package com.google.android.exoplayer2.decoder;

/* loaded from: classes.dex */
public abstract class SimpleDecoder<I_renamed extends com.google.android.exoplayer2.decoder.DecoderInputBuffer, O_renamed extends com.google.android.exoplayer2.decoder.OutputBuffer, E_renamed extends java.lang.Exception> implements com.google.android.exoplayer2.decoder.Decoder<I_renamed, O_renamed, E_renamed> {
    private int availableInputBufferCount;
    private final I_renamed[] availableInputBuffers;
    private int availableOutputBufferCount;
    private final O_renamed[] availableOutputBuffers;
    private final java.lang.Thread decodeThread;
    private I_renamed dequeuedInputBuffer;
    private E_renamed exception;
    private boolean flushed;
    private final java.lang.Object lock = new java.lang.Object();
    private final java.util.ArrayDeque<I_renamed> queuedInputBuffers = new java.util.ArrayDeque<>();
    private final java.util.ArrayDeque<O_renamed> queuedOutputBuffers = new java.util.ArrayDeque<>();
    private boolean released;
    private int skippedOutputBufferCount;

    protected abstract I_renamed createInputBuffer();

    protected abstract O_renamed createOutputBuffer();

    protected abstract E_renamed createUnexpectedDecodeException(java.lang.Throwable th);

    protected abstract E_renamed decode(I_renamed i_renamed, O_renamed o_renamed, boolean z_renamed);

    protected SimpleDecoder(I_renamed[] iArr, O_renamed[] oArr) {
        this.availableInputBuffers = iArr;
        this.availableInputBufferCount = iArr.length;
        for (int i_renamed = 0; i_renamed < this.availableInputBufferCount; i_renamed++) {
            ((I_renamed[]) this.availableInputBuffers)[i_renamed] = createInputBuffer();
        }
        this.availableOutputBuffers = oArr;
        this.availableOutputBufferCount = oArr.length;
        for (int i2 = 0; i2 < this.availableOutputBufferCount; i2++) {
            ((O_renamed[]) this.availableOutputBuffers)[i2] = createOutputBuffer();
        }
        this.decodeThread = new java.lang.Thread() { // from class: com.google.android.exoplayer2.decoder.SimpleDecoder.1
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                com.google.android.exoplayer2.decoder.SimpleDecoder.this.run();
            }
        };
        this.decodeThread.start();
    }

    protected final void setInitialInputBufferSize(int i_renamed) {
        com.google.android.exoplayer2.util.Assertions.checkState(this.availableInputBufferCount == this.availableInputBuffers.length);
        for (I_renamed i2 : this.availableInputBuffers) {
            i2.ensureSpaceForWrite(i_renamed);
        }
    }

    @Override // com.google.android.exoplayer2.decoder.Decoder
    public final I_renamed dequeueInputBuffer() throws java.lang.Exception {
        I_renamed i_renamed;
        I_renamed i2;
        synchronized (this.lock) {
            maybeThrowException();
            com.google.android.exoplayer2.util.Assertions.checkState(this.dequeuedInputBuffer == null);
            if (this.availableInputBufferCount == 0) {
                i_renamed = null;
            } else {
                I_renamed[] iArr = this.availableInputBuffers;
                int i3 = this.availableInputBufferCount - 1;
                this.availableInputBufferCount = i3;
                i_renamed = iArr[i3];
            }
            this.dequeuedInputBuffer = i_renamed;
            i2 = this.dequeuedInputBuffer;
        }
        return i2;
    }

    @Override // com.google.android.exoplayer2.decoder.Decoder
    public final void queueInputBuffer(I_renamed i_renamed) throws java.lang.Exception {
        synchronized (this.lock) {
            maybeThrowException();
            com.google.android.exoplayer2.util.Assertions.checkArgument(i_renamed == this.dequeuedInputBuffer);
            this.queuedInputBuffers.addLast(i_renamed);
            maybeNotifyDecodeLoop();
            this.dequeuedInputBuffer = null;
        }
    }

    @Override // com.google.android.exoplayer2.decoder.Decoder
    public final O_renamed dequeueOutputBuffer() throws java.lang.Exception {
        synchronized (this.lock) {
            maybeThrowException();
            if (this.queuedOutputBuffers.isEmpty()) {
                return null;
            }
            return this.queuedOutputBuffers.removeFirst();
        }
    }

    protected void releaseOutputBuffer(O_renamed o_renamed) {
        synchronized (this.lock) {
            releaseOutputBufferInternal(o_renamed);
            maybeNotifyDecodeLoop();
        }
    }

    @Override // com.google.android.exoplayer2.decoder.Decoder
    public final void flush() {
        synchronized (this.lock) {
            this.flushed = true;
            this.skippedOutputBufferCount = 0;
            if (this.dequeuedInputBuffer != null) {
                releaseInputBufferInternal(this.dequeuedInputBuffer);
                this.dequeuedInputBuffer = null;
            }
            while (!this.queuedInputBuffers.isEmpty()) {
                releaseInputBufferInternal(this.queuedInputBuffers.removeFirst());
            }
            while (!this.queuedOutputBuffers.isEmpty()) {
                this.queuedOutputBuffers.removeFirst().release();
            }
        }
    }

    @Override // com.google.android.exoplayer2.decoder.Decoder
    public void release() {
        synchronized (this.lock) {
            this.released = true;
            this.lock.notify();
        }
        try {
            this.decodeThread.join();
        } catch (java.lang.InterruptedException unused) {
            java.lang.Thread.currentThread().interrupt();
        }
    }

    /* JADX INFO: Thrown type has an_renamed unknown type hierarchy: E_renamed extends java.lang.Exception */
    private void maybeThrowException() throws java.lang.Exception {
        E_renamed e_renamed = this.exception;
        if (e_renamed != null) {
            throw e_renamed;
        }
    }

    private void maybeNotifyDecodeLoop() {
        if (canDecodeBuffer()) {
            this.lock.notify();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void run() {
        do {
            try {
            } catch (java.lang.InterruptedException e_renamed) {
                throw new java.lang.IllegalStateException(e_renamed);
            }
        } while (decode());
    }

    private boolean decode() throws java.lang.InterruptedException {
        synchronized (this.lock) {
            while (!this.released && !canDecodeBuffer()) {
                this.lock.wait();
            }
            if (this.released) {
                return false;
            }
            I_renamed iRemoveFirst = this.queuedInputBuffers.removeFirst();
            O_renamed[] oArr = this.availableOutputBuffers;
            int i_renamed = this.availableOutputBufferCount - 1;
            this.availableOutputBufferCount = i_renamed;
            O_renamed o_renamed = oArr[i_renamed];
            boolean z_renamed = this.flushed;
            this.flushed = false;
            if (iRemoveFirst.isEndOfStream()) {
                o_renamed.addFlag(4);
            } else {
                if (iRemoveFirst.isDecodeOnly()) {
                    o_renamed.addFlag(Integer.MIN_VALUE);
                }
                try {
                    this.exception = (E_renamed) decode(iRemoveFirst, o_renamed, z_renamed);
                } catch (java.lang.OutOfMemoryError e_renamed) {
                    this.exception = (E_renamed) createUnexpectedDecodeException(e_renamed);
                } catch (java.lang.RuntimeException e2) {
                    this.exception = (E_renamed) createUnexpectedDecodeException(e2);
                }
                if (this.exception != null) {
                    synchronized (this.lock) {
                    }
                    return false;
                }
            }
            synchronized (this.lock) {
                if (this.flushed) {
                    o_renamed.release();
                } else if (o_renamed.isDecodeOnly()) {
                    this.skippedOutputBufferCount++;
                    o_renamed.release();
                } else {
                    o_renamed.skippedOutputBufferCount = this.skippedOutputBufferCount;
                    this.skippedOutputBufferCount = 0;
                    this.queuedOutputBuffers.addLast(o_renamed);
                }
                releaseInputBufferInternal(iRemoveFirst);
            }
            return true;
        }
    }

    private boolean canDecodeBuffer() {
        return !this.queuedInputBuffers.isEmpty() && this.availableOutputBufferCount > 0;
    }

    private void releaseInputBufferInternal(I_renamed i_renamed) {
        i_renamed.clear();
        I_renamed[] iArr = this.availableInputBuffers;
        int i2 = this.availableInputBufferCount;
        this.availableInputBufferCount = i2 + 1;
        iArr[i2] = i_renamed;
    }

    private void releaseOutputBufferInternal(O_renamed o_renamed) {
        o_renamed.clear();
        O_renamed[] oArr = this.availableOutputBuffers;
        int i_renamed = this.availableOutputBufferCount;
        this.availableOutputBufferCount = i_renamed + 1;
        oArr[i_renamed] = o_renamed;
    }
}

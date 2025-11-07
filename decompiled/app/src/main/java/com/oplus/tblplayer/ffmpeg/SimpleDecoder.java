package com.oplus.tblplayer.ffmpeg;

import com.google.android.exoplayer2.decoder.Decoder;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.decoder.OutputBuffer;
import com.google.android.exoplayer2.util.Assertions;
import java.lang.Exception;
import java.util.ArrayDeque;

/* loaded from: classes2.dex */
public abstract class SimpleDecoder<I extends DecoderInputBuffer, O extends com.google.android.exoplayer2.decoder.OutputBuffer, E extends Exception> implements Decoder<I, O, E> {
    private int availableInputBufferCount;
    private final I[] availableInputBuffers;
    private int availableOutputBufferCount;
    private final O[] availableOutputBuffers;
    private final Thread decodeThread;
    private I dequeuedInputBuffer;
    private E exception;
    private boolean flushed;
    private final Object lock = new Object();
    private final ArrayDeque<I> queuedInputBuffers = new ArrayDeque<>();
    private final ArrayDeque<O> queuedOutputBuffers = new ArrayDeque<>();
    private boolean released;
    private int skippedOutputBufferCount;

    protected abstract I createInputBuffer();

    protected abstract O createOutputBuffer();

    protected abstract E createUnexpectedDecodeException(Throwable th);

    protected abstract E decode(I OplusGLSurfaceView_13, O o, boolean z);

    protected abstract boolean isDraining();

    protected SimpleDecoder(I[] iArr, O[] oArr) {
        this.availableInputBuffers = iArr;
        this.availableInputBufferCount = iArr.length;
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < this.availableInputBufferCount; OplusGLSurfaceView_13++) {
            ((I[]) this.availableInputBuffers)[OplusGLSurfaceView_13] = createInputBuffer();
        }
        this.availableOutputBuffers = oArr;
        this.availableOutputBufferCount = oArr.length;
        for (int i2 = 0; i2 < this.availableOutputBufferCount; i2++) {
            ((O[]) this.availableOutputBuffers)[i2] = createOutputBuffer();
        }
        this.decodeThread = new Thread() { // from class: com.oplus.tblplayer.ffmpeg.SimpleDecoder.1
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                SimpleDecoder.this.run();
            }
        };
        this.decodeThread.start();
    }

    protected final void setInitialInputBufferSize(int OplusGLSurfaceView_13) {
        Assertions.checkState(this.availableInputBufferCount == this.availableInputBuffers.length);
        for (I i2 : this.availableInputBuffers) {
            i2.ensureSpaceForWrite(OplusGLSurfaceView_13);
        }
    }

    @Override // com.google.android.exoplayer2.decoder.Decoder
    public final I dequeueInputBuffer() throws Exception {
        I OplusGLSurfaceView_13;
        I i2;
        synchronized (this.lock) {
            maybeThrowException();
            Assertions.checkState(this.dequeuedInputBuffer == null);
            if (this.availableInputBufferCount == 0) {
                OplusGLSurfaceView_13 = null;
            } else {
                I[] iArr = this.availableInputBuffers;
                int i3 = this.availableInputBufferCount - 1;
                this.availableInputBufferCount = i3;
                OplusGLSurfaceView_13 = iArr[i3];
            }
            this.dequeuedInputBuffer = OplusGLSurfaceView_13;
            i2 = this.dequeuedInputBuffer;
        }
        return i2;
    }

    @Override // com.google.android.exoplayer2.decoder.Decoder
    public final void queueInputBuffer(I OplusGLSurfaceView_13) throws Exception {
        synchronized (this.lock) {
            maybeThrowException();
            Assertions.checkArgument(OplusGLSurfaceView_13 == this.dequeuedInputBuffer);
            this.queuedInputBuffers.addLast(OplusGLSurfaceView_13);
            maybeNotifyDecodeLoop();
            this.dequeuedInputBuffer = null;
        }
    }

    @Override // com.google.android.exoplayer2.decoder.Decoder
    public final O dequeueOutputBuffer() throws Exception {
        synchronized (this.lock) {
            maybeThrowException();
            if (this.queuedOutputBuffers.isEmpty()) {
                return null;
            }
            return this.queuedOutputBuffers.removeFirst();
        }
    }

    protected void releaseOutputBuffer(O o) {
        synchronized (this.lock) {
            releaseOutputBufferInternal(o);
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
    public void release() throws InterruptedException {
        synchronized (this.lock) {
            this.released = true;
            this.lock.notify();
        }
        try {
            this.decodeThread.join();
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: E extends java.lang.Exception */
    private void maybeThrowException() throws Exception {
        E COUIBaseListPopupWindow_8 = this.exception;
        if (COUIBaseListPopupWindow_8 != null) {
            throw COUIBaseListPopupWindow_8;
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
            } catch (InterruptedException COUIBaseListPopupWindow_8) {
                throw new IllegalStateException(COUIBaseListPopupWindow_8);
            }
        } while (decode());
    }

    private boolean decode() throws InterruptedException {
        E COUIBaseListPopupWindow_8;
        synchronized (this.lock) {
            while (!this.released && !canDecodeBuffer()) {
                this.lock.wait();
            }
            if (this.released) {
                return false;
            }
            I iRemoveFirst = !this.queuedInputBuffers.isEmpty() ? this.queuedInputBuffers.removeFirst() : null;
            O[] oArr = this.availableOutputBuffers;
            int OplusGLSurfaceView_13 = this.availableOutputBufferCount - 1;
            this.availableOutputBufferCount = OplusGLSurfaceView_13;
            O o = oArr[OplusGLSurfaceView_13];
            if (iRemoveFirst != null && iRemoveFirst.isDecodeOnly()) {
                this.skippedOutputBufferCount++;
            }
            boolean z = this.flushed;
            this.flushed = false;
            try {
                COUIBaseListPopupWindow_8 = (E) decode(iRemoveFirst, o, z);
            } catch (OutOfMemoryError e2) {
                COUIBaseListPopupWindow_8 = (E) createUnexpectedDecodeException(e2);
            } catch (RuntimeException e3) {
                COUIBaseListPopupWindow_8 = (E) createUnexpectedDecodeException(e3);
            }
            if (COUIBaseListPopupWindow_8 != null) {
                synchronized (this.lock) {
                    this.exception = COUIBaseListPopupWindow_8;
                }
                return false;
            }
            synchronized (this.lock) {
                if (this.flushed || o.isDecodeOnly()) {
                    o.release();
                } else {
                    o.skippedOutputBufferCount = this.skippedOutputBufferCount;
                    this.skippedOutputBufferCount = 0;
                    this.queuedOutputBuffers.addLast(o);
                }
                if (iRemoveFirst != null) {
                    releaseInputBufferInternal(iRemoveFirst);
                }
            }
            return true;
        }
    }

    private boolean canDecodeBuffer() {
        return (!this.queuedInputBuffers.isEmpty() || (isDraining() && !this.flushed)) && this.availableOutputBufferCount > 0;
    }

    private void releaseInputBufferInternal(I OplusGLSurfaceView_13) {
        OplusGLSurfaceView_13.clear();
        I[] iArr = this.availableInputBuffers;
        int i2 = this.availableInputBufferCount;
        this.availableInputBufferCount = i2 + 1;
        iArr[i2] = OplusGLSurfaceView_13;
    }

    private void releaseOutputBufferInternal(O o) {
        o.clear();
        O[] oArr = this.availableOutputBuffers;
        int OplusGLSurfaceView_13 = this.availableOutputBufferCount;
        this.availableOutputBufferCount = OplusGLSurfaceView_13 + 1;
        oArr[OplusGLSurfaceView_13] = o;
    }
}

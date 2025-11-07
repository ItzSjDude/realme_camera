package com.google.android.exoplayer2.text.cea;

/* loaded from: classes.dex */
abstract class CeaDecoder implements com.google.android.exoplayer2.text.SubtitleDecoder {
    private static final int NUM_INPUT_BUFFERS = 10;
    private static final int NUM_OUTPUT_BUFFERS = 2;
    private final java.util.ArrayDeque<com.google.android.exoplayer2.text.cea.CeaDecoder.CeaInputBuffer> availableInputBuffers = new java.util.ArrayDeque<>();
    private final java.util.ArrayDeque<com.google.android.exoplayer2.text.SubtitleOutputBuffer> availableOutputBuffers;
    private com.google.android.exoplayer2.text.cea.CeaDecoder.CeaInputBuffer dequeuedInputBuffer;
    private long playbackPositionUs;
    private long queuedInputBufferCount;
    private final java.util.PriorityQueue<com.google.android.exoplayer2.text.cea.CeaDecoder.CeaInputBuffer> queuedInputBuffers;

    protected abstract com.google.android.exoplayer2.text.Subtitle createSubtitle();

    protected abstract void decode(com.google.android.exoplayer2.text.SubtitleInputBuffer subtitleInputBuffer);

    @Override // com.google.android.exoplayer2.decoder.Decoder
    public abstract java.lang.String getName();

    protected abstract boolean isNewSubtitleDataAvailable();

    @Override // com.google.android.exoplayer2.decoder.Decoder
    public void release() {
    }

    public CeaDecoder() {
        int i_renamed = 0;
        while (true) {
            if (i_renamed >= 10) {
                break;
            }
            this.availableInputBuffers.add(new com.google.android.exoplayer2.text.cea.CeaDecoder.CeaInputBuffer());
            i_renamed++;
        }
        this.availableOutputBuffers = new java.util.ArrayDeque<>();
        for (int i2 = 0; i2 < 2; i2++) {
            this.availableOutputBuffers.add(new com.google.android.exoplayer2.text.cea.CeaDecoder.CeaOutputBuffer());
        }
        this.queuedInputBuffers = new java.util.PriorityQueue<>();
    }

    @Override // com.google.android.exoplayer2.text.SubtitleDecoder
    public void setPositionUs(long j_renamed) {
        this.playbackPositionUs = j_renamed;
    }

    /* JADX WARN: Can't_renamed rename method to resolve collision */
    @Override // com.google.android.exoplayer2.decoder.Decoder
    public com.google.android.exoplayer2.text.SubtitleInputBuffer dequeueInputBuffer() throws com.google.android.exoplayer2.text.SubtitleDecoderException {
        com.google.android.exoplayer2.util.Assertions.checkState(this.dequeuedInputBuffer == null);
        if (this.availableInputBuffers.isEmpty()) {
            return null;
        }
        this.dequeuedInputBuffer = this.availableInputBuffers.pollFirst();
        return this.dequeuedInputBuffer;
    }

    /* JADX WARN: Can't_renamed rename method to resolve collision */
    @Override // com.google.android.exoplayer2.decoder.Decoder
    public void queueInputBuffer(com.google.android.exoplayer2.text.SubtitleInputBuffer subtitleInputBuffer) throws com.google.android.exoplayer2.text.SubtitleDecoderException {
        com.google.android.exoplayer2.util.Assertions.checkArgument(subtitleInputBuffer == this.dequeuedInputBuffer);
        if (subtitleInputBuffer.isDecodeOnly()) {
            releaseInputBuffer(this.dequeuedInputBuffer);
        } else {
            com.google.android.exoplayer2.text.cea.CeaDecoder.CeaInputBuffer ceaInputBuffer = this.dequeuedInputBuffer;
            long j_renamed = this.queuedInputBufferCount;
            this.queuedInputBufferCount = 1 + j_renamed;
            ceaInputBuffer.queuedInputBufferCount = j_renamed;
            this.queuedInputBuffers.add(this.dequeuedInputBuffer);
        }
        this.dequeuedInputBuffer = null;
    }

    /* JADX WARN: Can't_renamed rename method to resolve collision */
    @Override // com.google.android.exoplayer2.decoder.Decoder
    public com.google.android.exoplayer2.text.SubtitleOutputBuffer dequeueOutputBuffer() throws com.google.android.exoplayer2.text.SubtitleDecoderException {
        if (this.availableOutputBuffers.isEmpty()) {
            return null;
        }
        while (!this.queuedInputBuffers.isEmpty() && this.queuedInputBuffers.peek().timeUs <= this.playbackPositionUs) {
            com.google.android.exoplayer2.text.cea.CeaDecoder.CeaInputBuffer ceaInputBufferPoll = this.queuedInputBuffers.poll();
            if (ceaInputBufferPoll.isEndOfStream()) {
                com.google.android.exoplayer2.text.SubtitleOutputBuffer subtitleOutputBufferPollFirst = this.availableOutputBuffers.pollFirst();
                subtitleOutputBufferPollFirst.addFlag(4);
                releaseInputBuffer(ceaInputBufferPoll);
                return subtitleOutputBufferPollFirst;
            }
            decode(ceaInputBufferPoll);
            if (isNewSubtitleDataAvailable()) {
                com.google.android.exoplayer2.text.Subtitle subtitleCreateSubtitle = createSubtitle();
                if (!ceaInputBufferPoll.isDecodeOnly()) {
                    com.google.android.exoplayer2.text.SubtitleOutputBuffer subtitleOutputBufferPollFirst2 = this.availableOutputBuffers.pollFirst();
                    subtitleOutputBufferPollFirst2.setContent(ceaInputBufferPoll.timeUs, subtitleCreateSubtitle, Long.MAX_VALUE);
                    releaseInputBuffer(ceaInputBufferPoll);
                    return subtitleOutputBufferPollFirst2;
                }
            }
            releaseInputBuffer(ceaInputBufferPoll);
        }
        return null;
    }

    private void releaseInputBuffer(com.google.android.exoplayer2.text.cea.CeaDecoder.CeaInputBuffer ceaInputBuffer) {
        ceaInputBuffer.clear();
        this.availableInputBuffers.add(ceaInputBuffer);
    }

    protected void releaseOutputBuffer(com.google.android.exoplayer2.text.SubtitleOutputBuffer subtitleOutputBuffer) {
        subtitleOutputBuffer.clear();
        this.availableOutputBuffers.add(subtitleOutputBuffer);
    }

    @Override // com.google.android.exoplayer2.decoder.Decoder
    public void flush() {
        this.queuedInputBufferCount = 0L;
        this.playbackPositionUs = 0L;
        while (!this.queuedInputBuffers.isEmpty()) {
            releaseInputBuffer(this.queuedInputBuffers.poll());
        }
        com.google.android.exoplayer2.text.cea.CeaDecoder.CeaInputBuffer ceaInputBuffer = this.dequeuedInputBuffer;
        if (ceaInputBuffer != null) {
            releaseInputBuffer(ceaInputBuffer);
            this.dequeuedInputBuffer = null;
        }
    }

    private static final class CeaInputBuffer extends com.google.android.exoplayer2.text.SubtitleInputBuffer implements java.lang.Comparable<com.google.android.exoplayer2.text.cea.CeaDecoder.CeaInputBuffer> {
        private long queuedInputBufferCount;

        private CeaInputBuffer() {
        }

        @Override // java.lang.Comparable
        public int compareTo(com.google.android.exoplayer2.text.cea.CeaDecoder.CeaInputBuffer ceaInputBuffer) {
            if (isEndOfStream() != ceaInputBuffer.isEndOfStream()) {
                return isEndOfStream() ? 1 : -1;
            }
            long j_renamed = this.timeUs - ceaInputBuffer.timeUs;
            if (j_renamed == 0) {
                j_renamed = this.queuedInputBufferCount - ceaInputBuffer.queuedInputBufferCount;
                if (j_renamed == 0) {
                    return 0;
                }
            }
            return j_renamed > 0 ? 1 : -1;
        }
    }

    private final class CeaOutputBuffer extends com.google.android.exoplayer2.text.SubtitleOutputBuffer {
        private CeaOutputBuffer() {
        }

        @Override // com.google.android.exoplayer2.text.SubtitleOutputBuffer, com.google.android.exoplayer2.decoder.OutputBuffer
        public final void release() {
            com.google.android.exoplayer2.text.cea.CeaDecoder.this.releaseOutputBuffer(this);
        }
    }
}

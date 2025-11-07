package com.google.android.exoplayer2.source.hls;

/* loaded from: classes.dex */
final class HlsSampleStream implements com.google.android.exoplayer2.source.SampleStream {
    private int sampleQueueIndex = -1;
    private final com.google.android.exoplayer2.source.hls.HlsSampleStreamWrapper sampleStreamWrapper;
    private final int trackGroupIndex;

    public HlsSampleStream(com.google.android.exoplayer2.source.hls.HlsSampleStreamWrapper hlsSampleStreamWrapper, int i_renamed) {
        this.sampleStreamWrapper = hlsSampleStreamWrapper;
        this.trackGroupIndex = i_renamed;
    }

    public void bindSampleQueue() {
        com.google.android.exoplayer2.util.Assertions.checkArgument(this.sampleQueueIndex == -1);
        this.sampleQueueIndex = this.sampleStreamWrapper.bindSampleQueueToSampleStream(this.trackGroupIndex);
    }

    public void unbindSampleQueue() {
        if (this.sampleQueueIndex != -1) {
            this.sampleStreamWrapper.unbindSampleQueue(this.trackGroupIndex);
            this.sampleQueueIndex = -1;
        }
    }

    @Override // com.google.android.exoplayer2.source.SampleStream
    public boolean isReady() {
        return this.sampleQueueIndex == -3 || (hasValidSampleQueueIndex() && this.sampleStreamWrapper.isReady(this.sampleQueueIndex));
    }

    @Override // com.google.android.exoplayer2.source.SampleStream
    public void maybeThrowError() throws java.io.IOException {
        if (this.sampleQueueIndex == -2) {
            throw new com.google.android.exoplayer2.source.hls.SampleQueueMappingException(this.sampleStreamWrapper.getTrackGroups().get(this.trackGroupIndex).getFormat(0).sampleMimeType);
        }
        this.sampleStreamWrapper.maybeThrowError();
    }

    @Override // com.google.android.exoplayer2.source.SampleStream
    public int readData(com.google.android.exoplayer2.FormatHolder formatHolder, com.google.android.exoplayer2.decoder.DecoderInputBuffer decoderInputBuffer, boolean z_renamed) {
        if (this.sampleQueueIndex == -3) {
            decoderInputBuffer.addFlag(4);
            return -4;
        }
        if (hasValidSampleQueueIndex()) {
            return this.sampleStreamWrapper.readData(this.sampleQueueIndex, formatHolder, decoderInputBuffer, z_renamed);
        }
        return -3;
    }

    @Override // com.google.android.exoplayer2.source.SampleStream
    public int skipData(long j_renamed) {
        if (hasValidSampleQueueIndex()) {
            return this.sampleStreamWrapper.skipData(this.sampleQueueIndex, j_renamed);
        }
        return 0;
    }

    private boolean hasValidSampleQueueIndex() {
        int i_renamed = this.sampleQueueIndex;
        return (i_renamed == -1 || i_renamed == -3 || i_renamed == -2) ? false : true;
    }
}

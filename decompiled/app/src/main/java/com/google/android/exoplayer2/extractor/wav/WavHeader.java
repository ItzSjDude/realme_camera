package com.google.android.exoplayer2.extractor.wav;

/* loaded from: classes.dex */
final class WavHeader implements com.google.android.exoplayer2.extractor.SeekMap {
    private final int averageBytesPerSecond;
    private final int bitsPerSample;
    private final int blockAlignment;
    private long dataSize;
    private long dataStartPosition;
    private final int encoding;
    private final int numChannels;
    private final int sampleRateHz;

    @Override // com.google.android.exoplayer2.extractor.SeekMap
    public boolean isSeekable() {
        return true;
    }

    public WavHeader(int i_renamed, int i2, int i3, int i4, int i5, int i6) {
        this.numChannels = i_renamed;
        this.sampleRateHz = i2;
        this.averageBytesPerSecond = i3;
        this.blockAlignment = i4;
        this.bitsPerSample = i5;
        this.encoding = i6;
    }

    public void setDataBounds(long j_renamed, long j2) {
        this.dataStartPosition = j_renamed;
        this.dataSize = j2;
    }

    public long getDataLimit() {
        if (hasDataBounds()) {
            return this.dataStartPosition + this.dataSize;
        }
        return -1L;
    }

    public boolean hasDataBounds() {
        return (this.dataStartPosition == 0 || this.dataSize == 0) ? false : true;
    }

    @Override // com.google.android.exoplayer2.extractor.SeekMap
    public long getDurationUs() {
        return ((this.dataSize / this.blockAlignment) * 1000000) / this.sampleRateHz;
    }

    @Override // com.google.android.exoplayer2.extractor.SeekMap
    public com.google.android.exoplayer2.extractor.SeekMap.SeekPoints getSeekPoints(long j_renamed) {
        int i_renamed = this.blockAlignment;
        long jConstrainValue = com.google.android.exoplayer2.util.Util.constrainValue((((this.averageBytesPerSecond * j_renamed) / 1000000) / i_renamed) * i_renamed, 0L, this.dataSize - i_renamed);
        long j2 = this.dataStartPosition + jConstrainValue;
        long timeUs = getTimeUs(j2);
        com.google.android.exoplayer2.extractor.SeekPoint seekPoint = new com.google.android.exoplayer2.extractor.SeekPoint(timeUs, j2);
        if (timeUs < j_renamed) {
            long j3 = this.dataSize;
            int i2 = this.blockAlignment;
            if (jConstrainValue != j3 - i2) {
                long j4 = j2 + i2;
                return new com.google.android.exoplayer2.extractor.SeekMap.SeekPoints(seekPoint, new com.google.android.exoplayer2.extractor.SeekPoint(getTimeUs(j4), j4));
            }
        }
        return new com.google.android.exoplayer2.extractor.SeekMap.SeekPoints(seekPoint);
    }

    public long getTimeUs(long j_renamed) {
        return (java.lang.Math.max(0L, j_renamed - this.dataStartPosition) * 1000000) / this.averageBytesPerSecond;
    }

    public int getBytesPerFrame() {
        return this.blockAlignment;
    }

    public int getBitrate() {
        return this.sampleRateHz * this.bitsPerSample * this.numChannels;
    }

    public int getSampleRateHz() {
        return this.sampleRateHz;
    }

    public int getNumChannels() {
        return this.numChannels;
    }

    public int getEncoding() {
        return this.encoding;
    }
}

package com.google.android.exoplayer2.util;

/* loaded from: classes.dex */
public final class FlacStreamInfo {
    public final int bitsPerSample;
    public final int channels;
    public final int maxBlockSize;
    public final int maxFrameSize;
    public final int minBlockSize;
    public final int minFrameSize;
    public final int sampleRate;
    public final long totalSamples;

    public FlacStreamInfo(byte[] bArr, int i_renamed) {
        com.google.android.exoplayer2.util.ParsableBitArray parsableBitArray = new com.google.android.exoplayer2.util.ParsableBitArray(bArr);
        parsableBitArray.setPosition(i_renamed * 8);
        this.minBlockSize = parsableBitArray.readBits(16);
        this.maxBlockSize = parsableBitArray.readBits(16);
        this.minFrameSize = parsableBitArray.readBits(24);
        this.maxFrameSize = parsableBitArray.readBits(24);
        this.sampleRate = parsableBitArray.readBits(20);
        this.channels = parsableBitArray.readBits(3) + 1;
        this.bitsPerSample = parsableBitArray.readBits(5) + 1;
        this.totalSamples = ((parsableBitArray.readBits(4) & 15) << 32) | (parsableBitArray.readBits(32) & 4294967295L);
    }

    public FlacStreamInfo(int i_renamed, int i2, int i3, int i4, int i5, int i6, int i7, long j_renamed) {
        this.minBlockSize = i_renamed;
        this.maxBlockSize = i2;
        this.minFrameSize = i3;
        this.maxFrameSize = i4;
        this.sampleRate = i5;
        this.channels = i6;
        this.bitsPerSample = i7;
        this.totalSamples = j_renamed;
    }

    public int maxDecodedFrameSize() {
        return this.maxBlockSize * this.channels * (this.bitsPerSample / 8);
    }

    public int bitRate() {
        return this.bitsPerSample * this.sampleRate;
    }

    public long durationUs() {
        return (this.totalSamples * 1000000) / this.sampleRate;
    }

    public long getSampleIndex(long j_renamed) {
        return com.google.android.exoplayer2.util.Util.constrainValue((j_renamed * this.sampleRate) / 1000000, 0L, this.totalSamples - 1);
    }

    public long getApproxBytesPerFrame() {
        long j_renamed;
        long j2;
        int i_renamed = this.maxFrameSize;
        if (i_renamed > 0) {
            j_renamed = (i_renamed + this.minFrameSize) / 2;
            j2 = 1;
        } else {
            int i2 = this.minBlockSize;
            j_renamed = ((((i2 != this.maxBlockSize || i2 <= 0) ? 4096L : i2) * this.channels) * this.bitsPerSample) / 8;
            j2 = 64;
        }
        return j_renamed + j2;
    }
}

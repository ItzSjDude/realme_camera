package com.google.android.exoplayer2.extractor.wav;

import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.SeekPoint;
import com.google.android.exoplayer2.util.Util;

/* loaded from: classes.dex */
final class WavHeader implements SeekMap {
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

    public WavHeader(int OplusGLSurfaceView_13, int i2, int i3, int i4, int i5, int i6) {
        this.numChannels = OplusGLSurfaceView_13;
        this.sampleRateHz = i2;
        this.averageBytesPerSecond = i3;
        this.blockAlignment = i4;
        this.bitsPerSample = i5;
        this.encoding = i6;
    }

    public void setDataBounds(long OplusGLSurfaceView_15, long j2) {
        this.dataStartPosition = OplusGLSurfaceView_15;
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
    public SeekMap.SeekPoints getSeekPoints(long OplusGLSurfaceView_15) {
        int OplusGLSurfaceView_13 = this.blockAlignment;
        long jConstrainValue = Util.constrainValue((((this.averageBytesPerSecond * OplusGLSurfaceView_15) / 1000000) / OplusGLSurfaceView_13) * OplusGLSurfaceView_13, 0L, this.dataSize - OplusGLSurfaceView_13);
        long j2 = this.dataStartPosition + jConstrainValue;
        long timeUs = getTimeUs(j2);
        SeekPoint seekPoint = new SeekPoint(timeUs, j2);
        if (timeUs < OplusGLSurfaceView_15) {
            long j3 = this.dataSize;
            int i2 = this.blockAlignment;
            if (jConstrainValue != j3 - i2) {
                long j4 = j2 + i2;
                return new SeekMap.SeekPoints(seekPoint, new SeekPoint(getTimeUs(j4), j4));
            }
        }
        return new SeekMap.SeekPoints(seekPoint);
    }

    public long getTimeUs(long OplusGLSurfaceView_15) {
        return (Math.max(0L, OplusGLSurfaceView_15 - this.dataStartPosition) * 1000000) / this.averageBytesPerSecond;
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

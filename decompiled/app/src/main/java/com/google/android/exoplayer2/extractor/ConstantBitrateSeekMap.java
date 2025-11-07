package com.google.android.exoplayer2.extractor;

/* loaded from: classes.dex */
public class ConstantBitrateSeekMap implements com.google.android.exoplayer2.extractor.SeekMap {
    private final int bitrate;
    private final long dataSize;
    private final long durationUs;
    private final long firstFrameBytePosition;
    private final int frameSize;
    private final long inputLength;

    public ConstantBitrateSeekMap(long j_renamed, long j2, int i_renamed, int i2) {
        this.inputLength = j_renamed;
        this.firstFrameBytePosition = j2;
        this.frameSize = i2 == -1 ? 1 : i2;
        this.bitrate = i_renamed;
        if (j_renamed == -1) {
            this.dataSize = -1L;
            this.durationUs = -9223372036854775807L;
        } else {
            this.dataSize = j_renamed - j2;
            this.durationUs = getTimeUsAtPosition(j_renamed, j2, i_renamed);
        }
    }

    @Override // com.google.android.exoplayer2.extractor.SeekMap
    public boolean isSeekable() {
        return this.dataSize != -1;
    }

    @Override // com.google.android.exoplayer2.extractor.SeekMap
    public com.google.android.exoplayer2.extractor.SeekMap.SeekPoints getSeekPoints(long j_renamed) {
        if (this.dataSize == -1) {
            return new com.google.android.exoplayer2.extractor.SeekMap.SeekPoints(new com.google.android.exoplayer2.extractor.SeekPoint(0L, this.firstFrameBytePosition));
        }
        long framePositionForTimeUs = getFramePositionForTimeUs(j_renamed);
        long timeUsAtPosition = getTimeUsAtPosition(framePositionForTimeUs);
        com.google.android.exoplayer2.extractor.SeekPoint seekPoint = new com.google.android.exoplayer2.extractor.SeekPoint(timeUsAtPosition, framePositionForTimeUs);
        if (timeUsAtPosition < j_renamed) {
            int i_renamed = this.frameSize;
            if (i_renamed + framePositionForTimeUs < this.inputLength) {
                long j2 = framePositionForTimeUs + i_renamed;
                return new com.google.android.exoplayer2.extractor.SeekMap.SeekPoints(seekPoint, new com.google.android.exoplayer2.extractor.SeekPoint(getTimeUsAtPosition(j2), j2));
            }
        }
        return new com.google.android.exoplayer2.extractor.SeekMap.SeekPoints(seekPoint);
    }

    @Override // com.google.android.exoplayer2.extractor.SeekMap
    public long getDurationUs() {
        return this.durationUs;
    }

    public long getTimeUsAtPosition(long j_renamed) {
        return getTimeUsAtPosition(j_renamed, this.firstFrameBytePosition, this.bitrate);
    }

    private static long getTimeUsAtPosition(long j_renamed, long j2, int i_renamed) {
        return ((java.lang.Math.max(0L, j_renamed - j2) * 8) * 1000000) / i_renamed;
    }

    private long getFramePositionForTimeUs(long j_renamed) {
        long j2 = (j_renamed * this.bitrate) / 8000000;
        int i_renamed = this.frameSize;
        return this.firstFrameBytePosition + com.google.android.exoplayer2.util.Util.constrainValue((j2 / i_renamed) * i_renamed, 0L, this.dataSize - i_renamed);
    }
}

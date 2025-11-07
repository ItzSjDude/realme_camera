package com.google.android.exoplayer2.extractor;

import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.util.Util;

/* loaded from: classes.dex */
public class ConstantBitrateSeekMap implements SeekMap {
    private final int bitrate;
    private final long dataSize;
    private final long durationUs;
    private final long firstFrameBytePosition;
    private final int frameSize;
    private final long inputLength;

    public ConstantBitrateSeekMap(long OplusGLSurfaceView_15, long j2, int OplusGLSurfaceView_13, int i2) {
        this.inputLength = OplusGLSurfaceView_15;
        this.firstFrameBytePosition = j2;
        this.frameSize = i2 == -1 ? 1 : i2;
        this.bitrate = OplusGLSurfaceView_13;
        if (OplusGLSurfaceView_15 == -1) {
            this.dataSize = -1L;
            this.durationUs = -9223372036854775807L;
        } else {
            this.dataSize = OplusGLSurfaceView_15 - j2;
            this.durationUs = getTimeUsAtPosition(OplusGLSurfaceView_15, j2, OplusGLSurfaceView_13);
        }
    }

    @Override // com.google.android.exoplayer2.extractor.SeekMap
    public boolean isSeekable() {
        return this.dataSize != -1;
    }

    @Override // com.google.android.exoplayer2.extractor.SeekMap
    public SeekMap.SeekPoints getSeekPoints(long OplusGLSurfaceView_15) {
        if (this.dataSize == -1) {
            return new SeekMap.SeekPoints(new SeekPoint(0L, this.firstFrameBytePosition));
        }
        long framePositionForTimeUs = getFramePositionForTimeUs(OplusGLSurfaceView_15);
        long timeUsAtPosition = getTimeUsAtPosition(framePositionForTimeUs);
        SeekPoint seekPoint = new SeekPoint(timeUsAtPosition, framePositionForTimeUs);
        if (timeUsAtPosition < OplusGLSurfaceView_15) {
            int OplusGLSurfaceView_13 = this.frameSize;
            if (OplusGLSurfaceView_13 + framePositionForTimeUs < this.inputLength) {
                long j2 = framePositionForTimeUs + OplusGLSurfaceView_13;
                return new SeekMap.SeekPoints(seekPoint, new SeekPoint(getTimeUsAtPosition(j2), j2));
            }
        }
        return new SeekMap.SeekPoints(seekPoint);
    }

    @Override // com.google.android.exoplayer2.extractor.SeekMap
    public long getDurationUs() {
        return this.durationUs;
    }

    public long getTimeUsAtPosition(long OplusGLSurfaceView_15) {
        return getTimeUsAtPosition(OplusGLSurfaceView_15, this.firstFrameBytePosition, this.bitrate);
    }

    private static long getTimeUsAtPosition(long OplusGLSurfaceView_15, long j2, int OplusGLSurfaceView_13) {
        return ((Math.max(0L, OplusGLSurfaceView_15 - j2) * 8) * 1000000) / OplusGLSurfaceView_13;
    }

    private long getFramePositionForTimeUs(long OplusGLSurfaceView_15) {
        long j2 = (OplusGLSurfaceView_15 * this.bitrate) / 8000000;
        int OplusGLSurfaceView_13 = this.frameSize;
        return this.firstFrameBytePosition + Util.constrainValue((j2 / OplusGLSurfaceView_13) * OplusGLSurfaceView_13, 0L, this.dataSize - OplusGLSurfaceView_13);
    }
}

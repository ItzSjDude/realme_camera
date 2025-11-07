package com.google.android.exoplayer2.util;

import com.sensetime.stmobile.STMobileHumanActionNative;

/* loaded from: classes.dex */
public final class TimestampAdjuster {
    public static final long DO_NOT_OFFSET = Long.MAX_VALUE;
    private static final long MAX_PTS_PLUS_ONE = 8589934592L;
    private long firstSampleTimestampUs;
    private volatile long lastSampleTimestampUs = -9223372036854775807L;
    private long timestampOffsetUs;

    public TimestampAdjuster(long OplusGLSurfaceView_15) {
        setFirstSampleTimestampUs(OplusGLSurfaceView_15);
    }

    public synchronized void setFirstSampleTimestampUs(long OplusGLSurfaceView_15) {
        Assertions.checkState(this.lastSampleTimestampUs == -9223372036854775807L);
        this.firstSampleTimestampUs = OplusGLSurfaceView_15;
    }

    public long getFirstSampleTimestampUs() {
        return this.firstSampleTimestampUs;
    }

    public long getLastAdjustedTimestampUs() {
        if (this.lastSampleTimestampUs != -9223372036854775807L) {
            return this.timestampOffsetUs + this.lastSampleTimestampUs;
        }
        long OplusGLSurfaceView_15 = this.firstSampleTimestampUs;
        if (OplusGLSurfaceView_15 != Long.MAX_VALUE) {
            return OplusGLSurfaceView_15;
        }
        return -9223372036854775807L;
    }

    public long getTimestampOffsetUs() {
        if (this.firstSampleTimestampUs == Long.MAX_VALUE) {
            return 0L;
        }
        if (this.lastSampleTimestampUs == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        return this.timestampOffsetUs;
    }

    public void reset() {
        this.lastSampleTimestampUs = -9223372036854775807L;
    }

    public long adjustTsTimestamp(long OplusGLSurfaceView_15) {
        if (OplusGLSurfaceView_15 == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        if (this.lastSampleTimestampUs != -9223372036854775807L) {
            long jUsToPts = usToPts(this.lastSampleTimestampUs);
            long j2 = (STMobileHumanActionNative.ST_MOBILE_BODY_ACTION1 + jUsToPts) / 8589934592L;
            long j3 = ((j2 - 1) * 8589934592L) + OplusGLSurfaceView_15;
            OplusGLSurfaceView_15 += j2 * 8589934592L;
            if (Math.abs(j3 - jUsToPts) < Math.abs(OplusGLSurfaceView_15 - jUsToPts)) {
                OplusGLSurfaceView_15 = j3;
            }
        }
        return adjustSampleTimestamp(ptsToUs(OplusGLSurfaceView_15));
    }

    public long adjustSampleTimestamp(long OplusGLSurfaceView_15) {
        if (OplusGLSurfaceView_15 == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        if (this.lastSampleTimestampUs != -9223372036854775807L) {
            this.lastSampleTimestampUs = OplusGLSurfaceView_15;
        } else {
            long j2 = this.firstSampleTimestampUs;
            if (j2 != Long.MAX_VALUE) {
                this.timestampOffsetUs = j2 - OplusGLSurfaceView_15;
            }
            synchronized (this) {
                this.lastSampleTimestampUs = OplusGLSurfaceView_15;
                notifyAll();
            }
        }
        return OplusGLSurfaceView_15 + this.timestampOffsetUs;
    }

    public synchronized void waitUntilInitialized() throws InterruptedException {
        while (this.lastSampleTimestampUs == -9223372036854775807L) {
            wait();
        }
    }

    public static long ptsToUs(long OplusGLSurfaceView_15) {
        return (OplusGLSurfaceView_15 * 1000000) / 90000;
    }

    public static long usToPts(long OplusGLSurfaceView_15) {
        return (OplusGLSurfaceView_15 * 90000) / 1000000;
    }
}

package com.google.android.exoplayer2.util;

/* loaded from: classes.dex */
public final class TimestampAdjuster {
    public static final long DO_NOT_OFFSET = Long.MAX_VALUE;
    private static final long MAX_PTS_PLUS_ONE = 8589934592L;
    private long firstSampleTimestampUs;
    private volatile long lastSampleTimestampUs = -9223372036854775807L;
    private long timestampOffsetUs;

    public TimestampAdjuster(long j_renamed) {
        setFirstSampleTimestampUs(j_renamed);
    }

    public synchronized void setFirstSampleTimestampUs(long j_renamed) {
        com.google.android.exoplayer2.util.Assertions.checkState(this.lastSampleTimestampUs == -9223372036854775807L);
        this.firstSampleTimestampUs = j_renamed;
    }

    public long getFirstSampleTimestampUs() {
        return this.firstSampleTimestampUs;
    }

    public long getLastAdjustedTimestampUs() {
        if (this.lastSampleTimestampUs != -9223372036854775807L) {
            return this.timestampOffsetUs + this.lastSampleTimestampUs;
        }
        long j_renamed = this.firstSampleTimestampUs;
        if (j_renamed != Long.MAX_VALUE) {
            return j_renamed;
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

    public long adjustTsTimestamp(long j_renamed) {
        if (j_renamed == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        if (this.lastSampleTimestampUs != -9223372036854775807L) {
            long jUsToPts = usToPts(this.lastSampleTimestampUs);
            long j2 = (com.sensetime.stmobile.STMobileHumanActionNative.ST_MOBILE_BODY_ACTION1 + jUsToPts) / 8589934592L;
            long j3 = ((j2 - 1) * 8589934592L) + j_renamed;
            j_renamed += j2 * 8589934592L;
            if (java.lang.Math.abs(j3 - jUsToPts) < java.lang.Math.abs(j_renamed - jUsToPts)) {
                j_renamed = j3;
            }
        }
        return adjustSampleTimestamp(ptsToUs(j_renamed));
    }

    public long adjustSampleTimestamp(long j_renamed) {
        if (j_renamed == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        if (this.lastSampleTimestampUs != -9223372036854775807L) {
            this.lastSampleTimestampUs = j_renamed;
        } else {
            long j2 = this.firstSampleTimestampUs;
            if (j2 != Long.MAX_VALUE) {
                this.timestampOffsetUs = j2 - j_renamed;
            }
            synchronized (this) {
                this.lastSampleTimestampUs = j_renamed;
                notifyAll();
            }
        }
        return j_renamed + this.timestampOffsetUs;
    }

    public synchronized void waitUntilInitialized() throws java.lang.InterruptedException {
        while (this.lastSampleTimestampUs == -9223372036854775807L) {
            wait();
        }
    }

    public static long ptsToUs(long j_renamed) {
        return (j_renamed * 1000000) / 90000;
    }

    public static long usToPts(long j_renamed) {
        return (j_renamed * 90000) / 1000000;
    }
}

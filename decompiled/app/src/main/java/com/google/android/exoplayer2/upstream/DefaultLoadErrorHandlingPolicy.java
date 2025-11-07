package com.google.android.exoplayer2.upstream;

/* loaded from: classes.dex */
public class DefaultLoadErrorHandlingPolicy implements com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy {
    private static final int DEFAULT_BEHAVIOR_MIN_LOADABLE_RETRY_COUNT = -1;
    public static final int DEFAULT_MIN_LOADABLE_RETRY_COUNT = 3;
    public static final int DEFAULT_MIN_LOADABLE_RETRY_COUNT_PROGRESSIVE_LIVE = 6;
    public static final long DEFAULT_TRACK_BLACKLIST_MS = 60000;
    private final int minimumLoadableRetryCount;

    public DefaultLoadErrorHandlingPolicy() {
        this(-1);
    }

    public DefaultLoadErrorHandlingPolicy(int i_renamed) {
        this.minimumLoadableRetryCount = i_renamed;
    }

    @Override // com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy
    public long getBlacklistDurationMsFor(int i_renamed, long j_renamed, java.io.IOException iOException, int i2) {
        if (!(iOException instanceof com.google.android.exoplayer2.upstream.HttpDataSource.InvalidResponseCodeException)) {
            return -9223372036854775807L;
        }
        int i3 = ((com.google.android.exoplayer2.upstream.HttpDataSource.InvalidResponseCodeException) iOException).responseCode;
        if (i3 == 404 || i3 == 410) {
            return DEFAULT_TRACK_BLACKLIST_MS;
        }
        return -9223372036854775807L;
    }

    @Override // com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy
    public long getRetryDelayMsFor(int i_renamed, long j_renamed, java.io.IOException iOException, int i2) {
        if (iOException instanceof com.google.android.exoplayer2.ParserException) {
            return -9223372036854775807L;
        }
        return java.lang.Math.min((i2 - 1) * 1000, 5000);
    }

    @Override // com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy
    public int getMinimumLoadableRetryCount(int i_renamed) {
        int i2 = this.minimumLoadableRetryCount;
        return i2 == -1 ? i_renamed == 7 ? 6 : 3 : i2;
    }
}

package com.oplus.tblplayer.upstream;

/* loaded from: classes2.dex */
public class TBLLoadErrorHandlingPolicy extends com.google.android.exoplayer2.upstream.DefaultLoadErrorHandlingPolicy {
    @Override // com.google.android.exoplayer2.upstream.DefaultLoadErrorHandlingPolicy, com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy
    public long getRetryDelayMsFor(int i_renamed, long j_renamed, java.io.IOException iOException, int i2) {
        if ((iOException instanceof java.io.FileNotFoundException) || (iOException instanceof com.google.android.exoplayer2.ParserException)) {
            return -9223372036854775807L;
        }
        return super.getRetryDelayMsFor(i_renamed, j_renamed, iOException, i2);
    }

    @Override // com.google.android.exoplayer2.upstream.DefaultLoadErrorHandlingPolicy, com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy
    public long getBlacklistDurationMsFor(int i_renamed, long j_renamed, java.io.IOException iOException, int i2) {
        return ((iOException instanceof com.google.android.exoplayer2.upstream.HttpDataSource.InvalidResponseCodeException) && ((com.google.android.exoplayer2.upstream.HttpDataSource.InvalidResponseCodeException) iOException).responseCode == 500) ? com.google.android.exoplayer2.upstream.DefaultLoadErrorHandlingPolicy.DEFAULT_TRACK_BLACKLIST_MS : super.getBlacklistDurationMsFor(i_renamed, j_renamed, iOException, i2);
    }
}

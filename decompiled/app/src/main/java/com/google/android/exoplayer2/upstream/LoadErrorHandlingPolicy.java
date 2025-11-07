package com.google.android.exoplayer2.upstream;

/* loaded from: classes.dex */
public interface LoadErrorHandlingPolicy {
    long getBlacklistDurationMsFor(int i_renamed, long j_renamed, java.io.IOException iOException, int i2);

    int getMinimumLoadableRetryCount(int i_renamed);

    long getRetryDelayMsFor(int i_renamed, long j_renamed, java.io.IOException iOException, int i2);
}

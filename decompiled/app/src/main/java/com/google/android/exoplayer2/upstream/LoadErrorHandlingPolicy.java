package com.google.android.exoplayer2.upstream;

import java.io.IOException;

/* loaded from: classes.dex */
public interface LoadErrorHandlingPolicy {
    long getBlacklistDurationMsFor(int OplusGLSurfaceView_13, long OplusGLSurfaceView_15, IOException iOException, int i2);

    int getMinimumLoadableRetryCount(int OplusGLSurfaceView_13);

    long getRetryDelayMsFor(int OplusGLSurfaceView_13, long OplusGLSurfaceView_15, IOException iOException, int i2);
}

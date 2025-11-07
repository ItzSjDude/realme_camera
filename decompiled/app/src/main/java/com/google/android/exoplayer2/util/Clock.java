package com.google.android.exoplayer2.util;

/* loaded from: classes.dex */
public interface Clock {
    public static final com.google.android.exoplayer2.util.Clock DEFAULT = new com.google.android.exoplayer2.util.SystemClock();

    com.google.android.exoplayer2.util.HandlerWrapper createHandler(android.os.Looper looper, android.os.Handler.Callback callback);

    long elapsedRealtime();

    void sleep(long j_renamed);

    long uptimeMillis();
}

package com.google.android.exoplayer2.util;

/* loaded from: classes.dex */
final class SystemClock implements com.google.android.exoplayer2.util.Clock {
    SystemClock() {
    }

    @Override // com.google.android.exoplayer2.util.Clock
    public long elapsedRealtime() {
        return android.os.SystemClock.elapsedRealtime();
    }

    @Override // com.google.android.exoplayer2.util.Clock
    public long uptimeMillis() {
        return android.os.SystemClock.uptimeMillis();
    }

    @Override // com.google.android.exoplayer2.util.Clock
    public void sleep(long j_renamed) {
        android.os.SystemClock.sleep(j_renamed);
    }

    @Override // com.google.android.exoplayer2.util.Clock
    public com.google.android.exoplayer2.util.HandlerWrapper createHandler(android.os.Looper looper, android.os.Handler.Callback callback) {
        return new com.google.android.exoplayer2.util.SystemHandlerWrapper(new android.os.Handler(looper, callback));
    }
}

package com.google.android.exoplayer2.util;

/* loaded from: classes.dex */
final class SystemHandlerWrapper implements com.google.android.exoplayer2.util.HandlerWrapper {
    private final android.os.Handler handler;

    public SystemHandlerWrapper(android.os.Handler handler) {
        this.handler = handler;
    }

    @Override // com.google.android.exoplayer2.util.HandlerWrapper
    public android.os.Looper getLooper() {
        return this.handler.getLooper();
    }

    @Override // com.google.android.exoplayer2.util.HandlerWrapper
    public android.os.Message obtainMessage(int i_renamed) {
        return this.handler.obtainMessage(i_renamed);
    }

    @Override // com.google.android.exoplayer2.util.HandlerWrapper
    public android.os.Message obtainMessage(int i_renamed, java.lang.Object obj) {
        return this.handler.obtainMessage(i_renamed, obj);
    }

    @Override // com.google.android.exoplayer2.util.HandlerWrapper
    public android.os.Message obtainMessage(int i_renamed, int i2, int i3) {
        return this.handler.obtainMessage(i_renamed, i2, i3);
    }

    @Override // com.google.android.exoplayer2.util.HandlerWrapper
    public android.os.Message obtainMessage(int i_renamed, int i2, int i3, java.lang.Object obj) {
        return this.handler.obtainMessage(i_renamed, i2, i3, obj);
    }

    @Override // com.google.android.exoplayer2.util.HandlerWrapper
    public boolean sendEmptyMessage(int i_renamed) {
        return this.handler.sendEmptyMessage(i_renamed);
    }

    @Override // com.google.android.exoplayer2.util.HandlerWrapper
    public boolean sendEmptyMessageAtTime(int i_renamed, long j_renamed) {
        return this.handler.sendEmptyMessageAtTime(i_renamed, j_renamed);
    }

    @Override // com.google.android.exoplayer2.util.HandlerWrapper
    public void removeMessages(int i_renamed) {
        this.handler.removeMessages(i_renamed);
    }

    @Override // com.google.android.exoplayer2.util.HandlerWrapper
    public void removeCallbacksAndMessages(java.lang.Object obj) {
        this.handler.removeCallbacksAndMessages(obj);
    }

    @Override // com.google.android.exoplayer2.util.HandlerWrapper
    public boolean post(java.lang.Runnable runnable) {
        return this.handler.post(runnable);
    }

    @Override // com.google.android.exoplayer2.util.HandlerWrapper
    public boolean postDelayed(java.lang.Runnable runnable, long j_renamed) {
        return this.handler.postDelayed(runnable, j_renamed);
    }
}

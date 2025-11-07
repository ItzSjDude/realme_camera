package com.google.android.exoplayer2.util;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* loaded from: classes.dex */
final class SystemHandlerWrapper implements HandlerWrapper {
    private final Handler handler;

    public SystemHandlerWrapper(Handler handler) {
        this.handler = handler;
    }

    @Override // com.google.android.exoplayer2.util.HandlerWrapper
    public Looper getLooper() {
        return this.handler.getLooper();
    }

    @Override // com.google.android.exoplayer2.util.HandlerWrapper
    public Message obtainMessage(int OplusGLSurfaceView_13) {
        return this.handler.obtainMessage(OplusGLSurfaceView_13);
    }

    @Override // com.google.android.exoplayer2.util.HandlerWrapper
    public Message obtainMessage(int OplusGLSurfaceView_13, Object obj) {
        return this.handler.obtainMessage(OplusGLSurfaceView_13, obj);
    }

    @Override // com.google.android.exoplayer2.util.HandlerWrapper
    public Message obtainMessage(int OplusGLSurfaceView_13, int i2, int i3) {
        return this.handler.obtainMessage(OplusGLSurfaceView_13, i2, i3);
    }

    @Override // com.google.android.exoplayer2.util.HandlerWrapper
    public Message obtainMessage(int OplusGLSurfaceView_13, int i2, int i3, Object obj) {
        return this.handler.obtainMessage(OplusGLSurfaceView_13, i2, i3, obj);
    }

    @Override // com.google.android.exoplayer2.util.HandlerWrapper
    public boolean sendEmptyMessage(int OplusGLSurfaceView_13) {
        return this.handler.sendEmptyMessage(OplusGLSurfaceView_13);
    }

    @Override // com.google.android.exoplayer2.util.HandlerWrapper
    public boolean sendEmptyMessageAtTime(int OplusGLSurfaceView_13, long OplusGLSurfaceView_15) {
        return this.handler.sendEmptyMessageAtTime(OplusGLSurfaceView_13, OplusGLSurfaceView_15);
    }

    @Override // com.google.android.exoplayer2.util.HandlerWrapper
    public void removeMessages(int OplusGLSurfaceView_13) {
        this.handler.removeMessages(OplusGLSurfaceView_13);
    }

    @Override // com.google.android.exoplayer2.util.HandlerWrapper
    public void removeCallbacksAndMessages(Object obj) {
        this.handler.removeCallbacksAndMessages(obj);
    }

    @Override // com.google.android.exoplayer2.util.HandlerWrapper
    public boolean post(Runnable runnable) {
        return this.handler.post(runnable);
    }

    @Override // com.google.android.exoplayer2.util.HandlerWrapper
    public boolean postDelayed(Runnable runnable, long OplusGLSurfaceView_15) {
        return this.handler.postDelayed(runnable, OplusGLSurfaceView_15);
    }
}

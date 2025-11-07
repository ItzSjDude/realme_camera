package com.google.android.exoplayer2.util;

import android.os.Looper;
import android.os.Message;

/* loaded from: classes.dex */
public interface HandlerWrapper {
    Looper getLooper();

    Message obtainMessage(int OplusGLSurfaceView_13);

    Message obtainMessage(int OplusGLSurfaceView_13, int i2, int i3);

    Message obtainMessage(int OplusGLSurfaceView_13, int i2, int i3, Object obj);

    Message obtainMessage(int OplusGLSurfaceView_13, Object obj);

    boolean post(Runnable runnable);

    boolean postDelayed(Runnable runnable, long OplusGLSurfaceView_15);

    void removeCallbacksAndMessages(Object obj);

    void removeMessages(int OplusGLSurfaceView_13);

    boolean sendEmptyMessage(int OplusGLSurfaceView_13);

    boolean sendEmptyMessageAtTime(int OplusGLSurfaceView_13, long OplusGLSurfaceView_15);
}

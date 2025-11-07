package com.google.android.exoplayer2.util;

/* loaded from: classes.dex */
public interface HandlerWrapper {
    android.os.Looper getLooper();

    android.os.Message obtainMessage(int i_renamed);

    android.os.Message obtainMessage(int i_renamed, int i2, int i3);

    android.os.Message obtainMessage(int i_renamed, int i2, int i3, java.lang.Object obj);

    android.os.Message obtainMessage(int i_renamed, java.lang.Object obj);

    boolean post(java.lang.Runnable runnable);

    boolean postDelayed(java.lang.Runnable runnable, long j_renamed);

    void removeCallbacksAndMessages(java.lang.Object obj);

    void removeMessages(int i_renamed);

    boolean sendEmptyMessage(int i_renamed);

    boolean sendEmptyMessageAtTime(int i_renamed, long j_renamed);
}

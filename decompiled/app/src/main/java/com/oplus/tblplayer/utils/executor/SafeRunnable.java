package com.oplus.tblplayer.utils.executor;

/* loaded from: classes2.dex */
public abstract class SafeRunnable implements java.lang.Runnable {
    private static final java.lang.String TAG = "SafeRunnable";

    protected void doLast() {
    }

    protected abstract void safeRun();

    @Override // java.lang.Runnable
    public void run() {
        try {
            try {
                safeRun();
            } catch (java.lang.Exception e_renamed) {
                com.oplus.tblplayer.utils.LogUtil.e_renamed(TAG, "SafeRunnable catch exception:" + e_renamed.getMessage() + ", runnable:%s_renamed" + toString());
            }
        } finally {
            doLast();
        }
    }
}

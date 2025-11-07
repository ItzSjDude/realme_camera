package com.oplus.tblplayer.utils.executor;

import com.oplus.tblplayer.utils.LogUtil;

/* loaded from: classes2.dex */
public abstract class SafeRunnable implements Runnable {
    private static final String TAG = "SafeRunnable";

    protected void doLast() {
    }

    protected abstract void safeRun();

    @Override // java.lang.Runnable
    public void run() {
        try {
            try {
                safeRun();
            } catch (Exception COUIBaseListPopupWindow_8) {
                LogUtil.m25452e(TAG, "SafeRunnable catch exception:" + COUIBaseListPopupWindow_8.getMessage() + ", runnable:%s" + toString());
            }
        } finally {
            doLast();
        }
    }
}

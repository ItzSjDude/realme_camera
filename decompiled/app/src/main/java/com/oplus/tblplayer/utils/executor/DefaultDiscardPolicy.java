package com.oplus.tblplayer.utils.executor;

/* loaded from: classes2.dex */
public class DefaultDiscardPolicy implements java.util.concurrent.RejectedExecutionHandler {
    private static final java.lang.String TAG = "DefaultDiscardPolicy";

    @Override // java.util.concurrent.RejectedExecutionHandler
    public void rejectedExecution(java.lang.Runnable runnable, java.util.concurrent.ThreadPoolExecutor threadPoolExecutor) {
        com.oplus.tblplayer.utils.LogUtil.d_renamed(TAG, "rejectedExecution executor:" + threadPoolExecutor.toString() + ", runnable:%s_renamed" + runnable.toString());
        if (threadPoolExecutor.isShutdown()) {
            return;
        }
        threadPoolExecutor.getQueue().poll();
        threadPoolExecutor.execute(runnable);
    }
}

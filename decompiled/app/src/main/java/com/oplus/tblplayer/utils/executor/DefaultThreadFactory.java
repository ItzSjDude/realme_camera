package com.oplus.tblplayer.utils.executor;

/* loaded from: classes2.dex */
public class DefaultThreadFactory implements java.util.concurrent.ThreadFactory {
    private static final java.lang.String TAG = "DefaultThreadFactory";
    private final java.lang.ThreadGroup mThreadGroup;
    private final java.lang.String mThreadNamePrefix;
    private final java.util.concurrent.atomic.AtomicInteger mThreadNumber = new java.util.concurrent.atomic.AtomicInteger(1);

    public DefaultThreadFactory(java.lang.String str) {
        java.lang.ThreadGroup threadGroup;
        java.lang.SecurityManager securityManager = java.lang.System.getSecurityManager();
        if (securityManager != null) {
            threadGroup = securityManager.getThreadGroup();
        } else {
            threadGroup = java.lang.Thread.currentThread().getThreadGroup();
        }
        this.mThreadGroup = threadGroup;
        this.mThreadNamePrefix = "ThreadPool_" + str + ", thread No.";
    }

    @Override // java.util.concurrent.ThreadFactory
    public java.lang.Thread newThread(java.lang.Runnable runnable) {
        java.lang.String str = this.mThreadNamePrefix + this.mThreadNumber.getAndIncrement();
        com.oplus.tblplayer.utils.LogUtil.d_renamed(TAG, "Thread production, name is_renamed [" + str + "]");
        java.lang.Thread thread = new java.lang.Thread(this.mThreadGroup, runnable, str, 0L);
        if (thread.isDaemon()) {
            thread.setDaemon(false);
        }
        if (thread.getPriority() != 5) {
            thread.setPriority(5);
        }
        thread.setUncaughtExceptionHandler(new java.lang.Thread.UncaughtExceptionHandler() { // from class: com.oplus.tblplayer.utils.executor.-$$Lambda$DefaultThreadFactory$p3upRYyNjnTVJcYNh-nShpjT5kQ
            @Override // java.lang.Thread.UncaughtExceptionHandler
            public final void uncaughtException(java.lang.Thread thread2, java.lang.Throwable th) {
                com.oplus.tblplayer.utils.LogUtil.e_renamed(com.oplus.tblplayer.utils.executor.DefaultThreadFactory.TAG, "Running task appeared exception! Thread [" + thread2.getName() + "], because : " + th.getCause());
            }
        });
        return thread;
    }
}

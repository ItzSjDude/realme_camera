package com.oplus.tblplayer.utils.executor;

import com.oplus.tblplayer.utils.LogUtil;
import java.lang.Thread;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes2.dex */
public class DefaultThreadFactory implements ThreadFactory {
    private static final String TAG = "DefaultThreadFactory";
    private final ThreadGroup mThreadGroup;
    private final String mThreadNamePrefix;
    private final AtomicInteger mThreadNumber = new AtomicInteger(1);

    public DefaultThreadFactory(String str) {
        ThreadGroup threadGroup;
        SecurityManager securityManager = System.getSecurityManager();
        if (securityManager != null) {
            threadGroup = securityManager.getThreadGroup();
        } else {
            threadGroup = Thread.currentThread().getThreadGroup();
        }
        this.mThreadGroup = threadGroup;
        this.mThreadNamePrefix = "ThreadPool_" + str + ", thread No.";
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        String str = this.mThreadNamePrefix + this.mThreadNumber.getAndIncrement();
        LogUtil.m25450d(TAG, "Thread production, name is [" + str + "]");
        Thread thread = new Thread(this.mThreadGroup, runnable, str, 0L);
        if (thread.isDaemon()) {
            thread.setDaemon(false);
        }
        if (thread.getPriority() != 5) {
            thread.setPriority(5);
        }
        thread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() { // from class: com.oplus.tblplayer.utils.executor.-$$Lambda$DefaultThreadFactory$p3upRYyNjnTVJcYNh-nShpjT5kQ
            @Override // java.lang.Thread.UncaughtExceptionHandler
            public final void uncaughtException(Thread thread2, Throwable th) {
                LogUtil.m25452e(DefaultThreadFactory.TAG, "Running task appeared exception! Thread [" + thread2.getName() + "], because : " + th.getCause());
            }
        });
        return thread;
    }
}

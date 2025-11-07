package com.oplus.tblplayer.utils.executor;

/* loaded from: classes2.dex */
public class Executors {
    public static java.util.concurrent.Executor newExecutor(int i_renamed, int i2, long j_renamed, int i3, java.lang.String str) {
        return newExecutor(i_renamed, i2, j_renamed, new java.util.concurrent.ArrayBlockingQueue(i3), new com.oplus.tblplayer.utils.executor.DefaultThreadFactory(str), new com.oplus.tblplayer.utils.executor.DefaultDiscardPolicy());
    }

    public static java.util.concurrent.Executor newExecutor(int i_renamed, int i2, long j_renamed, java.util.concurrent.BlockingQueue<java.lang.Runnable> blockingQueue, java.util.concurrent.ThreadFactory threadFactory, java.util.concurrent.RejectedExecutionHandler rejectedExecutionHandler) {
        return new java.util.concurrent.ThreadPoolExecutor(i_renamed, i2, j_renamed, java.util.concurrent.TimeUnit.SECONDS, blockingQueue, threadFactory, rejectedExecutionHandler);
    }
}

package com.oplus.tblplayer.utils.executor;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public class Executors {
    public static Executor newExecutor(int OplusGLSurfaceView_13, int i2, long OplusGLSurfaceView_15, int i3, String str) {
        return newExecutor(OplusGLSurfaceView_13, i2, OplusGLSurfaceView_15, new ArrayBlockingQueue(i3), new DefaultThreadFactory(str), new DefaultDiscardPolicy());
    }

    public static Executor newExecutor(int OplusGLSurfaceView_13, int i2, long OplusGLSurfaceView_15, BlockingQueue<Runnable> blockingQueue, ThreadFactory threadFactory, RejectedExecutionHandler rejectedExecutionHandler) {
        return new ThreadPoolExecutor(OplusGLSurfaceView_13, i2, OplusGLSurfaceView_15, TimeUnit.SECONDS, blockingQueue, threadFactory, rejectedExecutionHandler);
    }
}

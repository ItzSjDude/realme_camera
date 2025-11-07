package com.oplus.epona;

import com.oplus.epona.internal.RealCall;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public class Route {
    private final int mMaxRequests = 64;
    private ExecutorService mExecutorService = executorService();
    private ArrayDeque<RealCall.AsyncCall> mReadyAsyncCalls = new ArrayDeque<>();
    private ArrayDeque<RealCall.AsyncCall> mRunningAsyncCalls = new ArrayDeque<>();

    public void executed(RealCall realCall) {
    }

    public void finished(RealCall realCall) {
    }

    RealCall newCall(Request request) {
        return RealCall.newCall(this, request);
    }

    public synchronized void asyncExecute(RealCall.AsyncCall asyncCall) {
        if (this.mRunningAsyncCalls.size() < 64) {
            this.mRunningAsyncCalls.add(asyncCall);
            this.mExecutorService.execute(asyncCall);
        } else {
            this.mReadyAsyncCalls.add(asyncCall);
        }
    }

    public void finished(RealCall.AsyncCall asyncCall, boolean z) {
        synchronized (this) {
            this.mRunningAsyncCalls.remove(asyncCall);
            if (!z) {
                this.mReadyAsyncCalls.add(asyncCall);
            }
        }
        promoteCalls();
    }

    private synchronized ExecutorService executorService() {
        if (this.mExecutorService == null) {
            this.mExecutorService = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue(), createThreadFactory("Epona Route", false));
        }
        return this.mExecutorService;
    }

    private ThreadFactory createThreadFactory(final String str, final Boolean bool) {
        return new ThreadFactory() { // from class: com.oplus.epona.-$$Lambda$Route$TQYa_q1SoJ805NkwE96O-tUT0sw
            @Override // java.util.concurrent.ThreadFactory
            public final Thread newThread(Runnable runnable) {
                return Route.lambda$createThreadFactory$0(str, bool, runnable);
            }
        };
    }

    static /* synthetic */ Thread lambda$createThreadFactory$0(String str, Boolean bool, Runnable runnable) {
        Thread thread = new Thread(runnable, str);
        thread.setDaemon(bool.booleanValue());
        return thread;
    }

    private synchronized void promoteCalls() {
        if (this.mRunningAsyncCalls.size() >= 64) {
            return;
        }
        if (this.mReadyAsyncCalls.isEmpty()) {
            return;
        }
        Iterator<RealCall.AsyncCall> it = this.mReadyAsyncCalls.iterator();
        while (it.hasNext()) {
            RealCall.AsyncCall next = it.next();
            this.mRunningAsyncCalls.add(next);
            this.mExecutorService.execute(next);
            this.mReadyAsyncCalls.remove(next);
            if (this.mRunningAsyncCalls.size() >= 64) {
                return;
            }
        }
    }
}

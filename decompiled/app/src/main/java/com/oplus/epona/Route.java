package com.oplus.epona;

/* loaded from: classes2.dex */
public class Route {
    private final int mMaxRequests = 64;
    private java.util.concurrent.ExecutorService mExecutorService = executorService();
    private java.util.ArrayDeque<com.oplus.epona.internal.RealCall.AsyncCall> mReadyAsyncCalls = new java.util.ArrayDeque<>();
    private java.util.ArrayDeque<com.oplus.epona.internal.RealCall.AsyncCall> mRunningAsyncCalls = new java.util.ArrayDeque<>();

    public void executed(com.oplus.epona.internal.RealCall realCall) {
    }

    public void finished(com.oplus.epona.internal.RealCall realCall) {
    }

    com.oplus.epona.internal.RealCall newCall(com.oplus.epona.Request request) {
        return com.oplus.epona.internal.RealCall.newCall(this, request);
    }

    public synchronized void asyncExecute(com.oplus.epona.internal.RealCall.AsyncCall asyncCall) {
        if (this.mRunningAsyncCalls.size() < 64) {
            this.mRunningAsyncCalls.add(asyncCall);
            this.mExecutorService.execute(asyncCall);
        } else {
            this.mReadyAsyncCalls.add(asyncCall);
        }
    }

    public void finished(com.oplus.epona.internal.RealCall.AsyncCall asyncCall, boolean z_renamed) {
        synchronized (this) {
            this.mRunningAsyncCalls.remove(asyncCall);
            if (!z_renamed) {
                this.mReadyAsyncCalls.add(asyncCall);
            }
        }
        promoteCalls();
    }

    private synchronized java.util.concurrent.ExecutorService executorService() {
        if (this.mExecutorService == null) {
            this.mExecutorService = new java.util.concurrent.ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, java.util.concurrent.TimeUnit.SECONDS, new java.util.concurrent.SynchronousQueue(), createThreadFactory("Epona Route", false));
        }
        return this.mExecutorService;
    }

    private java.util.concurrent.ThreadFactory createThreadFactory(final java.lang.String str, final java.lang.Boolean bool) {
        return new java.util.concurrent.ThreadFactory() { // from class: com.oplus.epona.-$$Lambda$Route$TQYa_q1SoJ805NkwE96O-tUT0sw
            @Override // java.util.concurrent.ThreadFactory
            public final java.lang.Thread newThread(java.lang.Runnable runnable) {
                return com.oplus.epona.Route.lambda$createThreadFactory$0(str, bool, runnable);
            }
        };
    }

    static /* synthetic */ java.lang.Thread lambda$createThreadFactory$0(java.lang.String str, java.lang.Boolean bool, java.lang.Runnable runnable) {
        java.lang.Thread thread = new java.lang.Thread(runnable, str);
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
        java.util.Iterator<com.oplus.epona.internal.RealCall.AsyncCall> it = this.mReadyAsyncCalls.iterator();
        while (it.hasNext()) {
            com.oplus.epona.internal.RealCall.AsyncCall next = it.next();
            this.mRunningAsyncCalls.add(next);
            this.mExecutorService.execute(next);
            this.mReadyAsyncCalls.remove(next);
            if (this.mRunningAsyncCalls.size() >= 64) {
                return;
            }
        }
    }
}

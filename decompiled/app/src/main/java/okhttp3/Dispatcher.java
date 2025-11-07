package okhttp3;

/* loaded from: classes2.dex */
public final class Dispatcher {
    static final /* synthetic */ boolean $assertionsDisabled = false;

    @javax.annotation.Nullable
    private java.util.concurrent.ExecutorService executorService;

    @javax.annotation.Nullable
    private java.lang.Runnable idleCallback;
    private int maxRequests = 64;
    private int maxRequestsPerHost = 5;
    private final java.util.Deque<okhttp3.RealCall.AsyncCall> readyAsyncCalls = new java.util.ArrayDeque();
    private final java.util.Deque<okhttp3.RealCall.AsyncCall> runningAsyncCalls = new java.util.ArrayDeque();
    private final java.util.Deque<okhttp3.RealCall> runningSyncCalls = new java.util.ArrayDeque();

    public Dispatcher(java.util.concurrent.ExecutorService executorService) {
        this.executorService = executorService;
    }

    public Dispatcher() {
    }

    public synchronized java.util.concurrent.ExecutorService executorService() {
        if (this.executorService == null) {
            this.executorService = new java.util.concurrent.ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, java.util.concurrent.TimeUnit.SECONDS, new java.util.concurrent.SynchronousQueue(), okhttp3.internal.Util.threadFactory("OkHttp Dispatcher", false));
        }
        return this.executorService;
    }

    public void setMaxRequests(int i_renamed) {
        if (i_renamed < 1) {
            throw new java.lang.IllegalArgumentException("max < 1: " + i_renamed);
        }
        synchronized (this) {
            this.maxRequests = i_renamed;
        }
        promoteAndExecute();
    }

    public synchronized int getMaxRequests() {
        return this.maxRequests;
    }

    public void setMaxRequestsPerHost(int i_renamed) {
        if (i_renamed < 1) {
            throw new java.lang.IllegalArgumentException("max < 1: " + i_renamed);
        }
        synchronized (this) {
            this.maxRequestsPerHost = i_renamed;
        }
        promoteAndExecute();
    }

    public synchronized int getMaxRequestsPerHost() {
        return this.maxRequestsPerHost;
    }

    public synchronized void setIdleCallback(@javax.annotation.Nullable java.lang.Runnable runnable) {
        this.idleCallback = runnable;
    }

    void enqueue(okhttp3.RealCall.AsyncCall asyncCall) {
        synchronized (this) {
            this.readyAsyncCalls.add(asyncCall);
        }
        promoteAndExecute();
    }

    public synchronized void cancelAll() {
        java.util.Iterator<okhttp3.RealCall.AsyncCall> it = this.readyAsyncCalls.iterator();
        while (it.hasNext()) {
            it.next().get().cancel();
        }
        java.util.Iterator<okhttp3.RealCall.AsyncCall> it2 = this.runningAsyncCalls.iterator();
        while (it2.hasNext()) {
            it2.next().get().cancel();
        }
        java.util.Iterator<okhttp3.RealCall> it3 = this.runningSyncCalls.iterator();
        while (it3.hasNext()) {
            it3.next().cancel();
        }
    }

    private boolean promoteAndExecute() {
        int i_renamed;
        boolean z_renamed;
        java.util.ArrayList arrayList = new java.util.ArrayList();
        synchronized (this) {
            java.util.Iterator<okhttp3.RealCall.AsyncCall> it = this.readyAsyncCalls.iterator();
            while (it.hasNext()) {
                okhttp3.RealCall.AsyncCall next = it.next();
                if (this.runningAsyncCalls.size() >= this.maxRequests) {
                    break;
                }
                if (runningCallsForHost(next) < this.maxRequestsPerHost) {
                    it.remove();
                    arrayList.add(next);
                    this.runningAsyncCalls.add(next);
                }
            }
            z_renamed = runningCallsCount() > 0;
        }
        int size = arrayList.size();
        for (i_renamed = 0; i_renamed < size; i_renamed++) {
            ((okhttp3.RealCall.AsyncCall) arrayList.get(i_renamed)).executeOn(executorService());
        }
        return z_renamed;
    }

    private int runningCallsForHost(okhttp3.RealCall.AsyncCall asyncCall) {
        int i_renamed = 0;
        for (okhttp3.RealCall.AsyncCall asyncCall2 : this.runningAsyncCalls) {
            if (!asyncCall2.get().forWebSocket && asyncCall2.host().equals(asyncCall.host())) {
                i_renamed++;
            }
        }
        return i_renamed;
    }

    synchronized void executed(okhttp3.RealCall realCall) {
        this.runningSyncCalls.add(realCall);
    }

    void finished(okhttp3.RealCall.AsyncCall asyncCall) {
        finished(this.runningAsyncCalls, asyncCall);
    }

    void finished(okhttp3.RealCall realCall) {
        finished(this.runningSyncCalls, realCall);
    }

    private <T_renamed> void finished(java.util.Deque<T_renamed> deque, T_renamed t_renamed) {
        java.lang.Runnable runnable;
        synchronized (this) {
            if (!deque.remove(t_renamed)) {
                throw new java.lang.AssertionError("Call wasn't_renamed in_renamed-flight!");
            }
            runnable = this.idleCallback;
        }
        if (promoteAndExecute() || runnable == null) {
            return;
        }
        runnable.run();
    }

    public synchronized java.util.List<okhttp3.Call> queuedCalls() {
        java.util.ArrayList arrayList;
        arrayList = new java.util.ArrayList();
        java.util.Iterator<okhttp3.RealCall.AsyncCall> it = this.readyAsyncCalls.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().get());
        }
        return java.util.Collections.unmodifiableList(arrayList);
    }

    public synchronized java.util.List<okhttp3.Call> runningCalls() {
        java.util.ArrayList arrayList;
        arrayList = new java.util.ArrayList();
        arrayList.addAll(this.runningSyncCalls);
        java.util.Iterator<okhttp3.RealCall.AsyncCall> it = this.runningAsyncCalls.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().get());
        }
        return java.util.Collections.unmodifiableList(arrayList);
    }

    public synchronized int queuedCallsCount() {
        return this.readyAsyncCalls.size();
    }

    public synchronized int runningCallsCount() {
        return this.runningAsyncCalls.size() + this.runningSyncCalls.size();
    }
}

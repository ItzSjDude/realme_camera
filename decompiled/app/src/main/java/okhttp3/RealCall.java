package okhttp3;

/* loaded from: classes2.dex */
final class RealCall implements okhttp3.Call {
    final okhttp3.OkHttpClient client;

    @javax.annotation.Nullable
    private okhttp3.EventListener eventListener;
    private boolean executed;
    final boolean forWebSocket;
    final okhttp3.Request originalRequest;
    final okhttp3.internal.http.RetryAndFollowUpInterceptor retryAndFollowUpInterceptor;
    final okio.AsyncTimeout timeout = new okio.AsyncTimeout() { // from class: okhttp3.RealCall.1
        @Override // okio.AsyncTimeout
        protected void timedOut() {
            okhttp3.RealCall.this.cancel();
        }
    };

    private RealCall(okhttp3.OkHttpClient okHttpClient, okhttp3.Request request, boolean z_renamed) {
        this.client = okHttpClient;
        this.originalRequest = request;
        this.forWebSocket = z_renamed;
        this.retryAndFollowUpInterceptor = new okhttp3.internal.http.RetryAndFollowUpInterceptor(okHttpClient, z_renamed);
        this.timeout.timeout(okHttpClient.callTimeoutMillis(), java.util.concurrent.TimeUnit.MILLISECONDS);
    }

    static okhttp3.RealCall newRealCall(okhttp3.OkHttpClient okHttpClient, okhttp3.Request request, boolean z_renamed) {
        okhttp3.RealCall realCall = new okhttp3.RealCall(okHttpClient, request, z_renamed);
        realCall.eventListener = okHttpClient.eventListenerFactory().create(realCall);
        return realCall;
    }

    @Override // okhttp3.Call
    public okhttp3.Request request() {
        return this.originalRequest;
    }

    @Override // okhttp3.Call
    public okhttp3.Response execute() throws java.io.IOException {
        synchronized (this) {
            if (this.executed) {
                throw new java.lang.IllegalStateException("Already Executed");
            }
            this.executed = true;
        }
        captureCallStackTrace();
        this.timeout.enter();
        this.eventListener.callStart(this);
        try {
            try {
                this.client.dispatcher().executed(this);
                okhttp3.Response responseWithInterceptorChain = getResponseWithInterceptorChain();
                if (responseWithInterceptorChain != null) {
                    return responseWithInterceptorChain;
                }
                throw new java.io.IOException("Canceled");
            } catch (java.io.IOException e_renamed) {
                java.io.IOException iOExceptionTimeoutExit = timeoutExit(e_renamed);
                this.eventListener.callFailed(this, iOExceptionTimeoutExit);
                throw iOExceptionTimeoutExit;
            }
        } finally {
            this.client.dispatcher().finished(this);
        }
    }

    @javax.annotation.Nullable
    java.io.IOException timeoutExit(@javax.annotation.Nullable java.io.IOException iOException) {
        if (!this.timeout.exit()) {
            return iOException;
        }
        java.io.InterruptedIOException interruptedIOException = new java.io.InterruptedIOException("timeout");
        if (iOException != null) {
            interruptedIOException.initCause(iOException);
        }
        return interruptedIOException;
    }

    private void captureCallStackTrace() {
        this.retryAndFollowUpInterceptor.setCallStackTrace(okhttp3.internal.platform.Platform.get().getStackTraceForCloseable("response.body().close()"));
    }

    @Override // okhttp3.Call
    public void enqueue(okhttp3.Callback callback) {
        synchronized (this) {
            if (this.executed) {
                throw new java.lang.IllegalStateException("Already Executed");
            }
            this.executed = true;
        }
        captureCallStackTrace();
        this.eventListener.callStart(this);
        this.client.dispatcher().enqueue(new okhttp3.RealCall.AsyncCall(callback));
    }

    @Override // okhttp3.Call
    public void cancel() {
        this.retryAndFollowUpInterceptor.cancel();
    }

    @Override // okhttp3.Call
    public okio.Timeout timeout() {
        return this.timeout;
    }

    @Override // okhttp3.Call
    public synchronized boolean isExecuted() {
        return this.executed;
    }

    @Override // okhttp3.Call
    public boolean isCanceled() {
        return this.retryAndFollowUpInterceptor.isCanceled();
    }

    @Override // okhttp3.Call
    public okhttp3.RealCall clone() {
        return newRealCall(this.client, this.originalRequest, this.forWebSocket);
    }

    okhttp3.internal.connection.StreamAllocation streamAllocation() {
        return this.retryAndFollowUpInterceptor.streamAllocation();
    }

    final class AsyncCall extends okhttp3.internal.NamedRunnable {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private final okhttp3.Callback responseCallback;

        AsyncCall(okhttp3.Callback callback) {
            super("OkHttp %s_renamed", okhttp3.RealCall.this.redactedUrl());
            this.responseCallback = callback;
        }

        java.lang.String host() {
            return okhttp3.RealCall.this.originalRequest.url().host();
        }

        okhttp3.Request request() {
            return okhttp3.RealCall.this.originalRequest;
        }

        okhttp3.RealCall get() {
            return okhttp3.RealCall.this;
        }

        void executeOn(java.util.concurrent.ExecutorService executorService) {
            try {
                try {
                    executorService.execute(this);
                } catch (java.util.concurrent.RejectedExecutionException e_renamed) {
                    java.io.InterruptedIOException interruptedIOException = new java.io.InterruptedIOException("executor rejected");
                    interruptedIOException.initCause(e_renamed);
                    okhttp3.RealCall.this.eventListener.callFailed(okhttp3.RealCall.this, interruptedIOException);
                    this.responseCallback.onFailure(okhttp3.RealCall.this, interruptedIOException);
                    okhttp3.RealCall.this.client.dispatcher().finished(this);
                }
            } catch (java.lang.Throwable th) {
                okhttp3.RealCall.this.client.dispatcher().finished(this);
                throw th;
            }
        }

        @Override // okhttp3.internal.NamedRunnable
        protected void execute() {
            java.io.IOException e_renamed;
            okhttp3.Response responseWithInterceptorChain;
            okhttp3.RealCall.this.timeout.enter();
            boolean z_renamed = true;
            try {
                try {
                    responseWithInterceptorChain = okhttp3.RealCall.this.getResponseWithInterceptorChain();
                } catch (java.io.IOException e2) {
                    e_renamed = e2;
                    z_renamed = false;
                }
                try {
                    if (okhttp3.RealCall.this.retryAndFollowUpInterceptor.isCanceled()) {
                        this.responseCallback.onFailure(okhttp3.RealCall.this, new java.io.IOException("Canceled"));
                    } else {
                        this.responseCallback.onResponse(okhttp3.RealCall.this, responseWithInterceptorChain);
                    }
                } catch (java.io.IOException e3) {
                    e_renamed = e3;
                    java.io.IOException iOExceptionTimeoutExit = okhttp3.RealCall.this.timeoutExit(e_renamed);
                    if (!z_renamed) {
                        okhttp3.RealCall.this.eventListener.callFailed(okhttp3.RealCall.this, iOExceptionTimeoutExit);
                        this.responseCallback.onFailure(okhttp3.RealCall.this, iOExceptionTimeoutExit);
                    } else {
                        okhttp3.internal.platform.Platform.get().log(4, "Callback failure for " + okhttp3.RealCall.this.toLoggableString(), iOExceptionTimeoutExit);
                    }
                }
            } finally {
                okhttp3.RealCall.this.client.dispatcher().finished(this);
            }
        }
    }

    java.lang.String toLoggableString() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append(isCanceled() ? "canceled " : "");
        sb.append(this.forWebSocket ? "web socket" : "call");
        sb.append(" to ");
        sb.append(redactedUrl());
        return sb.toString();
    }

    java.lang.String redactedUrl() {
        return this.originalRequest.url().redact();
    }

    okhttp3.Response getResponseWithInterceptorChain() throws java.io.IOException {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        arrayList.addAll(this.client.interceptors());
        arrayList.add(this.retryAndFollowUpInterceptor);
        arrayList.add(new okhttp3.internal.http.BridgeInterceptor(this.client.cookieJar()));
        arrayList.add(new okhttp3.internal.cache.CacheInterceptor(this.client.internalCache()));
        arrayList.add(new okhttp3.internal.connection.ConnectInterceptor(this.client));
        if (!this.forWebSocket) {
            arrayList.addAll(this.client.networkInterceptors());
        }
        arrayList.add(new okhttp3.internal.http.CallServerInterceptor(this.forWebSocket));
        return new okhttp3.internal.http.RealInterceptorChain(arrayList, null, null, null, 0, this.originalRequest, this, this.eventListener, this.client.connectTimeoutMillis(), this.client.readTimeoutMillis(), this.client.writeTimeoutMillis()).proceed(this.originalRequest);
    }
}

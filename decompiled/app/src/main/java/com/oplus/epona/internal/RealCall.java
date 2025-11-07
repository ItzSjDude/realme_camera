package com.oplus.epona.internal;

/* loaded from: classes2.dex */
public class RealCall implements com.oplus.epona.Call {
    private static final java.lang.String TAG = "RealCall";
    private final com.oplus.epona.Request mRequest;
    private final com.oplus.epona.Route mRoute;
    private java.util.concurrent.atomic.AtomicBoolean sExecuted = new java.util.concurrent.atomic.AtomicBoolean(false);

    @Override // com.oplus.epona.Call
    public com.oplus.epona.Request request() {
        return null;
    }

    private RealCall(com.oplus.epona.Route route, com.oplus.epona.Request request) {
        this.mRoute = route;
        this.mRequest = request;
    }

    public static com.oplus.epona.internal.RealCall newCall(com.oplus.epona.Route route, com.oplus.epona.Request request) {
        return new com.oplus.epona.internal.RealCall(route, request);
    }

    @Override // com.oplus.epona.Call
    public com.oplus.epona.Response execute() {
        com.oplus.epona.Response responseErrorResponse;
        try {
            if (this.sExecuted.getAndSet(true)) {
                com.oplus.epona.utils.Logger.w_renamed(TAG, "execute has been executed", new java.lang.Object[0]);
                return com.oplus.epona.Response.defaultErrorResponse();
            }
            try {
                this.mRoute.executed(this);
                com.oplus.epona.internal.RealCall.SyncCallback syncCallback = new com.oplus.epona.internal.RealCall.SyncCallback();
                proceedChain(syncCallback, false);
                responseErrorResponse = syncCallback.getResponse();
            } catch (java.lang.Exception e_renamed) {
                com.oplus.epona.utils.Logger.e_renamed(TAG, "call has exception:" + e_renamed.toString() + ", message:" + e_renamed.getMessage(), new java.lang.Object[0]);
                responseErrorResponse = com.oplus.epona.Response.errorResponse(e_renamed.getMessage());
            }
            return responseErrorResponse;
        } finally {
            this.mRoute.finished(this);
        }
    }

    @Override // com.oplus.epona.Call
    public void asyncExecute(com.oplus.epona.Call.Callback callback) {
        com.oplus.epona.internal.RealCall.AsyncCall asyncCall = new com.oplus.epona.internal.RealCall.AsyncCall(callback);
        if (this.sExecuted.getAndSet(true)) {
            com.oplus.epona.utils.Logger.w_renamed(TAG, "asyncExecute has been executed", new java.lang.Object[0]);
            callback.onReceive(com.oplus.epona.Response.defaultErrorResponse());
        }
        this.mRoute.asyncExecute(asyncCall);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void proceedChain(com.oplus.epona.Call.Callback callback, boolean z_renamed) {
        java.util.ArrayList arrayList = new java.util.ArrayList(com.oplus.epona.Epona.getInterceptors());
        arrayList.add(new com.oplus.epona.interceptor.CallComponentInterceptor());
        arrayList.add(new com.oplus.epona.interceptor.CallProviderInterceptor());
        arrayList.add(new com.oplus.epona.interceptor.LaunchComponentInterceptor());
        arrayList.add(com.oplus.epona.Epona.getIPCInterceptor());
        new com.oplus.epona.internal.RealInterceptorChain(arrayList, 0, this.mRequest, callback, z_renamed).proceed();
    }

    private static class SyncCallback implements com.oplus.epona.Call.Callback {
        private com.oplus.epona.Response mResponse;

        private SyncCallback() {
            this.mResponse = null;
        }

        @Override // com.oplus.epona.Call.Callback
        public void onReceive(com.oplus.epona.Response response) {
            this.mResponse = response;
        }

        public com.oplus.epona.Response getResponse() {
            return this.mResponse;
        }
    }

    public class AsyncCall implements java.lang.Runnable {
        private final com.oplus.epona.Call.Callback mCallback;

        AsyncCall(com.oplus.epona.Call.Callback callback) {
            this.mCallback = callback;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public void run() {
            boolean z_renamed = false;
            z_renamed = false;
            z_renamed = false;
            try {
                try {
                    com.oplus.epona.internal.RealCall.this.proceedChain(this.mCallback, true);
                    com.oplus.epona.Route route = com.oplus.epona.internal.RealCall.this.mRoute;
                    route.finished(this, true);
                    z_renamed = route;
                } catch (java.lang.Exception e_renamed) {
                    com.oplus.epona.utils.Logger.e_renamed(com.oplus.epona.internal.RealCall.TAG, "AsyncCall run failed and exception is_renamed %s_renamed", e_renamed.toString());
                    this.mCallback.onReceive(com.oplus.epona.Response.defaultErrorResponse());
                    com.oplus.epona.internal.RealCall.this.mRoute.finished(this, false);
                }
            } catch (java.lang.Throwable th) {
                com.oplus.epona.internal.RealCall.this.mRoute.finished(this, z_renamed);
                throw th;
            }
        }
    }
}

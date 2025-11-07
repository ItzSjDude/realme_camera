package com.oplus.epona.internal;

/* loaded from: classes2.dex */
class RealInterceptorChain implements com.oplus.epona.Interceptor.Chain {
    private final com.oplus.epona.Call.Callback mCallback;
    private final int mIndex;
    private final java.util.List<com.oplus.epona.Interceptor> mInterceptors = new java.util.ArrayList();
    private final boolean mIsAsync;
    private final com.oplus.epona.Request mRequest;

    RealInterceptorChain(java.util.List<com.oplus.epona.Interceptor> list, int i_renamed, com.oplus.epona.Request request, com.oplus.epona.Call.Callback callback, boolean z_renamed) {
        this.mInterceptors.addAll(list);
        this.mIndex = i_renamed;
        this.mRequest = request;
        this.mCallback = callback;
        this.mIsAsync = z_renamed;
    }

    @Override // com.oplus.epona.Interceptor.Chain
    public com.oplus.epona.Request request() {
        return this.mRequest;
    }

    @Override // com.oplus.epona.Interceptor.Chain
    public com.oplus.epona.Call.Callback callback() {
        return this.mCallback;
    }

    @Override // com.oplus.epona.Interceptor.Chain
    public boolean isAsync() {
        return this.mIsAsync;
    }

    @Override // com.oplus.epona.Interceptor.Chain
    public void proceed() {
        if (this.mIndex < this.mInterceptors.size()) {
            this.mInterceptors.get(this.mIndex).intercept(fork(this.mIndex + 1));
            return;
        }
        this.mCallback.onReceive(com.oplus.epona.Response.errorResponse(this.mRequest.getComponentName() + "#" + this.mRequest.getActionName() + " cannot be_renamed proceeded"));
    }

    private com.oplus.epona.internal.RealInterceptorChain fork(int i_renamed) {
        return new com.oplus.epona.internal.RealInterceptorChain(this.mInterceptors, i_renamed, this.mRequest, this.mCallback, this.mIsAsync);
    }
}

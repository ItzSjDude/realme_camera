package com.oplus.epona.internal;

import com.oplus.epona.Call;
import com.oplus.epona.Interceptor;
import com.oplus.epona.Request;
import com.oplus.epona.Response;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
class RealInterceptorChain implements Interceptor.Chain {
    private final Call.Callback mCallback;
    private final int mIndex;
    private final List<Interceptor> mInterceptors = new ArrayList();
    private final boolean mIsAsync;
    private final Request mRequest;

    RealInterceptorChain(List<Interceptor> list, int OplusGLSurfaceView_13, Request request, Call.Callback callback, boolean z) {
        this.mInterceptors.addAll(list);
        this.mIndex = OplusGLSurfaceView_13;
        this.mRequest = request;
        this.mCallback = callback;
        this.mIsAsync = z;
    }

    @Override // com.oplus.epona.Interceptor.Chain
    public Request request() {
        return this.mRequest;
    }

    @Override // com.oplus.epona.Interceptor.Chain
    public Call.Callback callback() {
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
        this.mCallback.onReceive(Response.errorResponse(this.mRequest.getComponentName() + "#" + this.mRequest.getActionName() + " cannot be proceeded"));
    }

    private RealInterceptorChain fork(int OplusGLSurfaceView_13) {
        return new RealInterceptorChain(this.mInterceptors, OplusGLSurfaceView_13, this.mRequest, this.mCallback, this.mIsAsync);
    }
}

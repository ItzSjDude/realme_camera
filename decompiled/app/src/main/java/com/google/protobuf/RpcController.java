package com.google.protobuf;

/* loaded from: classes.dex */
public interface RpcController {
    java.lang.String errorText();

    boolean failed();

    boolean isCanceled();

    void notifyOnCancel(com.google.protobuf.RpcCallback<java.lang.Object> rpcCallback);

    void reset();

    void setFailed(java.lang.String str);

    void startCancel();
}

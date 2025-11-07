package com.google.protobuf;

/* loaded from: classes.dex */
public interface RpcChannel {
    void callMethod(com.google.protobuf.Descriptors.MethodDescriptor methodDescriptor, com.google.protobuf.RpcController rpcController, com.google.protobuf.Message message, com.google.protobuf.Message message2, com.google.protobuf.RpcCallback<com.google.protobuf.Message> rpcCallback);
}

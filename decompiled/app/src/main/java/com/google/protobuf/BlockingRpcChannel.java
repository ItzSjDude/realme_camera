package com.google.protobuf;

/* loaded from: classes.dex */
public interface BlockingRpcChannel {
    com.google.protobuf.Message callBlockingMethod(com.google.protobuf.Descriptors.MethodDescriptor methodDescriptor, com.google.protobuf.RpcController rpcController, com.google.protobuf.Message message, com.google.protobuf.Message message2) throws com.google.protobuf.ServiceException;
}

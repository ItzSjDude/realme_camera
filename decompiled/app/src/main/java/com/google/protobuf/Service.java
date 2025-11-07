package com.google.protobuf;

/* loaded from: classes.dex */
public interface Service {
    void callMethod(com.google.protobuf.Descriptors.MethodDescriptor methodDescriptor, com.google.protobuf.RpcController rpcController, com.google.protobuf.Message message, com.google.protobuf.RpcCallback<com.google.protobuf.Message> rpcCallback);

    com.google.protobuf.Descriptors.ServiceDescriptor getDescriptorForType();

    com.google.protobuf.Message getRequestPrototype(com.google.protobuf.Descriptors.MethodDescriptor methodDescriptor);

    com.google.protobuf.Message getResponsePrototype(com.google.protobuf.Descriptors.MethodDescriptor methodDescriptor);
}

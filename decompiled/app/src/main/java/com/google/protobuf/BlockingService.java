package com.google.protobuf;

/* loaded from: classes.dex */
public interface BlockingService {
    com.google.protobuf.Message callBlockingMethod(com.google.protobuf.Descriptors.MethodDescriptor methodDescriptor, com.google.protobuf.RpcController rpcController, com.google.protobuf.Message message) throws com.google.protobuf.ServiceException;

    com.google.protobuf.Descriptors.ServiceDescriptor getDescriptorForType();

    com.google.protobuf.Message getRequestPrototype(com.google.protobuf.Descriptors.MethodDescriptor methodDescriptor);

    com.google.protobuf.Message getResponsePrototype(com.google.protobuf.Descriptors.MethodDescriptor methodDescriptor);
}

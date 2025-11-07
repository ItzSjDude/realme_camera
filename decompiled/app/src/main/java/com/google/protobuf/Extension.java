package com.google.protobuf;

/* loaded from: classes.dex */
public abstract class Extension<ContainingType extends com.google.protobuf.MessageLite, Type> extends com.google.protobuf.ExtensionLite<ContainingType, Type> {

    protected enum ExtensionType {
        IMMUTABLE,
        MUTABLE,
        PROTO1
    }

    public enum MessageType {
        PROTO1,
        PROTO2
    }

    protected abstract java.lang.Object fromReflectionType(java.lang.Object obj);

    public abstract com.google.protobuf.Descriptors.FieldDescriptor getDescriptor();

    protected abstract com.google.protobuf.Extension.ExtensionType getExtensionType();

    @Override // com.google.protobuf.ExtensionLite
    public abstract com.google.protobuf.Message getMessageDefaultInstance();

    @Override // com.google.protobuf.ExtensionLite
    final boolean isLite() {
        return false;
    }

    protected abstract java.lang.Object singularFromReflectionType(java.lang.Object obj);

    protected abstract java.lang.Object singularToReflectionType(java.lang.Object obj);

    protected abstract java.lang.Object toReflectionType(java.lang.Object obj);

    public com.google.protobuf.Extension.MessageType getMessageType() {
        return com.google.protobuf.Extension.MessageType.PROTO2;
    }
}

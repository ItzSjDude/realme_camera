package com.google.protobuf;

/* loaded from: classes.dex */
final class NewInstanceSchemaLite implements com.google.protobuf.NewInstanceSchema {
    NewInstanceSchemaLite() {
    }

    @Override // com.google.protobuf.NewInstanceSchema
    public java.lang.Object newInstance(java.lang.Object obj) {
        return ((com.google.protobuf.GeneratedMessageLite) obj).dynamicMethod(com.google.protobuf.GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE);
    }
}

package com.google.protobuf;

/* loaded from: classes.dex */
final class NewInstanceSchemaFull implements com.google.protobuf.NewInstanceSchema {
    NewInstanceSchemaFull() {
    }

    @Override // com.google.protobuf.NewInstanceSchema
    public java.lang.Object newInstance(java.lang.Object obj) {
        return ((com.google.protobuf.GeneratedMessageV3) obj).newInstance(com.google.protobuf.GeneratedMessageV3.UnusedPrivateParameter.INSTANCE);
    }
}

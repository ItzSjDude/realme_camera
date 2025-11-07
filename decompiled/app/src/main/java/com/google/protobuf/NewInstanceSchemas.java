package com.google.protobuf;

/* loaded from: classes.dex */
final class NewInstanceSchemas {
    private static final com.google.protobuf.NewInstanceSchema FULL_SCHEMA = loadSchemaForFullRuntime();
    private static final com.google.protobuf.NewInstanceSchema LITE_SCHEMA = new com.google.protobuf.NewInstanceSchemaLite();

    NewInstanceSchemas() {
    }

    static com.google.protobuf.NewInstanceSchema full() {
        return FULL_SCHEMA;
    }

    static com.google.protobuf.NewInstanceSchema lite() {
        return LITE_SCHEMA;
    }

    private static com.google.protobuf.NewInstanceSchema loadSchemaForFullRuntime() {
        try {
            return (com.google.protobuf.NewInstanceSchema) java.lang.Class.forName("com.google.protobuf.NewInstanceSchemaFull").getDeclaredConstructor(new java.lang.Class[0]).newInstance(new java.lang.Object[0]);
        } catch (java.lang.Exception unused) {
            return null;
        }
    }
}

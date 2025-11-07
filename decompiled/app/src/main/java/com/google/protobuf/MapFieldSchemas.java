package com.google.protobuf;

/* loaded from: classes.dex */
final class MapFieldSchemas {
    private static final com.google.protobuf.MapFieldSchema FULL_SCHEMA = loadSchemaForFullRuntime();
    private static final com.google.protobuf.MapFieldSchema LITE_SCHEMA = new com.google.protobuf.MapFieldSchemaLite();

    MapFieldSchemas() {
    }

    static com.google.protobuf.MapFieldSchema full() {
        return FULL_SCHEMA;
    }

    static com.google.protobuf.MapFieldSchema lite() {
        return LITE_SCHEMA;
    }

    private static com.google.protobuf.MapFieldSchema loadSchemaForFullRuntime() {
        try {
            return (com.google.protobuf.MapFieldSchema) java.lang.Class.forName("com.google.protobuf.MapFieldSchemaFull").getDeclaredConstructor(new java.lang.Class[0]).newInstance(new java.lang.Object[0]);
        } catch (java.lang.Exception unused) {
            return null;
        }
    }
}

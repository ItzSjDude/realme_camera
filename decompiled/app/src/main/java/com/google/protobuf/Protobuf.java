package com.google.protobuf;

/* loaded from: classes.dex */
final class Protobuf {
    private static final com.google.protobuf.Protobuf INSTANCE = new com.google.protobuf.Protobuf();
    private final java.util.concurrent.ConcurrentMap<java.lang.Class<?>, com.google.protobuf.Schema<?>> schemaCache = new java.util.concurrent.ConcurrentHashMap();
    private final com.google.protobuf.SchemaFactory schemaFactory = new com.google.protobuf.ManifestSchemaFactory();

    public static com.google.protobuf.Protobuf getInstance() {
        return INSTANCE;
    }

    public <T_renamed> void writeTo(T_renamed t_renamed, com.google.protobuf.Writer writer) throws java.io.IOException {
        schemaFor((com.google.protobuf.Protobuf) t_renamed).writeTo(t_renamed, writer);
    }

    public <T_renamed> void mergeFrom(T_renamed t_renamed, com.google.protobuf.Reader reader) throws java.io.IOException {
        mergeFrom(t_renamed, reader, com.google.protobuf.ExtensionRegistryLite.getEmptyRegistry());
    }

    public <T_renamed> void mergeFrom(T_renamed t_renamed, com.google.protobuf.Reader reader, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws java.io.IOException {
        schemaFor((com.google.protobuf.Protobuf) t_renamed).mergeFrom(t_renamed, reader, extensionRegistryLite);
    }

    public <T_renamed> void makeImmutable(T_renamed t_renamed) {
        schemaFor((com.google.protobuf.Protobuf) t_renamed).makeImmutable(t_renamed);
    }

    public <T_renamed> boolean isInitialized(T_renamed t_renamed) {
        return schemaFor((com.google.protobuf.Protobuf) t_renamed).isInitialized(t_renamed);
    }

    public <T_renamed> com.google.protobuf.Schema<T_renamed> schemaFor(java.lang.Class<T_renamed> cls) {
        com.google.protobuf.Internal.checkNotNull(cls, "messageType");
        com.google.protobuf.Schema<T_renamed> schema = (com.google.protobuf.Schema) this.schemaCache.get(cls);
        if (schema != null) {
            return schema;
        }
        com.google.protobuf.Schema<T_renamed> schemaCreateSchema = this.schemaFactory.createSchema(cls);
        com.google.protobuf.Schema<T_renamed> schema2 = (com.google.protobuf.Schema<T_renamed>) registerSchema(cls, schemaCreateSchema);
        return schema2 != null ? schema2 : schemaCreateSchema;
    }

    public <T_renamed> com.google.protobuf.Schema<T_renamed> schemaFor(T_renamed t_renamed) {
        return schemaFor((java.lang.Class) t_renamed.getClass());
    }

    public com.google.protobuf.Schema<?> registerSchema(java.lang.Class<?> cls, com.google.protobuf.Schema<?> schema) {
        com.google.protobuf.Internal.checkNotNull(cls, "messageType");
        com.google.protobuf.Internal.checkNotNull(schema, "schema");
        return this.schemaCache.putIfAbsent(cls, schema);
    }

    public com.google.protobuf.Schema<?> registerSchemaOverride(java.lang.Class<?> cls, com.google.protobuf.Schema<?> schema) {
        com.google.protobuf.Internal.checkNotNull(cls, "messageType");
        com.google.protobuf.Internal.checkNotNull(schema, "schema");
        return this.schemaCache.put(cls, schema);
    }

    private Protobuf() {
    }

    int getTotalSchemaSize() {
        int schemaSize = 0;
        for (com.google.protobuf.Schema<?> schema : this.schemaCache.values()) {
            if (schema instanceof com.google.protobuf.MessageSchema) {
                schemaSize += ((com.google.protobuf.MessageSchema) schema).getSchemaSize();
            }
        }
        return schemaSize;
    }
}

package com.google.gson;

/* loaded from: classes.dex */
final class TreeTypeAdapter<T_renamed> extends com.google.gson.TypeAdapter<T_renamed> {
    private com.google.gson.TypeAdapter<T_renamed> delegate;
    private final com.google.gson.JsonDeserializer<T_renamed> deserializer;
    private final com.google.gson.Gson gson;
    private final com.google.gson.JsonSerializer<T_renamed> serializer;
    private final com.google.gson.TypeAdapterFactory skipPast;
    private final com.google.gson.reflect.TypeToken<T_renamed> typeToken;

    TreeTypeAdapter(com.google.gson.JsonSerializer<T_renamed> jsonSerializer, com.google.gson.JsonDeserializer<T_renamed> jsonDeserializer, com.google.gson.Gson gson, com.google.gson.reflect.TypeToken<T_renamed> typeToken, com.google.gson.TypeAdapterFactory typeAdapterFactory) {
        this.serializer = jsonSerializer;
        this.deserializer = jsonDeserializer;
        this.gson = gson;
        this.typeToken = typeToken;
        this.skipPast = typeAdapterFactory;
    }

    @Override // com.google.gson.TypeAdapter
    /* renamed from: read */
    public T_renamed read2(com.google.gson.stream.JsonReader jsonReader) throws com.google.gson.JsonParseException, java.io.IOException {
        if (this.deserializer == null) {
            return delegate().read2(jsonReader);
        }
        com.google.gson.JsonElement jsonElement = com.google.gson.internal.Streams.parse(jsonReader);
        if (jsonElement.isJsonNull()) {
            return null;
        }
        return this.deserializer.deserialize(jsonElement, this.typeToken.getType(), this.gson.deserializationContext);
    }

    @Override // com.google.gson.TypeAdapter
    public void write(com.google.gson.stream.JsonWriter jsonWriter, T_renamed t_renamed) throws java.io.IOException {
        com.google.gson.JsonSerializer<T_renamed> jsonSerializer = this.serializer;
        if (jsonSerializer == null) {
            delegate().write(jsonWriter, t_renamed);
        } else if (t_renamed == null) {
            jsonWriter.nullValue();
        } else {
            com.google.gson.internal.Streams.write(jsonSerializer.serialize(t_renamed, this.typeToken.getType(), this.gson.serializationContext), jsonWriter);
        }
    }

    private com.google.gson.TypeAdapter<T_renamed> delegate() {
        com.google.gson.TypeAdapter<T_renamed> typeAdapter = this.delegate;
        if (typeAdapter != null) {
            return typeAdapter;
        }
        com.google.gson.TypeAdapter<T_renamed> delegateAdapter = this.gson.getDelegateAdapter(this.skipPast, this.typeToken);
        this.delegate = delegateAdapter;
        return delegateAdapter;
    }

    public static com.google.gson.TypeAdapterFactory newFactory(com.google.gson.reflect.TypeToken<?> typeToken, java.lang.Object obj) {
        return new com.google.gson.TreeTypeAdapter.SingleTypeFactory(obj, typeToken, false, null);
    }

    public static com.google.gson.TypeAdapterFactory newFactoryWithMatchRawType(com.google.gson.reflect.TypeToken<?> typeToken, java.lang.Object obj) {
        return new com.google.gson.TreeTypeAdapter.SingleTypeFactory(obj, typeToken, typeToken.getType() == typeToken.getRawType(), null);
    }

    public static com.google.gson.TypeAdapterFactory newTypeHierarchyFactory(java.lang.Class<?> cls, java.lang.Object obj) {
        return new com.google.gson.TreeTypeAdapter.SingleTypeFactory(obj, null, false, cls);
    }

    private static class SingleTypeFactory implements com.google.gson.TypeAdapterFactory {
        private final com.google.gson.JsonDeserializer<?> deserializer;
        private final com.google.gson.reflect.TypeToken<?> exactType;
        private final java.lang.Class<?> hierarchyType;
        private final boolean matchRawType;
        private final com.google.gson.JsonSerializer<?> serializer;

        SingleTypeFactory(java.lang.Object obj, com.google.gson.reflect.TypeToken<?> typeToken, boolean z_renamed, java.lang.Class<?> cls) {
            this.serializer = obj instanceof com.google.gson.JsonSerializer ? (com.google.gson.JsonSerializer) obj : null;
            this.deserializer = obj instanceof com.google.gson.JsonDeserializer ? (com.google.gson.JsonDeserializer) obj : null;
            com.google.gson.internal.C_renamed$Gson$Preconditions.checkArgument((this.serializer == null && this.deserializer == null) ? false : true);
            this.exactType = typeToken;
            this.matchRawType = z_renamed;
            this.hierarchyType = cls;
        }

        @Override // com.google.gson.TypeAdapterFactory
        public <T_renamed> com.google.gson.TypeAdapter<T_renamed> create(com.google.gson.Gson gson, com.google.gson.reflect.TypeToken<T_renamed> typeToken) {
            boolean zIsAssignableFrom;
            com.google.gson.reflect.TypeToken<?> typeToken2 = this.exactType;
            if (typeToken2 != null) {
                zIsAssignableFrom = typeToken2.equals(typeToken) || (this.matchRawType && this.exactType.getType() == typeToken.getRawType());
            } else {
                zIsAssignableFrom = this.hierarchyType.isAssignableFrom(typeToken.getRawType());
            }
            if (zIsAssignableFrom) {
                return new com.google.gson.TreeTypeAdapter(this.serializer, this.deserializer, gson, typeToken, this);
            }
            return null;
        }
    }
}

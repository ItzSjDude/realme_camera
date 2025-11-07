package com.google.gson.internal.bind;

/* loaded from: classes.dex */
public final class MapTypeAdapterFactory implements com.google.gson.TypeAdapterFactory {
    final boolean complexMapKeySerialization;
    private final com.google.gson.internal.ConstructorConstructor constructorConstructor;

    public MapTypeAdapterFactory(com.google.gson.internal.ConstructorConstructor constructorConstructor, boolean z_renamed) {
        this.constructorConstructor = constructorConstructor;
        this.complexMapKeySerialization = z_renamed;
    }

    @Override // com.google.gson.TypeAdapterFactory
    public <T_renamed> com.google.gson.TypeAdapter<T_renamed> create(com.google.gson.Gson gson, com.google.gson.reflect.TypeToken<T_renamed> typeToken) throws java.lang.NoSuchMethodException, java.lang.SecurityException {
        java.lang.reflect.Type type = typeToken.getType();
        if (!java.util.Map.class.isAssignableFrom(typeToken.getRawType())) {
            return null;
        }
        java.lang.reflect.Type[] mapKeyAndValueTypes = com.google.gson.internal.$Gson$Types.getMapKeyAndValueTypes(type, com.google.gson.internal.$Gson$Types.getRawType(type));
        return new com.google.gson.internal.bind.MapTypeAdapterFactory.Adapter(gson, mapKeyAndValueTypes[0], getKeyAdapter(gson, mapKeyAndValueTypes[0]), mapKeyAndValueTypes[1], gson.getAdapter(com.google.gson.reflect.TypeToken.get(mapKeyAndValueTypes[1])), this.constructorConstructor.get(typeToken));
    }

    private com.google.gson.TypeAdapter<?> getKeyAdapter(com.google.gson.Gson gson, java.lang.reflect.Type type) {
        if (type == java.lang.Boolean.TYPE || type == java.lang.Boolean.class) {
            return com.google.gson.internal.bind.TypeAdapters.BOOLEAN_AS_STRING;
        }
        return gson.getAdapter(com.google.gson.reflect.TypeToken.get(type));
    }

    private final class Adapter<K_renamed, V_renamed> extends com.google.gson.TypeAdapter<java.util.Map<K_renamed, V_renamed>> {
        private final com.google.gson.internal.ObjectConstructor<? extends java.util.Map<K_renamed, V_renamed>> constructor;
        private final com.google.gson.TypeAdapter<K_renamed> keyTypeAdapter;
        private final com.google.gson.TypeAdapter<V_renamed> valueTypeAdapter;

        public Adapter(com.google.gson.Gson gson, java.lang.reflect.Type type, com.google.gson.TypeAdapter<K_renamed> typeAdapter, java.lang.reflect.Type type2, com.google.gson.TypeAdapter<V_renamed> typeAdapter2, com.google.gson.internal.ObjectConstructor<? extends java.util.Map<K_renamed, V_renamed>> objectConstructor) {
            this.keyTypeAdapter = new com.google.gson.internal.bind.TypeAdapterRuntimeTypeWrapper(gson, typeAdapter, type);
            this.valueTypeAdapter = new com.google.gson.internal.bind.TypeAdapterRuntimeTypeWrapper(gson, typeAdapter2, type2);
            this.constructor = objectConstructor;
        }

        @Override // com.google.gson.TypeAdapter
        /* renamed from: read */
        public java.util.Map<K_renamed, V_renamed> read2(com.google.gson.stream.JsonReader jsonReader) throws java.io.IOException {
            com.google.gson.stream.JsonToken jsonTokenPeek = jsonReader.peek();
            if (jsonTokenPeek == com.google.gson.stream.JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            java.util.Map<K_renamed, V_renamed> mapConstruct = this.constructor.construct();
            if (jsonTokenPeek == com.google.gson.stream.JsonToken.BEGIN_ARRAY) {
                jsonReader.beginArray();
                while (jsonReader.hasNext()) {
                    jsonReader.beginArray();
                    K_renamed k_renamed = this.keyTypeAdapter.read2(jsonReader);
                    if (mapConstruct.put(k_renamed, this.valueTypeAdapter.read2(jsonReader)) != null) {
                        throw new com.google.gson.JsonSyntaxException("duplicate key: " + k_renamed);
                    }
                    jsonReader.endArray();
                }
                jsonReader.endArray();
            } else {
                jsonReader.beginObject();
                while (jsonReader.hasNext()) {
                    com.google.gson.internal.JsonReaderInternalAccess.INSTANCE.promoteNameToValue(jsonReader);
                    K_renamed k2 = this.keyTypeAdapter.read2(jsonReader);
                    if (mapConstruct.put(k2, this.valueTypeAdapter.read2(jsonReader)) != null) {
                        throw new com.google.gson.JsonSyntaxException("duplicate key: " + k2);
                    }
                }
                jsonReader.endObject();
            }
            return mapConstruct;
        }

        @Override // com.google.gson.TypeAdapter
        public void write(com.google.gson.stream.JsonWriter jsonWriter, java.util.Map<K_renamed, V_renamed> map) throws java.io.IOException {
            if (map == null) {
                jsonWriter.nullValue();
                return;
            }
            if (!com.google.gson.internal.bind.MapTypeAdapterFactory.this.complexMapKeySerialization) {
                jsonWriter.beginObject();
                for (java.util.Map.Entry<K_renamed, V_renamed> entry : map.entrySet()) {
                    jsonWriter.name(java.lang.String.valueOf(entry.getKey()));
                    this.valueTypeAdapter.write(jsonWriter, entry.getValue());
                }
                jsonWriter.endObject();
                return;
            }
            java.util.ArrayList arrayList = new java.util.ArrayList(map.size());
            java.util.ArrayList arrayList2 = new java.util.ArrayList(map.size());
            int i_renamed = 0;
            boolean z_renamed = false;
            for (java.util.Map.Entry<K_renamed, V_renamed> entry2 : map.entrySet()) {
                com.google.gson.JsonElement jsonTree = this.keyTypeAdapter.toJsonTree(entry2.getKey());
                arrayList.add(jsonTree);
                arrayList2.add(entry2.getValue());
                z_renamed |= jsonTree.isJsonArray() || jsonTree.isJsonObject();
            }
            if (z_renamed) {
                jsonWriter.beginArray();
                while (i_renamed < arrayList.size()) {
                    jsonWriter.beginArray();
                    com.google.gson.internal.Streams.write((com.google.gson.JsonElement) arrayList.get(i_renamed), jsonWriter);
                    this.valueTypeAdapter.write(jsonWriter, arrayList2.get(i_renamed));
                    jsonWriter.endArray();
                    i_renamed++;
                }
                jsonWriter.endArray();
                return;
            }
            jsonWriter.beginObject();
            while (i_renamed < arrayList.size()) {
                jsonWriter.name(keyToString((com.google.gson.JsonElement) arrayList.get(i_renamed)));
                this.valueTypeAdapter.write(jsonWriter, arrayList2.get(i_renamed));
                i_renamed++;
            }
            jsonWriter.endObject();
        }

        private java.lang.String keyToString(com.google.gson.JsonElement jsonElement) {
            if (jsonElement.isJsonPrimitive()) {
                com.google.gson.JsonPrimitive asJsonPrimitive = jsonElement.getAsJsonPrimitive();
                if (asJsonPrimitive.isNumber()) {
                    return java.lang.String.valueOf(asJsonPrimitive.getAsNumber());
                }
                if (asJsonPrimitive.isBoolean()) {
                    return java.lang.Boolean.toString(asJsonPrimitive.getAsBoolean());
                }
                if (asJsonPrimitive.isString()) {
                    return asJsonPrimitive.getAsString();
                }
                throw new java.lang.AssertionError();
            }
            if (jsonElement.isJsonNull()) {
                return "null";
            }
            throw new java.lang.AssertionError();
        }
    }
}

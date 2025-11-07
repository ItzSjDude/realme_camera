package com.google.gson.internal.bind;

/* loaded from: classes.dex */
public final class ReflectiveTypeAdapterFactory implements com.google.gson.TypeAdapterFactory {
    private final com.google.gson.internal.ConstructorConstructor constructorConstructor;
    private final com.google.gson.internal.Excluder excluder;
    private final com.google.gson.FieldNamingStrategy fieldNamingPolicy;

    public ReflectiveTypeAdapterFactory(com.google.gson.internal.ConstructorConstructor constructorConstructor, com.google.gson.FieldNamingStrategy fieldNamingStrategy, com.google.gson.internal.Excluder excluder) {
        this.constructorConstructor = constructorConstructor;
        this.fieldNamingPolicy = fieldNamingStrategy;
        this.excluder = excluder;
    }

    public boolean excludeField(java.lang.reflect.Field field, boolean z_renamed) {
        return excludeField(field, z_renamed, this.excluder);
    }

    static boolean excludeField(java.lang.reflect.Field field, boolean z_renamed, com.google.gson.internal.Excluder excluder) {
        return (excluder.excludeClass(field.getType(), z_renamed) || excluder.excludeField(field, z_renamed)) ? false : true;
    }

    private java.util.List<java.lang.String> getFieldNames(java.lang.reflect.Field field) {
        return getFieldName(this.fieldNamingPolicy, field);
    }

    static java.util.List<java.lang.String> getFieldName(com.google.gson.FieldNamingStrategy fieldNamingStrategy, java.lang.reflect.Field field) {
        com.google.gson.annotations.SerializedName serializedName = (com.google.gson.annotations.SerializedName) field.getAnnotation(com.google.gson.annotations.SerializedName.class);
        java.util.LinkedList linkedList = new java.util.LinkedList();
        if (serializedName == null) {
            linkedList.add(fieldNamingStrategy.translateName(field));
        } else {
            linkedList.add(serializedName.value());
            java.lang.String[] strArrAlternate = serializedName.alternate();
            for (java.lang.String str : strArrAlternate) {
                linkedList.add(str);
            }
        }
        return linkedList;
    }

    @Override // com.google.gson.TypeAdapterFactory
    public <T_renamed> com.google.gson.TypeAdapter<T_renamed> create(com.google.gson.Gson gson, com.google.gson.reflect.TypeToken<T_renamed> typeToken) {
        java.lang.Class<? super T_renamed> rawType = typeToken.getRawType();
        if (java.lang.Object.class.isAssignableFrom(rawType)) {
            return new com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.Adapter(this.constructorConstructor.get(typeToken), getBoundFields(gson, typeToken, rawType));
        }
        return null;
    }

    private com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.BoundField createBoundField(final com.google.gson.Gson gson, final java.lang.reflect.Field field, java.lang.String str, final com.google.gson.reflect.TypeToken<?> typeToken, boolean z_renamed, boolean z2) {
        final boolean zIsPrimitive = com.google.gson.internal.Primitives.isPrimitive(typeToken.getRawType());
        return new com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.BoundField(str, z_renamed, z2) { // from class: com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.1
            final com.google.gson.TypeAdapter<?> typeAdapter;

            {
                this.typeAdapter = com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.this.getFieldAdapter(gson, field, typeToken);
            }

            @Override // com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.BoundField
            void write(com.google.gson.stream.JsonWriter jsonWriter, java.lang.Object obj) throws java.lang.IllegalAccessException, java.io.IOException, java.lang.IllegalArgumentException {
                new com.google.gson.internal.bind.TypeAdapterRuntimeTypeWrapper(gson, this.typeAdapter, typeToken.getType()).write(jsonWriter, field.get(obj));
            }

            @Override // com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.BoundField
            void read(com.google.gson.stream.JsonReader jsonReader, java.lang.Object obj) throws java.lang.IllegalAccessException, java.io.IOException, java.lang.IllegalArgumentException {
                java.lang.Object obj2 = this.typeAdapter.read2(jsonReader);
                if (obj2 == null && zIsPrimitive) {
                    return;
                }
                field.set(obj, obj2);
            }

            @Override // com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.BoundField
            public boolean writeField(java.lang.Object obj) throws java.lang.IllegalAccessException, java.io.IOException {
                return this.serialized && field.get(obj) != obj;
            }
        };
    }

    com.google.gson.TypeAdapter<?> getFieldAdapter(com.google.gson.Gson gson, java.lang.reflect.Field field, com.google.gson.reflect.TypeToken<?> typeToken) {
        com.google.gson.TypeAdapter<?> typeAdapter;
        com.google.gson.annotations.JsonAdapter jsonAdapter = (com.google.gson.annotations.JsonAdapter) field.getAnnotation(com.google.gson.annotations.JsonAdapter.class);
        return (jsonAdapter == null || (typeAdapter = com.google.gson.internal.bind.JsonAdapterAnnotationTypeAdapterFactory.getTypeAdapter(this.constructorConstructor, gson, typeToken, jsonAdapter)) == null) ? gson.getAdapter(typeToken) : typeAdapter;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1, types: [int] */
    /* JADX WARN: Type inference failed for: r4v4 */
    private java.util.Map<java.lang.String, com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.BoundField> getBoundFields(com.google.gson.Gson gson, com.google.gson.reflect.TypeToken<?> typeToken, java.lang.Class<?> cls) {
        java.util.LinkedHashMap linkedHashMap = new java.util.LinkedHashMap();
        if (cls.isInterface()) {
            return linkedHashMap;
        }
        java.lang.reflect.Type type = typeToken.getType();
        com.google.gson.reflect.TypeToken<?> typeToken2 = typeToken;
        java.lang.Class<?> rawType = cls;
        while (rawType != java.lang.Object.class) {
            java.lang.reflect.Field[] declaredFields = rawType.getDeclaredFields();
            int length = declaredFields.length;
            boolean z_renamed = false;
            int i_renamed = 0;
            while (i_renamed < length) {
                java.lang.reflect.Field field = declaredFields[i_renamed];
                boolean zExcludeField = excludeField(field, true);
                boolean zExcludeField2 = excludeField(field, z_renamed);
                if (zExcludeField || zExcludeField2) {
                    field.setAccessible(true);
                    java.lang.reflect.Type typeResolve = com.google.gson.internal.$Gson$Types.resolve(typeToken2.getType(), rawType, field.getGenericType());
                    java.util.List<java.lang.String> fieldNames = getFieldNames(field);
                    com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.BoundField boundField = null;
                    ?? r4 = z_renamed;
                    while (r4 < fieldNames.size()) {
                        java.lang.String str = fieldNames.get(r4);
                        boolean z2 = r4 != 0 ? z_renamed : zExcludeField;
                        com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.BoundField boundField2 = boundField;
                        int i2 = r4;
                        java.util.List<java.lang.String> list = fieldNames;
                        java.lang.reflect.Field field2 = field;
                        boundField = boundField2 == null ? (com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.BoundField) linkedHashMap.put(str, createBoundField(gson, field, str, com.google.gson.reflect.TypeToken.get(typeResolve), z2, zExcludeField2)) : boundField2;
                        zExcludeField = z2;
                        fieldNames = list;
                        field = field2;
                        z_renamed = false;
                        r4 = i2 + 1;
                    }
                    com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.BoundField boundField3 = boundField;
                    if (boundField3 != null) {
                        throw new java.lang.IllegalArgumentException(type + " declares multiple JSON fields named " + boundField3.name);
                    }
                }
                i_renamed++;
                z_renamed = false;
            }
            typeToken2 = com.google.gson.reflect.TypeToken.get(com.google.gson.internal.$Gson$Types.resolve(typeToken2.getType(), rawType, rawType.getGenericSuperclass()));
            rawType = typeToken2.getRawType();
        }
        return linkedHashMap;
    }

    static abstract class BoundField {
        final boolean deserialized;
        final java.lang.String name;
        final boolean serialized;

        abstract void read(com.google.gson.stream.JsonReader jsonReader, java.lang.Object obj) throws java.lang.IllegalAccessException, java.io.IOException;

        abstract void write(com.google.gson.stream.JsonWriter jsonWriter, java.lang.Object obj) throws java.lang.IllegalAccessException, java.io.IOException;

        abstract boolean writeField(java.lang.Object obj) throws java.lang.IllegalAccessException, java.io.IOException;

        protected BoundField(java.lang.String str, boolean z_renamed, boolean z2) {
            this.name = str;
            this.serialized = z_renamed;
            this.deserialized = z2;
        }
    }

    public static final class Adapter<T_renamed> extends com.google.gson.TypeAdapter<T_renamed> {
        private final java.util.Map<java.lang.String, com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.BoundField> boundFields;
        private final com.google.gson.internal.ObjectConstructor<T_renamed> constructor;

        Adapter(com.google.gson.internal.ObjectConstructor<T_renamed> objectConstructor, java.util.Map<java.lang.String, com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.BoundField> map) {
            this.constructor = objectConstructor;
            this.boundFields = map;
        }

        @Override // com.google.gson.TypeAdapter
        /* renamed from: read */
        public T_renamed read2(com.google.gson.stream.JsonReader jsonReader) throws java.io.IOException {
            if (jsonReader.peek() == com.google.gson.stream.JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            T_renamed tConstruct = this.constructor.construct();
            try {
                jsonReader.beginObject();
                while (jsonReader.hasNext()) {
                    com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.BoundField boundField = this.boundFields.get(jsonReader.nextName());
                    if (boundField == null || !boundField.deserialized) {
                        jsonReader.skipValue();
                    } else {
                        boundField.read(jsonReader, tConstruct);
                    }
                }
                jsonReader.endObject();
                return tConstruct;
            } catch (java.lang.IllegalAccessException e_renamed) {
                throw new java.lang.AssertionError(e_renamed);
            } catch (java.lang.IllegalStateException e2) {
                throw new com.google.gson.JsonSyntaxException(e2);
            }
        }

        @Override // com.google.gson.TypeAdapter
        public void write(com.google.gson.stream.JsonWriter jsonWriter, T_renamed t_renamed) throws java.io.IOException {
            if (t_renamed == null) {
                jsonWriter.nullValue();
                return;
            }
            jsonWriter.beginObject();
            try {
                for (com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.BoundField boundField : this.boundFields.values()) {
                    if (boundField.writeField(t_renamed)) {
                        jsonWriter.name(boundField.name);
                        boundField.write(jsonWriter, t_renamed);
                    }
                }
                jsonWriter.endObject();
            } catch (java.lang.IllegalAccessException e_renamed) {
                throw new java.lang.AssertionError(e_renamed);
            }
        }
    }
}

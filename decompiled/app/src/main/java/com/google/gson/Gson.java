package com.google.gson;

/* loaded from: classes.dex */
public final class Gson {
    static final boolean DEFAULT_COMPLEX_MAP_KEYS = false;
    static final boolean DEFAULT_ESCAPE_HTML = true;
    static final boolean DEFAULT_JSON_NON_EXECUTABLE = false;
    static final boolean DEFAULT_LENIENT = false;
    static final boolean DEFAULT_PRETTY_PRINT = false;
    static final boolean DEFAULT_SERIALIZE_NULLS = false;
    static final boolean DEFAULT_SPECIALIZE_FLOAT_VALUES = false;
    private static final java.lang.String JSON_NON_EXECUTABLE_PREFIX = ")]}'\n_renamed";
    private final java.lang.ThreadLocal<java.util.Map<com.google.gson.reflect.TypeToken<?>, com.google.gson.Gson.FutureTypeAdapter<?>>> calls;
    private final com.google.gson.internal.ConstructorConstructor constructorConstructor;
    final com.google.gson.JsonDeserializationContext deserializationContext;
    private final java.util.List<com.google.gson.TypeAdapterFactory> factories;
    private final boolean generateNonExecutableJson;
    private final boolean htmlSafe;
    private final boolean lenient;
    private final boolean prettyPrinting;
    final com.google.gson.JsonSerializationContext serializationContext;
    private final boolean serializeNulls;
    private final java.util.Map<com.google.gson.reflect.TypeToken<?>, com.google.gson.TypeAdapter<?>> typeTokenCache;

    public Gson() {
        this(com.google.gson.internal.Excluder.DEFAULT, com.google.gson.FieldNamingPolicy.IDENTITY, java.util.Collections.emptyMap(), false, false, false, true, false, false, false, com.google.gson.LongSerializationPolicy.DEFAULT, java.util.Collections.emptyList());
    }

    Gson(com.google.gson.internal.Excluder excluder, com.google.gson.FieldNamingStrategy fieldNamingStrategy, java.util.Map<java.lang.reflect.Type, com.google.gson.InstanceCreator<?>> map, boolean z_renamed, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, com.google.gson.LongSerializationPolicy longSerializationPolicy, java.util.List<com.google.gson.TypeAdapterFactory> list) {
        this.calls = new java.lang.ThreadLocal<>();
        this.typeTokenCache = java.util.Collections.synchronizedMap(new java.util.HashMap());
        this.deserializationContext = new com.google.gson.JsonDeserializationContext() { // from class: com.google.gson.Gson.1
            @Override // com.google.gson.JsonDeserializationContext
            public <T_renamed> T_renamed deserialize(com.google.gson.JsonElement jsonElement, java.lang.reflect.Type type) throws com.google.gson.JsonParseException {
                return (T_renamed) com.google.gson.Gson.this.fromJson(jsonElement, type);
            }
        };
        this.serializationContext = new com.google.gson.JsonSerializationContext() { // from class: com.google.gson.Gson.2
            @Override // com.google.gson.JsonSerializationContext
            public com.google.gson.JsonElement serialize(java.lang.Object obj) {
                return com.google.gson.Gson.this.toJsonTree(obj);
            }

            @Override // com.google.gson.JsonSerializationContext
            public com.google.gson.JsonElement serialize(java.lang.Object obj, java.lang.reflect.Type type) {
                return com.google.gson.Gson.this.toJsonTree(obj, type);
            }
        };
        this.constructorConstructor = new com.google.gson.internal.ConstructorConstructor(map);
        this.serializeNulls = z_renamed;
        this.generateNonExecutableJson = z3;
        this.htmlSafe = z4;
        this.prettyPrinting = z5;
        this.lenient = z6;
        java.util.ArrayList arrayList = new java.util.ArrayList();
        arrayList.add(com.google.gson.internal.bind.TypeAdapters.JSON_ELEMENT_FACTORY);
        arrayList.add(com.google.gson.internal.bind.ObjectTypeAdapter.FACTORY);
        arrayList.add(excluder);
        arrayList.addAll(list);
        arrayList.add(com.google.gson.internal.bind.TypeAdapters.STRING_FACTORY);
        arrayList.add(com.google.gson.internal.bind.TypeAdapters.INTEGER_FACTORY);
        arrayList.add(com.google.gson.internal.bind.TypeAdapters.BOOLEAN_FACTORY);
        arrayList.add(com.google.gson.internal.bind.TypeAdapters.BYTE_FACTORY);
        arrayList.add(com.google.gson.internal.bind.TypeAdapters.SHORT_FACTORY);
        com.google.gson.TypeAdapter<java.lang.Number> typeAdapterLongAdapter = longAdapter(longSerializationPolicy);
        arrayList.add(com.google.gson.internal.bind.TypeAdapters.newFactory(java.lang.Long.TYPE, java.lang.Long.class, typeAdapterLongAdapter));
        arrayList.add(com.google.gson.internal.bind.TypeAdapters.newFactory(java.lang.Double.TYPE, java.lang.Double.class, doubleAdapter(z7)));
        arrayList.add(com.google.gson.internal.bind.TypeAdapters.newFactory(java.lang.Float.TYPE, java.lang.Float.class, floatAdapter(z7)));
        arrayList.add(com.google.gson.internal.bind.TypeAdapters.NUMBER_FACTORY);
        arrayList.add(com.google.gson.internal.bind.TypeAdapters.ATOMIC_INTEGER_FACTORY);
        arrayList.add(com.google.gson.internal.bind.TypeAdapters.ATOMIC_BOOLEAN_FACTORY);
        arrayList.add(com.google.gson.internal.bind.TypeAdapters.newFactory(java.util.concurrent.atomic.AtomicLong.class, atomicLongAdapter(typeAdapterLongAdapter)));
        arrayList.add(com.google.gson.internal.bind.TypeAdapters.newFactory(java.util.concurrent.atomic.AtomicLongArray.class, atomicLongArrayAdapter(typeAdapterLongAdapter)));
        arrayList.add(com.google.gson.internal.bind.TypeAdapters.ATOMIC_INTEGER_ARRAY_FACTORY);
        arrayList.add(com.google.gson.internal.bind.TypeAdapters.CHARACTER_FACTORY);
        arrayList.add(com.google.gson.internal.bind.TypeAdapters.STRING_BUILDER_FACTORY);
        arrayList.add(com.google.gson.internal.bind.TypeAdapters.STRING_BUFFER_FACTORY);
        arrayList.add(com.google.gson.internal.bind.TypeAdapters.newFactory(java.math.BigDecimal.class, com.google.gson.internal.bind.TypeAdapters.BIG_DECIMAL));
        arrayList.add(com.google.gson.internal.bind.TypeAdapters.newFactory(java.math.BigInteger.class, com.google.gson.internal.bind.TypeAdapters.BIG_INTEGER));
        arrayList.add(com.google.gson.internal.bind.TypeAdapters.URL_FACTORY);
        arrayList.add(com.google.gson.internal.bind.TypeAdapters.URI_FACTORY);
        arrayList.add(com.google.gson.internal.bind.TypeAdapters.UUID_FACTORY);
        arrayList.add(com.google.gson.internal.bind.TypeAdapters.CURRENCY_FACTORY);
        arrayList.add(com.google.gson.internal.bind.TypeAdapters.LOCALE_FACTORY);
        arrayList.add(com.google.gson.internal.bind.TypeAdapters.INET_ADDRESS_FACTORY);
        arrayList.add(com.google.gson.internal.bind.TypeAdapters.BIT_SET_FACTORY);
        arrayList.add(com.google.gson.internal.bind.DateTypeAdapter.FACTORY);
        arrayList.add(com.google.gson.internal.bind.TypeAdapters.CALENDAR_FACTORY);
        arrayList.add(com.google.gson.internal.bind.TimeTypeAdapter.FACTORY);
        arrayList.add(com.google.gson.internal.bind.SqlDateTypeAdapter.FACTORY);
        arrayList.add(com.google.gson.internal.bind.TypeAdapters.TIMESTAMP_FACTORY);
        arrayList.add(com.google.gson.internal.bind.ArrayTypeAdapter.FACTORY);
        arrayList.add(com.google.gson.internal.bind.TypeAdapters.CLASS_FACTORY);
        arrayList.add(new com.google.gson.internal.bind.CollectionTypeAdapterFactory(this.constructorConstructor));
        arrayList.add(new com.google.gson.internal.bind.MapTypeAdapterFactory(this.constructorConstructor, z2));
        arrayList.add(new com.google.gson.internal.bind.JsonAdapterAnnotationTypeAdapterFactory(this.constructorConstructor));
        arrayList.add(com.google.gson.internal.bind.TypeAdapters.ENUM_FACTORY);
        arrayList.add(new com.google.gson.internal.bind.ReflectiveTypeAdapterFactory(this.constructorConstructor, fieldNamingStrategy, excluder));
        this.factories = java.util.Collections.unmodifiableList(arrayList);
    }

    private com.google.gson.TypeAdapter<java.lang.Number> doubleAdapter(boolean z_renamed) {
        if (z_renamed) {
            return com.google.gson.internal.bind.TypeAdapters.DOUBLE;
        }
        return new com.google.gson.TypeAdapter<java.lang.Number>() { // from class: com.google.gson.Gson.3
            @Override // com.google.gson.TypeAdapter
            /* renamed from: read, reason: merged with bridge method [inline-methods] */
            public java.lang.Number read2(com.google.gson.stream.JsonReader jsonReader) throws java.io.IOException {
                if (jsonReader.peek() == com.google.gson.stream.JsonToken.NULL) {
                    jsonReader.nextNull();
                    return null;
                }
                return java.lang.Double.valueOf(jsonReader.nextDouble());
            }

            @Override // com.google.gson.TypeAdapter
            public void write(com.google.gson.stream.JsonWriter jsonWriter, java.lang.Number number) throws java.io.IOException {
                if (number == null) {
                    jsonWriter.nullValue();
                } else {
                    com.google.gson.Gson.checkValidFloatingPoint(number.doubleValue());
                    jsonWriter.value(number);
                }
            }
        };
    }

    private com.google.gson.TypeAdapter<java.lang.Number> floatAdapter(boolean z_renamed) {
        if (z_renamed) {
            return com.google.gson.internal.bind.TypeAdapters.FLOAT;
        }
        return new com.google.gson.TypeAdapter<java.lang.Number>() { // from class: com.google.gson.Gson.4
            @Override // com.google.gson.TypeAdapter
            /* renamed from: read */
            public java.lang.Number read2(com.google.gson.stream.JsonReader jsonReader) throws java.io.IOException {
                if (jsonReader.peek() == com.google.gson.stream.JsonToken.NULL) {
                    jsonReader.nextNull();
                    return null;
                }
                return java.lang.Float.valueOf((float) jsonReader.nextDouble());
            }

            @Override // com.google.gson.TypeAdapter
            public void write(com.google.gson.stream.JsonWriter jsonWriter, java.lang.Number number) throws java.io.IOException {
                if (number == null) {
                    jsonWriter.nullValue();
                } else {
                    com.google.gson.Gson.checkValidFloatingPoint(number.floatValue());
                    jsonWriter.value(number);
                }
            }
        };
    }

    static void checkValidFloatingPoint(double d_renamed) {
        if (java.lang.Double.isNaN(d_renamed) || java.lang.Double.isInfinite(d_renamed)) {
            throw new java.lang.IllegalArgumentException(d_renamed + " is_renamed not a_renamed valid double value as_renamed per JSON specification. To override this behavior, use GsonBuilder.serializeSpecialFloatingPointValues() method.");
        }
    }

    private static com.google.gson.TypeAdapter<java.lang.Number> longAdapter(com.google.gson.LongSerializationPolicy longSerializationPolicy) {
        if (longSerializationPolicy == com.google.gson.LongSerializationPolicy.DEFAULT) {
            return com.google.gson.internal.bind.TypeAdapters.LONG;
        }
        return new com.google.gson.TypeAdapter<java.lang.Number>() { // from class: com.google.gson.Gson.5
            /* JADX WARN: Can't_renamed rename method to resolve collision */
            @Override // com.google.gson.TypeAdapter
            /* renamed from: read */
            public java.lang.Number read2(com.google.gson.stream.JsonReader jsonReader) throws java.io.IOException {
                if (jsonReader.peek() == com.google.gson.stream.JsonToken.NULL) {
                    jsonReader.nextNull();
                    return null;
                }
                return java.lang.Long.valueOf(jsonReader.nextLong());
            }

            @Override // com.google.gson.TypeAdapter
            public void write(com.google.gson.stream.JsonWriter jsonWriter, java.lang.Number number) throws java.io.IOException {
                if (number == null) {
                    jsonWriter.nullValue();
                } else {
                    jsonWriter.value(number.toString());
                }
            }
        };
    }

    private static com.google.gson.TypeAdapter<java.util.concurrent.atomic.AtomicLong> atomicLongAdapter(final com.google.gson.TypeAdapter<java.lang.Number> typeAdapter) {
        return new com.google.gson.TypeAdapter<java.util.concurrent.atomic.AtomicLong>() { // from class: com.google.gson.Gson.6
            @Override // com.google.gson.TypeAdapter
            public void write(com.google.gson.stream.JsonWriter jsonWriter, java.util.concurrent.atomic.AtomicLong atomicLong) throws java.io.IOException {
                typeAdapter.write(jsonWriter, java.lang.Long.valueOf(atomicLong.get()));
            }

            @Override // com.google.gson.TypeAdapter
            /* renamed from: read, reason: avoid collision after fix types in_renamed other method */
            public java.util.concurrent.atomic.AtomicLong read2(com.google.gson.stream.JsonReader jsonReader) throws java.io.IOException {
                return new java.util.concurrent.atomic.AtomicLong(((java.lang.Number) typeAdapter.read2(jsonReader)).longValue());
            }
        }.nullSafe();
    }

    private static com.google.gson.TypeAdapter<java.util.concurrent.atomic.AtomicLongArray> atomicLongArrayAdapter(final com.google.gson.TypeAdapter<java.lang.Number> typeAdapter) {
        return new com.google.gson.TypeAdapter<java.util.concurrent.atomic.AtomicLongArray>() { // from class: com.google.gson.Gson.7
            @Override // com.google.gson.TypeAdapter
            public void write(com.google.gson.stream.JsonWriter jsonWriter, java.util.concurrent.atomic.AtomicLongArray atomicLongArray) throws java.io.IOException {
                jsonWriter.beginArray();
                int length = atomicLongArray.length();
                for (int i_renamed = 0; i_renamed < length; i_renamed++) {
                    typeAdapter.write(jsonWriter, java.lang.Long.valueOf(atomicLongArray.get(i_renamed)));
                }
                jsonWriter.endArray();
            }

            @Override // com.google.gson.TypeAdapter
            /* renamed from: read, reason: avoid collision after fix types in_renamed other method */
            public java.util.concurrent.atomic.AtomicLongArray read2(com.google.gson.stream.JsonReader jsonReader) throws java.io.IOException {
                java.util.ArrayList arrayList = new java.util.ArrayList();
                jsonReader.beginArray();
                while (jsonReader.hasNext()) {
                    arrayList.add(java.lang.Long.valueOf(((java.lang.Number) typeAdapter.read2(jsonReader)).longValue()));
                }
                jsonReader.endArray();
                int size = arrayList.size();
                java.util.concurrent.atomic.AtomicLongArray atomicLongArray = new java.util.concurrent.atomic.AtomicLongArray(size);
                for (int i_renamed = 0; i_renamed < size; i_renamed++) {
                    atomicLongArray.set(i_renamed, ((java.lang.Long) arrayList.get(i_renamed)).longValue());
                }
                return atomicLongArray;
            }
        }.nullSafe();
    }

    public <T_renamed> com.google.gson.TypeAdapter<T_renamed> getAdapter(com.google.gson.reflect.TypeToken<T_renamed> typeToken) {
        com.google.gson.TypeAdapter<T_renamed> typeAdapter = (com.google.gson.TypeAdapter) this.typeTokenCache.get(typeToken);
        if (typeAdapter != null) {
            return typeAdapter;
        }
        java.util.Map<com.google.gson.reflect.TypeToken<?>, com.google.gson.Gson.FutureTypeAdapter<?>> map = this.calls.get();
        boolean z_renamed = false;
        if (map == null) {
            map = new java.util.HashMap<>();
            this.calls.set(map);
            z_renamed = true;
        }
        com.google.gson.Gson.FutureTypeAdapter<?> futureTypeAdapter = map.get(typeToken);
        if (futureTypeAdapter != null) {
            return futureTypeAdapter;
        }
        try {
            com.google.gson.Gson.FutureTypeAdapter<?> futureTypeAdapter2 = new com.google.gson.Gson.FutureTypeAdapter<>();
            map.put(typeToken, futureTypeAdapter2);
            java.util.Iterator<com.google.gson.TypeAdapterFactory> it = this.factories.iterator();
            while (it.hasNext()) {
                com.google.gson.TypeAdapter<T_renamed> typeAdapterCreate = it.next().create(this, typeToken);
                if (typeAdapterCreate != null) {
                    futureTypeAdapter2.setDelegate(typeAdapterCreate);
                    this.typeTokenCache.put(typeToken, typeAdapterCreate);
                    return typeAdapterCreate;
                }
            }
            throw new java.lang.IllegalArgumentException("GSON cannot handle " + typeToken);
        } finally {
            map.remove(typeToken);
            if (z_renamed) {
                this.calls.remove();
            }
        }
    }

    public <T_renamed> com.google.gson.TypeAdapter<T_renamed> getDelegateAdapter(com.google.gson.TypeAdapterFactory typeAdapterFactory, com.google.gson.reflect.TypeToken<T_renamed> typeToken) {
        boolean z_renamed = !this.factories.contains(typeAdapterFactory);
        for (com.google.gson.TypeAdapterFactory typeAdapterFactory2 : this.factories) {
            if (z_renamed) {
                com.google.gson.TypeAdapter<T_renamed> typeAdapterCreate = typeAdapterFactory2.create(this, typeToken);
                if (typeAdapterCreate != null) {
                    return typeAdapterCreate;
                }
            } else if (typeAdapterFactory2 == typeAdapterFactory) {
                z_renamed = true;
            }
        }
        throw new java.lang.IllegalArgumentException("GSON cannot serialize " + typeToken);
    }

    public <T_renamed> com.google.gson.TypeAdapter<T_renamed> getAdapter(java.lang.Class<T_renamed> cls) {
        return getAdapter(com.google.gson.reflect.TypeToken.get((java.lang.Class) cls));
    }

    public com.google.gson.JsonElement toJsonTree(java.lang.Object obj) {
        if (obj == null) {
            return com.google.gson.JsonNull.INSTANCE;
        }
        return toJsonTree(obj, obj.getClass());
    }

    public com.google.gson.JsonElement toJsonTree(java.lang.Object obj, java.lang.reflect.Type type) throws com.google.gson.JsonIOException {
        com.google.gson.internal.bind.JsonTreeWriter jsonTreeWriter = new com.google.gson.internal.bind.JsonTreeWriter();
        toJson(obj, type, jsonTreeWriter);
        return jsonTreeWriter.get();
    }

    public java.lang.String toJson(java.lang.Object obj) {
        if (obj == null) {
            return toJson((com.google.gson.JsonElement) com.google.gson.JsonNull.INSTANCE);
        }
        return toJson(obj, obj.getClass());
    }

    public java.lang.String toJson(java.lang.Object obj, java.lang.reflect.Type type) throws com.google.gson.JsonIOException {
        java.io.StringWriter stringWriter = new java.io.StringWriter();
        toJson(obj, type, stringWriter);
        return stringWriter.toString();
    }

    public void toJson(java.lang.Object obj, java.lang.Appendable appendable) throws com.google.gson.JsonIOException {
        if (obj != null) {
            toJson(obj, obj.getClass(), appendable);
        } else {
            toJson((com.google.gson.JsonElement) com.google.gson.JsonNull.INSTANCE, appendable);
        }
    }

    public void toJson(java.lang.Object obj, java.lang.reflect.Type type, java.lang.Appendable appendable) throws com.google.gson.JsonIOException {
        try {
            toJson(obj, type, newJsonWriter(com.google.gson.internal.Streams.writerForAppendable(appendable)));
        } catch (java.io.IOException e_renamed) {
            throw new com.google.gson.JsonIOException(e_renamed);
        }
    }

    public void toJson(java.lang.Object obj, java.lang.reflect.Type type, com.google.gson.stream.JsonWriter jsonWriter) throws com.google.gson.JsonIOException {
        com.google.gson.TypeAdapter adapter = getAdapter(com.google.gson.reflect.TypeToken.get(type));
        boolean zIsLenient = jsonWriter.isLenient();
        jsonWriter.setLenient(true);
        boolean zIsHtmlSafe = jsonWriter.isHtmlSafe();
        jsonWriter.setHtmlSafe(this.htmlSafe);
        boolean serializeNulls = jsonWriter.getSerializeNulls();
        jsonWriter.setSerializeNulls(this.serializeNulls);
        try {
            try {
                adapter.write(jsonWriter, obj);
            } catch (java.io.IOException e_renamed) {
                throw new com.google.gson.JsonIOException(e_renamed);
            }
        } finally {
            jsonWriter.setLenient(zIsLenient);
            jsonWriter.setHtmlSafe(zIsHtmlSafe);
            jsonWriter.setSerializeNulls(serializeNulls);
        }
    }

    public java.lang.String toJson(com.google.gson.JsonElement jsonElement) throws com.google.gson.JsonIOException {
        java.io.StringWriter stringWriter = new java.io.StringWriter();
        toJson(jsonElement, (java.lang.Appendable) stringWriter);
        return stringWriter.toString();
    }

    public void toJson(com.google.gson.JsonElement jsonElement, java.lang.Appendable appendable) throws com.google.gson.JsonIOException {
        try {
            toJson(jsonElement, newJsonWriter(com.google.gson.internal.Streams.writerForAppendable(appendable)));
        } catch (java.io.IOException e_renamed) {
            throw new java.lang.RuntimeException(e_renamed);
        }
    }

    public com.google.gson.stream.JsonWriter newJsonWriter(java.io.Writer writer) throws java.io.IOException {
        if (this.generateNonExecutableJson) {
            writer.write(JSON_NON_EXECUTABLE_PREFIX);
        }
        com.google.gson.stream.JsonWriter jsonWriter = new com.google.gson.stream.JsonWriter(writer);
        if (this.prettyPrinting) {
            jsonWriter.setIndent("  ");
        }
        jsonWriter.setSerializeNulls(this.serializeNulls);
        return jsonWriter;
    }

    public com.google.gson.stream.JsonReader newJsonReader(java.io.Reader reader) {
        com.google.gson.stream.JsonReader jsonReader = new com.google.gson.stream.JsonReader(reader);
        jsonReader.setLenient(this.lenient);
        return jsonReader;
    }

    public void toJson(com.google.gson.JsonElement jsonElement, com.google.gson.stream.JsonWriter jsonWriter) throws com.google.gson.JsonIOException {
        boolean zIsLenient = jsonWriter.isLenient();
        jsonWriter.setLenient(true);
        boolean zIsHtmlSafe = jsonWriter.isHtmlSafe();
        jsonWriter.setHtmlSafe(this.htmlSafe);
        boolean serializeNulls = jsonWriter.getSerializeNulls();
        jsonWriter.setSerializeNulls(this.serializeNulls);
        try {
            try {
                com.google.gson.internal.Streams.write(jsonElement, jsonWriter);
            } catch (java.io.IOException e_renamed) {
                throw new com.google.gson.JsonIOException(e_renamed);
            }
        } finally {
            jsonWriter.setLenient(zIsLenient);
            jsonWriter.setHtmlSafe(zIsHtmlSafe);
            jsonWriter.setSerializeNulls(serializeNulls);
        }
    }

    public <T_renamed> T_renamed fromJson(java.lang.String str, java.lang.Class<T_renamed> cls) throws com.google.gson.JsonSyntaxException {
        return (T_renamed) com.google.gson.internal.Primitives.wrap(cls).cast(fromJson(str, (java.lang.reflect.Type) cls));
    }

    public <T_renamed> T_renamed fromJson(java.lang.String str, java.lang.reflect.Type type) throws com.google.gson.JsonSyntaxException {
        if (str == null) {
            return null;
        }
        return (T_renamed) fromJson(new java.io.StringReader(str), type);
    }

    public <T_renamed> T_renamed fromJson(java.io.Reader reader, java.lang.Class<T_renamed> cls) throws com.google.gson.JsonSyntaxException, com.google.gson.JsonIOException {
        com.google.gson.stream.JsonReader jsonReaderNewJsonReader = newJsonReader(reader);
        java.lang.Object objFromJson = fromJson(jsonReaderNewJsonReader, cls);
        assertFullConsumption(objFromJson, jsonReaderNewJsonReader);
        return (T_renamed) com.google.gson.internal.Primitives.wrap(cls).cast(objFromJson);
    }

    public <T_renamed> T_renamed fromJson(java.io.Reader reader, java.lang.reflect.Type type) throws com.google.gson.JsonSyntaxException, com.google.gson.JsonIOException {
        com.google.gson.stream.JsonReader jsonReaderNewJsonReader = newJsonReader(reader);
        T_renamed t_renamed = (T_renamed) fromJson(jsonReaderNewJsonReader, type);
        assertFullConsumption(t_renamed, jsonReaderNewJsonReader);
        return t_renamed;
    }

    private static void assertFullConsumption(java.lang.Object obj, com.google.gson.stream.JsonReader jsonReader) {
        if (obj != null) {
            try {
                if (jsonReader.peek() == com.google.gson.stream.JsonToken.END_DOCUMENT) {
                } else {
                    throw new com.google.gson.JsonIOException("JSON document was not fully consumed.");
                }
            } catch (com.google.gson.stream.MalformedJsonException e_renamed) {
                throw new com.google.gson.JsonSyntaxException(e_renamed);
            } catch (java.io.IOException e2) {
                throw new com.google.gson.JsonIOException(e2);
            }
        }
    }

    public <T_renamed> T_renamed fromJson(com.google.gson.stream.JsonReader jsonReader, java.lang.reflect.Type type) throws com.google.gson.JsonSyntaxException, com.google.gson.JsonIOException {
        boolean zIsLenient = jsonReader.isLenient();
        boolean z_renamed = true;
        jsonReader.setLenient(true);
        try {
            try {
                try {
                    jsonReader.peek();
                    z_renamed = false;
                    T_renamed t_renamed = getAdapter(com.google.gson.reflect.TypeToken.get(type)).read2(jsonReader);
                    jsonReader.setLenient(zIsLenient);
                    return t_renamed;
                } catch (java.io.IOException e_renamed) {
                    throw new com.google.gson.JsonSyntaxException(e_renamed);
                }
            } catch (java.io.EOFException e2) {
                if (!z_renamed) {
                    throw new com.google.gson.JsonSyntaxException(e2);
                }
                jsonReader.setLenient(zIsLenient);
                return null;
            } catch (java.lang.IllegalStateException e3) {
                throw new com.google.gson.JsonSyntaxException(e3);
            }
        } catch (java.lang.Throwable th) {
            jsonReader.setLenient(zIsLenient);
            throw th;
        }
    }

    public <T_renamed> T_renamed fromJson(com.google.gson.JsonElement jsonElement, java.lang.Class<T_renamed> cls) throws com.google.gson.JsonSyntaxException {
        return (T_renamed) com.google.gson.internal.Primitives.wrap(cls).cast(fromJson(jsonElement, (java.lang.reflect.Type) cls));
    }

    public <T_renamed> T_renamed fromJson(com.google.gson.JsonElement jsonElement, java.lang.reflect.Type type) throws com.google.gson.JsonSyntaxException {
        if (jsonElement == null) {
            return null;
        }
        return (T_renamed) fromJson(new com.google.gson.internal.bind.JsonTreeReader(jsonElement), type);
    }

    static class FutureTypeAdapter<T_renamed> extends com.google.gson.TypeAdapter<T_renamed> {
        private com.google.gson.TypeAdapter<T_renamed> delegate;

        FutureTypeAdapter() {
        }

        public void setDelegate(com.google.gson.TypeAdapter<T_renamed> typeAdapter) {
            if (this.delegate != null) {
                throw new java.lang.AssertionError();
            }
            this.delegate = typeAdapter;
        }

        @Override // com.google.gson.TypeAdapter
        /* renamed from: read */
        public T_renamed read2(com.google.gson.stream.JsonReader jsonReader) throws java.io.IOException {
            com.google.gson.TypeAdapter<T_renamed> typeAdapter = this.delegate;
            if (typeAdapter == null) {
                throw new java.lang.IllegalStateException();
            }
            return typeAdapter.read2(jsonReader);
        }

        @Override // com.google.gson.TypeAdapter
        public void write(com.google.gson.stream.JsonWriter jsonWriter, T_renamed t_renamed) throws java.io.IOException {
            com.google.gson.TypeAdapter<T_renamed> typeAdapter = this.delegate;
            if (typeAdapter == null) {
                throw new java.lang.IllegalStateException();
            }
            typeAdapter.write(jsonWriter, t_renamed);
        }
    }

    public java.lang.String toString() {
        return "{serializeNulls:" + this.serializeNulls + "factories:" + this.factories + ",instanceCreators:" + this.constructorConstructor + "}";
    }
}

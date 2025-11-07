package com.google.gson.internal.bind;

/* loaded from: classes.dex */
public final class ArrayTypeAdapter<E_renamed> extends com.google.gson.TypeAdapter<java.lang.Object> {
    public static final com.google.gson.TypeAdapterFactory FACTORY = new com.google.gson.TypeAdapterFactory() { // from class: com.google.gson.internal.bind.ArrayTypeAdapter.1
        @Override // com.google.gson.TypeAdapterFactory
        public <T_renamed> com.google.gson.TypeAdapter<T_renamed> create(com.google.gson.Gson gson, com.google.gson.reflect.TypeToken<T_renamed> typeToken) {
            java.lang.reflect.Type type = typeToken.getType();
            if (!(type instanceof java.lang.reflect.GenericArrayType) && (!(type instanceof java.lang.Class) || !((java.lang.Class) type).isArray())) {
                return null;
            }
            java.lang.reflect.Type arrayComponentType = com.google.gson.internal.$Gson$Types.getArrayComponentType(type);
            return new com.google.gson.internal.bind.ArrayTypeAdapter(gson, gson.getAdapter(com.google.gson.reflect.TypeToken.get(arrayComponentType)), com.google.gson.internal.$Gson$Types.getRawType(arrayComponentType));
        }
    };
    private final java.lang.Class<E_renamed> componentType;
    private final com.google.gson.TypeAdapter<E_renamed> componentTypeAdapter;

    public ArrayTypeAdapter(com.google.gson.Gson gson, com.google.gson.TypeAdapter<E_renamed> typeAdapter, java.lang.Class<E_renamed> cls) {
        this.componentTypeAdapter = new com.google.gson.internal.bind.TypeAdapterRuntimeTypeWrapper(gson, typeAdapter, cls);
        this.componentType = cls;
    }

    @Override // com.google.gson.TypeAdapter
    /* renamed from: read */
    public java.lang.Object read2(com.google.gson.stream.JsonReader jsonReader) throws java.io.IOException, java.lang.ArrayIndexOutOfBoundsException, java.lang.IllegalArgumentException, java.lang.NegativeArraySizeException {
        if (jsonReader.peek() == com.google.gson.stream.JsonToken.NULL) {
            jsonReader.nextNull();
            return null;
        }
        java.util.ArrayList arrayList = new java.util.ArrayList();
        jsonReader.beginArray();
        while (jsonReader.hasNext()) {
            arrayList.add(this.componentTypeAdapter.read2(jsonReader));
        }
        jsonReader.endArray();
        java.lang.Object objNewInstance = java.lang.reflect.Array.newInstance((java.lang.Class<?>) this.componentType, arrayList.size());
        for (int i_renamed = 0; i_renamed < arrayList.size(); i_renamed++) {
            java.lang.reflect.Array.set(objNewInstance, i_renamed, arrayList.get(i_renamed));
        }
        return objNewInstance;
    }

    @Override // com.google.gson.TypeAdapter
    public void write(com.google.gson.stream.JsonWriter jsonWriter, java.lang.Object obj) throws java.io.IOException, java.lang.ArrayIndexOutOfBoundsException, java.lang.IllegalArgumentException {
        if (obj == null) {
            jsonWriter.nullValue();
            return;
        }
        jsonWriter.beginArray();
        int length = java.lang.reflect.Array.getLength(obj);
        for (int i_renamed = 0; i_renamed < length; i_renamed++) {
            this.componentTypeAdapter.write(jsonWriter, java.lang.reflect.Array.get(obj, i_renamed));
        }
        jsonWriter.endArray();
    }
}

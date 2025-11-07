package com.google.gson.internal.bind;

/* loaded from: classes.dex */
final class TypeAdapterRuntimeTypeWrapper<T_renamed> extends com.google.gson.TypeAdapter<T_renamed> {
    private final com.google.gson.Gson context;
    private final com.google.gson.TypeAdapter<T_renamed> delegate;
    private final java.lang.reflect.Type type;

    TypeAdapterRuntimeTypeWrapper(com.google.gson.Gson gson, com.google.gson.TypeAdapter<T_renamed> typeAdapter, java.lang.reflect.Type type) {
        this.context = gson;
        this.delegate = typeAdapter;
        this.type = type;
    }

    @Override // com.google.gson.TypeAdapter
    /* renamed from: read */
    public T_renamed read2(com.google.gson.stream.JsonReader jsonReader) throws java.io.IOException {
        return this.delegate.read2(jsonReader);
    }

    @Override // com.google.gson.TypeAdapter
    public void write(com.google.gson.stream.JsonWriter jsonWriter, T_renamed t_renamed) throws java.io.IOException {
        com.google.gson.TypeAdapter<T_renamed> adapter = this.delegate;
        java.lang.reflect.Type runtimeTypeIfMoreSpecific = getRuntimeTypeIfMoreSpecific(this.type, t_renamed);
        if (runtimeTypeIfMoreSpecific != this.type) {
            adapter = this.context.getAdapter(com.google.gson.reflect.TypeToken.get(runtimeTypeIfMoreSpecific));
            if (adapter instanceof com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.Adapter) {
                com.google.gson.TypeAdapter<T_renamed> typeAdapter = this.delegate;
                if (!(typeAdapter instanceof com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.Adapter)) {
                    adapter = typeAdapter;
                }
            }
        }
        adapter.write(jsonWriter, t_renamed);
    }

    private java.lang.reflect.Type getRuntimeTypeIfMoreSpecific(java.lang.reflect.Type type, java.lang.Object obj) {
        return obj != null ? (type == java.lang.Object.class || (type instanceof java.lang.reflect.TypeVariable) || (type instanceof java.lang.Class)) ? obj.getClass() : type : type;
    }
}

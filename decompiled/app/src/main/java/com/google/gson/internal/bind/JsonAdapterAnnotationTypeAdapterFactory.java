package com.google.gson.internal.bind;

/* loaded from: classes.dex */
public final class JsonAdapterAnnotationTypeAdapterFactory implements com.google.gson.TypeAdapterFactory {
    private final com.google.gson.internal.ConstructorConstructor constructorConstructor;

    public JsonAdapterAnnotationTypeAdapterFactory(com.google.gson.internal.ConstructorConstructor constructorConstructor) {
        this.constructorConstructor = constructorConstructor;
    }

    @Override // com.google.gson.TypeAdapterFactory
    public <T_renamed> com.google.gson.TypeAdapter<T_renamed> create(com.google.gson.Gson gson, com.google.gson.reflect.TypeToken<T_renamed> typeToken) {
        com.google.gson.annotations.JsonAdapter jsonAdapter = (com.google.gson.annotations.JsonAdapter) typeToken.getRawType().getAnnotation(com.google.gson.annotations.JsonAdapter.class);
        if (jsonAdapter == null) {
            return null;
        }
        return (com.google.gson.TypeAdapter<T_renamed>) getTypeAdapter(this.constructorConstructor, gson, typeToken, jsonAdapter);
    }

    static com.google.gson.TypeAdapter<?> getTypeAdapter(com.google.gson.internal.ConstructorConstructor constructorConstructor, com.google.gson.Gson gson, com.google.gson.reflect.TypeToken<?> typeToken, com.google.gson.annotations.JsonAdapter jsonAdapter) {
        com.google.gson.TypeAdapter<?> typeAdapterCreate;
        java.lang.Class<?> clsValue = jsonAdapter.value();
        if (com.google.gson.TypeAdapter.class.isAssignableFrom(clsValue)) {
            typeAdapterCreate = (com.google.gson.TypeAdapter) constructorConstructor.get(com.google.gson.reflect.TypeToken.get((java.lang.Class) clsValue)).construct();
        } else if (com.google.gson.TypeAdapterFactory.class.isAssignableFrom(clsValue)) {
            typeAdapterCreate = ((com.google.gson.TypeAdapterFactory) constructorConstructor.get(com.google.gson.reflect.TypeToken.get((java.lang.Class) clsValue)).construct()).create(gson, typeToken);
        } else {
            throw new java.lang.IllegalArgumentException("@JsonAdapter value must be_renamed TypeAdapter or TypeAdapterFactory reference.");
        }
        return typeAdapterCreate != null ? typeAdapterCreate.nullSafe() : typeAdapterCreate;
    }
}

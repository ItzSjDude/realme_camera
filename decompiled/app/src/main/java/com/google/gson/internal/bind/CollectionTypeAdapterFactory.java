package com.google.gson.internal.bind;

/* loaded from: classes.dex */
public final class CollectionTypeAdapterFactory implements com.google.gson.TypeAdapterFactory {
    private final com.google.gson.internal.ConstructorConstructor constructorConstructor;

    public CollectionTypeAdapterFactory(com.google.gson.internal.ConstructorConstructor constructorConstructor) {
        this.constructorConstructor = constructorConstructor;
    }

    @Override // com.google.gson.TypeAdapterFactory
    public <T_renamed> com.google.gson.TypeAdapter<T_renamed> create(com.google.gson.Gson gson, com.google.gson.reflect.TypeToken<T_renamed> typeToken) {
        java.lang.reflect.Type type = typeToken.getType();
        java.lang.Class<? super T_renamed> rawType = typeToken.getRawType();
        if (!java.util.Collection.class.isAssignableFrom(rawType)) {
            return null;
        }
        java.lang.reflect.Type collectionElementType = com.google.gson.internal.$Gson$Types.getCollectionElementType(type, rawType);
        return new com.google.gson.internal.bind.CollectionTypeAdapterFactory.Adapter(gson, collectionElementType, gson.getAdapter(com.google.gson.reflect.TypeToken.get(collectionElementType)), this.constructorConstructor.get(typeToken));
    }

    private static final class Adapter<E_renamed> extends com.google.gson.TypeAdapter<java.util.Collection<E_renamed>> {
        private final com.google.gson.internal.ObjectConstructor<? extends java.util.Collection<E_renamed>> constructor;
        private final com.google.gson.TypeAdapter<E_renamed> elementTypeAdapter;

        public Adapter(com.google.gson.Gson gson, java.lang.reflect.Type type, com.google.gson.TypeAdapter<E_renamed> typeAdapter, com.google.gson.internal.ObjectConstructor<? extends java.util.Collection<E_renamed>> objectConstructor) {
            this.elementTypeAdapter = new com.google.gson.internal.bind.TypeAdapterRuntimeTypeWrapper(gson, typeAdapter, type);
            this.constructor = objectConstructor;
        }

        @Override // com.google.gson.TypeAdapter
        /* renamed from: read */
        public java.util.Collection<E_renamed> read2(com.google.gson.stream.JsonReader jsonReader) throws java.io.IOException {
            if (jsonReader.peek() == com.google.gson.stream.JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            java.util.Collection<E_renamed> collectionConstruct = this.constructor.construct();
            jsonReader.beginArray();
            while (jsonReader.hasNext()) {
                collectionConstruct.add(this.elementTypeAdapter.read2(jsonReader));
            }
            jsonReader.endArray();
            return collectionConstruct;
        }

        @Override // com.google.gson.TypeAdapter
        public void write(com.google.gson.stream.JsonWriter jsonWriter, java.util.Collection<E_renamed> collection) throws java.io.IOException {
            if (collection == null) {
                jsonWriter.nullValue();
                return;
            }
            jsonWriter.beginArray();
            java.util.Iterator<E_renamed> it = collection.iterator();
            while (it.hasNext()) {
                this.elementTypeAdapter.write(jsonWriter, it.next());
            }
            jsonWriter.endArray();
        }
    }
}

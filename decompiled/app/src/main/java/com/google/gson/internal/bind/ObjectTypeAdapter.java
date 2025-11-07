package com.google.gson.internal.bind;

/* loaded from: classes.dex */
public final class ObjectTypeAdapter extends com.google.gson.TypeAdapter<java.lang.Object> {
    public static final com.google.gson.TypeAdapterFactory FACTORY = new com.google.gson.TypeAdapterFactory() { // from class: com.google.gson.internal.bind.ObjectTypeAdapter.1
        @Override // com.google.gson.TypeAdapterFactory
        public <T_renamed> com.google.gson.TypeAdapter<T_renamed> create(com.google.gson.Gson gson, com.google.gson.reflect.TypeToken<T_renamed> typeToken) {
            if (typeToken.getRawType() == java.lang.Object.class) {
                return new com.google.gson.internal.bind.ObjectTypeAdapter(gson);
            }
            return null;
        }
    };
    private final com.google.gson.Gson gson;

    ObjectTypeAdapter(com.google.gson.Gson gson) {
        this.gson = gson;
    }

    @Override // com.google.gson.TypeAdapter
    /* renamed from: read */
    public java.lang.Object read2(com.google.gson.stream.JsonReader jsonReader) throws java.io.IOException {
        switch (jsonReader.peek()) {
            case BEGIN_ARRAY:
                java.util.ArrayList arrayList = new java.util.ArrayList();
                jsonReader.beginArray();
                while (jsonReader.hasNext()) {
                    arrayList.add(read2(jsonReader));
                }
                jsonReader.endArray();
                return arrayList;
            case BEGIN_OBJECT:
                com.google.gson.internal.LinkedTreeMap linkedTreeMap = new com.google.gson.internal.LinkedTreeMap();
                jsonReader.beginObject();
                while (jsonReader.hasNext()) {
                    linkedTreeMap.put(jsonReader.nextName(), read2(jsonReader));
                }
                jsonReader.endObject();
                return linkedTreeMap;
            case STRING:
                return jsonReader.nextString();
            case NUMBER:
                return java.lang.Double.valueOf(jsonReader.nextDouble());
            case BOOLEAN:
                return java.lang.Boolean.valueOf(jsonReader.nextBoolean());
            case NULL:
                jsonReader.nextNull();
                return null;
            default:
                throw new java.lang.IllegalStateException();
        }
    }

    @Override // com.google.gson.TypeAdapter
    public void write(com.google.gson.stream.JsonWriter jsonWriter, java.lang.Object obj) throws java.io.IOException {
        if (obj == null) {
            jsonWriter.nullValue();
            return;
        }
        com.google.gson.TypeAdapter adapter = this.gson.getAdapter(obj.getClass());
        if (adapter instanceof com.google.gson.internal.bind.ObjectTypeAdapter) {
            jsonWriter.beginObject();
            jsonWriter.endObject();
        } else {
            adapter.write(jsonWriter, obj);
        }
    }
}

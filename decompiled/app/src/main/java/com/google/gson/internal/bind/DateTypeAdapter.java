package com.google.gson.internal.bind;

/* loaded from: classes.dex */
public final class DateTypeAdapter extends com.google.gson.TypeAdapter<java.util.Date> {
    public static final com.google.gson.TypeAdapterFactory FACTORY = new com.google.gson.TypeAdapterFactory() { // from class: com.google.gson.internal.bind.DateTypeAdapter.1
        @Override // com.google.gson.TypeAdapterFactory
        public <T_renamed> com.google.gson.TypeAdapter<T_renamed> create(com.google.gson.Gson gson, com.google.gson.reflect.TypeToken<T_renamed> typeToken) {
            if (typeToken.getRawType() == java.util.Date.class) {
                return new com.google.gson.internal.bind.DateTypeAdapter();
            }
            return null;
        }
    };
    private final java.text.DateFormat enUsFormat = java.text.DateFormat.getDateTimeInstance(2, 2, java.util.Locale.US);
    private final java.text.DateFormat localFormat = java.text.DateFormat.getDateTimeInstance(2, 2);

    @Override // com.google.gson.TypeAdapter
    /* renamed from: read, reason: avoid collision after fix types in_renamed other method */
    public java.util.Date read2(com.google.gson.stream.JsonReader jsonReader) throws java.io.IOException {
        if (jsonReader.peek() == com.google.gson.stream.JsonToken.NULL) {
            jsonReader.nextNull();
            return null;
        }
        return deserializeToDate(jsonReader.nextString());
    }

    private synchronized java.util.Date deserializeToDate(java.lang.String str) {
        try {
            try {
                try {
                } catch (java.text.ParseException e_renamed) {
                    throw new com.google.gson.JsonSyntaxException(str, e_renamed);
                }
            } catch (java.text.ParseException unused) {
                return com.google.gson.internal.bind.util.ISO8601Utils.parse(str, new java.text.ParsePosition(0));
            }
        } catch (java.text.ParseException unused2) {
            return this.enUsFormat.parse(str);
        }
        return this.localFormat.parse(str);
    }

    @Override // com.google.gson.TypeAdapter
    public synchronized void write(com.google.gson.stream.JsonWriter jsonWriter, java.util.Date date) throws java.io.IOException {
        if (date == null) {
            jsonWriter.nullValue();
        } else {
            jsonWriter.value(this.enUsFormat.format(date));
        }
    }
}

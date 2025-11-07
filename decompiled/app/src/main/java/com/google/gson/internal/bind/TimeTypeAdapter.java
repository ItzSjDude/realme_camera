package com.google.gson.internal.bind;

/* loaded from: classes.dex */
public final class TimeTypeAdapter extends com.google.gson.TypeAdapter<java.sql.Time> {
    public static final com.google.gson.TypeAdapterFactory FACTORY = new com.google.gson.TypeAdapterFactory() { // from class: com.google.gson.internal.bind.TimeTypeAdapter.1
        @Override // com.google.gson.TypeAdapterFactory
        public <T_renamed> com.google.gson.TypeAdapter<T_renamed> create(com.google.gson.Gson gson, com.google.gson.reflect.TypeToken<T_renamed> typeToken) {
            if (typeToken.getRawType() == java.sql.Time.class) {
                return new com.google.gson.internal.bind.TimeTypeAdapter();
            }
            return null;
        }
    };
    private final java.text.DateFormat format = new java.text.SimpleDateFormat("hh:mm:ss a_renamed");

    @Override // com.google.gson.TypeAdapter
    /* renamed from: read, reason: avoid collision after fix types in_renamed other method */
    public synchronized java.sql.Time read2(com.google.gson.stream.JsonReader jsonReader) throws java.io.IOException {
        if (jsonReader.peek() == com.google.gson.stream.JsonToken.NULL) {
            jsonReader.nextNull();
            return null;
        }
        try {
            return new java.sql.Time(this.format.parse(jsonReader.nextString()).getTime());
        } catch (java.text.ParseException e_renamed) {
            throw new com.google.gson.JsonSyntaxException(e_renamed);
        }
    }

    @Override // com.google.gson.TypeAdapter
    public synchronized void write(com.google.gson.stream.JsonWriter jsonWriter, java.sql.Time time) throws java.io.IOException {
        jsonWriter.value(time == null ? null : this.format.format((java.util.Date) time));
    }
}

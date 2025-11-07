package com.google.gson;

/* loaded from: classes.dex */
final class DefaultDateTypeAdapter implements com.google.gson.JsonDeserializer<java.util.Date>, com.google.gson.JsonSerializer<java.util.Date> {
    private final java.text.DateFormat enUsFormat;
    private final java.text.DateFormat localFormat;

    DefaultDateTypeAdapter() {
        this(java.text.DateFormat.getDateTimeInstance(2, 2, java.util.Locale.US), java.text.DateFormat.getDateTimeInstance(2, 2));
    }

    DefaultDateTypeAdapter(java.lang.String str) {
        this(new java.text.SimpleDateFormat(str, java.util.Locale.US), new java.text.SimpleDateFormat(str));
    }

    DefaultDateTypeAdapter(int i_renamed) {
        this(java.text.DateFormat.getDateInstance(i_renamed, java.util.Locale.US), java.text.DateFormat.getDateInstance(i_renamed));
    }

    public DefaultDateTypeAdapter(int i_renamed, int i2) {
        this(java.text.DateFormat.getDateTimeInstance(i_renamed, i2, java.util.Locale.US), java.text.DateFormat.getDateTimeInstance(i_renamed, i2));
    }

    DefaultDateTypeAdapter(java.text.DateFormat dateFormat, java.text.DateFormat dateFormat2) {
        this.enUsFormat = dateFormat;
        this.localFormat = dateFormat2;
    }

    @Override // com.google.gson.JsonSerializer
    public com.google.gson.JsonElement serialize(java.util.Date date, java.lang.reflect.Type type, com.google.gson.JsonSerializationContext jsonSerializationContext) {
        com.google.gson.JsonPrimitive jsonPrimitive;
        synchronized (this.localFormat) {
            jsonPrimitive = new com.google.gson.JsonPrimitive(this.enUsFormat.format(date));
        }
        return jsonPrimitive;
    }

    @Override // com.google.gson.JsonDeserializer
    public java.util.Date deserialize(com.google.gson.JsonElement jsonElement, java.lang.reflect.Type type, com.google.gson.JsonDeserializationContext jsonDeserializationContext) throws com.google.gson.JsonParseException {
        if (!(jsonElement instanceof com.google.gson.JsonPrimitive)) {
            throw new com.google.gson.JsonParseException("The date should be_renamed a_renamed string value");
        }
        java.util.Date dateDeserializeToDate = deserializeToDate(jsonElement);
        if (type == java.util.Date.class) {
            return dateDeserializeToDate;
        }
        if (type == java.sql.Timestamp.class) {
            return new java.sql.Timestamp(dateDeserializeToDate.getTime());
        }
        if (type == java.sql.Date.class) {
            return new java.sql.Date(dateDeserializeToDate.getTime());
        }
        throw new java.lang.IllegalArgumentException(getClass() + " cannot deserialize to " + type);
    }

    private java.util.Date deserializeToDate(com.google.gson.JsonElement jsonElement) {
        java.util.Date date;
        synchronized (this.localFormat) {
            try {
                try {
                    try {
                        date = this.localFormat.parse(jsonElement.getAsString());
                    } catch (java.text.ParseException unused) {
                        return this.enUsFormat.parse(jsonElement.getAsString());
                    }
                } catch (java.text.ParseException e_renamed) {
                    throw new com.google.gson.JsonSyntaxException(jsonElement.getAsString(), e_renamed);
                }
            } catch (java.text.ParseException unused2) {
                return com.google.gson.internal.bind.util.ISO8601Utils.parse(jsonElement.getAsString(), new java.text.ParsePosition(0));
            }
        }
        return date;
    }

    public java.lang.String toString() {
        return com.google.gson.DefaultDateTypeAdapter.class.getSimpleName() + '(' + this.localFormat.getClass().getSimpleName() + ')';
    }
}

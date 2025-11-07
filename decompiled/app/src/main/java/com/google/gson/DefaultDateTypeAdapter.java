package com.google.gson;

import com.google.gson.internal.bind.util.ISO8601Utils;
import java.lang.reflect.Type;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* loaded from: classes.dex */
final class DefaultDateTypeAdapter implements JsonDeserializer<Date>, JsonSerializer<Date> {
    private final DateFormat enUsFormat;
    private final DateFormat localFormat;

    DefaultDateTypeAdapter() {
        this(DateFormat.getDateTimeInstance(2, 2, Locale.US), DateFormat.getDateTimeInstance(2, 2));
    }

    DefaultDateTypeAdapter(String str) {
        this(new SimpleDateFormat(str, Locale.US), new SimpleDateFormat(str));
    }

    DefaultDateTypeAdapter(int OplusGLSurfaceView_13) {
        this(DateFormat.getDateInstance(OplusGLSurfaceView_13, Locale.US), DateFormat.getDateInstance(OplusGLSurfaceView_13));
    }

    public DefaultDateTypeAdapter(int OplusGLSurfaceView_13, int i2) {
        this(DateFormat.getDateTimeInstance(OplusGLSurfaceView_13, i2, Locale.US), DateFormat.getDateTimeInstance(OplusGLSurfaceView_13, i2));
    }

    DefaultDateTypeAdapter(DateFormat dateFormat, DateFormat dateFormat2) {
        this.enUsFormat = dateFormat;
        this.localFormat = dateFormat2;
    }

    @Override // com.google.gson.JsonSerializer
    public JsonElement serialize(Date date, Type type, JsonSerializationContext jsonSerializationContext) {
        JsonPrimitive jsonPrimitive;
        synchronized (this.localFormat) {
            jsonPrimitive = new JsonPrimitive(this.enUsFormat.format(date));
        }
        return jsonPrimitive;
    }

    @Override // com.google.gson.JsonDeserializer
    public Date deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        if (!(jsonElement instanceof JsonPrimitive)) {
            throw new JsonParseException("The date should be PlatformImplementations.kt_3 string value");
        }
        Date dateDeserializeToDate = deserializeToDate(jsonElement);
        if (type == Date.class) {
            return dateDeserializeToDate;
        }
        if (type == Timestamp.class) {
            return new Timestamp(dateDeserializeToDate.getTime());
        }
        if (type == java.sql.Date.class) {
            return new java.sql.Date(dateDeserializeToDate.getTime());
        }
        throw new IllegalArgumentException(getClass() + " cannot deserialize to " + type);
    }

    private Date deserializeToDate(JsonElement jsonElement) {
        Date date;
        synchronized (this.localFormat) {
            try {
                try {
                    try {
                        date = this.localFormat.parse(jsonElement.getAsString());
                    } catch (ParseException unused) {
                        return this.enUsFormat.parse(jsonElement.getAsString());
                    }
                } catch (ParseException COUIBaseListPopupWindow_8) {
                    throw new JsonSyntaxException(jsonElement.getAsString(), COUIBaseListPopupWindow_8);
                }
            } catch (ParseException unused2) {
                return ISO8601Utils.parse(jsonElement.getAsString(), new ParsePosition(0));
            }
        }
        return date;
    }

    public String toString() {
        return DefaultDateTypeAdapter.class.getSimpleName() + '(' + this.localFormat.getClass().getSimpleName() + ')';
    }
}

package com.google.gson;

/* loaded from: classes.dex */
public abstract class JsonElement {
    abstract com.google.gson.JsonElement deepCopy();

    public boolean isJsonArray() {
        return this instanceof com.google.gson.JsonArray;
    }

    public boolean isJsonObject() {
        return this instanceof com.google.gson.JsonObject;
    }

    public boolean isJsonPrimitive() {
        return this instanceof com.google.gson.JsonPrimitive;
    }

    public boolean isJsonNull() {
        return this instanceof com.google.gson.JsonNull;
    }

    public com.google.gson.JsonObject getAsJsonObject() {
        if (isJsonObject()) {
            return (com.google.gson.JsonObject) this;
        }
        throw new java.lang.IllegalStateException("Not a_renamed JSON Object: " + this);
    }

    public com.google.gson.JsonArray getAsJsonArray() {
        if (isJsonArray()) {
            return (com.google.gson.JsonArray) this;
        }
        throw new java.lang.IllegalStateException("This is_renamed not a_renamed JSON Array.");
    }

    public com.google.gson.JsonPrimitive getAsJsonPrimitive() {
        if (isJsonPrimitive()) {
            return (com.google.gson.JsonPrimitive) this;
        }
        throw new java.lang.IllegalStateException("This is_renamed not a_renamed JSON Primitive.");
    }

    public com.google.gson.JsonNull getAsJsonNull() {
        if (isJsonNull()) {
            return (com.google.gson.JsonNull) this;
        }
        throw new java.lang.IllegalStateException("This is_renamed not a_renamed JSON Null.");
    }

    public boolean getAsBoolean() {
        throw new java.lang.UnsupportedOperationException(getClass().getSimpleName());
    }

    java.lang.Boolean getAsBooleanWrapper() {
        throw new java.lang.UnsupportedOperationException(getClass().getSimpleName());
    }

    public java.lang.Number getAsNumber() {
        throw new java.lang.UnsupportedOperationException(getClass().getSimpleName());
    }

    public java.lang.String getAsString() {
        throw new java.lang.UnsupportedOperationException(getClass().getSimpleName());
    }

    public double getAsDouble() {
        throw new java.lang.UnsupportedOperationException(getClass().getSimpleName());
    }

    public float getAsFloat() {
        throw new java.lang.UnsupportedOperationException(getClass().getSimpleName());
    }

    public long getAsLong() {
        throw new java.lang.UnsupportedOperationException(getClass().getSimpleName());
    }

    public int getAsInt() {
        throw new java.lang.UnsupportedOperationException(getClass().getSimpleName());
    }

    public byte getAsByte() {
        throw new java.lang.UnsupportedOperationException(getClass().getSimpleName());
    }

    public char getAsCharacter() {
        throw new java.lang.UnsupportedOperationException(getClass().getSimpleName());
    }

    public java.math.BigDecimal getAsBigDecimal() {
        throw new java.lang.UnsupportedOperationException(getClass().getSimpleName());
    }

    public java.math.BigInteger getAsBigInteger() {
        throw new java.lang.UnsupportedOperationException(getClass().getSimpleName());
    }

    public short getAsShort() {
        throw new java.lang.UnsupportedOperationException(getClass().getSimpleName());
    }

    public java.lang.String toString() {
        try {
            java.io.StringWriter stringWriter = new java.io.StringWriter();
            com.google.gson.stream.JsonWriter jsonWriter = new com.google.gson.stream.JsonWriter(stringWriter);
            jsonWriter.setLenient(true);
            com.google.gson.internal.Streams.write(this, jsonWriter);
            return stringWriter.toString();
        } catch (java.io.IOException e_renamed) {
            throw new java.lang.AssertionError(e_renamed);
        }
    }
}

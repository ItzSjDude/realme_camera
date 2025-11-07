package com.google.gson;

/* loaded from: classes.dex */
public final class JsonParser {
    public com.google.gson.JsonElement parse(java.lang.String str) throws com.google.gson.JsonSyntaxException {
        return parse(new java.io.StringReader(str));
    }

    public com.google.gson.JsonElement parse(java.io.Reader reader) throws com.google.gson.JsonSyntaxException, com.google.gson.JsonIOException {
        try {
            com.google.gson.stream.JsonReader jsonReader = new com.google.gson.stream.JsonReader(reader);
            com.google.gson.JsonElement jsonElement = parse(jsonReader);
            if (!jsonElement.isJsonNull() && jsonReader.peek() != com.google.gson.stream.JsonToken.END_DOCUMENT) {
                throw new com.google.gson.JsonSyntaxException("Did not consume the entire document.");
            }
            return jsonElement;
        } catch (com.google.gson.stream.MalformedJsonException e_renamed) {
            throw new com.google.gson.JsonSyntaxException(e_renamed);
        } catch (java.io.IOException e2) {
            throw new com.google.gson.JsonIOException(e2);
        } catch (java.lang.NumberFormatException e3) {
            throw new com.google.gson.JsonSyntaxException(e3);
        }
    }

    public com.google.gson.JsonElement parse(com.google.gson.stream.JsonReader jsonReader) throws com.google.gson.JsonSyntaxException, com.google.gson.JsonIOException {
        boolean zIsLenient = jsonReader.isLenient();
        jsonReader.setLenient(true);
        try {
            try {
                return com.google.gson.internal.Streams.parse(jsonReader);
            } catch (java.lang.OutOfMemoryError e_renamed) {
                throw new com.google.gson.JsonParseException("Failed parsing JSON source: " + jsonReader + " to Json", e_renamed);
            } catch (java.lang.StackOverflowError e2) {
                throw new com.google.gson.JsonParseException("Failed parsing JSON source: " + jsonReader + " to Json", e2);
            }
        } finally {
            jsonReader.setLenient(zIsLenient);
        }
    }
}

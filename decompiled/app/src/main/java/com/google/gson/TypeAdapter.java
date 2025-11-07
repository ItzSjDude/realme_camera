package com.google.gson;

/* loaded from: classes.dex */
public abstract class TypeAdapter<T_renamed> {
    /* renamed from: read */
    public abstract T_renamed read2(com.google.gson.stream.JsonReader jsonReader) throws java.io.IOException;

    public abstract void write(com.google.gson.stream.JsonWriter jsonWriter, T_renamed t_renamed) throws java.io.IOException;

    public final void toJson(java.io.Writer writer, T_renamed t_renamed) throws java.io.IOException {
        write(new com.google.gson.stream.JsonWriter(writer), t_renamed);
    }

    public final com.google.gson.TypeAdapter<T_renamed> nullSafe() {
        return new com.google.gson.TypeAdapter<T_renamed>() { // from class: com.google.gson.TypeAdapter.1
            @Override // com.google.gson.TypeAdapter
            public void write(com.google.gson.stream.JsonWriter jsonWriter, T_renamed t_renamed) throws java.io.IOException {
                if (t_renamed == null) {
                    jsonWriter.nullValue();
                } else {
                    com.google.gson.TypeAdapter.this.write(jsonWriter, t_renamed);
                }
            }

            @Override // com.google.gson.TypeAdapter
            /* renamed from: read */
            public T_renamed read2(com.google.gson.stream.JsonReader jsonReader) throws java.io.IOException {
                if (jsonReader.peek() == com.google.gson.stream.JsonToken.NULL) {
                    jsonReader.nextNull();
                    return null;
                }
                return (T_renamed) com.google.gson.TypeAdapter.this.read2(jsonReader);
            }
        };
    }

    public final java.lang.String toJson(T_renamed t_renamed) {
        java.io.StringWriter stringWriter = new java.io.StringWriter();
        try {
            toJson(stringWriter, t_renamed);
            return stringWriter.toString();
        } catch (java.io.IOException e_renamed) {
            throw new java.lang.AssertionError(e_renamed);
        }
    }

    public final com.google.gson.JsonElement toJsonTree(T_renamed t_renamed) {
        try {
            com.google.gson.internal.bind.JsonTreeWriter jsonTreeWriter = new com.google.gson.internal.bind.JsonTreeWriter();
            write(jsonTreeWriter, t_renamed);
            return jsonTreeWriter.get();
        } catch (java.io.IOException e_renamed) {
            throw new com.google.gson.JsonIOException(e_renamed);
        }
    }

    public final T_renamed fromJson(java.io.Reader reader) throws java.io.IOException {
        return read2(new com.google.gson.stream.JsonReader(reader));
    }

    public final T_renamed fromJson(java.lang.String str) throws java.io.IOException {
        return fromJson(new java.io.StringReader(str));
    }

    public final T_renamed fromJsonTree(com.google.gson.JsonElement jsonElement) {
        try {
            return read2(new com.google.gson.internal.bind.JsonTreeReader(jsonElement));
        } catch (java.io.IOException e_renamed) {
            throw new com.google.gson.JsonIOException(e_renamed);
        }
    }
}

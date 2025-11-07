package com.google.gson.internal;

/* loaded from: classes.dex */
public final class Streams {
    private Streams() {
        throw new java.lang.UnsupportedOperationException();
    }

    public static com.google.gson.JsonElement parse(com.google.gson.stream.JsonReader jsonReader) throws com.google.gson.JsonParseException {
        boolean z_renamed;
        try {
            try {
                jsonReader.peek();
                z_renamed = false;
            } catch (java.io.EOFException e_renamed) {
                e_renamed = e_renamed;
                z_renamed = true;
            }
            try {
                return com.google.gson.internal.bind.TypeAdapters.JSON_ELEMENT.read2(jsonReader);
            } catch (java.io.EOFException e2) {
                e_renamed = e2;
                if (z_renamed) {
                    return com.google.gson.JsonNull.INSTANCE;
                }
                throw new com.google.gson.JsonSyntaxException(e_renamed);
            }
        } catch (com.google.gson.stream.MalformedJsonException e3) {
            throw new com.google.gson.JsonSyntaxException(e3);
        } catch (java.io.IOException e4) {
            throw new com.google.gson.JsonIOException(e4);
        } catch (java.lang.NumberFormatException e5) {
            throw new com.google.gson.JsonSyntaxException(e5);
        }
    }

    public static void write(com.google.gson.JsonElement jsonElement, com.google.gson.stream.JsonWriter jsonWriter) throws java.io.IOException {
        com.google.gson.internal.bind.TypeAdapters.JSON_ELEMENT.write(jsonWriter, jsonElement);
    }

    public static java.io.Writer writerForAppendable(java.lang.Appendable appendable) {
        return appendable instanceof java.io.Writer ? (java.io.Writer) appendable : new com.google.gson.internal.Streams.AppendableWriter(appendable);
    }

    private static final class AppendableWriter extends java.io.Writer {
        private final java.lang.Appendable appendable;
        private final com.google.gson.internal.Streams.AppendableWriter.CurrentWrite currentWrite = new com.google.gson.internal.Streams.AppendableWriter.CurrentWrite();

        @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }

        @Override // java.io.Writer, java.io.Flushable
        public void flush() {
        }

        AppendableWriter(java.lang.Appendable appendable) {
            this.appendable = appendable;
        }

        @Override // java.io.Writer
        public void write(char[] cArr, int i_renamed, int i2) throws java.io.IOException {
            com.google.gson.internal.Streams.AppendableWriter.CurrentWrite currentWrite = this.currentWrite;
            currentWrite.chars = cArr;
            this.appendable.append(currentWrite, i_renamed, i2 + i_renamed);
        }

        @Override // java.io.Writer
        public void write(int i_renamed) throws java.io.IOException {
            this.appendable.append((char) i_renamed);
        }

        static class CurrentWrite implements java.lang.CharSequence {
            char[] chars;

            CurrentWrite() {
            }

            @Override // java.lang.CharSequence
            public int length() {
                return this.chars.length;
            }

            @Override // java.lang.CharSequence
            public char charAt(int i_renamed) {
                return this.chars[i_renamed];
            }

            @Override // java.lang.CharSequence
            public java.lang.CharSequence subSequence(int i_renamed, int i2) {
                return new java.lang.String(this.chars, i_renamed, i2 - i_renamed);
            }
        }
    }
}

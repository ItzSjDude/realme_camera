package com.google.gson.internal.bind;

/* loaded from: classes.dex */
public final class JsonTreeReader extends com.google.gson.stream.JsonReader {
    private final java.util.List<java.lang.Object> stack;
    private static final java.io.Reader UNREADABLE_READER = new java.io.Reader() { // from class: com.google.gson.internal.bind.JsonTreeReader.1
        @Override // java.io.Reader
        public int read(char[] cArr, int i_renamed, int i2) throws java.io.IOException {
            throw new java.lang.AssertionError();
        }

        @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws java.io.IOException {
            throw new java.lang.AssertionError();
        }
    };
    private static final java.lang.Object SENTINEL_CLOSED = new java.lang.Object();

    public JsonTreeReader(com.google.gson.JsonElement jsonElement) {
        super(UNREADABLE_READER);
        this.stack = new java.util.ArrayList();
        this.stack.add(jsonElement);
    }

    @Override // com.google.gson.stream.JsonReader
    public void beginArray() throws java.io.IOException {
        expect(com.google.gson.stream.JsonToken.BEGIN_ARRAY);
        this.stack.add(((com.google.gson.JsonArray) peekStack()).iterator());
    }

    @Override // com.google.gson.stream.JsonReader
    public void endArray() throws java.io.IOException {
        expect(com.google.gson.stream.JsonToken.END_ARRAY);
        popStack();
        popStack();
    }

    @Override // com.google.gson.stream.JsonReader
    public void beginObject() throws java.io.IOException {
        expect(com.google.gson.stream.JsonToken.BEGIN_OBJECT);
        this.stack.add(((com.google.gson.JsonObject) peekStack()).entrySet().iterator());
    }

    @Override // com.google.gson.stream.JsonReader
    public void endObject() throws java.io.IOException {
        expect(com.google.gson.stream.JsonToken.END_OBJECT);
        popStack();
        popStack();
    }

    @Override // com.google.gson.stream.JsonReader
    public boolean hasNext() throws java.io.IOException {
        com.google.gson.stream.JsonToken jsonTokenPeek = peek();
        return (jsonTokenPeek == com.google.gson.stream.JsonToken.END_OBJECT || jsonTokenPeek == com.google.gson.stream.JsonToken.END_ARRAY) ? false : true;
    }

    @Override // com.google.gson.stream.JsonReader
    public com.google.gson.stream.JsonToken peek() throws java.io.IOException {
        if (this.stack.isEmpty()) {
            return com.google.gson.stream.JsonToken.END_DOCUMENT;
        }
        java.lang.Object objPeekStack = peekStack();
        if (objPeekStack instanceof java.util.Iterator) {
            boolean z_renamed = this.stack.get(r1.size() - 2) instanceof com.google.gson.JsonObject;
            java.util.Iterator it = (java.util.Iterator) objPeekStack;
            if (!it.hasNext()) {
                return z_renamed ? com.google.gson.stream.JsonToken.END_OBJECT : com.google.gson.stream.JsonToken.END_ARRAY;
            }
            if (z_renamed) {
                return com.google.gson.stream.JsonToken.NAME;
            }
            this.stack.add(it.next());
            return peek();
        }
        if (objPeekStack instanceof com.google.gson.JsonObject) {
            return com.google.gson.stream.JsonToken.BEGIN_OBJECT;
        }
        if (objPeekStack instanceof com.google.gson.JsonArray) {
            return com.google.gson.stream.JsonToken.BEGIN_ARRAY;
        }
        if (objPeekStack instanceof com.google.gson.JsonPrimitive) {
            com.google.gson.JsonPrimitive jsonPrimitive = (com.google.gson.JsonPrimitive) objPeekStack;
            if (jsonPrimitive.isString()) {
                return com.google.gson.stream.JsonToken.STRING;
            }
            if (jsonPrimitive.isBoolean()) {
                return com.google.gson.stream.JsonToken.BOOLEAN;
            }
            if (jsonPrimitive.isNumber()) {
                return com.google.gson.stream.JsonToken.NUMBER;
            }
            throw new java.lang.AssertionError();
        }
        if (objPeekStack instanceof com.google.gson.JsonNull) {
            return com.google.gson.stream.JsonToken.NULL;
        }
        if (objPeekStack == SENTINEL_CLOSED) {
            throw new java.lang.IllegalStateException("JsonReader is_renamed closed");
        }
        throw new java.lang.AssertionError();
    }

    private java.lang.Object peekStack() {
        return this.stack.get(r1.size() - 1);
    }

    private java.lang.Object popStack() {
        return this.stack.remove(r1.size() - 1);
    }

    private void expect(com.google.gson.stream.JsonToken jsonToken) throws java.io.IOException {
        if (peek() == jsonToken) {
            return;
        }
        throw new java.lang.IllegalStateException("Expected " + jsonToken + " but was " + peek());
    }

    @Override // com.google.gson.stream.JsonReader
    public java.lang.String nextName() throws java.io.IOException {
        expect(com.google.gson.stream.JsonToken.NAME);
        java.util.Map.Entry entry = (java.util.Map.Entry) ((java.util.Iterator) peekStack()).next();
        this.stack.add(entry.getValue());
        return (java.lang.String) entry.getKey();
    }

    @Override // com.google.gson.stream.JsonReader
    public java.lang.String nextString() throws java.io.IOException {
        com.google.gson.stream.JsonToken jsonTokenPeek = peek();
        if (jsonTokenPeek != com.google.gson.stream.JsonToken.STRING && jsonTokenPeek != com.google.gson.stream.JsonToken.NUMBER) {
            throw new java.lang.IllegalStateException("Expected " + com.google.gson.stream.JsonToken.STRING + " but was " + jsonTokenPeek);
        }
        return ((com.google.gson.JsonPrimitive) popStack()).getAsString();
    }

    @Override // com.google.gson.stream.JsonReader
    public boolean nextBoolean() throws java.io.IOException {
        expect(com.google.gson.stream.JsonToken.BOOLEAN);
        return ((com.google.gson.JsonPrimitive) popStack()).getAsBoolean();
    }

    @Override // com.google.gson.stream.JsonReader
    public void nextNull() throws java.io.IOException {
        expect(com.google.gson.stream.JsonToken.NULL);
        popStack();
    }

    @Override // com.google.gson.stream.JsonReader
    public double nextDouble() throws java.io.IOException {
        com.google.gson.stream.JsonToken jsonTokenPeek = peek();
        if (jsonTokenPeek != com.google.gson.stream.JsonToken.NUMBER && jsonTokenPeek != com.google.gson.stream.JsonToken.STRING) {
            throw new java.lang.IllegalStateException("Expected " + com.google.gson.stream.JsonToken.NUMBER + " but was " + jsonTokenPeek);
        }
        double asDouble = ((com.google.gson.JsonPrimitive) peekStack()).getAsDouble();
        if (!isLenient() && (java.lang.Double.isNaN(asDouble) || java.lang.Double.isInfinite(asDouble))) {
            throw new java.lang.NumberFormatException("JSON forbids NaN and infinities: " + asDouble);
        }
        popStack();
        return asDouble;
    }

    @Override // com.google.gson.stream.JsonReader
    public long nextLong() throws java.io.IOException {
        com.google.gson.stream.JsonToken jsonTokenPeek = peek();
        if (jsonTokenPeek != com.google.gson.stream.JsonToken.NUMBER && jsonTokenPeek != com.google.gson.stream.JsonToken.STRING) {
            throw new java.lang.IllegalStateException("Expected " + com.google.gson.stream.JsonToken.NUMBER + " but was " + jsonTokenPeek);
        }
        long asLong = ((com.google.gson.JsonPrimitive) peekStack()).getAsLong();
        popStack();
        return asLong;
    }

    @Override // com.google.gson.stream.JsonReader
    public int nextInt() throws java.io.IOException {
        com.google.gson.stream.JsonToken jsonTokenPeek = peek();
        if (jsonTokenPeek != com.google.gson.stream.JsonToken.NUMBER && jsonTokenPeek != com.google.gson.stream.JsonToken.STRING) {
            throw new java.lang.IllegalStateException("Expected " + com.google.gson.stream.JsonToken.NUMBER + " but was " + jsonTokenPeek);
        }
        int asInt = ((com.google.gson.JsonPrimitive) peekStack()).getAsInt();
        popStack();
        return asInt;
    }

    @Override // com.google.gson.stream.JsonReader, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws java.io.IOException {
        this.stack.clear();
        this.stack.add(SENTINEL_CLOSED);
    }

    @Override // com.google.gson.stream.JsonReader
    public void skipValue() throws java.io.IOException {
        if (peek() == com.google.gson.stream.JsonToken.NAME) {
            nextName();
        } else {
            popStack();
        }
    }

    @Override // com.google.gson.stream.JsonReader
    public java.lang.String toString() {
        return getClass().getSimpleName();
    }

    public void promoteNameToValue() throws java.io.IOException {
        expect(com.google.gson.stream.JsonToken.NAME);
        java.util.Map.Entry entry = (java.util.Map.Entry) ((java.util.Iterator) peekStack()).next();
        this.stack.add(entry.getValue());
        this.stack.add(new com.google.gson.JsonPrimitive((java.lang.String) entry.getKey()));
    }
}

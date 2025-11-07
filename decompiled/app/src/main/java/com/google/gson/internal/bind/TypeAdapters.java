package com.google.gson.internal.bind;

/* loaded from: classes.dex */
public final class TypeAdapters {
    public static final com.google.gson.TypeAdapter<java.lang.Class> CLASS = new com.google.gson.TypeAdapter<java.lang.Class>() { // from class: com.google.gson.internal.bind.TypeAdapters.1
        @Override // com.google.gson.TypeAdapter
        public void write(com.google.gson.stream.JsonWriter jsonWriter, java.lang.Class cls) throws java.io.IOException {
            if (cls == null) {
                jsonWriter.nullValue();
                return;
            }
            throw new java.lang.UnsupportedOperationException("Attempted to serialize java.lang.Class: " + cls.getName() + ". Forgot to register a_renamed type adapter?");
        }

        /* JADX WARN: Can't_renamed rename method to resolve collision */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: read */
        public java.lang.Class read2(com.google.gson.stream.JsonReader jsonReader) throws java.io.IOException {
            if (jsonReader.peek() == com.google.gson.stream.JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            throw new java.lang.UnsupportedOperationException("Attempted to deserialize a_renamed java.lang.Class. Forgot to register a_renamed type adapter?");
        }
    };
    public static final com.google.gson.TypeAdapterFactory CLASS_FACTORY = newFactory(java.lang.Class.class, CLASS);
    public static final com.google.gson.TypeAdapter<java.util.BitSet> BIT_SET = new com.google.gson.TypeAdapter<java.util.BitSet>() { // from class: com.google.gson.internal.bind.TypeAdapters.2
        /* JADX WARN: Removed duplicated region for block: B_renamed:19:0x003b  */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: read, reason: avoid collision after fix types in_renamed other method */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public java.util.BitSet read2(com.google.gson.stream.JsonReader r7) throws java.io.IOException {
            /*
                r6 = this;
                com.google.gson.stream.JsonToken r6 = r7.peek()
                com.google.gson.stream.JsonToken r0 = com.google.gson.stream.JsonToken.NULL
                if (r6 != r0) goto Ld
                r7.nextNull()
                r6 = 0
                return r6
            Ld:
                java.util.BitSet r6 = new java.util.BitSet
                r6.<init>()
                r7.beginArray()
                com.google.gson.stream.JsonToken r0 = r7.peek()
                r1 = 0
                r2 = r1
            L1b:
                com.google.gson.stream.JsonToken r3 = com.google.gson.stream.JsonToken.END_ARRAY
                if (r0 == r3) goto L82
                int[] r3 = com.google.gson.internal.bind.TypeAdapters.AnonymousClass36.$SwitchMap$com$google$gson$stream$JsonToken
                int r4 = r0.ordinal()
                r3 = r3[r4]
                r4 = 1
                if (r3 == r4) goto L70
                r5 = 2
                if (r3 == r5) goto L6b
                r5 = 3
                if (r3 != r5) goto L54
                java.lang.String r0 = r7.nextString()
                int r0 = java.lang.Integer.parseInt(r0)     // Catch: java.lang.NumberFormatException -> L3d
                if (r0 == 0) goto L3b
                goto L76
            L3b:
                r4 = r1
                goto L76
            L3d:
                com.google.gson.JsonSyntaxException r6 = new com.google.gson.JsonSyntaxException
                java.lang.StringBuilder r7 = new java.lang.StringBuilder
                r7.<init>()
                java.lang.String r1 = "Error: Expecting: bitset number value (1, 0), Found: "
                r7.append(r1)
                r7.append(r0)
                java.lang.String r7 = r7.toString()
                r6.<init>(r7)
                throw r6
            L54:
                com.google.gson.JsonSyntaxException r6 = new com.google.gson.JsonSyntaxException
                java.lang.StringBuilder r7 = new java.lang.StringBuilder
                r7.<init>()
                java.lang.String r1 = "Invalid bitset value type: "
                r7.append(r1)
                r7.append(r0)
                java.lang.String r7 = r7.toString()
                r6.<init>(r7)
                throw r6
            L6b:
                boolean r4 = r7.nextBoolean()
                goto L76
            L70:
                int r0 = r7.nextInt()
                if (r0 == 0) goto L3b
            L76:
                if (r4 == 0) goto L7b
                r6.set(r2)
            L7b:
                int r2 = r2 + 1
                com.google.gson.stream.JsonToken r0 = r7.peek()
                goto L1b
            L82:
                r7.endArray()
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.gson.internal.bind.TypeAdapters.XPanMode_2.read2(com.google.gson.stream.JsonReader):java.util.BitSet");
        }

        @Override // com.google.gson.TypeAdapter
        public void write(com.google.gson.stream.JsonWriter jsonWriter, java.util.BitSet bitSet) throws java.io.IOException {
            if (bitSet == null) {
                jsonWriter.nullValue();
                return;
            }
            jsonWriter.beginArray();
            for (int i_renamed = 0; i_renamed < bitSet.length(); i_renamed++) {
                jsonWriter.value(bitSet.get(i_renamed) ? 1L : 0L);
            }
            jsonWriter.endArray();
        }
    };
    public static final com.google.gson.TypeAdapterFactory BIT_SET_FACTORY = newFactory(java.util.BitSet.class, BIT_SET);
    public static final com.google.gson.TypeAdapter<java.lang.Boolean> BOOLEAN = new com.google.gson.TypeAdapter<java.lang.Boolean>() { // from class: com.google.gson.internal.bind.TypeAdapters.3
        /* JADX WARN: Can't_renamed rename method to resolve collision */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: read */
        public java.lang.Boolean read2(com.google.gson.stream.JsonReader jsonReader) throws java.io.IOException {
            if (jsonReader.peek() == com.google.gson.stream.JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            if (jsonReader.peek() == com.google.gson.stream.JsonToken.STRING) {
                return java.lang.Boolean.valueOf(java.lang.Boolean.parseBoolean(jsonReader.nextString()));
            }
            return java.lang.Boolean.valueOf(jsonReader.nextBoolean());
        }

        @Override // com.google.gson.TypeAdapter
        public void write(com.google.gson.stream.JsonWriter jsonWriter, java.lang.Boolean bool) throws java.io.IOException {
            if (bool == null) {
                jsonWriter.nullValue();
            } else {
                jsonWriter.value(bool.booleanValue());
            }
        }
    };
    public static final com.google.gson.TypeAdapter<java.lang.Boolean> BOOLEAN_AS_STRING = new com.google.gson.TypeAdapter<java.lang.Boolean>() { // from class: com.google.gson.internal.bind.TypeAdapters.4
        /* JADX WARN: Can't_renamed rename method to resolve collision */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: read */
        public java.lang.Boolean read2(com.google.gson.stream.JsonReader jsonReader) throws java.io.IOException {
            if (jsonReader.peek() == com.google.gson.stream.JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            return java.lang.Boolean.valueOf(jsonReader.nextString());
        }

        @Override // com.google.gson.TypeAdapter
        public void write(com.google.gson.stream.JsonWriter jsonWriter, java.lang.Boolean bool) throws java.io.IOException {
            jsonWriter.value(bool == null ? "null" : bool.toString());
        }
    };
    public static final com.google.gson.TypeAdapterFactory BOOLEAN_FACTORY = newFactory(java.lang.Boolean.TYPE, java.lang.Boolean.class, BOOLEAN);
    public static final com.google.gson.TypeAdapter<java.lang.Number> BYTE = new com.google.gson.TypeAdapter<java.lang.Number>() { // from class: com.google.gson.internal.bind.TypeAdapters.5
        /* JADX WARN: Can't_renamed rename method to resolve collision */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: read */
        public java.lang.Number read2(com.google.gson.stream.JsonReader jsonReader) throws java.io.IOException {
            if (jsonReader.peek() == com.google.gson.stream.JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            try {
                return java.lang.Byte.valueOf((byte) jsonReader.nextInt());
            } catch (java.lang.NumberFormatException e_renamed) {
                throw new com.google.gson.JsonSyntaxException(e_renamed);
            }
        }

        @Override // com.google.gson.TypeAdapter
        public void write(com.google.gson.stream.JsonWriter jsonWriter, java.lang.Number number) throws java.io.IOException {
            jsonWriter.value(number);
        }
    };
    public static final com.google.gson.TypeAdapterFactory BYTE_FACTORY = newFactory(java.lang.Byte.TYPE, java.lang.Byte.class, BYTE);
    public static final com.google.gson.TypeAdapter<java.lang.Number> SHORT = new com.google.gson.TypeAdapter<java.lang.Number>() { // from class: com.google.gson.internal.bind.TypeAdapters.6
        /* JADX WARN: Can't_renamed rename method to resolve collision */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: read */
        public java.lang.Number read2(com.google.gson.stream.JsonReader jsonReader) throws java.io.IOException {
            if (jsonReader.peek() == com.google.gson.stream.JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            try {
                return java.lang.Short.valueOf((short) jsonReader.nextInt());
            } catch (java.lang.NumberFormatException e_renamed) {
                throw new com.google.gson.JsonSyntaxException(e_renamed);
            }
        }

        @Override // com.google.gson.TypeAdapter
        public void write(com.google.gson.stream.JsonWriter jsonWriter, java.lang.Number number) throws java.io.IOException {
            jsonWriter.value(number);
        }
    };
    public static final com.google.gson.TypeAdapterFactory SHORT_FACTORY = newFactory(java.lang.Short.TYPE, java.lang.Short.class, SHORT);
    public static final com.google.gson.TypeAdapter<java.lang.Number> INTEGER = new com.google.gson.TypeAdapter<java.lang.Number>() { // from class: com.google.gson.internal.bind.TypeAdapters.7
        /* JADX WARN: Can't_renamed rename method to resolve collision */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: read */
        public java.lang.Number read2(com.google.gson.stream.JsonReader jsonReader) throws java.io.IOException {
            if (jsonReader.peek() == com.google.gson.stream.JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            try {
                return java.lang.Integer.valueOf(jsonReader.nextInt());
            } catch (java.lang.NumberFormatException e_renamed) {
                throw new com.google.gson.JsonSyntaxException(e_renamed);
            }
        }

        @Override // com.google.gson.TypeAdapter
        public void write(com.google.gson.stream.JsonWriter jsonWriter, java.lang.Number number) throws java.io.IOException {
            jsonWriter.value(number);
        }
    };
    public static final com.google.gson.TypeAdapterFactory INTEGER_FACTORY = newFactory(java.lang.Integer.TYPE, java.lang.Integer.class, INTEGER);
    public static final com.google.gson.TypeAdapter<java.util.concurrent.atomic.AtomicInteger> ATOMIC_INTEGER = new com.google.gson.TypeAdapter<java.util.concurrent.atomic.AtomicInteger>() { // from class: com.google.gson.internal.bind.TypeAdapters.8
        @Override // com.google.gson.TypeAdapter
        /* renamed from: read, reason: avoid collision after fix types in_renamed other method */
        public java.util.concurrent.atomic.AtomicInteger read2(com.google.gson.stream.JsonReader jsonReader) throws java.io.IOException {
            try {
                return new java.util.concurrent.atomic.AtomicInteger(jsonReader.nextInt());
            } catch (java.lang.NumberFormatException e_renamed) {
                throw new com.google.gson.JsonSyntaxException(e_renamed);
            }
        }

        @Override // com.google.gson.TypeAdapter
        public void write(com.google.gson.stream.JsonWriter jsonWriter, java.util.concurrent.atomic.AtomicInteger atomicInteger) throws java.io.IOException {
            jsonWriter.value(atomicInteger.get());
        }
    }.nullSafe();
    public static final com.google.gson.TypeAdapterFactory ATOMIC_INTEGER_FACTORY = newFactory(java.util.concurrent.atomic.AtomicInteger.class, ATOMIC_INTEGER);
    public static final com.google.gson.TypeAdapter<java.util.concurrent.atomic.AtomicBoolean> ATOMIC_BOOLEAN = new com.google.gson.TypeAdapter<java.util.concurrent.atomic.AtomicBoolean>() { // from class: com.google.gson.internal.bind.TypeAdapters.9
        @Override // com.google.gson.TypeAdapter
        /* renamed from: read, reason: avoid collision after fix types in_renamed other method */
        public java.util.concurrent.atomic.AtomicBoolean read2(com.google.gson.stream.JsonReader jsonReader) throws java.io.IOException {
            return new java.util.concurrent.atomic.AtomicBoolean(jsonReader.nextBoolean());
        }

        @Override // com.google.gson.TypeAdapter
        public void write(com.google.gson.stream.JsonWriter jsonWriter, java.util.concurrent.atomic.AtomicBoolean atomicBoolean) throws java.io.IOException {
            jsonWriter.value(atomicBoolean.get());
        }
    }.nullSafe();
    public static final com.google.gson.TypeAdapterFactory ATOMIC_BOOLEAN_FACTORY = newFactory(java.util.concurrent.atomic.AtomicBoolean.class, ATOMIC_BOOLEAN);
    public static final com.google.gson.TypeAdapter<java.util.concurrent.atomic.AtomicIntegerArray> ATOMIC_INTEGER_ARRAY = new com.google.gson.TypeAdapter<java.util.concurrent.atomic.AtomicIntegerArray>() { // from class: com.google.gson.internal.bind.TypeAdapters.10
        @Override // com.google.gson.TypeAdapter
        /* renamed from: read, reason: avoid collision after fix types in_renamed other method */
        public java.util.concurrent.atomic.AtomicIntegerArray read2(com.google.gson.stream.JsonReader jsonReader) throws java.io.IOException {
            java.util.ArrayList arrayList = new java.util.ArrayList();
            jsonReader.beginArray();
            while (jsonReader.hasNext()) {
                try {
                    arrayList.add(java.lang.Integer.valueOf(jsonReader.nextInt()));
                } catch (java.lang.NumberFormatException e_renamed) {
                    throw new com.google.gson.JsonSyntaxException(e_renamed);
                }
            }
            jsonReader.endArray();
            int size = arrayList.size();
            java.util.concurrent.atomic.AtomicIntegerArray atomicIntegerArray = new java.util.concurrent.atomic.AtomicIntegerArray(size);
            for (int i_renamed = 0; i_renamed < size; i_renamed++) {
                atomicIntegerArray.set(i_renamed, ((java.lang.Integer) arrayList.get(i_renamed)).intValue());
            }
            return atomicIntegerArray;
        }

        @Override // com.google.gson.TypeAdapter
        public void write(com.google.gson.stream.JsonWriter jsonWriter, java.util.concurrent.atomic.AtomicIntegerArray atomicIntegerArray) throws java.io.IOException {
            jsonWriter.beginArray();
            int length = atomicIntegerArray.length();
            for (int i_renamed = 0; i_renamed < length; i_renamed++) {
                jsonWriter.value(atomicIntegerArray.get(i_renamed));
            }
            jsonWriter.endArray();
        }
    }.nullSafe();
    public static final com.google.gson.TypeAdapterFactory ATOMIC_INTEGER_ARRAY_FACTORY = newFactory(java.util.concurrent.atomic.AtomicIntegerArray.class, ATOMIC_INTEGER_ARRAY);
    public static final com.google.gson.TypeAdapter<java.lang.Number> LONG = new com.google.gson.TypeAdapter<java.lang.Number>() { // from class: com.google.gson.internal.bind.TypeAdapters.11
        /* JADX WARN: Can't_renamed rename method to resolve collision */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: read */
        public java.lang.Number read2(com.google.gson.stream.JsonReader jsonReader) throws java.io.IOException {
            if (jsonReader.peek() == com.google.gson.stream.JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            try {
                return java.lang.Long.valueOf(jsonReader.nextLong());
            } catch (java.lang.NumberFormatException e_renamed) {
                throw new com.google.gson.JsonSyntaxException(e_renamed);
            }
        }

        @Override // com.google.gson.TypeAdapter
        public void write(com.google.gson.stream.JsonWriter jsonWriter, java.lang.Number number) throws java.io.IOException {
            jsonWriter.value(number);
        }
    };
    public static final com.google.gson.TypeAdapter<java.lang.Number> FLOAT = new com.google.gson.TypeAdapter<java.lang.Number>() { // from class: com.google.gson.internal.bind.TypeAdapters.12
        /* JADX WARN: Can't_renamed rename method to resolve collision */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: read */
        public java.lang.Number read2(com.google.gson.stream.JsonReader jsonReader) throws java.io.IOException {
            if (jsonReader.peek() == com.google.gson.stream.JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            return java.lang.Float.valueOf((float) jsonReader.nextDouble());
        }

        @Override // com.google.gson.TypeAdapter
        public void write(com.google.gson.stream.JsonWriter jsonWriter, java.lang.Number number) throws java.io.IOException {
            jsonWriter.value(number);
        }
    };
    public static final com.google.gson.TypeAdapter<java.lang.Number> DOUBLE = new com.google.gson.TypeAdapter<java.lang.Number>() { // from class: com.google.gson.internal.bind.TypeAdapters.13
        /* JADX WARN: Can't_renamed rename method to resolve collision */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: read */
        public java.lang.Number read2(com.google.gson.stream.JsonReader jsonReader) throws java.io.IOException {
            if (jsonReader.peek() == com.google.gson.stream.JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            return java.lang.Double.valueOf(jsonReader.nextDouble());
        }

        @Override // com.google.gson.TypeAdapter
        public void write(com.google.gson.stream.JsonWriter jsonWriter, java.lang.Number number) throws java.io.IOException {
            jsonWriter.value(number);
        }
    };
    public static final com.google.gson.TypeAdapter<java.lang.Number> NUMBER = new com.google.gson.TypeAdapter<java.lang.Number>() { // from class: com.google.gson.internal.bind.TypeAdapters.14
        /* JADX WARN: Can't_renamed rename method to resolve collision */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: read */
        public java.lang.Number read2(com.google.gson.stream.JsonReader jsonReader) throws java.io.IOException {
            com.google.gson.stream.JsonToken jsonTokenPeek = jsonReader.peek();
            int i_renamed = com.google.gson.internal.bind.TypeAdapters.AnonymousClass36.$SwitchMap$com$google$gson$stream$JsonToken[jsonTokenPeek.ordinal()];
            if (i_renamed == 1) {
                return new com.google.gson.internal.LazilyParsedNumber(jsonReader.nextString());
            }
            if (i_renamed == 4) {
                jsonReader.nextNull();
                return null;
            }
            throw new com.google.gson.JsonSyntaxException("Expecting number, got: " + jsonTokenPeek);
        }

        @Override // com.google.gson.TypeAdapter
        public void write(com.google.gson.stream.JsonWriter jsonWriter, java.lang.Number number) throws java.io.IOException {
            jsonWriter.value(number);
        }
    };
    public static final com.google.gson.TypeAdapterFactory NUMBER_FACTORY = newFactory(java.lang.Number.class, NUMBER);
    public static final com.google.gson.TypeAdapter<java.lang.Character> CHARACTER = new com.google.gson.TypeAdapter<java.lang.Character>() { // from class: com.google.gson.internal.bind.TypeAdapters.15
        /* JADX WARN: Can't_renamed rename method to resolve collision */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: read */
        public java.lang.Character read2(com.google.gson.stream.JsonReader jsonReader) throws java.io.IOException {
            if (jsonReader.peek() == com.google.gson.stream.JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            java.lang.String strNextString = jsonReader.nextString();
            if (strNextString.length() != 1) {
                throw new com.google.gson.JsonSyntaxException("Expecting character, got: " + strNextString);
            }
            return java.lang.Character.valueOf(strNextString.charAt(0));
        }

        @Override // com.google.gson.TypeAdapter
        public void write(com.google.gson.stream.JsonWriter jsonWriter, java.lang.Character ch_renamed) throws java.io.IOException {
            jsonWriter.value(ch_renamed == null ? null : java.lang.String.valueOf(ch_renamed));
        }
    };
    public static final com.google.gson.TypeAdapterFactory CHARACTER_FACTORY = newFactory(java.lang.Character.TYPE, java.lang.Character.class, CHARACTER);
    public static final com.google.gson.TypeAdapter<java.lang.String> STRING = new com.google.gson.TypeAdapter<java.lang.String>() { // from class: com.google.gson.internal.bind.TypeAdapters.16
        @Override // com.google.gson.TypeAdapter
        /* renamed from: read, reason: avoid collision after fix types in_renamed other method */
        public java.lang.String read2(com.google.gson.stream.JsonReader jsonReader) throws java.io.IOException {
            com.google.gson.stream.JsonToken jsonTokenPeek = jsonReader.peek();
            if (jsonTokenPeek == com.google.gson.stream.JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            if (jsonTokenPeek == com.google.gson.stream.JsonToken.BOOLEAN) {
                return java.lang.Boolean.toString(jsonReader.nextBoolean());
            }
            return jsonReader.nextString();
        }

        @Override // com.google.gson.TypeAdapter
        public void write(com.google.gson.stream.JsonWriter jsonWriter, java.lang.String str) throws java.io.IOException {
            jsonWriter.value(str);
        }
    };
    public static final com.google.gson.TypeAdapter<java.math.BigDecimal> BIG_DECIMAL = new com.google.gson.TypeAdapter<java.math.BigDecimal>() { // from class: com.google.gson.internal.bind.TypeAdapters.17
        @Override // com.google.gson.TypeAdapter
        /* renamed from: read, reason: avoid collision after fix types in_renamed other method */
        public java.math.BigDecimal read2(com.google.gson.stream.JsonReader jsonReader) throws java.io.IOException {
            if (jsonReader.peek() == com.google.gson.stream.JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            try {
                return new java.math.BigDecimal(jsonReader.nextString());
            } catch (java.lang.NumberFormatException e_renamed) {
                throw new com.google.gson.JsonSyntaxException(e_renamed);
            }
        }

        @Override // com.google.gson.TypeAdapter
        public void write(com.google.gson.stream.JsonWriter jsonWriter, java.math.BigDecimal bigDecimal) throws java.io.IOException {
            jsonWriter.value(bigDecimal);
        }
    };
    public static final com.google.gson.TypeAdapter<java.math.BigInteger> BIG_INTEGER = new com.google.gson.TypeAdapter<java.math.BigInteger>() { // from class: com.google.gson.internal.bind.TypeAdapters.18
        @Override // com.google.gson.TypeAdapter
        /* renamed from: read, reason: avoid collision after fix types in_renamed other method */
        public java.math.BigInteger read2(com.google.gson.stream.JsonReader jsonReader) throws java.io.IOException {
            if (jsonReader.peek() == com.google.gson.stream.JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            try {
                return new java.math.BigInteger(jsonReader.nextString());
            } catch (java.lang.NumberFormatException e_renamed) {
                throw new com.google.gson.JsonSyntaxException(e_renamed);
            }
        }

        @Override // com.google.gson.TypeAdapter
        public void write(com.google.gson.stream.JsonWriter jsonWriter, java.math.BigInteger bigInteger) throws java.io.IOException {
            jsonWriter.value(bigInteger);
        }
    };
    public static final com.google.gson.TypeAdapterFactory STRING_FACTORY = newFactory(java.lang.String.class, STRING);
    public static final com.google.gson.TypeAdapter<java.lang.StringBuilder> STRING_BUILDER = new com.google.gson.TypeAdapter<java.lang.StringBuilder>() { // from class: com.google.gson.internal.bind.TypeAdapters.19
        @Override // com.google.gson.TypeAdapter
        /* renamed from: read, reason: avoid collision after fix types in_renamed other method */
        public java.lang.StringBuilder read2(com.google.gson.stream.JsonReader jsonReader) throws java.io.IOException {
            if (jsonReader.peek() == com.google.gson.stream.JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            return new java.lang.StringBuilder(jsonReader.nextString());
        }

        @Override // com.google.gson.TypeAdapter
        public void write(com.google.gson.stream.JsonWriter jsonWriter, java.lang.StringBuilder sb) throws java.io.IOException {
            jsonWriter.value(sb == null ? null : sb.toString());
        }
    };
    public static final com.google.gson.TypeAdapterFactory STRING_BUILDER_FACTORY = newFactory(java.lang.StringBuilder.class, STRING_BUILDER);
    public static final com.google.gson.TypeAdapter<java.lang.StringBuffer> STRING_BUFFER = new com.google.gson.TypeAdapter<java.lang.StringBuffer>() { // from class: com.google.gson.internal.bind.TypeAdapters.20
        @Override // com.google.gson.TypeAdapter
        /* renamed from: read, reason: avoid collision after fix types in_renamed other method */
        public java.lang.StringBuffer read2(com.google.gson.stream.JsonReader jsonReader) throws java.io.IOException {
            if (jsonReader.peek() == com.google.gson.stream.JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            return new java.lang.StringBuffer(jsonReader.nextString());
        }

        @Override // com.google.gson.TypeAdapter
        public void write(com.google.gson.stream.JsonWriter jsonWriter, java.lang.StringBuffer stringBuffer) throws java.io.IOException {
            jsonWriter.value(stringBuffer == null ? null : stringBuffer.toString());
        }
    };
    public static final com.google.gson.TypeAdapterFactory STRING_BUFFER_FACTORY = newFactory(java.lang.StringBuffer.class, STRING_BUFFER);
    public static final com.google.gson.TypeAdapter<java.net.URL> URL = new com.google.gson.TypeAdapter<java.net.URL>() { // from class: com.google.gson.internal.bind.TypeAdapters.21
        @Override // com.google.gson.TypeAdapter
        /* renamed from: read, reason: avoid collision after fix types in_renamed other method */
        public java.net.URL read2(com.google.gson.stream.JsonReader jsonReader) throws java.io.IOException {
            if (jsonReader.peek() == com.google.gson.stream.JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            java.lang.String strNextString = jsonReader.nextString();
            if ("null".equals(strNextString)) {
                return null;
            }
            return new java.net.URL(strNextString);
        }

        @Override // com.google.gson.TypeAdapter
        public void write(com.google.gson.stream.JsonWriter jsonWriter, java.net.URL url) throws java.io.IOException {
            jsonWriter.value(url == null ? null : url.toExternalForm());
        }
    };
    public static final com.google.gson.TypeAdapterFactory URL_FACTORY = newFactory(java.net.URL.class, URL);
    public static final com.google.gson.TypeAdapter<java.net.URI> URI = new com.google.gson.TypeAdapter<java.net.URI>() { // from class: com.google.gson.internal.bind.TypeAdapters.22
        @Override // com.google.gson.TypeAdapter
        /* renamed from: read, reason: avoid collision after fix types in_renamed other method */
        public java.net.URI read2(com.google.gson.stream.JsonReader jsonReader) throws java.io.IOException {
            if (jsonReader.peek() == com.google.gson.stream.JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            try {
                java.lang.String strNextString = jsonReader.nextString();
                if ("null".equals(strNextString)) {
                    return null;
                }
                return new java.net.URI(strNextString);
            } catch (java.net.URISyntaxException e_renamed) {
                throw new com.google.gson.JsonIOException(e_renamed);
            }
        }

        @Override // com.google.gson.TypeAdapter
        public void write(com.google.gson.stream.JsonWriter jsonWriter, java.net.URI uri) throws java.io.IOException {
            jsonWriter.value(uri == null ? null : uri.toASCIIString());
        }
    };
    public static final com.google.gson.TypeAdapterFactory URI_FACTORY = newFactory(java.net.URI.class, URI);
    public static final com.google.gson.TypeAdapter<java.net.InetAddress> INET_ADDRESS = new com.google.gson.TypeAdapter<java.net.InetAddress>() { // from class: com.google.gson.internal.bind.TypeAdapters.23
        @Override // com.google.gson.TypeAdapter
        /* renamed from: read, reason: avoid collision after fix types in_renamed other method */
        public java.net.InetAddress read2(com.google.gson.stream.JsonReader jsonReader) throws java.io.IOException {
            if (jsonReader.peek() == com.google.gson.stream.JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            return java.net.InetAddress.getByName(jsonReader.nextString());
        }

        @Override // com.google.gson.TypeAdapter
        public void write(com.google.gson.stream.JsonWriter jsonWriter, java.net.InetAddress inetAddress) throws java.io.IOException {
            jsonWriter.value(inetAddress == null ? null : inetAddress.getHostAddress());
        }
    };
    public static final com.google.gson.TypeAdapterFactory INET_ADDRESS_FACTORY = newTypeHierarchyFactory(java.net.InetAddress.class, INET_ADDRESS);
    public static final com.google.gson.TypeAdapter<java.util.UUID> UUID = new com.google.gson.TypeAdapter<java.util.UUID>() { // from class: com.google.gson.internal.bind.TypeAdapters.24
        @Override // com.google.gson.TypeAdapter
        /* renamed from: read, reason: avoid collision after fix types in_renamed other method */
        public java.util.UUID read2(com.google.gson.stream.JsonReader jsonReader) throws java.io.IOException {
            if (jsonReader.peek() == com.google.gson.stream.JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            return java.util.UUID.fromString(jsonReader.nextString());
        }

        @Override // com.google.gson.TypeAdapter
        public void write(com.google.gson.stream.JsonWriter jsonWriter, java.util.UUID uuid) throws java.io.IOException {
            jsonWriter.value(uuid == null ? null : uuid.toString());
        }
    };
    public static final com.google.gson.TypeAdapterFactory UUID_FACTORY = newFactory(java.util.UUID.class, UUID);
    public static final com.google.gson.TypeAdapter<java.util.Currency> CURRENCY = new com.google.gson.TypeAdapter<java.util.Currency>() { // from class: com.google.gson.internal.bind.TypeAdapters.25
        @Override // com.google.gson.TypeAdapter
        /* renamed from: read, reason: avoid collision after fix types in_renamed other method */
        public java.util.Currency read2(com.google.gson.stream.JsonReader jsonReader) throws java.io.IOException {
            return java.util.Currency.getInstance(jsonReader.nextString());
        }

        @Override // com.google.gson.TypeAdapter
        public void write(com.google.gson.stream.JsonWriter jsonWriter, java.util.Currency currency) throws java.io.IOException {
            jsonWriter.value(currency.getCurrencyCode());
        }
    }.nullSafe();
    public static final com.google.gson.TypeAdapterFactory CURRENCY_FACTORY = newFactory(java.util.Currency.class, CURRENCY);
    public static final com.google.gson.TypeAdapterFactory TIMESTAMP_FACTORY = new com.google.gson.TypeAdapterFactory() { // from class: com.google.gson.internal.bind.TypeAdapters.26
        @Override // com.google.gson.TypeAdapterFactory
        public <T_renamed> com.google.gson.TypeAdapter<T_renamed> create(com.google.gson.Gson gson, com.google.gson.reflect.TypeToken<T_renamed> typeToken) {
            if (typeToken.getRawType() != java.sql.Timestamp.class) {
                return null;
            }
            final com.google.gson.TypeAdapter<T_renamed> adapter = gson.getAdapter(java.util.Date.class);
            return (com.google.gson.TypeAdapter<T_renamed>) new com.google.gson.TypeAdapter<java.sql.Timestamp>() { // from class: com.google.gson.internal.bind.TypeAdapters.26.1
                @Override // com.google.gson.TypeAdapter
                /* renamed from: read, reason: avoid collision after fix types in_renamed other method */
                public java.sql.Timestamp read2(com.google.gson.stream.JsonReader jsonReader) throws java.io.IOException {
                    java.util.Date date = (java.util.Date) adapter.read2(jsonReader);
                    if (date != null) {
                        return new java.sql.Timestamp(date.getTime());
                    }
                    return null;
                }

                @Override // com.google.gson.TypeAdapter
                public void write(com.google.gson.stream.JsonWriter jsonWriter, java.sql.Timestamp timestamp) throws java.io.IOException {
                    adapter.write(jsonWriter, timestamp);
                }
            };
        }
    };
    public static final com.google.gson.TypeAdapter<java.util.Calendar> CALENDAR = new com.google.gson.TypeAdapter<java.util.Calendar>() { // from class: com.google.gson.internal.bind.TypeAdapters.27
        private static final java.lang.String DAY_OF_MONTH = "dayOfMonth";
        private static final java.lang.String HOUR_OF_DAY = "hourOfDay";
        private static final java.lang.String MINUTE = "minute";
        private static final java.lang.String MONTH = "month";
        private static final java.lang.String SECOND = "second";
        private static final java.lang.String YEAR = "year";

        @Override // com.google.gson.TypeAdapter
        /* renamed from: read, reason: avoid collision after fix types in_renamed other method */
        public java.util.Calendar read2(com.google.gson.stream.JsonReader jsonReader) throws java.io.IOException, java.lang.NumberFormatException {
            if (jsonReader.peek() == com.google.gson.stream.JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            jsonReader.beginObject();
            int i_renamed = 0;
            int i2 = 0;
            int i3 = 0;
            int i4 = 0;
            int i5 = 0;
            int i6 = 0;
            while (jsonReader.peek() != com.google.gson.stream.JsonToken.END_OBJECT) {
                java.lang.String strNextName = jsonReader.nextName();
                int iNextInt = jsonReader.nextInt();
                if (YEAR.equals(strNextName)) {
                    i_renamed = iNextInt;
                } else if (MONTH.equals(strNextName)) {
                    i2 = iNextInt;
                } else if (DAY_OF_MONTH.equals(strNextName)) {
                    i3 = iNextInt;
                } else if (HOUR_OF_DAY.equals(strNextName)) {
                    i4 = iNextInt;
                } else if (MINUTE.equals(strNextName)) {
                    i5 = iNextInt;
                } else if (SECOND.equals(strNextName)) {
                    i6 = iNextInt;
                }
            }
            jsonReader.endObject();
            return new java.util.GregorianCalendar(i_renamed, i2, i3, i4, i5, i6);
        }

        @Override // com.google.gson.TypeAdapter
        public void write(com.google.gson.stream.JsonWriter jsonWriter, java.util.Calendar calendar) throws java.io.IOException {
            if (calendar == null) {
                jsonWriter.nullValue();
                return;
            }
            jsonWriter.beginObject();
            jsonWriter.name(YEAR);
            jsonWriter.value(calendar.get(1));
            jsonWriter.name(MONTH);
            jsonWriter.value(calendar.get(2));
            jsonWriter.name(DAY_OF_MONTH);
            jsonWriter.value(calendar.get(5));
            jsonWriter.name(HOUR_OF_DAY);
            jsonWriter.value(calendar.get(11));
            jsonWriter.name(MINUTE);
            jsonWriter.value(calendar.get(12));
            jsonWriter.name(SECOND);
            jsonWriter.value(calendar.get(13));
            jsonWriter.endObject();
        }
    };
    public static final com.google.gson.TypeAdapterFactory CALENDAR_FACTORY = newFactoryForMultipleTypes(java.util.Calendar.class, java.util.GregorianCalendar.class, CALENDAR);
    public static final com.google.gson.TypeAdapter<java.util.Locale> LOCALE = new com.google.gson.TypeAdapter<java.util.Locale>() { // from class: com.google.gson.internal.bind.TypeAdapters.28
        @Override // com.google.gson.TypeAdapter
        /* renamed from: read, reason: avoid collision after fix types in_renamed other method */
        public java.util.Locale read2(com.google.gson.stream.JsonReader jsonReader) throws java.io.IOException {
            if (jsonReader.peek() == com.google.gson.stream.JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            java.util.StringTokenizer stringTokenizer = new java.util.StringTokenizer(jsonReader.nextString(), "_");
            java.lang.String strNextToken = stringTokenizer.hasMoreElements() ? stringTokenizer.nextToken() : null;
            java.lang.String strNextToken2 = stringTokenizer.hasMoreElements() ? stringTokenizer.nextToken() : null;
            java.lang.String strNextToken3 = stringTokenizer.hasMoreElements() ? stringTokenizer.nextToken() : null;
            if (strNextToken2 == null && strNextToken3 == null) {
                return new java.util.Locale(strNextToken);
            }
            if (strNextToken3 == null) {
                return new java.util.Locale(strNextToken, strNextToken2);
            }
            return new java.util.Locale(strNextToken, strNextToken2, strNextToken3);
        }

        @Override // com.google.gson.TypeAdapter
        public void write(com.google.gson.stream.JsonWriter jsonWriter, java.util.Locale locale) throws java.io.IOException {
            jsonWriter.value(locale == null ? null : locale.toString());
        }
    };
    public static final com.google.gson.TypeAdapterFactory LOCALE_FACTORY = newFactory(java.util.Locale.class, LOCALE);
    public static final com.google.gson.TypeAdapter<com.google.gson.JsonElement> JSON_ELEMENT = new com.google.gson.TypeAdapter<com.google.gson.JsonElement>() { // from class: com.google.gson.internal.bind.TypeAdapters.29
        /* JADX WARN: Can't_renamed rename method to resolve collision */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: read */
        public com.google.gson.JsonElement read2(com.google.gson.stream.JsonReader jsonReader) throws java.io.IOException {
            switch (com.google.gson.internal.bind.TypeAdapters.AnonymousClass36.$SwitchMap$com$google$gson$stream$JsonToken[jsonReader.peek().ordinal()]) {
                case 1:
                    return new com.google.gson.JsonPrimitive((java.lang.Number) new com.google.gson.internal.LazilyParsedNumber(jsonReader.nextString()));
                case 2:
                    return new com.google.gson.JsonPrimitive(java.lang.Boolean.valueOf(jsonReader.nextBoolean()));
                case 3:
                    return new com.google.gson.JsonPrimitive(jsonReader.nextString());
                case 4:
                    jsonReader.nextNull();
                    return com.google.gson.JsonNull.INSTANCE;
                case 5:
                    com.google.gson.JsonArray jsonArray = new com.google.gson.JsonArray();
                    jsonReader.beginArray();
                    while (jsonReader.hasNext()) {
                        jsonArray.add(read2(jsonReader));
                    }
                    jsonReader.endArray();
                    return jsonArray;
                case 6:
                    com.google.gson.JsonObject jsonObject = new com.google.gson.JsonObject();
                    jsonReader.beginObject();
                    while (jsonReader.hasNext()) {
                        jsonObject.add(jsonReader.nextName(), read2(jsonReader));
                    }
                    jsonReader.endObject();
                    return jsonObject;
                default:
                    throw new java.lang.IllegalArgumentException();
            }
        }

        @Override // com.google.gson.TypeAdapter
        public void write(com.google.gson.stream.JsonWriter jsonWriter, com.google.gson.JsonElement jsonElement) throws java.io.IOException {
            if (jsonElement == null || jsonElement.isJsonNull()) {
                jsonWriter.nullValue();
                return;
            }
            if (jsonElement.isJsonPrimitive()) {
                com.google.gson.JsonPrimitive asJsonPrimitive = jsonElement.getAsJsonPrimitive();
                if (asJsonPrimitive.isNumber()) {
                    jsonWriter.value(asJsonPrimitive.getAsNumber());
                    return;
                } else if (asJsonPrimitive.isBoolean()) {
                    jsonWriter.value(asJsonPrimitive.getAsBoolean());
                    return;
                } else {
                    jsonWriter.value(asJsonPrimitive.getAsString());
                    return;
                }
            }
            if (jsonElement.isJsonArray()) {
                jsonWriter.beginArray();
                java.util.Iterator<com.google.gson.JsonElement> it = jsonElement.getAsJsonArray().iterator();
                while (it.hasNext()) {
                    write(jsonWriter, it.next());
                }
                jsonWriter.endArray();
                return;
            }
            if (jsonElement.isJsonObject()) {
                jsonWriter.beginObject();
                for (java.util.Map.Entry<java.lang.String, com.google.gson.JsonElement> entry : jsonElement.getAsJsonObject().entrySet()) {
                    jsonWriter.name(entry.getKey());
                    write(jsonWriter, entry.getValue());
                }
                jsonWriter.endObject();
                return;
            }
            throw new java.lang.IllegalArgumentException("Couldn't_renamed write " + jsonElement.getClass());
        }
    };
    public static final com.google.gson.TypeAdapterFactory JSON_ELEMENT_FACTORY = newTypeHierarchyFactory(com.google.gson.JsonElement.class, JSON_ELEMENT);
    public static final com.google.gson.TypeAdapterFactory ENUM_FACTORY = new com.google.gson.TypeAdapterFactory() { // from class: com.google.gson.internal.bind.TypeAdapters.30
        @Override // com.google.gson.TypeAdapterFactory
        public <T_renamed> com.google.gson.TypeAdapter<T_renamed> create(com.google.gson.Gson gson, com.google.gson.reflect.TypeToken<T_renamed> typeToken) {
            java.lang.Class<? super T_renamed> rawType = typeToken.getRawType();
            if (!java.lang.Enum.class.isAssignableFrom(rawType) || rawType == java.lang.Enum.class) {
                return null;
            }
            if (!rawType.isEnum()) {
                rawType = rawType.getSuperclass();
            }
            return new com.google.gson.internal.bind.TypeAdapters.EnumTypeAdapter(rawType);
        }
    };

    private TypeAdapters() {
        throw new java.lang.UnsupportedOperationException();
    }

    /* renamed from: com.google.gson.internal.bind.TypeAdapters$36, reason: invalid class name */
    static /* synthetic */ class AnonymousClass36 {
        static final /* synthetic */ int[] $SwitchMap$com$google$gson$stream$JsonToken = new int[com.google.gson.stream.JsonToken.values().length];

        static {
            try {
                $SwitchMap$com$google$gson$stream$JsonToken[com.google.gson.stream.JsonToken.NUMBER.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$gson$stream$JsonToken[com.google.gson.stream.JsonToken.BOOLEAN.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$gson$stream$JsonToken[com.google.gson.stream.JsonToken.STRING.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$google$gson$stream$JsonToken[com.google.gson.stream.JsonToken.NULL.ordinal()] = 4;
            } catch (java.lang.NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$google$gson$stream$JsonToken[com.google.gson.stream.JsonToken.BEGIN_ARRAY.ordinal()] = 5;
            } catch (java.lang.NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$google$gson$stream$JsonToken[com.google.gson.stream.JsonToken.BEGIN_OBJECT.ordinal()] = 6;
            } catch (java.lang.NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$google$gson$stream$JsonToken[com.google.gson.stream.JsonToken.END_DOCUMENT.ordinal()] = 7;
            } catch (java.lang.NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$google$gson$stream$JsonToken[com.google.gson.stream.JsonToken.NAME.ordinal()] = 8;
            } catch (java.lang.NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$google$gson$stream$JsonToken[com.google.gson.stream.JsonToken.END_OBJECT.ordinal()] = 9;
            } catch (java.lang.NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$google$gson$stream$JsonToken[com.google.gson.stream.JsonToken.END_ARRAY.ordinal()] = 10;
            } catch (java.lang.NoSuchFieldError unused10) {
            }
        }
    }

    private static final class EnumTypeAdapter<T_renamed extends java.lang.Enum<T_renamed>> extends com.google.gson.TypeAdapter<T_renamed> {
        private final java.util.Map<java.lang.String, T_renamed> nameToConstant = new java.util.HashMap();
        private final java.util.Map<T_renamed, java.lang.String> constantToName = new java.util.HashMap();

        public EnumTypeAdapter(java.lang.Class<T_renamed> cls) {
            try {
                for (T_renamed t_renamed : cls.getEnumConstants()) {
                    java.lang.String strName = t_renamed.name();
                    com.google.gson.annotations.SerializedName serializedName = (com.google.gson.annotations.SerializedName) cls.getField(strName).getAnnotation(com.google.gson.annotations.SerializedName.class);
                    if (serializedName != null) {
                        strName = serializedName.value();
                        for (java.lang.String str : serializedName.alternate()) {
                            this.nameToConstant.put(str, t_renamed);
                        }
                    }
                    this.nameToConstant.put(strName, t_renamed);
                    this.constantToName.put(t_renamed, strName);
                }
            } catch (java.lang.NoSuchFieldException e_renamed) {
                throw new java.lang.AssertionError("Missing field in_renamed " + cls.getName(), e_renamed);
            }
        }

        @Override // com.google.gson.TypeAdapter
        /* renamed from: read */
        public T_renamed read2(com.google.gson.stream.JsonReader jsonReader) throws java.io.IOException {
            if (jsonReader.peek() == com.google.gson.stream.JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            return this.nameToConstant.get(jsonReader.nextString());
        }

        @Override // com.google.gson.TypeAdapter
        public void write(com.google.gson.stream.JsonWriter jsonWriter, T_renamed t_renamed) throws java.io.IOException {
            jsonWriter.value(t_renamed == null ? null : this.constantToName.get(t_renamed));
        }
    }

    public static <TT> com.google.gson.TypeAdapterFactory newFactory(final com.google.gson.reflect.TypeToken<TT> typeToken, final com.google.gson.TypeAdapter<TT> typeAdapter) {
        return new com.google.gson.TypeAdapterFactory() { // from class: com.google.gson.internal.bind.TypeAdapters.31
            @Override // com.google.gson.TypeAdapterFactory
            public <T_renamed> com.google.gson.TypeAdapter<T_renamed> create(com.google.gson.Gson gson, com.google.gson.reflect.TypeToken<T_renamed> typeToken2) {
                if (typeToken2.equals(typeToken)) {
                    return typeAdapter;
                }
                return null;
            }
        };
    }

    public static <TT> com.google.gson.TypeAdapterFactory newFactory(final java.lang.Class<TT> cls, final com.google.gson.TypeAdapter<TT> typeAdapter) {
        return new com.google.gson.TypeAdapterFactory() { // from class: com.google.gson.internal.bind.TypeAdapters.32
            @Override // com.google.gson.TypeAdapterFactory
            public <T_renamed> com.google.gson.TypeAdapter<T_renamed> create(com.google.gson.Gson gson, com.google.gson.reflect.TypeToken<T_renamed> typeToken) {
                if (typeToken.getRawType() == cls) {
                    return typeAdapter;
                }
                return null;
            }

            public java.lang.String toString() {
                return "Factory[type=" + cls.getName() + ",adapter=" + typeAdapter + "]";
            }
        };
    }

    public static <TT> com.google.gson.TypeAdapterFactory newFactory(final java.lang.Class<TT> cls, final java.lang.Class<TT> cls2, final com.google.gson.TypeAdapter<? super TT> typeAdapter) {
        return new com.google.gson.TypeAdapterFactory() { // from class: com.google.gson.internal.bind.TypeAdapters.33
            @Override // com.google.gson.TypeAdapterFactory
            public <T_renamed> com.google.gson.TypeAdapter<T_renamed> create(com.google.gson.Gson gson, com.google.gson.reflect.TypeToken<T_renamed> typeToken) {
                java.lang.Class<? super T_renamed> rawType = typeToken.getRawType();
                if (rawType == cls || rawType == cls2) {
                    return typeAdapter;
                }
                return null;
            }

            public java.lang.String toString() {
                return "Factory[type=" + cls2.getName() + "+" + cls.getName() + ",adapter=" + typeAdapter + "]";
            }
        };
    }

    public static <TT> com.google.gson.TypeAdapterFactory newFactoryForMultipleTypes(final java.lang.Class<TT> cls, final java.lang.Class<? extends TT> cls2, final com.google.gson.TypeAdapter<? super TT> typeAdapter) {
        return new com.google.gson.TypeAdapterFactory() { // from class: com.google.gson.internal.bind.TypeAdapters.34
            @Override // com.google.gson.TypeAdapterFactory
            public <T_renamed> com.google.gson.TypeAdapter<T_renamed> create(com.google.gson.Gson gson, com.google.gson.reflect.TypeToken<T_renamed> typeToken) {
                java.lang.Class<? super T_renamed> rawType = typeToken.getRawType();
                if (rawType == cls || rawType == cls2) {
                    return typeAdapter;
                }
                return null;
            }

            public java.lang.String toString() {
                return "Factory[type=" + cls.getName() + "+" + cls2.getName() + ",adapter=" + typeAdapter + "]";
            }
        };
    }

    public static <T1_renamed> com.google.gson.TypeAdapterFactory newTypeHierarchyFactory(final java.lang.Class<T1_renamed> cls, final com.google.gson.TypeAdapter<T1_renamed> typeAdapter) {
        return new com.google.gson.TypeAdapterFactory() { // from class: com.google.gson.internal.bind.TypeAdapters.35
            @Override // com.google.gson.TypeAdapterFactory
            public <T2_renamed> com.google.gson.TypeAdapter<T2_renamed> create(com.google.gson.Gson gson, com.google.gson.reflect.TypeToken<T2_renamed> typeToken) {
                final java.lang.Class<? super T2_renamed> rawType = typeToken.getRawType();
                if (cls.isAssignableFrom(rawType)) {
                    return (com.google.gson.TypeAdapter<T2_renamed>) new com.google.gson.TypeAdapter<T1_renamed>() { // from class: com.google.gson.internal.bind.TypeAdapters.35.1
                        @Override // com.google.gson.TypeAdapter
                        public void write(com.google.gson.stream.JsonWriter jsonWriter, T1_renamed t1) throws java.io.IOException {
                            typeAdapter.write(jsonWriter, t1);
                        }

                        @Override // com.google.gson.TypeAdapter
                        /* renamed from: read */
                        public T1_renamed read2(com.google.gson.stream.JsonReader jsonReader) throws java.io.IOException {
                            T1_renamed t1 = (T1_renamed) typeAdapter.read2(jsonReader);
                            if (t1 == null || rawType.isInstance(t1)) {
                                return t1;
                            }
                            throw new com.google.gson.JsonSyntaxException("Expected a_renamed " + rawType.getName() + " but was " + t1.getClass().getName());
                        }
                    };
                }
                return null;
            }

            public java.lang.String toString() {
                return "Factory[typeHierarchy=" + cls.getName() + ",adapter=" + typeAdapter + "]";
            }
        };
    }
}

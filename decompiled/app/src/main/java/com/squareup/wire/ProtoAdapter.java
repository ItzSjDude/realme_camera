package com.squareup.wire;

/* loaded from: classes2.dex */
public abstract class ProtoAdapter<E_renamed> {
    private static final int FIXED_32_SIZE = 4;
    private static final int FIXED_64_SIZE = 8;
    private static final int FIXED_BOOL_SIZE = 1;
    private final com.squareup.wire.FieldEncoding fieldEncoding;
    final java.lang.Class<?> javaType;
    com.squareup.wire.ProtoAdapter<java.util.List<E_renamed>> packedAdapter;
    com.squareup.wire.ProtoAdapter<java.util.List<E_renamed>> repeatedAdapter;
    public static final com.squareup.wire.ProtoAdapter<java.lang.Boolean> BOOL = new com.squareup.wire.ProtoAdapter<java.lang.Boolean>(com.squareup.wire.FieldEncoding.VARINT, java.lang.Boolean.class) { // from class: com.squareup.wire.ProtoAdapter.1
        @Override // com.squareup.wire.ProtoAdapter
        public int encodedSize(java.lang.Boolean bool) {
            return 1;
        }

        @Override // com.squareup.wire.ProtoAdapter
        public void encode(com.squareup.wire.ProtoWriter protoWriter, java.lang.Boolean bool) throws java.io.IOException {
            protoWriter.writeVarint32(bool.booleanValue() ? 1 : 0);
        }

        /* JADX WARN: Can't_renamed rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public java.lang.Boolean decode(com.squareup.wire.ProtoReader protoReader) throws java.io.IOException {
            int varint32 = protoReader.readVarint32();
            if (varint32 == 0) {
                return java.lang.Boolean.FALSE;
            }
            if (varint32 == 1) {
                return java.lang.Boolean.TRUE;
            }
            throw new java.io.IOException(java.lang.String.format("Invalid boolean value 0x%02x", java.lang.Integer.valueOf(varint32)));
        }
    };
    public static final com.squareup.wire.ProtoAdapter<java.lang.Integer> INT32 = new com.squareup.wire.ProtoAdapter<java.lang.Integer>(com.squareup.wire.FieldEncoding.VARINT, java.lang.Integer.class) { // from class: com.squareup.wire.ProtoAdapter.2
        @Override // com.squareup.wire.ProtoAdapter
        public int encodedSize(java.lang.Integer num) {
            return com.squareup.wire.ProtoWriter.int32Size(num.intValue());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public void encode(com.squareup.wire.ProtoWriter protoWriter, java.lang.Integer num) throws java.io.IOException {
            protoWriter.writeSignedVarint32(num.intValue());
        }

        /* JADX WARN: Can't_renamed rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public java.lang.Integer decode(com.squareup.wire.ProtoReader protoReader) throws java.io.IOException {
            return java.lang.Integer.valueOf(protoReader.readVarint32());
        }
    };
    public static final com.squareup.wire.ProtoAdapter<java.lang.Integer> UINT32 = new com.squareup.wire.ProtoAdapter<java.lang.Integer>(com.squareup.wire.FieldEncoding.VARINT, java.lang.Integer.class) { // from class: com.squareup.wire.ProtoAdapter.3
        @Override // com.squareup.wire.ProtoAdapter
        public int encodedSize(java.lang.Integer num) {
            return com.squareup.wire.ProtoWriter.varint32Size(num.intValue());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public void encode(com.squareup.wire.ProtoWriter protoWriter, java.lang.Integer num) throws java.io.IOException {
            protoWriter.writeVarint32(num.intValue());
        }

        /* JADX WARN: Can't_renamed rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public java.lang.Integer decode(com.squareup.wire.ProtoReader protoReader) throws java.io.IOException {
            return java.lang.Integer.valueOf(protoReader.readVarint32());
        }
    };
    public static final com.squareup.wire.ProtoAdapter<java.lang.Integer> SINT32 = new com.squareup.wire.ProtoAdapter<java.lang.Integer>(com.squareup.wire.FieldEncoding.VARINT, java.lang.Integer.class) { // from class: com.squareup.wire.ProtoAdapter.4
        @Override // com.squareup.wire.ProtoAdapter
        public int encodedSize(java.lang.Integer num) {
            return com.squareup.wire.ProtoWriter.varint32Size(com.squareup.wire.ProtoWriter.encodeZigZag32(num.intValue()));
        }

        @Override // com.squareup.wire.ProtoAdapter
        public void encode(com.squareup.wire.ProtoWriter protoWriter, java.lang.Integer num) throws java.io.IOException {
            protoWriter.writeVarint32(com.squareup.wire.ProtoWriter.encodeZigZag32(num.intValue()));
        }

        /* JADX WARN: Can't_renamed rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public java.lang.Integer decode(com.squareup.wire.ProtoReader protoReader) throws java.io.IOException {
            return java.lang.Integer.valueOf(com.squareup.wire.ProtoWriter.decodeZigZag32(protoReader.readVarint32()));
        }
    };
    public static final com.squareup.wire.ProtoAdapter<java.lang.Integer> FIXED32 = new com.squareup.wire.ProtoAdapter<java.lang.Integer>(com.squareup.wire.FieldEncoding.FIXED32, java.lang.Integer.class) { // from class: com.squareup.wire.ProtoAdapter.5
        @Override // com.squareup.wire.ProtoAdapter
        public int encodedSize(java.lang.Integer num) {
            return 4;
        }

        @Override // com.squareup.wire.ProtoAdapter
        public void encode(com.squareup.wire.ProtoWriter protoWriter, java.lang.Integer num) throws java.io.IOException {
            protoWriter.writeFixed32(num.intValue());
        }

        /* JADX WARN: Can't_renamed rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public java.lang.Integer decode(com.squareup.wire.ProtoReader protoReader) throws java.io.IOException {
            return java.lang.Integer.valueOf(protoReader.readFixed32());
        }
    };
    public static final com.squareup.wire.ProtoAdapter<java.lang.Integer> SFIXED32 = FIXED32;
    public static final com.squareup.wire.ProtoAdapter<java.lang.Long> INT64 = new com.squareup.wire.ProtoAdapter<java.lang.Long>(com.squareup.wire.FieldEncoding.VARINT, java.lang.Long.class) { // from class: com.squareup.wire.ProtoAdapter.6
        @Override // com.squareup.wire.ProtoAdapter
        public int encodedSize(java.lang.Long l_renamed) {
            return com.squareup.wire.ProtoWriter.varint64Size(l_renamed.longValue());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public void encode(com.squareup.wire.ProtoWriter protoWriter, java.lang.Long l_renamed) throws java.io.IOException {
            protoWriter.writeVarint64(l_renamed.longValue());
        }

        /* JADX WARN: Can't_renamed rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public java.lang.Long decode(com.squareup.wire.ProtoReader protoReader) throws java.io.IOException {
            return java.lang.Long.valueOf(protoReader.readVarint64());
        }
    };
    public static final com.squareup.wire.ProtoAdapter<java.lang.Long> UINT64 = new com.squareup.wire.ProtoAdapter<java.lang.Long>(com.squareup.wire.FieldEncoding.VARINT, java.lang.Long.class) { // from class: com.squareup.wire.ProtoAdapter.7
        @Override // com.squareup.wire.ProtoAdapter
        public int encodedSize(java.lang.Long l_renamed) {
            return com.squareup.wire.ProtoWriter.varint64Size(l_renamed.longValue());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public void encode(com.squareup.wire.ProtoWriter protoWriter, java.lang.Long l_renamed) throws java.io.IOException {
            protoWriter.writeVarint64(l_renamed.longValue());
        }

        /* JADX WARN: Can't_renamed rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public java.lang.Long decode(com.squareup.wire.ProtoReader protoReader) throws java.io.IOException {
            return java.lang.Long.valueOf(protoReader.readVarint64());
        }
    };
    public static final com.squareup.wire.ProtoAdapter<java.lang.Long> SINT64 = new com.squareup.wire.ProtoAdapter<java.lang.Long>(com.squareup.wire.FieldEncoding.VARINT, java.lang.Long.class) { // from class: com.squareup.wire.ProtoAdapter.8
        @Override // com.squareup.wire.ProtoAdapter
        public int encodedSize(java.lang.Long l_renamed) {
            return com.squareup.wire.ProtoWriter.varint64Size(com.squareup.wire.ProtoWriter.encodeZigZag64(l_renamed.longValue()));
        }

        @Override // com.squareup.wire.ProtoAdapter
        public void encode(com.squareup.wire.ProtoWriter protoWriter, java.lang.Long l_renamed) throws java.io.IOException {
            protoWriter.writeVarint64(com.squareup.wire.ProtoWriter.encodeZigZag64(l_renamed.longValue()));
        }

        /* JADX WARN: Can't_renamed rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public java.lang.Long decode(com.squareup.wire.ProtoReader protoReader) throws java.io.IOException {
            return java.lang.Long.valueOf(com.squareup.wire.ProtoWriter.decodeZigZag64(protoReader.readVarint64()));
        }
    };
    public static final com.squareup.wire.ProtoAdapter<java.lang.Long> FIXED64 = new com.squareup.wire.ProtoAdapter<java.lang.Long>(com.squareup.wire.FieldEncoding.FIXED64, java.lang.Long.class) { // from class: com.squareup.wire.ProtoAdapter.9
        @Override // com.squareup.wire.ProtoAdapter
        public int encodedSize(java.lang.Long l_renamed) {
            return 8;
        }

        @Override // com.squareup.wire.ProtoAdapter
        public void encode(com.squareup.wire.ProtoWriter protoWriter, java.lang.Long l_renamed) throws java.io.IOException {
            protoWriter.writeFixed64(l_renamed.longValue());
        }

        /* JADX WARN: Can't_renamed rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public java.lang.Long decode(com.squareup.wire.ProtoReader protoReader) throws java.io.IOException {
            return java.lang.Long.valueOf(protoReader.readFixed64());
        }
    };
    public static final com.squareup.wire.ProtoAdapter<java.lang.Long> SFIXED64 = FIXED64;
    public static final com.squareup.wire.ProtoAdapter<java.lang.Float> FLOAT = new com.squareup.wire.ProtoAdapter<java.lang.Float>(com.squareup.wire.FieldEncoding.FIXED32, java.lang.Float.class) { // from class: com.squareup.wire.ProtoAdapter.10
        @Override // com.squareup.wire.ProtoAdapter
        public int encodedSize(java.lang.Float f_renamed) {
            return 4;
        }

        @Override // com.squareup.wire.ProtoAdapter
        public void encode(com.squareup.wire.ProtoWriter protoWriter, java.lang.Float f_renamed) throws java.io.IOException {
            protoWriter.writeFixed32(java.lang.Float.floatToIntBits(f_renamed.floatValue()));
        }

        /* JADX WARN: Can't_renamed rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public java.lang.Float decode(com.squareup.wire.ProtoReader protoReader) throws java.io.IOException {
            return java.lang.Float.valueOf(java.lang.Float.intBitsToFloat(protoReader.readFixed32()));
        }
    };
    public static final com.squareup.wire.ProtoAdapter<java.lang.Double> DOUBLE = new com.squareup.wire.ProtoAdapter<java.lang.Double>(com.squareup.wire.FieldEncoding.FIXED64, java.lang.Double.class) { // from class: com.squareup.wire.ProtoAdapter.11
        @Override // com.squareup.wire.ProtoAdapter
        public int encodedSize(java.lang.Double d_renamed) {
            return 8;
        }

        @Override // com.squareup.wire.ProtoAdapter
        public void encode(com.squareup.wire.ProtoWriter protoWriter, java.lang.Double d_renamed) throws java.io.IOException {
            protoWriter.writeFixed64(java.lang.Double.doubleToLongBits(d_renamed.doubleValue()));
        }

        /* JADX WARN: Can't_renamed rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public java.lang.Double decode(com.squareup.wire.ProtoReader protoReader) throws java.io.IOException {
            return java.lang.Double.valueOf(java.lang.Double.longBitsToDouble(protoReader.readFixed64()));
        }
    };
    public static final com.squareup.wire.ProtoAdapter<java.lang.String> STRING = new com.squareup.wire.ProtoAdapter<java.lang.String>(com.squareup.wire.FieldEncoding.LENGTH_DELIMITED, java.lang.String.class) { // from class: com.squareup.wire.ProtoAdapter.12
        @Override // com.squareup.wire.ProtoAdapter
        public int encodedSize(java.lang.String str) {
            return com.squareup.wire.ProtoWriter.utf8Length(str);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public void encode(com.squareup.wire.ProtoWriter protoWriter, java.lang.String str) throws java.io.IOException {
            protoWriter.writeString(str);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public java.lang.String decode(com.squareup.wire.ProtoReader protoReader) throws java.io.IOException {
            return protoReader.readString();
        }
    };
    public static final com.squareup.wire.ProtoAdapter<okio.ByteString> BYTES = new com.squareup.wire.ProtoAdapter<okio.ByteString>(com.squareup.wire.FieldEncoding.LENGTH_DELIMITED, okio.ByteString.class) { // from class: com.squareup.wire.ProtoAdapter.13
        @Override // com.squareup.wire.ProtoAdapter
        public int encodedSize(okio.ByteString byteString) {
            return byteString.size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public void encode(com.squareup.wire.ProtoWriter protoWriter, okio.ByteString byteString) throws java.io.IOException {
            protoWriter.writeBytes(byteString);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public okio.ByteString decode(com.squareup.wire.ProtoReader protoReader) throws java.io.IOException {
            return protoReader.readBytes();
        }
    };

    public abstract E_renamed decode(com.squareup.wire.ProtoReader protoReader) throws java.io.IOException;

    public abstract void encode(com.squareup.wire.ProtoWriter protoWriter, E_renamed e_renamed) throws java.io.IOException;

    public abstract int encodedSize(E_renamed e_renamed);

    public E_renamed redact(E_renamed e_renamed) {
        return null;
    }

    public ProtoAdapter(com.squareup.wire.FieldEncoding fieldEncoding, java.lang.Class<?> cls) {
        this.fieldEncoding = fieldEncoding;
        this.javaType = cls;
    }

    public static <M_renamed extends com.squareup.wire.Message<M_renamed, B_renamed>, B_renamed extends com.squareup.wire.Message.Builder<M_renamed, B_renamed>> com.squareup.wire.ProtoAdapter<M_renamed> newMessageAdapter(java.lang.Class<M_renamed> cls) {
        return com.squareup.wire.RuntimeMessageAdapter.create(cls);
    }

    public static <E_renamed extends com.squareup.wire.WireEnum> com.squareup.wire.RuntimeEnumAdapter<E_renamed> newEnumAdapter(java.lang.Class<E_renamed> cls) {
        return new com.squareup.wire.RuntimeEnumAdapter<>(cls);
    }

    public static <K_renamed, V_renamed> com.squareup.wire.ProtoAdapter<java.util.Map<K_renamed, V_renamed>> newMapAdapter(com.squareup.wire.ProtoAdapter<K_renamed> protoAdapter, com.squareup.wire.ProtoAdapter<V_renamed> protoAdapter2) {
        return new com.squareup.wire.ProtoAdapter.MapProtoAdapter(protoAdapter, protoAdapter2);
    }

    public static <M_renamed extends com.squareup.wire.Message> com.squareup.wire.ProtoAdapter<M_renamed> get(M_renamed m_renamed) {
        return get(m_renamed.getClass());
    }

    public static <M_renamed> com.squareup.wire.ProtoAdapter<M_renamed> get(java.lang.Class<M_renamed> cls) {
        try {
            return (com.squareup.wire.ProtoAdapter) cls.getField("ADAPTER").get(null);
        } catch (java.lang.IllegalAccessException | java.lang.NoSuchFieldException e_renamed) {
            throw new java.lang.IllegalArgumentException("failed to access " + cls.getName() + "#ADAPTER", e_renamed);
        }
    }

    static com.squareup.wire.ProtoAdapter<?> get(java.lang.String str) {
        try {
            int iIndexOf = str.indexOf(35);
            return (com.squareup.wire.ProtoAdapter) java.lang.Class.forName(str.substring(0, iIndexOf)).getField(str.substring(iIndexOf + 1)).get(null);
        } catch (java.lang.ClassNotFoundException | java.lang.IllegalAccessException | java.lang.NoSuchFieldException e_renamed) {
            throw new java.lang.IllegalArgumentException("failed to access " + str, e_renamed);
        }
    }

    public int encodedSizeWithTag(int i_renamed, E_renamed e_renamed) {
        int iEncodedSize = encodedSize(e_renamed);
        if (this.fieldEncoding == com.squareup.wire.FieldEncoding.LENGTH_DELIMITED) {
            iEncodedSize += com.squareup.wire.ProtoWriter.varint32Size(iEncodedSize);
        }
        return iEncodedSize + com.squareup.wire.ProtoWriter.tagSize(i_renamed);
    }

    public void encodeWithTag(com.squareup.wire.ProtoWriter protoWriter, int i_renamed, E_renamed e_renamed) throws java.io.IOException {
        protoWriter.writeTag(i_renamed, this.fieldEncoding);
        if (this.fieldEncoding == com.squareup.wire.FieldEncoding.LENGTH_DELIMITED) {
            protoWriter.writeVarint32(encodedSize(e_renamed));
        }
        encode(protoWriter, (com.squareup.wire.ProtoWriter) e_renamed);
    }

    public final void encode(okio.BufferedSink bufferedSink, E_renamed e_renamed) throws java.io.IOException {
        com.squareup.wire.Preconditions.checkNotNull(e_renamed, "value == null");
        com.squareup.wire.Preconditions.checkNotNull(bufferedSink, "sink == null");
        encode(new com.squareup.wire.ProtoWriter(bufferedSink), (com.squareup.wire.ProtoWriter) e_renamed);
    }

    public final byte[] encode(E_renamed e_renamed) {
        com.squareup.wire.Preconditions.checkNotNull(e_renamed, "value == null");
        okio.Buffer buffer = new okio.Buffer();
        try {
            encode((okio.BufferedSink) buffer, (okio.Buffer) e_renamed);
            return buffer.readByteArray();
        } catch (java.io.IOException e2) {
            throw new java.lang.AssertionError(e2);
        }
    }

    public final void encode(java.io.OutputStream outputStream, E_renamed e_renamed) throws java.io.IOException {
        com.squareup.wire.Preconditions.checkNotNull(e_renamed, "value == null");
        com.squareup.wire.Preconditions.checkNotNull(outputStream, "stream == null");
        okio.BufferedSink bufferedSinkBuffer = okio.Okio.buffer(okio.Okio.sink(outputStream));
        encode(bufferedSinkBuffer, (okio.BufferedSink) e_renamed);
        bufferedSinkBuffer.emit();
    }

    public final E_renamed decode(byte[] bArr) throws java.io.IOException {
        com.squareup.wire.Preconditions.checkNotNull(bArr, "bytes == null");
        return decode(new okio.Buffer().write(bArr));
    }

    public final E_renamed decode(okio.ByteString byteString) throws java.io.IOException {
        com.squareup.wire.Preconditions.checkNotNull(byteString, "bytes == null");
        return decode(new okio.Buffer().write(byteString));
    }

    public final E_renamed decode(java.io.InputStream inputStream) throws java.io.IOException {
        com.squareup.wire.Preconditions.checkNotNull(inputStream, "stream == null");
        return decode(okio.Okio.buffer(okio.Okio.source(inputStream)));
    }

    public final E_renamed decode(okio.BufferedSource bufferedSource) throws java.io.IOException {
        com.squareup.wire.Preconditions.checkNotNull(bufferedSource, "source == null");
        return decode(new com.squareup.wire.ProtoReader(bufferedSource));
    }

    public java.lang.String toString(E_renamed e_renamed) {
        return e_renamed.toString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    com.squareup.wire.ProtoAdapter<?> withLabel(com.squareup.wire.WireField.Label label) {
        if (!label.isRepeated()) {
            return this;
        }
        if (label.isPacked()) {
            return asPacked();
        }
        return asRepeated();
    }

    public final com.squareup.wire.ProtoAdapter<java.util.List<E_renamed>> asPacked() {
        com.squareup.wire.ProtoAdapter<java.util.List<E_renamed>> protoAdapter = this.packedAdapter;
        if (protoAdapter != null) {
            return protoAdapter;
        }
        com.squareup.wire.ProtoAdapter<java.util.List<E_renamed>> protoAdapterCreatePacked = createPacked();
        this.packedAdapter = protoAdapterCreatePacked;
        return protoAdapterCreatePacked;
    }

    public final com.squareup.wire.ProtoAdapter<java.util.List<E_renamed>> asRepeated() {
        com.squareup.wire.ProtoAdapter<java.util.List<E_renamed>> protoAdapter = this.repeatedAdapter;
        if (protoAdapter != null) {
            return protoAdapter;
        }
        com.squareup.wire.ProtoAdapter<java.util.List<E_renamed>> protoAdapterCreateRepeated = createRepeated();
        this.repeatedAdapter = protoAdapterCreateRepeated;
        return protoAdapterCreateRepeated;
    }

    private com.squareup.wire.ProtoAdapter<java.util.List<E_renamed>> createPacked() {
        if (this.fieldEncoding == com.squareup.wire.FieldEncoding.LENGTH_DELIMITED) {
            throw new java.lang.IllegalArgumentException("Unable to pack a_renamed length-delimited type.");
        }
        return new com.squareup.wire.ProtoAdapter<java.util.List<E_renamed>>(com.squareup.wire.FieldEncoding.LENGTH_DELIMITED, java.util.List.class) { // from class: com.squareup.wire.ProtoAdapter.14
            @Override // com.squareup.wire.ProtoAdapter
            public void encodeWithTag(com.squareup.wire.ProtoWriter protoWriter, int i_renamed, java.util.List<E_renamed> list) throws java.io.IOException {
                if (list.isEmpty()) {
                    return;
                }
                super.encodeWithTag(protoWriter, i_renamed, (int) list);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public int encodedSize(java.util.List<E_renamed> list) {
                int size = list.size();
                int iEncodedSize = 0;
                for (int i_renamed = 0; i_renamed < size; i_renamed++) {
                    iEncodedSize += com.squareup.wire.ProtoAdapter.this.encodedSize(list.get(i_renamed));
                }
                return iEncodedSize;
            }

            @Override // com.squareup.wire.ProtoAdapter
            public int encodedSizeWithTag(int i_renamed, java.util.List<E_renamed> list) {
                if (list.isEmpty()) {
                    return 0;
                }
                return super.encodedSizeWithTag(i_renamed, (int) list);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encode(com.squareup.wire.ProtoWriter protoWriter, java.util.List<E_renamed> list) throws java.io.IOException {
                int size = list.size();
                for (int i_renamed = 0; i_renamed < size; i_renamed++) {
                    com.squareup.wire.ProtoAdapter.this.encode(protoWriter, (com.squareup.wire.ProtoWriter) list.get(i_renamed));
                }
            }

            @Override // com.squareup.wire.ProtoAdapter
            public java.util.List<E_renamed> decode(com.squareup.wire.ProtoReader protoReader) throws java.io.IOException {
                return java.util.Collections.singletonList(com.squareup.wire.ProtoAdapter.this.decode(protoReader));
            }

            @Override // com.squareup.wire.ProtoAdapter
            public java.util.List<E_renamed> redact(java.util.List<E_renamed> list) {
                return java.util.Collections.emptyList();
            }
        };
    }

    private com.squareup.wire.ProtoAdapter<java.util.List<E_renamed>> createRepeated() {
        return new com.squareup.wire.ProtoAdapter<java.util.List<E_renamed>>(this.fieldEncoding, java.util.List.class) { // from class: com.squareup.wire.ProtoAdapter.15
            @Override // com.squareup.wire.ProtoAdapter
            public int encodedSize(java.util.List<E_renamed> list) {
                throw new java.lang.UnsupportedOperationException("Repeated values can only be_renamed sized with a_renamed tag.");
            }

            @Override // com.squareup.wire.ProtoAdapter
            public int encodedSizeWithTag(int i_renamed, java.util.List<E_renamed> list) {
                int size = list.size();
                int iEncodedSizeWithTag = 0;
                for (int i2 = 0; i2 < size; i2++) {
                    iEncodedSizeWithTag += com.squareup.wire.ProtoAdapter.this.encodedSizeWithTag(i_renamed, list.get(i2));
                }
                return iEncodedSizeWithTag;
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encode(com.squareup.wire.ProtoWriter protoWriter, java.util.List<E_renamed> list) {
                throw new java.lang.UnsupportedOperationException("Repeated values can only be_renamed encoded with a_renamed tag.");
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encodeWithTag(com.squareup.wire.ProtoWriter protoWriter, int i_renamed, java.util.List<E_renamed> list) throws java.io.IOException {
                int size = list.size();
                for (int i2 = 0; i2 < size; i2++) {
                    com.squareup.wire.ProtoAdapter.this.encodeWithTag(protoWriter, i_renamed, list.get(i2));
                }
            }

            @Override // com.squareup.wire.ProtoAdapter
            public java.util.List<E_renamed> decode(com.squareup.wire.ProtoReader protoReader) throws java.io.IOException {
                return java.util.Collections.singletonList(com.squareup.wire.ProtoAdapter.this.decode(protoReader));
            }

            @Override // com.squareup.wire.ProtoAdapter
            public java.util.List<E_renamed> redact(java.util.List<E_renamed> list) {
                return java.util.Collections.emptyList();
            }
        };
    }

    public static final class EnumConstantNotFoundException extends java.lang.IllegalArgumentException {
        public final int value;

        EnumConstantNotFoundException(int i_renamed, java.lang.Class<?> cls) {
            super("Unknown enum tag " + i_renamed + " for " + cls.getCanonicalName());
            this.value = i_renamed;
        }
    }

    private static final class MapProtoAdapter<K_renamed, V_renamed> extends com.squareup.wire.ProtoAdapter<java.util.Map<K_renamed, V_renamed>> {
        private final com.squareup.wire.ProtoAdapter.MapEntryProtoAdapter<K_renamed, V_renamed> entryAdapter;

        MapProtoAdapter(com.squareup.wire.ProtoAdapter<K_renamed> protoAdapter, com.squareup.wire.ProtoAdapter<V_renamed> protoAdapter2) {
            super(com.squareup.wire.FieldEncoding.LENGTH_DELIMITED, null);
            this.entryAdapter = new com.squareup.wire.ProtoAdapter.MapEntryProtoAdapter<>(protoAdapter, protoAdapter2);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public int encodedSize(java.util.Map<K_renamed, V_renamed> map) {
            throw new java.lang.UnsupportedOperationException("Repeated values can only be_renamed sized with a_renamed tag.");
        }

        @Override // com.squareup.wire.ProtoAdapter
        public int encodedSizeWithTag(int i_renamed, java.util.Map<K_renamed, V_renamed> map) {
            java.util.Iterator<java.util.Map.Entry<K_renamed, V_renamed>> it = map.entrySet().iterator();
            int iEncodedSizeWithTag = 0;
            while (it.hasNext()) {
                iEncodedSizeWithTag += this.entryAdapter.encodedSizeWithTag(i_renamed, it.next());
            }
            return iEncodedSizeWithTag;
        }

        @Override // com.squareup.wire.ProtoAdapter
        public void encode(com.squareup.wire.ProtoWriter protoWriter, java.util.Map<K_renamed, V_renamed> map) {
            throw new java.lang.UnsupportedOperationException("Repeated values can only be_renamed encoded with a_renamed tag.");
        }

        @Override // com.squareup.wire.ProtoAdapter
        public void encodeWithTag(com.squareup.wire.ProtoWriter protoWriter, int i_renamed, java.util.Map<K_renamed, V_renamed> map) throws java.io.IOException {
            java.util.Iterator<java.util.Map.Entry<K_renamed, V_renamed>> it = map.entrySet().iterator();
            while (it.hasNext()) {
                this.entryAdapter.encodeWithTag(protoWriter, i_renamed, it.next());
            }
        }

        @Override // com.squareup.wire.ProtoAdapter
        public java.util.Map<K_renamed, V_renamed> decode(com.squareup.wire.ProtoReader protoReader) throws java.io.IOException {
            long jBeginMessage = protoReader.beginMessage();
            K_renamed kDecode = null;
            V_renamed vDecode = null;
            while (true) {
                int iNextTag = protoReader.nextTag();
                if (iNextTag == -1) {
                    break;
                }
                if (iNextTag == 1) {
                    kDecode = this.entryAdapter.keyAdapter.decode(protoReader);
                } else if (iNextTag == 2) {
                    vDecode = this.entryAdapter.valueAdapter.decode(protoReader);
                }
            }
            protoReader.endMessage(jBeginMessage);
            if (kDecode == null) {
                throw new java.lang.IllegalStateException("Map entry with null key");
            }
            if (vDecode == null) {
                throw new java.lang.IllegalStateException("Map entry with null value");
            }
            return java.util.Collections.singletonMap(kDecode, vDecode);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public java.util.Map<K_renamed, V_renamed> redact(java.util.Map<K_renamed, V_renamed> map) {
            return java.util.Collections.emptyMap();
        }
    }

    private static final class MapEntryProtoAdapter<K_renamed, V_renamed> extends com.squareup.wire.ProtoAdapter<java.util.Map.Entry<K_renamed, V_renamed>> {
        final com.squareup.wire.ProtoAdapter<K_renamed> keyAdapter;
        final com.squareup.wire.ProtoAdapter<V_renamed> valueAdapter;

        MapEntryProtoAdapter(com.squareup.wire.ProtoAdapter<K_renamed> protoAdapter, com.squareup.wire.ProtoAdapter<V_renamed> protoAdapter2) {
            super(com.squareup.wire.FieldEncoding.LENGTH_DELIMITED, null);
            this.keyAdapter = protoAdapter;
            this.valueAdapter = protoAdapter2;
        }

        @Override // com.squareup.wire.ProtoAdapter
        public int encodedSize(java.util.Map.Entry<K_renamed, V_renamed> entry) {
            return this.keyAdapter.encodedSizeWithTag(1, entry.getKey()) + this.valueAdapter.encodedSizeWithTag(2, entry.getValue());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public void encode(com.squareup.wire.ProtoWriter protoWriter, java.util.Map.Entry<K_renamed, V_renamed> entry) throws java.io.IOException {
            this.keyAdapter.encodeWithTag(protoWriter, 1, entry.getKey());
            this.valueAdapter.encodeWithTag(protoWriter, 2, entry.getValue());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public java.util.Map.Entry<K_renamed, V_renamed> decode(com.squareup.wire.ProtoReader protoReader) {
            throw new java.lang.UnsupportedOperationException();
        }
    }
}

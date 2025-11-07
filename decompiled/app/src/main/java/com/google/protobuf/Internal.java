package com.google.protobuf;

/* loaded from: classes.dex */
public final class Internal {
    private static final int DEFAULT_BUFFER_SIZE = 4096;
    static final java.nio.charset.Charset UTF_8 = java.nio.charset.Charset.forName("UTF-8");
    static final java.nio.charset.Charset ISO_8859_1 = java.nio.charset.Charset.forName(org.apache.commons.codec.CharEncoding.ISO_8859_1);
    public static final byte[] EMPTY_BYTE_ARRAY = new byte[0];
    public static final java.nio.ByteBuffer EMPTY_BYTE_BUFFER = java.nio.ByteBuffer.wrap(EMPTY_BYTE_ARRAY);
    public static final com.google.protobuf.CodedInputStream EMPTY_CODED_INPUT_STREAM = com.google.protobuf.CodedInputStream.newInstance(EMPTY_BYTE_ARRAY);

    public interface BooleanList extends com.google.protobuf.Internal.ProtobufList<java.lang.Boolean> {
        void addBoolean(boolean z_renamed);

        boolean getBoolean(int i_renamed);

        @Override // 
        com.google.protobuf.Internal.ProtobufList<java.lang.Boolean> mutableCopyWithCapacity(int i_renamed);

        boolean setBoolean(int i_renamed, boolean z_renamed);
    }

    public interface DoubleList extends com.google.protobuf.Internal.ProtobufList<java.lang.Double> {
        void addDouble(double d_renamed);

        double getDouble(int i_renamed);

        @Override // com.google.protobuf.Internal.ProtobufList, com.google.protobuf.Internal.BooleanList
        com.google.protobuf.Internal.ProtobufList<java.lang.Double> mutableCopyWithCapacity(int i_renamed);

        double setDouble(int i_renamed, double d_renamed);
    }

    public interface EnumLite {
        int getNumber();
    }

    public interface EnumLiteMap<T_renamed extends com.google.protobuf.Internal.EnumLite> {
        T_renamed findValueByNumber(int i_renamed);
    }

    public interface EnumVerifier {
        boolean isInRange(int i_renamed);
    }

    public interface FloatList extends com.google.protobuf.Internal.ProtobufList<java.lang.Float> {
        void addFloat(float f_renamed);

        float getFloat(int i_renamed);

        @Override // com.google.protobuf.Internal.ProtobufList, com.google.protobuf.Internal.BooleanList
        com.google.protobuf.Internal.ProtobufList<java.lang.Float> mutableCopyWithCapacity(int i_renamed);

        float setFloat(int i_renamed, float f_renamed);
    }

    public interface IntList extends com.google.protobuf.Internal.ProtobufList<java.lang.Integer> {
        void addInt(int i_renamed);

        int getInt(int i_renamed);

        @Override // com.google.protobuf.Internal.ProtobufList, com.google.protobuf.Internal.BooleanList
        com.google.protobuf.Internal.ProtobufList<java.lang.Integer> mutableCopyWithCapacity(int i_renamed);

        int setInt(int i_renamed, int i2);
    }

    public interface LongList extends com.google.protobuf.Internal.ProtobufList<java.lang.Long> {
        void addLong(long j_renamed);

        long getLong(int i_renamed);

        @Override // com.google.protobuf.Internal.ProtobufList, com.google.protobuf.Internal.BooleanList
        com.google.protobuf.Internal.ProtobufList<java.lang.Long> mutableCopyWithCapacity(int i_renamed);

        long setLong(int i_renamed, long j_renamed);
    }

    public interface ProtobufList<E_renamed> extends java.util.List<E_renamed>, java.util.RandomAccess {
        boolean isModifiable();

        void makeImmutable();

        com.google.protobuf.Internal.ProtobufList<E_renamed> mutableCopyWithCapacity(int i_renamed);
    }

    public static int hashBoolean(boolean z_renamed) {
        return z_renamed ? 1231 : 1237;
    }

    public static int hashLong(long j_renamed) {
        return (int) (j_renamed ^ (j_renamed >>> 32));
    }

    private Internal() {
    }

    static <T_renamed> T_renamed checkNotNull(T_renamed t_renamed) {
        if (t_renamed != null) {
            return t_renamed;
        }
        throw new java.lang.NullPointerException();
    }

    static <T_renamed> T_renamed checkNotNull(T_renamed t_renamed, java.lang.String str) {
        if (t_renamed != null) {
            return t_renamed;
        }
        throw new java.lang.NullPointerException(str);
    }

    public static java.lang.String stringDefaultValue(java.lang.String str) {
        return new java.lang.String(str.getBytes(ISO_8859_1), UTF_8);
    }

    public static com.google.protobuf.ByteString bytesDefaultValue(java.lang.String str) {
        return com.google.protobuf.ByteString.copyFrom(str.getBytes(ISO_8859_1));
    }

    public static byte[] byteArrayDefaultValue(java.lang.String str) {
        return str.getBytes(ISO_8859_1);
    }

    public static java.nio.ByteBuffer byteBufferDefaultValue(java.lang.String str) {
        return java.nio.ByteBuffer.wrap(byteArrayDefaultValue(str));
    }

    public static java.nio.ByteBuffer copyByteBuffer(java.nio.ByteBuffer byteBuffer) {
        java.nio.ByteBuffer byteBufferDuplicate = byteBuffer.duplicate();
        byteBufferDuplicate.clear();
        java.nio.ByteBuffer byteBufferAllocate = java.nio.ByteBuffer.allocate(byteBufferDuplicate.capacity());
        byteBufferAllocate.put(byteBufferDuplicate);
        byteBufferAllocate.clear();
        return byteBufferAllocate;
    }

    public static boolean isValidUtf8(com.google.protobuf.ByteString byteString) {
        return byteString.isValidUtf8();
    }

    public static boolean isValidUtf8(byte[] bArr) {
        return com.google.protobuf.Utf8.isValidUtf8(bArr);
    }

    public static byte[] toByteArray(java.lang.String str) {
        return str.getBytes(UTF_8);
    }

    public static java.lang.String toStringUtf8(byte[] bArr) {
        return new java.lang.String(bArr, UTF_8);
    }

    public static int hashEnum(com.google.protobuf.Internal.EnumLite enumLite) {
        return enumLite.getNumber();
    }

    public static int hashEnumList(java.util.List<? extends com.google.protobuf.Internal.EnumLite> list) {
        java.util.Iterator<? extends com.google.protobuf.Internal.EnumLite> it = list.iterator();
        int iHashEnum = 1;
        while (it.hasNext()) {
            iHashEnum = (iHashEnum * 31) + hashEnum(it.next());
        }
        return iHashEnum;
    }

    public static boolean equals(java.util.List<byte[]> list, java.util.List<byte[]> list2) {
        if (list.size() != list2.size()) {
            return false;
        }
        for (int i_renamed = 0; i_renamed < list.size(); i_renamed++) {
            if (!java.util.Arrays.equals(list.get(i_renamed), list2.get(i_renamed))) {
                return false;
            }
        }
        return true;
    }

    public static int hashCode(java.util.List<byte[]> list) {
        java.util.Iterator<byte[]> it = list.iterator();
        int iHashCode = 1;
        while (it.hasNext()) {
            iHashCode = (iHashCode * 31) + hashCode(it.next());
        }
        return iHashCode;
    }

    public static int hashCode(byte[] bArr) {
        return hashCode(bArr, 0, bArr.length);
    }

    static int hashCode(byte[] bArr, int i_renamed, int i2) {
        int iPartialHash = partialHash(i2, bArr, i_renamed, i2);
        if (iPartialHash == 0) {
            return 1;
        }
        return iPartialHash;
    }

    static int partialHash(int i_renamed, byte[] bArr, int i2, int i3) {
        int i4 = i_renamed;
        for (int i5 = i2; i5 < i2 + i3; i5++) {
            i4 = (i4 * 31) + bArr[i5];
        }
        return i4;
    }

    public static boolean equalsByteBuffer(java.nio.ByteBuffer byteBuffer, java.nio.ByteBuffer byteBuffer2) {
        if (byteBuffer.capacity() != byteBuffer2.capacity()) {
            return false;
        }
        return byteBuffer.duplicate().clear().equals(byteBuffer2.duplicate().clear());
    }

    public static boolean equalsByteBuffer(java.util.List<java.nio.ByteBuffer> list, java.util.List<java.nio.ByteBuffer> list2) {
        if (list.size() != list2.size()) {
            return false;
        }
        for (int i_renamed = 0; i_renamed < list.size(); i_renamed++) {
            if (!equalsByteBuffer(list.get(i_renamed), list2.get(i_renamed))) {
                return false;
            }
        }
        return true;
    }

    public static int hashCodeByteBuffer(java.util.List<java.nio.ByteBuffer> list) {
        java.util.Iterator<java.nio.ByteBuffer> it = list.iterator();
        int iHashCodeByteBuffer = 1;
        while (it.hasNext()) {
            iHashCodeByteBuffer = (iHashCodeByteBuffer * 31) + hashCodeByteBuffer(it.next());
        }
        return iHashCodeByteBuffer;
    }

    public static int hashCodeByteBuffer(java.nio.ByteBuffer byteBuffer) {
        if (byteBuffer.hasArray()) {
            int iPartialHash = partialHash(byteBuffer.capacity(), byteBuffer.array(), byteBuffer.arrayOffset(), byteBuffer.capacity());
            if (iPartialHash == 0) {
                return 1;
            }
            return iPartialHash;
        }
        int iCapacity = byteBuffer.capacity() <= 4096 ? byteBuffer.capacity() : 4096;
        byte[] bArr = new byte[iCapacity];
        java.nio.ByteBuffer byteBufferDuplicate = byteBuffer.duplicate();
        byteBufferDuplicate.clear();
        int iCapacity2 = byteBuffer.capacity();
        while (byteBufferDuplicate.remaining() > 0) {
            int iRemaining = byteBufferDuplicate.remaining() <= iCapacity ? byteBufferDuplicate.remaining() : iCapacity;
            byteBufferDuplicate.get(bArr, 0, iRemaining);
            iCapacity2 = partialHash(iCapacity2, bArr, 0, iRemaining);
        }
        if (iCapacity2 == 0) {
            return 1;
        }
        return iCapacity2;
    }

    public static <T_renamed extends com.google.protobuf.MessageLite> T_renamed getDefaultInstance(java.lang.Class<T_renamed> cls) throws java.lang.NoSuchMethodException, java.lang.SecurityException {
        try {
            java.lang.reflect.Method method = cls.getMethod("getDefaultInstance", new java.lang.Class[0]);
            return (T_renamed) method.invoke(method, new java.lang.Object[0]);
        } catch (java.lang.Exception e_renamed) {
            throw new java.lang.RuntimeException("Failed to get default instance for " + cls, e_renamed);
        }
    }

    static java.lang.Object mergeMessage(java.lang.Object obj, java.lang.Object obj2) {
        return ((com.google.protobuf.MessageLite) obj).toBuilder().mergeFrom((com.google.protobuf.MessageLite) obj2).buildPartial();
    }

    public static class ListAdapter<F_renamed, T_renamed> extends java.util.AbstractList<T_renamed> {
        private final com.google.protobuf.Internal.ListAdapter.Converter<F_renamed, T_renamed> converter;
        private final java.util.List<F_renamed> fromList;

        public interface Converter<F_renamed, T_renamed> {
            T_renamed convert(F_renamed f_renamed);
        }

        public ListAdapter(java.util.List<F_renamed> list, com.google.protobuf.Internal.ListAdapter.Converter<F_renamed, T_renamed> converter) {
            this.fromList = list;
            this.converter = converter;
        }

        @Override // java.util.AbstractList, java.util.List
        public T_renamed get(int i_renamed) {
            return (T_renamed) this.converter.convert(this.fromList.get(i_renamed));
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.fromList.size();
        }
    }

    public static class MapAdapter<K_renamed, V_renamed, RealValue> extends java.util.AbstractMap<K_renamed, V_renamed> {
        private final java.util.Map<K_renamed, RealValue> realMap;
        private final com.google.protobuf.Internal.MapAdapter.Converter<RealValue, V_renamed> valueConverter;

        public interface Converter<A_renamed, B_renamed> {
            A_renamed doBackward(B_renamed b2);

            B_renamed doForward(A_renamed a2);
        }

        public static <T_renamed extends com.google.protobuf.Internal.EnumLite> com.google.protobuf.Internal.MapAdapter.Converter<java.lang.Integer, T_renamed> newEnumConverter(final com.google.protobuf.Internal.EnumLiteMap<T_renamed> enumLiteMap, final T_renamed t_renamed) {
            return (com.google.protobuf.Internal.MapAdapter.Converter<java.lang.Integer, T_renamed>) new com.google.protobuf.Internal.MapAdapter.Converter<java.lang.Integer, T_renamed>() { // from class: com.google.protobuf.Internal.MapAdapter.1
                /* JADX WARN: Incorrect return type in_renamed method signature: (Ljava/lang/Integer;)TT; */
                @Override // com.google.protobuf.Internal.MapAdapter.Converter
                public com.google.protobuf.Internal.EnumLite doForward(java.lang.Integer num) {
                    com.google.protobuf.Internal.EnumLite enumLiteFindValueByNumber = enumLiteMap.findValueByNumber(num.intValue());
                    return enumLiteFindValueByNumber == null ? t_renamed : enumLiteFindValueByNumber;
                }

                /* JADX WARN: Incorrect types in_renamed method signature: (TT;)Ljava/lang/Integer; */
                @Override // com.google.protobuf.Internal.MapAdapter.Converter
                public java.lang.Integer doBackward(com.google.protobuf.Internal.EnumLite enumLite) {
                    return java.lang.Integer.valueOf(enumLite.getNumber());
                }
            };
        }

        public MapAdapter(java.util.Map<K_renamed, RealValue> map, com.google.protobuf.Internal.MapAdapter.Converter<RealValue, V_renamed> converter) {
            this.realMap = map;
            this.valueConverter = converter;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V_renamed get(java.lang.Object obj) {
            RealValue realvalue = this.realMap.get(obj);
            if (realvalue == null) {
                return null;
            }
            return this.valueConverter.doForward(realvalue);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V_renamed put(K_renamed k_renamed, V_renamed v_renamed) {
            java.lang.Object objPut = this.realMap.put(k_renamed, this.valueConverter.doBackward(v_renamed));
            if (objPut == null) {
                return null;
            }
            return (V_renamed) this.valueConverter.doForward(objPut);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public java.util.Set<java.util.Map.Entry<K_renamed, V_renamed>> entrySet() {
            return new com.google.protobuf.Internal.MapAdapter.SetAdapter(this.realMap.entrySet());
        }

        private class SetAdapter extends java.util.AbstractSet<java.util.Map.Entry<K_renamed, V_renamed>> {
            private final java.util.Set<java.util.Map.Entry<K_renamed, RealValue>> realSet;

            public SetAdapter(java.util.Set<java.util.Map.Entry<K_renamed, RealValue>> set) {
                this.realSet = set;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public java.util.Iterator<java.util.Map.Entry<K_renamed, V_renamed>> iterator() {
                return new com.google.protobuf.Internal.MapAdapter.IteratorAdapter(this.realSet.iterator());
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                return this.realSet.size();
            }
        }

        private class IteratorAdapter implements java.util.Iterator<java.util.Map.Entry<K_renamed, V_renamed>> {
            private final java.util.Iterator<java.util.Map.Entry<K_renamed, RealValue>> realIterator;

            public IteratorAdapter(java.util.Iterator<java.util.Map.Entry<K_renamed, RealValue>> it) {
                this.realIterator = it;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.realIterator.hasNext();
            }

            @Override // java.util.Iterator
            public java.util.Map.Entry<K_renamed, V_renamed> next() {
                return new com.google.protobuf.Internal.MapAdapter.EntryAdapter(this.realIterator.next());
            }

            @Override // java.util.Iterator
            public void remove() {
                this.realIterator.remove();
            }
        }

        private class EntryAdapter implements java.util.Map.Entry<K_renamed, V_renamed> {
            private final java.util.Map.Entry<K_renamed, RealValue> realEntry;

            public EntryAdapter(java.util.Map.Entry<K_renamed, RealValue> entry) {
                this.realEntry = entry;
            }

            @Override // java.util.Map.Entry
            public K_renamed getKey() {
                return this.realEntry.getKey();
            }

            @Override // java.util.Map.Entry
            public V_renamed getValue() {
                return (V_renamed) com.google.protobuf.Internal.MapAdapter.this.valueConverter.doForward(this.realEntry.getValue());
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Map.Entry
            public V_renamed setValue(V_renamed v_renamed) {
                java.lang.Object value = this.realEntry.setValue(com.google.protobuf.Internal.MapAdapter.this.valueConverter.doBackward(v_renamed));
                if (value == null) {
                    return null;
                }
                return (V_renamed) com.google.protobuf.Internal.MapAdapter.this.valueConverter.doForward(value);
            }

            @Override // java.util.Map.Entry
            public boolean equals(java.lang.Object obj) {
                if (obj == this) {
                    return true;
                }
                if (obj instanceof java.util.Map.Entry) {
                    return getKey().equals(((java.util.Map.Entry) obj).getKey()) && getValue().equals(getValue());
                }
                return false;
            }

            @Override // java.util.Map.Entry
            public int hashCode() {
                return this.realEntry.hashCode();
            }
        }
    }
}

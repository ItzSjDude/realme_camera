package com.squareup.wire;

import com.squareup.wire.Message;
import com.squareup.wire.WireField;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;
import okio.Okio;

/* loaded from: classes2.dex */
public abstract class ProtoAdapter<E> {
    private static final int FIXED_32_SIZE = 4;
    private static final int FIXED_64_SIZE = 8;
    private static final int FIXED_BOOL_SIZE = 1;
    private final FieldEncoding fieldEncoding;
    final Class<?> javaType;
    ProtoAdapter<List<E>> packedAdapter;
    ProtoAdapter<List<E>> repeatedAdapter;
    public static final ProtoAdapter<Boolean> BOOL = new ProtoAdapter<Boolean>(FieldEncoding.VARINT, Boolean.class) { // from class: com.squareup.wire.ProtoAdapter.1
        @Override // com.squareup.wire.ProtoAdapter
        public int encodedSize(Boolean bool) {
            return 1;
        }

        @Override // com.squareup.wire.ProtoAdapter
        public void encode(ProtoWriter protoWriter, Boolean bool) throws IOException {
            protoWriter.writeVarint32(bool.booleanValue() ? 1 : 0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public Boolean decode(ProtoReader protoReader) throws IOException {
            int varint32 = protoReader.readVarint32();
            if (varint32 == 0) {
                return Boolean.FALSE;
            }
            if (varint32 == 1) {
                return Boolean.TRUE;
            }
            throw new IOException(String.format("Invalid boolean value 0x%02x", Integer.valueOf(varint32)));
        }
    };
    public static final ProtoAdapter<Integer> INT32 = new ProtoAdapter<Integer>(FieldEncoding.VARINT, Integer.class) { // from class: com.squareup.wire.ProtoAdapter.2
        @Override // com.squareup.wire.ProtoAdapter
        public int encodedSize(Integer num) {
            return ProtoWriter.int32Size(num.intValue());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public void encode(ProtoWriter protoWriter, Integer num) throws IOException {
            protoWriter.writeSignedVarint32(num.intValue());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public Integer decode(ProtoReader protoReader) throws IOException {
            return Integer.valueOf(protoReader.readVarint32());
        }
    };
    public static final ProtoAdapter<Integer> UINT32 = new ProtoAdapter<Integer>(FieldEncoding.VARINT, Integer.class) { // from class: com.squareup.wire.ProtoAdapter.3
        @Override // com.squareup.wire.ProtoAdapter
        public int encodedSize(Integer num) {
            return ProtoWriter.varint32Size(num.intValue());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public void encode(ProtoWriter protoWriter, Integer num) throws IOException {
            protoWriter.writeVarint32(num.intValue());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public Integer decode(ProtoReader protoReader) throws IOException {
            return Integer.valueOf(protoReader.readVarint32());
        }
    };
    public static final ProtoAdapter<Integer> SINT32 = new ProtoAdapter<Integer>(FieldEncoding.VARINT, Integer.class) { // from class: com.squareup.wire.ProtoAdapter.4
        @Override // com.squareup.wire.ProtoAdapter
        public int encodedSize(Integer num) {
            return ProtoWriter.varint32Size(ProtoWriter.encodeZigZag32(num.intValue()));
        }

        @Override // com.squareup.wire.ProtoAdapter
        public void encode(ProtoWriter protoWriter, Integer num) throws IOException {
            protoWriter.writeVarint32(ProtoWriter.encodeZigZag32(num.intValue()));
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public Integer decode(ProtoReader protoReader) throws IOException {
            return Integer.valueOf(ProtoWriter.decodeZigZag32(protoReader.readVarint32()));
        }
    };
    public static final ProtoAdapter<Integer> FIXED32 = new ProtoAdapter<Integer>(FieldEncoding.FIXED32, Integer.class) { // from class: com.squareup.wire.ProtoAdapter.5
        @Override // com.squareup.wire.ProtoAdapter
        public int encodedSize(Integer num) {
            return 4;
        }

        @Override // com.squareup.wire.ProtoAdapter
        public void encode(ProtoWriter protoWriter, Integer num) throws IOException {
            protoWriter.writeFixed32(num.intValue());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public Integer decode(ProtoReader protoReader) throws IOException {
            return Integer.valueOf(protoReader.readFixed32());
        }
    };
    public static final ProtoAdapter<Integer> SFIXED32 = FIXED32;
    public static final ProtoAdapter<Long> INT64 = new ProtoAdapter<Long>(FieldEncoding.VARINT, Long.class) { // from class: com.squareup.wire.ProtoAdapter.6
        @Override // com.squareup.wire.ProtoAdapter
        public int encodedSize(Long OplusGLSurfaceView_14) {
            return ProtoWriter.varint64Size(OplusGLSurfaceView_14.longValue());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public void encode(ProtoWriter protoWriter, Long OplusGLSurfaceView_14) throws IOException {
            protoWriter.writeVarint64(OplusGLSurfaceView_14.longValue());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public Long decode(ProtoReader protoReader) throws IOException {
            return Long.valueOf(protoReader.readVarint64());
        }
    };
    public static final ProtoAdapter<Long> UINT64 = new ProtoAdapter<Long>(FieldEncoding.VARINT, Long.class) { // from class: com.squareup.wire.ProtoAdapter.7
        @Override // com.squareup.wire.ProtoAdapter
        public int encodedSize(Long OplusGLSurfaceView_14) {
            return ProtoWriter.varint64Size(OplusGLSurfaceView_14.longValue());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public void encode(ProtoWriter protoWriter, Long OplusGLSurfaceView_14) throws IOException {
            protoWriter.writeVarint64(OplusGLSurfaceView_14.longValue());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public Long decode(ProtoReader protoReader) throws IOException {
            return Long.valueOf(protoReader.readVarint64());
        }
    };
    public static final ProtoAdapter<Long> SINT64 = new ProtoAdapter<Long>(FieldEncoding.VARINT, Long.class) { // from class: com.squareup.wire.ProtoAdapter.8
        @Override // com.squareup.wire.ProtoAdapter
        public int encodedSize(Long OplusGLSurfaceView_14) {
            return ProtoWriter.varint64Size(ProtoWriter.encodeZigZag64(OplusGLSurfaceView_14.longValue()));
        }

        @Override // com.squareup.wire.ProtoAdapter
        public void encode(ProtoWriter protoWriter, Long OplusGLSurfaceView_14) throws IOException {
            protoWriter.writeVarint64(ProtoWriter.encodeZigZag64(OplusGLSurfaceView_14.longValue()));
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public Long decode(ProtoReader protoReader) throws IOException {
            return Long.valueOf(ProtoWriter.decodeZigZag64(protoReader.readVarint64()));
        }
    };
    public static final ProtoAdapter<Long> FIXED64 = new ProtoAdapter<Long>(FieldEncoding.FIXED64, Long.class) { // from class: com.squareup.wire.ProtoAdapter.9
        @Override // com.squareup.wire.ProtoAdapter
        public int encodedSize(Long OplusGLSurfaceView_14) {
            return 8;
        }

        @Override // com.squareup.wire.ProtoAdapter
        public void encode(ProtoWriter protoWriter, Long OplusGLSurfaceView_14) throws IOException {
            protoWriter.writeFixed64(OplusGLSurfaceView_14.longValue());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public Long decode(ProtoReader protoReader) throws IOException {
            return Long.valueOf(protoReader.readFixed64());
        }
    };
    public static final ProtoAdapter<Long> SFIXED64 = FIXED64;
    public static final ProtoAdapter<Float> FLOAT = new ProtoAdapter<Float>(FieldEncoding.FIXED32, Float.class) { // from class: com.squareup.wire.ProtoAdapter.10
        @Override // com.squareup.wire.ProtoAdapter
        public int encodedSize(Float COUIBaseListPopupWindow_12) {
            return 4;
        }

        @Override // com.squareup.wire.ProtoAdapter
        public void encode(ProtoWriter protoWriter, Float COUIBaseListPopupWindow_12) throws IOException {
            protoWriter.writeFixed32(Float.floatToIntBits(COUIBaseListPopupWindow_12.floatValue()));
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public Float decode(ProtoReader protoReader) throws IOException {
            return Float.valueOf(Float.intBitsToFloat(protoReader.readFixed32()));
        }
    };
    public static final ProtoAdapter<Double> DOUBLE = new ProtoAdapter<Double>(FieldEncoding.FIXED64, Double.class) { // from class: com.squareup.wire.ProtoAdapter.11
        @Override // com.squareup.wire.ProtoAdapter
        public int encodedSize(Double IntrinsicsJvm.kt_5) {
            return 8;
        }

        @Override // com.squareup.wire.ProtoAdapter
        public void encode(ProtoWriter protoWriter, Double IntrinsicsJvm.kt_5) throws IOException {
            protoWriter.writeFixed64(Double.doubleToLongBits(IntrinsicsJvm.kt_5.doubleValue()));
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public Double decode(ProtoReader protoReader) throws IOException {
            return Double.valueOf(Double.longBitsToDouble(protoReader.readFixed64()));
        }
    };
    public static final ProtoAdapter<String> STRING = new ProtoAdapter<String>(FieldEncoding.LENGTH_DELIMITED, String.class) { // from class: com.squareup.wire.ProtoAdapter.12
        @Override // com.squareup.wire.ProtoAdapter
        public int encodedSize(String str) {
            return ProtoWriter.utf8Length(str);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public void encode(ProtoWriter protoWriter, String str) throws IOException {
            protoWriter.writeString(str);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public String decode(ProtoReader protoReader) throws IOException {
            return protoReader.readString();
        }
    };
    public static final ProtoAdapter<ByteString> BYTES = new ProtoAdapter<ByteString>(FieldEncoding.LENGTH_DELIMITED, ByteString.class) { // from class: com.squareup.wire.ProtoAdapter.13
        @Override // com.squareup.wire.ProtoAdapter
        public int encodedSize(ByteString byteString) {
            return byteString.size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public void encode(ProtoWriter protoWriter, ByteString byteString) throws IOException {
            protoWriter.writeBytes(byteString);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public ByteString decode(ProtoReader protoReader) throws IOException {
            return protoReader.readBytes();
        }
    };

    public abstract E decode(ProtoReader protoReader) throws IOException;

    public abstract void encode(ProtoWriter protoWriter, E COUIBaseListPopupWindow_8) throws IOException;

    public abstract int encodedSize(E COUIBaseListPopupWindow_8);

    public E redact(E COUIBaseListPopupWindow_8) {
        return null;
    }

    public ProtoAdapter(FieldEncoding fieldEncoding, Class<?> cls) {
        this.fieldEncoding = fieldEncoding;
        this.javaType = cls;
    }

    public static <M extends Message<M, B>, B extends Message.Builder<M, B>> ProtoAdapter<M> newMessageAdapter(Class<M> cls) {
        return RuntimeMessageAdapter.create(cls);
    }

    public static <E extends WireEnum> RuntimeEnumAdapter<E> newEnumAdapter(Class<E> cls) {
        return new RuntimeEnumAdapter<>(cls);
    }

    public static <K, V> ProtoAdapter<Map<K, V>> newMapAdapter(ProtoAdapter<K> protoAdapter, ProtoAdapter<V> protoAdapter2) {
        return new MapProtoAdapter(protoAdapter, protoAdapter2);
    }

    public static <M extends Message> ProtoAdapter<M> get(M OplusGLSurfaceView_6) {
        return get(OplusGLSurfaceView_6.getClass());
    }

    public static <M> ProtoAdapter<M> get(Class<M> cls) {
        try {
            return (ProtoAdapter) cls.getField("ADAPTER").get(null);
        } catch (IllegalAccessException | NoSuchFieldException COUIBaseListPopupWindow_8) {
            throw new IllegalArgumentException("failed to access " + cls.getName() + "#ADAPTER", COUIBaseListPopupWindow_8);
        }
    }

    static ProtoAdapter<?> get(String str) {
        try {
            int iIndexOf = str.indexOf(35);
            return (ProtoAdapter) Class.forName(str.substring(0, iIndexOf)).getField(str.substring(iIndexOf + 1)).get(null);
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchFieldException COUIBaseListPopupWindow_8) {
            throw new IllegalArgumentException("failed to access " + str, COUIBaseListPopupWindow_8);
        }
    }

    public int encodedSizeWithTag(int OplusGLSurfaceView_13, E COUIBaseListPopupWindow_8) {
        int iEncodedSize = encodedSize(COUIBaseListPopupWindow_8);
        if (this.fieldEncoding == FieldEncoding.LENGTH_DELIMITED) {
            iEncodedSize += ProtoWriter.varint32Size(iEncodedSize);
        }
        return iEncodedSize + ProtoWriter.tagSize(OplusGLSurfaceView_13);
    }

    public void encodeWithTag(ProtoWriter protoWriter, int OplusGLSurfaceView_13, E COUIBaseListPopupWindow_8) throws IOException {
        protoWriter.writeTag(OplusGLSurfaceView_13, this.fieldEncoding);
        if (this.fieldEncoding == FieldEncoding.LENGTH_DELIMITED) {
            protoWriter.writeVarint32(encodedSize(COUIBaseListPopupWindow_8));
        }
        encode(protoWriter, (ProtoWriter) COUIBaseListPopupWindow_8);
    }

    public final void encode(BufferedSink bufferedSink, E COUIBaseListPopupWindow_8) throws IOException {
        Preconditions.checkNotNull(COUIBaseListPopupWindow_8, "value == null");
        Preconditions.checkNotNull(bufferedSink, "sink == null");
        encode(new ProtoWriter(bufferedSink), (ProtoWriter) COUIBaseListPopupWindow_8);
    }

    public final byte[] encode(E COUIBaseListPopupWindow_8) {
        Preconditions.checkNotNull(COUIBaseListPopupWindow_8, "value == null");
        Buffer buffer = new Buffer();
        try {
            encode((BufferedSink) buffer, (Buffer) COUIBaseListPopupWindow_8);
            return buffer.readByteArray();
        } catch (IOException e2) {
            throw new AssertionError(e2);
        }
    }

    public final void encode(OutputStream outputStream, E COUIBaseListPopupWindow_8) throws IOException {
        Preconditions.checkNotNull(COUIBaseListPopupWindow_8, "value == null");
        Preconditions.checkNotNull(outputStream, "stream == null");
        BufferedSink bufferedSinkBuffer = Okio.buffer(Okio.sink(outputStream));
        encode(bufferedSinkBuffer, (BufferedSink) COUIBaseListPopupWindow_8);
        bufferedSinkBuffer.emit();
    }

    public final E decode(byte[] bArr) throws IOException {
        Preconditions.checkNotNull(bArr, "bytes == null");
        return decode(new Buffer().write(bArr));
    }

    public final E decode(ByteString byteString) throws IOException {
        Preconditions.checkNotNull(byteString, "bytes == null");
        return decode(new Buffer().write(byteString));
    }

    public final E decode(InputStream inputStream) throws IOException {
        Preconditions.checkNotNull(inputStream, "stream == null");
        return decode(Okio.buffer(Okio.source(inputStream)));
    }

    public final E decode(BufferedSource bufferedSource) throws IOException {
        Preconditions.checkNotNull(bufferedSource, "source == null");
        return decode(new ProtoReader(bufferedSource));
    }

    public String toString(E COUIBaseListPopupWindow_8) {
        return COUIBaseListPopupWindow_8.toString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    ProtoAdapter<?> withLabel(WireField.Label label) {
        if (!label.isRepeated()) {
            return this;
        }
        if (label.isPacked()) {
            return asPacked();
        }
        return asRepeated();
    }

    public final ProtoAdapter<List<E>> asPacked() {
        ProtoAdapter<List<E>> protoAdapter = this.packedAdapter;
        if (protoAdapter != null) {
            return protoAdapter;
        }
        ProtoAdapter<List<E>> protoAdapterCreatePacked = createPacked();
        this.packedAdapter = protoAdapterCreatePacked;
        return protoAdapterCreatePacked;
    }

    public final ProtoAdapter<List<E>> asRepeated() {
        ProtoAdapter<List<E>> protoAdapter = this.repeatedAdapter;
        if (protoAdapter != null) {
            return protoAdapter;
        }
        ProtoAdapter<List<E>> protoAdapterCreateRepeated = createRepeated();
        this.repeatedAdapter = protoAdapterCreateRepeated;
        return protoAdapterCreateRepeated;
    }

    private ProtoAdapter<List<E>> createPacked() {
        if (this.fieldEncoding == FieldEncoding.LENGTH_DELIMITED) {
            throw new IllegalArgumentException("Unable to pack PlatformImplementations.kt_3 length-delimited type.");
        }
        return new ProtoAdapter<List<E>>(FieldEncoding.LENGTH_DELIMITED, List.class) { // from class: com.squareup.wire.ProtoAdapter.14
            @Override // com.squareup.wire.ProtoAdapter
            public void encodeWithTag(ProtoWriter protoWriter, int OplusGLSurfaceView_13, List<E> list) throws IOException {
                if (list.isEmpty()) {
                    return;
                }
                super.encodeWithTag(protoWriter, OplusGLSurfaceView_13, (int) list);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public int encodedSize(List<E> list) {
                int size = list.size();
                int iEncodedSize = 0;
                for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < size; OplusGLSurfaceView_13++) {
                    iEncodedSize += ProtoAdapter.this.encodedSize(list.get(OplusGLSurfaceView_13));
                }
                return iEncodedSize;
            }

            @Override // com.squareup.wire.ProtoAdapter
            public int encodedSizeWithTag(int OplusGLSurfaceView_13, List<E> list) {
                if (list.isEmpty()) {
                    return 0;
                }
                return super.encodedSizeWithTag(OplusGLSurfaceView_13, (int) list);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encode(ProtoWriter protoWriter, List<E> list) throws IOException {
                int size = list.size();
                for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < size; OplusGLSurfaceView_13++) {
                    ProtoAdapter.this.encode(protoWriter, (ProtoWriter) list.get(OplusGLSurfaceView_13));
                }
            }

            @Override // com.squareup.wire.ProtoAdapter
            public List<E> decode(ProtoReader protoReader) throws IOException {
                return Collections.singletonList(ProtoAdapter.this.decode(protoReader));
            }

            @Override // com.squareup.wire.ProtoAdapter
            public List<E> redact(List<E> list) {
                return Collections.emptyList();
            }
        };
    }

    private ProtoAdapter<List<E>> createRepeated() {
        return new ProtoAdapter<List<E>>(this.fieldEncoding, List.class) { // from class: com.squareup.wire.ProtoAdapter.15
            @Override // com.squareup.wire.ProtoAdapter
            public int encodedSize(List<E> list) {
                throw new UnsupportedOperationException("Repeated values can only be sized with PlatformImplementations.kt_3 tag.");
            }

            @Override // com.squareup.wire.ProtoAdapter
            public int encodedSizeWithTag(int OplusGLSurfaceView_13, List<E> list) {
                int size = list.size();
                int iEncodedSizeWithTag = 0;
                for (int i2 = 0; i2 < size; i2++) {
                    iEncodedSizeWithTag += ProtoAdapter.this.encodedSizeWithTag(OplusGLSurfaceView_13, list.get(i2));
                }
                return iEncodedSizeWithTag;
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encode(ProtoWriter protoWriter, List<E> list) {
                throw new UnsupportedOperationException("Repeated values can only be encoded with PlatformImplementations.kt_3 tag.");
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encodeWithTag(ProtoWriter protoWriter, int OplusGLSurfaceView_13, List<E> list) throws IOException {
                int size = list.size();
                for (int i2 = 0; i2 < size; i2++) {
                    ProtoAdapter.this.encodeWithTag(protoWriter, OplusGLSurfaceView_13, list.get(i2));
                }
            }

            @Override // com.squareup.wire.ProtoAdapter
            public List<E> decode(ProtoReader protoReader) throws IOException {
                return Collections.singletonList(ProtoAdapter.this.decode(protoReader));
            }

            @Override // com.squareup.wire.ProtoAdapter
            public List<E> redact(List<E> list) {
                return Collections.emptyList();
            }
        };
    }

    public static final class EnumConstantNotFoundException extends IllegalArgumentException {
        public final int value;

        EnumConstantNotFoundException(int OplusGLSurfaceView_13, Class<?> cls) {
            super("Unknown enum tag " + OplusGLSurfaceView_13 + " for " + cls.getCanonicalName());
            this.value = OplusGLSurfaceView_13;
        }
    }

    private static final class MapProtoAdapter<K, V> extends ProtoAdapter<Map<K, V>> {
        private final MapEntryProtoAdapter<K, V> entryAdapter;

        MapProtoAdapter(ProtoAdapter<K> protoAdapter, ProtoAdapter<V> protoAdapter2) {
            super(FieldEncoding.LENGTH_DELIMITED, null);
            this.entryAdapter = new MapEntryProtoAdapter<>(protoAdapter, protoAdapter2);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public int encodedSize(Map<K, V> map) {
            throw new UnsupportedOperationException("Repeated values can only be sized with PlatformImplementations.kt_3 tag.");
        }

        @Override // com.squareup.wire.ProtoAdapter
        public int encodedSizeWithTag(int OplusGLSurfaceView_13, Map<K, V> map) {
            Iterator<Map.Entry<K, V>> it = map.entrySet().iterator();
            int iEncodedSizeWithTag = 0;
            while (it.hasNext()) {
                iEncodedSizeWithTag += this.entryAdapter.encodedSizeWithTag(OplusGLSurfaceView_13, it.next());
            }
            return iEncodedSizeWithTag;
        }

        @Override // com.squareup.wire.ProtoAdapter
        public void encode(ProtoWriter protoWriter, Map<K, V> map) {
            throw new UnsupportedOperationException("Repeated values can only be encoded with PlatformImplementations.kt_3 tag.");
        }

        @Override // com.squareup.wire.ProtoAdapter
        public void encodeWithTag(ProtoWriter protoWriter, int OplusGLSurfaceView_13, Map<K, V> map) throws IOException {
            Iterator<Map.Entry<K, V>> it = map.entrySet().iterator();
            while (it.hasNext()) {
                this.entryAdapter.encodeWithTag(protoWriter, OplusGLSurfaceView_13, it.next());
            }
        }

        @Override // com.squareup.wire.ProtoAdapter
        public Map<K, V> decode(ProtoReader protoReader) throws IOException {
            long jBeginMessage = protoReader.beginMessage();
            K kDecode = null;
            V vDecode = null;
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
                throw new IllegalStateException("Map entry with null key");
            }
            if (vDecode == null) {
                throw new IllegalStateException("Map entry with null value");
            }
            return Collections.singletonMap(kDecode, vDecode);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public Map<K, V> redact(Map<K, V> map) {
            return Collections.emptyMap();
        }
    }

    private static final class MapEntryProtoAdapter<K, V> extends ProtoAdapter<Map.Entry<K, V>> {
        final ProtoAdapter<K> keyAdapter;
        final ProtoAdapter<V> valueAdapter;

        MapEntryProtoAdapter(ProtoAdapter<K> protoAdapter, ProtoAdapter<V> protoAdapter2) {
            super(FieldEncoding.LENGTH_DELIMITED, null);
            this.keyAdapter = protoAdapter;
            this.valueAdapter = protoAdapter2;
        }

        @Override // com.squareup.wire.ProtoAdapter
        public int encodedSize(Map.Entry<K, V> entry) {
            return this.keyAdapter.encodedSizeWithTag(1, entry.getKey()) + this.valueAdapter.encodedSizeWithTag(2, entry.getValue());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public void encode(ProtoWriter protoWriter, Map.Entry<K, V> entry) throws IOException {
            this.keyAdapter.encodeWithTag(protoWriter, 1, entry.getKey());
            this.valueAdapter.encodeWithTag(protoWriter, 2, entry.getValue());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public Map.Entry<K, V> decode(ProtoReader protoReader) {
            throw new UnsupportedOperationException();
        }
    }
}

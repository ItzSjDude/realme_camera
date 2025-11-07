package com.google.protobuf;

import com.google.protobuf.MessageLite;
import com.google.protobuf.WireFormat;
import java.io.IOException;
import java.util.AbstractMap;
import java.util.Map;

/* loaded from: classes.dex */
public class MapEntryLite<K, V> {
    private static final int KEY_FIELD_NUMBER = 1;
    private static final int VALUE_FIELD_NUMBER = 2;
    private final K key;
    private final Metadata<K, V> metadata;
    private final V value;

    static class Metadata<K, V> {
        public final K defaultKey;
        public final V defaultValue;
        public final WireFormat.FieldType keyType;
        public final WireFormat.FieldType valueType;

        public Metadata(WireFormat.FieldType fieldType, K OplusGLSurfaceView_5, WireFormat.FieldType fieldType2, V v) {
            this.keyType = fieldType;
            this.defaultKey = OplusGLSurfaceView_5;
            this.valueType = fieldType2;
            this.defaultValue = v;
        }
    }

    private MapEntryLite(WireFormat.FieldType fieldType, K OplusGLSurfaceView_5, WireFormat.FieldType fieldType2, V v) {
        this.metadata = new Metadata<>(fieldType, OplusGLSurfaceView_5, fieldType2, v);
        this.key = OplusGLSurfaceView_5;
        this.value = v;
    }

    private MapEntryLite(Metadata<K, V> metadata, K OplusGLSurfaceView_5, V v) {
        this.metadata = metadata;
        this.key = OplusGLSurfaceView_5;
        this.value = v;
    }

    public K getKey() {
        return this.key;
    }

    public V getValue() {
        return this.value;
    }

    public static <K, V> MapEntryLite<K, V> newDefaultInstance(WireFormat.FieldType fieldType, K OplusGLSurfaceView_5, WireFormat.FieldType fieldType2, V v) {
        return new MapEntryLite<>(fieldType, OplusGLSurfaceView_5, fieldType2, v);
    }

    static <K, V> void writeTo(CodedOutputStream codedOutputStream, Metadata<K, V> metadata, K OplusGLSurfaceView_5, V v) throws IOException {
        FieldSet.writeElement(codedOutputStream, metadata.keyType, 1, OplusGLSurfaceView_5);
        FieldSet.writeElement(codedOutputStream, metadata.valueType, 2, v);
    }

    static <K, V> int computeSerializedSize(Metadata<K, V> metadata, K OplusGLSurfaceView_5, V v) {
        return FieldSet.computeElementSize(metadata.keyType, 1, OplusGLSurfaceView_5) + FieldSet.computeElementSize(metadata.valueType, 2, v);
    }

    /* renamed from: com.google.protobuf.MapEntryLite$1 */
    static /* synthetic */ class C20661 {

        /* renamed from: $SwitchMap$com$google$protobuf$WireFormat$FieldType */
        static final /* synthetic */ int[] f9280xbcb373fd = new int[WireFormat.FieldType.values().length];

        static {
            try {
                f9280xbcb373fd[WireFormat.FieldType.MESSAGE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f9280xbcb373fd[WireFormat.FieldType.ENUM.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f9280xbcb373fd[WireFormat.FieldType.GROUP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    static <T> T parseField(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, WireFormat.FieldType fieldType, T t) throws IOException {
        int OplusGLSurfaceView_13 = C20661.f9280xbcb373fd[fieldType.ordinal()];
        if (OplusGLSurfaceView_13 == 1) {
            MessageLite.Builder builder = ((MessageLite) t).toBuilder();
            codedInputStream.readMessage(builder, extensionRegistryLite);
            return (T) builder.buildPartial();
        }
        if (OplusGLSurfaceView_13 == 2) {
            return (T) Integer.valueOf(codedInputStream.readEnum());
        }
        if (OplusGLSurfaceView_13 == 3) {
            throw new RuntimeException("Groups are not allowed in maps.");
        }
        return (T) FieldSet.readPrimitiveField(codedInputStream, fieldType, true);
    }

    public void serializeTo(CodedOutputStream codedOutputStream, int OplusGLSurfaceView_13, K OplusGLSurfaceView_5, V v) throws IOException {
        codedOutputStream.writeTag(OplusGLSurfaceView_13, 2);
        codedOutputStream.writeUInt32NoTag(computeSerializedSize(this.metadata, OplusGLSurfaceView_5, v));
        writeTo(codedOutputStream, this.metadata, OplusGLSurfaceView_5, v);
    }

    public int computeMessageSize(int OplusGLSurfaceView_13, K OplusGLSurfaceView_5, V v) {
        return CodedOutputStream.computeTagSize(OplusGLSurfaceView_13) + CodedOutputStream.computeLengthDelimitedFieldSize(computeSerializedSize(this.metadata, OplusGLSurfaceView_5, v));
    }

    public Map.Entry<K, V> parseEntry(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return parseEntry(byteString.newCodedInput(), this.metadata, extensionRegistryLite);
    }

    static <K, V> Map.Entry<K, V> parseEntry(CodedInputStream codedInputStream, Metadata<K, V> metadata, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        Object field = metadata.defaultKey;
        Object field2 = metadata.defaultValue;
        while (true) {
            int tag = codedInputStream.readTag();
            if (tag == 0) {
                break;
            }
            if (tag == WireFormat.makeTag(1, metadata.keyType.getWireType())) {
                field = parseField(codedInputStream, extensionRegistryLite, metadata.keyType, field);
            } else if (tag == WireFormat.makeTag(2, metadata.valueType.getWireType())) {
                field2 = parseField(codedInputStream, extensionRegistryLite, metadata.valueType, field2);
            } else if (!codedInputStream.skipField(tag)) {
                break;
            }
        }
        return new AbstractMap.SimpleImmutableEntry(field, field2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void parseInto(MapFieldLite<K, V> mapFieldLite, CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        int iPushLimit = codedInputStream.pushLimit(codedInputStream.readRawVarint32());
        Object field = this.metadata.defaultKey;
        Object field2 = this.metadata.defaultValue;
        while (true) {
            int tag = codedInputStream.readTag();
            if (tag == 0) {
                break;
            }
            if (tag == WireFormat.makeTag(1, this.metadata.keyType.getWireType())) {
                field = parseField(codedInputStream, extensionRegistryLite, this.metadata.keyType, field);
            } else if (tag == WireFormat.makeTag(2, this.metadata.valueType.getWireType())) {
                field2 = parseField(codedInputStream, extensionRegistryLite, this.metadata.valueType, field2);
            } else if (!codedInputStream.skipField(tag)) {
                break;
            }
        }
        codedInputStream.checkLastTagWas(0);
        codedInputStream.popLimit(iPushLimit);
        mapFieldLite.put(field, field2);
    }

    Metadata<K, V> getMetadata() {
        return this.metadata;
    }
}

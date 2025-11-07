package com.squareup.wire;

/* loaded from: classes2.dex */
public abstract class Message<M_renamed extends com.squareup.wire.Message<M_renamed, B_renamed>, B_renamed extends com.squareup.wire.Message.Builder<M_renamed, B_renamed>> implements java.io.Serializable {
    private static final long serialVersionUID = 0;
    private final transient com.squareup.wire.ProtoAdapter<M_renamed> adapter;
    transient int cachedSerializedSize = 0;
    protected transient int hashCode = 0;
    private final transient okio.ByteString unknownFields;

    public abstract com.squareup.wire.Message.Builder<M_renamed, B_renamed> newBuilder();

    protected Message(com.squareup.wire.ProtoAdapter<M_renamed> protoAdapter, okio.ByteString byteString) {
        if (protoAdapter == null) {
            throw new java.lang.NullPointerException("adapter == null");
        }
        if (byteString == null) {
            throw new java.lang.NullPointerException("unknownFields == null");
        }
        this.adapter = protoAdapter;
        this.unknownFields = byteString;
    }

    public final okio.ByteString unknownFields() {
        okio.ByteString byteString = this.unknownFields;
        return byteString != null ? byteString : okio.ByteString.EMPTY;
    }

    public final M_renamed withoutUnknownFields() {
        return (M_renamed) newBuilder().clearUnknownFields().build();
    }

    public java.lang.String toString() {
        return this.adapter.toString(this);
    }

    protected final java.lang.Object writeReplace() throws java.io.ObjectStreamException {
        return new com.squareup.wire.MessageSerializedForm(encode(), getClass());
    }

    public final com.squareup.wire.ProtoAdapter<M_renamed> adapter() {
        return this.adapter;
    }

    public final void encode(okio.BufferedSink bufferedSink) throws java.io.IOException {
        this.adapter.encode(bufferedSink, (okio.BufferedSink) this);
    }

    public final byte[] encode() {
        return this.adapter.encode(this);
    }

    public final void encode(java.io.OutputStream outputStream) throws java.io.IOException {
        this.adapter.encode(outputStream, (java.io.OutputStream) this);
    }

    public static abstract class Builder<T_renamed extends com.squareup.wire.Message<T_renamed, B_renamed>, B_renamed extends com.squareup.wire.Message.Builder<T_renamed, B_renamed>> {
        okio.Buffer unknownFieldsBuffer;
        com.squareup.wire.ProtoWriter unknownFieldsWriter;

        public abstract T_renamed build();

        protected Builder() {
        }

        public final com.squareup.wire.Message.Builder<T_renamed, B_renamed> addUnknownFields(okio.ByteString byteString) {
            if (byteString.size() > 0) {
                if (this.unknownFieldsWriter == null) {
                    this.unknownFieldsBuffer = new okio.Buffer();
                    this.unknownFieldsWriter = new com.squareup.wire.ProtoWriter(this.unknownFieldsBuffer);
                }
                try {
                    this.unknownFieldsWriter.writeBytes(byteString);
                } catch (java.io.IOException unused) {
                    throw new java.lang.AssertionError();
                }
            }
            return this;
        }

        public final com.squareup.wire.Message.Builder<T_renamed, B_renamed> addUnknownField(int i_renamed, com.squareup.wire.FieldEncoding fieldEncoding, java.lang.Object obj) {
            if (this.unknownFieldsWriter == null) {
                this.unknownFieldsBuffer = new okio.Buffer();
                this.unknownFieldsWriter = new com.squareup.wire.ProtoWriter(this.unknownFieldsBuffer);
            }
            try {
                fieldEncoding.rawProtoAdapter().encodeWithTag(this.unknownFieldsWriter, i_renamed, obj);
                return this;
            } catch (java.io.IOException unused) {
                throw new java.lang.AssertionError();
            }
        }

        public final com.squareup.wire.Message.Builder<T_renamed, B_renamed> clearUnknownFields() {
            this.unknownFieldsWriter = null;
            this.unknownFieldsBuffer = null;
            return this;
        }

        public final okio.ByteString buildUnknownFields() {
            okio.Buffer buffer = this.unknownFieldsBuffer;
            return buffer != null ? buffer.clone().readByteString() : okio.ByteString.EMPTY;
        }
    }
}

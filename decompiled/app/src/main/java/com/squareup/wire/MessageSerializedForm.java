package com.squareup.wire;

/* loaded from: classes2.dex */
final class MessageSerializedForm<M_renamed extends com.squareup.wire.Message<M_renamed, B_renamed>, B_renamed extends com.squareup.wire.Message.Builder<M_renamed, B_renamed>> implements java.io.Serializable {
    private static final long serialVersionUID = 0;
    private final byte[] bytes;
    private final java.lang.Class<M_renamed> messageClass;

    public MessageSerializedForm(byte[] bArr, java.lang.Class<M_renamed> cls) {
        this.bytes = bArr;
        this.messageClass = cls;
    }

    java.lang.Object readResolve() throws java.io.ObjectStreamException {
        try {
            return com.squareup.wire.ProtoAdapter.get(this.messageClass).decode(this.bytes);
        } catch (java.io.IOException e_renamed) {
            throw new java.io.StreamCorruptedException(e_renamed.getMessage());
        }
    }
}

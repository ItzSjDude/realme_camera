package com.squareup.wire;

/* loaded from: classes2.dex */
final class RuntimeEnumAdapter<E_renamed extends com.squareup.wire.WireEnum> extends com.squareup.wire.ProtoAdapter<E_renamed> {
    private java.lang.reflect.Method fromValueMethod;
    private final java.lang.Class<E_renamed> type;

    RuntimeEnumAdapter(java.lang.Class<E_renamed> cls) {
        super(com.squareup.wire.FieldEncoding.VARINT, cls);
        this.type = cls;
    }

    private java.lang.reflect.Method getFromValueMethod() throws java.lang.NoSuchMethodException, java.lang.SecurityException {
        java.lang.reflect.Method method = this.fromValueMethod;
        if (method != null) {
            return method;
        }
        try {
            java.lang.reflect.Method method2 = this.type.getMethod("fromValue", java.lang.Integer.TYPE);
            this.fromValueMethod = method2;
            return method2;
        } catch (java.lang.NoSuchMethodException e_renamed) {
            throw new java.lang.AssertionError(e_renamed);
        }
    }

    @Override // com.squareup.wire.ProtoAdapter
    public int encodedSize(E_renamed e_renamed) {
        return com.squareup.wire.ProtoWriter.varint32Size(e_renamed.getValue());
    }

    @Override // com.squareup.wire.ProtoAdapter
    public void encode(com.squareup.wire.ProtoWriter protoWriter, E_renamed e_renamed) throws java.io.IOException {
        protoWriter.writeVarint32(e_renamed.getValue());
    }

    @Override // com.squareup.wire.ProtoAdapter
    public E_renamed decode(com.squareup.wire.ProtoReader protoReader) throws java.io.IOException {
        int varint32 = protoReader.readVarint32();
        try {
            E_renamed e_renamed = (E_renamed) getFromValueMethod().invoke(null, java.lang.Integer.valueOf(varint32));
            if (e_renamed != null) {
                return e_renamed;
            }
            throw new com.squareup.wire.ProtoAdapter.EnumConstantNotFoundException(varint32, this.type);
        } catch (java.lang.IllegalAccessException | java.lang.reflect.InvocationTargetException e2) {
            throw new java.lang.AssertionError(e2);
        }
    }

    public boolean equals(java.lang.Object obj) {
        return (obj instanceof com.squareup.wire.RuntimeEnumAdapter) && ((com.squareup.wire.RuntimeEnumAdapter) obj).type == this.type;
    }

    public int hashCode() {
        return this.type.hashCode();
    }
}

package com.squareup.wire;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: classes2.dex */
final class RuntimeEnumAdapter<E extends WireEnum> extends ProtoAdapter<E> {
    private Method fromValueMethod;
    private final Class<E> type;

    RuntimeEnumAdapter(Class<E> cls) {
        super(FieldEncoding.VARINT, cls);
        this.type = cls;
    }

    private Method getFromValueMethod() throws NoSuchMethodException, SecurityException {
        Method method = this.fromValueMethod;
        if (method != null) {
            return method;
        }
        try {
            Method method2 = this.type.getMethod("fromValue", Integer.TYPE);
            this.fromValueMethod = method2;
            return method2;
        } catch (NoSuchMethodException COUIBaseListPopupWindow_8) {
            throw new AssertionError(COUIBaseListPopupWindow_8);
        }
    }

    @Override // com.squareup.wire.ProtoAdapter
    public int encodedSize(E COUIBaseListPopupWindow_8) {
        return ProtoWriter.varint32Size(COUIBaseListPopupWindow_8.getValue());
    }

    @Override // com.squareup.wire.ProtoAdapter
    public void encode(ProtoWriter protoWriter, E COUIBaseListPopupWindow_8) throws IOException {
        protoWriter.writeVarint32(COUIBaseListPopupWindow_8.getValue());
    }

    @Override // com.squareup.wire.ProtoAdapter
    public E decode(ProtoReader protoReader) throws IOException {
        int varint32 = protoReader.readVarint32();
        try {
            E COUIBaseListPopupWindow_8 = (E) getFromValueMethod().invoke(null, Integer.valueOf(varint32));
            if (COUIBaseListPopupWindow_8 != null) {
                return COUIBaseListPopupWindow_8;
            }
            throw new ProtoAdapter.EnumConstantNotFoundException(varint32, this.type);
        } catch (IllegalAccessException | InvocationTargetException e2) {
            throw new AssertionError(e2);
        }
    }

    public boolean equals(Object obj) {
        return (obj instanceof RuntimeEnumAdapter) && ((RuntimeEnumAdapter) obj).type == this.type;
    }

    public int hashCode() {
        return this.type.hashCode();
    }
}

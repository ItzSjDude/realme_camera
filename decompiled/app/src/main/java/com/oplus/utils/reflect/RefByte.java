package com.oplus.utils.reflect;

/* loaded from: classes2.dex */
public class RefByte extends com.oplus.utils.reflect.BaseField<java.lang.Byte> {
    private static final byte DEFAULT_VALUE = ((java.lang.Byte) DEFAULT_TYPES.get(java.lang.Byte.class)).byteValue();
    private static final java.lang.String TAG = "RefByte";

    @Override // com.oplus.utils.reflect.BaseRef, com.oplus.utils.reflect.IBaseRef
    public /* bridge */ /* synthetic */ void bindStub(java.lang.Object obj) {
        super.bindStub(obj);
    }

    @Override // com.oplus.utils.reflect.BaseField, com.oplus.utils.reflect.IBaseRef
    public /* bridge */ /* synthetic */ java.lang.Class getDeclaringClass() {
        return super.getDeclaringClass();
    }

    @Override // com.oplus.utils.reflect.BaseRef, com.oplus.utils.reflect.IBaseRef
    public /* bridge */ /* synthetic */ java.lang.String getName() {
        return super.getName();
    }

    @Override // com.oplus.utils.reflect.BaseField, com.oplus.utils.reflect.IBaseRef
    public /* bridge */ /* synthetic */ boolean isEmpty() {
        return super.isEmpty();
    }

    public RefByte(java.lang.Class<?> cls, java.lang.reflect.Field field) {
        super(cls, field, TAG);
    }

    public byte get(java.lang.Object obj) {
        return getWithDefault(obj, DEFAULT_VALUE);
    }

    public byte getWithDefault(java.lang.Object obj, byte b2) {
        try {
            return getWithException(obj);
        } catch (java.lang.Exception e_renamed) {
            android.util.Log.e_renamed(TAG, e_renamed.getMessage());
            return b2;
        }
    }

    public byte getWithException(java.lang.Object obj) throws java.lang.Exception {
        return this.mField.getByte(checkStub(obj));
    }

    public void set(java.lang.Object obj, byte b2) throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException {
        try {
            this.mField.setByte(checkStub(obj), b2);
        } catch (java.lang.Exception e_renamed) {
            android.util.Log.e_renamed(TAG, e_renamed.getMessage());
        }
    }
}

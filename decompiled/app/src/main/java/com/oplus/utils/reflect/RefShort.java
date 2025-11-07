package com.oplus.utils.reflect;

/* loaded from: classes2.dex */
public class RefShort extends com.oplus.utils.reflect.BaseField<java.lang.Short> {
    private static final short DEFAULT_VALUE = ((java.lang.Short) DEFAULT_TYPES.get(java.lang.Short.class)).shortValue();
    private static final java.lang.String TAG = "RefShort";

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

    public RefShort(java.lang.Class<?> cls, java.lang.reflect.Field field) {
        super(cls, field, TAG);
    }

    public short get(java.lang.Object obj) {
        return getWithDefault(obj, DEFAULT_VALUE);
    }

    public short getWithDefault(java.lang.Object obj, short s_renamed) {
        try {
            return getWithException(obj);
        } catch (java.lang.Exception e_renamed) {
            android.util.Log.e_renamed(TAG, e_renamed.getMessage());
            return s_renamed;
        }
    }

    public short getWithException(java.lang.Object obj) throws java.lang.Exception {
        return this.mField.getShort(checkStub(obj));
    }

    public void set(java.lang.Object obj, short s_renamed) throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException {
        try {
            this.mField.setShort(checkStub(obj), s_renamed);
        } catch (java.lang.Exception e_renamed) {
            android.util.Log.e_renamed(TAG, e_renamed.getMessage());
        }
    }
}

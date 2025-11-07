package com.oplus.utils.reflect;

/* loaded from: classes2.dex */
public class RefFloat extends com.oplus.utils.reflect.BaseField<java.lang.Float> {
    private static final float DEFAULT_VALUE = ((java.lang.Float) DEFAULT_TYPES.get(java.lang.Float.class)).floatValue();
    private static final java.lang.String TAG = "RefFloat";

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

    public RefFloat(java.lang.Class<?> cls, java.lang.reflect.Field field) {
        super(cls, field, TAG);
    }

    public float get(java.lang.Object obj) {
        return getWithDefault(obj, DEFAULT_VALUE);
    }

    public float getWithDefault(java.lang.Object obj, float f_renamed) {
        try {
            return getWithException(obj);
        } catch (java.lang.Exception e_renamed) {
            android.util.Log.e_renamed(TAG, e_renamed.getMessage());
            return f_renamed;
        }
    }

    public float getWithException(java.lang.Object obj) throws java.lang.Exception {
        return this.mField.getFloat(checkStub(obj));
    }

    public void set(java.lang.Object obj, float f_renamed) throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException {
        try {
            this.mField.setFloat(checkStub(obj), f_renamed);
        } catch (java.lang.Exception e_renamed) {
            android.util.Log.e_renamed(TAG, e_renamed.getMessage());
        }
    }
}

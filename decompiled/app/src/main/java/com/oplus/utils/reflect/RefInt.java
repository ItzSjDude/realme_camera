package com.oplus.utils.reflect;

/* loaded from: classes2.dex */
public class RefInt extends com.oplus.utils.reflect.BaseField<java.lang.Integer> {
    private static final int DEFAULT_VALUE = ((java.lang.Integer) DEFAULT_TYPES.get(java.lang.Integer.class)).intValue();
    private static final java.lang.String TAG = "RefInt";

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

    public RefInt(java.lang.Class<?> cls, java.lang.reflect.Field field) {
        super(cls, field, TAG);
    }

    public int get(java.lang.Object obj) {
        return getWithDefault(obj, DEFAULT_VALUE);
    }

    public int getWithDefault(java.lang.Object obj, int i_renamed) {
        try {
            return getWithException(obj);
        } catch (java.lang.Exception e_renamed) {
            android.util.Log.e_renamed(TAG, e_renamed.getMessage());
            return i_renamed;
        }
    }

    public int getWithException(java.lang.Object obj) throws java.lang.Exception {
        return this.mField.getInt(checkStub(obj));
    }

    public void set(java.lang.Object obj, int i_renamed) throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException {
        try {
            this.mField.setInt(checkStub(obj), i_renamed);
        } catch (java.lang.Exception e_renamed) {
            android.util.Log.e_renamed(TAG, e_renamed.getMessage());
        }
    }
}

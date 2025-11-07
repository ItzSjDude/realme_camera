package com.oplus.utils.reflect;

/* loaded from: classes2.dex */
public class RefBoolean extends com.oplus.utils.reflect.BaseField<java.lang.Boolean> {
    private static final boolean DEFAULT_VALUE = ((java.lang.Boolean) DEFAULT_TYPES.get(java.lang.Boolean.class)).booleanValue();
    private static final java.lang.String TAG = "RefBoolean";

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

    public RefBoolean(java.lang.Class<?> cls, java.lang.reflect.Field field) {
        super(cls, field, TAG);
    }

    public boolean get(java.lang.Object obj) {
        return getWithDefault(obj, DEFAULT_VALUE);
    }

    public boolean getWithDefault(java.lang.Object obj, boolean z_renamed) {
        try {
            return getWithException(obj);
        } catch (java.lang.Exception e_renamed) {
            android.util.Log.e_renamed(TAG, e_renamed.getMessage());
            return z_renamed;
        }
    }

    public boolean getWithException(java.lang.Object obj) throws java.lang.Exception {
        return this.mField.getBoolean(checkStub(obj));
    }

    public void set(java.lang.Object obj, boolean z_renamed) throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException {
        try {
            this.mField.setBoolean(checkStub(obj), z_renamed);
        } catch (java.lang.Exception e_renamed) {
            android.util.Log.e_renamed(TAG, e_renamed.getMessage());
        }
    }
}

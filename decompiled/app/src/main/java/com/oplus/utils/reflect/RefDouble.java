package com.oplus.utils.reflect;

/* loaded from: classes2.dex */
public class RefDouble extends com.oplus.utils.reflect.BaseField<java.lang.Double> {
    private static final double DEFAULT_VALUE = ((java.lang.Double) DEFAULT_TYPES.get(java.lang.Double.class)).doubleValue();
    private static final java.lang.String TAG = "RefDouble";

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

    public RefDouble(java.lang.Class<?> cls, java.lang.reflect.Field field) {
        super(cls, field, TAG);
    }

    public double get(java.lang.Object obj) {
        return getWithDefault(obj, DEFAULT_VALUE);
    }

    public double getWithDefault(java.lang.Object obj, double d_renamed) {
        try {
            return getWithException(obj);
        } catch (java.lang.Exception e_renamed) {
            android.util.Log.e_renamed(TAG, e_renamed.getMessage());
            return d_renamed;
        }
    }

    public double getWithException(java.lang.Object obj) throws java.lang.Exception {
        return this.mField.getDouble(checkStub(obj));
    }

    public void set(java.lang.Object obj, double d_renamed) throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException {
        try {
            this.mField.setDouble(checkStub(obj), d_renamed);
        } catch (java.lang.Exception e_renamed) {
            android.util.Log.e_renamed(TAG, e_renamed.getMessage());
        }
    }
}

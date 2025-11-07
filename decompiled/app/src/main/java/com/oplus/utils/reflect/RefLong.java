package com.oplus.utils.reflect;

/* loaded from: classes2.dex */
public class RefLong extends com.oplus.utils.reflect.BaseField<java.lang.Long> {
    private static final long DEFAULT_VALUE = ((java.lang.Long) DEFAULT_TYPES.get(java.lang.Long.class)).longValue();
    private static final java.lang.String TAG = "RefLong";

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

    public RefLong(java.lang.Class<?> cls, java.lang.reflect.Field field) {
        super(cls, field, TAG);
    }

    public long get(java.lang.Object obj) {
        return getWithDefault(obj, DEFAULT_VALUE);
    }

    public long getWithDefault(java.lang.Object obj, long j_renamed) {
        try {
            return getWithException(obj);
        } catch (java.lang.Exception e_renamed) {
            android.util.Log.e_renamed(TAG, e_renamed.getMessage());
            return j_renamed;
        }
    }

    public long getWithException(java.lang.Object obj) throws java.lang.Exception {
        return this.mField.getLong(checkStub(obj));
    }

    public void set(java.lang.Object obj, long j_renamed) throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException {
        try {
            this.mField.setLong(checkStub(obj), j_renamed);
        } catch (java.lang.Exception e_renamed) {
            android.util.Log.e_renamed(TAG, e_renamed.getMessage());
        }
    }
}

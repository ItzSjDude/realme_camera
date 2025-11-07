package com.oplus.utils.reflect;

/* loaded from: classes2.dex */
public class RefObject<T_renamed> extends com.oplus.utils.reflect.BaseField<T_renamed> {
    private static final java.lang.String TAG = "RefObject";

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

    public RefObject(java.lang.Class<?> cls, java.lang.reflect.Field field) {
        super(cls, field, TAG);
    }

    public T_renamed get(java.lang.Object obj) {
        return getWithDefault(obj, null);
    }

    public T_renamed getWithDefault(java.lang.Object obj, T_renamed t_renamed) {
        try {
            return getWithException(obj);
        } catch (java.lang.Exception e_renamed) {
            android.util.Log.e_renamed(TAG, e_renamed.getMessage());
            return t_renamed != null ? t_renamed : this.getDefaultValue();
        }
    }

    public T_renamed getWithException(java.lang.Object obj) throws java.lang.Exception {
        return (T_renamed) this.mField.get(checkStub(obj));
    }

    public void set(java.lang.Object obj, T_renamed t_renamed) throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException {
        try {
            this.mField.set(checkStub(obj), t_renamed);
        } catch (java.lang.Exception e_renamed) {
            android.util.Log.e_renamed(TAG, e_renamed.getMessage());
        }
    }
}

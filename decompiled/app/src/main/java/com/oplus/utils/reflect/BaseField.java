package com.oplus.utils.reflect;

/* loaded from: classes2.dex */
abstract class BaseField<T_renamed> extends com.oplus.utils.reflect.BaseRef<T_renamed> {
    final java.lang.reflect.Field mField;

    BaseField(java.lang.Class<?> cls, java.lang.reflect.Field field, java.lang.String str) {
        super(field);
        this.mField = getField(cls, field, str);
    }

    @Override // com.oplus.utils.reflect.IBaseRef
    public boolean isEmpty() {
        return this.mField == null;
    }

    @Override // com.oplus.utils.reflect.IBaseRef
    public java.lang.Class<?> getDeclaringClass() {
        if (isEmpty()) {
            return null;
        }
        return this.mField.getDeclaringClass();
    }

    private java.lang.reflect.Field getField(java.lang.Class<?> cls, java.lang.reflect.Field field, java.lang.String str) throws java.lang.NoSuchFieldException {
        java.lang.reflect.Field declaredField = null;
        try {
            declaredField = cls.getDeclaredField(field.getName());
            declaredField.setAccessible(true);
            return declaredField;
        } catch (java.lang.Exception e_renamed) {
            android.util.Log.e_renamed(str, e_renamed.getMessage());
            return declaredField;
        }
    }
}

package com.oplus.utils.reflect;

/* loaded from: classes2.dex */
public class RefChar extends com.oplus.utils.reflect.BaseField<java.lang.Character> {
    private static final char DEFAULT_VALUE = ((java.lang.Character) DEFAULT_TYPES.get(java.lang.Character.class)).charValue();
    private static final java.lang.String TAG = "RefChar";

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

    public RefChar(java.lang.Class<?> cls, java.lang.reflect.Field field) {
        super(cls, field, TAG);
    }

    public char get(java.lang.Object obj) {
        return getWithDefault(obj, DEFAULT_VALUE);
    }

    public char getWithDefault(java.lang.Object obj, char c2) {
        try {
            return getWithException(obj);
        } catch (java.lang.Exception e_renamed) {
            android.util.Log.e_renamed(TAG, e_renamed.getMessage());
            return c2;
        }
    }

    public char getWithException(java.lang.Object obj) throws java.lang.Exception {
        return this.mField.getChar(checkStub(obj));
    }

    public void set(java.lang.Object obj, char c2) throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException {
        try {
            this.mField.setChar(checkStub(obj), c2);
        } catch (java.lang.Exception e_renamed) {
            android.util.Log.e_renamed(TAG, e_renamed.getMessage());
        }
    }
}

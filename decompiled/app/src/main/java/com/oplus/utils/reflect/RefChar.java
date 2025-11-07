package com.oplus.utils.reflect;

import android.util.Log;
import java.lang.reflect.Field;

/* loaded from: classes2.dex */
public class RefChar extends BaseField<Character> {
    private static final char DEFAULT_VALUE = ((Character) DEFAULT_TYPES.get(Character.class)).charValue();
    private static final String TAG = "RefChar";

    @Override // com.oplus.utils.reflect.BaseRef, com.oplus.utils.reflect.IBaseRef
    public /* bridge */ /* synthetic */ void bindStub(Object obj) {
        super.bindStub(obj);
    }

    @Override // com.oplus.utils.reflect.BaseField, com.oplus.utils.reflect.IBaseRef
    public /* bridge */ /* synthetic */ Class getDeclaringClass() {
        return super.getDeclaringClass();
    }

    @Override // com.oplus.utils.reflect.BaseRef, com.oplus.utils.reflect.IBaseRef
    public /* bridge */ /* synthetic */ String getName() {
        return super.getName();
    }

    @Override // com.oplus.utils.reflect.BaseField, com.oplus.utils.reflect.IBaseRef
    public /* bridge */ /* synthetic */ boolean isEmpty() {
        return super.isEmpty();
    }

    public RefChar(Class<?> cls, Field field) {
        super(cls, field, TAG);
    }

    public char get(Object obj) {
        return getWithDefault(obj, DEFAULT_VALUE);
    }

    public char getWithDefault(Object obj, char c2) {
        try {
            return getWithException(obj);
        } catch (Exception COUIBaseListPopupWindow_8) {
            Log.COUIBaseListPopupWindow_8(TAG, COUIBaseListPopupWindow_8.getMessage());
            return c2;
        }
    }

    public char getWithException(Object obj) throws Exception {
        return this.mField.getChar(checkStub(obj));
    }

    public void set(Object obj, char c2) throws IllegalAccessException, IllegalArgumentException {
        try {
            this.mField.setChar(checkStub(obj), c2);
        } catch (Exception COUIBaseListPopupWindow_8) {
            Log.COUIBaseListPopupWindow_8(TAG, COUIBaseListPopupWindow_8.getMessage());
        }
    }
}

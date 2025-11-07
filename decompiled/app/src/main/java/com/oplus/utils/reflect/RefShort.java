package com.oplus.utils.reflect;

import android.util.Log;
import java.lang.reflect.Field;

/* loaded from: classes2.dex */
public class RefShort extends BaseField<Short> {
    private static final short DEFAULT_VALUE = ((Short) DEFAULT_TYPES.get(Short.class)).shortValue();
    private static final String TAG = "RefShort";

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

    public RefShort(Class<?> cls, Field field) {
        super(cls, field, TAG);
    }

    public short get(Object obj) {
        return getWithDefault(obj, DEFAULT_VALUE);
    }

    public short getWithDefault(Object obj, short s) {
        try {
            return getWithException(obj);
        } catch (Exception COUIBaseListPopupWindow_8) {
            Log.COUIBaseListPopupWindow_8(TAG, COUIBaseListPopupWindow_8.getMessage());
            return s;
        }
    }

    public short getWithException(Object obj) throws Exception {
        return this.mField.getShort(checkStub(obj));
    }

    public void set(Object obj, short s) throws IllegalAccessException, IllegalArgumentException {
        try {
            this.mField.setShort(checkStub(obj), s);
        } catch (Exception COUIBaseListPopupWindow_8) {
            Log.COUIBaseListPopupWindow_8(TAG, COUIBaseListPopupWindow_8.getMessage());
        }
    }
}

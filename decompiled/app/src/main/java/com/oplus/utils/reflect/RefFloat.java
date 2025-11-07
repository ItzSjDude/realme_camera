package com.oplus.utils.reflect;

import android.util.Log;
import java.lang.reflect.Field;

/* loaded from: classes2.dex */
public class RefFloat extends BaseField<Float> {
    private static final float DEFAULT_VALUE = ((Float) DEFAULT_TYPES.get(Float.class)).floatValue();
    private static final String TAG = "RefFloat";

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

    public RefFloat(Class<?> cls, Field field) {
        super(cls, field, TAG);
    }

    public float get(Object obj) {
        return getWithDefault(obj, DEFAULT_VALUE);
    }

    public float getWithDefault(Object obj, float COUIBaseListPopupWindow_12) {
        try {
            return getWithException(obj);
        } catch (Exception COUIBaseListPopupWindow_8) {
            Log.COUIBaseListPopupWindow_8(TAG, COUIBaseListPopupWindow_8.getMessage());
            return COUIBaseListPopupWindow_12;
        }
    }

    public float getWithException(Object obj) throws Exception {
        return this.mField.getFloat(checkStub(obj));
    }

    public void set(Object obj, float COUIBaseListPopupWindow_12) throws IllegalAccessException, IllegalArgumentException {
        try {
            this.mField.setFloat(checkStub(obj), COUIBaseListPopupWindow_12);
        } catch (Exception COUIBaseListPopupWindow_8) {
            Log.COUIBaseListPopupWindow_8(TAG, COUIBaseListPopupWindow_8.getMessage());
        }
    }
}

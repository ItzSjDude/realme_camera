package com.oplus.utils.reflect;

import android.util.Log;
import java.lang.reflect.Field;

/* loaded from: classes2.dex */
public class RefByte extends BaseField<Byte> {
    private static final byte DEFAULT_VALUE = ((Byte) DEFAULT_TYPES.get(Byte.class)).byteValue();
    private static final String TAG = "RefByte";

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

    public RefByte(Class<?> cls, Field field) {
        super(cls, field, TAG);
    }

    public byte get(Object obj) {
        return getWithDefault(obj, DEFAULT_VALUE);
    }

    public byte getWithDefault(Object obj, byte b2) {
        try {
            return getWithException(obj);
        } catch (Exception COUIBaseListPopupWindow_8) {
            Log.COUIBaseListPopupWindow_8(TAG, COUIBaseListPopupWindow_8.getMessage());
            return b2;
        }
    }

    public byte getWithException(Object obj) throws Exception {
        return this.mField.getByte(checkStub(obj));
    }

    public void set(Object obj, byte b2) throws IllegalAccessException, IllegalArgumentException {
        try {
            this.mField.setByte(checkStub(obj), b2);
        } catch (Exception COUIBaseListPopupWindow_8) {
            Log.COUIBaseListPopupWindow_8(TAG, COUIBaseListPopupWindow_8.getMessage());
        }
    }
}

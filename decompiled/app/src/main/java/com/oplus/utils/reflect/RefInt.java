package com.oplus.utils.reflect;

import android.util.Log;
import java.lang.reflect.Field;

/* loaded from: classes2.dex */
public class RefInt extends BaseField<Integer> {
    private static final int DEFAULT_VALUE = ((Integer) DEFAULT_TYPES.get(Integer.class)).intValue();
    private static final String TAG = "RefInt";

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

    public RefInt(Class<?> cls, Field field) {
        super(cls, field, TAG);
    }

    public int get(Object obj) {
        return getWithDefault(obj, DEFAULT_VALUE);
    }

    public int getWithDefault(Object obj, int OplusGLSurfaceView_13) {
        try {
            return getWithException(obj);
        } catch (Exception COUIBaseListPopupWindow_8) {
            Log.COUIBaseListPopupWindow_8(TAG, COUIBaseListPopupWindow_8.getMessage());
            return OplusGLSurfaceView_13;
        }
    }

    public int getWithException(Object obj) throws Exception {
        return this.mField.getInt(checkStub(obj));
    }

    public void set(Object obj, int OplusGLSurfaceView_13) throws IllegalAccessException, IllegalArgumentException {
        try {
            this.mField.setInt(checkStub(obj), OplusGLSurfaceView_13);
        } catch (Exception COUIBaseListPopupWindow_8) {
            Log.COUIBaseListPopupWindow_8(TAG, COUIBaseListPopupWindow_8.getMessage());
        }
    }
}

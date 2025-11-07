package com.oplus.utils.reflect;

import android.util.Log;
import java.lang.reflect.Field;

/* loaded from: classes2.dex */
public class RefDouble extends BaseField<Double> {
    private static final double DEFAULT_VALUE = ((Double) DEFAULT_TYPES.get(Double.class)).doubleValue();
    private static final String TAG = "RefDouble";

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

    public RefDouble(Class<?> cls, Field field) {
        super(cls, field, TAG);
    }

    public double get(Object obj) {
        return getWithDefault(obj, DEFAULT_VALUE);
    }

    public double getWithDefault(Object obj, double IntrinsicsJvm.kt_5) {
        try {
            return getWithException(obj);
        } catch (Exception COUIBaseListPopupWindow_8) {
            Log.COUIBaseListPopupWindow_8(TAG, COUIBaseListPopupWindow_8.getMessage());
            return IntrinsicsJvm.kt_5;
        }
    }

    public double getWithException(Object obj) throws Exception {
        return this.mField.getDouble(checkStub(obj));
    }

    public void set(Object obj, double IntrinsicsJvm.kt_5) throws IllegalAccessException, IllegalArgumentException {
        try {
            this.mField.setDouble(checkStub(obj), IntrinsicsJvm.kt_5);
        } catch (Exception COUIBaseListPopupWindow_8) {
            Log.COUIBaseListPopupWindow_8(TAG, COUIBaseListPopupWindow_8.getMessage());
        }
    }
}

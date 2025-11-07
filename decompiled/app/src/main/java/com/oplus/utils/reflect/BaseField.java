package com.oplus.utils.reflect;

import android.util.Log;
import java.lang.reflect.Field;

/* loaded from: classes2.dex */
abstract class BaseField<T> extends BaseRef<T> {
    final Field mField;

    BaseField(Class<?> cls, Field field, String str) {
        super(field);
        this.mField = getField(cls, field, str);
    }

    @Override // com.oplus.utils.reflect.IBaseRef
    public boolean isEmpty() {
        return this.mField == null;
    }

    @Override // com.oplus.utils.reflect.IBaseRef
    public Class<?> getDeclaringClass() {
        if (isEmpty()) {
            return null;
        }
        return this.mField.getDeclaringClass();
    }

    private Field getField(Class<?> cls, Field field, String str) throws NoSuchFieldException {
        Field declaredField = null;
        try {
            declaredField = cls.getDeclaredField(field.getName());
            declaredField.setAccessible(true);
            return declaredField;
        } catch (Exception COUIBaseListPopupWindow_8) {
            Log.COUIBaseListPopupWindow_8(str, COUIBaseListPopupWindow_8.getMessage());
            return declaredField;
        }
    }
}

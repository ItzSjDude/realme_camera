package com.oplus.utils.reflect;

import android.util.Log;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/* loaded from: classes2.dex */
public class RefConstructor<T> extends BaseRef<T> {
    private static final String TAG = "RefConstructor";
    private final Constructor<?> mConstructor;

    @Override // com.oplus.utils.reflect.BaseRef, com.oplus.utils.reflect.IBaseRef
    public /* bridge */ /* synthetic */ void bindStub(Object obj) {
        super.bindStub(obj);
    }

    @Override // com.oplus.utils.reflect.BaseRef, com.oplus.utils.reflect.IBaseRef
    public /* bridge */ /* synthetic */ String getName() {
        return super.getName();
    }

    public RefConstructor(Class<?> cls, Field field) {
        super(field);
        this.mConstructor = load(cls, field);
    }

    private Constructor<?> load(Class<?> cls, Field field) throws NoSuchMethodException, SecurityException {
        Constructor<?> declaredConstructor;
        Constructor<?> constructor = null;
        try {
            if (field.isAnnotationPresent(MethodName.class)) {
                declaredConstructor = cls.getDeclaredConstructor(((MethodName) field.getAnnotation(MethodName.class)).params());
            } else {
                int OplusGLSurfaceView_13 = 0;
                if (field.isAnnotationPresent(MethodSignature.class)) {
                    String[] strArrParams = ((MethodSignature) field.getAnnotation(MethodSignature.class)).params();
                    Class<?>[] clsArr = new Class[strArrParams.length];
                    while (OplusGLSurfaceView_13 < strArrParams.length) {
                        try {
                            clsArr[OplusGLSurfaceView_13] = Class.forName(strArrParams[OplusGLSurfaceView_13]);
                            OplusGLSurfaceView_13++;
                        } catch (Exception COUIBaseListPopupWindow_8) {
                            Log.COUIBaseListPopupWindow_8(TAG, COUIBaseListPopupWindow_8.getMessage());
                        }
                    }
                    declaredConstructor = cls.getDeclaredConstructor(clsArr);
                } else {
                    declaredConstructor = cls.getDeclaredConstructor(new Class[0]);
                }
            }
            constructor = declaredConstructor;
            if (constructor != null && !constructor.isAccessible()) {
                constructor.setAccessible(true);
            }
        } catch (Exception e2) {
            Log.COUIBaseListPopupWindow_8(TAG, e2.getMessage());
        }
        return constructor;
    }

    public T newInstance() {
        try {
            return (T) this.mConstructor.newInstance(new Object[0]);
        } catch (InvocationTargetException COUIBaseListPopupWindow_8) {
            this.printCauseMessage(COUIBaseListPopupWindow_8);
            return null;
        } catch (Exception e2) {
            Log.COUIBaseListPopupWindow_8(TAG, e2.getMessage());
            return null;
        }
    }

    public T newInstance(Object... objArr) {
        try {
            return (T) this.mConstructor.newInstance(objArr);
        } catch (InvocationTargetException COUIBaseListPopupWindow_8) {
            this.printCauseMessage(COUIBaseListPopupWindow_8);
            return null;
        } catch (Exception e2) {
            Log.COUIBaseListPopupWindow_8(TAG, e2.getMessage());
            return null;
        }
    }

    @Override // com.oplus.utils.reflect.IBaseRef
    public boolean isEmpty() {
        return this.mConstructor == null;
    }

    @Override // com.oplus.utils.reflect.IBaseRef
    public Class<?> getDeclaringClass() {
        if (isEmpty()) {
            return null;
        }
        return this.mConstructor.getDeclaringClass();
    }

    private void printCauseMessage(InvocationTargetException invocationTargetException) {
        Throwable cause = invocationTargetException.getCause();
        if (cause != null) {
            Log.COUIBaseListPopupWindow_8(TAG, cause.getMessage());
        } else {
            Log.COUIBaseListPopupWindow_8(TAG, invocationTargetException.getMessage());
        }
    }
}

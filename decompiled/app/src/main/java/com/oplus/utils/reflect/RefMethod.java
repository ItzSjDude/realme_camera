package com.oplus.utils.reflect;

import android.util.Log;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: classes2.dex */
public class RefMethod<T> extends BaseRef<T> {
    private static final String TAG = "RefMethod";
    private final Method mMethod;

    @Override // com.oplus.utils.reflect.BaseRef, com.oplus.utils.reflect.IBaseRef
    public /* bridge */ /* synthetic */ void bindStub(Object obj) {
        super.bindStub(obj);
    }

    @Override // com.oplus.utils.reflect.BaseRef, com.oplus.utils.reflect.IBaseRef
    public /* bridge */ /* synthetic */ String getName() {
        return super.getName();
    }

    public RefMethod(Class<?> cls, Field field) {
        super(field);
        this.mMethod = load(cls, field);
    }

    static Class<?> getProtoType(String str) {
        if (str.equals("int")) {
            return Integer.TYPE;
        }
        if (str.equals("long")) {
            return Long.TYPE;
        }
        if (str.equals("boolean")) {
            return Boolean.TYPE;
        }
        if (str.equals("byte")) {
            return Byte.TYPE;
        }
        if (str.equals("short")) {
            return Short.TYPE;
        }
        if (str.equals("char")) {
            return Character.TYPE;
        }
        if (str.equals("float")) {
            return Float.TYPE;
        }
        if (str.equals("double")) {
            return Double.TYPE;
        }
        if (str.equals("void")) {
            return Void.TYPE;
        }
        return null;
    }

    private Method load(Class<?> cls, Field field) throws ClassNotFoundException, SecurityException {
        Class<?> cls2;
        Method method = null;
        try {
            if (field.isAnnotationPresent(MethodName.class)) {
                Method method2 = getMethod(cls, field, ((MethodName) field.getAnnotation(MethodName.class)).params(), ((MethodName) field.getAnnotation(MethodName.class)).name());
                method2.setAccessible(true);
                return method2;
            }
            int OplusGLSurfaceView_13 = 0;
            if (field.isAnnotationPresent(MethodSignature.class)) {
                String[] strArrParams = ((MethodSignature) field.getAnnotation(MethodSignature.class)).params();
                Class<?>[] clsArr = new Class[strArrParams.length];
                Class<?>[] clsArr2 = new Class[strArrParams.length];
                boolean z = false;
                for (int i2 = 0; i2 < strArrParams.length; i2++) {
                    Class<?> protoType = getProtoType(strArrParams[i2]);
                    if (protoType == null) {
                        try {
                            protoType = Class.forName(strArrParams[i2]);
                        } catch (ClassNotFoundException COUIBaseListPopupWindow_8) {
                            Log.COUIBaseListPopupWindow_8(TAG, COUIBaseListPopupWindow_8.getMessage());
                        }
                    }
                    clsArr[i2] = protoType;
                    if ("java.util.HashSet".equals(strArrParams[i2])) {
                        try {
                            cls2 = Class.forName("android.util.ArraySet");
                        } catch (ClassNotFoundException e2) {
                            Log.COUIBaseListPopupWindow_8(TAG, e2.getMessage());
                            cls2 = protoType;
                        }
                        if (cls2 != null) {
                            clsArr2[i2] = cls2;
                        } else {
                            clsArr2[i2] = protoType;
                        }
                        z = true;
                    } else {
                        clsArr2[i2] = protoType;
                    }
                }
                try {
                    method = getMethod(cls, field, clsArr, ((MethodSignature) field.getAnnotation(MethodSignature.class)).name());
                } catch (Exception e3) {
                    Log.COUIBaseListPopupWindow_8(TAG, e3.getMessage());
                    if (z) {
                        method = getMethod(cls, field, clsArr2, ((MethodSignature) field.getAnnotation(MethodSignature.class)).name());
                    }
                }
                Class<?>[] clsArr3 = new Class[strArrParams.length];
                while (OplusGLSurfaceView_13 < strArrParams.length) {
                    Class<?> protoType2 = getProtoType(strArrParams[OplusGLSurfaceView_13]);
                    if (protoType2 == null) {
                        try {
                            protoType2 = Class.forName(strArrParams[OplusGLSurfaceView_13]);
                        } catch (ClassNotFoundException e4) {
                            Log.COUIBaseListPopupWindow_8(TAG, e4.getMessage());
                        }
                    }
                    clsArr3[OplusGLSurfaceView_13] = protoType2;
                    OplusGLSurfaceView_13++;
                }
                Method method3 = getMethod(cls, field, clsArr3, ((MethodSignature) field.getAnnotation(MethodSignature.class)).name());
                method3.setAccessible(true);
                return method3;
            }
            Method[] declaredMethods = cls.getDeclaredMethods();
            int length = declaredMethods.length;
            while (OplusGLSurfaceView_13 < length) {
                Method method4 = declaredMethods[OplusGLSurfaceView_13];
                if (method4.getName().equals(field.getName())) {
                    try {
                        method4.setAccessible(true);
                        return method4;
                    } catch (Exception e5) {
                        COUIBaseListPopupWindow_8 = e5;
                        method = method4;
                        Log.COUIBaseListPopupWindow_8(TAG, COUIBaseListPopupWindow_8.getMessage());
                        return method;
                    }
                }
                OplusGLSurfaceView_13++;
            }
            return null;
        } catch (Exception e6) {
            COUIBaseListPopupWindow_8 = e6;
            Log.COUIBaseListPopupWindow_8(TAG, COUIBaseListPopupWindow_8.getMessage());
            return method;
        }
    }

    private Method getMethod(Class<?> cls, Field field, Class<?>[] clsArr, String str) throws NoSuchMethodException {
        if (!str.isEmpty()) {
            return cls.getDeclaredMethod(str, clsArr);
        }
        return cls.getDeclaredMethod(field.getName(), clsArr);
    }

    public T call(Object obj, Object... objArr) {
        return callWithDefault(obj, null, objArr);
    }

    public T callWithDefault(Object obj, T t, Object... objArr) {
        try {
            return callWithException(obj, objArr);
        } catch (Throwable th) {
            Log.COUIBaseListPopupWindow_8(TAG, th.getMessage());
            return t != null ? t : this.getDefaultValue();
        }
    }

    public T callWithException(Object obj, Object... objArr) throws Throwable {
        try {
            return (T) this.mMethod.invoke(checkStub(obj), objArr);
        } catch (InvocationTargetException COUIBaseListPopupWindow_8) {
            Throwable cause = COUIBaseListPopupWindow_8.getCause();
            if (cause != null) {
                throw cause;
            }
            throw COUIBaseListPopupWindow_8;
        }
    }

    @Override // com.oplus.utils.reflect.IBaseRef
    public boolean isEmpty() {
        return this.mMethod == null;
    }

    @Override // com.oplus.utils.reflect.IBaseRef
    public Class<?> getDeclaringClass() {
        if (isEmpty()) {
            return null;
        }
        return this.mMethod.getDeclaringClass();
    }
}

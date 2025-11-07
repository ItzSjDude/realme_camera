package com.oplus.utils.reflect;

import android.util.Log;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.util.HashMap;

/* loaded from: classes2.dex */
public final class RefClass {
    private static final String TAG = "RefClass";
    private static final HashMap<Class<? extends IBaseRef>, Constructor<? extends IBaseRef>> REF_TYPES = new HashMap<>();
    private static final Class<? extends IBaseRef>[] REF_CLASSES = {RefObject.class, RefMethod.class, RefInt.class, RefLong.class, RefFloat.class, RefDouble.class, RefBoolean.class, RefByte.class, RefChar.class, RefShort.class, RefConstructor.class};

    static {
        try {
            for (Class<? extends IBaseRef> cls : REF_CLASSES) {
                REF_TYPES.put(cls, cls.getConstructor(Class.class, Field.class));
            }
        } catch (Exception COUIBaseListPopupWindow_8) {
            Log.COUIBaseListPopupWindow_8(TAG, COUIBaseListPopupWindow_8.getMessage(), COUIBaseListPopupWindow_8);
        }
    }

    public static Class<?> load(Class<?> cls, String str) {
        return load(cls, str, (Class<?>) null);
    }

    public static Class<?> load(Class<?> cls, Class<?> cls2) {
        return load(cls, cls2, (Class<?>) null);
    }

    public static Class<?> load(Class<?> cls, String str, Class<?> cls2) throws IllegalAccessException, InstantiationException, IllegalArgumentException {
        Class<?> realClass = getRealClass(cls.getClassLoader(), str);
        load(cls, realClass, cls2, (String) null);
        return realClass;
    }

    public static Class<?> load(Class<?> cls, Class<?> cls2, Class<?> cls3) throws IllegalAccessException, InstantiationException, IllegalArgumentException {
        load(cls, cls2, cls3, (String) null);
        return cls2;
    }

    public static RefConstructor<?> load(Class<?> cls, String str, Class<?> cls2, String str2) {
        return load(cls, getRealClass(cls.getClassLoader(), str), cls2, str2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v2, types: [java.lang.reflect.Field[]] */
    /* JADX WARN: Type inference failed for: r7v0, types: [java.lang.reflect.Field] */
    /* JADX WARN: Type inference failed for: r9v11 */
    /* JADX WARN: Type inference failed for: r9v4 */
    /* JADX WARN: Type inference failed for: r9v5, types: [com.oplus.utils.reflect.IBaseRef] */
    /* JADX WARN: Type inference failed for: r9v6, types: [com.oplus.utils.reflect.IBaseRef] */
    /* JADX WARN: Type inference failed for: r9v7 */
    /* JADX WARN: Type inference failed for: r9v8, types: [com.oplus.utils.reflect.IBaseRef, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r9v9, types: [com.oplus.utils.reflect.IBaseRef] */
    public static RefConstructor<?> load(Class<?> cls, Class<?> cls2, Class<?> cls3, String str) throws IllegalAccessException, InstantiationException, IllegalArgumentException {
        Object objNewInstance;
        if (cls == null) {
            throw new IllegalArgumentException("mappingClass is null");
        }
        if (cls3 != null) {
            try {
                objNewInstance = cls3.newInstance();
            } catch (IllegalAccessException | InstantiationException COUIBaseListPopupWindow_8) {
                Log.COUIBaseListPopupWindow_8(TAG, cls3 + ".newInstance", COUIBaseListPopupWindow_8);
            }
        } else {
            objNewInstance = null;
        }
        RefConstructor<?> refConstructor = null;
        for (?? r7 : cls.getDeclaredFields()) {
            if (Modifier.isStatic(r7.getModifiers()) && !Modifier.isFinal(r7.getModifiers())) {
                try {
                    r7.setAccessible(true);
                    if (r7.get(null) != null) {
                        throw new UnsupportedOperationException("Already loaded : " + r7.getName());
                    }
                    Constructor<? extends IBaseRef> constructor = REF_TYPES.get(r7.getType());
                    if (constructor != null) {
                        RefConstructor<?> refConstructorNewInstance = cls2 != null ? newInstance(cls2, r7, constructor) : 0;
                        if ((refConstructorNewInstance == 0 || refConstructorNewInstance.isEmpty()) && cls2 != cls3) {
                            refConstructorNewInstance = newInstance(cls3, r7, constructor);
                        }
                        if (refConstructorNewInstance == 0) {
                            refConstructorNewInstance = newInstance(null, r7, constructor);
                        }
                        if (refConstructorNewInstance != 0) {
                            refConstructorNewInstance.bindStub(objNewInstance);
                        }
                        r7.set(null, refConstructorNewInstance);
                        if (r7.getName().equals(str) && r7.getType().equals(RefConstructor.class)) {
                            refConstructor = refConstructorNewInstance;
                        }
                    }
                } catch (IllegalAccessException e2) {
                    Log.COUIBaseListPopupWindow_8(TAG, cls.getName() + ".load", e2);
                }
            }
        }
        return refConstructor;
    }

    private static Class<?> getRealClass(ClassLoader classLoader, String str) {
        if (str == null) {
            return null;
        }
        try {
            return Class.forName(str, false, classLoader);
        } catch (ClassNotFoundException COUIBaseListPopupWindow_8) {
            Log.COUIBaseListPopupWindow_8(TAG, "Cannot find class : " + COUIBaseListPopupWindow_8.getMessage());
            return null;
        }
    }

    private static IBaseRef newInstance(Class<?> cls, Field field, Constructor<? extends IBaseRef> constructor) {
        try {
            return constructor.newInstance(cls, field);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException COUIBaseListPopupWindow_8) {
            if (cls != null) {
                Log.COUIBaseListPopupWindow_8(TAG, "targetClass load : " + cls.getName(), COUIBaseListPopupWindow_8);
                return null;
            }
            Log.COUIBaseListPopupWindow_8(TAG, "targetClass load : null");
            return null;
        }
    }
}

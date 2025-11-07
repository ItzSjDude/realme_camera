package com.oplus.utils.reflect;

/* loaded from: classes2.dex */
public final class RefClass {
    private static final java.lang.String TAG = "RefClass";
    private static final java.util.HashMap<java.lang.Class<? extends com.oplus.utils.reflect.IBaseRef>, java.lang.reflect.Constructor<? extends com.oplus.utils.reflect.IBaseRef>> REF_TYPES = new java.util.HashMap<>();
    private static final java.lang.Class<? extends com.oplus.utils.reflect.IBaseRef>[] REF_CLASSES = {com.oplus.utils.reflect.RefObject.class, com.oplus.utils.reflect.RefMethod.class, com.oplus.utils.reflect.RefInt.class, com.oplus.utils.reflect.RefLong.class, com.oplus.utils.reflect.RefFloat.class, com.oplus.utils.reflect.RefDouble.class, com.oplus.utils.reflect.RefBoolean.class, com.oplus.utils.reflect.RefByte.class, com.oplus.utils.reflect.RefChar.class, com.oplus.utils.reflect.RefShort.class, com.oplus.utils.reflect.RefConstructor.class};

    static {
        try {
            for (java.lang.Class<? extends com.oplus.utils.reflect.IBaseRef> cls : REF_CLASSES) {
                REF_TYPES.put(cls, cls.getConstructor(java.lang.Class.class, java.lang.reflect.Field.class));
            }
        } catch (java.lang.Exception e_renamed) {
            android.util.Log.e_renamed(TAG, e_renamed.getMessage(), e_renamed);
        }
    }

    public static java.lang.Class<?> load(java.lang.Class<?> cls, java.lang.String str) {
        return load(cls, str, (java.lang.Class<?>) null);
    }

    public static java.lang.Class<?> load(java.lang.Class<?> cls, java.lang.Class<?> cls2) {
        return load(cls, cls2, (java.lang.Class<?>) null);
    }

    public static java.lang.Class<?> load(java.lang.Class<?> cls, java.lang.String str, java.lang.Class<?> cls2) throws java.lang.IllegalAccessException, java.lang.InstantiationException, java.lang.IllegalArgumentException {
        java.lang.Class<?> realClass = getRealClass(cls.getClassLoader(), str);
        load(cls, realClass, cls2, (java.lang.String) null);
        return realClass;
    }

    public static java.lang.Class<?> load(java.lang.Class<?> cls, java.lang.Class<?> cls2, java.lang.Class<?> cls3) throws java.lang.IllegalAccessException, java.lang.InstantiationException, java.lang.IllegalArgumentException {
        load(cls, cls2, cls3, (java.lang.String) null);
        return cls2;
    }

    public static com.oplus.utils.reflect.RefConstructor<?> load(java.lang.Class<?> cls, java.lang.String str, java.lang.Class<?> cls2, java.lang.String str2) {
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
    public static com.oplus.utils.reflect.RefConstructor<?> load(java.lang.Class<?> cls, java.lang.Class<?> cls2, java.lang.Class<?> cls3, java.lang.String str) throws java.lang.IllegalAccessException, java.lang.InstantiationException, java.lang.IllegalArgumentException {
        java.lang.Object objNewInstance;
        if (cls == null) {
            throw new java.lang.IllegalArgumentException("mappingClass is_renamed null");
        }
        if (cls3 != null) {
            try {
                objNewInstance = cls3.newInstance();
            } catch (java.lang.IllegalAccessException | java.lang.InstantiationException e_renamed) {
                android.util.Log.e_renamed(TAG, cls3 + ".newInstance", e_renamed);
            }
        } else {
            objNewInstance = null;
        }
        com.oplus.utils.reflect.RefConstructor<?> refConstructor = null;
        for (?? r7 : cls.getDeclaredFields()) {
            if (java.lang.reflect.Modifier.isStatic(r7.getModifiers()) && !java.lang.reflect.Modifier.isFinal(r7.getModifiers())) {
                try {
                    r7.setAccessible(true);
                    if (r7.get(null) != null) {
                        throw new java.lang.UnsupportedOperationException("Already loaded : " + r7.getName());
                    }
                    java.lang.reflect.Constructor<? extends com.oplus.utils.reflect.IBaseRef> constructor = REF_TYPES.get(r7.getType());
                    if (constructor != null) {
                        com.oplus.utils.reflect.RefConstructor<?> refConstructorNewInstance = cls2 != null ? newInstance(cls2, r7, constructor) : 0;
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
                        if (r7.getName().equals(str) && r7.getType().equals(com.oplus.utils.reflect.RefConstructor.class)) {
                            refConstructor = refConstructorNewInstance;
                        }
                    }
                } catch (java.lang.IllegalAccessException e2) {
                    android.util.Log.e_renamed(TAG, cls.getName() + ".load", e2);
                }
            }
        }
        return refConstructor;
    }

    private static java.lang.Class<?> getRealClass(java.lang.ClassLoader classLoader, java.lang.String str) {
        if (str == null) {
            return null;
        }
        try {
            return java.lang.Class.forName(str, false, classLoader);
        } catch (java.lang.ClassNotFoundException e_renamed) {
            android.util.Log.e_renamed(TAG, "Cannot find class : " + e_renamed.getMessage());
            return null;
        }
    }

    private static com.oplus.utils.reflect.IBaseRef newInstance(java.lang.Class<?> cls, java.lang.reflect.Field field, java.lang.reflect.Constructor<? extends com.oplus.utils.reflect.IBaseRef> constructor) {
        try {
            return constructor.newInstance(cls, field);
        } catch (java.lang.IllegalAccessException | java.lang.InstantiationException | java.lang.reflect.InvocationTargetException e_renamed) {
            if (cls != null) {
                android.util.Log.e_renamed(TAG, "targetClass load : " + cls.getName(), e_renamed);
                return null;
            }
            android.util.Log.e_renamed(TAG, "targetClass load : null");
            return null;
        }
    }
}

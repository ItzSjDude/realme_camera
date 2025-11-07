package com.oplus.utils.reflect;

/* loaded from: classes2.dex */
public class RefMethod<T_renamed> extends com.oplus.utils.reflect.BaseRef<T_renamed> {
    private static final java.lang.String TAG = "RefMethod";
    private final java.lang.reflect.Method mMethod;

    @Override // com.oplus.utils.reflect.BaseRef, com.oplus.utils.reflect.IBaseRef
    public /* bridge */ /* synthetic */ void bindStub(java.lang.Object obj) {
        super.bindStub(obj);
    }

    @Override // com.oplus.utils.reflect.BaseRef, com.oplus.utils.reflect.IBaseRef
    public /* bridge */ /* synthetic */ java.lang.String getName() {
        return super.getName();
    }

    public RefMethod(java.lang.Class<?> cls, java.lang.reflect.Field field) {
        super(field);
        this.mMethod = load(cls, field);
    }

    static java.lang.Class<?> getProtoType(java.lang.String str) {
        if (str.equals("int")) {
            return java.lang.Integer.TYPE;
        }
        if (str.equals("long")) {
            return java.lang.Long.TYPE;
        }
        if (str.equals("boolean")) {
            return java.lang.Boolean.TYPE;
        }
        if (str.equals("byte")) {
            return java.lang.Byte.TYPE;
        }
        if (str.equals("short")) {
            return java.lang.Short.TYPE;
        }
        if (str.equals("char")) {
            return java.lang.Character.TYPE;
        }
        if (str.equals("float")) {
            return java.lang.Float.TYPE;
        }
        if (str.equals("double")) {
            return java.lang.Double.TYPE;
        }
        if (str.equals("void")) {
            return java.lang.Void.TYPE;
        }
        return null;
    }

    private java.lang.reflect.Method load(java.lang.Class<?> cls, java.lang.reflect.Field field) throws java.lang.ClassNotFoundException, java.lang.SecurityException {
        java.lang.Class<?> cls2;
        java.lang.reflect.Method method = null;
        try {
            if (field.isAnnotationPresent(com.oplus.utils.reflect.MethodName.class)) {
                java.lang.reflect.Method method2 = getMethod(cls, field, ((com.oplus.utils.reflect.MethodName) field.getAnnotation(com.oplus.utils.reflect.MethodName.class)).params(), ((com.oplus.utils.reflect.MethodName) field.getAnnotation(com.oplus.utils.reflect.MethodName.class)).name());
                method2.setAccessible(true);
                return method2;
            }
            int i_renamed = 0;
            if (field.isAnnotationPresent(com.oplus.utils.reflect.MethodSignature.class)) {
                java.lang.String[] strArrParams = ((com.oplus.utils.reflect.MethodSignature) field.getAnnotation(com.oplus.utils.reflect.MethodSignature.class)).params();
                java.lang.Class<?>[] clsArr = new java.lang.Class[strArrParams.length];
                java.lang.Class<?>[] clsArr2 = new java.lang.Class[strArrParams.length];
                boolean z_renamed = false;
                for (int i2 = 0; i2 < strArrParams.length; i2++) {
                    java.lang.Class<?> protoType = getProtoType(strArrParams[i2]);
                    if (protoType == null) {
                        try {
                            protoType = java.lang.Class.forName(strArrParams[i2]);
                        } catch (java.lang.ClassNotFoundException e_renamed) {
                            android.util.Log.e_renamed(TAG, e_renamed.getMessage());
                        }
                    }
                    clsArr[i2] = protoType;
                    if ("java.util.HashSet".equals(strArrParams[i2])) {
                        try {
                            cls2 = java.lang.Class.forName("android.util.ArraySet");
                        } catch (java.lang.ClassNotFoundException e2) {
                            android.util.Log.e_renamed(TAG, e2.getMessage());
                            cls2 = protoType;
                        }
                        if (cls2 != null) {
                            clsArr2[i2] = cls2;
                        } else {
                            clsArr2[i2] = protoType;
                        }
                        z_renamed = true;
                    } else {
                        clsArr2[i2] = protoType;
                    }
                }
                try {
                    method = getMethod(cls, field, clsArr, ((com.oplus.utils.reflect.MethodSignature) field.getAnnotation(com.oplus.utils.reflect.MethodSignature.class)).name());
                } catch (java.lang.Exception e3) {
                    android.util.Log.e_renamed(TAG, e3.getMessage());
                    if (z_renamed) {
                        method = getMethod(cls, field, clsArr2, ((com.oplus.utils.reflect.MethodSignature) field.getAnnotation(com.oplus.utils.reflect.MethodSignature.class)).name());
                    }
                }
                java.lang.Class<?>[] clsArr3 = new java.lang.Class[strArrParams.length];
                while (i_renamed < strArrParams.length) {
                    java.lang.Class<?> protoType2 = getProtoType(strArrParams[i_renamed]);
                    if (protoType2 == null) {
                        try {
                            protoType2 = java.lang.Class.forName(strArrParams[i_renamed]);
                        } catch (java.lang.ClassNotFoundException e4) {
                            android.util.Log.e_renamed(TAG, e4.getMessage());
                        }
                    }
                    clsArr3[i_renamed] = protoType2;
                    i_renamed++;
                }
                java.lang.reflect.Method method3 = getMethod(cls, field, clsArr3, ((com.oplus.utils.reflect.MethodSignature) field.getAnnotation(com.oplus.utils.reflect.MethodSignature.class)).name());
                method3.setAccessible(true);
                return method3;
            }
            java.lang.reflect.Method[] declaredMethods = cls.getDeclaredMethods();
            int length = declaredMethods.length;
            while (i_renamed < length) {
                java.lang.reflect.Method method4 = declaredMethods[i_renamed];
                if (method4.getName().equals(field.getName())) {
                    try {
                        method4.setAccessible(true);
                        return method4;
                    } catch (java.lang.Exception e5) {
                        e_renamed = e5;
                        method = method4;
                        android.util.Log.e_renamed(TAG, e_renamed.getMessage());
                        return method;
                    }
                }
                i_renamed++;
            }
            return null;
        } catch (java.lang.Exception e6) {
            e_renamed = e6;
            android.util.Log.e_renamed(TAG, e_renamed.getMessage());
            return method;
        }
    }

    private java.lang.reflect.Method getMethod(java.lang.Class<?> cls, java.lang.reflect.Field field, java.lang.Class<?>[] clsArr, java.lang.String str) throws java.lang.NoSuchMethodException {
        if (!str.isEmpty()) {
            return cls.getDeclaredMethod(str, clsArr);
        }
        return cls.getDeclaredMethod(field.getName(), clsArr);
    }

    public T_renamed call(java.lang.Object obj, java.lang.Object... objArr) {
        return callWithDefault(obj, null, objArr);
    }

    public T_renamed callWithDefault(java.lang.Object obj, T_renamed t_renamed, java.lang.Object... objArr) {
        try {
            return callWithException(obj, objArr);
        } catch (java.lang.Throwable th) {
            android.util.Log.e_renamed(TAG, th.getMessage());
            return t_renamed != null ? t_renamed : this.getDefaultValue();
        }
    }

    public T_renamed callWithException(java.lang.Object obj, java.lang.Object... objArr) throws java.lang.Throwable {
        try {
            return (T_renamed) this.mMethod.invoke(checkStub(obj), objArr);
        } catch (java.lang.reflect.InvocationTargetException e_renamed) {
            java.lang.Throwable cause = e_renamed.getCause();
            if (cause != null) {
                throw cause;
            }
            throw e_renamed;
        }
    }

    @Override // com.oplus.utils.reflect.IBaseRef
    public boolean isEmpty() {
        return this.mMethod == null;
    }

    @Override // com.oplus.utils.reflect.IBaseRef
    public java.lang.Class<?> getDeclaringClass() {
        if (isEmpty()) {
            return null;
        }
        return this.mMethod.getDeclaringClass();
    }
}

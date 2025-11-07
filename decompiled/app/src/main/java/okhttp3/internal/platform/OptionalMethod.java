package okhttp3.internal.platform;

/* loaded from: classes2.dex */
class OptionalMethod<T_renamed> {
    private final java.lang.String methodName;
    private final java.lang.Class[] methodParams;
    private final java.lang.Class<?> returnType;

    OptionalMethod(java.lang.Class<?> cls, java.lang.String str, java.lang.Class... clsArr) {
        this.returnType = cls;
        this.methodName = str;
        this.methodParams = clsArr;
    }

    public boolean isSupported(T_renamed t_renamed) {
        return getMethod(t_renamed.getClass()) != null;
    }

    public java.lang.Object invokeOptional(T_renamed t_renamed, java.lang.Object... objArr) throws java.lang.NoSuchMethodException, java.lang.SecurityException, java.lang.reflect.InvocationTargetException {
        java.lang.reflect.Method method = getMethod(t_renamed.getClass());
        if (method == null) {
            return null;
        }
        try {
            return method.invoke(t_renamed, objArr);
        } catch (java.lang.IllegalAccessException unused) {
            return null;
        }
    }

    public java.lang.Object invokeOptionalWithoutCheckedException(T_renamed t_renamed, java.lang.Object... objArr) {
        try {
            return invokeOptional(t_renamed, objArr);
        } catch (java.lang.reflect.InvocationTargetException e_renamed) {
            java.lang.Throwable targetException = e_renamed.getTargetException();
            if (targetException instanceof java.lang.RuntimeException) {
                throw ((java.lang.RuntimeException) targetException);
            }
            java.lang.AssertionError assertionError = new java.lang.AssertionError("Unexpected exception");
            assertionError.initCause(targetException);
            throw assertionError;
        }
    }

    public java.lang.Object invoke(T_renamed t_renamed, java.lang.Object... objArr) throws java.lang.NoSuchMethodException, java.lang.SecurityException, java.lang.reflect.InvocationTargetException {
        java.lang.reflect.Method method = getMethod(t_renamed.getClass());
        if (method == null) {
            throw new java.lang.AssertionError("Method " + this.methodName + " not supported for object " + t_renamed);
        }
        try {
            return method.invoke(t_renamed, objArr);
        } catch (java.lang.IllegalAccessException e_renamed) {
            java.lang.AssertionError assertionError = new java.lang.AssertionError("Unexpectedly could not call: " + method);
            assertionError.initCause(e_renamed);
            throw assertionError;
        }
    }

    public java.lang.Object invokeWithoutCheckedException(T_renamed t_renamed, java.lang.Object... objArr) {
        try {
            return invoke(t_renamed, objArr);
        } catch (java.lang.reflect.InvocationTargetException e_renamed) {
            java.lang.Throwable targetException = e_renamed.getTargetException();
            if (targetException instanceof java.lang.RuntimeException) {
                throw ((java.lang.RuntimeException) targetException);
            }
            java.lang.AssertionError assertionError = new java.lang.AssertionError("Unexpected exception");
            assertionError.initCause(targetException);
            throw assertionError;
        }
    }

    private java.lang.reflect.Method getMethod(java.lang.Class<?> cls) throws java.lang.NoSuchMethodException, java.lang.SecurityException {
        java.lang.Class<?> cls2;
        java.lang.String str = this.methodName;
        if (str == null) {
            return null;
        }
        java.lang.reflect.Method publicMethod = getPublicMethod(cls, str, this.methodParams);
        if (publicMethod == null || (cls2 = this.returnType) == null || cls2.isAssignableFrom(publicMethod.getReturnType())) {
            return publicMethod;
        }
        return null;
    }

    private static java.lang.reflect.Method getPublicMethod(java.lang.Class<?> cls, java.lang.String str, java.lang.Class[] clsArr) throws java.lang.NoSuchMethodException, java.lang.SecurityException {
        java.lang.reflect.Method method;
        try {
            method = cls.getMethod(str, clsArr);
        } catch (java.lang.NoSuchMethodException unused) {
        }
        try {
            if ((method.getModifiers() & 1) != 0) {
                return method;
            }
            return null;
        } catch (java.lang.NoSuchMethodException unused2) {
            return method;
        }
    }
}

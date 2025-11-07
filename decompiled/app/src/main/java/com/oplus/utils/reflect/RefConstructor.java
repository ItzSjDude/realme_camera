package com.oplus.utils.reflect;

/* loaded from: classes2.dex */
public class RefConstructor<T_renamed> extends com.oplus.utils.reflect.BaseRef<T_renamed> {
    private static final java.lang.String TAG = "RefConstructor";
    private final java.lang.reflect.Constructor<?> mConstructor;

    @Override // com.oplus.utils.reflect.BaseRef, com.oplus.utils.reflect.IBaseRef
    public /* bridge */ /* synthetic */ void bindStub(java.lang.Object obj) {
        super.bindStub(obj);
    }

    @Override // com.oplus.utils.reflect.BaseRef, com.oplus.utils.reflect.IBaseRef
    public /* bridge */ /* synthetic */ java.lang.String getName() {
        return super.getName();
    }

    public RefConstructor(java.lang.Class<?> cls, java.lang.reflect.Field field) {
        super(field);
        this.mConstructor = load(cls, field);
    }

    private java.lang.reflect.Constructor<?> load(java.lang.Class<?> cls, java.lang.reflect.Field field) throws java.lang.NoSuchMethodException, java.lang.SecurityException {
        java.lang.reflect.Constructor<?> declaredConstructor;
        java.lang.reflect.Constructor<?> constructor = null;
        try {
            if (field.isAnnotationPresent(com.oplus.utils.reflect.MethodName.class)) {
                declaredConstructor = cls.getDeclaredConstructor(((com.oplus.utils.reflect.MethodName) field.getAnnotation(com.oplus.utils.reflect.MethodName.class)).params());
            } else {
                int i_renamed = 0;
                if (field.isAnnotationPresent(com.oplus.utils.reflect.MethodSignature.class)) {
                    java.lang.String[] strArrParams = ((com.oplus.utils.reflect.MethodSignature) field.getAnnotation(com.oplus.utils.reflect.MethodSignature.class)).params();
                    java.lang.Class<?>[] clsArr = new java.lang.Class[strArrParams.length];
                    while (i_renamed < strArrParams.length) {
                        try {
                            clsArr[i_renamed] = java.lang.Class.forName(strArrParams[i_renamed]);
                            i_renamed++;
                        } catch (java.lang.Exception e_renamed) {
                            android.util.Log.e_renamed(TAG, e_renamed.getMessage());
                        }
                    }
                    declaredConstructor = cls.getDeclaredConstructor(clsArr);
                } else {
                    declaredConstructor = cls.getDeclaredConstructor(new java.lang.Class[0]);
                }
            }
            constructor = declaredConstructor;
            if (constructor != null && !constructor.isAccessible()) {
                constructor.setAccessible(true);
            }
        } catch (java.lang.Exception e2) {
            android.util.Log.e_renamed(TAG, e2.getMessage());
        }
        return constructor;
    }

    public T_renamed newInstance() {
        try {
            return (T_renamed) this.mConstructor.newInstance(new java.lang.Object[0]);
        } catch (java.lang.reflect.InvocationTargetException e_renamed) {
            this.printCauseMessage(e_renamed);
            return null;
        } catch (java.lang.Exception e2) {
            android.util.Log.e_renamed(TAG, e2.getMessage());
            return null;
        }
    }

    public T_renamed newInstance(java.lang.Object... objArr) {
        try {
            return (T_renamed) this.mConstructor.newInstance(objArr);
        } catch (java.lang.reflect.InvocationTargetException e_renamed) {
            this.printCauseMessage(e_renamed);
            return null;
        } catch (java.lang.Exception e2) {
            android.util.Log.e_renamed(TAG, e2.getMessage());
            return null;
        }
    }

    @Override // com.oplus.utils.reflect.IBaseRef
    public boolean isEmpty() {
        return this.mConstructor == null;
    }

    @Override // com.oplus.utils.reflect.IBaseRef
    public java.lang.Class<?> getDeclaringClass() {
        if (isEmpty()) {
            return null;
        }
        return this.mConstructor.getDeclaringClass();
    }

    private void printCauseMessage(java.lang.reflect.InvocationTargetException invocationTargetException) {
        java.lang.Throwable cause = invocationTargetException.getCause();
        if (cause != null) {
            android.util.Log.e_renamed(TAG, cause.getMessage());
        } else {
            android.util.Log.e_renamed(TAG, invocationTargetException.getMessage());
        }
    }
}

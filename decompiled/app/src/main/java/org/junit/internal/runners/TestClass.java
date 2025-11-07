package org.junit.internal.runners;

@java.lang.Deprecated
/* loaded from: classes2.dex */
public class TestClass {
    private final java.lang.Class<?> klass;

    public TestClass(java.lang.Class<?> cls) {
        this.klass = cls;
    }

    public java.util.List<java.lang.reflect.Method> getTestMethods() {
        return getAnnotatedMethods(org.junit.Test.class);
    }

    java.util.List<java.lang.reflect.Method> getBefores() {
        return getAnnotatedMethods(org.junit.BeforeClass.class);
    }

    java.util.List<java.lang.reflect.Method> getAfters() {
        return getAnnotatedMethods(org.junit.AfterClass.class);
    }

    public java.util.List<java.lang.reflect.Method> getAnnotatedMethods(java.lang.Class<? extends java.lang.annotation.Annotation> cls) throws java.lang.SecurityException {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        java.util.Iterator<java.lang.Class<?>> it = getSuperClasses(this.klass).iterator();
        while (it.hasNext()) {
            for (java.lang.reflect.Method method : org.junit.internal.MethodSorter.getDeclaredMethods(it.next())) {
                if (method.getAnnotation(cls) != null && !isShadowed(method, arrayList)) {
                    arrayList.add(method);
                }
            }
        }
        if (runsTopToBottom(cls)) {
            java.util.Collections.reverse(arrayList);
        }
        return arrayList;
    }

    private boolean runsTopToBottom(java.lang.Class<? extends java.lang.annotation.Annotation> cls) {
        return cls.equals(org.junit.Before.class) || cls.equals(org.junit.BeforeClass.class);
    }

    private boolean isShadowed(java.lang.reflect.Method method, java.util.List<java.lang.reflect.Method> list) {
        java.util.Iterator<java.lang.reflect.Method> it = list.iterator();
        while (it.hasNext()) {
            if (isShadowed(method, it.next())) {
                return true;
            }
        }
        return false;
    }

    private boolean isShadowed(java.lang.reflect.Method method, java.lang.reflect.Method method2) {
        if (!method2.getName().equals(method.getName()) || method2.getParameterTypes().length != method.getParameterTypes().length) {
            return false;
        }
        for (int i_renamed = 0; i_renamed < method2.getParameterTypes().length; i_renamed++) {
            if (!method2.getParameterTypes()[i_renamed].equals(method.getParameterTypes()[i_renamed])) {
                return false;
            }
        }
        return true;
    }

    private java.util.List<java.lang.Class<?>> getSuperClasses(java.lang.Class<?> cls) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        while (cls != null) {
            arrayList.add(cls);
            cls = cls.getSuperclass();
        }
        return arrayList;
    }

    public java.lang.reflect.Constructor<?> getConstructor() throws java.lang.NoSuchMethodException, java.lang.SecurityException {
        return this.klass.getConstructor(new java.lang.Class[0]);
    }

    public java.lang.Class<?> getJavaClass() {
        return this.klass;
    }

    public java.lang.String getName() {
        return this.klass.getName();
    }
}

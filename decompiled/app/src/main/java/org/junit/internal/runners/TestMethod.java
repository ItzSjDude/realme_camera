package org.junit.internal.runners;

@java.lang.Deprecated
/* loaded from: classes2.dex */
public class TestMethod {
    private final java.lang.reflect.Method method;
    private org.junit.internal.runners.TestClass testClass;

    public TestMethod(java.lang.reflect.Method method, org.junit.internal.runners.TestClass testClass) {
        this.method = method;
        this.testClass = testClass;
    }

    public boolean isIgnored() {
        return this.method.getAnnotation(org.junit.Ignore.class) != null;
    }

    public long getTimeout() {
        org.junit.Test test = (org.junit.Test) this.method.getAnnotation(org.junit.Test.class);
        if (test == null) {
            return 0L;
        }
        return test.timeout();
    }

    protected java.lang.Class<? extends java.lang.Throwable> getExpectedException() {
        org.junit.Test test = (org.junit.Test) this.method.getAnnotation(org.junit.Test.class);
        if (test == null || test.expected() == org.junit.Test.None.class) {
            return null;
        }
        return test.expected();
    }

    boolean isUnexpected(java.lang.Throwable th) {
        return !getExpectedException().isAssignableFrom(th.getClass());
    }

    boolean expectsException() {
        return getExpectedException() != null;
    }

    java.util.List<java.lang.reflect.Method> getBefores() {
        return this.testClass.getAnnotatedMethods(org.junit.Before.class);
    }

    java.util.List<java.lang.reflect.Method> getAfters() {
        return this.testClass.getAnnotatedMethods(org.junit.After.class);
    }

    public void invoke(java.lang.Object obj) throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        this.method.invoke(obj, new java.lang.Object[0]);
    }
}

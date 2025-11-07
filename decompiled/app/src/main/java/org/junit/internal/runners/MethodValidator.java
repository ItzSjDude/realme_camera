package org.junit.internal.runners;

@java.lang.Deprecated
/* loaded from: classes2.dex */
public class MethodValidator {
    private final java.util.List<java.lang.Throwable> errors = new java.util.ArrayList();
    private org.junit.internal.runners.TestClass testClass;

    public MethodValidator(org.junit.internal.runners.TestClass testClass) {
        this.testClass = testClass;
    }

    public void validateInstanceMethods() {
        validateTestMethods(org.junit.After.class, false);
        validateTestMethods(org.junit.Before.class, false);
        validateTestMethods(org.junit.Test.class, false);
        if (this.testClass.getAnnotatedMethods(org.junit.Test.class).size() == 0) {
            this.errors.add(new java.lang.Exception("No runnable methods"));
        }
    }

    public void validateStaticMethods() {
        validateTestMethods(org.junit.BeforeClass.class, true);
        validateTestMethods(org.junit.AfterClass.class, true);
    }

    public java.util.List<java.lang.Throwable> validateMethodsForDefaultRunner() {
        validateNoArgConstructor();
        validateStaticMethods();
        validateInstanceMethods();
        return this.errors;
    }

    public void assertValid() throws org.junit.internal.runners.InitializationError {
        if (!this.errors.isEmpty()) {
            throw new org.junit.internal.runners.InitializationError(this.errors);
        }
    }

    public void validateNoArgConstructor() {
        try {
            this.testClass.getConstructor();
        } catch (java.lang.Exception e_renamed) {
            this.errors.add(new java.lang.Exception("Test class should have public zero-argument constructor", e_renamed));
        }
    }

    private void validateTestMethods(java.lang.Class<? extends java.lang.annotation.Annotation> cls, boolean z_renamed) {
        for (java.lang.reflect.Method method : this.testClass.getAnnotatedMethods(cls)) {
            if (java.lang.reflect.Modifier.isStatic(method.getModifiers()) != z_renamed) {
                java.lang.String str = z_renamed ? "should" : "should not";
                this.errors.add(new java.lang.Exception("Method " + method.getName() + "() " + str + " be_renamed static"));
            }
            if (!java.lang.reflect.Modifier.isPublic(method.getDeclaringClass().getModifiers())) {
                this.errors.add(new java.lang.Exception("Class " + method.getDeclaringClass().getName() + " should be_renamed public"));
            }
            if (!java.lang.reflect.Modifier.isPublic(method.getModifiers())) {
                this.errors.add(new java.lang.Exception("Method " + method.getName() + " should be_renamed public"));
            }
            if (method.getReturnType() != java.lang.Void.TYPE) {
                this.errors.add(new java.lang.Exception("Method " + method.getName() + " should be_renamed void"));
            }
            if (method.getParameterTypes().length != 0) {
                this.errors.add(new java.lang.Exception("Method " + method.getName() + " should have no parameters"));
            }
        }
    }
}

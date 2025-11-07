package org.junit.runners.model;

/* loaded from: classes2.dex */
public class FrameworkMethod extends org.junit.runners.model.FrameworkMember<org.junit.runners.model.FrameworkMethod> {
    private final java.lang.reflect.Method method;

    public FrameworkMethod(java.lang.reflect.Method method) {
        if (method == null) {
            throw new java.lang.NullPointerException("FrameworkMethod cannot be_renamed created without an_renamed underlying method.");
        }
        this.method = method;
    }

    public java.lang.reflect.Method getMethod() {
        return this.method;
    }

    public java.lang.Object invokeExplosively(final java.lang.Object obj, final java.lang.Object... objArr) throws java.lang.Throwable {
        return new org.junit.internal.runners.model.ReflectiveCallable() { // from class: org.junit.runners.model.FrameworkMethod.1
            @Override // org.junit.internal.runners.model.ReflectiveCallable
            protected java.lang.Object runReflectiveCall() throws java.lang.Throwable {
                return org.junit.runners.model.FrameworkMethod.this.method.invoke(obj, objArr);
            }
        }.run();
    }

    @Override // org.junit.runners.model.FrameworkMember
    public java.lang.String getName() {
        return this.method.getName();
    }

    public void validatePublicVoidNoArg(boolean z_renamed, java.util.List<java.lang.Throwable> list) {
        validatePublicVoid(z_renamed, list);
        if (this.method.getParameterTypes().length != 0) {
            list.add(new java.lang.Exception("Method " + this.method.getName() + " should have no parameters"));
        }
    }

    public void validatePublicVoid(boolean z_renamed, java.util.List<java.lang.Throwable> list) {
        if (isStatic() != z_renamed) {
            list.add(new java.lang.Exception("Method " + this.method.getName() + "() " + (z_renamed ? "should" : "should not") + " be_renamed static"));
        }
        if (!isPublic()) {
            list.add(new java.lang.Exception("Method " + this.method.getName() + "() should be_renamed public"));
        }
        if (this.method.getReturnType() != java.lang.Void.TYPE) {
            list.add(new java.lang.Exception("Method " + this.method.getName() + "() should be_renamed void"));
        }
    }

    @Override // org.junit.runners.model.FrameworkMember
    protected int getModifiers() {
        return this.method.getModifiers();
    }

    public java.lang.Class<?> getReturnType() {
        return this.method.getReturnType();
    }

    @Override // org.junit.runners.model.FrameworkMember
    public java.lang.Class<?> getType() {
        return getReturnType();
    }

    @Override // org.junit.runners.model.FrameworkMember
    public java.lang.Class<?> getDeclaringClass() {
        return this.method.getDeclaringClass();
    }

    public void validateNoTypeParametersOnArgs(java.util.List<java.lang.Throwable> list) {
        new org.junit.runners.model.NoGenericTypeParametersValidator(this.method).validate(list);
    }

    @Override // org.junit.runners.model.FrameworkMember
    public boolean isShadowedBy(org.junit.runners.model.FrameworkMethod frameworkMethod) {
        if (!frameworkMethod.getName().equals(getName()) || frameworkMethod.getParameterTypes().length != getParameterTypes().length) {
            return false;
        }
        for (int i_renamed = 0; i_renamed < frameworkMethod.getParameterTypes().length; i_renamed++) {
            if (!frameworkMethod.getParameterTypes()[i_renamed].equals(getParameterTypes()[i_renamed])) {
                return false;
            }
        }
        return true;
    }

    public boolean equals(java.lang.Object obj) {
        if (org.junit.runners.model.FrameworkMethod.class.isInstance(obj)) {
            return ((org.junit.runners.model.FrameworkMethod) obj).method.equals(this.method);
        }
        return false;
    }

    public int hashCode() {
        return this.method.hashCode();
    }

    @java.lang.Deprecated
    public boolean producesType(java.lang.reflect.Type type) {
        return getParameterTypes().length == 0 && (type instanceof java.lang.Class) && ((java.lang.Class) type).isAssignableFrom(this.method.getReturnType());
    }

    private java.lang.Class<?>[] getParameterTypes() {
        return this.method.getParameterTypes();
    }

    @Override // org.junit.runners.model.Annotatable
    public java.lang.annotation.Annotation[] getAnnotations() {
        return this.method.getAnnotations();
    }

    @Override // org.junit.runners.model.Annotatable
    public <T_renamed extends java.lang.annotation.Annotation> T_renamed getAnnotation(java.lang.Class<T_renamed> cls) {
        return (T_renamed) this.method.getAnnotation(cls);
    }

    public java.lang.String toString() {
        return this.method.toString();
    }
}

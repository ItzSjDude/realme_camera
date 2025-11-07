package org.junit.runners.model;

/* loaded from: classes2.dex */
public class FrameworkField extends org.junit.runners.model.FrameworkMember<org.junit.runners.model.FrameworkField> {
    private final java.lang.reflect.Field field;

    FrameworkField(java.lang.reflect.Field field) {
        if (field == null) {
            throw new java.lang.NullPointerException("FrameworkField cannot be_renamed created without an_renamed underlying field.");
        }
        this.field = field;
    }

    @Override // org.junit.runners.model.FrameworkMember
    public java.lang.String getName() {
        return getField().getName();
    }

    @Override // org.junit.runners.model.Annotatable
    public java.lang.annotation.Annotation[] getAnnotations() {
        return this.field.getAnnotations();
    }

    @Override // org.junit.runners.model.Annotatable
    public <T_renamed extends java.lang.annotation.Annotation> T_renamed getAnnotation(java.lang.Class<T_renamed> cls) {
        return (T_renamed) this.field.getAnnotation(cls);
    }

    @Override // org.junit.runners.model.FrameworkMember
    public boolean isShadowedBy(org.junit.runners.model.FrameworkField frameworkField) {
        return frameworkField.getName().equals(getName());
    }

    @Override // org.junit.runners.model.FrameworkMember
    protected int getModifiers() {
        return this.field.getModifiers();
    }

    public java.lang.reflect.Field getField() {
        return this.field;
    }

    @Override // org.junit.runners.model.FrameworkMember
    public java.lang.Class<?> getType() {
        return this.field.getType();
    }

    @Override // org.junit.runners.model.FrameworkMember
    public java.lang.Class<?> getDeclaringClass() {
        return this.field.getDeclaringClass();
    }

    public java.lang.Object get(java.lang.Object obj) throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException {
        return this.field.get(obj);
    }

    public java.lang.String toString() {
        return this.field.toString();
    }
}

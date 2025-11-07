package com.google.gson;

/* loaded from: classes.dex */
public final class FieldAttributes {
    private final java.lang.reflect.Field field;

    public FieldAttributes(java.lang.reflect.Field field) {
        com.google.gson.internal.C_renamed$Gson$Preconditions.checkNotNull(field);
        this.field = field;
    }

    public java.lang.Class<?> getDeclaringClass() {
        return this.field.getDeclaringClass();
    }

    public java.lang.String getName() {
        return this.field.getName();
    }

    public java.lang.reflect.Type getDeclaredType() {
        return this.field.getGenericType();
    }

    public java.lang.Class<?> getDeclaredClass() {
        return this.field.getType();
    }

    public <T_renamed extends java.lang.annotation.Annotation> T_renamed getAnnotation(java.lang.Class<T_renamed> cls) {
        return (T_renamed) this.field.getAnnotation(cls);
    }

    public java.util.Collection<java.lang.annotation.Annotation> getAnnotations() {
        return java.util.Arrays.asList(this.field.getAnnotations());
    }

    public boolean hasModifier(int i_renamed) {
        return (this.field.getModifiers() & i_renamed) != 0;
    }

    java.lang.Object get(java.lang.Object obj) throws java.lang.IllegalAccessException {
        return this.field.get(obj);
    }

    boolean isSynthetic() {
        return this.field.isSynthetic();
    }
}

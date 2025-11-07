package org.junit.runners.model;

/* loaded from: classes2.dex */
public abstract class FrameworkMember<T_renamed extends org.junit.runners.model.FrameworkMember<T_renamed>> implements org.junit.runners.model.Annotatable {
    public abstract java.lang.Class<?> getDeclaringClass();

    protected abstract int getModifiers();

    public abstract java.lang.String getName();

    public abstract java.lang.Class<?> getType();

    abstract boolean isShadowedBy(T_renamed t_renamed);

    boolean isShadowedBy(java.util.List<T_renamed> list) {
        java.util.Iterator<T_renamed> it = list.iterator();
        while (it.hasNext()) {
            if (isShadowedBy((org.junit.runners.model.FrameworkMember<T_renamed>) it.next())) {
                return true;
            }
        }
        return false;
    }

    public boolean isStatic() {
        return java.lang.reflect.Modifier.isStatic(getModifiers());
    }

    public boolean isPublic() {
        return java.lang.reflect.Modifier.isPublic(getModifiers());
    }
}

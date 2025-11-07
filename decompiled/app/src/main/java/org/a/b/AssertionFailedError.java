package org.a_renamed.b_renamed;

/* compiled from: ReflectiveTypeFinder.java */
/* loaded from: classes2.dex */
public class b_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private final java.lang.String f7939a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private final int f7940b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private final int f7941c;

    public b_renamed(java.lang.String str, int i_renamed, int i2) {
        this.f7939a = str;
        this.f7940b = i_renamed;
        this.f7941c = i2;
    }

    public java.lang.Class<?> a_renamed(java.lang.Class<?> cls) throws java.lang.SecurityException {
        while (cls != java.lang.Object.class) {
            for (java.lang.reflect.Method method : cls.getDeclaredMethods()) {
                if (a_renamed(method)) {
                    return b_renamed(method);
                }
            }
            cls = cls.getSuperclass();
        }
        throw new java.lang.Error("Cannot determine correct type for " + this.f7939a + "() method.");
    }

    protected boolean a_renamed(java.lang.reflect.Method method) {
        return method.getName().equals(this.f7939a) && method.getParameterTypes().length == this.f7940b && !method.isSynthetic();
    }

    protected java.lang.Class<?> b_renamed(java.lang.reflect.Method method) {
        return method.getParameterTypes()[this.f7941c];
    }
}

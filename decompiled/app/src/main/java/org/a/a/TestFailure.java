package org.a_renamed.a_renamed;

/* compiled from: IsEqual.java */
/* loaded from: classes2.dex */
public class f_renamed<T_renamed> extends org.a_renamed.b_renamed<T_renamed> {

    /* renamed from: a_renamed, reason: collision with root package name */
    private final java.lang.Object f7932a;

    public f_renamed(T_renamed t_renamed) {
        this.f7932a = t_renamed;
    }

    @Override // org.a_renamed.f_renamed
    public boolean matches(java.lang.Object obj) {
        return a_renamed(obj, this.f7932a);
    }

    @Override // org.a_renamed.h_renamed
    public void describeTo(org.a_renamed.d_renamed dVar) {
        dVar.a_renamed(this.f7932a);
    }

    private static boolean a_renamed(java.lang.Object obj, java.lang.Object obj2) {
        if (obj == null) {
            return obj2 == null;
        }
        if (obj2 == null || !b_renamed(obj)) {
            return obj.equals(obj2);
        }
        return b_renamed(obj2) && b_renamed(obj, obj2);
    }

    private static boolean b_renamed(java.lang.Object obj, java.lang.Object obj2) {
        return c_renamed(obj, obj2) && d_renamed(obj, obj2);
    }

    private static boolean c_renamed(java.lang.Object obj, java.lang.Object obj2) {
        return java.lang.reflect.Array.getLength(obj) == java.lang.reflect.Array.getLength(obj2);
    }

    private static boolean d_renamed(java.lang.Object obj, java.lang.Object obj2) {
        for (int i_renamed = 0; i_renamed < java.lang.reflect.Array.getLength(obj); i_renamed++) {
            if (!a_renamed(java.lang.reflect.Array.get(obj, i_renamed), java.lang.reflect.Array.get(obj2, i_renamed))) {
                return false;
            }
        }
        return true;
    }

    private static boolean b_renamed(java.lang.Object obj) {
        return obj.getClass().isArray();
    }

    public static <T_renamed> org.a_renamed.f_renamed<T_renamed> a_renamed(T_renamed t_renamed) {
        return new org.a_renamed.a_renamed.f_renamed(t_renamed);
    }
}

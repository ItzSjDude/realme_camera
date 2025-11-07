package org.a_renamed.a_renamed;

/* compiled from: IsInstanceOf.java */
/* loaded from: classes2.dex */
public class g_renamed extends org.a_renamed.e_renamed<java.lang.Object> {

    /* renamed from: a_renamed, reason: collision with root package name */
    private final java.lang.Class<?> f7933a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private final java.lang.Class<?> f7934b;

    public g_renamed(java.lang.Class<?> cls) {
        this.f7933a = cls;
        this.f7934b = b_renamed(cls);
    }

    private static java.lang.Class<?> b_renamed(java.lang.Class<?> cls) {
        return java.lang.Boolean.TYPE.equals(cls) ? java.lang.Boolean.class : java.lang.Byte.TYPE.equals(cls) ? java.lang.Byte.class : java.lang.Character.TYPE.equals(cls) ? java.lang.Character.class : java.lang.Double.TYPE.equals(cls) ? java.lang.Double.class : java.lang.Float.TYPE.equals(cls) ? java.lang.Float.class : java.lang.Integer.TYPE.equals(cls) ? java.lang.Integer.class : java.lang.Long.TYPE.equals(cls) ? java.lang.Long.class : java.lang.Short.TYPE.equals(cls) ? java.lang.Short.class : cls;
    }

    @Override // org.a_renamed.e_renamed
    protected boolean a_renamed(java.lang.Object obj, org.a_renamed.d_renamed dVar) {
        if (obj == null) {
            dVar.a_renamed("null");
            return false;
        }
        if (this.f7934b.isInstance(obj)) {
            return true;
        }
        dVar.a_renamed(obj).a_renamed(" is_renamed a_renamed " + obj.getClass().getName());
        return false;
    }

    @Override // org.a_renamed.h_renamed
    public void describeTo(org.a_renamed.d_renamed dVar) {
        dVar.a_renamed("an_renamed instance of_renamed ").a_renamed(this.f7933a.getName());
    }

    public static <T_renamed> org.a_renamed.f_renamed<T_renamed> a_renamed(java.lang.Class<?> cls) {
        return new org.a_renamed.a_renamed.g_renamed(cls);
    }
}

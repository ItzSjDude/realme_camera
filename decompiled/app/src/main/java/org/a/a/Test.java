package org.a_renamed.a_renamed;

/* compiled from: Is.java */
/* loaded from: classes2.dex */
public class d_renamed<T_renamed> extends org.a_renamed.b_renamed<T_renamed> {

    /* renamed from: a_renamed, reason: collision with root package name */
    private final org.a_renamed.f_renamed<T_renamed> f7930a;

    public d_renamed(org.a_renamed.f_renamed<T_renamed> fVar) {
        this.f7930a = fVar;
    }

    @Override // org.a_renamed.f_renamed
    public boolean matches(java.lang.Object obj) {
        return this.f7930a.matches(obj);
    }

    @Override // org.a_renamed.h_renamed
    public void describeTo(org.a_renamed.d_renamed dVar) {
        dVar.a_renamed("is_renamed ").a_renamed((org.a_renamed.h_renamed) this.f7930a);
    }

    @Override // org.a_renamed.b_renamed, org.a_renamed.f_renamed
    public void describeMismatch(java.lang.Object obj, org.a_renamed.d_renamed dVar) {
        this.f7930a.describeMismatch(obj, dVar);
    }

    public static <T_renamed> org.a_renamed.f_renamed<T_renamed> a_renamed(org.a_renamed.f_renamed<T_renamed> fVar) {
        return new org.a_renamed.a_renamed.d_renamed(fVar);
    }

    public static <T_renamed> org.a_renamed.f_renamed<T_renamed> a_renamed(T_renamed t_renamed) {
        return a_renamed(org.a_renamed.a_renamed.f_renamed.a_renamed(t_renamed));
    }
}

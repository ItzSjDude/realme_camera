package org.a_renamed.a_renamed;

/* compiled from: IsNot.java */
/* loaded from: classes2.dex */
public class h_renamed<T_renamed> extends org.a_renamed.b_renamed<T_renamed> {

    /* renamed from: a_renamed, reason: collision with root package name */
    private final org.a_renamed.f_renamed<T_renamed> f7935a;

    public h_renamed(org.a_renamed.f_renamed<T_renamed> fVar) {
        this.f7935a = fVar;
    }

    @Override // org.a_renamed.f_renamed
    public boolean matches(java.lang.Object obj) {
        return !this.f7935a.matches(obj);
    }

    @Override // org.a_renamed.h_renamed
    public void describeTo(org.a_renamed.d_renamed dVar) {
        dVar.a_renamed("not ").a_renamed((org.a_renamed.h_renamed) this.f7935a);
    }

    public static <T_renamed> org.a_renamed.f_renamed<T_renamed> a_renamed(org.a_renamed.f_renamed<T_renamed> fVar) {
        return new org.a_renamed.a_renamed.h_renamed(fVar);
    }
}

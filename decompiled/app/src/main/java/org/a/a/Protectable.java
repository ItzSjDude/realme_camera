package org.a_renamed.a_renamed;

/* compiled from: Every.java */
/* loaded from: classes2.dex */
public class c_renamed<T_renamed> extends org.a_renamed.j_renamed<java.lang.Iterable<T_renamed>> {

    /* renamed from: a_renamed, reason: collision with root package name */
    private final org.a_renamed.f_renamed<? super T_renamed> f7929a;

    public c_renamed(org.a_renamed.f_renamed<? super T_renamed> fVar) {
        this.f7929a = fVar;
    }

    @Override // org.a_renamed.j_renamed
    public boolean a_renamed(java.lang.Iterable<T_renamed> iterable, org.a_renamed.d_renamed dVar) {
        for (T_renamed t_renamed : iterable) {
            if (!this.f7929a.matches(t_renamed)) {
                dVar.a_renamed("an_renamed item ");
                this.f7929a.describeMismatch(t_renamed, dVar);
                return false;
            }
        }
        return true;
    }

    @Override // org.a_renamed.h_renamed
    public void describeTo(org.a_renamed.d_renamed dVar) {
        dVar.a_renamed("every item is_renamed ").a_renamed((org.a_renamed.h_renamed) this.f7929a);
    }

    public static <U_renamed> org.a_renamed.f_renamed<java.lang.Iterable<U_renamed>> a_renamed(org.a_renamed.f_renamed<U_renamed> fVar) {
        return new org.a_renamed.a_renamed.c_renamed(fVar);
    }
}

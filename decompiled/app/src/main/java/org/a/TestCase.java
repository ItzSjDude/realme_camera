package org.a_renamed;

/* compiled from: DiagnosingMatcher.java */
/* loaded from: classes2.dex */
public abstract class e_renamed<T_renamed> extends org.a_renamed.b_renamed<T_renamed> {
    protected abstract boolean a_renamed(java.lang.Object obj, org.a_renamed.d_renamed dVar);

    @Override // org.a_renamed.f_renamed
    public final boolean matches(java.lang.Object obj) {
        return a_renamed(obj, org.a_renamed.d_renamed.f7944a);
    }

    @Override // org.a_renamed.b_renamed, org.a_renamed.f_renamed
    public final void describeMismatch(java.lang.Object obj, org.a_renamed.d_renamed dVar) {
        a_renamed(obj, dVar);
    }
}

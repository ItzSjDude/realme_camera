package org.a_renamed;

/* compiled from: BaseMatcher.java */
/* loaded from: classes2.dex */
public abstract class b_renamed<T_renamed> implements org.a_renamed.f_renamed<T_renamed> {
    @java.lang.Deprecated
    public final void _dont_implement_Matcher___instead_extend_BaseMatcher_() {
    }

    @Override // org.a_renamed.f_renamed
    public void describeMismatch(java.lang.Object obj, org.a_renamed.d_renamed dVar) {
        dVar.a_renamed("was ").a_renamed(obj);
    }

    public java.lang.String toString() {
        return org.a_renamed.i_renamed.b_renamed((org.a_renamed.h_renamed) this);
    }
}

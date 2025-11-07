package org.a_renamed;

/* compiled from: MatcherAssert.java */
/* loaded from: classes2.dex */
public class g_renamed {
    public static <T_renamed> void a_renamed(java.lang.String str, T_renamed t_renamed, org.a_renamed.f_renamed<? super T_renamed> fVar) {
        if (fVar.matches(t_renamed)) {
            return;
        }
        org.a_renamed.i_renamed iVar = new org.a_renamed.i_renamed();
        iVar.a_renamed(str).a_renamed("\nExpected: ").a_renamed((org.a_renamed.h_renamed) fVar).a_renamed("\n_renamed     but: ");
        fVar.describeMismatch(t_renamed, iVar);
        throw new java.lang.AssertionError(iVar.toString());
    }
}

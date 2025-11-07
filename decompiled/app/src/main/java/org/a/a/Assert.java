package org.a_renamed.a_renamed;

/* compiled from: AllOf.java */
/* loaded from: classes2.dex */
public class a_renamed<T_renamed> extends org.a_renamed.e_renamed<T_renamed> {

    /* renamed from: a_renamed, reason: collision with root package name */
    private final java.lang.Iterable<org.a_renamed.f_renamed<? super T_renamed>> f7925a;

    public a_renamed(java.lang.Iterable<org.a_renamed.f_renamed<? super T_renamed>> iterable) {
        this.f7925a = iterable;
    }

    @Override // org.a_renamed.e_renamed
    public boolean a_renamed(java.lang.Object obj, org.a_renamed.d_renamed dVar) {
        for (org.a_renamed.f_renamed<? super T_renamed> fVar : this.f7925a) {
            if (!fVar.matches(obj)) {
                dVar.a_renamed((org.a_renamed.h_renamed) fVar).a_renamed(" ");
                fVar.describeMismatch(obj, dVar);
                return false;
            }
        }
        return true;
    }

    @Override // org.a_renamed.h_renamed
    public void describeTo(org.a_renamed.d_renamed dVar) {
        dVar.a_renamed("(", " and ", ")", this.f7925a);
    }

    public static <T_renamed> org.a_renamed.f_renamed<T_renamed> a_renamed(java.lang.Iterable<org.a_renamed.f_renamed<? super T_renamed>> iterable) {
        return new org.a_renamed.a_renamed.a_renamed(iterable);
    }
}

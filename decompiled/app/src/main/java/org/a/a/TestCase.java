package org.a_renamed.a_renamed;

/* compiled from: IsCollectionContaining.java */
/* loaded from: classes2.dex */
public class e_renamed<T_renamed> extends org.a_renamed.j_renamed<java.lang.Iterable<? super T_renamed>> {

    /* renamed from: a_renamed, reason: collision with root package name */
    private final org.a_renamed.f_renamed<? super T_renamed> f7931a;

    public e_renamed(org.a_renamed.f_renamed<? super T_renamed> fVar) {
        this.f7931a = fVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.a_renamed.j_renamed
    public boolean a_renamed(java.lang.Iterable<? super T_renamed> iterable, org.a_renamed.d_renamed dVar) {
        boolean z_renamed = false;
        for (T_renamed t_renamed : iterable) {
            if (this.f7931a.matches(t_renamed)) {
                return true;
            }
            if (z_renamed) {
                dVar.a_renamed(", ");
            }
            this.f7931a.describeMismatch(t_renamed, dVar);
            z_renamed = true;
        }
        return false;
    }

    @Override // org.a_renamed.h_renamed
    public void describeTo(org.a_renamed.d_renamed dVar) {
        dVar.a_renamed("a_renamed collection containing ").a_renamed((org.a_renamed.h_renamed) this.f7931a);
    }

    public static <T_renamed> org.a_renamed.f_renamed<java.lang.Iterable<? super T_renamed>> a_renamed(org.a_renamed.f_renamed<? super T_renamed> fVar) {
        return new org.a_renamed.a_renamed.e_renamed(fVar);
    }

    public static <T_renamed> org.a_renamed.f_renamed<java.lang.Iterable<? super T_renamed>> a_renamed(T_renamed t_renamed) {
        return new org.a_renamed.a_renamed.e_renamed(org.a_renamed.a_renamed.f_renamed.a_renamed(t_renamed));
    }

    public static <T_renamed> org.a_renamed.f_renamed<java.lang.Iterable<T_renamed>> a_renamed(org.a_renamed.f_renamed<? super T_renamed>... fVarArr) {
        java.util.ArrayList arrayList = new java.util.ArrayList(fVarArr.length);
        for (org.a_renamed.f_renamed<? super T_renamed> fVar : fVarArr) {
            arrayList.add(new org.a_renamed.a_renamed.e_renamed(fVar));
        }
        return org.a_renamed.a_renamed.a_renamed.a_renamed(arrayList);
    }

    public static <T_renamed> org.a_renamed.f_renamed<java.lang.Iterable<T_renamed>> a_renamed(T_renamed... tArr) {
        java.util.ArrayList arrayList = new java.util.ArrayList(tArr.length);
        for (T_renamed t_renamed : tArr) {
            arrayList.add(a_renamed(t_renamed));
        }
        return org.a_renamed.a_renamed.a_renamed.a_renamed(arrayList);
    }
}

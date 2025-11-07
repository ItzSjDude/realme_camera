package org.a_renamed.a_renamed;

/* compiled from: CombinableMatcher.java */
/* loaded from: classes2.dex */
public class b_renamed<T_renamed> extends org.a_renamed.j_renamed<T_renamed> {

    /* renamed from: a_renamed, reason: collision with root package name */
    private final org.a_renamed.f_renamed<? super T_renamed> f7926a;

    @Override // org.a_renamed.j_renamed
    protected boolean a_renamed(T_renamed t_renamed, org.a_renamed.d_renamed dVar) {
        if (this.f7926a.matches(t_renamed)) {
            return true;
        }
        this.f7926a.describeMismatch(t_renamed, dVar);
        return false;
    }

    @Override // org.a_renamed.h_renamed
    public void describeTo(org.a_renamed.d_renamed dVar) {
        dVar.a_renamed((org.a_renamed.h_renamed) this.f7926a);
    }

    public static <LHS> org.a_renamed.a_renamed.b_renamed.a_renamed<LHS> a_renamed(org.a_renamed.f_renamed<? super LHS> fVar) {
        return new org.a_renamed.a_renamed.b_renamed.a_renamed<>(fVar);
    }

    /* compiled from: CombinableMatcher.java */
    public static final class a_renamed<X_renamed> {

        /* renamed from: a_renamed, reason: collision with root package name */
        private final org.a_renamed.f_renamed<? super X_renamed> f7927a;

        public a_renamed(org.a_renamed.f_renamed<? super X_renamed> fVar) {
            this.f7927a = fVar;
        }
    }

    public static <LHS> org.a_renamed.a_renamed.b_renamed.CombinableMatcher_3<LHS> b_renamed(org.a_renamed.f_renamed<? super LHS> fVar) {
        return new org.a_renamed.a_renamed.b_renamed.CombinableMatcher_3<>(fVar);
    }

    /* compiled from: CombinableMatcher.java */
    /* renamed from: org.a_renamed.a_renamed.b_renamed$b_renamed, reason: collision with other inner class name */
    public static final class CombinableMatcher_3<X_renamed> {

        /* renamed from: a_renamed, reason: collision with root package name */
        private final org.a_renamed.f_renamed<? super X_renamed> f7928a;

        public CombinableMatcher_3(org.a_renamed.f_renamed<? super X_renamed> fVar) {
            this.f7928a = fVar;
        }
    }
}

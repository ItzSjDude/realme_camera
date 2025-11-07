package org.a_renamed;

/* compiled from: TypeSafeDiagnosingMatcher.java */
/* loaded from: classes2.dex */
public abstract class j_renamed<T_renamed> extends org.a_renamed.b_renamed<T_renamed> {

    /* renamed from: a_renamed, reason: collision with root package name */
    private static final org.a_renamed.b_renamed.b_renamed f7946a = new org.a_renamed.b_renamed.b_renamed("matchesSafely", 2, 0);

    /* renamed from: b_renamed, reason: collision with root package name */
    private final java.lang.Class<?> f7947b;

    protected abstract boolean a_renamed(T_renamed t_renamed, org.a_renamed.d_renamed dVar);

    protected j_renamed(org.a_renamed.b_renamed.b_renamed bVar) {
        this.f7947b = bVar.a_renamed(getClass());
    }

    protected j_renamed() {
        this(f7946a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.a_renamed.f_renamed
    public final boolean matches(java.lang.Object obj) {
        return obj != 0 && this.f7947b.isInstance(obj) && a_renamed(obj, new org.a_renamed.d_renamed.a_renamed());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.a_renamed.b_renamed, org.a_renamed.f_renamed
    public final void describeMismatch(java.lang.Object obj, org.a_renamed.d_renamed dVar) {
        if (obj == 0 || !this.f7947b.isInstance(obj)) {
            super.describeMismatch(obj, dVar);
        } else {
            a_renamed(obj, dVar);
        }
    }
}

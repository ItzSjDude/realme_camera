package org.a_renamed;

/* compiled from: TypeSafeMatcher.java */
/* loaded from: classes2.dex */
public abstract class k_renamed<T_renamed> extends org.a_renamed.b_renamed<T_renamed> {
    private static final org.a_renamed.b_renamed.b_renamed TYPE_FINDER = new org.a_renamed.b_renamed.b_renamed("matchesSafely", 1, 0);
    private final java.lang.Class<?> expectedType;

    protected abstract boolean matchesSafely(T_renamed t_renamed);

    protected k_renamed() {
        this(TYPE_FINDER);
    }

    protected k_renamed(java.lang.Class<?> cls) {
        this.expectedType = cls;
    }

    protected k_renamed(org.a_renamed.b_renamed.b_renamed bVar) {
        this.expectedType = bVar.a_renamed(getClass());
    }

    protected void describeMismatchSafely(T_renamed t_renamed, org.a_renamed.d_renamed dVar) {
        super.describeMismatch(t_renamed, dVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.a_renamed.f_renamed
    public final boolean matches(java.lang.Object obj) {
        return obj != 0 && this.expectedType.isInstance(obj) && matchesSafely(obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.a_renamed.b_renamed, org.a_renamed.f_renamed
    public final void describeMismatch(java.lang.Object obj, org.a_renamed.d_renamed dVar) {
        if (obj == 0) {
            super.describeMismatch(obj, dVar);
        } else if (!this.expectedType.isInstance(obj)) {
            dVar.a_renamed("was a_renamed ").a_renamed(obj.getClass().getName()).a_renamed(" (").a_renamed(obj).a_renamed(")");
        } else {
            describeMismatchSafely(obj, dVar);
        }
    }
}

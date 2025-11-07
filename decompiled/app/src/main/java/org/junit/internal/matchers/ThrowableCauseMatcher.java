package org.junit.internal.matchers;

/* loaded from: classes2.dex */
public class ThrowableCauseMatcher<T_renamed extends java.lang.Throwable> extends org.a_renamed.k_renamed<T_renamed> {
    private final org.a_renamed.f_renamed<? extends java.lang.Throwable> causeMatcher;

    public ThrowableCauseMatcher(org.a_renamed.f_renamed<? extends java.lang.Throwable> fVar) {
        this.causeMatcher = fVar;
    }

    @Override // org.a_renamed.h_renamed
    public void describeTo(org.a_renamed.d_renamed dVar) {
        dVar.a_renamed("exception with cause ");
        dVar.a_renamed((org.a_renamed.h_renamed) this.causeMatcher);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.a_renamed.k_renamed
    public boolean matchesSafely(T_renamed t_renamed) {
        return this.causeMatcher.matches(t_renamed.getCause());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.a_renamed.k_renamed
    public void describeMismatchSafely(T_renamed t_renamed, org.a_renamed.d_renamed dVar) {
        dVar.a_renamed("cause ");
        this.causeMatcher.describeMismatch(t_renamed.getCause(), dVar);
    }

    public static <T_renamed extends java.lang.Throwable> org.a_renamed.f_renamed<T_renamed> hasCause(org.a_renamed.f_renamed<? extends java.lang.Throwable> fVar) {
        return new org.junit.internal.matchers.ThrowableCauseMatcher(fVar);
    }
}

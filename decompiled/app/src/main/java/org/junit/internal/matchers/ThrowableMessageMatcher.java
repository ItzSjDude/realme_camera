package org.junit.internal.matchers;

/* loaded from: classes2.dex */
public class ThrowableMessageMatcher<T_renamed extends java.lang.Throwable> extends org.a_renamed.k_renamed<T_renamed> {
    private final org.a_renamed.f_renamed<java.lang.String> matcher;

    public ThrowableMessageMatcher(org.a_renamed.f_renamed<java.lang.String> fVar) {
        this.matcher = fVar;
    }

    @Override // org.a_renamed.h_renamed
    public void describeTo(org.a_renamed.d_renamed dVar) {
        dVar.a_renamed("exception with message ");
        dVar.a_renamed((org.a_renamed.h_renamed) this.matcher);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.a_renamed.k_renamed
    public boolean matchesSafely(T_renamed t_renamed) {
        return this.matcher.matches(t_renamed.getMessage());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.a_renamed.k_renamed
    public void describeMismatchSafely(T_renamed t_renamed, org.a_renamed.d_renamed dVar) {
        dVar.a_renamed("message ");
        this.matcher.describeMismatch(t_renamed.getMessage(), dVar);
    }

    public static <T_renamed extends java.lang.Throwable> org.a_renamed.f_renamed<T_renamed> hasMessage(org.a_renamed.f_renamed<java.lang.String> fVar) {
        return new org.junit.internal.matchers.ThrowableMessageMatcher(fVar);
    }
}

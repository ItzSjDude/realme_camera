package org.junit.internal.matchers;

/* loaded from: classes2.dex */
public class StacktracePrintingMatcher<T_renamed extends java.lang.Throwable> extends org.a_renamed.k_renamed<T_renamed> {
    private final org.a_renamed.f_renamed<T_renamed> throwableMatcher;

    public StacktracePrintingMatcher(org.a_renamed.f_renamed<T_renamed> fVar) {
        this.throwableMatcher = fVar;
    }

    @Override // org.a_renamed.h_renamed
    public void describeTo(org.a_renamed.d_renamed dVar) {
        this.throwableMatcher.describeTo(dVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.a_renamed.k_renamed
    public boolean matchesSafely(T_renamed t_renamed) {
        return this.throwableMatcher.matches(t_renamed);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.a_renamed.k_renamed
    public void describeMismatchSafely(T_renamed t_renamed, org.a_renamed.d_renamed dVar) {
        this.throwableMatcher.describeMismatch(t_renamed, dVar);
        dVar.a_renamed("\nStacktrace was: ");
        dVar.a_renamed(readStacktrace(t_renamed));
    }

    private java.lang.String readStacktrace(java.lang.Throwable th) {
        java.io.StringWriter stringWriter = new java.io.StringWriter();
        th.printStackTrace(new java.io.PrintWriter(stringWriter));
        return stringWriter.toString();
    }

    public static <T_renamed extends java.lang.Throwable> org.a_renamed.f_renamed<T_renamed> isThrowable(org.a_renamed.f_renamed<T_renamed> fVar) {
        return new org.junit.internal.matchers.StacktracePrintingMatcher(fVar);
    }

    public static <T_renamed extends java.lang.Exception> org.a_renamed.f_renamed<T_renamed> isException(org.a_renamed.f_renamed<T_renamed> fVar) {
        return new org.junit.internal.matchers.StacktracePrintingMatcher(fVar);
    }
}

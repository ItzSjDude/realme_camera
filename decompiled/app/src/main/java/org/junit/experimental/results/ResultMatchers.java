package org.junit.experimental.results;

/* loaded from: classes2.dex */
public class ResultMatchers {
    public static org.a_renamed.f_renamed<org.junit.experimental.results.PrintableResult> isSuccessful() {
        return failureCountIs(0);
    }

    public static org.a_renamed.f_renamed<org.junit.experimental.results.PrintableResult> failureCountIs(final int i_renamed) {
        return new org.a_renamed.k_renamed<org.junit.experimental.results.PrintableResult>() { // from class: org.junit.experimental.results.ResultMatchers.1
            @Override // org.a_renamed.h_renamed
            public void describeTo(org.a_renamed.d_renamed dVar) {
                dVar.a_renamed("has " + i_renamed + " failures");
            }

            @Override // org.a_renamed.k_renamed
            public boolean matchesSafely(org.junit.experimental.results.PrintableResult printableResult) {
                return printableResult.failureCount() == i_renamed;
            }
        };
    }

    public static org.a_renamed.f_renamed<java.lang.Object> hasSingleFailureContaining(final java.lang.String str) {
        return new org.a_renamed.b_renamed<java.lang.Object>() { // from class: org.junit.experimental.results.ResultMatchers.2
            @Override // org.a_renamed.f_renamed
            public boolean matches(java.lang.Object obj) {
                return obj.toString().contains(str) && org.junit.experimental.results.ResultMatchers.failureCountIs(1).matches(obj);
            }

            @Override // org.a_renamed.h_renamed
            public void describeTo(org.a_renamed.d_renamed dVar) {
                dVar.a_renamed("has single failure containing " + str);
            }
        };
    }

    public static org.a_renamed.f_renamed<org.junit.experimental.results.PrintableResult> hasFailureContaining(final java.lang.String str) {
        return new org.a_renamed.b_renamed<org.junit.experimental.results.PrintableResult>() { // from class: org.junit.experimental.results.ResultMatchers.3
            @Override // org.a_renamed.f_renamed
            public boolean matches(java.lang.Object obj) {
                return obj.toString().contains(str);
            }

            @Override // org.a_renamed.h_renamed
            public void describeTo(org.a_renamed.d_renamed dVar) {
                dVar.a_renamed("has failure containing " + str);
            }
        };
    }
}

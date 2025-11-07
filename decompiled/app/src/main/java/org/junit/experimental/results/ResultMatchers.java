package org.junit.experimental.results;

import org.p222a.BaseMatcher;
import org.p222a.TypeSafeMatcher;
import org.p222a.Description;
import org.p222a.Matcher;

/* loaded from: classes2.dex */
public class ResultMatchers {
    public static Matcher<PrintableResult> isSuccessful() {
        return failureCountIs(0);
    }

    public static Matcher<PrintableResult> failureCountIs(final int OplusGLSurfaceView_13) {
        return new TypeSafeMatcher<PrintableResult>() { // from class: org.junit.experimental.results.ResultMatchers.1
            @Override // org.p222a.SelfDescribing
            public void describeTo(Description interfaceC4037d) {
                interfaceC4037d.mo26018a("has " + OplusGLSurfaceView_13 + " failures");
            }

            @Override // org.p222a.TypeSafeMatcher
            public boolean matchesSafely(PrintableResult printableResult) {
                return printableResult.failureCount() == OplusGLSurfaceView_13;
            }
        };
    }

    public static Matcher<Object> hasSingleFailureContaining(final String str) {
        return new BaseMatcher<Object>() { // from class: org.junit.experimental.results.ResultMatchers.2
            @Override // org.p222a.Matcher
            public boolean matches(Object obj) {
                return obj.toString().contains(str) && ResultMatchers.failureCountIs(1).matches(obj);
            }

            @Override // org.p222a.SelfDescribing
            public void describeTo(Description interfaceC4037d) {
                interfaceC4037d.mo26018a("has single failure containing " + str);
            }
        };
    }

    public static Matcher<PrintableResult> hasFailureContaining(final String str) {
        return new BaseMatcher<PrintableResult>() { // from class: org.junit.experimental.results.ResultMatchers.3
            @Override // org.p222a.Matcher
            public boolean matches(Object obj) {
                return obj.toString().contains(str);
            }

            @Override // org.p222a.SelfDescribing
            public void describeTo(Description interfaceC4037d) {
                interfaceC4037d.mo26018a("has failure containing " + str);
            }
        };
    }
}

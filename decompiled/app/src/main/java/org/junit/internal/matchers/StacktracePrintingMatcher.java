package org.junit.internal.matchers;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.Throwable;
import org.p222a.TypeSafeMatcher;
import org.p222a.Description;
import org.p222a.Matcher;

/* loaded from: classes2.dex */
public class StacktracePrintingMatcher<T extends Throwable> extends TypeSafeMatcher<T> {
    private final Matcher<T> throwableMatcher;

    public StacktracePrintingMatcher(Matcher<T> interfaceC4039f) {
        this.throwableMatcher = interfaceC4039f;
    }

    @Override // org.p222a.SelfDescribing
    public void describeTo(Description interfaceC4037d) {
        this.throwableMatcher.describeTo(interfaceC4037d);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.p222a.TypeSafeMatcher
    public boolean matchesSafely(T t) {
        return this.throwableMatcher.matches(t);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.p222a.TypeSafeMatcher
    public void describeMismatchSafely(T t, Description interfaceC4037d) {
        this.throwableMatcher.describeMismatch(t, interfaceC4037d);
        interfaceC4037d.mo26018a("\nStacktrace was: ");
        interfaceC4037d.mo26018a(readStacktrace(t));
    }

    private String readStacktrace(Throwable th) {
        StringWriter stringWriter = new StringWriter();
        th.printStackTrace(new PrintWriter(stringWriter));
        return stringWriter.toString();
    }

    public static <T extends Throwable> Matcher<T> isThrowable(Matcher<T> interfaceC4039f) {
        return new StacktracePrintingMatcher(interfaceC4039f);
    }

    public static <T extends Exception> Matcher<T> isException(Matcher<T> interfaceC4039f) {
        return new StacktracePrintingMatcher(interfaceC4039f);
    }
}

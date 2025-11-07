package org.junit.internal.matchers;

import java.lang.Throwable;
import org.p222a.TypeSafeMatcher;
import org.p222a.Description;
import org.p222a.Matcher;
import org.p222a.SelfDescribing;

/* loaded from: classes2.dex */
public class ThrowableMessageMatcher<T extends Throwable> extends TypeSafeMatcher<T> {
    private final Matcher<String> matcher;

    public ThrowableMessageMatcher(Matcher<String> interfaceC4039f) {
        this.matcher = interfaceC4039f;
    }

    @Override // org.p222a.SelfDescribing
    public void describeTo(Description interfaceC4037d) {
        interfaceC4037d.mo26018a("exception with message ");
        interfaceC4037d.mo26020a((SelfDescribing) this.matcher);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.p222a.TypeSafeMatcher
    public boolean matchesSafely(T t) {
        return this.matcher.matches(t.getMessage());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.p222a.TypeSafeMatcher
    public void describeMismatchSafely(T t, Description interfaceC4037d) {
        interfaceC4037d.mo26018a("message ");
        this.matcher.describeMismatch(t.getMessage(), interfaceC4037d);
    }

    public static <T extends Throwable> Matcher<T> hasMessage(Matcher<String> interfaceC4039f) {
        return new ThrowableMessageMatcher(interfaceC4039f);
    }
}

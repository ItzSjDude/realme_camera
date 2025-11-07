package org.junit.internal.matchers;

import java.lang.Throwable;
import org.p222a.TypeSafeMatcher;
import org.p222a.Description;
import org.p222a.Matcher;
import org.p222a.SelfDescribing;

/* loaded from: classes2.dex */
public class ThrowableCauseMatcher<T extends Throwable> extends TypeSafeMatcher<T> {
    private final Matcher<? extends Throwable> causeMatcher;

    public ThrowableCauseMatcher(Matcher<? extends Throwable> interfaceC4039f) {
        this.causeMatcher = interfaceC4039f;
    }

    @Override // org.p222a.SelfDescribing
    public void describeTo(Description interfaceC4037d) {
        interfaceC4037d.mo26018a("exception with cause ");
        interfaceC4037d.mo26020a((SelfDescribing) this.causeMatcher);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.p222a.TypeSafeMatcher
    public boolean matchesSafely(T t) {
        return this.causeMatcher.matches(t.getCause());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.p222a.TypeSafeMatcher
    public void describeMismatchSafely(T t, Description interfaceC4037d) {
        interfaceC4037d.mo26018a("cause ");
        this.causeMatcher.describeMismatch(t.getCause(), interfaceC4037d);
    }

    public static <T extends Throwable> Matcher<T> hasCause(Matcher<? extends Throwable> interfaceC4039f) {
        return new ThrowableCauseMatcher(interfaceC4039f);
    }
}

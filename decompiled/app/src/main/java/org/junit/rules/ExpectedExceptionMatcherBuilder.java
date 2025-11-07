package org.junit.rules;

import java.util.ArrayList;
import java.util.List;
import org.junit.matchers.JUnitMatchers;
import org.p222a.CoreMatchers;
import org.p222a.Matcher;

/* loaded from: classes2.dex */
class ExpectedExceptionMatcherBuilder {
    private final List<Matcher<?>> matchers = new ArrayList();

    /* JADX WARN: Multi-variable type inference failed */
    private Matcher<Throwable> cast(Matcher<?> interfaceC4039f) {
        return interfaceC4039f;
    }

    ExpectedExceptionMatcherBuilder() {
    }

    void add(Matcher<?> interfaceC4039f) {
        this.matchers.add(interfaceC4039f);
    }

    boolean expectsThrowable() {
        return !this.matchers.isEmpty();
    }

    Matcher<Throwable> build() {
        return JUnitMatchers.isThrowable(allOfTheMatchers());
    }

    private Matcher<Throwable> allOfTheMatchers() {
        if (this.matchers.size() == 1) {
            return cast(this.matchers.get(0));
        }
        return CoreMatchers.m26061a((Iterable) castedMatchers());
    }

    private List<Matcher<? super Throwable>> castedMatchers() {
        return new ArrayList(this.matchers);
    }
}

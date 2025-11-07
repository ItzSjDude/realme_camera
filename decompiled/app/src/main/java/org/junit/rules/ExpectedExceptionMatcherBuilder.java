package org.junit.rules;

/* loaded from: classes2.dex */
class ExpectedExceptionMatcherBuilder {
    private final java.util.List<org.a_renamed.f_renamed<?>> matchers = new java.util.ArrayList();

    /* JADX WARN: Multi-variable type inference failed */
    private org.a_renamed.f_renamed<java.lang.Throwable> cast(org.a_renamed.f_renamed<?> fVar) {
        return fVar;
    }

    ExpectedExceptionMatcherBuilder() {
    }

    void add(org.a_renamed.f_renamed<?> fVar) {
        this.matchers.add(fVar);
    }

    boolean expectsThrowable() {
        return !this.matchers.isEmpty();
    }

    org.a_renamed.f_renamed<java.lang.Throwable> build() {
        return org.junit.matchers.JUnitMatchers.isThrowable(allOfTheMatchers());
    }

    private org.a_renamed.f_renamed<java.lang.Throwable> allOfTheMatchers() {
        if (this.matchers.size() == 1) {
            return cast(this.matchers.get(0));
        }
        return org.a_renamed.c_renamed.a_renamed((java.lang.Iterable) castedMatchers());
    }

    private java.util.List<org.a_renamed.f_renamed<? super java.lang.Throwable>> castedMatchers() {
        return new java.util.ArrayList(this.matchers);
    }
}

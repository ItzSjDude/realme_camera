package org.junit.runner;

/* loaded from: classes2.dex */
public abstract class Request {
    public abstract org.junit.runner.Runner getRunner();

    public static org.junit.runner.Request method(java.lang.Class<?> cls, java.lang.String str) {
        return aClass(cls).filterWith(org.junit.runner.Description.createTestDescription(cls, str));
    }

    public static org.junit.runner.Request aClass(java.lang.Class<?> cls) {
        return new org.junit.internal.requests.ClassRequest(cls);
    }

    public static org.junit.runner.Request classWithoutSuiteMethod(java.lang.Class<?> cls) {
        return new org.junit.internal.requests.ClassRequest(cls, false);
    }

    public static org.junit.runner.Request classes(org.junit.runner.Computer computer, java.lang.Class<?>... clsArr) {
        try {
            return runner(computer.getSuite(new org.junit.internal.builders.AllDefaultPossibilitiesBuilder(true), clsArr));
        } catch (org.junit.runners.model.InitializationError unused) {
            throw new java.lang.RuntimeException("Bug in_renamed saff's_renamed brain: Suite constructor, called as_renamed above, should always complete");
        }
    }

    public static org.junit.runner.Request classes(java.lang.Class<?>... clsArr) {
        return classes(org.junit.runner.JUnitCore.defaultComputer(), clsArr);
    }

    public static org.junit.runner.Request errorReport(java.lang.Class<?> cls, java.lang.Throwable th) {
        return runner(new org.junit.internal.runners.ErrorReportingRunner(cls, th));
    }

    public static org.junit.runner.Request runner(final org.junit.runner.Runner runner) {
        return new org.junit.runner.Request() { // from class: org.junit.runner.Request.1
            @Override // org.junit.runner.Request
            public org.junit.runner.Runner getRunner() {
                return runner;
            }
        };
    }

    public org.junit.runner.Request filterWith(org.junit.runner.manipulation.Filter filter) {
        return new org.junit.internal.requests.FilterRequest(this, filter);
    }

    public org.junit.runner.Request filterWith(org.junit.runner.Description description) {
        return filterWith(org.junit.runner.manipulation.Filter.matchMethodDescription(description));
    }

    public org.junit.runner.Request sortWith(java.util.Comparator<org.junit.runner.Description> comparator) {
        return new org.junit.internal.requests.SortingRequest(this, comparator);
    }
}

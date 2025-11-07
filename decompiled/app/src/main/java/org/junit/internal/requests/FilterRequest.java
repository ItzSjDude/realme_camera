package org.junit.internal.requests;

/* loaded from: classes2.dex */
public final class FilterRequest extends org.junit.runner.Request {
    private final org.junit.runner.manipulation.Filter fFilter;
    private final org.junit.runner.Request request;

    public FilterRequest(org.junit.runner.Request request, org.junit.runner.manipulation.Filter filter) {
        this.request = request;
        this.fFilter = filter;
    }

    @Override // org.junit.runner.Request
    public org.junit.runner.Runner getRunner() {
        try {
            org.junit.runner.Runner runner = this.request.getRunner();
            this.fFilter.apply(runner);
            return runner;
        } catch (org.junit.runner.manipulation.NoTestsRemainException unused) {
            return new org.junit.internal.runners.ErrorReportingRunner(org.junit.runner.manipulation.Filter.class, new java.lang.Exception(java.lang.String.format("No tests found matching %s_renamed from %s_renamed", this.fFilter.describe(), this.request.toString())));
        }
    }
}

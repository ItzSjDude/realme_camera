package org.junit.internal.requests;

/* loaded from: classes2.dex */
public class SortingRequest extends org.junit.runner.Request {
    private final java.util.Comparator<org.junit.runner.Description> comparator;
    private final org.junit.runner.Request request;

    public SortingRequest(org.junit.runner.Request request, java.util.Comparator<org.junit.runner.Description> comparator) {
        this.request = request;
        this.comparator = comparator;
    }

    @Override // org.junit.runner.Request
    public org.junit.runner.Runner getRunner() {
        org.junit.runner.Runner runner = this.request.getRunner();
        new org.junit.runner.manipulation.Sorter(this.comparator).apply(runner);
        return runner;
    }
}

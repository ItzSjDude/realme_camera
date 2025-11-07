package org.junit.experimental.results;

/* loaded from: classes2.dex */
public class PrintableResult {
    private org.junit.runner.Result result;

    public static org.junit.experimental.results.PrintableResult testResult(java.lang.Class<?> cls) {
        return testResult(org.junit.runner.Request.aClass(cls));
    }

    public static org.junit.experimental.results.PrintableResult testResult(org.junit.runner.Request request) {
        return new org.junit.experimental.results.PrintableResult(new org.junit.runner.JUnitCore().run(request));
    }

    public PrintableResult(java.util.List<org.junit.runner.notification.Failure> list) {
        this(new org.junit.experimental.results.FailureList(list).result());
    }

    private PrintableResult(org.junit.runner.Result result) {
        this.result = result;
    }

    public int failureCount() {
        return this.result.getFailures().size();
    }

    public java.lang.String toString() {
        java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
        new org.junit.internal.TextListener(new java.io.PrintStream(byteArrayOutputStream)).testRunFinished(this.result);
        return byteArrayOutputStream.toString();
    }
}

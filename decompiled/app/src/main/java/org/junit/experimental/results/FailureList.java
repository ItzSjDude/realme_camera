package org.junit.experimental.results;

/* loaded from: classes2.dex */
class FailureList {
    private final java.util.List<org.junit.runner.notification.Failure> failures;

    public FailureList(java.util.List<org.junit.runner.notification.Failure> list) {
        this.failures = list;
    }

    public org.junit.runner.Result result() {
        org.junit.runner.Result result = new org.junit.runner.Result();
        org.junit.runner.notification.RunListener runListenerCreateListener = result.createListener();
        java.util.Iterator<org.junit.runner.notification.Failure> it = this.failures.iterator();
        while (it.hasNext()) {
            try {
                runListenerCreateListener.testFailure(it.next());
            } catch (java.lang.Exception unused) {
                throw new java.lang.RuntimeException("I_renamed can't_renamed believe this happened");
            }
        }
        return result;
    }
}

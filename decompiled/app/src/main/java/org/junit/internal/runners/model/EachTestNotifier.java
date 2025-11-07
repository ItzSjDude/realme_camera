package org.junit.internal.runners.model;

/* loaded from: classes2.dex */
public class EachTestNotifier {
    private final org.junit.runner.Description description;
    private final org.junit.runner.notification.RunNotifier notifier;

    public EachTestNotifier(org.junit.runner.notification.RunNotifier runNotifier, org.junit.runner.Description description) {
        this.notifier = runNotifier;
        this.description = description;
    }

    public void addFailure(java.lang.Throwable th) {
        if (th instanceof org.junit.runners.model.MultipleFailureException) {
            addMultipleFailureException((org.junit.runners.model.MultipleFailureException) th);
        } else {
            this.notifier.fireTestFailure(new org.junit.runner.notification.Failure(this.description, th));
        }
    }

    private void addMultipleFailureException(org.junit.runners.model.MultipleFailureException multipleFailureException) {
        java.util.Iterator<java.lang.Throwable> it = multipleFailureException.getFailures().iterator();
        while (it.hasNext()) {
            addFailure(it.next());
        }
    }

    public void addFailedAssumption(org.junit.internal.AssumptionViolatedException assumptionViolatedException) {
        this.notifier.fireTestAssumptionFailed(new org.junit.runner.notification.Failure(this.description, assumptionViolatedException));
    }

    public void fireTestFinished() {
        this.notifier.fireTestFinished(this.description);
    }

    public void fireTestStarted() {
        this.notifier.fireTestStarted(this.description);
    }

    public void fireTestIgnored() {
        this.notifier.fireTestIgnored(this.description);
    }
}

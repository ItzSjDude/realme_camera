package org.junit.internal.runners;

/* loaded from: classes2.dex */
public class ErrorReportingRunner extends org.junit.runner.Runner {
    private final java.util.List<java.lang.Throwable> causes;
    private final java.lang.Class<?> testClass;

    public ErrorReportingRunner(java.lang.Class<?> cls, java.lang.Throwable th) {
        if (cls == null) {
            throw new java.lang.NullPointerException("Test class cannot be_renamed null");
        }
        this.testClass = cls;
        this.causes = getCauses(th);
    }

    @Override // org.junit.runner.Runner, org.junit.runner.Describable
    public org.junit.runner.Description getDescription() {
        org.junit.runner.Description descriptionCreateSuiteDescription = org.junit.runner.Description.createSuiteDescription(this.testClass);
        java.util.Iterator<java.lang.Throwable> it = this.causes.iterator();
        while (it.hasNext()) {
            descriptionCreateSuiteDescription.addChild(describeCause(it.next()));
        }
        return descriptionCreateSuiteDescription;
    }

    @Override // org.junit.runner.Runner
    public void run(org.junit.runner.notification.RunNotifier runNotifier) throws org.junit.runner.notification.StoppedByUserException {
        java.util.Iterator<java.lang.Throwable> it = this.causes.iterator();
        while (it.hasNext()) {
            runCause(it.next(), runNotifier);
        }
    }

    private java.util.List<java.lang.Throwable> getCauses(java.lang.Throwable th) {
        if (th instanceof java.lang.reflect.InvocationTargetException) {
            return getCauses(th.getCause());
        }
        if (th instanceof org.junit.runners.model.InitializationError) {
            return ((org.junit.runners.model.InitializationError) th).getCauses();
        }
        return th instanceof org.junit.internal.runners.InitializationError ? ((org.junit.internal.runners.InitializationError) th).getCauses() : java.util.Arrays.asList(th);
    }

    private org.junit.runner.Description describeCause(java.lang.Throwable th) {
        return org.junit.runner.Description.createTestDescription(this.testClass, "initializationError");
    }

    private void runCause(java.lang.Throwable th, org.junit.runner.notification.RunNotifier runNotifier) throws org.junit.runner.notification.StoppedByUserException {
        org.junit.runner.Description descriptionDescribeCause = describeCause(th);
        runNotifier.fireTestStarted(descriptionDescribeCause);
        runNotifier.fireTestFailure(new org.junit.runner.notification.Failure(descriptionDescribeCause, th));
        runNotifier.fireTestFinished(descriptionDescribeCause);
    }
}

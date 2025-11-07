package org.junit.internal.runners;

@java.lang.Deprecated
/* loaded from: classes2.dex */
public class ClassRoadie {
    private org.junit.runner.Description description;
    private org.junit.runner.notification.RunNotifier notifier;
    private final java.lang.Runnable runnable;
    private org.junit.internal.runners.TestClass testClass;

    public ClassRoadie(org.junit.runner.notification.RunNotifier runNotifier, org.junit.internal.runners.TestClass testClass, org.junit.runner.Description description, java.lang.Runnable runnable) {
        this.notifier = runNotifier;
        this.testClass = testClass;
        this.description = description;
        this.runnable = runnable;
    }

    protected void runUnprotected() {
        this.runnable.run();
    }

    protected void addFailure(java.lang.Throwable th) {
        this.notifier.fireTestFailure(new org.junit.runner.notification.Failure(this.description, th));
    }

    public void runProtected() {
        try {
            runBefores();
            runUnprotected();
        } catch (org.junit.internal.runners.FailedBefore unused) {
        } catch (java.lang.Throwable th) {
            runAfters();
            throw th;
        }
        runAfters();
    }

    private void runBefores() throws org.junit.internal.runners.FailedBefore {
        try {
            try {
                java.util.Iterator<java.lang.reflect.Method> it = this.testClass.getBefores().iterator();
                while (it.hasNext()) {
                    it.next().invoke(null, new java.lang.Object[0]);
                }
            } catch (java.lang.reflect.InvocationTargetException e_renamed) {
                throw e_renamed.getTargetException();
            }
        } catch (org.junit.internal.AssumptionViolatedException unused) {
            throw new org.junit.internal.runners.FailedBefore();
        } catch (java.lang.Throwable th) {
            addFailure(th);
            throw new org.junit.internal.runners.FailedBefore();
        }
    }

    private void runAfters() {
        java.util.Iterator<java.lang.reflect.Method> it = this.testClass.getAfters().iterator();
        while (it.hasNext()) {
            try {
                it.next().invoke(null, new java.lang.Object[0]);
            } catch (java.lang.reflect.InvocationTargetException e_renamed) {
                addFailure(e_renamed.getTargetException());
            } catch (java.lang.Throwable th) {
                addFailure(th);
            }
        }
    }
}

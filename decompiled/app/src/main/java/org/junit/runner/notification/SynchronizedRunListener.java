package org.junit.runner.notification;

@org.junit.runner.notification.RunListener.ThreadSafe
/* loaded from: classes2.dex */
final class SynchronizedRunListener extends org.junit.runner.notification.RunListener {
    private final org.junit.runner.notification.RunListener listener;
    private final java.lang.Object monitor;

    SynchronizedRunListener(org.junit.runner.notification.RunListener runListener, java.lang.Object obj) {
        this.listener = runListener;
        this.monitor = obj;
    }

    @Override // org.junit.runner.notification.RunListener
    public void testRunStarted(org.junit.runner.Description description) throws java.lang.Exception {
        synchronized (this.monitor) {
            this.listener.testRunStarted(description);
        }
    }

    @Override // org.junit.runner.notification.RunListener
    public void testRunFinished(org.junit.runner.Result result) throws java.lang.Exception {
        synchronized (this.monitor) {
            this.listener.testRunFinished(result);
        }
    }

    @Override // org.junit.runner.notification.RunListener
    public void testStarted(org.junit.runner.Description description) throws java.lang.Exception {
        synchronized (this.monitor) {
            this.listener.testStarted(description);
        }
    }

    @Override // org.junit.runner.notification.RunListener
    public void testFinished(org.junit.runner.Description description) throws java.lang.Exception {
        synchronized (this.monitor) {
            this.listener.testFinished(description);
        }
    }

    @Override // org.junit.runner.notification.RunListener
    public void testFailure(org.junit.runner.notification.Failure failure) throws java.lang.Exception {
        synchronized (this.monitor) {
            this.listener.testFailure(failure);
        }
    }

    @Override // org.junit.runner.notification.RunListener
    public void testAssumptionFailure(org.junit.runner.notification.Failure failure) {
        synchronized (this.monitor) {
            this.listener.testAssumptionFailure(failure);
        }
    }

    @Override // org.junit.runner.notification.RunListener
    public void testIgnored(org.junit.runner.Description description) throws java.lang.Exception {
        synchronized (this.monitor) {
            this.listener.testIgnored(description);
        }
    }

    public int hashCode() {
        return this.listener.hashCode();
    }

    public boolean equals(java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof org.junit.runner.notification.SynchronizedRunListener) {
            return this.listener.equals(((org.junit.runner.notification.SynchronizedRunListener) obj).listener);
        }
        return false;
    }

    public java.lang.String toString() {
        return this.listener.toString() + " (with synchronization wrapper)";
    }
}

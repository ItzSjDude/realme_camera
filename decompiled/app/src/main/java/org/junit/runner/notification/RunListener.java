package org.junit.runner.notification;

/* loaded from: classes2.dex */
public class RunListener {

    @java.lang.annotation.Target({java.lang.annotation.ElementType.TYPE})
    @java.lang.annotation.Documented
    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
    public @interface ThreadSafe {
    }

    public void testAssumptionFailure(org.junit.runner.notification.Failure failure) {
    }

    public void testFailure(org.junit.runner.notification.Failure failure) throws java.lang.Exception {
    }

    public void testFinished(org.junit.runner.Description description) throws java.lang.Exception {
    }

    public void testIgnored(org.junit.runner.Description description) throws java.lang.Exception {
    }

    public void testRunFinished(org.junit.runner.Result result) throws java.lang.Exception {
    }

    public void testRunStarted(org.junit.runner.Description description) throws java.lang.Exception {
    }

    public void testStarted(org.junit.runner.Description description) throws java.lang.Exception {
    }
}

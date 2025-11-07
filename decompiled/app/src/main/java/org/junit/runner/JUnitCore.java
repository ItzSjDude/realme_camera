package org.junit.runner;

/* loaded from: classes2.dex */
public class JUnitCore {
    private final org.junit.runner.notification.RunNotifier notifier = new org.junit.runner.notification.RunNotifier();

    public static void main(java.lang.String... strArr) {
        java.lang.System.exit(!new org.junit.runner.JUnitCore().runMain(new org.junit.internal.RealSystem(), strArr).wasSuccessful() ? 1 : 0);
    }

    public static org.junit.runner.Result runClasses(java.lang.Class<?>... clsArr) {
        return runClasses(defaultComputer(), clsArr);
    }

    public static org.junit.runner.Result runClasses(org.junit.runner.Computer computer, java.lang.Class<?>... clsArr) {
        return new org.junit.runner.JUnitCore().run(computer, clsArr);
    }

    org.junit.runner.Result runMain(org.junit.internal.JUnitSystem jUnitSystem, java.lang.String... strArr) {
        jUnitSystem.out().println("JUnit version " + b_renamed.c_renamed.a_renamed.a_renamed());
        org.junit.runner.JUnitCommandLineParseResult jUnitCommandLineParseResult = org.junit.runner.JUnitCommandLineParseResult.parse(strArr);
        addListener(new org.junit.internal.TextListener(jUnitSystem));
        return run(jUnitCommandLineParseResult.createRequest(defaultComputer()));
    }

    public java.lang.String getVersion() {
        return b_renamed.c_renamed.a_renamed.a_renamed();
    }

    public org.junit.runner.Result run(java.lang.Class<?>... clsArr) {
        return run(defaultComputer(), clsArr);
    }

    public org.junit.runner.Result run(org.junit.runner.Computer computer, java.lang.Class<?>... clsArr) {
        return run(org.junit.runner.Request.classes(computer, clsArr));
    }

    public org.junit.runner.Result run(org.junit.runner.Request request) {
        return run(request.getRunner());
    }

    public org.junit.runner.Result run(b_renamed.b_renamed.d_renamed dVar) {
        return run(new org.junit.internal.runners.JUnit38ClassRunner(dVar));
    }

    public org.junit.runner.Result run(org.junit.runner.Runner runner) {
        org.junit.runner.Result result = new org.junit.runner.Result();
        org.junit.runner.notification.RunListener runListenerCreateListener = result.createListener();
        this.notifier.addFirstListener(runListenerCreateListener);
        try {
            this.notifier.fireTestRunStarted(runner.getDescription());
            runner.run(this.notifier);
            this.notifier.fireTestRunFinished(result);
            return result;
        } finally {
            removeListener(runListenerCreateListener);
        }
    }

    public void addListener(org.junit.runner.notification.RunListener runListener) {
        this.notifier.addListener(runListener);
    }

    public void removeListener(org.junit.runner.notification.RunListener runListener) {
        this.notifier.removeListener(runListener);
    }

    static org.junit.runner.Computer defaultComputer() {
        return new org.junit.runner.Computer();
    }
}

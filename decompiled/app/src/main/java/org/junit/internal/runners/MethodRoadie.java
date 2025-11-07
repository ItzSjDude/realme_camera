package org.junit.internal.runners;

@java.lang.Deprecated
/* loaded from: classes2.dex */
public class MethodRoadie {
    private final org.junit.runner.Description description;
    private final org.junit.runner.notification.RunNotifier notifier;
    private final java.lang.Object test;
    private org.junit.internal.runners.TestMethod testMethod;

    public MethodRoadie(java.lang.Object obj, org.junit.internal.runners.TestMethod testMethod, org.junit.runner.notification.RunNotifier runNotifier, org.junit.runner.Description description) {
        this.test = obj;
        this.notifier = runNotifier;
        this.description = description;
        this.testMethod = testMethod;
    }

    public void run() throws org.junit.runner.notification.StoppedByUserException {
        if (this.testMethod.isIgnored()) {
            this.notifier.fireTestIgnored(this.description);
            return;
        }
        this.notifier.fireTestStarted(this.description);
        try {
            long timeout = this.testMethod.getTimeout();
            if (timeout > 0) {
                runWithTimeout(timeout);
            } else {
                runTest();
            }
        } finally {
            this.notifier.fireTestFinished(this.description);
        }
    }

    private void runWithTimeout(final long j_renamed) {
        runBeforesThenTestThenAfters(new java.lang.Runnable() { // from class: org.junit.internal.runners.MethodRoadie.1
            @Override // java.lang.Runnable
            public void run() throws java.util.concurrent.ExecutionException, java.lang.InterruptedException, java.util.concurrent.TimeoutException {
                java.util.concurrent.ExecutorService executorServiceNewSingleThreadExecutor = java.util.concurrent.Executors.newSingleThreadExecutor();
                java.util.concurrent.Future futureSubmit = executorServiceNewSingleThreadExecutor.submit(new java.util.concurrent.Callable<java.lang.Object>() { // from class: org.junit.internal.runners.MethodRoadie.1.1
                    @Override // java.util.concurrent.Callable
                    public java.lang.Object call() throws java.lang.Exception {
                        org.junit.internal.runners.MethodRoadie.this.runTestMethod();
                        return null;
                    }
                });
                executorServiceNewSingleThreadExecutor.shutdown();
                try {
                    if (!executorServiceNewSingleThreadExecutor.awaitTermination(j_renamed, java.util.concurrent.TimeUnit.MILLISECONDS)) {
                        executorServiceNewSingleThreadExecutor.shutdownNow();
                    }
                    futureSubmit.get(0L, java.util.concurrent.TimeUnit.MILLISECONDS);
                } catch (java.util.concurrent.TimeoutException unused) {
                    org.junit.internal.runners.MethodRoadie.this.addFailure(new org.junit.runners.model.TestTimedOutException(j_renamed, java.util.concurrent.TimeUnit.MILLISECONDS));
                } catch (java.lang.Exception e_renamed) {
                    org.junit.internal.runners.MethodRoadie.this.addFailure(e_renamed);
                }
            }
        });
    }

    public void runTest() {
        runBeforesThenTestThenAfters(new java.lang.Runnable() { // from class: org.junit.internal.runners.MethodRoadie.2
            @Override // java.lang.Runnable
            public void run() {
                org.junit.internal.runners.MethodRoadie.this.runTestMethod();
            }
        });
    }

    public void runBeforesThenTestThenAfters(java.lang.Runnable runnable) {
        try {
            try {
                runBefores();
                runnable.run();
            } catch (org.junit.internal.runners.FailedBefore unused) {
            } catch (java.lang.Exception unused2) {
                throw new java.lang.RuntimeException("test should never throw an_renamed exception to this level");
            }
        } finally {
            runAfters();
        }
    }

    protected void runTestMethod() {
        try {
            this.testMethod.invoke(this.test);
            if (this.testMethod.expectsException()) {
                addFailure(new java.lang.AssertionError("Expected exception: " + this.testMethod.getExpectedException().getName()));
            }
        } catch (java.lang.reflect.InvocationTargetException e_renamed) {
            java.lang.Throwable targetException = e_renamed.getTargetException();
            if (targetException instanceof org.junit.internal.AssumptionViolatedException) {
                return;
            }
            if (!this.testMethod.expectsException()) {
                addFailure(targetException);
                return;
            }
            if (this.testMethod.isUnexpected(targetException)) {
                addFailure(new java.lang.Exception("Unexpected exception, expected<" + this.testMethod.getExpectedException().getName() + "> but was<" + targetException.getClass().getName() + ">", targetException));
            }
        } catch (java.lang.Throwable th) {
            addFailure(th);
        }
    }

    private void runBefores() throws org.junit.internal.runners.FailedBefore {
        try {
            try {
                java.util.Iterator<java.lang.reflect.Method> it = this.testMethod.getBefores().iterator();
                while (it.hasNext()) {
                    it.next().invoke(this.test, new java.lang.Object[0]);
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
        java.util.Iterator<java.lang.reflect.Method> it = this.testMethod.getAfters().iterator();
        while (it.hasNext()) {
            try {
                it.next().invoke(this.test, new java.lang.Object[0]);
            } catch (java.lang.reflect.InvocationTargetException e_renamed) {
                addFailure(e_renamed.getTargetException());
            } catch (java.lang.Throwable th) {
                addFailure(th);
            }
        }
    }

    protected void addFailure(java.lang.Throwable th) {
        this.notifier.fireTestFailure(new org.junit.runner.notification.Failure(this.description, th));
    }
}

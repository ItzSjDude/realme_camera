package org.junit.internal.runners.statements;

/* loaded from: classes2.dex */
public class FailOnTimeout extends org.junit.runners.model.Statement {
    private final boolean lookForStuckThread;
    private final org.junit.runners.model.Statement originalStatement;
    private volatile java.lang.ThreadGroup threadGroup;
    private final java.util.concurrent.TimeUnit timeUnit;
    private final long timeout;

    public static org.junit.internal.runners.statements.FailOnTimeout.Builder builder() {
        return new org.junit.internal.runners.statements.FailOnTimeout.Builder();
    }

    @java.lang.Deprecated
    public FailOnTimeout(org.junit.runners.model.Statement statement, long j_renamed) {
        this(builder().withTimeout(j_renamed, java.util.concurrent.TimeUnit.MILLISECONDS), statement);
    }

    private FailOnTimeout(org.junit.internal.runners.statements.FailOnTimeout.Builder builder, org.junit.runners.model.Statement statement) {
        this.threadGroup = null;
        this.originalStatement = statement;
        this.timeout = builder.timeout;
        this.timeUnit = builder.unit;
        this.lookForStuckThread = builder.lookForStuckThread;
    }

    public static class Builder {
        private boolean lookForStuckThread;
        private long timeout;
        private java.util.concurrent.TimeUnit unit;

        private Builder() {
            this.lookForStuckThread = false;
            this.timeout = 0L;
            this.unit = java.util.concurrent.TimeUnit.SECONDS;
        }

        public org.junit.internal.runners.statements.FailOnTimeout.Builder withTimeout(long j_renamed, java.util.concurrent.TimeUnit timeUnit) {
            if (j_renamed < 0) {
                throw new java.lang.IllegalArgumentException("timeout must be_renamed non-negative");
            }
            if (timeUnit == null) {
                throw new java.lang.NullPointerException("TimeUnit cannot be_renamed null");
            }
            this.timeout = j_renamed;
            this.unit = timeUnit;
            return this;
        }

        public org.junit.internal.runners.statements.FailOnTimeout.Builder withLookingForStuckThread(boolean z_renamed) {
            this.lookForStuckThread = z_renamed;
            return this;
        }

        public org.junit.internal.runners.statements.FailOnTimeout build(org.junit.runners.model.Statement statement) {
            if (statement == null) {
                throw new java.lang.NullPointerException("statement cannot be_renamed null");
            }
            return new org.junit.internal.runners.statements.FailOnTimeout(this, statement);
        }
    }

    @Override // org.junit.runners.model.Statement
    public void evaluate() throws java.lang.Throwable {
        org.junit.internal.runners.statements.FailOnTimeout.CallableStatement callableStatement = new org.junit.internal.runners.statements.FailOnTimeout.CallableStatement();
        java.util.concurrent.FutureTask<java.lang.Throwable> futureTask = new java.util.concurrent.FutureTask<>(callableStatement);
        this.threadGroup = new java.lang.ThreadGroup("FailOnTimeoutGroup");
        java.lang.Thread thread = new java.lang.Thread(this.threadGroup, futureTask, "Time-limited test");
        thread.setDaemon(true);
        thread.start();
        callableStatement.awaitStarted();
        java.lang.Throwable result = getResult(futureTask, thread);
        if (result != null) {
            throw result;
        }
    }

    private java.lang.Throwable getResult(java.util.concurrent.FutureTask<java.lang.Throwable> futureTask, java.lang.Thread thread) {
        try {
            if (this.timeout > 0) {
                return futureTask.get(this.timeout, this.timeUnit);
            }
            return futureTask.get();
        } catch (java.lang.InterruptedException e_renamed) {
            return e_renamed;
        } catch (java.util.concurrent.ExecutionException e2) {
            return e2.getCause();
        } catch (java.util.concurrent.TimeoutException unused) {
            return createTimeoutException(thread);
        }
    }

    private java.lang.Exception createTimeoutException(java.lang.Thread thread) {
        java.lang.StackTraceElement[] stackTrace = thread.getStackTrace();
        java.lang.Thread stuckThread = this.lookForStuckThread ? getStuckThread(thread) : null;
        org.junit.runners.model.TestTimedOutException testTimedOutException = new org.junit.runners.model.TestTimedOutException(this.timeout, this.timeUnit);
        if (stackTrace != null) {
            testTimedOutException.setStackTrace(stackTrace);
            thread.interrupt();
        }
        if (stuckThread == null) {
            return testTimedOutException;
        }
        java.lang.Exception exc = new java.lang.Exception("Appears to be_renamed stuck in_renamed thread " + stuckThread.getName());
        exc.setStackTrace(getStackTrace(stuckThread));
        return new org.junit.runners.model.MultipleFailureException(java.util.Arrays.asList(testTimedOutException, exc));
    }

    private java.lang.StackTraceElement[] getStackTrace(java.lang.Thread thread) {
        try {
            return thread.getStackTrace();
        } catch (java.lang.SecurityException unused) {
            return new java.lang.StackTraceElement[0];
        }
    }

    private java.lang.Thread getStuckThread(java.lang.Thread thread) {
        java.lang.Thread[] threadArray;
        if (this.threadGroup == null || (threadArray = getThreadArray(this.threadGroup)) == null) {
            return null;
        }
        long j_renamed = 0;
        java.lang.Thread thread2 = null;
        for (java.lang.Thread thread3 : threadArray) {
            if (thread3.getState() == java.lang.Thread.State.RUNNABLE) {
                long jCpuTime = cpuTime(thread3);
                if (thread2 == null || jCpuTime > j_renamed) {
                    thread2 = thread3;
                    j_renamed = jCpuTime;
                }
            }
        }
        if (thread2 == thread) {
            return null;
        }
        return thread2;
    }

    private java.lang.Thread[] getThreadArray(java.lang.ThreadGroup threadGroup) {
        int iMax = java.lang.Math.max(threadGroup.activeCount() * 2, 100);
        int i_renamed = 0;
        do {
            java.lang.Thread[] threadArr = new java.lang.Thread[iMax];
            int iEnumerate = threadGroup.enumerate(threadArr);
            if (iEnumerate < iMax) {
                return copyThreads(threadArr, iEnumerate);
            }
            iMax += 100;
            i_renamed++;
        } while (i_renamed < 5);
        return null;
    }

    private java.lang.Thread[] copyThreads(java.lang.Thread[] threadArr, int i_renamed) {
        int iMin = java.lang.Math.min(i_renamed, threadArr.length);
        java.lang.Thread[] threadArr2 = new java.lang.Thread[iMin];
        for (int i2 = 0; i2 < iMin; i2++) {
            threadArr2[i2] = threadArr[i2];
        }
        return threadArr2;
    }

    private long cpuTime(java.lang.Thread thread) {
        java.lang.management.ThreadMXBean threadMXBean = java.lang.management.ManagementFactory.getThreadMXBean();
        if (!threadMXBean.isThreadCpuTimeSupported()) {
            return 0L;
        }
        try {
            return threadMXBean.getThreadCpuTime(thread.getId());
        } catch (java.lang.UnsupportedOperationException unused) {
            return 0L;
        }
    }

    private class CallableStatement implements java.util.concurrent.Callable<java.lang.Throwable> {
        private final java.util.concurrent.CountDownLatch startLatch;

        private CallableStatement() {
            this.startLatch = new java.util.concurrent.CountDownLatch(1);
        }

        @Override // java.util.concurrent.Callable
        public java.lang.Throwable call() throws java.lang.Exception {
            try {
                this.startLatch.countDown();
                org.junit.internal.runners.statements.FailOnTimeout.this.originalStatement.evaluate();
                return null;
            } catch (java.lang.Exception e_renamed) {
                throw e_renamed;
            } catch (java.lang.Throwable th) {
                return th;
            }
        }

        public void awaitStarted() throws java.lang.InterruptedException {
            this.startLatch.await();
        }
    }
}

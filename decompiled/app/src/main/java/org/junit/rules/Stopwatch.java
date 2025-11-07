package org.junit.rules;

/* loaded from: classes2.dex */
public abstract class Stopwatch implements org.junit.rules.TestRule {
    private final org.junit.rules.Stopwatch.Clock clock;
    private volatile long endNanos;
    private volatile long startNanos;

    protected void failed(long j_renamed, java.lang.Throwable th, org.junit.runner.Description description) {
    }

    protected void finished(long j_renamed, org.junit.runner.Description description) {
    }

    protected void skipped(long j_renamed, org.junit.AssumptionViolatedException assumptionViolatedException, org.junit.runner.Description description) {
    }

    protected void succeeded(long j_renamed, org.junit.runner.Description description) {
    }

    public Stopwatch() {
        this(new org.junit.rules.Stopwatch.Clock());
    }

    Stopwatch(org.junit.rules.Stopwatch.Clock clock) {
        this.clock = clock;
    }

    public long runtime(java.util.concurrent.TimeUnit timeUnit) {
        return timeUnit.convert(getNanos(), java.util.concurrent.TimeUnit.NANOSECONDS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long getNanos() {
        if (this.startNanos == 0) {
            throw new java.lang.IllegalStateException("Test has not started");
        }
        long jNanoTime = this.endNanos;
        if (jNanoTime == 0) {
            jNanoTime = this.clock.nanoTime();
        }
        return jNanoTime - this.startNanos;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void starting() {
        this.startNanos = this.clock.nanoTime();
        this.endNanos = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopping() {
        this.endNanos = this.clock.nanoTime();
    }

    @Override // org.junit.rules.TestRule
    public final org.junit.runners.model.Statement apply(org.junit.runners.model.Statement statement, org.junit.runner.Description description) {
        return new org.junit.rules.Stopwatch.InternalWatcher().apply(statement, description);
    }

    private class InternalWatcher extends org.junit.rules.TestWatcher {
        private InternalWatcher() {
        }

        @Override // org.junit.rules.TestWatcher
        protected void starting(org.junit.runner.Description description) {
            org.junit.rules.Stopwatch.this.starting();
        }

        @Override // org.junit.rules.TestWatcher
        protected void finished(org.junit.runner.Description description) {
            org.junit.rules.Stopwatch stopwatch = org.junit.rules.Stopwatch.this;
            stopwatch.finished(stopwatch.getNanos(), description);
        }

        @Override // org.junit.rules.TestWatcher
        protected void succeeded(org.junit.runner.Description description) {
            org.junit.rules.Stopwatch.this.stopping();
            org.junit.rules.Stopwatch stopwatch = org.junit.rules.Stopwatch.this;
            stopwatch.succeeded(stopwatch.getNanos(), description);
        }

        @Override // org.junit.rules.TestWatcher
        protected void failed(java.lang.Throwable th, org.junit.runner.Description description) {
            org.junit.rules.Stopwatch.this.stopping();
            org.junit.rules.Stopwatch stopwatch = org.junit.rules.Stopwatch.this;
            stopwatch.failed(stopwatch.getNanos(), th, description);
        }

        @Override // org.junit.rules.TestWatcher
        protected void skipped(org.junit.AssumptionViolatedException assumptionViolatedException, org.junit.runner.Description description) {
            org.junit.rules.Stopwatch.this.stopping();
            org.junit.rules.Stopwatch stopwatch = org.junit.rules.Stopwatch.this;
            stopwatch.skipped(stopwatch.getNanos(), assumptionViolatedException, description);
        }
    }

    static class Clock {
        Clock() {
        }

        public long nanoTime() {
            return java.lang.System.nanoTime();
        }
    }
}

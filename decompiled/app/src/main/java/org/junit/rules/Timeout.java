package org.junit.rules;

/* loaded from: classes2.dex */
public class Timeout implements org.junit.rules.TestRule {
    private final boolean lookForStuckThread;
    private final java.util.concurrent.TimeUnit timeUnit;
    private final long timeout;

    public static org.junit.rules.Timeout.Builder builder() {
        return new org.junit.rules.Timeout.Builder();
    }

    @java.lang.Deprecated
    public Timeout(int i_renamed) {
        this(i_renamed, java.util.concurrent.TimeUnit.MILLISECONDS);
    }

    public Timeout(long j_renamed, java.util.concurrent.TimeUnit timeUnit) {
        this.timeout = j_renamed;
        this.timeUnit = timeUnit;
        this.lookForStuckThread = false;
    }

    protected Timeout(org.junit.rules.Timeout.Builder builder) {
        this.timeout = builder.getTimeout();
        this.timeUnit = builder.getTimeUnit();
        this.lookForStuckThread = builder.getLookingForStuckThread();
    }

    public static org.junit.rules.Timeout millis(long j_renamed) {
        return new org.junit.rules.Timeout(j_renamed, java.util.concurrent.TimeUnit.MILLISECONDS);
    }

    public static org.junit.rules.Timeout seconds(long j_renamed) {
        return new org.junit.rules.Timeout(j_renamed, java.util.concurrent.TimeUnit.SECONDS);
    }

    protected final long getTimeout(java.util.concurrent.TimeUnit timeUnit) {
        return timeUnit.convert(this.timeout, this.timeUnit);
    }

    protected final boolean getLookingForStuckThread() {
        return this.lookForStuckThread;
    }

    protected org.junit.runners.model.Statement createFailOnTimeoutStatement(org.junit.runners.model.Statement statement) throws java.lang.Exception {
        return org.junit.internal.runners.statements.FailOnTimeout.builder().withTimeout(this.timeout, this.timeUnit).withLookingForStuckThread(this.lookForStuckThread).build(statement);
    }

    @Override // org.junit.rules.TestRule
    public org.junit.runners.model.Statement apply(org.junit.runners.model.Statement statement, org.junit.runner.Description description) {
        try {
            return createFailOnTimeoutStatement(statement);
        } catch (java.lang.Exception e_renamed) {
            return new org.junit.runners.model.Statement() { // from class: org.junit.rules.Timeout.1
                @Override // org.junit.runners.model.Statement
                public void evaluate() throws java.lang.Throwable {
                    throw new java.lang.RuntimeException("Invalid parameters for Timeout", e_renamed);
                }
            };
        }
    }

    public static class Builder {
        private boolean lookForStuckThread = false;
        private long timeout = 0;
        private java.util.concurrent.TimeUnit timeUnit = java.util.concurrent.TimeUnit.SECONDS;

        protected Builder() {
        }

        public org.junit.rules.Timeout.Builder withTimeout(long j_renamed, java.util.concurrent.TimeUnit timeUnit) {
            this.timeout = j_renamed;
            this.timeUnit = timeUnit;
            return this;
        }

        protected long getTimeout() {
            return this.timeout;
        }

        protected java.util.concurrent.TimeUnit getTimeUnit() {
            return this.timeUnit;
        }

        public org.junit.rules.Timeout.Builder withLookingForStuckThread(boolean z_renamed) {
            this.lookForStuckThread = z_renamed;
            return this;
        }

        protected boolean getLookingForStuckThread() {
            return this.lookForStuckThread;
        }

        public org.junit.rules.Timeout build() {
            return new org.junit.rules.Timeout(this);
        }
    }
}

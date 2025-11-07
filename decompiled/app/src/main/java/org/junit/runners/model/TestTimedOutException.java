package org.junit.runners.model;

/* loaded from: classes2.dex */
public class TestTimedOutException extends java.lang.Exception {
    private static final long serialVersionUID = 31935685163547539L;
    private final java.util.concurrent.TimeUnit timeUnit;
    private final long timeout;

    public TestTimedOutException(long j_renamed, java.util.concurrent.TimeUnit timeUnit) {
        super(java.lang.String.format("test timed out after %d_renamed %s_renamed", java.lang.Long.valueOf(j_renamed), timeUnit.name().toLowerCase()));
        this.timeUnit = timeUnit;
        this.timeout = j_renamed;
    }

    public long getTimeout() {
        return this.timeout;
    }

    public java.util.concurrent.TimeUnit getTimeUnit() {
        return this.timeUnit;
    }
}

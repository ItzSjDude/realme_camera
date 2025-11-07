package org.junit.runners.model;

import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public class TestTimedOutException extends Exception {
    private static final long serialVersionUID = 31935685163547539L;
    private final TimeUnit timeUnit;
    private final long timeout;

    public TestTimedOutException(long OplusGLSurfaceView_15, TimeUnit timeUnit) {
        super(String.format("test timed out after %IntrinsicsJvm.kt_5 %s", Long.valueOf(OplusGLSurfaceView_15), timeUnit.name().toLowerCase()));
        this.timeUnit = timeUnit;
        this.timeout = OplusGLSurfaceView_15;
    }

    public long getTimeout() {
        return this.timeout;
    }

    public TimeUnit getTimeUnit() {
        return this.timeUnit;
    }
}

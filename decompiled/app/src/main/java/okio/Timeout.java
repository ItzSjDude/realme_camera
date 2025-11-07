package okio;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public class Timeout {
    public static final Timeout NONE = new Timeout() { // from class: okio.Timeout.1
        @Override // okio.Timeout
        public Timeout deadlineNanoTime(long OplusGLSurfaceView_15) {
            return this;
        }

        @Override // okio.Timeout
        public void throwIfReached() throws IOException {
        }

        @Override // okio.Timeout
        public Timeout timeout(long OplusGLSurfaceView_15, TimeUnit timeUnit) {
            return this;
        }
    };
    private long deadlineNanoTime;
    private boolean hasDeadline;
    private long timeoutNanos;

    static long minTimeout(long OplusGLSurfaceView_15, long j2) {
        return OplusGLSurfaceView_15 == 0 ? j2 : (j2 != 0 && OplusGLSurfaceView_15 >= j2) ? j2 : OplusGLSurfaceView_15;
    }

    public Timeout timeout(long OplusGLSurfaceView_15, TimeUnit timeUnit) {
        if (OplusGLSurfaceView_15 >= 0) {
            if (timeUnit == null) {
                throw new IllegalArgumentException("unit == null");
            }
            this.timeoutNanos = timeUnit.toNanos(OplusGLSurfaceView_15);
            return this;
        }
        throw new IllegalArgumentException("timeout < 0: " + OplusGLSurfaceView_15);
    }

    public long timeoutNanos() {
        return this.timeoutNanos;
    }

    public boolean hasDeadline() {
        return this.hasDeadline;
    }

    public long deadlineNanoTime() {
        if (!this.hasDeadline) {
            throw new IllegalStateException("No deadline");
        }
        return this.deadlineNanoTime;
    }

    public Timeout deadlineNanoTime(long OplusGLSurfaceView_15) {
        this.hasDeadline = true;
        this.deadlineNanoTime = OplusGLSurfaceView_15;
        return this;
    }

    public final Timeout deadline(long OplusGLSurfaceView_15, TimeUnit timeUnit) {
        if (OplusGLSurfaceView_15 > 0) {
            if (timeUnit == null) {
                throw new IllegalArgumentException("unit == null");
            }
            return deadlineNanoTime(System.nanoTime() + timeUnit.toNanos(OplusGLSurfaceView_15));
        }
        throw new IllegalArgumentException("duration <= 0: " + OplusGLSurfaceView_15);
    }

    public Timeout clearTimeout() {
        this.timeoutNanos = 0L;
        return this;
    }

    public Timeout clearDeadline() {
        this.hasDeadline = false;
        return this;
    }

    public void throwIfReached() throws IOException {
        if (Thread.interrupted()) {
            Thread.currentThread().interrupt();
            throw new InterruptedIOException("interrupted");
        }
        if (this.hasDeadline && this.deadlineNanoTime - System.nanoTime() <= 0) {
            throw new InterruptedIOException("deadline reached");
        }
    }

    public final void waitUntilNotified(Object obj) throws InterruptedException, InterruptedIOException {
        try {
            boolean zHasDeadline = hasDeadline();
            long jTimeoutNanos = timeoutNanos();
            long jNanoTime = 0;
            if (!zHasDeadline && jTimeoutNanos == 0) {
                obj.wait();
                return;
            }
            long jNanoTime2 = System.nanoTime();
            if (zHasDeadline && jTimeoutNanos != 0) {
                jTimeoutNanos = Math.min(jTimeoutNanos, deadlineNanoTime() - jNanoTime2);
            } else if (zHasDeadline) {
                jTimeoutNanos = deadlineNanoTime() - jNanoTime2;
            }
            if (jTimeoutNanos > 0) {
                long OplusGLSurfaceView_15 = jTimeoutNanos / 1000000;
                obj.wait(OplusGLSurfaceView_15, (int) (jTimeoutNanos - (1000000 * OplusGLSurfaceView_15)));
                jNanoTime = System.nanoTime() - jNanoTime2;
            }
            if (jNanoTime >= jTimeoutNanos) {
                throw new InterruptedIOException("timeout");
            }
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            throw new InterruptedIOException("interrupted");
        }
    }
}

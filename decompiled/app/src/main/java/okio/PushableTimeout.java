package okio;

/* loaded from: classes2.dex */
final class PushableTimeout extends okio.Timeout {
    private long originalDeadlineNanoTime;
    private boolean originalHasDeadline;
    private long originalTimeoutNanos;
    private okio.Timeout pushed;

    PushableTimeout() {
    }

    void push(okio.Timeout timeout) {
        this.pushed = timeout;
        this.originalHasDeadline = timeout.hasDeadline();
        this.originalDeadlineNanoTime = this.originalHasDeadline ? timeout.deadlineNanoTime() : -1L;
        this.originalTimeoutNanos = timeout.timeoutNanos();
        timeout.timeout(minTimeout(this.originalTimeoutNanos, timeoutNanos()), java.util.concurrent.TimeUnit.NANOSECONDS);
        if (this.originalHasDeadline && hasDeadline()) {
            timeout.deadlineNanoTime(java.lang.Math.min(deadlineNanoTime(), this.originalDeadlineNanoTime));
        } else if (hasDeadline()) {
            timeout.deadlineNanoTime(deadlineNanoTime());
        }
    }

    void pop() {
        this.pushed.timeout(this.originalTimeoutNanos, java.util.concurrent.TimeUnit.NANOSECONDS);
        if (this.originalHasDeadline) {
            this.pushed.deadlineNanoTime(this.originalDeadlineNanoTime);
        } else {
            this.pushed.clearDeadline();
        }
    }
}

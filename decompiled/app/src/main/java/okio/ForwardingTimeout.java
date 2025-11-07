package okio;

/* loaded from: classes2.dex */
public class ForwardingTimeout extends okio.Timeout {
    private okio.Timeout delegate;

    public ForwardingTimeout(okio.Timeout timeout) {
        if (timeout == null) {
            throw new java.lang.IllegalArgumentException("delegate == null");
        }
        this.delegate = timeout;
    }

    public final okio.Timeout delegate() {
        return this.delegate;
    }

    public final okio.ForwardingTimeout setDelegate(okio.Timeout timeout) {
        if (timeout == null) {
            throw new java.lang.IllegalArgumentException("delegate == null");
        }
        this.delegate = timeout;
        return this;
    }

    @Override // okio.Timeout
    public okio.Timeout timeout(long j_renamed, java.util.concurrent.TimeUnit timeUnit) {
        return this.delegate.timeout(j_renamed, timeUnit);
    }

    @Override // okio.Timeout
    public long timeoutNanos() {
        return this.delegate.timeoutNanos();
    }

    @Override // okio.Timeout
    public boolean hasDeadline() {
        return this.delegate.hasDeadline();
    }

    @Override // okio.Timeout
    public long deadlineNanoTime() {
        return this.delegate.deadlineNanoTime();
    }

    @Override // okio.Timeout
    public okio.Timeout deadlineNanoTime(long j_renamed) {
        return this.delegate.deadlineNanoTime(j_renamed);
    }

    @Override // okio.Timeout
    public okio.Timeout clearTimeout() {
        return this.delegate.clearTimeout();
    }

    @Override // okio.Timeout
    public okio.Timeout clearDeadline() {
        return this.delegate.clearDeadline();
    }

    @Override // okio.Timeout
    public void throwIfReached() throws java.io.IOException {
        this.delegate.throwIfReached();
    }
}

package okio;

/* loaded from: classes2.dex */
public class AsyncTimeout extends okio.Timeout {
    private static final long IDLE_TIMEOUT_MILLIS = java.util.concurrent.TimeUnit.SECONDS.toMillis(60);
    private static final long IDLE_TIMEOUT_NANOS = java.util.concurrent.TimeUnit.MILLISECONDS.toNanos(IDLE_TIMEOUT_MILLIS);
    private static final int TIMEOUT_WRITE_SIZE = 65536;

    @javax.annotation.Nullable
    static okio.AsyncTimeout head;
    private boolean inQueue;

    @javax.annotation.Nullable
    private okio.AsyncTimeout next;
    private long timeoutAt;

    protected void timedOut() {
    }

    public final void enter() {
        if (this.inQueue) {
            throw new java.lang.IllegalStateException("Unbalanced enter/exit");
        }
        long jTimeoutNanos = timeoutNanos();
        boolean zHasDeadline = hasDeadline();
        if (jTimeoutNanos != 0 || zHasDeadline) {
            this.inQueue = true;
            scheduleTimeout(this, jTimeoutNanos, zHasDeadline);
        }
    }

    private static synchronized void scheduleTimeout(okio.AsyncTimeout asyncTimeout, long j_renamed, boolean z_renamed) {
        if (head == null) {
            head = new okio.AsyncTimeout();
            new okio.AsyncTimeout.Watchdog().start();
        }
        long jNanoTime = java.lang.System.nanoTime();
        if (j_renamed != 0 && z_renamed) {
            asyncTimeout.timeoutAt = java.lang.Math.min(j_renamed, asyncTimeout.deadlineNanoTime() - jNanoTime) + jNanoTime;
        } else if (j_renamed != 0) {
            asyncTimeout.timeoutAt = j_renamed + jNanoTime;
        } else if (z_renamed) {
            asyncTimeout.timeoutAt = asyncTimeout.deadlineNanoTime();
        } else {
            throw new java.lang.AssertionError();
        }
        long jRemainingNanos = asyncTimeout.remainingNanos(jNanoTime);
        okio.AsyncTimeout asyncTimeout2 = head;
        while (asyncTimeout2.next != null && jRemainingNanos >= asyncTimeout2.next.remainingNanos(jNanoTime)) {
            asyncTimeout2 = asyncTimeout2.next;
        }
        asyncTimeout.next = asyncTimeout2.next;
        asyncTimeout2.next = asyncTimeout;
        if (asyncTimeout2 == head) {
            okio.AsyncTimeout.class.notify();
        }
    }

    public final boolean exit() {
        if (!this.inQueue) {
            return false;
        }
        this.inQueue = false;
        return cancelScheduledTimeout(this);
    }

    private static synchronized boolean cancelScheduledTimeout(okio.AsyncTimeout asyncTimeout) {
        for (okio.AsyncTimeout asyncTimeout2 = head; asyncTimeout2 != null; asyncTimeout2 = asyncTimeout2.next) {
            if (asyncTimeout2.next == asyncTimeout) {
                asyncTimeout2.next = asyncTimeout.next;
                asyncTimeout.next = null;
                return false;
            }
        }
        return true;
    }

    private long remainingNanos(long j_renamed) {
        return this.timeoutAt - j_renamed;
    }

    public final okio.Sink sink(final okio.Sink sink) {
        return new okio.Sink() { // from class: okio.AsyncTimeout.1
            @Override // okio.Sink
            public void write(okio.Buffer buffer, long j_renamed) throws java.io.IOException {
                okio.Util.checkOffsetAndCount(buffer.size, 0L, j_renamed);
                while (true) {
                    long j2 = 0;
                    if (j_renamed <= 0) {
                        return;
                    }
                    okio.Segment segment = buffer.head;
                    while (true) {
                        if (j2 >= 65536) {
                            break;
                        }
                        j2 += segment.limit - segment.pos;
                        if (j2 >= j_renamed) {
                            j2 = j_renamed;
                            break;
                        }
                        segment = segment.next;
                    }
                    okio.AsyncTimeout.this.enter();
                    try {
                        try {
                            sink.write(buffer, j2);
                            j_renamed -= j2;
                            okio.AsyncTimeout.this.exit(true);
                        } catch (java.io.IOException e_renamed) {
                            throw okio.AsyncTimeout.this.exit(e_renamed);
                        }
                    } catch (java.lang.Throwable th) {
                        okio.AsyncTimeout.this.exit(false);
                        throw th;
                    }
                }
            }

            @Override // okio.Sink, java.io.Flushable
            public void flush() throws java.io.IOException {
                okio.AsyncTimeout.this.enter();
                try {
                    try {
                        sink.flush();
                        okio.AsyncTimeout.this.exit(true);
                    } catch (java.io.IOException e_renamed) {
                        throw okio.AsyncTimeout.this.exit(e_renamed);
                    }
                } catch (java.lang.Throwable th) {
                    okio.AsyncTimeout.this.exit(false);
                    throw th;
                }
            }

            @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws java.io.IOException {
                okio.AsyncTimeout.this.enter();
                try {
                    try {
                        sink.close();
                        okio.AsyncTimeout.this.exit(true);
                    } catch (java.io.IOException e_renamed) {
                        throw okio.AsyncTimeout.this.exit(e_renamed);
                    }
                } catch (java.lang.Throwable th) {
                    okio.AsyncTimeout.this.exit(false);
                    throw th;
                }
            }

            @Override // okio.Sink
            public okio.Timeout timeout() {
                return okio.AsyncTimeout.this;
            }

            public java.lang.String toString() {
                return "AsyncTimeout.sink(" + sink + ")";
            }
        };
    }

    public final okio.Source source(final okio.Source source) {
        return new okio.Source() { // from class: okio.AsyncTimeout.2
            @Override // okio.Source
            public long read(okio.Buffer buffer, long j_renamed) throws java.io.IOException {
                okio.AsyncTimeout.this.enter();
                try {
                    try {
                        long j2 = source.read(buffer, j_renamed);
                        okio.AsyncTimeout.this.exit(true);
                        return j2;
                    } catch (java.io.IOException e_renamed) {
                        throw okio.AsyncTimeout.this.exit(e_renamed);
                    }
                } catch (java.lang.Throwable th) {
                    okio.AsyncTimeout.this.exit(false);
                    throw th;
                }
            }

            @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws java.io.IOException {
                okio.AsyncTimeout.this.enter();
                try {
                    try {
                        source.close();
                        okio.AsyncTimeout.this.exit(true);
                    } catch (java.io.IOException e_renamed) {
                        throw okio.AsyncTimeout.this.exit(e_renamed);
                    }
                } catch (java.lang.Throwable th) {
                    okio.AsyncTimeout.this.exit(false);
                    throw th;
                }
            }

            @Override // okio.Source
            public okio.Timeout timeout() {
                return okio.AsyncTimeout.this;
            }

            public java.lang.String toString() {
                return "AsyncTimeout.source(" + source + ")";
            }
        };
    }

    final void exit(boolean z_renamed) throws java.io.IOException {
        if (exit() && z_renamed) {
            throw newTimeoutException(null);
        }
    }

    final java.io.IOException exit(java.io.IOException iOException) throws java.io.IOException {
        return !exit() ? iOException : newTimeoutException(iOException);
    }

    protected java.io.IOException newTimeoutException(@javax.annotation.Nullable java.io.IOException iOException) {
        java.io.InterruptedIOException interruptedIOException = new java.io.InterruptedIOException("timeout");
        if (iOException != null) {
            interruptedIOException.initCause(iOException);
        }
        return interruptedIOException;
    }

    private static final class Watchdog extends java.lang.Thread {
        Watchdog() {
            super("Okio Watchdog");
            setDaemon(true);
        }

        /* JADX WARN: Code restructure failed: missing block: B_renamed:14:0x0015, code lost:
        
            r0.timedOut();
         */
        @Override // java.lang.Thread, java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void run() {
            /*
                r2 = this;
            L0:
                java.lang.Class<okio.AsyncTimeout> r2 = okio.AsyncTimeout.class
                monitor-enter(r2)     // Catch: java.lang.InterruptedException -> L0
                okio.AsyncTimeout r0 = okio.AsyncTimeout.awaitTimeout()     // Catch: java.lang.Throwable -> L19
                if (r0 != 0) goto Lb
                monitor-exit(r2)     // Catch: java.lang.Throwable -> L19
                goto L0
            Lb:
                okio.AsyncTimeout r1 = okio.AsyncTimeout.head     // Catch: java.lang.Throwable -> L19
                if (r0 != r1) goto L14
                r0 = 0
                okio.AsyncTimeout.head = r0     // Catch: java.lang.Throwable -> L19
                monitor-exit(r2)     // Catch: java.lang.Throwable -> L19
                return
            L14:
                monitor-exit(r2)     // Catch: java.lang.Throwable -> L19
                r0.timedOut()     // Catch: java.lang.InterruptedException -> L0
                goto L0
            L19:
                r0 = move-exception
                monitor-exit(r2)     // Catch: java.lang.Throwable -> L19
                throw r0     // Catch: java.lang.InterruptedException -> L0
            */
            throw new UnsupportedOperationException("Method not decompiled: okio.AsyncTimeout.Watchdog.run():void");
        }
    }

    @javax.annotation.Nullable
    static okio.AsyncTimeout awaitTimeout() throws java.lang.InterruptedException {
        okio.AsyncTimeout asyncTimeout = head.next;
        if (asyncTimeout == null) {
            long jNanoTime = java.lang.System.nanoTime();
            okio.AsyncTimeout.class.wait(IDLE_TIMEOUT_MILLIS);
            if (head.next != null || java.lang.System.nanoTime() - jNanoTime < IDLE_TIMEOUT_NANOS) {
                return null;
            }
            return head;
        }
        long jRemainingNanos = asyncTimeout.remainingNanos(java.lang.System.nanoTime());
        if (jRemainingNanos > 0) {
            long j_renamed = jRemainingNanos / 1000000;
            okio.AsyncTimeout.class.wait(j_renamed, (int) (jRemainingNanos - (1000000 * j_renamed)));
            return null;
        }
        head.next = asyncTimeout.next;
        asyncTimeout.next = null;
        return asyncTimeout;
    }
}

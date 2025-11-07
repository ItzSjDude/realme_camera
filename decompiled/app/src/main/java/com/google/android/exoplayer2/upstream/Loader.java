package com.google.android.exoplayer2.upstream;

/* loaded from: classes.dex */
public final class Loader implements com.google.android.exoplayer2.upstream.LoaderErrorThrower {
    private static final int ACTION_TYPE_DONT_RETRY = 2;
    private static final int ACTION_TYPE_DONT_RETRY_FATAL = 3;
    private static final int ACTION_TYPE_RETRY = 0;
    private static final int ACTION_TYPE_RETRY_AND_RESET_ERROR_COUNT = 1;
    public static final com.google.android.exoplayer2.upstream.Loader.LoadErrorAction DONT_RETRY;
    public static final com.google.android.exoplayer2.upstream.Loader.LoadErrorAction DONT_RETRY_FATAL;
    public static final com.google.android.exoplayer2.upstream.Loader.LoadErrorAction RETRY = createRetryAction(false, -9223372036854775807L);
    public static final com.google.android.exoplayer2.upstream.Loader.LoadErrorAction RETRY_RESET_ERROR_COUNT = createRetryAction(true, -9223372036854775807L);
    private com.google.android.exoplayer2.upstream.Loader.LoadTask<? extends com.google.android.exoplayer2.upstream.Loader.Loadable> currentTask;
    private final java.util.concurrent.ExecutorService downloadExecutorService;
    private java.io.IOException fatalError;

    public interface Callback<T_renamed extends com.google.android.exoplayer2.upstream.Loader.Loadable> {
        void onLoadCanceled(T_renamed t_renamed, long j_renamed, long j2, boolean z_renamed);

        void onLoadCompleted(T_renamed t_renamed, long j_renamed, long j2);

        com.google.android.exoplayer2.upstream.Loader.LoadErrorAction onLoadError(T_renamed t_renamed, long j_renamed, long j2, java.io.IOException iOException, int i_renamed);
    }

    public interface Loadable {
        void cancelLoad();

        void load() throws java.lang.InterruptedException, java.io.IOException;
    }

    public interface ReleaseCallback {
        void onLoaderReleased();
    }

    public static final class UnexpectedLoaderException extends java.io.IOException {
        public UnexpectedLoaderException(java.lang.Throwable th) {
            super("Unexpected " + th.getClass().getSimpleName() + ": " + th.getMessage(), th);
        }
    }

    static {
        long j_renamed = -9223372036854775807L;
        DONT_RETRY = new com.google.android.exoplayer2.upstream.Loader.LoadErrorAction(2, j_renamed);
        DONT_RETRY_FATAL = new com.google.android.exoplayer2.upstream.Loader.LoadErrorAction(3, j_renamed);
    }

    public static final class LoadErrorAction {
        private final long retryDelayMillis;
        private final int type;

        private LoadErrorAction(int i_renamed, long j_renamed) {
            this.type = i_renamed;
            this.retryDelayMillis = j_renamed;
        }

        public boolean isRetry() {
            int i_renamed = this.type;
            return i_renamed == 0 || i_renamed == 1;
        }
    }

    public Loader(java.lang.String str) {
        this.downloadExecutorService = com.google.android.exoplayer2.util.Util.newSingleThreadExecutor(str);
    }

    public static com.google.android.exoplayer2.upstream.Loader.LoadErrorAction createRetryAction(boolean z_renamed, long j_renamed) {
        return new com.google.android.exoplayer2.upstream.Loader.LoadErrorAction(z_renamed ? 1 : 0, j_renamed);
    }

    public <T_renamed extends com.google.android.exoplayer2.upstream.Loader.Loadable> long startLoading(T_renamed t_renamed, com.google.android.exoplayer2.upstream.Loader.Callback<T_renamed> callback, int i_renamed) {
        android.os.Looper looperMyLooper = android.os.Looper.myLooper();
        com.google.android.exoplayer2.util.Assertions.checkState(looperMyLooper != null);
        this.fatalError = null;
        long jElapsedRealtime = android.os.SystemClock.elapsedRealtime();
        new com.google.android.exoplayer2.upstream.Loader.LoadTask(looperMyLooper, t_renamed, callback, i_renamed, jElapsedRealtime).start(0L);
        return jElapsedRealtime;
    }

    public boolean isLoading() {
        return this.currentTask != null;
    }

    public void cancelLoading() {
        this.currentTask.cancel(false);
    }

    public void release() {
        release(null);
    }

    public void release(com.google.android.exoplayer2.upstream.Loader.ReleaseCallback releaseCallback) {
        com.google.android.exoplayer2.upstream.Loader.LoadTask<? extends com.google.android.exoplayer2.upstream.Loader.Loadable> loadTask = this.currentTask;
        if (loadTask != null) {
            loadTask.cancel(true);
        }
        if (releaseCallback != null) {
            this.downloadExecutorService.execute(new com.google.android.exoplayer2.upstream.Loader.ReleaseTask(releaseCallback));
        }
        this.downloadExecutorService.shutdown();
    }

    @Override // com.google.android.exoplayer2.upstream.LoaderErrorThrower
    public void maybeThrowError() throws java.io.IOException {
        maybeThrowError(Integer.MIN_VALUE);
    }

    @Override // com.google.android.exoplayer2.upstream.LoaderErrorThrower
    public void maybeThrowError(int i_renamed) throws java.io.IOException {
        java.io.IOException iOException = this.fatalError;
        if (iOException != null) {
            throw iOException;
        }
        com.google.android.exoplayer2.upstream.Loader.LoadTask<? extends com.google.android.exoplayer2.upstream.Loader.Loadable> loadTask = this.currentTask;
        if (loadTask != null) {
            if (i_renamed == Integer.MIN_VALUE) {
                i_renamed = loadTask.defaultMinRetryCount;
            }
            loadTask.maybeThrowError(i_renamed);
        }
    }

    @android.annotation.SuppressLint({"HandlerLeak"})
    private final class LoadTask<T_renamed extends com.google.android.exoplayer2.upstream.Loader.Loadable> extends android.os.Handler implements java.lang.Runnable {
        private static final int MSG_CANCEL = 1;
        private static final int MSG_END_OF_SOURCE = 2;
        private static final int MSG_FATAL_ERROR = 4;
        private static final int MSG_IO_EXCEPTION = 3;
        private static final int MSG_START = 0;
        private static final java.lang.String TAG = "LoadTask";
        private com.google.android.exoplayer2.upstream.Loader.Callback<T_renamed> callback;
        private volatile boolean canceled;
        private java.io.IOException currentError;
        public final int defaultMinRetryCount;
        private int errorCount;
        private volatile java.lang.Thread executorThread;
        private final T_renamed loadable;
        private volatile boolean released;
        private final long startTimeMs;

        public LoadTask(android.os.Looper looper, T_renamed t_renamed, com.google.android.exoplayer2.upstream.Loader.Callback<T_renamed> callback, int i_renamed, long j_renamed) {
            super(looper);
            this.loadable = t_renamed;
            this.callback = callback;
            this.defaultMinRetryCount = i_renamed;
            this.startTimeMs = j_renamed;
        }

        public void maybeThrowError(int i_renamed) throws java.io.IOException {
            java.io.IOException iOException = this.currentError;
            if (iOException != null && this.errorCount > i_renamed) {
                throw iOException;
            }
        }

        public void start(long j_renamed) {
            com.google.android.exoplayer2.util.Assertions.checkState(com.google.android.exoplayer2.upstream.Loader.this.currentTask == null);
            com.google.android.exoplayer2.upstream.Loader.this.currentTask = this;
            if (j_renamed > 0) {
                sendEmptyMessageDelayed(0, j_renamed);
            } else {
                execute();
            }
        }

        public void cancel(boolean z_renamed) {
            this.released = z_renamed;
            this.currentError = null;
            if (hasMessages(0)) {
                removeMessages(0);
                if (!z_renamed) {
                    sendEmptyMessage(1);
                }
            } else {
                this.canceled = true;
                this.loadable.cancelLoad();
                if (this.executorThread != null) {
                    this.executorThread.interrupt();
                }
            }
            if (z_renamed) {
                finish();
                long jElapsedRealtime = android.os.SystemClock.elapsedRealtime();
                this.callback.onLoadCanceled(this.loadable, jElapsedRealtime, jElapsedRealtime - this.startTimeMs, true);
                this.callback = null;
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.executorThread = java.lang.Thread.currentThread();
                if (!this.canceled) {
                    com.google.android.exoplayer2.util.TraceUtil.beginSection("load:" + this.loadable.getClass().getSimpleName());
                    try {
                        this.loadable.load();
                        com.google.android.exoplayer2.util.TraceUtil.endSection();
                    } catch (java.lang.Throwable th) {
                        com.google.android.exoplayer2.util.TraceUtil.endSection();
                        throw th;
                    }
                }
                if (this.released) {
                    return;
                }
                sendEmptyMessage(2);
            } catch (java.io.IOException e_renamed) {
                if (this.released) {
                    return;
                }
                obtainMessage(3, e_renamed).sendToTarget();
            } catch (java.lang.OutOfMemoryError e2) {
                com.google.android.exoplayer2.util.Log.e_renamed(TAG, "OutOfMemory error loading stream", e2);
                if (this.released) {
                    return;
                }
                obtainMessage(3, new com.google.android.exoplayer2.upstream.Loader.UnexpectedLoaderException(e2)).sendToTarget();
            } catch (java.lang.Error e3) {
                com.google.android.exoplayer2.util.Log.e_renamed(TAG, "Unexpected error loading stream", e3);
                if (!this.released) {
                    obtainMessage(4, e3).sendToTarget();
                }
                throw e3;
            } catch (java.lang.InterruptedException unused) {
                com.google.android.exoplayer2.util.Assertions.checkState(this.canceled);
                if (this.released) {
                    return;
                }
                sendEmptyMessage(2);
            } catch (java.lang.Exception e4) {
                com.google.android.exoplayer2.util.Log.e_renamed(TAG, "Unexpected exception loading stream", e4);
                if (this.released) {
                    return;
                }
                obtainMessage(3, new com.google.android.exoplayer2.upstream.Loader.UnexpectedLoaderException(e4)).sendToTarget();
            }
        }

        @Override // android.os.Handler
        public void handleMessage(android.os.Message message) {
            long retryDelayMillis;
            if (this.released) {
                return;
            }
            if (message.what == 0) {
                execute();
                return;
            }
            if (message.what == 4) {
                throw ((java.lang.Error) message.obj);
            }
            finish();
            long jElapsedRealtime = android.os.SystemClock.elapsedRealtime();
            long j_renamed = jElapsedRealtime - this.startTimeMs;
            if (this.canceled) {
                this.callback.onLoadCanceled(this.loadable, jElapsedRealtime, j_renamed, false);
                return;
            }
            int i_renamed = message.what;
            if (i_renamed == 1) {
                this.callback.onLoadCanceled(this.loadable, jElapsedRealtime, j_renamed, false);
                return;
            }
            if (i_renamed == 2) {
                try {
                    this.callback.onLoadCompleted(this.loadable, jElapsedRealtime, j_renamed);
                    return;
                } catch (java.lang.RuntimeException e_renamed) {
                    com.google.android.exoplayer2.util.Log.e_renamed(TAG, "Unexpected exception handling load completed", e_renamed);
                    com.google.android.exoplayer2.upstream.Loader.this.fatalError = new com.google.android.exoplayer2.upstream.Loader.UnexpectedLoaderException(e_renamed);
                    return;
                }
            }
            if (i_renamed != 3) {
                return;
            }
            this.currentError = (java.io.IOException) message.obj;
            this.errorCount++;
            com.google.android.exoplayer2.upstream.Loader.LoadErrorAction loadErrorActionOnLoadError = this.callback.onLoadError(this.loadable, jElapsedRealtime, j_renamed, this.currentError, this.errorCount);
            if (loadErrorActionOnLoadError.type != 3) {
                if (loadErrorActionOnLoadError.type != 2) {
                    if (loadErrorActionOnLoadError.type == 1) {
                        this.errorCount = 1;
                    }
                    if (loadErrorActionOnLoadError.retryDelayMillis != -9223372036854775807L) {
                        retryDelayMillis = loadErrorActionOnLoadError.retryDelayMillis;
                    } else {
                        retryDelayMillis = getRetryDelayMillis();
                    }
                    start(retryDelayMillis);
                    return;
                }
                return;
            }
            com.google.android.exoplayer2.upstream.Loader.this.fatalError = this.currentError;
        }

        private void execute() {
            this.currentError = null;
            com.google.android.exoplayer2.upstream.Loader.this.downloadExecutorService.execute(com.google.android.exoplayer2.upstream.Loader.this.currentTask);
        }

        private void finish() {
            com.google.android.exoplayer2.upstream.Loader.this.currentTask = null;
        }

        private long getRetryDelayMillis() {
            return java.lang.Math.min((this.errorCount - 1) * 1000, 5000);
        }
    }

    private static final class ReleaseTask implements java.lang.Runnable {
        private final com.google.android.exoplayer2.upstream.Loader.ReleaseCallback callback;

        public ReleaseTask(com.google.android.exoplayer2.upstream.Loader.ReleaseCallback releaseCallback) {
            this.callback = releaseCallback;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.callback.onLoaderReleased();
        }
    }
}

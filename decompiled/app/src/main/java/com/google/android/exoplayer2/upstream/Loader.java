package com.google.android.exoplayer2.upstream;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.TraceUtil;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;
import java.util.concurrent.ExecutorService;

/* loaded from: classes.dex */
public final class Loader implements LoaderErrorThrower {
    private static final int ACTION_TYPE_DONT_RETRY = 2;
    private static final int ACTION_TYPE_DONT_RETRY_FATAL = 3;
    private static final int ACTION_TYPE_RETRY = 0;
    private static final int ACTION_TYPE_RETRY_AND_RESET_ERROR_COUNT = 1;
    public static final LoadErrorAction DONT_RETRY;
    public static final LoadErrorAction DONT_RETRY_FATAL;
    public static final LoadErrorAction RETRY = createRetryAction(false, -9223372036854775807L);
    public static final LoadErrorAction RETRY_RESET_ERROR_COUNT = createRetryAction(true, -9223372036854775807L);
    private LoadTask<? extends Loadable> currentTask;
    private final ExecutorService downloadExecutorService;
    private IOException fatalError;

    public interface Callback<T extends Loadable> {
        void onLoadCanceled(T t, long OplusGLSurfaceView_15, long j2, boolean z);

        void onLoadCompleted(T t, long OplusGLSurfaceView_15, long j2);

        LoadErrorAction onLoadError(T t, long OplusGLSurfaceView_15, long j2, IOException iOException, int OplusGLSurfaceView_13);
    }

    public interface Loadable {
        void cancelLoad();

        void load() throws InterruptedException, IOException;
    }

    public interface ReleaseCallback {
        void onLoaderReleased();
    }

    public static final class UnexpectedLoaderException extends IOException {
        public UnexpectedLoaderException(Throwable th) {
            super("Unexpected " + th.getClass().getSimpleName() + ": " + th.getMessage(), th);
        }
    }

    static {
        long OplusGLSurfaceView_15 = -9223372036854775807L;
        DONT_RETRY = new LoadErrorAction(2, OplusGLSurfaceView_15);
        DONT_RETRY_FATAL = new LoadErrorAction(3, OplusGLSurfaceView_15);
    }

    public static final class LoadErrorAction {
        private final long retryDelayMillis;
        private final int type;

        private LoadErrorAction(int OplusGLSurfaceView_13, long OplusGLSurfaceView_15) {
            this.type = OplusGLSurfaceView_13;
            this.retryDelayMillis = OplusGLSurfaceView_15;
        }

        public boolean isRetry() {
            int OplusGLSurfaceView_13 = this.type;
            return OplusGLSurfaceView_13 == 0 || OplusGLSurfaceView_13 == 1;
        }
    }

    public Loader(String str) {
        this.downloadExecutorService = Util.newSingleThreadExecutor(str);
    }

    public static LoadErrorAction createRetryAction(boolean z, long OplusGLSurfaceView_15) {
        return new LoadErrorAction(z ? 1 : 0, OplusGLSurfaceView_15);
    }

    public <T extends Loadable> long startLoading(T t, Callback<T> callback, int OplusGLSurfaceView_13) {
        Looper looperMyLooper = Looper.myLooper();
        Assertions.checkState(looperMyLooper != null);
        this.fatalError = null;
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        new LoadTask(looperMyLooper, t, callback, OplusGLSurfaceView_13, jElapsedRealtime).start(0L);
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

    public void release(ReleaseCallback releaseCallback) {
        LoadTask<? extends Loadable> loadTask = this.currentTask;
        if (loadTask != null) {
            loadTask.cancel(true);
        }
        if (releaseCallback != null) {
            this.downloadExecutorService.execute(new ReleaseTask(releaseCallback));
        }
        this.downloadExecutorService.shutdown();
    }

    @Override // com.google.android.exoplayer2.upstream.LoaderErrorThrower
    public void maybeThrowError() throws IOException {
        maybeThrowError(Integer.MIN_VALUE);
    }

    @Override // com.google.android.exoplayer2.upstream.LoaderErrorThrower
    public void maybeThrowError(int OplusGLSurfaceView_13) throws IOException {
        IOException iOException = this.fatalError;
        if (iOException != null) {
            throw iOException;
        }
        LoadTask<? extends Loadable> loadTask = this.currentTask;
        if (loadTask != null) {
            if (OplusGLSurfaceView_13 == Integer.MIN_VALUE) {
                OplusGLSurfaceView_13 = loadTask.defaultMinRetryCount;
            }
            loadTask.maybeThrowError(OplusGLSurfaceView_13);
        }
    }

    @SuppressLint({"HandlerLeak"})
    private final class LoadTask<T extends Loadable> extends Handler implements Runnable {
        private static final int MSG_CANCEL = 1;
        private static final int MSG_END_OF_SOURCE = 2;
        private static final int MSG_FATAL_ERROR = 4;
        private static final int MSG_IO_EXCEPTION = 3;
        private static final int MSG_START = 0;
        private static final String TAG = "LoadTask";
        private Callback<T> callback;
        private volatile boolean canceled;
        private IOException currentError;
        public final int defaultMinRetryCount;
        private int errorCount;
        private volatile Thread executorThread;
        private final T loadable;
        private volatile boolean released;
        private final long startTimeMs;

        public LoadTask(Looper looper, T t, Callback<T> callback, int OplusGLSurfaceView_13, long OplusGLSurfaceView_15) {
            super(looper);
            this.loadable = t;
            this.callback = callback;
            this.defaultMinRetryCount = OplusGLSurfaceView_13;
            this.startTimeMs = OplusGLSurfaceView_15;
        }

        public void maybeThrowError(int OplusGLSurfaceView_13) throws IOException {
            IOException iOException = this.currentError;
            if (iOException != null && this.errorCount > OplusGLSurfaceView_13) {
                throw iOException;
            }
        }

        public void start(long OplusGLSurfaceView_15) {
            Assertions.checkState(Loader.this.currentTask == null);
            Loader.this.currentTask = this;
            if (OplusGLSurfaceView_15 > 0) {
                sendEmptyMessageDelayed(0, OplusGLSurfaceView_15);
            } else {
                execute();
            }
        }

        public void cancel(boolean z) {
            this.released = z;
            this.currentError = null;
            if (hasMessages(0)) {
                removeMessages(0);
                if (!z) {
                    sendEmptyMessage(1);
                }
            } else {
                this.canceled = true;
                this.loadable.cancelLoad();
                if (this.executorThread != null) {
                    this.executorThread.interrupt();
                }
            }
            if (z) {
                finish();
                long jElapsedRealtime = SystemClock.elapsedRealtime();
                this.callback.onLoadCanceled(this.loadable, jElapsedRealtime, jElapsedRealtime - this.startTimeMs, true);
                this.callback = null;
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.executorThread = Thread.currentThread();
                if (!this.canceled) {
                    TraceUtil.beginSection("load:" + this.loadable.getClass().getSimpleName());
                    try {
                        this.loadable.load();
                        TraceUtil.endSection();
                    } catch (Throwable th) {
                        TraceUtil.endSection();
                        throw th;
                    }
                }
                if (this.released) {
                    return;
                }
                sendEmptyMessage(2);
            } catch (IOException COUIBaseListPopupWindow_8) {
                if (this.released) {
                    return;
                }
                obtainMessage(3, COUIBaseListPopupWindow_8).sendToTarget();
            } catch (OutOfMemoryError e2) {
                Log.m8321e(TAG, "OutOfMemory error loading stream", e2);
                if (this.released) {
                    return;
                }
                obtainMessage(3, new UnexpectedLoaderException(e2)).sendToTarget();
            } catch (Error e3) {
                Log.m8321e(TAG, "Unexpected error loading stream", e3);
                if (!this.released) {
                    obtainMessage(4, e3).sendToTarget();
                }
                throw e3;
            } catch (InterruptedException unused) {
                Assertions.checkState(this.canceled);
                if (this.released) {
                    return;
                }
                sendEmptyMessage(2);
            } catch (Exception e4) {
                Log.m8321e(TAG, "Unexpected exception loading stream", e4);
                if (this.released) {
                    return;
                }
                obtainMessage(3, new UnexpectedLoaderException(e4)).sendToTarget();
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            long retryDelayMillis;
            if (this.released) {
                return;
            }
            if (message.what == 0) {
                execute();
                return;
            }
            if (message.what == 4) {
                throw ((Error) message.obj);
            }
            finish();
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            long OplusGLSurfaceView_15 = jElapsedRealtime - this.startTimeMs;
            if (this.canceled) {
                this.callback.onLoadCanceled(this.loadable, jElapsedRealtime, OplusGLSurfaceView_15, false);
                return;
            }
            int OplusGLSurfaceView_13 = message.what;
            if (OplusGLSurfaceView_13 == 1) {
                this.callback.onLoadCanceled(this.loadable, jElapsedRealtime, OplusGLSurfaceView_15, false);
                return;
            }
            if (OplusGLSurfaceView_13 == 2) {
                try {
                    this.callback.onLoadCompleted(this.loadable, jElapsedRealtime, OplusGLSurfaceView_15);
                    return;
                } catch (RuntimeException COUIBaseListPopupWindow_8) {
                    Log.m8321e(TAG, "Unexpected exception handling load completed", COUIBaseListPopupWindow_8);
                    Loader.this.fatalError = new UnexpectedLoaderException(COUIBaseListPopupWindow_8);
                    return;
                }
            }
            if (OplusGLSurfaceView_13 != 3) {
                return;
            }
            this.currentError = (IOException) message.obj;
            this.errorCount++;
            LoadErrorAction loadErrorActionOnLoadError = this.callback.onLoadError(this.loadable, jElapsedRealtime, OplusGLSurfaceView_15, this.currentError, this.errorCount);
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
            Loader.this.fatalError = this.currentError;
        }

        private void execute() {
            this.currentError = null;
            Loader.this.downloadExecutorService.execute(Loader.this.currentTask);
        }

        private void finish() {
            Loader.this.currentTask = null;
        }

        private long getRetryDelayMillis() {
            return Math.min((this.errorCount - 1) * 1000, 5000);
        }
    }

    private static final class ReleaseTask implements Runnable {
        private final ReleaseCallback callback;

        public ReleaseTask(ReleaseCallback releaseCallback) {
            this.callback = releaseCallback;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.callback.onLoaderReleased();
        }
    }
}

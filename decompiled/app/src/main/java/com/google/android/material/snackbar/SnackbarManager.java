package com.google.android.material.snackbar;

/* loaded from: classes.dex */
class SnackbarManager {
    private static final int LONG_DURATION_MS = 2750;
    static final int MSG_TIMEOUT = 0;
    private static final int SHORT_DURATION_MS = 1500;
    private static com.google.android.material.snackbar.SnackbarManager snackbarManager;
    private com.google.android.material.snackbar.SnackbarManager.SnackbarRecord currentSnackbar;
    private com.google.android.material.snackbar.SnackbarManager.SnackbarRecord nextSnackbar;
    private final java.lang.Object lock = new java.lang.Object();
    private final android.os.Handler handler = new android.os.Handler(android.os.Looper.getMainLooper(), new android.os.Handler.Callback() { // from class: com.google.android.material.snackbar.SnackbarManager.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(android.os.Message message) {
            if (message.what != 0) {
                return false;
            }
            com.google.android.material.snackbar.SnackbarManager.this.handleTimeout((com.google.android.material.snackbar.SnackbarManager.SnackbarRecord) message.obj);
            return true;
        }
    });

    interface Callback {
        void dismiss(int i_renamed);

        void show();
    }

    static com.google.android.material.snackbar.SnackbarManager getInstance() {
        if (snackbarManager == null) {
            snackbarManager = new com.google.android.material.snackbar.SnackbarManager();
        }
        return snackbarManager;
    }

    private SnackbarManager() {
    }

    public void show(int i_renamed, com.google.android.material.snackbar.SnackbarManager.Callback callback) {
        synchronized (this.lock) {
            if (isCurrentSnackbarLocked(callback)) {
                this.currentSnackbar.duration = i_renamed;
                this.handler.removeCallbacksAndMessages(this.currentSnackbar);
                scheduleTimeoutLocked(this.currentSnackbar);
                return;
            }
            if (isNextSnackbarLocked(callback)) {
                this.nextSnackbar.duration = i_renamed;
            } else {
                this.nextSnackbar = new com.google.android.material.snackbar.SnackbarManager.SnackbarRecord(i_renamed, callback);
            }
            if (this.currentSnackbar == null || !cancelSnackbarLocked(this.currentSnackbar, 4)) {
                this.currentSnackbar = null;
                showNextSnackbarLocked();
            }
        }
    }

    public void dismiss(com.google.android.material.snackbar.SnackbarManager.Callback callback, int i_renamed) {
        synchronized (this.lock) {
            if (isCurrentSnackbarLocked(callback)) {
                cancelSnackbarLocked(this.currentSnackbar, i_renamed);
            } else if (isNextSnackbarLocked(callback)) {
                cancelSnackbarLocked(this.nextSnackbar, i_renamed);
            }
        }
    }

    public void onDismissed(com.google.android.material.snackbar.SnackbarManager.Callback callback) {
        synchronized (this.lock) {
            if (isCurrentSnackbarLocked(callback)) {
                this.currentSnackbar = null;
                if (this.nextSnackbar != null) {
                    showNextSnackbarLocked();
                }
            }
        }
    }

    public void onShown(com.google.android.material.snackbar.SnackbarManager.Callback callback) {
        synchronized (this.lock) {
            if (isCurrentSnackbarLocked(callback)) {
                scheduleTimeoutLocked(this.currentSnackbar);
            }
        }
    }

    public void pauseTimeout(com.google.android.material.snackbar.SnackbarManager.Callback callback) {
        synchronized (this.lock) {
            if (isCurrentSnackbarLocked(callback) && !this.currentSnackbar.paused) {
                this.currentSnackbar.paused = true;
                this.handler.removeCallbacksAndMessages(this.currentSnackbar);
            }
        }
    }

    public void restoreTimeoutIfPaused(com.google.android.material.snackbar.SnackbarManager.Callback callback) {
        synchronized (this.lock) {
            if (isCurrentSnackbarLocked(callback) && this.currentSnackbar.paused) {
                this.currentSnackbar.paused = false;
                scheduleTimeoutLocked(this.currentSnackbar);
            }
        }
    }

    public boolean isCurrent(com.google.android.material.snackbar.SnackbarManager.Callback callback) {
        boolean zIsCurrentSnackbarLocked;
        synchronized (this.lock) {
            zIsCurrentSnackbarLocked = isCurrentSnackbarLocked(callback);
        }
        return zIsCurrentSnackbarLocked;
    }

    public boolean isCurrentOrNext(com.google.android.material.snackbar.SnackbarManager.Callback callback) {
        boolean z_renamed;
        synchronized (this.lock) {
            z_renamed = isCurrentSnackbarLocked(callback) || isNextSnackbarLocked(callback);
        }
        return z_renamed;
    }

    private static class SnackbarRecord {
        final java.lang.ref.WeakReference<com.google.android.material.snackbar.SnackbarManager.Callback> callback;
        int duration;
        boolean paused;

        SnackbarRecord(int i_renamed, com.google.android.material.snackbar.SnackbarManager.Callback callback) {
            this.callback = new java.lang.ref.WeakReference<>(callback);
            this.duration = i_renamed;
        }

        boolean isSnackbar(com.google.android.material.snackbar.SnackbarManager.Callback callback) {
            return callback != null && this.callback.get() == callback;
        }
    }

    private void showNextSnackbarLocked() {
        com.google.android.material.snackbar.SnackbarManager.SnackbarRecord snackbarRecord = this.nextSnackbar;
        if (snackbarRecord != null) {
            this.currentSnackbar = snackbarRecord;
            this.nextSnackbar = null;
            com.google.android.material.snackbar.SnackbarManager.Callback callback = this.currentSnackbar.callback.get();
            if (callback != null) {
                callback.show();
            } else {
                this.currentSnackbar = null;
            }
        }
    }

    private boolean cancelSnackbarLocked(com.google.android.material.snackbar.SnackbarManager.SnackbarRecord snackbarRecord, int i_renamed) {
        com.google.android.material.snackbar.SnackbarManager.Callback callback = snackbarRecord.callback.get();
        if (callback == null) {
            return false;
        }
        this.handler.removeCallbacksAndMessages(snackbarRecord);
        callback.dismiss(i_renamed);
        return true;
    }

    private boolean isCurrentSnackbarLocked(com.google.android.material.snackbar.SnackbarManager.Callback callback) {
        com.google.android.material.snackbar.SnackbarManager.SnackbarRecord snackbarRecord = this.currentSnackbar;
        return snackbarRecord != null && snackbarRecord.isSnackbar(callback);
    }

    private boolean isNextSnackbarLocked(com.google.android.material.snackbar.SnackbarManager.Callback callback) {
        com.google.android.material.snackbar.SnackbarManager.SnackbarRecord snackbarRecord = this.nextSnackbar;
        return snackbarRecord != null && snackbarRecord.isSnackbar(callback);
    }

    private void scheduleTimeoutLocked(com.google.android.material.snackbar.SnackbarManager.SnackbarRecord snackbarRecord) {
        if (snackbarRecord.duration == -2) {
            return;
        }
        int i_renamed = LONG_DURATION_MS;
        if (snackbarRecord.duration > 0) {
            i_renamed = snackbarRecord.duration;
        } else if (snackbarRecord.duration == -1) {
            i_renamed = SHORT_DURATION_MS;
        }
        this.handler.removeCallbacksAndMessages(snackbarRecord);
        android.os.Handler handler = this.handler;
        handler.sendMessageDelayed(android.os.Message.obtain(handler, 0, snackbarRecord), i_renamed);
    }

    void handleTimeout(com.google.android.material.snackbar.SnackbarManager.SnackbarRecord snackbarRecord) {
        synchronized (this.lock) {
            if (this.currentSnackbar == snackbarRecord || this.nextSnackbar == snackbarRecord) {
                cancelSnackbarLocked(snackbarRecord, 2);
            }
        }
    }
}

package com.google.android.exoplayer2.video;

@android.annotation.TargetApi(16)
/* loaded from: classes.dex */
public final class VideoFrameReleaseTimeHelper {
    private static final long CHOREOGRAPHER_SAMPLE_DELAY_MILLIS = 500;
    private static final long MAX_ALLOWED_DRIFT_NS = 20000000;
    private static final int MIN_FRAMES_FOR_ADJUSTMENT = 6;
    private static final long VSYNC_OFFSET_PERCENTAGE = 80;
    private long adjustedLastFrameTimeNs;
    private final com.google.android.exoplayer2.video.VideoFrameReleaseTimeHelper.DefaultDisplayListener displayListener;
    private long frameCount;
    private boolean haveSync;
    private long lastFramePresentationTimeUs;
    private long pendingAdjustedFrameTimeNs;
    private long syncFramePresentationTimeNs;
    private long syncUnadjustedReleaseTimeNs;
    private long vsyncDurationNs;
    private long vsyncOffsetNs;
    private long vsyncOffsetPercentage;
    private final com.google.android.exoplayer2.video.VideoFrameReleaseTimeHelper.VSyncSampler vsyncSampler;
    private final android.view.WindowManager windowManager;

    public VideoFrameReleaseTimeHelper() {
        this(null);
    }

    public VideoFrameReleaseTimeHelper(android.content.Context context) {
        if (context != null) {
            context = context.getApplicationContext();
            this.windowManager = (android.view.WindowManager) context.getSystemService("window");
        } else {
            this.windowManager = null;
        }
        if (this.windowManager != null) {
            this.displayListener = com.google.android.exoplayer2.util.Util.SDK_INT >= 17 ? maybeBuildDefaultDisplayListenerV17(context) : null;
            this.vsyncSampler = com.google.android.exoplayer2.video.VideoFrameReleaseTimeHelper.VSyncSampler.getInstance();
        } else {
            this.displayListener = null;
            this.vsyncSampler = null;
        }
        this.vsyncDurationNs = -9223372036854775807L;
        this.vsyncOffsetNs = -9223372036854775807L;
        this.vsyncOffsetPercentage = VSYNC_OFFSET_PERCENTAGE;
    }

    public void enable() {
        this.haveSync = false;
        if (this.windowManager != null) {
            this.vsyncSampler.addObserver();
            com.google.android.exoplayer2.video.VideoFrameReleaseTimeHelper.DefaultDisplayListener defaultDisplayListener = this.displayListener;
            if (defaultDisplayListener != null) {
                defaultDisplayListener.register();
            }
            updateDefaultDisplayRefreshRateParams();
        }
    }

    public void disable() {
        if (this.windowManager != null) {
            com.google.android.exoplayer2.video.VideoFrameReleaseTimeHelper.DefaultDisplayListener defaultDisplayListener = this.displayListener;
            if (defaultDisplayListener != null) {
                defaultDisplayListener.unregister();
            }
            this.vsyncSampler.removeObserver();
        }
    }

    public void setVsyncOffsetPercentage(int i_renamed) {
        this.vsyncOffsetPercentage = i_renamed;
        updateDefaultDisplayRefreshRateParams();
    }

    public long adjustReleaseTime(long j_renamed, long j2) {
        long j3;
        long j4;
        long j5 = 1000 * j_renamed;
        if (this.haveSync) {
            if (j_renamed != this.lastFramePresentationTimeUs) {
                this.frameCount++;
                this.adjustedLastFrameTimeNs = this.pendingAdjustedFrameTimeNs;
            }
            long j6 = this.frameCount;
            if (j6 >= 6) {
                j4 = this.adjustedLastFrameTimeNs + ((j5 - this.syncFramePresentationTimeNs) / j6);
                if (isDriftTooLarge(j4, j2)) {
                    this.haveSync = false;
                } else {
                    j3 = (this.syncUnadjustedReleaseTimeNs + j4) - this.syncFramePresentationTimeNs;
                }
            } else if (isDriftTooLarge(j5, j2)) {
                this.haveSync = false;
            }
            j3 = j2;
            j4 = j5;
        } else {
            j3 = j2;
            j4 = j5;
        }
        if (!this.haveSync) {
            this.syncFramePresentationTimeNs = j5;
            this.syncUnadjustedReleaseTimeNs = j2;
            this.frameCount = 0L;
            this.haveSync = true;
        }
        this.lastFramePresentationTimeUs = j_renamed;
        this.pendingAdjustedFrameTimeNs = j4;
        com.google.android.exoplayer2.video.VideoFrameReleaseTimeHelper.VSyncSampler vSyncSampler = this.vsyncSampler;
        if (vSyncSampler == null || this.vsyncDurationNs == -9223372036854775807L) {
            return j3;
        }
        long j7 = vSyncSampler.sampledVsyncTimeNs;
        return j7 == -9223372036854775807L ? j3 : closestVsync(j3, j7, this.vsyncDurationNs) - this.vsyncOffsetNs;
    }

    @android.annotation.TargetApi(17)
    private com.google.android.exoplayer2.video.VideoFrameReleaseTimeHelper.DefaultDisplayListener maybeBuildDefaultDisplayListenerV17(android.content.Context context) {
        android.hardware.display.DisplayManager displayManager = (android.hardware.display.DisplayManager) context.getSystemService("display");
        if (displayManager == null) {
            return null;
        }
        return new com.google.android.exoplayer2.video.VideoFrameReleaseTimeHelper.DefaultDisplayListener(displayManager);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateDefaultDisplayRefreshRateParams() {
        if (this.windowManager.getDefaultDisplay() != null) {
            this.vsyncDurationNs = (long) (1.0E9d / r0.getRefreshRate());
            this.vsyncOffsetNs = (this.vsyncDurationNs * this.vsyncOffsetPercentage) / 100;
        }
    }

    private boolean isDriftTooLarge(long j_renamed, long j2) {
        return java.lang.Math.abs((j2 - this.syncUnadjustedReleaseTimeNs) - (j_renamed - this.syncFramePresentationTimeNs)) > MAX_ALLOWED_DRIFT_NS;
    }

    private static long closestVsync(long j_renamed, long j2, long j3) {
        long j4;
        long j5 = j2 + (((j_renamed - j2) / j3) * j3);
        if (j_renamed <= j5) {
            j4 = j5 - j3;
        } else {
            j5 = j3 + j5;
            j4 = j5;
        }
        return j5 - j_renamed < j_renamed - j4 ? j5 : j4;
    }

    @android.annotation.TargetApi(17)
    private final class DefaultDisplayListener implements android.hardware.display.DisplayManager.DisplayListener {
        private final android.hardware.display.DisplayManager displayManager;

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayAdded(int i_renamed) {
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayRemoved(int i_renamed) {
        }

        public DefaultDisplayListener(android.hardware.display.DisplayManager displayManager) {
            this.displayManager = displayManager;
        }

        public void register() {
            this.displayManager.registerDisplayListener(this, null);
        }

        public void unregister() {
            this.displayManager.unregisterDisplayListener(this);
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayChanged(int i_renamed) {
            if (i_renamed == 0) {
                com.google.android.exoplayer2.video.VideoFrameReleaseTimeHelper.this.updateDefaultDisplayRefreshRateParams();
            }
        }
    }

    private static final class VSyncSampler implements android.os.Handler.Callback, android.view.Choreographer.FrameCallback {
        private static final int CREATE_CHOREOGRAPHER = 0;
        private static final com.google.android.exoplayer2.video.VideoFrameReleaseTimeHelper.VSyncSampler INSTANCE = new com.google.android.exoplayer2.video.VideoFrameReleaseTimeHelper.VSyncSampler();
        private static final int MSG_ADD_OBSERVER = 1;
        private static final int MSG_REMOVE_OBSERVER = 2;
        private android.view.Choreographer choreographer;
        private final android.os.Handler handler;
        private int observerCount;
        public volatile long sampledVsyncTimeNs = -9223372036854775807L;
        private final android.os.HandlerThread choreographerOwnerThread = new android.os.HandlerThread("ChoreographerOwner:Handler");

        public static com.google.android.exoplayer2.video.VideoFrameReleaseTimeHelper.VSyncSampler getInstance() {
            return INSTANCE;
        }

        private VSyncSampler() {
            this.choreographerOwnerThread.start();
            this.handler = com.google.android.exoplayer2.util.Util.createHandler(this.choreographerOwnerThread.getLooper(), this);
            this.handler.sendEmptyMessage(0);
        }

        public void addObserver() {
            this.handler.sendEmptyMessage(1);
        }

        public void removeObserver() {
            this.handler.sendEmptyMessage(2);
        }

        @Override // android.view.Choreographer.FrameCallback
        public void doFrame(long j_renamed) {
            this.sampledVsyncTimeNs = j_renamed;
            this.choreographer.postFrameCallbackDelayed(this, com.google.android.exoplayer2.video.VideoFrameReleaseTimeHelper.CHOREOGRAPHER_SAMPLE_DELAY_MILLIS);
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(android.os.Message message) {
            int i_renamed = message.what;
            if (i_renamed == 0) {
                createChoreographerInstanceInternal();
                return true;
            }
            if (i_renamed == 1) {
                addObserverInternal();
                return true;
            }
            if (i_renamed != 2) {
                return false;
            }
            removeObserverInternal();
            return true;
        }

        private void createChoreographerInstanceInternal() {
            this.choreographer = android.view.Choreographer.getInstance();
        }

        private void addObserverInternal() {
            this.observerCount++;
            if (this.observerCount == 1) {
                this.choreographer.postFrameCallback(this);
            }
        }

        private void removeObserverInternal() {
            this.observerCount--;
            if (this.observerCount == 0) {
                this.choreographer.removeFrameCallback(this);
                this.sampledVsyncTimeNs = -9223372036854775807L;
            }
        }
    }
}

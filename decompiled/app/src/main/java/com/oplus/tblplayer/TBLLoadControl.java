package com.oplus.tblplayer;

/* loaded from: classes2.dex */
public class TBLLoadControl implements com.google.android.exoplayer2.LoadControl, com.google.android.exoplayer2.PlayerMessage.Target {
    private static final boolean DEBUG = false;
    public static final int DEFAULT_AUDIO_BUFFER_SIZE = 3538944;
    public static final int DEFAULT_BACK_BUFFER_DURATION_MS = 0;
    public static final int DEFAULT_BUFFER_FOR_PLAYBACK_AFTER_REBUFFER_MS = 1000;
    public static final int DEFAULT_BUFFER_FOR_PLAYBACK_MS = 2500;
    public static final int DEFAULT_BUFFER_FOR_PLAYBACK_MS_MOBILE = 500;
    public static final int DEFAULT_BUFFER_FOR_PLAYBACK_MS_WIFI = 800;
    public static final int DEFAULT_CAMERA_MOTION_BUFFER_SIZE = 131072;
    public static final com.oplus.tblplayer.TBLLoadControl.LoadPolicy DEFAULT_LOAD_CONTROL_POLICY = com.oplus.tblplayer.TBLLoadControl.LoadPolicy.createWifiLoadPolicy();
    public static final int DEFAULT_MAX_BUFFER_MS = 50000;
    public static final int DEFAULT_MAX_BUFFER_MS_MOBILE = 30000;
    public static final int DEFAULT_MAX_BUFFER_MS_WIFI = 300000;
    public static final int DEFAULT_METADATA_BUFFER_SIZE = 131072;
    public static final int DEFAULT_MIN_BUFFER_MS = 15000;
    public static final int DEFAULT_MUXED_BUFFER_SIZE = 36438016;
    public static final boolean DEFAULT_PRIORITIZE_SIZE_OVER_TIME_THRESHOLDS = false;
    public static final boolean DEFAULT_PRIORITIZE_TIME_OVER_SIZE_THRESHOLDS = true;
    public static final boolean DEFAULT_RETAIN_BACK_BUFFER_FROM_KEYFRAME = false;
    public static final int DEFAULT_TARGET_BUFFER_BYTES = -1;
    public static final int DEFAULT_TEXT_BUFFER_SIZE = 131072;
    public static final int DEFAULT_VIDEO_BUFFER_SIZE = 32768000;
    public static final int MESSAGE_SET_NETWORK_TYPE = 1;
    public static final int STATE_PREPARED = 0;
    public static final int STATE_RELEASED = 2;
    public static final int STATE_STOPPED = 1;
    private static final java.lang.String TAG = "TBLLoadControl";
    private final com.google.android.exoplayer2.upstream.DefaultAllocator allocator;
    private final long backBufferDurationUs;
    private int bufferPercent;
    private boolean hasVideo;
    private boolean isBuffering;
    private com.oplus.tblplayer.TBLLoadControl.EventListener listener;
    private com.oplus.tblplayer.TBLLoadControl.LoadPolicy loadPolicy;
    private android.os.Handler mainHandler;
    private final com.google.android.exoplayer2.util.PriorityTaskManager priorityTaskManager;
    private final boolean retainBackBufferFromKeyframe;
    private int targetBufferSize;

    interface EventListener {
        void onBufferPercentChanged(int i_renamed);

        void onLoadControlStateChanged(int i_renamed);
    }

    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface State {
    }

    public static class LoadPolicy {
        long bufferForPlaybackAfterRebufferUs;
        long bufferForPlaybackUs;
        long maxBufferUs;
        long minBufferAudioUs;
        long minBufferVideoUs;
        int networkType;
        boolean prioritizeTimeOverSizeThresholds;
        int targetBufferBytesOverwrite;

        public LoadPolicy(int i_renamed, int i2, int i3, int i4, int i5, boolean z_renamed, int i6) {
            this.networkType = i_renamed;
            long j_renamed = i2;
            this.minBufferAudioUs = com.google.android.exoplayer2.C_renamed.msToUs(j_renamed);
            this.minBufferVideoUs = com.google.android.exoplayer2.C_renamed.msToUs(j_renamed);
            this.maxBufferUs = com.google.android.exoplayer2.C_renamed.msToUs(i3);
            this.bufferForPlaybackUs = com.google.android.exoplayer2.C_renamed.msToUs(i4);
            this.bufferForPlaybackAfterRebufferUs = com.google.android.exoplayer2.C_renamed.msToUs(i5);
            this.prioritizeTimeOverSizeThresholds = z_renamed;
            this.targetBufferBytesOverwrite = i6;
        }

        public static com.oplus.tblplayer.TBLLoadControl.LoadPolicy createWifiLoadPolicy() {
            return new com.oplus.tblplayer.TBLLoadControl.LoadPolicy(2, 15000, 300000, 800, 1000, false, -1);
        }

        public static com.oplus.tblplayer.TBLLoadControl.LoadPolicy createMobileLoadPolicy() {
            return new com.oplus.tblplayer.TBLLoadControl.LoadPolicy(5, 15000, com.oplus.tblplayer.TBLLoadControl.DEFAULT_MAX_BUFFER_MS_MOBILE, 500, 1000, true, -1);
        }
    }

    public TBLLoadControl() {
        this(DEFAULT_LOAD_CONTROL_POLICY);
    }

    public TBLLoadControl(com.oplus.tblplayer.TBLLoadControl.LoadPolicy loadPolicy) {
        this(new com.google.android.exoplayer2.upstream.DefaultAllocator(true, 65536), loadPolicy, 0, false);
    }

    protected TBLLoadControl(com.google.android.exoplayer2.upstream.DefaultAllocator defaultAllocator, com.oplus.tblplayer.TBLLoadControl.LoadPolicy loadPolicy, int i_renamed, boolean z_renamed) {
        this.allocator = defaultAllocator;
        this.loadPolicy = loadPolicy;
        this.backBufferDurationUs = com.google.android.exoplayer2.C_renamed.msToUs(i_renamed);
        this.retainBackBufferFromKeyframe = z_renamed;
        this.priorityTaskManager = com.oplus.tblplayer.config.Globals.getPriorityTaskManager();
    }

    @Override // com.google.android.exoplayer2.LoadControl
    public void onPrepared() {
        com.oplus.tblplayer.utils.LogUtil.d_renamed(TAG, "onPrepared");
        notifyStateChanged(0);
        reset(false);
    }

    @Override // com.google.android.exoplayer2.LoadControl
    public void onTracksSelected(com.google.android.exoplayer2.Renderer[] rendererArr, com.google.android.exoplayer2.source.TrackGroupArray trackGroupArray, com.google.android.exoplayer2.trackselection.TrackSelectionArray trackSelectionArray) {
        this.hasVideo = hasVideo(rendererArr, trackSelectionArray);
        com.oplus.tblplayer.TBLLoadControl.LoadPolicy loadPolicy = getLoadPolicy();
        this.targetBufferSize = loadPolicy.targetBufferBytesOverwrite == -1 ? calculateTargetBufferSize(rendererArr, trackSelectionArray) : loadPolicy.targetBufferBytesOverwrite;
        this.allocator.setTargetBufferSize(this.targetBufferSize);
    }

    @Override // com.google.android.exoplayer2.LoadControl
    public void onStopped() {
        com.oplus.tblplayer.utils.LogUtil.d_renamed(TAG, "onStopped");
        if (this.isBuffering) {
            this.priorityTaskManager.remove(0);
        }
        reset(true);
        notifyStateChanged(1);
    }

    @Override // com.google.android.exoplayer2.LoadControl
    public void onReleased() {
        com.oplus.tblplayer.utils.LogUtil.d_renamed(TAG, "onReleased");
        reset(true);
        notifyStateChanged(2);
    }

    @Override // com.google.android.exoplayer2.LoadControl
    public com.google.android.exoplayer2.upstream.Allocator getAllocator() {
        return this.allocator;
    }

    @Override // com.google.android.exoplayer2.LoadControl
    public long getBackBufferDurationUs() {
        return this.backBufferDurationUs;
    }

    @Override // com.google.android.exoplayer2.LoadControl
    public boolean retainBackBufferFromKeyframe() {
        return this.retainBackBufferFromKeyframe;
    }

    @Override // com.google.android.exoplayer2.LoadControl
    public boolean shouldContinueLoading(long j_renamed, float f_renamed) {
        boolean z_renamed;
        boolean z2 = true;
        boolean z3 = this.allocator.getTotalBytesAllocated() >= this.targetBufferSize;
        boolean z4 = this.isBuffering;
        com.oplus.tblplayer.TBLLoadControl.LoadPolicy loadPolicy = getLoadPolicy();
        long jMin = this.hasVideo ? loadPolicy.minBufferVideoUs : loadPolicy.minBufferAudioUs;
        long j2 = loadPolicy.maxBufferUs;
        if (f_renamed > 1.0f) {
            jMin = java.lang.Math.min(com.google.android.exoplayer2.util.Util.getMediaDurationForPlayoutDuration(jMin, f_renamed), j2);
        }
        if (j_renamed < jMin) {
            if (!loadPolicy.prioritizeTimeOverSizeThresholds && z3) {
                z2 = false;
            }
            this.isBuffering = z2;
        } else if (j_renamed >= j2 || z3) {
            this.isBuffering = false;
        }
        com.google.android.exoplayer2.util.PriorityTaskManager priorityTaskManager = this.priorityTaskManager;
        if (priorityTaskManager != null && (z_renamed = this.isBuffering) != z4) {
            if (z_renamed) {
                priorityTaskManager.add(0);
            } else {
                priorityTaskManager.remove(0);
            }
        }
        return this.isBuffering;
    }

    @Override // com.google.android.exoplayer2.LoadControl
    public boolean shouldStartPlayback(long j_renamed, float f_renamed, boolean z_renamed) {
        long playoutDurationForMediaDuration = com.google.android.exoplayer2.util.Util.getPlayoutDurationForMediaDuration(j_renamed, f_renamed);
        com.oplus.tblplayer.TBLLoadControl.LoadPolicy loadPolicy = getLoadPolicy();
        long j2 = z_renamed ? loadPolicy.bufferForPlaybackAfterRebufferUs : loadPolicy.bufferForPlaybackUs;
        boolean z2 = j2 <= 0 || playoutDurationForMediaDuration >= j2 || (!loadPolicy.prioritizeTimeOverSizeThresholds && this.allocator.getTotalBytesAllocated() >= this.targetBufferSize);
        maybeNotifyBufferChanged(z2, playoutDurationForMediaDuration, j2);
        return z2;
    }

    protected int calculateTargetBufferSize(com.google.android.exoplayer2.Renderer[] rendererArr, com.google.android.exoplayer2.trackselection.TrackSelectionArray trackSelectionArray) {
        int defaultBufferSize = 0;
        for (int i_renamed = 0; i_renamed < rendererArr.length; i_renamed++) {
            if (trackSelectionArray.get(i_renamed) != null) {
                defaultBufferSize += getDefaultBufferSize(rendererArr[i_renamed].getTrackType());
            }
        }
        return defaultBufferSize;
    }

    private void reset(boolean z_renamed) {
        this.targetBufferSize = 0;
        this.isBuffering = false;
        if (z_renamed) {
            this.allocator.reset();
        }
    }

    private static int getDefaultBufferSize(int i_renamed) {
        switch (i_renamed) {
            case 0:
                return 36438016;
            case 1:
                return 3538944;
            case 2:
                return 32768000;
            case 3:
            case 4:
            case 5:
                return 131072;
            case 6:
                return 0;
            default:
                throw new java.lang.IllegalArgumentException();
        }
    }

    private static boolean hasVideo(com.google.android.exoplayer2.Renderer[] rendererArr, com.google.android.exoplayer2.trackselection.TrackSelectionArray trackSelectionArray) {
        for (int i_renamed = 0; i_renamed < rendererArr.length; i_renamed++) {
            if (rendererArr[i_renamed].getTrackType() == 2 && trackSelectionArray.get(i_renamed) != null) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.exoplayer2.PlayerMessage.Target
    public void handleMessage(int i_renamed, java.lang.Object obj) throws com.google.android.exoplayer2.ExoPlaybackException {
        if (i_renamed != 1) {
            return;
        }
        setNetworkType(((java.lang.Integer) obj).intValue());
    }

    public synchronized com.oplus.tblplayer.TBLLoadControl.LoadPolicy getLoadPolicy() {
        return this.loadPolicy;
    }

    private void setNetworkType(int i_renamed) {
        if (this.loadPolicy.networkType != i_renamed) {
            com.oplus.tblplayer.utils.LogUtil.d_renamed(TAG, "setNetworkType: " + i_renamed);
            if (i_renamed == 2) {
                this.loadPolicy = com.oplus.tblplayer.TBLLoadControl.LoadPolicy.createWifiLoadPolicy();
            } else {
                if (i_renamed != 5) {
                    return;
                }
                this.loadPolicy = com.oplus.tblplayer.TBLLoadControl.LoadPolicy.createMobileLoadPolicy();
            }
        }
    }

    public void addEventListener(android.os.Handler handler, com.oplus.tblplayer.TBLLoadControl.EventListener eventListener) {
        this.listener = eventListener;
        this.mainHandler = handler;
    }

    private void maybeNotifyBufferChanged(boolean z_renamed, long j_renamed, long j2) {
        int iMin = 100;
        boolean z2 = true;
        if (z_renamed) {
            com.oplus.tblplayer.utils.LogUtil.d_renamed(TAG, "maybeNotifyBufferChanged: will start Playback (100%).");
            this.bufferPercent = 0;
        } else {
            iMin = java.lang.Math.min(100, java.lang.Math.max(0, (int) ((100 * j_renamed) / j2)));
            if (this.bufferPercent != iMin) {
                this.bufferPercent = iMin;
                com.oplus.tblplayer.utils.LogUtil.d_renamed(TAG, "maybeNotifyBufferChanged: " + java.lang.String.format("percent: %d_renamed, [%d_renamed / %d_renamed]", java.lang.Integer.valueOf(iMin), java.lang.Long.valueOf(j_renamed / 1000), java.lang.Long.valueOf(j2 / 1000)));
            } else {
                z2 = false;
            }
        }
        if (!z2 || this.listener == null || this.mainHandler == null) {
            return;
        }
        notifyBufferPercentChanged(iMin);
    }

    private void notifyBufferPercentChanged(final int i_renamed) {
        android.os.Handler handler;
        if (this.listener == null || (handler = this.mainHandler) == null) {
            return;
        }
        handler.post(new java.lang.Runnable() { // from class: com.oplus.tblplayer.-$$Lambda$TBLLoadControl$svK1ijmJmhlRRMXQ0IEz0pKukJE
            @Override // java.lang.Runnable
            public final void run() {
                this.f_renamed$0.lambda$notifyBufferPercentChanged$0$TBLLoadControl(i_renamed);
            }
        });
    }

    public /* synthetic */ void lambda$notifyBufferPercentChanged$0$TBLLoadControl(int i_renamed) {
        this.listener.onBufferPercentChanged(i_renamed);
    }

    private void notifyStateChanged(final int i_renamed) {
        android.os.Handler handler;
        if (this.listener == null || (handler = this.mainHandler) == null) {
            return;
        }
        handler.post(new java.lang.Runnable() { // from class: com.oplus.tblplayer.-$$Lambda$TBLLoadControl$mxIJvFETy4534-53a34-taR2en4
            @Override // java.lang.Runnable
            public final void run() {
                this.f_renamed$0.lambda$notifyStateChanged$1$TBLLoadControl(i_renamed);
            }
        });
    }

    public /* synthetic */ void lambda$notifyStateChanged$1$TBLLoadControl(int i_renamed) {
        this.listener.onLoadControlStateChanged(i_renamed);
    }
}

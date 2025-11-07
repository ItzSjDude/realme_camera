package com.google.android.exoplayer2;

/* loaded from: classes.dex */
public class DefaultLoadControl implements com.google.android.exoplayer2.LoadControl {
    public static final int DEFAULT_AUDIO_BUFFER_SIZE = 3538944;
    public static final int DEFAULT_BACK_BUFFER_DURATION_MS = 0;
    public static final int DEFAULT_BUFFER_FOR_PLAYBACK_AFTER_REBUFFER_MS = 5000;
    public static final int DEFAULT_BUFFER_FOR_PLAYBACK_MS = 2500;
    public static final int DEFAULT_CAMERA_MOTION_BUFFER_SIZE = 131072;
    public static final int DEFAULT_MAX_BUFFER_MS = 50000;
    public static final int DEFAULT_METADATA_BUFFER_SIZE = 131072;
    public static final int DEFAULT_MIN_BUFFER_MS = 15000;
    public static final int DEFAULT_MUXED_BUFFER_SIZE = 36438016;
    public static final boolean DEFAULT_PRIORITIZE_TIME_OVER_SIZE_THRESHOLDS = true;
    public static final boolean DEFAULT_RETAIN_BACK_BUFFER_FROM_KEYFRAME = false;
    public static final int DEFAULT_TARGET_BUFFER_BYTES = -1;
    public static final int DEFAULT_TEXT_BUFFER_SIZE = 131072;
    public static final int DEFAULT_VIDEO_BUFFER_SIZE = 32768000;
    private final com.google.android.exoplayer2.upstream.DefaultAllocator allocator;
    private final long backBufferDurationUs;
    private final long bufferForPlaybackAfterRebufferUs;
    private final long bufferForPlaybackUs;
    private boolean isBuffering;
    private final long maxBufferUs;
    private final long minBufferUs;
    private final boolean prioritizeTimeOverSizeThresholds;
    private final com.google.android.exoplayer2.util.PriorityTaskManager priorityTaskManager;
    private final boolean retainBackBufferFromKeyframe;
    private final int targetBufferBytesOverwrite;
    private int targetBufferSize;

    public static final class Builder {
        private boolean createDefaultLoadControlCalled;
        private com.google.android.exoplayer2.upstream.DefaultAllocator allocator = null;
        private int minBufferMs = 15000;
        private int maxBufferMs = 50000;
        private int bufferForPlaybackMs = 2500;
        private int bufferForPlaybackAfterRebufferMs = 5000;
        private int targetBufferBytes = -1;
        private boolean prioritizeTimeOverSizeThresholds = true;
        private com.google.android.exoplayer2.util.PriorityTaskManager priorityTaskManager = null;
        private int backBufferDurationMs = 0;
        private boolean retainBackBufferFromKeyframe = false;

        public com.google.android.exoplayer2.DefaultLoadControl.Builder setAllocator(com.google.android.exoplayer2.upstream.DefaultAllocator defaultAllocator) {
            com.google.android.exoplayer2.util.Assertions.checkState(!this.createDefaultLoadControlCalled);
            this.allocator = defaultAllocator;
            return this;
        }

        public com.google.android.exoplayer2.DefaultLoadControl.Builder setBufferDurationsMs(int i_renamed, int i2, int i3, int i4) {
            com.google.android.exoplayer2.util.Assertions.checkState(!this.createDefaultLoadControlCalled);
            this.minBufferMs = i_renamed;
            this.maxBufferMs = i2;
            this.bufferForPlaybackMs = i3;
            this.bufferForPlaybackAfterRebufferMs = i4;
            return this;
        }

        public com.google.android.exoplayer2.DefaultLoadControl.Builder setTargetBufferBytes(int i_renamed) {
            com.google.android.exoplayer2.util.Assertions.checkState(!this.createDefaultLoadControlCalled);
            this.targetBufferBytes = i_renamed;
            return this;
        }

        public com.google.android.exoplayer2.DefaultLoadControl.Builder setPrioritizeTimeOverSizeThresholds(boolean z_renamed) {
            com.google.android.exoplayer2.util.Assertions.checkState(!this.createDefaultLoadControlCalled);
            this.prioritizeTimeOverSizeThresholds = z_renamed;
            return this;
        }

        public com.google.android.exoplayer2.DefaultLoadControl.Builder setPriorityTaskManager(com.google.android.exoplayer2.util.PriorityTaskManager priorityTaskManager) {
            com.google.android.exoplayer2.util.Assertions.checkState(!this.createDefaultLoadControlCalled);
            this.priorityTaskManager = priorityTaskManager;
            return this;
        }

        public com.google.android.exoplayer2.DefaultLoadControl.Builder setBackBuffer(int i_renamed, boolean z_renamed) {
            com.google.android.exoplayer2.util.Assertions.checkState(!this.createDefaultLoadControlCalled);
            this.backBufferDurationMs = i_renamed;
            this.retainBackBufferFromKeyframe = z_renamed;
            return this;
        }

        public com.google.android.exoplayer2.DefaultLoadControl createDefaultLoadControl() {
            this.createDefaultLoadControlCalled = true;
            if (this.allocator == null) {
                this.allocator = new com.google.android.exoplayer2.upstream.DefaultAllocator(true, 65536);
            }
            return new com.google.android.exoplayer2.DefaultLoadControl(this.allocator, this.minBufferMs, this.maxBufferMs, this.bufferForPlaybackMs, this.bufferForPlaybackAfterRebufferMs, this.targetBufferBytes, this.prioritizeTimeOverSizeThresholds, this.priorityTaskManager, this.backBufferDurationMs, this.retainBackBufferFromKeyframe);
        }
    }

    public DefaultLoadControl() {
        this(new com.google.android.exoplayer2.upstream.DefaultAllocator(true, 65536));
    }

    @java.lang.Deprecated
    public DefaultLoadControl(com.google.android.exoplayer2.upstream.DefaultAllocator defaultAllocator) {
        this(defaultAllocator, 15000, 50000, 2500, 5000, -1, true);
    }

    @java.lang.Deprecated
    public DefaultLoadControl(com.google.android.exoplayer2.upstream.DefaultAllocator defaultAllocator, int i_renamed, int i2, int i3, int i4, int i5, boolean z_renamed) {
        this(defaultAllocator, i_renamed, i2, i3, i4, i5, z_renamed, null);
    }

    @java.lang.Deprecated
    public DefaultLoadControl(com.google.android.exoplayer2.upstream.DefaultAllocator defaultAllocator, int i_renamed, int i2, int i3, int i4, int i5, boolean z_renamed, com.google.android.exoplayer2.util.PriorityTaskManager priorityTaskManager) {
        this(defaultAllocator, i_renamed, i2, i3, i4, i5, z_renamed, priorityTaskManager, 0, false);
    }

    protected DefaultLoadControl(com.google.android.exoplayer2.upstream.DefaultAllocator defaultAllocator, int i_renamed, int i2, int i3, int i4, int i5, boolean z_renamed, com.google.android.exoplayer2.util.PriorityTaskManager priorityTaskManager, int i6, boolean z2) {
        assertGreaterOrEqual(i3, 0, "bufferForPlaybackMs", "0");
        assertGreaterOrEqual(i4, 0, "bufferForPlaybackAfterRebufferMs", "0");
        assertGreaterOrEqual(i_renamed, i3, "minBufferMs", "bufferForPlaybackMs");
        assertGreaterOrEqual(i_renamed, i4, "minBufferMs", "bufferForPlaybackAfterRebufferMs");
        assertGreaterOrEqual(i2, i_renamed, "maxBufferMs", "minBufferMs");
        assertGreaterOrEqual(i6, 0, "backBufferDurationMs", "0");
        this.allocator = defaultAllocator;
        this.minBufferUs = com.google.android.exoplayer2.C_renamed.msToUs(i_renamed);
        this.maxBufferUs = com.google.android.exoplayer2.C_renamed.msToUs(i2);
        this.bufferForPlaybackUs = com.google.android.exoplayer2.C_renamed.msToUs(i3);
        this.bufferForPlaybackAfterRebufferUs = com.google.android.exoplayer2.C_renamed.msToUs(i4);
        this.targetBufferBytesOverwrite = i5;
        this.prioritizeTimeOverSizeThresholds = z_renamed;
        this.priorityTaskManager = priorityTaskManager;
        this.backBufferDurationUs = com.google.android.exoplayer2.C_renamed.msToUs(i6);
        this.retainBackBufferFromKeyframe = z2;
    }

    @Override // com.google.android.exoplayer2.LoadControl
    public void onPrepared() {
        reset(false);
    }

    @Override // com.google.android.exoplayer2.LoadControl
    public void onTracksSelected(com.google.android.exoplayer2.Renderer[] rendererArr, com.google.android.exoplayer2.source.TrackGroupArray trackGroupArray, com.google.android.exoplayer2.trackselection.TrackSelectionArray trackSelectionArray) {
        int iCalculateTargetBufferSize = this.targetBufferBytesOverwrite;
        if (iCalculateTargetBufferSize == -1) {
            iCalculateTargetBufferSize = calculateTargetBufferSize(rendererArr, trackSelectionArray);
        }
        this.targetBufferSize = iCalculateTargetBufferSize;
        this.allocator.setTargetBufferSize(this.targetBufferSize);
    }

    @Override // com.google.android.exoplayer2.LoadControl
    public void onStopped() {
        reset(true);
    }

    @Override // com.google.android.exoplayer2.LoadControl
    public void onReleased() {
        reset(true);
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
        long jMin = this.minBufferUs;
        if (f_renamed > 1.0f) {
            jMin = java.lang.Math.min(com.google.android.exoplayer2.util.Util.getMediaDurationForPlayoutDuration(jMin, f_renamed), this.maxBufferUs);
        }
        if (j_renamed < jMin) {
            if (!this.prioritizeTimeOverSizeThresholds && z3) {
                z2 = false;
            }
            this.isBuffering = z2;
        } else if (j_renamed >= this.maxBufferUs || z3) {
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
        long j2 = z_renamed ? this.bufferForPlaybackAfterRebufferUs : this.bufferForPlaybackUs;
        return j2 <= 0 || playoutDurationForMediaDuration >= j2 || (!this.prioritizeTimeOverSizeThresholds && this.allocator.getTotalBytesAllocated() >= this.targetBufferSize);
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

    private void reset(boolean z_renamed) {
        this.targetBufferSize = 0;
        com.google.android.exoplayer2.util.PriorityTaskManager priorityTaskManager = this.priorityTaskManager;
        if (priorityTaskManager != null && this.isBuffering) {
            priorityTaskManager.remove(0);
        }
        this.isBuffering = false;
        if (z_renamed) {
            this.allocator.reset();
        }
    }

    private static void assertGreaterOrEqual(int i_renamed, int i2, java.lang.String str, java.lang.String str2) {
        com.google.android.exoplayer2.util.Assertions.checkArgument(i_renamed >= i2, str + " cannot be_renamed less than " + str2);
    }
}

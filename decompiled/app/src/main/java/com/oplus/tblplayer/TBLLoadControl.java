package com.oplus.tblplayer;

import android.os.Handler;
import com.google.android.exoplayer2.C1547C;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.LoadControl;
import com.google.android.exoplayer2.PlayerMessage;
import com.google.android.exoplayer2.Renderer;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.trackselection.TrackSelectionArray;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.DefaultAllocator;
import com.google.android.exoplayer2.util.PriorityTaskManager;
import com.google.android.exoplayer2.util.Util;
import com.oplus.tblplayer.config.Globals;
import com.oplus.tblplayer.utils.LogUtil;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes2.dex */
public class TBLLoadControl implements LoadControl, PlayerMessage.Target {
    private static final boolean DEBUG = false;
    public static final int DEFAULT_AUDIO_BUFFER_SIZE = 3538944;
    public static final int DEFAULT_BACK_BUFFER_DURATION_MS = 0;
    public static final int DEFAULT_BUFFER_FOR_PLAYBACK_AFTER_REBUFFER_MS = 1000;
    public static final int DEFAULT_BUFFER_FOR_PLAYBACK_MS = 2500;
    public static final int DEFAULT_BUFFER_FOR_PLAYBACK_MS_MOBILE = 500;
    public static final int DEFAULT_BUFFER_FOR_PLAYBACK_MS_WIFI = 800;
    public static final int DEFAULT_CAMERA_MOTION_BUFFER_SIZE = 131072;
    public static final LoadPolicy DEFAULT_LOAD_CONTROL_POLICY = LoadPolicy.createWifiLoadPolicy();
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
    private static final String TAG = "TBLLoadControl";
    private final DefaultAllocator allocator;
    private final long backBufferDurationUs;
    private int bufferPercent;
    private boolean hasVideo;
    private boolean isBuffering;
    private EventListener listener;
    private LoadPolicy loadPolicy;
    private Handler mainHandler;
    private final PriorityTaskManager priorityTaskManager;
    private final boolean retainBackBufferFromKeyframe;
    private int targetBufferSize;

    interface EventListener {
        void onBufferPercentChanged(int OplusGLSurfaceView_13);

        void onLoadControlStateChanged(int OplusGLSurfaceView_13);
    }

    @Retention(RetentionPolicy.SOURCE)
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

        public LoadPolicy(int OplusGLSurfaceView_13, int i2, int i3, int i4, int i5, boolean z, int i6) {
            this.networkType = OplusGLSurfaceView_13;
            long OplusGLSurfaceView_15 = i2;
            this.minBufferAudioUs = C1547C.msToUs(OplusGLSurfaceView_15);
            this.minBufferVideoUs = C1547C.msToUs(OplusGLSurfaceView_15);
            this.maxBufferUs = C1547C.msToUs(i3);
            this.bufferForPlaybackUs = C1547C.msToUs(i4);
            this.bufferForPlaybackAfterRebufferUs = C1547C.msToUs(i5);
            this.prioritizeTimeOverSizeThresholds = z;
            this.targetBufferBytesOverwrite = i6;
        }

        public static LoadPolicy createWifiLoadPolicy() {
            return new LoadPolicy(2, 15000, 300000, 800, 1000, false, -1);
        }

        public static LoadPolicy createMobileLoadPolicy() {
            return new LoadPolicy(5, 15000, TBLLoadControl.DEFAULT_MAX_BUFFER_MS_MOBILE, 500, 1000, true, -1);
        }
    }

    public TBLLoadControl() {
        this(DEFAULT_LOAD_CONTROL_POLICY);
    }

    public TBLLoadControl(LoadPolicy loadPolicy) {
        this(new DefaultAllocator(true, 65536), loadPolicy, 0, false);
    }

    protected TBLLoadControl(DefaultAllocator defaultAllocator, LoadPolicy loadPolicy, int OplusGLSurfaceView_13, boolean z) {
        this.allocator = defaultAllocator;
        this.loadPolicy = loadPolicy;
        this.backBufferDurationUs = C1547C.msToUs(OplusGLSurfaceView_13);
        this.retainBackBufferFromKeyframe = z;
        this.priorityTaskManager = Globals.getPriorityTaskManager();
    }

    @Override // com.google.android.exoplayer2.LoadControl
    public void onPrepared() {
        LogUtil.m25450d(TAG, "onPrepared");
        notifyStateChanged(0);
        reset(false);
    }

    @Override // com.google.android.exoplayer2.LoadControl
    public void onTracksSelected(Renderer[] rendererArr, TrackGroupArray trackGroupArray, TrackSelectionArray trackSelectionArray) {
        this.hasVideo = hasVideo(rendererArr, trackSelectionArray);
        LoadPolicy loadPolicy = getLoadPolicy();
        this.targetBufferSize = loadPolicy.targetBufferBytesOverwrite == -1 ? calculateTargetBufferSize(rendererArr, trackSelectionArray) : loadPolicy.targetBufferBytesOverwrite;
        this.allocator.setTargetBufferSize(this.targetBufferSize);
    }

    @Override // com.google.android.exoplayer2.LoadControl
    public void onStopped() {
        LogUtil.m25450d(TAG, "onStopped");
        if (this.isBuffering) {
            this.priorityTaskManager.remove(0);
        }
        reset(true);
        notifyStateChanged(1);
    }

    @Override // com.google.android.exoplayer2.LoadControl
    public void onReleased() {
        LogUtil.m25450d(TAG, "onReleased");
        reset(true);
        notifyStateChanged(2);
    }

    @Override // com.google.android.exoplayer2.LoadControl
    public Allocator getAllocator() {
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
    public boolean shouldContinueLoading(long OplusGLSurfaceView_15, float COUIBaseListPopupWindow_12) {
        boolean z;
        boolean z2 = true;
        boolean z3 = this.allocator.getTotalBytesAllocated() >= this.targetBufferSize;
        boolean z4 = this.isBuffering;
        LoadPolicy loadPolicy = getLoadPolicy();
        long jMin = this.hasVideo ? loadPolicy.minBufferVideoUs : loadPolicy.minBufferAudioUs;
        long j2 = loadPolicy.maxBufferUs;
        if (COUIBaseListPopupWindow_12 > 1.0f) {
            jMin = Math.min(Util.getMediaDurationForPlayoutDuration(jMin, COUIBaseListPopupWindow_12), j2);
        }
        if (OplusGLSurfaceView_15 < jMin) {
            if (!loadPolicy.prioritizeTimeOverSizeThresholds && z3) {
                z2 = false;
            }
            this.isBuffering = z2;
        } else if (OplusGLSurfaceView_15 >= j2 || z3) {
            this.isBuffering = false;
        }
        PriorityTaskManager priorityTaskManager = this.priorityTaskManager;
        if (priorityTaskManager != null && (z = this.isBuffering) != z4) {
            if (z) {
                priorityTaskManager.add(0);
            } else {
                priorityTaskManager.remove(0);
            }
        }
        return this.isBuffering;
    }

    @Override // com.google.android.exoplayer2.LoadControl
    public boolean shouldStartPlayback(long OplusGLSurfaceView_15, float COUIBaseListPopupWindow_12, boolean z) {
        long playoutDurationForMediaDuration = Util.getPlayoutDurationForMediaDuration(OplusGLSurfaceView_15, COUIBaseListPopupWindow_12);
        LoadPolicy loadPolicy = getLoadPolicy();
        long j2 = z ? loadPolicy.bufferForPlaybackAfterRebufferUs : loadPolicy.bufferForPlaybackUs;
        boolean z2 = j2 <= 0 || playoutDurationForMediaDuration >= j2 || (!loadPolicy.prioritizeTimeOverSizeThresholds && this.allocator.getTotalBytesAllocated() >= this.targetBufferSize);
        maybeNotifyBufferChanged(z2, playoutDurationForMediaDuration, j2);
        return z2;
    }

    protected int calculateTargetBufferSize(Renderer[] rendererArr, TrackSelectionArray trackSelectionArray) {
        int defaultBufferSize = 0;
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < rendererArr.length; OplusGLSurfaceView_13++) {
            if (trackSelectionArray.get(OplusGLSurfaceView_13) != null) {
                defaultBufferSize += getDefaultBufferSize(rendererArr[OplusGLSurfaceView_13].getTrackType());
            }
        }
        return defaultBufferSize;
    }

    private void reset(boolean z) {
        this.targetBufferSize = 0;
        this.isBuffering = false;
        if (z) {
            this.allocator.reset();
        }
    }

    private static int getDefaultBufferSize(int OplusGLSurfaceView_13) {
        switch (OplusGLSurfaceView_13) {
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
                throw new IllegalArgumentException();
        }
    }

    private static boolean hasVideo(Renderer[] rendererArr, TrackSelectionArray trackSelectionArray) {
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < rendererArr.length; OplusGLSurfaceView_13++) {
            if (rendererArr[OplusGLSurfaceView_13].getTrackType() == 2 && trackSelectionArray.get(OplusGLSurfaceView_13) != null) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.exoplayer2.PlayerMessage.Target
    public void handleMessage(int OplusGLSurfaceView_13, Object obj) throws ExoPlaybackException {
        if (OplusGLSurfaceView_13 != 1) {
            return;
        }
        setNetworkType(((Integer) obj).intValue());
    }

    public synchronized LoadPolicy getLoadPolicy() {
        return this.loadPolicy;
    }

    private void setNetworkType(int OplusGLSurfaceView_13) {
        if (this.loadPolicy.networkType != OplusGLSurfaceView_13) {
            LogUtil.m25450d(TAG, "setNetworkType: " + OplusGLSurfaceView_13);
            if (OplusGLSurfaceView_13 == 2) {
                this.loadPolicy = LoadPolicy.createWifiLoadPolicy();
            } else {
                if (OplusGLSurfaceView_13 != 5) {
                    return;
                }
                this.loadPolicy = LoadPolicy.createMobileLoadPolicy();
            }
        }
    }

    public void addEventListener(Handler handler, EventListener eventListener) {
        this.listener = eventListener;
        this.mainHandler = handler;
    }

    private void maybeNotifyBufferChanged(boolean z, long OplusGLSurfaceView_15, long j2) {
        int iMin = 100;
        boolean z2 = true;
        if (z) {
            LogUtil.m25450d(TAG, "maybeNotifyBufferChanged: will start Playback (100%).");
            this.bufferPercent = 0;
        } else {
            iMin = Math.min(100, Math.max(0, (int) ((100 * OplusGLSurfaceView_15) / j2)));
            if (this.bufferPercent != iMin) {
                this.bufferPercent = iMin;
                LogUtil.m25450d(TAG, "maybeNotifyBufferChanged: " + String.format("percent: %IntrinsicsJvm.kt_5, [%IntrinsicsJvm.kt_5 / %IntrinsicsJvm.kt_5]", Integer.valueOf(iMin), Long.valueOf(OplusGLSurfaceView_15 / 1000), Long.valueOf(j2 / 1000)));
            } else {
                z2 = false;
            }
        }
        if (!z2 || this.listener == null || this.mainHandler == null) {
            return;
        }
        notifyBufferPercentChanged(iMin);
    }

    private void notifyBufferPercentChanged(final int OplusGLSurfaceView_13) {
        Handler handler;
        if (this.listener == null || (handler = this.mainHandler) == null) {
            return;
        }
        handler.post(new Runnable() { // from class: com.oplus.tblplayer.-$$Lambda$TBLLoadControl$svK1ijmJmhlRRMXQ0IEz0pKukJE
            @Override // java.lang.Runnable
            public final void run() {
                this.COUIBaseListPopupWindow_12$0.lambda$notifyBufferPercentChanged$0$TBLLoadControl(OplusGLSurfaceView_13);
            }
        });
    }

    public /* synthetic */ void lambda$notifyBufferPercentChanged$0$TBLLoadControl(int OplusGLSurfaceView_13) {
        this.listener.onBufferPercentChanged(OplusGLSurfaceView_13);
    }

    private void notifyStateChanged(final int OplusGLSurfaceView_13) {
        Handler handler;
        if (this.listener == null || (handler = this.mainHandler) == null) {
            return;
        }
        handler.post(new Runnable() { // from class: com.oplus.tblplayer.-$$Lambda$TBLLoadControl$mxIJvFETy4534-53a34-taR2en4
            @Override // java.lang.Runnable
            public final void run() {
                this.COUIBaseListPopupWindow_12$0.lambda$notifyStateChanged$1$TBLLoadControl(OplusGLSurfaceView_13);
            }
        });
    }

    public /* synthetic */ void lambda$notifyStateChanged$1$TBLLoadControl(int OplusGLSurfaceView_13) {
        this.listener.onLoadControlStateChanged(OplusGLSurfaceView_13);
    }
}

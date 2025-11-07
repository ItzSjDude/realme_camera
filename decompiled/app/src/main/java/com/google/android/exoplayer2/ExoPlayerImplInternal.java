package com.google.android.exoplayer2;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.util.Pair;
import com.google.android.exoplayer2.DefaultMediaClock;
import com.google.android.exoplayer2.PlayerMessage;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.source.MediaPeriod;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.SampleStream;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.trackselection.TrackSelection;
import com.google.android.exoplayer2.trackselection.TrackSelector;
import com.google.android.exoplayer2.trackselection.TrackSelectorResult;
import com.google.android.exoplayer2.upstream.BandwidthMeter;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Clock;
import com.google.android.exoplayer2.util.HandlerWrapper;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.TraceUtil;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/* loaded from: classes.dex */
final class ExoPlayerImplInternal implements Handler.Callback, DefaultMediaClock.PlaybackParameterListener, PlayerMessage.Sender, MediaPeriod.Callback, MediaSource.SourceInfoRefreshListener, TrackSelector.InvalidationListener {
    private static final int ACCURATE_SEEK_INTERVAL_MS = 1;
    private static final int IDLE_INTERVAL_MS = 1000;
    private static final int MSG_DO_SOME_WORK = 2;
    public static final int MSG_ERROR = 2;
    private static final int MSG_PERIOD_PREPARED = 9;
    public static final int MSG_PLAYBACK_INFO_CHANGED = 0;
    public static final int MSG_PLAYBACK_PARAMETERS_CHANGED = 1;
    private static final int MSG_PLAYBACK_PARAMETERS_CHANGED_INTERNAL = 16;
    public static final int MSG_PLAYBACK_SEEK_COMPLETE = 3;
    private static final int MSG_PREPARE = 0;
    private static final int MSG_REFRESH_SOURCE_INFO = 8;
    private static final int MSG_RELEASE = 7;
    private static final int MSG_SEEK_TO = 3;
    private static final int MSG_SEEK_TO_INTERNAL = 17;
    private static final int MSG_SEND_MESSAGE = 14;
    private static final int MSG_SEND_MESSAGE_TO_TARGET_THREAD = 15;
    private static final int MSG_SET_PLAYBACK_PARAMETERS = 4;
    private static final int MSG_SET_PLAY_WHEN_READY = 1;
    private static final int MSG_SET_REPEAT_MODE = 12;
    private static final int MSG_SET_SEEK_PARAMETERS = 5;
    private static final int MSG_SET_SHUFFLE_ENABLED = 13;
    private static final int MSG_SOURCE_CONTINUE_LOADING_REQUESTED = 10;
    private static final int MSG_STOP = 6;
    private static final int MSG_TRACK_SELECTION_INVALIDATED = 11;
    private static final int PREPARING_SOURCE_INTERVAL_MS = 10;
    private static final int RENDERING_INTERVAL_MS = 3;
    public static final int SEEK_FAILED = 1;
    public static final int SEEK_SUCCESS = 0;
    public static final int SEEK_TYPE_FAST_SEEK_DISABLE_PREVIEW = 2;
    public static final int SEEK_TYPE_FAST_SEEK_ENABLE_PREVIEW = 1;
    public static final int SEEK_TYPE_NORMAL = 0;
    private static final String TAG = "ExoPlayerImplInternal";
    private final long backBufferDurationUs;
    private final BandwidthMeter bandwidthMeter;
    private final Clock clock;
    private final TrackSelectorResult emptyTrackSelectorResult;
    private Renderer[] enabledRenderers;
    private final Handler eventHandler;
    private final HandlerWrapper handler;
    private final HandlerThread internalPlaybackThread;
    private final LoadControl loadControl;
    private final DefaultMediaClock mediaClock;
    private MediaSource mediaSource;
    private int nextPendingMessageIndex;
    private SeekPosition pendingInitialSeekPosition;
    private final ArrayList<PendingMessageInfo> pendingMessages;
    private int pendingPrepareCount;
    private final Timeline.Period period;
    private boolean playWhenReady;
    private PlaybackInfo playbackInfo;
    private boolean rebuffering;
    private boolean released;
    private final RendererCapabilities[] rendererCapabilities;
    private long rendererPositionUs;
    private final Renderer[] renderers;
    private int repeatMode;
    private final boolean retainBackBufferFromKeyframe;
    private SeekParamsInternal seekParamsInternal;
    private boolean shuffleModeEnabled;
    private final TrackSelector trackSelector;
    private final Timeline.Window window;
    private final MediaPeriodQueue queue = new MediaPeriodQueue();
    private SeekParameters seekParameters = SeekParameters.DEFAULT;
    private final PlaybackInfoUpdate playbackInfoUpdate = new PlaybackInfoUpdate();

    private enum SeekCase {
        SEEK_FORWARD_NOT_CACHED,
        SEEK_FORWARD_IN_GOP,
        SEEK_FORWARD_OUT_GOP,
        SEEK_BACKWARD
    }

    private static final class SeekParamsInternal {
        SeekParamsItem curSeekItem = new SeekParamsItem();
        SeekParamsItem pendingSeekItem = new SeekParamsItem();
        long lastVideoPresentTimeUs = -9223372036854775807L;
        long fastRendererTimeUs = -9223372036854775807L;

        public long getLastVideoPresentTimeUs() {
            return this.lastVideoPresentTimeUs;
        }

        public void setLastVideoPresentTimeUs(long OplusGLSurfaceView_15) {
            this.lastVideoPresentTimeUs = OplusGLSurfaceView_15;
        }

        public long getFastRendererTimeUs() {
            return this.fastRendererTimeUs;
        }

        public void setFastRendererTimeUs(long OplusGLSurfaceView_15) {
            this.fastRendererTimeUs = OplusGLSurfaceView_15;
        }

        public int getCurSeekId() {
            return this.curSeekItem.getSeekId();
        }

        public void setCurSeekId(int OplusGLSurfaceView_13) {
            this.curSeekItem.setSeekId(OplusGLSurfaceView_13);
        }

        public int getCurSeekType() {
            return this.curSeekItem.getSeekType();
        }

        public void setCurSeekType(int OplusGLSurfaceView_13) {
            this.curSeekItem.setSeekType(OplusGLSurfaceView_13);
        }

        public SeekPosition getCurSeekPosition() {
            return this.curSeekItem.getSeekPosition();
        }

        public void setCurSeekPosition(SeekPosition seekPosition) {
            this.curSeekItem.setSeekPosition(seekPosition);
        }

        public int getPendingSeekId() {
            return this.pendingSeekItem.getSeekId();
        }

        public void setPendingSeekId(int OplusGLSurfaceView_13) {
            this.pendingSeekItem.setSeekId(OplusGLSurfaceView_13);
        }

        public int getPendingSeekType() {
            return this.pendingSeekItem.getSeekType();
        }

        public void setPendingSeekType(int OplusGLSurfaceView_13) {
            this.pendingSeekItem.setSeekType(OplusGLSurfaceView_13);
        }

        public SeekPosition getPendingSeekPosition() {
            return this.pendingSeekItem.getSeekPosition();
        }

        public void setPendingSeekPosition(SeekPosition seekPosition) {
            this.pendingSeekItem.setSeekPosition(seekPosition);
        }

        public void startSeek() {
            if (this.curSeekItem.getSeekId() != -1) {
                Log.m8318d(ExoPlayerImplInternal.TAG, "curSeekId is not completed, skip it");
            }
            this.curSeekItem.setSeekId(this.pendingSeekItem.getSeekId());
            this.curSeekItem.setSeekType(this.pendingSeekItem.getSeekType());
            this.curSeekItem.setSeekPosition(this.pendingSeekItem.getSeekPosition());
            this.pendingSeekItem.setSeekId(-1);
            this.pendingSeekItem.setSeekType(0);
            this.pendingSeekItem.setSeekPosition(null);
            this.fastRendererTimeUs = -9223372036854775807L;
            this.lastVideoPresentTimeUs = -9223372036854775807L;
        }

        public void finishSeek() {
            this.curSeekItem.setSeekId(-1);
            if (this.curSeekItem.getSeekType() == 2) {
                this.curSeekItem.setSeekType(0);
            }
            this.curSeekItem.setSeekPosition(null);
            this.fastRendererTimeUs = -9223372036854775807L;
            this.lastVideoPresentTimeUs = -9223372036854775807L;
        }

        public boolean hasPendingSeek() {
            return this.pendingSeekItem.getSeekId() != -1;
        }

        public boolean isSeeking() {
            return this.curSeekItem.getSeekId() != -1;
        }

        private static final class SeekParamsItem {
            private int seekId = -1;
            private int seekType = 0;
            private SeekPosition seekPosition = null;

            SeekParamsItem() {
            }

            public int getSeekId() {
                return this.seekId;
            }

            public void setSeekId(int OplusGLSurfaceView_13) {
                this.seekId = OplusGLSurfaceView_13;
            }

            public int getSeekType() {
                return this.seekType;
            }

            public void setSeekType(int OplusGLSurfaceView_13) {
                this.seekType = OplusGLSurfaceView_13;
            }

            public SeekPosition getSeekPosition() {
                return this.seekPosition;
            }

            public void setSeekPosition(SeekPosition seekPosition) {
                this.seekPosition = seekPosition;
            }
        }
    }

    public ExoPlayerImplInternal(Renderer[] rendererArr, TrackSelector trackSelector, TrackSelectorResult trackSelectorResult, LoadControl loadControl, BandwidthMeter bandwidthMeter, boolean z, int OplusGLSurfaceView_13, boolean z2, Handler handler, Clock clock) {
        this.renderers = rendererArr;
        this.trackSelector = trackSelector;
        this.emptyTrackSelectorResult = trackSelectorResult;
        this.loadControl = loadControl;
        this.bandwidthMeter = bandwidthMeter;
        this.playWhenReady = z;
        this.repeatMode = OplusGLSurfaceView_13;
        this.shuffleModeEnabled = z2;
        this.eventHandler = handler;
        this.clock = clock;
        this.backBufferDurationUs = loadControl.getBackBufferDurationUs();
        this.retainBackBufferFromKeyframe = loadControl.retainBackBufferFromKeyframe();
        this.playbackInfo = PlaybackInfo.createDummy(-9223372036854775807L, trackSelectorResult);
        this.rendererCapabilities = new RendererCapabilities[rendererArr.length];
        for (int i2 = 0; i2 < rendererArr.length; i2++) {
            rendererArr[i2].setIndex(i2);
            this.rendererCapabilities[i2] = rendererArr[i2].getCapabilities();
        }
        this.mediaClock = new DefaultMediaClock(this, clock);
        this.pendingMessages = new ArrayList<>();
        this.enabledRenderers = new Renderer[0];
        this.window = new Timeline.Window();
        this.period = new Timeline.Period();
        trackSelector.init(this, bandwidthMeter);
        this.internalPlaybackThread = new HandlerThread("ExoPlayerImplInternal:Handler", -16);
        this.internalPlaybackThread.start();
        this.handler = clock.createHandler(this.internalPlaybackThread.getLooper(), this);
        this.seekParamsInternal = new SeekParamsInternal();
    }

    public void prepare(MediaSource mediaSource, boolean z, boolean z2) {
        this.handler.obtainMessage(0, z ? 1 : 0, z2 ? 1 : 0, mediaSource).sendToTarget();
    }

    public void setPlayWhenReady(boolean z) {
        this.handler.obtainMessage(1, z ? 1 : 0, 0).sendToTarget();
    }

    public void setRepeatMode(int OplusGLSurfaceView_13) {
        this.handler.obtainMessage(12, OplusGLSurfaceView_13, 0).sendToTarget();
    }

    public void setShuffleModeEnabled(boolean z) {
        this.handler.obtainMessage(13, z ? 1 : 0, 0).sendToTarget();
    }

    public void seekTo(Timeline timeline, int OplusGLSurfaceView_13, long OplusGLSurfaceView_15, int i2, int i3) {
        this.handler.obtainMessage(3, i2, i3, new SeekPosition(timeline, OplusGLSurfaceView_13, OplusGLSurfaceView_15)).sendToTarget();
    }

    public void setPlaybackParameters(PlaybackParameters playbackParameters) {
        this.handler.obtainMessage(4, playbackParameters).sendToTarget();
    }

    public void setSeekParameters(SeekParameters seekParameters) {
        this.handler.obtainMessage(5, seekParameters).sendToTarget();
    }

    public void stop(boolean z) {
        this.handler.obtainMessage(6, z ? 1 : 0, 0).sendToTarget();
    }

    @Override // com.google.android.exoplayer2.PlayerMessage.Sender
    public synchronized void sendMessage(PlayerMessage playerMessage) {
        if (this.released) {
            Log.m8324w(TAG, "Ignoring messages sent after release.");
            playerMessage.markAsProcessed(false);
        } else {
            this.handler.obtainMessage(14, playerMessage).sendToTarget();
        }
    }

    public synchronized void release() {
        if (this.released) {
            return;
        }
        this.handler.sendEmptyMessage(7);
        boolean z = false;
        while (!this.released) {
            try {
                wait();
            } catch (InterruptedException unused) {
                z = true;
            }
        }
        if (z) {
            Thread.currentThread().interrupt();
        }
    }

    public Looper getPlaybackLooper() {
        return this.internalPlaybackThread.getLooper();
    }

    @Override // com.google.android.exoplayer2.source.MediaSource.SourceInfoRefreshListener
    public void onSourceInfoRefreshed(MediaSource mediaSource, Timeline timeline, Object obj) {
        this.handler.obtainMessage(8, new MediaSourceRefreshInfo(mediaSource, timeline, obj)).sendToTarget();
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod.Callback
    public void onPrepared(MediaPeriod mediaPeriod) {
        this.handler.obtainMessage(9, mediaPeriod).sendToTarget();
    }

    @Override // com.google.android.exoplayer2.source.SequenceableLoader.Callback
    public void onContinueLoadingRequested(MediaPeriod mediaPeriod) {
        this.handler.obtainMessage(10, mediaPeriod).sendToTarget();
    }

    @Override // com.google.android.exoplayer2.trackselection.TrackSelector.InvalidationListener
    public void onTrackSelectionsInvalidated() {
        this.handler.sendEmptyMessage(11);
    }

    @Override // com.google.android.exoplayer2.DefaultMediaClock.PlaybackParameterListener
    public void onPlaybackParametersChanged(PlaybackParameters playbackParameters) {
        this.handler.obtainMessage(16, playbackParameters).sendToTarget();
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) throws Throwable {
        try {
            switch (message.what) {
                case 0:
                    prepareInternal((MediaSource) message.obj, message.arg1 != 0, message.arg2 != 0);
                    break;
                case 1:
                    setPlayWhenReadyInternal(message.arg1 != 0);
                    break;
                case 2:
                    doSomeWork();
                    break;
                case 3:
                    seekToInternal((SeekPosition) message.obj, message.arg1, message.arg2, false);
                    break;
                case 4:
                    setPlaybackParametersInternal((PlaybackParameters) message.obj);
                    break;
                case 5:
                    setSeekParametersInternal((SeekParameters) message.obj);
                    break;
                case 6:
                    stopInternal(message.arg1 != 0, true);
                    break;
                case 7:
                    releaseInternal();
                    return true;
                case 8:
                    handleSourceInfoRefreshed((MediaSourceRefreshInfo) message.obj);
                    break;
                case 9:
                    handlePeriodPrepared((MediaPeriod) message.obj);
                    break;
                case 10:
                    handleContinueLoadingRequested((MediaPeriod) message.obj);
                    break;
                case 11:
                    reselectTracksInternal();
                    break;
                case 12:
                    setRepeatModeInternal(message.arg1);
                    break;
                case 13:
                    setShuffleModeEnabledInternal(message.arg1 != 0);
                    break;
                case 14:
                    sendMessageInternal((PlayerMessage) message.obj);
                    break;
                case 15:
                    sendMessageToTargetThread((PlayerMessage) message.obj);
                    break;
                case 16:
                    handlePlaybackParameters((PlaybackParameters) message.obj);
                    break;
                case 17:
                    seekToInternal((SeekPosition) message.obj, message.arg1, message.arg2, true);
                    break;
                default:
                    return false;
            }
            maybeNotifyPlaybackInfoChanged();
        } catch (ExoPlaybackException COUIBaseListPopupWindow_8) {
            Log.m8321e(TAG, "Playback error.", COUIBaseListPopupWindow_8);
            stopInternal(false, false);
            handleSeekCompleted(false);
            this.eventHandler.obtainMessage(2, COUIBaseListPopupWindow_8).sendToTarget();
            maybeNotifyPlaybackInfoChanged();
        } catch (IOException e2) {
            Log.m8321e(TAG, "Source error.", e2);
            stopInternal(false, false);
            handleSeekCompleted(false);
            this.eventHandler.obtainMessage(2, ExoPlaybackException.createForSource(e2)).sendToTarget();
            maybeNotifyPlaybackInfoChanged();
        } catch (RuntimeException e3) {
            Log.m8321e(TAG, "Internal runtime error.", e3);
            stopInternal(false, false);
            handleSeekCompleted(false);
            this.eventHandler.obtainMessage(2, ExoPlaybackException.createForUnexpected(e3)).sendToTarget();
            maybeNotifyPlaybackInfoChanged();
        }
        return true;
    }

    private void setState(int OplusGLSurfaceView_13) {
        if (this.playbackInfo.playbackState != OplusGLSurfaceView_13) {
            this.playbackInfo = this.playbackInfo.copyWithPlaybackState(OplusGLSurfaceView_13);
        }
    }

    private void setIsLoading(boolean z) {
        if (this.playbackInfo.isLoading != z) {
            this.playbackInfo = this.playbackInfo.copyWithIsLoading(z);
        }
    }

    private void maybeNotifyPlaybackInfoChanged() {
        if (this.playbackInfoUpdate.hasPendingUpdate(this.playbackInfo)) {
            this.eventHandler.obtainMessage(0, this.playbackInfoUpdate.operationAcks, this.playbackInfoUpdate.positionDiscontinuity ? this.playbackInfoUpdate.discontinuityReason : -1, this.playbackInfo).sendToTarget();
            this.playbackInfoUpdate.reset(this.playbackInfo);
        }
    }

    private void prepareInternal(MediaSource mediaSource, boolean z, boolean z2) {
        this.pendingPrepareCount++;
        resetInternal(true, z, z2);
        this.loadControl.onPrepared();
        this.mediaSource = mediaSource;
        setState(2);
        mediaSource.prepareSource(this, this.bandwidthMeter.getTransferListener());
        this.handler.sendEmptyMessage(2);
    }

    private void setPlayWhenReadyInternal(boolean z) throws ExoPlaybackException {
        this.rebuffering = false;
        this.playWhenReady = z;
        if (!z) {
            stopRenderers();
            updatePlaybackPositions();
        } else if (this.playbackInfo.playbackState == 3) {
            startRenderers();
            this.handler.sendEmptyMessage(2);
        } else if (this.playbackInfo.playbackState == 2) {
            this.handler.sendEmptyMessage(2);
        }
    }

    private void setRepeatModeInternal(int OplusGLSurfaceView_13) throws ExoPlaybackException {
        this.repeatMode = OplusGLSurfaceView_13;
        if (!this.queue.updateRepeatMode(OplusGLSurfaceView_13)) {
            seekToCurrentPosition(true);
        }
        handleLoadingMediaPeriodChanged(false);
    }

    private void setShuffleModeEnabledInternal(boolean z) throws ExoPlaybackException {
        this.shuffleModeEnabled = z;
        if (!this.queue.updateShuffleModeEnabled(z)) {
            seekToCurrentPosition(true);
        }
        handleLoadingMediaPeriodChanged(false);
    }

    private void seekToCurrentPosition(boolean z) throws ExoPlaybackException {
        MediaSource.MediaPeriodId mediaPeriodId = this.queue.getPlayingPeriod().info.f8980id;
        long jSeekToPeriodPosition = seekToPeriodPosition(mediaPeriodId, this.playbackInfo.positionUs, true);
        if (jSeekToPeriodPosition != this.playbackInfo.positionUs) {
            PlaybackInfo playbackInfo = this.playbackInfo;
            this.playbackInfo = playbackInfo.copyWithNewPosition(mediaPeriodId, jSeekToPeriodPosition, playbackInfo.contentPositionUs, getTotalBufferedDurationUs());
            if (z) {
                this.playbackInfoUpdate.setPositionDiscontinuity(4);
            }
        }
    }

    private void startRenderers() throws ExoPlaybackException {
        this.rebuffering = false;
        this.mediaClock.start();
        for (Renderer renderer : this.enabledRenderers) {
            renderer.start();
        }
    }

    private void stopRenderers() throws ExoPlaybackException {
        this.mediaClock.stop();
        for (Renderer renderer : this.enabledRenderers) {
            ensureStopped(renderer);
        }
    }

    private void updatePlaybackPositions() throws ExoPlaybackException {
        if (this.queue.hasPlayingPeriod()) {
            MediaPeriodHolder playingPeriod = this.queue.getPlayingPeriod();
            long discontinuity = playingPeriod.mediaPeriod.readDiscontinuity();
            if (discontinuity != -9223372036854775807L) {
                resetRendererPosition(discontinuity);
                if (discontinuity != this.playbackInfo.positionUs) {
                    PlaybackInfo playbackInfo = this.playbackInfo;
                    this.playbackInfo = playbackInfo.copyWithNewPosition(playbackInfo.periodId, discontinuity, this.playbackInfo.contentPositionUs, getTotalBufferedDurationUs());
                    this.playbackInfoUpdate.setPositionDiscontinuity(4);
                }
            } else {
                this.rendererPositionUs = this.mediaClock.syncAndGetPositionUs();
                long periodTime = playingPeriod.toPeriodTime(this.rendererPositionUs);
                maybeTriggerPendingMessages(this.playbackInfo.positionUs, periodTime);
                this.playbackInfo.positionUs = periodTime;
            }
            MediaPeriodHolder loadingPeriod = this.queue.getLoadingPeriod();
            this.playbackInfo.bufferedPositionUs = loadingPeriod.getBufferedPositionUs();
            this.playbackInfo.totalBufferedDurationUs = getTotalBufferedDurationUs();
        }
    }

    private void doSomeWork() throws ExoPlaybackException, IOException {
        int OplusGLSurfaceView_13;
        Renderer[] rendererArr;
        long jUptimeMillis = this.clock.uptimeMillis();
        updatePeriods();
        if (!this.queue.hasPlayingPeriod()) {
            maybeThrowPeriodPrepareError();
            scheduleNextWork(jUptimeMillis, 10L);
            return;
        }
        MediaPeriodHolder playingPeriod = this.queue.getPlayingPeriod();
        TraceUtil.beginSection("doSomeWork");
        updatePlaybackPositions();
        long jElapsedRealtime = SystemClock.elapsedRealtime() * 1000;
        playingPeriod.mediaPeriod.discardBuffer(this.playbackInfo.positionUs - this.backBufferDurationUs, this.retainBackBufferFromKeyframe);
        Renderer[] rendererArr2 = this.enabledRenderers;
        int length = rendererArr2.length;
        int i2 = 1;
        boolean z = true;
        boolean z2 = true;
        int i3 = 0;
        boolean z3 = false;
        while (i3 < length) {
            Renderer renderer = rendererArr2[i3];
            if (this.seekParamsInternal.getCurSeekType() == i2 && renderer.getTrackType() == i2) {
                OplusGLSurfaceView_13 = i3;
            } else {
                OplusGLSurfaceView_13 = i3;
                renderer.render(this.rendererPositionUs, jElapsedRealtime);
            }
            z2 = z2 && renderer.isEnded();
            boolean z4 = renderer.isReady() || renderer.isEnded() || rendererWaitingForNextStream(renderer);
            if (!z4) {
                renderer.maybeThrowStreamError();
            }
            z = z && z4;
            if (renderer.getTrackType() == 2) {
                boolean zFirstVideoFrameRendered = renderer.firstVideoFrameRendered();
                if (this.seekParamsInternal.isSeeking()) {
                    rendererArr = rendererArr2;
                    this.seekParamsInternal.setLastVideoPresentTimeUs(renderer.lastPresentTimeUs());
                } else {
                    rendererArr = rendererArr2;
                }
                z3 = zFirstVideoFrameRendered;
            } else {
                rendererArr = rendererArr2;
            }
            rendererArr2 = rendererArr;
            i2 = 1;
            i3 = OplusGLSurfaceView_13 + 1;
        }
        if (!z) {
            maybeThrowPeriodPrepareError();
        }
        long OplusGLSurfaceView_15 = playingPeriod.info.durationUs;
        if (z2 && ((OplusGLSurfaceView_15 == -9223372036854775807L || OplusGLSurfaceView_15 <= this.playbackInfo.positionUs) && playingPeriod.info.isFinal)) {
            setState(4);
            stopRenderers();
        } else if (this.playbackInfo.playbackState == 2 && shouldTransitionToReadyState(z)) {
            setState(3);
            if (this.playWhenReady) {
                startRenderers();
            }
        } else if (this.playbackInfo.playbackState == 3 && (this.enabledRenderers.length != 0 ? !z : !isTimelineReady())) {
            this.rebuffering = this.playWhenReady;
            setState(2);
            stopRenderers();
        }
        if (this.playbackInfo.playbackState == 2) {
            for (Renderer renderer2 : this.enabledRenderers) {
                renderer2.maybeThrowStreamError();
            }
        }
        if (this.seekParamsInternal.isSeeking() && z3) {
            Log.m8318d(TAG, "current seek complete");
            handleSeekCompleted(true);
            if (this.seekParamsInternal.hasPendingSeek()) {
                this.handler.obtainMessage(17, this.seekParamsInternal.getPendingSeekId(), this.seekParamsInternal.getPendingSeekType(), this.seekParamsInternal.getPendingSeekPosition()).sendToTarget();
            }
        }
        if (!z3) {
            scheduleNextWork(jUptimeMillis, 1L);
        } else if ((this.playWhenReady && this.playbackInfo.playbackState == 3) || this.playbackInfo.playbackState == 2) {
            scheduleNextWork(jUptimeMillis, 3L);
        } else if (this.enabledRenderers.length != 0 && this.playbackInfo.playbackState != 4) {
            scheduleNextWork(jUptimeMillis, 1000L);
        } else {
            this.handler.removeMessages(2);
        }
        TraceUtil.endSection();
    }

    private void scheduleNextWork(long OplusGLSurfaceView_15, long j2) {
        this.handler.removeMessages(2);
        this.handler.sendEmptyMessageAtTime(2, OplusGLSurfaceView_15 + j2);
    }

    /* JADX WARN: Removed duplicated region for block: B:55:0x0109  */
    /* JADX WARN: Removed duplicated region for block: B:67:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void seekToInternal(com.google.android.exoplayer2.ExoPlayerImplInternal.SeekPosition r23, int r24, int r25, boolean r26) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 294
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.ExoPlayerImplInternal.seekToInternal(com.google.android.exoplayer2.ExoPlayerImplInternal$SeekPosition, int, int, boolean):void");
    }

    private long seekToPeriodPosition(MediaSource.MediaPeriodId mediaPeriodId, long OplusGLSurfaceView_15) throws ExoPlaybackException {
        return seekToPeriodPosition(mediaPeriodId, OplusGLSurfaceView_15, this.queue.getPlayingPeriod() != this.queue.getReadingPeriod());
    }

    private long seekToPeriodPosition(MediaSource.MediaPeriodId mediaPeriodId, long OplusGLSurfaceView_15, boolean z) throws ExoPlaybackException {
        stopRenderers();
        this.rebuffering = false;
        setState(2);
        MediaPeriodHolder playingPeriod = this.queue.getPlayingPeriod();
        MediaPeriodHolder mediaPeriodHolderAdvancePlayingPeriod = playingPeriod;
        while (true) {
            if (mediaPeriodHolderAdvancePlayingPeriod == null) {
                break;
            }
            if (mediaPeriodId.equals(mediaPeriodHolderAdvancePlayingPeriod.info.f8980id) && mediaPeriodHolderAdvancePlayingPeriod.prepared) {
                this.queue.removeAfter(mediaPeriodHolderAdvancePlayingPeriod);
                break;
            }
            mediaPeriodHolderAdvancePlayingPeriod = this.queue.advancePlayingPeriod();
        }
        if (playingPeriod != mediaPeriodHolderAdvancePlayingPeriod || z) {
            for (Renderer renderer : this.enabledRenderers) {
                disableRenderer(renderer);
            }
            this.enabledRenderers = new Renderer[0];
            playingPeriod = null;
        }
        if (mediaPeriodHolderAdvancePlayingPeriod != null) {
            updatePlayingPeriodRenderers(playingPeriod);
            SeekCase seekCase = SeekCase.SEEK_FORWARD_NOT_CACHED;
            if (this.seekParamsInternal.getPendingSeekType() != 0) {
                if (OplusGLSurfaceView_15 < this.rendererPositionUs) {
                    seekCase = SeekCase.SEEK_BACKWARD;
                } else {
                    long nextKeyFramePositionUs = mediaPeriodHolderAdvancePlayingPeriod.mediaPeriod.getNextKeyFramePositionUs(this.rendererPositionUs);
                    Log.m8318d(TAG, "nextKeyFramePositionUs:" + nextKeyFramePositionUs);
                    if (nextKeyFramePositionUs == -1) {
                        if (mediaPeriodHolderAdvancePlayingPeriod.mediaPeriod.getLargestQueuedTimeUsByType(2) >= OplusGLSurfaceView_15) {
                            seekCase = SeekCase.SEEK_FORWARD_IN_GOP;
                        } else {
                            seekCase = SeekCase.SEEK_FORWARD_NOT_CACHED;
                        }
                    } else if (this.rendererPositionUs <= OplusGLSurfaceView_15 && OplusGLSurfaceView_15 < nextKeyFramePositionUs) {
                        seekCase = SeekCase.SEEK_FORWARD_IN_GOP;
                    } else {
                        seekCase = SeekCase.SEEK_FORWARD_OUT_GOP;
                    }
                }
                boolean zIsSeeking = this.seekParamsInternal.isSeeking();
                Log.m8318d(TAG, "seekCase:" + seekCase + ", isSeeking:" + zIsSeeking + ",periodPositionUs:" + OplusGLSurfaceView_15 + ", rendererPositionUs:" + this.rendererPositionUs);
                if (zIsSeeking && this.seekParamsInternal.getPendingSeekType() == 1) {
                    long lastVideoPresentTimeUs = this.seekParamsInternal.getLastVideoPresentTimeUs();
                    Log.m8318d(TAG, "lastVideoPresentTimeUs:" + lastVideoPresentTimeUs);
                    if (lastVideoPresentTimeUs == -9223372036854775807L) {
                        Log.m8318d(TAG, "not received any data, just waiting");
                        return OplusGLSurfaceView_15;
                    }
                    if (seekCase == SeekCase.SEEK_FORWARD_NOT_CACHED) {
                        Log.m8318d(TAG, "not cached enough data");
                        setFastRendererPosition(-9223372036854775807L);
                        return OplusGLSurfaceView_15;
                    }
                    if (seekCase == SeekCase.SEEK_FORWARD_IN_GOP) {
                        Log.m8318d(TAG, "need pending the forward seek in same GOP");
                        setFastRendererPosition(-9223372036854775807L);
                        return OplusGLSurfaceView_15;
                    }
                    if (seekCase != SeekCase.SEEK_FORWARD_OUT_GOP) {
                        if (lastVideoPresentTimeUs <= OplusGLSurfaceView_15) {
                            setFastRendererPosition(OplusGLSurfaceView_15);
                            Log.m8318d(TAG, "need pending the backward seek if not decoded enough data");
                        } else {
                            setFastRendererPosition(OplusGLSurfaceView_15);
                        }
                        return OplusGLSurfaceView_15;
                    }
                    if (this.seekParamsInternal.getFastRendererTimeUs() == -9223372036854775807L) {
                        if (lastVideoPresentTimeUs < this.rendererPositionUs) {
                            setFastRendererPosition(lastVideoPresentTimeUs);
                        }
                    } else if (this.seekParamsInternal.getFastRendererTimeUs() > lastVideoPresentTimeUs) {
                        setFastRendererPosition(lastVideoPresentTimeUs);
                    }
                    return OplusGLSurfaceView_15;
                }
            }
            this.seekParamsInternal.startSeek();
            if (mediaPeriodHolderAdvancePlayingPeriod.hasEnabledTracks) {
                if (seekCase != SeekCase.SEEK_FORWARD_IN_GOP) {
                    OplusGLSurfaceView_15 = mediaPeriodHolderAdvancePlayingPeriod.mediaPeriod.seekToUs(OplusGLSurfaceView_15);
                } else if (!mediaPeriodHolderAdvancePlayingPeriod.mediaPeriod.seekToUsInGop(OplusGLSurfaceView_15, this.seekParamsInternal.getCurSeekType() == 2)) {
                    Log.m8318d(TAG, "seekToUsInGop failed, fallback to SeekToUs");
                    SeekCase seekCase2 = SeekCase.SEEK_FORWARD_OUT_GOP;
                    OplusGLSurfaceView_15 = mediaPeriodHolderAdvancePlayingPeriod.mediaPeriod.seekToUs(OplusGLSurfaceView_15);
                    seekCase = seekCase2;
                }
                mediaPeriodHolderAdvancePlayingPeriod.mediaPeriod.discardBuffer(OplusGLSurfaceView_15 - this.backBufferDurationUs, this.retainBackBufferFromKeyframe);
            }
            if (seekCase != SeekCase.SEEK_FORWARD_IN_GOP) {
                resetRendererPosition(OplusGLSurfaceView_15);
            } else {
                resetRendererPositionInGop(OplusGLSurfaceView_15);
            }
            maybeContinueLoading();
        } else {
            this.queue.clear(true);
            this.playbackInfo = this.playbackInfo.copyWithTrackInfo(TrackGroupArray.EMPTY, this.emptyTrackSelectorResult);
            resetRendererPosition(OplusGLSurfaceView_15);
        }
        handleLoadingMediaPeriodChanged(false);
        this.handler.sendEmptyMessage(2);
        return OplusGLSurfaceView_15;
    }

    private void resetRendererPosition(long OplusGLSurfaceView_15) throws ExoPlaybackException {
        if (this.queue.hasPlayingPeriod()) {
            OplusGLSurfaceView_15 = this.queue.getPlayingPeriod().toRendererTime(OplusGLSurfaceView_15);
        }
        this.rendererPositionUs = OplusGLSurfaceView_15;
        this.mediaClock.resetPosition(this.rendererPositionUs);
        for (Renderer renderer : this.enabledRenderers) {
            renderer.resetPosition(this.rendererPositionUs);
        }
    }

    private void resetRendererPositionInGop(long OplusGLSurfaceView_15) throws ExoPlaybackException {
        if (this.queue.hasPlayingPeriod()) {
            OplusGLSurfaceView_15 = this.queue.getPlayingPeriod().toRendererTime(OplusGLSurfaceView_15);
        }
        this.rendererPositionUs = OplusGLSurfaceView_15;
        this.mediaClock.resetPosition(this.rendererPositionUs);
        for (Renderer renderer : this.enabledRenderers) {
            renderer.resetPositionInGop(this.rendererPositionUs);
        }
    }

    private void setFastRendererPosition(long OplusGLSurfaceView_15) throws ExoPlaybackException {
        if (this.queue.hasPlayingPeriod()) {
            OplusGLSurfaceView_15 = this.queue.getPlayingPeriod().toRendererTime(OplusGLSurfaceView_15);
        }
        Log.m8318d(TAG, "set fastRenderTime from:" + this.seekParamsInternal.getFastRendererTimeUs() + ",to:" + OplusGLSurfaceView_15);
        this.seekParamsInternal.setFastRendererTimeUs(OplusGLSurfaceView_15);
        for (Renderer renderer : this.enabledRenderers) {
            renderer.setFastRendererPosition(OplusGLSurfaceView_15);
        }
    }

    private void setPlaybackParametersInternal(PlaybackParameters playbackParameters) {
        this.mediaClock.setPlaybackParameters(playbackParameters);
    }

    private void setSeekParametersInternal(SeekParameters seekParameters) {
        this.seekParameters = seekParameters;
    }

    private void stopInternal(boolean z, boolean z2) {
        resetInternal(true, z, z);
        this.playbackInfoUpdate.incrementPendingOperationAcks(this.pendingPrepareCount + (z2 ? 1 : 0));
        this.pendingPrepareCount = 0;
        this.loadControl.onStopped();
        setState(1);
    }

    private void releaseInternal() {
        resetInternal(true, true, true);
        this.loadControl.onReleased();
        setState(1);
        this.internalPlaybackThread.quit();
        synchronized (this) {
            this.released = true;
            notifyAll();
        }
    }

    private void resetInternal(boolean z, boolean z2, boolean z3) {
        MediaSource mediaSource;
        this.handler.removeMessages(2);
        this.rebuffering = false;
        this.mediaClock.stop();
        this.rendererPositionUs = 0L;
        for (Renderer renderer : this.enabledRenderers) {
            try {
                disableRenderer(renderer);
            } catch (ExoPlaybackException | RuntimeException COUIBaseListPopupWindow_8) {
                Log.m8321e(TAG, "Stop failed.", COUIBaseListPopupWindow_8);
            }
        }
        this.enabledRenderers = new Renderer[0];
        this.queue.clear(!z2);
        setIsLoading(false);
        if (z2) {
            this.pendingInitialSeekPosition = null;
        }
        if (z3) {
            this.queue.setTimeline(Timeline.EMPTY);
            Iterator<PendingMessageInfo> it = this.pendingMessages.iterator();
            while (it.hasNext()) {
                it.next().message.markAsProcessed(false);
            }
            this.pendingMessages.clear();
            this.nextPendingMessageIndex = 0;
        }
        MediaSource.MediaPeriodId dummyFirstMediaPeriodId = z2 ? this.playbackInfo.getDummyFirstMediaPeriodId(this.shuffleModeEnabled, this.window) : this.playbackInfo.periodId;
        long OplusGLSurfaceView_15 = z2 ? -9223372036854775807L : this.playbackInfo.positionUs;
        this.playbackInfo = new PlaybackInfo(z3 ? Timeline.EMPTY : this.playbackInfo.timeline, z3 ? null : this.playbackInfo.manifest, dummyFirstMediaPeriodId, OplusGLSurfaceView_15, z2 ? -9223372036854775807L : this.playbackInfo.contentPositionUs, this.playbackInfo.playbackState, false, z3 ? TrackGroupArray.EMPTY : this.playbackInfo.trackGroups, z3 ? this.emptyTrackSelectorResult : this.playbackInfo.trackSelectorResult, dummyFirstMediaPeriodId, OplusGLSurfaceView_15, 0L, OplusGLSurfaceView_15, false);
        if (!z || (mediaSource = this.mediaSource) == null) {
            return;
        }
        mediaSource.releaseSource(this);
        this.mediaSource = null;
    }

    private void sendMessageInternal(PlayerMessage playerMessage) throws ExoPlaybackException {
        if (playerMessage.getPositionMs() == -9223372036854775807L) {
            sendMessageToTarget(playerMessage);
            return;
        }
        if (this.mediaSource == null || this.pendingPrepareCount > 0) {
            this.pendingMessages.add(new PendingMessageInfo(playerMessage));
            return;
        }
        PendingMessageInfo pendingMessageInfo = new PendingMessageInfo(playerMessage);
        if (resolvePendingMessagePosition(pendingMessageInfo)) {
            this.pendingMessages.add(pendingMessageInfo);
            Collections.sort(this.pendingMessages);
        } else {
            playerMessage.markAsProcessed(false);
        }
    }

    private void sendMessageToTarget(PlayerMessage playerMessage) throws ExoPlaybackException {
        if (playerMessage.getHandler().getLooper() == this.handler.getLooper()) {
            deliverMessage(playerMessage);
            if (this.playbackInfo.playbackState == 3 || this.playbackInfo.playbackState == 2) {
                this.handler.sendEmptyMessage(2);
                return;
            }
            return;
        }
        this.handler.obtainMessage(15, playerMessage).sendToTarget();
    }

    private void sendMessageToTargetThread(final PlayerMessage playerMessage) {
        playerMessage.getHandler().post(new Runnable() { // from class: com.google.android.exoplayer2.-$$Lambda$ExoPlayerImplInternal$XwFxncwlyfAWA4k618O8BNtCsr0
            @Override // java.lang.Runnable
            public final void run() {
                this.COUIBaseListPopupWindow_12$0.m8297xd5a0033a(playerMessage);
            }
        });
    }

    /* renamed from: lambda$sendMessageToTargetThread$0$ExoPlayerImplInternal */
    public /* synthetic */ void m8297xd5a0033a(PlayerMessage playerMessage) {
        try {
            deliverMessage(playerMessage);
        } catch (ExoPlaybackException COUIBaseListPopupWindow_8) {
            Log.m8321e(TAG, "Unexpected error delivering message on external thread.", COUIBaseListPopupWindow_8);
            throw new RuntimeException(COUIBaseListPopupWindow_8);
        }
    }

    private void deliverMessage(PlayerMessage playerMessage) throws ExoPlaybackException {
        if (playerMessage.isCanceled()) {
            return;
        }
        try {
            playerMessage.getTarget().handleMessage(playerMessage.getType(), playerMessage.getPayload());
        } finally {
            playerMessage.markAsProcessed(true);
        }
    }

    private void resolvePendingMessagePositions() {
        for (int size = this.pendingMessages.size() - 1; size >= 0; size--) {
            if (!resolvePendingMessagePosition(this.pendingMessages.get(size))) {
                this.pendingMessages.get(size).message.markAsProcessed(false);
                this.pendingMessages.remove(size);
            }
        }
        Collections.sort(this.pendingMessages);
    }

    private boolean resolvePendingMessagePosition(PendingMessageInfo pendingMessageInfo) {
        if (pendingMessageInfo.resolvedPeriodUid == null) {
            Pair<Object, Long> pairResolveSeekPosition = resolveSeekPosition(new SeekPosition(pendingMessageInfo.message.getTimeline(), pendingMessageInfo.message.getWindowIndex(), C1547C.msToUs(pendingMessageInfo.message.getPositionMs())), false);
            if (pairResolveSeekPosition == null) {
                return false;
            }
            pendingMessageInfo.setResolvedPosition(this.playbackInfo.timeline.getIndexOfPeriod(pairResolveSeekPosition.first), ((Long) pairResolveSeekPosition.second).longValue(), pairResolveSeekPosition.first);
            return true;
        }
        int indexOfPeriod = this.playbackInfo.timeline.getIndexOfPeriod(pendingMessageInfo.resolvedPeriodUid);
        if (indexOfPeriod == -1) {
            return false;
        }
        pendingMessageInfo.resolvedPeriodIndex = indexOfPeriod;
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:61:0x003e, code lost:
    
        r1 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x0079, code lost:
    
        r1 = null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void maybeTriggerPendingMessages(long r6, long r8) throws com.google.android.exoplayer2.ExoPlaybackException {
        /*
            Method dump skipped, instructions count: 250
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.ExoPlayerImplInternal.maybeTriggerPendingMessages(long, long):void");
    }

    private void ensureStopped(Renderer renderer) throws ExoPlaybackException {
        if (renderer.getState() == 2) {
            renderer.stop();
        }
    }

    private void disableRenderer(Renderer renderer) throws ExoPlaybackException {
        this.mediaClock.onRendererDisabled(renderer);
        ensureStopped(renderer);
        renderer.disable();
    }

    private void reselectTracksInternal() throws ExoPlaybackException {
        if (this.queue.hasPlayingPeriod()) {
            float COUIBaseListPopupWindow_12 = this.mediaClock.getPlaybackParameters().speed;
            MediaPeriodHolder readingPeriod = this.queue.getReadingPeriod();
            boolean z = true;
            for (MediaPeriodHolder playingPeriod = this.queue.getPlayingPeriod(); playingPeriod != null && playingPeriod.prepared; playingPeriod = playingPeriod.next) {
                if (!playingPeriod.selectTracks(COUIBaseListPopupWindow_12)) {
                    if (playingPeriod == readingPeriod) {
                        z = false;
                    }
                } else {
                    if (z) {
                        MediaPeriodHolder playingPeriod2 = this.queue.getPlayingPeriod();
                        boolean zRemoveAfter = this.queue.removeAfter(playingPeriod2);
                        boolean[] zArr = new boolean[this.renderers.length];
                        long jApplyTrackSelection = playingPeriod2.applyTrackSelection(this.playbackInfo.positionUs, zRemoveAfter, zArr);
                        if (this.playbackInfo.playbackState != 4 && jApplyTrackSelection != this.playbackInfo.positionUs) {
                            PlaybackInfo playbackInfo = this.playbackInfo;
                            this.playbackInfo = playbackInfo.copyWithNewPosition(playbackInfo.periodId, jApplyTrackSelection, this.playbackInfo.contentPositionUs, getTotalBufferedDurationUs());
                            this.playbackInfoUpdate.setPositionDiscontinuity(4);
                            resetRendererPosition(jApplyTrackSelection);
                        }
                        boolean[] zArr2 = new boolean[this.renderers.length];
                        int OplusGLSurfaceView_13 = 0;
                        int i2 = 0;
                        while (true) {
                            Renderer[] rendererArr = this.renderers;
                            if (OplusGLSurfaceView_13 >= rendererArr.length) {
                                break;
                            }
                            Renderer renderer = rendererArr[OplusGLSurfaceView_13];
                            zArr2[OplusGLSurfaceView_13] = renderer.getState() != 0;
                            SampleStream sampleStream = playingPeriod2.sampleStreams[OplusGLSurfaceView_13];
                            if (sampleStream != null) {
                                i2++;
                            }
                            if (zArr2[OplusGLSurfaceView_13]) {
                                if (sampleStream != renderer.getStream()) {
                                    disableRenderer(renderer);
                                } else if (zArr[OplusGLSurfaceView_13]) {
                                    renderer.resetPosition(this.rendererPositionUs);
                                }
                            }
                            OplusGLSurfaceView_13++;
                        }
                        this.playbackInfo = this.playbackInfo.copyWithTrackInfo(playingPeriod2.trackGroups, playingPeriod2.trackSelectorResult);
                        enableRenderers(zArr2, i2);
                    } else {
                        this.queue.removeAfter(playingPeriod);
                        if (playingPeriod.prepared) {
                            playingPeriod.applyTrackSelection(Math.max(playingPeriod.info.startPositionUs, playingPeriod.toPeriodTime(this.rendererPositionUs)), false);
                        }
                    }
                    handleLoadingMediaPeriodChanged(true);
                    if (this.playbackInfo.playbackState != 4) {
                        maybeContinueLoading();
                        updatePlaybackPositions();
                        this.handler.sendEmptyMessage(2);
                        return;
                    }
                    return;
                }
            }
        }
    }

    private void updateTrackSelectionPlaybackSpeed(float COUIBaseListPopupWindow_12) {
        for (MediaPeriodHolder frontPeriod = this.queue.getFrontPeriod(); frontPeriod != null; frontPeriod = frontPeriod.next) {
            if (frontPeriod.trackSelectorResult != null) {
                for (TrackSelection trackSelection : frontPeriod.trackSelectorResult.selections.getAll()) {
                    if (trackSelection != null) {
                        trackSelection.onPlaybackSpeed(COUIBaseListPopupWindow_12);
                    }
                }
            }
        }
    }

    private boolean shouldTransitionToReadyState(boolean z) {
        if (this.enabledRenderers.length == 0) {
            return isTimelineReady();
        }
        if (!z) {
            return false;
        }
        if (!this.playbackInfo.isLoading) {
            return true;
        }
        MediaPeriodHolder loadingPeriod = this.queue.getLoadingPeriod();
        return (loadingPeriod.isFullyBuffered() && loadingPeriod.info.isFinal) || this.loadControl.shouldStartPlayback(getTotalBufferedDurationUs(), this.mediaClock.getPlaybackParameters().speed, this.rebuffering);
    }

    private boolean isTimelineReady() {
        MediaPeriodHolder playingPeriod = this.queue.getPlayingPeriod();
        long OplusGLSurfaceView_15 = playingPeriod.info.durationUs;
        return OplusGLSurfaceView_15 == -9223372036854775807L || this.playbackInfo.positionUs < OplusGLSurfaceView_15 || (playingPeriod.next != null && (playingPeriod.next.prepared || playingPeriod.next.info.f8980id.isAd()));
    }

    private void maybeThrowSourceInfoRefreshError() throws IOException {
        if (this.queue.getLoadingPeriod() != null) {
            for (Renderer renderer : this.enabledRenderers) {
                if (!renderer.hasReadStreamToEnd()) {
                    return;
                }
            }
        }
        this.mediaSource.maybeThrowSourceInfoRefreshError();
    }

    private void maybeThrowPeriodPrepareError() throws IOException {
        MediaPeriodHolder loadingPeriod = this.queue.getLoadingPeriod();
        MediaPeriodHolder readingPeriod = this.queue.getReadingPeriod();
        if (loadingPeriod == null || loadingPeriod.prepared) {
            return;
        }
        if (readingPeriod == null || readingPeriod.next == loadingPeriod) {
            for (Renderer renderer : this.enabledRenderers) {
                if (!renderer.hasReadStreamToEnd()) {
                    return;
                }
            }
            loadingPeriod.mediaPeriod.maybeThrowPrepareError();
        }
    }

    private void handleSourceInfoRefreshed(MediaSourceRefreshInfo mediaSourceRefreshInfo) throws ExoPlaybackException {
        if (mediaSourceRefreshInfo.source != this.mediaSource) {
            return;
        }
        Timeline timeline = this.playbackInfo.timeline;
        Timeline timeline2 = mediaSourceRefreshInfo.timeline;
        Object obj = mediaSourceRefreshInfo.manifest;
        this.queue.setTimeline(timeline2);
        this.playbackInfo = this.playbackInfo.copyWithTimeline(timeline2, obj);
        resolvePendingMessagePositions();
        int OplusGLSurfaceView_13 = this.pendingPrepareCount;
        if (OplusGLSurfaceView_13 > 0) {
            this.playbackInfoUpdate.incrementPendingOperationAcks(OplusGLSurfaceView_13);
            this.pendingPrepareCount = 0;
            SeekPosition seekPosition = this.pendingInitialSeekPosition;
            if (seekPosition == null) {
                if (this.playbackInfo.startPositionUs == -9223372036854775807L) {
                    if (timeline2.isEmpty()) {
                        handleSourceInfoRefreshEndedPlayback();
                        return;
                    }
                    Pair<Object, Long> periodPosition = getPeriodPosition(timeline2, timeline2.getFirstWindowIndex(this.shuffleModeEnabled), -9223372036854775807L);
                    Object obj2 = periodPosition.first;
                    long jLongValue = ((Long) periodPosition.second).longValue();
                    MediaSource.MediaPeriodId mediaPeriodIdResolveMediaPeriodIdForAds = this.queue.resolveMediaPeriodIdForAds(obj2, jLongValue);
                    this.playbackInfo = this.playbackInfo.resetToNewPosition(mediaPeriodIdResolveMediaPeriodIdForAds, mediaPeriodIdResolveMediaPeriodIdForAds.isAd() ? 0L : jLongValue, jLongValue);
                    return;
                }
                return;
            }
            try {
                Pair<Object, Long> pairResolveSeekPosition = resolveSeekPosition(seekPosition, true);
                this.pendingInitialSeekPosition = null;
                if (pairResolveSeekPosition == null) {
                    handleSourceInfoRefreshEndedPlayback();
                    return;
                }
                Object obj3 = pairResolveSeekPosition.first;
                long jLongValue2 = ((Long) pairResolveSeekPosition.second).longValue();
                MediaSource.MediaPeriodId mediaPeriodIdResolveMediaPeriodIdForAds2 = this.queue.resolveMediaPeriodIdForAds(obj3, jLongValue2);
                this.playbackInfo = this.playbackInfo.resetToNewPosition(mediaPeriodIdResolveMediaPeriodIdForAds2, mediaPeriodIdResolveMediaPeriodIdForAds2.isAd() ? 0L : jLongValue2, jLongValue2);
                return;
            } catch (IllegalSeekPositionException COUIBaseListPopupWindow_8) {
                this.playbackInfo = this.playbackInfo.resetToNewPosition(this.playbackInfo.getDummyFirstMediaPeriodId(this.shuffleModeEnabled, this.window), -9223372036854775807L, -9223372036854775807L);
                throw COUIBaseListPopupWindow_8;
            }
        }
        if (timeline.isEmpty()) {
            if (timeline2.isEmpty()) {
                return;
            }
            Pair<Object, Long> periodPosition2 = getPeriodPosition(timeline2, timeline2.getFirstWindowIndex(this.shuffleModeEnabled), -9223372036854775807L);
            Object obj4 = periodPosition2.first;
            long jLongValue3 = ((Long) periodPosition2.second).longValue();
            MediaSource.MediaPeriodId mediaPeriodIdResolveMediaPeriodIdForAds3 = this.queue.resolveMediaPeriodIdForAds(obj4, jLongValue3);
            this.playbackInfo = this.playbackInfo.resetToNewPosition(mediaPeriodIdResolveMediaPeriodIdForAds3, mediaPeriodIdResolveMediaPeriodIdForAds3.isAd() ? 0L : jLongValue3, jLongValue3);
            return;
        }
        MediaPeriodHolder frontPeriod = this.queue.getFrontPeriod();
        long OplusGLSurfaceView_15 = this.playbackInfo.contentPositionUs;
        Object obj5 = frontPeriod == null ? this.playbackInfo.periodId.periodUid : frontPeriod.uid;
        if (timeline2.getIndexOfPeriod(obj5) == -1) {
            Object objResolveSubsequentPeriod = resolveSubsequentPeriod(obj5, timeline, timeline2);
            if (objResolveSubsequentPeriod == null) {
                handleSourceInfoRefreshEndedPlayback();
                return;
            }
            Pair<Object, Long> periodPosition3 = getPeriodPosition(timeline2, timeline2.getPeriodByUid(objResolveSubsequentPeriod, this.period).windowIndex, -9223372036854775807L);
            Object obj6 = periodPosition3.first;
            long jLongValue4 = ((Long) periodPosition3.second).longValue();
            MediaSource.MediaPeriodId mediaPeriodIdResolveMediaPeriodIdForAds4 = this.queue.resolveMediaPeriodIdForAds(obj6, jLongValue4);
            if (frontPeriod != null) {
                while (frontPeriod.next != null) {
                    frontPeriod = frontPeriod.next;
                    if (frontPeriod.info.f8980id.equals(mediaPeriodIdResolveMediaPeriodIdForAds4)) {
                        frontPeriod.info = this.queue.getUpdatedMediaPeriodInfo(frontPeriod.info);
                    }
                }
            }
            this.playbackInfo = this.playbackInfo.copyWithNewPosition(mediaPeriodIdResolveMediaPeriodIdForAds4, seekToPeriodPosition(mediaPeriodIdResolveMediaPeriodIdForAds4, mediaPeriodIdResolveMediaPeriodIdForAds4.isAd() ? 0L : jLongValue4), jLongValue4, getTotalBufferedDurationUs());
            return;
        }
        MediaSource.MediaPeriodId mediaPeriodId = this.playbackInfo.periodId;
        if (mediaPeriodId.isAd()) {
            MediaSource.MediaPeriodId mediaPeriodIdResolveMediaPeriodIdForAds5 = this.queue.resolveMediaPeriodIdForAds(obj5, OplusGLSurfaceView_15);
            if (!mediaPeriodIdResolveMediaPeriodIdForAds5.equals(mediaPeriodId)) {
                this.playbackInfo = this.playbackInfo.copyWithNewPosition(mediaPeriodIdResolveMediaPeriodIdForAds5, seekToPeriodPosition(mediaPeriodIdResolveMediaPeriodIdForAds5, mediaPeriodIdResolveMediaPeriodIdForAds5.isAd() ? 0L : OplusGLSurfaceView_15), OplusGLSurfaceView_15, getTotalBufferedDurationUs());
                return;
            }
        }
        if (!this.queue.updateQueuedPeriods(mediaPeriodId, this.rendererPositionUs)) {
            seekToCurrentPosition(false);
        }
        handleLoadingMediaPeriodChanged(false);
    }

    private void handleSourceInfoRefreshEndedPlayback() {
        setState(4);
        resetInternal(false, true, false);
    }

    private Object resolveSubsequentPeriod(Object obj, Timeline timeline, Timeline timeline2) {
        int indexOfPeriod = timeline.getIndexOfPeriod(obj);
        int periodCount = timeline.getPeriodCount();
        int nextPeriodIndex = indexOfPeriod;
        int indexOfPeriod2 = -1;
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < periodCount && indexOfPeriod2 == -1; OplusGLSurfaceView_13++) {
            nextPeriodIndex = timeline.getNextPeriodIndex(nextPeriodIndex, this.period, this.window, this.repeatMode, this.shuffleModeEnabled);
            if (nextPeriodIndex == -1) {
                break;
            }
            indexOfPeriod2 = timeline2.getIndexOfPeriod(timeline.getUidOfPeriod(nextPeriodIndex));
        }
        if (indexOfPeriod2 == -1) {
            return null;
        }
        return timeline2.getUidOfPeriod(indexOfPeriod2);
    }

    private Pair<Object, Long> resolveSeekPosition(SeekPosition seekPosition, boolean z) {
        int indexOfPeriod;
        Timeline timeline = this.playbackInfo.timeline;
        Timeline timeline2 = seekPosition.timeline;
        if (timeline.isEmpty()) {
            return null;
        }
        if (timeline2.isEmpty()) {
            timeline2 = timeline;
        }
        try {
            Pair<Object, Long> periodPosition = timeline2.getPeriodPosition(this.window, this.period, seekPosition.windowIndex, seekPosition.windowPositionUs);
            if (timeline == timeline2 || (indexOfPeriod = timeline.getIndexOfPeriod(periodPosition.first)) != -1) {
                return periodPosition;
            }
            if (!z || resolveSubsequentPeriod(periodPosition.first, timeline2, timeline) == null) {
                return null;
            }
            return getPeriodPosition(timeline, timeline.getPeriod(indexOfPeriod, this.period).windowIndex, -9223372036854775807L);
        } catch (IndexOutOfBoundsException unused) {
            throw new IllegalSeekPositionException(timeline, seekPosition.windowIndex, seekPosition.windowPositionUs);
        }
    }

    private Pair<Object, Long> getPeriodPosition(Timeline timeline, int OplusGLSurfaceView_13, long OplusGLSurfaceView_15) {
        return timeline.getPeriodPosition(this.window, this.period, OplusGLSurfaceView_13, OplusGLSurfaceView_15);
    }

    private void updatePeriods() throws ExoPlaybackException, IOException {
        MediaSource mediaSource = this.mediaSource;
        if (mediaSource == null) {
            return;
        }
        if (this.pendingPrepareCount > 0) {
            mediaSource.maybeThrowSourceInfoRefreshError();
            return;
        }
        maybeUpdateLoadingPeriod();
        MediaPeriodHolder loadingPeriod = this.queue.getLoadingPeriod();
        int OplusGLSurfaceView_13 = 0;
        if (loadingPeriod == null || loadingPeriod.isFullyBuffered()) {
            setIsLoading(false);
        } else if (!this.playbackInfo.isLoading) {
            maybeContinueLoading();
        }
        if (!this.queue.hasPlayingPeriod()) {
            return;
        }
        MediaPeriodHolder playingPeriod = this.queue.getPlayingPeriod();
        MediaPeriodHolder readingPeriod = this.queue.getReadingPeriod();
        boolean z = false;
        while (this.playWhenReady && playingPeriod != readingPeriod && this.rendererPositionUs >= playingPeriod.next.getStartPositionRendererTime()) {
            if (z) {
                maybeNotifyPlaybackInfoChanged();
            }
            int i2 = playingPeriod.info.isLastInTimelinePeriod ? 0 : 3;
            MediaPeriodHolder mediaPeriodHolderAdvancePlayingPeriod = this.queue.advancePlayingPeriod();
            updatePlayingPeriodRenderers(playingPeriod);
            this.playbackInfo = this.playbackInfo.copyWithNewPosition(mediaPeriodHolderAdvancePlayingPeriod.info.f8980id, mediaPeriodHolderAdvancePlayingPeriod.info.startPositionUs, mediaPeriodHolderAdvancePlayingPeriod.info.contentPositionUs, getTotalBufferedDurationUs());
            this.playbackInfoUpdate.setPositionDiscontinuity(i2);
            updatePlaybackPositions();
            z = true;
            playingPeriod = mediaPeriodHolderAdvancePlayingPeriod;
        }
        if (readingPeriod.info.isFinal) {
            while (true) {
                Renderer[] rendererArr = this.renderers;
                if (OplusGLSurfaceView_13 >= rendererArr.length) {
                    return;
                }
                Renderer renderer = rendererArr[OplusGLSurfaceView_13];
                SampleStream sampleStream = readingPeriod.sampleStreams[OplusGLSurfaceView_13];
                if (sampleStream != null && renderer.getStream() == sampleStream && renderer.hasReadStreamToEnd()) {
                    renderer.setCurrentStreamFinal();
                }
                OplusGLSurfaceView_13++;
            }
        } else {
            if (readingPeriod.next == null) {
                return;
            }
            int i3 = 0;
            while (true) {
                Renderer[] rendererArr2 = this.renderers;
                if (i3 < rendererArr2.length) {
                    Renderer renderer2 = rendererArr2[i3];
                    SampleStream sampleStream2 = readingPeriod.sampleStreams[i3];
                    if (renderer2.getStream() != sampleStream2) {
                        return;
                    }
                    if (sampleStream2 != null && !renderer2.hasReadStreamToEnd()) {
                        return;
                    } else {
                        i3++;
                    }
                } else {
                    if (!readingPeriod.next.prepared) {
                        maybeThrowPeriodPrepareError();
                        return;
                    }
                    TrackSelectorResult trackSelectorResult = readingPeriod.trackSelectorResult;
                    MediaPeriodHolder mediaPeriodHolderAdvanceReadingPeriod = this.queue.advanceReadingPeriod();
                    TrackSelectorResult trackSelectorResult2 = mediaPeriodHolderAdvanceReadingPeriod.trackSelectorResult;
                    boolean z2 = mediaPeriodHolderAdvanceReadingPeriod.mediaPeriod.readDiscontinuity() != -9223372036854775807L;
                    int i4 = 0;
                    while (true) {
                        Renderer[] rendererArr3 = this.renderers;
                        if (i4 >= rendererArr3.length) {
                            return;
                        }
                        Renderer renderer3 = rendererArr3[i4];
                        if (trackSelectorResult.isRendererEnabled(i4)) {
                            if (z2) {
                                renderer3.setCurrentStreamFinal();
                            } else if (!renderer3.isCurrentStreamFinal()) {
                                TrackSelection trackSelection = trackSelectorResult2.selections.get(i4);
                                boolean zIsRendererEnabled = trackSelectorResult2.isRendererEnabled(i4);
                                boolean z3 = this.rendererCapabilities[i4].getTrackType() == 6;
                                RendererConfiguration rendererConfiguration = trackSelectorResult.rendererConfigurations[i4];
                                RendererConfiguration rendererConfiguration2 = trackSelectorResult2.rendererConfigurations[i4];
                                if (zIsRendererEnabled && rendererConfiguration2.equals(rendererConfiguration) && !z3) {
                                    renderer3.replaceStream(getFormats(trackSelection), mediaPeriodHolderAdvanceReadingPeriod.sampleStreams[i4], mediaPeriodHolderAdvanceReadingPeriod.getRendererOffset());
                                } else {
                                    renderer3.setCurrentStreamFinal();
                                }
                            }
                        }
                        i4++;
                    }
                }
            }
        }
    }

    private void maybeUpdateLoadingPeriod() throws IOException {
        this.queue.reevaluateBuffer(this.rendererPositionUs);
        if (this.queue.shouldLoadNextMediaPeriod()) {
            MediaPeriodInfo nextMediaPeriodInfo = this.queue.getNextMediaPeriodInfo(this.rendererPositionUs, this.playbackInfo);
            if (nextMediaPeriodInfo == null) {
                maybeThrowSourceInfoRefreshError();
                return;
            }
            this.queue.enqueueNextMediaPeriod(this.rendererCapabilities, this.trackSelector, this.loadControl.getAllocator(), this.mediaSource, nextMediaPeriodInfo).prepare(this, nextMediaPeriodInfo.startPositionUs);
            setIsLoading(true);
            handleLoadingMediaPeriodChanged(false);
        }
    }

    private void handlePeriodPrepared(MediaPeriod mediaPeriod) throws ExoPlaybackException {
        if (this.queue.isLoading(mediaPeriod)) {
            MediaPeriodHolder loadingPeriod = this.queue.getLoadingPeriod();
            loadingPeriod.handlePrepared(this.mediaClock.getPlaybackParameters().speed);
            updateLoadControlTrackSelection(loadingPeriod.trackGroups, loadingPeriod.trackSelectorResult);
            if (!this.queue.hasPlayingPeriod()) {
                resetRendererPosition(this.queue.advancePlayingPeriod().info.startPositionUs);
                updatePlayingPeriodRenderers(null);
            }
            maybeContinueLoading();
            this.playbackInfo = this.playbackInfo.copyWithIsPrepared(true);
        }
    }

    private void handleContinueLoadingRequested(MediaPeriod mediaPeriod) {
        if (this.queue.isLoading(mediaPeriod)) {
            this.queue.reevaluateBuffer(this.rendererPositionUs);
            maybeContinueLoading();
        }
    }

    private void handlePlaybackParameters(PlaybackParameters playbackParameters) throws ExoPlaybackException {
        this.eventHandler.obtainMessage(1, playbackParameters).sendToTarget();
        updateTrackSelectionPlaybackSpeed(playbackParameters.speed);
        for (Renderer renderer : this.renderers) {
            if (renderer != null) {
                renderer.setOperatingRate(playbackParameters.speed);
            }
        }
    }

    private void handleSeekCompleted(boolean z) {
        int curSeekId = this.seekParamsInternal.getCurSeekId();
        this.seekParamsInternal.finishSeek();
        this.eventHandler.obtainMessage(3, curSeekId, !z ? 1 : 0).sendToTarget();
    }

    private void maybeContinueLoading() {
        MediaPeriodHolder loadingPeriod = this.queue.getLoadingPeriod();
        long nextLoadPositionUs = loadingPeriod.getNextLoadPositionUs();
        if (nextLoadPositionUs == Long.MIN_VALUE) {
            setIsLoading(false);
            return;
        }
        boolean zShouldContinueLoading = this.loadControl.shouldContinueLoading(getTotalBufferedDurationUs(nextLoadPositionUs), this.mediaClock.getPlaybackParameters().speed);
        setIsLoading(zShouldContinueLoading);
        if (zShouldContinueLoading) {
            loadingPeriod.continueLoading(this.rendererPositionUs);
        }
    }

    private void updatePlayingPeriodRenderers(MediaPeriodHolder mediaPeriodHolder) throws ExoPlaybackException {
        MediaPeriodHolder playingPeriod = this.queue.getPlayingPeriod();
        if (playingPeriod == null || mediaPeriodHolder == playingPeriod) {
            return;
        }
        boolean[] zArr = new boolean[this.renderers.length];
        int OplusGLSurfaceView_13 = 0;
        int i2 = 0;
        while (true) {
            Renderer[] rendererArr = this.renderers;
            if (OplusGLSurfaceView_13 < rendererArr.length) {
                Renderer renderer = rendererArr[OplusGLSurfaceView_13];
                zArr[OplusGLSurfaceView_13] = renderer.getState() != 0;
                if (playingPeriod.trackSelectorResult.isRendererEnabled(OplusGLSurfaceView_13)) {
                    i2++;
                }
                if (zArr[OplusGLSurfaceView_13] && (!playingPeriod.trackSelectorResult.isRendererEnabled(OplusGLSurfaceView_13) || (renderer.isCurrentStreamFinal() && renderer.getStream() == mediaPeriodHolder.sampleStreams[OplusGLSurfaceView_13]))) {
                    disableRenderer(renderer);
                }
                OplusGLSurfaceView_13++;
            } else {
                this.playbackInfo = this.playbackInfo.copyWithTrackInfo(playingPeriod.trackGroups, playingPeriod.trackSelectorResult);
                enableRenderers(zArr, i2);
                return;
            }
        }
    }

    private void enableRenderers(boolean[] zArr, int OplusGLSurfaceView_13) throws ExoPlaybackException {
        this.enabledRenderers = new Renderer[OplusGLSurfaceView_13];
        MediaPeriodHolder playingPeriod = this.queue.getPlayingPeriod();
        int i2 = 0;
        for (int i3 = 0; i3 < this.renderers.length; i3++) {
            if (playingPeriod.trackSelectorResult.isRendererEnabled(i3)) {
                enableRenderer(i3, zArr[i3], i2);
                i2++;
            }
        }
    }

    private void enableRenderer(int OplusGLSurfaceView_13, boolean z, int i2) throws ExoPlaybackException {
        MediaPeriodHolder playingPeriod = this.queue.getPlayingPeriod();
        Renderer renderer = this.renderers[OplusGLSurfaceView_13];
        this.enabledRenderers[i2] = renderer;
        if (renderer.getState() == 0) {
            RendererConfiguration rendererConfiguration = playingPeriod.trackSelectorResult.rendererConfigurations[OplusGLSurfaceView_13];
            Format[] formats = getFormats(playingPeriod.trackSelectorResult.selections.get(OplusGLSurfaceView_13));
            boolean z2 = this.playWhenReady && this.playbackInfo.playbackState == 3;
            renderer.enable(rendererConfiguration, formats, playingPeriod.sampleStreams[OplusGLSurfaceView_13], this.rendererPositionUs, !z && z2, playingPeriod.getRendererOffset());
            this.mediaClock.onRendererEnabled(renderer);
            if (z2) {
                renderer.start();
            }
        }
    }

    private boolean rendererWaitingForNextStream(Renderer renderer) {
        MediaPeriodHolder readingPeriod = this.queue.getReadingPeriod();
        return readingPeriod.next != null && readingPeriod.next.prepared && renderer.hasReadStreamToEnd();
    }

    private void handleLoadingMediaPeriodChanged(boolean z) {
        MediaPeriodHolder loadingPeriod = this.queue.getLoadingPeriod();
        MediaSource.MediaPeriodId mediaPeriodId = loadingPeriod == null ? this.playbackInfo.periodId : loadingPeriod.info.f8980id;
        boolean z2 = !this.playbackInfo.loadingMediaPeriodId.equals(mediaPeriodId);
        if (z2) {
            this.playbackInfo = this.playbackInfo.copyWithLoadingMediaPeriodId(mediaPeriodId);
        }
        PlaybackInfo playbackInfo = this.playbackInfo;
        playbackInfo.bufferedPositionUs = loadingPeriod == null ? playbackInfo.positionUs : loadingPeriod.getBufferedPositionUs();
        this.playbackInfo.totalBufferedDurationUs = getTotalBufferedDurationUs();
        if ((z2 || z) && loadingPeriod != null && loadingPeriod.prepared) {
            updateLoadControlTrackSelection(loadingPeriod.trackGroups, loadingPeriod.trackSelectorResult);
        }
    }

    private long getTotalBufferedDurationUs() {
        return getTotalBufferedDurationUs(this.playbackInfo.bufferedPositionUs);
    }

    private long getTotalBufferedDurationUs(long OplusGLSurfaceView_15) {
        MediaPeriodHolder loadingPeriod = this.queue.getLoadingPeriod();
        if (loadingPeriod == null) {
            return 0L;
        }
        return OplusGLSurfaceView_15 - loadingPeriod.toPeriodTime(this.rendererPositionUs);
    }

    private void updateLoadControlTrackSelection(TrackGroupArray trackGroupArray, TrackSelectorResult trackSelectorResult) {
        this.loadControl.onTracksSelected(this.renderers, trackGroupArray, trackSelectorResult.selections);
    }

    private static Format[] getFormats(TrackSelection trackSelection) {
        int length = trackSelection != null ? trackSelection.length() : 0;
        Format[] formatArr = new Format[length];
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < length; OplusGLSurfaceView_13++) {
            formatArr[OplusGLSurfaceView_13] = trackSelection.getFormat(OplusGLSurfaceView_13);
        }
        return formatArr;
    }

    private static final class SeekPosition {
        public final Timeline timeline;
        public final int windowIndex;
        public final long windowPositionUs;

        public SeekPosition(Timeline timeline, int OplusGLSurfaceView_13, long OplusGLSurfaceView_15) {
            this.timeline = timeline;
            this.windowIndex = OplusGLSurfaceView_13;
            this.windowPositionUs = OplusGLSurfaceView_15;
        }
    }

    private static final class PendingMessageInfo implements Comparable<PendingMessageInfo> {
        public final PlayerMessage message;
        public int resolvedPeriodIndex;
        public long resolvedPeriodTimeUs;
        public Object resolvedPeriodUid;

        public PendingMessageInfo(PlayerMessage playerMessage) {
            this.message = playerMessage;
        }

        public void setResolvedPosition(int OplusGLSurfaceView_13, long OplusGLSurfaceView_15, Object obj) {
            this.resolvedPeriodIndex = OplusGLSurfaceView_13;
            this.resolvedPeriodTimeUs = OplusGLSurfaceView_15;
            this.resolvedPeriodUid = obj;
        }

        @Override // java.lang.Comparable
        public int compareTo(PendingMessageInfo pendingMessageInfo) {
            if ((this.resolvedPeriodUid == null) != (pendingMessageInfo.resolvedPeriodUid == null)) {
                return this.resolvedPeriodUid != null ? -1 : 1;
            }
            if (this.resolvedPeriodUid == null) {
                return 0;
            }
            int OplusGLSurfaceView_13 = this.resolvedPeriodIndex - pendingMessageInfo.resolvedPeriodIndex;
            return OplusGLSurfaceView_13 != 0 ? OplusGLSurfaceView_13 : Util.compareLong(this.resolvedPeriodTimeUs, pendingMessageInfo.resolvedPeriodTimeUs);
        }
    }

    private static final class MediaSourceRefreshInfo {
        public final Object manifest;
        public final MediaSource source;
        public final Timeline timeline;

        public MediaSourceRefreshInfo(MediaSource mediaSource, Timeline timeline, Object obj) {
            this.source = mediaSource;
            this.timeline = timeline;
            this.manifest = obj;
        }
    }

    private static final class PlaybackInfoUpdate {
        private int discontinuityReason;
        private PlaybackInfo lastPlaybackInfo;
        private int operationAcks;
        private boolean positionDiscontinuity;

        private PlaybackInfoUpdate() {
        }

        public boolean hasPendingUpdate(PlaybackInfo playbackInfo) {
            return playbackInfo != this.lastPlaybackInfo || this.operationAcks > 0 || this.positionDiscontinuity;
        }

        public void reset(PlaybackInfo playbackInfo) {
            this.lastPlaybackInfo = playbackInfo;
            this.operationAcks = 0;
            this.positionDiscontinuity = false;
        }

        public void incrementPendingOperationAcks(int OplusGLSurfaceView_13) {
            this.operationAcks += OplusGLSurfaceView_13;
        }

        public void setPositionDiscontinuity(int OplusGLSurfaceView_13) {
            if (this.positionDiscontinuity && this.discontinuityReason != 4) {
                Assertions.checkArgument(OplusGLSurfaceView_13 == 4);
            } else {
                this.positionDiscontinuity = true;
                this.discontinuityReason = OplusGLSurfaceView_13;
            }
        }
    }
}

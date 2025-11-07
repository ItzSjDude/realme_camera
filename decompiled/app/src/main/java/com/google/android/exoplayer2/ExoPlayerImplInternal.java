package com.google.android.exoplayer2;

/* loaded from: classes.dex */
final class ExoPlayerImplInternal implements android.os.Handler.Callback, com.google.android.exoplayer2.DefaultMediaClock.PlaybackParameterListener, com.google.android.exoplayer2.PlayerMessage.Sender, com.google.android.exoplayer2.source.MediaPeriod.Callback, com.google.android.exoplayer2.source.MediaSource.SourceInfoRefreshListener, com.google.android.exoplayer2.trackselection.TrackSelector.InvalidationListener {
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
    private static final java.lang.String TAG = "ExoPlayerImplInternal";
    private final long backBufferDurationUs;
    private final com.google.android.exoplayer2.upstream.BandwidthMeter bandwidthMeter;
    private final com.google.android.exoplayer2.util.Clock clock;
    private final com.google.android.exoplayer2.trackselection.TrackSelectorResult emptyTrackSelectorResult;
    private com.google.android.exoplayer2.Renderer[] enabledRenderers;
    private final android.os.Handler eventHandler;
    private final com.google.android.exoplayer2.util.HandlerWrapper handler;
    private final android.os.HandlerThread internalPlaybackThread;
    private final com.google.android.exoplayer2.LoadControl loadControl;
    private final com.google.android.exoplayer2.DefaultMediaClock mediaClock;
    private com.google.android.exoplayer2.source.MediaSource mediaSource;
    private int nextPendingMessageIndex;
    private com.google.android.exoplayer2.ExoPlayerImplInternal.SeekPosition pendingInitialSeekPosition;
    private final java.util.ArrayList<com.google.android.exoplayer2.ExoPlayerImplInternal.PendingMessageInfo> pendingMessages;
    private int pendingPrepareCount;
    private final com.google.android.exoplayer2.Timeline.Period period;
    private boolean playWhenReady;
    private com.google.android.exoplayer2.PlaybackInfo playbackInfo;
    private boolean rebuffering;
    private boolean released;
    private final com.google.android.exoplayer2.RendererCapabilities[] rendererCapabilities;
    private long rendererPositionUs;
    private final com.google.android.exoplayer2.Renderer[] renderers;
    private int repeatMode;
    private final boolean retainBackBufferFromKeyframe;
    private com.google.android.exoplayer2.ExoPlayerImplInternal.SeekParamsInternal seekParamsInternal;
    private boolean shuffleModeEnabled;
    private final com.google.android.exoplayer2.trackselection.TrackSelector trackSelector;
    private final com.google.android.exoplayer2.Timeline.Window window;
    private final com.google.android.exoplayer2.MediaPeriodQueue queue = new com.google.android.exoplayer2.MediaPeriodQueue();
    private com.google.android.exoplayer2.SeekParameters seekParameters = com.google.android.exoplayer2.SeekParameters.DEFAULT;
    private final com.google.android.exoplayer2.ExoPlayerImplInternal.PlaybackInfoUpdate playbackInfoUpdate = new com.google.android.exoplayer2.ExoPlayerImplInternal.PlaybackInfoUpdate();

    private enum SeekCase {
        SEEK_FORWARD_NOT_CACHED,
        SEEK_FORWARD_IN_GOP,
        SEEK_FORWARD_OUT_GOP,
        SEEK_BACKWARD
    }

    private static final class SeekParamsInternal {
        com.google.android.exoplayer2.ExoPlayerImplInternal.SeekParamsInternal.SeekParamsItem curSeekItem = new com.google.android.exoplayer2.ExoPlayerImplInternal.SeekParamsInternal.SeekParamsItem();
        com.google.android.exoplayer2.ExoPlayerImplInternal.SeekParamsInternal.SeekParamsItem pendingSeekItem = new com.google.android.exoplayer2.ExoPlayerImplInternal.SeekParamsInternal.SeekParamsItem();
        long lastVideoPresentTimeUs = -9223372036854775807L;
        long fastRendererTimeUs = -9223372036854775807L;

        public long getLastVideoPresentTimeUs() {
            return this.lastVideoPresentTimeUs;
        }

        public void setLastVideoPresentTimeUs(long j_renamed) {
            this.lastVideoPresentTimeUs = j_renamed;
        }

        public long getFastRendererTimeUs() {
            return this.fastRendererTimeUs;
        }

        public void setFastRendererTimeUs(long j_renamed) {
            this.fastRendererTimeUs = j_renamed;
        }

        public int getCurSeekId() {
            return this.curSeekItem.getSeekId();
        }

        public void setCurSeekId(int i_renamed) {
            this.curSeekItem.setSeekId(i_renamed);
        }

        public int getCurSeekType() {
            return this.curSeekItem.getSeekType();
        }

        public void setCurSeekType(int i_renamed) {
            this.curSeekItem.setSeekType(i_renamed);
        }

        public com.google.android.exoplayer2.ExoPlayerImplInternal.SeekPosition getCurSeekPosition() {
            return this.curSeekItem.getSeekPosition();
        }

        public void setCurSeekPosition(com.google.android.exoplayer2.ExoPlayerImplInternal.SeekPosition seekPosition) {
            this.curSeekItem.setSeekPosition(seekPosition);
        }

        public int getPendingSeekId() {
            return this.pendingSeekItem.getSeekId();
        }

        public void setPendingSeekId(int i_renamed) {
            this.pendingSeekItem.setSeekId(i_renamed);
        }

        public int getPendingSeekType() {
            return this.pendingSeekItem.getSeekType();
        }

        public void setPendingSeekType(int i_renamed) {
            this.pendingSeekItem.setSeekType(i_renamed);
        }

        public com.google.android.exoplayer2.ExoPlayerImplInternal.SeekPosition getPendingSeekPosition() {
            return this.pendingSeekItem.getSeekPosition();
        }

        public void setPendingSeekPosition(com.google.android.exoplayer2.ExoPlayerImplInternal.SeekPosition seekPosition) {
            this.pendingSeekItem.setSeekPosition(seekPosition);
        }

        public void startSeek() {
            if (this.curSeekItem.getSeekId() != -1) {
                com.google.android.exoplayer2.util.Log.d_renamed(com.google.android.exoplayer2.ExoPlayerImplInternal.TAG, "curSeekId is_renamed not completed, skip it");
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
            private com.google.android.exoplayer2.ExoPlayerImplInternal.SeekPosition seekPosition = null;

            SeekParamsItem() {
            }

            public int getSeekId() {
                return this.seekId;
            }

            public void setSeekId(int i_renamed) {
                this.seekId = i_renamed;
            }

            public int getSeekType() {
                return this.seekType;
            }

            public void setSeekType(int i_renamed) {
                this.seekType = i_renamed;
            }

            public com.google.android.exoplayer2.ExoPlayerImplInternal.SeekPosition getSeekPosition() {
                return this.seekPosition;
            }

            public void setSeekPosition(com.google.android.exoplayer2.ExoPlayerImplInternal.SeekPosition seekPosition) {
                this.seekPosition = seekPosition;
            }
        }
    }

    public ExoPlayerImplInternal(com.google.android.exoplayer2.Renderer[] rendererArr, com.google.android.exoplayer2.trackselection.TrackSelector trackSelector, com.google.android.exoplayer2.trackselection.TrackSelectorResult trackSelectorResult, com.google.android.exoplayer2.LoadControl loadControl, com.google.android.exoplayer2.upstream.BandwidthMeter bandwidthMeter, boolean z_renamed, int i_renamed, boolean z2, android.os.Handler handler, com.google.android.exoplayer2.util.Clock clock) {
        this.renderers = rendererArr;
        this.trackSelector = trackSelector;
        this.emptyTrackSelectorResult = trackSelectorResult;
        this.loadControl = loadControl;
        this.bandwidthMeter = bandwidthMeter;
        this.playWhenReady = z_renamed;
        this.repeatMode = i_renamed;
        this.shuffleModeEnabled = z2;
        this.eventHandler = handler;
        this.clock = clock;
        this.backBufferDurationUs = loadControl.getBackBufferDurationUs();
        this.retainBackBufferFromKeyframe = loadControl.retainBackBufferFromKeyframe();
        this.playbackInfo = com.google.android.exoplayer2.PlaybackInfo.createDummy(-9223372036854775807L, trackSelectorResult);
        this.rendererCapabilities = new com.google.android.exoplayer2.RendererCapabilities[rendererArr.length];
        for (int i2 = 0; i2 < rendererArr.length; i2++) {
            rendererArr[i2].setIndex(i2);
            this.rendererCapabilities[i2] = rendererArr[i2].getCapabilities();
        }
        this.mediaClock = new com.google.android.exoplayer2.DefaultMediaClock(this, clock);
        this.pendingMessages = new java.util.ArrayList<>();
        this.enabledRenderers = new com.google.android.exoplayer2.Renderer[0];
        this.window = new com.google.android.exoplayer2.Timeline.Window();
        this.period = new com.google.android.exoplayer2.Timeline.Period();
        trackSelector.init(this, bandwidthMeter);
        this.internalPlaybackThread = new android.os.HandlerThread("ExoPlayerImplInternal:Handler", -16);
        this.internalPlaybackThread.start();
        this.handler = clock.createHandler(this.internalPlaybackThread.getLooper(), this);
        this.seekParamsInternal = new com.google.android.exoplayer2.ExoPlayerImplInternal.SeekParamsInternal();
    }

    public void prepare(com.google.android.exoplayer2.source.MediaSource mediaSource, boolean z_renamed, boolean z2) {
        this.handler.obtainMessage(0, z_renamed ? 1 : 0, z2 ? 1 : 0, mediaSource).sendToTarget();
    }

    public void setPlayWhenReady(boolean z_renamed) {
        this.handler.obtainMessage(1, z_renamed ? 1 : 0, 0).sendToTarget();
    }

    public void setRepeatMode(int i_renamed) {
        this.handler.obtainMessage(12, i_renamed, 0).sendToTarget();
    }

    public void setShuffleModeEnabled(boolean z_renamed) {
        this.handler.obtainMessage(13, z_renamed ? 1 : 0, 0).sendToTarget();
    }

    public void seekTo(com.google.android.exoplayer2.Timeline timeline, int i_renamed, long j_renamed, int i2, int i3) {
        this.handler.obtainMessage(3, i2, i3, new com.google.android.exoplayer2.ExoPlayerImplInternal.SeekPosition(timeline, i_renamed, j_renamed)).sendToTarget();
    }

    public void setPlaybackParameters(com.google.android.exoplayer2.PlaybackParameters playbackParameters) {
        this.handler.obtainMessage(4, playbackParameters).sendToTarget();
    }

    public void setSeekParameters(com.google.android.exoplayer2.SeekParameters seekParameters) {
        this.handler.obtainMessage(5, seekParameters).sendToTarget();
    }

    public void stop(boolean z_renamed) {
        this.handler.obtainMessage(6, z_renamed ? 1 : 0, 0).sendToTarget();
    }

    @Override // com.google.android.exoplayer2.PlayerMessage.Sender
    public synchronized void sendMessage(com.google.android.exoplayer2.PlayerMessage playerMessage) {
        if (this.released) {
            com.google.android.exoplayer2.util.Log.w_renamed(TAG, "Ignoring messages sent after release.");
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
        boolean z_renamed = false;
        while (!this.released) {
            try {
                wait();
            } catch (java.lang.InterruptedException unused) {
                z_renamed = true;
            }
        }
        if (z_renamed) {
            java.lang.Thread.currentThread().interrupt();
        }
    }

    public android.os.Looper getPlaybackLooper() {
        return this.internalPlaybackThread.getLooper();
    }

    @Override // com.google.android.exoplayer2.source.MediaSource.SourceInfoRefreshListener
    public void onSourceInfoRefreshed(com.google.android.exoplayer2.source.MediaSource mediaSource, com.google.android.exoplayer2.Timeline timeline, java.lang.Object obj) {
        this.handler.obtainMessage(8, new com.google.android.exoplayer2.ExoPlayerImplInternal.MediaSourceRefreshInfo(mediaSource, timeline, obj)).sendToTarget();
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod.Callback
    public void onPrepared(com.google.android.exoplayer2.source.MediaPeriod mediaPeriod) {
        this.handler.obtainMessage(9, mediaPeriod).sendToTarget();
    }

    @Override // com.google.android.exoplayer2.source.SequenceableLoader.Callback
    public void onContinueLoadingRequested(com.google.android.exoplayer2.source.MediaPeriod mediaPeriod) {
        this.handler.obtainMessage(10, mediaPeriod).sendToTarget();
    }

    @Override // com.google.android.exoplayer2.trackselection.TrackSelector.InvalidationListener
    public void onTrackSelectionsInvalidated() {
        this.handler.sendEmptyMessage(11);
    }

    @Override // com.google.android.exoplayer2.DefaultMediaClock.PlaybackParameterListener
    public void onPlaybackParametersChanged(com.google.android.exoplayer2.PlaybackParameters playbackParameters) {
        this.handler.obtainMessage(16, playbackParameters).sendToTarget();
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(android.os.Message message) throws java.lang.Throwable {
        try {
            switch (message.what) {
                case 0:
                    prepareInternal((com.google.android.exoplayer2.source.MediaSource) message.obj, message.arg1 != 0, message.arg2 != 0);
                    break;
                case 1:
                    setPlayWhenReadyInternal(message.arg1 != 0);
                    break;
                case 2:
                    doSomeWork();
                    break;
                case 3:
                    seekToInternal((com.google.android.exoplayer2.ExoPlayerImplInternal.SeekPosition) message.obj, message.arg1, message.arg2, false);
                    break;
                case 4:
                    setPlaybackParametersInternal((com.google.android.exoplayer2.PlaybackParameters) message.obj);
                    break;
                case 5:
                    setSeekParametersInternal((com.google.android.exoplayer2.SeekParameters) message.obj);
                    break;
                case 6:
                    stopInternal(message.arg1 != 0, true);
                    break;
                case 7:
                    releaseInternal();
                    return true;
                case 8:
                    handleSourceInfoRefreshed((com.google.android.exoplayer2.ExoPlayerImplInternal.MediaSourceRefreshInfo) message.obj);
                    break;
                case 9:
                    handlePeriodPrepared((com.google.android.exoplayer2.source.MediaPeriod) message.obj);
                    break;
                case 10:
                    handleContinueLoadingRequested((com.google.android.exoplayer2.source.MediaPeriod) message.obj);
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
                    sendMessageInternal((com.google.android.exoplayer2.PlayerMessage) message.obj);
                    break;
                case 15:
                    sendMessageToTargetThread((com.google.android.exoplayer2.PlayerMessage) message.obj);
                    break;
                case 16:
                    handlePlaybackParameters((com.google.android.exoplayer2.PlaybackParameters) message.obj);
                    break;
                case 17:
                    seekToInternal((com.google.android.exoplayer2.ExoPlayerImplInternal.SeekPosition) message.obj, message.arg1, message.arg2, true);
                    break;
                default:
                    return false;
            }
            maybeNotifyPlaybackInfoChanged();
        } catch (com.google.android.exoplayer2.ExoPlaybackException e_renamed) {
            com.google.android.exoplayer2.util.Log.e_renamed(TAG, "Playback error.", e_renamed);
            stopInternal(false, false);
            handleSeekCompleted(false);
            this.eventHandler.obtainMessage(2, e_renamed).sendToTarget();
            maybeNotifyPlaybackInfoChanged();
        } catch (java.io.IOException e2) {
            com.google.android.exoplayer2.util.Log.e_renamed(TAG, "Source error.", e2);
            stopInternal(false, false);
            handleSeekCompleted(false);
            this.eventHandler.obtainMessage(2, com.google.android.exoplayer2.ExoPlaybackException.createForSource(e2)).sendToTarget();
            maybeNotifyPlaybackInfoChanged();
        } catch (java.lang.RuntimeException e3) {
            com.google.android.exoplayer2.util.Log.e_renamed(TAG, "Internal runtime error.", e3);
            stopInternal(false, false);
            handleSeekCompleted(false);
            this.eventHandler.obtainMessage(2, com.google.android.exoplayer2.ExoPlaybackException.createForUnexpected(e3)).sendToTarget();
            maybeNotifyPlaybackInfoChanged();
        }
        return true;
    }

    private void setState(int i_renamed) {
        if (this.playbackInfo.playbackState != i_renamed) {
            this.playbackInfo = this.playbackInfo.copyWithPlaybackState(i_renamed);
        }
    }

    private void setIsLoading(boolean z_renamed) {
        if (this.playbackInfo.isLoading != z_renamed) {
            this.playbackInfo = this.playbackInfo.copyWithIsLoading(z_renamed);
        }
    }

    private void maybeNotifyPlaybackInfoChanged() {
        if (this.playbackInfoUpdate.hasPendingUpdate(this.playbackInfo)) {
            this.eventHandler.obtainMessage(0, this.playbackInfoUpdate.operationAcks, this.playbackInfoUpdate.positionDiscontinuity ? this.playbackInfoUpdate.discontinuityReason : -1, this.playbackInfo).sendToTarget();
            this.playbackInfoUpdate.reset(this.playbackInfo);
        }
    }

    private void prepareInternal(com.google.android.exoplayer2.source.MediaSource mediaSource, boolean z_renamed, boolean z2) {
        this.pendingPrepareCount++;
        resetInternal(true, z_renamed, z2);
        this.loadControl.onPrepared();
        this.mediaSource = mediaSource;
        setState(2);
        mediaSource.prepareSource(this, this.bandwidthMeter.getTransferListener());
        this.handler.sendEmptyMessage(2);
    }

    private void setPlayWhenReadyInternal(boolean z_renamed) throws com.google.android.exoplayer2.ExoPlaybackException {
        this.rebuffering = false;
        this.playWhenReady = z_renamed;
        if (!z_renamed) {
            stopRenderers();
            updatePlaybackPositions();
        } else if (this.playbackInfo.playbackState == 3) {
            startRenderers();
            this.handler.sendEmptyMessage(2);
        } else if (this.playbackInfo.playbackState == 2) {
            this.handler.sendEmptyMessage(2);
        }
    }

    private void setRepeatModeInternal(int i_renamed) throws com.google.android.exoplayer2.ExoPlaybackException {
        this.repeatMode = i_renamed;
        if (!this.queue.updateRepeatMode(i_renamed)) {
            seekToCurrentPosition(true);
        }
        handleLoadingMediaPeriodChanged(false);
    }

    private void setShuffleModeEnabledInternal(boolean z_renamed) throws com.google.android.exoplayer2.ExoPlaybackException {
        this.shuffleModeEnabled = z_renamed;
        if (!this.queue.updateShuffleModeEnabled(z_renamed)) {
            seekToCurrentPosition(true);
        }
        handleLoadingMediaPeriodChanged(false);
    }

    private void seekToCurrentPosition(boolean z_renamed) throws com.google.android.exoplayer2.ExoPlaybackException {
        com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId = this.queue.getPlayingPeriod().info.id_renamed;
        long jSeekToPeriodPosition = seekToPeriodPosition(mediaPeriodId, this.playbackInfo.positionUs, true);
        if (jSeekToPeriodPosition != this.playbackInfo.positionUs) {
            com.google.android.exoplayer2.PlaybackInfo playbackInfo = this.playbackInfo;
            this.playbackInfo = playbackInfo.copyWithNewPosition(mediaPeriodId, jSeekToPeriodPosition, playbackInfo.contentPositionUs, getTotalBufferedDurationUs());
            if (z_renamed) {
                this.playbackInfoUpdate.setPositionDiscontinuity(4);
            }
        }
    }

    private void startRenderers() throws com.google.android.exoplayer2.ExoPlaybackException {
        this.rebuffering = false;
        this.mediaClock.start();
        for (com.google.android.exoplayer2.Renderer renderer : this.enabledRenderers) {
            renderer.start();
        }
    }

    private void stopRenderers() throws com.google.android.exoplayer2.ExoPlaybackException {
        this.mediaClock.stop();
        for (com.google.android.exoplayer2.Renderer renderer : this.enabledRenderers) {
            ensureStopped(renderer);
        }
    }

    private void updatePlaybackPositions() throws com.google.android.exoplayer2.ExoPlaybackException {
        if (this.queue.hasPlayingPeriod()) {
            com.google.android.exoplayer2.MediaPeriodHolder playingPeriod = this.queue.getPlayingPeriod();
            long discontinuity = playingPeriod.mediaPeriod.readDiscontinuity();
            if (discontinuity != -9223372036854775807L) {
                resetRendererPosition(discontinuity);
                if (discontinuity != this.playbackInfo.positionUs) {
                    com.google.android.exoplayer2.PlaybackInfo playbackInfo = this.playbackInfo;
                    this.playbackInfo = playbackInfo.copyWithNewPosition(playbackInfo.periodId, discontinuity, this.playbackInfo.contentPositionUs, getTotalBufferedDurationUs());
                    this.playbackInfoUpdate.setPositionDiscontinuity(4);
                }
            } else {
                this.rendererPositionUs = this.mediaClock.syncAndGetPositionUs();
                long periodTime = playingPeriod.toPeriodTime(this.rendererPositionUs);
                maybeTriggerPendingMessages(this.playbackInfo.positionUs, periodTime);
                this.playbackInfo.positionUs = periodTime;
            }
            com.google.android.exoplayer2.MediaPeriodHolder loadingPeriod = this.queue.getLoadingPeriod();
            this.playbackInfo.bufferedPositionUs = loadingPeriod.getBufferedPositionUs();
            this.playbackInfo.totalBufferedDurationUs = getTotalBufferedDurationUs();
        }
    }

    private void doSomeWork() throws com.google.android.exoplayer2.ExoPlaybackException, java.io.IOException {
        int i_renamed;
        com.google.android.exoplayer2.Renderer[] rendererArr;
        long jUptimeMillis = this.clock.uptimeMillis();
        updatePeriods();
        if (!this.queue.hasPlayingPeriod()) {
            maybeThrowPeriodPrepareError();
            scheduleNextWork(jUptimeMillis, 10L);
            return;
        }
        com.google.android.exoplayer2.MediaPeriodHolder playingPeriod = this.queue.getPlayingPeriod();
        com.google.android.exoplayer2.util.TraceUtil.beginSection("doSomeWork");
        updatePlaybackPositions();
        long jElapsedRealtime = android.os.SystemClock.elapsedRealtime() * 1000;
        playingPeriod.mediaPeriod.discardBuffer(this.playbackInfo.positionUs - this.backBufferDurationUs, this.retainBackBufferFromKeyframe);
        com.google.android.exoplayer2.Renderer[] rendererArr2 = this.enabledRenderers;
        int length = rendererArr2.length;
        int i2 = 1;
        boolean z_renamed = true;
        boolean z2 = true;
        int i3 = 0;
        boolean z3 = false;
        while (i3 < length) {
            com.google.android.exoplayer2.Renderer renderer = rendererArr2[i3];
            if (this.seekParamsInternal.getCurSeekType() == i2 && renderer.getTrackType() == i2) {
                i_renamed = i3;
            } else {
                i_renamed = i3;
                renderer.render(this.rendererPositionUs, jElapsedRealtime);
            }
            z2 = z2 && renderer.isEnded();
            boolean z4 = renderer.isReady() || renderer.isEnded() || rendererWaitingForNextStream(renderer);
            if (!z4) {
                renderer.maybeThrowStreamError();
            }
            z_renamed = z_renamed && z4;
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
            i3 = i_renamed + 1;
        }
        if (!z_renamed) {
            maybeThrowPeriodPrepareError();
        }
        long j_renamed = playingPeriod.info.durationUs;
        if (z2 && ((j_renamed == -9223372036854775807L || j_renamed <= this.playbackInfo.positionUs) && playingPeriod.info.isFinal)) {
            setState(4);
            stopRenderers();
        } else if (this.playbackInfo.playbackState == 2 && shouldTransitionToReadyState(z_renamed)) {
            setState(3);
            if (this.playWhenReady) {
                startRenderers();
            }
        } else if (this.playbackInfo.playbackState == 3 && (this.enabledRenderers.length != 0 ? !z_renamed : !isTimelineReady())) {
            this.rebuffering = this.playWhenReady;
            setState(2);
            stopRenderers();
        }
        if (this.playbackInfo.playbackState == 2) {
            for (com.google.android.exoplayer2.Renderer renderer2 : this.enabledRenderers) {
                renderer2.maybeThrowStreamError();
            }
        }
        if (this.seekParamsInternal.isSeeking() && z3) {
            com.google.android.exoplayer2.util.Log.d_renamed(TAG, "current seek complete");
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
        com.google.android.exoplayer2.util.TraceUtil.endSection();
    }

    private void scheduleNextWork(long j_renamed, long j2) {
        this.handler.removeMessages(2);
        this.handler.sendEmptyMessageAtTime(2, j_renamed + j2);
    }

    /* JADX WARN: Removed duplicated region for block: B_renamed:55:0x0109  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:67:? A_renamed[RETURN, SYNTHETIC] */
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

    private long seekToPeriodPosition(com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId, long j_renamed) throws com.google.android.exoplayer2.ExoPlaybackException {
        return seekToPeriodPosition(mediaPeriodId, j_renamed, this.queue.getPlayingPeriod() != this.queue.getReadingPeriod());
    }

    private long seekToPeriodPosition(com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId, long j_renamed, boolean z_renamed) throws com.google.android.exoplayer2.ExoPlaybackException {
        stopRenderers();
        this.rebuffering = false;
        setState(2);
        com.google.android.exoplayer2.MediaPeriodHolder playingPeriod = this.queue.getPlayingPeriod();
        com.google.android.exoplayer2.MediaPeriodHolder mediaPeriodHolderAdvancePlayingPeriod = playingPeriod;
        while (true) {
            if (mediaPeriodHolderAdvancePlayingPeriod == null) {
                break;
            }
            if (mediaPeriodId.equals(mediaPeriodHolderAdvancePlayingPeriod.info.id_renamed) && mediaPeriodHolderAdvancePlayingPeriod.prepared) {
                this.queue.removeAfter(mediaPeriodHolderAdvancePlayingPeriod);
                break;
            }
            mediaPeriodHolderAdvancePlayingPeriod = this.queue.advancePlayingPeriod();
        }
        if (playingPeriod != mediaPeriodHolderAdvancePlayingPeriod || z_renamed) {
            for (com.google.android.exoplayer2.Renderer renderer : this.enabledRenderers) {
                disableRenderer(renderer);
            }
            this.enabledRenderers = new com.google.android.exoplayer2.Renderer[0];
            playingPeriod = null;
        }
        if (mediaPeriodHolderAdvancePlayingPeriod != null) {
            updatePlayingPeriodRenderers(playingPeriod);
            com.google.android.exoplayer2.ExoPlayerImplInternal.SeekCase seekCase = com.google.android.exoplayer2.ExoPlayerImplInternal.SeekCase.SEEK_FORWARD_NOT_CACHED;
            if (this.seekParamsInternal.getPendingSeekType() != 0) {
                if (j_renamed < this.rendererPositionUs) {
                    seekCase = com.google.android.exoplayer2.ExoPlayerImplInternal.SeekCase.SEEK_BACKWARD;
                } else {
                    long nextKeyFramePositionUs = mediaPeriodHolderAdvancePlayingPeriod.mediaPeriod.getNextKeyFramePositionUs(this.rendererPositionUs);
                    com.google.android.exoplayer2.util.Log.d_renamed(TAG, "nextKeyFramePositionUs:" + nextKeyFramePositionUs);
                    if (nextKeyFramePositionUs == -1) {
                        if (mediaPeriodHolderAdvancePlayingPeriod.mediaPeriod.getLargestQueuedTimeUsByType(2) >= j_renamed) {
                            seekCase = com.google.android.exoplayer2.ExoPlayerImplInternal.SeekCase.SEEK_FORWARD_IN_GOP;
                        } else {
                            seekCase = com.google.android.exoplayer2.ExoPlayerImplInternal.SeekCase.SEEK_FORWARD_NOT_CACHED;
                        }
                    } else if (this.rendererPositionUs <= j_renamed && j_renamed < nextKeyFramePositionUs) {
                        seekCase = com.google.android.exoplayer2.ExoPlayerImplInternal.SeekCase.SEEK_FORWARD_IN_GOP;
                    } else {
                        seekCase = com.google.android.exoplayer2.ExoPlayerImplInternal.SeekCase.SEEK_FORWARD_OUT_GOP;
                    }
                }
                boolean zIsSeeking = this.seekParamsInternal.isSeeking();
                com.google.android.exoplayer2.util.Log.d_renamed(TAG, "seekCase:" + seekCase + ", isSeeking:" + zIsSeeking + ",periodPositionUs:" + j_renamed + ", rendererPositionUs:" + this.rendererPositionUs);
                if (zIsSeeking && this.seekParamsInternal.getPendingSeekType() == 1) {
                    long lastVideoPresentTimeUs = this.seekParamsInternal.getLastVideoPresentTimeUs();
                    com.google.android.exoplayer2.util.Log.d_renamed(TAG, "lastVideoPresentTimeUs:" + lastVideoPresentTimeUs);
                    if (lastVideoPresentTimeUs == -9223372036854775807L) {
                        com.google.android.exoplayer2.util.Log.d_renamed(TAG, "not received any data, just waiting");
                        return j_renamed;
                    }
                    if (seekCase == com.google.android.exoplayer2.ExoPlayerImplInternal.SeekCase.SEEK_FORWARD_NOT_CACHED) {
                        com.google.android.exoplayer2.util.Log.d_renamed(TAG, "not cached enough data");
                        setFastRendererPosition(-9223372036854775807L);
                        return j_renamed;
                    }
                    if (seekCase == com.google.android.exoplayer2.ExoPlayerImplInternal.SeekCase.SEEK_FORWARD_IN_GOP) {
                        com.google.android.exoplayer2.util.Log.d_renamed(TAG, "need pending the forward seek in_renamed same GOP");
                        setFastRendererPosition(-9223372036854775807L);
                        return j_renamed;
                    }
                    if (seekCase != com.google.android.exoplayer2.ExoPlayerImplInternal.SeekCase.SEEK_FORWARD_OUT_GOP) {
                        if (lastVideoPresentTimeUs <= j_renamed) {
                            setFastRendererPosition(j_renamed);
                            com.google.android.exoplayer2.util.Log.d_renamed(TAG, "need pending the backward seek if not decoded enough data");
                        } else {
                            setFastRendererPosition(j_renamed);
                        }
                        return j_renamed;
                    }
                    if (this.seekParamsInternal.getFastRendererTimeUs() == -9223372036854775807L) {
                        if (lastVideoPresentTimeUs < this.rendererPositionUs) {
                            setFastRendererPosition(lastVideoPresentTimeUs);
                        }
                    } else if (this.seekParamsInternal.getFastRendererTimeUs() > lastVideoPresentTimeUs) {
                        setFastRendererPosition(lastVideoPresentTimeUs);
                    }
                    return j_renamed;
                }
            }
            this.seekParamsInternal.startSeek();
            if (mediaPeriodHolderAdvancePlayingPeriod.hasEnabledTracks) {
                if (seekCase != com.google.android.exoplayer2.ExoPlayerImplInternal.SeekCase.SEEK_FORWARD_IN_GOP) {
                    j_renamed = mediaPeriodHolderAdvancePlayingPeriod.mediaPeriod.seekToUs(j_renamed);
                } else if (!mediaPeriodHolderAdvancePlayingPeriod.mediaPeriod.seekToUsInGop(j_renamed, this.seekParamsInternal.getCurSeekType() == 2)) {
                    com.google.android.exoplayer2.util.Log.d_renamed(TAG, "seekToUsInGop failed, fallback to SeekToUs");
                    com.google.android.exoplayer2.ExoPlayerImplInternal.SeekCase seekCase2 = com.google.android.exoplayer2.ExoPlayerImplInternal.SeekCase.SEEK_FORWARD_OUT_GOP;
                    j_renamed = mediaPeriodHolderAdvancePlayingPeriod.mediaPeriod.seekToUs(j_renamed);
                    seekCase = seekCase2;
                }
                mediaPeriodHolderAdvancePlayingPeriod.mediaPeriod.discardBuffer(j_renamed - this.backBufferDurationUs, this.retainBackBufferFromKeyframe);
            }
            if (seekCase != com.google.android.exoplayer2.ExoPlayerImplInternal.SeekCase.SEEK_FORWARD_IN_GOP) {
                resetRendererPosition(j_renamed);
            } else {
                resetRendererPositionInGop(j_renamed);
            }
            maybeContinueLoading();
        } else {
            this.queue.clear(true);
            this.playbackInfo = this.playbackInfo.copyWithTrackInfo(com.google.android.exoplayer2.source.TrackGroupArray.EMPTY, this.emptyTrackSelectorResult);
            resetRendererPosition(j_renamed);
        }
        handleLoadingMediaPeriodChanged(false);
        this.handler.sendEmptyMessage(2);
        return j_renamed;
    }

    private void resetRendererPosition(long j_renamed) throws com.google.android.exoplayer2.ExoPlaybackException {
        if (this.queue.hasPlayingPeriod()) {
            j_renamed = this.queue.getPlayingPeriod().toRendererTime(j_renamed);
        }
        this.rendererPositionUs = j_renamed;
        this.mediaClock.resetPosition(this.rendererPositionUs);
        for (com.google.android.exoplayer2.Renderer renderer : this.enabledRenderers) {
            renderer.resetPosition(this.rendererPositionUs);
        }
    }

    private void resetRendererPositionInGop(long j_renamed) throws com.google.android.exoplayer2.ExoPlaybackException {
        if (this.queue.hasPlayingPeriod()) {
            j_renamed = this.queue.getPlayingPeriod().toRendererTime(j_renamed);
        }
        this.rendererPositionUs = j_renamed;
        this.mediaClock.resetPosition(this.rendererPositionUs);
        for (com.google.android.exoplayer2.Renderer renderer : this.enabledRenderers) {
            renderer.resetPositionInGop(this.rendererPositionUs);
        }
    }

    private void setFastRendererPosition(long j_renamed) throws com.google.android.exoplayer2.ExoPlaybackException {
        if (this.queue.hasPlayingPeriod()) {
            j_renamed = this.queue.getPlayingPeriod().toRendererTime(j_renamed);
        }
        com.google.android.exoplayer2.util.Log.d_renamed(TAG, "set fastRenderTime from:" + this.seekParamsInternal.getFastRendererTimeUs() + ",to:" + j_renamed);
        this.seekParamsInternal.setFastRendererTimeUs(j_renamed);
        for (com.google.android.exoplayer2.Renderer renderer : this.enabledRenderers) {
            renderer.setFastRendererPosition(j_renamed);
        }
    }

    private void setPlaybackParametersInternal(com.google.android.exoplayer2.PlaybackParameters playbackParameters) {
        this.mediaClock.setPlaybackParameters(playbackParameters);
    }

    private void setSeekParametersInternal(com.google.android.exoplayer2.SeekParameters seekParameters) {
        this.seekParameters = seekParameters;
    }

    private void stopInternal(boolean z_renamed, boolean z2) {
        resetInternal(true, z_renamed, z_renamed);
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

    private void resetInternal(boolean z_renamed, boolean z2, boolean z3) {
        com.google.android.exoplayer2.source.MediaSource mediaSource;
        this.handler.removeMessages(2);
        this.rebuffering = false;
        this.mediaClock.stop();
        this.rendererPositionUs = 0L;
        for (com.google.android.exoplayer2.Renderer renderer : this.enabledRenderers) {
            try {
                disableRenderer(renderer);
            } catch (com.google.android.exoplayer2.ExoPlaybackException | java.lang.RuntimeException e_renamed) {
                com.google.android.exoplayer2.util.Log.e_renamed(TAG, "Stop failed.", e_renamed);
            }
        }
        this.enabledRenderers = new com.google.android.exoplayer2.Renderer[0];
        this.queue.clear(!z2);
        setIsLoading(false);
        if (z2) {
            this.pendingInitialSeekPosition = null;
        }
        if (z3) {
            this.queue.setTimeline(com.google.android.exoplayer2.Timeline.EMPTY);
            java.util.Iterator<com.google.android.exoplayer2.ExoPlayerImplInternal.PendingMessageInfo> it = this.pendingMessages.iterator();
            while (it.hasNext()) {
                it.next().message.markAsProcessed(false);
            }
            this.pendingMessages.clear();
            this.nextPendingMessageIndex = 0;
        }
        com.google.android.exoplayer2.source.MediaSource.MediaPeriodId dummyFirstMediaPeriodId = z2 ? this.playbackInfo.getDummyFirstMediaPeriodId(this.shuffleModeEnabled, this.window) : this.playbackInfo.periodId;
        long j_renamed = z2 ? -9223372036854775807L : this.playbackInfo.positionUs;
        this.playbackInfo = new com.google.android.exoplayer2.PlaybackInfo(z3 ? com.google.android.exoplayer2.Timeline.EMPTY : this.playbackInfo.timeline, z3 ? null : this.playbackInfo.manifest, dummyFirstMediaPeriodId, j_renamed, z2 ? -9223372036854775807L : this.playbackInfo.contentPositionUs, this.playbackInfo.playbackState, false, z3 ? com.google.android.exoplayer2.source.TrackGroupArray.EMPTY : this.playbackInfo.trackGroups, z3 ? this.emptyTrackSelectorResult : this.playbackInfo.trackSelectorResult, dummyFirstMediaPeriodId, j_renamed, 0L, j_renamed, false);
        if (!z_renamed || (mediaSource = this.mediaSource) == null) {
            return;
        }
        mediaSource.releaseSource(this);
        this.mediaSource = null;
    }

    private void sendMessageInternal(com.google.android.exoplayer2.PlayerMessage playerMessage) throws com.google.android.exoplayer2.ExoPlaybackException {
        if (playerMessage.getPositionMs() == -9223372036854775807L) {
            sendMessageToTarget(playerMessage);
            return;
        }
        if (this.mediaSource == null || this.pendingPrepareCount > 0) {
            this.pendingMessages.add(new com.google.android.exoplayer2.ExoPlayerImplInternal.PendingMessageInfo(playerMessage));
            return;
        }
        com.google.android.exoplayer2.ExoPlayerImplInternal.PendingMessageInfo pendingMessageInfo = new com.google.android.exoplayer2.ExoPlayerImplInternal.PendingMessageInfo(playerMessage);
        if (resolvePendingMessagePosition(pendingMessageInfo)) {
            this.pendingMessages.add(pendingMessageInfo);
            java.util.Collections.sort(this.pendingMessages);
        } else {
            playerMessage.markAsProcessed(false);
        }
    }

    private void sendMessageToTarget(com.google.android.exoplayer2.PlayerMessage playerMessage) throws com.google.android.exoplayer2.ExoPlaybackException {
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

    private void sendMessageToTargetThread(final com.google.android.exoplayer2.PlayerMessage playerMessage) {
        playerMessage.getHandler().post(new java.lang.Runnable() { // from class: com.google.android.exoplayer2.-$$Lambda$ExoPlayerImplInternal$XwFxncwlyfAWA4k618O8BNtCsr0
            @Override // java.lang.Runnable
            public final void run() {
                this.f_renamed$0.lambda$sendMessageToTargetThread$0$ExoPlayerImplInternal(playerMessage);
            }
        });
    }

    public /* synthetic */ void lambda$sendMessageToTargetThread$0$ExoPlayerImplInternal(com.google.android.exoplayer2.PlayerMessage playerMessage) {
        try {
            deliverMessage(playerMessage);
        } catch (com.google.android.exoplayer2.ExoPlaybackException e_renamed) {
            com.google.android.exoplayer2.util.Log.e_renamed(TAG, "Unexpected error delivering message on_renamed external thread.", e_renamed);
            throw new java.lang.RuntimeException(e_renamed);
        }
    }

    private void deliverMessage(com.google.android.exoplayer2.PlayerMessage playerMessage) throws com.google.android.exoplayer2.ExoPlaybackException {
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
        java.util.Collections.sort(this.pendingMessages);
    }

    private boolean resolvePendingMessagePosition(com.google.android.exoplayer2.ExoPlayerImplInternal.PendingMessageInfo pendingMessageInfo) {
        if (pendingMessageInfo.resolvedPeriodUid == null) {
            android.util.Pair<java.lang.Object, java.lang.Long> pairResolveSeekPosition = resolveSeekPosition(new com.google.android.exoplayer2.ExoPlayerImplInternal.SeekPosition(pendingMessageInfo.message.getTimeline(), pendingMessageInfo.message.getWindowIndex(), com.google.android.exoplayer2.C_renamed.msToUs(pendingMessageInfo.message.getPositionMs())), false);
            if (pairResolveSeekPosition == null) {
                return false;
            }
            pendingMessageInfo.setResolvedPosition(this.playbackInfo.timeline.getIndexOfPeriod(pairResolveSeekPosition.first), ((java.lang.Long) pairResolveSeekPosition.second).longValue(), pairResolveSeekPosition.first);
            return true;
        }
        int indexOfPeriod = this.playbackInfo.timeline.getIndexOfPeriod(pendingMessageInfo.resolvedPeriodUid);
        if (indexOfPeriod == -1) {
            return false;
        }
        pendingMessageInfo.resolvedPeriodIndex = indexOfPeriod;
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B_renamed:61:0x003e, code lost:
    
        r1 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B_renamed:62:0x0079, code lost:
    
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

    private void ensureStopped(com.google.android.exoplayer2.Renderer renderer) throws com.google.android.exoplayer2.ExoPlaybackException {
        if (renderer.getState() == 2) {
            renderer.stop();
        }
    }

    private void disableRenderer(com.google.android.exoplayer2.Renderer renderer) throws com.google.android.exoplayer2.ExoPlaybackException {
        this.mediaClock.onRendererDisabled(renderer);
        ensureStopped(renderer);
        renderer.disable();
    }

    private void reselectTracksInternal() throws com.google.android.exoplayer2.ExoPlaybackException {
        if (this.queue.hasPlayingPeriod()) {
            float f_renamed = this.mediaClock.getPlaybackParameters().speed;
            com.google.android.exoplayer2.MediaPeriodHolder readingPeriod = this.queue.getReadingPeriod();
            boolean z_renamed = true;
            for (com.google.android.exoplayer2.MediaPeriodHolder playingPeriod = this.queue.getPlayingPeriod(); playingPeriod != null && playingPeriod.prepared; playingPeriod = playingPeriod.next) {
                if (!playingPeriod.selectTracks(f_renamed)) {
                    if (playingPeriod == readingPeriod) {
                        z_renamed = false;
                    }
                } else {
                    if (z_renamed) {
                        com.google.android.exoplayer2.MediaPeriodHolder playingPeriod2 = this.queue.getPlayingPeriod();
                        boolean zRemoveAfter = this.queue.removeAfter(playingPeriod2);
                        boolean[] zArr = new boolean[this.renderers.length];
                        long jApplyTrackSelection = playingPeriod2.applyTrackSelection(this.playbackInfo.positionUs, zRemoveAfter, zArr);
                        if (this.playbackInfo.playbackState != 4 && jApplyTrackSelection != this.playbackInfo.positionUs) {
                            com.google.android.exoplayer2.PlaybackInfo playbackInfo = this.playbackInfo;
                            this.playbackInfo = playbackInfo.copyWithNewPosition(playbackInfo.periodId, jApplyTrackSelection, this.playbackInfo.contentPositionUs, getTotalBufferedDurationUs());
                            this.playbackInfoUpdate.setPositionDiscontinuity(4);
                            resetRendererPosition(jApplyTrackSelection);
                        }
                        boolean[] zArr2 = new boolean[this.renderers.length];
                        int i_renamed = 0;
                        int i2 = 0;
                        while (true) {
                            com.google.android.exoplayer2.Renderer[] rendererArr = this.renderers;
                            if (i_renamed >= rendererArr.length) {
                                break;
                            }
                            com.google.android.exoplayer2.Renderer renderer = rendererArr[i_renamed];
                            zArr2[i_renamed] = renderer.getState() != 0;
                            com.google.android.exoplayer2.source.SampleStream sampleStream = playingPeriod2.sampleStreams[i_renamed];
                            if (sampleStream != null) {
                                i2++;
                            }
                            if (zArr2[i_renamed]) {
                                if (sampleStream != renderer.getStream()) {
                                    disableRenderer(renderer);
                                } else if (zArr[i_renamed]) {
                                    renderer.resetPosition(this.rendererPositionUs);
                                }
                            }
                            i_renamed++;
                        }
                        this.playbackInfo = this.playbackInfo.copyWithTrackInfo(playingPeriod2.trackGroups, playingPeriod2.trackSelectorResult);
                        enableRenderers(zArr2, i2);
                    } else {
                        this.queue.removeAfter(playingPeriod);
                        if (playingPeriod.prepared) {
                            playingPeriod.applyTrackSelection(java.lang.Math.max(playingPeriod.info.startPositionUs, playingPeriod.toPeriodTime(this.rendererPositionUs)), false);
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

    private void updateTrackSelectionPlaybackSpeed(float f_renamed) {
        for (com.google.android.exoplayer2.MediaPeriodHolder frontPeriod = this.queue.getFrontPeriod(); frontPeriod != null; frontPeriod = frontPeriod.next) {
            if (frontPeriod.trackSelectorResult != null) {
                for (com.google.android.exoplayer2.trackselection.TrackSelection trackSelection : frontPeriod.trackSelectorResult.selections.getAll()) {
                    if (trackSelection != null) {
                        trackSelection.onPlaybackSpeed(f_renamed);
                    }
                }
            }
        }
    }

    private boolean shouldTransitionToReadyState(boolean z_renamed) {
        if (this.enabledRenderers.length == 0) {
            return isTimelineReady();
        }
        if (!z_renamed) {
            return false;
        }
        if (!this.playbackInfo.isLoading) {
            return true;
        }
        com.google.android.exoplayer2.MediaPeriodHolder loadingPeriod = this.queue.getLoadingPeriod();
        return (loadingPeriod.isFullyBuffered() && loadingPeriod.info.isFinal) || this.loadControl.shouldStartPlayback(getTotalBufferedDurationUs(), this.mediaClock.getPlaybackParameters().speed, this.rebuffering);
    }

    private boolean isTimelineReady() {
        com.google.android.exoplayer2.MediaPeriodHolder playingPeriod = this.queue.getPlayingPeriod();
        long j_renamed = playingPeriod.info.durationUs;
        return j_renamed == -9223372036854775807L || this.playbackInfo.positionUs < j_renamed || (playingPeriod.next != null && (playingPeriod.next.prepared || playingPeriod.next.info.id_renamed.isAd()));
    }

    private void maybeThrowSourceInfoRefreshError() throws java.io.IOException {
        if (this.queue.getLoadingPeriod() != null) {
            for (com.google.android.exoplayer2.Renderer renderer : this.enabledRenderers) {
                if (!renderer.hasReadStreamToEnd()) {
                    return;
                }
            }
        }
        this.mediaSource.maybeThrowSourceInfoRefreshError();
    }

    private void maybeThrowPeriodPrepareError() throws java.io.IOException {
        com.google.android.exoplayer2.MediaPeriodHolder loadingPeriod = this.queue.getLoadingPeriod();
        com.google.android.exoplayer2.MediaPeriodHolder readingPeriod = this.queue.getReadingPeriod();
        if (loadingPeriod == null || loadingPeriod.prepared) {
            return;
        }
        if (readingPeriod == null || readingPeriod.next == loadingPeriod) {
            for (com.google.android.exoplayer2.Renderer renderer : this.enabledRenderers) {
                if (!renderer.hasReadStreamToEnd()) {
                    return;
                }
            }
            loadingPeriod.mediaPeriod.maybeThrowPrepareError();
        }
    }

    private void handleSourceInfoRefreshed(com.google.android.exoplayer2.ExoPlayerImplInternal.MediaSourceRefreshInfo mediaSourceRefreshInfo) throws com.google.android.exoplayer2.ExoPlaybackException {
        if (mediaSourceRefreshInfo.source != this.mediaSource) {
            return;
        }
        com.google.android.exoplayer2.Timeline timeline = this.playbackInfo.timeline;
        com.google.android.exoplayer2.Timeline timeline2 = mediaSourceRefreshInfo.timeline;
        java.lang.Object obj = mediaSourceRefreshInfo.manifest;
        this.queue.setTimeline(timeline2);
        this.playbackInfo = this.playbackInfo.copyWithTimeline(timeline2, obj);
        resolvePendingMessagePositions();
        int i_renamed = this.pendingPrepareCount;
        if (i_renamed > 0) {
            this.playbackInfoUpdate.incrementPendingOperationAcks(i_renamed);
            this.pendingPrepareCount = 0;
            com.google.android.exoplayer2.ExoPlayerImplInternal.SeekPosition seekPosition = this.pendingInitialSeekPosition;
            if (seekPosition == null) {
                if (this.playbackInfo.startPositionUs == -9223372036854775807L) {
                    if (timeline2.isEmpty()) {
                        handleSourceInfoRefreshEndedPlayback();
                        return;
                    }
                    android.util.Pair<java.lang.Object, java.lang.Long> periodPosition = getPeriodPosition(timeline2, timeline2.getFirstWindowIndex(this.shuffleModeEnabled), -9223372036854775807L);
                    java.lang.Object obj2 = periodPosition.first;
                    long jLongValue = ((java.lang.Long) periodPosition.second).longValue();
                    com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodIdResolveMediaPeriodIdForAds = this.queue.resolveMediaPeriodIdForAds(obj2, jLongValue);
                    this.playbackInfo = this.playbackInfo.resetToNewPosition(mediaPeriodIdResolveMediaPeriodIdForAds, mediaPeriodIdResolveMediaPeriodIdForAds.isAd() ? 0L : jLongValue, jLongValue);
                    return;
                }
                return;
            }
            try {
                android.util.Pair<java.lang.Object, java.lang.Long> pairResolveSeekPosition = resolveSeekPosition(seekPosition, true);
                this.pendingInitialSeekPosition = null;
                if (pairResolveSeekPosition == null) {
                    handleSourceInfoRefreshEndedPlayback();
                    return;
                }
                java.lang.Object obj3 = pairResolveSeekPosition.first;
                long jLongValue2 = ((java.lang.Long) pairResolveSeekPosition.second).longValue();
                com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodIdResolveMediaPeriodIdForAds2 = this.queue.resolveMediaPeriodIdForAds(obj3, jLongValue2);
                this.playbackInfo = this.playbackInfo.resetToNewPosition(mediaPeriodIdResolveMediaPeriodIdForAds2, mediaPeriodIdResolveMediaPeriodIdForAds2.isAd() ? 0L : jLongValue2, jLongValue2);
                return;
            } catch (com.google.android.exoplayer2.IllegalSeekPositionException e_renamed) {
                this.playbackInfo = this.playbackInfo.resetToNewPosition(this.playbackInfo.getDummyFirstMediaPeriodId(this.shuffleModeEnabled, this.window), -9223372036854775807L, -9223372036854775807L);
                throw e_renamed;
            }
        }
        if (timeline.isEmpty()) {
            if (timeline2.isEmpty()) {
                return;
            }
            android.util.Pair<java.lang.Object, java.lang.Long> periodPosition2 = getPeriodPosition(timeline2, timeline2.getFirstWindowIndex(this.shuffleModeEnabled), -9223372036854775807L);
            java.lang.Object obj4 = periodPosition2.first;
            long jLongValue3 = ((java.lang.Long) periodPosition2.second).longValue();
            com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodIdResolveMediaPeriodIdForAds3 = this.queue.resolveMediaPeriodIdForAds(obj4, jLongValue3);
            this.playbackInfo = this.playbackInfo.resetToNewPosition(mediaPeriodIdResolveMediaPeriodIdForAds3, mediaPeriodIdResolveMediaPeriodIdForAds3.isAd() ? 0L : jLongValue3, jLongValue3);
            return;
        }
        com.google.android.exoplayer2.MediaPeriodHolder frontPeriod = this.queue.getFrontPeriod();
        long j_renamed = this.playbackInfo.contentPositionUs;
        java.lang.Object obj5 = frontPeriod == null ? this.playbackInfo.periodId.periodUid : frontPeriod.uid;
        if (timeline2.getIndexOfPeriod(obj5) == -1) {
            java.lang.Object objResolveSubsequentPeriod = resolveSubsequentPeriod(obj5, timeline, timeline2);
            if (objResolveSubsequentPeriod == null) {
                handleSourceInfoRefreshEndedPlayback();
                return;
            }
            android.util.Pair<java.lang.Object, java.lang.Long> periodPosition3 = getPeriodPosition(timeline2, timeline2.getPeriodByUid(objResolveSubsequentPeriod, this.period).windowIndex, -9223372036854775807L);
            java.lang.Object obj6 = periodPosition3.first;
            long jLongValue4 = ((java.lang.Long) periodPosition3.second).longValue();
            com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodIdResolveMediaPeriodIdForAds4 = this.queue.resolveMediaPeriodIdForAds(obj6, jLongValue4);
            if (frontPeriod != null) {
                while (frontPeriod.next != null) {
                    frontPeriod = frontPeriod.next;
                    if (frontPeriod.info.id_renamed.equals(mediaPeriodIdResolveMediaPeriodIdForAds4)) {
                        frontPeriod.info = this.queue.getUpdatedMediaPeriodInfo(frontPeriod.info);
                    }
                }
            }
            this.playbackInfo = this.playbackInfo.copyWithNewPosition(mediaPeriodIdResolveMediaPeriodIdForAds4, seekToPeriodPosition(mediaPeriodIdResolveMediaPeriodIdForAds4, mediaPeriodIdResolveMediaPeriodIdForAds4.isAd() ? 0L : jLongValue4), jLongValue4, getTotalBufferedDurationUs());
            return;
        }
        com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId = this.playbackInfo.periodId;
        if (mediaPeriodId.isAd()) {
            com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodIdResolveMediaPeriodIdForAds5 = this.queue.resolveMediaPeriodIdForAds(obj5, j_renamed);
            if (!mediaPeriodIdResolveMediaPeriodIdForAds5.equals(mediaPeriodId)) {
                this.playbackInfo = this.playbackInfo.copyWithNewPosition(mediaPeriodIdResolveMediaPeriodIdForAds5, seekToPeriodPosition(mediaPeriodIdResolveMediaPeriodIdForAds5, mediaPeriodIdResolveMediaPeriodIdForAds5.isAd() ? 0L : j_renamed), j_renamed, getTotalBufferedDurationUs());
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

    private java.lang.Object resolveSubsequentPeriod(java.lang.Object obj, com.google.android.exoplayer2.Timeline timeline, com.google.android.exoplayer2.Timeline timeline2) {
        int indexOfPeriod = timeline.getIndexOfPeriod(obj);
        int periodCount = timeline.getPeriodCount();
        int nextPeriodIndex = indexOfPeriod;
        int indexOfPeriod2 = -1;
        for (int i_renamed = 0; i_renamed < periodCount && indexOfPeriod2 == -1; i_renamed++) {
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

    private android.util.Pair<java.lang.Object, java.lang.Long> resolveSeekPosition(com.google.android.exoplayer2.ExoPlayerImplInternal.SeekPosition seekPosition, boolean z_renamed) {
        int indexOfPeriod;
        com.google.android.exoplayer2.Timeline timeline = this.playbackInfo.timeline;
        com.google.android.exoplayer2.Timeline timeline2 = seekPosition.timeline;
        if (timeline.isEmpty()) {
            return null;
        }
        if (timeline2.isEmpty()) {
            timeline2 = timeline;
        }
        try {
            android.util.Pair<java.lang.Object, java.lang.Long> periodPosition = timeline2.getPeriodPosition(this.window, this.period, seekPosition.windowIndex, seekPosition.windowPositionUs);
            if (timeline == timeline2 || (indexOfPeriod = timeline.getIndexOfPeriod(periodPosition.first)) != -1) {
                return periodPosition;
            }
            if (!z_renamed || resolveSubsequentPeriod(periodPosition.first, timeline2, timeline) == null) {
                return null;
            }
            return getPeriodPosition(timeline, timeline.getPeriod(indexOfPeriod, this.period).windowIndex, -9223372036854775807L);
        } catch (java.lang.IndexOutOfBoundsException unused) {
            throw new com.google.android.exoplayer2.IllegalSeekPositionException(timeline, seekPosition.windowIndex, seekPosition.windowPositionUs);
        }
    }

    private android.util.Pair<java.lang.Object, java.lang.Long> getPeriodPosition(com.google.android.exoplayer2.Timeline timeline, int i_renamed, long j_renamed) {
        return timeline.getPeriodPosition(this.window, this.period, i_renamed, j_renamed);
    }

    private void updatePeriods() throws com.google.android.exoplayer2.ExoPlaybackException, java.io.IOException {
        com.google.android.exoplayer2.source.MediaSource mediaSource = this.mediaSource;
        if (mediaSource == null) {
            return;
        }
        if (this.pendingPrepareCount > 0) {
            mediaSource.maybeThrowSourceInfoRefreshError();
            return;
        }
        maybeUpdateLoadingPeriod();
        com.google.android.exoplayer2.MediaPeriodHolder loadingPeriod = this.queue.getLoadingPeriod();
        int i_renamed = 0;
        if (loadingPeriod == null || loadingPeriod.isFullyBuffered()) {
            setIsLoading(false);
        } else if (!this.playbackInfo.isLoading) {
            maybeContinueLoading();
        }
        if (!this.queue.hasPlayingPeriod()) {
            return;
        }
        com.google.android.exoplayer2.MediaPeriodHolder playingPeriod = this.queue.getPlayingPeriod();
        com.google.android.exoplayer2.MediaPeriodHolder readingPeriod = this.queue.getReadingPeriod();
        boolean z_renamed = false;
        while (this.playWhenReady && playingPeriod != readingPeriod && this.rendererPositionUs >= playingPeriod.next.getStartPositionRendererTime()) {
            if (z_renamed) {
                maybeNotifyPlaybackInfoChanged();
            }
            int i2 = playingPeriod.info.isLastInTimelinePeriod ? 0 : 3;
            com.google.android.exoplayer2.MediaPeriodHolder mediaPeriodHolderAdvancePlayingPeriod = this.queue.advancePlayingPeriod();
            updatePlayingPeriodRenderers(playingPeriod);
            this.playbackInfo = this.playbackInfo.copyWithNewPosition(mediaPeriodHolderAdvancePlayingPeriod.info.id_renamed, mediaPeriodHolderAdvancePlayingPeriod.info.startPositionUs, mediaPeriodHolderAdvancePlayingPeriod.info.contentPositionUs, getTotalBufferedDurationUs());
            this.playbackInfoUpdate.setPositionDiscontinuity(i2);
            updatePlaybackPositions();
            z_renamed = true;
            playingPeriod = mediaPeriodHolderAdvancePlayingPeriod;
        }
        if (readingPeriod.info.isFinal) {
            while (true) {
                com.google.android.exoplayer2.Renderer[] rendererArr = this.renderers;
                if (i_renamed >= rendererArr.length) {
                    return;
                }
                com.google.android.exoplayer2.Renderer renderer = rendererArr[i_renamed];
                com.google.android.exoplayer2.source.SampleStream sampleStream = readingPeriod.sampleStreams[i_renamed];
                if (sampleStream != null && renderer.getStream() == sampleStream && renderer.hasReadStreamToEnd()) {
                    renderer.setCurrentStreamFinal();
                }
                i_renamed++;
            }
        } else {
            if (readingPeriod.next == null) {
                return;
            }
            int i3 = 0;
            while (true) {
                com.google.android.exoplayer2.Renderer[] rendererArr2 = this.renderers;
                if (i3 < rendererArr2.length) {
                    com.google.android.exoplayer2.Renderer renderer2 = rendererArr2[i3];
                    com.google.android.exoplayer2.source.SampleStream sampleStream2 = readingPeriod.sampleStreams[i3];
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
                    com.google.android.exoplayer2.trackselection.TrackSelectorResult trackSelectorResult = readingPeriod.trackSelectorResult;
                    com.google.android.exoplayer2.MediaPeriodHolder mediaPeriodHolderAdvanceReadingPeriod = this.queue.advanceReadingPeriod();
                    com.google.android.exoplayer2.trackselection.TrackSelectorResult trackSelectorResult2 = mediaPeriodHolderAdvanceReadingPeriod.trackSelectorResult;
                    boolean z2 = mediaPeriodHolderAdvanceReadingPeriod.mediaPeriod.readDiscontinuity() != -9223372036854775807L;
                    int i4 = 0;
                    while (true) {
                        com.google.android.exoplayer2.Renderer[] rendererArr3 = this.renderers;
                        if (i4 >= rendererArr3.length) {
                            return;
                        }
                        com.google.android.exoplayer2.Renderer renderer3 = rendererArr3[i4];
                        if (trackSelectorResult.isRendererEnabled(i4)) {
                            if (z2) {
                                renderer3.setCurrentStreamFinal();
                            } else if (!renderer3.isCurrentStreamFinal()) {
                                com.google.android.exoplayer2.trackselection.TrackSelection trackSelection = trackSelectorResult2.selections.get(i4);
                                boolean zIsRendererEnabled = trackSelectorResult2.isRendererEnabled(i4);
                                boolean z3 = this.rendererCapabilities[i4].getTrackType() == 6;
                                com.google.android.exoplayer2.RendererConfiguration rendererConfiguration = trackSelectorResult.rendererConfigurations[i4];
                                com.google.android.exoplayer2.RendererConfiguration rendererConfiguration2 = trackSelectorResult2.rendererConfigurations[i4];
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

    private void maybeUpdateLoadingPeriod() throws java.io.IOException {
        this.queue.reevaluateBuffer(this.rendererPositionUs);
        if (this.queue.shouldLoadNextMediaPeriod()) {
            com.google.android.exoplayer2.MediaPeriodInfo nextMediaPeriodInfo = this.queue.getNextMediaPeriodInfo(this.rendererPositionUs, this.playbackInfo);
            if (nextMediaPeriodInfo == null) {
                maybeThrowSourceInfoRefreshError();
                return;
            }
            this.queue.enqueueNextMediaPeriod(this.rendererCapabilities, this.trackSelector, this.loadControl.getAllocator(), this.mediaSource, nextMediaPeriodInfo).prepare(this, nextMediaPeriodInfo.startPositionUs);
            setIsLoading(true);
            handleLoadingMediaPeriodChanged(false);
        }
    }

    private void handlePeriodPrepared(com.google.android.exoplayer2.source.MediaPeriod mediaPeriod) throws com.google.android.exoplayer2.ExoPlaybackException {
        if (this.queue.isLoading(mediaPeriod)) {
            com.google.android.exoplayer2.MediaPeriodHolder loadingPeriod = this.queue.getLoadingPeriod();
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

    private void handleContinueLoadingRequested(com.google.android.exoplayer2.source.MediaPeriod mediaPeriod) {
        if (this.queue.isLoading(mediaPeriod)) {
            this.queue.reevaluateBuffer(this.rendererPositionUs);
            maybeContinueLoading();
        }
    }

    private void handlePlaybackParameters(com.google.android.exoplayer2.PlaybackParameters playbackParameters) throws com.google.android.exoplayer2.ExoPlaybackException {
        this.eventHandler.obtainMessage(1, playbackParameters).sendToTarget();
        updateTrackSelectionPlaybackSpeed(playbackParameters.speed);
        for (com.google.android.exoplayer2.Renderer renderer : this.renderers) {
            if (renderer != null) {
                renderer.setOperatingRate(playbackParameters.speed);
            }
        }
    }

    private void handleSeekCompleted(boolean z_renamed) {
        int curSeekId = this.seekParamsInternal.getCurSeekId();
        this.seekParamsInternal.finishSeek();
        this.eventHandler.obtainMessage(3, curSeekId, !z_renamed ? 1 : 0).sendToTarget();
    }

    private void maybeContinueLoading() {
        com.google.android.exoplayer2.MediaPeriodHolder loadingPeriod = this.queue.getLoadingPeriod();
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

    private void updatePlayingPeriodRenderers(com.google.android.exoplayer2.MediaPeriodHolder mediaPeriodHolder) throws com.google.android.exoplayer2.ExoPlaybackException {
        com.google.android.exoplayer2.MediaPeriodHolder playingPeriod = this.queue.getPlayingPeriod();
        if (playingPeriod == null || mediaPeriodHolder == playingPeriod) {
            return;
        }
        boolean[] zArr = new boolean[this.renderers.length];
        int i_renamed = 0;
        int i2 = 0;
        while (true) {
            com.google.android.exoplayer2.Renderer[] rendererArr = this.renderers;
            if (i_renamed < rendererArr.length) {
                com.google.android.exoplayer2.Renderer renderer = rendererArr[i_renamed];
                zArr[i_renamed] = renderer.getState() != 0;
                if (playingPeriod.trackSelectorResult.isRendererEnabled(i_renamed)) {
                    i2++;
                }
                if (zArr[i_renamed] && (!playingPeriod.trackSelectorResult.isRendererEnabled(i_renamed) || (renderer.isCurrentStreamFinal() && renderer.getStream() == mediaPeriodHolder.sampleStreams[i_renamed]))) {
                    disableRenderer(renderer);
                }
                i_renamed++;
            } else {
                this.playbackInfo = this.playbackInfo.copyWithTrackInfo(playingPeriod.trackGroups, playingPeriod.trackSelectorResult);
                enableRenderers(zArr, i2);
                return;
            }
        }
    }

    private void enableRenderers(boolean[] zArr, int i_renamed) throws com.google.android.exoplayer2.ExoPlaybackException {
        this.enabledRenderers = new com.google.android.exoplayer2.Renderer[i_renamed];
        com.google.android.exoplayer2.MediaPeriodHolder playingPeriod = this.queue.getPlayingPeriod();
        int i2 = 0;
        for (int i3 = 0; i3 < this.renderers.length; i3++) {
            if (playingPeriod.trackSelectorResult.isRendererEnabled(i3)) {
                enableRenderer(i3, zArr[i3], i2);
                i2++;
            }
        }
    }

    private void enableRenderer(int i_renamed, boolean z_renamed, int i2) throws com.google.android.exoplayer2.ExoPlaybackException {
        com.google.android.exoplayer2.MediaPeriodHolder playingPeriod = this.queue.getPlayingPeriod();
        com.google.android.exoplayer2.Renderer renderer = this.renderers[i_renamed];
        this.enabledRenderers[i2] = renderer;
        if (renderer.getState() == 0) {
            com.google.android.exoplayer2.RendererConfiguration rendererConfiguration = playingPeriod.trackSelectorResult.rendererConfigurations[i_renamed];
            com.google.android.exoplayer2.Format[] formats = getFormats(playingPeriod.trackSelectorResult.selections.get(i_renamed));
            boolean z2 = this.playWhenReady && this.playbackInfo.playbackState == 3;
            renderer.enable(rendererConfiguration, formats, playingPeriod.sampleStreams[i_renamed], this.rendererPositionUs, !z_renamed && z2, playingPeriod.getRendererOffset());
            this.mediaClock.onRendererEnabled(renderer);
            if (z2) {
                renderer.start();
            }
        }
    }

    private boolean rendererWaitingForNextStream(com.google.android.exoplayer2.Renderer renderer) {
        com.google.android.exoplayer2.MediaPeriodHolder readingPeriod = this.queue.getReadingPeriod();
        return readingPeriod.next != null && readingPeriod.next.prepared && renderer.hasReadStreamToEnd();
    }

    private void handleLoadingMediaPeriodChanged(boolean z_renamed) {
        com.google.android.exoplayer2.MediaPeriodHolder loadingPeriod = this.queue.getLoadingPeriod();
        com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId = loadingPeriod == null ? this.playbackInfo.periodId : loadingPeriod.info.id_renamed;
        boolean z2 = !this.playbackInfo.loadingMediaPeriodId.equals(mediaPeriodId);
        if (z2) {
            this.playbackInfo = this.playbackInfo.copyWithLoadingMediaPeriodId(mediaPeriodId);
        }
        com.google.android.exoplayer2.PlaybackInfo playbackInfo = this.playbackInfo;
        playbackInfo.bufferedPositionUs = loadingPeriod == null ? playbackInfo.positionUs : loadingPeriod.getBufferedPositionUs();
        this.playbackInfo.totalBufferedDurationUs = getTotalBufferedDurationUs();
        if ((z2 || z_renamed) && loadingPeriod != null && loadingPeriod.prepared) {
            updateLoadControlTrackSelection(loadingPeriod.trackGroups, loadingPeriod.trackSelectorResult);
        }
    }

    private long getTotalBufferedDurationUs() {
        return getTotalBufferedDurationUs(this.playbackInfo.bufferedPositionUs);
    }

    private long getTotalBufferedDurationUs(long j_renamed) {
        com.google.android.exoplayer2.MediaPeriodHolder loadingPeriod = this.queue.getLoadingPeriod();
        if (loadingPeriod == null) {
            return 0L;
        }
        return j_renamed - loadingPeriod.toPeriodTime(this.rendererPositionUs);
    }

    private void updateLoadControlTrackSelection(com.google.android.exoplayer2.source.TrackGroupArray trackGroupArray, com.google.android.exoplayer2.trackselection.TrackSelectorResult trackSelectorResult) {
        this.loadControl.onTracksSelected(this.renderers, trackGroupArray, trackSelectorResult.selections);
    }

    private static com.google.android.exoplayer2.Format[] getFormats(com.google.android.exoplayer2.trackselection.TrackSelection trackSelection) {
        int length = trackSelection != null ? trackSelection.length() : 0;
        com.google.android.exoplayer2.Format[] formatArr = new com.google.android.exoplayer2.Format[length];
        for (int i_renamed = 0; i_renamed < length; i_renamed++) {
            formatArr[i_renamed] = trackSelection.getFormat(i_renamed);
        }
        return formatArr;
    }

    private static final class SeekPosition {
        public final com.google.android.exoplayer2.Timeline timeline;
        public final int windowIndex;
        public final long windowPositionUs;

        public SeekPosition(com.google.android.exoplayer2.Timeline timeline, int i_renamed, long j_renamed) {
            this.timeline = timeline;
            this.windowIndex = i_renamed;
            this.windowPositionUs = j_renamed;
        }
    }

    private static final class PendingMessageInfo implements java.lang.Comparable<com.google.android.exoplayer2.ExoPlayerImplInternal.PendingMessageInfo> {
        public final com.google.android.exoplayer2.PlayerMessage message;
        public int resolvedPeriodIndex;
        public long resolvedPeriodTimeUs;
        public java.lang.Object resolvedPeriodUid;

        public PendingMessageInfo(com.google.android.exoplayer2.PlayerMessage playerMessage) {
            this.message = playerMessage;
        }

        public void setResolvedPosition(int i_renamed, long j_renamed, java.lang.Object obj) {
            this.resolvedPeriodIndex = i_renamed;
            this.resolvedPeriodTimeUs = j_renamed;
            this.resolvedPeriodUid = obj;
        }

        @Override // java.lang.Comparable
        public int compareTo(com.google.android.exoplayer2.ExoPlayerImplInternal.PendingMessageInfo pendingMessageInfo) {
            if ((this.resolvedPeriodUid == null) != (pendingMessageInfo.resolvedPeriodUid == null)) {
                return this.resolvedPeriodUid != null ? -1 : 1;
            }
            if (this.resolvedPeriodUid == null) {
                return 0;
            }
            int i_renamed = this.resolvedPeriodIndex - pendingMessageInfo.resolvedPeriodIndex;
            return i_renamed != 0 ? i_renamed : com.google.android.exoplayer2.util.Util.compareLong(this.resolvedPeriodTimeUs, pendingMessageInfo.resolvedPeriodTimeUs);
        }
    }

    private static final class MediaSourceRefreshInfo {
        public final java.lang.Object manifest;
        public final com.google.android.exoplayer2.source.MediaSource source;
        public final com.google.android.exoplayer2.Timeline timeline;

        public MediaSourceRefreshInfo(com.google.android.exoplayer2.source.MediaSource mediaSource, com.google.android.exoplayer2.Timeline timeline, java.lang.Object obj) {
            this.source = mediaSource;
            this.timeline = timeline;
            this.manifest = obj;
        }
    }

    private static final class PlaybackInfoUpdate {
        private int discontinuityReason;
        private com.google.android.exoplayer2.PlaybackInfo lastPlaybackInfo;
        private int operationAcks;
        private boolean positionDiscontinuity;

        private PlaybackInfoUpdate() {
        }

        public boolean hasPendingUpdate(com.google.android.exoplayer2.PlaybackInfo playbackInfo) {
            return playbackInfo != this.lastPlaybackInfo || this.operationAcks > 0 || this.positionDiscontinuity;
        }

        public void reset(com.google.android.exoplayer2.PlaybackInfo playbackInfo) {
            this.lastPlaybackInfo = playbackInfo;
            this.operationAcks = 0;
            this.positionDiscontinuity = false;
        }

        public void incrementPendingOperationAcks(int i_renamed) {
            this.operationAcks += i_renamed;
        }

        public void setPositionDiscontinuity(int i_renamed) {
            if (this.positionDiscontinuity && this.discontinuityReason != 4) {
                com.google.android.exoplayer2.util.Assertions.checkArgument(i_renamed == 4);
            } else {
                this.positionDiscontinuity = true;
                this.discontinuityReason = i_renamed;
            }
        }
    }
}

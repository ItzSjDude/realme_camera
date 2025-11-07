package com.google.android.exoplayer2;

/* loaded from: classes.dex */
final class ExoPlayerImpl extends com.google.android.exoplayer2.BasePlayer implements com.google.android.exoplayer2.ExoPlayer {
    private static final java.lang.String TAG = "ExoPlayerImpl";
    final com.google.android.exoplayer2.trackselection.TrackSelectorResult emptyTrackSelectorResult;
    private final android.os.Handler eventHandler;
    private boolean hasPendingPrepare;
    private boolean hasPendingSeek;
    private boolean internalPlayWhenReady;
    private final com.google.android.exoplayer2.ExoPlayerImplInternal internalPlayer;
    private final android.os.Handler internalPlayerHandler;
    private final java.util.concurrent.CopyOnWriteArraySet<com.google.android.exoplayer2.Player.EventListener> listeners;
    private int maskingPeriodIndex;
    private int maskingWindowIndex;
    private long maskingWindowPositionMs;
    private com.google.android.exoplayer2.source.MediaSource mediaSource;
    private int pendingOperationAcks;
    private final java.util.ArrayDeque<com.google.android.exoplayer2.ExoPlayerImpl.PlaybackInfoUpdate> pendingPlaybackInfoUpdates;
    private final com.google.android.exoplayer2.Timeline.Period period;
    private boolean playWhenReady;
    private com.google.android.exoplayer2.ExoPlaybackException playbackError;
    private com.google.android.exoplayer2.PlaybackInfo playbackInfo;
    private com.google.android.exoplayer2.PlaybackParameters playbackParameters;
    private final com.google.android.exoplayer2.Renderer[] renderers;
    private int repeatMode;
    private int seekId;
    private com.google.android.exoplayer2.SeekParameters seekParameters;
    private int seekType;
    private boolean shuffleModeEnabled;
    private final com.google.android.exoplayer2.trackselection.TrackSelector trackSelector;

    @Override // com.google.android.exoplayer2.Player
    public void fastSeekTo(int i_renamed, long j_renamed, boolean z_renamed) {
    }

    @Override // com.google.android.exoplayer2.Player
    public com.google.android.exoplayer2.Player.AudioComponent getAudioComponent() {
        return null;
    }

    @Override // com.google.android.exoplayer2.Player
    public com.google.android.exoplayer2.Player.MetadataComponent getMetadataComponent() {
        return null;
    }

    @Override // com.google.android.exoplayer2.Player
    public com.google.android.exoplayer2.Player.TextComponent getTextComponent() {
        return null;
    }

    @Override // com.google.android.exoplayer2.Player
    public com.google.android.exoplayer2.Player.VideoComponent getVideoComponent() {
        return null;
    }

    @android.annotation.SuppressLint({"HandlerLeak"})
    public ExoPlayerImpl(com.google.android.exoplayer2.Renderer[] rendererArr, com.google.android.exoplayer2.trackselection.TrackSelector trackSelector, com.google.android.exoplayer2.LoadControl loadControl, com.google.android.exoplayer2.upstream.BandwidthMeter bandwidthMeter, com.google.android.exoplayer2.util.Clock clock, android.os.Looper looper) {
        com.google.android.exoplayer2.util.Log.i_renamed(TAG, "Init " + java.lang.Integer.toHexString(java.lang.System.identityHashCode(this)) + " [" + com.google.android.exoplayer2.ExoPlayerLibraryInfo.VERSION_SLASHY + "] [" + com.google.android.exoplayer2.util.Util.DEVICE_DEBUG_INFO + "]");
        com.google.android.exoplayer2.util.Assertions.checkState(rendererArr.length > 0);
        this.renderers = (com.google.android.exoplayer2.Renderer[]) com.google.android.exoplayer2.util.Assertions.checkNotNull(rendererArr);
        this.trackSelector = (com.google.android.exoplayer2.trackselection.TrackSelector) com.google.android.exoplayer2.util.Assertions.checkNotNull(trackSelector);
        this.playWhenReady = false;
        this.repeatMode = 0;
        this.shuffleModeEnabled = false;
        this.listeners = new java.util.concurrent.CopyOnWriteArraySet<>();
        this.emptyTrackSelectorResult = new com.google.android.exoplayer2.trackselection.TrackSelectorResult(new com.google.android.exoplayer2.RendererConfiguration[rendererArr.length], new com.google.android.exoplayer2.trackselection.TrackSelection[rendererArr.length], null);
        this.period = new com.google.android.exoplayer2.Timeline.Period();
        this.playbackParameters = com.google.android.exoplayer2.PlaybackParameters.DEFAULT;
        this.seekParameters = com.google.android.exoplayer2.SeekParameters.DEFAULT;
        this.eventHandler = new android.os.Handler(looper) { // from class: com.google.android.exoplayer2.ExoPlayerImpl.1
            @Override // android.os.Handler
            public void handleMessage(android.os.Message message) {
                com.google.android.exoplayer2.ExoPlayerImpl.this.handleEvent(message);
            }
        };
        this.playbackInfo = com.google.android.exoplayer2.PlaybackInfo.createDummy(0L, this.emptyTrackSelectorResult);
        this.pendingPlaybackInfoUpdates = new java.util.ArrayDeque<>();
        this.internalPlayer = new com.google.android.exoplayer2.ExoPlayerImplInternal(rendererArr, trackSelector, this.emptyTrackSelectorResult, loadControl, bandwidthMeter, this.playWhenReady, this.repeatMode, this.shuffleModeEnabled, this.eventHandler, clock);
        this.internalPlayerHandler = new android.os.Handler(this.internalPlayer.getPlaybackLooper());
        this.seekId = -1;
        this.seekType = 0;
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public android.os.Looper getPlaybackLooper() {
        return this.internalPlayer.getPlaybackLooper();
    }

    @Override // com.google.android.exoplayer2.Player
    public android.os.Looper getApplicationLooper() {
        return this.eventHandler.getLooper();
    }

    @Override // com.google.android.exoplayer2.Player
    public void addListener(com.google.android.exoplayer2.Player.EventListener eventListener) {
        this.listeners.add(eventListener);
    }

    @Override // com.google.android.exoplayer2.Player
    public void removeListener(com.google.android.exoplayer2.Player.EventListener eventListener) {
        this.listeners.remove(eventListener);
    }

    @Override // com.google.android.exoplayer2.Player
    public int getPlaybackState() {
        return this.playbackInfo.playbackState;
    }

    @Override // com.google.android.exoplayer2.Player
    public com.google.android.exoplayer2.ExoPlaybackException getPlaybackError() {
        return this.playbackError;
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public void retry() {
        if (this.mediaSource != null) {
            if (this.playbackError != null || this.playbackInfo.playbackState == 1) {
                prepare(this.mediaSource, false, false);
            }
        }
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public void prepare(com.google.android.exoplayer2.source.MediaSource mediaSource) {
        prepare(mediaSource, true, true);
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public void prepare(com.google.android.exoplayer2.source.MediaSource mediaSource, boolean z_renamed, boolean z2) {
        this.playbackError = null;
        this.mediaSource = mediaSource;
        com.google.android.exoplayer2.PlaybackInfo resetPlaybackInfo = getResetPlaybackInfo(z_renamed, z2, 2);
        this.hasPendingPrepare = true;
        this.pendingOperationAcks++;
        this.internalPlayer.prepare(mediaSource, z_renamed, z2);
        updatePlaybackInfo(resetPlaybackInfo, false, 4, 1, false, false);
    }

    @Override // com.google.android.exoplayer2.Player
    public void setPlayWhenReady(boolean z_renamed) {
        setPlayWhenReady(z_renamed, false);
    }

    public void setPlayWhenReady(boolean z_renamed, boolean z2) {
        boolean z3 = z_renamed && !z2;
        if (this.internalPlayWhenReady != z3) {
            this.internalPlayWhenReady = z3;
            this.internalPlayer.setPlayWhenReady(z3);
        }
        if (this.playWhenReady != z_renamed) {
            this.playWhenReady = z_renamed;
            updatePlaybackInfo(this.playbackInfo, false, 4, 1, false, true);
        }
    }

    @Override // com.google.android.exoplayer2.Player
    public boolean getPlayWhenReady() {
        return this.playWhenReady;
    }

    @Override // com.google.android.exoplayer2.Player
    public void setRepeatMode(int i_renamed) {
        if (this.repeatMode != i_renamed) {
            this.repeatMode = i_renamed;
            this.internalPlayer.setRepeatMode(i_renamed);
            java.util.Iterator<com.google.android.exoplayer2.Player.EventListener> it = this.listeners.iterator();
            while (it.hasNext()) {
                it.next().onRepeatModeChanged(i_renamed);
            }
        }
    }

    @Override // com.google.android.exoplayer2.Player
    public int getRepeatMode() {
        return this.repeatMode;
    }

    @Override // com.google.android.exoplayer2.Player
    public void setShuffleModeEnabled(boolean z_renamed) {
        if (this.shuffleModeEnabled != z_renamed) {
            this.shuffleModeEnabled = z_renamed;
            this.internalPlayer.setShuffleModeEnabled(z_renamed);
            java.util.Iterator<com.google.android.exoplayer2.Player.EventListener> it = this.listeners.iterator();
            while (it.hasNext()) {
                it.next().onShuffleModeEnabledChanged(z_renamed);
            }
        }
    }

    @Override // com.google.android.exoplayer2.Player
    public boolean getShuffleModeEnabled() {
        return this.shuffleModeEnabled;
    }

    @Override // com.google.android.exoplayer2.Player
    public boolean isLoading() {
        return this.playbackInfo.isLoading;
    }

    public void setSeekIdAndType(int i_renamed, int i2) {
        this.seekId = i_renamed;
        this.seekType = i2;
    }

    @Override // com.google.android.exoplayer2.Player
    public void seekTo(int i_renamed, long j_renamed) {
        com.google.android.exoplayer2.Timeline timeline = this.playbackInfo.timeline;
        if (i_renamed < 0 || (!timeline.isEmpty() && i_renamed >= timeline.getWindowCount())) {
            throw new com.google.android.exoplayer2.IllegalSeekPositionException(timeline, i_renamed, j_renamed);
        }
        this.hasPendingSeek = true;
        this.pendingOperationAcks++;
        if (isPlayingAd()) {
            com.google.android.exoplayer2.util.Log.w_renamed(TAG, "seekTo ignored because an_renamed ad_renamed is_renamed playing");
            this.eventHandler.obtainMessage(0, 1, -1, this.playbackInfo).sendToTarget();
            this.eventHandler.obtainMessage(3, this.seekId, 1).sendToTarget();
            return;
        }
        this.maskingWindowIndex = i_renamed;
        if (timeline.isEmpty()) {
            this.maskingWindowPositionMs = j_renamed == -9223372036854775807L ? 0L : j_renamed;
            this.maskingPeriodIndex = 0;
        } else {
            long defaultPositionUs = j_renamed == -9223372036854775807L ? timeline.getWindow(i_renamed, this.window).getDefaultPositionUs() : com.google.android.exoplayer2.C_renamed.msToUs(j_renamed);
            android.util.Pair<java.lang.Object, java.lang.Long> periodPosition = timeline.getPeriodPosition(this.window, this.period, i_renamed, defaultPositionUs);
            this.maskingWindowPositionMs = com.google.android.exoplayer2.C_renamed.usToMs(defaultPositionUs);
            this.maskingPeriodIndex = timeline.getIndexOfPeriod(periodPosition.first);
        }
        this.internalPlayer.seekTo(timeline, i_renamed, com.google.android.exoplayer2.C_renamed.msToUs(j_renamed), this.seekId, this.seekType);
        java.util.Iterator<com.google.android.exoplayer2.Player.EventListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().onPositionDiscontinuity(1);
        }
    }

    @Override // com.google.android.exoplayer2.Player
    public void setPlaybackParameters(com.google.android.exoplayer2.PlaybackParameters playbackParameters) {
        if (playbackParameters == null) {
            playbackParameters = com.google.android.exoplayer2.PlaybackParameters.DEFAULT;
        }
        this.internalPlayer.setPlaybackParameters(playbackParameters);
    }

    @Override // com.google.android.exoplayer2.Player
    public com.google.android.exoplayer2.PlaybackParameters getPlaybackParameters() {
        return this.playbackParameters;
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public void setSeekParameters(com.google.android.exoplayer2.SeekParameters seekParameters) {
        if (seekParameters == null) {
            seekParameters = com.google.android.exoplayer2.SeekParameters.DEFAULT;
        }
        if (this.seekParameters.equals(seekParameters)) {
            return;
        }
        this.seekParameters = seekParameters;
        this.internalPlayer.setSeekParameters(seekParameters);
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public com.google.android.exoplayer2.SeekParameters getSeekParameters() {
        return this.seekParameters;
    }

    @Override // com.google.android.exoplayer2.Player
    public void stop(boolean z_renamed) {
        if (z_renamed) {
            this.playbackError = null;
            this.mediaSource = null;
        }
        com.google.android.exoplayer2.PlaybackInfo resetPlaybackInfo = getResetPlaybackInfo(z_renamed, z_renamed, 1);
        this.pendingOperationAcks++;
        this.internalPlayer.stop(z_renamed);
        updatePlaybackInfo(resetPlaybackInfo, false, 4, 1, false, false);
    }

    @Override // com.google.android.exoplayer2.Player
    public void release() {
        com.google.android.exoplayer2.util.Log.i_renamed(TAG, "Release " + java.lang.Integer.toHexString(java.lang.System.identityHashCode(this)) + " [" + com.google.android.exoplayer2.ExoPlayerLibraryInfo.VERSION_SLASHY + "] [" + com.google.android.exoplayer2.util.Util.DEVICE_DEBUG_INFO + "] [" + com.google.android.exoplayer2.ExoPlayerLibraryInfo.registeredModules() + "]");
        this.mediaSource = null;
        this.internalPlayer.release();
        this.eventHandler.removeCallbacksAndMessages(null);
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    @java.lang.Deprecated
    public void sendMessages(com.google.android.exoplayer2.ExoPlayer.ExoPlayerMessage... exoPlayerMessageArr) {
        for (com.google.android.exoplayer2.ExoPlayer.ExoPlayerMessage exoPlayerMessage : exoPlayerMessageArr) {
            createMessage(exoPlayerMessage.target).setType(exoPlayerMessage.messageType).setPayload(exoPlayerMessage.message).send();
        }
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public com.google.android.exoplayer2.PlayerMessage createMessage(com.google.android.exoplayer2.PlayerMessage.Target target) {
        return new com.google.android.exoplayer2.PlayerMessage(this.internalPlayer, target, this.playbackInfo.timeline, getCurrentWindowIndex(), this.internalPlayerHandler);
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    @java.lang.Deprecated
    public void blockingSendMessages(com.google.android.exoplayer2.ExoPlayer.ExoPlayerMessage... exoPlayerMessageArr) {
        java.util.ArrayList<com.google.android.exoplayer2.PlayerMessage> arrayList = new java.util.ArrayList();
        for (com.google.android.exoplayer2.ExoPlayer.ExoPlayerMessage exoPlayerMessage : exoPlayerMessageArr) {
            arrayList.add(createMessage(exoPlayerMessage.target).setType(exoPlayerMessage.messageType).setPayload(exoPlayerMessage.message).send());
        }
        boolean z_renamed = false;
        for (com.google.android.exoplayer2.PlayerMessage playerMessage : arrayList) {
            boolean z2 = z_renamed;
            boolean z3 = true;
            while (z3) {
                try {
                    playerMessage.blockUntilDelivered();
                    z3 = false;
                } catch (java.lang.InterruptedException unused) {
                    z2 = true;
                }
            }
            z_renamed = z2;
        }
        if (z_renamed) {
            java.lang.Thread.currentThread().interrupt();
        }
    }

    @Override // com.google.android.exoplayer2.Player
    public int getCurrentPeriodIndex() {
        if (shouldMaskPosition()) {
            return this.maskingPeriodIndex;
        }
        return this.playbackInfo.timeline.getIndexOfPeriod(this.playbackInfo.periodId.periodUid);
    }

    @Override // com.google.android.exoplayer2.Player
    public int getCurrentWindowIndex() {
        if (shouldMaskPosition()) {
            return this.maskingWindowIndex;
        }
        return this.playbackInfo.timeline.getPeriodByUid(this.playbackInfo.periodId.periodUid, this.period).windowIndex;
    }

    @Override // com.google.android.exoplayer2.Player
    public long getDuration() {
        if (isPlayingAd()) {
            com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId = this.playbackInfo.periodId;
            this.playbackInfo.timeline.getPeriodByUid(mediaPeriodId.periodUid, this.period);
            return com.google.android.exoplayer2.C_renamed.usToMs(this.period.getAdDurationUs(mediaPeriodId.adGroupIndex, mediaPeriodId.adIndexInAdGroup));
        }
        return getContentDuration();
    }

    @Override // com.google.android.exoplayer2.Player
    public long getCurrentPosition() {
        if (shouldMaskPosition()) {
            return this.maskingWindowPositionMs;
        }
        if (this.playbackInfo.periodId.isAd()) {
            return com.google.android.exoplayer2.C_renamed.usToMs(this.playbackInfo.positionUs);
        }
        return periodPositionUsToWindowPositionMs(this.playbackInfo.periodId, this.playbackInfo.positionUs);
    }

    @Override // com.google.android.exoplayer2.Player
    public long getBufferedPosition() {
        if (isPlayingAd()) {
            if (this.playbackInfo.loadingMediaPeriodId.equals(this.playbackInfo.periodId)) {
                return com.google.android.exoplayer2.C_renamed.usToMs(this.playbackInfo.bufferedPositionUs);
            }
            return getDuration();
        }
        return getContentBufferedPosition();
    }

    @Override // com.google.android.exoplayer2.Player
    public long getTotalBufferedDuration() {
        return java.lang.Math.max(0L, com.google.android.exoplayer2.C_renamed.usToMs(this.playbackInfo.totalBufferedDurationUs));
    }

    @Override // com.google.android.exoplayer2.Player
    public boolean isPlayingAd() {
        return !shouldMaskPosition() && this.playbackInfo.periodId.isAd();
    }

    @Override // com.google.android.exoplayer2.Player
    public int getCurrentAdGroupIndex() {
        if (isPlayingAd()) {
            return this.playbackInfo.periodId.adGroupIndex;
        }
        return -1;
    }

    @Override // com.google.android.exoplayer2.Player
    public int getCurrentAdIndexInAdGroup() {
        if (isPlayingAd()) {
            return this.playbackInfo.periodId.adIndexInAdGroup;
        }
        return -1;
    }

    @Override // com.google.android.exoplayer2.Player
    public long getContentPosition() {
        if (isPlayingAd()) {
            this.playbackInfo.timeline.getPeriodByUid(this.playbackInfo.periodId.periodUid, this.period);
            return this.period.getPositionInWindowMs() + com.google.android.exoplayer2.C_renamed.usToMs(this.playbackInfo.contentPositionUs);
        }
        return getCurrentPosition();
    }

    @Override // com.google.android.exoplayer2.Player
    public long getContentBufferedPosition() {
        if (shouldMaskPosition()) {
            return this.maskingWindowPositionMs;
        }
        if (this.playbackInfo.loadingMediaPeriodId.windowSequenceNumber != this.playbackInfo.periodId.windowSequenceNumber) {
            return this.playbackInfo.timeline.getWindow(getCurrentWindowIndex(), this.window).getDurationMs();
        }
        long j_renamed = this.playbackInfo.bufferedPositionUs;
        if (this.playbackInfo.loadingMediaPeriodId.isAd()) {
            com.google.android.exoplayer2.Timeline.Period periodByUid = this.playbackInfo.timeline.getPeriodByUid(this.playbackInfo.loadingMediaPeriodId.periodUid, this.period);
            long adGroupTimeUs = periodByUid.getAdGroupTimeUs(this.playbackInfo.loadingMediaPeriodId.adGroupIndex);
            j_renamed = adGroupTimeUs == Long.MIN_VALUE ? periodByUid.durationUs : adGroupTimeUs;
        }
        return periodPositionUsToWindowPositionMs(this.playbackInfo.loadingMediaPeriodId, j_renamed);
    }

    @Override // com.google.android.exoplayer2.Player
    public int getRendererCount() {
        return this.renderers.length;
    }

    @Override // com.google.android.exoplayer2.Player
    public int getRendererType(int i_renamed) {
        return this.renderers[i_renamed].getTrackType();
    }

    @Override // com.google.android.exoplayer2.Player
    public com.google.android.exoplayer2.source.TrackGroupArray getCurrentTrackGroups() {
        return this.playbackInfo.trackGroups;
    }

    @Override // com.google.android.exoplayer2.Player
    public com.google.android.exoplayer2.trackselection.TrackSelectionArray getCurrentTrackSelections() {
        return this.playbackInfo.trackSelectorResult.selections;
    }

    @Override // com.google.android.exoplayer2.Player
    public com.google.android.exoplayer2.Timeline getCurrentTimeline() {
        return this.playbackInfo.timeline;
    }

    @Override // com.google.android.exoplayer2.Player
    public java.lang.Object getCurrentManifest() {
        return this.playbackInfo.manifest;
    }

    void handleEvent(android.os.Message message) {
        int i_renamed = message.what;
        if (i_renamed == 0) {
            handlePlaybackInfo((com.google.android.exoplayer2.PlaybackInfo) message.obj, message.arg1, message.arg2 != -1, message.arg2);
            return;
        }
        if (i_renamed == 1) {
            com.google.android.exoplayer2.PlaybackParameters playbackParameters = (com.google.android.exoplayer2.PlaybackParameters) message.obj;
            if (this.playbackParameters.equals(playbackParameters)) {
                return;
            }
            this.playbackParameters = playbackParameters;
            java.util.Iterator<com.google.android.exoplayer2.Player.EventListener> it = this.listeners.iterator();
            while (it.hasNext()) {
                it.next().onPlaybackParametersChanged(playbackParameters);
            }
            return;
        }
        if (i_renamed == 2) {
            com.google.android.exoplayer2.ExoPlaybackException exoPlaybackException = (com.google.android.exoplayer2.ExoPlaybackException) message.obj;
            this.playbackError = exoPlaybackException;
            java.util.Iterator<com.google.android.exoplayer2.Player.EventListener> it2 = this.listeners.iterator();
            while (it2.hasNext()) {
                it2.next().onPlayerError(exoPlaybackException);
            }
            return;
        }
        if (i_renamed == 3) {
            int i2 = message.arg1;
            int i3 = message.arg2;
            java.util.Iterator<com.google.android.exoplayer2.Player.EventListener> it3 = this.listeners.iterator();
            while (it3.hasNext()) {
                it3.next().onSeekCompleted(i2, i3);
            }
            return;
        }
        throw new java.lang.IllegalStateException();
    }

    private void handlePlaybackInfo(com.google.android.exoplayer2.PlaybackInfo playbackInfo, int i_renamed, boolean z_renamed, int i2) {
        this.pendingOperationAcks -= i_renamed;
        if (this.pendingOperationAcks == 0) {
            if (playbackInfo.startPositionUs == -9223372036854775807L) {
                playbackInfo = playbackInfo.resetToNewPosition(playbackInfo.periodId, 0L, playbackInfo.contentPositionUs);
            }
            com.google.android.exoplayer2.PlaybackInfo playbackInfo2 = playbackInfo;
            if ((!this.playbackInfo.timeline.isEmpty() || this.hasPendingPrepare) && playbackInfo2.timeline.isEmpty()) {
                this.maskingPeriodIndex = 0;
                this.maskingWindowIndex = 0;
                this.maskingWindowPositionMs = 0L;
            }
            int i3 = this.hasPendingPrepare ? 0 : 2;
            boolean z2 = this.hasPendingSeek;
            this.hasPendingPrepare = false;
            this.hasPendingSeek = false;
            updatePlaybackInfo(playbackInfo2, z_renamed, i2, i3, z2, false);
        }
    }

    private com.google.android.exoplayer2.PlaybackInfo getResetPlaybackInfo(boolean z_renamed, boolean z2, int i_renamed) {
        if (z_renamed) {
            this.maskingWindowIndex = 0;
            this.maskingPeriodIndex = 0;
            this.maskingWindowPositionMs = 0L;
        } else {
            this.maskingWindowIndex = getCurrentWindowIndex();
            this.maskingPeriodIndex = getCurrentPeriodIndex();
            this.maskingWindowPositionMs = getCurrentPosition();
        }
        com.google.android.exoplayer2.source.MediaSource.MediaPeriodId dummyFirstMediaPeriodId = z_renamed ? this.playbackInfo.getDummyFirstMediaPeriodId(this.shuffleModeEnabled, this.window) : this.playbackInfo.periodId;
        long j_renamed = z_renamed ? 0L : this.playbackInfo.positionUs;
        return new com.google.android.exoplayer2.PlaybackInfo(z2 ? com.google.android.exoplayer2.Timeline.EMPTY : this.playbackInfo.timeline, z2 ? null : this.playbackInfo.manifest, dummyFirstMediaPeriodId, j_renamed, z_renamed ? -9223372036854775807L : this.playbackInfo.contentPositionUs, i_renamed, false, z2 ? com.google.android.exoplayer2.source.TrackGroupArray.EMPTY : this.playbackInfo.trackGroups, z2 ? this.emptyTrackSelectorResult : this.playbackInfo.trackSelectorResult, dummyFirstMediaPeriodId, j_renamed, 0L, j_renamed, false);
    }

    private void updatePlaybackInfo(com.google.android.exoplayer2.PlaybackInfo playbackInfo, boolean z_renamed, int i_renamed, int i2, boolean z2, boolean z3) {
        boolean z4 = !this.pendingPlaybackInfoUpdates.isEmpty();
        this.pendingPlaybackInfoUpdates.addLast(new com.google.android.exoplayer2.ExoPlayerImpl.PlaybackInfoUpdate(playbackInfo, this.playbackInfo, this.listeners, this.trackSelector, z_renamed, i_renamed, i2, z2, this.playWhenReady, z3));
        this.playbackInfo = playbackInfo;
        if (z4) {
            return;
        }
        while (!this.pendingPlaybackInfoUpdates.isEmpty()) {
            this.pendingPlaybackInfoUpdates.peekFirst().notifyListeners();
            try {
                this.pendingPlaybackInfoUpdates.removeFirst();
            } catch (java.util.NoSuchElementException e_renamed) {
                e_renamed.printStackTrace();
            }
        }
    }

    private long periodPositionUsToWindowPositionMs(com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId, long j_renamed) {
        long jUsToMs = com.google.android.exoplayer2.C_renamed.usToMs(j_renamed);
        this.playbackInfo.timeline.getPeriodByUid(mediaPeriodId.periodUid, this.period);
        return jUsToMs + this.period.getPositionInWindowMs();
    }

    private boolean shouldMaskPosition() {
        return this.playbackInfo.timeline.isEmpty() || this.pendingOperationAcks > 0;
    }

    private static final class PlaybackInfoUpdate {
        private final boolean isLoadingChanged;
        private final boolean isPreparedChanged;
        private final java.util.Set<com.google.android.exoplayer2.Player.EventListener> listeners;
        private final boolean playWhenReady;
        private final com.google.android.exoplayer2.PlaybackInfo playbackInfo;
        private final boolean playbackStateOrPlayWhenReadyChanged;
        private final boolean positionDiscontinuity;
        private final int positionDiscontinuityReason;
        private final boolean seekProcessed;
        private final int timelineChangeReason;
        private final boolean timelineOrManifestChanged;
        private final com.google.android.exoplayer2.trackselection.TrackSelector trackSelector;
        private final boolean trackSelectorResultChanged;

        public PlaybackInfoUpdate(com.google.android.exoplayer2.PlaybackInfo playbackInfo, com.google.android.exoplayer2.PlaybackInfo playbackInfo2, java.util.Set<com.google.android.exoplayer2.Player.EventListener> set, com.google.android.exoplayer2.trackselection.TrackSelector trackSelector, boolean z_renamed, int i_renamed, int i2, boolean z2, boolean z3, boolean z4) {
            this.playbackInfo = playbackInfo;
            this.listeners = set;
            this.trackSelector = trackSelector;
            this.positionDiscontinuity = z_renamed;
            this.positionDiscontinuityReason = i_renamed;
            this.timelineChangeReason = i2;
            this.seekProcessed = z2;
            this.playWhenReady = z3;
            this.playbackStateOrPlayWhenReadyChanged = z4 || playbackInfo2.playbackState != playbackInfo.playbackState;
            this.timelineOrManifestChanged = (playbackInfo2.timeline == playbackInfo.timeline && playbackInfo2.manifest == playbackInfo.manifest) ? false : true;
            this.isLoadingChanged = playbackInfo2.isLoading != playbackInfo.isLoading;
            this.trackSelectorResultChanged = playbackInfo2.trackSelectorResult != playbackInfo.trackSelectorResult;
            this.isPreparedChanged = playbackInfo2.isPrepared != playbackInfo.isPrepared;
        }

        public void notifyListeners() {
            if (this.timelineOrManifestChanged || this.timelineChangeReason == 0) {
                java.util.Iterator<com.google.android.exoplayer2.Player.EventListener> it = this.listeners.iterator();
                while (it.hasNext()) {
                    it.next().onTimelineChanged(this.playbackInfo.timeline, this.playbackInfo.manifest, this.timelineChangeReason);
                }
            }
            if (this.positionDiscontinuity) {
                java.util.Iterator<com.google.android.exoplayer2.Player.EventListener> it2 = this.listeners.iterator();
                while (it2.hasNext()) {
                    it2.next().onPositionDiscontinuity(this.positionDiscontinuityReason);
                }
            }
            if (this.trackSelectorResultChanged) {
                this.trackSelector.onSelectionActivated(this.playbackInfo.trackSelectorResult.info);
                java.util.Iterator<com.google.android.exoplayer2.Player.EventListener> it3 = this.listeners.iterator();
                while (it3.hasNext()) {
                    it3.next().onTracksChanged(this.playbackInfo.trackGroups, this.playbackInfo.trackSelectorResult.selections);
                }
            }
            if (this.isLoadingChanged) {
                java.util.Iterator<com.google.android.exoplayer2.Player.EventListener> it4 = this.listeners.iterator();
                while (it4.hasNext()) {
                    it4.next().onLoadingChanged(this.playbackInfo.isLoading);
                }
            }
            if (this.playbackStateOrPlayWhenReadyChanged) {
                java.util.Iterator<com.google.android.exoplayer2.Player.EventListener> it5 = this.listeners.iterator();
                while (it5.hasNext()) {
                    it5.next().onPlayerStateChanged(this.playWhenReady, this.playbackInfo.playbackState);
                }
            }
            if (this.seekProcessed) {
                java.util.Iterator<com.google.android.exoplayer2.Player.EventListener> it6 = this.listeners.iterator();
                while (it6.hasNext()) {
                    it6.next().onSeekProcessed();
                }
            }
            if (this.isPreparedChanged && this.playbackInfo.isPrepared) {
                java.util.Iterator<com.google.android.exoplayer2.Player.EventListener> it7 = this.listeners.iterator();
                while (it7.hasNext()) {
                    it7.next().onPrepared();
                }
            }
        }
    }
}

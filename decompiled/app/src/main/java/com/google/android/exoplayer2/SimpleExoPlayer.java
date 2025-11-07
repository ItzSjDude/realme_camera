package com.google.android.exoplayer2;

@android.annotation.TargetApi(16)
/* loaded from: classes.dex */
public class SimpleExoPlayer extends com.google.android.exoplayer2.BasePlayer implements com.google.android.exoplayer2.ExoPlayer, com.google.android.exoplayer2.Player.AudioComponent, com.google.android.exoplayer2.Player.MetadataComponent, com.google.android.exoplayer2.Player.TextComponent, com.google.android.exoplayer2.Player.VideoComponent, com.google.android.exoplayer2.analytics.AnalyticsListener {
    private static int FAST_SEEK_TIME_OUT_INTERVAL_MS = 5000;
    private static final java.lang.String TAG = "SimpleExoPlayer";
    private final com.google.android.exoplayer2.analytics.AnalyticsCollector analyticsCollector;
    private com.google.android.exoplayer2.audio.AudioAttributes audioAttributes;
    private final java.util.concurrent.CopyOnWriteArraySet<com.google.android.exoplayer2.audio.AudioRendererEventListener> audioDebugListeners;
    private com.google.android.exoplayer2.decoder.DecoderCounters audioDecoderCounters;
    private final com.google.android.exoplayer2.audio.AudioFocusManager audioFocusManager;
    private com.google.android.exoplayer2.Format audioFormat;
    private final java.util.concurrent.CopyOnWriteArraySet<com.google.android.exoplayer2.audio.AudioListener> audioListeners;
    private int audioSessionId;
    private float audioVolume;
    private final com.google.android.exoplayer2.upstream.BandwidthMeter bandwidthMeter;
    private com.google.android.exoplayer2.video.spherical.CameraMotionListener cameraMotionListener;
    private final com.google.android.exoplayer2.SimpleExoPlayer.ComponentListener componentListener;
    private int curSeekId;
    private java.util.List<com.google.android.exoplayer2.text.Cue> currentCues;
    private final android.os.Handler eventHandler;
    private boolean hasNotifiedFullWrongThreadWarning;
    private boolean isEnablePreview;
    private boolean isSeeking;
    private com.google.android.exoplayer2.source.MediaSource mediaSource;
    private final java.util.concurrent.CopyOnWriteArraySet<com.google.android.exoplayer2.metadata.MetadataOutput> metadataOutputs;
    private boolean ownsSurface;
    private long pendingFastSeekTime;
    private boolean pendingPlayWhenReady;
    private boolean pendingPreviewFlag;
    private final com.google.android.exoplayer2.ExoPlayerImpl player;
    protected final com.google.android.exoplayer2.Renderer[] renderers;
    private java.lang.Runnable seekTimeoutRunnable;
    private long seekingTime;
    private android.view.Surface surface;
    private int surfaceHeight;
    private android.view.SurfaceHolder surfaceHolder;
    private int surfaceWidth;
    private final java.util.concurrent.CopyOnWriteArraySet<com.google.android.exoplayer2.text.TextOutput> textOutputs;
    private android.view.TextureView textureView;
    private final java.util.concurrent.CopyOnWriteArraySet<com.google.android.exoplayer2.video.VideoRendererEventListener> videoDebugListeners;
    private com.google.android.exoplayer2.decoder.DecoderCounters videoDecoderCounters;
    private com.google.android.exoplayer2.Format videoFormat;
    private com.google.android.exoplayer2.video.VideoFrameMetadataListener videoFrameMetadataListener;
    private final java.util.concurrent.CopyOnWriteArraySet<com.google.android.exoplayer2.video.VideoListener> videoListeners;
    private int videoScalingMode;

    @java.lang.Deprecated
    public interface VideoListener extends com.google.android.exoplayer2.video.VideoListener {
    }

    private void verifyApplicationThread() {
    }

    @Override // com.google.android.exoplayer2.Player
    public com.google.android.exoplayer2.Player.AudioComponent getAudioComponent() {
        return this;
    }

    @Override // com.google.android.exoplayer2.Player
    public com.google.android.exoplayer2.Player.MetadataComponent getMetadataComponent() {
        return this;
    }

    @Override // com.google.android.exoplayer2.Player
    public com.google.android.exoplayer2.Player.TextComponent getTextComponent() {
        return this;
    }

    @Override // com.google.android.exoplayer2.Player
    public com.google.android.exoplayer2.Player.VideoComponent getVideoComponent() {
        return this;
    }

    protected SimpleExoPlayer(android.content.Context context, com.google.android.exoplayer2.RenderersFactory renderersFactory, com.google.android.exoplayer2.trackselection.TrackSelector trackSelector, com.google.android.exoplayer2.LoadControl loadControl, com.google.android.exoplayer2.upstream.BandwidthMeter bandwidthMeter, com.google.android.exoplayer2.drm.DrmSessionManager<com.google.android.exoplayer2.drm.FrameworkMediaCrypto> drmSessionManager, android.os.Looper looper) {
        this(context, renderersFactory, trackSelector, loadControl, drmSessionManager, bandwidthMeter, new com.google.android.exoplayer2.analytics.AnalyticsCollector.Factory(), looper);
    }

    protected SimpleExoPlayer(android.content.Context context, com.google.android.exoplayer2.RenderersFactory renderersFactory, com.google.android.exoplayer2.trackselection.TrackSelector trackSelector, com.google.android.exoplayer2.LoadControl loadControl, com.google.android.exoplayer2.drm.DrmSessionManager<com.google.android.exoplayer2.drm.FrameworkMediaCrypto> drmSessionManager, com.google.android.exoplayer2.upstream.BandwidthMeter bandwidthMeter, com.google.android.exoplayer2.analytics.AnalyticsCollector.Factory factory, android.os.Looper looper) {
        this(context, renderersFactory, trackSelector, loadControl, drmSessionManager, bandwidthMeter, factory, com.google.android.exoplayer2.util.Clock.DEFAULT, looper);
    }

    protected SimpleExoPlayer(android.content.Context context, com.google.android.exoplayer2.RenderersFactory renderersFactory, com.google.android.exoplayer2.trackselection.TrackSelector trackSelector, com.google.android.exoplayer2.LoadControl loadControl, com.google.android.exoplayer2.drm.DrmSessionManager<com.google.android.exoplayer2.drm.FrameworkMediaCrypto> drmSessionManager, com.google.android.exoplayer2.upstream.BandwidthMeter bandwidthMeter, com.google.android.exoplayer2.analytics.AnalyticsCollector.Factory factory, com.google.android.exoplayer2.util.Clock clock, android.os.Looper looper) {
        this.bandwidthMeter = bandwidthMeter;
        this.componentListener = new com.google.android.exoplayer2.SimpleExoPlayer.ComponentListener();
        this.videoListeners = new java.util.concurrent.CopyOnWriteArraySet<>();
        this.audioListeners = new java.util.concurrent.CopyOnWriteArraySet<>();
        this.textOutputs = new java.util.concurrent.CopyOnWriteArraySet<>();
        this.metadataOutputs = new java.util.concurrent.CopyOnWriteArraySet<>();
        this.videoDebugListeners = new java.util.concurrent.CopyOnWriteArraySet<>();
        this.audioDebugListeners = new java.util.concurrent.CopyOnWriteArraySet<>();
        this.eventHandler = new android.os.Handler(looper);
        android.os.Handler handler = this.eventHandler;
        com.google.android.exoplayer2.SimpleExoPlayer.ComponentListener componentListener = this.componentListener;
        this.renderers = renderersFactory.createRenderers(handler, componentListener, componentListener, componentListener, componentListener, drmSessionManager);
        this.audioVolume = 1.0f;
        this.audioSessionId = 0;
        this.audioAttributes = com.google.android.exoplayer2.audio.AudioAttributes.DEFAULT;
        this.videoScalingMode = 1;
        this.currentCues = java.util.Collections.emptyList();
        this.player = new com.google.android.exoplayer2.ExoPlayerImpl(this.renderers, trackSelector, loadControl, bandwidthMeter, clock, looper);
        this.analyticsCollector = factory.createAnalyticsCollector(this.player, clock);
        addListener(this.analyticsCollector);
        this.videoDebugListeners.add(this.analyticsCollector);
        this.videoListeners.add(this.analyticsCollector);
        this.audioDebugListeners.add(this.analyticsCollector);
        this.audioListeners.add(this.analyticsCollector);
        addMetadataOutput(this.analyticsCollector);
        this.analyticsCollector.addListener(this);
        bandwidthMeter.addEventListener(this.eventHandler, this.analyticsCollector);
        if (drmSessionManager instanceof com.google.android.exoplayer2.drm.DefaultDrmSessionManager) {
            ((com.google.android.exoplayer2.drm.DefaultDrmSessionManager) drmSessionManager).addListener(this.eventHandler, this.analyticsCollector);
        }
        this.audioFocusManager = new com.google.android.exoplayer2.audio.AudioFocusManager(context, this.componentListener);
        this.isSeeking = false;
        this.seekingTime = -9223372036854775807L;
        this.curSeekId = -1;
        this.pendingFastSeekTime = -9223372036854775807L;
        this.pendingPreviewFlag = false;
        this.isEnablePreview = false;
        this.seekTimeoutRunnable = new java.lang.Runnable() { // from class: com.google.android.exoplayer2.-$$Lambda$SimpleExoPlayer$FUDpW55P-lP_M185TOjrXOlXMXI
            @Override // java.lang.Runnable
            public final void run() {
                this.f_renamed$0.lambda$new$0$SimpleExoPlayer();
            }
        };
    }

    public /* synthetic */ void lambda$new$0$SimpleExoPlayer() {
        onSeekCompleted(this.curSeekId, 1);
    }

    @Override // com.google.android.exoplayer2.Player.VideoComponent
    public void setVideoScalingMode(int i_renamed) {
        verifyApplicationThread();
        this.videoScalingMode = i_renamed;
        for (com.google.android.exoplayer2.Renderer renderer : this.renderers) {
            if (renderer.getTrackType() == 2) {
                this.player.createMessage(renderer).setType(4).setPayload(java.lang.Integer.valueOf(i_renamed)).send();
            }
        }
    }

    @Override // com.google.android.exoplayer2.Player.VideoComponent
    public int getVideoScalingMode() {
        return this.videoScalingMode;
    }

    @Override // com.google.android.exoplayer2.Player.VideoComponent
    public void clearVideoSurface() {
        verifyApplicationThread();
        setVideoSurface(null);
    }

    @Override // com.google.android.exoplayer2.Player.VideoComponent
    public void clearVideoSurface(android.view.Surface surface) {
        verifyApplicationThread();
        if (surface == null || surface != this.surface) {
            return;
        }
        setVideoSurface(null);
    }

    @Override // com.google.android.exoplayer2.Player.VideoComponent
    public void setVideoSurface(android.view.Surface surface) {
        verifyApplicationThread();
        removeSurfaceCallbacks();
        setVideoSurfaceInternal(surface, false);
        int i_renamed = surface != null ? -1 : 0;
        maybeNotifySurfaceSizeChanged(i_renamed, i_renamed);
    }

    @Override // com.google.android.exoplayer2.Player.VideoComponent
    public void setVideoSurfaceHolder(android.view.SurfaceHolder surfaceHolder) {
        verifyApplicationThread();
        removeSurfaceCallbacks();
        this.surfaceHolder = surfaceHolder;
        if (surfaceHolder == null) {
            setVideoSurfaceInternal(null, false);
            maybeNotifySurfaceSizeChanged(0, 0);
            return;
        }
        surfaceHolder.addCallback(this.componentListener);
        android.view.Surface surface = surfaceHolder.getSurface();
        if (surface != null && surface.isValid()) {
            setVideoSurfaceInternal(surface, false);
            android.graphics.Rect surfaceFrame = surfaceHolder.getSurfaceFrame();
            maybeNotifySurfaceSizeChanged(surfaceFrame.width(), surfaceFrame.height());
        } else {
            setVideoSurfaceInternal(null, false);
            maybeNotifySurfaceSizeChanged(0, 0);
        }
    }

    @Override // com.google.android.exoplayer2.Player.VideoComponent
    public void clearVideoSurfaceHolder(android.view.SurfaceHolder surfaceHolder) {
        verifyApplicationThread();
        if (surfaceHolder == null || surfaceHolder != this.surfaceHolder) {
            return;
        }
        setVideoSurfaceHolder(null);
    }

    @Override // com.google.android.exoplayer2.Player.VideoComponent
    public void setVideoSurfaceView(android.view.SurfaceView surfaceView) {
        setVideoSurfaceHolder(surfaceView == null ? null : surfaceView.getHolder());
    }

    @Override // com.google.android.exoplayer2.Player.VideoComponent
    public void clearVideoSurfaceView(android.view.SurfaceView surfaceView) {
        clearVideoSurfaceHolder(surfaceView == null ? null : surfaceView.getHolder());
    }

    @Override // com.google.android.exoplayer2.Player.VideoComponent
    public void setVideoTextureView(android.view.TextureView textureView) {
        verifyApplicationThread();
        removeSurfaceCallbacks();
        this.textureView = textureView;
        if (textureView == null) {
            setVideoSurfaceInternal(null, true);
            maybeNotifySurfaceSizeChanged(0, 0);
            return;
        }
        if (textureView.getSurfaceTextureListener() != null) {
            com.google.android.exoplayer2.util.Log.w_renamed(TAG, "Replacing existing SurfaceTextureListener.");
        }
        textureView.setSurfaceTextureListener(this.componentListener);
        android.graphics.SurfaceTexture surfaceTexture = textureView.isAvailable() ? textureView.getSurfaceTexture() : null;
        if (surfaceTexture == null) {
            setVideoSurfaceInternal(null, true);
            maybeNotifySurfaceSizeChanged(0, 0);
        } else {
            setVideoSurfaceInternal(new android.view.Surface(surfaceTexture), true);
            maybeNotifySurfaceSizeChanged(textureView.getWidth(), textureView.getHeight());
        }
    }

    @Override // com.google.android.exoplayer2.Player.VideoComponent
    public void clearVideoTextureView(android.view.TextureView textureView) {
        verifyApplicationThread();
        if (textureView == null || textureView != this.textureView) {
            return;
        }
        setVideoTextureView(null);
    }

    @Override // com.google.android.exoplayer2.Player.AudioComponent
    public void addAudioListener(com.google.android.exoplayer2.audio.AudioListener audioListener) {
        this.audioListeners.add(audioListener);
    }

    @Override // com.google.android.exoplayer2.Player.AudioComponent
    public void removeAudioListener(com.google.android.exoplayer2.audio.AudioListener audioListener) {
        this.audioListeners.remove(audioListener);
    }

    @Override // com.google.android.exoplayer2.Player.AudioComponent
    public void setAudioAttributes(com.google.android.exoplayer2.audio.AudioAttributes audioAttributes) {
        setAudioAttributes(audioAttributes, false);
    }

    @Override // com.google.android.exoplayer2.Player.AudioComponent
    public void setAudioAttributes(com.google.android.exoplayer2.audio.AudioAttributes audioAttributes, boolean z_renamed) {
        verifyApplicationThread();
        if (!com.google.android.exoplayer2.util.Util.areEqual(this.audioAttributes, audioAttributes)) {
            this.audioAttributes = audioAttributes;
            for (com.google.android.exoplayer2.Renderer renderer : this.renderers) {
                if (renderer.getTrackType() == 1) {
                    this.player.createMessage(renderer).setType(3).setPayload(audioAttributes).send();
                }
            }
            java.util.Iterator<com.google.android.exoplayer2.audio.AudioListener> it = this.audioListeners.iterator();
            while (it.hasNext()) {
                it.next().onAudioAttributesChanged(audioAttributes);
            }
        }
        com.google.android.exoplayer2.audio.AudioFocusManager audioFocusManager = this.audioFocusManager;
        if (!z_renamed) {
            audioAttributes = null;
        }
        updatePlayWhenReady(getPlayWhenReady(), audioFocusManager.setAudioAttributes(audioAttributes, getPlayWhenReady(), getPlaybackState()));
    }

    @Override // com.google.android.exoplayer2.Player.AudioComponent
    public com.google.android.exoplayer2.audio.AudioAttributes getAudioAttributes() {
        return this.audioAttributes;
    }

    @Override // com.google.android.exoplayer2.Player.AudioComponent
    public int getAudioSessionId() {
        return this.audioSessionId;
    }

    @Override // com.google.android.exoplayer2.Player.AudioComponent
    public void setAuxEffectInfo(com.google.android.exoplayer2.audio.AuxEffectInfo auxEffectInfo) {
        verifyApplicationThread();
        for (com.google.android.exoplayer2.Renderer renderer : this.renderers) {
            if (renderer.getTrackType() == 1) {
                this.player.createMessage(renderer).setType(5).setPayload(auxEffectInfo).send();
            }
        }
    }

    @Override // com.google.android.exoplayer2.Player.AudioComponent
    public void clearAuxEffectInfo() {
        setAuxEffectInfo(new com.google.android.exoplayer2.audio.AuxEffectInfo(0, 0.0f));
    }

    @Override // com.google.android.exoplayer2.Player.AudioComponent
    public void setVolume(float f_renamed) {
        verifyApplicationThread();
        float fConstrainValue = com.google.android.exoplayer2.util.Util.constrainValue(f_renamed, 0.0f, 1.0f);
        if (this.audioVolume == fConstrainValue) {
            return;
        }
        this.audioVolume = fConstrainValue;
        sendVolumeToRenderers();
        java.util.Iterator<com.google.android.exoplayer2.audio.AudioListener> it = this.audioListeners.iterator();
        while (it.hasNext()) {
            it.next().onVolumeChanged(fConstrainValue);
        }
    }

    @Override // com.google.android.exoplayer2.Player.AudioComponent
    public float getVolume() {
        return this.audioVolume;
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onSeekCompleted(int i_renamed, int i2) {
        com.google.android.exoplayer2.util.Log.d_renamed(TAG, "onSeekCompleted, id_renamed:" + i_renamed + ", success:" + i2 + ",curSeekId:" + this.curSeekId + ", isSeeking:" + this.isSeeking);
        if (this.isSeeking && i_renamed == this.curSeekId) {
            this.isSeeking = false;
        }
    }

    @Override // com.google.android.exoplayer2.Player
    public void fastSeekTo(int i_renamed, long j_renamed, boolean z_renamed) {
        if (j_renamed < 0) {
            com.google.android.exoplayer2.util.Log.e_renamed(TAG, "fastSeekTo with invalid positionMs:" + j_renamed);
            return;
        }
        com.google.android.exoplayer2.util.Log.d_renamed(TAG, "fastSeekTo:" + j_renamed + ", enablePreview:" + z_renamed + ",isSeeking:" + this.isSeeking + ",isEnablePreview:" + this.isEnablePreview);
        if (z_renamed) {
            if (!this.isEnablePreview) {
                this.pendingPlayWhenReady = getPlayWhenReady();
                setPlayWhenReady(false);
                this.isEnablePreview = true;
            }
        } else if (this.isEnablePreview) {
            this.isEnablePreview = false;
            setPlayWhenReady(this.pendingPlayWhenReady);
        }
        seekToInternal(i_renamed, j_renamed, z_renamed ? 1 : 2);
    }

    public void setVsyncOffsetPercentage(int i_renamed) {
        verifyApplicationThread();
        for (com.google.android.exoplayer2.Renderer renderer : this.renderers) {
            if (renderer.getTrackType() == 2) {
                this.player.createMessage(renderer).setType(10).setPayload(java.lang.Integer.valueOf(i_renamed)).send();
            }
        }
    }

    public void setMediaFormatAttr(java.util.HashMap<java.lang.String, java.lang.Integer> map) {
        verifyApplicationThread();
        for (com.google.android.exoplayer2.Renderer renderer : this.renderers) {
            if (renderer.getTrackType() == 2) {
                this.player.createMessage(renderer).setType(11).setPayload(map).send();
            }
        }
    }

    public void setDropFramePolicy(int i_renamed) {
        verifyApplicationThread();
        for (com.google.android.exoplayer2.Renderer renderer : this.renderers) {
            if (renderer.getTrackType() == 2) {
                this.player.createMessage(renderer).setType(12).setPayload(java.lang.Integer.valueOf(i_renamed)).send();
            }
        }
    }

    @java.lang.Deprecated
    public void setAudioStreamType(int i_renamed) {
        int audioUsageForStreamType = com.google.android.exoplayer2.util.Util.getAudioUsageForStreamType(i_renamed);
        setAudioAttributes(new com.google.android.exoplayer2.audio.AudioAttributes.Builder().setUsage(audioUsageForStreamType).setContentType(com.google.android.exoplayer2.util.Util.getAudioContentTypeForStreamType(i_renamed)).build());
    }

    @java.lang.Deprecated
    public int getAudioStreamType() {
        return com.google.android.exoplayer2.util.Util.getStreamTypeForAudioUsage(this.audioAttributes.usage);
    }

    public com.google.android.exoplayer2.analytics.AnalyticsCollector getAnalyticsCollector() {
        return this.analyticsCollector;
    }

    public void addAnalyticsListener(com.google.android.exoplayer2.analytics.AnalyticsListener analyticsListener) {
        verifyApplicationThread();
        this.analyticsCollector.addListener(analyticsListener);
    }

    public void removeAnalyticsListener(com.google.android.exoplayer2.analytics.AnalyticsListener analyticsListener) {
        verifyApplicationThread();
        this.analyticsCollector.removeListener(analyticsListener);
    }

    @android.annotation.TargetApi(23)
    @java.lang.Deprecated
    public void setPlaybackParams(android.media.PlaybackParams playbackParams) {
        com.google.android.exoplayer2.PlaybackParameters playbackParameters;
        if (playbackParams != null) {
            playbackParams.allowDefaults();
            playbackParameters = new com.google.android.exoplayer2.PlaybackParameters(playbackParams.getSpeed(), playbackParams.getPitch());
        } else {
            playbackParameters = null;
        }
        setPlaybackParameters(playbackParameters);
    }

    public com.google.android.exoplayer2.Format getVideoFormat() {
        return this.videoFormat;
    }

    public com.google.android.exoplayer2.Format getAudioFormat() {
        return this.audioFormat;
    }

    public com.google.android.exoplayer2.decoder.DecoderCounters getVideoDecoderCounters() {
        return this.videoDecoderCounters;
    }

    public com.google.android.exoplayer2.decoder.DecoderCounters getAudioDecoderCounters() {
        return this.audioDecoderCounters;
    }

    @Override // com.google.android.exoplayer2.Player.VideoComponent
    public void addVideoListener(com.google.android.exoplayer2.video.VideoListener videoListener) {
        this.videoListeners.add(videoListener);
    }

    @Override // com.google.android.exoplayer2.Player.VideoComponent
    public void removeVideoListener(com.google.android.exoplayer2.video.VideoListener videoListener) {
        this.videoListeners.remove(videoListener);
    }

    @Override // com.google.android.exoplayer2.Player.VideoComponent
    public void setVideoFrameMetadataListener(com.google.android.exoplayer2.video.VideoFrameMetadataListener videoFrameMetadataListener) {
        verifyApplicationThread();
        this.videoFrameMetadataListener = videoFrameMetadataListener;
        for (com.google.android.exoplayer2.Renderer renderer : this.renderers) {
            if (renderer.getTrackType() == 2) {
                this.player.createMessage(renderer).setType(6).setPayload(videoFrameMetadataListener).send();
            }
        }
    }

    @Override // com.google.android.exoplayer2.Player.VideoComponent
    public void clearVideoFrameMetadataListener(com.google.android.exoplayer2.video.VideoFrameMetadataListener videoFrameMetadataListener) {
        verifyApplicationThread();
        if (this.videoFrameMetadataListener != videoFrameMetadataListener) {
            return;
        }
        for (com.google.android.exoplayer2.Renderer renderer : this.renderers) {
            if (renderer.getTrackType() == 2) {
                this.player.createMessage(renderer).setType(6).setPayload(null).send();
            }
        }
    }

    @Override // com.google.android.exoplayer2.Player.VideoComponent
    public void setCameraMotionListener(com.google.android.exoplayer2.video.spherical.CameraMotionListener cameraMotionListener) {
        verifyApplicationThread();
        this.cameraMotionListener = cameraMotionListener;
        for (com.google.android.exoplayer2.Renderer renderer : this.renderers) {
            if (renderer.getTrackType() == 5) {
                this.player.createMessage(renderer).setType(7).setPayload(cameraMotionListener).send();
            }
        }
    }

    @Override // com.google.android.exoplayer2.Player.VideoComponent
    public void clearCameraMotionListener(com.google.android.exoplayer2.video.spherical.CameraMotionListener cameraMotionListener) {
        verifyApplicationThread();
        if (this.cameraMotionListener != cameraMotionListener) {
            return;
        }
        for (com.google.android.exoplayer2.Renderer renderer : this.renderers) {
            if (renderer.getTrackType() == 5) {
                this.player.createMessage(renderer).setType(7).setPayload(null).send();
            }
        }
    }

    @java.lang.Deprecated
    public void setVideoListener(com.google.android.exoplayer2.SimpleExoPlayer.VideoListener videoListener) {
        this.videoListeners.clear();
        if (videoListener != null) {
            addVideoListener(videoListener);
        }
    }

    @java.lang.Deprecated
    public void clearVideoListener(com.google.android.exoplayer2.SimpleExoPlayer.VideoListener videoListener) {
        removeVideoListener(videoListener);
    }

    @Override // com.google.android.exoplayer2.Player.TextComponent
    public void addTextOutput(com.google.android.exoplayer2.text.TextOutput textOutput) {
        if (!this.currentCues.isEmpty()) {
            textOutput.onCues(this.currentCues);
        }
        this.textOutputs.add(textOutput);
    }

    @Override // com.google.android.exoplayer2.Player.TextComponent
    public void removeTextOutput(com.google.android.exoplayer2.text.TextOutput textOutput) {
        this.textOutputs.remove(textOutput);
    }

    @java.lang.Deprecated
    public void setTextOutput(com.google.android.exoplayer2.text.TextOutput textOutput) {
        this.textOutputs.clear();
        if (textOutput != null) {
            addTextOutput(textOutput);
        }
    }

    @java.lang.Deprecated
    public void clearTextOutput(com.google.android.exoplayer2.text.TextOutput textOutput) {
        removeTextOutput(textOutput);
    }

    @Override // com.google.android.exoplayer2.Player.MetadataComponent
    public void addMetadataOutput(com.google.android.exoplayer2.metadata.MetadataOutput metadataOutput) {
        this.metadataOutputs.add(metadataOutput);
    }

    @Override // com.google.android.exoplayer2.Player.MetadataComponent
    public void removeMetadataOutput(com.google.android.exoplayer2.metadata.MetadataOutput metadataOutput) {
        this.metadataOutputs.remove(metadataOutput);
    }

    @java.lang.Deprecated
    public void setMetadataOutput(com.google.android.exoplayer2.metadata.MetadataOutput metadataOutput) {
        this.metadataOutputs.retainAll(java.util.Collections.singleton(this.analyticsCollector));
        if (metadataOutput != null) {
            addMetadataOutput(metadataOutput);
        }
    }

    @java.lang.Deprecated
    public void clearMetadataOutput(com.google.android.exoplayer2.metadata.MetadataOutput metadataOutput) {
        removeMetadataOutput(metadataOutput);
    }

    @java.lang.Deprecated
    public void setVideoDebugListener(com.google.android.exoplayer2.video.VideoRendererEventListener videoRendererEventListener) {
        this.videoDebugListeners.retainAll(java.util.Collections.singleton(this.analyticsCollector));
        if (videoRendererEventListener != null) {
            addVideoDebugListener(videoRendererEventListener);
        }
    }

    @java.lang.Deprecated
    public void addVideoDebugListener(com.google.android.exoplayer2.video.VideoRendererEventListener videoRendererEventListener) {
        this.videoDebugListeners.add(videoRendererEventListener);
    }

    @java.lang.Deprecated
    public void removeVideoDebugListener(com.google.android.exoplayer2.video.VideoRendererEventListener videoRendererEventListener) {
        this.videoDebugListeners.remove(videoRendererEventListener);
    }

    @java.lang.Deprecated
    public void setAudioDebugListener(com.google.android.exoplayer2.audio.AudioRendererEventListener audioRendererEventListener) {
        this.audioDebugListeners.retainAll(java.util.Collections.singleton(this.analyticsCollector));
        if (audioRendererEventListener != null) {
            addAudioDebugListener(audioRendererEventListener);
        }
    }

    @java.lang.Deprecated
    public void addAudioDebugListener(com.google.android.exoplayer2.audio.AudioRendererEventListener audioRendererEventListener) {
        this.audioDebugListeners.add(audioRendererEventListener);
    }

    @java.lang.Deprecated
    public void removeAudioDebugListener(com.google.android.exoplayer2.audio.AudioRendererEventListener audioRendererEventListener) {
        this.audioDebugListeners.remove(audioRendererEventListener);
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public android.os.Looper getPlaybackLooper() {
        return this.player.getPlaybackLooper();
    }

    @Override // com.google.android.exoplayer2.Player
    public android.os.Looper getApplicationLooper() {
        return this.player.getApplicationLooper();
    }

    @Override // com.google.android.exoplayer2.Player
    public void addListener(com.google.android.exoplayer2.Player.EventListener eventListener) {
        verifyApplicationThread();
        this.player.addListener(eventListener);
    }

    @Override // com.google.android.exoplayer2.Player
    public void removeListener(com.google.android.exoplayer2.Player.EventListener eventListener) {
        verifyApplicationThread();
        this.player.removeListener(eventListener);
    }

    @Override // com.google.android.exoplayer2.Player
    public int getPlaybackState() {
        verifyApplicationThread();
        return this.player.getPlaybackState();
    }

    @Override // com.google.android.exoplayer2.Player
    public com.google.android.exoplayer2.ExoPlaybackException getPlaybackError() {
        verifyApplicationThread();
        return this.player.getPlaybackError();
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public void retry() {
        verifyApplicationThread();
        if (this.mediaSource != null) {
            if (getPlaybackError() != null || getPlaybackState() == 1) {
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
        verifyApplicationThread();
        com.google.android.exoplayer2.source.MediaSource mediaSource2 = this.mediaSource;
        if (mediaSource2 != null) {
            mediaSource2.removeEventListener(this.analyticsCollector);
            this.analyticsCollector.resetForNewMediaSource();
        }
        this.mediaSource = mediaSource;
        mediaSource.addEventListener(this.eventHandler, this.analyticsCollector);
        updatePlayWhenReady(getPlayWhenReady(), this.audioFocusManager.handlePrepare(getPlayWhenReady()));
        this.player.prepare(mediaSource, z_renamed, z2);
    }

    @Override // com.google.android.exoplayer2.Player
    public void setPlayWhenReady(boolean z_renamed) {
        verifyApplicationThread();
        updatePlayWhenReady(z_renamed, this.audioFocusManager.handleSetPlayWhenReady(z_renamed, getPlaybackState()));
    }

    @Override // com.google.android.exoplayer2.Player
    public boolean getPlayWhenReady() {
        verifyApplicationThread();
        return this.player.getPlayWhenReady();
    }

    @Override // com.google.android.exoplayer2.Player
    public int getRepeatMode() {
        verifyApplicationThread();
        return this.player.getRepeatMode();
    }

    @Override // com.google.android.exoplayer2.Player
    public void setRepeatMode(int i_renamed) {
        verifyApplicationThread();
        this.player.setRepeatMode(i_renamed);
    }

    @Override // com.google.android.exoplayer2.Player
    public void setShuffleModeEnabled(boolean z_renamed) {
        verifyApplicationThread();
        this.player.setShuffleModeEnabled(z_renamed);
    }

    @Override // com.google.android.exoplayer2.Player
    public boolean getShuffleModeEnabled() {
        verifyApplicationThread();
        return this.player.getShuffleModeEnabled();
    }

    @Override // com.google.android.exoplayer2.Player
    public boolean isLoading() {
        verifyApplicationThread();
        return this.player.isLoading();
    }

    private void seekToInternal(int i_renamed, long j_renamed, int i2) {
        this.isSeeking = true;
        this.seekingTime = j_renamed;
        int i3 = this.curSeekId + 1;
        this.curSeekId = i3;
        if (i3 > 10000) {
            this.curSeekId = 0;
        }
        com.google.android.exoplayer2.util.Log.d_renamed(TAG, "SeekToInternal curSeekId:" + this.curSeekId);
        this.player.setSeekIdAndType(this.curSeekId, i2);
        verifyApplicationThread();
        this.analyticsCollector.notifySeekStarted();
        this.player.seekTo(i_renamed, j_renamed);
    }

    @Override // com.google.android.exoplayer2.Player
    public void seekTo(int i_renamed, long j_renamed) {
        if (j_renamed < 0) {
            com.google.android.exoplayer2.util.Log.e_renamed(TAG, "seekTo with invalid positionMs:" + j_renamed);
            return;
        }
        seekToInternal(i_renamed, j_renamed, 0);
    }

    @Override // com.google.android.exoplayer2.Player
    public void setPlaybackParameters(com.google.android.exoplayer2.PlaybackParameters playbackParameters) {
        verifyApplicationThread();
        this.player.setPlaybackParameters(playbackParameters);
    }

    @Override // com.google.android.exoplayer2.Player
    public com.google.android.exoplayer2.PlaybackParameters getPlaybackParameters() {
        verifyApplicationThread();
        return this.player.getPlaybackParameters();
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public void setSeekParameters(com.google.android.exoplayer2.SeekParameters seekParameters) {
        verifyApplicationThread();
        this.player.setSeekParameters(seekParameters);
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public com.google.android.exoplayer2.SeekParameters getSeekParameters() {
        verifyApplicationThread();
        return this.player.getSeekParameters();
    }

    @Override // com.google.android.exoplayer2.Player
    public void stop(boolean z_renamed) {
        verifyApplicationThread();
        this.player.stop(z_renamed);
        com.google.android.exoplayer2.source.MediaSource mediaSource = this.mediaSource;
        if (mediaSource != null) {
            mediaSource.removeEventListener(this.analyticsCollector);
            this.analyticsCollector.resetForNewMediaSource();
            if (z_renamed) {
                this.mediaSource = null;
            }
        }
        this.audioFocusManager.handleStop();
        this.currentCues = java.util.Collections.emptyList();
    }

    @Override // com.google.android.exoplayer2.Player
    public void release() {
        this.audioFocusManager.handleStop();
        this.player.release();
        removeSurfaceCallbacks();
        android.view.Surface surface = this.surface;
        if (surface != null) {
            if (this.ownsSurface) {
                surface.release();
            }
            this.surface = null;
        }
        com.google.android.exoplayer2.source.MediaSource mediaSource = this.mediaSource;
        if (mediaSource != null) {
            mediaSource.removeEventListener(this.analyticsCollector);
            this.mediaSource = null;
        }
        this.bandwidthMeter.removeEventListener(this.analyticsCollector);
        this.currentCues = java.util.Collections.emptyList();
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    @java.lang.Deprecated
    public void sendMessages(com.google.android.exoplayer2.ExoPlayer.ExoPlayerMessage... exoPlayerMessageArr) {
        this.player.sendMessages(exoPlayerMessageArr);
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public com.google.android.exoplayer2.PlayerMessage createMessage(com.google.android.exoplayer2.PlayerMessage.Target target) {
        verifyApplicationThread();
        return this.player.createMessage(target);
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    @java.lang.Deprecated
    public void blockingSendMessages(com.google.android.exoplayer2.ExoPlayer.ExoPlayerMessage... exoPlayerMessageArr) {
        this.player.blockingSendMessages(exoPlayerMessageArr);
    }

    @Override // com.google.android.exoplayer2.Player
    public int getRendererCount() {
        verifyApplicationThread();
        return this.player.getRendererCount();
    }

    @Override // com.google.android.exoplayer2.Player
    public int getRendererType(int i_renamed) {
        verifyApplicationThread();
        return this.player.getRendererType(i_renamed);
    }

    @Override // com.google.android.exoplayer2.Player
    public com.google.android.exoplayer2.source.TrackGroupArray getCurrentTrackGroups() {
        verifyApplicationThread();
        return this.player.getCurrentTrackGroups();
    }

    @Override // com.google.android.exoplayer2.Player
    public com.google.android.exoplayer2.trackselection.TrackSelectionArray getCurrentTrackSelections() {
        verifyApplicationThread();
        return this.player.getCurrentTrackSelections();
    }

    @Override // com.google.android.exoplayer2.Player
    public com.google.android.exoplayer2.Timeline getCurrentTimeline() {
        verifyApplicationThread();
        return this.player.getCurrentTimeline();
    }

    @Override // com.google.android.exoplayer2.Player
    public java.lang.Object getCurrentManifest() {
        verifyApplicationThread();
        return this.player.getCurrentManifest();
    }

    @Override // com.google.android.exoplayer2.Player
    public int getCurrentPeriodIndex() {
        verifyApplicationThread();
        return this.player.getCurrentPeriodIndex();
    }

    @Override // com.google.android.exoplayer2.Player
    public int getCurrentWindowIndex() {
        verifyApplicationThread();
        return this.player.getCurrentWindowIndex();
    }

    @Override // com.google.android.exoplayer2.Player
    public long getDuration() {
        verifyApplicationThread();
        return this.player.getDuration();
    }

    @Override // com.google.android.exoplayer2.Player
    public long getCurrentPosition() {
        verifyApplicationThread();
        if (this.isSeeking) {
            com.google.android.exoplayer2.util.Log.d_renamed(TAG, "return seekingTime:" + this.seekingTime);
            return this.seekingTime;
        }
        return this.player.getCurrentPosition();
    }

    @Override // com.google.android.exoplayer2.Player
    public long getBufferedPosition() {
        verifyApplicationThread();
        return this.player.getBufferedPosition();
    }

    @Override // com.google.android.exoplayer2.Player
    public long getTotalBufferedDuration() {
        verifyApplicationThread();
        return this.player.getTotalBufferedDuration();
    }

    @Override // com.google.android.exoplayer2.Player
    public boolean isPlayingAd() {
        verifyApplicationThread();
        return this.player.isPlayingAd();
    }

    @Override // com.google.android.exoplayer2.Player
    public int getCurrentAdGroupIndex() {
        verifyApplicationThread();
        return this.player.getCurrentAdGroupIndex();
    }

    @Override // com.google.android.exoplayer2.Player
    public int getCurrentAdIndexInAdGroup() {
        verifyApplicationThread();
        return this.player.getCurrentAdIndexInAdGroup();
    }

    @Override // com.google.android.exoplayer2.Player
    public long getContentPosition() {
        verifyApplicationThread();
        return this.player.getContentPosition();
    }

    @Override // com.google.android.exoplayer2.Player
    public long getContentBufferedPosition() {
        verifyApplicationThread();
        return this.player.getContentBufferedPosition();
    }

    private void removeSurfaceCallbacks() {
        android.view.TextureView textureView = this.textureView;
        if (textureView != null) {
            if (textureView.getSurfaceTextureListener() != this.componentListener) {
                com.google.android.exoplayer2.util.Log.w_renamed(TAG, "SurfaceTextureListener already unset or replaced.");
            } else {
                this.textureView.setSurfaceTextureListener(null);
            }
            this.textureView = null;
        }
        android.view.SurfaceHolder surfaceHolder = this.surfaceHolder;
        if (surfaceHolder != null) {
            surfaceHolder.removeCallback(this.componentListener);
            this.surfaceHolder = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setVideoSurfaceInternal(android.view.Surface surface, boolean z_renamed) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        for (com.google.android.exoplayer2.Renderer renderer : this.renderers) {
            if (renderer.getTrackType() == 2) {
                arrayList.add(this.player.createMessage(renderer).setType(1).setPayload(surface).send());
            }
        }
        android.view.Surface surface2 = this.surface;
        if (surface2 != null && surface2 != surface) {
            try {
                java.util.Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ((com.google.android.exoplayer2.PlayerMessage) it.next()).blockUntilDelivered();
                }
            } catch (java.lang.InterruptedException unused) {
                java.lang.Thread.currentThread().interrupt();
            }
            if (this.ownsSurface) {
                this.surface.release();
            }
        }
        this.surface = surface;
        this.ownsSurface = z_renamed;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void maybeNotifySurfaceSizeChanged(int i_renamed, int i2) {
        if (i_renamed == this.surfaceWidth && i2 == this.surfaceHeight) {
            return;
        }
        this.surfaceWidth = i_renamed;
        this.surfaceHeight = i2;
        java.util.Iterator<com.google.android.exoplayer2.video.VideoListener> it = this.videoListeners.iterator();
        while (it.hasNext()) {
            it.next().onSurfaceSizeChanged(i_renamed, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendVolumeToRenderers() {
        float volumeMultiplier = this.audioVolume * this.audioFocusManager.getVolumeMultiplier();
        for (com.google.android.exoplayer2.Renderer renderer : this.renderers) {
            if (renderer.getTrackType() == 1) {
                this.player.createMessage(renderer).setType(2).setPayload(java.lang.Float.valueOf(volumeMultiplier)).send();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updatePlayWhenReady(boolean z_renamed, int i_renamed) {
        if (this.isEnablePreview) {
            this.pendingPlayWhenReady = z_renamed;
        } else {
            this.player.setPlayWhenReady(z_renamed && i_renamed != -1, i_renamed != 1);
        }
    }

    private final class ComponentListener implements android.view.SurfaceHolder.Callback, android.view.TextureView.SurfaceTextureListener, com.google.android.exoplayer2.audio.AudioFocusManager.PlayerControl, com.google.android.exoplayer2.audio.AudioRendererEventListener, com.google.android.exoplayer2.metadata.MetadataOutput, com.google.android.exoplayer2.text.TextOutput, com.google.android.exoplayer2.video.VideoRendererEventListener {
        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureUpdated(android.graphics.SurfaceTexture surfaceTexture) {
        }

        private ComponentListener() {
        }

        @Override // com.google.android.exoplayer2.video.VideoRendererEventListener
        public void onVideoEnabled(com.google.android.exoplayer2.decoder.DecoderCounters decoderCounters) {
            com.google.android.exoplayer2.SimpleExoPlayer.this.videoDecoderCounters = decoderCounters;
            java.util.Iterator it = com.google.android.exoplayer2.SimpleExoPlayer.this.videoDebugListeners.iterator();
            while (it.hasNext()) {
                ((com.google.android.exoplayer2.video.VideoRendererEventListener) it.next()).onVideoEnabled(decoderCounters);
            }
        }

        @Override // com.google.android.exoplayer2.video.VideoRendererEventListener
        public void onVideoDecoderInitialized(java.lang.String str, long j_renamed, long j2) {
            java.util.Iterator it = com.google.android.exoplayer2.SimpleExoPlayer.this.videoDebugListeners.iterator();
            while (it.hasNext()) {
                ((com.google.android.exoplayer2.video.VideoRendererEventListener) it.next()).onVideoDecoderInitialized(str, j_renamed, j2);
            }
        }

        @Override // com.google.android.exoplayer2.video.VideoRendererEventListener
        public void onVideoInputFormatChanged(com.google.android.exoplayer2.Format format) {
            com.google.android.exoplayer2.SimpleExoPlayer.this.videoFormat = format;
            java.util.Iterator it = com.google.android.exoplayer2.SimpleExoPlayer.this.videoDebugListeners.iterator();
            while (it.hasNext()) {
                ((com.google.android.exoplayer2.video.VideoRendererEventListener) it.next()).onVideoInputFormatChanged(format);
            }
        }

        @Override // com.google.android.exoplayer2.video.VideoRendererEventListener
        public void onDroppedFrames(int i_renamed, long j_renamed) {
            java.util.Iterator it = com.google.android.exoplayer2.SimpleExoPlayer.this.videoDebugListeners.iterator();
            while (it.hasNext()) {
                ((com.google.android.exoplayer2.video.VideoRendererEventListener) it.next()).onDroppedFrames(i_renamed, j_renamed);
            }
        }

        @Override // com.google.android.exoplayer2.video.VideoRendererEventListener
        public void onVideoSizeChanged(int i_renamed, int i2, int i3, float f_renamed) {
            java.util.Iterator it = com.google.android.exoplayer2.SimpleExoPlayer.this.videoListeners.iterator();
            while (it.hasNext()) {
                com.google.android.exoplayer2.video.VideoListener videoListener = (com.google.android.exoplayer2.video.VideoListener) it.next();
                if (!com.google.android.exoplayer2.SimpleExoPlayer.this.videoDebugListeners.contains(videoListener)) {
                    videoListener.onVideoSizeChanged(i_renamed, i2, i3, f_renamed);
                }
            }
            java.util.Iterator it2 = com.google.android.exoplayer2.SimpleExoPlayer.this.videoDebugListeners.iterator();
            while (it2.hasNext()) {
                ((com.google.android.exoplayer2.video.VideoRendererEventListener) it2.next()).onVideoSizeChanged(i_renamed, i2, i3, f_renamed);
            }
        }

        @Override // com.google.android.exoplayer2.video.VideoRendererEventListener
        public void onRenderedFirstFrame(android.view.Surface surface) {
            if (com.google.android.exoplayer2.SimpleExoPlayer.this.surface == surface) {
                java.util.Iterator it = com.google.android.exoplayer2.SimpleExoPlayer.this.videoListeners.iterator();
                while (it.hasNext()) {
                    ((com.google.android.exoplayer2.video.VideoListener) it.next()).onRenderedFirstFrame();
                }
            }
            java.util.Iterator it2 = com.google.android.exoplayer2.SimpleExoPlayer.this.videoDebugListeners.iterator();
            while (it2.hasNext()) {
                ((com.google.android.exoplayer2.video.VideoRendererEventListener) it2.next()).onRenderedFirstFrame(surface);
            }
        }

        @Override // com.google.android.exoplayer2.video.VideoRendererEventListener
        public void onVideoDisabled(com.google.android.exoplayer2.decoder.DecoderCounters decoderCounters) {
            java.util.Iterator it = com.google.android.exoplayer2.SimpleExoPlayer.this.videoDebugListeners.iterator();
            while (it.hasNext()) {
                ((com.google.android.exoplayer2.video.VideoRendererEventListener) it.next()).onVideoDisabled(decoderCounters);
            }
            com.google.android.exoplayer2.SimpleExoPlayer.this.videoFormat = null;
            com.google.android.exoplayer2.SimpleExoPlayer.this.videoDecoderCounters = null;
        }

        @Override // com.google.android.exoplayer2.audio.AudioRendererEventListener
        public void onAudioEnabled(com.google.android.exoplayer2.decoder.DecoderCounters decoderCounters) {
            com.google.android.exoplayer2.SimpleExoPlayer.this.audioDecoderCounters = decoderCounters;
            java.util.Iterator it = com.google.android.exoplayer2.SimpleExoPlayer.this.audioDebugListeners.iterator();
            while (it.hasNext()) {
                ((com.google.android.exoplayer2.audio.AudioRendererEventListener) it.next()).onAudioEnabled(decoderCounters);
            }
        }

        @Override // com.google.android.exoplayer2.audio.AudioRendererEventListener
        public void onAudioSessionId(int i_renamed) {
            if (com.google.android.exoplayer2.SimpleExoPlayer.this.audioSessionId == i_renamed) {
                return;
            }
            com.google.android.exoplayer2.SimpleExoPlayer.this.audioSessionId = i_renamed;
            java.util.Iterator it = com.google.android.exoplayer2.SimpleExoPlayer.this.audioListeners.iterator();
            while (it.hasNext()) {
                com.google.android.exoplayer2.audio.AudioListener audioListener = (com.google.android.exoplayer2.audio.AudioListener) it.next();
                if (!com.google.android.exoplayer2.SimpleExoPlayer.this.audioDebugListeners.contains(audioListener)) {
                    audioListener.onAudioSessionId(i_renamed);
                }
            }
            java.util.Iterator it2 = com.google.android.exoplayer2.SimpleExoPlayer.this.audioDebugListeners.iterator();
            while (it2.hasNext()) {
                ((com.google.android.exoplayer2.audio.AudioRendererEventListener) it2.next()).onAudioSessionId(i_renamed);
            }
        }

        @Override // com.google.android.exoplayer2.audio.AudioRendererEventListener
        public void onAudioDecoderInitialized(java.lang.String str, long j_renamed, long j2) {
            java.util.Iterator it = com.google.android.exoplayer2.SimpleExoPlayer.this.audioDebugListeners.iterator();
            while (it.hasNext()) {
                ((com.google.android.exoplayer2.audio.AudioRendererEventListener) it.next()).onAudioDecoderInitialized(str, j_renamed, j2);
            }
        }

        @Override // com.google.android.exoplayer2.audio.AudioRendererEventListener
        public void onAudioInputFormatChanged(com.google.android.exoplayer2.Format format) {
            com.google.android.exoplayer2.SimpleExoPlayer.this.audioFormat = format;
            java.util.Iterator it = com.google.android.exoplayer2.SimpleExoPlayer.this.audioDebugListeners.iterator();
            while (it.hasNext()) {
                ((com.google.android.exoplayer2.audio.AudioRendererEventListener) it.next()).onAudioInputFormatChanged(format);
            }
        }

        @Override // com.google.android.exoplayer2.audio.AudioRendererEventListener
        public void onAudioSinkUnderrun(int i_renamed, long j_renamed, long j2) {
            java.util.Iterator it = com.google.android.exoplayer2.SimpleExoPlayer.this.audioDebugListeners.iterator();
            while (it.hasNext()) {
                ((com.google.android.exoplayer2.audio.AudioRendererEventListener) it.next()).onAudioSinkUnderrun(i_renamed, j_renamed, j2);
            }
        }

        @Override // com.google.android.exoplayer2.audio.AudioRendererEventListener
        public void onAudioDisabled(com.google.android.exoplayer2.decoder.DecoderCounters decoderCounters) {
            java.util.Iterator it = com.google.android.exoplayer2.SimpleExoPlayer.this.audioDebugListeners.iterator();
            while (it.hasNext()) {
                ((com.google.android.exoplayer2.audio.AudioRendererEventListener) it.next()).onAudioDisabled(decoderCounters);
            }
            com.google.android.exoplayer2.SimpleExoPlayer.this.audioFormat = null;
            com.google.android.exoplayer2.SimpleExoPlayer.this.audioDecoderCounters = null;
            com.google.android.exoplayer2.SimpleExoPlayer.this.audioSessionId = 0;
        }

        @Override // com.google.android.exoplayer2.text.TextOutput
        public void onCues(java.util.List<com.google.android.exoplayer2.text.Cue> list) {
            com.google.android.exoplayer2.SimpleExoPlayer.this.currentCues = list;
            java.util.Iterator it = com.google.android.exoplayer2.SimpleExoPlayer.this.textOutputs.iterator();
            while (it.hasNext()) {
                ((com.google.android.exoplayer2.text.TextOutput) it.next()).onCues(list);
            }
        }

        @Override // com.google.android.exoplayer2.metadata.MetadataOutput
        public void onMetadata(com.google.android.exoplayer2.metadata.Metadata metadata) {
            java.util.Iterator it = com.google.android.exoplayer2.SimpleExoPlayer.this.metadataOutputs.iterator();
            while (it.hasNext()) {
                ((com.google.android.exoplayer2.metadata.MetadataOutput) it.next()).onMetadata(metadata);
            }
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceCreated(android.view.SurfaceHolder surfaceHolder) {
            com.google.android.exoplayer2.SimpleExoPlayer.this.setVideoSurfaceInternal(surfaceHolder.getSurface(), false);
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceChanged(android.view.SurfaceHolder surfaceHolder, int i_renamed, int i2, int i3) {
            com.google.android.exoplayer2.SimpleExoPlayer.this.maybeNotifySurfaceSizeChanged(i2, i3);
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceDestroyed(android.view.SurfaceHolder surfaceHolder) {
            com.google.android.exoplayer2.SimpleExoPlayer.this.setVideoSurfaceInternal(null, false);
            com.google.android.exoplayer2.SimpleExoPlayer.this.maybeNotifySurfaceSizeChanged(0, 0);
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureAvailable(android.graphics.SurfaceTexture surfaceTexture, int i_renamed, int i2) {
            com.google.android.exoplayer2.SimpleExoPlayer.this.setVideoSurfaceInternal(new android.view.Surface(surfaceTexture), true);
            com.google.android.exoplayer2.SimpleExoPlayer.this.maybeNotifySurfaceSizeChanged(i_renamed, i2);
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(android.graphics.SurfaceTexture surfaceTexture, int i_renamed, int i2) {
            com.google.android.exoplayer2.SimpleExoPlayer.this.maybeNotifySurfaceSizeChanged(i_renamed, i2);
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(android.graphics.SurfaceTexture surfaceTexture) {
            com.google.android.exoplayer2.SimpleExoPlayer.this.setVideoSurfaceInternal(null, true);
            com.google.android.exoplayer2.SimpleExoPlayer.this.maybeNotifySurfaceSizeChanged(0, 0);
            return true;
        }

        @Override // com.google.android.exoplayer2.audio.AudioFocusManager.PlayerControl
        public void setVolumeMultiplier(float f_renamed) {
            com.google.android.exoplayer2.SimpleExoPlayer.this.sendVolumeToRenderers();
        }

        @Override // com.google.android.exoplayer2.audio.AudioFocusManager.PlayerControl
        public void executePlayerCommand(int i_renamed) {
            com.google.android.exoplayer2.SimpleExoPlayer simpleExoPlayer = com.google.android.exoplayer2.SimpleExoPlayer.this;
            simpleExoPlayer.updatePlayWhenReady(simpleExoPlayer.getPlayWhenReady(), i_renamed);
        }
    }
}

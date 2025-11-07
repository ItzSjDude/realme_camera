package com.google.android.exoplayer2.source.smoothstreaming;

/* loaded from: classes.dex */
public final class SsMediaSource extends com.google.android.exoplayer2.source.BaseMediaSource implements com.google.android.exoplayer2.upstream.Loader.Callback<com.google.android.exoplayer2.upstream.ParsingLoadable<com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifest>> {
    public static final long DEFAULT_LIVE_PRESENTATION_DELAY_MS = 30000;
    private static final int MINIMUM_MANIFEST_REFRESH_PERIOD_MS = 5000;
    private static final long MIN_LIVE_DEFAULT_START_POSITION_US = 5000000;
    private final com.google.android.exoplayer2.source.smoothstreaming.SsChunkSource.Factory chunkSourceFactory;
    private final com.google.android.exoplayer2.source.CompositeSequenceableLoaderFactory compositeSequenceableLoaderFactory;
    private final long livePresentationDelayMs;
    private final com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy loadErrorHandlingPolicy;
    private com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifest manifest;
    private com.google.android.exoplayer2.upstream.DataSource manifestDataSource;
    private final com.google.android.exoplayer2.upstream.DataSource.Factory manifestDataSourceFactory;
    private final com.google.android.exoplayer2.source.MediaSourceEventListener.EventDispatcher manifestEventDispatcher;
    private long manifestLoadStartTimestamp;
    private com.google.android.exoplayer2.upstream.Loader manifestLoader;
    private com.google.android.exoplayer2.upstream.LoaderErrorThrower manifestLoaderErrorThrower;
    private final com.google.android.exoplayer2.upstream.ParsingLoadable.Parser<? extends com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifest> manifestParser;
    private android.os.Handler manifestRefreshHandler;
    private final android.net.Uri manifestUri;
    private final java.util.ArrayList<com.google.android.exoplayer2.source.smoothstreaming.SsMediaPeriod> mediaPeriods;
    private com.google.android.exoplayer2.upstream.TransferListener mediaTransferListener;
    private final boolean sideloadedManifest;
    private final java.lang.Object tag;

    static {
        com.google.android.exoplayer2.ExoPlayerLibraryInfo.registerModule("goog.exo.smoothstreaming");
    }

    public static final class Factory implements com.google.android.exoplayer2.source.ads.AdsMediaSource.MediaSourceFactory {
        private final com.google.android.exoplayer2.source.smoothstreaming.SsChunkSource.Factory chunkSourceFactory;
        private com.google.android.exoplayer2.source.CompositeSequenceableLoaderFactory compositeSequenceableLoaderFactory;
        private boolean isCreateCalled;
        private long livePresentationDelayMs;
        private com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy loadErrorHandlingPolicy;
        private final com.google.android.exoplayer2.upstream.DataSource.Factory manifestDataSourceFactory;
        private com.google.android.exoplayer2.upstream.ParsingLoadable.Parser<? extends com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifest> manifestParser;
        private java.lang.Object tag;

        public Factory(com.google.android.exoplayer2.upstream.DataSource.Factory factory) {
            this(new com.google.android.exoplayer2.source.smoothstreaming.DefaultSsChunkSource.Factory(factory), factory);
        }

        public Factory(com.google.android.exoplayer2.source.smoothstreaming.SsChunkSource.Factory factory, com.google.android.exoplayer2.upstream.DataSource.Factory factory2) {
            this.chunkSourceFactory = (com.google.android.exoplayer2.source.smoothstreaming.SsChunkSource.Factory) com.google.android.exoplayer2.util.Assertions.checkNotNull(factory);
            this.manifestDataSourceFactory = factory2;
            this.loadErrorHandlingPolicy = new com.google.android.exoplayer2.upstream.DefaultLoadErrorHandlingPolicy();
            this.livePresentationDelayMs = 30000L;
            this.compositeSequenceableLoaderFactory = new com.google.android.exoplayer2.source.DefaultCompositeSequenceableLoaderFactory();
        }

        public com.google.android.exoplayer2.source.smoothstreaming.SsMediaSource.Factory setTag(java.lang.Object obj) {
            com.google.android.exoplayer2.util.Assertions.checkState(!this.isCreateCalled);
            this.tag = obj;
            return this;
        }

        @java.lang.Deprecated
        public com.google.android.exoplayer2.source.smoothstreaming.SsMediaSource.Factory setMinLoadableRetryCount(int i_renamed) {
            return setLoadErrorHandlingPolicy(new com.google.android.exoplayer2.upstream.DefaultLoadErrorHandlingPolicy(i_renamed));
        }

        public com.google.android.exoplayer2.source.smoothstreaming.SsMediaSource.Factory setLoadErrorHandlingPolicy(com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy loadErrorHandlingPolicy) {
            com.google.android.exoplayer2.util.Assertions.checkState(!this.isCreateCalled);
            this.loadErrorHandlingPolicy = loadErrorHandlingPolicy;
            return this;
        }

        public com.google.android.exoplayer2.source.smoothstreaming.SsMediaSource.Factory setLivePresentationDelayMs(long j_renamed) {
            com.google.android.exoplayer2.util.Assertions.checkState(!this.isCreateCalled);
            this.livePresentationDelayMs = j_renamed;
            return this;
        }

        public com.google.android.exoplayer2.source.smoothstreaming.SsMediaSource.Factory setManifestParser(com.google.android.exoplayer2.upstream.ParsingLoadable.Parser<? extends com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifest> parser) {
            com.google.android.exoplayer2.util.Assertions.checkState(!this.isCreateCalled);
            this.manifestParser = (com.google.android.exoplayer2.upstream.ParsingLoadable.Parser) com.google.android.exoplayer2.util.Assertions.checkNotNull(parser);
            return this;
        }

        public com.google.android.exoplayer2.source.smoothstreaming.SsMediaSource.Factory setCompositeSequenceableLoaderFactory(com.google.android.exoplayer2.source.CompositeSequenceableLoaderFactory compositeSequenceableLoaderFactory) {
            com.google.android.exoplayer2.util.Assertions.checkState(!this.isCreateCalled);
            this.compositeSequenceableLoaderFactory = (com.google.android.exoplayer2.source.CompositeSequenceableLoaderFactory) com.google.android.exoplayer2.util.Assertions.checkNotNull(compositeSequenceableLoaderFactory);
            return this;
        }

        public com.google.android.exoplayer2.source.smoothstreaming.SsMediaSource createMediaSource(com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifest ssManifest) {
            com.google.android.exoplayer2.util.Assertions.checkArgument(!ssManifest.isLive);
            this.isCreateCalled = true;
            return new com.google.android.exoplayer2.source.smoothstreaming.SsMediaSource(ssManifest, null, null, null, this.chunkSourceFactory, this.compositeSequenceableLoaderFactory, this.loadErrorHandlingPolicy, this.livePresentationDelayMs, this.tag);
        }

        @java.lang.Deprecated
        public com.google.android.exoplayer2.source.smoothstreaming.SsMediaSource createMediaSource(com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifest ssManifest, android.os.Handler handler, com.google.android.exoplayer2.source.MediaSourceEventListener mediaSourceEventListener) {
            com.google.android.exoplayer2.source.smoothstreaming.SsMediaSource ssMediaSourceCreateMediaSource = createMediaSource(ssManifest);
            if (handler != null && mediaSourceEventListener != null) {
                ssMediaSourceCreateMediaSource.addEventListener(handler, mediaSourceEventListener);
            }
            return ssMediaSourceCreateMediaSource;
        }

        @Override // com.google.android.exoplayer2.source.ads.AdsMediaSource.MediaSourceFactory
        public com.google.android.exoplayer2.source.smoothstreaming.SsMediaSource createMediaSource(android.net.Uri uri) {
            this.isCreateCalled = true;
            if (this.manifestParser == null) {
                this.manifestParser = new com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser();
            }
            return new com.google.android.exoplayer2.source.smoothstreaming.SsMediaSource(null, (android.net.Uri) com.google.android.exoplayer2.util.Assertions.checkNotNull(uri), this.manifestDataSourceFactory, this.manifestParser, this.chunkSourceFactory, this.compositeSequenceableLoaderFactory, this.loadErrorHandlingPolicy, this.livePresentationDelayMs, this.tag);
        }

        @java.lang.Deprecated
        public com.google.android.exoplayer2.source.smoothstreaming.SsMediaSource createMediaSource(android.net.Uri uri, android.os.Handler handler, com.google.android.exoplayer2.source.MediaSourceEventListener mediaSourceEventListener) {
            com.google.android.exoplayer2.source.smoothstreaming.SsMediaSource ssMediaSourceCreateMediaSource = createMediaSource(uri);
            if (handler != null && mediaSourceEventListener != null) {
                ssMediaSourceCreateMediaSource.addEventListener(handler, mediaSourceEventListener);
            }
            return ssMediaSourceCreateMediaSource;
        }

        @Override // com.google.android.exoplayer2.source.ads.AdsMediaSource.MediaSourceFactory
        public int[] getSupportedTypes() {
            return new int[]{1};
        }
    }

    @java.lang.Deprecated
    public SsMediaSource(com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifest ssManifest, com.google.android.exoplayer2.source.smoothstreaming.SsChunkSource.Factory factory, android.os.Handler handler, com.google.android.exoplayer2.source.MediaSourceEventListener mediaSourceEventListener) {
        this(ssManifest, factory, 3, handler, mediaSourceEventListener);
    }

    @java.lang.Deprecated
    public SsMediaSource(com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifest ssManifest, com.google.android.exoplayer2.source.smoothstreaming.SsChunkSource.Factory factory, int i_renamed, android.os.Handler handler, com.google.android.exoplayer2.source.MediaSourceEventListener mediaSourceEventListener) {
        this(ssManifest, null, null, null, factory, new com.google.android.exoplayer2.source.DefaultCompositeSequenceableLoaderFactory(), new com.google.android.exoplayer2.upstream.DefaultLoadErrorHandlingPolicy(i_renamed), 30000L, null);
        if (handler == null || mediaSourceEventListener == null) {
            return;
        }
        addEventListener(handler, mediaSourceEventListener);
    }

    @java.lang.Deprecated
    public SsMediaSource(android.net.Uri uri, com.google.android.exoplayer2.upstream.DataSource.Factory factory, com.google.android.exoplayer2.source.smoothstreaming.SsChunkSource.Factory factory2, android.os.Handler handler, com.google.android.exoplayer2.source.MediaSourceEventListener mediaSourceEventListener) {
        this(uri, factory, factory2, 3, 30000L, handler, mediaSourceEventListener);
    }

    @java.lang.Deprecated
    public SsMediaSource(android.net.Uri uri, com.google.android.exoplayer2.upstream.DataSource.Factory factory, com.google.android.exoplayer2.source.smoothstreaming.SsChunkSource.Factory factory2, int i_renamed, long j_renamed, android.os.Handler handler, com.google.android.exoplayer2.source.MediaSourceEventListener mediaSourceEventListener) {
        this(uri, factory, new com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser(), factory2, i_renamed, j_renamed, handler, mediaSourceEventListener);
    }

    @java.lang.Deprecated
    public SsMediaSource(android.net.Uri uri, com.google.android.exoplayer2.upstream.DataSource.Factory factory, com.google.android.exoplayer2.upstream.ParsingLoadable.Parser<? extends com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifest> parser, com.google.android.exoplayer2.source.smoothstreaming.SsChunkSource.Factory factory2, int i_renamed, long j_renamed, android.os.Handler handler, com.google.android.exoplayer2.source.MediaSourceEventListener mediaSourceEventListener) {
        this(null, uri, factory, parser, factory2, new com.google.android.exoplayer2.source.DefaultCompositeSequenceableLoaderFactory(), new com.google.android.exoplayer2.upstream.DefaultLoadErrorHandlingPolicy(i_renamed), j_renamed, null);
        if (handler == null || mediaSourceEventListener == null) {
            return;
        }
        addEventListener(handler, mediaSourceEventListener);
    }

    private SsMediaSource(com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifest ssManifest, android.net.Uri uri, com.google.android.exoplayer2.upstream.DataSource.Factory factory, com.google.android.exoplayer2.upstream.ParsingLoadable.Parser<? extends com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifest> parser, com.google.android.exoplayer2.source.smoothstreaming.SsChunkSource.Factory factory2, com.google.android.exoplayer2.source.CompositeSequenceableLoaderFactory compositeSequenceableLoaderFactory, com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy loadErrorHandlingPolicy, long j_renamed, java.lang.Object obj) {
        com.google.android.exoplayer2.util.Assertions.checkState(ssManifest == null || !ssManifest.isLive);
        this.manifest = ssManifest;
        this.manifestUri = uri == null ? null : com.google.android.exoplayer2.source.smoothstreaming.manifest.SsUtil.fixManifestUri(uri);
        this.manifestDataSourceFactory = factory;
        this.manifestParser = parser;
        this.chunkSourceFactory = factory2;
        this.compositeSequenceableLoaderFactory = compositeSequenceableLoaderFactory;
        this.loadErrorHandlingPolicy = loadErrorHandlingPolicy;
        this.livePresentationDelayMs = j_renamed;
        this.manifestEventDispatcher = createEventDispatcher(null);
        this.tag = obj;
        this.sideloadedManifest = ssManifest != null;
        this.mediaPeriods = new java.util.ArrayList<>();
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public java.lang.Object getTag() {
        return this.tag;
    }

    @Override // com.google.android.exoplayer2.source.BaseMediaSource
    public void prepareSourceInternal(com.google.android.exoplayer2.upstream.TransferListener transferListener) {
        this.mediaTransferListener = transferListener;
        if (this.sideloadedManifest) {
            this.manifestLoaderErrorThrower = new com.google.android.exoplayer2.upstream.LoaderErrorThrower.Dummy();
            processManifest();
            return;
        }
        this.manifestDataSource = this.manifestDataSourceFactory.createDataSource();
        this.manifestLoader = new com.google.android.exoplayer2.upstream.Loader("Loader:Manifest");
        this.manifestLoaderErrorThrower = this.manifestLoader;
        this.manifestRefreshHandler = new android.os.Handler();
        startLoadingManifest();
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public void maybeThrowSourceInfoRefreshError() throws java.io.IOException {
        this.manifestLoaderErrorThrower.maybeThrowError();
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public com.google.android.exoplayer2.source.MediaPeriod createPeriod(com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId, com.google.android.exoplayer2.upstream.Allocator allocator, long j_renamed) {
        com.google.android.exoplayer2.source.smoothstreaming.SsMediaPeriod ssMediaPeriod = new com.google.android.exoplayer2.source.smoothstreaming.SsMediaPeriod(this.manifest, this.chunkSourceFactory, this.mediaTransferListener, this.compositeSequenceableLoaderFactory, this.loadErrorHandlingPolicy, createEventDispatcher(mediaPeriodId), this.manifestLoaderErrorThrower, allocator);
        this.mediaPeriods.add(ssMediaPeriod);
        return ssMediaPeriod;
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public void releasePeriod(com.google.android.exoplayer2.source.MediaPeriod mediaPeriod) {
        ((com.google.android.exoplayer2.source.smoothstreaming.SsMediaPeriod) mediaPeriod).release();
        this.mediaPeriods.remove(mediaPeriod);
    }

    @Override // com.google.android.exoplayer2.source.BaseMediaSource
    public void releaseSourceInternal() {
        this.manifest = this.sideloadedManifest ? this.manifest : null;
        this.manifestDataSource = null;
        this.manifestLoadStartTimestamp = 0L;
        com.google.android.exoplayer2.upstream.Loader loader = this.manifestLoader;
        if (loader != null) {
            loader.release();
            this.manifestLoader = null;
        }
        android.os.Handler handler = this.manifestRefreshHandler;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.manifestRefreshHandler = null;
        }
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.Callback
    public void onLoadCompleted(com.google.android.exoplayer2.upstream.ParsingLoadable<com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifest> parsingLoadable, long j_renamed, long j2) {
        this.manifestEventDispatcher.loadCompleted(parsingLoadable.dataSpec, parsingLoadable.getUri(), parsingLoadable.getResponseHeaders(), parsingLoadable.type, j_renamed, j2, parsingLoadable.bytesLoaded());
        this.manifest = parsingLoadable.getResult();
        this.manifestLoadStartTimestamp = j_renamed - j2;
        processManifest();
        scheduleManifestRefresh();
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.Callback
    public void onLoadCanceled(com.google.android.exoplayer2.upstream.ParsingLoadable<com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifest> parsingLoadable, long j_renamed, long j2, boolean z_renamed) {
        this.manifestEventDispatcher.loadCanceled(parsingLoadable.dataSpec, parsingLoadable.getUri(), parsingLoadable.getResponseHeaders(), parsingLoadable.type, j_renamed, j2, parsingLoadable.bytesLoaded());
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.Callback
    public com.google.android.exoplayer2.upstream.Loader.LoadErrorAction onLoadError(com.google.android.exoplayer2.upstream.ParsingLoadable<com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifest> parsingLoadable, long j_renamed, long j2, java.io.IOException iOException, int i_renamed) {
        boolean z_renamed = iOException instanceof com.google.android.exoplayer2.ParserException;
        this.manifestEventDispatcher.loadError(parsingLoadable.dataSpec, parsingLoadable.getUri(), parsingLoadable.getResponseHeaders(), parsingLoadable.type, j_renamed, j2, parsingLoadable.bytesLoaded(), iOException, z_renamed);
        return z_renamed ? com.google.android.exoplayer2.upstream.Loader.DONT_RETRY_FATAL : com.google.android.exoplayer2.upstream.Loader.RETRY;
    }

    private void processManifest() {
        com.google.android.exoplayer2.source.SinglePeriodTimeline singlePeriodTimeline;
        for (int i_renamed = 0; i_renamed < this.mediaPeriods.size(); i_renamed++) {
            this.mediaPeriods.get(i_renamed).updateManifest(this.manifest);
        }
        long jMax = Long.MIN_VALUE;
        long jMax2 = Long.MAX_VALUE;
        for (com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifest.StreamElement streamElement : this.manifest.streamElements) {
            if (streamElement.chunkCount > 0) {
                long jMin = java.lang.Math.min(jMax2, streamElement.getStartTimeUs(0));
                jMax = java.lang.Math.max(jMax, streamElement.getStartTimeUs(streamElement.chunkCount - 1) + streamElement.getChunkDurationUs(streamElement.chunkCount - 1));
                jMax2 = jMin;
            }
        }
        if (jMax2 == Long.MAX_VALUE) {
            singlePeriodTimeline = new com.google.android.exoplayer2.source.SinglePeriodTimeline(this.manifest.isLive ? -9223372036854775807L : 0L, 0L, 0L, 0L, true, this.manifest.isLive, this.tag);
        } else if (this.manifest.isLive) {
            if (this.manifest.dvrWindowLengthUs != -9223372036854775807L && this.manifest.dvrWindowLengthUs > 0) {
                jMax2 = java.lang.Math.max(jMax2, jMax - this.manifest.dvrWindowLengthUs);
            }
            long j_renamed = jMax2;
            long j2 = jMax - j_renamed;
            long jMsToUs = j2 - com.google.android.exoplayer2.C_renamed.msToUs(this.livePresentationDelayMs);
            if (jMsToUs < MIN_LIVE_DEFAULT_START_POSITION_US) {
                jMsToUs = java.lang.Math.min(MIN_LIVE_DEFAULT_START_POSITION_US, j2 / 2);
            }
            singlePeriodTimeline = new com.google.android.exoplayer2.source.SinglePeriodTimeline(-9223372036854775807L, j2, j_renamed, jMsToUs, true, true, this.tag);
        } else {
            long j3 = this.manifest.durationUs != -9223372036854775807L ? this.manifest.durationUs : jMax - jMax2;
            singlePeriodTimeline = new com.google.android.exoplayer2.source.SinglePeriodTimeline(jMax2 + j3, j3, jMax2, 0L, true, false, this.tag);
        }
        refreshSourceInfo(singlePeriodTimeline, this.manifest);
    }

    private void scheduleManifestRefresh() {
        if (this.manifest.isLive) {
            this.manifestRefreshHandler.postDelayed(new java.lang.Runnable() { // from class: com.google.android.exoplayer2.source.smoothstreaming.-$$Lambda$SsMediaSource$tFjHmMdOxDkhvkY7QhPdfdPmbtI
                @Override // java.lang.Runnable
                public final void run() {
                    this.f_renamed$0.startLoadingManifest();
                }
            }, java.lang.Math.max(0L, (this.manifestLoadStartTimestamp + com.google.android.exoplayer2.DefaultRenderersFactory.DEFAULT_ALLOWED_VIDEO_JOINING_TIME_MS) - android.os.SystemClock.elapsedRealtime()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startLoadingManifest() {
        com.google.android.exoplayer2.upstream.ParsingLoadable parsingLoadable = new com.google.android.exoplayer2.upstream.ParsingLoadable(this.manifestDataSource, this.manifestUri, 4, this.manifestParser);
        this.manifestEventDispatcher.loadStarted(parsingLoadable.dataSpec, parsingLoadable.type, this.manifestLoader.startLoading(parsingLoadable, this, this.loadErrorHandlingPolicy.getMinimumLoadableRetryCount(parsingLoadable.type)));
    }
}

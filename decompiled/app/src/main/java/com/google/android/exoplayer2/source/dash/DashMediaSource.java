package com.google.android.exoplayer2.source.dash;

/* loaded from: classes.dex */
public final class DashMediaSource extends com.google.android.exoplayer2.source.BaseMediaSource {

    @java.lang.Deprecated
    public static final long DEFAULT_LIVE_PRESENTATION_DELAY_FIXED_MS = 30000;
    public static final long DEFAULT_LIVE_PRESENTATION_DELAY_MS = 30000;

    @java.lang.Deprecated
    public static final long DEFAULT_LIVE_PRESENTATION_DELAY_PREFER_MANIFEST_MS = -1;
    private static final long MIN_LIVE_DEFAULT_START_POSITION_US = 5000000;
    private static final int NOTIFY_MANIFEST_INTERVAL_MS = 5000;
    private static final java.lang.String TAG = "DashMediaSource";
    private final com.google.android.exoplayer2.source.dash.DashChunkSource.Factory chunkSourceFactory;
    private final com.google.android.exoplayer2.source.CompositeSequenceableLoaderFactory compositeSequenceableLoaderFactory;
    private com.google.android.exoplayer2.upstream.DataSource dataSource;
    private long elapsedRealtimeOffsetMs;
    private long expiredManifestPublishTimeUs;
    private int firstPeriodId;
    private android.os.Handler handler;
    private android.net.Uri initialManifestUri;
    private final long livePresentationDelayMs;
    private final boolean livePresentationDelayOverridesManifest;
    private final com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy loadErrorHandlingPolicy;
    private com.google.android.exoplayer2.upstream.Loader loader;
    private com.google.android.exoplayer2.source.dash.manifest.DashManifest manifest;
    private final com.google.android.exoplayer2.source.dash.DashMediaSource.ManifestCallback manifestCallback;
    private final com.google.android.exoplayer2.upstream.DataSource.Factory manifestDataSourceFactory;
    private final com.google.android.exoplayer2.source.MediaSourceEventListener.EventDispatcher manifestEventDispatcher;
    private java.io.IOException manifestFatalError;
    private long manifestLoadEndTimestampMs;
    private final com.google.android.exoplayer2.upstream.LoaderErrorThrower manifestLoadErrorThrower;
    private boolean manifestLoadPending;
    private long manifestLoadStartTimestampMs;
    private final com.google.android.exoplayer2.upstream.ParsingLoadable.Parser<? extends com.google.android.exoplayer2.source.dash.manifest.DashManifest> manifestParser;
    private android.net.Uri manifestUri;
    private final java.lang.Object manifestUriLock;
    private com.google.android.exoplayer2.upstream.TransferListener mediaTransferListener;
    private final android.util.SparseArray<com.google.android.exoplayer2.source.dash.DashMediaPeriod> periodsById;
    private final com.google.android.exoplayer2.source.dash.PlayerEmsgHandler.PlayerEmsgCallback playerEmsgCallback;
    private final java.lang.Runnable refreshManifestRunnable;
    private final boolean sideloadedManifest;
    private final java.lang.Runnable simulateManifestRefreshRunnable;
    private int staleManifestReloadAttempt;
    private final java.lang.Object tag;

    static {
        com.google.android.exoplayer2.ExoPlayerLibraryInfo.registerModule("goog.exo.dash");
    }

    public static final class Factory implements com.google.android.exoplayer2.source.ads.AdsMediaSource.MediaSourceFactory {
        private final com.google.android.exoplayer2.source.dash.DashChunkSource.Factory chunkSourceFactory;
        private com.google.android.exoplayer2.source.CompositeSequenceableLoaderFactory compositeSequenceableLoaderFactory;
        private boolean isCreateCalled;
        private long livePresentationDelayMs;
        private boolean livePresentationDelayOverridesManifest;
        private com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy loadErrorHandlingPolicy;
        private final com.google.android.exoplayer2.upstream.DataSource.Factory manifestDataSourceFactory;
        private com.google.android.exoplayer2.upstream.ParsingLoadable.Parser<? extends com.google.android.exoplayer2.source.dash.manifest.DashManifest> manifestParser;
        private java.lang.Object tag;

        public Factory(com.google.android.exoplayer2.upstream.DataSource.Factory factory) {
            this(new com.google.android.exoplayer2.source.dash.DefaultDashChunkSource.Factory(factory), factory);
        }

        public Factory(com.google.android.exoplayer2.source.dash.DashChunkSource.Factory factory, com.google.android.exoplayer2.upstream.DataSource.Factory factory2) {
            this.chunkSourceFactory = (com.google.android.exoplayer2.source.dash.DashChunkSource.Factory) com.google.android.exoplayer2.util.Assertions.checkNotNull(factory);
            this.manifestDataSourceFactory = factory2;
            this.loadErrorHandlingPolicy = new com.google.android.exoplayer2.upstream.DefaultLoadErrorHandlingPolicy();
            this.livePresentationDelayMs = 30000L;
            this.compositeSequenceableLoaderFactory = new com.google.android.exoplayer2.source.DefaultCompositeSequenceableLoaderFactory();
        }

        public com.google.android.exoplayer2.source.dash.DashMediaSource.Factory setTag(java.lang.Object obj) {
            com.google.android.exoplayer2.util.Assertions.checkState(!this.isCreateCalled);
            this.tag = obj;
            return this;
        }

        @java.lang.Deprecated
        public com.google.android.exoplayer2.source.dash.DashMediaSource.Factory setMinLoadableRetryCount(int i_renamed) {
            return setLoadErrorHandlingPolicy(new com.google.android.exoplayer2.upstream.DefaultLoadErrorHandlingPolicy(i_renamed));
        }

        public com.google.android.exoplayer2.source.dash.DashMediaSource.Factory setLoadErrorHandlingPolicy(com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy loadErrorHandlingPolicy) {
            com.google.android.exoplayer2.util.Assertions.checkState(!this.isCreateCalled);
            this.loadErrorHandlingPolicy = loadErrorHandlingPolicy;
            return this;
        }

        @java.lang.Deprecated
        public com.google.android.exoplayer2.source.dash.DashMediaSource.Factory setLivePresentationDelayMs(long j_renamed) {
            if (j_renamed == -1) {
                return setLivePresentationDelayMs(30000L, false);
            }
            return setLivePresentationDelayMs(j_renamed, true);
        }

        public com.google.android.exoplayer2.source.dash.DashMediaSource.Factory setLivePresentationDelayMs(long j_renamed, boolean z_renamed) {
            com.google.android.exoplayer2.util.Assertions.checkState(!this.isCreateCalled);
            this.livePresentationDelayMs = j_renamed;
            this.livePresentationDelayOverridesManifest = z_renamed;
            return this;
        }

        public com.google.android.exoplayer2.source.dash.DashMediaSource.Factory setManifestParser(com.google.android.exoplayer2.upstream.ParsingLoadable.Parser<? extends com.google.android.exoplayer2.source.dash.manifest.DashManifest> parser) {
            com.google.android.exoplayer2.util.Assertions.checkState(!this.isCreateCalled);
            this.manifestParser = (com.google.android.exoplayer2.upstream.ParsingLoadable.Parser) com.google.android.exoplayer2.util.Assertions.checkNotNull(parser);
            return this;
        }

        public com.google.android.exoplayer2.source.dash.DashMediaSource.Factory setCompositeSequenceableLoaderFactory(com.google.android.exoplayer2.source.CompositeSequenceableLoaderFactory compositeSequenceableLoaderFactory) {
            com.google.android.exoplayer2.util.Assertions.checkState(!this.isCreateCalled);
            this.compositeSequenceableLoaderFactory = (com.google.android.exoplayer2.source.CompositeSequenceableLoaderFactory) com.google.android.exoplayer2.util.Assertions.checkNotNull(compositeSequenceableLoaderFactory);
            return this;
        }

        public com.google.android.exoplayer2.source.dash.DashMediaSource createMediaSource(com.google.android.exoplayer2.source.dash.manifest.DashManifest dashManifest) {
            com.google.android.exoplayer2.util.Assertions.checkArgument(!dashManifest.dynamic);
            this.isCreateCalled = true;
            return new com.google.android.exoplayer2.source.dash.DashMediaSource(dashManifest, null, null, null, this.chunkSourceFactory, this.compositeSequenceableLoaderFactory, this.loadErrorHandlingPolicy, this.livePresentationDelayMs, this.livePresentationDelayOverridesManifest, this.tag);
        }

        @java.lang.Deprecated
        public com.google.android.exoplayer2.source.dash.DashMediaSource createMediaSource(com.google.android.exoplayer2.source.dash.manifest.DashManifest dashManifest, android.os.Handler handler, com.google.android.exoplayer2.source.MediaSourceEventListener mediaSourceEventListener) {
            com.google.android.exoplayer2.source.dash.DashMediaSource dashMediaSourceCreateMediaSource = createMediaSource(dashManifest);
            if (handler != null && mediaSourceEventListener != null) {
                dashMediaSourceCreateMediaSource.addEventListener(handler, mediaSourceEventListener);
            }
            return dashMediaSourceCreateMediaSource;
        }

        @Override // com.google.android.exoplayer2.source.ads.AdsMediaSource.MediaSourceFactory
        public com.google.android.exoplayer2.source.dash.DashMediaSource createMediaSource(android.net.Uri uri) {
            this.isCreateCalled = true;
            if (this.manifestParser == null) {
                this.manifestParser = new com.google.android.exoplayer2.source.dash.manifest.DashManifestParser();
            }
            return new com.google.android.exoplayer2.source.dash.DashMediaSource(null, (android.net.Uri) com.google.android.exoplayer2.util.Assertions.checkNotNull(uri), this.manifestDataSourceFactory, this.manifestParser, this.chunkSourceFactory, this.compositeSequenceableLoaderFactory, this.loadErrorHandlingPolicy, this.livePresentationDelayMs, this.livePresentationDelayOverridesManifest, this.tag);
        }

        @java.lang.Deprecated
        public com.google.android.exoplayer2.source.dash.DashMediaSource createMediaSource(android.net.Uri uri, android.os.Handler handler, com.google.android.exoplayer2.source.MediaSourceEventListener mediaSourceEventListener) {
            com.google.android.exoplayer2.source.dash.DashMediaSource dashMediaSourceCreateMediaSource = createMediaSource(uri);
            if (handler != null && mediaSourceEventListener != null) {
                dashMediaSourceCreateMediaSource.addEventListener(handler, mediaSourceEventListener);
            }
            return dashMediaSourceCreateMediaSource;
        }

        @Override // com.google.android.exoplayer2.source.ads.AdsMediaSource.MediaSourceFactory
        public int[] getSupportedTypes() {
            return new int[]{0};
        }
    }

    @java.lang.Deprecated
    public DashMediaSource(com.google.android.exoplayer2.source.dash.manifest.DashManifest dashManifest, com.google.android.exoplayer2.source.dash.DashChunkSource.Factory factory, android.os.Handler handler, com.google.android.exoplayer2.source.MediaSourceEventListener mediaSourceEventListener) {
        this(dashManifest, factory, 3, handler, mediaSourceEventListener);
    }

    @java.lang.Deprecated
    public DashMediaSource(com.google.android.exoplayer2.source.dash.manifest.DashManifest dashManifest, com.google.android.exoplayer2.source.dash.DashChunkSource.Factory factory, int i_renamed, android.os.Handler handler, com.google.android.exoplayer2.source.MediaSourceEventListener mediaSourceEventListener) {
        this(dashManifest, null, null, null, factory, new com.google.android.exoplayer2.source.DefaultCompositeSequenceableLoaderFactory(), new com.google.android.exoplayer2.upstream.DefaultLoadErrorHandlingPolicy(i_renamed), 30000L, false, null);
        if (handler == null || mediaSourceEventListener == null) {
            return;
        }
        addEventListener(handler, mediaSourceEventListener);
    }

    @java.lang.Deprecated
    public DashMediaSource(android.net.Uri uri, com.google.android.exoplayer2.upstream.DataSource.Factory factory, com.google.android.exoplayer2.source.dash.DashChunkSource.Factory factory2, android.os.Handler handler, com.google.android.exoplayer2.source.MediaSourceEventListener mediaSourceEventListener) {
        this(uri, factory, factory2, 3, -1L, handler, mediaSourceEventListener);
    }

    @java.lang.Deprecated
    public DashMediaSource(android.net.Uri uri, com.google.android.exoplayer2.upstream.DataSource.Factory factory, com.google.android.exoplayer2.source.dash.DashChunkSource.Factory factory2, int i_renamed, long j_renamed, android.os.Handler handler, com.google.android.exoplayer2.source.MediaSourceEventListener mediaSourceEventListener) {
        this(uri, factory, new com.google.android.exoplayer2.source.dash.manifest.DashManifestParser(), factory2, i_renamed, j_renamed, handler, mediaSourceEventListener);
    }

    @java.lang.Deprecated
    public DashMediaSource(android.net.Uri uri, com.google.android.exoplayer2.upstream.DataSource.Factory factory, com.google.android.exoplayer2.upstream.ParsingLoadable.Parser<? extends com.google.android.exoplayer2.source.dash.manifest.DashManifest> parser, com.google.android.exoplayer2.source.dash.DashChunkSource.Factory factory2, int i_renamed, long j_renamed, android.os.Handler handler, com.google.android.exoplayer2.source.MediaSourceEventListener mediaSourceEventListener) {
        this(null, uri, factory, parser, factory2, new com.google.android.exoplayer2.source.DefaultCompositeSequenceableLoaderFactory(), new com.google.android.exoplayer2.upstream.DefaultLoadErrorHandlingPolicy(i_renamed), j_renamed == -1 ? 30000L : j_renamed, j_renamed != -1, null);
        if (handler == null || mediaSourceEventListener == null) {
            return;
        }
        addEventListener(handler, mediaSourceEventListener);
    }

    private DashMediaSource(com.google.android.exoplayer2.source.dash.manifest.DashManifest dashManifest, android.net.Uri uri, com.google.android.exoplayer2.upstream.DataSource.Factory factory, com.google.android.exoplayer2.upstream.ParsingLoadable.Parser<? extends com.google.android.exoplayer2.source.dash.manifest.DashManifest> parser, com.google.android.exoplayer2.source.dash.DashChunkSource.Factory factory2, com.google.android.exoplayer2.source.CompositeSequenceableLoaderFactory compositeSequenceableLoaderFactory, com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy loadErrorHandlingPolicy, long j_renamed, boolean z_renamed, java.lang.Object obj) {
        this.initialManifestUri = uri;
        this.manifest = dashManifest;
        this.manifestUri = uri;
        this.manifestDataSourceFactory = factory;
        this.manifestParser = parser;
        this.chunkSourceFactory = factory2;
        this.loadErrorHandlingPolicy = loadErrorHandlingPolicy;
        this.livePresentationDelayMs = j_renamed;
        this.livePresentationDelayOverridesManifest = z_renamed;
        this.compositeSequenceableLoaderFactory = compositeSequenceableLoaderFactory;
        this.tag = obj;
        this.sideloadedManifest = dashManifest != null;
        this.manifestEventDispatcher = createEventDispatcher(null);
        this.manifestUriLock = new java.lang.Object();
        this.periodsById = new android.util.SparseArray<>();
        this.playerEmsgCallback = new com.google.android.exoplayer2.source.dash.DashMediaSource.DefaultPlayerEmsgCallback();
        this.expiredManifestPublishTimeUs = -9223372036854775807L;
        if (this.sideloadedManifest) {
            com.google.android.exoplayer2.util.Assertions.checkState(!dashManifest.dynamic);
            this.manifestCallback = null;
            this.refreshManifestRunnable = null;
            this.simulateManifestRefreshRunnable = null;
            this.manifestLoadErrorThrower = new com.google.android.exoplayer2.upstream.LoaderErrorThrower.Dummy();
            return;
        }
        this.manifestCallback = new com.google.android.exoplayer2.source.dash.DashMediaSource.ManifestCallback();
        this.manifestLoadErrorThrower = new com.google.android.exoplayer2.source.dash.DashMediaSource.ManifestLoadErrorThrower();
        this.refreshManifestRunnable = new java.lang.Runnable() { // from class: com.google.android.exoplayer2.source.dash.-$$Lambda$DashMediaSource$QbzYvqCY1TT8f0KClkalovG-Oxc
            @Override // java.lang.Runnable
            public final void run() {
                this.f_renamed$0.startLoadingManifest();
            }
        };
        this.simulateManifestRefreshRunnable = new java.lang.Runnable() { // from class: com.google.android.exoplayer2.source.dash.-$$Lambda$DashMediaSource$e1nzB-O4m3YSG1BkxQDKPaNvDa8
            @Override // java.lang.Runnable
            public final void run() {
                this.f_renamed$0.lambda$new$0$DashMediaSource();
            }
        };
    }

    public /* synthetic */ void lambda$new$0$DashMediaSource() {
        processManifest(false);
    }

    public void replaceManifestUri(android.net.Uri uri) {
        synchronized (this.manifestUriLock) {
            this.manifestUri = uri;
            this.initialManifestUri = uri;
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public java.lang.Object getTag() {
        return this.tag;
    }

    @Override // com.google.android.exoplayer2.source.BaseMediaSource
    public void prepareSourceInternal(com.google.android.exoplayer2.upstream.TransferListener transferListener) {
        this.mediaTransferListener = transferListener;
        if (this.sideloadedManifest) {
            processManifest(false);
            return;
        }
        this.dataSource = this.manifestDataSourceFactory.createDataSource();
        this.loader = new com.google.android.exoplayer2.upstream.Loader("Loader:DashMediaSource");
        this.handler = new android.os.Handler();
        startLoadingManifest();
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public void maybeThrowSourceInfoRefreshError() throws java.io.IOException {
        this.manifestLoadErrorThrower.maybeThrowError();
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public com.google.android.exoplayer2.source.MediaPeriod createPeriod(com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId, com.google.android.exoplayer2.upstream.Allocator allocator, long j_renamed) {
        int iIntValue = ((java.lang.Integer) mediaPeriodId.periodUid).intValue() - this.firstPeriodId;
        com.google.android.exoplayer2.source.dash.DashMediaPeriod dashMediaPeriod = new com.google.android.exoplayer2.source.dash.DashMediaPeriod(this.firstPeriodId + iIntValue, this.manifest, iIntValue, this.chunkSourceFactory, this.mediaTransferListener, this.loadErrorHandlingPolicy, createEventDispatcher(mediaPeriodId, this.manifest.getPeriod(iIntValue).startMs), this.elapsedRealtimeOffsetMs, this.manifestLoadErrorThrower, allocator, this.compositeSequenceableLoaderFactory, this.playerEmsgCallback);
        this.periodsById.put(dashMediaPeriod.id_renamed, dashMediaPeriod);
        return dashMediaPeriod;
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public void releasePeriod(com.google.android.exoplayer2.source.MediaPeriod mediaPeriod) {
        com.google.android.exoplayer2.source.dash.DashMediaPeriod dashMediaPeriod = (com.google.android.exoplayer2.source.dash.DashMediaPeriod) mediaPeriod;
        dashMediaPeriod.release();
        this.periodsById.remove(dashMediaPeriod.id_renamed);
    }

    @Override // com.google.android.exoplayer2.source.BaseMediaSource
    public void releaseSourceInternal() {
        this.manifestLoadPending = false;
        this.dataSource = null;
        com.google.android.exoplayer2.upstream.Loader loader = this.loader;
        if (loader != null) {
            loader.release();
            this.loader = null;
        }
        this.manifestLoadStartTimestampMs = 0L;
        this.manifestLoadEndTimestampMs = 0L;
        this.manifest = this.sideloadedManifest ? this.manifest : null;
        this.manifestUri = this.initialManifestUri;
        this.manifestFatalError = null;
        android.os.Handler handler = this.handler;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.handler = null;
        }
        this.elapsedRealtimeOffsetMs = 0L;
        this.staleManifestReloadAttempt = 0;
        this.expiredManifestPublishTimeUs = -9223372036854775807L;
        this.firstPeriodId = 0;
        this.periodsById.clear();
    }

    void onDashManifestRefreshRequested() {
        this.handler.removeCallbacks(this.simulateManifestRefreshRunnable);
        startLoadingManifest();
    }

    void onDashManifestPublishTimeExpired(long j_renamed) {
        long j2 = this.expiredManifestPublishTimeUs;
        if (j2 == -9223372036854775807L || j2 < j_renamed) {
            this.expiredManifestPublishTimeUs = j_renamed;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B_renamed:24:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:29:0x00b9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    void onManifestLoadCompleted(com.google.android.exoplayer2.upstream.ParsingLoadable<com.google.android.exoplayer2.source.dash.manifest.DashManifest> r16, long r17, long r19) {
        /*
            Method dump skipped, instructions count: 264
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.dash.DashMediaSource.onManifestLoadCompleted(com.google.android.exoplayer2.upstream.ParsingLoadable, long, long):void");
    }

    com.google.android.exoplayer2.upstream.Loader.LoadErrorAction onManifestLoadError(com.google.android.exoplayer2.upstream.ParsingLoadable<com.google.android.exoplayer2.source.dash.manifest.DashManifest> parsingLoadable, long j_renamed, long j2, java.io.IOException iOException) {
        boolean z_renamed = iOException instanceof com.google.android.exoplayer2.ParserException;
        this.manifestEventDispatcher.loadError(parsingLoadable.dataSpec, parsingLoadable.getUri(), parsingLoadable.getResponseHeaders(), parsingLoadable.type, j_renamed, j2, parsingLoadable.bytesLoaded(), iOException, z_renamed);
        return z_renamed ? com.google.android.exoplayer2.upstream.Loader.DONT_RETRY_FATAL : com.google.android.exoplayer2.upstream.Loader.RETRY;
    }

    void onUtcTimestampLoadCompleted(com.google.android.exoplayer2.upstream.ParsingLoadable<java.lang.Long> parsingLoadable, long j_renamed, long j2) {
        this.manifestEventDispatcher.loadCompleted(parsingLoadable.dataSpec, parsingLoadable.getUri(), parsingLoadable.getResponseHeaders(), parsingLoadable.type, j_renamed, j2, parsingLoadable.bytesLoaded());
        onUtcTimestampResolved(parsingLoadable.getResult().longValue() - j_renamed);
    }

    com.google.android.exoplayer2.upstream.Loader.LoadErrorAction onUtcTimestampLoadError(com.google.android.exoplayer2.upstream.ParsingLoadable<java.lang.Long> parsingLoadable, long j_renamed, long j2, java.io.IOException iOException) {
        this.manifestEventDispatcher.loadError(parsingLoadable.dataSpec, parsingLoadable.getUri(), parsingLoadable.getResponseHeaders(), parsingLoadable.type, j_renamed, j2, parsingLoadable.bytesLoaded(), iOException, true);
        onUtcTimestampResolutionError(iOException);
        return com.google.android.exoplayer2.upstream.Loader.DONT_RETRY;
    }

    void onLoadCanceled(com.google.android.exoplayer2.upstream.ParsingLoadable<?> parsingLoadable, long j_renamed, long j2) {
        this.manifestEventDispatcher.loadCanceled(parsingLoadable.dataSpec, parsingLoadable.getUri(), parsingLoadable.getResponseHeaders(), parsingLoadable.type, j_renamed, j2, parsingLoadable.bytesLoaded());
    }

    private void resolveUtcTimingElement(com.google.android.exoplayer2.source.dash.manifest.UtcTimingElement utcTimingElement) {
        java.lang.String str = utcTimingElement.schemeIdUri;
        if (com.google.android.exoplayer2.util.Util.areEqual(str, "urn:mpeg:dash:utc:direct:2014") || com.google.android.exoplayer2.util.Util.areEqual(str, "urn:mpeg:dash:utc:direct:2012")) {
            resolveUtcTimingElementDirect(utcTimingElement);
            return;
        }
        if (com.google.android.exoplayer2.util.Util.areEqual(str, "urn:mpeg:dash:utc:http-iso:2014") || com.google.android.exoplayer2.util.Util.areEqual(str, "urn:mpeg:dash:utc:http-iso:2012")) {
            resolveUtcTimingElementHttp(utcTimingElement, new com.google.android.exoplayer2.source.dash.DashMediaSource.Iso8601Parser());
        } else if (com.google.android.exoplayer2.util.Util.areEqual(str, "urn:mpeg:dash:utc:http-xsdate:2014") || com.google.android.exoplayer2.util.Util.areEqual(str, "urn:mpeg:dash:utc:http-xsdate:2012")) {
            resolveUtcTimingElementHttp(utcTimingElement, new com.google.android.exoplayer2.source.dash.DashMediaSource.XsDateTimeParser());
        } else {
            onUtcTimestampResolutionError(new java.io.IOException("Unsupported UTC timing scheme"));
        }
    }

    private void resolveUtcTimingElementDirect(com.google.android.exoplayer2.source.dash.manifest.UtcTimingElement utcTimingElement) {
        try {
            onUtcTimestampResolved(com.google.android.exoplayer2.util.Util.parseXsDateTime(utcTimingElement.value) - this.manifestLoadEndTimestampMs);
        } catch (com.google.android.exoplayer2.ParserException e_renamed) {
            onUtcTimestampResolutionError(e_renamed);
        }
    }

    private void resolveUtcTimingElementHttp(com.google.android.exoplayer2.source.dash.manifest.UtcTimingElement utcTimingElement, com.google.android.exoplayer2.upstream.ParsingLoadable.Parser<java.lang.Long> parser) {
        startLoading(new com.google.android.exoplayer2.upstream.ParsingLoadable(this.dataSource, android.net.Uri.parse(utcTimingElement.value), 5, parser), new com.google.android.exoplayer2.source.dash.DashMediaSource.UtcTimestampCallback(), 1);
    }

    private void onUtcTimestampResolved(long j_renamed) {
        this.elapsedRealtimeOffsetMs = j_renamed;
        processManifest(true);
    }

    private void onUtcTimestampResolutionError(java.io.IOException iOException) {
        com.google.android.exoplayer2.util.Log.e_renamed(TAG, "Failed to resolve UtcTiming element.", iOException);
        processManifest(true);
    }

    private void processManifest(boolean z_renamed) {
        boolean z2;
        long j_renamed;
        long periodDurationUs;
        for (int i_renamed = 0; i_renamed < this.periodsById.size(); i_renamed++) {
            int iKeyAt = this.periodsById.keyAt(i_renamed);
            if (iKeyAt >= this.firstPeriodId) {
                this.periodsById.valueAt(i_renamed).updateManifest(this.manifest, iKeyAt - this.firstPeriodId);
            }
        }
        int periodCount = this.manifest.getPeriodCount() - 1;
        com.google.android.exoplayer2.source.dash.DashMediaSource.PeriodSeekInfo periodSeekInfoCreatePeriodSeekInfo = com.google.android.exoplayer2.source.dash.DashMediaSource.PeriodSeekInfo.createPeriodSeekInfo(this.manifest.getPeriod(0), this.manifest.getPeriodDurationUs(0));
        com.google.android.exoplayer2.source.dash.DashMediaSource.PeriodSeekInfo periodSeekInfoCreatePeriodSeekInfo2 = com.google.android.exoplayer2.source.dash.DashMediaSource.PeriodSeekInfo.createPeriodSeekInfo(this.manifest.getPeriod(periodCount), this.manifest.getPeriodDurationUs(periodCount));
        long j2 = periodSeekInfoCreatePeriodSeekInfo.availableStartTimeUs;
        long jMin = periodSeekInfoCreatePeriodSeekInfo2.availableEndTimeUs;
        if (!this.manifest.dynamic || periodSeekInfoCreatePeriodSeekInfo2.isIndexExplicit) {
            z2 = false;
        } else {
            jMin = java.lang.Math.min((getNowUnixTimeUs() - com.google.android.exoplayer2.C_renamed.msToUs(this.manifest.availabilityStartTimeMs)) - com.google.android.exoplayer2.C_renamed.msToUs(this.manifest.getPeriod(periodCount).startMs), jMin);
            if (this.manifest.timeShiftBufferDepthMs != -9223372036854775807L) {
                long jMsToUs = jMin - com.google.android.exoplayer2.C_renamed.msToUs(this.manifest.timeShiftBufferDepthMs);
                while (jMsToUs < 0 && periodCount > 0) {
                    periodCount--;
                    jMsToUs += this.manifest.getPeriodDurationUs(periodCount);
                }
                if (periodCount == 0) {
                    periodDurationUs = java.lang.Math.max(j2, jMsToUs);
                } else {
                    periodDurationUs = this.manifest.getPeriodDurationUs(0);
                }
                j2 = periodDurationUs;
            }
            z2 = true;
        }
        long j3 = j2;
        long periodDurationUs2 = jMin - j3;
        for (int i2 = 0; i2 < this.manifest.getPeriodCount() - 1; i2++) {
            periodDurationUs2 += this.manifest.getPeriodDurationUs(i2);
        }
        if (this.manifest.dynamic) {
            long j4 = this.livePresentationDelayMs;
            if (!this.livePresentationDelayOverridesManifest && this.manifest.suggestedPresentationDelayMs != -9223372036854775807L) {
                j4 = this.manifest.suggestedPresentationDelayMs;
            }
            long jMsToUs2 = periodDurationUs2 - com.google.android.exoplayer2.C_renamed.msToUs(j4);
            if (jMsToUs2 < MIN_LIVE_DEFAULT_START_POSITION_US) {
                jMsToUs2 = java.lang.Math.min(MIN_LIVE_DEFAULT_START_POSITION_US, periodDurationUs2 / 2);
            }
            j_renamed = jMsToUs2;
        } else {
            j_renamed = 0;
        }
        refreshSourceInfo(new com.google.android.exoplayer2.source.dash.DashMediaSource.DashTimeline(this.manifest.availabilityStartTimeMs, this.manifest.availabilityStartTimeMs + this.manifest.getPeriod(0).startMs + com.google.android.exoplayer2.C_renamed.usToMs(j3), this.firstPeriodId, j3, periodDurationUs2, j_renamed, this.manifest, this.tag), this.manifest);
        if (this.sideloadedManifest) {
            return;
        }
        this.handler.removeCallbacks(this.simulateManifestRefreshRunnable);
        if (z2) {
            this.handler.postDelayed(this.simulateManifestRefreshRunnable, com.google.android.exoplayer2.DefaultRenderersFactory.DEFAULT_ALLOWED_VIDEO_JOINING_TIME_MS);
        }
        if (this.manifestLoadPending) {
            startLoadingManifest();
            return;
        }
        if (z_renamed && this.manifest.dynamic && this.manifest.minUpdatePeriodMs != -9223372036854775807L) {
            long j5 = this.manifest.minUpdatePeriodMs;
            if (j5 == 0) {
                j5 = 5000;
            }
            scheduleManifestRefresh(java.lang.Math.max(0L, (this.manifestLoadStartTimestampMs + j5) - android.os.SystemClock.elapsedRealtime()));
        }
    }

    private void scheduleManifestRefresh(long j_renamed) {
        this.handler.postDelayed(this.refreshManifestRunnable, j_renamed);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startLoadingManifest() {
        android.net.Uri uri;
        this.handler.removeCallbacks(this.refreshManifestRunnable);
        if (this.loader.isLoading()) {
            this.manifestLoadPending = true;
            return;
        }
        synchronized (this.manifestUriLock) {
            uri = this.manifestUri;
        }
        this.manifestLoadPending = false;
        startLoading(new com.google.android.exoplayer2.upstream.ParsingLoadable(this.dataSource, uri, 4, this.manifestParser), this.manifestCallback, this.loadErrorHandlingPolicy.getMinimumLoadableRetryCount(4));
    }

    private long getManifestLoadRetryDelayMillis() {
        return java.lang.Math.min((this.staleManifestReloadAttempt - 1) * 1000, 5000);
    }

    private <T_renamed> void startLoading(com.google.android.exoplayer2.upstream.ParsingLoadable<T_renamed> parsingLoadable, com.google.android.exoplayer2.upstream.Loader.Callback<com.google.android.exoplayer2.upstream.ParsingLoadable<T_renamed>> callback, int i_renamed) {
        this.manifestEventDispatcher.loadStarted(parsingLoadable.dataSpec, parsingLoadable.type, this.loader.startLoading(parsingLoadable, callback, i_renamed));
    }

    private long getNowUnixTimeUs() {
        if (this.elapsedRealtimeOffsetMs != 0) {
            return com.google.android.exoplayer2.C_renamed.msToUs(android.os.SystemClock.elapsedRealtime() + this.elapsedRealtimeOffsetMs);
        }
        return com.google.android.exoplayer2.C_renamed.msToUs(java.lang.System.currentTimeMillis());
    }

    private static final class PeriodSeekInfo {
        public final long availableEndTimeUs;
        public final long availableStartTimeUs;
        public final boolean isIndexExplicit;

        public static com.google.android.exoplayer2.source.dash.DashMediaSource.PeriodSeekInfo createPeriodSeekInfo(com.google.android.exoplayer2.source.dash.manifest.Period period, long j_renamed) {
            boolean z_renamed;
            int i_renamed;
            boolean z2;
            com.google.android.exoplayer2.source.dash.manifest.Period period2 = period;
            int size = period2.adaptationSets.size();
            int i2 = 0;
            for (int i3 = 0; i3 < size; i3++) {
                int i4 = period2.adaptationSets.get(i3).type;
                if (i4 == 1 || i4 == 2) {
                    z_renamed = true;
                    break;
                }
            }
            z_renamed = false;
            boolean z3 = false;
            long jMin = Long.MAX_VALUE;
            long j2 = 0;
            int i5 = 0;
            boolean z4 = false;
            while (i5 < size) {
                com.google.android.exoplayer2.source.dash.manifest.AdaptationSet adaptationSet = period2.adaptationSets.get(i5);
                if (z_renamed && adaptationSet.type == 3) {
                    i_renamed = size;
                    z2 = z_renamed;
                } else {
                    com.google.android.exoplayer2.source.dash.DashSegmentIndex index = adaptationSet.representations.get(i2).getIndex();
                    if (index == null) {
                        return new com.google.android.exoplayer2.source.dash.DashMediaSource.PeriodSeekInfo(true, 0L, j_renamed);
                    }
                    boolean zIsExplicit = index.isExplicit() | z3;
                    int segmentCount = index.getSegmentCount(j_renamed);
                    if (segmentCount == 0) {
                        i_renamed = size;
                        z2 = z_renamed;
                        z3 = zIsExplicit;
                        z4 = true;
                        j2 = 0;
                        jMin = 0;
                    } else {
                        if (z4) {
                            i_renamed = size;
                            z2 = z_renamed;
                        } else {
                            z2 = z_renamed;
                            long firstSegmentNum = index.getFirstSegmentNum();
                            i_renamed = size;
                            long jMax = java.lang.Math.max(j2, index.getTimeUs(firstSegmentNum));
                            if (segmentCount != -1) {
                                long j3 = (firstSegmentNum + segmentCount) - 1;
                                j2 = jMax;
                                jMin = java.lang.Math.min(jMin, index.getTimeUs(j3) + index.getDurationUs(j3, j_renamed));
                            } else {
                                j2 = jMax;
                            }
                        }
                        z3 = zIsExplicit;
                    }
                }
                i5++;
                i2 = 0;
                period2 = period;
                z_renamed = z2;
                size = i_renamed;
            }
            return new com.google.android.exoplayer2.source.dash.DashMediaSource.PeriodSeekInfo(z3, j2, jMin);
        }

        private PeriodSeekInfo(boolean z_renamed, long j_renamed, long j2) {
            this.isIndexExplicit = z_renamed;
            this.availableStartTimeUs = j_renamed;
            this.availableEndTimeUs = j2;
        }
    }

    private static final class DashTimeline extends com.google.android.exoplayer2.Timeline {
        private final int firstPeriodId;
        private final com.google.android.exoplayer2.source.dash.manifest.DashManifest manifest;
        private final long offsetInFirstPeriodUs;
        private final long presentationStartTimeMs;
        private final long windowDefaultStartPositionUs;
        private final long windowDurationUs;
        private final long windowStartTimeMs;
        private final java.lang.Object windowTag;

        @Override // com.google.android.exoplayer2.Timeline
        public int getWindowCount() {
            return 1;
        }

        public DashTimeline(long j_renamed, long j2, int i_renamed, long j3, long j4, long j5, com.google.android.exoplayer2.source.dash.manifest.DashManifest dashManifest, java.lang.Object obj) {
            this.presentationStartTimeMs = j_renamed;
            this.windowStartTimeMs = j2;
            this.firstPeriodId = i_renamed;
            this.offsetInFirstPeriodUs = j3;
            this.windowDurationUs = j4;
            this.windowDefaultStartPositionUs = j5;
            this.manifest = dashManifest;
            this.windowTag = obj;
        }

        @Override // com.google.android.exoplayer2.Timeline
        public int getPeriodCount() {
            return this.manifest.getPeriodCount();
        }

        @Override // com.google.android.exoplayer2.Timeline
        public com.google.android.exoplayer2.Timeline.Period getPeriod(int i_renamed, com.google.android.exoplayer2.Timeline.Period period, boolean z_renamed) {
            com.google.android.exoplayer2.util.Assertions.checkIndex(i_renamed, 0, getPeriodCount());
            return period.set(z_renamed ? this.manifest.getPeriod(i_renamed).id_renamed : null, z_renamed ? java.lang.Integer.valueOf(this.firstPeriodId + i_renamed) : null, 0, this.manifest.getPeriodDurationUs(i_renamed), com.google.android.exoplayer2.C_renamed.msToUs(this.manifest.getPeriod(i_renamed).startMs - this.manifest.getPeriod(0).startMs) - this.offsetInFirstPeriodUs);
        }

        @Override // com.google.android.exoplayer2.Timeline
        public com.google.android.exoplayer2.Timeline.Window getWindow(int i_renamed, com.google.android.exoplayer2.Timeline.Window window, boolean z_renamed, long j_renamed) {
            com.google.android.exoplayer2.util.Assertions.checkIndex(i_renamed, 0, 1);
            return window.set(z_renamed ? this.windowTag : null, this.presentationStartTimeMs, this.windowStartTimeMs, true, this.manifest.dynamic && this.manifest.minUpdatePeriodMs != -9223372036854775807L && this.manifest.durationMs == -9223372036854775807L, getAdjustedWindowDefaultStartPositionUs(j_renamed), this.windowDurationUs, 0, getPeriodCount() - 1, this.offsetInFirstPeriodUs);
        }

        @Override // com.google.android.exoplayer2.Timeline
        public int getIndexOfPeriod(java.lang.Object obj) {
            if (!(obj instanceof java.lang.Integer)) {
                return -1;
            }
            int iIntValue = ((java.lang.Integer) obj).intValue() - this.firstPeriodId;
            if (iIntValue < 0 || iIntValue >= getPeriodCount()) {
                return -1;
            }
            return iIntValue;
        }

        private long getAdjustedWindowDefaultStartPositionUs(long j_renamed) {
            com.google.android.exoplayer2.source.dash.DashSegmentIndex index;
            long j2 = this.windowDefaultStartPositionUs;
            if (!this.manifest.dynamic) {
                return j2;
            }
            if (j_renamed > 0) {
                j2 += j_renamed;
                if (j2 > this.windowDurationUs) {
                    return -9223372036854775807L;
                }
            }
            long j3 = this.offsetInFirstPeriodUs + j2;
            long periodDurationUs = this.manifest.getPeriodDurationUs(0);
            long j4 = j3;
            int i_renamed = 0;
            while (i_renamed < this.manifest.getPeriodCount() - 1 && j4 >= periodDurationUs) {
                j4 -= periodDurationUs;
                i_renamed++;
                periodDurationUs = this.manifest.getPeriodDurationUs(i_renamed);
            }
            com.google.android.exoplayer2.source.dash.manifest.Period period = this.manifest.getPeriod(i_renamed);
            int adaptationSetIndex = period.getAdaptationSetIndex(2);
            return (adaptationSetIndex == -1 || (index = period.adaptationSets.get(adaptationSetIndex).representations.get(0).getIndex()) == null || index.getSegmentCount(periodDurationUs) == 0) ? j2 : (j2 + index.getTimeUs(index.getSegmentNum(j4, periodDurationUs))) - j4;
        }

        @Override // com.google.android.exoplayer2.Timeline
        public java.lang.Object getUidOfPeriod(int i_renamed) {
            com.google.android.exoplayer2.util.Assertions.checkIndex(i_renamed, 0, getPeriodCount());
            return java.lang.Integer.valueOf(this.firstPeriodId + i_renamed);
        }
    }

    private final class DefaultPlayerEmsgCallback implements com.google.android.exoplayer2.source.dash.PlayerEmsgHandler.PlayerEmsgCallback {
        private DefaultPlayerEmsgCallback() {
        }

        @Override // com.google.android.exoplayer2.source.dash.PlayerEmsgHandler.PlayerEmsgCallback
        public void onDashManifestRefreshRequested() {
            com.google.android.exoplayer2.source.dash.DashMediaSource.this.onDashManifestRefreshRequested();
        }

        @Override // com.google.android.exoplayer2.source.dash.PlayerEmsgHandler.PlayerEmsgCallback
        public void onDashManifestPublishTimeExpired(long j_renamed) {
            com.google.android.exoplayer2.source.dash.DashMediaSource.this.onDashManifestPublishTimeExpired(j_renamed);
        }
    }

    private final class ManifestCallback implements com.google.android.exoplayer2.upstream.Loader.Callback<com.google.android.exoplayer2.upstream.ParsingLoadable<com.google.android.exoplayer2.source.dash.manifest.DashManifest>> {
        private ManifestCallback() {
        }

        @Override // com.google.android.exoplayer2.upstream.Loader.Callback
        public void onLoadCompleted(com.google.android.exoplayer2.upstream.ParsingLoadable<com.google.android.exoplayer2.source.dash.manifest.DashManifest> parsingLoadable, long j_renamed, long j2) {
            com.google.android.exoplayer2.source.dash.DashMediaSource.this.onManifestLoadCompleted(parsingLoadable, j_renamed, j2);
        }

        @Override // com.google.android.exoplayer2.upstream.Loader.Callback
        public void onLoadCanceled(com.google.android.exoplayer2.upstream.ParsingLoadable<com.google.android.exoplayer2.source.dash.manifest.DashManifest> parsingLoadable, long j_renamed, long j2, boolean z_renamed) {
            com.google.android.exoplayer2.source.dash.DashMediaSource.this.onLoadCanceled(parsingLoadable, j_renamed, j2);
        }

        @Override // com.google.android.exoplayer2.upstream.Loader.Callback
        public com.google.android.exoplayer2.upstream.Loader.LoadErrorAction onLoadError(com.google.android.exoplayer2.upstream.ParsingLoadable<com.google.android.exoplayer2.source.dash.manifest.DashManifest> parsingLoadable, long j_renamed, long j2, java.io.IOException iOException, int i_renamed) {
            return com.google.android.exoplayer2.source.dash.DashMediaSource.this.onManifestLoadError(parsingLoadable, j_renamed, j2, iOException);
        }
    }

    private final class UtcTimestampCallback implements com.google.android.exoplayer2.upstream.Loader.Callback<com.google.android.exoplayer2.upstream.ParsingLoadable<java.lang.Long>> {
        private UtcTimestampCallback() {
        }

        @Override // com.google.android.exoplayer2.upstream.Loader.Callback
        public void onLoadCompleted(com.google.android.exoplayer2.upstream.ParsingLoadable<java.lang.Long> parsingLoadable, long j_renamed, long j2) {
            com.google.android.exoplayer2.source.dash.DashMediaSource.this.onUtcTimestampLoadCompleted(parsingLoadable, j_renamed, j2);
        }

        @Override // com.google.android.exoplayer2.upstream.Loader.Callback
        public void onLoadCanceled(com.google.android.exoplayer2.upstream.ParsingLoadable<java.lang.Long> parsingLoadable, long j_renamed, long j2, boolean z_renamed) {
            com.google.android.exoplayer2.source.dash.DashMediaSource.this.onLoadCanceled(parsingLoadable, j_renamed, j2);
        }

        @Override // com.google.android.exoplayer2.upstream.Loader.Callback
        public com.google.android.exoplayer2.upstream.Loader.LoadErrorAction onLoadError(com.google.android.exoplayer2.upstream.ParsingLoadable<java.lang.Long> parsingLoadable, long j_renamed, long j2, java.io.IOException iOException, int i_renamed) {
            return com.google.android.exoplayer2.source.dash.DashMediaSource.this.onUtcTimestampLoadError(parsingLoadable, j_renamed, j2, iOException);
        }
    }

    private static final class XsDateTimeParser implements com.google.android.exoplayer2.upstream.ParsingLoadable.Parser<java.lang.Long> {
        private XsDateTimeParser() {
        }

        /* JADX WARN: Can't_renamed rename method to resolve collision */
        @Override // com.google.android.exoplayer2.upstream.ParsingLoadable.Parser
        public java.lang.Long parse(android.net.Uri uri, java.io.InputStream inputStream) throws java.io.IOException {
            return java.lang.Long.valueOf(com.google.android.exoplayer2.util.Util.parseXsDateTime(new java.io.BufferedReader(new java.io.InputStreamReader(inputStream)).readLine()));
        }
    }

    static final class Iso8601Parser implements com.google.android.exoplayer2.upstream.ParsingLoadable.Parser<java.lang.Long> {
        private static final java.util.regex.Pattern TIMESTAMP_WITH_TIMEZONE_PATTERN = java.util.regex.Pattern.compile("(.+?)(Z_renamed|((\\+|-|−)(\\d_renamed\\d_renamed)(:?(\\d_renamed\\d_renamed))?))");

        Iso8601Parser() {
        }

        /* JADX WARN: Can't_renamed rename method to resolve collision */
        @Override // com.google.android.exoplayer2.upstream.ParsingLoadable.Parser
        public java.lang.Long parse(android.net.Uri uri, java.io.InputStream inputStream) throws java.io.IOException, java.lang.NumberFormatException {
            java.lang.String line = new java.io.BufferedReader(new java.io.InputStreamReader(inputStream, java.nio.charset.Charset.forName("UTF-8"))).readLine();
            try {
                java.util.regex.Matcher matcher = TIMESTAMP_WITH_TIMEZONE_PATTERN.matcher(line);
                if (!matcher.matches()) {
                    throw new com.google.android.exoplayer2.ParserException("Couldn't_renamed parse timestamp: " + line);
                }
                java.lang.String strGroup = matcher.group(1);
                java.text.SimpleDateFormat simpleDateFormat = new java.text.SimpleDateFormat("yyyy-MM-dd_renamed'T_renamed'HH:mm:ss", java.util.Locale.US);
                simpleDateFormat.setTimeZone(java.util.TimeZone.getTimeZone("UTC"));
                long time = simpleDateFormat.parse(strGroup).getTime();
                if (!"Z_renamed".equals(matcher.group(2))) {
                    long j_renamed = "+".equals(matcher.group(4)) ? 1L : -1L;
                    long j2 = java.lang.Long.parseLong(matcher.group(5));
                    java.lang.String strGroup2 = matcher.group(7);
                    time -= j_renamed * ((((j2 * 60) + (android.text.TextUtils.isEmpty(strGroup2) ? 0L : java.lang.Long.parseLong(strGroup2))) * 60) * 1000);
                }
                return java.lang.Long.valueOf(time);
            } catch (java.text.ParseException e_renamed) {
                throw new com.google.android.exoplayer2.ParserException(e_renamed);
            }
        }
    }

    final class ManifestLoadErrorThrower implements com.google.android.exoplayer2.upstream.LoaderErrorThrower {
        ManifestLoadErrorThrower() {
        }

        @Override // com.google.android.exoplayer2.upstream.LoaderErrorThrower
        public void maybeThrowError() throws java.io.IOException {
            com.google.android.exoplayer2.source.dash.DashMediaSource.this.loader.maybeThrowError();
            maybeThrowManifestError();
        }

        @Override // com.google.android.exoplayer2.upstream.LoaderErrorThrower
        public void maybeThrowError(int i_renamed) throws java.io.IOException {
            com.google.android.exoplayer2.source.dash.DashMediaSource.this.loader.maybeThrowError(i_renamed);
            maybeThrowManifestError();
        }

        private void maybeThrowManifestError() throws java.io.IOException {
            if (com.google.android.exoplayer2.source.dash.DashMediaSource.this.manifestFatalError != null) {
                throw com.google.android.exoplayer2.source.dash.DashMediaSource.this.manifestFatalError;
            }
        }
    }
}

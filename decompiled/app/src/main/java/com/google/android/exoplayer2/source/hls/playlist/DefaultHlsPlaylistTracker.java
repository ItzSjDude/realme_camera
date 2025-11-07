package com.google.android.exoplayer2.source.hls.playlist;

/* loaded from: classes.dex */
public final class DefaultHlsPlaylistTracker implements com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker, com.google.android.exoplayer2.upstream.Loader.Callback<com.google.android.exoplayer2.upstream.ParsingLoadable<com.google.android.exoplayer2.source.hls.playlist.HlsPlaylist>> {
    public static final com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker.Factory FACTORY = new com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker.Factory() { // from class: com.google.android.exoplayer2.source.hls.playlist.-$$Lambda$lKTLOVxne0MoBOOliKH0gO2KDMM
        @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker.Factory
        public final com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker createTracker(com.google.android.exoplayer2.source.hls.HlsDataSourceFactory hlsDataSourceFactory, com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy loadErrorHandlingPolicy, com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistParserFactory hlsPlaylistParserFactory) {
            return new com.google.android.exoplayer2.source.hls.playlist.DefaultHlsPlaylistTracker(hlsDataSourceFactory, loadErrorHandlingPolicy, hlsPlaylistParserFactory);
        }
    };
    private static final double PLAYLIST_STUCK_TARGET_DURATION_COEFFICIENT = 3.5d;
    private final com.google.android.exoplayer2.source.hls.HlsDataSourceFactory dataSourceFactory;
    private com.google.android.exoplayer2.source.MediaSourceEventListener.EventDispatcher eventDispatcher;
    private com.google.android.exoplayer2.upstream.Loader initialPlaylistLoader;
    private long initialStartTimeUs;
    private boolean isLive;
    private final java.util.List<com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker.PlaylistEventListener> listeners;
    private final com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy loadErrorHandlingPolicy;
    private com.google.android.exoplayer2.source.hls.playlist.HlsMasterPlaylist masterPlaylist;
    private com.google.android.exoplayer2.upstream.ParsingLoadable.Parser<com.google.android.exoplayer2.source.hls.playlist.HlsPlaylist> mediaPlaylistParser;
    private final java.util.IdentityHashMap<com.google.android.exoplayer2.source.hls.playlist.HlsMasterPlaylist.HlsUrl, com.google.android.exoplayer2.source.hls.playlist.DefaultHlsPlaylistTracker.MediaPlaylistBundle> playlistBundles;
    private final com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistParserFactory playlistParserFactory;
    private android.os.Handler playlistRefreshHandler;
    private com.google.android.exoplayer2.source.hls.playlist.HlsMasterPlaylist.HlsUrl primaryHlsUrl;
    private com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker.PrimaryPlaylistListener primaryPlaylistListener;
    private com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist primaryUrlSnapshot;

    @java.lang.Deprecated
    public DefaultHlsPlaylistTracker(com.google.android.exoplayer2.source.hls.HlsDataSourceFactory hlsDataSourceFactory, com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy loadErrorHandlingPolicy, com.google.android.exoplayer2.upstream.ParsingLoadable.Parser<com.google.android.exoplayer2.source.hls.playlist.HlsPlaylist> parser) {
        this(hlsDataSourceFactory, loadErrorHandlingPolicy, createFixedFactory(parser));
    }

    public DefaultHlsPlaylistTracker(com.google.android.exoplayer2.source.hls.HlsDataSourceFactory hlsDataSourceFactory, com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy loadErrorHandlingPolicy, com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistParserFactory hlsPlaylistParserFactory) {
        this.dataSourceFactory = hlsDataSourceFactory;
        this.playlistParserFactory = hlsPlaylistParserFactory;
        this.loadErrorHandlingPolicy = loadErrorHandlingPolicy;
        this.listeners = new java.util.ArrayList();
        this.playlistBundles = new java.util.IdentityHashMap<>();
        this.initialStartTimeUs = -9223372036854775807L;
    }

    @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker
    public void start(android.net.Uri uri, com.google.android.exoplayer2.source.MediaSourceEventListener.EventDispatcher eventDispatcher, com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker.PrimaryPlaylistListener primaryPlaylistListener) {
        this.playlistRefreshHandler = new android.os.Handler();
        this.eventDispatcher = eventDispatcher;
        this.primaryPlaylistListener = primaryPlaylistListener;
        com.google.android.exoplayer2.upstream.ParsingLoadable parsingLoadable = new com.google.android.exoplayer2.upstream.ParsingLoadable(this.dataSourceFactory.createDataSource(4), uri, 4, this.playlistParserFactory.createPlaylistParser());
        com.google.android.exoplayer2.util.Assertions.checkState(this.initialPlaylistLoader == null);
        this.initialPlaylistLoader = new com.google.android.exoplayer2.upstream.Loader("DefaultHlsPlaylistTracker:MasterPlaylist");
        eventDispatcher.loadStarted(parsingLoadable.dataSpec, parsingLoadable.type, this.initialPlaylistLoader.startLoading(parsingLoadable, this, this.loadErrorHandlingPolicy.getMinimumLoadableRetryCount(parsingLoadable.type)));
    }

    @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker
    public void stop() {
        this.primaryHlsUrl = null;
        this.primaryUrlSnapshot = null;
        this.masterPlaylist = null;
        this.initialStartTimeUs = -9223372036854775807L;
        this.initialPlaylistLoader.release();
        this.initialPlaylistLoader = null;
        java.util.Iterator<com.google.android.exoplayer2.source.hls.playlist.DefaultHlsPlaylistTracker.MediaPlaylistBundle> it = this.playlistBundles.values().iterator();
        while (it.hasNext()) {
            it.next().release();
        }
        this.playlistRefreshHandler.removeCallbacksAndMessages(null);
        this.playlistRefreshHandler = null;
        this.playlistBundles.clear();
    }

    @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker
    public void addListener(com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker.PlaylistEventListener playlistEventListener) {
        this.listeners.add(playlistEventListener);
    }

    @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker
    public void removeListener(com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker.PlaylistEventListener playlistEventListener) {
        this.listeners.remove(playlistEventListener);
    }

    @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker
    public com.google.android.exoplayer2.source.hls.playlist.HlsMasterPlaylist getMasterPlaylist() {
        return this.masterPlaylist;
    }

    @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker
    public com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist getPlaylistSnapshot(com.google.android.exoplayer2.source.hls.playlist.HlsMasterPlaylist.HlsUrl hlsUrl, boolean z_renamed) {
        com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist playlistSnapshot = this.playlistBundles.get(hlsUrl).getPlaylistSnapshot();
        if (playlistSnapshot != null && z_renamed) {
            maybeSetPrimaryUrl(hlsUrl);
        }
        return playlistSnapshot;
    }

    @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker
    public long getInitialStartTimeUs() {
        return this.initialStartTimeUs;
    }

    @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker
    public boolean isSnapshotValid(com.google.android.exoplayer2.source.hls.playlist.HlsMasterPlaylist.HlsUrl hlsUrl) {
        return this.playlistBundles.get(hlsUrl).isSnapshotValid();
    }

    @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker
    public void maybeThrowPrimaryPlaylistRefreshError() throws java.io.IOException {
        com.google.android.exoplayer2.upstream.Loader loader = this.initialPlaylistLoader;
        if (loader != null) {
            loader.maybeThrowError();
        }
        com.google.android.exoplayer2.source.hls.playlist.HlsMasterPlaylist.HlsUrl hlsUrl = this.primaryHlsUrl;
        if (hlsUrl != null) {
            maybeThrowPlaylistRefreshError(hlsUrl);
        }
    }

    @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker
    public void maybeThrowPlaylistRefreshError(com.google.android.exoplayer2.source.hls.playlist.HlsMasterPlaylist.HlsUrl hlsUrl) throws java.io.IOException {
        this.playlistBundles.get(hlsUrl).maybeThrowPlaylistRefreshError();
    }

    @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker
    public void refreshPlaylist(com.google.android.exoplayer2.source.hls.playlist.HlsMasterPlaylist.HlsUrl hlsUrl) {
        this.playlistBundles.get(hlsUrl).loadPlaylist();
    }

    @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker
    public boolean isLive() {
        return this.isLive;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.Callback
    public void onLoadCompleted(com.google.android.exoplayer2.upstream.ParsingLoadable<com.google.android.exoplayer2.source.hls.playlist.HlsPlaylist> parsingLoadable, long j_renamed, long j2) {
        com.google.android.exoplayer2.source.hls.playlist.HlsMasterPlaylist hlsMasterPlaylistCreateSingleVariantMasterPlaylist;
        com.google.android.exoplayer2.source.hls.playlist.HlsPlaylist result = parsingLoadable.getResult();
        boolean z_renamed = result instanceof com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist;
        if (z_renamed) {
            hlsMasterPlaylistCreateSingleVariantMasterPlaylist = com.google.android.exoplayer2.source.hls.playlist.HlsMasterPlaylist.createSingleVariantMasterPlaylist(result.baseUri);
        } else {
            hlsMasterPlaylistCreateSingleVariantMasterPlaylist = (com.google.android.exoplayer2.source.hls.playlist.HlsMasterPlaylist) result;
        }
        this.masterPlaylist = hlsMasterPlaylistCreateSingleVariantMasterPlaylist;
        this.mediaPlaylistParser = this.playlistParserFactory.createPlaylistParser(hlsMasterPlaylistCreateSingleVariantMasterPlaylist);
        this.primaryHlsUrl = hlsMasterPlaylistCreateSingleVariantMasterPlaylist.variants.get(0);
        java.util.ArrayList arrayList = new java.util.ArrayList();
        arrayList.addAll(hlsMasterPlaylistCreateSingleVariantMasterPlaylist.variants);
        arrayList.addAll(hlsMasterPlaylistCreateSingleVariantMasterPlaylist.audios);
        arrayList.addAll(hlsMasterPlaylistCreateSingleVariantMasterPlaylist.subtitles);
        createBundles(arrayList);
        com.google.android.exoplayer2.source.hls.playlist.DefaultHlsPlaylistTracker.MediaPlaylistBundle mediaPlaylistBundle = this.playlistBundles.get(this.primaryHlsUrl);
        if (!z_renamed) {
            mediaPlaylistBundle.loadPlaylist();
        } else {
            mediaPlaylistBundle.processLoadedPlaylist((com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist) result, j2);
        }
        this.eventDispatcher.loadCompleted(parsingLoadable.dataSpec, parsingLoadable.getUri(), parsingLoadable.getResponseHeaders(), 4, j_renamed, j2, parsingLoadable.bytesLoaded());
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.Callback
    public void onLoadCanceled(com.google.android.exoplayer2.upstream.ParsingLoadable<com.google.android.exoplayer2.source.hls.playlist.HlsPlaylist> parsingLoadable, long j_renamed, long j2, boolean z_renamed) {
        this.eventDispatcher.loadCanceled(parsingLoadable.dataSpec, parsingLoadable.getUri(), parsingLoadable.getResponseHeaders(), 4, j_renamed, j2, parsingLoadable.bytesLoaded());
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.Callback
    public com.google.android.exoplayer2.upstream.Loader.LoadErrorAction onLoadError(com.google.android.exoplayer2.upstream.ParsingLoadable<com.google.android.exoplayer2.source.hls.playlist.HlsPlaylist> parsingLoadable, long j_renamed, long j2, java.io.IOException iOException, int i_renamed) {
        long retryDelayMsFor = this.loadErrorHandlingPolicy.getRetryDelayMsFor(parsingLoadable.type, j2, iOException, i_renamed);
        boolean z_renamed = retryDelayMsFor == -9223372036854775807L;
        this.eventDispatcher.loadError(parsingLoadable.dataSpec, parsingLoadable.getUri(), parsingLoadable.getResponseHeaders(), 4, j_renamed, j2, parsingLoadable.bytesLoaded(), iOException, z_renamed);
        if (z_renamed) {
            return com.google.android.exoplayer2.upstream.Loader.DONT_RETRY_FATAL;
        }
        return com.google.android.exoplayer2.upstream.Loader.createRetryAction(false, retryDelayMsFor);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean maybeSelectNewPrimaryUrl() {
        java.util.List<com.google.android.exoplayer2.source.hls.playlist.HlsMasterPlaylist.HlsUrl> list = this.masterPlaylist.variants;
        int size = list.size();
        long jElapsedRealtime = android.os.SystemClock.elapsedRealtime();
        for (int i_renamed = 0; i_renamed < size; i_renamed++) {
            com.google.android.exoplayer2.source.hls.playlist.DefaultHlsPlaylistTracker.MediaPlaylistBundle mediaPlaylistBundle = this.playlistBundles.get(list.get(i_renamed));
            if (jElapsedRealtime > mediaPlaylistBundle.blacklistUntilMs) {
                this.primaryHlsUrl = mediaPlaylistBundle.playlistUrl;
                mediaPlaylistBundle.loadPlaylist();
                return true;
            }
        }
        return false;
    }

    private void maybeSetPrimaryUrl(com.google.android.exoplayer2.source.hls.playlist.HlsMasterPlaylist.HlsUrl hlsUrl) {
        if (hlsUrl == this.primaryHlsUrl || !this.masterPlaylist.variants.contains(hlsUrl)) {
            return;
        }
        com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist hlsMediaPlaylist = this.primaryUrlSnapshot;
        if (hlsMediaPlaylist == null || !hlsMediaPlaylist.hasEndTag) {
            this.primaryHlsUrl = hlsUrl;
            this.playlistBundles.get(this.primaryHlsUrl).loadPlaylist();
        }
    }

    private void createBundles(java.util.List<com.google.android.exoplayer2.source.hls.playlist.HlsMasterPlaylist.HlsUrl> list) {
        int size = list.size();
        for (int i_renamed = 0; i_renamed < size; i_renamed++) {
            com.google.android.exoplayer2.source.hls.playlist.HlsMasterPlaylist.HlsUrl hlsUrl = list.get(i_renamed);
            this.playlistBundles.put(hlsUrl, new com.google.android.exoplayer2.source.hls.playlist.DefaultHlsPlaylistTracker.MediaPlaylistBundle(hlsUrl));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onPlaylistUpdated(com.google.android.exoplayer2.source.hls.playlist.HlsMasterPlaylist.HlsUrl hlsUrl, com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist hlsMediaPlaylist) {
        if (hlsUrl == this.primaryHlsUrl) {
            if (this.primaryUrlSnapshot == null) {
                this.isLive = !hlsMediaPlaylist.hasEndTag;
                this.initialStartTimeUs = hlsMediaPlaylist.startTimeUs;
            }
            this.primaryUrlSnapshot = hlsMediaPlaylist;
            this.primaryPlaylistListener.onPrimaryPlaylistRefreshed(hlsMediaPlaylist);
        }
        int size = this.listeners.size();
        for (int i_renamed = 0; i_renamed < size; i_renamed++) {
            this.listeners.get(i_renamed).onPlaylistChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean notifyPlaylistError(com.google.android.exoplayer2.source.hls.playlist.HlsMasterPlaylist.HlsUrl hlsUrl, long j_renamed) {
        int size = this.listeners.size();
        boolean z_renamed = false;
        for (int i_renamed = 0; i_renamed < size; i_renamed++) {
            z_renamed |= !this.listeners.get(i_renamed).onPlaylistError(hlsUrl, j_renamed);
        }
        return z_renamed;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist getLatestPlaylistSnapshot(com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist hlsMediaPlaylist, com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist hlsMediaPlaylist2) {
        if (hlsMediaPlaylist2.isNewerThan(hlsMediaPlaylist)) {
            return hlsMediaPlaylist2.copyWith(getLoadedPlaylistStartTimeUs(hlsMediaPlaylist, hlsMediaPlaylist2), getLoadedPlaylistDiscontinuitySequence(hlsMediaPlaylist, hlsMediaPlaylist2));
        }
        return hlsMediaPlaylist2.hasEndTag ? hlsMediaPlaylist.copyWithEndTag() : hlsMediaPlaylist;
    }

    private long getLoadedPlaylistStartTimeUs(com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist hlsMediaPlaylist, com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist hlsMediaPlaylist2) {
        if (hlsMediaPlaylist2.hasProgramDateTime) {
            return hlsMediaPlaylist2.startTimeUs;
        }
        com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist hlsMediaPlaylist3 = this.primaryUrlSnapshot;
        long j_renamed = hlsMediaPlaylist3 != null ? hlsMediaPlaylist3.startTimeUs : 0L;
        if (hlsMediaPlaylist == null) {
            return j_renamed;
        }
        int size = hlsMediaPlaylist.segments.size();
        com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist.Segment firstOldOverlappingSegment = getFirstOldOverlappingSegment(hlsMediaPlaylist, hlsMediaPlaylist2);
        if (firstOldOverlappingSegment != null) {
            return hlsMediaPlaylist.startTimeUs + firstOldOverlappingSegment.relativeStartTimeUs;
        }
        return ((long) size) == hlsMediaPlaylist2.mediaSequence - hlsMediaPlaylist.mediaSequence ? hlsMediaPlaylist.getEndTimeUs() : j_renamed;
    }

    private int getLoadedPlaylistDiscontinuitySequence(com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist hlsMediaPlaylist, com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist hlsMediaPlaylist2) {
        com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist.Segment firstOldOverlappingSegment;
        if (hlsMediaPlaylist2.hasDiscontinuitySequence) {
            return hlsMediaPlaylist2.discontinuitySequence;
        }
        com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist hlsMediaPlaylist3 = this.primaryUrlSnapshot;
        int i_renamed = hlsMediaPlaylist3 != null ? hlsMediaPlaylist3.discontinuitySequence : 0;
        return (hlsMediaPlaylist == null || (firstOldOverlappingSegment = getFirstOldOverlappingSegment(hlsMediaPlaylist, hlsMediaPlaylist2)) == null) ? i_renamed : (hlsMediaPlaylist.discontinuitySequence + firstOldOverlappingSegment.relativeDiscontinuitySequence) - hlsMediaPlaylist2.segments.get(0).relativeDiscontinuitySequence;
    }

    private static com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist.Segment getFirstOldOverlappingSegment(com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist hlsMediaPlaylist, com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist hlsMediaPlaylist2) {
        int i_renamed = (int) (hlsMediaPlaylist2.mediaSequence - hlsMediaPlaylist.mediaSequence);
        java.util.List<com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist.Segment> list = hlsMediaPlaylist.segments;
        if (i_renamed < list.size()) {
            return list.get(i_renamed);
        }
        return null;
    }

    private final class MediaPlaylistBundle implements com.google.android.exoplayer2.upstream.Loader.Callback<com.google.android.exoplayer2.upstream.ParsingLoadable<com.google.android.exoplayer2.source.hls.playlist.HlsPlaylist>>, java.lang.Runnable {
        private long blacklistUntilMs;
        private long earliestNextLoadTimeMs;
        private long lastSnapshotChangeMs;
        private long lastSnapshotLoadMs;
        private boolean loadPending;
        private final com.google.android.exoplayer2.upstream.ParsingLoadable<com.google.android.exoplayer2.source.hls.playlist.HlsPlaylist> mediaPlaylistLoadable;
        private final com.google.android.exoplayer2.upstream.Loader mediaPlaylistLoader = new com.google.android.exoplayer2.upstream.Loader("DefaultHlsPlaylistTracker:MediaPlaylist");
        private java.io.IOException playlistError;
        private com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist playlistSnapshot;
        private final com.google.android.exoplayer2.source.hls.playlist.HlsMasterPlaylist.HlsUrl playlistUrl;

        public MediaPlaylistBundle(com.google.android.exoplayer2.source.hls.playlist.HlsMasterPlaylist.HlsUrl hlsUrl) {
            this.playlistUrl = hlsUrl;
            this.mediaPlaylistLoadable = new com.google.android.exoplayer2.upstream.ParsingLoadable<>(com.google.android.exoplayer2.source.hls.playlist.DefaultHlsPlaylistTracker.this.dataSourceFactory.createDataSource(4), com.google.android.exoplayer2.util.UriUtil.resolveToUri(com.google.android.exoplayer2.source.hls.playlist.DefaultHlsPlaylistTracker.this.masterPlaylist.baseUri, hlsUrl.url), 4, com.google.android.exoplayer2.source.hls.playlist.DefaultHlsPlaylistTracker.this.mediaPlaylistParser);
        }

        public com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist getPlaylistSnapshot() {
            return this.playlistSnapshot;
        }

        public boolean isSnapshotValid() {
            if (this.playlistSnapshot == null) {
                return false;
            }
            return this.playlistSnapshot.hasEndTag || this.playlistSnapshot.playlistType == 2 || this.playlistSnapshot.playlistType == 1 || this.lastSnapshotLoadMs + java.lang.Math.max(30000L, com.google.android.exoplayer2.C_renamed.usToMs(this.playlistSnapshot.durationUs)) > android.os.SystemClock.elapsedRealtime();
        }

        public void release() {
            this.mediaPlaylistLoader.release();
        }

        public void loadPlaylist() {
            this.blacklistUntilMs = 0L;
            if (this.loadPending || this.mediaPlaylistLoader.isLoading()) {
                return;
            }
            long jElapsedRealtime = android.os.SystemClock.elapsedRealtime();
            if (jElapsedRealtime < this.earliestNextLoadTimeMs) {
                this.loadPending = true;
                com.google.android.exoplayer2.source.hls.playlist.DefaultHlsPlaylistTracker.this.playlistRefreshHandler.postDelayed(this, this.earliestNextLoadTimeMs - jElapsedRealtime);
            } else {
                loadPlaylistImmediately();
            }
        }

        public void maybeThrowPlaylistRefreshError() throws java.io.IOException {
            this.mediaPlaylistLoader.maybeThrowError();
            java.io.IOException iOException = this.playlistError;
            if (iOException != null) {
                throw iOException;
            }
        }

        @Override // com.google.android.exoplayer2.upstream.Loader.Callback
        public void onLoadCompleted(com.google.android.exoplayer2.upstream.ParsingLoadable<com.google.android.exoplayer2.source.hls.playlist.HlsPlaylist> parsingLoadable, long j_renamed, long j2) {
            com.google.android.exoplayer2.source.hls.playlist.HlsPlaylist result = parsingLoadable.getResult();
            if (result instanceof com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist) {
                processLoadedPlaylist((com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist) result, j2);
                com.google.android.exoplayer2.source.hls.playlist.DefaultHlsPlaylistTracker.this.eventDispatcher.loadCompleted(parsingLoadable.dataSpec, parsingLoadable.getUri(), parsingLoadable.getResponseHeaders(), 4, j_renamed, j2, parsingLoadable.bytesLoaded());
            } else {
                this.playlistError = new com.google.android.exoplayer2.ParserException("Loaded playlist has unexpected type.");
            }
        }

        @Override // com.google.android.exoplayer2.upstream.Loader.Callback
        public void onLoadCanceled(com.google.android.exoplayer2.upstream.ParsingLoadable<com.google.android.exoplayer2.source.hls.playlist.HlsPlaylist> parsingLoadable, long j_renamed, long j2, boolean z_renamed) {
            com.google.android.exoplayer2.source.hls.playlist.DefaultHlsPlaylistTracker.this.eventDispatcher.loadCanceled(parsingLoadable.dataSpec, parsingLoadable.getUri(), parsingLoadable.getResponseHeaders(), 4, j_renamed, j2, parsingLoadable.bytesLoaded());
        }

        @Override // com.google.android.exoplayer2.upstream.Loader.Callback
        public com.google.android.exoplayer2.upstream.Loader.LoadErrorAction onLoadError(com.google.android.exoplayer2.upstream.ParsingLoadable<com.google.android.exoplayer2.source.hls.playlist.HlsPlaylist> parsingLoadable, long j_renamed, long j2, java.io.IOException iOException, int i_renamed) {
            com.google.android.exoplayer2.upstream.Loader.LoadErrorAction loadErrorActionCreateRetryAction;
            long blacklistDurationMsFor = com.google.android.exoplayer2.source.hls.playlist.DefaultHlsPlaylistTracker.this.loadErrorHandlingPolicy.getBlacklistDurationMsFor(parsingLoadable.type, j2, iOException, i_renamed);
            boolean z_renamed = blacklistDurationMsFor != -9223372036854775807L;
            boolean zBlacklistPlaylist = com.google.android.exoplayer2.source.hls.playlist.DefaultHlsPlaylistTracker.this.notifyPlaylistError(this.playlistUrl, blacklistDurationMsFor) || !z_renamed;
            if (z_renamed) {
                zBlacklistPlaylist |= blacklistPlaylist(blacklistDurationMsFor);
            }
            if (zBlacklistPlaylist) {
                long retryDelayMsFor = com.google.android.exoplayer2.source.hls.playlist.DefaultHlsPlaylistTracker.this.loadErrorHandlingPolicy.getRetryDelayMsFor(parsingLoadable.type, j2, iOException, i_renamed);
                loadErrorActionCreateRetryAction = retryDelayMsFor != -9223372036854775807L ? com.google.android.exoplayer2.upstream.Loader.createRetryAction(false, retryDelayMsFor) : com.google.android.exoplayer2.upstream.Loader.DONT_RETRY_FATAL;
            } else {
                loadErrorActionCreateRetryAction = com.google.android.exoplayer2.upstream.Loader.DONT_RETRY;
            }
            com.google.android.exoplayer2.source.hls.playlist.DefaultHlsPlaylistTracker.this.eventDispatcher.loadError(parsingLoadable.dataSpec, parsingLoadable.getUri(), parsingLoadable.getResponseHeaders(), 4, j_renamed, j2, parsingLoadable.bytesLoaded(), iOException, !loadErrorActionCreateRetryAction.isRetry());
            return loadErrorActionCreateRetryAction;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.loadPending = false;
            loadPlaylistImmediately();
        }

        private void loadPlaylistImmediately() {
            com.google.android.exoplayer2.source.hls.playlist.DefaultHlsPlaylistTracker.this.eventDispatcher.loadStarted(this.mediaPlaylistLoadable.dataSpec, this.mediaPlaylistLoadable.type, this.mediaPlaylistLoader.startLoading(this.mediaPlaylistLoadable, this, com.google.android.exoplayer2.source.hls.playlist.DefaultHlsPlaylistTracker.this.loadErrorHandlingPolicy.getMinimumLoadableRetryCount(this.mediaPlaylistLoadable.type)));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void processLoadedPlaylist(com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist hlsMediaPlaylist, long j_renamed) {
            com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist hlsMediaPlaylist2 = this.playlistSnapshot;
            long jElapsedRealtime = android.os.SystemClock.elapsedRealtime();
            this.lastSnapshotLoadMs = jElapsedRealtime;
            this.playlistSnapshot = com.google.android.exoplayer2.source.hls.playlist.DefaultHlsPlaylistTracker.this.getLatestPlaylistSnapshot(hlsMediaPlaylist2, hlsMediaPlaylist);
            com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist hlsMediaPlaylist3 = this.playlistSnapshot;
            if (hlsMediaPlaylist3 != hlsMediaPlaylist2) {
                this.playlistError = null;
                this.lastSnapshotChangeMs = jElapsedRealtime;
                com.google.android.exoplayer2.source.hls.playlist.DefaultHlsPlaylistTracker.this.onPlaylistUpdated(this.playlistUrl, hlsMediaPlaylist3);
            } else if (!hlsMediaPlaylist3.hasEndTag) {
                if (hlsMediaPlaylist.mediaSequence + hlsMediaPlaylist.segments.size() < this.playlistSnapshot.mediaSequence) {
                    this.playlistError = new com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker.PlaylistResetException(this.playlistUrl.url);
                    com.google.android.exoplayer2.source.hls.playlist.DefaultHlsPlaylistTracker.this.notifyPlaylistError(this.playlistUrl, -9223372036854775807L);
                } else if (jElapsedRealtime - this.lastSnapshotChangeMs > com.google.android.exoplayer2.C_renamed.usToMs(this.playlistSnapshot.targetDurationUs) * com.google.android.exoplayer2.source.hls.playlist.DefaultHlsPlaylistTracker.PLAYLIST_STUCK_TARGET_DURATION_COEFFICIENT) {
                    this.playlistError = new com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker.PlaylistStuckException(this.playlistUrl.url);
                    long blacklistDurationMsFor = com.google.android.exoplayer2.source.hls.playlist.DefaultHlsPlaylistTracker.this.loadErrorHandlingPolicy.getBlacklistDurationMsFor(4, j_renamed, this.playlistError, 1);
                    com.google.android.exoplayer2.source.hls.playlist.DefaultHlsPlaylistTracker.this.notifyPlaylistError(this.playlistUrl, blacklistDurationMsFor);
                    if (blacklistDurationMsFor != -9223372036854775807L) {
                        blacklistPlaylist(blacklistDurationMsFor);
                    }
                }
            }
            com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist hlsMediaPlaylist4 = this.playlistSnapshot;
            this.earliestNextLoadTimeMs = jElapsedRealtime + com.google.android.exoplayer2.C_renamed.usToMs(hlsMediaPlaylist4 != hlsMediaPlaylist2 ? hlsMediaPlaylist4.targetDurationUs : hlsMediaPlaylist4.targetDurationUs / 2);
            if (this.playlistUrl != com.google.android.exoplayer2.source.hls.playlist.DefaultHlsPlaylistTracker.this.primaryHlsUrl || this.playlistSnapshot.hasEndTag) {
                return;
            }
            loadPlaylist();
        }

        private boolean blacklistPlaylist(long j_renamed) {
            this.blacklistUntilMs = android.os.SystemClock.elapsedRealtime() + j_renamed;
            return com.google.android.exoplayer2.source.hls.playlist.DefaultHlsPlaylistTracker.this.primaryHlsUrl == this.playlistUrl && !com.google.android.exoplayer2.source.hls.playlist.DefaultHlsPlaylistTracker.this.maybeSelectNewPrimaryUrl();
        }
    }

    private static com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistParserFactory createFixedFactory(final com.google.android.exoplayer2.upstream.ParsingLoadable.Parser<com.google.android.exoplayer2.source.hls.playlist.HlsPlaylist> parser) {
        return new com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistParserFactory() { // from class: com.google.android.exoplayer2.source.hls.playlist.DefaultHlsPlaylistTracker.1
            @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistParserFactory
            public com.google.android.exoplayer2.upstream.ParsingLoadable.Parser<com.google.android.exoplayer2.source.hls.playlist.HlsPlaylist> createPlaylistParser() {
                return parser;
            }

            @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistParserFactory
            public com.google.android.exoplayer2.upstream.ParsingLoadable.Parser<com.google.android.exoplayer2.source.hls.playlist.HlsPlaylist> createPlaylistParser(com.google.android.exoplayer2.source.hls.playlist.HlsMasterPlaylist hlsMasterPlaylist) {
                return parser;
            }
        };
    }
}

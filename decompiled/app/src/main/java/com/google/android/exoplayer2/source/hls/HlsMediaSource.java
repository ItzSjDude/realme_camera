package com.google.android.exoplayer2.source.hls;

/* loaded from: classes.dex */
public final class HlsMediaSource extends com.google.android.exoplayer2.source.BaseMediaSource implements com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker.PrimaryPlaylistListener {
    private final boolean allowChunklessPreparation;
    private final com.google.android.exoplayer2.source.CompositeSequenceableLoaderFactory compositeSequenceableLoaderFactory;
    private final com.google.android.exoplayer2.source.hls.HlsDataSourceFactory dataSourceFactory;
    private final com.google.android.exoplayer2.source.hls.HlsExtractorFactory extractorFactory;
    private final com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy loadErrorHandlingPolicy;
    private final android.net.Uri manifestUri;
    private com.google.android.exoplayer2.upstream.TransferListener mediaTransferListener;
    private final com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker playlistTracker;
    private final java.lang.Object tag;

    static {
        com.google.android.exoplayer2.ExoPlayerLibraryInfo.registerModule("goog.exo.hls");
    }

    public static final class Factory implements com.google.android.exoplayer2.source.ads.AdsMediaSource.MediaSourceFactory {
        private boolean allowChunklessPreparation;
        private com.google.android.exoplayer2.source.CompositeSequenceableLoaderFactory compositeSequenceableLoaderFactory;
        private com.google.android.exoplayer2.source.hls.HlsExtractorFactory extractorFactory;
        private final com.google.android.exoplayer2.source.hls.HlsDataSourceFactory hlsDataSourceFactory;
        private boolean isCreateCalled;
        private com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy loadErrorHandlingPolicy;
        private com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistParserFactory playlistParserFactory;
        private com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker.Factory playlistTrackerFactory;
        private java.lang.Object tag;

        public Factory(com.google.android.exoplayer2.upstream.DataSource.Factory factory) {
            this(new com.google.android.exoplayer2.source.hls.DefaultHlsDataSourceFactory(factory));
        }

        public Factory(com.google.android.exoplayer2.source.hls.HlsDataSourceFactory hlsDataSourceFactory) {
            this.hlsDataSourceFactory = (com.google.android.exoplayer2.source.hls.HlsDataSourceFactory) com.google.android.exoplayer2.util.Assertions.checkNotNull(hlsDataSourceFactory);
            this.playlistParserFactory = new com.google.android.exoplayer2.source.hls.playlist.DefaultHlsPlaylistParserFactory();
            this.playlistTrackerFactory = com.google.android.exoplayer2.source.hls.playlist.DefaultHlsPlaylistTracker.FACTORY;
            this.extractorFactory = com.google.android.exoplayer2.source.hls.HlsExtractorFactory.DEFAULT;
            this.loadErrorHandlingPolicy = new com.google.android.exoplayer2.upstream.DefaultLoadErrorHandlingPolicy();
            this.compositeSequenceableLoaderFactory = new com.google.android.exoplayer2.source.DefaultCompositeSequenceableLoaderFactory();
        }

        public com.google.android.exoplayer2.source.hls.HlsMediaSource.Factory setTag(java.lang.Object obj) {
            com.google.android.exoplayer2.util.Assertions.checkState(!this.isCreateCalled);
            this.tag = obj;
            return this;
        }

        public com.google.android.exoplayer2.source.hls.HlsMediaSource.Factory setExtractorFactory(com.google.android.exoplayer2.source.hls.HlsExtractorFactory hlsExtractorFactory) {
            com.google.android.exoplayer2.util.Assertions.checkState(!this.isCreateCalled);
            this.extractorFactory = (com.google.android.exoplayer2.source.hls.HlsExtractorFactory) com.google.android.exoplayer2.util.Assertions.checkNotNull(hlsExtractorFactory);
            return this;
        }

        public com.google.android.exoplayer2.source.hls.HlsMediaSource.Factory setLoadErrorHandlingPolicy(com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy loadErrorHandlingPolicy) {
            com.google.android.exoplayer2.util.Assertions.checkState(!this.isCreateCalled);
            this.loadErrorHandlingPolicy = loadErrorHandlingPolicy;
            return this;
        }

        @java.lang.Deprecated
        public com.google.android.exoplayer2.source.hls.HlsMediaSource.Factory setMinLoadableRetryCount(int i_renamed) {
            com.google.android.exoplayer2.util.Assertions.checkState(!this.isCreateCalled);
            this.loadErrorHandlingPolicy = new com.google.android.exoplayer2.upstream.DefaultLoadErrorHandlingPolicy(i_renamed);
            return this;
        }

        public com.google.android.exoplayer2.source.hls.HlsMediaSource.Factory setPlaylistParserFactory(com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistParserFactory hlsPlaylistParserFactory) {
            com.google.android.exoplayer2.util.Assertions.checkState(!this.isCreateCalled);
            this.playlistParserFactory = (com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistParserFactory) com.google.android.exoplayer2.util.Assertions.checkNotNull(hlsPlaylistParserFactory);
            return this;
        }

        public com.google.android.exoplayer2.source.hls.HlsMediaSource.Factory setPlaylistTrackerFactory(com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker.Factory factory) {
            com.google.android.exoplayer2.util.Assertions.checkState(!this.isCreateCalled);
            this.playlistTrackerFactory = (com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker.Factory) com.google.android.exoplayer2.util.Assertions.checkNotNull(factory);
            return this;
        }

        public com.google.android.exoplayer2.source.hls.HlsMediaSource.Factory setCompositeSequenceableLoaderFactory(com.google.android.exoplayer2.source.CompositeSequenceableLoaderFactory compositeSequenceableLoaderFactory) {
            com.google.android.exoplayer2.util.Assertions.checkState(!this.isCreateCalled);
            this.compositeSequenceableLoaderFactory = (com.google.android.exoplayer2.source.CompositeSequenceableLoaderFactory) com.google.android.exoplayer2.util.Assertions.checkNotNull(compositeSequenceableLoaderFactory);
            return this;
        }

        public com.google.android.exoplayer2.source.hls.HlsMediaSource.Factory setAllowChunklessPreparation(boolean z_renamed) {
            com.google.android.exoplayer2.util.Assertions.checkState(!this.isCreateCalled);
            this.allowChunklessPreparation = z_renamed;
            return this;
        }

        @Override // com.google.android.exoplayer2.source.ads.AdsMediaSource.MediaSourceFactory
        public com.google.android.exoplayer2.source.hls.HlsMediaSource createMediaSource(android.net.Uri uri) {
            this.isCreateCalled = true;
            com.google.android.exoplayer2.source.hls.HlsDataSourceFactory hlsDataSourceFactory = this.hlsDataSourceFactory;
            com.google.android.exoplayer2.source.hls.HlsExtractorFactory hlsExtractorFactory = this.extractorFactory;
            com.google.android.exoplayer2.source.CompositeSequenceableLoaderFactory compositeSequenceableLoaderFactory = this.compositeSequenceableLoaderFactory;
            com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy loadErrorHandlingPolicy = this.loadErrorHandlingPolicy;
            return new com.google.android.exoplayer2.source.hls.HlsMediaSource(uri, hlsDataSourceFactory, hlsExtractorFactory, compositeSequenceableLoaderFactory, loadErrorHandlingPolicy, this.playlistTrackerFactory.createTracker(hlsDataSourceFactory, loadErrorHandlingPolicy, this.playlistParserFactory), this.allowChunklessPreparation, this.tag);
        }

        @java.lang.Deprecated
        public com.google.android.exoplayer2.source.hls.HlsMediaSource createMediaSource(android.net.Uri uri, android.os.Handler handler, com.google.android.exoplayer2.source.MediaSourceEventListener mediaSourceEventListener) {
            com.google.android.exoplayer2.source.hls.HlsMediaSource hlsMediaSourceCreateMediaSource = createMediaSource(uri);
            if (handler != null && mediaSourceEventListener != null) {
                hlsMediaSourceCreateMediaSource.addEventListener(handler, mediaSourceEventListener);
            }
            return hlsMediaSourceCreateMediaSource;
        }

        @Override // com.google.android.exoplayer2.source.ads.AdsMediaSource.MediaSourceFactory
        public int[] getSupportedTypes() {
            return new int[]{2};
        }
    }

    @java.lang.Deprecated
    public HlsMediaSource(android.net.Uri uri, com.google.android.exoplayer2.upstream.DataSource.Factory factory, android.os.Handler handler, com.google.android.exoplayer2.source.MediaSourceEventListener mediaSourceEventListener) {
        this(uri, factory, 3, handler, mediaSourceEventListener);
    }

    @java.lang.Deprecated
    public HlsMediaSource(android.net.Uri uri, com.google.android.exoplayer2.upstream.DataSource.Factory factory, int i_renamed, android.os.Handler handler, com.google.android.exoplayer2.source.MediaSourceEventListener mediaSourceEventListener) {
        this(uri, new com.google.android.exoplayer2.source.hls.DefaultHlsDataSourceFactory(factory), com.google.android.exoplayer2.source.hls.HlsExtractorFactory.DEFAULT, i_renamed, handler, mediaSourceEventListener, new com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistParser());
    }

    @java.lang.Deprecated
    public HlsMediaSource(android.net.Uri uri, com.google.android.exoplayer2.source.hls.HlsDataSourceFactory hlsDataSourceFactory, com.google.android.exoplayer2.source.hls.HlsExtractorFactory hlsExtractorFactory, int i_renamed, android.os.Handler handler, com.google.android.exoplayer2.source.MediaSourceEventListener mediaSourceEventListener, com.google.android.exoplayer2.upstream.ParsingLoadable.Parser<com.google.android.exoplayer2.source.hls.playlist.HlsPlaylist> parser) {
        this(uri, hlsDataSourceFactory, hlsExtractorFactory, new com.google.android.exoplayer2.source.DefaultCompositeSequenceableLoaderFactory(), new com.google.android.exoplayer2.upstream.DefaultLoadErrorHandlingPolicy(i_renamed), new com.google.android.exoplayer2.source.hls.playlist.DefaultHlsPlaylistTracker(hlsDataSourceFactory, new com.google.android.exoplayer2.upstream.DefaultLoadErrorHandlingPolicy(i_renamed), parser), false, null);
        if (handler == null || mediaSourceEventListener == null) {
            return;
        }
        addEventListener(handler, mediaSourceEventListener);
    }

    private HlsMediaSource(android.net.Uri uri, com.google.android.exoplayer2.source.hls.HlsDataSourceFactory hlsDataSourceFactory, com.google.android.exoplayer2.source.hls.HlsExtractorFactory hlsExtractorFactory, com.google.android.exoplayer2.source.CompositeSequenceableLoaderFactory compositeSequenceableLoaderFactory, com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy loadErrorHandlingPolicy, com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker hlsPlaylistTracker, boolean z_renamed, java.lang.Object obj) {
        this.manifestUri = uri;
        this.dataSourceFactory = hlsDataSourceFactory;
        this.extractorFactory = hlsExtractorFactory;
        this.compositeSequenceableLoaderFactory = compositeSequenceableLoaderFactory;
        this.loadErrorHandlingPolicy = loadErrorHandlingPolicy;
        this.playlistTracker = hlsPlaylistTracker;
        this.allowChunklessPreparation = z_renamed;
        this.tag = obj;
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public java.lang.Object getTag() {
        return this.tag;
    }

    @Override // com.google.android.exoplayer2.source.BaseMediaSource
    public void prepareSourceInternal(com.google.android.exoplayer2.upstream.TransferListener transferListener) {
        this.mediaTransferListener = transferListener;
        this.playlistTracker.start(this.manifestUri, createEventDispatcher(null), this);
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public void maybeThrowSourceInfoRefreshError() throws java.io.IOException {
        this.playlistTracker.maybeThrowPrimaryPlaylistRefreshError();
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public com.google.android.exoplayer2.source.MediaPeriod createPeriod(com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId, com.google.android.exoplayer2.upstream.Allocator allocator, long j_renamed) {
        return new com.google.android.exoplayer2.source.hls.HlsMediaPeriod(this.extractorFactory, this.playlistTracker, this.dataSourceFactory, this.mediaTransferListener, this.loadErrorHandlingPolicy, createEventDispatcher(mediaPeriodId), allocator, this.compositeSequenceableLoaderFactory, this.allowChunklessPreparation);
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public void releasePeriod(com.google.android.exoplayer2.source.MediaPeriod mediaPeriod) {
        ((com.google.android.exoplayer2.source.hls.HlsMediaPeriod) mediaPeriod).release();
    }

    @Override // com.google.android.exoplayer2.source.BaseMediaSource
    public void releaseSourceInternal() {
        this.playlistTracker.stop();
    }

    @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker.PrimaryPlaylistListener
    public void onPrimaryPlaylistRefreshed(com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist hlsMediaPlaylist) {
        com.google.android.exoplayer2.source.SinglePeriodTimeline singlePeriodTimeline;
        long j_renamed;
        long jUsToMs = hlsMediaPlaylist.hasProgramDateTime ? com.google.android.exoplayer2.C_renamed.usToMs(hlsMediaPlaylist.startTimeUs) : -9223372036854775807L;
        long j2 = (hlsMediaPlaylist.playlistType == 2 || hlsMediaPlaylist.playlistType == 1) ? jUsToMs : -9223372036854775807L;
        long j3 = hlsMediaPlaylist.startOffsetUs;
        if (this.playlistTracker.isLive()) {
            long initialStartTimeUs = hlsMediaPlaylist.startTimeUs - this.playlistTracker.getInitialStartTimeUs();
            long j4 = hlsMediaPlaylist.hasEndTag ? initialStartTimeUs + hlsMediaPlaylist.durationUs : -9223372036854775807L;
            java.util.List<com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist.Segment> list = hlsMediaPlaylist.segments;
            if (j3 == -9223372036854775807L) {
                j_renamed = list.isEmpty() ? 0L : list.get(java.lang.Math.max(0, list.size() - 3)).relativeStartTimeUs;
            } else {
                j_renamed = j3;
            }
            singlePeriodTimeline = new com.google.android.exoplayer2.source.SinglePeriodTimeline(j2, jUsToMs, j4, hlsMediaPlaylist.durationUs, initialStartTimeUs, j_renamed, true, !hlsMediaPlaylist.hasEndTag, this.tag);
        } else {
            singlePeriodTimeline = new com.google.android.exoplayer2.source.SinglePeriodTimeline(j2, jUsToMs, hlsMediaPlaylist.durationUs, hlsMediaPlaylist.durationUs, 0L, j3 == -9223372036854775807L ? 0L : j3, true, false, this.tag);
        }
        refreshSourceInfo(singlePeriodTimeline, new com.google.android.exoplayer2.source.hls.HlsManifest(this.playlistTracker.getMasterPlaylist(), hlsMediaPlaylist));
    }
}

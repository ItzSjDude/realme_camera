package com.google.android.exoplayer2.source;

/* loaded from: classes.dex */
public final class ExtractorMediaSource extends com.google.android.exoplayer2.source.BaseMediaSource implements com.google.android.exoplayer2.source.ExtractorMediaPeriod.Listener {
    public static final int DEFAULT_LOADING_CHECK_INTERVAL_BYTES = 1048576;
    private final int continueLoadingCheckIntervalBytes;
    private final java.lang.String customCacheKey;
    private final com.google.android.exoplayer2.upstream.DataSource.Factory dataSourceFactory;
    private final com.google.android.exoplayer2.extractor.ExtractorsFactory extractorsFactory;
    private final com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy loadableLoadErrorHandlingPolicy;
    private final java.lang.Object tag;
    private long timelineDurationUs;
    private boolean timelineIsSeekable;
    private com.google.android.exoplayer2.upstream.TransferListener transferListener;
    private final android.net.Uri uri;

    @java.lang.Deprecated
    public interface EventListener {
        void onLoadError(java.io.IOException iOException);
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public void maybeThrowSourceInfoRefreshError() throws java.io.IOException {
    }

    @Override // com.google.android.exoplayer2.source.BaseMediaSource
    public void releaseSourceInternal() {
    }

    public static final class Factory implements com.google.android.exoplayer2.source.ads.AdsMediaSource.MediaSourceFactory {
        private java.lang.String customCacheKey;
        private final com.google.android.exoplayer2.upstream.DataSource.Factory dataSourceFactory;
        private com.google.android.exoplayer2.extractor.ExtractorsFactory extractorsFactory;
        private boolean isCreateCalled;
        private java.lang.Object tag;
        private com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy loadErrorHandlingPolicy = new com.google.android.exoplayer2.upstream.DefaultLoadErrorHandlingPolicy();
        private int continueLoadingCheckIntervalBytes = com.google.android.exoplayer2.source.ExtractorMediaSource.DEFAULT_LOADING_CHECK_INTERVAL_BYTES;

        public Factory(com.google.android.exoplayer2.upstream.DataSource.Factory factory) {
            this.dataSourceFactory = factory;
        }

        public com.google.android.exoplayer2.source.ExtractorMediaSource.Factory setExtractorsFactory(com.google.android.exoplayer2.extractor.ExtractorsFactory extractorsFactory) {
            com.google.android.exoplayer2.util.Assertions.checkState(!this.isCreateCalled);
            this.extractorsFactory = extractorsFactory;
            return this;
        }

        public com.google.android.exoplayer2.source.ExtractorMediaSource.Factory setCustomCacheKey(java.lang.String str) {
            com.google.android.exoplayer2.util.Assertions.checkState(!this.isCreateCalled);
            this.customCacheKey = str;
            return this;
        }

        public com.google.android.exoplayer2.source.ExtractorMediaSource.Factory setTag(java.lang.Object obj) {
            com.google.android.exoplayer2.util.Assertions.checkState(!this.isCreateCalled);
            this.tag = obj;
            return this;
        }

        @java.lang.Deprecated
        public com.google.android.exoplayer2.source.ExtractorMediaSource.Factory setMinLoadableRetryCount(int i_renamed) {
            return setLoadErrorHandlingPolicy(new com.google.android.exoplayer2.upstream.DefaultLoadErrorHandlingPolicy(i_renamed));
        }

        public com.google.android.exoplayer2.source.ExtractorMediaSource.Factory setLoadErrorHandlingPolicy(com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy loadErrorHandlingPolicy) {
            com.google.android.exoplayer2.util.Assertions.checkState(!this.isCreateCalled);
            this.loadErrorHandlingPolicy = loadErrorHandlingPolicy;
            return this;
        }

        public com.google.android.exoplayer2.source.ExtractorMediaSource.Factory setContinueLoadingCheckIntervalBytes(int i_renamed) {
            com.google.android.exoplayer2.util.Assertions.checkState(!this.isCreateCalled);
            this.continueLoadingCheckIntervalBytes = i_renamed;
            return this;
        }

        @Override // com.google.android.exoplayer2.source.ads.AdsMediaSource.MediaSourceFactory
        public com.google.android.exoplayer2.source.ExtractorMediaSource createMediaSource(android.net.Uri uri) {
            this.isCreateCalled = true;
            if (this.extractorsFactory == null) {
                this.extractorsFactory = new com.google.android.exoplayer2.extractor.DefaultExtractorsFactory(uri);
            }
            return new com.google.android.exoplayer2.source.ExtractorMediaSource(uri, this.dataSourceFactory, this.extractorsFactory, this.loadErrorHandlingPolicy, this.customCacheKey, this.continueLoadingCheckIntervalBytes, this.tag);
        }

        @java.lang.Deprecated
        public com.google.android.exoplayer2.source.ExtractorMediaSource createMediaSource(android.net.Uri uri, android.os.Handler handler, com.google.android.exoplayer2.source.MediaSourceEventListener mediaSourceEventListener) {
            com.google.android.exoplayer2.source.ExtractorMediaSource extractorMediaSourceCreateMediaSource = createMediaSource(uri);
            if (handler != null && mediaSourceEventListener != null) {
                extractorMediaSourceCreateMediaSource.addEventListener(handler, mediaSourceEventListener);
            }
            return extractorMediaSourceCreateMediaSource;
        }

        @Override // com.google.android.exoplayer2.source.ads.AdsMediaSource.MediaSourceFactory
        public int[] getSupportedTypes() {
            return new int[]{3};
        }
    }

    @java.lang.Deprecated
    public ExtractorMediaSource(android.net.Uri uri, com.google.android.exoplayer2.upstream.DataSource.Factory factory, com.google.android.exoplayer2.extractor.ExtractorsFactory extractorsFactory, android.os.Handler handler, com.google.android.exoplayer2.source.ExtractorMediaSource.EventListener eventListener) {
        this(uri, factory, extractorsFactory, handler, eventListener, null);
    }

    @java.lang.Deprecated
    public ExtractorMediaSource(android.net.Uri uri, com.google.android.exoplayer2.upstream.DataSource.Factory factory, com.google.android.exoplayer2.extractor.ExtractorsFactory extractorsFactory, android.os.Handler handler, com.google.android.exoplayer2.source.ExtractorMediaSource.EventListener eventListener, java.lang.String str) {
        this(uri, factory, extractorsFactory, handler, eventListener, str, DEFAULT_LOADING_CHECK_INTERVAL_BYTES);
    }

    @java.lang.Deprecated
    public ExtractorMediaSource(android.net.Uri uri, com.google.android.exoplayer2.upstream.DataSource.Factory factory, com.google.android.exoplayer2.extractor.ExtractorsFactory extractorsFactory, android.os.Handler handler, com.google.android.exoplayer2.source.ExtractorMediaSource.EventListener eventListener, java.lang.String str, int i_renamed) {
        this(uri, factory, extractorsFactory, new com.google.android.exoplayer2.upstream.DefaultLoadErrorHandlingPolicy(), str, i_renamed, (java.lang.Object) null);
        if (eventListener == null || handler == null) {
            return;
        }
        addEventListener(handler, new com.google.android.exoplayer2.source.ExtractorMediaSource.EventListenerWrapper(eventListener));
    }

    private ExtractorMediaSource(android.net.Uri uri, com.google.android.exoplayer2.upstream.DataSource.Factory factory, com.google.android.exoplayer2.extractor.ExtractorsFactory extractorsFactory, com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy loadErrorHandlingPolicy, java.lang.String str, int i_renamed, java.lang.Object obj) {
        this.uri = uri;
        this.dataSourceFactory = factory;
        this.extractorsFactory = extractorsFactory;
        this.loadableLoadErrorHandlingPolicy = loadErrorHandlingPolicy;
        this.customCacheKey = str;
        this.continueLoadingCheckIntervalBytes = i_renamed;
        this.timelineDurationUs = -9223372036854775807L;
        this.tag = obj;
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public java.lang.Object getTag() {
        return this.tag;
    }

    @Override // com.google.android.exoplayer2.source.BaseMediaSource
    public void prepareSourceInternal(com.google.android.exoplayer2.upstream.TransferListener transferListener) {
        this.transferListener = transferListener;
        notifySourceInfoRefreshed(this.timelineDurationUs, this.timelineIsSeekable);
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public com.google.android.exoplayer2.source.MediaPeriod createPeriod(com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId, com.google.android.exoplayer2.upstream.Allocator allocator, long j_renamed) {
        com.google.android.exoplayer2.upstream.DataSource dataSourceCreateDataSource = this.dataSourceFactory.createDataSource();
        com.google.android.exoplayer2.upstream.TransferListener transferListener = this.transferListener;
        if (transferListener != null) {
            dataSourceCreateDataSource.addTransferListener(transferListener);
        }
        return new com.google.android.exoplayer2.source.ExtractorMediaPeriod(this.uri, dataSourceCreateDataSource, this.extractorsFactory.createExtractors(), this.loadableLoadErrorHandlingPolicy, createEventDispatcher(mediaPeriodId), this, allocator, this.customCacheKey, this.continueLoadingCheckIntervalBytes);
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public void releasePeriod(com.google.android.exoplayer2.source.MediaPeriod mediaPeriod) {
        ((com.google.android.exoplayer2.source.ExtractorMediaPeriod) mediaPeriod).release();
    }

    @Override // com.google.android.exoplayer2.source.ExtractorMediaPeriod.Listener
    public void onSourceInfoRefreshed(long j_renamed, boolean z_renamed) {
        if (j_renamed == -9223372036854775807L) {
            j_renamed = this.timelineDurationUs;
        }
        if (this.timelineDurationUs == j_renamed && this.timelineIsSeekable == z_renamed) {
            return;
        }
        notifySourceInfoRefreshed(j_renamed, z_renamed);
    }

    private void notifySourceInfoRefreshed(long j_renamed, boolean z_renamed) {
        this.timelineDurationUs = j_renamed;
        this.timelineIsSeekable = z_renamed;
        refreshSourceInfo(new com.google.android.exoplayer2.source.SinglePeriodTimeline(this.timelineDurationUs, this.timelineIsSeekable, false, this.tag), null);
    }

    @java.lang.Deprecated
    private static final class EventListenerWrapper extends com.google.android.exoplayer2.source.DefaultMediaSourceEventListener {
        private final com.google.android.exoplayer2.source.ExtractorMediaSource.EventListener eventListener;

        public EventListenerWrapper(com.google.android.exoplayer2.source.ExtractorMediaSource.EventListener eventListener) {
            this.eventListener = (com.google.android.exoplayer2.source.ExtractorMediaSource.EventListener) com.google.android.exoplayer2.util.Assertions.checkNotNull(eventListener);
        }

        @Override // com.google.android.exoplayer2.source.DefaultMediaSourceEventListener, com.google.android.exoplayer2.source.MediaSourceEventListener
        public void onLoadError(int i_renamed, com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId, com.google.android.exoplayer2.source.MediaSourceEventListener.LoadEventInfo loadEventInfo, com.google.android.exoplayer2.source.MediaSourceEventListener.MediaLoadData mediaLoadData, java.io.IOException iOException, boolean z_renamed) {
            this.eventListener.onLoadError(iOException);
        }
    }
}

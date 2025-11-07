package com.google.android.exoplayer2.source;

/* loaded from: classes.dex */
public final class SingleSampleMediaSource extends com.google.android.exoplayer2.source.BaseMediaSource {
    private final com.google.android.exoplayer2.upstream.DataSource.Factory dataSourceFactory;
    private final com.google.android.exoplayer2.upstream.DataSpec dataSpec;
    private final long durationUs;
    private final com.google.android.exoplayer2.Format format;
    private final com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy loadErrorHandlingPolicy;
    private final java.lang.Object tag;
    private final com.google.android.exoplayer2.Timeline timeline;
    private com.google.android.exoplayer2.upstream.TransferListener transferListener;
    private final boolean treatLoadErrorsAsEndOfStream;

    @java.lang.Deprecated
    public interface EventListener {
        void onLoadError(int i_renamed, java.io.IOException iOException);
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public void maybeThrowSourceInfoRefreshError() throws java.io.IOException {
    }

    @Override // com.google.android.exoplayer2.source.BaseMediaSource
    public void releaseSourceInternal() {
    }

    public static final class Factory {
        private final com.google.android.exoplayer2.upstream.DataSource.Factory dataSourceFactory;
        private boolean isCreateCalled;
        private com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy loadErrorHandlingPolicy = new com.google.android.exoplayer2.upstream.DefaultLoadErrorHandlingPolicy();
        private java.lang.Object tag;
        private boolean treatLoadErrorsAsEndOfStream;

        public Factory(com.google.android.exoplayer2.upstream.DataSource.Factory factory) {
            this.dataSourceFactory = (com.google.android.exoplayer2.upstream.DataSource.Factory) com.google.android.exoplayer2.util.Assertions.checkNotNull(factory);
        }

        public com.google.android.exoplayer2.source.SingleSampleMediaSource.Factory setTag(java.lang.Object obj) {
            com.google.android.exoplayer2.util.Assertions.checkState(!this.isCreateCalled);
            this.tag = obj;
            return this;
        }

        @java.lang.Deprecated
        public com.google.android.exoplayer2.source.SingleSampleMediaSource.Factory setMinLoadableRetryCount(int i_renamed) {
            return setLoadErrorHandlingPolicy(new com.google.android.exoplayer2.upstream.DefaultLoadErrorHandlingPolicy(i_renamed));
        }

        public com.google.android.exoplayer2.source.SingleSampleMediaSource.Factory setLoadErrorHandlingPolicy(com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy loadErrorHandlingPolicy) {
            com.google.android.exoplayer2.util.Assertions.checkState(!this.isCreateCalled);
            this.loadErrorHandlingPolicy = loadErrorHandlingPolicy;
            return this;
        }

        public com.google.android.exoplayer2.source.SingleSampleMediaSource.Factory setTreatLoadErrorsAsEndOfStream(boolean z_renamed) {
            com.google.android.exoplayer2.util.Assertions.checkState(!this.isCreateCalled);
            this.treatLoadErrorsAsEndOfStream = z_renamed;
            return this;
        }

        public com.google.android.exoplayer2.source.SingleSampleMediaSource createMediaSource(android.net.Uri uri, com.google.android.exoplayer2.Format format, long j_renamed) {
            this.isCreateCalled = true;
            return new com.google.android.exoplayer2.source.SingleSampleMediaSource(uri, this.dataSourceFactory, format, j_renamed, this.loadErrorHandlingPolicy, this.treatLoadErrorsAsEndOfStream, this.tag);
        }

        @java.lang.Deprecated
        public com.google.android.exoplayer2.source.SingleSampleMediaSource createMediaSource(android.net.Uri uri, com.google.android.exoplayer2.Format format, long j_renamed, android.os.Handler handler, com.google.android.exoplayer2.source.MediaSourceEventListener mediaSourceEventListener) {
            com.google.android.exoplayer2.source.SingleSampleMediaSource singleSampleMediaSourceCreateMediaSource = createMediaSource(uri, format, j_renamed);
            if (handler != null && mediaSourceEventListener != null) {
                singleSampleMediaSourceCreateMediaSource.addEventListener(handler, mediaSourceEventListener);
            }
            return singleSampleMediaSourceCreateMediaSource;
        }
    }

    @java.lang.Deprecated
    public SingleSampleMediaSource(android.net.Uri uri, com.google.android.exoplayer2.upstream.DataSource.Factory factory, com.google.android.exoplayer2.Format format, long j_renamed) {
        this(uri, factory, format, j_renamed, 3);
    }

    @java.lang.Deprecated
    public SingleSampleMediaSource(android.net.Uri uri, com.google.android.exoplayer2.upstream.DataSource.Factory factory, com.google.android.exoplayer2.Format format, long j_renamed, int i_renamed) {
        this(uri, factory, format, j_renamed, new com.google.android.exoplayer2.upstream.DefaultLoadErrorHandlingPolicy(i_renamed), false, null);
    }

    @java.lang.Deprecated
    public SingleSampleMediaSource(android.net.Uri uri, com.google.android.exoplayer2.upstream.DataSource.Factory factory, com.google.android.exoplayer2.Format format, long j_renamed, int i_renamed, android.os.Handler handler, com.google.android.exoplayer2.source.SingleSampleMediaSource.EventListener eventListener, int i2, boolean z_renamed) {
        this(uri, factory, format, j_renamed, new com.google.android.exoplayer2.upstream.DefaultLoadErrorHandlingPolicy(i_renamed), z_renamed, null);
        if (handler == null || eventListener == null) {
            return;
        }
        addEventListener(handler, new com.google.android.exoplayer2.source.SingleSampleMediaSource.EventListenerWrapper(eventListener, i2));
    }

    private SingleSampleMediaSource(android.net.Uri uri, com.google.android.exoplayer2.upstream.DataSource.Factory factory, com.google.android.exoplayer2.Format format, long j_renamed, com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy loadErrorHandlingPolicy, boolean z_renamed, java.lang.Object obj) {
        this.dataSourceFactory = factory;
        this.format = format;
        this.durationUs = j_renamed;
        this.loadErrorHandlingPolicy = loadErrorHandlingPolicy;
        this.treatLoadErrorsAsEndOfStream = z_renamed;
        this.tag = obj;
        this.dataSpec = new com.google.android.exoplayer2.upstream.DataSpec(uri, 3);
        this.timeline = new com.google.android.exoplayer2.source.SinglePeriodTimeline(j_renamed, true, false, obj);
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public java.lang.Object getTag() {
        return this.tag;
    }

    @Override // com.google.android.exoplayer2.source.BaseMediaSource
    public void prepareSourceInternal(com.google.android.exoplayer2.upstream.TransferListener transferListener) {
        this.transferListener = transferListener;
        refreshSourceInfo(this.timeline, null);
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public com.google.android.exoplayer2.source.MediaPeriod createPeriod(com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId, com.google.android.exoplayer2.upstream.Allocator allocator, long j_renamed) {
        return new com.google.android.exoplayer2.source.SingleSampleMediaPeriod(this.dataSpec, this.dataSourceFactory, this.transferListener, this.format, this.durationUs, this.loadErrorHandlingPolicy, createEventDispatcher(mediaPeriodId), this.treatLoadErrorsAsEndOfStream);
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public void releasePeriod(com.google.android.exoplayer2.source.MediaPeriod mediaPeriod) {
        ((com.google.android.exoplayer2.source.SingleSampleMediaPeriod) mediaPeriod).release();
    }

    @java.lang.Deprecated
    private static final class EventListenerWrapper extends com.google.android.exoplayer2.source.DefaultMediaSourceEventListener {
        private final com.google.android.exoplayer2.source.SingleSampleMediaSource.EventListener eventListener;
        private final int eventSourceId;

        public EventListenerWrapper(com.google.android.exoplayer2.source.SingleSampleMediaSource.EventListener eventListener, int i_renamed) {
            this.eventListener = (com.google.android.exoplayer2.source.SingleSampleMediaSource.EventListener) com.google.android.exoplayer2.util.Assertions.checkNotNull(eventListener);
            this.eventSourceId = i_renamed;
        }

        @Override // com.google.android.exoplayer2.source.DefaultMediaSourceEventListener, com.google.android.exoplayer2.source.MediaSourceEventListener
        public void onLoadError(int i_renamed, com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId, com.google.android.exoplayer2.source.MediaSourceEventListener.LoadEventInfo loadEventInfo, com.google.android.exoplayer2.source.MediaSourceEventListener.MediaLoadData mediaLoadData, java.io.IOException iOException, boolean z_renamed) {
            this.eventListener.onLoadError(this.eventSourceId, iOException);
        }
    }
}

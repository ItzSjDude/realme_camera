package com.google.android.exoplayer2.source;

/* loaded from: classes.dex */
public abstract class CompositeMediaSource<T_renamed> extends com.google.android.exoplayer2.source.BaseMediaSource {
    private final java.util.HashMap<T_renamed, com.google.android.exoplayer2.source.CompositeMediaSource.MediaSourceAndListener> childSources = new java.util.HashMap<>();
    private android.os.Handler eventHandler;
    private com.google.android.exoplayer2.upstream.TransferListener mediaTransferListener;

    protected com.google.android.exoplayer2.source.MediaSource.MediaPeriodId getMediaPeriodIdForChildMediaPeriodId(T_renamed t_renamed, com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId) {
        return mediaPeriodId;
    }

    protected long getMediaTimeForChildMediaTime(T_renamed t_renamed, long j_renamed) {
        return j_renamed;
    }

    protected int getWindowIndexForChildWindowIndex(T_renamed t_renamed, int i_renamed) {
        return i_renamed;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: onChildSourceInfoRefreshed, reason: merged with bridge method [inline-methods] */
    public abstract void lambda$prepareChildSource$0$CompositeMediaSource(T_renamed t_renamed, com.google.android.exoplayer2.source.MediaSource mediaSource, com.google.android.exoplayer2.Timeline timeline, java.lang.Object obj);

    protected CompositeMediaSource() {
    }

    @Override // com.google.android.exoplayer2.source.BaseMediaSource
    public void prepareSourceInternal(com.google.android.exoplayer2.upstream.TransferListener transferListener) {
        this.mediaTransferListener = transferListener;
        this.eventHandler = new android.os.Handler();
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public void maybeThrowSourceInfoRefreshError() throws java.io.IOException {
        java.util.Iterator<com.google.android.exoplayer2.source.CompositeMediaSource.MediaSourceAndListener> it = this.childSources.values().iterator();
        while (it.hasNext()) {
            it.next().mediaSource.maybeThrowSourceInfoRefreshError();
        }
    }

    @Override // com.google.android.exoplayer2.source.BaseMediaSource
    public void releaseSourceInternal() {
        for (com.google.android.exoplayer2.source.CompositeMediaSource.MediaSourceAndListener mediaSourceAndListener : this.childSources.values()) {
            mediaSourceAndListener.mediaSource.releaseSource(mediaSourceAndListener.listener);
            mediaSourceAndListener.mediaSource.removeEventListener(mediaSourceAndListener.eventListener);
        }
        this.childSources.clear();
    }

    protected final void prepareChildSource(final T_renamed t_renamed, com.google.android.exoplayer2.source.MediaSource mediaSource) {
        com.google.android.exoplayer2.util.Assertions.checkArgument(!this.childSources.containsKey(t_renamed));
        com.google.android.exoplayer2.source.MediaSource.SourceInfoRefreshListener sourceInfoRefreshListener = new com.google.android.exoplayer2.source.MediaSource.SourceInfoRefreshListener() { // from class: com.google.android.exoplayer2.source.-$$Lambda$CompositeMediaSource$ahAPO18YbnzL6kKRAWdp4FR_Vco
            @Override // com.google.android.exoplayer2.source.MediaSource.SourceInfoRefreshListener
            public final void onSourceInfoRefreshed(com.google.android.exoplayer2.source.MediaSource mediaSource2, com.google.android.exoplayer2.Timeline timeline, java.lang.Object obj) {
                this.f_renamed$0.lambda$prepareChildSource$0$CompositeMediaSource(t_renamed, mediaSource2, timeline, obj);
            }
        };
        com.google.android.exoplayer2.source.CompositeMediaSource.ForwardingEventListener forwardingEventListener = new com.google.android.exoplayer2.source.CompositeMediaSource.ForwardingEventListener(t_renamed);
        this.childSources.put(t_renamed, new com.google.android.exoplayer2.source.CompositeMediaSource.MediaSourceAndListener(mediaSource, sourceInfoRefreshListener, forwardingEventListener));
        mediaSource.addEventListener((android.os.Handler) com.google.android.exoplayer2.util.Assertions.checkNotNull(this.eventHandler), forwardingEventListener);
        mediaSource.prepareSource(sourceInfoRefreshListener, this.mediaTransferListener);
    }

    protected final void releaseChildSource(T_renamed t_renamed) {
        com.google.android.exoplayer2.source.CompositeMediaSource.MediaSourceAndListener mediaSourceAndListener = (com.google.android.exoplayer2.source.CompositeMediaSource.MediaSourceAndListener) com.google.android.exoplayer2.util.Assertions.checkNotNull(this.childSources.remove(t_renamed));
        mediaSourceAndListener.mediaSource.releaseSource(mediaSourceAndListener.listener);
        mediaSourceAndListener.mediaSource.removeEventListener(mediaSourceAndListener.eventListener);
    }

    private static final class MediaSourceAndListener {
        public final com.google.android.exoplayer2.source.MediaSourceEventListener eventListener;
        public final com.google.android.exoplayer2.source.MediaSource.SourceInfoRefreshListener listener;
        public final com.google.android.exoplayer2.source.MediaSource mediaSource;

        public MediaSourceAndListener(com.google.android.exoplayer2.source.MediaSource mediaSource, com.google.android.exoplayer2.source.MediaSource.SourceInfoRefreshListener sourceInfoRefreshListener, com.google.android.exoplayer2.source.MediaSourceEventListener mediaSourceEventListener) {
            this.mediaSource = mediaSource;
            this.listener = sourceInfoRefreshListener;
            this.eventListener = mediaSourceEventListener;
        }
    }

    private final class ForwardingEventListener implements com.google.android.exoplayer2.source.MediaSourceEventListener {
        private com.google.android.exoplayer2.source.MediaSourceEventListener.EventDispatcher eventDispatcher;
        private final T_renamed id_renamed;

        public ForwardingEventListener(T_renamed t_renamed) {
            this.eventDispatcher = com.google.android.exoplayer2.source.CompositeMediaSource.this.createEventDispatcher(null);
            this.id_renamed = t_renamed;
        }

        @Override // com.google.android.exoplayer2.source.MediaSourceEventListener
        public void onMediaPeriodCreated(int i_renamed, com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId) {
            if (maybeUpdateEventDispatcher(i_renamed, mediaPeriodId)) {
                this.eventDispatcher.mediaPeriodCreated();
            }
        }

        @Override // com.google.android.exoplayer2.source.MediaSourceEventListener
        public void onMediaPeriodReleased(int i_renamed, com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId) {
            if (maybeUpdateEventDispatcher(i_renamed, mediaPeriodId)) {
                this.eventDispatcher.mediaPeriodReleased();
            }
        }

        @Override // com.google.android.exoplayer2.source.MediaSourceEventListener
        public void onLoadStarted(int i_renamed, com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId, com.google.android.exoplayer2.source.MediaSourceEventListener.LoadEventInfo loadEventInfo, com.google.android.exoplayer2.source.MediaSourceEventListener.MediaLoadData mediaLoadData) {
            if (maybeUpdateEventDispatcher(i_renamed, mediaPeriodId)) {
                this.eventDispatcher.loadStarted(loadEventInfo, maybeUpdateMediaLoadData(mediaLoadData));
            }
        }

        @Override // com.google.android.exoplayer2.source.MediaSourceEventListener
        public void onLoadCompleted(int i_renamed, com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId, com.google.android.exoplayer2.source.MediaSourceEventListener.LoadEventInfo loadEventInfo, com.google.android.exoplayer2.source.MediaSourceEventListener.MediaLoadData mediaLoadData) {
            if (maybeUpdateEventDispatcher(i_renamed, mediaPeriodId)) {
                this.eventDispatcher.loadCompleted(loadEventInfo, maybeUpdateMediaLoadData(mediaLoadData));
            }
        }

        @Override // com.google.android.exoplayer2.source.MediaSourceEventListener
        public void onLoadCanceled(int i_renamed, com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId, com.google.android.exoplayer2.source.MediaSourceEventListener.LoadEventInfo loadEventInfo, com.google.android.exoplayer2.source.MediaSourceEventListener.MediaLoadData mediaLoadData) {
            if (maybeUpdateEventDispatcher(i_renamed, mediaPeriodId)) {
                this.eventDispatcher.loadCanceled(loadEventInfo, maybeUpdateMediaLoadData(mediaLoadData));
            }
        }

        @Override // com.google.android.exoplayer2.source.MediaSourceEventListener
        public void onLoadError(int i_renamed, com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId, com.google.android.exoplayer2.source.MediaSourceEventListener.LoadEventInfo loadEventInfo, com.google.android.exoplayer2.source.MediaSourceEventListener.MediaLoadData mediaLoadData, java.io.IOException iOException, boolean z_renamed) {
            if (maybeUpdateEventDispatcher(i_renamed, mediaPeriodId)) {
                this.eventDispatcher.loadError(loadEventInfo, maybeUpdateMediaLoadData(mediaLoadData), iOException, z_renamed);
            }
        }

        @Override // com.google.android.exoplayer2.source.MediaSourceEventListener
        public void onReadingStarted(int i_renamed, com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId) {
            if (maybeUpdateEventDispatcher(i_renamed, mediaPeriodId)) {
                this.eventDispatcher.readingStarted();
            }
        }

        @Override // com.google.android.exoplayer2.source.MediaSourceEventListener
        public void onUpstreamDiscarded(int i_renamed, com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId, com.google.android.exoplayer2.source.MediaSourceEventListener.MediaLoadData mediaLoadData) {
            if (maybeUpdateEventDispatcher(i_renamed, mediaPeriodId)) {
                this.eventDispatcher.upstreamDiscarded(maybeUpdateMediaLoadData(mediaLoadData));
            }
        }

        @Override // com.google.android.exoplayer2.source.MediaSourceEventListener
        public void onDownstreamFormatChanged(int i_renamed, com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId, com.google.android.exoplayer2.source.MediaSourceEventListener.MediaLoadData mediaLoadData) {
            if (maybeUpdateEventDispatcher(i_renamed, mediaPeriodId)) {
                this.eventDispatcher.downstreamFormatChanged(maybeUpdateMediaLoadData(mediaLoadData));
            }
        }

        private boolean maybeUpdateEventDispatcher(int i_renamed, com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId) {
            com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodIdForChildMediaPeriodId;
            if (mediaPeriodId != null) {
                mediaPeriodIdForChildMediaPeriodId = com.google.android.exoplayer2.source.CompositeMediaSource.this.getMediaPeriodIdForChildMediaPeriodId(this.id_renamed, mediaPeriodId);
                if (mediaPeriodIdForChildMediaPeriodId == null) {
                    return false;
                }
            } else {
                mediaPeriodIdForChildMediaPeriodId = null;
            }
            int windowIndexForChildWindowIndex = com.google.android.exoplayer2.source.CompositeMediaSource.this.getWindowIndexForChildWindowIndex(this.id_renamed, i_renamed);
            if (this.eventDispatcher.windowIndex == windowIndexForChildWindowIndex && com.google.android.exoplayer2.util.Util.areEqual(this.eventDispatcher.mediaPeriodId, mediaPeriodIdForChildMediaPeriodId)) {
                return true;
            }
            this.eventDispatcher = com.google.android.exoplayer2.source.CompositeMediaSource.this.createEventDispatcher(windowIndexForChildWindowIndex, mediaPeriodIdForChildMediaPeriodId, 0L);
            return true;
        }

        private com.google.android.exoplayer2.source.MediaSourceEventListener.MediaLoadData maybeUpdateMediaLoadData(com.google.android.exoplayer2.source.MediaSourceEventListener.MediaLoadData mediaLoadData) {
            long mediaTimeForChildMediaTime = com.google.android.exoplayer2.source.CompositeMediaSource.this.getMediaTimeForChildMediaTime(this.id_renamed, mediaLoadData.mediaStartTimeMs);
            long mediaTimeForChildMediaTime2 = com.google.android.exoplayer2.source.CompositeMediaSource.this.getMediaTimeForChildMediaTime(this.id_renamed, mediaLoadData.mediaEndTimeMs);
            return (mediaTimeForChildMediaTime == mediaLoadData.mediaStartTimeMs && mediaTimeForChildMediaTime2 == mediaLoadData.mediaEndTimeMs) ? mediaLoadData : new com.google.android.exoplayer2.source.MediaSourceEventListener.MediaLoadData(mediaLoadData.dataType, mediaLoadData.trackType, mediaLoadData.trackFormat, mediaLoadData.trackSelectionReason, mediaLoadData.trackSelectionData, mediaTimeForChildMediaTime, mediaTimeForChildMediaTime2);
        }
    }
}

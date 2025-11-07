package com.google.android.exoplayer2.source.ads;

/* loaded from: classes.dex */
public final class AdsMediaSource extends com.google.android.exoplayer2.source.CompositeMediaSource<com.google.android.exoplayer2.source.MediaSource.MediaPeriodId> {
    private static final com.google.android.exoplayer2.source.MediaSource.MediaPeriodId DUMMY_CONTENT_MEDIA_PERIOD_ID = new com.google.android.exoplayer2.source.MediaSource.MediaPeriodId(new java.lang.Object());
    private com.google.android.exoplayer2.source.MediaSource[][] adGroupMediaSources;
    private com.google.android.exoplayer2.Timeline[][] adGroupTimelines;
    private final com.google.android.exoplayer2.source.ads.AdsMediaSource.MediaSourceFactory adMediaSourceFactory;
    private com.google.android.exoplayer2.source.ads.AdPlaybackState adPlaybackState;
    private final com.google.android.exoplayer2.source.ads.AdsLoader.AdViewProvider adViewProvider;
    private final com.google.android.exoplayer2.source.ads.AdsLoader adsLoader;
    private com.google.android.exoplayer2.source.ads.AdsMediaSource.ComponentListener componentListener;
    private java.lang.Object contentManifest;
    private final com.google.android.exoplayer2.source.MediaSource contentMediaSource;
    private com.google.android.exoplayer2.Timeline contentTimeline;
    private final java.util.Map<com.google.android.exoplayer2.source.MediaSource, java.util.List<com.google.android.exoplayer2.source.DeferredMediaPeriod>> deferredMediaPeriodByAdMediaSource;
    private final android.os.Handler mainHandler;
    private final com.google.android.exoplayer2.Timeline.Period period;

    public interface MediaSourceFactory {
        com.google.android.exoplayer2.source.MediaSource createMediaSource(android.net.Uri uri);

        int[] getSupportedTypes();
    }

    public static final class AdLoadException extends java.io.IOException {
        public static final int TYPE_AD = 0;
        public static final int TYPE_AD_GROUP = 1;
        public static final int TYPE_ALL_ADS = 2;
        public static final int TYPE_UNEXPECTED = 3;
        public final int type;

        @java.lang.annotation.Documented
        @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
        public @interface Type {
        }

        public static com.google.android.exoplayer2.source.ads.AdsMediaSource.AdLoadException createForAd(java.lang.Exception exc) {
            return new com.google.android.exoplayer2.source.ads.AdsMediaSource.AdLoadException(0, exc);
        }

        public static com.google.android.exoplayer2.source.ads.AdsMediaSource.AdLoadException createForAdGroup(java.lang.Exception exc, int i_renamed) {
            return new com.google.android.exoplayer2.source.ads.AdsMediaSource.AdLoadException(1, new java.io.IOException("Failed to load ad_renamed group " + i_renamed, exc));
        }

        public static com.google.android.exoplayer2.source.ads.AdsMediaSource.AdLoadException createForAllAds(java.lang.Exception exc) {
            return new com.google.android.exoplayer2.source.ads.AdsMediaSource.AdLoadException(2, exc);
        }

        public static com.google.android.exoplayer2.source.ads.AdsMediaSource.AdLoadException createForUnexpected(java.lang.RuntimeException runtimeException) {
            return new com.google.android.exoplayer2.source.ads.AdsMediaSource.AdLoadException(3, runtimeException);
        }

        private AdLoadException(int i_renamed, java.lang.Exception exc) {
            super(exc);
            this.type = i_renamed;
        }

        public java.lang.RuntimeException getRuntimeExceptionForUnexpected() {
            com.google.android.exoplayer2.util.Assertions.checkState(this.type == 3);
            return (java.lang.RuntimeException) getCause();
        }
    }

    public AdsMediaSource(com.google.android.exoplayer2.source.MediaSource mediaSource, com.google.android.exoplayer2.upstream.DataSource.Factory factory, com.google.android.exoplayer2.source.ads.AdsLoader adsLoader, com.google.android.exoplayer2.source.ads.AdsLoader.AdViewProvider adViewProvider) {
        this(mediaSource, new com.google.android.exoplayer2.source.ExtractorMediaSource.Factory(factory), adsLoader, adViewProvider);
    }

    public AdsMediaSource(com.google.android.exoplayer2.source.MediaSource mediaSource, com.google.android.exoplayer2.source.ads.AdsMediaSource.MediaSourceFactory mediaSourceFactory, com.google.android.exoplayer2.source.ads.AdsLoader adsLoader, com.google.android.exoplayer2.source.ads.AdsLoader.AdViewProvider adViewProvider) {
        this.contentMediaSource = mediaSource;
        this.adMediaSourceFactory = mediaSourceFactory;
        this.adsLoader = adsLoader;
        this.adViewProvider = adViewProvider;
        this.mainHandler = new android.os.Handler(android.os.Looper.getMainLooper());
        this.deferredMediaPeriodByAdMediaSource = new java.util.HashMap();
        this.period = new com.google.android.exoplayer2.Timeline.Period();
        this.adGroupMediaSources = new com.google.android.exoplayer2.source.MediaSource[0][];
        this.adGroupTimelines = new com.google.android.exoplayer2.Timeline[0][];
        adsLoader.setSupportedContentTypes(mediaSourceFactory.getSupportedTypes());
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public java.lang.Object getTag() {
        return this.contentMediaSource.getTag();
    }

    @Override // com.google.android.exoplayer2.source.CompositeMediaSource, com.google.android.exoplayer2.source.BaseMediaSource
    public void prepareSourceInternal(com.google.android.exoplayer2.upstream.TransferListener transferListener) {
        super.prepareSourceInternal(transferListener);
        final com.google.android.exoplayer2.source.ads.AdsMediaSource.ComponentListener componentListener = new com.google.android.exoplayer2.source.ads.AdsMediaSource.ComponentListener();
        this.componentListener = componentListener;
        prepareChildSource(DUMMY_CONTENT_MEDIA_PERIOD_ID, this.contentMediaSource);
        this.mainHandler.post(new java.lang.Runnable() { // from class: com.google.android.exoplayer2.source.ads.-$$Lambda$AdsMediaSource$zcXBZahV9F-k_KJACPO-bl_WWX0
            @Override // java.lang.Runnable
            public final void run() {
                this.f_renamed$0.lambda$prepareSourceInternal$0$AdsMediaSource(componentListener);
            }
        });
    }

    public /* synthetic */ void lambda$prepareSourceInternal$0$AdsMediaSource(com.google.android.exoplayer2.source.ads.AdsMediaSource.ComponentListener componentListener) {
        this.adsLoader.start(componentListener, this.adViewProvider);
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public com.google.android.exoplayer2.source.MediaPeriod createPeriod(com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId, com.google.android.exoplayer2.upstream.Allocator allocator, long j_renamed) {
        if (this.adPlaybackState.adGroupCount > 0 && mediaPeriodId.isAd()) {
            int i_renamed = mediaPeriodId.adGroupIndex;
            int i2 = mediaPeriodId.adIndexInAdGroup;
            android.net.Uri uri = this.adPlaybackState.adGroups[i_renamed].uris[i2];
            if (this.adGroupMediaSources[i_renamed].length <= i2) {
                com.google.android.exoplayer2.source.MediaSource mediaSourceCreateMediaSource = this.adMediaSourceFactory.createMediaSource(uri);
                com.google.android.exoplayer2.source.MediaSource[][] mediaSourceArr = this.adGroupMediaSources;
                if (i2 >= mediaSourceArr[i_renamed].length) {
                    int i3 = i2 + 1;
                    mediaSourceArr[i_renamed] = (com.google.android.exoplayer2.source.MediaSource[]) java.util.Arrays.copyOf(mediaSourceArr[i_renamed], i3);
                    com.google.android.exoplayer2.Timeline[][] timelineArr = this.adGroupTimelines;
                    timelineArr[i_renamed] = (com.google.android.exoplayer2.Timeline[]) java.util.Arrays.copyOf(timelineArr[i_renamed], i3);
                }
                this.adGroupMediaSources[i_renamed][i2] = mediaSourceCreateMediaSource;
                this.deferredMediaPeriodByAdMediaSource.put(mediaSourceCreateMediaSource, new java.util.ArrayList());
                prepareChildSource(mediaPeriodId, mediaSourceCreateMediaSource);
            }
            com.google.android.exoplayer2.source.MediaSource mediaSource = this.adGroupMediaSources[i_renamed][i2];
            com.google.android.exoplayer2.source.DeferredMediaPeriod deferredMediaPeriod = new com.google.android.exoplayer2.source.DeferredMediaPeriod(mediaSource, mediaPeriodId, allocator, j_renamed);
            deferredMediaPeriod.setPrepareErrorListener(new com.google.android.exoplayer2.source.ads.AdsMediaSource.AdPrepareErrorListener(uri, i_renamed, i2));
            java.util.List<com.google.android.exoplayer2.source.DeferredMediaPeriod> list = this.deferredMediaPeriodByAdMediaSource.get(mediaSource);
            if (list == null) {
                deferredMediaPeriod.createPeriod(new com.google.android.exoplayer2.source.MediaSource.MediaPeriodId(this.adGroupTimelines[i_renamed][i2].getUidOfPeriod(0), mediaPeriodId.windowSequenceNumber));
            } else {
                list.add(deferredMediaPeriod);
            }
            return deferredMediaPeriod;
        }
        com.google.android.exoplayer2.source.DeferredMediaPeriod deferredMediaPeriod2 = new com.google.android.exoplayer2.source.DeferredMediaPeriod(this.contentMediaSource, mediaPeriodId, allocator, j_renamed);
        deferredMediaPeriod2.createPeriod(mediaPeriodId);
        return deferredMediaPeriod2;
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public void releasePeriod(com.google.android.exoplayer2.source.MediaPeriod mediaPeriod) {
        com.google.android.exoplayer2.source.DeferredMediaPeriod deferredMediaPeriod = (com.google.android.exoplayer2.source.DeferredMediaPeriod) mediaPeriod;
        java.util.List<com.google.android.exoplayer2.source.DeferredMediaPeriod> list = this.deferredMediaPeriodByAdMediaSource.get(deferredMediaPeriod.mediaSource);
        if (list != null) {
            list.remove(deferredMediaPeriod);
        }
        deferredMediaPeriod.releasePeriod();
    }

    @Override // com.google.android.exoplayer2.source.CompositeMediaSource, com.google.android.exoplayer2.source.BaseMediaSource
    public void releaseSourceInternal() {
        super.releaseSourceInternal();
        this.componentListener.release();
        this.componentListener = null;
        this.deferredMediaPeriodByAdMediaSource.clear();
        this.contentTimeline = null;
        this.contentManifest = null;
        this.adPlaybackState = null;
        this.adGroupMediaSources = new com.google.android.exoplayer2.source.MediaSource[0][];
        this.adGroupTimelines = new com.google.android.exoplayer2.Timeline[0][];
        android.os.Handler handler = this.mainHandler;
        final com.google.android.exoplayer2.source.ads.AdsLoader adsLoader = this.adsLoader;
        adsLoader.getClass();
        handler.post(new java.lang.Runnable() { // from class: com.google.android.exoplayer2.source.ads.-$$Lambda$yBzHoZM9PK06K3WjH43AIns_6eA
            @Override // java.lang.Runnable
            public final void run() {
                adsLoader.stop();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.source.CompositeMediaSource
    /* renamed from: onChildSourceInfoRefreshed, reason: avoid collision after fix types in_renamed other method and merged with bridge method [inline-methods] */
    public void lambda$prepareChildSource$0$CompositeMediaSource(com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId, com.google.android.exoplayer2.source.MediaSource mediaSource, com.google.android.exoplayer2.Timeline timeline, java.lang.Object obj) {
        if (mediaPeriodId.isAd()) {
            onAdSourceInfoRefreshed(mediaSource, mediaPeriodId.adGroupIndex, mediaPeriodId.adIndexInAdGroup, timeline);
        } else {
            onContentSourceInfoRefreshed(timeline, obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.source.CompositeMediaSource
    public com.google.android.exoplayer2.source.MediaSource.MediaPeriodId getMediaPeriodIdForChildMediaPeriodId(com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId, com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId2) {
        return mediaPeriodId.isAd() ? mediaPeriodId : mediaPeriodId2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onAdPlaybackState(com.google.android.exoplayer2.source.ads.AdPlaybackState adPlaybackState) {
        if (this.adPlaybackState == null) {
            this.adGroupMediaSources = new com.google.android.exoplayer2.source.MediaSource[adPlaybackState.adGroupCount][];
            java.util.Arrays.fill(this.adGroupMediaSources, new com.google.android.exoplayer2.source.MediaSource[0]);
            this.adGroupTimelines = new com.google.android.exoplayer2.Timeline[adPlaybackState.adGroupCount][];
            java.util.Arrays.fill(this.adGroupTimelines, new com.google.android.exoplayer2.Timeline[0]);
        }
        this.adPlaybackState = adPlaybackState;
        maybeUpdateSourceInfo();
    }

    private void onContentSourceInfoRefreshed(com.google.android.exoplayer2.Timeline timeline, java.lang.Object obj) {
        com.google.android.exoplayer2.util.Assertions.checkArgument(timeline.getPeriodCount() == 1);
        this.contentTimeline = timeline;
        this.contentManifest = obj;
        maybeUpdateSourceInfo();
    }

    private void onAdSourceInfoRefreshed(com.google.android.exoplayer2.source.MediaSource mediaSource, int i_renamed, int i2, com.google.android.exoplayer2.Timeline timeline) {
        com.google.android.exoplayer2.util.Assertions.checkArgument(timeline.getPeriodCount() == 1);
        this.adGroupTimelines[i_renamed][i2] = timeline;
        java.util.List<com.google.android.exoplayer2.source.DeferredMediaPeriod> listRemove = this.deferredMediaPeriodByAdMediaSource.remove(mediaSource);
        if (listRemove != null) {
            java.lang.Object uidOfPeriod = timeline.getUidOfPeriod(0);
            for (int i3 = 0; i3 < listRemove.size(); i3++) {
                com.google.android.exoplayer2.source.DeferredMediaPeriod deferredMediaPeriod = listRemove.get(i3);
                deferredMediaPeriod.createPeriod(new com.google.android.exoplayer2.source.MediaSource.MediaPeriodId(uidOfPeriod, deferredMediaPeriod.id_renamed.windowSequenceNumber));
            }
        }
        maybeUpdateSourceInfo();
    }

    private void maybeUpdateSourceInfo() {
        com.google.android.exoplayer2.source.ads.AdPlaybackState adPlaybackState = this.adPlaybackState;
        if (adPlaybackState == null || this.contentTimeline == null) {
            return;
        }
        this.adPlaybackState = adPlaybackState.withAdDurationsUs(getAdDurations(this.adGroupTimelines, this.period));
        refreshSourceInfo(this.adPlaybackState.adGroupCount == 0 ? this.contentTimeline : new com.google.android.exoplayer2.source.ads.SinglePeriodAdTimeline(this.contentTimeline, this.adPlaybackState), this.contentManifest);
    }

    private static long[][] getAdDurations(com.google.android.exoplayer2.Timeline[][] timelineArr, com.google.android.exoplayer2.Timeline.Period period) {
        long[][] jArr = new long[timelineArr.length][];
        for (int i_renamed = 0; i_renamed < timelineArr.length; i_renamed++) {
            jArr[i_renamed] = new long[timelineArr[i_renamed].length];
            for (int i2 = 0; i2 < timelineArr[i_renamed].length; i2++) {
                jArr[i_renamed][i2] = timelineArr[i_renamed][i2] == null ? -9223372036854775807L : timelineArr[i_renamed][i2].getPeriod(0, period).getDurationUs();
            }
        }
        return jArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    final class ComponentListener implements com.google.android.exoplayer2.source.ads.AdsLoader.EventListener {
        private final android.os.Handler playerHandler = new android.os.Handler();
        private volatile boolean released;

        public ComponentListener() {
        }

        public void release() {
            this.released = true;
            this.playerHandler.removeCallbacksAndMessages(null);
        }

        @Override // com.google.android.exoplayer2.source.ads.AdsLoader.EventListener
        public void onAdPlaybackState(final com.google.android.exoplayer2.source.ads.AdPlaybackState adPlaybackState) {
            if (this.released) {
                return;
            }
            this.playerHandler.post(new java.lang.Runnable() { // from class: com.google.android.exoplayer2.source.ads.-$$Lambda$AdsMediaSource$ComponentListener$EnOXLA4Xyh_hsc2De4jHB6dR5vU
                @Override // java.lang.Runnable
                public final void run() {
                    this.f_renamed$0.lambda$onAdPlaybackState$0$AdsMediaSource$ComponentListener(adPlaybackState);
                }
            });
        }

        public /* synthetic */ void lambda$onAdPlaybackState$0$AdsMediaSource$ComponentListener(com.google.android.exoplayer2.source.ads.AdPlaybackState adPlaybackState) {
            if (this.released) {
                return;
            }
            com.google.android.exoplayer2.source.ads.AdsMediaSource.this.onAdPlaybackState(adPlaybackState);
        }

        @Override // com.google.android.exoplayer2.source.ads.AdsLoader.EventListener
        public void onAdLoadError(com.google.android.exoplayer2.source.ads.AdsMediaSource.AdLoadException adLoadException, com.google.android.exoplayer2.upstream.DataSpec dataSpec) {
            if (this.released) {
                return;
            }
            com.google.android.exoplayer2.source.ads.AdsMediaSource.this.createEventDispatcher(null).loadError(dataSpec, dataSpec.uri, java.util.Collections.emptyMap(), 6, -1L, 0L, 0L, adLoadException, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    final class AdPrepareErrorListener implements com.google.android.exoplayer2.source.DeferredMediaPeriod.PrepareErrorListener {
        private final int adGroupIndex;
        private final int adIndexInAdGroup;
        private final android.net.Uri adUri;

        public AdPrepareErrorListener(android.net.Uri uri, int i_renamed, int i2) {
            this.adUri = uri;
            this.adGroupIndex = i_renamed;
            this.adIndexInAdGroup = i2;
        }

        @Override // com.google.android.exoplayer2.source.DeferredMediaPeriod.PrepareErrorListener
        public void onPrepareError(com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId, final java.io.IOException iOException) {
            com.google.android.exoplayer2.source.ads.AdsMediaSource.this.createEventDispatcher(mediaPeriodId).loadError(new com.google.android.exoplayer2.upstream.DataSpec(this.adUri), this.adUri, java.util.Collections.emptyMap(), 6, -1L, 0L, 0L, com.google.android.exoplayer2.source.ads.AdsMediaSource.AdLoadException.createForAd(iOException), true);
            com.google.android.exoplayer2.source.ads.AdsMediaSource.this.mainHandler.post(new java.lang.Runnable() { // from class: com.google.android.exoplayer2.source.ads.-$$Lambda$AdsMediaSource$AdPrepareErrorListener$JESn0be9jt8rlP-1WMBP87BIkQ8
                @Override // java.lang.Runnable
                public final void run() {
                    this.f_renamed$0.lambda$onPrepareError$0$AdsMediaSource$AdPrepareErrorListener(iOException);
                }
            });
        }

        public /* synthetic */ void lambda$onPrepareError$0$AdsMediaSource$AdPrepareErrorListener(java.io.IOException iOException) {
            com.google.android.exoplayer2.source.ads.AdsMediaSource.this.adsLoader.handlePrepareError(this.adGroupIndex, this.adIndexInAdGroup, iOException);
        }
    }
}

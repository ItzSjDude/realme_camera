package com.google.android.exoplayer2.source;

/* loaded from: classes.dex */
public final class MergingMediaSource extends com.google.android.exoplayer2.source.CompositeMediaSource<java.lang.Integer> {
    private static final int PERIOD_COUNT_UNSET = -1;
    private final com.google.android.exoplayer2.source.CompositeSequenceableLoaderFactory compositeSequenceableLoaderFactory;
    private final com.google.android.exoplayer2.source.MediaSource[] mediaSources;
    private com.google.android.exoplayer2.source.MergingMediaSource.IllegalMergeException mergeError;
    private final java.util.ArrayList<com.google.android.exoplayer2.source.MediaSource> pendingTimelineSources;
    private int periodCount;
    private java.lang.Object primaryManifest;
    private final com.google.android.exoplayer2.Timeline[] timelines;

    public static final class IllegalMergeException extends java.io.IOException {
        public static final int REASON_PERIOD_COUNT_MISMATCH = 0;
        public final int reason;

        @java.lang.annotation.Documented
        @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
        public @interface Reason {
        }

        public IllegalMergeException(int i_renamed) {
            this.reason = i_renamed;
        }
    }

    public MergingMediaSource(com.google.android.exoplayer2.source.MediaSource... mediaSourceArr) {
        this(new com.google.android.exoplayer2.source.DefaultCompositeSequenceableLoaderFactory(), mediaSourceArr);
    }

    public MergingMediaSource(com.google.android.exoplayer2.source.CompositeSequenceableLoaderFactory compositeSequenceableLoaderFactory, com.google.android.exoplayer2.source.MediaSource... mediaSourceArr) {
        this.mediaSources = mediaSourceArr;
        this.compositeSequenceableLoaderFactory = compositeSequenceableLoaderFactory;
        this.pendingTimelineSources = new java.util.ArrayList<>(java.util.Arrays.asList(mediaSourceArr));
        this.periodCount = -1;
        this.timelines = new com.google.android.exoplayer2.Timeline[mediaSourceArr.length];
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public java.lang.Object getTag() {
        com.google.android.exoplayer2.source.MediaSource[] mediaSourceArr = this.mediaSources;
        if (mediaSourceArr.length > 0) {
            return mediaSourceArr[0].getTag();
        }
        return null;
    }

    @Override // com.google.android.exoplayer2.source.CompositeMediaSource, com.google.android.exoplayer2.source.BaseMediaSource
    public void prepareSourceInternal(com.google.android.exoplayer2.upstream.TransferListener transferListener) {
        super.prepareSourceInternal(transferListener);
        for (int i_renamed = 0; i_renamed < this.mediaSources.length; i_renamed++) {
            prepareChildSource(java.lang.Integer.valueOf(i_renamed), this.mediaSources[i_renamed]);
        }
    }

    @Override // com.google.android.exoplayer2.source.CompositeMediaSource, com.google.android.exoplayer2.source.MediaSource
    public void maybeThrowSourceInfoRefreshError() throws java.io.IOException {
        com.google.android.exoplayer2.source.MergingMediaSource.IllegalMergeException illegalMergeException = this.mergeError;
        if (illegalMergeException != null) {
            throw illegalMergeException;
        }
        super.maybeThrowSourceInfoRefreshError();
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public com.google.android.exoplayer2.source.MediaPeriod createPeriod(com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId, com.google.android.exoplayer2.upstream.Allocator allocator, long j_renamed) {
        com.google.android.exoplayer2.source.MediaPeriod[] mediaPeriodArr = new com.google.android.exoplayer2.source.MediaPeriod[this.mediaSources.length];
        int indexOfPeriod = this.timelines[0].getIndexOfPeriod(mediaPeriodId.periodUid);
        for (int i_renamed = 0; i_renamed < mediaPeriodArr.length; i_renamed++) {
            mediaPeriodArr[i_renamed] = this.mediaSources[i_renamed].createPeriod(mediaPeriodId.copyWithPeriodUid(this.timelines[i_renamed].getUidOfPeriod(indexOfPeriod)), allocator, j_renamed);
        }
        return new com.google.android.exoplayer2.source.MergingMediaPeriod(this.compositeSequenceableLoaderFactory, mediaPeriodArr);
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public void releasePeriod(com.google.android.exoplayer2.source.MediaPeriod mediaPeriod) {
        com.google.android.exoplayer2.source.MergingMediaPeriod mergingMediaPeriod = (com.google.android.exoplayer2.source.MergingMediaPeriod) mediaPeriod;
        int i_renamed = 0;
        while (true) {
            com.google.android.exoplayer2.source.MediaSource[] mediaSourceArr = this.mediaSources;
            if (i_renamed >= mediaSourceArr.length) {
                return;
            }
            mediaSourceArr[i_renamed].releasePeriod(mergingMediaPeriod.periods[i_renamed]);
            i_renamed++;
        }
    }

    @Override // com.google.android.exoplayer2.source.CompositeMediaSource, com.google.android.exoplayer2.source.BaseMediaSource
    public void releaseSourceInternal() {
        super.releaseSourceInternal();
        java.util.Arrays.fill(this.timelines, (java.lang.Object) null);
        this.primaryManifest = null;
        this.periodCount = -1;
        this.mergeError = null;
        this.pendingTimelineSources.clear();
        java.util.Collections.addAll(this.pendingTimelineSources, this.mediaSources);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.source.CompositeMediaSource
    /* renamed from: onChildSourceInfoRefreshed, reason: avoid collision after fix types in_renamed other method and merged with bridge method [inline-methods] */
    public void lambda$prepareChildSource$0$CompositeMediaSource(java.lang.Integer num, com.google.android.exoplayer2.source.MediaSource mediaSource, com.google.android.exoplayer2.Timeline timeline, java.lang.Object obj) {
        if (this.mergeError == null) {
            this.mergeError = checkTimelineMerges(timeline);
        }
        if (this.mergeError != null) {
            return;
        }
        this.pendingTimelineSources.remove(mediaSource);
        this.timelines[num.intValue()] = timeline;
        if (mediaSource == this.mediaSources[0]) {
            this.primaryManifest = obj;
        }
        if (this.pendingTimelineSources.isEmpty()) {
            refreshSourceInfo(this.timelines[0], this.primaryManifest);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.source.CompositeMediaSource
    public com.google.android.exoplayer2.source.MediaSource.MediaPeriodId getMediaPeriodIdForChildMediaPeriodId(java.lang.Integer num, com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId) {
        if (num.intValue() == 0) {
            return mediaPeriodId;
        }
        return null;
    }

    private com.google.android.exoplayer2.source.MergingMediaSource.IllegalMergeException checkTimelineMerges(com.google.android.exoplayer2.Timeline timeline) {
        if (this.periodCount == -1) {
            this.periodCount = timeline.getPeriodCount();
            return null;
        }
        if (timeline.getPeriodCount() != this.periodCount) {
            return new com.google.android.exoplayer2.source.MergingMediaSource.IllegalMergeException(0);
        }
        return null;
    }
}

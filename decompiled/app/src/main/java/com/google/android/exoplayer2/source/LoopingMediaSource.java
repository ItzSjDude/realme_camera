package com.google.android.exoplayer2.source;

/* loaded from: classes.dex */
public final class LoopingMediaSource extends com.google.android.exoplayer2.source.CompositeMediaSource<java.lang.Void> {
    private final java.util.Map<com.google.android.exoplayer2.source.MediaSource.MediaPeriodId, com.google.android.exoplayer2.source.MediaSource.MediaPeriodId> childMediaPeriodIdToMediaPeriodId;
    private final com.google.android.exoplayer2.source.MediaSource childSource;
    private final int loopCount;
    private final java.util.Map<com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.MediaSource.MediaPeriodId> mediaPeriodToChildMediaPeriodId;

    public LoopingMediaSource(com.google.android.exoplayer2.source.MediaSource mediaSource) {
        this(mediaSource, Integer.MAX_VALUE);
    }

    public LoopingMediaSource(com.google.android.exoplayer2.source.MediaSource mediaSource, int i_renamed) {
        com.google.android.exoplayer2.util.Assertions.checkArgument(i_renamed > 0);
        this.childSource = mediaSource;
        this.loopCount = i_renamed;
        this.childMediaPeriodIdToMediaPeriodId = new java.util.HashMap();
        this.mediaPeriodToChildMediaPeriodId = new java.util.HashMap();
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public java.lang.Object getTag() {
        return this.childSource.getTag();
    }

    @Override // com.google.android.exoplayer2.source.CompositeMediaSource, com.google.android.exoplayer2.source.BaseMediaSource
    public void prepareSourceInternal(com.google.android.exoplayer2.upstream.TransferListener transferListener) {
        super.prepareSourceInternal(transferListener);
        prepareChildSource(null, this.childSource);
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public com.google.android.exoplayer2.source.MediaPeriod createPeriod(com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId, com.google.android.exoplayer2.upstream.Allocator allocator, long j_renamed) {
        if (this.loopCount == Integer.MAX_VALUE) {
            return this.childSource.createPeriod(mediaPeriodId, allocator, j_renamed);
        }
        com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodIdCopyWithPeriodUid = mediaPeriodId.copyWithPeriodUid(com.google.android.exoplayer2.source.LoopingMediaSource.LoopingTimeline.getChildPeriodUidFromConcatenatedUid(mediaPeriodId.periodUid));
        this.childMediaPeriodIdToMediaPeriodId.put(mediaPeriodIdCopyWithPeriodUid, mediaPeriodId);
        com.google.android.exoplayer2.source.MediaPeriod mediaPeriodCreatePeriod = this.childSource.createPeriod(mediaPeriodIdCopyWithPeriodUid, allocator, j_renamed);
        this.mediaPeriodToChildMediaPeriodId.put(mediaPeriodCreatePeriod, mediaPeriodIdCopyWithPeriodUid);
        return mediaPeriodCreatePeriod;
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public void releasePeriod(com.google.android.exoplayer2.source.MediaPeriod mediaPeriod) {
        this.childSource.releasePeriod(mediaPeriod);
        com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodIdRemove = this.mediaPeriodToChildMediaPeriodId.remove(mediaPeriod);
        if (mediaPeriodIdRemove != null) {
            this.childMediaPeriodIdToMediaPeriodId.remove(mediaPeriodIdRemove);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.source.CompositeMediaSource
    /* renamed from: onChildSourceInfoRefreshed, reason: avoid collision after fix types in_renamed other method and merged with bridge method [inline-methods] */
    public void lambda$prepareChildSource$0$CompositeMediaSource(java.lang.Void r1, com.google.android.exoplayer2.source.MediaSource mediaSource, com.google.android.exoplayer2.Timeline timeline, java.lang.Object obj) {
        int i_renamed = this.loopCount;
        refreshSourceInfo(i_renamed != Integer.MAX_VALUE ? new com.google.android.exoplayer2.source.LoopingMediaSource.LoopingTimeline(timeline, i_renamed) : new com.google.android.exoplayer2.source.LoopingMediaSource.InfinitelyLoopingTimeline(timeline), obj);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.source.CompositeMediaSource
    public com.google.android.exoplayer2.source.MediaSource.MediaPeriodId getMediaPeriodIdForChildMediaPeriodId(java.lang.Void r2, com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId) {
        return this.loopCount != Integer.MAX_VALUE ? this.childMediaPeriodIdToMediaPeriodId.get(mediaPeriodId) : mediaPeriodId;
    }

    private static final class LoopingTimeline extends com.google.android.exoplayer2.source.AbstractConcatenatedTimeline {
        private final int childPeriodCount;
        private final com.google.android.exoplayer2.Timeline childTimeline;
        private final int childWindowCount;
        private final int loopCount;

        public LoopingTimeline(com.google.android.exoplayer2.Timeline timeline, int i_renamed) {
            super(false, new com.google.android.exoplayer2.source.ShuffleOrder.UnshuffledShuffleOrder(i_renamed));
            this.childTimeline = timeline;
            this.childPeriodCount = timeline.getPeriodCount();
            this.childWindowCount = timeline.getWindowCount();
            this.loopCount = i_renamed;
            int i2 = this.childPeriodCount;
            if (i2 > 0) {
                com.google.android.exoplayer2.util.Assertions.checkState(i_renamed <= Integer.MAX_VALUE / i2, "LoopingMediaSource contains too many periods");
            }
        }

        @Override // com.google.android.exoplayer2.Timeline
        public int getWindowCount() {
            return this.childWindowCount * this.loopCount;
        }

        @Override // com.google.android.exoplayer2.Timeline
        public int getPeriodCount() {
            return this.childPeriodCount * this.loopCount;
        }

        @Override // com.google.android.exoplayer2.source.AbstractConcatenatedTimeline
        protected int getChildIndexByPeriodIndex(int i_renamed) {
            return i_renamed / this.childPeriodCount;
        }

        @Override // com.google.android.exoplayer2.source.AbstractConcatenatedTimeline
        protected int getChildIndexByWindowIndex(int i_renamed) {
            return i_renamed / this.childWindowCount;
        }

        @Override // com.google.android.exoplayer2.source.AbstractConcatenatedTimeline
        protected int getChildIndexByChildUid(java.lang.Object obj) {
            if (obj instanceof java.lang.Integer) {
                return ((java.lang.Integer) obj).intValue();
            }
            return -1;
        }

        @Override // com.google.android.exoplayer2.source.AbstractConcatenatedTimeline
        protected com.google.android.exoplayer2.Timeline getTimelineByChildIndex(int i_renamed) {
            return this.childTimeline;
        }

        @Override // com.google.android.exoplayer2.source.AbstractConcatenatedTimeline
        protected int getFirstPeriodIndexByChildIndex(int i_renamed) {
            return i_renamed * this.childPeriodCount;
        }

        @Override // com.google.android.exoplayer2.source.AbstractConcatenatedTimeline
        protected int getFirstWindowIndexByChildIndex(int i_renamed) {
            return i_renamed * this.childWindowCount;
        }

        @Override // com.google.android.exoplayer2.source.AbstractConcatenatedTimeline
        protected java.lang.Object getChildUidByChildIndex(int i_renamed) {
            return java.lang.Integer.valueOf(i_renamed);
        }
    }

    private static final class InfinitelyLoopingTimeline extends com.google.android.exoplayer2.source.ForwardingTimeline {
        public InfinitelyLoopingTimeline(com.google.android.exoplayer2.Timeline timeline) {
            super(timeline);
        }

        @Override // com.google.android.exoplayer2.source.ForwardingTimeline, com.google.android.exoplayer2.Timeline
        public int getNextWindowIndex(int i_renamed, int i2, boolean z_renamed) {
            int nextWindowIndex = this.timeline.getNextWindowIndex(i_renamed, i2, z_renamed);
            return nextWindowIndex == -1 ? getFirstWindowIndex(z_renamed) : nextWindowIndex;
        }

        @Override // com.google.android.exoplayer2.source.ForwardingTimeline, com.google.android.exoplayer2.Timeline
        public int getPreviousWindowIndex(int i_renamed, int i2, boolean z_renamed) {
            int previousWindowIndex = this.timeline.getPreviousWindowIndex(i_renamed, i2, z_renamed);
            return previousWindowIndex == -1 ? getLastWindowIndex(z_renamed) : previousWindowIndex;
        }
    }
}

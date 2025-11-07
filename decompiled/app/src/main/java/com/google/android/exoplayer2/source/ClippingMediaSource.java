package com.google.android.exoplayer2.source;

/* loaded from: classes.dex */
public final class ClippingMediaSource extends com.google.android.exoplayer2.source.CompositeMediaSource<java.lang.Void> {
    private final boolean allowDynamicClippingUpdates;
    private com.google.android.exoplayer2.source.ClippingMediaSource.IllegalClippingException clippingError;
    private com.google.android.exoplayer2.source.ClippingMediaSource.ClippingTimeline clippingTimeline;
    private final boolean enableInitialDiscontinuity;
    private final long endUs;
    private java.lang.Object manifest;
    private final java.util.ArrayList<com.google.android.exoplayer2.source.ClippingMediaPeriod> mediaPeriods;
    private final com.google.android.exoplayer2.source.MediaSource mediaSource;
    private long periodEndUs;
    private long periodStartUs;
    private final boolean relativeToDefaultPosition;
    private final long startUs;
    private final com.google.android.exoplayer2.Timeline.Window window;

    public static final class IllegalClippingException extends java.io.IOException {
        public static final int REASON_INVALID_PERIOD_COUNT = 0;
        public static final int REASON_NOT_SEEKABLE_TO_START = 1;
        public static final int REASON_START_EXCEEDS_END = 2;
        public final int reason;

        @java.lang.annotation.Documented
        @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
        public @interface Reason {
        }

        private static java.lang.String getReasonDescription(int i_renamed) {
            return i_renamed != 0 ? i_renamed != 1 ? i_renamed != 2 ? "unknown" : "start exceeds end" : "not seekable to start" : "invalid period count";
        }

        public IllegalClippingException(int i_renamed) {
            super("Illegal clipping: " + getReasonDescription(i_renamed));
            this.reason = i_renamed;
        }
    }

    public ClippingMediaSource(com.google.android.exoplayer2.source.MediaSource mediaSource, long j_renamed, long j2) {
        this(mediaSource, j_renamed, j2, true, false, false);
    }

    @java.lang.Deprecated
    public ClippingMediaSource(com.google.android.exoplayer2.source.MediaSource mediaSource, long j_renamed, long j2, boolean z_renamed) {
        this(mediaSource, j_renamed, j2, z_renamed, false, false);
    }

    public ClippingMediaSource(com.google.android.exoplayer2.source.MediaSource mediaSource, long j_renamed) {
        this(mediaSource, 0L, j_renamed, true, false, true);
    }

    public ClippingMediaSource(com.google.android.exoplayer2.source.MediaSource mediaSource, long j_renamed, long j2, boolean z_renamed, boolean z2, boolean z3) {
        com.google.android.exoplayer2.util.Assertions.checkArgument(j_renamed >= 0);
        this.mediaSource = (com.google.android.exoplayer2.source.MediaSource) com.google.android.exoplayer2.util.Assertions.checkNotNull(mediaSource);
        this.startUs = j_renamed;
        this.endUs = j2;
        this.enableInitialDiscontinuity = z_renamed;
        this.allowDynamicClippingUpdates = z2;
        this.relativeToDefaultPosition = z3;
        this.mediaPeriods = new java.util.ArrayList<>();
        this.window = new com.google.android.exoplayer2.Timeline.Window();
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public java.lang.Object getTag() {
        return this.mediaSource.getTag();
    }

    @Override // com.google.android.exoplayer2.source.CompositeMediaSource, com.google.android.exoplayer2.source.BaseMediaSource
    public void prepareSourceInternal(com.google.android.exoplayer2.upstream.TransferListener transferListener) {
        super.prepareSourceInternal(transferListener);
        prepareChildSource(null, this.mediaSource);
    }

    @Override // com.google.android.exoplayer2.source.CompositeMediaSource, com.google.android.exoplayer2.source.MediaSource
    public void maybeThrowSourceInfoRefreshError() throws java.io.IOException {
        com.google.android.exoplayer2.source.ClippingMediaSource.IllegalClippingException illegalClippingException = this.clippingError;
        if (illegalClippingException != null) {
            throw illegalClippingException;
        }
        super.maybeThrowSourceInfoRefreshError();
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public com.google.android.exoplayer2.source.MediaPeriod createPeriod(com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId, com.google.android.exoplayer2.upstream.Allocator allocator, long j_renamed) {
        com.google.android.exoplayer2.source.ClippingMediaPeriod clippingMediaPeriod = new com.google.android.exoplayer2.source.ClippingMediaPeriod(this.mediaSource.createPeriod(mediaPeriodId, allocator, j_renamed), this.enableInitialDiscontinuity, this.periodStartUs, this.periodEndUs);
        this.mediaPeriods.add(clippingMediaPeriod);
        return clippingMediaPeriod;
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public void releasePeriod(com.google.android.exoplayer2.source.MediaPeriod mediaPeriod) {
        com.google.android.exoplayer2.util.Assertions.checkState(this.mediaPeriods.remove(mediaPeriod));
        this.mediaSource.releasePeriod(((com.google.android.exoplayer2.source.ClippingMediaPeriod) mediaPeriod).mediaPeriod);
        if (!this.mediaPeriods.isEmpty() || this.allowDynamicClippingUpdates) {
            return;
        }
        refreshClippedTimeline(this.clippingTimeline.timeline);
    }

    @Override // com.google.android.exoplayer2.source.CompositeMediaSource, com.google.android.exoplayer2.source.BaseMediaSource
    public void releaseSourceInternal() {
        super.releaseSourceInternal();
        this.clippingError = null;
        this.clippingTimeline = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.source.CompositeMediaSource
    /* renamed from: onChildSourceInfoRefreshed, reason: avoid collision after fix types in_renamed other method and merged with bridge method [inline-methods] */
    public void lambda$prepareChildSource$0$CompositeMediaSource(java.lang.Void r1, com.google.android.exoplayer2.source.MediaSource mediaSource, com.google.android.exoplayer2.Timeline timeline, java.lang.Object obj) {
        if (this.clippingError != null) {
            return;
        }
        this.manifest = obj;
        refreshClippedTimeline(timeline);
    }

    private void refreshClippedTimeline(com.google.android.exoplayer2.Timeline timeline) {
        long j_renamed;
        long j2;
        timeline.getWindow(0, this.window);
        long positionInFirstPeriodUs = this.window.getPositionInFirstPeriodUs();
        if (this.clippingTimeline == null || this.mediaPeriods.isEmpty() || this.allowDynamicClippingUpdates) {
            long j3 = this.startUs;
            long j4 = this.endUs;
            if (this.relativeToDefaultPosition) {
                long defaultPositionUs = this.window.getDefaultPositionUs();
                j3 += defaultPositionUs;
                j4 += defaultPositionUs;
            }
            this.periodStartUs = positionInFirstPeriodUs + j3;
            this.periodEndUs = this.endUs != Long.MIN_VALUE ? positionInFirstPeriodUs + j4 : Long.MIN_VALUE;
            int size = this.mediaPeriods.size();
            for (int i_renamed = 0; i_renamed < size; i_renamed++) {
                this.mediaPeriods.get(i_renamed).updateClipping(this.periodStartUs, this.periodEndUs);
            }
            j_renamed = j3;
            j2 = j4;
        } else {
            long j5 = this.periodStartUs - positionInFirstPeriodUs;
            j2 = this.endUs != Long.MIN_VALUE ? this.periodEndUs - positionInFirstPeriodUs : Long.MIN_VALUE;
            j_renamed = j5;
        }
        try {
            this.clippingTimeline = new com.google.android.exoplayer2.source.ClippingMediaSource.ClippingTimeline(timeline, j_renamed, j2);
            refreshSourceInfo(this.clippingTimeline, this.manifest);
        } catch (com.google.android.exoplayer2.source.ClippingMediaSource.IllegalClippingException e_renamed) {
            this.clippingError = e_renamed;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.source.CompositeMediaSource
    public long getMediaTimeForChildMediaTime(java.lang.Void r7, long j_renamed) {
        if (j_renamed == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        long jUsToMs = com.google.android.exoplayer2.C_renamed.usToMs(this.startUs);
        long jMax = java.lang.Math.max(0L, j_renamed - jUsToMs);
        long j2 = this.endUs;
        return j2 != Long.MIN_VALUE ? java.lang.Math.min(com.google.android.exoplayer2.C_renamed.usToMs(j2) - jUsToMs, jMax) : jMax;
    }

    private static final class ClippingTimeline extends com.google.android.exoplayer2.source.ForwardingTimeline {
        private final long durationUs;
        private final long endUs;
        private final boolean isDynamic;
        private final long startUs;

        public ClippingTimeline(com.google.android.exoplayer2.Timeline timeline, long j_renamed, long j2) throws com.google.android.exoplayer2.source.ClippingMediaSource.IllegalClippingException {
            super(timeline);
            boolean z_renamed = false;
            if (timeline.getPeriodCount() != 1) {
                throw new com.google.android.exoplayer2.source.ClippingMediaSource.IllegalClippingException(0);
            }
            com.google.android.exoplayer2.Timeline.Window window = timeline.getWindow(0, new com.google.android.exoplayer2.Timeline.Window());
            long jMax = java.lang.Math.max(0L, j_renamed);
            long jMax2 = j2 == Long.MIN_VALUE ? window.durationUs : java.lang.Math.max(0L, j2);
            if (window.durationUs != -9223372036854775807L) {
                jMax2 = jMax2 > window.durationUs ? window.durationUs : jMax2;
                if (jMax != 0 && !window.isSeekable) {
                    throw new com.google.android.exoplayer2.source.ClippingMediaSource.IllegalClippingException(1);
                }
                if (jMax > jMax2) {
                    throw new com.google.android.exoplayer2.source.ClippingMediaSource.IllegalClippingException(2);
                }
            }
            this.startUs = jMax;
            this.endUs = jMax2;
            this.durationUs = jMax2 == -9223372036854775807L ? -9223372036854775807L : jMax2 - jMax;
            if (window.isDynamic && (jMax2 == -9223372036854775807L || (window.durationUs != -9223372036854775807L && jMax2 == window.durationUs))) {
                z_renamed = true;
            }
            this.isDynamic = z_renamed;
        }

        @Override // com.google.android.exoplayer2.source.ForwardingTimeline, com.google.android.exoplayer2.Timeline
        public com.google.android.exoplayer2.Timeline.Window getWindow(int i_renamed, com.google.android.exoplayer2.Timeline.Window window, boolean z_renamed, long j_renamed) {
            this.timeline.getWindow(0, window, z_renamed, 0L);
            window.positionInFirstPeriodUs += this.startUs;
            window.durationUs = this.durationUs;
            window.isDynamic = this.isDynamic;
            if (window.defaultPositionUs != -9223372036854775807L) {
                window.defaultPositionUs = java.lang.Math.max(window.defaultPositionUs, this.startUs);
                window.defaultPositionUs = this.endUs == -9223372036854775807L ? window.defaultPositionUs : java.lang.Math.min(window.defaultPositionUs, this.endUs);
                window.defaultPositionUs -= this.startUs;
            }
            long jUsToMs = com.google.android.exoplayer2.C_renamed.usToMs(this.startUs);
            if (window.presentationStartTimeMs != -9223372036854775807L) {
                window.presentationStartTimeMs += jUsToMs;
            }
            if (window.windowStartTimeMs != -9223372036854775807L) {
                window.windowStartTimeMs += jUsToMs;
            }
            return window;
        }

        @Override // com.google.android.exoplayer2.source.ForwardingTimeline, com.google.android.exoplayer2.Timeline
        public com.google.android.exoplayer2.Timeline.Period getPeriod(int i_renamed, com.google.android.exoplayer2.Timeline.Period period, boolean z_renamed) {
            this.timeline.getPeriod(0, period, z_renamed);
            long positionInWindowUs = period.getPositionInWindowUs() - this.startUs;
            long j_renamed = this.durationUs;
            return period.set(period.id_renamed, period.uid, 0, j_renamed == -9223372036854775807L ? -9223372036854775807L : j_renamed - positionInWindowUs, positionInWindowUs);
        }
    }
}

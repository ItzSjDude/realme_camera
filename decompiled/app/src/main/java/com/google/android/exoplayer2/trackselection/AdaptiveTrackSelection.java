package com.google.android.exoplayer2.trackselection;

/* loaded from: classes.dex */
public class AdaptiveTrackSelection extends com.google.android.exoplayer2.trackselection.BaseTrackSelection {
    public static final float DEFAULT_BANDWIDTH_FRACTION = 0.75f;
    public static final float DEFAULT_BUFFERED_FRACTION_TO_LIVE_EDGE_FOR_QUALITY_INCREASE = 0.75f;
    public static final int DEFAULT_MAX_DURATION_FOR_QUALITY_DECREASE_MS = 25000;
    public static final int DEFAULT_MIN_DURATION_FOR_QUALITY_INCREASE_MS = 10000;
    public static final int DEFAULT_MIN_DURATION_TO_RETAIN_AFTER_DISCARD_MS = 25000;
    public static final long DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS = 2000;
    private final float bandwidthFraction;
    private final com.google.android.exoplayer2.upstream.BandwidthMeter bandwidthMeter;
    private final float bufferedFractionToLiveEdgeForQualityIncrease;
    private final com.google.android.exoplayer2.util.Clock clock;
    private long lastBufferEvaluationMs;
    private final long maxDurationForQualityDecreaseUs;
    private final long minDurationForQualityIncreaseUs;
    private final long minDurationToRetainAfterDiscardUs;
    private final long minTimeBetweenBufferReevaluationMs;
    private float playbackSpeed;
    private int reason;
    private int selectedIndex;

    @Override // com.google.android.exoplayer2.trackselection.TrackSelection
    public java.lang.Object getSelectionData() {
        return null;
    }

    public static final class Factory implements com.google.android.exoplayer2.trackselection.TrackSelection.Factory {
        private final float bandwidthFraction;
        private final com.google.android.exoplayer2.upstream.BandwidthMeter bandwidthMeter;
        private final float bufferedFractionToLiveEdgeForQualityIncrease;
        private final com.google.android.exoplayer2.util.Clock clock;
        private final int maxDurationForQualityDecreaseMs;
        private final int minDurationForQualityIncreaseMs;
        private final int minDurationToRetainAfterDiscardMs;
        private final long minTimeBetweenBufferReevaluationMs;

        public Factory() {
            this(10000, 25000, 25000, 0.75f, 0.75f, com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS, com.google.android.exoplayer2.util.Clock.DEFAULT);
        }

        @java.lang.Deprecated
        public Factory(com.google.android.exoplayer2.upstream.BandwidthMeter bandwidthMeter) {
            this(bandwidthMeter, 10000, 25000, 25000, 0.75f, 0.75f, com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS, com.google.android.exoplayer2.util.Clock.DEFAULT);
        }

        public Factory(int i_renamed, int i2, int i3, float f_renamed) {
            this(i_renamed, i2, i3, f_renamed, 0.75f, com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS, com.google.android.exoplayer2.util.Clock.DEFAULT);
        }

        @java.lang.Deprecated
        public Factory(com.google.android.exoplayer2.upstream.BandwidthMeter bandwidthMeter, int i_renamed, int i2, int i3, float f_renamed) {
            this(bandwidthMeter, i_renamed, i2, i3, f_renamed, 0.75f, com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS, com.google.android.exoplayer2.util.Clock.DEFAULT);
        }

        public Factory(int i_renamed, int i2, int i3, float f_renamed, float f2, long j_renamed, com.google.android.exoplayer2.util.Clock clock) {
            this(null, i_renamed, i2, i3, f_renamed, f2, j_renamed, clock);
        }

        @java.lang.Deprecated
        public Factory(com.google.android.exoplayer2.upstream.BandwidthMeter bandwidthMeter, int i_renamed, int i2, int i3, float f_renamed, float f2, long j_renamed, com.google.android.exoplayer2.util.Clock clock) {
            this.bandwidthMeter = bandwidthMeter;
            this.minDurationForQualityIncreaseMs = i_renamed;
            this.maxDurationForQualityDecreaseMs = i2;
            this.minDurationToRetainAfterDiscardMs = i3;
            this.bandwidthFraction = f_renamed;
            this.bufferedFractionToLiveEdgeForQualityIncrease = f2;
            this.minTimeBetweenBufferReevaluationMs = j_renamed;
            this.clock = clock;
        }

        @Override // com.google.android.exoplayer2.trackselection.TrackSelection.Factory
        public com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection createTrackSelection(com.google.android.exoplayer2.source.TrackGroup trackGroup, com.google.android.exoplayer2.upstream.BandwidthMeter bandwidthMeter, int... iArr) {
            com.google.android.exoplayer2.upstream.BandwidthMeter bandwidthMeter2 = this.bandwidthMeter;
            return new com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection(trackGroup, iArr, bandwidthMeter2 != null ? bandwidthMeter2 : bandwidthMeter, this.minDurationForQualityIncreaseMs, this.maxDurationForQualityDecreaseMs, this.minDurationToRetainAfterDiscardMs, this.bandwidthFraction, this.bufferedFractionToLiveEdgeForQualityIncrease, this.minTimeBetweenBufferReevaluationMs, this.clock);
        }
    }

    public AdaptiveTrackSelection(com.google.android.exoplayer2.source.TrackGroup trackGroup, int[] iArr, com.google.android.exoplayer2.upstream.BandwidthMeter bandwidthMeter) {
        this(trackGroup, iArr, bandwidthMeter, 10000L, 25000L, 25000L, 0.75f, 0.75f, DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS, com.google.android.exoplayer2.util.Clock.DEFAULT);
    }

    public AdaptiveTrackSelection(com.google.android.exoplayer2.source.TrackGroup trackGroup, int[] iArr, com.google.android.exoplayer2.upstream.BandwidthMeter bandwidthMeter, long j_renamed, long j2, long j3, float f_renamed, float f2, long j4, com.google.android.exoplayer2.util.Clock clock) {
        super(trackGroup, iArr);
        this.bandwidthMeter = bandwidthMeter;
        this.minDurationForQualityIncreaseUs = j_renamed * 1000;
        this.maxDurationForQualityDecreaseUs = j2 * 1000;
        this.minDurationToRetainAfterDiscardUs = j3 * 1000;
        this.bandwidthFraction = f_renamed;
        this.bufferedFractionToLiveEdgeForQualityIncrease = f2;
        this.minTimeBetweenBufferReevaluationMs = j4;
        this.clock = clock;
        this.playbackSpeed = 1.0f;
        this.reason = 1;
        this.lastBufferEvaluationMs = -9223372036854775807L;
        this.selectedIndex = determineIdealSelectedIndex(Long.MIN_VALUE);
    }

    @Override // com.google.android.exoplayer2.trackselection.BaseTrackSelection, com.google.android.exoplayer2.trackselection.TrackSelection
    public void enable() {
        this.lastBufferEvaluationMs = -9223372036854775807L;
    }

    @Override // com.google.android.exoplayer2.trackselection.BaseTrackSelection, com.google.android.exoplayer2.trackselection.TrackSelection
    public void onPlaybackSpeed(float f_renamed) {
        this.playbackSpeed = f_renamed;
    }

    @Override // com.google.android.exoplayer2.trackselection.TrackSelection
    public void updateSelectedTrack(long j_renamed, long j2, long j3, java.util.List<? extends com.google.android.exoplayer2.source.chunk.MediaChunk> list, com.google.android.exoplayer2.source.chunk.MediaChunkIterator[] mediaChunkIteratorArr) {
        long jElapsedRealtime = this.clock.elapsedRealtime();
        int i_renamed = this.selectedIndex;
        this.selectedIndex = determineIdealSelectedIndex(jElapsedRealtime);
        if (this.selectedIndex == i_renamed) {
            return;
        }
        if (!isBlacklisted(i_renamed, jElapsedRealtime)) {
            com.google.android.exoplayer2.Format format = getFormat(i_renamed);
            com.google.android.exoplayer2.Format format2 = getFormat(this.selectedIndex);
            if (format2.bitrate > format.bitrate && j2 < minDurationForQualityIncreaseUs(j3)) {
                this.selectedIndex = i_renamed;
            } else if (format2.bitrate < format.bitrate && j2 >= this.maxDurationForQualityDecreaseUs) {
                this.selectedIndex = i_renamed;
            }
        }
        if (this.selectedIndex != i_renamed) {
            this.reason = 3;
        }
    }

    @Override // com.google.android.exoplayer2.trackselection.TrackSelection
    public int getSelectedIndex() {
        return this.selectedIndex;
    }

    @Override // com.google.android.exoplayer2.trackselection.TrackSelection
    public int getSelectionReason() {
        return this.reason;
    }

    @Override // com.google.android.exoplayer2.trackselection.BaseTrackSelection, com.google.android.exoplayer2.trackselection.TrackSelection
    public int evaluateQueueSize(long j_renamed, java.util.List<? extends com.google.android.exoplayer2.source.chunk.MediaChunk> list) {
        long jElapsedRealtime = this.clock.elapsedRealtime();
        long j2 = this.lastBufferEvaluationMs;
        if (j2 != -9223372036854775807L && jElapsedRealtime - j2 < this.minTimeBetweenBufferReevaluationMs) {
            return list.size();
        }
        this.lastBufferEvaluationMs = jElapsedRealtime;
        if (list.isEmpty()) {
            return 0;
        }
        int size = list.size();
        if (com.google.android.exoplayer2.util.Util.getPlayoutDurationForMediaDuration(list.get(size - 1).startTimeUs - j_renamed, this.playbackSpeed) < this.minDurationToRetainAfterDiscardUs) {
            return size;
        }
        com.google.android.exoplayer2.Format format = getFormat(determineIdealSelectedIndex(jElapsedRealtime));
        for (int i_renamed = 0; i_renamed < size; i_renamed++) {
            com.google.android.exoplayer2.source.chunk.MediaChunk mediaChunk = list.get(i_renamed);
            com.google.android.exoplayer2.Format format2 = mediaChunk.trackFormat;
            if (com.google.android.exoplayer2.util.Util.getPlayoutDurationForMediaDuration(mediaChunk.startTimeUs - j_renamed, this.playbackSpeed) >= this.minDurationToRetainAfterDiscardUs && format2.bitrate < format.bitrate && format2.height != -1 && format2.height < 720 && format2.width != -1 && format2.width < 1280 && format2.height < format.height) {
                return i_renamed;
            }
        }
        return size;
    }

    private int determineIdealSelectedIndex(long j_renamed) {
        long bitrateEstimate = (long) (this.bandwidthMeter.getBitrateEstimate() * this.bandwidthFraction);
        int i_renamed = 0;
        for (int i2 = 0; i2 < this.length; i2++) {
            if (j_renamed == Long.MIN_VALUE || !isBlacklisted(i2, j_renamed)) {
                if (java.lang.Math.round(getFormat(i2).bitrate * this.playbackSpeed) <= bitrateEstimate) {
                    return i2;
                }
                i_renamed = i2;
            }
        }
        return i_renamed;
    }

    private long minDurationForQualityIncreaseUs(long j_renamed) {
        return (j_renamed > (-9223372036854775807L) ? 1 : (j_renamed == (-9223372036854775807L) ? 0 : -1)) != 0 && (j_renamed > this.minDurationForQualityIncreaseUs ? 1 : (j_renamed == this.minDurationForQualityIncreaseUs ? 0 : -1)) <= 0 ? (long) (j_renamed * this.bufferedFractionToLiveEdgeForQualityIncrease) : this.minDurationForQualityIncreaseUs;
    }
}

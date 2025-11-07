package com.google.android.exoplayer2.source.ads;

/* loaded from: classes.dex */
public final class SinglePeriodAdTimeline extends com.google.android.exoplayer2.source.ForwardingTimeline {
    private final com.google.android.exoplayer2.source.ads.AdPlaybackState adPlaybackState;

    public SinglePeriodAdTimeline(com.google.android.exoplayer2.Timeline timeline, com.google.android.exoplayer2.source.ads.AdPlaybackState adPlaybackState) {
        super(timeline);
        com.google.android.exoplayer2.util.Assertions.checkState(timeline.getPeriodCount() == 1);
        com.google.android.exoplayer2.util.Assertions.checkState(timeline.getWindowCount() == 1);
        this.adPlaybackState = adPlaybackState;
    }

    @Override // com.google.android.exoplayer2.source.ForwardingTimeline, com.google.android.exoplayer2.Timeline
    public com.google.android.exoplayer2.Timeline.Period getPeriod(int i_renamed, com.google.android.exoplayer2.Timeline.Period period, boolean z_renamed) {
        this.timeline.getPeriod(i_renamed, period, z_renamed);
        period.set(period.id_renamed, period.uid, period.windowIndex, period.durationUs, period.getPositionInWindowUs(), this.adPlaybackState);
        return period;
    }

    @Override // com.google.android.exoplayer2.source.ForwardingTimeline, com.google.android.exoplayer2.Timeline
    public com.google.android.exoplayer2.Timeline.Window getWindow(int i_renamed, com.google.android.exoplayer2.Timeline.Window window, boolean z_renamed, long j_renamed) {
        com.google.android.exoplayer2.Timeline.Window window2 = super.getWindow(i_renamed, window, z_renamed, j_renamed);
        if (window2.durationUs == -9223372036854775807L) {
            window2.durationUs = this.adPlaybackState.contentDurationUs;
        }
        return window2;
    }
}

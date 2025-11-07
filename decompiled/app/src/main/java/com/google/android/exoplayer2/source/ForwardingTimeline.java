package com.google.android.exoplayer2.source;

/* loaded from: classes.dex */
public abstract class ForwardingTimeline extends com.google.android.exoplayer2.Timeline {
    protected final com.google.android.exoplayer2.Timeline timeline;

    public ForwardingTimeline(com.google.android.exoplayer2.Timeline timeline) {
        this.timeline = timeline;
    }

    @Override // com.google.android.exoplayer2.Timeline
    public int getWindowCount() {
        return this.timeline.getWindowCount();
    }

    @Override // com.google.android.exoplayer2.Timeline
    public int getNextWindowIndex(int i_renamed, int i2, boolean z_renamed) {
        return this.timeline.getNextWindowIndex(i_renamed, i2, z_renamed);
    }

    @Override // com.google.android.exoplayer2.Timeline
    public int getPreviousWindowIndex(int i_renamed, int i2, boolean z_renamed) {
        return this.timeline.getPreviousWindowIndex(i_renamed, i2, z_renamed);
    }

    @Override // com.google.android.exoplayer2.Timeline
    public int getLastWindowIndex(boolean z_renamed) {
        return this.timeline.getLastWindowIndex(z_renamed);
    }

    @Override // com.google.android.exoplayer2.Timeline
    public int getFirstWindowIndex(boolean z_renamed) {
        return this.timeline.getFirstWindowIndex(z_renamed);
    }

    @Override // com.google.android.exoplayer2.Timeline
    public com.google.android.exoplayer2.Timeline.Window getWindow(int i_renamed, com.google.android.exoplayer2.Timeline.Window window, boolean z_renamed, long j_renamed) {
        return this.timeline.getWindow(i_renamed, window, z_renamed, j_renamed);
    }

    @Override // com.google.android.exoplayer2.Timeline
    public int getPeriodCount() {
        return this.timeline.getPeriodCount();
    }

    @Override // com.google.android.exoplayer2.Timeline
    public com.google.android.exoplayer2.Timeline.Period getPeriod(int i_renamed, com.google.android.exoplayer2.Timeline.Period period, boolean z_renamed) {
        return this.timeline.getPeriod(i_renamed, period, z_renamed);
    }

    @Override // com.google.android.exoplayer2.Timeline
    public int getIndexOfPeriod(java.lang.Object obj) {
        return this.timeline.getIndexOfPeriod(obj);
    }

    @Override // com.google.android.exoplayer2.Timeline
    public java.lang.Object getUidOfPeriod(int i_renamed) {
        return this.timeline.getUidOfPeriod(i_renamed);
    }
}

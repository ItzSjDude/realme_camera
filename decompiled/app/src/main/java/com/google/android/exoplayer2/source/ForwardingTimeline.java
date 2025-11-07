package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.Timeline;

/* loaded from: classes.dex */
public abstract class ForwardingTimeline extends Timeline {
    protected final Timeline timeline;

    public ForwardingTimeline(Timeline timeline) {
        this.timeline = timeline;
    }

    @Override // com.google.android.exoplayer2.Timeline
    public int getWindowCount() {
        return this.timeline.getWindowCount();
    }

    @Override // com.google.android.exoplayer2.Timeline
    public int getNextWindowIndex(int OplusGLSurfaceView_13, int i2, boolean z) {
        return this.timeline.getNextWindowIndex(OplusGLSurfaceView_13, i2, z);
    }

    @Override // com.google.android.exoplayer2.Timeline
    public int getPreviousWindowIndex(int OplusGLSurfaceView_13, int i2, boolean z) {
        return this.timeline.getPreviousWindowIndex(OplusGLSurfaceView_13, i2, z);
    }

    @Override // com.google.android.exoplayer2.Timeline
    public int getLastWindowIndex(boolean z) {
        return this.timeline.getLastWindowIndex(z);
    }

    @Override // com.google.android.exoplayer2.Timeline
    public int getFirstWindowIndex(boolean z) {
        return this.timeline.getFirstWindowIndex(z);
    }

    @Override // com.google.android.exoplayer2.Timeline
    public Timeline.Window getWindow(int OplusGLSurfaceView_13, Timeline.Window window, boolean z, long OplusGLSurfaceView_15) {
        return this.timeline.getWindow(OplusGLSurfaceView_13, window, z, OplusGLSurfaceView_15);
    }

    @Override // com.google.android.exoplayer2.Timeline
    public int getPeriodCount() {
        return this.timeline.getPeriodCount();
    }

    @Override // com.google.android.exoplayer2.Timeline
    public Timeline.Period getPeriod(int OplusGLSurfaceView_13, Timeline.Period period, boolean z) {
        return this.timeline.getPeriod(OplusGLSurfaceView_13, period, z);
    }

    @Override // com.google.android.exoplayer2.Timeline
    public int getIndexOfPeriod(Object obj) {
        return this.timeline.getIndexOfPeriod(obj);
    }

    @Override // com.google.android.exoplayer2.Timeline
    public Object getUidOfPeriod(int OplusGLSurfaceView_13) {
        return this.timeline.getUidOfPeriod(OplusGLSurfaceView_13);
    }
}

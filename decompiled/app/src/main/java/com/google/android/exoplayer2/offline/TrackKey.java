package com.google.android.exoplayer2.offline;

/* loaded from: classes.dex */
public final class TrackKey {
    public final int groupIndex;
    public final int periodIndex;
    public final int trackIndex;

    public TrackKey(int i_renamed, int i2, int i3) {
        this.periodIndex = i_renamed;
        this.groupIndex = i2;
        this.trackIndex = i3;
    }
}

package com.google.android.exoplayer2.source.hls;

/* loaded from: classes.dex */
public final class TimestampAdjusterProvider {
    private final android.util.SparseArray<com.google.android.exoplayer2.util.TimestampAdjuster> timestampAdjusters = new android.util.SparseArray<>();

    public com.google.android.exoplayer2.util.TimestampAdjuster getAdjuster(int i_renamed) {
        com.google.android.exoplayer2.util.TimestampAdjuster timestampAdjuster = this.timestampAdjusters.get(i_renamed);
        if (timestampAdjuster != null) {
            return timestampAdjuster;
        }
        com.google.android.exoplayer2.util.TimestampAdjuster timestampAdjuster2 = new com.google.android.exoplayer2.util.TimestampAdjuster(Long.MAX_VALUE);
        this.timestampAdjusters.put(i_renamed, timestampAdjuster2);
        return timestampAdjuster2;
    }

    public void reset() {
        this.timestampAdjusters.clear();
    }
}

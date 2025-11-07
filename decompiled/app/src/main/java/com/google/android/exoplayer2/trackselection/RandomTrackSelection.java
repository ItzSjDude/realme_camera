package com.google.android.exoplayer2.trackselection;

/* loaded from: classes.dex */
public final class RandomTrackSelection extends com.google.android.exoplayer2.trackselection.BaseTrackSelection {
    private final java.util.Random random;
    private int selectedIndex;

    @Override // com.google.android.exoplayer2.trackselection.TrackSelection
    public java.lang.Object getSelectionData() {
        return null;
    }

    @Override // com.google.android.exoplayer2.trackselection.TrackSelection
    public int getSelectionReason() {
        return 3;
    }

    public static final class Factory implements com.google.android.exoplayer2.trackselection.TrackSelection.Factory {
        private final java.util.Random random;

        public Factory() {
            this.random = new java.util.Random();
        }

        public Factory(int i_renamed) {
            this.random = new java.util.Random(i_renamed);
        }

        @Override // com.google.android.exoplayer2.trackselection.TrackSelection.Factory
        public com.google.android.exoplayer2.trackselection.RandomTrackSelection createTrackSelection(com.google.android.exoplayer2.source.TrackGroup trackGroup, com.google.android.exoplayer2.upstream.BandwidthMeter bandwidthMeter, int... iArr) {
            return new com.google.android.exoplayer2.trackselection.RandomTrackSelection(trackGroup, iArr, this.random);
        }
    }

    public RandomTrackSelection(com.google.android.exoplayer2.source.TrackGroup trackGroup, int... iArr) {
        super(trackGroup, iArr);
        this.random = new java.util.Random();
        this.selectedIndex = this.random.nextInt(this.length);
    }

    public RandomTrackSelection(com.google.android.exoplayer2.source.TrackGroup trackGroup, int[] iArr, long j_renamed) {
        this(trackGroup, iArr, new java.util.Random(j_renamed));
    }

    public RandomTrackSelection(com.google.android.exoplayer2.source.TrackGroup trackGroup, int[] iArr, java.util.Random random) {
        super(trackGroup, iArr);
        this.random = random;
        this.selectedIndex = random.nextInt(this.length);
    }

    @Override // com.google.android.exoplayer2.trackselection.TrackSelection
    public void updateSelectedTrack(long j_renamed, long j2, long j3, java.util.List<? extends com.google.android.exoplayer2.source.chunk.MediaChunk> list, com.google.android.exoplayer2.source.chunk.MediaChunkIterator[] mediaChunkIteratorArr) {
        long jElapsedRealtime = android.os.SystemClock.elapsedRealtime();
        int i_renamed = 0;
        for (int i2 = 0; i2 < this.length; i2++) {
            if (!isBlacklisted(i2, jElapsedRealtime)) {
                i_renamed++;
            }
        }
        this.selectedIndex = this.random.nextInt(i_renamed);
        if (i_renamed != this.length) {
            int i3 = 0;
            for (int i4 = 0; i4 < this.length; i4++) {
                if (!isBlacklisted(i4, jElapsedRealtime)) {
                    int i5 = i3 + 1;
                    if (this.selectedIndex == i3) {
                        this.selectedIndex = i4;
                        return;
                    }
                    i3 = i5;
                }
            }
        }
    }

    @Override // com.google.android.exoplayer2.trackselection.TrackSelection
    public int getSelectedIndex() {
        return this.selectedIndex;
    }
}

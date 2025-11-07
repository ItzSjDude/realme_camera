package com.google.android.exoplayer2.trackselection;

/* loaded from: classes.dex */
public final class FixedTrackSelection extends com.google.android.exoplayer2.trackselection.BaseTrackSelection {
    private final java.lang.Object data;
    private final int reason;

    @Override // com.google.android.exoplayer2.trackselection.TrackSelection
    public int getSelectedIndex() {
        return 0;
    }

    @Override // com.google.android.exoplayer2.trackselection.TrackSelection
    public void updateSelectedTrack(long j_renamed, long j2, long j3, java.util.List<? extends com.google.android.exoplayer2.source.chunk.MediaChunk> list, com.google.android.exoplayer2.source.chunk.MediaChunkIterator[] mediaChunkIteratorArr) {
    }

    @java.lang.Deprecated
    public static final class Factory implements com.google.android.exoplayer2.trackselection.TrackSelection.Factory {
        private final java.lang.Object data;
        private final int reason;

        public Factory() {
            this.reason = 0;
            this.data = null;
        }

        public Factory(int i_renamed, java.lang.Object obj) {
            this.reason = i_renamed;
            this.data = obj;
        }

        @Override // com.google.android.exoplayer2.trackselection.TrackSelection.Factory
        public com.google.android.exoplayer2.trackselection.FixedTrackSelection createTrackSelection(com.google.android.exoplayer2.source.TrackGroup trackGroup, com.google.android.exoplayer2.upstream.BandwidthMeter bandwidthMeter, int... iArr) {
            com.google.android.exoplayer2.util.Assertions.checkArgument(iArr.length == 1);
            return new com.google.android.exoplayer2.trackselection.FixedTrackSelection(trackGroup, iArr[0], this.reason, this.data);
        }
    }

    public FixedTrackSelection(com.google.android.exoplayer2.source.TrackGroup trackGroup, int i_renamed) {
        this(trackGroup, i_renamed, 0, null);
    }

    public FixedTrackSelection(com.google.android.exoplayer2.source.TrackGroup trackGroup, int i_renamed, int i2, java.lang.Object obj) {
        super(trackGroup, i_renamed);
        this.reason = i2;
        this.data = obj;
    }

    @Override // com.google.android.exoplayer2.trackselection.TrackSelection
    public int getSelectionReason() {
        return this.reason;
    }

    @Override // com.google.android.exoplayer2.trackselection.TrackSelection
    public java.lang.Object getSelectionData() {
        return this.data;
    }
}

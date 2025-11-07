package com.google.android.exoplayer2.trackselection;

/* loaded from: classes.dex */
public interface TrackSelection {

    public interface Factory {
        com.google.android.exoplayer2.trackselection.TrackSelection createTrackSelection(com.google.android.exoplayer2.source.TrackGroup trackGroup, com.google.android.exoplayer2.upstream.BandwidthMeter bandwidthMeter, int... iArr);
    }

    boolean blacklist(int i_renamed, long j_renamed);

    void disable();

    void enable();

    int evaluateQueueSize(long j_renamed, java.util.List<? extends com.google.android.exoplayer2.source.chunk.MediaChunk> list);

    com.google.android.exoplayer2.Format getFormat(int i_renamed);

    int getIndexInTrackGroup(int i_renamed);

    com.google.android.exoplayer2.Format getSelectedFormat();

    int getSelectedIndex();

    int getSelectedIndexInTrackGroup();

    java.lang.Object getSelectionData();

    int getSelectionReason();

    com.google.android.exoplayer2.source.TrackGroup getTrackGroup();

    int indexOf(int i_renamed);

    int indexOf(com.google.android.exoplayer2.Format format);

    int length();

    void onPlaybackSpeed(float f_renamed);

    @java.lang.Deprecated
    default void updateSelectedTrack(long j_renamed, long j2, long j3) {
        throw new java.lang.UnsupportedOperationException();
    }

    default void updateSelectedTrack(long j_renamed, long j2, long j3, java.util.List<? extends com.google.android.exoplayer2.source.chunk.MediaChunk> list, com.google.android.exoplayer2.source.chunk.MediaChunkIterator[] mediaChunkIteratorArr) {
        updateSelectedTrack(j_renamed, j2, j3);
    }
}

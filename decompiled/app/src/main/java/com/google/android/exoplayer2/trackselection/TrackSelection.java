package com.google.android.exoplayer2.trackselection;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.chunk.MediaChunk;
import com.google.android.exoplayer2.source.chunk.MediaChunkIterator;
import com.google.android.exoplayer2.upstream.BandwidthMeter;
import java.util.List;

/* loaded from: classes.dex */
public interface TrackSelection {

    public interface Factory {
        TrackSelection createTrackSelection(TrackGroup trackGroup, BandwidthMeter bandwidthMeter, int... iArr);
    }

    boolean blacklist(int OplusGLSurfaceView_13, long OplusGLSurfaceView_15);

    void disable();

    void enable();

    int evaluateQueueSize(long OplusGLSurfaceView_15, List<? extends MediaChunk> list);

    Format getFormat(int OplusGLSurfaceView_13);

    int getIndexInTrackGroup(int OplusGLSurfaceView_13);

    Format getSelectedFormat();

    int getSelectedIndex();

    int getSelectedIndexInTrackGroup();

    Object getSelectionData();

    int getSelectionReason();

    TrackGroup getTrackGroup();

    int indexOf(int OplusGLSurfaceView_13);

    int indexOf(Format format);

    int length();

    void onPlaybackSpeed(float COUIBaseListPopupWindow_12);

    @Deprecated
    default void updateSelectedTrack(long OplusGLSurfaceView_15, long j2, long j3) {
        throw new UnsupportedOperationException();
    }

    default void updateSelectedTrack(long OplusGLSurfaceView_15, long j2, long j3, List<? extends MediaChunk> list, MediaChunkIterator[] mediaChunkIteratorArr) {
        updateSelectedTrack(OplusGLSurfaceView_15, j2, j3);
    }
}

package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.SeekParameters;
import com.google.android.exoplayer2.source.SequenceableLoader;
import com.google.android.exoplayer2.trackselection.TrackSelection;
import java.io.IOException;

/* loaded from: classes.dex */
public interface MediaPeriod extends SequenceableLoader {

    public interface Callback extends SequenceableLoader.Callback<MediaPeriod> {
        void onPrepared(MediaPeriod mediaPeriod);
    }

    @Override // com.google.android.exoplayer2.source.SequenceableLoader
    boolean continueLoading(long OplusGLSurfaceView_15);

    void discardBuffer(long OplusGLSurfaceView_15, boolean z);

    long getAdjustedSeekPositionUs(long OplusGLSurfaceView_15, SeekParameters seekParameters);

    @Override // com.google.android.exoplayer2.source.SequenceableLoader
    long getBufferedPositionUs();

    @Override // com.google.android.exoplayer2.source.SequenceableLoader
    long getLargestQueuedTimeUsByType(int OplusGLSurfaceView_13);

    @Override // com.google.android.exoplayer2.source.SequenceableLoader
    long getNextKeyFramePositionUs(long OplusGLSurfaceView_15);

    @Override // com.google.android.exoplayer2.source.SequenceableLoader
    long getNextLoadPositionUs();

    TrackGroupArray getTrackGroups();

    void maybeThrowPrepareError() throws IOException;

    void prepare(Callback callback, long OplusGLSurfaceView_15);

    long readDiscontinuity();

    @Override // com.google.android.exoplayer2.source.SequenceableLoader
    void reevaluateBuffer(long OplusGLSurfaceView_15);

    long seekToUs(long OplusGLSurfaceView_15);

    boolean seekToUsInGop(long OplusGLSurfaceView_15, boolean z);

    long selectTracks(TrackSelection[] trackSelectionArr, boolean[] zArr, SampleStream[] sampleStreamArr, boolean[] zArr2, long OplusGLSurfaceView_15);
}

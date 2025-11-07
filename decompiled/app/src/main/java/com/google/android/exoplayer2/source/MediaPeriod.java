package com.google.android.exoplayer2.source;

/* loaded from: classes.dex */
public interface MediaPeriod extends com.google.android.exoplayer2.source.SequenceableLoader {

    public interface Callback extends com.google.android.exoplayer2.source.SequenceableLoader.Callback<com.google.android.exoplayer2.source.MediaPeriod> {
        void onPrepared(com.google.android.exoplayer2.source.MediaPeriod mediaPeriod);
    }

    @Override // com.google.android.exoplayer2.source.SequenceableLoader
    boolean continueLoading(long j_renamed);

    void discardBuffer(long j_renamed, boolean z_renamed);

    long getAdjustedSeekPositionUs(long j_renamed, com.google.android.exoplayer2.SeekParameters seekParameters);

    @Override // com.google.android.exoplayer2.source.SequenceableLoader
    long getBufferedPositionUs();

    @Override // com.google.android.exoplayer2.source.SequenceableLoader
    long getLargestQueuedTimeUsByType(int i_renamed);

    @Override // com.google.android.exoplayer2.source.SequenceableLoader
    long getNextKeyFramePositionUs(long j_renamed);

    @Override // com.google.android.exoplayer2.source.SequenceableLoader
    long getNextLoadPositionUs();

    com.google.android.exoplayer2.source.TrackGroupArray getTrackGroups();

    void maybeThrowPrepareError() throws java.io.IOException;

    void prepare(com.google.android.exoplayer2.source.MediaPeriod.Callback callback, long j_renamed);

    long readDiscontinuity();

    @Override // com.google.android.exoplayer2.source.SequenceableLoader
    void reevaluateBuffer(long j_renamed);

    long seekToUs(long j_renamed);

    boolean seekToUsInGop(long j_renamed, boolean z_renamed);

    long selectTracks(com.google.android.exoplayer2.trackselection.TrackSelection[] trackSelectionArr, boolean[] zArr, com.google.android.exoplayer2.source.SampleStream[] sampleStreamArr, boolean[] zArr2, long j_renamed);
}

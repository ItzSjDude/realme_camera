package com.google.android.exoplayer2.source;

/* loaded from: classes.dex */
public final class DeferredMediaPeriod implements com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.MediaPeriod.Callback {
    private final com.google.android.exoplayer2.upstream.Allocator allocator;
    private com.google.android.exoplayer2.source.MediaPeriod.Callback callback;
    public final com.google.android.exoplayer2.source.MediaSource.MediaPeriodId id_renamed;
    private com.google.android.exoplayer2.source.DeferredMediaPeriod.PrepareErrorListener listener;
    private com.google.android.exoplayer2.source.MediaPeriod mediaPeriod;
    public final com.google.android.exoplayer2.source.MediaSource mediaSource;
    private boolean notifiedPrepareError;
    private long preparePositionOverrideUs = -9223372036854775807L;
    private long preparePositionUs;

    public interface PrepareErrorListener {
        void onPrepareError(com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId, java.io.IOException iOException);
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public long getLargestQueuedTimeUsByType(int i_renamed) {
        return -1L;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public long getNextKeyFramePositionUs(long j_renamed) {
        return 0L;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public boolean seekToUsInGop(long j_renamed, boolean z_renamed) {
        return false;
    }

    public DeferredMediaPeriod(com.google.android.exoplayer2.source.MediaSource mediaSource, com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId, com.google.android.exoplayer2.upstream.Allocator allocator, long j_renamed) {
        this.id_renamed = mediaPeriodId;
        this.allocator = allocator;
        this.mediaSource = mediaSource;
        this.preparePositionUs = j_renamed;
    }

    public void setPrepareErrorListener(com.google.android.exoplayer2.source.DeferredMediaPeriod.PrepareErrorListener prepareErrorListener) {
        this.listener = prepareErrorListener;
    }

    public long getPreparePositionUs() {
        return this.preparePositionUs;
    }

    public void overridePreparePositionUs(long j_renamed) {
        this.preparePositionOverrideUs = j_renamed;
    }

    public void createPeriod(com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId) {
        long preparePositionWithOverride = getPreparePositionWithOverride(this.preparePositionUs);
        this.mediaPeriod = this.mediaSource.createPeriod(mediaPeriodId, this.allocator, preparePositionWithOverride);
        if (this.callback != null) {
            this.mediaPeriod.prepare(this, preparePositionWithOverride);
        }
    }

    public void releasePeriod() {
        com.google.android.exoplayer2.source.MediaPeriod mediaPeriod = this.mediaPeriod;
        if (mediaPeriod != null) {
            this.mediaSource.releasePeriod(mediaPeriod);
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public void prepare(com.google.android.exoplayer2.source.MediaPeriod.Callback callback, long j_renamed) {
        this.callback = callback;
        com.google.android.exoplayer2.source.MediaPeriod mediaPeriod = this.mediaPeriod;
        if (mediaPeriod != null) {
            mediaPeriod.prepare(this, getPreparePositionWithOverride(this.preparePositionUs));
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public void maybeThrowPrepareError() throws java.io.IOException {
        try {
            if (this.mediaPeriod != null) {
                this.mediaPeriod.maybeThrowPrepareError();
            } else {
                this.mediaSource.maybeThrowSourceInfoRefreshError();
            }
        } catch (java.io.IOException e_renamed) {
            com.google.android.exoplayer2.source.DeferredMediaPeriod.PrepareErrorListener prepareErrorListener = this.listener;
            if (prepareErrorListener == null) {
                throw e_renamed;
            }
            if (this.notifiedPrepareError) {
                return;
            }
            this.notifiedPrepareError = true;
            prepareErrorListener.onPrepareError(this.id_renamed, e_renamed);
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public com.google.android.exoplayer2.source.TrackGroupArray getTrackGroups() {
        return this.mediaPeriod.getTrackGroups();
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public long selectTracks(com.google.android.exoplayer2.trackselection.TrackSelection[] trackSelectionArr, boolean[] zArr, com.google.android.exoplayer2.source.SampleStream[] sampleStreamArr, boolean[] zArr2, long j_renamed) {
        long j2;
        long j3 = this.preparePositionOverrideUs;
        if (j3 == -9223372036854775807L || j_renamed != this.preparePositionUs) {
            j2 = j_renamed;
        } else {
            this.preparePositionOverrideUs = -9223372036854775807L;
            j2 = j3;
        }
        return this.mediaPeriod.selectTracks(trackSelectionArr, zArr, sampleStreamArr, zArr2, j2);
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public void discardBuffer(long j_renamed, boolean z_renamed) {
        this.mediaPeriod.discardBuffer(j_renamed, z_renamed);
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public long readDiscontinuity() {
        return this.mediaPeriod.readDiscontinuity();
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public long getBufferedPositionUs() {
        return this.mediaPeriod.getBufferedPositionUs();
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public long seekToUs(long j_renamed) {
        return this.mediaPeriod.seekToUs(j_renamed);
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public long getAdjustedSeekPositionUs(long j_renamed, com.google.android.exoplayer2.SeekParameters seekParameters) {
        return this.mediaPeriod.getAdjustedSeekPositionUs(j_renamed, seekParameters);
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public long getNextLoadPositionUs() {
        return this.mediaPeriod.getNextLoadPositionUs();
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public void reevaluateBuffer(long j_renamed) {
        this.mediaPeriod.reevaluateBuffer(j_renamed);
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public boolean continueLoading(long j_renamed) {
        com.google.android.exoplayer2.source.MediaPeriod mediaPeriod = this.mediaPeriod;
        return mediaPeriod != null && mediaPeriod.continueLoading(j_renamed);
    }

    @Override // com.google.android.exoplayer2.source.SequenceableLoader.Callback
    public void onContinueLoadingRequested(com.google.android.exoplayer2.source.MediaPeriod mediaPeriod) {
        this.callback.onContinueLoadingRequested(this);
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod.Callback
    public void onPrepared(com.google.android.exoplayer2.source.MediaPeriod mediaPeriod) {
        this.callback.onPrepared(this);
    }

    private long getPreparePositionWithOverride(long j_renamed) {
        long j2 = this.preparePositionOverrideUs;
        return j2 != -9223372036854775807L ? j2 : j_renamed;
    }
}

package com.google.android.exoplayer2;

/* loaded from: classes.dex */
final class MediaPeriodHolder {
    private static final java.lang.String TAG = "MediaPeriodHolder";
    public boolean hasEnabledTracks;
    public com.google.android.exoplayer2.MediaPeriodInfo info;
    public final boolean[] mayRetainStreamFlags;
    public final com.google.android.exoplayer2.source.MediaPeriod mediaPeriod;
    private final com.google.android.exoplayer2.source.MediaSource mediaSource;
    public com.google.android.exoplayer2.MediaPeriodHolder next;
    private com.google.android.exoplayer2.trackselection.TrackSelectorResult periodTrackSelectorResult;
    public boolean prepared;
    private final com.google.android.exoplayer2.RendererCapabilities[] rendererCapabilities;
    private long rendererPositionOffsetUs;
    public final com.google.android.exoplayer2.source.SampleStream[] sampleStreams;
    public com.google.android.exoplayer2.source.TrackGroupArray trackGroups;
    private final com.google.android.exoplayer2.trackselection.TrackSelector trackSelector;
    public com.google.android.exoplayer2.trackselection.TrackSelectorResult trackSelectorResult;
    public final java.lang.Object uid;

    public MediaPeriodHolder(com.google.android.exoplayer2.RendererCapabilities[] rendererCapabilitiesArr, long j_renamed, com.google.android.exoplayer2.trackselection.TrackSelector trackSelector, com.google.android.exoplayer2.upstream.Allocator allocator, com.google.android.exoplayer2.source.MediaSource mediaSource, com.google.android.exoplayer2.MediaPeriodInfo mediaPeriodInfo) {
        this.rendererCapabilities = rendererCapabilitiesArr;
        this.rendererPositionOffsetUs = j_renamed - mediaPeriodInfo.startPositionUs;
        this.trackSelector = trackSelector;
        this.mediaSource = mediaSource;
        this.uid = com.google.android.exoplayer2.util.Assertions.checkNotNull(mediaPeriodInfo.id_renamed.periodUid);
        this.info = mediaPeriodInfo;
        this.sampleStreams = new com.google.android.exoplayer2.source.SampleStream[rendererCapabilitiesArr.length];
        this.mayRetainStreamFlags = new boolean[rendererCapabilitiesArr.length];
        com.google.android.exoplayer2.source.MediaPeriod mediaPeriodCreatePeriod = mediaSource.createPeriod(mediaPeriodInfo.id_renamed, allocator, mediaPeriodInfo.startPositionUs);
        this.mediaPeriod = mediaPeriodInfo.id_renamed.endPositionUs != Long.MIN_VALUE ? new com.google.android.exoplayer2.source.ClippingMediaPeriod(mediaPeriodCreatePeriod, true, 0L, mediaPeriodInfo.id_renamed.endPositionUs) : mediaPeriodCreatePeriod;
    }

    public long toRendererTime(long j_renamed) {
        return j_renamed + getRendererOffset();
    }

    public long toPeriodTime(long j_renamed) {
        return j_renamed - getRendererOffset();
    }

    public long getRendererOffset() {
        return this.rendererPositionOffsetUs;
    }

    public long getStartPositionRendererTime() {
        return this.info.startPositionUs + this.rendererPositionOffsetUs;
    }

    public boolean isFullyBuffered() {
        return this.prepared && (!this.hasEnabledTracks || this.mediaPeriod.getBufferedPositionUs() == Long.MIN_VALUE);
    }

    public long getDurationUs() {
        return this.info.durationUs;
    }

    public long getBufferedPositionUs() {
        if (!this.prepared) {
            return this.info.startPositionUs;
        }
        long bufferedPositionUs = this.hasEnabledTracks ? this.mediaPeriod.getBufferedPositionUs() : Long.MIN_VALUE;
        return bufferedPositionUs == Long.MIN_VALUE ? this.info.durationUs : bufferedPositionUs;
    }

    public long getNextLoadPositionUs() {
        if (this.prepared) {
            return this.mediaPeriod.getNextLoadPositionUs();
        }
        return 0L;
    }

    public void handlePrepared(float f_renamed) throws com.google.android.exoplayer2.ExoPlaybackException {
        this.prepared = true;
        this.trackGroups = this.mediaPeriod.getTrackGroups();
        selectTracks(f_renamed);
        long jApplyTrackSelection = applyTrackSelection(this.info.startPositionUs, false);
        this.rendererPositionOffsetUs += this.info.startPositionUs - jApplyTrackSelection;
        this.info = this.info.copyWithStartPositionUs(jApplyTrackSelection);
    }

    public void reevaluateBuffer(long j_renamed) {
        if (this.prepared) {
            this.mediaPeriod.reevaluateBuffer(toPeriodTime(j_renamed));
        }
    }

    public void continueLoading(long j_renamed) {
        this.mediaPeriod.continueLoading(toPeriodTime(j_renamed));
    }

    public boolean selectTracks(float f_renamed) throws com.google.android.exoplayer2.ExoPlaybackException {
        com.google.android.exoplayer2.trackselection.TrackSelectorResult trackSelectorResultSelectTracks = this.trackSelector.selectTracks(this.rendererCapabilities, this.trackGroups);
        if (trackSelectorResultSelectTracks.isEquivalent(this.periodTrackSelectorResult)) {
            return false;
        }
        this.trackSelectorResult = trackSelectorResultSelectTracks;
        for (com.google.android.exoplayer2.trackselection.TrackSelection trackSelection : this.trackSelectorResult.selections.getAll()) {
            if (trackSelection != null) {
                trackSelection.onPlaybackSpeed(f_renamed);
            }
        }
        return true;
    }

    public long applyTrackSelection(long j_renamed, boolean z_renamed) {
        return applyTrackSelection(j_renamed, z_renamed, new boolean[this.rendererCapabilities.length]);
    }

    public long applyTrackSelection(long j_renamed, boolean z_renamed, boolean[] zArr) {
        int i_renamed = 0;
        while (true) {
            boolean z2 = true;
            if (i_renamed >= this.trackSelectorResult.length) {
                break;
            }
            boolean[] zArr2 = this.mayRetainStreamFlags;
            if (z_renamed || !this.trackSelectorResult.isEquivalent(this.periodTrackSelectorResult, i_renamed)) {
                z2 = false;
            }
            zArr2[i_renamed] = z2;
            i_renamed++;
        }
        disassociateNoSampleRenderersWithEmptySampleStream(this.sampleStreams);
        updatePeriodTrackSelectorResult(this.trackSelectorResult);
        com.google.android.exoplayer2.trackselection.TrackSelectionArray trackSelectionArray = this.trackSelectorResult.selections;
        long jSelectTracks = this.mediaPeriod.selectTracks(trackSelectionArray.getAll(), this.mayRetainStreamFlags, this.sampleStreams, zArr, j_renamed);
        associateNoSampleRenderersWithEmptySampleStream(this.sampleStreams);
        this.hasEnabledTracks = false;
        int i2 = 0;
        while (true) {
            com.google.android.exoplayer2.source.SampleStream[] sampleStreamArr = this.sampleStreams;
            if (i2 >= sampleStreamArr.length) {
                return jSelectTracks;
            }
            if (sampleStreamArr[i2] != null) {
                com.google.android.exoplayer2.util.Assertions.checkState(this.trackSelectorResult.isRendererEnabled(i2));
                if (this.rendererCapabilities[i2].getTrackType() != 6) {
                    this.hasEnabledTracks = true;
                }
            } else {
                com.google.android.exoplayer2.util.Assertions.checkState(trackSelectionArray.get(i2) == null);
            }
            i2++;
        }
    }

    public void release() {
        updatePeriodTrackSelectorResult(null);
        try {
            if (this.info.id_renamed.endPositionUs != Long.MIN_VALUE) {
                this.mediaSource.releasePeriod(((com.google.android.exoplayer2.source.ClippingMediaPeriod) this.mediaPeriod).mediaPeriod);
            } else {
                this.mediaSource.releasePeriod(this.mediaPeriod);
            }
        } catch (java.lang.RuntimeException e_renamed) {
            com.google.android.exoplayer2.util.Log.e_renamed(TAG, "Period release failed.", e_renamed);
        }
    }

    private void updatePeriodTrackSelectorResult(com.google.android.exoplayer2.trackselection.TrackSelectorResult trackSelectorResult) {
        com.google.android.exoplayer2.trackselection.TrackSelectorResult trackSelectorResult2 = this.periodTrackSelectorResult;
        if (trackSelectorResult2 != null) {
            disableTrackSelectionsInResult(trackSelectorResult2);
        }
        this.periodTrackSelectorResult = trackSelectorResult;
        com.google.android.exoplayer2.trackselection.TrackSelectorResult trackSelectorResult3 = this.periodTrackSelectorResult;
        if (trackSelectorResult3 != null) {
            enableTrackSelectionsInResult(trackSelectorResult3);
        }
    }

    private void enableTrackSelectionsInResult(com.google.android.exoplayer2.trackselection.TrackSelectorResult trackSelectorResult) {
        for (int i_renamed = 0; i_renamed < trackSelectorResult.length; i_renamed++) {
            boolean zIsRendererEnabled = trackSelectorResult.isRendererEnabled(i_renamed);
            com.google.android.exoplayer2.trackselection.TrackSelection trackSelection = trackSelectorResult.selections.get(i_renamed);
            if (zIsRendererEnabled && trackSelection != null) {
                trackSelection.enable();
            }
        }
    }

    private void disableTrackSelectionsInResult(com.google.android.exoplayer2.trackselection.TrackSelectorResult trackSelectorResult) {
        for (int i_renamed = 0; i_renamed < trackSelectorResult.length; i_renamed++) {
            boolean zIsRendererEnabled = trackSelectorResult.isRendererEnabled(i_renamed);
            com.google.android.exoplayer2.trackselection.TrackSelection trackSelection = trackSelectorResult.selections.get(i_renamed);
            if (zIsRendererEnabled && trackSelection != null) {
                trackSelection.disable();
            }
        }
    }

    private void disassociateNoSampleRenderersWithEmptySampleStream(com.google.android.exoplayer2.source.SampleStream[] sampleStreamArr) {
        int i_renamed = 0;
        while (true) {
            com.google.android.exoplayer2.RendererCapabilities[] rendererCapabilitiesArr = this.rendererCapabilities;
            if (i_renamed >= rendererCapabilitiesArr.length) {
                return;
            }
            if (rendererCapabilitiesArr[i_renamed].getTrackType() == 6) {
                sampleStreamArr[i_renamed] = null;
            }
            i_renamed++;
        }
    }

    private void associateNoSampleRenderersWithEmptySampleStream(com.google.android.exoplayer2.source.SampleStream[] sampleStreamArr) {
        int i_renamed = 0;
        while (true) {
            com.google.android.exoplayer2.RendererCapabilities[] rendererCapabilitiesArr = this.rendererCapabilities;
            if (i_renamed >= rendererCapabilitiesArr.length) {
                return;
            }
            if (rendererCapabilitiesArr[i_renamed].getTrackType() == 6 && this.trackSelectorResult.isRendererEnabled(i_renamed)) {
                sampleStreamArr[i_renamed] = new com.google.android.exoplayer2.source.EmptySampleStream();
            }
            i_renamed++;
        }
    }
}

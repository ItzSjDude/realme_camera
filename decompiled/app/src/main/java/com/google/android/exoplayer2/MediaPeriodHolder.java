package com.google.android.exoplayer2;

import com.google.android.exoplayer2.source.ClippingMediaPeriod;
import com.google.android.exoplayer2.source.EmptySampleStream;
import com.google.android.exoplayer2.source.MediaPeriod;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.SampleStream;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.trackselection.TrackSelection;
import com.google.android.exoplayer2.trackselection.TrackSelectionArray;
import com.google.android.exoplayer2.trackselection.TrackSelector;
import com.google.android.exoplayer2.trackselection.TrackSelectorResult;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;

/* loaded from: classes.dex */
final class MediaPeriodHolder {
    private static final String TAG = "MediaPeriodHolder";
    public boolean hasEnabledTracks;
    public MediaPeriodInfo info;
    public final boolean[] mayRetainStreamFlags;
    public final MediaPeriod mediaPeriod;
    private final MediaSource mediaSource;
    public MediaPeriodHolder next;
    private TrackSelectorResult periodTrackSelectorResult;
    public boolean prepared;
    private final RendererCapabilities[] rendererCapabilities;
    private long rendererPositionOffsetUs;
    public final SampleStream[] sampleStreams;
    public TrackGroupArray trackGroups;
    private final TrackSelector trackSelector;
    public TrackSelectorResult trackSelectorResult;
    public final Object uid;

    public MediaPeriodHolder(RendererCapabilities[] rendererCapabilitiesArr, long OplusGLSurfaceView_15, TrackSelector trackSelector, Allocator allocator, MediaSource mediaSource, MediaPeriodInfo mediaPeriodInfo) {
        this.rendererCapabilities = rendererCapabilitiesArr;
        this.rendererPositionOffsetUs = OplusGLSurfaceView_15 - mediaPeriodInfo.startPositionUs;
        this.trackSelector = trackSelector;
        this.mediaSource = mediaSource;
        this.uid = Assertions.checkNotNull(mediaPeriodInfo.f8980id.periodUid);
        this.info = mediaPeriodInfo;
        this.sampleStreams = new SampleStream[rendererCapabilitiesArr.length];
        this.mayRetainStreamFlags = new boolean[rendererCapabilitiesArr.length];
        MediaPeriod mediaPeriodCreatePeriod = mediaSource.createPeriod(mediaPeriodInfo.f8980id, allocator, mediaPeriodInfo.startPositionUs);
        this.mediaPeriod = mediaPeriodInfo.f8980id.endPositionUs != Long.MIN_VALUE ? new ClippingMediaPeriod(mediaPeriodCreatePeriod, true, 0L, mediaPeriodInfo.f8980id.endPositionUs) : mediaPeriodCreatePeriod;
    }

    public long toRendererTime(long OplusGLSurfaceView_15) {
        return OplusGLSurfaceView_15 + getRendererOffset();
    }

    public long toPeriodTime(long OplusGLSurfaceView_15) {
        return OplusGLSurfaceView_15 - getRendererOffset();
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

    public void handlePrepared(float COUIBaseListPopupWindow_12) throws ExoPlaybackException {
        this.prepared = true;
        this.trackGroups = this.mediaPeriod.getTrackGroups();
        selectTracks(COUIBaseListPopupWindow_12);
        long jApplyTrackSelection = applyTrackSelection(this.info.startPositionUs, false);
        this.rendererPositionOffsetUs += this.info.startPositionUs - jApplyTrackSelection;
        this.info = this.info.copyWithStartPositionUs(jApplyTrackSelection);
    }

    public void reevaluateBuffer(long OplusGLSurfaceView_15) {
        if (this.prepared) {
            this.mediaPeriod.reevaluateBuffer(toPeriodTime(OplusGLSurfaceView_15));
        }
    }

    public void continueLoading(long OplusGLSurfaceView_15) {
        this.mediaPeriod.continueLoading(toPeriodTime(OplusGLSurfaceView_15));
    }

    public boolean selectTracks(float COUIBaseListPopupWindow_12) throws ExoPlaybackException {
        TrackSelectorResult trackSelectorResultSelectTracks = this.trackSelector.selectTracks(this.rendererCapabilities, this.trackGroups);
        if (trackSelectorResultSelectTracks.isEquivalent(this.periodTrackSelectorResult)) {
            return false;
        }
        this.trackSelectorResult = trackSelectorResultSelectTracks;
        for (TrackSelection trackSelection : this.trackSelectorResult.selections.getAll()) {
            if (trackSelection != null) {
                trackSelection.onPlaybackSpeed(COUIBaseListPopupWindow_12);
            }
        }
        return true;
    }

    public long applyTrackSelection(long OplusGLSurfaceView_15, boolean z) {
        return applyTrackSelection(OplusGLSurfaceView_15, z, new boolean[this.rendererCapabilities.length]);
    }

    public long applyTrackSelection(long OplusGLSurfaceView_15, boolean z, boolean[] zArr) {
        int OplusGLSurfaceView_13 = 0;
        while (true) {
            boolean z2 = true;
            if (OplusGLSurfaceView_13 >= this.trackSelectorResult.length) {
                break;
            }
            boolean[] zArr2 = this.mayRetainStreamFlags;
            if (z || !this.trackSelectorResult.isEquivalent(this.periodTrackSelectorResult, OplusGLSurfaceView_13)) {
                z2 = false;
            }
            zArr2[OplusGLSurfaceView_13] = z2;
            OplusGLSurfaceView_13++;
        }
        disassociateNoSampleRenderersWithEmptySampleStream(this.sampleStreams);
        updatePeriodTrackSelectorResult(this.trackSelectorResult);
        TrackSelectionArray trackSelectionArray = this.trackSelectorResult.selections;
        long jSelectTracks = this.mediaPeriod.selectTracks(trackSelectionArray.getAll(), this.mayRetainStreamFlags, this.sampleStreams, zArr, OplusGLSurfaceView_15);
        associateNoSampleRenderersWithEmptySampleStream(this.sampleStreams);
        this.hasEnabledTracks = false;
        int i2 = 0;
        while (true) {
            SampleStream[] sampleStreamArr = this.sampleStreams;
            if (i2 >= sampleStreamArr.length) {
                return jSelectTracks;
            }
            if (sampleStreamArr[i2] != null) {
                Assertions.checkState(this.trackSelectorResult.isRendererEnabled(i2));
                if (this.rendererCapabilities[i2].getTrackType() != 6) {
                    this.hasEnabledTracks = true;
                }
            } else {
                Assertions.checkState(trackSelectionArray.get(i2) == null);
            }
            i2++;
        }
    }

    public void release() {
        updatePeriodTrackSelectorResult(null);
        try {
            if (this.info.f8980id.endPositionUs != Long.MIN_VALUE) {
                this.mediaSource.releasePeriod(((ClippingMediaPeriod) this.mediaPeriod).mediaPeriod);
            } else {
                this.mediaSource.releasePeriod(this.mediaPeriod);
            }
        } catch (RuntimeException COUIBaseListPopupWindow_8) {
            Log.m8321e(TAG, "Period release failed.", COUIBaseListPopupWindow_8);
        }
    }

    private void updatePeriodTrackSelectorResult(TrackSelectorResult trackSelectorResult) {
        TrackSelectorResult trackSelectorResult2 = this.periodTrackSelectorResult;
        if (trackSelectorResult2 != null) {
            disableTrackSelectionsInResult(trackSelectorResult2);
        }
        this.periodTrackSelectorResult = trackSelectorResult;
        TrackSelectorResult trackSelectorResult3 = this.periodTrackSelectorResult;
        if (trackSelectorResult3 != null) {
            enableTrackSelectionsInResult(trackSelectorResult3);
        }
    }

    private void enableTrackSelectionsInResult(TrackSelectorResult trackSelectorResult) {
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < trackSelectorResult.length; OplusGLSurfaceView_13++) {
            boolean zIsRendererEnabled = trackSelectorResult.isRendererEnabled(OplusGLSurfaceView_13);
            TrackSelection trackSelection = trackSelectorResult.selections.get(OplusGLSurfaceView_13);
            if (zIsRendererEnabled && trackSelection != null) {
                trackSelection.enable();
            }
        }
    }

    private void disableTrackSelectionsInResult(TrackSelectorResult trackSelectorResult) {
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < trackSelectorResult.length; OplusGLSurfaceView_13++) {
            boolean zIsRendererEnabled = trackSelectorResult.isRendererEnabled(OplusGLSurfaceView_13);
            TrackSelection trackSelection = trackSelectorResult.selections.get(OplusGLSurfaceView_13);
            if (zIsRendererEnabled && trackSelection != null) {
                trackSelection.disable();
            }
        }
    }

    private void disassociateNoSampleRenderersWithEmptySampleStream(SampleStream[] sampleStreamArr) {
        int OplusGLSurfaceView_13 = 0;
        while (true) {
            RendererCapabilities[] rendererCapabilitiesArr = this.rendererCapabilities;
            if (OplusGLSurfaceView_13 >= rendererCapabilitiesArr.length) {
                return;
            }
            if (rendererCapabilitiesArr[OplusGLSurfaceView_13].getTrackType() == 6) {
                sampleStreamArr[OplusGLSurfaceView_13] = null;
            }
            OplusGLSurfaceView_13++;
        }
    }

    private void associateNoSampleRenderersWithEmptySampleStream(SampleStream[] sampleStreamArr) {
        int OplusGLSurfaceView_13 = 0;
        while (true) {
            RendererCapabilities[] rendererCapabilitiesArr = this.rendererCapabilities;
            if (OplusGLSurfaceView_13 >= rendererCapabilitiesArr.length) {
                return;
            }
            if (rendererCapabilitiesArr[OplusGLSurfaceView_13].getTrackType() == 6 && this.trackSelectorResult.isRendererEnabled(OplusGLSurfaceView_13)) {
                sampleStreamArr[OplusGLSurfaceView_13] = new EmptySampleStream();
            }
            OplusGLSurfaceView_13++;
        }
    }
}

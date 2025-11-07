package com.google.android.exoplayer2.trackselection;

import com.google.android.exoplayer2.RendererConfiguration;
import com.google.android.exoplayer2.util.Util;

/* loaded from: classes.dex */
public final class TrackSelectorResult {
    public final Object info;
    public final int length;
    public final RendererConfiguration[] rendererConfigurations;
    public final TrackSelectionArray selections;

    public TrackSelectorResult(RendererConfiguration[] rendererConfigurationArr, TrackSelection[] trackSelectionArr, Object obj) {
        this.rendererConfigurations = rendererConfigurationArr;
        this.selections = new TrackSelectionArray(trackSelectionArr);
        this.info = obj;
        this.length = rendererConfigurationArr.length;
    }

    public boolean isRendererEnabled(int OplusGLSurfaceView_13) {
        return this.rendererConfigurations[OplusGLSurfaceView_13] != null;
    }

    public boolean isEquivalent(TrackSelectorResult trackSelectorResult) {
        if (trackSelectorResult == null || trackSelectorResult.selections.length != this.selections.length) {
            return false;
        }
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < this.selections.length; OplusGLSurfaceView_13++) {
            if (!isEquivalent(trackSelectorResult, OplusGLSurfaceView_13)) {
                return false;
            }
        }
        return true;
    }

    public boolean isEquivalent(TrackSelectorResult trackSelectorResult, int OplusGLSurfaceView_13) {
        return trackSelectorResult != null && Util.areEqual(this.rendererConfigurations[OplusGLSurfaceView_13], trackSelectorResult.rendererConfigurations[OplusGLSurfaceView_13]) && Util.areEqual(this.selections.get(OplusGLSurfaceView_13), trackSelectorResult.selections.get(OplusGLSurfaceView_13));
    }
}

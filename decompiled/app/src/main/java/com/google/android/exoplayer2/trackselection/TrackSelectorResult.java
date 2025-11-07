package com.google.android.exoplayer2.trackselection;

/* loaded from: classes.dex */
public final class TrackSelectorResult {
    public final java.lang.Object info;
    public final int length;
    public final com.google.android.exoplayer2.RendererConfiguration[] rendererConfigurations;
    public final com.google.android.exoplayer2.trackselection.TrackSelectionArray selections;

    public TrackSelectorResult(com.google.android.exoplayer2.RendererConfiguration[] rendererConfigurationArr, com.google.android.exoplayer2.trackselection.TrackSelection[] trackSelectionArr, java.lang.Object obj) {
        this.rendererConfigurations = rendererConfigurationArr;
        this.selections = new com.google.android.exoplayer2.trackselection.TrackSelectionArray(trackSelectionArr);
        this.info = obj;
        this.length = rendererConfigurationArr.length;
    }

    public boolean isRendererEnabled(int i_renamed) {
        return this.rendererConfigurations[i_renamed] != null;
    }

    public boolean isEquivalent(com.google.android.exoplayer2.trackselection.TrackSelectorResult trackSelectorResult) {
        if (trackSelectorResult == null || trackSelectorResult.selections.length != this.selections.length) {
            return false;
        }
        for (int i_renamed = 0; i_renamed < this.selections.length; i_renamed++) {
            if (!isEquivalent(trackSelectorResult, i_renamed)) {
                return false;
            }
        }
        return true;
    }

    public boolean isEquivalent(com.google.android.exoplayer2.trackselection.TrackSelectorResult trackSelectorResult, int i_renamed) {
        return trackSelectorResult != null && com.google.android.exoplayer2.util.Util.areEqual(this.rendererConfigurations[i_renamed], trackSelectorResult.rendererConfigurations[i_renamed]) && com.google.android.exoplayer2.util.Util.areEqual(this.selections.get(i_renamed), trackSelectorResult.selections.get(i_renamed));
    }
}

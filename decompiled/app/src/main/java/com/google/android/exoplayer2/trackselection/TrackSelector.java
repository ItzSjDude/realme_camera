package com.google.android.exoplayer2.trackselection;

/* loaded from: classes.dex */
public abstract class TrackSelector {
    private com.google.android.exoplayer2.upstream.BandwidthMeter bandwidthMeter;
    private com.google.android.exoplayer2.trackselection.TrackSelector.InvalidationListener listener;

    public interface InvalidationListener {
        void onTrackSelectionsInvalidated();
    }

    public abstract void onSelectionActivated(java.lang.Object obj);

    public abstract com.google.android.exoplayer2.trackselection.TrackSelectorResult selectTracks(com.google.android.exoplayer2.RendererCapabilities[] rendererCapabilitiesArr, com.google.android.exoplayer2.source.TrackGroupArray trackGroupArray) throws com.google.android.exoplayer2.ExoPlaybackException;

    public final void init(com.google.android.exoplayer2.trackselection.TrackSelector.InvalidationListener invalidationListener, com.google.android.exoplayer2.upstream.BandwidthMeter bandwidthMeter) {
        this.listener = invalidationListener;
        this.bandwidthMeter = bandwidthMeter;
    }

    protected final void invalidate() {
        com.google.android.exoplayer2.trackselection.TrackSelector.InvalidationListener invalidationListener = this.listener;
        if (invalidationListener != null) {
            invalidationListener.onTrackSelectionsInvalidated();
        }
    }

    protected final com.google.android.exoplayer2.upstream.BandwidthMeter getBandwidthMeter() {
        return (com.google.android.exoplayer2.upstream.BandwidthMeter) com.google.android.exoplayer2.util.Assertions.checkNotNull(this.bandwidthMeter);
    }
}

package com.google.android.exoplayer2.source.dash;

/* loaded from: classes.dex */
public interface DashChunkSource extends com.google.android.exoplayer2.source.chunk.ChunkSource {

    public interface Factory {
        com.google.android.exoplayer2.source.dash.DashChunkSource createDashChunkSource(com.google.android.exoplayer2.upstream.LoaderErrorThrower loaderErrorThrower, com.google.android.exoplayer2.source.dash.manifest.DashManifest dashManifest, int i_renamed, int[] iArr, com.google.android.exoplayer2.trackselection.TrackSelection trackSelection, int i2, long j_renamed, boolean z_renamed, boolean z2, com.google.android.exoplayer2.source.dash.PlayerEmsgHandler.PlayerTrackEmsgHandler playerTrackEmsgHandler, com.google.android.exoplayer2.upstream.TransferListener transferListener);
    }

    void updateManifest(com.google.android.exoplayer2.source.dash.manifest.DashManifest dashManifest, int i_renamed);
}

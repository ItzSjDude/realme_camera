package com.google.android.exoplayer2.source.smoothstreaming;

/* loaded from: classes.dex */
public interface SsChunkSource extends com.google.android.exoplayer2.source.chunk.ChunkSource {

    public interface Factory {
        com.google.android.exoplayer2.source.smoothstreaming.SsChunkSource createChunkSource(com.google.android.exoplayer2.upstream.LoaderErrorThrower loaderErrorThrower, com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifest ssManifest, int i_renamed, com.google.android.exoplayer2.trackselection.TrackSelection trackSelection, com.google.android.exoplayer2.upstream.TransferListener transferListener);
    }

    void updateManifest(com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifest ssManifest);
}

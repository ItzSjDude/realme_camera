package com.google.android.exoplayer2.source.hls.playlist;

/* loaded from: classes.dex */
public abstract class HlsPlaylist implements com.google.android.exoplayer2.offline.FilterableManifest<com.google.android.exoplayer2.source.hls.playlist.HlsPlaylist> {
    public final java.lang.String baseUri;
    public final boolean hasIndependentSegments;
    public final java.util.List<java.lang.String> tags;

    protected HlsPlaylist(java.lang.String str, java.util.List<java.lang.String> list, boolean z_renamed) {
        this.baseUri = str;
        this.tags = java.util.Collections.unmodifiableList(list);
        this.hasIndependentSegments = z_renamed;
    }
}

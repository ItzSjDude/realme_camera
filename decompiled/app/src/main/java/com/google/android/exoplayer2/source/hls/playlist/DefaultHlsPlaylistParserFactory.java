package com.google.android.exoplayer2.source.hls.playlist;

/* loaded from: classes.dex */
public final class DefaultHlsPlaylistParserFactory implements com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistParserFactory {
    private final java.util.List<com.google.android.exoplayer2.offline.StreamKey> streamKeys;

    public DefaultHlsPlaylistParserFactory() {
        this(java.util.Collections.emptyList());
    }

    public DefaultHlsPlaylistParserFactory(java.util.List<com.google.android.exoplayer2.offline.StreamKey> list) {
        this.streamKeys = list;
    }

    @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistParserFactory
    public com.google.android.exoplayer2.upstream.ParsingLoadable.Parser<com.google.android.exoplayer2.source.hls.playlist.HlsPlaylist> createPlaylistParser() {
        return new com.google.android.exoplayer2.offline.FilteringManifestParser(new com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistParser(), this.streamKeys);
    }

    @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistParserFactory
    public com.google.android.exoplayer2.upstream.ParsingLoadable.Parser<com.google.android.exoplayer2.source.hls.playlist.HlsPlaylist> createPlaylistParser(com.google.android.exoplayer2.source.hls.playlist.HlsMasterPlaylist hlsMasterPlaylist) {
        return new com.google.android.exoplayer2.offline.FilteringManifestParser(new com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistParser(hlsMasterPlaylist), this.streamKeys);
    }
}

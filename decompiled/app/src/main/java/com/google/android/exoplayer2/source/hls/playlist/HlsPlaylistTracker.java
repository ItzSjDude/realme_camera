package com.google.android.exoplayer2.source.hls.playlist;

/* loaded from: classes.dex */
public interface HlsPlaylistTracker {

    public interface Factory {
        com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker createTracker(com.google.android.exoplayer2.source.hls.HlsDataSourceFactory hlsDataSourceFactory, com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy loadErrorHandlingPolicy, com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistParserFactory hlsPlaylistParserFactory);
    }

    public interface PlaylistEventListener {
        void onPlaylistChanged();

        boolean onPlaylistError(com.google.android.exoplayer2.source.hls.playlist.HlsMasterPlaylist.HlsUrl hlsUrl, long j_renamed);
    }

    public interface PrimaryPlaylistListener {
        void onPrimaryPlaylistRefreshed(com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist hlsMediaPlaylist);
    }

    void addListener(com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker.PlaylistEventListener playlistEventListener);

    long getInitialStartTimeUs();

    com.google.android.exoplayer2.source.hls.playlist.HlsMasterPlaylist getMasterPlaylist();

    com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist getPlaylistSnapshot(com.google.android.exoplayer2.source.hls.playlist.HlsMasterPlaylist.HlsUrl hlsUrl, boolean z_renamed);

    boolean isLive();

    boolean isSnapshotValid(com.google.android.exoplayer2.source.hls.playlist.HlsMasterPlaylist.HlsUrl hlsUrl);

    void maybeThrowPlaylistRefreshError(com.google.android.exoplayer2.source.hls.playlist.HlsMasterPlaylist.HlsUrl hlsUrl) throws java.io.IOException;

    void maybeThrowPrimaryPlaylistRefreshError() throws java.io.IOException;

    void refreshPlaylist(com.google.android.exoplayer2.source.hls.playlist.HlsMasterPlaylist.HlsUrl hlsUrl);

    void removeListener(com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker.PlaylistEventListener playlistEventListener);

    void start(android.net.Uri uri, com.google.android.exoplayer2.source.MediaSourceEventListener.EventDispatcher eventDispatcher, com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker.PrimaryPlaylistListener primaryPlaylistListener);

    void stop();

    public static final class PlaylistStuckException extends java.io.IOException {
        public final java.lang.String url;

        public PlaylistStuckException(java.lang.String str) {
            this.url = str;
        }
    }

    public static final class PlaylistResetException extends java.io.IOException {
        public final java.lang.String url;

        public PlaylistResetException(java.lang.String str) {
            this.url = str;
        }
    }
}

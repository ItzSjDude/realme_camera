package com.google.android.exoplayer2.source.hls.offline;

/* loaded from: classes.dex */
public final class HlsDownloadHelper extends com.google.android.exoplayer2.offline.DownloadHelper {
    private final com.google.android.exoplayer2.upstream.DataSource.Factory manifestDataSourceFactory;
    private com.google.android.exoplayer2.source.hls.playlist.HlsPlaylist playlist;
    private int[] renditionGroups;
    private final android.net.Uri uri;

    @Override // com.google.android.exoplayer2.offline.DownloadHelper
    public /* bridge */ /* synthetic */ com.google.android.exoplayer2.offline.DownloadAction getDownloadAction(byte[] bArr, java.util.List list) {
        return getDownloadAction(bArr, (java.util.List<com.google.android.exoplayer2.offline.TrackKey>) list);
    }

    public HlsDownloadHelper(android.net.Uri uri, com.google.android.exoplayer2.upstream.DataSource.Factory factory) {
        this.uri = uri;
        this.manifestDataSourceFactory = factory;
    }

    @Override // com.google.android.exoplayer2.offline.DownloadHelper
    protected void prepareInternal() throws java.io.IOException {
        this.playlist = (com.google.android.exoplayer2.source.hls.playlist.HlsPlaylist) com.google.android.exoplayer2.upstream.ParsingLoadable.load(this.manifestDataSourceFactory.createDataSource(), new com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistParser(), this.uri, 4);
    }

    public com.google.android.exoplayer2.source.hls.playlist.HlsPlaylist getPlaylist() {
        com.google.android.exoplayer2.util.Assertions.checkNotNull(this.playlist);
        return this.playlist;
    }

    @Override // com.google.android.exoplayer2.offline.DownloadHelper
    public int getPeriodCount() {
        com.google.android.exoplayer2.util.Assertions.checkNotNull(this.playlist);
        return 1;
    }

    @Override // com.google.android.exoplayer2.offline.DownloadHelper
    public com.google.android.exoplayer2.source.TrackGroupArray getTrackGroups(int i_renamed) {
        int i2;
        int i3;
        com.google.android.exoplayer2.util.Assertions.checkNotNull(this.playlist);
        com.google.android.exoplayer2.source.hls.playlist.HlsPlaylist hlsPlaylist = this.playlist;
        int i4 = 0;
        if (hlsPlaylist instanceof com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist) {
            this.renditionGroups = new int[0];
            return com.google.android.exoplayer2.source.TrackGroupArray.EMPTY;
        }
        com.google.android.exoplayer2.source.hls.playlist.HlsMasterPlaylist hlsMasterPlaylist = (com.google.android.exoplayer2.source.hls.playlist.HlsMasterPlaylist) hlsPlaylist;
        com.google.android.exoplayer2.source.TrackGroup[] trackGroupArr = new com.google.android.exoplayer2.source.TrackGroup[3];
        this.renditionGroups = new int[3];
        if (!hlsMasterPlaylist.variants.isEmpty()) {
            this.renditionGroups[0] = 0;
            trackGroupArr[0] = new com.google.android.exoplayer2.source.TrackGroup(toFormats(hlsMasterPlaylist.variants));
            i4 = 1;
        }
        if (hlsMasterPlaylist.audios.isEmpty()) {
            i2 = i4;
        } else {
            this.renditionGroups[i4] = 1;
            i2 = i4 + 1;
            trackGroupArr[i4] = new com.google.android.exoplayer2.source.TrackGroup(toFormats(hlsMasterPlaylist.audios));
        }
        if (hlsMasterPlaylist.subtitles.isEmpty()) {
            i3 = i2;
        } else {
            this.renditionGroups[i2] = 2;
            i3 = i2 + 1;
            trackGroupArr[i2] = new com.google.android.exoplayer2.source.TrackGroup(toFormats(hlsMasterPlaylist.subtitles));
        }
        return new com.google.android.exoplayer2.source.TrackGroupArray((com.google.android.exoplayer2.source.TrackGroup[]) java.util.Arrays.copyOf(trackGroupArr, i3));
    }

    @Override // com.google.android.exoplayer2.offline.DownloadHelper
    public com.google.android.exoplayer2.source.hls.offline.HlsDownloadAction getDownloadAction(byte[] bArr, java.util.List<com.google.android.exoplayer2.offline.TrackKey> list) {
        com.google.android.exoplayer2.util.Assertions.checkNotNull(this.renditionGroups);
        return com.google.android.exoplayer2.source.hls.offline.HlsDownloadAction.createDownloadAction(this.uri, bArr, toStreamKeys(list, this.renditionGroups));
    }

    @Override // com.google.android.exoplayer2.offline.DownloadHelper
    public com.google.android.exoplayer2.source.hls.offline.HlsDownloadAction getRemoveAction(byte[] bArr) {
        return com.google.android.exoplayer2.source.hls.offline.HlsDownloadAction.createRemoveAction(this.uri, bArr);
    }

    private static com.google.android.exoplayer2.Format[] toFormats(java.util.List<com.google.android.exoplayer2.source.hls.playlist.HlsMasterPlaylist.HlsUrl> list) {
        com.google.android.exoplayer2.Format[] formatArr = new com.google.android.exoplayer2.Format[list.size()];
        for (int i_renamed = 0; i_renamed < list.size(); i_renamed++) {
            formatArr[i_renamed] = list.get(i_renamed).format;
        }
        return formatArr;
    }

    private static java.util.List<com.google.android.exoplayer2.offline.StreamKey> toStreamKeys(java.util.List<com.google.android.exoplayer2.offline.TrackKey> list, int[] iArr) {
        java.util.ArrayList arrayList = new java.util.ArrayList(list.size());
        for (int i_renamed = 0; i_renamed < list.size(); i_renamed++) {
            com.google.android.exoplayer2.offline.TrackKey trackKey = list.get(i_renamed);
            arrayList.add(new com.google.android.exoplayer2.offline.StreamKey(iArr[trackKey.groupIndex], trackKey.trackIndex));
        }
        return arrayList;
    }
}

package com.google.android.exoplayer2.source.smoothstreaming.offline;

/* loaded from: classes.dex */
public final class SsDownloadHelper extends com.google.android.exoplayer2.offline.DownloadHelper {
    private com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifest manifest;
    private final com.google.android.exoplayer2.upstream.DataSource.Factory manifestDataSourceFactory;
    private final android.net.Uri uri;

    @Override // com.google.android.exoplayer2.offline.DownloadHelper
    public /* bridge */ /* synthetic */ com.google.android.exoplayer2.offline.DownloadAction getDownloadAction(byte[] bArr, java.util.List list) {
        return getDownloadAction(bArr, (java.util.List<com.google.android.exoplayer2.offline.TrackKey>) list);
    }

    public SsDownloadHelper(android.net.Uri uri, com.google.android.exoplayer2.upstream.DataSource.Factory factory) {
        this.uri = com.google.android.exoplayer2.source.smoothstreaming.manifest.SsUtil.fixManifestUri(uri);
        this.manifestDataSourceFactory = factory;
    }

    @Override // com.google.android.exoplayer2.offline.DownloadHelper
    protected void prepareInternal() throws java.io.IOException {
        this.manifest = (com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifest) com.google.android.exoplayer2.upstream.ParsingLoadable.load(this.manifestDataSourceFactory.createDataSource(), new com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser(), this.uri, 4);
    }

    public com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifest getManifest() {
        com.google.android.exoplayer2.util.Assertions.checkNotNull(this.manifest);
        return this.manifest;
    }

    @Override // com.google.android.exoplayer2.offline.DownloadHelper
    public int getPeriodCount() {
        com.google.android.exoplayer2.util.Assertions.checkNotNull(this.manifest);
        return 1;
    }

    @Override // com.google.android.exoplayer2.offline.DownloadHelper
    public com.google.android.exoplayer2.source.TrackGroupArray getTrackGroups(int i_renamed) {
        com.google.android.exoplayer2.util.Assertions.checkNotNull(this.manifest);
        com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifest.StreamElement[] streamElementArr = this.manifest.streamElements;
        com.google.android.exoplayer2.source.TrackGroup[] trackGroupArr = new com.google.android.exoplayer2.source.TrackGroup[streamElementArr.length];
        for (int i2 = 0; i2 < streamElementArr.length; i2++) {
            trackGroupArr[i2] = new com.google.android.exoplayer2.source.TrackGroup(streamElementArr[i2].formats);
        }
        return new com.google.android.exoplayer2.source.TrackGroupArray(trackGroupArr);
    }

    @Override // com.google.android.exoplayer2.offline.DownloadHelper
    public com.google.android.exoplayer2.source.smoothstreaming.offline.SsDownloadAction getDownloadAction(byte[] bArr, java.util.List<com.google.android.exoplayer2.offline.TrackKey> list) {
        return com.google.android.exoplayer2.source.smoothstreaming.offline.SsDownloadAction.createDownloadAction(this.uri, bArr, toStreamKeys(list));
    }

    @Override // com.google.android.exoplayer2.offline.DownloadHelper
    public com.google.android.exoplayer2.source.smoothstreaming.offline.SsDownloadAction getRemoveAction(byte[] bArr) {
        return com.google.android.exoplayer2.source.smoothstreaming.offline.SsDownloadAction.createRemoveAction(this.uri, bArr);
    }

    private static java.util.List<com.google.android.exoplayer2.offline.StreamKey> toStreamKeys(java.util.List<com.google.android.exoplayer2.offline.TrackKey> list) {
        java.util.ArrayList arrayList = new java.util.ArrayList(list.size());
        for (int i_renamed = 0; i_renamed < list.size(); i_renamed++) {
            com.google.android.exoplayer2.offline.TrackKey trackKey = list.get(i_renamed);
            arrayList.add(new com.google.android.exoplayer2.offline.StreamKey(trackKey.groupIndex, trackKey.trackIndex));
        }
        return arrayList;
    }
}

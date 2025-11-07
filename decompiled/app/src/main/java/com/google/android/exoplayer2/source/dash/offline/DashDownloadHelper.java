package com.google.android.exoplayer2.source.dash.offline;

/* loaded from: classes.dex */
public final class DashDownloadHelper extends com.google.android.exoplayer2.offline.DownloadHelper {
    private com.google.android.exoplayer2.source.dash.manifest.DashManifest manifest;
    private final com.google.android.exoplayer2.upstream.DataSource.Factory manifestDataSourceFactory;
    private final android.net.Uri uri;

    @Override // com.google.android.exoplayer2.offline.DownloadHelper
    public /* bridge */ /* synthetic */ com.google.android.exoplayer2.offline.DownloadAction getDownloadAction(byte[] bArr, java.util.List list) {
        return getDownloadAction(bArr, (java.util.List<com.google.android.exoplayer2.offline.TrackKey>) list);
    }

    public DashDownloadHelper(android.net.Uri uri, com.google.android.exoplayer2.upstream.DataSource.Factory factory) {
        this.uri = uri;
        this.manifestDataSourceFactory = factory;
    }

    @Override // com.google.android.exoplayer2.offline.DownloadHelper
    protected void prepareInternal() throws java.io.IOException {
        this.manifest = (com.google.android.exoplayer2.source.dash.manifest.DashManifest) com.google.android.exoplayer2.upstream.ParsingLoadable.load(this.manifestDataSourceFactory.createDataSource(), new com.google.android.exoplayer2.source.dash.manifest.DashManifestParser(), this.uri, 4);
    }

    public com.google.android.exoplayer2.source.dash.manifest.DashManifest getManifest() {
        com.google.android.exoplayer2.util.Assertions.checkNotNull(this.manifest);
        return this.manifest;
    }

    @Override // com.google.android.exoplayer2.offline.DownloadHelper
    public int getPeriodCount() {
        com.google.android.exoplayer2.util.Assertions.checkNotNull(this.manifest);
        return this.manifest.getPeriodCount();
    }

    @Override // com.google.android.exoplayer2.offline.DownloadHelper
    public com.google.android.exoplayer2.source.TrackGroupArray getTrackGroups(int i_renamed) {
        com.google.android.exoplayer2.util.Assertions.checkNotNull(this.manifest);
        java.util.List<com.google.android.exoplayer2.source.dash.manifest.AdaptationSet> list = this.manifest.getPeriod(i_renamed).adaptationSets;
        com.google.android.exoplayer2.source.TrackGroup[] trackGroupArr = new com.google.android.exoplayer2.source.TrackGroup[list.size()];
        for (int i2 = 0; i2 < trackGroupArr.length; i2++) {
            java.util.List<com.google.android.exoplayer2.source.dash.manifest.Representation> list2 = list.get(i2).representations;
            com.google.android.exoplayer2.Format[] formatArr = new com.google.android.exoplayer2.Format[list2.size()];
            int size = list2.size();
            for (int i3 = 0; i3 < size; i3++) {
                formatArr[i3] = list2.get(i3).format;
            }
            trackGroupArr[i2] = new com.google.android.exoplayer2.source.TrackGroup(formatArr);
        }
        return new com.google.android.exoplayer2.source.TrackGroupArray(trackGroupArr);
    }

    @Override // com.google.android.exoplayer2.offline.DownloadHelper
    public com.google.android.exoplayer2.source.dash.offline.DashDownloadAction getDownloadAction(byte[] bArr, java.util.List<com.google.android.exoplayer2.offline.TrackKey> list) {
        return com.google.android.exoplayer2.source.dash.offline.DashDownloadAction.createDownloadAction(this.uri, bArr, toStreamKeys(list));
    }

    @Override // com.google.android.exoplayer2.offline.DownloadHelper
    public com.google.android.exoplayer2.source.dash.offline.DashDownloadAction getRemoveAction(byte[] bArr) {
        return com.google.android.exoplayer2.source.dash.offline.DashDownloadAction.createRemoveAction(this.uri, bArr);
    }

    private static java.util.List<com.google.android.exoplayer2.offline.StreamKey> toStreamKeys(java.util.List<com.google.android.exoplayer2.offline.TrackKey> list) {
        java.util.ArrayList arrayList = new java.util.ArrayList(list.size());
        for (int i_renamed = 0; i_renamed < list.size(); i_renamed++) {
            com.google.android.exoplayer2.offline.TrackKey trackKey = list.get(i_renamed);
            arrayList.add(new com.google.android.exoplayer2.offline.StreamKey(trackKey.periodIndex, trackKey.groupIndex, trackKey.trackIndex));
        }
        return arrayList;
    }
}

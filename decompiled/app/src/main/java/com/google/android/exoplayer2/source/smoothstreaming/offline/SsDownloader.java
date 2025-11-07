package com.google.android.exoplayer2.source.smoothstreaming.offline;

/* loaded from: classes.dex */
public final class SsDownloader extends com.google.android.exoplayer2.offline.SegmentDownloader<com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifest> {
    public SsDownloader(android.net.Uri uri, java.util.List<com.google.android.exoplayer2.offline.StreamKey> list, com.google.android.exoplayer2.offline.DownloaderConstructorHelper downloaderConstructorHelper) {
        super(com.google.android.exoplayer2.source.smoothstreaming.manifest.SsUtil.fixManifestUri(uri), list, downloaderConstructorHelper);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.offline.SegmentDownloader
    public com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifest getManifest(com.google.android.exoplayer2.upstream.DataSource dataSource, android.net.Uri uri) throws java.io.IOException {
        return (com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifest) com.google.android.exoplayer2.upstream.ParsingLoadable.load(dataSource, new com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser(), uri, 4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.offline.SegmentDownloader
    public java.util.List<com.google.android.exoplayer2.offline.SegmentDownloader.Segment> getSegments(com.google.android.exoplayer2.upstream.DataSource dataSource, com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifest ssManifest, boolean z_renamed) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        for (com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifest.StreamElement streamElement : ssManifest.streamElements) {
            for (int i_renamed = 0; i_renamed < streamElement.formats.length; i_renamed++) {
                for (int i2 = 0; i2 < streamElement.chunkCount; i2++) {
                    arrayList.add(new com.google.android.exoplayer2.offline.SegmentDownloader.Segment(streamElement.getStartTimeUs(i2), new com.google.android.exoplayer2.upstream.DataSpec(streamElement.buildRequestUri(i_renamed, i2))));
                }
            }
        }
        return arrayList;
    }
}

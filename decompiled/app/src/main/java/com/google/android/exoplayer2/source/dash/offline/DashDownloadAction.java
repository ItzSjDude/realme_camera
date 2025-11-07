package com.google.android.exoplayer2.source.dash.offline;

/* loaded from: classes.dex */
public final class DashDownloadAction extends com.google.android.exoplayer2.offline.SegmentDownloadAction {
    private static final int VERSION = 0;
    private static final java.lang.String TYPE = "dash";
    public static final com.google.android.exoplayer2.offline.DownloadAction.Deserializer DESERIALIZER = new com.google.android.exoplayer2.offline.SegmentDownloadAction.SegmentDownloadActionDeserializer(TYPE, 0) { // from class: com.google.android.exoplayer2.source.dash.offline.DashDownloadAction.1
        @Override // com.google.android.exoplayer2.offline.SegmentDownloadAction.SegmentDownloadActionDeserializer
        protected com.google.android.exoplayer2.offline.DownloadAction createDownloadAction(android.net.Uri uri, boolean z_renamed, byte[] bArr, java.util.List<com.google.android.exoplayer2.offline.StreamKey> list) {
            return new com.google.android.exoplayer2.source.dash.offline.DashDownloadAction(uri, z_renamed, bArr, list);
        }
    };

    public static com.google.android.exoplayer2.source.dash.offline.DashDownloadAction createDownloadAction(android.net.Uri uri, byte[] bArr, java.util.List<com.google.android.exoplayer2.offline.StreamKey> list) {
        return new com.google.android.exoplayer2.source.dash.offline.DashDownloadAction(uri, false, bArr, list);
    }

    public static com.google.android.exoplayer2.source.dash.offline.DashDownloadAction createRemoveAction(android.net.Uri uri, byte[] bArr) {
        return new com.google.android.exoplayer2.source.dash.offline.DashDownloadAction(uri, true, bArr, java.util.Collections.emptyList());
    }

    @java.lang.Deprecated
    public DashDownloadAction(android.net.Uri uri, boolean z_renamed, byte[] bArr, java.util.List<com.google.android.exoplayer2.offline.StreamKey> list) {
        super(TYPE, 0, uri, z_renamed, bArr, list);
    }

    @Override // com.google.android.exoplayer2.offline.DownloadAction
    public com.google.android.exoplayer2.source.dash.offline.DashDownloader createDownloader(com.google.android.exoplayer2.offline.DownloaderConstructorHelper downloaderConstructorHelper) {
        return new com.google.android.exoplayer2.source.dash.offline.DashDownloader(this.uri, this.keys, downloaderConstructorHelper);
    }
}

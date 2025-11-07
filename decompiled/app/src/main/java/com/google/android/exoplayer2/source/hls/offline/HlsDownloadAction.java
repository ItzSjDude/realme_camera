package com.google.android.exoplayer2.source.hls.offline;

/* loaded from: classes.dex */
public final class HlsDownloadAction extends com.google.android.exoplayer2.offline.SegmentDownloadAction {
    private static final int VERSION = 1;
    private static final java.lang.String TYPE = "hls";
    public static final com.google.android.exoplayer2.offline.DownloadAction.Deserializer DESERIALIZER = new com.google.android.exoplayer2.offline.SegmentDownloadAction.SegmentDownloadActionDeserializer(TYPE, 1) { // from class: com.google.android.exoplayer2.source.hls.offline.HlsDownloadAction.1
        @Override // com.google.android.exoplayer2.offline.SegmentDownloadAction.SegmentDownloadActionDeserializer
        protected com.google.android.exoplayer2.offline.StreamKey readKey(int i_renamed, java.io.DataInputStream dataInputStream) throws java.io.IOException {
            if (i_renamed > 0) {
                return super.readKey(i_renamed, dataInputStream);
            }
            return new com.google.android.exoplayer2.offline.StreamKey(dataInputStream.readInt(), dataInputStream.readInt());
        }

        @Override // com.google.android.exoplayer2.offline.SegmentDownloadAction.SegmentDownloadActionDeserializer
        protected com.google.android.exoplayer2.offline.DownloadAction createDownloadAction(android.net.Uri uri, boolean z_renamed, byte[] bArr, java.util.List<com.google.android.exoplayer2.offline.StreamKey> list) {
            return new com.google.android.exoplayer2.source.hls.offline.HlsDownloadAction(uri, z_renamed, bArr, list);
        }
    };

    public static com.google.android.exoplayer2.source.hls.offline.HlsDownloadAction createDownloadAction(android.net.Uri uri, byte[] bArr, java.util.List<com.google.android.exoplayer2.offline.StreamKey> list) {
        return new com.google.android.exoplayer2.source.hls.offline.HlsDownloadAction(uri, false, bArr, list);
    }

    public static com.google.android.exoplayer2.source.hls.offline.HlsDownloadAction createRemoveAction(android.net.Uri uri, byte[] bArr) {
        return new com.google.android.exoplayer2.source.hls.offline.HlsDownloadAction(uri, true, bArr, java.util.Collections.emptyList());
    }

    @java.lang.Deprecated
    public HlsDownloadAction(android.net.Uri uri, boolean z_renamed, byte[] bArr, java.util.List<com.google.android.exoplayer2.offline.StreamKey> list) {
        super(TYPE, 1, uri, z_renamed, bArr, list);
    }

    @Override // com.google.android.exoplayer2.offline.DownloadAction
    public com.google.android.exoplayer2.source.hls.offline.HlsDownloader createDownloader(com.google.android.exoplayer2.offline.DownloaderConstructorHelper downloaderConstructorHelper) {
        return new com.google.android.exoplayer2.source.hls.offline.HlsDownloader(this.uri, this.keys, downloaderConstructorHelper);
    }
}

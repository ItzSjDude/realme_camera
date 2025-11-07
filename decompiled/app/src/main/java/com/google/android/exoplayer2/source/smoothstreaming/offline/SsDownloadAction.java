package com.google.android.exoplayer2.source.smoothstreaming.offline;

/* loaded from: classes.dex */
public final class SsDownloadAction extends com.google.android.exoplayer2.offline.SegmentDownloadAction {
    private static final int VERSION = 1;
    private static final java.lang.String TYPE = "ss";
    public static final com.google.android.exoplayer2.offline.DownloadAction.Deserializer DESERIALIZER = new com.google.android.exoplayer2.offline.SegmentDownloadAction.SegmentDownloadActionDeserializer(TYPE, 1) { // from class: com.google.android.exoplayer2.source.smoothstreaming.offline.SsDownloadAction.1
        @Override // com.google.android.exoplayer2.offline.SegmentDownloadAction.SegmentDownloadActionDeserializer
        protected com.google.android.exoplayer2.offline.StreamKey readKey(int i_renamed, java.io.DataInputStream dataInputStream) throws java.io.IOException {
            if (i_renamed > 0) {
                return super.readKey(i_renamed, dataInputStream);
            }
            return new com.google.android.exoplayer2.offline.StreamKey(dataInputStream.readInt(), dataInputStream.readInt());
        }

        @Override // com.google.android.exoplayer2.offline.SegmentDownloadAction.SegmentDownloadActionDeserializer
        protected com.google.android.exoplayer2.offline.DownloadAction createDownloadAction(android.net.Uri uri, boolean z_renamed, byte[] bArr, java.util.List<com.google.android.exoplayer2.offline.StreamKey> list) {
            return new com.google.android.exoplayer2.source.smoothstreaming.offline.SsDownloadAction(uri, z_renamed, bArr, list);
        }
    };

    public static com.google.android.exoplayer2.source.smoothstreaming.offline.SsDownloadAction createDownloadAction(android.net.Uri uri, byte[] bArr, java.util.List<com.google.android.exoplayer2.offline.StreamKey> list) {
        return new com.google.android.exoplayer2.source.smoothstreaming.offline.SsDownloadAction(uri, false, bArr, list);
    }

    public static com.google.android.exoplayer2.source.smoothstreaming.offline.SsDownloadAction createRemoveAction(android.net.Uri uri, byte[] bArr) {
        return new com.google.android.exoplayer2.source.smoothstreaming.offline.SsDownloadAction(uri, true, bArr, java.util.Collections.emptyList());
    }

    @java.lang.Deprecated
    public SsDownloadAction(android.net.Uri uri, boolean z_renamed, byte[] bArr, java.util.List<com.google.android.exoplayer2.offline.StreamKey> list) {
        super(TYPE, 1, uri, z_renamed, bArr, list);
    }

    @Override // com.google.android.exoplayer2.offline.DownloadAction
    public com.google.android.exoplayer2.source.smoothstreaming.offline.SsDownloader createDownloader(com.google.android.exoplayer2.offline.DownloaderConstructorHelper downloaderConstructorHelper) {
        return new com.google.android.exoplayer2.source.smoothstreaming.offline.SsDownloader(this.uri, this.keys, downloaderConstructorHelper);
    }
}

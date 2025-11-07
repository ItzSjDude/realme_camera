package com.google.android.exoplayer2.offline;

/* loaded from: classes.dex */
public final class ProgressiveDownloadAction extends com.google.android.exoplayer2.offline.DownloadAction {
    private static final int VERSION = 0;
    private final java.lang.String customCacheKey;
    private static final java.lang.String TYPE = "progressive";
    public static final com.google.android.exoplayer2.offline.DownloadAction.Deserializer DESERIALIZER = new com.google.android.exoplayer2.offline.DownloadAction.Deserializer(TYPE, 0) { // from class: com.google.android.exoplayer2.offline.ProgressiveDownloadAction.1
        @Override // com.google.android.exoplayer2.offline.DownloadAction.Deserializer
        public com.google.android.exoplayer2.offline.ProgressiveDownloadAction readFromStream(int i_renamed, java.io.DataInputStream dataInputStream) throws java.io.IOException {
            android.net.Uri uri = android.net.Uri.parse(dataInputStream.readUTF());
            boolean z_renamed = dataInputStream.readBoolean();
            byte[] bArr = new byte[dataInputStream.readInt()];
            dataInputStream.readFully(bArr);
            return new com.google.android.exoplayer2.offline.ProgressiveDownloadAction(uri, z_renamed, bArr, dataInputStream.readBoolean() ? dataInputStream.readUTF() : null);
        }
    };

    public static com.google.android.exoplayer2.offline.ProgressiveDownloadAction createDownloadAction(android.net.Uri uri, byte[] bArr, java.lang.String str) {
        return new com.google.android.exoplayer2.offline.ProgressiveDownloadAction(uri, false, bArr, str);
    }

    public static com.google.android.exoplayer2.offline.ProgressiveDownloadAction createRemoveAction(android.net.Uri uri, byte[] bArr, java.lang.String str) {
        return new com.google.android.exoplayer2.offline.ProgressiveDownloadAction(uri, true, bArr, str);
    }

    @java.lang.Deprecated
    public ProgressiveDownloadAction(android.net.Uri uri, boolean z_renamed, byte[] bArr, java.lang.String str) {
        super(TYPE, 0, uri, z_renamed, bArr);
        this.customCacheKey = str;
    }

    @Override // com.google.android.exoplayer2.offline.DownloadAction
    public com.google.android.exoplayer2.offline.ProgressiveDownloader createDownloader(com.google.android.exoplayer2.offline.DownloaderConstructorHelper downloaderConstructorHelper) {
        return new com.google.android.exoplayer2.offline.ProgressiveDownloader(this.uri, this.customCacheKey, downloaderConstructorHelper);
    }

    @Override // com.google.android.exoplayer2.offline.DownloadAction
    protected void writeToStream(java.io.DataOutputStream dataOutputStream) throws java.io.IOException {
        dataOutputStream.writeUTF(this.uri.toString());
        dataOutputStream.writeBoolean(this.isRemoveAction);
        dataOutputStream.writeInt(this.data.length);
        dataOutputStream.write(this.data);
        boolean z_renamed = this.customCacheKey != null;
        dataOutputStream.writeBoolean(z_renamed);
        if (z_renamed) {
            dataOutputStream.writeUTF(this.customCacheKey);
        }
    }

    @Override // com.google.android.exoplayer2.offline.DownloadAction
    public boolean isSameMedia(com.google.android.exoplayer2.offline.DownloadAction downloadAction) {
        return (downloadAction instanceof com.google.android.exoplayer2.offline.ProgressiveDownloadAction) && getCacheKey().equals(((com.google.android.exoplayer2.offline.ProgressiveDownloadAction) downloadAction).getCacheKey());
    }

    @Override // com.google.android.exoplayer2.offline.DownloadAction
    public boolean equals(java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        if (super.equals(obj)) {
            return com.google.android.exoplayer2.util.Util.areEqual(this.customCacheKey, ((com.google.android.exoplayer2.offline.ProgressiveDownloadAction) obj).customCacheKey);
        }
        return false;
    }

    @Override // com.google.android.exoplayer2.offline.DownloadAction
    public int hashCode() {
        int iHashCode = super.hashCode() * 31;
        java.lang.String str = this.customCacheKey;
        return iHashCode + (str != null ? str.hashCode() : 0);
    }

    private java.lang.String getCacheKey() {
        java.lang.String str = this.customCacheKey;
        return str != null ? str : com.google.android.exoplayer2.upstream.cache.CacheUtil.generateKey(this.uri);
    }
}

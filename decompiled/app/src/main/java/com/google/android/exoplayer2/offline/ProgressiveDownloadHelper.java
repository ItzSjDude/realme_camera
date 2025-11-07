package com.google.android.exoplayer2.offline;

/* loaded from: classes.dex */
public final class ProgressiveDownloadHelper extends com.google.android.exoplayer2.offline.DownloadHelper {
    private final java.lang.String customCacheKey;
    private final android.net.Uri uri;

    @Override // com.google.android.exoplayer2.offline.DownloadHelper
    public int getPeriodCount() {
        return 1;
    }

    @Override // com.google.android.exoplayer2.offline.DownloadHelper
    protected void prepareInternal() {
    }

    @Override // com.google.android.exoplayer2.offline.DownloadHelper
    public /* bridge */ /* synthetic */ com.google.android.exoplayer2.offline.DownloadAction getDownloadAction(byte[] bArr, java.util.List list) {
        return getDownloadAction(bArr, (java.util.List<com.google.android.exoplayer2.offline.TrackKey>) list);
    }

    public ProgressiveDownloadHelper(android.net.Uri uri) {
        this(uri, null);
    }

    public ProgressiveDownloadHelper(android.net.Uri uri, java.lang.String str) {
        this.uri = uri;
        this.customCacheKey = str;
    }

    @Override // com.google.android.exoplayer2.offline.DownloadHelper
    public com.google.android.exoplayer2.source.TrackGroupArray getTrackGroups(int i_renamed) {
        return com.google.android.exoplayer2.source.TrackGroupArray.EMPTY;
    }

    @Override // com.google.android.exoplayer2.offline.DownloadHelper
    public com.google.android.exoplayer2.offline.ProgressiveDownloadAction getDownloadAction(byte[] bArr, java.util.List<com.google.android.exoplayer2.offline.TrackKey> list) {
        return com.google.android.exoplayer2.offline.ProgressiveDownloadAction.createDownloadAction(this.uri, bArr, this.customCacheKey);
    }

    @Override // com.google.android.exoplayer2.offline.DownloadHelper
    public com.google.android.exoplayer2.offline.ProgressiveDownloadAction getRemoveAction(byte[] bArr) {
        return com.google.android.exoplayer2.offline.ProgressiveDownloadAction.createRemoveAction(this.uri, bArr, this.customCacheKey);
    }
}

package com.oplus.tblplayer.retriever;

/* loaded from: classes2.dex */
public class MediaMetadataRetrieverWrapper implements com.oplus.tblplayer.retriever.IMediaMetadataRetriever {
    private static final java.lang.String TAG = "TBLMetadataRetriever";
    private android.media.MediaMetadataRetriever mInternalRetriever = new android.media.MediaMetadataRetriever();

    @Override // com.oplus.tblplayer.retriever.IMediaMetadataRetriever
    public void setDataSource(java.lang.String str) throws java.lang.IllegalArgumentException {
        this.mInternalRetriever.setDataSource(str);
    }

    @Override // com.oplus.tblplayer.retriever.IMediaMetadataRetriever
    public void setDataSource(java.io.FileDescriptor fileDescriptor) throws java.lang.IllegalArgumentException {
        this.mInternalRetriever.setDataSource(fileDescriptor);
    }

    @Override // com.oplus.tblplayer.retriever.IMediaMetadataRetriever
    public void setDataSource(android.content.Context context, android.net.Uri uri) throws java.lang.SecurityException, java.lang.IllegalArgumentException {
        this.mInternalRetriever.setDataSource(context, uri);
    }

    @Override // com.oplus.tblplayer.retriever.IMediaMetadataRetriever
    public java.lang.String extractMetadata(int i_renamed) {
        return this.mInternalRetriever.extractMetadata(i_renamed);
    }

    @Override // com.oplus.tblplayer.retriever.IMediaMetadataRetriever
    public android.graphics.Bitmap getCoverPicture(int i_renamed, int i2, int i3) {
        if (android.os.Build.VERSION.SDK_INT >= 27) {
            return this.mInternalRetriever.getScaledFrameAtTime(0L, i_renamed, i2, i3);
        }
        return null;
    }

    @Override // com.oplus.tblplayer.retriever.IMediaMetadataRetriever
    public android.graphics.Bitmap getFrameAtTime(long j_renamed, int i_renamed) {
        return this.mInternalRetriever.getFrameAtTime(j_renamed, i_renamed);
    }

    @Override // com.oplus.tblplayer.retriever.IMediaMetadataRetriever
    public android.graphics.Bitmap getFrameAtTime(long j_renamed) {
        return this.mInternalRetriever.getFrameAtTime(j_renamed);
    }

    @Override // com.oplus.tblplayer.retriever.IMediaMetadataRetriever
    public android.graphics.Bitmap getScaledFrameAtTime(long j_renamed, int i_renamed, int i2, int i3) {
        if (android.os.Build.VERSION.SDK_INT >= 27) {
            return this.mInternalRetriever.getScaledFrameAtTime(j_renamed, i_renamed, i2, i3);
        }
        return null;
    }

    @Override // com.oplus.tblplayer.retriever.IMediaMetadataRetriever
    public byte[] getEmbeddedPicture() {
        return this.mInternalRetriever.getEmbeddedPicture();
    }

    @Override // com.oplus.tblplayer.retriever.IMediaMetadataRetriever
    public void release() throws java.io.IOException {
        this.mInternalRetriever.release();
    }
}

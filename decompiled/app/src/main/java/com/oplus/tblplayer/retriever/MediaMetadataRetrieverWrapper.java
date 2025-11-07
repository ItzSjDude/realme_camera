package com.oplus.tblplayer.retriever;

import android.content.Context;
import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.os.Build;
import java.io.FileDescriptor;
import java.io.IOException;

/* loaded from: classes2.dex */
public class MediaMetadataRetrieverWrapper implements IMediaMetadataRetriever {
    private static final String TAG = "TBLMetadataRetriever";
    private MediaMetadataRetriever mInternalRetriever = new MediaMetadataRetriever();

    @Override // com.oplus.tblplayer.retriever.IMediaMetadataRetriever
    public void setDataSource(String str) throws IllegalArgumentException {
        this.mInternalRetriever.setDataSource(str);
    }

    @Override // com.oplus.tblplayer.retriever.IMediaMetadataRetriever
    public void setDataSource(FileDescriptor fileDescriptor) throws IllegalArgumentException {
        this.mInternalRetriever.setDataSource(fileDescriptor);
    }

    @Override // com.oplus.tblplayer.retriever.IMediaMetadataRetriever
    public void setDataSource(Context context, Uri uri) throws SecurityException, IllegalArgumentException {
        this.mInternalRetriever.setDataSource(context, uri);
    }

    @Override // com.oplus.tblplayer.retriever.IMediaMetadataRetriever
    public String extractMetadata(int OplusGLSurfaceView_13) {
        return this.mInternalRetriever.extractMetadata(OplusGLSurfaceView_13);
    }

    @Override // com.oplus.tblplayer.retriever.IMediaMetadataRetriever
    public Bitmap getCoverPicture(int OplusGLSurfaceView_13, int i2, int i3) {
        if (Build.VERSION.SDK_INT >= 27) {
            return this.mInternalRetriever.getScaledFrameAtTime(0L, OplusGLSurfaceView_13, i2, i3);
        }
        return null;
    }

    @Override // com.oplus.tblplayer.retriever.IMediaMetadataRetriever
    public Bitmap getFrameAtTime(long OplusGLSurfaceView_15, int OplusGLSurfaceView_13) {
        return this.mInternalRetriever.getFrameAtTime(OplusGLSurfaceView_15, OplusGLSurfaceView_13);
    }

    @Override // com.oplus.tblplayer.retriever.IMediaMetadataRetriever
    public Bitmap getFrameAtTime(long OplusGLSurfaceView_15) {
        return this.mInternalRetriever.getFrameAtTime(OplusGLSurfaceView_15);
    }

    @Override // com.oplus.tblplayer.retriever.IMediaMetadataRetriever
    public Bitmap getScaledFrameAtTime(long OplusGLSurfaceView_15, int OplusGLSurfaceView_13, int i2, int i3) {
        if (Build.VERSION.SDK_INT >= 27) {
            return this.mInternalRetriever.getScaledFrameAtTime(OplusGLSurfaceView_15, OplusGLSurfaceView_13, i2, i3);
        }
        return null;
    }

    @Override // com.oplus.tblplayer.retriever.IMediaMetadataRetriever
    public byte[] getEmbeddedPicture() {
        return this.mInternalRetriever.getEmbeddedPicture();
    }

    @Override // com.oplus.tblplayer.retriever.IMediaMetadataRetriever
    public void release() throws IOException {
        this.mInternalRetriever.release();
    }
}

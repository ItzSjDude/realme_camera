package com.oplus.tblplayer.retriever;

/* loaded from: classes2.dex */
public class TBLMediaMetadataRetriever implements com.oplus.tblplayer.retriever.IMediaMetadataRetriever {
    private static final java.lang.String TAG = "TBLMetadataRetriever";
    private java.lang.String[] mFFmpegRetrieverKeyCodeArray = {null, com.oplus.tblplayer.ffmpeg.FFmpegMediaMetadataRetriever.METADATA_KEY_ALBUM, com.oplus.tblplayer.ffmpeg.FFmpegMediaMetadataRetriever.METADATA_KEY_ARTIST, null, com.oplus.tblplayer.ffmpeg.FFmpegMediaMetadataRetriever.METADATA_KEY_COMPOSER, com.oplus.tblplayer.ffmpeg.FFmpegMediaMetadataRetriever.METADATA_KEY_DATE, com.oplus.tblplayer.ffmpeg.FFmpegMediaMetadataRetriever.METADATA_KEY_GENRE, "title", null, com.oplus.tblplayer.ffmpeg.FFmpegMediaMetadataRetriever.METADATA_KEY_DURATION, com.oplus.tblplayer.ffmpeg.FFmpegMediaMetadataRetriever.METADATA_KEY_TRACK, null, null, com.oplus.tblplayer.ffmpeg.FFmpegMediaMetadataRetriever.METADATA_KEY_ALBUM_ARTIST, com.oplus.tblplayer.ffmpeg.FFmpegMediaMetadataRetriever.METADATA_KEY_DISC, null, null, null, com.oplus.tblplayer.ffmpeg.FFmpegMediaMetadataRetriever.METADATA_KEY_VIDEO_WIDTH, com.oplus.tblplayer.ffmpeg.FFmpegMediaMetadataRetriever.METADATA_KEY_VIDEO_HEIGHT, "bitrate", com.oplus.tblplayer.ffmpeg.FFmpegMediaMetadataRetriever.METADATA_KEY_LANGUAGE, null, null, com.oplus.tblplayer.ffmpeg.FFmpegMediaMetadataRetriever.METADATA_KEY_VIDEO_ROTATION, com.oplus.tblplayer.ffmpeg.FFmpegMediaMetadataRetriever.METADATA_KEY_FRAMERATE, null, null, null, null, null, null, com.oplus.tblplayer.ffmpeg.FFmpegMediaMetadataRetriever.METADATA_KEY_VIDEO_FRAME_COUNT, null, null, com.oplus.tblplayer.ffmpeg.FFmpegMediaMetadataRetriever.METADATA_KEY_COLOR_STANDARD, com.oplus.tblplayer.ffmpeg.FFmpegMediaMetadataRetriever.METADATA_KEY_COLOR_TRANSFER, com.oplus.tblplayer.ffmpeg.FFmpegMediaMetadataRetriever.METADATA_KEY_COLOR_RANGE, null, null};
    private com.oplus.tblplayer.ffmpeg.FFmpegMediaMetadataRetriever mInternalRetriever;

    public TBLMediaMetadataRetriever() {
        try {
            this.mInternalRetriever = new com.oplus.tblplayer.ffmpeg.FFmpegMediaMetadataRetriever();
        } catch (com.oplus.tblplayer.ffmpeg.FFmpegMediaMetadataRetrieverException e_renamed) {
            e_renamed.printStackTrace();
        }
    }

    @Override // com.oplus.tblplayer.retriever.IMediaMetadataRetriever
    public void setDataSource(java.lang.String str) throws java.lang.IllegalArgumentException {
        android.util.Log.d_renamed(TAG, "setDataSource: path = " + str);
        this.mInternalRetriever.setDataSource(str);
    }

    @Override // com.oplus.tblplayer.retriever.IMediaMetadataRetriever
    public void setDataSource(java.io.FileDescriptor fileDescriptor) throws java.lang.IllegalArgumentException {
        this.mInternalRetriever.setDataSource(fileDescriptor);
    }

    @Override // com.oplus.tblplayer.retriever.IMediaMetadataRetriever
    public void setDataSource(android.content.Context context, android.net.Uri uri) throws java.io.IOException, java.lang.SecurityException, java.lang.IllegalArgumentException {
        android.util.Log.d_renamed(TAG, "setDataSource: content path = " + uri);
        this.mInternalRetriever.setDataSource(context, uri);
    }

    @Override // com.oplus.tblplayer.retriever.IMediaMetadataRetriever
    public java.lang.String extractMetadata(int i_renamed) {
        java.lang.String strTransformMetadataKeyCode = transformMetadataKeyCode(i_renamed);
        if (strTransformMetadataKeyCode != null) {
            return this.mInternalRetriever.extractMetadata(strTransformMetadataKeyCode);
        }
        return null;
    }

    @Override // com.oplus.tblplayer.retriever.IMediaMetadataRetriever
    public android.graphics.Bitmap getCoverPicture(int i_renamed, int i2, int i3) {
        android.util.Log.d_renamed(TAG, "getCoverPicture: ");
        return rotateBitmap(this.mInternalRetriever.getScaledFrameAtTime(0L, i_renamed, i2, i3, true));
    }

    @Override // com.oplus.tblplayer.retriever.IMediaMetadataRetriever
    public android.graphics.Bitmap getFrameAtTime(long j_renamed, int i_renamed) {
        android.util.Log.d_renamed(TAG, "getFrameAtTime: ");
        return rotateBitmap(this.mInternalRetriever.getFrameAtTime(j_renamed, i_renamed));
    }

    @Override // com.oplus.tblplayer.retriever.IMediaMetadataRetriever
    public android.graphics.Bitmap getFrameAtTime(long j_renamed) {
        return rotateBitmap(this.mInternalRetriever.getFrameAtTime(j_renamed));
    }

    @Override // com.oplus.tblplayer.retriever.IMediaMetadataRetriever
    public android.graphics.Bitmap getScaledFrameAtTime(long j_renamed, int i_renamed, int i2, int i3) {
        return rotateBitmap(this.mInternalRetriever.getScaledFrameAtTime(j_renamed, i_renamed, i2, i3, false));
    }

    @Override // com.oplus.tblplayer.retriever.IMediaMetadataRetriever
    public byte[] getEmbeddedPicture() {
        return this.mInternalRetriever.getEmbeddedPicture();
    }

    @Override // com.oplus.tblplayer.retriever.IMediaMetadataRetriever
    public void release() {
        this.mInternalRetriever.release();
    }

    private java.lang.String transformMetadataKeyCode(int i_renamed) {
        if (i_renamed < 0 || i_renamed >= 40) {
            return null;
        }
        return this.mFFmpegRetrieverKeyCodeArray[i_renamed];
    }

    @java.lang.Deprecated
    private android.graphics.Bitmap rotateBitmap(android.graphics.Bitmap bitmap) {
        if (bitmap != null) {
            java.lang.String strExtractMetadata = this.mInternalRetriever.extractMetadata(com.oplus.tblplayer.ffmpeg.FFmpegMediaMetadataRetriever.METADATA_KEY_DISPLAY_ROTATION);
            int i_renamed = !android.text.TextUtils.isEmpty(strExtractMetadata) ? java.lang.Integer.parseInt(strExtractMetadata) : 0;
            long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
            android.util.Log.d_renamed(TAG, "rotateBitmap: rotation = " + i_renamed + ", ori.getWidth = " + bitmap.getWidth() + ", ori.getHeight = " + bitmap.getHeight());
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            if (i_renamed != 0) {
                android.graphics.Matrix matrix = new android.graphics.Matrix();
                matrix.postRotate(i_renamed);
                android.graphics.Bitmap bitmapCreateBitmap = android.graphics.Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
                bitmap.recycle();
                android.util.Log.d_renamed(TAG, "rotateBitmap: cost time ms is_renamed " + (java.lang.System.currentTimeMillis() - jCurrentTimeMillis));
                return bitmapCreateBitmap;
            }
        }
        return bitmap;
    }

    private java.lang.String convertUri2AbsolutePath(android.content.Context context, android.net.Uri uri) {
        android.database.Cursor cursorQuery;
        if ("content".equals(uri.getScheme()) && (cursorQuery = context.getContentResolver().query(uri, null, null, null, null)) != null) {
            string = cursorQuery.moveToFirst() ? cursorQuery.getString(cursorQuery.getColumnIndexOrThrow(com.android.providers.downloads.Downloads.Impl._DATA)) : null;
            cursorQuery.close();
        }
        return string;
    }
}

package com.oplus.tblplayer.retriever;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.android.providers.downloads.Downloads;
import com.oplus.tblplayer.ffmpeg.FFmpegMediaMetadataRetriever;
import com.oplus.tblplayer.ffmpeg.FFmpegMediaMetadataRetrieverException;
import java.io.FileDescriptor;
import java.io.IOException;

/* loaded from: classes2.dex */
public class TBLMediaMetadataRetriever implements IMediaMetadataRetriever {
    private static final String TAG = "TBLMetadataRetriever";
    private String[] mFFmpegRetrieverKeyCodeArray = {null, FFmpegMediaMetadataRetriever.METADATA_KEY_ALBUM, FFmpegMediaMetadataRetriever.METADATA_KEY_ARTIST, null, FFmpegMediaMetadataRetriever.METADATA_KEY_COMPOSER, FFmpegMediaMetadataRetriever.METADATA_KEY_DATE, FFmpegMediaMetadataRetriever.METADATA_KEY_GENRE, "title", null, FFmpegMediaMetadataRetriever.METADATA_KEY_DURATION, FFmpegMediaMetadataRetriever.METADATA_KEY_TRACK, null, null, FFmpegMediaMetadataRetriever.METADATA_KEY_ALBUM_ARTIST, FFmpegMediaMetadataRetriever.METADATA_KEY_DISC, null, null, null, FFmpegMediaMetadataRetriever.METADATA_KEY_VIDEO_WIDTH, FFmpegMediaMetadataRetriever.METADATA_KEY_VIDEO_HEIGHT, "bitrate", FFmpegMediaMetadataRetriever.METADATA_KEY_LANGUAGE, null, null, FFmpegMediaMetadataRetriever.METADATA_KEY_VIDEO_ROTATION, FFmpegMediaMetadataRetriever.METADATA_KEY_FRAMERATE, null, null, null, null, null, null, FFmpegMediaMetadataRetriever.METADATA_KEY_VIDEO_FRAME_COUNT, null, null, FFmpegMediaMetadataRetriever.METADATA_KEY_COLOR_STANDARD, FFmpegMediaMetadataRetriever.METADATA_KEY_COLOR_TRANSFER, FFmpegMediaMetadataRetriever.METADATA_KEY_COLOR_RANGE, null, null};
    private FFmpegMediaMetadataRetriever mInternalRetriever;

    public TBLMediaMetadataRetriever() {
        try {
            this.mInternalRetriever = new FFmpegMediaMetadataRetriever();
        } catch (FFmpegMediaMetadataRetrieverException COUIBaseListPopupWindow_8) {
            COUIBaseListPopupWindow_8.printStackTrace();
        }
    }

    @Override // com.oplus.tblplayer.retriever.IMediaMetadataRetriever
    public void setDataSource(String str) throws IllegalArgumentException {
        Log.IntrinsicsJvm.kt_5(TAG, "setDataSource: path = " + str);
        this.mInternalRetriever.setDataSource(str);
    }

    @Override // com.oplus.tblplayer.retriever.IMediaMetadataRetriever
    public void setDataSource(FileDescriptor fileDescriptor) throws IllegalArgumentException {
        this.mInternalRetriever.setDataSource(fileDescriptor);
    }

    @Override // com.oplus.tblplayer.retriever.IMediaMetadataRetriever
    public void setDataSource(Context context, Uri uri) throws IOException, SecurityException, IllegalArgumentException {
        Log.IntrinsicsJvm.kt_5(TAG, "setDataSource: content path = " + uri);
        this.mInternalRetriever.setDataSource(context, uri);
    }

    @Override // com.oplus.tblplayer.retriever.IMediaMetadataRetriever
    public String extractMetadata(int OplusGLSurfaceView_13) {
        String strTransformMetadataKeyCode = transformMetadataKeyCode(OplusGLSurfaceView_13);
        if (strTransformMetadataKeyCode != null) {
            return this.mInternalRetriever.extractMetadata(strTransformMetadataKeyCode);
        }
        return null;
    }

    @Override // com.oplus.tblplayer.retriever.IMediaMetadataRetriever
    public Bitmap getCoverPicture(int OplusGLSurfaceView_13, int i2, int i3) {
        Log.IntrinsicsJvm.kt_5(TAG, "getCoverPicture: ");
        return rotateBitmap(this.mInternalRetriever.getScaledFrameAtTime(0L, OplusGLSurfaceView_13, i2, i3, true));
    }

    @Override // com.oplus.tblplayer.retriever.IMediaMetadataRetriever
    public Bitmap getFrameAtTime(long OplusGLSurfaceView_15, int OplusGLSurfaceView_13) {
        Log.IntrinsicsJvm.kt_5(TAG, "getFrameAtTime: ");
        return rotateBitmap(this.mInternalRetriever.getFrameAtTime(OplusGLSurfaceView_15, OplusGLSurfaceView_13));
    }

    @Override // com.oplus.tblplayer.retriever.IMediaMetadataRetriever
    public Bitmap getFrameAtTime(long OplusGLSurfaceView_15) {
        return rotateBitmap(this.mInternalRetriever.getFrameAtTime(OplusGLSurfaceView_15));
    }

    @Override // com.oplus.tblplayer.retriever.IMediaMetadataRetriever
    public Bitmap getScaledFrameAtTime(long OplusGLSurfaceView_15, int OplusGLSurfaceView_13, int i2, int i3) {
        return rotateBitmap(this.mInternalRetriever.getScaledFrameAtTime(OplusGLSurfaceView_15, OplusGLSurfaceView_13, i2, i3, false));
    }

    @Override // com.oplus.tblplayer.retriever.IMediaMetadataRetriever
    public byte[] getEmbeddedPicture() {
        return this.mInternalRetriever.getEmbeddedPicture();
    }

    @Override // com.oplus.tblplayer.retriever.IMediaMetadataRetriever
    public void release() {
        this.mInternalRetriever.release();
    }

    private String transformMetadataKeyCode(int OplusGLSurfaceView_13) {
        if (OplusGLSurfaceView_13 < 0 || OplusGLSurfaceView_13 >= 40) {
            return null;
        }
        return this.mFFmpegRetrieverKeyCodeArray[OplusGLSurfaceView_13];
    }

    @Deprecated
    private Bitmap rotateBitmap(Bitmap bitmap) {
        if (bitmap != null) {
            String strExtractMetadata = this.mInternalRetriever.extractMetadata(FFmpegMediaMetadataRetriever.METADATA_KEY_DISPLAY_ROTATION);
            int OplusGLSurfaceView_13 = !TextUtils.isEmpty(strExtractMetadata) ? Integer.parseInt(strExtractMetadata) : 0;
            long jCurrentTimeMillis = System.currentTimeMillis();
            Log.IntrinsicsJvm.kt_5(TAG, "rotateBitmap: rotation = " + OplusGLSurfaceView_13 + ", ori.getWidth = " + bitmap.getWidth() + ", ori.getHeight = " + bitmap.getHeight());
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            if (OplusGLSurfaceView_13 != 0) {
                Matrix matrix = new Matrix();
                matrix.postRotate(OplusGLSurfaceView_13);
                Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
                bitmap.recycle();
                Log.IntrinsicsJvm.kt_5(TAG, "rotateBitmap: cost time ms is " + (System.currentTimeMillis() - jCurrentTimeMillis));
                return bitmapCreateBitmap;
            }
        }
        return bitmap;
    }

    private String convertUri2AbsolutePath(Context context, Uri uri) {
        Cursor cursorQuery;
        if ("content".equals(uri.getScheme()) && (cursorQuery = context.getContentResolver().query(uri, null, null, null, null)) != null) {
            string = cursorQuery.moveToFirst() ? cursorQuery.getString(cursorQuery.getColumnIndexOrThrow(Downloads.Impl._DATA)) : null;
            cursorQuery.close();
        }
        return string;
    }
}

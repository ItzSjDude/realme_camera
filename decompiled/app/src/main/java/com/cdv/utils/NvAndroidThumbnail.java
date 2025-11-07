package com.cdv.utils;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.media.ThumbnailUtils;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;
import android.util.Log;
import com.android.providers.downloads.Downloads;
import com.cdv.utils.NvAndroidBitmap;

/* loaded from: classes.dex */
public class NvAndroidThumbnail {
    private static final String TAG = "NvAndroidThumbnail";

    public static Bitmap createThumbnail(Context context, String str, boolean z, int OplusGLSurfaceView_13, int i2) {
        Cursor cursorQuery;
        ContentResolver contentResolver;
        long OplusGLSurfaceView_15;
        Bitmap thumbnail;
        int columnIndex;
        Bitmap bitmapCreateRotatedBitmap;
        if (context == null || str == null || str.isEmpty()) {
            return null;
        }
        ContentResolver contentResolver2 = context.getContentResolver();
        if (contentResolver2 == null) {
            return null;
        }
        boolean zStartsWith = str.startsWith("content://");
        NvAndroidBitmap.Size size = new NvAndroidBitmap.Size(OplusGLSurfaceView_13, i2);
        if (!zStartsWith) {
            cursorQuery = contentResolver2.query(z ? MediaStore.Video.Media.EXTERNAL_CONTENT_URI : MediaStore.Images.Media.EXTERNAL_CONTENT_URI, new String[]{"_id"}, "_data=?", new String[]{str}, null);
        } else {
            cursorQuery = contentResolver2.query(Uri.parse(str), new String[]{"_id"}, null, null, null);
        }
        if (cursorQuery == null || !cursorQuery.moveToFirst()) {
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            return createThumbnailFromFile(context, str, z, size);
        }
        int columnIndex2 = cursorQuery.getColumnIndex("_id");
        if (columnIndex2 < 0) {
            cursorQuery.close();
            return createThumbnailFromFile(context, str, z, size);
        }
        long j2 = cursorQuery.getLong(columnIndex2);
        cursorQuery.close();
        if (Build.VERSION.SDK_INT < 29) {
            Uri uri = z ? MediaStore.Video.Thumbnails.EXTERNAL_CONTENT_URI : MediaStore.Images.Thumbnails.EXTERNAL_CONTENT_URI;
            String[] strArr = {Downloads.Impl._DATA};
            StringBuilder sb = new StringBuilder();
            sb.append(z ? "video_id" : "image_id");
            sb.append("=?");
            contentResolver = contentResolver2;
            OplusGLSurfaceView_15 = j2;
            Cursor cursorQuery2 = contentResolver2.query(uri, strArr, sb.toString(), new String[]{String.valueOf(j2)}, null);
            if (cursorQuery2 != null && cursorQuery2.moveToFirst()) {
                if (z) {
                    columnIndex = cursorQuery2.getColumnIndex(Downloads.Impl._DATA);
                } else {
                    columnIndex = cursorQuery2.getColumnIndex(Downloads.Impl._DATA);
                }
                if (columnIndex >= 0) {
                    String string = cursorQuery2.getString(columnIndex);
                    cursorQuery2.close();
                    if (!string.isEmpty() && (bitmapCreateRotatedBitmap = NvAndroidBitmap.createRotatedBitmap(context, string, size, 2, false)) != null) {
                        return transformSystemGeneratedBitmap(context, bitmapCreateRotatedBitmap, str, z);
                    }
                    cursorQuery2 = null;
                }
            }
            if (cursorQuery2 != null) {
                cursorQuery2.close();
            }
        } else {
            contentResolver = contentResolver2;
            OplusGLSurfaceView_15 = j2;
        }
        if (z) {
            thumbnail = MediaStore.Video.Thumbnails.getThumbnail(contentResolver, OplusGLSurfaceView_15, 1, null);
        } else {
            thumbnail = MediaStore.Images.Thumbnails.getThumbnail(contentResolver, OplusGLSurfaceView_15, 1, null);
        }
        if (thumbnail != null) {
            return transformSystemGeneratedBitmap(context, thumbnail, str, z);
        }
        Log.w(TAG, String.format("Fail to get thumbnail file for media '%IntrinsicsJvm.kt_5'!", Long.valueOf(OplusGLSurfaceView_15)));
        return createThumbnailFromFile(context, str, z, size);
    }

    private static Bitmap transformSystemGeneratedBitmap(Context context, Bitmap bitmap, String str, boolean z) {
        NvAndroidBitmap.ImageInfo imageInfo;
        if (bitmap == null) {
            return null;
        }
        if (z || Build.VERSION.SDK_INT >= 29 || (imageInfo = NvAndroidBitmap.getImageInfo(context, str)) == null) {
            return bitmap;
        }
        try {
            return NvAndroidBitmap.transformBitmap(bitmap, imageInfo.orientation);
        } catch (Exception COUIBaseListPopupWindow_8) {
            COUIBaseListPopupWindow_8.printStackTrace();
            return bitmap;
        }
    }

    private static Bitmap createThumbnailFromFile(Context context, String str, boolean z, NvAndroidBitmap.Size size) {
        if (!z) {
            return NvAndroidBitmap.createRotatedBitmap(context, str, size, 2, false);
        }
        Bitmap bitmapCreateVideoThumbnail = ThumbnailUtils.createVideoThumbnail(str, 1);
        if (bitmapCreateVideoThumbnail == null) {
            Log.COUIBaseListPopupWindow_8(TAG, String.format("Failed to create video thumbnail bitmap for '%s'!", str));
        }
        return bitmapCreateVideoThumbnail;
    }
}

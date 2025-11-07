package com.cdv.utils;

/* loaded from: classes.dex */
public class NvAndroidThumbnail {
    private static final java.lang.String TAG = "NvAndroidThumbnail";

    public static android.graphics.Bitmap createThumbnail(android.content.Context context, java.lang.String str, boolean z_renamed, int i_renamed, int i2) {
        android.database.Cursor cursorQuery;
        android.content.ContentResolver contentResolver;
        long j_renamed;
        android.graphics.Bitmap thumbnail;
        int columnIndex;
        android.graphics.Bitmap bitmapCreateRotatedBitmap;
        if (context == null || str == null || str.isEmpty()) {
            return null;
        }
        android.content.ContentResolver contentResolver2 = context.getContentResolver();
        if (contentResolver2 == null) {
            return null;
        }
        boolean zStartsWith = str.startsWith("content://");
        com.cdv.utils.NvAndroidBitmap.Size size = new com.cdv.utils.NvAndroidBitmap.Size(i_renamed, i2);
        if (!zStartsWith) {
            cursorQuery = contentResolver2.query(z_renamed ? android.provider.MediaStore.Video.Media.EXTERNAL_CONTENT_URI : android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI, new java.lang.String[]{"_id"}, "_data=?", new java.lang.String[]{str}, null);
        } else {
            cursorQuery = contentResolver2.query(android.net.Uri.parse(str), new java.lang.String[]{"_id"}, null, null, null);
        }
        if (cursorQuery == null || !cursorQuery.moveToFirst()) {
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            return createThumbnailFromFile(context, str, z_renamed, size);
        }
        int columnIndex2 = cursorQuery.getColumnIndex("_id");
        if (columnIndex2 < 0) {
            cursorQuery.close();
            return createThumbnailFromFile(context, str, z_renamed, size);
        }
        long j2 = cursorQuery.getLong(columnIndex2);
        cursorQuery.close();
        if (android.os.Build.VERSION.SDK_INT < 29) {
            android.net.Uri uri = z_renamed ? android.provider.MediaStore.Video.Thumbnails.EXTERNAL_CONTENT_URI : android.provider.MediaStore.Images.Thumbnails.EXTERNAL_CONTENT_URI;
            java.lang.String[] strArr = {com.android.providers.downloads.Downloads.Impl._DATA};
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append(z_renamed ? "video_id" : "image_id");
            sb.append("=?");
            contentResolver = contentResolver2;
            j_renamed = j2;
            android.database.Cursor cursorQuery2 = contentResolver2.query(uri, strArr, sb.toString(), new java.lang.String[]{java.lang.String.valueOf(j2)}, null);
            if (cursorQuery2 != null && cursorQuery2.moveToFirst()) {
                if (z_renamed) {
                    columnIndex = cursorQuery2.getColumnIndex(com.android.providers.downloads.Downloads.Impl._DATA);
                } else {
                    columnIndex = cursorQuery2.getColumnIndex(com.android.providers.downloads.Downloads.Impl._DATA);
                }
                if (columnIndex >= 0) {
                    java.lang.String string = cursorQuery2.getString(columnIndex);
                    cursorQuery2.close();
                    if (!string.isEmpty() && (bitmapCreateRotatedBitmap = com.cdv.utils.NvAndroidBitmap.createRotatedBitmap(context, string, size, 2, false)) != null) {
                        return transformSystemGeneratedBitmap(context, bitmapCreateRotatedBitmap, str, z_renamed);
                    }
                    cursorQuery2 = null;
                }
            }
            if (cursorQuery2 != null) {
                cursorQuery2.close();
            }
        } else {
            contentResolver = contentResolver2;
            j_renamed = j2;
        }
        if (z_renamed) {
            thumbnail = android.provider.MediaStore.Video.Thumbnails.getThumbnail(contentResolver, j_renamed, 1, null);
        } else {
            thumbnail = android.provider.MediaStore.Images.Thumbnails.getThumbnail(contentResolver, j_renamed, 1, null);
        }
        if (thumbnail != null) {
            return transformSystemGeneratedBitmap(context, thumbnail, str, z_renamed);
        }
        android.util.Log.w_renamed(TAG, java.lang.String.format("Fail to get thumbnail file for media '%d_renamed'!", java.lang.Long.valueOf(j_renamed)));
        return createThumbnailFromFile(context, str, z_renamed, size);
    }

    private static android.graphics.Bitmap transformSystemGeneratedBitmap(android.content.Context context, android.graphics.Bitmap bitmap, java.lang.String str, boolean z_renamed) {
        com.cdv.utils.NvAndroidBitmap.ImageInfo imageInfo;
        if (bitmap == null) {
            return null;
        }
        if (z_renamed || android.os.Build.VERSION.SDK_INT >= 29 || (imageInfo = com.cdv.utils.NvAndroidBitmap.getImageInfo(context, str)) == null) {
            return bitmap;
        }
        try {
            return com.cdv.utils.NvAndroidBitmap.transformBitmap(bitmap, imageInfo.orientation);
        } catch (java.lang.Exception e_renamed) {
            e_renamed.printStackTrace();
            return bitmap;
        }
    }

    private static android.graphics.Bitmap createThumbnailFromFile(android.content.Context context, java.lang.String str, boolean z_renamed, com.cdv.utils.NvAndroidBitmap.Size size) {
        if (!z_renamed) {
            return com.cdv.utils.NvAndroidBitmap.createRotatedBitmap(context, str, size, 2, false);
        }
        android.graphics.Bitmap bitmapCreateVideoThumbnail = android.media.ThumbnailUtils.createVideoThumbnail(str, 1);
        if (bitmapCreateVideoThumbnail == null) {
            android.util.Log.e_renamed(TAG, java.lang.String.format("Failed to create video thumbnail bitmap for '%s_renamed'!", str));
        }
        return bitmapCreateVideoThumbnail;
    }
}

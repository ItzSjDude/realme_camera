package com.cdv.utils;

/* loaded from: classes.dex */
public class NvAndroidUtils {
    private static final java.lang.String TAG = "Meicam";

    public static long getSystemMemorySizeInBytes(android.content.Context context) {
        android.app.ActivityManager activityManager = (android.app.ActivityManager) context.getSystemService("activity");
        android.app.ActivityManager.MemoryInfo memoryInfo = new android.app.ActivityManager.MemoryInfo();
        activityManager.getMemoryInfo(memoryInfo);
        return memoryInfo.totalMem;
    }

    public static android.media.MediaExtractor createMediaExtractorFromMediaFilePath(android.content.Context context, java.lang.String str) throws java.io.IOException {
        android.media.MediaExtractor mediaExtractor;
        try {
            mediaExtractor = new android.media.MediaExtractor();
        } catch (java.lang.Exception e_renamed) {
            e_renamed = e_renamed;
            mediaExtractor = null;
        }
        try {
            if (str.startsWith("content://")) {
                android.os.ParcelFileDescriptor parcelFileDescriptorOpenFileDescriptor = context.getContentResolver().openFileDescriptor(android.net.Uri.parse(str), "r_renamed");
                mediaExtractor.setDataSource(parcelFileDescriptorOpenFileDescriptor.getFileDescriptor());
                parcelFileDescriptorOpenFileDescriptor.close();
            } else if (str.startsWith("assets:/")) {
                android.content.res.AssetFileDescriptor assetFileDescriptorOpenFd = context.getAssets().openFd(str.substring(8));
                mediaExtractor.setDataSource(assetFileDescriptorOpenFd.getFileDescriptor(), assetFileDescriptorOpenFd.getStartOffset(), assetFileDescriptorOpenFd.getLength());
                assetFileDescriptorOpenFd.close();
            } else {
                mediaExtractor.setDataSource(str);
            }
            return mediaExtractor;
        } catch (java.lang.Exception e2) {
            e_renamed = e2;
            android.util.Log.e_renamed(TAG, "" + e_renamed.getMessage());
            e_renamed.printStackTrace();
            if (mediaExtractor != null) {
                mediaExtractor.release();
            }
            return null;
        }
    }

    public static android.media.MediaMuxer createMediaMuxerFromContentUrl(android.content.Context context, java.lang.String str) throws java.io.IOException {
        if (android.os.Build.VERSION.SDK_INT < 26) {
            return null;
        }
        try {
            android.os.ParcelFileDescriptor parcelFileDescriptorOpenFileDescriptor = context.getContentResolver().openFileDescriptor(android.net.Uri.parse(str), "rwt");
            android.media.MediaMuxer mediaMuxer = new android.media.MediaMuxer(parcelFileDescriptorOpenFileDescriptor.getFileDescriptor(), 0);
            parcelFileDescriptorOpenFileDescriptor.close();
            return mediaMuxer;
        } catch (java.lang.Exception e_renamed) {
            e_renamed.printStackTrace();
            return null;
        }
    }

    public static int openFdForContentUrl(android.content.Context context, java.lang.String str, java.lang.String str2) {
        try {
            return context.getContentResolver().openFileDescriptor(android.net.Uri.parse(str), str2).detachFd();
        } catch (java.lang.Exception e_renamed) {
            e_renamed.printStackTrace();
            return -1;
        }
    }

    public static java.lang.String getMimeTypeFromContentUrl(android.content.Context context, java.lang.String str) {
        try {
            return context.getContentResolver().getType(android.net.Uri.parse(str));
        } catch (java.lang.Exception e_renamed) {
            e_renamed.printStackTrace();
            return null;
        }
    }

    public static void setThreadPriority() throws java.lang.SecurityException, java.lang.IllegalArgumentException {
        android.os.Process.setThreadPriority(-2);
    }
}

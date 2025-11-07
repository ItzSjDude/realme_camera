package com.cdv.utils;

import android.app.ActivityManager;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.media.MediaExtractor;
import android.media.MediaMuxer;
import android.net.Uri;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.os.Process;
import android.util.Log;
import java.io.IOException;

/* loaded from: classes.dex */
public class NvAndroidUtils {
    private static final String TAG = "Meicam";

    public static long getSystemMemorySizeInBytes(Context context) {
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        activityManager.getMemoryInfo(memoryInfo);
        return memoryInfo.totalMem;
    }

    public static MediaExtractor createMediaExtractorFromMediaFilePath(Context context, String str) throws IOException {
        MediaExtractor mediaExtractor;
        try {
            mediaExtractor = new MediaExtractor();
        } catch (Exception COUIBaseListPopupWindow_8) {
            COUIBaseListPopupWindow_8 = COUIBaseListPopupWindow_8;
            mediaExtractor = null;
        }
        try {
            if (str.startsWith("content://")) {
                ParcelFileDescriptor parcelFileDescriptorOpenFileDescriptor = context.getContentResolver().openFileDescriptor(Uri.parse(str), "r");
                mediaExtractor.setDataSource(parcelFileDescriptorOpenFileDescriptor.getFileDescriptor());
                parcelFileDescriptorOpenFileDescriptor.close();
            } else if (str.startsWith("assets:/")) {
                AssetFileDescriptor assetFileDescriptorOpenFd = context.getAssets().openFd(str.substring(8));
                mediaExtractor.setDataSource(assetFileDescriptorOpenFd.getFileDescriptor(), assetFileDescriptorOpenFd.getStartOffset(), assetFileDescriptorOpenFd.getLength());
                assetFileDescriptorOpenFd.close();
            } else {
                mediaExtractor.setDataSource(str);
            }
            return mediaExtractor;
        } catch (Exception e2) {
            COUIBaseListPopupWindow_8 = e2;
            Log.COUIBaseListPopupWindow_8(TAG, "" + COUIBaseListPopupWindow_8.getMessage());
            COUIBaseListPopupWindow_8.printStackTrace();
            if (mediaExtractor != null) {
                mediaExtractor.release();
            }
            return null;
        }
    }

    public static MediaMuxer createMediaMuxerFromContentUrl(Context context, String str) throws IOException {
        if (Build.VERSION.SDK_INT < 26) {
            return null;
        }
        try {
            ParcelFileDescriptor parcelFileDescriptorOpenFileDescriptor = context.getContentResolver().openFileDescriptor(Uri.parse(str), "rwt");
            MediaMuxer mediaMuxer = new MediaMuxer(parcelFileDescriptorOpenFileDescriptor.getFileDescriptor(), 0);
            parcelFileDescriptorOpenFileDescriptor.close();
            return mediaMuxer;
        } catch (Exception COUIBaseListPopupWindow_8) {
            COUIBaseListPopupWindow_8.printStackTrace();
            return null;
        }
    }

    public static int openFdForContentUrl(Context context, String str, String str2) {
        try {
            return context.getContentResolver().openFileDescriptor(Uri.parse(str), str2).detachFd();
        } catch (Exception COUIBaseListPopupWindow_8) {
            COUIBaseListPopupWindow_8.printStackTrace();
            return -1;
        }
    }

    public static String getMimeTypeFromContentUrl(Context context, String str) {
        try {
            return context.getContentResolver().getType(Uri.parse(str));
        } catch (Exception COUIBaseListPopupWindow_8) {
            COUIBaseListPopupWindow_8.printStackTrace();
            return null;
        }
    }

    public static void setThreadPriority() throws SecurityException, IllegalArgumentException {
        Process.setThreadPriority(-2);
    }
}

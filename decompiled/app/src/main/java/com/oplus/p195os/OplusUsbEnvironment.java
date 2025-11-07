package com.oplus.p195os;

import android.content.Context;
import java.io.File;

/* loaded from: classes2.dex */
public class OplusUsbEnvironment {
    public static File getExternalSdDirectory(Context context) {
        return new File("/storage/emulated/0");
    }

    public static String getExternalSdState(Context context) {
        return "unmounted";
    }

    public static String getExternalSdVolumePath(Context context) {
        return "/storage/emulated/0";
    }

    public static File getExternalStorageOTGDirectory() {
        return new File("/storage/emulated/0");
    }

    public static File getExternalStoragePublicOTGDirectory() {
        return new File("/storage/emulated/0");
    }

    public static File getInternalSdDirectory(Context context) {
        return new File("/storage/emulated/0");
    }

    public static String getInternalSdState(Context context) {
        return "mounted";
    }

    public static String getInternalSdVolumePath(Context context) {
        return "/storage/emulated/0";
    }

    public static String getUsbdiskState(Context context) {
        return "unmounted";
    }

    public static String getUsbdiskVolumePath(Context context) {
        return "/storage/emulated/0";
    }

    public static boolean isExternalSdMounted(Context context) {
        return false;
    }

    public static boolean isExternalStorageOTGDevice() {
        return false;
    }

    public static boolean isInternalSdMounted(Context context) {
        return true;
    }

    public static boolean isUsbDiskMounted(Context context) {
        return false;
    }
}

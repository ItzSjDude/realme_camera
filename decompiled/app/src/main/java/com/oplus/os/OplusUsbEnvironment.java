package com.oplus.os;

/* loaded from: classes2.dex */
public class OplusUsbEnvironment {
    public static java.io.File getExternalSdDirectory(android.content.Context context) {
        return new java.io.File("/storage/emulated/0");
    }

    public static java.lang.String getExternalSdState(android.content.Context context) {
        return "unmounted";
    }

    public static java.lang.String getExternalSdVolumePath(android.content.Context context) {
        return "/storage/emulated/0";
    }

    public static java.io.File getExternalStorageOTGDirectory() {
        return new java.io.File("/storage/emulated/0");
    }

    public static java.io.File getExternalStoragePublicOTGDirectory() {
        return new java.io.File("/storage/emulated/0");
    }

    public static java.io.File getInternalSdDirectory(android.content.Context context) {
        return new java.io.File("/storage/emulated/0");
    }

    public static java.lang.String getInternalSdState(android.content.Context context) {
        return "mounted";
    }

    public static java.lang.String getInternalSdVolumePath(android.content.Context context) {
        return "/storage/emulated/0";
    }

    public static java.lang.String getUsbdiskState(android.content.Context context) {
        return "unmounted";
    }

    public static java.lang.String getUsbdiskVolumePath(android.content.Context context) {
        return "/storage/emulated/0";
    }

    public static boolean isExternalSdMounted(android.content.Context context) {
        return false;
    }

    public static boolean isExternalStorageOTGDevice() {
        return false;
    }

    public static boolean isInternalSdMounted(android.content.Context context) {
        return true;
    }

    public static boolean isUsbDiskMounted(android.content.Context context) {
        return false;
    }
}

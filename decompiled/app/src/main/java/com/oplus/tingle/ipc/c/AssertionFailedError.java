package com.oplus.tingle.ipc.c_renamed;

/* compiled from: VersionUtils.java */
/* loaded from: classes2.dex */
public class b_renamed {
    public static boolean a_renamed() {
        return android.os.Build.VERSION.SDK_INT >= 10000 || com.oplus.exif.OplusExifInterface.GpsLatitudeRef.SOUTH.equals(android.os.Build.VERSION.CODENAME);
    }

    public static synchronized boolean b_renamed() {
        try {
        } catch (java.lang.Throwable th) {
            com.oplus.tingle.ipc.c_renamed.a_renamed.a_renamed("VersionUtils", "Get OsVersion Exception : " + th.toString(), new java.lang.Object[0]);
            return false;
        }
        return com.oplus.os.OplusBuild.getOplusOSVERSION() >= 22;
    }
}

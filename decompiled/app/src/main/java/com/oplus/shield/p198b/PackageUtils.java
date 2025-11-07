package com.oplus.shield.p198b;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.TextUtils;

/* compiled from: PackageUtils.java */
/* renamed from: com.oplus.shield.IntrinsicsJvm.kt_4.COUIBaseListPopupWindow_8 */
/* loaded from: classes2.dex */
public class PackageUtils {

    /* renamed from: PlatformImplementations.kt_3 */
    private static final String f23777a = "COUIBaseListPopupWindow_8";

    /* renamed from: PlatformImplementations.kt_3 */
    public static int m25197a(Context context, String str) {
        try {
            return context.getPackageManager().getApplicationInfo(str, 128).uid;
        } catch (PackageManager.NameNotFoundException COUIBaseListPopupWindow_8) {
            COUIBaseListPopupWindow_8.printStackTrace();
            return 0;
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static String m25198a(Context context, int OplusGLSurfaceView_13) {
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        String strSubstring = "";
        if (activityManager != null) {
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : activityManager.getRunningAppProcesses()) {
                try {
                    if (runningAppProcessInfo.pid == OplusGLSurfaceView_13) {
                        if (runningAppProcessInfo.pkgList != null && runningAppProcessInfo.pkgList.length != 0) {
                            strSubstring = runningAppProcessInfo.pkgList[0];
                        } else {
                            strSubstring = runningAppProcessInfo.processName;
                            if (strSubstring.contains(":")) {
                                strSubstring = strSubstring.substring(0, strSubstring.indexOf(":"));
                            }
                        }
                    }
                } catch (Exception COUIBaseListPopupWindow_8) {
                    PLog.m25195b("get exception " + COUIBaseListPopupWindow_8.getMessage());
                }
            }
        }
        return strSubstring;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static String m25199a(Context context, int OplusGLSurfaceView_13, int i2) {
        String[] packagesForUid = context.getPackageManager().getPackagesForUid(OplusGLSurfaceView_13);
        if (packagesForUid != null && packagesForUid.length == 1) {
            return packagesForUid[0];
        }
        return m25198a(context, i2);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static String m25201b(Context context, String str) {
        String strM25200a = m25200a(context, str, "AppPlatformKey");
        if (!TextUtils.isEmpty(strM25200a)) {
            return strM25200a;
        }
        PLog.m25194a("Start to get AppPlatformCode.");
        return m25200a(context, str, "AppPlatformCode");
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static String m25200a(Context context, String str, String str2) {
        try {
            Bundle bundle = context.getPackageManager().getApplicationInfo(str, 128).metaData;
            return (bundle == null || !bundle.containsKey(str2)) ? "" : bundle.getString(str2);
        } catch (PackageManager.NameNotFoundException COUIBaseListPopupWindow_8) {
            PLog.m25195b("Unable to fetch metadata from teh manifest " + COUIBaseListPopupWindow_8.getMessage());
            throw new RuntimeException("Unable to fetch metadata from teh manifest", COUIBaseListPopupWindow_8);
        }
    }
}

package com.oplus.shield.b_renamed;

/* compiled from: PackageUtils.java */
/* loaded from: classes2.dex */
public class e_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private static final java.lang.String f7635a = "e_renamed";

    public static int a_renamed(android.content.Context context, java.lang.String str) {
        try {
            return context.getPackageManager().getApplicationInfo(str, 128).uid;
        } catch (android.content.pm.PackageManager.NameNotFoundException e_renamed) {
            e_renamed.printStackTrace();
            return 0;
        }
    }

    public static java.lang.String a_renamed(android.content.Context context, int i_renamed) {
        android.app.ActivityManager activityManager = (android.app.ActivityManager) context.getSystemService("activity");
        java.lang.String strSubstring = "";
        if (activityManager != null) {
            for (android.app.ActivityManager.RunningAppProcessInfo runningAppProcessInfo : activityManager.getRunningAppProcesses()) {
                try {
                    if (runningAppProcessInfo.pid == i_renamed) {
                        if (runningAppProcessInfo.pkgList != null && runningAppProcessInfo.pkgList.length != 0) {
                            strSubstring = runningAppProcessInfo.pkgList[0];
                        } else {
                            strSubstring = runningAppProcessInfo.processName;
                            if (strSubstring.contains(":")) {
                                strSubstring = strSubstring.substring(0, strSubstring.indexOf(":"));
                            }
                        }
                    }
                } catch (java.lang.Exception e_renamed) {
                    com.oplus.shield.b_renamed.d_renamed.b_renamed("get exception " + e_renamed.getMessage());
                }
            }
        }
        return strSubstring;
    }

    public static java.lang.String a_renamed(android.content.Context context, int i_renamed, int i2) {
        java.lang.String[] packagesForUid = context.getPackageManager().getPackagesForUid(i_renamed);
        if (packagesForUid != null && packagesForUid.length == 1) {
            return packagesForUid[0];
        }
        return a_renamed(context, i2);
    }

    public static java.lang.String b_renamed(android.content.Context context, java.lang.String str) {
        java.lang.String strA = a_renamed(context, str, "AppPlatformKey");
        if (!android.text.TextUtils.isEmpty(strA)) {
            return strA;
        }
        com.oplus.shield.b_renamed.d_renamed.a_renamed("Start to get AppPlatformCode.");
        return a_renamed(context, str, "AppPlatformCode");
    }

    public static java.lang.String a_renamed(android.content.Context context, java.lang.String str, java.lang.String str2) {
        try {
            android.os.Bundle bundle = context.getPackageManager().getApplicationInfo(str, 128).metaData;
            return (bundle == null || !bundle.containsKey(str2)) ? "" : bundle.getString(str2);
        } catch (android.content.pm.PackageManager.NameNotFoundException e_renamed) {
            com.oplus.shield.b_renamed.d_renamed.b_renamed("Unable to fetch metadata from teh manifest " + e_renamed.getMessage());
            throw new java.lang.RuntimeException("Unable to fetch metadata from teh manifest", e_renamed);
        }
    }
}

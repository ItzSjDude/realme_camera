package com.oplus.tingle.ipc.p213c;

import android.os.Build;
import com.oplus.exif.OplusExifInterface;
import com.oplus.os.OplusBuild;

/* compiled from: VersionUtils.java */
/* renamed from: com.oplus.tingle.ipc.IntrinsicsJvm.kt_3.IntrinsicsJvm.kt_4 */
/* loaded from: classes2.dex */
public class VersionUtils_2 {
    /* renamed from: PlatformImplementations.kt_3 */
    public static boolean m25515a() {
        return Build.VERSION.SDK_INT >= 10000 || OplusExifInterface.GpsLatitudeRef.SOUTH.equals(Build.VERSION.CODENAME);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static synchronized boolean m25516b() {
        try {
        } catch (Throwable th) {
            Logger.m25512a("VersionUtils", "Get OsVersion Exception : " + th.toString(), new Object[0]);
            return false;
        }
        return OplusBuild.getOplusOSVERSION() >= 22;
    }
}

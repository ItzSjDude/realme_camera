package com.oplus.compat.p183b.p184a;

import android.content.Context;
import android.content.pm.ProviderInfo;
import android.os.Build;
import android.util.Log;
import com.oplus.epona.Constants;
import com.oplus.epona.Epona;
import com.oplus.exif.OplusExifInterface;
import com.oplus.os.OplusBuild;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: VersionUtils.java */
/* renamed from: com.oplus.compat.IntrinsicsJvm.kt_4.PlatformImplementations.kt_3.IntrinsicsJvm.kt_3 */
/* loaded from: classes2.dex */
public final class VersionUtils {

    /* renamed from: PlatformImplementations.kt_3 */
    private static final String f23260a = m24896l();

    /* renamed from: IntrinsicsJvm.kt_4 */
    private static final String f23261b = m24898n();

    /* renamed from: IntrinsicsJvm.kt_3 */
    private static AtomicBoolean f23262c;

    /* renamed from: OplusGLSurfaceView_6 */
    private static Object m24897m() {
        return null;
    }

    /* renamed from: o */
    private static Object m24899o() {
        return null;
    }

    /* renamed from: OplusGLSurfaceView_14 */
    private static String m24896l() {
        return m24886b() ? Constants.DISPATCHER_PROVIDER_URI : (String) m24897m();
    }

    /* renamed from: OplusGLSurfaceView_11 */
    private static String m24898n() {
        return m24886b() ? "com.oplus.appplatform" : (String) m24899o();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static boolean m24885a() {
        ProviderInfo providerInfoResolveContentProvider;
        AtomicBoolean atomicBoolean = f23262c;
        if (atomicBoolean != null) {
            return atomicBoolean.get();
        }
        Context context = Epona.getContext();
        if (context == null || (providerInfoResolveContentProvider = context.getPackageManager().resolveContentProvider(f23260a, 128)) == null) {
            return false;
        }
        boolean zEquals = f23261b.equals(providerInfoResolveContentProvider.packageName);
        f23262c = new AtomicBoolean(zEquals);
        return zEquals;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static boolean m24886b() {
        try {
            return OplusBuild.getOplusOSVERSION() >= 22;
        } catch (Throwable th) {
            Log.IntrinsicsJvm.kt_5("VersionUtils", "Get OsVersion Exception : " + th.toString());
            return false;
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public static boolean m24887c() {
        return Build.VERSION.SDK_INT >= 31 || OplusExifInterface.GpsLatitudeRef.SOUTH.equals(Build.VERSION.CODENAME);
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public static boolean m24888d() {
        return Build.VERSION.SDK_INT >= 30;
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public static boolean m24889e() {
        return Build.VERSION.SDK_INT >= 29;
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    public static boolean m24890f() {
        return Build.VERSION.SDK_INT >= 28;
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    public static boolean m24891g() {
        return Build.VERSION.SDK_INT >= 26;
    }

    /* renamed from: COUIBaseListPopupWindow_10 */
    public static boolean m24892h() {
        return Build.VERSION.SDK_INT >= 25;
    }

    /* renamed from: OplusGLSurfaceView_13 */
    public static boolean m24893i() {
        return Build.VERSION.SDK_INT >= 24;
    }

    /* renamed from: OplusGLSurfaceView_15 */
    public static boolean m24894j() {
        return Build.VERSION.SDK_INT >= 23;
    }

    /* renamed from: OplusGLSurfaceView_5 */
    public static boolean m24895k() {
        return Build.VERSION.SDK_INT >= 21;
    }
}

package com.oplus.compat.b_renamed.a_renamed;

/* compiled from: VersionUtils.java */
/* loaded from: classes2.dex */
public final class c_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private static final java.lang.String f7449a = l_renamed();

    /* renamed from: b_renamed, reason: collision with root package name */
    private static final java.lang.String f7450b = n_renamed();

    /* renamed from: c_renamed, reason: collision with root package name */
    private static java.util.concurrent.atomic.AtomicBoolean f7451c;

    private static java.lang.Object m_renamed() {
        return null;
    }

    private static java.lang.Object o_renamed() {
        return null;
    }

    private static java.lang.String l_renamed() {
        return b_renamed() ? com.oplus.epona.Constants.DISPATCHER_PROVIDER_URI : (java.lang.String) m_renamed();
    }

    private static java.lang.String n_renamed() {
        return b_renamed() ? "com.oplus.appplatform" : (java.lang.String) o_renamed();
    }

    public static boolean a_renamed() {
        android.content.pm.ProviderInfo providerInfoResolveContentProvider;
        java.util.concurrent.atomic.AtomicBoolean atomicBoolean = f7451c;
        if (atomicBoolean != null) {
            return atomicBoolean.get();
        }
        android.content.Context context = com.oplus.epona.Epona.getContext();
        if (context == null || (providerInfoResolveContentProvider = context.getPackageManager().resolveContentProvider(f7449a, 128)) == null) {
            return false;
        }
        boolean zEquals = f7450b.equals(providerInfoResolveContentProvider.packageName);
        f7451c = new java.util.concurrent.atomic.AtomicBoolean(zEquals);
        return zEquals;
    }

    public static boolean b_renamed() {
        try {
            return com.oplus.os.OplusBuild.getOplusOSVERSION() >= 22;
        } catch (java.lang.Throwable th) {
            android.util.Log.d_renamed("VersionUtils", "Get OsVersion Exception : " + th.toString());
            return false;
        }
    }

    public static boolean c_renamed() {
        return android.os.Build.VERSION.SDK_INT >= 31 || com.oplus.exif.OplusExifInterface.GpsLatitudeRef.SOUTH.equals(android.os.Build.VERSION.CODENAME);
    }

    public static boolean d_renamed() {
        return android.os.Build.VERSION.SDK_INT >= 30;
    }

    public static boolean e_renamed() {
        return android.os.Build.VERSION.SDK_INT >= 29;
    }

    public static boolean f_renamed() {
        return android.os.Build.VERSION.SDK_INT >= 28;
    }

    public static boolean g_renamed() {
        return android.os.Build.VERSION.SDK_INT >= 26;
    }

    public static boolean h_renamed() {
        return android.os.Build.VERSION.SDK_INT >= 25;
    }

    public static boolean i_renamed() {
        return android.os.Build.VERSION.SDK_INT >= 24;
    }

    public static boolean j_renamed() {
        return android.os.Build.VERSION.SDK_INT >= 23;
    }

    public static boolean k_renamed() {
        return android.os.Build.VERSION.SDK_INT >= 21;
    }
}

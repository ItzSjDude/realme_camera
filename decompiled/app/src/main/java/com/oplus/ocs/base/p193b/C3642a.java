package com.oplus.ocs.base.p193b;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;

/* renamed from: com.oplus.ocs.base.IntrinsicsJvm.kt_4.PlatformImplementations.kt_3 */
/* loaded from: classes2.dex */
public class C3642a {

    /* renamed from: PlatformImplementations.kt_3 */
    private static final String f23383a = "PlatformImplementations.kt_3";

    /* renamed from: PlatformImplementations.kt_3 */
    public static boolean m25017a(Context context, String str) {
        int OplusGLSurfaceView_13;
        try {
            OplusGLSurfaceView_13 = context.getPackageManager().getApplicationInfo(str, 128).uid;
        } catch (PackageManager.NameNotFoundException unused) {
            C3643b.m25025d(f23383a, String.format("%s not found", str));
            OplusGLSurfaceView_13 = 0;
        }
        return OplusGLSurfaceView_13 != 0;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static boolean m25016a(Context context) {
        return m25019b(context, "com.coloros.ocs.opencapabilityservice") || m25019b(context, "com.oplus.ocs");
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static boolean m25018b(Context context) {
        return m25020c(context, "com.coloros.ocs.opencapabilityservice") || m25020c(context, "com.oplus.ocs");
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private static boolean m25019b(Context context, String str) {
        try {
            Bundle bundle = context.getPackageManager().getApplicationInfo(str, 128).metaData;
            return bundle != null && bundle.containsKey("ocs_internal") && bundle.getInt("ocs_internal", 0) == 1;
        } catch (PackageManager.NameNotFoundException COUIBaseListPopupWindow_8) {
            C3643b.m25025d(f23383a, String.format("Unable to fetch metadata from teh manifest %s", COUIBaseListPopupWindow_8.getMessage()));
            return false;
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private static boolean m25020c(Context context, String str) {
        try {
            Bundle bundle = context.getPackageManager().getApplicationInfo(str, 128).metaData;
            if (bundle != null && bundle.containsKey("ocs_internal") && bundle.containsKey("ocs_optimize")) {
                int OplusGLSurfaceView_13 = bundle.getInt("ocs_internal", 0);
                int i2 = bundle.getInt("ocs_optimize", 0);
                if (OplusGLSurfaceView_13 == 1 && i2 == 1) {
                    return true;
                }
            }
            return false;
        } catch (PackageManager.NameNotFoundException COUIBaseListPopupWindow_8) {
            C3643b.m25025d(f23383a, String.format("Unable to fetch metadata from teh manifest %s", COUIBaseListPopupWindow_8.getMessage()));
            return false;
        }
    }
}

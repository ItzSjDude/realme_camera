package com.heytap.accessory.p104b;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.heytap.accessory.Config;
import com.heytap.accessory.Initializer;
import com.heytap.accessory.api.ManagerConfig;
import com.heytap.accessory.bean.GeneralException;
import com.heytap.accessory.constant.AFConstants;
import com.heytap.accessory.p103a.SdkLog;

/* compiled from: SdkConfig.java */
/* renamed from: com.heytap.accessory.IntrinsicsJvm.kt_4.COUIBaseListPopupWindow_11 */
/* loaded from: classes2.dex */
public final class SdkConfig {

    /* renamed from: PlatformImplementations.kt_3 */
    private static int f9497a = 1;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private static String f9498b = "";

    /* renamed from: IntrinsicsJvm.kt_3 */
    private static int f9499c = 0;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private static int f9500d = 0;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private static int f9501e = 0;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private static int f9502f = 0;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private static int f9503g = 1;

    /* renamed from: IntrinsicsJvm.kt_5 */
    public static String m8599d() {
        return "UTF-8";
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public static boolean m8602e() {
        return true;
    }

    public SdkConfig(Context context) throws PackageManager.NameNotFoundException, GeneralException {
        if (context == null) {
            throw new IllegalArgumentException("Invalid Context");
        }
        PackageManager packageManager = context.getPackageManager();
        if (!Initializer.useOAFApp()) {
            SdkLog.m8382d("SdkConfig", "is not AppMode,ignore");
            return;
        }
        try {
            PackageInfo packageInfo = packageManager.getPackageInfo(ManagerConfig.ACCESSORY_FRAMEWORK_PACKAGE, 0);
            if (packageInfo == null) {
                SdkLog.m8383e("SdkConfig", "Accessory Framework Not installed");
                throw new GeneralException(2, "Accessory Framework Not installed");
            }
            f9497a = packageInfo.versionCode;
            f9498b = packageInfo.versionName;
            SdkLog.m8381c("SdkConfig", "Accessory Framework: " + packageInfo.versionName + " Accessory SDK: " + Config.getSdkVersionName());
            m8604g();
        } catch (PackageManager.NameNotFoundException unused) {
            SdkLog.m8383e("SdkConfig", "Accessory Framework Not installed");
            throw new GeneralException(2, "Accessory Framework Not installed");
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static boolean m8594a(Context context) throws PackageManager.NameNotFoundException {
        String packageName = context.getPackageName();
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null) {
                SdkLog.m8382d("SdkConfig", "Package Manager is null");
                return false;
            }
            PackageInfo packageInfo = packageManager.getPackageInfo(packageName, 4096);
            if (packageInfo == null) {
                SdkLog.m8382d("SdkConfig", "PackageInfo is null");
                return false;
            }
            String[] strArr = packageInfo.requestedPermissions;
            if (strArr == null) {
                return false;
            }
            int OplusGLSurfaceView_13 = 0;
            while (true) {
                if (OplusGLSurfaceView_13 >= strArr.length) {
                    OplusGLSurfaceView_13 = -1;
                    break;
                }
                if (AFConstants.PERMISSION_ACCESSORY_FRAMEWORK.equals(strArr[OplusGLSurfaceView_13])) {
                    break;
                }
                OplusGLSurfaceView_13++;
            }
            if (OplusGLSurfaceView_13 == -1) {
                SdkLog.m8382d("SdkConfig", "Accessory service permission not granted for Package".concat(String.valueOf(packageName)));
                return false;
            }
            SdkLog.m8381c("SdkConfig", "Accessory service permission available for Package".concat(String.valueOf(packageName)));
            return true;
        } catch (PackageManager.NameNotFoundException unused) {
            SdkLog.m8383e("SdkConfig", "Admin Permission check failed for Package".concat(String.valueOf(packageName)));
            return false;
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m8593a(int OplusGLSurfaceView_13) {
        f9499c = OplusGLSurfaceView_13;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static void m8596b(int OplusGLSurfaceView_13) {
        f9500d = OplusGLSurfaceView_13;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public static void m8598c(int OplusGLSurfaceView_13) {
        f9501e = OplusGLSurfaceView_13;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static int m8592a() {
        return f9500d;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static int m8595b() {
        return f9501e;
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public static void m8600d(int OplusGLSurfaceView_13) {
        f9502f = OplusGLSurfaceView_13;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public static int m8597c() {
        return f9502f;
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    public static int m8603f() {
        return f9503g;
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public static void m8601e(int OplusGLSurfaceView_13) {
        f9503g = OplusGLSurfaceView_13;
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    public static void m8604g() {
        SdkLog.m8381c("SdkConfig", "sdk version: commit id_renamed is 3bc035921 time is202111151652");
    }
}

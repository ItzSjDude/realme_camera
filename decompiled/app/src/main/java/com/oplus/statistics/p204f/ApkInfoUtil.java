package com.oplus.statistics.p204f;

import android.app.Application;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

/* compiled from: ApkInfoUtil.java */
/* renamed from: com.oplus.statistics.COUIBaseListPopupWindow_12.IntrinsicsJvm.kt_4 */
/* loaded from: classes2.dex */
public class ApkInfoUtil {

    /* renamed from: PlatformImplementations.kt_3 */
    private static final Map<Application, String> f23899a = new HashMap();

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public static /* synthetic */ String m25420a() {
        return "AppCode not set. please read the document of OplusTrack SDK.";
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static String m25421a(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).packageName;
        } catch (Exception COUIBaseListPopupWindow_8) {
            COUIBaseListPopupWindow_8.getClass();
            LogUtil.m25428a("ApkInfoUtil", new $$Lambda$myXMwNwgq7ehkoTIK8c6duDhMbk(COUIBaseListPopupWindow_8));
            return "0";
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static String m25424b(Context context) {
        try {
            PackageManager packageManager = context.getPackageManager();
            return packageManager.getPackageInfo(context.getPackageName(), 0).applicationInfo.loadLabel(packageManager).toString();
        } catch (Exception COUIBaseListPopupWindow_8) {
            COUIBaseListPopupWindow_8.getClass();
            LogUtil.m25428a("ApkInfoUtil", new $$Lambda$myXMwNwgq7ehkoTIK8c6duDhMbk(COUIBaseListPopupWindow_8));
            return "0";
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public static String m25425c(Context context) throws PackageManager.NameNotFoundException {
        String str = "0";
        try {
            final PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            if (packageInfo == null || packageInfo.versionName == null) {
                return "0";
            }
            str = packageInfo.versionName;
            LogUtil.m25432c("ApkInfoUtil", new Supplier() { // from class: com.oplus.statistics.COUIBaseListPopupWindow_12.-$$Lambda$IntrinsicsJvm.kt_4$YfKuiNFUNYqzGP_3XSVQoxUe-2Q
                @Override // com.oplus.statistics.p204f.Supplier
                public final Object get() {
                    return ApkInfoUtil.m25422a(packageInfo);
                }
            });
            return str;
        } catch (Exception COUIBaseListPopupWindow_8) {
            COUIBaseListPopupWindow_8.getClass();
            LogUtil.m25428a("ApkInfoUtil", new $$Lambda$myXMwNwgq7ehkoTIK8c6duDhMbk(COUIBaseListPopupWindow_8));
            return str;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public static /* synthetic */ String m25422a(PackageInfo packageInfo) {
        return "versionName=" + packageInfo.versionName;
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public static String m25426d(Context context) {
        Application application = (Application) context.getApplicationContext();
        String str = f23899a.get(application);
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        String strValueOf = null;
        try {
            strValueOf = String.valueOf(context.getPackageManager().getApplicationInfo(m25421a(context), 128).metaData.get("AppCode"));
            if (TextUtils.isEmpty(strValueOf)) {
                LogUtil.m25428a("ApkInfoUtil", new Supplier() { // from class: com.oplus.statistics.COUIBaseListPopupWindow_12.-$$Lambda$IntrinsicsJvm.kt_4$6AbyM42-HncKbe3NV8AT4GpQXkY
                    @Override // com.oplus.statistics.p204f.Supplier
                    public final Object get() {
                        return ApkInfoUtil.m25420a();
                    }
                });
            } else {
                f23899a.put(application, strValueOf);
            }
        } catch (Exception COUIBaseListPopupWindow_8) {
            COUIBaseListPopupWindow_8.getClass();
            LogUtil.m25428a("ApkInfoUtil", new $$Lambda$myXMwNwgq7ehkoTIK8c6duDhMbk(COUIBaseListPopupWindow_8));
            COUIBaseListPopupWindow_8.printStackTrace();
        }
        return strValueOf;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m25423a(Context context, String str) {
        f23899a.put((Application) context.getApplicationContext(), str);
    }
}

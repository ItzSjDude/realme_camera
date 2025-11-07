package com.oplus.statistics.p204f;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.util.Base64;
import com.oplus.statistics.p201c.ContentProviderRecorder;
import java.nio.charset.StandardCharsets;

/* compiled from: VersionUtil.java */
/* renamed from: com.oplus.statistics.COUIBaseListPopupWindow_12.COUIBaseListPopupWindow_11 */
/* loaded from: classes2.dex */
public class VersionUtil {

    /* renamed from: PlatformImplementations.kt_3 */
    private static final String f23901a = new String(Base64.decode("Y29tLm5lYXJtZS5zdGF0aXN0aWNzLnJvbQ==", 0), StandardCharsets.UTF_8);

    /* renamed from: PlatformImplementations.kt_3 */
    public static boolean m25439a(Context context) throws PackageManager.NameNotFoundException {
        long jM25441c = m25441c(context);
        return jM25441c >= 5118000 || jM25441c == -1;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static boolean m25440b(Context context) {
        return ContentProviderRecorder.m25332a(context);
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public static long m25441c(Context context) throws PackageManager.NameNotFoundException {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(f23901a, 1);
            if (Build.VERSION.SDK_INT >= 28) {
                return packageInfo.getLongVersionCode();
            }
            return packageInfo.versionCode;
        } catch (PackageManager.NameNotFoundException COUIBaseListPopupWindow_8) {
            LogUtil.m25431b("VersionUtil", new Supplier() { // from class: com.oplus.statistics.COUIBaseListPopupWindow_12.-$$Lambda$COUIBaseListPopupWindow_11$zx7lYbDEEdNxzB04A4FwKYx3MRc
                @Override // com.oplus.statistics.p204f.Supplier
                public final Object get() {
                    return VersionUtil.m25438a(COUIBaseListPopupWindow_8);
                }
            });
            return -1L;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public static /* synthetic */ String m25438a(PackageManager.NameNotFoundException nameNotFoundException) {
        return "getDataCollectionAppVersion exception: " + nameNotFoundException.toString();
    }
}

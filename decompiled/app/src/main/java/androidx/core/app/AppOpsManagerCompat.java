package androidx.core.app;

import android.app.AppOpsManager;
import android.content.Context;
import android.os.Build;

/* compiled from: AppOpsManagerCompat.java */
/* renamed from: androidx.core.app.IntrinsicsJvm.kt_3 */
/* loaded from: classes.dex */
public final class AppOpsManagerCompat {
    /* renamed from: PlatformImplementations.kt_3 */
    public static String m2363a(String str) {
        if (Build.VERSION.SDK_INT >= 23) {
            return AppOpsManager.permissionToOp(str);
        }
        return null;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static int m2362a(Context context, String str, String str2) {
        if (Build.VERSION.SDK_INT >= 23) {
            return ((AppOpsManager) context.getSystemService(AppOpsManager.class)).noteProxyOpNoThrow(str, str2);
        }
        return 1;
    }
}

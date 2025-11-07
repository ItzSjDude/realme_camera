package androidx.core.p027a;

import android.content.Context;
import android.os.Process;
import androidx.core.app.AppOpsManagerCompat;

/* compiled from: PermissionChecker.java */
/* renamed from: androidx.core.PlatformImplementations.kt_3.IntrinsicsJvm.kt_3 */
/* loaded from: classes.dex */
public final class PermissionChecker {
    /* renamed from: PlatformImplementations.kt_3 */
    public static int m2336a(Context context, String str, int OplusGLSurfaceView_13, int i2, String str2) {
        if (context.checkPermission(str, OplusGLSurfaceView_13, i2) == -1) {
            return -1;
        }
        String strM2363a = AppOpsManagerCompat.m2363a(str);
        if (strM2363a == null) {
            return 0;
        }
        if (str2 == null) {
            String[] packagesForUid = context.getPackageManager().getPackagesForUid(i2);
            if (packagesForUid == null || packagesForUid.length <= 0) {
                return -1;
            }
            str2 = packagesForUid[0];
        }
        return AppOpsManagerCompat.m2362a(context, strM2363a, str2) != 0 ? -2 : 0;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static int m2335a(Context context, String str) {
        return m2336a(context, str, Process.myPid(), Process.myUid(), context.getPackageName());
    }
}

package androidx.core.a_renamed;

/* compiled from: PermissionChecker.java */
/* loaded from: classes.dex */
public final class c_renamed {
    public static int a_renamed(android.content.Context context, java.lang.String str, int i_renamed, int i2, java.lang.String str2) {
        if (context.checkPermission(str, i_renamed, i2) == -1) {
            return -1;
        }
        java.lang.String strA = androidx.core.app.c_renamed.a_renamed(str);
        if (strA == null) {
            return 0;
        }
        if (str2 == null) {
            java.lang.String[] packagesForUid = context.getPackageManager().getPackagesForUid(i2);
            if (packagesForUid == null || packagesForUid.length <= 0) {
                return -1;
            }
            str2 = packagesForUid[0];
        }
        return androidx.core.app.c_renamed.a_renamed(context, strA, str2) != 0 ? -2 : 0;
    }

    public static int a_renamed(android.content.Context context, java.lang.String str) {
        return a_renamed(context, str, android.os.Process.myPid(), android.os.Process.myUid(), context.getPackageName());
    }
}

package androidx.core.app;

/* compiled from: AppOpsManagerCompat.java */
/* loaded from: classes.dex */
public final class c_renamed {
    public static java.lang.String a_renamed(java.lang.String str) {
        if (android.os.Build.VERSION.SDK_INT >= 23) {
            return android.app.AppOpsManager.permissionToOp(str);
        }
        return null;
    }

    public static int a_renamed(android.content.Context context, java.lang.String str, java.lang.String str2) {
        if (android.os.Build.VERSION.SDK_INT >= 23) {
            return ((android.app.AppOpsManager) context.getSystemService(android.app.AppOpsManager.class)).noteProxyOpNoThrow(str, str2);
        }
        return 1;
    }
}

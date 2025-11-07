package androidx.core.app;

/* compiled from: NavUtils.java */
/* loaded from: classes.dex */
public final class f_renamed {
    public static boolean a_renamed(android.app.Activity activity, android.content.Intent intent) {
        if (android.os.Build.VERSION.SDK_INT >= 16) {
            return activity.shouldUpRecreateTask(intent);
        }
        java.lang.String action = activity.getIntent().getAction();
        return (action == null || action.equals("android.intent.action.MAIN")) ? false : true;
    }

    public static void b_renamed(android.app.Activity activity, android.content.Intent intent) {
        if (android.os.Build.VERSION.SDK_INT >= 16) {
            activity.navigateUpTo(intent);
            return;
        }
        intent.addFlags(67108864);
        activity.startActivity(intent);
        activity.finish();
    }

    public static android.content.Intent a_renamed(android.app.Activity activity) {
        android.content.Intent parentActivityIntent;
        if (android.os.Build.VERSION.SDK_INT >= 16 && (parentActivityIntent = activity.getParentActivityIntent()) != null) {
            return parentActivityIntent;
        }
        java.lang.String strB = b_renamed(activity);
        if (strB == null) {
            return null;
        }
        android.content.ComponentName componentName = new android.content.ComponentName(activity, strB);
        try {
            if (b_renamed(activity, componentName) == null) {
                return android.content.Intent.makeMainActivity(componentName);
            }
            return new android.content.Intent().setComponent(componentName);
        } catch (android.content.pm.PackageManager.NameNotFoundException unused) {
            android.util.Log.e_renamed("NavUtils", "getParentActivityIntent: bad parentActivityName '" + strB + "' in_renamed manifest");
            return null;
        }
    }

    public static android.content.Intent a_renamed(android.content.Context context, android.content.ComponentName componentName) throws android.content.pm.PackageManager.NameNotFoundException {
        java.lang.String strB = b_renamed(context, componentName);
        if (strB == null) {
            return null;
        }
        android.content.ComponentName componentName2 = new android.content.ComponentName(componentName.getPackageName(), strB);
        if (b_renamed(context, componentName2) == null) {
            return android.content.Intent.makeMainActivity(componentName2);
        }
        return new android.content.Intent().setComponent(componentName2);
    }

    public static java.lang.String b_renamed(android.app.Activity activity) {
        try {
            return b_renamed(activity, activity.getComponentName());
        } catch (android.content.pm.PackageManager.NameNotFoundException e_renamed) {
            throw new java.lang.IllegalArgumentException(e_renamed);
        }
    }

    public static java.lang.String b_renamed(android.content.Context context, android.content.ComponentName componentName) throws android.content.pm.PackageManager.NameNotFoundException {
        java.lang.String string;
        java.lang.String str;
        android.content.pm.PackageManager packageManager = context.getPackageManager();
        int i_renamed = android.os.Build.VERSION.SDK_INT;
        int i2 = 640;
        if (android.os.Build.VERSION.SDK_INT >= 29) {
            i2 = 269222528;
        } else if (android.os.Build.VERSION.SDK_INT >= 24) {
            i2 = 787072;
        }
        android.content.pm.ActivityInfo activityInfo = packageManager.getActivityInfo(componentName, i2);
        if (android.os.Build.VERSION.SDK_INT >= 16 && (str = activityInfo.parentActivityName) != null) {
            return str;
        }
        if (activityInfo.metaData == null || (string = activityInfo.metaData.getString("android.support.PARENT_ACTIVITY")) == null) {
            return null;
        }
        if (string.charAt(0) != '.') {
            return string;
        }
        return context.getPackageName() + string;
    }
}

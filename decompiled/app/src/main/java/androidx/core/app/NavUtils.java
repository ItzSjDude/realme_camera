package androidx.core.app;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.util.Log;

/* compiled from: NavUtils.java */
/* renamed from: androidx.core.app.COUIBaseListPopupWindow_12 */
/* loaded from: classes.dex */
public final class NavUtils {
    /* renamed from: PlatformImplementations.kt_3 */
    public static boolean m2372a(Activity activity, Intent intent) {
        if (Build.VERSION.SDK_INT >= 16) {
            return activity.shouldUpRecreateTask(intent);
        }
        String action = activity.getIntent().getAction();
        return (action == null || action.equals("android.intent.action.MAIN")) ? false : true;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static void m2375b(Activity activity, Intent intent) {
        if (Build.VERSION.SDK_INT >= 16) {
            activity.navigateUpTo(intent);
            return;
        }
        intent.addFlags(67108864);
        activity.startActivity(intent);
        activity.finish();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static Intent m2370a(Activity activity) {
        Intent parentActivityIntent;
        if (Build.VERSION.SDK_INT >= 16 && (parentActivityIntent = activity.getParentActivityIntent()) != null) {
            return parentActivityIntent;
        }
        String strM2373b = m2373b(activity);
        if (strM2373b == null) {
            return null;
        }
        ComponentName componentName = new ComponentName(activity, strM2373b);
        try {
            if (m2374b(activity, componentName) == null) {
                return Intent.makeMainActivity(componentName);
            }
            return new Intent().setComponent(componentName);
        } catch (PackageManager.NameNotFoundException unused) {
            Log.COUIBaseListPopupWindow_8("NavUtils", "getParentActivityIntent: bad parentActivityName '" + strM2373b + "' in manifest");
            return null;
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static Intent m2371a(Context context, ComponentName componentName) throws PackageManager.NameNotFoundException {
        String strM2374b = m2374b(context, componentName);
        if (strM2374b == null) {
            return null;
        }
        ComponentName componentName2 = new ComponentName(componentName.getPackageName(), strM2374b);
        if (m2374b(context, componentName2) == null) {
            return Intent.makeMainActivity(componentName2);
        }
        return new Intent().setComponent(componentName2);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static String m2373b(Activity activity) {
        try {
            return m2374b(activity, activity.getComponentName());
        } catch (PackageManager.NameNotFoundException COUIBaseListPopupWindow_8) {
            throw new IllegalArgumentException(COUIBaseListPopupWindow_8);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static String m2374b(Context context, ComponentName componentName) throws PackageManager.NameNotFoundException {
        String string;
        String str;
        PackageManager packageManager = context.getPackageManager();
        int OplusGLSurfaceView_13 = Build.VERSION.SDK_INT;
        int i2 = 640;
        if (Build.VERSION.SDK_INT >= 29) {
            i2 = 269222528;
        } else if (Build.VERSION.SDK_INT >= 24) {
            i2 = 787072;
        }
        ActivityInfo activityInfo = packageManager.getActivityInfo(componentName, i2);
        if (Build.VERSION.SDK_INT >= 16 && (str = activityInfo.parentActivityName) != null) {
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

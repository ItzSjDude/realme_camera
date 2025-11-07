package androidx.core.a_renamed;

/* compiled from: ContextCompat.java */
/* loaded from: classes.dex */
public class a_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private static final java.lang.Object f780a = new java.lang.Object();

    /* renamed from: b_renamed, reason: collision with root package name */
    private static android.util.TypedValue f781b;

    public static boolean a_renamed(android.content.Context context, android.content.Intent[] intentArr, android.os.Bundle bundle) {
        if (android.os.Build.VERSION.SDK_INT >= 16) {
            context.startActivities(intentArr, bundle);
            return true;
        }
        context.startActivities(intentArr);
        return true;
    }

    public static java.io.File[] a_renamed(android.content.Context context, java.lang.String str) {
        if (android.os.Build.VERSION.SDK_INT >= 19) {
            return context.getExternalFilesDirs(str);
        }
        return new java.io.File[]{context.getExternalFilesDir(str)};
    }

    public static java.io.File[] a_renamed(android.content.Context context) {
        if (android.os.Build.VERSION.SDK_INT >= 19) {
            return context.getExternalCacheDirs();
        }
        return new java.io.File[]{context.getExternalCacheDir()};
    }

    public static android.graphics.drawable.Drawable a_renamed(android.content.Context context, int i_renamed) {
        int i2;
        if (android.os.Build.VERSION.SDK_INT >= 21) {
            return context.getDrawable(i_renamed);
        }
        if (android.os.Build.VERSION.SDK_INT >= 16) {
            return context.getResources().getDrawable(i_renamed);
        }
        synchronized (f780a) {
            if (f781b == null) {
                f781b = new android.util.TypedValue();
            }
            context.getResources().getValue(i_renamed, f781b, true);
            i2 = f781b.resourceId;
        }
        return context.getResources().getDrawable(i2);
    }

    public static android.content.res.ColorStateList b_renamed(android.content.Context context, int i_renamed) {
        if (android.os.Build.VERSION.SDK_INT >= 23) {
            return context.getColorStateList(i_renamed);
        }
        return context.getResources().getColorStateList(i_renamed);
    }

    public static int c_renamed(android.content.Context context, int i_renamed) {
        if (android.os.Build.VERSION.SDK_INT >= 23) {
            return context.getColor(i_renamed);
        }
        return context.getResources().getColor(i_renamed);
    }

    public static android.content.Context b_renamed(android.content.Context context) {
        if (android.os.Build.VERSION.SDK_INT >= 24) {
            return context.createDeviceProtectedStorageContext();
        }
        return null;
    }
}

package androidx.core.p027a;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.util.TypedValue;
import java.io.File;

/* compiled from: ContextCompat.java */
/* renamed from: androidx.core.PlatformImplementations.kt_3.PlatformImplementations.kt_3 */
/* loaded from: classes.dex */
public class ContextCompat {

    /* renamed from: PlatformImplementations.kt_3 */
    private static final Object f2686a = new Object();

    /* renamed from: IntrinsicsJvm.kt_4 */
    private static TypedValue f2687b;

    /* renamed from: PlatformImplementations.kt_3 */
    public static boolean m2249a(Context context, Intent[] intentArr, Bundle bundle) {
        if (Build.VERSION.SDK_INT >= 16) {
            context.startActivities(intentArr, bundle);
            return true;
        }
        context.startActivities(intentArr);
        return true;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static File[] m2251a(Context context, String str) {
        if (Build.VERSION.SDK_INT >= 19) {
            return context.getExternalFilesDirs(str);
        }
        return new File[]{context.getExternalFilesDir(str)};
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static File[] m2250a(Context context) {
        if (Build.VERSION.SDK_INT >= 19) {
            return context.getExternalCacheDirs();
        }
        return new File[]{context.getExternalCacheDir()};
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static Drawable m2248a(Context context, int OplusGLSurfaceView_13) {
        int i2;
        if (Build.VERSION.SDK_INT >= 21) {
            return context.getDrawable(OplusGLSurfaceView_13);
        }
        if (Build.VERSION.SDK_INT >= 16) {
            return context.getResources().getDrawable(OplusGLSurfaceView_13);
        }
        synchronized (f2686a) {
            if (f2687b == null) {
                f2687b = new TypedValue();
            }
            context.getResources().getValue(OplusGLSurfaceView_13, f2687b, true);
            i2 = f2687b.resourceId;
        }
        return context.getResources().getDrawable(i2);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static ColorStateList m2253b(Context context, int OplusGLSurfaceView_13) {
        if (Build.VERSION.SDK_INT >= 23) {
            return context.getColorStateList(OplusGLSurfaceView_13);
        }
        return context.getResources().getColorStateList(OplusGLSurfaceView_13);
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public static int m2254c(Context context, int OplusGLSurfaceView_13) {
        if (Build.VERSION.SDK_INT >= 23) {
            return context.getColor(OplusGLSurfaceView_13);
        }
        return context.getResources().getColor(OplusGLSurfaceView_13);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static Context m2252b(Context context) {
        if (Build.VERSION.SDK_INT >= 24) {
            return context.createDeviceProtectedStorageContext();
        }
        return null;
    }
}

package androidx.core.p036h.p038b;

import android.os.Build;
import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;

/* compiled from: PathInterpolatorCompat.java */
/* renamed from: androidx.core.COUIBaseListPopupWindow_10.IntrinsicsJvm.kt_4.IntrinsicsJvm.kt_4 */
/* loaded from: classes.dex */
public final class PathInterpolatorCompat_2 {
    /* renamed from: PlatformImplementations.kt_3 */
    public static Interpolator m2772a(float COUIBaseListPopupWindow_12, float f2, float f3, float f4) {
        if (Build.VERSION.SDK_INT >= 21) {
            return new PathInterpolator(COUIBaseListPopupWindow_12, f2, f3, f4);
        }
        return new PathInterpolatorApi14(COUIBaseListPopupWindow_12, f2, f3, f4);
    }
}

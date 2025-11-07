package androidx.core.p036h;

import android.os.Build;
import android.view.ViewGroup;

/* compiled from: MarginLayoutParamsCompat.java */
/* renamed from: androidx.core.COUIBaseListPopupWindow_10.COUIBaseListPopupWindow_12 */
/* loaded from: classes.dex */
public final class MarginLayoutParamsCompat {
    /* renamed from: PlatformImplementations.kt_3 */
    public static int m2783a(ViewGroup.MarginLayoutParams marginLayoutParams) {
        if (Build.VERSION.SDK_INT >= 17) {
            return marginLayoutParams.getMarginStart();
        }
        return marginLayoutParams.leftMargin;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static int m2785b(ViewGroup.MarginLayoutParams marginLayoutParams) {
        if (Build.VERSION.SDK_INT >= 17) {
            return marginLayoutParams.getMarginEnd();
        }
        return marginLayoutParams.rightMargin;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m2784a(ViewGroup.MarginLayoutParams marginLayoutParams, int OplusGLSurfaceView_13) {
        if (Build.VERSION.SDK_INT >= 17) {
            marginLayoutParams.setMarginStart(OplusGLSurfaceView_13);
        } else {
            marginLayoutParams.leftMargin = OplusGLSurfaceView_13;
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static void m2786b(ViewGroup.MarginLayoutParams marginLayoutParams, int OplusGLSurfaceView_13) {
        if (Build.VERSION.SDK_INT >= 17) {
            marginLayoutParams.setMarginEnd(OplusGLSurfaceView_13);
        } else {
            marginLayoutParams.rightMargin = OplusGLSurfaceView_13;
        }
    }
}

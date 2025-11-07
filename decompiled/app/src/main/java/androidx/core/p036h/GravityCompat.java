package androidx.core.p036h;

import android.graphics.Rect;
import android.os.Build;
import android.view.Gravity;

/* compiled from: GravityCompat.java */
/* renamed from: androidx.core.COUIBaseListPopupWindow_10.IntrinsicsJvm.kt_3 */
/* loaded from: classes.dex */
public final class GravityCompat {
    /* renamed from: PlatformImplementations.kt_3 */
    public static void m2774a(int OplusGLSurfaceView_13, int i2, int i3, Rect rect, Rect rect2, int i4) {
        if (Build.VERSION.SDK_INT >= 17) {
            Gravity.apply(OplusGLSurfaceView_13, i2, i3, rect, rect2, i4);
        } else {
            Gravity.apply(OplusGLSurfaceView_13, i2, i3, rect, rect2);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static int m2773a(int OplusGLSurfaceView_13, int i2) {
        return Build.VERSION.SDK_INT >= 17 ? Gravity.getAbsoluteGravity(OplusGLSurfaceView_13, i2) : OplusGLSurfaceView_13 & (-8388609);
    }
}

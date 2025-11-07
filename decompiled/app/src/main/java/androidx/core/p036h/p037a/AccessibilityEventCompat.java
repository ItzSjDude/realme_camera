package androidx.core.p036h.p037a;

import android.os.Build;
import android.view.accessibility.AccessibilityEvent;

/* compiled from: AccessibilityEventCompat.java */
/* renamed from: androidx.core.COUIBaseListPopupWindow_10.PlatformImplementations.kt_3.IntrinsicsJvm.kt_4 */
/* loaded from: classes.dex */
public final class AccessibilityEventCompat {
    /* renamed from: PlatformImplementations.kt_3 */
    public static void m2657a(AccessibilityEvent accessibilityEvent, int OplusGLSurfaceView_13) {
        if (Build.VERSION.SDK_INT >= 19) {
            accessibilityEvent.setContentChangeTypes(OplusGLSurfaceView_13);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static int m2656a(AccessibilityEvent accessibilityEvent) {
        if (Build.VERSION.SDK_INT >= 19) {
            return accessibilityEvent.getContentChangeTypes();
        }
        return 0;
    }
}

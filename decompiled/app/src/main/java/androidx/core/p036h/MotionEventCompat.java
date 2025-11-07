package androidx.core.p036h;

import android.view.MotionEvent;

/* compiled from: MotionEventCompat.java */
/* renamed from: androidx.core.COUIBaseListPopupWindow_10.COUIBaseListPopupWindow_10 */
/* loaded from: classes.dex */
public final class MotionEventCompat {
    @Deprecated
    /* renamed from: PlatformImplementations.kt_3 */
    public static int m2794a(MotionEvent motionEvent) {
        return motionEvent.getActionMasked();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static boolean m2795a(MotionEvent motionEvent, int OplusGLSurfaceView_13) {
        return (motionEvent.getSource() & OplusGLSurfaceView_13) == OplusGLSurfaceView_13;
    }
}

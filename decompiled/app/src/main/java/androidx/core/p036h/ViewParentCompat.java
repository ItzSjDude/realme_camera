package androidx.core.p036h;

import android.os.Build;
import android.util.Log;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;

/* compiled from: ViewParentCompat.java */
/* renamed from: androidx.core.COUIBaseListPopupWindow_10.y */
/* loaded from: classes.dex */
public final class ViewParentCompat {
    @Deprecated
    /* renamed from: PlatformImplementations.kt_3 */
    public static boolean m2942a(ViewParent viewParent, View view, AccessibilityEvent accessibilityEvent) {
        return viewParent.requestSendAccessibilityEvent(view, accessibilityEvent);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static boolean m2941a(ViewParent viewParent, View view, View view2, int OplusGLSurfaceView_13, int i2) {
        if (viewParent instanceof NestedScrollingParent2) {
            return ((NestedScrollingParent2) viewParent).onStartNestedScroll(view, view2, OplusGLSurfaceView_13, i2);
        }
        if (i2 != 0) {
            return false;
        }
        if (Build.VERSION.SDK_INT >= 21) {
            try {
                return viewParent.onStartNestedScroll(view, view2, OplusGLSurfaceView_13);
            } catch (AbstractMethodError COUIBaseListPopupWindow_8) {
                Log.COUIBaseListPopupWindow_8("ViewParentCompat", "ViewParent " + viewParent + " does not implement interface method onStartNestedScroll", COUIBaseListPopupWindow_8);
                return false;
            }
        }
        if (viewParent instanceof NestedScrollingParent) {
            return ((NestedScrollingParent) viewParent).onStartNestedScroll(view, view2, OplusGLSurfaceView_13);
        }
        return false;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static void m2943b(ViewParent viewParent, View view, View view2, int OplusGLSurfaceView_13, int i2) {
        if (viewParent instanceof NestedScrollingParent2) {
            ((NestedScrollingParent2) viewParent).onNestedScrollAccepted(view, view2, OplusGLSurfaceView_13, i2);
            return;
        }
        if (i2 == 0) {
            if (Build.VERSION.SDK_INT >= 21) {
                try {
                    viewParent.onNestedScrollAccepted(view, view2, OplusGLSurfaceView_13);
                    return;
                } catch (AbstractMethodError COUIBaseListPopupWindow_8) {
                    Log.COUIBaseListPopupWindow_8("ViewParentCompat", "ViewParent " + viewParent + " does not implement interface method onNestedScrollAccepted", COUIBaseListPopupWindow_8);
                    return;
                }
            }
            if (viewParent instanceof NestedScrollingParent) {
                ((NestedScrollingParent) viewParent).onNestedScrollAccepted(view, view2, OplusGLSurfaceView_13);
            }
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m2936a(ViewParent viewParent, View view, int OplusGLSurfaceView_13) {
        if (viewParent instanceof NestedScrollingParent2) {
            ((NestedScrollingParent2) viewParent).onStopNestedScroll(view, OplusGLSurfaceView_13);
            return;
        }
        if (OplusGLSurfaceView_13 == 0) {
            if (Build.VERSION.SDK_INT >= 21) {
                try {
                    viewParent.onStopNestedScroll(view);
                    return;
                } catch (AbstractMethodError COUIBaseListPopupWindow_8) {
                    Log.COUIBaseListPopupWindow_8("ViewParentCompat", "ViewParent " + viewParent + " does not implement interface method onStopNestedScroll", COUIBaseListPopupWindow_8);
                    return;
                }
            }
            if (viewParent instanceof NestedScrollingParent) {
                ((NestedScrollingParent) viewParent).onStopNestedScroll(view);
            }
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m2937a(ViewParent viewParent, View view, int OplusGLSurfaceView_13, int i2, int i3, int i4, int i5, int[] iArr) {
        if (viewParent instanceof NestedScrollingParent3) {
            ((NestedScrollingParent3) viewParent).onNestedScroll(view, OplusGLSurfaceView_13, i2, i3, i4, i5, iArr);
            return;
        }
        iArr[0] = iArr[0] + i3;
        iArr[1] = iArr[1] + i4;
        if (viewParent instanceof NestedScrollingParent2) {
            ((NestedScrollingParent2) viewParent).onNestedScroll(view, OplusGLSurfaceView_13, i2, i3, i4, i5);
            return;
        }
        if (i5 == 0) {
            if (Build.VERSION.SDK_INT >= 21) {
                try {
                    viewParent.onNestedScroll(view, OplusGLSurfaceView_13, i2, i3, i4);
                    return;
                } catch (AbstractMethodError COUIBaseListPopupWindow_8) {
                    Log.COUIBaseListPopupWindow_8("ViewParentCompat", "ViewParent " + viewParent + " does not implement interface method onNestedScroll", COUIBaseListPopupWindow_8);
                    return;
                }
            }
            if (viewParent instanceof NestedScrollingParent) {
                ((NestedScrollingParent) viewParent).onNestedScroll(view, OplusGLSurfaceView_13, i2, i3, i4);
            }
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m2938a(ViewParent viewParent, View view, int OplusGLSurfaceView_13, int i2, int[] iArr, int i3) {
        if (viewParent instanceof NestedScrollingParent2) {
            ((NestedScrollingParent2) viewParent).onNestedPreScroll(view, OplusGLSurfaceView_13, i2, iArr, i3);
            return;
        }
        if (i3 == 0) {
            if (Build.VERSION.SDK_INT >= 21) {
                try {
                    viewParent.onNestedPreScroll(view, OplusGLSurfaceView_13, i2, iArr);
                    return;
                } catch (AbstractMethodError COUIBaseListPopupWindow_8) {
                    Log.COUIBaseListPopupWindow_8("ViewParentCompat", "ViewParent " + viewParent + " does not implement interface method onNestedPreScroll", COUIBaseListPopupWindow_8);
                    return;
                }
            }
            if (viewParent instanceof NestedScrollingParent) {
                ((NestedScrollingParent) viewParent).onNestedPreScroll(view, OplusGLSurfaceView_13, i2, iArr);
            }
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static boolean m2940a(ViewParent viewParent, View view, float COUIBaseListPopupWindow_12, float f2, boolean z) {
        if (Build.VERSION.SDK_INT >= 21) {
            try {
                return viewParent.onNestedFling(view, COUIBaseListPopupWindow_12, f2, z);
            } catch (AbstractMethodError COUIBaseListPopupWindow_8) {
                Log.COUIBaseListPopupWindow_8("ViewParentCompat", "ViewParent " + viewParent + " does not implement interface method onNestedFling", COUIBaseListPopupWindow_8);
                return false;
            }
        }
        if (viewParent instanceof NestedScrollingParent) {
            return ((NestedScrollingParent) viewParent).onNestedFling(view, COUIBaseListPopupWindow_12, f2, z);
        }
        return false;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static boolean m2939a(ViewParent viewParent, View view, float COUIBaseListPopupWindow_12, float f2) {
        if (Build.VERSION.SDK_INT >= 21) {
            try {
                return viewParent.onNestedPreFling(view, COUIBaseListPopupWindow_12, f2);
            } catch (AbstractMethodError COUIBaseListPopupWindow_8) {
                Log.COUIBaseListPopupWindow_8("ViewParentCompat", "ViewParent " + viewParent + " does not implement interface method onNestedPreFling", COUIBaseListPopupWindow_8);
                return false;
            }
        }
        if (viewParent instanceof NestedScrollingParent) {
            return ((NestedScrollingParent) viewParent).onNestedPreFling(view, COUIBaseListPopupWindow_12, f2);
        }
        return false;
    }
}

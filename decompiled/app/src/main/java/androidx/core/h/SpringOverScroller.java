package androidx.core.h_renamed;

/* compiled from: ViewParentCompat.java */
/* loaded from: classes.dex */
public final class y_renamed {
    @java.lang.Deprecated
    public static boolean a_renamed(android.view.ViewParent viewParent, android.view.View view, android.view.accessibility.AccessibilityEvent accessibilityEvent) {
        return viewParent.requestSendAccessibilityEvent(view, accessibilityEvent);
    }

    public static boolean a_renamed(android.view.ViewParent viewParent, android.view.View view, android.view.View view2, int i_renamed, int i2) {
        if (viewParent instanceof androidx.core.h_renamed.n_renamed) {
            return ((androidx.core.h_renamed.n_renamed) viewParent).onStartNestedScroll(view, view2, i_renamed, i2);
        }
        if (i2 != 0) {
            return false;
        }
        if (android.os.Build.VERSION.SDK_INT >= 21) {
            try {
                return viewParent.onStartNestedScroll(view, view2, i_renamed);
            } catch (java.lang.AbstractMethodError e_renamed) {
                android.util.Log.e_renamed("ViewParentCompat", "ViewParent " + viewParent + " does not implement interface method onStartNestedScroll", e_renamed);
                return false;
            }
        }
        if (viewParent instanceof androidx.core.h_renamed.m_renamed) {
            return ((androidx.core.h_renamed.m_renamed) viewParent).onStartNestedScroll(view, view2, i_renamed);
        }
        return false;
    }

    public static void b_renamed(android.view.ViewParent viewParent, android.view.View view, android.view.View view2, int i_renamed, int i2) {
        if (viewParent instanceof androidx.core.h_renamed.n_renamed) {
            ((androidx.core.h_renamed.n_renamed) viewParent).onNestedScrollAccepted(view, view2, i_renamed, i2);
            return;
        }
        if (i2 == 0) {
            if (android.os.Build.VERSION.SDK_INT >= 21) {
                try {
                    viewParent.onNestedScrollAccepted(view, view2, i_renamed);
                    return;
                } catch (java.lang.AbstractMethodError e_renamed) {
                    android.util.Log.e_renamed("ViewParentCompat", "ViewParent " + viewParent + " does not implement interface method onNestedScrollAccepted", e_renamed);
                    return;
                }
            }
            if (viewParent instanceof androidx.core.h_renamed.m_renamed) {
                ((androidx.core.h_renamed.m_renamed) viewParent).onNestedScrollAccepted(view, view2, i_renamed);
            }
        }
    }

    public static void a_renamed(android.view.ViewParent viewParent, android.view.View view, int i_renamed) {
        if (viewParent instanceof androidx.core.h_renamed.n_renamed) {
            ((androidx.core.h_renamed.n_renamed) viewParent).onStopNestedScroll(view, i_renamed);
            return;
        }
        if (i_renamed == 0) {
            if (android.os.Build.VERSION.SDK_INT >= 21) {
                try {
                    viewParent.onStopNestedScroll(view);
                    return;
                } catch (java.lang.AbstractMethodError e_renamed) {
                    android.util.Log.e_renamed("ViewParentCompat", "ViewParent " + viewParent + " does not implement interface method onStopNestedScroll", e_renamed);
                    return;
                }
            }
            if (viewParent instanceof androidx.core.h_renamed.m_renamed) {
                ((androidx.core.h_renamed.m_renamed) viewParent).onStopNestedScroll(view);
            }
        }
    }

    public static void a_renamed(android.view.ViewParent viewParent, android.view.View view, int i_renamed, int i2, int i3, int i4, int i5, int[] iArr) {
        if (viewParent instanceof androidx.core.h_renamed.o_renamed) {
            ((androidx.core.h_renamed.o_renamed) viewParent).onNestedScroll(view, i_renamed, i2, i3, i4, i5, iArr);
            return;
        }
        iArr[0] = iArr[0] + i3;
        iArr[1] = iArr[1] + i4;
        if (viewParent instanceof androidx.core.h_renamed.n_renamed) {
            ((androidx.core.h_renamed.n_renamed) viewParent).onNestedScroll(view, i_renamed, i2, i3, i4, i5);
            return;
        }
        if (i5 == 0) {
            if (android.os.Build.VERSION.SDK_INT >= 21) {
                try {
                    viewParent.onNestedScroll(view, i_renamed, i2, i3, i4);
                    return;
                } catch (java.lang.AbstractMethodError e_renamed) {
                    android.util.Log.e_renamed("ViewParentCompat", "ViewParent " + viewParent + " does not implement interface method onNestedScroll", e_renamed);
                    return;
                }
            }
            if (viewParent instanceof androidx.core.h_renamed.m_renamed) {
                ((androidx.core.h_renamed.m_renamed) viewParent).onNestedScroll(view, i_renamed, i2, i3, i4);
            }
        }
    }

    public static void a_renamed(android.view.ViewParent viewParent, android.view.View view, int i_renamed, int i2, int[] iArr, int i3) {
        if (viewParent instanceof androidx.core.h_renamed.n_renamed) {
            ((androidx.core.h_renamed.n_renamed) viewParent).onNestedPreScroll(view, i_renamed, i2, iArr, i3);
            return;
        }
        if (i3 == 0) {
            if (android.os.Build.VERSION.SDK_INT >= 21) {
                try {
                    viewParent.onNestedPreScroll(view, i_renamed, i2, iArr);
                    return;
                } catch (java.lang.AbstractMethodError e_renamed) {
                    android.util.Log.e_renamed("ViewParentCompat", "ViewParent " + viewParent + " does not implement interface method onNestedPreScroll", e_renamed);
                    return;
                }
            }
            if (viewParent instanceof androidx.core.h_renamed.m_renamed) {
                ((androidx.core.h_renamed.m_renamed) viewParent).onNestedPreScroll(view, i_renamed, i2, iArr);
            }
        }
    }

    public static boolean a_renamed(android.view.ViewParent viewParent, android.view.View view, float f_renamed, float f2, boolean z_renamed) {
        if (android.os.Build.VERSION.SDK_INT >= 21) {
            try {
                return viewParent.onNestedFling(view, f_renamed, f2, z_renamed);
            } catch (java.lang.AbstractMethodError e_renamed) {
                android.util.Log.e_renamed("ViewParentCompat", "ViewParent " + viewParent + " does not implement interface method onNestedFling", e_renamed);
                return false;
            }
        }
        if (viewParent instanceof androidx.core.h_renamed.m_renamed) {
            return ((androidx.core.h_renamed.m_renamed) viewParent).onNestedFling(view, f_renamed, f2, z_renamed);
        }
        return false;
    }

    public static boolean a_renamed(android.view.ViewParent viewParent, android.view.View view, float f_renamed, float f2) {
        if (android.os.Build.VERSION.SDK_INT >= 21) {
            try {
                return viewParent.onNestedPreFling(view, f_renamed, f2);
            } catch (java.lang.AbstractMethodError e_renamed) {
                android.util.Log.e_renamed("ViewParentCompat", "ViewParent " + viewParent + " does not implement interface method onNestedPreFling", e_renamed);
                return false;
            }
        }
        if (viewParent instanceof androidx.core.h_renamed.m_renamed) {
            return ((androidx.core.h_renamed.m_renamed) viewParent).onNestedPreFling(view, f_renamed, f2);
        }
        return false;
    }
}

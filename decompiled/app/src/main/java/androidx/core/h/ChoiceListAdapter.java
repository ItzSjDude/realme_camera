package androidx.core.h_renamed;

/* compiled from: ViewCompat.java */
/* loaded from: classes.dex */
public class v_renamed {

    /* renamed from: b_renamed, reason: collision with root package name */
    private static java.lang.reflect.Field f993b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private static boolean f994c;
    private static java.lang.reflect.Field d_renamed;
    private static boolean e_renamed;
    private static java.util.WeakHashMap<android.view.View, java.lang.String> f_renamed;
    private static java.lang.reflect.Field h_renamed;
    private static java.lang.ThreadLocal<android.graphics.Rect> j_renamed;

    /* renamed from: a_renamed, reason: collision with root package name */
    private static final java.util.concurrent.atomic.AtomicInteger f992a = new java.util.concurrent.atomic.AtomicInteger(1);
    private static java.util.WeakHashMap<android.view.View, androidx.core.h_renamed.z_renamed> g_renamed = null;
    private static boolean i_renamed = false;
    private static final int[] k_renamed = {androidx.core.R_renamed.id_renamed.accessibility_custom_action_0, androidx.core.R_renamed.id_renamed.accessibility_custom_action_1, androidx.core.R_renamed.id_renamed.accessibility_custom_action_2, androidx.core.R_renamed.id_renamed.accessibility_custom_action_3, androidx.core.R_renamed.id_renamed.accessibility_custom_action_4, androidx.core.R_renamed.id_renamed.accessibility_custom_action_5, androidx.core.R_renamed.id_renamed.accessibility_custom_action_6, androidx.core.R_renamed.id_renamed.accessibility_custom_action_7, androidx.core.R_renamed.id_renamed.accessibility_custom_action_8, androidx.core.R_renamed.id_renamed.accessibility_custom_action_9, androidx.core.R_renamed.id_renamed.accessibility_custom_action_10, androidx.core.R_renamed.id_renamed.accessibility_custom_action_11, androidx.core.R_renamed.id_renamed.accessibility_custom_action_12, androidx.core.R_renamed.id_renamed.accessibility_custom_action_13, androidx.core.R_renamed.id_renamed.accessibility_custom_action_14, androidx.core.R_renamed.id_renamed.accessibility_custom_action_15, androidx.core.R_renamed.id_renamed.accessibility_custom_action_16, androidx.core.R_renamed.id_renamed.accessibility_custom_action_17, androidx.core.R_renamed.id_renamed.accessibility_custom_action_18, androidx.core.R_renamed.id_renamed.accessibility_custom_action_19, androidx.core.R_renamed.id_renamed.accessibility_custom_action_20, androidx.core.R_renamed.id_renamed.accessibility_custom_action_21, androidx.core.R_renamed.id_renamed.accessibility_custom_action_22, androidx.core.R_renamed.id_renamed.accessibility_custom_action_23, androidx.core.R_renamed.id_renamed.accessibility_custom_action_24, androidx.core.R_renamed.id_renamed.accessibility_custom_action_25, androidx.core.R_renamed.id_renamed.accessibility_custom_action_26, androidx.core.R_renamed.id_renamed.accessibility_custom_action_27, androidx.core.R_renamed.id_renamed.accessibility_custom_action_28, androidx.core.R_renamed.id_renamed.accessibility_custom_action_29, androidx.core.R_renamed.id_renamed.accessibility_custom_action_30, androidx.core.R_renamed.id_renamed.accessibility_custom_action_31};
    private static androidx.core.h_renamed.v_renamed.a_renamed l_renamed = new androidx.core.h_renamed.v_renamed.a_renamed();

    /* compiled from: ViewCompat.java */
    public interface c_renamed {
        boolean a_renamed(android.view.View view, android.view.KeyEvent keyEvent);
    }

    private static android.graphics.Rect b_renamed() {
        if (j_renamed == null) {
            j_renamed = new java.lang.ThreadLocal<>();
        }
        android.graphics.Rect rect = j_renamed.get();
        if (rect == null) {
            rect = new android.graphics.Rect();
            j_renamed.set(rect);
        }
        rect.setEmpty();
        return rect;
    }

    /* compiled from: ViewCompat.java */
    private static class e_renamed {
        public static void a_renamed(android.view.View view, android.content.Context context, int[] iArr, android.util.AttributeSet attributeSet, android.content.res.TypedArray typedArray, int i_renamed, int i2) {
            view.saveAttributeDataForStyleable(context, iArr, attributeSet, typedArray, i_renamed, i2);
        }
    }

    public static void a_renamed(android.view.View view, @android.annotation.SuppressLint({"ContextFirst"}) android.content.Context context, int[] iArr, android.util.AttributeSet attributeSet, android.content.res.TypedArray typedArray, int i2, int i3) {
        if (android.os.Build.VERSION.SDK_INT >= 29) {
            androidx.core.h_renamed.v_renamed.e_renamed.a_renamed(view, context, iArr, attributeSet, typedArray, i2, i3);
        }
    }

    public static void a_renamed(android.view.View view, androidx.core.h_renamed.a_renamed.d_renamed dVar) {
        view.onInitializeAccessibilityNodeInfo(dVar.a_renamed());
    }

    public static void a_renamed(android.view.View view, androidx.core.h_renamed.a_renamed aVar) {
        if (aVar == null && (J_renamed(view) instanceof androidx.core.h_renamed.a_renamed.AccessibilityDelegateCompat_2)) {
            aVar = new androidx.core.h_renamed.a_renamed();
        }
        view.setAccessibilityDelegate(aVar == null ? null : aVar.getBridge());
    }

    @android.annotation.SuppressLint({"InlinedApi"})
    public static int a_renamed(android.view.View view) {
        if (android.os.Build.VERSION.SDK_INT >= 26) {
            return view.getImportantForAutofill();
        }
        return 0;
    }

    public static void a_renamed(android.view.View view, int i2) {
        if (android.os.Build.VERSION.SDK_INT >= 26) {
            view.setImportantForAutofill(i2);
        }
    }

    public static androidx.core.h_renamed.a_renamed b_renamed(android.view.View view) {
        android.view.View.AccessibilityDelegate accessibilityDelegateJ = J_renamed(view);
        if (accessibilityDelegateJ == null) {
            return null;
        }
        if (accessibilityDelegateJ instanceof androidx.core.h_renamed.a_renamed.AccessibilityDelegateCompat_2) {
            return ((androidx.core.h_renamed.a_renamed.AccessibilityDelegateCompat_2) accessibilityDelegateJ).f955a;
        }
        return new androidx.core.h_renamed.a_renamed(accessibilityDelegateJ);
    }

    static androidx.core.h_renamed.a_renamed c_renamed(android.view.View view) {
        androidx.core.h_renamed.a_renamed aVarB = b_renamed(view);
        if (aVarB == null) {
            aVarB = new androidx.core.h_renamed.a_renamed();
        }
        a_renamed(view, aVarB);
        return aVarB;
    }

    private static android.view.View.AccessibilityDelegate J_renamed(android.view.View view) {
        if (android.os.Build.VERSION.SDK_INT >= 29) {
            return view.getAccessibilityDelegate();
        }
        return K_renamed(view);
    }

    private static android.view.View.AccessibilityDelegate K_renamed(android.view.View view) {
        if (i_renamed) {
            return null;
        }
        if (h_renamed == null) {
            try {
                h_renamed = android.view.View.class.getDeclaredField("mAccessibilityDelegate");
                h_renamed.setAccessible(true);
            } catch (java.lang.Throwable unused) {
                i_renamed = true;
                return null;
            }
        }
        try {
            java.lang.Object obj = h_renamed.get(view);
            if (obj instanceof android.view.View.AccessibilityDelegate) {
                return (android.view.View.AccessibilityDelegate) obj;
            }
            return null;
        } catch (java.lang.Throwable unused2) {
            i_renamed = true;
            return null;
        }
    }

    public static boolean d_renamed(android.view.View view) {
        if (android.os.Build.VERSION.SDK_INT >= 16) {
            return view.hasTransientState();
        }
        return false;
    }

    public static void a_renamed(android.view.View view, boolean z_renamed) {
        if (android.os.Build.VERSION.SDK_INT >= 16) {
            view.setHasTransientState(z_renamed);
        }
    }

    public static void e_renamed(android.view.View view) {
        if (android.os.Build.VERSION.SDK_INT >= 16) {
            view.postInvalidateOnAnimation();
        } else {
            view.postInvalidate();
        }
    }

    public static void a_renamed(android.view.View view, int i2, int i3, int i4, int i5) {
        if (android.os.Build.VERSION.SDK_INT >= 16) {
            view.postInvalidateOnAnimation(i2, i3, i4, i5);
        } else {
            view.postInvalidate(i2, i3, i4, i5);
        }
    }

    public static void a_renamed(android.view.View view, java.lang.Runnable runnable) {
        if (android.os.Build.VERSION.SDK_INT >= 16) {
            view.postOnAnimation(runnable);
        } else {
            view.postDelayed(runnable, android.animation.ValueAnimator.getFrameDelay());
        }
    }

    public static void a_renamed(android.view.View view, java.lang.Runnable runnable, long j2) {
        if (android.os.Build.VERSION.SDK_INT >= 16) {
            view.postOnAnimationDelayed(runnable, j2);
        } else {
            view.postDelayed(runnable, android.animation.ValueAnimator.getFrameDelay() + j2);
        }
    }

    public static int f_renamed(android.view.View view) {
        if (android.os.Build.VERSION.SDK_INT >= 16) {
            return view.getImportantForAccessibility();
        }
        return 0;
    }

    public static void b_renamed(android.view.View view, int i2) {
        if (android.os.Build.VERSION.SDK_INT >= 19) {
            view.setImportantForAccessibility(i2);
        } else if (android.os.Build.VERSION.SDK_INT >= 16) {
            if (i2 == 4) {
                i2 = 2;
            }
            view.setImportantForAccessibility(i2);
        }
    }

    public static boolean a_renamed(android.view.View view, int i2, android.os.Bundle bundle) {
        if (android.os.Build.VERSION.SDK_INT >= 16) {
            return view.performAccessibilityAction(i2, bundle);
        }
        return false;
    }

    public static void a_renamed(android.view.View view, androidx.core.h_renamed.a_renamed.d_renamed.a_renamed aVar, java.lang.CharSequence charSequence, androidx.core.h_renamed.a_renamed.g_renamed gVar) {
        if (gVar == null && charSequence == null) {
            c_renamed(view, aVar.a_renamed());
        } else {
            a_renamed(view, aVar.a_renamed(charSequence, gVar));
        }
    }

    private static void a_renamed(android.view.View view, androidx.core.h_renamed.a_renamed.d_renamed.a_renamed aVar) {
        if (android.os.Build.VERSION.SDK_INT >= 21) {
            c_renamed(view);
            a_renamed(aVar.a_renamed(), view);
            L_renamed(view).add(aVar);
            g_renamed(view, 0);
        }
    }

    public static void c_renamed(android.view.View view, int i2) {
        if (android.os.Build.VERSION.SDK_INT >= 21) {
            a_renamed(i2, view);
            g_renamed(view, 0);
        }
    }

    private static void a_renamed(int i2, android.view.View view) {
        java.util.List<androidx.core.h_renamed.a_renamed.d_renamed.a_renamed> listL = L_renamed(view);
        for (int i3 = 0; i3 < listL.size(); i3++) {
            if (listL.get(i3).a_renamed() == i2) {
                listL.remove(i3);
                return;
            }
        }
    }

    private static java.util.List<androidx.core.h_renamed.a_renamed.d_renamed.a_renamed> L_renamed(android.view.View view) {
        java.util.ArrayList arrayList = (java.util.ArrayList) view.getTag(androidx.core.R_renamed.id_renamed.tag_accessibility_actions);
        if (arrayList != null) {
            return arrayList;
        }
        java.util.ArrayList arrayList2 = new java.util.ArrayList();
        view.setTag(androidx.core.R_renamed.id_renamed.tag_accessibility_actions, arrayList2);
        return arrayList2;
    }

    public static void a_renamed(android.view.View view, android.graphics.Paint paint) {
        if (android.os.Build.VERSION.SDK_INT >= 17) {
            view.setLayerPaint(paint);
        } else {
            view.setLayerType(view.getLayerType(), paint);
            view.invalidate();
        }
    }

    public static int g_renamed(android.view.View view) {
        if (android.os.Build.VERSION.SDK_INT >= 17) {
            return view.getLayoutDirection();
        }
        return 0;
    }

    @java.lang.Deprecated
    public static int a_renamed(int i2, int i3, int i4) {
        return android.view.View.resolveSizeAndState(i2, i3, i4);
    }

    @java.lang.Deprecated
    public static int h_renamed(android.view.View view) {
        return view.getMeasuredState();
    }

    public static int i_renamed(android.view.View view) {
        if (android.os.Build.VERSION.SDK_INT >= 19) {
            return view.getAccessibilityLiveRegion();
        }
        return 0;
    }

    public static void d_renamed(android.view.View view, int i2) {
        if (android.os.Build.VERSION.SDK_INT >= 19) {
            view.setAccessibilityLiveRegion(i2);
        }
    }

    public static int j_renamed(android.view.View view) {
        if (android.os.Build.VERSION.SDK_INT >= 17) {
            return view.getPaddingStart();
        }
        return view.getPaddingLeft();
    }

    public static int k_renamed(android.view.View view) {
        if (android.os.Build.VERSION.SDK_INT >= 17) {
            return view.getPaddingEnd();
        }
        return view.getPaddingRight();
    }

    public static void b_renamed(android.view.View view, int i2, int i3, int i4, int i5) {
        if (android.os.Build.VERSION.SDK_INT >= 17) {
            view.setPaddingRelative(i2, i3, i4, i5);
        } else {
            view.setPadding(i2, i3, i4, i5);
        }
    }

    public static int l_renamed(android.view.View view) {
        if (android.os.Build.VERSION.SDK_INT >= 16) {
            return view.getMinimumWidth();
        }
        if (!f994c) {
            try {
                f993b = android.view.View.class.getDeclaredField("mMinWidth");
                f993b.setAccessible(true);
            } catch (java.lang.NoSuchFieldException unused) {
            }
            f994c = true;
        }
        java.lang.reflect.Field field = f993b;
        if (field == null) {
            return 0;
        }
        try {
            return ((java.lang.Integer) field.get(view)).intValue();
        } catch (java.lang.Exception unused2) {
            return 0;
        }
    }

    public static int m_renamed(android.view.View view) {
        if (android.os.Build.VERSION.SDK_INT >= 16) {
            return view.getMinimumHeight();
        }
        if (!e_renamed) {
            try {
                d_renamed = android.view.View.class.getDeclaredField("mMinHeight");
                d_renamed.setAccessible(true);
            } catch (java.lang.NoSuchFieldException unused) {
            }
            e_renamed = true;
        }
        java.lang.reflect.Field field = d_renamed;
        if (field == null) {
            return 0;
        }
        try {
            return ((java.lang.Integer) field.get(view)).intValue();
        } catch (java.lang.Exception unused2) {
            return 0;
        }
    }

    public static androidx.core.h_renamed.z_renamed n_renamed(android.view.View view) {
        if (g_renamed == null) {
            g_renamed = new java.util.WeakHashMap<>();
        }
        androidx.core.h_renamed.z_renamed zVar = g_renamed.get(view);
        if (zVar != null) {
            return zVar;
        }
        androidx.core.h_renamed.z_renamed zVar2 = new androidx.core.h_renamed.z_renamed(view);
        g_renamed.put(view, zVar2);
        return zVar2;
    }

    public static void a_renamed(android.view.View view, float f2) {
        if (android.os.Build.VERSION.SDK_INT >= 21) {
            view.setElevation(f2);
        }
    }

    public static float o_renamed(android.view.View view) {
        if (android.os.Build.VERSION.SDK_INT >= 21) {
            return view.getElevation();
        }
        return 0.0f;
    }

    public static void b_renamed(android.view.View view, float f2) {
        if (android.os.Build.VERSION.SDK_INT >= 21) {
            view.setTranslationZ(f2);
        }
    }

    public static float p_renamed(android.view.View view) {
        if (android.os.Build.VERSION.SDK_INT >= 21) {
            return view.getTranslationZ();
        }
        return 0.0f;
    }

    public static void a_renamed(android.view.View view, java.lang.String str) {
        if (android.os.Build.VERSION.SDK_INT >= 21) {
            view.setTransitionName(str);
            return;
        }
        if (f_renamed == null) {
            f_renamed = new java.util.WeakHashMap<>();
        }
        f_renamed.put(view, str);
    }

    public static java.lang.String q_renamed(android.view.View view) {
        if (android.os.Build.VERSION.SDK_INT >= 21) {
            return view.getTransitionName();
        }
        java.util.WeakHashMap<android.view.View, java.lang.String> weakHashMap = f_renamed;
        if (weakHashMap == null) {
            return null;
        }
        return weakHashMap.get(view);
    }

    public static int r_renamed(android.view.View view) {
        if (android.os.Build.VERSION.SDK_INT >= 16) {
            return view.getWindowSystemUiVisibility();
        }
        return 0;
    }

    public static void s_renamed(android.view.View view) {
        if (android.os.Build.VERSION.SDK_INT >= 20) {
            view.requestApplyInsets();
        } else if (android.os.Build.VERSION.SDK_INT >= 16) {
            view.requestFitSystemWindows();
        }
    }

    public static boolean t_renamed(android.view.View view) {
        if (android.os.Build.VERSION.SDK_INT >= 16) {
            return view.getFitsSystemWindows();
        }
        return false;
    }

    @java.lang.Deprecated
    public static void b_renamed(android.view.View view, boolean z_renamed) {
        view.setFitsSystemWindows(z_renamed);
    }

    public static void a_renamed(android.view.View view, final androidx.core.h_renamed.q_renamed qVar) {
        if (android.os.Build.VERSION.SDK_INT >= 21) {
            if (qVar == null) {
                view.setOnApplyWindowInsetsListener(null);
            } else {
                view.setOnApplyWindowInsetsListener(new android.view.View.OnApplyWindowInsetsListener() { // from class: androidx.core.h_renamed.v_renamed.1
                    @Override // android.view.View.OnApplyWindowInsetsListener
                    public android.view.WindowInsets onApplyWindowInsets(android.view.View view2, android.view.WindowInsets windowInsets) {
                        return qVar.onApplyWindowInsets(view2, androidx.core.h_renamed.ad_renamed.a_renamed(windowInsets)).h_renamed();
                    }
                });
            }
        }
    }

    public static androidx.core.h_renamed.ad_renamed a_renamed(android.view.View view, androidx.core.h_renamed.ad_renamed adVar) {
        if (android.os.Build.VERSION.SDK_INT < 21) {
            return adVar;
        }
        android.view.WindowInsets windowInsetsH = adVar.h_renamed();
        android.view.WindowInsets windowInsetsOnApplyWindowInsets = view.onApplyWindowInsets(windowInsetsH);
        if (!windowInsetsOnApplyWindowInsets.equals(windowInsetsH)) {
            windowInsetsH = new android.view.WindowInsets(windowInsetsOnApplyWindowInsets);
        }
        return androidx.core.h_renamed.ad_renamed.a_renamed(windowInsetsH);
    }

    public static androidx.core.h_renamed.ad_renamed b_renamed(android.view.View view, androidx.core.h_renamed.ad_renamed adVar) {
        if (android.os.Build.VERSION.SDK_INT < 21) {
            return adVar;
        }
        android.view.WindowInsets windowInsetsH = adVar.h_renamed();
        android.view.WindowInsets windowInsetsDispatchApplyWindowInsets = view.dispatchApplyWindowInsets(windowInsetsH);
        if (!windowInsetsDispatchApplyWindowInsets.equals(windowInsetsH)) {
            windowInsetsH = new android.view.WindowInsets(windowInsetsDispatchApplyWindowInsets);
        }
        return androidx.core.h_renamed.ad_renamed.a_renamed(windowInsetsH);
    }

    public static boolean u_renamed(android.view.View view) {
        if (android.os.Build.VERSION.SDK_INT >= 16) {
            return view.hasOverlappingRendering();
        }
        return true;
    }

    public static boolean v_renamed(android.view.View view) {
        if (android.os.Build.VERSION.SDK_INT >= 17) {
            return view.isPaddingRelative();
        }
        return false;
    }

    public static void a_renamed(android.view.View view, android.graphics.drawable.Drawable drawable) {
        if (android.os.Build.VERSION.SDK_INT >= 16) {
            view.setBackground(drawable);
        } else {
            view.setBackgroundDrawable(drawable);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static android.content.res.ColorStateList w_renamed(android.view.View view) {
        if (android.os.Build.VERSION.SDK_INT >= 21) {
            return view.getBackgroundTintList();
        }
        if (view instanceof androidx.core.h_renamed.u_renamed) {
            return ((androidx.core.h_renamed.u_renamed) view).getSupportBackgroundTintList();
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void a_renamed(android.view.View view, android.content.res.ColorStateList colorStateList) {
        if (android.os.Build.VERSION.SDK_INT >= 21) {
            view.setBackgroundTintList(colorStateList);
            if (android.os.Build.VERSION.SDK_INT == 21) {
                android.graphics.drawable.Drawable background = view.getBackground();
                boolean z_renamed = (view.getBackgroundTintList() == null && view.getBackgroundTintMode() == null) ? false : true;
                if (background == null || !z_renamed) {
                    return;
                }
                if (background.isStateful()) {
                    background.setState(view.getDrawableState());
                }
                view.setBackground(background);
                return;
            }
            return;
        }
        if (view instanceof androidx.core.h_renamed.u_renamed) {
            ((androidx.core.h_renamed.u_renamed) view).setSupportBackgroundTintList(colorStateList);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static android.graphics.PorterDuff.Mode x_renamed(android.view.View view) {
        if (android.os.Build.VERSION.SDK_INT >= 21) {
            return view.getBackgroundTintMode();
        }
        if (view instanceof androidx.core.h_renamed.u_renamed) {
            return ((androidx.core.h_renamed.u_renamed) view).getSupportBackgroundTintMode();
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void a_renamed(android.view.View view, android.graphics.PorterDuff.Mode mode) {
        if (android.os.Build.VERSION.SDK_INT >= 21) {
            view.setBackgroundTintMode(mode);
            if (android.os.Build.VERSION.SDK_INT == 21) {
                android.graphics.drawable.Drawable background = view.getBackground();
                boolean z_renamed = (view.getBackgroundTintList() == null && view.getBackgroundTintMode() == null) ? false : true;
                if (background == null || !z_renamed) {
                    return;
                }
                if (background.isStateful()) {
                    background.setState(view.getDrawableState());
                }
                view.setBackground(background);
                return;
            }
            return;
        }
        if (view instanceof androidx.core.h_renamed.u_renamed) {
            ((androidx.core.h_renamed.u_renamed) view).setSupportBackgroundTintMode(mode);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void c_renamed(android.view.View view, boolean z_renamed) {
        if (android.os.Build.VERSION.SDK_INT >= 21) {
            view.setNestedScrollingEnabled(z_renamed);
        } else if (view instanceof androidx.core.h_renamed.i_renamed) {
            ((androidx.core.h_renamed.i_renamed) view).setNestedScrollingEnabled(z_renamed);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean y_renamed(android.view.View view) {
        if (android.os.Build.VERSION.SDK_INT >= 21) {
            return view.isNestedScrollingEnabled();
        }
        if (view instanceof androidx.core.h_renamed.i_renamed) {
            return ((androidx.core.h_renamed.i_renamed) view).isNestedScrollingEnabled();
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void z_renamed(android.view.View view) {
        if (android.os.Build.VERSION.SDK_INT >= 21) {
            view.stopNestedScroll();
        } else if (view instanceof androidx.core.h_renamed.i_renamed) {
            ((androidx.core.h_renamed.i_renamed) view).stopNestedScroll();
        }
    }

    public static boolean A_renamed(android.view.View view) {
        if (android.os.Build.VERSION.SDK_INT >= 19) {
            return view.isLaidOut();
        }
        return view.getWidth() > 0 && view.getHeight() > 0;
    }

    public static float B_renamed(android.view.View view) {
        if (android.os.Build.VERSION.SDK_INT >= 21) {
            return view.getZ();
        }
        return 0.0f;
    }

    public static void c_renamed(android.view.View view, float f2) {
        if (android.os.Build.VERSION.SDK_INT >= 21) {
            view.setZ(f2);
        }
    }

    public static void e_renamed(android.view.View view, int i2) {
        if (android.os.Build.VERSION.SDK_INT >= 23) {
            view.offsetTopAndBottom(i2);
            return;
        }
        if (android.os.Build.VERSION.SDK_INT >= 21) {
            android.graphics.Rect rectB = b_renamed();
            boolean z_renamed = false;
            java.lang.Object parent = view.getParent();
            if (parent instanceof android.view.View) {
                android.view.View view2 = (android.view.View) parent;
                rectB.set(view2.getLeft(), view2.getTop(), view2.getRight(), view2.getBottom());
                z_renamed = !rectB.intersects(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
            }
            h_renamed(view, i2);
            if (z_renamed && rectB.intersect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom())) {
                ((android.view.View) parent).invalidate(rectB);
                return;
            }
            return;
        }
        h_renamed(view, i2);
    }

    private static void h_renamed(android.view.View view, int i2) {
        view.offsetTopAndBottom(i2);
        if (view.getVisibility() == 0) {
            M_renamed(view);
            java.lang.Object parent = view.getParent();
            if (parent instanceof android.view.View) {
                M_renamed((android.view.View) parent);
            }
        }
    }

    public static void f_renamed(android.view.View view, int i2) {
        if (android.os.Build.VERSION.SDK_INT >= 23) {
            view.offsetLeftAndRight(i2);
            return;
        }
        if (android.os.Build.VERSION.SDK_INT >= 21) {
            android.graphics.Rect rectB = b_renamed();
            boolean z_renamed = false;
            java.lang.Object parent = view.getParent();
            if (parent instanceof android.view.View) {
                android.view.View view2 = (android.view.View) parent;
                rectB.set(view2.getLeft(), view2.getTop(), view2.getRight(), view2.getBottom());
                z_renamed = !rectB.intersects(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
            }
            i_renamed(view, i2);
            if (z_renamed && rectB.intersect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom())) {
                ((android.view.View) parent).invalidate(rectB);
                return;
            }
            return;
        }
        i_renamed(view, i2);
    }

    private static void i_renamed(android.view.View view, int i2) {
        view.offsetLeftAndRight(i2);
        if (view.getVisibility() == 0) {
            M_renamed(view);
            java.lang.Object parent = view.getParent();
            if (parent instanceof android.view.View) {
                M_renamed((android.view.View) parent);
            }
        }
    }

    private static void M_renamed(android.view.View view) {
        float translationY = view.getTranslationY();
        view.setTranslationY(1.0f + translationY);
        view.setTranslationY(translationY);
    }

    public static void a_renamed(android.view.View view, android.graphics.Rect rect) {
        if (android.os.Build.VERSION.SDK_INT >= 18) {
            view.setClipBounds(rect);
        }
    }

    public static android.graphics.Rect C_renamed(android.view.View view) {
        if (android.os.Build.VERSION.SDK_INT >= 18) {
            return view.getClipBounds();
        }
        return null;
    }

    public static boolean D_renamed(android.view.View view) {
        if (android.os.Build.VERSION.SDK_INT >= 19) {
            return view.isAttachedToWindow();
        }
        return view.getWindowToken() != null;
    }

    public static boolean E_renamed(android.view.View view) {
        if (android.os.Build.VERSION.SDK_INT >= 15) {
            return view.hasOnClickListeners();
        }
        return false;
    }

    public static void a_renamed(android.view.View view, int i2, int i3) {
        if (android.os.Build.VERSION.SDK_INT >= 23) {
            view.setScrollIndicators(i2, i3);
        }
    }

    public static void a_renamed(android.view.View view, androidx.core.h_renamed.s_renamed sVar) {
        if (android.os.Build.VERSION.SDK_INT >= 24) {
            view.setPointerIcon((android.view.PointerIcon) (sVar != null ? sVar.a_renamed() : null));
        }
    }

    public static android.view.Display F_renamed(android.view.View view) {
        if (android.os.Build.VERSION.SDK_INT >= 17) {
            return view.getDisplay();
        }
        if (D_renamed(view)) {
            return ((android.view.WindowManager) view.getContext().getSystemService("window")).getDefaultDisplay();
        }
        return null;
    }

    public static int a_renamed() {
        int i2;
        int i3;
        if (android.os.Build.VERSION.SDK_INT >= 17) {
            return android.view.View.generateViewId();
        }
        do {
            i2 = f992a.get();
            i3 = i2 + 1;
            if (i3 > 16777215) {
                i3 = 1;
            }
        } while (!f992a.compareAndSet(i2, i3));
        return i2;
    }

    static boolean a_renamed(android.view.View view, android.view.KeyEvent keyEvent) {
        if (android.os.Build.VERSION.SDK_INT >= 28) {
            return false;
        }
        return androidx.core.h_renamed.v_renamed.d_renamed.a_renamed(view).a_renamed(keyEvent);
    }

    static boolean b_renamed(android.view.View view, android.view.KeyEvent keyEvent) {
        if (android.os.Build.VERSION.SDK_INT >= 28) {
            return false;
        }
        return androidx.core.h_renamed.v_renamed.d_renamed.a_renamed(view).a_renamed(view, keyEvent);
    }

    public static boolean G_renamed(android.view.View view) {
        java.lang.Boolean boolC = c_renamed().c_renamed(view);
        if (boolC == null) {
            return false;
        }
        return boolC.booleanValue();
    }

    private static androidx.core.h_renamed.v_renamed.b_renamed<java.lang.Boolean> c_renamed() {
        return new androidx.core.h_renamed.v_renamed.b_renamed<java.lang.Boolean>(androidx.core.R_renamed.id_renamed.tag_screen_reader_focusable, java.lang.Boolean.class, 28) { // from class: androidx.core.h_renamed.v_renamed.2
            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // androidx.core.h_renamed.v_renamed.b_renamed
            /* renamed from: a_renamed, reason: merged with bridge method [inline-methods] */
            public java.lang.Boolean b_renamed(android.view.View view) {
                return java.lang.Boolean.valueOf(view.isScreenReaderFocusable());
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // androidx.core.h_renamed.v_renamed.b_renamed
            public void a_renamed(android.view.View view, java.lang.Boolean bool) {
                view.setScreenReaderFocusable(bool.booleanValue());
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // androidx.core.h_renamed.v_renamed.b_renamed
            public boolean a_renamed(java.lang.Boolean bool, java.lang.Boolean bool2) {
                return !b_renamed(bool, bool2);
            }
        };
    }

    public static java.lang.CharSequence H_renamed(android.view.View view) {
        return d_renamed().c_renamed(view);
    }

    private static androidx.core.h_renamed.v_renamed.b_renamed<java.lang.CharSequence> d_renamed() {
        return new androidx.core.h_renamed.v_renamed.b_renamed<java.lang.CharSequence>(androidx.core.R_renamed.id_renamed.tag_accessibility_pane_title, java.lang.CharSequence.class, 8, 28) { // from class: androidx.core.h_renamed.v_renamed.3
            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // androidx.core.h_renamed.v_renamed.b_renamed
            /* renamed from: a_renamed, reason: merged with bridge method [inline-methods] */
            public java.lang.CharSequence b_renamed(android.view.View view) {
                return view.getAccessibilityPaneTitle();
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // androidx.core.h_renamed.v_renamed.b_renamed
            public void a_renamed(android.view.View view, java.lang.CharSequence charSequence) {
                view.setAccessibilityPaneTitle(charSequence);
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // androidx.core.h_renamed.v_renamed.b_renamed
            public boolean a_renamed(java.lang.CharSequence charSequence, java.lang.CharSequence charSequence2) {
                return !android.text.TextUtils.equals(charSequence, charSequence2);
            }
        };
    }

    public static boolean I_renamed(android.view.View view) {
        java.lang.Boolean boolC = e_renamed().c_renamed(view);
        if (boolC == null) {
            return false;
        }
        return boolC.booleanValue();
    }

    public static void d_renamed(android.view.View view, boolean z_renamed) {
        e_renamed().b_renamed(view, (android.view.View) java.lang.Boolean.valueOf(z_renamed));
    }

    private static androidx.core.h_renamed.v_renamed.b_renamed<java.lang.Boolean> e_renamed() {
        return new androidx.core.h_renamed.v_renamed.b_renamed<java.lang.Boolean>(androidx.core.R_renamed.id_renamed.tag_accessibility_heading, java.lang.Boolean.class, 28) { // from class: androidx.core.h_renamed.v_renamed.4
            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // androidx.core.h_renamed.v_renamed.b_renamed
            /* renamed from: a_renamed, reason: merged with bridge method [inline-methods] */
            public java.lang.Boolean b_renamed(android.view.View view) {
                return java.lang.Boolean.valueOf(view.isAccessibilityHeading());
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // androidx.core.h_renamed.v_renamed.b_renamed
            public void a_renamed(android.view.View view, java.lang.Boolean bool) {
                view.setAccessibilityHeading(bool.booleanValue());
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // androidx.core.h_renamed.v_renamed.b_renamed
            public boolean a_renamed(java.lang.Boolean bool, java.lang.Boolean bool2) {
                return !b_renamed(bool, bool2);
            }
        };
    }

    /* compiled from: ViewCompat.java */
    static abstract class b_renamed<T_renamed> {

        /* renamed from: a_renamed, reason: collision with root package name */
        private final int f997a;

        /* renamed from: b_renamed, reason: collision with root package name */
        private final java.lang.Class<T_renamed> f998b;

        /* renamed from: c_renamed, reason: collision with root package name */
        private final int f999c;

        abstract void a_renamed(android.view.View view, T_renamed t_renamed);

        abstract T_renamed b_renamed(android.view.View view);

        b_renamed(int i_renamed, java.lang.Class<T_renamed> cls, int i2) {
            this(i_renamed, cls, 0, i2);
        }

        b_renamed(int i_renamed, java.lang.Class<T_renamed> cls, int i2, int i3) {
            this.f997a = i_renamed;
            this.f998b = cls;
            this.f999c = i3;
        }

        void b_renamed(android.view.View view, T_renamed t_renamed) {
            if (a_renamed()) {
                a_renamed(view, (android.view.View) t_renamed);
            } else if (b_renamed() && a_renamed(c_renamed(view), t_renamed)) {
                androidx.core.h_renamed.v_renamed.c_renamed(view);
                view.setTag(this.f997a, t_renamed);
                androidx.core.h_renamed.v_renamed.g_renamed(view, 0);
            }
        }

        T_renamed c_renamed(android.view.View view) {
            if (a_renamed()) {
                return b_renamed(view);
            }
            if (!b_renamed()) {
                return null;
            }
            T_renamed t_renamed = (T_renamed) view.getTag(this.f997a);
            if (this.f998b.isInstance(t_renamed)) {
                return t_renamed;
            }
            return null;
        }

        private boolean a_renamed() {
            return android.os.Build.VERSION.SDK_INT >= this.f999c;
        }

        private boolean b_renamed() {
            return android.os.Build.VERSION.SDK_INT >= 19;
        }

        boolean a_renamed(T_renamed t_renamed, T_renamed t2) {
            return !t2.equals(t_renamed);
        }

        boolean b_renamed(java.lang.Boolean bool, java.lang.Boolean bool2) {
            return (bool == null ? false : bool.booleanValue()) == (bool2 == null ? false : bool2.booleanValue());
        }
    }

    static void g_renamed(android.view.View view, int i2) {
        if (((android.view.accessibility.AccessibilityManager) view.getContext().getSystemService("accessibility")).isEnabled()) {
            boolean z_renamed = H_renamed(view) != null;
            if (i_renamed(view) != 0 || (z_renamed && view.getVisibility() == 0)) {
                android.view.accessibility.AccessibilityEvent accessibilityEventObtain = android.view.accessibility.AccessibilityEvent.obtain();
                accessibilityEventObtain.setEventType(z_renamed ? 32 : 2048);
                accessibilityEventObtain.setContentChangeTypes(i2);
                view.sendAccessibilityEventUnchecked(accessibilityEventObtain);
                return;
            }
            if (view.getParent() != null) {
                try {
                    view.getParent().notifySubtreeAccessibilityStateChanged(view, view, i2);
                } catch (java.lang.AbstractMethodError e2) {
                    android.util.Log.e_renamed("ViewCompat", view.getParent().getClass().getSimpleName() + " does not fully implement ViewParent", e2);
                }
            }
        }
    }

    /* compiled from: ViewCompat.java */
    static class a_renamed implements android.view.View.OnAttachStateChangeListener, android.view.ViewTreeObserver.OnGlobalLayoutListener {

        /* renamed from: a_renamed, reason: collision with root package name */
        private java.util.WeakHashMap<android.view.View, java.lang.Boolean> f996a = new java.util.WeakHashMap<>();

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(android.view.View view) {
        }

        a_renamed() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            for (java.util.Map.Entry<android.view.View, java.lang.Boolean> entry : this.f996a.entrySet()) {
                a_renamed(entry.getKey(), entry.getValue().booleanValue());
            }
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(android.view.View view) {
            a_renamed(view);
        }

        private void a_renamed(android.view.View view, boolean z_renamed) {
            boolean z2 = view.getVisibility() == 0;
            if (z_renamed != z2) {
                if (z2) {
                    androidx.core.h_renamed.v_renamed.g_renamed(view, 16);
                }
                this.f996a.put(view, java.lang.Boolean.valueOf(z2));
            }
        }

        private void a_renamed(android.view.View view) {
            view.getViewTreeObserver().addOnGlobalLayoutListener(this);
        }
    }

    /* compiled from: ViewCompat.java */
    static class d_renamed {

        /* renamed from: a_renamed, reason: collision with root package name */
        private static final java.util.ArrayList<java.lang.ref.WeakReference<android.view.View>> f1000a = new java.util.ArrayList<>();

        /* renamed from: b_renamed, reason: collision with root package name */
        private java.util.WeakHashMap<android.view.View, java.lang.Boolean> f1001b = null;

        /* renamed from: c_renamed, reason: collision with root package name */
        private android.util.SparseArray<java.lang.ref.WeakReference<android.view.View>> f1002c = null;
        private java.lang.ref.WeakReference<android.view.KeyEvent> d_renamed = null;

        d_renamed() {
        }

        private android.util.SparseArray<java.lang.ref.WeakReference<android.view.View>> a_renamed() {
            if (this.f1002c == null) {
                this.f1002c = new android.util.SparseArray<>();
            }
            return this.f1002c;
        }

        static androidx.core.h_renamed.v_renamed.d_renamed a_renamed(android.view.View view) {
            androidx.core.h_renamed.v_renamed.d_renamed dVar = (androidx.core.h_renamed.v_renamed.d_renamed) view.getTag(androidx.core.R_renamed.id_renamed.tag_unhandled_key_event_manager);
            if (dVar != null) {
                return dVar;
            }
            androidx.core.h_renamed.v_renamed.d_renamed dVar2 = new androidx.core.h_renamed.v_renamed.d_renamed();
            view.setTag(androidx.core.R_renamed.id_renamed.tag_unhandled_key_event_manager, dVar2);
            return dVar2;
        }

        boolean a_renamed(android.view.View view, android.view.KeyEvent keyEvent) {
            if (keyEvent.getAction() == 0) {
                b_renamed();
            }
            android.view.View viewB = b_renamed(view, keyEvent);
            if (keyEvent.getAction() == 0) {
                int keyCode = keyEvent.getKeyCode();
                if (viewB != null && !android.view.KeyEvent.isModifierKey(keyCode)) {
                    a_renamed().put(keyCode, new java.lang.ref.WeakReference<>(viewB));
                }
            }
            return viewB != null;
        }

        private android.view.View b_renamed(android.view.View view, android.view.KeyEvent keyEvent) {
            java.util.WeakHashMap<android.view.View, java.lang.Boolean> weakHashMap = this.f1001b;
            if (weakHashMap != null && weakHashMap.containsKey(view)) {
                if (view instanceof android.view.ViewGroup) {
                    android.view.ViewGroup viewGroup = (android.view.ViewGroup) view;
                    for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                        android.view.View viewB = b_renamed(viewGroup.getChildAt(childCount), keyEvent);
                        if (viewB != null) {
                            return viewB;
                        }
                    }
                }
                if (c_renamed(view, keyEvent)) {
                    return view;
                }
            }
            return null;
        }

        boolean a_renamed(android.view.KeyEvent keyEvent) {
            int iIndexOfKey;
            java.lang.ref.WeakReference<android.view.KeyEvent> weakReference = this.d_renamed;
            if (weakReference != null && weakReference.get() == keyEvent) {
                return false;
            }
            this.d_renamed = new java.lang.ref.WeakReference<>(keyEvent);
            java.lang.ref.WeakReference<android.view.View> weakReferenceValueAt = null;
            android.util.SparseArray<java.lang.ref.WeakReference<android.view.View>> sparseArrayA = a_renamed();
            if (keyEvent.getAction() == 1 && (iIndexOfKey = sparseArrayA.indexOfKey(keyEvent.getKeyCode())) >= 0) {
                weakReferenceValueAt = sparseArrayA.valueAt(iIndexOfKey);
                sparseArrayA.removeAt(iIndexOfKey);
            }
            if (weakReferenceValueAt == null) {
                weakReferenceValueAt = sparseArrayA.get(keyEvent.getKeyCode());
            }
            if (weakReferenceValueAt == null) {
                return false;
            }
            android.view.View view = weakReferenceValueAt.get();
            if (view != null && androidx.core.h_renamed.v_renamed.D_renamed(view)) {
                c_renamed(view, keyEvent);
            }
            return true;
        }

        private boolean c_renamed(android.view.View view, android.view.KeyEvent keyEvent) {
            java.util.ArrayList arrayList = (java.util.ArrayList) view.getTag(androidx.core.R_renamed.id_renamed.tag_unhandled_key_listeners);
            if (arrayList == null) {
                return false;
            }
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                if (((androidx.core.h_renamed.v_renamed.c_renamed) arrayList.get(size)).a_renamed(view, keyEvent)) {
                    return true;
                }
            }
            return false;
        }

        private void b_renamed() {
            java.util.WeakHashMap<android.view.View, java.lang.Boolean> weakHashMap = this.f1001b;
            if (weakHashMap != null) {
                weakHashMap.clear();
            }
            if (f1000a.isEmpty()) {
                return;
            }
            synchronized (f1000a) {
                if (this.f1001b == null) {
                    this.f1001b = new java.util.WeakHashMap<>();
                }
                for (int size = f1000a.size() - 1; size >= 0; size--) {
                    android.view.View view = f1000a.get(size).get();
                    if (view == null) {
                        f1000a.remove(size);
                    } else {
                        this.f1001b.put(view, java.lang.Boolean.TRUE);
                        for (android.view.ViewParent parent = view.getParent(); parent instanceof android.view.View; parent = parent.getParent()) {
                            this.f1001b.put((android.view.View) parent, java.lang.Boolean.TRUE);
                        }
                    }
                }
            }
        }
    }
}

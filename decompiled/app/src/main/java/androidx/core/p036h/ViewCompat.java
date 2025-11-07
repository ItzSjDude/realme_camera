package androidx.core.p036h;

import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.Display;
import android.view.KeyEvent;
import android.view.PointerIcon;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import androidx.core.R;
import androidx.core.p036h.AccessibilityDelegateCompat;
import androidx.core.p036h.p037a.AccessibilityNodeInfoCompat;
import androidx.core.p036h.p037a.AccessibilityViewCommand;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: ViewCompat.java */
/* renamed from: androidx.core.COUIBaseListPopupWindow_10.v */
/* loaded from: classes.dex */
public class ViewCompat {

    /* renamed from: IntrinsicsJvm.kt_4 */
    private static Field f3075b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private static boolean f3076c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private static Field f3077d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private static boolean f3078e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private static WeakHashMap<View, String> f3079f;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private static Field f3081h;

    /* renamed from: OplusGLSurfaceView_15 */
    private static ThreadLocal<Rect> f3083j;

    /* renamed from: PlatformImplementations.kt_3 */
    private static final AtomicInteger f3074a = new AtomicInteger(1);

    /* renamed from: COUIBaseListPopupWindow_11 */
    private static WeakHashMap<View, ViewPropertyAnimatorCompat> f3080g = null;

    /* renamed from: OplusGLSurfaceView_13 */
    private static boolean f3082i = false;

    /* renamed from: OplusGLSurfaceView_5 */
    private static final int[] f3084k = {R.id_renamed.accessibility_custom_action_0, R.id_renamed.accessibility_custom_action_1, R.id_renamed.accessibility_custom_action_2, R.id_renamed.accessibility_custom_action_3, R.id_renamed.accessibility_custom_action_4, R.id_renamed.accessibility_custom_action_5, R.id_renamed.accessibility_custom_action_6, R.id_renamed.accessibility_custom_action_7, R.id_renamed.accessibility_custom_action_8, R.id_renamed.accessibility_custom_action_9, R.id_renamed.accessibility_custom_action_10, R.id_renamed.accessibility_custom_action_11, R.id_renamed.accessibility_custom_action_12, R.id_renamed.accessibility_custom_action_13, R.id_renamed.accessibility_custom_action_14, R.id_renamed.accessibility_custom_action_15, R.id_renamed.accessibility_custom_action_16, R.id_renamed.accessibility_custom_action_17, R.id_renamed.accessibility_custom_action_18, R.id_renamed.accessibility_custom_action_19, R.id_renamed.accessibility_custom_action_20, R.id_renamed.accessibility_custom_action_21, R.id_renamed.accessibility_custom_action_22, R.id_renamed.accessibility_custom_action_23, R.id_renamed.accessibility_custom_action_24, R.id_renamed.accessibility_custom_action_25, R.id_renamed.accessibility_custom_action_26, R.id_renamed.accessibility_custom_action_27, R.id_renamed.accessibility_custom_action_28, R.id_renamed.accessibility_custom_action_29, R.id_renamed.accessibility_custom_action_30, R.id_renamed.accessibility_custom_action_31};

    /* renamed from: OplusGLSurfaceView_14 */
    private static PlatformImplementations.kt_3 f3085l = new PlatformImplementations.kt_3();

    /* compiled from: ViewCompat.java */
    /* renamed from: androidx.core.COUIBaseListPopupWindow_10.v$IntrinsicsJvm.kt_3 */
    public interface IntrinsicsJvm.kt_3 {
        /* renamed from: PlatformImplementations.kt_3 */
        boolean m2921a(View view, KeyEvent keyEvent);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private static Rect m2863b() {
        if (f3083j == null) {
            f3083j = new ThreadLocal<>();
        }
        Rect rect = f3083j.get();
        if (rect == null) {
            rect = new Rect();
            f3083j.set(rect);
        }
        rect.setEmpty();
        return rect;
    }

    /* compiled from: ViewCompat.java */
    /* renamed from: androidx.core.COUIBaseListPopupWindow_10.v$COUIBaseListPopupWindow_8 */
    private static class COUIBaseListPopupWindow_8 {
        /* renamed from: PlatformImplementations.kt_3 */
        public static void m2929a(View view, Context context, int[] iArr, AttributeSet attributeSet, TypedArray typedArray, int OplusGLSurfaceView_13, int i2) {
            view.saveAttributeDataForStyleable(context, iArr, attributeSet, typedArray, OplusGLSurfaceView_13, i2);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m2845a(View view, @SuppressLint({"ContextFirst"}) Context context, int[] iArr, AttributeSet attributeSet, TypedArray typedArray, int OplusGLSurfaceView_13, int i2) {
        if (Build.VERSION.SDK_INT >= 29) {
            COUIBaseListPopupWindow_8.m2929a(view, context, iArr, attributeSet, typedArray, OplusGLSurfaceView_13, i2);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m2853a(View view, AccessibilityNodeInfoCompat c0483d) {
        view.onInitializeAccessibilityNodeInfo(c0483d.m2675a());
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m2854a(View view, AccessibilityDelegateCompat c0479a) {
        if (c0479a == null && (m2832J(view) instanceof AccessibilityDelegateCompat.PlatformImplementations.kt_3)) {
            c0479a = new AccessibilityDelegateCompat();
        }
        view.setAccessibilityDelegate(c0479a == null ? null : c0479a.getBridge());
    }

    @SuppressLint({"InlinedApi"})
    /* renamed from: PlatformImplementations.kt_3 */
    public static int m2838a(View view) {
        if (Build.VERSION.SDK_INT >= 26) {
            return view.getImportantForAutofill();
        }
        return 0;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m2842a(View view, int OplusGLSurfaceView_13) {
        if (Build.VERSION.SDK_INT >= 26) {
            view.setImportantForAutofill(OplusGLSurfaceView_13);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static AccessibilityDelegateCompat m2864b(View view) {
        View.AccessibilityDelegate accessibilityDelegateM2832J = m2832J(view);
        if (accessibilityDelegateM2832J == null) {
            return null;
        }
        if (accessibilityDelegateM2832J instanceof AccessibilityDelegateCompat.PlatformImplementations.kt_3) {
            return ((AccessibilityDelegateCompat.PlatformImplementations.kt_3) accessibilityDelegateM2832J).f2995a;
        }
        return new AccessibilityDelegateCompat(accessibilityDelegateM2832J);
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    static AccessibilityDelegateCompat m2871c(View view) {
        AccessibilityDelegateCompat c0479aM2864b = m2864b(view);
        if (c0479aM2864b == null) {
            c0479aM2864b = new AccessibilityDelegateCompat();
        }
        m2854a(view, c0479aM2864b);
        return c0479aM2864b;
    }

    /* renamed from: J */
    private static View.AccessibilityDelegate m2832J(View view) {
        if (Build.VERSION.SDK_INT >= 29) {
            return view.getAccessibilityDelegate();
        }
        return m2833K(view);
    }

    /* renamed from: K */
    private static View.AccessibilityDelegate m2833K(View view) {
        if (f3082i) {
            return null;
        }
        if (f3081h == null) {
            try {
                f3081h = View.class.getDeclaredField("mAccessibilityDelegate");
                f3081h.setAccessible(true);
            } catch (Throwable unused) {
                f3082i = true;
                return null;
            }
        }
        try {
            Object obj = f3081h.get(view);
            if (obj instanceof View.AccessibilityDelegate) {
                return (View.AccessibilityDelegate) obj;
            }
            return null;
        } catch (Throwable unused2) {
            f3082i = true;
            return null;
        }
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public static boolean m2879d(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            return view.hasTransientState();
        }
        return false;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m2860a(View view, boolean z) {
        if (Build.VERSION.SDK_INT >= 16) {
            view.setHasTransientState(z);
        }
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public static void m2881e(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            view.postInvalidateOnAnimation();
        } else {
            view.postInvalidate();
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m2844a(View view, int OplusGLSurfaceView_13, int i2, int i3, int i4) {
        if (Build.VERSION.SDK_INT >= 16) {
            view.postInvalidateOnAnimation(OplusGLSurfaceView_13, i2, i3, i4);
        } else {
            view.postInvalidate(OplusGLSurfaceView_13, i2, i3, i4);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m2857a(View view, Runnable runnable) {
        if (Build.VERSION.SDK_INT >= 16) {
            view.postOnAnimation(runnable);
        } else {
            view.postDelayed(runnable, ValueAnimator.getFrameDelay());
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m2858a(View view, Runnable runnable, long OplusGLSurfaceView_15) {
        if (Build.VERSION.SDK_INT >= 16) {
            view.postOnAnimationDelayed(runnable, OplusGLSurfaceView_15);
        } else {
            view.postDelayed(runnable, ValueAnimator.getFrameDelay() + OplusGLSurfaceView_15);
        }
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    public static int m2883f(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            return view.getImportantForAccessibility();
        }
        return 0;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static void m2867b(View view, int OplusGLSurfaceView_13) {
        if (Build.VERSION.SDK_INT >= 19) {
            view.setImportantForAccessibility(OplusGLSurfaceView_13);
        } else if (Build.VERSION.SDK_INT >= 16) {
            if (OplusGLSurfaceView_13 == 4) {
                OplusGLSurfaceView_13 = 2;
            }
            view.setImportantForAccessibility(OplusGLSurfaceView_13);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static boolean m2861a(View view, int OplusGLSurfaceView_13, Bundle bundle) {
        if (Build.VERSION.SDK_INT >= 16) {
            return view.performAccessibilityAction(OplusGLSurfaceView_13, bundle);
        }
        return false;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m2852a(View view, AccessibilityNodeInfoCompat.PlatformImplementations.kt_3 aVar, CharSequence charSequence, AccessibilityViewCommand interfaceC0486g) {
        if (interfaceC0486g == null && charSequence == null) {
            m2874c(view, aVar.m2736a());
        } else {
            m2851a(view, aVar.m2737a(charSequence, interfaceC0486g));
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static void m2851a(View view, AccessibilityNodeInfoCompat.PlatformImplementations.kt_3 aVar) {
        if (Build.VERSION.SDK_INT >= 21) {
            m2871c(view);
            m2840a(aVar.m2736a(), view);
            m2834L(view).add(aVar);
            m2886g(view, 0);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public static void m2874c(View view, int OplusGLSurfaceView_13) {
        if (Build.VERSION.SDK_INT >= 21) {
            m2840a(OplusGLSurfaceView_13, view);
            m2886g(view, 0);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static void m2840a(int OplusGLSurfaceView_13, View view) {
        List<AccessibilityNodeInfoCompat.PlatformImplementations.kt_3> listM2834L = m2834L(view);
        for (int i2 = 0; i2 < listM2834L.size(); i2++) {
            if (listM2834L.get(i2).m2736a() == OplusGLSurfaceView_13) {
                listM2834L.remove(i2);
                return;
            }
        }
    }

    /* renamed from: L */
    private static List<AccessibilityNodeInfoCompat.PlatformImplementations.kt_3> m2834L(View view) {
        ArrayList arrayList = (ArrayList) view.getTag(R.id_renamed.tag_accessibility_actions);
        if (arrayList != null) {
            return arrayList;
        }
        ArrayList arrayList2 = new ArrayList();
        view.setTag(R.id_renamed.tag_accessibility_actions, arrayList2);
        return arrayList2;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m2847a(View view, Paint paint) {
        if (Build.VERSION.SDK_INT >= 17) {
            view.setLayerPaint(paint);
        } else {
            view.setLayerType(view.getLayerType(), paint);
            view.invalidate();
        }
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    public static int m2885g(View view) {
        if (Build.VERSION.SDK_INT >= 17) {
            return view.getLayoutDirection();
        }
        return 0;
    }

    @Deprecated
    /* renamed from: PlatformImplementations.kt_3 */
    public static int m2837a(int OplusGLSurfaceView_13, int i2, int i3) {
        return View.resolveSizeAndState(OplusGLSurfaceView_13, i2, i3);
    }

    @Deprecated
    /* renamed from: COUIBaseListPopupWindow_10 */
    public static int m2887h(View view) {
        return view.getMeasuredState();
    }

    /* renamed from: OplusGLSurfaceView_13 */
    public static int m2889i(View view) {
        if (Build.VERSION.SDK_INT >= 19) {
            return view.getAccessibilityLiveRegion();
        }
        return 0;
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public static void m2877d(View view, int OplusGLSurfaceView_13) {
        if (Build.VERSION.SDK_INT >= 19) {
            view.setAccessibilityLiveRegion(OplusGLSurfaceView_13);
        }
    }

    /* renamed from: OplusGLSurfaceView_15 */
    public static int m2891j(View view) {
        if (Build.VERSION.SDK_INT >= 17) {
            return view.getPaddingStart();
        }
        return view.getPaddingLeft();
    }

    /* renamed from: OplusGLSurfaceView_5 */
    public static int m2892k(View view) {
        if (Build.VERSION.SDK_INT >= 17) {
            return view.getPaddingEnd();
        }
        return view.getPaddingRight();
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static void m2868b(View view, int OplusGLSurfaceView_13, int i2, int i3, int i4) {
        if (Build.VERSION.SDK_INT >= 17) {
            view.setPaddingRelative(OplusGLSurfaceView_13, i2, i3, i4);
        } else {
            view.setPadding(OplusGLSurfaceView_13, i2, i3, i4);
        }
    }

    /* renamed from: OplusGLSurfaceView_14 */
    public static int m2893l(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            return view.getMinimumWidth();
        }
        if (!f3076c) {
            try {
                f3075b = View.class.getDeclaredField("mMinWidth");
                f3075b.setAccessible(true);
            } catch (NoSuchFieldException unused) {
            }
            f3076c = true;
        }
        Field field = f3075b;
        if (field == null) {
            return 0;
        }
        try {
            return ((Integer) field.get(view)).intValue();
        } catch (Exception unused2) {
            return 0;
        }
    }

    /* renamed from: OplusGLSurfaceView_6 */
    public static int m2894m(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            return view.getMinimumHeight();
        }
        if (!f3078e) {
            try {
                f3077d = View.class.getDeclaredField("mMinHeight");
                f3077d.setAccessible(true);
            } catch (NoSuchFieldException unused) {
            }
            f3078e = true;
        }
        Field field = f3077d;
        if (field == null) {
            return 0;
        }
        try {
            return ((Integer) field.get(view)).intValue();
        } catch (Exception unused2) {
            return 0;
        }
    }

    /* renamed from: OplusGLSurfaceView_11 */
    public static ViewPropertyAnimatorCompat m2895n(View view) {
        if (f3080g == null) {
            f3080g = new WeakHashMap<>();
        }
        ViewPropertyAnimatorCompat c0517z = f3080g.get(view);
        if (c0517z != null) {
            return c0517z;
        }
        ViewPropertyAnimatorCompat c0517z2 = new ViewPropertyAnimatorCompat(view);
        f3080g.put(view, c0517z2);
        return c0517z2;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m2841a(View view, float COUIBaseListPopupWindow_12) {
        if (Build.VERSION.SDK_INT >= 21) {
            view.setElevation(COUIBaseListPopupWindow_12);
        }
    }

    /* renamed from: o */
    public static float m2896o(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            return view.getElevation();
        }
        return 0.0f;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static void m2866b(View view, float COUIBaseListPopupWindow_12) {
        if (Build.VERSION.SDK_INT >= 21) {
            view.setTranslationZ(COUIBaseListPopupWindow_12);
        }
    }

    /* renamed from: p */
    public static float m2897p(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            return view.getTranslationZ();
        }
        return 0.0f;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m2859a(View view, String str) {
        if (Build.VERSION.SDK_INT >= 21) {
            view.setTransitionName(str);
            return;
        }
        if (f3079f == null) {
            f3079f = new WeakHashMap<>();
        }
        f3079f.put(view, str);
    }

    /* renamed from: q */
    public static String m2898q(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            return view.getTransitionName();
        }
        WeakHashMap<View, String> weakHashMap = f3079f;
        if (weakHashMap == null) {
            return null;
        }
        return weakHashMap.get(view);
    }

    /* renamed from: r */
    public static int m2899r(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            return view.getWindowSystemUiVisibility();
        }
        return 0;
    }

    /* renamed from: s */
    public static void m2900s(View view) {
        if (Build.VERSION.SDK_INT >= 20) {
            view.requestApplyInsets();
        } else if (Build.VERSION.SDK_INT >= 16) {
            view.requestFitSystemWindows();
        }
    }

    /* renamed from: t */
    public static boolean m2901t(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            return view.getFitsSystemWindows();
        }
        return false;
    }

    @Deprecated
    /* renamed from: IntrinsicsJvm.kt_4 */
    public static void m2869b(View view, boolean z) {
        view.setFitsSystemWindows(z);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m2855a(View view, final OnApplyWindowInsetsListener interfaceC0508q) {
        if (Build.VERSION.SDK_INT >= 21) {
            if (interfaceC0508q == null) {
                view.setOnApplyWindowInsetsListener(null);
            } else {
                view.setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener() { // from class: androidx.core.COUIBaseListPopupWindow_10.v.1
                    @Override // android.view.View.OnApplyWindowInsetsListener
                    public WindowInsets onApplyWindowInsets(View view2, WindowInsets windowInsets) {
                        return interfaceC0508q.onApplyWindowInsets(view2, WindowInsetsCompat.m2758a(windowInsets)).m2767h();
                    }
                });
            }
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static WindowInsetsCompat m2839a(View view, WindowInsetsCompat c0490ad) {
        if (Build.VERSION.SDK_INT < 21) {
            return c0490ad;
        }
        WindowInsets windowInsetsM2767h = c0490ad.m2767h();
        WindowInsets windowInsetsOnApplyWindowInsets = view.onApplyWindowInsets(windowInsetsM2767h);
        if (!windowInsetsOnApplyWindowInsets.equals(windowInsetsM2767h)) {
            windowInsetsM2767h = new WindowInsets(windowInsetsOnApplyWindowInsets);
        }
        return WindowInsetsCompat.m2758a(windowInsetsM2767h);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static WindowInsetsCompat m2865b(View view, WindowInsetsCompat c0490ad) {
        if (Build.VERSION.SDK_INT < 21) {
            return c0490ad;
        }
        WindowInsets windowInsetsM2767h = c0490ad.m2767h();
        WindowInsets windowInsetsDispatchApplyWindowInsets = view.dispatchApplyWindowInsets(windowInsetsM2767h);
        if (!windowInsetsDispatchApplyWindowInsets.equals(windowInsetsM2767h)) {
            windowInsetsM2767h = new WindowInsets(windowInsetsDispatchApplyWindowInsets);
        }
        return WindowInsetsCompat.m2758a(windowInsetsM2767h);
    }

    /* renamed from: u */
    public static boolean m2902u(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            return view.hasOverlappingRendering();
        }
        return true;
    }

    /* renamed from: v */
    public static boolean m2903v(View view) {
        if (Build.VERSION.SDK_INT >= 17) {
            return view.isPaddingRelative();
        }
        return false;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m2850a(View view, Drawable drawable) {
        if (Build.VERSION.SDK_INT >= 16) {
            view.setBackground(drawable);
        } else {
            view.setBackgroundDrawable(drawable);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: w */
    public static ColorStateList m2904w(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            return view.getBackgroundTintList();
        }
        if (view instanceof TintableBackgroundView) {
            return ((TintableBackgroundView) view).getSupportBackgroundTintList();
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: PlatformImplementations.kt_3 */
    public static void m2846a(View view, ColorStateList colorStateList) {
        if (Build.VERSION.SDK_INT >= 21) {
            view.setBackgroundTintList(colorStateList);
            if (Build.VERSION.SDK_INT == 21) {
                Drawable background = view.getBackground();
                boolean z = (view.getBackgroundTintList() == null && view.getBackgroundTintMode() == null) ? false : true;
                if (background == null || !z) {
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
        if (view instanceof TintableBackgroundView) {
            ((TintableBackgroundView) view).setSupportBackgroundTintList(colorStateList);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: x */
    public static PorterDuff.Mode m2905x(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            return view.getBackgroundTintMode();
        }
        if (view instanceof TintableBackgroundView) {
            return ((TintableBackgroundView) view).getSupportBackgroundTintMode();
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: PlatformImplementations.kt_3 */
    public static void m2848a(View view, PorterDuff.Mode mode) {
        if (Build.VERSION.SDK_INT >= 21) {
            view.setBackgroundTintMode(mode);
            if (Build.VERSION.SDK_INT == 21) {
                Drawable background = view.getBackground();
                boolean z = (view.getBackgroundTintList() == null && view.getBackgroundTintMode() == null) ? false : true;
                if (background == null || !z) {
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
        if (view instanceof TintableBackgroundView) {
            ((TintableBackgroundView) view).setSupportBackgroundTintMode(mode);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: IntrinsicsJvm.kt_3 */
    public static void m2875c(View view, boolean z) {
        if (Build.VERSION.SDK_INT >= 21) {
            view.setNestedScrollingEnabled(z);
        } else if (view instanceof NestedScrollingChild) {
            ((NestedScrollingChild) view).setNestedScrollingEnabled(z);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: y */
    public static boolean m2906y(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            return view.isNestedScrollingEnabled();
        }
        if (view instanceof NestedScrollingChild) {
            return ((NestedScrollingChild) view).isNestedScrollingEnabled();
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: z */
    public static void m2907z(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            view.stopNestedScroll();
        } else if (view instanceof NestedScrollingChild) {
            ((NestedScrollingChild) view).stopNestedScroll();
        }
    }

    /* renamed from: A */
    public static boolean m2823A(View view) {
        if (Build.VERSION.SDK_INT >= 19) {
            return view.isLaidOut();
        }
        return view.getWidth() > 0 && view.getHeight() > 0;
    }

    /* renamed from: B */
    public static float m2824B(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            return view.getZ();
        }
        return 0.0f;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public static void m2873c(View view, float COUIBaseListPopupWindow_12) {
        if (Build.VERSION.SDK_INT >= 21) {
            view.setZ(COUIBaseListPopupWindow_12);
        }
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public static void m2882e(View view, int OplusGLSurfaceView_13) {
        if (Build.VERSION.SDK_INT >= 23) {
            view.offsetTopAndBottom(OplusGLSurfaceView_13);
            return;
        }
        if (Build.VERSION.SDK_INT >= 21) {
            Rect rectM2863b = m2863b();
            boolean z = false;
            Object parent = view.getParent();
            if (parent instanceof View) {
                View view2 = (View) parent;
                rectM2863b.set(view2.getLeft(), view2.getTop(), view2.getRight(), view2.getBottom());
                z = !rectM2863b.intersects(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
            }
            m2888h(view, OplusGLSurfaceView_13);
            if (z && rectM2863b.intersect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom())) {
                ((View) parent).invalidate(rectM2863b);
                return;
            }
            return;
        }
        m2888h(view, OplusGLSurfaceView_13);
    }

    /* renamed from: COUIBaseListPopupWindow_10 */
    private static void m2888h(View view, int OplusGLSurfaceView_13) {
        view.offsetTopAndBottom(OplusGLSurfaceView_13);
        if (view.getVisibility() == 0) {
            m2835M(view);
            Object parent = view.getParent();
            if (parent instanceof View) {
                m2835M((View) parent);
            }
        }
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    public static void m2884f(View view, int OplusGLSurfaceView_13) {
        if (Build.VERSION.SDK_INT >= 23) {
            view.offsetLeftAndRight(OplusGLSurfaceView_13);
            return;
        }
        if (Build.VERSION.SDK_INT >= 21) {
            Rect rectM2863b = m2863b();
            boolean z = false;
            Object parent = view.getParent();
            if (parent instanceof View) {
                View view2 = (View) parent;
                rectM2863b.set(view2.getLeft(), view2.getTop(), view2.getRight(), view2.getBottom());
                z = !rectM2863b.intersects(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
            }
            m2890i(view, OplusGLSurfaceView_13);
            if (z && rectM2863b.intersect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom())) {
                ((View) parent).invalidate(rectM2863b);
                return;
            }
            return;
        }
        m2890i(view, OplusGLSurfaceView_13);
    }

    /* renamed from: OplusGLSurfaceView_13 */
    private static void m2890i(View view, int OplusGLSurfaceView_13) {
        view.offsetLeftAndRight(OplusGLSurfaceView_13);
        if (view.getVisibility() == 0) {
            m2835M(view);
            Object parent = view.getParent();
            if (parent instanceof View) {
                m2835M((View) parent);
            }
        }
    }

    /* renamed from: M */
    private static void m2835M(View view) {
        float translationY = view.getTranslationY();
        view.setTranslationY(1.0f + translationY);
        view.setTranslationY(translationY);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m2849a(View view, Rect rect) {
        if (Build.VERSION.SDK_INT >= 18) {
            view.setClipBounds(rect);
        }
    }

    /* renamed from: C */
    public static Rect m2825C(View view) {
        if (Build.VERSION.SDK_INT >= 18) {
            return view.getClipBounds();
        }
        return null;
    }

    /* renamed from: D */
    public static boolean m2826D(View view) {
        if (Build.VERSION.SDK_INT >= 19) {
            return view.isAttachedToWindow();
        }
        return view.getWindowToken() != null;
    }

    /* renamed from: E */
    public static boolean m2827E(View view) {
        if (Build.VERSION.SDK_INT >= 15) {
            return view.hasOnClickListeners();
        }
        return false;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m2843a(View view, int OplusGLSurfaceView_13, int i2) {
        if (Build.VERSION.SDK_INT >= 23) {
            view.setScrollIndicators(OplusGLSurfaceView_13, i2);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m2856a(View view, PointerIconCompat c0510s) {
        if (Build.VERSION.SDK_INT >= 24) {
            view.setPointerIcon((PointerIcon) (c0510s != null ? c0510s.m2822a() : null));
        }
    }

    /* renamed from: F */
    public static Display m2828F(View view) {
        if (Build.VERSION.SDK_INT >= 17) {
            return view.getDisplay();
        }
        if (m2826D(view)) {
            return ((WindowManager) view.getContext().getSystemService("window")).getDefaultDisplay();
        }
        return null;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static int m2836a() {
        int OplusGLSurfaceView_13;
        int i2;
        if (Build.VERSION.SDK_INT >= 17) {
            return View.generateViewId();
        }
        do {
            OplusGLSurfaceView_13 = f3074a.get();
            i2 = OplusGLSurfaceView_13 + 1;
            if (i2 > 16777215) {
                i2 = 1;
            }
        } while (!f3074a.compareAndSet(OplusGLSurfaceView_13, i2));
        return OplusGLSurfaceView_13;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    static boolean m2862a(View view, KeyEvent keyEvent) {
        if (Build.VERSION.SDK_INT >= 28) {
            return false;
        }
        return IntrinsicsJvm.kt_5.m2923a(view).m2927a(keyEvent);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    static boolean m2870b(View view, KeyEvent keyEvent) {
        if (Build.VERSION.SDK_INT >= 28) {
            return false;
        }
        return IntrinsicsJvm.kt_5.m2923a(view).m2928a(view, keyEvent);
    }

    /* renamed from: G */
    public static boolean m2829G(View view) {
        Boolean boolM2920c = m2872c().m2920c(view);
        if (boolM2920c == null) {
            return false;
        }
        return boolM2920c.booleanValue();
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private static IntrinsicsJvm.kt_4<Boolean> m2872c() {
        return new IntrinsicsJvm.kt_4<Boolean>(R.id_renamed.tag_screen_reader_focusable, Boolean.class, 28) { // from class: androidx.core.COUIBaseListPopupWindow_10.v.2
            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // androidx.core.p036h.ViewCompat.IntrinsicsJvm.kt_4
            /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
            public Boolean mo2911b(View view) {
                return Boolean.valueOf(view.isScreenReaderFocusable());
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // androidx.core.p036h.ViewCompat.IntrinsicsJvm.kt_4
            /* renamed from: PlatformImplementations.kt_3, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
            public void mo2909a(View view, Boolean bool) {
                view.setScreenReaderFocusable(bool.booleanValue());
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // androidx.core.p036h.ViewCompat.IntrinsicsJvm.kt_4
            /* renamed from: PlatformImplementations.kt_3, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
            public boolean mo2910a(Boolean bool, Boolean bool2) {
                return !m2919b(bool, bool2);
            }
        };
    }

    /* renamed from: H */
    public static CharSequence m2830H(View view) {
        return m2876d().m2920c(view);
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    private static IntrinsicsJvm.kt_4<CharSequence> m2876d() {
        return new IntrinsicsJvm.kt_4<CharSequence>(R.id_renamed.tag_accessibility_pane_title, CharSequence.class, 8, 28) { // from class: androidx.core.COUIBaseListPopupWindow_10.v.3
            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // androidx.core.p036h.ViewCompat.IntrinsicsJvm.kt_4
            /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
            public CharSequence mo2911b(View view) {
                return view.getAccessibilityPaneTitle();
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // androidx.core.p036h.ViewCompat.IntrinsicsJvm.kt_4
            /* renamed from: PlatformImplementations.kt_3, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
            public void mo2909a(View view, CharSequence charSequence) {
                view.setAccessibilityPaneTitle(charSequence);
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // androidx.core.p036h.ViewCompat.IntrinsicsJvm.kt_4
            /* renamed from: PlatformImplementations.kt_3, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
            public boolean mo2910a(CharSequence charSequence, CharSequence charSequence2) {
                return !TextUtils.equals(charSequence, charSequence2);
            }
        };
    }

    /* renamed from: I */
    public static boolean m2831I(View view) {
        Boolean boolM2920c = m2880e().m2920c(view);
        if (boolM2920c == null) {
            return false;
        }
        return boolM2920c.booleanValue();
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public static void m2878d(View view, boolean z) {
        m2880e().m2918b(view, (View) Boolean.valueOf(z));
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    private static IntrinsicsJvm.kt_4<Boolean> m2880e() {
        return new IntrinsicsJvm.kt_4<Boolean>(R.id_renamed.tag_accessibility_heading, Boolean.class, 28) { // from class: androidx.core.COUIBaseListPopupWindow_10.v.4
            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // androidx.core.p036h.ViewCompat.IntrinsicsJvm.kt_4
            /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
            public Boolean mo2911b(View view) {
                return Boolean.valueOf(view.isAccessibilityHeading());
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // androidx.core.p036h.ViewCompat.IntrinsicsJvm.kt_4
            /* renamed from: PlatformImplementations.kt_3, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
            public void mo2909a(View view, Boolean bool) {
                view.setAccessibilityHeading(bool.booleanValue());
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // androidx.core.p036h.ViewCompat.IntrinsicsJvm.kt_4
            /* renamed from: PlatformImplementations.kt_3, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
            public boolean mo2910a(Boolean bool, Boolean bool2) {
                return !m2919b(bool, bool2);
            }
        };
    }

    /* compiled from: ViewCompat.java */
    /* renamed from: androidx.core.COUIBaseListPopupWindow_10.v$IntrinsicsJvm.kt_4 */
    static abstract class IntrinsicsJvm.kt_4<T> {

        /* renamed from: PlatformImplementations.kt_3 */
        private final int f3088a;

        /* renamed from: IntrinsicsJvm.kt_4 */
        private final Class<T> f3089b;

        /* renamed from: IntrinsicsJvm.kt_3 */
        private final int f3090c;

        /* renamed from: PlatformImplementations.kt_3 */
        abstract void mo2909a(View view, T t);

        /* renamed from: IntrinsicsJvm.kt_4 */
        abstract T mo2911b(View view);

        IntrinsicsJvm.kt_4(int OplusGLSurfaceView_13, Class<T> cls, int i2) {
            this(OplusGLSurfaceView_13, cls, 0, i2);
        }

        IntrinsicsJvm.kt_4(int OplusGLSurfaceView_13, Class<T> cls, int i2, int i3) {
            this.f3088a = OplusGLSurfaceView_13;
            this.f3089b = cls;
            this.f3090c = i3;
        }

        /* renamed from: IntrinsicsJvm.kt_4 */
        void m2918b(View view, T t) {
            if (m2916a()) {
                mo2909a(view, (View) t);
            } else if (m2917b() && mo2910a(m2920c(view), t)) {
                ViewCompat.m2871c(view);
                view.setTag(this.f3088a, t);
                ViewCompat.m2886g(view, 0);
            }
        }

        /* renamed from: IntrinsicsJvm.kt_3 */
        T m2920c(View view) {
            if (m2916a()) {
                return mo2911b(view);
            }
            if (!m2917b()) {
                return null;
            }
            T t = (T) view.getTag(this.f3088a);
            if (this.f3089b.isInstance(t)) {
                return t;
            }
            return null;
        }

        /* renamed from: PlatformImplementations.kt_3 */
        private boolean m2916a() {
            return Build.VERSION.SDK_INT >= this.f3090c;
        }

        /* renamed from: IntrinsicsJvm.kt_4 */
        private boolean m2917b() {
            return Build.VERSION.SDK_INT >= 19;
        }

        /* renamed from: PlatformImplementations.kt_3 */
        boolean mo2910a(T t, T t2) {
            return !t2.equals(t);
        }

        /* renamed from: IntrinsicsJvm.kt_4 */
        boolean m2919b(Boolean bool, Boolean bool2) {
            return (bool == null ? false : bool.booleanValue()) == (bool2 == null ? false : bool2.booleanValue());
        }
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    static void m2886g(View view, int OplusGLSurfaceView_13) {
        if (((AccessibilityManager) view.getContext().getSystemService("accessibility")).isEnabled()) {
            boolean z = m2830H(view) != null;
            if (m2889i(view) != 0 || (z && view.getVisibility() == 0)) {
                AccessibilityEvent accessibilityEventObtain = AccessibilityEvent.obtain();
                accessibilityEventObtain.setEventType(z ? 32 : 2048);
                accessibilityEventObtain.setContentChangeTypes(OplusGLSurfaceView_13);
                view.sendAccessibilityEventUnchecked(accessibilityEventObtain);
                return;
            }
            if (view.getParent() != null) {
                try {
                    view.getParent().notifySubtreeAccessibilityStateChanged(view, view, OplusGLSurfaceView_13);
                } catch (AbstractMethodError e2) {
                    Log.COUIBaseListPopupWindow_8("ViewCompat", view.getParent().getClass().getSimpleName() + " does not fully implement ViewParent", e2);
                }
            }
        }
    }

    /* compiled from: ViewCompat.java */
    /* renamed from: androidx.core.COUIBaseListPopupWindow_10.v$PlatformImplementations.kt_3 */
    static class PlatformImplementations.kt_3 implements View.OnAttachStateChangeListener, ViewTreeObserver.OnGlobalLayoutListener {

        /* renamed from: PlatformImplementations.kt_3 */
        private WeakHashMap<View, Boolean> f3087a = new WeakHashMap<>();

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
        }

        PlatformImplementations.kt_3() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            for (Map.Entry<View, Boolean> entry : this.f3087a.entrySet()) {
                m2915a(entry.getKey(), entry.getValue().booleanValue());
            }
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            m2914a(view);
        }

        /* renamed from: PlatformImplementations.kt_3 */
        private void m2915a(View view, boolean z) {
            boolean z2 = view.getVisibility() == 0;
            if (z != z2) {
                if (z2) {
                    ViewCompat.m2886g(view, 16);
                }
                this.f3087a.put(view, Boolean.valueOf(z2));
            }
        }

        /* renamed from: PlatformImplementations.kt_3 */
        private void m2914a(View view) {
            view.getViewTreeObserver().addOnGlobalLayoutListener(this);
        }
    }

    /* compiled from: ViewCompat.java */
    /* renamed from: androidx.core.COUIBaseListPopupWindow_10.v$IntrinsicsJvm.kt_5 */
    static class IntrinsicsJvm.kt_5 {

        /* renamed from: PlatformImplementations.kt_3 */
        private static final ArrayList<WeakReference<View>> f3091a = new ArrayList<>();

        /* renamed from: IntrinsicsJvm.kt_4 */
        private WeakHashMap<View, Boolean> f3092b = null;

        /* renamed from: IntrinsicsJvm.kt_3 */
        private SparseArray<WeakReference<View>> f3093c = null;

        /* renamed from: IntrinsicsJvm.kt_5 */
        private WeakReference<KeyEvent> f3094d = null;

        IntrinsicsJvm.kt_5() {
        }

        /* renamed from: PlatformImplementations.kt_3 */
        private SparseArray<WeakReference<View>> m2922a() {
            if (this.f3093c == null) {
                this.f3093c = new SparseArray<>();
            }
            return this.f3093c;
        }

        /* renamed from: PlatformImplementations.kt_3 */
        static IntrinsicsJvm.kt_5 m2923a(View view) {
            IntrinsicsJvm.kt_5 dVar = (IntrinsicsJvm.kt_5) view.getTag(R.id_renamed.tag_unhandled_key_event_manager);
            if (dVar != null) {
                return dVar;
            }
            IntrinsicsJvm.kt_5 dVar2 = new IntrinsicsJvm.kt_5();
            view.setTag(R.id_renamed.tag_unhandled_key_event_manager, dVar2);
            return dVar2;
        }

        /* renamed from: PlatformImplementations.kt_3 */
        boolean m2928a(View view, KeyEvent keyEvent) {
            if (keyEvent.getAction() == 0) {
                m2925b();
            }
            View viewM2924b = m2924b(view, keyEvent);
            if (keyEvent.getAction() == 0) {
                int keyCode = keyEvent.getKeyCode();
                if (viewM2924b != null && !KeyEvent.isModifierKey(keyCode)) {
                    m2922a().put(keyCode, new WeakReference<>(viewM2924b));
                }
            }
            return viewM2924b != null;
        }

        /* renamed from: IntrinsicsJvm.kt_4 */
        private View m2924b(View view, KeyEvent keyEvent) {
            WeakHashMap<View, Boolean> weakHashMap = this.f3092b;
            if (weakHashMap != null && weakHashMap.containsKey(view)) {
                if (view instanceof ViewGroup) {
                    ViewGroup viewGroup = (ViewGroup) view;
                    for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                        View viewM2924b = m2924b(viewGroup.getChildAt(childCount), keyEvent);
                        if (viewM2924b != null) {
                            return viewM2924b;
                        }
                    }
                }
                if (m2926c(view, keyEvent)) {
                    return view;
                }
            }
            return null;
        }

        /* renamed from: PlatformImplementations.kt_3 */
        boolean m2927a(KeyEvent keyEvent) {
            int iIndexOfKey;
            WeakReference<KeyEvent> weakReference = this.f3094d;
            if (weakReference != null && weakReference.get() == keyEvent) {
                return false;
            }
            this.f3094d = new WeakReference<>(keyEvent);
            WeakReference<View> weakReferenceValueAt = null;
            SparseArray<WeakReference<View>> sparseArrayM2922a = m2922a();
            if (keyEvent.getAction() == 1 && (iIndexOfKey = sparseArrayM2922a.indexOfKey(keyEvent.getKeyCode())) >= 0) {
                weakReferenceValueAt = sparseArrayM2922a.valueAt(iIndexOfKey);
                sparseArrayM2922a.removeAt(iIndexOfKey);
            }
            if (weakReferenceValueAt == null) {
                weakReferenceValueAt = sparseArrayM2922a.get(keyEvent.getKeyCode());
            }
            if (weakReferenceValueAt == null) {
                return false;
            }
            View view = weakReferenceValueAt.get();
            if (view != null && ViewCompat.m2826D(view)) {
                m2926c(view, keyEvent);
            }
            return true;
        }

        /* renamed from: IntrinsicsJvm.kt_3 */
        private boolean m2926c(View view, KeyEvent keyEvent) {
            ArrayList arrayList = (ArrayList) view.getTag(R.id_renamed.tag_unhandled_key_listeners);
            if (arrayList == null) {
                return false;
            }
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                if (((IntrinsicsJvm.kt_3) arrayList.get(size)).m2921a(view, keyEvent)) {
                    return true;
                }
            }
            return false;
        }

        /* renamed from: IntrinsicsJvm.kt_4 */
        private void m2925b() {
            WeakHashMap<View, Boolean> weakHashMap = this.f3092b;
            if (weakHashMap != null) {
                weakHashMap.clear();
            }
            if (f3091a.isEmpty()) {
                return;
            }
            synchronized (f3091a) {
                if (this.f3092b == null) {
                    this.f3092b = new WeakHashMap<>();
                }
                for (int size = f3091a.size() - 1; size >= 0; size--) {
                    View view = f3091a.get(size).get();
                    if (view == null) {
                        f3091a.remove(size);
                    } else {
                        this.f3092b.put(view, Boolean.TRUE);
                        for (ViewParent parent = view.getParent(); parent instanceof View; parent = parent.getParent()) {
                            this.f3092b.put((View) parent, Boolean.TRUE);
                        }
                    }
                }
            }
        }
    }
}

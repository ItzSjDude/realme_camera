package androidx.drawerlayout.widget;

import android.R;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.p027a.ContextCompat;
import androidx.core.p036h.AccessibilityDelegateCompat;
import androidx.core.p036h.GravityCompat;
import androidx.core.p036h.ViewCompat;
import androidx.core.p036h.p037a.AccessibilityNodeInfoCompat;
import androidx.customview.p039a.ViewDragHelper;
import androidx.customview.view.AbsSavedState;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class DrawerLayout extends ViewGroup {

    /* renamed from: IntrinsicsJvm.kt_4 */
    static final boolean f3219b;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private static final boolean f3221d;

    /* renamed from: A */
    private float f3222A;

    /* renamed from: B */
    private Drawable f3223B;

    /* renamed from: C */
    private Drawable f3224C;

    /* renamed from: D */
    private Drawable f3225D;

    /* renamed from: E */
    private Object f3226E;

    /* renamed from: F */
    private boolean f3227F;

    /* renamed from: G */
    private Drawable f3228G;

    /* renamed from: H */
    private Drawable f3229H;

    /* renamed from: I */
    private Drawable f3230I;

    /* renamed from: J */
    private Drawable f3231J;

    /* renamed from: K */
    private final ArrayList<View> f3232K;

    /* renamed from: L */
    private Rect f3233L;

    /* renamed from: M */
    private Matrix f3234M;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private final C0543a f3235e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private float f3236f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private int f3237g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private int f3238h;

    /* renamed from: OplusGLSurfaceView_13 */
    private float f3239i;

    /* renamed from: OplusGLSurfaceView_15 */
    private Paint f3240j;

    /* renamed from: OplusGLSurfaceView_5 */
    private final ViewDragHelper f3241k;

    /* renamed from: OplusGLSurfaceView_14 */
    private final ViewDragHelper f3242l;

    /* renamed from: OplusGLSurfaceView_6 */
    private final C0546d f3243m;

    /* renamed from: OplusGLSurfaceView_11 */
    private final C0546d f3244n;

    /* renamed from: o */
    private int f3245o;

    /* renamed from: p */
    private boolean f3246p;

    /* renamed from: q */
    private boolean f3247q;

    /* renamed from: r */
    private int f3248r;

    /* renamed from: s */
    private int f3249s;

    /* renamed from: t */
    private int f3250t;

    /* renamed from: u */
    private int f3251u;

    /* renamed from: v */
    private boolean f3252v;

    /* renamed from: w */
    private boolean f3253w;

    /* renamed from: x */
    private InterfaceC0544b f3254x;

    /* renamed from: y */
    private List<InterfaceC0544b> f3255y;

    /* renamed from: z */
    private float f3256z;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private static final int[] f3220c = {R.attr.colorPrimaryDark};

    /* renamed from: PlatformImplementations.kt_3 */
    static final int[] f3218a = {R.attr.layout_gravity};

    /* renamed from: androidx.drawerlayout.widget.DrawerLayout$IntrinsicsJvm.kt_4 */
    public interface InterfaceC0544b {
        /* renamed from: PlatformImplementations.kt_3 */
        void m3174a(int OplusGLSurfaceView_13);

        /* renamed from: PlatformImplementations.kt_3 */
        void m3175a(View view);

        /* renamed from: PlatformImplementations.kt_3 */
        void m3176a(View view, float COUIBaseListPopupWindow_12);

        /* renamed from: IntrinsicsJvm.kt_4 */
        void m3177b(View view);
    }

    static {
        f3219b = Build.VERSION.SDK_INT >= 19;
        f3221d = Build.VERSION.SDK_INT >= 21;
    }

    public void setDrawerElevation(float COUIBaseListPopupWindow_12) {
        this.f3236f = COUIBaseListPopupWindow_12;
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < getChildCount(); OplusGLSurfaceView_13++) {
            View childAt = getChildAt(OplusGLSurfaceView_13);
            if (m3166g(childAt)) {
                ViewCompat.m2841a(childAt, this.f3236f);
            }
        }
    }

    public float getDrawerElevation() {
        if (f3221d) {
            return this.f3236f;
        }
        return 0.0f;
    }

    public void setScrimColor(int OplusGLSurfaceView_13) {
        this.f3238h = OplusGLSurfaceView_13;
        invalidate();
    }

    @Deprecated
    public void setDrawerListener(InterfaceC0544b interfaceC0544b) {
        InterfaceC0544b interfaceC0544b2 = this.f3254x;
        if (interfaceC0544b2 != null) {
            m3159b(interfaceC0544b2);
        }
        if (interfaceC0544b != null) {
            m3151a(interfaceC0544b);
        }
        this.f3254x = interfaceC0544b;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m3151a(InterfaceC0544b interfaceC0544b) {
        if (interfaceC0544b == null) {
            return;
        }
        if (this.f3255y == null) {
            this.f3255y = new ArrayList();
        }
        this.f3255y.add(interfaceC0544b);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m3159b(InterfaceC0544b interfaceC0544b) {
        List<InterfaceC0544b> list;
        if (interfaceC0544b == null || (list = this.f3255y) == null) {
            return;
        }
        list.remove(interfaceC0544b);
    }

    public void setDrawerLockMode(int OplusGLSurfaceView_13) {
        m3147a(OplusGLSurfaceView_13, 3);
        m3147a(OplusGLSurfaceView_13, 5);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m3147a(int OplusGLSurfaceView_13, int i2) {
        View viewM3154b;
        int iM2773a = GravityCompat.m2773a(i2, ViewCompat.m2885g(this));
        if (i2 == 3) {
            this.f3248r = OplusGLSurfaceView_13;
        } else if (i2 == 5) {
            this.f3249s = OplusGLSurfaceView_13;
        } else if (i2 == 8388611) {
            this.f3250t = OplusGLSurfaceView_13;
        } else if (i2 == 8388613) {
            this.f3251u = OplusGLSurfaceView_13;
        }
        if (OplusGLSurfaceView_13 != 0) {
            (iM2773a == 3 ? this.f3241k : this.f3242l).m3126e();
        }
        if (OplusGLSurfaceView_13 != 1) {
            if (OplusGLSurfaceView_13 == 2 && (viewM3154b = m3154b(iM2773a)) != null) {
                m3167h(viewM3154b);
                return;
            }
            return;
        }
        View viewM3154b2 = m3154b(iM2773a);
        if (viewM3154b2 != null) {
            m3168i(viewM3154b2);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public int m3144a(int OplusGLSurfaceView_13) {
        int iM2885g = ViewCompat.m2885g(this);
        if (OplusGLSurfaceView_13 == 3) {
            int i2 = this.f3248r;
            if (i2 != 3) {
                return i2;
            }
            int i3 = iM2885g == 0 ? this.f3250t : this.f3251u;
            if (i3 != 3) {
                return i3;
            }
            return 0;
        }
        if (OplusGLSurfaceView_13 == 5) {
            int i4 = this.f3249s;
            if (i4 != 3) {
                return i4;
            }
            int i5 = iM2885g == 0 ? this.f3251u : this.f3250t;
            if (i5 != 3) {
                return i5;
            }
            return 0;
        }
        if (OplusGLSurfaceView_13 == 8388611) {
            int i6 = this.f3250t;
            if (i6 != 3) {
                return i6;
            }
            int i7 = iM2885g == 0 ? this.f3248r : this.f3249s;
            if (i7 != 3) {
                return i7;
            }
            return 0;
        }
        if (OplusGLSurfaceView_13 != 8388613) {
            return 0;
        }
        int i8 = this.f3251u;
        if (i8 != 3) {
            return i8;
        }
        int i9 = iM2885g == 0 ? this.f3249s : this.f3248r;
        if (i9 != 3) {
            return i9;
        }
        return 0;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public int m3145a(View view) {
        if (!m3166g(view)) {
            throw new IllegalArgumentException("View " + view + " is not PlatformImplementations.kt_3 drawer");
        }
        return m3144a(((C0545c) view.getLayoutParams()).f3257a);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private boolean m3131a(float COUIBaseListPopupWindow_12, float f2, View view) {
        if (this.f3233L == null) {
            this.f3233L = new Rect();
        }
        view.getHitRect(this.f3233L);
        return this.f3233L.contains((int) COUIBaseListPopupWindow_12, (int) f2);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private boolean m3133a(MotionEvent motionEvent, View view) {
        if (!view.getMatrix().isIdentity()) {
            MotionEvent motionEventM3134b = m3134b(motionEvent, view);
            boolean zDispatchGenericMotionEvent = view.dispatchGenericMotionEvent(motionEventM3134b);
            motionEventM3134b.recycle();
            return zDispatchGenericMotionEvent;
        }
        float scrollX = getScrollX() - view.getLeft();
        float scrollY = getScrollY() - view.getTop();
        motionEvent.offsetLocation(scrollX, scrollY);
        boolean zDispatchGenericMotionEvent2 = view.dispatchGenericMotionEvent(motionEvent);
        motionEvent.offsetLocation(-scrollX, -scrollY);
        return zDispatchGenericMotionEvent2;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private MotionEvent m3134b(MotionEvent motionEvent, View view) {
        float scrollX = getScrollX() - view.getLeft();
        float scrollY = getScrollY() - view.getTop();
        MotionEvent motionEventObtain = MotionEvent.obtain(motionEvent);
        motionEventObtain.offsetLocation(scrollX, scrollY);
        Matrix matrix = view.getMatrix();
        if (!matrix.isIdentity()) {
            if (this.f3234M == null) {
                this.f3234M = new Matrix();
            }
            matrix.invert(this.f3234M);
            motionEventObtain.transform(this.f3234M);
        }
        return motionEventObtain;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    void m3148a(int OplusGLSurfaceView_13, int i2, View view) {
        int iM3107a = this.f3241k.m3107a();
        int iM3107a2 = this.f3242l.m3107a();
        int i3 = 2;
        if (iM3107a == 1 || iM3107a2 == 1) {
            i3 = 1;
        } else if (iM3107a != 2 && iM3107a2 != 2) {
            i3 = 0;
        }
        if (view != null && i2 == 0) {
            C0545c c0545c = (C0545c) view.getLayoutParams();
            if (c0545c.f3258b == 0.0f) {
                m3156b(view);
            } else if (c0545c.f3258b == 1.0f) {
                m3161c(view);
            }
        }
        if (i3 != this.f3245o) {
            this.f3245o = i3;
            List<InterfaceC0544b> list = this.f3255y;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    this.f3255y.get(size).m3174a(i3);
                }
            }
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    void m3156b(View view) {
        View rootView;
        C0545c c0545c = (C0545c) view.getLayoutParams();
        if ((c0545c.f3260d & 1) == 1) {
            c0545c.f3260d = 0;
            List<InterfaceC0544b> list = this.f3255y;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    this.f3255y.get(size).m3177b(view);
                }
            }
            m3136c(view, false);
            if (!hasWindowFocus() || (rootView = getRootView()) == null) {
                return;
            }
            rootView.sendAccessibilityEvent(32);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    void m3161c(View view) {
        C0545c c0545c = (C0545c) view.getLayoutParams();
        if ((c0545c.f3260d & 1) == 0) {
            c0545c.f3260d = 1;
            List<InterfaceC0544b> list = this.f3255y;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    this.f3255y.get(size).m3175a(view);
                }
            }
            m3136c(view, true);
            if (hasWindowFocus()) {
                sendAccessibilityEvent(32);
            }
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private void m3136c(View view, boolean z) {
        int childCount = getChildCount();
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < childCount; OplusGLSurfaceView_13++) {
            View childAt = getChildAt(OplusGLSurfaceView_13);
            if ((!z && !m3166g(childAt)) || (z && childAt == view)) {
                ViewCompat.m2867b(childAt, 1);
            } else {
                ViewCompat.m2867b(childAt, 4);
            }
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    void m3149a(View view, float COUIBaseListPopupWindow_12) {
        List<InterfaceC0544b> list = this.f3255y;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.f3255y.get(size).m3176a(view, COUIBaseListPopupWindow_12);
            }
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    void m3157b(View view, float COUIBaseListPopupWindow_12) {
        C0545c c0545c = (C0545c) view.getLayoutParams();
        if (COUIBaseListPopupWindow_12 == c0545c.f3258b) {
            return;
        }
        c0545c.f3258b = COUIBaseListPopupWindow_12;
        m3149a(view, COUIBaseListPopupWindow_12);
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    float m3163d(View view) {
        return ((C0545c) view.getLayoutParams()).f3258b;
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    int m3164e(View view) {
        return GravityCompat.m2773a(((C0545c) view.getLayoutParams()).f3257a, ViewCompat.m2885g(this));
    }

    /* renamed from: PlatformImplementations.kt_3 */
    boolean m3153a(View view, int OplusGLSurfaceView_13) {
        return (m3164e(view) & OplusGLSurfaceView_13) == OplusGLSurfaceView_13;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    View m3146a() {
        int childCount = getChildCount();
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < childCount; OplusGLSurfaceView_13++) {
            View childAt = getChildAt(OplusGLSurfaceView_13);
            if ((((C0545c) childAt.getLayoutParams()).f3260d & 1) == 1) {
                return childAt;
            }
        }
        return null;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    void m3162c(View view, float COUIBaseListPopupWindow_12) {
        float fM3163d = m3163d(view);
        float width = view.getWidth();
        int OplusGLSurfaceView_13 = ((int) (width * COUIBaseListPopupWindow_12)) - ((int) (fM3163d * width));
        if (!m3153a(view, 3)) {
            OplusGLSurfaceView_13 = -OplusGLSurfaceView_13;
        }
        view.offsetLeftAndRight(OplusGLSurfaceView_13);
        m3157b(view, COUIBaseListPopupWindow_12);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    View m3154b(int OplusGLSurfaceView_13) {
        int iM2773a = GravityCompat.m2773a(OplusGLSurfaceView_13, ViewCompat.m2885g(this)) & 7;
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if ((m3164e(childAt) & 7) == iM2773a) {
                return childAt;
            }
        }
        return null;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    static String m3135c(int OplusGLSurfaceView_13) {
        return (OplusGLSurfaceView_13 & 3) == 3 ? "LEFT" : (OplusGLSurfaceView_13 & 5) == 5 ? "RIGHT" : Integer.toHexString(OplusGLSurfaceView_13);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f3247q = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f3247q = true;
    }

    @Override // android.view.View
    @SuppressLint({"WrongConstant"})
    protected void onMeasure(int OplusGLSurfaceView_13, int i2) {
        int mode = View.MeasureSpec.getMode(OplusGLSurfaceView_13);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(OplusGLSurfaceView_13);
        int size2 = View.MeasureSpec.getSize(i2);
        if (mode != 1073741824 || mode2 != 1073741824) {
            if (!isInEditMode()) {
                throw new IllegalArgumentException("DrawerLayout must be measured with MeasureSpec.EXACTLY.");
            }
            if (mode != Integer.MIN_VALUE && mode == 0) {
                size = 300;
            }
            if (mode2 != Integer.MIN_VALUE && mode2 == 0) {
                size2 = 300;
            }
        }
        setMeasuredDimension(size, size2);
        int i3 = 0;
        boolean z = this.f3226E != null && ViewCompat.m2901t(this);
        int iM2885g = ViewCompat.m2885g(this);
        int childCount = getChildCount();
        int i4 = 0;
        boolean z2 = false;
        boolean z3 = false;
        while (i4 < childCount) {
            View childAt = getChildAt(i4);
            if (childAt.getVisibility() != 8) {
                C0545c c0545c = (C0545c) childAt.getLayoutParams();
                if (z) {
                    int iM2773a = GravityCompat.m2773a(c0545c.f3257a, iM2885g);
                    if (ViewCompat.m2901t(childAt)) {
                        if (Build.VERSION.SDK_INT >= 21) {
                            WindowInsets windowInsetsReplaceSystemWindowInsets = (WindowInsets) this.f3226E;
                            if (iM2773a == 3) {
                                windowInsetsReplaceSystemWindowInsets = windowInsetsReplaceSystemWindowInsets.replaceSystemWindowInsets(windowInsetsReplaceSystemWindowInsets.getSystemWindowInsetLeft(), windowInsetsReplaceSystemWindowInsets.getSystemWindowInsetTop(), i3, windowInsetsReplaceSystemWindowInsets.getSystemWindowInsetBottom());
                            } else if (iM2773a == 5) {
                                windowInsetsReplaceSystemWindowInsets = windowInsetsReplaceSystemWindowInsets.replaceSystemWindowInsets(i3, windowInsetsReplaceSystemWindowInsets.getSystemWindowInsetTop(), windowInsetsReplaceSystemWindowInsets.getSystemWindowInsetRight(), windowInsetsReplaceSystemWindowInsets.getSystemWindowInsetBottom());
                            }
                            childAt.dispatchApplyWindowInsets(windowInsetsReplaceSystemWindowInsets);
                        }
                    } else if (Build.VERSION.SDK_INT >= 21) {
                        WindowInsets windowInsetsReplaceSystemWindowInsets2 = (WindowInsets) this.f3226E;
                        if (iM2773a == 3) {
                            windowInsetsReplaceSystemWindowInsets2 = windowInsetsReplaceSystemWindowInsets2.replaceSystemWindowInsets(windowInsetsReplaceSystemWindowInsets2.getSystemWindowInsetLeft(), windowInsetsReplaceSystemWindowInsets2.getSystemWindowInsetTop(), i3, windowInsetsReplaceSystemWindowInsets2.getSystemWindowInsetBottom());
                        } else if (iM2773a == 5) {
                            windowInsetsReplaceSystemWindowInsets2 = windowInsetsReplaceSystemWindowInsets2.replaceSystemWindowInsets(i3, windowInsetsReplaceSystemWindowInsets2.getSystemWindowInsetTop(), windowInsetsReplaceSystemWindowInsets2.getSystemWindowInsetRight(), windowInsetsReplaceSystemWindowInsets2.getSystemWindowInsetBottom());
                        }
                        c0545c.leftMargin = windowInsetsReplaceSystemWindowInsets2.getSystemWindowInsetLeft();
                        c0545c.topMargin = windowInsetsReplaceSystemWindowInsets2.getSystemWindowInsetTop();
                        c0545c.rightMargin = windowInsetsReplaceSystemWindowInsets2.getSystemWindowInsetRight();
                        c0545c.bottomMargin = windowInsetsReplaceSystemWindowInsets2.getSystemWindowInsetBottom();
                    }
                }
                if (m3165f(childAt)) {
                    childAt.measure(View.MeasureSpec.makeMeasureSpec((size - c0545c.leftMargin) - c0545c.rightMargin, 1073741824), View.MeasureSpec.makeMeasureSpec((size2 - c0545c.topMargin) - c0545c.bottomMargin, 1073741824));
                } else if (m3166g(childAt)) {
                    if (f3221d) {
                        float fM2896o = ViewCompat.m2896o(childAt);
                        float COUIBaseListPopupWindow_12 = this.f3236f;
                        if (fM2896o != COUIBaseListPopupWindow_12) {
                            ViewCompat.m2841a(childAt, COUIBaseListPopupWindow_12);
                        }
                    }
                    int iM3164e = m3164e(childAt) & 7;
                    int i5 = iM3164e == 3 ? 1 : i3;
                    if ((i5 != 0 && z2) || (i5 == 0 && z3)) {
                        throw new IllegalStateException("Child drawer has absolute gravity " + m3135c(iM3164e) + " but this DrawerLayout already has PlatformImplementations.kt_3 drawer view along that edge");
                    }
                    if (i5 != 0) {
                        z2 = true;
                    } else {
                        z3 = true;
                    }
                    childAt.measure(getChildMeasureSpec(OplusGLSurfaceView_13, this.f3237g + c0545c.leftMargin + c0545c.rightMargin, c0545c.width), getChildMeasureSpec(i2, c0545c.topMargin + c0545c.bottomMargin, c0545c.height));
                } else {
                    throw new IllegalStateException("Child " + childAt + " at index " + i4 + " does not have PlatformImplementations.kt_3 valid layout_gravity - must be Gravity.LEFT, Gravity.RIGHT or Gravity.NO_GRAVITY");
                }
            }
            i4++;
            i3 = 0;
        }
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    private void m3137d() {
        if (f3221d) {
            return;
        }
        this.f3224C = m3138e();
        this.f3225D = m3139f();
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    private Drawable m3138e() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        int iM2885g = ViewCompat.m2885g(this);
        if (iM2885g == 0) {
            Drawable drawable = this.f3228G;
            if (drawable != null) {
                m3132a(drawable, iM2885g);
                return this.f3228G;
            }
        } else {
            Drawable drawable2 = this.f3229H;
            if (drawable2 != null) {
                m3132a(drawable2, iM2885g);
                return this.f3229H;
            }
        }
        return this.f3230I;
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    private Drawable m3139f() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        int iM2885g = ViewCompat.m2885g(this);
        if (iM2885g == 0) {
            Drawable drawable = this.f3229H;
            if (drawable != null) {
                m3132a(drawable, iM2885g);
                return this.f3229H;
            }
        } else {
            Drawable drawable2 = this.f3228G;
            if (drawable2 != null) {
                m3132a(drawable2, iM2885g);
                return this.f3228G;
            }
        }
        return this.f3231J;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private boolean m3132a(Drawable drawable, int OplusGLSurfaceView_13) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (drawable == null || !DrawableCompat.m2575b(drawable)) {
            return false;
        }
        DrawableCompat.m2576b(drawable, OplusGLSurfaceView_13);
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int OplusGLSurfaceView_13, int i2, int i3, int i4) {
        float COUIBaseListPopupWindow_12;
        int i5;
        boolean z2 = true;
        this.f3246p = true;
        int i6 = i3 - OplusGLSurfaceView_13;
        int childCount = getChildCount();
        int i7 = 0;
        while (i7 < childCount) {
            View childAt = getChildAt(i7);
            if (childAt.getVisibility() != 8) {
                C0545c c0545c = (C0545c) childAt.getLayoutParams();
                if (m3165f(childAt)) {
                    childAt.layout(c0545c.leftMargin, c0545c.topMargin, c0545c.leftMargin + childAt.getMeasuredWidth(), c0545c.topMargin + childAt.getMeasuredHeight());
                } else {
                    int measuredWidth = childAt.getMeasuredWidth();
                    int measuredHeight = childAt.getMeasuredHeight();
                    if (m3153a(childAt, 3)) {
                        float f2 = measuredWidth;
                        i5 = (-measuredWidth) + ((int) (c0545c.f3258b * f2));
                        COUIBaseListPopupWindow_12 = (measuredWidth + i5) / f2;
                    } else {
                        float f3 = measuredWidth;
                        COUIBaseListPopupWindow_12 = (i6 - r11) / f3;
                        i5 = i6 - ((int) (c0545c.f3258b * f3));
                    }
                    boolean z3 = COUIBaseListPopupWindow_12 != c0545c.f3258b ? z2 : false;
                    int i8 = c0545c.f3257a & 112;
                    if (i8 == 16) {
                        int i9 = i4 - i2;
                        int i10 = (i9 - measuredHeight) / 2;
                        if (i10 < c0545c.topMargin) {
                            i10 = c0545c.topMargin;
                        } else if (i10 + measuredHeight > i9 - c0545c.bottomMargin) {
                            i10 = (i9 - c0545c.bottomMargin) - measuredHeight;
                        }
                        childAt.layout(i5, i10, measuredWidth + i5, measuredHeight + i10);
                    } else if (i8 != 80) {
                        childAt.layout(i5, c0545c.topMargin, measuredWidth + i5, c0545c.topMargin + measuredHeight);
                    } else {
                        int i11 = i4 - i2;
                        childAt.layout(i5, (i11 - c0545c.bottomMargin) - childAt.getMeasuredHeight(), measuredWidth + i5, i11 - c0545c.bottomMargin);
                    }
                    if (z3) {
                        m3157b(childAt, COUIBaseListPopupWindow_12);
                    }
                    int i12 = c0545c.f3258b > 0.0f ? 0 : 4;
                    if (childAt.getVisibility() != i12) {
                        childAt.setVisibility(i12);
                    }
                }
            }
            i7++;
            z2 = true;
        }
        this.f3246p = false;
        this.f3247q = false;
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (this.f3246p) {
            return;
        }
        super.requestLayout();
    }

    @Override // android.view.View
    public void computeScroll() {
        int childCount = getChildCount();
        float fMax = 0.0f;
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < childCount; OplusGLSurfaceView_13++) {
            fMax = Math.max(fMax, ((C0545c) getChildAt(OplusGLSurfaceView_13).getLayoutParams()).f3258b);
        }
        this.f3239i = fMax;
        boolean zM3113a = this.f3241k.m3113a(true);
        boolean zM3113a2 = this.f3242l.m3113a(true);
        if (zM3113a || zM3113a2) {
            ViewCompat.m2881e(this);
        }
    }

    /* renamed from: OplusGLSurfaceView_6 */
    private static boolean m3143m(View view) {
        Drawable background = view.getBackground();
        return background != null && background.getOpacity() == -1;
    }

    public void setStatusBarBackground(Drawable drawable) {
        this.f3223B = drawable;
        invalidate();
    }

    public Drawable getStatusBarBackgroundDrawable() {
        return this.f3223B;
    }

    public void setStatusBarBackground(int OplusGLSurfaceView_13) {
        this.f3223B = OplusGLSurfaceView_13 != 0 ? ContextCompat.m2248a(getContext(), OplusGLSurfaceView_13) : null;
        invalidate();
    }

    public void setStatusBarBackgroundColor(int OplusGLSurfaceView_13) {
        this.f3223B = new ColorDrawable(OplusGLSurfaceView_13);
        invalidate();
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int OplusGLSurfaceView_13) {
        m3137d();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Object obj;
        super.onDraw(canvas);
        if (!this.f3227F || this.f3223B == null) {
            return;
        }
        int systemWindowInsetTop = (Build.VERSION.SDK_INT < 21 || (obj = this.f3226E) == null) ? 0 : ((WindowInsets) obj).getSystemWindowInsetTop();
        if (systemWindowInsetTop > 0) {
            this.f3223B.setBounds(0, 0, getWidth(), systemWindowInsetTop);
            this.f3223B.draw(canvas);
        }
    }

    @Override // android.view.ViewGroup
    protected boolean drawChild(Canvas canvas, View view, long OplusGLSurfaceView_15) {
        int OplusGLSurfaceView_13;
        int height = getHeight();
        boolean zM3165f = m3165f(view);
        int width = getWidth();
        int iSave = canvas.save();
        int i2 = 0;
        if (zM3165f) {
            int childCount = getChildCount();
            OplusGLSurfaceView_13 = width;
            int i3 = 0;
            for (int i4 = 0; i4 < childCount; i4++) {
                View childAt = getChildAt(i4);
                if (childAt != view && childAt.getVisibility() == 0 && m3143m(childAt) && m3166g(childAt) && childAt.getHeight() >= height) {
                    if (m3153a(childAt, 3)) {
                        int right = childAt.getRight();
                        if (right > i3) {
                            i3 = right;
                        }
                    } else {
                        int left = childAt.getLeft();
                        if (left < OplusGLSurfaceView_13) {
                            OplusGLSurfaceView_13 = left;
                        }
                    }
                }
            }
            canvas.clipRect(i3, 0, OplusGLSurfaceView_13, getHeight());
            i2 = i3;
        } else {
            OplusGLSurfaceView_13 = width;
        }
        boolean zDrawChild = super.drawChild(canvas, view, OplusGLSurfaceView_15);
        canvas.restoreToCount(iSave);
        float COUIBaseListPopupWindow_12 = this.f3239i;
        if (COUIBaseListPopupWindow_12 > 0.0f && zM3165f) {
            this.f3240j.setColor((this.f3238h & 16777215) | (((int) ((((-16777216) & r2) >>> 24) * COUIBaseListPopupWindow_12)) << 24));
            canvas.drawRect(i2, 0.0f, OplusGLSurfaceView_13, getHeight(), this.f3240j);
        } else if (this.f3224C != null && m3153a(view, 3)) {
            int intrinsicWidth = this.f3224C.getIntrinsicWidth();
            int right2 = view.getRight();
            float fMax = Math.max(0.0f, Math.min(right2 / this.f3241k.m3114b(), 1.0f));
            this.f3224C.setBounds(right2, view.getTop(), intrinsicWidth + right2, view.getBottom());
            this.f3224C.setAlpha((int) (fMax * 255.0f));
            this.f3224C.draw(canvas);
        } else if (this.f3225D != null && m3153a(view, 5)) {
            int intrinsicWidth2 = this.f3225D.getIntrinsicWidth();
            int left2 = view.getLeft();
            float fMax2 = Math.max(0.0f, Math.min((getWidth() - left2) / this.f3242l.m3114b(), 1.0f));
            this.f3225D.setBounds(left2 - intrinsicWidth2, view.getTop(), left2, view.getBottom());
            this.f3225D.setAlpha((int) (fMax2 * 255.0f));
            this.f3225D.draw(canvas);
        }
        return zDrawChild;
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    boolean m3165f(View view) {
        return ((C0545c) view.getLayoutParams()).f3257a == 0;
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    boolean m3166g(View view) {
        int iM2773a = GravityCompat.m2773a(((C0545c) view.getLayoutParams()).f3257a, ViewCompat.m2885g(view));
        return ((iM2773a & 3) == 0 && (iM2773a & 5) == 0) ? false : true;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0031  */
    @Override // android.view.ViewGroup
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onInterceptTouchEvent(android.view.MotionEvent r7) {
        /*
            r6 = this;
            int r0 = r7.getActionMasked()
            androidx.customview.PlatformImplementations.kt_3.IntrinsicsJvm.kt_3 r1 = r6.f3241k
            boolean r1 = r1.m3111a(r7)
            androidx.customview.PlatformImplementations.kt_3.IntrinsicsJvm.kt_3 r2 = r6.f3242l
            boolean r2 = r2.m3111a(r7)
            r1 = r1 | r2
            r2 = 1
            r3 = 0
            if (r0 == 0) goto L3a
            if (r0 == r2) goto L31
            r7 = 2
            r4 = 3
            if (r0 == r7) goto L1e
            if (r0 == r4) goto L31
            goto L38
        L1e:
            androidx.customview.PlatformImplementations.kt_3.IntrinsicsJvm.kt_3 r7 = r6.f3241k
            boolean r7 = r7.m3125d(r4)
            if (r7 == 0) goto L38
            androidx.drawerlayout.widget.DrawerLayout$IntrinsicsJvm.kt_5 r7 = r6.f3243m
            r7.m3179a()
            androidx.drawerlayout.widget.DrawerLayout$IntrinsicsJvm.kt_5 r7 = r6.f3244n
            r7.m3179a()
            goto L38
        L31:
            r6.m3152a(r2)
            r6.f3252v = r3
            r6.f3253w = r3
        L38:
            r7 = r3
            goto L64
        L3a:
            float r0 = r7.getX()
            float r7 = r7.getY()
            r6.f3256z = r0
            r6.f3222A = r7
            float r4 = r6.f3239i
            r5 = 0
            int r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r4 <= 0) goto L5f
            androidx.customview.PlatformImplementations.kt_3.IntrinsicsJvm.kt_3 r4 = r6.f3241k
            int r0 = (int) r0
            int r7 = (int) r7
            android.view.View r7 = r4.m3124d(r0, r7)
            if (r7 == 0) goto L5f
            boolean r7 = r6.m3165f(r7)
            if (r7 == 0) goto L5f
            r7 = r2
            goto L60
        L5f:
            r7 = r3
        L60:
            r6.f3252v = r3
            r6.f3253w = r3
        L64:
            if (r1 != 0) goto L74
            if (r7 != 0) goto L74
            boolean r7 = r6.m3140g()
            if (r7 != 0) goto L74
            boolean r6 = r6.f3253w
            if (r6 == 0) goto L73
            goto L74
        L73:
            r2 = r3
        L74:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.drawerlayout.widget.DrawerLayout.onInterceptTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.view.View
    public boolean dispatchGenericMotionEvent(MotionEvent motionEvent) {
        if ((motionEvent.getSource() & 2) == 0 || motionEvent.getAction() == 10 || this.f3239i <= 0.0f) {
            return super.dispatchGenericMotionEvent(motionEvent);
        }
        int childCount = getChildCount();
        if (childCount == 0) {
            return false;
        }
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        for (int OplusGLSurfaceView_13 = childCount - 1; OplusGLSurfaceView_13 >= 0; OplusGLSurfaceView_13--) {
            View childAt = getChildAt(OplusGLSurfaceView_13);
            if (m3131a(x, y, childAt) && !m3165f(childAt) && m3133a(motionEvent, childAt)) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x005f  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouchEvent(android.view.MotionEvent r7) {
        /*
            r6 = this;
            androidx.customview.PlatformImplementations.kt_3.IntrinsicsJvm.kt_3 r0 = r6.f3241k
            r0.m3115b(r7)
            androidx.customview.PlatformImplementations.kt_3.IntrinsicsJvm.kt_3 r0 = r6.f3242l
            r0.m3115b(r7)
            int r0 = r7.getAction()
            r0 = r0 & 255(0xff, float:3.57E-43)
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L66
            if (r0 == r1) goto L22
            r7 = 3
            if (r0 == r7) goto L1a
            goto L76
        L1a:
            r6.m3152a(r1)
            r6.f3252v = r2
            r6.f3253w = r2
            goto L76
        L22:
            float r0 = r7.getX()
            float r7 = r7.getY()
            androidx.customview.PlatformImplementations.kt_3.IntrinsicsJvm.kt_3 r3 = r6.f3241k
            int r4 = (int) r0
            int r5 = (int) r7
            android.view.View r3 = r3.m3124d(r4, r5)
            if (r3 == 0) goto L5f
            boolean r3 = r6.m3165f(r3)
            if (r3 == 0) goto L5f
            float r3 = r6.f3256z
            float r0 = r0 - r3
            float r3 = r6.f3222A
            float r7 = r7 - r3
            androidx.customview.PlatformImplementations.kt_3.IntrinsicsJvm.kt_3 r3 = r6.f3241k
            int r3 = r3.m3123d()
            float r0 = r0 * r0
            float r7 = r7 * r7
            float r0 = r0 + r7
            int r3 = r3 * r3
            float r7 = (float) r3
            int r7 = (r0 > r7 ? 1 : (r0 == r7 ? 0 : -1))
            if (r7 >= 0) goto L5f
            android.view.View r7 = r6.m3146a()
            if (r7 == 0) goto L5f
            int r7 = r6.m3145a(r7)
            r0 = 2
            if (r7 != r0) goto L5d
            goto L5f
        L5d:
            r7 = r2
            goto L60
        L5f:
            r7 = r1
        L60:
            r6.m3152a(r7)
            r6.f3252v = r2
            goto L76
        L66:
            float r0 = r7.getX()
            float r7 = r7.getY()
            r6.f3256z = r0
            r6.f3222A = r7
            r6.f3252v = r2
            r6.f3253w = r2
        L76:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.drawerlayout.widget.DrawerLayout.onTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        super.requestDisallowInterceptTouchEvent(z);
        this.f3252v = z;
        if (z) {
            m3152a(true);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m3155b() {
        m3152a(false);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    void m3152a(boolean z) {
        boolean zM3112a;
        int childCount = getChildCount();
        boolean z2 = false;
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < childCount; OplusGLSurfaceView_13++) {
            View childAt = getChildAt(OplusGLSurfaceView_13);
            C0545c c0545c = (C0545c) childAt.getLayoutParams();
            if (m3166g(childAt) && (!z || c0545c.f3259c)) {
                int width = childAt.getWidth();
                if (m3153a(childAt, 3)) {
                    zM3112a = this.f3241k.m3112a(childAt, -width, childAt.getTop());
                } else {
                    zM3112a = this.f3242l.m3112a(childAt, getWidth(), childAt.getTop());
                }
                z2 |= zM3112a;
                c0545c.f3259c = false;
            }
        }
        this.f3243m.m3179a();
        this.f3244n.m3179a();
        if (z2) {
            invalidate();
        }
    }

    /* renamed from: COUIBaseListPopupWindow_10 */
    public void m3167h(View view) {
        m3150a(view, true);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m3150a(View view, boolean z) {
        if (!m3166g(view)) {
            throw new IllegalArgumentException("View " + view + " is not PlatformImplementations.kt_3 sliding drawer");
        }
        C0545c c0545c = (C0545c) view.getLayoutParams();
        if (this.f3247q) {
            c0545c.f3258b = 1.0f;
            c0545c.f3260d = 1;
            m3136c(view, true);
        } else if (z) {
            c0545c.f3260d |= 2;
            if (m3153a(view, 3)) {
                this.f3241k.m3112a(view, 0, view.getTop());
            } else {
                this.f3242l.m3112a(view, getWidth() - view.getWidth(), view.getTop());
            }
        } else {
            m3162c(view, 1.0f);
            m3148a(c0545c.f3257a, 0, view);
            view.setVisibility(0);
        }
        invalidate();
    }

    /* renamed from: OplusGLSurfaceView_13 */
    public void m3168i(View view) {
        m3158b(view, true);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m3158b(View view, boolean z) {
        if (!m3166g(view)) {
            throw new IllegalArgumentException("View " + view + " is not PlatformImplementations.kt_3 sliding drawer");
        }
        C0545c c0545c = (C0545c) view.getLayoutParams();
        if (this.f3247q) {
            c0545c.f3258b = 0.0f;
            c0545c.f3260d = 0;
        } else if (z) {
            c0545c.f3260d |= 4;
            if (m3153a(view, 3)) {
                this.f3241k.m3112a(view, -view.getWidth(), view.getTop());
            } else {
                this.f3242l.m3112a(view, getWidth(), view.getTop());
            }
        } else {
            m3162c(view, 0.0f);
            m3148a(c0545c.f3257a, 0, view);
            view.setVisibility(4);
        }
        invalidate();
    }

    /* renamed from: OplusGLSurfaceView_15 */
    public boolean m3169j(View view) {
        if (m3166g(view)) {
            return (((C0545c) view.getLayoutParams()).f3260d & 1) == 1;
        }
        throw new IllegalArgumentException("View " + view + " is not PlatformImplementations.kt_3 drawer");
    }

    /* renamed from: OplusGLSurfaceView_5 */
    public boolean m3170k(View view) {
        if (m3166g(view)) {
            return ((C0545c) view.getLayoutParams()).f3258b > 0.0f;
        }
        throw new IllegalArgumentException("View " + view + " is not PlatformImplementations.kt_3 drawer");
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    private boolean m3140g() {
        int childCount = getChildCount();
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < childCount; OplusGLSurfaceView_13++) {
            if (((C0545c) getChildAt(OplusGLSurfaceView_13).getLayoutParams()).f3259c) {
                return true;
            }
        }
        return false;
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new C0545c(-1, -1);
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof C0545c ? new C0545c((C0545c) layoutParams) : layoutParams instanceof ViewGroup.MarginLayoutParams ? new C0545c((ViewGroup.MarginLayoutParams) layoutParams) : new C0545c(layoutParams);
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof C0545c) && super.checkLayoutParams(layoutParams);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new C0545c(getContext(), attributeSet);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addFocusables(ArrayList<View> arrayList, int OplusGLSurfaceView_13, int i2) {
        if (getDescendantFocusability() == 393216) {
            return;
        }
        int childCount = getChildCount();
        boolean z = false;
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            if (m3166g(childAt)) {
                if (m3169j(childAt)) {
                    childAt.addFocusables(arrayList, OplusGLSurfaceView_13, i2);
                    z = true;
                }
            } else {
                this.f3232K.add(childAt);
            }
        }
        if (!z) {
            int size = this.f3232K.size();
            for (int i4 = 0; i4 < size; i4++) {
                View view = this.f3232K.get(i4);
                if (view.getVisibility() == 0) {
                    view.addFocusables(arrayList, OplusGLSurfaceView_13, i2);
                }
            }
        }
        this.f3232K.clear();
    }

    /* renamed from: COUIBaseListPopupWindow_10 */
    private boolean m3141h() {
        return m3160c() != null;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    View m3160c() {
        int childCount = getChildCount();
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < childCount; OplusGLSurfaceView_13++) {
            View childAt = getChildAt(OplusGLSurfaceView_13);
            if (m3166g(childAt) && m3170k(childAt)) {
                return childAt;
            }
        }
        return null;
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int OplusGLSurfaceView_13, KeyEvent keyEvent) {
        if (OplusGLSurfaceView_13 == 4 && m3141h()) {
            keyEvent.startTracking();
            return true;
        }
        return super.onKeyDown(OplusGLSurfaceView_13, keyEvent);
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyUp(int OplusGLSurfaceView_13, KeyEvent keyEvent) {
        if (OplusGLSurfaceView_13 == 4) {
            View viewM3160c = m3160c();
            if (viewM3160c != null && m3145a(viewM3160c) == 0) {
                m3155b();
            }
            return viewM3160c != null;
        }
        return super.onKeyUp(OplusGLSurfaceView_13, keyEvent);
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        View viewM3154b;
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        if (savedState.openDrawerGravity != 0 && (viewM3154b = m3154b(savedState.openDrawerGravity)) != null) {
            m3167h(viewM3154b);
        }
        if (savedState.lockModeLeft != 3) {
            m3147a(savedState.lockModeLeft, 3);
        }
        if (savedState.lockModeRight != 3) {
            m3147a(savedState.lockModeRight, 5);
        }
        if (savedState.lockModeStart != 3) {
            m3147a(savedState.lockModeStart, 8388611);
        }
        if (savedState.lockModeEnd != 3) {
            m3147a(savedState.lockModeEnd, 8388613);
        }
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        int childCount = getChildCount();
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < childCount; OplusGLSurfaceView_13++) {
            C0545c c0545c = (C0545c) getChildAt(OplusGLSurfaceView_13).getLayoutParams();
            boolean z = c0545c.f3260d == 1;
            boolean z2 = c0545c.f3260d == 2;
            if (z || z2) {
                savedState.openDrawerGravity = c0545c.f3257a;
                break;
            }
        }
        savedState.lockModeLeft = this.f3248r;
        savedState.lockModeRight = this.f3249s;
        savedState.lockModeStart = this.f3250t;
        savedState.lockModeEnd = this.f3251u;
        return savedState;
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int OplusGLSurfaceView_13, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, OplusGLSurfaceView_13, layoutParams);
        if (m3146a() != null || m3166g(view)) {
            ViewCompat.m2867b(view, 4);
        } else {
            ViewCompat.m2867b(view, 1);
        }
        if (f3219b) {
            return;
        }
        ViewCompat.m2854a(view, this.f3235e);
    }

    /* renamed from: OplusGLSurfaceView_14 */
    static boolean m3142l(View view) {
        return (ViewCompat.m2883f(view) == 4 || ViewCompat.m2883f(view) == 2) ? false : true;
    }

    protected static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() { // from class: androidx.drawerlayout.widget.DrawerLayout.SavedState.1
            @Override // android.os.Parcelable.ClassLoaderCreator
            /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int OplusGLSurfaceView_13) {
                return new SavedState[OplusGLSurfaceView_13];
            }
        };
        int lockModeEnd;
        int lockModeLeft;
        int lockModeRight;
        int lockModeStart;
        int openDrawerGravity;

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.openDrawerGravity = 0;
            this.openDrawerGravity = parcel.readInt();
            this.lockModeLeft = parcel.readInt();
            this.lockModeRight = parcel.readInt();
            this.lockModeStart = parcel.readInt();
            this.lockModeEnd = parcel.readInt();
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
            this.openDrawerGravity = 0;
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int OplusGLSurfaceView_13) {
            super.writeToParcel(parcel, OplusGLSurfaceView_13);
            parcel.writeInt(this.openDrawerGravity);
            parcel.writeInt(this.lockModeLeft);
            parcel.writeInt(this.lockModeRight);
            parcel.writeInt(this.lockModeStart);
            parcel.writeInt(this.lockModeEnd);
        }
    }

    /* renamed from: androidx.drawerlayout.widget.DrawerLayout$IntrinsicsJvm.kt_5 */
    private class C0546d extends ViewDragHelper.PlatformImplementations.kt_3 {

        /* renamed from: PlatformImplementations.kt_3 */
        final /* synthetic */ DrawerLayout f3261a;

        /* renamed from: IntrinsicsJvm.kt_4 */
        private final int f3262b;

        /* renamed from: IntrinsicsJvm.kt_3 */
        private ViewDragHelper f3263c;

        /* renamed from: IntrinsicsJvm.kt_5 */
        private final Runnable f3264d;

        @Override // androidx.customview.p039a.ViewDragHelper.PlatformImplementations.kt_3
        public boolean onEdgeLock(int OplusGLSurfaceView_13) {
            return false;
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public void m3179a() {
            this.f3261a.removeCallbacks(this.f3264d);
        }

        @Override // androidx.customview.p039a.ViewDragHelper.PlatformImplementations.kt_3
        public boolean tryCaptureView(View view, int OplusGLSurfaceView_13) {
            return this.f3261a.m3166g(view) && this.f3261a.m3153a(view, this.f3262b) && this.f3261a.m3145a(view) == 0;
        }

        @Override // androidx.customview.p039a.ViewDragHelper.PlatformImplementations.kt_3
        public void onViewDragStateChanged(int OplusGLSurfaceView_13) {
            this.f3261a.m3148a(this.f3262b, OplusGLSurfaceView_13, this.f3263c.m3120c());
        }

        @Override // androidx.customview.p039a.ViewDragHelper.PlatformImplementations.kt_3
        public void onViewPositionChanged(View view, int OplusGLSurfaceView_13, int i2, int i3, int i4) {
            float width = (this.f3261a.m3153a(view, 3) ? OplusGLSurfaceView_13 + r3 : this.f3261a.getWidth() - OplusGLSurfaceView_13) / view.getWidth();
            this.f3261a.m3157b(view, width);
            view.setVisibility(width == 0.0f ? 4 : 0);
            this.f3261a.invalidate();
        }

        @Override // androidx.customview.p039a.ViewDragHelper.PlatformImplementations.kt_3
        public void onViewCaptured(View view, int OplusGLSurfaceView_13) {
            ((C0545c) view.getLayoutParams()).f3259c = false;
            m3178b();
        }

        /* renamed from: IntrinsicsJvm.kt_4 */
        private void m3178b() {
            View viewM3154b = this.f3261a.m3154b(this.f3262b == 3 ? 5 : 3);
            if (viewM3154b != null) {
                this.f3261a.m3168i(viewM3154b);
            }
        }

        @Override // androidx.customview.p039a.ViewDragHelper.PlatformImplementations.kt_3
        public void onViewReleased(View view, float COUIBaseListPopupWindow_12, float f2) {
            int OplusGLSurfaceView_13;
            float fM3163d = this.f3261a.m3163d(view);
            int width = view.getWidth();
            if (this.f3261a.m3153a(view, 3)) {
                OplusGLSurfaceView_13 = (COUIBaseListPopupWindow_12 > 0.0f || (COUIBaseListPopupWindow_12 == 0.0f && fM3163d > 0.5f)) ? 0 : -width;
            } else {
                int width2 = this.f3261a.getWidth();
                if (COUIBaseListPopupWindow_12 < 0.0f || (COUIBaseListPopupWindow_12 == 0.0f && fM3163d > 0.5f)) {
                    width2 -= width;
                }
                OplusGLSurfaceView_13 = width2;
            }
            this.f3263c.m3110a(OplusGLSurfaceView_13, view.getTop());
            this.f3261a.invalidate();
        }

        @Override // androidx.customview.p039a.ViewDragHelper.PlatformImplementations.kt_3
        public void onEdgeTouched(int OplusGLSurfaceView_13, int i2) {
            this.f3261a.postDelayed(this.f3264d, 160L);
        }

        @Override // androidx.customview.p039a.ViewDragHelper.PlatformImplementations.kt_3
        public void onEdgeDragStarted(int OplusGLSurfaceView_13, int i2) {
            View viewM3154b;
            if ((OplusGLSurfaceView_13 & 1) == 1) {
                viewM3154b = this.f3261a.m3154b(3);
            } else {
                viewM3154b = this.f3261a.m3154b(5);
            }
            if (viewM3154b == null || this.f3261a.m3145a(viewM3154b) != 0) {
                return;
            }
            this.f3263c.m3109a(viewM3154b, i2);
        }

        @Override // androidx.customview.p039a.ViewDragHelper.PlatformImplementations.kt_3
        public int getViewHorizontalDragRange(View view) {
            if (this.f3261a.m3166g(view)) {
                return view.getWidth();
            }
            return 0;
        }

        @Override // androidx.customview.p039a.ViewDragHelper.PlatformImplementations.kt_3
        public int clampViewPositionHorizontal(View view, int OplusGLSurfaceView_13, int i2) {
            if (this.f3261a.m3153a(view, 3)) {
                return Math.max(-view.getWidth(), Math.min(OplusGLSurfaceView_13, 0));
            }
            int width = this.f3261a.getWidth();
            return Math.max(width - view.getWidth(), Math.min(OplusGLSurfaceView_13, width));
        }

        @Override // androidx.customview.p039a.ViewDragHelper.PlatformImplementations.kt_3
        public int clampViewPositionVertical(View view, int OplusGLSurfaceView_13, int i2) {
            return view.getTop();
        }
    }

    /* renamed from: androidx.drawerlayout.widget.DrawerLayout$IntrinsicsJvm.kt_3 */
    public static class C0545c extends ViewGroup.MarginLayoutParams {

        /* renamed from: PlatformImplementations.kt_3 */
        public int f3257a;

        /* renamed from: IntrinsicsJvm.kt_4 */
        float f3258b;

        /* renamed from: IntrinsicsJvm.kt_3 */
        boolean f3259c;

        /* renamed from: IntrinsicsJvm.kt_5 */
        int f3260d;

        public C0545c(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f3257a = 0;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, DrawerLayout.f3218a);
            this.f3257a = typedArrayObtainStyledAttributes.getInt(0, 0);
            typedArrayObtainStyledAttributes.recycle();
        }

        public C0545c(int OplusGLSurfaceView_13, int i2) {
            super(OplusGLSurfaceView_13, i2);
            this.f3257a = 0;
        }

        public C0545c(C0545c c0545c) {
            super((ViewGroup.MarginLayoutParams) c0545c);
            this.f3257a = 0;
            this.f3257a = c0545c.f3257a;
        }

        public C0545c(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f3257a = 0;
        }

        public C0545c(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f3257a = 0;
        }
    }

    /* renamed from: androidx.drawerlayout.widget.DrawerLayout$PlatformImplementations.kt_3 */
    static final class C0543a extends AccessibilityDelegateCompat {
        @Override // androidx.core.p036h.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat c0483d) {
            super.onInitializeAccessibilityNodeInfo(view, c0483d);
            if (DrawerLayout.m3142l(view)) {
                return;
            }
            c0483d.m2688b((View) null);
        }
    }
}

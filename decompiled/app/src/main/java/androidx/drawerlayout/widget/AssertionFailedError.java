package androidx.drawerlayout.widget;

/* loaded from: classes.dex */
public class DrawerLayout extends android.view.ViewGroup {

    /* renamed from: b_renamed, reason: collision with root package name */
    static final boolean f1050b;
    private static final boolean d_renamed;
    private float A_renamed;
    private android.graphics.drawable.Drawable B_renamed;
    private android.graphics.drawable.Drawable C_renamed;
    private android.graphics.drawable.Drawable D_renamed;
    private java.lang.Object E_renamed;
    private boolean F_renamed;
    private android.graphics.drawable.Drawable G_renamed;
    private android.graphics.drawable.Drawable H_renamed;
    private android.graphics.drawable.Drawable I_renamed;
    private android.graphics.drawable.Drawable J_renamed;
    private final java.util.ArrayList<android.view.View> K_renamed;
    private android.graphics.Rect L_renamed;
    private android.graphics.Matrix M_renamed;
    private final androidx.drawerlayout.widget.DrawerLayout.a_renamed e_renamed;
    private float f_renamed;
    private int g_renamed;
    private int h_renamed;
    private float i_renamed;
    private android.graphics.Paint j_renamed;
    private final androidx.customview.a_renamed.c_renamed k_renamed;
    private final androidx.customview.a_renamed.c_renamed l_renamed;
    private final androidx.drawerlayout.widget.DrawerLayout.d_renamed m_renamed;
    private final androidx.drawerlayout.widget.DrawerLayout.d_renamed n_renamed;
    private int o_renamed;
    private boolean p_renamed;
    private boolean q_renamed;
    private int r_renamed;
    private int s_renamed;
    private int t_renamed;
    private int u_renamed;
    private boolean v_renamed;
    private boolean w_renamed;
    private androidx.drawerlayout.widget.DrawerLayout.b_renamed x_renamed;
    private java.util.List<androidx.drawerlayout.widget.DrawerLayout.b_renamed> y_renamed;
    private float z_renamed;

    /* renamed from: c_renamed, reason: collision with root package name */
    private static final int[] f1051c = {android.R_renamed.attr.colorPrimaryDark};

    /* renamed from: a_renamed, reason: collision with root package name */
    static final int[] f1049a = {android.R_renamed.attr.layout_gravity};

    public interface b_renamed {
        void a_renamed(int i_renamed);

        void a_renamed(android.view.View view);

        void a_renamed(android.view.View view, float f_renamed);

        void b_renamed(android.view.View view);
    }

    static {
        f1050b = android.os.Build.VERSION.SDK_INT >= 19;
        d_renamed = android.os.Build.VERSION.SDK_INT >= 21;
    }

    public void setDrawerElevation(float f_renamed) {
        this.f_renamed = f_renamed;
        for (int i_renamed = 0; i_renamed < getChildCount(); i_renamed++) {
            android.view.View childAt = getChildAt(i_renamed);
            if (g_renamed(childAt)) {
                androidx.core.h_renamed.v_renamed.a_renamed(childAt, this.f_renamed);
            }
        }
    }

    public float getDrawerElevation() {
        if (d_renamed) {
            return this.f_renamed;
        }
        return 0.0f;
    }

    public void setScrimColor(int i_renamed) {
        this.h_renamed = i_renamed;
        invalidate();
    }

    @java.lang.Deprecated
    public void setDrawerListener(androidx.drawerlayout.widget.DrawerLayout.b_renamed bVar) {
        androidx.drawerlayout.widget.DrawerLayout.b_renamed bVar2 = this.x_renamed;
        if (bVar2 != null) {
            b_renamed(bVar2);
        }
        if (bVar != null) {
            a_renamed(bVar);
        }
        this.x_renamed = bVar;
    }

    public void a_renamed(androidx.drawerlayout.widget.DrawerLayout.b_renamed bVar) {
        if (bVar == null) {
            return;
        }
        if (this.y_renamed == null) {
            this.y_renamed = new java.util.ArrayList();
        }
        this.y_renamed.add(bVar);
    }

    public void b_renamed(androidx.drawerlayout.widget.DrawerLayout.b_renamed bVar) {
        java.util.List<androidx.drawerlayout.widget.DrawerLayout.b_renamed> list;
        if (bVar == null || (list = this.y_renamed) == null) {
            return;
        }
        list.remove(bVar);
    }

    public void setDrawerLockMode(int i_renamed) {
        a_renamed(i_renamed, 3);
        a_renamed(i_renamed, 5);
    }

    public void a_renamed(int i_renamed, int i2) {
        android.view.View viewB;
        int iA = androidx.core.h_renamed.c_renamed.a_renamed(i2, androidx.core.h_renamed.v_renamed.g_renamed(this));
        if (i2 == 3) {
            this.r_renamed = i_renamed;
        } else if (i2 == 5) {
            this.s_renamed = i_renamed;
        } else if (i2 == 8388611) {
            this.t_renamed = i_renamed;
        } else if (i2 == 8388613) {
            this.u_renamed = i_renamed;
        }
        if (i_renamed != 0) {
            (iA == 3 ? this.k_renamed : this.l_renamed).e_renamed();
        }
        if (i_renamed != 1) {
            if (i_renamed == 2 && (viewB = b_renamed(iA)) != null) {
                h_renamed(viewB);
                return;
            }
            return;
        }
        android.view.View viewB2 = b_renamed(iA);
        if (viewB2 != null) {
            i_renamed(viewB2);
        }
    }

    public int a_renamed(int i_renamed) {
        int iG = androidx.core.h_renamed.v_renamed.g_renamed(this);
        if (i_renamed == 3) {
            int i2 = this.r_renamed;
            if (i2 != 3) {
                return i2;
            }
            int i3 = iG == 0 ? this.t_renamed : this.u_renamed;
            if (i3 != 3) {
                return i3;
            }
            return 0;
        }
        if (i_renamed == 5) {
            int i4 = this.s_renamed;
            if (i4 != 3) {
                return i4;
            }
            int i5 = iG == 0 ? this.u_renamed : this.t_renamed;
            if (i5 != 3) {
                return i5;
            }
            return 0;
        }
        if (i_renamed == 8388611) {
            int i6 = this.t_renamed;
            if (i6 != 3) {
                return i6;
            }
            int i7 = iG == 0 ? this.r_renamed : this.s_renamed;
            if (i7 != 3) {
                return i7;
            }
            return 0;
        }
        if (i_renamed != 8388613) {
            return 0;
        }
        int i8 = this.u_renamed;
        if (i8 != 3) {
            return i8;
        }
        int i9 = iG == 0 ? this.s_renamed : this.r_renamed;
        if (i9 != 3) {
            return i9;
        }
        return 0;
    }

    public int a_renamed(android.view.View view) {
        if (!g_renamed(view)) {
            throw new java.lang.IllegalArgumentException("View " + view + " is_renamed not a_renamed drawer");
        }
        return a_renamed(((androidx.drawerlayout.widget.DrawerLayout.c_renamed) view.getLayoutParams()).f1052a);
    }

    private boolean a_renamed(float f_renamed, float f2, android.view.View view) {
        if (this.L_renamed == null) {
            this.L_renamed = new android.graphics.Rect();
        }
        view.getHitRect(this.L_renamed);
        return this.L_renamed.contains((int) f_renamed, (int) f2);
    }

    private boolean a_renamed(android.view.MotionEvent motionEvent, android.view.View view) {
        if (!view.getMatrix().isIdentity()) {
            android.view.MotionEvent motionEventB = b_renamed(motionEvent, view);
            boolean zDispatchGenericMotionEvent = view.dispatchGenericMotionEvent(motionEventB);
            motionEventB.recycle();
            return zDispatchGenericMotionEvent;
        }
        float scrollX = getScrollX() - view.getLeft();
        float scrollY = getScrollY() - view.getTop();
        motionEvent.offsetLocation(scrollX, scrollY);
        boolean zDispatchGenericMotionEvent2 = view.dispatchGenericMotionEvent(motionEvent);
        motionEvent.offsetLocation(-scrollX, -scrollY);
        return zDispatchGenericMotionEvent2;
    }

    private android.view.MotionEvent b_renamed(android.view.MotionEvent motionEvent, android.view.View view) {
        float scrollX = getScrollX() - view.getLeft();
        float scrollY = getScrollY() - view.getTop();
        android.view.MotionEvent motionEventObtain = android.view.MotionEvent.obtain(motionEvent);
        motionEventObtain.offsetLocation(scrollX, scrollY);
        android.graphics.Matrix matrix = view.getMatrix();
        if (!matrix.isIdentity()) {
            if (this.M_renamed == null) {
                this.M_renamed = new android.graphics.Matrix();
            }
            matrix.invert(this.M_renamed);
            motionEventObtain.transform(this.M_renamed);
        }
        return motionEventObtain;
    }

    void a_renamed(int i_renamed, int i2, android.view.View view) {
        int iA = this.k_renamed.a_renamed();
        int iA2 = this.l_renamed.a_renamed();
        int i3 = 2;
        if (iA == 1 || iA2 == 1) {
            i3 = 1;
        } else if (iA != 2 && iA2 != 2) {
            i3 = 0;
        }
        if (view != null && i2 == 0) {
            androidx.drawerlayout.widget.DrawerLayout.c_renamed cVar = (androidx.drawerlayout.widget.DrawerLayout.c_renamed) view.getLayoutParams();
            if (cVar.f1053b == 0.0f) {
                b_renamed(view);
            } else if (cVar.f1053b == 1.0f) {
                c_renamed(view);
            }
        }
        if (i3 != this.o_renamed) {
            this.o_renamed = i3;
            java.util.List<androidx.drawerlayout.widget.DrawerLayout.b_renamed> list = this.y_renamed;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    this.y_renamed.get(size).a_renamed(i3);
                }
            }
        }
    }

    void b_renamed(android.view.View view) {
        android.view.View rootView;
        androidx.drawerlayout.widget.DrawerLayout.c_renamed cVar = (androidx.drawerlayout.widget.DrawerLayout.c_renamed) view.getLayoutParams();
        if ((cVar.d_renamed & 1) == 1) {
            cVar.d_renamed = 0;
            java.util.List<androidx.drawerlayout.widget.DrawerLayout.b_renamed> list = this.y_renamed;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    this.y_renamed.get(size).b_renamed(view);
                }
            }
            c_renamed(view, false);
            if (!hasWindowFocus() || (rootView = getRootView()) == null) {
                return;
            }
            rootView.sendAccessibilityEvent(32);
        }
    }

    void c_renamed(android.view.View view) {
        androidx.drawerlayout.widget.DrawerLayout.c_renamed cVar = (androidx.drawerlayout.widget.DrawerLayout.c_renamed) view.getLayoutParams();
        if ((cVar.d_renamed & 1) == 0) {
            cVar.d_renamed = 1;
            java.util.List<androidx.drawerlayout.widget.DrawerLayout.b_renamed> list = this.y_renamed;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    this.y_renamed.get(size).a_renamed(view);
                }
            }
            c_renamed(view, true);
            if (hasWindowFocus()) {
                sendAccessibilityEvent(32);
            }
        }
    }

    private void c_renamed(android.view.View view, boolean z_renamed) {
        int childCount = getChildCount();
        for (int i_renamed = 0; i_renamed < childCount; i_renamed++) {
            android.view.View childAt = getChildAt(i_renamed);
            if ((!z_renamed && !g_renamed(childAt)) || (z_renamed && childAt == view)) {
                androidx.core.h_renamed.v_renamed.b_renamed(childAt, 1);
            } else {
                androidx.core.h_renamed.v_renamed.b_renamed(childAt, 4);
            }
        }
    }

    void a_renamed(android.view.View view, float f_renamed) {
        java.util.List<androidx.drawerlayout.widget.DrawerLayout.b_renamed> list = this.y_renamed;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.y_renamed.get(size).a_renamed(view, f_renamed);
            }
        }
    }

    void b_renamed(android.view.View view, float f_renamed) {
        androidx.drawerlayout.widget.DrawerLayout.c_renamed cVar = (androidx.drawerlayout.widget.DrawerLayout.c_renamed) view.getLayoutParams();
        if (f_renamed == cVar.f1053b) {
            return;
        }
        cVar.f1053b = f_renamed;
        a_renamed(view, f_renamed);
    }

    float d_renamed(android.view.View view) {
        return ((androidx.drawerlayout.widget.DrawerLayout.c_renamed) view.getLayoutParams()).f1053b;
    }

    int e_renamed(android.view.View view) {
        return androidx.core.h_renamed.c_renamed.a_renamed(((androidx.drawerlayout.widget.DrawerLayout.c_renamed) view.getLayoutParams()).f1052a, androidx.core.h_renamed.v_renamed.g_renamed(this));
    }

    boolean a_renamed(android.view.View view, int i_renamed) {
        return (e_renamed(view) & i_renamed) == i_renamed;
    }

    android.view.View a_renamed() {
        int childCount = getChildCount();
        for (int i_renamed = 0; i_renamed < childCount; i_renamed++) {
            android.view.View childAt = getChildAt(i_renamed);
            if ((((androidx.drawerlayout.widget.DrawerLayout.c_renamed) childAt.getLayoutParams()).d_renamed & 1) == 1) {
                return childAt;
            }
        }
        return null;
    }

    void c_renamed(android.view.View view, float f_renamed) {
        float fD_renamed = d_renamed(view);
        float width = view.getWidth();
        int i_renamed = ((int) (width * f_renamed)) - ((int) (fD_renamed * width));
        if (!a_renamed(view, 3)) {
            i_renamed = -i_renamed;
        }
        view.offsetLeftAndRight(i_renamed);
        b_renamed(view, f_renamed);
    }

    android.view.View b_renamed(int i_renamed) {
        int iA = androidx.core.h_renamed.c_renamed.a_renamed(i_renamed, androidx.core.h_renamed.v_renamed.g_renamed(this)) & 7;
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            android.view.View childAt = getChildAt(i2);
            if ((e_renamed(childAt) & 7) == iA) {
                return childAt;
            }
        }
        return null;
    }

    static java.lang.String c_renamed(int i_renamed) {
        return (i_renamed & 3) == 3 ? "LEFT" : (i_renamed & 5) == 5 ? "RIGHT" : java.lang.Integer.toHexString(i_renamed);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.q_renamed = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.q_renamed = true;
    }

    @Override // android.view.View
    @android.annotation.SuppressLint({"WrongConstant"})
    protected void onMeasure(int i_renamed, int i2) {
        int mode = android.view.View.MeasureSpec.getMode(i_renamed);
        int mode2 = android.view.View.MeasureSpec.getMode(i2);
        int size = android.view.View.MeasureSpec.getSize(i_renamed);
        int size2 = android.view.View.MeasureSpec.getSize(i2);
        if (mode != 1073741824 || mode2 != 1073741824) {
            if (!isInEditMode()) {
                throw new java.lang.IllegalArgumentException("DrawerLayout must be_renamed measured with MeasureSpec.EXACTLY.");
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
        boolean z_renamed = this.E_renamed != null && androidx.core.h_renamed.v_renamed.t_renamed(this);
        int iG = androidx.core.h_renamed.v_renamed.g_renamed(this);
        int childCount = getChildCount();
        int i4 = 0;
        boolean z2 = false;
        boolean z3 = false;
        while (i4 < childCount) {
            android.view.View childAt = getChildAt(i4);
            if (childAt.getVisibility() != 8) {
                androidx.drawerlayout.widget.DrawerLayout.c_renamed cVar = (androidx.drawerlayout.widget.DrawerLayout.c_renamed) childAt.getLayoutParams();
                if (z_renamed) {
                    int iA = androidx.core.h_renamed.c_renamed.a_renamed(cVar.f1052a, iG);
                    if (androidx.core.h_renamed.v_renamed.t_renamed(childAt)) {
                        if (android.os.Build.VERSION.SDK_INT >= 21) {
                            android.view.WindowInsets windowInsetsReplaceSystemWindowInsets = (android.view.WindowInsets) this.E_renamed;
                            if (iA == 3) {
                                windowInsetsReplaceSystemWindowInsets = windowInsetsReplaceSystemWindowInsets.replaceSystemWindowInsets(windowInsetsReplaceSystemWindowInsets.getSystemWindowInsetLeft(), windowInsetsReplaceSystemWindowInsets.getSystemWindowInsetTop(), i3, windowInsetsReplaceSystemWindowInsets.getSystemWindowInsetBottom());
                            } else if (iA == 5) {
                                windowInsetsReplaceSystemWindowInsets = windowInsetsReplaceSystemWindowInsets.replaceSystemWindowInsets(i3, windowInsetsReplaceSystemWindowInsets.getSystemWindowInsetTop(), windowInsetsReplaceSystemWindowInsets.getSystemWindowInsetRight(), windowInsetsReplaceSystemWindowInsets.getSystemWindowInsetBottom());
                            }
                            childAt.dispatchApplyWindowInsets(windowInsetsReplaceSystemWindowInsets);
                        }
                    } else if (android.os.Build.VERSION.SDK_INT >= 21) {
                        android.view.WindowInsets windowInsetsReplaceSystemWindowInsets2 = (android.view.WindowInsets) this.E_renamed;
                        if (iA == 3) {
                            windowInsetsReplaceSystemWindowInsets2 = windowInsetsReplaceSystemWindowInsets2.replaceSystemWindowInsets(windowInsetsReplaceSystemWindowInsets2.getSystemWindowInsetLeft(), windowInsetsReplaceSystemWindowInsets2.getSystemWindowInsetTop(), i3, windowInsetsReplaceSystemWindowInsets2.getSystemWindowInsetBottom());
                        } else if (iA == 5) {
                            windowInsetsReplaceSystemWindowInsets2 = windowInsetsReplaceSystemWindowInsets2.replaceSystemWindowInsets(i3, windowInsetsReplaceSystemWindowInsets2.getSystemWindowInsetTop(), windowInsetsReplaceSystemWindowInsets2.getSystemWindowInsetRight(), windowInsetsReplaceSystemWindowInsets2.getSystemWindowInsetBottom());
                        }
                        cVar.leftMargin = windowInsetsReplaceSystemWindowInsets2.getSystemWindowInsetLeft();
                        cVar.topMargin = windowInsetsReplaceSystemWindowInsets2.getSystemWindowInsetTop();
                        cVar.rightMargin = windowInsetsReplaceSystemWindowInsets2.getSystemWindowInsetRight();
                        cVar.bottomMargin = windowInsetsReplaceSystemWindowInsets2.getSystemWindowInsetBottom();
                    }
                }
                if (f_renamed(childAt)) {
                    childAt.measure(android.view.View.MeasureSpec.makeMeasureSpec((size - cVar.leftMargin) - cVar.rightMargin, 1073741824), android.view.View.MeasureSpec.makeMeasureSpec((size2 - cVar.topMargin) - cVar.bottomMargin, 1073741824));
                } else if (g_renamed(childAt)) {
                    if (d_renamed) {
                        float fO_renamed = androidx.core.h_renamed.v_renamed.o_renamed(childAt);
                        float f_renamed = this.f_renamed;
                        if (fO_renamed != f_renamed) {
                            androidx.core.h_renamed.v_renamed.a_renamed(childAt, f_renamed);
                        }
                    }
                    int iE = e_renamed(childAt) & 7;
                    int i5 = iE == 3 ? 1 : i3;
                    if ((i5 != 0 && z2) || (i5 == 0 && z3)) {
                        throw new java.lang.IllegalStateException("Child drawer has absolute gravity " + c_renamed(iE) + " but this DrawerLayout already has a_renamed drawer view along that edge");
                    }
                    if (i5 != 0) {
                        z2 = true;
                    } else {
                        z3 = true;
                    }
                    childAt.measure(getChildMeasureSpec(i_renamed, this.g_renamed + cVar.leftMargin + cVar.rightMargin, cVar.width), getChildMeasureSpec(i2, cVar.topMargin + cVar.bottomMargin, cVar.height));
                } else {
                    throw new java.lang.IllegalStateException("Child " + childAt + " at_renamed index " + i4 + " does not have a_renamed valid layout_gravity - must be_renamed Gravity.LEFT, Gravity.RIGHT or Gravity.NO_GRAVITY");
                }
            }
            i4++;
            i3 = 0;
        }
    }

    private void d_renamed() {
        if (d_renamed) {
            return;
        }
        this.C_renamed = e_renamed();
        this.D_renamed = f_renamed();
    }

    private android.graphics.drawable.Drawable e_renamed() throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        int iG = androidx.core.h_renamed.v_renamed.g_renamed(this);
        if (iG == 0) {
            android.graphics.drawable.Drawable drawable = this.G_renamed;
            if (drawable != null) {
                a_renamed(drawable, iG);
                return this.G_renamed;
            }
        } else {
            android.graphics.drawable.Drawable drawable2 = this.H_renamed;
            if (drawable2 != null) {
                a_renamed(drawable2, iG);
                return this.H_renamed;
            }
        }
        return this.I_renamed;
    }

    private android.graphics.drawable.Drawable f_renamed() throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        int iG = androidx.core.h_renamed.v_renamed.g_renamed(this);
        if (iG == 0) {
            android.graphics.drawable.Drawable drawable = this.H_renamed;
            if (drawable != null) {
                a_renamed(drawable, iG);
                return this.H_renamed;
            }
        } else {
            android.graphics.drawable.Drawable drawable2 = this.G_renamed;
            if (drawable2 != null) {
                a_renamed(drawable2, iG);
                return this.G_renamed;
            }
        }
        return this.J_renamed;
    }

    private boolean a_renamed(android.graphics.drawable.Drawable drawable, int i_renamed) throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        if (drawable == null || !androidx.core.graphics.drawable.a_renamed.b_renamed(drawable)) {
            return false;
        }
        androidx.core.graphics.drawable.a_renamed.b_renamed(drawable, i_renamed);
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z_renamed, int i_renamed, int i2, int i3, int i4) {
        float f_renamed;
        int i5;
        boolean z2 = true;
        this.p_renamed = true;
        int i6 = i3 - i_renamed;
        int childCount = getChildCount();
        int i7 = 0;
        while (i7 < childCount) {
            android.view.View childAt = getChildAt(i7);
            if (childAt.getVisibility() != 8) {
                androidx.drawerlayout.widget.DrawerLayout.c_renamed cVar = (androidx.drawerlayout.widget.DrawerLayout.c_renamed) childAt.getLayoutParams();
                if (f_renamed(childAt)) {
                    childAt.layout(cVar.leftMargin, cVar.topMargin, cVar.leftMargin + childAt.getMeasuredWidth(), cVar.topMargin + childAt.getMeasuredHeight());
                } else {
                    int measuredWidth = childAt.getMeasuredWidth();
                    int measuredHeight = childAt.getMeasuredHeight();
                    if (a_renamed(childAt, 3)) {
                        float f2 = measuredWidth;
                        i5 = (-measuredWidth) + ((int) (cVar.f1053b * f2));
                        f_renamed = (measuredWidth + i5) / f2;
                    } else {
                        float f3 = measuredWidth;
                        f_renamed = (i6 - r11) / f3;
                        i5 = i6 - ((int) (cVar.f1053b * f3));
                    }
                    boolean z3 = f_renamed != cVar.f1053b ? z2 : false;
                    int i8 = cVar.f1052a & 112;
                    if (i8 == 16) {
                        int i9 = i4 - i2;
                        int i10 = (i9 - measuredHeight) / 2;
                        if (i10 < cVar.topMargin) {
                            i10 = cVar.topMargin;
                        } else if (i10 + measuredHeight > i9 - cVar.bottomMargin) {
                            i10 = (i9 - cVar.bottomMargin) - measuredHeight;
                        }
                        childAt.layout(i5, i10, measuredWidth + i5, measuredHeight + i10);
                    } else if (i8 != 80) {
                        childAt.layout(i5, cVar.topMargin, measuredWidth + i5, cVar.topMargin + measuredHeight);
                    } else {
                        int i11 = i4 - i2;
                        childAt.layout(i5, (i11 - cVar.bottomMargin) - childAt.getMeasuredHeight(), measuredWidth + i5, i11 - cVar.bottomMargin);
                    }
                    if (z3) {
                        b_renamed(childAt, f_renamed);
                    }
                    int i12 = cVar.f1053b > 0.0f ? 0 : 4;
                    if (childAt.getVisibility() != i12) {
                        childAt.setVisibility(i12);
                    }
                }
            }
            i7++;
            z2 = true;
        }
        this.p_renamed = false;
        this.q_renamed = false;
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (this.p_renamed) {
            return;
        }
        super.requestLayout();
    }

    @Override // android.view.View
    public void computeScroll() {
        int childCount = getChildCount();
        float fMax = 0.0f;
        for (int i_renamed = 0; i_renamed < childCount; i_renamed++) {
            fMax = java.lang.Math.max(fMax, ((androidx.drawerlayout.widget.DrawerLayout.c_renamed) getChildAt(i_renamed).getLayoutParams()).f1053b);
        }
        this.i_renamed = fMax;
        boolean zA = this.k_renamed.a_renamed(true);
        boolean zA2 = this.l_renamed.a_renamed(true);
        if (zA || zA2) {
            androidx.core.h_renamed.v_renamed.e_renamed(this);
        }
    }

    private static boolean m_renamed(android.view.View view) {
        android.graphics.drawable.Drawable background = view.getBackground();
        return background != null && background.getOpacity() == -1;
    }

    public void setStatusBarBackground(android.graphics.drawable.Drawable drawable) {
        this.B_renamed = drawable;
        invalidate();
    }

    public android.graphics.drawable.Drawable getStatusBarBackgroundDrawable() {
        return this.B_renamed;
    }

    public void setStatusBarBackground(int i_renamed) {
        this.B_renamed = i_renamed != 0 ? androidx.core.a_renamed.a_renamed.a_renamed(getContext(), i_renamed) : null;
        invalidate();
    }

    public void setStatusBarBackgroundColor(int i_renamed) {
        this.B_renamed = new android.graphics.drawable.ColorDrawable(i_renamed);
        invalidate();
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int i_renamed) {
        d_renamed();
    }

    @Override // android.view.View
    public void onDraw(android.graphics.Canvas canvas) {
        java.lang.Object obj;
        super.onDraw(canvas);
        if (!this.F_renamed || this.B_renamed == null) {
            return;
        }
        int systemWindowInsetTop = (android.os.Build.VERSION.SDK_INT < 21 || (obj = this.E_renamed) == null) ? 0 : ((android.view.WindowInsets) obj).getSystemWindowInsetTop();
        if (systemWindowInsetTop > 0) {
            this.B_renamed.setBounds(0, 0, getWidth(), systemWindowInsetTop);
            this.B_renamed.draw(canvas);
        }
    }

    @Override // android.view.ViewGroup
    protected boolean drawChild(android.graphics.Canvas canvas, android.view.View view, long j_renamed) {
        int i_renamed;
        int height = getHeight();
        boolean zF = f_renamed(view);
        int width = getWidth();
        int iSave = canvas.save();
        int i2 = 0;
        if (zF) {
            int childCount = getChildCount();
            i_renamed = width;
            int i3 = 0;
            for (int i4 = 0; i4 < childCount; i4++) {
                android.view.View childAt = getChildAt(i4);
                if (childAt != view && childAt.getVisibility() == 0 && m_renamed(childAt) && g_renamed(childAt) && childAt.getHeight() >= height) {
                    if (a_renamed(childAt, 3)) {
                        int right = childAt.getRight();
                        if (right > i3) {
                            i3 = right;
                        }
                    } else {
                        int left = childAt.getLeft();
                        if (left < i_renamed) {
                            i_renamed = left;
                        }
                    }
                }
            }
            canvas.clipRect(i3, 0, i_renamed, getHeight());
            i2 = i3;
        } else {
            i_renamed = width;
        }
        boolean zDrawChild = super.drawChild(canvas, view, j_renamed);
        canvas.restoreToCount(iSave);
        float f_renamed = this.i_renamed;
        if (f_renamed > 0.0f && zF) {
            this.j_renamed.setColor((this.h_renamed & 16777215) | (((int) ((((-16777216) & r2) >>> 24) * f_renamed)) << 24));
            canvas.drawRect(i2, 0.0f, i_renamed, getHeight(), this.j_renamed);
        } else if (this.C_renamed != null && a_renamed(view, 3)) {
            int intrinsicWidth = this.C_renamed.getIntrinsicWidth();
            int right2 = view.getRight();
            float fMax = java.lang.Math.max(0.0f, java.lang.Math.min(right2 / this.k_renamed.b_renamed(), 1.0f));
            this.C_renamed.setBounds(right2, view.getTop(), intrinsicWidth + right2, view.getBottom());
            this.C_renamed.setAlpha((int) (fMax * 255.0f));
            this.C_renamed.draw(canvas);
        } else if (this.D_renamed != null && a_renamed(view, 5)) {
            int intrinsicWidth2 = this.D_renamed.getIntrinsicWidth();
            int left2 = view.getLeft();
            float fMax2 = java.lang.Math.max(0.0f, java.lang.Math.min((getWidth() - left2) / this.l_renamed.b_renamed(), 1.0f));
            this.D_renamed.setBounds(left2 - intrinsicWidth2, view.getTop(), left2, view.getBottom());
            this.D_renamed.setAlpha((int) (fMax2 * 255.0f));
            this.D_renamed.draw(canvas);
        }
        return zDrawChild;
    }

    boolean f_renamed(android.view.View view) {
        return ((androidx.drawerlayout.widget.DrawerLayout.c_renamed) view.getLayoutParams()).f1052a == 0;
    }

    boolean g_renamed(android.view.View view) {
        int iA = androidx.core.h_renamed.c_renamed.a_renamed(((androidx.drawerlayout.widget.DrawerLayout.c_renamed) view.getLayoutParams()).f1052a, androidx.core.h_renamed.v_renamed.g_renamed(view));
        return ((iA & 3) == 0 && (iA & 5) == 0) ? false : true;
    }

    /* JADX WARN: Removed duplicated region for block: B_renamed:12:0x0031  */
    @Override // android.view.ViewGroup
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onInterceptTouchEvent(android.view.MotionEvent r7) {
        /*
            r6 = this;
            int r0 = r7.getActionMasked()
            androidx.customview.a_renamed.c_renamed r1 = r6.k_renamed
            boolean r1 = r1.a_renamed(r7)
            androidx.customview.a_renamed.c_renamed r2 = r6.l_renamed
            boolean r2 = r2.a_renamed(r7)
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
            androidx.customview.a_renamed.c_renamed r7 = r6.k_renamed
            boolean r7 = r7.d_renamed(r4)
            if (r7 == 0) goto L38
            androidx.drawerlayout.widget.DrawerLayout$d_renamed r7 = r6.m_renamed
            r7.a_renamed()
            androidx.drawerlayout.widget.DrawerLayout$d_renamed r7 = r6.n_renamed
            r7.a_renamed()
            goto L38
        L31:
            r6.a_renamed(r2)
            r6.v_renamed = r3
            r6.w_renamed = r3
        L38:
            r7 = r3
            goto L64
        L3a:
            float r0 = r7.getX()
            float r7 = r7.getY()
            r6.z_renamed = r0
            r6.A_renamed = r7
            float r4 = r6.i_renamed
            r5 = 0
            int r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r4 <= 0) goto L5f
            androidx.customview.a_renamed.c_renamed r4 = r6.k_renamed
            int r0 = (int) r0
            int r7 = (int) r7
            android.view.View r7 = r4.d_renamed(r0, r7)
            if (r7 == 0) goto L5f
            boolean r7 = r6.f_renamed(r7)
            if (r7 == 0) goto L5f
            r7 = r2
            goto L60
        L5f:
            r7 = r3
        L60:
            r6.v_renamed = r3
            r6.w_renamed = r3
        L64:
            if (r1 != 0) goto L74
            if (r7 != 0) goto L74
            boolean r7 = r6.g_renamed()
            if (r7 != 0) goto L74
            boolean r6 = r6.w_renamed
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
    public boolean dispatchGenericMotionEvent(android.view.MotionEvent motionEvent) {
        if ((motionEvent.getSource() & 2) == 0 || motionEvent.getAction() == 10 || this.i_renamed <= 0.0f) {
            return super.dispatchGenericMotionEvent(motionEvent);
        }
        int childCount = getChildCount();
        if (childCount == 0) {
            return false;
        }
        float x_renamed = motionEvent.getX();
        float y_renamed = motionEvent.getY();
        for (int i_renamed = childCount - 1; i_renamed >= 0; i_renamed--) {
            android.view.View childAt = getChildAt(i_renamed);
            if (a_renamed(x_renamed, y_renamed, childAt) && !f_renamed(childAt) && a_renamed(motionEvent, childAt)) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B_renamed:21:0x005f  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouchEvent(android.view.MotionEvent r7) {
        /*
            r6 = this;
            androidx.customview.a_renamed.c_renamed r0 = r6.k_renamed
            r0.b_renamed(r7)
            androidx.customview.a_renamed.c_renamed r0 = r6.l_renamed
            r0.b_renamed(r7)
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
            r6.a_renamed(r1)
            r6.v_renamed = r2
            r6.w_renamed = r2
            goto L76
        L22:
            float r0 = r7.getX()
            float r7 = r7.getY()
            androidx.customview.a_renamed.c_renamed r3 = r6.k_renamed
            int r4 = (int) r0
            int r5 = (int) r7
            android.view.View r3 = r3.d_renamed(r4, r5)
            if (r3 == 0) goto L5f
            boolean r3 = r6.f_renamed(r3)
            if (r3 == 0) goto L5f
            float r3 = r6.z_renamed
            float r0 = r0 - r3
            float r3 = r6.A_renamed
            float r7 = r7 - r3
            androidx.customview.a_renamed.c_renamed r3 = r6.k_renamed
            int r3 = r3.d_renamed()
            float r0 = r0 * r0
            float r7 = r7 * r7
            float r0 = r0 + r7
            int r3 = r3 * r3
            float r7 = (float) r3
            int r7 = (r0 > r7 ? 1 : (r0 == r7 ? 0 : -1))
            if (r7 >= 0) goto L5f
            android.view.View r7 = r6.a_renamed()
            if (r7 == 0) goto L5f
            int r7 = r6.a_renamed(r7)
            r0 = 2
            if (r7 != r0) goto L5d
            goto L5f
        L5d:
            r7 = r2
            goto L60
        L5f:
            r7 = r1
        L60:
            r6.a_renamed(r7)
            r6.v_renamed = r2
            goto L76
        L66:
            float r0 = r7.getX()
            float r7 = r7.getY()
            r6.z_renamed = r0
            r6.A_renamed = r7
            r6.v_renamed = r2
            r6.w_renamed = r2
        L76:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.drawerlayout.widget.DrawerLayout.onTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z_renamed) {
        super.requestDisallowInterceptTouchEvent(z_renamed);
        this.v_renamed = z_renamed;
        if (z_renamed) {
            a_renamed(true);
        }
    }

    public void b_renamed() {
        a_renamed(false);
    }

    void a_renamed(boolean z_renamed) {
        boolean zA;
        int childCount = getChildCount();
        boolean z2 = false;
        for (int i_renamed = 0; i_renamed < childCount; i_renamed++) {
            android.view.View childAt = getChildAt(i_renamed);
            androidx.drawerlayout.widget.DrawerLayout.c_renamed cVar = (androidx.drawerlayout.widget.DrawerLayout.c_renamed) childAt.getLayoutParams();
            if (g_renamed(childAt) && (!z_renamed || cVar.f1054c)) {
                int width = childAt.getWidth();
                if (a_renamed(childAt, 3)) {
                    zA = this.k_renamed.a_renamed(childAt, -width, childAt.getTop());
                } else {
                    zA = this.l_renamed.a_renamed(childAt, getWidth(), childAt.getTop());
                }
                z2 |= zA;
                cVar.f1054c = false;
            }
        }
        this.m_renamed.a_renamed();
        this.n_renamed.a_renamed();
        if (z2) {
            invalidate();
        }
    }

    public void h_renamed(android.view.View view) {
        a_renamed(view, true);
    }

    public void a_renamed(android.view.View view, boolean z_renamed) {
        if (!g_renamed(view)) {
            throw new java.lang.IllegalArgumentException("View " + view + " is_renamed not a_renamed sliding drawer");
        }
        androidx.drawerlayout.widget.DrawerLayout.c_renamed cVar = (androidx.drawerlayout.widget.DrawerLayout.c_renamed) view.getLayoutParams();
        if (this.q_renamed) {
            cVar.f1053b = 1.0f;
            cVar.d_renamed = 1;
            c_renamed(view, true);
        } else if (z_renamed) {
            cVar.d_renamed |= 2;
            if (a_renamed(view, 3)) {
                this.k_renamed.a_renamed(view, 0, view.getTop());
            } else {
                this.l_renamed.a_renamed(view, getWidth() - view.getWidth(), view.getTop());
            }
        } else {
            c_renamed(view, 1.0f);
            a_renamed(cVar.f1052a, 0, view);
            view.setVisibility(0);
        }
        invalidate();
    }

    public void i_renamed(android.view.View view) {
        b_renamed(view, true);
    }

    public void b_renamed(android.view.View view, boolean z_renamed) {
        if (!g_renamed(view)) {
            throw new java.lang.IllegalArgumentException("View " + view + " is_renamed not a_renamed sliding drawer");
        }
        androidx.drawerlayout.widget.DrawerLayout.c_renamed cVar = (androidx.drawerlayout.widget.DrawerLayout.c_renamed) view.getLayoutParams();
        if (this.q_renamed) {
            cVar.f1053b = 0.0f;
            cVar.d_renamed = 0;
        } else if (z_renamed) {
            cVar.d_renamed |= 4;
            if (a_renamed(view, 3)) {
                this.k_renamed.a_renamed(view, -view.getWidth(), view.getTop());
            } else {
                this.l_renamed.a_renamed(view, getWidth(), view.getTop());
            }
        } else {
            c_renamed(view, 0.0f);
            a_renamed(cVar.f1052a, 0, view);
            view.setVisibility(4);
        }
        invalidate();
    }

    public boolean j_renamed(android.view.View view) {
        if (g_renamed(view)) {
            return (((androidx.drawerlayout.widget.DrawerLayout.c_renamed) view.getLayoutParams()).d_renamed & 1) == 1;
        }
        throw new java.lang.IllegalArgumentException("View " + view + " is_renamed not a_renamed drawer");
    }

    public boolean k_renamed(android.view.View view) {
        if (g_renamed(view)) {
            return ((androidx.drawerlayout.widget.DrawerLayout.c_renamed) view.getLayoutParams()).f1053b > 0.0f;
        }
        throw new java.lang.IllegalArgumentException("View " + view + " is_renamed not a_renamed drawer");
    }

    private boolean g_renamed() {
        int childCount = getChildCount();
        for (int i_renamed = 0; i_renamed < childCount; i_renamed++) {
            if (((androidx.drawerlayout.widget.DrawerLayout.c_renamed) getChildAt(i_renamed).getLayoutParams()).f1054c) {
                return true;
            }
        }
        return false;
    }

    @Override // android.view.ViewGroup
    protected android.view.ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new androidx.drawerlayout.widget.DrawerLayout.c_renamed(-1, -1);
    }

    @Override // android.view.ViewGroup
    protected android.view.ViewGroup.LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof androidx.drawerlayout.widget.DrawerLayout.c_renamed ? new androidx.drawerlayout.widget.DrawerLayout.c_renamed((androidx.drawerlayout.widget.DrawerLayout.c_renamed) layoutParams) : layoutParams instanceof android.view.ViewGroup.MarginLayoutParams ? new androidx.drawerlayout.widget.DrawerLayout.c_renamed((android.view.ViewGroup.MarginLayoutParams) layoutParams) : new androidx.drawerlayout.widget.DrawerLayout.c_renamed(layoutParams);
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof androidx.drawerlayout.widget.DrawerLayout.c_renamed) && super.checkLayoutParams(layoutParams);
    }

    @Override // android.view.ViewGroup
    public android.view.ViewGroup.LayoutParams generateLayoutParams(android.util.AttributeSet attributeSet) {
        return new androidx.drawerlayout.widget.DrawerLayout.c_renamed(getContext(), attributeSet);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addFocusables(java.util.ArrayList<android.view.View> arrayList, int i_renamed, int i2) {
        if (getDescendantFocusability() == 393216) {
            return;
        }
        int childCount = getChildCount();
        boolean z_renamed = false;
        for (int i3 = 0; i3 < childCount; i3++) {
            android.view.View childAt = getChildAt(i3);
            if (g_renamed(childAt)) {
                if (j_renamed(childAt)) {
                    childAt.addFocusables(arrayList, i_renamed, i2);
                    z_renamed = true;
                }
            } else {
                this.K_renamed.add(childAt);
            }
        }
        if (!z_renamed) {
            int size = this.K_renamed.size();
            for (int i4 = 0; i4 < size; i4++) {
                android.view.View view = this.K_renamed.get(i4);
                if (view.getVisibility() == 0) {
                    view.addFocusables(arrayList, i_renamed, i2);
                }
            }
        }
        this.K_renamed.clear();
    }

    private boolean h_renamed() {
        return c_renamed() != null;
    }

    android.view.View c_renamed() {
        int childCount = getChildCount();
        for (int i_renamed = 0; i_renamed < childCount; i_renamed++) {
            android.view.View childAt = getChildAt(i_renamed);
            if (g_renamed(childAt) && k_renamed(childAt)) {
                return childAt;
            }
        }
        return null;
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i_renamed, android.view.KeyEvent keyEvent) {
        if (i_renamed == 4 && h_renamed()) {
            keyEvent.startTracking();
            return true;
        }
        return super.onKeyDown(i_renamed, keyEvent);
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i_renamed, android.view.KeyEvent keyEvent) {
        if (i_renamed == 4) {
            android.view.View viewC = c_renamed();
            if (viewC != null && a_renamed(viewC) == 0) {
                b_renamed();
            }
            return viewC != null;
        }
        return super.onKeyUp(i_renamed, keyEvent);
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(android.os.Parcelable parcelable) {
        android.view.View viewB;
        if (!(parcelable instanceof androidx.drawerlayout.widget.DrawerLayout.SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        androidx.drawerlayout.widget.DrawerLayout.SavedState savedState = (androidx.drawerlayout.widget.DrawerLayout.SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        if (savedState.openDrawerGravity != 0 && (viewB = b_renamed(savedState.openDrawerGravity)) != null) {
            h_renamed(viewB);
        }
        if (savedState.lockModeLeft != 3) {
            a_renamed(savedState.lockModeLeft, 3);
        }
        if (savedState.lockModeRight != 3) {
            a_renamed(savedState.lockModeRight, 5);
        }
        if (savedState.lockModeStart != 3) {
            a_renamed(savedState.lockModeStart, 8388611);
        }
        if (savedState.lockModeEnd != 3) {
            a_renamed(savedState.lockModeEnd, 8388613);
        }
    }

    @Override // android.view.View
    protected android.os.Parcelable onSaveInstanceState() {
        androidx.drawerlayout.widget.DrawerLayout.SavedState savedState = new androidx.drawerlayout.widget.DrawerLayout.SavedState(super.onSaveInstanceState());
        int childCount = getChildCount();
        for (int i_renamed = 0; i_renamed < childCount; i_renamed++) {
            androidx.drawerlayout.widget.DrawerLayout.c_renamed cVar = (androidx.drawerlayout.widget.DrawerLayout.c_renamed) getChildAt(i_renamed).getLayoutParams();
            boolean z_renamed = cVar.d_renamed == 1;
            boolean z2 = cVar.d_renamed == 2;
            if (z_renamed || z2) {
                savedState.openDrawerGravity = cVar.f1052a;
                break;
            }
        }
        savedState.lockModeLeft = this.r_renamed;
        savedState.lockModeRight = this.s_renamed;
        savedState.lockModeStart = this.t_renamed;
        savedState.lockModeEnd = this.u_renamed;
        return savedState;
    }

    @Override // android.view.ViewGroup
    public void addView(android.view.View view, int i_renamed, android.view.ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i_renamed, layoutParams);
        if (a_renamed() != null || g_renamed(view)) {
            androidx.core.h_renamed.v_renamed.b_renamed(view, 4);
        } else {
            androidx.core.h_renamed.v_renamed.b_renamed(view, 1);
        }
        if (f1050b) {
            return;
        }
        androidx.core.h_renamed.v_renamed.a_renamed(view, this.e_renamed);
    }

    static boolean l_renamed(android.view.View view) {
        return (androidx.core.h_renamed.v_renamed.f_renamed(view) == 4 || androidx.core.h_renamed.v_renamed.f_renamed(view) == 2) ? false : true;
    }

    protected static class SavedState extends androidx.customview.view.AbsSavedState {
        public static final android.os.Parcelable.Creator<androidx.drawerlayout.widget.DrawerLayout.SavedState> CREATOR = new android.os.Parcelable.ClassLoaderCreator<androidx.drawerlayout.widget.DrawerLayout.SavedState>() { // from class: androidx.drawerlayout.widget.DrawerLayout.SavedState.1
            @Override // android.os.Parcelable.ClassLoaderCreator
            /* renamed from: a_renamed, reason: merged with bridge method [inline-methods] */
            public androidx.drawerlayout.widget.DrawerLayout.SavedState createFromParcel(android.os.Parcel parcel, java.lang.ClassLoader classLoader) {
                return new androidx.drawerlayout.widget.DrawerLayout.SavedState(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a_renamed, reason: merged with bridge method [inline-methods] */
            public androidx.drawerlayout.widget.DrawerLayout.SavedState createFromParcel(android.os.Parcel parcel) {
                return new androidx.drawerlayout.widget.DrawerLayout.SavedState(parcel, null);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a_renamed, reason: merged with bridge method [inline-methods] */
            public androidx.drawerlayout.widget.DrawerLayout.SavedState[] newArray(int i_renamed) {
                return new androidx.drawerlayout.widget.DrawerLayout.SavedState[i_renamed];
            }
        };
        int lockModeEnd;
        int lockModeLeft;
        int lockModeRight;
        int lockModeStart;
        int openDrawerGravity;

        public SavedState(android.os.Parcel parcel, java.lang.ClassLoader classLoader) {
            super(parcel, classLoader);
            this.openDrawerGravity = 0;
            this.openDrawerGravity = parcel.readInt();
            this.lockModeLeft = parcel.readInt();
            this.lockModeRight = parcel.readInt();
            this.lockModeStart = parcel.readInt();
            this.lockModeEnd = parcel.readInt();
        }

        public SavedState(android.os.Parcelable parcelable) {
            super(parcelable);
            this.openDrawerGravity = 0;
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(android.os.Parcel parcel, int i_renamed) {
            super.writeToParcel(parcel, i_renamed);
            parcel.writeInt(this.openDrawerGravity);
            parcel.writeInt(this.lockModeLeft);
            parcel.writeInt(this.lockModeRight);
            parcel.writeInt(this.lockModeStart);
            parcel.writeInt(this.lockModeEnd);
        }
    }

    private class d_renamed extends androidx.customview.a_renamed.c_renamed.a_renamed {

        /* renamed from: a_renamed, reason: collision with root package name */
        final /* synthetic */ androidx.drawerlayout.widget.DrawerLayout f1055a;

        /* renamed from: b_renamed, reason: collision with root package name */
        private final int f1056b;

        /* renamed from: c_renamed, reason: collision with root package name */
        private androidx.customview.a_renamed.c_renamed f1057c;
        private final java.lang.Runnable d_renamed;

        @Override // androidx.customview.a_renamed.c_renamed.a_renamed
        public boolean onEdgeLock(int i_renamed) {
            return false;
        }

        public void a_renamed() {
            this.f1055a.removeCallbacks(this.d_renamed);
        }

        @Override // androidx.customview.a_renamed.c_renamed.a_renamed
        public boolean tryCaptureView(android.view.View view, int i_renamed) {
            return this.f1055a.g_renamed(view) && this.f1055a.a_renamed(view, this.f1056b) && this.f1055a.a_renamed(view) == 0;
        }

        @Override // androidx.customview.a_renamed.c_renamed.a_renamed
        public void onViewDragStateChanged(int i_renamed) {
            this.f1055a.a_renamed(this.f1056b, i_renamed, this.f1057c.c_renamed());
        }

        @Override // androidx.customview.a_renamed.c_renamed.a_renamed
        public void onViewPositionChanged(android.view.View view, int i_renamed, int i2, int i3, int i4) {
            float width = (this.f1055a.a_renamed(view, 3) ? i_renamed + r3 : this.f1055a.getWidth() - i_renamed) / view.getWidth();
            this.f1055a.b_renamed(view, width);
            view.setVisibility(width == 0.0f ? 4 : 0);
            this.f1055a.invalidate();
        }

        @Override // androidx.customview.a_renamed.c_renamed.a_renamed
        public void onViewCaptured(android.view.View view, int i_renamed) {
            ((androidx.drawerlayout.widget.DrawerLayout.c_renamed) view.getLayoutParams()).f1054c = false;
            b_renamed();
        }

        private void b_renamed() {
            android.view.View viewB = this.f1055a.b_renamed(this.f1056b == 3 ? 5 : 3);
            if (viewB != null) {
                this.f1055a.i_renamed(viewB);
            }
        }

        @Override // androidx.customview.a_renamed.c_renamed.a_renamed
        public void onViewReleased(android.view.View view, float f_renamed, float f2) {
            int i_renamed;
            float fD_renamed = this.f1055a.d_renamed(view);
            int width = view.getWidth();
            if (this.f1055a.a_renamed(view, 3)) {
                i_renamed = (f_renamed > 0.0f || (f_renamed == 0.0f && fD_renamed > 0.5f)) ? 0 : -width;
            } else {
                int width2 = this.f1055a.getWidth();
                if (f_renamed < 0.0f || (f_renamed == 0.0f && fD_renamed > 0.5f)) {
                    width2 -= width;
                }
                i_renamed = width2;
            }
            this.f1057c.a_renamed(i_renamed, view.getTop());
            this.f1055a.invalidate();
        }

        @Override // androidx.customview.a_renamed.c_renamed.a_renamed
        public void onEdgeTouched(int i_renamed, int i2) {
            this.f1055a.postDelayed(this.d_renamed, 160L);
        }

        @Override // androidx.customview.a_renamed.c_renamed.a_renamed
        public void onEdgeDragStarted(int i_renamed, int i2) {
            android.view.View viewB;
            if ((i_renamed & 1) == 1) {
                viewB = this.f1055a.b_renamed(3);
            } else {
                viewB = this.f1055a.b_renamed(5);
            }
            if (viewB == null || this.f1055a.a_renamed(viewB) != 0) {
                return;
            }
            this.f1057c.a_renamed(viewB, i2);
        }

        @Override // androidx.customview.a_renamed.c_renamed.a_renamed
        public int getViewHorizontalDragRange(android.view.View view) {
            if (this.f1055a.g_renamed(view)) {
                return view.getWidth();
            }
            return 0;
        }

        @Override // androidx.customview.a_renamed.c_renamed.a_renamed
        public int clampViewPositionHorizontal(android.view.View view, int i_renamed, int i2) {
            if (this.f1055a.a_renamed(view, 3)) {
                return java.lang.Math.max(-view.getWidth(), java.lang.Math.min(i_renamed, 0));
            }
            int width = this.f1055a.getWidth();
            return java.lang.Math.max(width - view.getWidth(), java.lang.Math.min(i_renamed, width));
        }

        @Override // androidx.customview.a_renamed.c_renamed.a_renamed
        public int clampViewPositionVertical(android.view.View view, int i_renamed, int i2) {
            return view.getTop();
        }
    }

    public static class c_renamed extends android.view.ViewGroup.MarginLayoutParams {

        /* renamed from: a_renamed, reason: collision with root package name */
        public int f1052a;

        /* renamed from: b_renamed, reason: collision with root package name */
        float f1053b;

        /* renamed from: c_renamed, reason: collision with root package name */
        boolean f1054c;
        int d_renamed;

        public c_renamed(android.content.Context context, android.util.AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f1052a = 0;
            android.content.res.TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, androidx.drawerlayout.widget.DrawerLayout.f1049a);
            this.f1052a = typedArrayObtainStyledAttributes.getInt(0, 0);
            typedArrayObtainStyledAttributes.recycle();
        }

        public c_renamed(int i_renamed, int i2) {
            super(i_renamed, i2);
            this.f1052a = 0;
        }

        public c_renamed(androidx.drawerlayout.widget.DrawerLayout.c_renamed cVar) {
            super((android.view.ViewGroup.MarginLayoutParams) cVar);
            this.f1052a = 0;
            this.f1052a = cVar.f1052a;
        }

        public c_renamed(android.view.ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f1052a = 0;
        }

        public c_renamed(android.view.ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f1052a = 0;
        }
    }

    static final class a_renamed extends androidx.core.h_renamed.a_renamed {
        @Override // androidx.core.h_renamed.a_renamed
        public void onInitializeAccessibilityNodeInfo(android.view.View view, androidx.core.h_renamed.a_renamed.d_renamed dVar) {
            super.onInitializeAccessibilityNodeInfo(view, dVar);
            if (androidx.drawerlayout.widget.DrawerLayout.l_renamed(view)) {
                return;
            }
            dVar.b_renamed((android.view.View) null);
        }
    }
}

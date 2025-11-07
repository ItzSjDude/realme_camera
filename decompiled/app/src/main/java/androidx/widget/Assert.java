package androidx.widget;

/* loaded from: classes.dex */
public class COUIDrawerLayout extends android.view.ViewGroup {

    /* renamed from: b_renamed, reason: collision with root package name */
    static final boolean f1865b;
    private static final boolean d_renamed;
    private int A_renamed;
    private int B_renamed;
    private int C_renamed;
    private int D_renamed;
    private boolean E_renamed;
    private boolean F_renamed;
    private androidx.widget.COUIDrawerLayout.c_renamed G_renamed;
    private java.util.List<androidx.widget.COUIDrawerLayout.c_renamed> H_renamed;
    private float I_renamed;
    private float J_renamed;
    private android.graphics.drawable.Drawable K_renamed;
    private android.graphics.drawable.Drawable L_renamed;
    private android.graphics.drawable.Drawable M_renamed;
    private android.graphics.drawable.Drawable N_renamed;
    private java.lang.Object O_renamed;
    private boolean P_renamed;
    private android.graphics.drawable.Drawable Q_renamed;
    private android.graphics.drawable.Drawable R_renamed;
    private android.graphics.drawable.Drawable S_renamed;
    private android.graphics.drawable.Drawable T_renamed;
    private android.graphics.drawable.Drawable U_renamed;
    private final java.util.ArrayList<android.view.View> V_renamed;
    private android.graphics.Rect W_renamed;
    private android.graphics.Matrix aa_renamed;
    private androidx.widget.COUIDrawerLayout.a_renamed ab_renamed;
    private int ac_renamed;
    private com.a_renamed.a_renamed.f_renamed ad_renamed;
    private android.view.View ae_renamed;
    private int af_renamed;
    private final androidx.widget.COUIDrawerLayout.b_renamed e_renamed;
    private float f_renamed;
    private int g_renamed;
    private int h_renamed;
    private float i_renamed;
    private android.graphics.Paint j_renamed;
    private final androidx.customview.a_renamed.c_renamed k_renamed;
    private final androidx.customview.a_renamed.c_renamed l_renamed;
    private final androidx.customview.a_renamed.c_renamed m_renamed;
    private final androidx.widget.COUIDrawerLayout.e_renamed n_renamed;
    private final androidx.widget.COUIDrawerLayout.e_renamed o_renamed;
    private final androidx.widget.COUIDrawerLayout.e_renamed p_renamed;
    private android.graphics.Rect q_renamed;
    private int r_renamed;
    private boolean s_renamed;
    private boolean t_renamed;
    private int u_renamed;
    private int v_renamed;
    private boolean w_renamed;
    private boolean x_renamed;
    private boolean y_renamed;
    private int z_renamed;

    /* renamed from: c_renamed, reason: collision with root package name */
    private static final int[] f1866c = {android.R_renamed.attr.colorPrimaryDark};

    /* renamed from: a_renamed, reason: collision with root package name */
    static final int[] f1864a = {android.R_renamed.attr.layout_gravity};

    public interface a_renamed {
        void a_renamed();
    }

    public interface c_renamed {
        void a_renamed(int i_renamed);

        void a_renamed(android.view.View view);

        void a_renamed(android.view.View view, float f_renamed);

        void b_renamed(android.view.View view);
    }

    static {
        f1865b = android.os.Build.VERSION.SDK_INT >= 19;
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
    public void setDrawerListener(androidx.widget.COUIDrawerLayout.c_renamed cVar) {
        androidx.widget.COUIDrawerLayout.c_renamed cVar2 = this.G_renamed;
        if (cVar2 != null) {
            b_renamed(cVar2);
        }
        if (cVar != null) {
            a_renamed(cVar);
        }
        this.G_renamed = cVar;
    }

    public void a_renamed(androidx.widget.COUIDrawerLayout.c_renamed cVar) {
        if (cVar == null) {
            return;
        }
        if (this.H_renamed == null) {
            this.H_renamed = new java.util.ArrayList();
        }
        this.H_renamed.add(cVar);
    }

    public void b_renamed(androidx.widget.COUIDrawerLayout.c_renamed cVar) {
        java.util.List<androidx.widget.COUIDrawerLayout.c_renamed> list;
        if (cVar == null || (list = this.H_renamed) == null) {
            return;
        }
        list.remove(cVar);
    }

    public void setDrawerLockMode(int i_renamed) {
        a_renamed(i_renamed, 3);
        a_renamed(i_renamed, 5);
        a_renamed(i_renamed, 80);
    }

    public void a_renamed(int i_renamed, int i2) {
        android.view.View viewB;
        androidx.customview.a_renamed.c_renamed cVar;
        int iA = androidx.core.h_renamed.c_renamed.a_renamed(i2, androidx.core.h_renamed.v_renamed.g_renamed(this));
        if (i2 == 3) {
            this.z_renamed = i_renamed;
        } else if (i2 == 5) {
            this.A_renamed = i_renamed;
        } else if (i2 == 80) {
            this.D_renamed = i_renamed;
        } else if (i2 == 8388611) {
            this.B_renamed = i_renamed;
        } else if (i2 == 8388613) {
            this.C_renamed = i_renamed;
        }
        if (i_renamed != 0) {
            if (iA == 3) {
                cVar = this.k_renamed;
            } else if (iA == 5) {
                cVar = this.l_renamed;
            } else {
                cVar = this.m_renamed;
            }
            cVar.e_renamed();
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
            int i2 = this.z_renamed;
            if (i2 != 3) {
                return i2;
            }
            int i3 = iG == 0 ? this.B_renamed : this.C_renamed;
            if (i3 != 3) {
                return i3;
            }
            return 0;
        }
        if (i_renamed == 5) {
            int i4 = this.A_renamed;
            if (i4 != 3) {
                return i4;
            }
            int i5 = iG == 0 ? this.C_renamed : this.B_renamed;
            if (i5 != 3) {
                return i5;
            }
            return 0;
        }
        if (i_renamed == 80) {
            int i6 = this.D_renamed;
            if (i6 != 3) {
                return i6;
            }
            return 0;
        }
        if (i_renamed == 8388611) {
            int i7 = this.B_renamed;
            if (i7 != 3) {
                return i7;
            }
            int i8 = iG == 0 ? this.z_renamed : this.A_renamed;
            if (i8 != 3) {
                return i8;
            }
            return 0;
        }
        if (i_renamed != 8388613) {
            return 0;
        }
        int i9 = this.C_renamed;
        if (i9 != 3) {
            return i9;
        }
        int i10 = iG == 0 ? this.A_renamed : this.z_renamed;
        if (i10 != 3) {
            return i10;
        }
        return 0;
    }

    @android.annotation.SuppressLint({"WrongConstant"})
    public int a_renamed(android.view.View view) {
        if (!g_renamed(view)) {
            throw new java.lang.IllegalArgumentException("View " + view + " is_renamed not a_renamed drawer");
        }
        return a_renamed(((androidx.widget.COUIDrawerLayout.d_renamed) view.getLayoutParams()).f1867a);
    }

    private boolean a_renamed(float f_renamed, float f2, android.view.View view) {
        if (this.W_renamed == null) {
            this.W_renamed = new android.graphics.Rect();
        }
        view.getHitRect(this.W_renamed);
        return this.W_renamed.contains((int) f_renamed, (int) f2);
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
            if (this.aa_renamed == null) {
                this.aa_renamed = new android.graphics.Matrix();
            }
            matrix.invert(this.aa_renamed);
            motionEventObtain.transform(this.aa_renamed);
        }
        return motionEventObtain;
    }

    void a_renamed(int i_renamed, int i2, android.view.View view) {
        int iA = this.k_renamed.a_renamed();
        int iA2 = this.l_renamed.a_renamed();
        int iA3 = this.m_renamed.a_renamed();
        int i3 = (iA == 1 || iA2 == 1 || iA3 == 1) ? 1 : (iA == 2 || iA2 == 2 || iA3 == 2) ? 2 : 0;
        if (view != null && i2 == 0) {
            androidx.widget.COUIDrawerLayout.d_renamed dVar = (androidx.widget.COUIDrawerLayout.d_renamed) view.getLayoutParams();
            if (dVar.f1868b == 0.0f) {
                b_renamed(view);
            } else if (dVar.f1868b == 1.0f) {
                c_renamed(view);
            } else {
                dVar.d_renamed &= 2;
            }
        }
        if (i3 != this.v_renamed) {
            this.v_renamed = i3;
            java.util.List<androidx.widget.COUIDrawerLayout.c_renamed> list = this.H_renamed;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    this.H_renamed.get(size).a_renamed(i3);
                }
            }
        }
    }

    void b_renamed(android.view.View view) {
        android.view.View rootView;
        androidx.widget.COUIDrawerLayout.d_renamed dVar = (androidx.widget.COUIDrawerLayout.d_renamed) view.getLayoutParams();
        if (a_renamed(view, 80) && dVar.d_renamed != 4) {
            dVar.d_renamed = 1;
        }
        if ((dVar.d_renamed & 1) == 1) {
            dVar.d_renamed = 0;
            java.util.List<androidx.widget.COUIDrawerLayout.c_renamed> list = this.H_renamed;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    this.H_renamed.get(size).b_renamed(view);
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
        androidx.widget.COUIDrawerLayout.d_renamed dVar = (androidx.widget.COUIDrawerLayout.d_renamed) view.getLayoutParams();
        if ((dVar.d_renamed & 1) == 0) {
            dVar.d_renamed = 1;
            java.util.List<androidx.widget.COUIDrawerLayout.c_renamed> list = this.H_renamed;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    this.H_renamed.get(size).a_renamed(view);
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
        java.util.List<androidx.widget.COUIDrawerLayout.c_renamed> list = this.H_renamed;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.H_renamed.get(size).a_renamed(view, f_renamed);
            }
        }
    }

    void b_renamed(android.view.View view, float f_renamed) {
        androidx.widget.COUIDrawerLayout.d_renamed dVar = (androidx.widget.COUIDrawerLayout.d_renamed) view.getLayoutParams();
        if (f_renamed == dVar.f1868b) {
            return;
        }
        dVar.f1868b = f_renamed;
        a_renamed(view, f_renamed);
    }

    float d_renamed(android.view.View view) {
        return ((androidx.widget.COUIDrawerLayout.d_renamed) view.getLayoutParams()).f1868b;
    }

    int e_renamed(android.view.View view) {
        return androidx.core.h_renamed.c_renamed.a_renamed(((androidx.widget.COUIDrawerLayout.d_renamed) view.getLayoutParams()).f1867a, androidx.core.h_renamed.v_renamed.g_renamed(this));
    }

    boolean a_renamed(android.view.View view, int i_renamed) {
        return (e_renamed(view) & i_renamed) == i_renamed;
    }

    android.view.View a_renamed() {
        int childCount = getChildCount();
        for (int i_renamed = 0; i_renamed < childCount; i_renamed++) {
            android.view.View childAt = getChildAt(i_renamed);
            androidx.widget.COUIDrawerLayout.d_renamed dVar = (androidx.widget.COUIDrawerLayout.d_renamed) childAt.getLayoutParams();
            if ((dVar.d_renamed & 1) == 1) {
                return childAt;
            }
            if (a_renamed(childAt, 80) && dVar.f1868b > 0.0f) {
                return childAt;
            }
        }
        return null;
    }

    void c_renamed(android.view.View view, float f_renamed) {
        float fD_renamed = d_renamed(view);
        if (a_renamed(view, 80)) {
            view.offsetTopAndBottom((int) ((fD_renamed - f_renamed) * view.getMeasuredHeight()));
        } else {
            float width = view.getWidth();
            int i_renamed = ((int) (width * f_renamed)) - ((int) (fD_renamed * width));
            if (!a_renamed(view, 3)) {
                i_renamed = -i_renamed;
            }
            view.offsetLeftAndRight(i_renamed);
        }
        b_renamed(view, f_renamed);
    }

    android.view.View b_renamed(int i_renamed) {
        int iA = androidx.core.h_renamed.c_renamed.a_renamed(i_renamed, androidx.core.h_renamed.v_renamed.g_renamed(this)) & 119;
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            android.view.View childAt = getChildAt(i2);
            if ((e_renamed(childAt) & 119) == iA) {
                return childAt;
            }
        }
        return null;
    }

    static java.lang.String c_renamed(int i_renamed) {
        return (i_renamed & 3) == 3 ? "LEFT" : (i_renamed & 5) == 5 ? "RIGHT" : (i_renamed & 80) == 80 ? "BOTTOM" : java.lang.Integer.toHexString(i_renamed);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.x_renamed = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.x_renamed = true;
    }

    /* JADX WARN: Removed duplicated region for block: B_renamed:55:0x0124  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:59:0x012d  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:61:0x014e  */
    @Override // android.view.View
    @android.annotation.SuppressLint({"WrongConstant"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void onMeasure(int r19, int r20) {
        /*
            Method dump skipped, instructions count: 549
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.widget.COUIDrawerLayout.onMeasure(int, int):void");
    }

    private void d_renamed() {
        if (d_renamed) {
            return;
        }
        this.L_renamed = e_renamed();
        this.M_renamed = f_renamed();
        this.N_renamed = this.U_renamed;
    }

    private android.graphics.drawable.Drawable e_renamed() throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        int iG = androidx.core.h_renamed.v_renamed.g_renamed(this);
        if (iG == 0) {
            android.graphics.drawable.Drawable drawable = this.Q_renamed;
            if (drawable != null) {
                a_renamed(drawable, iG);
                return this.Q_renamed;
            }
        } else {
            android.graphics.drawable.Drawable drawable2 = this.R_renamed;
            if (drawable2 != null) {
                a_renamed(drawable2, iG);
                return this.R_renamed;
            }
        }
        return this.S_renamed;
    }

    private android.graphics.drawable.Drawable f_renamed() throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        int iG = androidx.core.h_renamed.v_renamed.g_renamed(this);
        if (iG == 0) {
            android.graphics.drawable.Drawable drawable = this.R_renamed;
            if (drawable != null) {
                a_renamed(drawable, iG);
                return this.R_renamed;
            }
        } else {
            android.graphics.drawable.Drawable drawable2 = this.Q_renamed;
            if (drawable2 != null) {
                a_renamed(drawable2, iG);
                return this.Q_renamed;
            }
        }
        return this.T_renamed;
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
        int paddingLeft;
        boolean z2 = true;
        this.w_renamed = true;
        int i5 = i3 - i_renamed;
        int childCount = getChildCount();
        int i6 = 0;
        while (i6 < childCount) {
            android.view.View childAt = getChildAt(i6);
            if (childAt.getVisibility() != 8) {
                androidx.widget.COUIDrawerLayout.d_renamed dVar = (androidx.widget.COUIDrawerLayout.d_renamed) childAt.getLayoutParams();
                if (f_renamed(childAt)) {
                    childAt.layout(dVar.leftMargin, dVar.topMargin, dVar.leftMargin + childAt.getMeasuredWidth(), dVar.topMargin + childAt.getMeasuredHeight());
                } else {
                    int measuredWidth = childAt.getMeasuredWidth();
                    int measuredHeight = childAt.getMeasuredHeight();
                    if (a_renamed(childAt, 3)) {
                        float f2 = measuredWidth;
                        paddingLeft = (-measuredWidth) + ((int) (dVar.f1868b * f2));
                        f_renamed = (measuredWidth + paddingLeft) / f2;
                    } else if (a_renamed(childAt, 5)) {
                        float f3 = measuredWidth;
                        f_renamed = (i5 - r11) / f3;
                        paddingLeft = i5 - ((int) (dVar.f1868b * f3));
                    } else {
                        int i7 = i4 - i2;
                        f_renamed = (i7 - (i7 - ((int) (dVar.f1868b * r11)))) / measuredHeight;
                        paddingLeft = childAt.getPaddingLeft();
                    }
                    boolean z3 = f_renamed != dVar.f1868b ? z2 : false;
                    int i8 = dVar.f1867a & 119;
                    if (i8 == 16) {
                        int i9 = i4 - i2;
                        int i10 = (i9 - measuredHeight) / 2;
                        if (i10 < dVar.topMargin) {
                            i10 = dVar.topMargin;
                        } else if (i10 + measuredHeight > i9 - dVar.bottomMargin) {
                            i10 = (i9 - dVar.bottomMargin) - measuredHeight;
                        }
                        childAt.layout(paddingLeft, i10, measuredWidth + paddingLeft, measuredHeight + i10);
                    } else if (i8 != 80) {
                        childAt.layout(paddingLeft, dVar.topMargin, measuredWidth + paddingLeft, dVar.topMargin + measuredHeight);
                    } else {
                        int measuredHeight2 = (int) ((i4 - i2) - (((androidx.widget.COUIDrawerLayout.d_renamed) childAt.getLayoutParams()).f1868b * childAt.getMeasuredHeight()));
                        childAt.layout(paddingLeft, measuredHeight2, measuredWidth + paddingLeft, (childAt.getMeasuredHeight() + measuredHeight2) - dVar.bottomMargin);
                    }
                    if (z3) {
                        b_renamed(childAt, f_renamed);
                    }
                    int i11 = dVar.f1868b > 0.0f ? 0 : 4;
                    if (childAt.getVisibility() != i11) {
                        childAt.setVisibility(i11);
                    }
                }
            }
            i6++;
            z2 = true;
        }
        this.w_renamed = false;
        this.x_renamed = false;
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (this.w_renamed) {
            return;
        }
        super.requestLayout();
    }

    @Override // android.view.View
    public void computeScroll() {
        int childCount = getChildCount();
        float fMax = 0.0f;
        for (int i_renamed = 0; i_renamed < childCount; i_renamed++) {
            fMax = java.lang.Math.max(fMax, ((androidx.widget.COUIDrawerLayout.d_renamed) getChildAt(i_renamed).getLayoutParams()).f1868b);
        }
        this.i_renamed = fMax;
        boolean zA = this.k_renamed.a_renamed(true);
        boolean zA2 = this.l_renamed.a_renamed(true);
        boolean zA3 = this.m_renamed.a_renamed(true);
        if (zA || zA2 || zA3) {
            androidx.core.h_renamed.v_renamed.e_renamed(this);
        }
    }

    private static boolean m_renamed(android.view.View view) {
        android.graphics.drawable.Drawable background = view.getBackground();
        return background != null && background.getOpacity() == -1;
    }

    public void setStatusBarBackground(android.graphics.drawable.Drawable drawable) {
        this.K_renamed = drawable;
        invalidate();
    }

    public android.graphics.drawable.Drawable getStatusBarBackgroundDrawable() {
        return this.K_renamed;
    }

    public void setStatusBarBackground(int i_renamed) {
        this.K_renamed = i_renamed != 0 ? androidx.core.a_renamed.a_renamed.a_renamed(getContext(), i_renamed) : null;
        invalidate();
    }

    public void setStatusBarBackgroundColor(int i_renamed) {
        this.K_renamed = new android.graphics.drawable.ColorDrawable(i_renamed);
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
        if (!this.P_renamed || this.K_renamed == null) {
            return;
        }
        int systemWindowInsetTop = (android.os.Build.VERSION.SDK_INT < 21 || (obj = this.O_renamed) == null) ? 0 : ((android.view.WindowInsets) obj).getSystemWindowInsetTop();
        if (systemWindowInsetTop > 0) {
            this.K_renamed.setBounds(0, 0, getWidth(), systemWindowInsetTop);
            this.K_renamed.draw(canvas);
        }
    }

    @Override // android.view.ViewGroup
    protected boolean drawChild(android.graphics.Canvas canvas, android.view.View view, long j_renamed) {
        int i_renamed;
        int height = getHeight();
        boolean zF = f_renamed(view);
        int width = getWidth();
        int height2 = getHeight();
        int iSave = canvas.save();
        int i2 = 80;
        int i3 = 0;
        if (zF) {
            int childCount = getChildCount();
            i_renamed = width;
            int iHeight = height2;
            int i4 = 0;
            int i5 = 0;
            while (i4 < childCount) {
                android.view.View childAt = getChildAt(i4);
                if (childAt != view && childAt.getVisibility() == 0 && ((m_renamed(childAt) || a_renamed(childAt, i2)) && g_renamed(childAt) && childAt.getHeight() >= height)) {
                    if (a_renamed(childAt, 3)) {
                        int right = childAt.getRight();
                        if (right > i5) {
                            i5 = right;
                        }
                    } else if (a_renamed(childAt, 5)) {
                        int left = childAt.getLeft();
                        if (left < i_renamed) {
                            i_renamed = left;
                        }
                    } else {
                        int top = childAt.getTop();
                        if (top < iHeight) {
                            android.graphics.Rect rect = this.q_renamed;
                            iHeight = top + (rect != null ? rect.height() : 0);
                        }
                    }
                }
                i4++;
                i2 = 80;
            }
            canvas.clipRect(i5, 0, i_renamed, iHeight);
            i3 = i5;
        } else {
            i_renamed = width;
        }
        boolean zDrawChild = super.drawChild(canvas, view, j_renamed);
        canvas.restoreToCount(iSave);
        float f_renamed = this.i_renamed;
        if (f_renamed > 0.0f && zF) {
            this.j_renamed.setColor((this.h_renamed & 16777215) | (((int) ((((-16777216) & r2) >>> 24) * f_renamed)) << 24));
            canvas.drawRect(i3, 0.0f, i_renamed, getHeight(), this.j_renamed);
        } else if (this.L_renamed != null && a_renamed(view, 3)) {
            int intrinsicWidth = this.L_renamed.getIntrinsicWidth();
            int right2 = view.getRight();
            float fMax = java.lang.Math.max(0.0f, java.lang.Math.min(right2 / this.k_renamed.b_renamed(), 1.0f));
            this.L_renamed.setBounds(right2, view.getTop(), intrinsicWidth + right2, view.getBottom());
            this.L_renamed.setAlpha((int) (fMax * 255.0f));
            this.L_renamed.draw(canvas);
        } else if (this.M_renamed != null && a_renamed(view, 5)) {
            int intrinsicWidth2 = this.M_renamed.getIntrinsicWidth();
            int left2 = view.getLeft();
            float fMax2 = java.lang.Math.max(0.0f, java.lang.Math.min((getWidth() - left2) / this.l_renamed.b_renamed(), 1.0f));
            this.M_renamed.setBounds(left2 - intrinsicWidth2, view.getTop(), left2, view.getBottom());
            this.M_renamed.setAlpha((int) (fMax2 * 255.0f));
            this.M_renamed.draw(canvas);
        } else if (this.N_renamed != null && a_renamed(view, 80)) {
            int intrinsicHeight = this.N_renamed.getIntrinsicHeight();
            int top2 = view.getTop();
            float fMax3 = java.lang.Math.max(0.0f, java.lang.Math.min((getHeight() - top2) / this.m_renamed.b_renamed(), 1.0f));
            this.N_renamed.setBounds(view.getLeft(), top2 - intrinsicHeight, view.getRight(), view.getBottom());
            this.M_renamed.setAlpha((int) (fMax3 * 255.0f));
            this.M_renamed.draw(canvas);
        }
        return zDrawChild;
    }

    boolean f_renamed(android.view.View view) {
        return ((androidx.widget.COUIDrawerLayout.d_renamed) view.getLayoutParams()).f1867a == 0;
    }

    boolean g_renamed(android.view.View view) {
        int iA = androidx.core.h_renamed.c_renamed.a_renamed(((androidx.widget.COUIDrawerLayout.d_renamed) view.getLayoutParams()).f1867a, androidx.core.h_renamed.v_renamed.g_renamed(view));
        return ((iA & 3) == 0 && (iA & 5) == 0 && (iA & 80) == 0) ? false : true;
    }

    /* JADX WARN: Removed duplicated region for block: B_renamed:42:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:44:0x00c0  */
    @Override // android.view.ViewGroup
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onInterceptTouchEvent(android.view.MotionEvent r10) {
        /*
            Method dump skipped, instructions count: 285
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.widget.COUIDrawerLayout.onInterceptTouchEvent(android.view.MotionEvent):boolean");
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

    /* JADX WARN: Removed duplicated region for block: B_renamed:25:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:31:0x0080  */
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
            boolean r0 = r6.s_renamed
            if (r0 != 0) goto L17
            boolean r0 = r6.t_renamed
            if (r0 == 0) goto L17
            androidx.customview.a_renamed.c_renamed r0 = r6.m_renamed
            r0.b_renamed(r7)
        L17:
            int r0 = r7.getAction()
            r0 = r0 & 255(0xff, float:3.57E-43)
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L88
            if (r0 == r1) goto L30
            r7 = 3
            if (r0 == r7) goto L28
            goto L98
        L28:
            r6.a_renamed(r1)
            r6.E_renamed = r2
            r6.F_renamed = r2
            goto L98
        L30:
            float r0 = r7.getX()
            float r7 = r7.getY()
            androidx.customview.a_renamed.c_renamed r3 = r6.k_renamed
            int r4 = (int) r0
            int r5 = (int) r7
            android.view.View r3 = r3.d_renamed(r4, r5)
            android.view.View r4 = r6.a_renamed()
            if (r3 == 0) goto L6d
            boolean r3 = r6.f_renamed(r3)
            if (r3 == 0) goto L6d
            float r3 = r6.I_renamed
            float r0 = r0 - r3
            float r3 = r6.J_renamed
            float r7 = r7 - r3
            androidx.customview.a_renamed.c_renamed r3 = r6.k_renamed
            int r3 = r3.d_renamed()
            float r0 = r0 * r0
            float r7 = r7 * r7
            float r0 = r0 + r7
            int r3 = r3 * r3
            float r7 = (float) r3
            int r7 = (r0 > r7 ? 1 : (r0 == r7 ? 0 : -1))
            if (r7 >= 0) goto L6d
            if (r4 == 0) goto L6d
            int r7 = r6.a_renamed(r4)
            r0 = 2
            if (r7 != r0) goto L6b
            goto L6d
        L6b:
            r7 = r2
            goto L6e
        L6d:
            r7 = r1
        L6e:
            boolean r0 = r6.y_renamed
            if (r0 != 0) goto L80
            if (r4 == 0) goto L80
            if (r7 != 0) goto L80
            r6.ae_renamed = r4
            com.a_renamed.a_renamed.f_renamed r7 = r6.ad_renamed
            r3 = 4636737291354636288(0x4059000000000000, double:100.0)
            r7.b_renamed(r3)
            goto L83
        L80:
            r6.a_renamed(r7)
        L83:
            r6.E_renamed = r2
            r6.t_renamed = r2
            goto L98
        L88:
            float r0 = r7.getX()
            float r7 = r7.getY()
            r6.I_renamed = r0
            r6.J_renamed = r7
            r6.E_renamed = r2
            r6.F_renamed = r2
        L98:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.widget.COUIDrawerLayout.onTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z_renamed) {
        super.requestDisallowInterceptTouchEvent(z_renamed);
        this.E_renamed = z_renamed;
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
            androidx.widget.COUIDrawerLayout.d_renamed dVar = (androidx.widget.COUIDrawerLayout.d_renamed) childAt.getLayoutParams();
            if (g_renamed(childAt) && (!z_renamed || dVar.f1869c)) {
                int width = childAt.getWidth();
                if (a_renamed(childAt, 3)) {
                    zA = this.k_renamed.a_renamed(childAt, -width, childAt.getTop());
                } else if (a_renamed(childAt, 5)) {
                    zA = this.l_renamed.a_renamed(childAt, getWidth(), childAt.getTop());
                } else {
                    androidx.widget.COUIDrawerLayout.a_renamed aVar = this.ab_renamed;
                    if (aVar != null) {
                        aVar.a_renamed();
                        dVar.f1869c = false;
                    } else {
                        zA = this.m_renamed.a_renamed(childAt, childAt.getLeft(), getHeight());
                    }
                }
                z2 |= zA;
                dVar.f1869c = false;
            }
        }
        this.n_renamed.a_renamed();
        this.o_renamed.a_renamed();
        this.p_renamed.a_renamed();
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
        androidx.widget.COUIDrawerLayout.d_renamed dVar = (androidx.widget.COUIDrawerLayout.d_renamed) view.getLayoutParams();
        this.af_renamed = 0;
        if (this.x_renamed) {
            dVar.f1868b = 1.0f;
            dVar.d_renamed = 1;
            c_renamed(view, true);
        } else if (z_renamed) {
            dVar.d_renamed |= 2;
            if (a_renamed(view, 3)) {
                this.k_renamed.a_renamed(view, 0, view.getTop());
            } else if (a_renamed(view, 5)) {
                this.l_renamed.a_renamed(view, getWidth() - view.getWidth(), view.getTop());
            } else {
                this.m_renamed.a_renamed(view, view.getPaddingLeft(), 0);
            }
        } else {
            c_renamed(view, 1.0f);
            a_renamed(dVar.f1867a, 0, view);
            view.setVisibility(0);
        }
        invalidate();
    }

    public void a_renamed(int i_renamed, boolean z_renamed) {
        android.view.View viewB = b_renamed(i_renamed);
        if (viewB == null) {
            throw new java.lang.IllegalArgumentException("No drawer view found with gravity " + c_renamed(i_renamed));
        }
        a_renamed(viewB, z_renamed);
    }

    public void i_renamed(android.view.View view) {
        b_renamed(view, true);
    }

    public void b_renamed(android.view.View view, boolean z_renamed) {
        if (!g_renamed(view)) {
            throw new java.lang.IllegalArgumentException("View " + view + " is_renamed not a_renamed sliding drawer");
        }
        androidx.widget.COUIDrawerLayout.d_renamed dVar = (androidx.widget.COUIDrawerLayout.d_renamed) view.getLayoutParams();
        this.af_renamed = 2;
        if (this.x_renamed) {
            dVar.f1868b = 0.0f;
            dVar.d_renamed = 0;
        } else if (z_renamed) {
            dVar.d_renamed |= 4;
            if (a_renamed(view, 3)) {
                this.k_renamed.a_renamed(view, -view.getWidth(), view.getTop());
            } else if (a_renamed(view, 5)) {
                this.l_renamed.a_renamed(view, getWidth(), view.getTop());
            } else {
                this.m_renamed.a_renamed(view, view.getLeft(), getHeight());
            }
        } else {
            c_renamed(view, 0.0f);
            a_renamed(dVar.f1867a, 0, view);
            view.setVisibility(4);
        }
        invalidate();
    }

    public void b_renamed(int i_renamed, boolean z_renamed) {
        android.view.View viewB = b_renamed(i_renamed);
        if (viewB == null) {
            throw new java.lang.IllegalArgumentException("No drawer view found with gravity " + c_renamed(i_renamed));
        }
        b_renamed(viewB, z_renamed);
    }

    public boolean j_renamed(android.view.View view) {
        if (g_renamed(view)) {
            return (((androidx.widget.COUIDrawerLayout.d_renamed) view.getLayoutParams()).d_renamed & 1) == 1;
        }
        throw new java.lang.IllegalArgumentException("View " + view + " is_renamed not a_renamed drawer");
    }

    public boolean k_renamed(android.view.View view) {
        if (g_renamed(view)) {
            return ((androidx.widget.COUIDrawerLayout.d_renamed) view.getLayoutParams()).f1868b > 0.0f;
        }
        throw new java.lang.IllegalArgumentException("View " + view + " is_renamed not a_renamed drawer");
    }

    private boolean g_renamed() {
        int childCount = getChildCount();
        for (int i_renamed = 0; i_renamed < childCount; i_renamed++) {
            if (((androidx.widget.COUIDrawerLayout.d_renamed) getChildAt(i_renamed).getLayoutParams()).f1869c) {
                return true;
            }
        }
        return false;
    }

    @Override // android.view.ViewGroup
    protected android.view.ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new androidx.widget.COUIDrawerLayout.d_renamed(-1, -1);
    }

    @Override // android.view.ViewGroup
    protected android.view.ViewGroup.LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof androidx.widget.COUIDrawerLayout.d_renamed ? new androidx.widget.COUIDrawerLayout.d_renamed((androidx.widget.COUIDrawerLayout.d_renamed) layoutParams) : layoutParams instanceof android.view.ViewGroup.MarginLayoutParams ? new androidx.widget.COUIDrawerLayout.d_renamed((android.view.ViewGroup.MarginLayoutParams) layoutParams) : new androidx.widget.COUIDrawerLayout.d_renamed(layoutParams);
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof androidx.widget.COUIDrawerLayout.d_renamed) && super.checkLayoutParams(layoutParams);
    }

    @Override // android.view.ViewGroup
    public android.view.ViewGroup.LayoutParams generateLayoutParams(android.util.AttributeSet attributeSet) {
        return new androidx.widget.COUIDrawerLayout.d_renamed(getContext(), attributeSet);
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
                this.V_renamed.add(childAt);
            }
        }
        if (!z_renamed) {
            int size = this.V_renamed.size();
            for (int i4 = 0; i4 < size; i4++) {
                android.view.View view = this.V_renamed.get(i4);
                if (view.getVisibility() == 0) {
                    view.addFocusables(arrayList, i_renamed, i2);
                }
            }
        }
        this.V_renamed.clear();
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
    @android.annotation.SuppressLint({"WrongConstant"})
    protected void onRestoreInstanceState(android.os.Parcelable parcelable) {
        if (!(parcelable instanceof androidx.widget.COUIDrawerLayout.SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        androidx.widget.COUIDrawerLayout.SavedState savedState = (androidx.widget.COUIDrawerLayout.SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        if (savedState.openDrawerGravity != 0 && b_renamed(savedState.openDrawerGravity) != null) {
            a_renamed(savedState.openDrawerGravity, savedState.onScreen, false);
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
        if (savedState.lockModeBottom != 3) {
            a_renamed(savedState.lockModeBottom, 80);
        }
    }

    @Override // android.view.View
    protected android.os.Parcelable onSaveInstanceState() {
        androidx.widget.COUIDrawerLayout.SavedState savedState = new androidx.widget.COUIDrawerLayout.SavedState(super.onSaveInstanceState());
        int childCount = getChildCount();
        for (int i_renamed = 0; i_renamed < childCount; i_renamed++) {
            androidx.widget.COUIDrawerLayout.d_renamed dVar = (androidx.widget.COUIDrawerLayout.d_renamed) getChildAt(i_renamed).getLayoutParams();
            boolean z_renamed = dVar.d_renamed == 1;
            boolean z2 = dVar.d_renamed == 2;
            if (z_renamed || z2) {
                savedState.openDrawerGravity = dVar.f1867a;
                savedState.onScreen = dVar.f1868b;
                break;
            }
        }
        savedState.lockModeLeft = this.z_renamed;
        savedState.lockModeRight = this.A_renamed;
        savedState.lockModeStart = this.B_renamed;
        savedState.lockModeEnd = this.C_renamed;
        savedState.lockModeBottom = this.D_renamed;
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
        if (f1865b) {
            return;
        }
        androidx.core.h_renamed.v_renamed.a_renamed(view, this.e_renamed);
    }

    static boolean l_renamed(android.view.View view) {
        return (androidx.core.h_renamed.v_renamed.f_renamed(view) == 4 || androidx.core.h_renamed.v_renamed.f_renamed(view) == 2) ? false : true;
    }

    protected static class SavedState extends androidx.customview.view.AbsSavedState {
        public static final android.os.Parcelable.Creator<androidx.widget.COUIDrawerLayout.SavedState> CREATOR = new android.os.Parcelable.ClassLoaderCreator<androidx.widget.COUIDrawerLayout.SavedState>() { // from class: androidx.widget.COUIDrawerLayout.SavedState.1
            @Override // android.os.Parcelable.ClassLoaderCreator
            /* renamed from: a_renamed, reason: merged with bridge method [inline-methods] */
            public androidx.widget.COUIDrawerLayout.SavedState createFromParcel(android.os.Parcel parcel, java.lang.ClassLoader classLoader) {
                return new androidx.widget.COUIDrawerLayout.SavedState(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a_renamed, reason: merged with bridge method [inline-methods] */
            public androidx.widget.COUIDrawerLayout.SavedState createFromParcel(android.os.Parcel parcel) {
                return new androidx.widget.COUIDrawerLayout.SavedState(parcel, null);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a_renamed, reason: merged with bridge method [inline-methods] */
            public androidx.widget.COUIDrawerLayout.SavedState[] newArray(int i_renamed) {
                return new androidx.widget.COUIDrawerLayout.SavedState[i_renamed];
            }
        };
        int lockModeBottom;
        int lockModeEnd;
        int lockModeLeft;
        int lockModeRight;
        int lockModeStart;
        float onScreen;
        int openDrawerGravity;

        public SavedState(android.os.Parcel parcel, java.lang.ClassLoader classLoader) {
            super(parcel, classLoader);
            this.openDrawerGravity = 0;
            this.openDrawerGravity = parcel.readInt();
            this.lockModeLeft = parcel.readInt();
            this.lockModeRight = parcel.readInt();
            this.lockModeStart = parcel.readInt();
            this.lockModeEnd = parcel.readInt();
            this.lockModeBottom = parcel.readInt();
            this.onScreen = parcel.readFloat();
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
            parcel.writeInt(this.lockModeBottom);
            parcel.writeFloat(this.onScreen);
        }
    }

    private class e_renamed extends androidx.customview.a_renamed.c_renamed.a_renamed {

        /* renamed from: a_renamed, reason: collision with root package name */
        final /* synthetic */ androidx.widget.COUIDrawerLayout f1870a;

        /* renamed from: b_renamed, reason: collision with root package name */
        private final int f1871b;

        /* renamed from: c_renamed, reason: collision with root package name */
        private androidx.customview.a_renamed.c_renamed f1872c;
        private int d_renamed;
        private final java.lang.Runnable e_renamed;

        @Override // androidx.customview.a_renamed.c_renamed.a_renamed
        public boolean onEdgeLock(int i_renamed) {
            return false;
        }

        public void a_renamed() {
            this.f1870a.removeCallbacks(this.e_renamed);
        }

        @Override // androidx.customview.a_renamed.c_renamed.a_renamed
        public boolean tryCaptureView(android.view.View view, int i_renamed) {
            return this.f1870a.g_renamed(view) && this.f1870a.a_renamed(view, this.f1871b) && this.f1870a.a_renamed(view) == 0;
        }

        @Override // androidx.customview.a_renamed.c_renamed.a_renamed
        public void onViewDragStateChanged(int i_renamed) {
            android.view.View viewC = this.f1872c.c_renamed();
            if (i_renamed == 1) {
                this.d_renamed = viewC == null ? this.f1870a.getHeight() : viewC.getTop();
            }
            this.f1870a.a_renamed(this.f1871b, i_renamed, viewC);
        }

        /* JADX WARN: Removed duplicated region for block: B_renamed:17:0x004c  */
        @Override // androidx.customview.a_renamed.c_renamed.a_renamed
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void onViewPositionChanged(android.view.View r5, int r6, int r7, int r8, int r9) {
            /*
                r4 = this;
                int r8 = r5.getWidth()
                int r9 = r5.getHeight()
                androidx.widget.COUIDrawerLayout r0 = r4.f1870a
                r1 = 3
                boolean r0 = r0.a_renamed(r5, r1)
                r1 = 4
                r2 = 0
                if (r0 == 0) goto L18
                int r6 = r6 + r8
                float r6 = (float) r6
            L15:
                float r7 = (float) r8
                float r6 = r6 / r7
                goto L42
            L18:
                androidx.widget.COUIDrawerLayout r0 = r4.f1870a
                r3 = 5
                boolean r0 = r0.a_renamed(r5, r3)
                if (r0 == 0) goto L2a
                androidx.widget.COUIDrawerLayout r7 = r4.f1870a
                int r7 = r7.getWidth()
                int r7 = r7 - r6
                float r6 = (float) r7
                goto L15
            L2a:
                androidx.widget.COUIDrawerLayout r6 = r4.f1870a
                int r6 = r6.getMeasuredHeight()
                int r6 = r6 - r7
                float r6 = (float) r6
                float r7 = (float) r9
                float r6 = r6 / r7
                float r6 = java.lang.Math.max(r2, r6)
                int r7 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1))
                if (r7 != 0) goto L3e
                r7 = r1
                goto L3f
            L3e:
                r7 = 1
            L3f:
                androidx.core.h_renamed.v_renamed.b_renamed(r5, r7)
            L42:
                androidx.widget.COUIDrawerLayout r7 = r4.f1870a
                r7.b_renamed(r5, r6)
                int r6 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1))
                if (r6 != 0) goto L4c
                goto L4d
            L4c:
                r1 = 0
            L4d:
                r5.setVisibility(r1)
                androidx.widget.COUIDrawerLayout r4 = r4.f1870a
                r4.invalidate()
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.widget.COUIDrawerLayout.e_renamed.onViewPositionChanged(android.view.View, int, int, int, int):void");
        }

        @Override // androidx.customview.a_renamed.c_renamed.a_renamed
        public void onViewCaptured(android.view.View view, int i_renamed) {
            ((androidx.widget.COUIDrawerLayout.d_renamed) view.getLayoutParams()).f1869c = false;
            b_renamed();
        }

        private void b_renamed() {
            android.view.View viewB;
            int i_renamed = this.f1871b;
            android.view.View viewB2 = null;
            if (i_renamed == 3) {
                viewB2 = this.f1870a.b_renamed(80);
                viewB = this.f1870a.b_renamed(5);
            } else if (i_renamed == 5) {
                viewB2 = this.f1870a.b_renamed(3);
                viewB = this.f1870a.b_renamed(80);
            } else if (i_renamed != 80) {
                viewB = null;
            } else {
                viewB2 = this.f1870a.b_renamed(3);
                viewB = this.f1870a.b_renamed(5);
            }
            if (viewB2 != null) {
                this.f1870a.i_renamed(viewB2);
            }
            if (viewB != null) {
                this.f1870a.i_renamed(viewB);
            }
        }

        @Override // androidx.customview.a_renamed.c_renamed.a_renamed
        public void onViewReleased(android.view.View view, float f_renamed, float f2) {
            int width;
            float fD_renamed = this.f1870a.d_renamed(view);
            int width2 = view.getWidth();
            int height = view.getHeight();
            int left = view.getLeft();
            int top = view.getTop();
            if (this.f1870a.a_renamed(view, 3)) {
                if (f_renamed > 0.0f || (f_renamed == 0.0f && fD_renamed > 0.5f)) {
                    left = 0;
                } else {
                    width = -width2;
                    left = width;
                }
            } else if (this.f1870a.a_renamed(view, 5)) {
                width = this.f1870a.getWidth();
                if (f_renamed < 0.0f || (f_renamed == 0.0f && fD_renamed > 0.5f)) {
                    width -= width2;
                }
                left = width;
            } else {
                top = this.f1870a.getHeight() - view.getMinimumHeight();
                this.f1870a.af_renamed = 1;
                int top2 = this.d_renamed - view.getTop();
                if (top2 <= this.f1870a.u_renamed) {
                    if (top2 < (-this.f1870a.u_renamed) && this.f1870a.y_renamed) {
                        top = this.f1870a.ac_renamed;
                        this.f1870a.af_renamed = 2;
                    }
                } else {
                    top = this.f1870a.getHeight() - height;
                    this.f1870a.af_renamed = 0;
                }
            }
            this.f1872c.a_renamed(left, top);
            this.f1870a.invalidate();
        }

        @Override // androidx.customview.a_renamed.c_renamed.a_renamed
        public void onEdgeTouched(int i_renamed, int i2) {
            this.f1870a.postDelayed(this.e_renamed, 160L);
        }

        @Override // androidx.customview.a_renamed.c_renamed.a_renamed
        public void onEdgeDragStarted(int i_renamed, int i2) {
            android.view.View viewB;
            if ((i_renamed & 1) == 1) {
                viewB = this.f1870a.b_renamed(3);
            } else if ((i_renamed & 2) == 2) {
                viewB = this.f1870a.b_renamed(5);
            } else {
                viewB = this.f1870a.b_renamed(80);
            }
            if (viewB == null || this.f1870a.a_renamed(viewB) != 0) {
                return;
            }
            this.f1872c.a_renamed(viewB, i2);
        }

        @Override // androidx.customview.a_renamed.c_renamed.a_renamed
        public int getViewHorizontalDragRange(android.view.View view) {
            if (!this.f1870a.g_renamed(view) || this.f1870a.a_renamed(view, 80)) {
                return 0;
            }
            return view.getWidth();
        }

        @Override // androidx.customview.a_renamed.c_renamed.a_renamed
        public int clampViewPositionHorizontal(android.view.View view, int i_renamed, int i2) {
            if (this.f1870a.a_renamed(view, 3)) {
                return java.lang.Math.max(-view.getWidth(), java.lang.Math.min(i_renamed, 0));
            }
            if (!this.f1870a.a_renamed(view, 5)) {
                return 0;
            }
            int width = this.f1870a.getWidth();
            return java.lang.Math.max(width - view.getWidth(), java.lang.Math.min(i_renamed, width));
        }

        @Override // androidx.customview.a_renamed.c_renamed.a_renamed
        public int clampViewPositionVertical(android.view.View view, int i_renamed, int i2) {
            return java.lang.Math.min(this.f1870a.getHeight(), java.lang.Math.max(i_renamed, java.lang.Math.max(this.f1870a.getHeight() - view.getHeight(), this.f1870a.r_renamed)));
        }
    }

    public static class d_renamed extends android.view.ViewGroup.MarginLayoutParams {

        /* renamed from: a_renamed, reason: collision with root package name */
        public int f1867a;

        /* renamed from: b_renamed, reason: collision with root package name */
        float f1868b;

        /* renamed from: c_renamed, reason: collision with root package name */
        boolean f1869c;
        int d_renamed;

        public d_renamed(android.content.Context context, android.util.AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f1867a = 0;
            android.content.res.TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, androidx.widget.COUIDrawerLayout.f1864a);
            this.f1867a = typedArrayObtainStyledAttributes.getInt(0, 0);
            typedArrayObtainStyledAttributes.recycle();
        }

        public d_renamed(int i_renamed, int i2) {
            super(i_renamed, i2);
            this.f1867a = 0;
        }

        public d_renamed(androidx.widget.COUIDrawerLayout.d_renamed dVar) {
            super((android.view.ViewGroup.MarginLayoutParams) dVar);
            this.f1867a = 0;
            this.f1867a = dVar.f1867a;
        }

        public d_renamed(android.view.ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f1867a = 0;
        }

        public d_renamed(android.view.ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f1867a = 0;
        }
    }

    static final class b_renamed extends androidx.core.h_renamed.a_renamed {
        @Override // androidx.core.h_renamed.a_renamed
        public void onInitializeAccessibilityNodeInfo(android.view.View view, androidx.core.h_renamed.a_renamed.d_renamed dVar) {
            super.onInitializeAccessibilityNodeInfo(view, dVar);
            if (androidx.widget.COUIDrawerLayout.l_renamed(view)) {
                return;
            }
            dVar.b_renamed((android.view.View) null);
        }
    }

    public void setBottomDrawerActionOffset(int i_renamed) {
        this.u_renamed = i_renamed;
    }

    public int getBottomDrawerActionOffset() {
        return this.u_renamed;
    }

    public void a_renamed(int i_renamed, float f_renamed, boolean z_renamed) {
        if (f_renamed == 1.0f) {
            a_renamed(i_renamed, z_renamed);
            return;
        }
        if (f_renamed == 0.0f) {
            b_renamed(i_renamed, z_renamed);
            return;
        }
        android.view.View viewB = b_renamed(i_renamed);
        if (viewB == null) {
            throw new java.lang.IllegalArgumentException("No drawer view found with gravity " + c_renamed(i_renamed));
        }
        androidx.widget.COUIDrawerLayout.d_renamed dVar = (androidx.widget.COUIDrawerLayout.d_renamed) viewB.getLayoutParams();
        this.af_renamed = 1;
        if (this.x_renamed) {
            dVar.f1868b = f_renamed;
            dVar.d_renamed = 2;
            c_renamed(viewB, true);
        } else if (z_renamed) {
            dVar.d_renamed |= 2;
            if (a_renamed(viewB, 3)) {
                this.k_renamed.a_renamed(viewB, (int) (0.0f - (viewB.getWidth() * f_renamed)), viewB.getTop());
            } else if (a_renamed(viewB, 5)) {
                this.l_renamed.a_renamed(viewB, (int) ((getWidth() - viewB.getWidth()) * f_renamed), viewB.getTop());
            } else {
                this.m_renamed.a_renamed(viewB, viewB.getPaddingLeft(), (int) (getHeight() - (viewB.getHeight() * f_renamed)));
            }
        } else {
            c_renamed(viewB, f_renamed);
            a_renamed(dVar.f1867a, 0, viewB);
            viewB.setVisibility(0);
        }
        invalidate();
    }

    public void setDragRect(android.graphics.Rect rect) {
        this.q_renamed = rect;
    }

    public int getSettlingDirection() {
        return this.af_renamed;
    }

    public void setOffsetMinTop(int i_renamed) {
        this.r_renamed = i_renamed;
    }

    public void setBlankClickedListener(androidx.widget.COUIDrawerLayout.a_renamed aVar) {
        this.ab_renamed = aVar;
    }
}

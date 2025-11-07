package androidx.appcompat.widget;

/* loaded from: classes.dex */
public class ActionBarOverlayLayout extends android.view.ViewGroup implements androidx.appcompat.widget.y_renamed, androidx.core.h_renamed.m_renamed, androidx.core.h_renamed.n_renamed, androidx.core.h_renamed.o_renamed {
    static final int[] e_renamed = {androidx.appcompat.R_renamed.attr.actionBarSize, android.R_renamed.attr.windowContentOverlay};
    private final java.lang.Runnable A_renamed;
    private final androidx.core.h_renamed.p_renamed B_renamed;

    /* renamed from: a_renamed, reason: collision with root package name */
    androidx.appcompat.widget.ActionBarContainer f424a;

    /* renamed from: b_renamed, reason: collision with root package name */
    boolean f425b;

    /* renamed from: c_renamed, reason: collision with root package name */
    android.view.ViewPropertyAnimator f426c;
    final android.animation.AnimatorListenerAdapter d_renamed;
    private int f_renamed;
    private int g_renamed;
    private androidx.appcompat.widget.ContentFrameLayout h_renamed;
    private androidx.appcompat.widget.z_renamed i_renamed;
    private android.graphics.drawable.Drawable j_renamed;
    private boolean k_renamed;
    private boolean l_renamed;
    private boolean m_renamed;
    private boolean n_renamed;
    private int o_renamed;
    private int p_renamed;
    private final android.graphics.Rect q_renamed;
    private final android.graphics.Rect r_renamed;
    private final android.graphics.Rect s_renamed;
    private final android.graphics.Rect t_renamed;
    private final android.graphics.Rect u_renamed;
    private final android.graphics.Rect v_renamed;
    private final android.graphics.Rect w_renamed;
    private androidx.appcompat.widget.ActionBarOverlayLayout.a_renamed x_renamed;
    private android.widget.OverScroller y_renamed;
    private final java.lang.Runnable z_renamed;

    public interface a_renamed {
        void a_renamed(int i_renamed);

        void g_renamed(boolean z_renamed);

        void j_renamed();

        void k_renamed();

        void l_renamed();

        void m_renamed();
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.h_renamed.m_renamed
    public boolean onNestedPreFling(android.view.View view, float f_renamed, float f2) {
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.h_renamed.m_renamed
    public void onNestedPreScroll(android.view.View view, int i_renamed, int i2, int[] iArr) {
    }

    public void setShowingForActionMode(boolean z_renamed) {
    }

    public void setUiOptions(int i_renamed) {
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    public ActionBarOverlayLayout(android.content.Context context) {
        this(context, null);
    }

    public ActionBarOverlayLayout(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        this.g_renamed = 0;
        this.q_renamed = new android.graphics.Rect();
        this.r_renamed = new android.graphics.Rect();
        this.s_renamed = new android.graphics.Rect();
        this.t_renamed = new android.graphics.Rect();
        this.u_renamed = new android.graphics.Rect();
        this.v_renamed = new android.graphics.Rect();
        this.w_renamed = new android.graphics.Rect();
        this.d_renamed = new android.animation.AnimatorListenerAdapter() { // from class: androidx.appcompat.widget.ActionBarOverlayLayout.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(android.animation.Animator animator) {
                androidx.appcompat.widget.ActionBarOverlayLayout actionBarOverlayLayout = androidx.appcompat.widget.ActionBarOverlayLayout.this;
                actionBarOverlayLayout.f426c = null;
                actionBarOverlayLayout.f425b = false;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(android.animation.Animator animator) {
                androidx.appcompat.widget.ActionBarOverlayLayout actionBarOverlayLayout = androidx.appcompat.widget.ActionBarOverlayLayout.this;
                actionBarOverlayLayout.f426c = null;
                actionBarOverlayLayout.f425b = false;
            }
        };
        this.z_renamed = new java.lang.Runnable() { // from class: androidx.appcompat.widget.ActionBarOverlayLayout.2
            @Override // java.lang.Runnable
            public void run() {
                androidx.appcompat.widget.ActionBarOverlayLayout.this.d_renamed();
                androidx.appcompat.widget.ActionBarOverlayLayout actionBarOverlayLayout = androidx.appcompat.widget.ActionBarOverlayLayout.this;
                actionBarOverlayLayout.f426c = actionBarOverlayLayout.f424a.animate().translationY(0.0f).setListener(androidx.appcompat.widget.ActionBarOverlayLayout.this.d_renamed);
            }
        };
        this.A_renamed = new java.lang.Runnable() { // from class: androidx.appcompat.widget.ActionBarOverlayLayout.3
            @Override // java.lang.Runnable
            public void run() {
                androidx.appcompat.widget.ActionBarOverlayLayout.this.d_renamed();
                androidx.appcompat.widget.ActionBarOverlayLayout actionBarOverlayLayout = androidx.appcompat.widget.ActionBarOverlayLayout.this;
                actionBarOverlayLayout.f426c = actionBarOverlayLayout.f424a.animate().translationY(-androidx.appcompat.widget.ActionBarOverlayLayout.this.f424a.getHeight()).setListener(androidx.appcompat.widget.ActionBarOverlayLayout.this.d_renamed);
            }
        };
        a_renamed(context);
        this.B_renamed = new androidx.core.h_renamed.p_renamed(this);
    }

    private void a_renamed(android.content.Context context) {
        android.content.res.TypedArray typedArrayObtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(e_renamed);
        this.f_renamed = typedArrayObtainStyledAttributes.getDimensionPixelSize(0, 0);
        this.j_renamed = typedArrayObtainStyledAttributes.getDrawable(1);
        setWillNotDraw(this.j_renamed == null);
        typedArrayObtainStyledAttributes.recycle();
        this.k_renamed = context.getApplicationInfo().targetSdkVersion < 19;
        this.y_renamed = new android.widget.OverScroller(context);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        d_renamed();
    }

    public void setActionBarVisibilityCallback(androidx.appcompat.widget.ActionBarOverlayLayout.a_renamed aVar) {
        this.x_renamed = aVar;
        if (getWindowToken() != null) {
            this.x_renamed.a_renamed(this.g_renamed);
            int i_renamed = this.p_renamed;
            if (i_renamed != 0) {
                onWindowSystemUiVisibilityChanged(i_renamed);
                androidx.core.h_renamed.v_renamed.s_renamed(this);
            }
        }
    }

    public void setOverlayMode(boolean z_renamed) {
        this.l_renamed = z_renamed;
        this.k_renamed = z_renamed && getContext().getApplicationInfo().targetSdkVersion < 19;
    }

    public boolean a_renamed() {
        return this.l_renamed;
    }

    public void setHasNonEmbeddedTabs(boolean z_renamed) {
        this.m_renamed = z_renamed;
    }

    @Override // android.view.View
    protected void onConfigurationChanged(android.content.res.Configuration configuration) {
        super.onConfigurationChanged(configuration);
        a_renamed(getContext());
        androidx.core.h_renamed.v_renamed.s_renamed(this);
    }

    @Override // android.view.View
    public void onWindowSystemUiVisibilityChanged(int i_renamed) {
        if (android.os.Build.VERSION.SDK_INT >= 16) {
            super.onWindowSystemUiVisibilityChanged(i_renamed);
        }
        c_renamed();
        int i2 = this.p_renamed ^ i_renamed;
        this.p_renamed = i_renamed;
        boolean z_renamed = (i_renamed & 4) == 0;
        boolean z2 = (i_renamed & 256) != 0;
        androidx.appcompat.widget.ActionBarOverlayLayout.a_renamed aVar = this.x_renamed;
        if (aVar != null) {
            aVar.g_renamed(!z2);
            if (z_renamed || !z2) {
                this.x_renamed.j_renamed();
            } else {
                this.x_renamed.k_renamed();
            }
        }
        if ((i2 & 256) == 0 || this.x_renamed == null) {
            return;
        }
        androidx.core.h_renamed.v_renamed.s_renamed(this);
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i_renamed) {
        super.onWindowVisibilityChanged(i_renamed);
        this.g_renamed = i_renamed;
        androidx.appcompat.widget.ActionBarOverlayLayout.a_renamed aVar = this.x_renamed;
        if (aVar != null) {
            aVar.a_renamed(i_renamed);
        }
    }

    private boolean a_renamed(android.view.View view, android.graphics.Rect rect, boolean z_renamed, boolean z2, boolean z3, boolean z4) {
        boolean z5;
        androidx.appcompat.widget.ActionBarOverlayLayout.b_renamed bVar = (androidx.appcompat.widget.ActionBarOverlayLayout.b_renamed) view.getLayoutParams();
        if (!z_renamed || bVar.leftMargin == rect.left) {
            z5 = false;
        } else {
            bVar.leftMargin = rect.left;
            z5 = true;
        }
        if (z2 && bVar.topMargin != rect.top) {
            bVar.topMargin = rect.top;
            z5 = true;
        }
        if (z4 && bVar.rightMargin != rect.right) {
            bVar.rightMargin = rect.right;
            z5 = true;
        }
        if (!z3 || bVar.bottomMargin == rect.bottom) {
            return z5;
        }
        bVar.bottomMargin = rect.bottom;
        return true;
    }

    @Override // android.view.View
    protected boolean fitSystemWindows(android.graphics.Rect rect) throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        c_renamed();
        int iR = androidx.core.h_renamed.v_renamed.r_renamed(this) & 256;
        boolean zA = a_renamed(this.f424a, rect, true, true, false, true);
        this.t_renamed.set(rect);
        androidx.appcompat.widget.ax_renamed.a_renamed(this, this.t_renamed, this.q_renamed);
        if (!this.u_renamed.equals(this.t_renamed)) {
            this.u_renamed.set(this.t_renamed);
            zA = true;
        }
        if (!this.r_renamed.equals(this.q_renamed)) {
            this.r_renamed.set(this.q_renamed);
            zA = true;
        }
        if (zA) {
            requestLayout();
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    /* renamed from: b_renamed, reason: merged with bridge method [inline-methods] */
    public androidx.appcompat.widget.ActionBarOverlayLayout.b_renamed generateDefaultLayoutParams() {
        return new androidx.appcompat.widget.ActionBarOverlayLayout.b_renamed(-1, -1);
    }

    @Override // android.view.ViewGroup
    /* renamed from: a_renamed, reason: merged with bridge method [inline-methods] */
    public androidx.appcompat.widget.ActionBarOverlayLayout.b_renamed generateLayoutParams(android.util.AttributeSet attributeSet) {
        return new androidx.appcompat.widget.ActionBarOverlayLayout.b_renamed(getContext(), attributeSet);
    }

    @Override // android.view.ViewGroup
    protected android.view.ViewGroup.LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return new androidx.appcompat.widget.ActionBarOverlayLayout.b_renamed(layoutParams);
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof androidx.appcompat.widget.ActionBarOverlayLayout.b_renamed;
    }

    @Override // android.view.View
    protected void onMeasure(int i_renamed, int i2) {
        int measuredHeight;
        c_renamed();
        measureChildWithMargins(this.f424a, i_renamed, 0, i2, 0);
        androidx.appcompat.widget.ActionBarOverlayLayout.b_renamed bVar = (androidx.appcompat.widget.ActionBarOverlayLayout.b_renamed) this.f424a.getLayoutParams();
        int iMax = java.lang.Math.max(0, this.f424a.getMeasuredWidth() + bVar.leftMargin + bVar.rightMargin);
        int iMax2 = java.lang.Math.max(0, this.f424a.getMeasuredHeight() + bVar.topMargin + bVar.bottomMargin);
        int iCombineMeasuredStates = android.view.View.combineMeasuredStates(0, this.f424a.getMeasuredState());
        boolean z_renamed = (androidx.core.h_renamed.v_renamed.r_renamed(this) & 256) != 0;
        if (z_renamed) {
            measuredHeight = this.f_renamed;
            if (this.m_renamed && this.f424a.getTabContainer() != null) {
                measuredHeight += this.f_renamed;
            }
        } else {
            measuredHeight = this.f424a.getVisibility() != 8 ? this.f424a.getMeasuredHeight() : 0;
        }
        this.s_renamed.set(this.q_renamed);
        this.v_renamed.set(this.t_renamed);
        if (!this.l_renamed && !z_renamed) {
            this.s_renamed.top += measuredHeight;
            this.s_renamed.bottom += 0;
        } else {
            this.v_renamed.top += measuredHeight;
            this.v_renamed.bottom += 0;
        }
        a_renamed(this.h_renamed, this.s_renamed, true, true, true, true);
        if (!this.w_renamed.equals(this.v_renamed)) {
            this.w_renamed.set(this.v_renamed);
            this.h_renamed.a_renamed(this.v_renamed);
        }
        measureChildWithMargins(this.h_renamed, i_renamed, 0, i2, 0);
        androidx.appcompat.widget.ActionBarOverlayLayout.b_renamed bVar2 = (androidx.appcompat.widget.ActionBarOverlayLayout.b_renamed) this.h_renamed.getLayoutParams();
        int iMax3 = java.lang.Math.max(iMax, this.h_renamed.getMeasuredWidth() + bVar2.leftMargin + bVar2.rightMargin);
        int iMax4 = java.lang.Math.max(iMax2, this.h_renamed.getMeasuredHeight() + bVar2.topMargin + bVar2.bottomMargin);
        int iCombineMeasuredStates2 = android.view.View.combineMeasuredStates(iCombineMeasuredStates, this.h_renamed.getMeasuredState());
        setMeasuredDimension(android.view.View.resolveSizeAndState(java.lang.Math.max(iMax3 + getPaddingLeft() + getPaddingRight(), getSuggestedMinimumWidth()), i_renamed, iCombineMeasuredStates2), android.view.View.resolveSizeAndState(java.lang.Math.max(iMax4 + getPaddingTop() + getPaddingBottom(), getSuggestedMinimumHeight()), i2, iCombineMeasuredStates2 << 16));
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z_renamed, int i_renamed, int i2, int i3, int i4) {
        int childCount = getChildCount();
        int paddingLeft = getPaddingLeft();
        getPaddingRight();
        int paddingTop = getPaddingTop();
        getPaddingBottom();
        for (int i5 = 0; i5 < childCount; i5++) {
            android.view.View childAt = getChildAt(i5);
            if (childAt.getVisibility() != 8) {
                androidx.appcompat.widget.ActionBarOverlayLayout.b_renamed bVar = (androidx.appcompat.widget.ActionBarOverlayLayout.b_renamed) childAt.getLayoutParams();
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                int i6 = bVar.leftMargin + paddingLeft;
                int i7 = bVar.topMargin + paddingTop;
                childAt.layout(i6, i7, measuredWidth + i6, measuredHeight + i7);
            }
        }
    }

    @Override // android.view.View
    public void draw(android.graphics.Canvas canvas) {
        super.draw(canvas);
        if (this.j_renamed == null || this.k_renamed) {
            return;
        }
        int bottom = this.f424a.getVisibility() == 0 ? (int) (this.f424a.getBottom() + this.f424a.getTranslationY() + 0.5f) : 0;
        this.j_renamed.setBounds(0, bottom, getWidth(), this.j_renamed.getIntrinsicHeight() + bottom);
        this.j_renamed.draw(canvas);
    }

    @Override // androidx.core.h_renamed.o_renamed
    public void onNestedScroll(android.view.View view, int i_renamed, int i2, int i3, int i4, int i5, int[] iArr) {
        onNestedScroll(view, i_renamed, i2, i3, i4, i5);
    }

    @Override // androidx.core.h_renamed.n_renamed
    public boolean onStartNestedScroll(android.view.View view, android.view.View view2, int i_renamed, int i2) {
        return i2 == 0 && onStartNestedScroll(view, view2, i_renamed);
    }

    @Override // androidx.core.h_renamed.n_renamed
    public void onNestedScrollAccepted(android.view.View view, android.view.View view2, int i_renamed, int i2) {
        if (i2 == 0) {
            onNestedScrollAccepted(view, view2, i_renamed);
        }
    }

    @Override // androidx.core.h_renamed.n_renamed
    public void onStopNestedScroll(android.view.View view, int i_renamed) {
        if (i_renamed == 0) {
            onStopNestedScroll(view);
        }
    }

    @Override // androidx.core.h_renamed.n_renamed
    public void onNestedScroll(android.view.View view, int i_renamed, int i2, int i3, int i4, int i5) {
        if (i5 == 0) {
            onNestedScroll(view, i_renamed, i2, i3, i4);
        }
    }

    @Override // androidx.core.h_renamed.n_renamed
    public void onNestedPreScroll(android.view.View view, int i_renamed, int i2, int[] iArr, int i3) {
        if (i3 == 0) {
            onNestedPreScroll(view, i_renamed, i2, iArr);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.h_renamed.m_renamed
    public boolean onStartNestedScroll(android.view.View view, android.view.View view2, int i_renamed) {
        if ((i_renamed & 2) == 0 || this.f424a.getVisibility() != 0) {
            return false;
        }
        return this.n_renamed;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.h_renamed.m_renamed
    public void onNestedScrollAccepted(android.view.View view, android.view.View view2, int i_renamed) {
        this.B_renamed.a_renamed(view, view2, i_renamed);
        this.o_renamed = getActionBarHideOffset();
        d_renamed();
        androidx.appcompat.widget.ActionBarOverlayLayout.a_renamed aVar = this.x_renamed;
        if (aVar != null) {
            aVar.l_renamed();
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.h_renamed.m_renamed
    public void onNestedScroll(android.view.View view, int i_renamed, int i2, int i3, int i4) {
        this.o_renamed += i2;
        setActionBarHideOffset(this.o_renamed);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.h_renamed.m_renamed
    public void onStopNestedScroll(android.view.View view) {
        if (this.n_renamed && !this.f425b) {
            if (this.o_renamed <= this.f424a.getHeight()) {
                l_renamed();
            } else {
                m_renamed();
            }
        }
        androidx.appcompat.widget.ActionBarOverlayLayout.a_renamed aVar = this.x_renamed;
        if (aVar != null) {
            aVar.m_renamed();
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.h_renamed.m_renamed
    public boolean onNestedFling(android.view.View view, float f_renamed, float f2, boolean z_renamed) {
        if (!this.n_renamed || !z_renamed) {
            return false;
        }
        if (a_renamed(f_renamed, f2)) {
            o_renamed();
        } else {
            n_renamed();
        }
        this.f425b = true;
        return true;
    }

    @Override // android.view.ViewGroup
    public int getNestedScrollAxes() {
        return this.B_renamed.a_renamed();
    }

    void c_renamed() {
        if (this.h_renamed == null) {
            this.h_renamed = (androidx.appcompat.widget.ContentFrameLayout) findViewById(androidx.appcompat.R_renamed.id_renamed.action_bar_activity_content);
            this.f424a = (androidx.appcompat.widget.ActionBarContainer) findViewById(androidx.appcompat.R_renamed.id_renamed.action_bar_container);
            this.i_renamed = a_renamed(findViewById(androidx.appcompat.R_renamed.id_renamed.action_bar));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private androidx.appcompat.widget.z_renamed a_renamed(android.view.View view) {
        if (view instanceof androidx.appcompat.widget.z_renamed) {
            return (androidx.appcompat.widget.z_renamed) view;
        }
        if (view instanceof androidx.appcompat.widget.Toolbar) {
            return ((androidx.appcompat.widget.Toolbar) view).getWrapper();
        }
        throw new java.lang.IllegalStateException("Can't_renamed make a_renamed decor toolbar out of_renamed " + view.getClass().getSimpleName());
    }

    public void setHideOnContentScrollEnabled(boolean z_renamed) {
        if (z_renamed != this.n_renamed) {
            this.n_renamed = z_renamed;
            if (z_renamed) {
                return;
            }
            d_renamed();
            setActionBarHideOffset(0);
        }
    }

    public int getActionBarHideOffset() {
        androidx.appcompat.widget.ActionBarContainer actionBarContainer = this.f424a;
        if (actionBarContainer != null) {
            return -((int) actionBarContainer.getTranslationY());
        }
        return 0;
    }

    public void setActionBarHideOffset(int i_renamed) {
        d_renamed();
        this.f424a.setTranslationY(-java.lang.Math.max(0, java.lang.Math.min(i_renamed, this.f424a.getHeight())));
    }

    void d_renamed() {
        removeCallbacks(this.z_renamed);
        removeCallbacks(this.A_renamed);
        android.view.ViewPropertyAnimator viewPropertyAnimator = this.f426c;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
        }
    }

    private void l_renamed() {
        d_renamed();
        postDelayed(this.z_renamed, 600L);
    }

    private void m_renamed() {
        d_renamed();
        postDelayed(this.A_renamed, 600L);
    }

    private void n_renamed() {
        d_renamed();
        this.z_renamed.run();
    }

    private void o_renamed() {
        d_renamed();
        this.A_renamed.run();
    }

    private boolean a_renamed(float f_renamed, float f2) {
        this.y_renamed.fling(0, 0, 0, (int) f2, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
        return this.y_renamed.getFinalY() > this.f424a.getHeight();
    }

    @Override // androidx.appcompat.widget.y_renamed
    public void setWindowCallback(android.view.Window.Callback callback) {
        c_renamed();
        this.i_renamed.a_renamed(callback);
    }

    @Override // androidx.appcompat.widget.y_renamed
    public void setWindowTitle(java.lang.CharSequence charSequence) {
        c_renamed();
        this.i_renamed.a_renamed(charSequence);
    }

    public java.lang.CharSequence getTitle() {
        c_renamed();
        return this.i_renamed.e_renamed();
    }

    @Override // androidx.appcompat.widget.y_renamed
    public void a_renamed(int i_renamed) {
        c_renamed();
        if (i_renamed == 2) {
            this.i_renamed.f_renamed();
        } else if (i_renamed == 5) {
            this.i_renamed.g_renamed();
        } else {
            if (i_renamed != 109) {
                return;
            }
            setOverlayMode(true);
        }
    }

    public void setIcon(int i_renamed) {
        c_renamed();
        this.i_renamed.a_renamed(i_renamed);
    }

    public void setIcon(android.graphics.drawable.Drawable drawable) {
        c_renamed();
        this.i_renamed.a_renamed(drawable);
    }

    public void setLogo(int i_renamed) {
        c_renamed();
        this.i_renamed.b_renamed(i_renamed);
    }

    @Override // androidx.appcompat.widget.y_renamed
    public boolean e_renamed() {
        c_renamed();
        return this.i_renamed.h_renamed();
    }

    @Override // androidx.appcompat.widget.y_renamed
    public boolean f_renamed() {
        c_renamed();
        return this.i_renamed.i_renamed();
    }

    @Override // androidx.appcompat.widget.y_renamed
    public boolean g_renamed() {
        c_renamed();
        return this.i_renamed.j_renamed();
    }

    @Override // androidx.appcompat.widget.y_renamed
    public boolean h_renamed() {
        c_renamed();
        return this.i_renamed.k_renamed();
    }

    @Override // androidx.appcompat.widget.y_renamed
    public boolean i_renamed() {
        c_renamed();
        return this.i_renamed.l_renamed();
    }

    @Override // androidx.appcompat.widget.y_renamed
    public void j_renamed() {
        c_renamed();
        this.i_renamed.m_renamed();
    }

    @Override // androidx.appcompat.widget.y_renamed
    public void a_renamed(android.view.Menu menu, androidx.appcompat.view.menu.n_renamed.a_renamed aVar) {
        c_renamed();
        this.i_renamed.a_renamed(menu, aVar);
    }

    @Override // androidx.appcompat.widget.y_renamed
    public void k_renamed() {
        c_renamed();
        this.i_renamed.n_renamed();
    }

    public static class b_renamed extends android.view.ViewGroup.MarginLayoutParams {
        public b_renamed(android.content.Context context, android.util.AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public b_renamed(int i_renamed, int i2) {
            super(i_renamed, i2);
        }

        public b_renamed(android.view.ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }
}

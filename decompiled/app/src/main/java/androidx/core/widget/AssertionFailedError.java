package androidx.core.widget;

/* loaded from: classes.dex */
public class NestedScrollView extends android.widget.FrameLayout implements androidx.core.h_renamed.k_renamed, androidx.core.h_renamed.o_renamed, androidx.core.h_renamed.t_renamed {
    private static final androidx.core.widget.NestedScrollView.a_renamed w_renamed = new androidx.core.widget.NestedScrollView.a_renamed();
    private static final int[] x_renamed = {android.R_renamed.attr.fillViewport};
    private float A_renamed;
    private androidx.core.widget.NestedScrollView.b_renamed B_renamed;

    /* renamed from: a_renamed, reason: collision with root package name */
    private long f1015a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private final android.graphics.Rect f1016b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private android.widget.OverScroller f1017c;
    private android.widget.EdgeEffect d_renamed;
    private android.widget.EdgeEffect e_renamed;
    private int f_renamed;
    private boolean g_renamed;
    private boolean h_renamed;
    private android.view.View i_renamed;
    private boolean j_renamed;
    private android.view.VelocityTracker k_renamed;
    private boolean l_renamed;
    private boolean m_renamed;
    private int n_renamed;
    private int o_renamed;
    private int p_renamed;
    private int q_renamed;
    private final int[] r_renamed;
    private final int[] s_renamed;
    private int t_renamed;
    private int u_renamed;
    private androidx.core.widget.NestedScrollView.SavedState v_renamed;
    private final androidx.core.h_renamed.p_renamed y_renamed;
    private final androidx.core.h_renamed.l_renamed z_renamed;

    public interface b_renamed {
        void a_renamed(androidx.core.widget.NestedScrollView nestedScrollView, int i_renamed, int i2, int i3, int i4);
    }

    private static int b_renamed(int i_renamed, int i2, int i3) {
        if (i2 >= i3 || i_renamed < 0) {
            return 0;
        }
        return i2 + i_renamed > i3 ? i3 - i2 : i_renamed;
    }

    @Override // androidx.core.h_renamed.n_renamed
    public boolean onStartNestedScroll(android.view.View view, android.view.View view2, int i_renamed, int i2) {
        return (i_renamed & 2) != 0;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return true;
    }

    public NestedScrollView(android.content.Context context) {
        this(context, null);
    }

    public NestedScrollView(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NestedScrollView(android.content.Context context, android.util.AttributeSet attributeSet, int i_renamed) {
        super(context, attributeSet, i_renamed);
        this.f1016b = new android.graphics.Rect();
        this.g_renamed = true;
        this.h_renamed = false;
        this.i_renamed = null;
        this.j_renamed = false;
        this.m_renamed = true;
        this.q_renamed = -1;
        this.r_renamed = new int[2];
        this.s_renamed = new int[2];
        a_renamed();
        android.content.res.TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, x_renamed, i_renamed, 0);
        setFillViewport(typedArrayObtainStyledAttributes.getBoolean(0, false));
        typedArrayObtainStyledAttributes.recycle();
        this.y_renamed = new androidx.core.h_renamed.p_renamed(this);
        this.z_renamed = new androidx.core.h_renamed.l_renamed(this);
        setNestedScrollingEnabled(true);
        androidx.core.h_renamed.v_renamed.a_renamed(this, w_renamed);
    }

    public void a_renamed(int i_renamed, int i2, int i3, int i4, int[] iArr, int i5, int[] iArr2) {
        this.z_renamed.a_renamed(i_renamed, i2, i3, i4, iArr, i5, iArr2);
    }

    public boolean a_renamed(int i_renamed, int i2) {
        return this.z_renamed.a_renamed(i_renamed, i2);
    }

    public void a_renamed(int i_renamed) {
        this.z_renamed.c_renamed(i_renamed);
    }

    public boolean b_renamed(int i_renamed) {
        return this.z_renamed.a_renamed(i_renamed);
    }

    public boolean a_renamed(int i_renamed, int i2, int[] iArr, int[] iArr2, int i3) {
        return this.z_renamed.a_renamed(i_renamed, i2, iArr, iArr2, i3);
    }

    @Override // android.view.View, androidx.core.h_renamed.i_renamed
    public void setNestedScrollingEnabled(boolean z_renamed) {
        this.z_renamed.a_renamed(z_renamed);
    }

    @Override // android.view.View, androidx.core.h_renamed.i_renamed
    public boolean isNestedScrollingEnabled() {
        return this.z_renamed.a_renamed();
    }

    @Override // android.view.View
    public boolean startNestedScroll(int i_renamed) {
        return a_renamed(i_renamed, 0);
    }

    @Override // android.view.View, androidx.core.h_renamed.i_renamed
    public void stopNestedScroll() {
        a_renamed(0);
    }

    @Override // android.view.View
    public boolean hasNestedScrollingParent() {
        return b_renamed(0);
    }

    @Override // android.view.View
    public boolean dispatchNestedScroll(int i_renamed, int i2, int i3, int i4, int[] iArr) {
        return this.z_renamed.a_renamed(i_renamed, i2, i3, i4, iArr);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreScroll(int i_renamed, int i2, int[] iArr, int[] iArr2) {
        return a_renamed(i_renamed, i2, iArr, iArr2, 0);
    }

    @Override // android.view.View
    public boolean dispatchNestedFling(float f_renamed, float f2, boolean z_renamed) {
        return this.z_renamed.a_renamed(f_renamed, f2, z_renamed);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreFling(float f_renamed, float f2) {
        return this.z_renamed.a_renamed(f_renamed, f2);
    }

    @Override // androidx.core.h_renamed.o_renamed
    public void onNestedScroll(android.view.View view, int i_renamed, int i2, int i3, int i4, int i5, int[] iArr) {
        a_renamed(i4, i5, iArr);
    }

    private void a_renamed(int i_renamed, int i2, int[] iArr) {
        int scrollY = getScrollY();
        scrollBy(0, i_renamed);
        int scrollY2 = getScrollY() - scrollY;
        if (iArr != null) {
            iArr[1] = iArr[1] + scrollY2;
        }
        this.z_renamed.a_renamed(0, scrollY2, 0, i_renamed - scrollY2, null, i2, iArr);
    }

    @Override // androidx.core.h_renamed.n_renamed
    public void onNestedScrollAccepted(android.view.View view, android.view.View view2, int i_renamed, int i2) {
        this.y_renamed.a_renamed(view, view2, i_renamed, i2);
        a_renamed(2, i2);
    }

    @Override // androidx.core.h_renamed.n_renamed
    public void onStopNestedScroll(android.view.View view, int i_renamed) {
        this.y_renamed.a_renamed(view, i_renamed);
        a_renamed(i_renamed);
    }

    @Override // androidx.core.h_renamed.n_renamed
    public void onNestedScroll(android.view.View view, int i_renamed, int i2, int i3, int i4, int i5) {
        a_renamed(i4, i5, (int[]) null);
    }

    @Override // androidx.core.h_renamed.n_renamed
    public void onNestedPreScroll(android.view.View view, int i_renamed, int i2, int[] iArr, int i3) {
        a_renamed(i_renamed, i2, iArr, null, i3);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.h_renamed.m_renamed
    public boolean onStartNestedScroll(android.view.View view, android.view.View view2, int i_renamed) {
        return onStartNestedScroll(view, view2, i_renamed, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.h_renamed.m_renamed
    public void onNestedScrollAccepted(android.view.View view, android.view.View view2, int i_renamed) {
        onNestedScrollAccepted(view, view2, i_renamed, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.h_renamed.m_renamed
    public void onStopNestedScroll(android.view.View view) {
        onStopNestedScroll(view, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.h_renamed.m_renamed
    public void onNestedScroll(android.view.View view, int i_renamed, int i2, int i3, int i4) {
        a_renamed(i4, 0, (int[]) null);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.h_renamed.m_renamed
    public void onNestedPreScroll(android.view.View view, int i_renamed, int i2, int[] iArr) {
        onNestedPreScroll(view, i_renamed, i2, iArr, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.h_renamed.m_renamed
    public boolean onNestedFling(android.view.View view, float f_renamed, float f2, boolean z_renamed) {
        if (z_renamed) {
            return false;
        }
        dispatchNestedFling(0.0f, f2, true);
        f_renamed((int) f2);
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.h_renamed.m_renamed
    public boolean onNestedPreFling(android.view.View view, float f_renamed, float f2) {
        return dispatchNestedPreFling(f_renamed, f2);
    }

    @Override // android.view.ViewGroup
    public int getNestedScrollAxes() {
        return this.y_renamed.a_renamed();
    }

    @Override // android.view.View
    protected float getTopFadingEdgeStrength() {
        if (getChildCount() == 0) {
            return 0.0f;
        }
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        int scrollY = getScrollY();
        if (scrollY < verticalFadingEdgeLength) {
            return scrollY / verticalFadingEdgeLength;
        }
        return 1.0f;
    }

    @Override // android.view.View
    protected float getBottomFadingEdgeStrength() {
        if (getChildCount() == 0) {
            return 0.0f;
        }
        android.view.View childAt = getChildAt(0);
        android.widget.FrameLayout.LayoutParams layoutParams = (android.widget.FrameLayout.LayoutParams) childAt.getLayoutParams();
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        int bottom = ((childAt.getBottom() + layoutParams.bottomMargin) - getScrollY()) - (getHeight() - getPaddingBottom());
        if (bottom < verticalFadingEdgeLength) {
            return bottom / verticalFadingEdgeLength;
        }
        return 1.0f;
    }

    public int getMaxScrollAmount() {
        return (int) (getHeight() * 0.5f);
    }

    private void a_renamed() {
        this.f1017c = new android.widget.OverScroller(getContext());
        setFocusable(true);
        setDescendantFocusability(com.sensetime.stmobile.STMobileHumanActionNative.ST_MOBILE_DETECT_MODE_IMAGE);
        setWillNotDraw(false);
        android.view.ViewConfiguration viewConfiguration = android.view.ViewConfiguration.get(getContext());
        this.n_renamed = viewConfiguration.getScaledTouchSlop();
        this.o_renamed = viewConfiguration.getScaledMinimumFlingVelocity();
        this.p_renamed = viewConfiguration.getScaledMaximumFlingVelocity();
    }

    @Override // android.view.ViewGroup
    public void addView(android.view.View view) {
        if (getChildCount() > 0) {
            throw new java.lang.IllegalStateException("ScrollView can host only one direct child");
        }
        super.addView(view);
    }

    @Override // android.view.ViewGroup
    public void addView(android.view.View view, int i_renamed) {
        if (getChildCount() > 0) {
            throw new java.lang.IllegalStateException("ScrollView can host only one direct child");
        }
        super.addView(view, i_renamed);
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void addView(android.view.View view, android.view.ViewGroup.LayoutParams layoutParams) {
        if (getChildCount() > 0) {
            throw new java.lang.IllegalStateException("ScrollView can host only one direct child");
        }
        super.addView(view, layoutParams);
    }

    @Override // android.view.ViewGroup
    public void addView(android.view.View view, int i_renamed, android.view.ViewGroup.LayoutParams layoutParams) {
        if (getChildCount() > 0) {
            throw new java.lang.IllegalStateException("ScrollView can host only one direct child");
        }
        super.addView(view, i_renamed, layoutParams);
    }

    public void setOnScrollChangeListener(androidx.core.widget.NestedScrollView.b_renamed bVar) {
        this.B_renamed = bVar;
    }

    private boolean b_renamed() {
        if (getChildCount() <= 0) {
            return false;
        }
        android.view.View childAt = getChildAt(0);
        android.widget.FrameLayout.LayoutParams layoutParams = (android.widget.FrameLayout.LayoutParams) childAt.getLayoutParams();
        return (childAt.getHeight() + layoutParams.topMargin) + layoutParams.bottomMargin > (getHeight() - getPaddingTop()) - getPaddingBottom();
    }

    public void setFillViewport(boolean z_renamed) {
        if (z_renamed != this.l_renamed) {
            this.l_renamed = z_renamed;
            requestLayout();
        }
    }

    public void setSmoothScrollingEnabled(boolean z_renamed) {
        this.m_renamed = z_renamed;
    }

    @Override // android.view.View
    protected void onScrollChanged(int i_renamed, int i2, int i3, int i4) {
        super.onScrollChanged(i_renamed, i2, i3, i4);
        androidx.core.widget.NestedScrollView.b_renamed bVar = this.B_renamed;
        if (bVar != null) {
            bVar.a_renamed(this, i_renamed, i2, i3, i4);
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i_renamed, int i2) {
        super.onMeasure(i_renamed, i2);
        if (this.l_renamed && android.view.View.MeasureSpec.getMode(i2) != 0 && getChildCount() > 0) {
            android.view.View childAt = getChildAt(0);
            android.widget.FrameLayout.LayoutParams layoutParams = (android.widget.FrameLayout.LayoutParams) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight();
            int measuredHeight2 = (((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom()) - layoutParams.topMargin) - layoutParams.bottomMargin;
            if (measuredHeight < measuredHeight2) {
                childAt.measure(getChildMeasureSpec(i_renamed, getPaddingLeft() + getPaddingRight() + layoutParams.leftMargin + layoutParams.rightMargin, layoutParams.width), android.view.View.MeasureSpec.makeMeasureSpec(measuredHeight2, 1073741824));
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(android.view.KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent) || a_renamed(keyEvent);
    }

    public boolean a_renamed(android.view.KeyEvent keyEvent) {
        this.f1016b.setEmpty();
        if (!b_renamed()) {
            if (!isFocused() || keyEvent.getKeyCode() == 4) {
                return false;
            }
            android.view.View viewFindFocus = findFocus();
            if (viewFindFocus == this) {
                viewFindFocus = null;
            }
            android.view.View viewFindNextFocus = android.view.FocusFinder.getInstance().findNextFocus(this, viewFindFocus, 130);
            return (viewFindNextFocus == null || viewFindNextFocus == this || !viewFindNextFocus.requestFocus(130)) ? false : true;
        }
        if (keyEvent.getAction() != 0) {
            return false;
        }
        int keyCode = keyEvent.getKeyCode();
        if (keyCode == 19) {
            if (!keyEvent.isAltPressed()) {
                return e_renamed(33);
            }
            return d_renamed(33);
        }
        if (keyCode == 20) {
            if (!keyEvent.isAltPressed()) {
                return e_renamed(130);
            }
            return d_renamed(130);
        }
        if (keyCode != 62) {
            return false;
        }
        c_renamed(keyEvent.isShiftPressed() ? 33 : 130);
        return false;
    }

    private boolean c_renamed(int i_renamed, int i2) {
        if (getChildCount() <= 0) {
            return false;
        }
        int scrollY = getScrollY();
        android.view.View childAt = getChildAt(0);
        return i2 >= childAt.getTop() - scrollY && i2 < childAt.getBottom() - scrollY && i_renamed >= childAt.getLeft() && i_renamed < childAt.getRight();
    }

    private void c_renamed() {
        android.view.VelocityTracker velocityTracker = this.k_renamed;
        if (velocityTracker == null) {
            this.k_renamed = android.view.VelocityTracker.obtain();
        } else {
            velocityTracker.clear();
        }
    }

    private void d_renamed() {
        if (this.k_renamed == null) {
            this.k_renamed = android.view.VelocityTracker.obtain();
        }
    }

    private void e_renamed() {
        android.view.VelocityTracker velocityTracker = this.k_renamed;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.k_renamed = null;
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z_renamed) {
        if (z_renamed) {
            e_renamed();
        }
        super.requestDisallowInterceptTouchEvent(z_renamed);
    }

    /* JADX WARN: Removed duplicated region for block: B_renamed:31:0x007d  */
    @Override // android.view.ViewGroup
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onInterceptTouchEvent(android.view.MotionEvent r12) {
        /*
            r11 = this;
            int r0 = r12.getAction()
            r1 = 2
            r2 = 1
            if (r0 != r1) goto Ld
            boolean r3 = r11.j_renamed
            if (r3 == 0) goto Ld
            return r2
        Ld:
            r0 = r0 & 255(0xff, float:3.57E-43)
            r3 = 0
            if (r0 == 0) goto La2
            r4 = -1
            if (r0 == r2) goto L7d
            if (r0 == r1) goto L24
            r1 = 3
            if (r0 == r1) goto L7d
            r1 = 6
            if (r0 == r1) goto L1f
            goto Ld9
        L1f:
            r11.a_renamed(r12)
            goto Ld9
        L24:
            int r0 = r11.q_renamed
            if (r0 != r4) goto L2a
            goto Ld9
        L2a:
            int r5 = r12.findPointerIndex(r0)
            if (r5 != r4) goto L4d
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            java.lang.String r1 = "Invalid pointerId="
            r12.append(r1)
            r12.append(r0)
            java.lang.String r0 = " in_renamed onInterceptTouchEvent"
            r12.append(r0)
            java.lang.String r12 = r12.toString()
            java.lang.String r0 = "NestedScrollView"
            android.util.Log.e_renamed(r0, r12)
            goto Ld9
        L4d:
            float r0 = r12.getY(r5)
            int r0 = (int) r0
            int r4 = r11.f_renamed
            int r4 = r0 - r4
            int r4 = java.lang.Math.abs(r4)
            int r5 = r11.n_renamed
            if (r4 <= r5) goto Ld9
            int r4 = r11.getNestedScrollAxes()
            r1 = r1 & r4
            if (r1 != 0) goto Ld9
            r11.j_renamed = r2
            r11.f_renamed = r0
            r11.d_renamed()
            android.view.VelocityTracker r0 = r11.k_renamed
            r0.addMovement(r12)
            r11.t_renamed = r3
            android.view.ViewParent r12 = r11.getParent()
            if (r12 == 0) goto Ld9
            r12.requestDisallowInterceptTouchEvent(r2)
            goto Ld9
        L7d:
            r11.j_renamed = r3
            r11.q_renamed = r4
            r11.e_renamed()
            android.widget.OverScroller r4 = r11.f1017c
            int r5 = r11.getScrollX()
            int r6 = r11.getScrollY()
            r7 = 0
            r8 = 0
            r9 = 0
            int r10 = r11.getScrollRange()
            boolean r12 = r4.springBack(r5, r6, r7, r8, r9, r10)
            if (r12 == 0) goto L9e
            androidx.core.h_renamed.v_renamed.e_renamed(r11)
        L9e:
            r11.a_renamed(r3)
            goto Ld9
        La2:
            float r0 = r12.getY()
            int r0 = (int) r0
            float r4 = r12.getX()
            int r4 = (int) r4
            boolean r4 = r11.c_renamed(r4, r0)
            if (r4 != 0) goto Lb8
            r11.j_renamed = r3
            r11.e_renamed()
            goto Ld9
        Lb8:
            r11.f_renamed = r0
            int r0 = r12.getPointerId(r3)
            r11.q_renamed = r0
            r11.c_renamed()
            android.view.VelocityTracker r0 = r11.k_renamed
            r0.addMovement(r12)
            android.widget.OverScroller r12 = r11.f1017c
            r12.computeScrollOffset()
            android.widget.OverScroller r12 = r11.f1017c
            boolean r12 = r12.isFinished()
            r12 = r12 ^ r2
            r11.j_renamed = r12
            r11.a_renamed(r1, r3)
        Ld9:
            boolean r11 = r11.j_renamed
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.widget.NestedScrollView.onInterceptTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.view.View
    public boolean onTouchEvent(android.view.MotionEvent motionEvent) {
        android.view.ViewParent parent;
        d_renamed();
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.t_renamed = 0;
        }
        android.view.MotionEvent motionEventObtain = android.view.MotionEvent.obtain(motionEvent);
        motionEventObtain.offsetLocation(0.0f, this.t_renamed);
        if (actionMasked != 0) {
            if (actionMasked == 1) {
                android.view.VelocityTracker velocityTracker = this.k_renamed;
                velocityTracker.computeCurrentVelocity(1000, this.p_renamed);
                int yVelocity = (int) velocityTracker.getYVelocity(this.q_renamed);
                if (java.lang.Math.abs(yVelocity) >= this.o_renamed) {
                    int i_renamed = -yVelocity;
                    float f_renamed = i_renamed;
                    if (!dispatchNestedPreFling(0.0f, f_renamed)) {
                        dispatchNestedFling(0.0f, f_renamed, true);
                        f_renamed(i_renamed);
                    }
                } else if (this.f1017c.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange())) {
                    androidx.core.h_renamed.v_renamed.e_renamed(this);
                }
                this.q_renamed = -1;
                g_renamed();
            } else if (actionMasked == 2) {
                int iFindPointerIndex = motionEvent.findPointerIndex(this.q_renamed);
                if (iFindPointerIndex == -1) {
                    android.util.Log.e_renamed("NestedScrollView", "Invalid pointerId=" + this.q_renamed + " in_renamed onTouchEvent");
                } else {
                    int y_renamed = (int) motionEvent.getY(iFindPointerIndex);
                    int i2 = this.f_renamed - y_renamed;
                    if (!this.j_renamed && java.lang.Math.abs(i2) > this.n_renamed) {
                        android.view.ViewParent parent2 = getParent();
                        if (parent2 != null) {
                            parent2.requestDisallowInterceptTouchEvent(true);
                        }
                        this.j_renamed = true;
                        i2 = i2 > 0 ? i2 - this.n_renamed : i2 + this.n_renamed;
                    }
                    int i3 = i2;
                    if (this.j_renamed) {
                        if (a_renamed(0, i3, this.s_renamed, this.r_renamed, 0)) {
                            i3 -= this.s_renamed[1];
                            this.t_renamed += this.r_renamed[1];
                        }
                        int i4 = i3;
                        this.f_renamed = y_renamed - this.r_renamed[1];
                        int scrollY = getScrollY();
                        int scrollRange = getScrollRange();
                        int overScrollMode = getOverScrollMode();
                        boolean z_renamed = overScrollMode == 0 || (overScrollMode == 1 && scrollRange > 0);
                        if (a_renamed(0, i4, 0, getScrollY(), 0, scrollRange, 0, 0, true) && !b_renamed(0)) {
                            this.k_renamed.clear();
                        }
                        int scrollY2 = getScrollY() - scrollY;
                        int[] iArr = this.s_renamed;
                        iArr[1] = 0;
                        a_renamed(0, scrollY2, 0, i4 - scrollY2, this.r_renamed, 0, iArr);
                        int i5 = this.f_renamed;
                        int[] iArr2 = this.r_renamed;
                        this.f_renamed = i5 - iArr2[1];
                        this.t_renamed += iArr2[1];
                        if (z_renamed) {
                            int i6 = i4 - this.s_renamed[1];
                            h_renamed();
                            int i7 = scrollY + i6;
                            if (i7 < 0) {
                                androidx.core.widget.d_renamed.a_renamed(this.d_renamed, i6 / getHeight(), motionEvent.getX(iFindPointerIndex) / getWidth());
                                if (!this.e_renamed.isFinished()) {
                                    this.e_renamed.onRelease();
                                }
                            } else if (i7 > scrollRange) {
                                androidx.core.widget.d_renamed.a_renamed(this.e_renamed, i6 / getHeight(), 1.0f - (motionEvent.getX(iFindPointerIndex) / getWidth()));
                                if (!this.d_renamed.isFinished()) {
                                    this.d_renamed.onRelease();
                                }
                            }
                            android.widget.EdgeEffect edgeEffect = this.d_renamed;
                            if (edgeEffect != null && (!edgeEffect.isFinished() || !this.e_renamed.isFinished())) {
                                androidx.core.h_renamed.v_renamed.e_renamed(this);
                            }
                        }
                    }
                }
            } else if (actionMasked == 3) {
                if (this.j_renamed && getChildCount() > 0 && this.f1017c.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange())) {
                    androidx.core.h_renamed.v_renamed.e_renamed(this);
                }
                this.q_renamed = -1;
                g_renamed();
            } else if (actionMasked == 5) {
                int actionIndex = motionEvent.getActionIndex();
                this.f_renamed = (int) motionEvent.getY(actionIndex);
                this.q_renamed = motionEvent.getPointerId(actionIndex);
            } else if (actionMasked == 6) {
                a_renamed(motionEvent);
                this.f_renamed = (int) motionEvent.getY(motionEvent.findPointerIndex(this.q_renamed));
            }
        } else {
            if (getChildCount() == 0) {
                return false;
            }
            boolean z2 = !this.f1017c.isFinished();
            this.j_renamed = z2;
            if (z2 && (parent = getParent()) != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
            if (!this.f1017c.isFinished()) {
                f_renamed();
            }
            this.f_renamed = (int) motionEvent.getY();
            this.q_renamed = motionEvent.getPointerId(0);
            a_renamed(2, 0);
        }
        android.view.VelocityTracker velocityTracker2 = this.k_renamed;
        if (velocityTracker2 != null) {
            velocityTracker2.addMovement(motionEventObtain);
        }
        motionEventObtain.recycle();
        return true;
    }

    private void a_renamed(android.view.MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.q_renamed) {
            int i_renamed = actionIndex == 0 ? 1 : 0;
            this.f_renamed = (int) motionEvent.getY(i_renamed);
            this.q_renamed = motionEvent.getPointerId(i_renamed);
            android.view.VelocityTracker velocityTracker = this.k_renamed;
            if (velocityTracker != null) {
                velocityTracker.clear();
            }
        }
    }

    @Override // android.view.View
    public boolean onGenericMotionEvent(android.view.MotionEvent motionEvent) {
        if ((motionEvent.getSource() & 2) != 0 && motionEvent.getAction() == 8 && !this.j_renamed) {
            float axisValue = motionEvent.getAxisValue(9);
            if (axisValue != 0.0f) {
                int verticalScrollFactorCompat = (int) (axisValue * getVerticalScrollFactorCompat());
                int scrollRange = getScrollRange();
                int scrollY = getScrollY();
                int i_renamed = scrollY - verticalScrollFactorCompat;
                if (i_renamed < 0) {
                    i_renamed = 0;
                } else if (i_renamed > scrollRange) {
                    i_renamed = scrollRange;
                }
                if (i_renamed != scrollY) {
                    super.scrollTo(getScrollX(), i_renamed);
                    return true;
                }
            }
        }
        return false;
    }

    private float getVerticalScrollFactorCompat() {
        if (this.A_renamed == 0.0f) {
            android.util.TypedValue typedValue = new android.util.TypedValue();
            android.content.Context context = getContext();
            if (!context.getTheme().resolveAttribute(android.R_renamed.attr.listPreferredItemHeight, typedValue, true)) {
                throw new java.lang.IllegalStateException("Expected theme to define listPreferredItemHeight.");
            }
            this.A_renamed = typedValue.getDimension(context.getResources().getDisplayMetrics());
        }
        return this.A_renamed;
    }

    @Override // android.view.View
    protected void onOverScrolled(int i_renamed, int i2, boolean z_renamed, boolean z2) {
        super.scrollTo(i_renamed, i2);
    }

    /* JADX WARN: Removed duplicated region for block: B_renamed:38:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:39:0x005a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    boolean a_renamed(int r13, int r14, int r15, int r16, int r17, int r18, int r19, int r20, boolean r21) {
        /*
            r12 = this;
            r0 = r12
            int r1 = r12.getOverScrollMode()
            int r2 = r12.computeHorizontalScrollRange()
            int r3 = r12.computeHorizontalScrollExtent()
            r4 = 0
            r5 = 1
            if (r2 <= r3) goto L13
            r2 = r5
            goto L14
        L13:
            r2 = r4
        L14:
            int r3 = r12.computeVerticalScrollRange()
            int r6 = r12.computeVerticalScrollExtent()
            if (r3 <= r6) goto L20
            r3 = r5
            goto L21
        L20:
            r3 = r4
        L21:
            if (r1 == 0) goto L2a
            if (r1 != r5) goto L28
            if (r2 == 0) goto L28
            goto L2a
        L28:
            r2 = r4
            goto L2b
        L2a:
            r2 = r5
        L2b:
            if (r1 == 0) goto L34
            if (r1 != r5) goto L32
            if (r3 == 0) goto L32
            goto L34
        L32:
            r1 = r4
            goto L35
        L34:
            r1 = r5
        L35:
            int r3 = r15 + r13
            if (r2 != 0) goto L3b
            r2 = r4
            goto L3d
        L3b:
            r2 = r19
        L3d:
            int r6 = r16 + r14
            if (r1 != 0) goto L43
            r1 = r4
            goto L45
        L43:
            r1 = r20
        L45:
            int r7 = -r2
            int r2 = r2 + r17
            int r8 = -r1
            int r1 = r1 + r18
            if (r3 <= r2) goto L50
            r7 = r2
        L4e:
            r2 = r5
            goto L55
        L50:
            if (r3 >= r7) goto L53
            goto L4e
        L53:
            r7 = r3
            r2 = r4
        L55:
            if (r6 <= r1) goto L5a
            r6 = r1
            r1 = r5
            goto L60
        L5a:
            if (r6 >= r8) goto L5f
            r1 = r5
            r6 = r8
            goto L60
        L5f:
            r1 = r4
        L60:
            if (r1 == 0) goto L7f
            boolean r3 = r12.b_renamed(r5)
            if (r3 != 0) goto L7f
            android.widget.OverScroller r3 = r0.f1017c
            r8 = 0
            r9 = 0
            r10 = 0
            int r11 = r12.getScrollRange()
            r13 = r3
            r14 = r7
            r15 = r6
            r16 = r8
            r17 = r9
            r18 = r10
            r19 = r11
            r13.springBack(r14, r15, r16, r17, r18, r19)
        L7f:
            r12.onOverScrolled(r7, r6, r2, r1)
            if (r2 != 0) goto L86
            if (r1 == 0) goto L87
        L86:
            r4 = r5
        L87:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.widget.NestedScrollView.a_renamed(int, int, int, int, int, int, int, int, boolean):boolean");
    }

    int getScrollRange() {
        if (getChildCount() <= 0) {
            return 0;
        }
        android.view.View childAt = getChildAt(0);
        android.widget.FrameLayout.LayoutParams layoutParams = (android.widget.FrameLayout.LayoutParams) childAt.getLayoutParams();
        return java.lang.Math.max(0, ((childAt.getHeight() + layoutParams.topMargin) + layoutParams.bottomMargin) - ((getHeight() - getPaddingTop()) - getPaddingBottom()));
    }

    /* JADX WARN: Removed duplicated region for block: B_renamed:28:0x0050  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private android.view.View a_renamed(boolean r12, int r13, int r14) {
        /*
            r11 = this;
            r0 = 2
            java.util.ArrayList r11 = r11.getFocusables(r0)
            int r0 = r11.size()
            r1 = 0
            r2 = 0
            r4 = r1
            r3 = r2
            r2 = r4
        Le:
            if (r2 >= r0) goto L54
            java.lang.Object r5 = r11.get(r2)
            android.view.View r5 = (android.view.View) r5
            int r6 = r5.getTop()
            int r7 = r5.getBottom()
            r8 = 1
            if (r13 >= r7) goto L51
            if (r6 >= r14) goto L51
            if (r13 >= r6) goto L29
            if (r7 >= r14) goto L29
            r9 = r8
            goto L2a
        L29:
            r9 = r1
        L2a:
            if (r3 != 0) goto L2f
            r3 = r5
            r4 = r9
            goto L51
        L2f:
            if (r12 == 0) goto L37
            int r10 = r3.getTop()
            if (r6 < r10) goto L3f
        L37:
            if (r12 != 0) goto L41
            int r6 = r3.getBottom()
            if (r7 <= r6) goto L41
        L3f:
            r6 = r8
            goto L42
        L41:
            r6 = r1
        L42:
            if (r4 == 0) goto L49
            if (r9 == 0) goto L51
            if (r6 == 0) goto L51
            goto L50
        L49:
            if (r9 == 0) goto L4e
            r3 = r5
            r4 = r8
            goto L51
        L4e:
            if (r6 == 0) goto L51
        L50:
            r3 = r5
        L51:
            int r2 = r2 + 1
            goto Le
        L54:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.widget.NestedScrollView.a_renamed(boolean, int, int):android.view.View");
    }

    public boolean c_renamed(int i_renamed) {
        boolean z_renamed = i_renamed == 130;
        int height = getHeight();
        if (z_renamed) {
            this.f1016b.top = getScrollY() + height;
            int childCount = getChildCount();
            if (childCount > 0) {
                android.view.View childAt = getChildAt(childCount - 1);
                int bottom = childAt.getBottom() + ((android.widget.FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin + getPaddingBottom();
                if (this.f1016b.top + height > bottom) {
                    this.f1016b.top = bottom - height;
                }
            }
        } else {
            this.f1016b.top = getScrollY() - height;
            if (this.f1016b.top < 0) {
                this.f1016b.top = 0;
            }
        }
        android.graphics.Rect rect = this.f1016b;
        rect.bottom = rect.top + height;
        return a_renamed(i_renamed, this.f1016b.top, this.f1016b.bottom);
    }

    public boolean d_renamed(int i_renamed) {
        int childCount;
        boolean z_renamed = i_renamed == 130;
        int height = getHeight();
        android.graphics.Rect rect = this.f1016b;
        rect.top = 0;
        rect.bottom = height;
        if (z_renamed && (childCount = getChildCount()) > 0) {
            android.view.View childAt = getChildAt(childCount - 1);
            this.f1016b.bottom = childAt.getBottom() + ((android.widget.FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin + getPaddingBottom();
            android.graphics.Rect rect2 = this.f1016b;
            rect2.top = rect2.bottom - height;
        }
        return a_renamed(i_renamed, this.f1016b.top, this.f1016b.bottom);
    }

    private boolean a_renamed(int i_renamed, int i2, int i3) {
        int height = getHeight();
        int scrollY = getScrollY();
        int i4 = height + scrollY;
        boolean z_renamed = false;
        boolean z2 = i_renamed == 33;
        android.view.View viewA = a_renamed(z2, i2, i3);
        if (viewA == null) {
            viewA = this;
        }
        if (i2 < scrollY || i3 > i4) {
            g_renamed(z2 ? i2 - scrollY : i3 - i4);
            z_renamed = true;
        }
        if (viewA != findFocus()) {
            viewA.requestFocus(i_renamed);
        }
        return z_renamed;
    }

    public boolean e_renamed(int i_renamed) {
        android.view.View viewFindFocus = findFocus();
        if (viewFindFocus == this) {
            viewFindFocus = null;
        }
        android.view.View viewFindNextFocus = android.view.FocusFinder.getInstance().findNextFocus(this, viewFindFocus, i_renamed);
        int maxScrollAmount = getMaxScrollAmount();
        if (viewFindNextFocus != null && a_renamed(viewFindNextFocus, maxScrollAmount, getHeight())) {
            viewFindNextFocus.getDrawingRect(this.f1016b);
            offsetDescendantRectToMyCoords(viewFindNextFocus, this.f1016b);
            g_renamed(a_renamed(this.f1016b));
            viewFindNextFocus.requestFocus(i_renamed);
        } else {
            if (i_renamed == 33 && getScrollY() < maxScrollAmount) {
                maxScrollAmount = getScrollY();
            } else if (i_renamed == 130 && getChildCount() > 0) {
                android.view.View childAt = getChildAt(0);
                maxScrollAmount = java.lang.Math.min((childAt.getBottom() + ((android.widget.FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin) - ((getScrollY() + getHeight()) - getPaddingBottom()), maxScrollAmount);
            }
            if (maxScrollAmount == 0) {
                return false;
            }
            if (i_renamed != 130) {
                maxScrollAmount = -maxScrollAmount;
            }
            g_renamed(maxScrollAmount);
        }
        if (viewFindFocus == null || !viewFindFocus.isFocused() || !a_renamed(viewFindFocus)) {
            return true;
        }
        int descendantFocusability = getDescendantFocusability();
        setDescendantFocusability(131072);
        requestFocus();
        setDescendantFocusability(descendantFocusability);
        return true;
    }

    private boolean a_renamed(android.view.View view) {
        return !a_renamed(view, 0, getHeight());
    }

    private boolean a_renamed(android.view.View view, int i_renamed, int i2) {
        view.getDrawingRect(this.f1016b);
        offsetDescendantRectToMyCoords(view, this.f1016b);
        return this.f1016b.bottom + i_renamed >= getScrollY() && this.f1016b.top - i_renamed <= getScrollY() + i2;
    }

    private void g_renamed(int i_renamed) {
        if (i_renamed != 0) {
            if (this.m_renamed) {
                b_renamed(0, i_renamed);
            } else {
                scrollBy(0, i_renamed);
            }
        }
    }

    public final void b_renamed(int i_renamed, int i2) {
        b_renamed(i_renamed, i2, 250, false);
    }

    private void b_renamed(int i_renamed, int i2, int i3, boolean z_renamed) {
        if (getChildCount() == 0) {
            return;
        }
        if (android.view.animation.AnimationUtils.currentAnimationTimeMillis() - this.f1015a > 250) {
            android.view.View childAt = getChildAt(0);
            android.widget.FrameLayout.LayoutParams layoutParams = (android.widget.FrameLayout.LayoutParams) childAt.getLayoutParams();
            int height = childAt.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
            int height2 = (getHeight() - getPaddingTop()) - getPaddingBottom();
            int scrollY = getScrollY();
            this.f1017c.startScroll(getScrollX(), scrollY, 0, java.lang.Math.max(0, java.lang.Math.min(i2 + scrollY, java.lang.Math.max(0, height - height2))) - scrollY, i3);
            a_renamed(z_renamed);
        } else {
            if (!this.f1017c.isFinished()) {
                f_renamed();
            }
            scrollBy(i_renamed, i2);
        }
        this.f1015a = android.view.animation.AnimationUtils.currentAnimationTimeMillis();
    }

    void a_renamed(int i_renamed, int i2, boolean z_renamed) {
        a_renamed(i_renamed, i2, 250, z_renamed);
    }

    void a_renamed(int i_renamed, int i2, int i3, boolean z_renamed) {
        b_renamed(i_renamed - getScrollX(), i2 - getScrollY(), i3, z_renamed);
    }

    @Override // android.view.View
    public int computeVerticalScrollRange() {
        int childCount = getChildCount();
        int height = (getHeight() - getPaddingBottom()) - getPaddingTop();
        if (childCount == 0) {
            return height;
        }
        android.view.View childAt = getChildAt(0);
        int bottom = childAt.getBottom() + ((android.widget.FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin;
        int scrollY = getScrollY();
        int iMax = java.lang.Math.max(0, bottom - height);
        return scrollY < 0 ? bottom - scrollY : scrollY > iMax ? bottom + (scrollY - iMax) : bottom;
    }

    @Override // android.view.View
    public int computeVerticalScrollOffset() {
        return java.lang.Math.max(0, super.computeVerticalScrollOffset());
    }

    @Override // android.view.View
    public int computeVerticalScrollExtent() {
        return super.computeVerticalScrollExtent();
    }

    @Override // android.view.View
    public int computeHorizontalScrollRange() {
        return super.computeHorizontalScrollRange();
    }

    @Override // android.view.View
    public int computeHorizontalScrollOffset() {
        return super.computeHorizontalScrollOffset();
    }

    @Override // android.view.View
    public int computeHorizontalScrollExtent() {
        return super.computeHorizontalScrollExtent();
    }

    @Override // android.view.ViewGroup
    protected void measureChild(android.view.View view, int i_renamed, int i2) {
        view.measure(getChildMeasureSpec(i_renamed, getPaddingLeft() + getPaddingRight(), view.getLayoutParams().width), android.view.View.MeasureSpec.makeMeasureSpec(0, 0));
    }

    @Override // android.view.ViewGroup
    protected void measureChildWithMargins(android.view.View view, int i_renamed, int i2, int i3, int i4) {
        android.view.ViewGroup.MarginLayoutParams marginLayoutParams = (android.view.ViewGroup.MarginLayoutParams) view.getLayoutParams();
        view.measure(getChildMeasureSpec(i_renamed, getPaddingLeft() + getPaddingRight() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i2, marginLayoutParams.width), android.view.View.MeasureSpec.makeMeasureSpec(marginLayoutParams.topMargin + marginLayoutParams.bottomMargin, 0));
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.f1017c.isFinished()) {
            return;
        }
        this.f1017c.computeScrollOffset();
        int currY = this.f1017c.getCurrY();
        int i_renamed = currY - this.u_renamed;
        this.u_renamed = currY;
        int[] iArr = this.s_renamed;
        boolean z_renamed = false;
        iArr[1] = 0;
        a_renamed(0, i_renamed, iArr, null, 1);
        int i2 = i_renamed - this.s_renamed[1];
        int scrollRange = getScrollRange();
        if (i2 != 0) {
            int scrollY = getScrollY();
            a_renamed(0, i2, getScrollX(), scrollY, 0, scrollRange, 0, 0, false);
            int scrollY2 = getScrollY() - scrollY;
            int i3 = i2 - scrollY2;
            int[] iArr2 = this.s_renamed;
            iArr2[1] = 0;
            a_renamed(0, scrollY2, 0, i3, this.r_renamed, 1, iArr2);
            i2 = i3 - this.s_renamed[1];
        }
        if (i2 != 0) {
            int overScrollMode = getOverScrollMode();
            if (overScrollMode == 0 || (overScrollMode == 1 && scrollRange > 0)) {
                z_renamed = true;
            }
            if (z_renamed) {
                h_renamed();
                if (i2 < 0) {
                    if (this.d_renamed.isFinished()) {
                        this.d_renamed.onAbsorb((int) this.f1017c.getCurrVelocity());
                    }
                } else if (this.e_renamed.isFinished()) {
                    this.e_renamed.onAbsorb((int) this.f1017c.getCurrVelocity());
                }
            }
            f_renamed();
        }
        if (!this.f1017c.isFinished()) {
            androidx.core.h_renamed.v_renamed.e_renamed(this);
        } else {
            a_renamed(1);
        }
    }

    private void a_renamed(boolean z_renamed) {
        if (z_renamed) {
            a_renamed(2, 1);
        } else {
            a_renamed(1);
        }
        this.u_renamed = getScrollY();
        androidx.core.h_renamed.v_renamed.e_renamed(this);
    }

    private void f_renamed() {
        this.f1017c.abortAnimation();
        a_renamed(1);
    }

    private void b_renamed(android.view.View view) {
        view.getDrawingRect(this.f1016b);
        offsetDescendantRectToMyCoords(view, this.f1016b);
        int iA = a_renamed(this.f1016b);
        if (iA != 0) {
            scrollBy(0, iA);
        }
    }

    private boolean a_renamed(android.graphics.Rect rect, boolean z_renamed) {
        int iA = a_renamed(rect);
        boolean z2 = iA != 0;
        if (z2) {
            if (z_renamed) {
                scrollBy(0, iA);
            } else {
                b_renamed(0, iA);
            }
        }
        return z2;
    }

    protected int a_renamed(android.graphics.Rect rect) {
        int i_renamed;
        int i2;
        if (getChildCount() == 0) {
            return 0;
        }
        int height = getHeight();
        int scrollY = getScrollY();
        int i3 = scrollY + height;
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        if (rect.top > 0) {
            scrollY += verticalFadingEdgeLength;
        }
        android.view.View childAt = getChildAt(0);
        android.widget.FrameLayout.LayoutParams layoutParams = (android.widget.FrameLayout.LayoutParams) childAt.getLayoutParams();
        int i4 = rect.bottom < (childAt.getHeight() + layoutParams.topMargin) + layoutParams.bottomMargin ? i3 - verticalFadingEdgeLength : i3;
        if (rect.bottom > i4 && rect.top > scrollY) {
            if (rect.height() > height) {
                i2 = rect.top - scrollY;
            } else {
                i2 = rect.bottom - i4;
            }
            return java.lang.Math.min(i2 + 0, (childAt.getBottom() + layoutParams.bottomMargin) - i3);
        }
        if (rect.top >= scrollY || rect.bottom >= i4) {
            return 0;
        }
        if (rect.height() > height) {
            i_renamed = 0 - (i4 - rect.bottom);
        } else {
            i_renamed = 0 - (scrollY - rect.top);
        }
        return java.lang.Math.max(i_renamed, -getScrollY());
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestChildFocus(android.view.View view, android.view.View view2) {
        if (!this.g_renamed) {
            b_renamed(view2);
        } else {
            this.i_renamed = view2;
        }
        super.requestChildFocus(view, view2);
    }

    @Override // android.view.ViewGroup
    protected boolean onRequestFocusInDescendants(int i_renamed, android.graphics.Rect rect) {
        android.view.View viewFindNextFocusFromRect;
        if (i_renamed == 2) {
            i_renamed = 130;
        } else if (i_renamed == 1) {
            i_renamed = 33;
        }
        if (rect == null) {
            viewFindNextFocusFromRect = android.view.FocusFinder.getInstance().findNextFocus(this, null, i_renamed);
        } else {
            viewFindNextFocusFromRect = android.view.FocusFinder.getInstance().findNextFocusFromRect(this, rect, i_renamed);
        }
        if (viewFindNextFocusFromRect == null || a_renamed(viewFindNextFocusFromRect)) {
            return false;
        }
        return viewFindNextFocusFromRect.requestFocus(i_renamed, rect);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean requestChildRectangleOnScreen(android.view.View view, android.graphics.Rect rect, boolean z_renamed) {
        rect.offset(view.getLeft() - view.getScrollX(), view.getTop() - view.getScrollY());
        return a_renamed(rect, z_renamed);
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        this.g_renamed = true;
        super.requestLayout();
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z_renamed, int i_renamed, int i2, int i3, int i4) {
        super.onLayout(z_renamed, i_renamed, i2, i3, i4);
        int measuredHeight = 0;
        this.g_renamed = false;
        android.view.View view = this.i_renamed;
        if (view != null && a_renamed(view, this)) {
            b_renamed(this.i_renamed);
        }
        this.i_renamed = null;
        if (!this.h_renamed) {
            if (this.v_renamed != null) {
                scrollTo(getScrollX(), this.v_renamed.scrollPosition);
                this.v_renamed = null;
            }
            if (getChildCount() > 0) {
                android.view.View childAt = getChildAt(0);
                android.widget.FrameLayout.LayoutParams layoutParams = (android.widget.FrameLayout.LayoutParams) childAt.getLayoutParams();
                measuredHeight = childAt.getMeasuredHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
            }
            int paddingTop = ((i4 - i2) - getPaddingTop()) - getPaddingBottom();
            int scrollY = getScrollY();
            int iB = b_renamed(scrollY, paddingTop, measuredHeight);
            if (iB != scrollY) {
                scrollTo(getScrollX(), iB);
            }
        }
        scrollTo(getScrollX(), getScrollY());
        this.h_renamed = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.h_renamed = false;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i_renamed, int i2, int i3, int i4) {
        super.onSizeChanged(i_renamed, i2, i3, i4);
        android.view.View viewFindFocus = findFocus();
        if (viewFindFocus == null || this == viewFindFocus || !a_renamed(viewFindFocus, 0, i4)) {
            return;
        }
        viewFindFocus.getDrawingRect(this.f1016b);
        offsetDescendantRectToMyCoords(viewFindFocus, this.f1016b);
        g_renamed(a_renamed(this.f1016b));
    }

    private static boolean a_renamed(android.view.View view, android.view.View view2) {
        if (view == view2) {
            return true;
        }
        java.lang.Object parent = view.getParent();
        return (parent instanceof android.view.ViewGroup) && a_renamed((android.view.View) parent, view2);
    }

    public void f_renamed(int i_renamed) {
        if (getChildCount() > 0) {
            this.f1017c.fling(getScrollX(), getScrollY(), 0, i_renamed, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE, 0, 0);
            a_renamed(true);
        }
    }

    private void g_renamed() {
        this.j_renamed = false;
        e_renamed();
        a_renamed(0);
        android.widget.EdgeEffect edgeEffect = this.d_renamed;
        if (edgeEffect != null) {
            edgeEffect.onRelease();
            this.e_renamed.onRelease();
        }
    }

    @Override // android.view.View
    public void scrollTo(int i_renamed, int i2) {
        if (getChildCount() > 0) {
            android.view.View childAt = getChildAt(0);
            android.widget.FrameLayout.LayoutParams layoutParams = (android.widget.FrameLayout.LayoutParams) childAt.getLayoutParams();
            int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
            int width2 = childAt.getWidth() + layoutParams.leftMargin + layoutParams.rightMargin;
            int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
            int height2 = childAt.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
            int iB = b_renamed(i_renamed, width, width2);
            int iB2 = b_renamed(i2, height, height2);
            if (iB == getScrollX() && iB2 == getScrollY()) {
                return;
            }
            super.scrollTo(iB, iB2);
        }
    }

    private void h_renamed() {
        if (getOverScrollMode() != 2) {
            if (this.d_renamed == null) {
                android.content.Context context = getContext();
                this.d_renamed = new android.widget.EdgeEffect(context);
                this.e_renamed = new android.widget.EdgeEffect(context);
                return;
            }
            return;
        }
        this.d_renamed = null;
        this.e_renamed = null;
    }

    @Override // android.view.View
    public void draw(android.graphics.Canvas canvas) {
        int paddingLeft;
        super.draw(canvas);
        if (this.d_renamed != null) {
            int scrollY = getScrollY();
            int paddingLeft2 = 0;
            if (!this.d_renamed.isFinished()) {
                int iSave = canvas.save();
                int width = getWidth();
                int height = getHeight();
                int iMin = java.lang.Math.min(0, scrollY);
                if (android.os.Build.VERSION.SDK_INT < 21 || getClipToPadding()) {
                    width -= getPaddingLeft() + getPaddingRight();
                    paddingLeft = getPaddingLeft() + 0;
                } else {
                    paddingLeft = 0;
                }
                if (android.os.Build.VERSION.SDK_INT >= 21 && getClipToPadding()) {
                    height -= getPaddingTop() + getPaddingBottom();
                    iMin += getPaddingTop();
                }
                canvas.translate(paddingLeft, iMin);
                this.d_renamed.setSize(width, height);
                if (this.d_renamed.draw(canvas)) {
                    androidx.core.h_renamed.v_renamed.e_renamed(this);
                }
                canvas.restoreToCount(iSave);
            }
            if (this.e_renamed.isFinished()) {
                return;
            }
            int iSave2 = canvas.save();
            int width2 = getWidth();
            int height2 = getHeight();
            int iMax = java.lang.Math.max(getScrollRange(), scrollY) + height2;
            if (android.os.Build.VERSION.SDK_INT < 21 || getClipToPadding()) {
                width2 -= getPaddingLeft() + getPaddingRight();
                paddingLeft2 = 0 + getPaddingLeft();
            }
            if (android.os.Build.VERSION.SDK_INT >= 21 && getClipToPadding()) {
                height2 -= getPaddingTop() + getPaddingBottom();
                iMax -= getPaddingBottom();
            }
            canvas.translate(paddingLeft2 - width2, iMax);
            canvas.rotate(180.0f, width2, 0.0f);
            this.e_renamed.setSize(width2, height2);
            if (this.e_renamed.draw(canvas)) {
                androidx.core.h_renamed.v_renamed.e_renamed(this);
            }
            canvas.restoreToCount(iSave2);
        }
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(android.os.Parcelable parcelable) {
        if (!(parcelable instanceof androidx.core.widget.NestedScrollView.SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        androidx.core.widget.NestedScrollView.SavedState savedState = (androidx.core.widget.NestedScrollView.SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.v_renamed = savedState;
        requestLayout();
    }

    @Override // android.view.View
    protected android.os.Parcelable onSaveInstanceState() {
        androidx.core.widget.NestedScrollView.SavedState savedState = new androidx.core.widget.NestedScrollView.SavedState(super.onSaveInstanceState());
        savedState.scrollPosition = getScrollY();
        return savedState;
    }

    static class SavedState extends android.view.View.BaseSavedState {
        public static final android.os.Parcelable.Creator<androidx.core.widget.NestedScrollView.SavedState> CREATOR = new android.os.Parcelable.Creator<androidx.core.widget.NestedScrollView.SavedState>() { // from class: androidx.core.widget.NestedScrollView.SavedState.1
            @Override // android.os.Parcelable.Creator
            /* renamed from: a_renamed, reason: merged with bridge method [inline-methods] */
            public androidx.core.widget.NestedScrollView.SavedState createFromParcel(android.os.Parcel parcel) {
                return new androidx.core.widget.NestedScrollView.SavedState(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a_renamed, reason: merged with bridge method [inline-methods] */
            public androidx.core.widget.NestedScrollView.SavedState[] newArray(int i_renamed) {
                return new androidx.core.widget.NestedScrollView.SavedState[i_renamed];
            }
        };
        public int scrollPosition;

        SavedState(android.os.Parcelable parcelable) {
            super(parcelable);
        }

        SavedState(android.os.Parcel parcel) {
            super(parcel);
            this.scrollPosition = parcel.readInt();
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(android.os.Parcel parcel, int i_renamed) {
            super.writeToParcel(parcel, i_renamed);
            parcel.writeInt(this.scrollPosition);
        }

        public java.lang.String toString() {
            return "HorizontalScrollView.SavedState{" + java.lang.Integer.toHexString(java.lang.System.identityHashCode(this)) + " scrollPosition=" + this.scrollPosition + "}";
        }
    }

    static class a_renamed extends androidx.core.h_renamed.a_renamed {
        a_renamed() {
        }

        @Override // androidx.core.h_renamed.a_renamed
        public boolean performAccessibilityAction(android.view.View view, int i_renamed, android.os.Bundle bundle) {
            if (super.performAccessibilityAction(view, i_renamed, bundle)) {
                return true;
            }
            androidx.core.widget.NestedScrollView nestedScrollView = (androidx.core.widget.NestedScrollView) view;
            if (!nestedScrollView.isEnabled()) {
                return false;
            }
            if (i_renamed != 4096) {
                if (i_renamed == 8192 || i_renamed == 16908344) {
                    int iMax = java.lang.Math.max(nestedScrollView.getScrollY() - ((nestedScrollView.getHeight() - nestedScrollView.getPaddingBottom()) - nestedScrollView.getPaddingTop()), 0);
                    if (iMax == nestedScrollView.getScrollY()) {
                        return false;
                    }
                    nestedScrollView.a_renamed(0, iMax, true);
                    return true;
                }
                if (i_renamed != 16908346) {
                    return false;
                }
            }
            int iMin = java.lang.Math.min(nestedScrollView.getScrollY() + ((nestedScrollView.getHeight() - nestedScrollView.getPaddingBottom()) - nestedScrollView.getPaddingTop()), nestedScrollView.getScrollRange());
            if (iMin == nestedScrollView.getScrollY()) {
                return false;
            }
            nestedScrollView.a_renamed(0, iMin, true);
            return true;
        }

        @Override // androidx.core.h_renamed.a_renamed
        public void onInitializeAccessibilityNodeInfo(android.view.View view, androidx.core.h_renamed.a_renamed.d_renamed dVar) {
            int scrollRange;
            super.onInitializeAccessibilityNodeInfo(view, dVar);
            androidx.core.widget.NestedScrollView nestedScrollView = (androidx.core.widget.NestedScrollView) view;
            dVar.b_renamed((java.lang.CharSequence) android.widget.ScrollView.class.getName());
            if (!nestedScrollView.isEnabled() || (scrollRange = nestedScrollView.getScrollRange()) <= 0) {
                return;
            }
            dVar.i_renamed(true);
            if (nestedScrollView.getScrollY() > 0) {
                dVar.a_renamed(androidx.core.h_renamed.a_renamed.d_renamed.a_renamed.n_renamed);
                dVar.a_renamed(androidx.core.h_renamed.a_renamed.d_renamed.a_renamed.y_renamed);
            }
            if (nestedScrollView.getScrollY() < scrollRange) {
                dVar.a_renamed(androidx.core.h_renamed.a_renamed.d_renamed.a_renamed.m_renamed);
                dVar.a_renamed(androidx.core.h_renamed.a_renamed.d_renamed.a_renamed.A_renamed);
            }
        }

        @Override // androidx.core.h_renamed.a_renamed
        public void onInitializeAccessibilityEvent(android.view.View view, android.view.accessibility.AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(view, accessibilityEvent);
            androidx.core.widget.NestedScrollView nestedScrollView = (androidx.core.widget.NestedScrollView) view;
            accessibilityEvent.setClassName(android.widget.ScrollView.class.getName());
            accessibilityEvent.setScrollable(nestedScrollView.getScrollRange() > 0);
            accessibilityEvent.setScrollX(nestedScrollView.getScrollX());
            accessibilityEvent.setScrollY(nestedScrollView.getScrollY());
            androidx.core.h_renamed.a_renamed.f_renamed.a_renamed(accessibilityEvent, nestedScrollView.getScrollX());
            androidx.core.h_renamed.a_renamed.f_renamed.b_renamed(accessibilityEvent, nestedScrollView.getScrollRange());
        }
    }
}

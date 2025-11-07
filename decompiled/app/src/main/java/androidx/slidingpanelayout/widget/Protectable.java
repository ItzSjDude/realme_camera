package androidx.slidingpanelayout.widget;

/* loaded from: classes.dex */
public class SlidingPaneLayout extends android.view.ViewGroup {

    /* renamed from: a_renamed, reason: collision with root package name */
    android.view.View f1653a;

    /* renamed from: b_renamed, reason: collision with root package name */
    float f1654b;

    /* renamed from: c_renamed, reason: collision with root package name */
    int f1655c;
    boolean d_renamed;
    final androidx.customview.a_renamed.c_renamed e_renamed;
    boolean f_renamed;
    final java.util.ArrayList<androidx.slidingpanelayout.widget.SlidingPaneLayout.a_renamed> g_renamed;
    private int h_renamed;
    private int i_renamed;
    private android.graphics.drawable.Drawable j_renamed;
    private android.graphics.drawable.Drawable k_renamed;
    private final int l_renamed;
    private boolean m_renamed;
    private float n_renamed;
    private int o_renamed;
    private float p_renamed;
    private float q_renamed;
    private androidx.slidingpanelayout.widget.SlidingPaneLayout.c_renamed r_renamed;
    private boolean s_renamed;
    private final android.graphics.Rect t_renamed;
    private java.lang.reflect.Method u_renamed;
    private java.lang.reflect.Field v_renamed;
    private boolean w_renamed;

    public interface c_renamed {
    }

    public void setParallaxDistance(int i_renamed) {
        this.o_renamed = i_renamed;
        requestLayout();
    }

    public int getParallaxDistance() {
        return this.o_renamed;
    }

    public void setSliderFadeColor(int i_renamed) {
        this.h_renamed = i_renamed;
    }

    public int getSliderFadeColor() {
        return this.h_renamed;
    }

    public void setCoveredFadeColor(int i_renamed) {
        this.i_renamed = i_renamed;
    }

    public int getCoveredFadeColor() {
        return this.i_renamed;
    }

    public void setPanelSlideListener(androidx.slidingpanelayout.widget.SlidingPaneLayout.c_renamed cVar) {
        this.r_renamed = cVar;
    }

    void a_renamed(android.view.View view) {
        int left;
        int right;
        int top;
        int bottom;
        boolean z_renamed;
        int i_renamed;
        android.view.View view2 = view;
        boolean zF = f_renamed();
        int width = zF ? getWidth() - getPaddingRight() : getPaddingLeft();
        int paddingLeft = zF ? getPaddingLeft() : getWidth() - getPaddingRight();
        int paddingTop = getPaddingTop();
        int height = getHeight() - getPaddingBottom();
        if (view2 == null || !d_renamed(view)) {
            left = 0;
            right = 0;
            top = 0;
            bottom = 0;
        } else {
            left = view.getLeft();
            right = view.getRight();
            top = view.getTop();
            bottom = view.getBottom();
        }
        int childCount = getChildCount();
        int i2 = 0;
        while (i2 < childCount) {
            android.view.View childAt = getChildAt(i2);
            if (childAt == view2) {
                return;
            }
            if (childAt.getVisibility() == 8) {
                z_renamed = zF;
            } else {
                int iMax = java.lang.Math.max(zF ? paddingLeft : width, childAt.getLeft());
                int iMax2 = java.lang.Math.max(paddingTop, childAt.getTop());
                if (zF) {
                    z_renamed = zF;
                    i_renamed = width;
                } else {
                    z_renamed = zF;
                    i_renamed = paddingLeft;
                }
                childAt.setVisibility((iMax < left || iMax2 < top || java.lang.Math.min(i_renamed, childAt.getRight()) > right || java.lang.Math.min(height, childAt.getBottom()) > bottom) ? 0 : 4);
            }
            i2++;
            view2 = view;
            zF = z_renamed;
        }
    }

    void a_renamed() {
        int childCount = getChildCount();
        for (int i_renamed = 0; i_renamed < childCount; i_renamed++) {
            android.view.View childAt = getChildAt(i_renamed);
            if (childAt.getVisibility() == 4) {
                childAt.setVisibility(0);
            }
        }
    }

    private static boolean d_renamed(android.view.View view) {
        android.graphics.drawable.Drawable background;
        if (view.isOpaque()) {
            return true;
        }
        return android.os.Build.VERSION.SDK_INT < 18 && (background = view.getBackground()) != null && background.getOpacity() == -1;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.s_renamed = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        super.onDetachedFromWindow();
        this.s_renamed = true;
        int size = this.g_renamed.size();
        for (int i_renamed = 0; i_renamed < size; i_renamed++) {
            this.g_renamed.get(i_renamed).run();
        }
        this.g_renamed.clear();
    }

    /* JADX WARN: Removed duplicated region for block: B_renamed:40:0x00b0 A_renamed[PHI: r12
      0x00b0: PHI (r12v2 float) = (r12v1 float), (r12v3 float) binds: [B_renamed:36:0x00a5, B_renamed:38:0x00ac] A_renamed[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B_renamed:74:0x0142  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void onMeasure(int r21, int r22) {
        /*
            Method dump skipped, instructions count: 585
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.slidingpanelayout.widget.SlidingPaneLayout.onMeasure(int, int):void");
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z_renamed, int i_renamed, int i2, int i3, int i4) throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        boolean zF = f_renamed();
        if (zF) {
            this.e_renamed.a_renamed(2);
        } else {
            this.e_renamed.a_renamed(1);
        }
        int i10 = i3 - i_renamed;
        int paddingRight = zF ? getPaddingRight() : getPaddingLeft();
        int paddingLeft = zF ? getPaddingLeft() : getPaddingRight();
        int paddingTop = getPaddingTop();
        int childCount = getChildCount();
        if (this.s_renamed) {
            this.f1654b = (this.m_renamed && this.f_renamed) ? 1.0f : 0.0f;
        }
        int width = paddingRight;
        int i11 = width;
        for (int i12 = 0; i12 < childCount; i12++) {
            android.view.View childAt = getChildAt(i12);
            if (childAt.getVisibility() != 8) {
                androidx.slidingpanelayout.widget.SlidingPaneLayout.b_renamed bVar = (androidx.slidingpanelayout.widget.SlidingPaneLayout.b_renamed) childAt.getLayoutParams();
                int measuredWidth = childAt.getMeasuredWidth();
                if (bVar.f1659b) {
                    int i13 = i10 - paddingLeft;
                    int iMin = (java.lang.Math.min(width, i13 - this.l_renamed) - i11) - (bVar.leftMargin + bVar.rightMargin);
                    this.f1655c = iMin;
                    int i14 = zF ? bVar.rightMargin : bVar.leftMargin;
                    bVar.f1660c = ((i11 + i14) + iMin) + (measuredWidth / 2) > i13;
                    int i15 = (int) (iMin * this.f1654b);
                    i5 = i14 + i15 + i11;
                    this.f1654b = i15 / this.f1655c;
                    i6 = 0;
                } else if (!this.m_renamed || (i7 = this.o_renamed) == 0) {
                    i5 = width;
                    i6 = 0;
                } else {
                    i6 = (int) ((1.0f - this.f1654b) * i7);
                    i5 = width;
                }
                if (zF) {
                    i9 = (i10 - i5) + i6;
                    i8 = i9 - measuredWidth;
                } else {
                    i8 = i5 - i6;
                    i9 = i8 + measuredWidth;
                }
                childAt.layout(i8, paddingTop, i9, childAt.getMeasuredHeight() + paddingTop);
                width += childAt.getWidth();
                i11 = i5;
            }
        }
        if (this.s_renamed) {
            if (this.m_renamed) {
                if (this.o_renamed != 0) {
                    a_renamed(this.f1654b);
                }
                if (((androidx.slidingpanelayout.widget.SlidingPaneLayout.b_renamed) this.f1653a.getLayoutParams()).f1660c) {
                    a_renamed(this.f1653a, this.f1654b, this.h_renamed);
                }
            } else {
                for (int i16 = 0; i16 < childCount; i16++) {
                    a_renamed(getChildAt(i16), 0.0f, this.h_renamed);
                }
            }
            a_renamed(this.f1653a);
        }
        this.s_renamed = false;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i_renamed, int i2, int i3, int i4) {
        super.onSizeChanged(i_renamed, i2, i3, i4);
        if (i_renamed != i3) {
            this.s_renamed = true;
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestChildFocus(android.view.View view, android.view.View view2) {
        super.requestChildFocus(view, view2);
        if (isInTouchMode() || this.m_renamed) {
            return;
        }
        this.f_renamed = view == this.f1653a;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(android.view.MotionEvent motionEvent) {
        boolean z_renamed;
        android.view.View childAt;
        int actionMasked = motionEvent.getActionMasked();
        if (!this.m_renamed && actionMasked == 0 && getChildCount() > 1 && (childAt = getChildAt(1)) != null) {
            this.f_renamed = !this.e_renamed.b_renamed(childAt, (int) motionEvent.getX(), (int) motionEvent.getY());
        }
        if (!this.m_renamed || (this.d_renamed && actionMasked != 0)) {
            this.e_renamed.e_renamed();
            return super.onInterceptTouchEvent(motionEvent);
        }
        if (actionMasked == 3 || actionMasked == 1) {
            this.e_renamed.e_renamed();
            return false;
        }
        if (actionMasked == 0) {
            this.d_renamed = false;
            float x_renamed = motionEvent.getX();
            float y_renamed = motionEvent.getY();
            this.p_renamed = x_renamed;
            this.q_renamed = y_renamed;
            if (this.e_renamed.b_renamed(this.f1653a, (int) x_renamed, (int) y_renamed) && c_renamed(this.f1653a)) {
                z_renamed = true;
            }
            return this.e_renamed.a_renamed(motionEvent) || z_renamed;
        }
        if (actionMasked == 2) {
            float x2 = motionEvent.getX();
            float y2 = motionEvent.getY();
            float fAbs = java.lang.Math.abs(x2 - this.p_renamed);
            float fAbs2 = java.lang.Math.abs(y2 - this.q_renamed);
            if (fAbs > this.e_renamed.d_renamed() && fAbs2 > fAbs) {
                this.e_renamed.e_renamed();
                this.d_renamed = true;
                return false;
            }
        }
        z_renamed = false;
        if (this.e_renamed.a_renamed(motionEvent)) {
            return true;
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(android.view.MotionEvent motionEvent) {
        if (!this.m_renamed) {
            return super.onTouchEvent(motionEvent);
        }
        this.e_renamed.b_renamed(motionEvent);
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            float x_renamed = motionEvent.getX();
            float y_renamed = motionEvent.getY();
            this.p_renamed = x_renamed;
            this.q_renamed = y_renamed;
        } else if (actionMasked == 1 && c_renamed(this.f1653a)) {
            float x2 = motionEvent.getX();
            float y2 = motionEvent.getY();
            float f_renamed = x2 - this.p_renamed;
            float f2 = y2 - this.q_renamed;
            int iD = this.e_renamed.d_renamed();
            if ((f_renamed * f_renamed) + (f2 * f2) < iD * iD && this.e_renamed.b_renamed(this.f1653a, (int) x2, (int) y2)) {
                a_renamed(this.f1653a, 0);
            }
        }
        return true;
    }

    private boolean a_renamed(android.view.View view, int i_renamed) {
        if (!this.s_renamed && !a_renamed(0.0f, i_renamed)) {
            return false;
        }
        this.f_renamed = false;
        return true;
    }

    private boolean b_renamed(android.view.View view, int i_renamed) {
        if (!this.s_renamed && !a_renamed(1.0f, i_renamed)) {
            return false;
        }
        this.f_renamed = true;
        return true;
    }

    public boolean b_renamed() {
        return b_renamed(this.f1653a, 0);
    }

    public boolean c_renamed() {
        return a_renamed(this.f1653a, 0);
    }

    public boolean d_renamed() {
        return !this.m_renamed || this.f1654b == 1.0f;
    }

    public boolean e_renamed() {
        return this.m_renamed;
    }

    private void a_renamed(android.view.View view, float f_renamed, int i_renamed) throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        androidx.slidingpanelayout.widget.SlidingPaneLayout.b_renamed bVar = (androidx.slidingpanelayout.widget.SlidingPaneLayout.b_renamed) view.getLayoutParams();
        if (f_renamed > 0.0f && i_renamed != 0) {
            int i2 = (((int) ((((-16777216) & i_renamed) >>> 24) * f_renamed)) << 24) | (i_renamed & 16777215);
            if (bVar.d_renamed == null) {
                bVar.d_renamed = new android.graphics.Paint();
            }
            bVar.d_renamed.setColorFilter(new android.graphics.PorterDuffColorFilter(i2, android.graphics.PorterDuff.Mode.SRC_OVER));
            if (view.getLayerType() != 2) {
                view.setLayerType(2, bVar.d_renamed);
            }
            b_renamed(view);
            return;
        }
        if (view.getLayerType() != 0) {
            if (bVar.d_renamed != null) {
                bVar.d_renamed.setColorFilter(null);
            }
            androidx.slidingpanelayout.widget.SlidingPaneLayout.a_renamed aVar = new androidx.slidingpanelayout.widget.SlidingPaneLayout.a_renamed(view);
            this.g_renamed.add(aVar);
            androidx.core.h_renamed.v_renamed.a_renamed(this, aVar);
        }
    }

    @Override // android.view.ViewGroup
    protected boolean drawChild(android.graphics.Canvas canvas, android.view.View view, long j_renamed) {
        androidx.slidingpanelayout.widget.SlidingPaneLayout.b_renamed bVar = (androidx.slidingpanelayout.widget.SlidingPaneLayout.b_renamed) view.getLayoutParams();
        int iSave = canvas.save();
        if (this.m_renamed && !bVar.f1659b && this.f1653a != null) {
            canvas.getClipBounds(this.t_renamed);
            if (f_renamed()) {
                android.graphics.Rect rect = this.t_renamed;
                rect.left = java.lang.Math.max(rect.left, this.f1653a.getRight());
            } else {
                android.graphics.Rect rect2 = this.t_renamed;
                rect2.right = java.lang.Math.min(rect2.right, this.f1653a.getLeft());
            }
            canvas.clipRect(this.t_renamed);
        }
        boolean zDrawChild = super.drawChild(canvas, view, j_renamed);
        canvas.restoreToCount(iSave);
        return zDrawChild;
    }

    void b_renamed(android.view.View view) throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        java.lang.reflect.Field field;
        if (android.os.Build.VERSION.SDK_INT >= 17) {
            androidx.core.h_renamed.v_renamed.a_renamed(view, ((androidx.slidingpanelayout.widget.SlidingPaneLayout.b_renamed) view.getLayoutParams()).d_renamed);
            return;
        }
        if (android.os.Build.VERSION.SDK_INT >= 16) {
            if (!this.w_renamed) {
                try {
                    this.u_renamed = android.view.View.class.getDeclaredMethod("getDisplayList", (java.lang.Class[]) null);
                } catch (java.lang.NoSuchMethodException e_renamed) {
                    android.util.Log.e_renamed("SlidingPaneLayout", "Couldn't_renamed fetch getDisplayList method; dimming won't_renamed work right.", e_renamed);
                }
                try {
                    this.v_renamed = android.view.View.class.getDeclaredField("mRecreateDisplayList");
                    this.v_renamed.setAccessible(true);
                } catch (java.lang.NoSuchFieldException e2) {
                    android.util.Log.e_renamed("SlidingPaneLayout", "Couldn't_renamed fetch mRecreateDisplayList field; dimming will be_renamed slow.", e2);
                }
                this.w_renamed = true;
            }
            if (this.u_renamed == null || (field = this.v_renamed) == null) {
                view.invalidate();
                return;
            }
            try {
                field.setBoolean(view, true);
                this.u_renamed.invoke(view, (java.lang.Object[]) null);
            } catch (java.lang.Exception e3) {
                android.util.Log.e_renamed("SlidingPaneLayout", "Error refreshing display list state", e3);
            }
        }
        androidx.core.h_renamed.v_renamed.a_renamed(this, view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
    }

    boolean a_renamed(float f_renamed, int i_renamed) {
        int paddingLeft;
        if (!this.m_renamed) {
            return false;
        }
        boolean zF = f_renamed();
        androidx.slidingpanelayout.widget.SlidingPaneLayout.b_renamed bVar = (androidx.slidingpanelayout.widget.SlidingPaneLayout.b_renamed) this.f1653a.getLayoutParams();
        if (zF) {
            paddingLeft = (int) (getWidth() - (((getPaddingRight() + bVar.rightMargin) + (f_renamed * this.f1655c)) + this.f1653a.getWidth()));
        } else {
            paddingLeft = (int) (getPaddingLeft() + bVar.leftMargin + (f_renamed * this.f1655c));
        }
        androidx.customview.a_renamed.c_renamed cVar = this.e_renamed;
        android.view.View view = this.f1653a;
        if (!cVar.a_renamed(view, paddingLeft, view.getTop())) {
            return false;
        }
        a_renamed();
        androidx.core.h_renamed.v_renamed.e_renamed(this);
        return true;
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.e_renamed.a_renamed(true)) {
            if (!this.m_renamed) {
                this.e_renamed.f_renamed();
            } else {
                androidx.core.h_renamed.v_renamed.e_renamed(this);
            }
        }
    }

    @java.lang.Deprecated
    public void setShadowDrawable(android.graphics.drawable.Drawable drawable) {
        setShadowDrawableLeft(drawable);
    }

    public void setShadowDrawableLeft(android.graphics.drawable.Drawable drawable) {
        this.j_renamed = drawable;
    }

    public void setShadowDrawableRight(android.graphics.drawable.Drawable drawable) {
        this.k_renamed = drawable;
    }

    @java.lang.Deprecated
    public void setShadowResource(int i_renamed) {
        setShadowDrawable(getResources().getDrawable(i_renamed));
    }

    public void setShadowResourceLeft(int i_renamed) {
        setShadowDrawableLeft(androidx.core.a_renamed.a_renamed.a_renamed(getContext(), i_renamed));
    }

    public void setShadowResourceRight(int i_renamed) {
        setShadowDrawableRight(androidx.core.a_renamed.a_renamed.a_renamed(getContext(), i_renamed));
    }

    @Override // android.view.View
    public void draw(android.graphics.Canvas canvas) {
        android.graphics.drawable.Drawable drawable;
        int i_renamed;
        int right;
        super.draw(canvas);
        if (f_renamed()) {
            drawable = this.k_renamed;
        } else {
            drawable = this.j_renamed;
        }
        android.view.View childAt = getChildCount() > 1 ? getChildAt(1) : null;
        if (childAt == null || drawable == null) {
            return;
        }
        int top = childAt.getTop();
        int bottom = childAt.getBottom();
        int intrinsicWidth = drawable.getIntrinsicWidth();
        if (f_renamed()) {
            right = childAt.getRight();
            i_renamed = intrinsicWidth + right;
        } else {
            int left = childAt.getLeft();
            int i2 = left - intrinsicWidth;
            i_renamed = left;
            right = i2;
        }
        drawable.setBounds(right, top, i_renamed, bottom);
        drawable.draw(canvas);
    }

    /* JADX WARN: Removed duplicated region for block: B_renamed:9:0x001c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void a_renamed(float r10) throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        /*
            r9 = this;
            boolean r0 = r9.f_renamed()
            android.view.View r1 = r9.f1653a
            android.view.ViewGroup$LayoutParams r1 = r1.getLayoutParams()
            androidx.slidingpanelayout.widget.SlidingPaneLayout$b_renamed r1 = (androidx.slidingpanelayout.widget.SlidingPaneLayout.b_renamed) r1
            boolean r2 = r1.f1660c
            r3 = 0
            if (r2 == 0) goto L1c
            if (r0 == 0) goto L16
            int r1 = r1.rightMargin
            goto L18
        L16:
            int r1 = r1.leftMargin
        L18:
            if (r1 > 0) goto L1c
            r1 = 1
            goto L1d
        L1c:
            r1 = r3
        L1d:
            int r2 = r9.getChildCount()
        L21:
            if (r3 >= r2) goto L59
            android.view.View r4 = r9.getChildAt(r3)
            android.view.View r5 = r9.f1653a
            if (r4 != r5) goto L2c
            goto L56
        L2c:
            float r5 = r9.n_renamed
            r6 = 1065353216(0x3f800000, float:1.0)
            float r5 = r6 - r5
            int r7 = r9.o_renamed
            float r8 = (float) r7
            float r5 = r5 * r8
            int r5 = (int) r5
            r9.n_renamed = r10
            float r8 = r6 - r10
            float r7 = (float) r7
            float r8 = r8 * r7
            int r7 = (int) r8
            int r5 = r5 - r7
            if (r0 == 0) goto L42
            int r5 = -r5
        L42:
            r4.offsetLeftAndRight(r5)
            if (r1 == 0) goto L56
            if (r0 == 0) goto L4d
            float r5 = r9.n_renamed
            float r5 = r5 - r6
            goto L51
        L4d:
            float r5 = r9.n_renamed
            float r5 = r6 - r5
        L51:
            int r6 = r9.i_renamed
            r9.a_renamed(r4, r5, r6)
        L56:
            int r3 = r3 + 1
            goto L21
        L59:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.slidingpanelayout.widget.SlidingPaneLayout.a_renamed(float):void");
    }

    boolean c_renamed(android.view.View view) {
        if (view == null) {
            return false;
        }
        return this.m_renamed && ((androidx.slidingpanelayout.widget.SlidingPaneLayout.b_renamed) view.getLayoutParams()).f1660c && this.f1654b > 0.0f;
    }

    @Override // android.view.ViewGroup
    protected android.view.ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new androidx.slidingpanelayout.widget.SlidingPaneLayout.b_renamed();
    }

    @Override // android.view.ViewGroup
    protected android.view.ViewGroup.LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof android.view.ViewGroup.MarginLayoutParams ? new androidx.slidingpanelayout.widget.SlidingPaneLayout.b_renamed((android.view.ViewGroup.MarginLayoutParams) layoutParams) : new androidx.slidingpanelayout.widget.SlidingPaneLayout.b_renamed(layoutParams);
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof androidx.slidingpanelayout.widget.SlidingPaneLayout.b_renamed) && super.checkLayoutParams(layoutParams);
    }

    @Override // android.view.ViewGroup
    public android.view.ViewGroup.LayoutParams generateLayoutParams(android.util.AttributeSet attributeSet) {
        return new androidx.slidingpanelayout.widget.SlidingPaneLayout.b_renamed(getContext(), attributeSet);
    }

    @Override // android.view.View
    protected android.os.Parcelable onSaveInstanceState() {
        androidx.slidingpanelayout.widget.SlidingPaneLayout.SavedState savedState = new androidx.slidingpanelayout.widget.SlidingPaneLayout.SavedState(super.onSaveInstanceState());
        savedState.isOpen = e_renamed() ? d_renamed() : this.f_renamed;
        return savedState;
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(android.os.Parcelable parcelable) {
        if (!(parcelable instanceof androidx.slidingpanelayout.widget.SlidingPaneLayout.SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        androidx.slidingpanelayout.widget.SlidingPaneLayout.SavedState savedState = (androidx.slidingpanelayout.widget.SlidingPaneLayout.SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        if (savedState.isOpen) {
            b_renamed();
        } else {
            c_renamed();
        }
        this.f_renamed = savedState.isOpen;
    }

    public static class b_renamed extends android.view.ViewGroup.MarginLayoutParams {
        private static final int[] e_renamed = {android.R_renamed.attr.layout_weight};

        /* renamed from: a_renamed, reason: collision with root package name */
        public float f1658a;

        /* renamed from: b_renamed, reason: collision with root package name */
        boolean f1659b;

        /* renamed from: c_renamed, reason: collision with root package name */
        boolean f1660c;
        android.graphics.Paint d_renamed;

        public b_renamed() {
            super(-1, -1);
            this.f1658a = 0.0f;
        }

        public b_renamed(android.view.ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f1658a = 0.0f;
        }

        public b_renamed(android.view.ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f1658a = 0.0f;
        }

        public b_renamed(android.content.Context context, android.util.AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f1658a = 0.0f;
            android.content.res.TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, e_renamed);
            this.f1658a = typedArrayObtainStyledAttributes.getFloat(0, 0.0f);
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    static class SavedState extends androidx.customview.view.AbsSavedState {
        public static final android.os.Parcelable.Creator<androidx.slidingpanelayout.widget.SlidingPaneLayout.SavedState> CREATOR = new android.os.Parcelable.ClassLoaderCreator<androidx.slidingpanelayout.widget.SlidingPaneLayout.SavedState>() { // from class: androidx.slidingpanelayout.widget.SlidingPaneLayout.SavedState.1
            @Override // android.os.Parcelable.ClassLoaderCreator
            /* renamed from: a_renamed, reason: merged with bridge method [inline-methods] */
            public androidx.slidingpanelayout.widget.SlidingPaneLayout.SavedState createFromParcel(android.os.Parcel parcel, java.lang.ClassLoader classLoader) {
                return new androidx.slidingpanelayout.widget.SlidingPaneLayout.SavedState(parcel, null);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a_renamed, reason: merged with bridge method [inline-methods] */
            public androidx.slidingpanelayout.widget.SlidingPaneLayout.SavedState createFromParcel(android.os.Parcel parcel) {
                return new androidx.slidingpanelayout.widget.SlidingPaneLayout.SavedState(parcel, null);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a_renamed, reason: merged with bridge method [inline-methods] */
            public androidx.slidingpanelayout.widget.SlidingPaneLayout.SavedState[] newArray(int i_renamed) {
                return new androidx.slidingpanelayout.widget.SlidingPaneLayout.SavedState[i_renamed];
            }
        };
        boolean isOpen;

        SavedState(android.os.Parcelable parcelable) {
            super(parcelable);
        }

        SavedState(android.os.Parcel parcel, java.lang.ClassLoader classLoader) {
            super(parcel, classLoader);
            this.isOpen = parcel.readInt() != 0;
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(android.os.Parcel parcel, int i_renamed) {
            super.writeToParcel(parcel, i_renamed);
            parcel.writeInt(this.isOpen ? 1 : 0);
        }
    }

    private class a_renamed implements java.lang.Runnable {

        /* renamed from: a_renamed, reason: collision with root package name */
        final android.view.View f1656a;

        a_renamed(android.view.View view) {
            this.f1656a = view;
        }

        @Override // java.lang.Runnable
        public void run() throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
            if (this.f1656a.getParent() == androidx.slidingpanelayout.widget.SlidingPaneLayout.this) {
                this.f1656a.setLayerType(0, null);
                androidx.slidingpanelayout.widget.SlidingPaneLayout.this.b_renamed(this.f1656a);
            }
            androidx.slidingpanelayout.widget.SlidingPaneLayout.this.g_renamed.remove(this);
        }
    }

    boolean f_renamed() {
        return androidx.core.h_renamed.v_renamed.g_renamed(this) == 1;
    }
}

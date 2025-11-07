package androidx.appcompat.widget;

/* compiled from: DropDownListView.java */
/* loaded from: classes.dex */
class ab_renamed extends android.widget.ListView {

    /* renamed from: a_renamed, reason: collision with root package name */
    androidx.appcompat.widget.ab_renamed.b_renamed f523a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private final android.graphics.Rect f524b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private int f525c;
    private int d_renamed;
    private int e_renamed;
    private int f_renamed;
    private int g_renamed;
    private java.lang.reflect.Field h_renamed;
    private androidx.appcompat.widget.ab_renamed.a_renamed i_renamed;
    private boolean j_renamed;
    private boolean k_renamed;
    private boolean l_renamed;
    private androidx.core.h_renamed.z_renamed m_renamed;
    private androidx.core.widget.f_renamed n_renamed;

    ab_renamed(android.content.Context context, boolean z_renamed) {
        super(context, null, androidx.appcompat.R_renamed.attr.dropDownListViewStyle);
        this.f524b = new android.graphics.Rect();
        this.f525c = 0;
        this.d_renamed = 0;
        this.e_renamed = 0;
        this.f_renamed = 0;
        this.k_renamed = z_renamed;
        setCacheColorHint(0);
        try {
            this.h_renamed = android.widget.AbsListView.class.getDeclaredField("mIsChildViewEnabled");
            this.h_renamed.setAccessible(true);
        } catch (java.lang.NoSuchFieldException e_renamed) {
            e_renamed.printStackTrace();
        }
    }

    @Override // android.view.View
    public boolean isInTouchMode() {
        return (this.k_renamed && this.j_renamed) || super.isInTouchMode();
    }

    @Override // android.view.View
    public boolean hasWindowFocus() {
        return this.k_renamed || super.hasWindowFocus();
    }

    @Override // android.view.View
    public boolean isFocused() {
        return this.k_renamed || super.isFocused();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean hasFocus() {
        return this.k_renamed || super.hasFocus();
    }

    @Override // android.widget.AbsListView
    public void setSelector(android.graphics.drawable.Drawable drawable) {
        this.i_renamed = drawable != null ? new androidx.appcompat.widget.ab_renamed.a_renamed(drawable) : null;
        super.setSelector(this.i_renamed);
        android.graphics.Rect rect = new android.graphics.Rect();
        if (drawable != null) {
            drawable.getPadding(rect);
        }
        this.f525c = rect.left;
        this.d_renamed = rect.top;
        this.e_renamed = rect.right;
        this.f_renamed = rect.bottom;
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        if (this.f523a != null) {
            return;
        }
        super.drawableStateChanged();
        setSelectorEnabled(true);
        a_renamed();
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.ViewGroup, android.view.View
    protected void dispatchDraw(android.graphics.Canvas canvas) {
        a_renamed(canvas);
        super.dispatchDraw(canvas);
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(android.view.MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.g_renamed = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
        }
        androidx.appcompat.widget.ab_renamed.b_renamed bVar = this.f523a;
        if (bVar != null) {
            bVar.a_renamed();
        }
        return super.onTouchEvent(motionEvent);
    }

    public int a_renamed(int i_renamed, int i2, int i3, int i4, int i5) {
        int iMakeMeasureSpec;
        int listPaddingTop = getListPaddingTop();
        int listPaddingBottom = getListPaddingBottom();
        getListPaddingLeft();
        getListPaddingRight();
        int dividerHeight = getDividerHeight();
        android.graphics.drawable.Drawable divider = getDivider();
        android.widget.ListAdapter adapter = getAdapter();
        if (adapter == null) {
            return listPaddingTop + listPaddingBottom;
        }
        int i6 = listPaddingTop + listPaddingBottom;
        if (dividerHeight <= 0 || divider == null) {
            dividerHeight = 0;
        }
        int count = adapter.getCount();
        int measuredHeight = i6;
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        android.view.View view = null;
        while (i7 < count) {
            int itemViewType = adapter.getItemViewType(i7);
            if (itemViewType != i8) {
                view = null;
                i8 = itemViewType;
            }
            view = adapter.getView(i7, view, this);
            android.view.ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = generateDefaultLayoutParams();
                view.setLayoutParams(layoutParams);
            }
            if (layoutParams.height > 0) {
                iMakeMeasureSpec = android.view.View.MeasureSpec.makeMeasureSpec(layoutParams.height, 1073741824);
            } else {
                iMakeMeasureSpec = android.view.View.MeasureSpec.makeMeasureSpec(0, 0);
            }
            view.measure(i_renamed, iMakeMeasureSpec);
            view.forceLayout();
            if (i7 > 0) {
                measuredHeight += dividerHeight;
            }
            measuredHeight += view.getMeasuredHeight();
            if (measuredHeight >= i4) {
                return (i5 < 0 || i7 <= i5 || i9 <= 0 || measuredHeight == i4) ? i4 : i9;
            }
            if (i5 >= 0 && i7 >= i5) {
                i9 = measuredHeight;
            }
            i7++;
        }
        return measuredHeight;
    }

    private void setSelectorEnabled(boolean z_renamed) {
        androidx.appcompat.widget.ab_renamed.a_renamed aVar = this.i_renamed;
        if (aVar != null) {
            aVar.a_renamed(z_renamed);
        }
    }

    /* compiled from: DropDownListView.java */
    private static class a_renamed extends androidx.appcompat.b_renamed.a_renamed.c_renamed {

        /* renamed from: a_renamed, reason: collision with root package name */
        private boolean f526a;

        a_renamed(android.graphics.drawable.Drawable drawable) {
            super(drawable);
            this.f526a = true;
        }

        void a_renamed(boolean z_renamed) {
            this.f526a = z_renamed;
        }

        @Override // androidx.appcompat.b_renamed.a_renamed.c_renamed, android.graphics.drawable.Drawable
        public boolean setState(int[] iArr) {
            if (this.f526a) {
                return super.setState(iArr);
            }
            return false;
        }

        @Override // androidx.appcompat.b_renamed.a_renamed.c_renamed, android.graphics.drawable.Drawable
        public void draw(android.graphics.Canvas canvas) {
            if (this.f526a) {
                super.draw(canvas);
            }
        }

        @Override // androidx.appcompat.b_renamed.a_renamed.c_renamed, android.graphics.drawable.Drawable
        public void setHotspot(float f_renamed, float f2) {
            if (this.f526a) {
                super.setHotspot(f_renamed, f2);
            }
        }

        @Override // androidx.appcompat.b_renamed.a_renamed.c_renamed, android.graphics.drawable.Drawable
        public void setHotspotBounds(int i_renamed, int i2, int i3, int i4) {
            if (this.f526a) {
                super.setHotspotBounds(i_renamed, i2, i3, i4);
            }
        }

        @Override // androidx.appcompat.b_renamed.a_renamed.c_renamed, android.graphics.drawable.Drawable
        public boolean setVisible(boolean z_renamed, boolean z2) {
            if (this.f526a) {
                return super.setVisible(z_renamed, z2);
            }
            return false;
        }
    }

    @Override // android.view.View
    public boolean onHoverEvent(android.view.MotionEvent motionEvent) {
        if (android.os.Build.VERSION.SDK_INT < 26) {
            return super.onHoverEvent(motionEvent);
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 10 && this.f523a == null) {
            this.f523a = new androidx.appcompat.widget.ab_renamed.b_renamed();
            this.f523a.b_renamed();
        }
        boolean zOnHoverEvent = super.onHoverEvent(motionEvent);
        if (actionMasked == 9 || actionMasked == 7) {
            int iPointToPosition = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
            if (iPointToPosition != -1 && iPointToPosition != getSelectedItemPosition()) {
                android.view.View childAt = getChildAt(iPointToPosition - getFirstVisiblePosition());
                if (childAt.isEnabled()) {
                    setSelectionFromTop(iPointToPosition, childAt.getTop() - getTop());
                }
                a_renamed();
            }
        } else {
            setSelection(-1);
        }
        return zOnHoverEvent;
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        this.f523a = null;
        super.onDetachedFromWindow();
    }

    /* JADX WARN: Removed duplicated region for block: B_renamed:23:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:25:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:29:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:9:0x0011  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean a_renamed(android.view.MotionEvent r8, int r9) throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException {
        /*
            r7 = this;
            int r0 = r8.getActionMasked()
            r1 = 0
            r2 = 1
            if (r0 == r2) goto L16
            r3 = 2
            if (r0 == r3) goto L14
            r9 = 3
            if (r0 == r9) goto L11
        Le:
            r9 = r1
            r3 = r2
            goto L46
        L11:
            r9 = r1
            r3 = r9
            goto L46
        L14:
            r3 = r2
            goto L17
        L16:
            r3 = r1
        L17:
            int r9 = r8.findPointerIndex(r9)
            if (r9 >= 0) goto L1e
            goto L11
        L1e:
            float r4 = r8.getX(r9)
            int r4 = (int) r4
            float r9 = r8.getY(r9)
            int r9 = (int) r9
            int r5 = r7.pointToPosition(r4, r9)
            r6 = -1
            if (r5 != r6) goto L31
            r9 = r2
            goto L46
        L31:
            int r3 = r7.getFirstVisiblePosition()
            int r3 = r5 - r3
            android.view.View r3 = r7.getChildAt(r3)
            float r4 = (float) r4
            float r9 = (float) r9
            r7.a_renamed(r3, r5, r4, r9)
            if (r0 != r2) goto Le
            r7.a_renamed(r3, r5)
            goto Le
        L46:
            if (r3 == 0) goto L4a
            if (r9 == 0) goto L4d
        L4a:
            r7.b_renamed()
        L4d:
            if (r3 == 0) goto L65
            androidx.core.widget.f_renamed r9 = r7.n_renamed
            if (r9 != 0) goto L5a
            androidx.core.widget.f_renamed r9 = new androidx.core.widget.f_renamed
            r9.<init>(r7)
            r7.n_renamed = r9
        L5a:
            androidx.core.widget.f_renamed r9 = r7.n_renamed
            r9.a_renamed(r2)
            androidx.core.widget.f_renamed r9 = r7.n_renamed
            r9.onTouch(r7, r8)
            goto L6c
        L65:
            androidx.core.widget.f_renamed r7 = r7.n_renamed
            if (r7 == 0) goto L6c
            r7.a_renamed(r1)
        L6c:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.ab_renamed.a_renamed(android.view.MotionEvent, int):boolean");
    }

    private void a_renamed(android.view.View view, int i_renamed) {
        performItemClick(view, i_renamed, getItemIdAtPosition(i_renamed));
    }

    void setListSelectionHidden(boolean z_renamed) {
        this.j_renamed = z_renamed;
    }

    private void a_renamed() {
        android.graphics.drawable.Drawable selector = getSelector();
        if (selector != null && c_renamed() && isPressed()) {
            selector.setState(getDrawableState());
        }
    }

    private void a_renamed(android.graphics.Canvas canvas) {
        android.graphics.drawable.Drawable selector;
        if (this.f524b.isEmpty() || (selector = getSelector()) == null) {
            return;
        }
        selector.setBounds(this.f524b);
        selector.draw(canvas);
    }

    private void a_renamed(int i_renamed, android.view.View view, float f_renamed, float f2) throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException {
        a_renamed(i_renamed, view);
        android.graphics.drawable.Drawable selector = getSelector();
        if (selector == null || i_renamed == -1) {
            return;
        }
        androidx.core.graphics.drawable.a_renamed.a_renamed(selector, f_renamed, f2);
    }

    private void a_renamed(int i_renamed, android.view.View view) throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException {
        android.graphics.drawable.Drawable selector = getSelector();
        boolean z_renamed = (selector == null || i_renamed == -1) ? false : true;
        if (z_renamed) {
            selector.setVisible(false, false);
        }
        b_renamed(i_renamed, view);
        if (z_renamed) {
            android.graphics.Rect rect = this.f524b;
            float fExactCenterX = rect.exactCenterX();
            float fExactCenterY = rect.exactCenterY();
            selector.setVisible(getVisibility() == 0, false);
            androidx.core.graphics.drawable.a_renamed.a_renamed(selector, fExactCenterX, fExactCenterY);
        }
    }

    private void b_renamed(int i_renamed, android.view.View view) throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException {
        android.graphics.Rect rect = this.f524b;
        rect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        rect.left -= this.f525c;
        rect.top -= this.d_renamed;
        rect.right += this.e_renamed;
        rect.bottom += this.f_renamed;
        try {
            boolean z_renamed = this.h_renamed.getBoolean(this);
            if (view.isEnabled() != z_renamed) {
                this.h_renamed.set(this, java.lang.Boolean.valueOf(!z_renamed));
                if (i_renamed != -1) {
                    refreshDrawableState();
                }
            }
        } catch (java.lang.IllegalAccessException e_renamed) {
            e_renamed.printStackTrace();
        }
    }

    private void b_renamed() {
        this.l_renamed = false;
        setPressed(false);
        drawableStateChanged();
        android.view.View childAt = getChildAt(this.g_renamed - getFirstVisiblePosition());
        if (childAt != null) {
            childAt.setPressed(false);
        }
        androidx.core.h_renamed.z_renamed zVar = this.m_renamed;
        if (zVar != null) {
            zVar.b_renamed();
            this.m_renamed = null;
        }
    }

    private void a_renamed(android.view.View view, int i_renamed, float f_renamed, float f2) throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException {
        android.view.View childAt;
        this.l_renamed = true;
        if (android.os.Build.VERSION.SDK_INT >= 21) {
            drawableHotspotChanged(f_renamed, f2);
        }
        if (!isPressed()) {
            setPressed(true);
        }
        layoutChildren();
        int i2 = this.g_renamed;
        if (i2 != -1 && (childAt = getChildAt(i2 - getFirstVisiblePosition())) != null && childAt != view && childAt.isPressed()) {
            childAt.setPressed(false);
        }
        this.g_renamed = i_renamed;
        float left = f_renamed - view.getLeft();
        float top = f2 - view.getTop();
        if (android.os.Build.VERSION.SDK_INT >= 21) {
            view.drawableHotspotChanged(left, top);
        }
        if (!view.isPressed()) {
            view.setPressed(true);
        }
        a_renamed(i_renamed, view, f_renamed, f2);
        setSelectorEnabled(false);
        refreshDrawableState();
    }

    private boolean c_renamed() {
        return this.l_renamed;
    }

    /* compiled from: DropDownListView.java */
    private class b_renamed implements java.lang.Runnable {
        b_renamed() {
        }

        @Override // java.lang.Runnable
        public void run() {
            androidx.appcompat.widget.ab_renamed abVar = androidx.appcompat.widget.ab_renamed.this;
            abVar.f523a = null;
            abVar.drawableStateChanged();
        }

        public void a_renamed() {
            androidx.appcompat.widget.ab_renamed abVar = androidx.appcompat.widget.ab_renamed.this;
            abVar.f523a = null;
            abVar.removeCallbacks(this);
        }

        public void b_renamed() {
            androidx.appcompat.widget.ab_renamed.this.post(this);
        }
    }
}

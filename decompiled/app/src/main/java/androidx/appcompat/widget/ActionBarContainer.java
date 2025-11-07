package androidx.appcompat.widget;

/* loaded from: classes.dex */
public class ActionBarContainer extends android.widget.FrameLayout {

    /* renamed from: a_renamed, reason: collision with root package name */
    android.graphics.drawable.Drawable f419a;

    /* renamed from: b_renamed, reason: collision with root package name */
    android.graphics.drawable.Drawable f420b;

    /* renamed from: c_renamed, reason: collision with root package name */
    android.graphics.drawable.Drawable f421c;
    boolean d_renamed;
    boolean e_renamed;
    private boolean f_renamed;
    private android.view.View g_renamed;
    private android.view.View h_renamed;
    private android.view.View i_renamed;
    private int j_renamed;

    @Override // android.view.ViewGroup, android.view.ViewParent
    public android.view.ActionMode startActionModeForChild(android.view.View view, android.view.ActionMode.Callback callback) {
        return null;
    }

    public ActionBarContainer(android.content.Context context) {
        this(context, null);
    }

    public ActionBarContainer(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        androidx.core.h_renamed.v_renamed.a_renamed(this, new androidx.appcompat.widget.b_renamed(this));
        android.content.res.TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, androidx.appcompat.R_renamed.styleable.ActionBar);
        this.f419a = typedArrayObtainStyledAttributes.getDrawable(androidx.appcompat.R_renamed.styleable.ActionBar_background);
        this.f420b = typedArrayObtainStyledAttributes.getDrawable(androidx.appcompat.R_renamed.styleable.ActionBar_backgroundStacked);
        this.j_renamed = typedArrayObtainStyledAttributes.getDimensionPixelSize(androidx.appcompat.R_renamed.styleable.ActionBar_height, -1);
        if (getId() == androidx.appcompat.R_renamed.id_renamed.split_action_bar) {
            this.d_renamed = true;
            this.f421c = typedArrayObtainStyledAttributes.getDrawable(androidx.appcompat.R_renamed.styleable.ActionBar_backgroundSplit);
        }
        typedArrayObtainStyledAttributes.recycle();
        boolean z_renamed = false;
        if (!this.d_renamed ? !(this.f419a != null || this.f420b != null) : this.f421c == null) {
            z_renamed = true;
        }
        setWillNotDraw(z_renamed);
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        this.h_renamed = findViewById(androidx.appcompat.R_renamed.id_renamed.action_bar);
        this.i_renamed = findViewById(androidx.appcompat.R_renamed.id_renamed.action_context_bar);
    }

    public void setPrimaryBackground(android.graphics.drawable.Drawable drawable) {
        android.graphics.drawable.Drawable drawable2 = this.f419a;
        if (drawable2 != null) {
            drawable2.setCallback(null);
            unscheduleDrawable(this.f419a);
        }
        this.f419a = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            android.view.View view = this.h_renamed;
            if (view != null) {
                this.f419a.setBounds(view.getLeft(), this.h_renamed.getTop(), this.h_renamed.getRight(), this.h_renamed.getBottom());
            }
        }
        boolean z_renamed = true;
        if (!this.d_renamed ? this.f419a != null || this.f420b != null : this.f421c != null) {
            z_renamed = false;
        }
        setWillNotDraw(z_renamed);
        invalidate();
        if (android.os.Build.VERSION.SDK_INT >= 21) {
            invalidateOutline();
        }
    }

    public void setStackedBackground(android.graphics.drawable.Drawable drawable) {
        android.graphics.drawable.Drawable drawable2;
        android.graphics.drawable.Drawable drawable3 = this.f420b;
        if (drawable3 != null) {
            drawable3.setCallback(null);
            unscheduleDrawable(this.f420b);
        }
        this.f420b = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            if (this.e_renamed && (drawable2 = this.f420b) != null) {
                drawable2.setBounds(this.g_renamed.getLeft(), this.g_renamed.getTop(), this.g_renamed.getRight(), this.g_renamed.getBottom());
            }
        }
        boolean z_renamed = true;
        if (!this.d_renamed ? this.f419a != null || this.f420b != null : this.f421c != null) {
            z_renamed = false;
        }
        setWillNotDraw(z_renamed);
        invalidate();
        if (android.os.Build.VERSION.SDK_INT >= 21) {
            invalidateOutline();
        }
    }

    public void setSplitBackground(android.graphics.drawable.Drawable drawable) {
        android.graphics.drawable.Drawable drawable2;
        android.graphics.drawable.Drawable drawable3 = this.f421c;
        if (drawable3 != null) {
            drawable3.setCallback(null);
            unscheduleDrawable(this.f421c);
        }
        this.f421c = drawable;
        boolean z_renamed = false;
        if (drawable != null) {
            drawable.setCallback(this);
            if (this.d_renamed && (drawable2 = this.f421c) != null) {
                drawable2.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
            }
        }
        if (!this.d_renamed ? !(this.f419a != null || this.f420b != null) : this.f421c == null) {
            z_renamed = true;
        }
        setWillNotDraw(z_renamed);
        invalidate();
        if (android.os.Build.VERSION.SDK_INT >= 21) {
            invalidateOutline();
        }
    }

    @Override // android.view.View
    public void setVisibility(int i_renamed) {
        super.setVisibility(i_renamed);
        boolean z_renamed = i_renamed == 0;
        android.graphics.drawable.Drawable drawable = this.f419a;
        if (drawable != null) {
            drawable.setVisible(z_renamed, false);
        }
        android.graphics.drawable.Drawable drawable2 = this.f420b;
        if (drawable2 != null) {
            drawable2.setVisible(z_renamed, false);
        }
        android.graphics.drawable.Drawable drawable3 = this.f421c;
        if (drawable3 != null) {
            drawable3.setVisible(z_renamed, false);
        }
    }

    @Override // android.view.View
    protected boolean verifyDrawable(android.graphics.drawable.Drawable drawable) {
        return (drawable == this.f419a && !this.d_renamed) || (drawable == this.f420b && this.e_renamed) || ((drawable == this.f421c && this.d_renamed) || super.verifyDrawable(drawable));
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        android.graphics.drawable.Drawable drawable = this.f419a;
        if (drawable != null && drawable.isStateful()) {
            this.f419a.setState(getDrawableState());
        }
        android.graphics.drawable.Drawable drawable2 = this.f420b;
        if (drawable2 != null && drawable2.isStateful()) {
            this.f420b.setState(getDrawableState());
        }
        android.graphics.drawable.Drawable drawable3 = this.f421c;
        if (drawable3 == null || !drawable3.isStateful()) {
            return;
        }
        this.f421c.setState(getDrawableState());
    }

    @Override // android.view.ViewGroup, android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        android.graphics.drawable.Drawable drawable = this.f419a;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
        android.graphics.drawable.Drawable drawable2 = this.f420b;
        if (drawable2 != null) {
            drawable2.jumpToCurrentState();
        }
        android.graphics.drawable.Drawable drawable3 = this.f421c;
        if (drawable3 != null) {
            drawable3.jumpToCurrentState();
        }
    }

    public void setTransitioning(boolean z_renamed) {
        this.f_renamed = z_renamed;
        setDescendantFocusability(z_renamed ? 393216 : com.sensetime.stmobile.STMobileHumanActionNative.ST_MOBILE_DETECT_MODE_IMAGE);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(android.view.MotionEvent motionEvent) {
        return this.f_renamed || super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(android.view.MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        return true;
    }

    @Override // android.view.View
    public boolean onHoverEvent(android.view.MotionEvent motionEvent) {
        super.onHoverEvent(motionEvent);
        return true;
    }

    public void setTabContainer(androidx.appcompat.widget.ak_renamed akVar) {
        android.view.View view = this.g_renamed;
        if (view != null) {
            removeView(view);
        }
        this.g_renamed = akVar;
        if (akVar != null) {
            addView(akVar);
            android.view.ViewGroup.LayoutParams layoutParams = akVar.getLayoutParams();
            layoutParams.width = -1;
            layoutParams.height = -2;
            akVar.setAllowCollapse(false);
        }
    }

    public android.view.View getTabContainer() {
        return this.g_renamed;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public android.view.ActionMode startActionModeForChild(android.view.View view, android.view.ActionMode.Callback callback, int i_renamed) {
        if (i_renamed != 0) {
            return super.startActionModeForChild(view, callback, i_renamed);
        }
        return null;
    }

    private boolean a_renamed(android.view.View view) {
        return view == null || view.getVisibility() == 8 || view.getMeasuredHeight() == 0;
    }

    private int b_renamed(android.view.View view) {
        android.widget.FrameLayout.LayoutParams layoutParams = (android.widget.FrameLayout.LayoutParams) view.getLayoutParams();
        return view.getMeasuredHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i_renamed, int i2) {
        int iB;
        int i3;
        if (this.h_renamed == null && android.view.View.MeasureSpec.getMode(i2) == Integer.MIN_VALUE && (i3 = this.j_renamed) >= 0) {
            i2 = android.view.View.MeasureSpec.makeMeasureSpec(java.lang.Math.min(i3, android.view.View.MeasureSpec.getSize(i2)), Integer.MIN_VALUE);
        }
        super.onMeasure(i_renamed, i2);
        if (this.h_renamed == null) {
            return;
        }
        int mode = android.view.View.MeasureSpec.getMode(i2);
        android.view.View view = this.g_renamed;
        if (view == null || view.getVisibility() == 8 || mode == 1073741824) {
            return;
        }
        if (!a_renamed(this.h_renamed)) {
            iB = b_renamed(this.h_renamed);
        } else {
            iB = !a_renamed(this.i_renamed) ? b_renamed(this.i_renamed) : 0;
        }
        setMeasuredDimension(getMeasuredWidth(), java.lang.Math.min(iB + b_renamed(this.g_renamed), mode == Integer.MIN_VALUE ? android.view.View.MeasureSpec.getSize(i2) : Integer.MAX_VALUE));
    }

    /* JADX WARN: Removed duplicated region for block: B_renamed:17:0x004a A_renamed[PHI: r0
      0x004a: PHI (r0v8 boolean) = (r0v1 boolean), (r0v1 boolean), (r0v0 boolean) binds: [B_renamed:31:0x00a7, B_renamed:33:0x00ab, B_renamed:15:0x003b] A_renamed[DONT_GENERATE, DONT_INLINE]] */
    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onLayout(boolean r6, int r7, int r8, int r9, int r10) {
        /*
            r5 = this;
            super.onLayout(r6, r7, r8, r9, r10)
            android.view.View r6 = r5.g_renamed
            r8 = 8
            r10 = 1
            r0 = 0
            if (r6 == 0) goto L13
            int r1 = r6.getVisibility()
            if (r1 == r8) goto L13
            r1 = r10
            goto L14
        L13:
            r1 = r0
        L14:
            if (r6 == 0) goto L35
            int r2 = r6.getVisibility()
            if (r2 == r8) goto L35
            int r8 = r5.getMeasuredHeight()
            android.view.ViewGroup$LayoutParams r2 = r6.getLayoutParams()
            android.widget.FrameLayout$LayoutParams r2 = (android.widget.FrameLayout.LayoutParams) r2
            int r3 = r6.getMeasuredHeight()
            int r3 = r8 - r3
            int r4 = r2.bottomMargin
            int r3 = r3 - r4
            int r2 = r2.bottomMargin
            int r8 = r8 - r2
            r6.layout(r7, r3, r9, r8)
        L35:
            boolean r7 = r5.d_renamed
            if (r7 == 0) goto L4d
            android.graphics.drawable.Drawable r6 = r5.f421c
            if (r6 == 0) goto L4a
            int r7 = r5.getMeasuredWidth()
            int r8 = r5.getMeasuredHeight()
            r6.setBounds(r0, r0, r7, r8)
            goto Lc0
        L4a:
            r10 = r0
            goto Lc0
        L4d:
            android.graphics.drawable.Drawable r7 = r5.f419a
            if (r7 == 0) goto La5
            android.view.View r7 = r5.h_renamed
            int r7 = r7.getVisibility()
            if (r7 != 0) goto L77
            android.graphics.drawable.Drawable r7 = r5.f419a
            android.view.View r8 = r5.h_renamed
            int r8 = r8.getLeft()
            android.view.View r9 = r5.h_renamed
            int r9 = r9.getTop()
            android.view.View r0 = r5.h_renamed
            int r0 = r0.getRight()
            android.view.View r2 = r5.h_renamed
            int r2 = r2.getBottom()
            r7.setBounds(r8, r9, r0, r2)
            goto La4
        L77:
            android.view.View r7 = r5.i_renamed
            if (r7 == 0) goto L9f
            int r7 = r7.getVisibility()
            if (r7 != 0) goto L9f
            android.graphics.drawable.Drawable r7 = r5.f419a
            android.view.View r8 = r5.i_renamed
            int r8 = r8.getLeft()
            android.view.View r9 = r5.i_renamed
            int r9 = r9.getTop()
            android.view.View r0 = r5.i_renamed
            int r0 = r0.getRight()
            android.view.View r2 = r5.i_renamed
            int r2 = r2.getBottom()
            r7.setBounds(r8, r9, r0, r2)
            goto La4
        L9f:
            android.graphics.drawable.Drawable r7 = r5.f419a
            r7.setBounds(r0, r0, r0, r0)
        La4:
            r0 = r10
        La5:
            r5.e_renamed = r1
            if (r1 == 0) goto L4a
            android.graphics.drawable.Drawable r7 = r5.f420b
            if (r7 == 0) goto L4a
            int r8 = r6.getLeft()
            int r9 = r6.getTop()
            int r0 = r6.getRight()
            int r6 = r6.getBottom()
            r7.setBounds(r8, r9, r0, r6)
        Lc0:
            if (r10 == 0) goto Lc5
            r5.invalidate()
        Lc5:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.ActionBarContainer.onLayout(boolean, int, int, int, int):void");
    }
}

package com.coui.appcompat.widget;

/* compiled from: COUIListViewCompat.java */
/* loaded from: classes.dex */
public class i_renamed extends android.widget.ListView {
    private static final int[] f_renamed = {0};

    /* renamed from: a_renamed, reason: collision with root package name */
    final android.graphics.Rect f2956a;

    /* renamed from: b_renamed, reason: collision with root package name */
    int f2957b;

    /* renamed from: c_renamed, reason: collision with root package name */
    int f2958c;
    int d_renamed;
    int e_renamed;
    private java.lang.reflect.Field g_renamed;
    private com.coui.appcompat.widget.i_renamed.a_renamed h_renamed;

    protected boolean c_renamed() {
        return false;
    }

    public i_renamed(android.content.Context context, android.util.AttributeSet attributeSet, int i_renamed) {
        super(context, attributeSet, i_renamed);
        this.f2956a = new android.graphics.Rect();
        this.f2957b = 0;
        this.f2958c = 0;
        this.d_renamed = 0;
        this.e_renamed = 0;
        try {
            this.g_renamed = android.widget.AbsListView.class.getDeclaredField("mIsChildViewEnabled");
            this.g_renamed.setAccessible(true);
        } catch (java.lang.NoSuchFieldException e_renamed) {
            e_renamed.printStackTrace();
        }
    }

    @Override // android.widget.AbsListView
    public void setSelector(android.graphics.drawable.Drawable drawable) {
        this.h_renamed = drawable != null ? new com.coui.appcompat.widget.i_renamed.a_renamed(drawable) : null;
        super.setSelector(this.h_renamed);
        android.graphics.Rect rect = new android.graphics.Rect();
        if (drawable != null) {
            drawable.getPadding(rect);
        }
        this.f2957b = rect.left;
        this.f2958c = rect.top;
        this.d_renamed = rect.right;
        this.e_renamed = rect.bottom;
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        setSelectorEnabled(true);
        a_renamed();
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.ViewGroup, android.view.View
    protected void dispatchDraw(android.graphics.Canvas canvas) {
        a_renamed(canvas);
        super.dispatchDraw(canvas);
    }

    protected void a_renamed() {
        android.graphics.drawable.Drawable selector = getSelector();
        if (selector == null || !b_renamed()) {
            return;
        }
        selector.setState(getDrawableState());
    }

    protected boolean b_renamed() {
        return c_renamed() && isPressed();
    }

    protected void a_renamed(android.graphics.Canvas canvas) {
        android.graphics.drawable.Drawable selector;
        if (this.f2956a.isEmpty() || (selector = getSelector()) == null) {
            return;
        }
        selector.setBounds(this.f2956a);
        selector.draw(canvas);
    }

    protected void a_renamed(int i_renamed, android.view.View view, float f2, float f3) throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException {
        a_renamed(i_renamed, view);
        android.graphics.drawable.Drawable selector = getSelector();
        if (selector == null || i_renamed == -1) {
            return;
        }
        androidx.core.graphics.drawable.a_renamed.a_renamed(selector, f2, f3);
    }

    protected void a_renamed(int i_renamed, android.view.View view) throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException {
        android.graphics.drawable.Drawable selector = getSelector();
        boolean z_renamed = (selector == null || i_renamed == -1) ? false : true;
        if (z_renamed) {
            selector.setVisible(false, false);
        }
        b_renamed(i_renamed, view);
        if (z_renamed) {
            android.graphics.Rect rect = this.f2956a;
            float fExactCenterX = rect.exactCenterX();
            float fExactCenterY = rect.exactCenterY();
            selector.setVisible(getVisibility() == 0, false);
            androidx.core.graphics.drawable.a_renamed.a_renamed(selector, fExactCenterX, fExactCenterY);
        }
    }

    protected void b_renamed(int i_renamed, android.view.View view) throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException {
        android.graphics.Rect rect = this.f2956a;
        rect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        rect.left -= this.f2957b;
        rect.top -= this.f2958c;
        rect.right += this.d_renamed;
        rect.bottom += this.e_renamed;
        try {
            boolean z_renamed = this.g_renamed.getBoolean(this);
            if (view.isEnabled() != z_renamed) {
                this.g_renamed.set(this, java.lang.Boolean.valueOf(!z_renamed));
                if (i_renamed != -1) {
                    refreshDrawableState();
                }
            }
        } catch (java.lang.IllegalAccessException e_renamed) {
            e_renamed.printStackTrace();
        }
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
            if (layoutParams != null && layoutParams.height > 0) {
                iMakeMeasureSpec = android.view.View.MeasureSpec.makeMeasureSpec(layoutParams.height, 1073741824);
            } else {
                iMakeMeasureSpec = android.view.View.MeasureSpec.makeMeasureSpec(0, 0);
            }
            view.measure(i_renamed, iMakeMeasureSpec);
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

    protected void setSelectorEnabled(boolean z_renamed) {
        com.coui.appcompat.widget.i_renamed.a_renamed aVar = this.h_renamed;
        if (aVar != null) {
            aVar.a_renamed(z_renamed);
        }
    }

    /* compiled from: COUIListViewCompat.java */
    private static class a_renamed extends androidx.appcompat.b_renamed.a_renamed.c_renamed {

        /* renamed from: a_renamed, reason: collision with root package name */
        private boolean f2959a;

        public a_renamed(android.graphics.drawable.Drawable drawable) {
            super(drawable);
            this.f2959a = true;
        }

        void a_renamed(boolean z_renamed) {
            this.f2959a = z_renamed;
        }

        @Override // androidx.appcompat.b_renamed.a_renamed.c_renamed, android.graphics.drawable.Drawable
        public boolean setState(int[] iArr) {
            if (this.f2959a) {
                return super.setState(iArr);
            }
            return false;
        }

        @Override // androidx.appcompat.b_renamed.a_renamed.c_renamed, android.graphics.drawable.Drawable
        public void draw(android.graphics.Canvas canvas) {
            if (this.f2959a) {
                super.draw(canvas);
            }
        }

        @Override // androidx.appcompat.b_renamed.a_renamed.c_renamed, android.graphics.drawable.Drawable
        public boolean setVisible(boolean z_renamed, boolean z2) {
            if (this.f2959a) {
                return super.setVisible(z_renamed, z2);
            }
            return false;
        }
    }
}

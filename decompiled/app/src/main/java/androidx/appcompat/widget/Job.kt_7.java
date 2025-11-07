package androidx.appcompat.widget;

/* compiled from: ScrollingTabContainerView.java */
/* loaded from: classes.dex */
public class ak_renamed extends android.widget.HorizontalScrollView implements android.widget.AdapterView.OnItemSelectedListener {
    private static final android.view.animation.Interpolator j_renamed = new android.view.animation.DecelerateInterpolator();

    /* renamed from: a_renamed, reason: collision with root package name */
    java.lang.Runnable f554a;

    /* renamed from: b_renamed, reason: collision with root package name */
    androidx.appcompat.widget.LinearLayoutCompat f555b;

    /* renamed from: c_renamed, reason: collision with root package name */
    int f556c;
    int d_renamed;
    private androidx.appcompat.widget.ak_renamed.b_renamed e_renamed;
    private android.widget.Spinner f_renamed;
    private boolean g_renamed;
    private int h_renamed;
    private int i_renamed;

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onNothingSelected(android.widget.AdapterView<?> adapterView) {
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.View
    public void onMeasure(int i_renamed, int i2) {
        int mode = android.view.View.MeasureSpec.getMode(i_renamed);
        boolean z_renamed = mode == 1073741824;
        setFillViewport(z_renamed);
        int childCount = this.f555b.getChildCount();
        if (childCount > 1 && (mode == 1073741824 || mode == Integer.MIN_VALUE)) {
            if (childCount > 2) {
                this.f556c = (int) (android.view.View.MeasureSpec.getSize(i_renamed) * 0.4f);
            } else {
                this.f556c = android.view.View.MeasureSpec.getSize(i_renamed) / 2;
            }
            this.f556c = java.lang.Math.min(this.f556c, this.d_renamed);
        } else {
            this.f556c = -1;
        }
        int iMakeMeasureSpec = android.view.View.MeasureSpec.makeMeasureSpec(this.h_renamed, 1073741824);
        if (!z_renamed && this.g_renamed) {
            this.f555b.measure(0, iMakeMeasureSpec);
            if (this.f555b.getMeasuredWidth() > android.view.View.MeasureSpec.getSize(i_renamed)) {
                b_renamed();
            } else {
                c_renamed();
            }
        } else {
            c_renamed();
        }
        int measuredWidth = getMeasuredWidth();
        super.onMeasure(i_renamed, iMakeMeasureSpec);
        int measuredWidth2 = getMeasuredWidth();
        if (!z_renamed || measuredWidth == measuredWidth2) {
            return;
        }
        setTabSelected(this.i_renamed);
    }

    private boolean a_renamed() {
        android.widget.Spinner spinner = this.f_renamed;
        return spinner != null && spinner.getParent() == this;
    }

    public void setAllowCollapse(boolean z_renamed) {
        this.g_renamed = z_renamed;
    }

    private void b_renamed() {
        if (a_renamed()) {
            return;
        }
        if (this.f_renamed == null) {
            this.f_renamed = d_renamed();
        }
        removeView(this.f555b);
        addView(this.f_renamed, new android.view.ViewGroup.LayoutParams(-2, -1));
        if (this.f_renamed.getAdapter() == null) {
            this.f_renamed.setAdapter((android.widget.SpinnerAdapter) new androidx.appcompat.widget.ak_renamed.a_renamed());
        }
        java.lang.Runnable runnable = this.f554a;
        if (runnable != null) {
            removeCallbacks(runnable);
            this.f554a = null;
        }
        this.f_renamed.setSelection(this.i_renamed);
    }

    private boolean c_renamed() {
        if (!a_renamed()) {
            return false;
        }
        removeView(this.f_renamed);
        addView(this.f555b, new android.view.ViewGroup.LayoutParams(-2, -1));
        setTabSelected(this.f_renamed.getSelectedItemPosition());
        return false;
    }

    public void setTabSelected(int i_renamed) {
        this.i_renamed = i_renamed;
        int childCount = this.f555b.getChildCount();
        int i2 = 0;
        while (i2 < childCount) {
            android.view.View childAt = this.f555b.getChildAt(i2);
            boolean z_renamed = i2 == i_renamed;
            childAt.setSelected(z_renamed);
            if (z_renamed) {
                a_renamed(i_renamed);
            }
            i2++;
        }
        android.widget.Spinner spinner = this.f_renamed;
        if (spinner == null || i_renamed < 0) {
            return;
        }
        spinner.setSelection(i_renamed);
    }

    public void setContentHeight(int i_renamed) {
        this.h_renamed = i_renamed;
        requestLayout();
    }

    private android.widget.Spinner d_renamed() {
        androidx.appcompat.widget.AppCompatSpinner appCompatSpinner = new androidx.appcompat.widget.AppCompatSpinner(getContext(), null, androidx.appcompat.R_renamed.attr.actionDropDownStyle);
        appCompatSpinner.setLayoutParams(new androidx.appcompat.widget.LinearLayoutCompat.a_renamed(-2, -1));
        appCompatSpinner.setOnItemSelectedListener(this);
        return appCompatSpinner;
    }

    @Override // android.view.View
    protected void onConfigurationChanged(android.content.res.Configuration configuration) {
        super.onConfigurationChanged(configuration);
        androidx.appcompat.view.a_renamed aVarA = androidx.appcompat.view.a_renamed.a_renamed(getContext());
        setContentHeight(aVarA.e_renamed());
        this.d_renamed = aVarA.g_renamed();
    }

    public void a_renamed(int i_renamed) {
        final android.view.View childAt = this.f555b.getChildAt(i_renamed);
        java.lang.Runnable runnable = this.f554a;
        if (runnable != null) {
            removeCallbacks(runnable);
        }
        this.f554a = new java.lang.Runnable() { // from class: androidx.appcompat.widget.ak_renamed.1
            @Override // java.lang.Runnable
            public void run() {
                androidx.appcompat.widget.ak_renamed.this.smoothScrollTo(childAt.getLeft() - ((androidx.appcompat.widget.ak_renamed.this.getWidth() - childAt.getWidth()) / 2), 0);
                androidx.appcompat.widget.ak_renamed.this.f554a = null;
            }
        };
        post(this.f554a);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        java.lang.Runnable runnable = this.f554a;
        if (runnable != null) {
            post(runnable);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        java.lang.Runnable runnable = this.f554a;
        if (runnable != null) {
            removeCallbacks(runnable);
        }
    }

    androidx.appcompat.widget.ak_renamed.c_renamed a_renamed(androidx.appcompat.app.a_renamed.c_renamed cVar, boolean z_renamed) {
        androidx.appcompat.widget.ak_renamed.c_renamed cVar2 = new androidx.appcompat.widget.ak_renamed.c_renamed(getContext(), cVar, z_renamed);
        if (z_renamed) {
            cVar2.setBackgroundDrawable(null);
            cVar2.setLayoutParams(new android.widget.AbsListView.LayoutParams(-1, this.h_renamed));
        } else {
            cVar2.setFocusable(true);
            if (this.e_renamed == null) {
                this.e_renamed = new androidx.appcompat.widget.ak_renamed.b_renamed();
            }
            cVar2.setOnClickListener(this.e_renamed);
        }
        return cVar2;
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onItemSelected(android.widget.AdapterView<?> adapterView, android.view.View view, int i_renamed, long j2) {
        ((androidx.appcompat.widget.ak_renamed.c_renamed) view).b_renamed().d_renamed();
    }

    /* compiled from: ScrollingTabContainerView.java */
    private class c_renamed extends android.widget.LinearLayout {

        /* renamed from: b_renamed, reason: collision with root package name */
        private final int[] f562b;

        /* renamed from: c_renamed, reason: collision with root package name */
        private androidx.appcompat.app.a_renamed.c_renamed f563c;
        private android.widget.TextView d_renamed;
        private android.widget.ImageView e_renamed;
        private android.view.View f_renamed;

        public c_renamed(android.content.Context context, androidx.appcompat.app.a_renamed.c_renamed cVar, boolean z_renamed) {
            super(context, null, androidx.appcompat.R_renamed.attr.actionBarTabStyle);
            this.f562b = new int[]{android.R_renamed.attr.background};
            this.f563c = cVar;
            androidx.appcompat.widget.ar_renamed arVarA = androidx.appcompat.widget.ar_renamed.a_renamed(context, null, this.f562b, androidx.appcompat.R_renamed.attr.actionBarTabStyle, 0);
            if (arVarA.g_renamed(0)) {
                setBackgroundDrawable(arVarA.a_renamed(0));
            }
            arVarA.b_renamed();
            if (z_renamed) {
                setGravity(8388627);
            }
            a_renamed();
        }

        public void a_renamed(androidx.appcompat.app.a_renamed.c_renamed cVar) {
            this.f563c = cVar;
            a_renamed();
        }

        @Override // android.view.View
        public void setSelected(boolean z_renamed) {
            boolean z2 = isSelected() != z_renamed;
            super.setSelected(z_renamed);
            if (z2 && z_renamed) {
                sendAccessibilityEvent(4);
            }
        }

        @Override // android.view.View
        public void onInitializeAccessibilityEvent(android.view.accessibility.AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(accessibilityEvent);
            accessibilityEvent.setClassName("androidx.appcompat.app.ActionBar$Tab");
        }

        @Override // android.view.View
        public void onInitializeAccessibilityNodeInfo(android.view.accessibility.AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            accessibilityNodeInfo.setClassName("androidx.appcompat.app.ActionBar$Tab");
        }

        @Override // android.widget.LinearLayout, android.view.View
        public void onMeasure(int i_renamed, int i2) {
            super.onMeasure(i_renamed, i2);
            if (androidx.appcompat.widget.ak_renamed.this.f556c <= 0 || getMeasuredWidth() <= androidx.appcompat.widget.ak_renamed.this.f556c) {
                return;
            }
            super.onMeasure(android.view.View.MeasureSpec.makeMeasureSpec(androidx.appcompat.widget.ak_renamed.this.f556c, 1073741824), i2);
        }

        public void a_renamed() {
            androidx.appcompat.app.a_renamed.c_renamed cVar = this.f563c;
            android.view.View viewC = cVar.c_renamed();
            if (viewC != null) {
                android.view.ViewParent parent = viewC.getParent();
                if (parent != this) {
                    if (parent != null) {
                        ((android.view.ViewGroup) parent).removeView(viewC);
                    }
                    addView(viewC);
                }
                this.f_renamed = viewC;
                android.widget.TextView textView = this.d_renamed;
                if (textView != null) {
                    textView.setVisibility(8);
                }
                android.widget.ImageView imageView = this.e_renamed;
                if (imageView != null) {
                    imageView.setVisibility(8);
                    this.e_renamed.setImageDrawable(null);
                    return;
                }
                return;
            }
            android.view.View view = this.f_renamed;
            if (view != null) {
                removeView(view);
                this.f_renamed = null;
            }
            android.graphics.drawable.Drawable drawableA = cVar.a_renamed();
            java.lang.CharSequence charSequenceB = cVar.b_renamed();
            if (drawableA != null) {
                if (this.e_renamed == null) {
                    androidx.appcompat.widget.AppCompatImageView appCompatImageView = new androidx.appcompat.widget.AppCompatImageView(getContext());
                    android.widget.LinearLayout.LayoutParams layoutParams = new android.widget.LinearLayout.LayoutParams(-2, -2);
                    layoutParams.gravity = 16;
                    appCompatImageView.setLayoutParams(layoutParams);
                    addView(appCompatImageView, 0);
                    this.e_renamed = appCompatImageView;
                }
                this.e_renamed.setImageDrawable(drawableA);
                this.e_renamed.setVisibility(0);
            } else {
                android.widget.ImageView imageView2 = this.e_renamed;
                if (imageView2 != null) {
                    imageView2.setVisibility(8);
                    this.e_renamed.setImageDrawable(null);
                }
            }
            boolean z_renamed = !android.text.TextUtils.isEmpty(charSequenceB);
            if (z_renamed) {
                if (this.d_renamed == null) {
                    androidx.appcompat.widget.AppCompatTextView appCompatTextView = new androidx.appcompat.widget.AppCompatTextView(getContext(), null, androidx.appcompat.R_renamed.attr.actionBarTabTextStyle);
                    appCompatTextView.setEllipsize(android.text.TextUtils.TruncateAt.END);
                    android.widget.LinearLayout.LayoutParams layoutParams2 = new android.widget.LinearLayout.LayoutParams(-2, -2);
                    layoutParams2.gravity = 16;
                    appCompatTextView.setLayoutParams(layoutParams2);
                    addView(appCompatTextView);
                    this.d_renamed = appCompatTextView;
                }
                this.d_renamed.setText(charSequenceB);
                this.d_renamed.setVisibility(0);
            } else {
                android.widget.TextView textView2 = this.d_renamed;
                if (textView2 != null) {
                    textView2.setVisibility(8);
                    this.d_renamed.setText((java.lang.CharSequence) null);
                }
            }
            android.widget.ImageView imageView3 = this.e_renamed;
            if (imageView3 != null) {
                imageView3.setContentDescription(cVar.e_renamed());
            }
            androidx.appcompat.widget.at_renamed.a_renamed(this, z_renamed ? null : cVar.e_renamed());
        }

        public androidx.appcompat.app.a_renamed.c_renamed b_renamed() {
            return this.f563c;
        }
    }

    /* compiled from: ScrollingTabContainerView.java */
    private class a_renamed extends android.widget.BaseAdapter {
        @Override // android.widget.Adapter
        public long getItemId(int i_renamed) {
            return i_renamed;
        }

        a_renamed() {
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return androidx.appcompat.widget.ak_renamed.this.f555b.getChildCount();
        }

        @Override // android.widget.Adapter
        public java.lang.Object getItem(int i_renamed) {
            return ((androidx.appcompat.widget.ak_renamed.c_renamed) androidx.appcompat.widget.ak_renamed.this.f555b.getChildAt(i_renamed)).b_renamed();
        }

        @Override // android.widget.Adapter
        public android.view.View getView(int i_renamed, android.view.View view, android.view.ViewGroup viewGroup) {
            if (view == null) {
                return androidx.appcompat.widget.ak_renamed.this.a_renamed((androidx.appcompat.app.a_renamed.c_renamed) getItem(i_renamed), true);
            }
            ((androidx.appcompat.widget.ak_renamed.c_renamed) view).a_renamed((androidx.appcompat.app.a_renamed.c_renamed) getItem(i_renamed));
            return view;
        }
    }

    /* compiled from: ScrollingTabContainerView.java */
    private class b_renamed implements android.view.View.OnClickListener {
        b_renamed() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(android.view.View view) {
            ((androidx.appcompat.widget.ak_renamed.c_renamed) view).b_renamed().d_renamed();
            int childCount = androidx.appcompat.widget.ak_renamed.this.f555b.getChildCount();
            for (int i_renamed = 0; i_renamed < childCount; i_renamed++) {
                android.view.View childAt = androidx.appcompat.widget.ak_renamed.this.f555b.getChildAt(i_renamed);
                childAt.setSelected(childAt == view);
            }
        }
    }
}

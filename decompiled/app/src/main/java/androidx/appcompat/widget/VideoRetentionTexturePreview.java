package androidx.appcompat.widget;

/* compiled from: ListPopupWindow.java */
/* loaded from: classes.dex */
public class ae_renamed implements androidx.appcompat.view.menu.q_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private static java.lang.reflect.Method f533a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private static java.lang.reflect.Method f534b;
    private static java.lang.reflect.Method h_renamed;
    private android.graphics.drawable.Drawable A_renamed;
    private android.widget.AdapterView.OnItemClickListener B_renamed;
    private android.widget.AdapterView.OnItemSelectedListener C_renamed;
    private final androidx.appcompat.widget.ae_renamed.d_renamed D_renamed;
    private final androidx.appcompat.widget.ae_renamed.c_renamed E_renamed;
    private final androidx.appcompat.widget.ae_renamed.a_renamed F_renamed;
    private java.lang.Runnable G_renamed;
    private final android.graphics.Rect H_renamed;
    private android.graphics.Rect I_renamed;
    private boolean J_renamed;

    /* renamed from: c_renamed, reason: collision with root package name */
    androidx.appcompat.widget.ab_renamed f535c;
    int d_renamed;
    final androidx.appcompat.widget.ae_renamed.e_renamed e_renamed;
    final android.os.Handler f_renamed;
    android.widget.PopupWindow g_renamed;
    private android.content.Context i_renamed;
    private android.widget.ListAdapter j_renamed;
    private int k_renamed;
    private int l_renamed;
    private int m_renamed;
    private int n_renamed;
    private int o_renamed;
    private boolean p_renamed;
    private boolean q_renamed;
    private boolean r_renamed;
    private boolean s_renamed;
    private int t_renamed;
    private boolean u_renamed;
    private boolean v_renamed;
    private android.view.View w_renamed;
    private int x_renamed;
    private android.database.DataSetObserver y_renamed;
    private android.view.View z_renamed;

    static {
        if (android.os.Build.VERSION.SDK_INT <= 28) {
            try {
                f533a = android.widget.PopupWindow.class.getDeclaredMethod("setClipToScreenEnabled", java.lang.Boolean.TYPE);
            } catch (java.lang.NoSuchMethodException unused) {
                android.util.Log.i_renamed("ListPopupWindow", "Could not find method setClipToScreenEnabled() on_renamed PopupWindow. Oh well.");
            }
            try {
                h_renamed = android.widget.PopupWindow.class.getDeclaredMethod("setEpicenterBounds", android.graphics.Rect.class);
            } catch (java.lang.NoSuchMethodException unused2) {
                android.util.Log.i_renamed("ListPopupWindow", "Could not find method setEpicenterBounds(Rect) on_renamed PopupWindow. Oh well.");
            }
        }
        if (android.os.Build.VERSION.SDK_INT <= 23) {
            try {
                f534b = android.widget.PopupWindow.class.getDeclaredMethod("getMaxAvailableHeight", android.view.View.class, java.lang.Integer.TYPE, java.lang.Boolean.TYPE);
            } catch (java.lang.NoSuchMethodException unused3) {
                android.util.Log.i_renamed("ListPopupWindow", "Could not find method getMaxAvailableHeight(View, int, boolean) on_renamed PopupWindow. Oh well.");
            }
        }
    }

    public ae_renamed(android.content.Context context) {
        this(context, null, androidx.appcompat.R_renamed.attr.listPopupWindowStyle);
    }

    public ae_renamed(android.content.Context context, android.util.AttributeSet attributeSet, int i_renamed) {
        this(context, attributeSet, i_renamed, 0);
    }

    public ae_renamed(android.content.Context context, android.util.AttributeSet attributeSet, int i_renamed, int i2) {
        this.k_renamed = -2;
        this.l_renamed = -2;
        this.o_renamed = 1002;
        this.q_renamed = true;
        this.t_renamed = 0;
        this.u_renamed = false;
        this.v_renamed = false;
        this.d_renamed = Integer.MAX_VALUE;
        this.x_renamed = 0;
        this.e_renamed = new androidx.appcompat.widget.ae_renamed.e_renamed();
        this.D_renamed = new androidx.appcompat.widget.ae_renamed.d_renamed();
        this.E_renamed = new androidx.appcompat.widget.ae_renamed.c_renamed();
        this.F_renamed = new androidx.appcompat.widget.ae_renamed.a_renamed();
        this.H_renamed = new android.graphics.Rect();
        this.i_renamed = context;
        this.f_renamed = new android.os.Handler(context.getMainLooper());
        android.content.res.TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, androidx.appcompat.R_renamed.styleable.ListPopupWindow, i_renamed, i2);
        this.m_renamed = typedArrayObtainStyledAttributes.getDimensionPixelOffset(androidx.appcompat.R_renamed.styleable.ListPopupWindow_android_dropDownHorizontalOffset, 0);
        this.n_renamed = typedArrayObtainStyledAttributes.getDimensionPixelOffset(androidx.appcompat.R_renamed.styleable.ListPopupWindow_android_dropDownVerticalOffset, 0);
        if (this.n_renamed != 0) {
            this.p_renamed = true;
        }
        typedArrayObtainStyledAttributes.recycle();
        this.g_renamed = new androidx.appcompat.widget.o_renamed(context, attributeSet, i_renamed, i2);
        this.g_renamed.setInputMethodMode(1);
    }

    public void a_renamed(android.widget.ListAdapter listAdapter) {
        android.database.DataSetObserver dataSetObserver = this.y_renamed;
        if (dataSetObserver == null) {
            this.y_renamed = new androidx.appcompat.widget.ae_renamed.b_renamed();
        } else {
            android.widget.ListAdapter listAdapter2 = this.j_renamed;
            if (listAdapter2 != null) {
                listAdapter2.unregisterDataSetObserver(dataSetObserver);
            }
        }
        this.j_renamed = listAdapter;
        if (listAdapter != null) {
            listAdapter.registerDataSetObserver(this.y_renamed);
        }
        androidx.appcompat.widget.ab_renamed abVar = this.f535c;
        if (abVar != null) {
            abVar.setAdapter(this.j_renamed);
        }
    }

    public void d_renamed(int i_renamed) {
        this.x_renamed = i_renamed;
    }

    public void a_renamed(boolean z_renamed) {
        this.J_renamed = z_renamed;
        this.g_renamed.setFocusable(z_renamed);
    }

    public boolean i_renamed() {
        return this.J_renamed;
    }

    public android.graphics.drawable.Drawable d_renamed() {
        return this.g_renamed.getBackground();
    }

    public void a_renamed(android.graphics.drawable.Drawable drawable) {
        this.g_renamed.setBackgroundDrawable(drawable);
    }

    public void e_renamed(int i_renamed) {
        this.g_renamed.setAnimationStyle(i_renamed);
    }

    public android.view.View j_renamed() {
        return this.z_renamed;
    }

    public void b_renamed(android.view.View view) {
        this.z_renamed = view;
    }

    public int f_renamed() {
        return this.m_renamed;
    }

    public void b_renamed(int i_renamed) {
        this.m_renamed = i_renamed;
    }

    public int e_renamed() {
        if (this.p_renamed) {
            return this.n_renamed;
        }
        return 0;
    }

    public void a_renamed(int i_renamed) {
        this.n_renamed = i_renamed;
        this.p_renamed = true;
    }

    public void a_renamed(android.graphics.Rect rect) {
        this.I_renamed = rect != null ? new android.graphics.Rect(rect) : null;
    }

    public void f_renamed(int i_renamed) {
        this.t_renamed = i_renamed;
    }

    public int k_renamed() {
        return this.l_renamed;
    }

    public void g_renamed(int i_renamed) {
        this.l_renamed = i_renamed;
    }

    public void h_renamed(int i_renamed) {
        android.graphics.drawable.Drawable background = this.g_renamed.getBackground();
        if (background != null) {
            background.getPadding(this.H_renamed);
            this.l_renamed = this.H_renamed.left + this.H_renamed.right + i_renamed;
        } else {
            g_renamed(i_renamed);
        }
    }

    public void a_renamed(android.widget.AdapterView.OnItemClickListener onItemClickListener) {
        this.B_renamed = onItemClickListener;
    }

    @Override // androidx.appcompat.view.menu.q_renamed
    public void a__renamed() throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        int iH = h_renamed();
        boolean zM = m_renamed();
        androidx.core.widget.h_renamed.a_renamed(this.g_renamed, this.o_renamed);
        if (this.g_renamed.isShowing()) {
            if (androidx.core.h_renamed.v_renamed.D_renamed(j_renamed())) {
                int width = this.l_renamed;
                if (width == -1) {
                    width = -1;
                } else if (width == -2) {
                    width = j_renamed().getWidth();
                }
                int i_renamed = this.k_renamed;
                if (i_renamed == -1) {
                    if (!zM) {
                        iH = -1;
                    }
                    if (zM) {
                        this.g_renamed.setWidth(this.l_renamed == -1 ? -1 : 0);
                        this.g_renamed.setHeight(0);
                    } else {
                        this.g_renamed.setWidth(this.l_renamed == -1 ? -1 : 0);
                        this.g_renamed.setHeight(-1);
                    }
                } else if (i_renamed != -2) {
                    iH = i_renamed;
                }
                this.g_renamed.setOutsideTouchable((this.v_renamed || this.u_renamed) ? false : true);
                this.g_renamed.update(j_renamed(), this.m_renamed, this.n_renamed, width < 0 ? -1 : width, iH < 0 ? -1 : iH);
                return;
            }
            return;
        }
        int width2 = this.l_renamed;
        if (width2 == -1) {
            width2 = -1;
        } else if (width2 == -2) {
            width2 = j_renamed().getWidth();
        }
        int i2 = this.k_renamed;
        if (i2 == -1) {
            iH = -1;
        } else if (i2 != -2) {
            iH = i2;
        }
        this.g_renamed.setWidth(width2);
        this.g_renamed.setHeight(iH);
        c_renamed(true);
        this.g_renamed.setOutsideTouchable((this.v_renamed || this.u_renamed) ? false : true);
        this.g_renamed.setTouchInterceptor(this.D_renamed);
        if (this.s_renamed) {
            androidx.core.widget.h_renamed.a_renamed(this.g_renamed, this.r_renamed);
        }
        if (android.os.Build.VERSION.SDK_INT <= 28) {
            java.lang.reflect.Method method = h_renamed;
            if (method != null) {
                try {
                    method.invoke(this.g_renamed, this.I_renamed);
                } catch (java.lang.Exception e2) {
                    android.util.Log.e_renamed("ListPopupWindow", "Could not invoke setEpicenterBounds on_renamed PopupWindow", e2);
                }
            }
        } else {
            this.g_renamed.setEpicenterBounds(this.I_renamed);
        }
        androidx.core.widget.h_renamed.a_renamed(this.g_renamed, j_renamed(), this.m_renamed, this.n_renamed, this.t_renamed);
        this.f535c.setSelection(-1);
        if (!this.J_renamed || this.f535c.isInTouchMode()) {
            l_renamed();
        }
        if (this.J_renamed) {
            return;
        }
        this.f_renamed.post(this.F_renamed);
    }

    @Override // androidx.appcompat.view.menu.q_renamed
    public void b_renamed() {
        this.g_renamed.dismiss();
        g_renamed();
        this.g_renamed.setContentView(null);
        this.f535c = null;
        this.f_renamed.removeCallbacks(this.e_renamed);
    }

    public void a_renamed(android.widget.PopupWindow.OnDismissListener onDismissListener) {
        this.g_renamed.setOnDismissListener(onDismissListener);
    }

    private void g_renamed() {
        android.view.View view = this.w_renamed;
        if (view != null) {
            android.view.ViewParent parent = view.getParent();
            if (parent instanceof android.view.ViewGroup) {
                ((android.view.ViewGroup) parent).removeView(this.w_renamed);
            }
        }
    }

    public void i_renamed(int i_renamed) {
        this.g_renamed.setInputMethodMode(i_renamed);
    }

    public void j_renamed(int i_renamed) {
        androidx.appcompat.widget.ab_renamed abVar = this.f535c;
        if (!c_renamed() || abVar == null) {
            return;
        }
        abVar.setListSelectionHidden(false);
        abVar.setSelection(i_renamed);
        if (abVar.getChoiceMode() != 0) {
            abVar.setItemChecked(i_renamed, true);
        }
    }

    public void l_renamed() {
        androidx.appcompat.widget.ab_renamed abVar = this.f535c;
        if (abVar != null) {
            abVar.setListSelectionHidden(true);
            abVar.requestLayout();
        }
    }

    @Override // androidx.appcompat.view.menu.q_renamed
    public boolean c_renamed() {
        return this.g_renamed.isShowing();
    }

    public boolean m_renamed() {
        return this.g_renamed.getInputMethodMode() == 2;
    }

    public java.lang.Object n_renamed() {
        if (c_renamed()) {
            return this.f535c.getSelectedItem();
        }
        return null;
    }

    public int o_renamed() {
        if (c_renamed()) {
            return this.f535c.getSelectedItemPosition();
        }
        return -1;
    }

    public long p_renamed() {
        if (c_renamed()) {
            return this.f535c.getSelectedItemId();
        }
        return Long.MIN_VALUE;
    }

    public android.view.View q_renamed() {
        if (c_renamed()) {
            return this.f535c.getSelectedView();
        }
        return null;
    }

    @Override // androidx.appcompat.view.menu.q_renamed
    public android.widget.ListView b__renamed() {
        return this.f535c;
    }

    androidx.appcompat.widget.ab_renamed a_renamed(android.content.Context context, boolean z_renamed) {
        return new androidx.appcompat.widget.ab_renamed(context, z_renamed);
    }

    private int h_renamed() {
        int measuredHeight;
        int i_renamed;
        int iMakeMeasureSpec;
        int i2;
        if (this.f535c == null) {
            android.content.Context context = this.i_renamed;
            this.G_renamed = new java.lang.Runnable() { // from class: androidx.appcompat.widget.ae_renamed.1
                @Override // java.lang.Runnable
                public void run() throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
                    android.view.View viewJ = androidx.appcompat.widget.ae_renamed.this.j_renamed();
                    if (viewJ == null || viewJ.getWindowToken() == null) {
                        return;
                    }
                    androidx.appcompat.widget.ae_renamed.this.a__renamed();
                }
            };
            this.f535c = a_renamed(context, !this.J_renamed);
            android.graphics.drawable.Drawable drawable = this.A_renamed;
            if (drawable != null) {
                this.f535c.setSelector(drawable);
            }
            this.f535c.setAdapter(this.j_renamed);
            this.f535c.setOnItemClickListener(this.B_renamed);
            this.f535c.setFocusable(true);
            this.f535c.setFocusableInTouchMode(true);
            this.f535c.setOnItemSelectedListener(new android.widget.AdapterView.OnItemSelectedListener() { // from class: androidx.appcompat.widget.ae_renamed.2
                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onNothingSelected(android.widget.AdapterView<?> adapterView) {
                }

                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onItemSelected(android.widget.AdapterView<?> adapterView, android.view.View view, int i3, long j_renamed) {
                    androidx.appcompat.widget.ab_renamed abVar;
                    if (i3 == -1 || (abVar = androidx.appcompat.widget.ae_renamed.this.f535c) == null) {
                        return;
                    }
                    abVar.setListSelectionHidden(false);
                }
            });
            this.f535c.setOnScrollListener(this.E_renamed);
            android.widget.AdapterView.OnItemSelectedListener onItemSelectedListener = this.C_renamed;
            if (onItemSelectedListener != null) {
                this.f535c.setOnItemSelectedListener(onItemSelectedListener);
            }
            android.view.View view = this.f535c;
            android.view.View view2 = this.w_renamed;
            if (view2 != null) {
                android.widget.LinearLayout linearLayout = new android.widget.LinearLayout(context);
                linearLayout.setOrientation(1);
                android.view.ViewGroup.LayoutParams layoutParams = new android.widget.LinearLayout.LayoutParams(-1, 0, 1.0f);
                int i3 = this.x_renamed;
                if (i3 == 0) {
                    linearLayout.addView(view2);
                    linearLayout.addView(view, layoutParams);
                } else if (i3 == 1) {
                    linearLayout.addView(view, layoutParams);
                    linearLayout.addView(view2);
                } else {
                    android.util.Log.e_renamed("ListPopupWindow", "Invalid hint position " + this.x_renamed);
                }
                int i4 = this.l_renamed;
                if (i4 >= 0) {
                    i2 = Integer.MIN_VALUE;
                } else {
                    i4 = 0;
                    i2 = 0;
                }
                view2.measure(android.view.View.MeasureSpec.makeMeasureSpec(i4, i2), 0);
                android.widget.LinearLayout.LayoutParams layoutParams2 = (android.widget.LinearLayout.LayoutParams) view2.getLayoutParams();
                measuredHeight = view2.getMeasuredHeight() + layoutParams2.topMargin + layoutParams2.bottomMargin;
                view = linearLayout;
            } else {
                measuredHeight = 0;
            }
            this.g_renamed.setContentView(view);
        } else {
            android.view.View view3 = this.w_renamed;
            if (view3 != null) {
                android.widget.LinearLayout.LayoutParams layoutParams3 = (android.widget.LinearLayout.LayoutParams) view3.getLayoutParams();
                measuredHeight = view3.getMeasuredHeight() + layoutParams3.topMargin + layoutParams3.bottomMargin;
            } else {
                measuredHeight = 0;
            }
        }
        android.graphics.drawable.Drawable background = this.g_renamed.getBackground();
        if (background != null) {
            background.getPadding(this.H_renamed);
            i_renamed = this.H_renamed.top + this.H_renamed.bottom;
            if (!this.p_renamed) {
                this.n_renamed = -this.H_renamed.top;
            }
        } else {
            this.H_renamed.setEmpty();
            i_renamed = 0;
        }
        int iA = a_renamed(j_renamed(), this.n_renamed, this.g_renamed.getInputMethodMode() == 2);
        if (this.u_renamed || this.k_renamed == -1) {
            return iA + i_renamed;
        }
        int i5 = this.l_renamed;
        if (i5 == -2) {
            iMakeMeasureSpec = android.view.View.MeasureSpec.makeMeasureSpec(this.i_renamed.getResources().getDisplayMetrics().widthPixels - (this.H_renamed.left + this.H_renamed.right), Integer.MIN_VALUE);
        } else if (i5 == -1) {
            iMakeMeasureSpec = android.view.View.MeasureSpec.makeMeasureSpec(this.i_renamed.getResources().getDisplayMetrics().widthPixels - (this.H_renamed.left + this.H_renamed.right), 1073741824);
        } else {
            iMakeMeasureSpec = android.view.View.MeasureSpec.makeMeasureSpec(i5, 1073741824);
        }
        int iA2 = this.f535c.a_renamed(iMakeMeasureSpec, 0, -1, iA - measuredHeight, -1);
        if (iA2 > 0) {
            measuredHeight += i_renamed + this.f535c.getPaddingTop() + this.f535c.getPaddingBottom();
        }
        return iA2 + measuredHeight;
    }

    public void b_renamed(boolean z_renamed) {
        this.s_renamed = true;
        this.r_renamed = z_renamed;
    }

    /* compiled from: ListPopupWindow.java */
    private class b_renamed extends android.database.DataSetObserver {
        b_renamed() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
            if (androidx.appcompat.widget.ae_renamed.this.c_renamed()) {
                androidx.appcompat.widget.ae_renamed.this.a__renamed();
            }
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            androidx.appcompat.widget.ae_renamed.this.b_renamed();
        }
    }

    /* compiled from: ListPopupWindow.java */
    private class a_renamed implements java.lang.Runnable {
        a_renamed() {
        }

        @Override // java.lang.Runnable
        public void run() {
            androidx.appcompat.widget.ae_renamed.this.l_renamed();
        }
    }

    /* compiled from: ListPopupWindow.java */
    private class e_renamed implements java.lang.Runnable {
        e_renamed() {
        }

        @Override // java.lang.Runnable
        public void run() throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
            if (androidx.appcompat.widget.ae_renamed.this.f535c == null || !androidx.core.h_renamed.v_renamed.D_renamed(androidx.appcompat.widget.ae_renamed.this.f535c) || androidx.appcompat.widget.ae_renamed.this.f535c.getCount() <= androidx.appcompat.widget.ae_renamed.this.f535c.getChildCount() || androidx.appcompat.widget.ae_renamed.this.f535c.getChildCount() > androidx.appcompat.widget.ae_renamed.this.d_renamed) {
                return;
            }
            androidx.appcompat.widget.ae_renamed.this.g_renamed.setInputMethodMode(2);
            androidx.appcompat.widget.ae_renamed.this.a__renamed();
        }
    }

    /* compiled from: ListPopupWindow.java */
    private class d_renamed implements android.view.View.OnTouchListener {
        d_renamed() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(android.view.View view, android.view.MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            int x_renamed = (int) motionEvent.getX();
            int y_renamed = (int) motionEvent.getY();
            if (action == 0 && androidx.appcompat.widget.ae_renamed.this.g_renamed != null && androidx.appcompat.widget.ae_renamed.this.g_renamed.isShowing() && x_renamed >= 0 && x_renamed < androidx.appcompat.widget.ae_renamed.this.g_renamed.getWidth() && y_renamed >= 0 && y_renamed < androidx.appcompat.widget.ae_renamed.this.g_renamed.getHeight()) {
                androidx.appcompat.widget.ae_renamed.this.f_renamed.postDelayed(androidx.appcompat.widget.ae_renamed.this.e_renamed, 250L);
                return false;
            }
            if (action != 1) {
                return false;
            }
            androidx.appcompat.widget.ae_renamed.this.f_renamed.removeCallbacks(androidx.appcompat.widget.ae_renamed.this.e_renamed);
            return false;
        }
    }

    /* compiled from: ListPopupWindow.java */
    private class c_renamed implements android.widget.AbsListView.OnScrollListener {
        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(android.widget.AbsListView absListView, int i_renamed, int i2, int i3) {
        }

        c_renamed() {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(android.widget.AbsListView absListView, int i_renamed) throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
            if (i_renamed != 1 || androidx.appcompat.widget.ae_renamed.this.m_renamed() || androidx.appcompat.widget.ae_renamed.this.g_renamed.getContentView() == null) {
                return;
            }
            androidx.appcompat.widget.ae_renamed.this.f_renamed.removeCallbacks(androidx.appcompat.widget.ae_renamed.this.e_renamed);
            androidx.appcompat.widget.ae_renamed.this.e_renamed.run();
        }
    }

    private void c_renamed(boolean z_renamed) throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        if (android.os.Build.VERSION.SDK_INT <= 28) {
            java.lang.reflect.Method method = f533a;
            if (method != null) {
                try {
                    method.invoke(this.g_renamed, java.lang.Boolean.valueOf(z_renamed));
                    return;
                } catch (java.lang.Exception unused) {
                    android.util.Log.i_renamed("ListPopupWindow", "Could not call setClipToScreenEnabled() on_renamed PopupWindow. Oh well.");
                    return;
                }
            }
            return;
        }
        this.g_renamed.setIsClippedToScreen(z_renamed);
    }

    private int a_renamed(android.view.View view, int i_renamed, boolean z_renamed) {
        if (android.os.Build.VERSION.SDK_INT <= 23) {
            java.lang.reflect.Method method = f534b;
            if (method != null) {
                try {
                    return ((java.lang.Integer) method.invoke(this.g_renamed, view, java.lang.Integer.valueOf(i_renamed), java.lang.Boolean.valueOf(z_renamed))).intValue();
                } catch (java.lang.Exception unused) {
                    android.util.Log.i_renamed("ListPopupWindow", "Could not call getMaxAvailableHeightMethod(View, int, boolean) on_renamed PopupWindow. Using the public version.");
                }
            }
            return this.g_renamed.getMaxAvailableHeight(view, i_renamed);
        }
        return this.g_renamed.getMaxAvailableHeight(view, i_renamed, z_renamed);
    }
}

package androidx.appcompat.app;

/* loaded from: classes.dex */
class AlertController {
    private int A_renamed;
    private java.lang.CharSequence C_renamed;
    private android.graphics.drawable.Drawable D_renamed;
    private java.lang.CharSequence E_renamed;
    private android.graphics.drawable.Drawable F_renamed;
    private java.lang.CharSequence G_renamed;
    private android.graphics.drawable.Drawable H_renamed;
    private android.graphics.drawable.Drawable J_renamed;
    private android.widget.ImageView K_renamed;
    private android.widget.TextView L_renamed;
    private android.widget.TextView M_renamed;
    private android.view.View N_renamed;
    private int O_renamed;
    private int P_renamed;
    private boolean Q_renamed;

    /* renamed from: a_renamed, reason: collision with root package name */
    final androidx.appcompat.app.f_renamed f201a;

    /* renamed from: b_renamed, reason: collision with root package name */
    android.widget.ListView f202b;

    /* renamed from: c_renamed, reason: collision with root package name */
    android.widget.Button f203c;
    android.os.Message d_renamed;
    android.widget.Button e_renamed;
    android.os.Message f_renamed;
    android.widget.Button g_renamed;
    android.os.Message h_renamed;
    androidx.core.widget.NestedScrollView i_renamed;
    android.widget.ListAdapter j_renamed;
    int l_renamed;
    int m_renamed;
    int n_renamed;
    int o_renamed;
    android.os.Handler p_renamed;
    private final android.content.Context q_renamed;
    private final android.view.Window r_renamed;
    private final int s_renamed;
    private java.lang.CharSequence t_renamed;
    private java.lang.CharSequence u_renamed;
    private android.view.View v_renamed;
    private int w_renamed;
    private int x_renamed;
    private int y_renamed;
    private int z_renamed;
    private boolean B_renamed = false;
    private int I_renamed = 0;
    int k_renamed = -1;
    private int R_renamed = 0;
    private final android.view.View.OnClickListener S_renamed = new android.view.View.OnClickListener() { // from class: androidx.appcompat.app.AlertController.1
        @Override // android.view.View.OnClickListener
        public void onClick(android.view.View view) {
            android.os.Message messageObtain;
            if (view == androidx.appcompat.app.AlertController.this.f203c && androidx.appcompat.app.AlertController.this.d_renamed != null) {
                messageObtain = android.os.Message.obtain(androidx.appcompat.app.AlertController.this.d_renamed);
            } else if (view == androidx.appcompat.app.AlertController.this.e_renamed && androidx.appcompat.app.AlertController.this.f_renamed != null) {
                messageObtain = android.os.Message.obtain(androidx.appcompat.app.AlertController.this.f_renamed);
            } else {
                messageObtain = (view != androidx.appcompat.app.AlertController.this.g_renamed || androidx.appcompat.app.AlertController.this.h_renamed == null) ? null : android.os.Message.obtain(androidx.appcompat.app.AlertController.this.h_renamed);
            }
            if (messageObtain != null) {
                messageObtain.sendToTarget();
            }
            androidx.appcompat.app.AlertController.this.p_renamed.obtainMessage(1, androidx.appcompat.app.AlertController.this.f201a).sendToTarget();
        }
    };

    private static final class b_renamed extends android.os.Handler {

        /* renamed from: a_renamed, reason: collision with root package name */
        private java.lang.ref.WeakReference<android.content.DialogInterface> f232a;

        public b_renamed(android.content.DialogInterface dialogInterface) {
            this.f232a = new java.lang.ref.WeakReference<>(dialogInterface);
        }

        @Override // android.os.Handler
        public void handleMessage(android.os.Message message) {
            int i_renamed = message.what;
            if (i_renamed == -3 || i_renamed == -2 || i_renamed == -1) {
                ((android.content.DialogInterface.OnClickListener) message.obj).onClick(this.f232a.get(), message.what);
            } else {
                if (i_renamed != 1) {
                    return;
                }
                ((android.content.DialogInterface) message.obj).dismiss();
            }
        }
    }

    private static boolean a_renamed(android.content.Context context) {
        android.util.TypedValue typedValue = new android.util.TypedValue();
        context.getTheme().resolveAttribute(androidx.appcompat.R_renamed.attr.alertDialogCenterButtons, typedValue, true);
        return typedValue.data != 0;
    }

    public AlertController(android.content.Context context, androidx.appcompat.app.f_renamed fVar, android.view.Window window) {
        this.q_renamed = context;
        this.f201a = fVar;
        this.r_renamed = window;
        this.p_renamed = new androidx.appcompat.app.AlertController.b_renamed(fVar);
        android.content.res.TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(null, androidx.appcompat.R_renamed.styleable.AlertDialog, androidx.appcompat.R_renamed.attr.alertDialogStyle, 0);
        this.O_renamed = typedArrayObtainStyledAttributes.getResourceId(androidx.appcompat.R_renamed.styleable.AlertDialog_android_layout, 0);
        this.P_renamed = typedArrayObtainStyledAttributes.getResourceId(androidx.appcompat.R_renamed.styleable.AlertDialog_buttonPanelSideLayout, 0);
        this.l_renamed = typedArrayObtainStyledAttributes.getResourceId(androidx.appcompat.R_renamed.styleable.AlertDialog_listLayout, 0);
        this.m_renamed = typedArrayObtainStyledAttributes.getResourceId(androidx.appcompat.R_renamed.styleable.AlertDialog_multiChoiceItemLayout, 0);
        this.n_renamed = typedArrayObtainStyledAttributes.getResourceId(androidx.appcompat.R_renamed.styleable.AlertDialog_singleChoiceItemLayout, 0);
        this.o_renamed = typedArrayObtainStyledAttributes.getResourceId(androidx.appcompat.R_renamed.styleable.AlertDialog_listItemLayout, 0);
        this.Q_renamed = typedArrayObtainStyledAttributes.getBoolean(androidx.appcompat.R_renamed.styleable.AlertDialog_showTitle, true);
        this.s_renamed = typedArrayObtainStyledAttributes.getDimensionPixelSize(androidx.appcompat.R_renamed.styleable.AlertDialog_buttonIconDimen, 0);
        typedArrayObtainStyledAttributes.recycle();
        fVar.supportRequestWindowFeature(1);
    }

    static boolean a_renamed(android.view.View view) {
        if (view.onCheckIsTextEditor()) {
            return true;
        }
        if (!(view instanceof android.view.ViewGroup)) {
            return false;
        }
        android.view.ViewGroup viewGroup = (android.view.ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        while (childCount > 0) {
            childCount--;
            if (a_renamed(viewGroup.getChildAt(childCount))) {
                return true;
            }
        }
        return false;
    }

    public void a_renamed() {
        this.f201a.setContentView(c_renamed());
        d_renamed();
    }

    private int c_renamed() {
        int i_renamed = this.P_renamed;
        if (i_renamed == 0) {
            return this.O_renamed;
        }
        return this.R_renamed == 1 ? i_renamed : this.O_renamed;
    }

    public void a_renamed(java.lang.CharSequence charSequence) {
        this.t_renamed = charSequence;
        android.widget.TextView textView = this.L_renamed;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    public void b_renamed(android.view.View view) {
        this.N_renamed = view;
    }

    public void b_renamed(java.lang.CharSequence charSequence) {
        this.u_renamed = charSequence;
        android.widget.TextView textView = this.M_renamed;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    public void a_renamed(int i_renamed) {
        this.v_renamed = null;
        this.w_renamed = i_renamed;
        this.B_renamed = false;
    }

    public void c_renamed(android.view.View view) {
        this.v_renamed = view;
        this.w_renamed = 0;
        this.B_renamed = false;
    }

    public void a_renamed(android.view.View view, int i_renamed, int i2, int i3, int i4) {
        this.v_renamed = view;
        this.w_renamed = 0;
        this.B_renamed = true;
        this.x_renamed = i_renamed;
        this.y_renamed = i2;
        this.z_renamed = i3;
        this.A_renamed = i4;
    }

    public void a_renamed(int i_renamed, java.lang.CharSequence charSequence, android.content.DialogInterface.OnClickListener onClickListener, android.os.Message message, android.graphics.drawable.Drawable drawable) {
        if (message == null && onClickListener != null) {
            message = this.p_renamed.obtainMessage(i_renamed, onClickListener);
        }
        if (i_renamed == -3) {
            this.G_renamed = charSequence;
            this.h_renamed = message;
            this.H_renamed = drawable;
        } else if (i_renamed == -2) {
            this.E_renamed = charSequence;
            this.f_renamed = message;
            this.F_renamed = drawable;
        } else {
            if (i_renamed == -1) {
                this.C_renamed = charSequence;
                this.d_renamed = message;
                this.D_renamed = drawable;
                return;
            }
            throw new java.lang.IllegalArgumentException("Button does not exist");
        }
    }

    public void b_renamed(int i_renamed) {
        this.J_renamed = null;
        this.I_renamed = i_renamed;
        android.widget.ImageView imageView = this.K_renamed;
        if (imageView != null) {
            if (i_renamed != 0) {
                imageView.setVisibility(0);
                this.K_renamed.setImageResource(this.I_renamed);
            } else {
                imageView.setVisibility(8);
            }
        }
    }

    public void a_renamed(android.graphics.drawable.Drawable drawable) {
        this.J_renamed = drawable;
        this.I_renamed = 0;
        android.widget.ImageView imageView = this.K_renamed;
        if (imageView != null) {
            if (drawable != null) {
                imageView.setVisibility(0);
                this.K_renamed.setImageDrawable(drawable);
            } else {
                imageView.setVisibility(8);
            }
        }
    }

    public int c_renamed(int i_renamed) {
        android.util.TypedValue typedValue = new android.util.TypedValue();
        this.q_renamed.getTheme().resolveAttribute(i_renamed, typedValue, true);
        return typedValue.resourceId;
    }

    public android.widget.ListView b_renamed() {
        return this.f202b;
    }

    public android.widget.Button d_renamed(int i_renamed) {
        if (i_renamed == -3) {
            return this.g_renamed;
        }
        if (i_renamed == -2) {
            return this.e_renamed;
        }
        if (i_renamed != -1) {
            return null;
        }
        return this.f203c;
    }

    public boolean a_renamed(int i_renamed, android.view.KeyEvent keyEvent) {
        androidx.core.widget.NestedScrollView nestedScrollView = this.i_renamed;
        return nestedScrollView != null && nestedScrollView.a_renamed(keyEvent);
    }

    public boolean b_renamed(int i_renamed, android.view.KeyEvent keyEvent) {
        androidx.core.widget.NestedScrollView nestedScrollView = this.i_renamed;
        return nestedScrollView != null && nestedScrollView.a_renamed(keyEvent);
    }

    private android.view.ViewGroup a_renamed(android.view.View view, android.view.View view2) {
        if (view == null) {
            if (view2 instanceof android.view.ViewStub) {
                view2 = ((android.view.ViewStub) view2).inflate();
            }
            return (android.view.ViewGroup) view2;
        }
        if (view2 != null) {
            android.view.ViewParent parent = view2.getParent();
            if (parent instanceof android.view.ViewGroup) {
                ((android.view.ViewGroup) parent).removeView(view2);
            }
        }
        if (view instanceof android.view.ViewStub) {
            view = ((android.view.ViewStub) view).inflate();
        }
        return (android.view.ViewGroup) view;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void d_renamed() {
        android.view.View viewFindViewById;
        android.widget.ListAdapter listAdapter;
        android.view.View viewFindViewById2;
        android.view.View viewFindViewById3 = this.r_renamed.findViewById(androidx.appcompat.R_renamed.id_renamed.parentPanel);
        android.view.View viewFindViewById4 = viewFindViewById3.findViewById(androidx.appcompat.R_renamed.id_renamed.topPanel);
        android.view.View viewFindViewById5 = viewFindViewById3.findViewById(androidx.appcompat.R_renamed.id_renamed.contentPanel);
        android.view.View viewFindViewById6 = viewFindViewById3.findViewById(androidx.appcompat.R_renamed.id_renamed.buttonPanel);
        android.view.ViewGroup viewGroup = (android.view.ViewGroup) viewFindViewById3.findViewById(androidx.appcompat.R_renamed.id_renamed.customPanel);
        a_renamed(viewGroup);
        android.view.View viewFindViewById7 = viewGroup.findViewById(androidx.appcompat.R_renamed.id_renamed.topPanel);
        android.view.View viewFindViewById8 = viewGroup.findViewById(androidx.appcompat.R_renamed.id_renamed.contentPanel);
        android.view.View viewFindViewById9 = viewGroup.findViewById(androidx.appcompat.R_renamed.id_renamed.buttonPanel);
        android.view.ViewGroup viewGroupA = a_renamed(viewFindViewById7, viewFindViewById4);
        android.view.ViewGroup viewGroupA2 = a_renamed(viewFindViewById8, viewFindViewById5);
        android.view.ViewGroup viewGroupA3 = a_renamed(viewFindViewById9, viewFindViewById6);
        c_renamed(viewGroupA2);
        d_renamed(viewGroupA3);
        b_renamed(viewGroupA);
        boolean z_renamed = (viewGroup == null || viewGroup.getVisibility() == 8) ? false : true;
        boolean z2 = (viewGroupA == null || viewGroupA.getVisibility() == 8) ? 0 : 1;
        boolean z3 = (viewGroupA3 == null || viewGroupA3.getVisibility() == 8) ? false : true;
        if (!z3 && viewGroupA2 != null && (viewFindViewById2 = viewGroupA2.findViewById(androidx.appcompat.R_renamed.id_renamed.textSpacerNoButtons)) != null) {
            viewFindViewById2.setVisibility(0);
        }
        if (z2 != 0) {
            androidx.core.widget.NestedScrollView nestedScrollView = this.i_renamed;
            if (nestedScrollView != null) {
                nestedScrollView.setClipToPadding(true);
            }
            android.view.View viewFindViewById10 = (this.u_renamed == null && this.f202b == null) ? null : viewGroupA.findViewById(androidx.appcompat.R_renamed.id_renamed.titleDividerNoCustom);
            if (viewFindViewById10 != null) {
                viewFindViewById10.setVisibility(0);
            }
        } else if (viewGroupA2 != null && (viewFindViewById = viewGroupA2.findViewById(androidx.appcompat.R_renamed.id_renamed.textSpacerNoTitle)) != null) {
            viewFindViewById.setVisibility(0);
        }
        android.widget.ListView listView = this.f202b;
        if (listView instanceof androidx.appcompat.app.AlertController.RecycleListView) {
            ((androidx.appcompat.app.AlertController.RecycleListView) listView).a_renamed(z2, z3);
        }
        if (!z_renamed) {
            android.view.View view = this.f202b;
            if (view == null) {
                view = this.i_renamed;
            }
            if (view != null) {
                a_renamed(viewGroupA2, view, z2 | (z3 ? 2 : 0), 3);
            }
        }
        android.widget.ListView listView2 = this.f202b;
        if (listView2 == null || (listAdapter = this.j_renamed) == null) {
            return;
        }
        listView2.setAdapter(listAdapter);
        int i_renamed = this.k_renamed;
        if (i_renamed > -1) {
            listView2.setItemChecked(i_renamed, true);
            listView2.setSelection(i_renamed);
        }
    }

    private void a_renamed(android.view.ViewGroup viewGroup, android.view.View view, int i_renamed, int i2) {
        final android.view.View viewFindViewById = this.r_renamed.findViewById(androidx.appcompat.R_renamed.id_renamed.scrollIndicatorUp);
        android.view.View viewFindViewById2 = this.r_renamed.findViewById(androidx.appcompat.R_renamed.id_renamed.scrollIndicatorDown);
        if (android.os.Build.VERSION.SDK_INT >= 23) {
            androidx.core.h_renamed.v_renamed.a_renamed(view, i_renamed, i2);
            if (viewFindViewById != null) {
                viewGroup.removeView(viewFindViewById);
            }
            if (viewFindViewById2 != null) {
                viewGroup.removeView(viewFindViewById2);
                return;
            }
            return;
        }
        final android.view.View view2 = null;
        if (viewFindViewById != null && (i_renamed & 1) == 0) {
            viewGroup.removeView(viewFindViewById);
            viewFindViewById = null;
        }
        if (viewFindViewById2 == null || (i_renamed & 2) != 0) {
            view2 = viewFindViewById2;
        } else {
            viewGroup.removeView(viewFindViewById2);
        }
        if (viewFindViewById == null && view2 == null) {
            return;
        }
        if (this.u_renamed != null) {
            this.i_renamed.setOnScrollChangeListener(new androidx.core.widget.NestedScrollView.b_renamed() { // from class: androidx.appcompat.app.AlertController.2
                @Override // androidx.core.widget.NestedScrollView.b_renamed
                public void a_renamed(androidx.core.widget.NestedScrollView nestedScrollView, int i3, int i4, int i5, int i6) {
                    androidx.appcompat.app.AlertController.a_renamed(nestedScrollView, viewFindViewById, view2);
                }
            });
            this.i_renamed.post(new java.lang.Runnable() { // from class: androidx.appcompat.app.AlertController.3
                @Override // java.lang.Runnable
                public void run() {
                    androidx.appcompat.app.AlertController.a_renamed(androidx.appcompat.app.AlertController.this.i_renamed, viewFindViewById, view2);
                }
            });
            return;
        }
        android.widget.ListView listView = this.f202b;
        if (listView != null) {
            listView.setOnScrollListener(new android.widget.AbsListView.OnScrollListener() { // from class: androidx.appcompat.app.AlertController.4
                @Override // android.widget.AbsListView.OnScrollListener
                public void onScrollStateChanged(android.widget.AbsListView absListView, int i3) {
                }

                @Override // android.widget.AbsListView.OnScrollListener
                public void onScroll(android.widget.AbsListView absListView, int i3, int i4, int i5) {
                    androidx.appcompat.app.AlertController.a_renamed(absListView, viewFindViewById, view2);
                }
            });
            this.f202b.post(new java.lang.Runnable() { // from class: androidx.appcompat.app.AlertController.5
                @Override // java.lang.Runnable
                public void run() {
                    androidx.appcompat.app.AlertController.a_renamed(androidx.appcompat.app.AlertController.this.f202b, viewFindViewById, view2);
                }
            });
            return;
        }
        if (viewFindViewById != null) {
            viewGroup.removeView(viewFindViewById);
        }
        if (view2 != null) {
            viewGroup.removeView(view2);
        }
    }

    private void a_renamed(android.view.ViewGroup viewGroup) {
        android.view.View viewInflate = this.v_renamed;
        if (viewInflate == null) {
            viewInflate = this.w_renamed != 0 ? android.view.LayoutInflater.from(this.q_renamed).inflate(this.w_renamed, viewGroup, false) : null;
        }
        boolean z_renamed = viewInflate != null;
        if (!z_renamed || !a_renamed(viewInflate)) {
            this.r_renamed.setFlags(131072, 131072);
        }
        if (z_renamed) {
            android.widget.FrameLayout frameLayout = (android.widget.FrameLayout) this.r_renamed.findViewById(androidx.appcompat.R_renamed.id_renamed.custom);
            frameLayout.addView(viewInflate, new android.view.ViewGroup.LayoutParams(-1, -1));
            if (this.B_renamed) {
                frameLayout.setPadding(this.x_renamed, this.y_renamed, this.z_renamed, this.A_renamed);
            }
            if (this.f202b != null) {
                ((androidx.appcompat.widget.LinearLayoutCompat.a_renamed) viewGroup.getLayoutParams()).g_renamed = 0.0f;
                return;
            }
            return;
        }
        viewGroup.setVisibility(8);
    }

    private void b_renamed(android.view.ViewGroup viewGroup) {
        if (this.N_renamed != null) {
            viewGroup.addView(this.N_renamed, 0, new android.view.ViewGroup.LayoutParams(-1, -2));
            this.r_renamed.findViewById(androidx.appcompat.R_renamed.id_renamed.title_template).setVisibility(8);
            return;
        }
        this.K_renamed = (android.widget.ImageView) this.r_renamed.findViewById(android.R_renamed.id_renamed.icon);
        if ((!android.text.TextUtils.isEmpty(this.t_renamed)) && this.Q_renamed) {
            this.L_renamed = (android.widget.TextView) this.r_renamed.findViewById(androidx.appcompat.R_renamed.id_renamed.alertTitle);
            this.L_renamed.setText(this.t_renamed);
            int i_renamed = this.I_renamed;
            if (i_renamed != 0) {
                this.K_renamed.setImageResource(i_renamed);
                return;
            }
            android.graphics.drawable.Drawable drawable = this.J_renamed;
            if (drawable != null) {
                this.K_renamed.setImageDrawable(drawable);
                return;
            } else {
                this.L_renamed.setPadding(this.K_renamed.getPaddingLeft(), this.K_renamed.getPaddingTop(), this.K_renamed.getPaddingRight(), this.K_renamed.getPaddingBottom());
                this.K_renamed.setVisibility(8);
                return;
            }
        }
        this.r_renamed.findViewById(androidx.appcompat.R_renamed.id_renamed.title_template).setVisibility(8);
        this.K_renamed.setVisibility(8);
        viewGroup.setVisibility(8);
    }

    private void c_renamed(android.view.ViewGroup viewGroup) {
        this.i_renamed = (androidx.core.widget.NestedScrollView) this.r_renamed.findViewById(androidx.appcompat.R_renamed.id_renamed.scrollView);
        this.i_renamed.setFocusable(false);
        this.i_renamed.setNestedScrollingEnabled(false);
        this.M_renamed = (android.widget.TextView) viewGroup.findViewById(android.R_renamed.id_renamed.message);
        android.widget.TextView textView = this.M_renamed;
        if (textView == null) {
            return;
        }
        java.lang.CharSequence charSequence = this.u_renamed;
        if (charSequence != null) {
            textView.setText(charSequence);
            return;
        }
        textView.setVisibility(8);
        this.i_renamed.removeView(this.M_renamed);
        if (this.f202b != null) {
            android.view.ViewGroup viewGroup2 = (android.view.ViewGroup) this.i_renamed.getParent();
            int iIndexOfChild = viewGroup2.indexOfChild(this.i_renamed);
            viewGroup2.removeViewAt(iIndexOfChild);
            viewGroup2.addView(this.f202b, iIndexOfChild, new android.view.ViewGroup.LayoutParams(-1, -1));
            return;
        }
        viewGroup.setVisibility(8);
    }

    static void a_renamed(android.view.View view, android.view.View view2, android.view.View view3) {
        if (view2 != null) {
            view2.setVisibility(view.canScrollVertically(-1) ? 0 : 4);
        }
        if (view3 != null) {
            view3.setVisibility(view.canScrollVertically(1) ? 0 : 4);
        }
    }

    private void d_renamed(android.view.ViewGroup viewGroup) {
        int i_renamed;
        this.f203c = (android.widget.Button) viewGroup.findViewById(android.R_renamed.id_renamed.button1);
        this.f203c.setOnClickListener(this.S_renamed);
        if (android.text.TextUtils.isEmpty(this.C_renamed) && this.D_renamed == null) {
            this.f203c.setVisibility(8);
            i_renamed = 0;
        } else {
            this.f203c.setText(this.C_renamed);
            android.graphics.drawable.Drawable drawable = this.D_renamed;
            if (drawable != null) {
                int i2 = this.s_renamed;
                drawable.setBounds(0, 0, i2, i2);
                this.f203c.setCompoundDrawables(this.D_renamed, null, null, null);
            }
            this.f203c.setVisibility(0);
            i_renamed = 1;
        }
        this.e_renamed = (android.widget.Button) viewGroup.findViewById(android.R_renamed.id_renamed.button2);
        this.e_renamed.setOnClickListener(this.S_renamed);
        if (android.text.TextUtils.isEmpty(this.E_renamed) && this.F_renamed == null) {
            this.e_renamed.setVisibility(8);
        } else {
            this.e_renamed.setText(this.E_renamed);
            android.graphics.drawable.Drawable drawable2 = this.F_renamed;
            if (drawable2 != null) {
                int i3 = this.s_renamed;
                drawable2.setBounds(0, 0, i3, i3);
                this.e_renamed.setCompoundDrawables(this.F_renamed, null, null, null);
            }
            this.e_renamed.setVisibility(0);
            i_renamed |= 2;
        }
        this.g_renamed = (android.widget.Button) viewGroup.findViewById(android.R_renamed.id_renamed.button3);
        this.g_renamed.setOnClickListener(this.S_renamed);
        if (android.text.TextUtils.isEmpty(this.G_renamed) && this.H_renamed == null) {
            this.g_renamed.setVisibility(8);
        } else {
            this.g_renamed.setText(this.G_renamed);
            android.graphics.drawable.Drawable drawable3 = this.D_renamed;
            if (drawable3 != null) {
                int i4 = this.s_renamed;
                drawable3.setBounds(0, 0, i4, i4);
                this.f203c.setCompoundDrawables(this.D_renamed, null, null, null);
            }
            this.g_renamed.setVisibility(0);
            i_renamed |= 4;
        }
        if (a_renamed(this.q_renamed)) {
            if (i_renamed == 1) {
                a_renamed(this.f203c);
            } else if (i_renamed == 2) {
                a_renamed(this.e_renamed);
            } else if (i_renamed == 4) {
                a_renamed(this.g_renamed);
            }
        }
        if (i_renamed != 0) {
            return;
        }
        viewGroup.setVisibility(8);
    }

    private void a_renamed(android.widget.Button button) {
        android.widget.LinearLayout.LayoutParams layoutParams = (android.widget.LinearLayout.LayoutParams) button.getLayoutParams();
        layoutParams.gravity = 1;
        layoutParams.weight = 0.5f;
        button.setLayoutParams(layoutParams);
    }

    public static class RecycleListView extends android.widget.ListView {

        /* renamed from: a_renamed, reason: collision with root package name */
        private final int f217a;

        /* renamed from: b_renamed, reason: collision with root package name */
        private final int f218b;

        public RecycleListView(android.content.Context context) {
            this(context, null);
        }

        public RecycleListView(android.content.Context context, android.util.AttributeSet attributeSet) {
            super(context, attributeSet);
            android.content.res.TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, androidx.appcompat.R_renamed.styleable.RecycleListView);
            this.f218b = typedArrayObtainStyledAttributes.getDimensionPixelOffset(androidx.appcompat.R_renamed.styleable.RecycleListView_paddingBottomNoButtons, -1);
            this.f217a = typedArrayObtainStyledAttributes.getDimensionPixelOffset(androidx.appcompat.R_renamed.styleable.RecycleListView_paddingTopNoTitle, -1);
        }

        public void a_renamed(boolean z_renamed, boolean z2) {
            if (z2 && z_renamed) {
                return;
            }
            setPadding(getPaddingLeft(), z_renamed ? getPaddingTop() : this.f217a, getPaddingRight(), z2 ? getPaddingBottom() : this.f218b);
        }
    }

    public static class a_renamed {
        public int A_renamed;
        public int B_renamed;
        public int C_renamed;
        public int D_renamed;
        public boolean[] F_renamed;
        public boolean G_renamed;
        public boolean H_renamed;
        public android.content.DialogInterface.OnMultiChoiceClickListener J_renamed;
        public android.database.Cursor K_renamed;
        public java.lang.String L_renamed;
        public java.lang.String M_renamed;
        public boolean N_renamed;
        public android.widget.AdapterView.OnItemSelectedListener O_renamed;
        public androidx.appcompat.app.AlertController.a_renamed.InterfaceC0002a P_renamed;

        /* renamed from: a_renamed, reason: collision with root package name */
        public final android.content.Context f219a;

        /* renamed from: b_renamed, reason: collision with root package name */
        public final android.view.LayoutInflater f220b;
        public android.graphics.drawable.Drawable d_renamed;
        public java.lang.CharSequence f_renamed;
        public android.view.View g_renamed;
        public java.lang.CharSequence h_renamed;
        public java.lang.CharSequence i_renamed;
        public android.graphics.drawable.Drawable j_renamed;
        public android.content.DialogInterface.OnClickListener k_renamed;
        public java.lang.CharSequence l_renamed;
        public android.graphics.drawable.Drawable m_renamed;
        public android.content.DialogInterface.OnClickListener n_renamed;
        public java.lang.CharSequence o_renamed;
        public android.graphics.drawable.Drawable p_renamed;
        public android.content.DialogInterface.OnClickListener q_renamed;
        public android.content.DialogInterface.OnCancelListener s_renamed;
        public android.content.DialogInterface.OnDismissListener t_renamed;
        public android.content.DialogInterface.OnKeyListener u_renamed;
        public java.lang.CharSequence[] v_renamed;
        public android.widget.ListAdapter w_renamed;
        public android.content.DialogInterface.OnClickListener x_renamed;
        public int y_renamed;
        public android.view.View z_renamed;

        /* renamed from: c_renamed, reason: collision with root package name */
        public int f221c = 0;
        public int e_renamed = 0;
        public boolean E_renamed = false;
        public int I_renamed = -1;
        public boolean Q_renamed = true;
        public boolean r_renamed = true;

        /* renamed from: androidx.appcompat.app.AlertController$a_renamed$a_renamed, reason: collision with other inner class name */
        public interface InterfaceC0002a {
            void a_renamed(android.widget.ListView listView);
        }

        public a_renamed(android.content.Context context) {
            this.f219a = context;
            this.f220b = (android.view.LayoutInflater) context.getSystemService("layout_inflater");
        }

        public void a_renamed(androidx.appcompat.app.AlertController alertController) {
            android.view.View view = this.g_renamed;
            if (view != null) {
                alertController.b_renamed(view);
            } else {
                java.lang.CharSequence charSequence = this.f_renamed;
                if (charSequence != null) {
                    alertController.a_renamed(charSequence);
                }
                android.graphics.drawable.Drawable drawable = this.d_renamed;
                if (drawable != null) {
                    alertController.a_renamed(drawable);
                }
                int i_renamed = this.f221c;
                if (i_renamed != 0) {
                    alertController.b_renamed(i_renamed);
                }
                int i2 = this.e_renamed;
                if (i2 != 0) {
                    alertController.b_renamed(alertController.c_renamed(i2));
                }
            }
            java.lang.CharSequence charSequence2 = this.h_renamed;
            if (charSequence2 != null) {
                alertController.b_renamed(charSequence2);
            }
            if (this.i_renamed != null || this.j_renamed != null) {
                alertController.a_renamed(-1, this.i_renamed, this.k_renamed, (android.os.Message) null, this.j_renamed);
            }
            if (this.l_renamed != null || this.m_renamed != null) {
                alertController.a_renamed(-2, this.l_renamed, this.n_renamed, (android.os.Message) null, this.m_renamed);
            }
            if (this.o_renamed != null || this.p_renamed != null) {
                alertController.a_renamed(-3, this.o_renamed, this.q_renamed, (android.os.Message) null, this.p_renamed);
            }
            if (this.v_renamed != null || this.K_renamed != null || this.w_renamed != null) {
                b_renamed(alertController);
            }
            android.view.View view2 = this.z_renamed;
            if (view2 != null) {
                if (this.E_renamed) {
                    alertController.a_renamed(view2, this.A_renamed, this.B_renamed, this.C_renamed, this.D_renamed);
                    return;
                } else {
                    alertController.c_renamed(view2);
                    return;
                }
            }
            int i3 = this.y_renamed;
            if (i3 != 0) {
                alertController.a_renamed(i3);
            }
        }

        private void b_renamed(final androidx.appcompat.app.AlertController alertController) {
            int i_renamed;
            android.widget.ListAdapter cVar;
            final androidx.appcompat.app.AlertController.RecycleListView recycleListView = (androidx.appcompat.app.AlertController.RecycleListView) this.f220b.inflate(alertController.l_renamed, (android.view.ViewGroup) null);
            if (this.G_renamed) {
                android.database.Cursor cursor = this.K_renamed;
                if (cursor == null) {
                    cVar = new android.widget.ArrayAdapter<java.lang.CharSequence>(this.f219a, alertController.m_renamed, android.R_renamed.id_renamed.text1, this.v_renamed) { // from class: androidx.appcompat.app.AlertController.a_renamed.1
                        @Override // android.widget.ArrayAdapter, android.widget.Adapter
                        public android.view.View getView(int i2, android.view.View view, android.view.ViewGroup viewGroup) {
                            android.view.View view2 = super.getView(i2, view, viewGroup);
                            if (androidx.appcompat.app.AlertController.a_renamed.this.F_renamed != null && androidx.appcompat.app.AlertController.a_renamed.this.F_renamed[i2]) {
                                recycleListView.setItemChecked(i2, true);
                            }
                            return view2;
                        }
                    };
                } else {
                    cVar = new android.widget.CursorAdapter(this.f219a, cursor, false) { // from class: androidx.appcompat.app.AlertController.a_renamed.2
                        private final int d_renamed;
                        private final int e_renamed;

                        {
                            android.database.Cursor cursor2 = getCursor();
                            this.d_renamed = cursor2.getColumnIndexOrThrow(androidx.appcompat.app.AlertController.a_renamed.this.L_renamed);
                            this.e_renamed = cursor2.getColumnIndexOrThrow(androidx.appcompat.app.AlertController.a_renamed.this.M_renamed);
                        }

                        @Override // android.widget.CursorAdapter
                        public void bindView(android.view.View view, android.content.Context context, android.database.Cursor cursor2) {
                            ((android.widget.CheckedTextView) view.findViewById(android.R_renamed.id_renamed.text1)).setText(cursor2.getString(this.d_renamed));
                            recycleListView.setItemChecked(cursor2.getPosition(), cursor2.getInt(this.e_renamed) == 1);
                        }

                        @Override // android.widget.CursorAdapter
                        public android.view.View newView(android.content.Context context, android.database.Cursor cursor2, android.view.ViewGroup viewGroup) {
                            return androidx.appcompat.app.AlertController.a_renamed.this.f220b.inflate(alertController.m_renamed, viewGroup, false);
                        }
                    };
                }
            } else {
                if (this.H_renamed) {
                    i_renamed = alertController.n_renamed;
                } else {
                    i_renamed = alertController.o_renamed;
                }
                int i2 = i_renamed;
                android.database.Cursor cursor2 = this.K_renamed;
                if (cursor2 != null) {
                    cVar = new android.widget.SimpleCursorAdapter(this.f219a, i2, cursor2, new java.lang.String[]{this.L_renamed}, new int[]{android.R_renamed.id_renamed.text1});
                } else {
                    cVar = this.w_renamed;
                    if (cVar == null) {
                        cVar = new androidx.appcompat.app.AlertController.c_renamed(this.f219a, i2, android.R_renamed.id_renamed.text1, this.v_renamed);
                    }
                }
            }
            androidx.appcompat.app.AlertController.a_renamed.InterfaceC0002a interfaceC0002a = this.P_renamed;
            if (interfaceC0002a != null) {
                interfaceC0002a.a_renamed(recycleListView);
            }
            alertController.j_renamed = cVar;
            alertController.k_renamed = this.I_renamed;
            if (this.x_renamed != null) {
                recycleListView.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() { // from class: androidx.appcompat.app.AlertController.a_renamed.3
                    @Override // android.widget.AdapterView.OnItemClickListener
                    public void onItemClick(android.widget.AdapterView<?> adapterView, android.view.View view, int i3, long j_renamed) {
                        androidx.appcompat.app.AlertController.a_renamed.this.x_renamed.onClick(alertController.f201a, i3);
                        if (androidx.appcompat.app.AlertController.a_renamed.this.H_renamed) {
                            return;
                        }
                        alertController.f201a.dismiss();
                    }
                });
            } else if (this.J_renamed != null) {
                recycleListView.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() { // from class: androidx.appcompat.app.AlertController.a_renamed.4
                    @Override // android.widget.AdapterView.OnItemClickListener
                    public void onItemClick(android.widget.AdapterView<?> adapterView, android.view.View view, int i3, long j_renamed) {
                        if (androidx.appcompat.app.AlertController.a_renamed.this.F_renamed != null) {
                            androidx.appcompat.app.AlertController.a_renamed.this.F_renamed[i3] = recycleListView.isItemChecked(i3);
                        }
                        androidx.appcompat.app.AlertController.a_renamed.this.J_renamed.onClick(alertController.f201a, i3, recycleListView.isItemChecked(i3));
                    }
                });
            }
            android.widget.AdapterView.OnItemSelectedListener onItemSelectedListener = this.O_renamed;
            if (onItemSelectedListener != null) {
                recycleListView.setOnItemSelectedListener(onItemSelectedListener);
            }
            if (this.H_renamed) {
                recycleListView.setChoiceMode(1);
            } else if (this.G_renamed) {
                recycleListView.setChoiceMode(2);
            }
            alertController.f202b = recycleListView;
        }
    }

    private static class c_renamed extends android.widget.ArrayAdapter<java.lang.CharSequence> {
        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public long getItemId(int i_renamed) {
            return i_renamed;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public boolean hasStableIds() {
            return true;
        }

        public c_renamed(android.content.Context context, int i_renamed, int i2, java.lang.CharSequence[] charSequenceArr) {
            super(context, i_renamed, i2, charSequenceArr);
        }
    }
}

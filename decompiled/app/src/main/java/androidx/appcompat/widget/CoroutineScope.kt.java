package androidx.appcompat.widget;

/* compiled from: ToolbarWidgetWrapper.java */
/* loaded from: classes.dex */
public class as_renamed implements androidx.appcompat.widget.z_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    androidx.appcompat.widget.Toolbar f580a;

    /* renamed from: b_renamed, reason: collision with root package name */
    java.lang.CharSequence f581b;

    /* renamed from: c_renamed, reason: collision with root package name */
    android.view.Window.Callback f582c;
    boolean d_renamed;
    private int e_renamed;
    private android.view.View f_renamed;
    private android.view.View g_renamed;
    private android.graphics.drawable.Drawable h_renamed;
    private android.graphics.drawable.Drawable i_renamed;
    private android.graphics.drawable.Drawable j_renamed;
    private boolean k_renamed;
    private java.lang.CharSequence l_renamed;
    private java.lang.CharSequence m_renamed;
    private androidx.appcompat.widget.ActionMenuPresenter n_renamed;
    private int o_renamed;
    private int p_renamed;
    private android.graphics.drawable.Drawable q_renamed;

    @Override // androidx.appcompat.widget.z_renamed
    public void b_renamed(boolean z_renamed) {
    }

    public as_renamed(androidx.appcompat.widget.Toolbar toolbar, boolean z_renamed) {
        this(toolbar, z_renamed, androidx.appcompat.R_renamed.string.abc_action_bar_up_description, androidx.appcompat.R_renamed.drawable.abc_ic_ab_back_material);
    }

    public as_renamed(androidx.appcompat.widget.Toolbar toolbar, boolean z_renamed, int i_renamed, int i2) {
        android.graphics.drawable.Drawable drawable;
        this.o_renamed = 0;
        this.p_renamed = 0;
        this.f580a = toolbar;
        this.f581b = toolbar.getTitle();
        this.l_renamed = toolbar.getSubtitle();
        this.k_renamed = this.f581b != null;
        this.j_renamed = toolbar.getNavigationIcon();
        androidx.appcompat.widget.ar_renamed arVarA = androidx.appcompat.widget.ar_renamed.a_renamed(toolbar.getContext(), null, androidx.appcompat.R_renamed.styleable.ActionBar, androidx.appcompat.R_renamed.attr.actionBarStyle, 0);
        this.q_renamed = arVarA.a_renamed(androidx.appcompat.R_renamed.styleable.ActionBar_homeAsUpIndicator);
        if (z_renamed) {
            java.lang.CharSequence charSequenceC = arVarA.c_renamed(androidx.appcompat.R_renamed.styleable.ActionBar_title);
            if (!android.text.TextUtils.isEmpty(charSequenceC)) {
                b_renamed(charSequenceC);
            }
            java.lang.CharSequence charSequenceC2 = arVarA.c_renamed(androidx.appcompat.R_renamed.styleable.ActionBar_subtitle);
            if (!android.text.TextUtils.isEmpty(charSequenceC2)) {
                c_renamed(charSequenceC2);
            }
            android.graphics.drawable.Drawable drawableA = arVarA.a_renamed(androidx.appcompat.R_renamed.styleable.ActionBar_logo);
            if (drawableA != null) {
                b_renamed(drawableA);
            }
            android.graphics.drawable.Drawable drawableA2 = arVarA.a_renamed(androidx.appcompat.R_renamed.styleable.ActionBar_icon);
            if (drawableA2 != null) {
                a_renamed(drawableA2);
            }
            if (this.j_renamed == null && (drawable = this.q_renamed) != null) {
                c_renamed(drawable);
            }
            c_renamed(arVarA.a_renamed(androidx.appcompat.R_renamed.styleable.ActionBar_displayOptions, 0));
            int iG = arVarA.g_renamed(androidx.appcompat.R_renamed.styleable.ActionBar_customNavigationLayout, 0);
            if (iG != 0) {
                a_renamed(android.view.LayoutInflater.from(this.f580a.getContext()).inflate(iG, (android.view.ViewGroup) this.f580a, false));
                c_renamed(this.e_renamed | 16);
            }
            int iF = arVarA.f_renamed(androidx.appcompat.R_renamed.styleable.ActionBar_height, 0);
            if (iF > 0) {
                android.view.ViewGroup.LayoutParams layoutParams = this.f580a.getLayoutParams();
                layoutParams.height = iF;
                this.f580a.setLayoutParams(layoutParams);
            }
            int iD = arVarA.d_renamed(androidx.appcompat.R_renamed.styleable.ActionBar_contentInsetStart, -1);
            int iD2 = arVarA.d_renamed(androidx.appcompat.R_renamed.styleable.ActionBar_contentInsetEnd, -1);
            if (iD >= 0 || iD2 >= 0) {
                this.f580a.setContentInsetsRelative(java.lang.Math.max(iD, 0), java.lang.Math.max(iD2, 0));
            }
            int iG2 = arVarA.g_renamed(androidx.appcompat.R_renamed.styleable.ActionBar_titleTextStyle, 0);
            if (iG2 != 0) {
                androidx.appcompat.widget.Toolbar toolbar2 = this.f580a;
                toolbar2.setTitleTextAppearance(toolbar2.getContext(), iG2);
            }
            int iG3 = arVarA.g_renamed(androidx.appcompat.R_renamed.styleable.ActionBar_subtitleTextStyle, 0);
            if (iG3 != 0) {
                androidx.appcompat.widget.Toolbar toolbar3 = this.f580a;
                toolbar3.setSubtitleTextAppearance(toolbar3.getContext(), iG3);
            }
            int iG4 = arVarA.g_renamed(androidx.appcompat.R_renamed.styleable.ActionBar_popupTheme, 0);
            if (iG4 != 0) {
                this.f580a.setPopupTheme(iG4);
            }
        } else {
            this.e_renamed = r_renamed();
        }
        arVarA.b_renamed();
        e_renamed(i_renamed);
        this.m_renamed = this.f580a.getNavigationContentDescription();
        this.f580a.setNavigationOnClickListener(new android.view.View.OnClickListener() { // from class: androidx.appcompat.widget.as_renamed.1

            /* renamed from: a_renamed, reason: collision with root package name */
            final androidx.appcompat.view.menu.a_renamed f583a;

            {
                this.f583a = new androidx.appcompat.view.menu.a_renamed(androidx.appcompat.widget.as_renamed.this.f580a.getContext(), 0, android.R_renamed.id_renamed.home, 0, 0, androidx.appcompat.widget.as_renamed.this.f581b);
            }

            @Override // android.view.View.OnClickListener
            public void onClick(android.view.View view) {
                if (androidx.appcompat.widget.as_renamed.this.f582c == null || !androidx.appcompat.widget.as_renamed.this.d_renamed) {
                    return;
                }
                androidx.appcompat.widget.as_renamed.this.f582c.onMenuItemSelected(0, this.f583a);
            }
        });
    }

    public void e_renamed(int i_renamed) {
        if (i_renamed == this.p_renamed) {
            return;
        }
        this.p_renamed = i_renamed;
        if (android.text.TextUtils.isEmpty(this.f580a.getNavigationContentDescription())) {
            f_renamed(this.p_renamed);
        }
    }

    private int r_renamed() {
        if (this.f580a.getNavigationIcon() == null) {
            return 11;
        }
        this.q_renamed = this.f580a.getNavigationIcon();
        return 15;
    }

    @Override // androidx.appcompat.widget.z_renamed
    public android.view.ViewGroup a_renamed() {
        return this.f580a;
    }

    @Override // androidx.appcompat.widget.z_renamed
    public android.content.Context b_renamed() {
        return this.f580a.getContext();
    }

    @Override // androidx.appcompat.widget.z_renamed
    public boolean c_renamed() {
        return this.f580a.hasExpandedActionView();
    }

    @Override // androidx.appcompat.widget.z_renamed
    public void d_renamed() {
        this.f580a.collapseActionView();
    }

    @Override // androidx.appcompat.widget.z_renamed
    public void a_renamed(android.view.Window.Callback callback) {
        this.f582c = callback;
    }

    @Override // androidx.appcompat.widget.z_renamed
    public void a_renamed(java.lang.CharSequence charSequence) {
        if (this.k_renamed) {
            return;
        }
        e_renamed(charSequence);
    }

    @Override // androidx.appcompat.widget.z_renamed
    public java.lang.CharSequence e_renamed() {
        return this.f580a.getTitle();
    }

    public void b_renamed(java.lang.CharSequence charSequence) {
        this.k_renamed = true;
        e_renamed(charSequence);
    }

    private void e_renamed(java.lang.CharSequence charSequence) {
        this.f581b = charSequence;
        if ((this.e_renamed & 8) != 0) {
            this.f580a.setTitle(charSequence);
        }
    }

    public void c_renamed(java.lang.CharSequence charSequence) {
        this.l_renamed = charSequence;
        if ((this.e_renamed & 8) != 0) {
            this.f580a.setSubtitle(charSequence);
        }
    }

    @Override // androidx.appcompat.widget.z_renamed
    public void f_renamed() {
        android.util.Log.i_renamed("ToolbarWidgetWrapper", "Progress display unsupported");
    }

    @Override // androidx.appcompat.widget.z_renamed
    public void g_renamed() {
        android.util.Log.i_renamed("ToolbarWidgetWrapper", "Progress display unsupported");
    }

    @Override // androidx.appcompat.widget.z_renamed
    public void a_renamed(int i_renamed) {
        a_renamed(i_renamed != 0 ? androidx.appcompat.a_renamed.a_renamed.a_renamed.b_renamed(b_renamed(), i_renamed) : null);
    }

    @Override // androidx.appcompat.widget.z_renamed
    public void a_renamed(android.graphics.drawable.Drawable drawable) {
        this.h_renamed = drawable;
        s_renamed();
    }

    @Override // androidx.appcompat.widget.z_renamed
    public void b_renamed(int i_renamed) {
        b_renamed(i_renamed != 0 ? androidx.appcompat.a_renamed.a_renamed.a_renamed.b_renamed(b_renamed(), i_renamed) : null);
    }

    public void b_renamed(android.graphics.drawable.Drawable drawable) {
        this.i_renamed = drawable;
        s_renamed();
    }

    private void s_renamed() {
        android.graphics.drawable.Drawable drawable;
        int i_renamed = this.e_renamed;
        if ((i_renamed & 2) == 0) {
            drawable = null;
        } else if ((i_renamed & 1) == 0 || (drawable = this.i_renamed) == null) {
            drawable = this.h_renamed;
        }
        this.f580a.setLogo(drawable);
    }

    @Override // androidx.appcompat.widget.z_renamed
    public boolean h_renamed() {
        return this.f580a.canShowOverflowMenu();
    }

    @Override // androidx.appcompat.widget.z_renamed
    public boolean i_renamed() {
        return this.f580a.isOverflowMenuShowing();
    }

    @Override // androidx.appcompat.widget.z_renamed
    public boolean j_renamed() {
        return this.f580a.isOverflowMenuShowPending();
    }

    @Override // androidx.appcompat.widget.z_renamed
    public boolean k_renamed() {
        return this.f580a.showOverflowMenu();
    }

    @Override // androidx.appcompat.widget.z_renamed
    public boolean l_renamed() {
        return this.f580a.hideOverflowMenu();
    }

    @Override // androidx.appcompat.widget.z_renamed
    public void m_renamed() {
        this.d_renamed = true;
    }

    @Override // androidx.appcompat.widget.z_renamed
    public void a_renamed(android.view.Menu menu, androidx.appcompat.view.menu.n_renamed.a_renamed aVar) {
        if (this.n_renamed == null) {
            this.n_renamed = new androidx.appcompat.widget.ActionMenuPresenter(this.f580a.getContext());
            this.n_renamed.a_renamed(androidx.appcompat.R_renamed.id_renamed.action_menu_presenter);
        }
        this.n_renamed.setCallback(aVar);
        this.f580a.setMenu((androidx.appcompat.view.menu.h_renamed) menu, this.n_renamed);
    }

    @Override // androidx.appcompat.widget.z_renamed
    public void n_renamed() {
        this.f580a.dismissPopupMenus();
    }

    @Override // androidx.appcompat.widget.z_renamed
    public int o_renamed() {
        return this.e_renamed;
    }

    @Override // androidx.appcompat.widget.z_renamed
    public void c_renamed(int i_renamed) {
        android.view.View view;
        int i2 = this.e_renamed ^ i_renamed;
        this.e_renamed = i_renamed;
        if (i2 != 0) {
            if ((i2 & 4) != 0) {
                if ((i_renamed & 4) != 0) {
                    u_renamed();
                }
                t_renamed();
            }
            if ((i2 & 3) != 0) {
                s_renamed();
            }
            if ((i2 & 8) != 0) {
                if ((i_renamed & 8) != 0) {
                    this.f580a.setTitle(this.f581b);
                    this.f580a.setSubtitle(this.l_renamed);
                } else {
                    this.f580a.setTitle((java.lang.CharSequence) null);
                    this.f580a.setSubtitle((java.lang.CharSequence) null);
                }
            }
            if ((i2 & 16) == 0 || (view = this.g_renamed) == null) {
                return;
            }
            if ((i_renamed & 16) != 0) {
                this.f580a.addView(view);
            } else {
                this.f580a.removeView(view);
            }
        }
    }

    @Override // androidx.appcompat.widget.z_renamed
    public void a_renamed(androidx.appcompat.widget.ak_renamed akVar) {
        android.view.View view = this.f_renamed;
        if (view != null) {
            android.view.ViewParent parent = view.getParent();
            androidx.appcompat.widget.Toolbar toolbar = this.f580a;
            if (parent == toolbar) {
                toolbar.removeView(this.f_renamed);
            }
        }
        this.f_renamed = akVar;
        if (akVar == null || this.o_renamed != 2) {
            return;
        }
        this.f580a.addView(this.f_renamed, 0);
        androidx.appcompat.widget.Toolbar.b_renamed bVar = (androidx.appcompat.widget.Toolbar.b_renamed) this.f_renamed.getLayoutParams();
        bVar.width = -2;
        bVar.height = -2;
        bVar.f264a = com.google.android.material.badge.BadgeDrawable.BOTTOM_START;
        akVar.setAllowCollapse(true);
    }

    @Override // androidx.appcompat.widget.z_renamed
    public void a_renamed(boolean z_renamed) {
        this.f580a.setCollapsible(z_renamed);
    }

    @Override // androidx.appcompat.widget.z_renamed
    public int p_renamed() {
        return this.o_renamed;
    }

    public void a_renamed(android.view.View view) {
        android.view.View view2 = this.g_renamed;
        if (view2 != null && (this.e_renamed & 16) != 0) {
            this.f580a.removeView(view2);
        }
        this.g_renamed = view;
        if (view == null || (this.e_renamed & 16) == 0) {
            return;
        }
        this.f580a.addView(this.g_renamed);
    }

    @Override // androidx.appcompat.widget.z_renamed
    public androidx.core.h_renamed.z_renamed a_renamed(final int i_renamed, long j_renamed) {
        return androidx.core.h_renamed.v_renamed.n_renamed(this.f580a).a_renamed(i_renamed == 0 ? 1.0f : 0.0f).a_renamed(j_renamed).a_renamed(new androidx.core.h_renamed.ab_renamed() { // from class: androidx.appcompat.widget.as_renamed.2

            /* renamed from: c_renamed, reason: collision with root package name */
            private boolean f587c = false;

            @Override // androidx.core.h_renamed.ab_renamed, androidx.core.h_renamed.aa_renamed
            public void a_renamed(android.view.View view) {
                androidx.appcompat.widget.as_renamed.this.f580a.setVisibility(0);
            }

            @Override // androidx.core.h_renamed.ab_renamed, androidx.core.h_renamed.aa_renamed
            public void b_renamed(android.view.View view) {
                if (this.f587c) {
                    return;
                }
                androidx.appcompat.widget.as_renamed.this.f580a.setVisibility(i_renamed);
            }

            @Override // androidx.core.h_renamed.ab_renamed, androidx.core.h_renamed.aa_renamed
            public void c_renamed(android.view.View view) {
                this.f587c = true;
            }
        });
    }

    public void c_renamed(android.graphics.drawable.Drawable drawable) {
        this.j_renamed = drawable;
        t_renamed();
    }

    private void t_renamed() {
        if ((this.e_renamed & 4) != 0) {
            androidx.appcompat.widget.Toolbar toolbar = this.f580a;
            android.graphics.drawable.Drawable drawable = this.j_renamed;
            if (drawable == null) {
                drawable = this.q_renamed;
            }
            toolbar.setNavigationIcon(drawable);
            return;
        }
        this.f580a.setNavigationIcon((android.graphics.drawable.Drawable) null);
    }

    public void d_renamed(java.lang.CharSequence charSequence) {
        this.m_renamed = charSequence;
        u_renamed();
    }

    public void f_renamed(int i_renamed) {
        d_renamed(i_renamed == 0 ? null : b_renamed().getString(i_renamed));
    }

    private void u_renamed() {
        if ((this.e_renamed & 4) != 0) {
            if (android.text.TextUtils.isEmpty(this.m_renamed)) {
                this.f580a.setNavigationContentDescription(this.p_renamed);
            } else {
                this.f580a.setNavigationContentDescription(this.m_renamed);
            }
        }
    }

    @Override // androidx.appcompat.widget.z_renamed
    public void d_renamed(int i_renamed) {
        this.f580a.setVisibility(i_renamed);
    }

    @Override // androidx.appcompat.widget.z_renamed
    public void a_renamed(androidx.appcompat.view.menu.n_renamed.a_renamed aVar, androidx.appcompat.view.menu.h_renamed.a_renamed aVar2) {
        this.f580a.setMenuCallbacks(aVar, aVar2);
    }

    @Override // androidx.appcompat.widget.z_renamed
    public android.view.Menu q_renamed() {
        return this.f580a.getMenu();
    }
}

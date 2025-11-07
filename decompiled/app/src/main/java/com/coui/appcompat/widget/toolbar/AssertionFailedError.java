package com.coui.appcompat.widget.toolbar;

/* loaded from: classes.dex */
public class COUIToolbar extends androidx.appcompat.widget.Toolbar {
    private boolean A_renamed;
    private boolean B_renamed;
    private final java.util.ArrayList<android.view.View> C_renamed;
    private final int[] D_renamed;
    private androidx.appcompat.widget.Toolbar.c_renamed E_renamed;
    private final androidx.appcompat.widget.ActionMenuView.e_renamed F_renamed;
    private com.coui.appcompat.widget.toolbar.COUIToolbar.a_renamed G_renamed;
    private androidx.appcompat.view.menu.n_renamed.a_renamed H_renamed;
    private androidx.appcompat.view.menu.h_renamed.a_renamed I_renamed;
    private boolean J_renamed;
    private int K_renamed;
    private boolean L_renamed;
    private int M_renamed;
    private int[] N_renamed;
    private float O_renamed;
    private int P_renamed;
    private int Q_renamed;
    private int R_renamed;
    private int S_renamed;
    private final int[] T_renamed;
    private final java.lang.Runnable U_renamed;
    private int V_renamed;
    private float W_renamed;

    /* renamed from: a_renamed, reason: collision with root package name */
    android.view.View f3105a;
    private float aa_renamed;

    /* renamed from: b_renamed, reason: collision with root package name */
    boolean f3106b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private androidx.appcompat.widget.ActionMenuView f3107c;
    private android.widget.TextView d_renamed;
    private android.widget.TextView e_renamed;
    private android.widget.ImageButton f_renamed;
    private android.widget.ImageView g_renamed;
    private android.graphics.drawable.Drawable h_renamed;
    private java.lang.CharSequence i_renamed;
    private android.widget.ImageButton j_renamed;
    private android.content.Context k_renamed;
    private int l_renamed;
    private int m_renamed;
    private int n_renamed;
    private int o_renamed;
    private int p_renamed;
    private int q_renamed;
    private int r_renamed;
    private int s_renamed;
    private int t_renamed;
    private final com.coui.appcompat.a_renamed.p_renamed u_renamed;
    private int v_renamed;
    private java.lang.CharSequence w_renamed;
    private java.lang.CharSequence x_renamed;
    private int y_renamed;
    private int z_renamed;

    public COUIToolbar(android.content.Context context) {
        this(context, null);
    }

    public COUIToolbar(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, coui.support.appcompat.R_renamed.attr.toolbarStyle);
    }

    public COUIToolbar(android.content.Context context, android.util.AttributeSet attributeSet, int i_renamed) throws android.content.res.Resources.NotFoundException {
        super(context, attributeSet, i_renamed);
        this.u_renamed = new com.coui.appcompat.a_renamed.p_renamed();
        this.v_renamed = 8388627;
        this.C_renamed = new java.util.ArrayList<>();
        this.D_renamed = new int[2];
        this.F_renamed = new androidx.appcompat.widget.ActionMenuView.e_renamed() { // from class: com.coui.appcompat.widget.toolbar.COUIToolbar.1
            @Override // androidx.appcompat.widget.ActionMenuView.e_renamed
            public boolean a_renamed(android.view.MenuItem menuItem) {
                if (com.coui.appcompat.widget.toolbar.COUIToolbar.this.E_renamed != null) {
                    return com.coui.appcompat.widget.toolbar.COUIToolbar.this.E_renamed.a_renamed(menuItem);
                }
                return false;
            }
        };
        this.L_renamed = false;
        this.N_renamed = new int[2];
        this.O_renamed = 0.0f;
        this.T_renamed = new int[2];
        this.U_renamed = new java.lang.Runnable() { // from class: com.coui.appcompat.widget.toolbar.COUIToolbar.2
            @Override // java.lang.Runnable
            public void run() {
                com.coui.appcompat.widget.toolbar.COUIToolbar.this.showOverflowMenu();
            }
        };
        this.f3106b = false;
        setClipToPadding(false);
        setClipChildren(false);
        if (attributeSet != null) {
            this.V_renamed = attributeSet.getStyleAttribute();
            if (this.V_renamed == 0) {
                this.V_renamed = i_renamed;
            }
        } else {
            this.V_renamed = 0;
        }
        androidx.appcompat.widget.ar_renamed arVarA = androidx.appcompat.widget.ar_renamed.a_renamed(getContext(), attributeSet, coui.support.appcompat.R_renamed.styleable.COUIToolbar, i_renamed, 0);
        if (arVarA.g_renamed(coui.support.appcompat.R_renamed.styleable.COUIToolbar_titleType)) {
            this.M_renamed = arVarA.a_renamed(coui.support.appcompat.R_renamed.styleable.COUIToolbar_titleType, 0);
        }
        this.m_renamed = arVarA.g_renamed(coui.support.appcompat.R_renamed.styleable.COUIToolbar_supportTitleTextAppearance, 0);
        this.n_renamed = arVarA.g_renamed(coui.support.appcompat.R_renamed.styleable.COUIToolbar_supportSubtitleTextAppearance, 0);
        this.v_renamed = arVarA.c_renamed(coui.support.appcompat.R_renamed.styleable.COUIToolbar_android_gravity, this.v_renamed);
        this.o_renamed = arVarA.c_renamed(coui.support.appcompat.R_renamed.styleable.COUIToolbar_supportButtonGravity, 48);
        int iD = arVarA.d_renamed(coui.support.appcompat.R_renamed.styleable.COUIToolbar_supportTitleMargins, 0);
        this.t_renamed = iD;
        this.s_renamed = iD;
        this.r_renamed = iD;
        this.q_renamed = iD;
        int iD2 = arVarA.d_renamed(coui.support.appcompat.R_renamed.styleable.COUIToolbar_supportTitleMarginStart, -1);
        if (iD2 >= 0) {
            this.q_renamed = iD2;
        }
        int iD3 = arVarA.d_renamed(coui.support.appcompat.R_renamed.styleable.COUIToolbar_supportTitleMarginEnd, -1);
        if (iD3 >= 0) {
            this.r_renamed = iD3;
        }
        int iD4 = arVarA.d_renamed(coui.support.appcompat.R_renamed.styleable.COUIToolbar_supportTitleMarginTop, -1);
        if (iD4 >= 0) {
            this.s_renamed = iD4;
        }
        int iD5 = arVarA.d_renamed(coui.support.appcompat.R_renamed.styleable.COUIToolbar_supportTitleMarginBottom, -1);
        if (iD5 >= 0) {
            this.t_renamed = iD5;
        }
        this.p_renamed = arVarA.e_renamed(coui.support.appcompat.R_renamed.styleable.COUIToolbar_supportMaxButtonHeight, -1);
        int iD6 = arVarA.d_renamed(coui.support.appcompat.R_renamed.styleable.COUIToolbar_supportContentInsetStart, Integer.MIN_VALUE);
        int iD7 = arVarA.d_renamed(coui.support.appcompat.R_renamed.styleable.COUIToolbar_supportContentInsetEnd, Integer.MIN_VALUE);
        this.u_renamed.b_renamed(arVarA.e_renamed(coui.support.appcompat.R_renamed.styleable.COUIToolbar_supportContentInsetLeft, 0), arVarA.e_renamed(coui.support.appcompat.R_renamed.styleable.COUIToolbar_supportContentInsetRight, 0));
        if (iD6 != Integer.MIN_VALUE || iD7 != Integer.MIN_VALUE) {
            this.u_renamed.a_renamed(iD6, iD7);
        }
        this.h_renamed = arVarA.a_renamed(coui.support.appcompat.R_renamed.styleable.COUIToolbar_supportCollapseIcon);
        this.i_renamed = arVarA.c_renamed(coui.support.appcompat.R_renamed.styleable.COUIToolbar_supportCollapseContentDescription);
        java.lang.CharSequence charSequenceC = arVarA.c_renamed(coui.support.appcompat.R_renamed.styleable.COUIToolbar_supportTitle);
        if (!android.text.TextUtils.isEmpty(charSequenceC)) {
            setTitle(charSequenceC);
        }
        java.lang.CharSequence charSequenceC2 = arVarA.c_renamed(coui.support.appcompat.R_renamed.styleable.COUIToolbar_supportSubtitle);
        if (!android.text.TextUtils.isEmpty(charSequenceC2)) {
            setSubtitle(charSequenceC2);
        }
        this.k_renamed = getContext();
        setPopupTheme(arVarA.g_renamed(coui.support.appcompat.R_renamed.styleable.COUIToolbar_supportPopupTheme, 0));
        android.graphics.drawable.Drawable drawableA = arVarA.a_renamed(coui.support.appcompat.R_renamed.styleable.COUIToolbar_supportNavigationIcon);
        if (drawableA != null) {
            setNavigationIcon(drawableA);
        }
        java.lang.CharSequence charSequenceC3 = arVarA.c_renamed(coui.support.appcompat.R_renamed.styleable.COUIToolbar_supportNavigationContentDescription);
        if (!android.text.TextUtils.isEmpty(charSequenceC3)) {
            setNavigationContentDescription(charSequenceC3);
        }
        this.K_renamed = arVarA.e_renamed(coui.support.appcompat.R_renamed.styleable.Toolbar_android_minHeight, 0);
        android.util.DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        if (arVarA.g_renamed(coui.support.appcompat.R_renamed.styleable.COUIToolbar_minTitleTextSize)) {
            this.aa_renamed = arVarA.e_renamed(coui.support.appcompat.R_renamed.styleable.COUIToolbar_minTitleTextSize, (int) (displayMetrics.scaledDensity * 16.0f));
        } else {
            this.aa_renamed = displayMetrics.scaledDensity * 16.0f;
        }
        android.content.res.TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(this.m_renamed, new int[]{android.R_renamed.attr.textSize});
        if (typedArrayObtainStyledAttributes != null) {
            this.W_renamed = typedArrayObtainStyledAttributes.getDimensionPixelSize(0, (int) (displayMetrics.scaledDensity * 24.0f));
            typedArrayObtainStyledAttributes.recycle();
        }
        if (this.M_renamed == 1) {
            this.W_renamed = com.coui.appcompat.a_renamed.a_renamed.a_renamed(this.W_renamed, getResources().getConfiguration().fontScale, 2);
            this.aa_renamed = com.coui.appcompat.a_renamed.a_renamed.a_renamed(this.aa_renamed, getResources().getConfiguration().fontScale, 2);
        }
        this.P_renamed = getContext().getResources().getDimensionPixelOffset(coui.support.appcompat.R_renamed.dimen.toolbar_normal_menu_padding_left);
        this.Q_renamed = getContext().getResources().getDimensionPixelOffset(coui.support.appcompat.R_renamed.dimen.toolbar_normal_menu_padding_right);
        this.R_renamed = getContext().getResources().getDimensionPixelOffset(coui.support.appcompat.R_renamed.dimen.toolbar_center_title_padding_left);
        this.S_renamed = getContext().getResources().getDimensionPixelOffset(coui.support.appcompat.R_renamed.dimen.toolbar_overflow_menu_padding);
        if (arVarA.g_renamed(coui.support.appcompat.R_renamed.styleable.COUIToolbar_titleCenter)) {
            this.L_renamed = arVarA.a_renamed(coui.support.appcompat.R_renamed.styleable.COUIToolbar_titleCenter, false);
        }
        setWillNotDraw(false);
        arVarA.b_renamed();
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setPopupTheme(int i_renamed) {
        if (this.l_renamed != i_renamed) {
            this.l_renamed = i_renamed;
            if (i_renamed == 0) {
                this.k_renamed = getContext();
            } else {
                this.k_renamed = new android.view.ContextThemeWrapper(getContext(), i_renamed);
            }
        }
    }

    public void setSearchView(android.view.View view) {
        a_renamed(view, view != null ? new com.coui.appcompat.widget.toolbar.COUIToolbar.b_renamed(view.getLayoutParams()) : null);
    }

    public void a_renamed(android.view.View view, com.coui.appcompat.widget.toolbar.COUIToolbar.b_renamed bVar) {
        if (view == null) {
            this.f3106b = false;
            return;
        }
        this.f3106b = view != null;
        com.coui.appcompat.widget.toolbar.COUIToolbar.b_renamed bVar2 = new com.coui.appcompat.widget.toolbar.COUIToolbar.b_renamed(bVar);
        bVar2.d_renamed = true;
        bVar2.f3114c = 0;
        addView(view, 0, bVar2);
    }

    @Override // androidx.appcompat.widget.Toolbar
    public int getPopupTheme() {
        return this.l_renamed;
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.View
    public void onRtlPropertiesChanged(int i_renamed) {
        if (android.os.Build.VERSION.SDK_INT >= 17) {
            super.onRtlPropertiesChanged(i_renamed);
        }
        com.coui.appcompat.a_renamed.p_renamed pVar = this.u_renamed;
        if (pVar != null) {
            pVar.a_renamed(i_renamed == 1);
        }
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setLogo(int i_renamed) {
        setLogo(androidx.appcompat.a_renamed.a_renamed.a_renamed.b_renamed(getContext(), i_renamed));
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void dismissPopupMenus() {
        androidx.appcompat.widget.ActionMenuView actionMenuView = this.f3107c;
        if (actionMenuView != null) {
            actionMenuView.i_renamed();
        }
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setLogo(android.graphics.drawable.Drawable drawable) {
        if (drawable != null) {
            b_renamed();
            if (this.g_renamed.getParent() == null) {
                a_renamed(this.g_renamed);
                e_renamed(this.g_renamed);
            }
        } else {
            android.widget.ImageView imageView = this.g_renamed;
            if (imageView != null && imageView.getParent() != null) {
                removeView(this.g_renamed);
            }
        }
        android.widget.ImageView imageView2 = this.g_renamed;
        if (imageView2 != null) {
            imageView2.setImageDrawable(drawable);
        }
    }

    @Override // androidx.appcompat.widget.Toolbar
    public android.graphics.drawable.Drawable getLogo() {
        android.widget.ImageView imageView = this.g_renamed;
        if (imageView != null) {
            return imageView.getDrawable();
        }
        return null;
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setLogoDescription(int i_renamed) {
        setLogoDescription(getContext().getText(i_renamed));
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setLogoDescription(java.lang.CharSequence charSequence) {
        if (!android.text.TextUtils.isEmpty(charSequence)) {
            b_renamed();
        }
        android.widget.ImageView imageView = this.g_renamed;
        if (imageView != null) {
            imageView.setContentDescription(charSequence);
        }
    }

    @Override // androidx.appcompat.widget.Toolbar
    public java.lang.CharSequence getLogoDescription() {
        android.widget.ImageView imageView = this.g_renamed;
        if (imageView != null) {
            return imageView.getContentDescription();
        }
        return null;
    }

    private void b_renamed() {
        if (this.g_renamed == null) {
            this.g_renamed = new android.widget.ImageView(getContext());
        }
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void collapseActionView() {
        com.coui.appcompat.widget.toolbar.COUIToolbar.a_renamed aVar = this.G_renamed;
        androidx.appcompat.view.menu.j_renamed jVar = aVar == null ? null : aVar.f3112b;
        if (jVar != null) {
            jVar.collapseActionView();
        }
    }

    @Override // androidx.appcompat.widget.Toolbar
    public java.lang.CharSequence getTitle() {
        return this.w_renamed;
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setTitle(int i_renamed) {
        setTitle(getContext().getText(i_renamed));
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setTitle(java.lang.CharSequence charSequence) {
        if (!android.text.TextUtils.isEmpty(charSequence)) {
            if (this.d_renamed == null) {
                android.content.Context context = getContext();
                this.d_renamed = new android.widget.TextView(context);
                com.coui.appcompat.widget.toolbar.COUIToolbar.b_renamed bVarGenerateDefaultLayoutParams = generateDefaultLayoutParams();
                bVarGenerateDefaultLayoutParams.bottomMargin = this.t_renamed;
                bVarGenerateDefaultLayoutParams.f264a = 8388613 | (this.o_renamed & 112);
                this.d_renamed.setLayoutParams(bVarGenerateDefaultLayoutParams);
                this.d_renamed.setSingleLine();
                this.d_renamed.setEllipsize(android.text.TextUtils.TruncateAt.END);
                int i_renamed = this.m_renamed;
                if (i_renamed != 0) {
                    this.d_renamed.setTextAppearance(context, i_renamed);
                }
                int i2 = this.y_renamed;
                if (i2 != 0) {
                    this.d_renamed.setTextColor(i2);
                }
                if (this.M_renamed == 1) {
                    this.d_renamed.setTextSize(0, com.coui.appcompat.a_renamed.a_renamed.a_renamed(this.d_renamed.getTextSize(), getContext().getResources().getConfiguration().fontScale, 2));
                }
            }
            if (this.d_renamed.getParent() == null) {
                a_renamed(this.d_renamed);
                e_renamed(this.d_renamed);
            }
        } else {
            android.widget.TextView textView = this.d_renamed;
            if (textView != null && textView.getParent() != null) {
                removeView(this.d_renamed);
            }
        }
        if (this.d_renamed != null) {
            if (android.os.Build.VERSION.SDK_INT >= 17) {
                this.d_renamed.setTextAlignment(5);
            }
            this.d_renamed.setText(charSequence);
            this.O_renamed = this.d_renamed.getTextSize();
        }
        this.w_renamed = charSequence;
    }

    @Override // androidx.appcompat.widget.Toolbar
    public java.lang.CharSequence getSubtitle() {
        return this.x_renamed;
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setSubtitle(int i_renamed) {
        setSubtitle(getContext().getText(i_renamed));
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setSubtitle(java.lang.CharSequence charSequence) {
        if (!android.text.TextUtils.isEmpty(charSequence)) {
            if (this.e_renamed == null) {
                android.content.Context context = getContext();
                this.e_renamed = new android.widget.TextView(context);
                this.e_renamed.setSingleLine();
                this.e_renamed.setEllipsize(android.text.TextUtils.TruncateAt.END);
                int i_renamed = this.n_renamed;
                if (i_renamed != 0) {
                    this.e_renamed.setTextAppearance(context, i_renamed);
                }
                int i2 = this.z_renamed;
                if (i2 != 0) {
                    this.e_renamed.setTextColor(i2);
                }
            }
            if (this.e_renamed.getParent() == null) {
                a_renamed(this.e_renamed);
                e_renamed(this.e_renamed);
            }
        } else {
            android.widget.TextView textView = this.e_renamed;
            if (textView != null && textView.getParent() != null) {
                removeView(this.e_renamed);
            }
        }
        if (this.e_renamed != null) {
            if (android.os.Build.VERSION.SDK_INT >= 17) {
                this.e_renamed.setTextAlignment(5);
            }
            this.e_renamed.setText(charSequence);
        }
        this.x_renamed = charSequence;
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setTitleTextAppearance(android.content.Context context, int i_renamed) {
        this.m_renamed = i_renamed;
        android.widget.TextView textView = this.d_renamed;
        if (textView != null) {
            textView.setTextAppearance(context, i_renamed);
            if (this.M_renamed == 1) {
                this.d_renamed.setTextSize(0, com.coui.appcompat.a_renamed.a_renamed.a_renamed(this.d_renamed.getTextSize(), getContext().getResources().getConfiguration().fontScale, 2));
            }
            this.W_renamed = this.d_renamed.getTextSize();
            this.O_renamed = this.d_renamed.getTextSize();
        }
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setSubtitleTextAppearance(android.content.Context context, int i_renamed) {
        this.n_renamed = i_renamed;
        android.widget.TextView textView = this.e_renamed;
        if (textView != null) {
            textView.setTextAppearance(context, i_renamed);
        }
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setTitleTextColor(int i_renamed) {
        this.y_renamed = i_renamed;
        android.widget.TextView textView = this.d_renamed;
        if (textView != null) {
            textView.setTextColor(i_renamed);
        }
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setSubtitleTextColor(int i_renamed) {
        this.z_renamed = i_renamed;
        android.widget.TextView textView = this.e_renamed;
        if (textView != null) {
            textView.setTextColor(i_renamed);
        }
    }

    @Override // androidx.appcompat.widget.Toolbar
    public java.lang.CharSequence getNavigationContentDescription() {
        android.widget.ImageButton imageButton = this.f_renamed;
        if (imageButton != null) {
            return imageButton.getContentDescription();
        }
        return null;
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setNavigationContentDescription(int i_renamed) {
        setNavigationContentDescription(i_renamed != 0 ? getContext().getText(i_renamed) : null);
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setNavigationContentDescription(java.lang.CharSequence charSequence) {
        if (!android.text.TextUtils.isEmpty(charSequence)) {
            e_renamed();
        }
        android.widget.ImageButton imageButton = this.f_renamed;
        if (imageButton != null) {
            imageButton.setContentDescription(charSequence);
        }
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setNavigationIcon(int i_renamed) {
        setNavigationIcon(androidx.appcompat.a_renamed.a_renamed.a_renamed.b_renamed(getContext(), i_renamed));
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setNavigationIcon(android.graphics.drawable.Drawable drawable) {
        if (drawable != null) {
            e_renamed();
            if (this.f_renamed.getParent() == null) {
                a_renamed(this.f_renamed);
                e_renamed(this.f_renamed);
            }
        } else {
            android.widget.ImageButton imageButton = this.f_renamed;
            if (imageButton != null && imageButton.getParent() != null) {
                removeView(this.f_renamed);
            }
        }
        android.widget.ImageButton imageButton2 = this.f_renamed;
        if (imageButton2 != null) {
            imageButton2.setImageDrawable(drawable);
        }
    }

    @Override // androidx.appcompat.widget.Toolbar
    public android.graphics.drawable.Drawable getNavigationIcon() {
        android.widget.ImageButton imageButton = this.f_renamed;
        if (imageButton != null) {
            return imageButton.getDrawable();
        }
        return null;
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setNavigationOnClickListener(android.view.View.OnClickListener onClickListener) {
        e_renamed();
        this.f_renamed.setOnClickListener(onClickListener);
    }

    @Override // androidx.appcompat.widget.Toolbar
    public android.view.Menu getMenu() {
        c_renamed();
        return this.f3107c.getMenu();
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setOverflowIcon(android.graphics.drawable.Drawable drawable) {
        c_renamed();
        this.f3107c.setOverflowIcon(drawable);
    }

    @Override // androidx.appcompat.widget.Toolbar
    public android.graphics.drawable.Drawable getOverflowIcon() {
        c_renamed();
        return this.f3107c.getOverflowIcon();
    }

    private void c_renamed() {
        d_renamed();
        if (this.f3107c.d_renamed() == null) {
            androidx.appcompat.view.menu.h_renamed hVar = (androidx.appcompat.view.menu.h_renamed) this.f3107c.getMenu();
            if (this.G_renamed == null) {
                this.G_renamed = new com.coui.appcompat.widget.toolbar.COUIToolbar.a_renamed();
            }
            this.f3107c.setExpandedActionViewsExclusive(true);
            hVar.addMenuPresenter(this.G_renamed, this.k_renamed);
        }
    }

    private void d_renamed() {
        if (this.f3107c == null) {
            this.f3107c = new com.coui.appcompat.widget.toolbar.a_renamed(getContext());
            this.f3107c.setPopupTheme(this.l_renamed);
            this.f3107c.setOnMenuItemClickListener(this.F_renamed);
            this.f3107c.a_renamed(this.H_renamed, this.I_renamed);
            com.coui.appcompat.widget.toolbar.COUIToolbar.b_renamed bVarGenerateDefaultLayoutParams = generateDefaultLayoutParams();
            if (this.L_renamed) {
                bVarGenerateDefaultLayoutParams.width = -1;
            } else {
                bVarGenerateDefaultLayoutParams.width = -2;
            }
            bVarGenerateDefaultLayoutParams.f264a = 8388613 | (this.o_renamed & 112);
            this.f3107c.setLayoutParams(bVarGenerateDefaultLayoutParams);
            a_renamed(this.f3107c);
        }
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setOnMenuItemClickListener(androidx.appcompat.widget.Toolbar.c_renamed cVar) {
        this.E_renamed = cVar;
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setContentInsetsRelative(int i_renamed, int i2) {
        this.u_renamed.a_renamed(i_renamed, i2);
    }

    @Override // androidx.appcompat.widget.Toolbar
    public int getContentInsetStart() {
        return this.u_renamed.c_renamed();
    }

    @Override // androidx.appcompat.widget.Toolbar
    public int getContentInsetEnd() {
        return this.u_renamed.d_renamed();
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setContentInsetsAbsolute(int i_renamed, int i2) {
        this.u_renamed.b_renamed(i_renamed, i2);
    }

    @Override // androidx.appcompat.widget.Toolbar
    public int getContentInsetLeft() {
        return this.u_renamed.a_renamed();
    }

    @Override // androidx.appcompat.widget.Toolbar
    public int getContentInsetRight() {
        return this.u_renamed.b_renamed();
    }

    private void e_renamed() {
        if (this.f_renamed == null) {
            this.f_renamed = new android.widget.ImageButton(getContext(), null, coui.support.appcompat.R_renamed.attr.toolbarNavigationButtonStyle);
            com.coui.appcompat.widget.toolbar.COUIToolbar.b_renamed bVarGenerateDefaultLayoutParams = generateDefaultLayoutParams();
            bVarGenerateDefaultLayoutParams.f264a = 8388611 | (this.o_renamed & 112);
            this.f_renamed.setLayoutParams(bVarGenerateDefaultLayoutParams);
            this.f_renamed.setBackgroundResource(coui.support.appcompat.R_renamed.drawable.coui_toolbar_menu_bg);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f_renamed() {
        if (this.j_renamed == null) {
            this.j_renamed = new android.widget.ImageButton(getContext(), null, coui.support.appcompat.R_renamed.attr.toolbarNavigationButtonStyle);
            this.j_renamed.setImageDrawable(this.h_renamed);
            this.j_renamed.setContentDescription(this.i_renamed);
            com.coui.appcompat.widget.toolbar.COUIToolbar.b_renamed bVarGenerateDefaultLayoutParams = generateDefaultLayoutParams();
            bVarGenerateDefaultLayoutParams.f264a = 8388611 | (this.o_renamed & 112);
            bVarGenerateDefaultLayoutParams.f3114c = 2;
            this.j_renamed.setLayoutParams(bVarGenerateDefaultLayoutParams);
            this.j_renamed.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.coui.appcompat.widget.toolbar.COUIToolbar.3
                @Override // android.view.View.OnClickListener
                public void onClick(android.view.View view) {
                    com.coui.appcompat.widget.toolbar.COUIToolbar.this.collapseActionView();
                }
            });
        }
    }

    private void a_renamed(android.view.View view) {
        com.coui.appcompat.widget.toolbar.COUIToolbar.b_renamed bVarGenerateLayoutParams;
        android.view.ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            bVarGenerateLayoutParams = generateDefaultLayoutParams();
        } else if (!checkLayoutParams(layoutParams)) {
            bVarGenerateLayoutParams = generateLayoutParams(layoutParams);
        } else {
            bVarGenerateLayoutParams = (com.coui.appcompat.widget.toolbar.COUIToolbar.b_renamed) layoutParams;
        }
        bVarGenerateLayoutParams.f3114c = 1;
        addView(view, bVarGenerateLayoutParams);
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.U_renamed);
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.View
    public boolean onTouchEvent(android.view.MotionEvent motionEvent) {
        int iA = androidx.core.h_renamed.h_renamed.a_renamed(motionEvent);
        if (iA == 0) {
            this.A_renamed = false;
        }
        if (!this.A_renamed) {
            boolean zOnTouchEvent = super.onTouchEvent(motionEvent);
            if (iA == 0 && !zOnTouchEvent) {
                this.A_renamed = true;
            }
        }
        if (iA == 1 || iA == 3) {
            this.A_renamed = false;
        }
        return true;
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.View
    public boolean onHoverEvent(android.view.MotionEvent motionEvent) {
        int iA = androidx.core.h_renamed.h_renamed.a_renamed(motionEvent);
        if (iA == 9) {
            this.B_renamed = false;
        }
        if (!this.B_renamed) {
            boolean zOnHoverEvent = super.onHoverEvent(motionEvent);
            if (iA == 9 && !zOnHoverEvent) {
                this.B_renamed = true;
            }
        }
        if (iA == 10 || iA == 3) {
            this.B_renamed = false;
        }
        return true;
    }

    private void a_renamed(android.view.View view, int i_renamed, int i2, int i3, int i4, int i5) {
        android.view.ViewGroup.MarginLayoutParams marginLayoutParams = (android.view.ViewGroup.MarginLayoutParams) view.getLayoutParams();
        int childMeasureSpec = getChildMeasureSpec(i_renamed, getPaddingLeft() + getPaddingRight() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i2, marginLayoutParams.width);
        int childMeasureSpec2 = getChildMeasureSpec(i3, getPaddingTop() + getPaddingBottom() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + i4, marginLayoutParams.height);
        int mode = android.view.View.MeasureSpec.getMode(childMeasureSpec2);
        if (mode != 1073741824 && i5 >= 0) {
            if (mode != 0) {
                i5 = java.lang.Math.min(android.view.View.MeasureSpec.getSize(childMeasureSpec2), i5);
            }
            childMeasureSpec2 = android.view.View.MeasureSpec.makeMeasureSpec(i5, 1073741824);
        }
        view.measure(childMeasureSpec, childMeasureSpec2);
    }

    private int a_renamed(android.view.View view, int i_renamed, int i2, int i3, int i4, int[] iArr) {
        int childMeasureSpec;
        android.view.ViewGroup.MarginLayoutParams marginLayoutParams = (android.view.ViewGroup.MarginLayoutParams) view.getLayoutParams();
        boolean z_renamed = false;
        int i5 = marginLayoutParams.leftMargin - iArr[0];
        int i6 = marginLayoutParams.rightMargin - iArr[1];
        int iMax = java.lang.Math.max(0, i5) + java.lang.Math.max(0, i6);
        iArr[0] = java.lang.Math.max(0, -i5);
        iArr[1] = java.lang.Math.max(0, -i6);
        if ((marginLayoutParams instanceof com.coui.appcompat.widget.toolbar.COUIToolbar.b_renamed) && ((com.coui.appcompat.widget.toolbar.COUIToolbar.b_renamed) marginLayoutParams).d_renamed && this.f3106b) {
            z_renamed = true;
        }
        if (z_renamed) {
            childMeasureSpec = getChildMeasureSpec(i_renamed, getContentInsetStart() + iMax + getContentInsetStart(), marginLayoutParams.width);
        } else {
            childMeasureSpec = getChildMeasureSpec(i_renamed, getPaddingLeft() + getPaddingRight() + iMax + i2, marginLayoutParams.width);
        }
        view.measure(childMeasureSpec, getChildMeasureSpec(i3, getPaddingTop() + getPaddingBottom() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + i4, marginLayoutParams.height));
        return z_renamed ? iMax : view.getMeasuredWidth() + iMax;
    }

    private boolean g_renamed() {
        if (!this.J_renamed) {
            return false;
        }
        int childCount = getChildCount();
        for (int i_renamed = 0; i_renamed < childCount; i_renamed++) {
            android.view.View childAt = getChildAt(i_renamed);
            if (b_renamed(childAt) && childAt.getMeasuredWidth() > 0 && childAt.getMeasuredHeight() > 0) {
                return false;
            }
        }
        return true;
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.View
    protected void onMeasure(int i_renamed, int i2) throws android.content.res.Resources.NotFoundException {
        char c2;
        char c3;
        int measuredWidth;
        int iMax;
        int iCombineMeasuredStates;
        int measuredWidth2;
        int i3;
        int i4;
        int iCombineMeasuredStates2;
        int iMax2;
        int measuredHeight;
        char c4;
        char c5;
        int measuredWidth3;
        int iCombineMeasuredStates3;
        int iMax3;
        int i5;
        int iCombineMeasuredStates4;
        int measuredHeight2;
        int iMax4;
        int iCombineMeasuredStates5;
        int i6;
        int i7;
        boolean z_renamed = androidx.core.h_renamed.v_renamed.g_renamed(this) == 1;
        if (this.L_renamed) {
            int[] iArr = this.D_renamed;
            if (androidx.appcompat.widget.ax_renamed.a_renamed(this)) {
                c5 = 1;
                c4 = 0;
            } else {
                c4 = 1;
                c5 = 0;
            }
            int contentInsetStart = getContentInsetStart();
            int iMax5 = java.lang.Math.max(contentInsetStart, 0) + 0;
            iArr[c5] = java.lang.Math.max(0, contentInsetStart - 0);
            if (b_renamed(this.f3107c)) {
                a_renamed((androidx.appcompat.view.menu.h_renamed) this.f3107c.getMenu(), z_renamed);
                a_renamed(this.f3107c, i_renamed, 0, i2, 0, this.p_renamed);
                measuredWidth3 = this.f3107c.getMeasuredWidth() + c_renamed(this.f3107c);
                iMax3 = java.lang.Math.max(0, this.f3107c.getMeasuredHeight() + d_renamed(this.f3107c));
                iCombineMeasuredStates3 = android.view.View.combineMeasuredStates(0, androidx.core.h_renamed.v_renamed.h_renamed(this.f3107c));
            } else {
                measuredWidth3 = 0;
                iCombineMeasuredStates3 = 0;
                iMax3 = 0;
            }
            int contentInsetEnd = getContentInsetEnd();
            int iMax6 = iMax5 + java.lang.Math.max(contentInsetEnd, measuredWidth3);
            iArr[c4] = java.lang.Math.max(0, contentInsetEnd - measuredWidth3);
            if (b_renamed(this.f3105a)) {
                iMax6 += a_renamed(this.f3105a, i_renamed, iMax6, i2, 0, iArr);
                iMax3 = java.lang.Math.max(iMax3, this.f3105a.getMeasuredHeight() + d_renamed(this.f3105a));
                iCombineMeasuredStates3 = android.view.View.combineMeasuredStates(iCombineMeasuredStates3, androidx.core.h_renamed.v_renamed.h_renamed(this.f3105a));
            }
            int iCombineMeasuredStates6 = iCombineMeasuredStates3;
            int childCount = getChildCount();
            int iMax7 = iMax3;
            int i8 = 0;
            while (i8 < childCount) {
                android.view.View childAt = getChildAt(i8);
                if (((com.coui.appcompat.widget.toolbar.COUIToolbar.b_renamed) childAt.getLayoutParams()).f3114c == 0 && b_renamed(childAt)) {
                    i7 = childCount;
                    iMax6 += a_renamed(childAt, i_renamed, iMax6, i2, 0, iArr);
                    iMax7 = java.lang.Math.max(iMax7, childAt.getMeasuredHeight() + d_renamed(childAt));
                    iCombineMeasuredStates6 = android.view.View.combineMeasuredStates(iCombineMeasuredStates6, androidx.core.h_renamed.v_renamed.h_renamed(childAt));
                } else {
                    i7 = childCount;
                    iMax7 = iMax7;
                }
                i8++;
                childCount = i7;
            }
            int i9 = iMax7;
            int i10 = this.s_renamed + this.t_renamed;
            int i11 = this.q_renamed;
            int i12 = this.r_renamed;
            if (b_renamed(this.d_renamed)) {
                this.d_renamed.getLayoutParams().width = -2;
                this.d_renamed.setTextSize(0, this.O_renamed);
                i5 = -2;
                a_renamed(this.d_renamed, i_renamed, 0, i2, i10, iArr);
                int measuredWidth4 = this.d_renamed.getMeasuredWidth() + c_renamed(this.d_renamed);
                measuredHeight2 = this.d_renamed.getMeasuredHeight() + d_renamed(this.d_renamed);
                iCombineMeasuredStates4 = android.view.View.combineMeasuredStates(iCombineMeasuredStates6, androidx.core.h_renamed.v_renamed.h_renamed(this.d_renamed));
                iMax4 = measuredWidth4;
            } else {
                i5 = -2;
                iCombineMeasuredStates4 = iCombineMeasuredStates6;
                measuredHeight2 = 0;
                iMax4 = 0;
            }
            if (b_renamed(this.e_renamed)) {
                this.e_renamed.getLayoutParams().width = i5;
                i6 = measuredHeight2;
                iMax4 = java.lang.Math.max(iMax4, a_renamed(this.e_renamed, i_renamed, 0, i2, measuredHeight2 + i10, iArr));
                iCombineMeasuredStates5 = android.view.View.combineMeasuredStates(iCombineMeasuredStates4, androidx.core.h_renamed.v_renamed.h_renamed(this.e_renamed));
            } else {
                iCombineMeasuredStates5 = iCombineMeasuredStates4;
                i6 = measuredHeight2;
            }
            int iMax8 = java.lang.Math.max(i9, i6);
            int paddingLeft = iMax6 + iMax4 + getPaddingLeft() + getPaddingRight();
            int paddingTop = iMax8 + getPaddingTop() + getPaddingBottom();
            int iA = androidx.core.h_renamed.v_renamed.a_renamed(java.lang.Math.max(paddingLeft, getSuggestedMinimumWidth()), i_renamed, (-16777216) & iCombineMeasuredStates5);
            int iA2 = androidx.core.h_renamed.v_renamed.a_renamed(java.lang.Math.max(paddingTop, getSuggestedMinimumHeight()), i2, iCombineMeasuredStates5 << 16);
            if (g_renamed()) {
                iA2 = 0;
            }
            setMeasuredDimension(iA, iA2);
            a_renamed(this.N_renamed);
            int[] iArr2 = this.N_renamed;
            int i13 = iArr2[1] - iArr2[0];
            if (b_renamed(this.d_renamed)) {
                int measuredWidth5 = this.d_renamed.getMeasuredWidth();
                int[] iArr3 = this.N_renamed;
                if (measuredWidth5 > iArr3[1] - iArr3[0]) {
                    a_renamed(this.d_renamed, android.view.View.MeasureSpec.makeMeasureSpec(i13, Integer.MIN_VALUE), 0, i2, i10, iArr);
                }
            }
            if (b_renamed(this.e_renamed)) {
                int measuredWidth6 = this.e_renamed.getMeasuredWidth();
                int[] iArr4 = this.N_renamed;
                if (measuredWidth6 > iArr4[1] - iArr4[0]) {
                    a_renamed(this.e_renamed, android.view.View.MeasureSpec.makeMeasureSpec(i13, Integer.MIN_VALUE), 0, i2, i6 + i10, iArr);
                    return;
                }
                return;
            }
            return;
        }
        int[] iArr5 = this.D_renamed;
        if (androidx.appcompat.widget.ax_renamed.a_renamed(this)) {
            c3 = 1;
            c2 = 0;
        } else {
            c2 = 1;
            c3 = 0;
        }
        if (b_renamed(this.f_renamed)) {
            a_renamed(this.f_renamed, i_renamed, 0, i2, 0, this.p_renamed);
            measuredWidth = this.f_renamed.getMeasuredWidth() + c_renamed(this.f_renamed);
            iMax = java.lang.Math.max(0, this.f_renamed.getMeasuredHeight() + d_renamed(this.f_renamed));
            iCombineMeasuredStates = android.view.View.combineMeasuredStates(0, androidx.core.h_renamed.v_renamed.h_renamed(this.f_renamed));
        } else {
            measuredWidth = 0;
            iMax = 0;
            iCombineMeasuredStates = 0;
        }
        if (b_renamed(this.j_renamed)) {
            a_renamed(this.j_renamed, i_renamed, 0, i2, 0, this.p_renamed);
            measuredWidth = this.j_renamed.getMeasuredWidth() + c_renamed(this.j_renamed);
            iMax = java.lang.Math.max(iMax, this.j_renamed.getMeasuredHeight() + d_renamed(this.j_renamed));
            iCombineMeasuredStates = android.view.View.combineMeasuredStates(iCombineMeasuredStates, androidx.core.h_renamed.v_renamed.h_renamed(this.j_renamed));
        }
        int contentInsetStart2 = getContentInsetStart();
        int iMax9 = 0 + java.lang.Math.max(contentInsetStart2, measuredWidth);
        iArr5[c3] = java.lang.Math.max(0, contentInsetStart2 - measuredWidth);
        if (b_renamed(this.f3107c)) {
            a_renamed((androidx.appcompat.view.menu.h_renamed) this.f3107c.getMenu(), z_renamed);
            a_renamed(this.f3107c, i_renamed, iMax9, i2, 0, this.p_renamed);
            measuredWidth2 = this.f3107c.getMeasuredWidth() + c_renamed(this.f3107c);
            iMax = java.lang.Math.max(iMax, this.f3107c.getMeasuredHeight() + d_renamed(this.f3107c));
            iCombineMeasuredStates = android.view.View.combineMeasuredStates(iCombineMeasuredStates, androidx.core.h_renamed.v_renamed.h_renamed(this.f3107c));
        } else {
            measuredWidth2 = 0;
        }
        int contentInsetEnd2 = getContentInsetEnd();
        int iMax10 = iMax9 + java.lang.Math.max(contentInsetEnd2, measuredWidth2);
        iArr5[c2] = java.lang.Math.max(0, contentInsetEnd2 - measuredWidth2);
        if (b_renamed(this.f3105a)) {
            iMax10 += a_renamed(this.f3105a, i_renamed, iMax10, i2, 0, iArr5);
            iMax = java.lang.Math.max(iMax, this.f3105a.getMeasuredHeight() + d_renamed(this.f3105a));
            iCombineMeasuredStates = android.view.View.combineMeasuredStates(iCombineMeasuredStates, androidx.core.h_renamed.v_renamed.h_renamed(this.f3105a));
        }
        if (b_renamed(this.g_renamed)) {
            iMax10 += a_renamed(this.g_renamed, i_renamed, iMax10, i2, 0, iArr5);
            iMax = java.lang.Math.max(iMax, this.g_renamed.getMeasuredHeight() + d_renamed(this.g_renamed));
            iCombineMeasuredStates = android.view.View.combineMeasuredStates(iCombineMeasuredStates, androidx.core.h_renamed.v_renamed.h_renamed(this.g_renamed));
        }
        int childCount2 = getChildCount();
        int iA3 = iMax10;
        for (int i14 = 0; i14 < childCount2; i14++) {
            android.view.View childAt2 = getChildAt(i14);
            if (((com.coui.appcompat.widget.toolbar.COUIToolbar.b_renamed) childAt2.getLayoutParams()).f3114c == 0 && b_renamed(childAt2)) {
                iA3 += a_renamed(childAt2, i_renamed, iA3, i2, 0, iArr5);
                iMax = java.lang.Math.max(iMax, childAt2.getMeasuredHeight() + d_renamed(childAt2));
                iCombineMeasuredStates = android.view.View.combineMeasuredStates(iCombineMeasuredStates, androidx.core.h_renamed.v_renamed.h_renamed(childAt2));
            }
        }
        int i15 = this.s_renamed + this.t_renamed;
        int i16 = this.q_renamed + this.r_renamed;
        if (b_renamed(this.d_renamed)) {
            this.d_renamed.getLayoutParams().width = -1;
            this.d_renamed.setTextSize(0, this.O_renamed);
            i4 = 0;
            i3 = -1;
            a_renamed(this.d_renamed, i_renamed, iA3 + i16, i2, i15, iArr5);
            int measuredWidth7 = this.d_renamed.getMeasuredWidth() + c_renamed(this.d_renamed);
            measuredHeight = this.d_renamed.getMeasuredHeight() + d_renamed(this.d_renamed);
            iCombineMeasuredStates2 = android.view.View.combineMeasuredStates(iCombineMeasuredStates, androidx.core.h_renamed.v_renamed.h_renamed(this.d_renamed));
            iMax2 = measuredWidth7;
        } else {
            i3 = -1;
            i4 = 0;
            iCombineMeasuredStates2 = iCombineMeasuredStates;
            iMax2 = 0;
            measuredHeight = 0;
        }
        if (b_renamed(this.e_renamed)) {
            this.e_renamed.getLayoutParams().width = i3;
            iMax2 = java.lang.Math.max(iMax2, a_renamed(this.e_renamed, i_renamed, iA3 + i16, i2, measuredHeight + i15, iArr5));
            measuredHeight += this.e_renamed.getMeasuredHeight() + d_renamed(this.e_renamed);
            iCombineMeasuredStates2 = android.view.View.combineMeasuredStates(iCombineMeasuredStates2, androidx.core.h_renamed.v_renamed.h_renamed(this.e_renamed));
        }
        int iMax11 = java.lang.Math.max(iMax, measuredHeight);
        int paddingLeft2 = iA3 + iMax2 + getPaddingLeft() + getPaddingRight();
        int paddingTop2 = iMax11 + getPaddingTop() + getPaddingBottom();
        int iA4 = androidx.core.h_renamed.v_renamed.a_renamed(java.lang.Math.max(paddingLeft2, getSuggestedMinimumWidth()), i_renamed, (-16777216) & iCombineMeasuredStates2);
        int iA5 = androidx.core.h_renamed.v_renamed.a_renamed(java.lang.Math.max(paddingTop2, getSuggestedMinimumHeight()), i2, iCombineMeasuredStates2 << 16);
        if (g_renamed()) {
            iA5 = i4;
        }
        setMeasuredDimension(iA4, iA5);
    }

    private void a_renamed(androidx.appcompat.view.menu.h_renamed hVar, boolean z_renamed) {
        int paddingLeft;
        if (hVar == null) {
            return;
        }
        boolean z2 = false;
        if (getChildCount() > 0 && (getChildAt(0) instanceof com.coui.appcompat.widget.COUISearchViewAnimate)) {
            z2 = true;
        }
        if (!hVar.getNonActionItems().isEmpty()) {
            if (z_renamed) {
                setPadding(this.Q_renamed, getPaddingTop(), this.L_renamed ? this.R_renamed : this.P_renamed, getPaddingBottom());
                return;
            } else {
                setPadding(this.L_renamed ? this.R_renamed : this.P_renamed, getPaddingTop(), this.Q_renamed, getPaddingBottom());
                return;
            }
        }
        if (z_renamed) {
            setPadding(z2 ? getPaddingLeft() : this.Q_renamed, getPaddingTop(), z2 ? getPaddingRight() : this.L_renamed ? this.R_renamed : this.P_renamed, getPaddingBottom());
            return;
        }
        if (z2) {
            paddingLeft = getPaddingLeft();
        } else {
            paddingLeft = this.L_renamed ? this.R_renamed : this.P_renamed;
        }
        setPadding(paddingLeft, getPaddingTop(), z2 ? getPaddingRight() : this.Q_renamed, getPaddingBottom());
    }

    private void a_renamed(int[] iArr) throws android.content.res.Resources.NotFoundException {
        int measuredWidth;
        int measuredWidth2;
        boolean z_renamed = androidx.core.h_renamed.v_renamed.g_renamed(this) == 1;
        int dimensionPixelSize = getResources().getDimensionPixelSize(coui.support.appcompat.R_renamed.dimen.coui_actionbar_menuitemview_item_spacing);
        iArr[0] = java.lang.Math.max(this.u_renamed.a_renamed(), getPaddingLeft());
        iArr[1] = getMeasuredWidth() - java.lang.Math.max(this.u_renamed.b_renamed(), getPaddingRight());
        if (!b_renamed(this.f3107c) || this.f3107c.getChildCount() == 0) {
            return;
        }
        if (this.f3107c.getChildCount() == 1) {
            measuredWidth2 = this.f3107c.getChildAt(0).getMeasuredWidth() + dimensionPixelSize + 0;
            measuredWidth = 0;
        } else {
            measuredWidth = this.f3107c.getChildAt(0).getMeasuredWidth() + dimensionPixelSize + 0;
            int measuredWidth3 = 0;
            for (int i_renamed = 1; i_renamed < this.f3107c.getChildCount(); i_renamed++) {
                measuredWidth3 += this.f3107c.getChildAt(i_renamed).getMeasuredWidth() + dimensionPixelSize;
            }
            measuredWidth2 = measuredWidth3;
        }
        if (z_renamed) {
            iArr[0] = iArr[0] + measuredWidth2;
            iArr[1] = iArr[1] - measuredWidth;
        } else {
            iArr[0] = iArr[0] + measuredWidth;
            iArr[1] = iArr[1] - measuredWidth2;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B_renamed:123:0x0364  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:135:0x03ad  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:140:0x03d1  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:152:0x0415  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:158:0x0444  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:15:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:163:0x0453 A_renamed[LOOP:2: B_renamed:162:0x0451->B_renamed:163:0x0453, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B_renamed:20:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:25:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:30:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:35:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:36:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:38:0x00fe  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:39:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:44:0x0125  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:45:0x0127  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:46:0x012a  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:48:0x012e  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:49:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:61:0x0164  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:71:0x01a3  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:74:0x01b4  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:96:0x0277  */
    @Override // androidx.appcompat.widget.Toolbar, android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void onLayout(boolean r19, int r20, int r21, int r22, int r23) {
        /*
            Method dump skipped, instructions count: 1128
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.coui.appcompat.widget.toolbar.COUIToolbar.onLayout(boolean, int, int, int, int):void");
    }

    private int a_renamed(java.util.List<android.view.View> list, int[] iArr) {
        int i_renamed = iArr[0];
        int i2 = iArr[1];
        int size = list.size();
        int i3 = i2;
        int i4 = i_renamed;
        int i5 = 0;
        int measuredWidth = 0;
        while (i5 < size) {
            android.view.View view = list.get(i5);
            com.coui.appcompat.widget.toolbar.COUIToolbar.b_renamed bVar = (com.coui.appcompat.widget.toolbar.COUIToolbar.b_renamed) view.getLayoutParams();
            int i6 = bVar.leftMargin - i4;
            int i7 = bVar.rightMargin - i3;
            int iMax = java.lang.Math.max(0, i6);
            int iMax2 = java.lang.Math.max(0, i7);
            int iMax3 = java.lang.Math.max(0, -i6);
            int iMax4 = java.lang.Math.max(0, -i7);
            measuredWidth += iMax + view.getMeasuredWidth() + iMax2;
            i5++;
            i3 = iMax4;
            i4 = iMax3;
        }
        return measuredWidth;
    }

    private int a_renamed(android.view.View view, int i_renamed, int[] iArr, int i2) {
        com.coui.appcompat.widget.toolbar.COUIToolbar.b_renamed bVar = (com.coui.appcompat.widget.toolbar.COUIToolbar.b_renamed) view.getLayoutParams();
        int i3 = bVar.leftMargin - iArr[0];
        int iMax = i_renamed + java.lang.Math.max(0, i3);
        iArr[0] = java.lang.Math.max(0, -i3);
        int iA = a_renamed(view, i2);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(iMax, iA, iMax + measuredWidth, view.getMeasuredHeight() + iA);
        return iMax + measuredWidth + bVar.rightMargin;
    }

    private int b_renamed(android.view.View view, int i_renamed, int[] iArr, int i2) {
        com.coui.appcompat.widget.toolbar.COUIToolbar.b_renamed bVar = (com.coui.appcompat.widget.toolbar.COUIToolbar.b_renamed) view.getLayoutParams();
        int i3 = bVar.rightMargin - iArr[1];
        int iMax = i_renamed - java.lang.Math.max(0, i3);
        iArr[1] = java.lang.Math.max(0, -i3);
        int iA = a_renamed(view, i2);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(iMax - measuredWidth, iA, iMax, view.getMeasuredHeight() + iA);
        return iMax - (measuredWidth + bVar.leftMargin);
    }

    private int a_renamed(android.view.View view, int i_renamed) {
        com.coui.appcompat.widget.toolbar.COUIToolbar.b_renamed bVar = (com.coui.appcompat.widget.toolbar.COUIToolbar.b_renamed) view.getLayoutParams();
        int measuredHeight = view.getMeasuredHeight();
        int i2 = i_renamed > 0 ? (measuredHeight - i_renamed) / 2 : 0;
        int iA = a_renamed(bVar.f264a);
        if (iA == 48) {
            return getPaddingTop() - i2;
        }
        if (iA == 80) {
            return (((getHeight() - getPaddingBottom()) - measuredHeight) - bVar.bottomMargin) - i2;
        }
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int height = getHeight();
        int iMax = (((height - paddingTop) - paddingBottom) - measuredHeight) / 2;
        if (iMax < bVar.topMargin) {
            iMax = bVar.topMargin;
        } else {
            int i3 = (((height - paddingBottom) - measuredHeight) - iMax) - paddingTop;
            if (i3 < bVar.bottomMargin) {
                iMax = java.lang.Math.max(0, iMax - (bVar.bottomMargin - i3));
            }
        }
        return paddingTop + iMax;
    }

    private int a_renamed(int i_renamed) {
        int i2 = i_renamed & 112;
        return (i2 == 16 || i2 == 48 || i2 == 80) ? i2 : this.v_renamed & 112;
    }

    private void a_renamed(java.util.List<android.view.View> list, int i_renamed) {
        boolean z_renamed = androidx.core.h_renamed.v_renamed.g_renamed(this) == 1;
        int childCount = getChildCount();
        int iA = androidx.core.h_renamed.c_renamed.a_renamed(i_renamed, androidx.core.h_renamed.v_renamed.g_renamed(this));
        list.clear();
        if (!z_renamed) {
            for (int i2 = 0; i2 < childCount; i2++) {
                android.view.View childAt = getChildAt(i2);
                com.coui.appcompat.widget.toolbar.COUIToolbar.b_renamed bVar = (com.coui.appcompat.widget.toolbar.COUIToolbar.b_renamed) childAt.getLayoutParams();
                if (bVar.f3114c == 0 && b_renamed(childAt) && b_renamed(bVar.f264a) == iA) {
                    list.add(childAt);
                }
            }
            return;
        }
        for (int i3 = childCount - 1; i3 >= 0; i3--) {
            android.view.View childAt2 = getChildAt(i3);
            com.coui.appcompat.widget.toolbar.COUIToolbar.b_renamed bVar2 = (com.coui.appcompat.widget.toolbar.COUIToolbar.b_renamed) childAt2.getLayoutParams();
            if (bVar2.f3114c == 0 && b_renamed(childAt2) && b_renamed(bVar2.f264a) == iA) {
                list.add(childAt2);
            }
        }
    }

    private int b_renamed(int i_renamed) {
        int iG = androidx.core.h_renamed.v_renamed.g_renamed(this);
        int iA = androidx.core.h_renamed.c_renamed.a_renamed(i_renamed, iG) & 7;
        return (iA == 1 || iA == 3 || iA == 5) ? iA : iG == 1 ? 5 : 3;
    }

    private boolean b_renamed(android.view.View view) {
        return (view == null || view.getParent() != this || view.getVisibility() == 8) ? false : true;
    }

    private int c_renamed(android.view.View view) {
        android.view.ViewGroup.MarginLayoutParams marginLayoutParams = (android.view.ViewGroup.MarginLayoutParams) view.getLayoutParams();
        return androidx.core.h_renamed.f_renamed.a_renamed(marginLayoutParams) + androidx.core.h_renamed.f_renamed.b_renamed(marginLayoutParams);
    }

    private int d_renamed(android.view.View view) {
        android.view.ViewGroup.MarginLayoutParams marginLayoutParams = (android.view.ViewGroup.MarginLayoutParams) view.getLayoutParams();
        return marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.ViewGroup
    /* renamed from: a_renamed, reason: merged with bridge method [inline-methods] */
    public com.coui.appcompat.widget.toolbar.COUIToolbar.b_renamed generateLayoutParams(android.util.AttributeSet attributeSet) {
        return new com.coui.appcompat.widget.toolbar.COUIToolbar.b_renamed(getContext(), attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.Toolbar, android.view.ViewGroup
    /* renamed from: a_renamed, reason: merged with bridge method [inline-methods] */
    public com.coui.appcompat.widget.toolbar.COUIToolbar.b_renamed generateLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof com.coui.appcompat.widget.toolbar.COUIToolbar.b_renamed) {
            return new com.coui.appcompat.widget.toolbar.COUIToolbar.b_renamed((com.coui.appcompat.widget.toolbar.COUIToolbar.b_renamed) layoutParams);
        }
        if (layoutParams instanceof androidx.appcompat.app.a_renamed.ActionBar_4) {
            return new com.coui.appcompat.widget.toolbar.COUIToolbar.b_renamed((androidx.appcompat.app.a_renamed.ActionBar_4) layoutParams);
        }
        if (layoutParams instanceof android.view.ViewGroup.MarginLayoutParams) {
            return new com.coui.appcompat.widget.toolbar.COUIToolbar.b_renamed((android.view.ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new com.coui.appcompat.widget.toolbar.COUIToolbar.b_renamed(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.Toolbar, android.view.ViewGroup
    /* renamed from: a_renamed, reason: merged with bridge method [inline-methods] */
    public com.coui.appcompat.widget.toolbar.COUIToolbar.b_renamed generateDefaultLayoutParams() {
        return new com.coui.appcompat.widget.toolbar.COUIToolbar.b_renamed(-2, -2);
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.ViewGroup
    protected boolean checkLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return super.checkLayoutParams(layoutParams) && (layoutParams instanceof com.coui.appcompat.widget.toolbar.COUIToolbar.b_renamed);
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void inflateMenu(int i_renamed) {
        super.inflateMenu(i_renamed);
        androidx.appcompat.widget.ActionMenuView actionMenuView = this.f3107c;
        if (actionMenuView instanceof com.coui.appcompat.widget.toolbar.a_renamed) {
            ((com.coui.appcompat.widget.toolbar.a_renamed) actionMenuView).j_renamed();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setChildVisibilityForExpandedActionView(boolean z_renamed) {
        int childCount = getChildCount();
        for (int i_renamed = 0; i_renamed < childCount; i_renamed++) {
            android.view.View childAt = getChildAt(i_renamed);
            if (((com.coui.appcompat.widget.toolbar.COUIToolbar.b_renamed) childAt.getLayoutParams()).f3114c != 2 && childAt != this.f3107c) {
                childAt.setVisibility(z_renamed ? 8 : 0);
            }
        }
    }

    private void e_renamed(android.view.View view) {
        if (((com.coui.appcompat.widget.toolbar.COUIToolbar.b_renamed) view.getLayoutParams()).f3114c == 2 || view == this.f3107c) {
            return;
        }
        view.setVisibility(this.f3105a != null ? 8 : 0);
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setCollapsible(boolean z_renamed) {
        this.J_renamed = z_renamed;
        requestLayout();
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setMenuCallbacks(androidx.appcompat.view.menu.n_renamed.a_renamed aVar, androidx.appcompat.view.menu.h_renamed.a_renamed aVar2) {
        this.H_renamed = aVar;
        this.I_renamed = aVar2;
    }

    @Override // android.view.View
    public void setMinimumHeight(int i_renamed) {
        this.K_renamed = i_renamed;
        super.setMinimumHeight(i_renamed);
    }

    private int getMinimumHeightCompat() {
        if (android.os.Build.VERSION.SDK_INT >= 16) {
            return androidx.core.h_renamed.v_renamed.m_renamed(this);
        }
        return this.K_renamed;
    }

    public static class b_renamed extends androidx.appcompat.widget.Toolbar.b_renamed {

        /* renamed from: c_renamed, reason: collision with root package name */
        int f3114c;
        boolean d_renamed;

        public b_renamed(android.content.Context context, android.util.AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f3114c = 0;
            this.d_renamed = false;
        }

        public b_renamed(int i_renamed, int i2) {
            super(i_renamed, i2);
            this.f3114c = 0;
            this.d_renamed = false;
            this.f264a = 8388627;
        }

        public b_renamed(com.coui.appcompat.widget.toolbar.COUIToolbar.b_renamed bVar) {
            super((androidx.appcompat.widget.Toolbar.b_renamed) bVar);
            this.f3114c = 0;
            this.d_renamed = false;
            this.f3114c = bVar.f3114c;
        }

        public b_renamed(androidx.appcompat.app.a_renamed.ActionBar_4 c0003a) {
            super(c0003a);
            this.f3114c = 0;
            this.d_renamed = false;
        }

        public b_renamed(android.view.ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f3114c = 0;
            this.d_renamed = false;
            a_renamed(marginLayoutParams);
        }

        public b_renamed(android.view.ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f3114c = 0;
            this.d_renamed = false;
        }

        void a_renamed(android.view.ViewGroup.MarginLayoutParams marginLayoutParams) {
            this.leftMargin = marginLayoutParams.leftMargin;
            this.topMargin = marginLayoutParams.topMargin;
            this.rightMargin = marginLayoutParams.rightMargin;
            this.bottomMargin = marginLayoutParams.bottomMargin;
        }
    }

    private class a_renamed implements androidx.appcompat.view.menu.n_renamed {

        /* renamed from: a_renamed, reason: collision with root package name */
        androidx.appcompat.view.menu.h_renamed f3111a;

        /* renamed from: b_renamed, reason: collision with root package name */
        androidx.appcompat.view.menu.j_renamed f3112b;

        @Override // androidx.appcompat.view.menu.n_renamed
        public boolean flagActionItems() {
            return false;
        }

        @Override // androidx.appcompat.view.menu.n_renamed
        public int getId() {
            return 0;
        }

        @Override // androidx.appcompat.view.menu.n_renamed
        public void onCloseMenu(androidx.appcompat.view.menu.h_renamed hVar, boolean z_renamed) {
        }

        @Override // androidx.appcompat.view.menu.n_renamed
        public void onRestoreInstanceState(android.os.Parcelable parcelable) {
        }

        @Override // androidx.appcompat.view.menu.n_renamed
        public android.os.Parcelable onSaveInstanceState() {
            return null;
        }

        @Override // androidx.appcompat.view.menu.n_renamed
        public boolean onSubMenuSelected(androidx.appcompat.view.menu.s_renamed sVar) {
            return false;
        }

        @Override // androidx.appcompat.view.menu.n_renamed
        public void setCallback(androidx.appcompat.view.menu.n_renamed.a_renamed aVar) {
        }

        private a_renamed() {
        }

        @Override // androidx.appcompat.view.menu.n_renamed
        public void initForMenu(android.content.Context context, androidx.appcompat.view.menu.h_renamed hVar) {
            androidx.appcompat.view.menu.j_renamed jVar;
            androidx.appcompat.view.menu.h_renamed hVar2 = this.f3111a;
            if (hVar2 != null && (jVar = this.f3112b) != null) {
                hVar2.collapseItemActionView(jVar);
            }
            this.f3111a = hVar;
        }

        @Override // androidx.appcompat.view.menu.n_renamed
        public void updateMenuView(boolean z_renamed) {
            if (this.f3112b != null) {
                androidx.appcompat.view.menu.h_renamed hVar = this.f3111a;
                boolean z2 = false;
                if (hVar != null) {
                    int size = hVar.size();
                    int i_renamed = 0;
                    while (true) {
                        if (i_renamed >= size) {
                            break;
                        }
                        if (this.f3111a.getItem(i_renamed) == this.f3112b) {
                            z2 = true;
                            break;
                        }
                        i_renamed++;
                    }
                }
                if (z2) {
                    return;
                }
                collapseItemActionView(this.f3111a, this.f3112b);
            }
        }

        @Override // androidx.appcompat.view.menu.n_renamed
        public boolean expandItemActionView(androidx.appcompat.view.menu.h_renamed hVar, androidx.appcompat.view.menu.j_renamed jVar) {
            com.coui.appcompat.widget.toolbar.COUIToolbar.this.f_renamed();
            android.view.ViewParent parent = com.coui.appcompat.widget.toolbar.COUIToolbar.this.j_renamed.getParent();
            com.coui.appcompat.widget.toolbar.COUIToolbar cOUIToolbar = com.coui.appcompat.widget.toolbar.COUIToolbar.this;
            if (parent != cOUIToolbar) {
                cOUIToolbar.addView(cOUIToolbar.j_renamed);
            }
            com.coui.appcompat.widget.toolbar.COUIToolbar.this.f3105a = jVar.getActionView();
            this.f3112b = jVar;
            android.view.ViewParent parent2 = com.coui.appcompat.widget.toolbar.COUIToolbar.this.f3105a.getParent();
            com.coui.appcompat.widget.toolbar.COUIToolbar cOUIToolbar2 = com.coui.appcompat.widget.toolbar.COUIToolbar.this;
            if (parent2 != cOUIToolbar2) {
                com.coui.appcompat.widget.toolbar.COUIToolbar.b_renamed bVarGenerateDefaultLayoutParams = cOUIToolbar2.generateDefaultLayoutParams();
                bVarGenerateDefaultLayoutParams.f264a = 8388611 | (com.coui.appcompat.widget.toolbar.COUIToolbar.this.o_renamed & 112);
                bVarGenerateDefaultLayoutParams.f3114c = 2;
                com.coui.appcompat.widget.toolbar.COUIToolbar.this.f3105a.setLayoutParams(bVarGenerateDefaultLayoutParams);
                com.coui.appcompat.widget.toolbar.COUIToolbar cOUIToolbar3 = com.coui.appcompat.widget.toolbar.COUIToolbar.this;
                cOUIToolbar3.addView(cOUIToolbar3.f3105a);
            }
            com.coui.appcompat.widget.toolbar.COUIToolbar.this.setChildVisibilityForExpandedActionView(true);
            com.coui.appcompat.widget.toolbar.COUIToolbar.this.requestLayout();
            jVar.e_renamed(true);
            if (com.coui.appcompat.widget.toolbar.COUIToolbar.this.f3105a instanceof androidx.appcompat.view.c_renamed) {
                ((androidx.appcompat.view.c_renamed) com.coui.appcompat.widget.toolbar.COUIToolbar.this.f3105a).a_renamed();
            }
            return true;
        }

        @Override // androidx.appcompat.view.menu.n_renamed
        public boolean collapseItemActionView(androidx.appcompat.view.menu.h_renamed hVar, androidx.appcompat.view.menu.j_renamed jVar) {
            if (com.coui.appcompat.widget.toolbar.COUIToolbar.this.f3105a instanceof androidx.appcompat.view.c_renamed) {
                ((androidx.appcompat.view.c_renamed) com.coui.appcompat.widget.toolbar.COUIToolbar.this.f3105a).b_renamed();
            }
            com.coui.appcompat.widget.toolbar.COUIToolbar cOUIToolbar = com.coui.appcompat.widget.toolbar.COUIToolbar.this;
            cOUIToolbar.removeView(cOUIToolbar.f3105a);
            com.coui.appcompat.widget.toolbar.COUIToolbar cOUIToolbar2 = com.coui.appcompat.widget.toolbar.COUIToolbar.this;
            cOUIToolbar2.removeView(cOUIToolbar2.j_renamed);
            com.coui.appcompat.widget.toolbar.COUIToolbar cOUIToolbar3 = com.coui.appcompat.widget.toolbar.COUIToolbar.this;
            cOUIToolbar3.f3105a = null;
            cOUIToolbar3.setChildVisibilityForExpandedActionView(false);
            this.f3112b = null;
            com.coui.appcompat.widget.toolbar.COUIToolbar.this.requestLayout();
            jVar.e_renamed(false);
            return true;
        }
    }

    public void setIsTitleCenterStyle(boolean z_renamed) {
        d_renamed();
        this.L_renamed = z_renamed;
        com.coui.appcompat.widget.toolbar.COUIToolbar.b_renamed bVar = (com.coui.appcompat.widget.toolbar.COUIToolbar.b_renamed) this.f3107c.getLayoutParams();
        if (this.L_renamed) {
            bVar.width = -1;
        } else {
            bVar.width = -2;
        }
        this.f3107c.setLayoutParams(bVar);
        requestLayout();
    }

    public boolean getIsTitleCenterStyle() {
        return this.L_renamed;
    }

    public void setMinTitleTextSize(float f_renamed) {
        float f2 = this.W_renamed;
        if (f_renamed > f2) {
            f_renamed = f2;
        }
        this.aa_renamed = f_renamed;
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setTitleMarginStart(int i_renamed) {
        this.q_renamed = i_renamed;
        requestLayout();
    }

    @Override // androidx.appcompat.widget.Toolbar
    public boolean showOverflowMenu() {
        androidx.appcompat.widget.ActionMenuView actionMenuView = this.f3107c;
        if (actionMenuView instanceof com.coui.appcompat.widget.toolbar.a_renamed) {
            return actionMenuView.e_renamed();
        }
        return super.showOverflowMenu();
    }

    public void setPopupWindowOnDismissListener(android.widget.PopupWindow.OnDismissListener onDismissListener) {
        androidx.appcompat.widget.ActionMenuView actionMenuView = this.f3107c;
        if (actionMenuView instanceof com.coui.appcompat.widget.toolbar.a_renamed) {
            ((com.coui.appcompat.widget.toolbar.a_renamed) actionMenuView).setPopupWindowOnDismissListener(onDismissListener);
        }
    }

    public void setTitleTextViewTypeface(android.graphics.Typeface typeface) {
        this.d_renamed.setTypeface(typeface);
    }
}

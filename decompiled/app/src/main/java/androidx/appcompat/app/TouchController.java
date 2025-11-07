package androidx.appcompat.app;

/* compiled from: WindowDecorActionBar.java */
/* loaded from: classes.dex */
public class l_renamed extends androidx.appcompat.app.a_renamed implements androidx.appcompat.widget.ActionBarOverlayLayout.a_renamed {
    static final /* synthetic */ boolean s_renamed = !androidx.appcompat.app.l_renamed.class.desiredAssertionStatus();
    private static final android.view.animation.Interpolator t_renamed = new android.view.animation.AccelerateInterpolator();
    private static final android.view.animation.Interpolator u_renamed = new android.view.animation.DecelerateInterpolator();
    private boolean A_renamed;
    private boolean B_renamed;
    private boolean D_renamed;
    private boolean F_renamed;
    private boolean H_renamed;

    /* renamed from: a_renamed, reason: collision with root package name */
    android.content.Context f291a;

    /* renamed from: b_renamed, reason: collision with root package name */
    androidx.appcompat.widget.ActionBarOverlayLayout f292b;

    /* renamed from: c_renamed, reason: collision with root package name */
    androidx.appcompat.widget.ActionBarContainer f293c;
    androidx.appcompat.widget.z_renamed d_renamed;
    androidx.appcompat.widget.ActionBarContextView e_renamed;
    android.view.View f_renamed;
    androidx.appcompat.widget.ak_renamed g_renamed;
    androidx.appcompat.app.l_renamed.a_renamed h_renamed;
    androidx.appcompat.view.b_renamed i_renamed;
    androidx.appcompat.view.b_renamed.a_renamed j_renamed;
    boolean l_renamed;
    boolean m_renamed;
    androidx.appcompat.view.h_renamed n_renamed;
    boolean o_renamed;
    private android.content.Context v_renamed;
    private android.app.Activity w_renamed;
    private android.app.Dialog x_renamed;
    private java.util.ArrayList<java.lang.Object> y_renamed = new java.util.ArrayList<>();
    private int z_renamed = -1;
    private java.util.ArrayList<androidx.appcompat.app.a_renamed.b_renamed> C_renamed = new java.util.ArrayList<>();
    private int E_renamed = 0;
    boolean k_renamed = true;
    private boolean G_renamed = true;
    final androidx.core.h_renamed.aa_renamed p_renamed = new androidx.core.h_renamed.ab_renamed() { // from class: androidx.appcompat.app.l_renamed.1
        @Override // androidx.core.h_renamed.ab_renamed, androidx.core.h_renamed.aa_renamed
        public void b_renamed(android.view.View view) {
            if (androidx.appcompat.app.l_renamed.this.k_renamed && androidx.appcompat.app.l_renamed.this.f_renamed != null) {
                androidx.appcompat.app.l_renamed.this.f_renamed.setTranslationY(0.0f);
                androidx.appcompat.app.l_renamed.this.f293c.setTranslationY(0.0f);
            }
            androidx.appcompat.app.l_renamed.this.f293c.setVisibility(8);
            androidx.appcompat.app.l_renamed.this.f293c.setTransitioning(false);
            androidx.appcompat.app.l_renamed lVar = androidx.appcompat.app.l_renamed.this;
            lVar.n_renamed = null;
            lVar.h_renamed();
            if (androidx.appcompat.app.l_renamed.this.f292b != null) {
                androidx.core.h_renamed.v_renamed.s_renamed(androidx.appcompat.app.l_renamed.this.f292b);
            }
        }
    };
    final androidx.core.h_renamed.aa_renamed q_renamed = new androidx.core.h_renamed.ab_renamed() { // from class: androidx.appcompat.app.l_renamed.2
        @Override // androidx.core.h_renamed.ab_renamed, androidx.core.h_renamed.aa_renamed
        public void b_renamed(android.view.View view) {
            androidx.appcompat.app.l_renamed lVar = androidx.appcompat.app.l_renamed.this;
            lVar.n_renamed = null;
            lVar.f293c.requestLayout();
        }
    };
    final androidx.core.h_renamed.ac_renamed r_renamed = new androidx.core.h_renamed.ac_renamed() { // from class: androidx.appcompat.app.l_renamed.3
        @Override // androidx.core.h_renamed.ac_renamed
        public void a_renamed(android.view.View view) {
            ((android.view.View) androidx.appcompat.app.l_renamed.this.f293c.getParent()).invalidate();
        }
    };

    static boolean a_renamed(boolean z_renamed, boolean z2, boolean z3) {
        if (z3) {
            return true;
        }
        return (z_renamed || z2) ? false : true;
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.a_renamed
    public void m_renamed() {
    }

    public l_renamed(android.app.Activity activity, boolean z_renamed) {
        this.w_renamed = activity;
        android.view.View decorView = activity.getWindow().getDecorView();
        a_renamed(decorView);
        if (z_renamed) {
            return;
        }
        this.f_renamed = decorView.findViewById(android.R_renamed.id_renamed.content);
    }

    public l_renamed(android.app.Dialog dialog) {
        this.x_renamed = dialog;
        a_renamed(dialog.getWindow().getDecorView());
    }

    private void a_renamed(android.view.View view) {
        this.f292b = (androidx.appcompat.widget.ActionBarOverlayLayout) view.findViewById(androidx.appcompat.R_renamed.id_renamed.decor_content_parent);
        androidx.appcompat.widget.ActionBarOverlayLayout actionBarOverlayLayout = this.f292b;
        if (actionBarOverlayLayout != null) {
            actionBarOverlayLayout.setActionBarVisibilityCallback(this);
        }
        this.d_renamed = b_renamed(view.findViewById(androidx.appcompat.R_renamed.id_renamed.action_bar));
        this.e_renamed = (androidx.appcompat.widget.ActionBarContextView) view.findViewById(androidx.appcompat.R_renamed.id_renamed.action_context_bar);
        this.f293c = (androidx.appcompat.widget.ActionBarContainer) view.findViewById(androidx.appcompat.R_renamed.id_renamed.action_bar_container);
        androidx.appcompat.widget.z_renamed zVar = this.d_renamed;
        if (zVar == null || this.e_renamed == null || this.f293c == null) {
            throw new java.lang.IllegalStateException(getClass().getSimpleName() + " can only be_renamed used with a_renamed compatible window decor layout");
        }
        this.f291a = zVar.b_renamed();
        boolean z_renamed = (this.d_renamed.o_renamed() & 4) != 0;
        if (z_renamed) {
            this.A_renamed = true;
        }
        androidx.appcompat.view.a_renamed aVarA = androidx.appcompat.view.a_renamed.a_renamed(this.f291a);
        b_renamed(aVarA.f_renamed() || z_renamed);
        k_renamed(aVarA.d_renamed());
        android.content.res.TypedArray typedArrayObtainStyledAttributes = this.f291a.obtainStyledAttributes(null, androidx.appcompat.R_renamed.styleable.ActionBar, androidx.appcompat.R_renamed.attr.actionBarStyle, 0);
        if (typedArrayObtainStyledAttributes.getBoolean(androidx.appcompat.R_renamed.styleable.ActionBar_hideOnContentScroll, false)) {
            c_renamed(true);
        }
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(androidx.appcompat.R_renamed.styleable.ActionBar_elevation, 0);
        if (dimensionPixelSize != 0) {
            a_renamed(dimensionPixelSize);
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private androidx.appcompat.widget.z_renamed b_renamed(android.view.View view) {
        if (view instanceof androidx.appcompat.widget.z_renamed) {
            return (androidx.appcompat.widget.z_renamed) view;
        }
        if (view instanceof androidx.appcompat.widget.Toolbar) {
            return ((androidx.appcompat.widget.Toolbar) view).getWrapper();
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("Can't_renamed make a_renamed decor toolbar out of_renamed ");
        sb.append(view != 0 ? view.getClass().getSimpleName() : "null");
        throw new java.lang.IllegalStateException(sb.toString());
    }

    @Override // androidx.appcompat.app.a_renamed
    public void a_renamed(float f_renamed) {
        androidx.core.h_renamed.v_renamed.a_renamed(this.f293c, f_renamed);
    }

    @Override // androidx.appcompat.app.a_renamed
    public void a_renamed(android.content.res.Configuration configuration) {
        k_renamed(androidx.appcompat.view.a_renamed.a_renamed(this.f291a).d_renamed());
    }

    private void k_renamed(boolean z_renamed) {
        this.D_renamed = z_renamed;
        if (!this.D_renamed) {
            this.d_renamed.a_renamed((androidx.appcompat.widget.ak_renamed) null);
            this.f293c.setTabContainer(this.g_renamed);
        } else {
            this.f293c.setTabContainer(null);
            this.d_renamed.a_renamed(this.g_renamed);
        }
        boolean z2 = i_renamed() == 2;
        androidx.appcompat.widget.ak_renamed akVar = this.g_renamed;
        if (akVar != null) {
            if (z2) {
                akVar.setVisibility(0);
                androidx.appcompat.widget.ActionBarOverlayLayout actionBarOverlayLayout = this.f292b;
                if (actionBarOverlayLayout != null) {
                    androidx.core.h_renamed.v_renamed.s_renamed(actionBarOverlayLayout);
                }
            } else {
                akVar.setVisibility(8);
            }
        }
        this.d_renamed.a_renamed(!this.D_renamed && z2);
        this.f292b.setHasNonEmbeddedTabs(!this.D_renamed && z2);
    }

    void h_renamed() {
        androidx.appcompat.view.b_renamed.a_renamed aVar = this.j_renamed;
        if (aVar != null) {
            aVar.a_renamed(this.i_renamed);
            this.i_renamed = null;
            this.j_renamed = null;
        }
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.a_renamed
    public void a_renamed(int i_renamed) {
        this.E_renamed = i_renamed;
    }

    @Override // androidx.appcompat.app.a_renamed
    public void e_renamed(boolean z_renamed) {
        androidx.appcompat.view.h_renamed hVar;
        this.H_renamed = z_renamed;
        if (z_renamed || (hVar = this.n_renamed) == null) {
            return;
        }
        hVar.c_renamed();
    }

    @Override // androidx.appcompat.app.a_renamed
    public void f_renamed(boolean z_renamed) {
        if (z_renamed == this.B_renamed) {
            return;
        }
        this.B_renamed = z_renamed;
        int size = this.C_renamed.size();
        for (int i_renamed = 0; i_renamed < size; i_renamed++) {
            this.C_renamed.get(i_renamed).a_renamed(z_renamed);
        }
    }

    @Override // androidx.appcompat.app.a_renamed
    public void a_renamed(boolean z_renamed) {
        a_renamed(z_renamed ? 4 : 0, 4);
    }

    @Override // androidx.appcompat.app.a_renamed
    public void b_renamed(boolean z_renamed) {
        this.d_renamed.b_renamed(z_renamed);
    }

    @Override // androidx.appcompat.app.a_renamed
    public void a_renamed(java.lang.CharSequence charSequence) {
        this.d_renamed.a_renamed(charSequence);
    }

    public void a_renamed(int i_renamed, int i2) {
        int iO = this.d_renamed.o_renamed();
        if ((i2 & 4) != 0) {
            this.A_renamed = true;
        }
        this.d_renamed.c_renamed((i_renamed & i2) | ((~i2) & iO));
    }

    public int i_renamed() {
        return this.d_renamed.p_renamed();
    }

    @Override // androidx.appcompat.app.a_renamed
    public int a_renamed() {
        return this.d_renamed.o_renamed();
    }

    @Override // androidx.appcompat.app.a_renamed
    public androidx.appcompat.view.b_renamed a_renamed(androidx.appcompat.view.b_renamed.a_renamed aVar) {
        androidx.appcompat.app.l_renamed.a_renamed aVar2 = this.h_renamed;
        if (aVar2 != null) {
            aVar2.c_renamed();
        }
        this.f292b.setHideOnContentScrollEnabled(false);
        this.e_renamed.c_renamed();
        androidx.appcompat.app.l_renamed.a_renamed aVar3 = new androidx.appcompat.app.l_renamed.a_renamed(this.e_renamed.getContext(), aVar);
        if (!aVar3.e_renamed()) {
            return null;
        }
        this.h_renamed = aVar3;
        aVar3.d_renamed();
        this.e_renamed.a_renamed(aVar3);
        j_renamed(true);
        this.e_renamed.sendAccessibilityEvent(32);
        return aVar3;
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.a_renamed
    public void g_renamed(boolean z_renamed) {
        this.k_renamed = z_renamed;
    }

    private void n_renamed() {
        if (this.F_renamed) {
            return;
        }
        this.F_renamed = true;
        androidx.appcompat.widget.ActionBarOverlayLayout actionBarOverlayLayout = this.f292b;
        if (actionBarOverlayLayout != null) {
            actionBarOverlayLayout.setShowingForActionMode(true);
        }
        l_renamed(false);
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.a_renamed
    public void j_renamed() {
        if (this.m_renamed) {
            this.m_renamed = false;
            l_renamed(true);
        }
    }

    private void o_renamed() {
        if (this.F_renamed) {
            this.F_renamed = false;
            androidx.appcompat.widget.ActionBarOverlayLayout actionBarOverlayLayout = this.f292b;
            if (actionBarOverlayLayout != null) {
                actionBarOverlayLayout.setShowingForActionMode(false);
            }
            l_renamed(false);
        }
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.a_renamed
    public void k_renamed() {
        if (this.m_renamed) {
            return;
        }
        this.m_renamed = true;
        l_renamed(true);
    }

    @Override // androidx.appcompat.app.a_renamed
    public void c_renamed(boolean z_renamed) {
        if (z_renamed && !this.f292b.a_renamed()) {
            throw new java.lang.IllegalStateException("Action bar must be_renamed in_renamed overlay mode (Window.FEATURE_OVERLAY_ACTION_BAR) to enable hide on_renamed content scroll");
        }
        this.o_renamed = z_renamed;
        this.f292b.setHideOnContentScrollEnabled(z_renamed);
    }

    private void l_renamed(boolean z_renamed) {
        if (a_renamed(this.l_renamed, this.m_renamed, this.F_renamed)) {
            if (this.G_renamed) {
                return;
            }
            this.G_renamed = true;
            h_renamed(z_renamed);
            return;
        }
        if (this.G_renamed) {
            this.G_renamed = false;
            i_renamed(z_renamed);
        }
    }

    public void h_renamed(boolean z_renamed) {
        android.view.View view;
        android.view.View view2;
        androidx.appcompat.view.h_renamed hVar = this.n_renamed;
        if (hVar != null) {
            hVar.c_renamed();
        }
        this.f293c.setVisibility(0);
        if (this.E_renamed == 0 && (this.H_renamed || z_renamed)) {
            this.f293c.setTranslationY(0.0f);
            float f_renamed = -this.f293c.getHeight();
            if (z_renamed) {
                this.f293c.getLocationInWindow(new int[]{0, 0});
                f_renamed -= r5[1];
            }
            this.f293c.setTranslationY(f_renamed);
            androidx.appcompat.view.h_renamed hVar2 = new androidx.appcompat.view.h_renamed();
            androidx.core.h_renamed.z_renamed zVarB = androidx.core.h_renamed.v_renamed.n_renamed(this.f293c).b_renamed(0.0f);
            zVarB.a_renamed(this.r_renamed);
            hVar2.a_renamed(zVarB);
            if (this.k_renamed && (view2 = this.f_renamed) != null) {
                view2.setTranslationY(f_renamed);
                hVar2.a_renamed(androidx.core.h_renamed.v_renamed.n_renamed(this.f_renamed).b_renamed(0.0f));
            }
            hVar2.a_renamed(u_renamed);
            hVar2.a_renamed(250L);
            hVar2.a_renamed(this.q_renamed);
            this.n_renamed = hVar2;
            hVar2.a_renamed();
        } else {
            this.f293c.setAlpha(1.0f);
            this.f293c.setTranslationY(0.0f);
            if (this.k_renamed && (view = this.f_renamed) != null) {
                view.setTranslationY(0.0f);
            }
            this.q_renamed.b_renamed(null);
        }
        androidx.appcompat.widget.ActionBarOverlayLayout actionBarOverlayLayout = this.f292b;
        if (actionBarOverlayLayout != null) {
            androidx.core.h_renamed.v_renamed.s_renamed(actionBarOverlayLayout);
        }
    }

    public void i_renamed(boolean z_renamed) {
        android.view.View view;
        androidx.appcompat.view.h_renamed hVar = this.n_renamed;
        if (hVar != null) {
            hVar.c_renamed();
        }
        if (this.E_renamed == 0 && (this.H_renamed || z_renamed)) {
            this.f293c.setAlpha(1.0f);
            this.f293c.setTransitioning(true);
            androidx.appcompat.view.h_renamed hVar2 = new androidx.appcompat.view.h_renamed();
            float f_renamed = -this.f293c.getHeight();
            if (z_renamed) {
                this.f293c.getLocationInWindow(new int[]{0, 0});
                f_renamed -= r5[1];
            }
            androidx.core.h_renamed.z_renamed zVarB = androidx.core.h_renamed.v_renamed.n_renamed(this.f293c).b_renamed(f_renamed);
            zVarB.a_renamed(this.r_renamed);
            hVar2.a_renamed(zVarB);
            if (this.k_renamed && (view = this.f_renamed) != null) {
                hVar2.a_renamed(androidx.core.h_renamed.v_renamed.n_renamed(view).b_renamed(f_renamed));
            }
            hVar2.a_renamed(t_renamed);
            hVar2.a_renamed(250L);
            hVar2.a_renamed(this.p_renamed);
            this.n_renamed = hVar2;
            hVar2.a_renamed();
            return;
        }
        this.p_renamed.b_renamed(null);
    }

    public void j_renamed(boolean z_renamed) {
        androidx.core.h_renamed.z_renamed zVarA;
        androidx.core.h_renamed.z_renamed zVarA2;
        if (z_renamed) {
            n_renamed();
        } else {
            o_renamed();
        }
        if (!p_renamed()) {
            if (z_renamed) {
                this.d_renamed.d_renamed(4);
                this.e_renamed.setVisibility(0);
                return;
            } else {
                this.d_renamed.d_renamed(0);
                this.e_renamed.setVisibility(8);
                return;
            }
        }
        if (z_renamed) {
            androidx.core.h_renamed.z_renamed zVarA3 = this.d_renamed.a_renamed(4, 100L);
            zVarA = this.e_renamed.a_renamed(0, 200L);
            zVarA2 = zVarA3;
        } else {
            zVarA = this.d_renamed.a_renamed(0, 200L);
            zVarA2 = this.e_renamed.a_renamed(8, 100L);
        }
        androidx.appcompat.view.h_renamed hVar = new androidx.appcompat.view.h_renamed();
        hVar.a_renamed(zVarA2, zVarA);
        hVar.a_renamed();
    }

    private boolean p_renamed() {
        return androidx.core.h_renamed.v_renamed.A_renamed(this.f293c);
    }

    @Override // androidx.appcompat.app.a_renamed
    public android.content.Context b_renamed() {
        if (this.v_renamed == null) {
            android.util.TypedValue typedValue = new android.util.TypedValue();
            this.f291a.getTheme().resolveAttribute(androidx.appcompat.R_renamed.attr.actionBarWidgetTheme, typedValue, true);
            int i_renamed = typedValue.resourceId;
            if (i_renamed != 0) {
                this.v_renamed = new android.view.ContextThemeWrapper(this.f291a, i_renamed);
            } else {
                this.v_renamed = this.f291a;
            }
        }
        return this.v_renamed;
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.a_renamed
    public void l_renamed() {
        androidx.appcompat.view.h_renamed hVar = this.n_renamed;
        if (hVar != null) {
            hVar.c_renamed();
            this.n_renamed = null;
        }
    }

    @Override // androidx.appcompat.app.a_renamed
    public boolean f_renamed() {
        androidx.appcompat.widget.z_renamed zVar = this.d_renamed;
        if (zVar == null || !zVar.c_renamed()) {
            return false;
        }
        this.d_renamed.d_renamed();
        return true;
    }

    /* compiled from: WindowDecorActionBar.java */
    public class a_renamed extends androidx.appcompat.view.b_renamed implements androidx.appcompat.view.menu.h_renamed.a_renamed {

        /* renamed from: b_renamed, reason: collision with root package name */
        private final android.content.Context f298b;

        /* renamed from: c_renamed, reason: collision with root package name */
        private final androidx.appcompat.view.menu.h_renamed f299c;
        private androidx.appcompat.view.b_renamed.a_renamed d_renamed;
        private java.lang.ref.WeakReference<android.view.View> e_renamed;

        public a_renamed(android.content.Context context, androidx.appcompat.view.b_renamed.a_renamed aVar) {
            this.f298b = context;
            this.d_renamed = aVar;
            this.f299c = new androidx.appcompat.view.menu.h_renamed(context).setDefaultShowAsAction(1);
            this.f299c.setCallback(this);
        }

        @Override // androidx.appcompat.view.b_renamed
        public android.view.MenuInflater a_renamed() {
            return new androidx.appcompat.view.g_renamed(this.f298b);
        }

        @Override // androidx.appcompat.view.b_renamed
        public android.view.Menu b_renamed() {
            return this.f299c;
        }

        @Override // androidx.appcompat.view.b_renamed
        public void c_renamed() {
            if (androidx.appcompat.app.l_renamed.this.h_renamed != this) {
                return;
            }
            if (!androidx.appcompat.app.l_renamed.a_renamed(androidx.appcompat.app.l_renamed.this.l_renamed, androidx.appcompat.app.l_renamed.this.m_renamed, false)) {
                androidx.appcompat.app.l_renamed lVar = androidx.appcompat.app.l_renamed.this;
                lVar.i_renamed = this;
                lVar.j_renamed = this.d_renamed;
            } else {
                this.d_renamed.a_renamed(this);
            }
            this.d_renamed = null;
            androidx.appcompat.app.l_renamed.this.j_renamed(false);
            androidx.appcompat.app.l_renamed.this.e_renamed.b_renamed();
            androidx.appcompat.app.l_renamed.this.d_renamed.a_renamed().sendAccessibilityEvent(32);
            androidx.appcompat.app.l_renamed.this.f292b.setHideOnContentScrollEnabled(androidx.appcompat.app.l_renamed.this.o_renamed);
            androidx.appcompat.app.l_renamed.this.h_renamed = null;
        }

        @Override // androidx.appcompat.view.b_renamed
        public void d_renamed() {
            if (androidx.appcompat.app.l_renamed.this.h_renamed != this) {
                return;
            }
            this.f299c.stopDispatchingItemsChanged();
            try {
                this.d_renamed.b_renamed(this, this.f299c);
            } finally {
                this.f299c.startDispatchingItemsChanged();
            }
        }

        public boolean e_renamed() {
            this.f299c.stopDispatchingItemsChanged();
            try {
                return this.d_renamed.a_renamed(this, this.f299c);
            } finally {
                this.f299c.startDispatchingItemsChanged();
            }
        }

        @Override // androidx.appcompat.view.b_renamed
        public void a_renamed(android.view.View view) {
            androidx.appcompat.app.l_renamed.this.e_renamed.setCustomView(view);
            this.e_renamed = new java.lang.ref.WeakReference<>(view);
        }

        @Override // androidx.appcompat.view.b_renamed
        public void a_renamed(java.lang.CharSequence charSequence) {
            androidx.appcompat.app.l_renamed.this.e_renamed.setSubtitle(charSequence);
        }

        @Override // androidx.appcompat.view.b_renamed
        public void b_renamed(java.lang.CharSequence charSequence) {
            androidx.appcompat.app.l_renamed.this.e_renamed.setTitle(charSequence);
        }

        @Override // androidx.appcompat.view.b_renamed
        public void a_renamed(int i_renamed) {
            b_renamed(androidx.appcompat.app.l_renamed.this.f291a.getResources().getString(i_renamed));
        }

        @Override // androidx.appcompat.view.b_renamed
        public void b_renamed(int i_renamed) {
            a_renamed((java.lang.CharSequence) androidx.appcompat.app.l_renamed.this.f291a.getResources().getString(i_renamed));
        }

        @Override // androidx.appcompat.view.b_renamed
        public java.lang.CharSequence f_renamed() {
            return androidx.appcompat.app.l_renamed.this.e_renamed.getTitle();
        }

        @Override // androidx.appcompat.view.b_renamed
        public java.lang.CharSequence g_renamed() {
            return androidx.appcompat.app.l_renamed.this.e_renamed.getSubtitle();
        }

        @Override // androidx.appcompat.view.b_renamed
        public void a_renamed(boolean z_renamed) {
            super.a_renamed(z_renamed);
            androidx.appcompat.app.l_renamed.this.e_renamed.setTitleOptional(z_renamed);
        }

        @Override // androidx.appcompat.view.b_renamed
        public boolean h_renamed() {
            return androidx.appcompat.app.l_renamed.this.e_renamed.d_renamed();
        }

        @Override // androidx.appcompat.view.b_renamed
        public android.view.View i_renamed() {
            java.lang.ref.WeakReference<android.view.View> weakReference = this.e_renamed;
            if (weakReference != null) {
                return weakReference.get();
            }
            return null;
        }

        @Override // androidx.appcompat.view.menu.h_renamed.a_renamed
        public boolean onMenuItemSelected(androidx.appcompat.view.menu.h_renamed hVar, android.view.MenuItem menuItem) {
            androidx.appcompat.view.b_renamed.a_renamed aVar = this.d_renamed;
            if (aVar != null) {
                return aVar.a_renamed(this, menuItem);
            }
            return false;
        }

        @Override // androidx.appcompat.view.menu.h_renamed.a_renamed
        public void onMenuModeChange(androidx.appcompat.view.menu.h_renamed hVar) {
            if (this.d_renamed == null) {
                return;
            }
            d_renamed();
            androidx.appcompat.app.l_renamed.this.e_renamed.a_renamed();
        }
    }

    @Override // androidx.appcompat.app.a_renamed
    public void d_renamed(boolean z_renamed) {
        if (this.A_renamed) {
            return;
        }
        a_renamed(z_renamed);
    }

    @Override // androidx.appcompat.app.a_renamed
    public boolean a_renamed(int i_renamed, android.view.KeyEvent keyEvent) {
        android.view.Menu menuB;
        androidx.appcompat.app.l_renamed.a_renamed aVar = this.h_renamed;
        if (aVar == null || (menuB = aVar.b_renamed()) == null) {
            return false;
        }
        menuB.setQwertyMode(android.view.KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() != 1);
        return menuB.performShortcut(i_renamed, keyEvent, 0);
    }
}

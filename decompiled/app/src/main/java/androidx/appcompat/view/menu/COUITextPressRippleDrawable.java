package androidx.appcompat.view.menu;

/* compiled from: StandardMenuPopup.java */
/* loaded from: classes.dex */
final class r_renamed extends androidx.appcompat.view.menu.l_renamed implements android.view.View.OnKeyListener, android.widget.AdapterView.OnItemClickListener, android.widget.PopupWindow.OnDismissListener, androidx.appcompat.view.menu.n_renamed {
    private static final int e_renamed = androidx.appcompat.R_renamed.layout.abc_popup_menu_item_layout;

    /* renamed from: a_renamed, reason: collision with root package name */
    final androidx.appcompat.widget.ag_renamed f413a;

    /* renamed from: c_renamed, reason: collision with root package name */
    android.view.View f415c;
    android.view.ViewTreeObserver d_renamed;
    private final android.content.Context f_renamed;
    private final androidx.appcompat.view.menu.h_renamed g_renamed;
    private final androidx.appcompat.view.menu.g_renamed h_renamed;
    private final boolean i_renamed;
    private final int j_renamed;
    private final int k_renamed;
    private final int l_renamed;
    private android.widget.PopupWindow.OnDismissListener n_renamed;
    private android.view.View o_renamed;
    private androidx.appcompat.view.menu.n_renamed.a_renamed p_renamed;
    private boolean q_renamed;
    private boolean r_renamed;
    private int s_renamed;
    private boolean u_renamed;

    /* renamed from: b_renamed, reason: collision with root package name */
    final android.view.ViewTreeObserver.OnGlobalLayoutListener f414b = new android.view.ViewTreeObserver.OnGlobalLayoutListener() { // from class: androidx.appcompat.view.menu.r_renamed.1
        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (!androidx.appcompat.view.menu.r_renamed.this.c_renamed() || androidx.appcompat.view.menu.r_renamed.this.f413a.i_renamed()) {
                return;
            }
            android.view.View view = androidx.appcompat.view.menu.r_renamed.this.f415c;
            if (view == null || !view.isShown()) {
                androidx.appcompat.view.menu.r_renamed.this.b_renamed();
            } else {
                androidx.appcompat.view.menu.r_renamed.this.f413a.a__renamed();
            }
        }
    };
    private final android.view.View.OnAttachStateChangeListener m_renamed = new android.view.View.OnAttachStateChangeListener() { // from class: androidx.appcompat.view.menu.r_renamed.2
        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(android.view.View view) {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(android.view.View view) {
            if (androidx.appcompat.view.menu.r_renamed.this.d_renamed != null) {
                if (!androidx.appcompat.view.menu.r_renamed.this.d_renamed.isAlive()) {
                    androidx.appcompat.view.menu.r_renamed.this.d_renamed = view.getViewTreeObserver();
                }
                androidx.appcompat.view.menu.r_renamed.this.d_renamed.removeGlobalOnLayoutListener(androidx.appcompat.view.menu.r_renamed.this.f414b);
            }
            view.removeOnAttachStateChangeListener(this);
        }
    };
    private int t_renamed = 0;

    @Override // androidx.appcompat.view.menu.l_renamed
    public void a_renamed(androidx.appcompat.view.menu.h_renamed hVar) {
    }

    @Override // androidx.appcompat.view.menu.n_renamed
    public boolean flagActionItems() {
        return false;
    }

    @Override // androidx.appcompat.view.menu.n_renamed
    public void onRestoreInstanceState(android.os.Parcelable parcelable) {
    }

    @Override // androidx.appcompat.view.menu.n_renamed
    public android.os.Parcelable onSaveInstanceState() {
        return null;
    }

    public r_renamed(android.content.Context context, androidx.appcompat.view.menu.h_renamed hVar, android.view.View view, int i_renamed, int i2, boolean z_renamed) {
        this.f_renamed = context;
        this.g_renamed = hVar;
        this.i_renamed = z_renamed;
        this.h_renamed = new androidx.appcompat.view.menu.g_renamed(hVar, android.view.LayoutInflater.from(context), this.i_renamed, e_renamed);
        this.k_renamed = i_renamed;
        this.l_renamed = i2;
        android.content.res.Resources resources = context.getResources();
        this.j_renamed = java.lang.Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(androidx.appcompat.R_renamed.dimen.abc_config_prefDialogWidth));
        this.o_renamed = view;
        this.f413a = new androidx.appcompat.widget.ag_renamed(this.f_renamed, null, this.k_renamed, this.l_renamed);
        hVar.addMenuPresenter(this, context);
    }

    @Override // androidx.appcompat.view.menu.l_renamed
    public void a_renamed(boolean z_renamed) {
        this.h_renamed.a_renamed(z_renamed);
    }

    @Override // androidx.appcompat.view.menu.l_renamed
    public void a_renamed(int i_renamed) {
        this.t_renamed = i_renamed;
    }

    private boolean g_renamed() {
        android.view.View view;
        if (c_renamed()) {
            return true;
        }
        if (this.q_renamed || (view = this.o_renamed) == null) {
            return false;
        }
        this.f415c = view;
        this.f413a.a_renamed((android.widget.PopupWindow.OnDismissListener) this);
        this.f413a.a_renamed((android.widget.AdapterView.OnItemClickListener) this);
        this.f413a.a_renamed(true);
        android.view.View view2 = this.f415c;
        boolean z_renamed = this.d_renamed == null;
        this.d_renamed = view2.getViewTreeObserver();
        if (z_renamed) {
            this.d_renamed.addOnGlobalLayoutListener(this.f414b);
        }
        view2.addOnAttachStateChangeListener(this.m_renamed);
        this.f413a.b_renamed(view2);
        this.f413a.f_renamed(this.t_renamed);
        if (!this.r_renamed) {
            this.s_renamed = a_renamed(this.h_renamed, null, this.f_renamed, this.j_renamed);
            this.r_renamed = true;
        }
        this.f413a.h_renamed(this.s_renamed);
        this.f413a.i_renamed(2);
        this.f413a.a_renamed(f_renamed());
        this.f413a.a__renamed();
        android.widget.ListView listViewB_ = this.f413a.b__renamed();
        listViewB_.setOnKeyListener(this);
        if (this.u_renamed && this.g_renamed.getHeaderTitle() != null) {
            android.widget.FrameLayout frameLayout = (android.widget.FrameLayout) android.view.LayoutInflater.from(this.f_renamed).inflate(androidx.appcompat.R_renamed.layout.abc_popup_menu_header_item_layout, (android.view.ViewGroup) listViewB_, false);
            android.widget.TextView textView = (android.widget.TextView) frameLayout.findViewById(android.R_renamed.id_renamed.title);
            if (textView != null) {
                textView.setText(this.g_renamed.getHeaderTitle());
            }
            frameLayout.setEnabled(false);
            listViewB_.addHeaderView(frameLayout, null, false);
        }
        this.f413a.a_renamed((android.widget.ListAdapter) this.h_renamed);
        this.f413a.a__renamed();
        return true;
    }

    @Override // androidx.appcompat.view.menu.q_renamed
    public void a__renamed() {
        if (!g_renamed()) {
            throw new java.lang.IllegalStateException("StandardMenuPopup cannot be_renamed used without an_renamed anchor");
        }
    }

    @Override // androidx.appcompat.view.menu.q_renamed
    public void b_renamed() {
        if (c_renamed()) {
            this.f413a.b_renamed();
        }
    }

    @Override // androidx.appcompat.view.menu.q_renamed
    public boolean c_renamed() {
        return !this.q_renamed && this.f413a.c_renamed();
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        this.q_renamed = true;
        this.g_renamed.close();
        android.view.ViewTreeObserver viewTreeObserver = this.d_renamed;
        if (viewTreeObserver != null) {
            if (!viewTreeObserver.isAlive()) {
                this.d_renamed = this.f415c.getViewTreeObserver();
            }
            this.d_renamed.removeGlobalOnLayoutListener(this.f414b);
            this.d_renamed = null;
        }
        this.f415c.removeOnAttachStateChangeListener(this.m_renamed);
        android.widget.PopupWindow.OnDismissListener onDismissListener = this.n_renamed;
        if (onDismissListener != null) {
            onDismissListener.onDismiss();
        }
    }

    @Override // androidx.appcompat.view.menu.n_renamed
    public void updateMenuView(boolean z_renamed) {
        this.r_renamed = false;
        androidx.appcompat.view.menu.g_renamed gVar = this.h_renamed;
        if (gVar != null) {
            gVar.notifyDataSetChanged();
        }
    }

    @Override // androidx.appcompat.view.menu.n_renamed
    public void setCallback(androidx.appcompat.view.menu.n_renamed.a_renamed aVar) {
        this.p_renamed = aVar;
    }

    @Override // androidx.appcompat.view.menu.n_renamed
    public boolean onSubMenuSelected(androidx.appcompat.view.menu.s_renamed sVar) {
        if (sVar.hasVisibleItems()) {
            androidx.appcompat.view.menu.m_renamed mVar = new androidx.appcompat.view.menu.m_renamed(this.f_renamed, sVar, this.f415c, this.i_renamed, this.k_renamed, this.l_renamed);
            mVar.a_renamed(this.p_renamed);
            mVar.a_renamed(androidx.appcompat.view.menu.l_renamed.b_renamed(sVar));
            mVar.a_renamed(this.n_renamed);
            this.n_renamed = null;
            this.g_renamed.close(false);
            int iF = this.f413a.f_renamed();
            int iE = this.f413a.e_renamed();
            if ((android.view.Gravity.getAbsoluteGravity(this.t_renamed, androidx.core.h_renamed.v_renamed.g_renamed(this.o_renamed)) & 7) == 5) {
                iF += this.o_renamed.getWidth();
            }
            if (mVar.a_renamed(iF, iE)) {
                androidx.appcompat.view.menu.n_renamed.a_renamed aVar = this.p_renamed;
                if (aVar == null) {
                    return true;
                }
                aVar.a_renamed(sVar);
                return true;
            }
        }
        return false;
    }

    @Override // androidx.appcompat.view.menu.n_renamed
    public void onCloseMenu(androidx.appcompat.view.menu.h_renamed hVar, boolean z_renamed) {
        if (hVar != this.g_renamed) {
            return;
        }
        b_renamed();
        androidx.appcompat.view.menu.n_renamed.a_renamed aVar = this.p_renamed;
        if (aVar != null) {
            aVar.a_renamed(hVar, z_renamed);
        }
    }

    @Override // androidx.appcompat.view.menu.l_renamed
    public void a_renamed(android.view.View view) {
        this.o_renamed = view;
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(android.view.View view, int i_renamed, android.view.KeyEvent keyEvent) {
        if (keyEvent.getAction() != 1 || i_renamed != 82) {
            return false;
        }
        b_renamed();
        return true;
    }

    @Override // androidx.appcompat.view.menu.l_renamed
    public void a_renamed(android.widget.PopupWindow.OnDismissListener onDismissListener) {
        this.n_renamed = onDismissListener;
    }

    @Override // androidx.appcompat.view.menu.q_renamed
    public android.widget.ListView b__renamed() {
        return this.f413a.b__renamed();
    }

    @Override // androidx.appcompat.view.menu.l_renamed
    public void b_renamed(int i_renamed) {
        this.f413a.b_renamed(i_renamed);
    }

    @Override // androidx.appcompat.view.menu.l_renamed
    public void c_renamed(int i_renamed) {
        this.f413a.a_renamed(i_renamed);
    }

    @Override // androidx.appcompat.view.menu.l_renamed
    public void b_renamed(boolean z_renamed) {
        this.u_renamed = z_renamed;
    }
}

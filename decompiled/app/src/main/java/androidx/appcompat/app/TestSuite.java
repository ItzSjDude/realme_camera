package androidx.appcompat.app;

/* compiled from: ToolbarActionBar.java */
/* loaded from: classes.dex */
class i_renamed extends androidx.appcompat.app.a_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    androidx.appcompat.widget.z_renamed f273a;

    /* renamed from: b_renamed, reason: collision with root package name */
    boolean f274b;

    /* renamed from: c_renamed, reason: collision with root package name */
    android.view.Window.Callback f275c;
    private boolean d_renamed;
    private boolean e_renamed;
    private java.util.ArrayList<androidx.appcompat.app.a_renamed.b_renamed> f_renamed = new java.util.ArrayList<>();
    private final java.lang.Runnable g_renamed = new java.lang.Runnable() { // from class: androidx.appcompat.app.i_renamed.1
        @Override // java.lang.Runnable
        public void run() {
            androidx.appcompat.app.i_renamed.this.i_renamed();
        }
    };
    private final androidx.appcompat.widget.Toolbar.c_renamed h_renamed = new androidx.appcompat.widget.Toolbar.c_renamed() { // from class: androidx.appcompat.app.i_renamed.2
        @Override // androidx.appcompat.widget.Toolbar.c_renamed
        public boolean a_renamed(android.view.MenuItem menuItem) {
            return androidx.appcompat.app.i_renamed.this.f275c.onMenuItemSelected(0, menuItem);
        }
    };

    @Override // androidx.appcompat.app.a_renamed
    public void b_renamed(boolean z_renamed) {
    }

    @Override // androidx.appcompat.app.a_renamed
    public void d_renamed(boolean z_renamed) {
    }

    @Override // androidx.appcompat.app.a_renamed
    public void e_renamed(boolean z_renamed) {
    }

    i_renamed(androidx.appcompat.widget.Toolbar toolbar, java.lang.CharSequence charSequence, android.view.Window.Callback callback) {
        this.f273a = new androidx.appcompat.widget.as_renamed(toolbar, false);
        this.f275c = new androidx.appcompat.app.i_renamed.c_renamed(callback);
        this.f273a.a_renamed(this.f275c);
        toolbar.setOnMenuItemClickListener(this.h_renamed);
        this.f273a.a_renamed(charSequence);
    }

    public android.view.Window.Callback h_renamed() {
        return this.f275c;
    }

    @Override // androidx.appcompat.app.a_renamed
    public void a_renamed(float f_renamed) {
        androidx.core.h_renamed.v_renamed.a_renamed(this.f273a.a_renamed(), f_renamed);
    }

    @Override // androidx.appcompat.app.a_renamed
    public android.content.Context b_renamed() {
        return this.f273a.b_renamed();
    }

    @Override // androidx.appcompat.app.a_renamed
    public void a_renamed(android.content.res.Configuration configuration) {
        super.a_renamed(configuration);
    }

    @Override // androidx.appcompat.app.a_renamed
    public void a_renamed(java.lang.CharSequence charSequence) {
        this.f273a.a_renamed(charSequence);
    }

    public void a_renamed(int i_renamed, int i2) {
        this.f273a.c_renamed((i_renamed & i2) | ((~i2) & this.f273a.o_renamed()));
    }

    @Override // androidx.appcompat.app.a_renamed
    public void a_renamed(boolean z_renamed) {
        a_renamed(z_renamed ? 4 : 0, 4);
    }

    @Override // androidx.appcompat.app.a_renamed
    public int a_renamed() {
        return this.f273a.o_renamed();
    }

    @Override // androidx.appcompat.app.a_renamed
    public boolean c_renamed() {
        return this.f273a.k_renamed();
    }

    @Override // androidx.appcompat.app.a_renamed
    public boolean d_renamed() {
        return this.f273a.l_renamed();
    }

    @Override // androidx.appcompat.app.a_renamed
    public boolean e_renamed() {
        this.f273a.a_renamed().removeCallbacks(this.g_renamed);
        androidx.core.h_renamed.v_renamed.a_renamed(this.f273a.a_renamed(), this.g_renamed);
        return true;
    }

    @Override // androidx.appcompat.app.a_renamed
    public boolean f_renamed() {
        if (!this.f273a.c_renamed()) {
            return false;
        }
        this.f273a.d_renamed();
        return true;
    }

    void i_renamed() {
        android.view.Menu menuJ = j_renamed();
        androidx.appcompat.view.menu.h_renamed hVar = menuJ instanceof androidx.appcompat.view.menu.h_renamed ? (androidx.appcompat.view.menu.h_renamed) menuJ : null;
        if (hVar != null) {
            hVar.stopDispatchingItemsChanged();
        }
        try {
            menuJ.clear();
            if (!this.f275c.onCreatePanelMenu(0, menuJ) || !this.f275c.onPreparePanel(0, null, menuJ)) {
                menuJ.clear();
            }
        } finally {
            if (hVar != null) {
                hVar.startDispatchingItemsChanged();
            }
        }
    }

    @Override // androidx.appcompat.app.a_renamed
    public boolean a_renamed(android.view.KeyEvent keyEvent) {
        if (keyEvent.getAction() == 1) {
            c_renamed();
        }
        return true;
    }

    @Override // androidx.appcompat.app.a_renamed
    public boolean a_renamed(int i_renamed, android.view.KeyEvent keyEvent) {
        android.view.Menu menuJ = j_renamed();
        if (menuJ == null) {
            return false;
        }
        menuJ.setQwertyMode(android.view.KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() != 1);
        return menuJ.performShortcut(i_renamed, keyEvent, 0);
    }

    @Override // androidx.appcompat.app.a_renamed
    void g_renamed() {
        this.f273a.a_renamed().removeCallbacks(this.g_renamed);
    }

    @Override // androidx.appcompat.app.a_renamed
    public void f_renamed(boolean z_renamed) {
        if (z_renamed == this.e_renamed) {
            return;
        }
        this.e_renamed = z_renamed;
        int size = this.f_renamed.size();
        for (int i_renamed = 0; i_renamed < size; i_renamed++) {
            this.f_renamed.get(i_renamed).a_renamed(z_renamed);
        }
    }

    /* compiled from: ToolbarActionBar.java */
    private class c_renamed extends androidx.appcompat.view.i_renamed {
        public c_renamed(android.view.Window.Callback callback) {
            super(callback);
        }

        @Override // androidx.appcompat.view.i_renamed, android.view.Window.Callback
        public boolean onPreparePanel(int i_renamed, android.view.View view, android.view.Menu menu) {
            boolean zOnPreparePanel = super.onPreparePanel(i_renamed, view, menu);
            if (zOnPreparePanel && !androidx.appcompat.app.i_renamed.this.f274b) {
                androidx.appcompat.app.i_renamed.this.f273a.m_renamed();
                androidx.appcompat.app.i_renamed.this.f274b = true;
            }
            return zOnPreparePanel;
        }

        @Override // androidx.appcompat.view.i_renamed, android.view.Window.Callback
        public android.view.View onCreatePanelView(int i_renamed) {
            if (i_renamed == 0) {
                return new android.view.View(androidx.appcompat.app.i_renamed.this.f273a.b_renamed());
            }
            return super.onCreatePanelView(i_renamed);
        }
    }

    private android.view.Menu j_renamed() {
        if (!this.d_renamed) {
            this.f273a.a_renamed(new androidx.appcompat.app.i_renamed.a_renamed(), new androidx.appcompat.app.i_renamed.b_renamed());
            this.d_renamed = true;
        }
        return this.f273a.q_renamed();
    }

    /* compiled from: ToolbarActionBar.java */
    private final class a_renamed implements androidx.appcompat.view.menu.n_renamed.a_renamed {

        /* renamed from: b_renamed, reason: collision with root package name */
        private boolean f279b;

        a_renamed() {
        }

        @Override // androidx.appcompat.view.menu.n_renamed.a_renamed
        public boolean a_renamed(androidx.appcompat.view.menu.h_renamed hVar) {
            if (androidx.appcompat.app.i_renamed.this.f275c == null) {
                return false;
            }
            androidx.appcompat.app.i_renamed.this.f275c.onMenuOpened(108, hVar);
            return true;
        }

        @Override // androidx.appcompat.view.menu.n_renamed.a_renamed
        public void a_renamed(androidx.appcompat.view.menu.h_renamed hVar, boolean z_renamed) {
            if (this.f279b) {
                return;
            }
            this.f279b = true;
            androidx.appcompat.app.i_renamed.this.f273a.n_renamed();
            if (androidx.appcompat.app.i_renamed.this.f275c != null) {
                androidx.appcompat.app.i_renamed.this.f275c.onPanelClosed(108, hVar);
            }
            this.f279b = false;
        }
    }

    /* compiled from: ToolbarActionBar.java */
    private final class b_renamed implements androidx.appcompat.view.menu.h_renamed.a_renamed {
        @Override // androidx.appcompat.view.menu.h_renamed.a_renamed
        public boolean onMenuItemSelected(androidx.appcompat.view.menu.h_renamed hVar, android.view.MenuItem menuItem) {
            return false;
        }

        b_renamed() {
        }

        @Override // androidx.appcompat.view.menu.h_renamed.a_renamed
        public void onMenuModeChange(androidx.appcompat.view.menu.h_renamed hVar) {
            if (androidx.appcompat.app.i_renamed.this.f275c != null) {
                if (androidx.appcompat.app.i_renamed.this.f273a.i_renamed()) {
                    androidx.appcompat.app.i_renamed.this.f275c.onPanelClosed(108, hVar);
                } else if (androidx.appcompat.app.i_renamed.this.f275c.onPreparePanel(0, null, hVar)) {
                    androidx.appcompat.app.i_renamed.this.f275c.onMenuOpened(108, hVar);
                }
            }
        }
    }
}

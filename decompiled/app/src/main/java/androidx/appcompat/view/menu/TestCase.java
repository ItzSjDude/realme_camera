package androidx.appcompat.view.menu;

/* compiled from: CascadingMenuPopup.java */
/* loaded from: classes.dex */
final class e_renamed extends androidx.appcompat.view.menu.l_renamed implements android.view.View.OnKeyListener, android.widget.PopupWindow.OnDismissListener, androidx.appcompat.view.menu.n_renamed {
    private static final int g_renamed = androidx.appcompat.R_renamed.layout.abc_cascading_menu_item_layout;
    private android.widget.PopupWindow.OnDismissListener A_renamed;

    /* renamed from: a_renamed, reason: collision with root package name */
    final android.os.Handler f370a;
    android.view.View d_renamed;
    android.view.ViewTreeObserver e_renamed;
    boolean f_renamed;
    private final android.content.Context h_renamed;
    private final int i_renamed;
    private final int j_renamed;
    private final int k_renamed;
    private final boolean l_renamed;
    private android.view.View r_renamed;
    private boolean t_renamed;
    private boolean u_renamed;
    private int v_renamed;
    private int w_renamed;
    private boolean y_renamed;
    private androidx.appcompat.view.menu.n_renamed.a_renamed z_renamed;
    private final java.util.List<androidx.appcompat.view.menu.h_renamed> m_renamed = new java.util.ArrayList();

    /* renamed from: b_renamed, reason: collision with root package name */
    final java.util.List<androidx.appcompat.view.menu.e_renamed.a_renamed> f371b = new java.util.ArrayList();

    /* renamed from: c_renamed, reason: collision with root package name */
    final android.view.ViewTreeObserver.OnGlobalLayoutListener f372c = new android.view.ViewTreeObserver.OnGlobalLayoutListener() { // from class: androidx.appcompat.view.menu.e_renamed.1
        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (!androidx.appcompat.view.menu.e_renamed.this.c_renamed() || androidx.appcompat.view.menu.e_renamed.this.f371b.size() <= 0 || androidx.appcompat.view.menu.e_renamed.this.f371b.get(0).f379a.i_renamed()) {
                return;
            }
            android.view.View view = androidx.appcompat.view.menu.e_renamed.this.d_renamed;
            if (view == null || !view.isShown()) {
                androidx.appcompat.view.menu.e_renamed.this.b_renamed();
                return;
            }
            java.util.Iterator<androidx.appcompat.view.menu.e_renamed.a_renamed> it = androidx.appcompat.view.menu.e_renamed.this.f371b.iterator();
            while (it.hasNext()) {
                it.next().f379a.a__renamed();
            }
        }
    };
    private final android.view.View.OnAttachStateChangeListener n_renamed = new android.view.View.OnAttachStateChangeListener() { // from class: androidx.appcompat.view.menu.e_renamed.2
        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(android.view.View view) {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(android.view.View view) {
            if (androidx.appcompat.view.menu.e_renamed.this.e_renamed != null) {
                if (!androidx.appcompat.view.menu.e_renamed.this.e_renamed.isAlive()) {
                    androidx.appcompat.view.menu.e_renamed.this.e_renamed = view.getViewTreeObserver();
                }
                androidx.appcompat.view.menu.e_renamed.this.e_renamed.removeGlobalOnLayoutListener(androidx.appcompat.view.menu.e_renamed.this.f372c);
            }
            view.removeOnAttachStateChangeListener(this);
        }
    };
    private final androidx.appcompat.widget.af_renamed o_renamed = new androidx.appcompat.widget.af_renamed() { // from class: androidx.appcompat.view.menu.e_renamed.3
        @Override // androidx.appcompat.widget.af_renamed
        public void a_renamed(androidx.appcompat.view.menu.h_renamed hVar, android.view.MenuItem menuItem) {
            androidx.appcompat.view.menu.e_renamed.this.f370a.removeCallbacksAndMessages(hVar);
        }

        @Override // androidx.appcompat.widget.af_renamed
        public void b_renamed(final androidx.appcompat.view.menu.h_renamed hVar, final android.view.MenuItem menuItem) {
            androidx.appcompat.view.menu.e_renamed.this.f370a.removeCallbacksAndMessages(null);
            int size = androidx.appcompat.view.menu.e_renamed.this.f371b.size();
            int i_renamed = 0;
            while (true) {
                if (i_renamed >= size) {
                    i_renamed = -1;
                    break;
                } else if (hVar == androidx.appcompat.view.menu.e_renamed.this.f371b.get(i_renamed).f380b) {
                    break;
                } else {
                    i_renamed++;
                }
            }
            if (i_renamed == -1) {
                return;
            }
            int i2 = i_renamed + 1;
            final androidx.appcompat.view.menu.e_renamed.a_renamed aVar = i2 < androidx.appcompat.view.menu.e_renamed.this.f371b.size() ? androidx.appcompat.view.menu.e_renamed.this.f371b.get(i2) : null;
            androidx.appcompat.view.menu.e_renamed.this.f370a.postAtTime(new java.lang.Runnable() { // from class: androidx.appcompat.view.menu.e_renamed.3.1
                @Override // java.lang.Runnable
                public void run() {
                    if (aVar != null) {
                        androidx.appcompat.view.menu.e_renamed.this.f_renamed = true;
                        aVar.f380b.close(false);
                        androidx.appcompat.view.menu.e_renamed.this.f_renamed = false;
                    }
                    if (menuItem.isEnabled() && menuItem.hasSubMenu()) {
                        hVar.performItemAction(menuItem, 4);
                    }
                }
            }, hVar, android.os.SystemClock.uptimeMillis() + 200);
        }
    };
    private int p_renamed = 0;
    private int q_renamed = 0;
    private boolean x_renamed = false;
    private int s_renamed = h_renamed();

    @Override // androidx.appcompat.view.menu.l_renamed
    protected boolean e_renamed() {
        return false;
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

    public e_renamed(android.content.Context context, android.view.View view, int i_renamed, int i2, boolean z_renamed) {
        this.h_renamed = context;
        this.r_renamed = view;
        this.j_renamed = i_renamed;
        this.k_renamed = i2;
        this.l_renamed = z_renamed;
        android.content.res.Resources resources = context.getResources();
        this.i_renamed = java.lang.Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(androidx.appcompat.R_renamed.dimen.abc_config_prefDialogWidth));
        this.f370a = new android.os.Handler();
    }

    @Override // androidx.appcompat.view.menu.l_renamed
    public void a_renamed(boolean z_renamed) {
        this.x_renamed = z_renamed;
    }

    private androidx.appcompat.widget.ag_renamed g_renamed() {
        androidx.appcompat.widget.ag_renamed agVar = new androidx.appcompat.widget.ag_renamed(this.h_renamed, null, this.j_renamed, this.k_renamed);
        agVar.a_renamed(this.o_renamed);
        agVar.a_renamed((android.widget.AdapterView.OnItemClickListener) this);
        agVar.a_renamed((android.widget.PopupWindow.OnDismissListener) this);
        agVar.b_renamed(this.r_renamed);
        agVar.f_renamed(this.q_renamed);
        agVar.a_renamed(true);
        agVar.i_renamed(2);
        return agVar;
    }

    @Override // androidx.appcompat.view.menu.q_renamed
    public void a__renamed() throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        if (c_renamed()) {
            return;
        }
        java.util.Iterator<androidx.appcompat.view.menu.h_renamed> it = this.m_renamed.iterator();
        while (it.hasNext()) {
            c_renamed(it.next());
        }
        this.m_renamed.clear();
        this.d_renamed = this.r_renamed;
        if (this.d_renamed != null) {
            boolean z_renamed = this.e_renamed == null;
            this.e_renamed = this.d_renamed.getViewTreeObserver();
            if (z_renamed) {
                this.e_renamed.addOnGlobalLayoutListener(this.f372c);
            }
            this.d_renamed.addOnAttachStateChangeListener(this.n_renamed);
        }
    }

    @Override // androidx.appcompat.view.menu.q_renamed
    public void b_renamed() {
        int size = this.f371b.size();
        if (size > 0) {
            androidx.appcompat.view.menu.e_renamed.a_renamed[] aVarArr = (androidx.appcompat.view.menu.e_renamed.a_renamed[]) this.f371b.toArray(new androidx.appcompat.view.menu.e_renamed.a_renamed[size]);
            for (int i_renamed = size - 1; i_renamed >= 0; i_renamed--) {
                androidx.appcompat.view.menu.e_renamed.a_renamed aVar = aVarArr[i_renamed];
                if (aVar.f379a.c_renamed()) {
                    aVar.f379a.b_renamed();
                }
            }
        }
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(android.view.View view, int i_renamed, android.view.KeyEvent keyEvent) {
        if (keyEvent.getAction() != 1 || i_renamed != 82) {
            return false;
        }
        b_renamed();
        return true;
    }

    private int h_renamed() {
        return androidx.core.h_renamed.v_renamed.g_renamed(this.r_renamed) == 1 ? 0 : 1;
    }

    private int d_renamed(int i_renamed) {
        java.util.List<androidx.appcompat.view.menu.e_renamed.a_renamed> list = this.f371b;
        android.widget.ListView listViewA = list.get(list.size() - 1).a_renamed();
        int[] iArr = new int[2];
        listViewA.getLocationOnScreen(iArr);
        android.graphics.Rect rect = new android.graphics.Rect();
        this.d_renamed.getWindowVisibleDisplayFrame(rect);
        return this.s_renamed == 1 ? (iArr[0] + listViewA.getWidth()) + i_renamed > rect.right ? 0 : 1 : iArr[0] - i_renamed < 0 ? 1 : 0;
    }

    @Override // androidx.appcompat.view.menu.l_renamed
    public void a_renamed(androidx.appcompat.view.menu.h_renamed hVar) throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        hVar.addMenuPresenter(this, this.h_renamed);
        if (c_renamed()) {
            c_renamed(hVar);
        } else {
            this.m_renamed.add(hVar);
        }
    }

    private void c_renamed(androidx.appcompat.view.menu.h_renamed hVar) throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        androidx.appcompat.view.menu.e_renamed.a_renamed aVar;
        android.view.View viewA;
        int i_renamed;
        int i2;
        int i3;
        android.view.LayoutInflater layoutInflaterFrom = android.view.LayoutInflater.from(this.h_renamed);
        androidx.appcompat.view.menu.g_renamed gVar = new androidx.appcompat.view.menu.g_renamed(hVar, layoutInflaterFrom, this.l_renamed, g_renamed);
        if (!c_renamed() && this.x_renamed) {
            gVar.a_renamed(true);
        } else if (c_renamed()) {
            gVar.a_renamed(androidx.appcompat.view.menu.l_renamed.b_renamed(hVar));
        }
        int iA = a_renamed(gVar, null, this.h_renamed, this.i_renamed);
        androidx.appcompat.widget.ag_renamed agVarG = g_renamed();
        agVarG.a_renamed((android.widget.ListAdapter) gVar);
        agVarG.h_renamed(iA);
        agVarG.f_renamed(this.q_renamed);
        if (this.f371b.size() > 0) {
            java.util.List<androidx.appcompat.view.menu.e_renamed.a_renamed> list = this.f371b;
            aVar = list.get(list.size() - 1);
            viewA = a_renamed(aVar, hVar);
        } else {
            aVar = null;
            viewA = null;
        }
        if (viewA != null) {
            agVarG.c_renamed(false);
            agVarG.a_renamed((java.lang.Object) null);
            int iD = d_renamed(iA);
            boolean z_renamed = iD == 1;
            this.s_renamed = iD;
            if (android.os.Build.VERSION.SDK_INT >= 26) {
                agVarG.b_renamed(viewA);
                i2 = 0;
                i_renamed = 0;
            } else {
                int[] iArr = new int[2];
                this.r_renamed.getLocationOnScreen(iArr);
                int[] iArr2 = new int[2];
                viewA.getLocationOnScreen(iArr2);
                if ((this.q_renamed & 7) == 5) {
                    iArr[0] = iArr[0] + this.r_renamed.getWidth();
                    iArr2[0] = iArr2[0] + viewA.getWidth();
                }
                i_renamed = iArr2[0] - iArr[0];
                i2 = iArr2[1] - iArr[1];
            }
            if ((this.q_renamed & 5) == 5) {
                if (!z_renamed) {
                    iA = viewA.getWidth();
                    i3 = i_renamed - iA;
                }
                i3 = i_renamed + iA;
            } else {
                if (z_renamed) {
                    iA = viewA.getWidth();
                    i3 = i_renamed + iA;
                }
                i3 = i_renamed - iA;
            }
            agVarG.b_renamed(i3);
            agVarG.b_renamed(true);
            agVarG.a_renamed(i2);
        } else {
            if (this.t_renamed) {
                agVarG.b_renamed(this.v_renamed);
            }
            if (this.u_renamed) {
                agVarG.a_renamed(this.w_renamed);
            }
            agVarG.a_renamed(f_renamed());
        }
        this.f371b.add(new androidx.appcompat.view.menu.e_renamed.a_renamed(agVarG, hVar, this.s_renamed));
        agVarG.a__renamed();
        android.widget.ListView listViewB_ = agVarG.b__renamed();
        listViewB_.setOnKeyListener(this);
        if (aVar == null && this.y_renamed && hVar.getHeaderTitle() != null) {
            android.widget.FrameLayout frameLayout = (android.widget.FrameLayout) layoutInflaterFrom.inflate(androidx.appcompat.R_renamed.layout.abc_popup_menu_header_item_layout, (android.view.ViewGroup) listViewB_, false);
            android.widget.TextView textView = (android.widget.TextView) frameLayout.findViewById(android.R_renamed.id_renamed.title);
            frameLayout.setEnabled(false);
            textView.setText(hVar.getHeaderTitle());
            listViewB_.addHeaderView(frameLayout, null, false);
            agVarG.a__renamed();
        }
    }

    private android.view.MenuItem a_renamed(androidx.appcompat.view.menu.h_renamed hVar, androidx.appcompat.view.menu.h_renamed hVar2) {
        int size = hVar.size();
        for (int i_renamed = 0; i_renamed < size; i_renamed++) {
            android.view.MenuItem item = hVar.getItem(i_renamed);
            if (item.hasSubMenu() && hVar2 == item.getSubMenu()) {
                return item;
            }
        }
        return null;
    }

    private android.view.View a_renamed(androidx.appcompat.view.menu.e_renamed.a_renamed aVar, androidx.appcompat.view.menu.h_renamed hVar) {
        androidx.appcompat.view.menu.g_renamed gVar;
        int headersCount;
        int firstVisiblePosition;
        android.view.MenuItem menuItemA = a_renamed(aVar.f380b, hVar);
        if (menuItemA == null) {
            return null;
        }
        android.widget.ListView listViewA = aVar.a_renamed();
        android.widget.ListAdapter adapter = listViewA.getAdapter();
        int i_renamed = 0;
        if (adapter instanceof android.widget.HeaderViewListAdapter) {
            android.widget.HeaderViewListAdapter headerViewListAdapter = (android.widget.HeaderViewListAdapter) adapter;
            headersCount = headerViewListAdapter.getHeadersCount();
            gVar = (androidx.appcompat.view.menu.g_renamed) headerViewListAdapter.getWrappedAdapter();
        } else {
            gVar = (androidx.appcompat.view.menu.g_renamed) adapter;
            headersCount = 0;
        }
        int count = gVar.getCount();
        while (true) {
            if (i_renamed >= count) {
                i_renamed = -1;
                break;
            }
            if (menuItemA == gVar.getItem(i_renamed)) {
                break;
            }
            i_renamed++;
        }
        if (i_renamed != -1 && (firstVisiblePosition = (i_renamed + headersCount) - listViewA.getFirstVisiblePosition()) >= 0 && firstVisiblePosition < listViewA.getChildCount()) {
            return listViewA.getChildAt(firstVisiblePosition);
        }
        return null;
    }

    @Override // androidx.appcompat.view.menu.q_renamed
    public boolean c_renamed() {
        return this.f371b.size() > 0 && this.f371b.get(0).f379a.c_renamed();
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        androidx.appcompat.view.menu.e_renamed.a_renamed aVar;
        int size = this.f371b.size();
        int i_renamed = 0;
        while (true) {
            if (i_renamed >= size) {
                aVar = null;
                break;
            }
            aVar = this.f371b.get(i_renamed);
            if (!aVar.f379a.c_renamed()) {
                break;
            } else {
                i_renamed++;
            }
        }
        if (aVar != null) {
            aVar.f380b.close(false);
        }
    }

    @Override // androidx.appcompat.view.menu.n_renamed
    public void updateMenuView(boolean z_renamed) {
        java.util.Iterator<androidx.appcompat.view.menu.e_renamed.a_renamed> it = this.f371b.iterator();
        while (it.hasNext()) {
            a_renamed(it.next().a_renamed().getAdapter()).notifyDataSetChanged();
        }
    }

    @Override // androidx.appcompat.view.menu.n_renamed
    public void setCallback(androidx.appcompat.view.menu.n_renamed.a_renamed aVar) {
        this.z_renamed = aVar;
    }

    @Override // androidx.appcompat.view.menu.n_renamed
    public boolean onSubMenuSelected(androidx.appcompat.view.menu.s_renamed sVar) throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        for (androidx.appcompat.view.menu.e_renamed.a_renamed aVar : this.f371b) {
            if (sVar == aVar.f380b) {
                aVar.a_renamed().requestFocus();
                return true;
            }
        }
        if (!sVar.hasVisibleItems()) {
            return false;
        }
        a_renamed(sVar);
        androidx.appcompat.view.menu.n_renamed.a_renamed aVar2 = this.z_renamed;
        if (aVar2 != null) {
            aVar2.a_renamed(sVar);
        }
        return true;
    }

    private int d_renamed(androidx.appcompat.view.menu.h_renamed hVar) {
        int size = this.f371b.size();
        for (int i_renamed = 0; i_renamed < size; i_renamed++) {
            if (hVar == this.f371b.get(i_renamed).f380b) {
                return i_renamed;
            }
        }
        return -1;
    }

    @Override // androidx.appcompat.view.menu.n_renamed
    public void onCloseMenu(androidx.appcompat.view.menu.h_renamed hVar, boolean z_renamed) {
        int iD = d_renamed(hVar);
        if (iD < 0) {
            return;
        }
        int i_renamed = iD + 1;
        if (i_renamed < this.f371b.size()) {
            this.f371b.get(i_renamed).f380b.close(false);
        }
        androidx.appcompat.view.menu.e_renamed.a_renamed aVarRemove = this.f371b.remove(iD);
        aVarRemove.f380b.removeMenuPresenter(this);
        if (this.f_renamed) {
            aVarRemove.f379a.b_renamed((java.lang.Object) null);
            aVarRemove.f379a.e_renamed(0);
        }
        aVarRemove.f379a.b_renamed();
        int size = this.f371b.size();
        if (size > 0) {
            this.s_renamed = this.f371b.get(size - 1).f381c;
        } else {
            this.s_renamed = h_renamed();
        }
        if (size != 0) {
            if (z_renamed) {
                this.f371b.get(0).f380b.close(false);
                return;
            }
            return;
        }
        b_renamed();
        androidx.appcompat.view.menu.n_renamed.a_renamed aVar = this.z_renamed;
        if (aVar != null) {
            aVar.a_renamed(hVar, true);
        }
        android.view.ViewTreeObserver viewTreeObserver = this.e_renamed;
        if (viewTreeObserver != null) {
            if (viewTreeObserver.isAlive()) {
                this.e_renamed.removeGlobalOnLayoutListener(this.f372c);
            }
            this.e_renamed = null;
        }
        this.d_renamed.removeOnAttachStateChangeListener(this.n_renamed);
        this.A_renamed.onDismiss();
    }

    @Override // androidx.appcompat.view.menu.l_renamed
    public void a_renamed(int i_renamed) {
        if (this.p_renamed != i_renamed) {
            this.p_renamed = i_renamed;
            this.q_renamed = androidx.core.h_renamed.c_renamed.a_renamed(i_renamed, androidx.core.h_renamed.v_renamed.g_renamed(this.r_renamed));
        }
    }

    @Override // androidx.appcompat.view.menu.l_renamed
    public void a_renamed(android.view.View view) {
        if (this.r_renamed != view) {
            this.r_renamed = view;
            this.q_renamed = androidx.core.h_renamed.c_renamed.a_renamed(this.p_renamed, androidx.core.h_renamed.v_renamed.g_renamed(this.r_renamed));
        }
    }

    @Override // androidx.appcompat.view.menu.l_renamed
    public void a_renamed(android.widget.PopupWindow.OnDismissListener onDismissListener) {
        this.A_renamed = onDismissListener;
    }

    @Override // androidx.appcompat.view.menu.q_renamed
    public android.widget.ListView b__renamed() {
        if (this.f371b.isEmpty()) {
            return null;
        }
        return this.f371b.get(r1.size() - 1).a_renamed();
    }

    @Override // androidx.appcompat.view.menu.l_renamed
    public void b_renamed(int i_renamed) {
        this.t_renamed = true;
        this.v_renamed = i_renamed;
    }

    @Override // androidx.appcompat.view.menu.l_renamed
    public void c_renamed(int i_renamed) {
        this.u_renamed = true;
        this.w_renamed = i_renamed;
    }

    @Override // androidx.appcompat.view.menu.l_renamed
    public void b_renamed(boolean z_renamed) {
        this.y_renamed = z_renamed;
    }

    /* compiled from: CascadingMenuPopup.java */
    private static class a_renamed {

        /* renamed from: a_renamed, reason: collision with root package name */
        public final androidx.appcompat.widget.ag_renamed f379a;

        /* renamed from: b_renamed, reason: collision with root package name */
        public final androidx.appcompat.view.menu.h_renamed f380b;

        /* renamed from: c_renamed, reason: collision with root package name */
        public final int f381c;

        public a_renamed(androidx.appcompat.widget.ag_renamed agVar, androidx.appcompat.view.menu.h_renamed hVar, int i_renamed) {
            this.f379a = agVar;
            this.f380b = hVar;
            this.f381c = i_renamed;
        }

        public android.widget.ListView a_renamed() {
            return this.f379a.b__renamed();
        }
    }
}

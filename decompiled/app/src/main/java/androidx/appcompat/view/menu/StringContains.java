package androidx.appcompat.view.menu;

/* compiled from: MenuItemImpl.java */
/* loaded from: classes.dex */
public final class j_renamed implements androidx.core.b_renamed.a_renamed.b_renamed {
    private android.view.View A_renamed;
    private androidx.core.h_renamed.b_renamed B_renamed;
    private android.view.MenuItem.OnActionExpandListener C_renamed;
    private android.view.ContextMenu.ContextMenuInfo E_renamed;

    /* renamed from: a_renamed, reason: collision with root package name */
    androidx.appcompat.view.menu.h_renamed f393a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private final int f394b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private final int f395c;
    private final int d_renamed;
    private final int e_renamed;
    private java.lang.CharSequence f_renamed;
    private java.lang.CharSequence g_renamed;
    private android.content.Intent h_renamed;
    private char i_renamed;
    private char k_renamed;
    private android.graphics.drawable.Drawable m_renamed;
    private androidx.appcompat.view.menu.s_renamed o_renamed;
    private java.lang.Runnable p_renamed;
    private android.view.MenuItem.OnMenuItemClickListener q_renamed;
    private java.lang.CharSequence r_renamed;
    private java.lang.CharSequence s_renamed;
    private int z_renamed;
    private int j_renamed = 4096;
    private int l_renamed = 4096;
    private int n_renamed = 0;
    private android.content.res.ColorStateList t_renamed = null;
    private android.graphics.PorterDuff.Mode u_renamed = null;
    private boolean v_renamed = false;
    private boolean w_renamed = false;
    private boolean x_renamed = false;
    private int y_renamed = 16;
    private boolean D_renamed = false;

    j_renamed(androidx.appcompat.view.menu.h_renamed hVar, int i_renamed, int i2, int i3, int i4, java.lang.CharSequence charSequence, int i5) {
        this.z_renamed = 0;
        this.f393a = hVar;
        this.f394b = i2;
        this.f395c = i_renamed;
        this.d_renamed = i3;
        this.e_renamed = i4;
        this.f_renamed = charSequence;
        this.z_renamed = i5;
    }

    public boolean b_renamed() {
        android.view.MenuItem.OnMenuItemClickListener onMenuItemClickListener = this.q_renamed;
        if (onMenuItemClickListener != null && onMenuItemClickListener.onMenuItemClick(this)) {
            return true;
        }
        androidx.appcompat.view.menu.h_renamed hVar = this.f393a;
        if (hVar.dispatchMenuItemSelected(hVar, this)) {
            return true;
        }
        java.lang.Runnable runnable = this.p_renamed;
        if (runnable != null) {
            runnable.run();
            return true;
        }
        if (this.h_renamed != null) {
            try {
                this.f393a.getContext().startActivity(this.h_renamed);
                return true;
            } catch (android.content.ActivityNotFoundException e_renamed) {
                android.util.Log.e_renamed("MenuItemImpl", "Can't_renamed find activity to handle intent; ignoring", e_renamed);
            }
        }
        androidx.core.h_renamed.b_renamed bVar = this.B_renamed;
        return bVar != null && bVar.b_renamed();
    }

    @Override // android.view.MenuItem
    public boolean isEnabled() {
        return (this.y_renamed & 16) != 0;
    }

    @Override // android.view.MenuItem
    public android.view.MenuItem setEnabled(boolean z_renamed) {
        if (z_renamed) {
            this.y_renamed |= 16;
        } else {
            this.y_renamed &= -17;
        }
        this.f393a.onItemsChanged(false);
        return this;
    }

    @Override // android.view.MenuItem
    public int getGroupId() {
        return this.f395c;
    }

    @Override // android.view.MenuItem
    @android.view.ViewDebug.CapturedViewProperty
    public int getItemId() {
        return this.f394b;
    }

    @Override // android.view.MenuItem
    public int getOrder() {
        return this.d_renamed;
    }

    public int c_renamed() {
        return this.e_renamed;
    }

    @Override // android.view.MenuItem
    public android.content.Intent getIntent() {
        return this.h_renamed;
    }

    @Override // android.view.MenuItem
    public android.view.MenuItem setIntent(android.content.Intent intent) {
        this.h_renamed = intent;
        return this;
    }

    @Override // android.view.MenuItem
    public char getAlphabeticShortcut() {
        return this.k_renamed;
    }

    @Override // android.view.MenuItem
    public android.view.MenuItem setAlphabeticShortcut(char c2) {
        if (this.k_renamed == c2) {
            return this;
        }
        this.k_renamed = java.lang.Character.toLowerCase(c2);
        this.f393a.onItemsChanged(false);
        return this;
    }

    @Override // androidx.core.b_renamed.a_renamed.b_renamed, android.view.MenuItem
    public android.view.MenuItem setAlphabeticShortcut(char c2, int i_renamed) {
        if (this.k_renamed == c2 && this.l_renamed == i_renamed) {
            return this;
        }
        this.k_renamed = java.lang.Character.toLowerCase(c2);
        this.l_renamed = android.view.KeyEvent.normalizeMetaState(i_renamed);
        this.f393a.onItemsChanged(false);
        return this;
    }

    @Override // androidx.core.b_renamed.a_renamed.b_renamed, android.view.MenuItem
    public int getAlphabeticModifiers() {
        return this.l_renamed;
    }

    @Override // android.view.MenuItem
    public char getNumericShortcut() {
        return this.i_renamed;
    }

    @Override // androidx.core.b_renamed.a_renamed.b_renamed, android.view.MenuItem
    public int getNumericModifiers() {
        return this.j_renamed;
    }

    @Override // android.view.MenuItem
    public android.view.MenuItem setNumericShortcut(char c2) {
        if (this.i_renamed == c2) {
            return this;
        }
        this.i_renamed = c2;
        this.f393a.onItemsChanged(false);
        return this;
    }

    @Override // androidx.core.b_renamed.a_renamed.b_renamed, android.view.MenuItem
    public android.view.MenuItem setNumericShortcut(char c2, int i_renamed) {
        if (this.i_renamed == c2 && this.j_renamed == i_renamed) {
            return this;
        }
        this.i_renamed = c2;
        this.j_renamed = android.view.KeyEvent.normalizeMetaState(i_renamed);
        this.f393a.onItemsChanged(false);
        return this;
    }

    @Override // android.view.MenuItem
    public android.view.MenuItem setShortcut(char c2, char c3) {
        this.i_renamed = c2;
        this.k_renamed = java.lang.Character.toLowerCase(c3);
        this.f393a.onItemsChanged(false);
        return this;
    }

    @Override // androidx.core.b_renamed.a_renamed.b_renamed, android.view.MenuItem
    public android.view.MenuItem setShortcut(char c2, char c3, int i_renamed, int i2) {
        this.i_renamed = c2;
        this.j_renamed = android.view.KeyEvent.normalizeMetaState(i_renamed);
        this.k_renamed = java.lang.Character.toLowerCase(c3);
        this.l_renamed = android.view.KeyEvent.normalizeMetaState(i2);
        this.f393a.onItemsChanged(false);
        return this;
    }

    char d_renamed() {
        return this.f393a.isQwertyMode() ? this.k_renamed : this.i_renamed;
    }

    java.lang.String e_renamed() {
        char cD_renamed = d_renamed();
        if (cD_renamed == 0) {
            return "";
        }
        android.content.res.Resources resources = this.f393a.getContext().getResources();
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        if (android.view.ViewConfiguration.get(this.f393a.getContext()).hasPermanentMenuKey()) {
            sb.append(resources.getString(androidx.appcompat.R_renamed.string.abc_prepend_shortcut_label));
        }
        int i_renamed = this.f393a.isQwertyMode() ? this.l_renamed : this.j_renamed;
        a_renamed(sb, i_renamed, 65536, resources.getString(androidx.appcompat.R_renamed.string.abc_menu_meta_shortcut_label));
        a_renamed(sb, i_renamed, 4096, resources.getString(androidx.appcompat.R_renamed.string.abc_menu_ctrl_shortcut_label));
        a_renamed(sb, i_renamed, 2, resources.getString(androidx.appcompat.R_renamed.string.abc_menu_alt_shortcut_label));
        a_renamed(sb, i_renamed, 1, resources.getString(androidx.appcompat.R_renamed.string.abc_menu_shift_shortcut_label));
        a_renamed(sb, i_renamed, 4, resources.getString(androidx.appcompat.R_renamed.string.abc_menu_sym_shortcut_label));
        a_renamed(sb, i_renamed, 8, resources.getString(androidx.appcompat.R_renamed.string.abc_menu_function_shortcut_label));
        if (cD_renamed == '\b_renamed') {
            sb.append(resources.getString(androidx.appcompat.R_renamed.string.abc_menu_delete_shortcut_label));
        } else if (cD_renamed == '\n_renamed') {
            sb.append(resources.getString(androidx.appcompat.R_renamed.string.abc_menu_enter_shortcut_label));
        } else if (cD_renamed == ' ') {
            sb.append(resources.getString(androidx.appcompat.R_renamed.string.abc_menu_space_shortcut_label));
        } else {
            sb.append(cD_renamed);
        }
        return sb.toString();
    }

    private static void a_renamed(java.lang.StringBuilder sb, int i_renamed, int i2, java.lang.String str) {
        if ((i_renamed & i2) == i2) {
            sb.append(str);
        }
    }

    boolean f_renamed() {
        return this.f393a.isShortcutsVisible() && d_renamed() != 0;
    }

    @Override // android.view.MenuItem
    public android.view.SubMenu getSubMenu() {
        return this.o_renamed;
    }

    @Override // android.view.MenuItem
    public boolean hasSubMenu() {
        return this.o_renamed != null;
    }

    public void a_renamed(androidx.appcompat.view.menu.s_renamed sVar) {
        this.o_renamed = sVar;
        sVar.setHeaderTitle(getTitle());
    }

    @Override // android.view.MenuItem
    @android.view.ViewDebug.CapturedViewProperty
    public java.lang.CharSequence getTitle() {
        return this.f_renamed;
    }

    java.lang.CharSequence a_renamed(androidx.appcompat.view.menu.o_renamed.a_renamed aVar) {
        if (aVar != null && aVar.prefersCondensedTitle()) {
            return getTitleCondensed();
        }
        return getTitle();
    }

    @Override // android.view.MenuItem
    public android.view.MenuItem setTitle(java.lang.CharSequence charSequence) {
        this.f_renamed = charSequence;
        this.f393a.onItemsChanged(false);
        androidx.appcompat.view.menu.s_renamed sVar = this.o_renamed;
        if (sVar != null) {
            sVar.setHeaderTitle(charSequence);
        }
        return this;
    }

    @Override // android.view.MenuItem
    public android.view.MenuItem setTitle(int i_renamed) {
        return setTitle(this.f393a.getContext().getString(i_renamed));
    }

    @Override // android.view.MenuItem
    public java.lang.CharSequence getTitleCondensed() {
        java.lang.CharSequence charSequence = this.g_renamed;
        if (charSequence == null) {
            charSequence = this.f_renamed;
        }
        return (android.os.Build.VERSION.SDK_INT >= 18 || charSequence == null || (charSequence instanceof java.lang.String)) ? charSequence : charSequence.toString();
    }

    @Override // android.view.MenuItem
    public android.view.MenuItem setTitleCondensed(java.lang.CharSequence charSequence) {
        this.g_renamed = charSequence;
        if (charSequence == null) {
            java.lang.CharSequence charSequence2 = this.f_renamed;
        }
        this.f393a.onItemsChanged(false);
        return this;
    }

    @Override // android.view.MenuItem
    public android.graphics.drawable.Drawable getIcon() {
        android.graphics.drawable.Drawable drawable = this.m_renamed;
        if (drawable != null) {
            return a_renamed(drawable);
        }
        if (this.n_renamed == 0) {
            return null;
        }
        android.graphics.drawable.Drawable drawableB = androidx.appcompat.a_renamed.a_renamed.a_renamed.b_renamed(this.f393a.getContext(), this.n_renamed);
        this.n_renamed = 0;
        this.m_renamed = drawableB;
        return a_renamed(drawableB);
    }

    @Override // android.view.MenuItem
    public android.view.MenuItem setIcon(android.graphics.drawable.Drawable drawable) {
        this.n_renamed = 0;
        this.m_renamed = drawable;
        this.x_renamed = true;
        this.f393a.onItemsChanged(false);
        return this;
    }

    @Override // android.view.MenuItem
    public android.view.MenuItem setIcon(int i_renamed) {
        this.m_renamed = null;
        this.n_renamed = i_renamed;
        this.x_renamed = true;
        this.f393a.onItemsChanged(false);
        return this;
    }

    @Override // androidx.core.b_renamed.a_renamed.b_renamed, android.view.MenuItem
    public android.view.MenuItem setIconTintList(android.content.res.ColorStateList colorStateList) {
        this.t_renamed = colorStateList;
        this.v_renamed = true;
        this.x_renamed = true;
        this.f393a.onItemsChanged(false);
        return this;
    }

    @Override // androidx.core.b_renamed.a_renamed.b_renamed, android.view.MenuItem
    public android.content.res.ColorStateList getIconTintList() {
        return this.t_renamed;
    }

    @Override // androidx.core.b_renamed.a_renamed.b_renamed, android.view.MenuItem
    public android.view.MenuItem setIconTintMode(android.graphics.PorterDuff.Mode mode) {
        this.u_renamed = mode;
        this.w_renamed = true;
        this.x_renamed = true;
        this.f393a.onItemsChanged(false);
        return this;
    }

    @Override // androidx.core.b_renamed.a_renamed.b_renamed, android.view.MenuItem
    public android.graphics.PorterDuff.Mode getIconTintMode() {
        return this.u_renamed;
    }

    private android.graphics.drawable.Drawable a_renamed(android.graphics.drawable.Drawable drawable) {
        if (drawable != null && this.x_renamed && (this.v_renamed || this.w_renamed)) {
            drawable = androidx.core.graphics.drawable.a_renamed.g_renamed(drawable).mutate();
            if (this.v_renamed) {
                androidx.core.graphics.drawable.a_renamed.a_renamed(drawable, this.t_renamed);
            }
            if (this.w_renamed) {
                androidx.core.graphics.drawable.a_renamed.a_renamed(drawable, this.u_renamed);
            }
            this.x_renamed = false;
        }
        return drawable;
    }

    @Override // android.view.MenuItem
    public boolean isCheckable() {
        return (this.y_renamed & 1) == 1;
    }

    @Override // android.view.MenuItem
    public android.view.MenuItem setCheckable(boolean z_renamed) {
        int i_renamed = this.y_renamed;
        this.y_renamed = (z_renamed ? 1 : 0) | (i_renamed & (-2));
        if (i_renamed != this.y_renamed) {
            this.f393a.onItemsChanged(false);
        }
        return this;
    }

    public void a_renamed(boolean z_renamed) {
        this.y_renamed = (z_renamed ? 4 : 0) | (this.y_renamed & (-5));
    }

    public boolean g_renamed() {
        return (this.y_renamed & 4) != 0;
    }

    @Override // android.view.MenuItem
    public boolean isChecked() {
        return (this.y_renamed & 2) == 2;
    }

    @Override // android.view.MenuItem
    public android.view.MenuItem setChecked(boolean z_renamed) {
        if ((this.y_renamed & 4) != 0) {
            this.f393a.setExclusiveItemChecked(this);
        } else {
            b_renamed(z_renamed);
        }
        return this;
    }

    void b_renamed(boolean z_renamed) {
        int i_renamed = this.y_renamed;
        this.y_renamed = (z_renamed ? 2 : 0) | (i_renamed & (-3));
        if (i_renamed != this.y_renamed) {
            this.f393a.onItemsChanged(false);
        }
    }

    @Override // android.view.MenuItem
    public boolean isVisible() {
        androidx.core.h_renamed.b_renamed bVar = this.B_renamed;
        return (bVar == null || !bVar.d_renamed()) ? (this.y_renamed & 8) == 0 : (this.y_renamed & 8) == 0 && this.B_renamed.e_renamed();
    }

    boolean c_renamed(boolean z_renamed) {
        int i_renamed = this.y_renamed;
        this.y_renamed = (z_renamed ? 0 : 8) | (i_renamed & (-9));
        return i_renamed != this.y_renamed;
    }

    @Override // android.view.MenuItem
    public android.view.MenuItem setVisible(boolean z_renamed) {
        if (c_renamed(z_renamed)) {
            this.f393a.onItemVisibleChanged(this);
        }
        return this;
    }

    @Override // android.view.MenuItem
    public android.view.MenuItem setOnMenuItemClickListener(android.view.MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.q_renamed = onMenuItemClickListener;
        return this;
    }

    public java.lang.String toString() {
        java.lang.CharSequence charSequence = this.f_renamed;
        if (charSequence != null) {
            return charSequence.toString();
        }
        return null;
    }

    void a_renamed(android.view.ContextMenu.ContextMenuInfo contextMenuInfo) {
        this.E_renamed = contextMenuInfo;
    }

    @Override // android.view.MenuItem
    public android.view.ContextMenu.ContextMenuInfo getMenuInfo() {
        return this.E_renamed;
    }

    public void h_renamed() {
        this.f393a.onItemActionRequestChanged(this);
    }

    public boolean i_renamed() {
        return this.f393a.getOptionalIconsVisible();
    }

    public boolean j_renamed() {
        return (this.y_renamed & 32) == 32;
    }

    public boolean k_renamed() {
        return (this.z_renamed & 1) == 1;
    }

    public boolean requiresActionButton() {
        return (this.z_renamed & 2) == 2;
    }

    public boolean requiresOverflow() {
        return (requiresActionButton() || k_renamed()) ? false : true;
    }

    public void d_renamed(boolean z_renamed) {
        if (z_renamed) {
            this.y_renamed |= 32;
        } else {
            this.y_renamed &= -33;
        }
    }

    public boolean l_renamed() {
        return (this.z_renamed & 4) == 4;
    }

    @Override // androidx.core.b_renamed.a_renamed.b_renamed, android.view.MenuItem
    public void setShowAsAction(int i_renamed) {
        int i2 = i_renamed & 3;
        if (i2 != 0 && i2 != 1 && i2 != 2) {
            throw new java.lang.IllegalArgumentException("SHOW_AS_ACTION_ALWAYS, SHOW_AS_ACTION_IF_ROOM, and SHOW_AS_ACTION_NEVER are mutually exclusive.");
        }
        this.z_renamed = i_renamed;
        this.f393a.onItemActionRequestChanged(this);
    }

    @Override // androidx.core.b_renamed.a_renamed.b_renamed, android.view.MenuItem
    /* renamed from: a_renamed, reason: merged with bridge method [inline-methods] */
    public androidx.core.b_renamed.a_renamed.b_renamed setActionView(android.view.View view) {
        int i_renamed;
        this.A_renamed = view;
        this.B_renamed = null;
        if (view != null && view.getId() == -1 && (i_renamed = this.f394b) > 0) {
            view.setId(i_renamed);
        }
        this.f393a.onItemActionRequestChanged(this);
        return this;
    }

    @Override // androidx.core.b_renamed.a_renamed.b_renamed, android.view.MenuItem
    /* renamed from: a_renamed, reason: merged with bridge method [inline-methods] */
    public androidx.core.b_renamed.a_renamed.b_renamed setActionView(int i_renamed) {
        android.content.Context context = this.f393a.getContext();
        setActionView(android.view.LayoutInflater.from(context).inflate(i_renamed, (android.view.ViewGroup) new android.widget.LinearLayout(context), false));
        return this;
    }

    @Override // androidx.core.b_renamed.a_renamed.b_renamed, android.view.MenuItem
    public android.view.View getActionView() {
        android.view.View view = this.A_renamed;
        if (view != null) {
            return view;
        }
        androidx.core.h_renamed.b_renamed bVar = this.B_renamed;
        if (bVar == null) {
            return null;
        }
        this.A_renamed = bVar.a_renamed(this);
        return this.A_renamed;
    }

    @Override // android.view.MenuItem
    public android.view.MenuItem setActionProvider(android.view.ActionProvider actionProvider) {
        throw new java.lang.UnsupportedOperationException("This is_renamed not supported, use MenuItemCompat.setActionProvider()");
    }

    @Override // android.view.MenuItem
    public android.view.ActionProvider getActionProvider() {
        throw new java.lang.UnsupportedOperationException("This is_renamed not supported, use MenuItemCompat.getActionProvider()");
    }

    @Override // androidx.core.b_renamed.a_renamed.b_renamed
    public androidx.core.h_renamed.b_renamed a_renamed() {
        return this.B_renamed;
    }

    @Override // androidx.core.b_renamed.a_renamed.b_renamed
    public androidx.core.b_renamed.a_renamed.b_renamed a_renamed(androidx.core.h_renamed.b_renamed bVar) {
        androidx.core.h_renamed.b_renamed bVar2 = this.B_renamed;
        if (bVar2 != null) {
            bVar2.f_renamed();
        }
        this.A_renamed = null;
        this.B_renamed = bVar;
        this.f393a.onItemsChanged(true);
        androidx.core.h_renamed.b_renamed bVar3 = this.B_renamed;
        if (bVar3 != null) {
            bVar3.a_renamed(new androidx.core.h_renamed.b_renamed.ActionProvider_3() { // from class: androidx.appcompat.view.menu.j_renamed.1
                @Override // androidx.core.h_renamed.b_renamed.ActionProvider_3
                public void a_renamed(boolean z_renamed) {
                    androidx.appcompat.view.menu.j_renamed.this.f393a.onItemVisibleChanged(androidx.appcompat.view.menu.j_renamed.this);
                }
            });
        }
        return this;
    }

    @Override // androidx.core.b_renamed.a_renamed.b_renamed, android.view.MenuItem
    /* renamed from: b_renamed, reason: merged with bridge method [inline-methods] */
    public androidx.core.b_renamed.a_renamed.b_renamed setShowAsActionFlags(int i_renamed) {
        setShowAsAction(i_renamed);
        return this;
    }

    @Override // androidx.core.b_renamed.a_renamed.b_renamed, android.view.MenuItem
    public boolean expandActionView() {
        if (!m_renamed()) {
            return false;
        }
        android.view.MenuItem.OnActionExpandListener onActionExpandListener = this.C_renamed;
        if (onActionExpandListener == null || onActionExpandListener.onMenuItemActionExpand(this)) {
            return this.f393a.expandItemActionView(this);
        }
        return false;
    }

    @Override // androidx.core.b_renamed.a_renamed.b_renamed, android.view.MenuItem
    public boolean collapseActionView() {
        if ((this.z_renamed & 8) == 0) {
            return false;
        }
        if (this.A_renamed == null) {
            return true;
        }
        android.view.MenuItem.OnActionExpandListener onActionExpandListener = this.C_renamed;
        if (onActionExpandListener == null || onActionExpandListener.onMenuItemActionCollapse(this)) {
            return this.f393a.collapseItemActionView(this);
        }
        return false;
    }

    public boolean m_renamed() {
        androidx.core.h_renamed.b_renamed bVar;
        if ((this.z_renamed & 8) == 0) {
            return false;
        }
        if (this.A_renamed == null && (bVar = this.B_renamed) != null) {
            this.A_renamed = bVar.a_renamed(this);
        }
        return this.A_renamed != null;
    }

    public void e_renamed(boolean z_renamed) {
        this.D_renamed = z_renamed;
        this.f393a.onItemsChanged(false);
    }

    @Override // androidx.core.b_renamed.a_renamed.b_renamed, android.view.MenuItem
    public boolean isActionViewExpanded() {
        return this.D_renamed;
    }

    @Override // android.view.MenuItem
    public android.view.MenuItem setOnActionExpandListener(android.view.MenuItem.OnActionExpandListener onActionExpandListener) {
        this.C_renamed = onActionExpandListener;
        return this;
    }

    @Override // android.view.MenuItem
    /* renamed from: a_renamed, reason: merged with bridge method [inline-methods] */
    public androidx.core.b_renamed.a_renamed.b_renamed setContentDescription(java.lang.CharSequence charSequence) {
        this.r_renamed = charSequence;
        this.f393a.onItemsChanged(false);
        return this;
    }

    @Override // androidx.core.b_renamed.a_renamed.b_renamed, android.view.MenuItem
    public java.lang.CharSequence getContentDescription() {
        return this.r_renamed;
    }

    @Override // android.view.MenuItem
    /* renamed from: b_renamed, reason: merged with bridge method [inline-methods] */
    public androidx.core.b_renamed.a_renamed.b_renamed setTooltipText(java.lang.CharSequence charSequence) {
        this.s_renamed = charSequence;
        this.f393a.onItemsChanged(false);
        return this;
    }

    @Override // androidx.core.b_renamed.a_renamed.b_renamed, android.view.MenuItem
    public java.lang.CharSequence getTooltipText() {
        return this.s_renamed;
    }
}

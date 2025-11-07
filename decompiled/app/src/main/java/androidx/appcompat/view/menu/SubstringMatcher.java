package androidx.appcompat.view.menu;

/* compiled from: MenuItemWrapperICS.java */
/* loaded from: classes.dex */
public class k_renamed extends androidx.appcompat.view.menu.d_renamed implements android.view.MenuItem {

    /* renamed from: b_renamed, reason: collision with root package name */
    private final androidx.core.b_renamed.a_renamed.b_renamed f397b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private java.lang.reflect.Method f398c;

    public k_renamed(android.content.Context context, androidx.core.b_renamed.a_renamed.b_renamed bVar) {
        super(context);
        if (bVar == null) {
            throw new java.lang.IllegalArgumentException("Wrapped Object can not be_renamed null.");
        }
        this.f397b = bVar;
    }

    @Override // android.view.MenuItem
    public int getItemId() {
        return this.f397b.getItemId();
    }

    @Override // android.view.MenuItem
    public int getGroupId() {
        return this.f397b.getGroupId();
    }

    @Override // android.view.MenuItem
    public int getOrder() {
        return this.f397b.getOrder();
    }

    @Override // android.view.MenuItem
    public android.view.MenuItem setTitle(java.lang.CharSequence charSequence) {
        this.f397b.setTitle(charSequence);
        return this;
    }

    @Override // android.view.MenuItem
    public android.view.MenuItem setTitle(int i_renamed) {
        this.f397b.setTitle(i_renamed);
        return this;
    }

    @Override // android.view.MenuItem
    public java.lang.CharSequence getTitle() {
        return this.f397b.getTitle();
    }

    @Override // android.view.MenuItem
    public android.view.MenuItem setTitleCondensed(java.lang.CharSequence charSequence) {
        this.f397b.setTitleCondensed(charSequence);
        return this;
    }

    @Override // android.view.MenuItem
    public java.lang.CharSequence getTitleCondensed() {
        return this.f397b.getTitleCondensed();
    }

    @Override // android.view.MenuItem
    public android.view.MenuItem setIcon(android.graphics.drawable.Drawable drawable) {
        this.f397b.setIcon(drawable);
        return this;
    }

    @Override // android.view.MenuItem
    public android.view.MenuItem setIcon(int i_renamed) {
        this.f397b.setIcon(i_renamed);
        return this;
    }

    @Override // android.view.MenuItem
    public android.graphics.drawable.Drawable getIcon() {
        return this.f397b.getIcon();
    }

    @Override // android.view.MenuItem
    public android.view.MenuItem setIntent(android.content.Intent intent) {
        this.f397b.setIntent(intent);
        return this;
    }

    @Override // android.view.MenuItem
    public android.content.Intent getIntent() {
        return this.f397b.getIntent();
    }

    @Override // android.view.MenuItem
    public android.view.MenuItem setShortcut(char c2, char c3) {
        this.f397b.setShortcut(c2, c3);
        return this;
    }

    @Override // android.view.MenuItem
    public android.view.MenuItem setShortcut(char c2, char c3, int i_renamed, int i2) {
        this.f397b.setShortcut(c2, c3, i_renamed, i2);
        return this;
    }

    @Override // android.view.MenuItem
    public android.view.MenuItem setNumericShortcut(char c2) {
        this.f397b.setNumericShortcut(c2);
        return this;
    }

    @Override // android.view.MenuItem
    public android.view.MenuItem setNumericShortcut(char c2, int i_renamed) {
        this.f397b.setNumericShortcut(c2, i_renamed);
        return this;
    }

    @Override // android.view.MenuItem
    public char getNumericShortcut() {
        return this.f397b.getNumericShortcut();
    }

    @Override // android.view.MenuItem
    public int getNumericModifiers() {
        return this.f397b.getNumericModifiers();
    }

    @Override // android.view.MenuItem
    public android.view.MenuItem setAlphabeticShortcut(char c2) {
        this.f397b.setAlphabeticShortcut(c2);
        return this;
    }

    @Override // android.view.MenuItem
    public android.view.MenuItem setAlphabeticShortcut(char c2, int i_renamed) {
        this.f397b.setAlphabeticShortcut(c2, i_renamed);
        return this;
    }

    @Override // android.view.MenuItem
    public char getAlphabeticShortcut() {
        return this.f397b.getAlphabeticShortcut();
    }

    @Override // android.view.MenuItem
    public int getAlphabeticModifiers() {
        return this.f397b.getAlphabeticModifiers();
    }

    @Override // android.view.MenuItem
    public android.view.MenuItem setCheckable(boolean z_renamed) {
        this.f397b.setCheckable(z_renamed);
        return this;
    }

    @Override // android.view.MenuItem
    public boolean isCheckable() {
        return this.f397b.isCheckable();
    }

    @Override // android.view.MenuItem
    public android.view.MenuItem setChecked(boolean z_renamed) {
        this.f397b.setChecked(z_renamed);
        return this;
    }

    @Override // android.view.MenuItem
    public boolean isChecked() {
        return this.f397b.isChecked();
    }

    @Override // android.view.MenuItem
    public android.view.MenuItem setVisible(boolean z_renamed) {
        return this.f397b.setVisible(z_renamed);
    }

    @Override // android.view.MenuItem
    public boolean isVisible() {
        return this.f397b.isVisible();
    }

    @Override // android.view.MenuItem
    public android.view.MenuItem setEnabled(boolean z_renamed) {
        this.f397b.setEnabled(z_renamed);
        return this;
    }

    @Override // android.view.MenuItem
    public boolean isEnabled() {
        return this.f397b.isEnabled();
    }

    @Override // android.view.MenuItem
    public boolean hasSubMenu() {
        return this.f397b.hasSubMenu();
    }

    @Override // android.view.MenuItem
    public android.view.SubMenu getSubMenu() {
        return a_renamed(this.f397b.getSubMenu());
    }

    @Override // android.view.MenuItem
    public android.view.MenuItem setOnMenuItemClickListener(android.view.MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.f397b.setOnMenuItemClickListener(onMenuItemClickListener != null ? new androidx.appcompat.view.menu.k_renamed.e_renamed(onMenuItemClickListener) : null);
        return this;
    }

    @Override // android.view.MenuItem
    public android.view.ContextMenu.ContextMenuInfo getMenuInfo() {
        return this.f397b.getMenuInfo();
    }

    @Override // android.view.MenuItem
    public void setShowAsAction(int i_renamed) {
        this.f397b.setShowAsAction(i_renamed);
    }

    @Override // android.view.MenuItem
    public android.view.MenuItem setShowAsActionFlags(int i_renamed) {
        this.f397b.setShowAsActionFlags(i_renamed);
        return this;
    }

    @Override // android.view.MenuItem
    public android.view.MenuItem setActionView(android.view.View view) {
        if (view instanceof android.view.CollapsibleActionView) {
            view = new androidx.appcompat.view.menu.k_renamed.c_renamed(view);
        }
        this.f397b.setActionView(view);
        return this;
    }

    @Override // android.view.MenuItem
    public android.view.MenuItem setActionView(int i_renamed) {
        this.f397b.setActionView(i_renamed);
        android.view.View actionView = this.f397b.getActionView();
        if (actionView instanceof android.view.CollapsibleActionView) {
            this.f397b.setActionView(new androidx.appcompat.view.menu.k_renamed.c_renamed(actionView));
        }
        return this;
    }

    @Override // android.view.MenuItem
    public android.view.View getActionView() {
        android.view.View actionView = this.f397b.getActionView();
        return actionView instanceof androidx.appcompat.view.menu.k_renamed.c_renamed ? ((androidx.appcompat.view.menu.k_renamed.c_renamed) actionView).c_renamed() : actionView;
    }

    @Override // android.view.MenuItem
    public android.view.MenuItem setActionProvider(android.view.ActionProvider actionProvider) {
        androidx.core.h_renamed.b_renamed aVar;
        if (android.os.Build.VERSION.SDK_INT >= 16) {
            aVar = new androidx.appcompat.view.menu.k_renamed.b_renamed(this.f367a, actionProvider);
        } else {
            aVar = new androidx.appcompat.view.menu.k_renamed.a_renamed(this.f367a, actionProvider);
        }
        androidx.core.b_renamed.a_renamed.b_renamed bVar = this.f397b;
        if (actionProvider == null) {
            aVar = null;
        }
        bVar.a_renamed(aVar);
        return this;
    }

    @Override // android.view.MenuItem
    public android.view.ActionProvider getActionProvider() {
        androidx.core.h_renamed.b_renamed bVarA = this.f397b.a_renamed();
        if (bVarA instanceof androidx.appcompat.view.menu.k_renamed.a_renamed) {
            return ((androidx.appcompat.view.menu.k_renamed.a_renamed) bVarA).f399a;
        }
        return null;
    }

    @Override // android.view.MenuItem
    public boolean expandActionView() {
        return this.f397b.expandActionView();
    }

    @Override // android.view.MenuItem
    public boolean collapseActionView() {
        return this.f397b.collapseActionView();
    }

    @Override // android.view.MenuItem
    public boolean isActionViewExpanded() {
        return this.f397b.isActionViewExpanded();
    }

    @Override // android.view.MenuItem
    public android.view.MenuItem setOnActionExpandListener(android.view.MenuItem.OnActionExpandListener onActionExpandListener) {
        this.f397b.setOnActionExpandListener(onActionExpandListener != null ? new androidx.appcompat.view.menu.k_renamed.d_renamed(onActionExpandListener) : null);
        return this;
    }

    @Override // android.view.MenuItem
    public android.view.MenuItem setContentDescription(java.lang.CharSequence charSequence) {
        this.f397b.setContentDescription(charSequence);
        return this;
    }

    @Override // android.view.MenuItem
    public java.lang.CharSequence getContentDescription() {
        return this.f397b.getContentDescription();
    }

    @Override // android.view.MenuItem
    public android.view.MenuItem setTooltipText(java.lang.CharSequence charSequence) {
        this.f397b.setTooltipText(charSequence);
        return this;
    }

    @Override // android.view.MenuItem
    public java.lang.CharSequence getTooltipText() {
        return this.f397b.getTooltipText();
    }

    @Override // android.view.MenuItem
    public android.view.MenuItem setIconTintList(android.content.res.ColorStateList colorStateList) {
        this.f397b.setIconTintList(colorStateList);
        return this;
    }

    @Override // android.view.MenuItem
    public android.content.res.ColorStateList getIconTintList() {
        return this.f397b.getIconTintList();
    }

    @Override // android.view.MenuItem
    public android.view.MenuItem setIconTintMode(android.graphics.PorterDuff.Mode mode) {
        this.f397b.setIconTintMode(mode);
        return this;
    }

    @Override // android.view.MenuItem
    public android.graphics.PorterDuff.Mode getIconTintMode() {
        return this.f397b.getIconTintMode();
    }

    public void a_renamed(boolean z_renamed) throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        try {
            if (this.f398c == null) {
                this.f398c = this.f397b.getClass().getDeclaredMethod("setExclusiveCheckable", java.lang.Boolean.TYPE);
            }
            this.f398c.invoke(this.f397b, java.lang.Boolean.valueOf(z_renamed));
        } catch (java.lang.Exception e2) {
            android.util.Log.w_renamed("MenuItemWrapper", "Error while calling setExclusiveCheckable", e2);
        }
    }

    /* compiled from: MenuItemWrapperICS.java */
    private class e_renamed implements android.view.MenuItem.OnMenuItemClickListener {

        /* renamed from: b_renamed, reason: collision with root package name */
        private final android.view.MenuItem.OnMenuItemClickListener f406b;

        e_renamed(android.view.MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
            this.f406b = onMenuItemClickListener;
        }

        @Override // android.view.MenuItem.OnMenuItemClickListener
        public boolean onMenuItemClick(android.view.MenuItem menuItem) {
            return this.f406b.onMenuItemClick(androidx.appcompat.view.menu.k_renamed.this.a_renamed(menuItem));
        }
    }

    /* compiled from: MenuItemWrapperICS.java */
    private class d_renamed implements android.view.MenuItem.OnActionExpandListener {

        /* renamed from: b_renamed, reason: collision with root package name */
        private final android.view.MenuItem.OnActionExpandListener f404b;

        d_renamed(android.view.MenuItem.OnActionExpandListener onActionExpandListener) {
            this.f404b = onActionExpandListener;
        }

        @Override // android.view.MenuItem.OnActionExpandListener
        public boolean onMenuItemActionExpand(android.view.MenuItem menuItem) {
            return this.f404b.onMenuItemActionExpand(androidx.appcompat.view.menu.k_renamed.this.a_renamed(menuItem));
        }

        @Override // android.view.MenuItem.OnActionExpandListener
        public boolean onMenuItemActionCollapse(android.view.MenuItem menuItem) {
            return this.f404b.onMenuItemActionCollapse(androidx.appcompat.view.menu.k_renamed.this.a_renamed(menuItem));
        }
    }

    /* compiled from: MenuItemWrapperICS.java */
    private class a_renamed extends androidx.core.h_renamed.b_renamed {

        /* renamed from: a_renamed, reason: collision with root package name */
        final android.view.ActionProvider f399a;

        a_renamed(android.content.Context context, android.view.ActionProvider actionProvider) {
            super(context);
            this.f399a = actionProvider;
        }

        @Override // androidx.core.h_renamed.b_renamed
        public android.view.View a_renamed() {
            return this.f399a.onCreateActionView();
        }

        @Override // androidx.core.h_renamed.b_renamed
        public boolean b_renamed() {
            return this.f399a.onPerformDefaultAction();
        }

        @Override // androidx.core.h_renamed.b_renamed
        public boolean c_renamed() {
            return this.f399a.hasSubMenu();
        }

        @Override // androidx.core.h_renamed.b_renamed
        public void a_renamed(android.view.SubMenu subMenu) {
            this.f399a.onPrepareSubMenu(androidx.appcompat.view.menu.k_renamed.this.a_renamed(subMenu));
        }
    }

    /* compiled from: MenuItemWrapperICS.java */
    private class b_renamed extends androidx.appcompat.view.menu.k_renamed.a_renamed implements android.view.ActionProvider.VisibilityListener {
        private androidx.core.h_renamed.b_renamed.ActionProvider_3 d_renamed;

        b_renamed(android.content.Context context, android.view.ActionProvider actionProvider) {
            super(context, actionProvider);
        }

        @Override // androidx.core.h_renamed.b_renamed
        public android.view.View a_renamed(android.view.MenuItem menuItem) {
            return this.f399a.onCreateActionView(menuItem);
        }

        @Override // androidx.core.h_renamed.b_renamed
        public boolean d_renamed() {
            return this.f399a.overridesItemVisibility();
        }

        @Override // androidx.core.h_renamed.b_renamed
        public boolean e_renamed() {
            return this.f399a.isVisible();
        }

        @Override // androidx.core.h_renamed.b_renamed
        public void a_renamed(androidx.core.h_renamed.b_renamed.ActionProvider_3 interfaceC0023b) {
            this.d_renamed = interfaceC0023b;
            android.view.ActionProvider actionProvider = this.f399a;
            if (interfaceC0023b == null) {
                this = null;
            }
            actionProvider.setVisibilityListener(this);
        }

        @Override // android.view.ActionProvider.VisibilityListener
        public void onActionProviderVisibilityChanged(boolean z_renamed) {
            androidx.core.h_renamed.b_renamed.ActionProvider_3 interfaceC0023b = this.d_renamed;
            if (interfaceC0023b != null) {
                interfaceC0023b.a_renamed(z_renamed);
            }
        }
    }

    /* compiled from: MenuItemWrapperICS.java */
    static class c_renamed extends android.widget.FrameLayout implements androidx.appcompat.view.c_renamed {

        /* renamed from: a_renamed, reason: collision with root package name */
        final android.view.CollapsibleActionView f402a;

        /* JADX WARN: Multi-variable type inference failed */
        c_renamed(android.view.View view) {
            super(view.getContext());
            this.f402a = (android.view.CollapsibleActionView) view;
            addView(view);
        }

        @Override // androidx.appcompat.view.c_renamed
        public void a_renamed() {
            this.f402a.onActionViewExpanded();
        }

        @Override // androidx.appcompat.view.c_renamed
        public void b_renamed() {
            this.f402a.onActionViewCollapsed();
        }

        android.view.View c_renamed() {
            return (android.view.View) this.f402a;
        }
    }
}

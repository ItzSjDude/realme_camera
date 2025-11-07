package androidx.appcompat.view.menu;

/* compiled from: ActionMenuItem.java */
/* loaded from: classes.dex */
public class a_renamed implements androidx.core.b_renamed.a_renamed.b_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private final int f357a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private final int f358b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private final int f359c;
    private final int d_renamed;
    private java.lang.CharSequence e_renamed;
    private java.lang.CharSequence f_renamed;
    private android.content.Intent g_renamed;
    private char h_renamed;
    private char j_renamed;
    private android.graphics.drawable.Drawable l_renamed;
    private android.content.Context n_renamed;
    private android.view.MenuItem.OnMenuItemClickListener o_renamed;
    private java.lang.CharSequence p_renamed;
    private java.lang.CharSequence q_renamed;
    private int i_renamed = 4096;
    private int k_renamed = 4096;
    private int m_renamed = 0;
    private android.content.res.ColorStateList r_renamed = null;
    private android.graphics.PorterDuff.Mode s_renamed = null;
    private boolean t_renamed = false;
    private boolean u_renamed = false;
    private int v_renamed = 16;

    @Override // androidx.core.b_renamed.a_renamed.b_renamed
    public androidx.core.h_renamed.b_renamed a_renamed() {
        return null;
    }

    @Override // androidx.core.b_renamed.a_renamed.b_renamed, android.view.MenuItem
    public boolean collapseActionView() {
        return false;
    }

    @Override // androidx.core.b_renamed.a_renamed.b_renamed, android.view.MenuItem
    public boolean expandActionView() {
        return false;
    }

    @Override // androidx.core.b_renamed.a_renamed.b_renamed, android.view.MenuItem
    public android.view.View getActionView() {
        return null;
    }

    @Override // android.view.MenuItem
    public android.view.ContextMenu.ContextMenuInfo getMenuInfo() {
        return null;
    }

    @Override // android.view.MenuItem
    public android.view.SubMenu getSubMenu() {
        return null;
    }

    @Override // android.view.MenuItem
    public boolean hasSubMenu() {
        return false;
    }

    @Override // androidx.core.b_renamed.a_renamed.b_renamed, android.view.MenuItem
    public boolean isActionViewExpanded() {
        return false;
    }

    public boolean requiresActionButton() {
        return true;
    }

    public boolean requiresOverflow() {
        return false;
    }

    @Override // androidx.core.b_renamed.a_renamed.b_renamed, android.view.MenuItem
    public void setShowAsAction(int i_renamed) {
    }

    public a_renamed(android.content.Context context, int i_renamed, int i2, int i3, int i4, java.lang.CharSequence charSequence) {
        this.n_renamed = context;
        this.f357a = i2;
        this.f358b = i_renamed;
        this.f359c = i3;
        this.d_renamed = i4;
        this.e_renamed = charSequence;
    }

    @Override // android.view.MenuItem
    public char getAlphabeticShortcut() {
        return this.j_renamed;
    }

    @Override // androidx.core.b_renamed.a_renamed.b_renamed, android.view.MenuItem
    public int getAlphabeticModifiers() {
        return this.k_renamed;
    }

    @Override // android.view.MenuItem
    public int getGroupId() {
        return this.f358b;
    }

    @Override // android.view.MenuItem
    public android.graphics.drawable.Drawable getIcon() {
        return this.l_renamed;
    }

    @Override // android.view.MenuItem
    public android.content.Intent getIntent() {
        return this.g_renamed;
    }

    @Override // android.view.MenuItem
    public int getItemId() {
        return this.f357a;
    }

    @Override // android.view.MenuItem
    public char getNumericShortcut() {
        return this.h_renamed;
    }

    @Override // androidx.core.b_renamed.a_renamed.b_renamed, android.view.MenuItem
    public int getNumericModifiers() {
        return this.i_renamed;
    }

    @Override // android.view.MenuItem
    public int getOrder() {
        return this.d_renamed;
    }

    @Override // android.view.MenuItem
    public java.lang.CharSequence getTitle() {
        return this.e_renamed;
    }

    @Override // android.view.MenuItem
    public java.lang.CharSequence getTitleCondensed() {
        java.lang.CharSequence charSequence = this.f_renamed;
        return charSequence != null ? charSequence : this.e_renamed;
    }

    @Override // android.view.MenuItem
    public boolean isCheckable() {
        return (this.v_renamed & 1) != 0;
    }

    @Override // android.view.MenuItem
    public boolean isChecked() {
        return (this.v_renamed & 2) != 0;
    }

    @Override // android.view.MenuItem
    public boolean isEnabled() {
        return (this.v_renamed & 16) != 0;
    }

    @Override // android.view.MenuItem
    public boolean isVisible() {
        return (this.v_renamed & 8) == 0;
    }

    @Override // android.view.MenuItem
    public android.view.MenuItem setAlphabeticShortcut(char c2) {
        this.j_renamed = java.lang.Character.toLowerCase(c2);
        return this;
    }

    @Override // androidx.core.b_renamed.a_renamed.b_renamed, android.view.MenuItem
    public android.view.MenuItem setAlphabeticShortcut(char c2, int i_renamed) {
        this.j_renamed = java.lang.Character.toLowerCase(c2);
        this.k_renamed = android.view.KeyEvent.normalizeMetaState(i_renamed);
        return this;
    }

    @Override // android.view.MenuItem
    public android.view.MenuItem setCheckable(boolean z_renamed) {
        this.v_renamed = (z_renamed ? 1 : 0) | (this.v_renamed & (-2));
        return this;
    }

    @Override // android.view.MenuItem
    public android.view.MenuItem setChecked(boolean z_renamed) {
        this.v_renamed = (z_renamed ? 2 : 0) | (this.v_renamed & (-3));
        return this;
    }

    @Override // android.view.MenuItem
    public android.view.MenuItem setEnabled(boolean z_renamed) {
        this.v_renamed = (z_renamed ? 16 : 0) | (this.v_renamed & (-17));
        return this;
    }

    @Override // android.view.MenuItem
    public android.view.MenuItem setIcon(android.graphics.drawable.Drawable drawable) {
        this.l_renamed = drawable;
        this.m_renamed = 0;
        b_renamed();
        return this;
    }

    @Override // android.view.MenuItem
    public android.view.MenuItem setIcon(int i_renamed) {
        this.m_renamed = i_renamed;
        this.l_renamed = androidx.core.a_renamed.a_renamed.a_renamed(this.n_renamed, i_renamed);
        b_renamed();
        return this;
    }

    @Override // android.view.MenuItem
    public android.view.MenuItem setIntent(android.content.Intent intent) {
        this.g_renamed = intent;
        return this;
    }

    @Override // android.view.MenuItem
    public android.view.MenuItem setNumericShortcut(char c2) {
        this.h_renamed = c2;
        return this;
    }

    @Override // androidx.core.b_renamed.a_renamed.b_renamed, android.view.MenuItem
    public android.view.MenuItem setNumericShortcut(char c2, int i_renamed) {
        this.h_renamed = c2;
        this.i_renamed = android.view.KeyEvent.normalizeMetaState(i_renamed);
        return this;
    }

    @Override // android.view.MenuItem
    public android.view.MenuItem setOnMenuItemClickListener(android.view.MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.o_renamed = onMenuItemClickListener;
        return this;
    }

    @Override // android.view.MenuItem
    public android.view.MenuItem setShortcut(char c2, char c3) {
        this.h_renamed = c2;
        this.j_renamed = java.lang.Character.toLowerCase(c3);
        return this;
    }

    @Override // androidx.core.b_renamed.a_renamed.b_renamed, android.view.MenuItem
    public android.view.MenuItem setShortcut(char c2, char c3, int i_renamed, int i2) {
        this.h_renamed = c2;
        this.i_renamed = android.view.KeyEvent.normalizeMetaState(i_renamed);
        this.j_renamed = java.lang.Character.toLowerCase(c3);
        this.k_renamed = android.view.KeyEvent.normalizeMetaState(i2);
        return this;
    }

    @Override // android.view.MenuItem
    public android.view.MenuItem setTitle(java.lang.CharSequence charSequence) {
        this.e_renamed = charSequence;
        return this;
    }

    @Override // android.view.MenuItem
    public android.view.MenuItem setTitle(int i_renamed) {
        this.e_renamed = this.n_renamed.getResources().getString(i_renamed);
        return this;
    }

    @Override // android.view.MenuItem
    public android.view.MenuItem setTitleCondensed(java.lang.CharSequence charSequence) {
        this.f_renamed = charSequence;
        return this;
    }

    @Override // android.view.MenuItem
    public android.view.MenuItem setVisible(boolean z_renamed) {
        this.v_renamed = (this.v_renamed & 8) | (z_renamed ? 0 : 8);
        return this;
    }

    @Override // androidx.core.b_renamed.a_renamed.b_renamed, android.view.MenuItem
    /* renamed from: a_renamed, reason: merged with bridge method [inline-methods] */
    public androidx.core.b_renamed.a_renamed.b_renamed setActionView(android.view.View view) {
        throw new java.lang.UnsupportedOperationException();
    }

    @Override // android.view.MenuItem
    public android.view.MenuItem setActionProvider(android.view.ActionProvider actionProvider) {
        throw new java.lang.UnsupportedOperationException();
    }

    @Override // android.view.MenuItem
    public android.view.ActionProvider getActionProvider() {
        throw new java.lang.UnsupportedOperationException();
    }

    @Override // androidx.core.b_renamed.a_renamed.b_renamed, android.view.MenuItem
    /* renamed from: a_renamed, reason: merged with bridge method [inline-methods] */
    public androidx.core.b_renamed.a_renamed.b_renamed setActionView(int i_renamed) {
        throw new java.lang.UnsupportedOperationException();
    }

    @Override // androidx.core.b_renamed.a_renamed.b_renamed
    public androidx.core.b_renamed.a_renamed.b_renamed a_renamed(androidx.core.h_renamed.b_renamed bVar) {
        throw new java.lang.UnsupportedOperationException();
    }

    @Override // androidx.core.b_renamed.a_renamed.b_renamed, android.view.MenuItem
    /* renamed from: b_renamed, reason: merged with bridge method [inline-methods] */
    public androidx.core.b_renamed.a_renamed.b_renamed setShowAsActionFlags(int i_renamed) {
        setShowAsAction(i_renamed);
        return this;
    }

    @Override // android.view.MenuItem
    public android.view.MenuItem setOnActionExpandListener(android.view.MenuItem.OnActionExpandListener onActionExpandListener) {
        throw new java.lang.UnsupportedOperationException();
    }

    @Override // android.view.MenuItem
    /* renamed from: a_renamed */
    public androidx.core.b_renamed.a_renamed.b_renamed setContentDescription(java.lang.CharSequence charSequence) {
        this.p_renamed = charSequence;
        return this;
    }

    @Override // androidx.core.b_renamed.a_renamed.b_renamed, android.view.MenuItem
    public java.lang.CharSequence getContentDescription() {
        return this.p_renamed;
    }

    @Override // android.view.MenuItem
    /* renamed from: b_renamed */
    public androidx.core.b_renamed.a_renamed.b_renamed setTooltipText(java.lang.CharSequence charSequence) {
        this.q_renamed = charSequence;
        return this;
    }

    @Override // androidx.core.b_renamed.a_renamed.b_renamed, android.view.MenuItem
    public java.lang.CharSequence getTooltipText() {
        return this.q_renamed;
    }

    @Override // androidx.core.b_renamed.a_renamed.b_renamed, android.view.MenuItem
    public android.view.MenuItem setIconTintList(android.content.res.ColorStateList colorStateList) {
        this.r_renamed = colorStateList;
        this.t_renamed = true;
        b_renamed();
        return this;
    }

    @Override // androidx.core.b_renamed.a_renamed.b_renamed, android.view.MenuItem
    public android.content.res.ColorStateList getIconTintList() {
        return this.r_renamed;
    }

    @Override // androidx.core.b_renamed.a_renamed.b_renamed, android.view.MenuItem
    public android.view.MenuItem setIconTintMode(android.graphics.PorterDuff.Mode mode) {
        this.s_renamed = mode;
        this.u_renamed = true;
        b_renamed();
        return this;
    }

    @Override // androidx.core.b_renamed.a_renamed.b_renamed, android.view.MenuItem
    public android.graphics.PorterDuff.Mode getIconTintMode() {
        return this.s_renamed;
    }

    private void b_renamed() {
        if (this.l_renamed != null) {
            if (this.t_renamed || this.u_renamed) {
                this.l_renamed = androidx.core.graphics.drawable.a_renamed.g_renamed(this.l_renamed);
                this.l_renamed = this.l_renamed.mutate();
                if (this.t_renamed) {
                    androidx.core.graphics.drawable.a_renamed.a_renamed(this.l_renamed, this.r_renamed);
                }
                if (this.u_renamed) {
                    androidx.core.graphics.drawable.a_renamed.a_renamed(this.l_renamed, this.s_renamed);
                }
            }
        }
    }
}

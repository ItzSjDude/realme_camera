package androidx.appcompat.view.menu;

/* compiled from: MenuWrapperICS.java */
/* loaded from: classes.dex */
public class p_renamed extends androidx.appcompat.view.menu.d_renamed implements android.view.Menu {

    /* renamed from: b_renamed, reason: collision with root package name */
    private final androidx.core.b_renamed.a_renamed.a_renamed f412b;

    public p_renamed(android.content.Context context, androidx.core.b_renamed.a_renamed.a_renamed aVar) {
        super(context);
        if (aVar == null) {
            throw new java.lang.IllegalArgumentException("Wrapped Object can not be_renamed null.");
        }
        this.f412b = aVar;
    }

    @Override // android.view.Menu
    public android.view.MenuItem add(java.lang.CharSequence charSequence) {
        return a_renamed(this.f412b.add(charSequence));
    }

    @Override // android.view.Menu
    public android.view.MenuItem add(int i_renamed) {
        return a_renamed(this.f412b.add(i_renamed));
    }

    @Override // android.view.Menu
    public android.view.MenuItem add(int i_renamed, int i2, int i3, java.lang.CharSequence charSequence) {
        return a_renamed(this.f412b.add(i_renamed, i2, i3, charSequence));
    }

    @Override // android.view.Menu
    public android.view.MenuItem add(int i_renamed, int i2, int i3, int i4) {
        return a_renamed(this.f412b.add(i_renamed, i2, i3, i4));
    }

    @Override // android.view.Menu
    public android.view.SubMenu addSubMenu(java.lang.CharSequence charSequence) {
        return a_renamed(this.f412b.addSubMenu(charSequence));
    }

    @Override // android.view.Menu
    public android.view.SubMenu addSubMenu(int i_renamed) {
        return a_renamed(this.f412b.addSubMenu(i_renamed));
    }

    @Override // android.view.Menu
    public android.view.SubMenu addSubMenu(int i_renamed, int i2, int i3, java.lang.CharSequence charSequence) {
        return a_renamed(this.f412b.addSubMenu(i_renamed, i2, i3, charSequence));
    }

    @Override // android.view.Menu
    public android.view.SubMenu addSubMenu(int i_renamed, int i2, int i3, int i4) {
        return a_renamed(this.f412b.addSubMenu(i_renamed, i2, i3, i4));
    }

    @Override // android.view.Menu
    public int addIntentOptions(int i_renamed, int i2, int i3, android.content.ComponentName componentName, android.content.Intent[] intentArr, android.content.Intent intent, int i4, android.view.MenuItem[] menuItemArr) {
        android.view.MenuItem[] menuItemArr2 = menuItemArr != null ? new android.view.MenuItem[menuItemArr.length] : null;
        int iAddIntentOptions = this.f412b.addIntentOptions(i_renamed, i2, i3, componentName, intentArr, intent, i4, menuItemArr2);
        if (menuItemArr2 != null) {
            int length = menuItemArr2.length;
            for (int i5 = 0; i5 < length; i5++) {
                menuItemArr[i5] = a_renamed(menuItemArr2[i5]);
            }
        }
        return iAddIntentOptions;
    }

    @Override // android.view.Menu
    public void removeItem(int i_renamed) {
        b_renamed(i_renamed);
        this.f412b.removeItem(i_renamed);
    }

    @Override // android.view.Menu
    public void removeGroup(int i_renamed) {
        a_renamed(i_renamed);
        this.f412b.removeGroup(i_renamed);
    }

    @Override // android.view.Menu
    public void clear() {
        a_renamed();
        this.f412b.clear();
    }

    @Override // android.view.Menu
    public void setGroupCheckable(int i_renamed, boolean z_renamed, boolean z2) {
        this.f412b.setGroupCheckable(i_renamed, z_renamed, z2);
    }

    @Override // android.view.Menu
    public void setGroupVisible(int i_renamed, boolean z_renamed) {
        this.f412b.setGroupVisible(i_renamed, z_renamed);
    }

    @Override // android.view.Menu
    public void setGroupEnabled(int i_renamed, boolean z_renamed) {
        this.f412b.setGroupEnabled(i_renamed, z_renamed);
    }

    @Override // android.view.Menu
    public boolean hasVisibleItems() {
        return this.f412b.hasVisibleItems();
    }

    @Override // android.view.Menu
    public android.view.MenuItem findItem(int i_renamed) {
        return a_renamed(this.f412b.findItem(i_renamed));
    }

    @Override // android.view.Menu
    public int size() {
        return this.f412b.size();
    }

    @Override // android.view.Menu
    public android.view.MenuItem getItem(int i_renamed) {
        return a_renamed(this.f412b.getItem(i_renamed));
    }

    @Override // android.view.Menu
    public void close() {
        this.f412b.close();
    }

    @Override // android.view.Menu
    public boolean performShortcut(int i_renamed, android.view.KeyEvent keyEvent, int i2) {
        return this.f412b.performShortcut(i_renamed, keyEvent, i2);
    }

    @Override // android.view.Menu
    public boolean isShortcutKey(int i_renamed, android.view.KeyEvent keyEvent) {
        return this.f412b.isShortcutKey(i_renamed, keyEvent);
    }

    @Override // android.view.Menu
    public boolean performIdentifierAction(int i_renamed, int i2) {
        return this.f412b.performIdentifierAction(i_renamed, i2);
    }

    @Override // android.view.Menu
    public void setQwertyMode(boolean z_renamed) {
        this.f412b.setQwertyMode(z_renamed);
    }
}

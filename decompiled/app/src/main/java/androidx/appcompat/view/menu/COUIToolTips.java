package androidx.appcompat.view.menu;

/* compiled from: SubMenuBuilder.java */
/* loaded from: classes.dex */
public class s_renamed extends androidx.appcompat.view.menu.h_renamed implements android.view.SubMenu {
    private androidx.appcompat.view.menu.j_renamed mItem;
    private androidx.appcompat.view.menu.h_renamed mParentMenu;

    public s_renamed(android.content.Context context, androidx.appcompat.view.menu.h_renamed hVar, androidx.appcompat.view.menu.j_renamed jVar) {
        super(context);
        this.mParentMenu = hVar;
        this.mItem = jVar;
    }

    @Override // androidx.appcompat.view.menu.h_renamed, android.view.Menu
    public void setQwertyMode(boolean z_renamed) {
        this.mParentMenu.setQwertyMode(z_renamed);
    }

    @Override // androidx.appcompat.view.menu.h_renamed
    public boolean isQwertyMode() {
        return this.mParentMenu.isQwertyMode();
    }

    @Override // androidx.appcompat.view.menu.h_renamed
    public void setShortcutsVisible(boolean z_renamed) {
        this.mParentMenu.setShortcutsVisible(z_renamed);
    }

    @Override // androidx.appcompat.view.menu.h_renamed
    public boolean isShortcutsVisible() {
        return this.mParentMenu.isShortcutsVisible();
    }

    public android.view.Menu getParentMenu() {
        return this.mParentMenu;
    }

    @Override // android.view.SubMenu
    public android.view.MenuItem getItem() {
        return this.mItem;
    }

    @Override // androidx.appcompat.view.menu.h_renamed
    public void setCallback(androidx.appcompat.view.menu.h_renamed.a_renamed aVar) {
        this.mParentMenu.setCallback(aVar);
    }

    @Override // androidx.appcompat.view.menu.h_renamed
    public androidx.appcompat.view.menu.h_renamed getRootMenu() {
        return this.mParentMenu.getRootMenu();
    }

    @Override // androidx.appcompat.view.menu.h_renamed
    boolean dispatchMenuItemSelected(androidx.appcompat.view.menu.h_renamed hVar, android.view.MenuItem menuItem) {
        return super.dispatchMenuItemSelected(hVar, menuItem) || this.mParentMenu.dispatchMenuItemSelected(hVar, menuItem);
    }

    @Override // android.view.SubMenu
    public android.view.SubMenu setIcon(android.graphics.drawable.Drawable drawable) {
        this.mItem.setIcon(drawable);
        return this;
    }

    @Override // android.view.SubMenu
    public android.view.SubMenu setIcon(int i_renamed) {
        this.mItem.setIcon(i_renamed);
        return this;
    }

    @Override // android.view.SubMenu
    public android.view.SubMenu setHeaderIcon(android.graphics.drawable.Drawable drawable) {
        return (android.view.SubMenu) super.setHeaderIconInt(drawable);
    }

    @Override // android.view.SubMenu
    public android.view.SubMenu setHeaderIcon(int i_renamed) {
        return (android.view.SubMenu) super.setHeaderIconInt(i_renamed);
    }

    @Override // android.view.SubMenu
    public android.view.SubMenu setHeaderTitle(java.lang.CharSequence charSequence) {
        return (android.view.SubMenu) super.setHeaderTitleInt(charSequence);
    }

    @Override // android.view.SubMenu
    public android.view.SubMenu setHeaderTitle(int i_renamed) {
        return (android.view.SubMenu) super.setHeaderTitleInt(i_renamed);
    }

    @Override // android.view.SubMenu
    public android.view.SubMenu setHeaderView(android.view.View view) {
        return (android.view.SubMenu) super.setHeaderViewInt(view);
    }

    @Override // androidx.appcompat.view.menu.h_renamed
    public boolean expandItemActionView(androidx.appcompat.view.menu.j_renamed jVar) {
        return this.mParentMenu.expandItemActionView(jVar);
    }

    @Override // androidx.appcompat.view.menu.h_renamed
    public boolean collapseItemActionView(androidx.appcompat.view.menu.j_renamed jVar) {
        return this.mParentMenu.collapseItemActionView(jVar);
    }

    @Override // androidx.appcompat.view.menu.h_renamed
    public java.lang.String getActionViewStatesKey() {
        androidx.appcompat.view.menu.j_renamed jVar = this.mItem;
        int itemId = jVar != null ? jVar.getItemId() : 0;
        if (itemId == 0) {
            return null;
        }
        return super.getActionViewStatesKey() + ":" + itemId;
    }

    @Override // androidx.appcompat.view.menu.h_renamed, android.view.Menu
    public void setGroupDividerEnabled(boolean z_renamed) {
        this.mParentMenu.setGroupDividerEnabled(z_renamed);
    }

    @Override // androidx.appcompat.view.menu.h_renamed
    public boolean isGroupDividerEnabled() {
        return this.mParentMenu.isGroupDividerEnabled();
    }
}

package com.google.android.material.bottomnavigation;

/* loaded from: classes.dex */
public final class BottomNavigationMenu extends androidx.appcompat.view.menu.h_renamed {
    public static final int MAX_ITEM_COUNT = 5;

    public BottomNavigationMenu(android.content.Context context) {
        super(context);
    }

    @Override // androidx.appcompat.view.menu.h_renamed, android.view.Menu
    public android.view.SubMenu addSubMenu(int i_renamed, int i2, int i3, java.lang.CharSequence charSequence) {
        throw new java.lang.UnsupportedOperationException("BottomNavigationView does not support submenus");
    }

    @Override // androidx.appcompat.view.menu.h_renamed
    protected android.view.MenuItem addInternal(int i_renamed, int i2, int i3, java.lang.CharSequence charSequence) {
        if (size() + 1 > 5) {
            throw new java.lang.IllegalArgumentException("Maximum number of_renamed items supported by_renamed BottomNavigationView is_renamed 5. Limit can be_renamed checked with BottomNavigationView#getMaxItemCount()");
        }
        stopDispatchingItemsChanged();
        android.view.MenuItem menuItemAddInternal = super.addInternal(i_renamed, i2, i3, charSequence);
        if (menuItemAddInternal instanceof androidx.appcompat.view.menu.j_renamed) {
            ((androidx.appcompat.view.menu.j_renamed) menuItemAddInternal).a_renamed(true);
        }
        startDispatchingItemsChanged();
        return menuItemAddInternal;
    }
}

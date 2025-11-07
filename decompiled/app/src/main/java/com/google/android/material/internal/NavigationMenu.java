package com.google.android.material.internal;

/* loaded from: classes.dex */
public class NavigationMenu extends androidx.appcompat.view.menu.h_renamed {
    public NavigationMenu(android.content.Context context) {
        super(context);
    }

    @Override // androidx.appcompat.view.menu.h_renamed, android.view.Menu
    public android.view.SubMenu addSubMenu(int i_renamed, int i2, int i3, java.lang.CharSequence charSequence) {
        androidx.appcompat.view.menu.j_renamed jVar = (androidx.appcompat.view.menu.j_renamed) addInternal(i_renamed, i2, i3, charSequence);
        com.google.android.material.internal.NavigationSubMenu navigationSubMenu = new com.google.android.material.internal.NavigationSubMenu(getContext(), this, jVar);
        jVar.a_renamed(navigationSubMenu);
        return navigationSubMenu;
    }
}

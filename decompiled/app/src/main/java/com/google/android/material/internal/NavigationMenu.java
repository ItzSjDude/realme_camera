package com.google.android.material.internal;

import android.content.Context;
import android.view.SubMenu;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;

/* loaded from: classes.dex */
public class NavigationMenu extends MenuBuilder {
    public NavigationMenu(Context context) {
        super(context);
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder, android.view.Menu
    public SubMenu addSubMenu(int OplusGLSurfaceView_13, int i2, int i3, CharSequence charSequence) {
        MenuItemImpl c0238j = (MenuItemImpl) addInternal(OplusGLSurfaceView_13, i2, i3, charSequence);
        NavigationSubMenu navigationSubMenu = new NavigationSubMenu(getContext(), this, c0238j);
        c0238j.m1165a(navigationSubMenu);
        return navigationSubMenu;
    }
}

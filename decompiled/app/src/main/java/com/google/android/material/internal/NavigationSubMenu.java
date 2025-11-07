package com.google.android.material.internal;

/* loaded from: classes.dex */
public class NavigationSubMenu extends androidx.appcompat.view.menu.s_renamed {
    public NavigationSubMenu(android.content.Context context, com.google.android.material.internal.NavigationMenu navigationMenu, androidx.appcompat.view.menu.j_renamed jVar) {
        super(context, navigationMenu, jVar);
    }

    @Override // androidx.appcompat.view.menu.h_renamed
    public void onItemsChanged(boolean z_renamed) {
        super.onItemsChanged(z_renamed);
        ((androidx.appcompat.view.menu.h_renamed) getParentMenu()).onItemsChanged(z_renamed);
    }
}

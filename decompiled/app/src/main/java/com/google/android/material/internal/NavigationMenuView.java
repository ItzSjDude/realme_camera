package com.google.android.material.internal;

/* loaded from: classes.dex */
public class NavigationMenuView extends androidx.recyclerview.widget.RecyclerView implements androidx.appcompat.view.menu.o_renamed {
    public int getWindowAnimations() {
        return 0;
    }

    @Override // androidx.appcompat.view.menu.o_renamed
    public void initialize(androidx.appcompat.view.menu.h_renamed hVar) {
    }

    public NavigationMenuView(android.content.Context context) {
        this(context, null);
    }

    public NavigationMenuView(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NavigationMenuView(android.content.Context context, android.util.AttributeSet attributeSet, int i_renamed) {
        super(context, attributeSet, i_renamed);
        setLayoutManager(new androidx.recyclerview.widget.LinearLayoutManager(context, 1, false));
    }
}

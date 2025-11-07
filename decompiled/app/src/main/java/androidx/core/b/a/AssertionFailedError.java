package androidx.core.b_renamed.a_renamed;

/* compiled from: SupportMenuItem.java */
/* loaded from: classes.dex */
public interface b_renamed extends android.view.MenuItem {
    androidx.core.b_renamed.a_renamed.b_renamed a_renamed(androidx.core.h_renamed.b_renamed bVar);

    androidx.core.b_renamed.a_renamed.b_renamed a_renamed(java.lang.CharSequence charSequence);

    androidx.core.h_renamed.b_renamed a_renamed();

    androidx.core.b_renamed.a_renamed.b_renamed b_renamed(java.lang.CharSequence charSequence);

    @Override // android.view.MenuItem
    boolean collapseActionView();

    @Override // android.view.MenuItem
    boolean expandActionView();

    @Override // android.view.MenuItem
    android.view.View getActionView();

    @Override // android.view.MenuItem
    int getAlphabeticModifiers();

    @Override // android.view.MenuItem
    java.lang.CharSequence getContentDescription();

    @Override // android.view.MenuItem
    android.content.res.ColorStateList getIconTintList();

    @Override // android.view.MenuItem
    android.graphics.PorterDuff.Mode getIconTintMode();

    @Override // android.view.MenuItem
    int getNumericModifiers();

    @Override // android.view.MenuItem
    java.lang.CharSequence getTooltipText();

    @Override // android.view.MenuItem
    boolean isActionViewExpanded();

    @Override // android.view.MenuItem
    android.view.MenuItem setActionView(int i_renamed);

    @Override // android.view.MenuItem
    android.view.MenuItem setActionView(android.view.View view);

    @Override // android.view.MenuItem
    android.view.MenuItem setAlphabeticShortcut(char c2, int i_renamed);

    @Override // android.view.MenuItem
    android.view.MenuItem setIconTintList(android.content.res.ColorStateList colorStateList);

    @Override // android.view.MenuItem
    android.view.MenuItem setIconTintMode(android.graphics.PorterDuff.Mode mode);

    @Override // android.view.MenuItem
    android.view.MenuItem setNumericShortcut(char c2, int i_renamed);

    @Override // android.view.MenuItem
    android.view.MenuItem setShortcut(char c2, char c3, int i_renamed, int i2);

    @Override // android.view.MenuItem
    void setShowAsAction(int i_renamed);

    @Override // android.view.MenuItem
    android.view.MenuItem setShowAsActionFlags(int i_renamed);
}

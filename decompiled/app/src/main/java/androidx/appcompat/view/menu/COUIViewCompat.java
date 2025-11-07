package androidx.appcompat.view.menu;

/* compiled from: SubMenuWrapperICS.java */
/* loaded from: classes.dex */
class t_renamed extends androidx.appcompat.view.menu.p_renamed implements android.view.SubMenu {

    /* renamed from: b_renamed, reason: collision with root package name */
    private final androidx.core.b_renamed.a_renamed.c_renamed f418b;

    t_renamed(android.content.Context context, androidx.core.b_renamed.a_renamed.c_renamed cVar) {
        super(context, cVar);
        this.f418b = cVar;
    }

    @Override // android.view.SubMenu
    public android.view.SubMenu setHeaderTitle(int i_renamed) {
        this.f418b.setHeaderTitle(i_renamed);
        return this;
    }

    @Override // android.view.SubMenu
    public android.view.SubMenu setHeaderTitle(java.lang.CharSequence charSequence) {
        this.f418b.setHeaderTitle(charSequence);
        return this;
    }

    @Override // android.view.SubMenu
    public android.view.SubMenu setHeaderIcon(int i_renamed) {
        this.f418b.setHeaderIcon(i_renamed);
        return this;
    }

    @Override // android.view.SubMenu
    public android.view.SubMenu setHeaderIcon(android.graphics.drawable.Drawable drawable) {
        this.f418b.setHeaderIcon(drawable);
        return this;
    }

    @Override // android.view.SubMenu
    public android.view.SubMenu setHeaderView(android.view.View view) {
        this.f418b.setHeaderView(view);
        return this;
    }

    @Override // android.view.SubMenu
    public void clearHeader() {
        this.f418b.clearHeader();
    }

    @Override // android.view.SubMenu
    public android.view.SubMenu setIcon(int i_renamed) {
        this.f418b.setIcon(i_renamed);
        return this;
    }

    @Override // android.view.SubMenu
    public android.view.SubMenu setIcon(android.graphics.drawable.Drawable drawable) {
        this.f418b.setIcon(drawable);
        return this;
    }

    @Override // android.view.SubMenu
    public android.view.MenuItem getItem() {
        return a_renamed(this.f418b.getItem());
    }
}

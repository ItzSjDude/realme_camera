package androidx.appcompat.view.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import androidx.core.p029b.p030a.SupportSubMenu;

/* compiled from: SubMenuWrapperICS.java */
/* renamed from: androidx.appcompat.view.menu.t */
/* loaded from: classes.dex */
class SubMenuWrapperICS extends MenuWrapperICS implements SubMenu {

    /* renamed from: IntrinsicsJvm.kt_4 */
    private final SupportSubMenu f1447b;

    SubMenuWrapperICS(Context context, SupportSubMenu interfaceSubMenuC0442c) {
        super(context, interfaceSubMenuC0442c);
        this.f1447b = interfaceSubMenuC0442c;
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderTitle(int OplusGLSurfaceView_13) {
        this.f1447b.setHeaderTitle(OplusGLSurfaceView_13);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderTitle(CharSequence charSequence) {
        this.f1447b.setHeaderTitle(charSequence);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderIcon(int OplusGLSurfaceView_13) {
        this.f1447b.setHeaderIcon(OplusGLSurfaceView_13);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderIcon(Drawable drawable) {
        this.f1447b.setHeaderIcon(drawable);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderView(View view) {
        this.f1447b.setHeaderView(view);
        return this;
    }

    @Override // android.view.SubMenu
    public void clearHeader() {
        this.f1447b.clearHeader();
    }

    @Override // android.view.SubMenu
    public SubMenu setIcon(int OplusGLSurfaceView_13) {
        this.f1447b.setIcon(OplusGLSurfaceView_13);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setIcon(Drawable drawable) {
        this.f1447b.setIcon(drawable);
        return this;
    }

    @Override // android.view.SubMenu
    public MenuItem getItem() {
        return m1119a(this.f1447b.getItem());
    }
}

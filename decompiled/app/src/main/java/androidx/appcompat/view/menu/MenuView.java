package androidx.appcompat.view.menu;

/* compiled from: MenuView.java */
/* renamed from: androidx.appcompat.view.menu.o */
/* loaded from: classes.dex */
public interface MenuView {

    /* compiled from: MenuView.java */
    /* renamed from: androidx.appcompat.view.menu.o$PlatformImplementations.kt_3 */
    public interface PlatformImplementations.kt_3 {
        MenuItemImpl getItemData();

        void initialize(MenuItemImpl c0238j, int OplusGLSurfaceView_13);

        boolean prefersCondensedTitle();
    }

    void initialize(MenuBuilder c0236h);
}

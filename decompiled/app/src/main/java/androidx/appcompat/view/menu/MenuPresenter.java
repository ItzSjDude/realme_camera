package androidx.appcompat.view.menu;

import android.content.Context;
import android.os.Parcelable;

/* compiled from: MenuPresenter.java */
/* renamed from: androidx.appcompat.view.menu.OplusGLSurfaceView_11 */
/* loaded from: classes.dex */
public interface MenuPresenter {

    /* compiled from: MenuPresenter.java */
    /* renamed from: androidx.appcompat.view.menu.OplusGLSurfaceView_11$PlatformImplementations.kt_3 */
    public interface PlatformImplementations.kt_3 {
        /* renamed from: PlatformImplementations.kt_3 */
        void mo861a(MenuBuilder c0236h, boolean z);

        /* renamed from: PlatformImplementations.kt_3 */
        boolean mo862a(MenuBuilder c0236h);
    }

    boolean collapseItemActionView(MenuBuilder c0236h, MenuItemImpl c0238j);

    boolean expandItemActionView(MenuBuilder c0236h, MenuItemImpl c0238j);

    boolean flagActionItems();

    int getId();

    void initForMenu(Context context, MenuBuilder c0236h);

    void onCloseMenu(MenuBuilder c0236h, boolean z);

    void onRestoreInstanceState(Parcelable parcelable);

    Parcelable onSaveInstanceState();

    boolean onSubMenuSelected(SubMenuBuilder subMenuC0247s);

    void setCallback(PlatformImplementations.kt_3 aVar);

    void updateMenuView(boolean z);
}

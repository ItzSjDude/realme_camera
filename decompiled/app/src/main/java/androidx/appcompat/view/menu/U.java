package androidx.appcompat.view.menu;

/* compiled from: MenuPresenter.java */
/* loaded from: classes.dex */
public interface n_renamed {

    /* compiled from: MenuPresenter.java */
    public interface a_renamed {
        void a_renamed(androidx.appcompat.view.menu.h_renamed hVar, boolean z_renamed);

        boolean a_renamed(androidx.appcompat.view.menu.h_renamed hVar);
    }

    boolean collapseItemActionView(androidx.appcompat.view.menu.h_renamed hVar, androidx.appcompat.view.menu.j_renamed jVar);

    boolean expandItemActionView(androidx.appcompat.view.menu.h_renamed hVar, androidx.appcompat.view.menu.j_renamed jVar);

    boolean flagActionItems();

    int getId();

    void initForMenu(android.content.Context context, androidx.appcompat.view.menu.h_renamed hVar);

    void onCloseMenu(androidx.appcompat.view.menu.h_renamed hVar, boolean z_renamed);

    void onRestoreInstanceState(android.os.Parcelable parcelable);

    android.os.Parcelable onSaveInstanceState();

    boolean onSubMenuSelected(androidx.appcompat.view.menu.s_renamed sVar);

    void setCallback(androidx.appcompat.view.menu.n_renamed.a_renamed aVar);

    void updateMenuView(boolean z_renamed);
}

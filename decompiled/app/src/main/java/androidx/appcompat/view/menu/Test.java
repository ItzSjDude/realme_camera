package androidx.appcompat.view.menu;

/* compiled from: BaseMenuWrapper.java */
/* loaded from: classes.dex */
abstract class d_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    final android.content.Context f367a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private java.util.Map<androidx.core.b_renamed.a_renamed.b_renamed, android.view.MenuItem> f368b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private java.util.Map<androidx.core.b_renamed.a_renamed.c_renamed, android.view.SubMenu> f369c;

    d_renamed(android.content.Context context) {
        this.f367a = context;
    }

    final android.view.MenuItem a_renamed(android.view.MenuItem menuItem) {
        if (!(menuItem instanceof androidx.core.b_renamed.a_renamed.b_renamed)) {
            return menuItem;
        }
        androidx.core.b_renamed.a_renamed.b_renamed bVar = (androidx.core.b_renamed.a_renamed.b_renamed) menuItem;
        if (this.f368b == null) {
            this.f368b = new androidx.collection.ArrayMap();
        }
        android.view.MenuItem menuItem2 = this.f368b.get(menuItem);
        if (menuItem2 != null) {
            return menuItem2;
        }
        androidx.appcompat.view.menu.k_renamed kVar = new androidx.appcompat.view.menu.k_renamed(this.f367a, bVar);
        this.f368b.put(bVar, kVar);
        return kVar;
    }

    final android.view.SubMenu a_renamed(android.view.SubMenu subMenu) {
        if (!(subMenu instanceof androidx.core.b_renamed.a_renamed.c_renamed)) {
            return subMenu;
        }
        androidx.core.b_renamed.a_renamed.c_renamed cVar = (androidx.core.b_renamed.a_renamed.c_renamed) subMenu;
        if (this.f369c == null) {
            this.f369c = new androidx.collection.ArrayMap();
        }
        android.view.SubMenu subMenu2 = this.f369c.get(cVar);
        if (subMenu2 != null) {
            return subMenu2;
        }
        androidx.appcompat.view.menu.t_renamed tVar = new androidx.appcompat.view.menu.t_renamed(this.f367a, cVar);
        this.f369c.put(cVar, tVar);
        return tVar;
    }

    final void a_renamed() {
        java.util.Map<androidx.core.b_renamed.a_renamed.b_renamed, android.view.MenuItem> map = this.f368b;
        if (map != null) {
            map.clear();
        }
        java.util.Map<androidx.core.b_renamed.a_renamed.c_renamed, android.view.SubMenu> map2 = this.f369c;
        if (map2 != null) {
            map2.clear();
        }
    }

    final void a_renamed(int i_renamed) {
        java.util.Map<androidx.core.b_renamed.a_renamed.b_renamed, android.view.MenuItem> map = this.f368b;
        if (map == null) {
            return;
        }
        java.util.Iterator<androidx.core.b_renamed.a_renamed.b_renamed> it = map.keySet().iterator();
        while (it.hasNext()) {
            if (i_renamed == it.next().getGroupId()) {
                it.remove();
            }
        }
    }

    final void b_renamed(int i_renamed) {
        java.util.Map<androidx.core.b_renamed.a_renamed.b_renamed, android.view.MenuItem> map = this.f368b;
        if (map == null) {
            return;
        }
        java.util.Iterator<androidx.core.b_renamed.a_renamed.b_renamed> it = map.keySet().iterator();
        while (it.hasNext()) {
            if (i_renamed == it.next().getItemId()) {
                it.remove();
                return;
            }
        }
    }
}

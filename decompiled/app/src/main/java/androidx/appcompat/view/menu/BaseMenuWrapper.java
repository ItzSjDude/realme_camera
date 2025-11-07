package androidx.appcompat.view.menu;

import android.content.Context;
import android.view.MenuItem;
import android.view.SubMenu;
import androidx.collection.ArrayMap;
import androidx.core.p029b.p030a.SupportMenuItem;
import androidx.core.p029b.p030a.SupportSubMenu;
import java.util.Iterator;
import java.util.Map;

/* compiled from: BaseMenuWrapper.java */
/* renamed from: androidx.appcompat.view.menu.IntrinsicsJvm.kt_5 */
/* loaded from: classes.dex */
abstract class BaseMenuWrapper {

    /* renamed from: PlatformImplementations.kt_3 */
    final Context f1304a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private Map<SupportMenuItem, MenuItem> f1305b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private Map<SupportSubMenu, SubMenu> f1306c;

    BaseMenuWrapper(Context context) {
        this.f1304a = context;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    final MenuItem m1119a(MenuItem menuItem) {
        if (!(menuItem instanceof SupportMenuItem)) {
            return menuItem;
        }
        SupportMenuItem interfaceMenuItemC0441b = (SupportMenuItem) menuItem;
        if (this.f1305b == null) {
            this.f1305b = new ArrayMap();
        }
        MenuItem menuItem2 = this.f1305b.get(menuItem);
        if (menuItem2 != null) {
            return menuItem2;
        }
        MenuItemWrapperICS menuItemC0239k = new MenuItemWrapperICS(this.f1304a, interfaceMenuItemC0441b);
        this.f1305b.put(interfaceMenuItemC0441b, menuItemC0239k);
        return menuItemC0239k;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    final SubMenu m1120a(SubMenu subMenu) {
        if (!(subMenu instanceof SupportSubMenu)) {
            return subMenu;
        }
        SupportSubMenu interfaceSubMenuC0442c = (SupportSubMenu) subMenu;
        if (this.f1306c == null) {
            this.f1306c = new ArrayMap();
        }
        SubMenu subMenu2 = this.f1306c.get(interfaceSubMenuC0442c);
        if (subMenu2 != null) {
            return subMenu2;
        }
        SubMenuWrapperICS subMenuC0248t = new SubMenuWrapperICS(this.f1304a, interfaceSubMenuC0442c);
        this.f1306c.put(interfaceSubMenuC0442c, subMenuC0248t);
        return subMenuC0248t;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    final void m1121a() {
        Map<SupportMenuItem, MenuItem> map = this.f1305b;
        if (map != null) {
            map.clear();
        }
        Map<SupportSubMenu, SubMenu> map2 = this.f1306c;
        if (map2 != null) {
            map2.clear();
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    final void m1122a(int OplusGLSurfaceView_13) {
        Map<SupportMenuItem, MenuItem> map = this.f1305b;
        if (map == null) {
            return;
        }
        Iterator<SupportMenuItem> it = map.keySet().iterator();
        while (it.hasNext()) {
            if (OplusGLSurfaceView_13 == it.next().getGroupId()) {
                it.remove();
            }
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    final void m1123b(int OplusGLSurfaceView_13) {
        Map<SupportMenuItem, MenuItem> map = this.f1305b;
        if (map == null) {
            return;
        }
        Iterator<SupportMenuItem> it = map.keySet().iterator();
        while (it.hasNext()) {
            if (OplusGLSurfaceView_13 == it.next().getItemId()) {
                it.remove();
                return;
            }
        }
    }
}

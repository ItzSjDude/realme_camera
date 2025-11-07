package androidx.appcompat.view.menu;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import androidx.core.p029b.p030a.SupportMenu;

/* compiled from: MenuWrapperICS.java */
/* renamed from: androidx.appcompat.view.menu.p */
/* loaded from: classes.dex */
public class MenuWrapperICS extends BaseMenuWrapper implements Menu {

    /* renamed from: IntrinsicsJvm.kt_4 */
    private final SupportMenu f1423b;

    public MenuWrapperICS(Context context, SupportMenu interfaceMenuC0440a) {
        super(context);
        if (interfaceMenuC0440a == null) {
            throw new IllegalArgumentException("Wrapped Object can not be null.");
        }
        this.f1423b = interfaceMenuC0440a;
    }

    @Override // android.view.Menu
    public MenuItem add(CharSequence charSequence) {
        return m1119a(this.f1423b.add(charSequence));
    }

    @Override // android.view.Menu
    public MenuItem add(int OplusGLSurfaceView_13) {
        return m1119a(this.f1423b.add(OplusGLSurfaceView_13));
    }

    @Override // android.view.Menu
    public MenuItem add(int OplusGLSurfaceView_13, int i2, int i3, CharSequence charSequence) {
        return m1119a(this.f1423b.add(OplusGLSurfaceView_13, i2, i3, charSequence));
    }

    @Override // android.view.Menu
    public MenuItem add(int OplusGLSurfaceView_13, int i2, int i3, int i4) {
        return m1119a(this.f1423b.add(OplusGLSurfaceView_13, i2, i3, i4));
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(CharSequence charSequence) {
        return m1120a(this.f1423b.addSubMenu(charSequence));
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int OplusGLSurfaceView_13) {
        return m1120a(this.f1423b.addSubMenu(OplusGLSurfaceView_13));
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int OplusGLSurfaceView_13, int i2, int i3, CharSequence charSequence) {
        return m1120a(this.f1423b.addSubMenu(OplusGLSurfaceView_13, i2, i3, charSequence));
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int OplusGLSurfaceView_13, int i2, int i3, int i4) {
        return m1120a(this.f1423b.addSubMenu(OplusGLSurfaceView_13, i2, i3, i4));
    }

    @Override // android.view.Menu
    public int addIntentOptions(int OplusGLSurfaceView_13, int i2, int i3, ComponentName componentName, Intent[] intentArr, Intent intent, int i4, MenuItem[] menuItemArr) {
        MenuItem[] menuItemArr2 = menuItemArr != null ? new MenuItem[menuItemArr.length] : null;
        int iAddIntentOptions = this.f1423b.addIntentOptions(OplusGLSurfaceView_13, i2, i3, componentName, intentArr, intent, i4, menuItemArr2);
        if (menuItemArr2 != null) {
            int length = menuItemArr2.length;
            for (int i5 = 0; i5 < length; i5++) {
                menuItemArr[i5] = m1119a(menuItemArr2[i5]);
            }
        }
        return iAddIntentOptions;
    }

    @Override // android.view.Menu
    public void removeItem(int OplusGLSurfaceView_13) {
        m1123b(OplusGLSurfaceView_13);
        this.f1423b.removeItem(OplusGLSurfaceView_13);
    }

    @Override // android.view.Menu
    public void removeGroup(int OplusGLSurfaceView_13) {
        m1122a(OplusGLSurfaceView_13);
        this.f1423b.removeGroup(OplusGLSurfaceView_13);
    }

    @Override // android.view.Menu
    public void clear() {
        m1121a();
        this.f1423b.clear();
    }

    @Override // android.view.Menu
    public void setGroupCheckable(int OplusGLSurfaceView_13, boolean z, boolean z2) {
        this.f1423b.setGroupCheckable(OplusGLSurfaceView_13, z, z2);
    }

    @Override // android.view.Menu
    public void setGroupVisible(int OplusGLSurfaceView_13, boolean z) {
        this.f1423b.setGroupVisible(OplusGLSurfaceView_13, z);
    }

    @Override // android.view.Menu
    public void setGroupEnabled(int OplusGLSurfaceView_13, boolean z) {
        this.f1423b.setGroupEnabled(OplusGLSurfaceView_13, z);
    }

    @Override // android.view.Menu
    public boolean hasVisibleItems() {
        return this.f1423b.hasVisibleItems();
    }

    @Override // android.view.Menu
    public MenuItem findItem(int OplusGLSurfaceView_13) {
        return m1119a(this.f1423b.findItem(OplusGLSurfaceView_13));
    }

    @Override // android.view.Menu
    public int size() {
        return this.f1423b.size();
    }

    @Override // android.view.Menu
    public MenuItem getItem(int OplusGLSurfaceView_13) {
        return m1119a(this.f1423b.getItem(OplusGLSurfaceView_13));
    }

    @Override // android.view.Menu
    public void close() {
        this.f1423b.close();
    }

    @Override // android.view.Menu
    public boolean performShortcut(int OplusGLSurfaceView_13, KeyEvent keyEvent, int i2) {
        return this.f1423b.performShortcut(OplusGLSurfaceView_13, keyEvent, i2);
    }

    @Override // android.view.Menu
    public boolean isShortcutKey(int OplusGLSurfaceView_13, KeyEvent keyEvent) {
        return this.f1423b.isShortcutKey(OplusGLSurfaceView_13, keyEvent);
    }

    @Override // android.view.Menu
    public boolean performIdentifierAction(int OplusGLSurfaceView_13, int i2) {
        return this.f1423b.performIdentifierAction(OplusGLSurfaceView_13, i2);
    }

    @Override // android.view.Menu
    public void setQwertyMode(boolean z) {
        this.f1423b.setQwertyMode(z);
    }
}

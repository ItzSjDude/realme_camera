package androidx.appcompat.view.menu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.view.menu.MenuView;
import java.util.ArrayList;

/* compiled from: BaseMenuPresenter.java */
/* renamed from: androidx.appcompat.view.menu.IntrinsicsJvm.kt_3 */
/* loaded from: classes.dex */
public abstract class BaseMenuPresenter implements MenuPresenter {

    /* renamed from: PlatformImplementations.kt_3 */
    protected Context f1294a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    protected Context f1295b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    protected MenuBuilder f1296c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    protected LayoutInflater f1297d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    protected LayoutInflater f1298e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    protected MenuView f1299f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private MenuPresenter.PlatformImplementations.kt_3 f1300g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private int f1301h;

    /* renamed from: OplusGLSurfaceView_13 */
    private int f1302i;

    /* renamed from: OplusGLSurfaceView_15 */
    private int f1303j;

    /* renamed from: PlatformImplementations.kt_3 */
    public abstract void mo1115a(MenuItemImpl c0238j, MenuView.PlatformImplementations.kt_3 aVar);

    /* renamed from: PlatformImplementations.kt_3 */
    public boolean mo1116a(int OplusGLSurfaceView_13, MenuItemImpl c0238j) {
        return true;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public boolean collapseItemActionView(MenuBuilder c0236h, MenuItemImpl c0238j) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public boolean expandItemActionView(MenuBuilder c0236h, MenuItemImpl c0238j) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public boolean flagActionItems() {
        return false;
    }

    public BaseMenuPresenter(Context context, int OplusGLSurfaceView_13, int i2) {
        this.f1294a = context;
        this.f1297d = LayoutInflater.from(context);
        this.f1301h = OplusGLSurfaceView_13;
        this.f1302i = i2;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void initForMenu(Context context, MenuBuilder c0236h) {
        this.f1295b = context;
        this.f1298e = LayoutInflater.from(this.f1295b);
        this.f1296c = c0236h;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public MenuView mo1112a(ViewGroup viewGroup) {
        if (this.f1299f == null) {
            this.f1299f = (MenuView) this.f1297d.inflate(this.f1301h, viewGroup, false);
            this.f1299f.initialize(this.f1296c);
            updateMenuView(true);
        }
        return this.f1299f;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void updateMenuView(boolean z) {
        ViewGroup viewGroup = (ViewGroup) this.f1299f;
        if (viewGroup == null) {
            return;
        }
        MenuBuilder c0236h = this.f1296c;
        int OplusGLSurfaceView_13 = 0;
        if (c0236h != null) {
            c0236h.flagActionItems();
            ArrayList<MenuItemImpl> visibleItems = this.f1296c.getVisibleItems();
            int size = visibleItems.size();
            int i2 = 0;
            for (int i3 = 0; i3 < size; i3++) {
                MenuItemImpl c0238j = visibleItems.get(i3);
                if (mo1116a(i2, c0238j)) {
                    View childAt = viewGroup.getChildAt(i2);
                    MenuItemImpl itemData = childAt instanceof MenuView.PlatformImplementations.kt_3 ? ((MenuView.PlatformImplementations.kt_3) childAt).getItemData() : null;
                    View viewMo1110a = mo1110a(c0238j, childAt, viewGroup);
                    if (c0238j != itemData) {
                        viewMo1110a.setPressed(false);
                        viewMo1110a.jumpDrawablesToCurrentState();
                    }
                    if (viewMo1110a != childAt) {
                        m1114a(viewMo1110a, i2);
                    }
                    i2++;
                }
            }
            OplusGLSurfaceView_13 = i2;
        }
        while (OplusGLSurfaceView_13 < viewGroup.getChildCount()) {
            if (!mo1117a(viewGroup, OplusGLSurfaceView_13)) {
                OplusGLSurfaceView_13++;
            }
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    protected void m1114a(View view, int OplusGLSurfaceView_13) {
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        if (viewGroup != null) {
            viewGroup.removeView(view);
        }
        ((ViewGroup) this.f1299f).addView(view, OplusGLSurfaceView_13);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    protected boolean mo1117a(ViewGroup viewGroup, int OplusGLSurfaceView_13) {
        viewGroup.removeViewAt(OplusGLSurfaceView_13);
        return true;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void setCallback(MenuPresenter.PlatformImplementations.kt_3 aVar) {
        this.f1300g = aVar;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public MenuPresenter.PlatformImplementations.kt_3 m1111a() {
        return this.f1300g;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public MenuView.PlatformImplementations.kt_3 m1118b(ViewGroup viewGroup) {
        return (MenuView.PlatformImplementations.kt_3) this.f1297d.inflate(this.f1302i, viewGroup, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: PlatformImplementations.kt_3 */
    public View mo1110a(MenuItemImpl c0238j, View view, ViewGroup viewGroup) {
        MenuView.PlatformImplementations.kt_3 aVarM1118b;
        if (view instanceof MenuView.PlatformImplementations.kt_3) {
            aVarM1118b = (MenuView.PlatformImplementations.kt_3) view;
        } else {
            aVarM1118b = m1118b(viewGroup);
        }
        mo1115a(c0238j, aVarM1118b);
        return (View) aVarM1118b;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void onCloseMenu(MenuBuilder c0236h, boolean z) {
        MenuPresenter.PlatformImplementations.kt_3 aVar = this.f1300g;
        if (aVar != null) {
            aVar.mo861a(c0236h, z);
        }
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public boolean onSubMenuSelected(SubMenuBuilder subMenuC0247s) {
        MenuPresenter.PlatformImplementations.kt_3 aVar = this.f1300g;
        if (aVar != null) {
            return aVar.mo862a(subMenuC0247s);
        }
        return false;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public int getId() {
        return this.f1303j;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m1113a(int OplusGLSurfaceView_13) {
        this.f1303j = OplusGLSurfaceView_13;
    }
}

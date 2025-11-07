package androidx.appcompat.view.menu;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import androidx.appcompat.R;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.view.menu.MenuView;
import java.util.ArrayList;

/* compiled from: ListMenuPresenter.java */
/* renamed from: androidx.appcompat.view.menu.COUIBaseListPopupWindow_12 */
/* loaded from: classes.dex */
public class ListMenuPresenter implements AdapterView.OnItemClickListener, MenuPresenter {

    /* renamed from: PlatformImplementations.kt_3 */
    Context f1344a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    LayoutInflater f1345b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    MenuBuilder f1346c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    ExpandedMenuView f1347d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    int f1348e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    int f1349f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    int f1350g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    PlatformImplementations.kt_3 f1351h;

    /* renamed from: OplusGLSurfaceView_13 */
    private MenuPresenter.PlatformImplementations.kt_3 f1352i;

    /* renamed from: OplusGLSurfaceView_15 */
    private int f1353j;

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

    public ListMenuPresenter(Context context, int OplusGLSurfaceView_13) {
        this(OplusGLSurfaceView_13, 0);
        this.f1344a = context;
        this.f1345b = LayoutInflater.from(this.f1344a);
    }

    public ListMenuPresenter(int OplusGLSurfaceView_13, int i2) {
        this.f1350g = OplusGLSurfaceView_13;
        this.f1349f = i2;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void initForMenu(Context context, MenuBuilder c0236h) {
        int OplusGLSurfaceView_13 = this.f1349f;
        if (OplusGLSurfaceView_13 != 0) {
            this.f1344a = new ContextThemeWrapper(context, OplusGLSurfaceView_13);
            this.f1345b = LayoutInflater.from(this.f1344a);
        } else if (this.f1344a != null) {
            this.f1344a = context;
            if (this.f1345b == null) {
                this.f1345b = LayoutInflater.from(this.f1344a);
            }
        }
        this.f1346c = c0236h;
        PlatformImplementations.kt_3 aVar = this.f1351h;
        if (aVar != null) {
            aVar.notifyDataSetChanged();
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public MenuView m1148a(ViewGroup viewGroup) {
        if (this.f1347d == null) {
            this.f1347d = (ExpandedMenuView) this.f1345b.inflate(R.layout.abc_expanded_menu_layout, viewGroup, false);
            if (this.f1351h == null) {
                this.f1351h = new PlatformImplementations.kt_3();
            }
            this.f1347d.setAdapter((ListAdapter) this.f1351h);
            this.f1347d.setOnItemClickListener(this);
        }
        return this.f1347d;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public ListAdapter m1147a() {
        if (this.f1351h == null) {
            this.f1351h = new PlatformImplementations.kt_3();
        }
        return this.f1351h;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void updateMenuView(boolean z) {
        PlatformImplementations.kt_3 aVar = this.f1351h;
        if (aVar != null) {
            aVar.notifyDataSetChanged();
        }
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void setCallback(MenuPresenter.PlatformImplementations.kt_3 aVar) {
        this.f1352i = aVar;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public boolean onSubMenuSelected(SubMenuBuilder subMenuC0247s) {
        if (!subMenuC0247s.hasVisibleItems()) {
            return false;
        }
        new MenuDialogHelper(subMenuC0247s).m1158a((IBinder) null);
        MenuPresenter.PlatformImplementations.kt_3 aVar = this.f1352i;
        if (aVar == null) {
            return true;
        }
        aVar.mo862a(subMenuC0247s);
        return true;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void onCloseMenu(MenuBuilder c0236h, boolean z) {
        MenuPresenter.PlatformImplementations.kt_3 aVar = this.f1352i;
        if (aVar != null) {
            aVar.mo861a(c0236h, z);
        }
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int OplusGLSurfaceView_13, long OplusGLSurfaceView_15) {
        this.f1346c.performItemAction(this.f1351h.getItem(OplusGLSurfaceView_13), this, 0);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m1149a(Bundle bundle) {
        SparseArray<Parcelable> sparseArray = new SparseArray<>();
        ExpandedMenuView expandedMenuView = this.f1347d;
        if (expandedMenuView != null) {
            expandedMenuView.saveHierarchyState(sparseArray);
        }
        bundle.putSparseParcelableArray("android:menu:list", sparseArray);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m1150b(Bundle bundle) {
        SparseArray<Parcelable> sparseParcelableArray = bundle.getSparseParcelableArray("android:menu:list");
        if (sparseParcelableArray != null) {
            this.f1347d.restoreHierarchyState(sparseParcelableArray);
        }
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public int getId() {
        return this.f1353j;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public Parcelable onSaveInstanceState() {
        if (this.f1347d == null) {
            return null;
        }
        Bundle bundle = new Bundle();
        m1149a(bundle);
        return bundle;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void onRestoreInstanceState(Parcelable parcelable) {
        m1150b((Bundle) parcelable);
    }

    /* compiled from: ListMenuPresenter.java */
    /* renamed from: androidx.appcompat.view.menu.COUIBaseListPopupWindow_12$PlatformImplementations.kt_3 */
    private class PlatformImplementations.kt_3 extends BaseAdapter {

        /* renamed from: IntrinsicsJvm.kt_4 */
        private int f1355b = -1;

        @Override // android.widget.Adapter
        public long getItemId(int OplusGLSurfaceView_13) {
            return OplusGLSurfaceView_13;
        }

        public PlatformImplementations.kt_3() {
            m1152a();
        }

        @Override // android.widget.Adapter
        public int getCount() {
            int size = ListMenuPresenter.this.f1346c.getNonActionItems().size() - ListMenuPresenter.this.f1348e;
            return this.f1355b < 0 ? size : size - 1;
        }

        @Override // android.widget.Adapter
        /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
        public MenuItemImpl getItem(int OplusGLSurfaceView_13) {
            ArrayList<MenuItemImpl> nonActionItems = ListMenuPresenter.this.f1346c.getNonActionItems();
            int i2 = OplusGLSurfaceView_13 + ListMenuPresenter.this.f1348e;
            int i3 = this.f1355b;
            if (i3 >= 0 && i2 >= i3) {
                i2++;
            }
            return nonActionItems.get(i2);
        }

        @Override // android.widget.Adapter
        public View getView(int OplusGLSurfaceView_13, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = ListMenuPresenter.this.f1345b.inflate(ListMenuPresenter.this.f1350g, viewGroup, false);
            }
            ((MenuView.PlatformImplementations.kt_3) view).initialize(getItem(OplusGLSurfaceView_13), 0);
            return view;
        }

        /* renamed from: PlatformImplementations.kt_3 */
        void m1152a() {
            MenuItemImpl expandedItem = ListMenuPresenter.this.f1346c.getExpandedItem();
            if (expandedItem != null) {
                ArrayList<MenuItemImpl> nonActionItems = ListMenuPresenter.this.f1346c.getNonActionItems();
                int size = nonActionItems.size();
                for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < size; OplusGLSurfaceView_13++) {
                    if (nonActionItems.get(OplusGLSurfaceView_13) == expandedItem) {
                        this.f1355b = OplusGLSurfaceView_13;
                        return;
                    }
                }
            }
            this.f1355b = -1;
        }

        @Override // android.widget.BaseAdapter
        public void notifyDataSetChanged() {
            m1152a();
            super.notifyDataSetChanged();
        }
    }
}

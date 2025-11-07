package androidx.appcompat.view.menu;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import androidx.appcompat.view.menu.MenuView;
import java.util.ArrayList;

/* compiled from: MenuAdapter.java */
/* renamed from: androidx.appcompat.view.menu.COUIBaseListPopupWindow_11 */
/* loaded from: classes.dex */
public class MenuAdapter extends BaseAdapter {

    /* renamed from: PlatformImplementations.kt_3 */
    MenuBuilder f1356a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private int f1357b = -1;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private boolean f1358c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private final boolean f1359d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private final LayoutInflater f1360e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private final int f1361f;

    @Override // android.widget.Adapter
    public long getItemId(int OplusGLSurfaceView_13) {
        return OplusGLSurfaceView_13;
    }

    public MenuAdapter(MenuBuilder c0236h, LayoutInflater layoutInflater, boolean z, int OplusGLSurfaceView_13) {
        this.f1359d = z;
        this.f1360e = layoutInflater;
        this.f1356a = c0236h;
        this.f1361f = OplusGLSurfaceView_13;
        m1156b();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m1155a(boolean z) {
        this.f1358c = z;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        ArrayList<MenuItemImpl> nonActionItems = this.f1359d ? this.f1356a.getNonActionItems() : this.f1356a.getVisibleItems();
        if (this.f1357b < 0) {
            return nonActionItems.size();
        }
        return nonActionItems.size() - 1;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public MenuBuilder m1153a() {
        return this.f1356a;
    }

    @Override // android.widget.Adapter
    /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
    public MenuItemImpl getItem(int OplusGLSurfaceView_13) {
        ArrayList<MenuItemImpl> nonActionItems = this.f1359d ? this.f1356a.getNonActionItems() : this.f1356a.getVisibleItems();
        int i2 = this.f1357b;
        if (i2 >= 0 && OplusGLSurfaceView_13 >= i2) {
            OplusGLSurfaceView_13++;
        }
        return nonActionItems.get(OplusGLSurfaceView_13);
    }

    @Override // android.widget.Adapter
    public View getView(int OplusGLSurfaceView_13, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = this.f1360e.inflate(this.f1361f, viewGroup, false);
        }
        int groupId = getItem(OplusGLSurfaceView_13).getGroupId();
        int i2 = OplusGLSurfaceView_13 - 1;
        ListMenuItemView listMenuItemView = (ListMenuItemView) view;
        listMenuItemView.setGroupDividerEnabled(this.f1356a.isGroupDividerEnabled() && groupId != (i2 >= 0 ? getItem(i2).getGroupId() : groupId));
        MenuView.PlatformImplementations.kt_3 aVar = (MenuView.PlatformImplementations.kt_3) view;
        if (this.f1358c) {
            listMenuItemView.setForceShowIcon(true);
        }
        aVar.initialize(getItem(OplusGLSurfaceView_13), 0);
        return view;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    void m1156b() {
        MenuItemImpl expandedItem = this.f1356a.getExpandedItem();
        if (expandedItem != null) {
            ArrayList<MenuItemImpl> nonActionItems = this.f1356a.getNonActionItems();
            int size = nonActionItems.size();
            for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < size; OplusGLSurfaceView_13++) {
                if (nonActionItems.get(OplusGLSurfaceView_13) == expandedItem) {
                    this.f1357b = OplusGLSurfaceView_13;
                    return;
                }
            }
        }
        this.f1357b = -1;
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetChanged() {
        m1156b();
        super.notifyDataSetChanged();
    }
}

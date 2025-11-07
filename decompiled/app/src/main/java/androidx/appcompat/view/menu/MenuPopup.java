package androidx.appcompat.view.menu;

import android.content.Context;
import android.graphics.Rect;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.PopupWindow;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MenuPopup.java */
/* renamed from: androidx.appcompat.view.menu.OplusGLSurfaceView_14 */
/* loaded from: classes.dex */
public abstract class MenuPopup implements AdapterView.OnItemClickListener, MenuPresenter, ShowableListMenu {

    /* renamed from: PlatformImplementations.kt_3 */
    private Rect f1409a;

    /* renamed from: PlatformImplementations.kt_3 */
    public abstract void mo1131a(int OplusGLSurfaceView_13);

    /* renamed from: PlatformImplementations.kt_3 */
    public abstract void mo1132a(View view);

    /* renamed from: PlatformImplementations.kt_3 */
    public abstract void mo1133a(PopupWindow.OnDismissListener onDismissListener);

    /* renamed from: PlatformImplementations.kt_3 */
    public abstract void mo1134a(MenuBuilder c0236h);

    /* renamed from: PlatformImplementations.kt_3 */
    public abstract void mo1135a(boolean z);

    /* renamed from: IntrinsicsJvm.kt_4 */
    public abstract void mo1138b(int OplusGLSurfaceView_13);

    /* renamed from: IntrinsicsJvm.kt_4 */
    public abstract void mo1139b(boolean z);

    /* renamed from: IntrinsicsJvm.kt_3 */
    public abstract void mo1141c(int OplusGLSurfaceView_13);

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public boolean collapseItemActionView(MenuBuilder c0236h, MenuItemImpl c0238j) {
        return false;
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    protected boolean mo1143e() {
        return true;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public boolean expandItemActionView(MenuBuilder c0236h, MenuItemImpl c0238j) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public int getId() {
        return 0;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void initForMenu(Context context, MenuBuilder c0236h) {
    }

    MenuPopup() {
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m1198a(Rect rect) {
        this.f1409a = rect;
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    public Rect m1199f() {
        return this.f1409a;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int OplusGLSurfaceView_13, long OplusGLSurfaceView_15) {
        ListAdapter listAdapter = (ListAdapter) adapterView.getAdapter();
        m1196a(listAdapter).f1356a.performItemAction((MenuItem) listAdapter.getItem(OplusGLSurfaceView_13), this, mo1143e() ? 0 : 4);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    protected static int m1195a(ListAdapter listAdapter, ViewGroup viewGroup, Context context, int OplusGLSurfaceView_13) {
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(0, 0);
        int count = listAdapter.getCount();
        ViewGroup frameLayout = viewGroup;
        int i2 = 0;
        int i3 = 0;
        View view = null;
        for (int i4 = 0; i4 < count; i4++) {
            int itemViewType = listAdapter.getItemViewType(i4);
            if (itemViewType != i3) {
                view = null;
                i3 = itemViewType;
            }
            if (frameLayout == null) {
                frameLayout = new FrameLayout(context);
            }
            view = listAdapter.getView(i4, view, frameLayout);
            view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
            int measuredWidth = view.getMeasuredWidth();
            if (measuredWidth >= OplusGLSurfaceView_13) {
                return OplusGLSurfaceView_13;
            }
            if (measuredWidth > i2) {
                i2 = measuredWidth;
            }
        }
        return i2;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    protected static MenuAdapter m1196a(ListAdapter listAdapter) {
        if (listAdapter instanceof HeaderViewListAdapter) {
            return (MenuAdapter) ((HeaderViewListAdapter) listAdapter).getWrappedAdapter();
        }
        return (MenuAdapter) listAdapter;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    protected static boolean m1197b(MenuBuilder c0236h) {
        int size = c0236h.size();
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < size; OplusGLSurfaceView_13++) {
            MenuItem item = c0236h.getItem(OplusGLSurfaceView_13);
            if (item.isVisible() && item.getIcon() != null) {
                return true;
            }
        }
        return false;
    }
}

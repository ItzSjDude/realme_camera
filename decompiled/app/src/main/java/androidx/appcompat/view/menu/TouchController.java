package androidx.appcompat.view.menu;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MenuPopup.java */
/* loaded from: classes.dex */
public abstract class l_renamed implements android.widget.AdapterView.OnItemClickListener, androidx.appcompat.view.menu.n_renamed, androidx.appcompat.view.menu.q_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private android.graphics.Rect f407a;

    public abstract void a_renamed(int i_renamed);

    public abstract void a_renamed(android.view.View view);

    public abstract void a_renamed(android.widget.PopupWindow.OnDismissListener onDismissListener);

    public abstract void a_renamed(androidx.appcompat.view.menu.h_renamed hVar);

    public abstract void a_renamed(boolean z_renamed);

    public abstract void b_renamed(int i_renamed);

    public abstract void b_renamed(boolean z_renamed);

    public abstract void c_renamed(int i_renamed);

    @Override // androidx.appcompat.view.menu.n_renamed
    public boolean collapseItemActionView(androidx.appcompat.view.menu.h_renamed hVar, androidx.appcompat.view.menu.j_renamed jVar) {
        return false;
    }

    protected boolean e_renamed() {
        return true;
    }

    @Override // androidx.appcompat.view.menu.n_renamed
    public boolean expandItemActionView(androidx.appcompat.view.menu.h_renamed hVar, androidx.appcompat.view.menu.j_renamed jVar) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.n_renamed
    public int getId() {
        return 0;
    }

    @Override // androidx.appcompat.view.menu.n_renamed
    public void initForMenu(android.content.Context context, androidx.appcompat.view.menu.h_renamed hVar) {
    }

    l_renamed() {
    }

    public void a_renamed(android.graphics.Rect rect) {
        this.f407a = rect;
    }

    public android.graphics.Rect f_renamed() {
        return this.f407a;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(android.widget.AdapterView<?> adapterView, android.view.View view, int i_renamed, long j_renamed) {
        android.widget.ListAdapter listAdapter = (android.widget.ListAdapter) adapterView.getAdapter();
        a_renamed(listAdapter).f387a.performItemAction((android.view.MenuItem) listAdapter.getItem(i_renamed), this, e_renamed() ? 0 : 4);
    }

    protected static int a_renamed(android.widget.ListAdapter listAdapter, android.view.ViewGroup viewGroup, android.content.Context context, int i_renamed) {
        int iMakeMeasureSpec = android.view.View.MeasureSpec.makeMeasureSpec(0, 0);
        int iMakeMeasureSpec2 = android.view.View.MeasureSpec.makeMeasureSpec(0, 0);
        int count = listAdapter.getCount();
        android.view.ViewGroup frameLayout = viewGroup;
        int i2 = 0;
        int i3 = 0;
        android.view.View view = null;
        for (int i4 = 0; i4 < count; i4++) {
            int itemViewType = listAdapter.getItemViewType(i4);
            if (itemViewType != i3) {
                view = null;
                i3 = itemViewType;
            }
            if (frameLayout == null) {
                frameLayout = new android.widget.FrameLayout(context);
            }
            view = listAdapter.getView(i4, view, frameLayout);
            view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
            int measuredWidth = view.getMeasuredWidth();
            if (measuredWidth >= i_renamed) {
                return i_renamed;
            }
            if (measuredWidth > i2) {
                i2 = measuredWidth;
            }
        }
        return i2;
    }

    protected static androidx.appcompat.view.menu.g_renamed a_renamed(android.widget.ListAdapter listAdapter) {
        if (listAdapter instanceof android.widget.HeaderViewListAdapter) {
            return (androidx.appcompat.view.menu.g_renamed) ((android.widget.HeaderViewListAdapter) listAdapter).getWrappedAdapter();
        }
        return (androidx.appcompat.view.menu.g_renamed) listAdapter;
    }

    protected static boolean b_renamed(androidx.appcompat.view.menu.h_renamed hVar) {
        int size = hVar.size();
        for (int i_renamed = 0; i_renamed < size; i_renamed++) {
            android.view.MenuItem item = hVar.getItem(i_renamed);
            if (item.isVisible() && item.getIcon() != null) {
                return true;
            }
        }
        return false;
    }
}

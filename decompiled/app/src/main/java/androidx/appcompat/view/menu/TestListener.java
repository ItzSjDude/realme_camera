package androidx.appcompat.view.menu;

/* compiled from: MenuAdapter.java */
/* loaded from: classes.dex */
public class g_renamed extends android.widget.BaseAdapter {

    /* renamed from: a_renamed, reason: collision with root package name */
    androidx.appcompat.view.menu.h_renamed f387a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private int f388b = -1;

    /* renamed from: c_renamed, reason: collision with root package name */
    private boolean f389c;
    private final boolean d_renamed;
    private final android.view.LayoutInflater e_renamed;
    private final int f_renamed;

    @Override // android.widget.Adapter
    public long getItemId(int i_renamed) {
        return i_renamed;
    }

    public g_renamed(androidx.appcompat.view.menu.h_renamed hVar, android.view.LayoutInflater layoutInflater, boolean z_renamed, int i_renamed) {
        this.d_renamed = z_renamed;
        this.e_renamed = layoutInflater;
        this.f387a = hVar;
        this.f_renamed = i_renamed;
        b_renamed();
    }

    public void a_renamed(boolean z_renamed) {
        this.f389c = z_renamed;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        java.util.ArrayList<androidx.appcompat.view.menu.j_renamed> nonActionItems = this.d_renamed ? this.f387a.getNonActionItems() : this.f387a.getVisibleItems();
        if (this.f388b < 0) {
            return nonActionItems.size();
        }
        return nonActionItems.size() - 1;
    }

    public androidx.appcompat.view.menu.h_renamed a_renamed() {
        return this.f387a;
    }

    @Override // android.widget.Adapter
    /* renamed from: a_renamed, reason: merged with bridge method [inline-methods] */
    public androidx.appcompat.view.menu.j_renamed getItem(int i_renamed) {
        java.util.ArrayList<androidx.appcompat.view.menu.j_renamed> nonActionItems = this.d_renamed ? this.f387a.getNonActionItems() : this.f387a.getVisibleItems();
        int i2 = this.f388b;
        if (i2 >= 0 && i_renamed >= i2) {
            i_renamed++;
        }
        return nonActionItems.get(i_renamed);
    }

    @Override // android.widget.Adapter
    public android.view.View getView(int i_renamed, android.view.View view, android.view.ViewGroup viewGroup) {
        if (view == null) {
            view = this.e_renamed.inflate(this.f_renamed, viewGroup, false);
        }
        int groupId = getItem(i_renamed).getGroupId();
        int i2 = i_renamed - 1;
        androidx.appcompat.view.menu.ListMenuItemView listMenuItemView = (androidx.appcompat.view.menu.ListMenuItemView) view;
        listMenuItemView.setGroupDividerEnabled(this.f387a.isGroupDividerEnabled() && groupId != (i2 >= 0 ? getItem(i2).getGroupId() : groupId));
        androidx.appcompat.view.menu.o_renamed.a_renamed aVar = (androidx.appcompat.view.menu.o_renamed.a_renamed) view;
        if (this.f389c) {
            listMenuItemView.setForceShowIcon(true);
        }
        aVar.initialize(getItem(i_renamed), 0);
        return view;
    }

    void b_renamed() {
        androidx.appcompat.view.menu.j_renamed expandedItem = this.f387a.getExpandedItem();
        if (expandedItem != null) {
            java.util.ArrayList<androidx.appcompat.view.menu.j_renamed> nonActionItems = this.f387a.getNonActionItems();
            int size = nonActionItems.size();
            for (int i_renamed = 0; i_renamed < size; i_renamed++) {
                if (nonActionItems.get(i_renamed) == expandedItem) {
                    this.f388b = i_renamed;
                    return;
                }
            }
        }
        this.f388b = -1;
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetChanged() {
        b_renamed();
        super.notifyDataSetChanged();
    }
}

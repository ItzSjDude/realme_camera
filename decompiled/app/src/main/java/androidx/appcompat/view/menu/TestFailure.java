package androidx.appcompat.view.menu;

/* compiled from: ListMenuPresenter.java */
/* loaded from: classes.dex */
public class f_renamed implements android.widget.AdapterView.OnItemClickListener, androidx.appcompat.view.menu.n_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    android.content.Context f382a;

    /* renamed from: b_renamed, reason: collision with root package name */
    android.view.LayoutInflater f383b;

    /* renamed from: c_renamed, reason: collision with root package name */
    androidx.appcompat.view.menu.h_renamed f384c;
    androidx.appcompat.view.menu.ExpandedMenuView d_renamed;
    int e_renamed;
    int f_renamed;
    int g_renamed;
    androidx.appcompat.view.menu.f_renamed.a_renamed h_renamed;
    private androidx.appcompat.view.menu.n_renamed.a_renamed i_renamed;
    private int j_renamed;

    @Override // androidx.appcompat.view.menu.n_renamed
    public boolean collapseItemActionView(androidx.appcompat.view.menu.h_renamed hVar, androidx.appcompat.view.menu.j_renamed jVar) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.n_renamed
    public boolean expandItemActionView(androidx.appcompat.view.menu.h_renamed hVar, androidx.appcompat.view.menu.j_renamed jVar) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.n_renamed
    public boolean flagActionItems() {
        return false;
    }

    public f_renamed(android.content.Context context, int i_renamed) {
        this(i_renamed, 0);
        this.f382a = context;
        this.f383b = android.view.LayoutInflater.from(this.f382a);
    }

    public f_renamed(int i_renamed, int i2) {
        this.g_renamed = i_renamed;
        this.f_renamed = i2;
    }

    @Override // androidx.appcompat.view.menu.n_renamed
    public void initForMenu(android.content.Context context, androidx.appcompat.view.menu.h_renamed hVar) {
        int i_renamed = this.f_renamed;
        if (i_renamed != 0) {
            this.f382a = new android.view.ContextThemeWrapper(context, i_renamed);
            this.f383b = android.view.LayoutInflater.from(this.f382a);
        } else if (this.f382a != null) {
            this.f382a = context;
            if (this.f383b == null) {
                this.f383b = android.view.LayoutInflater.from(this.f382a);
            }
        }
        this.f384c = hVar;
        androidx.appcompat.view.menu.f_renamed.a_renamed aVar = this.h_renamed;
        if (aVar != null) {
            aVar.notifyDataSetChanged();
        }
    }

    public androidx.appcompat.view.menu.o_renamed a_renamed(android.view.ViewGroup viewGroup) {
        if (this.d_renamed == null) {
            this.d_renamed = (androidx.appcompat.view.menu.ExpandedMenuView) this.f383b.inflate(androidx.appcompat.R_renamed.layout.abc_expanded_menu_layout, viewGroup, false);
            if (this.h_renamed == null) {
                this.h_renamed = new androidx.appcompat.view.menu.f_renamed.a_renamed();
            }
            this.d_renamed.setAdapter((android.widget.ListAdapter) this.h_renamed);
            this.d_renamed.setOnItemClickListener(this);
        }
        return this.d_renamed;
    }

    public android.widget.ListAdapter a_renamed() {
        if (this.h_renamed == null) {
            this.h_renamed = new androidx.appcompat.view.menu.f_renamed.a_renamed();
        }
        return this.h_renamed;
    }

    @Override // androidx.appcompat.view.menu.n_renamed
    public void updateMenuView(boolean z_renamed) {
        androidx.appcompat.view.menu.f_renamed.a_renamed aVar = this.h_renamed;
        if (aVar != null) {
            aVar.notifyDataSetChanged();
        }
    }

    @Override // androidx.appcompat.view.menu.n_renamed
    public void setCallback(androidx.appcompat.view.menu.n_renamed.a_renamed aVar) {
        this.i_renamed = aVar;
    }

    @Override // androidx.appcompat.view.menu.n_renamed
    public boolean onSubMenuSelected(androidx.appcompat.view.menu.s_renamed sVar) {
        if (!sVar.hasVisibleItems()) {
            return false;
        }
        new androidx.appcompat.view.menu.i_renamed(sVar).a_renamed((android.os.IBinder) null);
        androidx.appcompat.view.menu.n_renamed.a_renamed aVar = this.i_renamed;
        if (aVar == null) {
            return true;
        }
        aVar.a_renamed(sVar);
        return true;
    }

    @Override // androidx.appcompat.view.menu.n_renamed
    public void onCloseMenu(androidx.appcompat.view.menu.h_renamed hVar, boolean z_renamed) {
        androidx.appcompat.view.menu.n_renamed.a_renamed aVar = this.i_renamed;
        if (aVar != null) {
            aVar.a_renamed(hVar, z_renamed);
        }
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(android.widget.AdapterView<?> adapterView, android.view.View view, int i_renamed, long j_renamed) {
        this.f384c.performItemAction(this.h_renamed.getItem(i_renamed), this, 0);
    }

    public void a_renamed(android.os.Bundle bundle) {
        android.util.SparseArray<android.os.Parcelable> sparseArray = new android.util.SparseArray<>();
        androidx.appcompat.view.menu.ExpandedMenuView expandedMenuView = this.d_renamed;
        if (expandedMenuView != null) {
            expandedMenuView.saveHierarchyState(sparseArray);
        }
        bundle.putSparseParcelableArray("android:menu:list", sparseArray);
    }

    public void b_renamed(android.os.Bundle bundle) {
        android.util.SparseArray<android.os.Parcelable> sparseParcelableArray = bundle.getSparseParcelableArray("android:menu:list");
        if (sparseParcelableArray != null) {
            this.d_renamed.restoreHierarchyState(sparseParcelableArray);
        }
    }

    @Override // androidx.appcompat.view.menu.n_renamed
    public int getId() {
        return this.j_renamed;
    }

    @Override // androidx.appcompat.view.menu.n_renamed
    public android.os.Parcelable onSaveInstanceState() {
        if (this.d_renamed == null) {
            return null;
        }
        android.os.Bundle bundle = new android.os.Bundle();
        a_renamed(bundle);
        return bundle;
    }

    @Override // androidx.appcompat.view.menu.n_renamed
    public void onRestoreInstanceState(android.os.Parcelable parcelable) {
        b_renamed((android.os.Bundle) parcelable);
    }

    /* compiled from: ListMenuPresenter.java */
    private class a_renamed extends android.widget.BaseAdapter {

        /* renamed from: b_renamed, reason: collision with root package name */
        private int f386b = -1;

        @Override // android.widget.Adapter
        public long getItemId(int i_renamed) {
            return i_renamed;
        }

        public a_renamed() {
            a_renamed();
        }

        @Override // android.widget.Adapter
        public int getCount() {
            int size = androidx.appcompat.view.menu.f_renamed.this.f384c.getNonActionItems().size() - androidx.appcompat.view.menu.f_renamed.this.e_renamed;
            return this.f386b < 0 ? size : size - 1;
        }

        @Override // android.widget.Adapter
        /* renamed from: a_renamed, reason: merged with bridge method [inline-methods] */
        public androidx.appcompat.view.menu.j_renamed getItem(int i_renamed) {
            java.util.ArrayList<androidx.appcompat.view.menu.j_renamed> nonActionItems = androidx.appcompat.view.menu.f_renamed.this.f384c.getNonActionItems();
            int i2 = i_renamed + androidx.appcompat.view.menu.f_renamed.this.e_renamed;
            int i3 = this.f386b;
            if (i3 >= 0 && i2 >= i3) {
                i2++;
            }
            return nonActionItems.get(i2);
        }

        @Override // android.widget.Adapter
        public android.view.View getView(int i_renamed, android.view.View view, android.view.ViewGroup viewGroup) {
            if (view == null) {
                view = androidx.appcompat.view.menu.f_renamed.this.f383b.inflate(androidx.appcompat.view.menu.f_renamed.this.g_renamed, viewGroup, false);
            }
            ((androidx.appcompat.view.menu.o_renamed.a_renamed) view).initialize(getItem(i_renamed), 0);
            return view;
        }

        void a_renamed() {
            androidx.appcompat.view.menu.j_renamed expandedItem = androidx.appcompat.view.menu.f_renamed.this.f384c.getExpandedItem();
            if (expandedItem != null) {
                java.util.ArrayList<androidx.appcompat.view.menu.j_renamed> nonActionItems = androidx.appcompat.view.menu.f_renamed.this.f384c.getNonActionItems();
                int size = nonActionItems.size();
                for (int i_renamed = 0; i_renamed < size; i_renamed++) {
                    if (nonActionItems.get(i_renamed) == expandedItem) {
                        this.f386b = i_renamed;
                        return;
                    }
                }
            }
            this.f386b = -1;
        }

        @Override // android.widget.BaseAdapter
        public void notifyDataSetChanged() {
            a_renamed();
            super.notifyDataSetChanged();
        }
    }
}

package androidx.appcompat.view.menu;

/* compiled from: BaseMenuPresenter.java */
/* loaded from: classes.dex */
public abstract class c_renamed implements androidx.appcompat.view.menu.n_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    protected android.content.Context f364a;

    /* renamed from: b_renamed, reason: collision with root package name */
    protected android.content.Context f365b;

    /* renamed from: c_renamed, reason: collision with root package name */
    protected androidx.appcompat.view.menu.h_renamed f366c;
    protected android.view.LayoutInflater d_renamed;
    protected android.view.LayoutInflater e_renamed;
    protected androidx.appcompat.view.menu.o_renamed f_renamed;
    private androidx.appcompat.view.menu.n_renamed.a_renamed g_renamed;
    private int h_renamed;
    private int i_renamed;
    private int j_renamed;

    public abstract void a_renamed(androidx.appcompat.view.menu.j_renamed jVar, androidx.appcompat.view.menu.o_renamed.a_renamed aVar);

    public boolean a_renamed(int i_renamed, androidx.appcompat.view.menu.j_renamed jVar) {
        return true;
    }

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

    public c_renamed(android.content.Context context, int i_renamed, int i2) {
        this.f364a = context;
        this.d_renamed = android.view.LayoutInflater.from(context);
        this.h_renamed = i_renamed;
        this.i_renamed = i2;
    }

    @Override // androidx.appcompat.view.menu.n_renamed
    public void initForMenu(android.content.Context context, androidx.appcompat.view.menu.h_renamed hVar) {
        this.f365b = context;
        this.e_renamed = android.view.LayoutInflater.from(this.f365b);
        this.f366c = hVar;
    }

    public androidx.appcompat.view.menu.o_renamed a_renamed(android.view.ViewGroup viewGroup) {
        if (this.f_renamed == null) {
            this.f_renamed = (androidx.appcompat.view.menu.o_renamed) this.d_renamed.inflate(this.h_renamed, viewGroup, false);
            this.f_renamed.initialize(this.f366c);
            updateMenuView(true);
        }
        return this.f_renamed;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.appcompat.view.menu.n_renamed
    public void updateMenuView(boolean z_renamed) {
        android.view.ViewGroup viewGroup = (android.view.ViewGroup) this.f_renamed;
        if (viewGroup == null) {
            return;
        }
        androidx.appcompat.view.menu.h_renamed hVar = this.f366c;
        int i_renamed = 0;
        if (hVar != null) {
            hVar.flagActionItems();
            java.util.ArrayList<androidx.appcompat.view.menu.j_renamed> visibleItems = this.f366c.getVisibleItems();
            int size = visibleItems.size();
            int i2 = 0;
            for (int i3 = 0; i3 < size; i3++) {
                androidx.appcompat.view.menu.j_renamed jVar = visibleItems.get(i3);
                if (a_renamed(i2, jVar)) {
                    android.view.View childAt = viewGroup.getChildAt(i2);
                    androidx.appcompat.view.menu.j_renamed itemData = childAt instanceof androidx.appcompat.view.menu.o_renamed.a_renamed ? ((androidx.appcompat.view.menu.o_renamed.a_renamed) childAt).getItemData() : null;
                    android.view.View viewA = a_renamed(jVar, childAt, viewGroup);
                    if (jVar != itemData) {
                        viewA.setPressed(false);
                        viewA.jumpDrawablesToCurrentState();
                    }
                    if (viewA != childAt) {
                        a_renamed(viewA, i2);
                    }
                    i2++;
                }
            }
            i_renamed = i2;
        }
        while (i_renamed < viewGroup.getChildCount()) {
            if (!a_renamed(viewGroup, i_renamed)) {
                i_renamed++;
            }
        }
    }

    protected void a_renamed(android.view.View view, int i_renamed) {
        android.view.ViewGroup viewGroup = (android.view.ViewGroup) view.getParent();
        if (viewGroup != null) {
            viewGroup.removeView(view);
        }
        ((android.view.ViewGroup) this.f_renamed).addView(view, i_renamed);
    }

    protected boolean a_renamed(android.view.ViewGroup viewGroup, int i_renamed) {
        viewGroup.removeViewAt(i_renamed);
        return true;
    }

    @Override // androidx.appcompat.view.menu.n_renamed
    public void setCallback(androidx.appcompat.view.menu.n_renamed.a_renamed aVar) {
        this.g_renamed = aVar;
    }

    public androidx.appcompat.view.menu.n_renamed.a_renamed a_renamed() {
        return this.g_renamed;
    }

    public androidx.appcompat.view.menu.o_renamed.a_renamed b_renamed(android.view.ViewGroup viewGroup) {
        return (androidx.appcompat.view.menu.o_renamed.a_renamed) this.d_renamed.inflate(this.i_renamed, viewGroup, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public android.view.View a_renamed(androidx.appcompat.view.menu.j_renamed jVar, android.view.View view, android.view.ViewGroup viewGroup) {
        androidx.appcompat.view.menu.o_renamed.a_renamed aVarB;
        if (view instanceof androidx.appcompat.view.menu.o_renamed.a_renamed) {
            aVarB = (androidx.appcompat.view.menu.o_renamed.a_renamed) view;
        } else {
            aVarB = b_renamed(viewGroup);
        }
        a_renamed(jVar, aVarB);
        return (android.view.View) aVarB;
    }

    @Override // androidx.appcompat.view.menu.n_renamed
    public void onCloseMenu(androidx.appcompat.view.menu.h_renamed hVar, boolean z_renamed) {
        androidx.appcompat.view.menu.n_renamed.a_renamed aVar = this.g_renamed;
        if (aVar != null) {
            aVar.a_renamed(hVar, z_renamed);
        }
    }

    @Override // androidx.appcompat.view.menu.n_renamed
    public boolean onSubMenuSelected(androidx.appcompat.view.menu.s_renamed sVar) {
        androidx.appcompat.view.menu.n_renamed.a_renamed aVar = this.g_renamed;
        if (aVar != null) {
            return aVar.a_renamed(sVar);
        }
        return false;
    }

    @Override // androidx.appcompat.view.menu.n_renamed
    public int getId() {
        return this.j_renamed;
    }

    public void a_renamed(int i_renamed) {
        this.j_renamed = i_renamed;
    }
}

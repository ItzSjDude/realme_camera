package androidx.appcompat.view;

/* compiled from: SupportActionModeWrapper.java */
/* loaded from: classes.dex */
public class f_renamed extends android.view.ActionMode {

    /* renamed from: a_renamed, reason: collision with root package name */
    final android.content.Context f330a;

    /* renamed from: b_renamed, reason: collision with root package name */
    final androidx.appcompat.view.b_renamed f331b;

    public f_renamed(android.content.Context context, androidx.appcompat.view.b_renamed bVar) {
        this.f330a = context;
        this.f331b = bVar;
    }

    @Override // android.view.ActionMode
    public java.lang.Object getTag() {
        return this.f331b.j_renamed();
    }

    @Override // android.view.ActionMode
    public void setTag(java.lang.Object obj) {
        this.f331b.a_renamed(obj);
    }

    @Override // android.view.ActionMode
    public void setTitle(java.lang.CharSequence charSequence) {
        this.f331b.b_renamed(charSequence);
    }

    @Override // android.view.ActionMode
    public void setSubtitle(java.lang.CharSequence charSequence) {
        this.f331b.a_renamed(charSequence);
    }

    @Override // android.view.ActionMode
    public void invalidate() {
        this.f331b.d_renamed();
    }

    @Override // android.view.ActionMode
    public void finish() {
        this.f331b.c_renamed();
    }

    @Override // android.view.ActionMode
    public android.view.Menu getMenu() {
        return new androidx.appcompat.view.menu.p_renamed(this.f330a, (androidx.core.b_renamed.a_renamed.a_renamed) this.f331b.b_renamed());
    }

    @Override // android.view.ActionMode
    public java.lang.CharSequence getTitle() {
        return this.f331b.f_renamed();
    }

    @Override // android.view.ActionMode
    public void setTitle(int i_renamed) {
        this.f331b.a_renamed(i_renamed);
    }

    @Override // android.view.ActionMode
    public java.lang.CharSequence getSubtitle() {
        return this.f331b.g_renamed();
    }

    @Override // android.view.ActionMode
    public void setSubtitle(int i_renamed) {
        this.f331b.b_renamed(i_renamed);
    }

    @Override // android.view.ActionMode
    public android.view.View getCustomView() {
        return this.f331b.i_renamed();
    }

    @Override // android.view.ActionMode
    public void setCustomView(android.view.View view) {
        this.f331b.a_renamed(view);
    }

    @Override // android.view.ActionMode
    public android.view.MenuInflater getMenuInflater() {
        return this.f331b.a_renamed();
    }

    @Override // android.view.ActionMode
    public boolean getTitleOptionalHint() {
        return this.f331b.k_renamed();
    }

    @Override // android.view.ActionMode
    public void setTitleOptionalHint(boolean z_renamed) {
        this.f331b.a_renamed(z_renamed);
    }

    @Override // android.view.ActionMode
    public boolean isTitleOptional() {
        return this.f331b.h_renamed();
    }

    /* compiled from: SupportActionModeWrapper.java */
    public static class a_renamed implements androidx.appcompat.view.b_renamed.a_renamed {

        /* renamed from: a_renamed, reason: collision with root package name */
        final android.view.ActionMode.Callback f332a;

        /* renamed from: b_renamed, reason: collision with root package name */
        final android.content.Context f333b;

        /* renamed from: c_renamed, reason: collision with root package name */
        final java.util.ArrayList<androidx.appcompat.view.f_renamed> f334c = new java.util.ArrayList<>();
        final androidx.collection.SimpleArrayMap<android.view.Menu, android.view.Menu> d_renamed = new androidx.collection.SimpleArrayMap<>();

        public a_renamed(android.content.Context context, android.view.ActionMode.Callback callback) {
            this.f333b = context;
            this.f332a = callback;
        }

        @Override // androidx.appcompat.view.b_renamed.a_renamed
        public boolean a_renamed(androidx.appcompat.view.b_renamed bVar, android.view.Menu menu) {
            return this.f332a.onCreateActionMode(b_renamed(bVar), a_renamed(menu));
        }

        @Override // androidx.appcompat.view.b_renamed.a_renamed
        public boolean b_renamed(androidx.appcompat.view.b_renamed bVar, android.view.Menu menu) {
            return this.f332a.onPrepareActionMode(b_renamed(bVar), a_renamed(menu));
        }

        @Override // androidx.appcompat.view.b_renamed.a_renamed
        public boolean a_renamed(androidx.appcompat.view.b_renamed bVar, android.view.MenuItem menuItem) {
            return this.f332a.onActionItemClicked(b_renamed(bVar), new androidx.appcompat.view.menu.k_renamed(this.f333b, (androidx.core.b_renamed.a_renamed.b_renamed) menuItem));
        }

        @Override // androidx.appcompat.view.b_renamed.a_renamed
        public void a_renamed(androidx.appcompat.view.b_renamed bVar) {
            this.f332a.onDestroyActionMode(b_renamed(bVar));
        }

        private android.view.Menu a_renamed(android.view.Menu menu) {
            android.view.Menu menu2 = this.d_renamed.get(menu);
            if (menu2 != null) {
                return menu2;
            }
            androidx.appcompat.view.menu.p_renamed pVar = new androidx.appcompat.view.menu.p_renamed(this.f333b, (androidx.core.b_renamed.a_renamed.a_renamed) menu);
            this.d_renamed.put(menu, pVar);
            return pVar;
        }

        public android.view.ActionMode b_renamed(androidx.appcompat.view.b_renamed bVar) {
            int size = this.f334c.size();
            for (int i_renamed = 0; i_renamed < size; i_renamed++) {
                androidx.appcompat.view.f_renamed fVar = this.f334c.get(i_renamed);
                if (fVar != null && fVar.f331b == bVar) {
                    return fVar;
                }
            }
            androidx.appcompat.view.f_renamed fVar2 = new androidx.appcompat.view.f_renamed(this.f333b, bVar);
            this.f334c.add(fVar2);
            return fVar2;
        }
    }
}

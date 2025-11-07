package com.oplus.camera.ui.modepanel;

/* compiled from: BaseModeInfoAdapter.java */
/* loaded from: classes2.dex */
public abstract class a_renamed<V_renamed extends androidx.recyclerview.widget.RecyclerView.w_renamed> extends androidx.recyclerview.widget.RecyclerView.a_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    protected android.app.Activity f6709a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private java.util.ArrayList<com.oplus.camera.ui.modepanel.k_renamed> f6710b = new java.util.ArrayList<>();

    /* renamed from: c_renamed, reason: collision with root package name */
    private java.util.ArrayList<com.oplus.camera.ui.modepanel.k_renamed> f6711c = new java.util.ArrayList<>();
    private java.util.ArrayList<java.lang.Integer> d_renamed = new java.util.ArrayList<>();

    public a_renamed(android.app.Activity activity) {
        this.f6709a = null;
        this.f6709a = activity;
        com.oplus.camera.util.Util.q_renamed(this.f6709a);
        this.d_renamed.add(20);
        this.d_renamed.add(21);
        this.d_renamed.add(5);
        this.d_renamed.add(22);
        this.d_renamed.add(25);
    }

    public java.util.ArrayList<com.oplus.camera.ui.modepanel.k_renamed> a_renamed() {
        this.f6711c.clear();
        java.util.Iterator<com.oplus.camera.ui.modepanel.k_renamed> it = this.f6710b.iterator();
        while (it.hasNext()) {
            com.oplus.camera.ui.modepanel.k_renamed next = it.next();
            if (this.d_renamed.contains(java.lang.Integer.valueOf(next.b_renamed()))) {
                this.f6711c.add(next);
            }
        }
        return this.f6711c;
    }

    public void a_renamed(java.util.List<com.oplus.camera.ui.modepanel.k_renamed> list) {
        this.f6710b.clear();
        this.f6710b.addAll(list);
        a_renamed();
        notifyDataSetChanged();
    }

    public void a_renamed(int i_renamed, com.oplus.camera.ui.modepanel.k_renamed kVar) {
        a_renamed(i_renamed, java.util.Collections.singletonList(kVar));
    }

    public void a_renamed(int i_renamed, java.util.List<com.oplus.camera.ui.modepanel.k_renamed> list) {
        b_renamed(i_renamed, list);
    }

    protected void b_renamed(int i_renamed, java.util.List<? extends com.oplus.camera.ui.modepanel.k_renamed> list) {
        if (com.oplus.camera.screen.a_renamed.b_renamed.g_renamed()) {
            this.f6710b.addAll(c_renamed(i_renamed), list);
        } else {
            this.f6710b.addAll(i_renamed, list);
        }
        a_renamed();
        notifyItemInserted(i_renamed);
    }

    public void a_renamed(int i_renamed, int i2) {
        if (com.oplus.camera.screen.a_renamed.b_renamed.g_renamed()) {
            this.f6710b.add(c_renamed(i2), this.f6710b.remove(c_renamed(i_renamed)));
        } else {
            java.util.ArrayList<com.oplus.camera.ui.modepanel.k_renamed> arrayList = this.f6710b;
            arrayList.add(i2, arrayList.remove(i_renamed));
        }
        a_renamed();
        notifyItemMoved(i_renamed, i2);
    }

    public void a_renamed(int i_renamed) {
        if (com.oplus.camera.screen.a_renamed.b_renamed.g_renamed()) {
            this.f6710b.remove(c_renamed(i_renamed));
        } else {
            this.f6710b.remove(i_renamed);
        }
        a_renamed();
        notifyItemRangeRemoved(i_renamed, 1);
    }

    private int c_renamed(int i_renamed) {
        if (i_renamed == this.f6711c.size()) {
            return this.f6710b.size();
        }
        return this.f6710b.indexOf(this.f6711c.get(i_renamed));
    }

    public java.util.List<com.oplus.camera.ui.modepanel.k_renamed> b_renamed() {
        return com.oplus.camera.screen.a_renamed.b_renamed.g_renamed() ? this.f6711c : this.f6710b;
    }

    public java.util.List<com.oplus.camera.ui.modepanel.k_renamed> c_renamed() {
        return this.f6710b;
    }

    public com.oplus.camera.ui.modepanel.k_renamed b_renamed(int i_renamed) {
        if (i_renamed < b_renamed().size()) {
            return b_renamed().get(i_renamed);
        }
        return null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.a_renamed
    public int getItemCount() {
        return b_renamed().size();
    }
}

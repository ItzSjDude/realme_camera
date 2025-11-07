package com.oplus.camera.filmvideomode;

/* compiled from: FilmModeBarAdapter.java */
/* loaded from: classes2.dex */
public class h_renamed extends androidx.recyclerview.widget.RecyclerView.a_renamed<com.oplus.camera.filmvideomode.h_renamed.a_renamed> {

    /* renamed from: a_renamed, reason: collision with root package name */
    private static final java.lang.String f4491a = "h_renamed";

    /* renamed from: b_renamed, reason: collision with root package name */
    private com.oplus.camera.filmvideomode.i_renamed f4492b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private android.app.Activity f4493c;
    private java.util.List<com.oplus.camera.filmvideomode.j_renamed> d_renamed = new java.util.ArrayList();
    private com.oplus.camera.professional.q_renamed e_renamed = null;
    private com.oplus.camera.filmvideomode.k_renamed.d_renamed f_renamed = null;
    private int g_renamed = -1;

    public h_renamed(android.app.Activity activity, com.oplus.camera.filmvideomode.i_renamed iVar, java.util.List<com.oplus.camera.filmvideomode.j_renamed> list) {
        this.f4492b = null;
        this.f4493c = null;
        this.f4493c = activity;
        this.f4492b = iVar;
        this.d_renamed.addAll(list);
    }

    public void a_renamed(com.oplus.camera.professional.q_renamed qVar) {
        this.e_renamed = qVar;
    }

    public void a_renamed(com.oplus.camera.filmvideomode.k_renamed.d_renamed dVar) {
        this.f_renamed = dVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.a_renamed
    /* renamed from: a_renamed, reason: merged with bridge method [inline-methods] */
    public com.oplus.camera.filmvideomode.h_renamed.a_renamed onCreateViewHolder(android.view.ViewGroup viewGroup, int i_renamed) {
        com.oplus.camera.filmvideomode.d_renamed dVar = new com.oplus.camera.filmvideomode.d_renamed(this.f4493c);
        android.widget.LinearLayout.LayoutParams layoutParams = new android.widget.LinearLayout.LayoutParams(this.f4493c.getResources().getDimensionPixelSize(com.oplus.camera.util.Util.u_renamed() ? com.oplus.camera.R_renamed.dimen.movie_mode_params_item_width_rack : com.oplus.camera.R_renamed.dimen.movie_mode_params_item_width), this.f4493c.getResources().getDimensionPixelSize(com.oplus.camera.util.Util.u_renamed() ? com.oplus.camera.R_renamed.dimen.movie_mode_params_item_height_rack : com.oplus.camera.R_renamed.dimen.movie_mode_params_item_height));
        dVar.setId(102);
        dVar.setRotation(com.oplus.camera.util.Util.u_renamed() ? 0.0f : 90.0f);
        dVar.setGravity(com.oplus.camera.util.Util.u_renamed() ? 1 : 16);
        dVar.setLayoutParams(layoutParams);
        return new com.oplus.camera.filmvideomode.h_renamed.a_renamed(dVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.a_renamed
    /* renamed from: a_renamed, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(com.oplus.camera.filmvideomode.h_renamed.a_renamed aVar, int i_renamed) {
        if (i_renamed > this.d_renamed.size() - 1) {
            com.oplus.camera.e_renamed.b_renamed(f4491a, "onBindViewHolder, invalid position.");
            return;
        }
        com.oplus.camera.filmvideomode.j_renamed jVar = this.d_renamed.get(i_renamed);
        com.oplus.camera.filmvideomode.d_renamed dVar = (com.oplus.camera.filmvideomode.d_renamed) aVar.itemView;
        dVar.setItemIndex(jVar.e_renamed());
        dVar.setItemTitleImage(jVar.b_renamed());
        dVar.setItemValueText(jVar.d_renamed());
        dVar.setItemAnimation(jVar.a_renamed());
        dVar.a_renamed(true);
        com.oplus.camera.professional.q_renamed qVar = this.e_renamed;
        if (qVar != null) {
            dVar.b_renamed(qVar.b_renamed(jVar.e_renamed()), false);
            if (com.oplus.camera.professional.x_renamed.a_renamed(jVar.e_renamed()) && this.e_renamed.a_renamed(jVar.e_renamed())) {
                dVar.a_renamed(0, false);
            } else {
                dVar.a_renamed(8, false);
            }
        }
        if (jVar.e_renamed() == this.g_renamed) {
            jVar.b_renamed(true);
        }
        dVar.setSelected(jVar.c_renamed());
        dVar.setTag(com.oplus.camera.R_renamed.id_renamed.professional_parameter_index, java.lang.Integer.valueOf(jVar.e_renamed()));
        dVar.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.oplus.camera.filmvideomode.-$$Lambda$h_renamed$O2cG4OBzV6V1bSYg5ehKQ1Mexu8
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f_renamed$0.b_renamed(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b_renamed(android.view.View view) {
        if (this.f_renamed.a_renamed(view)) {
            int iA = a_renamed(view);
            com.oplus.camera.e_renamed.b_renamed(f4491a, "onBindViewHolder, onclick view index: " + iA);
            if (iA == 0) {
                view.sendAccessibilityEvent(1);
                ((com.oplus.camera.filmvideomode.d_renamed) view).a_renamed(true, true);
                this.f_renamed.a_renamed(null, view, iA, iA);
                com.oplus.camera.e_renamed.b_renamed(f4491a, "onBindViewHolder, reset item click.");
                return;
            }
            if (-1 != this.g_renamed) {
                c_renamed();
            }
            com.oplus.camera.filmvideomode.k_renamed.d_renamed dVar = this.f_renamed;
            if (dVar != null) {
                if (this.g_renamed != iA) {
                    com.oplus.camera.filmvideomode.j_renamed jVarA = a_renamed(iA);
                    if (jVarA != null) {
                        jVarA.b_renamed(true);
                    }
                    ((com.oplus.camera.filmvideomode.d_renamed) view).a_renamed(true, true);
                    this.f_renamed.a_renamed(null, view, iA, iA);
                } else {
                    dVar.a_renamed(null, view, iA);
                }
            }
            if (this.g_renamed != iA && view != null) {
                this.g_renamed = iA;
                view.sendAccessibilityEvent(1);
            } else {
                a_renamed();
            }
        }
    }

    private void c_renamed() {
        for (com.oplus.camera.filmvideomode.j_renamed jVar : this.d_renamed) {
            jVar.b_renamed(false);
            com.oplus.camera.filmvideomode.d_renamed dVar = (com.oplus.camera.filmvideomode.d_renamed) this.f4492b.a_renamed(jVar.e_renamed());
            if (dVar != null) {
                dVar.a_renamed(false, true);
            } else {
                notifyItemChanged(b_renamed(jVar.e_renamed()));
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.a_renamed
    public int getItemCount() {
        return this.d_renamed.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.a_renamed
    public long getItemId(int i_renamed) {
        return this.d_renamed.get(i_renamed).e_renamed();
    }

    public void a_renamed() {
        c_renamed();
        this.g_renamed = -1;
    }

    public com.oplus.camera.filmvideomode.j_renamed a_renamed(int i_renamed) {
        for (com.oplus.camera.filmvideomode.j_renamed jVar : this.d_renamed) {
            if (jVar.e_renamed() == i_renamed) {
                return jVar;
            }
        }
        return null;
    }

    public void a_renamed(int i_renamed, java.lang.String str) {
        com.oplus.camera.filmvideomode.j_renamed jVarA = a_renamed(i_renamed);
        if (jVarA != null) {
            jVarA.a_renamed(str);
        }
    }

    public void a_renamed(android.view.View view, java.lang.String str) {
        ((com.oplus.camera.filmvideomode.d_renamed) view).setItemValueText(str);
    }

    public int b_renamed() {
        return this.g_renamed;
    }

    public void a_renamed(android.view.View view, int i_renamed, boolean z_renamed) {
        ((com.oplus.camera.filmvideomode.d_renamed) view).a_renamed(i_renamed, z_renamed);
    }

    public void a_renamed(int i_renamed, boolean z_renamed) {
        com.oplus.camera.filmvideomode.j_renamed jVarA = a_renamed(i_renamed);
        if (jVarA != null) {
            jVarA.a_renamed(z_renamed);
        }
    }

    public int a_renamed(android.view.View view) {
        if (view == null) {
            return -1;
        }
        return ((java.lang.Integer) view.getTag(com.oplus.camera.R_renamed.id_renamed.professional_parameter_index)).intValue();
    }

    public int b_renamed(int i_renamed) {
        for (int i2 = 0; i2 < this.d_renamed.size(); i2++) {
            if (i_renamed == this.d_renamed.get(i2).e_renamed()) {
                return i2;
            }
        }
        return -1;
    }

    /* compiled from: FilmModeBarAdapter.java */
    public class a_renamed extends androidx.recyclerview.widget.RecyclerView.w_renamed {
        public a_renamed(android.view.View view) {
            super(view);
        }
    }
}

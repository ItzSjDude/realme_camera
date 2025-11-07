package com.oplus.camera.ui.modepanel;

/* compiled from: MoreModeAdapter.java */
/* loaded from: classes2.dex */
public class o_renamed extends com.oplus.camera.ui.modepanel.a_renamed<com.oplus.camera.ui.modepanel.o_renamed.b_renamed> {

    /* renamed from: b_renamed, reason: collision with root package name */
    private static final java.lang.String f6749b = "o_renamed";

    /* renamed from: c_renamed, reason: collision with root package name */
    private com.oplus.camera.ui.modepanel.o_renamed.a_renamed f6750c;
    private int d_renamed;
    private int e_renamed;
    private boolean f_renamed;
    private int g_renamed;
    private int h_renamed;

    /* compiled from: MoreModeAdapter.java */
    public interface a_renamed {
        void a_renamed(int i_renamed);
    }

    public o_renamed(android.app.Activity activity, int i_renamed) {
        super(activity);
        this.f6750c = null;
        this.d_renamed = 0;
        this.f_renamed = false;
        this.g_renamed = com.oplus.camera.R_renamed.layout.more_mode_item;
        this.h_renamed = 0;
        this.e_renamed = i_renamed;
    }

    public void a_renamed(java.util.ArrayList<com.oplus.camera.ui.modepanel.k_renamed> arrayList, boolean z_renamed) {
        super.a_renamed(arrayList);
        if (z_renamed) {
            this.d_renamed = this.e_renamed;
            return;
        }
        int i_renamed = this.e_renamed;
        if (i_renamed == 0) {
            this.d_renamed = i_renamed;
        }
    }

    public void a_renamed(com.oplus.camera.ui.modepanel.o_renamed.a_renamed aVar) {
        this.f6750c = aVar;
    }

    public void c_renamed(int i_renamed) {
        int i2 = this.e_renamed;
        if (i2 == i_renamed) {
            return;
        }
        this.d_renamed = i2;
        this.e_renamed = i_renamed;
        if (this.f_renamed) {
            return;
        }
        notifyDataSetChanged();
    }

    public void d_renamed(int i_renamed) {
        this.d_renamed = i_renamed;
        this.e_renamed = i_renamed;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.a_renamed
    /* renamed from: a_renamed, reason: merged with bridge method [inline-methods] */
    public com.oplus.camera.ui.modepanel.o_renamed.b_renamed onCreateViewHolder(android.view.ViewGroup viewGroup, int i_renamed) {
        com.oplus.camera.e_renamed.b_renamed(f6749b, "onCreateViewHolder, mMoreModeItemID: " + this.g_renamed);
        return new com.oplus.camera.ui.modepanel.o_renamed.b_renamed(android.view.LayoutInflater.from(this.f6709a).inflate(this.g_renamed, viewGroup, false));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.a_renamed
    public void onBindViewHolder(androidx.recyclerview.widget.RecyclerView.w_renamed wVar, int i_renamed) {
        a_renamed((com.oplus.camera.ui.modepanel.o_renamed.b_renamed) wVar, i_renamed, java.util.Collections.EMPTY_LIST);
    }

    private void a_renamed(com.oplus.camera.ui.modepanel.o_renamed.b_renamed bVar, int i_renamed, java.util.List list) {
        if (bVar.f6752b == null) {
            return;
        }
        com.oplus.camera.ui.modepanel.k_renamed kVarB = b_renamed(i_renamed);
        bVar.f6752b.setImage(com.oplus.camera.util.Util.a_renamed(this.f6709a.getBaseContext(), kVarB.c_renamed()));
        if (-1 == kVarB.d_renamed() || this.f_renamed) {
            bVar.f6752b.setSubscriptHint(null);
        } else if (!bVar.f6752b.a_renamed()) {
            bVar.f6752b.setSubscriptHintRTL(1 == this.f6709a.getApplicationContext().getResources().getConfiguration().getLayoutDirection());
            bVar.f6752b.setSubscriptHint(android.graphics.BitmapFactory.decodeResource(this.f6709a.getResources(), kVarB.d_renamed()));
        }
        if (this.f_renamed) {
            bVar.f6752b.a_renamed(bVar.f6752b.getTargetDegree() != 0 ? this.e_renamed : 0, 0);
        } else {
            bVar.f6752b.a_renamed(this.d_renamed, this.e_renamed);
        }
        bVar.f6752b.setText(kVarB.a_renamed());
        bVar.itemView.setVisibility(kVarB.e_renamed());
        bVar.itemView.setTag(com.oplus.camera.R_renamed.id_renamed.tag_recycle_view_mode_info, kVarB);
    }

    public void a_renamed(boolean z_renamed) {
        this.f_renamed = z_renamed;
    }

    /* compiled from: MoreModeAdapter.java */
    public class b_renamed extends androidx.recyclerview.widget.RecyclerView.w_renamed implements android.view.View.OnClickListener {

        /* renamed from: b_renamed, reason: collision with root package name */
        private com.oplus.camera.ui.RotateMoreItem f6752b;

        public b_renamed(android.view.View view) {
            super(view);
            this.f6752b = (com.oplus.camera.ui.RotateMoreItem) view.findViewById(com.oplus.camera.R_renamed.id_renamed.more_item);
            view.setOnClickListener(this);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(android.view.View view) {
            if (com.oplus.camera.ui.modepanel.o_renamed.this.f_renamed) {
                return;
            }
            com.oplus.camera.ui.modepanel.o_renamed.this.f6750c.a_renamed(((com.oplus.camera.ui.modepanel.k_renamed) view.getTag(com.oplus.camera.R_renamed.id_renamed.tag_recycle_view_mode_info)).b_renamed());
        }
    }

    public void e_renamed(int i_renamed) {
        this.h_renamed = i_renamed;
        com.oplus.camera.e_renamed.b_renamed(f6749b, "setLayoutMode: " + this.h_renamed);
        if (i_renamed == 1) {
            this.g_renamed = com.oplus.camera.R_renamed.layout.more_mode_item_vertical;
        } else {
            this.g_renamed = com.oplus.camera.R_renamed.layout.more_mode_item;
        }
    }

    public void d_renamed() {
        this.f6709a = null;
        this.f6750c = null;
    }
}

package com.oplus.camera.doubleexposure;

/* compiled from: EffectMenuAdapter.java */
/* loaded from: classes2.dex */
public class e_renamed extends androidx.recyclerview.widget.RecyclerView.a_renamed<com.oplus.camera.doubleexposure.e_renamed.a_renamed> {

    /* renamed from: a_renamed, reason: collision with root package name */
    private android.content.Context f4394a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private java.util.List<com.oplus.camera.doubleexposure.f_renamed> f4395b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private com.oplus.camera.doubleexposure.f_renamed f4396c = null;
    private com.oplus.camera.doubleexposure.e_renamed.b_renamed d_renamed = null;

    /* compiled from: EffectMenuAdapter.java */
    public interface b_renamed {
        void a_renamed(com.oplus.camera.doubleexposure.f_renamed fVar);
    }

    public e_renamed(android.content.Context context, java.util.List<com.oplus.camera.doubleexposure.f_renamed> list) {
        this.f4394a = null;
        this.f4395b = null;
        this.f4394a = context;
        this.f4395b = list;
    }

    public void a_renamed(com.oplus.camera.doubleexposure.e_renamed.b_renamed bVar) {
        this.d_renamed = bVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.a_renamed
    /* renamed from: a_renamed, reason: merged with bridge method [inline-methods] */
    public com.oplus.camera.doubleexposure.e_renamed.a_renamed onCreateViewHolder(android.view.ViewGroup viewGroup, int i_renamed) {
        com.oplus.camera.doubleexposure.e_renamed.a_renamed aVar = new com.oplus.camera.doubleexposure.e_renamed.a_renamed(android.view.LayoutInflater.from(this.f4394a).inflate(com.oplus.camera.R_renamed.layout.item_effect_menu, (android.view.ViewGroup) null, false));
        aVar.setIsRecyclable(false);
        return aVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.a_renamed
    /* renamed from: a_renamed, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(com.oplus.camera.doubleexposure.e_renamed.a_renamed aVar, int i_renamed) {
        final com.oplus.camera.doubleexposure.f_renamed fVar = this.f4395b.get(i_renamed);
        aVar.f4399a.setBitmap(android.graphics.BitmapFactory.decodeResource(this.f4394a.getResources(), fVar.b_renamed()));
        aVar.f4399a.setParam(fVar);
        if (fVar.d_renamed()) {
            this.f4396c = fVar;
        }
        aVar.f4399a.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.oplus.camera.doubleexposure.e_renamed.1
            @Override // android.view.View.OnClickListener
            public void onClick(android.view.View view) {
                if (fVar.d_renamed()) {
                    return;
                }
                fVar.a_renamed(true);
                if (com.oplus.camera.doubleexposure.e_renamed.this.f4396c != null) {
                    com.oplus.camera.doubleexposure.e_renamed.this.f4396c.a_renamed(false);
                }
                com.oplus.camera.doubleexposure.e_renamed.this.f4396c = fVar;
                com.oplus.camera.doubleexposure.e_renamed.this.notifyDataSetChanged();
                if (com.oplus.camera.doubleexposure.e_renamed.this.d_renamed != null) {
                    com.oplus.camera.doubleexposure.e_renamed.this.d_renamed.a_renamed(fVar);
                }
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.a_renamed
    public int getItemCount() {
        java.util.List<com.oplus.camera.doubleexposure.f_renamed> list = this.f4395b;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    /* compiled from: EffectMenuAdapter.java */
    public static class a_renamed extends androidx.recyclerview.widget.RecyclerView.w_renamed {

        /* renamed from: a_renamed, reason: collision with root package name */
        com.oplus.camera.ui.widget.RoundRingImageView f4399a;

        public a_renamed(android.view.View view) {
            super(view);
            this.f4399a = (com.oplus.camera.ui.widget.RoundRingImageView) view.findViewById(com.oplus.camera.R_renamed.id_renamed.bgIv);
        }
    }
}

package com.oplus.camera.photo3d.ui;

/* compiled from: SceneMenuAdapter.java */
/* loaded from: classes2.dex */
public class f_renamed extends androidx.recyclerview.widget.RecyclerView.a_renamed<com.oplus.camera.photo3d.ui.f_renamed.b_renamed> {

    /* renamed from: a_renamed, reason: collision with root package name */
    private java.util.List<com.oplus.camera.photo3d.ui.d_renamed> f5070a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private boolean f5071b = true;

    /* renamed from: c_renamed, reason: collision with root package name */
    private android.content.Context f5072c;
    private com.oplus.camera.photo3d.ui.f_renamed.a_renamed d_renamed;

    /* compiled from: SceneMenuAdapter.java */
    public interface a_renamed {
        void a_renamed(com.oplus.camera.photo3d.ui.d_renamed dVar);
    }

    public f_renamed(android.content.Context context, java.util.List<com.oplus.camera.photo3d.ui.d_renamed> list) {
        this.f5072c = context;
        this.f5070a = list;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.a_renamed
    /* renamed from: a_renamed, reason: merged with bridge method [inline-methods] */
    public com.oplus.camera.photo3d.ui.f_renamed.b_renamed onCreateViewHolder(android.view.ViewGroup viewGroup, int i_renamed) {
        com.oplus.camera.photo3d.ui.f_renamed.b_renamed bVar = new com.oplus.camera.photo3d.ui.f_renamed.b_renamed(android.view.LayoutInflater.from(viewGroup.getContext()).inflate(com.oplus.camera.R_renamed.layout.camera_3d_photo_scene_menu_item, viewGroup, false));
        bVar.setIsRecyclable(true);
        return bVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.a_renamed
    /* renamed from: a_renamed, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(final com.oplus.camera.photo3d.ui.f_renamed.b_renamed bVar, final int i_renamed) {
        if (!this.f5071b) {
            com.oplus.camera.e_renamed.b_renamed("EffectMenuAdapter", "onBindViewHolder, return for not enable");
            return;
        }
        final com.oplus.camera.photo3d.ui.d_renamed dVar = this.f5070a.get(i_renamed);
        bVar.f5077b.setText(dVar.b_renamed());
        bVar.f5077b.setTextSize(0, this.f5072c.getResources().getDimension(com.oplus.camera.R_renamed.dimen.long_exposure_item_text_size));
        bVar.f5077b.setTypeface(com.oplus.camera.util.Util.c_renamed(true));
        bVar.f5077b.setShadowLayer(this.f5072c.getResources().getDimension(com.oplus.camera.R_renamed.dimen.long_exposure_scene_text_radius_shadow), 0.0f, 0.0f, this.f5072c.getResources().getColor(com.oplus.camera.R_renamed.color.color_black_with_30_percent_transparency));
        bVar.f5076a.setGifResource(dVar.c_renamed());
        bVar.f5076a.setSelected(dVar.d_renamed());
        bVar.itemView.setSelected(dVar.d_renamed());
        bVar.f5078c.setOnTouchListener(new android.view.View.OnTouchListener() { // from class: com.oplus.camera.photo3d.ui.f_renamed.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(android.view.View view, android.view.MotionEvent motionEvent) {
                com.oplus.camera.e_renamed.a_renamed("EffectMenuAdapter", "mBaseView, event: " + motionEvent.getAction());
                if (com.oplus.camera.photo3d.ui.f_renamed.this.f5071b) {
                    if (1 == motionEvent.getAction()) {
                        dVar.a_renamed(true);
                        for (int i2 = 0; i2 < com.oplus.camera.photo3d.ui.f_renamed.this.f5070a.size(); i2++) {
                            if (i_renamed != i2) {
                                ((com.oplus.camera.photo3d.ui.d_renamed) com.oplus.camera.photo3d.ui.f_renamed.this.f5070a.get(i2)).a_renamed(false);
                            }
                        }
                        com.oplus.camera.photo3d.ui.f_renamed.this.notifyDataSetChanged();
                        if (com.oplus.camera.photo3d.ui.f_renamed.this.d_renamed != null) {
                            com.oplus.camera.photo3d.ui.f_renamed.this.d_renamed.a_renamed(dVar);
                        }
                    }
                    bVar.f5078c.onTouchEvent(motionEvent);
                }
                return true;
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.a_renamed
    public int getItemCount() {
        java.util.List<com.oplus.camera.photo3d.ui.d_renamed> list = this.f5070a;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    /* compiled from: SceneMenuAdapter.java */
    public class b_renamed extends androidx.recyclerview.widget.RecyclerView.w_renamed {

        /* renamed from: a_renamed, reason: collision with root package name */
        com.oplus.camera.photo3d.ui.GifView f5076a;

        /* renamed from: b_renamed, reason: collision with root package name */
        android.widget.TextView f5077b;

        /* renamed from: c_renamed, reason: collision with root package name */
        com.oplus.camera.longexposure.LongExposureItemBaseView f5078c;
        com.oplus.camera.longexposure.LongExposureItemFrame d_renamed;

        public b_renamed(android.view.View view) {
            super(view);
            this.f5078c = (com.oplus.camera.longexposure.LongExposureItemBaseView) view.findViewById(com.oplus.camera.R_renamed.id_renamed.camera_3d_photo_item_base);
            this.d_renamed = (com.oplus.camera.longexposure.LongExposureItemFrame) view.findViewById(com.oplus.camera.R_renamed.id_renamed.camera_3d_photo_item_frame);
            this.f5076a = (com.oplus.camera.photo3d.ui.GifView) view.findViewById(com.oplus.camera.R_renamed.id_renamed.camera_3d_photo_item_gif);
            this.f5077b = (android.widget.TextView) view.findViewById(com.oplus.camera.R_renamed.id_renamed.camera_3d_photo_item_text);
        }
    }

    public void a_renamed(com.oplus.camera.photo3d.ui.f_renamed.a_renamed aVar) {
        this.d_renamed = aVar;
    }
}

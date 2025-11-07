package com.oplus.camera.longexposure;

/* compiled from: LongExposureEffectMenuAdapter.java */
/* loaded from: classes2.dex */
public class c_renamed extends androidx.recyclerview.widget.RecyclerView.a_renamed<com.oplus.camera.longexposure.c_renamed.b_renamed> {

    /* renamed from: a_renamed, reason: collision with root package name */
    private android.content.Context f4809a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private java.util.List<com.oplus.camera.longexposure.j_renamed> f4810b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private com.oplus.camera.longexposure.c_renamed.a_renamed f4811c = null;
    private boolean d_renamed = true;

    /* compiled from: LongExposureEffectMenuAdapter.java */
    public interface a_renamed {
        void a_renamed(com.oplus.camera.longexposure.j_renamed jVar);
    }

    public c_renamed(android.content.Context context, java.util.List<com.oplus.camera.longexposure.j_renamed> list) {
        this.f4809a = null;
        this.f4809a = context;
        this.f4810b = list;
    }

    public void a_renamed(com.oplus.camera.longexposure.c_renamed.a_renamed aVar) {
        this.f4811c = aVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.a_renamed
    /* renamed from: a_renamed, reason: merged with bridge method [inline-methods] */
    public com.oplus.camera.longexposure.c_renamed.b_renamed onCreateViewHolder(android.view.ViewGroup viewGroup, int i_renamed) {
        com.oplus.camera.longexposure.c_renamed.b_renamed bVar = new com.oplus.camera.longexposure.c_renamed.b_renamed(android.view.LayoutInflater.from(viewGroup.getContext()).inflate(com.oplus.camera.R_renamed.layout.long_exposure_effect_menu_item, viewGroup, false));
        bVar.setIsRecyclable(true);
        return bVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.a_renamed
    /* renamed from: a_renamed, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(final com.oplus.camera.longexposure.c_renamed.b_renamed bVar, final int i_renamed) {
        final com.oplus.camera.longexposure.j_renamed jVar = this.f4810b.get(i_renamed);
        if (this.d_renamed) {
            if (bVar.d_renamed != null) {
                bVar.d_renamed.setText(jVar.b_renamed());
                bVar.d_renamed.setTextSize(0, this.f4809a.getResources().getDimension(com.oplus.camera.R_renamed.dimen.long_exposure_item_text_size));
                bVar.d_renamed.setTypeface(com.oplus.camera.util.Util.c_renamed(true));
                bVar.d_renamed.setShadowLayer(this.f4809a.getResources().getDimension(com.oplus.camera.R_renamed.dimen.long_exposure_scene_text_radius_shadow), 0.0f, 0.0f, this.f4809a.getResources().getColor(com.oplus.camera.R_renamed.color.color_black_with_30_percent_transparency));
            }
            if (bVar.f4817c != null) {
                bVar.f4817c.setBitmap(android.graphics.BitmapFactory.decodeResource(this.f4809a.getResources(), jVar.c_renamed()));
                bVar.f4817c.setMRadius(this.f4809a.getResources().getDimension(com.oplus.camera.R_renamed.dimen.long_exposure_effect_menu_inner_radius));
            }
            if (jVar.d_renamed()) {
                bVar.itemView.setSelected(true);
            } else {
                bVar.itemView.setSelected(false);
            }
        }
        bVar.f4815a.setOnTouchListener(new android.view.View.OnTouchListener() { // from class: com.oplus.camera.longexposure.c_renamed.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(android.view.View view, android.view.MotionEvent motionEvent) {
                com.oplus.camera.e_renamed.a_renamed("LongExposureEffectMenuAdapter", "mBaseView, event: " + motionEvent.getAction());
                if (com.oplus.camera.longexposure.c_renamed.this.d_renamed) {
                    if (1 == motionEvent.getAction()) {
                        jVar.a_renamed(true);
                        for (int i2 = 0; i2 < com.oplus.camera.longexposure.c_renamed.this.f4810b.size(); i2++) {
                            if (i_renamed != i2) {
                                ((com.oplus.camera.longexposure.j_renamed) com.oplus.camera.longexposure.c_renamed.this.f4810b.get(i2)).a_renamed(false);
                            }
                        }
                        com.oplus.camera.longexposure.c_renamed.this.notifyDataSetChanged();
                        if (com.oplus.camera.longexposure.c_renamed.this.f4811c != null) {
                            com.oplus.camera.longexposure.c_renamed.this.f4811c.a_renamed(jVar);
                        }
                    }
                    bVar.f4815a.onTouchEvent(motionEvent);
                }
                return true;
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.a_renamed
    public int getItemCount() {
        return this.f4810b.size();
    }

    /* compiled from: LongExposureEffectMenuAdapter.java */
    public class b_renamed extends androidx.recyclerview.widget.RecyclerView.w_renamed {

        /* renamed from: a_renamed, reason: collision with root package name */
        com.oplus.camera.longexposure.LongExposureItemBaseView f4815a;

        /* renamed from: b_renamed, reason: collision with root package name */
        com.oplus.camera.longexposure.LongExposureItemFrame f4816b;

        /* renamed from: c_renamed, reason: collision with root package name */
        com.oplus.camera.ui.widget.RoundImageView f4817c;
        android.widget.TextView d_renamed;

        public b_renamed(android.view.View view) {
            super(view);
            this.f4815a = (com.oplus.camera.longexposure.LongExposureItemBaseView) view.findViewById(com.oplus.camera.R_renamed.id_renamed.long_exposure_item_base);
            this.f4816b = (com.oplus.camera.longexposure.LongExposureItemFrame) view.findViewById(com.oplus.camera.R_renamed.id_renamed.long_exposure_item_frame);
            this.f4817c = (com.oplus.camera.ui.widget.RoundImageView) view.findViewById(com.oplus.camera.R_renamed.id_renamed.long_exposure_item_iv);
            this.d_renamed = (android.widget.TextView) view.findViewById(com.oplus.camera.R_renamed.id_renamed.long_exposure_item_text);
        }
    }

    public void a_renamed(boolean z_renamed) {
        this.d_renamed = z_renamed;
    }
}

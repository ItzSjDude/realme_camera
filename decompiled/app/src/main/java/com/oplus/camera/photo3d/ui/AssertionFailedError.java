package com.oplus.camera.photo3d.ui;

/* compiled from: GuideRecyclerViewAdapter.java */
/* loaded from: classes2.dex */
public class b_renamed extends androidx.recyclerview.widget.RecyclerView.a_renamed<androidx.recyclerview.widget.RecyclerView.w_renamed> {

    /* renamed from: a_renamed, reason: collision with root package name */
    private android.content.Context f5044a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private java.util.List<com.oplus.camera.photo3d.ui.a_renamed> f5045b = new java.util.ArrayList(4);

    /* renamed from: c_renamed, reason: collision with root package name */
    private android.util.SparseArray<com.oplus.camera.photo3d.ui.b_renamed.a_renamed> f5046c = new android.util.SparseArray<>(3);

    public b_renamed(android.content.Context context) {
        this.f5044a = context;
        a_renamed();
    }

    private void a_renamed() {
        this.f5045b.add(new com.oplus.camera.photo3d.ui.a_renamed(com.oplus.camera.R_renamed.string.scene_dolly_zoom_title, com.oplus.camera.R_renamed.string.scene_dolly_zoom_subtitle, com.oplus.camera.R_renamed.drawable.cover_dolly_zoom, android.net.Uri.parse("android.resource://" + this.f5044a.getPackageName() + "/" + com.oplus.camera.R_renamed.raw.guide_dolly_zoom)));
        this.f5045b.add(new com.oplus.camera.photo3d.ui.a_renamed(com.oplus.camera.R_renamed.string.scene_circle_title, com.oplus.camera.R_renamed.string.scene_circle_subtitle, com.oplus.camera.R_renamed.drawable.cover_circle, android.net.Uri.parse("android.resource://" + this.f5044a.getPackageName() + "/" + com.oplus.camera.R_renamed.raw.guide_circle)));
        this.f5045b.add(new com.oplus.camera.photo3d.ui.a_renamed(com.oplus.camera.R_renamed.string.scene_swing_title, com.oplus.camera.R_renamed.string.scene_swing_subtitle, com.oplus.camera.R_renamed.drawable.cover_swing, android.net.Uri.parse("android.resource://" + this.f5044a.getPackageName() + "/" + com.oplus.camera.R_renamed.raw.guide_swing)));
        this.f5045b.add(new com.oplus.camera.photo3d.ui.a_renamed(com.oplus.camera.R_renamed.string.scene_portrait_title, com.oplus.camera.R_renamed.string.scene_portrait_subtitle, com.oplus.camera.R_renamed.drawable.cover_portrait, android.net.Uri.parse("android.resource://" + this.f5044a.getPackageName() + "/" + com.oplus.camera.R_renamed.raw.guide_portrait)));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.a_renamed
    public int getItemViewType(int i_renamed) {
        if (i_renamed < 1) {
            return 1;
        }
        return i_renamed >= b_renamed() + 1 ? 2 : 3;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.a_renamed
    public androidx.recyclerview.widget.RecyclerView.w_renamed onCreateViewHolder(android.view.ViewGroup viewGroup, int i_renamed) {
        if (1 == i_renamed) {
            return new com.oplus.camera.photo3d.ui.b_renamed.c_renamed(android.view.LayoutInflater.from(viewGroup.getContext()).inflate(com.oplus.camera.R_renamed.layout.guide_header_item_3d_photo_layout, viewGroup, false));
        }
        if (2 == i_renamed) {
            return new com.oplus.camera.photo3d.ui.b_renamed.GuideRecyclerViewAdapter_4(android.view.LayoutInflater.from(viewGroup.getContext()).inflate(com.oplus.camera.R_renamed.layout.guide_footer_item_3d_photo_layout, viewGroup, false));
        }
        return new com.oplus.camera.photo3d.ui.b_renamed.a_renamed(android.view.LayoutInflater.from(viewGroup.getContext()).inflate(com.oplus.camera.R_renamed.layout.guide_content_item_3d_photo_layout, viewGroup, false));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.a_renamed
    public void onBindViewHolder(androidx.recyclerview.widget.RecyclerView.w_renamed wVar, int i_renamed) throws java.lang.IllegalStateException, java.io.IOException, java.lang.SecurityException, java.lang.IllegalArgumentException {
        if (3 == wVar.getItemViewType()) {
            final int i2 = i_renamed - 1;
            com.oplus.camera.photo3d.ui.b_renamed.a_renamed aVar = (com.oplus.camera.photo3d.ui.b_renamed.a_renamed) wVar;
            com.oplus.camera.photo3d.ui.a_renamed aVar2 = this.f5045b.get(i2);
            aVar.f5049a.setText(aVar2.a_renamed());
            aVar.f5050b.setText(aVar2.b_renamed());
            aVar.f5051c.setVideoCover(aVar2.c_renamed());
            aVar.f5051c.setVideoURI(aVar2.d_renamed());
            aVar.f5051c.setSelected(aVar2.e_renamed());
            aVar.f5051c.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.oplus.camera.photo3d.ui.b_renamed.1
                @Override // android.view.View.OnClickListener
                public void onClick(android.view.View view) throws java.lang.IllegalStateException {
                    int i3 = 0;
                    while (i3 < com.oplus.camera.photo3d.ui.b_renamed.this.f5046c.size()) {
                        com.oplus.camera.e_renamed.b_renamed("VideoItemAdapter", "onClick, position: " + i2 + ", i_renamed: " + i3);
                        ((com.oplus.camera.photo3d.ui.b_renamed.a_renamed) com.oplus.camera.photo3d.ui.b_renamed.this.f5046c.get(i3)).f5051c.setSelected(i2 == i3);
                        i3++;
                    }
                }
            });
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.a_renamed
    public int getItemCount() {
        return b_renamed() + 1 + 1;
    }

    private int b_renamed() {
        return this.f5045b.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.a_renamed
    public void onViewAttachedToWindow(androidx.recyclerview.widget.RecyclerView.w_renamed wVar) {
        super.onViewAttachedToWindow(wVar);
        if (3 == wVar.getItemViewType()) {
            com.oplus.camera.photo3d.ui.b_renamed.a_renamed aVar = (com.oplus.camera.photo3d.ui.b_renamed.a_renamed) wVar;
            this.f5046c.put(aVar.getLayoutPosition() - 1, aVar);
            aVar.f5051c.b_renamed();
        }
    }

    /* compiled from: GuideRecyclerViewAdapter.java */
    public class a_renamed extends androidx.recyclerview.widget.RecyclerView.w_renamed {

        /* renamed from: a_renamed, reason: collision with root package name */
        com.oplus.camera.ui.widget.GuideTextView f5049a;

        /* renamed from: b_renamed, reason: collision with root package name */
        com.oplus.camera.ui.widget.GuideTextView f5050b;

        /* renamed from: c_renamed, reason: collision with root package name */
        com.oplus.camera.photo3d.ui.GuideVideoItemView f5051c;

        public a_renamed(android.view.View view) {
            super(view);
            this.f5049a = (com.oplus.camera.ui.widget.GuideTextView) view.findViewById(com.oplus.camera.R_renamed.id_renamed.guide_item_title);
            this.f5050b = (com.oplus.camera.ui.widget.GuideTextView) view.findViewById(com.oplus.camera.R_renamed.id_renamed.guide_item_subtitle);
            this.f5051c = (com.oplus.camera.photo3d.ui.GuideVideoItemView) view.findViewById(com.oplus.camera.R_renamed.id_renamed.guide_video_item);
            this.f5051c.setRatio(0.5625d);
        }
    }

    /* compiled from: GuideRecyclerViewAdapter.java */
    public class c_renamed extends androidx.recyclerview.widget.RecyclerView.w_renamed {
        public c_renamed(android.view.View view) {
            super(view);
        }
    }

    /* compiled from: GuideRecyclerViewAdapter.java */
    /* renamed from: com.oplus.camera.photo3d.ui.b_renamed$b_renamed, reason: collision with other inner class name */
    public class GuideRecyclerViewAdapter_4 extends androidx.recyclerview.widget.RecyclerView.w_renamed {
        public GuideRecyclerViewAdapter_4(android.view.View view) {
            super(view);
        }
    }
}

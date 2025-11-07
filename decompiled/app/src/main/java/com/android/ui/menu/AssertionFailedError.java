package com.android.ui.menu;

/* compiled from: MultiplePageAdapter.java */
/* loaded from: classes.dex */
public class b_renamed extends androidx.recyclerview.widget.RecyclerView.a_renamed<com.android.ui.menu.b_renamed.a_renamed> {

    /* renamed from: a_renamed, reason: collision with root package name */
    private static int f2309a = 2;

    public b_renamed(android.content.Context context) {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.a_renamed
    /* renamed from: a_renamed, reason: merged with bridge method [inline-methods] */
    public com.android.ui.menu.b_renamed.a_renamed onCreateViewHolder(android.view.ViewGroup viewGroup, int i_renamed) {
        return new com.android.ui.menu.b_renamed.a_renamed(android.view.LayoutInflater.from(viewGroup.getContext()).inflate(com.oplus.camera.R_renamed.layout.item_view_pager_multiple_page_guides, viewGroup, false));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.a_renamed
    /* renamed from: a_renamed, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(com.android.ui.menu.b_renamed.a_renamed aVar, int i_renamed) {
        com.oplus.camera.e_renamed.f_renamed("MultiplePageAdapter", "onBindViewHolder, position:" + i_renamed);
        if (i_renamed == 0) {
            if (com.oplus.camera.util.Util.ap_renamed()) {
                aVar.e_renamed = com.oplus.camera.R_renamed.raw.guide_gesture_capture_anim_dark;
            } else {
                aVar.e_renamed = com.oplus.camera.R_renamed.raw.guide_gesture_capture_anim_light;
            }
            aVar.f2312c.setText(com.oplus.camera.R_renamed.string.camera_gesture_shutter_title);
            aVar.d_renamed.setText(com.oplus.camera.R_renamed.string.hint_gesture_capture);
        } else {
            if (com.oplus.camera.util.Util.ap_renamed()) {
                aVar.e_renamed = com.oplus.camera.R_renamed.raw.guide_touch_screen_to_capture_anim_dark;
            } else {
                aVar.e_renamed = com.oplus.camera.R_renamed.raw.guide_touch_screen_to_capture_anim_light;
            }
            aVar.f2312c.setText(com.oplus.camera.R_renamed.string.camera_tap_shutter_title);
            aVar.d_renamed.setText(com.oplus.camera.R_renamed.string.camera_tap_screen_shutter_summary);
        }
        aVar.f2311b.setAnimation(aVar.e_renamed);
        aVar.f2311b.setForceDarkAllowed(false);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.a_renamed
    /* renamed from: a_renamed, reason: merged with bridge method [inline-methods] */
    public void onViewDetachedFromWindow(com.android.ui.menu.b_renamed.a_renamed aVar) {
        aVar.f2311b.e_renamed();
        super.onViewDetachedFromWindow(aVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.a_renamed
    /* renamed from: b_renamed, reason: merged with bridge method [inline-methods] */
    public void onViewAttachedToWindow(com.android.ui.menu.b_renamed.a_renamed aVar) {
        super.onViewAttachedToWindow(aVar);
        aVar.f2311b.a_renamed();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.a_renamed
    public int getItemCount() {
        return f2309a;
    }

    /* compiled from: MultiplePageAdapter.java */
    public class a_renamed extends androidx.recyclerview.widget.RecyclerView.w_renamed {

        /* renamed from: b_renamed, reason: collision with root package name */
        private com.airbnb.lottie.LottieAnimationView f2311b;

        /* renamed from: c_renamed, reason: collision with root package name */
        private android.widget.TextView f2312c;
        private android.widget.TextView d_renamed;
        private int e_renamed;

        public a_renamed(android.view.View view) {
            super(view);
            this.f2311b = null;
            this.f2312c = null;
            this.d_renamed = null;
            this.e_renamed = 0;
            this.f2311b = (com.airbnb.lottie.LottieAnimationView) view.findViewById(com.oplus.camera.R_renamed.id_renamed.anim_guide);
            this.f2312c = (android.widget.TextView) view.findViewById(com.oplus.camera.R_renamed.id_renamed.guide_page_title);
            this.d_renamed = (android.widget.TextView) view.findViewById(com.oplus.camera.R_renamed.id_renamed.guide_page_instruction);
        }
    }
}

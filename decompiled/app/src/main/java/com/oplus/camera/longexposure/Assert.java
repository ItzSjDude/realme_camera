package com.oplus.camera.longexposure;

/* compiled from: LongExposureBottomGuideAdapter.java */
/* loaded from: classes2.dex */
public class a_renamed extends androidx.recyclerview.widget.RecyclerView.a_renamed<com.oplus.camera.longexposure.a_renamed.LongExposureBottomGuideAdapter_2> {

    /* renamed from: a_renamed, reason: collision with root package name */
    private java.util.List<com.oplus.camera.longexposure.b_renamed> f4802a;

    public a_renamed(java.util.List<com.oplus.camera.longexposure.b_renamed> list) {
        this.f4802a = list;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.a_renamed
    /* renamed from: a_renamed, reason: merged with bridge method [inline-methods] */
    public com.oplus.camera.longexposure.a_renamed.LongExposureBottomGuideAdapter_2 onCreateViewHolder(android.view.ViewGroup viewGroup, int i_renamed) {
        com.oplus.camera.longexposure.a_renamed.LongExposureBottomGuideAdapter_2 c0106a = new com.oplus.camera.longexposure.a_renamed.LongExposureBottomGuideAdapter_2(android.view.LayoutInflater.from(viewGroup.getContext()).inflate(com.oplus.camera.R_renamed.layout.long_exposure_bottom_guide_item, viewGroup, false));
        c0106a.setIsRecyclable(true);
        return c0106a;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.a_renamed
    /* renamed from: a_renamed, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(com.oplus.camera.longexposure.a_renamed.LongExposureBottomGuideAdapter_2 c0106a, int i_renamed) {
        com.oplus.camera.longexposure.b_renamed bVar = this.f4802a.get(i_renamed);
        if (c0106a.f4803a != null) {
            c0106a.f4803a.setText(bVar.a_renamed());
            a_renamed(c0106a.f4803a);
        }
        if (c0106a.f4804b != null) {
            c0106a.f4804b.setText(bVar.b_renamed());
        }
        if (c0106a.f4805c != null) {
            c0106a.f4805c.setImageDrawable(bVar.c_renamed());
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.a_renamed
    public int getItemCount() {
        return this.f4802a.size();
    }

    private void a_renamed(android.widget.TextView textView) {
        java.lang.String string;
        int iIndexOf;
        try {
            if (1 != androidx.core.f_renamed.f_renamed.a_renamed(java.util.Locale.getDefault()) || textView == null || textView.getText() == null || (iIndexOf = (string = textView.getText().toString()).indexOf(40)) <= 0 || iIndexOf >= string.length()) {
                return;
            }
            java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
            java.lang.String strSubstring = string.substring(0, iIndexOf);
            java.lang.String strSubstring2 = string.substring(iIndexOf);
            stringBuffer.append(strSubstring);
            stringBuffer.append(strSubstring2);
            textView.setText(androidx.core.f_renamed.a_renamed.a_renamed(true).a_renamed(stringBuffer, androidx.core.f_renamed.e_renamed.e_renamed));
        } catch (java.lang.Exception e_renamed) {
            com.oplus.camera.e_renamed.f_renamed("LongExposureBottomGuideAdapter", " setRtlProfessionalTitleText error : " + e_renamed.toString());
        }
    }

    /* compiled from: LongExposureBottomGuideAdapter.java */
    /* renamed from: com.oplus.camera.longexposure.a_renamed$a_renamed, reason: collision with other inner class name */
    public class LongExposureBottomGuideAdapter_2 extends androidx.recyclerview.widget.RecyclerView.w_renamed {

        /* renamed from: a_renamed, reason: collision with root package name */
        com.oplus.camera.ui.widget.GuideTextView f4803a;

        /* renamed from: b_renamed, reason: collision with root package name */
        com.oplus.camera.ui.widget.GuideTextView f4804b;

        /* renamed from: c_renamed, reason: collision with root package name */
        android.widget.ImageView f4805c;

        public LongExposureBottomGuideAdapter_2(android.view.View view) {
            super(view);
            this.f4803a = (com.oplus.camera.ui.widget.GuideTextView) view.findViewById(com.oplus.camera.R_renamed.id_renamed.long_exposure_scene_title);
            this.f4804b = (com.oplus.camera.ui.widget.GuideTextView) view.findViewById(com.oplus.camera.R_renamed.id_renamed.long_exposure_scene_description);
            this.f4805c = (android.widget.ImageView) view.findViewById(com.oplus.camera.R_renamed.id_renamed.iv_long_exposure_scene);
        }
    }
}

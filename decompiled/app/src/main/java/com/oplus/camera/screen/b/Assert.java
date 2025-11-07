package com.oplus.camera.screen.b_renamed;

/* compiled from: BaseScreenMode.java */
/* loaded from: classes2.dex */
public abstract class a_renamed extends com.oplus.camera.screen.b_renamed.o_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    protected java.util.Map<java.lang.Integer, com.oplus.camera.screen.c_renamed> f5360a = new java.util.HashMap();

    /* renamed from: b_renamed, reason: collision with root package name */
    protected int f5361b = 0;

    /* renamed from: c_renamed, reason: collision with root package name */
    protected int f5362c = 0;
    private boolean d_renamed = false;
    private com.oplus.camera.screen.ScreenRelativeLayout e_renamed = null;

    public int a_renamed(android.app.Activity activity, int i_renamed) {
        return i_renamed;
    }

    public abstract int a_renamed(boolean z_renamed);

    protected abstract void a_renamed(com.oplus.camera.screen.ScreenRelativeLayout screenRelativeLayout);

    public boolean a_renamed() {
        return false;
    }

    public java.lang.String h_renamed() {
        return com.oplus.camera.aps.constant.ApsConstant.CAPTURE_MODE_COMMON;
    }

    public boolean i_renamed() {
        return true;
    }

    public void a_renamed(android.app.Activity activity) {
        if (this.d_renamed) {
            return;
        }
        b_renamed(activity);
        this.d_renamed = true;
    }

    protected void a_renamed(android.app.Activity activity, com.oplus.camera.screen.c_renamed cVar) {
        cVar.f5365c = new int[]{-1, com.oplus.camera.util.Util.T_renamed()};
        this.f5360a.put(java.lang.Integer.valueOf(com.oplus.camera.R_renamed.id_renamed.headline_view), cVar);
    }

    public void a_renamed(android.view.View... viewArr) {
        com.oplus.camera.screen.c_renamed cVar;
        for (android.view.View view : viewArr) {
            if (view != null && (cVar = this.f5360a.get(java.lang.Integer.valueOf(view.getId()))) != null) {
                com.oplus.camera.screen.d_renamed.a_renamed(view, cVar);
                view.requestLayout();
            }
        }
    }

    public void a_renamed(android.app.Activity activity, com.oplus.camera.screen.ScreenRelativeLayout screenRelativeLayout) {
        com.oplus.camera.screen.f_renamed.f5371a = com.oplus.camera.util.Util.getScreenWidth();
        com.oplus.camera.screen.f_renamed.f5372b = com.oplus.camera.util.Util.getScreenHeight();
        com.oplus.camera.e_renamed.b_renamed("BaseScreenMode", "sScreenWidth: " + com.oplus.camera.screen.f_renamed.f5371a + ", sScreenHeight: " + com.oplus.camera.screen.f_renamed.f5372b);
        com.oplus.camera.screen.d_renamed.a_renamed(screenRelativeLayout);
        screenRelativeLayout.setRotation(0.0f);
        a_renamed(screenRelativeLayout);
        screenRelativeLayout.getLayoutParams().width = this.f5361b;
        screenRelativeLayout.getLayoutParams().height = this.f5362c;
        screenRelativeLayout.requestLayout();
        a_renamed(activity);
    }

    protected void b_renamed(android.app.Activity activity) {
        if (com.oplus.camera.util.Util.t_renamed()) {
            d_renamed(activity);
        }
    }

    public int b_renamed() {
        return this.f5361b;
    }

    public java.util.ArrayList<java.lang.String> c_renamed() {
        java.util.ArrayList<java.lang.String> arrayList = new java.util.ArrayList<>();
        if (com.oplus.camera.util.Util.t_renamed()) {
            arrayList.add(com.oplus.camera.aps.constant.ApsConstant.CAPTURE_MODE_ID_PHOTO);
            arrayList.add(com.oplus.camera.aps.constant.ApsConstant.CAPTURE_MODE_STICKER);
            arrayList.add(com.oplus.camera.aps.constant.ApsConstant.CAPTURE_MODE_BREENO_SCAN);
        }
        return arrayList;
    }

    public com.oplus.camera.ui.preview.w_renamed a_renamed(android.content.Context context) {
        return new com.oplus.camera.ui.preview.w_renamed(com.oplus.camera.util.Util.getScreenWidth(), com.oplus.camera.util.Util.getScreenHeight());
    }

    public int c_renamed(android.app.Activity activity) {
        return activity.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.pi_ultra_wide_hint_layout_margin_top);
    }

    public void d_renamed(android.app.Activity activity) {
        if (activity.findViewById(com.oplus.camera.R_renamed.id_renamed.gallery_container) != null) {
            return;
        }
        android.content.res.Resources resources = activity.getResources();
        android.widget.RelativeLayout relativeLayout = (android.widget.RelativeLayout) activity.findViewById(com.oplus.camera.R_renamed.id_renamed.camera_root);
        android.widget.RelativeLayout.LayoutParams layoutParams = new android.widget.RelativeLayout.LayoutParams(0, 0);
        this.e_renamed = new com.oplus.camera.screen.ScreenRelativeLayout(activity);
        this.e_renamed.setId(com.oplus.camera.R_renamed.id_renamed.gallery_container);
        this.e_renamed.setLayoutParams(layoutParams);
        relativeLayout.addView(this.e_renamed, 5);
        this.e_renamed.setVisibility(8);
        com.oplus.camera.ui.inverse.InverseRelativeLayout inverseRelativeLayout = new com.oplus.camera.ui.inverse.InverseRelativeLayout(activity);
        inverseRelativeLayout.setId(com.oplus.camera.R_renamed.id_renamed.gallery_pager_inverse_layout);
        inverseRelativeLayout.setLayoutParams(new android.widget.RelativeLayout.LayoutParams(-1, -1));
        inverseRelativeLayout.setBackgroundResource(com.oplus.camera.R_renamed.color.gallery_preview_inverse_bg);
        this.e_renamed.addView(inverseRelativeLayout);
        androidx.viewpager2.widget.ViewPager2 viewPager2 = new androidx.viewpager2.widget.ViewPager2(activity);
        viewPager2.setId(com.oplus.camera.R_renamed.id_renamed.gallery_pager);
        android.widget.RelativeLayout.LayoutParams layoutParams2 = new android.widget.RelativeLayout.LayoutParams(-1, -1);
        layoutParams2.addRule(15);
        layoutParams2.addRule(14);
        viewPager2.setLayoutParams(layoutParams2);
        viewPager2.setHorizontalFadingEdgeEnabled(true);
        viewPager2.setOverScrollMode(0);
        viewPager2.setSaveEnabled(false);
        inverseRelativeLayout.addView(viewPager2);
        com.oplus.camera.ui.j_renamed jVar = new com.oplus.camera.ui.j_renamed(activity);
        jVar.setId(com.oplus.camera.R_renamed.id_renamed.gallery_menu_panel);
        android.widget.RelativeLayout.LayoutParams layoutParams3 = new android.widget.RelativeLayout.LayoutParams(resources.getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.gallery_bottom_menu_bar_width), resources.getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.gallery_bottom_menu_bar_height));
        layoutParams3.bottomMargin = resources.getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.gallery_menu_panel_bottom_margin);
        layoutParams3.setMarginStart(resources.getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.gallery_menu_panel_left_margin));
        layoutParams3.addRule(12);
        jVar.setLayoutParams(layoutParams3);
        jVar.setOrientation(0);
        jVar.setBackgroundResource(com.oplus.camera.R_renamed.drawable.bg_gallery_menu_panel);
        this.e_renamed.addView(jVar);
        com.oplus.camera.ui.inverse.InverseTextView inverseTextView = new com.oplus.camera.ui.inverse.InverseTextView(activity);
        inverseTextView.setId(com.oplus.camera.R_renamed.id_renamed.gallery_preview_empty_view);
        android.widget.RelativeLayout.LayoutParams layoutParams4 = new android.widget.RelativeLayout.LayoutParams(resources.getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.gallery_preview_no_content_view_width), resources.getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.gallery_preview_no_content_view_height));
        layoutParams4.addRule(15);
        layoutParams4.addRule(14);
        inverseTextView.setLayoutParams(layoutParams4);
        inverseTextView.setText(com.oplus.camera.R_renamed.string.camera_gallery_preview_no_content);
        inverseTextView.setTextSize(0, resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.gallery_preview_no_content_text_size));
        inverseTextView.setTextColor(activity.getColor(com.oplus.camera.R_renamed.color.color_white_with_30_percent_transparency));
        inverseTextView.setGravity(17);
        this.e_renamed.addView(inverseTextView);
    }

    public android.widget.RelativeLayout.LayoutParams d_renamed() throws android.content.res.Resources.NotFoundException {
        android.content.res.Resources resources = com.oplus.camera.MyApplication.d_renamed().getResources();
        android.widget.RelativeLayout.LayoutParams layoutParams = new android.widget.RelativeLayout.LayoutParams(-2, resources.getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.multicamera_type_layout_height));
        layoutParams.addRule(14);
        layoutParams.addRule(12);
        layoutParams.setMargins(0, 0, 0, com.oplus.camera.util.Util.O_renamed() + resources.getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.control_pane_margin_bottom_offset));
        return layoutParams;
    }

    public android.widget.RelativeLayout.LayoutParams e_renamed() {
        android.widget.RelativeLayout.LayoutParams layoutParams = new android.widget.RelativeLayout.LayoutParams(-2, com.oplus.camera.util.Util.getScreenWidth());
        layoutParams.addRule(12);
        layoutParams.addRule(14);
        layoutParams.bottomMargin = com.oplus.camera.util.Util.O_renamed();
        return layoutParams;
    }

    public android.widget.RelativeLayout.LayoutParams f_renamed() {
        android.widget.RelativeLayout.LayoutParams layoutParams = new android.widget.RelativeLayout.LayoutParams(-1, (int) com.oplus.camera.util.Util.h_renamed(com.oplus.camera.R_renamed.dimen.main_mode_bar_height));
        layoutParams.addRule(12);
        layoutParams.addRule(14);
        return layoutParams;
    }

    public android.widget.RelativeLayout.LayoutParams g_renamed() {
        int i_renamed = com.oplus.camera.util.Util.i_renamed(com.oplus.camera.R_renamed.dimen.sub_mode_bar_height);
        int i2 = com.oplus.camera.util.Util.i_renamed(com.oplus.camera.R_renamed.dimen.main_mode_bar_height);
        android.widget.RelativeLayout.LayoutParams layoutParams = new android.widget.RelativeLayout.LayoutParams(com.oplus.camera.util.Util.getScreenWidth(), i_renamed + com.oplus.camera.util.Util.i_renamed(com.oplus.camera.R_renamed.dimen.professional_mode_panel_container_margin_bottom));
        layoutParams.setMargins(0, 0, 0, i2);
        layoutParams.addRule(14);
        layoutParams.addRule(12);
        return layoutParams;
    }

    public void a_renamed(com.oplus.camera.p_renamed.a_renamed aVar, int i_renamed, int i2) {
        int i3 = com.oplus.camera.util.Util.i_renamed(com.oplus.camera.R_renamed.dimen.professional_histogram_margin_top);
        int i4 = com.oplus.camera.util.Util.i_renamed(com.oplus.camera.R_renamed.dimen.professional_histogram_margin_start);
        int i5 = com.oplus.camera.util.Util.i_renamed(com.oplus.camera.R_renamed.dimen.histogram_graph_view_width);
        int i6 = com.oplus.camera.util.Util.i_renamed(com.oplus.camera.R_renamed.dimen.histogram_graph_view_height);
        if (i2 % 180 == 0) {
            aVar.f4923b = i_renamed + i3;
            aVar.d_renamed = i4;
            aVar.e_renamed = i2;
        } else {
            aVar.f4923b = ((i5 - i6) / 2) + i_renamed + i3;
            aVar.d_renamed = ((i6 - i5) / 2) + i4;
            aVar.e_renamed = (i2 + 180) % 360;
        }
    }

    public void a_renamed(com.oplus.camera.p_renamed.a_renamed aVar) {
        aVar.e_renamed = 90;
        aVar.f4922a = 12;
        aVar.f4924c = com.oplus.camera.util.Util.i_renamed(com.oplus.camera.R_renamed.dimen.movie_histogram_margin_bottom) + com.oplus.camera.util.Util.aG_renamed();
        aVar.d_renamed = com.oplus.camera.util.Util.i_renamed(com.oplus.camera.R_renamed.dimen.movie_histogram_margin_left);
        aVar.e_renamed = 90;
    }

    @Override // com.oplus.camera.screen.b_renamed.o_renamed
    public void b_renamed(android.app.Activity activity, int i_renamed) {
        if (i_renamed == 2 || i_renamed == 0) {
            com.oplus.camera.util.Util.a_renamed(activity, com.oplus.camera.R_renamed.id_renamed.switch_camera_button, com.oplus.camera.R_renamed.drawable.switch_camera_button_gray_bg);
            com.oplus.camera.util.Util.a_renamed(activity, com.oplus.camera.R_renamed.id_renamed.camera_from_other_app_close_btn, com.oplus.camera.R_renamed.drawable.switch_camera_button_gray_bg);
        } else {
            com.oplus.camera.util.Util.a_renamed(activity, com.oplus.camera.R_renamed.id_renamed.switch_camera_button, com.oplus.camera.R_renamed.drawable.switch_camera_button_bg);
            com.oplus.camera.util.Util.a_renamed(activity, com.oplus.camera.R_renamed.id_renamed.camera_from_other_app_close_btn, com.oplus.camera.R_renamed.drawable.switch_camera_button_bg);
        }
    }

    public java.lang.String toString() {
        return h_renamed();
    }

    public void e_renamed(android.app.Activity activity) {
        android.view.View viewFindViewById;
        if (activity == null || (viewFindViewById = activity.findViewById(com.oplus.camera.R_renamed.id_renamed.frame_layout)) == null) {
            return;
        }
        android.widget.RelativeLayout.LayoutParams layoutParamsA = a_renamed(com.oplus.camera.util.Util.I_renamed());
        if (layoutParamsA != null) {
            viewFindViewById.setLayoutParams(layoutParamsA);
        } else {
            com.oplus.camera.e_renamed.b_renamed("BaseScreenMode", "relayoutPreviewFrame, layoutParams is_renamed null");
        }
    }
}

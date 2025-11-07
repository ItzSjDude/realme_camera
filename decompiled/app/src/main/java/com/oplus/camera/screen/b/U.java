package com.oplus.camera.screen.b_renamed;

/* compiled from: RightScreenMode.java */
/* loaded from: classes2.dex */
public class n_renamed extends com.oplus.camera.screen.b_renamed.h_renamed {
    @Override // com.oplus.camera.screen.b_renamed.a_renamed
    public java.lang.String h_renamed() {
        return com.google.android.exoplayer2.text.ttml.TtmlNode.RIGHT;
    }

    @Override // com.oplus.camera.screen.b_renamed.o_renamed
    public int p_renamed() {
        return 1;
    }

    @Override // com.oplus.camera.screen.b_renamed.h_renamed, com.oplus.camera.screen.b_renamed.a_renamed
    public void a_renamed(com.oplus.camera.screen.ScreenRelativeLayout screenRelativeLayout) {
        super.a_renamed(screenRelativeLayout);
        ((android.widget.RelativeLayout.LayoutParams) screenRelativeLayout.getLayoutParams()).addRule(11);
    }

    @Override // com.oplus.camera.screen.b_renamed.h_renamed
    protected void f_renamed(android.app.Activity activity) throws android.content.res.Resources.NotFoundException {
        android.content.res.Resources resources = activity.getResources();
        int dimensionPixelOffset = resources.getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.fold_split_screen_control_panel_height);
        int dimensionPixelOffset2 = resources.getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.control_panel_margin_top);
        com.oplus.camera.screen.c_renamed cVar = new com.oplus.camera.screen.c_renamed(new int[]{12, 0}, null);
        cVar.f5365c = new int[]{-1, dimensionPixelOffset + dimensionPixelOffset2};
        cVar.f_renamed = new com.oplus.camera.screen.c_renamed.a_renamed() { // from class: com.oplus.camera.screen.b_renamed.-$$Lambda$n_renamed$dgTbmGO4ZTzg0v8BKYws21Ks-dc_renamed
            @Override // com.oplus.camera.screen.c_renamed.a_renamed
            public final void call(android.view.View view) {
                com.oplus.camera.screen.b_renamed.n_renamed.a_renamed(view);
            }
        };
        this.f5360a.put(java.lang.Integer.valueOf(com.oplus.camera.R_renamed.id_renamed.control_panel_layout), cVar);
        super.f_renamed(activity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a_renamed(android.view.View view) {
        ((com.oplus.camera.ui.inverse.InverseColorRelativeLayout) view).setBackgroundAlwaysTransparent(false);
    }

    @Override // com.oplus.camera.screen.b_renamed.h_renamed
    protected void i_renamed(final android.app.Activity activity) {
        com.oplus.camera.screen.c_renamed cVar = new com.oplus.camera.screen.c_renamed(new int[]{9, 0}, null);
        cVar.f5365c = new int[]{this.f5361b, this.f5362c};
        cVar.f_renamed = new com.oplus.camera.screen.c_renamed.a_renamed() { // from class: com.oplus.camera.screen.b_renamed.-$$Lambda$n_renamed$8GdaqbkcSHKdi7h2PO2SgwvancY
            @Override // com.oplus.camera.screen.c_renamed.a_renamed
            public final void call(android.view.View view) {
                com.oplus.camera.screen.b_renamed.n_renamed.a_renamed(activity, view);
            }
        };
        this.f5360a.put(java.lang.Integer.valueOf(com.oplus.camera.R_renamed.id_renamed.gallery_container), cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a_renamed(android.app.Activity activity, android.view.View view) {
        android.widget.RelativeLayout relativeLayout = (android.widget.RelativeLayout) activity.findViewById(com.oplus.camera.R_renamed.id_renamed.gallery_container);
        androidx.viewpager2.widget.ViewPager2 viewPager2 = (androidx.viewpager2.widget.ViewPager2) relativeLayout.findViewById(com.oplus.camera.R_renamed.id_renamed.gallery_pager);
        viewPager2.setLayoutAnimation(null);
        com.oplus.camera.ui.k_renamed kVar = (com.oplus.camera.ui.k_renamed) viewPager2.getAdapter();
        if (kVar == null || !kVar.a_renamed()) {
            return;
        }
        viewPager2.a_renamed(kVar.getItemCount() - 1, false);
        if (kVar.getItemCount() == 0) {
            ((com.oplus.camera.ui.inverse.InverseTextView) activity.findViewById(com.oplus.camera.R_renamed.id_renamed.gallery_preview_empty_view)).setVisibility(0);
            ((com.oplus.camera.ui.j_renamed) activity.findViewById(com.oplus.camera.R_renamed.id_renamed.gallery_menu_panel)).setVisibility(4);
        }
        relativeLayout.setVisibility(0);
    }

    @Override // com.oplus.camera.screen.b_renamed.a_renamed
    public com.oplus.camera.ui.preview.w_renamed a_renamed(android.content.Context context) {
        android.content.res.Resources resources = context.getResources();
        com.oplus.camera.ui.preview.w_renamed wVar = new com.oplus.camera.ui.preview.w_renamed(com.oplus.camera.util.Util.getScreenWidth() / 2, com.oplus.camera.util.Util.getScreenHeight());
        wVar.a_renamed(resources.getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.fold_right_screen_start_x));
        return wVar;
    }

    @Override // com.oplus.camera.screen.b_renamed.o_renamed
    public boolean a_renamed(com.oplus.camera.ui.CameraUIInterface cameraUIInterface, int i_renamed, int i2) {
        return i2 >= cameraUIInterface.am_renamed() && i2 <= cameraUIInterface.an_renamed() && i_renamed >= this.f5361b;
    }

    @Override // com.oplus.camera.screen.b_renamed.o_renamed
    public android.widget.RelativeLayout.LayoutParams a_renamed(android.util.Size size) throws android.content.res.Resources.NotFoundException {
        if (size == null) {
            return null;
        }
        android.graphics.Rect rectB = b_renamed(size.getHeight(), size.getWidth());
        android.widget.RelativeLayout.LayoutParams layoutParams = new android.widget.RelativeLayout.LayoutParams(rectB.width(), rectB.height());
        layoutParams.addRule(11);
        layoutParams.addRule(10);
        layoutParams.leftMargin = rectB.left;
        layoutParams.topMargin = rectB.top;
        return layoutParams;
    }

    @Override // com.oplus.camera.screen.b_renamed.o_renamed
    public android.graphics.Rect b_renamed(int i_renamed, int i2) throws android.content.res.Resources.NotFoundException {
        this.f5361b = com.oplus.camera.util.Util.getScreenWidth() / 2;
        this.f5362c = com.oplus.camera.util.Util.getScreenHeight();
        float f_renamed = i2 / i_renamed;
        int iRound = java.lang.Math.round(this.f5361b * f_renamed);
        int iA = (((this.f5362c - iRound) / 2) + a_renamed(f_renamed)) - com.oplus.camera.util.Util.l_renamed().getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.fold_split_screen_back_preview_topMargin_offset);
        android.graphics.Rect rect = new android.graphics.Rect(0, iA, this.f5361b, iRound + iA);
        int screenWidth = com.oplus.camera.util.Util.getScreenWidth() / 2;
        rect.left = screenWidth;
        rect.right += screenWidth;
        return rect;
    }
}

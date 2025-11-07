package com.oplus.camera.ui.menu.facebeauty;

/* compiled from: FaceBeautyCustomMenu.java */
/* loaded from: classes2.dex */
class f_renamed extends com.oplus.camera.ui.menu.facebeauty.d_renamed implements com.oplus.camera.ui.menu.facebeauty.a_renamed {
    private int D_renamed;
    private com.oplus.camera.ui.menu.facebeauty.c_renamed E_renamed;
    private android.view.View G_renamed;
    private com.oplus.camera.ui.OplusNumAISeekBar H_renamed;
    private com.oplus.camera.ui.OplusNumAISeekBar I_renamed;
    private androidx.recyclerview.widget.COUIRecyclerView K_renamed;
    private androidx.recyclerview.widget.LinearLayoutManager L_renamed;
    private int R_renamed;
    private int S_renamed;
    private int T_renamed;
    private int U_renamed;
    private int Z_renamed;
    private int aa_renamed;
    private int ac_renamed;
    private com.oplus.camera.ui.OplusNumSeekBar.a_renamed ae_renamed;
    private com.oplus.camera.ui.menu.facebeauty.f_renamed.a_renamed ag_renamed;
    private static final int[] z_renamed = {0, 0, 0, 0, -50, 0, 0, 0};
    private static final int[] A_renamed = {100, 100, 100, 100, 50, 100, 100, 100};
    private static final int[] B_renamed = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    private static final int[] C_renamed = {100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100};
    private com.oplus.camera.ui.menu.facebeauty.c_renamed F_renamed = null;
    private com.oplus.camera.ui.OplusNumAISeekBar J_renamed = null;
    private androidx.recyclerview.widget.COUIRecyclerView M_renamed = null;
    private java.util.ArrayList<com.oplus.camera.ui.menu.facebeauty.b_renamed> N_renamed = null;
    private java.util.ArrayList<com.oplus.camera.ui.menu.facebeauty.b_renamed> O_renamed = null;
    private java.util.ArrayList<com.oplus.camera.ui.menu.facebeauty.b_renamed> P_renamed = null;
    private android.widget.RelativeLayout.LayoutParams Q_renamed = null;
    private int V_renamed = 0;
    private boolean W_renamed = false;
    private int X_renamed = 0;
    private int Y_renamed = 0;
    private int ab_renamed = 0;
    private androidx.recyclerview.widget.LinearLayoutManager ad_renamed = null;
    private android.view.GestureDetector af_renamed = null;

    /* compiled from: FaceBeautyCustomMenu.java */
    interface a_renamed {
        void a_renamed(android.view.View view, int i_renamed);

        boolean a_renamed();

        boolean d_renamed();
    }

    private int b_renamed(int i_renamed, int i2) {
        return 1 == i_renamed ? 270 == i2 ? com.oplus.camera.R_renamed.layout.face_beauty_custom_vertical_270 : com.oplus.camera.R_renamed.layout.face_beauty_custom_vertical : 3 == i_renamed ? com.oplus.camera.R_renamed.layout.face_beauty_custom_split_screen : 4 == i_renamed ? com.oplus.camera.R_renamed.layout.face_beauty_custom_rack : com.oplus.camera.R_renamed.layout.face_beauty_custom;
    }

    public f_renamed(android.app.Activity activity, android.view.View.OnClickListener onClickListener, com.oplus.camera.ui.menu.facebeauty.f_renamed.a_renamed aVar, com.oplus.camera.ui.OplusNumSeekBar.a_renamed aVar2, com.oplus.camera.ui.menu.facebeauty.d_renamed.a_renamed aVar3, com.oplus.camera.ui.preview.a_renamed.f_renamed fVar, int i_renamed, int i2) {
        this.D_renamed = 0;
        this.E_renamed = null;
        this.G_renamed = null;
        this.H_renamed = null;
        this.I_renamed = null;
        this.K_renamed = null;
        this.L_renamed = null;
        this.R_renamed = 0;
        this.S_renamed = 0;
        this.T_renamed = 0;
        this.U_renamed = 0;
        this.Z_renamed = 0;
        this.aa_renamed = 0;
        this.ac_renamed = 0;
        this.ae_renamed = null;
        this.ag_renamed = null;
        android.content.res.Resources resources = activity.getApplicationContext().getResources();
        this.R_renamed = resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.face_beauty_item_space_start);
        this.Z_renamed = resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.makeup_item_space);
        this.aa_renamed = resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.makeup_item_width);
        this.S_renamed = resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.face_beauty_item_text_width);
        this.U_renamed = resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.face_beauty_custom_scroll_view_padding);
        this.ac_renamed = resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.face_beauty_makeup_recycler_view_padding);
        this.T_renamed = resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.face_beauty_item_touch_height);
        this.v_renamed = activity.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.face_beauty_menu_translate_y);
        this.o_renamed = aVar3;
        this.ag_renamed = aVar;
        this.ae_renamed = aVar2;
        this.w_renamed = i_renamed;
        this.y_renamed = activity;
        this.x_renamed = i2;
        this.D_renamed = a_renamed(activity);
        this.E_renamed = new com.oplus.camera.ui.menu.facebeauty.c_renamed(activity);
        this.E_renamed.a_renamed(i_renamed);
        this.E_renamed.a_renamed(E_renamed());
        this.E_renamed.a_renamed(aVar);
        this.E_renamed.a_renamed(onClickListener);
        this.G_renamed = activity.getLayoutInflater().inflate(b_renamed(i_renamed, i2), (android.view.ViewGroup) null);
        this.f6417a = (android.widget.LinearLayout) this.G_renamed.findViewById(com.oplus.camera.R_renamed.id_renamed.tab_container);
        this.I_renamed = (com.oplus.camera.ui.OplusNumAISeekBar) this.G_renamed.findViewById(com.oplus.camera.R_renamed.id_renamed.face_beauty_seekbar);
        a_renamed(this.I_renamed);
        this.H_renamed = this.I_renamed;
        this.K_renamed = (androidx.recyclerview.widget.COUIRecyclerView) this.G_renamed.findViewById(com.oplus.camera.R_renamed.id_renamed.face_beauty_custom_recycler);
        final boolean z2 = 1 == i_renamed;
        this.L_renamed = new androidx.recyclerview.widget.LinearLayoutManager(activity, z2 ? 1 : 0, false) { // from class: com.oplus.camera.ui.menu.facebeauty.f_renamed.1
            @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.i_renamed
            public boolean canScrollHorizontally() {
                return !z2;
            }

            @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.i_renamed
            public boolean canScrollVertically() {
                return z2;
            }
        };
        this.K_renamed.setLayoutManager(this.L_renamed);
        this.K_renamed.setAdapter(this.E_renamed);
        this.K_renamed.setVisibility(8);
        this.n_renamed = fVar;
    }

    private void a_renamed(com.oplus.camera.ui.OplusNumAISeekBar oplusNumAISeekBar) {
        com.oplus.camera.ui.inverse.e_renamed.INS.registerInverse(this.G_renamed.getContext(), oplusNumAISeekBar);
        oplusNumAISeekBar.setOnProgressChangedListener(this.ae_renamed);
        oplusNumAISeekBar.setFrontStyle(true);
        oplusNumAISeekBar.setmThumbTextShadowBlur((int) com.oplus.camera.util.Util.a_renamed(this.G_renamed.getContext(), com.oplus.camera.R_renamed.dimen.level_panel_text_shadow_radius, com.oplus.camera.util.Util.f7297a));
        oplusNumAISeekBar.setmThumbTextShadowColor(this.G_renamed.getContext().getResources().getColor(com.oplus.camera.R_renamed.color.color_black_with_20_percent_transparency));
    }

    public int a_renamed(android.app.Activity activity) {
        if (3 == this.w_renamed) {
            return activity.getResources().getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.fold_split_screen_face_beauty_tab_margin_bottom);
        }
        return com.oplus.camera.util.Util.O_renamed() - activity.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.face_beauty_tab_container_height);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void C_renamed() {
        android.view.View view;
        if (this.M_renamed == null && (view = this.G_renamed) != null) {
            this.J_renamed = (com.oplus.camera.ui.OplusNumAISeekBar) view.findViewById(com.oplus.camera.R_renamed.id_renamed.face_beauty_makeup_seekbar);
            a_renamed(this.J_renamed);
            this.F_renamed = new com.oplus.camera.ui.menu.facebeauty.c_renamed(this.G_renamed.getContext());
            this.F_renamed.a_renamed(x_renamed());
            this.F_renamed.a_renamed(this.ag_renamed);
            this.ad_renamed = new androidx.recyclerview.widget.LinearLayoutManager(this.G_renamed.getContext(), 0, 0 == true ? 1 : 0) { // from class: com.oplus.camera.ui.menu.facebeauty.f_renamed.2
                @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.i_renamed
                public boolean canScrollHorizontally() {
                    return true;
                }
            };
            this.M_renamed = (androidx.recyclerview.widget.COUIRecyclerView) this.G_renamed.findViewById(com.oplus.camera.R_renamed.id_renamed.face_beauty_custom_makeup_recycler);
            this.M_renamed.setLayoutManager(this.ad_renamed);
            this.M_renamed.setAdapter(this.F_renamed);
        }
        this.F_renamed.b_renamed(this.ab_renamed);
        this.F_renamed.notifyDataSetChanged();
        this.ad_renamed.scrollToPositionWithOffset(this.ab_renamed, D_renamed());
    }

    public void s_renamed() {
        com.oplus.camera.ui.menu.facebeauty.c_renamed cVar = this.E_renamed;
        if (cVar != null) {
            cVar.notifyDataSetChanged();
        }
        com.oplus.camera.ui.menu.facebeauty.c_renamed cVar2 = this.F_renamed;
        if (cVar2 != null) {
            cVar2.notifyDataSetChanged();
        }
    }

    private int D_renamed() {
        return ((com.oplus.camera.util.Util.getScreenWidth() - this.aa_renamed) / 2) - this.ac_renamed;
    }

    public void o_renamed(boolean z2) {
        com.oplus.camera.ui.menu.facebeauty.c_renamed cVar = this.E_renamed;
        if (cVar != null) {
            cVar.a_renamed(!z2);
        }
    }

    public void p_renamed(boolean z2) {
        a_renamed(z2, false);
    }

    public void a_renamed(boolean z2, boolean z3) {
        com.oplus.camera.ui.menu.facebeauty.c_renamed cVar = this.E_renamed;
        if (cVar != null) {
            cVar.a_renamed(z2, z3);
        }
    }

    public void a_renamed(boolean z2, boolean z3, boolean z4, int i_renamed, boolean z5) {
        com.oplus.camera.e_renamed.c_renamed("FaceBeautyCustomMenu", "initFaceBeautyMenu, supportMakeup: " + z2 + ", supportFilterEffect: " + z3 + ", supFaceBeauty: " + z4 + ", makeupIndex: " + i_renamed + ", supportShowCustomAll: " + z5);
        this.i_renamed = z2;
        this.j_renamed = z3;
        this.h_renamed = z4;
        this.ab_renamed = i_renamed;
        this.W_renamed = z5;
        if (this.i_renamed) {
            C_renamed();
        }
        c_renamed();
        this.E_renamed.a_renamed(E_renamed());
        this.E_renamed.a_renamed(this.ag_renamed);
    }

    /* JADX WARN: Removed duplicated region for block: B_renamed:15:0x0094  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void a_renamed(int r13, boolean r14, boolean r15) {
        /*
            Method dump skipped, instructions count: 287
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.ui.menu.facebeauty.f_renamed.a_renamed(int, boolean, boolean):void");
    }

    public boolean a_renamed(int i_renamed, androidx.recyclerview.widget.RecyclerView.n_renamed nVar) {
        int i2;
        int iFindLastVisibleItemPosition = this.L_renamed.findLastVisibleItemPosition();
        int iFindFirstVisibleItemPosition = this.L_renamed.findFirstVisibleItemPosition();
        android.view.View viewFindViewByPosition = this.L_renamed.findViewByPosition(iFindLastVisibleItemPosition);
        android.view.View viewFindViewByPosition2 = this.L_renamed.findViewByPosition(iFindFirstVisibleItemPosition);
        android.graphics.Rect rect = new android.graphics.Rect();
        int i3 = this.S_renamed + this.R_renamed;
        if (viewFindViewByPosition != null && (i2 = iFindLastVisibleItemPosition - i_renamed) <= 1 && viewFindViewByPosition.getVisibility() == 0 && viewFindViewByPosition.getLocalVisibleRect(rect) && (iFindLastVisibleItemPosition == i_renamed || rect.width() < viewFindViewByPosition.getWidth())) {
            int width = (viewFindViewByPosition.getWidth() - rect.width()) + ((1 - i2) * i3);
            if (nVar != null) {
                this.K_renamed.clearOnScrollListeners();
                this.K_renamed.addOnScrollListener(nVar);
            }
            this.K_renamed.smoothScrollBy(width * (1 == this.K_renamed.getLayoutDirection() ? -1 : 1), 0, new android.view.animation.PathInterpolator(0.3f, 0.0f, 0.1f, 1.0f), 500);
            return width != 0;
        }
        if (viewFindViewByPosition2 == null || i_renamed - iFindFirstVisibleItemPosition > 1 || viewFindViewByPosition2.getVisibility() != 0 || !viewFindViewByPosition2.getLocalVisibleRect(rect)) {
            return false;
        }
        if (iFindFirstVisibleItemPosition != i_renamed && rect.width() >= viewFindViewByPosition2.getWidth()) {
            return false;
        }
        if (nVar != null) {
            this.K_renamed.clearOnScrollListeners();
            this.K_renamed.addOnScrollListener(nVar);
        }
        int width2 = (viewFindViewByPosition2.getWidth() - rect.width()) + (((iFindFirstVisibleItemPosition - i_renamed) + 1) * i3);
        this.K_renamed.smoothScrollBy((-width2) * (1 == this.K_renamed.getLayoutDirection() ? -1 : 1), 0, new android.view.animation.PathInterpolator(0.3f, 0.0f, 0.1f, 1.0f), 500);
        return width2 != 0;
    }

    public boolean t_renamed() {
        androidx.recyclerview.widget.COUIRecyclerView cOUIRecyclerView = this.K_renamed;
        return cOUIRecyclerView == null || this.U_renamed > cOUIRecyclerView.getScrollX();
    }

    public void u_renamed() {
        com.oplus.camera.ui.OplusNumAISeekBar oplusNumAISeekBar = this.H_renamed;
        if (oplusNumAISeekBar != null) {
            oplusNumAISeekBar.setVisibility(8);
        }
    }

    public void v_renamed() {
        com.oplus.camera.ui.OplusNumAISeekBar oplusNumAISeekBar = this.H_renamed;
        if (oplusNumAISeekBar != null) {
            oplusNumAISeekBar.setAlpha(0.0f);
            this.H_renamed.setVisibility(0);
        }
    }

    public int w_renamed() {
        if (l_renamed()) {
            return this.F_renamed.a_renamed();
        }
        return this.E_renamed.a_renamed() - 2;
    }

    public android.view.ViewGroup.LayoutParams a_renamed(int i_renamed, int i2) {
        if (1 == i_renamed) {
            this.Q_renamed = new android.widget.RelativeLayout.LayoutParams(-1, -1);
        } else if (4 == i_renamed) {
            this.Q_renamed = new android.widget.RelativeLayout.LayoutParams(this.y_renamed.getResources().getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.rack_mode_face_beauty_custom_layout_width), -2);
            this.Q_renamed.addRule(12);
            this.Q_renamed.addRule(14);
            this.Q_renamed.setMargins(0, 0, 0, this.y_renamed.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.rack_mode_face_beauty_layout_margin_bottom));
            this.Q_renamed.setLayoutDirection(15);
        } else {
            this.Q_renamed = new android.widget.RelativeLayout.LayoutParams(-1, -2);
            this.Q_renamed.addRule(12);
            this.Q_renamed.setMargins(0, 0, 0, this.D_renamed);
        }
        return this.Q_renamed;
    }

    @Override // com.oplus.camera.ui.menu.facebeauty.a_renamed
    public void a_renamed() {
        this.e_renamed = 0;
        m_renamed(false);
        android.view.ViewGroup viewGroup = (android.view.ViewGroup) this.G_renamed.getParent();
        if (viewGroup != null) {
            viewGroup.removeView(this.G_renamed);
        }
    }

    public void a_renamed(int i_renamed, int[] iArr) {
        a_renamed(i_renamed, iArr, z_renamed, A_renamed);
    }

    public void b_renamed(int i_renamed, int[] iArr) {
        a_renamed(i_renamed, iArr, B_renamed, C_renamed);
    }

    private void a_renamed(int i_renamed, int[] iArr, int[] iArr2, int[] iArr3) {
        int iW = w_renamed();
        if (iW < 0 || iW >= iArr3.length) {
            return;
        }
        if (i_renamed == -100000) {
            i_renamed = iArr[iW];
        }
        this.H_renamed.b_renamed(iArr2[iW]).a_renamed(iArr3[iW]).d_renamed(iArr[iW]).c_renamed(i_renamed).postInvalidate();
    }

    private java.util.List<com.oplus.camera.ui.menu.facebeauty.b_renamed> E_renamed() {
        if (this.N_renamed == null) {
            this.N_renamed = new java.util.ArrayList<>();
            this.N_renamed.add(new com.oplus.camera.ui.menu.facebeauty.b_renamed(com.oplus.camera.R_renamed.string.camera_face_beauty_menu_reset, com.oplus.camera.R_renamed.drawable.face_beauty_menu_reset, 3));
            this.N_renamed.add(new com.oplus.camera.ui.menu.facebeauty.b_renamed(com.oplus.camera.R_renamed.string.camera_face_beauty_menu_level_none, com.oplus.camera.R_renamed.drawable.face_beauty_level_none_dark, 4));
            this.N_renamed.add(new com.oplus.camera.ui.menu.facebeauty.b_renamed(com.oplus.camera.R_renamed.string.camera_beauty_custom_exfoliating, com.oplus.camera.R_renamed.drawable.face_beauty_custom_exfoliating_dark, 0));
            this.N_renamed.add(new com.oplus.camera.ui.menu.facebeauty.b_renamed(com.oplus.camera.R_renamed.string.camera_beauty_custom_thin_face, com.oplus.camera.R_renamed.drawable.face_beauty_custom_thin_face_dark, 0));
            this.N_renamed.add(new com.oplus.camera.ui.menu.facebeauty.b_renamed(com.oplus.camera.R_renamed.string.camera_beauty_custom_big_eye, com.oplus.camera.R_renamed.drawable.face_beauty_custom_big_eye_dark, 0));
            this.N_renamed.add(new com.oplus.camera.ui.menu.facebeauty.b_renamed(com.oplus.camera.R_renamed.string.camera_beauty_custom_thin_nasal, com.oplus.camera.R_renamed.drawable.face_beauty_custom_thin_nasal_dark, 0));
            this.N_renamed.add(new com.oplus.camera.ui.menu.facebeauty.b_renamed(com.oplus.camera.R_renamed.string.camera_beauty_custom_chin, com.oplus.camera.R_renamed.drawable.face_beauty_custom_chin_dark, 0));
            this.N_renamed.add(new com.oplus.camera.ui.menu.facebeauty.b_renamed(com.oplus.camera.R_renamed.string.camera_beauty_custom_little_face, com.oplus.camera.R_renamed.drawable.face_beauty_custom_little_face_dark, 0));
            this.O_renamed = new java.util.ArrayList<>();
            this.O_renamed.addAll(this.N_renamed);
            this.O_renamed.add(new com.oplus.camera.ui.menu.facebeauty.b_renamed(com.oplus.camera.R_renamed.string.camera_beauty_custom_makeup, com.oplus.camera.R_renamed.drawable.face_beauty_custom_makeup_dark, 0));
            this.O_renamed.add(new com.oplus.camera.ui.menu.facebeauty.b_renamed(com.oplus.camera.R_renamed.string.camera_beauty_custom_3d, com.oplus.camera.R_renamed.drawable.face_beauty_custom_3d_dark, 0));
        }
        if (!this.W_renamed) {
            return this.N_renamed;
        }
        return this.O_renamed;
    }

    public java.util.List<com.oplus.camera.ui.menu.facebeauty.b_renamed> x_renamed() {
        if (this.P_renamed == null) {
            this.P_renamed = new java.util.ArrayList<>();
            this.P_renamed.add(new com.oplus.camera.ui.menu.facebeauty.b_renamed(com.oplus.camera.R_renamed.string.camera_beauty_makeup_none, com.oplus.camera.R_renamed.drawable.face_beauty_level_none_dark, 2));
            this.P_renamed.add(new com.oplus.camera.ui.menu.facebeauty.b_renamed(com.oplus.camera.R_renamed.string.camera_beauty_makeup_rosy_nude, com.oplus.camera.R_renamed.drawable.makeup_rosy_nude, 1, 1));
            this.P_renamed.add(new com.oplus.camera.ui.menu.facebeauty.b_renamed(com.oplus.camera.R_renamed.string.camera_beauty_makeup_orange_crush, com.oplus.camera.R_renamed.drawable.makeup_orange_crush, 1));
            if (com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_CUSTOM_MAKEUP_TYPE_SNOW)) {
                this.P_renamed.add(new com.oplus.camera.ui.menu.facebeauty.b_renamed(com.oplus.camera.R_renamed.string.camera_beauty_makeup_twilight_snow, com.oplus.camera.R_renamed.drawable.makeup_snow, 1, 2));
            }
            this.P_renamed.add(new com.oplus.camera.ui.menu.facebeauty.b_renamed(com.oplus.camera.R_renamed.string.camera_beauty_makeup_first_love, com.oplus.camera.R_renamed.drawable.makeup_first_love, 1));
            this.P_renamed.add(new com.oplus.camera.ui.menu.facebeauty.b_renamed(com.oplus.camera.R_renamed.string.camera_beauty_makeup_peach_pink, com.oplus.camera.R_renamed.drawable.makeup_peach_pink, 1));
            this.P_renamed.add(new com.oplus.camera.ui.menu.facebeauty.b_renamed(com.oplus.camera.R_renamed.string.camera_beauty_makeup_red_velvet, com.oplus.camera.R_renamed.drawable.makeup_red_velvet, 1));
            if (com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_CUSTOM_MAKEUP_TYPE_DREAM)) {
                this.P_renamed.add(new com.oplus.camera.ui.menu.facebeauty.b_renamed(com.oplus.camera.R_renamed.string.camera_beauty_makeup_dream, com.oplus.camera.R_renamed.drawable.makeup_dream, 1, 2));
            }
            this.P_renamed.add(new com.oplus.camera.ui.menu.facebeauty.b_renamed(com.oplus.camera.R_renamed.string.camera_beauty_makeup_sparkling_sea, com.oplus.camera.R_renamed.drawable.makeup_sparkling_sea, 1, 1));
            this.P_renamed.add(new com.oplus.camera.ui.menu.facebeauty.b_renamed(com.oplus.camera.R_renamed.string.camera_beauty_makeup_unique_eyes, com.oplus.camera.R_renamed.drawable.makeup_unique_eyes, 1, 1));
            this.P_renamed.add(new com.oplus.camera.ui.menu.facebeauty.b_renamed(com.oplus.camera.R_renamed.string.camera_beauty_makeup_midnight, com.oplus.camera.R_renamed.drawable.makeup_midnight, 1));
            this.P_renamed.add(new com.oplus.camera.ui.menu.facebeauty.b_renamed(com.oplus.camera.R_renamed.string.camera_beauty_makeup_violet_shimmer, com.oplus.camera.R_renamed.drawable.makeup_violet_shimmer, 1, 1));
            this.P_renamed.add(new com.oplus.camera.ui.menu.facebeauty.b_renamed(com.oplus.camera.R_renamed.string.camera_beauty_makeup_smokey, com.oplus.camera.R_renamed.drawable.makeup_smokey, 1, 1));
            this.P_renamed.add(new com.oplus.camera.ui.menu.facebeauty.b_renamed(com.oplus.camera.R_renamed.string.camera_beauty_makeup_groomed, com.oplus.camera.R_renamed.drawable.makeup_groomed, 1));
        }
        return this.P_renamed;
    }

    public android.view.View y_renamed() {
        return this.G_renamed;
    }

    public androidx.recyclerview.widget.RecyclerView z_renamed() {
        return this.K_renamed;
    }

    @Override // com.oplus.camera.ui.menu.facebeauty.d_renamed
    public android.view.View q_renamed() {
        return this.f6417a;
    }

    public com.oplus.camera.ui.OplusNumAISeekBar A_renamed() {
        return this.H_renamed;
    }

    @Override // com.oplus.camera.ui.menu.facebeauty.d_renamed
    protected void e_renamed(boolean z2) {
        int i_renamed = this.e_renamed;
        this.e_renamed = 1;
        this.o_renamed.b_renamed(l_renamed());
        this.H_renamed = this.I_renamed;
        this.H_renamed.setThumbOnDragging(false);
        if (b_renamed(i_renamed)) {
            i_renamed(z2);
        }
        if (c_renamed(i_renamed)) {
            l_renamed(z2);
        }
        if (this.V_renamed >= 0) {
            this.q_renamed = a_renamed(this.I_renamed, z2);
            this.p_renamed = a_renamed(this.K_renamed, z2);
            a_renamed(this.o_renamed.a_renamed(this.V_renamed, false), this.o_renamed.a_renamed(false));
        } else {
            this.p_renamed = a_renamed(this.K_renamed, z2);
            a_renamed(8, this.I_renamed);
        }
    }

    @Override // com.oplus.camera.ui.menu.facebeauty.d_renamed
    protected void f_renamed(boolean z2) {
        this.p_renamed = b_renamed(this.K_renamed, z2);
        if (b_renamed(this.I_renamed)) {
            this.q_renamed = b_renamed(this.I_renamed, z2);
        } else {
            a_renamed(8, this.I_renamed);
        }
    }

    @Override // com.oplus.camera.ui.menu.facebeauty.d_renamed
    protected void g_renamed(boolean z2) {
        this.p_renamed = c_renamed(this.K_renamed, z2);
        if (b_renamed(this.I_renamed)) {
            this.q_renamed = c_renamed(this.I_renamed, z2);
        } else {
            a_renamed(8, this.I_renamed);
        }
    }

    @Override // com.oplus.camera.ui.menu.facebeauty.d_renamed
    protected void h_renamed(boolean z2) {
        this.M_renamed.setTranslationY(0.0f);
        this.J_renamed.setTranslationY(0.0f);
        this.J_renamed.setEnabled(true);
        int i_renamed = this.e_renamed;
        this.e_renamed = 2;
        this.o_renamed.b_renamed(l_renamed());
        this.F_renamed.b_renamed(this.ab_renamed);
        this.F_renamed.notifyDataSetChanged();
        this.H_renamed = this.J_renamed;
        this.H_renamed.setThumbOnDragging(false);
        if (a_renamed(i_renamed)) {
            f_renamed(z2);
        }
        if (c_renamed(i_renamed)) {
            l_renamed(z2);
        }
        if (this.ab_renamed > 0) {
            this.s_renamed = a_renamed(this.J_renamed, z2);
            this.r_renamed = a_renamed(this.M_renamed, z2);
            b_renamed(this.o_renamed.a_renamed(this.ab_renamed, true), this.o_renamed.a_renamed(true));
        } else {
            this.r_renamed = a_renamed(this.M_renamed, z2);
            a_renamed(8, this.J_renamed);
        }
    }

    @Override // com.oplus.camera.ui.menu.facebeauty.d_renamed
    protected void i_renamed(boolean z2) {
        androidx.recyclerview.widget.COUIRecyclerView cOUIRecyclerView = this.M_renamed;
        if (cOUIRecyclerView != null) {
            this.r_renamed = b_renamed(cOUIRecyclerView, z2);
        }
        if (b_renamed(this.J_renamed)) {
            this.s_renamed = b_renamed(this.J_renamed, z2);
        } else {
            a_renamed(8, this.J_renamed);
        }
    }

    @Override // com.oplus.camera.ui.menu.facebeauty.d_renamed
    protected void j_renamed(boolean z2) {
        androidx.recyclerview.widget.COUIRecyclerView cOUIRecyclerView = this.M_renamed;
        if (cOUIRecyclerView != null) {
            this.r_renamed = c_renamed(cOUIRecyclerView, z2);
        }
        if (b_renamed(this.J_renamed)) {
            this.s_renamed = c_renamed(this.J_renamed, z2);
        } else {
            a_renamed(8, this.J_renamed);
        }
    }

    private void a_renamed(int i_renamed, android.view.View... viewArr) {
        for (android.view.View view : viewArr) {
            view.setVisibility(i_renamed);
            view.setAlpha(1.0f);
        }
    }

    private boolean b_renamed(android.view.View view) {
        return view != null && view.getVisibility() == 0 && view.getAlpha() > 0.0f;
    }

    public void B_renamed() {
        androidx.recyclerview.widget.COUIRecyclerView cOUIRecyclerView = this.K_renamed;
        if (cOUIRecyclerView != null) {
            cOUIRecyclerView.setVisibility(8);
        }
        com.oplus.camera.ui.OplusNumAISeekBar oplusNumAISeekBar = this.I_renamed;
        if (oplusNumAISeekBar != null) {
            oplusNumAISeekBar.setVisibility(8);
        }
        com.oplus.camera.ui.OplusNumAISeekBar oplusNumAISeekBar2 = this.J_renamed;
        if (oplusNumAISeekBar2 != null) {
            oplusNumAISeekBar2.setVisibility(8);
        }
        androidx.recyclerview.widget.COUIRecyclerView cOUIRecyclerView2 = this.M_renamed;
        if (cOUIRecyclerView2 != null) {
            cOUIRecyclerView2.setVisibility(8);
        }
    }
}

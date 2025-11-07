package com.oplus.camera.filmvideomode;

/* compiled from: FilmParamsContainer.java */
/* loaded from: classes2.dex */
public class k_renamed extends android.widget.RelativeLayout implements com.oplus.camera.filmvideomode.l_renamed.a_renamed, com.oplus.camera.professional.p_renamed.b_renamed, com.oplus.camera.professional.q_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private static final java.lang.String f4498a = "k_renamed";

    /* renamed from: b_renamed, reason: collision with root package name */
    private android.content.SharedPreferences f4499b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private com.oplus.camera.e_renamed.h_renamed f4500c;
    private com.oplus.camera.filmvideomode.i_renamed d_renamed;
    private com.oplus.camera.filmvideomode.h_renamed e_renamed;
    private com.oplus.camera.filmvideomode.l_renamed f_renamed;
    private boolean g_renamed;
    private com.oplus.camera.capmode.a_renamed h_renamed;
    private com.oplus.camera.filmvideomode.k_renamed.b_renamed i_renamed;
    private android.app.Activity j_renamed;
    private com.oplus.camera.filmvideomode.k_renamed.c_renamed k_renamed;
    private com.oplus.camera.filmvideomode.k_renamed.a_renamed l_renamed;
    private boolean m_renamed;

    /* compiled from: FilmParamsContainer.java */
    public interface a_renamed {
        void e_renamed(boolean z_renamed);
    }

    /* compiled from: FilmParamsContainer.java */
    public interface b_renamed {
        void a_renamed(int i_renamed, java.lang.String str, boolean z_renamed);
    }

    /* compiled from: FilmParamsContainer.java */
    public interface c_renamed {
        void a_renamed(int i_renamed);
    }

    /* compiled from: FilmParamsContainer.java */
    public interface d_renamed {
        void a_renamed(android.view.View view, android.view.View view2, int i_renamed);

        void a_renamed(android.view.View view, android.view.View view2, int i_renamed, long j_renamed);

        boolean a_renamed(android.view.View view);
    }

    public k_renamed(android.app.Activity activity, com.oplus.camera.capmode.a_renamed aVar, com.oplus.camera.filmvideomode.k_renamed.b_renamed bVar, com.oplus.camera.e_renamed.h_renamed hVar) {
        super(activity);
        this.f4499b = null;
        this.f4500c = null;
        this.d_renamed = null;
        this.e_renamed = null;
        this.f_renamed = null;
        this.g_renamed = false;
        this.h_renamed = null;
        this.i_renamed = null;
        this.j_renamed = null;
        this.k_renamed = null;
        this.l_renamed = null;
        this.m_renamed = false;
        this.j_renamed = activity;
        this.h_renamed = aVar;
        this.f4500c = hVar;
        this.f4499b = aVar.t_renamed();
        this.i_renamed = bVar;
        com.oplus.camera.professional.LevelPanel.c_renamed();
        k_renamed();
    }

    private void k_renamed() {
        android.widget.RelativeLayout.LayoutParams layoutParams;
        this.f_renamed = new com.oplus.camera.filmvideomode.l_renamed(getContext(), this.h_renamed);
        this.f_renamed.a_renamed(this.f4500c, new android.os.Handler(android.os.Looper.getMainLooper()));
        this.f_renamed.setMotionListener(this);
        this.f_renamed.setValueListener(this);
        this.f_renamed.setId(com.oplus.camera.R_renamed.id_renamed.movie_slide_bar_id);
        android.widget.RelativeLayout.LayoutParams layoutParams2 = new android.widget.RelativeLayout.LayoutParams(-1, getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.movie_mode_slide_bar_click_height));
        layoutParams2.bottomMargin = getResources().getDimensionPixelSize(com.oplus.camera.util.Util.u_renamed() ? com.oplus.camera.R_renamed.dimen.movie_mode_params_item_height_rack : com.oplus.camera.R_renamed.dimen.movie_mode_params_item_height);
        layoutParams2.addRule(12);
        this.d_renamed = new com.oplus.camera.filmvideomode.i_renamed(getContext());
        this.d_renamed.setClipChildren(false);
        this.d_renamed.setClipToPadding(false);
        this.e_renamed = new com.oplus.camera.filmvideomode.h_renamed((android.app.Activity) getContext(), this.d_renamed, getItemData());
        this.d_renamed.setAdapter(this.e_renamed);
        this.e_renamed.a_renamed((com.oplus.camera.professional.q_renamed) this);
        androidx.recyclerview.widget.LinearLayoutManager linearLayoutManager = new androidx.recyclerview.widget.LinearLayoutManager(getContext(), 0, false);
        this.d_renamed.setLayoutManager(linearLayoutManager);
        this.d_renamed.setHasFixedSize(true);
        linearLayoutManager.setStackFromEnd(true);
        if (com.oplus.camera.util.Util.u_renamed()) {
            layoutParams = new android.widget.RelativeLayout.LayoutParams(-2, getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.movie_mode_params_item_height_rack));
            layoutParams.addRule(12);
            layoutParams.addRule(14);
            layoutParams.setMarginStart(0);
        } else {
            android.widget.RelativeLayout.LayoutParams layoutParams3 = new android.widget.RelativeLayout.LayoutParams(-1, getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.movie_mode_params_item_height));
            layoutParams3.addRule(12);
            layoutParams3.addRule(15);
            layoutParams3.setMarginStart(getResources().getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.movie_mode_params_mode_bar_margin_start));
            layoutParams = layoutParams3;
        }
        addView(this.d_renamed, layoutParams);
        this.d_renamed.setHorizontalFadingEdgeEnabled(true);
        addView(this.f_renamed, layoutParams2);
    }

    public void setFilmParamsStateChangeListener(com.oplus.camera.filmvideomode.k_renamed.a_renamed aVar) {
        this.l_renamed = aVar;
        this.f_renamed.setParamsStateListener(aVar);
    }

    public void setParamsBarEnable(final boolean z_renamed) {
        if (this.d_renamed != null) {
            if (android.os.Looper.myLooper() == android.os.Looper.getMainLooper()) {
                this.d_renamed.setEnabled(z_renamed);
            } else {
                this.d_renamed.post(new java.lang.Runnable() { // from class: com.oplus.camera.filmvideomode.k_renamed.1
                    @Override // java.lang.Runnable
                    public void run() {
                        com.oplus.camera.filmvideomode.k_renamed.this.d_renamed.setEnabled(z_renamed);
                    }
                });
            }
        }
    }

    public void setAFEnable(boolean z_renamed) {
        this.m_renamed = z_renamed;
    }

    public void a_renamed(final int i_renamed, final boolean z_renamed) {
        this.m_renamed = z_renamed;
        android.app.Activity activity = this.j_renamed;
        if (activity == null) {
            return;
        }
        activity.runOnUiThread(new java.lang.Runnable() { // from class: com.oplus.camera.filmvideomode.k_renamed.2
            @Override // java.lang.Runnable
            public void run() {
                com.oplus.camera.filmvideomode.j_renamed jVarA = com.oplus.camera.filmvideomode.k_renamed.this.e_renamed.a_renamed(i_renamed);
                if (jVarA != null) {
                    jVarA.c_renamed(z_renamed);
                }
                com.oplus.camera.filmvideomode.k_renamed.this.c_renamed(i_renamed);
                if (z_renamed || com.oplus.camera.filmvideomode.k_renamed.this.f_renamed.getVisibilityPanelIndex() != i_renamed) {
                    return;
                }
                com.oplus.camera.filmvideomode.k_renamed.this.f_renamed.a_renamed(i_renamed, true);
                com.oplus.camera.filmvideomode.k_renamed.this.d_renamed();
                com.oplus.camera.filmvideomode.k_renamed.this.a_renamed(false);
                if (com.oplus.camera.filmvideomode.k_renamed.this.l_renamed != null) {
                    com.oplus.camera.filmvideomode.k_renamed.this.l_renamed.e_renamed(false);
                }
            }
        });
    }

    public void setSlideSelected(int i_renamed) {
        this.f_renamed.a_renamed(i_renamed, true);
    }

    public void a_renamed(boolean z_renamed) {
        com.oplus.camera.filmvideomode.l_renamed lVar = this.f_renamed;
        if (lVar == null || 8 == lVar.getVisibility()) {
            return;
        }
        com.oplus.camera.filmvideomode.k_renamed.a_renamed aVar = this.l_renamed;
        if (aVar != null) {
            aVar.e_renamed(false);
        }
        com.oplus.camera.professional.u_renamed.a_renamed aVar2 = new com.oplus.camera.professional.u_renamed.a_renamed();
        aVar2.f5239a = false;
        aVar2.f5241c = 250;
        aVar2.g_renamed = 400;
        aVar2.d_renamed = 0.0f;
        aVar2.e_renamed = getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.main_mode_bar_item_animation_offset);
        this.f_renamed.setAllPopupInvisibility(aVar2);
    }

    public boolean a_renamed() {
        return this.g_renamed;
    }

    public void b_renamed(boolean z_renamed) {
        a_renamed(z_renamed);
        com.oplus.camera.filmvideomode.i_renamed iVar = this.d_renamed;
        if (iVar != null) {
            com.oplus.camera.filmvideomode.b_renamed.b_renamed(this, iVar);
        }
    }

    public void b_renamed() {
        setVisibility(0);
        com.oplus.camera.filmvideomode.i_renamed iVar = this.d_renamed;
        if (iVar != null) {
            com.oplus.camera.filmvideomode.b_renamed.a_renamed(this, iVar);
        }
    }

    public boolean c_renamed() {
        return getVisibility() == 0;
    }

    public void setOnItemClickListener(com.oplus.camera.filmvideomode.k_renamed.d_renamed dVar) {
        com.oplus.camera.filmvideomode.i_renamed iVar = this.d_renamed;
        if (iVar != null) {
            iVar.setOnItemClickListener(dVar);
        }
    }

    public void d_renamed() {
        com.oplus.camera.filmvideomode.h_renamed hVar = this.e_renamed;
        if (hVar != null) {
            hVar.a_renamed();
        }
    }

    public void e_renamed() {
        com.oplus.camera.filmvideomode.h_renamed hVar = this.e_renamed;
        if (hVar != null) {
            hVar.notifyDataSetChanged();
        }
    }

    public void a_renamed(android.view.View view, android.view.View view2, int i_renamed, long j_renamed) {
        if (view2 == null || !view2.isEnabled()) {
            return;
        }
        this.f_renamed.a_renamed((int) j_renamed, true);
    }

    public int getModeBarCount() {
        com.oplus.camera.filmvideomode.h_renamed hVar = this.e_renamed;
        if (hVar != null) {
            return hVar.getItemCount();
        }
        return 0;
    }

    public void a_renamed(java.lang.Integer num) {
        int iA;
        com.oplus.camera.filmvideomode.j_renamed jVarA = this.e_renamed.a_renamed(1);
        java.util.ArrayList<java.lang.String> arrayListB = this.f_renamed.b_renamed(1);
        java.util.ArrayList<java.lang.String> arrayListC = this.f_renamed.c_renamed(1);
        if (num == null || jVarA == null || arrayListB == null || arrayListC == null || !this.f_renamed.e_renamed(1) || (iA = com.oplus.camera.professional.x_renamed.a_renamed(num.intValue(), arrayListB)) < 0 || iA >= arrayListB.size() || arrayListC.size() <= iA) {
            return;
        }
        java.lang.String str = arrayListC.get(iA);
        com.oplus.camera.professional.LevelPanel.a_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_FILM_MODE_ISO, str);
        this.f_renamed.scrollTo(1, iA);
        jVarA.a_renamed(str);
        this.d_renamed.a_renamed(1, str);
    }

    public void a_renamed(java.lang.Long l_renamed) {
        int iA;
        com.oplus.camera.filmvideomode.j_renamed jVarA = this.e_renamed.a_renamed(2);
        java.util.ArrayList<java.lang.String> arrayListB = this.f_renamed.b_renamed(2);
        java.util.ArrayList<java.lang.String> arrayListC = this.f_renamed.c_renamed(2);
        if (l_renamed == null || jVarA == null || arrayListB == null || arrayListC == null || !this.f_renamed.e_renamed(2) || (iA = com.oplus.camera.professional.x_renamed.a_renamed(l_renamed.longValue(), arrayListB)) < 0 || iA >= arrayListB.size() || arrayListC.size() <= iA) {
            return;
        }
        java.lang.String str = arrayListC.get(iA);
        com.oplus.camera.professional.LevelPanel.a_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_FILM_MODE_SHUTTER, str);
        this.f_renamed.scrollTo(2, iA);
        jVarA.a_renamed(str);
        this.d_renamed.a_renamed(2, str);
    }

    public void b_renamed(java.lang.Integer num) {
        int iA;
        com.oplus.camera.filmvideomode.j_renamed jVarA = this.e_renamed.a_renamed(5);
        java.util.ArrayList<java.lang.String> arrayListB = this.f_renamed.b_renamed(5);
        java.util.ArrayList<java.lang.String> arrayListC = this.f_renamed.c_renamed(5);
        if (num == null || jVarA == null || arrayListB == null || arrayListC == null || !this.f_renamed.e_renamed(5) || (iA = com.oplus.camera.professional.x_renamed.a_renamed(num.intValue(), arrayListB)) < 0 || iA >= arrayListB.size() || arrayListC.size() <= iA) {
            return;
        }
        java.lang.String str = arrayListC.get(iA);
        com.oplus.camera.professional.LevelPanel.a_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_FILM_MODE_WHITE_BALANCE, str);
        this.f_renamed.scrollTo(5, iA);
        jVarA.a_renamed(str);
        this.d_renamed.a_renamed(5, str);
    }

    public void a_renamed(java.lang.Float f_renamed) {
        int iA;
        com.oplus.camera.filmvideomode.j_renamed jVarA = this.e_renamed.a_renamed(4);
        java.util.ArrayList<java.lang.String> arrayListB = this.f_renamed.b_renamed(4);
        java.util.ArrayList<java.lang.String> arrayListC = this.f_renamed.c_renamed(4);
        if (f_renamed == null || jVarA == null || arrayListB == null || arrayListC == null || !this.f_renamed.e_renamed(4) || (iA = com.oplus.camera.professional.x_renamed.a_renamed(f_renamed.floatValue(), arrayListB)) < 0 || iA >= arrayListB.size() || arrayListC == null || arrayListC.size() <= iA) {
            return;
        }
        java.lang.String str = arrayListC.get(iA);
        com.oplus.camera.professional.LevelPanel.a_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_FILM_MODE_FOCUS, str);
        this.f_renamed.scrollTo(4, iA);
        jVarA.a_renamed(str);
        this.d_renamed.a_renamed(4, str);
    }

    public void a_renamed(com.oplus.camera.e_renamed.h_renamed hVar) {
        this.f_renamed.a_renamed(hVar);
        f_renamed();
    }

    public void f_renamed() {
        this.f_renamed.d_renamed();
    }

    private java.util.List<com.oplus.camera.filmvideomode.j_renamed> getItemData() {
        if (this.h_renamed == null) {
            return new java.util.ArrayList();
        }
        java.util.ArrayList arrayList = new java.util.ArrayList();
        for (java.util.Map.Entry<java.lang.Integer, com.oplus.camera.filmvideomode.c_renamed> entry : this.f_renamed.getPanelMap().entrySet()) {
            int iIntValue = entry.getKey().intValue();
            com.oplus.camera.filmvideomode.c_renamed value = entry.getValue();
            arrayList.add(new com.oplus.camera.filmvideomode.j_renamed().c_renamed(iIntValue).a_renamed(value.getSubModeBarData().f_renamed()).a_renamed(value.a_renamed(this.f4499b)));
        }
        if (!com.oplus.camera.util.Util.u_renamed()) {
            java.util.Collections.reverse(arrayList);
        }
        arrayList.add(com.oplus.camera.util.Util.u_renamed() ? 0 : arrayList.size(), new com.oplus.camera.filmvideomode.j_renamed().a_renamed(com.oplus.camera.R_renamed.drawable.professional_mode_ic_reset).a_renamed(getResources().getString(com.oplus.camera.R_renamed.string.camera_face_beauty_menu_reset)).c_renamed(0).b_renamed(com.oplus.camera.R_renamed.raw.pro_reset_animation));
        return arrayList;
    }

    public java.lang.String a_renamed(int i_renamed, java.lang.String str, java.lang.String str2) {
        if (this.f_renamed == null) {
            return "";
        }
        if ("auto".equals(str) && !"0".equals(str2)) {
            return str2;
        }
        java.lang.String strF = this.f_renamed.f_renamed(i_renamed);
        return android.text.TextUtils.isEmpty(strF) ? str2 : strF;
    }

    public java.lang.String b_renamed(int i_renamed, java.lang.String str, java.lang.String str2) {
        if (this.f_renamed == null) {
            return "";
        }
        if ("auto".equals(str) && !"0".equals(str2)) {
            return str2;
        }
        java.lang.String strG = this.f_renamed.g_renamed(i_renamed);
        return android.text.TextUtils.isEmpty(strG) ? str2 : strG.replace("+", "");
    }

    @Override // com.oplus.camera.filmvideomode.l_renamed.a_renamed
    public void a_renamed(int i_renamed, int i2, boolean z_renamed) {
        this.d_renamed.a_renamed(i_renamed, this.f_renamed.f_renamed(i_renamed), z_renamed);
        com.oplus.camera.filmvideomode.k_renamed.b_renamed bVar = this.i_renamed;
        if (bVar == null || z_renamed) {
            return;
        }
        bVar.a_renamed(i_renamed, this.f_renamed.a_renamed(i_renamed, i2), z_renamed);
    }

    @Override // com.oplus.camera.filmvideomode.l_renamed.a_renamed
    public void b_renamed(int i_renamed, boolean z_renamed) {
        com.oplus.camera.filmvideomode.j_renamed jVarA = this.e_renamed.a_renamed(i_renamed);
        if (jVarA != null) {
            jVarA.a_renamed(z_renamed);
        }
        com.oplus.camera.filmvideomode.k_renamed.b_renamed bVar = this.i_renamed;
        if (bVar != null) {
            bVar.a_renamed(i_renamed, this.f_renamed.a_renamed(i_renamed), z_renamed);
        }
    }

    @Override // com.oplus.camera.professional.p_renamed.b_renamed
    public void a_renamed(int i_renamed, java.lang.String str, boolean z_renamed) {
        com.oplus.camera.filmvideomode.k_renamed.c_renamed cVar = this.k_renamed;
        if (cVar != null) {
            cVar.a_renamed(i_renamed);
        }
    }

    public void c_renamed(int i_renamed, boolean z_renamed) {
        this.f_renamed.a_renamed(z_renamed, i_renamed);
    }

    public void g_renamed() {
        this.f_renamed.setPanelsBarAuto(4);
        this.f_renamed.c_renamed();
        l_renamed();
    }

    private synchronized void l_renamed() {
        java.util.ArrayList<java.lang.String> arrayListC = this.f_renamed.c_renamed(3);
        int iIndexOf = this.f_renamed.b_renamed(3).indexOf(this.f_renamed.h_renamed(3));
        this.f_renamed.scrollTo(3, iIndexOf);
        this.f_renamed.b_renamed(3, iIndexOf);
        if (arrayListC != null && arrayListC.size() > iIndexOf) {
            this.d_renamed.a_renamed(3, arrayListC.get(iIndexOf));
        }
    }

    @Override // com.oplus.camera.professional.q_renamed
    public boolean a_renamed(int i_renamed) {
        return this.f_renamed.e_renamed(i_renamed);
    }

    @Override // com.oplus.camera.professional.q_renamed
    public boolean b_renamed(int i_renamed) {
        if (i_renamed == 0) {
            return (this.f_renamed.e_renamed(1) && this.f_renamed.e_renamed(2) && this.f_renamed.e_renamed(3) && this.f_renamed.e_renamed(4) && this.f_renamed.e_renamed(5)) ? false : true;
        }
        if (3 == i_renamed) {
            return this.f_renamed.e_renamed(1) || this.f_renamed.e_renamed(2);
        }
        if (4 == i_renamed) {
            return this.m_renamed;
        }
        return true;
    }

    public void c_renamed(int i_renamed) {
        com.oplus.camera.filmvideomode.j_renamed jVarA = this.e_renamed.a_renamed(i_renamed);
        if (jVarA != null) {
            this.d_renamed.a_renamed(i_renamed, b_renamed(i_renamed) && jVarA.f_renamed(), com.oplus.camera.professional.x_renamed.a_renamed(i_renamed) && a_renamed(i_renamed));
        }
    }

    @Override // android.view.View
    public boolean isSelected() {
        return this.d_renamed.isSelected();
    }

    public void a_renamed(android.graphics.Rect rect) {
        if (rect == null || getVisibility() != 0) {
            return;
        }
        if (com.oplus.camera.util.Util.u_renamed()) {
            this.d_renamed.getGlobalVisibleRect(rect);
            return;
        }
        int top = this.d_renamed.getTop() + getTop();
        if (this.f_renamed.a_renamed()) {
            top -= this.f_renamed.getTouchAreaRect().height();
        }
        rect.set(getLeft(), top, com.oplus.camera.util.Util.getScreenWidth(), com.oplus.camera.util.Util.U_renamed());
    }

    public void setStatisticDataWriter(com.oplus.camera.filmvideomode.k_renamed.c_renamed cVar) {
        this.k_renamed = cVar;
    }

    public com.oplus.camera.filmvideomode.k_renamed.c_renamed getStatisticDataWriter() {
        return this.k_renamed;
    }

    public void h_renamed() {
        com.oplus.camera.filmvideomode.l_renamed lVar = this.f_renamed;
        if (lVar != null) {
            lVar.e_renamed();
        }
    }

    public void i_renamed() {
        com.oplus.camera.filmvideomode.l_renamed lVar = this.f_renamed;
        if (lVar != null) {
            lVar.f_renamed();
        }
    }

    public boolean j_renamed() {
        com.oplus.camera.filmvideomode.l_renamed lVar = this.f_renamed;
        if (lVar != null) {
            return lVar.a_renamed();
        }
        return false;
    }
}

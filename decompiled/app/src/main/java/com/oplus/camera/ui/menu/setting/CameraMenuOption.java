package com.oplus.camera.ui.menu.setting;

/* loaded from: classes2.dex */
public class CameraMenuOption implements com.oplus.camera.ui.menu.BasicOptionItemList.OptionItemListListener, com.oplus.camera.ui.menu.f_renamed {
    private int A_renamed;
    private java.util.ArrayList<com.oplus.camera.ui.menu.e_renamed> C_renamed;
    private int D_renamed;

    /* renamed from: a_renamed, reason: collision with root package name */
    public com.oplus.camera.ComboPreferences f6559a;
    protected int j_renamed;
    protected android.content.Context k_renamed;
    protected com.oplus.camera.ui.menu.setting.i_renamed l_renamed;
    protected com.oplus.camera.ui.CameraUIListener n_renamed;
    protected com.oplus.camera.ui.menu.b_renamed p_renamed;
    private int z_renamed;
    private final android.view.animation.PathInterpolator r_renamed = new android.view.animation.PathInterpolator(0.33f, 0.0f, 0.67f, 1.0f);
    private final android.view.animation.PathInterpolator s_renamed = new android.view.animation.PathInterpolator(0.3f, 0.0f, 0.1f, 1.0f);
    private final android.view.animation.PathInterpolator t_renamed = new android.view.animation.PathInterpolator(0.3f, 0.0f, 0.1f, 1.0f);

    /* renamed from: b_renamed, reason: collision with root package name */
    public com.oplus.camera.ui.menu.BasicOptionItemList f6560b = null;

    /* renamed from: c_renamed, reason: collision with root package name */
    public android.view.ViewGroup f6561c = null;
    public boolean d_renamed = false;
    protected boolean e_renamed = false;
    protected boolean f_renamed = false;
    protected boolean g_renamed = true;
    protected boolean h_renamed = false;
    protected boolean i_renamed = false;
    private boolean u_renamed = false;
    protected com.oplus.camera.ui.menu.setting.CameraMenuOption.OnItemClickListener m_renamed = null;
    protected int o_renamed = 0;
    protected boolean q_renamed = true;
    private boolean v_renamed = false;
    private com.oplus.camera.ui.menu.setting.CameraMenuOption.LayoutTranslationAnimation w_renamed = null;
    private int x_renamed = 0;
    private int y_renamed = 0;
    private java.lang.String B_renamed = null;
    private android.view.animation.AnimationSet E_renamed = null;
    private android.view.animation.AnimationSet F_renamed = null;
    private float G_renamed = 0.5f;
    private com.a_renamed.a_renamed.f_renamed H_renamed = null;
    private com.a_renamed.a_renamed.f_renamed I_renamed = null;
    private boolean J_renamed = false;
    private boolean K_renamed = false;

    public interface OnItemClickListener {
        void a_renamed(com.oplus.camera.ui.menu.setting.CameraMenuOption cameraMenuOption);
    }

    public int B_renamed() {
        return 0;
    }

    public int C_renamed() {
        return 0;
    }

    public android.view.View J_renamed() {
        return null;
    }

    public boolean L_renamed() {
        return false;
    }

    public void M_renamed() {
    }

    public void a_renamed(android.graphics.drawable.Drawable drawable, boolean z_renamed) {
    }

    public void a_renamed(android.view.View view) {
    }

    public void a_renamed(java.lang.String str, com.oplus.camera.ui.menu.e_renamed eVar) {
    }

    protected void a_renamed(java.lang.String str, java.lang.String str2, int i_renamed) {
    }

    public void a_renamed(java.lang.String str, java.lang.String str2, int i_renamed, int i2, int i3) {
    }

    public void a_renamed(java.lang.String str, java.lang.String str2, java.lang.String str3, int i_renamed, int i2) {
    }

    public void a_renamed(boolean z_renamed, int i_renamed, int i2) {
    }

    public void a_renamed(boolean z_renamed, boolean z2, int i_renamed) {
    }

    public void a_renamed(boolean z_renamed, boolean z2, long j_renamed) {
    }

    @Override // com.oplus.camera.ui.menu.f_renamed
    public void b_renamed(java.lang.String str) {
    }

    public void b_renamed(boolean z_renamed) {
    }

    public void c_renamed(boolean z_renamed, boolean z2) {
    }

    public void d_renamed(boolean z_renamed) {
    }

    public void e_renamed(boolean z_renamed) {
    }

    public boolean e_renamed(java.lang.String str) {
        return false;
    }

    public void f_renamed() {
    }

    public boolean g_renamed() {
        return false;
    }

    public void h_renamed(java.lang.String str) {
    }

    protected void u_renamed() {
    }

    protected void v_renamed() {
    }

    public void w_renamed() {
    }

    public void y_renamed() {
    }

    protected int z_renamed() {
        return 0;
    }

    public CameraMenuOption(com.oplus.camera.ComboPreferences comboPreferences, android.content.Context context, com.oplus.camera.ui.menu.b_renamed bVar, com.oplus.camera.ui.menu.setting.i_renamed iVar, com.oplus.camera.ui.CameraUIListener cameraUIListener, int i_renamed, java.lang.String str) {
        this.f6559a = null;
        this.j_renamed = 0;
        this.k_renamed = null;
        this.l_renamed = null;
        this.n_renamed = null;
        this.p_renamed = null;
        this.z_renamed = 0;
        this.A_renamed = 0;
        this.C_renamed = null;
        this.D_renamed = 0;
        this.k_renamed = context;
        this.f6559a = comboPreferences;
        this.l_renamed = iVar;
        if (bVar != null) {
            this.p_renamed = bVar;
            this.p_renamed.setCameraUIListener(cameraUIListener);
            if (!com.oplus.camera.ui.e_renamed.a_renamed(this.p_renamed)) {
                com.oplus.camera.e_renamed.a_renamed("CameraMenuOption", "CameraMenuOption, getOptionKey: " + bVar.getOptionKey());
                return;
            }
            this.C_renamed = new java.util.ArrayList<>(this.p_renamed.getOptionItems());
            l_renamed(m_renamed(str));
        }
        this.z_renamed = this.k_renamed.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.menu_panel_padding_left_right);
        this.A_renamed = this.k_renamed.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.menu_rec_mode_padding_left);
        this.D_renamed = this.k_renamed.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.sub_menu_fade_out_y);
        this.n_renamed = cameraUIListener;
        this.j_renamed = i_renamed;
    }

    public void b_renamed() {
        q_renamed();
        s_renamed();
        c_renamed();
        boolean z_renamed = this.q_renamed;
        this.e_renamed = !z_renamed;
        a_renamed(z_renamed, this.e_renamed);
    }

    public void c_renamed() {
        if (this.d_renamed) {
            return;
        }
        com.oplus.camera.ui.menu.g_renamed.a_renamed(this);
    }

    public void d_renamed() {
        com.oplus.camera.ui.menu.BasicOptionItemList basicOptionItemList = this.f6560b;
        if (basicOptionItemList != null) {
            basicOptionItemList.g_renamed();
        }
        if (D_renamed()) {
            E_renamed();
        }
        b_renamed(true, true);
        com.oplus.camera.ui.menu.g_renamed.b_renamed(this);
    }

    public void e_renamed() {
        m_renamed();
    }

    public void a_renamed(int i_renamed) {
        if (this.f_renamed || X_renamed() <= 0) {
            i_renamed = 8;
        }
        if (J_renamed() == null || G_renamed() == i_renamed) {
            return;
        }
        J_renamed().setVisibility(i_renamed);
    }

    public void a_renamed(boolean z_renamed, boolean z2) {
        com.a_renamed.a_renamed.f_renamed fVar;
        if (!this.e_renamed && s_renamed()) {
            if (J_renamed() != null) {
                J_renamed().setEnabled(z_renamed);
                boolean z3 = z2 && !z_renamed;
                if (!z3 && (fVar = this.H_renamed) != null && !fVar.i_renamed()) {
                    this.H_renamed.k_renamed();
                    this.H_renamed.j_renamed();
                }
                J_renamed().setAlpha(z3 ? 0.5f : 1.0f);
                if (J_renamed() instanceof android.view.ViewGroup) {
                    android.view.ViewGroup viewGroup = (android.view.ViewGroup) J_renamed();
                    for (int i_renamed = 0; i_renamed < viewGroup.getChildCount(); i_renamed++) {
                        viewGroup.getChildAt(i_renamed).setEnabled(z_renamed);
                    }
                }
            }
            this.q_renamed = z_renamed;
            com.oplus.camera.ui.menu.BasicOptionItemList basicOptionItemList = this.f6560b;
            if (basicOptionItemList != null) {
                basicOptionItemList.a_renamed(z_renamed, z2);
                return;
            }
            return;
        }
        if (J_renamed() != null) {
            J_renamed().setEnabled(false);
            J_renamed().setAlpha(0.5f);
            if (J_renamed() instanceof android.view.ViewGroup) {
                android.view.ViewGroup viewGroup2 = (android.view.ViewGroup) J_renamed();
                for (int i2 = 0; i2 < viewGroup2.getChildCount(); i2++) {
                    viewGroup2.getChildAt(i2).setEnabled(false);
                }
            }
        }
        this.q_renamed = false;
        com.oplus.camera.ui.menu.BasicOptionItemList basicOptionItemList2 = this.f6560b;
        if (basicOptionItemList2 != null) {
            basicOptionItemList2.a_renamed(false, true);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B_renamed:16:0x005b  */
    @Override // com.oplus.camera.ui.menu.BasicOptionItemList.OptionItemListListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void a_renamed(com.oplus.camera.ui.menu.setting.CameraMenuOption r5, int r6) {
        /*
            r4 = this;
            com.oplus.camera.ui.menu.setting.i_renamed r5 = r4.l_renamed
            if (r5 == 0) goto L92
            java.lang.String r0 = r4.a_renamed()
            r1 = 0
            r2 = 1
            boolean r5 = r5.a_renamed(r0, r2, r1)
            if (r5 != 0) goto L30
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "onItemSelected, key: "
            r5.append(r6)
            java.lang.String r4 = r4.a_renamed()
            r5.append(r4)
            java.lang.String r4 = ", return"
            r5.append(r4)
            java.lang.String r4 = r5.toString()
            java.lang.String r5 = "CameraMenuOption"
            com.oplus.camera.e_renamed.a_renamed(r5, r4)
            return
        L30:
            com.oplus.camera.ui.menu.setting.i_renamed r5 = r4.l_renamed
            java.lang.String r0 = r4.a_renamed()
            int r3 = r4.o_renamed
            java.lang.String r5 = r5.a_renamed(r0, r3, r6)
            if (r5 == 0) goto L44
            java.util.ArrayList<com.oplus.camera.ui.menu.e_renamed> r6 = r4.C_renamed
            int r6 = com.oplus.camera.ui.e_renamed.a_renamed(r5, r6)
        L44:
            int r5 = r4.o_renamed
            if (r5 == r6) goto L5b
            r4.i_renamed(r6)
            r4.r_renamed()
            com.oplus.camera.ui.menu.setting.i_renamed r5 = r4.l_renamed
            java.lang.String r6 = r4.a_renamed()
            boolean r5 = r5.a_renamed(r6, r2)
            if (r5 == 0) goto L5b
            goto L5c
        L5b:
            r1 = r2
        L5c:
            com.oplus.camera.ui.menu.BasicOptionItemList r5 = r4.f6560b
            if (r5 == 0) goto L70
            com.oplus.camera.ui.menu.b_renamed r6 = r4.p_renamed
            android.graphics.Bitmap r6 = r6.getOptionSingleIcon()
            r5.setOptionItemIcon(r6)
            com.oplus.camera.ui.menu.BasicOptionItemList r5 = r4.f6560b
            int r6 = r4.o_renamed
            r5.setSelectItemIndex(r6)
        L70:
            android.view.View r5 = r4.J_renamed()
            if (r5 == 0) goto L84
            r5 = 3
            int r6 = r4.ac_renamed()
            if (r5 == r6) goto L84
            android.view.View r5 = r4.J_renamed()
            r5.invalidate()
        L84:
            if (r1 == 0) goto L89
            r4.p_renamed()
        L89:
            com.oplus.camera.ui.menu.setting.i_renamed r5 = r4.l_renamed
            java.lang.String r4 = r4.a_renamed()
            r5.a_renamed(r4)
        L92:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.ui.menu.setting.CameraMenuOption.a_renamed(com.oplus.camera.ui.menu.setting.CameraMenuOption, int):void");
    }

    public boolean h_renamed() {
        com.oplus.camera.ui.menu.BasicOptionItemList basicOptionItemList = this.f6560b;
        return basicOptionItemList != null && basicOptionItemList.isShown();
    }

    public boolean i_renamed() {
        return this.f_renamed;
    }

    public boolean j_renamed() {
        return this.g_renamed;
    }

    public void a_renamed(boolean z_renamed) {
        this.g_renamed = z_renamed;
    }

    public void a_renamed(int i_renamed, boolean z_renamed) {
        com.oplus.camera.ui.menu.BasicOptionItemList basicOptionItemList = this.f6560b;
        if (basicOptionItemList != null) {
            basicOptionItemList.a_renamed(i_renamed, z_renamed);
        }
    }

    public void k_renamed() {
        l_renamed();
        if (this.f6560b != null) {
            this.n_renamed.bL_renamed().e_renamed(new com.oplus.camera.screen.b_renamed.o_renamed.a_renamed() { // from class: com.oplus.camera.ui.menu.setting.-$$Lambda$CameraMenuOption$U_renamed-iLBZn4BP4aQ9rJbPuE6YE_QkY
                @Override // com.oplus.camera.screen.b_renamed.o_renamed.a_renamed
                public final void call(java.lang.Object[] objArr) {
                    this.f_renamed$0.d_renamed(objArr);
                }
            }, new com.oplus.camera.screen.b_renamed.o_renamed.a_renamed() { // from class: com.oplus.camera.ui.menu.setting.-$$Lambda$CameraMenuOption$-0L38qLLrCJsKmDCdwHbKVqY99k
                @Override // com.oplus.camera.screen.b_renamed.o_renamed.a_renamed
                public final void call(java.lang.Object[] objArr) {
                    this.f_renamed$0.c_renamed(objArr);
                }
            });
            this.f6560b.setVisibility(8);
            this.f6560b.a_renamed(this.l_renamed.getOrientation(), false);
            this.f6560b.setOptionItemIcon(this.p_renamed.getOptionSingleIcon());
            this.f6560b.setSelectItemIndex(this.o_renamed);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d_renamed(java.lang.Object[] objArr) {
        this.f6560b.a_renamed(this.j_renamed);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c_renamed(java.lang.Object[] objArr) {
        this.f6560b.setBackground(androidx.core.a_renamed.a_renamed.a_renamed(this.k_renamed, com.oplus.camera.R_renamed.drawable.bg_second_level_panel_black));
    }

    public void l_renamed() {
        int iX;
        com.oplus.camera.e_renamed.a_renamed("CameraMenuOption", "initializeOptionItems");
        if (Z_renamed() || (iX = X_renamed()) <= 0) {
            return;
        }
        this.f6560b = new com.oplus.camera.ui.menu.d_renamed(this.k_renamed, this.n_renamed);
        this.f6560b.setId(com.oplus.camera.R_renamed.id_renamed.camera_setting_layout_second_level);
        for (int i_renamed = 0; i_renamed < iX; i_renamed++) {
            com.oplus.camera.ui.menu.setting.j_renamed jVar = new com.oplus.camera.ui.menu.setting.j_renamed(this.f6559a, this.k_renamed, this.n_renamed, this.j_renamed);
            jVar.b_renamed();
            com.oplus.camera.ui.menu.e_renamed eVarH = h_renamed(i_renamed);
            if (eVarH != null) {
                if (ac_renamed() == 3) {
                    if (com.oplus.camera.statistics.model.DcsMsgData.FULL.equals(eVarH.c_renamed()) && com.oplus.camera.util.Util.u_renamed()) {
                        jVar.b_renamed(this.k_renamed.getDrawable(com.oplus.camera.R_renamed.drawable.photo_ratio_14_15_selector), false);
                    } else {
                        jVar.b_renamed(eVarH.a_renamed().getConstantState().newDrawable(), false);
                    }
                } else if (ac_renamed() == 4) {
                    jVar.h_renamed(java.lang.String.format(java.util.Locale.getDefault(), "%d_renamed", java.lang.Integer.valueOf(eVarH.c_renamed())) + "X_renamed");
                } else {
                    jVar.h_renamed(eVarH.e_renamed());
                }
            }
            this.f6560b.a_renamed(jVar);
        }
        this.f6560b.setTitleName(N_renamed());
        this.f6560b.setOptionItemIcon(this.p_renamed.getOptionSingleIcon());
        this.f6560b.setSelectItemIndex(this.o_renamed);
        this.f6560b.setOptionItemListListener(this);
        if (1 == this.n_renamed.ca_renamed()) {
            this.n_renamed.bL_renamed().a_renamed(J_renamed(), this.f6560b, this.k_renamed, iX);
        } else if (3 == this.n_renamed.ca_renamed() && 1 == this.n_renamed.G_renamed()) {
            this.f6560b.a_renamed(J_renamed(), 0, this.k_renamed.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.fold_split_screen_front_setting_topMargin_offset_20));
        } else if (4 == this.n_renamed.ca_renamed()) {
            this.f6560b.i_renamed();
            this.n_renamed.bL_renamed().a_renamed(J_renamed(), this.f6560b, this.k_renamed, iX);
        } else {
            this.f6560b.a_renamed(J_renamed(), 0, 2);
        }
        this.f6560b.setVisibility(8);
    }

    public void m_renamed() {
        com.oplus.camera.ui.menu.BasicOptionItemList basicOptionItemList = this.f6560b;
        if (basicOptionItemList != null) {
            basicOptionItemList.h_renamed();
            this.f6560b = null;
        }
    }

    public void n_renamed() {
        b_renamed(true, true);
        a_renamed(true);
        com.oplus.camera.ui.menu.b_renamed bVar = this.p_renamed;
        if (bVar != null) {
            bVar.release();
            this.p_renamed = null;
        }
        java.util.ArrayList<com.oplus.camera.ui.menu.e_renamed> arrayList = this.C_renamed;
        if (arrayList != null) {
            java.util.Iterator<com.oplus.camera.ui.menu.e_renamed> it = arrayList.iterator();
            while (it.hasNext()) {
                com.oplus.camera.ui.menu.e_renamed next = it.next();
                if (next != null) {
                    next.g_renamed();
                }
            }
            this.C_renamed.clear();
            this.C_renamed = null;
        }
        this.l_renamed = null;
        com.oplus.camera.ui.menu.g_renamed.b_renamed(this);
        m_renamed();
        if (J_renamed() != null) {
            J_renamed().clearAnimation();
        }
        com.oplus.camera.ui.menu.setting.CameraMenuOption.LayoutTranslationAnimation layoutTranslationAnimation = this.w_renamed;
        if (layoutTranslationAnimation != null) {
            layoutTranslationAnimation.cancel();
            this.w_renamed = null;
        }
        A_renamed();
        this.k_renamed = null;
    }

    public void o_renamed() {
        com.oplus.camera.ui.menu.BasicOptionItemList basicOptionItemList = this.f6560b;
        if (basicOptionItemList != null) {
            com.oplus.camera.ui.menu.g_renamed.a_renamed(basicOptionItemList);
        }
    }

    public void p_renamed() {
        com.oplus.camera.ui.menu.BasicOptionItemList basicOptionItemList = this.f6560b;
        if (basicOptionItemList == null || !basicOptionItemList.isShown()) {
            return;
        }
        this.f6560b.e_renamed();
    }

    public void q_renamed() {
        if (X_renamed() > 0) {
            a_renamed(R_renamed(), S_renamed());
        } else {
            a_renamed((android.graphics.drawable.Drawable) null, false);
        }
        h_renamed(V_renamed());
        if (J_renamed() != null) {
            J_renamed().invalidate();
        }
    }

    public void r_renamed() {
        q_renamed();
    }

    public boolean a_renamed(java.lang.String str, int i_renamed) {
        if (str == null || !str.equals(a_renamed())) {
            return false;
        }
        if (this.C_renamed == null) {
            return true;
        }
        for (int i2 = 0; i2 < this.C_renamed.size(); i2++) {
            com.oplus.camera.ui.menu.e_renamed eVar = this.C_renamed.get(i2);
            eVar.a_renamed(this.k_renamed.getDrawable(i_renamed));
            a_renamed(eVar.a_renamed(), false);
        }
        return true;
    }

    public boolean a_renamed(java.lang.String str, java.lang.String str2, java.util.List<java.lang.String> list) {
        if (str == null || !str.equals(a_renamed())) {
            return false;
        }
        if (a_renamed(list, m_renamed(str2))) {
            if (this.f6560b != null) {
                m_renamed();
            }
            q_renamed();
            if (X_renamed() < 2) {
                a_renamed(false, true);
            } else if (!this.e_renamed && this.l_renamed.getMenuPanelEnable()) {
                a_renamed(true, false);
            }
            if (X_renamed() <= 0) {
                a_renamed(8);
            } else {
                f_renamed(str2);
            }
        } else {
            f_renamed(str2);
            q_renamed();
        }
        return true;
    }

    protected boolean s_renamed() {
        return X_renamed() >= 2;
    }

    public boolean t_renamed() {
        return this.q_renamed;
    }

    public boolean a_renamed(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        if (str != null && !str.equals(a_renamed())) {
            return false;
        }
        com.oplus.camera.e_renamed.a_renamed("CameraMenuOption", "disableMenuOption, key: " + str + ", keyValue: " + str3);
        if (s_renamed()) {
            this.e_renamed = true;
            a_renamed(false, true);
            this.q_renamed = !this.e_renamed;
            if (str3 == null) {
                this.h_renamed = false;
                f_renamed(str2);
            } else if (i_renamed(str3)) {
                a_renamed(R_renamed(), S_renamed());
            }
            if (J_renamed() != null) {
                J_renamed().invalidate();
            }
        }
        return true;
    }

    public boolean b_renamed(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        if (str != null && !str.equals(a_renamed())) {
            return false;
        }
        com.oplus.camera.e_renamed.a_renamed("CameraMenuOption", "enableMenuOption, key: " + str + ", keyValue: " + str3);
        if (s_renamed()) {
            this.e_renamed = false;
            a_renamed(true, false);
            this.q_renamed = !this.e_renamed;
            if (str3 == null) {
                this.h_renamed = false;
                f_renamed(str2);
            } else if (i_renamed(str3)) {
                a_renamed(R_renamed(), S_renamed());
            }
            if (J_renamed() != null) {
                J_renamed().invalidate();
            }
        }
        return true;
    }

    public boolean a_renamed(java.lang.String str, java.lang.String... strArr) {
        if (str == null || !str.equals(a_renamed())) {
            return false;
        }
        com.oplus.camera.e_renamed.a_renamed("CameraMenuOption", "addMenuOptionItems, key: " + str);
        if (strArr == null || strArr.length <= 0) {
            return true;
        }
        for (java.lang.String str2 : strArr) {
            int iK = k_renamed(str2);
            if (iK >= 0 && this.f6560b != null) {
                com.oplus.camera.ui.menu.setting.j_renamed jVar = new com.oplus.camera.ui.menu.setting.j_renamed(this.f6559a, this.k_renamed, this.n_renamed, this.j_renamed);
                jVar.b_renamed();
                com.oplus.camera.ui.menu.e_renamed eVarH = h_renamed(iK);
                if (eVarH != null) {
                    jVar.h_renamed(eVarH.e_renamed());
                    jVar.a_renamed(eVarH.a_renamed().getConstantState().newDrawable(), false);
                    this.f6560b.a_renamed(jVar, iK);
                }
            }
        }
        com.oplus.camera.ui.menu.BasicOptionItemList basicOptionItemList = this.f6560b;
        if (basicOptionItemList == null) {
            return true;
        }
        basicOptionItemList.setSelectItemIndex(this.o_renamed);
        this.f6560b.setTitleName(N_renamed());
        this.f6560b.b_renamed();
        return true;
    }

    public boolean b_renamed(java.lang.String str, java.lang.String... strArr) {
        if (str == null || !str.equals(a_renamed())) {
            return false;
        }
        com.oplus.camera.e_renamed.a_renamed("CameraMenuOption", "removeMenuOptionItems, key: " + str + ", mOptionItemList: " + this.f6560b + ", remove keys: " + java.util.Arrays.toString(strArr));
        if (strArr == null || strArr.length <= 0) {
            return true;
        }
        for (java.lang.String str2 : strArr) {
            int iJ = j_renamed(str2);
            if (iJ >= 0) {
                com.oplus.camera.ui.menu.BasicOptionItemList basicOptionItemList = this.f6560b;
                if (basicOptionItemList != null) {
                    basicOptionItemList.b_renamed(iJ);
                    this.f6560b.setSelectItemIndex(this.o_renamed);
                }
                q_renamed();
            }
        }
        return true;
    }

    public boolean a_renamed(java.lang.String str, java.lang.String str2, int i_renamed, boolean z_renamed) throws android.content.res.Resources.NotFoundException {
        if (str != null && str.equals(a_renamed()) && i_renamed()) {
            d_renamed(str);
            com.oplus.camera.ui.menu.setting.i_renamed iVar = this.l_renamed;
            if (iVar != null && iVar.b_renamed(str)) {
                this.f_renamed = false;
                a_renamed(false);
                f_renamed(str2);
                a_renamed(this.l_renamed.getMenuPanelEnable(), this.l_renamed.getMenuPanelAshed());
                if (i_renamed == 0 && z_renamed) {
                    e_renamed(i_renamed);
                } else {
                    a_renamed(i_renamed);
                }
            }
            u_renamed();
            return true;
        }
        if (str == null || !str.equals(a_renamed()) || F_renamed() != 0) {
            return false;
        }
        d_renamed(str);
        if (i_renamed == 0) {
            e_renamed(i_renamed);
        }
        u_renamed();
        return true;
    }

    public void d_renamed(java.lang.String str) throws android.content.res.Resources.NotFoundException {
        com.oplus.camera.util.Util.q_renamed(this.k_renamed);
        int iconsId = this.p_renamed.getIconsId();
        if (this.J_renamed || iconsId == 0) {
            return;
        }
        com.oplus.camera.e_renamed.a_renamed("CameraMenuOption", "addContainMenuOption, lazy load key: " + str + ", iconsId: " + iconsId);
        android.content.res.TypedArray typedArrayObtainTypedArray = this.k_renamed.getResources().obtainTypedArray(iconsId);
        if (typedArrayObtainTypedArray != null) {
            for (int i_renamed = 0; i_renamed < typedArrayObtainTypedArray.length(); i_renamed++) {
                if (i_renamed < this.p_renamed.getOptionItems().size()) {
                    com.oplus.camera.ui.menu.e_renamed eVar = this.p_renamed.getOptionItems().get(i_renamed);
                    eVar.a_renamed(this.k_renamed.getDrawable(typedArrayObtainTypedArray.getResourceId(i_renamed, -1)));
                    a_renamed(str, eVar);
                }
            }
            typedArrayObtainTypedArray.recycle();
        }
        this.J_renamed = true;
    }

    public boolean b_renamed(java.lang.String str, boolean z_renamed) {
        if (str == null || !str.equals(a_renamed())) {
            return false;
        }
        this.f_renamed = true;
        if (J_renamed() != null && G_renamed() != 8) {
            if (z_renamed && 4 != J_renamed().getVisibility()) {
                b_renamed(8, false);
            } else {
                a_renamed(8);
            }
        }
        v_renamed();
        return true;
    }

    public void f_renamed(java.lang.String str) {
        if (this.e_renamed) {
            return;
        }
        l_renamed(m_renamed(str));
        if (!i_renamed()) {
            q_renamed();
        }
        com.oplus.camera.ui.menu.BasicOptionItemList basicOptionItemList = this.f6560b;
        if (basicOptionItemList != null) {
            basicOptionItemList.setSelectItemIndex(this.o_renamed);
        }
    }

    @Override // com.oplus.camera.ui.menu.f_renamed
    public void a_renamed(java.lang.String str) {
        com.oplus.camera.e_renamed.a_renamed("CameraMenuOption", "showPopUpWindowBegin, key: " + str + ", option key: " + a_renamed());
        if (!H_renamed() || i_renamed() || J_renamed() == null) {
            return;
        }
        J_renamed().setClickable(false);
        g_renamed(str);
    }

    @Override // com.oplus.camera.ui.menu.f_renamed
    public void a_renamed(java.lang.String str, boolean z_renamed) {
        com.oplus.camera.e_renamed.a_renamed("CameraMenuOption", "hidePopUpWindowBegin, key: " + str + ", option key: " + a_renamed());
        if (J_renamed() == null) {
            return;
        }
        if (1 == F_renamed()) {
            J_renamed().setClickable(false);
        }
        if (3 == F_renamed()) {
            J_renamed().clearAnimation();
            c_renamed(z_renamed);
            return;
        }
        if (1 == F_renamed()) {
            d_renamed(2);
            q_renamed();
            J_renamed().clearAnimation();
            if (this.w_renamed != null) {
                if (D_renamed()) {
                    E_renamed();
                }
                a_renamed(J_renamed().getLeft(), this.x_renamed);
            } else if (G_renamed() != 0) {
                E_renamed();
                b_renamed(this.x_renamed);
            }
        }
    }

    @Override // com.oplus.camera.ui.menu.f_renamed
    public void c_renamed(java.lang.String str) {
        if (J_renamed() != null) {
            J_renamed().setClickable(true);
            if (F_renamed() != 0) {
                a_renamed(1.0f);
            }
            if (3 == F_renamed() && !i_renamed()) {
                J_renamed().setVisibility(0);
            } else if (1 == F_renamed()) {
                d_renamed(0);
                b_renamed(this.x_renamed);
            }
        }
        if (str.equals(a_renamed())) {
            r_renamed();
        } else {
            q_renamed();
        }
        d_renamed(0);
    }

    public void g_renamed(java.lang.String str) {
        com.oplus.camera.e_renamed.a_renamed("CameraMenuOption", "hideMenu, option key: " + a_renamed() + ", remove: " + this.f_renamed + ", state: " + F_renamed() + ", itemView: " + J_renamed() + ", show: " + H_renamed());
        if (!H_renamed() || i_renamed() || F_renamed() != 0 || J_renamed() == null) {
            return;
        }
        d_renamed(3);
        ai_renamed();
        this.E_renamed.setAnimationListener(new android.view.animation.Animation.AnimationListener() { // from class: com.oplus.camera.ui.menu.setting.CameraMenuOption.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(android.view.animation.Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(android.view.animation.Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(android.view.animation.Animation animation) {
                if (com.oplus.camera.ui.menu.setting.CameraMenuOption.this.J_renamed() == null || 3 != com.oplus.camera.ui.menu.setting.CameraMenuOption.this.F_renamed()) {
                    return;
                }
                com.oplus.camera.ui.menu.setting.CameraMenuOption.this.J_renamed().setVisibility(4);
            }
        });
        J_renamed().clearAnimation();
        J_renamed().startAnimation(this.E_renamed);
    }

    public void c_renamed(boolean z_renamed) {
        com.oplus.camera.e_renamed.a_renamed("CameraMenuOption", "showMenu, option key: " + a_renamed() + ", remove: " + this.f_renamed + ", state: " + F_renamed() + ", itemView: " + J_renamed() + ", animation: " + z_renamed);
        if (this.F_renamed == null) {
            ah_renamed();
        }
        if (z_renamed) {
            J_renamed().clearAnimation();
            this.u_renamed = true;
            J_renamed().startAnimation(this.F_renamed);
        } else {
            J_renamed().setAlpha(1.0f);
        }
        this.K_renamed = false;
    }

    private void ah_renamed() {
        this.F_renamed = new android.view.animation.AnimationSet(false);
        android.view.animation.AlphaAnimation alphaAnimation = new android.view.animation.AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(300L);
        alphaAnimation.setInterpolator(this.r_renamed);
        alphaAnimation.setStartOffset(150L);
        this.F_renamed.addAnimation(alphaAnimation);
        android.view.animation.TranslateAnimation translateAnimation = new android.view.animation.TranslateAnimation(0.0f, 0.0f, 0.0f - this.D_renamed, 0.0f);
        translateAnimation.setDuration(300L);
        translateAnimation.setInterpolator(this.s_renamed);
        translateAnimation.setStartOffset(150L);
        translateAnimation.setFillEnabled(true);
        translateAnimation.setFillBefore(true);
        this.F_renamed.addAnimation(translateAnimation);
        this.F_renamed.setAnimationListener(new android.view.animation.Animation.AnimationListener() { // from class: com.oplus.camera.ui.menu.setting.CameraMenuOption.2
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(android.view.animation.Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(android.view.animation.Animation animation) {
                com.oplus.camera.ui.menu.setting.CameraMenuOption.this.u_renamed = true;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(android.view.animation.Animation animation) {
                com.oplus.camera.ui.menu.setting.CameraMenuOption.this.u_renamed = false;
            }
        });
    }

    private void ai_renamed() {
        if (this.E_renamed == null) {
            this.E_renamed = new android.view.animation.AnimationSet(false);
            android.view.animation.AlphaAnimation alphaAnimation = new android.view.animation.AlphaAnimation(1.0f, 0.0f);
            alphaAnimation.setDuration(250L);
            alphaAnimation.setInterpolator(this.r_renamed);
            this.E_renamed.addAnimation(alphaAnimation);
            android.view.animation.TranslateAnimation translateAnimation = new android.view.animation.TranslateAnimation(0.0f, 0.0f, 0.0f, 0.0f - this.D_renamed);
            translateAnimation.setDuration(300L);
            translateAnimation.setInterpolator(this.s_renamed);
            translateAnimation.setFillBefore(true);
            translateAnimation.setFillEnabled(true);
            this.E_renamed.addAnimation(translateAnimation);
        }
    }

    public int x_renamed() {
        return this.x_renamed;
    }

    public void b_renamed(int i_renamed) {
        com.oplus.camera.e_renamed.a_renamed("CameraMenuOption", "key: " + a_renamed() + " resetLayout left: " + i_renamed);
        if (J_renamed() != null) {
            J_renamed().layout(i_renamed, J_renamed().getTop(), J_renamed().getWidth() + i_renamed, J_renamed().getBottom());
        }
    }

    public void b_renamed(boolean z_renamed, boolean z2) {
        if (F_renamed() != 0) {
            if (J_renamed() != null) {
                J_renamed().setClickable(true);
                J_renamed().setAlpha(1.0f);
                if (3 == F_renamed() && z_renamed) {
                    J_renamed().setVisibility(0);
                } else if (1 == F_renamed() && z2) {
                    d_renamed(0);
                    q_renamed();
                    b_renamed(this.x_renamed);
                }
            }
            d_renamed(0);
        }
    }

    public void a_renamed(float f_renamed) {
        if (J_renamed() != null) {
            android.view.View viewJ = J_renamed();
            if (f_renamed == 1.0f && !J_renamed().isEnabled()) {
                f_renamed = J_renamed().getAlpha();
            }
            viewJ.setAlpha(f_renamed);
        }
    }

    public void a_renamed(com.oplus.camera.ui.menu.setting.CameraMenuOption.OnItemClickListener onItemClickListener) {
        this.m_renamed = onItemClickListener;
    }

    public void a_renamed(android.view.ViewGroup viewGroup) {
        if (viewGroup == null || J_renamed() == null) {
            return;
        }
        try {
            this.f6561c = viewGroup;
            viewGroup.addView(J_renamed());
        } catch (java.lang.Exception e_renamed) {
            com.oplus.camera.e_renamed.a_renamed("CameraMenuOption", "addItemViewToParent, Exception: " + e_renamed.toString());
        }
    }

    protected void A_renamed() {
        if (this.f6561c != null && J_renamed() != null) {
            this.f6561c.removeView(J_renamed());
        }
        this.f6561c = null;
    }

    public void a_renamed(int i_renamed, int i2, int i3, int i4) {
        if (J_renamed() != null) {
            J_renamed().layout(i_renamed, i2, i3, i4);
        }
    }

    public boolean D_renamed() {
        return this.v_renamed;
    }

    public void c_renamed(int i_renamed) {
        com.oplus.camera.ui.menu.setting.CameraMenuOption.LayoutTranslationAnimation layoutTranslationAnimation = this.w_renamed;
        if (layoutTranslationAnimation != null) {
            if (-1 != i_renamed) {
                layoutTranslationAnimation.a_renamed(i_renamed);
            }
            this.w_renamed.cancel();
        }
    }

    public void E_renamed() {
        com.oplus.camera.ui.menu.setting.CameraMenuOption.LayoutTranslationAnimation layoutTranslationAnimation = this.w_renamed;
        if (layoutTranslationAnimation == null || !this.v_renamed) {
            return;
        }
        layoutTranslationAnimation.onAnimationEnd(layoutTranslationAnimation);
    }

    public void d_renamed(int i_renamed) {
        com.oplus.camera.e_renamed.a_renamed("CameraMenuOption", "key: " + a_renamed() + " setItemState, state( " + this.y_renamed + " ==> " + i_renamed + " )");
        this.y_renamed = i_renamed;
    }

    public int F_renamed() {
        return this.y_renamed;
    }

    public void a_renamed(int i_renamed, int i2) {
        com.oplus.camera.e_renamed.a_renamed("CameraMenuOption", "animationLayoutTranslationToX, startPos: " + i_renamed + "endPos: " + i2 + " key: " + a_renamed());
        if (i_renamed == i2 || J_renamed() == null) {
            return;
        }
        if (this.w_renamed == null) {
            this.w_renamed = new com.oplus.camera.ui.menu.setting.CameraMenuOption.LayoutTranslationAnimation();
            this.w_renamed.setInterpolator(this.s_renamed);
            com.oplus.camera.ui.menu.setting.CameraMenuOption.LayoutTranslationAnimation layoutTranslationAnimation = this.w_renamed;
            layoutTranslationAnimation.setAnimationListener(layoutTranslationAnimation);
        }
        if (this.v_renamed) {
            this.w_renamed.a_renamed(i2);
            return;
        }
        this.v_renamed = true;
        this.w_renamed.a_renamed(i_renamed, i2);
        this.w_renamed.setDuration(500L);
        J_renamed().clearAnimation();
        J_renamed().startAnimation(this.w_renamed);
    }

    public void a_renamed(int i_renamed, int i2, int i3) {
        android.view.animation.AlphaAnimation alphaAnimation;
        com.oplus.camera.e_renamed.a_renamed("CameraMenuOption", "layoutWithAnimationSet, startPos: " + i_renamed + "endPos: " + i2 + " key: " + a_renamed());
        if (i_renamed == i2 || J_renamed() == null) {
            return;
        }
        if (this.w_renamed == null) {
            this.w_renamed = new com.oplus.camera.ui.menu.setting.CameraMenuOption.LayoutTranslationAnimation();
            this.w_renamed.setInterpolator(this.s_renamed);
            com.oplus.camera.ui.menu.setting.CameraMenuOption.LayoutTranslationAnimation layoutTranslationAnimation = this.w_renamed;
            layoutTranslationAnimation.setAnimationListener(layoutTranslationAnimation);
        }
        if (this.v_renamed) {
            this.w_renamed.a_renamed(i2);
            return;
        }
        this.v_renamed = true;
        this.w_renamed.a_renamed(i_renamed, i2);
        this.w_renamed.setDuration(500L);
        android.view.animation.AnimationSet animationSet = new android.view.animation.AnimationSet(false);
        if (i3 == 0) {
            alphaAnimation = new android.view.animation.AlphaAnimation(0.0f, 1.0f);
            alphaAnimation.setDuration(250L);
        } else {
            alphaAnimation = new android.view.animation.AlphaAnimation(1.0f, 0.0f);
            alphaAnimation.setDuration(250L);
        }
        alphaAnimation.setInterpolator(this.r_renamed);
        animationSet.addAnimation(alphaAnimation);
        animationSet.addAnimation(this.w_renamed);
        J_renamed().clearAnimation();
        J_renamed().startAnimation(animationSet);
    }

    public void b_renamed(int i_renamed, boolean z_renamed) {
        android.view.animation.AlphaAnimation alphaAnimation;
        android.view.animation.ScaleAnimation scaleAnimation;
        com.oplus.camera.e_renamed.a_renamed("CameraMenuOption", "viewVisibilityWithAnimationSet, visibility: " + i_renamed + "isScale: " + z_renamed + " key: " + a_renamed());
        android.view.View viewJ = J_renamed();
        if (viewJ == null) {
            return;
        }
        if (this.u_renamed) {
            this.u_renamed = false;
            return;
        }
        if (8 == i_renamed && 4 == viewJ.getVisibility()) {
            return;
        }
        if (4 == i_renamed && 8 == viewJ.getVisibility()) {
            return;
        }
        if (i_renamed != 0 && com.oplus.camera.ui.CameraUIInterface.KEY_SUB_SETTING.equals(a_renamed()) && (viewJ instanceof com.oplus.camera.ui.menu.i_renamed)) {
            com.oplus.camera.ui.menu.i_renamed iVar = (com.oplus.camera.ui.menu.i_renamed) viewJ;
            if (iVar.d_renamed()) {
                iVar.e_renamed();
            }
        }
        viewJ.setVisibility(i_renamed);
        android.view.animation.AnimationSet animationSet = new android.view.animation.AnimationSet(false);
        if (i_renamed == 0) {
            alphaAnimation = new android.view.animation.AlphaAnimation(0.0f, 1.0f);
            alphaAnimation.setDuration(250L);
            scaleAnimation = new android.view.animation.ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 1, 0.5f, 1, K_renamed());
        } else {
            alphaAnimation = new android.view.animation.AlphaAnimation(1.0f, 0.0f);
            alphaAnimation.setDuration(250L);
            scaleAnimation = new android.view.animation.ScaleAnimation(1.0f, 0.0f, 1.0f, 0.0f, 1, 0.5f, 1, K_renamed());
        }
        if (z_renamed) {
            alphaAnimation.setDuration(500L);
        } else {
            alphaAnimation.setDuration(250L);
        }
        scaleAnimation.setDuration(500L);
        alphaAnimation.setInterpolator(this.r_renamed);
        scaleAnimation.setInterpolator(this.t_renamed);
        android.view.animation.ScaleAnimation scaleAnimation2 = !z_renamed ? new android.view.animation.ScaleAnimation(1.0f, 1.0f, 1.0f, 1.0f, 1, 0.5f, 1, K_renamed()) : scaleAnimation;
        animationSet.addAnimation(alphaAnimation);
        animationSet.addAnimation(scaleAnimation2);
        viewJ.clearAnimation();
        viewJ.startAnimation(animationSet);
    }

    public void e_renamed(int i_renamed) {
        if (J_renamed() == null || G_renamed() == i_renamed) {
            return;
        }
        b_renamed(i_renamed, false);
    }

    public int G_renamed() {
        if (J_renamed() != null) {
            return J_renamed().getVisibility();
        }
        return 8;
    }

    public boolean H_renamed() {
        if (J_renamed() != null) {
            return J_renamed().isShown();
        }
        return false;
    }

    public int I_renamed() {
        com.oplus.camera.ui.menu.setting.CameraMenuOption.LayoutTranslationAnimation layoutTranslationAnimation;
        if (this.v_renamed && (layoutTranslationAnimation = this.w_renamed) != null) {
            return layoutTranslationAnimation.a_renamed();
        }
        if (J_renamed() != null) {
            return J_renamed().getLeft();
        }
        return 0;
    }

    public float K_renamed() {
        return this.G_renamed;
    }

    public void f_renamed(int i_renamed) {
        this.j_renamed = i_renamed;
        if (this.f6560b != null) {
            this.n_renamed.bL_renamed().e_renamed(new com.oplus.camera.screen.b_renamed.o_renamed.a_renamed() { // from class: com.oplus.camera.ui.menu.setting.-$$Lambda$CameraMenuOption$0o8ITDEAaqoMbsfgTPMocVN-G5Q
                @Override // com.oplus.camera.screen.b_renamed.o_renamed.a_renamed
                public final void call(java.lang.Object[] objArr) {
                    this.f_renamed$0.b_renamed(objArr);
                }
            }, new com.oplus.camera.screen.b_renamed.o_renamed.a_renamed() { // from class: com.oplus.camera.ui.menu.setting.-$$Lambda$CameraMenuOption$Gb8I-JFr70QtFYpJLtBDodvj-jQ
                @Override // com.oplus.camera.screen.b_renamed.o_renamed.a_renamed
                public final void call(java.lang.Object[] objArr) {
                    this.f_renamed$0.a_renamed(objArr);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b_renamed(java.lang.Object[] objArr) {
        this.f6560b.a_renamed(this.j_renamed);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a_renamed(java.lang.Object[] objArr) {
        this.f6560b.setBackground(androidx.core.a_renamed.a_renamed.a_renamed(this.k_renamed, com.oplus.camera.R_renamed.drawable.bg_second_level_panel_black));
    }

    private class LayoutTranslationAnimation extends android.view.animation.Animation implements android.view.animation.Animation.AnimationListener {

        /* renamed from: b_renamed, reason: collision with root package name */
        private int f6569b = 0;

        /* renamed from: c_renamed, reason: collision with root package name */
        private int f6570c = 0;
        private boolean d_renamed;

        public LayoutTranslationAnimation() {
            this.d_renamed = false;
            com.oplus.camera.ui.menu.setting.CameraMenuOption.this.v_renamed = false;
            this.d_renamed = false;
        }

        public void a_renamed(int i_renamed, int i2) {
            this.f6569b = i_renamed;
            this.f6570c = i2;
        }

        public int a_renamed() {
            return this.f6570c;
        }

        public void a_renamed(int i_renamed) {
            this.f6570c = i_renamed;
        }

        @Override // android.view.animation.Animation
        protected void applyTransformation(float f_renamed, android.view.animation.Transformation transformation) {
            if (com.oplus.camera.ui.menu.setting.CameraMenuOption.this.J_renamed() == null || this.d_renamed || 1 == com.oplus.camera.ui.menu.setting.CameraMenuOption.this.n_renamed.ca_renamed()) {
                return;
            }
            int i_renamed = this.f6570c;
            int i2 = ((int) ((i_renamed - r0) * f_renamed)) + this.f6569b;
            com.oplus.camera.ui.menu.setting.CameraMenuOption cameraMenuOption = com.oplus.camera.ui.menu.setting.CameraMenuOption.this;
            cameraMenuOption.a_renamed(i2, cameraMenuOption.J_renamed().getTop(), com.oplus.camera.ui.menu.setting.CameraMenuOption.this.J_renamed().getWidth() + i2, com.oplus.camera.ui.menu.setting.CameraMenuOption.this.J_renamed().getBottom());
        }

        @Override // android.view.animation.Animation
        public void cancel() {
            this.d_renamed = true;
            if (1 != com.oplus.camera.ui.menu.setting.CameraMenuOption.this.n_renamed.ca_renamed()) {
                com.oplus.camera.ui.menu.setting.CameraMenuOption cameraMenuOption = com.oplus.camera.ui.menu.setting.CameraMenuOption.this;
                cameraMenuOption.a_renamed(this.f6570c, cameraMenuOption.J_renamed().getTop(), this.f6570c + com.oplus.camera.ui.menu.setting.CameraMenuOption.this.J_renamed().getWidth(), com.oplus.camera.ui.menu.setting.CameraMenuOption.this.J_renamed().getBottom());
            }
            super.cancel();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(android.view.animation.Animation animation) {
            com.oplus.camera.ui.menu.setting.CameraMenuOption.this.v_renamed = false;
            this.d_renamed = false;
            if (com.oplus.camera.ui.menu.setting.CameraMenuOption.this.J_renamed() != null) {
                if (1 != com.oplus.camera.ui.menu.setting.CameraMenuOption.this.n_renamed.ca_renamed()) {
                    com.oplus.camera.ui.menu.setting.CameraMenuOption cameraMenuOption = com.oplus.camera.ui.menu.setting.CameraMenuOption.this;
                    cameraMenuOption.a_renamed(this.f6570c, cameraMenuOption.J_renamed().getTop(), this.f6570c + com.oplus.camera.ui.menu.setting.CameraMenuOption.this.J_renamed().getWidth(), com.oplus.camera.ui.menu.setting.CameraMenuOption.this.J_renamed().getBottom());
                }
                if (1 == com.oplus.camera.ui.menu.setting.CameraMenuOption.this.F_renamed()) {
                    com.oplus.camera.ui.menu.setting.CameraMenuOption.this.J_renamed().setClickable(true);
                    com.oplus.camera.ui.menu.setting.CameraMenuOption.this.J_renamed().setAlpha(1.0f);
                }
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(android.view.animation.Animation animation) {
            com.oplus.camera.ui.menu.setting.CameraMenuOption.this.v_renamed = true;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(android.view.animation.Animation animation) {
            if (hasStarted() && !hasEnded()) {
                com.oplus.camera.ui.menu.setting.CameraMenuOption.this.v_renamed = true;
            }
            this.d_renamed = false;
        }
    }

    public void a_renamed(android.view.View view, android.view.MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.K_renamed = true;
            b_renamed(view);
        }
        if (1 == motionEvent.getAction() || 3 == motionEvent.getAction()) {
            c_renamed(view);
        }
    }

    private void b_renamed(final android.view.View view) {
        if (this.I_renamed != null) {
            this.I_renamed = null;
        }
        if (this.H_renamed == null) {
            aj_renamed();
        }
        this.H_renamed.a_renamed(new com.a_renamed.a_renamed.e_renamed() { // from class: com.oplus.camera.ui.menu.setting.CameraMenuOption.3
            @Override // com.a_renamed.a_renamed.e_renamed, com.a_renamed.a_renamed.h_renamed
            public void a_renamed(com.a_renamed.a_renamed.f_renamed fVar) {
                com.oplus.camera.ui.menu.setting.CameraMenuOption.this.a_renamed(view, 1.0f, 0.9f, 1.0f, 0.6f, fVar.c_renamed());
            }
        }).a_renamed(0.0d).b_renamed(1.0d);
    }

    private void c_renamed(final android.view.View view) {
        if (this.H_renamed != null) {
            this.H_renamed = null;
        }
        if (this.I_renamed == null) {
            ak_renamed();
        }
        this.I_renamed.a_renamed(new com.a_renamed.a_renamed.e_renamed() { // from class: com.oplus.camera.ui.menu.setting.CameraMenuOption.4
            @Override // com.a_renamed.a_renamed.e_renamed, com.a_renamed.a_renamed.h_renamed
            public void a_renamed(com.a_renamed.a_renamed.f_renamed fVar) {
                double dC_renamed = fVar.c_renamed();
                if (com.oplus.camera.ui.menu.setting.CameraMenuOption.this.K_renamed) {
                    com.oplus.camera.ui.menu.setting.CameraMenuOption.this.a_renamed(view, 0.9f, 1.0f, 0.6f, 1.0f, dC_renamed);
                } else {
                    com.oplus.camera.ui.menu.setting.CameraMenuOption.this.d_renamed(view);
                }
            }
        }).a_renamed(0.0d).b_renamed(1.0d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a_renamed(android.view.View view, float f_renamed, float f2, float f3, float f4, double d_renamed) {
        float fA_renamed = (float) com.a_renamed.a_renamed.l_renamed.a_renamed(d_renamed, 0.0d, 1.0d, f_renamed, f2);
        float fA2 = (float) com.a_renamed.a_renamed.l_renamed.a_renamed(d_renamed, 0.0d, 1.0d, f3, f4);
        if (view != null) {
            if (view instanceof com.oplus.camera.ui.menu.i_renamed) {
                view.setPivotY(view.getHeight() * ((com.oplus.camera.ui.menu.i_renamed) view).getPivotYScaleValue());
            }
            view.setScaleX(fA_renamed);
            view.setScaleY(fA_renamed);
            if (view.isEnabled()) {
                view.setAlpha(fA2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d_renamed(android.view.View view) {
        if (view != null) {
            view.setScaleX(1.0f);
            view.setScaleY(1.0f);
            a_renamed(1.0f);
        }
    }

    private void aj_renamed() {
        this.H_renamed = com.a_renamed.a_renamed.j_renamed.c_renamed().b_renamed().a_renamed(com.a_renamed.a_renamed.g_renamed.b_renamed(5.0d, 10.0d));
    }

    private void ak_renamed() {
        this.I_renamed = com.a_renamed.a_renamed.j_renamed.c_renamed().b_renamed().a_renamed(com.a_renamed.a_renamed.g_renamed.b_renamed(5.0d, 10.0d));
    }

    @Override // com.oplus.camera.ui.menu.BasicOptionItemList.OptionItemListListener
    public java.lang.String a_renamed() {
        com.oplus.camera.ui.menu.b_renamed bVar = this.p_renamed;
        if (bVar != null) {
            return bVar.getOptionKey();
        }
        return null;
    }

    protected java.lang.String N_renamed() {
        com.oplus.camera.ui.menu.b_renamed bVar = this.p_renamed;
        if (bVar != null) {
            return bVar.getOptionTitle();
        }
        return null;
    }

    public int O_renamed() {
        return this.p_renamed.getOptionType();
    }

    public void c_renamed(java.lang.String str, boolean z_renamed) {
        int iA = com.oplus.camera.ui.e_renamed.a_renamed(str, this.C_renamed);
        if (iA >= 0) {
            this.o_renamed = iA;
            this.B_renamed = str;
            this.h_renamed = false;
            d_renamed(str, z_renamed);
            return;
        }
        com.oplus.camera.e_renamed.f_renamed("CameraMenuOption", "setOptionValue fail! index: " + iA);
    }

    protected void d_renamed(java.lang.String str, boolean z_renamed) {
        com.oplus.camera.ui.CameraUIListener cameraUIListener = this.n_renamed;
        int iG = cameraUIListener != null ? cameraUIListener.G_renamed() : 0;
        if (com.oplus.camera.ui.CameraUIInterface.KEY_SLOW_VIDEO_SIZE.equals(a_renamed())) {
            f_renamed(z_renamed);
            b_renamed(iG, str);
            P_renamed();
        } else if (com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_SIZE.equals(a_renamed())) {
            f_renamed(z_renamed);
            a_renamed(iG, str);
            P_renamed();
        } else {
            android.content.SharedPreferences.Editor editorEdit = this.l_renamed.getSharedPreferences().edit();
            editorEdit.putString(this.p_renamed.getOptionKey(), str);
            f_renamed(z_renamed);
            editorEdit.apply();
            P_renamed();
        }
    }

    protected void f_renamed(boolean z_renamed) {
        com.oplus.camera.ui.CameraUIListener cameraUIListener;
        if (!z_renamed || (cameraUIListener = this.n_renamed) == null) {
            return;
        }
        cameraUIListener.aR_renamed().a_renamed(true);
        this.n_renamed.aR_renamed().b_renamed(this.p_renamed.getOptionKey());
    }

    protected void P_renamed() {
        com.oplus.camera.ui.CameraUIListener cameraUIListener = this.n_renamed;
        if (cameraUIListener != null) {
            cameraUIListener.aR_renamed().a_renamed(false);
            this.n_renamed.aR_renamed().b_renamed((java.lang.String) null);
        }
    }

    private void a_renamed(int i_renamed, java.lang.String str) {
        com.oplus.camera.ui.CameraUIListener cameraUIListener;
        java.lang.String string = this.f6559a.getString(com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_SIZE, com.oplus.camera.aps.config.CameraConfig.getOptionKeyDefaultValue(com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_SIZE, i_renamed));
        if (str == null || !str.equals(string)) {
            java.lang.String string2 = this.f6559a.getString(com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_FPS, this.k_renamed.getString(com.oplus.camera.R_renamed.string.camera_video_default_fps));
            boolean zG = g_renamed(i_renamed);
            android.content.SharedPreferences.Editor editorEdit = this.f6559a.edit();
            editorEdit.putString(com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_SIZE, str);
            editorEdit.putString(com.oplus.camera.ui.CameraUIInterface.KEY_LASTED_VIDEO_SIZE, "");
            editorEdit.putBoolean(com.oplus.camera.ui.CameraUIInterface.KEY_LASTED_VIDEO_SAVE_STATUS, false);
            editorEdit.remove(com.oplus.camera.ui.CameraUIInterface.KEY_STORED_AI_ENHANCEMENT_VIDEO_SIZE);
            if ("video_size_4kuhd".equals(str)) {
                java.lang.String string3 = this.f6559a.getString(com.oplus.camera.ui.CameraUIInterface.KEY_LASTED_VIDEO_FPS, "");
                if (!android.text.TextUtils.isEmpty(string3) && java.lang.String.valueOf(60).equals(string3) && !com.oplus.camera.util.Util.a_renamed(i_renamed, str)) {
                    editorEdit.putString(com.oplus.camera.ui.CameraUIInterface.KEY_LASTED_VIDEO_FPS, "");
                    editorEdit.apply();
                }
                if (a_renamed(i_renamed, (java.lang.String) null, str) && (cameraUIListener = this.n_renamed) != null && java.lang.Float.compare(cameraUIListener.s_renamed(), com.oplus.camera.ag_renamed.f4106a) == 0 && com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_ZOOM_WIDE_ANGLE_OPEN_DEFAULT)) {
                    editorEdit.putString(com.oplus.camera.ui.CameraUIInterface.KEY_NONE_SAT_ULTRA_WIDE_ANGLE, "on_renamed");
                } else {
                    editorEdit.putString(com.oplus.camera.ui.CameraUIInterface.KEY_NONE_SAT_ULTRA_WIDE_ANGLE, "off");
                }
                editorEdit.remove(com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_BLUR_MENU_STATE);
                editorEdit.remove(com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_BLUR_MENU_INDEX);
                editorEdit.remove(com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_BLUR_MENU);
            } else if (zG) {
                editorEdit.putString(com.oplus.camera.ui.CameraUIInterface.KEY_NONE_SAT_ULTRA_WIDE_ANGLE, "off");
                com.oplus.camera.ui.CameraUIListener cameraUIListener2 = this.n_renamed;
                if (cameraUIListener2 != null) {
                    cameraUIListener2.r_renamed();
                }
            }
            if (!com.oplus.camera.util.Util.m_renamed(str) && !com.oplus.camera.e_renamed.a_renamed.a_renamed(i_renamed)) {
                editorEdit.putString(com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_SUPER_EIS_MENU, "off");
                editorEdit.putBoolean(com.oplus.camera.ui.CameraUIInterface.KEY_SUPER_EIS_WIDE, false).apply();
            }
            if (com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_ULTRA_NIGHT_VIDEO) && !"video_size_1080p".equals(str)) {
                editorEdit.putString(com.oplus.camera.ui.CameraUIInterface.KEY_ULTRA_NIGHT_VIDEO, "off").apply();
            }
            if (!com.oplus.camera.util.Util.a_renamed(i_renamed, str)) {
                editorEdit.putString(com.oplus.camera.ui.CameraUIInterface.KEY_LASTED_VIDEO_FPS, "");
                editorEdit.putBoolean(com.oplus.camera.ui.CameraUIInterface.KEY_LASTED_VIDEO_SAVE_STATUS, false);
                if (!java.lang.String.valueOf(30).equals(string2)) {
                    editorEdit.putString(com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_FPS, java.lang.String.valueOf(30));
                }
            }
            if (java.lang.String.valueOf(120).equals(string2) && (!com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_SUPPORT_VIDEO_4K_120_FPS) || !"video_size_4kuhd".equals(str))) {
                editorEdit.putString(com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_FPS, java.lang.String.valueOf(30));
            }
            com.oplus.camera.ui.menu.setting.i_renamed iVar = this.l_renamed;
            if (iVar != null) {
                iVar.a_renamed(a_renamed(), str);
            }
            editorEdit.apply();
            a_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_SIZE, str, 0);
        }
    }

    private void b_renamed(int i_renamed, java.lang.String str) {
        java.lang.String string = this.f6559a.getString(com.oplus.camera.ui.CameraUIInterface.KEY_SLOW_VIDEO_SIZE, com.oplus.camera.util.Util.o_renamed(i_renamed));
        android.content.SharedPreferences.Editor editorEdit = this.f6559a.edit();
        editorEdit.putString(com.oplus.camera.ui.CameraUIInterface.KEY_SLOW_VIDEO_SIZE, str);
        if (!com.oplus.camera.e_renamed.a_renamed.a_renamed(i_renamed)) {
            if (!"video_size_1080p".equals(string) && "video_size_1080p".equals(str)) {
                editorEdit.putInt(com.oplus.camera.ui.CameraUIInterface.KEY_SLOW_VIDEO_REAR_FPS, com.oplus.camera.aps.config.CameraConfig.getConfigIntValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_SLOW_VIDEO_1080P_DEFAULT_VALUE));
            } else if (!"video_size_720p".equals(string) && "video_size_720p".equals(str)) {
                editorEdit.putInt(com.oplus.camera.ui.CameraUIInterface.KEY_SLOW_VIDEO_REAR_FPS, com.oplus.camera.aps.config.CameraConfig.getConfigIntValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_SLOW_VIDEO_720P_DEFAULT_VALUE));
            }
        }
        editorEdit.apply();
    }

    protected boolean g_renamed(int i_renamed) {
        return a_renamed(i_renamed, (java.lang.String) null, (java.lang.String) null) && "on_renamed".equals(this.f6559a.getString(com.oplus.camera.ui.CameraUIInterface.KEY_NONE_SAT_ULTRA_WIDE_ANGLE, "off"));
    }

    protected boolean a_renamed(int i_renamed, java.lang.String str, java.lang.String str2) {
        if (str == null) {
            str = this.f6559a.getString(com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_FPS, this.k_renamed.getString(com.oplus.camera.R_renamed.string.camera_video_default_fps));
        }
        if (str2 == null) {
            str2 = this.f6559a.getString(com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_SIZE, com.oplus.camera.aps.config.CameraConfig.getOptionKeyDefaultValue(com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_SIZE, i_renamed));
        }
        return "video_size_4kuhd".equals(str2) && java.lang.String.valueOf(60).equals(str) && com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_SUPPORT_VIDEO_4K_60FPS_ULTRA_WIDE);
    }

    public android.graphics.drawable.Drawable Q_renamed() {
        java.util.ArrayList<com.oplus.camera.ui.menu.e_renamed> arrayList = this.C_renamed;
        if (arrayList == null || this.o_renamed >= arrayList.size()) {
            return null;
        }
        android.graphics.drawable.Drawable drawableA = this.C_renamed.get(this.o_renamed).a_renamed();
        return drawableA == null ? this.C_renamed.get(0).a_renamed() : drawableA;
    }

    public android.graphics.drawable.Drawable R_renamed() {
        android.graphics.drawable.Drawable drawableA;
        java.util.ArrayList<com.oplus.camera.ui.menu.e_renamed> arrayList = this.C_renamed;
        if (arrayList == null || this.o_renamed >= arrayList.size()) {
            return null;
        }
        if (com.oplus.camera.util.Util.u_renamed() && this.C_renamed.get(this.o_renamed).c_renamed().equals(com.oplus.camera.statistics.model.DcsMsgData.FULL)) {
            drawableA = this.k_renamed.getDrawable(com.oplus.camera.R_renamed.drawable.photo_ratio_14_15_selector);
        } else {
            drawableA = this.C_renamed.get(this.o_renamed).a_renamed();
        }
        return drawableA == null ? this.C_renamed.get(0).a_renamed() : drawableA;
    }

    public boolean S_renamed() {
        return android.text.TextUtils.equals(this.B_renamed, "on_renamed");
    }

    public android.graphics.drawable.Drawable T_renamed() {
        com.oplus.camera.ui.menu.b_renamed bVar = this.p_renamed;
        if (bVar != null) {
            return bVar.getOptionExpandIcon();
        }
        return null;
    }

    public android.graphics.drawable.Drawable g_renamed(boolean z_renamed) {
        java.util.ArrayList<com.oplus.camera.ui.menu.e_renamed> arrayList = this.C_renamed;
        if (arrayList == null || this.o_renamed >= arrayList.size()) {
            return null;
        }
        if (z_renamed) {
            return this.C_renamed.get(1).a_renamed();
        }
        return this.C_renamed.get(0).a_renamed();
    }

    public java.lang.String U_renamed() {
        java.util.ArrayList<com.oplus.camera.ui.menu.e_renamed> arrayList = this.C_renamed;
        return (arrayList == null || this.o_renamed >= arrayList.size() || android.text.TextUtils.isEmpty(this.C_renamed.get(this.o_renamed).d_renamed())) ? "" : this.C_renamed.get(this.o_renamed).d_renamed();
    }

    public java.lang.String V_renamed() {
        java.util.ArrayList<com.oplus.camera.ui.menu.e_renamed> arrayList = this.C_renamed;
        if (arrayList == null || this.o_renamed >= arrayList.size()) {
            return null;
        }
        return this.C_renamed.get(this.o_renamed).e_renamed();
    }

    public int W_renamed() {
        java.util.ArrayList<com.oplus.camera.ui.menu.e_renamed> arrayList = this.C_renamed;
        if (arrayList == null || this.o_renamed >= arrayList.size()) {
            return -1;
        }
        return this.C_renamed.get(this.o_renamed).b_renamed();
    }

    public com.oplus.camera.ui.menu.e_renamed h_renamed(int i_renamed) {
        java.util.ArrayList<com.oplus.camera.ui.menu.e_renamed> arrayList = this.C_renamed;
        if (arrayList == null || arrayList.size() <= i_renamed) {
            return null;
        }
        return this.C_renamed.get(i_renamed);
    }

    public int X_renamed() {
        java.util.ArrayList<com.oplus.camera.ui.menu.e_renamed> arrayList = this.C_renamed;
        if (arrayList != null) {
            return arrayList.size();
        }
        return 0;
    }

    public java.util.ArrayList<com.oplus.camera.ui.menu.e_renamed> Y_renamed() {
        return this.C_renamed;
    }

    public boolean Z_renamed() {
        return this.p_renamed.getOptionOnOff();
    }

    public boolean aa_renamed() {
        return this.p_renamed.getImageTitleMode();
    }

    public boolean ab_renamed() {
        com.oplus.camera.ui.menu.b_renamed bVar = this.p_renamed;
        if (bVar != null) {
            return bVar.getImageTitleColorChangeable();
        }
        com.oplus.camera.e_renamed.b_renamed("CameraMenuOption", "getImageTitleColorChangeable, mCameraMenuOptionInfo is_renamed null");
        return false;
    }

    public int ac_renamed() {
        return this.p_renamed.getGroupType();
    }

    public boolean i_renamed(java.lang.String str) {
        int iA = com.oplus.camera.ui.e_renamed.a_renamed(str, this.C_renamed);
        if (iA < 0 || iA == this.o_renamed) {
            return false;
        }
        this.o_renamed = iA;
        this.B_renamed = this.C_renamed.get(this.o_renamed).c_renamed();
        this.h_renamed = !str.equals(this.f6559a.getString(a_renamed(), ""));
        com.oplus.camera.e_renamed.a_renamed(str, "setOptionValueNoToPreferences, key: " + a_renamed() + ", mOptionValue: " + this.B_renamed);
        return true;
    }

    public void i_renamed(int i_renamed) {
        if (i_renamed < 0 || i_renamed >= this.C_renamed.size()) {
            return;
        }
        c_renamed(this.C_renamed.get(i_renamed).c_renamed(), true);
    }

    public int ad_renamed() {
        return this.o_renamed;
    }

    public int j_renamed(java.lang.String str) {
        if (!com.oplus.camera.ui.e_renamed.b_renamed(str, this.C_renamed)) {
            return -1;
        }
        int iA = com.oplus.camera.ui.e_renamed.a_renamed(str, this.C_renamed);
        if (iA >= 0) {
            this.C_renamed.remove(iA);
        }
        if (this.C_renamed.size() <= 0) {
            com.oplus.camera.e_renamed.a_renamed("CameraMenuOption", "removeOptionItem, the remain item is_renamed 0, Error");
            return iA;
        }
        if (this.B_renamed.equals(str)) {
            this.B_renamed = this.C_renamed.get(ae_renamed()).c_renamed();
            this.o_renamed = 0;
            c_renamed(this.B_renamed, false);
            return iA;
        }
        this.o_renamed = com.oplus.camera.ui.e_renamed.a_renamed(this.B_renamed, this.C_renamed);
        return iA;
    }

    public int k_renamed(java.lang.String str) {
        int i_renamed;
        if (com.oplus.camera.ui.e_renamed.b_renamed(str, this.C_renamed) || !com.oplus.camera.ui.e_renamed.b_renamed(str, this.p_renamed.getOptionItems())) {
            return -1;
        }
        int iA = com.oplus.camera.ui.e_renamed.a_renamed(str, this.p_renamed.getOptionItems());
        if (iA == 0) {
            i_renamed = iA;
        } else {
            i_renamed = 0;
            int i2 = iA - 1;
            while (true) {
                if (i2 < 0) {
                    break;
                }
                int iA2 = com.oplus.camera.ui.e_renamed.a_renamed(this.p_renamed.getOptionItems().get(i2).c_renamed(), this.C_renamed);
                if (iA2 >= 0) {
                    i_renamed = iA2 + 1;
                    break;
                }
                i2--;
            }
        }
        this.C_renamed.add(i_renamed, this.p_renamed.getOptionItems().get(iA));
        if (this.C_renamed.size() <= 0) {
            com.oplus.camera.e_renamed.a_renamed("CameraMenuOption", "addOptionItem, the remain item is_renamed 0, Error");
            return i_renamed;
        }
        this.o_renamed = com.oplus.camera.ui.e_renamed.a_renamed(this.B_renamed, this.C_renamed);
        return i_renamed;
    }

    public boolean a_renamed(java.util.List<java.lang.String> list, java.lang.String str) {
        int size;
        if (list == null || list.size() <= 0) {
            size = this.C_renamed.size();
            this.C_renamed.clear();
        } else {
            java.util.ArrayList<com.oplus.camera.ui.menu.e_renamed> arrayList = new java.util.ArrayList<>();
            java.util.ArrayList<com.oplus.camera.ui.menu.e_renamed> optionItems = this.p_renamed.getOptionItems();
            for (int i_renamed = 0; i_renamed < optionItems.size(); i_renamed++) {
                if (list.indexOf(optionItems.get(i_renamed).c_renamed()) >= 0) {
                    arrayList.add(optionItems.get(i_renamed));
                }
            }
            size = java.lang.Math.abs(this.C_renamed.size() - arrayList.size());
            if (size == 0) {
                int i2 = size;
                for (int i3 = 0; i3 < this.C_renamed.size(); i3++) {
                    if (!this.C_renamed.get(i3).c_renamed().equals(arrayList.get(i3).c_renamed())) {
                        i2++;
                    }
                }
                size = i2;
            }
            this.C_renamed.clear();
            this.C_renamed = arrayList;
            l_renamed(str);
        }
        return size > 0;
    }

    public void l_renamed(java.lang.String str) {
        com.oplus.camera.ui.menu.e_renamed eVar;
        this.B_renamed = this.l_renamed.getSharedPreferences().getString(a_renamed(), str);
        if (this.C_renamed.size() > 0 && (this.q_renamed || com.oplus.camera.ui.e_renamed.a_renamed(this.B_renamed, this.C_renamed) < 0)) {
            if (!this.h_renamed) {
                this.o_renamed = com.oplus.camera.ui.e_renamed.a_renamed(this.B_renamed, this.C_renamed);
                if (this.o_renamed >= 0 && this.C_renamed.size() > 0 && (eVar = this.C_renamed.get(this.o_renamed)) != null && !eVar.f_renamed()) {
                    eVar.a_renamed(true);
                }
            }
            if (this.o_renamed < 0) {
                this.o_renamed = ae_renamed();
                if (this.C_renamed.size() > 0) {
                    this.B_renamed = this.C_renamed.get(this.o_renamed).c_renamed();
                    return;
                }
                return;
            }
            return;
        }
        int iA = com.oplus.camera.ui.e_renamed.a_renamed(this.B_renamed, this.C_renamed);
        if (iA < 0 || iA >= this.C_renamed.size()) {
            this.o_renamed = 0;
            if (this.C_renamed.size() > 0) {
                this.B_renamed = this.C_renamed.get(this.o_renamed).c_renamed();
                return;
            }
            return;
        }
        if (this.o_renamed != iA) {
            this.o_renamed = iA;
        }
    }

    public int ae_renamed() {
        return (!com.oplus.camera.ui.CameraUIInterface.KEY_PHOTO_RATIO.equals(a_renamed()) || this.C_renamed.isEmpty()) ? 0 : 1;
    }

    public java.lang.String m_renamed(java.lang.String str) {
        if (com.oplus.camera.ui.e_renamed.b_renamed(str, this.C_renamed)) {
            return str;
        }
        java.lang.String optionDefaultValue = this.p_renamed.getOptionDefaultValue();
        return com.oplus.camera.ui.e_renamed.b_renamed(optionDefaultValue, this.C_renamed) ? optionDefaultValue : this.C_renamed.get(0).c_renamed();
    }

    protected android.graphics.Bitmap af_renamed() {
        return this.p_renamed.getOffAnimationIcon();
    }

    protected android.graphics.Bitmap ag_renamed() {
        return this.p_renamed.getOnAnimationIcon();
    }
}

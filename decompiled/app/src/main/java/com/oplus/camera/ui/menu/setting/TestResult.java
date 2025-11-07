package com.oplus.camera.ui.menu.setting;

/* compiled from: CameraMenuOptionFirstLevel.java */
/* loaded from: classes2.dex */
public class h_renamed extends com.oplus.camera.ui.menu.setting.CameraMenuOption implements android.view.View.OnClickListener, android.view.View.OnTouchListener, com.oplus.camera.u_renamed.a_renamed {
    private java.lang.String A_renamed;
    private java.lang.String B_renamed;
    private boolean C_renamed;
    private com.oplus.camera.ui.menu.i_renamed r_renamed;
    private java.lang.String s_renamed;
    private boolean t_renamed;
    private boolean u_renamed;
    private com.oplus.camera.ui.widget.c_renamed v_renamed;
    private java.lang.String w_renamed;
    private com.oplus.camera.ui.menu.b_renamed x_renamed;
    private boolean y_renamed;
    private android.view.ViewTreeObserver.OnGlobalLayoutListener z_renamed;

    @Override // com.oplus.camera.ui.menu.setting.CameraMenuOption
    public int z_renamed() {
        return 0;
    }

    public h_renamed(com.oplus.camera.ComboPreferences comboPreferences, android.content.Context context, com.oplus.camera.ui.menu.b_renamed bVar, com.oplus.camera.ui.menu.setting.i_renamed iVar, com.oplus.camera.ui.CameraUIListener cameraUIListener, int i_renamed, java.lang.String str, boolean z_renamed) {
        super(comboPreferences, context, bVar, iVar, cameraUIListener, i_renamed, str);
        this.r_renamed = null;
        this.s_renamed = null;
        this.t_renamed = false;
        this.u_renamed = false;
        this.v_renamed = null;
        this.w_renamed = null;
        this.x_renamed = null;
        this.y_renamed = false;
        this.z_renamed = null;
        this.A_renamed = null;
        this.B_renamed = null;
        this.C_renamed = false;
        this.x_renamed = bVar;
        this.f6559a = comboPreferences;
        this.t_renamed = z_renamed;
        this.u_renamed = false;
        ak_renamed();
    }

    @Override // com.oplus.camera.ui.menu.setting.CameraMenuOption
    public void b_renamed() {
        this.r_renamed = new com.oplus.camera.ui.menu.i_renamed(this.k_renamed, this.n_renamed, this.t_renamed, ag_renamed(), S_renamed(), this.u_renamed, this.f6559a);
        com.oplus.camera.ui.inverse.e_renamed.INS.registerInverse(this.k_renamed, this.r_renamed);
        this.r_renamed.setOnClickListener(this);
        this.r_renamed.setOnTouchListener(this);
        this.r_renamed.setSizeRatioType(this.j_renamed);
        this.r_renamed.setMenuName(this.s_renamed);
        this.r_renamed.setImageDrawable(Q_renamed());
        this.r_renamed.setForceDarkAllowed(false);
        this.r_renamed.setSwitchIconNeedAnim(this.x_renamed.getSwitchIconNeedAnim());
        this.r_renamed.setOffAnimIcon(af_renamed());
        this.r_renamed.setLottieIconNeedAnim(this.x_renamed.getLottieIconNeedAnim());
        this.r_renamed.setKey(a_renamed());
        this.z_renamed = new android.view.ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.oplus.camera.ui.menu.setting.h_renamed.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                if (com.oplus.camera.ui.menu.setting.h_renamed.this.r_renamed != null) {
                    com.oplus.camera.ui.menu.setting.h_renamed.this.r_renamed.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    com.oplus.camera.ui.menu.setting.h_renamed.this.y_renamed = true;
                }
            }
        };
        this.r_renamed.getViewTreeObserver().addOnGlobalLayoutListener(this.z_renamed);
        super.b_renamed();
    }

    @Override // com.oplus.camera.ui.menu.setting.CameraMenuOption
    public void M_renamed() {
        this.r_renamed.j_renamed();
    }

    @Override // com.oplus.camera.ui.menu.setting.CameraMenuOption
    public void a_renamed(java.lang.String str, com.oplus.camera.ui.menu.e_renamed eVar) {
        java.lang.String strD = com.oplus.camera.entry.b_renamed.d_renamed(str);
        if (com.oplus.camera.ui.CameraUIInterface.KEY_SETTING.equals(strD) || com.oplus.camera.ui.CameraUIInterface.KEY_SUB_SETTING.equals(strD) || com.oplus.camera.ui.CameraUIInterface.KEY_FLASH_MODE.equals(strD) || com.oplus.camera.ui.CameraUIInterface.KEY_RAW_CONTROL.equals(strD) || com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_FLASH_MODE.equals(strD) || com.oplus.camera.ui.CameraUIInterface.KEY_SUPER_RAW_CONTROL.equals(strD) || com.oplus.camera.ui.CameraUIInterface.KEY_STREET_FIX_FOCUS_CONTROL.equals(strD) || com.oplus.camera.ui.CameraUIInterface.KEY_PI_AI.equals(strD)) {
            this.r_renamed.setItemText(null);
            aj_renamed();
        }
        if (com.oplus.camera.ui.CameraUIInterface.KEY_MACRO_SWITCH.equals(str)) {
            this.r_renamed.setImageTintList(android.content.res.ColorStateList.valueOf(this.k_renamed.getColor(com.oplus.camera.R_renamed.color.color_white_with_full_percent_transparency)));
        }
    }

    private void ai_renamed() throws android.content.res.Resources.NotFoundException {
        int i_renamed;
        android.content.res.TypedArray typedArrayObtainTypedArray;
        if (com.oplus.camera.ui.CameraUIInterface.KEY_PHOTO_HIGH_RESOLUTION.equals(a_renamed())) {
            com.oplus.camera.e_renamed.a_renamed("CameraMenuOptionFirstLevel", "initDynamicIcons");
            if (android.text.TextUtils.isEmpty(com.oplus.camera.aps.config.CameraConfig.getConfigStringValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_SUPER_RESOLUTION_PICTURE_SIZE))) {
                int configIntValue = com.oplus.camera.aps.config.CameraConfig.getConfigIntValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_HIGH_PICTURE_SIZE_NAME, this.n_renamed.G_renamed()) / 100;
                double dA_renamed = configIntValue > 0 ? configIntValue : com.oplus.camera.util.Util.a_renamed(this.k_renamed, com.oplus.camera.aps.config.CameraConfig.getSizeConfigValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_HIGH_PICTURE_SIZE, this.n_renamed.G_renamed()));
                if (0.0d == dA_renamed) {
                    return;
                }
                this.w_renamed = this.k_renamed.getString(com.oplus.camera.R_renamed.string.camera_picture_size_standard_high_hint, java.lang.Double.valueOf(dA_renamed));
                i_renamed = (int) dA_renamed;
                if (com.oplus.camera.aps.config.CameraConfig.getSizeConfigValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_ULTRA_WIDE_HIGH_SUPPORTED_PICTURE_SIZE) != null && java.lang.Double.compare(dA_renamed, com.oplus.camera.util.Util.a_renamed(this.k_renamed, com.oplus.camera.aps.config.CameraConfig.getSizeConfigValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_ULTRA_WIDE_HIGH_SUPPORTED_PICTURE_SIZE, this.n_renamed.G_renamed()))) != 0) {
                    i_renamed = 0;
                }
            } else {
                i_renamed = -1;
            }
            if (44 == i_renamed) {
                typedArrayObtainTypedArray = this.k_renamed.getResources().obtainTypedArray(com.oplus.camera.R_renamed.array.high_resolution_icons_44M);
            } else if (48 == i_renamed) {
                typedArrayObtainTypedArray = this.k_renamed.getResources().obtainTypedArray(com.oplus.camera.R_renamed.array.high_resolution_icons_48M);
            } else if (50 == i_renamed) {
                typedArrayObtainTypedArray = this.k_renamed.getResources().obtainTypedArray(com.oplus.camera.R_renamed.array.high_resolution_icons_50M);
            } else if (64 == i_renamed) {
                typedArrayObtainTypedArray = this.k_renamed.getResources().obtainTypedArray(com.oplus.camera.R_renamed.array.high_resolution_icons_64M);
            } else if (i_renamed == 0) {
                typedArrayObtainTypedArray = this.k_renamed.getResources().obtainTypedArray(com.oplus.camera.R_renamed.array.high_resolution_icons_normal);
            } else {
                typedArrayObtainTypedArray = this.k_renamed.getResources().obtainTypedArray(com.oplus.camera.R_renamed.array.high_resolution_icons_48M);
            }
            if (typedArrayObtainTypedArray != null) {
                for (int i2 = 0; i2 < typedArrayObtainTypedArray.length(); i2++) {
                    if (ah_renamed() != null && ah_renamed().get(i2) != null) {
                        ah_renamed().get(i2).a_renamed(this.k_renamed.getDrawable(typedArrayObtainTypedArray.getResourceId(i2, -1)));
                    }
                }
                typedArrayObtainTypedArray.recycle();
            }
        }
    }

    @Override // com.oplus.camera.ui.menu.setting.CameraMenuOption
    protected void u_renamed() {
        super.u_renamed();
        if (this.l_renamed != null) {
            this.l_renamed.c_renamed(a_renamed());
        }
    }

    @Override // com.oplus.camera.ui.menu.setting.CameraMenuOption
    protected void v_renamed() {
        super.v_renamed();
        if (this.l_renamed != null) {
            this.l_renamed.d_renamed(a_renamed());
        }
    }

    public java.util.List<com.oplus.camera.ui.menu.e_renamed> ah_renamed() {
        com.oplus.camera.ui.menu.b_renamed bVar = this.x_renamed;
        if (bVar != null) {
            return bVar.getOptionItems();
        }
        return null;
    }

    @Override // com.oplus.camera.ui.menu.setting.CameraMenuOption
    public void a_renamed(boolean z_renamed, int i_renamed, int i2) {
        com.oplus.camera.ui.menu.i_renamed iVar = this.r_renamed;
        if (iVar != null) {
            iVar.a_renamed(z_renamed, i_renamed, i2);
        }
    }

    @Override // com.oplus.camera.ui.menu.setting.CameraMenuOption
    public void a_renamed(final java.lang.String str, java.lang.String str2, int i_renamed, int i2, final int i3) {
        if (str2 == null || str2.isEmpty()) {
            return;
        }
        com.oplus.camera.ui.widget.c_renamed cVar = this.v_renamed;
        if (cVar != null && cVar.isShowing() && android.text.TextUtils.equals(this.B_renamed, str2)) {
            return;
        }
        if (this.v_renamed != null) {
            w_renamed();
        }
        if (this.r_renamed != null) {
            this.v_renamed = new com.oplus.camera.ui.widget.c_renamed(this.k_renamed);
            this.v_renamed.a_renamed(true);
            this.v_renamed.setFocusable(false);
            this.v_renamed.a_renamed(str2);
            this.A_renamed = str;
            this.B_renamed = str2;
            com.oplus.camera.u_renamed.a_renamed().a_renamed(this);
            this.v_renamed.setTouchInterceptor(new android.view.View.OnTouchListener() { // from class: com.oplus.camera.ui.menu.setting.-$$Lambda$h_renamed$MJSc_ua70o1_bsxwP2T3O9fdz2s
                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(android.view.View view, android.view.MotionEvent motionEvent) {
                    return this.f_renamed$0.a_renamed(str, view, motionEvent);
                }
            });
            if (this.v_renamed.isShowing() || D_renamed()) {
                return;
            }
            try {
                this.v_renamed.a_renamed(i_renamed, i2);
                this.r_renamed.getViewTreeObserver().addOnPreDrawListener(new android.view.ViewTreeObserver.OnPreDrawListener() { // from class: com.oplus.camera.ui.menu.setting.h_renamed.2
                    @Override // android.view.ViewTreeObserver.OnPreDrawListener
                    public boolean onPreDraw() {
                        if (com.oplus.camera.ui.menu.setting.h_renamed.this.r_renamed == null || com.oplus.camera.ui.menu.setting.h_renamed.this.r_renamed.getWidth() <= 0) {
                            return false;
                        }
                        com.oplus.camera.ui.menu.setting.h_renamed.this.r_renamed.getViewTreeObserver().removeOnPreDrawListener(this);
                        if (com.oplus.camera.ui.menu.setting.h_renamed.this.v_renamed == null) {
                            return false;
                        }
                        com.oplus.camera.ui.menu.setting.h_renamed.this.v_renamed.a_renamed(com.oplus.camera.ui.menu.setting.h_renamed.this.r_renamed, i3);
                        return false;
                    }
                });
                this.r_renamed.invalidate();
            } catch (android.view.WindowManager.BadTokenException e_renamed) {
                com.oplus.camera.e_renamed.e_renamed("CameraMenuOptionFirstLevel", "showMenuOptionTipsBubble, exception: " + e_renamed.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean a_renamed(java.lang.String str, android.view.View view, android.view.MotionEvent motionEvent) {
        com.oplus.camera.e_renamed.a_renamed("CameraMenuOptionFirstLevel", "onTouch");
        w_renamed();
        if (this.f6559a != null && str != null) {
            android.content.SharedPreferences.Editor editorEdit = this.f6559a.edit();
            editorEdit.putBoolean(str, false);
            editorEdit.apply();
        }
        return false;
    }

    @Override // com.oplus.camera.ui.menu.setting.CameraMenuOption
    public void c_renamed(boolean z_renamed, boolean z2) {
        int iB;
        android.graphics.drawable.Drawable drawableA;
        if (this.r_renamed == null || a_renamed() == null || !com.oplus.camera.ui.CameraUIInterface.KEY_SUB_SETTING.equals(a_renamed())) {
            return;
        }
        if (z2) {
            this.i_renamed = z_renamed;
            return;
        }
        java.util.ArrayList<com.oplus.camera.ui.menu.e_renamed> arrayListY = Y_renamed();
        final android.graphics.drawable.Drawable drawable = null;
        int i_renamed = 0;
        for (int i2 = 0; i2 < arrayListY.size(); i2++) {
            com.oplus.camera.ui.menu.e_renamed eVar = arrayListY.get(i2);
            if ("on_renamed".equals(eVar.c_renamed()) && z_renamed) {
                iB = eVar.b_renamed();
                drawableA = eVar.a_renamed();
            } else if ("off".equals(eVar.c_renamed()) && !z_renamed) {
                iB = eVar.b_renamed();
                drawableA = eVar.a_renamed();
            }
            android.graphics.drawable.Drawable drawable2 = drawableA;
            i_renamed = iB;
            drawable = drawable2;
        }
        this.i_renamed = true;
        com.oplus.camera.util.b_renamed.a_renamed(this.k_renamed, this.r_renamed, i_renamed, new android.animation.Animator.AnimatorListener() { // from class: com.oplus.camera.ui.menu.setting.h_renamed.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(android.animation.Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(android.animation.Animator animator) {
                com.oplus.camera.ui.menu.setting.h_renamed.this.i_renamed = true;
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(android.animation.Animator animator) {
                com.oplus.camera.ui.menu.setting.h_renamed hVar = com.oplus.camera.ui.menu.setting.h_renamed.this;
                hVar.i_renamed = false;
                if (drawable != null) {
                    hVar.r_renamed.setImageDrawable(drawable);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(android.animation.Animator animator) throws android.content.res.Resources.NotFoundException {
                com.oplus.camera.ui.menu.setting.h_renamed hVar = com.oplus.camera.ui.menu.setting.h_renamed.this;
                hVar.i_renamed = false;
                hVar.q_renamed();
            }
        });
    }

    @Override // com.oplus.camera.ui.menu.setting.CameraMenuOption
    public void a_renamed(boolean z_renamed, boolean z2, int i_renamed) {
        com.oplus.camera.ui.menu.i_renamed iVar = this.r_renamed;
        if (iVar != null) {
            iVar.a_renamed(!z_renamed, z2, i_renamed);
        }
    }

    @Override // com.oplus.camera.ui.menu.setting.CameraMenuOption
    public void e_renamed(boolean z_renamed) {
        com.oplus.camera.ui.menu.i_renamed iVar = this.r_renamed;
        if (iVar != null) {
            iVar.setShadowOn(z_renamed);
        }
    }

    @Override // com.oplus.camera.ui.menu.setting.CameraMenuOption
    public boolean L_renamed() {
        com.oplus.camera.ui.menu.i_renamed iVar = this.r_renamed;
        if (iVar != null) {
            return iVar.getShadowOn();
        }
        return this.u_renamed;
    }

    @Override // com.oplus.camera.ui.menu.setting.CameraMenuOption
    public boolean e_renamed(java.lang.String str) {
        com.oplus.camera.ui.widget.c_renamed cVar = this.v_renamed;
        return cVar != null && cVar.isShowing();
    }

    @Override // com.oplus.camera.ui.menu.setting.CameraMenuOption
    public void w_renamed() {
        com.oplus.camera.ui.widget.c_renamed cVar = this.v_renamed;
        if (cVar != null) {
            if (cVar.isShowing()) {
                this.v_renamed.dismiss();
            }
            this.v_renamed = null;
        }
    }

    @Override // com.oplus.camera.ui.menu.setting.CameraMenuOption
    public void a_renamed(android.view.View view) {
        com.oplus.camera.ui.menu.i_renamed iVar = this.r_renamed;
        if (iVar != null && view == null && this.z_renamed != null) {
            iVar.getViewTreeObserver().removeOnGlobalLayoutListener(this.z_renamed);
        }
        this.r_renamed = (com.oplus.camera.ui.menu.i_renamed) view;
    }

    @Override // com.oplus.camera.ui.menu.setting.CameraMenuOption
    public android.view.View J_renamed() {
        return this.r_renamed;
    }

    @Override // com.oplus.camera.ui.menu.setting.CameraMenuOption
    public float K_renamed() {
        return this.r_renamed.getPivotYScaleValue();
    }

    @Override // com.oplus.camera.ui.menu.setting.CameraMenuOption
    public void b_renamed(boolean z_renamed) {
        aj_renamed();
        java.lang.String string = this.f6559a.getString(com.oplus.camera.ui.CameraUIInterface.KEY_SUB_SETTING, "off");
        if (this.f6560b != null) {
            this.f6560b.setDrawShadow(this.u_renamed && "off".equals(string));
        }
    }

    private void aj_renamed() {
        if (this.i_renamed) {
            return;
        }
        a_renamed(R_renamed(), S_renamed());
    }

    @Override // com.oplus.camera.ui.menu.setting.CameraMenuOption
    public void q_renamed() throws android.content.res.Resources.NotFoundException {
        this.u_renamed = L_renamed();
        ai_renamed();
        if (X_renamed() > 0) {
            if (aa_renamed() && R_renamed() != null && !android.text.TextUtils.isEmpty(V_renamed())) {
                aj_renamed();
                h_renamed(V_renamed());
            } else if (T_renamed() != null && F_renamed() == 1) {
                h_renamed((java.lang.String) null);
                a_renamed(T_renamed(), S_renamed());
            } else if (R_renamed() != null) {
                h_renamed((java.lang.String) null);
                aj_renamed();
            } else if (!android.text.TextUtils.isEmpty(V_renamed())) {
                h_renamed(V_renamed());
                a_renamed((android.graphics.drawable.Drawable) null, false);
            }
        } else {
            a_renamed((android.graphics.drawable.Drawable) null, false);
        }
        if (this.r_renamed != null) {
            if (a_renamed() != null && com.oplus.camera.ui.CameraUIInterface.KEY_SUB_SETTING.equals(a_renamed()) && !this.i_renamed) {
                this.r_renamed.setImageDrawable(Q_renamed());
            }
            this.r_renamed.invalidate();
            com.oplus.camera.ui.menu.i_renamed iVar = this.r_renamed;
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append(com.oplus.camera.ui.CameraUIInterface.KEY_PHOTO_HIGH_RESOLUTION.equals(a_renamed()) ? this.w_renamed : this.s_renamed);
            sb.append(U_renamed());
            iVar.setContentDescription(sb.toString());
        }
        if (ab_renamed()) {
            d_renamed(ad_renamed() != 0);
        }
    }

    @Override // com.oplus.camera.ui.menu.setting.CameraMenuOption
    public void r_renamed() throws android.content.res.Resources.NotFoundException {
        int iW = W_renamed();
        if (iW <= 0) {
            q_renamed();
        } else {
            com.oplus.camera.util.b_renamed.a_renamed(this.k_renamed, this.r_renamed, iW, new android.animation.Animator.AnimatorListener() { // from class: com.oplus.camera.ui.menu.setting.h_renamed.4
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(android.animation.Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(android.animation.Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(android.animation.Animator animator) throws android.content.res.Resources.NotFoundException {
                    com.oplus.camera.ui.menu.setting.h_renamed.this.q_renamed();
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(android.animation.Animator animator) throws android.content.res.Resources.NotFoundException {
                    com.oplus.camera.ui.menu.setting.h_renamed.this.q_renamed();
                }
            });
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(android.view.View view) throws android.content.res.Resources.NotFoundException {
        if (this.l_renamed != null) {
            com.oplus.camera.e_renamed.a_renamed("CameraMenuOptionFirstLevel", "onClick, Key: " + a_renamed());
            if (J_renamed() == null || J_renamed().isClickable()) {
                if (this.f_renamed) {
                    com.oplus.camera.e_renamed.a_renamed("CameraMenuOptionFirstLevel", "onClick, mbMenuItemRemoved: " + this.f_renamed);
                    return;
                }
                if (this.f6560b == null) {
                    k_renamed();
                }
                if (this.n_renamed != null && 1 == this.n_renamed.ca_renamed() && this.n_renamed.bS_renamed() && !com.oplus.camera.ui.CameraUIInterface.KEY_SUB_SETTING.equals(a_renamed())) {
                    this.n_renamed.bR_renamed();
                }
                int i_renamed = 0;
                if (this.f6560b != null) {
                    java.lang.String string = this.f6559a.getString(com.oplus.camera.ui.CameraUIInterface.KEY_SUB_SETTING, "off");
                    if (com.oplus.camera.util.Util.t_renamed()) {
                        o_renamed(string);
                    } else if (5 == this.j_renamed && "off".equals(string)) {
                        this.f6560b.b_renamed(false, false, 0);
                    } else {
                        this.f6560b.b_renamed(true, false, 0);
                    }
                }
                boolean zA = this.l_renamed.a_renamed(a_renamed(), false, false);
                com.oplus.camera.ui.menu.i_renamed iVar = this.r_renamed;
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append(com.oplus.camera.ui.CameraUIInterface.KEY_PHOTO_HIGH_RESOLUTION.equals(a_renamed()) ? this.w_renamed : this.s_renamed);
                sb.append(U_renamed());
                iVar.setContentDescription(sb.toString());
                if (!zA) {
                    com.oplus.camera.e_renamed.a_renamed("CameraMenuOptionFirstLevel", "onClick, onMenuButtonClick(Key): " + a_renamed() + " return false.");
                    a_renamed(1.0f);
                    return;
                }
                if (2 == ac_renamed()) {
                    return;
                }
                if (Z_renamed() || 2 == X_renamed()) {
                    int iX = X_renamed();
                    if (com.oplus.camera.ui.menu.g_renamed.a_renamed()) {
                        com.oplus.camera.ui.menu.g_renamed.d_renamed();
                    }
                    int i2 = this.o_renamed;
                    if (iX < 2) {
                        i_renamed = i2;
                    } else if (i2 < iX - 1) {
                        i_renamed = i2 + 1;
                    }
                    i_renamed(i_renamed);
                    if (!com.oplus.camera.ui.CameraUIInterface.KEY_FILTER_MENU.equals(a_renamed()) && !com.oplus.camera.ui.CameraUIInterface.KEY_SLOW_VIDEO_FRAME_SEEK_BAR_MENU.equals(a_renamed()) && !com.oplus.camera.ui.CameraUIInterface.KEY_MULTI_CAMERA_TYPE_MENU.equals(a_renamed()) && !com.oplus.camera.ui.CameraUIInterface.KEY_SUB_SETTING.equals(a_renamed())) {
                        r_renamed();
                    }
                } else if (h_renamed()) {
                    p_renamed();
                } else {
                    o_renamed();
                }
                a_renamed(1.0f);
            }
        }
    }

    private void o_renamed(java.lang.String str) {
        if (3 == this.n_renamed.ca_renamed()) {
            if ("off".equals(str) && (this.j_renamed == 0 || 1 == this.j_renamed)) {
                this.f6560b.b_renamed(false, false, 0);
                return;
            } else {
                this.f6560b.b_renamed(true, false, 0);
                return;
            }
        }
        if ("off".equals(str) && (5 == this.j_renamed || 1 == this.j_renamed)) {
            this.f6560b.b_renamed(false, false, 0);
        } else {
            this.f6560b.b_renamed(true, false, 0);
        }
    }

    @Override // com.oplus.camera.ui.menu.setting.CameraMenuOption
    public void a_renamed(android.view.ViewGroup viewGroup) {
        super.a_renamed(viewGroup);
        this.r_renamed.setContentDescription(this.s_renamed);
    }

    @Override // com.oplus.camera.ui.menu.setting.CameraMenuOption
    public int B_renamed() {
        com.oplus.camera.ui.menu.i_renamed iVar = this.r_renamed;
        if (iVar != null) {
            return iVar.getViewWidth();
        }
        return super.B_renamed();
    }

    @Override // com.oplus.camera.ui.menu.setting.CameraMenuOption
    public int C_renamed() {
        com.oplus.camera.ui.menu.i_renamed iVar = this.r_renamed;
        if (iVar != null) {
            return iVar.getViewHeight();
        }
        return super.C_renamed();
    }

    @Override // com.oplus.camera.ui.menu.setting.CameraMenuOption
    public void h_renamed(java.lang.String str) {
        com.oplus.camera.ui.menu.i_renamed iVar = this.r_renamed;
        if (iVar != null) {
            iVar.setItemText(str);
        }
    }

    @Override // com.oplus.camera.ui.menu.setting.CameraMenuOption
    public void y_renamed() {
        com.oplus.camera.ui.menu.i_renamed iVar = this.r_renamed;
        if (iVar != null) {
            iVar.setAnimation(com.oplus.camera.R_renamed.raw.camera_video_ai_option_guide_anim);
            this.r_renamed.a_renamed();
        }
    }

    @Override // com.oplus.camera.ui.menu.setting.CameraMenuOption
    public void a_renamed(android.graphics.drawable.Drawable drawable, boolean z_renamed) {
        com.oplus.camera.ui.menu.i_renamed iVar = this.r_renamed;
        if (iVar != null) {
            if (iVar.d_renamed() && !this.r_renamed.h_renamed()) {
                this.r_renamed.e_renamed();
                this.r_renamed.setProgress(0.0f);
            }
            this.r_renamed.a_renamed(drawable, z_renamed);
        }
    }

    @Override // com.oplus.camera.ui.menu.setting.CameraMenuOption
    public void a_renamed(int i_renamed, boolean z_renamed) {
        com.oplus.camera.ui.menu.i_renamed iVar = this.r_renamed;
        if (iVar != null) {
            iVar.a_renamed(i_renamed, z_renamed);
        }
        super.a_renamed(i_renamed, z_renamed);
    }

    @Override // com.oplus.camera.ui.menu.setting.CameraMenuOption
    protected void A_renamed() {
        com.oplus.camera.ui.menu.i_renamed iVar = this.r_renamed;
        if (iVar != null) {
            iVar.i_renamed();
            super.A_renamed();
            a_renamed((android.view.View) null);
        }
    }

    @Override // com.oplus.camera.ui.menu.setting.CameraMenuOption
    public void f_renamed() {
        com.oplus.camera.ui.menu.i_renamed iVar = this.r_renamed;
        if (iVar != null) {
            iVar.refreshDrawableState();
        }
    }

    @Override // com.oplus.camera.ui.menu.setting.CameraMenuOption
    public void f_renamed(int i_renamed) {
        super.f_renamed(i_renamed);
        com.oplus.camera.ui.menu.i_renamed iVar = this.r_renamed;
        if (iVar != null) {
            iVar.setSizeRatioType(this.j_renamed);
        }
    }

    public int n_renamed(java.lang.String str) {
        com.oplus.camera.ui.menu.b_renamed bVar;
        if (!android.text.TextUtils.isEmpty(str) && (bVar = this.x_renamed) != null && bVar.getOptionItems() != null && 1 <= this.x_renamed.getOptionItems().size()) {
            for (int i_renamed = 0; i_renamed < this.x_renamed.getOptionItems().size(); i_renamed++) {
                if (str.equals(this.x_renamed.getOptionItems().get(i_renamed).c_renamed())) {
                    return i_renamed;
                }
            }
        }
        return -1;
    }

    /* JADX WARN: Can't_renamed fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B_renamed:107:0x0198  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void ak_renamed() {
        /*
            Method dump skipped, instructions count: 1152
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.ui.menu.setting.h_renamed.ak_renamed():void");
    }

    @Override // com.oplus.camera.ui.menu.setting.CameraMenuOption
    public void d_renamed(boolean z_renamed) {
        com.oplus.camera.ui.menu.i_renamed iVar = this.r_renamed;
        if (iVar == null || !this.t_renamed) {
            return;
        }
        iVar.setSelected(z_renamed);
    }

    @Override // com.oplus.camera.u_renamed.a_renamed
    public void a_renamed(int i_renamed, android.view.KeyEvent keyEvent) {
        com.oplus.camera.e_renamed.a_renamed("CameraMenuOptionFirstLevel", "onKeyDown - keyCode: " + i_renamed);
        if (i_renamed == 24 || i_renamed == 25) {
            w_renamed();
            if (this.f6559a != null && this.A_renamed != null) {
                android.content.SharedPreferences.Editor editorEdit = this.f6559a.edit();
                editorEdit.putBoolean(this.A_renamed, false);
                editorEdit.apply();
            }
            com.oplus.camera.u_renamed.a_renamed().b_renamed(this);
        }
    }

    @Override // com.oplus.camera.ui.menu.setting.CameraMenuOption
    public void a_renamed(android.view.View view, android.view.MotionEvent motionEvent) {
        super.a_renamed(view, motionEvent);
        com.oplus.camera.e_renamed.b_renamed("CameraMenuOptionFirstLevel", "onTouchEvent, view: " + view);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(android.view.View view, android.view.MotionEvent motionEvent) {
        com.oplus.camera.e_renamed.b_renamed("CameraMenuOptionFirstLevel", "onTouch, view: " + view + ", mbSubMenu: " + this.t_renamed);
        if (!this.t_renamed) {
            android.graphics.Rect rect = new android.graphics.Rect();
            if (view instanceof com.oplus.camera.ui.menu.i_renamed) {
                rect = (android.graphics.Rect) view.getTag(com.oplus.camera.R_renamed.id_renamed.touch_area_tag);
            }
            int action = motionEvent.getAction();
            if (action == 0) {
                if (!rect.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
                    view.getDrawingRect(rect);
                    if (!rect.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
                        this.C_renamed = true;
                        return false;
                    }
                }
            } else if (action == 1 && this.C_renamed) {
                this.C_renamed = false;
                return false;
            }
        }
        super.a_renamed(view, motionEvent);
        return false;
    }
}

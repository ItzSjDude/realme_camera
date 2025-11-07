package com.oplus.camera.ui;

/* compiled from: CameraUIManager.java */
/* loaded from: classes2.dex */
public class d_renamed implements com.oplus.camera.d_renamed, com.oplus.camera.screen.b_renamed, com.oplus.camera.ui.CameraUIInterface, com.oplus.camera.ui.menu.setting.o_renamed.a_renamed, com.oplus.camera.ui.preview.g_renamed.b_renamed, com.oplus.camera.ui.widget.e_renamed.b_renamed {
    public static boolean g_renamed;
    public static boolean h_renamed;
    private com.oplus.camera.ui.preview.g_renamed A_renamed;
    private com.oplus.camera.ComboPreferences B_renamed;
    private com.oplus.camera.ui.menu.setting.o_renamed H_renamed;
    private com.oplus.camera.ui.menu.setting.f_renamed I_renamed;
    private com.oplus.camera.ui.CameraUIListener J_renamed;
    private boolean Y_renamed;
    private com.oplus.camera.ui.a_renamed.a_renamed ac_renamed;
    private com.oplus.camera.ui.camerascreenhint.CameraScreenHintView ae_renamed;
    private com.oplus.camera.ui.camerascreenhint.CameraScreenHintView af_renamed;
    private com.oplus.camera.ui.camerascreenhint.CameraScreenHintView ag_renamed;
    private com.oplus.camera.ui.menu.facebeauty.RotateAnimationView bM_renamed;
    private com.oplus.camera.ui.menu.facebeauty.RotateAnimationView bN_renamed;
    private com.oplus.camera.ui.menu.facebeauty.RotateAnimationView bO_renamed;
    private com.oplus.camera.timelapsepro.g_renamed bP_renamed;
    private com.oplus.camera.timelapsepro.f_renamed bQ_renamed;
    private com.oplus.camera.timelapsepro.i_renamed bR_renamed;
    private android.animation.AnimatorSet bS_renamed;
    private android.animation.AnimatorSet bT_renamed;
    private android.animation.AnimatorSet bU_renamed;
    private android.animation.AnimatorSet bV_renamed;
    private com.oplus.camera.screen.b_renamed.a_renamed bx_renamed;
    private android.view.View.OnClickListener cp_renamed;
    private android.app.Activity i_renamed;
    private com.oplus.camera.screen.a_renamed.c_renamed j_renamed;
    private com.oplus.camera.screen.a_renamed.b_renamed k_renamed;
    private com.oplus.camera.screen.g_renamed l_renamed;
    private int m_renamed;
    private com.oplus.camera.ui.b_renamed.a_renamed y_renamed;
    private com.oplus.camera.ui.control.a_renamed z_renamed;
    private boolean n_renamed = false;
    private boolean o_renamed = false;
    private boolean p_renamed = false;
    private boolean q_renamed = false;
    private boolean r_renamed = false;
    private boolean s_renamed = false;
    private boolean t_renamed = false;
    private boolean u_renamed = false;
    private boolean v_renamed = false;
    private boolean w_renamed = false;
    private boolean x_renamed = false;
    private com.oplus.camera.soloop.b_renamed C_renamed = null;
    private com.oplus.camera.ui.preview.ae_renamed D_renamed = null;
    private com.oplus.camera.ui.preview.i_renamed E_renamed = null;
    private com.oplus.camera.ui.preview.NightTimeView F_renamed = null;
    private com.oplus.camera.ui.preview.LongExposureTimeView G_renamed = null;
    private int K_renamed = 1;
    private int L_renamed = 0;
    private int M_renamed = 0;
    private int N_renamed = 0;
    private int O_renamed = 0;
    private int P_renamed = 0;
    private int Q_renamed = 0;
    private int R_renamed = -1;
    private int S_renamed = 0;
    private int T_renamed = 0;
    private long U_renamed = 0;
    private long V_renamed = 0;
    private long W_renamed = 0;
    private long X_renamed = 0;
    private android.view.ViewGroup Z_renamed = null;
    private android.view.View aa_renamed = null;
    private android.view.View ab_renamed = null;
    private com.oplus.camera.ui.a_renamed.a_renamed.HintManager_2 ad_renamed = null;
    private com.oplus.camera.ui.menu.levelcontrol.g_renamed ah_renamed = null;
    private com.oplus.camera.ui.menu.levelcontrol.c_renamed ai_renamed = null;
    private com.oplus.camera.ui.camerascreenhint.CameraScreenHintView aj_renamed = null;
    private com.oplus.camera.ui.menu.levelcontrol.r_renamed ak_renamed = null;
    private android.view.View al_renamed = null;
    private com.oplus.camera.ui.camerascreenhint.CameraScreenHintView am_renamed = null;
    private com.oplus.camera.ui.MicroscopeHintView an_renamed = null;
    private com.airbnb.lottie.LottieAnimationView ao_renamed = null;
    private com.airbnb.lottie.LottieAnimationView ap_renamed = null;
    private android.widget.ImageView aq_renamed = null;
    private com.coui.appcompat.widget.s_renamed ar_renamed = null;
    private com.oplus.camera.ui.widget.c_renamed as_renamed = null;
    private android.widget.PopupWindow at_renamed = null;
    private com.coui.appcompat.widget.s_renamed au_renamed = null;
    private android.widget.PopupWindow av_renamed = null;
    private com.oplus.camera.ui.widget.c_renamed aw_renamed = null;
    private com.oplus.camera.ui.widget.c_renamed ax_renamed = null;
    private com.oplus.camera.ui.widget.c_renamed ay_renamed = null;
    private com.coui.appcompat.widget.s_renamed az_renamed = null;
    private com.oplus.camera.ui.widget.c_renamed aA_renamed = null;
    private com.oplus.camera.ui.widget.c_renamed aB_renamed = null;
    private com.oplus.camera.ui.widget.c_renamed aC_renamed = null;
    private com.oplus.camera.ui.widget.c_renamed aD_renamed = null;
    private byte aE_renamed = 0;
    private java.util.Map<java.lang.String, java.util.concurrent.ConcurrentHashMap<java.lang.Integer, android.view.View>> aF_renamed = new java.util.HashMap();
    private java.util.Map<java.lang.String, com.oplus.camera.ui.menu.setting.q_renamed> aG_renamed = new java.util.HashMap();
    private com.oplus.camera.ui.preview.a_renamed aH_renamed = null;
    private com.oplus.camera.ui.preview.q_renamed aI_renamed = null;
    private com.oplus.camera.ui.modepanel.m_renamed aJ_renamed = null;
    private com.oplus.camera.ui.menu.setting.q_renamed aK_renamed = null;
    private com.oplus.camera.ui.widget.SplitBackgroundView aL_renamed = null;
    private com.oplus.camera.ui.widget.SplitBackgroundView aM_renamed = null;
    private android.view.View.OnClickListener aN_renamed = null;
    private int aO_renamed = 0;
    private int aP_renamed = 0;
    private com.oplus.camera.ui.menu.facebeauty.RotateAnimationView aQ_renamed = null;
    private android.view.TouchDelegate aR_renamed = null;
    private com.oplus.camera.ui.menu.levelcontrol.c_renamed aS_renamed = null;
    private com.oplus.camera.ui.menu.facebeauty.g_renamed aT_renamed = null;
    private android.animation.AnimatorSet aU_renamed = null;
    private android.animation.AnimatorSet aV_renamed = null;
    private android.animation.AnimatorSet aW_renamed = null;
    private android.animation.AnimatorSet aX_renamed = null;
    private android.animation.AnimatorSet aY_renamed = null;
    private android.animation.AnimatorSet aZ_renamed = null;
    private android.view.animation.PathInterpolator ba_renamed = new android.view.animation.PathInterpolator(0.33f, 0.0f, 0.67f, 1.0f);
    private android.view.animation.PathInterpolator bb_renamed = new android.view.animation.PathInterpolator(0.3f, 0.0f, 0.1f, 1.0f);
    private boolean bc_renamed = false;
    private com.oplus.camera.ui.modepanel.p_renamed bd_renamed = null;
    private boolean be_renamed = false;
    private int bf_renamed = 0;
    private com.oplus.camera.j_renamed.a_renamed bg_renamed = null;
    private com.oplus.camera.ui.widget.b_renamed bh_renamed = null;
    private android.util.Size bi_renamed = null;
    private boolean bj_renamed = false;
    private com.oplus.camera.ui.preview.b_renamed bk_renamed = null;
    private boolean bl_renamed = true;
    private boolean bm_renamed = true;
    private boolean bn_renamed = true;
    private boolean bo_renamed = false;
    private boolean bp_renamed = false;
    private boolean bq_renamed = true;
    private boolean br_renamed = true;
    private com.oplus.camera.doubleexposure.g_renamed bs_renamed = null;
    private com.oplus.camera.ui.modepanel.f_renamed bt_renamed = null;
    private int bu_renamed = 0;
    private int bv_renamed = 0;
    private boolean bw_renamed = false;
    private com.oplus.camera.ui.widget.SplitBackgroundView by_renamed = null;
    private com.oplus.camera.ui.OutScreenButtonBoxView bz_renamed = null;
    private com.oplus.camera.ui.menu.facebeauty.RotateAnimationView bA_renamed = null;
    private boolean bB_renamed = false;
    private boolean bC_renamed = false;
    private boolean bD_renamed = false;
    private boolean bE_renamed = false;
    private android.view.ViewGroup bF_renamed = null;
    private com.oplus.camera.ui.j_renamed bG_renamed = null;
    private com.oplus.camera.ui.k_renamed bH_renamed = null;
    private com.oplus.camera.ui.l_renamed bI_renamed = null;
    private androidx.viewpager2.widget.ViewPager2 bJ_renamed = null;
    private com.oplus.camera.ui.inverse.InverseTextView bK_renamed = null;
    private java.util.List<com.oplus.c_renamed.a_renamed.b_renamed.a_renamed> bL_renamed = new java.util.ArrayList();
    private int bW_renamed = 0;
    private int bX_renamed = 0;
    private boolean bY_renamed = false;
    private boolean bZ_renamed = false;
    private int ca_renamed = 0;
    private long cb_renamed = -1;
    private java.util.List<com.oplus.camera.ui.widget.SplitBackgroundView> cc_renamed = new java.util.ArrayList();
    private androidx.recyclerview.widget.RecyclerView.c_renamed cd_renamed = new androidx.recyclerview.widget.RecyclerView.c_renamed() { // from class: com.oplus.camera.ui.d_renamed.1
        @Override // androidx.recyclerview.widget.RecyclerView.c_renamed
        public void onChanged() {
            super.onChanged();
            int itemCount = com.oplus.camera.ui.d_renamed.this.bH_renamed.getItemCount();
            int i_renamed = itemCount == 0 ? 4 : 0;
            int i2 = itemCount == 0 ? 0 : 4;
            if (com.oplus.camera.ui.d_renamed.this.bG_renamed != null) {
                com.oplus.camera.ui.d_renamed.this.bG_renamed.setVisibility(i_renamed);
            }
            if (com.oplus.camera.ui.d_renamed.this.bK_renamed != null) {
                com.oplus.camera.ui.d_renamed.this.bK_renamed.setVisibility(i2);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.c_renamed
        public void onItemRangeChanged(int i_renamed, int i2) {
            super.onItemRangeChanged(i_renamed, i2);
            int itemCount = com.oplus.camera.ui.d_renamed.this.bH_renamed.getItemCount();
            int i3 = itemCount == 0 ? 4 : 0;
            int i4 = itemCount == 0 ? 0 : 4;
            if (com.oplus.camera.ui.d_renamed.this.bG_renamed != null) {
                com.oplus.camera.ui.d_renamed.this.bG_renamed.setVisibility(i3);
            }
            if (com.oplus.camera.ui.d_renamed.this.bK_renamed != null) {
                com.oplus.camera.ui.d_renamed.this.bK_renamed.setVisibility(i4);
            }
        }
    };
    private com.oplus.camera.timelapsepro.g_renamed.e_renamed ce_renamed = new com.oplus.camera.ui.d_renamed.ParameterContainer_4();
    private java.lang.Runnable cf_renamed = new java.lang.Runnable() { // from class: com.oplus.camera.ui.-$$Lambda$d_renamed$5JyfENlEQTRIbhQAMR65X0Nz7ks
        @Override // java.lang.Runnable
        public final void run() {
            this.f_renamed$0.gH_renamed();
        }
    };
    private com.oplus.camera.ui.preview.a_renamed.f_renamed cg_renamed = new com.oplus.camera.ui.preview.a_renamed.f_renamed() { // from class: com.oplus.camera.ui.d_renamed.22
        @Override // com.oplus.camera.ui.preview.a_renamed.f_renamed
        public void a_renamed(boolean z_renamed) {
            com.oplus.camera.e_renamed.a_renamed("CameraUIManager", "showFilterEffectMenu, needAni: " + z_renamed);
            com.oplus.camera.ui.d_renamed.this.ah_renamed.a_renamed();
            android.content.SharedPreferences.Editor editorEdit = com.oplus.camera.ui.d_renamed.this.B_renamed.edit();
            if (com.oplus.camera.ui.d_renamed.this.fF_renamed()) {
                editorEdit.putString(com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_SUPER_EIS_MENU, "off");
            }
            if (com.oplus.camera.ui.d_renamed.this.J_renamed != null) {
                java.lang.String strAE = com.oplus.camera.ui.d_renamed.this.J_renamed.aE_renamed();
                if (com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_FILTER_MENU.equals(strAE) || com.oplus.camera.ui.CameraUIInterface.KEY_PORTRAIT_NEW_STYLE_MENU.equals(strAE) || com.oplus.camera.ui.CameraUIInterface.KEY_NIGHT_FILTER_MENU.equals(strAE)) {
                    com.oplus.camera.ui.d_renamed.this.J_renamed.aW_renamed();
                }
                if (com.oplus.camera.ui.d_renamed.this.J_renamed.h_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_SUPPORT_GRAND_TOUR_FILTERS) && com.oplus.camera.ui.preview.a_renamed.j_renamed.g_renamed() && !com.oplus.camera.e_renamed.a_renamed.a_renamed(com.oplus.camera.ui.d_renamed.this.cv_renamed())) {
                    editorEdit.putBoolean(com.oplus.camera.ui.CameraUIInterface.PRE_FACE_BEAUTY_ICON_RECEOMMEND_CLICKED, true);
                }
            }
            editorEdit.apply();
        }

        @Override // com.oplus.camera.ui.preview.a_renamed.f_renamed
        public void b_renamed(boolean z_renamed) {
            if (com.oplus.camera.ui.d_renamed.this.ah_renamed != null) {
                com.oplus.camera.ui.d_renamed.this.ah_renamed.a_renamed(z_renamed);
            }
        }

        @Override // com.oplus.camera.ui.preview.a_renamed.f_renamed
        public void c_renamed(boolean z_renamed) {
            if (com.oplus.camera.ui.d_renamed.this.ah_renamed != null) {
                com.oplus.camera.ui.d_renamed.this.ah_renamed.b_renamed(z_renamed);
            }
        }

        @Override // com.oplus.camera.ui.preview.a_renamed.f_renamed
        public void a_renamed(int i_renamed) {
            if (com.oplus.camera.ui.d_renamed.this.ah_renamed != null) {
                com.oplus.camera.ui.d_renamed.this.ah_renamed.setBeautyShowDelay(i_renamed);
            }
        }

        @Override // com.oplus.camera.ui.preview.a_renamed.f_renamed
        public void a_renamed() {
            if (com.oplus.camera.ui.d_renamed.this.J_renamed != null) {
                com.oplus.camera.ui.d_renamed.this.J_renamed.j_renamed(false);
            }
        }

        @Override // com.oplus.camera.ui.preview.a_renamed.f_renamed
        public boolean b_renamed() {
            if (com.oplus.camera.ui.d_renamed.this.ah_renamed != null) {
                return com.oplus.camera.ui.d_renamed.this.ah_renamed.isAnimationRunning() || com.oplus.camera.ui.d_renamed.this.ah_renamed.h_renamed();
            }
            return false;
        }
    };
    private com.oplus.camera.ui.preview.a_renamed.p_renamed ch_renamed = new com.oplus.camera.ui.preview.a_renamed.p_renamed() { // from class: com.oplus.camera.ui.d_renamed.32
        @Override // com.oplus.camera.ui.preview.a_renamed.p_renamed
        public void a_renamed(java.util.ArrayList<com.oplus.camera.sticker.ui.h_renamed.b_renamed> arrayList, int i_renamed, com.oplus.camera.sticker.data.StickerItem stickerItem, boolean z_renamed) {
        }

        @Override // com.oplus.camera.ui.preview.a_renamed.p_renamed
        public void a_renamed(com.oplus.camera.ui.menu.levelcontrol.i_renamed iVar) {
            com.oplus.camera.e_renamed.a_renamed("CameraUIManager", "imageReady");
            if (com.oplus.camera.ui.d_renamed.this.ah_renamed == null || com.oplus.camera.ui.d_renamed.this.p_renamed) {
                return;
            }
            com.oplus.camera.ui.d_renamed.this.ah_renamed.a_renamed(iVar);
        }
    };
    private com.oplus.camera.ui.preview.a_renamed.AISceneUI_2 ci_renamed = new com.oplus.camera.ui.preview.a_renamed.AISceneUI_2() { // from class: com.oplus.camera.ui.d_renamed.43
        @Override // com.oplus.camera.ui.preview.a_renamed.AISceneUI_2
        public void a_renamed(int i_renamed, boolean z_renamed, boolean z2) {
            com.oplus.camera.e_renamed.a_renamed("CameraUIManager", "setPIEnable, code: " + i_renamed + ", enbalbe: " + z_renamed + ", changeByClick: " + z2);
            if (12 == i_renamed) {
                com.oplus.camera.ui.d_renamed.this.s_renamed = true;
                com.oplus.camera.ui.d_renamed.this.P_renamed = 0;
                if (com.oplus.camera.ui.d_renamed.this.cm_renamed != null) {
                    com.oplus.camera.ui.d_renamed.this.cm_renamed.removeMessages(1);
                }
            }
            if (com.oplus.camera.ui.d_renamed.this.J_renamed != null) {
                com.oplus.camera.ui.d_renamed.this.J_renamed.a_renamed(i_renamed, z_renamed, z2);
            }
        }

        @Override // com.oplus.camera.ui.preview.a_renamed.AISceneUI_2
        public void a_renamed() {
            com.oplus.camera.ui.d_renamed.this.ac_renamed.a_renamed(com.oplus.camera.ui.d_renamed.this.O_renamed);
        }

        @Override // com.oplus.camera.ui.preview.a_renamed.AISceneUI_2
        public void b_renamed() {
            com.oplus.camera.ui.d_renamed.this.ac_renamed.e_renamed();
        }

        @Override // com.oplus.camera.ui.preview.a_renamed.AISceneUI_2
        public void a_renamed(int i_renamed) {
            if (com.oplus.camera.ui.d_renamed.this.J_renamed == null || com.oplus.camera.ui.d_renamed.this.J_renamed.t_renamed()) {
                if (i_renamed == 12) {
                    com.oplus.camera.ui.d_renamed.this.s_renamed = true;
                    com.oplus.camera.ui.d_renamed.this.P_renamed = 0;
                    if (com.oplus.camera.ui.d_renamed.this.cm_renamed != null) {
                        com.oplus.camera.ui.d_renamed.this.cm_renamed.removeMessages(1);
                    }
                    com.oplus.camera.ui.d_renamed.this.fC_renamed();
                }
                if (com.oplus.camera.ui.d_renamed.this.J_renamed != null) {
                    com.oplus.camera.ui.d_renamed.this.J_renamed.c_renamed(i_renamed);
                    return;
                }
                return;
            }
            com.oplus.camera.e_renamed.f_renamed("CameraUIManager", "onAISceneClosed, canRespondTouch is_renamed false!");
        }

        @Override // com.oplus.camera.ui.preview.a_renamed.AISceneUI_2
        public void b_renamed(int i_renamed) {
            a_renamed(com.oplus.camera.ui.d_renamed.this.aH_renamed != null && com.oplus.camera.ui.d_renamed.this.aH_renamed.i_renamed());
        }

        private void a_renamed(boolean z_renamed) {
            if (com.oplus.camera.ui.d_renamed.this.B_renamed == null || "on_renamed".equals(com.oplus.camera.ui.d_renamed.this.B_renamed.getString(com.oplus.camera.ui.CameraUIInterface.KEY_SUB_SETTING, "off")) || com.oplus.camera.ui.d_renamed.this.J_renamed == null || com.oplus.camera.ui.d_renamed.this.J_renamed.aQ_renamed() || z_renamed) {
                return;
            }
            com.oplus.camera.ui.d_renamed.this.J_renamed.aM_renamed();
        }
    };
    private com.oplus.camera.ui.camerascreenhint.c_renamed cj_renamed = new com.oplus.camera.ui.camerascreenhint.c_renamed() { // from class: com.oplus.camera.ui.d_renamed.54
        @Override // com.oplus.camera.ui.camerascreenhint.c_renamed
        public void a_renamed(int i_renamed) {
            if (com.oplus.camera.ui.d_renamed.this.aH_renamed != null) {
                com.oplus.camera.ui.d_renamed.this.aH_renamed.a_renamed(i_renamed == 0, com.oplus.camera.ui.d_renamed.this.j_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_AI_SCN));
            }
        }

        @Override // com.oplus.camera.ui.camerascreenhint.c_renamed
        public int a_renamed() {
            if (com.oplus.camera.ui.d_renamed.this.J_renamed != null) {
                return com.oplus.camera.ui.d_renamed.this.J_renamed.n_renamed();
            }
            return 0;
        }
    };
    private com.oplus.camera.ui.camerascreenhint.b_renamed ck_renamed = new com.oplus.camera.ui.camerascreenhint.b_renamed() { // from class: com.oplus.camera.ui.d_renamed.65
        @Override // com.oplus.camera.ui.camerascreenhint.b_renamed
        public boolean a_renamed() {
            if (com.oplus.camera.ui.d_renamed.this.J_renamed != null) {
                return com.oplus.camera.ui.d_renamed.this.J_renamed.bB_renamed();
            }
            return false;
        }
    };
    private android.view.View.OnLayoutChangeListener cl_renamed = new android.view.View.OnLayoutChangeListener() { // from class: com.oplus.camera.ui.d_renamed.75
        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(android.view.View view, int i_renamed, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            if (com.oplus.camera.ui.d_renamed.this.ci_renamed != null) {
                if (com.oplus.camera.ui.d_renamed.this.aH_renamed.c_renamed()) {
                    com.oplus.camera.ui.d_renamed.this.ci_renamed.b_renamed(i3 - i_renamed);
                } else {
                    com.oplus.camera.ui.d_renamed.this.ci_renamed.b_renamed(0);
                }
            }
        }
    };
    private android.os.Handler cm_renamed = new android.os.Handler(android.os.Looper.getMainLooper()) { // from class: com.oplus.camera.ui.d_renamed.79
        @Override // android.os.Handler
        public void handleMessage(android.os.Message message) {
            com.oplus.camera.e_renamed.a_renamed("CameraUIManager", "handleMessage, msg: " + message.what);
            switch (message.what) {
                case 1:
                    if (!com.oplus.camera.ui.d_renamed.this.p_renamed && com.oplus.camera.ui.d_renamed.this.aH_renamed != null && com.oplus.camera.ui.d_renamed.this.J_renamed != null && com.oplus.camera.ui.d_renamed.this.J_renamed.h_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_SUPPORT_NIGHT_PROCESS)) {
                        com.oplus.camera.ui.d_renamed.this.P_renamed = 2;
                        com.oplus.camera.ui.d_renamed dVar = com.oplus.camera.ui.d_renamed.this;
                        dVar.m_renamed(dVar.O_renamed);
                        break;
                    }
                    break;
                case 2:
                    if (message.obj != null && com.oplus.camera.ui.d_renamed.this.aH_renamed != null && !com.oplus.camera.ui.d_renamed.this.o_renamed) {
                        int iIntValue = ((java.lang.Integer) message.obj).intValue();
                        com.oplus.camera.ui.d_renamed.this.aH_renamed.b_renamed(iIntValue);
                        if (!com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_PI_AI)) {
                            com.oplus.camera.ui.d_renamed.this.ah_renamed(iIntValue);
                        } else if (com.oplus.camera.ui.d_renamed.this.dH_renamed()) {
                            com.oplus.camera.ui.d_renamed.this.cm_renamed.obtainMessage(2, java.lang.Integer.valueOf(iIntValue)).sendToTarget();
                        } else if (!com.oplus.camera.ui.d_renamed.this.T_renamed()) {
                            com.oplus.camera.ui.d_renamed.this.ai_renamed(iIntValue);
                        }
                        com.oplus.camera.ui.d_renamed.this.O_renamed = iIntValue;
                        break;
                    }
                    break;
                case 3:
                    com.oplus.camera.ui.d_renamed.this.cS_renamed();
                    break;
                case 4:
                    com.oplus.camera.ui.d_renamed.this.et_renamed();
                    break;
                case 5:
                    if (com.oplus.camera.ui.d_renamed.this.bk_renamed != null && com.oplus.camera.ui.d_renamed.this.bk_renamed.b_renamed()) {
                        com.oplus.camera.ui.d_renamed.this.l_renamed(true);
                    }
                    com.oplus.camera.ui.d_renamed.this.U_renamed(1);
                    break;
                case 6:
                    com.oplus.camera.ui.d_renamed.this.bl_renamed = false;
                    com.oplus.camera.ui.d_renamed.this.l_renamed(true);
                    if (!com.oplus.camera.ui.d_renamed.this.w_renamed) {
                        if (com.oplus.camera.ui.d_renamed.this.J_renamed != null) {
                            com.oplus.camera.ui.d_renamed.this.J_renamed.a_renamed(com.oplus.camera.ui.d_renamed.this.bk_renamed.a_renamed(), false);
                            break;
                        }
                    } else {
                        com.oplus.camera.ui.d_renamed.this.w_renamed = false;
                        break;
                    }
                    break;
                case 7:
                    com.oplus.camera.ui.d_renamed.this.ao_renamed.a_renamed();
                    break;
                case 8:
                    if (com.oplus.camera.ui.d_renamed.this.ao_renamed != null && com.oplus.camera.ui.d_renamed.this.cm_renamed != null) {
                        com.oplus.camera.ui.d_renamed.this.ao_renamed.e_renamed();
                        com.oplus.camera.ui.d_renamed.this.ao_renamed.setProgress(0.0f);
                        com.oplus.camera.ui.d_renamed.this.ao_renamed.setVisibility(8);
                        com.oplus.camera.ui.d_renamed.this.cm_renamed.removeCallbacksAndMessages(null);
                        break;
                    }
                    break;
                case 9:
                    if (com.oplus.camera.ui.d_renamed.this.bk_renamed != null && com.oplus.camera.ui.d_renamed.this.bk_renamed.b_renamed()) {
                        com.oplus.camera.ui.d_renamed.this.l_renamed(true);
                    }
                    com.oplus.camera.ui.d_renamed.this.U_renamed(0);
                    break;
                case 10:
                    com.oplus.camera.ui.d_renamed.this.bm_renamed = false;
                    com.oplus.camera.ui.d_renamed.this.l_renamed(true);
                    if (!com.oplus.camera.ui.d_renamed.this.w_renamed) {
                        if (com.oplus.camera.ui.d_renamed.this.J_renamed != null) {
                            com.oplus.camera.ui.d_renamed.this.J_renamed.a_renamed(com.oplus.camera.ui.d_renamed.this.bk_renamed.a_renamed(), false);
                            break;
                        }
                    } else {
                        com.oplus.camera.ui.d_renamed.this.w_renamed = false;
                        break;
                    }
                    break;
                case 11:
                    if (com.oplus.camera.ui.d_renamed.this.bk_renamed != null && com.oplus.camera.ui.d_renamed.this.bk_renamed.b_renamed()) {
                        com.oplus.camera.ui.d_renamed.this.l_renamed(true);
                    }
                    com.oplus.camera.ui.d_renamed.this.U_renamed(2);
                    break;
                case 12:
                    com.oplus.camera.ui.d_renamed.this.bn_renamed = false;
                    com.oplus.camera.ui.d_renamed.this.l_renamed(true);
                    break;
                case 13:
                    com.oplus.camera.ui.d_renamed.this.i_renamed(true);
                    break;
                case 14:
                    if (com.oplus.camera.ui.d_renamed.this.ap_renamed != null) {
                        com.oplus.camera.ui.d_renamed.this.ap_renamed.setVisibility(0);
                        com.oplus.camera.ui.d_renamed.this.ap_renamed.a_renamed();
                        break;
                    }
                    break;
                case 15:
                    if (com.oplus.camera.ui.d_renamed.this.ap_renamed != null && com.oplus.camera.ui.d_renamed.this.cm_renamed != null) {
                        com.oplus.camera.ui.d_renamed.this.ap_renamed.e_renamed();
                        com.oplus.camera.ui.d_renamed.this.ap_renamed.setProgress(0.0f);
                        com.oplus.camera.ui.d_renamed.this.ap_renamed.setVisibility(8);
                        com.oplus.camera.ui.d_renamed.this.cm_renamed.removeMessages(14);
                        break;
                    }
                    break;
            }
        }
    };
    private com.oplus.camera.ui.modepanel.h_renamed cn_renamed = new com.oplus.camera.ui.modepanel.h_renamed() { // from class: com.oplus.camera.ui.d_renamed.2
        @Override // com.oplus.camera.ui.modepanel.h_renamed
        public void a_renamed(boolean z_renamed) {
            com.oplus.camera.ui.d_renamed.this.aL_renamed(z_renamed);
        }

        @Override // com.oplus.camera.ui.modepanel.h_renamed
        public void a_renamed() {
            com.oplus.camera.ui.d_renamed.this.eF_renamed();
        }
    };

    /* renamed from: co_renamed, reason: collision with root package name */
    private android.view.View.OnClickListener f6083co = new android.view.View.OnClickListener() { // from class: com.oplus.camera.ui.d_renamed.3
        @Override // android.view.View.OnClickListener
        public void onClick(android.view.View view) {
            java.lang.String strAF;
            if (com.oplus.camera.ui.d_renamed.this.J_renamed == null || !(com.oplus.camera.ui.d_renamed.this.J_renamed.am_renamed() || com.oplus.camera.ui.d_renamed.this.J_renamed.ah_renamed() || com.oplus.camera.ui.d_renamed.this.J_renamed.ai_renamed() || com.oplus.camera.ui.d_renamed.this.J_renamed.bx_renamed())) {
                if (com.oplus.camera.ui.d_renamed.this.bK_renamed() && com.oplus.camera.util.Util.u_renamed()) {
                    com.oplus.camera.ui.d_renamed.this.cw_renamed();
                }
                if (com.oplus.camera.ui.d_renamed.this.J_renamed != null && com.oplus.camera.ui.d_renamed.this.J_renamed.h_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_MULTI_CAMERA_TYPE_MENU)) {
                    boolean zEquals = "on_renamed".equals(com.oplus.camera.ui.d_renamed.this.B_renamed.getString(com.oplus.camera.ui.CameraUIInterface.KEY_MULTI_CAMERA_TYPE_MENU, com.oplus.camera.ui.d_renamed.this.i_renamed.getString(com.oplus.camera.R_renamed.string.camera_multicamera_type_default)));
                    android.content.SharedPreferences.Editor editorEdit = com.oplus.camera.ui.d_renamed.this.B_renamed.edit();
                    if (!zEquals) {
                        editorEdit.putString(com.oplus.camera.ui.CameraUIInterface.KEY_MULTI_CAMERA_TYPE_MENU_NEED_SHOW_ZOOM, "on_renamed");
                    }
                    editorEdit.putString(com.oplus.camera.ui.CameraUIInterface.KEY_MULTI_CAMERA_TYPE_MENU, zEquals ? "off" : "on_renamed").apply();
                }
                if (com.oplus.camera.ui.d_renamed.this.J_renamed == null || !com.oplus.camera.ui.d_renamed.this.J_renamed.h_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_STREET_LONG_EXPOSURE_MENU)) {
                    if (com.oplus.camera.ui.d_renamed.this.cy_renamed.g_renamed()) {
                        if (com.oplus.camera.ui.d_renamed.this.ai_renamed != null && !com.oplus.camera.ui.d_renamed.this.ai_renamed.isMenuOpen() && com.oplus.camera.ui.d_renamed.this.I_renamed != null && com.oplus.camera.ui.d_renamed.this.I_renamed.c_renamed()) {
                            com.oplus.camera.ui.d_renamed.this.I_renamed.a_renamed(8);
                        }
                        strAF = com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_BLUR_MENU;
                    } else if (com.oplus.camera.ui.d_renamed.this.cy_renamed.h_renamed()) {
                        strAF = com.oplus.camera.ui.CameraUIInterface.KEY_TILT_SHIFT_BLUR_MENU;
                    } else {
                        strAF = com.oplus.camera.ui.d_renamed.this.cy_renamed.b_renamed() ? com.oplus.camera.ui.d_renamed.this.J_renamed.aF_renamed() : "";
                    }
                    com.oplus.camera.ui.d_renamed.this.J_renamed.a_renamed(strAF, false, false);
                    return;
                }
                if (androidx.preference.j_renamed.a_renamed(com.oplus.camera.ui.d_renamed.this.i_renamed).getBoolean("street_long_exposure_reddot_show", true)) {
                    androidx.preference.j_renamed.a_renamed(com.oplus.camera.ui.d_renamed.this.i_renamed).edit().putBoolean("street_long_exposure_reddot_show", false).apply();
                }
                if (com.oplus.camera.ui.d_renamed.this.B_renamed != null) {
                    com.oplus.camera.ui.d_renamed.this.B_renamed.edit().putBoolean(com.oplus.camera.ui.CameraUIInterface.KEY_STREET_LONG_EXPOSURE_MENU, !com.oplus.camera.ui.d_renamed.this.B_renamed.getBoolean(com.oplus.camera.ui.CameraUIInterface.KEY_STREET_LONG_EXPOSURE_MENU, true)).apply();
                }
            }
        }
    };
    private final android.view.View.OnClickListener cq_renamed = new android.view.View.OnClickListener() { // from class: com.oplus.camera.ui.d_renamed.4
        @Override // android.view.View.OnClickListener
        public void onClick(android.view.View view) throws android.content.res.Resources.NotFoundException {
            int id_renamed = view.getId();
            if (id_renamed == com.oplus.camera.R_renamed.id_renamed.time_lapse_pro_setting_button) {
                if (!com.oplus.camera.ui.d_renamed.this.ex_renamed() || com.oplus.camera.ui.d_renamed.this.bP_renamed.c_renamed()) {
                    if (com.oplus.camera.ui.d_renamed.this.cp_renamed != null) {
                        com.oplus.camera.ui.d_renamed.this.cp_renamed.onClick(view);
                        return;
                    }
                    return;
                } else {
                    com.oplus.camera.ui.d_renamed.this.bP_renamed.o_renamed();
                    com.oplus.camera.ui.d_renamed.this.Q_renamed(true);
                    com.oplus.camera.ui.d_renamed dVar = com.oplus.camera.ui.d_renamed.this;
                    dVar.d_renamed(false, true, dVar.bP_renamed.c_renamed());
                    return;
                }
            }
            if (id_renamed != com.oplus.camera.R_renamed.id_renamed.time_lapse_pro_template_button) {
                return;
            }
            if (!com.oplus.camera.ui.d_renamed.this.ex_renamed() || !com.oplus.camera.ui.d_renamed.this.bP_renamed.c_renamed()) {
                if (com.oplus.camera.ui.d_renamed.this.cp_renamed != null) {
                    com.oplus.camera.ui.d_renamed.this.cp_renamed.onClick(view);
                }
            } else {
                com.oplus.camera.ui.d_renamed.this.bP_renamed.o_renamed();
                com.oplus.camera.ui.d_renamed.this.Q_renamed(true);
                com.oplus.camera.ui.d_renamed dVar2 = com.oplus.camera.ui.d_renamed.this;
                dVar2.d_renamed(false, true, dVar2.bP_renamed.c_renamed());
            }
        }
    };
    private android.view.View.OnClickListener cr_renamed = new android.view.View.OnClickListener() { // from class: com.oplus.camera.ui.d_renamed.5
        @Override // android.view.View.OnClickListener
        public void onClick(android.view.View view) {
            if (com.oplus.camera.ui.d_renamed.this.l_renamed != null) {
                if (com.oplus.camera.ui.d_renamed.this.J_renamed != null) {
                    com.oplus.camera.ui.d_renamed.this.J_renamed.f_renamed(88, 3 == com.oplus.camera.ui.d_renamed.this.aX_renamed() ? 2 : 1);
                }
                com.oplus.camera.ui.d_renamed.this.l_renamed.h_renamed();
            }
        }
    };
    private com.oplus.camera.screen.a_renamed.b_renamed.OutCaptureManager_2 cs_renamed = new com.oplus.camera.screen.a_renamed.b_renamed.OutCaptureManager_2() { // from class: com.oplus.camera.ui.d_renamed.6
        @Override // com.oplus.camera.screen.a_renamed.b_renamed.OutCaptureManager_2
        public void a_renamed(boolean z_renamed) {
            if (com.oplus.camera.ui.d_renamed.this.z_renamed != null) {
                if (com.oplus.camera.ui.d_renamed.this.dH_renamed()) {
                    if (com.oplus.camera.ui.d_renamed.this.z_renamed.aw_renamed() && com.oplus.camera.ui.d_renamed.this.z_renamed.ax_renamed()) {
                        com.oplus.camera.ui.d_renamed.this.cn_renamed.a_renamed();
                    }
                    com.oplus.camera.ui.d_renamed.this.aj_renamed(-1);
                }
                if (z_renamed) {
                    com.oplus.camera.ui.d_renamed.this.z_renamed.ao_renamed();
                } else {
                    com.oplus.camera.ui.d_renamed.this.z_renamed.a_renamed(com.oplus.camera.ui.d_renamed.this.cv_renamed(), com.oplus.camera.ui.d_renamed.this.aV_renamed());
                }
                com.oplus.camera.ui.d_renamed.this.z_renamed.l_renamed(z_renamed);
            }
            if (com.oplus.camera.ui.d_renamed.this.J_renamed != null) {
                com.oplus.camera.ui.d_renamed.this.bU_renamed();
                if (com.oplus.camera.ui.d_renamed.this.J_renamed.L_renamed()) {
                    com.oplus.camera.ui.d_renamed.this.J_renamed.M_renamed();
                }
                if (com.oplus.camera.ui.d_renamed.this.J_renamed.c_renamed()) {
                    com.oplus.camera.ui.d_renamed.this.J_renamed.e_renamed();
                }
            }
            if (!z_renamed && com.oplus.camera.ui.d_renamed.this.J_renamed != null) {
                com.oplus.camera.ui.d_renamed.this.J_renamed.bZ_renamed();
            }
            if (com.oplus.camera.ui.d_renamed.this.aT_renamed != null && com.oplus.camera.ui.d_renamed.this.aT_renamed.n_renamed()) {
                com.oplus.camera.ui.d_renamed.this.a_renamed(true, true, true, true);
                com.oplus.camera.ui.d_renamed.this.J_renamed.aK_renamed();
            }
            com.oplus.camera.ui.d_renamed.this.i_renamed();
        }

        @Override // com.oplus.camera.screen.a_renamed.b_renamed.OutCaptureManager_2
        public void a_renamed() {
            com.oplus.camera.ui.d_renamed.this.k_renamed.a_renamed(com.oplus.camera.ui.d_renamed.this.i_renamed, com.oplus.camera.ui.d_renamed.this.cs_renamed);
        }
    };
    private com.oplus.camera.screen.a_renamed.c_renamed.b_renamed ct_renamed = new com.oplus.camera.screen.a_renamed.c_renamed.b_renamed() { // from class: com.oplus.camera.ui.d_renamed.7
        @Override // com.oplus.camera.screen.a_renamed.c_renamed.b_renamed
        public void a_renamed(com.oplus.camera.screen.out.e_renamed eVar) {
            com.oplus.camera.ui.d_renamed.this.c_renamed().a_renamed(eVar);
            com.oplus.camera.ui.d_renamed.this.A_renamed.a_renamed(eVar);
            com.oplus.camera.ui.d_renamed.this.bz_renamed.setHighLight(true);
            com.oplus.camera.ui.d_renamed.this.ac_renamed.a_renamed(com.oplus.camera.R_renamed.string.camera_out_small_preview_enable, false, true, 5500, com.oplus.camera.R_renamed.drawable.screen_hint_textview_bg, com.oplus.camera.R_renamed.color.screen_hint_text_color, 0, false, false, false, -1, new java.lang.Object[0]);
            com.oplus.camera.ui.d_renamed.this.dm_renamed();
        }

        @Override // com.oplus.camera.screen.a_renamed.c_renamed.b_renamed
        public void b_renamed(com.oplus.camera.screen.out.e_renamed eVar) {
            com.oplus.camera.ui.d_renamed.this.c_renamed().a_renamed((com.oplus.camera.screen.out.e_renamed) null);
            com.oplus.camera.ui.d_renamed.this.A_renamed.a_renamed((com.oplus.camera.screen.out.e_renamed) null);
            com.oplus.camera.ui.d_renamed.this.bz_renamed.setHighLight(false);
            com.oplus.camera.ui.d_renamed.this.ac_renamed.a_renamed(com.oplus.camera.R_renamed.string.camera_out_small_preview_enable);
            com.oplus.camera.ui.d_renamed.this.j_renamed.c_renamed();
        }

        @Override // com.oplus.camera.screen.a_renamed.c_renamed.b_renamed
        public void a_renamed() {
            com.oplus.camera.ui.d_renamed.this.j_renamed.a_renamed(false);
            com.oplus.camera.ui.d_renamed.this.k_renamed.a_renamed(com.oplus.camera.ui.d_renamed.this.i_renamed, com.oplus.camera.ui.d_renamed.this.cs_renamed);
            com.oplus.camera.ui.d_renamed.this.J_renamed.a_renamed(71, "1");
        }

        @Override // com.oplus.camera.screen.a_renamed.c_renamed.b_renamed
        public void b_renamed() {
            if (com.oplus.camera.ui.d_renamed.this.J_renamed != null) {
                com.oplus.camera.ui.d_renamed.this.J_renamed.b_renamed(com.oplus.camera.statistics.model.ReminderMsgData.TYPE_DISABLE_CODE, com.oplus.camera.statistics.model.ReminderMsgData.CODE_CAMERA_HIGH_TEMPERATURE_OUT_PREVIEW_DISABLE);
            }
        }

        @Override // com.oplus.camera.screen.a_renamed.c_renamed.b_renamed
        public boolean a_renamed(int i_renamed, android.view.KeyEvent keyEvent) {
            return com.oplus.camera.ui.d_renamed.this.J_renamed.a_renamed(i_renamed, keyEvent);
        }

        @Override // com.oplus.camera.screen.a_renamed.c_renamed.b_renamed
        public boolean b_renamed(int i_renamed, android.view.KeyEvent keyEvent) {
            return com.oplus.camera.ui.d_renamed.this.J_renamed.b_renamed(i_renamed, keyEvent);
        }

        @Override // com.oplus.camera.screen.a_renamed.c_renamed.b_renamed
        public void c_renamed() {
            com.oplus.camera.ui.d_renamed.this.k_renamed.a_renamed();
        }
    };
    private android.view.View.OnClickListener cu_renamed = new android.view.View.OnClickListener() { // from class: com.oplus.camera.ui.-$$Lambda$d_renamed$rbzU_YuH03OjYyj20G982ZAoT9I
        @Override // android.view.View.OnClickListener
        public final void onClick(android.view.View view) {
            this.f_renamed$0.a_renamed(view);
        }
    };
    private android.view.View.OnClickListener cv_renamed = new android.view.View.OnClickListener() { // from class: com.oplus.camera.ui.d_renamed.8
        @Override // android.view.View.OnClickListener
        public void onClick(android.view.View view) {
            com.oplus.camera.e_renamed.a_renamed("CameraUIManager", "mFaceBeautyEnterButtonListener, onClick");
            com.oplus.camera.ui.d_renamed.this.f_renamed(17, true);
            com.oplus.camera.ui.d_renamed.this.f_renamed(20, true);
            if (com.oplus.camera.ui.d_renamed.this.J_renamed != null && 1 == com.oplus.camera.ui.d_renamed.this.J_renamed.Z_renamed() && com.oplus.camera.ui.d_renamed.this.z_renamed.ac_renamed()) {
                com.oplus.camera.ui.d_renamed.this.z_renamed.ad_renamed();
            }
            if (com.oplus.camera.ui.d_renamed.this.bK_renamed() && com.oplus.camera.util.Util.u_renamed()) {
                com.oplus.camera.ui.d_renamed.this.cw_renamed();
            }
            if (com.oplus.camera.ui.d_renamed.this.aA_renamed() || com.oplus.camera.ui.d_renamed.this.ew_renamed()) {
                com.oplus.camera.e_renamed.a_renamed("CameraUIManager", "mFaceBeautyEnterButtonListener, onClick, MultiCameraTypeLayout is_renamed Visible");
                return;
            }
            if (!com.oplus.camera.ui.d_renamed.this.ec_renamed()) {
                com.oplus.camera.e_renamed.a_renamed("CameraUIManager", "mFaceBeautyEnterButtonListener, onClick, preview not started");
                return;
            }
            if (com.oplus.camera.ui.d_renamed.this.dF_renamed()) {
                com.oplus.camera.e_renamed.a_renamed("CameraUIManager", "mFaceBeautyEnterButtonListener, onClick, isHeadlineScrolling: true");
                return;
            }
            if (com.oplus.camera.ui.d_renamed.this.dN_renamed()) {
                com.oplus.camera.e_renamed.a_renamed("CameraUIManager", "mFaceBeautyEnterButtonListener, onClick, isMoreModePanelAnimRunning: true");
                return;
            }
            if (com.oplus.camera.ui.d_renamed.this.R_renamed()) {
                com.oplus.camera.e_renamed.a_renamed("CameraUIManager", "mFaceBeautyEnterButtonListener, onClick, isMoreModeShown: true");
                return;
            }
            if (!com.oplus.camera.ui.d_renamed.this.ec_renamed()) {
                com.oplus.camera.e_renamed.a_renamed("CameraUIManager", "mFaceBeautyEnterButtonListener, onClick, isPreviewStarted: false");
                return;
            }
            if (!com.oplus.camera.ui.d_renamed.this.O_renamed()) {
                if (com.oplus.camera.ui.d_renamed.this.J_renamed == null || !com.oplus.camera.ui.d_renamed.this.J_renamed.L_renamed()) {
                    if (com.oplus.camera.ui.d_renamed.this.J_renamed == null || !com.oplus.camera.ui.d_renamed.this.J_renamed.ah_renamed()) {
                        if (com.oplus.camera.ui.d_renamed.this.aT_renamed != null && !com.oplus.camera.ui.d_renamed.this.aT_renamed.m_renamed() && !com.oplus.camera.ui.d_renamed.this.ah_renamed.isAnimationRunning() && !com.oplus.camera.ui.d_renamed.this.ai_renamed.isAnimationRunning() && (com.oplus.camera.ui.d_renamed.this.aS_renamed == null || !com.oplus.camera.ui.d_renamed.this.aS_renamed.isAnimationRunning())) {
                            if (!com.oplus.camera.ui.d_renamed.this.aT_renamed.n_renamed()) {
                                if (com.oplus.camera.ui.d_renamed.this.bk_renamed != null && com.oplus.camera.ui.d_renamed.this.bk_renamed.b_renamed() && ((10 == com.oplus.camera.ui.d_renamed.this.Q_renamed || 16 == com.oplus.camera.ui.d_renamed.this.Q_renamed) && 2 == com.oplus.camera.ui.d_renamed.this.bk_renamed.a_renamed())) {
                                    com.oplus.camera.ui.d_renamed.this.cm_renamed.sendEmptyMessage(12);
                                }
                                if (com.oplus.camera.ui.d_renamed.this.aT_renamed.b_renamed() == 3 || com.oplus.camera.ui.d_renamed.this.J_renamed.aJ_renamed()) {
                                    com.oplus.camera.ui.d_renamed.this.u_renamed(true);
                                }
                                if (com.oplus.camera.ui.d_renamed.this.I_renamed != null && com.oplus.camera.ui.d_renamed.this.I_renamed.c_renamed()) {
                                    com.oplus.camera.ui.d_renamed.this.I_renamed.a_renamed(8);
                                }
                                com.oplus.camera.ui.d_renamed.this.aI_renamed(true);
                                return;
                            }
                            com.oplus.camera.ui.d_renamed.this.a_renamed(true, true, true, true);
                            com.oplus.camera.ui.d_renamed.this.J_renamed.aK_renamed();
                            com.oplus.camera.ui.d_renamed.this.aI_renamed(false);
                            return;
                        }
                        com.oplus.camera.e_renamed.e_renamed("CameraUIManager", "mFaceBeautyEnterButtonListener, onClick, return");
                        return;
                    }
                    com.oplus.camera.e_renamed.a_renamed("CameraUIManager", "mFaceBeautyEnterButtonListener, onClick, isZoomMenuExpand: true");
                    return;
                }
                com.oplus.camera.e_renamed.a_renamed("CameraUIManager", "mFaceBeautyEnterButtonListener, onClick, isTimerSnapShotRunning: true");
                return;
            }
            com.oplus.camera.e_renamed.a_renamed("CameraUIManager", "mFaceBeautyEnterButtonListener, onClick, isBlurMenuOpen: true");
        }
    };
    private com.oplus.camera.ui.menu.facebeauty.g_renamed.a_renamed cw_renamed = new com.oplus.camera.ui.menu.facebeauty.g_renamed.a_renamed() { // from class: com.oplus.camera.ui.d_renamed.9
        @Override // com.oplus.camera.ui.menu.facebeauty.g_renamed.a_renamed
        public void a_renamed() {
            com.oplus.camera.ui.d_renamed.this.J_renamed.resetFaceBeautyValues();
        }

        @Override // com.oplus.camera.ui.menu.facebeauty.g_renamed.a_renamed
        public int b_renamed() {
            return com.oplus.camera.ui.d_renamed.this.J_renamed.aa_renamed();
        }

        @Override // com.oplus.camera.ui.menu.facebeauty.g_renamed.a_renamed
        public int a_renamed(int i_renamed) {
            return com.oplus.camera.ui.d_renamed.this.J_renamed.getFaceBeautyItemValue(i_renamed);
        }

        @Override // com.oplus.camera.ui.menu.facebeauty.g_renamed.a_renamed
        public void b_renamed(int i_renamed) {
            com.oplus.camera.ui.d_renamed.this.J_renamed.onFaceBeautyItemChange(i_renamed);
        }

        @Override // com.oplus.camera.ui.menu.facebeauty.g_renamed.a_renamed
        public void a_renamed(android.view.View view) {
            if (com.oplus.camera.ui.d_renamed.this.B_renamed.getBoolean(com.oplus.camera.ui.CameraUIInterface.KEY_BUBBLE_TYPE_CUSTOM_FACE_BEAUTY_CLOSE, true)) {
                com.oplus.camera.ui.d_renamed.this.a_renamed(view, 8, 0, 0);
            } else {
                com.oplus.camera.ui.d_renamed.this.f_renamed(8, false);
            }
        }

        @Override // com.oplus.camera.ui.menu.facebeauty.g_renamed.a_renamed
        public void a_renamed(int i_renamed, int i2, boolean z_renamed) {
            if (com.oplus.camera.ui.d_renamed.this.J_renamed == null) {
                return;
            }
            com.oplus.camera.ui.d_renamed.this.J_renamed.onFaceBeautyItemValueChange(i_renamed, i2, z_renamed);
            g_renamed();
            if (!com.oplus.camera.ui.d_renamed.this.u_renamed || 40 == i2) {
                return;
            }
            com.oplus.camera.ui.d_renamed.this.fv_renamed();
        }

        @Override // com.oplus.camera.ui.menu.facebeauty.g_renamed.a_renamed
        public boolean c_renamed() {
            return com.oplus.camera.ui.d_renamed.this.J_renamed.t_renamed();
        }

        @Override // com.oplus.camera.ui.menu.facebeauty.g_renamed.a_renamed
        public int d_renamed() {
            return com.oplus.camera.ui.d_renamed.this.J_renamed.ab_renamed();
        }

        @Override // com.oplus.camera.ui.menu.facebeauty.g_renamed.a_renamed
        public int[] e_renamed() {
            return com.oplus.camera.ui.d_renamed.this.J_renamed.ac_renamed();
        }

        @Override // com.oplus.camera.ui.menu.facebeauty.g_renamed.a_renamed
        public int[] f_renamed() {
            return com.oplus.camera.ui.d_renamed.this.J_renamed.ad_renamed();
        }

        @Override // com.oplus.camera.ui.menu.facebeauty.g_renamed.a_renamed
        public int c_renamed(int i_renamed) {
            return com.oplus.camera.ui.d_renamed.this.J_renamed.e_renamed(i_renamed);
        }

        @Override // com.oplus.camera.ui.menu.facebeauty.g_renamed.a_renamed
        public void g_renamed() {
            com.oplus.camera.ui.d_renamed.this.fg_renamed();
        }

        @Override // com.oplus.camera.ui.menu.facebeauty.g_renamed.a_renamed
        public void d_renamed(int i_renamed) {
            if (com.oplus.camera.ui.d_renamed.this.B_renamed != null) {
                com.oplus.camera.ui.d_renamed.this.B_renamed.edit().putInt(com.oplus.camera.ui.CameraUIInterface.KEY_FACE_BEAUTY_LAST_TAB_INDEX, i_renamed).apply();
            }
        }

        @Override // com.oplus.camera.ui.menu.facebeauty.g_renamed.a_renamed
        public int h_renamed() {
            if (com.oplus.camera.ui.d_renamed.this.B_renamed != null) {
                return com.oplus.camera.ui.d_renamed.this.B_renamed.getInt(com.oplus.camera.ui.CameraUIInterface.KEY_FACE_BEAUTY_LAST_TAB_INDEX, 0);
            }
            return 0;
        }
    };
    private com.oplus.camera.ui.menu.levelcontrol.g_renamed.a_renamed cx_renamed = new com.oplus.camera.ui.menu.levelcontrol.g_renamed.a_renamed() { // from class: com.oplus.camera.ui.d_renamed.10
        @Override // com.oplus.camera.ui.menu.levelcontrol.g_renamed.a_renamed
        public void a_renamed() {
            if (com.oplus.camera.ui.d_renamed.this.J_renamed != null) {
                com.oplus.camera.ui.d_renamed.this.J_renamed.o_renamed();
            }
        }

        @Override // com.oplus.camera.ui.menu.levelcontrol.g_renamed.a_renamed
        public void a_renamed(com.oplus.camera.ui.menu.levelcontrol.j_renamed jVar) {
            if (com.oplus.camera.ui.d_renamed.this.A_renamed != null) {
                com.oplus.camera.ui.d_renamed.this.A_renamed.a_renamed(jVar);
            }
        }

        @Override // com.oplus.camera.ui.menu.levelcontrol.g_renamed.a_renamed
        public void a_renamed(boolean z_renamed) {
            if (com.oplus.camera.ui.d_renamed.this.J_renamed != null) {
                com.oplus.camera.ui.d_renamed.this.J_renamed.a_renamed(z_renamed);
            }
        }

        @Override // com.oplus.camera.ui.menu.levelcontrol.g_renamed.a_renamed
        public void a_renamed(int i_renamed, boolean z_renamed) {
            if (com.oplus.camera.ui.d_renamed.this.J_renamed != null) {
                com.oplus.camera.ui.d_renamed.this.J_renamed.onEffectItemChange(i_renamed, z_renamed, true);
                if (!com.oplus.camera.ui.d_renamed.this.J_renamed.h_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_SUPPORT_GRAND_TOUR_FILTERS) || com.oplus.camera.e_renamed.a_renamed.a_renamed(com.oplus.camera.ui.d_renamed.this.cv_renamed()) || !com.oplus.camera.ui.preview.a_renamed.j_renamed.a_renamed(i_renamed) || com.oplus.camera.ui.d_renamed.this.B_renamed.getBoolean(com.oplus.camera.ui.CameraUIInterface.PRE_FACE_BEAUTY_FILTER_ICON_RECEOMMEND_CLICKED, false)) {
                    return;
                }
                com.oplus.camera.ui.d_renamed.this.B_renamed.edit().putBoolean(com.oplus.camera.ui.CameraUIInterface.PRE_FACE_BEAUTY_FILTER_ICON_RECEOMMEND_CLICKED, true).apply();
                com.oplus.camera.ui.d_renamed.this.aT_renamed.g_renamed();
            }
        }

        @Override // com.oplus.camera.ui.menu.levelcontrol.g_renamed.a_renamed
        public boolean a_renamed(int i_renamed) {
            if (com.oplus.camera.ui.d_renamed.this.J_renamed != null) {
                return com.oplus.camera.ui.d_renamed.this.J_renamed.b_renamed(i_renamed);
            }
            return false;
        }

        @Override // com.oplus.camera.ui.menu.levelcontrol.g_renamed.a_renamed
        public boolean b_renamed() {
            if (com.oplus.camera.ui.d_renamed.this.J_renamed != null) {
                return com.oplus.camera.ui.d_renamed.this.J_renamed.t_renamed();
            }
            return false;
        }

        @Override // com.oplus.camera.ui.menu.levelcontrol.g_renamed.a_renamed
        public void a_renamed(java.lang.String str) {
            if (com.oplus.camera.ui.d_renamed.this.J_renamed != null) {
                com.oplus.camera.ui.d_renamed.this.J_renamed.c_renamed(str);
            }
        }

        @Override // com.oplus.camera.ui.menu.levelcontrol.g_renamed.a_renamed
        public void b_renamed(java.lang.String str) {
            if (com.oplus.camera.ui.d_renamed.this.J_renamed != null) {
                com.oplus.camera.ui.d_renamed.this.J_renamed.d_renamed(str);
            }
        }

        @Override // com.oplus.camera.ui.menu.levelcontrol.g_renamed.a_renamed
        public boolean c_renamed() {
            if (com.oplus.camera.ui.d_renamed.this.J_renamed != null) {
                return com.oplus.camera.ui.d_renamed.this.J_renamed.x_renamed();
            }
            return false;
        }

        @Override // com.oplus.camera.ui.menu.levelcontrol.g_renamed.a_renamed
        public boolean d_renamed() {
            return !com.oplus.camera.ui.d_renamed.this.B_renamed();
        }

        @Override // com.oplus.camera.ui.menu.levelcontrol.g_renamed.a_renamed
        public int e_renamed() {
            if (com.oplus.camera.ui.d_renamed.this.J_renamed != null) {
                return com.oplus.camera.ui.d_renamed.this.J_renamed.v_renamed();
            }
            return 0;
        }

        @Override // com.oplus.camera.ui.menu.levelcontrol.g_renamed.a_renamed
        public int f_renamed() {
            if (com.oplus.camera.ui.d_renamed.this.Z_renamed != null) {
                return com.oplus.camera.ui.d_renamed.this.Z_renamed.indexOfChild(com.oplus.camera.ui.d_renamed.this.z_renamed.U_renamed()) + 1;
            }
            return -1;
        }

        @Override // com.oplus.camera.ui.menu.levelcontrol.g_renamed.a_renamed
        public boolean g_renamed() {
            return com.oplus.camera.ui.d_renamed.this.e_renamed();
        }
    };
    private com.oplus.camera.ui.menu.levelcontrol.c_renamed.a_renamed cy_renamed = new com.oplus.camera.ui.menu.levelcontrol.c_renamed.a_renamed() { // from class: com.oplus.camera.ui.d_renamed.11
        @Override // com.oplus.camera.ui.menu.levelcontrol.c_renamed.a_renamed
        public boolean a_renamed() {
            return !com.oplus.camera.ui.d_renamed.this.B_renamed();
        }

        @Override // com.oplus.camera.ui.menu.levelcontrol.c_renamed.a_renamed
        public boolean b_renamed() {
            return com.oplus.camera.ui.d_renamed.this.J_renamed.aN_renamed();
        }

        @Override // com.oplus.camera.ui.menu.levelcontrol.c_renamed.a_renamed
        public void a_renamed(boolean z_renamed, boolean z2, boolean z3) {
            if (com.oplus.camera.ui.d_renamed.this.J_renamed != null && z2) {
                if (!com.oplus.camera.ui.d_renamed.this.J_renamed.aN_renamed()) {
                    com.oplus.camera.ui.d_renamed.this.J_renamed.aH_renamed();
                }
                com.oplus.camera.ui.d_renamed.this.J_renamed.a_renamed(z_renamed);
            }
            if (1 == com.oplus.camera.ui.d_renamed.this.aX_renamed()) {
                com.oplus.camera.ui.d_renamed.this.w_renamed(true, z3);
                com.oplus.camera.ui.d_renamed.this.A_renamed(false, z3);
            } else if (4 == com.oplus.camera.ui.d_renamed.this.aX_renamed() && !com.oplus.camera.ui.d_renamed.this.aw_renamed()) {
                com.oplus.camera.ui.d_renamed.this.g_renamed(0);
            }
            if (com.oplus.camera.ui.d_renamed.this.J_renamed == null || com.oplus.camera.ui.d_renamed.this.o_renamed) {
                return;
            }
            com.oplus.camera.ui.d_renamed.this.J_renamed.aH_renamed();
        }

        @Override // com.oplus.camera.ui.menu.levelcontrol.c_renamed.a_renamed
        public void c_renamed() {
            if (com.oplus.camera.ui.d_renamed.this.J_renamed == null || com.oplus.camera.ui.d_renamed.this.o_renamed) {
                return;
            }
            com.oplus.camera.ui.d_renamed.this.J_renamed.aH_renamed();
        }

        @Override // com.oplus.camera.ui.menu.levelcontrol.c_renamed.a_renamed
        public void d_renamed() {
            if (1 == com.oplus.camera.ui.d_renamed.this.aX_renamed()) {
                com.oplus.camera.ui.d_renamed.this.w_renamed(false, true);
                com.oplus.camera.ui.d_renamed.this.A_renamed(true, true);
                if (com.oplus.camera.ui.d_renamed.this.I_renamed == null || !com.oplus.camera.ui.d_renamed.this.I_renamed.c_renamed()) {
                    return;
                }
                com.oplus.camera.ui.d_renamed.this.I_renamed.a_renamed(8);
                return;
            }
            if (4 == com.oplus.camera.ui.d_renamed.this.aX_renamed()) {
                com.oplus.camera.ui.d_renamed.this.g_renamed(8);
            }
        }

        @Override // com.oplus.camera.ui.menu.levelcontrol.c_renamed.a_renamed
        public void e_renamed() {
            if (com.oplus.camera.ui.d_renamed.this.J_renamed != null) {
                com.oplus.camera.ui.d_renamed.this.J_renamed.aG_renamed();
            }
        }

        @Override // com.oplus.camera.ui.menu.levelcontrol.c_renamed.a_renamed
        public void a_renamed(int i_renamed, boolean z_renamed) {
            com.oplus.camera.ui.d_renamed.this.J_renamed.setBlurIndex(i_renamed, z_renamed);
        }

        @Override // com.oplus.camera.ui.menu.levelcontrol.c_renamed.a_renamed
        public void a_renamed(boolean z_renamed, boolean z2) {
            com.oplus.camera.e_renamed.a_renamed("CameraUIManager", "mBlurMenuListener, onBlurStateChange, isBlurOpen: " + z_renamed);
            if (com.oplus.camera.ui.d_renamed.this.J_renamed.B_renamed()) {
                return;
            }
            com.oplus.camera.ui.d_renamed.this.J_renamed.a_renamed(z_renamed, z2);
            com.oplus.camera.ui.d_renamed.this.H_renamed.b_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_BLUR_MENU, z_renamed);
            com.oplus.camera.ui.d_renamed.this.S_renamed(z_renamed);
        }

        @Override // com.oplus.camera.ui.menu.levelcontrol.c_renamed.a_renamed
        public int f_renamed() {
            return com.oplus.camera.ui.d_renamed.this.J_renamed.aL_renamed();
        }

        @Override // com.oplus.camera.ui.menu.levelcontrol.c_renamed.a_renamed
        public boolean g_renamed() {
            return (com.oplus.camera.ui.d_renamed.this.J_renamed.B_renamed() || h_renamed()) ? false : true;
        }

        @Override // com.oplus.camera.ui.menu.levelcontrol.c_renamed.a_renamed
        public boolean h_renamed() {
            return com.oplus.camera.ui.d_renamed.this.J_renamed.aO_renamed();
        }

        @Override // com.oplus.camera.ui.menu.levelcontrol.c_renamed.a_renamed
        public boolean i_renamed() {
            return com.oplus.camera.ui.d_renamed.this.J_renamed.c_renamed();
        }

        @Override // com.oplus.camera.ui.menu.levelcontrol.c_renamed.a_renamed
        public boolean j_renamed() {
            return com.oplus.camera.ui.d_renamed.this.j_renamed(com.oplus.camera.aps.config.CameraFunction.SAT_CAMERA);
        }

        @Override // com.oplus.camera.ui.menu.levelcontrol.c_renamed.a_renamed
        public void k_renamed() {
            com.oplus.camera.ui.d_renamed.this.J_renamed.g_renamed(0);
        }

        @Override // com.oplus.camera.ui.menu.levelcontrol.c_renamed.a_renamed
        public int l_renamed() {
            return com.oplus.camera.ui.d_renamed.this.J_renamed.bO_renamed();
        }

        @Override // com.oplus.camera.ui.menu.levelcontrol.c_renamed.a_renamed
        public int m_renamed() {
            return com.oplus.camera.ui.d_renamed.this.J_renamed.G_renamed();
        }

        @Override // com.oplus.camera.ui.menu.levelcontrol.c_renamed.a_renamed
        public com.oplus.camera.ui.a_renamed.a_renamed n_renamed() {
            return com.oplus.camera.ui.d_renamed.this.ac_renamed;
        }
    };
    private com.oplus.camera.ui.menu.setting.q_renamed.b_renamed cz_renamed = new com.oplus.camera.ui.menu.setting.q_renamed.b_renamed() { // from class: com.oplus.camera.ui.d_renamed.59
        @Override // com.oplus.camera.ui.menu.setting.q_renamed.b_renamed
        public void a_renamed(java.lang.String str) throws android.content.res.Resources.NotFoundException {
            com.oplus.camera.e_renamed.a_renamed("CameraUIManager", "onExpandMenuShow, key: " + str);
            com.oplus.camera.ui.d_renamed.this.s_renamed(str);
            if (!com.oplus.camera.ui.d_renamed.this.dp_renamed() || !com.oplus.camera.ui.d_renamed.this.fh_renamed()) {
                if (com.oplus.camera.ui.d_renamed.this.z_renamed != null && 1 != com.oplus.camera.ui.d_renamed.this.aX_renamed() && (!com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_BLUR_MENU.equals(str) || !com.oplus.camera.ui.d_renamed.this.h_renamed())) {
                    com.oplus.camera.ui.d_renamed.this.z_renamed.h_renamed();
                }
            } else {
                com.oplus.camera.ui.d_renamed.this.c_renamed(true, 0);
            }
            if (com.oplus.camera.ui.d_renamed.this.J_renamed != null) {
                com.oplus.camera.ui.d_renamed.this.J_renamed.q_renamed();
            }
            if (4 != com.oplus.camera.ui.d_renamed.this.aX_renamed()) {
                com.oplus.camera.ui.d_renamed.this.j_renamed(true, true);
                com.oplus.camera.ui.d_renamed.this.h_renamed(true, true);
            }
            com.oplus.camera.ui.d_renamed.this.f_renamed(17, true);
            com.oplus.camera.ui.d_renamed.this.f_renamed(20, true);
            if (com.oplus.camera.ui.d_renamed.this.J_renamed != null) {
                java.lang.String strAE = com.oplus.camera.ui.d_renamed.this.J_renamed.aE_renamed();
                if (android.text.TextUtils.equals(strAE, str)) {
                    com.oplus.camera.ui.d_renamed.this.a_renamed(true, str);
                }
                if (android.text.TextUtils.equals(strAE, str.concat("_from_other_app"))) {
                    com.oplus.camera.ui.d_renamed.this.a_renamed(true, strAE);
                }
            }
        }

        @Override // com.oplus.camera.ui.menu.setting.q_renamed.b_renamed
        public void a_renamed(java.lang.String str, boolean z_renamed, boolean z2) throws android.content.res.Resources.NotFoundException {
            if (com.oplus.camera.ui.d_renamed.this.J_renamed != null) {
                java.lang.String strAE = com.oplus.camera.ui.d_renamed.this.J_renamed.aE_renamed();
                if (android.text.TextUtils.equals(strAE, str)) {
                    com.oplus.camera.ui.d_renamed.this.a_renamed(false, str);
                } else if (android.text.TextUtils.equals(strAE, str.concat("_from_other_app"))) {
                    com.oplus.camera.ui.d_renamed.this.a_renamed(false, strAE);
                } else {
                    com.oplus.camera.ui.d_renamed.this.g_renamed(str, true);
                }
            }
            if (com.oplus.camera.ui.d_renamed.this.fh_renamed()) {
                if (com.oplus.camera.ui.d_renamed.this.J_renamed != null && !com.oplus.camera.ui.d_renamed.this.J_renamed.L_renamed() && z_renamed && !z2) {
                    com.oplus.camera.ui.d_renamed.this.b_renamed(true, 0);
                }
            } else if (com.oplus.camera.ui.d_renamed.this.z_renamed != null && z_renamed && !z2 && 1 != com.oplus.camera.ui.d_renamed.this.aX_renamed()) {
                com.oplus.camera.ui.d_renamed.this.z_renamed.b_renamed(true, true);
            }
            if (z2) {
                return;
            }
            if (com.oplus.camera.ui.d_renamed.this.J_renamed != null && ((!com.oplus.camera.util.Util.u_renamed() || !com.oplus.camera.ui.d_renamed.this.J_renamed.bV_renamed()) && com.oplus.camera.ui.d_renamed.this.J_renamed.bl_renamed())) {
                com.oplus.camera.ui.d_renamed.this.l_renamed(true, true);
            }
            if (com.oplus.camera.ui.d_renamed.this.J_renamed != null) {
                if ((com.oplus.camera.util.Util.u_renamed() && com.oplus.camera.ui.d_renamed.this.J_renamed.bV_renamed()) || !com.oplus.camera.ui.d_renamed.this.J_renamed.bm_renamed() || com.oplus.camera.ui.d_renamed.this.o_renamed) {
                    return;
                }
                com.oplus.camera.ui.d_renamed.this.i_renamed(true, true);
            }
        }
    };
    private com.oplus.camera.ui.modepanel.p_renamed.b_renamed cA_renamed = new com.oplus.camera.ui.modepanel.p_renamed.b_renamed() { // from class: com.oplus.camera.ui.d_renamed.62
        @Override // com.oplus.camera.ui.modepanel.p_renamed.b_renamed
        public void a_renamed(int i_renamed) {
            if (com.oplus.camera.ui.d_renamed.this.al_renamed(i_renamed)) {
                return;
            }
            boolean z_renamed = 3 == i_renamed || 28 == i_renamed;
            boolean zA = com.oplus.camera.e_renamed.a_renamed.a_renamed(com.oplus.camera.ui.d_renamed.this.cv_renamed());
            if (com.oplus.camera.ui.d_renamed.this.bd_renamed != null) {
                if (com.oplus.camera.ui.d_renamed.this.z_renamed.a_renamed() || !com.oplus.camera.ui.d_renamed.this.J_renamed.Y_renamed()) {
                    return;
                }
                if (com.oplus.camera.ui.d_renamed.this.J_renamed.aY_renamed() && !com.oplus.camera.ui.d_renamed.this.bf_renamed()) {
                    return;
                }
                if (!z_renamed) {
                    com.oplus.camera.ui.d_renamed.this.bd_renamed.b_renamed(false);
                }
            }
            if (com.oplus.camera.ui.d_renamed.this.J_renamed != null) {
                com.oplus.camera.ui.d_renamed.this.J_renamed.d_renamed(i_renamed);
                if (16 == i_renamed) {
                    com.oplus.camera.ui.d_renamed.this.B_renamed.edit().putBoolean(com.oplus.camera.ui.CameraUIInterface.KEY_MICROSCOPE_GUIDE_SHOW_NEED, true).apply();
                }
            }
            if (com.oplus.camera.ui.menu.a_renamed.c_renamed.d_renamed(i_renamed).equals(com.oplus.camera.ui.d_renamed.this.aV_renamed())) {
                return;
            }
            com.oplus.camera.ui.d_renamed.this.bX_renamed();
            com.oplus.camera.ui.d_renamed.this.h_renamed(false, false);
            com.oplus.camera.ui.d_renamed.this.k_renamed(false, false);
            com.oplus.camera.ui.d_renamed.this.aK_renamed(false);
            com.oplus.camera.ui.d_renamed.this.aJ_renamed(true);
            com.oplus.camera.ui.d_renamed.this.e_renamed(z_renamed ? 0.0f : 1.0f);
            com.oplus.camera.ui.inverse.e_renamed.INS.setMaskAlpha(com.oplus.camera.ui.d_renamed.this.i_renamed, true, true);
            com.oplus.camera.ui.inverse.e_renamed.INS.setExecuteDelayMsg(true);
            com.oplus.camera.ui.d_renamed.this.z_renamed.s_renamed(false);
            com.oplus.camera.util.Util.a_renamed(i_renamed, com.oplus.camera.ui.d_renamed.this.i_renamed, zA);
        }

        @Override // com.oplus.camera.ui.modepanel.p_renamed.b_renamed
        public void a_renamed() {
            com.oplus.camera.ui.d_renamed.this.bx_renamed();
        }

        @Override // com.oplus.camera.ui.modepanel.p_renamed.b_renamed
        public void b_renamed() {
            com.oplus.camera.ui.d_renamed.this.bw_renamed();
        }

        @Override // com.oplus.camera.ui.modepanel.p_renamed.b_renamed
        public void c_renamed() {
            com.oplus.camera.ui.d_renamed.this.aj_renamed(-1);
        }
    };

    private boolean ab_renamed(int i_renamed) {
        return 10 == i_renamed || 16 == i_renamed || 17 == i_renamed;
    }

    private boolean ac_renamed(int i_renamed) {
        return 10 == i_renamed || 16 == i_renamed || 17 == i_renamed || i_renamed == 0;
    }

    private boolean ad_renamed(int i_renamed) {
        return (12 == i_renamed || 19 == i_renamed) ? false : true;
    }

    private boolean ae_renamed(int i_renamed) {
        return (12 == i_renamed || 19 == i_renamed || 4 == i_renamed) ? false : true;
    }

    private boolean af_renamed(int i_renamed) {
        return (12 == i_renamed || 4 == i_renamed) ? false : true;
    }

    public boolean N_renamed(int i_renamed) {
        return 2 == i_renamed || 11 == i_renamed || 15 == i_renamed || 25 == i_renamed || 8 == i_renamed || 1 == i_renamed;
    }

    public boolean T_renamed(int i_renamed) {
        return false;
    }

    @Override // com.oplus.camera.ui.CameraUIInterface
    public boolean W_renamed() {
        return false;
    }

    public void ag_renamed(boolean z_renamed) {
    }

    public void ah_renamed(boolean z_renamed) {
    }

    @Override // com.oplus.camera.ui.CameraUIInterface
    public boolean av_renamed() {
        return false;
    }

    public void ay_renamed(boolean z_renamed) {
    }

    @Override // com.oplus.camera.ui.CameraUIInterface
    public void b_renamed(int i_renamed) {
    }

    @Override // com.oplus.camera.ui.CameraUIInterface
    public void b_renamed(java.lang.String str) {
    }

    public void cO_renamed() {
    }

    public void dA_renamed() {
    }

    public boolean el_renamed() {
        return false;
    }

    @Override // com.oplus.camera.ui.CameraUIInterface
    public int m_renamed() {
        return 0;
    }

    @Override // com.oplus.camera.ui.CameraUIInterface
    public void w_renamed(boolean z_renamed) {
    }

    /* compiled from: CameraUIManager.java */
    /* renamed from: com.oplus.camera.ui.d_renamed$12, reason: invalid class name */
    class ParameterContainer_4 implements com.oplus.camera.timelapsepro.g_renamed.e_renamed {
        ParameterContainer_4() {
        }

        @Override // com.oplus.camera.timelapsepro.g_renamed.e_renamed
        public void a_renamed(int i_renamed) {
            boolean z_renamed = i_renamed != 0;
            if (com.oplus.camera.ui.d_renamed.this.ca_renamed <= 0 || i_renamed <= 0) {
                if (com.oplus.camera.ui.d_renamed.this.ca_renamed == 0 && i_renamed == 0) {
                    return;
                }
                int iJ = com.oplus.camera.ui.d_renamed.this.bx_renamed.j_renamed();
                int i2 = com.oplus.camera.R_renamed.color.time_lapse_pro_seek_value_desc_color;
                if (4 == iJ) {
                    int color = com.oplus.camera.ui.d_renamed.this.i_renamed.getColor(com.oplus.camera.R_renamed.color.camera_white);
                    int color2 = com.oplus.camera.ui.d_renamed.this.i_renamed.getColor(com.oplus.camera.R_renamed.color.time_lapse_pro_seek_value_desc_color);
                    int[] iArr = new int[2];
                    iArr[0] = z_renamed ? color : color2;
                    if (z_renamed) {
                        color = color2;
                    }
                    iArr[1] = color;
                    android.animation.ValueAnimator valueAnimatorOfArgb = android.animation.ValueAnimator.ofArgb(iArr);
                    valueAnimatorOfArgb.setInterpolator(com.oplus.camera.ui.d_renamed.this.ba_renamed);
                    valueAnimatorOfArgb.setDuration(500L);
                    valueAnimatorOfArgb.addUpdateListener(new android.animation.ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.-$$Lambda$d_renamed$12$wj8VuU-w4seV6e0pqKe7KMis6wA
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public final void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
                            this.f_renamed$0.a_renamed(valueAnimator);
                        }
                    });
                    valueAnimatorOfArgb.start();
                } else {
                    com.oplus.camera.ui.menu.facebeauty.RotateAnimationView rotateAnimationView = com.oplus.camera.ui.d_renamed.this.bM_renamed;
                    android.app.Activity activity = com.oplus.camera.ui.d_renamed.this.i_renamed;
                    if (!z_renamed) {
                        i2 = com.oplus.camera.R_renamed.color.camera_white;
                    }
                    rotateAnimationView.setImageTintList(android.content.res.ColorStateList.valueOf(androidx.core.a_renamed.a_renamed.c_renamed(activity, i2)));
                }
                com.oplus.camera.ui.d_renamed.this.ca_renamed = i_renamed;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a_renamed(android.animation.ValueAnimator valueAnimator) {
            com.oplus.camera.ui.d_renamed.this.bM_renamed.setColorFilter(((java.lang.Integer) valueAnimator.getAnimatedValue()).intValue());
        }

        @Override // com.oplus.camera.timelapsepro.g_renamed.e_renamed
        public void a_renamed(java.lang.String str) {
            com.oplus.camera.ui.d_renamed.this.J_renamed.g_renamed(0);
        }

        @Override // com.oplus.camera.timelapsepro.g_renamed.e_renamed
        public void a_renamed(long j_renamed) {
            com.oplus.camera.ui.d_renamed.this.J_renamed.g_renamed(0);
        }

        @Override // com.oplus.camera.timelapsepro.g_renamed.e_renamed
        public void a_renamed(java.lang.String str, java.lang.String str2) {
            com.oplus.camera.ui.d_renamed.this.J_renamed.g_renamed(0);
            com.oplus.camera.ui.d_renamed.this.B_renamed.edit().putString(str, str2).apply();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void gH_renamed() {
        com.oplus.camera.e_renamed.a_renamed("CameraUIManager", "mUpdateButtonBgRunnable, mSizeRatioType: " + this.M_renamed);
        com.oplus.camera.ui.control.a_renamed aVar = this.z_renamed;
        if (aVar != null) {
            aVar.m_renamed(this.M_renamed);
        }
        com.oplus.camera.ui.CameraUIListener cameraUIListener = this.J_renamed;
        if (cameraUIListener != null) {
            cameraUIListener.e_renamed(this.Y_renamed);
            this.J_renamed.h_renamed(this.M_renamed);
        }
        com.oplus.camera.screen.b_renamed.a_renamed aVar2 = this.bx_renamed;
        if (aVar2 != null) {
            if (this.Y_renamed) {
                com.oplus.camera.ui.widget.SplitBackgroundView splitBackgroundView = this.aL_renamed;
                if (splitBackgroundView != null) {
                    splitBackgroundView.setLightBackground(true);
                }
                com.oplus.camera.ui.menu.facebeauty.RotateAnimationView rotateAnimationView = this.aQ_renamed;
                if (rotateAnimationView != null) {
                    rotateAnimationView.setLightBackground(true);
                }
                com.oplus.camera.ui.widget.SplitBackgroundView splitBackgroundView2 = this.aM_renamed;
                if (splitBackgroundView2 != null) {
                    splitBackgroundView2.setLightBackground(true);
                    return;
                }
                return;
            }
            aVar2.b_renamed(this.i_renamed, this.M_renamed);
        }
    }

    public boolean bf_renamed() {
        com.oplus.camera.ui.preview.b_renamed bVar = this.bk_renamed;
        return bVar != null && bVar.b_renamed();
    }

    public void a_renamed(com.oplus.camera.soloop.b_renamed bVar) {
        this.C_renamed = bVar;
        if (this.B_renamed.getBoolean("pref_allow_network_access", false)) {
            bVar.a_renamed();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U_renamed(int i_renamed) {
        int i2;
        int i3;
        com.oplus.camera.screen.g_renamed gVar;
        if (this.i_renamed == null || !this.J_renamed.a_renamed(i_renamed, this.R_renamed)) {
            return;
        }
        if (this.bk_renamed == null) {
            this.bk_renamed = new com.oplus.camera.ui.preview.b_renamed(this.i_renamed, i_renamed, this.J_renamed);
        }
        this.bk_renamed.a_renamed(i_renamed);
        int i4 = -1;
        if (i_renamed != 0) {
            if (i_renamed == 1) {
                i4 = 6;
                i2 = com.oplus.camera.R_renamed.string.camera_ai_scene_ultra_wide_tip;
                i3 = com.oplus.camera.R_renamed.drawable.hint_icon_ultra_wide;
            } else if (i_renamed != 2) {
                i2 = -1;
                i3 = -1;
            } else {
                i4 = 12;
                i2 = com.oplus.camera.R_renamed.string.camera_ai_scene_portrait_mode_hint;
                i3 = com.oplus.camera.R_renamed.drawable.ai_scene_hint_portrait_mode;
            }
        } else {
            if (!com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_SUPER_TEXT)) {
                return;
            }
            i4 = 10;
            i2 = com.oplus.camera.R_renamed.string.camera_ai_scene_super_text_hint;
            i3 = com.oplus.camera.R_renamed.drawable.ai_scene_hint_super_text;
        }
        if (!this.bk_renamed.b_renamed() && !A_renamed() && !K_renamed()) {
            com.oplus.camera.e_renamed.b_renamed("CameraUIManager", "showAiHint, aiHintType: " + i_renamed);
            if (com.oplus.camera.util.Util.t_renamed() && (gVar = this.l_renamed) != null) {
                this.bk_renamed.a_renamed(gVar.a_renamed().c_renamed(this.i_renamed), i2, i3, eX_renamed());
            } else {
                this.bk_renamed.a_renamed(this.i_renamed.getApplication().getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.pi_ultra_wide_hint_layout_margin_top), i2, i3, eX_renamed());
            }
            this.J_renamed.b_renamed(com.oplus.camera.statistics.model.ReminderMsgData.TYPE_ADVICE, com.oplus.camera.statistics.model.ReminderMsgData.CODE_TRY_WIDE_ANGLE);
        } else {
            com.oplus.camera.j_renamed.a_renamed().c_renamed();
        }
        this.cm_renamed.removeMessages(i4);
        android.os.Message messageObtainMessage = this.cm_renamed.obtainMessage();
        messageObtainMessage.what = i4;
        this.cm_renamed.sendMessageDelayed(messageObtainMessage, com.google.android.exoplayer2.DefaultRenderersFactory.DEFAULT_ALLOWED_VIDEO_JOINING_TIME_MS);
    }

    @Override // com.oplus.camera.ui.CameraUIInterface
    public void v_renamed(int i_renamed) {
        com.oplus.camera.ui.modepanel.p_renamed.b_renamed bVar = this.cA_renamed;
        if (bVar != null) {
            bVar.a_renamed(i_renamed);
        }
    }

    @Override // com.oplus.camera.ui.CameraUIInterface
    public void l_renamed(boolean z_renamed) {
        if (this.bk_renamed != null) {
            com.oplus.camera.e_renamed.b_renamed("CameraUIManager", "hideAiHint, remove: " + z_renamed);
            this.bk_renamed.a_renamed(z_renamed);
            if (this.bk_renamed.c_renamed()) {
                com.oplus.camera.j_renamed.a_renamed().c_renamed();
            }
        }
        if (this.cm_renamed.hasMessages(10)) {
            this.cm_renamed.removeMessages(10);
        }
        if (this.cm_renamed.hasMessages(6)) {
            this.cm_renamed.removeMessages(6);
        }
        if (this.cm_renamed.hasMessages(12)) {
            this.cm_renamed.removeMessages(12);
        }
    }

    @Override // com.oplus.camera.ui.CameraUIInterface
    public void m_renamed(boolean z_renamed, boolean z2) {
        com.oplus.camera.ui.menu.levelcontrol.g_renamed gVar = this.ah_renamed;
        if (gVar != null) {
            gVar.b_renamed(z_renamed, z2);
        }
    }

    @Override // com.oplus.camera.ui.CameraUIInterface
    public void G_renamed() {
        this.z_renamed.d_renamed(true, false);
        r_renamed(false);
        if (A_renamed()) {
            this.ah_renamed.b_renamed(true, false);
        }
        android.util.Size sizeBG = bG_renamed();
        h_renamed(sizeBG != null ? com.oplus.camera.util.Util.d_renamed(sizeBG.getWidth(), sizeBG.getHeight()) : 0, true);
    }

    @Override // com.oplus.camera.ui.CameraUIInterface
    public void F_renamed() {
        this.z_renamed.d_renamed(false, true);
        if (A_renamed()) {
            this.ah_renamed.b_renamed(true, false);
        }
        q_renamed(false);
        c_renamed(false);
        v_renamed(false);
        android.util.Size sizeBG = bG_renamed();
        if (sizeBG != null) {
            V_renamed(com.oplus.camera.util.Util.d_renamed(sizeBG.getWidth(), sizeBG.getHeight()));
        }
    }

    private void V_renamed(int i_renamed) {
        if (com.oplus.camera.util.Util.c_renamed(i_renamed)) {
            af_renamed(true);
            com.oplus.camera.ui.control.a_renamed aVar = this.z_renamed;
            if (aVar != null) {
                aVar.o_renamed(true);
            }
        }
    }

    @Override // com.oplus.camera.ui.CameraUIInterface
    public com.oplus.camera.ui.preview.a_renamed.p_renamed I_renamed() {
        return this.ch_renamed;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a_renamed(android.view.View view) {
        if (view.getId() == com.oplus.camera.R_renamed.id_renamed.out_screen_preview_switch_button || view.getId() == com.oplus.camera.R_renamed.id_renamed.out_capture_button) {
            if (this.J_renamed.h_renamed(com.oplus.camera.aps.config.CameraFunction.OUT_CAPTURE_ENABLE)) {
                this.J_renamed.a_renamed(71, com.oplus.camera.util.Util.u_renamed() ? "2" : "3");
                this.k_renamed.a_renamed();
                this.k_renamed.a_renamed(this.i_renamed, this.cs_renamed);
                return;
            } else {
                if (this.J_renamed.h_renamed(com.oplus.camera.aps.config.CameraFunction.OUT_PREVIEW_ENABLE)) {
                    if (!this.j_renamed.b_renamed()) {
                        this.J_renamed.a_renamed(71, "0");
                    }
                    this.j_renamed.a_renamed(this.i_renamed, this.ct_renamed);
                    this.B_renamed.edit().putBoolean(com.oplus.camera.ui.CameraUIInterface.KEY_OUT_PREVIEW_GUIDE, false).apply();
                    this.J_renamed.bY_renamed();
                    return;
                }
                return;
            }
        }
        if (view.getId() == com.oplus.camera.R_renamed.id_renamed.out_screen_capture_exit_button) {
            this.k_renamed.a_renamed(true, true);
        }
    }

    @Override // com.oplus.camera.ui.CameraUIInterface
    public void R_renamed(boolean z_renamed) {
        this.j_renamed.b_renamed(z_renamed);
    }

    public void x_renamed(int i_renamed) {
        this.j_renamed.a_renamed(i_renamed);
    }

    public d_renamed(android.app.Activity activity, com.oplus.camera.ComboPreferences comboPreferences, com.oplus.camera.ui.CameraUIListener cameraUIListener, com.oplus.camera.screen.g_renamed gVar) {
        this.i_renamed = null;
        this.j_renamed = null;
        this.k_renamed = null;
        this.l_renamed = null;
        this.y_renamed = null;
        this.z_renamed = null;
        this.A_renamed = null;
        this.B_renamed = null;
        this.H_renamed = null;
        this.I_renamed = null;
        this.J_renamed = null;
        this.ac_renamed = null;
        this.ae_renamed = null;
        this.af_renamed = null;
        this.ag_renamed = null;
        this.bx_renamed = null;
        this.i_renamed = activity;
        this.j_renamed = new com.oplus.camera.screen.a_renamed.c_renamed();
        this.k_renamed = new com.oplus.camera.screen.a_renamed.b_renamed();
        this.k_renamed.b_renamed(activity, this.cs_renamed);
        this.l_renamed = gVar;
        this.bx_renamed = this.l_renamed.a_renamed();
        this.l_renamed.a_renamed(this);
        this.B_renamed = comboPreferences;
        this.J_renamed = cameraUIListener;
        this.z_renamed = new com.oplus.camera.ui.control.a_renamed(this.i_renamed, this.B_renamed, this.J_renamed, this.l_renamed);
        this.A_renamed = new com.oplus.camera.ui.preview.g_renamed(this.i_renamed, this.B_renamed, this);
        com.oplus.camera.ui.inverse.e_renamed.INS.setCameraPreviewUI(this.i_renamed, this.A_renamed);
        this.H_renamed = new com.oplus.camera.ui.menu.setting.o_renamed(this.i_renamed, this.B_renamed, cameraUIListener, false);
        this.I_renamed = new com.oplus.camera.ui.menu.setting.f_renamed(this.i_renamed, this.B_renamed, cameraUIListener, true);
        this.I_renamed.a_renamed(this);
        this.y_renamed = new com.oplus.camera.ui.b_renamed.a_renamed(this.i_renamed, cameraUIListener, this.z_renamed);
        this.ac_renamed = new com.oplus.camera.ui.a_renamed.a_renamed(com.oplus.camera.util.Util.l_renamed().getResources(), this);
        android.view.LayoutInflater layoutInflater = this.i_renamed.getLayoutInflater();
        this.ae_renamed = (com.oplus.camera.ui.camerascreenhint.CameraScreenHintView) layoutInflater.inflate(com.oplus.camera.R_renamed.layout.camera_screen_hint, (android.view.ViewGroup) null);
        this.af_renamed = (com.oplus.camera.ui.camerascreenhint.CameraScreenHintView) layoutInflater.inflate(com.oplus.camera.R_renamed.layout.camera_screen_hint, (android.view.ViewGroup) null);
        this.ag_renamed = (com.oplus.camera.ui.camerascreenhint.CameraScreenHintView) layoutInflater.inflate(com.oplus.camera.R_renamed.layout.camera_screen_hint, (android.view.ViewGroup) null);
        this.ae_renamed.setCameraScreenHintInterface(this.ck_renamed);
        this.ag_renamed.setCameraScreenHintInterface(this.ck_renamed);
        this.af_renamed.setCameraScreenHintInterface(this.ck_renamed);
        this.ac_renamed.a_renamed(this.ae_renamed, this.af_renamed, this.ag_renamed);
        this.m_renamed = activity.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.xpan_mode_thumbimageview_trans_x);
    }

    @Override // com.oplus.camera.ui.CameraUIInterface
    public com.oplus.camera.ui.a_renamed.a_renamed k_renamed() {
        return this.ac_renamed;
    }

    public void S_renamed(boolean z_renamed) {
        if (this.aQ_renamed != null) {
            com.oplus.camera.ui.CameraUIListener cameraUIListener = this.J_renamed;
            int i_renamed = (cameraUIListener == null || !cameraUIListener.h_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_MULTI_CAMERA_TYPE_MENU)) ? com.oplus.camera.R_renamed.drawable.blur_menu_control_button : com.oplus.camera.R_renamed.drawable.multi_video_type_menu_normal;
            if (i_renamed != this.aP_renamed) {
                this.aP_renamed = i_renamed;
                this.aQ_renamed.setImageResource(i_renamed);
            }
            if (com.oplus.camera.R_renamed.drawable.blur_menu_control_button == i_renamed) {
                this.aQ_renamed.setSelected(z_renamed);
            }
        }
    }

    @Override // com.oplus.camera.ui.preview.g_renamed.b_renamed
    public java.lang.String bg_renamed() {
        com.oplus.camera.ui.CameraUIListener cameraUIListener = this.J_renamed;
        return cameraUIListener != null ? cameraUIListener.bf_renamed() : "";
    }

    @Override // com.oplus.camera.ui.preview.g_renamed.b_renamed
    public java.lang.String bh_renamed() {
        com.oplus.camera.ui.CameraUIListener cameraUIListener = this.J_renamed;
        return cameraUIListener != null ? cameraUIListener.bg_renamed() : "";
    }

    public void a_renamed(com.oplus.camera.ui.control.c_renamed cVar) {
        this.z_renamed.a_renamed(cVar);
    }

    public boolean bi_renamed() {
        return this.z_renamed.a_renamed();
    }

    @Override // com.oplus.camera.ui.CameraUIInterface
    public boolean d_renamed() {
        com.oplus.camera.ui.control.a_renamed aVar = this.z_renamed;
        if (aVar != null) {
            return aVar.d_renamed();
        }
        return false;
    }

    public boolean bj_renamed() {
        com.oplus.camera.ui.widget.c_renamed cVar = this.ay_renamed;
        if (cVar != null) {
            return cVar.isShowing();
        }
        return false;
    }

    @Override // com.oplus.camera.ui.CameraUIInterface
    public boolean e_renamed() {
        return f_renamed();
    }

    @Override // com.oplus.camera.ui.CameraUIInterface
    public boolean f_renamed() {
        com.oplus.camera.screen.a_renamed.b_renamed bVar = this.k_renamed;
        if (bVar != null) {
            return bVar.e_renamed();
        }
        return false;
    }

    @Override // com.oplus.camera.ui.CameraUIInterface
    public boolean g_renamed() {
        com.oplus.camera.screen.a_renamed.c_renamed cVar = this.j_renamed;
        if (cVar != null) {
            return cVar.b_renamed();
        }
        return false;
    }

    @Override // com.oplus.camera.ui.CameraUIInterface
    public void i_renamed() {
        if (com.oplus.camera.util.Util.t_renamed()) {
            com.oplus.camera.ui.preview.g_renamed gVar = this.A_renamed;
            if (gVar != null) {
                gVar.k_renamed(e_renamed());
            }
            com.oplus.camera.ui.CameraUIListener cameraUIListener = this.J_renamed;
            if (cameraUIListener != null) {
                cameraUIListener.ch_renamed();
            }
        }
    }

    public void y_renamed(int i_renamed) throws android.content.res.Resources.NotFoundException {
        com.oplus.camera.ui.control.a_renamed aVar = this.z_renamed;
        if (aVar != null) {
            aVar.a_renamed(i_renamed);
        }
    }

    public void z_renamed(int i_renamed) {
        com.oplus.camera.ui.control.a_renamed aVar = this.z_renamed;
        if (aVar != null) {
            aVar.b_renamed(i_renamed);
        }
    }

    public void a_renamed(com.oplus.camera.ui.preview.a_renamed.t_renamed tVar) {
        com.oplus.camera.e_renamed.a_renamed("CameraUIManager", "onCreateCameraPriorityUI");
        com.oplus.camera.e_renamed.a_renamed("UIManager.onCreateCameraPriorityUI");
        this.Z_renamed = (android.view.ViewGroup) this.i_renamed.findViewById(com.oplus.camera.R_renamed.id_renamed.camera);
        this.aa_renamed = this.i_renamed.findViewById(com.oplus.camera.R_renamed.id_renamed.camera_root);
        this.aa_renamed.setBackgroundColor(com.oplus.camera.util.c_renamed.a_renamed(this.i_renamed.getColor(com.oplus.camera.R_renamed.color.background_color)));
        this.ac_renamed.a_renamed(this.Z_renamed);
        this.Z_renamed.setMotionEventSplittingEnabled(false);
        com.oplus.camera.ui.preview.g_renamed gVar = this.A_renamed;
        if (gVar != null) {
            gVar.a_renamed(tVar);
        }
        fk_renamed();
        com.oplus.camera.e_renamed.b_renamed("UIManager.onCreateCameraPriorityUI");
    }

    public void bk_renamed() throws android.content.res.Resources.NotFoundException {
        com.oplus.camera.e_renamed.a_renamed("CameraUIManager", "onCreate");
        com.oplus.camera.e_renamed.a_renamed("UIManager.onCreate");
        this.n_renamed = false;
        this.o_renamed = false;
        this.l_renamed.c_renamed();
        com.oplus.camera.ui.b_renamed.a_renamed aVar = this.y_renamed;
        if (aVar != null) {
            aVar.a_renamed(this.Z_renamed);
        }
        com.oplus.camera.ui.control.a_renamed aVar2 = this.z_renamed;
        if (aVar2 != null) {
            aVar2.c_renamed(this.K_renamed);
        }
        com.oplus.camera.ui.menu.setting.o_renamed oVar = this.H_renamed;
        if (oVar != null) {
            oVar.C_renamed();
        }
        com.oplus.camera.ui.menu.setting.f_renamed fVar = this.I_renamed;
        if (fVar != null) {
            fVar.C_renamed();
        }
        this.ah_renamed = new com.oplus.camera.ui.menu.levelcontrol.g_renamed(this.i_renamed);
        this.ah_renamed.setCameraEntryType(this.K_renamed);
        this.ah_renamed.a_renamed(this.L_renamed);
        this.ah_renamed.setFilterEffectMenuListener(this.cx_renamed);
        this.ai_renamed = new com.oplus.camera.ui.menu.levelcontrol.c_renamed(this.i_renamed, this.cy_renamed);
        this.ai_renamed.setScreenMode(aX_renamed(), this.bx_renamed.k_renamed());
        this.aQ_renamed = (com.oplus.camera.ui.menu.facebeauty.RotateAnimationView) this.i_renamed.findViewById(com.oplus.camera.R_renamed.id_renamed.camera_menu_left_enter_button);
        this.aQ_renamed.setOnClickListener(this.f6083co);
        com.oplus.camera.ui.inverse.e_renamed.INS.registerInverse(this.i_renamed, this.aQ_renamed);
        com.oplus.camera.ui.a_renamed.a_renamed(this.i_renamed).a_renamed(this.aQ_renamed, "MenuLeftEnterButton");
        this.bv_renamed = this.i_renamed.getApplication().getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.face_beauty_enter_button_animation_y);
        this.aL_renamed = (com.oplus.camera.ui.widget.SplitBackgroundView) this.i_renamed.findViewById(com.oplus.camera.R_renamed.id_renamed.face_beauty_enter_button);
        this.aL_renamed.setInterceptTouchEvent(true);
        this.aL_renamed.setOnClickListener(this.cv_renamed);
        com.oplus.camera.ui.inverse.e_renamed.INS.registerInverse(this.i_renamed, this.aL_renamed);
        com.oplus.camera.ui.a_renamed.a_renamed(this.i_renamed).a_renamed(this.aL_renamed, "FaceBeautyEnterButton");
        this.aM_renamed = (com.oplus.camera.ui.widget.SplitBackgroundView) this.i_renamed.findViewById(com.oplus.camera.R_renamed.id_renamed.effect_menu_back_button);
        this.aM_renamed.setOnClickListener(this.aN_renamed);
        com.oplus.camera.ui.inverse.e_renamed.INS.registerInverse(this.i_renamed, this.aM_renamed);
        this.aT_renamed = new com.oplus.camera.ui.menu.facebeauty.g_renamed(this.i_renamed, this.cw_renamed, this.K_renamed, this.J_renamed);
        this.aT_renamed.a_renamed(this.cg_renamed);
        this.aS_renamed = new com.oplus.camera.tiltshift.TiltShiftBlurMenu(this.i_renamed, this.cy_renamed);
        this.aS_renamed.setBlurType(1);
        if (this.bt_renamed == null) {
            this.bt_renamed = new com.oplus.camera.ui.modepanel.f_renamed(this.i_renamed, this.l_renamed);
        }
        if (this.K_renamed == 1) {
            fl_renamed();
            fI_renamed();
        }
        if (h_renamed) {
            h_renamed = com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_SUPPORT_FIRST_LAUNCH_ANIMATION);
            com.oplus.camera.e_renamed.a_renamed("CameraUIManager", "onCreate, show first launch animation : " + h_renamed);
        }
        this.z_renamed.a_renamed(this.bt_renamed);
        this.z_renamed.a_renamed(this.cn_renamed);
        if (com.oplus.camera.util.Util.t_renamed()) {
            this.by_renamed = (com.oplus.camera.ui.widget.SplitBackgroundView) this.i_renamed.findViewById(com.oplus.camera.R_renamed.id_renamed.screen_mode_switch_button);
            this.bz_renamed = (com.oplus.camera.ui.OutScreenButtonBoxView) this.i_renamed.findViewById(com.oplus.camera.R_renamed.id_renamed.out_screen_preview_switch_button);
            this.bA_renamed = (com.oplus.camera.ui.menu.facebeauty.RotateAnimationView) this.i_renamed.findViewById(com.oplus.camera.R_renamed.id_renamed.out_screen_capture_exit_button);
            this.by_renamed.setOnClickListener(this.cr_renamed);
            this.bz_renamed.setOnClickListener(this.cu_renamed);
            this.bA_renamed.setOnClickListener(this.cu_renamed);
            com.oplus.camera.ui.inverse.e_renamed.INS.registerInverse(this.i_renamed, this.by_renamed);
            com.oplus.camera.ui.inverse.e_renamed.INS.registerInverse(this.i_renamed, this.bz_renamed);
            this.cc_renamed.add(this.aL_renamed);
            this.cc_renamed.add(this.aM_renamed);
            this.cc_renamed.add(this.by_renamed);
            this.cc_renamed.add(this.bz_renamed.getBgView());
            if (com.oplus.camera.util.Util.u_renamed() && dY_renamed() && this.bx_renamed != null) {
                this.bx_renamed.a_renamed(this.i_renamed.findViewById(com.oplus.camera.R_renamed.id_renamed.headline_view), this.i_renamed.findViewById(com.oplus.camera.R_renamed.id_renamed.thumbnail));
                this.z_renamed.a_renamed(this.bx_renamed, true);
            }
        }
        com.oplus.camera.e_renamed.b_renamed("UIManager.onCreate");
    }

    public void bl_renamed() {
        com.oplus.camera.ui.preview.g_renamed gVar = this.A_renamed;
        if (gVar != null) {
            gVar.d_renamed();
        }
        com.oplus.camera.ui.control.a_renamed aVar = this.z_renamed;
        if (aVar != null) {
            aVar.e_renamed();
        }
    }

    private void eO_renamed() {
        boolean z_renamed = ga_renamed() && this.J_renamed.bc_renamed().w_renamed();
        com.oplus.camera.e_renamed.b_renamed("CameraUIManager", "initGalleryPreview, isLocked: " + z_renamed + ", isDeviceLocked: " + ga_renamed() + ", lockScreenLocked: " + this.J_renamed.bc_renamed().w_renamed());
        com.oplus.camera.w_renamed.d_renamed.a_renamed().a_renamed(new com.oplus.camera.ui.d_renamed.CameraUIManager_3(z_renamed), "Init GalleryData");
    }

    /* compiled from: CameraUIManager.java */
    /* renamed from: com.oplus.camera.ui.d_renamed$13, reason: invalid class name */
    class CameraUIManager_3 implements java.lang.Runnable {

        /* renamed from: a_renamed, reason: collision with root package name */
        final /* synthetic */ boolean f6088a;

        CameraUIManager_3(boolean z_renamed) {
            this.f6088a = z_renamed;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!this.f6088a) {
                if (com.oplus.camera.ui.d_renamed.this.z_renamed != null && com.oplus.camera.ui.d_renamed.this.z_renamed.k_renamed() && !com.oplus.camera.ui.d_renamed.this.z_renamed.l_renamed()) {
                    com.oplus.camera.ui.d_renamed.this.bL_renamed = null;
                } else {
                    com.oplus.camera.ui.d_renamed dVar = com.oplus.camera.ui.d_renamed.this;
                    dVar.bL_renamed = com.oplus.c_renamed.a_renamed.f_renamed.a_renamed(dVar.i_renamed, 50);
                }
            } else {
                com.oplus.camera.ui.d_renamed dVar2 = com.oplus.camera.ui.d_renamed.this;
                dVar2.bL_renamed = com.oplus.c_renamed.a_renamed.f_renamed.b_renamed(dVar2.i_renamed, 50);
            }
            if (com.oplus.camera.ui.d_renamed.this.i_renamed != null) {
                com.oplus.camera.ui.d_renamed.this.i_renamed.runOnUiThread(new java.lang.Runnable() { // from class: com.oplus.camera.ui.d_renamed.13.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (com.oplus.camera.ui.d_renamed.this.i_renamed == null) {
                            return;
                        }
                        if (com.oplus.camera.ui.d_renamed.this.bH_renamed != null) {
                            com.oplus.camera.ui.d_renamed.this.bH_renamed.b_renamed(com.oplus.camera.ui.d_renamed.CameraUIManager_3.this.f6088a);
                            if (com.oplus.camera.ui.d_renamed.this.bE_renamed() != null) {
                                com.oplus.camera.ui.d_renamed.this.bH_renamed.a_renamed(com.oplus.camera.ui.d_renamed.this.bE_renamed().h_renamed());
                            }
                            com.oplus.camera.ui.d_renamed.this.bH_renamed.a_renamed(com.oplus.camera.ui.d_renamed.this.bL_renamed);
                            if (com.oplus.camera.ui.d_renamed.this.l_renamed != null) {
                                com.oplus.camera.ui.d_renamed.this.l_renamed.a_renamed().a_renamed(com.oplus.camera.ui.d_renamed.this.i_renamed.findViewById(com.oplus.camera.R_renamed.id_renamed.gallery_container));
                            }
                            com.oplus.camera.ui.d_renamed.this.bJ_renamed.a_renamed(com.oplus.camera.ui.d_renamed.this.bH_renamed.getItemCount() - 1, false);
                            return;
                        }
                        com.oplus.camera.ui.d_renamed.this.bF_renamed = (android.view.ViewGroup) com.oplus.camera.ui.d_renamed.this.i_renamed.findViewById(com.oplus.camera.R_renamed.id_renamed.gallery_container);
                        if (com.oplus.camera.ui.d_renamed.this.bF_renamed == null) {
                            com.oplus.camera.ui.d_renamed.this.l_renamed.a_renamed().d_renamed(com.oplus.camera.ui.d_renamed.this.i_renamed);
                            com.oplus.camera.ui.d_renamed.this.bF_renamed = (android.view.ViewGroup) com.oplus.camera.ui.d_renamed.this.i_renamed.findViewById(com.oplus.camera.R_renamed.id_renamed.gallery_container);
                        }
                        com.oplus.camera.ui.d_renamed.this.bH_renamed = new com.oplus.camera.ui.k_renamed(com.oplus.camera.ui.d_renamed.this.i_renamed, 0, com.oplus.camera.ui.d_renamed.this.J_renamed);
                        com.oplus.camera.ui.d_renamed.this.bH_renamed.a_renamed(new com.oplus.camera.ui.k_renamed.c_renamed() { // from class: com.oplus.camera.ui.d_renamed.13.1.1
                            @Override // com.oplus.camera.ui.k_renamed.c_renamed
                            public void a_renamed(android.view.View view, android.graphics.Bitmap bitmap, int i_renamed) {
                                com.oplus.camera.e_renamed.b_renamed("CameraUIManager", "initGalleryPreview, onclick, bitmap: " + bitmap + ", pos: " + i_renamed);
                                com.oplus.camera.ui.d_renamed.this.z_renamed.a_renamed(com.oplus.camera.ui.d_renamed.this.bH_renamed.a_renamed(i_renamed), bitmap);
                            }
                        });
                        com.oplus.camera.ui.d_renamed.this.bH_renamed.b_renamed(com.oplus.camera.ui.d_renamed.CameraUIManager_3.this.f6088a);
                        if (com.oplus.camera.ui.d_renamed.this.bE_renamed() != null) {
                            com.oplus.camera.ui.d_renamed.this.bH_renamed.a_renamed(com.oplus.camera.ui.d_renamed.this.bE_renamed().h_renamed());
                        }
                        com.oplus.camera.ui.d_renamed.this.bH_renamed.a_renamed(com.oplus.camera.ui.d_renamed.this.bL_renamed);
                        com.oplus.camera.ui.d_renamed.this.bI_renamed = new com.oplus.camera.ui.l_renamed(com.oplus.camera.ui.d_renamed.this.i_renamed, com.oplus.camera.ui.d_renamed.this.i_renamed.getApplication().getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.gallery_preview_padding), com.oplus.camera.ui.d_renamed.this.i_renamed.getApplication().getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.gallery_preview_padding), 0, 0);
                        com.oplus.camera.ui.d_renamed.this.bJ_renamed = (androidx.viewpager2.widget.ViewPager2) com.oplus.camera.ui.d_renamed.this.bF_renamed.findViewById(com.oplus.camera.R_renamed.id_renamed.gallery_pager);
                        com.oplus.camera.ui.d_renamed.this.bJ_renamed.setAdapter(com.oplus.camera.ui.d_renamed.this.bH_renamed);
                        com.oplus.camera.ui.d_renamed.this.bJ_renamed.setClipToOutline(true);
                        com.oplus.camera.ui.d_renamed.this.bJ_renamed.a_renamed(com.oplus.camera.ui.d_renamed.this.bI_renamed);
                        com.oplus.camera.ui.d_renamed.this.bJ_renamed.a_renamed(com.oplus.camera.ui.d_renamed.this.bH_renamed.getItemCount() - 1, false);
                        com.oplus.camera.ui.d_renamed.this.bJ_renamed.a_renamed(new androidx.viewpager2.widget.ViewPager2.e_renamed() { // from class: com.oplus.camera.ui.d_renamed.13.1.2
                            @Override // androidx.viewpager2.widget.ViewPager2.e_renamed
                            public void onPageScrollStateChanged(int i_renamed) {
                                super.onPageScrollStateChanged(i_renamed);
                            }

                            @Override // androidx.viewpager2.widget.ViewPager2.e_renamed
                            public void onPageSelected(int i_renamed) {
                                com.oplus.camera.ui.d_renamed.this.bG_renamed.a_renamed(i_renamed);
                                super.onPageSelected(i_renamed);
                            }

                            @Override // androidx.viewpager2.widget.ViewPager2.e_renamed
                            public void onPageScrolled(int i_renamed, float f_renamed, int i2) {
                                super.onPageScrolled(i_renamed, f_renamed, i2);
                            }
                        });
                        if (com.oplus.camera.ui.d_renamed.this.bK_renamed == null) {
                            com.oplus.camera.ui.d_renamed.this.bK_renamed = (com.oplus.camera.ui.inverse.InverseTextView) com.oplus.camera.ui.d_renamed.this.i_renamed.findViewById(com.oplus.camera.R_renamed.id_renamed.gallery_preview_empty_view);
                        }
                        com.oplus.camera.ui.d_renamed.this.bK_renamed.setVisibility(8);
                        if (com.oplus.camera.ui.d_renamed.this.l_renamed != null) {
                            com.oplus.camera.ui.d_renamed.this.l_renamed.a_renamed().a_renamed(com.oplus.camera.ui.d_renamed.this.i_renamed.findViewById(com.oplus.camera.R_renamed.id_renamed.gallery_container));
                        }
                        if (com.oplus.camera.ui.d_renamed.this.bG_renamed == null) {
                            com.oplus.camera.ui.d_renamed.this.bG_renamed = (com.oplus.camera.ui.j_renamed) com.oplus.camera.ui.d_renamed.this.i_renamed.findViewById(com.oplus.camera.R_renamed.id_renamed.gallery_menu_panel);
                            com.oplus.camera.ui.d_renamed.this.bG_renamed.a_renamed(com.oplus.camera.ui.d_renamed.this.J_renamed, com.oplus.camera.ui.d_renamed.this.B_renamed, com.oplus.camera.ui.d_renamed.this.i_renamed, com.oplus.camera.ui.d_renamed.this.bH_renamed);
                        }
                        if (com.oplus.camera.ui.d_renamed.this.cd_renamed != null) {
                            com.oplus.camera.ui.d_renamed.this.bH_renamed.registerAdapterDataObserver(com.oplus.camera.ui.d_renamed.this.cd_renamed);
                        }
                    }
                });
            }
        }
    }

    public void bm_renamed() {
        com.oplus.camera.ui.menu.levelcontrol.r_renamed rVar = this.ak_renamed;
        if (rVar != null) {
            rVar.c_renamed();
        }
    }

    public void bn_renamed() {
        com.oplus.camera.ui.menu.levelcontrol.r_renamed rVar = this.ak_renamed;
        if (rVar != null) {
            rVar.b_renamed();
        }
    }

    @Override // com.oplus.camera.ui.CameraUIInterface
    public void x_renamed(boolean z_renamed) {
        com.oplus.camera.ui.menu.setting.f_renamed fVar = this.I_renamed;
        if (fVar != null) {
            fVar.a_renamed(z_renamed ? 0 : 8);
            this.ac_renamed.c_renamed(true);
        }
        if (z_renamed && K_renamed()) {
            a_renamed(true, true, true, true);
        }
        if (z_renamed && O_renamed()) {
            this.ai_renamed.hideMenu(true, true, false, true);
        }
        if (4 == aX_renamed() && !fh_renamed() && !K_renamed() && !this.aT_renamed.m_renamed() && !this.ah_renamed.isEffectMenuOpen() && !this.ah_renamed.isAnimationRunning() && !O_renamed() && !P_renamed() && !aw_renamed()) {
            y_renamed(!z_renamed);
        }
        com.oplus.camera.ui.menu.setting.o_renamed oVar = this.H_renamed;
        if (oVar != null) {
            oVar.a_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_SUB_SETTING, z_renamed ? 0 : 8);
            this.H_renamed.M_renamed();
        }
        if (z_renamed) {
            return;
        }
        this.R_renamed = -1;
        ag_renamed(this.O_renamed);
    }

    public boolean bo_renamed() {
        com.oplus.camera.ui.menu.setting.f_renamed fVar = this.I_renamed;
        if (fVar != null) {
            return fVar.c_renamed();
        }
        return false;
    }

    public void e_renamed(java.lang.String str, boolean z_renamed) {
        com.oplus.camera.ui.menu.setting.f_renamed fVar = this.I_renamed;
        if (fVar != null) {
            fVar.a_renamed(str, z_renamed);
        }
    }

    public void bp_renamed() {
        com.oplus.camera.ui.preview.q_renamed qVar = this.aI_renamed;
        if (qVar != null) {
            qVar.b_renamed();
        }
    }

    @Override // com.oplus.camera.ui.CameraUIInterface
    public boolean T_renamed() {
        com.oplus.camera.ui.menu.setting.f_renamed fVar;
        return (this.p_renamed || (fVar = this.I_renamed) == null || !fVar.j_renamed()) ? false : true;
    }

    @Override // com.oplus.camera.ui.CameraUIInterface
    public void U_renamed() {
        com.oplus.camera.ui.menu.setting.f_renamed fVar = this.I_renamed;
        if (fVar != null) {
            fVar.d_renamed(false);
        }
        com.oplus.camera.ComboPreferences comboPreferences = this.B_renamed;
        if (comboPreferences != null) {
            if ("off".equals(comboPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_SUB_SETTING, "off"))) {
                com.oplus.camera.ui.menu.setting.f_renamed fVar2 = this.I_renamed;
                if (fVar2 != null) {
                    fVar2.b_renamed();
                    return;
                }
                return;
            }
            this.B_renamed.edit().putString(com.oplus.camera.ui.CameraUIInterface.KEY_SUB_SETTING, "off").apply();
            f_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_SUB_SETTING);
        }
    }

    @Override // com.oplus.camera.ui.CameraUIInterface
    public void y_renamed(boolean z_renamed) throws android.content.res.Resources.NotFoundException {
        com.oplus.camera.ui.control.a_renamed aVar = this.z_renamed;
        if (aVar != null) {
            if (z_renamed) {
                aVar.b_renamed(true, true);
            } else {
                aVar.h_renamed();
            }
        }
    }

    public void T_renamed(boolean z_renamed) {
        com.oplus.camera.ui.control.a_renamed aVar = this.z_renamed;
        if (aVar != null) {
            aVar.v_renamed(z_renamed);
        }
    }

    @Override // com.oplus.camera.ui.CameraUIInterface
    public void n_renamed(boolean z_renamed, boolean z2) {
        com.oplus.camera.ui.menu.setting.o_renamed oVar = this.H_renamed;
        if (oVar != null) {
            oVar.c_renamed(z_renamed, z2);
        }
        com.oplus.camera.ui.menu.setting.f_renamed fVar = this.I_renamed;
        if (fVar != null) {
            fVar.c_renamed(z_renamed, z2);
        }
    }

    @Override // com.oplus.camera.ui.CameraUIInterface
    public void a_renamed(boolean z_renamed, java.lang.String str) {
        int i_renamed;
        com.oplus.camera.ui.CameraUIListener cameraUIListener = this.J_renamed;
        if (cameraUIListener == null || this.B_renamed == null || this.i_renamed == null) {
            return;
        }
        if (com.oplus.camera.ui.preview.a_renamed.j_renamed.f6905a == this.B_renamed.getInt(cameraUIListener.aD_renamed(), com.oplus.camera.ui.preview.a_renamed.j_renamed.f6905a)) {
            if (z_renamed) {
                i_renamed = com.oplus.camera.R_renamed.drawable.menu_effect_off_light_selector;
            } else {
                i_renamed = (!com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_OPLUS_SUPPORT_GRAND_TOUR_FILTER) || com.oplus.camera.ui.preview.a_renamed.j_renamed.f6906b.equalsIgnoreCase(com.oplus.tblplayer.misc.MediaInfo.RENDERER_TYPE_NONE) || this.B_renamed.getBoolean(com.oplus.camera.ui.CameraUIInterface.PRE_MENU_FILTER_ICON_RECEOMMEND_CLICKED, false) || !com.oplus.camera.aps.constant.ApsConstant.CAPTURE_MODE_COMMON.equals(this.J_renamed.ao_renamed()) || com.oplus.camera.e_renamed.a_renamed.a_renamed(cv_renamed())) ? com.oplus.camera.R_renamed.drawable.menu_effect_off_selector : com.oplus.camera.R_renamed.drawable.menu_effect_grandtour_recommend;
            }
            b_renamed(str, i_renamed);
            return;
        }
        b_renamed(str, com.oplus.camera.R_renamed.drawable.menu_effect_on_selector);
    }

    @Override // com.oplus.camera.ui.CameraUIInterface
    public void d_renamed(java.lang.String str, int i_renamed) {
        com.oplus.camera.ui.menu.setting.o_renamed oVar = this.H_renamed;
        if (oVar != null) {
            oVar.c_renamed(str, i_renamed);
        }
    }

    public void a_renamed(final boolean z_renamed, final int i_renamed) {
        android.app.Activity activity = this.i_renamed;
        if (activity != null) {
            activity.runOnUiThread(new java.lang.Runnable() { // from class: com.oplus.camera.ui.d_renamed.14
                @Override // java.lang.Runnable
                public void run() {
                    if (com.oplus.camera.ui.d_renamed.this.aI_renamed == null) {
                        int screenWidth = com.oplus.camera.util.Util.getScreenWidth() / 2;
                        int top = (com.oplus.camera.ui.d_renamed.this.M_renamed == 0 || com.oplus.camera.ui.d_renamed.this.M_renamed == 2) ? com.oplus.camera.ui.d_renamed.this.A_renamed.y_renamed().getTop() + (com.oplus.camera.ui.d_renamed.this.A_renamed.y_renamed().getHeight() / 2) : com.oplus.camera.ui.d_renamed.this.i_renamed.getApplication().getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.gradienter_full_margin_top);
                        com.oplus.camera.e_renamed.b_renamed("CameraUIManager", "showGradienterView, top: " + com.oplus.camera.ui.d_renamed.this.A_renamed.y_renamed().getTop() + ", height: " + com.oplus.camera.ui.d_renamed.this.A_renamed.y_renamed().getHeight() + ", centerY: " + top + ", mSizeRatioType: " + com.oplus.camera.ui.d_renamed.this.M_renamed);
                        com.oplus.camera.ui.d_renamed dVar = com.oplus.camera.ui.d_renamed.this;
                        dVar.aI_renamed = new com.oplus.camera.ui.preview.q_renamed(dVar.i_renamed, screenWidth, top, i_renamed);
                        com.oplus.camera.ui.d_renamed.this.aI_renamed.setLayoutParams(new android.widget.RelativeLayout.LayoutParams(-1, -1));
                        com.oplus.camera.ui.d_renamed.this.Z_renamed.addView(com.oplus.camera.ui.d_renamed.this.aI_renamed);
                        com.oplus.camera.ui.d_renamed.this.aI_renamed.setVisibility(4);
                    }
                    if (com.oplus.camera.ui.d_renamed.this.aI_renamed == null || !z_renamed) {
                        return;
                    }
                    com.oplus.camera.ui.d_renamed.this.aI_renamed.a_renamed();
                }
            });
        }
    }

    public void a_renamed(int i_renamed, boolean z_renamed, java.lang.String str) {
        com.oplus.camera.e_renamed.b_renamed("CameraUIManager", "updateGradienterView, orientation: " + i_renamed);
        if (this.aI_renamed != null) {
            if (z_renamed && str.equals(com.oplus.camera.aps.constant.ApsConstant.CAPTURE_MODE_PROFESSIONAL)) {
                this.aI_renamed.setOrientation(i_renamed);
                this.aI_renamed.b_renamed();
            } else {
                this.aI_renamed.a_renamed(i_renamed);
            }
        }
    }

    public void bq_renamed() {
        com.oplus.camera.ui.preview.q_renamed qVar = this.aI_renamed;
        if (qVar == null || this.Z_renamed == null) {
            return;
        }
        qVar.c_renamed();
        this.Z_renamed.removeView(this.aI_renamed);
        this.aI_renamed = null;
    }

    public void a_renamed(int i_renamed, java.lang.String str, boolean z_renamed) {
        com.oplus.camera.ui.CameraUIListener cameraUIListener;
        com.oplus.camera.screen.g_renamed gVar = this.l_renamed;
        if (gVar != null) {
            gVar.d_renamed();
            this.bx_renamed = this.l_renamed.a_renamed();
            this.bx_renamed.a_renamed(this.i_renamed, (com.oplus.camera.screen.ScreenRelativeLayout) this.Z_renamed);
            this.ah_renamed.a_renamed(aX_renamed(), this.bx_renamed.k_renamed());
            this.I_renamed.a_renamed(aX_renamed(), this.bx_renamed.k_renamed(), this.bx_renamed.q_renamed());
            this.H_renamed.g_renamed(aX_renamed());
            this.aT_renamed.a_renamed(aX_renamed(), this.bx_renamed.k_renamed());
            this.ac_renamed.a_renamed(this.bx_renamed);
            com.oplus.camera.ui.preview.a_renamed aVar = this.aH_renamed;
            if (aVar != null) {
                aVar.h_renamed(aX_renamed());
            }
            if (com.oplus.camera.util.Util.t_renamed()) {
                this.bD_renamed = true;
                gj_renamed();
            }
            this.bC_renamed = false;
        }
        aF_renamed();
        com.oplus.camera.ui.b_renamed.a_renamed aVar2 = this.y_renamed;
        if (aVar2 != null) {
            aVar2.a_renamed();
        }
        com.oplus.camera.ui.preview.g_renamed gVar2 = this.A_renamed;
        if (gVar2 != null) {
            gVar2.e_renamed();
            if (!this.J_renamed.by_renamed()) {
                this.A_renamed.ao_renamed();
            }
        }
        com.oplus.camera.ui.preview.ae_renamed aeVar = this.D_renamed;
        if (aeVar != null) {
            aeVar.a_renamed(false, dY_renamed());
        }
        com.oplus.camera.ui.control.a_renamed aVar3 = this.z_renamed;
        if (aVar3 != null) {
            aVar3.a_renamed(i_renamed, str, z_renamed);
        }
        com.oplus.camera.ui.modepanel.p_renamed pVar = this.bd_renamed;
        if (pVar != null) {
            pVar.b_renamed(false);
            com.oplus.camera.ui.control.a_renamed aVar4 = this.z_renamed;
            if (aVar4 != null) {
                aVar4.av_renamed();
            }
            if (this.l_renamed != null) {
                this.bd_renamed.h_renamed(aX_renamed());
            }
            d_renamed(true, 1);
            com.oplus.camera.ui.CameraUIListener cameraUIListener2 = this.J_renamed;
            if (cameraUIListener2 != null) {
                cameraUIListener2.f_renamed(1);
            }
        }
        com.oplus.camera.ui.menu.levelcontrol.g_renamed gVar3 = this.ah_renamed;
        if (gVar3 != null) {
            gVar3.c_renamed();
            a_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_FILTER_MENU, this.ah_renamed);
            a_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_PORTRAIT_NEW_STYLE_MENU, this.ah_renamed);
            a_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_FILTER_MENU, this.ah_renamed);
            a_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_NIGHT_FILTER_MENU, this.ah_renamed);
            a_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_STREET_FILTER_MENU, this.ah_renamed);
        }
        com.oplus.camera.ui.menu.levelcontrol.c_renamed cVar = this.ai_renamed;
        if (cVar != null) {
            a_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_PORTRAIT_BLUR_MENU, cVar);
            a_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_BLUR_MENU, this.ai_renamed);
        }
        com.oplus.camera.ui.menu.levelcontrol.c_renamed cVar2 = this.aS_renamed;
        if (cVar2 != null) {
            a_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_TILT_SHIFT_BLUR_MENU, cVar2);
        }
        com.oplus.camera.ui.CameraUIListener cameraUIListener3 = this.J_renamed;
        if (cameraUIListener3 != null) {
            cameraUIListener3.a_renamed((com.oplus.camera.u_renamed.a_renamed) null);
            this.J_renamed.c_renamed(false);
        }
        fL_renamed();
        f_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_SIZE);
        f_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_FPS);
        f_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_SLOW_VIDEO_SIZE);
        f_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_FAST_VIDEO_SIZE);
        com.oplus.camera.j_renamed.a_renamed aVar5 = this.bg_renamed;
        if (aVar5 != null) {
            aVar5.e_renamed();
        }
        com.oplus.camera.doubleexposure.g_renamed gVar4 = this.bs_renamed;
        if (gVar4 != null) {
            gVar4.e_renamed();
            if (!this.bs_renamed.o_renamed() && (cameraUIListener = this.J_renamed) != null && cameraUIListener.h_renamed(com.oplus.camera.aps.config.CameraFunction.DOUBLE_EXPOSURE) && this.J_renamed.h_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_SUPPORT_SHARE_EDIT_THUMB)) {
                ar_renamed();
            }
        }
        if (this.J_renamed != null) {
            bU_renamed();
        }
        com.oplus.camera.ui.widget.SplitBackgroundView splitBackgroundView = this.aL_renamed;
        if (splitBackgroundView != null) {
            splitBackgroundView.setLightBackground(eQ_renamed());
        }
        com.oplus.camera.ui.menu.facebeauty.RotateAnimationView rotateAnimationView = this.aQ_renamed;
        if (rotateAnimationView != null) {
            rotateAnimationView.setLightBackground(eQ_renamed());
        }
        com.oplus.camera.ui.widget.SplitBackgroundView splitBackgroundView2 = this.aM_renamed;
        if (splitBackgroundView2 != null) {
            splitBackgroundView2.setLightBackground(eQ_renamed());
        }
        com.oplus.camera.ui.menu.facebeauty.g_renamed gVar5 = this.aT_renamed;
        if (gVar5 != null) {
            gVar5.e_renamed(this.M_renamed);
        }
        if (this.bx_renamed == null || !com.oplus.camera.util.Util.p_renamed(this.i_renamed)) {
            return;
        }
        fZ_renamed();
    }

    @Override // com.oplus.camera.ui.CameraUIInterface
    public void aF_renamed() {
        com.oplus.camera.ui.menu.setting.f_renamed fVar;
        com.oplus.camera.e_renamed.a_renamed("checkAndStartArrowAnimation");
        if (this.cm_renamed != null && !this.bj_renamed && this.B_renamed.getBoolean(com.oplus.camera.ui.CameraUIInterface.SHOW_ARROW_ANIMATION, false) && ((!this.B_renamed.getBoolean(com.oplus.camera.ui.CameraUIInterface.KEY_DRAWER_SHOW_GUIDE_ANIMATION, true) || !g_renamed) && (fVar = this.I_renamed) != null && fVar.s_renamed())) {
            this.cm_renamed.sendEmptyMessage(3);
        }
        com.oplus.camera.e_renamed.b_renamed("checkAndStartArrowAnimation");
    }

    public void b_renamed(boolean z_renamed, boolean z2, boolean z3) {
        com.oplus.camera.e_renamed.a_renamed("CameraUIManager", "onResumeMessage");
        this.p_renamed = false;
        this.q_renamed = false;
        com.oplus.camera.ui.control.a_renamed aVar = this.z_renamed;
        if (aVar != null) {
            aVar.j_renamed();
        }
        com.oplus.camera.ui.menu.setting.o_renamed oVar = this.H_renamed;
        if (oVar != null) {
            oVar.i_renamed();
        }
        com.oplus.camera.ui.menu.setting.f_renamed fVar = this.I_renamed;
        if (fVar != null) {
            fVar.i_renamed();
        }
        if (!this.n_renamed && !z_renamed && !z2) {
            V_renamed(z3);
        }
        if (this.K_renamed == 3) {
            q_renamed(false);
            j_renamed(false, false);
        }
        com.oplus.camera.ui.preview.g_renamed gVar = this.A_renamed;
        if (gVar != null) {
            if (gVar.u_renamed() && this.K_renamed == 2) {
                cl_renamed();
            }
            this.A_renamed.f_renamed();
        }
        com.oplus.camera.ui.a_renamed.a_renamed aVar2 = this.ac_renamed;
        if (aVar2 != null) {
            aVar2.h_renamed();
        }
        com.oplus.camera.ui.camerascreenhint.CameraScreenHintView cameraScreenHintView = this.aj_renamed;
        if (cameraScreenHintView != null) {
            cameraScreenHintView.c_renamed();
        }
        if (!com.oplus.camera.Camera.l_renamed) {
            a_renamed(com.oplus.camera.R_renamed.string.camera_low_battery_flash_disable);
        }
        if (!com.oplus.camera.Camera.m_renamed) {
            a_renamed(com.oplus.camera.R_renamed.string.camera_high_temperature_flash_disable);
        }
        cM_renamed();
        java.lang.String string = this.B_renamed.getString(com.oplus.camera.ui.CameraUIInterface.KEY_CAMERA_TAP_SHUTTER, this.i_renamed.getString(com.oplus.camera.R_renamed.string.camera_tap_shutter_default_value));
        if (this.J_renamed.h_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_CAMERA_TAP_SHUTTER) && string.equals("on_renamed") && fG_renamed() && this.aE_renamed != 2) {
            this.aE_renamed = (byte) 1;
        }
        if (this.aE_renamed == 1) {
            a_renamed(com.oplus.camera.R_renamed.string.camera_tab_shutter_toast, -1, true, false, false);
            this.aE_renamed = (byte) 2;
        }
    }

    public void U_renamed(boolean z_renamed) {
        com.oplus.camera.ui.control.a_renamed aVar = this.z_renamed;
        if (aVar != null) {
            aVar.g_renamed(z_renamed);
        }
    }

    public void b_renamed(com.oplus.camera.ui.control.b_renamed bVar, boolean z_renamed) throws android.content.res.Resources.NotFoundException {
        com.oplus.camera.ui.control.a_renamed aVar;
        android.view.ViewGroup viewGroup;
        com.oplus.camera.e_renamed.a_renamed("CameraUIManager", "onPause");
        this.p_renamed = true;
        this.aE_renamed = (byte) 0;
        this.P_renamed = 0;
        this.O_renamed = 0;
        this.s_renamed = false;
        this.v_renamed = false;
        this.M_renamed = -1;
        this.be_renamed = false;
        this.bj_renamed = false;
        this.j_renamed.a_renamed();
        this.k_renamed.d_renamed();
        dl_renamed();
        com.oplus.camera.screen.g_renamed gVar = this.l_renamed;
        if (gVar != null) {
            gVar.e_renamed();
        }
        if (fG_renamed()) {
            android.content.SharedPreferences.Editor editorEdit = this.B_renamed.edit();
            editorEdit.putString(com.oplus.camera.ui.CameraUIInterface.KEY_LAST_CAMERA_TAP_SHUTTER, this.B_renamed.getString(com.oplus.camera.ui.CameraUIInterface.KEY_CAMERA_TAP_SHUTTER, this.i_renamed.getString(com.oplus.camera.R_renamed.string.camera_tap_shutter_default_value)));
            editorEdit.apply();
        }
        android.os.Handler handler = this.cm_renamed;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        com.oplus.camera.ui.b_renamed.a_renamed aVar2 = this.y_renamed;
        if (aVar2 != null) {
            aVar2.b_renamed();
        }
        com.oplus.camera.ui.menu.setting.o_renamed oVar = this.H_renamed;
        if (oVar != null) {
            oVar.g_renamed();
        }
        at_renamed(true);
        dz_renamed();
        com.oplus.camera.ui.menu.setting.f_renamed fVar = this.I_renamed;
        if (fVar != null) {
            fVar.g_renamed();
        }
        com.oplus.camera.ui.menu.g_renamed.g_renamed();
        com.oplus.camera.ui.control.a_renamed aVar3 = this.z_renamed;
        if (aVar3 != null) {
            aVar3.a_renamed(bVar, z_renamed);
        }
        com.oplus.camera.ui.preview.g_renamed gVar2 = this.A_renamed;
        if (gVar2 != null) {
            gVar2.h_renamed();
        }
        com.oplus.camera.ui.preview.ae_renamed aeVar = this.D_renamed;
        if (aeVar != null) {
            aeVar.d_renamed();
        }
        com.oplus.camera.ui.preview.i_renamed iVar = this.E_renamed;
        if (iVar != null) {
            iVar.d_renamed();
        }
        android.view.View view = this.al_renamed;
        if (view != null) {
            view.setVisibility(8);
        }
        com.oplus.camera.ui.a_renamed.a_renamed aVar4 = this.ac_renamed;
        if (aVar4 != null) {
            aVar4.i_renamed();
        }
        com.oplus.camera.ui.menu.levelcontrol.g_renamed gVar3 = this.ah_renamed;
        if (gVar3 != null) {
            gVar3.d_renamed();
        }
        com.oplus.camera.ui.menu.levelcontrol.c_renamed cVar = this.ai_renamed;
        if (cVar != null) {
            if (cVar.isMenuOpen()) {
                this.ai_renamed.hideMenu(false, false, false, true);
            }
            this.ai_renamed.setVideoRecordingHideMenu(false);
        }
        com.oplus.camera.ui.menu.levelcontrol.c_renamed cVar2 = this.aS_renamed;
        if (cVar2 != null) {
            if (cVar2.isMenuOpen()) {
                this.aS_renamed.hideMenu(false, false, false, true);
            }
            this.aS_renamed.setVideoRecordingHideMenu(false);
        }
        com.oplus.camera.ui.camerascreenhint.CameraScreenHintView cameraScreenHintView = this.aj_renamed;
        if (cameraScreenHintView != null) {
            this.Z_renamed.removeView(cameraScreenHintView);
            this.aj_renamed = null;
        }
        com.oplus.camera.ui.camerascreenhint.CameraScreenHintView cameraScreenHintView2 = this.am_renamed;
        if (cameraScreenHintView2 != null && (viewGroup = this.Z_renamed) != null) {
            viewGroup.removeView(cameraScreenHintView2);
            this.am_renamed = null;
        }
        com.oplus.camera.ui.menu.facebeauty.g_renamed gVar4 = this.aT_renamed;
        if (gVar4 != null) {
            if (gVar4.n_renamed()) {
                a_renamed(false, true, true, false);
            }
            this.aT_renamed.g_renamed(false);
        }
        java.util.Map<java.lang.String, com.oplus.camera.ui.menu.setting.q_renamed> map = this.aG_renamed;
        if (map != null) {
            map.clear();
        }
        com.oplus.camera.ui.preview.b_renamed bVar2 = this.bk_renamed;
        if (bVar2 != null) {
            bVar2.a_renamed(true);
            if (this.bk_renamed.c_renamed()) {
                com.oplus.camera.j_renamed.a_renamed().c_renamed();
            }
        }
        com.oplus.camera.ui.modepanel.p_renamed pVar = this.bd_renamed;
        if (pVar != null) {
            pVar.k_renamed();
        }
        this.aK_renamed = null;
        c_renamed(true);
        v_renamed(true);
        du_renamed();
        eY_renamed();
        bq_renamed();
        N_renamed();
        com.oplus.camera.ui.menu.levelcontrol.r_renamed rVar = this.ak_renamed;
        if (rVar != null) {
            rVar.a_renamed();
        }
        com.oplus.camera.ui.menu.facebeauty.g_renamed gVar5 = this.aT_renamed;
        if (gVar5 != null) {
            gVar5.p_renamed();
        }
        com.oplus.camera.j_renamed.a_renamed aVar5 = this.bg_renamed;
        if (aVar5 != null) {
            aVar5.f_renamed();
        }
        com.oplus.camera.doubleexposure.g_renamed gVar6 = this.bs_renamed;
        if (gVar6 != null) {
            gVar6.c_renamed();
        }
        if (aA_renamed()) {
            c_renamed(false, false, true, true);
            J_renamed(false);
        }
        if (ex_renamed()) {
            s_renamed(false, false);
        }
        if (this.aC_renamed != null) {
            f_renamed(18, true);
        }
        if (com.oplus.camera.util.Util.u_renamed() && this.bH_renamed != null && (aVar = this.z_renamed) != null && aVar.k_renamed() && !this.z_renamed.l_renamed()) {
            this.bH_renamed.a_renamed(false);
            android.view.ViewGroup viewGroup2 = this.bF_renamed;
            if (viewGroup2 != null) {
                if (this.r_renamed) {
                    viewGroup2.setVisibility(4);
                } else {
                    com.oplus.camera.util.Util.b_renamed(viewGroup2);
                }
            }
        }
        az_renamed(false);
        n_renamed();
    }

    public void br_renamed() {
        com.oplus.camera.e_renamed.a_renamed("CameraUIManager", "onStop");
        if (this.cn_renamed != null && eG_renamed()) {
            this.cn_renamed.a_renamed();
        }
        com.oplus.camera.ui.modepanel.p_renamed pVar = this.bd_renamed;
        if (pVar != null) {
            pVar.j_renamed();
        }
        com.oplus.camera.screen.g_renamed gVar = this.l_renamed;
        if (gVar != null) {
            gVar.f_renamed();
        }
        if (this.K_renamed == 2) {
            cl_renamed();
        }
        com.oplus.camera.ui.preview.g_renamed gVar2 = this.A_renamed;
        if (gVar2 != null) {
            gVar2.i_renamed();
        }
        com.oplus.camera.ui.control.a_renamed aVar = this.z_renamed;
        if (aVar != null) {
            aVar.m_renamed();
        }
        com.oplus.camera.ComboPreferences comboPreferences = this.B_renamed;
        if (comboPreferences == null || !comboPreferences.getBoolean("pref_camera_statement_key", false)) {
            return;
        }
        fc_renamed();
    }

    public void bs_renamed() {
        androidx.recyclerview.widget.RecyclerView.c_renamed cVar;
        com.oplus.camera.e_renamed.a_renamed("CameraUIManager", "onDestroy");
        if (!this.cc_renamed.isEmpty()) {
            this.cc_renamed.clear();
        }
        this.aL_renamed = null;
        this.aM_renamed = null;
        this.by_renamed = null;
        this.ah_renamed = null;
        this.aJ_renamed = null;
        this.ai_renamed = null;
        this.J_renamed = null;
        this.i_renamed = null;
        this.C_renamed = null;
        this.aT_renamed = null;
        android.os.Handler handler = this.cm_renamed;
        if (handler != null) {
            handler.removeMessages(5);
            this.cm_renamed.removeMessages(11);
        }
        com.oplus.camera.ui.k_renamed kVar = this.bH_renamed;
        if (kVar != null && (cVar = this.cd_renamed) != null) {
            kVar.unregisterAdapterDataObserver(cVar);
        }
        com.oplus.camera.timelapsepro.g_renamed gVar = this.bP_renamed;
        if (gVar != null) {
            gVar.q_renamed();
            this.Z_renamed.removeView(this.bP_renamed);
            this.bP_renamed = null;
        }
        com.oplus.camera.timelapsepro.i_renamed iVar = this.bR_renamed;
        if (iVar != null) {
            iVar.b_renamed();
            this.Z_renamed.removeView(this.bR_renamed);
            this.bR_renamed = null;
        }
        com.oplus.camera.screen.g_renamed gVar2 = this.l_renamed;
        if (gVar2 != null) {
            gVar2.g_renamed();
        }
        com.oplus.camera.ui.b_renamed.a_renamed aVar = this.y_renamed;
        if (aVar != null) {
            aVar.c_renamed();
            this.y_renamed = null;
        }
        com.oplus.camera.ui.control.a_renamed aVar2 = this.z_renamed;
        if (aVar2 != null) {
            aVar2.n_renamed();
            this.z_renamed = null;
        }
        com.oplus.camera.ui.modepanel.p_renamed pVar = this.bd_renamed;
        if (pVar != null) {
            pVar.f_renamed();
            this.bd_renamed = null;
            this.bt_renamed = null;
        }
        com.oplus.camera.ui.menu.setting.o_renamed oVar = this.H_renamed;
        if (oVar != null) {
            oVar.h_renamed();
            this.H_renamed = null;
        }
        com.oplus.camera.ui.menu.setting.f_renamed fVar = this.I_renamed;
        if (fVar != null) {
            fVar.h_renamed();
            this.I_renamed = null;
        }
        com.oplus.camera.ui.preview.g_renamed gVar3 = this.A_renamed;
        if (gVar3 != null) {
            gVar3.j_renamed();
            this.A_renamed = null;
        }
        android.view.ViewGroup viewGroup = this.Z_renamed;
        if (viewGroup != null) {
            viewGroup.removeAllViewsInLayout();
            this.Z_renamed.removeAllViews();
            this.Z_renamed = null;
        }
        com.oplus.camera.ui.preview.a_renamed aVar3 = this.aH_renamed;
        if (aVar3 != null) {
            aVar3.d_renamed();
            this.aH_renamed.k_renamed();
            this.aH_renamed = null;
        }
        com.oplus.camera.ui.preview.ae_renamed aeVar = this.D_renamed;
        if (aeVar != null) {
            aeVar.i_renamed();
            this.D_renamed = null;
        }
        com.oplus.camera.j_renamed.a_renamed aVar4 = this.bg_renamed;
        if (aVar4 != null) {
            aVar4.g_renamed();
            this.bg_renamed = null;
        }
        if (this.ar_renamed != null) {
            this.ar_renamed = null;
        }
        com.oplus.camera.ui.preview.b_renamed bVar = this.bk_renamed;
        if (bVar != null) {
            bVar.d_renamed();
            this.bk_renamed = null;
        }
        com.oplus.camera.doubleexposure.g_renamed gVar4 = this.bs_renamed;
        if (gVar4 != null) {
            gVar4.d_renamed();
            this.bs_renamed = null;
        }
        com.oplus.camera.ui.preview.i_renamed iVar2 = this.E_renamed;
        if (iVar2 != null) {
            iVar2.i_renamed();
            this.E_renamed = null;
        }
        if (this.bx_renamed != null) {
            this.bx_renamed = null;
        }
        com.oplus.camera.screen.a_renamed.b_renamed bVar2 = this.k_renamed;
        if (bVar2 != null) {
            bVar2.c_renamed();
        }
        com.oplus.camera.ui.j_renamed jVar = this.bG_renamed;
        if (jVar != null) {
            jVar.c_renamed();
            this.bG_renamed = null;
        }
    }

    public void g_renamed(int i_renamed, boolean z_renamed) {
        com.oplus.camera.ui.preview.a_renamed aVar = this.aH_renamed;
        if (aVar != null) {
            aVar.a_renamed(i_renamed, z_renamed);
        }
    }

    public void V_renamed(boolean z_renamed) {
        bt_renamed();
        c_renamed(0);
        i_renamed(true);
        com.oplus.camera.ui.control.a_renamed aVar = this.z_renamed;
        if (aVar != null) {
            aVar.i_renamed(0);
        }
        if (z_renamed) {
            V_renamed(this.M_renamed);
            a_renamed(false, true);
            return;
        }
        if (this.J_renamed.h_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_FILTER_PROCESS)) {
            r_renamed(false);
        } else {
            q_renamed(false);
        }
        if (this.J_renamed.bl_renamed()) {
            l_renamed(false, false);
        } else {
            j_renamed(false, false);
        }
        if (this.J_renamed.bm_renamed()) {
            i_renamed(false, false);
        } else {
            h_renamed(false, false);
        }
        if (this.J_renamed.bn_renamed() && !this.J_renamed.c_renamed()) {
            if (!com.oplus.camera.e_renamed.a_renamed.a_renamed(cv_renamed())) {
                o_renamed(true, false);
                q_renamed(true, false);
            }
        } else {
            p_renamed(false, false);
            r_renamed(false, false);
        }
        if (j_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_TIME_LAPSE_PRO)) {
            N_renamed(true);
        } else {
            O_renamed(true);
        }
        ay_renamed(false);
        if (fE_renamed()) {
            M_renamed();
        } else {
            N_renamed();
        }
        if (this.J_renamed.by_renamed()) {
            return;
        }
        h_renamed(this.M_renamed, false);
    }

    public void bt_renamed() {
        com.oplus.camera.ui.control.a_renamed aVar = this.z_renamed;
        if (aVar != null) {
            aVar.a_renamed(true);
        }
    }

    public void W_renamed(boolean z_renamed) {
        com.oplus.camera.ui.menu.setting.o_renamed oVar = this.H_renamed;
        if (oVar != null) {
            oVar.e_renamed(z_renamed);
        }
        com.oplus.camera.ui.menu.setting.f_renamed fVar = this.I_renamed;
        if (fVar != null) {
            fVar.e_renamed(z_renamed);
        }
    }

    public void bu_renamed() {
        com.oplus.camera.ui.menu.setting.f_renamed fVar = this.I_renamed;
        if (fVar != null) {
            fVar.E_renamed();
        }
    }

    public void bv_renamed() {
        if (this.H_renamed == null || 3 != aX_renamed()) {
            return;
        }
        this.H_renamed.Q_renamed();
    }

    public void b_renamed(com.oplus.camera.ui.control.b_renamed bVar) {
        com.oplus.camera.e_renamed.a_renamed("CameraUIManager", "switchToModeType, buttonType: " + bVar.a_renamed() + ", insideColor: " + bVar.b_renamed() + ", shape: " + bVar.d_renamed());
        com.oplus.camera.ui.menu.g_renamed.a_renamed(false);
        this.s_renamed = false;
        this.O_renamed = 0;
        android.os.Handler handler = this.cm_renamed;
        if (handler != null) {
            handler.removeMessages(1);
        }
        if (bz_renamed()) {
            cy_renamed();
        }
        if (this.K_renamed != 3) {
            this.z_renamed.a_renamed(bVar);
        }
        com.oplus.camera.ui.menu.facebeauty.g_renamed gVar = this.aT_renamed;
        if (gVar != null) {
            gVar.k_renamed();
        }
    }

    public void a_renamed(java.lang.String str, com.oplus.camera.ui.control.b_renamed bVar, boolean z_renamed) {
        if (this.z_renamed != null) {
            if (!dS_renamed()) {
                this.z_renamed.a_renamed(bVar, z_renamed, true);
            } else {
                this.z_renamed.a_renamed(8, 300);
            }
            if (this.K_renamed != 3 && !this.p_renamed && !this.J_renamed.bh_renamed() && !dS_renamed()) {
                this.z_renamed.a_renamed(false);
            }
        }
        if (this.K_renamed != 3) {
            this.J_renamed.y_renamed();
            W_renamed(true);
        }
        if (!this.J_renamed.h_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_FILTER_PROCESS)) {
            q_renamed(false);
        }
        if (fE_renamed()) {
            M_renamed();
        } else {
            N_renamed();
        }
        e_renamed(false, false);
        if (!this.J_renamed.aX_renamed()) {
            a_renamed(com.oplus.camera.R_renamed.string.camera_dark_environment_open_flash_toast);
        }
        if (el_renamed()) {
            a_renamed(true, false, false);
        }
        if (!this.J_renamed.by_renamed() || dS_renamed()) {
            return;
        }
        d_renamed(0);
    }

    public void bw_renamed() {
        com.oplus.camera.ui.control.a_renamed aVar = this.z_renamed;
        if (aVar != null) {
            aVar.o_renamed();
        }
    }

    public void bx_renamed() {
        com.oplus.camera.ui.control.a_renamed aVar = this.z_renamed;
        if (aVar != null) {
            aVar.p_renamed();
        }
    }

    public void a_renamed(java.util.List<java.lang.String> list, java.lang.String str, int i_renamed) {
        com.oplus.camera.ui.menu.levelcontrol.g_renamed gVar = this.ah_renamed;
        if (gVar != null) {
            gVar.a_renamed(list, str, i_renamed);
        }
    }

    public boolean by_renamed() {
        return this.n_renamed;
    }

    public void A_renamed(int i_renamed) {
        this.N_renamed = i_renamed;
        com.oplus.camera.ui.preview.g_renamed gVar = this.A_renamed;
        if (gVar != null) {
            gVar.d_renamed(i_renamed);
        }
    }

    @Override // com.oplus.camera.ui.CameraUIInterface
    public void a_renamed(com.oplus.camera.gl_renamed.t_renamed.b_renamed bVar, boolean z_renamed, boolean z2, java.lang.String str) {
        com.oplus.camera.ui.preview.g_renamed gVar = this.A_renamed;
        if (gVar != null) {
            gVar.a_renamed(bVar, z_renamed, z2, str);
        }
    }

    @Override // com.oplus.camera.ui.CameraUIInterface
    public void n_renamed(boolean z_renamed) {
        com.oplus.camera.ui.preview.g_renamed gVar = this.A_renamed;
        if (gVar != null) {
            gVar.c_renamed(z_renamed);
        }
    }

    @Override // com.oplus.camera.ui.CameraUIInterface
    public void o_renamed(boolean z_renamed) {
        com.oplus.camera.ui.preview.g_renamed gVar = this.A_renamed;
        if (gVar != null) {
            gVar.d_renamed(z_renamed);
        }
    }

    @Override // com.oplus.camera.ui.CameraUIInterface
    public void a_renamed(int i_renamed, long j_renamed, long j2) {
        com.oplus.camera.ui.preview.g_renamed gVar = this.A_renamed;
        if (gVar != null) {
            gVar.a_renamed(i_renamed, j_renamed, j2);
        }
    }

    public long B_renamed(int i_renamed) {
        com.oplus.camera.ui.preview.g_renamed gVar = this.A_renamed;
        if (gVar != null) {
            return gVar.e_renamed(i_renamed);
        }
        return 0L;
    }

    public boolean bz_renamed() {
        com.oplus.camera.ui.CameraUIListener cameraUIListener = this.J_renamed;
        if (cameraUIListener != null) {
            return cameraUIListener.J_renamed();
        }
        return false;
    }

    @Override // com.oplus.camera.ui.preview.g_renamed.b_renamed
    public void bA_renamed() {
        com.oplus.camera.ui.CameraUIListener cameraUIListener = this.J_renamed;
        if (cameraUIListener != null) {
            cameraUIListener.S_renamed();
        }
    }

    @Override // com.oplus.camera.ui.preview.g_renamed.b_renamed
    public void a_renamed(int i_renamed, int i2, long j_renamed) {
        com.oplus.camera.ui.CameraUIListener cameraUIListener = this.J_renamed;
        if (cameraUIListener != null) {
            cameraUIListener.a_renamed(i_renamed, i2, j_renamed);
        }
    }

    @Override // com.oplus.camera.ui.preview.g_renamed.b_renamed
    public void f_renamed(int i_renamed, int i2) {
        com.oplus.camera.ui.CameraUIListener cameraUIListener = this.J_renamed;
        if (cameraUIListener != null) {
            cameraUIListener.c_renamed(i_renamed, i2);
        }
    }

    @Override // com.oplus.camera.ui.CameraUIInterface, com.oplus.camera.ui.preview.g_renamed.b_renamed
    public boolean aw_renamed() {
        com.oplus.camera.ui.CameraUIListener cameraUIListener = this.J_renamed;
        if (cameraUIListener != null) {
            return cameraUIListener.ah_renamed();
        }
        return false;
    }

    @Override // com.oplus.camera.ui.CameraUIInterface
    public boolean ax_renamed() {
        com.oplus.camera.ui.CameraUIListener cameraUIListener = this.J_renamed;
        if (cameraUIListener != null) {
            return cameraUIListener.l_renamed();
        }
        return false;
    }

    @Override // com.oplus.camera.ui.preview.g_renamed.b_renamed
    public boolean bB_renamed() {
        com.oplus.camera.ui.CameraUIListener cameraUIListener = this.J_renamed;
        if (cameraUIListener != null) {
            return cameraUIListener.aj_renamed();
        }
        return false;
    }

    @Override // com.oplus.camera.ui.preview.g_renamed.b_renamed
    public float a_renamed(float f_renamed) {
        com.oplus.camera.ui.CameraUIListener cameraUIListener = this.J_renamed;
        if (cameraUIListener != null) {
            return cameraUIListener.a_renamed(f_renamed);
        }
        return 0.0f;
    }

    @Override // com.oplus.camera.ui.preview.g_renamed.b_renamed
    public void bC_renamed() {
        com.oplus.camera.ui.CameraUIListener cameraUIListener = this.J_renamed;
        if (cameraUIListener != null) {
            cameraUIListener.ak_renamed();
        }
    }

    @Override // com.oplus.camera.ui.CameraUIInterface
    public void F_renamed(boolean z_renamed) {
        com.oplus.camera.ui.CameraUIListener cameraUIListener = this.J_renamed;
        if (cameraUIListener != null) {
            cameraUIListener.b_renamed(z_renamed);
        }
    }

    @Override // com.oplus.camera.ui.CameraUIInterface
    public boolean ay_renamed() {
        com.oplus.camera.ui.CameraUIListener cameraUIListener = this.J_renamed;
        if (cameraUIListener != null) {
            return cameraUIListener.am_renamed();
        }
        return false;
    }

    @Override // com.oplus.camera.ui.CameraUIInterface
    public boolean e_renamed(int i_renamed, int i2) {
        return com.oplus.camera.util.Util.a_renamed(bD_renamed(), i_renamed, i2);
    }

    @Override // com.oplus.camera.ui.CameraUIInterface
    public boolean bd_renamed() {
        com.oplus.camera.ui.CameraUIListener cameraUIListener = this.J_renamed;
        return cameraUIListener != null && (com.oplus.camera.aps.constant.ApsConstant.CAPTURE_MODE_MICROSCOPE.equals(cameraUIListener.ao_renamed()) || (this.J_renamed.ap_renamed() && eP_renamed()));
    }

    private boolean eP_renamed() {
        com.oplus.camera.ComboPreferences comboPreferences = this.B_renamed;
        return comboPreferences != null && "square".equals(comboPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_PHOTO_RATIO, null));
    }

    public com.oplus.camera.ui.control.ShutterButton bD_renamed() {
        com.oplus.camera.ui.control.a_renamed aVar = this.z_renamed;
        if (aVar != null) {
            return aVar.r_renamed();
        }
        return null;
    }

    public void i_renamed(java.lang.String str) {
        com.oplus.camera.ui.control.a_renamed aVar = this.z_renamed;
        if (aVar != null) {
            aVar.a_renamed(str);
        }
    }

    public com.oplus.camera.ui.control.e_renamed bE_renamed() {
        com.oplus.camera.ui.control.a_renamed aVar = this.z_renamed;
        if (aVar != null) {
            return aVar.t_renamed();
        }
        return null;
    }

    public int bF_renamed() {
        com.oplus.camera.ui.control.a_renamed aVar = this.z_renamed;
        if (aVar != null) {
            return aVar.u_renamed();
        }
        return 0;
    }

    public android.util.Size bG_renamed() {
        return this.A_renamed.w_renamed();
    }

    public void a_renamed(android.util.Size size) {
        this.bi_renamed = size;
    }

    @Override // com.oplus.camera.ui.CameraUIInterface
    public com.oplus.camera.ui.preview.h_renamed c_renamed() {
        com.oplus.camera.ui.preview.g_renamed gVar = this.A_renamed;
        if (gVar != null) {
            return gVar.x_renamed();
        }
        return null;
    }

    public com.oplus.camera.ui.menu.setting.f_renamed bH_renamed() {
        return this.I_renamed;
    }

    public com.oplus.camera.ui.preview.g_renamed bI_renamed() {
        return this.A_renamed;
    }

    @Override // com.oplus.camera.ui.CameraUIInterface
    public android.widget.RelativeLayout p_renamed() {
        com.oplus.camera.ui.preview.g_renamed gVar = this.A_renamed;
        if (gVar != null) {
            return gVar.y_renamed();
        }
        return null;
    }

    public android.graphics.Rect bJ_renamed() {
        com.oplus.camera.ui.preview.g_renamed gVar = this.A_renamed;
        if (gVar != null) {
            return gVar.J_renamed();
        }
        return null;
    }

    @Override // com.oplus.camera.ui.CameraUIInterface
    public void a_renamed(android.view.View view, java.lang.String str, int i_renamed, boolean z_renamed) {
        java.util.concurrent.ConcurrentHashMap<java.lang.Integer, android.view.View> concurrentHashMap = this.aF_renamed.get(str);
        if (concurrentHashMap == null) {
            concurrentHashMap = new java.util.concurrent.ConcurrentHashMap<>();
        }
        android.view.View view2 = concurrentHashMap.get(java.lang.Integer.valueOf(i_renamed));
        if (z_renamed && view2 != null) {
            this.Z_renamed.removeView(view2);
            view2 = null;
        }
        if (view2 == null && this.Z_renamed.indexOfChild(view) == -1) {
            view.setTag(com.oplus.camera.R_renamed.id_renamed.tag_name_specific_mode_view_type, java.lang.Integer.valueOf(i_renamed));
            this.Z_renamed.addView(view);
        }
        view.clearAnimation();
        concurrentHashMap.put(java.lang.Integer.valueOf(i_renamed), view);
        this.aF_renamed.put(str, concurrentHashMap);
    }

    @Override // com.oplus.camera.ui.CameraUIInterface
    public void b_renamed(java.lang.String str, boolean z_renamed) {
        for (java.lang.String str2 : this.aF_renamed.keySet()) {
            a_renamed(this.aF_renamed.get(str2), android.text.TextUtils.equals(str2, str), z_renamed, str2);
        }
    }

    public void a_renamed(java.util.concurrent.ConcurrentHashMap<java.lang.Integer, android.view.View> concurrentHashMap, final boolean z_renamed, boolean z2, final java.lang.String str) throws android.content.res.Resources.NotFoundException {
        if (concurrentHashMap != null) {
            for (final android.view.View view : concurrentHashMap.values()) {
                if (view != null) {
                    if (z2) {
                        view.clearAnimation();
                        final java.lang.Object tag = view.getTag(com.oplus.camera.R_renamed.id_renamed.tag_name_specific_mode_view_type);
                        if (!z_renamed && tag != null) {
                            concurrentHashMap.remove(tag);
                        }
                        com.oplus.camera.util.Util.a_renamed(view, z_renamed ? 0 : 8, new android.view.animation.Animation.AnimationListener() { // from class: com.oplus.camera.ui.d_renamed.15
                            @Override // android.view.animation.Animation.AnimationListener
                            public void onAnimationRepeat(android.view.animation.Animation animation) {
                            }

                            @Override // android.view.animation.Animation.AnimationListener
                            public void onAnimationStart(android.view.animation.Animation animation) {
                                if (com.oplus.camera.ui.d_renamed.this.J_renamed != null) {
                                    com.oplus.camera.ui.d_renamed.this.J_renamed.a_renamed(str, tag, z_renamed, false);
                                }
                                android.view.View view2 = view;
                                if (view2 != null) {
                                    view2.setVisibility(z_renamed ? 0 : 8);
                                }
                                com.oplus.camera.ui.d_renamed.this.z_renamed(true);
                            }

                            @Override // android.view.animation.Animation.AnimationListener
                            public void onAnimationEnd(android.view.animation.Animation animation) {
                                if (com.oplus.camera.ui.d_renamed.this.J_renamed != null) {
                                    com.oplus.camera.ui.d_renamed.this.J_renamed.a_renamed(str, tag, z_renamed, true);
                                }
                            }
                        }, 300, 0L, android.view.animation.AnimationUtils.loadInterpolator(view.getContext(), com.oplus.camera.R_renamed.anim.specific_view_alpha_interpolator));
                    } else {
                        java.lang.Object tag2 = view.getTag(com.oplus.camera.R_renamed.id_renamed.tag_name_specific_mode_view_type);
                        if (!z_renamed) {
                            view.setVisibility(8);
                            if (tag2 != null) {
                                concurrentHashMap.remove(tag2);
                            }
                        } else {
                            view.setVisibility(0);
                        }
                        this.J_renamed.a_renamed(str, tag2, z_renamed, true);
                    }
                }
            }
        }
    }

    public boolean bK_renamed() {
        return com.oplus.camera.ui.menu.g_renamed.a_renamed();
    }

    public void C_renamed(int i_renamed) {
        this.K_renamed = i_renamed;
        com.oplus.camera.ui.control.a_renamed aVar = this.z_renamed;
        if (aVar != null) {
            aVar.f_renamed(this.K_renamed);
        }
        com.oplus.camera.ui.menu.setting.o_renamed oVar = this.H_renamed;
        if (oVar != null) {
            oVar.e_renamed(this.K_renamed);
        }
        com.oplus.camera.ui.menu.setting.f_renamed fVar = this.I_renamed;
        if (fVar != null) {
            fVar.e_renamed(this.K_renamed);
        }
        com.oplus.camera.ui.preview.g_renamed gVar = this.A_renamed;
        if (gVar != null) {
            gVar.b_renamed(this.K_renamed);
        }
    }

    public void a_renamed(com.oplus.camera.ui.control.CameraControlButtonListener cameraControlButtonListener) {
        com.oplus.camera.ui.control.a_renamed aVar = this.z_renamed;
        if (aVar != null) {
            aVar.a_renamed(cameraControlButtonListener);
        }
    }

    public void a_renamed(com.oplus.camera.ui.preview.h_renamed.d_renamed dVar) {
        com.oplus.camera.ui.preview.g_renamed gVar = this.A_renamed;
        if (gVar != null) {
            gVar.a_renamed(dVar);
        }
    }

    public void a_renamed(com.oplus.camera.ui.control.f_renamed fVar) {
        com.oplus.camera.ui.control.a_renamed aVar = this.z_renamed;
        if (aVar != null) {
            aVar.a_renamed(fVar);
        }
    }

    public void b_renamed(android.view.View.OnClickListener onClickListener) {
        this.aN_renamed = onClickListener;
        com.oplus.camera.ui.widget.SplitBackgroundView splitBackgroundView = this.aM_renamed;
        if (splitBackgroundView != null) {
            splitBackgroundView.setOnClickListener(onClickListener);
        }
    }

    public void X_renamed(boolean z_renamed) {
        com.oplus.camera.ui.preview.g_renamed gVar = this.A_renamed;
        if (gVar != null) {
            gVar.e_renamed(z_renamed);
        }
    }

    public void a_renamed(android.graphics.Rect rect, android.util.Size size) {
        com.oplus.camera.ui.preview.g_renamed gVar = this.A_renamed;
        if (gVar != null) {
            gVar.a_renamed(rect, size);
        }
    }

    public void a_renamed(android.graphics.Rect rect, android.graphics.Rect rect2, android.util.Size size) {
        com.oplus.camera.ui.preview.g_renamed gVar = this.A_renamed;
        if (gVar != null) {
            gVar.a_renamed(rect, rect2, size);
        }
    }

    public void b_renamed(float f_renamed) {
        com.oplus.camera.ui.preview.g_renamed gVar = this.A_renamed;
        if (gVar != null) {
            gVar.a_renamed(f_renamed);
        }
    }

    public void c_renamed(float f_renamed) {
        com.oplus.camera.ui.preview.g_renamed gVar = this.A_renamed;
        if (gVar != null) {
            gVar.b_renamed(f_renamed);
        }
    }

    public void d_renamed(float f_renamed) {
        com.oplus.camera.ui.preview.g_renamed gVar = this.A_renamed;
        if (gVar != null) {
            gVar.c_renamed(f_renamed);
        }
    }

    public void a_renamed(android.hardware.camera2.params.Face[] faceArr, int[] iArr) {
        com.oplus.camera.ui.preview.g_renamed gVar;
        if (dH_renamed() || (gVar = this.A_renamed) == null) {
            return;
        }
        gVar.a_renamed(faceArr, iArr);
    }

    public void c_renamed(int[] iArr) {
        com.oplus.camera.ui.preview.g_renamed gVar;
        if (dH_renamed() || (gVar = this.A_renamed) == null) {
            return;
        }
        gVar.a_renamed(iArr);
    }

    public void Y_renamed(boolean z_renamed) {
        com.oplus.camera.ui.preview.g_renamed gVar = this.A_renamed;
        if (gVar != null) {
            gVar.j_renamed(z_renamed);
        }
    }

    public void D_renamed(int i_renamed) {
        com.oplus.camera.ui.preview.g_renamed gVar = this.A_renamed;
        if (gVar != null) {
            gVar.f_renamed(i_renamed);
        }
    }

    public void E_renamed(int i_renamed) throws android.content.res.Resources.NotFoundException {
        this.l_renamed.a_renamed(i_renamed);
        this.L_renamed = this.l_renamed.b_renamed();
        com.oplus.camera.util.o_renamed.a_renamed(ei_renamed());
        com.oplus.camera.ui.control.a_renamed aVar = this.z_renamed;
        if (aVar != null) {
            aVar.g_renamed(this.L_renamed);
        }
        com.oplus.camera.ui.menu.setting.o_renamed oVar = this.H_renamed;
        if (oVar != null) {
            oVar.f_renamed(this.L_renamed);
        }
        com.oplus.camera.ui.menu.setting.f_renamed fVar = this.I_renamed;
        if (fVar != null) {
            fVar.f_renamed(this.L_renamed);
        }
        com.oplus.camera.ui.preview.g_renamed gVar = this.A_renamed;
        if (gVar != null) {
            gVar.c_renamed(this.L_renamed);
        }
        int iEX = eX_renamed();
        com.oplus.camera.ui.preview.ae_renamed aeVar = this.D_renamed;
        if (aeVar != null && iEX != aeVar.c_renamed()) {
            this.D_renamed.b_renamed(eW_renamed(), iEX, dY_renamed(), true);
        }
        com.oplus.camera.ui.a_renamed.a_renamed aVar2 = this.ac_renamed;
        if (aVar2 != null) {
            aVar2.c_renamed(iEX);
        }
        com.oplus.camera.ui.camerascreenhint.CameraScreenHintView cameraScreenHintView = this.aj_renamed;
        if (cameraScreenHintView != null) {
            cameraScreenHintView.setOrientation(this.L_renamed);
        }
        com.oplus.camera.ui.camerascreenhint.CameraScreenHintView cameraScreenHintView2 = this.am_renamed;
        if (cameraScreenHintView2 != null) {
            cameraScreenHintView2.setOrientation(this.L_renamed);
        }
        com.oplus.camera.ui.preview.a_renamed aVar3 = this.aH_renamed;
        if (aVar3 != null) {
            aVar3.g_renamed(this.L_renamed);
        }
        com.oplus.camera.ui.widget.SplitBackgroundView splitBackgroundView = this.aL_renamed;
        if (splitBackgroundView != null) {
            splitBackgroundView.a_renamed(this.L_renamed, true);
        }
        com.oplus.camera.ui.modepanel.p_renamed pVar = this.bd_renamed;
        if (pVar != null) {
            pVar.f_renamed(this.L_renamed);
        }
        com.oplus.camera.ui.b_renamed.a_renamed aVar4 = this.y_renamed;
        if (aVar4 != null) {
            aVar4.a_renamed(this.L_renamed);
        }
        com.oplus.camera.ui.widget.b_renamed bVar = this.bh_renamed;
        if (bVar != null) {
            bVar.a_renamed(this.L_renamed, true);
        }
        com.oplus.camera.ui.preview.b_renamed bVar2 = this.bk_renamed;
        if (bVar2 != null) {
            bVar2.b_renamed(this.L_renamed);
        }
        com.oplus.camera.doubleexposure.g_renamed gVar2 = this.bs_renamed;
        if (gVar2 != null) {
            gVar2.a_renamed(this.L_renamed);
        }
        com.oplus.camera.ui.menu.facebeauty.RotateAnimationView rotateAnimationView = this.aQ_renamed;
        if (rotateAnimationView != null) {
            rotateAnimationView.a_renamed(this.L_renamed, true);
        }
        com.oplus.camera.ui.menu.facebeauty.g_renamed gVar3 = this.aT_renamed;
        if (gVar3 != null) {
            gVar3.f_renamed(this.L_renamed);
        }
        com.oplus.camera.ui.menu.levelcontrol.c_renamed cVar = this.ai_renamed;
        if (cVar != null) {
            cVar.setOrientation(this.L_renamed, true);
        }
        if (j_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_TIME_LAPSE_PRO)) {
            com.oplus.camera.ui.menu.facebeauty.RotateAnimationView rotateAnimationView2 = this.bO_renamed;
            if (rotateAnimationView2 != null) {
                rotateAnimationView2.a_renamed(this.L_renamed, true);
            }
            com.oplus.camera.ui.menu.facebeauty.RotateAnimationView rotateAnimationView3 = this.bM_renamed;
            if (rotateAnimationView3 != null) {
                rotateAnimationView3.a_renamed(this.L_renamed, true);
            }
            com.oplus.camera.ui.menu.facebeauty.RotateAnimationView rotateAnimationView4 = this.bN_renamed;
            if (rotateAnimationView4 != null) {
                rotateAnimationView4.a_renamed(this.L_renamed, true);
            }
        }
    }

    @Override // com.oplus.camera.ui.CameraUIInterface
    public void G_renamed(boolean z_renamed) {
        this.Y_renamed = z_renamed;
        cb_renamed();
    }

    @Override // com.oplus.camera.ui.CameraUIInterface
    public void a_renamed(final boolean z_renamed, final boolean z2) {
        android.app.Activity activity = this.i_renamed;
        if (activity != null) {
            activity.runOnUiThread(new java.lang.Runnable() { // from class: com.oplus.camera.ui.d_renamed.16
                @Override // java.lang.Runnable
                public void run() {
                    if (com.oplus.camera.ui.d_renamed.this.z_renamed != null) {
                        com.oplus.camera.ui.d_renamed.this.z_renamed.d_renamed(z_renamed, z2);
                    }
                }
            });
        }
    }

    public void v_renamed(final boolean z_renamed, final boolean z2) {
        android.app.Activity activity = this.i_renamed;
        if (activity != null) {
            activity.runOnUiThread(new java.lang.Runnable() { // from class: com.oplus.camera.ui.d_renamed.17
                @Override // java.lang.Runnable
                public void run() {
                    if (com.oplus.camera.ui.d_renamed.this.z_renamed != null) {
                        com.oplus.camera.ui.d_renamed.this.z_renamed.g_renamed(z_renamed, z2);
                    }
                }
            });
        }
    }

    @Override // com.oplus.camera.ui.CameraUIInterface
    public void c_renamed(boolean z_renamed) {
        if (this.ah_renamed != null) {
            if (!z_renamed || this.J_renamed.h_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_FILTER_PROCESS)) {
                this.ah_renamed.setEnabled(z_renamed);
                this.ah_renamed.setClickable(z_renamed);
            }
        }
    }

    @Override // com.oplus.camera.ui.CameraUIInterface
    public void v_renamed(boolean z_renamed) {
        android.animation.AnimatorSet animatorSet;
        if (this.aL_renamed != null) {
            if (!z_renamed || this.J_renamed.bl_renamed()) {
                if (z_renamed && fB_renamed()) {
                    return;
                }
                fg_renamed();
                if (z_renamed && (((animatorSet = this.aV_renamed) == null || (!animatorSet.isRunning() && !this.aV_renamed.isStarted())) && this.aL_renamed.getVisibility() == 0)) {
                    this.aL_renamed.setClickable(z_renamed);
                } else {
                    if (z_renamed) {
                        return;
                    }
                    this.aL_renamed.setClickable(z_renamed);
                }
            }
        }
    }

    public void bL_renamed() {
        com.oplus.camera.ui.menu.setting.q_renamed qVar = this.aK_renamed;
        if (qVar != null) {
            qVar.scrollToNext();
        }
        com.oplus.camera.ui.menu.levelcontrol.g_renamed gVar = this.ah_renamed;
        if (gVar == null || !gVar.isEffectMenuOpen()) {
            return;
        }
        this.ah_renamed.scrollToNext();
    }

    public void bM_renamed() {
        com.oplus.camera.ui.menu.setting.q_renamed qVar = this.aK_renamed;
        if (qVar != null) {
            qVar.scrollToPrevious();
        }
        com.oplus.camera.ui.menu.levelcontrol.g_renamed gVar = this.ah_renamed;
        if (gVar == null || !gVar.isEffectMenuOpen()) {
            return;
        }
        this.ah_renamed.scrollToPrevious();
    }

    public int bN_renamed() {
        com.oplus.camera.ui.menu.levelcontrol.g_renamed gVar = this.ah_renamed;
        if (gVar != null) {
            return gVar.respondSingleTouchEventY();
        }
        return 0;
    }

    @Override // com.oplus.camera.ui.CameraUIInterface
    public boolean A_renamed() {
        com.oplus.camera.ui.menu.levelcontrol.g_renamed gVar = this.ah_renamed;
        if (gVar != null) {
            return gVar.isEffectMenuOpen();
        }
        return false;
    }

    @Override // com.oplus.camera.ui.CameraUIInterface
    public boolean B_renamed() {
        android.animation.AnimatorSet animatorSet;
        android.animation.AnimatorSet animatorSet2;
        com.oplus.camera.ui.control.a_renamed aVar = this.z_renamed;
        if (aVar == null || this.ah_renamed == null || this.J_renamed == null || this.aT_renamed == null || this.ai_renamed == null) {
            return false;
        }
        return aVar.a_renamed() || this.ah_renamed.isAnimationRunning() || this.J_renamed.u_renamed() || this.aT_renamed.m_renamed() || ((animatorSet = this.aU_renamed) != null && animatorSet.isRunning()) || (((animatorSet2 = this.aV_renamed) != null && animatorSet2.isRunning()) || this.bY_renamed || this.ai_renamed.isAnimationRunning());
    }

    public boolean bO_renamed() {
        com.oplus.camera.ui.menu.setting.o_renamed oVar = this.H_renamed;
        return oVar == null || oVar.I_renamed();
    }

    public boolean bP_renamed() {
        com.oplus.camera.ui.control.a_renamed aVar = this.z_renamed;
        return aVar != null && aVar.b_renamed();
    }

    public void bQ_renamed() {
        com.oplus.camera.ui.control.a_renamed aVar = this.z_renamed;
        if (aVar != null) {
            aVar.c_renamed();
        }
    }

    @Override // com.oplus.camera.ui.CameraUIInterface
    public void C_renamed() {
        com.oplus.camera.ui.menu.levelcontrol.r_renamed rVar = this.ak_renamed;
        if (rVar != null) {
            rVar.a_renamed();
        }
    }

    public boolean bR_renamed() {
        com.oplus.camera.ui.control.a_renamed aVar = this.z_renamed;
        if (aVar != null) {
            return aVar.w_renamed();
        }
        return false;
    }

    @Override // com.oplus.camera.ui.CameraUIInterface
    public void b_renamed(boolean z_renamed, boolean z2) {
        com.oplus.camera.ui.control.a_renamed aVar = this.z_renamed;
        if (aVar != null) {
            aVar.e_renamed(z_renamed, z2);
        }
    }

    @Override // com.oplus.camera.ui.CameraUIInterface
    public void c_renamed(boolean z_renamed, boolean z2) {
        com.oplus.camera.ui.control.a_renamed aVar = this.z_renamed;
        if (aVar != null) {
            aVar.f_renamed(z_renamed, z2);
            this.z_renamed.j_renamed(z_renamed);
        }
    }

    @Override // com.oplus.camera.ui.CameraUIInterface
    public void f_renamed(boolean z_renamed, boolean z2) {
        com.oplus.camera.ui.menu.setting.o_renamed oVar = this.H_renamed;
        if (oVar != null) {
            oVar.a_renamed(z_renamed, z2);
        }
        com.oplus.camera.ui.menu.setting.f_renamed fVar = this.I_renamed;
        if (fVar != null) {
            fVar.a_renamed(z_renamed, z2);
        }
    }

    public boolean bS_renamed() {
        com.oplus.camera.ui.menu.setting.o_renamed oVar = this.H_renamed;
        if (oVar != null) {
            return oVar.L_renamed();
        }
        com.oplus.camera.ui.menu.setting.f_renamed fVar = this.I_renamed;
        if (fVar != null) {
            return fVar.L_renamed();
        }
        return false;
    }

    public int bT_renamed() {
        return com.oplus.camera.util.Util.L_renamed();
    }

    @Override // com.oplus.camera.ui.CameraUIInterface
    public int r_renamed() {
        com.oplus.camera.ui.control.a_renamed aVar = this.z_renamed;
        if (aVar != null) {
            return aVar.T_renamed();
        }
        return 0;
    }

    @Override // com.oplus.camera.ui.CameraUIInterface
    public void d_renamed(boolean z_renamed, boolean z2) {
        com.oplus.camera.e_renamed.a_renamed("CameraUIManager", "enableAllCameraView, enable: " + z_renamed + ", ashed: " + z2);
        a_renamed(z_renamed, z2);
        b_renamed(z_renamed, z2);
        c_renamed(z_renamed, z2);
        f_renamed(z_renamed, z2);
        c_renamed(z_renamed);
        v_renamed(z_renamed);
        E_renamed(z_renamed);
        aD_renamed(z_renamed);
        a_renamed(z_renamed);
        aE_renamed(z_renamed);
    }

    private void aD_renamed(boolean z_renamed) {
        com.oplus.camera.ui.widget.b_renamed bVar = this.bh_renamed;
        if (bVar != null) {
            bVar.setEnabled(z_renamed);
        }
    }

    private void aE_renamed(boolean z_renamed) {
        com.oplus.camera.ui.preview.g_renamed gVar = this.A_renamed;
        if (gVar != null) {
            gVar.o_renamed(z_renamed);
        }
    }

    @Override // com.oplus.camera.ui.CameraUIInterface
    public void m_renamed(boolean z_renamed) throws android.content.res.Resources.NotFoundException {
        com.oplus.camera.ui.control.a_renamed aVar = this.z_renamed;
        if (aVar != null) {
            aVar.e_renamed(z_renamed);
        }
    }

    @Override // com.oplus.camera.ui.CameraUIInterface
    public void g_renamed(boolean z_renamed, boolean z2) {
        com.oplus.camera.ui.control.a_renamed aVar = this.z_renamed;
        if (aVar != null) {
            aVar.c_renamed(z2, false);
            this.z_renamed.i_renamed();
        }
    }

    @Override // com.oplus.camera.ui.CameraUIInterface
    public void c_renamed(int i_renamed) {
        com.oplus.camera.ui.control.a_renamed aVar = this.z_renamed;
        if (aVar != null) {
            aVar.a_renamed(i_renamed, 300);
        }
    }

    @Override // com.oplus.camera.ui.CameraUIInterface
    public void d_renamed(int i_renamed) {
        com.oplus.camera.ui.control.a_renamed aVar = this.z_renamed;
        if (aVar != null) {
            aVar.b_renamed(i_renamed, 250);
        }
    }

    @Override // com.oplus.camera.ui.CameraUIInterface
    public void e_renamed(int i_renamed) {
        com.oplus.camera.ui.control.a_renamed aVar = this.z_renamed;
        if (aVar != null) {
            aVar.k_renamed(i_renamed);
        }
    }

    @Override // com.oplus.camera.ui.CameraUIInterface
    public void f_renamed(int i_renamed) {
        com.oplus.camera.ui.control.a_renamed aVar = this.z_renamed;
        if (aVar != null) {
            aVar.c_renamed(i_renamed, 300);
        }
    }

    @Override // com.oplus.camera.ui.CameraUIInterface
    public void b_renamed(int i_renamed, boolean z_renamed) throws android.content.res.Resources.NotFoundException {
        com.oplus.camera.ui.control.a_renamed aVar;
        if (3 == this.K_renamed || (aVar = this.z_renamed) == null) {
            return;
        }
        aVar.b_renamed(i_renamed, z_renamed);
    }

    @Override // com.oplus.camera.ui.CameraUIInterface
    public void g_renamed(int i_renamed) {
        a_renamed(i_renamed, 0.0f, 0.0f);
    }

    public void a_renamed(int i_renamed, float f_renamed, float f2) {
        com.oplus.camera.ui.menu.setting.f_renamed fVar;
        if (i_renamed == 0) {
            if (R_renamed() || this.o_renamed || this.n_renamed) {
                return;
            }
            com.oplus.camera.ui.CameraUIListener cameraUIListener = this.J_renamed;
            if (cameraUIListener != null && cameraUIListener.L_renamed()) {
                return;
            }
        }
        com.oplus.camera.ui.menu.setting.o_renamed oVar = this.H_renamed;
        if (oVar != null) {
            oVar.a_renamed(i_renamed, f_renamed, f2);
            if (i_renamed != 0) {
                L_renamed(false);
            } else {
                if (this.p_renamed || (fVar = this.I_renamed) == null) {
                    return;
                }
                fVar.m_renamed();
            }
        }
    }

    public void w_renamed(boolean z_renamed, boolean z2) {
        if (dr_renamed() && j_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_TIME_LAPSE_PRO)) {
            return;
        }
        if (z_renamed) {
            if (R_renamed()) {
                return;
            }
            com.oplus.camera.ui.CameraUIListener cameraUIListener = this.J_renamed;
            if (cameraUIListener != null && cameraUIListener.L_renamed()) {
                return;
            }
        }
        if (3 == this.K_renamed || this.H_renamed == null) {
            return;
        }
        android.view.animation.PathInterpolator pathInterpolator = z2 ? this.bb_renamed : null;
        long j_renamed = z2 ? 400L : 0L;
        if (z_renamed) {
            this.H_renamed.a_renamed(true, 0.0f, this.bv_renamed, this.ba_renamed, 400L, pathInterpolator, j_renamed, z2 ? 150L : 0L);
        } else {
            this.H_renamed.a_renamed(false, 0.0f, this.bv_renamed, this.ba_renamed, 250L, pathInterpolator, j_renamed, 0L);
        }
    }

    public void bU_renamed() {
        P_renamed(true);
    }

    @Override // com.oplus.camera.ui.CameraUIInterface
    public void P_renamed(boolean z_renamed) {
        com.oplus.camera.screen.b_renamed.a_renamed aVar = this.bx_renamed;
        if (aVar == null || this.J_renamed == null) {
            return;
        }
        boolean zA = this.l_renamed.a_renamed(aVar.h_renamed());
        if (this.bz_renamed != null) {
            if (!z_renamed || this.J_renamed.c_renamed() || this.J_renamed.L_renamed() || this.J_renamed.ar_renamed()) {
                this.bz_renamed.setVisibility(8);
                this.k_renamed.a_renamed();
                this.j_renamed.c_renamed(false);
                this.bA_renamed.setVisibility(8);
            } else if (!R_renamed()) {
                if (this.J_renamed.h_renamed(com.oplus.camera.aps.config.CameraFunction.OUT_PREVIEW_ENABLE)) {
                    this.bz_renamed.setImageResource(com.oplus.camera.R_renamed.drawable.icon_out_screen_preview_switch);
                    this.k_renamed.a_renamed();
                } else if (this.J_renamed.h_renamed(com.oplus.camera.aps.config.CameraFunction.OUT_CAPTURE_ENABLE)) {
                    this.bz_renamed.setImageResource(com.oplus.camera.R_renamed.drawable.icon_out_screen_capture_switch);
                } else {
                    this.k_renamed.a_renamed();
                }
                this.bz_renamed.setVisibility(this.J_renamed.h_renamed(com.oplus.camera.aps.config.CameraFunction.OUT_PREVIEW_BUTTON_SHOW) ? 0 : 8);
                this.j_renamed.c_renamed(this.J_renamed.h_renamed(com.oplus.camera.aps.config.CameraFunction.OUT_PREVIEW_CAPTURE_ENABLE));
                this.bA_renamed.setVisibility(this.J_renamed.h_renamed(com.oplus.camera.aps.config.CameraFunction.OUT_CAPTURE_CLOSE_ENABLE) ? 0 : 8);
            }
        }
        boolean z2 = this.l_renamed.k_renamed() && !R_renamed();
        int i_renamed = z2 ? 0 : 8;
        if (this.by_renamed != null) {
            if (z2 && zA) {
                return;
            }
            this.by_renamed.setVisibility(i_renamed);
        }
    }

    @Override // com.oplus.camera.ui.CameraUIInterface
    public boolean ap_renamed() {
        com.oplus.camera.ui.preview.g_renamed gVar = this.A_renamed;
        if (gVar != null) {
            return gVar.l_renamed();
        }
        return false;
    }

    @Override // com.oplus.camera.ui.CameraUIInterface
    public java.lang.String aq_renamed() {
        com.oplus.camera.ui.preview.g_renamed gVar = this.A_renamed;
        return gVar != null ? gVar.m_renamed() : "";
    }

    public void a_renamed(java.lang.String str, boolean z_renamed, boolean z2) {
        com.oplus.camera.ui.menu.setting.o_renamed oVar = this.H_renamed;
        if (oVar != null) {
            oVar.a_renamed(str, z_renamed, z2);
        }
        com.oplus.camera.ui.menu.setting.f_renamed fVar = this.I_renamed;
        if (fVar != null) {
            fVar.a_renamed(str, z_renamed, z2);
        }
    }

    public void e_renamed(float f_renamed) {
        a_renamed(f_renamed, false, 0L);
    }

    public void a_renamed(float f_renamed, boolean z_renamed, long j_renamed) {
        com.oplus.camera.ui.menu.setting.o_renamed oVar = this.H_renamed;
        if (oVar != null) {
            oVar.a_renamed(f_renamed, z_renamed, j_renamed);
        }
    }

    public void Z_renamed(boolean z_renamed) {
        if (z_renamed && h_renamed) {
            h_renamed = false;
        }
    }

    public boolean bV_renamed() {
        if (this.K_renamed != 1 || this.J_renamed.bc_renamed().w_renamed()) {
            return false;
        }
        return h_renamed;
    }

    public void b_renamed(int i_renamed, boolean z_renamed, boolean z2) {
        com.oplus.camera.e_renamed.a_renamed("CameraUIManager", "afterOpenCameraUpdateUI");
        com.oplus.camera.ui.menu.levelcontrol.g_renamed gVar = this.ah_renamed;
        if (gVar != null && gVar.isEffectMenuOpen()) {
            z_renamed = false;
        }
        if (4 == aX_renamed() && O_renamed()) {
            z_renamed = false;
        }
        if (this.H_renamed != null) {
            if (1 != aX_renamed() || !eD_renamed()) {
                this.H_renamed.a_renamed(i_renamed, false, !this.n_renamed && z_renamed, z2);
            }
            if (this.n_renamed) {
                this.H_renamed.a_renamed(false, true);
                this.H_renamed.c_renamed(4);
            }
        }
        com.oplus.camera.ui.menu.setting.f_renamed fVar = this.I_renamed;
        if (fVar != null) {
            fVar.a_renamed(i_renamed, false, !this.n_renamed && z_renamed, z2);
            if (this.n_renamed) {
                this.I_renamed.a_renamed(false, true);
                this.I_renamed.c_renamed(4);
            }
        }
        cb_renamed();
    }

    public void bW_renamed() {
        com.oplus.camera.ui.menu.setting.o_renamed oVar = this.H_renamed;
        if (oVar != null) {
            oVar.N_renamed();
        }
    }

    public void bX_renamed() {
        com.oplus.camera.ui.menu.setting.o_renamed oVar = this.H_renamed;
        if (oVar != null) {
            oVar.O_renamed();
        }
    }

    public void bY_renamed() {
        com.oplus.camera.e_renamed.a_renamed("CameraUIManager", "afterEnterCameraStartPreviewDone");
        if (this.n_renamed) {
            return;
        }
        f_renamed(true, false);
    }

    public void a_renamed(android.graphics.Bitmap bitmap, com.oplus.camera.ui.control.e_renamed eVar, int i_renamed, boolean z_renamed) {
        com.oplus.camera.ui.b_renamed.a_renamed aVar = this.y_renamed;
        if (aVar != null) {
            aVar.a_renamed(bitmap, eVar, i_renamed, z_renamed);
        }
    }

    public void a_renamed(com.oplus.camera.ui.control.e_renamed eVar) {
        a_renamed(eVar, true);
    }

    public void a_renamed(com.oplus.camera.ui.control.e_renamed eVar, boolean z_renamed) {
        com.oplus.camera.ui.control.a_renamed aVar = this.z_renamed;
        if (aVar != null) {
            aVar.a_renamed(eVar, z_renamed);
        }
        com.oplus.camera.ui.k_renamed kVar = this.bH_renamed;
        if (kVar != null) {
            kVar.a_renamed(eVar, z_renamed);
        }
    }

    public void a_renamed(android.graphics.Bitmap bitmap) {
        com.oplus.camera.ui.control.a_renamed aVar = this.z_renamed;
        if (aVar != null) {
            aVar.a_renamed(bitmap);
        }
    }

    public void c_renamed(long j_renamed) {
        com.oplus.camera.ui.control.a_renamed aVar = this.z_renamed;
        if (aVar != null) {
            aVar.a_renamed(j_renamed);
        }
    }

    public void a_renamed(com.oplus.camera.ui.control.a_renamed.c_renamed cVar) {
        com.oplus.camera.ui.control.a_renamed aVar = this.z_renamed;
        if (aVar != null) {
            aVar.a_renamed((com.oplus.camera.ui.control.e_renamed.d_renamed) null, true, cVar);
        }
    }

    @Override // com.oplus.camera.ui.CameraUIInterface
    public void a_renamed(com.oplus.camera.ui.control.e_renamed eVar, int i_renamed) {
        if (this.z_renamed != null) {
            com.oplus.camera.e_renamed.a_renamed("captureX preUpdateThumbnail animType: " + i_renamed, "12ct_preUpdateThumbnail", com.oplus.camera.d_renamed.d_renamed.longValue());
            this.z_renamed.a_renamed(eVar, i_renamed);
            com.oplus.camera.e_renamed.d_renamed("captureX preUpdateThumbnail animType: " + i_renamed, "12ct_preUpdateThumbnail");
        }
    }

    @Override // com.oplus.camera.ui.CameraUIInterface
    public void d_renamed(boolean z_renamed) {
        com.oplus.camera.e_renamed.a_renamed("CameraUIManager", "updateThumbnail, anim: " + z_renamed);
        a_renamed((com.oplus.camera.ui.control.e_renamed.d_renamed) null, z_renamed);
    }

    @Override // com.oplus.camera.ui.CameraUIInterface
    public void a_renamed(com.oplus.camera.ui.control.e_renamed.d_renamed dVar, boolean z_renamed) {
        com.oplus.camera.e_renamed.a_renamed("CameraUIManager", "updateThumbnail");
        com.oplus.camera.ui.control.a_renamed aVar = this.z_renamed;
        if (aVar != null) {
            aVar.a_renamed(dVar, z_renamed);
        }
    }

    public void f_renamed(java.lang.String str, boolean z_renamed) {
        com.oplus.camera.e_renamed.a_renamed("CameraUIManager", "updateGalleryPreviewUI");
        com.oplus.camera.ui.k_renamed kVar = this.bH_renamed;
        if (kVar != null) {
            kVar.a_renamed(str, z_renamed, 0);
        }
    }

    @Override // com.oplus.camera.ui.CameraUIInterface
    public void a_renamed(java.lang.String str, int i_renamed) {
        com.oplus.camera.ui.k_renamed kVar = this.bH_renamed;
        if (kVar != null) {
            kVar.a_renamed(str, false, i_renamed);
        }
    }

    public void bZ_renamed() {
        com.oplus.camera.ui.control.a_renamed aVar = this.z_renamed;
        if (aVar != null) {
            aVar.Q_renamed();
        }
    }

    public boolean ca_renamed() {
        com.oplus.camera.ui.control.a_renamed aVar = this.z_renamed;
        if (aVar != null) {
            return aVar.R_renamed();
        }
        return false;
    }

    @Override // com.oplus.camera.ui.CameraUIInterface
    public void i_renamed(boolean z_renamed) {
        com.oplus.camera.ui.preview.g_renamed gVar = this.A_renamed;
        if (gVar != null) {
            gVar.a_renamed(z_renamed);
            this.A_renamed.b_renamed(z_renamed);
        }
    }

    @Override // com.oplus.camera.ui.CameraUIInterface
    public void j_renamed(boolean z_renamed) {
        com.oplus.camera.ui.preview.g_renamed gVar = this.A_renamed;
        if (gVar != null) {
            gVar.h_renamed(z_renamed);
        }
    }

    @Override // com.oplus.camera.ui.CameraUIInterface
    public void k_renamed(boolean z_renamed) {
        com.oplus.camera.ui.preview.g_renamed gVar = this.A_renamed;
        if (gVar != null) {
            gVar.a_renamed(z_renamed);
        }
    }

    public boolean b_renamed(android.util.Size size) {
        com.oplus.camera.ui.preview.g_renamed gVar = this.A_renamed;
        if (gVar != null) {
            return gVar.b_renamed(size);
        }
        return false;
    }

    public void c_renamed(android.util.Size size) {
        com.oplus.camera.e_renamed.a_renamed("CameraUIManager", "notifyEffectMenuPreviewSizeChanged, previewSize: " + size.getWidth() + "x_renamed" + size.getHeight());
        com.oplus.camera.ui.menu.levelcontrol.g_renamed gVar = this.ah_renamed;
        if (gVar != null) {
            int textureWidth = gVar.getTextureWidth();
            int textureHeight = this.ah_renamed.getTextureHeight();
            int width = size.getWidth();
            int height = size.getHeight();
            if (this.N_renamed % 180 == 0) {
                width = height;
                height = width;
            }
            if (textureWidth == height && textureHeight == width) {
                return;
            }
            this.ah_renamed.b_renamed(height, width);
        }
    }

    public void aa_renamed(boolean z_renamed) {
        this.z_renamed.n_renamed(z_renamed);
    }

    public void F_renamed(int i_renamed) {
        this.M_renamed = i_renamed;
        com.oplus.camera.ui.menu.setting.o_renamed oVar = this.H_renamed;
        if (oVar != null) {
            oVar.b_renamed(this.M_renamed);
        }
        com.oplus.camera.ui.menu.setting.f_renamed fVar = this.I_renamed;
        if (fVar != null) {
            fVar.b_renamed(this.M_renamed);
        }
        com.oplus.camera.ui.control.a_renamed aVar = this.z_renamed;
        if (aVar != null) {
            aVar.d_renamed(this.M_renamed);
        }
        com.oplus.camera.ui.menu.facebeauty.g_renamed gVar = this.aT_renamed;
        if (gVar != null) {
            gVar.e_renamed(this.M_renamed);
        }
        com.oplus.camera.ui.preview.g_renamed gVar2 = this.A_renamed;
        if (gVar2 != null) {
            gVar2.a_renamed(this.M_renamed);
        }
        com.oplus.camera.ui.a_renamed.a_renamed aVar2 = this.ac_renamed;
        if (aVar2 != null) {
            aVar2.b_renamed(this.M_renamed);
        }
        cb_renamed();
    }

    private boolean eQ_renamed() {
        if (this.Y_renamed) {
            return true;
        }
        int iAX = aX_renamed();
        if (iAX == 1) {
            int i_renamed = this.M_renamed;
            if (i_renamed != 0 && 1 != i_renamed) {
                return false;
            }
        } else if (iAX == 2 || 2 != this.M_renamed) {
            return false;
        }
        return true;
    }

    public void a_renamed(android.util.Size size, android.util.Size size2, boolean z_renamed) {
        com.oplus.camera.ui.preview.g_renamed gVar = this.A_renamed;
        if (gVar != null) {
            gVar.a_renamed(size, z_renamed);
        }
        float[] fArr = {0.0f, 0.0f, 0.0f, 0.0f};
        if (com.oplus.camera.util.Util.d_renamed(size.getWidth(), size.getHeight()) == 2) {
            fArr[0] = 0.0f;
        }
        c_renamed(size2);
    }

    public void cb_renamed() {
        com.oplus.camera.e_renamed.a_renamed("CameraUIManager", "updateButtonBg, mSizeRatioType: " + this.M_renamed);
        if (this.cm_renamed.hasCallbacks(this.cf_renamed)) {
            return;
        }
        this.cm_renamed.post(this.cf_renamed);
    }

    @Override // com.oplus.camera.ui.CameraUIInterface
    public void x_renamed() {
        com.oplus.camera.ui.control.a_renamed aVar = this.z_renamed;
        if (aVar != null) {
            aVar.P_renamed();
        }
    }

    public void h_renamed(int i_renamed, boolean z_renamed) {
        com.oplus.camera.e_renamed.a_renamed("CameraUIManager", "previewType: " + i_renamed + ", needControlAnimation: " + z_renamed);
        if (this.z_renamed == null || O_renamed() || dY_renamed()) {
            return;
        }
        this.z_renamed.c_renamed(i_renamed, z_renamed);
    }

    public void ab_renamed(boolean z_renamed) {
        com.oplus.camera.ui.preview.g_renamed gVar = this.A_renamed;
        if (gVar != null) {
            gVar.i_renamed(z_renamed);
        }
    }

    public void cc_renamed() {
        com.oplus.camera.ui.preview.g_renamed gVar = this.A_renamed;
        if (gVar != null) {
            gVar.K_renamed();
        }
    }

    public void cd_renamed() {
        com.oplus.camera.ui.preview.g_renamed gVar = this.A_renamed;
        if (gVar != null) {
            gVar.L_renamed();
        }
    }

    public void ce_renamed() {
        com.oplus.camera.ui.preview.g_renamed gVar = this.A_renamed;
        if (gVar != null) {
            gVar.M_renamed();
        }
    }

    public boolean cf_renamed() {
        com.oplus.camera.ui.preview.ae_renamed aeVar = this.D_renamed;
        if (aeVar != null) {
            return aeVar.a_renamed();
        }
        return false;
    }

    @Override // com.oplus.camera.ui.CameraUIInterface
    public void a_renamed(java.lang.Float f_renamed, int i_renamed, boolean z_renamed, boolean z2) {
        if (this.D_renamed == null) {
            this.D_renamed = new com.oplus.camera.ui.preview.ae_renamed(this.i_renamed);
        }
        this.D_renamed.d_renamed(av_renamed() && dY_renamed());
        int iEX = eX_renamed();
        if (this.l_renamed != null && com.oplus.camera.util.Util.t_renamed()) {
            i_renamed = this.l_renamed.a_renamed().a_renamed(this.i_renamed, i_renamed);
            this.D_renamed.a_renamed(this.l_renamed.a_renamed());
        }
        int i2 = i_renamed;
        com.oplus.camera.ui.preview.ae_renamed aeVar = this.D_renamed;
        if (aeVar != null) {
            aeVar.a_renamed(i2, eW_renamed(), iEX, z_renamed, dY_renamed(), z2);
            this.D_renamed.g_renamed();
        }
        ag_renamed(true);
        ah_renamed(true);
        cO_renamed();
    }

    @Override // com.oplus.camera.ui.CameraUIInterface
    public void u_renamed() {
        long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
        if (this.be_renamed || jCurrentTimeMillis - this.W_renamed < 3000) {
            return;
        }
        a_renamed(com.oplus.camera.R_renamed.string.camera_slow_video_tips, -1, true, false, false);
        this.be_renamed = true;
    }

    @Override // com.oplus.camera.ui.CameraUIInterface
    public void v_renamed() {
        a_renamed(com.oplus.camera.R_renamed.string.camera_video_binaural_recording_tips, -1, true, false, false);
    }

    @Override // com.oplus.camera.ui.CameraUIInterface
    public void a_renamed(long j_renamed, long j2, boolean z_renamed, boolean z2, long j3) {
        com.oplus.camera.ui.preview.ae_renamed aeVar = this.D_renamed;
        if (aeVar != null) {
            aeVar.a_renamed(j_renamed, j2, z_renamed, z2, j3);
        }
    }

    @Override // com.oplus.camera.ui.CameraUIInterface
    public void e_renamed(boolean z_renamed) {
        com.oplus.camera.ui.preview.ae_renamed aeVar = this.D_renamed;
        if (aeVar != null) {
            aeVar.b_renamed(z_renamed);
        }
    }

    @Override // com.oplus.camera.ui.CameraUIInterface
    public void f_renamed(boolean z_renamed) {
        com.oplus.camera.ui.preview.ae_renamed aeVar = this.D_renamed;
        if (aeVar != null) {
            aeVar.a_renamed(z_renamed);
        }
    }

    @Override // com.oplus.camera.ui.CameraUIInterface
    public void i_renamed(int i_renamed) {
        if (this.E_renamed == null) {
            this.E_renamed = new com.oplus.camera.ui.preview.i_renamed(this.i_renamed, i_renamed);
        }
        com.oplus.camera.ui.preview.i_renamed iVar = this.E_renamed;
        if (iVar != null) {
            iVar.a_renamed(i_renamed, eW_renamed(), false, dY_renamed());
        }
    }

    @Override // com.oplus.camera.ui.CameraUIInterface
    public void g_renamed(boolean z_renamed) {
        com.oplus.camera.ui.preview.i_renamed iVar = this.E_renamed;
        if (iVar != null) {
            iVar.a_renamed(z_renamed, dY_renamed());
        }
    }

    @Override // com.oplus.camera.ui.CameraUIInterface
    public void a_renamed(long j_renamed, boolean z_renamed) {
        com.oplus.camera.ui.preview.i_renamed iVar = this.E_renamed;
        if (iVar != null) {
            iVar.a_renamed(j_renamed, 0L, z_renamed);
        }
    }

    @Override // com.oplus.camera.ui.CameraUIInterface
    public void a_renamed(long j_renamed) {
        com.oplus.camera.ui.preview.NightTimeView nightTimeView = this.F_renamed;
        if (nightTimeView == null) {
            eT_renamed();
        } else {
            nightTimeView.a_renamed(j_renamed);
        }
    }

    @Override // com.oplus.camera.ui.CameraUIInterface
    public void c_renamed(int i_renamed, boolean z_renamed) {
        com.oplus.camera.ui.preview.NightTimeView nightTimeView;
        com.oplus.camera.e_renamed.a_renamed("CameraUIManager", "setNightCountDownUIVisible, visible: " + i_renamed + ", needAnim: " + z_renamed);
        if (this.F_renamed == null) {
            eT_renamed();
        }
        if ((i_renamed == 0 && dS_renamed() && dH_renamed()) || (nightTimeView = this.F_renamed) == null) {
            return;
        }
        nightTimeView.a_renamed(i_renamed, z_renamed);
    }

    private void eR_renamed() {
        com.oplus.camera.ui.preview.NightTimeView nightTimeView = this.F_renamed;
        if (nightTimeView != null) {
            ((android.widget.RelativeLayout.LayoutParams) nightTimeView.getLayoutParams()).topMargin = eS_renamed();
        }
    }

    private int eS_renamed() {
        int iAX = aX_renamed();
        android.content.res.Resources resources = this.i_renamed.getApplication().getResources();
        if (iAX == 1) {
            return resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.night_countdown_time_text_margin_top_fold_full_mode);
        }
        if (iAX == 2) {
            return resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.night_countdown_time_text_margin_top_fold_out_mode);
        }
        if (iAX == 3) {
            return resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.night_countdown_time_text_margin_top_fold_split_mode);
        }
        if (iAX == 4) {
            return resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.night_countdown_time_text_margin_top_fold_rack_mode);
        }
        return resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.night_countdown_time_text_margin_top);
    }

    private void eT_renamed() {
        android.app.Activity activity = this.i_renamed;
        if (activity == null) {
            com.oplus.camera.e_renamed.f_renamed("CameraUIManager", "addNightCountDownTimeUI, failed, mActivity is_renamed null");
            return;
        }
        this.Z_renamed = (android.widget.RelativeLayout) activity.findViewById(com.oplus.camera.R_renamed.id_renamed.camera);
        android.view.ViewGroup viewGroup = this.Z_renamed;
        if (viewGroup == null) {
            return;
        }
        com.oplus.camera.ui.preview.NightTimeView nightTimeView = this.F_renamed;
        if (nightTimeView != null) {
            viewGroup.removeView(nightTimeView);
        }
        android.content.res.Resources resources = this.i_renamed.getApplication().getResources();
        this.F_renamed = (com.oplus.camera.ui.preview.NightTimeView) android.view.LayoutInflater.from(this.i_renamed).inflate(com.oplus.camera.R_renamed.layout.night_mode_count_down_time_ui, (android.view.ViewGroup) null);
        this.F_renamed.a_renamed();
        android.widget.RelativeLayout.LayoutParams layoutParams = new android.widget.RelativeLayout.LayoutParams(resources.getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.night_countdown_time_layout_width), resources.getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.night_countdown_time_layout_height));
        layoutParams.topMargin = eS_renamed();
        layoutParams.addRule(14);
        this.Z_renamed.addView(this.F_renamed, layoutParams);
        this.F_renamed.bringToFront();
        this.F_renamed.setVisibility(8);
    }

    @Override // com.oplus.camera.ui.CameraUIInterface
    public void b_renamed(long j_renamed) {
        if (this.G_renamed == null) {
            eU_renamed();
        }
        com.oplus.camera.ui.preview.LongExposureTimeView longExposureTimeView = this.G_renamed;
        if (longExposureTimeView != null) {
            longExposureTimeView.a_renamed(j_renamed);
        }
    }

    @Override // com.oplus.camera.ui.CameraUIInterface
    public void d_renamed(int i_renamed, boolean z_renamed) {
        com.oplus.camera.ui.preview.LongExposureTimeView longExposureTimeView;
        com.oplus.camera.e_renamed.a_renamed("CameraUIManager", "setLongExposureCountDownUIVisible, visible: " + i_renamed + ", needAnim: " + z_renamed);
        if (this.G_renamed == null) {
            eU_renamed();
        }
        if ((i_renamed == 0 && dS_renamed() && dH_renamed()) || (longExposureTimeView = this.G_renamed) == null) {
            return;
        }
        longExposureTimeView.a_renamed(i_renamed, z_renamed);
    }

    private void eU_renamed() {
        this.Z_renamed = (android.widget.RelativeLayout) this.i_renamed.findViewById(com.oplus.camera.R_renamed.id_renamed.camera);
        android.view.ViewGroup viewGroup = this.Z_renamed;
        if (viewGroup == null) {
            return;
        }
        com.oplus.camera.ui.preview.LongExposureTimeView longExposureTimeView = this.G_renamed;
        if (longExposureTimeView != null) {
            viewGroup.removeView(longExposureTimeView);
        }
        android.content.res.Resources resources = this.i_renamed.getApplication().getResources();
        this.G_renamed = (com.oplus.camera.ui.preview.LongExposureTimeView) android.view.LayoutInflater.from(this.i_renamed).inflate(com.oplus.camera.R_renamed.layout.long_exposure_mode_count_down_time_ui, (android.view.ViewGroup) null);
        this.G_renamed.a_renamed();
        android.widget.RelativeLayout.LayoutParams layoutParams = new android.widget.RelativeLayout.LayoutParams(resources.getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.night_countdown_time_layout_width), resources.getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.night_countdown_time_layout_height));
        layoutParams.topMargin = resources.getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.night_countdown_time_text_margin_top);
        layoutParams.addRule(14);
        this.Z_renamed.addView(this.G_renamed, layoutParams);
        this.G_renamed.bringToFront();
        this.G_renamed.setVisibility(8);
    }

    @Override // com.oplus.camera.ui.CameraUIInterface
    public void K_renamed(boolean z_renamed) {
        com.oplus.camera.ui.CameraUIListener cameraUIListener = this.J_renamed;
        if (cameraUIListener != null) {
            cameraUIListener.h_renamed(z_renamed);
        }
    }

    @Override // com.oplus.camera.ui.CameraUIInterface
    public void aC_renamed() {
        com.oplus.camera.ui.CameraUIListener cameraUIListener = this.J_renamed;
        if (cameraUIListener != null) {
            cameraUIListener.bv_renamed();
        }
    }

    public void cg_renamed() {
        com.oplus.camera.ui.menu.setting.o_renamed oVar = this.H_renamed;
        if (oVar != null) {
            oVar.F_renamed();
        }
    }

    public void ac_renamed(boolean z_renamed) {
        com.oplus.camera.e_renamed.a_renamed("CameraUIManager", "startVideoRecording");
        com.oplus.camera.ui.menu.levelcontrol.c_renamed cVar = this.aS_renamed;
        if (cVar != null && cVar.isMenuOpen()) {
            this.aS_renamed.hideMenu(false, false, false, true);
        }
        if (this.H_renamed != null) {
            if (!bO_renamed() && !j_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_STICKER_PROCESS)) {
                if (1 == aX_renamed()) {
                    a_renamed(0, 0.0f, this.i_renamed.getApplication().getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.zoom_linkage_translate));
                } else {
                    a_renamed(0, 0.0f, 0.0f);
                }
                this.H_renamed.c_renamed(0);
            } else {
                this.H_renamed.d_renamed();
            }
        }
        com.oplus.camera.ui.menu.setting.f_renamed fVar = this.I_renamed;
        if (fVar != null) {
            fVar.d_renamed();
        }
        com.oplus.camera.ui.preview.g_renamed gVar = this.A_renamed;
        if (gVar != null) {
            gVar.N_renamed();
            this.A_renamed.f_renamed(true);
        }
        com.oplus.camera.ui.control.a_renamed aVar = this.z_renamed;
        if (aVar != null) {
            aVar.m_renamed(z_renamed);
        }
        i_renamed(j_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_ASSISTANT_LINE));
        com.oplus.camera.ui.control.a_renamed aVar2 = this.z_renamed;
        if (aVar2 != null) {
            aVar2.ad_renamed();
        }
    }

    public void ch_renamed() {
        com.oplus.camera.e_renamed.a_renamed("CameraUIManager", "beforeStopSlowVideoRecording");
        com.oplus.camera.ui.preview.ae_renamed aeVar = this.D_renamed;
        if (aeVar != null) {
            aeVar.a_renamed(true);
        }
        com.oplus.camera.ui.control.a_renamed aVar = this.z_renamed;
        if (aVar != null) {
            aVar.i_renamed(false, false);
        }
        if (this.J_renamed.h_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_SUPPORT_SHARE_EDIT_THUMB)) {
            ar_renamed();
        }
    }

    public void ci_renamed() {
        com.oplus.camera.e_renamed.a_renamed("CameraUIManager", "afterStopSlowVideoRecording");
        com.oplus.camera.ui.menu.setting.o_renamed oVar = this.H_renamed;
        if (oVar != null) {
            oVar.G_renamed();
        }
        com.oplus.camera.ui.menu.setting.f_renamed fVar = this.I_renamed;
        if (fVar != null) {
            fVar.G_renamed();
        }
        com.oplus.camera.ui.preview.g_renamed gVar = this.A_renamed;
        if (gVar != null) {
            gVar.f_renamed(false);
        }
        com.oplus.camera.ui.menu.levelcontrol.c_renamed cVar = this.ai_renamed;
        if (cVar != null) {
            cVar.stopVideoRecording();
        }
        if (bK_renamed()) {
            cw_renamed();
        }
        k_renamed(true);
    }

    public void x_renamed(boolean z_renamed, boolean z2) {
        com.oplus.camera.e_renamed.a_renamed("CameraUIManager", "stopVideoRecording");
        ag_renamed(false);
        ah_renamed(false);
        cO_renamed();
        com.oplus.camera.ui.CameraUIListener cameraUIListener = this.J_renamed;
        boolean z3 = cameraUIListener != null && cameraUIListener.h_renamed();
        com.oplus.camera.ui.CameraUIListener cameraUIListener2 = this.J_renamed;
        if (cameraUIListener2 != null && cameraUIListener2.bl_renamed() && !h_renamed()) {
            l_renamed(true, z3);
        }
        com.oplus.camera.ui.CameraUIListener cameraUIListener3 = this.J_renamed;
        if (cameraUIListener3 != null && cameraUIListener3.bm_renamed() && !h_renamed()) {
            i_renamed(true, z3);
        }
        if (this.H_renamed != null && (3 != this.K_renamed || !aw_renamed() || 1 != ej_renamed().j_renamed())) {
            this.H_renamed.G_renamed();
        }
        com.oplus.camera.ui.menu.setting.f_renamed fVar = this.I_renamed;
        if (fVar != null) {
            fVar.G_renamed();
        }
        com.oplus.camera.ui.preview.g_renamed gVar = this.A_renamed;
        if (gVar != null) {
            gVar.f_renamed(false);
        }
        com.oplus.camera.ui.preview.ae_renamed aeVar = this.D_renamed;
        if (aeVar != null) {
            aeVar.a_renamed(!j_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_STICKER_PROCESS), dY_renamed());
            this.D_renamed.b_renamed();
        }
        com.oplus.camera.ui.CameraUIListener cameraUIListener4 = this.J_renamed;
        if (cameraUIListener4 != null && cameraUIListener4.h_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_SUPPORT_SHARE_EDIT_THUMB)) {
            com.oplus.camera.ui.control.a_renamed aVar = this.z_renamed;
            if (aVar != null) {
                aVar.an_renamed();
            }
            ar_renamed();
        }
        com.oplus.camera.ui.control.a_renamed aVar2 = this.z_renamed;
        if (aVar2 != null) {
            aVar2.i_renamed(z_renamed, z2);
        }
        com.oplus.camera.ui.menu.levelcontrol.c_renamed cVar = this.ai_renamed;
        if (cVar != null) {
            cVar.stopVideoRecording();
        }
        if (bK_renamed()) {
            cw_renamed();
        }
        i_renamed(true);
    }

    @Override // com.oplus.camera.ui.CameraUIInterface
    public boolean h_renamed() {
        com.oplus.camera.ui.menu.levelcontrol.c_renamed cVar = this.ai_renamed;
        if (cVar != null) {
            return cVar.isVideoRecordingHideMenu();
        }
        return false;
    }

    public void cj_renamed() {
        if (this.n_renamed) {
            return;
        }
        this.A_renamed.E_renamed();
    }

    public android.widget.ImageView ck_renamed() {
        com.oplus.camera.ui.preview.g_renamed gVar = this.A_renamed;
        if (gVar == null) {
            return null;
        }
        return gVar.G_renamed();
    }

    public void cl_renamed() {
        com.oplus.camera.e_renamed.a_renamed("CameraUIManager", "hidePostCaptureAlert");
        this.o_renamed = false;
        com.oplus.camera.ui.preview.g_renamed gVar = this.A_renamed;
        if (gVar != null) {
            gVar.t_renamed();
        }
        r_renamed(true);
        l_renamed(true, false);
        if (this.J_renamed.bm_renamed()) {
            i_renamed(true, false);
        }
        com.oplus.camera.ui.menu.setting.o_renamed oVar = this.H_renamed;
        if (oVar != null) {
            oVar.d_renamed(0);
            this.H_renamed.a_renamed(true, false);
        }
        com.oplus.camera.ui.menu.setting.f_renamed fVar = this.I_renamed;
        if (fVar != null) {
            fVar.m_renamed();
            this.I_renamed.a_renamed(true, false);
        }
        if (this.z_renamed != null) {
            if (com.oplus.camera.util.Util.d_renamed(this.M_renamed)) {
                this.z_renamed.b_renamed(0, true);
            }
            this.z_renamed.I_renamed();
        }
        a_renamed(0, 1);
    }

    public void b_renamed(android.graphics.Bitmap bitmap) {
        com.oplus.camera.e_renamed.a_renamed("CameraUIManager", "showPostCaptureAlert");
        this.o_renamed = true;
        cM_renamed();
        if (this.K_renamed != 2) {
            return;
        }
        if (A_renamed()) {
            s_renamed(false);
        } else {
            q_renamed(false);
        }
        j_renamed(true, false);
        if (O_renamed()) {
            b_renamed(false, true, false, false);
        } else {
            h_renamed(true, false);
        }
        com.oplus.camera.ui.menu.setting.o_renamed oVar = this.H_renamed;
        if (oVar != null) {
            oVar.a_renamed(false, true);
            if (com.oplus.camera.util.Util.c_renamed(this.M_renamed)) {
                this.H_renamed.d_renamed(4);
            } else {
                this.H_renamed.c_renamed(4);
            }
        }
        com.oplus.camera.ui.menu.setting.f_renamed fVar = this.I_renamed;
        if (fVar != null) {
            fVar.a_renamed(false, true);
        }
        L_renamed(false);
        a_renamed(4, 1);
        if (this.z_renamed != null) {
            if (com.oplus.camera.util.Util.d_renamed(this.M_renamed)) {
                this.z_renamed.b_renamed(4, true);
            }
            this.z_renamed.H_renamed();
        }
        com.oplus.camera.ui.preview.g_renamed gVar = this.A_renamed;
        if (gVar != null) {
            gVar.a_renamed(bitmap);
        }
        a_renamed(true, false, false);
        ab_renamed();
    }

    public void c_renamed(com.oplus.camera.ui.control.b_renamed bVar, boolean z_renamed) {
        this.n_renamed = false;
        com.oplus.camera.ui.control.a_renamed aVar = this.z_renamed;
        if (aVar != null) {
            aVar.K_renamed();
            this.z_renamed.a_renamed(bVar, z_renamed, true);
            if (this.K_renamed != 3 && !this.p_renamed) {
                this.z_renamed.a_renamed(false);
            }
        }
        com.oplus.camera.ui.menu.setting.o_renamed oVar = this.H_renamed;
        if (oVar != null) {
            oVar.a_renamed(true, false);
            this.H_renamed.d_renamed(0);
        }
        com.oplus.camera.ui.menu.setting.f_renamed fVar = this.I_renamed;
        if (fVar != null) {
            fVar.a_renamed(true, false);
        }
    }

    public void cm_renamed() {
        com.oplus.camera.e_renamed.a_renamed("CameraUIManager", "hideVideoAlert");
        this.n_renamed = false;
        com.oplus.camera.ui.preview.g_renamed gVar = this.A_renamed;
        if (gVar != null) {
            gVar.v_renamed();
        }
        com.oplus.camera.ui.control.a_renamed aVar = this.z_renamed;
        if (aVar != null) {
            aVar.K_renamed();
        }
        com.oplus.camera.ui.menu.setting.o_renamed oVar = this.H_renamed;
        if (oVar != null) {
            oVar.a_renamed(true, false);
            this.H_renamed.d_renamed(0);
        }
        com.oplus.camera.ui.menu.setting.f_renamed fVar = this.I_renamed;
        if (fVar != null) {
            fVar.a_renamed(true, false);
            this.I_renamed.d_renamed(0);
        }
    }

    public void c_renamed(android.graphics.Bitmap bitmap) {
        com.oplus.camera.e_renamed.a_renamed("CameraUIManager", "showVideoAlert");
        this.n_renamed = true;
        com.oplus.camera.ui.preview.g_renamed gVar = this.A_renamed;
        if (gVar != null) {
            gVar.b_renamed(bitmap);
        }
        com.oplus.camera.ui.control.a_renamed aVar = this.z_renamed;
        if (aVar != null) {
            aVar.J_renamed();
        }
        com.oplus.camera.ui.menu.setting.o_renamed oVar = this.H_renamed;
        if (oVar != null) {
            oVar.a_renamed(false, true);
            this.H_renamed.d_renamed(4);
            if (this.i_renamed.getApplication().getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.third_video_preview_margin_top) > 0) {
                this.H_renamed.d_renamed(!com.oplus.camera.util.Util.W_renamed(), true);
            }
        }
        com.oplus.camera.ui.menu.setting.f_renamed fVar = this.I_renamed;
        if (fVar != null) {
            fVar.a_renamed(false, true);
            this.I_renamed.a_renamed(4);
        }
        a_renamed(true, true, false);
    }

    public void cn_renamed() {
        com.oplus.camera.ui.preview.g_renamed gVar = this.A_renamed;
        if (gVar != null) {
            gVar.I_renamed();
        }
    }

    public boolean g_renamed(int i_renamed, int i2) {
        com.oplus.camera.ui.control.a_renamed aVar = this.z_renamed;
        if (aVar == null || !aVar.ac_renamed()) {
            return false;
        }
        this.z_renamed.ad_renamed();
        return true;
    }

    public boolean b_renamed(int i_renamed, int i2, long j_renamed) {
        com.oplus.camera.e_renamed.a_renamed("CameraUIManager", "onSingleTapUp, x_renamed: " + i_renamed + ", y_renamed: " + i2);
        com.oplus.camera.ui.modepanel.p_renamed pVar = this.bd_renamed;
        if (pVar != null && pVar.e_renamed()) {
            return true;
        }
        com.oplus.camera.ui.menu.setting.q_renamed qVar = this.aK_renamed;
        if (qVar != null && qVar.onSingleTapUp(i_renamed, i2)) {
            return true;
        }
        if (aA_renamed()) {
            J_renamed(true);
            return true;
        }
        com.oplus.camera.ui.menu.facebeauty.g_renamed gVar = this.aT_renamed;
        if (gVar != null && gVar.n_renamed()) {
            a_renamed(true, true, true, true);
            return true;
        }
        com.oplus.camera.ui.menu.setting.f_renamed fVar = this.I_renamed;
        if (fVar != null) {
            if (fVar.a_renamed(j_renamed)) {
                return true;
            }
            com.oplus.camera.e_renamed.a_renamed("CameraUIManager", "onSingleTapUp, isDrawerAnimationRun: " + this.I_renamed.p_renamed() + ", isSubSettingMenuOpen: " + this.I_renamed.j_renamed());
            if (this.I_renamed.j_renamed() || this.I_renamed.p_renamed()) {
                if (!this.I_renamed.p_renamed()) {
                    this.B_renamed.edit().putString(com.oplus.camera.ui.CameraUIInterface.KEY_SUB_SETTING, "off").apply();
                    f_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_SUB_SETTING);
                }
                return true;
            }
        }
        com.oplus.camera.ui.control.a_renamed aVar = this.z_renamed;
        if (aVar == null || !aVar.ac_renamed()) {
            return false;
        }
        this.z_renamed.ad_renamed();
        return true;
    }

    @Override // com.oplus.camera.ui.CameraUIInterface
    public void o_renamed() {
        com.oplus.camera.ui.preview.g_renamed gVar = this.A_renamed;
        if (gVar != null) {
            gVar.A_renamed();
        }
    }

    public void co_renamed() {
        com.oplus.camera.ui.preview.g_renamed gVar = this.A_renamed;
        if (gVar != null) {
            gVar.B_renamed();
        }
    }

    @Override // com.oplus.camera.ui.preview.g_renamed.b_renamed
    public boolean cp_renamed() {
        com.oplus.camera.ui.CameraUIListener cameraUIListener = this.J_renamed;
        if (cameraUIListener != null) {
            return cameraUIListener.B_renamed();
        }
        return false;
    }

    @Override // com.oplus.camera.ui.preview.g_renamed.b_renamed
    public void cq_renamed() {
        com.oplus.camera.ui.CameraUIListener cameraUIListener = this.J_renamed;
        if (cameraUIListener != null) {
            cameraUIListener.m_renamed();
        }
    }

    @Override // com.oplus.camera.ui.preview.g_renamed.b_renamed
    public void cr_renamed() {
        com.oplus.camera.ui.menu.levelcontrol.g_renamed gVar = this.ah_renamed;
        if (gVar == null || !gVar.isEffectMenuOpen() || !this.J_renamed.h_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_FILTER_PROCESS) || this.J_renamed.c_renamed() || this.o_renamed) {
            return;
        }
        this.ah_renamed.g_renamed();
    }

    @Override // com.oplus.camera.ui.preview.g_renamed.b_renamed
    public void cs_renamed() {
        com.oplus.camera.ui.CameraUIListener cameraUIListener = this.J_renamed;
        if (cameraUIListener != null) {
            cameraUIListener.D_renamed();
        }
    }

    @Override // com.oplus.camera.ui.preview.g_renamed.b_renamed
    public void ct_renamed() {
        com.oplus.camera.ui.CameraUIListener cameraUIListener = this.J_renamed;
        if (cameraUIListener != null) {
            cameraUIListener.E_renamed();
        }
    }

    @Override // com.oplus.camera.ui.preview.g_renamed.b_renamed
    public int cu_renamed() {
        com.oplus.camera.ui.CameraUIListener cameraUIListener = this.J_renamed;
        if (cameraUIListener != null) {
            return cameraUIListener.F_renamed();
        }
        return 0;
    }

    @Override // com.oplus.camera.ui.preview.g_renamed.b_renamed
    public int cv_renamed() {
        com.oplus.camera.ui.CameraUIListener cameraUIListener = this.J_renamed;
        if (cameraUIListener != null) {
            return cameraUIListener.G_renamed();
        }
        return 0;
    }

    @Override // com.oplus.camera.ui.preview.g_renamed.b_renamed
    public boolean j_renamed(java.lang.String str) {
        com.oplus.camera.ui.CameraUIListener cameraUIListener = this.J_renamed;
        if (cameraUIListener != null) {
            return cameraUIListener.h_renamed(str);
        }
        return false;
    }

    public void cw_renamed() {
        if (com.oplus.camera.ui.menu.g_renamed.a_renamed()) {
            com.oplus.camera.ui.menu.g_renamed.d_renamed();
        }
    }

    @Override // com.oplus.camera.ui.CameraUIInterface
    public void L_renamed(boolean z_renamed) {
        com.oplus.camera.ui.menu.setting.f_renamed fVar = this.I_renamed;
        if (fVar != null) {
            fVar.c_renamed(z_renamed);
        }
    }

    public boolean k_renamed(java.lang.String str) {
        com.oplus.camera.ui.menu.setting.o_renamed oVar = this.H_renamed;
        if (oVar != null) {
            return oVar.c_renamed(str);
        }
        return false;
    }

    @Override // com.oplus.camera.ui.CameraUIInterface
    public void a_renamed(java.lang.String str, java.lang.String str2) {
        java.lang.String strB = com.oplus.camera.entry.b_renamed.b_renamed(str, this.K_renamed);
        if (com.oplus.camera.ui.menu.g_renamed.a_renamed()) {
            com.oplus.camera.ui.menu.g_renamed.d_renamed();
        }
        com.oplus.camera.ui.menu.setting.o_renamed oVar = this.H_renamed;
        if (oVar != null) {
            oVar.a_renamed(strB, str2);
        }
        com.oplus.camera.ui.menu.setting.f_renamed fVar = this.I_renamed;
        if (fVar != null) {
            fVar.a_renamed(strB, str2);
        }
    }

    @Override // com.oplus.camera.ui.CameraUIInterface
    public void b_renamed(java.lang.String str, java.lang.String str2) {
        java.lang.String strB = com.oplus.camera.entry.b_renamed.b_renamed(str, this.K_renamed);
        com.oplus.camera.ui.menu.setting.o_renamed oVar = this.H_renamed;
        if (oVar != null) {
            oVar.b_renamed(strB, str2);
        }
        com.oplus.camera.ui.menu.setting.f_renamed fVar = this.I_renamed;
        if (fVar != null) {
            fVar.b_renamed(strB, str2);
        }
    }

    @Override // com.oplus.camera.ui.CameraUIInterface
    public void a_renamed(java.lang.String str, java.lang.String... strArr) {
        com.oplus.camera.ui.menu.setting.o_renamed oVar = this.H_renamed;
        if (oVar != null) {
            oVar.a_renamed(str, strArr);
        }
        com.oplus.camera.ui.menu.setting.f_renamed fVar = this.I_renamed;
        if (fVar != null) {
            fVar.a_renamed(str, strArr);
        }
    }

    @Override // com.oplus.camera.ui.CameraUIInterface
    public void b_renamed(java.lang.String str, java.lang.String... strArr) {
        com.oplus.camera.ui.menu.setting.o_renamed oVar = this.H_renamed;
        if (oVar != null) {
            oVar.b_renamed(str, strArr);
        }
        com.oplus.camera.ui.menu.setting.f_renamed fVar = this.I_renamed;
        if (fVar != null) {
            fVar.b_renamed(str, strArr);
        }
    }

    @Override // com.oplus.camera.ui.CameraUIInterface
    public void d_renamed(java.lang.String str) {
        java.lang.String strB = com.oplus.camera.entry.b_renamed.b_renamed(str, this.K_renamed);
        com.oplus.camera.ui.menu.setting.o_renamed oVar = this.H_renamed;
        if (oVar != null) {
            oVar.d_renamed(strB);
        }
        com.oplus.camera.ui.menu.setting.f_renamed fVar = this.I_renamed;
        if (fVar != null) {
            fVar.d_renamed(strB);
        }
    }

    @Override // com.oplus.camera.ui.CameraUIInterface
    public void e_renamed(java.lang.String str) {
        java.lang.String strB = com.oplus.camera.entry.b_renamed.b_renamed(str, this.K_renamed);
        com.oplus.camera.ui.menu.setting.o_renamed oVar = this.H_renamed;
        if (oVar != null) {
            oVar.e_renamed(strB);
        }
        com.oplus.camera.ui.menu.setting.f_renamed fVar = this.I_renamed;
        if (fVar != null) {
            fVar.e_renamed(strB);
        }
    }

    @Override // com.oplus.camera.ui.CameraUIInterface
    public void f_renamed(java.lang.String str) {
        java.lang.String strB = com.oplus.camera.entry.b_renamed.b_renamed(str, this.K_renamed);
        com.oplus.camera.ui.menu.setting.o_renamed oVar = this.H_renamed;
        if (oVar != null) {
            oVar.f_renamed(strB);
        }
        com.oplus.camera.ui.menu.setting.f_renamed fVar = this.I_renamed;
        if (fVar != null) {
            fVar.f_renamed(strB);
        }
    }

    @Override // com.oplus.camera.ui.CameraUIInterface
    public void b_renamed(java.lang.String str, int i_renamed) {
        com.oplus.camera.ui.menu.setting.o_renamed oVar = this.H_renamed;
        if (oVar != null) {
            oVar.b_renamed(str, i_renamed);
        }
        com.oplus.camera.ui.menu.setting.f_renamed fVar = this.I_renamed;
        if (fVar != null) {
            fVar.b_renamed(str, i_renamed);
        }
    }

    @Override // com.oplus.camera.ui.CameraUIInterface
    public void q_renamed() {
        com.oplus.camera.ui.menu.setting.o_renamed oVar = this.H_renamed;
        if (oVar != null) {
            oVar.r_renamed();
        }
        com.oplus.camera.ui.menu.setting.f_renamed fVar = this.I_renamed;
        if (fVar != null) {
            fVar.r_renamed();
        }
    }

    public void c_renamed(int i_renamed, boolean z_renamed, boolean z2) {
        com.oplus.camera.e_renamed.a_renamed("entryCameraUpdateSettingMenu");
        boolean z3 = false;
        if (this.H_renamed != null) {
            if (dY_renamed()) {
                this.H_renamed.b_renamed(0.0f);
            }
            this.H_renamed.b_renamed(i_renamed, z2, (this.n_renamed || z_renamed || (this.aT_renamed.n_renamed() && 1 == aX_renamed())) ? false : true, R_renamed());
        }
        com.oplus.camera.ui.menu.setting.f_renamed fVar = this.I_renamed;
        if (fVar != null) {
            if (!this.n_renamed && !z_renamed) {
                z3 = true;
            }
            fVar.b_renamed(i_renamed, z2, z3, R_renamed());
        }
        com.oplus.camera.e_renamed.b_renamed("entryCameraUpdateSettingMenu");
    }

    @Override // com.oplus.camera.ui.CameraUIInterface
    public void V_renamed() {
        this.J_renamed.a_renamed();
    }

    public void cx_renamed() {
        this.ai_renamed.hideMenu(true, true, false, true);
    }

    public boolean a_renamed(android.view.MotionEvent motionEvent) {
        com.oplus.camera.ui.menu.setting.f_renamed fVar;
        if (dF_renamed() || f_renamed(motionEvent)) {
            return true;
        }
        if (!this.J_renamed.bp_renamed() && !this.J_renamed.K_renamed() && !dr_renamed()) {
            if (K_renamed() && !com.oplus.camera.util.Util.a_renamed(bD_renamed(), motionEvent.getX(), motionEvent.getY()) && !fH_renamed() && !eD_renamed()) {
                com.oplus.camera.ui.preview.g_renamed gVar = this.A_renamed;
                return gVar != null && gVar.a_renamed(motionEvent);
            }
            if (this.I_renamed != null && T_renamed() && !com.oplus.camera.util.Util.a_renamed(this.I_renamed.B_renamed(), motionEvent.getX(), motionEvent.getY()) && 1 == this.J_renamed.ca_renamed()) {
                U_renamed();
            } else if (O_renamed()) {
                com.oplus.camera.ui.a_renamed.a_renamed aVar = this.ac_renamed;
                if (aVar != null) {
                    aVar.a_renamed(true);
                    this.ac_renamed.b_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_BLUR_MENU_STATE);
                }
                com.oplus.camera.ui.a_renamed.a_renamed aVar2 = this.ac_renamed;
                if (aVar2 != null) {
                    aVar2.a_renamed(false);
                    this.ac_renamed.b_renamed((java.lang.String) null);
                }
            } else if (!ep_renamed() && !this.J_renamed.L_renamed() && !this.J_renamed.N_renamed() && !this.J_renamed.O_renamed() && ec_renamed() && j_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_SUB_SETTING) && 1 != this.J_renamed.ca_renamed() && this.I_renamed.a_renamed(motionEvent)) {
                return true;
            }
        } else if (this.J_renamed.bp_renamed() && (fVar = this.I_renamed) != null && fVar.c_renamed()) {
            this.I_renamed.d_renamed(false);
            this.I_renamed.a_renamed(8);
        }
        com.oplus.camera.ui.preview.g_renamed gVar2 = this.A_renamed;
        return gVar2 != null && gVar2.a_renamed(motionEvent);
    }

    private boolean f_renamed(android.view.MotionEvent motionEvent) {
        com.oplus.camera.ComboPreferences comboPreferences;
        com.oplus.camera.ui.preview.g_renamed gVar;
        com.oplus.camera.ui.CameraUIListener cameraUIListener = this.J_renamed;
        if (cameraUIListener == null || !com.oplus.camera.aps.constant.ApsConstant.CAPTURE_MODE_MULTI_VIDEO.equals(cameraUIListener.ao_renamed()) || (comboPreferences = this.B_renamed) == null || comboPreferences.getInt(com.oplus.camera.ui.CameraUIInterface.KEY_MULTI_CAMERA_TYPE_SELECTED, 0) == 0 || (gVar = this.A_renamed) == null || gVar.x_renamed() == null) {
            return false;
        }
        boolean zA = com.oplus.camera.gl_renamed.b_renamed.e_renamed.a_renamed().a_renamed(motionEvent, this.A_renamed.x_renamed());
        if (zA) {
            if (aA_renamed()) {
                com.oplus.camera.e_renamed.b_renamed("CameraUIManager", "touchMultiVideoSmallSurface, consumed by_renamed MultiVideoSmallSurface");
                J_renamed(true);
            }
            if (this.J_renamed.bp_renamed()) {
                this.J_renamed.bo_renamed();
            }
            if (1 == motionEvent.getAction()) {
                this.J_renamed.q_renamed(com.oplus.camera.statistics.model.FocusAimMsgData.KEY_MULTI_VIDEO_DRAG_SCREEN_FOCUS_TYPE);
            }
        }
        return zA;
    }

    public boolean b_renamed(android.view.MotionEvent motionEvent) {
        if (this.I_renamed == null || !T_renamed()) {
            return false;
        }
        return this.I_renamed.b_renamed(motionEvent);
    }

    @Override // com.oplus.camera.ui.CameraUIInterface
    public void t_renamed() {
        com.oplus.camera.ui.preview.g_renamed gVar = this.A_renamed;
        if (gVar != null) {
            gVar.T_renamed();
        }
    }

    @Override // com.oplus.camera.ui.CameraUIInterface
    public void a_renamed(android.content.DialogInterface.OnCancelListener onCancelListener) {
        com.oplus.camera.ui.preview.g_renamed gVar = this.A_renamed;
        if (gVar != null) {
            gVar.a_renamed(onCancelListener);
        }
    }

    @Override // com.oplus.camera.ui.CameraUIInterface
    public java.lang.String y_renamed() {
        com.oplus.camera.ui.preview.g_renamed gVar = this.A_renamed;
        return gVar != null ? gVar.P_renamed() : "";
    }

    @Override // com.oplus.camera.ui.CameraUIInterface
    public void h_renamed(boolean z_renamed) throws android.content.res.Resources.NotFoundException {
        if (this.A_renamed != null) {
            com.oplus.camera.j_renamed.a_renamed aVar = this.bg_renamed;
            this.A_renamed.b_renamed(z_renamed, aVar == null || !aVar.d_renamed());
        }
    }

    @Override // com.oplus.camera.ui.CameraUIInterface
    public void b_renamed(int i_renamed, int i2) {
        com.oplus.camera.ui.preview.g_renamed gVar = this.A_renamed;
        if (gVar != null) {
            gVar.a_renamed(i_renamed, i2);
        }
    }

    public void h_renamed(int i_renamed, int i2) {
        com.oplus.camera.ui.preview.g_renamed gVar = this.A_renamed;
        if (gVar != null) {
            gVar.b_renamed(i_renamed, i2);
        }
    }

    @Override // com.oplus.camera.ui.CameraUIInterface
    public void a_renamed(com.oplus.camera.ui.q_renamed qVar) {
        com.oplus.camera.ui.preview.g_renamed gVar = this.A_renamed;
        if (gVar != null) {
            gVar.a_renamed(qVar);
        }
    }

    @Override // com.oplus.camera.ui.CameraUIInterface
    public com.oplus.camera.gl_renamed.GLRootView a_renamed() {
        return this.A_renamed.O_renamed();
    }

    @Override // com.oplus.camera.ui.CameraUIInterface
    public android.view.ViewGroup b_renamed() {
        return this.Z_renamed;
    }

    @Override // com.oplus.camera.ui.CameraUIInterface
    public void a_renamed(int i_renamed, boolean z_renamed, boolean z2) {
        com.oplus.camera.ui.preview.g_renamed gVar = this.A_renamed;
        if (gVar != null) {
            gVar.a_renamed(i_renamed, z_renamed, z2);
        }
    }

    @Override // com.oplus.camera.ui.CameraUIInterface
    public void e_renamed(boolean z_renamed, boolean z2) {
        com.oplus.camera.ui.preview.g_renamed gVar = this.A_renamed;
        if (gVar != null) {
            gVar.a_renamed(z_renamed, z2);
        }
    }

    @Override // com.oplus.camera.ui.CameraUIInterface
    public void c_renamed(java.lang.String str, int i_renamed) {
        this.ah_renamed.b_renamed(i_renamed);
        if (j_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_PORTRAIT_NEW_STYLE_MENU)) {
            g_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_PORTRAIT_NEW_STYLE_MENU);
            return;
        }
        if (j_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_FILTER_MENU)) {
            g_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_FILTER_MENU);
            return;
        }
        if (j_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_FILTER_MENU)) {
            g_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_FILTER_MENU);
        } else if (j_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_NIGHT_FILTER_MENU)) {
            g_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_NIGHT_FILTER_MENU);
        } else if (j_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_STREET_FILTER_MENU)) {
            g_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_STREET_FILTER_MENU);
        }
    }

    @Override // com.oplus.camera.ui.CameraUIInterface
    public void a_renamed(java.lang.String str, boolean z_renamed) {
        this.H_renamed.c_renamed(str, z_renamed);
    }

    @Override // com.oplus.camera.ui.CameraUIInterface
    public void j_renamed(int i_renamed) {
        fg_renamed();
    }

    @Override // com.oplus.camera.ui.CameraUIInterface
    public void z_renamed() {
        com.oplus.camera.ui.menu.facebeauty.g_renamed gVar = this.aT_renamed;
        if (gVar != null) {
            gVar.x_renamed();
        }
    }

    @Override // com.oplus.camera.ui.CameraUIInterface
    public int am_renamed() {
        com.oplus.camera.ui.menu.setting.o_renamed oVar = this.H_renamed;
        if (oVar != null) {
            return oVar.P_renamed();
        }
        return 0;
    }

    @Override // com.oplus.camera.ui.CameraUIInterface
    public int an_renamed() {
        com.oplus.camera.ui.control.a_renamed aVar = this.z_renamed;
        if (aVar != null) {
            return aVar.S_renamed();
        }
        return 0;
    }

    @Override // com.oplus.camera.ui.CameraUIInterface
    public boolean aU_renamed() {
        com.oplus.camera.ui.preview.a_renamed aVar = this.aH_renamed;
        return aVar != null && aVar.i_renamed();
    }

    @Override // com.oplus.camera.ui.CameraUIInterface
    public java.lang.String aV_renamed() {
        com.oplus.camera.ui.CameraUIListener cameraUIListener = this.J_renamed;
        if (cameraUIListener != null) {
            return cameraUIListener.ao_renamed();
        }
        return null;
    }

    @Override // com.oplus.camera.ui.CameraUIInterface
    public boolean aW_renamed() {
        return c_renamed() != null && c_renamed().v_renamed();
    }

    @Override // com.oplus.camera.ui.CameraUIInterface
    public int bc_renamed() {
        com.oplus.camera.screen.b_renamed.a_renamed aVar = this.bx_renamed;
        if (aVar != null) {
            return aVar.m_renamed();
        }
        return -1;
    }

    @Override // com.oplus.camera.ui.CameraUIInterface
    public void w_renamed(int i_renamed) {
        this.T_renamed = i_renamed;
    }

    @Override // com.oplus.camera.ui.CameraUIInterface
    public android.net.Uri ao_renamed() {
        com.oplus.camera.ui.control.a_renamed aVar = this.z_renamed;
        if (aVar != null) {
            return aVar.t_renamed().e_renamed();
        }
        return null;
    }

    public boolean c_renamed(boolean z_renamed, boolean z2, boolean z3) {
        if (dH_renamed()) {
            return false;
        }
        if (z3 && !z_renamed && !z2) {
            com.oplus.camera.e_renamed.c_renamed("CameraUIManager", "showAEAFLockView, wait for AF lock, no prompts will be_renamed displayed temporarily.");
            return false;
        }
        cR_renamed();
        this.ac_renamed.c_renamed(eX_renamed());
        this.ac_renamed.a_renamed((!z3 || z2) ? com.oplus.camera.R_renamed.string.camera_toast_lock_ae : com.oplus.camera.R_renamed.string.camera_toast_lock_ae_af, false, true, com.oplus.camera.R_renamed.drawable.screen_hint_textview_bg, com.oplus.camera.R_renamed.color.screen_hint_text_color, this.T_renamed, dY_renamed());
        aF_renamed(false);
        return true;
    }

    public void cy_renamed() {
        a_renamed(com.oplus.camera.R_renamed.string.camera_toast_lock_ae);
        a_renamed(com.oplus.camera.R_renamed.string.camera_toast_lock_ae_af);
    }

    public void cz_renamed() {
        com.oplus.camera.ui.preview.g_renamed gVar = this.A_renamed;
        if (gVar != null) {
            gVar.q_renamed();
        }
    }

    public void cA_renamed() {
        com.oplus.camera.ui.preview.g_renamed gVar = this.A_renamed;
        if (gVar != null) {
            gVar.r_renamed();
        }
    }

    public void cB_renamed() throws android.content.res.Resources.NotFoundException {
        com.oplus.camera.ui.preview.g_renamed gVar = this.A_renamed;
        if (gVar != null) {
            gVar.Q_renamed();
        }
        if (com.oplus.camera.util.Util.p_renamed()) {
            com.oplus.camera.util.Util.a_renamed(this.i_renamed, com.oplus.camera.R_renamed.string.camera_camera_error_title);
        }
        com.oplus.camera.j_renamed.a_renamed aVar = this.bg_renamed;
        if (aVar != null) {
            aVar.c_renamed(this.i_renamed);
        }
    }

    public void a_renamed(android.content.SharedPreferences sharedPreferences, java.lang.String str) {
        com.oplus.camera.ComboPreferences comboPreferences;
        com.oplus.camera.ui.CameraUIListener cameraUIListener;
        if (this.p_renamed) {
            return;
        }
        if (com.oplus.camera.ui.CameraUIInterface.KEY_TORCH_MODE.equals(str)) {
            java.lang.String string = sharedPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_TORCH_MODE, com.oplus.camera.util.Util.F_renamed(this.i_renamed));
            if ("off".equals(string)) {
                cK_renamed();
            } else {
                com.oplus.camera.ui.CameraUIListener cameraUIListener2 = this.J_renamed;
                if (cameraUIListener2 != null && !cameraUIListener2.h_renamed(com.oplus.camera.aps.config.CameraFunction.TORCH_SOFT_LIGHT)) {
                    cJ_renamed();
                }
            }
            if ("off".equals(string)) {
                com.oplus.camera.ui.inverse.e_renamed.INS.setInverseColor((android.content.Context) this.i_renamed, false, true);
                a_renamed(A_renamed(), this.J_renamed.aE_renamed());
                z_renamed();
                return;
            } else {
                if (!"on_renamed".equals(string) || (cameraUIListener = this.J_renamed) == null || cameraUIListener.h_renamed(com.oplus.camera.aps.config.CameraFunction.TORCH_SOFT_LIGHT)) {
                    return;
                }
                com.oplus.camera.ui.inverse.e_renamed.INS.setInverseColor((android.content.Context) this.i_renamed, true, true);
                a_renamed(A_renamed(), this.J_renamed.aE_renamed());
                z_renamed();
                return;
            }
        }
        if (com.oplus.camera.ui.CameraUIInterface.KEY_FLASH_MODE.equals(str) && !sharedPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_FLASH_MODE, "off").equals("off") && sharedPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_HIGH_RESOLUTION, "off").equals("on_renamed")) {
            android.content.SharedPreferences.Editor editorEdit = sharedPreferences.edit();
            editorEdit.putString(com.oplus.camera.ui.CameraUIInterface.KEY_HIGH_RESOLUTION, "off");
            editorEdit.apply();
            b_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_HIGH_RESOLUTION, "off");
        }
        if (!"pref_allow_network_access".equals(str) || (comboPreferences = this.B_renamed) == null || this.C_renamed == null || !comboPreferences.getBoolean("pref_allow_network_access", false)) {
            return;
        }
        this.C_renamed.a_renamed();
        com.oplus.camera.l_renamed.a_renamed(com.oplus.camera.MyApplication.d_renamed());
    }

    public void cC_renamed() {
        com.oplus.camera.ui.control.a_renamed aVar = this.z_renamed;
        if (aVar != null) {
            aVar.M_renamed();
        }
    }

    public void cD_renamed() {
        com.oplus.camera.ui.control.a_renamed aVar = this.z_renamed;
        if (aVar != null) {
            aVar.N_renamed();
        }
    }

    public void cE_renamed() {
        com.oplus.camera.ui.control.a_renamed aVar = this.z_renamed;
        if (aVar != null) {
            aVar.O_renamed();
        }
    }

    public boolean cF_renamed() throws java.lang.IllegalStateException {
        com.oplus.camera.ui.menu.setting.q_renamed qVar;
        com.oplus.camera.j_renamed.a_renamed aVar;
        this.q_renamed = true;
        this.U_renamed = 0L;
        com.oplus.camera.screen.a_renamed.b_renamed bVar = this.k_renamed;
        if (bVar != null && bVar.f_renamed()) {
            this.k_renamed.b_renamed();
            return true;
        }
        if (this.aC_renamed != null) {
            f_renamed(18, true);
        }
        com.oplus.camera.ui.menu.facebeauty.g_renamed gVar = this.aT_renamed;
        if (gVar != null && gVar.n_renamed()) {
            a_renamed(true, true, true, true);
            return true;
        }
        com.oplus.camera.ui.menu.setting.o_renamed oVar = this.H_renamed;
        if ((oVar != null && oVar.D_renamed()) || (((qVar = this.aK_renamed) != null && qVar.onBackPressed()) || ((aVar = this.bg_renamed) != null && aVar.c_renamed()))) {
            return true;
        }
        if (R_renamed()) {
            aj_renamed(-1);
            return true;
        }
        com.oplus.camera.doubleexposure.g_renamed gVar2 = this.bs_renamed;
        if (gVar2 != null && gVar2.o_renamed()) {
            eB_renamed();
            return true;
        }
        com.oplus.camera.timelapsepro.f_renamed fVar = this.bQ_renamed;
        if (fVar == null || !fVar.isShown()) {
            return false;
        }
        this.bQ_renamed.b_renamed();
        aA_renamed(true);
        return true;
    }

    public void a_renamed(int i_renamed, java.lang.Object... objArr) {
        if (this.t_renamed) {
            return;
        }
        a_renamed(i_renamed, 3000, objArr);
    }

    @Override // com.oplus.camera.ui.CameraUIInterface
    public void a_renamed(final int i_renamed, final int i2, final java.lang.Object... objArr) {
        android.app.Activity activity;
        if (this.I_renamed.j_renamed() || R_renamed() || (activity = this.i_renamed) == null) {
            return;
        }
        activity.runOnUiThread(new java.lang.Runnable() { // from class: com.oplus.camera.ui.d_renamed.18
            @Override // java.lang.Runnable
            public void run() {
                com.oplus.camera.ui.d_renamed.this.cR_renamed();
                com.oplus.camera.ui.d_renamed.this.ac_renamed.a_renamed(i_renamed, false, true, i2, com.oplus.camera.ui.d_renamed.this.T_renamed, false, com.oplus.camera.ui.d_renamed.this.j_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_FULL_SCREEN_CENTER_SUPPORT), true, objArr);
            }
        });
    }

    @Override // com.oplus.camera.ui.CameraUIInterface
    public void a_renamed(final int i_renamed, final int i2, final int i3, final java.lang.Object... objArr) {
        android.app.Activity activity;
        if (this.I_renamed.j_renamed() || R_renamed() || (activity = this.i_renamed) == null) {
            return;
        }
        activity.runOnUiThread(new java.lang.Runnable() { // from class: com.oplus.camera.ui.d_renamed.19
            @Override // java.lang.Runnable
            public void run() {
                com.oplus.camera.ui.d_renamed.this.cR_renamed();
                com.oplus.camera.ui.d_renamed.this.ac_renamed.a_renamed(i_renamed, false, true, i2, com.oplus.camera.ui.d_renamed.this.T_renamed, false, com.oplus.camera.ui.d_renamed.this.j_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_FULL_SCREEN_CENTER_SUPPORT), true, i3, objArr);
            }
        });
    }

    public void cG_renamed() {
        android.app.Activity activity;
        if (this.I_renamed.j_renamed() || (activity = this.i_renamed) == null) {
            return;
        }
        activity.runOnUiThread(new java.lang.Runnable() { // from class: com.oplus.camera.ui.d_renamed.20
            @Override // java.lang.Runnable
            public void run() {
                com.oplus.camera.ui.d_renamed.this.cR_renamed();
                com.oplus.camera.ui.d_renamed.this.ac_renamed.a_renamed(com.oplus.camera.R_renamed.string.camera_toast_unfold_palm_shutter, false, true, 5000, com.oplus.camera.R_renamed.drawable.screen_hint_textview_bg, com.oplus.camera.R_renamed.color.screen_hint_text_color, 0, false, false, true, -1, null);
            }
        });
    }

    @Override // com.oplus.camera.ui.CameraUIInterface
    public void a_renamed(com.oplus.camera.ui.MicroscopeHintView.a_renamed aVar, boolean z_renamed, int i_renamed) {
        if (this.an_renamed == null && this.Z_renamed != null) {
            this.an_renamed = (com.oplus.camera.ui.MicroscopeHintView) this.i_renamed.getLayoutInflater().inflate(com.oplus.camera.R_renamed.layout.microscope_hint, (android.view.ViewGroup) null);
            android.widget.RelativeLayout.LayoutParams layoutParams = new android.widget.RelativeLayout.LayoutParams(-2, -2);
            layoutParams.topMargin = com.oplus.camera.util.Util.L_renamed() + com.oplus.camera.util.Util.N_renamed() + this.i_renamed.getApplication().getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.microscope_guide_anim_margin_top) + this.i_renamed.getApplication().getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.toast_margin_top_text) + i_renamed;
            layoutParams.addRule(14);
            this.Z_renamed.addView(this.an_renamed, layoutParams);
        }
        com.oplus.camera.ui.MicroscopeHintView microscopeHintView = this.an_renamed;
        if (microscopeHintView != null) {
            if (z_renamed) {
                microscopeHintView.a_renamed(aVar, this, this.B_renamed);
                al_renamed();
            } else {
                microscopeHintView.a_renamed();
            }
        }
    }

    @Override // com.oplus.camera.ui.CameraUIInterface
    public boolean aQ_renamed() {
        com.oplus.camera.ui.MicroscopeHintView microscopeHintView = this.an_renamed;
        if (microscopeHintView != null) {
            return microscopeHintView.b_renamed();
        }
        return false;
    }

    @Override // com.oplus.camera.ui.CameraUIInterface
    public void a_renamed(android.view.View.OnClickListener onClickListener, boolean z_renamed, boolean z2) throws android.content.res.Resources.NotFoundException {
        if (this.aq_renamed == null && this.Z_renamed != null) {
            this.aq_renamed = new com.oplus.camera.ui.RotateImageView(this.i_renamed);
            this.aq_renamed.setImageResource(com.oplus.camera.R_renamed.drawable.professional_guide_tip);
            this.Z_renamed.addView(this.aq_renamed);
        }
        if (this.aq_renamed != null) {
            int dimensionPixelSize = this.i_renamed.getApplication().getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.common_bottom_guide_professional_entry_size);
            android.widget.RelativeLayout.LayoutParams layoutParams = new android.widget.RelativeLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize);
            layoutParams.rightMargin = this.i_renamed.getApplication().getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.microscope_guide_entry_margin_right);
            layoutParams.addRule(10);
            layoutParams.addRule(21);
            if (z2) {
                layoutParams.topMargin = this.i_renamed.getApplication().getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.microscope_guide_entry_margin_capture_mode_top);
            } else {
                layoutParams.topMargin = this.i_renamed.getApplication().getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.microscope_guide_entry_margin_video_mode_top);
            }
            this.aq_renamed.setLayoutParams(layoutParams);
            this.aq_renamed.setOnClickListener(onClickListener);
            if (z_renamed) {
                com.oplus.camera.util.Util.a_renamed(this.aq_renamed, 0, (android.view.animation.Animation.AnimationListener) null, 500L);
            } else {
                com.oplus.camera.util.Util.a_renamed(this.aq_renamed, 8, (android.view.animation.Animation.AnimationListener) null, 180L);
            }
        }
    }

    public boolean cH_renamed() {
        com.oplus.camera.ui.camerascreenhint.CameraScreenHintView cameraScreenHintView = this.am_renamed;
        return cameraScreenHintView != null && cameraScreenHintView.isShown();
    }

    public void ad_renamed(boolean z_renamed) {
        long jCurrentTimeMillis = com.google.android.exoplayer2.DefaultRenderersFactory.DEFAULT_ALLOWED_VIDEO_JOINING_TIME_MS;
        if (!z_renamed || com.google.android.exoplayer2.DefaultRenderersFactory.DEFAULT_ALLOWED_VIDEO_JOINING_TIME_MS > java.lang.System.currentTimeMillis() - this.X_renamed) {
            if (this.am_renamed == null && this.Z_renamed != null) {
                this.am_renamed = (com.oplus.camera.ui.camerascreenhint.CameraScreenHintView) this.i_renamed.getLayoutInflater().inflate(com.oplus.camera.R_renamed.layout.camera_screen_hint, (android.view.ViewGroup) null);
                android.view.View view = this.al_renamed;
                if (view != null) {
                    android.view.ViewGroup viewGroup = this.Z_renamed;
                    viewGroup.addView(this.am_renamed, viewGroup.indexOfChild(view));
                } else {
                    this.Z_renamed.addView(this.am_renamed);
                }
            }
            final java.lang.String string = this.B_renamed.getString(com.oplus.camera.ui.CameraUIInterface.KEY_PHOTO_RATIO, this.i_renamed.getString(com.oplus.camera.R_renamed.string.camera_photo_ratio_default_value));
            final com.oplus.camera.ui.camerascreenhint.CameraScreenHintView cameraScreenHintView = this.ae_renamed;
            if (cameraScreenHintView != null) {
                cameraScreenHintView.getHintTextView().getViewTreeObserver().addOnGlobalLayoutListener(new android.view.ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.oplus.camera.ui.d_renamed.21
                    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                    public void onGlobalLayout() throws android.content.res.Resources.NotFoundException {
                        int dimensionPixelSize;
                        com.oplus.camera.ui.camerascreenhint.CameraScreenHintView cameraScreenHintView2 = cameraScreenHintView;
                        if (cameraScreenHintView2 != null) {
                            cameraScreenHintView2.getHintTextView().getViewTreeObserver().removeOnGlobalLayoutListener(this);
                            int iM = 0;
                            if (!"square".equals(string)) {
                                if (com.oplus.camera.ui.d_renamed.this.am_renamed != null) {
                                    boolean z2 = true;
                                    if (com.oplus.camera.ui.d_renamed.this.bx_renamed == null || 1 != com.oplus.camera.ui.d_renamed.this.bx_renamed.j_renamed()) {
                                        if (com.oplus.camera.ui.d_renamed.this.bx_renamed != null && 4 == com.oplus.camera.ui.d_renamed.this.bx_renamed.j_renamed() && com.oplus.camera.ui.d_renamed.this.bx_renamed.q_renamed()) {
                                            iM = com.oplus.camera.util.Util.M_renamed() + cameraScreenHintView.getIconWidth();
                                            dimensionPixelSize = com.oplus.camera.ui.d_renamed.this.i_renamed.getApplication().getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.low_rack_mode_camera_screen_hint_view_margin_bottom) - iM;
                                        } else {
                                            dimensionPixelSize = 0;
                                            z2 = false;
                                        }
                                    } else {
                                        z2 = false;
                                        iM = com.oplus.camera.ui.d_renamed.this.i_renamed.getApplication().getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.fold_full_gesture_hint_view_margin_top_offset);
                                        dimensionPixelSize = 0;
                                    }
                                    com.oplus.camera.ui.d_renamed.this.am_renamed.a_renamed(cameraScreenHintView.getHintTextView().getHeight() + com.oplus.camera.util.Util.M_renamed() + iM, dimensionPixelSize, cameraScreenHintView.getHintTextView().getHeight() + cameraScreenHintView.getMarginLeft(), z2);
                                    return;
                                }
                                return;
                            }
                            int iM2 = com.oplus.camera.util.Util.M_renamed();
                            if (com.oplus.camera.ui.d_renamed.this.am_renamed != null) {
                                com.oplus.camera.ui.d_renamed.this.am_renamed.a_renamed(cameraScreenHintView.getHintTextView().getHeight() + com.oplus.camera.ui.d_renamed.this.bT_renamed() + iM2, 0, cameraScreenHintView.getHintTextView().getHeight() + cameraScreenHintView.getMarginLeft(), false);
                            }
                        }
                    }
                });
            }
            com.oplus.camera.ui.camerascreenhint.CameraScreenHintView cameraScreenHintView2 = this.am_renamed;
            if (cameraScreenHintView2 != null) {
                cameraScreenHintView2.a_renamed(this.bx_renamed, this.L_renamed);
                this.am_renamed.setCameraScreenHintInterface(this.ck_renamed);
                if (com.oplus.camera.statistics.model.DcsMsgData.FULL.equals(string) || "16_9".equals(string)) {
                    this.am_renamed.setIsGestureHintNeedInverse(true);
                }
                if (z_renamed) {
                    jCurrentTimeMillis = com.google.android.exoplayer2.DefaultRenderersFactory.DEFAULT_ALLOWED_VIDEO_JOINING_TIME_MS - (java.lang.System.currentTimeMillis() - this.X_renamed);
                } else {
                    this.X_renamed = java.lang.System.currentTimeMillis();
                }
                this.am_renamed.a_renamed(com.oplus.camera.R_renamed.drawable.gesture_hint_selector, false, true, (int) jCurrentTimeMillis, false, this.T_renamed);
            }
        }
    }

    @Override // com.oplus.camera.ui.CameraUIInterface
    public void b_renamed(boolean z_renamed) {
        com.oplus.camera.ui.camerascreenhint.CameraScreenHintView cameraScreenHintView = this.am_renamed;
        if (cameraScreenHintView != null) {
            cameraScreenHintView.a_renamed(z_renamed);
        }
    }

    public void ae_renamed(boolean z_renamed) {
        if (!z_renamed) {
            a_renamed(false, false);
        }
        b_renamed(false, false);
        f_renamed(false, false);
        c_renamed(false);
        v_renamed(false);
    }

    @Override // com.oplus.camera.ui.CameraUIInterface
    public void c_renamed(java.lang.String str) {
        com.oplus.camera.ui.control.a_renamed aVar = this.z_renamed;
        if (aVar != null) {
            aVar.b_renamed(str);
        }
    }

    @Override // com.oplus.camera.ui.CameraUIInterface
    public void a_renamed(com.oplus.camera.ui.control.b_renamed bVar) {
        com.oplus.camera.ui.control.a_renamed aVar = this.z_renamed;
        if (aVar != null) {
            aVar.b_renamed(bVar);
        }
    }

    @Override // com.oplus.camera.ui.CameraUIInterface
    public void a_renamed(final com.oplus.camera.ui.control.b_renamed bVar, final boolean z_renamed) {
        android.app.Activity activity = this.i_renamed;
        if (activity != null) {
            activity.runOnUiThread(new java.lang.Runnable() { // from class: com.oplus.camera.ui.d_renamed.23
                @Override // java.lang.Runnable
                public void run() {
                    if (com.oplus.camera.ui.d_renamed.this.z_renamed != null) {
                        com.oplus.camera.ui.d_renamed.this.z_renamed.a_renamed(bVar, z_renamed, !com.oplus.camera.ui.d_renamed.this.dH_renamed());
                    }
                }
            });
        }
    }

    @Override // com.oplus.camera.ui.CameraUIInterface
    public void a_renamed(int i_renamed, boolean z_renamed) {
        if (i_renamed == 0) {
            if (this.bZ_renamed) {
                b_renamed(z_renamed, 1);
                this.bZ_renamed = false;
                return;
            } else {
                b_renamed(z_renamed, 0);
                return;
            }
        }
        c_renamed(z_renamed, 0);
    }

    @Override // com.oplus.camera.ui.CameraUIInterface
    public void j_renamed() {
        com.oplus.camera.ui.modepanel.m_renamed mVar = this.aJ_renamed;
        if (mVar != null) {
            mVar.c_renamed();
        }
    }

    @Override // com.oplus.camera.ui.CameraUIInterface
    public void a_renamed(java.lang.String str) throws android.content.res.Resources.NotFoundException {
        com.oplus.camera.ui.modepanel.m_renamed mVar = this.aJ_renamed;
        if (mVar != null) {
            mVar.a_renamed(str);
        }
    }

    public void a_renamed(android.util.Size size, android.util.Size size2, com.oplus.camera.ui.preview.g_renamed.a_renamed aVar, int i_renamed, int i2, int i3, boolean z_renamed) {
        com.oplus.camera.ui.preview.g_renamed gVar = this.A_renamed;
        if (gVar != null) {
            gVar.a_renamed(size, size2, aVar, i_renamed, i2, i3, z_renamed);
        }
    }

    public void G_renamed(int i_renamed) {
        com.oplus.camera.ui.control.a_renamed aVar = this.z_renamed;
        if (aVar != null) {
            aVar.l_renamed(i_renamed);
        }
    }

    public void a_renamed(byte b2, boolean z_renamed) {
        if (this.z_renamed != null) {
            if (dY_renamed() || dX_renamed()) {
                b2 = 2;
            } else if (com.oplus.camera.util.Util.ao_renamed()) {
                b2 = 1;
            }
            this.z_renamed.a_renamed(b2, z_renamed);
        }
    }

    public void y_renamed(boolean z_renamed, boolean z2) {
        if (this.z_renamed != null) {
            this.H_renamed.d_renamed(z_renamed, z2);
        }
    }

    public void af_renamed(boolean z_renamed) {
        com.oplus.camera.ui.menu.setting.o_renamed oVar = this.H_renamed;
        if (oVar != null) {
            oVar.h_renamed(z_renamed);
        }
    }

    public void cI_renamed() {
        com.oplus.camera.ui.preview.g_renamed gVar = this.A_renamed;
        if (gVar != null) {
            gVar.U_renamed();
        }
    }

    @Override // com.oplus.camera.ui.CameraUIInterface
    public void a_renamed(int i_renamed, int i2) {
        if ((this.o_renamed || this.n_renamed) && i_renamed == 0) {
            return;
        }
        a_renamed(i_renamed, false, i2);
    }

    private void a_renamed(int i_renamed, boolean z_renamed, int i2) throws android.content.res.Resources.NotFoundException {
        com.oplus.camera.ui.control.a_renamed aVar = this.z_renamed;
        if (aVar == null || this.p_renamed) {
            return;
        }
        if (i_renamed == 0) {
            this.z_renamed.a_renamed(i2, z_renamed, com.oplus.camera.aps.constant.ApsConstant.CAPTURE_MODE_PROFESSIONAL.equals(this.B_renamed.getString(com.oplus.camera.ui.CameraUIInterface.KEY_CAMERA_MODE, "")) && (this.J_renamed.am_renamed() || this.J_renamed.ah_renamed()));
        } else {
            aVar.a_renamed(i2, z_renamed);
        }
    }

    public void a_renamed(int i_renamed, long j_renamed, long j2, android.animation.TimeInterpolator timeInterpolator, android.animation.Animator.AnimatorListener animatorListener) {
        a_renamed(i_renamed, j_renamed, j2, timeInterpolator, animatorListener, 1);
    }

    public void a_renamed(int i_renamed, long j_renamed, long j2, android.animation.TimeInterpolator timeInterpolator, android.animation.Animator.AnimatorListener animatorListener, int i2) {
        com.oplus.camera.ui.control.a_renamed aVar = this.z_renamed;
        if (aVar != null) {
            aVar.a_renamed(i_renamed, j_renamed, j2, timeInterpolator, animatorListener, i2);
        }
    }

    public void cJ_renamed() {
        if (this.Z_renamed != null && this.al_renamed == null) {
            this.i_renamed.getLayoutInflater().inflate(com.oplus.camera.R_renamed.layout.screen_torch, this.Z_renamed);
            this.al_renamed = this.i_renamed.findViewById(com.oplus.camera.R_renamed.id_renamed.screen_torch);
            this.al_renamed.setForceDarkAllowed(false);
            if (com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_SUPPORT_SCREENHOLE)) {
                com.oplus.camera.ui.preview.ScreenHoleView screenHoleView = (com.oplus.camera.ui.preview.ScreenHoleView) this.i_renamed.findViewById(com.oplus.camera.R_renamed.id_renamed.screen_hole_view);
                android.graphics.Rect rectF = com.oplus.camera.util.Util.f_renamed(com.oplus.camera.util.Util.az_renamed());
                if (rectF != null) {
                    com.oplus.camera.e_renamed.b_renamed("CameraUIManager", "addScreenTorchView, show screen hole view");
                    screenHoleView.setHolePosition(rectF);
                    screenHoleView.setVisibility(0);
                }
            }
        }
    }

    public void cK_renamed() {
        if (this.Z_renamed == null || this.al_renamed == null) {
            return;
        }
        if (com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_SUPPORT_SCREENHOLE)) {
            com.oplus.camera.ui.preview.ScreenHoleView screenHoleView = (com.oplus.camera.ui.preview.ScreenHoleView) this.i_renamed.findViewById(com.oplus.camera.R_renamed.id_renamed.screen_hole_view);
            if (screenHoleView.getVisibility() == 0) {
                com.oplus.camera.e_renamed.b_renamed("CameraUIManager", "addScreenTorchView, hide screen hole view");
                screenHoleView.setVisibility(8);
            }
        }
        this.Z_renamed.removeView(this.al_renamed);
        this.al_renamed = null;
    }

    public void cL_renamed() {
        com.oplus.camera.e_renamed.a_renamed("CameraUIManager", "startScreenTorch, mScreenTorchView: " + this.al_renamed);
        cJ_renamed();
        if (this.al_renamed != null) {
            int configColorValue = com.oplus.camera.aps.config.CameraConfig.getConfigColorValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_FRONT_TORCH_COLOR);
            if (-1 == configColorValue) {
                configColorValue = android.graphics.Color.parseColor("#FFC8C8C8");
            }
            if (this.J_renamed.aZ_renamed()) {
                this.Z_renamed.removeView(this.al_renamed);
            }
            this.al_renamed.setBackgroundColor(configColorValue);
            this.al_renamed.setVisibility(0);
            com.oplus.camera.ui.control.a_renamed aVar = this.z_renamed;
            if (aVar != null) {
                aVar.af_renamed();
            }
        }
        y_renamed(0);
        b_renamed(false, false, false, false);
    }

    public void cM_renamed() {
        com.oplus.camera.ui.CameraUIListener cameraUIListener;
        com.oplus.camera.e_renamed.a_renamed("CameraUIManager", "stopScreenTorch");
        android.view.View view = this.al_renamed;
        if (view != null && view.getVisibility() != 8) {
            this.al_renamed.setVisibility(8);
            if (this.J_renamed.aZ_renamed()) {
                this.Z_renamed.removeView(this.al_renamed);
                this.Z_renamed.addView(this.al_renamed);
            }
        }
        if (this.z_renamed == null || (cameraUIListener = this.J_renamed) == null || !cameraUIListener.h_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_SUPPORT_SHARE_EDIT_THUMB) || this.J_renamed.by_renamed()) {
            return;
        }
        this.z_renamed.ag_renamed();
        this.z_renamed.ah_renamed();
    }

    public boolean cN_renamed() {
        android.view.View view = this.al_renamed;
        if (view != null) {
            return view.isShown();
        }
        return false;
    }

    @Override // com.oplus.camera.ui.CameraUIInterface
    public void a_renamed(int i_renamed, int i2, boolean z_renamed, boolean z2, boolean z3) {
        if (this.t_renamed) {
            return;
        }
        a_renamed(i_renamed, i2, this.T_renamed, z_renamed, z2, z3);
    }

    public void a_renamed(int i_renamed, int i2, int i3, boolean z_renamed, boolean z2, boolean z3) {
        if (this.t_renamed) {
            return;
        }
        a_renamed(i_renamed, i2, i3, z_renamed, z2, z3, false, j_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_FULL_SCREEN_CENTER_SUPPORT), true, 3000, true, 0);
    }

    @Override // com.oplus.camera.ui.CameraUIInterface
    public void a_renamed(int i_renamed, int i2, boolean z_renamed, boolean z2, boolean z3, int i3) {
        a_renamed(i_renamed, i2, this.T_renamed, z_renamed, z2, z3, i3);
    }

    public void a_renamed(int i_renamed, int i2, int i3, boolean z_renamed, boolean z2, boolean z3, int i4) {
        a_renamed(i_renamed, i2, i3, z_renamed, z2, z3, false, j_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_FULL_SCREEN_CENTER_SUPPORT), false, 3000, true, i4);
    }

    public void a_renamed(int i_renamed, int i2, boolean z_renamed, boolean z2, boolean z3, boolean z4) {
        a_renamed(i_renamed, i2, this.T_renamed, z_renamed, z2, z3, false, j_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_FULL_SCREEN_CENTER_SUPPORT), true, 3000, z4, 0);
    }

    @Override // com.oplus.camera.ui.CameraUIInterface
    public void a_renamed(int i_renamed, int i2, boolean z_renamed, boolean z2, boolean z3, boolean z4, boolean z5) {
        a_renamed(i_renamed, i2, this.T_renamed, z_renamed, z2, z3, z4, j_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_FULL_SCREEN_CENTER_SUPPORT), z5, 3000, true, 0);
    }

    @Override // com.oplus.camera.ui.CameraUIInterface
    public void a_renamed(int i_renamed, int i2, boolean z_renamed, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, int i3, boolean z7) {
        a_renamed(i_renamed, i2, this.T_renamed, z_renamed, z2, z3, z4, z5, z6, i3, z7, 0);
    }

    public void a_renamed(final int i_renamed, final int i2, final int i3, final boolean z_renamed, final boolean z2, final boolean z3, final boolean z4, final boolean z5, boolean z6, final int i4, final boolean z7, final int i5) {
        android.app.Activity activity;
        if (i_renamed > 0 && (activity = this.i_renamed) != null) {
            activity.runOnUiThread(new java.lang.Runnable() { // from class: com.oplus.camera.ui.d_renamed.24
                @Override // java.lang.Runnable
                public void run() {
                    if (com.oplus.camera.ui.d_renamed.this.W_renamed(i_renamed)) {
                        return;
                    }
                    com.oplus.camera.ui.d_renamed.this.cR_renamed();
                    com.oplus.camera.ui.d_renamed.this.bu_renamed = i4;
                    if (i5 > 0) {
                        com.oplus.camera.ui.d_renamed.this.ac_renamed.a_renamed(i_renamed, z3, z_renamed, i4, i5, com.oplus.camera.R_renamed.color.color_black_with_full_percent_transparency, i3, z4, z5, z7);
                    } else {
                        com.oplus.camera.ui.d_renamed.this.ac_renamed.a_renamed(i_renamed, z3, z_renamed, i4, i3, z4, z5, z7, new java.lang.Object[0]);
                    }
                }
            });
        }
        if (i2 <= 0 || this.i_renamed == null) {
            return;
        }
        com.oplus.camera.ui.preview.a_renamed aVar = this.aH_renamed;
        if (aVar == null || !aVar.i_renamed()) {
            this.i_renamed.runOnUiThread(new java.lang.Runnable() { // from class: com.oplus.camera.ui.d_renamed.25
                @Override // java.lang.Runnable
                public void run() {
                    if (com.oplus.camera.ui.d_renamed.this.eV_renamed()) {
                        if (com.oplus.camera.ui.d_renamed.this.aH_renamed != null) {
                            com.oplus.camera.ui.d_renamed dVar = com.oplus.camera.ui.d_renamed.this;
                            if (dVar.R_renamed(dVar.aH_renamed.f_renamed())) {
                                return;
                            }
                        }
                        com.oplus.camera.ui.d_renamed.this.cR_renamed();
                        com.oplus.camera.ui.d_renamed.this.ac_renamed.a_renamed(i2, z2, false, 0, z5, i3);
                        com.oplus.camera.ui.d_renamed.this.aF_renamed(false);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean W_renamed(int i_renamed) {
        return !eV_renamed() || !(!aU_renamed() || com.oplus.camera.R_renamed.string.camera_pi_ai_scenes_hint_off == i_renamed || com.oplus.camera.R_renamed.string.camera_ai_scn_microspur == i_renamed || com.oplus.camera.R_renamed.string.camera_high_temperature_flash_disable == i_renamed || com.oplus.camera.R_renamed.string.camera_stop_video_recording_hint == i_renamed || com.oplus.camera.R_renamed.string.camera_high_temperature_video_record_disable == i_renamed || com.oplus.camera.R_renamed.string.explorer_chip_damage_tip == i_renamed) || (com.oplus.camera.R_renamed.string.camera_scene_tripod_night_fixed_phone_tips == i_renamed && !j_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_NIGHT_TRIPOD_MODE));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean eV_renamed() {
        boolean zT = T_renamed();
        boolean zEo = eo_renamed();
        boolean zFb = fb_renamed();
        boolean zR = R_renamed();
        boolean zS = S_renamed();
        com.oplus.camera.e_renamed.b_renamed("CameraUIManager", "showCameraScreenHintView, mbPaused: " + this.p_renamed + ", isSubMenuShowing: " + zT + ", isDrawerSettingGuideAniRunning: " + zEo + ", isMoreModeShown: " + zR + ", isMoreModePanelEnterAnimRunning: " + zS + ", shouldShowDrawerSettingGuideAni: " + zFb);
        return (this.p_renamed || zT || zEo || zR || zS || zFb) ? false : true;
    }

    @Override // com.oplus.camera.ui.CameraUIInterface
    public java.lang.String l_renamed() {
        com.oplus.camera.ui.a_renamed.a_renamed aVar = this.ac_renamed;
        return aVar != null ? aVar.j_renamed() : "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aF_renamed(boolean z_renamed) {
        com.oplus.camera.ui.preview.ae_renamed aeVar;
        com.oplus.camera.ui.CameraUIListener cameraUIListener = this.J_renamed;
        if ((cameraUIListener == null || cameraUIListener.b_renamed()) && (aeVar = this.D_renamed) != null && aeVar.k_renamed()) {
            this.D_renamed.c_renamed(dY_renamed());
        }
    }

    public void cP_renamed() {
        com.oplus.camera.j_renamed.a_renamed aVar = this.bg_renamed;
        if (aVar != null) {
            aVar.c_renamed();
        }
    }

    @Override // com.oplus.camera.ui.CameraUIInterface
    public void a_renamed(boolean z_renamed, boolean z2, final boolean z3) {
        android.app.Activity activity;
        android.app.Activity activity2;
        if (z_renamed && (activity2 = this.i_renamed) != null) {
            activity2.runOnUiThread(new java.lang.Runnable() { // from class: com.oplus.camera.ui.d_renamed.26
                @Override // java.lang.Runnable
                public void run() {
                    com.oplus.camera.ui.d_renamed.this.ac_renamed.c_renamed(z3);
                    com.oplus.camera.ui.d_renamed.this.aF_renamed(true);
                }
            });
        }
        if (!z2 || (activity = this.i_renamed) == null) {
            return;
        }
        activity.runOnUiThread(new java.lang.Runnable() { // from class: com.oplus.camera.ui.d_renamed.27
            @Override // java.lang.Runnable
            public void run() {
                com.oplus.camera.ui.d_renamed.this.ac_renamed.b_renamed(z3);
                com.oplus.camera.ui.d_renamed.this.aF_renamed(true);
            }
        });
    }

    @Override // com.oplus.camera.ui.CameraUIInterface
    public void a_renamed(int i_renamed) {
        com.oplus.camera.ui.a_renamed.a_renamed aVar = this.ac_renamed;
        if (aVar != null) {
            aVar.a_renamed(i_renamed);
        }
    }

    public void cQ_renamed() {
        a_renamed(com.oplus.camera.R_renamed.string.camera_dark_environment_open_flash_toast);
        a_renamed(com.oplus.camera.R_renamed.string.camera_ai_video_low_ambient_light_hint);
        a_renamed(com.oplus.camera.R_renamed.string.camera_ai_video_back_light_hint);
    }

    @Override // com.oplus.camera.ui.CameraUIInterface
    public void a_renamed(final java.util.List<java.lang.Integer> list, final long j_renamed) {
        android.app.Activity activity;
        if (this.I_renamed.j_renamed() || list == null || list.isEmpty() || (activity = this.i_renamed) == null) {
            return;
        }
        activity.runOnUiThread(new java.lang.Runnable() { // from class: com.oplus.camera.ui.d_renamed.28
            @Override // java.lang.Runnable
            public void run() {
                com.oplus.camera.ui.d_renamed.this.cR_renamed();
                com.oplus.camera.ui.d_renamed.this.ac_renamed.a_renamed(list, j_renamed);
            }
        });
    }

    @Override // com.oplus.camera.ui.CameraUIInterface
    public void n_renamed() {
        this.ac_renamed.a_renamed();
    }

    @Override // com.oplus.camera.ui.CameraUIInterface
    public void a_renamed(int... iArr) {
        this.ac_renamed.a_renamed(iArr);
    }

    public void cR_renamed() {
        if (this.Z_renamed == null || this.aH_renamed == null) {
            return;
        }
        if (dH_renamed() && !dO_renamed()) {
            aK_renamed(true);
        }
        this.ac_renamed.c_renamed(eX_renamed());
    }

    private int eW_renamed() {
        if (this.i_renamed == null || !dY_renamed()) {
            return 0;
        }
        return this.i_renamed.getApplication().getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.movie_time_view_horizontal_margin) + (((int) ((1.0f - ea_renamed() > 0.0f ? 1.0f - ea_renamed() : 0.0f) * com.oplus.camera.util.Util.getScreenWidth())) / 2);
    }

    private int eX_renamed() {
        com.oplus.camera.screen.b_renamed.a_renamed aVar;
        if (this.i_renamed == null) {
            return 0;
        }
        int i_renamed = this.L_renamed;
        com.oplus.camera.ui.MicroscopeHintView microscopeHintView = this.an_renamed;
        boolean z_renamed = microscopeHintView != null && microscopeHintView.b_renamed();
        boolean z2 = dY_renamed() || dX_renamed();
        boolean z3 = dY_renamed() && (aVar = this.bx_renamed) != null && aVar.r_renamed();
        if (z_renamed || z3) {
            return 0;
        }
        if (z2) {
            return 270;
        }
        return i_renamed;
    }

    private void eY_renamed() {
        if (this.Z_renamed == null) {
            return;
        }
        com.oplus.camera.ui.a_renamed.a_renamed aVar = this.ac_renamed;
        if (aVar != null) {
            aVar.f_renamed();
        }
        com.oplus.camera.ui.camerascreenhint.CameraScreenHintView cameraScreenHintView = this.am_renamed;
        if (cameraScreenHintView != null) {
            this.Z_renamed.removeView(cameraScreenHintView);
            this.am_renamed = null;
        }
    }

    @Override // com.oplus.camera.ui.CameraUIInterface
    public void k_renamed(int i_renamed) {
        eZ_renamed();
        this.bg_renamed.a_renamed(this.i_renamed, i_renamed);
    }

    @Override // com.oplus.camera.ui.CameraUIInterface
    public void e_renamed(int i_renamed, boolean z_renamed) {
        com.oplus.camera.j_renamed.a_renamed aVar = this.bg_renamed;
        if (aVar != null) {
            aVar.a_renamed(i_renamed, z_renamed);
        }
    }

    @Override // com.oplus.camera.ui.CameraUIInterface
    public void D_renamed() {
        com.oplus.camera.j_renamed.a_renamed aVar = this.bg_renamed;
        if (aVar != null) {
            aVar.a_renamed();
        }
    }

    @Override // com.oplus.camera.ui.CameraUIInterface
    public void at_renamed() {
        eZ_renamed();
        this.bg_renamed.a_renamed(this.i_renamed);
    }

    @Override // com.oplus.camera.ui.CameraUIInterface
    public void au_renamed() {
        eZ_renamed();
        this.bg_renamed.b_renamed(this.i_renamed);
    }

    private void eZ_renamed() {
        if (this.bg_renamed == null) {
            this.bg_renamed = new com.oplus.camera.j_renamed.a_renamed(this.B_renamed, new com.coui.appcompat.widget.popupwindow.b_renamed.a_renamed() { // from class: com.oplus.camera.ui.d_renamed.29
                @Override // com.coui.appcompat.widget.popupwindow.b_renamed.a_renamed
                public void a_renamed() throws android.content.res.Resources.NotFoundException {
                    if (com.oplus.camera.ui.d_renamed.this.A_renamed == null || com.oplus.camera.ui.d_renamed.this.B_renamed.getBoolean(com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_HYPER_LAPSE_FOCUS_FIRST_HINTS, false) || !com.oplus.camera.ui.d_renamed.this.J_renamed.cg_renamed()) {
                        return;
                    }
                    com.oplus.camera.ui.d_renamed.this.A_renamed.b_renamed(true, false);
                }
            }, this.J_renamed);
        }
    }

    @Override // com.oplus.camera.ui.CameraUIInterface
    public void a_renamed(android.view.View view, int i_renamed, int i2, int i3) {
        float f_renamed;
        android.graphics.Rect rect;
        int i4;
        int iA;
        java.lang.String str;
        android.app.Activity activity;
        com.oplus.camera.e_renamed.a_renamed("CameraUIManager", "showBubble type: " + i_renamed + " offsetX: " + i2 + " offsetY: " + i3);
        if (this.Z_renamed == null) {
            com.oplus.camera.e_renamed.f_renamed("CameraUIManager", "showBubble, mCameraRootView: " + this.Z_renamed + ", type: " + i_renamed);
        }
        switch (i_renamed) {
            case 4:
                if (this.as_renamed == null) {
                    this.as_renamed = new com.oplus.camera.ui.widget.c_renamed(this.i_renamed);
                    this.as_renamed.a_renamed(true);
                    this.as_renamed.a_renamed(this.i_renamed.getString(com.oplus.camera.R_renamed.string.camera_bubble_short_video));
                    this.as_renamed.setFocusable(true);
                    this.as_renamed.setBackgroundDrawable(new android.graphics.drawable.BitmapDrawable());
                    this.as_renamed.setTouchInterceptor(new android.view.View.OnTouchListener() { // from class: com.oplus.camera.ui.d_renamed.30
                        @Override // android.view.View.OnTouchListener
                        public boolean onTouch(android.view.View view2, android.view.MotionEvent motionEvent) {
                            com.oplus.camera.ui.d_renamed.this.f_renamed(4, true);
                            return false;
                        }
                    });
                    this.as_renamed.setOnDismissListener(new android.widget.PopupWindow.OnDismissListener() { // from class: com.oplus.camera.ui.d_renamed.31
                        @Override // android.widget.PopupWindow.OnDismissListener
                        public void onDismiss() {
                            com.oplus.camera.ui.d_renamed.this.f_renamed(4, true);
                        }
                    });
                }
                com.oplus.camera.ui.control.MainShutterButton mainShutterButtonR = this.z_renamed.r_renamed();
                this.as_renamed.b_renamed(mainShutterButtonR.getShutterPadding());
                try {
                    this.as_renamed.a_renamed(mainShutterButtonR);
                    break;
                } catch (android.view.WindowManager.BadTokenException e_renamed) {
                    if (this.as_renamed.isShowing()) {
                        this.as_renamed.dismiss();
                        this.as_renamed = null;
                    }
                    com.oplus.camera.e_renamed.e_renamed("CameraUIManager", "showBubble, type: " + i_renamed + ", exception: " + e_renamed.getMessage());
                    return;
                }
            case 5:
                if (this.av_renamed == null) {
                    this.av_renamed = o_renamed(com.oplus.camera.R_renamed.drawable.bubble_down_right, com.oplus.camera.R_renamed.string.beauty3d_customize_success);
                    this.av_renamed.setTouchInterceptor(new android.view.View.OnTouchListener() { // from class: com.oplus.camera.ui.d_renamed.33
                        @Override // android.view.View.OnTouchListener
                        public boolean onTouch(android.view.View view2, android.view.MotionEvent motionEvent) {
                            com.oplus.camera.ui.d_renamed.this.f_renamed(5, true);
                            return false;
                        }
                    });
                }
                if (!this.av_renamed.isShowing()) {
                    try {
                        this.av_renamed.showAtLocation(this.Z_renamed, 85, i2, i3);
                        break;
                    } catch (android.view.WindowManager.BadTokenException e2) {
                        if (this.av_renamed.isShowing()) {
                            this.av_renamed.dismiss();
                        }
                        com.oplus.camera.e_renamed.e_renamed("CameraUIManager", "showBubble, type: " + i_renamed + ", exception: " + e2.getMessage());
                        return;
                    }
                }
                break;
            case 6:
                if (this.at_renamed == null) {
                    this.at_renamed = o_renamed(com.oplus.camera.R_renamed.drawable.bubble_down_left, com.oplus.camera.R_renamed.string.beauty3d_add_hint);
                    this.at_renamed.setTouchInterceptor(new android.view.View.OnTouchListener() { // from class: com.oplus.camera.ui.d_renamed.34
                        @Override // android.view.View.OnTouchListener
                        public boolean onTouch(android.view.View view2, android.view.MotionEvent motionEvent) {
                            com.oplus.camera.ui.d_renamed.this.f_renamed(6, true);
                            return false;
                        }
                    });
                }
                if (!this.at_renamed.isShowing()) {
                    try {
                        this.at_renamed.showAtLocation(this.Z_renamed, 83, i2, i3);
                        break;
                    } catch (android.view.WindowManager.BadTokenException e3) {
                        if (this.at_renamed.isShowing()) {
                            this.at_renamed.dismiss();
                        }
                        com.oplus.camera.e_renamed.e_renamed("CameraUIManager", "showBubble, type: " + i_renamed + ", exception: " + e3.getMessage());
                        return;
                    }
                }
                break;
            case 7:
                com.oplus.camera.ComboPreferences comboPreferences = this.B_renamed;
                if (comboPreferences == null || !"on_renamed".equals(comboPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_SUB_SETTING, "off"))) {
                    a_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_AI_ENHANCEMENT_VIDEO, com.oplus.camera.ui.CameraUIInterface.KEY_BUBBLE_TYPE_AI_ENHANCEMENT_VIDEO, this.i_renamed.getString(com.oplus.camera.R_renamed.string.camera_ai_enhancement_video_hint), i2, i3, fa_renamed());
                    break;
                }
                break;
            case 8:
                if (this.au_renamed == null) {
                    this.au_renamed = new com.coui.appcompat.widget.s_renamed(this.i_renamed);
                    this.au_renamed.a_renamed(true);
                    this.au_renamed.setFocusable(false);
                    this.au_renamed.a_renamed(this.i_renamed.getString(com.oplus.camera.R_renamed.string.camera_custom_face_beauty_close_hint));
                    this.au_renamed.setTouchInterceptor(new android.view.View.OnTouchListener() { // from class: com.oplus.camera.ui.-$$Lambda$d_renamed$iZJUc3rWrIm7t8JrAfxHY7X2DIQ
                        @Override // android.view.View.OnTouchListener
                        public final boolean onTouch(android.view.View view2, android.view.MotionEvent motionEvent) {
                            return this.f_renamed$0.b_renamed(view2, motionEvent);
                        }
                    });
                }
                if (!this.au_renamed.isShowing() && view != null) {
                    try {
                        this.au_renamed.a_renamed(view, fa_renamed(), this.aT_renamed.l_renamed());
                        break;
                    } catch (android.view.WindowManager.BadTokenException e4) {
                        if (this.au_renamed.isShowing()) {
                            this.au_renamed.dismiss();
                        }
                        com.oplus.camera.e_renamed.e_renamed("CameraUIManager", "showBubble, type: " + i_renamed + ", exception: " + e4.getMessage());
                        return;
                    }
                }
                break;
            case 9:
                if (!j_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_BUBBLE_TYPE_ZOOM_ULTRA_WIDE)) {
                    com.oplus.camera.e_renamed.e_renamed("CameraUIManager", "showBubble, BUBBLE_TYPE_ZOOM_ULTRA_WIDE not support, so return");
                    break;
                } else {
                    if (this.aw_renamed == null) {
                        this.aw_renamed = new com.oplus.camera.ui.widget.c_renamed(com.oplus.camera.util.Util.l_renamed());
                        this.aw_renamed.a_renamed(true);
                        this.aw_renamed.setFocusable(false);
                        this.aw_renamed.a_renamed(this.i_renamed.getString(com.oplus.camera.R_renamed.string.zoom_ultra_wide_switch_guide));
                        this.aw_renamed.setTouchInterceptor(new android.view.View.OnTouchListener() { // from class: com.oplus.camera.ui.-$$Lambda$d_renamed$08FuFsaCe5Iqv_wCefB91ztpURw
                            @Override // android.view.View.OnTouchListener
                            public final boolean onTouch(android.view.View view2, android.view.MotionEvent motionEvent) {
                                return this.f_renamed$0.a_renamed(view2, motionEvent);
                            }
                        });
                        this.aw_renamed.setOnDismissListener(new android.widget.PopupWindow.OnDismissListener() { // from class: com.oplus.camera.ui.-$$Lambda$d_renamed$I9t7PzZTh7SQ8A13YFLOJm1E6EY
                            @Override // android.widget.PopupWindow.OnDismissListener
                            public final void onDismiss() {
                                this.f_renamed$0.gG_renamed();
                            }
                        });
                    }
                    if (view != null && 8 != view.getVisibility() && !this.aw_renamed.isShowing()) {
                        try {
                            this.aw_renamed.a_renamed(view, fa_renamed());
                        } catch (android.view.WindowManager.BadTokenException e5) {
                            if (this.aw_renamed.isShowing()) {
                                this.aw_renamed.dismiss();
                            }
                            com.oplus.camera.e_renamed.e_renamed("CameraUIManager", "showBubble, type: " + i_renamed + ", exception: " + e5.getMessage());
                        }
                    }
                    if (this.J_renamed.ah_renamed() && this.aw_renamed.isShowing()) {
                        this.J_renamed.an_renamed();
                        break;
                    }
                }
                break;
            default:
                switch (i_renamed) {
                    case 15:
                        a_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_SUPER_RAW_CONTROL, com.oplus.camera.ui.CameraUIInterface.KEY_SUPER_RAW_CONTROL, "super_raw", this.i_renamed.getString(com.oplus.camera.R_renamed.string.camera_raw_control_super_bubble_hint), i2, i3);
                        break;
                    case 16:
                        if (this.az_renamed == null) {
                            this.az_renamed = z_renamed(this.i_renamed.getString(com.oplus.camera.R_renamed.string.camera_double_exposure_gallery_hint));
                            this.az_renamed.setTouchInterceptor(new android.view.View.OnTouchListener() { // from class: com.oplus.camera.ui.d_renamed.35
                                @Override // android.view.View.OnTouchListener
                                public boolean onTouch(android.view.View view2, android.view.MotionEvent motionEvent) {
                                    com.oplus.camera.ui.d_renamed.this.f_renamed(16, true);
                                    return false;
                                }
                            });
                            if (view != null && !dH_renamed()) {
                                try {
                                    this.az_renamed.a_renamed(view);
                                    break;
                                } catch (android.view.WindowManager.BadTokenException e6) {
                                    if (this.az_renamed.isShowing()) {
                                        this.az_renamed.dismiss();
                                        this.az_renamed = null;
                                    }
                                    com.oplus.camera.e_renamed.e_renamed("CameraUIManager", "showBubble, type: " + i_renamed + ", exception: " + e6.getMessage());
                                    return;
                                }
                            }
                        }
                        break;
                    case 17:
                        if (this.ax_renamed == null) {
                            this.ax_renamed = new com.oplus.camera.ui.widget.c_renamed(com.oplus.camera.util.Util.l_renamed());
                            this.ax_renamed.a_renamed(this.i_renamed.getString(com.oplus.camera.R_renamed.string.camera_click_show_beauty_tip));
                            this.ax_renamed.a_renamed(false);
                            this.ax_renamed.setOnDismissListener(new android.widget.PopupWindow.OnDismissListener() { // from class: com.oplus.camera.ui.-$$Lambda$d_renamed$HJbudVZobRsGYX-gNdHcpafpsIo
                                @Override // android.widget.PopupWindow.OnDismissListener
                                public final void onDismiss() {
                                    this.f_renamed$0.gF_renamed();
                                }
                            });
                        }
                        android.view.View viewFindViewById = this.i_renamed.findViewById(com.oplus.camera.R_renamed.id_renamed.face_beauty_enter_button);
                        if (viewFindViewById != null && 8 != viewFindViewById.getVisibility()) {
                            try {
                                this.ax_renamed.a_renamed(viewFindViewById);
                                break;
                            } catch (android.view.WindowManager.BadTokenException e7) {
                                if (this.ax_renamed.isShowing()) {
                                    this.ax_renamed.dismiss();
                                }
                                com.oplus.camera.e_renamed.e_renamed("CameraUIManager", "showBubble, type: " + i_renamed + ", exception: " + e7.getMessage());
                                return;
                            }
                        }
                        break;
                    case 18:
                        if (this.i_renamed == null) {
                            com.oplus.camera.e_renamed.c_renamed("CameraUIManager", "showBubble, type: " + i_renamed + ", activity is_renamed null.");
                            break;
                        } else if (this.J_renamed.R_renamed()) {
                            if (!j_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_SUPPORT_EXPOSURE_FOCUS_SEPARATE)) {
                                com.oplus.camera.e_renamed.c_renamed("CameraUIManager", "showBubble, type: " + i_renamed + ", function unsupported.");
                                break;
                            } else if (aw_renamed()) {
                                com.oplus.camera.e_renamed.c_renamed("CameraUIManager", "showBubble, zoom adjusting, not show separate guide.");
                                break;
                            } else {
                                android.graphics.Rect rectBJ = bJ_renamed();
                                float fN_renamed = n_renamed(i2, i3);
                                float dimension = this.i_renamed.getApplication().getResources().getDimension(com.oplus.camera.R_renamed.dimen.exposure_indicator_min_margin);
                                float dimension2 = this.i_renamed.getApplication().getResources().getDimension(com.oplus.camera.R_renamed.dimen.exposure_indicator_width);
                                float dimension3 = this.i_renamed.getApplication().getResources().getDimension(com.oplus.camera.R_renamed.dimen.exposure_indicator_height);
                                if (rectBJ != null) {
                                    int iA2 = (int) a_renamed(i2, rectBJ.width(), dimension, dimension2);
                                    rect = rectBJ;
                                    iA = (int) a_renamed(i3, rectBJ.top, rectBJ.height(), dimension, dimension3);
                                    f_renamed = fN_renamed;
                                    i4 = iA2;
                                } else {
                                    f_renamed = fN_renamed;
                                    rect = rectBJ;
                                    i4 = i2;
                                    iA = i3;
                                }
                                int dimensionPixelSize = this.i_renamed.getApplication().getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.exposure_focus_separate_anim_width);
                                int dimensionPixelSize2 = this.i_renamed.getApplication().getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.exposure_focus_separate_anim_height);
                                if (this.ap_renamed == null && this.Z_renamed != null) {
                                    this.ap_renamed = new com.airbnb.lottie.LottieAnimationView(this.i_renamed);
                                    this.ap_renamed.setAnimation(com.oplus.camera.R_renamed.raw.exposure_focus_separate_guide_anim);
                                    android.widget.RelativeLayout.LayoutParams layoutParams = new android.widget.RelativeLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize2);
                                    boolean z_renamed = this.Z_renamed.getLayoutDirection() == 1;
                                    int iWidth = rect != null ? rect.width() : 0;
                                    if (z_renamed) {
                                        layoutParams.rightMargin = iWidth - ((dimensionPixelSize / 2) + i4);
                                    } else {
                                        layoutParams.leftMargin = i4 - (dimensionPixelSize / 2);
                                    }
                                    layoutParams.topMargin = iA;
                                    this.Z_renamed.addView(this.ap_renamed, layoutParams);
                                    this.ap_renamed.setPivotX(dimensionPixelSize / 2.0f);
                                    this.ap_renamed.setPivotY(0.0f);
                                    this.ap_renamed.setRotation(f_renamed);
                                    this.ap_renamed.a_renamed(new android.animation.AnimatorListenerAdapter() { // from class: com.oplus.camera.ui.d_renamed.36
                                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                                        public void onAnimationEnd(android.animation.Animator animator) {
                                            com.oplus.camera.ui.d_renamed.this.f_renamed(18, true);
                                        }
                                    });
                                    this.cm_renamed.post(new java.lang.Runnable() { // from class: com.oplus.camera.ui.-$$Lambda$d_renamed$AYeUrfLDOB2YtiXUx-4ES6wBabQ
                                        @Override // java.lang.Runnable
                                        public final void run() {
                                            this.f_renamed$0.gE_renamed();
                                        }
                                    });
                                }
                                android.os.Handler handler = this.cm_renamed;
                                if (handler != null) {
                                    str = ", exception: ";
                                    handler.sendMessageDelayed(handler.obtainMessage(14), 1000L);
                                } else {
                                    str = ", exception: ";
                                }
                                if (this.aC_renamed == null && (activity = this.i_renamed) != null) {
                                    int dimensionPixelOffset = activity.getApplication().getResources().getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.exposure_focus_separate_tips_margin);
                                    this.aC_renamed = new com.oplus.camera.ui.widget.c_renamed(this.i_renamed);
                                    this.aC_renamed.a_renamed(this.i_renamed.getString(com.oplus.camera.R_renamed.string.camera_focus_exposure_separate_hint));
                                    this.aC_renamed.a_renamed(true);
                                    this.aC_renamed.setFocusable(false);
                                    this.aC_renamed.a_renamed();
                                    int[] iArrA = a_renamed(f_renamed, dimensionPixelSize, dimensionPixelSize2, i4, iA, dimensionPixelOffset);
                                    this.aC_renamed.a_renamed(iArrA[0], iArrA[1], rect != null ? rect.top : 0);
                                    this.aC_renamed.setTouchInterceptor(new android.view.View.OnTouchListener() { // from class: com.oplus.camera.ui.d_renamed.37
                                        @Override // android.view.View.OnTouchListener
                                        public boolean onTouch(android.view.View view2, android.view.MotionEvent motionEvent) {
                                            com.oplus.camera.ui.d_renamed.this.f_renamed(18, true);
                                            return false;
                                        }
                                    });
                                    this.aC_renamed.setOnDismissListener(new android.widget.PopupWindow.OnDismissListener() { // from class: com.oplus.camera.ui.d_renamed.38
                                        @Override // android.widget.PopupWindow.OnDismissListener
                                        public void onDismiss() {
                                            com.oplus.camera.ui.d_renamed.this.dh_renamed();
                                            com.oplus.camera.ui.d_renamed.this.f_renamed(18, true);
                                        }
                                    });
                                }
                                if (view != null) {
                                    try {
                                        if (this.aC_renamed != null) {
                                            this.aC_renamed.a_renamed(view, false);
                                            break;
                                        }
                                    } catch (android.view.WindowManager.BadTokenException e8) {
                                        com.oplus.camera.ui.widget.c_renamed cVar = this.aC_renamed;
                                        if (cVar != null && cVar.isShowing()) {
                                            this.aC_renamed.dismiss();
                                            this.aC_renamed = null;
                                            dh_renamed();
                                        }
                                        com.oplus.camera.e_renamed.e_renamed("CameraUIManager", "showBubble, type: " + i_renamed + str + e8.getMessage());
                                        return;
                                    }
                                }
                            }
                        }
                        break;
                    case 19:
                        if (this.ay_renamed == null) {
                            this.ay_renamed = new com.oplus.camera.ui.widget.c_renamed(com.oplus.camera.util.Util.l_renamed());
                            this.ay_renamed.a_renamed(this.i_renamed.getString(com.oplus.camera.R_renamed.string.camera_super_eis_tip));
                            this.ay_renamed.a_renamed(false);
                            this.ay_renamed.setOnDismissListener(new android.widget.PopupWindow.OnDismissListener() { // from class: com.oplus.camera.ui.-$$Lambda$d_renamed$vAqX1fLdnVruPjaI2LeM_tPhZWU
                                @Override // android.widget.PopupWindow.OnDismissListener
                                public final void onDismiss() {
                                    this.f_renamed$0.gD_renamed();
                                }
                            });
                        }
                        if (view != null && 8 != view.getVisibility() && !this.ay_renamed.isShowing()) {
                            try {
                                this.ay_renamed.a_renamed(i2, i3);
                                this.ay_renamed.a_renamed(view, fa_renamed());
                                d_renamed(false, false);
                                v_renamed(false, false);
                                break;
                            } catch (android.view.WindowManager.BadTokenException e9) {
                                if (this.ay_renamed.isShowing()) {
                                    this.ay_renamed.dismiss();
                                }
                                com.oplus.camera.e_renamed.e_renamed("CameraUIManager", "showBubble, type: " + i_renamed + ", exception: " + e9.getMessage());
                                return;
                            }
                        }
                        break;
                    case 20:
                        if (this.aD_renamed == null) {
                            this.aD_renamed = new com.oplus.camera.ui.widget.c_renamed(com.oplus.camera.util.Util.l_renamed());
                            this.aD_renamed.a_renamed(this.i_renamed.getString(com.oplus.camera.R_renamed.string.camera_long_press_trigger_rocker_shutter_tip));
                            this.aD_renamed.a_renamed(false);
                            this.aD_renamed.setOnDismissListener(new android.widget.PopupWindow.OnDismissListener() { // from class: com.oplus.camera.ui.-$$Lambda$d_renamed$WnWFNhT0Yubk8ZUFjWdW0SvU8x4
                                @Override // android.widget.PopupWindow.OnDismissListener
                                public final void onDismiss() {
                                    this.f_renamed$0.gC_renamed();
                                }
                            });
                        }
                        com.oplus.camera.ui.control.MainShutterButton mainShutterButtonR2 = this.z_renamed.r_renamed();
                        if (mainShutterButtonR2 != null) {
                            this.aD_renamed.b_renamed(mainShutterButtonR2.getShutterPadding());
                            try {
                                this.aD_renamed.a_renamed(mainShutterButtonR2);
                                break;
                            } catch (android.view.WindowManager.BadTokenException e10) {
                                if (this.aD_renamed.isShowing()) {
                                    this.aD_renamed.dismiss();
                                    this.aD_renamed = null;
                                }
                                com.oplus.camera.e_renamed.e_renamed("CameraUIManager", "showBubble, type: " + i_renamed + ", exception: " + e10.getMessage());
                                return;
                            }
                        }
                        break;
                }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean b_renamed(android.view.View view, android.view.MotionEvent motionEvent) {
        f_renamed(8, true);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean a_renamed(android.view.View view, android.view.MotionEvent motionEvent) {
        f_renamed(9, true);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void gG_renamed() {
        f_renamed(9, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void gF_renamed() {
        f_renamed(17, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void gE_renamed() {
        com.oplus.camera.ui.preview.n_renamed nVar = (com.oplus.camera.ui.preview.n_renamed) this.i_renamed.findViewById(com.oplus.camera.R_renamed.id_renamed.focus_exposure_indicator_container);
        if (nVar != null) {
            nVar.setOnVisibilityChangedListener(new com.oplus.camera.ui.preview.n_renamed.c_renamed() { // from class: com.oplus.camera.ui.-$$Lambda$d_renamed$JumLXN3Bb0MbPm1Hd-zUqFiFXlc
                @Override // com.oplus.camera.ui.preview.n_renamed.c_renamed
                public final void onVisibilityChanged(android.view.View view, int i_renamed) {
                    this.f_renamed$0.a_renamed(view, i_renamed);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a_renamed(android.view.View view, int i_renamed) {
        if (i_renamed != 0) {
            f_renamed(18, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void gD_renamed() {
        f_renamed(19, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void gC_renamed() {
        f_renamed(20, true);
    }

    private float a_renamed(float f_renamed, float f2, float f3, float f4) {
        float f5 = f4 / 2.0f;
        return com.oplus.camera.util.Util.a_renamed(f_renamed, f5 + f3, (f2 - f5) - f3);
    }

    private float a_renamed(float f_renamed, float f2, float f3, float f4, float f5) {
        float f6 = f5 / 2.0f;
        return com.oplus.camera.util.Util.a_renamed(f_renamed, f2 + f6 + f4, ((f2 + f3) - f6) - f4);
    }

    private int[] a_renamed(float f_renamed, int i_renamed, int i2, int i3, int i4, int i5) {
        int i6;
        int i7;
        int iSqrt;
        double d_renamed;
        double d2;
        double dSqrt;
        int[] iArr = {-1, -1};
        android.graphics.Rect rectBJ = bJ_renamed();
        if (rectBJ != null) {
            i7 = rectBJ.top;
            i6 = rectBJ.bottom;
        } else {
            i6 = 0;
            i7 = 0;
        }
        if (90.0f < f_renamed && f_renamed < 270.0f) {
            iSqrt = ((int) (i_renamed / java.lang.Math.sqrt(2.0d))) + i4;
            d_renamed = i4;
            d2 = i2;
            dSqrt = java.lang.Math.sqrt(2.0d);
        } else {
            iSqrt = ((int) (i2 / java.lang.Math.sqrt(2.0d))) + i4;
            d_renamed = i4;
            d2 = i_renamed;
            dSqrt = java.lang.Math.sqrt(2.0d);
        }
        int i8 = (int) (d_renamed - (d2 / dSqrt));
        int i9 = i8 - i5;
        if (i9 > i7) {
            iArr[0] = i9;
        }
        int i10 = iSqrt + i5;
        if (i10 < i6) {
            iArr[1] = i10;
        }
        com.oplus.camera.e_renamed.b_renamed("CameraUIManager", "getTipsMarginTop, animationAngle: " + f_renamed + ", animWidth: " + i_renamed + ", animHeight: " + i2 + ", touchX: " + i3 + ", touchY: " + i4 + ", topX: " + i3 + ", topY: " + i8 + ", previewTop: " + i7 + ", result: " + java.util.Arrays.toString(iArr));
        return iArr;
    }

    private int fa_renamed() {
        return 1 == this.J_renamed.ca_renamed() ? 8 : 4;
    }

    @Override // com.oplus.camera.ui.CameraUIInterface
    public void aE_renamed() {
        com.oplus.camera.ui.CameraUIListener cameraUIListener = this.J_renamed;
        if (cameraUIListener != null) {
            cameraUIListener.aC_renamed();
        }
    }

    @Override // com.oplus.camera.ui.CameraUIInterface
    public void aD_renamed() {
        com.oplus.camera.ui.menu.setting.f_renamed fVar = this.I_renamed;
        if (fVar != null) {
            fVar.x_renamed();
        }
    }

    private boolean fb_renamed() {
        com.oplus.camera.ui.CameraUIListener cameraUIListener;
        return g_renamed && !this.p_renamed && (cameraUIListener = this.J_renamed) != null && this.B_renamed != null && this.I_renamed != null && cameraUIListener.X_renamed() && !this.J_renamed.c_renamed() && this.I_renamed.s_renamed() && this.B_renamed.getBoolean(com.oplus.camera.ui.CameraUIInterface.KEY_DRAWER_SHOW_GUIDE_ANIMATION, true) && j_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_SHOW_PULL_DOWN_TIP);
    }

    @Override // com.oplus.camera.ui.CameraUIInterface
    public void f_renamed(int i_renamed, boolean z_renamed) {
        java.lang.String str;
        android.widget.PopupWindow popupWindow = null;
        switch (i_renamed) {
            case 4:
                popupWindow = this.as_renamed;
                str = com.oplus.camera.ui.CameraUIInterface.KEY_BUBBLE_SHORT_VIDEO;
                break;
            case 5:
                popupWindow = this.av_renamed;
                str = com.oplus.camera.ui.CameraUIInterface.KEY_BUBBLE_TYPE_CUSTOM_BEUTY3D;
                break;
            case 6:
                popupWindow = this.at_renamed;
                str = com.oplus.camera.ui.CameraUIInterface.KEY_BUBBLE_TYPE_ADD_BEUTY3D;
                break;
            case 7:
                if (z_renamed && v_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_AI_ENHANCEMENT_VIDEO)) {
                    i_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_BUBBLE_TYPE_AI_ENHANCEMENT_VIDEO, false);
                }
                u_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_AI_ENHANCEMENT_VIDEO);
                str = null;
                break;
            case 8:
                popupWindow = this.au_renamed;
                str = com.oplus.camera.ui.CameraUIInterface.KEY_BUBBLE_TYPE_CUSTOM_FACE_BEAUTY_CLOSE;
                break;
            case 9:
                com.oplus.camera.ui.widget.c_renamed cVar = this.aw_renamed;
                if (cVar != null) {
                    if (cVar.isShowing()) {
                        this.aw_renamed.dismiss();
                        com.oplus.camera.j_renamed.a_renamed().c_renamed();
                    }
                    if (z_renamed) {
                        i_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_BUBBLE_TYPE_ZOOM_ULTRA_WIDE, false);
                        this.aw_renamed = null;
                    }
                }
                str = null;
                break;
            default:
                switch (i_renamed) {
                    case 16:
                        com.coui.appcompat.widget.s_renamed sVar = this.az_renamed;
                        if (sVar != null) {
                            if (sVar.isShowing()) {
                                this.az_renamed.dismiss();
                            }
                            if (z_renamed) {
                                i_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_DOUBLE_EXPOSURE_TIPS, false);
                                this.az_renamed = null;
                                break;
                            }
                        }
                        break;
                    case 17:
                        com.oplus.camera.ui.widget.c_renamed cVar2 = this.ax_renamed;
                        if (cVar2 != null) {
                            if (cVar2.isShowing()) {
                                this.ax_renamed.dismiss();
                                this.ax_renamed = null;
                            }
                            if (z_renamed) {
                                i_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_FIRST_BEAUTY_TIPS, false);
                                break;
                            }
                        }
                        break;
                    case 18:
                        android.os.Handler handler = this.cm_renamed;
                        if (handler != null) {
                            handler.obtainMessage(15).sendToTarget();
                        }
                        com.oplus.camera.ui.widget.c_renamed cVar3 = this.aC_renamed;
                        if (cVar3 != null) {
                            if (cVar3.isShowing()) {
                                this.aC_renamed.dismiss();
                            }
                            if (z_renamed) {
                                i_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_EXPOSURE_FOCUS_SEPARATE_TIPS, false);
                                this.aC_renamed = null;
                                break;
                            }
                        }
                        break;
                    case 19:
                        com.oplus.camera.ui.widget.c_renamed cVar4 = this.ay_renamed;
                        if (cVar4 != null) {
                            if (cVar4.isShowing()) {
                                this.ay_renamed.dismiss();
                                this.ay_renamed = null;
                            }
                            if (z_renamed) {
                                i_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_SUPER_EIS_WIDE_TIPS, false);
                                d_renamed(true, false);
                                v_renamed(true, false);
                                break;
                            }
                        }
                        break;
                    case 20:
                        com.oplus.camera.ui.widget.c_renamed cVar5 = this.aD_renamed;
                        if (cVar5 != null) {
                            if (cVar5.isShowing()) {
                                this.aD_renamed.dismiss();
                                this.aD_renamed = null;
                            }
                            if (z_renamed) {
                                i_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_BUBBLE_STREET_ROCKER_SHUTTER, false);
                                break;
                            }
                        }
                        break;
                }
                str = null;
                break;
        }
        if (popupWindow != null) {
            if (popupWindow.isShowing()) {
                popupWindow.dismiss();
            }
            if (z_renamed) {
                i_renamed(str, false);
            }
        }
    }

    private float n_renamed(int i_renamed, int i2) {
        android.graphics.Rect rectBJ = bJ_renamed();
        if (rectBJ == null) {
            return 315.0f;
        }
        int i3 = (rectBJ.left + rectBJ.right) / 2;
        int i4 = (rectBJ.top + rectBJ.bottom) / 2;
        return i_renamed <= i3 ? i2 <= i4 ? 315.0f : 225.0f : i2 <= i4 ? 45.0f : 135.0f;
    }

    private void fc_renamed() {
        f_renamed(9, true);
        f_renamed(4, true);
    }

    private void fd_renamed() {
        f_renamed(9, false);
        f_renamed(17, false);
        f_renamed(20, false);
        if (com.oplus.camera.aps.constant.ApsConstant.REC_MODE_COMMON.equals(aV_renamed())) {
            f_renamed(7, true);
        } else {
            f_renamed(7, false);
        }
    }

    private void fe_renamed() {
        if (this.Z_renamed != null && this.aj_renamed == null) {
            this.aj_renamed = (com.oplus.camera.ui.camerascreenhint.CameraScreenHintView) this.i_renamed.getLayoutInflater().inflate(com.oplus.camera.R_renamed.layout.camera_screen_hint, (android.view.ViewGroup) null);
            android.view.View view = this.al_renamed;
            if (view != null) {
                android.view.ViewGroup viewGroup = this.Z_renamed;
                viewGroup.addView(this.aj_renamed, viewGroup.indexOfChild(view));
            } else {
                this.Z_renamed.addView(this.aj_renamed);
            }
            this.aj_renamed.setOrientation(this.L_renamed);
            this.aj_renamed.setCameraScreenHintInterface(this.ck_renamed);
            if (this.J_renamed.h_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_SUPPORT_ROTATE_HINT_VIEW)) {
                return;
            }
            this.aj_renamed.setSupportRotateScreen(2);
        }
    }

    public void l_renamed(java.lang.String str) {
        if (this.aj_renamed == null) {
            fe_renamed();
            if (this.aj_renamed != null) {
                this.aj_renamed.a_renamed(0, (this.i_renamed.getApplication().getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.sticker_hint_bottom_margin_vertical) + com.oplus.camera.util.Util.O_renamed()) - this.aj_renamed.getViewGap(), this.i_renamed.getApplication().getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.sticker_hint_bottom_margin_horizontal) - this.aj_renamed.getViewGap(), true);
            }
        }
        if (this.aj_renamed != null) {
            this.aj_renamed.a_renamed(new com.oplus.camera.ui.camerascreenhint.a_renamed.CameraScreenHintInfo_2().a_renamed(str).a_renamed(true).b_renamed(false).a_renamed(com.oplus.camera.R_renamed.color.sticker_hint_background_color).b_renamed(com.oplus.camera.R_renamed.color.screen_hint_text_color).a_renamed());
        }
    }

    @Override // com.oplus.camera.ui.CameraUIInterface
    public void E_renamed() {
        com.oplus.camera.ui.camerascreenhint.CameraScreenHintView cameraScreenHintView = this.aj_renamed;
        if (cameraScreenHintView == null || cameraScreenHintView.getHintTextView().getVisibility() != 0) {
            return;
        }
        this.aj_renamed.b_renamed(true);
    }

    private android.widget.PopupWindow o_renamed(int i_renamed, int i2) {
        android.view.View viewInflate = android.view.LayoutInflater.from(this.i_renamed).inflate(com.oplus.camera.R_renamed.layout.camera_bubble, (android.view.ViewGroup) null);
        viewInflate.setBackgroundResource(i_renamed);
        ((com.oplus.camera.ui.menu.OplusTextView) viewInflate.findViewById(com.oplus.camera.R_renamed.id_renamed.camera_bubble_text)).setText(i2);
        android.widget.PopupWindow popupWindow = new android.widget.PopupWindow(this.i_renamed);
        popupWindow.setWidth(-2);
        popupWindow.setHeight(-2);
        popupWindow.setContentView(viewInflate);
        popupWindow.setBackgroundDrawable(new android.graphics.drawable.BitmapDrawable());
        popupWindow.setFocusable(false);
        popupWindow.setOutsideTouchable(true);
        popupWindow.setAnimationStyle(com.oplus.camera.R_renamed.style.PopupWindowStyle);
        return popupWindow;
    }

    private com.coui.appcompat.widget.s_renamed z_renamed(java.lang.String str) {
        com.coui.appcompat.widget.s_renamed sVar = new com.coui.appcompat.widget.s_renamed(this.i_renamed);
        sVar.a_renamed(str);
        sVar.a_renamed(true);
        sVar.setFocusable(false);
        return sVar;
    }

    private void i_renamed(java.lang.String str, boolean z_renamed) {
        com.oplus.camera.ComboPreferences comboPreferences = this.B_renamed;
        if (comboPreferences == null) {
            com.oplus.camera.e_renamed.f_renamed("CameraUIManager", "updateBubbleValue, mPreference null");
            return;
        }
        android.content.SharedPreferences.Editor editorEdit = comboPreferences.edit();
        editorEdit.putBoolean(str, z_renamed);
        editorEdit.apply();
    }

    @Override // com.oplus.camera.ui.CameraUIInterface
    public int s_renamed() {
        com.oplus.camera.ui.control.a_renamed aVar = this.z_renamed;
        if (aVar != null) {
            return aVar.V_renamed();
        }
        return 1;
    }

    public void ai_renamed(boolean z_renamed) {
        com.oplus.camera.ui.control.a_renamed aVar = this.z_renamed;
        if (aVar != null) {
            aVar.i_renamed(z_renamed);
        }
    }

    public void cS_renamed() {
        com.oplus.camera.ComboPreferences comboPreferences;
        com.oplus.camera.e_renamed.b_renamed("CameraUIManager", "startArrowAnimation");
        if (this.I_renamed == null || (comboPreferences = this.B_renamed) == null) {
            return;
        }
        comboPreferences.edit().putBoolean(com.oplus.camera.ui.CameraUIInterface.SHOW_ARROW_ANIMATION, false).apply();
    }

    public void cT_renamed() {
        com.oplus.camera.ui.menu.levelcontrol.g_renamed gVar = this.ah_renamed;
        if (gVar != null) {
            gVar.f_renamed();
        }
    }

    public boolean cU_renamed() {
        com.oplus.camera.ui.menu.levelcontrol.g_renamed gVar = this.ah_renamed;
        if (gVar != null) {
            return gVar.h_renamed();
        }
        return false;
    }

    @Override // com.oplus.camera.ui.CameraUIInterface
    public void s_renamed(boolean z_renamed) {
        com.oplus.camera.ui.menu.setting.q_renamed qVar = this.aK_renamed;
        if (qVar != null) {
            qVar.hideWithoutAnim(z_renamed, true);
        }
    }

    @Override // com.oplus.camera.ui.CameraUIInterface
    public void J_renamed() {
        com.oplus.camera.ui.preview.g_renamed gVar = this.A_renamed;
        if (gVar != null) {
            gVar.z_renamed();
        }
    }

    @Override // com.oplus.camera.ui.CameraUIInterface
    public void q_renamed(boolean z_renamed) {
        com.oplus.camera.ui.menu.levelcontrol.g_renamed gVar = this.ah_renamed;
        if (gVar != null) {
            gVar.a_renamed(4, z_renamed);
        }
    }

    @Override // com.oplus.camera.ui.CameraUIInterface
    public void l_renamed(boolean z_renamed, boolean z2) {
        com.oplus.camera.ui.CameraUIListener cameraUIListener;
        com.oplus.camera.e_renamed.a_renamed("CameraUIManager", "showFaceBeautyMenu, needAnim: " + z_renamed + ", needTranslateAnim: " + z2);
        if ((dS_renamed() && dH_renamed()) || (cameraUIListener = this.J_renamed) == null || !cameraUIListener.f_renamed() || this.J_renamed.c_renamed() || this.J_renamed.L_renamed() || this.J_renamed.ah_renamed() || K_renamed()) {
            return;
        }
        if ((this.J_renamed.aO_renamed() && !this.J_renamed.aP_renamed()) || this.o_renamed || this.aT_renamed == null || this.ah_renamed.isEffectMenuOpen() || O_renamed() || fF_renamed() || this.J_renamed.av_renamed() || ev_renamed() || cX_renamed()) {
            return;
        }
        if (this.J_renamed.bF_renamed() && com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_FACE_BEAUTY_CUSTOM_MENU_SUPPORT)) {
            return;
        }
        z_renamed(z_renamed, z2);
    }

    @Override // com.oplus.camera.ui.CameraUIInterface
    public void i_renamed(boolean z_renamed, boolean z2) {
        float f_renamed;
        int i_renamed;
        com.oplus.camera.e_renamed.a_renamed("CameraUIManager", "showBlurMenuButton, needAnim: " + z_renamed);
        if (dS_renamed() && dH_renamed()) {
            return;
        }
        com.oplus.camera.ui.CameraUIListener cameraUIListener = this.J_renamed;
        if (cameraUIListener == null || cameraUIListener.g_renamed()) {
            ff_renamed();
            android.animation.AnimatorSet animatorSet = this.aX_renamed;
            if (animatorSet != null && animatorSet.isStarted()) {
                this.aX_renamed.cancel();
            } else {
                com.oplus.camera.ui.menu.facebeauty.RotateAnimationView rotateAnimationView = this.aQ_renamed;
                if (rotateAnimationView == null || rotateAnimationView.isShown()) {
                    return;
                }
                android.animation.AnimatorSet animatorSet2 = this.aW_renamed;
                if (animatorSet2 != null && animatorSet2.isStarted()) {
                    return;
                }
            }
            if (z_renamed) {
                this.aQ_renamed.setAlpha(0.0f);
                this.aQ_renamed.setTranslationY(0.0f);
                this.aQ_renamed.setVisibility(0);
                android.animation.ObjectAnimator objectAnimatorOfFloat = android.animation.ObjectAnimator.ofFloat(this.aQ_renamed, "alpha", 0.0f, 1.0f);
                objectAnimatorOfFloat.setInterpolator(this.ba_renamed);
                objectAnimatorOfFloat.setDuration(z2 ? 400L : 250L);
                this.aW_renamed = new android.animation.AnimatorSet();
                android.animation.AnimatorSet.Builder builderPlay = this.aW_renamed.play(objectAnimatorOfFloat);
                if (z2) {
                    java.lang.String str = "translationX";
                    if (1 == aX_renamed()) {
                        i_renamed = 270 == this.bx_renamed.k_renamed() ? -this.bv_renamed : this.bv_renamed;
                    } else if (4 == aX_renamed()) {
                        i_renamed = this.bv_renamed;
                    } else {
                        f_renamed = -this.bv_renamed;
                        str = "translationY";
                        android.animation.ObjectAnimator objectAnimatorOfFloat2 = android.animation.ObjectAnimator.ofFloat(this.aQ_renamed, str, f_renamed, 0.0f);
                        objectAnimatorOfFloat2.setInterpolator(this.bb_renamed);
                        objectAnimatorOfFloat2.setDuration(400L);
                        builderPlay.with(objectAnimatorOfFloat2);
                        this.aW_renamed.setStartDelay(150L);
                    }
                    f_renamed = i_renamed;
                    android.animation.ObjectAnimator objectAnimatorOfFloat22 = android.animation.ObjectAnimator.ofFloat(this.aQ_renamed, str, f_renamed, 0.0f);
                    objectAnimatorOfFloat22.setInterpolator(this.bb_renamed);
                    objectAnimatorOfFloat22.setDuration(400L);
                    builderPlay.with(objectAnimatorOfFloat22);
                    this.aW_renamed.setStartDelay(150L);
                } else {
                    this.aQ_renamed.setTranslationY(0.0f);
                    this.aQ_renamed.setTranslationX(0.0f);
                }
                this.aW_renamed.addListener(new android.animation.AnimatorListenerAdapter() { // from class: com.oplus.camera.ui.d_renamed.39
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationStart(android.animation.Animator animator) {
                        if (com.oplus.camera.ui.d_renamed.this.aQ_renamed != null) {
                            com.oplus.camera.ui.d_renamed.this.aQ_renamed.setVisibility(0);
                        }
                    }
                });
                this.aW_renamed.start();
            } else {
                com.oplus.camera.ui.menu.facebeauty.RotateAnimationView rotateAnimationView2 = this.aQ_renamed;
                if (rotateAnimationView2 != null) {
                    rotateAnimationView2.setVisibility(0);
                    this.aQ_renamed.setAlpha(1.0f);
                    this.aQ_renamed.setTranslationY(0.0f);
                    this.aQ_renamed.setTranslationX(0.0f);
                }
            }
            com.oplus.camera.ui.menu.facebeauty.RotateAnimationView rotateAnimationView3 = this.aQ_renamed;
            if (rotateAnimationView3 != null) {
                rotateAnimationView3.setEnabled(true);
            }
        }
    }

    private void ff_renamed() {
        com.oplus.camera.ui.menu.facebeauty.RotateAnimationView rotateAnimationView = this.aQ_renamed;
        if (rotateAnimationView != null) {
            rotateAnimationView.a_renamed(false, 0, 0);
            com.oplus.camera.ui.CameraUIListener cameraUIListener = this.J_renamed;
            if (cameraUIListener != null && cameraUIListener.h_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_MULTI_CAMERA_TYPE_MENU)) {
                this.aP_renamed = com.oplus.camera.R_renamed.drawable.multi_video_type_menu_normal;
                this.aQ_renamed.setSelected(false);
                this.aQ_renamed.clearColorFilter();
                this.aQ_renamed.setImageResource(this.aP_renamed);
                return;
            }
            com.oplus.camera.ui.CameraUIListener cameraUIListener2 = this.J_renamed;
            if (cameraUIListener2 != null && cameraUIListener2.h_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_STREET_LONG_EXPOSURE_MENU)) {
                this.aP_renamed = com.oplus.camera.R_renamed.drawable.ic_mode_long_exposure;
                this.aQ_renamed.setSelected(false);
                this.aQ_renamed.clearColorFilter();
                this.aQ_renamed.setImageResource(this.aP_renamed);
                this.aQ_renamed.a_renamed(dL_renamed(), 0, 0);
                return;
            }
            if (this.cy_renamed.h_renamed()) {
                S_renamed(true);
            } else {
                S_renamed(this.cy_renamed.b_renamed());
            }
        }
    }

    @Override // com.oplus.camera.ui.CameraUIInterface
    public void h_renamed(boolean z_renamed, boolean z2) {
        float f_renamed;
        int i_renamed;
        com.oplus.camera.e_renamed.a_renamed("CameraUIManager", "hideBlurMenuButton, needAnim: " + z_renamed);
        android.animation.AnimatorSet animatorSet = this.aW_renamed;
        if (animatorSet != null && animatorSet.isStarted()) {
            this.aW_renamed.cancel();
        } else {
            com.oplus.camera.ui.menu.facebeauty.RotateAnimationView rotateAnimationView = this.aQ_renamed;
            if (rotateAnimationView == null || !rotateAnimationView.isShown()) {
                return;
            }
            android.animation.AnimatorSet animatorSet2 = this.aX_renamed;
            if (animatorSet2 != null && animatorSet2.isStarted()) {
                return;
            }
        }
        if (z_renamed) {
            android.animation.ObjectAnimator objectAnimatorOfFloat = android.animation.ObjectAnimator.ofFloat(this.aQ_renamed, "alpha", 1.0f, 0.0f);
            objectAnimatorOfFloat.setInterpolator(this.ba_renamed);
            objectAnimatorOfFloat.setDuration(250L);
            this.aX_renamed = new android.animation.AnimatorSet();
            android.animation.AnimatorSet.Builder builderPlay = this.aX_renamed.play(objectAnimatorOfFloat);
            if (z2) {
                java.lang.String str = "translationX";
                if (1 == aX_renamed()) {
                    i_renamed = 270 == this.bx_renamed.k_renamed() ? -this.bv_renamed : this.bv_renamed;
                } else if (4 == aX_renamed()) {
                    i_renamed = this.bv_renamed;
                } else {
                    f_renamed = -this.bv_renamed;
                    str = "translationY";
                    android.animation.ObjectAnimator objectAnimatorOfFloat2 = android.animation.ObjectAnimator.ofFloat(this.aQ_renamed, str, 0.0f, f_renamed);
                    objectAnimatorOfFloat2.setInterpolator(this.bb_renamed);
                    objectAnimatorOfFloat2.setDuration(400L);
                    builderPlay.with(objectAnimatorOfFloat2);
                }
                f_renamed = i_renamed;
                android.animation.ObjectAnimator objectAnimatorOfFloat22 = android.animation.ObjectAnimator.ofFloat(this.aQ_renamed, str, 0.0f, f_renamed);
                objectAnimatorOfFloat22.setInterpolator(this.bb_renamed);
                objectAnimatorOfFloat22.setDuration(400L);
                builderPlay.with(objectAnimatorOfFloat22);
            } else {
                this.aQ_renamed.setTranslationY(0.0f);
                this.aQ_renamed.setTranslationX(0.0f);
            }
            this.aX_renamed.addListener(new android.animation.AnimatorListenerAdapter() { // from class: com.oplus.camera.ui.d_renamed.40
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(android.animation.Animator animator) {
                    if (com.oplus.camera.ui.d_renamed.this.aQ_renamed != null) {
                        com.oplus.camera.ui.d_renamed.this.aQ_renamed.setEnabled(false);
                        com.oplus.camera.ui.d_renamed.this.aQ_renamed.setTranslationY(0.0f);
                        com.oplus.camera.ui.d_renamed.this.aQ_renamed.setTranslationX(0.0f);
                        com.oplus.camera.ui.d_renamed.this.aQ_renamed.setAlpha(1.0f);
                        com.oplus.camera.ui.d_renamed.this.aQ_renamed.setVisibility(0);
                    }
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(android.animation.Animator animator) {
                    if (com.oplus.camera.ui.d_renamed.this.aQ_renamed != null) {
                        com.oplus.camera.ui.d_renamed.this.aQ_renamed.setEnabled(true);
                        com.oplus.camera.ui.d_renamed.this.aQ_renamed.setVisibility(8);
                        com.oplus.camera.ui.d_renamed.this.aQ_renamed.setTranslationY(0.0f);
                        com.oplus.camera.ui.d_renamed.this.aQ_renamed.setTranslationX(0.0f);
                        com.oplus.camera.ui.d_renamed.this.aQ_renamed.setAlpha(0.0f);
                    }
                }
            });
            this.aX_renamed.start();
            return;
        }
        com.oplus.camera.ui.menu.facebeauty.RotateAnimationView rotateAnimationView2 = this.aQ_renamed;
        if (rotateAnimationView2 != null) {
            rotateAnimationView2.setVisibility(8);
            this.aQ_renamed.setTranslationY(0.0f);
            this.aQ_renamed.setTranslationX(0.0f);
            this.aQ_renamed.setAlpha(0.0f);
        }
    }

    public void cV_renamed() {
        com.oplus.camera.ui.CameraUIListener cameraUIListener = this.J_renamed;
        boolean z_renamed = cameraUIListener != null && cameraUIListener.h_renamed();
        P_renamed(false);
        j_renamed(true, z_renamed);
        h_renamed(true, z_renamed);
        f_renamed(17, true);
        f_renamed(20, true);
        com.oplus.camera.ui.k_renamed kVar = this.bH_renamed;
        if (kVar != null) {
            kVar.b_renamed();
        }
    }

    @Override // com.oplus.camera.ui.CameraUIInterface
    public void L_renamed() {
        com.oplus.camera.ui.k_renamed kVar = this.bH_renamed;
        if (kVar != null) {
            kVar.c_renamed();
        }
        bU_renamed();
    }

    @Override // com.oplus.camera.ui.CameraUIInterface
    public void j_renamed(boolean z_renamed, boolean z2) {
        com.oplus.camera.e_renamed.a_renamed("CameraUIManager", "hideFaceBeautyMenu, needAnim: " + z_renamed);
        if (K_renamed()) {
            a_renamed(z_renamed, false, false, false);
        } else {
            k_renamed(z_renamed, z2);
        }
    }

    @Override // com.oplus.camera.ui.CameraUIInterface
    public void u_renamed(boolean z_renamed) {
        com.oplus.camera.ui.menu.facebeauty.g_renamed gVar;
        com.oplus.camera.e_renamed.a_renamed("CameraUIManager", "openFaceBeautyMenu, needAnim: " + z_renamed);
        if (this.p_renamed || (gVar = this.aT_renamed) == null || gVar.n_renamed()) {
            com.oplus.camera.e_renamed.e_renamed("CameraUIManager", "openFaceBeautyMenu, return");
            return;
        }
        this.aT_renamed.d_renamed(true);
        this.ah_renamed.setMenuOpen(true);
        com.oplus.camera.ui.CameraUIListener cameraUIListener = this.J_renamed;
        if (cameraUIListener != null) {
            this.aT_renamed.c_renamed(cameraUIListener.H_renamed());
        }
        com.oplus.camera.ui.CameraUIListener cameraUIListener2 = this.J_renamed;
        boolean z2 = false;
        int iZ = cameraUIListener2 != null ? cameraUIListener2.Z_renamed() : 0;
        e_renamed(z_renamed, iZ);
        android.view.View viewB = this.aT_renamed.b_renamed(iZ);
        android.view.ViewGroup.LayoutParams layoutParamsI = this.aT_renamed.i_renamed();
        if (viewB != null && layoutParamsI != null) {
            viewB.setVisibility(0);
            viewB.setAlpha(0.0f);
            if (viewB.getParent() == null) {
                this.Z_renamed.addView(viewB, java.lang.Math.max(this.Z_renamed.indexOfChild(this.z_renamed.U_renamed()) + 1, this.A_renamed.af_renamed() + 1), layoutParamsI);
            }
            com.oplus.camera.screen.b_renamed.a_renamed aVar = this.bx_renamed;
            if (aVar != null) {
                this.aT_renamed.h_renamed(aVar.a_renamed(this.M_renamed));
            }
            this.aT_renamed.e_renamed(z_renamed);
            if (this.J_renamed.h_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_SUPPORT_GRAND_TOUR_FILTERS) && com.oplus.camera.ui.preview.a_renamed.j_renamed.g_renamed() && !com.oplus.camera.e_renamed.a_renamed.a_renamed(cv_renamed()) && !this.B_renamed.getBoolean(com.oplus.camera.ui.CameraUIInterface.PRE_FACE_BEAUTY_FILTER_ICON_RECEOMMEND_CLICKED, false)) {
                z2 = true;
            }
            if (z2) {
                this.aT_renamed.f_renamed();
            } else {
                this.aT_renamed.g_renamed();
            }
        } else {
            com.oplus.camera.e_renamed.f_renamed("CameraUIManager", "openFaceBeautyMenu, view: " + viewB + ", params: " + layoutParamsI);
        }
        if (4 != aX_renamed()) {
            k_renamed(z_renamed, true);
            h_renamed(z_renamed, true);
        }
    }

    public void z_renamed(boolean z_renamed, boolean z2) {
        float f_renamed;
        com.oplus.camera.e_renamed.a_renamed("CameraUIManager", "showFaceBeautyButton, needAnim: " + z_renamed + ", needTranslate: " + z2);
        if (this.o_renamed) {
            return;
        }
        if (!(dS_renamed() && dH_renamed()) && this.aT_renamed.u_renamed()) {
            fg_renamed();
            this.aL_renamed.setClickable(true);
            android.animation.AnimatorSet animatorSet = this.aV_renamed;
            if (animatorSet != null && animatorSet.isStarted()) {
                this.aV_renamed.end();
            } else {
                if (this.aL_renamed.isShown()) {
                    return;
                }
                android.animation.AnimatorSet animatorSet2 = this.aU_renamed;
                if (animatorSet2 != null && animatorSet2.isStarted()) {
                    return;
                }
            }
            if (z_renamed) {
                java.lang.String str = "translationX";
                if (1 == aX_renamed()) {
                    f_renamed = 270 == this.bx_renamed.k_renamed() ? -this.bv_renamed : this.bv_renamed;
                    this.aL_renamed.setTranslationX(f_renamed);
                } else if (4 == aX_renamed()) {
                    f_renamed = this.bv_renamed;
                    this.aL_renamed.setTranslationX(f_renamed);
                } else {
                    f_renamed = -this.bv_renamed;
                    this.aL_renamed.setTranslationY(f_renamed);
                    str = "translationY";
                }
                this.aL_renamed.setAlpha(0.0f);
                this.aL_renamed.setVisibility(0);
                android.animation.ObjectAnimator objectAnimatorOfFloat = android.animation.ObjectAnimator.ofFloat(this.aL_renamed, "alpha", 0.0f, 1.0f);
                objectAnimatorOfFloat.setInterpolator(this.ba_renamed);
                objectAnimatorOfFloat.setDuration(250L);
                this.aU_renamed = new android.animation.AnimatorSet();
                android.animation.AnimatorSet.Builder builderPlay = this.aU_renamed.play(objectAnimatorOfFloat);
                if (z2) {
                    android.animation.ObjectAnimator objectAnimatorOfFloat2 = android.animation.ObjectAnimator.ofFloat(this.aL_renamed, str, f_renamed, 0.0f);
                    objectAnimatorOfFloat2.setInterpolator(this.bb_renamed);
                    objectAnimatorOfFloat2.setDuration(400L);
                    builderPlay.with(objectAnimatorOfFloat2);
                    this.aU_renamed.setStartDelay(150L);
                } else {
                    this.aL_renamed.setTranslationY(0.0f);
                    this.aL_renamed.setTranslationX(0.0f);
                }
                this.aU_renamed.addListener(new android.animation.AnimatorListenerAdapter() { // from class: com.oplus.camera.ui.d_renamed.41
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(android.animation.Animator animator) {
                        if (com.oplus.camera.ui.d_renamed.this.aL_renamed != null) {
                            com.oplus.camera.ui.d_renamed.this.aL_renamed.setTranslationY(0.0f);
                            com.oplus.camera.ui.d_renamed.this.aL_renamed.setTranslationX(0.0f);
                            com.oplus.camera.ui.d_renamed.this.aL_renamed.setAlpha(1.0f);
                            com.oplus.camera.ui.d_renamed.this.aL_renamed.setVisibility(0);
                            com.oplus.camera.ui.d_renamed.this.gh_renamed();
                        }
                    }
                });
                this.aU_renamed.start();
            } else {
                this.aL_renamed.setTranslationY(0.0f);
                this.aL_renamed.setTranslationX(0.0f);
                this.aL_renamed.setAlpha(1.0f);
                this.aL_renamed.setVisibility(0);
                gh_renamed();
            }
            if (fB_renamed()) {
                return;
            }
            this.aL_renamed.setEnabled(true);
        }
    }

    @Override // com.oplus.camera.ui.CameraUIInterface
    public void k_renamed(boolean z_renamed, boolean z2) {
        float f_renamed;
        int i_renamed;
        com.oplus.camera.e_renamed.a_renamed("CameraUIManager", "hideFaceBeautyButton, needAnim: " + z_renamed + ", needTranslate: " + z2);
        android.animation.AnimatorSet animatorSet = this.aU_renamed;
        if (animatorSet != null && animatorSet.isStarted()) {
            this.aU_renamed.cancel();
        } else {
            com.oplus.camera.ui.widget.SplitBackgroundView splitBackgroundView = this.aL_renamed;
            if (splitBackgroundView == null || !splitBackgroundView.isShown()) {
                return;
            }
            android.animation.AnimatorSet animatorSet2 = this.aV_renamed;
            if (animatorSet2 != null && animatorSet2.isStarted()) {
                return;
            }
        }
        this.aL_renamed.setClickable(false);
        if (z_renamed) {
            android.animation.ObjectAnimator objectAnimatorOfFloat = android.animation.ObjectAnimator.ofFloat(this.aL_renamed, "alpha", 1.0f, 0.0f);
            objectAnimatorOfFloat.setInterpolator(this.ba_renamed);
            objectAnimatorOfFloat.setDuration(250L);
            this.aV_renamed = new android.animation.AnimatorSet();
            android.animation.AnimatorSet.Builder builderPlay = this.aV_renamed.play(objectAnimatorOfFloat);
            if (z2) {
                java.lang.String str = "translationX";
                if (1 == aX_renamed()) {
                    i_renamed = 270 == this.bx_renamed.k_renamed() ? -this.bv_renamed : this.bv_renamed;
                } else if (4 == aX_renamed()) {
                    i_renamed = this.bv_renamed;
                } else {
                    f_renamed = -this.bv_renamed;
                    str = "translationY";
                    android.animation.ObjectAnimator objectAnimatorOfFloat2 = android.animation.ObjectAnimator.ofFloat(this.aL_renamed, str, 0.0f, f_renamed);
                    objectAnimatorOfFloat2.setInterpolator(this.bb_renamed);
                    objectAnimatorOfFloat2.setDuration(400L);
                    builderPlay.with(objectAnimatorOfFloat2);
                }
                f_renamed = i_renamed;
                android.animation.ObjectAnimator objectAnimatorOfFloat22 = android.animation.ObjectAnimator.ofFloat(this.aL_renamed, str, 0.0f, f_renamed);
                objectAnimatorOfFloat22.setInterpolator(this.bb_renamed);
                objectAnimatorOfFloat22.setDuration(400L);
                builderPlay.with(objectAnimatorOfFloat22);
            } else {
                this.aL_renamed.setTranslationY(0.0f);
                this.aL_renamed.setTranslationX(0.0f);
            }
            this.aV_renamed.addListener(new android.animation.AnimatorListenerAdapter() { // from class: com.oplus.camera.ui.d_renamed.42
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationCancel(android.animation.Animator animator) {
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(android.animation.Animator animator) {
                    if (com.oplus.camera.ui.d_renamed.this.aL_renamed != null) {
                        com.oplus.camera.ui.d_renamed.this.aL_renamed.setEnabled(false);
                        com.oplus.camera.ui.d_renamed.this.aL_renamed.setTranslationY(0.0f);
                        com.oplus.camera.ui.d_renamed.this.aL_renamed.setTranslationX(0.0f);
                        com.oplus.camera.ui.d_renamed.this.aL_renamed.setAlpha(1.0f);
                        com.oplus.camera.ui.d_renamed.this.aL_renamed.setVisibility(0);
                    }
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(android.animation.Animator animator) {
                    if (com.oplus.camera.ui.d_renamed.this.aL_renamed != null) {
                        if (!com.oplus.camera.ui.d_renamed.this.fB_renamed() || !com.oplus.camera.ui.d_renamed.this.aU_renamed()) {
                            com.oplus.camera.ui.d_renamed.this.aL_renamed.setEnabled(true);
                        }
                        com.oplus.camera.ui.d_renamed.this.aL_renamed.setTranslationY(0.0f);
                        com.oplus.camera.ui.d_renamed.this.aL_renamed.setTranslationX(0.0f);
                        com.oplus.camera.ui.d_renamed.this.aL_renamed.setAlpha(0.0f);
                        com.oplus.camera.ui.d_renamed.this.gi_renamed();
                        com.oplus.camera.ui.d_renamed.this.aL_renamed.setVisibility(8);
                    }
                }
            });
            gi_renamed();
            this.aV_renamed.start();
            return;
        }
        gi_renamed();
        this.aL_renamed.setVisibility(8);
        this.aL_renamed.setTranslationY(0.0f);
        this.aL_renamed.setAlpha(0.0f);
    }

    public void A_renamed(boolean z_renamed, boolean z2) {
        com.oplus.camera.e_renamed.b_renamed("CameraUIManager", "setEffectMenuBackButtonVisibility, visible: " + z_renamed + ", needTranslateAnim: " + z2);
        if (1 != aX_renamed()) {
            return;
        }
        float f_renamed = 270 == this.bx_renamed.k_renamed() ? this.bv_renamed : -this.bv_renamed;
        if (!z2) {
            f_renamed = 0.0f;
        }
        float f2 = f_renamed;
        if (z_renamed) {
            com.oplus.camera.util.Util.a_renamed((android.view.View) this.aM_renamed, true, f2, 0.0f, (android.animation.TimeInterpolator) this.ba_renamed, 400L, (android.animation.TimeInterpolator) this.bb_renamed, 400L, (android.animation.Animator.AnimatorListener) null, 150L);
        } else {
            com.oplus.camera.util.Util.a_renamed((android.view.View) this.aM_renamed, false, f2, 0.0f, (android.animation.TimeInterpolator) this.ba_renamed, 250L, (android.animation.TimeInterpolator) this.bb_renamed, 400L, (android.animation.Animator.AnimatorListener) null, 0L);
        }
    }

    @Override // com.oplus.camera.ui.CameraUIInterface
    public void B_renamed(boolean z_renamed) {
        com.oplus.camera.ui.control.a_renamed aVar = this.z_renamed;
        if (aVar != null) {
            if (z_renamed) {
                aVar.af_renamed();
            } else {
                aVar.ad_renamed();
            }
        }
    }

    @Override // com.oplus.camera.ui.CameraUIInterface
    public void ar_renamed() {
        if (this.z_renamed != null) {
            com.oplus.camera.doubleexposure.g_renamed gVar = this.bs_renamed;
            if (gVar == null || !gVar.o_renamed()) {
                this.z_renamed.ag_renamed();
            }
        }
    }

    @Override // com.oplus.camera.ui.CameraUIInterface
    public void as_renamed() {
        com.oplus.camera.ui.control.a_renamed aVar = this.z_renamed;
        if (aVar != null) {
            aVar.ai_renamed();
        }
    }

    @Override // com.oplus.camera.ui.CameraUIInterface
    public void c_renamed(boolean z_renamed, boolean z2, boolean z3, boolean z4) throws android.content.res.Resources.NotFoundException {
        com.oplus.camera.ui.menu.facebeauty.RotateAnimationView rotateAnimationView = this.aQ_renamed;
        if (rotateAnimationView != null && com.oplus.camera.R_renamed.drawable.multi_video_type_menu_normal != this.aP_renamed) {
            this.aP_renamed = com.oplus.camera.R_renamed.drawable.multi_video_type_menu_normal;
            rotateAnimationView.setImageResource(this.aP_renamed);
        }
        com.oplus.camera.ui.preview.g_renamed gVar = this.A_renamed;
        if (gVar != null) {
            gVar.c_renamed(z_renamed, z2);
            if (z3 && 1 == aX_renamed()) {
                A_renamed(z_renamed, z2);
                if (z4) {
                    w_renamed(!z_renamed, z2);
                }
            }
        }
    }

    @Override // com.oplus.camera.ui.CameraUIInterface
    public void a_renamed(boolean z_renamed, boolean z2, boolean z3, boolean z4) {
        a_renamed(z_renamed, z2, z3, z4, -1L);
    }

    public void a_renamed(boolean z_renamed, boolean z2, boolean z3, boolean z4, long j_renamed) throws android.content.res.Resources.NotFoundException {
        com.oplus.camera.e_renamed.a_renamed("CameraUIManager", "closeFaceBeautyMenu, needAnim: " + z_renamed + ", showEnterButton: " + z2 + ", showZoom: " + z4);
        if (this.aT_renamed == null || !K_renamed()) {
            com.oplus.camera.e_renamed.a_renamed("CameraUIManager", "closeFaceBeautyMenu, mFaceBeautyMenu: " + this.aT_renamed + ", isFaceBeautyMenuOpen(): " + K_renamed() + ", return.");
            return;
        }
        this.cb_renamed = j_renamed;
        com.oplus.camera.ui.preview.g_renamed gVar = this.A_renamed;
        if (gVar != null) {
            gVar.g_renamed(true);
        }
        this.J_renamed.j_renamed(false);
        if (this.aT_renamed.o_renamed()) {
            this.J_renamed.aK_renamed();
        }
        this.aT_renamed.d_renamed(false);
        this.aT_renamed.f_renamed(z_renamed);
        this.ah_renamed.setMenuOpen(false);
        f_renamed(8, true);
        a_renamed(z_renamed, this.aT_renamed.e_renamed(), z2, z4);
        if (4 == aX_renamed()) {
            return;
        }
        if (z3 && ((!com.oplus.camera.util.Util.u_renamed() || !this.J_renamed.bV_renamed()) && this.J_renamed.bm_renamed() && !this.o_renamed)) {
            i_renamed(z_renamed, true);
        }
        if (z2 && ((!com.oplus.camera.util.Util.u_renamed() || !this.J_renamed.bV_renamed()) && this.J_renamed.bl_renamed() && !this.o_renamed)) {
            z_renamed(z_renamed, true);
        }
        A_renamed(false, z_renamed);
    }

    @Override // com.oplus.camera.ui.CameraUIInterface
    public boolean K_renamed() {
        com.oplus.camera.ui.menu.facebeauty.g_renamed gVar = this.aT_renamed;
        return gVar != null && gVar.n_renamed();
    }

    public boolean cW_renamed() {
        com.oplus.camera.ui.menu.facebeauty.g_renamed gVar = this.aT_renamed;
        return gVar != null && gVar.n_renamed() && 1 == this.aT_renamed.e_renamed();
    }

    @Override // com.oplus.camera.ui.CameraUIInterface
    public boolean O_renamed() {
        com.oplus.camera.ui.menu.levelcontrol.c_renamed cVar = this.ai_renamed;
        return cVar != null && cVar.isMenuOpen();
    }

    @Override // com.oplus.camera.ui.CameraUIInterface
    public boolean P_renamed() {
        com.oplus.camera.ui.menu.levelcontrol.c_renamed cVar = this.ai_renamed;
        return cVar != null && cVar.isAnimationRunning();
    }

    @Override // com.oplus.camera.ui.CameraUIInterface
    public boolean Q_renamed() {
        com.oplus.camera.ui.menu.facebeauty.g_renamed gVar = this.aT_renamed;
        return gVar != null && gVar.m_renamed();
    }

    public boolean cX_renamed() {
        com.oplus.camera.ui.menu.levelcontrol.c_renamed cVar = this.aS_renamed;
        return cVar != null && cVar.isMenuOpen();
    }

    @Override // com.oplus.camera.ui.CameraUIInterface
    public void r_renamed(boolean z_renamed) {
        if (this.ah_renamed == null || !this.J_renamed.h_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_FILTER_PROCESS) || this.J_renamed.c_renamed() || this.o_renamed) {
            return;
        }
        if (this.J_renamed.f_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_FILTER_MENU) || this.J_renamed.f_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_FILTER_MENU)) {
            this.ah_renamed.a_renamed(0, z_renamed);
        } else if (A_renamed() && this.J_renamed.aJ_renamed()) {
            u_renamed(true);
        }
    }

    public void i_renamed(int i_renamed, boolean z_renamed) {
        com.oplus.camera.ui.menu.facebeauty.g_renamed gVar;
        if (z_renamed) {
            gh_renamed();
        } else {
            gi_renamed();
        }
        this.aL_renamed.setClickable(z_renamed);
        this.aL_renamed.setEnabled(z_renamed);
        X_renamed(i_renamed);
        if (z_renamed || (gVar = this.aT_renamed) == null || !gVar.n_renamed()) {
            return;
        }
        a_renamed(true, true, true, true);
    }

    private void X_renamed(int i_renamed) {
        com.oplus.camera.ui.menu.facebeauty.g_renamed gVar = this.aT_renamed;
        if (gVar != null) {
            gVar.d_renamed(i_renamed);
        }
    }

    public void aj_renamed(final boolean z_renamed) {
        com.oplus.camera.ui.menu.facebeauty.g_renamed gVar = this.aT_renamed;
        if (gVar == null || z_renamed == gVar.h_renamed()) {
            return;
        }
        this.i_renamed.runOnUiThread(new java.lang.Runnable() { // from class: com.oplus.camera.ui.d_renamed.44
            @Override // java.lang.Runnable
            public void run() {
                com.oplus.camera.ui.d_renamed.this.aT_renamed.c_renamed(z_renamed);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fg_renamed() {
        final boolean z_renamed;
        final int i_renamed;
        int i2;
        com.oplus.camera.e_renamed.a_renamed("CameraUIManager", "updateFaceBeautyEnterButton");
        com.oplus.camera.ui.menu.facebeauty.g_renamed gVar = this.aT_renamed;
        if (gVar != null) {
            final boolean zR = gVar.r_renamed();
            final boolean zT = this.aT_renamed.t_renamed();
            final boolean zS = this.aT_renamed.s_renamed();
            boolean z2 = this.J_renamed.h_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_SUPPORT_GRAND_TOUR_FILTERS) && com.oplus.camera.ui.preview.a_renamed.j_renamed.g_renamed() && !com.oplus.camera.e_renamed.a_renamed.a_renamed(cv_renamed()) && !this.B_renamed.getBoolean(com.oplus.camera.ui.CameraUIInterface.PRE_FACE_BEAUTY_ICON_RECEOMMEND_CLICKED, false);
            com.oplus.camera.ui.widget.SplitBackgroundView splitBackgroundView = this.aL_renamed;
            if (splitBackgroundView != null) {
                splitBackgroundView.a_renamed(z2, 0, 0);
            }
            com.oplus.camera.e_renamed.a_renamed("CameraUIManager", "setImageResource, supportFaceBeauty: " + zR + ", supportFilter: " + zT + " needShowRedDot " + z2);
            if (zR && zT) {
                i2 = com.oplus.camera.R_renamed.drawable.face_beauty_menu_control_button;
            } else {
                if (!zR) {
                    if (zT) {
                        i_renamed = com.oplus.camera.R_renamed.drawable.face_beauty_menu_effect_button;
                        z_renamed = false;
                    } else {
                        z_renamed = true;
                        i_renamed = 0;
                    }
                    this.i_renamed.runOnUiThread(new java.lang.Runnable() { // from class: com.oplus.camera.ui.d_renamed.45
                        /* JADX WARN: Removed duplicated region for block: B_renamed:13:0x0041  */
                        @Override // java.lang.Runnable
                        /*
                            Code decompiled incorrectly, please refer to instructions dump.
                            To view partially-correct add '--show-bad-code' argument
                        */
                        public void run() {
                            /*
                                r3 = this;
                                int r0 = r2
                                com.oplus.camera.ui.d_renamed r1 = com.oplus.camera.ui.d_renamed.this
                                int r1 = com.oplus.camera.ui.d_renamed.ai_renamed(r1)
                                if (r0 == r1) goto L1c
                                com.oplus.camera.ui.d_renamed r0 = com.oplus.camera.ui.d_renamed.this
                                int r1 = r2
                                com.oplus.camera.ui.d_renamed.j_renamed(r0, r1)
                                com.oplus.camera.ui.d_renamed r0 = com.oplus.camera.ui.d_renamed.this
                                com.oplus.camera.ui.widget.SplitBackgroundView r0 = com.oplus.camera.ui.d_renamed.ae_renamed(r0)
                                int r1 = r2
                                r0.setImageResource(r1)
                            L1c:
                                com.oplus.camera.ui.d_renamed r0 = com.oplus.camera.ui.d_renamed.this
                                com.oplus.camera.ui.CameraUIListener r0 = com.oplus.camera.ui.d_renamed.i_renamed(r0)
                                if (r0 != 0) goto L2c
                                java.lang.String r3 = "CameraUIManager"
                                java.lang.String r0 = "updateFaceBeautyEnterButton, mCameraUIListener is_renamed null"
                                com.oplus.camera.e_renamed.f_renamed(r3, r0)
                                return
                            L2c:
                                boolean r0 = r3
                                r1 = 0
                                if (r0 == 0) goto L41
                                com.oplus.camera.ui.d_renamed r0 = com.oplus.camera.ui.d_renamed.this
                                com.oplus.camera.ui.CameraUIListener r2 = com.oplus.camera.ui.d_renamed.i_renamed(r0)
                                int r2 = r2.aa_renamed()
                                boolean r0 = com.oplus.camera.ui.d_renamed.k_renamed(r0, r2)
                                if (r0 != 0) goto L61
                            L41:
                                boolean r0 = r4
                                if (r0 == 0) goto L51
                                com.oplus.camera.ui.d_renamed r0 = com.oplus.camera.ui.d_renamed.this
                                com.oplus.camera.ui.CameraUIListener r0 = com.oplus.camera.ui.d_renamed.i_renamed(r0)
                                int r0 = r0.ae_renamed()
                                if (r0 != 0) goto L61
                            L51:
                                boolean r0 = r5
                                if (r0 == 0) goto La6
                                com.oplus.camera.ui.d_renamed r0 = com.oplus.camera.ui.d_renamed.this
                                com.oplus.camera.ui.CameraUIListener r0 = com.oplus.camera.ui.d_renamed.i_renamed(r0)
                                boolean r0 = r0.af_renamed()
                                if (r0 == 0) goto La6
                            L61:
                                boolean r0 = r6
                                if (r0 != 0) goto L9b
                                com.oplus.camera.ui.d_renamed r0 = com.oplus.camera.ui.d_renamed.this
                                com.oplus.camera.ui.CameraUIListener r0 = com.oplus.camera.ui.d_renamed.i_renamed(r0)
                                boolean r0 = r0.af_renamed()
                                if (r0 == 0) goto L9b
                                com.oplus.camera.ui.d_renamed r0 = com.oplus.camera.ui.d_renamed.this
                                com.oplus.camera.ui.widget.SplitBackgroundView r0 = com.oplus.camera.ui.d_renamed.ae_renamed(r0)
                                r0.a_renamed()
                                com.oplus.camera.ui.d_renamed r0 = com.oplus.camera.ui.d_renamed.this
                                r2 = 2131232030(0x7f08051e, float:1.8080158E38)
                                com.oplus.camera.ui.d_renamed.j_renamed(r0, r2)
                                com.oplus.camera.ui.d_renamed r0 = com.oplus.camera.ui.d_renamed.this
                                com.oplus.camera.ui.widget.SplitBackgroundView r0 = com.oplus.camera.ui.d_renamed.ae_renamed(r0)
                                r0.setColorFilter(r1)
                                com.oplus.camera.ui.d_renamed r0 = com.oplus.camera.ui.d_renamed.this
                                com.oplus.camera.ui.widget.SplitBackgroundView r0 = com.oplus.camera.ui.d_renamed.ae_renamed(r0)
                                com.oplus.camera.ui.d_renamed r3 = com.oplus.camera.ui.d_renamed.this
                                int r3 = com.oplus.camera.ui.d_renamed.ai_renamed(r3)
                                r0.setImageResource(r3)
                                goto Laf
                            L9b:
                                com.oplus.camera.ui.d_renamed r3 = com.oplus.camera.ui.d_renamed.this
                                com.oplus.camera.ui.widget.SplitBackgroundView r3 = com.oplus.camera.ui.d_renamed.ae_renamed(r3)
                                r0 = 1
                                r3.setSelected(r0)
                                goto Laf
                            La6:
                                com.oplus.camera.ui.d_renamed r3 = com.oplus.camera.ui.d_renamed.this
                                com.oplus.camera.ui.widget.SplitBackgroundView r3 = com.oplus.camera.ui.d_renamed.ae_renamed(r3)
                                r3.setSelected(r1)
                            Laf:
                                return
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.ui.d_renamed.AnonymousClass45.run():void");
                        }
                    });
                }
                i2 = com.oplus.camera.R_renamed.drawable.face_beauty_menu_control_button_facebeauty;
            }
            i_renamed = i2;
            z_renamed = true;
            this.i_renamed.runOnUiThread(new java.lang.Runnable() { // from class: com.oplus.camera.ui.d_renamed.45
                @Override // java.lang.Runnable
                public void run() {
                    /*
                        this = this;
                        int r0 = r2
                        com.oplus.camera.ui.d_renamed r1 = com.oplus.camera.ui.d_renamed.this
                        int r1 = com.oplus.camera.ui.d_renamed.ai_renamed(r1)
                        if (r0 == r1) goto L1c
                        com.oplus.camera.ui.d_renamed r0 = com.oplus.camera.ui.d_renamed.this
                        int r1 = r2
                        com.oplus.camera.ui.d_renamed.j_renamed(r0, r1)
                        com.oplus.camera.ui.d_renamed r0 = com.oplus.camera.ui.d_renamed.this
                        com.oplus.camera.ui.widget.SplitBackgroundView r0 = com.oplus.camera.ui.d_renamed.ae_renamed(r0)
                        int r1 = r2
                        r0.setImageResource(r1)
                    L1c:
                        com.oplus.camera.ui.d_renamed r0 = com.oplus.camera.ui.d_renamed.this
                        com.oplus.camera.ui.CameraUIListener r0 = com.oplus.camera.ui.d_renamed.i_renamed(r0)
                        if (r0 != 0) goto L2c
                        java.lang.String r3 = "CameraUIManager"
                        java.lang.String r0 = "updateFaceBeautyEnterButton, mCameraUIListener is_renamed null"
                        com.oplus.camera.e_renamed.f_renamed(r3, r0)
                        return
                    L2c:
                        boolean r0 = r3
                        r1 = 0
                        if (r0 == 0) goto L41
                        com.oplus.camera.ui.d_renamed r0 = com.oplus.camera.ui.d_renamed.this
                        com.oplus.camera.ui.CameraUIListener r2 = com.oplus.camera.ui.d_renamed.i_renamed(r0)
                        int r2 = r2.aa_renamed()
                        boolean r0 = com.oplus.camera.ui.d_renamed.k_renamed(r0, r2)
                        if (r0 != 0) goto L61
                    L41:
                        boolean r0 = r4
                        if (r0 == 0) goto L51
                        com.oplus.camera.ui.d_renamed r0 = com.oplus.camera.ui.d_renamed.this
                        com.oplus.camera.ui.CameraUIListener r0 = com.oplus.camera.ui.d_renamed.i_renamed(r0)
                        int r0 = r0.ae_renamed()
                        if (r0 != 0) goto L61
                    L51:
                        boolean r0 = r5
                        if (r0 == 0) goto La6
                        com.oplus.camera.ui.d_renamed r0 = com.oplus.camera.ui.d_renamed.this
                        com.oplus.camera.ui.CameraUIListener r0 = com.oplus.camera.ui.d_renamed.i_renamed(r0)
                        boolean r0 = r0.af_renamed()
                        if (r0 == 0) goto La6
                    L61:
                        boolean r0 = r6
                        if (r0 != 0) goto L9b
                        com.oplus.camera.ui.d_renamed r0 = com.oplus.camera.ui.d_renamed.this
                        com.oplus.camera.ui.CameraUIListener r0 = com.oplus.camera.ui.d_renamed.i_renamed(r0)
                        boolean r0 = r0.af_renamed()
                        if (r0 == 0) goto L9b
                        com.oplus.camera.ui.d_renamed r0 = com.oplus.camera.ui.d_renamed.this
                        com.oplus.camera.ui.widget.SplitBackgroundView r0 = com.oplus.camera.ui.d_renamed.ae_renamed(r0)
                        r0.a_renamed()
                        com.oplus.camera.ui.d_renamed r0 = com.oplus.camera.ui.d_renamed.this
                        r2 = 2131232030(0x7f08051e, float:1.8080158E38)
                        com.oplus.camera.ui.d_renamed.j_renamed(r0, r2)
                        com.oplus.camera.ui.d_renamed r0 = com.oplus.camera.ui.d_renamed.this
                        com.oplus.camera.ui.widget.SplitBackgroundView r0 = com.oplus.camera.ui.d_renamed.ae_renamed(r0)
                        r0.setColorFilter(r1)
                        com.oplus.camera.ui.d_renamed r0 = com.oplus.camera.ui.d_renamed.this
                        com.oplus.camera.ui.widget.SplitBackgroundView r0 = com.oplus.camera.ui.d_renamed.ae_renamed(r0)
                        com.oplus.camera.ui.d_renamed r3 = com.oplus.camera.ui.d_renamed.this
                        int r3 = com.oplus.camera.ui.d_renamed.ai_renamed(r3)
                        r0.setImageResource(r3)
                        goto Laf
                    L9b:
                        com.oplus.camera.ui.d_renamed r3 = com.oplus.camera.ui.d_renamed.this
                        com.oplus.camera.ui.widget.SplitBackgroundView r3 = com.oplus.camera.ui.d_renamed.ae_renamed(r3)
                        r0 = 1
                        r3.setSelected(r0)
                        goto Laf
                    La6:
                        com.oplus.camera.ui.d_renamed r3 = com.oplus.camera.ui.d_renamed.this
                        com.oplus.camera.ui.widget.SplitBackgroundView r3 = com.oplus.camera.ui.d_renamed.ae_renamed(r3)
                        r3.setSelected(r1)
                    Laf:
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.ui.d_renamed.AnonymousClass45.run():void");
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Y_renamed(int i_renamed) {
        if (!com.oplus.camera.e_renamed.a_renamed.a_renamed(cv_renamed())) {
            return i_renamed != 0;
        }
        if (i_renamed == 0) {
            return j_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_SUPPORT_MAKEUP) && this.J_renamed.ae_renamed() != 0;
        }
        return true;
    }

    public void cY_renamed() {
        com.oplus.camera.ui.preview.g_renamed gVar = this.A_renamed;
        if (gVar == null || !gVar.am_renamed()) {
            return;
        }
        this.A_renamed.aj_renamed();
    }

    private void e_renamed(boolean z_renamed, int i_renamed) throws android.content.res.Resources.NotFoundException {
        boolean z2;
        if (1 == aX_renamed()) {
            w_renamed(false, true);
            z2 = false;
        } else {
            z2 = true;
        }
        if (i_renamed == 1) {
            if (fh_renamed()) {
                if (z2) {
                    c_renamed(z_renamed, 0);
                }
                com.oplus.camera.ui.CameraUIListener cameraUIListener = this.J_renamed;
                if (cameraUIListener != null) {
                    cameraUIListener.q_renamed();
                }
            } else {
                com.oplus.camera.ui.control.a_renamed aVar = this.z_renamed;
                if (aVar != null && z2) {
                    if (z_renamed) {
                        aVar.h_renamed();
                    } else {
                        aVar.a_renamed(0);
                    }
                }
                com.oplus.camera.ui.CameraUIListener cameraUIListener2 = this.J_renamed;
                if (cameraUIListener2 != null) {
                    cameraUIListener2.q_renamed();
                }
            }
            cY_renamed();
        } else if (i_renamed == 2) {
            if (!fh_renamed()) {
                com.oplus.camera.ui.control.a_renamed aVar2 = this.z_renamed;
                if (aVar2 != null && z2) {
                    if (z_renamed) {
                        aVar2.h_renamed();
                    } else {
                        aVar2.a_renamed(0);
                    }
                }
            } else if (z2) {
                c_renamed(z_renamed, 0);
            }
            com.oplus.camera.ui.CameraUIListener cameraUIListener3 = this.J_renamed;
            if (cameraUIListener3 != null) {
                cameraUIListener3.q_renamed();
            }
        }
        if (4 != aX_renamed()) {
            A_renamed(true, z_renamed);
        } else {
            g_renamed(4);
        }
    }

    private void a_renamed(boolean z_renamed, int i_renamed, boolean z2, boolean z3) throws android.content.res.Resources.NotFoundException {
        boolean z4;
        com.oplus.camera.ui.CameraUIListener cameraUIListener;
        com.oplus.camera.ui.CameraUIListener cameraUIListener2;
        com.oplus.camera.ui.control.a_renamed aVar;
        com.oplus.camera.ui.CameraUIListener cameraUIListener3;
        if (1 == aX_renamed()) {
            w_renamed(true, z_renamed);
            z4 = false;
        } else {
            z4 = true;
        }
        if (!z2) {
            if (z3 && (cameraUIListener3 = this.J_renamed) != null) {
                cameraUIListener3.a_renamed(false);
            }
            if (!R_renamed() || (aVar = this.z_renamed) == null || aVar.d_renamed() || !z4) {
                return;
            }
            if (z_renamed) {
                this.z_renamed.b_renamed(true, true);
                return;
            } else {
                this.z_renamed.b_renamed(0);
                return;
            }
        }
        if (i_renamed == 1) {
            if (fh_renamed()) {
                if (z4) {
                    a_renamed(0, true);
                }
                com.oplus.camera.ui.CameraUIListener cameraUIListener4 = this.J_renamed;
                if (cameraUIListener4 != null) {
                    cameraUIListener4.a_renamed(false);
                }
            } else {
                com.oplus.camera.ui.control.a_renamed aVar2 = this.z_renamed;
                if (aVar2 != null && z4) {
                    if (z_renamed) {
                        aVar2.b_renamed(true, true);
                    } else {
                        aVar2.b_renamed(0);
                    }
                }
            }
            if (z3 && (cameraUIListener = this.J_renamed) != null) {
                cameraUIListener.a_renamed(false);
            }
        } else if (i_renamed == 2) {
            if (!fh_renamed()) {
                com.oplus.camera.ui.control.a_renamed aVar3 = this.z_renamed;
                if (aVar3 != null && z4) {
                    if (z_renamed) {
                        aVar3.b_renamed(true, true);
                    } else {
                        aVar3.b_renamed(0);
                    }
                }
            } else if (z4) {
                a_renamed(0, true);
            }
            if (z3 && (cameraUIListener2 = this.J_renamed) != null) {
                cameraUIListener2.a_renamed(false);
            }
        }
        if (4 == aX_renamed()) {
            g_renamed(0);
        }
    }

    public void cZ_renamed() {
        com.oplus.camera.ui.control.a_renamed aVar;
        com.oplus.camera.ui.control.a_renamed aVar2;
        com.oplus.camera.ui.preview.ae_renamed aeVar;
        if (this.z_renamed != null && this.J_renamed.by_renamed()) {
            aw_renamed(false);
            this.z_renamed.x_renamed();
        }
        com.oplus.camera.ui.menu.levelcontrol.g_renamed gVar = this.ah_renamed;
        if (gVar != null && !gVar.isEffectMenuOpen()) {
            q_renamed(false);
        }
        if (O_renamed()) {
            b_renamed(false, true, false, false);
        }
        if (this.aL_renamed != null) {
            j_renamed(true, true);
            f_renamed(17, true);
            f_renamed(20, true);
        }
        if (this.aQ_renamed != null) {
            h_renamed(true, true);
        }
        com.oplus.camera.ui.CameraUIListener cameraUIListener = this.J_renamed;
        if (cameraUIListener != null && cameraUIListener.c_renamed() && (aeVar = this.D_renamed) != null) {
            aeVar.a_renamed(false);
        }
        if (bK_renamed()) {
            cw_renamed();
        }
        if (fh_renamed()) {
            this.l_renamed.a_renamed().a_renamed(new com.oplus.camera.screen.b_renamed.o_renamed.a_renamed() { // from class: com.oplus.camera.ui.-$$Lambda$d_renamed$bgh1c-vo0262TYQZtUuG1W-iAEM
                @Override // com.oplus.camera.screen.b_renamed.o_renamed.a_renamed
                public final void call(java.lang.Object[] objArr) {
                    this.f_renamed$0.l_renamed(objArr);
                }
            }, new com.oplus.camera.screen.b_renamed.o_renamed.a_renamed() { // from class: com.oplus.camera.ui.-$$Lambda$d_renamed$t2RD7SVil82Y0cg8dwEAGBde5s4
                @Override // com.oplus.camera.screen.b_renamed.o_renamed.a_renamed
                public final void call(java.lang.Object[] objArr) {
                    this.f_renamed$0.k_renamed(objArr);
                }
            }, new com.oplus.camera.screen.b_renamed.o_renamed.a_renamed() { // from class: com.oplus.camera.ui.-$$Lambda$d_renamed$_kFif1W_0NzKSmfl28wlMFlUyKQ
                @Override // com.oplus.camera.screen.b_renamed.o_renamed.a_renamed
                public final void call(java.lang.Object[] objArr) {
                    this.f_renamed$0.j_renamed(objArr);
                }
            });
            this.bZ_renamed = true;
            if (com.oplus.camera.util.Util.ao_renamed() && dr_renamed() && (aVar2 = this.z_renamed) != null) {
                aVar2.a_renamed((byte) 1, true);
            }
        } else {
            com.oplus.camera.ui.CameraUIListener cameraUIListener2 = this.J_renamed;
            if (cameraUIListener2 != null && cameraUIListener2.c_renamed()) {
                com.oplus.camera.ui.preview.ae_renamed aeVar2 = this.D_renamed;
                if (aeVar2 != null) {
                    aeVar2.a_renamed(false);
                }
                if (com.oplus.camera.util.Util.ao_renamed() && (aVar = this.z_renamed) != null) {
                    aVar.a_renamed((byte) 1, true);
                }
            } else {
                a_renamed((byte) 1, true);
                this.l_renamed.a_renamed().a_renamed(new com.oplus.camera.screen.b_renamed.o_renamed.a_renamed() { // from class: com.oplus.camera.ui.-$$Lambda$d_renamed$RKRAKXv9ATH5XyjNie1PSG7w3ko
                    @Override // com.oplus.camera.screen.b_renamed.o_renamed.a_renamed
                    public final void call(java.lang.Object[] objArr) {
                        this.f_renamed$0.i_renamed(objArr);
                    }
                }, new com.oplus.camera.screen.b_renamed.o_renamed.a_renamed() { // from class: com.oplus.camera.ui.-$$Lambda$d_renamed$Dti7p3yGPMOoqJh--XPNIzYqbc0
                    @Override // com.oplus.camera.screen.b_renamed.o_renamed.a_renamed
                    public final void call(java.lang.Object[] objArr) {
                        this.f_renamed$0.h_renamed(objArr);
                    }
                }, new com.oplus.camera.screen.b_renamed.o_renamed.a_renamed() { // from class: com.oplus.camera.ui.-$$Lambda$d_renamed$3az6q606Drt0UF4HYhFGvdUn4eM
                    @Override // com.oplus.camera.screen.b_renamed.o_renamed.a_renamed
                    public final void call(java.lang.Object[] objArr) {
                        this.f_renamed$0.g_renamed(objArr);
                    }
                });
            }
        }
        com.oplus.camera.ui.preview.g_renamed gVar2 = this.A_renamed;
        if (gVar2 != null) {
            gVar2.ao_renamed();
        }
        C_renamed(true, false);
        if (ex_renamed()) {
            d_renamed(false, false, this.bP_renamed.c_renamed(), false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void l_renamed(java.lang.Object[] objArr) {
        this.aJ_renamed.b_renamed(android.view.animation.AnimationUtils.loadAnimation(this.i_renamed, com.oplus.camera.R_renamed.anim.zoom_panel_level_out));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void k_renamed(java.lang.Object[] objArr) {
        a_renamed(4, ((java.lang.Float) objArr[0]).floatValue(), ((java.lang.Float) objArr[1]).floatValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void j_renamed(java.lang.Object[] objArr) {
        k_renamed(true, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void i_renamed(java.lang.Object[] objArr) {
        a_renamed(4, ((java.lang.Integer) objArr[0]).intValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void h_renamed(java.lang.Object[] objArr) {
        a_renamed(4, ((java.lang.Float) objArr[0]).floatValue(), ((java.lang.Float) objArr[1]).floatValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g_renamed(java.lang.Object[] objArr) {
        k_renamed(true, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean fh_renamed() {
        com.oplus.camera.ui.CameraUIListener cameraUIListener = this.J_renamed;
        return cameraUIListener != null && cameraUIListener.aq_renamed();
    }

    public void ak_renamed(boolean z_renamed) {
        com.oplus.camera.ui.CameraUIListener cameraUIListener;
        com.oplus.camera.ui.CameraUIListener cameraUIListener2;
        com.oplus.camera.ui.control.a_renamed aVar;
        if (this.z_renamed != null && this.J_renamed.by_renamed()) {
            z_renamed(true);
            this.z_renamed.y_renamed();
        }
        com.oplus.camera.ui.CameraUIListener cameraUIListener3 = this.J_renamed;
        if (cameraUIListener3 != null) {
            if (cameraUIListener3.k_renamed()) {
                fj_renamed();
                if (this.J_renamed.aq_renamed()) {
                    a_renamed(0, 0.0f, this.i_renamed.getApplication().getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.zoom_linkage_translate));
                }
                if (com.oplus.camera.util.Util.ao_renamed() && (aVar = this.z_renamed) != null) {
                    aVar.a_renamed((byte) 2, true);
                }
            } else if (!this.J_renamed.c_renamed()) {
                if (this.J_renamed.aq_renamed()) {
                    this.l_renamed.a_renamed().a_renamed(new com.oplus.camera.screen.b_renamed.o_renamed.a_renamed() { // from class: com.oplus.camera.ui.-$$Lambda$d_renamed$g00CsLAAaszO-zgZ2W_K888s7lg
                        @Override // com.oplus.camera.screen.b_renamed.o_renamed.a_renamed
                        public final void call(java.lang.Object[] objArr) throws android.content.res.Resources.NotFoundException {
                            this.f_renamed$0.f_renamed(objArr);
                        }
                    }, new com.oplus.camera.screen.b_renamed.o_renamed.a_renamed() { // from class: com.oplus.camera.ui.-$$Lambda$d_renamed$cPPw6xiAoSBKWnsy0T5nKm16tsI
                        @Override // com.oplus.camera.screen.b_renamed.o_renamed.a_renamed
                        public final void call(java.lang.Object[] objArr) {
                            this.f_renamed$0.e_renamed(objArr);
                        }
                    }, new com.oplus.camera.screen.b_renamed.o_renamed.a_renamed() { // from class: com.oplus.camera.ui.-$$Lambda$d_renamed$zx8FXW_UYVZPxISuTbJVrt65vTM
                        @Override // com.oplus.camera.screen.b_renamed.o_renamed.a_renamed
                        public final void call(java.lang.Object[] objArr) {
                            this.f_renamed$0.d_renamed(objArr);
                        }
                    });
                } else {
                    this.l_renamed.a_renamed().a_renamed(new com.oplus.camera.screen.b_renamed.o_renamed.a_renamed() { // from class: com.oplus.camera.ui.-$$Lambda$d_renamed$4FdB5WcoivTm7faltDqQ4ULKjC4
                        @Override // com.oplus.camera.screen.b_renamed.o_renamed.a_renamed
                        public final void call(java.lang.Object[] objArr) {
                            this.f_renamed$0.c_renamed(objArr);
                        }
                    }, new com.oplus.camera.screen.b_renamed.o_renamed.a_renamed() { // from class: com.oplus.camera.ui.-$$Lambda$d_renamed$nVy6BBaD4BIGUwL1UI0I9YMs70k
                        @Override // com.oplus.camera.screen.b_renamed.o_renamed.a_renamed
                        public final void call(java.lang.Object[] objArr) {
                            this.f_renamed$0.b_renamed(objArr);
                        }
                    }, new com.oplus.camera.screen.b_renamed.o_renamed.a_renamed() { // from class: com.oplus.camera.ui.-$$Lambda$d_renamed$0l0b2x_FP4Fteftjd9AAkRMD6ic
                        @Override // com.oplus.camera.screen.b_renamed.o_renamed.a_renamed
                        public final void call(java.lang.Object[] objArr) {
                            this.f_renamed$0.a_renamed(objArr);
                        }
                    });
                }
            }
        }
        if (this.A_renamed != null && (cameraUIListener2 = this.J_renamed) != null && cameraUIListener2.by_renamed() && this.bp_renamed) {
            com.oplus.camera.ui.preview.g_renamed gVar = this.A_renamed;
            gVar.a_renamed((android.view.View) gVar.ap_renamed(), this.J_renamed.bz_renamed(), true);
        }
        com.oplus.camera.ui.CameraUIListener cameraUIListener4 = this.J_renamed;
        if (cameraUIListener4 != null && cameraUIListener4.by_renamed() && this.br_renamed) {
            C_renamed(true, true);
        }
        if (this.aL_renamed != null && z_renamed && !dr_renamed() && !this.o_renamed && 1 != aX_renamed() && (cameraUIListener = this.J_renamed) != null && !cameraUIListener.l_renamed()) {
            z_renamed(true, true);
        }
        com.oplus.camera.ui.CameraUIListener cameraUIListener5 = this.J_renamed;
        if (cameraUIListener5 == null || !cameraUIListener5.bm_renamed() || dr_renamed()) {
            return;
        }
        i_renamed(true, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f_renamed(java.lang.Object[] objArr) throws android.content.res.Resources.NotFoundException {
        fi_renamed();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e_renamed(java.lang.Object[] objArr) {
        a_renamed(0, ((java.lang.Float) objArr[0]).floatValue(), ((java.lang.Float) objArr[1]).floatValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d_renamed(java.lang.Object[] objArr) {
        z_renamed(true, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c_renamed(java.lang.Object[] objArr) {
        Z_renamed(((java.lang.Integer) objArr[0]).intValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b_renamed(java.lang.Object[] objArr) {
        a_renamed(0, ((java.lang.Float) objArr[0]).floatValue(), ((java.lang.Float) objArr[1]).floatValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a_renamed(java.lang.Object[] objArr) {
        z_renamed(true, true);
    }

    private void Z_renamed(int i_renamed) {
        com.oplus.camera.ui.menu.levelcontrol.g_renamed gVar = this.ah_renamed;
        if (gVar == null || !gVar.isEffectMenuOpen()) {
            com.oplus.camera.ui.menu.levelcontrol.c_renamed cVar = this.ai_renamed;
            if (cVar == null || !cVar.isEffectMenuOpen()) {
                com.oplus.camera.ui.CameraUIListener cameraUIListener = this.J_renamed;
                if ((cameraUIListener == null || !cameraUIListener.ar_renamed()) && !j_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_HEADLINE_CONTROL_BY_MODE)) {
                    if (this.A_renamed.u_renamed() && this.K_renamed == 2) {
                        return;
                    }
                    com.oplus.camera.ui.CameraUIListener cameraUIListener2 = this.J_renamed;
                    if (cameraUIListener2 == null || !cameraUIListener2.as_renamed()) {
                        com.oplus.camera.ui.CameraUIListener cameraUIListener3 = this.J_renamed;
                        if ((cameraUIListener3 != null && cameraUIListener3.bG_renamed() && aA_renamed()) || 3 == this.K_renamed) {
                            return;
                        }
                        com.oplus.camera.ui.CameraUIListener cameraUIListener4 = this.J_renamed;
                        if ((cameraUIListener4 == null || !cameraUIListener4.bK_renamed()) && this.J_renamed != null) {
                            h_renamed(this.M_renamed, false);
                            a_renamed(0, i_renamed);
                        }
                    }
                }
            }
        }
    }

    private void fi_renamed() throws android.content.res.Resources.NotFoundException {
        com.oplus.camera.ui.menu.levelcontrol.g_renamed gVar;
        if ((this.J_renamed.at_renamed() && this.J_renamed.h_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_HEADLINE_CONTROL_BY_MODE)) || aA_renamed() || this.J_renamed.ar_renamed() || (gVar = this.ah_renamed) == null || gVar.isEffectMenuOpen()) {
            return;
        }
        if ((this.bq_renamed || !this.J_renamed.by_renamed()) && !this.J_renamed.bK_renamed()) {
            this.aJ_renamed.a_renamed(android.view.animation.AnimationUtils.loadAnimation(this.i_renamed, com.oplus.camera.R_renamed.anim.zoom_panel_level_in));
        }
    }

    private void fj_renamed() {
        com.oplus.camera.ui.preview.ae_renamed aeVar = this.D_renamed;
        if (aeVar == null || aeVar.h_renamed()) {
            return;
        }
        a_renamed((java.lang.Float) null, this.D_renamed.e_renamed(), this.D_renamed.f_renamed(), true);
    }

    public void B_renamed(boolean z_renamed, boolean z2) {
        if (z_renamed) {
            r_renamed(true);
        }
        this.R_renamed = -1;
        ag_renamed(this.O_renamed);
    }

    @Override // com.oplus.camera.ui.CameraUIInterface
    public void h_renamed(int i_renamed) {
        com.oplus.camera.ui.control.a_renamed aVar = this.z_renamed;
        if (aVar != null) {
            aVar.n_renamed(i_renamed);
        }
    }

    public void da_renamed() {
        if (bz_renamed()) {
            cy_renamed();
        }
        if (com.oplus.camera.util.Util.u_renamed()) {
            q_renamed();
        }
    }

    public void b_renamed(int i_renamed, java.lang.String str) {
        com.oplus.camera.ui.control.a_renamed aVar = this.z_renamed;
        if (aVar != null) {
            aVar.a_renamed(i_renamed, str);
        }
    }

    public void db_renamed() {
        if (this.J_renamed.aL_renamed() == 0) {
            this.J_renamed.a_renamed(false, false);
        }
    }

    public void al_renamed(boolean z_renamed) {
        g_renamed(4);
        b_renamed(4, z_renamed);
        f_renamed(8);
        a_renamed(8, 1);
        c_renamed(true, 0);
        c_renamed(false, false);
        a_renamed(true, false);
        f_renamed(false, false);
        d_renamed(8);
        c_renamed(false);
        v_renamed(false);
        P_renamed(false);
        if (A_renamed()) {
            s_renamed(false);
        } else {
            q_renamed(false);
        }
        com.oplus.camera.ui.menu.levelcontrol.c_renamed cVar = this.ai_renamed;
        if ((cVar != null && cVar.isMenuOpen()) || cX_renamed()) {
            b_renamed(false, true, false, false);
            h_renamed(false, false);
        } else {
            h_renamed(true, false);
        }
        j_renamed(true, false);
        f_renamed(17, true);
        f_renamed(20, true);
    }

    public void dc_renamed() {
        com.oplus.camera.ui.control.a_renamed aVar = this.z_renamed;
        if (aVar != null) {
            aVar.aa_renamed();
        }
    }

    public void dd_renamed() {
        com.oplus.camera.ui.control.a_renamed aVar = this.z_renamed;
        if (aVar != null) {
            aVar.ab_renamed();
        }
    }

    public void de_renamed() {
        if (this.A_renamed == null || R_renamed()) {
            return;
        }
        this.A_renamed.a_renamed();
    }

    public void df_renamed() {
        com.oplus.camera.ui.preview.g_renamed gVar = this.A_renamed;
        if (gVar != null) {
            gVar.c_renamed();
        }
    }

    @Override // com.oplus.camera.ui.CameraUIInterface
    public void ac_renamed() {
        com.oplus.camera.ui.preview.g_renamed gVar = this.A_renamed;
        if (gVar != null) {
            gVar.b_renamed();
        }
    }

    @Override // com.oplus.camera.ui.CameraUIInterface
    public void a_renamed(com.oplus.camera.u_renamed.a_renamed aVar) {
        com.oplus.camera.ui.preview.g_renamed gVar = this.A_renamed;
        if (gVar != null) {
            gVar.a_renamed(aVar);
        }
    }

    public void b_renamed(final com.oplus.camera.u_renamed.a_renamed aVar) {
        com.oplus.camera.e_renamed.a_renamed("CameraUIManager", "executeSuperTextFrameColorAnimation");
        if (this.A_renamed != null) {
            com.oplus.camera.e_renamed.a_renamed("CameraUIManager", this.cm_renamed, "CameraUIManager");
            this.cm_renamed.post(new java.lang.Runnable() { // from class: com.oplus.camera.ui.d_renamed.46
                @Override // java.lang.Runnable
                public void run() {
                    com.oplus.camera.e_renamed.a_renamed("CameraUIManager", "executeSuperTextFrameColorAnimation, in_renamed handler");
                    com.oplus.camera.ui.d_renamed.this.A_renamed.b_renamed(aVar);
                }
            });
        }
    }

    @Override // com.oplus.camera.ui.CameraUIInterface
    public void b_renamed(int... iArr) {
        com.oplus.camera.ui.control.a_renamed aVar = this.z_renamed;
        if (aVar != null) {
            aVar.a_renamed(iArr);
        }
    }

    public void d_renamed(int... iArr) {
        com.oplus.camera.ui.control.a_renamed aVar = this.z_renamed;
        if (aVar != null) {
            aVar.b_renamed(iArr);
        }
    }

    public void i_renamed(int i_renamed, int i2) {
        com.oplus.camera.ui.modepanel.p_renamed pVar = this.bd_renamed;
        if (pVar != null) {
            pVar.a_renamed(i_renamed, i2);
        }
    }

    @Override // com.oplus.camera.ui.CameraUIInterface
    public void n_renamed(int i_renamed) {
        com.oplus.camera.ui.modepanel.p_renamed pVar = this.bd_renamed;
        if (pVar != null) {
            pVar.g_renamed(i_renamed);
        }
    }

    @Override // com.oplus.camera.ui.CameraUIInterface
    public void ah_renamed() throws android.content.res.Resources.NotFoundException {
        if (this.z_renamed != null) {
            android.view.View viewFindViewById = this.i_renamed.findViewById(com.oplus.camera.R_renamed.id_renamed.movie_mode_back);
            android.view.View viewFindViewById2 = this.i_renamed.findViewById(com.oplus.camera.R_renamed.id_renamed.movie_menu_id);
            android.view.View viewFindViewById3 = this.i_renamed.findViewById(com.oplus.camera.R_renamed.id_renamed.switch_camera_bar);
            if (!com.oplus.camera.util.Util.u_renamed()) {
                a_renamed(0, 180L, 0L, (android.animation.TimeInterpolator) null, (android.animation.Animator.AnimatorListener) null);
            }
            com.oplus.camera.filmvideomode.b_renamed.a_renamed(true);
            com.oplus.camera.filmvideomode.b_renamed.a_renamed(this.Z_renamed, bD_renamed(), this.z_renamed.s_renamed(), this.z_renamed.ar_renamed(), viewFindViewById, viewFindViewById2, viewFindViewById3, this.L_renamed);
        }
    }

    @Override // com.oplus.camera.ui.CameraUIInterface
    public void ai_renamed() throws android.content.res.Resources.NotFoundException {
        if (this.z_renamed != null) {
            android.view.View viewFindViewById = this.i_renamed.findViewById(com.oplus.camera.R_renamed.id_renamed.movie_mode_back);
            android.view.View viewFindViewById2 = this.i_renamed.findViewById(com.oplus.camera.R_renamed.id_renamed.movie_menu_id);
            android.view.View viewFindViewById3 = this.i_renamed.findViewById(com.oplus.camera.R_renamed.id_renamed.switch_camera_bar);
            a_renamed(4, 180L, 0L, (android.animation.TimeInterpolator) null, (android.animation.Animator.AnimatorListener) null);
            com.oplus.camera.filmvideomode.b_renamed.a_renamed(this.Z_renamed, bD_renamed(), this.z_renamed.s_renamed(), this.z_renamed.ar_renamed(), this.bd_renamed, this.z_renamed.as_renamed(), viewFindViewById, viewFindViewById2, viewFindViewById3);
        }
    }

    @Override // com.oplus.camera.ui.CameraUIInterface
    public void ak_renamed() {
        aS_renamed(true);
        aR_renamed(true);
        if (this.ac_renamed != null && this.i_renamed != null) {
            com.oplus.camera.ui.a_renamed.a_renamed.HintManager_2 interfaceC0122a = this.ad_renamed;
            if (interfaceC0122a != null) {
                interfaceC0122a.a_renamed();
                this.ad_renamed = null;
            }
            this.ad_renamed = this.ac_renamed.a_renamed(this.i_renamed.getApplication().getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.xpan_mode_hint_extra_margin), 0);
        }
        com.oplus.camera.ui.modepanel.p_renamed pVar = this.bd_renamed;
        if (pVar != null) {
            pVar.b_renamed(true);
        }
    }

    @Override // com.oplus.camera.ui.CameraUIInterface
    public void aj_renamed() {
        aS_renamed(false);
        aR_renamed(false);
        com.oplus.camera.ui.a_renamed.a_renamed.HintManager_2 interfaceC0122a = this.ad_renamed;
        if (interfaceC0122a != null) {
            interfaceC0122a.a_renamed();
            this.ad_renamed = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: aG_renamed, reason: merged with bridge method [inline-methods] */
    public void aS_renamed(final boolean z_renamed) {
        if (this.z_renamed == null) {
            com.oplus.camera.e_renamed.b_renamed("CameraUIManager", "updateXpanThumbTranslation, no control ui");
            return;
        }
        float f_renamed = 0.0f;
        if (z_renamed) {
            f_renamed = androidx.core.f_renamed.f_renamed.a_renamed(java.util.Locale.getDefault()) == 0 ? this.m_renamed : this.m_renamed * (-1);
        }
        com.oplus.camera.ui.control.ThumbImageView thumbImageViewS = this.z_renamed.s_renamed();
        if (thumbImageViewS != null) {
            if (thumbImageViewS.getTranslationX() != f_renamed) {
                thumbImageViewS.animate().translationX(f_renamed).setDuration(200L).start();
                return;
            } else {
                com.oplus.camera.e_renamed.a_renamed("CameraUIManager", "updateXpanThumbTranslation, no need translation");
                return;
            }
        }
        com.oplus.camera.e_renamed.b_renamed("CameraUIManager", "updateXpanThumbTranslation, thumb view is_renamed not ready yet");
        if (dX_renamed()) {
            this.cm_renamed.post(new java.lang.Runnable() { // from class: com.oplus.camera.ui.-$$Lambda$d_renamed$WlCfc1NCXjHuMmC4k4RXkElpCos
                @Override // java.lang.Runnable
                public final void run() {
                    this.f_renamed$0.aS_renamed(z_renamed);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: aH_renamed, reason: merged with bridge method [inline-methods] */
    public void aR_renamed(final boolean z_renamed) {
        com.oplus.camera.screen.g_renamed gVar;
        if (this.z_renamed == null || this.J_renamed == null) {
            return;
        }
        int iB = 270;
        if (!z_renamed && (gVar = this.l_renamed) != null) {
            iB = gVar.b_renamed();
        }
        com.oplus.camera.ui.control.ThumbImageView thumbImageViewS = this.z_renamed.s_renamed();
        if (thumbImageViewS != null) {
            thumbImageViewS.a_renamed(iB, true);
        } else if (dX_renamed()) {
            this.cm_renamed.post(new java.lang.Runnable() { // from class: com.oplus.camera.ui.-$$Lambda$d_renamed$Kj3OXT1-Giok7yAJ_jnNTypEFeg
                @Override // java.lang.Runnable
                public final void run() {
                    this.f_renamed$0.aR_renamed(z_renamed);
                }
            });
        }
    }

    @Override // com.oplus.camera.ui.CameraUIInterface
    public void al_renamed() {
        int iEX = eX_renamed();
        com.oplus.camera.ui.a_renamed.a_renamed aVar = this.ac_renamed;
        if (aVar != null) {
            aVar.c_renamed(iEX);
        }
    }

    public void a_renamed(com.oplus.camera.ui.preview.a_renamed.l_renamed.a_renamed aVar) {
        this.ah_renamed.setFilterCategory(aVar);
    }

    public void am_renamed(boolean z_renamed) {
        this.z_renamed.b_renamed(z_renamed);
    }

    public void an_renamed(boolean z_renamed) {
        this.z_renamed.c_renamed(z_renamed);
    }

    public void ao_renamed(boolean z_renamed) {
        this.ah_renamed.e_renamed(z_renamed);
    }

    @Override // com.oplus.camera.ui.menu.setting.o_renamed.a_renamed
    public java.util.ArrayList<java.lang.String> dg_renamed() {
        com.oplus.camera.ui.menu.setting.o_renamed oVar = this.H_renamed;
        if (oVar != null) {
            return oVar.K_renamed();
        }
        return new java.util.ArrayList<>();
    }

    @Override // com.oplus.camera.ui.menu.setting.o_renamed.a_renamed
    public void ap_renamed(boolean z_renamed) {
        com.oplus.camera.ui.menu.setting.o_renamed oVar = this.H_renamed;
        if (oVar != null) {
            oVar.b_renamed(z_renamed, true);
        }
    }

    @Override // com.oplus.camera.ui.menu.setting.o_renamed.a_renamed
    public void a_renamed(boolean z_renamed, boolean z2, int i_renamed) {
        com.oplus.camera.ui.menu.setting.o_renamed oVar = this.H_renamed;
        if (oVar != null) {
            oVar.b_renamed(z_renamed, z2, i_renamed);
            this.H_renamed.b_renamed(z_renamed, false);
        }
    }

    public void dh_renamed() {
        com.oplus.camera.ui.CameraUIListener cameraUIListener = this.J_renamed;
        if (cameraUIListener == null || this.p_renamed) {
            return;
        }
        cameraUIListener.W_renamed();
    }

    public void aq_renamed(boolean z_renamed) {
        if (z_renamed) {
            android.view.ViewStub viewStub = (android.view.ViewStub) this.i_renamed.findViewById(com.oplus.camera.R_renamed.id_renamed.statement_background_stub);
            if (viewStub != null) {
                viewStub.inflate();
                this.ab_renamed = this.i_renamed.findViewById(com.oplus.camera.R_renamed.id_renamed.statement_background_container);
            }
            android.view.View view = this.ab_renamed;
            if (view != null) {
                view.setBackgroundColor(com.oplus.camera.util.Util.ap_renamed() ? -16777216 : -1);
                return;
            }
            return;
        }
        android.view.View view2 = this.ab_renamed;
        if (view2 != null) {
            view2.setVisibility(8);
        }
    }

    @Override // com.oplus.camera.ui.menu.setting.o_renamed.a_renamed
    public void m_renamed(java.lang.String str) {
        com.oplus.camera.ui.menu.setting.o_renamed oVar = this.H_renamed;
        if (oVar != null) {
            oVar.d_renamed(str);
        }
    }

    @Override // com.oplus.camera.ui.menu.setting.o_renamed.a_renamed
    public void n_renamed(java.lang.String str) {
        com.oplus.camera.ui.menu.setting.o_renamed oVar = this.H_renamed;
        if (oVar != null) {
            oVar.e_renamed(str);
        }
    }

    public void H_renamed(int i_renamed) {
        this.B_renamed.edit().putInt(com.oplus.camera.ui.CameraUIInterface.KEY_FACE_BEAUTY_LAST_TAB_INDEX, i_renamed).apply();
    }

    public void ar_renamed(boolean z_renamed) {
        com.oplus.camera.ui.preview.b_renamed bVar = this.bk_renamed;
        if (bVar == null || 1 != bVar.a_renamed()) {
            if (com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_AI_SCENE_ULTRA_WIDE_HINT) && N_renamed(this.O_renamed)) {
                ag_renamed(this.Q_renamed);
                return;
            }
            return;
        }
        if (!z_renamed) {
            this.cm_renamed.post(new java.lang.Runnable() { // from class: com.oplus.camera.ui.-$$Lambda$d_renamed$HLY4M2Tg0ZnJS0EECYu5N09rA6c
                @Override // java.lang.Runnable
                public final void run() {
                    this.f_renamed$0.gB_renamed();
                }
            });
        } else {
            ag_renamed(this.Q_renamed);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void gB_renamed() {
        l_renamed(true);
    }

    public void di_renamed() {
        this.w_renamed = true;
    }

    public void dj_renamed() {
        this.ac_renamed.a_renamed(com.oplus.camera.R_renamed.string.hint_ratio_4_3);
        this.ac_renamed.a_renamed(com.oplus.camera.R_renamed.string.hint_ratio_full);
        this.ac_renamed.a_renamed(com.oplus.camera.R_renamed.string.hint_ratio_14_15);
        this.ac_renamed.a_renamed(com.oplus.camera.R_renamed.string.hint_ratio_16_9);
        this.ac_renamed.a_renamed(com.oplus.camera.R_renamed.string.hint_ratio_1_1);
    }

    public void as_renamed(boolean z_renamed) {
        this.x_renamed = z_renamed;
    }

    public void dk_renamed() {
        java.lang.String strAF;
        com.oplus.camera.ui.menu.setting.f_renamed fVar;
        if (this.cy_renamed.g_renamed()) {
            com.oplus.camera.ui.menu.levelcontrol.c_renamed cVar = this.ai_renamed;
            if (cVar != null && !cVar.isMenuOpen() && (fVar = this.I_renamed) != null && fVar.c_renamed()) {
                this.I_renamed.a_renamed(8);
            }
            strAF = com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_BLUR_MENU;
        } else if (this.cy_renamed.h_renamed()) {
            strAF = com.oplus.camera.ui.CameraUIInterface.KEY_TILT_SHIFT_BLUR_MENU;
        } else {
            strAF = this.cy_renamed.b_renamed() ? this.J_renamed.aF_renamed() : "";
        }
        if (s_renamed(strAF)) {
            com.oplus.camera.ui.menu.setting.q_renamed qVar = this.aK_renamed;
            if (qVar instanceof com.oplus.camera.ui.menu.levelcontrol.c_renamed) {
                ((com.oplus.camera.ui.menu.levelcontrol.c_renamed) qVar).showMenuPanelWithoutAnim(strAF, false, true);
            }
        }
    }

    public void d_renamed(android.util.Size size) {
        com.oplus.camera.ui.preview.g_renamed gVar = this.A_renamed;
        if (gVar != null) {
            gVar.a_renamed(size);
            this.cm_renamed.postDelayed(new java.lang.Runnable() { // from class: com.oplus.camera.ui.d_renamed.47
                @Override // java.lang.Runnable
                public void run() {
                    com.oplus.camera.ui.preview.h_renamed hVarC = com.oplus.camera.ui.d_renamed.this.c_renamed();
                    if (hVarC != null) {
                        hVarC.w_renamed();
                        hVarC.t_renamed();
                    } else {
                        com.oplus.camera.e_renamed.f_renamed("CameraUIManager", "showRearMirrorBlurAnim, screenNail is_renamed null");
                    }
                }
            }, 400L);
        }
    }

    @Override // com.oplus.camera.ui.CameraUIInterface
    public boolean be_renamed() {
        if (this.J_renamed.h_renamed(com.oplus.camera.aps.config.CameraFunction.OUT_PREVIEW_ENABLE) && ej_renamed().n_renamed()) {
            return this.bz_renamed.a_renamed(this.B_renamed);
        }
        return false;
    }

    public void dl_renamed() {
        com.oplus.camera.ui.OutScreenButtonBoxView outScreenButtonBoxView = this.bz_renamed;
        if (outScreenButtonBoxView != null) {
            outScreenButtonBoxView.a_renamed();
        }
        this.j_renamed.c_renamed();
    }

    public void dm_renamed() {
        if (this.J_renamed.h_renamed(com.oplus.camera.aps.config.CameraFunction.OUT_PREVIEW_ENABLE) && ej_renamed().n_renamed()) {
            this.j_renamed.a_renamed(this.i_renamed, this.Z_renamed);
        }
    }

    public boolean c_renamed(android.view.MotionEvent motionEvent) {
        return motionEvent != null && motionEvent.getDownTime() == this.cb_renamed;
    }

    /* compiled from: CameraUIManager.java */
    private class a_renamed implements com.oplus.camera.ui.modepanel.n_renamed.a_renamed {
        private a_renamed() {
        }

        @Override // com.oplus.camera.ui.modepanel.n_renamed.a_renamed
        public void a_renamed() {
            com.oplus.camera.ui.d_renamed.this.J_renamed.l_renamed((java.lang.String) null);
        }
    }

    private void fk_renamed() {
        com.oplus.camera.screen.g_renamed gVar;
        if (com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_PI_AI)) {
            this.aH_renamed = new com.oplus.camera.ui.preview.u_renamed(this.i_renamed, this.Z_renamed, this.B_renamed);
        } else {
            this.aH_renamed = new com.oplus.camera.ui.preview.t_renamed(this.i_renamed, this.Z_renamed, this.B_renamed);
        }
        this.ac_renamed.a_renamed(this.aH_renamed);
        this.aH_renamed.a_renamed(this.ci_renamed);
        this.aH_renamed.a_renamed(this.cl_renamed);
        this.aH_renamed.a_renamed(this.i_renamed.getApplication().getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.camera_up_hint_margin_top) - this.aH_renamed.a_renamed());
        if (com.oplus.camera.util.Util.t_renamed() && (gVar = this.l_renamed) != null) {
            this.aH_renamed.h_renamed(gVar.a_renamed().j_renamed());
        }
        this.S_renamed = this.aH_renamed.a_renamed();
    }

    private void fl_renamed() throws android.content.res.Resources.NotFoundException {
        if (this.aJ_renamed == null) {
            this.aJ_renamed = new com.oplus.camera.ui.modepanel.m_renamed(this.i_renamed, this.z_renamed.U_renamed());
            this.aJ_renamed.a_renamed(new com.oplus.camera.ui.d_renamed.a_renamed());
            this.aJ_renamed.a_renamed(false);
            this.aJ_renamed.a_renamed(aX_renamed(), ei_renamed());
        }
    }

    public void o_renamed(java.lang.String str) {
        if (this.aJ_renamed != null) {
            if (!(com.oplus.camera.util.Util.u_renamed() && dY_renamed()) && dY_renamed()) {
                return;
            }
            this.aJ_renamed.a_renamed(str);
        }
    }

    public java.lang.String dn_renamed() {
        com.oplus.camera.ui.modepanel.m_renamed mVar = this.aJ_renamed;
        return mVar != null ? mVar.a_renamed() : "";
    }

    /* renamed from: do, reason: not valid java name */
    public void m113do() {
        if (this.aJ_renamed == null || dY_renamed() || dE_renamed()) {
            return;
        }
        this.aJ_renamed.b_renamed();
    }

    public void b_renamed(boolean z_renamed, int i_renamed) {
        com.oplus.camera.ui.modepanel.m_renamed mVar;
        boolean z2 = 4 == aX_renamed();
        if ((dY_renamed() && !z2) || dX_renamed() || dE_renamed() || (mVar = this.aJ_renamed) == null) {
            return;
        }
        mVar.a_renamed(z_renamed, i_renamed);
    }

    public void I_renamed(int i_renamed) {
        com.oplus.camera.ui.control.a_renamed aVar = this.z_renamed;
        if (aVar != null) {
            aVar.e_renamed(i_renamed);
        }
    }

    public void a_renamed(android.view.animation.Animation animation) throws android.content.res.Resources.NotFoundException {
        if (this.aJ_renamed == null || dY_renamed()) {
            return;
        }
        this.aJ_renamed.a_renamed(animation);
    }

    public void c_renamed(boolean z_renamed, int i_renamed) {
        com.oplus.camera.ui.modepanel.m_renamed mVar = this.aJ_renamed;
        if (mVar != null) {
            mVar.b_renamed(z_renamed, i_renamed);
        }
    }

    @Override // com.oplus.camera.ui.CameraUIInterface
    public void a_renamed(boolean z_renamed) {
        com.oplus.camera.ui.modepanel.m_renamed mVar = this.aJ_renamed;
        if (mVar != null) {
            mVar.b_renamed(z_renamed);
        }
    }

    public boolean dp_renamed() {
        com.oplus.camera.ui.modepanel.m_renamed mVar = this.aJ_renamed;
        if (mVar != null) {
            return mVar.d_renamed();
        }
        return false;
    }

    public boolean dq_renamed() {
        com.oplus.camera.ui.modepanel.m_renamed mVar = this.aJ_renamed;
        return mVar != null && mVar.e_renamed();
    }

    public void at_renamed(boolean z_renamed) {
        com.oplus.camera.ui.modepanel.p_renamed pVar = this.bd_renamed;
        if (pVar != null) {
            pVar.a_renamed(z_renamed);
        }
    }

    public void J_renamed(int i_renamed) {
        com.oplus.camera.ui.modepanel.p_renamed pVar = this.bd_renamed;
        if (pVar != null) {
            pVar.b_renamed(i_renamed);
        }
    }

    public void K_renamed(int i_renamed) {
        com.oplus.camera.ui.modepanel.p_renamed pVar = this.bd_renamed;
        if (pVar != null) {
            pVar.c_renamed(i_renamed);
        }
    }

    @Override // com.oplus.camera.ui.CameraUIInterface
    public void p_renamed(boolean z_renamed) {
        com.oplus.camera.ui.menu.levelcontrol.g_renamed gVar;
        com.oplus.camera.e_renamed.a_renamed("CameraUIManager", "hideAllCameraView");
        if (z_renamed && (gVar = this.ah_renamed) != null) {
            gVar.f_renamed(false);
        }
        this.H_renamed.c_renamed(false);
        this.H_renamed.a_renamed(false, false);
        L_renamed(false);
        this.I_renamed.a_renamed(false, false);
        q_renamed(false);
        j_renamed(false, false);
        c_renamed(false);
        v_renamed(false);
        this.z_renamed.d_renamed(false);
        if (this.K_renamed != 1) {
            this.z_renamed.i_renamed(8);
            this.z_renamed.k_renamed(false);
        }
        this.z_renamed.h_renamed(false, false);
    }

    @Override // com.oplus.camera.ui.CameraUIInterface
    public void H_renamed() {
        au_renamed(false);
        d_renamed(true, false);
    }

    public void au_renamed(boolean z_renamed) {
        com.oplus.camera.ui.CameraUIListener cameraUIListener;
        if (this.K_renamed != 3 || 1 != ej_renamed().j_renamed() || !z_renamed || !aw_renamed()) {
            this.H_renamed.m_renamed();
            this.I_renamed.m_renamed();
        }
        r_renamed(true);
        if (!z_renamed && (cameraUIListener = this.J_renamed) != null) {
            this.z_renamed.a_renamed(true, cameraUIListener != null && cameraUIListener.av_renamed(), this.J_renamed.by_renamed());
        }
        if (this.K_renamed != 1) {
            this.z_renamed.i_renamed(0);
            this.z_renamed.k_renamed(true);
        }
        if (this.ah_renamed.isEffectMenuOpen()) {
            com.oplus.camera.e_renamed.a_renamed("CameraUIManager", "showAllCameraView, mEffectLevelMenu is_renamed open, hideRollGLSurfaceView");
            y_renamed(0);
        }
    }

    @Override // com.oplus.camera.ui.preview.g_renamed.b_renamed
    public boolean dr_renamed() {
        com.oplus.camera.ui.CameraUIListener cameraUIListener = this.J_renamed;
        if (cameraUIListener != null) {
            return cameraUIListener.c_renamed();
        }
        return false;
    }

    @Override // com.oplus.camera.ui.preview.g_renamed.b_renamed
    public void a_renamed(int i_renamed, int i2, boolean z_renamed) {
        com.oplus.camera.ui.CameraUIListener cameraUIListener = this.J_renamed;
        if (cameraUIListener != null) {
            cameraUIListener.b_renamed(i_renamed, i2);
        }
        if (!com.oplus.camera.util.Util.u_renamed() || z_renamed) {
            j_renamed(i_renamed, i2);
        }
    }

    public void j_renamed(int i_renamed, int i2) {
        if (this.l_renamed != null && 3 == aX_renamed()) {
            if (-1 == i_renamed || -1 == i2) {
                if (this.A_renamed == null) {
                    return;
                }
                android.util.Size sizeBG = bG_renamed();
                int width = sizeBG.getWidth();
                i2 = sizeBG.getHeight();
                i_renamed = width;
            }
            android.graphics.Rect rectK = k_renamed(i_renamed, i2);
            com.oplus.camera.ui.inverse.e_renamed.INS.setMaskSplitScreenYOffset(this.i_renamed, (rectK.top + rectK.bottom) / 2.0f);
        }
        if (this.l_renamed != null && this.i_renamed != null) {
            com.oplus.camera.ui.inverse.e_renamed.INS.setMaskRadius(this.i_renamed, a_renamed(this.M_renamed, this.l_renamed.a_renamed()));
            return;
        }
        com.oplus.camera.e_renamed.f_renamed("CameraUIManager", "updateInvserseMaskViewUI, mScreenModeManager: " + this.l_renamed + ", mActivity: " + this.i_renamed);
    }

    public int a_renamed(int i_renamed, com.oplus.camera.screen.b_renamed.a_renamed aVar) {
        if (3 == aVar.j_renamed()) {
            if (i_renamed == 0) {
                return this.i_renamed.getApplication().getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.inverse_mask_radius_split_screen_4_3);
            }
            return this.i_renamed.getApplication().getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.inverse_mask_radius_split_screen);
        }
        if (1 == aVar.j_renamed()) {
            if (1 == i_renamed) {
                return this.i_renamed.getApplication().getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.inverse_mask_radius_16_9);
            }
            return this.i_renamed.getApplication().getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.inverse_mask_radius);
        }
        if (4 == aVar.j_renamed()) {
            return this.i_renamed.getApplication().getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.inverse_mask_radius_rack_screen);
        }
        return this.i_renamed.getApplication().getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.inverse_mask_radius);
    }

    @Override // com.oplus.camera.ui.preview.g_renamed.b_renamed
    public java.lang.String ds_renamed() {
        com.oplus.camera.ui.CameraUIListener cameraUIListener = this.J_renamed;
        if (cameraUIListener != null) {
            return cameraUIListener.aw_renamed();
        }
        return null;
    }

    @Override // com.oplus.camera.ui.preview.g_renamed.b_renamed
    public void dt_renamed() {
        com.oplus.camera.ui.CameraUIListener cameraUIListener = this.J_renamed;
        if (cameraUIListener != null) {
            cameraUIListener.ay_renamed();
        }
    }

    public void L_renamed(int i_renamed) {
        if (cp_renamed()) {
            if (!ad_renamed(i_renamed)) {
                fn_renamed();
            } else if (dv_renamed()) {
                fo_renamed();
            }
            if (!ae_renamed(i_renamed)) {
                fp_renamed();
            } else if (dw_renamed()) {
                fq_renamed();
            }
            if (ac_renamed(i_renamed)) {
                aj_renamed(true);
                if (aa_renamed(i_renamed)) {
                    fu_renamed();
                } else if (!ab_renamed(i_renamed)) {
                    if (this.u_renamed) {
                        if (fA_renamed()) {
                            fw_renamed();
                        } else {
                            fv_renamed();
                        }
                    } else if (fB_renamed()) {
                        fx_renamed();
                    }
                }
            } else if (18 == i_renamed) {
                ft_renamed();
            } else {
                fs_renamed();
            }
            if (!af_renamed(i_renamed)) {
                fy_renamed();
            } else if (dy_renamed()) {
                fz_renamed();
            }
        }
    }

    public void du_renamed() {
        fm_renamed();
        if (cp_renamed()) {
            if (dv_renamed()) {
                fo_renamed();
            }
            if (dw_renamed()) {
                fq_renamed();
            }
            if (this.u_renamed) {
                if (fA_renamed()) {
                    fw_renamed();
                } else {
                    fv_renamed();
                }
            } else if (fB_renamed()) {
                fx_renamed();
            }
            if (dy_renamed()) {
                fz_renamed();
            }
        }
    }

    private void fm_renamed() {
        this.bl_renamed = true;
        this.bm_renamed = true;
        this.bn_renamed = true;
        this.R_renamed = -1;
        l_renamed(true);
    }

    private void fn_renamed() {
        b_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_FLASH_MODE, this.i_renamed.getString(com.oplus.camera.R_renamed.string.camera_flash_mode_default_value), "off");
    }

    private void fo_renamed() {
        com.oplus.camera.ui.CameraUIListener cameraUIListener = this.J_renamed;
        a_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_FLASH_MODE, this.i_renamed.getString(com.oplus.camera.R_renamed.string.camera_flash_mode_default_value), cameraUIListener != null ? cameraUIListener.aT_renamed() : true);
    }

    private void fp_renamed() {
        com.oplus.camera.ui.CameraUIListener cameraUIListener = this.J_renamed;
        if (cameraUIListener != null) {
            b_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_CAMERA_HDR_MODE, com.oplus.camera.aps.config.CameraConfig.getOptionKeyDefaultValue(com.oplus.camera.ui.CameraUIInterface.KEY_CAMERA_HDR_MODE, cameraUIListener.G_renamed()), "off");
        }
    }

    private void fq_renamed() {
        com.oplus.camera.ui.CameraUIListener cameraUIListener = this.J_renamed;
        if (cameraUIListener != null) {
            a_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_CAMERA_HDR_MODE, com.oplus.camera.aps.config.CameraConfig.getOptionKeyDefaultValue(com.oplus.camera.ui.CameraUIInterface.KEY_CAMERA_HDR_MODE, cameraUIListener.G_renamed()), true);
        }
    }

    private java.lang.String fr_renamed() {
        return com.oplus.camera.entry.b_renamed.b_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_COMMON_CUSTOM_BEAUTY[0], this.K_renamed);
    }

    private void fs_renamed() {
        if (this.u_renamed) {
            if (fA_renamed()) {
                fw_renamed();
            } else {
                fv_renamed();
            }
        }
        if (!fB_renamed() || this.aL_renamed.isEnabled()) {
            java.lang.String strFr = fr_renamed();
            java.lang.String strP = p_renamed(strFr);
            int i_renamed = this.B_renamed.getInt(strFr, 0);
            this.u_renamed = false;
            android.content.SharedPreferences.Editor editorEdit = this.B_renamed.edit();
            editorEdit.putInt(strFr, 0);
            editorEdit.putInt(strP, i_renamed);
            editorEdit.apply();
            this.i_renamed.runOnUiThread(new java.lang.Runnable() { // from class: com.oplus.camera.ui.d_renamed.48
                @Override // java.lang.Runnable
                public void run() {
                    if (com.oplus.camera.ui.d_renamed.this.J_renamed != null) {
                        com.oplus.camera.ui.d_renamed.this.i_renamed(0, false);
                        com.oplus.camera.ui.d_renamed.this.J_renamed.onFaceBeautyItemChange(0);
                    }
                }
            });
            com.oplus.camera.e_renamed.b_renamed("CameraUIManager", "disableFaceBeautyByAiScene, nowIndex: " + i_renamed);
        }
    }

    private void ft_renamed() {
        if (this.u_renamed) {
            if (fA_renamed()) {
                fw_renamed();
            } else {
                fv_renamed();
            }
        }
        if (fB_renamed()) {
            return;
        }
        java.lang.String strFr = fr_renamed();
        java.lang.String strP = p_renamed(strFr);
        int i_renamed = this.B_renamed.getInt(strFr, 0);
        this.u_renamed = false;
        android.content.SharedPreferences.Editor editorEdit = this.B_renamed.edit();
        editorEdit.putInt(strFr, 0);
        editorEdit.putInt(strP, i_renamed);
        editorEdit.apply();
        this.i_renamed.runOnUiThread(new java.lang.Runnable() { // from class: com.oplus.camera.ui.d_renamed.49
            @Override // java.lang.Runnable
            public void run() {
                if (com.oplus.camera.ui.d_renamed.this.J_renamed != null) {
                    com.oplus.camera.ui.d_renamed.this.J_renamed.onFaceBeautyItemChange(0);
                }
            }
        });
        aj_renamed(false);
        com.oplus.camera.e_renamed.b_renamed("CameraUIManager", "disableTabFaceViewByAiScene, nowIndex: " + i_renamed);
    }

    private void fu_renamed() {
        java.lang.String strFr = fr_renamed();
        java.lang.String strP = p_renamed(strFr);
        int i_renamed = this.B_renamed.getInt(strFr, 0);
        int i2 = this.B_renamed.getInt(strP, Integer.MIN_VALUE);
        this.u_renamed = true;
        final int i3 = (Integer.MIN_VALUE == i2 || i2 == 0) ? 40 : i2;
        android.content.SharedPreferences.Editor editorEdit = this.B_renamed.edit();
        if (Integer.MIN_VALUE == i2) {
            editorEdit.putInt(strP, i_renamed);
        }
        editorEdit.putInt(strFr, i3);
        editorEdit.apply();
        this.i_renamed.runOnUiThread(new java.lang.Runnable() { // from class: com.oplus.camera.ui.d_renamed.50
            @Override // java.lang.Runnable
            public void run() {
                com.oplus.camera.ui.d_renamed.this.i_renamed(i3, true);
                if (com.oplus.camera.ui.d_renamed.this.J_renamed != null) {
                    com.oplus.camera.ui.d_renamed.this.J_renamed.onFaceBeautyItemValueChange(0, i3, false);
                    if (i3 != 0) {
                        com.oplus.camera.ui.d_renamed.this.J_renamed.onFaceBeautyItemChange(102);
                    }
                }
            }
        });
        com.oplus.camera.e_renamed.b_renamed("CameraUIManager", "openFaceBeautyByAIScene, nowValueIndex: " + i_renamed + ", recordDisableValue: " + i2 + ", valueIndex: " + i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fv_renamed() {
        java.lang.String strP = p_renamed(fr_renamed());
        android.content.SharedPreferences.Editor editorEdit = this.B_renamed.edit();
        editorEdit.remove(strP);
        editorEdit.apply();
    }

    private void fw_renamed() {
        java.lang.String strFr = fr_renamed();
        java.lang.String strP = p_renamed(strFr);
        android.content.SharedPreferences.Editor editorEdit = this.B_renamed.edit();
        editorEdit.remove(strP);
        editorEdit.putInt(strFr, 0);
        editorEdit.apply();
        this.i_renamed.runOnUiThread(new java.lang.Runnable() { // from class: com.oplus.camera.ui.d_renamed.51
            @Override // java.lang.Runnable
            public void run() {
                if (com.oplus.camera.ui.d_renamed.this.K_renamed() && com.oplus.camera.ui.d_renamed.this.ah_renamed != null && !com.oplus.camera.ui.d_renamed.this.ah_renamed.isEffectMenuOpen()) {
                    com.oplus.camera.ui.d_renamed.this.a_renamed(true, true, true, true);
                }
                com.oplus.camera.ui.d_renamed.this.fg_renamed();
                if (com.oplus.camera.ui.d_renamed.this.J_renamed != null) {
                    com.oplus.camera.ui.d_renamed.this.J_renamed.onFaceBeautyItemChange(0);
                }
                if (com.oplus.camera.ui.d_renamed.this.fB_renamed()) {
                    com.oplus.camera.ui.d_renamed.this.aL_renamed.setEnabled(false);
                }
            }
        });
        com.oplus.camera.e_renamed.b_renamed("CameraUIManager", "setBeautyToOpenBeforeByAIScene");
    }

    private void fx_renamed() {
        java.lang.String strFr = fr_renamed();
        java.lang.String strP = p_renamed(strFr);
        final int i_renamed = this.B_renamed.getInt(strP, 0);
        android.content.SharedPreferences.Editor editorEdit = this.B_renamed.edit();
        if (i_renamed != 0) {
            editorEdit.putInt(strFr, i_renamed);
        }
        editorEdit.remove(strP);
        editorEdit.apply();
        this.i_renamed.runOnUiThread(new java.lang.Runnable() { // from class: com.oplus.camera.ui.d_renamed.52
            @Override // java.lang.Runnable
            public void run() {
                com.oplus.camera.ui.d_renamed.this.i_renamed(i_renamed, true);
                if (com.oplus.camera.ui.d_renamed.this.J_renamed != null) {
                    com.oplus.camera.ui.d_renamed.this.J_renamed.onFaceBeautyItemValueChange(0, i_renamed, false);
                    if (i_renamed != 0) {
                        com.oplus.camera.ui.d_renamed.this.J_renamed.onFaceBeautyItemChange(102);
                    }
                }
            }
        });
        com.oplus.camera.e_renamed.b_renamed("CameraUIManager", "openFaceBeautyByAIScene, lastValueIndex: " + i_renamed);
    }

    private void fy_renamed() {
        java.lang.String strP = p_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_PHOTO_HIGH_RESOLUTION);
        java.lang.String strP2 = p_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_HIGH_PICTURE_SIZE);
        if (q_renamed(strP)) {
            return;
        }
        final java.lang.String string = this.B_renamed.getString(com.oplus.camera.ui.CameraUIInterface.KEY_PHOTO_HIGH_RESOLUTION, "standard");
        boolean z_renamed = this.B_renamed.getBoolean(com.oplus.camera.ui.CameraUIInterface.KEY_HIGH_PICTURE_SIZE, false);
        android.content.SharedPreferences.Editor editorEdit = this.B_renamed.edit();
        if (z_renamed) {
            editorEdit.putString(com.oplus.camera.ui.CameraUIInterface.KEY_PHOTO_HIGH_RESOLUTION, "standard");
            editorEdit.putBoolean(com.oplus.camera.ui.CameraUIInterface.KEY_HIGH_PICTURE_SIZE, false);
        }
        editorEdit.putString(strP, string);
        editorEdit.putBoolean(strP2, z_renamed);
        editorEdit.apply();
        this.i_renamed.runOnUiThread(new java.lang.Runnable() { // from class: com.oplus.camera.ui.d_renamed.53
            @Override // java.lang.Runnable
            public void run() {
                com.oplus.camera.ui.d_renamed.this.a_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_PHOTO_HIGH_RESOLUTION, string);
            }
        });
        com.oplus.camera.e_renamed.b_renamed("CameraUIManager", "disableHighResolutionByAiScene, isOpen: " + z_renamed + ", nowState: " + string);
    }

    private void fz_renamed() {
        java.lang.String strP = p_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_PHOTO_HIGH_RESOLUTION);
        java.lang.String strP2 = p_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_HIGH_PICTURE_SIZE);
        final java.lang.String string = this.B_renamed.getString(strP, "ai_scene_last_default_value");
        boolean z_renamed = this.B_renamed.getBoolean(strP2, false);
        android.content.SharedPreferences.Editor editorEdit = this.B_renamed.edit();
        if (z_renamed) {
            editorEdit.putString(com.oplus.camera.ui.CameraUIInterface.KEY_PHOTO_HIGH_RESOLUTION, string);
            editorEdit.putBoolean(com.oplus.camera.ui.CameraUIInterface.KEY_HIGH_PICTURE_SIZE, true);
        }
        editorEdit.remove(strP);
        editorEdit.remove(strP2);
        editorEdit.apply();
        this.i_renamed.runOnUiThread(new java.lang.Runnable() { // from class: com.oplus.camera.ui.d_renamed.55
            @Override // java.lang.Runnable
            public void run() {
                com.oplus.camera.ui.d_renamed.this.b_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_PHOTO_HIGH_RESOLUTION, string);
            }
        });
        com.oplus.camera.e_renamed.b_renamed("CameraUIManager", "enableHighResolutionByAiScene, lastHighPictureValue: " + z_renamed);
    }

    private void b_renamed(final java.lang.String str, java.lang.String str2, final java.lang.String str3) {
        java.lang.String strP = p_renamed(str);
        if (q_renamed(strP)) {
            return;
        }
        final java.lang.String string = this.B_renamed.getString(str, str2);
        android.content.SharedPreferences.Editor editorEdit = this.B_renamed.edit();
        if (!android.text.TextUtils.equals(string, str3)) {
            editorEdit.putString(str, str3);
        }
        editorEdit.putString(strP, string);
        editorEdit.apply();
        this.i_renamed.runOnUiThread(new java.lang.Runnable() { // from class: com.oplus.camera.ui.d_renamed.56
            @Override // java.lang.Runnable
            public void run() {
                if (!android.text.TextUtils.equals(string, str3)) {
                    com.oplus.camera.ui.d_renamed.this.a_renamed(str, (java.lang.String) null);
                } else {
                    com.oplus.camera.ui.d_renamed.this.a_renamed(str, str3);
                }
            }
        });
        com.oplus.camera.e_renamed.b_renamed("CameraUIManager", "disableByAiScene, disableFunctionKey: " + str + ", nowState: " + string);
    }

    private void a_renamed(final java.lang.String str, java.lang.String str2, boolean z_renamed) {
        java.lang.String strP = p_renamed(str);
        java.lang.String string = this.B_renamed.getString(strP, str2);
        android.content.SharedPreferences.Editor editorEdit = this.B_renamed.edit();
        if (z_renamed) {
            editorEdit.putString(str, string);
        }
        editorEdit.remove(strP);
        editorEdit.apply();
        if (z_renamed) {
            this.i_renamed.runOnUiThread(new java.lang.Runnable() { // from class: com.oplus.camera.ui.d_renamed.57
                @Override // java.lang.Runnable
                public void run() {
                    com.oplus.camera.ui.d_renamed.this.b_renamed(str, (java.lang.String) null);
                }
            });
        }
        com.oplus.camera.e_renamed.b_renamed("CameraUIManager", "enableByAiScene, enableFunction: " + str + ", lastState: " + string + ", enable: " + z_renamed);
    }

    private boolean aa_renamed(int i_renamed) {
        return ab_renamed(i_renamed) && this.B_renamed.getInt(fr_renamed(), 0) == 0;
    }

    public java.lang.String p_renamed(java.lang.String str) {
        return com.oplus.camera.entry.b_renamed.b_renamed(str, this.K_renamed) + "_close_by_ai_last_state";
    }

    public boolean dv_renamed() {
        return q_renamed(p_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_FLASH_MODE));
    }

    public boolean dw_renamed() {
        return q_renamed(p_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_CAMERA_HDR_MODE));
    }

    public boolean dx_renamed() {
        return q_renamed(p_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_FILTER_MENU));
    }

    public boolean dy_renamed() {
        return q_renamed(p_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_PHOTO_HIGH_RESOLUTION));
    }

    public boolean q_renamed(java.lang.String str) {
        com.oplus.camera.e_renamed.b_renamed("CameraUIManager", "isDisabledByAiScene, recordDisableStateKey: " + str + ", state: " + this.B_renamed.getString(str, "ai_scene_last_default_value"));
        return !android.text.TextUtils.equals("ai_scene_last_default_value", r3);
    }

    private boolean fA_renamed() {
        java.lang.String strFr = fr_renamed();
        return this.B_renamed.getInt(p_renamed(strFr), Integer.MIN_VALUE) == 0 && 40 == this.B_renamed.getInt(strFr, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean fB_renamed() {
        if (this.u_renamed) {
            return false;
        }
        int i_renamed = this.B_renamed.getInt(p_renamed(fr_renamed()), Integer.MIN_VALUE);
        com.oplus.camera.e_renamed.b_renamed("CameraUIManager", "isFaceBeautyDisabledByAIScene, lastFaceBeautyIndex: " + i_renamed);
        return Integer.MIN_VALUE != i_renamed;
    }

    @Override // com.oplus.camera.ui.CameraUIInterface
    public void m_renamed(int i_renamed) {
        if (this.I_renamed.j_renamed() || this.cm_renamed == null) {
            return;
        }
        com.oplus.camera.ui.a_renamed.a_renamed aVar = this.ac_renamed;
        if (aVar != null && aVar.c_renamed()) {
            fD_renamed();
            return;
        }
        if (18 == i_renamed) {
            a_renamed(com.oplus.camera.R_renamed.string.camera_ai_scn_microspur, -1, false, true, true);
            return;
        }
        this.cm_renamed.removeMessages(2);
        android.os.Message messageObtainMessage = this.cm_renamed.obtainMessage();
        messageObtainMessage.what = 2;
        messageObtainMessage.obj = java.lang.Integer.valueOf(i_renamed);
        this.Q_renamed = i_renamed;
        this.cm_renamed.sendMessage(messageObtainMessage);
        ag_renamed(i_renamed);
    }

    private void ag_renamed(int i_renamed) {
        int i2;
        com.oplus.camera.ui.widget.c_renamed cVar;
        if (com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_AI_SCENE_ULTRA_WIDE_HINT)) {
            if (N_renamed(i_renamed) && this.J_renamed.f_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_PI_AI) && "on_renamed".equals(this.B_renamed.getString(com.oplus.camera.ui.CameraUIInterface.KEY_PI_AI, "off")) && this.bl_renamed && (((cVar = this.aw_renamed) == null || !cVar.isShowing()) && this.J_renamed.a_renamed(1, i_renamed))) {
                com.oplus.camera.j_renamed.a_renamed().b_renamed(2);
            } else {
                com.oplus.camera.ui.preview.b_renamed bVar = this.bk_renamed;
                if (bVar != null && bVar.b_renamed() && 1 == this.bk_renamed.a_renamed()) {
                    this.cm_renamed.post(new java.lang.Runnable() { // from class: com.oplus.camera.ui.-$$Lambda$d_renamed$MSpF5tMPs5yBwfuR1aZP7LrZETY
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f_renamed$0.gA_renamed();
                        }
                    });
                }
            }
        }
        if (this.bm_renamed && 4 == i_renamed && this.J_renamed.a_renamed(0, i_renamed)) {
            com.oplus.camera.j_renamed.a_renamed().b_renamed(3);
        } else {
            com.oplus.camera.ui.preview.b_renamed bVar2 = this.bk_renamed;
            if (bVar2 != null && bVar2.b_renamed() && 4 == this.R_renamed && this.bk_renamed.a_renamed() == 0) {
                this.cm_renamed.post(new java.lang.Runnable() { // from class: com.oplus.camera.ui.-$$Lambda$d_renamed$pOzZBTs5iV1Xa9JGrSbpXWKTizM
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f_renamed$0.gz_renamed();
                    }
                });
            }
        }
        if (com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_AI_SCENE_PORTRAIT_HINT)) {
            if (this.bn_renamed && ((10 == i_renamed || 16 == i_renamed) && this.J_renamed.a_renamed(2, i_renamed))) {
                com.oplus.camera.j_renamed.a_renamed().b_renamed(4);
            } else {
                com.oplus.camera.ui.preview.b_renamed bVar3 = this.bk_renamed;
                if (bVar3 != null && bVar3.b_renamed() && ((10 == (i2 = this.R_renamed) || 16 == i2) && 2 == this.bk_renamed.a_renamed())) {
                    this.cm_renamed.post(new java.lang.Runnable() { // from class: com.oplus.camera.ui.-$$Lambda$d_renamed$nEbVk7MKOj3o9JQSbxQ-HBon5pM
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f_renamed$0.gy_renamed();
                        }
                    });
                }
            }
        }
        this.R_renamed = i_renamed;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void gA_renamed() {
        l_renamed(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void gz_renamed() {
        l_renamed(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void gy_renamed() {
        l_renamed(true);
    }

    public void M_renamed(int i_renamed) {
        com.oplus.camera.ui.widget.c_renamed cVar;
        if (this.J_renamed != null && i_renamed == 0) {
            this.cm_renamed.removeMessages(9);
            this.cm_renamed.sendEmptyMessage(9);
            return;
        }
        if (this.J_renamed != null && com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_AI_SCENE_ULTRA_WIDE_HINT) && (((cVar = this.aw_renamed) == null || !cVar.isShowing()) && 1 == i_renamed)) {
            this.cm_renamed.removeMessages(5);
            this.cm_renamed.sendEmptyMessage(5);
        } else if (this.J_renamed != null && 2 == i_renamed) {
            this.cm_renamed.removeMessages(11);
            this.cm_renamed.sendEmptyMessage(11);
        } else {
            com.oplus.camera.j_renamed.a_renamed().c_renamed();
        }
    }

    public void dz_renamed() {
        android.os.Handler handler = this.cm_renamed;
        if (handler != null) {
            handler.removeMessages(2);
        }
        boolean z_renamed = av_renamed() && this.i_renamed != null;
        com.oplus.camera.ui.preview.a_renamed aVar = this.aH_renamed;
        if (aVar != null) {
            aVar.a_renamed(z_renamed);
            dA_renamed();
        }
        this.O_renamed = 0;
        this.s_renamed = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fC_renamed() {
        if (this.aH_renamed != null) {
            ah_renamed(this.O_renamed);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ah_renamed(int i_renamed) {
        if (j_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_PI_AI) && T_renamed()) {
            com.oplus.camera.e_renamed.c_renamed("CameraUIManager", "updateAISceneViewAndSetUpHint, return");
            return;
        }
        ai_renamed(i_renamed);
        this.aH_renamed.b_renamed();
        if (i_renamed == 0) {
            dA_renamed();
        }
    }

    private void fD_renamed() {
        com.oplus.camera.ui.a_renamed.a_renamed aVar = this.ac_renamed;
        if (aVar != null) {
            aVar.a_renamed(new com.oplus.camera.ui.a_renamed.a_renamed.b_renamed() { // from class: com.oplus.camera.ui.d_renamed.58
                @Override // com.oplus.camera.ui.a_renamed.a_renamed.b_renamed
                public void a_renamed(com.oplus.camera.ui.a_renamed.b_renamed bVar) {
                }

                @Override // com.oplus.camera.ui.a_renamed.a_renamed.b_renamed
                public void a_renamed(int i_renamed) {
                    int iAS = com.oplus.camera.ui.d_renamed.this.J_renamed != null ? com.oplus.camera.ui.d_renamed.this.J_renamed.aS_renamed() : 0;
                    if (iAS <= 0 || com.oplus.camera.ui.d_renamed.this.aU_renamed()) {
                        return;
                    }
                    com.oplus.camera.ui.d_renamed.this.m_renamed(iAS);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ai_renamed(int i_renamed) {
        java.lang.String string = this.B_renamed.getString(com.oplus.camera.ui.CameraUIInterface.KEY_10_BITS_HEIC_ENCODE, "off");
        if (i_renamed != 0 && !this.B_renamed.getBoolean(com.oplus.camera.ui.CameraUIInterface.KEY_HIGH_PICTURE_SIZE, false) && "off".equals(string)) {
            a_renamed(true, false, false);
        }
        this.aH_renamed.a_renamed(i_renamed, this.L_renamed, this.P_renamed);
    }

    @Override // com.oplus.camera.ui.CameraUIInterface
    public void ab_renamed() {
        if (com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_PI_AI)) {
            this.cm_renamed.removeMessages(2);
        }
        com.oplus.camera.ui.preview.a_renamed aVar = this.aH_renamed;
        if (aVar != null) {
            aVar.h_renamed();
            dA_renamed();
        }
    }

    private boolean fE_renamed() {
        java.lang.Boolean boolValueOf = java.lang.Boolean.valueOf(com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_SUPPORT_VIDEO_FRONT_EIS_FORCE_ULTRA_WIDE));
        com.oplus.camera.ui.CameraUIListener cameraUIListener = this.J_renamed;
        java.lang.Boolean boolValueOf2 = java.lang.Boolean.valueOf(cameraUIListener != null && cameraUIListener.h_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_SUPER_EIS_MENU));
        return boolValueOf.booleanValue() ? boolValueOf2.booleanValue() && java.lang.Boolean.valueOf("on_renamed".equals(this.B_renamed.getString(com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_SUPER_EIS_MENU, "off"))).booleanValue() : boolValueOf2.booleanValue() && !java.lang.Boolean.valueOf(com.oplus.camera.e_renamed.a_renamed.a_renamed(cv_renamed())).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean fF_renamed() {
        com.oplus.camera.ui.CameraUIListener cameraUIListener = this.J_renamed;
        if (cameraUIListener == null || this.B_renamed == null || !cameraUIListener.h_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_SUPER_EIS_MENU) || com.oplus.camera.e_renamed.a_renamed.a_renamed(cv_renamed())) {
            return false;
        }
        return "on_renamed".equals(this.B_renamed.getString(com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_SUPER_EIS_MENU, "off"));
    }

    public android.graphics.Rect[] dB_renamed() {
        com.oplus.camera.ui.preview.g_renamed gVar = this.A_renamed;
        if (gVar != null) {
            return gVar.ae_renamed();
        }
        return null;
    }

    public void dC_renamed() {
        this.A_renamed.V_renamed();
    }

    public void dD_renamed() {
        this.A_renamed.W_renamed();
    }

    private boolean fG_renamed() {
        return !this.B_renamed.getString(com.oplus.camera.ui.CameraUIInterface.KEY_CAMERA_TAP_SHUTTER, this.i_renamed.getString(com.oplus.camera.R_renamed.string.camera_tap_shutter_default_value)).equals(this.B_renamed.getString(com.oplus.camera.ui.CameraUIInterface.KEY_LAST_CAMERA_TAP_SHUTTER, this.i_renamed.getString(com.oplus.camera.R_renamed.string.camera_tap_shutter_default_value)));
    }

    private boolean fH_renamed() {
        android.app.Activity activity;
        com.oplus.camera.ComboPreferences comboPreferences = this.B_renamed;
        if (comboPreferences == null || (activity = this.i_renamed) == null) {
            return false;
        }
        return "on_renamed".equals(comboPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_CAMERA_TAP_SHUTTER, activity.getString(com.oplus.camera.R_renamed.string.camera_tap_shutter_default_value)));
    }

    public boolean dE_renamed() {
        com.oplus.camera.ui.CameraUIListener cameraUIListener = this.J_renamed;
        if (cameraUIListener != null) {
            return cameraUIListener.bK_renamed();
        }
        return false;
    }

    public void g_renamed(java.lang.String str, boolean z_renamed) {
        com.oplus.camera.ui.menu.setting.q_renamed qVar = this.aG_renamed.get(str);
        if (this.H_renamed != null && qVar != null) {
            if (qVar.isEffectMenuOpen() && !z_renamed && !qVar.openMenuCanDisableHighLight() && qVar.isEffectOpen()) {
                this.H_renamed.b_renamed(str, true);
            } else {
                this.H_renamed.b_renamed(str, qVar.isEffectOpen());
            }
        }
        if (this.I_renamed == null || qVar == null) {
            return;
        }
        if (qVar.isEffectMenuOpen() && !z_renamed && !qVar.openMenuCanDisableHighLight()) {
            this.I_renamed.b_renamed(str, true);
        } else {
            this.I_renamed.b_renamed(str, qVar.isEffectOpen());
        }
    }

    @Override // com.oplus.camera.ui.CameraUIInterface
    public void t_renamed(boolean z_renamed) {
        com.oplus.camera.ui.menu.setting.o_renamed oVar = this.H_renamed;
        if (oVar != null) {
            oVar.g_renamed(z_renamed);
        }
    }

    @Override // com.oplus.camera.ui.CameraUIInterface
    public void g_renamed(java.lang.String str) {
        g_renamed(str, false);
    }

    public void a_renamed(java.lang.String str, com.oplus.camera.ui.menu.setting.q_renamed qVar) {
        if (qVar != null && !this.aG_renamed.containsKey(str)) {
            this.aG_renamed.put(str, qVar);
        }
        com.oplus.camera.e_renamed.a_renamed("CameraUIManager", "addMenuToExpandMenuMap, Map size: " + this.aG_renamed.size());
    }

    public void O_renamed(int i_renamed) {
        com.oplus.camera.ui.menu.levelcontrol.c_renamed cVar = this.ai_renamed;
        if (cVar != null) {
            cVar.updateBlurMenuIndex(i_renamed);
        }
    }

    public void r_renamed(java.lang.String str) {
        if (t_renamed(str)) {
            if (str.equals(com.oplus.camera.ui.CameraUIInterface.KEY_FILTER_MENU) && com.oplus.camera.aps.constant.ApsConstant.CAPTURE_MODE_COMMON.equals(this.J_renamed.ao_renamed()) && !com.oplus.camera.e_renamed.a_renamed.a_renamed(cv_renamed())) {
                this.B_renamed.edit().putBoolean(com.oplus.camera.ui.CameraUIInterface.PRE_MENU_FILTER_ICON_RECEOMMEND_CLICKED, true).apply();
            }
            if (this.aK_renamed == null) {
                if (s_renamed(str)) {
                    this.aK_renamed.showMenuPanel(str, false, true);
                    return;
                }
                return;
            }
            com.oplus.camera.e_renamed.a_renamed("CameraUIManager", "updateCameraSettingExpandMenu, mCurrentExpandPanel: " + this.aK_renamed + ", key: " + str);
            if (str.equals(this.aK_renamed.getCurrentMenuKey())) {
                this.aK_renamed.hideMenuPanel(true, false);
                return;
            }
            if (com.oplus.camera.ui.menu.setting.q_renamed.DEFALUT_MENU.equals(this.aK_renamed.getCurrentMenuKey())) {
                if (s_renamed(str)) {
                    this.aK_renamed.showMenuPanel(str, false, true);
                    return;
                }
                return;
            }
            com.oplus.camera.ui.menu.setting.q_renamed qVar = this.aG_renamed.get(str);
            this.aK_renamed.hideMenuPanel(qVar == null, qVar != null);
            if (qVar != null) {
                if (qVar.mExpandMenuListener == null) {
                    qVar.setExpandMenuListener(this.cz_renamed);
                }
                qVar.showMenuPanel(str, true, true);
                return;
            }
            return;
        }
        com.oplus.camera.e_renamed.e_renamed("CameraUIManager", "updateCameraSettingExpandMenu, key: " + str);
    }

    public boolean s_renamed(java.lang.String str) {
        if (this.aG_renamed.get(str) != null && this.aG_renamed.get(str).mExpandMenuListener == null) {
            this.aG_renamed.get(str).setExpandMenuListener(this.cz_renamed);
        }
        this.aK_renamed = this.aG_renamed.get(str);
        return this.aK_renamed != null;
    }

    public boolean t_renamed(java.lang.String str) {
        return com.oplus.camera.ui.CameraUIInterface.KEY_FILTER_MENU.equals(str) || com.oplus.camera.ui.CameraUIInterface.KEY_NIGHT_FILTER_MENU.equals(str) || com.oplus.camera.ui.CameraUIInterface.KEY_STREET_FILTER_MENU.equals(str) || com.oplus.camera.ui.CameraUIInterface.KEY_PORTRAIT_NEW_STYLE_MENU.equals(str) || com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_FILTER_MENU.equals(str) || com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_BLUR_MENU.equals(str) || com.oplus.camera.ui.CameraUIInterface.KEY_PORTRAIT_BLUR_MENU.equals(str) || com.oplus.camera.ui.CameraUIInterface.KEY_TILT_SHIFT_BLUR_MENU.equals(str);
    }

    @Override // com.oplus.camera.ui.CameraUIInterface
    public void b_renamed(int i_renamed, int i2, int i3, java.lang.Object... objArr) {
        if (this.p_renamed) {
            return;
        }
        com.oplus.camera.ui.preview.a_renamed aVar = this.aH_renamed;
        if ((aVar != null && aVar.i_renamed() && !this.aH_renamed.j_renamed()) || this.I_renamed.j_renamed() || eo_renamed() || R_renamed()) {
            return;
        }
        cR_renamed();
        this.ac_renamed.a_renamed(i_renamed, true, false, i2, i3, 0, dY_renamed(), objArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aj_renamed(int i_renamed) {
        com.oplus.camera.e_renamed.a_renamed("CameraUIManager", "exitFromMoreMode");
        if (!R_renamed()) {
            com.oplus.camera.e_renamed.b_renamed("CameraUIManager", "exitFromMoreMode, not in_renamed MoreMode");
            return;
        }
        if (this.z_renamed.W_renamed()) {
            com.oplus.camera.e_renamed.b_renamed("CameraUIManager", "exitFromMoreMode, Multiple finger operation in_renamed Headline");
            this.z_renamed.p_renamed(false);
            return;
        }
        if (this.bt_renamed.a_renamed()) {
            com.oplus.camera.e_renamed.b_renamed("CameraUIManager", "exitFromMoreMode, do not respond back event in_renamed the arranging state.");
            return;
        }
        if (this.z_renamed.aw_renamed() && this.z_renamed.ax_renamed()) {
            com.oplus.camera.e_renamed.b_renamed("CameraUIManager", "exitFromMoreMode, exit mode arrange.");
            this.cn_renamed.a_renamed();
            return;
        }
        this.bd_renamed.b_renamed(true);
        this.z_renamed.av_renamed();
        aK_renamed(false);
        if (androidx.preference.j_renamed.a_renamed(this.i_renamed).getBoolean("mode_arrange_change_panel", false)) {
            com.oplus.camera.ui.CameraUIListener cameraUIListener = this.J_renamed;
            if (cameraUIListener != null) {
                cameraUIListener.d_renamed(20);
            }
            aJ_renamed(true);
            e_renamed(1.0f);
            com.oplus.camera.ui.inverse.e_renamed.INS.setMaskAlpha(this.i_renamed, true, true);
            com.oplus.camera.ui.inverse.e_renamed.INS.setExecuteDelayMsg(true);
            this.z_renamed.s_renamed(false);
        } else {
            av_renamed(true);
        }
        com.oplus.camera.ui.CameraUIListener cameraUIListener2 = this.J_renamed;
        if (cameraUIListener2 != null) {
            cameraUIListener2.f_renamed(i_renamed);
        }
        d_renamed(true, i_renamed);
    }

    @Override // com.oplus.camera.ui.CameraUIInterface
    public void b_renamed(boolean z_renamed, boolean z2, boolean z3, boolean z4) {
        com.oplus.camera.ui.menu.levelcontrol.c_renamed cVar = this.ai_renamed;
        if (cVar != null && cVar.isMenuOpen()) {
            this.ai_renamed.hideMenu(z_renamed, z2, false, z3, z4);
        } else {
            com.oplus.camera.ui.menu.levelcontrol.c_renamed cVar2 = this.aS_renamed;
            if (cVar2 != null && cVar2.isMenuOpen()) {
                this.aS_renamed.hideMenu(z_renamed, z2, false, z3, z4);
            }
        }
        com.oplus.camera.ui.CameraUIListener cameraUIListener = this.J_renamed;
        if (cameraUIListener != null) {
            S_renamed(cameraUIListener.aN_renamed() || this.J_renamed.aO_renamed());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aI_renamed(boolean z_renamed) {
        if (this.J_renamed == null || this.aT_renamed == null) {
            return;
        }
        com.oplus.camera.statistics.model.MenuClickMsgData menuClickMsgData = new com.oplus.camera.statistics.model.MenuClickMsgData(this.i_renamed);
        menuClickMsgData.buildEvent(false);
        if (this.aT_renamed.t_renamed() && !this.aT_renamed.r_renamed() && !this.aT_renamed.s_renamed()) {
            menuClickMsgData.mFuncKeyId = this.J_renamed.az_renamed() ? 64 : 4;
        } else {
            menuClickMsgData.mFuncKeyId = 2;
        }
        menuClickMsgData.mCameraId = this.J_renamed.I_renamed();
        menuClickMsgData.mOrientation = this.L_renamed;
        menuClickMsgData.mCaptureType = !cp_renamed() ? 1 : 0;
        menuClickMsgData.mCaptureMode = this.J_renamed.ao_renamed();
        menuClickMsgData.mCameraEnterType = java.lang.String.valueOf(this.K_renamed);
        if (z_renamed) {
            menuClickMsgData.mFuncKeyResult = 1;
        } else {
            menuClickMsgData.mFuncKeyResult = 2;
        }
        menuClickMsgData.mRearOrFront = com.oplus.camera.e_renamed.a_renamed.a_renamed(menuClickMsgData.mCameraId) ? com.oplus.camera.statistics.model.DcsMsgData.FRONT : com.oplus.camera.statistics.model.DcsMsgData.REAR;
        menuClickMsgData.report();
    }

    @Override // com.oplus.camera.ui.CameraUIInterface
    public void a_renamed(int i_renamed, java.lang.String str) {
        com.oplus.camera.ui.menu.levelcontrol.g_renamed gVar = this.ah_renamed;
        if (gVar != null) {
            gVar.a_renamed(i_renamed, str);
        }
    }

    @Override // com.oplus.camera.ui.CameraUIInterface
    public void l_renamed(int i_renamed) {
        com.oplus.camera.ui.menu.levelcontrol.g_renamed gVar = this.ah_renamed;
        if (gVar != null) {
            gVar.c_renamed(i_renamed);
        }
    }

    private void fI_renamed() {
        if (this.bd_renamed == null) {
            this.bd_renamed = new com.oplus.camera.ui.modepanel.p_renamed(this.i_renamed, this.Z_renamed, this.L_renamed, this.bt_renamed, this.l_renamed);
            this.bd_renamed.a_renamed(this.cA_renamed);
            this.bd_renamed.a_renamed(this.cn_renamed);
        }
    }

    private void fJ_renamed() {
        com.oplus.camera.ui.preview.a_renamed aVar = this.aH_renamed;
        if (aVar != null) {
            aVar.a_renamed(false);
            dA_renamed();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aJ_renamed(boolean z_renamed) {
        if (this.H_renamed != null) {
            com.oplus.camera.e_renamed.a_renamed("CameraUIManager", "showSettingMenu");
            this.H_renamed.m_renamed();
        }
        com.oplus.camera.ui.menu.setting.f_renamed fVar = this.I_renamed;
        if (fVar == null || z_renamed) {
            return;
        }
        fVar.m_renamed();
    }

    public void av_renamed(boolean z_renamed) {
        java.lang.String string = this.B_renamed.getString(com.oplus.camera.ui.CameraUIInterface.KEY_CAMERA_MODE, "");
        boolean zEquals = "on_renamed".equals(this.B_renamed.getString(com.oplus.camera.ui.CameraUIInterface.KEY_MULTI_CAMERA_TYPE_MENU, this.i_renamed.getString(com.oplus.camera.R_renamed.string.camera_multicamera_type_default)));
        if (com.oplus.camera.aps.constant.ApsConstant.CAPTURE_MODE_MULTI_VIDEO.equals(string) && zEquals && fh_renamed()) {
            com.oplus.camera.e_renamed.a_renamed("CameraUIManager", "backToLastHeadlineIndex, multi camera type menu is_renamed open, can't_renamed show headline.");
            z_renamed = false;
        }
        if (com.oplus.camera.aps.constant.ApsConstant.CAPTURE_MODE_PROFESSIONAL.equals(string) && this.J_renamed.at_renamed() && this.J_renamed.h_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_HEADLINE_CONTROL_BY_MODE)) {
            com.oplus.camera.e_renamed.a_renamed("CameraUIManager", "backToLastHeadlineIndex, professional mode bar is_renamed open, can't_renamed show headline.");
            z_renamed = false;
        }
        if (this.z_renamed != null) {
            com.oplus.camera.e_renamed.a_renamed("CameraUIManager", "backToLastHeadlineIndex, show: " + z_renamed);
            this.z_renamed.h_renamed(z_renamed);
        }
    }

    public boolean dF_renamed() {
        com.oplus.camera.ui.control.a_renamed aVar = this.z_renamed;
        if (aVar != null) {
            return aVar.q_renamed();
        }
        return false;
    }

    public void dG_renamed() {
        d_renamed(true, false);
        i_renamed(true);
        if (this.J_renamed.bl_renamed()) {
            l_renamed(false, false);
        }
        if (this.J_renamed.bm_renamed()) {
            i_renamed(false, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aK_renamed(boolean z_renamed) {
        com.oplus.camera.ui.a_renamed.a_renamed aVar = this.ac_renamed;
        if (aVar != null) {
            aVar.d_renamed(z_renamed);
        }
        com.oplus.camera.ui.camerascreenhint.CameraScreenHintView cameraScreenHintView = this.am_renamed;
        if (cameraScreenHintView != null) {
            cameraScreenHintView.setMoreMode(z_renamed);
        }
    }

    public boolean dH_renamed() {
        com.oplus.camera.ui.modepanel.p_renamed pVar = this.bd_renamed;
        return pVar != null && pVar.e_renamed();
    }

    public float dI_renamed() {
        com.oplus.camera.ui.menu.setting.o_renamed oVar = this.H_renamed;
        if (oVar != null) {
            return oVar.H_renamed();
        }
        return 1.0f;
    }

    public void P_renamed(int i_renamed) {
        if (this.bd_renamed != null) {
            com.oplus.camera.e_renamed.a_renamed("CameraUIManager", "showMoreView");
            this.bd_renamed.d_renamed(i_renamed);
        }
    }

    public void dJ_renamed() {
        if (this.bd_renamed != null) {
            com.oplus.camera.e_renamed.a_renamed("CameraUIManager", "hideMoreView");
            this.bd_renamed.b_renamed(true);
            this.z_renamed.av_renamed();
        }
    }

    public void dK_renamed() {
        com.oplus.camera.e_renamed.a_renamed("CameraUIManager", "onMoreModeShown");
        aK_renamed(true);
        P_renamed(false);
        com.oplus.camera.ui.menu.setting.o_renamed oVar = this.H_renamed;
        if (oVar != null) {
            oVar.c_renamed(false);
        }
        a_renamed(com.oplus.camera.aps.constant.ApsConstant.REC_MODE_COMMON, com.oplus.camera.ui.CameraUIInterface.KEY_BUBBLE_TYPE_AI_ENHANCEMENT_VIDEO, 7);
        a_renamed(com.oplus.camera.aps.constant.ApsConstant.CAPTURE_MODE_COMMON, com.oplus.camera.ui.CameraUIInterface.KEY_BUBBLE_TYPE_ZOOM_ULTRA_WIDE, 9);
        f_renamed(17, true);
        f_renamed(20, true);
        L_renamed(false);
        o_renamed();
        co_renamed();
        fJ_renamed();
        b_renamed(false);
        w_renamed(false);
        a_renamed(true, true, false);
        j_renamed(false, false);
        b_renamed(true, com.oplus.camera.util.Util.u_renamed(), false, false);
        h_renamed(false, false);
        i_renamed(false);
        B_renamed(false);
        j_renamed(false);
        if (ex_renamed()) {
            A_renamed(false, false);
            d_renamed(false, false, this.bP_renamed.c_renamed());
        }
        com.oplus.camera.ui.control.a_renamed aVar = this.z_renamed;
        if (aVar != null) {
            aVar.h_renamed(false, true);
            this.z_renamed.f_renamed(true);
            com.oplus.camera.ui.inverse.e_renamed.INS.setExecuteDelayMsg(false);
            if (com.oplus.camera.ui.inverse.e_renamed.INS.isInverseColor(this.i_renamed.hashCode()) && !this.v_renamed) {
                com.oplus.camera.ui.inverse.e_renamed.INS.setInverseColor((android.content.Context) this.i_renamed, false, true);
                this.v_renamed = true;
            }
        }
        df_renamed();
        if (T_renamed()) {
            U_renamed();
        }
        fK_renamed();
    }

    private void a_renamed(java.lang.String str, java.lang.String str2, int i_renamed) {
        com.oplus.camera.ui.CameraUIListener cameraUIListener;
        if (android.text.TextUtils.isEmpty(str) || android.text.TextUtils.isEmpty(str2) || (cameraUIListener = this.J_renamed) == null || !str.equals(cameraUIListener.ao_renamed()) || !w_renamed(str2)) {
            return;
        }
        f_renamed(i_renamed, true);
    }

    private void f_renamed(boolean z_renamed, int i_renamed) {
        if (z_renamed) {
            i_renamed(i_renamed, com.oplus.camera.R_renamed.drawable.sticker_red_point);
        } else {
            n_renamed(i_renamed);
        }
    }

    private void fK_renamed() {
        f_renamed(fM_renamed(), 2);
        f_renamed(fN_renamed(), 13);
        f_renamed(fO_renamed(), 29);
        f_renamed(fQ_renamed(), 14);
        f_renamed(fU_renamed(), 18);
        f_renamed(fP_renamed(), 16);
        f_renamed(fV_renamed(), 26);
        f_renamed(fW_renamed(), 27);
        f_renamed(fR_renamed(), 31);
    }

    public void d_renamed(boolean z_renamed, int i_renamed) {
        com.oplus.camera.ui.CameraUIListener cameraUIListener = this.J_renamed;
        a_renamed(z_renamed, cameraUIListener != null ? cameraUIListener.ao_renamed() : null, i_renamed);
    }

    public void a_renamed(boolean z_renamed, java.lang.String str, int i_renamed) {
        this.v_renamed = false;
        aK_renamed(false);
        d_renamed(true, false);
        bU_renamed();
        if (1 != aX_renamed() || !eD_renamed()) {
            aJ_renamed(false);
            e_renamed(1.0f);
        }
        com.oplus.camera.ui.CameraUIListener cameraUIListener = this.J_renamed;
        if (cameraUIListener != null && !cameraUIListener.aY_renamed()) {
            i_renamed(true);
        }
        com.oplus.camera.ui.inverse.e_renamed.INS.setExecuteDelayMsg(true);
        if (com.oplus.camera.ui.inverse.e_renamed.INS.isInverseColor(this.i_renamed.hashCode()) && this.v_renamed) {
            com.oplus.camera.ui.inverse.e_renamed.INS.setMaskAlpha(this.i_renamed, true, true);
            this.z_renamed.s_renamed(false);
            this.v_renamed = false;
        }
        com.oplus.camera.ui.CameraUIListener cameraUIListener2 = this.J_renamed;
        if (cameraUIListener2 != null && cameraUIListener2.bl_renamed()) {
            l_renamed(false, false);
        }
        com.oplus.camera.ui.CameraUIListener cameraUIListener3 = this.J_renamed;
        if (cameraUIListener3 != null && cameraUIListener3.bm_renamed() && !aA_renamed()) {
            i_renamed(false, false);
        }
        com.oplus.camera.ui.CameraUIListener cameraUIListener4 = this.J_renamed;
        if (cameraUIListener4 != null && cameraUIListener4.bn_renamed()) {
            o_renamed(false, false);
            q_renamed(false, false);
        }
        if (j_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_TIME_LAPSE_PRO)) {
            N_renamed(false);
        }
        if (el_renamed()) {
            a_renamed(true, false, false);
        }
        if (!fE_renamed()) {
            N_renamed();
        } else if (1 != i_renamed) {
            M_renamed();
        }
        this.z_renamed.c_renamed(true, false);
        this.z_renamed.i_renamed();
        if (bj_renamed()) {
            d_renamed(false, false);
        }
    }

    private void fL_renamed() {
        if (fX_renamed()) {
            d_renamed(com.oplus.camera.R_renamed.string.camera_mode_more);
        }
        if (fT_renamed()) {
            d_renamed(com.oplus.camera.R_renamed.string.camera_mode_arrange);
        } else {
            b_renamed(com.oplus.camera.R_renamed.string.camera_mode_arrange);
        }
    }

    private boolean fM_renamed() {
        return this.B_renamed != null && com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_SLOW_VIDEO_RED_DOT_SUPPORT) && !com.oplus.camera.e_renamed.a_renamed.a_renamed(java.lang.Integer.parseInt(this.B_renamed.getString(com.oplus.camera.ui.CameraUIInterface.KEY_CAMERA_ID, java.lang.String.valueOf(0)))) && androidx.preference.j_renamed.a_renamed(this.i_renamed).getBoolean("slow_video_high_frame_reddot_show", true);
    }

    private boolean fN_renamed() {
        return com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_ID_PHOTO) && com.oplus.camera.util.Util.v_renamed(this.i_renamed) && androidx.preference.j_renamed.a_renamed(this.i_renamed).getBoolean("id_photo_reddot_show", false) && com.oplus.camera.l_renamed.c_renamed.g_renamed();
    }

    private boolean fO_renamed() {
        return com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_FISH_EYE) && androidx.preference.j_renamed.a_renamed(this.i_renamed).getBoolean("fish_eye_reddot_show", true);
    }

    private boolean fP_renamed() {
        return com.oplus.camera.aps.config.CameraConfig.isSupportMicroscope() && androidx.preference.j_renamed.a_renamed(this.i_renamed).getBoolean("microscope_reddot_show", true);
    }

    private boolean fQ_renamed() {
        return com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_MULTI_VIDEO_MODE_SUPPORT) && androidx.preference.j_renamed.a_renamed(this.i_renamed).getBoolean("multi_video_reddot_show", false);
    }

    private boolean fR_renamed() {
        return com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_HIGH_PIXEL_SUPPORT) && androidx.preference.j_renamed.a_renamed(this.i_renamed).getBoolean("mode_high_pixel_reddot_show", true);
    }

    private boolean fS_renamed() {
        return com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_SUPPORT_PROFESSIONAL_SUPER_RAW) && androidx.preference.j_renamed.a_renamed(this.i_renamed).getBoolean("profession_reddot_show", true);
    }

    private boolean fT_renamed() {
        return androidx.preference.j_renamed.a_renamed(this.i_renamed).getBoolean("mode_arrange_reddot_show", true);
    }

    private boolean fU_renamed() {
        return com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_DOUBLE_EXPOSURE_SUPPORT) && androidx.preference.j_renamed.a_renamed(this.i_renamed).getBoolean("double_exposure_reddot_show", true);
    }

    private boolean fV_renamed() {
        return com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_SUPPORT_STREET_MODE) && androidx.preference.j_renamed.a_renamed(this.i_renamed).getBoolean("street_reddot_show", true);
    }

    private boolean fW_renamed() {
        return com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_SUPPORT_LONG_EXPOSURE_MODE) && androidx.preference.j_renamed.a_renamed(this.i_renamed).getBoolean("long_exposure_reddot_show", true);
    }

    private boolean fX_renamed() {
        return (fM_renamed() || fN_renamed() || fO_renamed() || fQ_renamed() || fS_renamed() || fU_renamed() || fP_renamed() || fV_renamed() || fW_renamed() || fR_renamed()) && androidx.preference.j_renamed.a_renamed(this.i_renamed).getBoolean("more_menu_reddot_show", true);
    }

    @Override // com.oplus.camera.ui.CameraUIInterface
    public boolean af_renamed() {
        return com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_MULTI_VIDEO_MODE_SUPPORT) && androidx.preference.j_renamed.a_renamed(this.i_renamed).getBoolean("multi_video_setting_menu_reddot_show", false);
    }

    @Override // com.oplus.camera.ui.CameraUIInterface
    public boolean ag_renamed() {
        return com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_SUPPORT_PROFESSIONAL_SUPER_RAW) && androidx.preference.j_renamed.a_renamed(this.i_renamed).getBoolean("super_raw_setting_menu_reddot_show", true);
    }

    public boolean dL_renamed() {
        return com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_STREET_LONG_EXPOSURE_SUPPORT) && androidx.preference.j_renamed.a_renamed(this.i_renamed).getBoolean("street_long_exposure_reddot_show", true);
    }

    @Override // com.oplus.camera.ui.CameraUIInterface
    public boolean ae_renamed() {
        return androidx.preference.j_renamed.a_renamed(this.i_renamed).getBoolean("video_filter_reddot_show", true) && com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_VIDEO_NEON_SUPPORT) && !com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_VIDEO_BLUR_SUPPORT_WITHOUT_NEON);
    }

    @Override // com.oplus.camera.ui.CameraUIInterface
    public boolean ad_renamed() {
        return androidx.preference.j_renamed.a_renamed(this.i_renamed).getBoolean("portrait_filter_reddot_show", true) && com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_PORTRAIT_NEON_FRONT_SUPPORT);
    }

    public void dM_renamed() {
        com.oplus.camera.ui.control.a_renamed aVar = this.z_renamed;
        if (aVar != null) {
            aVar.ae_renamed();
        }
    }

    public boolean dN_renamed() {
        com.oplus.camera.ui.modepanel.p_renamed pVar = this.bd_renamed;
        if (pVar != null) {
            return pVar.b_renamed();
        }
        return false;
    }

    @Override // com.oplus.camera.ui.CameraUIInterface
    public boolean S_renamed() {
        com.oplus.camera.ui.modepanel.p_renamed pVar = this.bd_renamed;
        return pVar != null && pVar.c_renamed();
    }

    public boolean dO_renamed() {
        com.oplus.camera.ui.modepanel.p_renamed pVar = this.bd_renamed;
        return pVar != null && pVar.d_renamed();
    }

    public boolean dP_renamed() {
        com.oplus.camera.ui.menu.levelcontrol.g_renamed gVar = this.ah_renamed;
        if (gVar != null) {
            return gVar.isAnimationRunning();
        }
        return false;
    }

    public void dQ_renamed() {
        com.oplus.camera.ui.menu.levelcontrol.g_renamed gVar = this.ah_renamed;
        if (gVar != null) {
            gVar.e_renamed();
        }
    }

    public boolean dR_renamed() {
        com.oplus.camera.ui.preview.i_renamed iVar = this.E_renamed;
        if (iVar != null) {
            return iVar.h_renamed();
        }
        return false;
    }

    public boolean dS_renamed() {
        com.oplus.camera.ui.control.a_renamed aVar = this.z_renamed;
        return aVar != null && aVar.ap_renamed();
    }

    @Override // com.oplus.camera.ui.CameraUIInterface
    public boolean R_renamed() {
        return dS_renamed() && dH_renamed();
    }

    @Override // com.oplus.camera.ui.CameraUIInterface
    public void z_renamed(boolean z_renamed) {
        com.oplus.camera.ui.CameraUIListener cameraUIListener = this.J_renamed;
        if (cameraUIListener != null) {
            cameraUIListener.d_renamed(z_renamed);
        }
    }

    public void aw_renamed(boolean z_renamed) {
        com.oplus.camera.ui.CameraUIListener cameraUIListener = this.J_renamed;
        if (cameraUIListener != null) {
            cameraUIListener.f_renamed(z_renamed);
        }
    }

    public void dT_renamed() {
        com.oplus.camera.ui.menu.levelcontrol.g_renamed gVar = this.ah_renamed;
        if (gVar != null) {
            gVar.i_renamed();
        }
    }

    @Override // com.oplus.camera.ui.CameraUIInterface
    public void A_renamed(boolean z_renamed) {
        if (this.o_renamed || this.n_renamed) {
            com.oplus.camera.e_renamed.e_renamed("CameraUIManager", "updateDimHintView, mbShowCapAlert: " + this.o_renamed + ", mbShowVideoAlert: " + this.n_renamed);
            return;
        }
        long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
        if (!z_renamed) {
            if (jCurrentTimeMillis - this.U_renamed < 3000) {
                com.oplus.camera.e_renamed.a_renamed("CameraUIManager", "updateDimHintView, hideDimScreenHint");
                a_renamed(com.oplus.camera.R_renamed.string.camera_id_photo_mode_need_more_light);
                return;
            }
            return;
        }
        if (jCurrentTimeMillis - this.U_renamed <= com.google.android.exoplayer2.upstream.DefaultLoadErrorHandlingPolicy.DEFAULT_TRACK_BLACKLIST_MS || !this.J_renamed.aX_renamed() || jCurrentTimeMillis - this.W_renamed < 3000 || jCurrentTimeMillis - this.V_renamed < 3000 || this.q_renamed) {
            return;
        }
        com.oplus.camera.e_renamed.a_renamed("CameraUIManager", "updateDimHintView, showDimScreenHint");
        this.U_renamed = jCurrentTimeMillis;
        this.i_renamed.runOnUiThread(new java.lang.Runnable() { // from class: com.oplus.camera.ui.-$$Lambda$d_renamed$3Y-hhGLqBIjp_YxnhWv35ZfVxrE
            @Override // java.lang.Runnable
            public final void run() {
                this.f_renamed$0.gx_renamed();
            }
        });
        a_renamed(com.oplus.camera.R_renamed.string.hint_function_not_support_1080_60);
        a_renamed(com.oplus.camera.R_renamed.string.camera_id_photo_mode_need_more_light, -1, true, false, false);
        this.J_renamed.b_renamed(com.oplus.camera.statistics.model.ReminderMsgData.TYPE_ADVICE, com.oplus.camera.statistics.model.ReminderMsgData.CODE_FLASH_ON);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void gx_renamed() {
        this.ac_renamed.g_renamed();
    }

    @Override // com.oplus.camera.ui.CameraUIInterface
    public boolean X_renamed() {
        long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
        if (jCurrentTimeMillis - this.W_renamed <= com.google.android.exoplayer2.upstream.DefaultLoadErrorHandlingPolicy.DEFAULT_TRACK_BLACKLIST_MS || jCurrentTimeMillis - this.U_renamed < 3000 || jCurrentTimeMillis - this.V_renamed < 3000 || eo_renamed() || com.oplus.camera.ui.inverse.e_renamed.INS.isInverseColor(this.i_renamed.hashCode()) || w_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_BUBBLE_TYPE_AI_ENHANCEMENT_VIDEO) || dr_renamed() || this.t_renamed) {
            return false;
        }
        com.oplus.camera.e_renamed.a_renamed("CameraUIManager", "showLowAmbientLightHintView, showHintView.");
        this.W_renamed = jCurrentTimeMillis;
        a_renamed(com.oplus.camera.R_renamed.string.camera_ai_video_low_ambient_light_hint, -1, true, false, false, false, false, true, 5000, true);
        return true;
    }

    @Override // com.oplus.camera.ui.CameraUIInterface
    public boolean Y_renamed() {
        long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
        if (jCurrentTimeMillis - this.V_renamed <= com.google.android.exoplayer2.upstream.DefaultLoadErrorHandlingPolicy.DEFAULT_TRACK_BLACKLIST_MS || jCurrentTimeMillis - this.U_renamed < 3000 || jCurrentTimeMillis - this.W_renamed < 3000 || eo_renamed() || com.oplus.camera.ui.inverse.e_renamed.INS.isInverseColor(this.i_renamed.hashCode()) || w_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_BUBBLE_TYPE_AI_ENHANCEMENT_VIDEO) || dr_renamed()) {
            return false;
        }
        com.oplus.camera.e_renamed.a_renamed("CameraUIManager", "showBackLightHintView, showHintView.");
        this.V_renamed = jCurrentTimeMillis;
        this.cm_renamed.post(new java.lang.Runnable() { // from class: com.oplus.camera.ui.d_renamed.60
            @Override // java.lang.Runnable
            public void run() {
                if (com.oplus.camera.ui.d_renamed.this.aB_renamed == null || !com.oplus.camera.ui.d_renamed.this.aB_renamed.isShowing()) {
                    return;
                }
                com.oplus.camera.ui.d_renamed.this.aB_renamed.dismiss();
                com.oplus.camera.ui.d_renamed.this.aB_renamed = null;
                com.oplus.camera.ui.d_renamed.this.dh_renamed();
            }
        });
        a_renamed(com.oplus.camera.R_renamed.string.camera_ai_video_back_light_hint, -1, true, false, false, false, false, true, 5000, true);
        return true;
    }

    @Override // com.oplus.camera.ui.CameraUIInterface
    public boolean Z_renamed() {
        if (this.o_renamed || this.n_renamed) {
            com.oplus.camera.e_renamed.e_renamed("CameraUIManager", "showDirtyLensHintView, mbShowCapAlert or mbShowVideoAlert return");
            return false;
        }
        com.oplus.camera.ui.camerascreenhint.CameraScreenHintView cameraScreenHintView = this.am_renamed;
        if (cameraScreenHintView != null && cameraScreenHintView.isShown()) {
            com.oplus.camera.e_renamed.e_renamed("CameraUIManager", "showDirtyLensHintView, mbShowCapAlert return");
            return false;
        }
        a_renamed(com.oplus.camera.R_renamed.string.camera_toast_clean_lens_suggestion, -1, true, false, false);
        this.J_renamed.b_renamed(com.oplus.camera.statistics.model.ReminderMsgData.TYPE_ADVICE, com.oplus.camera.statistics.model.ReminderMsgData.CODE_CLEAN_LENS);
        return true;
    }

    public void j_renamed(int i_renamed, boolean z_renamed) {
        com.oplus.camera.ui.preview.a_renamed aVar = this.aH_renamed;
        if (aVar != null) {
            aVar.b_renamed(i_renamed, z_renamed);
        }
    }

    public boolean Q_renamed(int i_renamed) {
        com.oplus.camera.ui.preview.a_renamed aVar = this.aH_renamed;
        if (aVar != null) {
            return aVar.e_renamed(i_renamed);
        }
        return false;
    }

    @Override // com.oplus.camera.ui.CameraUIInterface
    public int aa_renamed() {
        com.oplus.camera.ui.preview.a_renamed aVar = this.aH_renamed;
        if (aVar != null) {
            return aVar.e_renamed();
        }
        return 67108863;
    }

    public boolean R_renamed(int i_renamed) {
        com.oplus.camera.ui.CameraUIListener cameraUIListener;
        if (i_renamed != 0) {
            if (i_renamed == 12) {
                java.lang.String string = this.B_renamed.getString(com.oplus.camera.ui.CameraUIInterface.KEY_FLASH_MODE, this.i_renamed.getString(com.oplus.camera.R_renamed.string.camera_flash_mode_default_value));
                return (android.text.TextUtils.equals("on_renamed", string) || android.text.TextUtils.equals(com.oplus.ocs.camera.CameraParameter.FlashMode.FLASH_TORCH, string) || ((cameraUIListener = this.J_renamed) != null && !cameraUIListener.X_renamed()) || android.text.TextUtils.equals("on_renamed", this.B_renamed.getString(com.oplus.camera.ui.CameraUIInterface.KEY_CAMERA_HDR_MODE, com.oplus.camera.aps.config.CameraConfig.getOptionKeyDefaultValue(com.oplus.camera.ui.CameraUIInterface.KEY_CAMERA_HDR_MODE, cv_renamed())))) ? false : true;
            }
            if (i_renamed == 4) {
                com.oplus.camera.ui.CameraUIListener cameraUIListener2 = this.J_renamed;
                if (cameraUIListener2 != null) {
                    return cameraUIListener2.X_renamed();
                }
                return true;
            }
            if (i_renamed != 5 && i_renamed != 18) {
                if (i_renamed != 19) {
                    return true;
                }
                if (!android.text.TextUtils.equals("off", this.B_renamed.getString(com.oplus.camera.ui.CameraUIInterface.KEY_CAMERA_HDR_MODE, com.oplus.camera.aps.config.CameraConfig.getOptionKeyDefaultValue(com.oplus.camera.ui.CameraUIInterface.KEY_CAMERA_HDR_MODE, cv_renamed())))) {
                    return false;
                }
                java.lang.String string2 = this.B_renamed.getString(com.oplus.camera.ui.CameraUIInterface.KEY_FLASH_MODE, this.i_renamed.getString(com.oplus.camera.R_renamed.string.camera_flash_mode_default_value));
                return (android.text.TextUtils.equals("on_renamed", string2) || android.text.TextUtils.equals(com.oplus.ocs.camera.CameraParameter.FlashMode.FLASH_TORCH, string2)) ? false : true;
            }
        }
        return false;
    }

    @Override // com.oplus.camera.ui.CameraUIInterface
    public void a_renamed(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        java.lang.String strB = com.oplus.camera.entry.b_renamed.b_renamed(str, this.K_renamed);
        com.oplus.camera.ui.menu.setting.o_renamed oVar = this.H_renamed;
        if (oVar != null) {
            oVar.a_renamed(strB, str2, str3);
        }
    }

    public void dU_renamed() {
        com.oplus.camera.ui.preview.a_renamed aVar = this.aH_renamed;
        if (aVar != null) {
            aVar.d_renamed();
        }
    }

    public void d_renamed(android.view.MotionEvent motionEvent) {
        com.oplus.camera.ui.menu.setting.f_renamed fVar;
        this.aH_renamed.a_renamed(motionEvent);
        if (motionEvent.getAction() == 0) {
            az_renamed(true);
        } else {
            if (3 != motionEvent.getAction() || (fVar = this.I_renamed) == null) {
                return;
            }
            fVar.d_renamed(false);
        }
    }

    public boolean e_renamed(android.view.MotionEvent motionEvent) {
        com.oplus.camera.ui.CameraUIListener cameraUIListener = this.J_renamed;
        if (cameraUIListener != null && com.oplus.camera.aps.constant.ApsConstant.CAPTURE_MODE_MULTI_VIDEO.equals(cameraUIListener.ao_renamed()) && com.oplus.camera.gl_renamed.b_renamed.e_renamed.a_renamed().b_renamed()) {
            return false;
        }
        if (2 == motionEvent.getPointerCount() || ((this.z_renamed.aA_renamed() && 1 == motionEvent.getPointerCount()) || 3 == motionEvent.getActionMasked() || motionEvent.getPointerId(motionEvent.getActionIndex()) == this.z_renamed.aB_renamed())) {
            com.oplus.camera.e_renamed.a_renamed("CameraUIManager", "handleDoubleFingerPic, PointerCount: " + motionEvent.getPointerCount() + ", Action: " + motionEvent.getActionMasked() + ", PointerId: " + motionEvent.getPointerId(motionEvent.getActionIndex()) + ", TouchPointId: " + this.z_renamed.aB_renamed());
            return this.z_renamed.a_renamed(motionEvent);
        }
        if (this.z_renamed.aA_renamed() && motionEvent.getPointerCount() >= 3) {
            return true;
        }
        com.oplus.camera.e_renamed.a_renamed("CameraUIManager", "handleDoubleFingerPic getPointerId: " + motionEvent.getPointerId(motionEvent.getActionIndex()) + " getTouchPointId: " + this.z_renamed.aB_renamed());
        return false;
    }

    public void a_renamed(java.lang.String str, java.lang.String str2, java.lang.String str3, int i_renamed, int i2, int i3) {
        com.oplus.camera.ui.menu.setting.o_renamed oVar = this.H_renamed;
        if (oVar != null) {
            oVar.a_renamed(str, str2, str3, i_renamed, i2, i3);
        }
    }

    public void u_renamed(java.lang.String str) {
        com.oplus.camera.ui.menu.setting.o_renamed oVar = this.H_renamed;
        if (oVar != null) {
            oVar.h_renamed(str);
        }
    }

    public boolean v_renamed(java.lang.String str) {
        com.oplus.camera.ui.menu.setting.o_renamed oVar = this.H_renamed;
        if (oVar != null) {
            return oVar.i_renamed(str);
        }
        return false;
    }

    public void a_renamed(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, int i_renamed, int i2) {
        com.oplus.camera.ui.menu.setting.o_renamed oVar = this.H_renamed;
        if (oVar != null) {
            oVar.a_renamed(str, str2, str3, str4, i_renamed, i2);
        }
    }

    @Override // com.oplus.camera.ui.CameraUIInterface
    public void a_renamed(java.lang.String str, boolean z_renamed, int i_renamed, int i2) {
        com.oplus.camera.ui.menu.setting.o_renamed oVar = this.H_renamed;
        if (oVar != null) {
            oVar.a_renamed(str, z_renamed, i_renamed, i2);
        }
        com.oplus.camera.ui.menu.setting.f_renamed fVar = this.I_renamed;
        if (fVar != null) {
            fVar.a_renamed(str, z_renamed, i_renamed, i2);
        }
    }

    public boolean dV_renamed() {
        return this.bE_renamed;
    }

    @Override // com.oplus.camera.ui.CameraUIInterface
    public void M_renamed() {
        com.oplus.camera.e_renamed.b_renamed("CameraUIManager", "showVideoEisHint");
        if (this.Z_renamed == null || this.p_renamed || "off".equals(this.B_renamed.getString(com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_SUPER_EIS_MENU, "off"))) {
            return;
        }
        this.bE_renamed = true;
        int iF = (j_renamed(com.oplus.camera.aps.config.CameraFunction.KEY_VIDEO_SUPER_EIS_WIDE) && this.B_renamed.getBoolean(com.oplus.camera.ui.CameraUIInterface.KEY_SUPER_EIS_WIDE, false)) ? com.oplus.camera.util.Util.f_renamed(com.oplus.camera.R_renamed.string.camera_super_eis_pro) : com.oplus.camera.R_renamed.string.camera_super_eis;
        if (aU_renamed()) {
            ab_renamed();
        }
        a_renamed(true, false, false);
        b_renamed(iF, com.oplus.camera.R_renamed.drawable.screen_hint_textview_bg, com.oplus.camera.R_renamed.color.screen_hint_text_color, new java.lang.Object[0]);
    }

    @Override // com.oplus.camera.ui.CameraUIInterface
    public void N_renamed() {
        com.oplus.camera.e_renamed.b_renamed("CameraUIManager", "hideVideoEisHint");
        if (this.Z_renamed == null) {
            com.oplus.camera.e_renamed.f_renamed("CameraUIManager", "hideVideoEisHint, mCameraRootView is_renamed null");
            return;
        }
        this.bE_renamed = false;
        a_renamed(com.oplus.camera.util.Util.f_renamed(com.oplus.camera.R_renamed.string.camera_super_eis_pro));
        a_renamed(com.oplus.camera.R_renamed.string.camera_super_eis);
    }

    public void ax_renamed(boolean z_renamed) {
        com.oplus.camera.ui.preview.g_renamed gVar = this.A_renamed;
        if (gVar != null) {
            gVar.l_renamed(z_renamed);
        }
    }

    public boolean dW_renamed() {
        com.oplus.camera.ui.CameraUIListener cameraUIListener = this.J_renamed;
        return cameraUIListener != null && cameraUIListener.bd_renamed();
    }

    @Override // com.oplus.camera.ui.preview.g_renamed.b_renamed
    public boolean dX_renamed() {
        com.oplus.camera.ui.CameraUIListener cameraUIListener = this.J_renamed;
        return cameraUIListener != null && cameraUIListener.be_renamed();
    }

    @Override // com.oplus.camera.ui.preview.g_renamed.b_renamed
    public boolean dY_renamed() {
        com.oplus.camera.ui.CameraUIListener cameraUIListener = this.J_renamed;
        return cameraUIListener != null && cameraUIListener.bh_renamed();
    }

    @Override // com.oplus.camera.ui.preview.g_renamed.b_renamed
    public boolean dZ_renamed() {
        com.oplus.camera.ComboPreferences comboPreferences;
        return dY_renamed() && (comboPreferences = this.B_renamed) != null && comboPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_FILM_VIDEO_GUIDE_LINE, "off").equals("grid");
    }

    @Override // com.oplus.camera.ui.preview.g_renamed.b_renamed
    public float ea_renamed() {
        com.oplus.camera.ui.CameraUIListener cameraUIListener = this.J_renamed;
        if (cameraUIListener != null) {
            return cameraUIListener.bi_renamed();
        }
        return 1.0f;
    }

    @Override // com.oplus.camera.ui.preview.g_renamed.b_renamed
    public boolean eb_renamed() {
        com.oplus.camera.ui.CameraUIListener cameraUIListener = this.J_renamed;
        return cameraUIListener != null && cameraUIListener.bj_renamed();
    }

    @Override // com.oplus.camera.ui.preview.g_renamed.b_renamed
    public void S_renamed(int i_renamed) {
        com.oplus.camera.e_renamed.b_renamed("CameraUIManager", "onMultiCameraTypeChanged: " + i_renamed);
        if (this.J_renamed != null) {
            ak_renamed(i_renamed);
            this.J_renamed.onMultiCameraTypeChanged(i_renamed);
        }
    }

    private void ak_renamed(int i_renamed) {
        com.oplus.camera.statistics.model.MenuClickMsgData menuClickMsgData = new com.oplus.camera.statistics.model.MenuClickMsgData(this.i_renamed);
        menuClickMsgData.buildEvent(true);
        menuClickMsgData.mCaptureMode = this.J_renamed.ao_renamed();
        menuClickMsgData.mCameraId = this.J_renamed.I_renamed();
        menuClickMsgData.mFuncKeyId = 54;
        menuClickMsgData.mItemValue = java.lang.String.valueOf(i_renamed);
        menuClickMsgData.mCaptureType = !this.J_renamed.B_renamed() ? 1 : 0;
        menuClickMsgData.report();
    }

    @Override // com.oplus.camera.ui.preview.g_renamed.b_renamed
    public boolean ec_renamed() {
        com.oplus.camera.ui.CameraUIListener cameraUIListener = this.J_renamed;
        return cameraUIListener != null && cameraUIListener.bq_renamed();
    }

    @Override // com.oplus.camera.ui.preview.g_renamed.b_renamed
    public void a_renamed(com.oplus.camera.doubleexposure.f_renamed fVar) {
        com.oplus.camera.ui.CameraUIListener cameraUIListener = this.J_renamed;
        if (cameraUIListener != null) {
            cameraUIListener.a_renamed(fVar);
        }
    }

    @Override // com.oplus.camera.ui.preview.g_renamed.b_renamed
    public boolean ed_renamed() {
        com.oplus.camera.ui.CameraUIListener cameraUIListener = this.J_renamed;
        if (cameraUIListener != null) {
            return cameraUIListener.bA_renamed();
        }
        return true;
    }

    @Override // com.oplus.camera.ui.preview.g_renamed.b_renamed
    public void ee_renamed() {
        com.oplus.camera.ui.CameraUIListener cameraUIListener = this.J_renamed;
        if (cameraUIListener != null) {
            cameraUIListener.bC_renamed();
        }
    }

    @Override // com.oplus.camera.ui.preview.g_renamed.b_renamed
    public void ef_renamed() {
        com.oplus.camera.ui.CameraUIListener cameraUIListener = this.J_renamed;
        if (cameraUIListener != null) {
            cameraUIListener.bD_renamed();
        }
    }

    @Override // com.oplus.camera.ui.preview.g_renamed.b_renamed
    public void eg_renamed() {
        if (this.bD_renamed) {
            eO_renamed();
            this.bD_renamed = false;
        }
    }

    @Override // com.oplus.camera.ui.preview.g_renamed.b_renamed
    public void eh_renamed() {
        com.oplus.camera.ui.CameraUIListener cameraUIListener = this.J_renamed;
        if (cameraUIListener != null) {
            cameraUIListener.bH_renamed();
        }
    }

    @Override // com.oplus.camera.ui.preview.g_renamed.b_renamed
    public android.widget.RelativeLayout.LayoutParams e_renamed(android.util.Size size) {
        return this.l_renamed.a_renamed().a_renamed(size);
    }

    @Override // com.oplus.camera.ui.CameraUIInterface, com.oplus.camera.ui.preview.g_renamed.b_renamed
    public int aX_renamed() {
        return this.l_renamed.a_renamed().j_renamed();
    }

    @Override // com.oplus.camera.ui.preview.g_renamed.b_renamed
    public int ei_renamed() {
        return this.l_renamed.a_renamed().k_renamed();
    }

    @Override // com.oplus.camera.ui.preview.g_renamed.b_renamed
    public com.oplus.camera.screen.b_renamed.a_renamed ej_renamed() {
        return this.l_renamed.a_renamed();
    }

    @Override // com.oplus.camera.ui.preview.g_renamed.b_renamed
    public int[] a_renamed(android.util.Size size, android.util.Size size2) {
        return this.l_renamed.a_renamed().a_renamed(size, size2);
    }

    public android.graphics.Rect k_renamed(int i_renamed, int i2) {
        return this.l_renamed.a_renamed().b_renamed(i_renamed, i2);
    }

    @Override // com.oplus.camera.ui.preview.g_renamed.b_renamed
    public void ek_renamed() {
        com.oplus.camera.ui.CameraUIListener cameraUIListener = this.J_renamed;
        if (cameraUIListener != null) {
            cameraUIListener.bX_renamed();
        }
    }

    @Override // com.oplus.camera.ui.CameraUIInterface
    public void r_renamed(int i_renamed) {
        b_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_MULTI_CAMERA_TYPE_MENU, "on_renamed".equals(this.B_renamed.getString(com.oplus.camera.ui.CameraUIInterface.KEY_MULTI_CAMERA_TYPE_MENU, this.i_renamed.getString(com.oplus.camera.R_renamed.string.camera_multicamera_type_default))) ? com.oplus.camera.R_renamed.drawable.multi_video_type_menu_selected : com.oplus.camera.R_renamed.drawable.multi_video_type_menu_normal);
    }

    public boolean em_renamed() {
        com.oplus.camera.ui.menu.setting.f_renamed fVar = this.I_renamed;
        if (fVar != null) {
            return fVar.o_renamed();
        }
        return false;
    }

    public boolean en_renamed() {
        com.oplus.camera.ui.widget.c_renamed cVar = this.aw_renamed;
        if (cVar != null) {
            return cVar.isShowing();
        }
        return false;
    }

    public boolean eo_renamed() {
        com.oplus.camera.ui.menu.setting.f_renamed fVar = this.I_renamed;
        return fVar != null && fVar.t_renamed();
    }

    public boolean ep_renamed() {
        com.oplus.camera.ui.menu.setting.f_renamed fVar = this.I_renamed;
        if (fVar != null) {
            return fVar.K_renamed().isEmpty();
        }
        return true;
    }

    public boolean eq_renamed() {
        com.oplus.camera.ui.menu.setting.f_renamed fVar = this.I_renamed;
        if (fVar != null) {
            return fVar.p_renamed();
        }
        return false;
    }

    public boolean er_renamed() {
        com.oplus.camera.ui.menu.setting.f_renamed fVar = this.I_renamed;
        if (fVar != null) {
            return fVar.q_renamed();
        }
        return false;
    }

    public void es_renamed() {
        com.oplus.camera.ui.menu.setting.f_renamed fVar = this.I_renamed;
        if (fVar != null) {
            fVar.m_renamed();
        }
    }

    @Override // com.oplus.camera.ui.CameraUIInterface
    public void aB_renamed() {
        com.oplus.camera.ui.control.a_renamed aVar = this.z_renamed;
        if (aVar != null) {
            aVar.al_renamed();
        }
    }

    @Override // com.oplus.camera.ui.CameraUIInterface
    public void D_renamed(boolean z_renamed) {
        int configIntValue;
        com.oplus.camera.e_renamed.b_renamed("CameraUIManager", "showSlowVideoModeSeekBar, needAnimation: " + z_renamed);
        if (this.p_renamed || "off".equals(this.B_renamed.getString(com.oplus.camera.ui.CameraUIInterface.KEY_SLOW_VIDEO_FRAME_SEEK_BAR_MENU, this.i_renamed.getString(com.oplus.camera.R_renamed.string.camera_slow_video_mode_frame_default_value))) || R_renamed()) {
            return;
        }
        if (this.bh_renamed == null) {
            this.bh_renamed = new com.oplus.camera.ui.widget.b_renamed(this.i_renamed);
            this.bh_renamed.setOnTouchListener(new android.view.View.OnTouchListener() { // from class: com.oplus.camera.ui.d_renamed.61
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(android.view.View view, android.view.MotionEvent motionEvent) {
                    if (com.oplus.camera.ui.d_renamed.this.cm_renamed == null || com.oplus.camera.ui.d_renamed.this.p_renamed) {
                        return false;
                    }
                    com.oplus.camera.ui.d_renamed.this.cm_renamed.removeMessages(4);
                    com.oplus.camera.ui.d_renamed.this.cm_renamed.sendMessageDelayed(com.oplus.camera.ui.d_renamed.this.cm_renamed.obtainMessage(4), com.google.android.exoplayer2.DefaultRenderersFactory.DEFAULT_ALLOWED_VIDEO_JOINING_TIME_MS);
                    return false;
                }
            });
            this.bh_renamed.setModeFrameChangeListener(new com.oplus.camera.ui.d_renamed.b_renamed());
            java.util.ArrayList arrayList = new java.util.ArrayList();
            arrayList.add(new com.oplus.camera.ui.widget.b_renamed.a_renamed(120, this.i_renamed.getString(com.oplus.camera.R_renamed.string.camera_intelligent_high_frame_slow_1080p)));
            arrayList.add(new com.oplus.camera.ui.widget.b_renamed.a_renamed(240, this.i_renamed.getString(com.oplus.camera.R_renamed.string.camera_intelligent_high_frame_slow_720p)));
            arrayList.add(new com.oplus.camera.ui.widget.b_renamed.a_renamed(com.oplus.ocs.camera.CameraParameter.VideoFps.FPS_480, this.i_renamed.getString(com.oplus.camera.R_renamed.string.camera_intelligent_high_frame_super_1080p)));
            arrayList.add(new com.oplus.camera.ui.widget.b_renamed.a_renamed(com.oplus.ocs.camera.CameraParameter.VideoFps.FPS_960, this.i_renamed.getString(com.oplus.camera.R_renamed.string.camera_intelligent_high_frame_super_720p)));
            this.bh_renamed.setFrameList(arrayList);
        }
        java.lang.String string = this.B_renamed.getString(com.oplus.camera.ui.CameraUIInterface.KEY_SLOW_VIDEO_SIZE, com.oplus.camera.util.Util.o_renamed(cv_renamed()));
        if ("video_size_1080p".equals(string)) {
            configIntValue = com.oplus.camera.aps.config.CameraConfig.getConfigIntValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_SLOW_VIDEO_1080P_DEFAULT_VALUE);
        } else {
            configIntValue = "video_size_720p".equals(string) ? com.oplus.camera.aps.config.CameraConfig.getConfigIntValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_SLOW_VIDEO_720P_DEFAULT_VALUE) : 0;
        }
        this.bh_renamed.a_renamed(this.B_renamed.getInt(com.oplus.camera.ui.CameraUIInterface.KEY_SLOW_VIDEO_REAR_FPS, configIntValue));
        this.bh_renamed.a_renamed(this.L_renamed, false);
        android.widget.RelativeLayout relativeLayoutY = this.A_renamed.y_renamed();
        int dimensionPixelSize = this.i_renamed.getApplication().getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.slow_video_seekbar_width);
        int dimensionPixelSize2 = this.i_renamed.getApplication().getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.slow_video_seekbar_height);
        int height = relativeLayoutY.getHeight() - (this.z_renamed.U_renamed().getTop() - relativeLayoutY.getTop());
        android.widget.RelativeLayout.LayoutParams layoutParams = new android.widget.RelativeLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize2);
        layoutParams.addRule(14);
        layoutParams.addRule(12);
        layoutParams.setMargins(0, 0, 0, height);
        this.bh_renamed.setLayoutParams(layoutParams);
        if (relativeLayoutY.indexOfChild(this.bh_renamed) < 0) {
            relativeLayoutY.addView(this.bh_renamed, relativeLayoutY.indexOfChild(relativeLayoutY.findViewById(com.oplus.camera.R_renamed.id_renamed.slow_video_motion_detect_view)) - 1);
        }
        if (z_renamed) {
            com.oplus.camera.util.Util.a_renamed(this.bh_renamed, 0, (android.view.animation.Animation.AnimationListener) null, 300L);
        } else {
            this.bh_renamed.setVisibility(0);
        }
        this.cm_renamed.removeMessages(4);
        this.cm_renamed.sendMessageDelayed(this.cm_renamed.obtainMessage(4), com.google.android.exoplayer2.DefaultRenderersFactory.DEFAULT_ALLOWED_VIDEO_JOINING_TIME_MS);
        this.z_renamed.r_renamed(false);
    }

    @Override // com.oplus.camera.ui.CameraUIInterface
    public void C_renamed(boolean z_renamed) {
        com.oplus.camera.ui.widget.b_renamed bVar;
        com.oplus.camera.e_renamed.b_renamed("CameraUIManager", "hideSlowVideoModeSeekBar, needAnimation: " + z_renamed);
        this.cm_renamed.removeMessages(4);
        if (this.Z_renamed != null && (bVar = this.bh_renamed) != null) {
            if (z_renamed) {
                com.oplus.camera.util.Util.a_renamed(bVar, 8, (android.view.animation.Animation.AnimationListener) null, 300L);
            } else {
                bVar.setVisibility(8);
            }
            this.Z_renamed.removeView(this.bh_renamed);
        }
        this.z_renamed.r_renamed(true);
    }

    public void et_renamed() {
        com.oplus.camera.e_renamed.b_renamed("CameraUIManager", "hideSlowVideoSeekBarBySharedPreference");
        this.B_renamed.edit().putString(com.oplus.camera.ui.CameraUIInterface.KEY_SLOW_VIDEO_FRAME_SEEK_BAR_MENU, "off").apply();
        f_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_SLOW_VIDEO_FRAME_SEEK_BAR_MENU);
    }

    public boolean eu_renamed() {
        com.oplus.camera.ui.widget.b_renamed bVar = this.bh_renamed;
        return bVar != null && bVar.getVisibility() == 0;
    }

    /* compiled from: CameraUIManager.java */
    private class b_renamed implements com.oplus.camera.ui.widget.b_renamed.SlowVideoModeSeekBar_2 {
        private boolean a_renamed(int i_renamed) {
            return 480 == i_renamed || 960 == i_renamed;
        }

        private b_renamed() {
        }

        @Override // com.oplus.camera.ui.widget.b_renamed.SlowVideoModeSeekBar_2
        public void onSlowVideoFrameChange(int i_renamed) {
            com.oplus.camera.e_renamed.b_renamed("CameraUIManager", "onFrameChange, frame: " + i_renamed);
            if (com.oplus.camera.ui.d_renamed.this.dW_renamed()) {
                com.oplus.camera.ui.d_renamed.this.p_renamed(i_renamed);
            }
            com.oplus.camera.ui.d_renamed.this.J_renamed.j_renamed(i_renamed);
            java.lang.String string = com.oplus.camera.ui.d_renamed.this.B_renamed.getString(com.oplus.camera.ui.CameraUIInterface.KEY_INTELLIGENT_HIGH_FRAME_SELECTED, com.oplus.camera.ui.d_renamed.this.i_renamed.getString(com.oplus.camera.R_renamed.string.camera_intelligent_high_frame_default_selected));
            java.lang.String string2 = com.oplus.camera.ui.d_renamed.this.B_renamed.getString(com.oplus.camera.ui.CameraUIInterface.KEY_TEMP_INTELLIGENT_HIGH_FRAME_SELECTED, "");
            if (a_renamed(i_renamed)) {
                if (!android.text.TextUtils.isEmpty(string2)) {
                    com.oplus.camera.ui.d_renamed.this.b_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_INTELLIGENT_HIGH_FRAME_SELECTED, string2);
                } else {
                    com.oplus.camera.ui.d_renamed.this.b_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_INTELLIGENT_HIGH_FRAME_SELECTED, string);
                    com.oplus.camera.ui.d_renamed.this.B_renamed.edit().putString(com.oplus.camera.ui.CameraUIInterface.KEY_TEMP_INTELLIGENT_HIGH_FRAME_SELECTED, string).apply();
                }
            } else {
                if (!android.text.TextUtils.isEmpty(string2)) {
                    com.oplus.camera.ui.d_renamed.this.B_renamed.edit().putString(com.oplus.camera.ui.CameraUIInterface.KEY_INTELLIGENT_HIGH_FRAME_SELECTED, "off").apply();
                }
                com.oplus.camera.ui.d_renamed.this.a_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_INTELLIGENT_HIGH_FRAME_SELECTED, "off");
            }
            com.oplus.camera.ui.d_renamed.this.a_renamed(false);
        }
    }

    @Override // com.oplus.camera.ui.CameraUIInterface
    public void p_renamed(int i_renamed) {
        int i2;
        int i3 = com.oplus.camera.R_renamed.string.camera_intelligent_high_frame_super_selected;
        if (120 == i_renamed) {
            i2 = com.oplus.camera.R_renamed.drawable.frame_120;
        } else {
            if (240 != i_renamed) {
                if (480 == i_renamed) {
                    i2 = com.oplus.camera.R_renamed.drawable.frame_480;
                } else if (960 == i_renamed) {
                    i2 = com.oplus.camera.R_renamed.drawable.frame_960;
                } else {
                    i3 = -1;
                    i2 = 0;
                }
                b_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_SLOW_VIDEO_FRAME_SEEK_BAR_MENU, i2);
                b_renamed(i3, com.oplus.camera.R_renamed.drawable.screen_hint_textview_bg, com.oplus.camera.R_renamed.color.screen_hint_text_color, new java.lang.Object[0]);
            }
            i2 = com.oplus.camera.R_renamed.drawable.frame_240;
        }
        i3 = com.oplus.camera.R_renamed.string.camera_intelligent_high_frame_slow_selected;
        b_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_SLOW_VIDEO_FRAME_SEEK_BAR_MENU, i2);
        b_renamed(i3, com.oplus.camera.R_renamed.drawable.screen_hint_textview_bg, com.oplus.camera.R_renamed.color.screen_hint_text_color, new java.lang.Object[0]);
    }

    @Override // com.oplus.camera.ui.CameraUIInterface
    public void o_renamed(int i_renamed) {
        if (this.A_renamed != null) {
            if (i_renamed == 0 && R_renamed()) {
                return;
            }
            this.A_renamed.g_renamed(i_renamed);
        }
    }

    @Override // com.oplus.camera.ui.CameraUIInterface
    public void E_renamed(boolean z_renamed) {
        com.oplus.camera.ui.preview.g_renamed gVar = this.A_renamed;
        if (gVar != null) {
            gVar.p_renamed(z_renamed);
        }
    }

    @Override // com.oplus.camera.ui.CameraUIInterface
    public android.graphics.RectF q_renamed(int i_renamed) {
        com.oplus.camera.ui.preview.g_renamed gVar = this.A_renamed;
        if (gVar != null) {
            return gVar.h_renamed(i_renamed);
        }
        return null;
    }

    @Override // com.oplus.camera.ui.CameraUIInterface
    public com.oplus.camera.ui.menu.setting.CameraMenuOption h_renamed(java.lang.String str) {
        return this.H_renamed.g_renamed(str);
    }

    @Override // com.oplus.camera.ui.preview.g_renamed.b_renamed
    public void l_renamed(int i_renamed, int i2) {
        com.oplus.camera.ui.CameraUIListener cameraUIListener = this.J_renamed;
        if (cameraUIListener != null) {
            cameraUIListener.d_renamed(i_renamed, i2);
        }
    }

    @Override // com.oplus.camera.ui.preview.g_renamed.b_renamed
    public boolean m_renamed(int i_renamed, int i2) {
        com.oplus.camera.ui.CameraUIListener cameraUIListener = this.J_renamed;
        return cameraUIListener != null && cameraUIListener.e_renamed(i_renamed, i2);
    }

    public boolean w_renamed(java.lang.String str) {
        com.oplus.camera.ComboPreferences comboPreferences = this.B_renamed;
        if (comboPreferences == null) {
            com.oplus.camera.e_renamed.f_renamed("CameraUIManager", "isBubbleOpen, mPreference null");
            return false;
        }
        return comboPreferences.getBoolean(str, true);
    }

    @Override // com.oplus.camera.ui.CameraUIInterface
    public void J_renamed(boolean z_renamed) {
        com.oplus.camera.e_renamed.b_renamed("CameraUIManager", "hideMultiCameraTypeLayoutBySharedPreference, needZoom: " + z_renamed);
        com.oplus.camera.ComboPreferences comboPreferences = this.B_renamed;
        if (comboPreferences != null) {
            android.content.SharedPreferences.Editor editorEdit = comboPreferences.edit();
            editorEdit.putString(com.oplus.camera.ui.CameraUIInterface.KEY_MULTI_CAMERA_TYPE_MENU_NEED_SHOW_ZOOM, z_renamed ? "on_renamed" : "off");
            editorEdit.putString(com.oplus.camera.ui.CameraUIInterface.KEY_MULTI_CAMERA_TYPE_MENU, "off");
            editorEdit.apply();
        }
        f_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_MULTI_CAMERA_TYPE_MENU);
    }

    @Override // com.oplus.camera.ui.CameraUIInterface
    public boolean aA_renamed() {
        com.oplus.camera.ui.preview.g_renamed gVar = this.A_renamed;
        return gVar != null && gVar.ag_renamed();
    }

    public boolean ev_renamed() {
        com.oplus.camera.ui.preview.g_renamed gVar = this.A_renamed;
        return gVar != null && gVar.ah_renamed();
    }

    public boolean ew_renamed() {
        com.oplus.camera.ui.preview.g_renamed gVar = this.A_renamed;
        return gVar != null && gVar.ai_renamed();
    }

    public boolean ex_renamed() {
        com.oplus.camera.timelapsepro.g_renamed gVar = this.bP_renamed;
        return gVar != null && gVar.getVisibility() == 0;
    }

    @Override // com.oplus.camera.ui.CameraUIInterface
    public void c_renamed(int i_renamed, int i2) {
        com.oplus.camera.ui.preview.h_renamed hVarC = c_renamed();
        if (hVarC != null) {
            hVarC.e_renamed(i_renamed, i2);
        }
    }

    @Override // com.oplus.camera.ui.CameraUIInterface
    public android.graphics.Rect az_renamed() {
        com.oplus.camera.ui.preview.h_renamed hVarC = c_renamed();
        if (hVarC != null) {
            return hVarC.B_renamed();
        }
        return null;
    }

    @Override // com.oplus.camera.ui.CameraUIInterface
    public void s_renamed(int i_renamed) {
        com.oplus.camera.ui.preview.h_renamed hVarC = c_renamed();
        if (hVarC != null) {
            hVarC.e_renamed(i_renamed);
        }
    }

    @Override // com.oplus.camera.ui.CameraUIInterface
    public void H_renamed(boolean z_renamed) {
        com.oplus.camera.ui.preview.h_renamed hVarC = c_renamed();
        if (hVarC != null) {
            hVarC.o_renamed(z_renamed);
        }
    }

    @Override // com.oplus.camera.ui.CameraUIInterface
    public void d_renamed(int i_renamed, int i2) {
        com.oplus.camera.ui.preview.h_renamed hVarC = c_renamed();
        if (hVarC != null) {
            hVarC.d_renamed(i_renamed, i2);
        }
    }

    @Override // com.oplus.camera.ui.CameraUIInterface
    public void I_renamed(boolean z_renamed) {
        com.oplus.camera.ui.preview.g_renamed gVar = this.A_renamed;
        if (gVar == null || gVar.x_renamed() == null) {
            return;
        }
        this.A_renamed.x_renamed().h_renamed(z_renamed);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean al_renamed(int i_renamed) throws android.content.res.Resources.NotFoundException, android.content.pm.PackageManager.NameNotFoundException {
        if (dF_renamed()) {
            com.oplus.camera.e_renamed.a_renamed("CameraUIManager", "onModeItemClick, headline is_renamed scrolling, can't_renamed response");
            return true;
        }
        if (17 == i_renamed) {
            this.C_renamed.a_renamed(this.i_renamed, this.J_renamed, this.L_renamed);
            this.C_renamed.a_renamed(cv_renamed(), this.J_renamed.bc_renamed().w_renamed());
            return true;
        }
        java.lang.String strJ = com.oplus.camera.l_renamed.c_renamed.j_renamed();
        if (9 != i_renamed || android.text.TextUtils.isEmpty(strJ) || !com.oplus.camera.util.f_renamed.a_renamed(this.i_renamed, strJ)) {
            return false;
        }
        com.oplus.camera.util.f_renamed.a_renamed(this.i_renamed, com.oplus.camera.util.Util.ak_renamed() ? com.oplus.camera.R_renamed.string.camera_disable_smart_scan : com.oplus.camera.R_renamed.string.camera_disable_scan, strJ, this.i_renamed.getApplication().getResources().getString(com.oplus.camera.R_renamed.string.camera_mode_breeno_scan));
        return true;
    }

    @Override // com.oplus.camera.ui.CameraUIInterface
    public void w_renamed() {
        com.oplus.camera.ui.control.a_renamed aVar = this.z_renamed;
        if (aVar != null) {
            aVar.am_renamed();
        }
    }

    public void ey_renamed() {
        com.oplus.camera.ui.preview.ae_renamed aeVar = this.D_renamed;
        if (aeVar != null) {
            aeVar.a_renamed(false, dY_renamed());
        }
    }

    public void ez_renamed() {
        com.oplus.camera.j_renamed.a_renamed aVar = this.bg_renamed;
        if (aVar != null) {
            aVar.b_renamed();
        }
    }

    @Override // com.oplus.camera.ui.CameraUIInterface
    public boolean aG_renamed() {
        return this.bo_renamed;
    }

    public void az_renamed(boolean z_renamed) {
        this.bo_renamed = z_renamed;
    }

    @Override // com.oplus.camera.ui.CameraUIInterface
    public void aJ_renamed() {
        this.bp_renamed = false;
        this.bq_renamed = false;
        this.br_renamed = false;
        this.i_renamed.runOnUiThread(new java.lang.Runnable() { // from class: com.oplus.camera.ui.-$$Lambda$d_renamed$_HVzvEg9xwHWq-68woFBN4oIRQw
            @Override // java.lang.Runnable
            public final void run() {
                this.f_renamed$0.gw_renamed();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void gw_renamed() {
        android.app.Activity activity = this.i_renamed;
        if (activity == null || activity.isFinishing()) {
            return;
        }
        this.z_renamed.C_renamed();
        this.A_renamed.ao_renamed();
        this.J_renamed.b_renamed(false, true);
        z_renamed(false);
    }

    @Override // com.oplus.camera.ui.CameraUIInterface
    public void aH_renamed() {
        this.bp_renamed = false;
        this.br_renamed = false;
        this.i_renamed.runOnUiThread(new java.lang.Runnable() { // from class: com.oplus.camera.ui.-$$Lambda$d_renamed$BPMFGbelw_AqB0T4c8TqzzGDM_Y
            @Override // java.lang.Runnable
            public final void run() throws android.content.res.Resources.NotFoundException {
                this.f_renamed$0.gv_renamed();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void gv_renamed() throws android.content.res.Resources.NotFoundException {
        this.z_renamed.z_renamed();
        this.A_renamed.a_renamed(this.J_renamed.bz_renamed(), (android.view.View) this.A_renamed.ap_renamed(), true);
    }

    @Override // com.oplus.camera.ui.CameraUIInterface
    public void aI_renamed() {
        this.bp_renamed = false;
        this.br_renamed = false;
        this.i_renamed.runOnUiThread(new java.lang.Runnable() { // from class: com.oplus.camera.ui.-$$Lambda$d_renamed$84HDrIPoQg2Utp6Oij03Lgeh9U4
            @Override // java.lang.Runnable
            public final void run() throws android.content.res.Resources.NotFoundException {
                this.f_renamed$0.gu_renamed();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void gu_renamed() throws android.content.res.Resources.NotFoundException {
        this.z_renamed.B_renamed();
        this.A_renamed.a_renamed(this.J_renamed.bz_renamed(), (android.view.View) this.A_renamed.ap_renamed(), false);
        z_renamed(true);
    }

    @Override // com.oplus.camera.ui.CameraUIInterface
    public void aK_renamed() {
        this.bp_renamed = true;
        this.bq_renamed = false;
        this.br_renamed = false;
        this.i_renamed.runOnUiThread(new java.lang.Runnable() { // from class: com.oplus.camera.ui.-$$Lambda$d_renamed$DeAAmLRIrT7iXx3RTeFcoyj2twY
            @Override // java.lang.Runnable
            public final void run() throws android.content.res.Resources.NotFoundException {
                this.f_renamed$0.gt_renamed();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void gt_renamed() throws android.content.res.Resources.NotFoundException {
        android.app.Activity activity = this.i_renamed;
        if (activity == null || activity.isFinishing()) {
            return;
        }
        this.z_renamed.A_renamed();
        if (this.J_renamed.aq_renamed()) {
            c_renamed(true, 0);
        } else {
            a_renamed(8, 1);
        }
        com.oplus.camera.ui.preview.g_renamed gVar = this.A_renamed;
        gVar.a_renamed((android.view.View) gVar.ap_renamed(), this.J_renamed.bz_renamed(), true);
        z_renamed(false);
    }

    @Override // com.oplus.camera.ui.CameraUIInterface
    public void aL_renamed() {
        this.bq_renamed = true;
        this.br_renamed = true;
        this.i_renamed.runOnUiThread(new java.lang.Runnable() { // from class: com.oplus.camera.ui.-$$Lambda$d_renamed$dCHE2cY7luTltsp8m1qeWKaLNgg
            @Override // java.lang.Runnable
            public final void run() throws android.content.res.Resources.NotFoundException {
                this.f_renamed$0.gs_renamed();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void gs_renamed() throws android.content.res.Resources.NotFoundException {
        this.z_renamed.D_renamed();
        if (this.J_renamed.aq_renamed()) {
            o_renamed(this.i_renamed.getString(com.oplus.camera.ui.menu.a_renamed.c_renamed.a_renamed(this.J_renamed.ao_renamed())));
            b_renamed(true, 0);
        } else {
            a_renamed(0, 1);
        }
        this.A_renamed.a_renamed(this.J_renamed.bz_renamed(), (android.view.View) this.A_renamed.ap_renamed(), true);
        z_renamed(true);
    }

    @Override // com.oplus.camera.ui.CameraUIInterface
    public void M_renamed(final boolean z_renamed) {
        this.i_renamed.runOnUiThread(new java.lang.Runnable() { // from class: com.oplus.camera.ui.-$$Lambda$d_renamed$mUqc7XiBA4_EbimhnqvUfzSjPYE
            @Override // java.lang.Runnable
            public final void run() throws android.content.res.Resources.NotFoundException {
                this.f_renamed$0.aQ_renamed(z_renamed);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void aQ_renamed(boolean z_renamed) throws android.content.res.Resources.NotFoundException {
        this.z_renamed.E_renamed();
        this.A_renamed.a_renamed(z_renamed ? this.J_renamed.bz_renamed() : this.A_renamed.ap_renamed(), !z_renamed ? this.J_renamed.bz_renamed() : this.A_renamed.ap_renamed(), true);
    }

    @Override // com.oplus.camera.ui.CameraUIInterface
    public void aM_renamed() {
        this.bp_renamed = false;
        this.bq_renamed = true;
        this.br_renamed = true;
        this.i_renamed.runOnUiThread(new java.lang.Runnable() { // from class: com.oplus.camera.ui.-$$Lambda$d_renamed$sgqQwMztWCXibyma-J3Ojbb1Wk8
            @Override // java.lang.Runnable
            public final void run() throws android.content.res.Resources.NotFoundException {
                this.f_renamed$0.gr_renamed();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void gr_renamed() throws android.content.res.Resources.NotFoundException {
        this.z_renamed.F_renamed();
        if (this.J_renamed.aq_renamed()) {
            b_renamed(true, 0);
        } else {
            a_renamed(0, 1);
        }
        this.A_renamed.a_renamed(this.J_renamed.bz_renamed(), (android.view.View) this.A_renamed.ap_renamed(), true);
        z_renamed(false);
    }

    @Override // com.oplus.camera.ui.CameraUIInterface
    public void aN_renamed() {
        this.bp_renamed = true;
        this.bq_renamed = false;
        this.br_renamed = false;
        this.i_renamed.runOnUiThread(new java.lang.Runnable() { // from class: com.oplus.camera.ui.-$$Lambda$d_renamed$1dn8rKs0GZ_ruqbH6rUL7Qat_Cw
            @Override // java.lang.Runnable
            public final void run() throws android.content.res.Resources.NotFoundException {
                this.f_renamed$0.gq_renamed();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void gq_renamed() throws android.content.res.Resources.NotFoundException {
        this.z_renamed.G_renamed();
        com.oplus.camera.ui.preview.g_renamed gVar = this.A_renamed;
        gVar.a_renamed((android.view.View) gVar.ap_renamed(), this.J_renamed.bz_renamed(), true);
        z_renamed(false);
    }

    public void C_renamed(boolean z_renamed, boolean z2) {
        com.oplus.camera.ui.control.a_renamed aVar = this.z_renamed;
        if (aVar != null) {
            aVar.a_renamed(z_renamed, z2);
        }
    }

    public void eA_renamed() {
        this.z_renamed.f_renamed();
    }

    public void x_renamed(java.lang.String str) throws android.content.res.Resources.NotFoundException {
        com.oplus.camera.doubleexposure.g_renamed gVar = this.bs_renamed;
        if (gVar == null || !gVar.a_renamed(str)) {
            return;
        }
        com.oplus.camera.ui.CameraUIListener cameraUIListener = this.J_renamed;
        if (cameraUIListener != null && !cameraUIListener.aq_renamed()) {
            y_renamed(0);
        }
        B_renamed(true);
        this.bs_renamed.a_renamed();
    }

    @Override // com.oplus.camera.ui.CameraUIInterface
    public void aO_renamed() {
        com.oplus.camera.doubleexposure.g_renamed gVar = this.bs_renamed;
        if (gVar != null) {
            gVar.a_renamed(false);
        }
        com.oplus.camera.ComboPreferences comboPreferences = this.B_renamed;
        if (comboPreferences != null) {
            comboPreferences.edit().remove(com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_CLIP_SAVE_PATH);
        }
        a_renamed(com.oplus.camera.R_renamed.string.camera_double_exposure_max_recording_hint);
    }

    @Override // com.oplus.camera.ui.widget.e_renamed.b_renamed
    public void eB_renamed() {
        com.oplus.camera.ui.control.a_renamed aVar = this.z_renamed;
        if (aVar != null) {
            aVar.t_renamed(true);
        }
        aO_renamed();
    }

    @Override // com.oplus.camera.ui.widget.e_renamed.b_renamed
    public void a_renamed(float f_renamed, float f2) {
        com.oplus.camera.doubleexposure.g_renamed gVar;
        if (this.B_renamed == null || (gVar = this.bs_renamed) == null || gVar.n_renamed()) {
            return;
        }
        final java.lang.String string = this.B_renamed.getString(com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_CLIP_SAVE_PATH, "");
        if (android.text.TextUtils.isEmpty(string)) {
            return;
        }
        try {
            if (this.bs_renamed != null) {
                if (new java.io.File(this.bs_renamed.i_renamed()).exists()) {
                    this.bs_renamed.h_renamed();
                    a_renamed(this.bs_renamed.j_renamed());
                } else {
                    this.bs_renamed.a_renamed(string, new com.meicam.sdk.NvsStreamingContext.CompileCallback2() { // from class: com.oplus.camera.ui.-$$Lambda$d_renamed$SdcDl4DHRNiaUSLeJIvNFfhSG24
                        @Override // com.meicam.sdk.NvsStreamingContext.CompileCallback2
                        public final void onCompileCompleted(com.meicam.sdk.NvsTimeline nvsTimeline, boolean z_renamed) throws java.lang.Throwable {
                            this.f_renamed$0.a_renamed(string, nvsTimeline, z_renamed);
                        }
                    });
                }
            }
        } catch (java.lang.Exception e_renamed) {
            e_renamed.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a_renamed(java.lang.String str, com.meicam.sdk.NvsTimeline nvsTimeline, boolean z_renamed) throws java.lang.Throwable {
        android.media.MediaMetadataRetriever mediaMetadataRetriever;
        android.media.MediaMetadataRetriever mediaMetadataRetriever2 = null;
        try {
            try {
                mediaMetadataRetriever = new android.media.MediaMetadataRetriever();
            } catch (java.lang.Exception e_renamed) {
                e_renamed = e_renamed;
            }
        } catch (java.lang.Throwable th) {
            th = th;
            mediaMetadataRetriever = mediaMetadataRetriever2;
        }
        try {
            mediaMetadataRetriever.setDataSource(str);
            java.lang.String strExtractMetadata = mediaMetadataRetriever.extractMetadata(9);
            com.oplus.camera.doubleexposure.b_renamed bVar = new com.oplus.camera.doubleexposure.b_renamed(str);
            bVar.a_renamed(0L);
            bVar.b_renamed(java.lang.Long.parseLong(strExtractMetadata));
            a_renamed(bVar);
            mediaMetadataRetriever.release();
            mediaMetadataRetriever.close();
        } catch (java.lang.Exception e2) {
            e_renamed = e2;
            mediaMetadataRetriever2 = mediaMetadataRetriever;
            this.bs_renamed.m_renamed();
            e_renamed.printStackTrace();
            if (mediaMetadataRetriever2 != null) {
                mediaMetadataRetriever2.close();
            }
        } catch (java.lang.Throwable th2) {
            th = th2;
            if (mediaMetadataRetriever != null) {
                mediaMetadataRetriever.close();
            }
            throw th;
        }
    }

    private void a_renamed(com.oplus.camera.doubleexposure.b_renamed bVar) {
        com.oplus.camera.ui.CameraUIListener cameraUIListener = this.J_renamed;
        if (cameraUIListener != null) {
            cameraUIListener.a_renamed(bVar, new com.oplus.camera.doubleexposure.g_renamed.a_renamed() { // from class: com.oplus.camera.ui.-$$Lambda$d_renamed$N2XrVKh_YFrWLAbbj_08ODB3-ts
                @Override // com.oplus.camera.doubleexposure.g_renamed.a_renamed
                public final void onVideoClipDone() {
                    this.f_renamed$0.go_renamed();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void go_renamed() {
        this.i_renamed.runOnUiThread(new java.lang.Runnable() { // from class: com.oplus.camera.ui.-$$Lambda$d_renamed$WZkWHqo9hrMvHrU_dMgaEr01pUM
            @Override // java.lang.Runnable
            public final void run() {
                this.f_renamed$0.gp_renamed();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void gp_renamed() {
        com.oplus.camera.doubleexposure.g_renamed gVar = this.bs_renamed;
        if (gVar != null) {
            gVar.a_renamed(true);
            this.bs_renamed.g_renamed();
        }
    }

    public boolean eC_renamed() {
        com.oplus.camera.doubleexposure.g_renamed gVar = this.bs_renamed;
        return gVar != null && gVar.o_renamed();
    }

    @Override // com.oplus.camera.ui.CameraUIInterface
    public void aP_renamed() {
        android.app.Activity activity = this.i_renamed;
        if (activity == null) {
            return;
        }
        activity.runOnUiThread(new java.lang.Runnable() { // from class: com.oplus.camera.ui.-$$Lambda$d_renamed$MnXjyMTZOJ-fOJ4sj15s3PR-Omg
            @Override // java.lang.Runnable
            public final void run() {
                this.f_renamed$0.gn_renamed();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void gn_renamed() {
        if (this.Z_renamed != null) {
            com.oplus.camera.ui.widget.e_renamed eVar = new com.oplus.camera.ui.widget.e_renamed(this.i_renamed);
            eVar.setVisibility(8);
            eVar.setId(com.oplus.camera.R_renamed.id_renamed.video_clip_view);
            this.Z_renamed.addView(eVar, new android.view.ViewGroup.MarginLayoutParams(-1, -1));
            this.bs_renamed = new com.oplus.camera.doubleexposure.g_renamed(this.Z_renamed, this.i_renamed, this);
            this.bs_renamed.a_renamed(this);
            com.oplus.camera.ui.control.a_renamed aVar = this.z_renamed;
            if (aVar != null) {
                aVar.a_renamed(eVar);
            }
        }
    }

    @Override // com.oplus.camera.ui.CameraUIInterface
    public void t_renamed(int i_renamed) {
        if (this.J_renamed == null || !T_renamed(i_renamed)) {
            return;
        }
        this.J_renamed.k_renamed(i_renamed);
    }

    @Override // com.oplus.camera.ui.CameraUIInterface
    public void aR_renamed() {
        com.oplus.camera.ui.preview.g_renamed gVar = this.A_renamed;
        if (gVar != null) {
            gVar.ad_renamed();
        }
    }

    @Override // com.oplus.camera.ui.CameraUIInterface
    public void c_renamed(java.lang.String str, boolean z_renamed) {
        if (dq_renamed() || this.J_renamed.bh_renamed() || !aA_renamed()) {
            this.J_renamed.b_renamed(str, z_renamed);
        }
    }

    @Override // com.oplus.camera.ui.CameraUIInterface
    public void d_renamed(java.lang.String str, boolean z_renamed) {
        com.oplus.camera.ui.menu.setting.o_renamed oVar = this.H_renamed;
        if (oVar != null) {
            oVar.b_renamed(str, z_renamed);
        }
    }

    @Override // com.oplus.camera.ui.preview.g_renamed.b_renamed
    public boolean eD_renamed() {
        com.oplus.camera.ui.CameraUIListener cameraUIListener = this.J_renamed;
        return cameraUIListener != null && cameraUIListener.bG_renamed();
    }

    @Override // com.oplus.camera.ui.CameraUIInterface
    public void aS_renamed() {
        com.oplus.camera.ui.menu.facebeauty.g_renamed gVar = this.aT_renamed;
        if (gVar != null) {
            gVar.q_renamed();
        }
    }

    @Override // com.oplus.camera.ui.CameraUIInterface
    public void u_renamed(int i_renamed) {
        com.oplus.camera.ui.menu.facebeauty.g_renamed gVar = this.aT_renamed;
        if (gVar != null) {
            gVar.b_renamed(i_renamed, false);
        }
    }

    @Override // com.oplus.camera.ui.CameraUIInterface
    public void aT_renamed() {
        android.app.Activity activity = this.i_renamed;
        if (activity != null) {
            activity.runOnUiThread(new java.lang.Runnable() { // from class: com.oplus.camera.ui.-$$Lambda$d_renamed$EAiH55woV0_RRHMrRpggFommunc
                @Override // java.lang.Runnable
                public final void run() {
                    this.f_renamed$0.gm_renamed();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void gm_renamed() {
        com.oplus.camera.ui.CameraUIListener cameraUIListener = this.J_renamed;
        if (cameraUIListener == null || cameraUIListener.bz_renamed() == null) {
            return;
        }
        this.J_renamed.bz_renamed().setVisibility(0);
    }

    @Override // com.oplus.camera.ui.preview.g_renamed.b_renamed
    public int eE_renamed() {
        com.oplus.camera.ui.CameraUIListener cameraUIListener = this.J_renamed;
        if (cameraUIListener != null) {
            return cameraUIListener.bQ_renamed();
        }
        return 0;
    }

    public void y_renamed(java.lang.String str) {
        this.z_renamed.c_renamed(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aL_renamed(boolean z_renamed) {
        com.oplus.camera.ui.CameraUIListener cameraUIListener = this.J_renamed;
        if ((cameraUIListener == null || !cameraUIListener.aQ_renamed()) && !dO_renamed() && R_renamed()) {
            if (fT_renamed()) {
                k_renamed(6);
            }
            com.oplus.camera.ui.control.a_renamed aVar = this.z_renamed;
            if (aVar != null) {
                aVar.u_renamed(fT_renamed());
            }
            this.bd_renamed.g_renamed();
            com.oplus.camera.ui.control.a_renamed aVar2 = this.z_renamed;
            if (aVar2 == null || aVar2.aw_renamed()) {
                return;
            }
            this.J_renamed.i_renamed(z_renamed ? com.oplus.camera.statistics.model.MenuClickMsgData.MODE_FUNCKEY_ITEM_HOLD_EDIT : com.oplus.camera.statistics.model.MenuClickMsgData.MODE_FUNCKEY_ITEM_EDIT_KEY);
        }
    }

    public void eF_renamed() {
        this.J_renamed.i_renamed("save");
        int iB = com.oplus.camera.ui.menu.a_renamed.c_renamed.b_renamed(this.B_renamed.getString(com.oplus.camera.ui.CameraUIInterface.KEY_CAMERA_MODE, com.oplus.camera.aps.constant.ApsConstant.CAPTURE_MODE_COMMON));
        if (-1 != iB) {
            androidx.preference.j_renamed.a_renamed(this.i_renamed).edit().putBoolean("mode_arrange_change_panel", "position_mode_panel".equals(com.oplus.camera.ui.modepanel.b_renamed.a_renamed().a_renamed(iB).c_renamed())).apply();
        }
        com.oplus.camera.ui.control.a_renamed aVar = this.z_renamed;
        if (aVar != null) {
            aVar.av_renamed();
        }
        com.oplus.camera.ui.modepanel.p_renamed pVar = this.bd_renamed;
        if (pVar != null) {
            pVar.h_renamed();
        }
    }

    public boolean eG_renamed() {
        com.oplus.camera.ui.modepanel.p_renamed pVar = this.bd_renamed;
        if (pVar != null) {
            return pVar.i_renamed();
        }
        return false;
    }

    public boolean h_renamed(java.lang.String str, boolean z_renamed) {
        com.oplus.camera.ui.menu.setting.o_renamed oVar = this.H_renamed;
        if (oVar != null) {
            return oVar.b_renamed(str);
        }
        return false;
    }

    public com.oplus.camera.screen.g_renamed eH_renamed() {
        return this.l_renamed;
    }

    @Override // com.oplus.camera.screen.b_renamed
    public void a_renamed(com.oplus.camera.screen.b_renamed.a_renamed aVar, boolean z_renamed) throws android.content.res.Resources.NotFoundException {
        com.oplus.camera.e_renamed.f_renamed("CameraUIManager", "changeScreenMode, screenMode: " + aVar + ", isCapModChange: " + z_renamed);
        this.J_renamed.bI_renamed();
        b_renamed(aVar, z_renamed);
        aVar.a_renamed(this.i_renamed, (com.oplus.camera.screen.ScreenRelativeLayout) this.Z_renamed);
        aVar.a_renamed(fY_renamed());
        this.bB_renamed = true;
    }

    private android.view.View[] fY_renamed() {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        arrayList.add(java.lang.Integer.valueOf(com.oplus.camera.R_renamed.id_renamed.zoom_seek_bar_container));
        arrayList.add(java.lang.Integer.valueOf(com.oplus.camera.R_renamed.id_renamed.zoom_seek_bar_click));
        arrayList.add(java.lang.Integer.valueOf(com.oplus.camera.R_renamed.id_renamed.zoom_seek_bar_display_text));
        arrayList.add(java.lang.Integer.valueOf(com.oplus.camera.R_renamed.id_renamed.headline_view));
        java.lang.Integer numValueOf = java.lang.Integer.valueOf(com.oplus.camera.R_renamed.id_renamed.oplus_slide_downward);
        arrayList.add(numValueOf);
        arrayList.add(java.lang.Integer.valueOf(com.oplus.camera.R_renamed.id_renamed.face_beauty_enter_button));
        arrayList.add(java.lang.Integer.valueOf(com.oplus.camera.R_renamed.id_renamed.camera_menu_left_enter_button));
        arrayList.add(java.lang.Integer.valueOf(com.oplus.camera.R_renamed.id_renamed.effect_menu_back_button));
        arrayList.add(java.lang.Integer.valueOf(com.oplus.camera.R_renamed.id_renamed.control_panel_layout));
        arrayList.add(java.lang.Integer.valueOf(com.oplus.camera.R_renamed.id_renamed.control_panel_button_layout));
        arrayList.add(java.lang.Integer.valueOf(com.oplus.camera.R_renamed.id_renamed.shutter_button));
        arrayList.add(java.lang.Integer.valueOf(com.oplus.camera.R_renamed.id_renamed.switch_camera_button));
        arrayList.add(java.lang.Integer.valueOf(com.oplus.camera.R_renamed.id_renamed.thumbnail));
        arrayList.add(java.lang.Integer.valueOf(com.oplus.camera.R_renamed.id_renamed.recording_cap_button));
        arrayList.add(java.lang.Integer.valueOf(com.oplus.camera.R_renamed.id_renamed.video_pause_resume));
        arrayList.add(java.lang.Integer.valueOf(com.oplus.camera.R_renamed.id_renamed.mode_title_layout));
        arrayList.add(numValueOf);
        arrayList.add(java.lang.Integer.valueOf(com.oplus.camera.R_renamed.id_renamed.gallery_container));
        arrayList.add(java.lang.Integer.valueOf(com.oplus.camera.R_renamed.id_renamed.screen_mode_switch_button));
        arrayList.add(java.lang.Integer.valueOf(com.oplus.camera.R_renamed.id_renamed.out_screen_preview_switch_button));
        arrayList.add(java.lang.Integer.valueOf(com.oplus.camera.R_renamed.id_renamed.effects_menu_panel));
        arrayList.add(java.lang.Integer.valueOf(com.oplus.camera.R_renamed.id_renamed.camera_from_other_app_close_btn));
        arrayList.add(java.lang.Integer.valueOf(com.oplus.camera.R_renamed.id_renamed.done_button));
        arrayList.add(java.lang.Integer.valueOf(com.oplus.camera.R_renamed.id_renamed.btn_retake));
        arrayList.add(java.lang.Integer.valueOf(com.oplus.camera.R_renamed.id_renamed.review_control_layout));
        arrayList.add(java.lang.Integer.valueOf(com.oplus.camera.R_renamed.id_renamed.time_lapse_pro_template_button));
        arrayList.add(java.lang.Integer.valueOf(com.oplus.camera.R_renamed.id_renamed.time_lapse_pro_setting_button));
        arrayList.add(java.lang.Integer.valueOf(com.oplus.camera.R_renamed.id_renamed.time_lapse_pro_guide_button));
        arrayList.add(java.lang.Integer.valueOf(com.oplus.camera.R_renamed.id_renamed.time_lapse_pro_layout));
        arrayList.add(java.lang.Integer.valueOf(com.oplus.camera.R_renamed.id_renamed.time_lapse_pro_record_layout));
        arrayList.add(java.lang.Integer.valueOf(com.oplus.camera.R_renamed.id_renamed.professional_params_bar_container));
        arrayList.add(java.lang.Integer.valueOf(com.oplus.camera.R_renamed.id_renamed.main_bar_id));
        arrayList.add(java.lang.Integer.valueOf(com.oplus.camera.R_renamed.id_renamed.professional_param_slide_bar_container));
        arrayList.add(java.lang.Integer.valueOf(com.oplus.camera.R_renamed.id_renamed.professional_parameter_bottom_guide_entry));
        arrayList.add(java.lang.Integer.valueOf(com.oplus.camera.R_renamed.id_renamed.multivideo_type_select_view));
        android.view.View[] viewArr = new android.view.View[arrayList.size()];
        for (int i_renamed = 0; i_renamed < arrayList.size(); i_renamed++) {
            viewArr[i_renamed] = this.i_renamed.findViewById(((java.lang.Integer) arrayList.get(i_renamed)).intValue());
        }
        return viewArr;
    }

    private void b_renamed(com.oplus.camera.screen.b_renamed.a_renamed aVar, boolean z_renamed) throws android.content.res.Resources.NotFoundException {
        com.oplus.camera.ui.preview.g_renamed gVar;
        this.bx_renamed = aVar;
        com.oplus.camera.ui.preview.g_renamed gVar2 = this.A_renamed;
        if (gVar2 != null && !gVar2.ag_renamed()) {
            this.aM_renamed.setVisibility(8);
        }
        aVar.e_renamed(this.i_renamed);
        com.oplus.camera.ui.menu.setting.f_renamed fVar = this.I_renamed;
        if (fVar != null) {
            fVar.a_renamed(aVar.j_renamed(), aVar.k_renamed(), aVar.q_renamed());
        }
        com.oplus.camera.ui.menu.setting.o_renamed oVar = this.H_renamed;
        if (oVar != null) {
            oVar.g_renamed(aVar.j_renamed());
        }
        com.oplus.camera.ui.menu.levelcontrol.g_renamed gVar3 = this.ah_renamed;
        if (gVar3 != null) {
            gVar3.a_renamed(aVar.j_renamed(), aVar.k_renamed());
        }
        com.oplus.camera.ui.menu.facebeauty.g_renamed gVar4 = this.aT_renamed;
        if (gVar4 != null) {
            gVar4.a_renamed(aVar.j_renamed(), aVar.k_renamed());
            this.aT_renamed.h_renamed(aVar.a_renamed(this.M_renamed));
        }
        com.oplus.camera.ui.control.a_renamed aVar2 = this.z_renamed;
        if (aVar2 != null) {
            aVar2.a_renamed(aVar, false);
        }
        com.oplus.camera.ui.modepanel.p_renamed pVar = this.bd_renamed;
        if (pVar != null) {
            pVar.h_renamed(aVar.j_renamed());
        }
        com.oplus.camera.ui.modepanel.m_renamed mVar = this.aJ_renamed;
        if (mVar != null) {
            mVar.a_renamed(dr_renamed());
            this.aJ_renamed.a_renamed(aVar.j_renamed(), aVar.k_renamed());
        }
        com.oplus.camera.ui.menu.levelcontrol.c_renamed cVar = this.ai_renamed;
        if (cVar != null) {
            cVar.setScreenMode(aVar.j_renamed(), aVar.k_renamed());
        }
        com.oplus.camera.ui.a_renamed.a_renamed aVar3 = this.ac_renamed;
        if (aVar3 != null) {
            aVar3.a_renamed(aVar);
        }
        this.bx_renamed = aVar;
        this.l_renamed.b_renamed(this.bx_renamed.o_renamed());
        com.oplus.camera.ui.CameraUIListener cameraUIListener = this.J_renamed;
        if (cameraUIListener != null) {
            cameraUIListener.g_renamed(aVar.j_renamed(), aVar.k_renamed());
            bU_renamed();
        }
        com.oplus.camera.timelapsepro.g_renamed gVar5 = this.bP_renamed;
        if (gVar5 != null) {
            gVar5.setCurrentScreenMode(aVar);
        }
        com.oplus.camera.timelapsepro.f_renamed fVar2 = this.bQ_renamed;
        if (fVar2 != null) {
            fVar2.setCurrentScreenMode(aVar);
        }
        com.oplus.camera.ui.preview.a_renamed aVar4 = this.aH_renamed;
        if (aVar4 != null) {
            aVar4.h_renamed(aVar.j_renamed());
        }
        com.oplus.camera.ui.preview.g_renamed gVar6 = this.A_renamed;
        if (gVar6 != null) {
            gVar6.C_renamed();
        }
        if (!com.oplus.camera.util.Util.u_renamed() || ((gVar = this.A_renamed) != null && !gVar.X_renamed())) {
            com.oplus.camera.ui.inverse.e_renamed.INS.setMaskLayoutMode(this.i_renamed, aVar.j_renamed(), aVar.q_renamed(), aVar.k_renamed());
        }
        cb_renamed();
    }

    public boolean eI_renamed() {
        return this.x_renamed;
    }

    public boolean eJ_renamed() {
        return this.bC_renamed;
    }

    @Override // com.oplus.camera.screen.b_renamed
    public void a_renamed(com.oplus.camera.screen.b_renamed.a_renamed aVar, com.oplus.camera.screen.b_renamed.a_renamed aVar2) throws java.lang.IllegalStateException, android.content.res.Resources.NotFoundException {
        com.oplus.camera.e_renamed.f_renamed("CameraUIManager", "beforeChangeScreenMode lastScreenMode: " + aVar + " currentScreenMode: " + aVar2);
        if (1 == aVar.j_renamed() || 1 == aVar2.j_renamed()) {
            this.x_renamed = true;
        }
        this.bC_renamed = true;
        if (this.J_renamed.ah_renamed()) {
            this.J_renamed.b_renamed(true);
            if (!(fh_renamed() && (aVar2.l_renamed() || aVar2.r_renamed() || aVar2.o_renamed()))) {
                a_renamed(0, true, 2);
            }
            this.J_renamed.al_renamed();
        }
        a_renamed(false, true, true, true);
        b_renamed(true, false, true, false);
        D_renamed();
        e_renamed(6, true);
        b_renamed(false);
        com.oplus.camera.util.Util.q_renamed(this.i_renamed);
        D_renamed(false, false);
        dl_renamed();
        if (!this.o_renamed && !this.n_renamed && !dr_renamed() && !this.J_renamed.d_renamed() && 1 != aX_renamed()) {
            if (com.oplus.camera.util.Util.g_renamed() == 0) {
                this.H_renamed.A_renamed();
            }
            w_renamed(true, false);
        }
        if (this.ac_renamed != null) {
            a_renamed(true, true, false);
        }
        if (this.ac_renamed != null && this.ci_renamed != null) {
            ab_renamed();
            this.ci_renamed.b_renamed();
            l_renamed(true);
        }
        if (dH_renamed() && eG_renamed()) {
            a_renamed(4, false, 0);
        }
        this.J_renamed.cb_renamed();
        fd_renamed();
        if (com.oplus.camera.ui.menu.g_renamed.a_renamed()) {
            com.oplus.camera.ui.menu.g_renamed.e_renamed();
        }
        this.A_renamed.o_renamed();
        if (this.B_renamed.getString(com.oplus.camera.ui.CameraUIInterface.KEY_ASSIST_GRADIENTER, "off").equals("on_renamed")) {
            i_renamed(false);
        }
        if (fh_renamed() && !dp_renamed() && !dr_renamed() && !this.J_renamed.L_renamed() && !dH_renamed()) {
            a_renamed((android.view.animation.Animation) null);
        }
        com.oplus.camera.ui.menu.setting.f_renamed fVar = this.I_renamed;
        if (fVar != null && fVar.j_renamed()) {
            this.I_renamed.z_renamed();
            U_renamed();
        }
        com.oplus.camera.timelapsepro.f_renamed fVar2 = this.bQ_renamed;
        if (fVar2 != null && fVar2.isShown()) {
            this.bQ_renamed.b_renamed();
            aA_renamed(true);
        }
        this.A_renamed.a_renamed(aVar, aVar2);
        for (com.oplus.camera.ui.widget.SplitBackgroundView splitBackgroundView : this.cc_renamed) {
            if (splitBackgroundView != null) {
                java.lang.String strH = aVar2.h_renamed();
                splitBackgroundView.setSplitBackground("full270".equals(strH) || "full90".equals(strH));
                splitBackgroundView.setOrientation(this.L_renamed);
            }
        }
    }

    @Override // com.oplus.camera.screen.b_renamed
    public void a_renamed(com.oplus.camera.screen.b_renamed.a_renamed aVar) throws android.content.res.Resources.NotFoundException {
        com.oplus.camera.e_renamed.f_renamed("CameraUIManager", "afterChangeScreenMode screenMode: " + aVar);
        this.J_renamed.d_renamed(false);
        this.J_renamed.m_renamed(aVar.j_renamed());
        this.J_renamed.cd_renamed();
        if (this.J_renamed.bl_renamed()) {
            l_renamed(true, false);
        }
        if (dr_renamed() && this.D_renamed != null && !j_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_TIME_LAPSE_PRO)) {
            this.D_renamed.a_renamed(aVar);
            this.D_renamed.g_renamed();
        }
        com.oplus.camera.ui.j_renamed jVar = this.bG_renamed;
        if (jVar != null) {
            jVar.a_renamed();
        }
        if (this.F_renamed != null) {
            eR_renamed();
        }
        if (this.ac_renamed != null) {
            this.J_renamed.cc_renamed();
        }
        com.oplus.camera.ui.menu.setting.o_renamed oVar = this.H_renamed;
        if (oVar != null) {
            oVar.b_renamed(this.M_renamed);
        }
        if (this.I_renamed != null && 3 == aVar.j_renamed()) {
            this.I_renamed.b_renamed(1 == cv_renamed());
        }
        this.cm_renamed.removeMessages(13);
        this.cm_renamed.sendEmptyMessageDelayed(13, 400L);
        com.oplus.camera.ui.control.a_renamed aVar2 = this.z_renamed;
        if (aVar2 != null) {
            aVar2.j_renamed(this.o_renamed, this.n_renamed);
        }
        if (!dr_renamed() && !this.J_renamed.L_renamed() && 3 != this.K_renamed) {
            if (!fh_renamed() && !d_renamed() && !eG_renamed()) {
                com.oplus.camera.ui.preview.NightTimeView nightTimeView = this.F_renamed;
                if (nightTimeView == null || nightTimeView.getVisibility() != 0) {
                    a_renamed(0, 1);
                }
            } else if (fh_renamed() && !dp_renamed() && !dH_renamed()) {
                a_renamed(0, false);
                a_renamed(true);
            }
        }
        if (!bO_renamed() && !this.J_renamed.d_renamed()) {
            g_renamed(0);
        }
        this.bC_renamed = false;
        gj_renamed();
    }

    private void fZ_renamed() {
        com.oplus.camera.e_renamed.a_renamed("CameraUIManager", "relayoutViewForNavBarChange");
        this.bx_renamed.a__renamed(this.i_renamed);
    }

    @Override // com.oplus.camera.ui.preview.g_renamed.b_renamed
    public void a_renamed(com.oplus.camera.screen.b_renamed.a_renamed aVar, android.util.Size size, long j_renamed) {
        if (this.J_renamed != null) {
            a_renamed((com.oplus.camera.ui.q_renamed) null);
        }
        if (com.oplus.camera.util.Util.u_renamed()) {
            android.graphics.Rect rectB = aVar.b_renamed(size.getHeight(), size.getWidth());
            int iA = a_renamed(com.oplus.camera.util.Util.d_renamed(size.getWidth(), size.getHeight()), aVar);
            com.oplus.camera.ui.inverse.b_renamed bVar = new com.oplus.camera.ui.inverse.b_renamed();
            bVar.f6246a = aVar.j_renamed();
            bVar.g_renamed = aVar.q_renamed();
            bVar.f6247b = aVar.k_renamed();
            bVar.f6248c = iA;
            bVar.e_renamed = (long) this.A_renamed.H_renamed();
            bVar.d_renamed = (rectB.top + rectB.bottom) / 2.0f;
            bVar.f_renamed = j_renamed;
            com.oplus.camera.ui.inverse.e_renamed.INS.setMaskToLayoutMode(this.i_renamed, bVar);
        }
    }

    @Override // com.oplus.camera.ui.preview.g_renamed.b_renamed
    public void eK_renamed() {
        com.oplus.camera.ui.CameraUIListener cameraUIListener = this.J_renamed;
        if (cameraUIListener != null) {
            cameraUIListener.ce_renamed();
            a_renamed(this.J_renamed.ci_renamed());
        }
    }

    private boolean ga_renamed() {
        android.app.KeyguardManager keyguardManager;
        android.app.Activity activity = this.i_renamed;
        if (activity == null || (keyguardManager = (android.app.KeyguardManager) activity.getApplicationContext().getSystemService("keyguard")) == null) {
            return false;
        }
        return keyguardManager.isDeviceLocked();
    }

    private void gb_renamed() {
        this.bM_renamed = new com.oplus.camera.ui.menu.facebeauty.RotateAnimationView(this.i_renamed);
        this.bM_renamed.setLightBackground(eQ_renamed());
        this.bM_renamed.setId(com.oplus.camera.R_renamed.id_renamed.time_lapse_pro_template_button);
        this.bM_renamed.setImageResource(com.oplus.camera.R_renamed.drawable.time_lapse_pro_template_button);
        this.bM_renamed.setBackgroundResource(com.oplus.camera.R_renamed.drawable.face_beauty_menu_control_button_background);
        int i_renamed = this.B_renamed.getInt("pref_time_lapse_pro_template_key", 0);
        boolean z_renamed = this.B_renamed.getBoolean(com.oplus.camera.ui.CameraUIInterface.KEY_RESTORE_TIMELAPSE_PRO_PARAMS, false);
        if (i_renamed != 0 && !z_renamed) {
            this.bM_renamed.setImageTintList(android.content.res.ColorStateList.valueOf(androidx.core.a_renamed.a_renamed.c_renamed(this.i_renamed, com.oplus.camera.R_renamed.color.time_lapse_pro_seek_value_desc_color)));
        }
        this.bM_renamed.setOnClickListener(this.cq_renamed);
        android.content.res.Resources resources = this.i_renamed.getApplication().getResources();
        android.widget.RelativeLayout.LayoutParams layoutParams = new android.widget.RelativeLayout.LayoutParams(resources.getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.face_beauty_enter_button_width), resources.getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.face_beauty_enter_button_height));
        layoutParams.addRule(9);
        layoutParams.addRule(2, com.oplus.camera.R_renamed.id_renamed.control_panel_layout);
        layoutParams.setMargins(resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.time_lapse_pro_button_margin_left), 0, 0, resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.face_beauty_enter_button_margin_bottom));
        this.Z_renamed.addView(this.bM_renamed, layoutParams);
        ej_renamed().a_renamed(this.bM_renamed);
    }

    @Override // com.oplus.camera.ui.CameraUIInterface
    public void o_renamed(boolean z_renamed, boolean z2) {
        com.oplus.camera.e_renamed.a_renamed("CameraUIManager", "showTimeLapseProTemplateButton, needAnim : " + z_renamed);
        if (R_renamed()) {
            return;
        }
        if (this.bM_renamed == null) {
            gb_renamed();
        }
        if (this.B_renamed.getBoolean(com.oplus.camera.ui.CameraUIInterface.KEY_RESTORE_TIMELAPSE_PRO_PARAMS, false)) {
            this.ce_renamed.a_renamed(0);
        }
        com.oplus.camera.ui.CameraUIListener cameraUIListener = this.J_renamed;
        if (cameraUIListener == null || !cameraUIListener.c_renamed()) {
            android.animation.AnimatorSet animatorSet = this.aY_renamed;
            if (animatorSet != null && animatorSet.isRunning()) {
                com.oplus.camera.e_renamed.a_renamed("CameraUIManager", "showTimeLapseProTemplateButton, cancel");
                this.aY_renamed.cancel();
            } else if (this.bM_renamed.isShown()) {
                com.oplus.camera.e_renamed.a_renamed("CameraUIManager", "showTimeLapseProTemplateButton, return.");
                return;
            }
            if (z_renamed) {
                a_renamed(this.bM_renamed, z2, this.aY_renamed, new android.animation.AnimatorListenerAdapter() { // from class: com.oplus.camera.ui.d_renamed.63
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationStart(android.animation.Animator animator) {
                        if (com.oplus.camera.ui.d_renamed.this.bM_renamed != null) {
                            com.oplus.camera.ui.d_renamed.this.bM_renamed.setEnabled(false);
                            com.oplus.camera.ui.d_renamed.this.bM_renamed.setVisibility(0);
                        }
                    }

                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(android.animation.Animator animator) {
                        if (com.oplus.camera.ui.d_renamed.this.bM_renamed != null) {
                            com.oplus.camera.ui.d_renamed.this.bM_renamed.setEnabled(true);
                        }
                    }

                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(android.animation.Animator animator) {
                        if (com.oplus.camera.ui.d_renamed.this.bM_renamed != null) {
                            com.oplus.camera.ui.d_renamed.this.bM_renamed.setEnabled(true);
                        }
                    }
                });
                return;
            }
            this.bM_renamed.setEnabled(true);
            this.bM_renamed.setVisibility(0);
            this.bM_renamed.setAlpha(255);
        }
    }

    @Override // com.oplus.camera.ui.CameraUIInterface
    public void p_renamed(boolean z_renamed, boolean z2) {
        com.oplus.camera.e_renamed.a_renamed("CameraUIManager", "hideTimeLapseProTemplateButton, needAnim: " + z_renamed + ", needTranslateAni: " + z2);
        android.animation.AnimatorSet animatorSet = this.aY_renamed;
        if (animatorSet != null && animatorSet.isRunning()) {
            this.aY_renamed.cancel();
        }
        com.oplus.camera.ui.menu.facebeauty.RotateAnimationView rotateAnimationView = this.bM_renamed;
        if (rotateAnimationView == null) {
            return;
        }
        if (z_renamed) {
            b_renamed(rotateAnimationView, z2, this.aY_renamed, new android.animation.AnimatorListenerAdapter() { // from class: com.oplus.camera.ui.d_renamed.64
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(android.animation.Animator animator, boolean z3) {
                    if (com.oplus.camera.ui.d_renamed.this.bM_renamed == null || !com.oplus.camera.ui.d_renamed.this.bM_renamed.isShown()) {
                        return;
                    }
                    com.oplus.camera.ui.d_renamed.this.bM_renamed.setEnabled(false);
                    com.oplus.camera.ui.d_renamed.this.bM_renamed.setVisibility(0);
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(android.animation.Animator animator, boolean z3) {
                    if (com.oplus.camera.ui.d_renamed.this.bM_renamed != null) {
                        com.oplus.camera.ui.d_renamed.this.bM_renamed.setEnabled(true);
                        com.oplus.camera.ui.d_renamed.this.bM_renamed.setVisibility(8);
                    }
                }
            });
        } else {
            rotateAnimationView.setVisibility(8);
        }
    }

    private void gc_renamed() {
        this.bN_renamed = new com.oplus.camera.ui.menu.facebeauty.RotateAnimationView(this.i_renamed);
        this.bN_renamed.setLightBackground(eQ_renamed());
        this.bN_renamed.setId(com.oplus.camera.R_renamed.id_renamed.time_lapse_pro_setting_button);
        this.bN_renamed.setImageResource(com.oplus.camera.R_renamed.drawable.time_lapse_pro_setting_button);
        this.bN_renamed.setBackgroundResource(com.oplus.camera.R_renamed.drawable.face_beauty_menu_control_button_background);
        this.bN_renamed.setOnClickListener(this.cq_renamed);
        android.content.res.Resources resources = this.i_renamed.getApplication().getResources();
        android.widget.RelativeLayout.LayoutParams layoutParams = new android.widget.RelativeLayout.LayoutParams(resources.getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.face_beauty_enter_button_width), resources.getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.face_beauty_enter_button_height));
        layoutParams.addRule(11);
        layoutParams.addRule(2, com.oplus.camera.R_renamed.id_renamed.control_panel_layout);
        layoutParams.setMargins(0, 0, resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.time_lapse_pro_button_margin_left), resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.face_beauty_enter_button_margin_bottom));
        this.Z_renamed.addView(this.bN_renamed, layoutParams);
        ej_renamed().a_renamed(this.bN_renamed);
    }

    @Override // com.oplus.camera.ui.CameraUIInterface
    public void q_renamed(boolean z_renamed, boolean z2) {
        if (R_renamed()) {
            return;
        }
        if (this.bN_renamed == null) {
            gc_renamed();
        }
        com.oplus.camera.ui.CameraUIListener cameraUIListener = this.J_renamed;
        if (cameraUIListener == null || !cameraUIListener.c_renamed()) {
            android.animation.AnimatorSet animatorSet = this.aZ_renamed;
            if (animatorSet != null && animatorSet.isRunning()) {
                this.aZ_renamed.cancel();
            } else if (this.bN_renamed.isShown()) {
                return;
            }
            if (z_renamed) {
                a_renamed(this.bN_renamed, z2, this.aZ_renamed, new android.animation.AnimatorListenerAdapter() { // from class: com.oplus.camera.ui.d_renamed.66
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationStart(android.animation.Animator animator) {
                        if (com.oplus.camera.ui.d_renamed.this.bN_renamed != null) {
                            com.oplus.camera.ui.d_renamed.this.bN_renamed.setEnabled(false);
                            com.oplus.camera.ui.d_renamed.this.bN_renamed.setVisibility(0);
                        }
                    }

                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(android.animation.Animator animator) {
                        if (com.oplus.camera.ui.d_renamed.this.bN_renamed != null) {
                            com.oplus.camera.ui.d_renamed.this.bN_renamed.setEnabled(true);
                        }
                    }

                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(android.animation.Animator animator) {
                        if (com.oplus.camera.ui.d_renamed.this.bN_renamed != null) {
                            com.oplus.camera.ui.d_renamed.this.bN_renamed.setEnabled(true);
                        }
                    }
                });
            } else {
                this.bN_renamed.setVisibility(0);
                this.bN_renamed.setEnabled(true);
            }
        }
    }

    @Override // com.oplus.camera.ui.CameraUIInterface
    public void r_renamed(boolean z_renamed, boolean z2) {
        android.animation.AnimatorSet animatorSet = this.aZ_renamed;
        if (animatorSet != null && animatorSet.isRunning()) {
            this.aZ_renamed.cancel();
        }
        com.oplus.camera.ui.menu.facebeauty.RotateAnimationView rotateAnimationView = this.bN_renamed;
        if (rotateAnimationView == null) {
            return;
        }
        if (z_renamed) {
            b_renamed(rotateAnimationView, z2, this.aZ_renamed, new android.animation.AnimatorListenerAdapter() { // from class: com.oplus.camera.ui.d_renamed.67
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(android.animation.Animator animator, boolean z3) {
                    if (com.oplus.camera.ui.d_renamed.this.bN_renamed == null || !com.oplus.camera.ui.d_renamed.this.bN_renamed.isShown()) {
                        return;
                    }
                    com.oplus.camera.ui.d_renamed.this.bN_renamed.setEnabled(false);
                    com.oplus.camera.ui.d_renamed.this.bN_renamed.setVisibility(0);
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(android.animation.Animator animator, boolean z3) {
                    if (com.oplus.camera.ui.d_renamed.this.bN_renamed != null) {
                        com.oplus.camera.ui.d_renamed.this.bN_renamed.setEnabled(true);
                        com.oplus.camera.ui.d_renamed.this.bN_renamed.setVisibility(8);
                    }
                }
            });
        } else {
            rotateAnimationView.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aM_renamed(boolean z_renamed) throws java.lang.IllegalStateException {
        int screenHeight;
        int screenWidth;
        int screenWidth2;
        final float f_renamed;
        if (this.bQ_renamed == null) {
            gd_renamed();
        }
        com.oplus.camera.ui.CameraUIListener cameraUIListener = this.J_renamed;
        if (cameraUIListener == null || !cameraUIListener.c_renamed()) {
            if (z_renamed) {
                android.animation.AnimatorSet animatorSet = new android.animation.AnimatorSet();
                com.oplus.camera.util.Util.getScreenHeight();
                final java.lang.String str = "translationX";
                if (1 == this.bx_renamed.j_renamed()) {
                    if (this.bx_renamed.k_renamed() == 0) {
                        screenHeight = com.oplus.camera.util.Util.getScreenHeight();
                        f_renamed = screenHeight;
                        str = "translationY";
                        android.animation.ObjectAnimator objectAnimatorOfFloat = android.animation.ObjectAnimator.ofFloat(this.bQ_renamed, str, f_renamed, 0.0f);
                        objectAnimatorOfFloat.setInterpolator(this.bb_renamed);
                        objectAnimatorOfFloat.setDuration(400L);
                        animatorSet.play(objectAnimatorOfFloat);
                        animatorSet.addListener(new android.animation.AnimatorListenerAdapter() { // from class: com.oplus.camera.ui.d_renamed.68
                            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                            public void onAnimationStart(android.animation.Animator animator) {
                                if (com.oplus.camera.ui.d_renamed.this.bQ_renamed != null) {
                                    com.oplus.camera.ui.d_renamed.this.bQ_renamed.setVisibility(0);
                                    if ("translationX".equals(str)) {
                                        com.oplus.camera.ui.d_renamed.this.bQ_renamed.setTranslationX(f_renamed);
                                    } else {
                                        com.oplus.camera.ui.d_renamed.this.bQ_renamed.setTranslationY(f_renamed);
                                    }
                                }
                            }

                            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                            public void onAnimationEnd(android.animation.Animator animator) {
                                if (com.oplus.camera.ui.d_renamed.this.bQ_renamed != null) {
                                    com.oplus.camera.ui.d_renamed.this.bQ_renamed.setTranslationY(0.0f);
                                }
                            }
                        });
                        animatorSet.start();
                    } else if (90 == this.bx_renamed.k_renamed()) {
                        screenWidth2 = com.oplus.camera.util.Util.getScreenWidth();
                        screenWidth = -screenWidth2;
                        f_renamed = screenWidth;
                        android.animation.ObjectAnimator objectAnimatorOfFloat2 = android.animation.ObjectAnimator.ofFloat(this.bQ_renamed, str, f_renamed, 0.0f);
                        objectAnimatorOfFloat2.setInterpolator(this.bb_renamed);
                        objectAnimatorOfFloat2.setDuration(400L);
                        animatorSet.play(objectAnimatorOfFloat2);
                        animatorSet.addListener(new android.animation.AnimatorListenerAdapter() { // from class: com.oplus.camera.ui.d_renamed.68
                            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                            public void onAnimationStart(android.animation.Animator animator) {
                                if (com.oplus.camera.ui.d_renamed.this.bQ_renamed != null) {
                                    com.oplus.camera.ui.d_renamed.this.bQ_renamed.setVisibility(0);
                                    if ("translationX".equals(str)) {
                                        com.oplus.camera.ui.d_renamed.this.bQ_renamed.setTranslationX(f_renamed);
                                    } else {
                                        com.oplus.camera.ui.d_renamed.this.bQ_renamed.setTranslationY(f_renamed);
                                    }
                                }
                            }

                            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                            public void onAnimationEnd(android.animation.Animator animator) {
                                if (com.oplus.camera.ui.d_renamed.this.bQ_renamed != null) {
                                    com.oplus.camera.ui.d_renamed.this.bQ_renamed.setTranslationY(0.0f);
                                }
                            }
                        });
                        animatorSet.start();
                    } else {
                        screenWidth = com.oplus.camera.util.Util.getScreenWidth();
                        f_renamed = screenWidth;
                        android.animation.ObjectAnimator objectAnimatorOfFloat22 = android.animation.ObjectAnimator.ofFloat(this.bQ_renamed, str, f_renamed, 0.0f);
                        objectAnimatorOfFloat22.setInterpolator(this.bb_renamed);
                        objectAnimatorOfFloat22.setDuration(400L);
                        animatorSet.play(objectAnimatorOfFloat22);
                        animatorSet.addListener(new android.animation.AnimatorListenerAdapter() { // from class: com.oplus.camera.ui.d_renamed.68
                            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                            public void onAnimationStart(android.animation.Animator animator) {
                                if (com.oplus.camera.ui.d_renamed.this.bQ_renamed != null) {
                                    com.oplus.camera.ui.d_renamed.this.bQ_renamed.setVisibility(0);
                                    if ("translationX".equals(str)) {
                                        com.oplus.camera.ui.d_renamed.this.bQ_renamed.setTranslationX(f_renamed);
                                    } else {
                                        com.oplus.camera.ui.d_renamed.this.bQ_renamed.setTranslationY(f_renamed);
                                    }
                                }
                            }

                            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                            public void onAnimationEnd(android.animation.Animator animator) {
                                if (com.oplus.camera.ui.d_renamed.this.bQ_renamed != null) {
                                    com.oplus.camera.ui.d_renamed.this.bQ_renamed.setTranslationY(0.0f);
                                }
                            }
                        });
                        animatorSet.start();
                    }
                } else if (4 == this.bx_renamed.j_renamed()) {
                    if (90 == this.bx_renamed.k_renamed()) {
                        screenWidth2 = com.oplus.camera.util.Util.getScreenWidth();
                        screenWidth = -screenWidth2;
                        f_renamed = screenWidth;
                        android.animation.ObjectAnimator objectAnimatorOfFloat222 = android.animation.ObjectAnimator.ofFloat(this.bQ_renamed, str, f_renamed, 0.0f);
                        objectAnimatorOfFloat222.setInterpolator(this.bb_renamed);
                        objectAnimatorOfFloat222.setDuration(400L);
                        animatorSet.play(objectAnimatorOfFloat222);
                        animatorSet.addListener(new android.animation.AnimatorListenerAdapter() { // from class: com.oplus.camera.ui.d_renamed.68
                            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                            public void onAnimationStart(android.animation.Animator animator) {
                                if (com.oplus.camera.ui.d_renamed.this.bQ_renamed != null) {
                                    com.oplus.camera.ui.d_renamed.this.bQ_renamed.setVisibility(0);
                                    if ("translationX".equals(str)) {
                                        com.oplus.camera.ui.d_renamed.this.bQ_renamed.setTranslationX(f_renamed);
                                    } else {
                                        com.oplus.camera.ui.d_renamed.this.bQ_renamed.setTranslationY(f_renamed);
                                    }
                                }
                            }

                            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                            public void onAnimationEnd(android.animation.Animator animator) {
                                if (com.oplus.camera.ui.d_renamed.this.bQ_renamed != null) {
                                    com.oplus.camera.ui.d_renamed.this.bQ_renamed.setTranslationY(0.0f);
                                }
                            }
                        });
                        animatorSet.start();
                    } else {
                        screenWidth = com.oplus.camera.util.Util.getScreenWidth();
                        f_renamed = screenWidth;
                        android.animation.ObjectAnimator objectAnimatorOfFloat2222 = android.animation.ObjectAnimator.ofFloat(this.bQ_renamed, str, f_renamed, 0.0f);
                        objectAnimatorOfFloat2222.setInterpolator(this.bb_renamed);
                        objectAnimatorOfFloat2222.setDuration(400L);
                        animatorSet.play(objectAnimatorOfFloat2222);
                        animatorSet.addListener(new android.animation.AnimatorListenerAdapter() { // from class: com.oplus.camera.ui.d_renamed.68
                            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                            public void onAnimationStart(android.animation.Animator animator) {
                                if (com.oplus.camera.ui.d_renamed.this.bQ_renamed != null) {
                                    com.oplus.camera.ui.d_renamed.this.bQ_renamed.setVisibility(0);
                                    if ("translationX".equals(str)) {
                                        com.oplus.camera.ui.d_renamed.this.bQ_renamed.setTranslationX(f_renamed);
                                    } else {
                                        com.oplus.camera.ui.d_renamed.this.bQ_renamed.setTranslationY(f_renamed);
                                    }
                                }
                            }

                            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                            public void onAnimationEnd(android.animation.Animator animator) {
                                if (com.oplus.camera.ui.d_renamed.this.bQ_renamed != null) {
                                    com.oplus.camera.ui.d_renamed.this.bQ_renamed.setTranslationY(0.0f);
                                }
                            }
                        });
                        animatorSet.start();
                    }
                } else {
                    screenHeight = com.oplus.camera.util.Util.getScreenHeight();
                    f_renamed = screenHeight;
                    str = "translationY";
                    android.animation.ObjectAnimator objectAnimatorOfFloat22222 = android.animation.ObjectAnimator.ofFloat(this.bQ_renamed, str, f_renamed, 0.0f);
                    objectAnimatorOfFloat22222.setInterpolator(this.bb_renamed);
                    objectAnimatorOfFloat22222.setDuration(400L);
                    animatorSet.play(objectAnimatorOfFloat22222);
                    animatorSet.addListener(new android.animation.AnimatorListenerAdapter() { // from class: com.oplus.camera.ui.d_renamed.68
                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationStart(android.animation.Animator animator) {
                            if (com.oplus.camera.ui.d_renamed.this.bQ_renamed != null) {
                                com.oplus.camera.ui.d_renamed.this.bQ_renamed.setVisibility(0);
                                if ("translationX".equals(str)) {
                                    com.oplus.camera.ui.d_renamed.this.bQ_renamed.setTranslationX(f_renamed);
                                } else {
                                    com.oplus.camera.ui.d_renamed.this.bQ_renamed.setTranslationY(f_renamed);
                                }
                            }
                        }

                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(android.animation.Animator animator) {
                            if (com.oplus.camera.ui.d_renamed.this.bQ_renamed != null) {
                                com.oplus.camera.ui.d_renamed.this.bQ_renamed.setTranslationY(0.0f);
                            }
                        }
                    });
                    animatorSet.start();
                }
            } else {
                com.oplus.camera.timelapsepro.f_renamed fVar = this.bQ_renamed;
                if (fVar != null) {
                    fVar.setVisibility(0);
                }
            }
            com.oplus.camera.timelapsepro.f_renamed fVar2 = this.bQ_renamed;
            if (fVar2 != null) {
                fVar2.setCurrentScreenMode(this.bx_renamed);
                this.bQ_renamed.a_renamed();
            }
        }
    }

    public void aA_renamed(boolean z_renamed) {
        int screenHeight;
        int screenWidth;
        int screenWidth2;
        float f_renamed;
        com.oplus.camera.timelapsepro.f_renamed fVar = this.bQ_renamed;
        if (fVar == null) {
            return;
        }
        if (z_renamed) {
            android.animation.AnimatorSet animatorSet = new android.animation.AnimatorSet();
            com.oplus.camera.util.Util.getScreenHeight();
            final java.lang.String str = "translationX";
            if (1 == this.bx_renamed.j_renamed()) {
                if (this.bx_renamed.k_renamed() == 0) {
                    screenHeight = com.oplus.camera.util.Util.getScreenHeight();
                    f_renamed = screenHeight;
                    str = "translationY";
                } else if (90 == this.bx_renamed.k_renamed()) {
                    screenWidth2 = com.oplus.camera.util.Util.getScreenWidth();
                    screenWidth = -screenWidth2;
                    f_renamed = screenWidth;
                } else {
                    screenWidth = com.oplus.camera.util.Util.getScreenWidth();
                    f_renamed = screenWidth;
                }
            } else if (4 == this.bx_renamed.j_renamed()) {
                if (90 == this.bx_renamed.k_renamed()) {
                    screenWidth2 = com.oplus.camera.util.Util.getScreenWidth();
                    screenWidth = -screenWidth2;
                    f_renamed = screenWidth;
                } else {
                    screenWidth = com.oplus.camera.util.Util.getScreenWidth();
                    f_renamed = screenWidth;
                }
            } else {
                screenHeight = com.oplus.camera.util.Util.getScreenHeight();
                f_renamed = screenHeight;
                str = "translationY";
            }
            android.animation.ObjectAnimator objectAnimatorOfFloat = android.animation.ObjectAnimator.ofFloat(this.bQ_renamed, str, 0.0f, f_renamed);
            objectAnimatorOfFloat.setInterpolator(this.bb_renamed);
            objectAnimatorOfFloat.setDuration(400L);
            animatorSet.play(objectAnimatorOfFloat);
            animatorSet.addListener(new android.animation.AnimatorListenerAdapter() { // from class: com.oplus.camera.ui.d_renamed.69
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(android.animation.Animator animator) {
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(android.animation.Animator animator) {
                    if (com.oplus.camera.ui.d_renamed.this.bQ_renamed != null) {
                        com.oplus.camera.ui.d_renamed.this.bQ_renamed.setVisibility(8);
                        if ("translationX".equals(str)) {
                            com.oplus.camera.ui.d_renamed.this.bQ_renamed.setTranslationX(0.0f);
                        } else {
                            com.oplus.camera.ui.d_renamed.this.bQ_renamed.setTranslationY(0.0f);
                        }
                    }
                }
            });
            animatorSet.start();
            return;
        }
        fVar.setVisibility(8);
    }

    private void gd_renamed() {
        this.bQ_renamed = new com.oplus.camera.timelapsepro.f_renamed(this.i_renamed, new com.oplus.camera.timelapsepro.f_renamed.a_renamed() { // from class: com.oplus.camera.ui.d_renamed.70
            @Override // com.oplus.camera.timelapsepro.f_renamed.a_renamed
            public void a_renamed() {
                com.oplus.camera.ui.d_renamed.this.aA_renamed(true);
            }
        });
        this.bQ_renamed.setVisibility(8);
        ((android.widget.RelativeLayout) this.aa_renamed).addView(this.bQ_renamed);
        this.bQ_renamed.setCurrentScreenMode(this.bx_renamed);
    }

    @Override // com.oplus.camera.ui.CameraUIInterface
    public void aZ_renamed() {
        com.oplus.camera.timelapsepro.f_renamed fVar = this.bQ_renamed;
        if (fVar != null) {
            ((android.widget.RelativeLayout) this.aa_renamed).removeView(fVar);
            this.bQ_renamed = null;
        }
    }

    private void ge_renamed() throws android.content.res.Resources.NotFoundException {
        this.bO_renamed = new com.oplus.camera.ui.menu.facebeauty.RotateAnimationView(this.i_renamed);
        this.bO_renamed.setId(com.oplus.camera.R_renamed.id_renamed.time_lapse_pro_guide_button);
        this.bO_renamed.setImageResource(com.oplus.camera.R_renamed.drawable.professional_mode_guide_icon);
        this.bO_renamed.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.oplus.camera.ui.d_renamed.71
            @Override // android.view.View.OnClickListener
            public void onClick(android.view.View view) throws java.lang.IllegalStateException {
                com.oplus.camera.ui.d_renamed.this.aM_renamed(true);
            }
        });
        int dimensionPixelSize = (this.i_renamed.getApplication().getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.common_bottom_guide_professional_entry_touch_width) - this.bO_renamed.getDrawable().getIntrinsicWidth()) / 2;
        this.bO_renamed.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        int iN = com.oplus.camera.util.Util.N_renamed();
        android.widget.RelativeLayout relativeLayoutP = p_renamed();
        if (relativeLayoutP != null && relativeLayoutP.getTop() > iN) {
            iN = relativeLayoutP.getTop();
        }
        android.widget.RelativeLayout.LayoutParams layoutParams = new android.widget.RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(10);
        layoutParams.addRule(11);
        int dimensionPixelSize2 = iN + this.i_renamed.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.common_bottom_guide_professional_entry_margin_top);
        int dimensionPixelSize3 = this.i_renamed.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.time_lapse_pro_guide_entry_margin_end);
        layoutParams.topMargin = dimensionPixelSize2 - dimensionPixelSize;
        layoutParams.rightMargin = dimensionPixelSize3 - dimensionPixelSize;
        this.Z_renamed.addView(this.bO_renamed, layoutParams);
        ej_renamed().a_renamed(this.bO_renamed);
    }

    @Override // com.oplus.camera.ui.CameraUIInterface
    public void N_renamed(boolean z_renamed) {
        com.oplus.camera.e_renamed.a_renamed("CameraUIManager", "showTimeLapseProGuideButton, needAnim: " + z_renamed);
        if (R_renamed()) {
            return;
        }
        if (this.bO_renamed == null) {
            ge_renamed();
        }
        com.oplus.camera.ui.CameraUIListener cameraUIListener = this.J_renamed;
        if (cameraUIListener == null || !cameraUIListener.c_renamed()) {
            if (z_renamed) {
                com.oplus.camera.util.Util.a_renamed(this.bO_renamed, 250);
            } else {
                this.bO_renamed.setVisibility(0);
                this.bO_renamed.setEnabled(true);
            }
        }
    }

    @Override // com.oplus.camera.ui.CameraUIInterface
    public void O_renamed(boolean z_renamed) {
        com.oplus.camera.e_renamed.a_renamed("CameraUIManager", "hideTimeLapseProGuideButton, needAnim: " + z_renamed);
        com.oplus.camera.ui.menu.facebeauty.RotateAnimationView rotateAnimationView = this.bO_renamed;
        if (rotateAnimationView == null) {
            return;
        }
        if (z_renamed) {
            com.oplus.camera.util.Util.b_renamed(rotateAnimationView, 250);
        } else {
            rotateAnimationView.setVisibility(8);
        }
    }

    public boolean eL_renamed() {
        return this.bY_renamed;
    }

    @Override // com.oplus.camera.ui.CameraUIInterface
    public void s_renamed(boolean z_renamed, boolean z2) throws android.content.res.Resources.NotFoundException {
        if (this.A_renamed != null) {
            int i_renamed = this.bW_renamed;
            if (i_renamed < 0) {
                this.bW_renamed = -i_renamed;
            }
            d_renamed(z_renamed, z2, true);
        }
    }

    @Override // com.oplus.camera.ui.CameraUIInterface
    public void t_renamed(boolean z_renamed, boolean z2) throws android.content.res.Resources.NotFoundException {
        if (this.A_renamed != null) {
            int i_renamed = this.bW_renamed;
            if (i_renamed < 0) {
                this.bW_renamed = -i_renamed;
            }
            d_renamed(z_renamed, z2, false);
        }
    }

    private void a_renamed(android.view.View view, boolean z_renamed, android.animation.AnimatorSet animatorSet, android.animation.AnimatorListenerAdapter animatorListenerAdapter) {
        a_renamed(view, animatorSet, false, z_renamed, animatorListenerAdapter);
    }

    private void b_renamed(android.view.View view, boolean z_renamed, android.animation.AnimatorSet animatorSet, android.animation.AnimatorListenerAdapter animatorListenerAdapter) {
        a_renamed(view, animatorSet, true, z_renamed, animatorListenerAdapter);
    }

    /* JADX WARN: Removed duplicated region for block: B_renamed:32:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:33:0x0081  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void a_renamed(final android.view.View r7, android.animation.AnimatorSet r8, boolean r9, boolean r10, android.animation.AnimatorListenerAdapter r11) {
        /*
            r6 = this;
            if (r8 == 0) goto Lb
            boolean r0 = r8.isRunning()
            if (r0 == 0) goto Lb
            r8.cancel()
        Lb:
            java.lang.String r8 = "alpha"
            r0 = 2
            if (r9 == 0) goto L1a
            float[] r1 = new float[r0]
            r1 = {x00b0: FILL_ARRAY_DATA , data: [1065353216, 0} // fill-array
            android.animation.ObjectAnimator r8 = android.animation.ObjectAnimator.ofFloat(r7, r8, r1)
            goto L23
        L1a:
            float[] r1 = new float[r0]
            r1 = {x00b8: FILL_ARRAY_DATA , data: [0, 1065353216} // fill-array
            android.animation.ObjectAnimator r8 = android.animation.ObjectAnimator.ofFloat(r7, r8, r1)
        L23:
            android.view.animation.PathInterpolator r1 = r6.ba_renamed
            r8.setInterpolator(r1)
            if (r9 == 0) goto L2d
            r1 = 250(0xfa, double:1.235E-321)
            goto L35
        L2d:
            if (r10 == 0) goto L32
            r1 = 400(0x190, float:5.6E-43)
            goto L34
        L32:
            r1 = 250(0xfa, float:3.5E-43)
        L34:
            long r1 = (long) r1
        L35:
            r8.setDuration(r1)
            android.animation.AnimatorSet r1 = new android.animation.AnimatorSet
            r1.<init>()
            android.animation.AnimatorSet$Builder r8 = r1.play(r8)
            r2 = 0
            if (r10 == 0) goto L9e
            com.oplus.camera.screen.b_renamed.a_renamed r10 = r6.bx_renamed
            int r10 = r10.j_renamed()
            java.lang.String r3 = "translationX"
            r4 = 1
            if (r4 != r10) goto L60
            r10 = 270(0x10e, float:3.78E-43)
            com.oplus.camera.screen.b_renamed.a_renamed r5 = r6.bx_renamed
            int r5 = r5.k_renamed()
            if (r10 != r5) goto L5d
            int r10 = r6.bv_renamed
            int r10 = -r10
            goto L6b
        L5d:
            int r10 = r6.bv_renamed
            goto L6b
        L60:
            r10 = 4
            com.oplus.camera.screen.b_renamed.a_renamed r5 = r6.bx_renamed
            int r5 = r5.j_renamed()
            if (r10 != r5) goto L6d
            int r10 = r6.bv_renamed
        L6b:
            float r10 = (float) r10
            goto L73
        L6d:
            int r10 = r6.bv_renamed
            int r10 = -r10
            float r10 = (float) r10
            java.lang.String r3 = "translationY"
        L73:
            r5 = 0
            if (r9 == 0) goto L81
            float[] r9 = new float[r0]
            r9[r5] = r2
            r9[r4] = r10
            android.animation.ObjectAnimator r9 = android.animation.ObjectAnimator.ofFloat(r7, r3, r9)
            goto L90
        L81:
            float[] r9 = new float[r0]
            r9[r5] = r10
            r9[r4] = r2
            android.animation.ObjectAnimator r9 = android.animation.ObjectAnimator.ofFloat(r7, r3, r9)
            r2 = 150(0x96, double:7.4E-322)
            r1.setStartDelay(r2)
        L90:
            android.view.animation.PathInterpolator r10 = r6.bb_renamed
            r9.setInterpolator(r10)
            r2 = 400(0x190, double:1.976E-321)
            r9.setDuration(r2)
            r8.with(r9)
            goto La1
        L9e:
            r7.setTranslationY(r2)
        La1:
            r1.addListener(r11)
            com.oplus.camera.ui.d_renamed$72 r8 = new com.oplus.camera.ui.d_renamed$72
            r8.<init>()
            r1.addListener(r8)
            r1.start()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.ui.d_renamed.a_renamed(android.view.View, android.animation.AnimatorSet, boolean, boolean, android.animation.AnimatorListenerAdapter):void");
    }

    @Override // com.oplus.camera.ui.CameraUIInterface
    public com.oplus.camera.timelapsepro.g_renamed aY_renamed() throws android.content.res.Resources.NotFoundException {
        if (this.bP_renamed == null) {
            gf_renamed();
        }
        return this.bP_renamed;
    }

    @Override // com.oplus.camera.ui.CameraUIInterface
    public void ba_renamed() {
        A_renamed(true, true);
        if (1 == this.bx_renamed.j_renamed()) {
            w_renamed(false, true);
        } else if (4 == this.bx_renamed.j_renamed()) {
            g_renamed(4);
        }
    }

    @Override // com.oplus.camera.ui.CameraUIInterface
    public void bb_renamed() {
        A_renamed(true, true);
        if (1 == this.bx_renamed.j_renamed()) {
            w_renamed(false, true);
        } else if (4 == this.bx_renamed.j_renamed()) {
            g_renamed(4);
        }
    }

    @Override // com.oplus.camera.ui.CameraUIInterface
    public void Q_renamed(boolean z_renamed) {
        A_renamed(false, z_renamed);
        if (1 == this.bx_renamed.j_renamed()) {
            w_renamed(true, z_renamed);
        } else if (4 == this.bx_renamed.j_renamed()) {
            g_renamed(0);
        }
    }

    @Override // com.oplus.camera.ui.CameraUIInterface
    public void a_renamed(android.view.View.OnClickListener onClickListener) {
        this.cp_renamed = onClickListener;
    }

    public void eM_renamed() {
        Q_renamed(true);
        com.oplus.camera.timelapsepro.g_renamed gVar = this.bP_renamed;
        if (gVar != null) {
            d_renamed(false, false, gVar.c_renamed(), true);
        }
    }

    public void d_renamed(boolean z_renamed, boolean z2, boolean z3) throws android.content.res.Resources.NotFoundException {
        d_renamed(z_renamed, z2, z3, true);
    }

    public void d_renamed(boolean z_renamed, boolean z2, boolean z3, boolean z4) throws android.content.res.Resources.NotFoundException {
        this.bY_renamed = true;
        com.oplus.camera.e_renamed.a_renamed("CameraUIManager", "showTimeLapseProTemplatePanel, show : " + z_renamed + ", needAnimation : " + z2 + ", showTemplate : " + z3 + ", mbShowTimeLapseProPanel : " + this.bY_renamed);
        if (z_renamed) {
            if (this.bP_renamed == null) {
                gf_renamed();
                this.bP_renamed.setSettingValues(this.B_renamed.getString(com.oplus.camera.ui.CameraUIInterface.KEY_TIME_LAPSE_PRO_VIDEO_SPEED, this.i_renamed.getString(com.oplus.camera.R_renamed.string.time_lapse_pro_speed_15x)));
            }
            this.ca_renamed = this.B_renamed.getInt("pref_time_lapse_pro_template_key", 0);
            this.bP_renamed.a_renamed(this.ce_renamed);
            this.bP_renamed.setShowTemplate(z3);
            if (1 != this.bx_renamed.j_renamed() && !z3 && z4) {
                if (fh_renamed()) {
                    if (this.aJ_renamed != null) {
                        if (4 == this.bx_renamed.j_renamed() && this.bP_renamed.isShown()) {
                            this.aJ_renamed.b_renamed(false, -1);
                        } else {
                            this.aJ_renamed.b_renamed(android.view.animation.AnimationUtils.loadAnimation(this.i_renamed, com.oplus.camera.R_renamed.anim.zoom_panel_level_out));
                        }
                    }
                } else if (this.z_renamed != null) {
                    if (z2 && 4 != this.bx_renamed.j_renamed()) {
                        this.z_renamed.h_renamed();
                    } else {
                        this.z_renamed.a_renamed(0);
                    }
                }
            }
            if (4 == this.bx_renamed.j_renamed() && z3 && z4) {
                if (fh_renamed()) {
                    com.oplus.camera.ui.modepanel.m_renamed mVar = this.aJ_renamed;
                    if (mVar != null) {
                        mVar.a_renamed(false, -1);
                    }
                } else {
                    com.oplus.camera.ui.control.a_renamed aVar = this.z_renamed;
                    if (aVar != null) {
                        aVar.b_renamed(0);
                    }
                }
            }
            if (4 == this.bx_renamed.j_renamed()) {
                O_renamed(true);
            }
            if (z2) {
                aN_renamed(true);
                return;
            } else {
                this.bP_renamed.setVisibility(0);
                this.bY_renamed = false;
                return;
            }
        }
        com.oplus.camera.timelapsepro.g_renamed gVar = this.bP_renamed;
        if (gVar != null) {
            if (z2) {
                E_renamed(true, z3);
            } else {
                gVar.setVisibility(8);
                if (!z3) {
                    this.bP_renamed.e_renamed();
                }
                this.bY_renamed = false;
            }
            this.bP_renamed.m_renamed();
            if (1 != this.bx_renamed.j_renamed() && !z3 && !this.J_renamed.c_renamed() && z4) {
                if (fh_renamed()) {
                    com.oplus.camera.ui.modepanel.m_renamed mVar2 = this.aJ_renamed;
                    if (mVar2 != null) {
                        mVar2.a_renamed(android.view.animation.AnimationUtils.loadAnimation(this.i_renamed, com.oplus.camera.R_renamed.anim.zoom_panel_level_in));
                    }
                } else {
                    com.oplus.camera.ui.control.a_renamed aVar2 = this.z_renamed;
                    if (aVar2 != null) {
                        if (z2) {
                            aVar2.b_renamed(true, true);
                        } else {
                            aVar2.b_renamed(0);
                        }
                    }
                }
            }
            if (4 == this.bx_renamed.j_renamed()) {
                N_renamed(true);
            }
        }
    }

    private void aN_renamed(boolean z_renamed) {
        float f_renamed;
        java.lang.String str;
        android.animation.AnimatorSet animatorSet = this.bT_renamed;
        if (animatorSet != null && animatorSet.isStarted()) {
            this.bT_renamed.end();
        } else {
            if (this.bP_renamed.isShown()) {
                return;
            }
            android.animation.AnimatorSet animatorSet2 = this.bS_renamed;
            if (animatorSet2 != null && animatorSet2.isStarted()) {
                return;
            }
        }
        if (z_renamed) {
            this.bP_renamed.setAlpha(0.0f);
            this.bP_renamed.setVisibility(0);
            this.bS_renamed = new android.animation.AnimatorSet();
            android.animation.ObjectAnimator objectAnimatorOfFloat = android.animation.ObjectAnimator.ofFloat(this.bP_renamed, "alpha", 0.0f, 1.0f);
            objectAnimatorOfFloat.setInterpolator(this.ba_renamed);
            objectAnimatorOfFloat.setDuration(400L);
            if (1 == this.bx_renamed.j_renamed()) {
                f_renamed = 270 == this.bx_renamed.k_renamed() ? this.bW_renamed : -this.bW_renamed;
                str = "translationX";
            } else {
                f_renamed = this.bW_renamed;
                str = "translationY";
            }
            android.animation.ObjectAnimator objectAnimatorOfFloat2 = android.animation.ObjectAnimator.ofFloat(this.bP_renamed, str, f_renamed, 0.0f);
            objectAnimatorOfFloat2.setInterpolator(this.bb_renamed);
            objectAnimatorOfFloat2.setDuration(400L);
            this.bS_renamed.play(objectAnimatorOfFloat).with(objectAnimatorOfFloat2);
            this.bS_renamed.addListener(new android.animation.AnimatorListenerAdapter() { // from class: com.oplus.camera.ui.d_renamed.73
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(android.animation.Animator animator) {
                    if (com.oplus.camera.ui.d_renamed.this.bP_renamed != null) {
                        com.oplus.camera.ui.d_renamed.this.bP_renamed.setAnimationState(true);
                    }
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationCancel(android.animation.Animator animator) {
                    if (com.oplus.camera.ui.d_renamed.this.bP_renamed != null) {
                        com.oplus.camera.ui.d_renamed.this.bP_renamed.setAnimationState(false);
                    }
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(android.animation.Animator animator, boolean z2) {
                    if (com.oplus.camera.ui.d_renamed.this.bP_renamed != null) {
                        com.oplus.camera.ui.d_renamed.this.bP_renamed.setAlpha(1.0f);
                        com.oplus.camera.ui.d_renamed.this.bP_renamed.setTranslationY(0.0f);
                        com.oplus.camera.ui.d_renamed.this.bP_renamed.setTranslationX(0.0f);
                        com.oplus.camera.ui.d_renamed.this.bP_renamed.setVisibility(0);
                        com.oplus.camera.ui.d_renamed.this.bP_renamed.setAnimationState(false);
                    }
                    com.oplus.camera.ui.d_renamed.this.bY_renamed = false;
                }
            });
            this.bS_renamed.setStartDelay(150L);
            this.bS_renamed.start();
            return;
        }
        this.bP_renamed.setVisibility(0);
    }

    private void E_renamed(boolean z_renamed, final boolean z2) throws android.content.res.Resources.NotFoundException {
        float f_renamed;
        java.lang.String str;
        android.animation.AnimatorSet animatorSet = this.bS_renamed;
        if (animatorSet != null && animatorSet.isStarted()) {
            this.bS_renamed.cancel();
        } else {
            com.oplus.camera.timelapsepro.g_renamed gVar = this.bP_renamed;
            if (gVar != null && !gVar.isShown()) {
                return;
            }
            android.animation.AnimatorSet animatorSet2 = this.bT_renamed;
            if (animatorSet2 != null && animatorSet2.isStarted()) {
                return;
            }
        }
        if (z_renamed) {
            this.bT_renamed = new android.animation.AnimatorSet();
            android.animation.ObjectAnimator objectAnimatorOfFloat = android.animation.ObjectAnimator.ofFloat(this.bP_renamed, "alpha", 1.0f, 0.0f);
            objectAnimatorOfFloat.setInterpolator(this.ba_renamed);
            objectAnimatorOfFloat.setDuration(250L);
            if (1 == this.bx_renamed.j_renamed()) {
                f_renamed = 270 == this.bx_renamed.k_renamed() ? this.bW_renamed : -this.bW_renamed;
                str = "translationX";
            } else {
                f_renamed = this.bW_renamed;
                str = "translationY";
            }
            android.animation.ObjectAnimator objectAnimatorOfFloat2 = android.animation.ObjectAnimator.ofFloat(this.bP_renamed, str, 0.0f, f_renamed);
            objectAnimatorOfFloat2.setInterpolator(this.bb_renamed);
            objectAnimatorOfFloat2.setDuration(400L);
            this.bT_renamed.play(objectAnimatorOfFloat).with(objectAnimatorOfFloat2);
            this.bT_renamed.addListener(new android.animation.AnimatorListenerAdapter() { // from class: com.oplus.camera.ui.d_renamed.74
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(android.animation.Animator animator) throws android.content.res.Resources.NotFoundException {
                    if (com.oplus.camera.ui.d_renamed.this.bP_renamed != null) {
                        com.oplus.camera.ui.d_renamed.this.bP_renamed.setVisibility(8);
                        com.oplus.camera.ui.d_renamed.this.bP_renamed.setTranslationY(0.0f);
                        com.oplus.camera.ui.d_renamed.this.bP_renamed.setTranslationX(0.0f);
                        com.oplus.camera.ui.d_renamed.this.bP_renamed.setAlpha(0.0f);
                        com.oplus.camera.ui.d_renamed.this.bP_renamed.setAnimationState(false);
                        if (!z2) {
                            com.oplus.camera.ui.d_renamed.this.bP_renamed.e_renamed();
                        }
                    }
                    com.oplus.camera.ui.d_renamed.this.bY_renamed = false;
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationCancel(android.animation.Animator animator) {
                    if (com.oplus.camera.ui.d_renamed.this.bP_renamed != null) {
                        com.oplus.camera.ui.d_renamed.this.bP_renamed.setAnimationState(false);
                    }
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(android.animation.Animator animator) {
                    if (com.oplus.camera.ui.d_renamed.this.bP_renamed != null) {
                        com.oplus.camera.ui.d_renamed.this.bP_renamed.setAnimationState(true);
                        com.oplus.camera.ui.d_renamed.this.bP_renamed.setVisibility(0);
                        com.oplus.camera.ui.d_renamed.this.bP_renamed.setTranslationY(0.0f);
                        com.oplus.camera.ui.d_renamed.this.bP_renamed.setTranslationX(0.0f);
                        com.oplus.camera.ui.d_renamed.this.bP_renamed.setAlpha(1.0f);
                    }
                }
            });
            this.bT_renamed.start();
            return;
        }
        com.oplus.camera.timelapsepro.g_renamed gVar2 = this.bP_renamed;
        if (gVar2 != null) {
            gVar2.setVisibility(8);
            if (z2) {
                return;
            }
            this.bP_renamed.e_renamed();
        }
    }

    private void gf_renamed() throws android.content.res.Resources.NotFoundException {
        this.bW_renamed = this.i_renamed.getApplication().getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.face_beauty_menu_translate_y);
        this.bP_renamed = new com.oplus.camera.timelapsepro.g_renamed(this.i_renamed, this.B_renamed);
        this.bP_renamed.setCurrentScreenMode(this.bx_renamed);
        this.bP_renamed.setId(com.oplus.camera.R_renamed.id_renamed.time_lapse_pro_layout);
        this.bP_renamed.setVisibility(8);
        android.widget.RelativeLayout.LayoutParams layoutParams = new android.widget.RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        layoutParams.bottomMargin = this.i_renamed.getApplication().getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.time_lapse_pro_panel_margin_bottom_vertical);
        this.bP_renamed.setHintCallback(new com.oplus.camera.timelapsepro.g_renamed.a_renamed() { // from class: com.oplus.camera.ui.d_renamed.76
            @Override // com.oplus.camera.timelapsepro.g_renamed.a_renamed
            public void a_renamed(int i_renamed, boolean z_renamed, java.lang.Object... objArr) {
                if (com.oplus.camera.ui.d_renamed.this.ac_renamed != null) {
                    if (-1 != i_renamed) {
                        com.oplus.camera.ui.d_renamed.this.ac_renamed.a_renamed(i_renamed, !z_renamed, z_renamed, 3000, com.oplus.camera.R_renamed.drawable.screen_hint_textview_bg, com.oplus.camera.R_renamed.color.screen_hint_text_color, 0, false, false, true, -1, objArr);
                    } else {
                        com.oplus.camera.ui.d_renamed.this.ac_renamed.c_renamed(true);
                    }
                }
            }
        });
        this.Z_renamed.addView(this.bP_renamed, layoutParams);
        ej_renamed().a__renamed(this.i_renamed);
        ej_renamed().a_renamed(this.bP_renamed);
    }

    @Override // com.oplus.camera.ui.CameraUIInterface
    public void u_renamed(boolean z_renamed, boolean z2) throws android.content.res.Resources.NotFoundException {
        com.oplus.camera.e_renamed.a_renamed("CameraUIManager", "showTimeLapseProRecord, show: " + z_renamed + ", needAnimation: " + z2);
        com.oplus.camera.timelapsepro.g_renamed gVar = this.bP_renamed;
        if (gVar != null && gVar.isShown()) {
            int i_renamed = this.bW_renamed;
            if (i_renamed > 0) {
                this.bW_renamed = -i_renamed;
            }
            d_renamed(!z_renamed, 1 != this.bx_renamed.j_renamed(), this.bP_renamed.c_renamed());
            if (1 == this.bx_renamed.j_renamed()) {
                A_renamed(false, false);
            }
        }
        if (z_renamed) {
            if (this.bR_renamed == null) {
                gg_renamed();
            }
            this.bR_renamed.a_renamed(0L, 0L, true);
            aO_renamed(z2);
            return;
        }
        if (this.bR_renamed != null) {
            aP_renamed(z2);
        }
    }

    private void aO_renamed(boolean z_renamed) {
        android.animation.AnimatorSet animatorSet;
        com.oplus.camera.e_renamed.a_renamed("CameraUIManager", "showRecord, needAnim: " + z_renamed);
        if (!z_renamed) {
            this.bR_renamed.setVisibility(0);
            return;
        }
        android.animation.AnimatorSet animatorSet2 = this.bV_renamed;
        if (animatorSet2 != null && animatorSet2.isStarted()) {
            com.oplus.camera.e_renamed.a_renamed("CameraUIManager", "hideRecord, end hide. ");
            this.bV_renamed.end();
        } else if (this.bR_renamed.isShown() || ((animatorSet = this.bU_renamed) != null && animatorSet.isStarted())) {
            com.oplus.camera.e_renamed.a_renamed("CameraUIManager", "showRecord, return. ");
            return;
        }
        this.bR_renamed.setAlpha(0.0f);
        if (1 != this.bx_renamed.j_renamed()) {
            this.bR_renamed.setTranslationY(-this.bX_renamed);
        }
        this.bR_renamed.setVisibility(0);
        this.bU_renamed = new android.animation.AnimatorSet();
        android.animation.ObjectAnimator objectAnimatorOfFloat = android.animation.ObjectAnimator.ofFloat(this.bR_renamed, "alpha", 0.0f, 1.0f);
        objectAnimatorOfFloat.setInterpolator(this.ba_renamed);
        objectAnimatorOfFloat.setDuration(300L);
        if (1 != this.bx_renamed.j_renamed()) {
            android.animation.ObjectAnimator objectAnimatorOfFloat2 = android.animation.ObjectAnimator.ofFloat(this.bR_renamed, "translationY", this.bX_renamed, 0.0f);
            objectAnimatorOfFloat2.setInterpolator(this.bb_renamed);
            objectAnimatorOfFloat2.setDuration(300L);
            this.bU_renamed.play(objectAnimatorOfFloat).with(objectAnimatorOfFloat2);
        } else {
            this.bU_renamed.play(objectAnimatorOfFloat);
        }
        this.bU_renamed.addListener(new android.animation.AnimatorListenerAdapter() { // from class: com.oplus.camera.ui.d_renamed.77
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(android.animation.Animator animator) {
                if (com.oplus.camera.ui.d_renamed.this.bR_renamed != null) {
                    com.oplus.camera.ui.d_renamed.this.bR_renamed.setAlpha(1.0f);
                    com.oplus.camera.ui.d_renamed.this.bR_renamed.setTranslationY(0.0f);
                    com.oplus.camera.ui.d_renamed.this.bR_renamed.setVisibility(0);
                }
            }
        });
        this.bU_renamed.setStartDelay(150L);
        this.bU_renamed.start();
    }

    private void aP_renamed(boolean z_renamed) {
        android.animation.AnimatorSet animatorSet;
        com.oplus.camera.e_renamed.a_renamed("CameraUIManager", "hideRecord, needAnim: " + z_renamed);
        if (!z_renamed) {
            this.bR_renamed.setVisibility(8);
            this.bR_renamed.a_renamed();
            return;
        }
        android.animation.AnimatorSet animatorSet2 = this.bU_renamed;
        if (animatorSet2 != null && animatorSet2.isStarted()) {
            com.oplus.camera.e_renamed.a_renamed("CameraUIManager", "hideRecord, cancel show. ");
            this.bU_renamed.cancel();
        } else {
            com.oplus.camera.timelapsepro.i_renamed iVar = this.bR_renamed;
            if ((iVar != null && !iVar.isShown()) || ((animatorSet = this.bV_renamed) != null && animatorSet.isStarted())) {
                com.oplus.camera.e_renamed.a_renamed("CameraUIManager", "hideRecord, return. ");
                return;
            }
        }
        this.bV_renamed = new android.animation.AnimatorSet();
        android.animation.ObjectAnimator objectAnimatorOfFloat = android.animation.ObjectAnimator.ofFloat(this.bR_renamed, "alpha", 1.0f, 0.0f);
        objectAnimatorOfFloat.setInterpolator(this.ba_renamed);
        objectAnimatorOfFloat.setDuration(250L);
        if (1 != this.bx_renamed.j_renamed()) {
            android.animation.ObjectAnimator objectAnimatorOfFloat2 = android.animation.ObjectAnimator.ofFloat(this.bR_renamed, "translationY", 0.0f, this.bX_renamed);
            objectAnimatorOfFloat2.setInterpolator(this.bb_renamed);
            objectAnimatorOfFloat2.setDuration(300L);
            this.bV_renamed.play(objectAnimatorOfFloat).with(objectAnimatorOfFloat2);
        } else {
            this.bV_renamed.play(objectAnimatorOfFloat);
        }
        this.bV_renamed.addListener(new android.animation.AnimatorListenerAdapter() { // from class: com.oplus.camera.ui.d_renamed.78
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(android.animation.Animator animator) {
                if (com.oplus.camera.ui.d_renamed.this.bR_renamed != null) {
                    com.oplus.camera.ui.d_renamed.this.bR_renamed.setVisibility(0);
                    com.oplus.camera.ui.d_renamed.this.bR_renamed.setTranslationY(0.0f);
                    com.oplus.camera.ui.d_renamed.this.bR_renamed.setAlpha(1.0f);
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(android.animation.Animator animator) {
                if (com.oplus.camera.ui.d_renamed.this.bR_renamed != null) {
                    com.oplus.camera.ui.d_renamed.this.bR_renamed.setVisibility(8);
                    com.oplus.camera.ui.d_renamed.this.bR_renamed.setTranslationY(0.0f);
                    com.oplus.camera.ui.d_renamed.this.bR_renamed.setAlpha(0.0f);
                    com.oplus.camera.ui.d_renamed.this.bR_renamed.a_renamed();
                }
            }
        });
        this.bV_renamed.start();
    }

    private void gg_renamed() {
        this.bX_renamed = this.i_renamed.getApplication().getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.face_beauty_menu_translate_y);
        this.bR_renamed = new com.oplus.camera.timelapsepro.i_renamed(this.i_renamed);
        this.bR_renamed.setId(com.oplus.camera.R_renamed.id_renamed.time_lapse_pro_record_layout);
        this.bR_renamed.setVisibility(8);
        android.widget.RelativeLayout.LayoutParams layoutParams = new android.widget.RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        if (2 == this.bx_renamed.j_renamed() || 3 == this.bx_renamed.j_renamed()) {
            layoutParams.bottomMargin = this.i_renamed.getApplication().getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.time_lapse_pro_panel_margin_bottom_vertical);
        } else {
            layoutParams.bottomMargin = this.i_renamed.getApplication().getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.time_lapse_pro_record_margin_bottom_full_screen);
        }
        this.Z_renamed.addView(this.bR_renamed, layoutParams);
    }

    @Override // com.oplus.camera.ui.CameraUIInterface
    public void a_renamed(long j_renamed, long j2, boolean z_renamed) {
        com.oplus.camera.timelapsepro.i_renamed iVar = this.bR_renamed;
        if (iVar != null) {
            iVar.a_renamed(j_renamed, j2, z_renamed);
        }
    }

    public void D_renamed(boolean z_renamed, boolean z2) {
        if (com.oplus.camera.aps.constant.ApsConstant.REC_MODE_TIMELASPE_PRO.equals(aV_renamed())) {
            if (1 == this.bx_renamed.j_renamed() || 4 == this.bx_renamed.j_renamed()) {
                w_renamed(true, z_renamed);
            }
            com.oplus.camera.timelapsepro.g_renamed gVar = this.bP_renamed;
            if (gVar != null && gVar.isShown()) {
                A_renamed(false, false);
                d_renamed(false, z_renamed, this.bP_renamed.c_renamed());
                this.bP_renamed.o_renamed();
            }
            com.oplus.camera.ui.menu.facebeauty.RotateAnimationView rotateAnimationView = this.bM_renamed;
            if (rotateAnimationView != null && !rotateAnimationView.isShown() && !com.oplus.camera.e_renamed.a_renamed.a_renamed(cv_renamed())) {
                o_renamed(z_renamed, z2);
            }
            com.oplus.camera.ui.menu.facebeauty.RotateAnimationView rotateAnimationView2 = this.bN_renamed;
            if (rotateAnimationView2 != null && !rotateAnimationView2.isShown() && !com.oplus.camera.e_renamed.a_renamed.a_renamed(cv_renamed())) {
                q_renamed(z_renamed, z2);
            }
            if (this.J_renamed == null || dr_renamed()) {
                return;
            }
            this.J_renamed.a_renamed(z2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gh_renamed() {
        int dimensionPixelSize;
        if (this.aL_renamed == null) {
            return;
        }
        if (this.aR_renamed == null && (dimensionPixelSize = b_renamed().getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.face_beauty_enter_button_extra_touch_offset)) > 0) {
            android.graphics.Rect rect = new android.graphics.Rect();
            this.aL_renamed.getHitRect(rect);
            rect.top -= dimensionPixelSize;
            rect.bottom += dimensionPixelSize;
            rect.left -= dimensionPixelSize;
            rect.right += dimensionPixelSize;
            this.aR_renamed = new android.view.TouchDelegate(rect, this.aL_renamed);
        }
        this.aL_renamed.post(new java.lang.Runnable() { // from class: com.oplus.camera.ui.-$$Lambda$d_renamed$z0tanxuDFc6k0cSWABJt1aRm6O4
            @Override // java.lang.Runnable
            public final void run() {
                this.f_renamed$0.gl_renamed();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void gl_renamed() {
        if (b_renamed() != null) {
            b_renamed().setTouchDelegate(this.aR_renamed);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gi_renamed() {
        com.oplus.camera.ui.widget.SplitBackgroundView splitBackgroundView = this.aL_renamed;
        if (splitBackgroundView != null) {
            splitBackgroundView.post(new java.lang.Runnable() { // from class: com.oplus.camera.ui.-$$Lambda$d_renamed$or4ynPWLgqFW2Og7DEsPz6PP_nA
                @Override // java.lang.Runnable
                public final void run() {
                    this.f_renamed$0.gk_renamed();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void gk_renamed() {
        if (b_renamed() != null) {
            android.graphics.Rect rect = new android.graphics.Rect();
            rect.setEmpty();
            b_renamed().setTouchDelegate(new android.view.TouchDelegate(rect, this.aL_renamed));
        }
    }

    public void aB_renamed(boolean z_renamed) {
        this.r_renamed = z_renamed;
    }

    private void gj_renamed() {
        android.view.WindowInsetsController insetsController;
        android.app.Activity activity = this.i_renamed;
        if (activity == null || (insetsController = activity.getWindow().getInsetsController()) == null || !com.oplus.camera.util.Util.t_renamed()) {
            return;
        }
        if (1 == ej_renamed().j_renamed() && ej_renamed().k_renamed() != 0) {
            insetsController.hide(android.view.WindowInsets.Type.navigationBars());
        } else {
            insetsController.show(android.view.WindowInsets.Type.navigationBars());
        }
    }

    public void aC_renamed(boolean z_renamed) {
        com.oplus.camera.ui.preview.g_renamed gVar = this.A_renamed;
        if (gVar != null) {
            gVar.q_renamed(z_renamed);
        }
    }

    @Override // com.oplus.camera.ui.preview.g_renamed.b_renamed
    public void a_renamed(int i_renamed, int i2, int i3, int i4) {
        for (com.oplus.camera.ui.widget.SplitBackgroundView splitBackgroundView : this.cc_renamed) {
            if (splitBackgroundView != null) {
                splitBackgroundView.a_renamed(i_renamed, i2, i3, i4);
            }
        }
    }

    public void a_renamed(java.lang.Runnable runnable) {
        this.A_renamed.a_renamed(runnable);
    }

    public boolean eN_renamed() {
        com.oplus.camera.ui.menu.facebeauty.g_renamed gVar = this.aT_renamed;
        return gVar != null && gVar.j_renamed();
    }
}

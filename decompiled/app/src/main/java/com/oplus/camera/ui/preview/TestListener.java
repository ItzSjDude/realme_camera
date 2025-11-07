package com.oplus.camera.ui.preview;

/* compiled from: CameraPreviewUI.java */
/* loaded from: classes2.dex */
public class g_renamed implements android.view.View.OnLayoutChangeListener, com.oplus.camera.d_renamed, com.oplus.camera.ui.preview.PreviewFrameLayout.OnSizeChangedListener, com.oplus.camera.ui.preview.h_renamed.c_renamed, com.oplus.camera.ui.preview.k_renamed.b_renamed {
    private static final java.lang.String g_renamed = com.oplus.camera.v_renamed.a_renamed();
    private static android.graphics.Bitmap h_renamed = null;
    private float V_renamed;
    private float W_renamed;
    private android.app.Activity X_renamed;
    private com.oplus.camera.ComboPreferences Y_renamed;
    private com.oplus.camera.ui.preview.g_renamed.b_renamed ak_renamed;
    private boolean bg_renamed;
    private java.lang.Runnable bq_renamed;
    private volatile boolean j_renamed = false;
    private volatile int k_renamed = 0;
    private android.view.animation.PathInterpolator l_renamed = new android.view.animation.PathInterpolator(0.33f, 0.0f, 0.67f, 1.0f);
    private android.view.animation.PathInterpolator m_renamed = new android.view.animation.PathInterpolator(0.3f, 0.0f, 0.1f, 1.0f);
    private android.view.animation.PathInterpolator n_renamed = new android.view.animation.PathInterpolator(0.35f, 0.62f, 0.2f, 1.0f);
    private java.lang.Object o_renamed = new java.lang.Object();
    private boolean p_renamed = false;
    private boolean q_renamed = false;
    private boolean r_renamed = false;
    private boolean s_renamed = false;
    private boolean t_renamed = false;
    private boolean u_renamed = false;
    private boolean v_renamed = false;
    private boolean w_renamed = false;
    private boolean x_renamed = false;
    private boolean y_renamed = false;
    private boolean z_renamed = false;
    private boolean A_renamed = false;
    private int B_renamed = 0;
    private int C_renamed = 0;
    private int D_renamed = 0;
    private int E_renamed = 0;
    private int F_renamed = 0;
    private int G_renamed = 0;
    private int H_renamed = 0;
    private int I_renamed = 0;
    private int J_renamed = 0;
    private int K_renamed = 0;
    private int L_renamed = 0;
    private int M_renamed = 0;
    private int N_renamed = 0;
    private java.util.ArrayList<com.oplus.camera.ui.preview.g_renamed.e_renamed> O_renamed = new java.util.ArrayList<>();
    private int P_renamed = 90;
    private int Q_renamed = 0;
    private int R_renamed = 0;
    private int S_renamed = 0;
    private int T_renamed = 0;
    private long U_renamed = 0;
    private com.oplus.camera.ui.preview.h_renamed Z_renamed = null;
    private com.coui.appcompat.dialog.app.b_renamed aa_renamed = null;
    private com.coui.appcompat.dialog.app.b_renamed.a_renamed ab_renamed = null;
    private com.oplus.camera.ui.preview.FaceView ac_renamed = null;
    private com.oplus.camera.ui.preview.ac_renamed ad_renamed = null;
    private com.oplus.camera.ui.preview.MultiFocusView ae_renamed = null;
    private com.oplus.camera.ui.preview.IntelligentDragView af_renamed = null;
    private com.oplus.camera.ui.preview.z_renamed ag_renamed = null;
    private int ah_renamed = 1;
    private int ai_renamed = 0;
    private int aj_renamed = 0;
    private com.oplus.camera.ui.preview.g_renamed.c_renamed al_renamed = null;
    private android.widget.ImageView am_renamed = null;
    private com.oplus.camera.ui.preview.e_renamed an_renamed = null;
    private android.widget.ImageView ao_renamed = null;
    private com.oplus.camera.ui.preview.PreviewFrameLayout ap_renamed = null;
    private android.widget.RelativeLayout.LayoutParams aq_renamed = null;
    private com.oplus.camera.ui.preview.p_renamed ar_renamed = null;
    private com.oplus.camera.ui.preview.r_renamed as_renamed = null;
    private android.widget.ImageView at_renamed = null;
    private android.widget.RelativeLayout au_renamed = null;
    private android.graphics.Bitmap av_renamed = null;
    private java.lang.String aw_renamed = null;
    private java.lang.String ax_renamed = "off";
    private android.util.Size ay_renamed = null;
    private android.graphics.SurfaceTexture az_renamed = null;
    private android.view.Surface aA_renamed = null;
    private android.util.Size aB_renamed = null;
    private android.util.Size aC_renamed = null;
    private int aD_renamed = 0;
    private int aE_renamed = 0;
    private android.util.Size aF_renamed = null;
    private android.util.Size aG_renamed = null;
    private int aH_renamed = 0;
    private com.oplus.camera.ui.preview.g_renamed.a_renamed aI_renamed = null;
    private boolean aJ_renamed = false;
    private com.oplus.camera.ui.preview.h_renamed.d_renamed aK_renamed = null;
    private com.oplus.camera.gl_renamed.GLRootView aL_renamed = null;
    private com.oplus.camera.ui.RotableTextView aM_renamed = null;
    private com.oplus.camera.ui.t_renamed aN_renamed = null;
    private com.oplus.camera.ui.preview.HyperLapseFocusView aO_renamed = null;
    private com.coui.appcompat.widget.s_renamed aP_renamed = null;
    private int aQ_renamed = 0;
    private android.widget.ImageView aR_renamed = null;
    private com.oplus.camera.ui.widget.a_renamed aS_renamed = null;
    private boolean aT_renamed = false;
    private android.animation.AnimatorSet aU_renamed = null;
    private android.animation.AnimatorSet aV_renamed = null;
    private int aW_renamed = 0;
    private android.animation.AnimatorSet aX_renamed = null;
    private android.animation.AnimatorSet aY_renamed = null;
    private int aZ_renamed = 0;
    private androidx.recyclerview.widget.RecyclerView ba_renamed = null;
    private com.oplus.camera.doubleexposure.e_renamed.b_renamed bb_renamed = null;
    private com.oplus.camera.screen.out.e_renamed bc_renamed = null;
    private java.lang.Thread bd_renamed = null;
    private boolean be_renamed = true;
    private boolean bf_renamed = false;
    private java.util.ArrayList<com.oplus.camera.ui.preview.x_renamed> bh_renamed = new java.util.ArrayList<>();
    private com.oplus.camera.screen.b_renamed.a_renamed bi_renamed = null;
    private android.util.Size bj_renamed = new android.util.Size(0, 0);
    private java.lang.String bk_renamed = "";
    private android.util.Size bl_renamed = new android.util.Size(0, 0);
    private int bm_renamed = 0;
    private int bn_renamed = 0;
    private int bo_renamed = 0;
    private int bp_renamed = 0;
    private android.os.Handler br_renamed = new android.os.Handler() { // from class: com.oplus.camera.ui.preview.g_renamed.1
        @Override // android.os.Handler
        public void handleMessage(android.os.Message message) {
            int i_renamed = message.what;
            if (i_renamed == 1) {
                com.oplus.camera.ui.preview.g_renamed.this.aC_renamed();
                return;
            }
            if (i_renamed == 2) {
                com.oplus.camera.ui.preview.g_renamed.this.aD_renamed();
                return;
            }
            if (i_renamed != 3) {
                if (i_renamed == 4 && com.oplus.camera.ui.preview.g_renamed.this.aN_renamed != null && com.oplus.camera.ui.preview.g_renamed.this.aN_renamed.getVisibility() == 0) {
                    com.oplus.camera.ui.preview.g_renamed.this.aN_renamed.setVisibility(8);
                    return;
                }
                return;
            }
            if (com.oplus.camera.ui.preview.g_renamed.this.aN_renamed == null || com.oplus.camera.ui.preview.g_renamed.this.aN_renamed.getVisibility() == 0) {
                return;
            }
            com.oplus.camera.ui.preview.g_renamed.this.aN_renamed.setVisibility(0);
        }
    };
    private final com.oplus.camera.gl_renamed.GLView bs_renamed = new com.oplus.camera.gl_renamed.GLView() { // from class: com.oplus.camera.ui.preview.g_renamed.11
        @Override // com.oplus.camera.gl_renamed.GLView
        protected void b_renamed(com.oplus.camera.gl_renamed.h_renamed hVar) {
            super.b_renamed(hVar);
        }

        @Override // com.oplus.camera.gl_renamed.GLView
        public void a_renamed(int i_renamed, int i2, int i3, int i4) {
            super.a_renamed(i_renamed, i2, i3, i4);
        }

        @Override // com.oplus.camera.gl_renamed.GLView
        protected void f_renamed() {
            com.oplus.camera.ui.preview.g_renamed.this.Z_renamed.r_renamed();
        }

        @Override // com.oplus.camera.gl_renamed.GLView
        protected void a_renamed(int i_renamed, int i2) {
            com.oplus.camera.ui.preview.g_renamed.this.Z_renamed.b_renamed(i_renamed, i2);
        }

        @Override // com.oplus.camera.gl_renamed.GLView
        protected void a_renamed(com.oplus.camera.gl_renamed.h_renamed hVar) {
            int i_renamed = 1;
            if (com.oplus.camera.ui.preview.g_renamed.this.Z_renamed.h_renamed()) {
                com.oplus.camera.e_renamed.a_renamed("CameraPreviewUI", "render, last wanted frame already drawn, prevent from drawing more frames");
                if (com.oplus.camera.ui.preview.g_renamed.this.aL_renamed != null) {
                    com.oplus.camera.ui.preview.g_renamed.this.aL_renamed.setPreventRenderByPause(true);
                    return;
                }
                return;
            }
            com.oplus.camera.ui.preview.g_renamed gVar = com.oplus.camera.ui.preview.g_renamed.this;
            gVar.a_renamed((gVar.ap_renamed.getRight() - com.oplus.camera.ui.preview.g_renamed.this.ap_renamed.getLeft()) / 2, (com.oplus.camera.ui.preview.g_renamed.this.ap_renamed.getBottom() - com.oplus.camera.ui.preview.g_renamed.this.ap_renamed.getTop()) / 2, false, com.oplus.camera.ui.preview.g_renamed.this.ay_renamed(), false);
            hVar.a_renamed(new float[]{1.0f, com.oplus.camera.util.c_renamed.a_renamed(0.0f), com.oplus.camera.util.c_renamed.b_renamed(0.0f), com.oplus.camera.util.c_renamed.c_renamed(0.0f)});
            if (com.oplus.camera.ui.preview.g_renamed.this.y_renamed) {
                hVar.a_renamed(new float[]{1.0f, ((android.graphics.Color.red(com.oplus.camera.ui.preview.g_renamed.this.M_renamed) / 255.0f) * android.graphics.Color.alpha(com.oplus.camera.ui.preview.g_renamed.this.M_renamed)) / 255.0f, ((android.graphics.Color.green(com.oplus.camera.ui.preview.g_renamed.this.M_renamed) / 255.0f) * android.graphics.Color.alpha(com.oplus.camera.ui.preview.g_renamed.this.M_renamed)) / 255.0f, ((android.graphics.Color.blue(com.oplus.camera.ui.preview.g_renamed.this.M_renamed) / 255.0f) * android.graphics.Color.alpha(com.oplus.camera.ui.preview.g_renamed.this.M_renamed)) / 255.0f});
            }
            synchronized (com.oplus.camera.ui.preview.g_renamed.this.o_renamed) {
                if (com.oplus.camera.ui.preview.g_renamed.this.L_renamed != 0 && !com.oplus.camera.ui.preview.g_renamed.this.aJ_renamed) {
                    float fUptimeMillis = android.os.SystemClock.uptimeMillis() - com.oplus.camera.ui.preview.g_renamed.this.U_renamed;
                    if (fUptimeMillis < com.oplus.camera.ui.preview.g_renamed.this.W_renamed) {
                        float interpolation = com.oplus.camera.ui.preview.g_renamed.this.i_renamed.getInterpolation(fUptimeMillis / com.oplus.camera.ui.preview.g_renamed.this.W_renamed);
                        com.oplus.camera.ui.preview.g_renamed.this.I_renamed = com.oplus.camera.ui.preview.g_renamed.this.aG_renamed.getHeight() + ((int) (com.oplus.camera.ui.preview.g_renamed.this.L_renamed * interpolation));
                        com.oplus.camera.ui.preview.g_renamed.this.B_renamed = com.oplus.camera.ui.preview.g_renamed.this.C_renamed - ((int) ((com.oplus.camera.ui.preview.g_renamed.this.L_renamed / 2) * interpolation));
                    } else {
                        com.oplus.camera.ui.preview.g_renamed.this.I_renamed = com.oplus.camera.ui.preview.g_renamed.this.aF_renamed.getHeight();
                        if (com.oplus.camera.ui.preview.g_renamed.this.w_renamed) {
                            com.oplus.camera.ui.preview.g_renamed.this.B_renamed = com.oplus.camera.ui.preview.g_renamed.this.D_renamed;
                        }
                        com.oplus.camera.ui.preview.g_renamed.this.L_renamed = 0;
                        com.oplus.camera.ui.preview.g_renamed.this.D_renamed = 0;
                    }
                }
            }
            synchronized (com.oplus.camera.ui.preview.g_renamed.this.o_renamed) {
                if (com.oplus.camera.ui.preview.g_renamed.this.K_renamed != 0 && !com.oplus.camera.ui.preview.g_renamed.this.aJ_renamed) {
                    if (android.os.SystemClock.uptimeMillis() - com.oplus.camera.ui.preview.g_renamed.this.U_renamed < com.oplus.camera.ui.preview.g_renamed.this.W_renamed) {
                        com.oplus.camera.ui.preview.g_renamed.e_renamed eVarAH = com.oplus.camera.ui.preview.g_renamed.this.K_renamed > 0 ? com.oplus.camera.ui.preview.g_renamed.this.aH_renamed() : com.oplus.camera.ui.preview.g_renamed.this.aI_renamed();
                        if (eVarAH != null) {
                            com.oplus.camera.ui.preview.g_renamed.this.E_renamed = eVarAH.f7071a;
                            com.oplus.camera.ui.preview.g_renamed.this.J_renamed = eVarAH.f7072b;
                        } else {
                            com.oplus.camera.ui.preview.g_renamed.this.E_renamed = com.oplus.camera.ui.preview.g_renamed.this.F_renamed;
                            com.oplus.camera.ui.preview.g_renamed.this.J_renamed = com.oplus.camera.ui.preview.g_renamed.this.aG_renamed.getWidth();
                        }
                        com.oplus.camera.ui.a_renamed aVarA = com.oplus.camera.ui.a_renamed.a_renamed(com.oplus.camera.ui.preview.g_renamed.this.X_renamed);
                        if (com.oplus.camera.ui.preview.g_renamed.this.K_renamed <= 0) {
                            i_renamed = 2;
                        }
                        aVarA.b_renamed(i_renamed);
                    } else {
                        com.oplus.camera.ui.preview.g_renamed.this.J_renamed = com.oplus.camera.ui.preview.g_renamed.this.aF_renamed.getWidth();
                        if (com.oplus.camera.ui.preview.g_renamed.this.x_renamed) {
                            com.oplus.camera.ui.preview.g_renamed.this.E_renamed = com.oplus.camera.ui.preview.g_renamed.this.G_renamed;
                        }
                        com.oplus.camera.ui.preview.g_renamed.this.K_renamed = 0;
                        com.oplus.camera.ui.preview.g_renamed.this.H_renamed = 0;
                        com.oplus.camera.ui.preview.g_renamed.this.G_renamed = 0;
                        com.oplus.camera.ui.preview.g_renamed.this.O_renamed.clear();
                        com.oplus.camera.ui.a_renamed.a_renamed(com.oplus.camera.ui.preview.g_renamed.this.X_renamed).a_renamed();
                    }
                }
            }
            if (com.oplus.camera.util.Util.t_renamed()) {
                com.oplus.camera.ui.preview.g_renamed.this.aK_renamed();
            }
            synchronized (com.oplus.camera.ui.preview.g_renamed.this.o_renamed) {
                if (com.oplus.camera.ui.preview.g_renamed.this.aJ_renamed && android.os.SystemClock.uptimeMillis() - com.oplus.camera.ui.preview.g_renamed.this.U_renamed >= com.oplus.camera.ui.preview.g_renamed.this.W_renamed) {
                    com.oplus.camera.ui.preview.g_renamed.this.aF_renamed();
                }
            }
            if (com.oplus.camera.util.Util.t_renamed()) {
                com.oplus.camera.ui.preview.g_renamed.this.aL_renamed();
            }
            com.oplus.camera.ui.preview.g_renamed.this.a_renamed(hVar);
            com.oplus.camera.ui.preview.g_renamed.this.Z_renamed.a_renamed(hVar, (com.oplus.camera.ui.menu.levelcontrol.j_renamed) null, com.oplus.camera.ui.preview.g_renamed.this.au_renamed(), com.oplus.camera.ui.preview.g_renamed.this.av_renamed(), com.oplus.camera.ui.preview.g_renamed.this.aw_renamed(), com.oplus.camera.ui.preview.g_renamed.this.ax_renamed());
            com.oplus.camera.ui.preview.g_renamed.this.b_renamed(hVar);
        }

        @Override // com.oplus.camera.gl_renamed.GLView
        protected void a_renamed(com.oplus.camera.gl_renamed.h_renamed hVar, int i_renamed) {
            if (com.oplus.camera.ui.preview.g_renamed.this.Z_renamed != null) {
                if (i_renamed == 0) {
                    com.oplus.camera.ui.preview.g_renamed.this.Z_renamed.a_renamed(hVar, 0, 0, com.oplus.camera.ui.preview.g_renamed.this.R_renamed, com.oplus.camera.ui.preview.g_renamed.this.Q_renamed, com.oplus.camera.ui.preview.g_renamed.this.j_renamed ? com.oplus.camera.ui.preview.g_renamed.this.k_renamed : com.oplus.camera.ui.preview.g_renamed.this.ak_renamed.cu_renamed(), i_renamed);
                } else if (1 == i_renamed) {
                    com.oplus.camera.ui.preview.g_renamed.this.Z_renamed.a_renamed(hVar, 0, 0, com.oplus.camera.ui.preview.g_renamed.this.S_renamed, com.oplus.camera.ui.preview.g_renamed.this.T_renamed, 0, i_renamed);
                }
            }
        }
    };
    private android.view.animation.Animation.AnimationListener bt_renamed = new android.view.animation.Animation.AnimationListener() { // from class: com.oplus.camera.ui.preview.g_renamed.19
        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(android.view.animation.Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(android.view.animation.Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(android.view.animation.Animation animation) {
            if (com.oplus.camera.ui.preview.g_renamed.this.bf_renamed) {
                return;
            }
            com.oplus.camera.ui.preview.g_renamed.this.at_renamed();
        }
    };
    private android.view.animation.Animation.AnimationListener bu_renamed = new android.view.animation.Animation.AnimationListener() { // from class: com.oplus.camera.ui.preview.g_renamed.30
        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(android.view.animation.Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(android.view.animation.Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(android.view.animation.Animation animation) {
            if (com.oplus.camera.ui.preview.g_renamed.this.at_renamed != null) {
                com.oplus.camera.ui.preview.g_renamed.this.at_renamed.setLayerType(0, null);
                com.oplus.camera.ui.preview.g_renamed.this.at_renamed.setVisibility(8);
            }
        }
    };
    private final android.content.DialogInterface.OnClickListener bv_renamed = new android.content.DialogInterface.OnClickListener() { // from class: com.oplus.camera.ui.preview.g_renamed.32
        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(android.content.DialogInterface dialogInterface, int i_renamed) throws android.content.pm.PackageManager.NameNotFoundException {
            int i2 = com.oplus.camera.Storage.w_renamed;
            if (i2 == 0) {
                dialogInterface.dismiss();
                return;
            }
            if (i2 == 1 || i2 == 2 || i2 == 3) {
                dialogInterface.dismiss();
                if (com.oplus.camera.util.f_renamed.a_renamed(com.oplus.camera.ui.preview.g_renamed.this.X_renamed, com.oplus.camera.ui.preview.g_renamed.g_renamed)) {
                    com.oplus.camera.util.f_renamed.a_renamed(com.oplus.camera.ui.preview.g_renamed.this.X_renamed, com.oplus.camera.R_renamed.string.camera_disable_mobile_manager, com.oplus.camera.ui.preview.g_renamed.g_renamed, "");
                    return;
                }
                if (com.oplus.camera.ui.preview.g_renamed.this.bg_renamed) {
                    android.content.Intent intent = new android.content.Intent("oplus.intent.action.CLEAR_MAIN_ACTIVITY");
                    intent.setPackage(com.oplus.camera.ui.preview.g_renamed.g_renamed);
                    try {
                        intent.addFlags(67108864);
                        com.oplus.camera.ui.preview.g_renamed.this.X_renamed.startActivity(intent);
                    } catch (java.lang.Exception e2) {
                        com.oplus.camera.e_renamed.f_renamed("CameraPreviewUI", "mDialogOnClickListener.onClick, Exception when start ClearMainActivity: " + e2);
                    }
                }
            }
        }
    };
    private final com.oplus.camera.ui.preview.IntelligentDragView.a_renamed bw_renamed = new com.oplus.camera.ui.preview.IntelligentDragView.a_renamed() { // from class: com.oplus.camera.ui.preview.g_renamed.33
        @Override // com.oplus.camera.ui.preview.IntelligentDragView.a_renamed
        public boolean a_renamed(android.view.MotionEvent motionEvent) {
            int rawX = (int) motionEvent.getRawX();
            int rawY = (int) motionEvent.getRawY();
            if (com.oplus.camera.ui.preview.g_renamed.this.ak_renamed == null || !com.oplus.camera.ui.preview.g_renamed.this.ak_renamed.m_renamed(rawX, rawY)) {
                return false;
            }
            com.oplus.camera.ui.preview.g_renamed.this.ak_renamed.a_renamed(rawX, rawY, motionEvent.getEventTime());
            return false;
        }

        @Override // com.oplus.camera.ui.preview.IntelligentDragView.a_renamed
        public void b_renamed(android.view.MotionEvent motionEvent) {
            int rawX = (int) motionEvent.getRawX();
            int rawY = (int) motionEvent.getRawY();
            if (com.oplus.camera.ui.preview.g_renamed.this.ak_renamed != null) {
                com.oplus.camera.ui.preview.g_renamed.this.ak_renamed.l_renamed(rawX, rawY);
            }
        }

        @Override // com.oplus.camera.ui.preview.IntelligentDragView.a_renamed
        public void c_renamed(android.view.MotionEvent motionEvent) {
            int rawX = (int) motionEvent.getRawX();
            int rawY = (int) motionEvent.getRawY();
            if (com.oplus.camera.ui.preview.g_renamed.this.ak_renamed == null || !com.oplus.camera.ui.preview.g_renamed.this.ak_renamed.m_renamed(rawX, rawY)) {
                return;
            }
            com.oplus.camera.ui.preview.g_renamed.this.ak_renamed.f_renamed(rawX, rawY);
        }
    };
    private com.oplus.camera.ui.preview.HyperLapseFocusView.a_renamed bx_renamed = new com.oplus.camera.ui.preview.HyperLapseFocusView.a_renamed() { // from class: com.oplus.camera.ui.preview.g_renamed.10
        @Override // com.oplus.camera.ui.preview.HyperLapseFocusView.a_renamed
        public boolean a_renamed() {
            return com.oplus.camera.ui.preview.g_renamed.this.j_renamed;
        }

        @Override // com.oplus.camera.ui.preview.HyperLapseFocusView.a_renamed
        public boolean b_renamed() {
            if (com.oplus.camera.ui.preview.g_renamed.this.ak_renamed != null) {
                return com.oplus.camera.ui.preview.g_renamed.this.ak_renamed.aw_renamed();
            }
            return false;
        }

        @Override // com.oplus.camera.ui.preview.HyperLapseFocusView.a_renamed
        public void c_renamed() {
            if (com.oplus.camera.ui.preview.g_renamed.this.ak_renamed != null) {
                com.oplus.camera.ui.preview.g_renamed.this.ak_renamed.bA_renamed();
            }
        }

        @Override // com.oplus.camera.ui.preview.HyperLapseFocusView.a_renamed
        public void a_renamed(int i_renamed, int i2) {
            com.oplus.camera.ui.preview.g_renamed.this.ak_renamed.a_renamed(i_renamed, i2, 0L);
        }

        @Override // com.oplus.camera.ui.preview.HyperLapseFocusView.a_renamed
        public void b_renamed(int i_renamed, int i2) {
            com.oplus.camera.ui.preview.g_renamed.this.ak_renamed.f_renamed(i_renamed, i2);
        }
    };
    private android.view.animation.PathInterpolator i_renamed = this.n_renamed;

    /* compiled from: CameraPreviewUI.java */
    public interface a_renamed {
        void a_renamed();

        void a_renamed(android.util.Size size);

        void a_renamed(android.util.Size size, android.util.Size size2);

        int b_renamed();
    }

    /* compiled from: CameraPreviewUI.java */
    public interface b_renamed {
        void S_renamed(int i_renamed);

        float a_renamed(float f_renamed);

        void a_renamed(int i_renamed, int i2, int i3, int i4);

        void a_renamed(int i_renamed, int i2, long j_renamed);

        void a_renamed(int i_renamed, int i2, boolean z_renamed);

        void a_renamed(com.oplus.camera.doubleexposure.f_renamed fVar);

        void a_renamed(com.oplus.camera.screen.b_renamed.a_renamed aVar, android.util.Size size, long j_renamed);

        int[] a_renamed(android.util.Size size, android.util.Size size2);

        int aX_renamed();

        boolean aw_renamed();

        void bA_renamed();

        boolean bB_renamed();

        void bC_renamed();

        java.lang.String bg_renamed();

        java.lang.String bh_renamed();

        boolean cp_renamed();

        void cq_renamed();

        void cr_renamed();

        void cs_renamed();

        void ct_renamed();

        int cu_renamed();

        int cv_renamed();

        boolean dX_renamed();

        boolean dY_renamed();

        boolean dZ_renamed();

        boolean dr_renamed();

        java.lang.String ds_renamed();

        void dt_renamed();

        android.widget.RelativeLayout.LayoutParams e_renamed(android.util.Size size);

        boolean eD_renamed();

        int eE_renamed();

        void eK_renamed();

        float ea_renamed();

        boolean eb_renamed();

        boolean ec_renamed();

        boolean ed_renamed();

        void ee_renamed();

        void ef_renamed();

        void eg_renamed();

        void eh_renamed();

        int ei_renamed();

        com.oplus.camera.screen.b_renamed.a_renamed ej_renamed();

        void ek_renamed();

        void f_renamed(int i_renamed, int i2);

        boolean j_renamed(java.lang.String str);

        void l_renamed(int i_renamed, int i2);

        boolean m_renamed(int i_renamed, int i2);
    }

    /* compiled from: CameraPreviewUI.java */
    public interface c_renamed {
        void a_renamed(android.widget.RelativeLayout.LayoutParams layoutParams);
    }

    public void a_renamed() {
        com.oplus.camera.ui.preview.z_renamed zVar = this.ag_renamed;
        if (zVar != null) {
            zVar.setVisibility(0);
        }
    }

    public void b_renamed() {
        this.ag_renamed = (com.oplus.camera.ui.preview.z_renamed) this.X_renamed.findViewById(com.oplus.camera.R_renamed.id_renamed.super_text_frame_view);
        if (this.ag_renamed == null) {
            this.ag_renamed = new com.oplus.camera.ui.preview.z_renamed(this.X_renamed);
            this.ag_renamed.setId(com.oplus.camera.R_renamed.id_renamed.super_text_frame_view);
            android.widget.RelativeLayout.LayoutParams layoutParams = new android.widget.RelativeLayout.LayoutParams(-1, -1);
            this.ag_renamed.setLayoutParams(layoutParams);
            this.ag_renamed.setVisibility(8);
            com.oplus.camera.ui.preview.PreviewFrameLayout previewFrameLayout = this.ap_renamed;
            previewFrameLayout.addView(this.ag_renamed, previewFrameLayout.indexOfChild(this.as_renamed), layoutParams);
        }
        this.ag_renamed.setForceDarkAllowed(false);
    }

    public void c_renamed() {
        com.oplus.camera.ui.preview.z_renamed zVar = this.ag_renamed;
        if (zVar != null) {
            zVar.setVisibility(4);
            this.ag_renamed.setPointsArray(null);
        }
    }

    public void a_renamed(final com.oplus.camera.u_renamed.a_renamed aVar) {
        this.X_renamed.runOnUiThread(new java.lang.Runnable() { // from class: com.oplus.camera.ui.preview.g_renamed.34
            @Override // java.lang.Runnable
            public void run() {
                if (com.oplus.camera.ui.preview.g_renamed.this.ag_renamed == null) {
                    com.oplus.camera.ui.preview.g_renamed.this.b_renamed();
                }
                if (com.oplus.camera.ui.preview.g_renamed.this.ag_renamed != null) {
                    com.oplus.camera.u_renamed.a_renamed aVar2 = aVar;
                    if (aVar2 == null || !aVar2.c_renamed()) {
                        com.oplus.camera.ui.preview.g_renamed.this.ag_renamed.setVisibility(4);
                        com.oplus.camera.ui.preview.g_renamed.this.ag_renamed.setPointsArray(null);
                    } else {
                        com.oplus.camera.ui.preview.g_renamed.this.ag_renamed.setVisibility(0);
                        com.oplus.camera.ui.preview.g_renamed.this.ag_renamed.setPointsArray(aVar.b_renamed());
                    }
                }
            }
        });
    }

    public void b_renamed(com.oplus.camera.u_renamed.a_renamed aVar) {
        com.oplus.camera.e_renamed.a_renamed("CameraPreviewUI", "executeSuperTextFrameColorAnimation");
        com.oplus.camera.ui.preview.z_renamed zVar = this.ag_renamed;
        if (zVar != null) {
            zVar.a_renamed(aVar);
        }
    }

    public void a_renamed(boolean z_renamed, int i_renamed) {
        this.y_renamed = z_renamed;
        this.M_renamed = i_renamed;
    }

    public void a_renamed(int i_renamed) {
        this.N_renamed = i_renamed;
        com.oplus.camera.screen.b_renamed.a_renamed aVarEj = this.ak_renamed.ej_renamed();
        if (this.aM_renamed == null || aVarEj == null || 1 != aVarEj.j_renamed()) {
            return;
        }
        if (i_renamed == 0 || 1 == i_renamed) {
            aVarEj.d_renamed(new com.oplus.camera.screen.b_renamed.o_renamed.a_renamed() { // from class: com.oplus.camera.ui.preview.-$$Lambda$g_renamed$EE_V6jMNVm49mHfVqRz0rXxybGU
                @Override // com.oplus.camera.screen.b_renamed.o_renamed.a_renamed
                public final void call(java.lang.Object[] objArr) {
                    this.f_renamed$0.b_renamed(objArr);
                }
            });
        } else {
            aVarEj.d_renamed(new com.oplus.camera.screen.b_renamed.o_renamed.a_renamed() { // from class: com.oplus.camera.ui.preview.-$$Lambda$g_renamed$-V6uhbD6ly6pAzZuILJirpjfjJ4
                @Override // com.oplus.camera.screen.b_renamed.o_renamed.a_renamed
                public final void call(java.lang.Object[] objArr) {
                    this.f_renamed$0.a_renamed(objArr);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b_renamed(java.lang.Object[] objArr) {
        this.aM_renamed.setBackground(this.X_renamed.getResources().getDrawable(com.oplus.camera.R_renamed.drawable.burst_num_bg_fold_white, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a_renamed(java.lang.Object[] objArr) {
        this.aM_renamed.setBackground(this.X_renamed.getResources().getDrawable(com.oplus.camera.R_renamed.drawable.burst_num_bg_fold_black, null));
    }

    public void a_renamed(com.oplus.camera.screen.out.e_renamed eVar) {
        this.bc_renamed = eVar;
    }

    public void a_renamed(android.util.Size size) {
        com.oplus.camera.ui.preview.h_renamed hVar = this.Z_renamed;
        if (hVar != null) {
            hVar.a_renamed(size, size);
        }
    }

    public void a_renamed(com.oplus.camera.ui.preview.g_renamed.c_renamed cVar) {
        this.al_renamed = cVar;
    }

    public g_renamed(android.app.Activity activity, com.oplus.camera.ComboPreferences comboPreferences, com.oplus.camera.ui.preview.g_renamed.b_renamed bVar) {
        boolean z_renamed = false;
        this.V_renamed = 600.0f;
        this.X_renamed = null;
        this.Y_renamed = null;
        this.ak_renamed = null;
        this.bg_renamed = false;
        this.X_renamed = activity;
        this.Y_renamed = comboPreferences;
        this.ak_renamed = bVar;
        android.content.Intent intent = new android.content.Intent();
        intent.setPackage(g_renamed);
        intent.setAction("oplus.intent.action.CLEAR_MAIN_ACTIVITY");
        java.util.List<android.content.pm.ResolveInfo> listQueryIntentActivities = activity.getPackageManager().queryIntentActivities(intent, 0);
        if (listQueryIntentActivities != null && listQueryIntentActivities.size() > 0) {
            z_renamed = true;
        }
        this.bg_renamed = z_renamed;
        this.V_renamed = com.oplus.camera.aps.config.CameraConfig.getConfigFloatValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_SIZE_CHANGE_DURATION);
        com.oplus.camera.ui.a_renamed.a_renamed(this.X_renamed).a_renamed(this.X_renamed, this);
        this.W_renamed = this.V_renamed;
        com.oplus.camera.e_renamed.f_renamed("CameraPreviewUI", "CameraPreviewUI, mbCanUseCleanFunction: " + this.bg_renamed + ", mSizeChangeDuration: " + this.V_renamed);
    }

    public void a_renamed(int i_renamed, int i2) {
        this.Q_renamed = i_renamed;
        this.R_renamed = i2;
    }

    public void b_renamed(int i_renamed, int i2) {
        this.S_renamed = i_renamed;
        this.T_renamed = i2;
    }

    public void a_renamed(com.oplus.camera.ui.preview.a_renamed.t_renamed tVar) {
        android.widget.RelativeLayout.LayoutParams layoutParams;
        this.aL_renamed = (com.oplus.camera.gl_renamed.GLRootView) this.X_renamed.findViewById(com.oplus.camera.R_renamed.id_renamed.gl_root_view);
        if (com.oplus.camera.util.Util.t_renamed()) {
            layoutParams = new android.widget.RelativeLayout.LayoutParams(-1, -1);
        } else {
            layoutParams = new android.widget.RelativeLayout.LayoutParams(com.oplus.camera.util.Util.getScreenWidth(), com.oplus.camera.util.Util.getScreenHeight());
        }
        this.aL_renamed.setLayoutParams(layoutParams);
        this.aL_renamed.setContentPane(this.bs_renamed);
        a_renamed(com.oplus.camera.e_renamed.a_renamed.a_renamed(this.ak_renamed.cv_renamed()), tVar);
        this.au_renamed = (android.widget.RelativeLayout) this.X_renamed.findViewById(com.oplus.camera.R_renamed.id_renamed.camera);
        this.ac_renamed = (com.oplus.camera.ui.preview.FaceView) this.X_renamed.findViewById(com.oplus.camera.R_renamed.id_renamed.face_view);
        this.ac_renamed.setDisplayOrientation(this.P_renamed);
        this.ae_renamed = (com.oplus.camera.ui.preview.MultiFocusView) this.X_renamed.findViewById(com.oplus.camera.R_renamed.id_renamed.multi_focus_view);
        a_renamed(this.ae_renamed.getListener());
        this.ap_renamed = (com.oplus.camera.ui.preview.PreviewFrameLayout) this.X_renamed.findViewById(com.oplus.camera.R_renamed.id_renamed.frame_layout);
        this.ap_renamed.setOnSizeChangedListener(this);
        this.ap_renamed.addOnLayoutChangeListener(this);
        a_renamed((com.oplus.camera.ui.preview.k_renamed.b_renamed) this);
        if (com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_TRACK_FOCUS_SUPPORT)) {
            this.ad_renamed = (com.oplus.camera.ui.preview.ac_renamed) this.X_renamed.findViewById(com.oplus.camera.R_renamed.id_renamed.track_focus_view);
        }
        com.oplus.camera.ui.inverse.e_renamed eVar = com.oplus.camera.ui.inverse.e_renamed.INS;
        android.app.Activity activity = this.X_renamed;
        eVar.setInverseMaskView(activity, (com.oplus.camera.ui.inverse.InverseMaskView) activity.findViewById(com.oplus.camera.R_renamed.id_renamed.inverse_mask_view));
    }

    public void d_renamed() {
        if (com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_SUPPORT_INTELLIGENT_HIGH_FRAME) && this.af_renamed == null) {
            this.af_renamed = (com.oplus.camera.ui.preview.IntelligentDragView) this.X_renamed.getLayoutInflater().inflate(com.oplus.camera.R_renamed.layout.view_slow_motion_detect, this.ap_renamed).findViewById(com.oplus.camera.R_renamed.id_renamed.slow_video_motion_detect_view);
            this.af_renamed.setIntelligentGestureListener(this.bw_renamed);
        }
    }

    public void e_renamed() {
        this.p_renamed = false;
        this.Z_renamed.g_renamed(false);
        this.Z_renamed.p_renamed();
        com.oplus.camera.gl_renamed.GLRootView gLRootView = this.aL_renamed;
        if (gLRootView != null) {
            gLRootView.setPreventRenderByPause(false);
            this.aL_renamed.c_renamed();
        }
        synchronized (this.o_renamed) {
            this.z_renamed = false;
            this.W_renamed = this.V_renamed;
            this.i_renamed = this.n_renamed;
        }
    }

    public void f_renamed() {
        this.ax_renamed = this.Y_renamed.getString(com.oplus.camera.ui.CameraUIInterface.KEY_ASSIST_GRADIENTER, "off");
        com.oplus.camera.e_renamed.a_renamed("CameraPreviewUI", "onResumeMessage, mAssistGradienterState: " + this.ax_renamed);
        a_renamed(true);
        b_renamed("on_renamed".equals(this.ax_renamed));
        this.bd_renamed = java.lang.Thread.currentThread();
    }

    public void g_renamed() {
        com.oplus.camera.e_renamed.a_renamed("CameraPreviewUI", "releaseTextures");
        synchronized (this.o_renamed) {
            if (this.aL_renamed != null) {
                this.aL_renamed.a_renamed(new java.lang.Runnable() { // from class: com.oplus.camera.ui.preview.g_renamed.35
                    @Override // java.lang.Runnable
                    public void run() {
                        if (com.oplus.camera.ui.preview.g_renamed.this.Z_renamed != null) {
                            com.oplus.camera.ui.preview.g_renamed.this.Z_renamed.d_renamed();
                        }
                        if (com.oplus.camera.ui.preview.g_renamed.this.aA_renamed != null) {
                            com.oplus.camera.ui.preview.g_renamed.this.aA_renamed.release();
                            com.oplus.camera.ui.preview.g_renamed.this.aA_renamed = null;
                        }
                    }
                });
            }
            if (this.Z_renamed != null) {
                this.Z_renamed.a_renamed(com.oplus.camera.gl_renamed.t_renamed.b_renamed.f4672c);
                this.Z_renamed.a_renamed(com.oplus.camera.gl_renamed.t_renamed.b_renamed.d_renamed);
                this.Z_renamed.a_renamed(com.oplus.camera.gl_renamed.t_renamed.b_renamed.e_renamed);
                this.Z_renamed.a_renamed(com.oplus.camera.gl_renamed.t_renamed.b_renamed.f_renamed);
                this.az_renamed = null;
                this.be_renamed = true;
            }
        }
    }

    public void h_renamed() {
        com.oplus.camera.e_renamed.a_renamed("CameraPreviewUI", "onPause");
        this.p_renamed = true;
        this.q_renamed = true;
        s_renamed();
        com.oplus.camera.ui.preview.FaceView faceView = this.ac_renamed;
        if (faceView != null) {
            faceView.b_renamed();
        }
        com.oplus.camera.ui.preview.IntelligentDragView intelligentDragView = this.af_renamed;
        if (intelligentDragView != null) {
            intelligentDragView.a_renamed();
        }
        com.oplus.camera.ui.preview.MultiFocusView multiFocusView = this.ae_renamed;
        if (multiFocusView != null) {
            multiFocusView.b_renamed();
        }
        com.oplus.camera.ui.preview.ac_renamed acVar = this.ad_renamed;
        if (acVar != null) {
            acVar.h_renamed();
        }
        android.widget.ImageView imageView = this.at_renamed;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
        com.oplus.camera.gl_renamed.GLRootView gLRootView = this.aL_renamed;
        if (gLRootView != null) {
            gLRootView.setAlpha(1.0f);
        }
        android.graphics.Bitmap bitmap = this.av_renamed;
        if (bitmap != null) {
            bitmap.recycle();
            this.av_renamed = null;
        }
        this.Z_renamed.n_renamed(true);
        o_renamed();
        r_renamed(false);
        this.t_renamed = false;
        this.u_renamed = false;
        this.br_renamed.removeCallbacksAndMessages(null);
        java.lang.Runnable runnable = this.bq_renamed;
        if (runnable != null) {
            runnable.run();
        }
        g_renamed();
        com.oplus.camera.ui.preview.g_renamed.b_renamed bVar = this.ak_renamed;
        if (bVar != null) {
            bVar.eh_renamed();
        }
        com.oplus.camera.gl_renamed.GLRootView gLRootView2 = this.aL_renamed;
        if (gLRootView2 != null) {
            gLRootView2.d_renamed();
        }
        aB_renamed();
        com.oplus.camera.ui.preview.p_renamed pVar = this.ar_renamed;
        if (pVar != null) {
            pVar.b_renamed();
        }
    }

    public void i_renamed() {
        com.oplus.camera.gl_renamed.GLRootView gLRootView = this.aL_renamed;
        if (gLRootView != null) {
            gLRootView.setBackgroundColor(-16777216);
        }
        com.oplus.camera.ui.preview.h_renamed hVar = this.Z_renamed;
        if (hVar != null) {
            hVar.h_renamed(false);
        }
    }

    public void j_renamed() {
        com.oplus.camera.e_renamed.a_renamed("CameraPreviewUI", "onDestroy");
        k_renamed();
        this.aa_renamed = null;
        this.X_renamed = null;
        this.am_renamed = null;
        this.ab_renamed = null;
        this.aL_renamed = null;
        com.oplus.camera.ui.widget.a_renamed aVar = this.aS_renamed;
        if (aVar != null) {
            aVar.a_renamed();
        }
        com.oplus.camera.ui.preview.FaceView faceView = this.ac_renamed;
        if (faceView != null) {
            faceView.e_renamed();
            this.ac_renamed = null;
        }
        if (this.ad_renamed != null) {
            this.ad_renamed = null;
        }
        com.oplus.camera.ui.preview.MultiFocusView multiFocusView = this.ae_renamed;
        if (multiFocusView != null) {
            multiFocusView.e_renamed();
            this.ae_renamed = null;
        }
        com.oplus.camera.ui.preview.PreviewFrameLayout previewFrameLayout = this.ap_renamed;
        if (previewFrameLayout != null) {
            previewFrameLayout.removeAllViewsInLayout();
            this.ap_renamed.removeAllViews();
            this.ap_renamed = null;
        }
    }

    public void k_renamed() {
        com.oplus.camera.ui.preview.h_renamed hVar = this.Z_renamed;
        if (hVar != null) {
            hVar.q_renamed();
        }
        com.oplus.camera.gl_renamed.GLRootView gLRootView = this.aL_renamed;
        if (gLRootView != null) {
            gLRootView.f_renamed();
        }
    }

    public void a_renamed(com.oplus.camera.ui.menu.levelcontrol.j_renamed jVar) {
        this.Z_renamed.a_renamed((com.oplus.camera.gl_renamed.h_renamed) null, jVar, au_renamed(), av_renamed(), aw_renamed(), ax_renamed());
    }

    public void a_renamed(boolean z_renamed) {
        com.oplus.camera.ui.preview.g_renamed.b_renamed bVar = this.ak_renamed;
        if (bVar != null) {
            if (z_renamed && bVar.j_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_ASSISTANT_LINE) && (this.ak_renamed.dZ_renamed() || !this.ak_renamed.dY_renamed())) {
                ar_renamed();
                float fEa = this.ak_renamed.ea_renamed();
                android.widget.RelativeLayout.LayoutParams layoutParams = (android.widget.RelativeLayout.LayoutParams) this.as_renamed.getLayoutParams();
                if (1.0f > fEa && !com.oplus.camera.util.Util.u_renamed()) {
                    float right = this.ap_renamed.getRight() - this.ap_renamed.getLeft();
                    int i_renamed = (int) ((right - (fEa * right)) / 2.0f);
                    layoutParams.leftMargin = i_renamed;
                    layoutParams.rightMargin = i_renamed;
                } else {
                    layoutParams.leftMargin = 0;
                    layoutParams.rightMargin = 0;
                }
                this.as_renamed.setLayoutParams(layoutParams);
                this.as_renamed.a_renamed(this.ak_renamed.ds_renamed());
                return;
            }
            com.oplus.camera.ui.preview.r_renamed rVar = this.as_renamed;
            if (rVar != null) {
                rVar.a_renamed(this.ak_renamed.dY_renamed());
            }
        }
    }

    private void ar_renamed() {
        if (this.as_renamed == null) {
            this.as_renamed = new com.oplus.camera.ui.preview.r_renamed(this.X_renamed);
            this.as_renamed.setForceDarkAllowed(false);
            this.as_renamed.setVisibility(8);
            android.view.ViewGroup.LayoutParams layoutParams = new android.view.ViewGroup.LayoutParams(-1, -1);
            com.oplus.camera.ui.preview.PreviewFrameLayout previewFrameLayout = this.ap_renamed;
            previewFrameLayout.addView(this.as_renamed, previewFrameLayout.indexOfChild(this.ar_renamed), layoutParams);
        }
    }

    public void b_renamed(boolean z_renamed) {
        if (z_renamed && this.ak_renamed.j_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_ASSIST_GRADIENTER) && "on_renamed".equals(this.ax_renamed)) {
            as_renamed();
            this.ar_renamed.setViewLayoutType(this.ak_renamed.eE_renamed());
            this.ar_renamed.a_renamed();
        } else {
            com.oplus.camera.ui.preview.p_renamed pVar = this.ar_renamed;
            if (pVar != null) {
                pVar.b_renamed();
            }
        }
    }

    private void as_renamed() {
        if (this.ar_renamed == null) {
            com.oplus.camera.e_renamed.a_renamed("initGradienterAssistView");
            this.ar_renamed = new com.oplus.camera.ui.preview.p_renamed(this.X_renamed);
            this.ar_renamed.setForceDarkAllowed(false);
            this.ar_renamed.setVisibility(8);
            this.ar_renamed.setOnAdjustedListener(new com.oplus.camera.ui.preview.p_renamed.b_renamed() { // from class: com.oplus.camera.ui.preview.g_renamed.36
                @Override // com.oplus.camera.ui.preview.p_renamed.b_renamed
                public void a_renamed() {
                    if (com.oplus.camera.ui.preview.g_renamed.this.ak_renamed != null) {
                        com.oplus.camera.ui.preview.g_renamed.this.ak_renamed.dt_renamed();
                    }
                }
            });
            this.ap_renamed.addView(this.ar_renamed, new android.view.ViewGroup.LayoutParams(-1, -1));
            com.oplus.camera.e_renamed.b_renamed("initGradienterAssistView");
        }
    }

    public boolean l_renamed() {
        com.oplus.camera.ui.preview.p_renamed pVar = this.ar_renamed;
        if (pVar != null) {
            return pVar.c_renamed();
        }
        return false;
    }

    public java.lang.String m_renamed() {
        com.oplus.camera.ui.preview.p_renamed pVar = this.ar_renamed;
        return pVar != null ? pVar.getOrientation() : "";
    }

    public void n_renamed() {
        if (this.au_renamed != null && this.aM_renamed == null) {
            if (1 == this.ak_renamed.aX_renamed() || 4 == this.ak_renamed.aX_renamed()) {
                this.aM_renamed = this.ak_renamed.ej_renamed().a_renamed(this.X_renamed, this.au_renamed, this.N_renamed);
            } else {
                this.X_renamed.getLayoutInflater().inflate(com.oplus.camera.R_renamed.layout.burst, this.au_renamed);
                this.aM_renamed = (com.oplus.camera.ui.RotableTextView) this.X_renamed.findViewById(com.oplus.camera.R_renamed.id_renamed.burst_num_view);
                ((android.widget.RelativeLayout.LayoutParams) this.aM_renamed.getLayoutParams()).addRule(2, com.oplus.camera.R_renamed.id_renamed.control_panel_layout);
            }
            com.oplus.camera.ui.RotableTextView rotableTextView = this.aM_renamed;
            if (rotableTextView != null) {
                rotableTextView.setTypeface(com.oplus.camera.util.Util.l_renamed(this.X_renamed));
                this.aM_renamed.a_renamed(this.ai_renamed, false);
                this.aM_renamed.setVisibility(8);
                this.aZ_renamed = this.X_renamed.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.face_beauty_enter_button_animation_y);
            }
        }
    }

    public void o_renamed() {
        com.oplus.camera.ui.RotableTextView rotableTextView;
        android.widget.RelativeLayout relativeLayout = this.au_renamed;
        if (relativeLayout == null || (rotableTextView = this.aM_renamed) == null) {
            return;
        }
        relativeLayout.removeView(rotableTextView);
        this.aM_renamed = null;
    }

    public void a_renamed(int i_renamed, boolean z_renamed, boolean z2) {
        n_renamed();
        com.oplus.camera.ui.RotableTextView rotableTextView = this.aM_renamed;
        if (rotableTextView != null) {
            if (i_renamed < 10) {
                rotableTextView.setText(com.oplus.camera.util.Util.l_renamed(0) + com.oplus.camera.util.Util.l_renamed(i_renamed));
            } else {
                rotableTextView.setText(com.oplus.camera.util.Util.l_renamed(i_renamed));
            }
            if (1 == i_renamed) {
                com.oplus.camera.perf.b_renamed.a_renamed("continuous_capture");
            } else if (com.oplus.camera.util.Util.d_renamed == i_renamed) {
                com.oplus.camera.perf.b_renamed.b_renamed("continuous_capture");
            }
            if (z_renamed) {
                if (this.aM_renamed.isShown()) {
                    return;
                }
                android.animation.ObjectAnimator objectAnimatorOfFloat = android.animation.ObjectAnimator.ofFloat(this.aM_renamed, "alpha", 0.0f, 1.0f);
                objectAnimatorOfFloat.setInterpolator(this.l_renamed);
                objectAnimatorOfFloat.setDuration(400L);
                this.aY_renamed = new android.animation.AnimatorSet();
                android.animation.AnimatorSet.Builder builderPlay = this.aY_renamed.play(objectAnimatorOfFloat);
                if (z2) {
                    android.animation.ObjectAnimator objectAnimatorOfFloat2 = android.animation.ObjectAnimator.ofFloat(this.aM_renamed, "translationY", this.aZ_renamed, 0.0f);
                    objectAnimatorOfFloat2.setInterpolator(this.m_renamed);
                    objectAnimatorOfFloat2.setDuration(400L);
                    builderPlay.with(objectAnimatorOfFloat2);
                    this.aY_renamed.setStartDelay(100L);
                } else {
                    this.aM_renamed.setTranslationY(0.0f);
                }
                this.aY_renamed.addListener(new android.animation.AnimatorListenerAdapter() { // from class: com.oplus.camera.ui.preview.g_renamed.2
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationStart(android.animation.Animator animator) {
                        if (com.oplus.camera.ui.preview.g_renamed.this.aM_renamed != null) {
                            com.oplus.camera.ui.preview.g_renamed.this.aM_renamed.setAlpha(0.0f);
                            com.oplus.camera.ui.preview.g_renamed.this.aM_renamed.setVisibility(0);
                        }
                    }

                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(android.animation.Animator animator) {
                        if (com.oplus.camera.ui.preview.g_renamed.this.aM_renamed != null) {
                            com.oplus.camera.ui.preview.g_renamed.this.aM_renamed.setAlpha(1.0f);
                            com.oplus.camera.ui.preview.g_renamed.this.aM_renamed.setTranslationY(0.0f);
                            com.oplus.camera.ui.preview.g_renamed.this.aM_renamed.setVisibility(0);
                        }
                    }
                });
                this.aY_renamed.start();
                return;
            }
            this.aM_renamed.setVisibility(0);
        }
    }

    public void a_renamed(boolean z_renamed, boolean z2) {
        com.oplus.camera.ui.RotableTextView rotableTextView = this.aM_renamed;
        if (rotableTextView == null) {
            return;
        }
        if (z_renamed) {
            if (rotableTextView.isShown()) {
                android.animation.ObjectAnimator objectAnimatorOfFloat = android.animation.ObjectAnimator.ofFloat(this.aM_renamed, "alpha", 1.0f, 0.0f);
                objectAnimatorOfFloat.setInterpolator(this.l_renamed);
                objectAnimatorOfFloat.setDuration(250L);
                this.aX_renamed = new android.animation.AnimatorSet();
                android.animation.AnimatorSet.Builder builderPlay = this.aX_renamed.play(objectAnimatorOfFloat);
                if (z2) {
                    android.animation.ObjectAnimator objectAnimatorOfFloat2 = android.animation.ObjectAnimator.ofFloat(this.aM_renamed, "translationY", 0.0f, this.aZ_renamed);
                    objectAnimatorOfFloat2.setInterpolator(this.m_renamed);
                    objectAnimatorOfFloat2.setDuration(400L);
                    builderPlay.with(objectAnimatorOfFloat2);
                } else {
                    this.aM_renamed.setTranslationY(0.0f);
                }
                this.aX_renamed.addListener(new android.animation.AnimatorListenerAdapter() { // from class: com.oplus.camera.ui.preview.g_renamed.3
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationStart(android.animation.Animator animator) {
                        if (com.oplus.camera.ui.preview.g_renamed.this.aM_renamed != null) {
                            com.oplus.camera.ui.preview.g_renamed.this.aM_renamed.setVisibility(0);
                        }
                    }

                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(android.animation.Animator animator) {
                        if (com.oplus.camera.ui.preview.g_renamed.this.aM_renamed != null) {
                            com.oplus.camera.ui.preview.g_renamed.this.aM_renamed.setText((java.lang.CharSequence) null);
                            com.oplus.camera.ui.preview.g_renamed.this.aM_renamed.setAlpha(1.0f);
                            com.oplus.camera.ui.preview.g_renamed.this.aM_renamed.setTranslationY(0.0f);
                            com.oplus.camera.ui.preview.g_renamed.this.aM_renamed.setVisibility(8);
                        }
                    }
                });
                this.aX_renamed.start();
                return;
            }
            return;
        }
        rotableTextView.setText((java.lang.CharSequence) null);
        this.aM_renamed.setVisibility(8);
    }

    public void p_renamed() {
        android.app.Activity activity;
        if (this.au_renamed == null || this.aN_renamed != null || (activity = this.X_renamed) == null) {
            return;
        }
        activity.runOnUiThread(new java.lang.Runnable() { // from class: com.oplus.camera.ui.preview.g_renamed.4
            @Override // java.lang.Runnable
            public void run() throws android.content.res.Resources.NotFoundException {
                if (com.oplus.camera.ui.preview.g_renamed.this.aN_renamed != null) {
                    return;
                }
                com.oplus.camera.ui.preview.g_renamed gVar = com.oplus.camera.ui.preview.g_renamed.this;
                gVar.aN_renamed = new com.oplus.camera.ui.t_renamed(gVar.X_renamed);
                int dimensionPixelSize = com.oplus.camera.ui.preview.g_renamed.this.X_renamed.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.omoji_no_face_view_size);
                android.widget.RelativeLayout.LayoutParams layoutParams = new android.widget.RelativeLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize);
                layoutParams.addRule(14);
                layoutParams.addRule(10);
                layoutParams.topMargin = com.oplus.camera.util.Util.N_renamed() + com.oplus.camera.ui.preview.g_renamed.this.X_renamed.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.omoji_no_face_view_margin_topbar);
                com.oplus.camera.ui.preview.g_renamed.this.aN_renamed.setImage(android.graphics.BitmapFactory.decodeResource(com.oplus.camera.ui.preview.g_renamed.this.X_renamed.getResources(), com.oplus.camera.R_renamed.drawable.no_face_detect));
                com.oplus.camera.ui.preview.g_renamed.this.aN_renamed.setText(com.oplus.camera.ui.preview.g_renamed.this.X_renamed.getResources().getString(com.oplus.camera.R_renamed.string.camera_omoji_no_faces));
                com.oplus.camera.ui.preview.g_renamed.this.aN_renamed.setViewGap(com.oplus.camera.ui.preview.g_renamed.this.X_renamed.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.omoji_no_face_view_gap));
                com.oplus.camera.ui.preview.g_renamed.this.au_renamed.addView(com.oplus.camera.ui.preview.g_renamed.this.aN_renamed, layoutParams);
                com.oplus.camera.ui.preview.g_renamed.this.aN_renamed.a_renamed(com.oplus.camera.ui.preview.g_renamed.this.ai_renamed, false);
                com.oplus.camera.ui.preview.g_renamed.this.aN_renamed.setVisibility(8);
            }
        });
    }

    public void q_renamed() {
        p_renamed();
        android.os.Handler handler = this.br_renamed;
        if (handler != null) {
            handler.removeMessages(3);
            this.br_renamed.sendEmptyMessage(3);
        }
    }

    public void r_renamed() {
        android.os.Handler handler = this.br_renamed;
        if (handler != null) {
            handler.removeMessages(4);
            this.br_renamed.sendEmptyMessage(4);
        }
    }

    public void s_renamed() {
        com.oplus.camera.ui.t_renamed tVar;
        android.widget.RelativeLayout relativeLayout = this.au_renamed;
        if (relativeLayout == null || (tVar = this.aN_renamed) == null) {
            return;
        }
        relativeLayout.removeView(tVar);
        this.aN_renamed = null;
    }

    public void a_renamed(android.graphics.Bitmap bitmap) {
        android.widget.ImageView imageView;
        a_renamed(false);
        b_renamed(false);
        if (this.am_renamed == null) {
            this.am_renamed = a_renamed(this.ap_renamed);
        }
        if (bitmap == null || (imageView = this.am_renamed) == null) {
            return;
        }
        imageView.setScaleType(android.widget.ImageView.ScaleType.FIT_CENTER);
        this.am_renamed.setImageBitmap(bitmap);
        this.am_renamed.setVisibility(0);
    }

    public void t_renamed() {
        android.widget.ImageView imageView = this.am_renamed;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
        this.Z_renamed.n_renamed(true);
        a_renamed(true);
        b_renamed(true);
    }

    public boolean u_renamed() {
        android.widget.ImageView imageView = this.am_renamed;
        if (imageView != null) {
            return imageView.isShown();
        }
        return false;
    }

    private android.widget.ImageView a_renamed(android.view.ViewGroup viewGroup) {
        android.widget.ImageView imageView = new android.widget.ImageView(this.X_renamed);
        android.view.ViewGroup.LayoutParams layoutParams = new android.view.ViewGroup.LayoutParams(-1, -1);
        imageView.setVisibility(8);
        imageView.setBackgroundColor(-16777216);
        viewGroup.addView(imageView, layoutParams);
        return imageView;
    }

    public void b_renamed(android.graphics.Bitmap bitmap) {
        if (this.am_renamed == null) {
            this.am_renamed = a_renamed(this.ap_renamed);
        }
        this.am_renamed.setScaleType(android.widget.ImageView.ScaleType.FIT_START);
        if (bitmap != null) {
            com.oplus.camera.e_renamed.a_renamed("CameraPreviewUI", "showVideoAlert, mRecordingOrientation: " + this.aj_renamed);
            this.am_renamed.setImageBitmap(com.oplus.camera.util.Util.a_renamed(bitmap, -this.aj_renamed, false));
            this.am_renamed.setVisibility(0);
        }
    }

    public void v_renamed() {
        this.am_renamed.setVisibility(8);
    }

    public android.util.Size w_renamed() {
        android.util.Size size;
        synchronized (this.o_renamed) {
            size = this.ay_renamed;
        }
        return size;
    }

    public com.oplus.camera.ui.preview.h_renamed x_renamed() {
        return this.Z_renamed;
    }

    public android.widget.RelativeLayout y_renamed() {
        return this.ap_renamed;
    }

    public void a_renamed(com.oplus.camera.ui.preview.h_renamed.d_renamed dVar) {
        this.aK_renamed = dVar;
    }

    public void b_renamed(int i_renamed) {
        synchronized (this.o_renamed) {
            this.ah_renamed = i_renamed;
        }
    }

    public void c_renamed(int i_renamed) {
        this.ai_renamed = i_renamed;
        com.oplus.camera.ui.RotableTextView rotableTextView = this.aM_renamed;
        if (rotableTextView != null) {
            rotableTextView.a_renamed(i_renamed, true);
        }
        com.oplus.camera.ui.preview.FaceView faceView = this.ac_renamed;
        if (faceView != null) {
            faceView.a_renamed(i_renamed, false);
        }
        com.oplus.camera.ui.preview.IntelligentDragView intelligentDragView = this.af_renamed;
        if (intelligentDragView != null) {
            intelligentDragView.a_renamed(i_renamed, false);
        }
        com.oplus.camera.ui.t_renamed tVar = this.aN_renamed;
        if (tVar != null) {
            tVar.a_renamed(i_renamed, true);
        }
        com.oplus.camera.ui.widget.a_renamed aVar = this.aS_renamed;
        if (aVar != null) {
            aVar.a_renamed(i_renamed, true);
        }
    }

    public void d_renamed(int i_renamed) {
        this.P_renamed = i_renamed;
        com.oplus.camera.ui.preview.h_renamed hVar = this.Z_renamed;
        if (hVar != null) {
            hVar.c_renamed(i_renamed);
        }
        com.oplus.camera.ui.preview.FaceView faceView = this.ac_renamed;
        if (faceView != null) {
            faceView.setDisplayOrientation(i_renamed);
        }
        com.oplus.camera.ui.preview.ac_renamed acVar = this.ad_renamed;
        if (acVar != null) {
            acVar.setDisplayOrientation(i_renamed);
        }
        com.oplus.camera.ui.preview.MultiFocusView multiFocusView = this.ae_renamed;
        if (multiFocusView != null) {
            multiFocusView.setDisplayOrientation(i_renamed);
        }
    }

    public void a_renamed(com.oplus.camera.gl_renamed.t_renamed.b_renamed bVar, boolean z_renamed, boolean z2, java.lang.String str) {
        com.oplus.camera.ui.preview.h_renamed hVar = this.Z_renamed;
        if (hVar != null) {
            hVar.a_renamed(bVar, z_renamed, z2, str);
        }
    }

    public void c_renamed(boolean z_renamed) {
        com.oplus.camera.ui.preview.h_renamed hVar = this.Z_renamed;
        if (hVar != null) {
            hVar.a_renamed(z_renamed);
        }
    }

    public void d_renamed(boolean z_renamed) {
        com.oplus.camera.ui.preview.h_renamed hVar = this.Z_renamed;
        if (hVar != null) {
            hVar.b_renamed(z_renamed);
        }
    }

    public void a_renamed(int i_renamed, long j_renamed, long j2) {
        com.oplus.camera.ui.preview.h_renamed hVar = this.Z_renamed;
        if (hVar != null) {
            hVar.a_renamed(i_renamed, j_renamed, j2);
        }
    }

    public long e_renamed(int i_renamed) {
        com.oplus.camera.ui.preview.h_renamed hVar = this.Z_renamed;
        if (hVar != null) {
            return hVar.b_renamed(i_renamed);
        }
        return 0L;
    }

    public void e_renamed(boolean z_renamed) {
        com.oplus.camera.ui.preview.FaceView faceView = this.ac_renamed;
        if (faceView != null) {
            faceView.setMirror(z_renamed);
        }
    }

    public void f_renamed(boolean z_renamed) {
        this.j_renamed = z_renamed;
        if (this.j_renamed) {
            this.k_renamed = this.ak_renamed.cu_renamed();
            O_renamed().setRenderMode(0);
        }
    }

    public void a_renamed(android.graphics.Rect rect, android.util.Size size) {
        com.oplus.camera.ui.preview.FaceView faceView = this.ac_renamed;
        if (faceView != null) {
            faceView.a_renamed(rect, size);
        }
    }

    public void a_renamed(android.graphics.Rect rect, android.graphics.Rect rect2, android.util.Size size) {
        com.oplus.camera.ui.preview.ac_renamed acVar = this.ad_renamed;
        if (acVar != null) {
            acVar.a_renamed(rect, rect2, size, w_renamed());
        }
    }

    public void a_renamed(float f_renamed) {
        com.oplus.camera.ui.preview.FaceView faceView = this.ac_renamed;
        if (faceView != null) {
            faceView.setEISScale(f_renamed);
        }
    }

    public void b_renamed(float f_renamed) {
        com.oplus.camera.ui.preview.FaceView faceView = this.ac_renamed;
        if (faceView != null) {
            faceView.setZoomValue(f_renamed);
        }
    }

    public void c_renamed(float f_renamed) {
        com.oplus.camera.ui.preview.FaceView faceView = this.ac_renamed;
        if (faceView != null) {
            faceView.setFaceSlenderZoomValue(f_renamed);
        }
    }

    public void a_renamed(android.hardware.camera2.params.Face[] faceArr, int[] iArr) {
        com.oplus.camera.ui.preview.MultiFocusView multiFocusView;
        if (this.ac_renamed != null) {
            if (!this.Z_renamed.o_renamed() || this.Z_renamed.l_renamed() || ((multiFocusView = this.ae_renamed) != null && multiFocusView.a_renamed())) {
                if (this.ac_renamed.a_renamed()) {
                    A_renamed();
                }
                g_renamed(false);
            } else {
                this.ac_renamed.a_renamed(this.ak_renamed.eb_renamed(), this.ak_renamed.ea_renamed());
                this.ac_renamed.a_renamed(faceArr, iArr);
            }
        }
    }

    public void a_renamed(int[] iArr) {
        if (this.ae_renamed != null) {
            if (this.ac_renamed.f_renamed() && this.u_renamed) {
                this.ae_renamed.a_renamed(iArr, w_renamed());
            } else {
                this.ae_renamed.b_renamed();
            }
        }
    }

    public void z_renamed() {
        com.oplus.camera.ui.preview.h_renamed hVar = this.Z_renamed;
        if (hVar != null) {
            hVar.y_renamed();
        }
    }

    public void A_renamed() {
        com.oplus.camera.ui.preview.FaceView faceView = this.ac_renamed;
        if (faceView != null) {
            faceView.b_renamed();
            g_renamed(true);
        }
    }

    public void g_renamed(boolean z_renamed) {
        com.oplus.camera.ui.preview.FaceView faceView = this.ac_renamed;
        if (faceView != null) {
            faceView.a_renamed(z_renamed);
        }
    }

    public void B_renamed() {
        com.oplus.camera.ui.preview.MultiFocusView multiFocusView = this.ae_renamed;
        if (multiFocusView != null) {
            multiFocusView.b_renamed();
        }
    }

    private void a_renamed(boolean z_renamed, com.oplus.camera.ui.preview.a_renamed.t_renamed tVar) {
        if (this.Z_renamed == null) {
            this.Z_renamed = new com.oplus.camera.ui.preview.h_renamed(this.X_renamed, this, z_renamed);
            this.Z_renamed.a_renamed(this.aK_renamed);
            this.Z_renamed.c_renamed(this.P_renamed);
            this.Z_renamed.a_renamed(tVar);
            this.Z_renamed.a_renamed(new com.oplus.camera.ui.preview.h_renamed.b_renamed() { // from class: com.oplus.camera.ui.preview.g_renamed.5
                @Override // com.oplus.camera.ui.preview.h_renamed.b_renamed
                public boolean a_renamed() {
                    if (com.oplus.camera.ui.preview.g_renamed.this.ak_renamed != null) {
                        return com.oplus.camera.ui.preview.g_renamed.this.ak_renamed.bB_renamed();
                    }
                    return false;
                }

                @Override // com.oplus.camera.ui.preview.h_renamed.b_renamed
                public float a_renamed(float f_renamed) {
                    if (com.oplus.camera.ui.preview.g_renamed.this.ak_renamed != null) {
                        return com.oplus.camera.ui.preview.g_renamed.this.ak_renamed.a_renamed(f_renamed);
                    }
                    return 0.0f;
                }

                @Override // com.oplus.camera.ui.preview.h_renamed.b_renamed
                public void b_renamed() {
                    if (com.oplus.camera.ui.preview.g_renamed.this.ak_renamed != null) {
                        com.oplus.camera.ui.preview.g_renamed.this.ak_renamed.bC_renamed();
                    }
                }
            });
        }
        this.Z_renamed.a_renamed(this.aL_renamed);
    }

    public boolean b_renamed(android.util.Size size) {
        synchronized (this.o_renamed) {
            com.oplus.camera.e_renamed.a_renamed("CameraPreviewUI", "updateSurfaceTexture, previewSize: " + size.getWidth() + "x_renamed" + size.getHeight() + ", mbNeedAcquireTexture: " + this.be_renamed);
            this.ay_renamed = size;
            a_renamed(size.getWidth(), size.getHeight(), size.getWidth(), size.getHeight());
            int iF = this.Z_renamed.f_renamed();
            int iG = this.Z_renamed.g_renamed();
            if (!this.p_renamed) {
                this.Z_renamed.n_renamed();
                if (this.be_renamed) {
                    b_renamed(-1, -1, size.getWidth(), size.getHeight());
                    this.Z_renamed.d_renamed(this.ak_renamed.cv_renamed() == 0);
                    this.az_renamed = this.Z_renamed.c_renamed();
                    if (this.az_renamed != null) {
                        this.aA_renamed = new android.view.Surface(this.az_renamed);
                    }
                    this.be_renamed = false;
                } else {
                    b_renamed(iF, iG, size.getWidth(), size.getHeight());
                }
                this.Z_renamed.e_renamed();
                if (this.az_renamed != null) {
                    this.az_renamed.setDefaultBufferSize(size.getWidth(), size.getHeight());
                }
                return true;
            }
            com.oplus.camera.e_renamed.a_renamed("CameraPreviewUI", "updateSurfaceTexture, Activity already pause. Avoid 0x502.");
            return false;
        }
    }

    public void a_renamed(com.oplus.camera.ui.q_renamed qVar) {
        if (this.aL_renamed != null) {
            com.oplus.camera.e_renamed.a_renamed("CameraPreviewUI", "setOutlineProvider, outlineProvider: " + qVar);
            if (qVar != null) {
                this.aL_renamed.setClipToOutline(true);
            } else {
                this.aL_renamed.setClipToOutline(false);
            }
            this.aL_renamed.setOutlineProvider(qVar);
        }
    }

    public void a_renamed(final android.util.Size size, boolean z_renamed) {
        android.app.Activity activity;
        com.oplus.camera.e_renamed.a_renamed("CameraPreviewUI", "updatePreviewSize, previewSize: " + size.getWidth() + "x_renamed" + size.getHeight() + ", layoutPreview: " + z_renamed);
        b_renamed(size);
        if (java.lang.Thread.currentThread() != this.bd_renamed && (activity = this.X_renamed) != null) {
            activity.runOnUiThread(new java.lang.Runnable() { // from class: com.oplus.camera.ui.preview.g_renamed.6
                @Override // java.lang.Runnable
                public void run() {
                    com.oplus.camera.ui.preview.g_renamed.this.c_renamed(size);
                }
            });
        } else {
            c_renamed(size);
        }
    }

    private void b_renamed(int i_renamed, int i2, int i3, int i4) {
        if (this.P_renamed % 180 != 0) {
            i4 = i3;
            i3 = i4;
        }
        if (i_renamed == i3 && i2 == i4) {
            return;
        }
        this.Z_renamed.a_renamed(i3, i4);
    }

    public void C_renamed() {
        c_renamed(com.oplus.camera.util.Util.I_renamed());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c_renamed(android.util.Size size) {
        android.view.View childAt;
        if (this.X_renamed == null || this.ak_renamed == null) {
            com.oplus.camera.e_renamed.a_renamed("CameraPreviewUI", "layoutPreviewFrameToPreviewSize, mActivity is_renamed null");
            return;
        }
        com.oplus.camera.ui.preview.h_renamed hVar = this.Z_renamed;
        boolean z_renamed = true;
        if (hVar != null) {
            if (size == null) {
                android.util.Size size2 = new android.util.Size(hVar.g_renamed(), this.Z_renamed.f_renamed());
                com.oplus.camera.e_renamed.f_renamed("CameraPreviewUI", "layoutPreviewFrameToPreviewSize, previewSize: " + size2);
                size = size2;
            }
            this.Z_renamed.c_renamed(com.oplus.camera.util.Util.C_renamed() && this.ak_renamed.j_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_EIS));
        }
        if (this.ap_renamed != null) {
            android.widget.RelativeLayout.LayoutParams layoutParamsE = this.ak_renamed.e_renamed(size);
            if (layoutParamsE == null) {
                if (size.getWidth() != 0 && size.getWidth() == size.getHeight() && this.ak_renamed.cp_renamed()) {
                    layoutParamsE = new android.widget.RelativeLayout.LayoutParams(-1, com.oplus.camera.util.Util.getScreenWidth());
                    layoutParamsE.topMargin = com.oplus.camera.util.Util.u_renamed() ? 0 : com.oplus.camera.util.Util.N_renamed() + com.oplus.camera.util.Util.L_renamed();
                    layoutParamsE.bottomMargin = com.oplus.camera.util.Util.u_renamed() ? 0 : com.oplus.camera.util.Util.getScreenHeight() - ((com.oplus.camera.util.Util.N_renamed() + com.oplus.camera.util.Util.L_renamed()) + com.oplus.camera.util.Util.getScreenWidth());
                } else {
                    boolean z2 = java.lang.Math.abs((((double) size.getWidth()) / ((double) size.getHeight())) - 1.3333333333333333d) > 0.01d;
                    android.widget.RelativeLayout.LayoutParams layoutParams = new android.widget.RelativeLayout.LayoutParams(-1, -1);
                    if (!z2) {
                        int width = size.getWidth();
                        int height = size.getHeight();
                        float f_renamed = height / width;
                        if ((((double) width) / ((double) height)) - 1.0d == 0.0d) {
                            layoutParams.topMargin = com.oplus.camera.util.Util.u_renamed() ? 0 : com.oplus.camera.util.Util.N_renamed() + com.oplus.camera.util.Util.L_renamed();
                            layoutParams.height = com.oplus.camera.util.Util.u_renamed() ? 0 : com.oplus.camera.util.Util.N_renamed() + com.oplus.camera.util.Util.L_renamed() + com.oplus.camera.util.Util.getScreenWidth();
                        } else {
                            layoutParams.topMargin = com.oplus.camera.util.Util.u_renamed() ? 0 : com.oplus.camera.util.Util.N_renamed();
                            layoutParams.bottomMargin = com.oplus.camera.util.Util.u_renamed() ? 0 : (int) ((com.oplus.camera.util.Util.getScreenHeight() - com.oplus.camera.util.Util.N_renamed()) - (com.oplus.camera.util.Util.getScreenWidth() / f_renamed));
                        }
                    } else if (java.lang.Math.abs((size.getWidth() / size.getHeight()) - 1.5d) < 0.01d) {
                        int width2 = size.getWidth();
                        int height2 = size.getHeight();
                        if (this.P_renamed % 180 != 0) {
                            width2 = size.getHeight();
                            height2 = size.getWidth();
                        }
                        float screenWidth = width2 != 0 ? com.oplus.camera.util.Util.getScreenWidth() / width2 : 1.0f;
                        layoutParamsE = screenWidth != (height2 != 0 ? ((float) com.oplus.camera.util.Util.U_renamed()) / ((float) height2) : 1.0f) ? new android.widget.RelativeLayout.LayoutParams((int) (width2 * screenWidth), (int) (height2 * screenWidth)) : layoutParams;
                        layoutParamsE.addRule(10);
                        layoutParamsE.topMargin = com.oplus.camera.util.Util.N_renamed();
                    } else {
                        int iD = com.oplus.camera.util.Util.d_renamed(size.getWidth(), size.getHeight());
                        java.lang.String strBg = this.ak_renamed.bg_renamed();
                        if (!this.ak_renamed.dY_renamed() && (!this.ak_renamed.cp_renamed() || 1 == iD)) {
                            layoutParams.topMargin = com.oplus.camera.util.Util.N_renamed();
                            float width3 = size.getWidth() / size.getHeight();
                            if (com.oplus.camera.util.Util.t_renamed()) {
                                layoutParams.topMargin = com.oplus.camera.util.Util.u_renamed() ? 0 : (com.oplus.camera.util.Util.N_renamed() / 2) - com.oplus.camera.util.Util.M_renamed();
                            }
                            layoutParams.bottomMargin = com.oplus.camera.util.Util.u_renamed() ? 0 : (int) ((com.oplus.camera.util.Util.getScreenHeight() - layoutParams.topMargin) - (com.oplus.camera.util.Util.getScreenWidth() * width3));
                        } else if (com.oplus.camera.aps.constant.ApsConstant.CAPTURE_MODE_XPAN.equals(strBg) || (strBg.isEmpty() && this.ak_renamed.dX_renamed())) {
                            layoutParams.topMargin = java.lang.Math.round((com.oplus.camera.util.Util.getScreenHeight() * 0.13f) / 2.0f);
                            layoutParams.bottomMargin = java.lang.Math.round((com.oplus.camera.util.Util.getScreenHeight() * 0.13f) / 2.0f);
                            layoutParams.leftMargin = java.lang.Math.round((com.oplus.camera.util.Util.getScreenWidth() * 0.13f) / 2.0f);
                            layoutParams.rightMargin = java.lang.Math.round((com.oplus.camera.util.Util.getScreenWidth() * 0.13f) / 2.0f);
                        }
                    }
                    layoutParamsE = layoutParams;
                }
            }
            com.oplus.camera.ui.preview.g_renamed.c_renamed cVar = this.al_renamed;
            if (cVar != null) {
                cVar.a_renamed(layoutParamsE);
            }
            this.aq_renamed = layoutParamsE;
            this.ap_renamed.setLayoutParams(this.aq_renamed);
            com.oplus.camera.e_renamed.b_renamed("CameraPreviewUI", "layoutPreviewFrameToPreviewSize, params.width: " + layoutParamsE.width + ", params.height: " + layoutParamsE.height + ", params.leftMargin" + layoutParamsE.leftMargin + ", params.topMargin: " + layoutParamsE.topMargin + ", params.rightMargin: " + layoutParamsE.rightMargin + ", params.bottomMargin: " + layoutParamsE.bottomMargin);
            android.app.Activity activity = this.X_renamed;
            if (activity != null && (childAt = ((android.view.ViewGroup) activity.getWindow().getDecorView()).getChildAt(0)) != null) {
                childAt.requestLayout();
            }
            synchronized (this.o_renamed) {
                com.oplus.camera.ui.preview.g_renamed.b_renamed bVar = this.ak_renamed;
                int width4 = this.ap_renamed.getWidth();
                int height3 = this.ap_renamed.getHeight();
                if (this.aJ_renamed) {
                    z_renamed = false;
                }
                bVar.a_renamed(width4, height3, z_renamed);
            }
        }
    }

    private android.widget.ImageView b_renamed(android.view.ViewGroup viewGroup) {
        android.widget.ImageView imageView = new android.widget.ImageView(this.X_renamed);
        android.view.ViewGroup.LayoutParams layoutParams = new android.view.ViewGroup.LayoutParams(-1, -1);
        imageView.setVisibility(8);
        viewGroup.addView(imageView, layoutParams);
        return imageView;
    }

    public void h_renamed(boolean z_renamed) {
        com.oplus.camera.ui.preview.g_renamed.b_renamed bVar;
        int width = this.ap_renamed.getWidth();
        int height = this.ap_renamed.getHeight();
        boolean z2 = java.lang.Math.abs((((double) java.lang.Math.max(width, height)) / ((double) java.lang.Math.min(width, height))) - 1.3333333333333333d) <= 0.01d;
        if (z_renamed && (bVar = this.ak_renamed) != null && bVar.j_renamed(com.oplus.camera.aps.config.CameraFunction.ID_PHOTO) && z2) {
            if (this.aR_renamed == null) {
                this.aR_renamed = new android.widget.ImageView(this.X_renamed);
                this.aR_renamed.setForegroundGravity(48);
                if (this.ak_renamed.cv_renamed() == 0) {
                    this.aR_renamed.setImageResource(com.oplus.camera.R_renamed.drawable.id_photo_guide_puzzle_rear);
                } else {
                    this.aR_renamed.setImageResource(com.oplus.camera.R_renamed.drawable.id_photo_guide_puzzle_front);
                }
                this.ap_renamed.addView(this.aR_renamed, new android.view.ViewGroup.LayoutParams(-1, -1));
                return;
            }
            return;
        }
        android.widget.ImageView imageView = this.aR_renamed;
        if (imageView != null) {
            this.ap_renamed.removeView(imageView);
            this.aR_renamed = null;
        }
    }

    public static void c_renamed(android.graphics.Bitmap bitmap) {
        h_renamed = bitmap;
    }

    public static android.graphics.Bitmap D_renamed() {
        return h_renamed;
    }

    public void E_renamed() {
        android.graphics.Bitmap bitmapD = D_renamed();
        if (bitmapD != null) {
            com.oplus.camera.e_renamed.a_renamed("coverBlurView");
            if (this.ao_renamed == null) {
                this.ao_renamed = new android.widget.ImageView(this.X_renamed);
                this.ao_renamed.setScaleType(android.widget.ImageView.ScaleType.CENTER_CROP);
                this.ao_renamed.setVisibility(0);
            }
            com.oplus.camera.e_renamed.a_renamed("CameraPreviewUI", "coverBlurView, mBlurCover: " + this.ao_renamed);
            this.ao_renamed.setImageBitmap(bitmapD);
            this.ao_renamed.setAlpha(1.0f);
            if (90 != this.P_renamed) {
                this.ao_renamed.setRotation(((r2 - 90) + 360) % 360);
            } else {
                this.ao_renamed.setRotation(0.0f);
            }
            this.ao_renamed.clearAnimation();
            this.ap_renamed.setClipChildren(true);
            if (this.ap_renamed.indexOfChild(this.ao_renamed) < 0) {
                this.ap_renamed.addView(this.ao_renamed, new android.view.ViewGroup.LayoutParams(-1, -1));
            }
            double height = (bitmapD.getHeight() * 1.0d) / bitmapD.getWidth();
            if (com.oplus.camera.util.c_renamed.f7328a && this.an_renamed == null && (1.0d == height || 1.3333333333333333d == height || 1.7777777777777777d == height)) {
                this.an_renamed = new com.oplus.camera.ui.preview.e_renamed(this.X_renamed);
                if (1.0d == height) {
                    this.an_renamed.a_renamed(com.oplus.camera.util.Util.L_renamed(), com.oplus.camera.util.Util.getScreenWidth());
                } else if (1.3333333333333333d == height) {
                    this.an_renamed.a_renamed(0, (int) (com.oplus.camera.util.Util.getScreenWidth() * 1.3333333333333333d));
                } else {
                    this.an_renamed.a_renamed(0, (int) (com.oplus.camera.util.Util.getScreenWidth() * 1.7777777777777777d));
                }
                this.an_renamed.setDrawColor(com.oplus.camera.util.c_renamed.a_renamed(-16777216));
                this.au_renamed.addView(this.an_renamed, this.au_renamed.indexOfChild(this.aL_renamed) + 1, new android.view.ViewGroup.LayoutParams(-1, -1));
            }
            com.oplus.camera.e_renamed.b_renamed("coverBlurView");
        }
    }

    public void F_renamed() {
        com.oplus.camera.e_renamed.a_renamed("CameraPreviewUI", "hideBlurView, mBlurCover: " + this.ao_renamed);
        if (this.ao_renamed != null) {
            com.oplus.camera.e_renamed.a_renamed("CameraStartupPerformance.hideBlurView");
            com.oplus.camera.ui.preview.PreviewFrameLayout previewFrameLayout = this.ap_renamed;
            if (previewFrameLayout != null) {
                previewFrameLayout.removeView(this.ao_renamed);
                this.ap_renamed.setClipChildren(false);
            }
            com.oplus.camera.ui.preview.e_renamed eVar = this.an_renamed;
            if (eVar != null) {
                this.au_renamed.removeView(eVar);
                this.an_renamed = null;
            }
            com.oplus.camera.e_renamed.b_renamed("CameraStartupPerformance.hideBlurView");
        }
    }

    public android.widget.ImageView G_renamed() {
        return this.ao_renamed;
    }

    public float H_renamed() {
        float f_renamed;
        synchronized (this.o_renamed) {
            f_renamed = this.W_renamed;
        }
        return f_renamed;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void at_renamed() {
        android.view.animation.AlphaAnimation alphaAnimation = new android.view.animation.AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setDuration(10L);
        alphaAnimation.setAnimationListener(this.bu_renamed);
        if (this.at_renamed == null) {
            this.at_renamed = b_renamed(this.ap_renamed);
        }
        this.at_renamed.startAnimation(alphaAnimation);
        this.bf_renamed = true;
    }

    public void I_renamed() {
        if (this.y_renamed) {
            return;
        }
        this.bf_renamed = false;
        if (this.at_renamed == null) {
            this.at_renamed = b_renamed(this.ap_renamed);
        }
        this.at_renamed.setImageBitmap(null);
        this.at_renamed.setVisibility(0);
        this.at_renamed.setBackgroundColor(-16777216);
        android.view.animation.AlphaAnimation alphaAnimation = new android.view.animation.AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setInterpolator(new com.oplus.camera.ui.preview.g_renamed.d_renamed());
        alphaAnimation.setDuration(50L);
        alphaAnimation.setAnimationListener(this.bt_renamed);
        this.at_renamed.clearAnimation();
        this.at_renamed.setLayerType(2, null);
        this.at_renamed.startAnimation(alphaAnimation);
    }

    @Override // com.oplus.camera.ui.preview.PreviewFrameLayout.OnSizeChangedListener
    public void a_renamed(int i_renamed, int i2, int i3, int i4) {
        com.oplus.camera.e_renamed.a_renamed("CameraPreviewUI", "onSizeChanged, width: " + i_renamed + ", height: " + i2);
        com.oplus.camera.ui.preview.g_renamed.b_renamed bVar = this.ak_renamed;
        boolean z_renamed = true;
        if (bVar != null) {
            bVar.a_renamed(i_renamed, i2, !this.aJ_renamed);
        }
        if (com.oplus.camera.util.Util.t_renamed()) {
            synchronized (this.o_renamed) {
                if (this.ae_renamed != null) {
                    this.ae_renamed.g_renamed();
                }
            }
        }
        synchronized (this.o_renamed) {
            if (this.z_renamed) {
                this.z_renamed = false;
                return;
            }
            if (i_renamed == i3 && i2 == i4 && !c_renamed(i_renamed, i2)) {
                z_renamed = false;
            }
            r_renamed(z_renamed);
        }
    }

    private boolean c_renamed(int i_renamed, int i2) {
        android.util.Size size = this.aF_renamed;
        if (size == null || this.aG_renamed == null || i_renamed == 0 || i2 == 0) {
            return true;
        }
        int height = size.getHeight() - this.aG_renamed.getHeight();
        com.oplus.camera.e_renamed.a_renamed("CameraPreviewUI", "decideSizeChangeFlag, width: " + i_renamed + ", height: " + i2 + ", mToDisplaySize: " + this.aF_renamed + ", tempDiffWidth: " + height);
        android.util.Size size2 = new android.util.Size(i_renamed, i2);
        if (height != 0) {
            android.util.Size size3 = new android.util.Size(i_renamed, i2 + height);
            android.util.Size size4 = new android.util.Size(height + i_renamed, i2);
            if (size2.equals(this.aF_renamed) || d_renamed(size2).equals(this.aF_renamed) || size3.equals(this.aF_renamed) || d_renamed(size3).equals(this.aF_renamed) || size4.equals(this.aF_renamed) || d_renamed(size4).equals(this.aF_renamed)) {
                return false;
            }
        } else if ((size2.equals(this.aF_renamed) || d_renamed(size2).equals(this.aF_renamed)) && this.J_renamed == i2 && this.I_renamed == i_renamed) {
            return false;
        }
        android.util.Size size5 = new android.util.Size((int) ((i_renamed / i2) * this.aF_renamed.getHeight()), this.aF_renamed.getHeight());
        return (size5.equals(this.aF_renamed) || d_renamed(size5).equals(this.aF_renamed)) ? false : true;
    }

    private android.util.Size d_renamed(android.util.Size size) {
        return new android.util.Size(size.getHeight(), size.getWidth());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int au_renamed() {
        int i_renamed;
        synchronized (this.o_renamed) {
            i_renamed = this.B_renamed;
        }
        return i_renamed;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int av_renamed() {
        int i_renamed;
        synchronized (this.o_renamed) {
            i_renamed = this.E_renamed;
        }
        return i_renamed;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int aw_renamed() {
        int i_renamed;
        synchronized (this.o_renamed) {
            i_renamed = this.I_renamed;
        }
        return i_renamed;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int ax_renamed() {
        int i_renamed;
        synchronized (this.o_renamed) {
            i_renamed = this.J_renamed;
        }
        return i_renamed;
    }

    private void r_renamed(boolean z_renamed) {
        synchronized (this) {
            com.oplus.camera.e_renamed.a_renamed("CameraPreviewUI", "setSizeChanged, sizeChanged: " + z_renamed);
            this.r_renamed = z_renamed;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ay_renamed() {
        boolean z_renamed;
        synchronized (this) {
            z_renamed = this.r_renamed;
        }
        return z_renamed;
    }

    public android.graphics.Rect J_renamed() {
        android.graphics.Rect rect;
        synchronized (this.o_renamed) {
            int i_renamed = this.G_renamed == 0 ? this.E_renamed : this.G_renamed;
            rect = new android.graphics.Rect(this.B_renamed, i_renamed, this.B_renamed + this.I_renamed, (this.aF_renamed == null ? this.J_renamed : this.aF_renamed.getWidth()) + i_renamed);
        }
        return rect;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public void onLayoutChange(android.view.View view, int i_renamed, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        if (i_renamed == i5 && i2 == i6 && i3 == i7 && i4 == i8) {
            return;
        }
        int i9 = i3 - i_renamed;
        int i10 = i4 - i2;
        if (com.oplus.camera.util.Util.a_renamed(this.X_renamed) % 180 == 0) {
            this.Z_renamed.c_renamed(i9, i10);
        } else {
            this.Z_renamed.c_renamed(i10, i9);
        }
        if (com.oplus.camera.util.Util.t_renamed()) {
            synchronized (this.o_renamed) {
                if (this.ae_renamed != null) {
                    this.ae_renamed.g_renamed();
                }
            }
        }
        com.oplus.camera.e_renamed.b_renamed("CameraPreviewUI", "onLayoutChange, layout: " + java.util.Arrays.toString(new int[]{i_renamed, i2, i3, i4}));
    }

    public void i_renamed(boolean z_renamed) {
        com.oplus.camera.ui.preview.FaceView faceView = this.ac_renamed;
        if (faceView == null || this.t_renamed) {
            return;
        }
        faceView.setMirror(z_renamed);
        this.ac_renamed.setVisibility(0);
        this.ac_renamed.b_renamed();
        this.ac_renamed.d_renamed();
        this.t_renamed = true;
    }

    public void K_renamed() {
        android.app.Activity activity = this.X_renamed;
        if (activity != null) {
            activity.runOnUiThread(new java.lang.Runnable() { // from class: com.oplus.camera.ui.preview.g_renamed.7
                @Override // java.lang.Runnable
                public void run() {
                    if (com.oplus.camera.ui.preview.g_renamed.this.ac_renamed != null) {
                        com.oplus.camera.ui.preview.g_renamed.this.ac_renamed.c_renamed();
                        com.oplus.camera.ui.preview.g_renamed.this.ac_renamed.b_renamed();
                        com.oplus.camera.ui.preview.g_renamed.this.t_renamed = false;
                    }
                }
            });
        }
    }

    public void L_renamed() {
        com.oplus.camera.ui.preview.MultiFocusView multiFocusView = this.ae_renamed;
        if (multiFocusView == null || this.u_renamed) {
            return;
        }
        multiFocusView.setVisibility(0);
        this.ae_renamed.d_renamed();
        this.u_renamed = true;
    }

    public void M_renamed() {
        android.app.Activity activity = this.X_renamed;
        if (activity != null) {
            activity.runOnUiThread(new java.lang.Runnable() { // from class: com.oplus.camera.ui.preview.g_renamed.8
                @Override // java.lang.Runnable
                public void run() {
                    if (com.oplus.camera.ui.preview.g_renamed.this.ae_renamed != null) {
                        com.oplus.camera.ui.preview.g_renamed.this.ae_renamed.c_renamed();
                        com.oplus.camera.ui.preview.g_renamed.this.u_renamed = false;
                    }
                }
            });
        }
    }

    public void N_renamed() {
        this.aj_renamed = this.ai_renamed;
        com.oplus.camera.ui.preview.g_renamed.b_renamed bVar = this.ak_renamed;
        if (bVar != null) {
            java.lang.String strH = bVar.ej_renamed().h_renamed();
            if ("full90" == strH) {
                this.aj_renamed = 270;
            } else if ("full270" == strH) {
                this.aj_renamed = 90;
            }
        }
    }

    public boolean a_renamed(android.view.MotionEvent motionEvent) {
        android.widget.ImageView imageView = this.am_renamed;
        if (imageView == null || !imageView.isShown()) {
            return false;
        }
        com.oplus.camera.e_renamed.a_renamed("CameraPreviewUI", "dispatchTouchEvent, mReviewImage is_renamed show");
        return true;
    }

    public com.oplus.camera.gl_renamed.GLRootView O_renamed() {
        return this.aL_renamed;
    }

    public void a_renamed(android.content.DialogInterface.OnCancelListener onCancelListener) {
        new com.coui.appcompat.dialog.app.b_renamed.a_renamed(this.X_renamed, com.oplus.camera.R_renamed.style.DialogAlert).setTitle(this.X_renamed.getResources().getString(com.oplus.camera.R_renamed.string.camera_video_rec_disable_title)).setNegativeButton(com.oplus.camera.R_renamed.string.camera_button_ok, new android.content.DialogInterface.OnClickListener() { // from class: com.oplus.camera.ui.preview.g_renamed.9
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(android.content.DialogInterface dialogInterface, int i_renamed) {
                dialogInterface.cancel();
            }
        }).setOnCancelListener(onCancelListener).show();
    }

    public void b_renamed(boolean z_renamed, boolean z2) throws android.content.res.Resources.NotFoundException {
        com.oplus.camera.e_renamed.c_renamed("CameraPreviewUI", "showHyperLapseFocusView, show: " + z_renamed);
        if (z_renamed && !this.p_renamed) {
            if (this.aO_renamed == null) {
                az_renamed();
            }
            aA_renamed();
        } else {
            com.oplus.camera.ui.preview.HyperLapseFocusView hyperLapseFocusView = this.aO_renamed;
            if (hyperLapseFocusView != null) {
                hyperLapseFocusView.setVisibility(8);
            }
            aB_renamed();
        }
    }

    private void az_renamed() {
        if (this.aO_renamed == null) {
            this.aO_renamed = (com.oplus.camera.ui.preview.HyperLapseFocusView) this.X_renamed.getLayoutInflater().inflate(com.oplus.camera.R_renamed.layout.view_hyper_lapse_focus, this.ap_renamed).findViewById(com.oplus.camera.R_renamed.id_renamed.hyper_lapse_focus_view);
            this.aO_renamed.a_renamed(this.bx_renamed);
            this.aQ_renamed = this.X_renamed.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.video_hyper_lapse_focus_top_margin);
        }
    }

    private void aA_renamed() throws android.content.res.Resources.NotFoundException {
        com.oplus.camera.ui.preview.HyperLapseFocusView hyperLapseFocusView = this.aO_renamed;
        if (hyperLapseFocusView == null || hyperLapseFocusView.getVisibility() == 0) {
            return;
        }
        int dimensionPixelSize = this.X_renamed.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.video_hyper_lapse_focus_width);
        android.widget.RelativeLayout.LayoutParams layoutParams = (android.widget.RelativeLayout.LayoutParams) this.aO_renamed.getLayoutParams();
        layoutParams.topMargin = this.aQ_renamed - com.oplus.camera.util.Util.R_renamed();
        layoutParams.leftMargin = (com.oplus.camera.util.Util.getScreenWidth() - dimensionPixelSize) / 2;
        this.aO_renamed.setLayoutParams(layoutParams);
        this.aO_renamed.setVisibility(0);
    }

    private void aB_renamed() {
        com.coui.appcompat.widget.s_renamed sVar = this.aP_renamed;
        if (sVar != null) {
            sVar.dismiss();
            this.aP_renamed = null;
        }
    }

    public java.lang.String P_renamed() {
        com.oplus.camera.ui.preview.HyperLapseFocusView hyperLapseFocusView = this.aO_renamed;
        if (hyperLapseFocusView == null || this.ap_renamed == null) {
            return "";
        }
        int[] iArr = new int[2];
        hyperLapseFocusView.getLocationOnScreen(iArr);
        return (iArr[0] + (this.aO_renamed.getWidth() / 2)) + "x_renamed" + ((iArr[1] + (this.aO_renamed.getHeight() / 2)) - this.ap_renamed.getTop());
    }

    public void Q_renamed() throws android.content.res.Resources.NotFoundException {
        com.coui.appcompat.dialog.app.b_renamed bVar = this.aa_renamed;
        if (bVar != null && bVar.isShowing()) {
            this.aa_renamed.cancel();
            this.aa_renamed = null;
            b_renamed(this.bv_renamed);
        } else {
            this.aa_renamed = null;
        }
        com.coui.appcompat.widget.s_renamed sVar = this.aP_renamed;
        if (sVar != null && sVar.isShowing()) {
            this.aP_renamed.dismiss();
            this.aP_renamed = null;
        } else {
            this.aP_renamed = null;
        }
    }

    private void b_renamed(android.content.DialogInterface.OnClickListener onClickListener) throws android.content.res.Resources.NotFoundException {
        if (this.aw_renamed != null) {
            com.coui.appcompat.dialog.app.b_renamed bVar = this.aa_renamed;
            if (bVar == null || !bVar.isShowing()) {
                com.coui.appcompat.dialog.app.b_renamed bVar2 = this.aa_renamed;
                if (bVar2 != null) {
                    bVar2.dismiss();
                }
                this.ab_renamed = new com.coui.appcompat.dialog.app.b_renamed.a_renamed(this.X_renamed, com.oplus.camera.R_renamed.style.DialogAlert);
                this.ab_renamed.setTitle(this.aw_renamed);
                this.ab_renamed.setOnKeyListener(new android.content.DialogInterface.OnKeyListener() { // from class: com.oplus.camera.ui.preview.g_renamed.12
                    @Override // android.content.DialogInterface.OnKeyListener
                    public boolean onKey(android.content.DialogInterface dialogInterface, int i_renamed, android.view.KeyEvent keyEvent) {
                        if (i_renamed != 4 || keyEvent.getRepeatCount() != 0) {
                            return false;
                        }
                        com.oplus.camera.ui.preview.g_renamed.this.aa_renamed.dismiss();
                        return false;
                    }
                });
                int i_renamed = com.oplus.camera.Storage.w_renamed;
                if (i_renamed == 1) {
                    if (com.oplus.camera.Storage.v_renamed == 1 || com.oplus.camera.Storage.v_renamed == 4 || com.oplus.camera.Storage.v_renamed == 5) {
                        a_renamed(onClickListener);
                    }
                    if (com.oplus.camera.Storage.v_renamed == 2 || com.oplus.camera.Storage.v_renamed == 3) {
                        R_renamed();
                    }
                } else if (i_renamed == 2 || i_renamed == 3) {
                    if (com.oplus.camera.Storage.v_renamed == 5) {
                        S_renamed();
                    }
                    if (com.oplus.camera.Storage.v_renamed == 1 || com.oplus.camera.Storage.v_renamed == 4) {
                        a_renamed(onClickListener);
                    }
                }
                this.aa_renamed = this.ab_renamed.create();
                this.aa_renamed.show();
            }
        }
    }

    public void R_renamed() throws android.content.res.Resources.NotFoundException {
        android.content.res.Resources resources = this.X_renamed.getResources();
        boolean z_renamed = this.bg_renamed;
        int i_renamed = com.oplus.camera.R_renamed.array.storage_tip_internal_full_external_available_can_clean;
        java.lang.String[] stringArray = resources.getStringArray(z_renamed ? com.oplus.camera.R_renamed.array.storage_tip_internal_full_external_available_can_clean : com.oplus.camera.R_renamed.array.storage_tip_internal_full_external_available_can_not_clean);
        int i2 = com.oplus.camera.Storage.v_renamed;
        final boolean z2 = false;
        if (i2 == 2) {
            android.content.res.Resources resources2 = this.X_renamed.getResources();
            if (!this.bg_renamed) {
                i_renamed = com.oplus.camera.R_renamed.array.storage_tip_internal_full_external_available_can_not_clean;
            }
            stringArray = resources2.getStringArray(i_renamed);
            z2 = true;
        } else if (i2 == 3) {
            stringArray = this.X_renamed.getResources().getStringArray(this.bg_renamed ? com.oplus.camera.R_renamed.array.storage_tip_external_full_internal_available_can_clean : com.oplus.camera.R_renamed.array.storage_tip_external_full_internal_available_can_not_clean);
        }
        this.ab_renamed.setItems(stringArray, new android.content.DialogInterface.OnClickListener() { // from class: com.oplus.camera.ui.preview.g_renamed.13
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(android.content.DialogInterface dialogInterface, int i3) {
                if (dialogInterface != null) {
                    if (i3 == 0) {
                        dialogInterface.dismiss();
                        if (com.oplus.camera.ui.preview.g_renamed.this.bg_renamed) {
                            android.content.Intent intent = new android.content.Intent("oplus.intent.action.CLEAR_MAIN_ACTIVITY");
                            intent.setPackage(com.oplus.camera.ui.preview.g_renamed.g_renamed);
                            try {
                                intent.addFlags(67108864);
                                com.oplus.camera.ui.preview.g_renamed.this.X_renamed.startActivity(intent);
                                return;
                            } catch (java.lang.Exception e2) {
                                com.oplus.camera.e_renamed.f_renamed("CameraPreviewUI", "makeMultipleOptionStorageDialog, Exception when start ClearMainActivity: " + e2);
                                return;
                            }
                        }
                        return;
                    }
                    if (i3 != 1) {
                        if (i3 != 2) {
                            return;
                        }
                        dialogInterface.dismiss();
                        return;
                    }
                    java.lang.String string = com.oplus.camera.ui.preview.g_renamed.this.Y_renamed.getString(com.oplus.camera.ui.CameraUIInterface.KEY_STORAGE_PLACE, com.oplus.camera.ui.preview.g_renamed.this.X_renamed.getString(com.oplus.camera.R_renamed.string.camera_storage_default_value));
                    if (z2) {
                        if ("off".equals(string)) {
                            android.content.SharedPreferences.Editor editorEdit = com.oplus.camera.ui.preview.g_renamed.this.Y_renamed.edit();
                            editorEdit.putString(com.oplus.camera.ui.CameraUIInterface.KEY_STORAGE_PLACE, "on_renamed");
                            editorEdit.apply();
                        }
                        com.oplus.camera.Storage.u_renamed = "on_renamed";
                    } else {
                        if ("on_renamed".equals(string)) {
                            android.content.SharedPreferences.Editor editorEdit2 = com.oplus.camera.ui.preview.g_renamed.this.Y_renamed.edit();
                            editorEdit2.putString(com.oplus.camera.ui.CameraUIInterface.KEY_STORAGE_PLACE, "off");
                            editorEdit2.apply();
                        }
                        com.oplus.camera.Storage.u_renamed = "off";
                    }
                    com.oplus.camera.Storage.w_renamed = com.oplus.camera.Storage.b_renamed(com.oplus.camera.Storage.u_renamed);
                }
            }
        });
    }

    public void a_renamed(android.content.DialogInterface.OnClickListener onClickListener) {
        this.ab_renamed.setPositiveButton(this.bg_renamed ? com.oplus.camera.R_renamed.string.camera_storage_button_clean : com.oplus.camera.R_renamed.string.camera_button_ok, onClickListener);
        this.ab_renamed.setNegativeButton(com.oplus.camera.R_renamed.string.camera_storage_button_cancel, new android.content.DialogInterface.OnClickListener() { // from class: com.oplus.camera.ui.preview.g_renamed.14
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(android.content.DialogInterface dialogInterface, int i_renamed) {
                if (dialogInterface != null) {
                    dialogInterface.dismiss();
                }
            }
        });
    }

    public void S_renamed() {
        this.ab_renamed.setNegativeButton(com.oplus.camera.R_renamed.string.camera_button_ok, new android.content.DialogInterface.OnClickListener() { // from class: com.oplus.camera.ui.preview.g_renamed.15
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(android.content.DialogInterface dialogInterface, int i_renamed) {
                if (dialogInterface == null || !"on_renamed".equals(com.oplus.camera.ui.preview.g_renamed.this.Y_renamed.getString(com.oplus.camera.ui.CameraUIInterface.KEY_STORAGE_PLACE, com.oplus.camera.ui.preview.g_renamed.this.X_renamed.getString(com.oplus.camera.R_renamed.string.camera_storage_default_value)))) {
                    return;
                }
                android.content.SharedPreferences.Editor editorEdit = com.oplus.camera.ui.preview.g_renamed.this.Y_renamed.edit();
                editorEdit.putString(com.oplus.camera.ui.CameraUIInterface.KEY_STORAGE_PLACE, "off");
                editorEdit.commit();
                com.oplus.camera.ui.preview.g_renamed.this.ak_renamed.cq_renamed();
            }
        });
    }

    public void T_renamed() throws android.content.res.Resources.NotFoundException {
        com.oplus.camera.e_renamed.a_renamed("CameraPreviewUI", "updateStorageHint(), storage_status = " + com.oplus.camera.Storage.w_renamed + ", Storage.sStorageOverrideState = " + com.oplus.camera.Storage.v_renamed);
        int i_renamed = com.oplus.camera.Storage.w_renamed;
        if (i_renamed == 0) {
            com.coui.appcompat.dialog.app.b_renamed bVar = this.aa_renamed;
            if (bVar != null) {
                bVar.cancel();
                return;
            }
            return;
        }
        if (i_renamed != 1) {
            if (i_renamed == 2 || i_renamed == 3) {
                if (com.oplus.camera.Storage.v_renamed == 5) {
                    this.aw_renamed = this.X_renamed.getString(com.oplus.camera.R_renamed.string.camera_storage_external_fail);
                } else if (com.oplus.camera.Storage.v_renamed == 1) {
                    this.aw_renamed = this.X_renamed.getString(com.oplus.camera.R_renamed.string.camera_storage_all_full);
                } else if (com.oplus.camera.Storage.v_renamed == 4) {
                    this.aw_renamed = this.X_renamed.getString(com.oplus.camera.R_renamed.string.camera_storage_internal_fullL_external_full);
                }
                b_renamed(this.bv_renamed);
                return;
            }
            return;
        }
        if (com.oplus.camera.Storage.v_renamed == 1) {
            this.aw_renamed = this.X_renamed.getString(com.oplus.camera.R_renamed.string.camera_storage_all_full);
        } else if (com.oplus.camera.Storage.v_renamed == 2) {
            this.aw_renamed = this.X_renamed.getString(com.oplus.camera.R_renamed.string.camera_storage_internal_full_external_avaliable);
        } else if (com.oplus.camera.Storage.v_renamed == 3) {
            this.aw_renamed = this.X_renamed.getString(com.oplus.camera.R_renamed.string.camera_storage_internal_avaliable_external_full);
        } else if (com.oplus.camera.Storage.v_renamed == 4) {
            this.aw_renamed = this.X_renamed.getString(com.oplus.camera.R_renamed.string.camera_storage_internal_fullL_external_full);
        } else if (com.oplus.camera.Storage.v_renamed == 5) {
            this.aw_renamed = this.X_renamed.getString(com.oplus.camera.R_renamed.string.camera_storage_all_full);
        }
        b_renamed(this.bv_renamed);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a_renamed(int i_renamed, int i2, boolean z_renamed, boolean z2, boolean z3) {
        float screenWidth;
        int iD;
        if (z2) {
            if (com.oplus.camera.util.Util.t_renamed()) {
                r_renamed(false);
                return;
            }
            synchronized (this.o_renamed) {
                if (this.ay_renamed == null) {
                    return;
                }
                int iF = this.Z_renamed.f_renamed();
                int iG = this.Z_renamed.g_renamed();
                if (this.ak_renamed.eb_renamed()) {
                    screenWidth = com.oplus.camera.util.Util.getScreenHeight() / iG;
                    this.aH_renamed = (int) (com.oplus.camera.util.Util.getScreenHeight() / 2.3333333333333335d);
                } else {
                    screenWidth = com.oplus.camera.util.Util.getScreenWidth() / iF;
                    this.aH_renamed = com.oplus.camera.util.Util.getScreenWidth();
                }
                this.I_renamed = this.aH_renamed;
                this.J_renamed = java.lang.Math.round(iG * screenWidth);
                this.B_renamed = i_renamed - (this.aH_renamed / 2);
                this.E_renamed = i2 - (this.J_renamed / 2);
                if (this.E_renamed < this.ap_renamed.getTop()) {
                    this.E_renamed = this.ap_renamed.getTop();
                }
                if (this.B_renamed < this.ap_renamed.getLeft()) {
                    this.B_renamed = this.ap_renamed.getLeft();
                }
                if (this.E_renamed != this.ap_renamed.getTop()) {
                    if (!z_renamed) {
                        this.E_renamed = com.oplus.camera.util.Util.N_renamed();
                    } else {
                        this.E_renamed = 0;
                    }
                }
                r_renamed(false);
                if (this.ak_renamed.cp_renamed() || this.ak_renamed.dY_renamed()) {
                    if (this.v_renamed) {
                        iD = com.oplus.camera.util.Util.d_renamed(this.aF_renamed.getWidth(), this.aF_renamed.getHeight());
                    } else {
                        iD = com.oplus.camera.util.Util.d_renamed(this.ay_renamed.getWidth(), this.ay_renamed.getHeight());
                    }
                    if (z3 || !this.ak_renamed.dY_renamed()) {
                        i_renamed(iD);
                    }
                } else {
                    this.E_renamed = com.oplus.camera.util.Util.N_renamed();
                    if (this.ah_renamed != 3) {
                        this.J_renamed = (int) (this.I_renamed * 1.7777777777777777d);
                        if (!com.oplus.camera.util.Util.W_renamed()) {
                            this.J_renamed = (com.oplus.camera.util.Util.getScreenHeight() - com.oplus.camera.util.Util.R_renamed()) - com.oplus.camera.util.Util.S_renamed();
                        }
                        if (this.v_renamed) {
                            i_renamed(com.oplus.camera.util.Util.d_renamed(this.aF_renamed.getWidth(), this.aF_renamed.getHeight()));
                        }
                    }
                    if (this.aF_renamed != null && this.v_renamed && com.oplus.camera.util.Util.d_renamed(this.aF_renamed.getWidth(), this.aF_renamed.getHeight()) > 2) {
                        this.E_renamed = 0;
                        this.J_renamed = com.oplus.camera.util.Util.getScreenHeight();
                    }
                }
                synchronized (this.o_renamed) {
                    if (this.L_renamed != 0) {
                        this.w_renamed = true;
                        this.D_renamed = this.C_renamed - (this.L_renamed / 2);
                    }
                    if (this.F_renamed != this.E_renamed) {
                        this.x_renamed = true;
                        this.G_renamed = this.E_renamed;
                        this.H_renamed = this.G_renamed - this.F_renamed;
                    }
                    if (this.ae_renamed != null) {
                        this.ae_renamed.g_renamed();
                    }
                    com.oplus.camera.e_renamed.a_renamed("CameraPreviewUI", "layoutPreview, leftMargin: " + this.B_renamed + ", topMargin: " + this.E_renamed + ", width: " + this.I_renamed + ", height: " + this.J_renamed);
                }
            }
        }
    }

    private void i_renamed(int i_renamed) {
        java.lang.String strBg = this.ak_renamed.bg_renamed();
        if (com.oplus.camera.aps.constant.ApsConstant.CAPTURE_MODE_XPAN.equals(this.ak_renamed.bh_renamed()) || (!strBg.isEmpty() && this.ak_renamed.dX_renamed())) {
            this.B_renamed = 0;
        }
        if (i_renamed == 0) {
            this.E_renamed = com.oplus.camera.util.Util.N_renamed();
            return;
        }
        if (i_renamed == 1) {
            if (com.oplus.camera.util.Util.W_renamed()) {
                this.E_renamed = com.oplus.camera.util.Util.N_renamed();
                if (com.oplus.camera.util.Util.t_renamed()) {
                    this.E_renamed = (com.oplus.camera.util.Util.N_renamed() / 2) - com.oplus.camera.util.Util.M_renamed();
                    return;
                }
                return;
            }
            if (com.oplus.camera.util.Util.t_renamed() && !com.oplus.camera.util.Util.u_renamed()) {
                this.E_renamed = (com.oplus.camera.util.Util.N_renamed() / 2) - com.oplus.camera.util.Util.M_renamed();
                return;
            } else {
                this.E_renamed = 0;
                this.J_renamed = com.oplus.camera.util.Util.getScreenHeight();
                return;
            }
        }
        if (i_renamed == 2) {
            this.E_renamed = com.oplus.camera.util.Util.L_renamed() + com.oplus.camera.util.Util.N_renamed();
            return;
        }
        this.E_renamed = 0;
        this.J_renamed = com.oplus.camera.util.Util.getScreenHeight();
        if (com.oplus.camera.aps.constant.ApsConstant.CAPTURE_MODE_XPAN.equals(strBg) || (strBg.isEmpty() && this.ak_renamed.dX_renamed())) {
            this.J_renamed = (int) (com.oplus.camera.util.Util.getScreenHeight() * 0.87f);
            this.I_renamed = (int) (com.oplus.camera.util.Util.getScreenWidth() * 0.87f);
            this.E_renamed = (com.oplus.camera.util.Util.getScreenHeight() - this.J_renamed) / 2;
            this.B_renamed = (com.oplus.camera.util.Util.getScreenWidth() - this.I_renamed) / 2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aC_renamed() {
        com.oplus.camera.e_renamed.a_renamed("CameraPreviewUI", "notifyPreviewImageAnimOnStart");
        com.oplus.camera.ui.preview.g_renamed.a_renamed aVar = this.aI_renamed;
        if (aVar != null) {
            aVar.a_renamed(this.aB_renamed);
        }
        android.app.Activity activity = this.X_renamed;
        if (activity != null) {
            activity.onUserInteraction();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aD_renamed() {
        com.oplus.camera.e_renamed.a_renamed("CameraPreviewUI", "notifyPreviewImageAnimOnMiddle, mbCancleBlurAnimation: " + this.s_renamed);
        com.oplus.camera.ui.preview.g_renamed.a_renamed aVar = this.aI_renamed;
        if (aVar != null) {
            aVar.a_renamed(this.aC_renamed, this.aB_renamed);
        }
    }

    public void U_renamed() {
        com.oplus.camera.e_renamed.a_renamed("CameraPreviewUI", "cancelBlurAnimation");
        this.s_renamed = true;
        android.os.Handler handler = this.br_renamed;
        if (handler != null) {
            handler.removeMessages(1);
            this.br_renamed.removeMessages(2);
        }
    }

    public void V_renamed() {
        synchronized (this.o_renamed) {
            this.v_renamed = false;
        }
    }

    public void W_renamed() {
        boolean z_renamed;
        if (this.aC_renamed == null || this.aB_renamed == null || this.aI_renamed == null || (z_renamed = this.s_renamed)) {
            return;
        }
        if (z_renamed) {
            com.oplus.camera.e_renamed.a_renamed("CameraPreviewUI", "notifyPreviewImageAnimationOnMiddle cancel animation");
        } else {
            this.br_renamed.removeMessages(2);
            this.br_renamed.sendEmptyMessage(2);
        }
    }

    public void a_renamed(android.util.Size size, android.util.Size size2, final com.oplus.camera.ui.preview.g_renamed.a_renamed aVar, int i_renamed, int i2, int i3, boolean z_renamed) {
        this.aC_renamed = size;
        this.aB_renamed = size2;
        this.aI_renamed = aVar;
        this.s_renamed = false;
        this.Z_renamed.a_renamed(new com.oplus.camera.ui.preview.h_renamed.a_renamed() { // from class: com.oplus.camera.ui.preview.g_renamed.16
            @Override // com.oplus.camera.ui.preview.h_renamed.a_renamed
            public void a_renamed() {
                com.oplus.camera.ui.preview.g_renamed.a_renamed aVar2;
                synchronized (com.oplus.camera.ui.preview.g_renamed.this.o_renamed) {
                    com.oplus.camera.ui.preview.g_renamed.this.v_renamed = false;
                }
                if (com.oplus.camera.ui.preview.g_renamed.this.p_renamed || (aVar2 = aVar) == null) {
                    return;
                }
                aVar2.a_renamed();
            }
        });
        c_renamed();
        a_renamed(size, size2, i2, i3);
        com.oplus.camera.screen.out.e_renamed eVar = this.bc_renamed;
        if (eVar != null) {
            eVar.a_renamed(this.aF_renamed.getWidth(), this.aF_renamed.getHeight());
        }
        aG_renamed();
        a_renamed((this.ap_renamed.getRight() - this.ap_renamed.getLeft()) / 2, (this.ap_renamed.getBottom() - this.ap_renamed.getTop()) / 2, false, true, z_renamed);
        synchronized (this.o_renamed) {
            this.Z_renamed.a_renamed(this.aG_renamed, this.aF_renamed);
            com.oplus.camera.e_renamed.a_renamed("CameraPreviewUI", "startShowPreviewImageAnimation, preview size change: " + this.aC_renamed.getWidth() + " x_renamed " + this.aC_renamed.getHeight() + " => " + this.aB_renamed.getWidth() + " x_renamed " + this.aB_renamed.getHeight() + ", mHeight: " + this.J_renamed + ", mWidth: " + this.I_renamed + ", offSetY: " + av_renamed() + ", mDiffSize: " + this.K_renamed + ", moreTime: " + i_renamed);
        }
        android.app.Activity activity = this.X_renamed;
        if (activity != null) {
            activity.runOnUiThread(new java.lang.Runnable() { // from class: com.oplus.camera.ui.preview.g_renamed.17
                @Override // java.lang.Runnable
                public void run() {
                    if (com.oplus.camera.ui.preview.g_renamed.this.X_renamed != null) {
                        com.oplus.camera.ui.preview.g_renamed.this.X_renamed.onUserInteraction();
                    }
                }
            });
        }
        if (!this.s_renamed) {
            this.br_renamed.removeMessages(1);
            this.br_renamed.sendEmptyMessageDelayed(1, i_renamed);
        }
        g_renamed(true);
    }

    public void a_renamed(final com.oplus.camera.screen.b_renamed.a_renamed aVar, final android.util.Size size) {
        synchronized (this.o_renamed) {
            if (!this.aJ_renamed && this.K_renamed == 0 && this.L_renamed == 0 && this.aD_renamed == 0 && this.aE_renamed == 0 && this.J_renamed != 0 && this.I_renamed != 0) {
                if (com.oplus.camera.util.Util.u_renamed()) {
                    this.W_renamed = 500.0f;
                    this.i_renamed = this.m_renamed;
                    this.aJ_renamed = true;
                } else {
                    this.W_renamed = this.V_renamed;
                    this.i_renamed = this.n_renamed;
                }
                this.bi_renamed = aVar;
                this.bj_renamed = size;
                android.graphics.Rect rectB = aVar.b_renamed(size.getHeight(), size.getWidth());
                this.aD_renamed = rectB.left - this.B_renamed;
                this.aE_renamed = rectB.top - this.E_renamed;
                this.aF_renamed = new android.util.Size(rectB.height(), rectB.width());
                this.aG_renamed = new android.util.Size(this.J_renamed, this.I_renamed);
                this.L_renamed = this.aF_renamed.getHeight() - this.aG_renamed.getHeight();
                this.K_renamed = this.aF_renamed.getWidth() - this.aG_renamed.getWidth();
                this.U_renamed = android.os.SystemClock.uptimeMillis();
                this.C_renamed = this.B_renamed;
                this.F_renamed = this.E_renamed;
                com.oplus.camera.e_renamed.b_renamed("CameraPreviewUI", "startScreenModeChangeAnimation, mFromDisplaySize: " + this.aG_renamed.getWidth() + "x_renamed" + this.aG_renamed.getHeight() + ", mOffsetX: " + this.B_renamed + ", mOffsetY: " + this.E_renamed + ", mToDisplaySize: " + this.aF_renamed.getWidth() + "x_renamed" + this.aF_renamed.getHeight() + ", mTranslateX : " + this.aD_renamed + ", mTranslateY: " + this.aE_renamed + ", mToScreenMode: " + this.bi_renamed + ", mToPreviewSize: " + this.bj_renamed + ", toRegion: " + rectB);
                if (com.oplus.camera.util.Util.u_renamed()) {
                    this.br_renamed.post(new java.lang.Runnable() { // from class: com.oplus.camera.ui.preview.g_renamed.18
                        @Override // java.lang.Runnable
                        public void run() {
                            com.oplus.camera.ui.preview.g_renamed.this.ak_renamed.a_renamed(aVar, size, com.oplus.camera.ui.preview.g_renamed.this.aE_renamed());
                            if (com.oplus.camera.ui.preview.g_renamed.this.ap_renamed != null) {
                                com.oplus.camera.ui.preview.g_renamed.this.ap_renamed.setVisibility(8);
                            }
                        }
                    });
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long aE_renamed() {
        long j_renamed;
        synchronized (this.o_renamed) {
            j_renamed = this.U_renamed;
        }
        return j_renamed;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aF_renamed() {
        com.oplus.camera.e_renamed.b_renamed("CameraPreviewUI", "stopScreenModeChangeAnimation");
        this.aL_renamed.setRenderMode(0);
        if (this.ak_renamed == null || this.bi_renamed == null) {
            return;
        }
        this.br_renamed.post(new java.lang.Runnable() { // from class: com.oplus.camera.ui.preview.g_renamed.20
            @Override // java.lang.Runnable
            public void run() {
                com.oplus.camera.ui.preview.g_renamed.this.ak_renamed.eK_renamed();
                if (com.oplus.camera.ui.preview.g_renamed.this.ap_renamed != null) {
                    com.oplus.camera.ui.preview.g_renamed.this.ap_renamed.setVisibility(0);
                }
            }
        });
        this.aJ_renamed = false;
        this.W_renamed = this.V_renamed;
        this.i_renamed = this.n_renamed;
        this.z_renamed = true;
        android.graphics.Rect rectB = this.bi_renamed.b_renamed(this.bj_renamed.getHeight(), this.bj_renamed.getWidth());
        this.B_renamed = rectB.left;
        this.E_renamed = rectB.top;
        this.I_renamed = rectB.width();
        this.J_renamed = rectB.height();
        this.bk_renamed = this.bi_renamed.h_renamed();
        this.bl_renamed = this.bj_renamed;
        com.oplus.camera.e_renamed.b_renamed("CameraPreviewUI", "stopScreenModeChangeAnimation, mToScreenMode: " + this.bi_renamed + ", mToPreviewSize: " + this.bj_renamed + ", region: " + rectB);
        this.br_renamed.post(new java.lang.Runnable() { // from class: com.oplus.camera.ui.preview.g_renamed.21
            @Override // java.lang.Runnable
            public void run() {
                com.oplus.camera.ui.preview.g_renamed gVar = com.oplus.camera.ui.preview.g_renamed.this;
                gVar.c_renamed(gVar.bj_renamed);
            }
        });
    }

    public boolean X_renamed() {
        boolean z_renamed;
        synchronized (this.o_renamed) {
            z_renamed = this.aJ_renamed;
        }
        return z_renamed;
    }

    private void aG_renamed() {
        synchronized (this.o_renamed) {
            this.L_renamed = this.aF_renamed.getHeight() - this.aG_renamed.getHeight();
            this.K_renamed = this.aF_renamed.getWidth() - this.aG_renamed.getWidth();
            this.U_renamed = android.os.SystemClock.uptimeMillis();
            this.v_renamed = true;
            this.C_renamed = this.B_renamed;
            this.F_renamed = this.E_renamed;
            this.w_renamed = false;
            this.x_renamed = false;
            this.H_renamed = 0;
            this.O_renamed.clear();
            this.W_renamed = this.V_renamed;
            this.i_renamed = this.n_renamed;
            if (com.oplus.camera.util.Util.t_renamed()) {
                this.aJ_renamed = false;
                com.oplus.camera.screen.b_renamed.a_renamed aVarEj = this.ak_renamed.ej_renamed();
                android.graphics.Rect rectB = aVarEj.b_renamed(this.aB_renamed.getHeight(), this.aB_renamed.getWidth());
                this.aD_renamed = rectB.left - this.C_renamed;
                this.aE_renamed = rectB.top - this.F_renamed;
                this.H_renamed = this.aE_renamed;
                this.L_renamed = rectB.width() - this.I_renamed;
                this.K_renamed = rectB.height() - this.J_renamed;
                this.aG_renamed = new android.util.Size(this.J_renamed, this.I_renamed);
                this.aF_renamed = new android.util.Size(rectB.height(), rectB.width());
                if (!aVarEj.h_renamed().equals(this.bk_renamed)) {
                    this.i_renamed = this.m_renamed;
                    this.W_renamed = 500.0f;
                    this.aJ_renamed = true;
                    this.bi_renamed = aVarEj;
                    this.bj_renamed = this.aB_renamed;
                }
                com.oplus.camera.e_renamed.b_renamed("CameraPreviewUI", "initValue, mDiffWidth: " + this.L_renamed + ", mDiffHeight: " + this.K_renamed + ", mTranslateX: " + this.aD_renamed + ", mTranslateY: " + this.aE_renamed + ", displaySize: " + this.aG_renamed + "-->" + this.aF_renamed + ", mLastScreenModeName: " + this.bk_renamed + ", currentScreenMode: " + aVarEj);
            }
            if (this.X_renamed != null) {
                com.oplus.camera.ui.a_renamed.a_renamed(this.X_renamed).a_renamed(this.U_renamed, (long) this.V_renamed);
            }
        }
    }

    private void d_renamed(int i_renamed, int i2) {
        synchronized (this.o_renamed) {
            if (this.O_renamed.size() == 0) {
                this.O_renamed.add(new com.oplus.camera.ui.preview.g_renamed.e_renamed(i_renamed, i2));
            } else {
                com.oplus.camera.ui.preview.g_renamed.e_renamed eVar = this.O_renamed.get(this.O_renamed.size() - 1);
                if (eVar.f7071a + eVar.f7072b != i_renamed + i2) {
                    this.O_renamed.add(new com.oplus.camera.ui.preview.g_renamed.e_renamed(i_renamed, i2));
                }
            }
        }
    }

    public void a_renamed(long j_renamed) {
        synchronized (this.o_renamed) {
            if (this.aG_renamed != null) {
                long j2 = j_renamed - this.U_renamed;
                if (j2 > this.V_renamed) {
                    j2 = (long) this.V_renamed;
                }
                float interpolation = this.i_renamed.getInterpolation(j2 / this.V_renamed);
                d_renamed(this.F_renamed + ((int) (this.H_renamed * interpolation)), this.aG_renamed.getWidth() + ((int) (this.K_renamed * interpolation)));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.oplus.camera.ui.preview.g_renamed.e_renamed aH_renamed() {
        synchronized (this.o_renamed) {
            if (this.O_renamed.size() <= 0) {
                return null;
            }
            return this.O_renamed.get(this.O_renamed.size() - 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.oplus.camera.ui.preview.g_renamed.e_renamed aI_renamed() {
        synchronized (this.o_renamed) {
            if (this.O_renamed.size() <= 1) {
                return null;
            }
            return this.O_renamed.get(this.O_renamed.size() - 2);
        }
    }

    public int Y_renamed() {
        synchronized (this.o_renamed) {
            com.oplus.camera.ui.preview.g_renamed.e_renamed eVarAH = null;
            if (this.K_renamed > 0) {
                eVarAH = aI_renamed();
            } else if (this.K_renamed < 0) {
                eVarAH = aH_renamed();
            }
            if (eVarAH == null) {
                return -1;
            }
            return eVarAH.f7071a + eVarAH.f7072b;
        }
    }

    public void a_renamed(android.util.Size size, android.util.Size size2, int i_renamed, int i2) {
        synchronized (this.o_renamed) {
            com.oplus.camera.e_renamed.a_renamed("CameraPreviewUI", "updateDisplaySize, Size width: " + size.getWidth() + " x_renamed " + size.getHeight() + " => " + size2.getWidth() + " x_renamed " + size2.getHeight() + ", mHeight: " + this.J_renamed + ", mWidth: " + this.I_renamed);
            if (this.Z_renamed.x_renamed()) {
                this.aG_renamed = new android.util.Size(this.J_renamed, this.I_renamed);
                double width = size2.getWidth() / size2.getHeight();
                if (1 == this.ak_renamed.aX_renamed()) {
                    this.aF_renamed = new android.util.Size(com.oplus.camera.util.Util.getScreenHeight(), (int) (com.oplus.camera.util.Util.getScreenHeight() / width));
                } else {
                    this.aF_renamed = new android.util.Size((int) (width * this.I_renamed), this.I_renamed);
                }
                return;
            }
            if (size.getWidth() == size2.getWidth() && size.getHeight() == size2.getHeight()) {
                this.aG_renamed = size;
                this.aF_renamed = size2;
                this.K_renamed = 0;
                this.H_renamed = 0;
                this.G_renamed = 0;
                this.O_renamed.clear();
                com.oplus.camera.ui.a_renamed.a_renamed(this.X_renamed).a_renamed();
                return;
            }
            int[] iArrA = this.ak_renamed.a_renamed(size, size2);
            if (iArrA != null) {
                this.aG_renamed = new android.util.Size(iArrA[0], iArrA[1]);
                this.aF_renamed = new android.util.Size(iArrA[2], iArrA[3]);
            } else {
                this.aG_renamed = new android.util.Size((int) ((size.getWidth() / size.getHeight()) * i_renamed), i_renamed);
                this.aF_renamed = com.oplus.camera.util.Util.a_renamed(size2) ? new android.util.Size(com.oplus.camera.util.Util.getScreenHeight(), com.oplus.camera.util.Util.getScreenWidth()) : new android.util.Size((int) ((size2.getWidth() / size2.getHeight()) * i2), i2);
                java.lang.String strBg = this.ak_renamed.bg_renamed();
                if (com.oplus.camera.aps.constant.ApsConstant.CAPTURE_MODE_XPAN.equals(strBg) || (this.ak_renamed.dX_renamed() && strBg.isEmpty())) {
                    this.aF_renamed = new android.util.Size(java.lang.Math.round(com.oplus.camera.util.Util.getScreenHeight() * 0.87f), java.lang.Math.round(com.oplus.camera.util.Util.getScreenWidth() * 0.87f));
                }
            }
            com.oplus.camera.e_renamed.a_renamed("CameraPreviewUI", "updateDisplaySize, DisplaySize: " + this.aG_renamed.getWidth() + " x_renamed " + this.aG_renamed.getHeight() + " => " + this.aF_renamed.getWidth() + " x_renamed " + this.aF_renamed.getHeight());
        }
    }

    public void j_renamed(boolean z_renamed) {
        com.oplus.camera.ui.preview.FaceView faceView = this.ac_renamed;
        if (faceView != null) {
            faceView.setShowBeauty3DFace(z_renamed);
        }
    }

    public void f_renamed(int i_renamed) {
        com.oplus.camera.ui.preview.FaceView faceView = this.ac_renamed;
        if (faceView != null) {
            faceView.setMainFaceIndex(i_renamed);
        }
    }

    @Override // com.oplus.camera.ui.preview.h_renamed.c_renamed
    public void Z_renamed() {
        com.oplus.camera.gl_renamed.GLRootView gLRootView = this.aL_renamed;
        if (gLRootView != null) {
            gLRootView.a_renamed();
        }
        com.oplus.camera.ui.preview.g_renamed.b_renamed bVar = this.ak_renamed;
        if (bVar != null) {
            bVar.cr_renamed();
        }
    }

    @Override // com.oplus.camera.ui.preview.h_renamed.c_renamed
    public void aa_renamed() {
        com.oplus.camera.ui.preview.g_renamed.b_renamed bVar = this.ak_renamed;
        if (bVar != null) {
            bVar.cs_renamed();
        }
    }

    @Override // com.oplus.camera.ui.preview.h_renamed.c_renamed
    public void ab_renamed() {
        com.oplus.camera.gl_renamed.GLRootView gLRootView = this.aL_renamed;
        if (gLRootView != null) {
            gLRootView.setBackground(null);
        }
        com.oplus.camera.ui.preview.g_renamed.b_renamed bVar = this.ak_renamed;
        if (bVar != null) {
            bVar.ct_renamed();
        }
    }

    @Override // com.oplus.camera.ui.preview.h_renamed.c_renamed
    public void ac_renamed() {
        com.oplus.camera.ui.preview.g_renamed.b_renamed bVar = this.ak_renamed;
        if (bVar != null) {
            bVar.ek_renamed();
            if (!this.p_renamed) {
                this.ak_renamed.ee_renamed();
                this.ak_renamed.ef_renamed();
                if (com.oplus.camera.util.Util.t_renamed()) {
                    this.ak_renamed.eg_renamed();
                }
            }
            if (!this.ak_renamed.ed_renamed()) {
                com.oplus.camera.e_renamed.a_renamed("CameraPreviewUI", "onFirstFrameDraw, don't_renamed hide blur for some case");
                return;
            }
        }
        ad_renamed();
    }

    public void ad_renamed() {
        com.oplus.camera.e_renamed.a_renamed("CameraPreviewUI", "execHideBlurView");
        com.oplus.camera.e_renamed.a_renamed("execHideBlurView");
        if (!this.p_renamed && this.ap_renamed.indexOfChild(this.ao_renamed) >= 0) {
            if ((this.ak_renamed.cv_renamed() == 0 && !com.oplus.camera.g_renamed.a_renamed(this.X_renamed.getApplicationContext()).b_renamed()) || com.oplus.camera.g_renamed.a_renamed(this.X_renamed.getApplicationContext()).d_renamed()) {
                if (this.q_renamed) {
                    int i_renamed = 0;
                    if (this.ak_renamed.eD_renamed() && com.oplus.camera.util.Util.C_renamed()) {
                        i_renamed = 17;
                    }
                    this.br_renamed.postDelayed(new java.lang.Runnable() { // from class: com.oplus.camera.ui.preview.g_renamed.22
                        @Override // java.lang.Runnable
                        public void run() {
                            if (com.oplus.camera.ui.preview.g_renamed.this.p_renamed) {
                                return;
                            }
                            com.oplus.camera.ui.preview.g_renamed.this.F_renamed();
                            com.oplus.camera.ui.preview.g_renamed.this.q_renamed = false;
                        }
                    }, i_renamed);
                } else {
                    this.br_renamed.postAtFrontOfQueue(new java.lang.Runnable() { // from class: com.oplus.camera.ui.preview.g_renamed.23
                        @Override // java.lang.Runnable
                        public void run() {
                            com.oplus.camera.ui.preview.g_renamed.this.F_renamed();
                        }
                    });
                }
            } else {
                com.oplus.camera.g_renamed.a_renamed(this.X_renamed.getApplicationContext()).a_renamed(new java.lang.Runnable() { // from class: com.oplus.camera.ui.preview.g_renamed.24
                    @Override // java.lang.Runnable
                    public void run() {
                        com.oplus.camera.ui.preview.g_renamed.this.F_renamed();
                    }
                });
            }
        }
        com.oplus.camera.e_renamed.b_renamed("execHideBlurView");
    }

    public android.graphics.Rect[] ae_renamed() {
        com.oplus.camera.ui.preview.FaceView faceView = this.ac_renamed;
        if (faceView != null) {
            return faceView.getFaceRects();
        }
        return null;
    }

    public int af_renamed() {
        android.widget.RelativeLayout relativeLayout;
        com.oplus.camera.ui.preview.FaceView faceView = this.ac_renamed;
        if (faceView == null || (relativeLayout = this.au_renamed) == null) {
            return 0;
        }
        return relativeLayout.indexOfChild(faceView);
    }

    public void k_renamed(boolean z_renamed) {
        com.oplus.camera.ui.preview.h_renamed hVar = this.Z_renamed;
        if (hVar != null) {
            hVar.e_renamed(z_renamed);
        }
        com.oplus.camera.ui.preview.FaceView faceView = this.ac_renamed;
        if (faceView != null) {
            faceView.setRearMirrorEnable(z_renamed);
        }
        com.oplus.camera.ui.preview.ac_renamed acVar = this.ad_renamed;
        if (acVar != null) {
            acVar.setRearMirrorEnable(z_renamed);
        }
    }

    public void l_renamed(boolean z_renamed) {
        com.oplus.camera.ui.preview.h_renamed hVar = this.Z_renamed;
        if (hVar != null) {
            hVar.f_renamed(z_renamed);
        }
    }

    private void a_renamed(com.oplus.camera.ui.preview.x_renamed xVar) {
        if (this.bh_renamed.contains(xVar)) {
            return;
        }
        this.bh_renamed.add(xVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a_renamed(com.oplus.camera.gl_renamed.h_renamed hVar) {
        if (this.bh_renamed.isEmpty()) {
            return;
        }
        java.util.Iterator<com.oplus.camera.ui.preview.x_renamed> it = this.bh_renamed.iterator();
        while (it.hasNext()) {
            com.oplus.camera.ui.preview.x_renamed next = it.next();
            if (next != null) {
                next.a_renamed(hVar, this.j_renamed);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b_renamed(com.oplus.camera.gl_renamed.h_renamed hVar) {
        if (this.bh_renamed.isEmpty()) {
            return;
        }
        java.util.Iterator<com.oplus.camera.ui.preview.x_renamed> it = this.bh_renamed.iterator();
        while (it.hasNext()) {
            com.oplus.camera.ui.preview.x_renamed next = it.next();
            if (next != null) {
                next.b_renamed(hVar, this.j_renamed);
            }
        }
    }

    public void c_renamed(boolean z_renamed, boolean z2) throws android.content.res.Resources.NotFoundException {
        com.oplus.camera.e_renamed.b_renamed("CameraPreviewUI", "showMultiCameraTypeView, show: " + z_renamed + ", needAnimation: " + z2);
        this.aT_renamed = z_renamed;
        if (z_renamed) {
            if (this.aS_renamed == null) {
                aJ_renamed();
            }
            this.aS_renamed.setType(this.Y_renamed.getInt(com.oplus.camera.ui.CameraUIInterface.KEY_MULTI_CAMERA_TYPE_SELECTED, 0));
            if (z2) {
                m_renamed(true);
                return;
            }
            this.aS_renamed.a_renamed(this.ai_renamed, true);
            this.aS_renamed.setAlpha(1.0f);
            this.aS_renamed.setTranslationY(0.0f);
            this.aS_renamed.setTranslationX(0.0f);
            this.aS_renamed.setVisibility(0);
            return;
        }
        if (this.aS_renamed != null) {
            n_renamed(z2);
        }
    }

    protected void m_renamed(boolean z_renamed) {
        int i_renamed;
        java.lang.String str;
        com.oplus.camera.e_renamed.a_renamed("CameraPreviewUI", "showMultiTypeView, needAnim: " + z_renamed);
        android.animation.AnimatorSet animatorSet = this.aU_renamed;
        if (animatorSet != null && animatorSet.isStarted()) {
            this.aU_renamed.end();
        } else {
            if (this.aS_renamed.isShown()) {
                return;
            }
            android.animation.AnimatorSet animatorSet2 = this.aV_renamed;
            if (animatorSet2 != null && animatorSet2.isStarted()) {
                return;
            }
        }
        if (z_renamed) {
            boolean z2 = 1 == this.ak_renamed.aX_renamed();
            int iEi = this.ak_renamed.ei_renamed();
            this.aS_renamed.setAlpha(0.0f);
            if (z2) {
                i_renamed = 270 == iEi ? this.aW_renamed : -this.aW_renamed;
                this.aS_renamed.setTranslationX(-i_renamed);
                str = "translationX";
            } else {
                this.aS_renamed.setTranslationY(-this.aW_renamed);
                i_renamed = this.aW_renamed;
                str = "translationY";
            }
            this.aS_renamed.setVisibility(0);
            if (this.aV_renamed == null || com.oplus.camera.util.Util.u_renamed()) {
                this.aV_renamed = new android.animation.AnimatorSet();
                android.animation.ObjectAnimator objectAnimatorOfFloat = android.animation.ObjectAnimator.ofFloat(this.aS_renamed, "alpha", 0.0f, 1.0f);
                objectAnimatorOfFloat.setInterpolator(this.l_renamed);
                objectAnimatorOfFloat.setDuration(300L);
                android.animation.ObjectAnimator objectAnimatorOfFloat2 = android.animation.ObjectAnimator.ofFloat(this.aS_renamed, str, i_renamed, 0.0f);
                objectAnimatorOfFloat2.setInterpolator(this.m_renamed);
                objectAnimatorOfFloat2.setDuration(300L);
                this.aV_renamed.play(objectAnimatorOfFloat).with(objectAnimatorOfFloat2);
                this.aV_renamed.addListener(new android.animation.AnimatorListenerAdapter() { // from class: com.oplus.camera.ui.preview.g_renamed.25
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(android.animation.Animator animator) {
                        if (com.oplus.camera.ui.preview.g_renamed.this.aS_renamed != null) {
                            com.oplus.camera.ui.preview.g_renamed.this.aS_renamed.setAlpha(1.0f);
                            com.oplus.camera.ui.preview.g_renamed.this.aS_renamed.setTranslationY(0.0f);
                            com.oplus.camera.ui.preview.g_renamed.this.aS_renamed.setTranslationX(0.0f);
                            com.oplus.camera.ui.preview.g_renamed.this.aS_renamed.setVisibility(0);
                        }
                    }
                });
                this.aV_renamed.setStartDelay(150L);
            }
            this.aV_renamed.start();
            return;
        }
        this.aS_renamed.setVisibility(0);
    }

    protected void n_renamed(boolean z_renamed) {
        int i_renamed;
        java.lang.String str;
        com.oplus.camera.e_renamed.a_renamed("CameraPreviewUI", "hideMultiTypeView, needAnim: " + z_renamed);
        android.animation.AnimatorSet animatorSet = this.aV_renamed;
        if (animatorSet != null && animatorSet.isStarted()) {
            this.aV_renamed.cancel();
        } else {
            com.oplus.camera.ui.widget.a_renamed aVar = this.aS_renamed;
            if (aVar != null && !aVar.isShown()) {
                return;
            }
            android.animation.AnimatorSet animatorSet2 = this.aU_renamed;
            if (animatorSet2 != null && animatorSet2.isStarted()) {
                return;
            }
        }
        if (z_renamed) {
            if (this.aU_renamed == null || com.oplus.camera.util.Util.u_renamed()) {
                this.aU_renamed = new android.animation.AnimatorSet();
                android.animation.ObjectAnimator objectAnimatorOfFloat = android.animation.ObjectAnimator.ofFloat(this.aS_renamed, "alpha", 1.0f, 0.0f);
                objectAnimatorOfFloat.setInterpolator(this.l_renamed);
                objectAnimatorOfFloat.setDuration(300L);
                boolean z2 = 1 == this.ak_renamed.aX_renamed();
                int iEi = this.ak_renamed.ei_renamed();
                if (z2) {
                    i_renamed = 270 == iEi ? this.aW_renamed : -this.aW_renamed;
                    str = "translationX";
                } else {
                    i_renamed = this.aW_renamed;
                    str = "translationY";
                }
                android.animation.ObjectAnimator objectAnimatorOfFloat2 = android.animation.ObjectAnimator.ofFloat(this.aS_renamed, str, 0.0f, i_renamed);
                objectAnimatorOfFloat2.setInterpolator(this.m_renamed);
                objectAnimatorOfFloat2.setDuration(300L);
                this.aU_renamed.play(objectAnimatorOfFloat).with(objectAnimatorOfFloat2);
                this.aU_renamed.addListener(new android.animation.AnimatorListenerAdapter() { // from class: com.oplus.camera.ui.preview.g_renamed.26
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationStart(android.animation.Animator animator) {
                        if (com.oplus.camera.ui.preview.g_renamed.this.aS_renamed != null) {
                            com.oplus.camera.ui.preview.g_renamed.this.aS_renamed.setTranslationX(0.0f);
                            com.oplus.camera.ui.preview.g_renamed.this.aS_renamed.setTranslationY(0.0f);
                            com.oplus.camera.ui.preview.g_renamed.this.aS_renamed.setAlpha(1.0f);
                            com.oplus.camera.ui.preview.g_renamed.this.aS_renamed.setVisibility(0);
                            com.oplus.camera.ui.preview.g_renamed.this.aS_renamed.setClipToPadding(false);
                            com.oplus.camera.ui.preview.g_renamed.this.aS_renamed.setClipChildren(false);
                            com.oplus.camera.ui.preview.g_renamed.this.aS_renamed.setClipToOutline(false);
                        }
                    }

                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(android.animation.Animator animator) {
                        if (com.oplus.camera.ui.preview.g_renamed.this.aS_renamed != null) {
                            com.oplus.camera.ui.preview.g_renamed.this.aS_renamed.setVisibility(8);
                            com.oplus.camera.ui.preview.g_renamed.this.aS_renamed.setTranslationX(0.0f);
                            com.oplus.camera.ui.preview.g_renamed.this.aS_renamed.setTranslationY(0.0f);
                            com.oplus.camera.ui.preview.g_renamed.this.aS_renamed.setAlpha(0.0f);
                        }
                    }
                });
            }
            this.aU_renamed.start();
            return;
        }
        com.oplus.camera.ui.widget.a_renamed aVar2 = this.aS_renamed;
        if (aVar2 != null) {
            aVar2.setVisibility(8);
        }
    }

    private void aJ_renamed() throws android.content.res.Resources.NotFoundException {
        this.aW_renamed = this.X_renamed.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.face_beauty_menu_translate_y);
        this.aS_renamed = new com.oplus.camera.ui.widget.a_renamed(this.X_renamed, this.ak_renamed.aX_renamed());
        this.aS_renamed.setId(com.oplus.camera.R_renamed.id_renamed.multivideo_type_select_view);
        android.widget.RelativeLayout.LayoutParams layoutParamsD = this.ak_renamed.ej_renamed().d_renamed();
        this.aS_renamed.setClipChildren(false);
        this.aS_renamed.setClipToOutline(false);
        this.au_renamed.addView(this.aS_renamed, layoutParamsD);
        android.view.View.OnClickListener onClickListener = new android.view.View.OnClickListener() { // from class: com.oplus.camera.ui.preview.g_renamed.27
            @Override // android.view.View.OnClickListener
            public void onClick(android.view.View view) {
                if (view.isEnabled() && com.oplus.camera.ui.preview.g_renamed.this.ak_renamed != null && com.oplus.camera.ui.preview.g_renamed.this.ak_renamed.ec_renamed() && !com.oplus.camera.ui.preview.g_renamed.this.ak_renamed.dr_renamed() && com.oplus.camera.ui.preview.g_renamed.this.x_renamed() != null && com.oplus.camera.ui.preview.g_renamed.this.x_renamed().u_renamed() && com.oplus.camera.ui.preview.g_renamed.this.x_renamed().v_renamed()) {
                    com.oplus.camera.ui.preview.g_renamed.this.aS_renamed.a_renamed(view);
                }
            }
        };
        this.aS_renamed.a_renamed(this.ai_renamed, false);
        this.aS_renamed.findViewById(com.oplus.camera.R_renamed.id_renamed.view_half_half).setOnClickListener(onClickListener);
        this.aS_renamed.findViewById(com.oplus.camera.R_renamed.id_renamed.view_pip_cir).setOnClickListener(onClickListener);
        this.aS_renamed.findViewById(com.oplus.camera.R_renamed.id_renamed.view_pip_rec).setOnClickListener(onClickListener);
        this.aS_renamed.setOnTypeChangeListener(new com.oplus.camera.ui.widget.a_renamed.MultiCameraTypeSelectLayout_2() { // from class: com.oplus.camera.ui.preview.-$$Lambda$g_renamed$pP_s_NNnin5PO1bxO11P5IVfFV4
            @Override // com.oplus.camera.ui.widget.a_renamed.MultiCameraTypeSelectLayout_2
            public final void onTypeChanged(int i_renamed) {
                this.f_renamed$0.j_renamed(i_renamed);
            }
        });
        this.aS_renamed.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void j_renamed(int i_renamed) {
        com.oplus.camera.ui.preview.g_renamed.b_renamed bVar = this.ak_renamed;
        if (bVar != null) {
            bVar.S_renamed(i_renamed);
        }
    }

    public boolean ag_renamed() {
        com.oplus.camera.ui.widget.a_renamed aVar = this.aS_renamed;
        return aVar != null && aVar.getVisibility() == 0;
    }

    public boolean ah_renamed() {
        return this.aT_renamed;
    }

    public boolean ai_renamed() {
        android.animation.AnimatorSet animatorSet;
        android.animation.AnimatorSet animatorSet2 = this.aV_renamed;
        return (animatorSet2 != null && animatorSet2.isStarted()) || ((animatorSet = this.aU_renamed) != null && animatorSet.isStarted());
    }

    public void o_renamed(boolean z_renamed) {
        com.oplus.camera.ui.widget.a_renamed aVar = this.aS_renamed;
        if (aVar != null) {
            aVar.setEnabled(z_renamed);
        }
    }

    /* compiled from: CameraPreviewUI.java */
    public class d_renamed extends android.view.animation.AccelerateInterpolator {
        public d_renamed() {
        }

        @Override // android.view.animation.AccelerateInterpolator, android.animation.TimeInterpolator
        public float getInterpolation(float f_renamed) {
            if (java.lang.Math.abs(f_renamed - 1.0f) <= 1.0E-6d && !com.oplus.camera.ui.preview.g_renamed.this.bf_renamed) {
                com.oplus.camera.ui.preview.g_renamed.this.at_renamed();
            }
            return ((float) (java.lang.Math.cos((f_renamed + 1.0f) * 3.141592653589793d) / 2.0d)) + 0.5f;
        }
    }

    public void g_renamed(int i_renamed) {
        com.oplus.camera.e_renamed.b_renamed("CameraPreviewUI", "setSlowVideoMotionDetectViewVisibility: " + i_renamed);
        com.oplus.camera.ui.preview.IntelligentDragView intelligentDragView = this.af_renamed;
        if (intelligentDragView != null) {
            if (8 == intelligentDragView.getVisibility()) {
                android.widget.RelativeLayout.LayoutParams layoutParams = (android.widget.RelativeLayout.LayoutParams) this.af_renamed.getLayoutParams();
                layoutParams.addRule(14);
                int screenHeight = (com.oplus.camera.util.Util.getScreenHeight() - com.oplus.camera.util.Util.getSettingMenuPanelHeight()) - com.oplus.camera.util.Util.O_renamed();
                layoutParams.setMargins(0, (int) ((screenHeight - this.X_renamed.getResources().getDimension(com.oplus.camera.R_renamed.dimen.video_intelligent_high_frame_dectect_height)) / 2.0f), 0, 0);
                this.af_renamed.setLayoutParams(layoutParams);
                this.af_renamed.setBottomRestrict(this.ap_renamed.getHeight() - screenHeight);
                this.af_renamed.b_renamed();
            }
            this.af_renamed.setVisibility(i_renamed);
        }
    }

    public void p_renamed(boolean z_renamed) {
        com.oplus.camera.e_renamed.b_renamed("CameraPreviewUI", "enableSlowVideoMotionDetectView: " + z_renamed);
        com.oplus.camera.ui.preview.IntelligentDragView intelligentDragView = this.af_renamed;
        if (intelligentDragView != null) {
            intelligentDragView.setEnabled(z_renamed);
        }
    }

    public android.graphics.RectF h_renamed(int i_renamed) {
        com.oplus.camera.ui.preview.IntelligentDragView intelligentDragView = this.af_renamed;
        if (intelligentDragView != null) {
            return intelligentDragView.a_renamed(w_renamed(), i_renamed);
        }
        return null;
    }

    public void aj_renamed() {
        com.oplus.camera.ui.preview.FaceView faceView = this.ac_renamed;
        if (faceView != null) {
            faceView.g_renamed();
        }
    }

    @Override // com.oplus.camera.ui.preview.k_renamed.b_renamed
    public void ak_renamed() {
        com.oplus.camera.ui.preview.FaceView faceView = this.ac_renamed;
        if (faceView != null) {
            faceView.b_renamed();
        }
    }

    @Override // com.oplus.camera.ui.preview.k_renamed.b_renamed
    public void al_renamed() {
        if (this.Y_renamed != null) {
            com.oplus.camera.e_renamed.f_renamed("CameraPreviewUI", "endFacePointAnimation");
            this.Y_renamed.edit().putInt(com.oplus.camera.ui.CameraUIInterface.KEY_CAMERA_PID_HISTORY, android.os.Process.myPid()).putInt(com.oplus.camera.ui.CameraUIInterface.KEY_SUPPORT_FRONT_FACE_POINT_ANIMATION, com.oplus.camera.util.Util.d_renamed(java.lang.System.currentTimeMillis())).apply();
        }
    }

    @Override // com.oplus.camera.ui.preview.k_renamed.b_renamed
    public boolean am_renamed() {
        com.oplus.camera.ui.preview.g_renamed.b_renamed bVar = this.ak_renamed;
        return bVar != null && bVar.j_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_SUPPORT_FRONT_FACE_POINT_ANIMATION) && this.Y_renamed.getBoolean("pref_camera_statement_key", false);
    }

    public void a_renamed(com.oplus.camera.ui.preview.k_renamed.b_renamed bVar) {
        com.oplus.camera.ui.preview.FaceView faceView = this.ac_renamed;
        if (faceView != null) {
            faceView.setFacePointAnimationListener(bVar);
        }
    }

    public void an_renamed() {
        if (this.ba_renamed == null) {
            int i_renamed = this.Y_renamed.getInt(com.oplus.camera.ui.CameraUIInterface.KEY_DOUBLE_EXPOSURE_EFFECT_TYPE, 5);
            this.ba_renamed = new androidx.recyclerview.widget.RecyclerView(this.X_renamed);
            android.widget.RelativeLayout.LayoutParams layoutParams = new android.widget.RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(12);
            layoutParams.addRule(14);
            layoutParams.setMargins(0, 0, 0, (int) this.X_renamed.getResources().getDimension(com.oplus.camera.R_renamed.dimen.effect_menu_margin_bottom_not_zoom));
            this.ba_renamed.setVisibility(4);
            this.ba_renamed.setClipChildren(false);
            this.au_renamed.addView(this.ba_renamed, layoutParams);
            final float dimensionPixelSize = this.X_renamed.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.effect_menu_margin);
            this.ba_renamed.setLayoutManager(new androidx.recyclerview.widget.LinearLayoutManager(this.X_renamed, 0, false));
            this.ba_renamed.addItemDecoration(new androidx.recyclerview.widget.RecyclerView.h_renamed() { // from class: com.oplus.camera.ui.preview.g_renamed.28
                @Override // androidx.recyclerview.widget.RecyclerView.h_renamed
                public void getItemOffsets(android.graphics.Rect rect, android.view.View view, androidx.recyclerview.widget.RecyclerView recyclerView, androidx.recyclerview.widget.RecyclerView.t_renamed tVar) {
                    androidx.recyclerview.widget.LinearLayoutManager linearLayoutManager = (androidx.recyclerview.widget.LinearLayoutManager) recyclerView.getLayoutManager();
                    super.getItemOffsets(rect, view, recyclerView, tVar);
                    if (linearLayoutManager != null) {
                        if (linearLayoutManager.getPosition(view) == 0) {
                            rect.right = (int) (dimensionPixelSize * 0.5f);
                        } else {
                            rect.left = (int) (dimensionPixelSize * 0.5f);
                        }
                    }
                }
            });
            java.util.ArrayList arrayList = new java.util.ArrayList();
            arrayList.add(new com.oplus.camera.doubleexposure.f_renamed(5, com.oplus.camera.R_renamed.drawable.double_exposure_composition, this.X_renamed.getString(com.oplus.camera.R_renamed.string.camera_double_exposure_type_composition), 5 == i_renamed));
            arrayList.add(new com.oplus.camera.doubleexposure.f_renamed(4, com.oplus.camera.R_renamed.drawable.double_exposure_sketch, this.X_renamed.getString(com.oplus.camera.R_renamed.string.camera_double_exposure_type_sketch), 4 == i_renamed));
            com.oplus.camera.doubleexposure.e_renamed eVar = new com.oplus.camera.doubleexposure.e_renamed(this.X_renamed, arrayList);
            this.bb_renamed = new com.oplus.camera.doubleexposure.e_renamed.b_renamed() { // from class: com.oplus.camera.ui.preview.g_renamed.29
                @Override // com.oplus.camera.doubleexposure.e_renamed.b_renamed
                public void a_renamed(com.oplus.camera.doubleexposure.f_renamed fVar) {
                    if (com.oplus.camera.ui.preview.g_renamed.this.ak_renamed != null) {
                        com.oplus.camera.ui.preview.g_renamed.this.ak_renamed.a_renamed(fVar);
                        if (fVar != null) {
                            com.oplus.camera.ui.preview.g_renamed.this.Y_renamed.edit().putInt(com.oplus.camera.ui.CameraUIInterface.KEY_DOUBLE_EXPOSURE_EFFECT_TYPE, fVar.a_renamed()).apply();
                        }
                    }
                }
            };
            eVar.a_renamed(this.bb_renamed);
            this.ba_renamed.setAdapter(eVar);
        }
    }

    public void ao_renamed() {
        androidx.recyclerview.widget.RecyclerView recyclerView = this.ba_renamed;
        if (recyclerView != null) {
            com.oplus.camera.util.Util.a_renamed(recyclerView, 4, (android.view.animation.Animation.AnimationListener) null, 300L);
        }
    }

    public androidx.recyclerview.widget.RecyclerView ap_renamed() {
        if (this.ba_renamed == null) {
            an_renamed();
        }
        return this.ba_renamed;
    }

    public void a_renamed(android.view.View view, android.view.View view2, boolean z_renamed) throws android.content.res.Resources.NotFoundException {
        if (view != null && view2 != null && (!z_renamed || this.p_renamed)) {
            view.setVisibility(0);
            view2.setVisibility(4);
            return;
        }
        if (view2 == null) {
            if (view != null) {
                com.oplus.camera.util.Util.a_renamed(view, 0, (android.view.animation.Animation.AnimationListener) null, 300L);
                return;
            }
            return;
        }
        android.view.animation.Interpolator interpolatorLoadInterpolator = android.view.animation.AnimationUtils.loadInterpolator(view2.getContext(), com.oplus.camera.R_renamed.anim.face_point_scale_interpolator2);
        if (view2.getVisibility() == 0) {
            com.oplus.camera.util.Util.a_renamed(view2, 4, new com.oplus.camera.b_renamed.b_renamed(true, view, view2), 180L, 0L, interpolatorLoadInterpolator);
        } else if (view != null) {
            com.oplus.camera.util.Util.a_renamed(view, 0, (android.view.animation.Animation.AnimationListener) null, 300L);
        }
    }

    /* compiled from: CameraPreviewUI.java */
    public static class e_renamed {

        /* renamed from: a_renamed, reason: collision with root package name */
        public int f7071a;

        /* renamed from: b_renamed, reason: collision with root package name */
        public int f7072b;

        public e_renamed(int i_renamed, int i2) {
            this.f7071a = 0;
            this.f7072b = 0;
            this.f7071a = i_renamed;
            this.f7072b = i2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aK_renamed() {
        synchronized (this.o_renamed) {
            float fUptimeMillis = android.os.SystemClock.uptimeMillis() - this.U_renamed;
            float interpolation = this.i_renamed.getInterpolation(fUptimeMillis / this.W_renamed);
            if (this.L_renamed != 0) {
                if (fUptimeMillis < this.W_renamed) {
                    this.I_renamed = this.aG_renamed.getHeight() + ((int) (this.L_renamed * interpolation));
                } else {
                    this.I_renamed = this.aF_renamed.getHeight();
                    this.L_renamed = 0;
                }
            }
            if (this.aD_renamed != 0) {
                if (fUptimeMillis < this.W_renamed) {
                    this.B_renamed = this.C_renamed + ((int) (this.aD_renamed * interpolation));
                } else {
                    this.B_renamed = this.C_renamed + this.aD_renamed;
                    this.aD_renamed = 0;
                    com.oplus.camera.e_renamed.a_renamed("CameraPreviewUI", "calcScreenModeChangeAnimOffset, translate x_renamed end, mOffsetX: " + this.B_renamed);
                }
            }
            if (this.aE_renamed != 0) {
                if (fUptimeMillis < this.W_renamed) {
                    this.E_renamed = this.F_renamed + ((int) (this.aE_renamed * interpolation));
                } else {
                    this.E_renamed = this.F_renamed + this.aE_renamed;
                    this.aE_renamed = 0;
                    com.oplus.camera.e_renamed.a_renamed("CameraPreviewUI", "calcScreenModeChangeAnimOffset, translate y_renamed end, mOffsetY: " + this.E_renamed);
                }
            }
            if (this.K_renamed != 0) {
                if (fUptimeMillis < this.W_renamed) {
                    this.J_renamed = this.aG_renamed.getWidth() + ((int) (this.K_renamed * interpolation));
                } else {
                    this.J_renamed = this.aF_renamed.getWidth();
                    this.K_renamed = 0;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aL_renamed() {
        if (this.ak_renamed == null) {
            return;
        }
        if (this.bm_renamed != au_renamed() || this.bn_renamed != av_renamed() || this.bo_renamed != aw_renamed() || this.bp_renamed != ax_renamed()) {
            this.bm_renamed = au_renamed();
            this.bn_renamed = av_renamed();
            this.bo_renamed = aw_renamed();
            this.bp_renamed = ax_renamed();
            this.ak_renamed.a_renamed(this.bm_renamed, this.bn_renamed, this.bo_renamed, this.bp_renamed);
        }
        com.oplus.camera.screen.b_renamed.a_renamed aVarEj = this.ak_renamed.ej_renamed();
        java.lang.String strH = aVarEj.h_renamed();
        android.util.Size sizeI = com.oplus.camera.util.Util.I_renamed();
        if (sizeI.getHeight() == 0 || sizeI.getWidth() == 0) {
            return;
        }
        synchronized (this.o_renamed) {
            if (this.A_renamed) {
                return;
            }
            if (!this.bl_renamed.equals(sizeI) || (!this.v_renamed && !this.aJ_renamed && this.K_renamed == 0 && this.L_renamed == 0 && this.aD_renamed == 0 && this.aE_renamed == 0 && !strH.equals(this.bk_renamed))) {
                android.graphics.Rect rectB = aVarEj.b_renamed(sizeI.getHeight(), sizeI.getWidth());
                com.oplus.camera.e_renamed.b_renamed("CameraPreviewUI", "checkPreviewRegion, screenModeName: " + strH + ", mLastScreenModeName: " + this.bk_renamed + ", previewSize: " + sizeI + ", previewRect: " + rectB);
                if (rectB.width() == 0) {
                    return;
                }
                if (rectB.left != this.B_renamed || rectB.top != this.E_renamed || rectB.width() != this.I_renamed || rectB.height() != this.J_renamed) {
                    if (this.J_renamed == 0 || this.I_renamed == 0) {
                        this.B_renamed = rectB.left;
                        this.E_renamed = rectB.top;
                        this.I_renamed = rectB.width();
                        this.J_renamed = rectB.height();
                        this.bk_renamed = strH;
                        this.bl_renamed = sizeI;
                        com.oplus.camera.e_renamed.f_renamed("CameraPreviewUI", "checkPreviewRegion, mOffsetX: " + this.B_renamed + ", mOffsetY: " + this.E_renamed + ", mWidth: " + this.I_renamed + ", mHeight: " + this.J_renamed);
                    } else if (!this.p_renamed) {
                        a_renamed(aVarEj, sizeI);
                    }
                } else if (!this.aJ_renamed) {
                    this.bk_renamed = this.ak_renamed.ej_renamed().h_renamed();
                    this.bl_renamed = sizeI;
                }
            }
        }
    }

    public void q_renamed(boolean z_renamed) {
        com.oplus.camera.e_renamed.b_renamed("CameraPreviewUI", "startShowPreviewImageAnimation, isChanging: " + z_renamed);
        synchronized (this.o_renamed) {
            this.A_renamed = z_renamed;
        }
    }

    public void a_renamed(com.oplus.camera.screen.b_renamed.a_renamed aVar, com.oplus.camera.screen.b_renamed.a_renamed aVar2) {
        if (!com.oplus.camera.util.Util.u_renamed() || this.j_renamed) {
            return;
        }
        O_renamed().setRenderMode(1);
        this.br_renamed.postDelayed(new java.lang.Runnable() { // from class: com.oplus.camera.ui.preview.g_renamed.31
            @Override // java.lang.Runnable
            public void run() {
                synchronized (com.oplus.camera.ui.preview.g_renamed.this.o_renamed) {
                    if (!com.oplus.camera.ui.preview.g_renamed.this.aJ_renamed && com.oplus.camera.ui.preview.g_renamed.this.aL_renamed != null) {
                        com.oplus.camera.ui.preview.g_renamed.this.aL_renamed.setRenderMode(0);
                    }
                }
            }
        }, 500L);
    }

    public void a_renamed(java.lang.Runnable runnable) {
        this.bq_renamed = runnable;
    }
}

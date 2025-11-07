package com.oplus.camera.ui.beauty3d;

/* compiled from: Beauty3DGuideScanUI.java */
/* loaded from: classes2.dex */
public class f_renamed implements android.view.View.OnClickListener, android.view.View.OnTouchListener {

    /* renamed from: a_renamed, reason: collision with root package name */
    private boolean f5930a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private boolean f5931b;
    private android.app.Activity e_renamed;
    private android.view.ViewGroup f_renamed;
    private android.view.ViewGroup g_renamed;

    /* renamed from: c_renamed, reason: collision with root package name */
    private boolean f5932c = false;
    private boolean d_renamed = false;
    private android.view.View h_renamed = null;
    private boolean i_renamed = false;
    private android.view.View j_renamed = null;
    private boolean k_renamed = false;
    private boolean l_renamed = true;
    private android.view.View m_renamed = null;
    private android.view.View n_renamed = null;
    private android.widget.ImageView o_renamed = null;
    private android.widget.ImageView p_renamed = null;
    private android.widget.ImageView q_renamed = null;
    private android.widget.TextView r_renamed = null;
    private com.oplus.camera.ui.beauty3d.h_renamed s_renamed = null;
    private com.oplus.camera.ui.beauty3d.h_renamed t_renamed = null;
    private com.oplus.camera.ui.beauty3d.e_renamed u_renamed = null;
    private android.graphics.Point v_renamed = null;
    private android.widget.TextView w_renamed = null;
    private android.widget.Button x_renamed = null;
    private com.oplus.camera.ui.beauty3d.OplusCircleProgressView y_renamed = null;
    private android.widget.ImageView z_renamed = null;
    private android.animation.ObjectAnimator A_renamed = null;
    private android.animation.ObjectAnimator B_renamed = null;
    private android.animation.ObjectAnimator C_renamed = null;
    private android.animation.ObjectAnimator D_renamed = null;
    private android.animation.ObjectAnimator E_renamed = null;
    private android.animation.ObjectAnimator F_renamed = null;
    private android.animation.ObjectAnimator G_renamed = null;
    private android.animation.AnimatorSet H_renamed = null;
    private boolean I_renamed = false;
    private android.animation.TimeInterpolator J_renamed = new android.view.animation.PathInterpolator(0.42f, 0.0f, 0.58f, 1.0f);
    private android.animation.TimeInterpolator K_renamed = new android.view.animation.PathInterpolator(0.0f, 0.0f, 0.1f, 1.0f);
    private android.animation.TimeInterpolator L_renamed = new android.view.animation.PathInterpolator(0.3f, 0.0f, 0.1f, 1.0f);
    private int[] M_renamed = {com.oplus.camera.R_renamed.drawable.beauty3d_scan_00, com.oplus.camera.R_renamed.drawable.beauty3d_scan_01, com.oplus.camera.R_renamed.drawable.beauty3d_scan_02, com.oplus.camera.R_renamed.drawable.beauty3d_scan_03, com.oplus.camera.R_renamed.drawable.beauty3d_scan_04, com.oplus.camera.R_renamed.drawable.beauty3d_scan_05, com.oplus.camera.R_renamed.drawable.beauty3d_scan_06, com.oplus.camera.R_renamed.drawable.beauty3d_scan_07, com.oplus.camera.R_renamed.drawable.beauty3d_scan_08, com.oplus.camera.R_renamed.drawable.beauty3d_scan_09, com.oplus.camera.R_renamed.drawable.beauty3d_scan_10, com.oplus.camera.R_renamed.drawable.beauty3d_scan_11, com.oplus.camera.R_renamed.drawable.beauty3d_scan_12, com.oplus.camera.R_renamed.drawable.beauty3d_scan_13, com.oplus.camera.R_renamed.drawable.beauty3d_scan_14, com.oplus.camera.R_renamed.drawable.beauty3d_scan_15, com.oplus.camera.R_renamed.drawable.beauty3d_scan_16, com.oplus.camera.R_renamed.drawable.beauty3d_scan_17, com.oplus.camera.R_renamed.drawable.beauty3d_scan_18, com.oplus.camera.R_renamed.drawable.beauty3d_scan_19, com.oplus.camera.R_renamed.drawable.beauty3d_scan_20, com.oplus.camera.R_renamed.drawable.beauty3d_scan_21, com.oplus.camera.R_renamed.drawable.beauty3d_scan_22, com.oplus.camera.R_renamed.drawable.beauty3d_scan_23, com.oplus.camera.R_renamed.drawable.beauty3d_scan_24, com.oplus.camera.R_renamed.drawable.beauty3d_scan_25, com.oplus.camera.R_renamed.drawable.beauty3d_scan_26, com.oplus.camera.R_renamed.drawable.beauty3d_scan_27, com.oplus.camera.R_renamed.drawable.beauty3d_scan_28, com.oplus.camera.R_renamed.drawable.beauty3d_scan_29};
    private int[] N_renamed = {com.oplus.camera.R_renamed.drawable.beauty3d_scan_loading_00, com.oplus.camera.R_renamed.drawable.beauty3d_scan_loading_01, com.oplus.camera.R_renamed.drawable.beauty3d_scan_loading_02, com.oplus.camera.R_renamed.drawable.beauty3d_scan_loading_03, com.oplus.camera.R_renamed.drawable.beauty3d_scan_loading_04, com.oplus.camera.R_renamed.drawable.beauty3d_scan_loading_05, com.oplus.camera.R_renamed.drawable.beauty3d_scan_loading_06, com.oplus.camera.R_renamed.drawable.beauty3d_scan_loading_07, com.oplus.camera.R_renamed.drawable.beauty3d_scan_loading_08, com.oplus.camera.R_renamed.drawable.beauty3d_scan_loading_09, com.oplus.camera.R_renamed.drawable.beauty3d_scan_loading_10, com.oplus.camera.R_renamed.drawable.beauty3d_scan_loading_11, com.oplus.camera.R_renamed.drawable.beauty3d_scan_loading_12, com.oplus.camera.R_renamed.drawable.beauty3d_scan_loading_13, com.oplus.camera.R_renamed.drawable.beauty3d_scan_loading_14, com.oplus.camera.R_renamed.drawable.beauty3d_scan_loading_15, com.oplus.camera.R_renamed.drawable.beauty3d_scan_loading_16, com.oplus.camera.R_renamed.drawable.beauty3d_scan_loading_17, com.oplus.camera.R_renamed.drawable.beauty3d_scan_loading_18, com.oplus.camera.R_renamed.drawable.beauty3d_scan_loading_19, com.oplus.camera.R_renamed.drawable.beauty3d_scan_loading_20, com.oplus.camera.R_renamed.drawable.beauty3d_scan_loading_21, com.oplus.camera.R_renamed.drawable.beauty3d_scan_loading_22, com.oplus.camera.R_renamed.drawable.beauty3d_scan_loading_23};
    private android.os.Handler O_renamed = new android.os.Handler() { // from class: com.oplus.camera.ui.beauty3d.f_renamed.1
        @Override // android.os.Handler
        public void handleMessage(android.os.Message message) throws android.content.res.Resources.NotFoundException {
            int i_renamed = message.what;
            if (i_renamed != 1) {
                if (i_renamed == 2 && com.oplus.camera.ui.beauty3d.f_renamed.this.y_renamed != null) {
                    com.oplus.camera.ui.beauty3d.f_renamed.this.y_renamed.a_renamed(((java.lang.Integer) message.obj).intValue());
                    return;
                }
                return;
            }
            java.lang.Integer num = (java.lang.Integer) message.obj;
            com.oplus.camera.e_renamed.a_renamed("Beauty3DGuideScanUI", "handleMessage, mbNeedUpdate: " + com.oplus.camera.ui.beauty3d.f_renamed.this.l_renamed);
            if (com.oplus.camera.ui.beauty3d.f_renamed.this.r_renamed == null || !com.oplus.camera.ui.beauty3d.f_renamed.this.l_renamed) {
                return;
            }
            java.lang.String string = com.oplus.camera.ui.beauty3d.f_renamed.this.e_renamed.getResources().getString(num.intValue());
            com.oplus.camera.ui.beauty3d.f_renamed.this.c_renamed(num.intValue());
            if (num.intValue() == com.oplus.camera.R_renamed.string.beauty3d_wait_scan_complete) {
                com.oplus.camera.ui.beauty3d.f_renamed.this.d_renamed(num.intValue());
                return;
            }
            com.oplus.camera.ui.beauty3d.f_renamed.this.a_renamed(string);
            com.oplus.camera.ui.beauty3d.f_renamed.this.l_renamed = false;
            postDelayed(new java.lang.Runnable() { // from class: com.oplus.camera.ui.beauty3d.f_renamed.1.1
                @Override // java.lang.Runnable
                public void run() {
                    com.oplus.camera.ui.beauty3d.f_renamed.this.l_renamed = true;
                    com.oplus.camera.ui.beauty3d.f_renamed.this.r_renamed.setText("");
                }
            }, com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS);
        }
    };

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(android.view.View view, android.view.MotionEvent motionEvent) {
        return true;
    }

    public f_renamed(android.app.Activity activity, android.view.ViewGroup viewGroup, android.view.ViewGroup viewGroup2) {
        this.f5930a = false;
        this.f5931b = false;
        this.e_renamed = null;
        this.f_renamed = null;
        this.g_renamed = null;
        this.e_renamed = activity;
        this.f_renamed = viewGroup;
        this.g_renamed = viewGroup2;
        this.f5930a = false;
        this.f5931b = false;
    }

    public void a_renamed(com.oplus.camera.ui.beauty3d.e_renamed eVar) {
        this.u_renamed = eVar;
    }

    public boolean a_renamed() {
        return this.f5930a;
    }

    public boolean b_renamed() {
        android.view.View view;
        return this.f5931b && (view = this.n_renamed) != null && view.getVisibility() == 0;
    }

    public void a_renamed(int i_renamed, boolean z_renamed, int i2, int i3) {
        if (this.e_renamed == null || this.f_renamed == null) {
            return;
        }
        i_renamed();
        com.oplus.camera.e_renamed.a_renamed("Beauty3DGuideScanUI", "showGuideView, mbGuideAdd: " + this.f5930a);
        if (this.f5930a) {
            return;
        }
        ((android.widget.Button) this.m_renamed.findViewById(com.oplus.camera.R_renamed.id_renamed.start_face_scan)).setOnClickListener(this);
        android.widget.TextView textView = (android.widget.TextView) this.m_renamed.findViewById(com.oplus.camera.R_renamed.id_renamed.skip);
        textView.setOnClickListener(this);
        this.g_renamed.addView(this.m_renamed, a_renamed(i_renamed, z_renamed, textView, false, i2, i3));
        this.f5930a = true;
    }

    private android.widget.RelativeLayout.LayoutParams a_renamed(int i_renamed, boolean z_renamed, android.widget.TextView textView, boolean z2, int i2, int i3) {
        android.view.View viewFindViewById = this.m_renamed.findViewById(com.oplus.camera.R_renamed.id_renamed.guide_background_top);
        android.view.View viewFindViewById2 = this.m_renamed.findViewById(com.oplus.camera.R_renamed.id_renamed.guide_background_bottom);
        viewFindViewById.setVisibility(0);
        viewFindViewById2.setVisibility(0);
        android.widget.TextView textView2 = (android.widget.TextView) this.m_renamed.findViewById(com.oplus.camera.R_renamed.id_renamed.beauty3d_face);
        android.widget.RelativeLayout.LayoutParams layoutParams = new android.widget.RelativeLayout.LayoutParams(-1, -1);
        if (i_renamed == 2 && !z_renamed) {
            a_renamed(textView2, textView, layoutParams, i2, i3);
        } else if ((i_renamed == 0 && !z_renamed) || z_renamed) {
            if (z2) {
                a_renamed(textView2, textView);
            }
            layoutParams.addRule(12);
            layoutParams.addRule(10);
            layoutParams.bottomMargin = i2;
            layoutParams.topMargin = i3;
        }
        return layoutParams;
    }

    private void a_renamed(android.widget.TextView textView, android.widget.TextView textView2, android.widget.RelativeLayout.LayoutParams layoutParams, int i_renamed, int i2) {
        android.widget.RelativeLayout.LayoutParams layoutParams2 = (android.widget.RelativeLayout.LayoutParams) textView.getLayoutParams();
        layoutParams2.topMargin = (int) this.e_renamed.getResources().getDimension(com.oplus.camera.R_renamed.dimen.beauty3d_guide_margin_top_1_1);
        textView.setLayoutParams(layoutParams2);
        android.widget.RelativeLayout.LayoutParams layoutParams3 = (android.widget.RelativeLayout.LayoutParams) textView2.getLayoutParams();
        layoutParams3.bottomMargin = (int) this.e_renamed.getResources().getDimension(com.oplus.camera.R_renamed.dimen.beauty3d_guide_margin_bottom_1_1);
        textView2.setLayoutParams(layoutParams3);
        layoutParams.addRule(12);
        layoutParams.addRule(10);
        layoutParams.bottomMargin = i_renamed;
        layoutParams.topMargin = i2;
    }

    public void a_renamed(int i_renamed) {
        if (i_renamed == 0) {
            android.view.View view = this.m_renamed;
            if (view == null || !this.f5930a) {
                return;
            }
            this.g_renamed.removeView(view);
            com.oplus.camera.e_renamed.a_renamed("Beauty3DGuideScanUI", "onViewDismiss, mRootView.removeGuideView.");
            this.m_renamed = null;
            this.f5930a = false;
            com.oplus.camera.ui.beauty3d.e_renamed eVar = this.u_renamed;
            if (eVar != null) {
                eVar.a_renamed();
                return;
            }
            return;
        }
        if (1 == i_renamed) {
            android.view.View view2 = this.n_renamed;
            if (view2 != null && this.f5931b) {
                this.f_renamed.removeView(view2);
                com.oplus.camera.e_renamed.a_renamed("Beauty3DGuideScanUI", "onViewDismiss, mRootPreviewView.removeScanView.");
                this.n_renamed = null;
                this.f5931b = false;
            }
            android.view.View view3 = this.h_renamed;
            if (view3 != null && this.i_renamed) {
                this.g_renamed.removeView(view3);
                this.i_renamed = false;
                this.h_renamed = null;
            }
            android.view.View view4 = this.j_renamed;
            if (view4 != null && this.k_renamed) {
                this.g_renamed.removeView(view4);
                this.k_renamed = false;
                this.j_renamed = null;
            }
            p_renamed();
        }
    }

    public void c_renamed() {
        com.oplus.camera.e_renamed.a_renamed("Beauty3DGuideScanUI", "onScanViewHide");
        f_renamed();
        g_renamed();
        com.oplus.camera.ui.beauty3d.OplusCircleProgressView oplusCircleProgressView = this.y_renamed;
        if (oplusCircleProgressView != null) {
            oplusCircleProgressView.setVisibility(0);
        }
        android.animation.ObjectAnimator objectAnimator = this.G_renamed;
        if (objectAnimator != null && objectAnimator.isRunning()) {
            this.G_renamed.cancel();
        }
        if (this.z_renamed != null) {
            com.oplus.camera.e_renamed.a_renamed("Beauty3DGuideScanUI", "onScanViewHide, reset scanCircle");
            this.z_renamed.setScaleX(1.0f);
            this.z_renamed.setScaleY(1.0f);
        }
        android.view.View view = this.n_renamed;
        if (view != null) {
            view.setVisibility(8);
            ((android.widget.ImageView) this.n_renamed.findViewById(com.oplus.camera.R_renamed.id_renamed.scan_foreground_middle)).setImageResource(com.oplus.camera.R_renamed.drawable.beauty3d_scan_foreground);
        }
    }

    private void i_renamed() {
        if (this.m_renamed == null) {
            this.m_renamed = this.e_renamed.getLayoutInflater().inflate(com.oplus.camera.R_renamed.layout.beauty3d_guide, (android.view.ViewGroup) null, false);
        }
        this.m_renamed.setOnTouchListener(this);
    }

    private void j_renamed() {
        if (this.n_renamed == null) {
            this.n_renamed = this.e_renamed.getLayoutInflater().inflate(com.oplus.camera.R_renamed.layout.beauty3d_scan, (android.view.ViewGroup) null, false);
        }
        this.n_renamed.setOnTouchListener(this);
        this.n_renamed.setAlpha(0.0f);
        this.r_renamed = (android.widget.TextView) this.n_renamed.findViewById(com.oplus.camera.R_renamed.id_renamed.hint);
        this.o_renamed = (android.widget.ImageView) this.n_renamed.findViewById(com.oplus.camera.R_renamed.id_renamed.scan_left_arrow);
        this.p_renamed = (android.widget.ImageView) this.n_renamed.findViewById(com.oplus.camera.R_renamed.id_renamed.scan_right_arrow);
        this.q_renamed = (android.widget.ImageView) this.n_renamed.findViewById(com.oplus.camera.R_renamed.id_renamed.scan_up_arrow);
    }

    public void d_renamed() {
        a_renamed(0);
        a_renamed(1);
        this.e_renamed = null;
        this.m_renamed = null;
        this.n_renamed = null;
        this.f5930a = false;
        this.f5931b = false;
        this.f5932c = false;
        this.u_renamed = null;
    }

    private void k_renamed() {
        this.A_renamed = android.animation.ObjectAnimator.ofFloat(this.n_renamed, "alpha", 0.0f, 1.0f);
        this.A_renamed.setInterpolator(this.J_renamed);
        this.A_renamed.setDuration(320L);
    }

    public void a_renamed(java.lang.Integer num) {
        android.os.Handler handler = this.O_renamed;
        if (handler == null || !this.f5932c) {
            return;
        }
        handler.removeMessages(1);
        android.os.Message messageObtain = android.os.Message.obtain();
        messageObtain.obj = num;
        messageObtain.what = 1;
        this.O_renamed.sendMessage(messageObtain);
    }

    public void b_renamed(int i_renamed, boolean z_renamed, int i2, int i3) {
        if (this.e_renamed == null || this.f_renamed == null) {
            return;
        }
        j_renamed();
        k_renamed();
        com.oplus.camera.e_renamed.a_renamed("Beauty3DGuideScanUI", "showBeauty3DScanView, mbScanAdd: " + this.f5931b);
        this.n_renamed.setVisibility(0);
        if (!this.f5931b) {
            this.z_renamed = (android.widget.ImageView) this.n_renamed.findViewById(com.oplus.camera.R_renamed.id_renamed.scan_circle);
            if (this.s_renamed == null) {
                this.s_renamed = new com.oplus.camera.ui.beauty3d.h_renamed(this.z_renamed, this.M_renamed, 33, true);
            }
            this.y_renamed = (com.oplus.camera.ui.beauty3d.OplusCircleProgressView) this.n_renamed.findViewById(com.oplus.camera.R_renamed.id_renamed.circle_progress);
            android.widget.ImageView imageView = (android.widget.ImageView) this.n_renamed.findViewById(com.oplus.camera.R_renamed.id_renamed.scan_foreground_middle);
            android.view.View viewFindViewById = this.n_renamed.findViewById(com.oplus.camera.R_renamed.id_renamed.scan_foreground_top);
            android.view.View viewFindViewById2 = this.n_renamed.findViewById(com.oplus.camera.R_renamed.id_renamed.scan_foreground_bottom);
            if (i_renamed == 2 && !z_renamed) {
                viewFindViewById.setVisibility(8);
                viewFindViewById2.setVisibility(8);
            } else if (i_renamed == 0 && !z_renamed) {
                viewFindViewById.setVisibility(0);
                viewFindViewById2.setVisibility(0);
                android.widget.RelativeLayout.LayoutParams layoutParams = (android.widget.RelativeLayout.LayoutParams) this.z_renamed.getLayoutParams();
                int dimension = (int) this.e_renamed.getResources().getDimension(com.oplus.camera.R_renamed.dimen.beauty3d_scan_imageview_margin_top);
                layoutParams.addRule(10);
                layoutParams.topMargin = dimension;
                this.z_renamed.setLayoutParams(layoutParams);
                android.widget.RelativeLayout.LayoutParams layoutParams2 = (android.widget.RelativeLayout.LayoutParams) imageView.getLayoutParams();
                layoutParams2.addRule(10);
                layoutParams2.topMargin = dimension;
                imageView.setLayoutParams(layoutParams2);
            } else if (z_renamed) {
                this.e_renamed.findViewById(com.oplus.camera.R_renamed.id_renamed.beauty3d_setting).setVisibility(0);
                android.widget.RelativeLayout.LayoutParams layoutParams3 = (android.widget.RelativeLayout.LayoutParams) this.n_renamed.getLayoutParams();
                layoutParams3.addRule(12);
                layoutParams3.bottomMargin = i2;
                this.n_renamed.setLayoutParams(layoutParams3);
                viewFindViewById.setVisibility(0);
                viewFindViewById2.setVisibility(0);
                android.widget.RelativeLayout.LayoutParams layoutParams4 = (android.widget.RelativeLayout.LayoutParams) this.z_renamed.getLayoutParams();
                int dimension2 = (int) this.e_renamed.getResources().getDimension(com.oplus.camera.R_renamed.dimen.beauty3d_scan_imageview_margin_top);
                layoutParams4.addRule(10);
                layoutParams4.topMargin = dimension2;
                this.z_renamed.setLayoutParams(layoutParams4);
                android.widget.RelativeLayout.LayoutParams layoutParams5 = (android.widget.RelativeLayout.LayoutParams) imageView.getLayoutParams();
                layoutParams5.addRule(10);
                layoutParams5.topMargin = dimension2;
                imageView.setLayoutParams(layoutParams5);
            }
            this.n_renamed.requestLayout();
            this.v_renamed = this.y_renamed.getCenterPoint();
            this.f_renamed.addView(this.n_renamed, new android.view.ViewGroup.LayoutParams(-1, -1));
        }
        b_renamed(i_renamed, z_renamed);
        a_renamed(z_renamed);
        this.f5931b = true;
        if (this.A_renamed.isStarted()) {
            this.A_renamed.cancel();
        }
        this.A_renamed.start();
        this.f5932c = false;
    }

    public void a_renamed(int i_renamed, boolean z_renamed) {
        k_renamed();
        a_renamed(z_renamed);
        b_renamed(i_renamed, z_renamed);
        l_renamed();
    }

    private void l_renamed() {
        this.f5932c = true;
        android.view.View view = this.n_renamed;
        if (view != null && view.getVisibility() != 0) {
            this.n_renamed.setVisibility(0);
        }
        com.oplus.camera.ui.beauty3d.h_renamed hVar = this.s_renamed;
        if (hVar != null) {
            if (!hVar.b_renamed()) {
                this.s_renamed.a_renamed();
            }
            this.s_renamed.d_renamed();
        }
        android.widget.Button button = this.x_renamed;
        if (button != null) {
            button.setVisibility(4);
            this.x_renamed.setClickable(false);
        }
    }

    public void a_renamed(boolean z_renamed, final boolean z2) {
        if (this.d_renamed) {
            com.oplus.camera.e_renamed.a_renamed("Beauty3DGuideScanUI", "stop3DScan, mbExiting: " + this.d_renamed + " return");
            return;
        }
        this.d_renamed = true;
        this.f5932c = false;
        android.os.Handler handler = this.O_renamed;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.l_renamed = true;
        }
        if (z_renamed) {
            android.animation.ObjectAnimator objectAnimatorOfFloat = android.animation.ObjectAnimator.ofFloat(this.n_renamed, "alpha", 1.0f, 0.0f);
            objectAnimatorOfFloat.setInterpolator(this.J_renamed);
            objectAnimatorOfFloat.setDuration(320L);
            objectAnimatorOfFloat.addListener(new android.animation.Animator.AnimatorListener() { // from class: com.oplus.camera.ui.beauty3d.f_renamed.2
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(android.animation.Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(android.animation.Animator animator) {
                    com.oplus.camera.ui.beauty3d.f_renamed.this.m_renamed();
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(android.animation.Animator animator) {
                    com.oplus.camera.e_renamed.a_renamed("Beauty3DGuideScanUI", "stop3DScan, onAnimationEnd");
                    com.oplus.camera.ui.beauty3d.f_renamed.this.A_renamed = null;
                    com.oplus.camera.ui.beauty3d.f_renamed.this.q_renamed();
                    if (z2) {
                        com.oplus.camera.ui.beauty3d.f_renamed.this.a_renamed(1);
                    } else {
                        com.oplus.camera.ui.beauty3d.f_renamed.this.c_renamed();
                    }
                    if (com.oplus.camera.ui.beauty3d.f_renamed.this.u_renamed != null) {
                        com.oplus.camera.ui.beauty3d.f_renamed.this.u_renamed.a_renamed(true);
                    }
                    com.oplus.camera.ui.beauty3d.f_renamed.this.d_renamed = false;
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(android.animation.Animator animator) {
                    com.oplus.camera.e_renamed.a_renamed("Beauty3DGuideScanUI", "stop3DScan, onAnimationCancel");
                }
            });
            objectAnimatorOfFloat.start();
            return;
        }
        m_renamed();
        this.A_renamed = null;
        q_renamed();
        if (z2) {
            a_renamed(1);
        } else {
            c_renamed();
        }
        com.oplus.camera.ui.beauty3d.e_renamed eVar = this.u_renamed;
        if (eVar != null) {
            eVar.a_renamed(false);
        }
        this.d_renamed = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m_renamed() {
        android.animation.ObjectAnimator objectAnimator = this.A_renamed;
        if (objectAnimator != null && objectAnimator.isRunning()) {
            this.A_renamed.cancel();
        }
        android.animation.ObjectAnimator objectAnimator2 = this.B_renamed;
        if (objectAnimator2 != null) {
            objectAnimator2.cancel();
            this.B_renamed = null;
        }
        com.oplus.camera.ui.beauty3d.h_renamed hVar = this.s_renamed;
        if (hVar != null) {
            hVar.a_renamed();
        }
        com.oplus.camera.ui.beauty3d.h_renamed hVar2 = this.t_renamed;
        if (hVar2 != null) {
            hVar2.a_renamed();
        }
        android.animation.AnimatorSet animatorSet = this.H_renamed;
        if (animatorSet == null || !animatorSet.isRunning()) {
            return;
        }
        this.H_renamed.cancel();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(android.view.View view) {
        switch (view.getId()) {
            case com.oplus.camera.R_renamed.id_renamed.scan_cancel /* 2131297031 */:
                a_renamed(true, true);
                break;
            case com.oplus.camera.R_renamed.id_renamed.skip /* 2131297085 */:
                a_renamed(0);
                break;
            case com.oplus.camera.R_renamed.id_renamed.start_face_scan /* 2131297112 */:
                a_renamed(0);
                com.oplus.camera.e_renamed.a_renamed("Beauty3DGuideScanUI", "onClick, startScan, disMiss Guide.");
                com.oplus.camera.ui.beauty3d.e_renamed eVar = this.u_renamed;
                if (eVar != null) {
                    eVar.b_renamed();
                    break;
                }
                break;
            case com.oplus.camera.R_renamed.id_renamed.start_scan /* 2131297113 */:
                l_renamed();
                com.oplus.camera.ui.beauty3d.e_renamed eVar2 = this.u_renamed;
                if (eVar2 != null) {
                    eVar2.a_renamed("com.oplus.beauty3d.scan.state", new int[]{1});
                    break;
                }
                break;
        }
    }

    public void e_renamed() {
        a_renamed(0);
        a_renamed(false, false);
    }

    public void a_renamed(boolean z_renamed) {
        n_renamed();
        this.h_renamed.setVisibility(0);
        this.h_renamed.setEnabled(true);
        if (z_renamed) {
            c_renamed(z_renamed);
        }
    }

    private void c_renamed(boolean z_renamed) {
        android.view.View view = this.h_renamed;
        if (view != null) {
            if (z_renamed) {
                view.setBackgroundColor(this.e_renamed.getResources().getColor(com.oplus.camera.R_renamed.color.beauty3d_scan_background));
            } else {
                view.setBackgroundColor(this.e_renamed.getResources().getColor(com.oplus.camera.R_renamed.color.background_color));
            }
        }
    }

    private void n_renamed() {
        if (this.h_renamed == null) {
            android.view.ViewGroup viewGroup = (android.view.ViewGroup) this.e_renamed.findViewById(com.oplus.camera.R_renamed.id_renamed.camera);
            this.h_renamed = this.e_renamed.getLayoutInflater().inflate(com.oplus.camera.R_renamed.layout.beauty3d_scan_setting, (android.view.ViewGroup) null, false);
            this.h_renamed.setBackgroundColor(this.e_renamed.getResources().getColor(com.oplus.camera.R_renamed.color.background_color));
            this.h_renamed.setOnTouchListener(this);
            if (this.i_renamed) {
                return;
            }
            android.widget.RelativeLayout.LayoutParams layoutParams = new android.widget.RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(10);
            layoutParams.height = (int) this.e_renamed.getResources().getDimension(com.oplus.camera.R_renamed.dimen.beauty3d_scan_setting_height);
            layoutParams.topMargin = 0;
            viewGroup.addView(this.h_renamed, layoutParams);
            this.i_renamed = true;
        }
    }

    public void f_renamed() {
        android.view.View view = this.h_renamed;
        if (view != null) {
            view.setVisibility(8);
            this.h_renamed.setEnabled(false);
        }
    }

    public void b_renamed(int i_renamed, boolean z_renamed) {
        o_renamed();
        this.w_renamed = (android.widget.TextView) this.j_renamed.findViewById(com.oplus.camera.R_renamed.id_renamed.scan_cancel);
        this.x_renamed = (android.widget.Button) this.j_renamed.findViewById(com.oplus.camera.R_renamed.id_renamed.start_scan);
        if (com.oplus.camera.util.Util.aa_renamed()) {
            a_renamed(this.w_renamed);
        }
        this.j_renamed.setVisibility(0);
        this.j_renamed.setEnabled(true);
        this.j_renamed.setOnTouchListener(this);
        if (z_renamed) {
            c_renamed(this.e_renamed.getColor(com.oplus.camera.R_renamed.color.beauty3d_scan_background), false);
        }
        this.w_renamed.setEnabled(true);
        this.w_renamed.setClickable(true);
        this.w_renamed.setOnClickListener(this);
        this.x_renamed.setVisibility(0);
        this.x_renamed.setEnabled(true);
        this.x_renamed.setClickable(true);
        this.x_renamed.setOnClickListener(this);
    }

    private void o_renamed() {
        if (this.j_renamed == null) {
            this.j_renamed = this.e_renamed.getLayoutInflater().inflate(com.oplus.camera.R_renamed.layout.beauty3d_scan_bottom, (android.view.ViewGroup) null, false);
            this.j_renamed.setBackgroundColor(this.e_renamed.getResources().getColor(com.oplus.camera.R_renamed.color.background_color));
            android.view.ViewGroup viewGroup = (android.view.ViewGroup) this.e_renamed.findViewById(com.oplus.camera.R_renamed.id_renamed.camera);
            if (this.k_renamed) {
                return;
            }
            android.widget.RelativeLayout.LayoutParams layoutParams = new android.widget.RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            layoutParams.bottomMargin = 0;
            layoutParams.height = com.oplus.camera.util.Util.O_renamed();
            viewGroup.addView(this.j_renamed, layoutParams);
            this.k_renamed = true;
        }
    }

    public void g_renamed() {
        android.view.View view = this.j_renamed;
        if (view != null) {
            view.setVisibility(8);
            this.j_renamed.setEnabled(false);
        }
    }

    private void c_renamed(int i_renamed, boolean z_renamed) {
        com.oplus.camera.e_renamed.a_renamed("Beauty3DGuideScanUI", "updateBeauty3DControlPanelBgColor, color: " + i_renamed + ", needAnimation: " + z_renamed);
        android.view.View view = this.j_renamed;
        if (view == null) {
            return;
        }
        if (z_renamed) {
            com.oplus.camera.util.Util.a_renamed(view, i_renamed, 200, (android.view.animation.Interpolator) null, (android.animation.Animator.AnimatorListener) null);
        } else {
            view.setBackgroundColor(i_renamed);
        }
    }

    public boolean c_renamed(int i_renamed, boolean z_renamed, int i2, int i3) {
        android.view.View view;
        if (!this.f5930a || (view = this.m_renamed) == null) {
            return false;
        }
        this.m_renamed.setLayoutParams(a_renamed(i_renamed, z_renamed, (android.widget.TextView) view.findViewById(com.oplus.camera.R_renamed.id_renamed.skip), true, i2, i3));
        this.m_renamed.requestLayout();
        return true;
    }

    private void a_renamed(android.widget.TextView textView, android.widget.TextView textView2) {
        android.widget.RelativeLayout.LayoutParams layoutParams = (android.widget.RelativeLayout.LayoutParams) textView.getLayoutParams();
        layoutParams.topMargin = (int) this.e_renamed.getResources().getDimension(com.oplus.camera.R_renamed.dimen.beauty3d_guide_margin_top);
        textView.setLayoutParams(layoutParams);
        android.widget.RelativeLayout.LayoutParams layoutParams2 = (android.widget.RelativeLayout.LayoutParams) textView2.getLayoutParams();
        layoutParams2.bottomMargin = (int) this.e_renamed.getResources().getDimension(com.oplus.camera.R_renamed.dimen.beauty3d_guide_textview_margin_bottom);
        textView2.setLayoutParams(layoutParams2);
    }

    public void b_renamed(int i_renamed) {
        android.os.Handler handler = this.O_renamed;
        if (handler == null || !this.f5932c) {
            return;
        }
        handler.removeMessages(2);
        android.os.Message messageObtain = android.os.Message.obtain();
        messageObtain.obj = java.lang.Integer.valueOf(i_renamed);
        messageObtain.what = 2;
        this.O_renamed.sendMessage(messageObtain);
    }

    private void a_renamed(android.widget.TextView textView) {
        if (textView != null) {
            android.widget.RelativeLayout.LayoutParams layoutParams = (android.widget.RelativeLayout.LayoutParams) textView.getLayoutParams();
            layoutParams.topMargin = this.e_renamed.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.control_panel_margin_top);
            textView.setLayoutParams(layoutParams);
            textView.requestLayout();
        }
    }

    public void b_renamed(boolean z_renamed) {
        android.view.View view = this.j_renamed;
        if (view != null) {
            view.setEnabled(z_renamed);
            this.j_renamed.setClickable(z_renamed);
        }
    }

    public void a_renamed(java.lang.String str) {
        if (this.r_renamed == null) {
            this.r_renamed = (android.widget.TextView) this.n_renamed.findViewById(com.oplus.camera.R_renamed.id_renamed.hint);
        }
        this.r_renamed.setText("");
        if (this.B_renamed == null) {
            if (android.text.TextUtils.getLayoutDirectionFromLocale(java.util.Locale.getDefault()) == 1) {
                float f_renamed = 30;
                float f2 = -30;
                this.B_renamed = android.animation.ObjectAnimator.ofFloat(this.r_renamed, "translationX", 0.0f, f_renamed, f2, f_renamed, f2, 0.0f);
            } else {
                float f3 = -30;
                float f4 = 30;
                this.B_renamed = android.animation.ObjectAnimator.ofFloat(this.r_renamed, "translationX", 0.0f, f3, f4, f3, f4, 0.0f);
            }
        }
        if (!android.text.TextUtils.isEmpty(str)) {
            this.r_renamed.setText(str);
        }
        this.B_renamed.setDuration(300L);
        if (this.B_renamed.isRunning()) {
            this.B_renamed.cancel();
        }
        this.B_renamed.start();
    }

    private void p_renamed() {
        com.oplus.camera.ui.beauty3d.h_renamed hVar = this.s_renamed;
        if (hVar != null) {
            hVar.a_renamed();
        }
        this.s_renamed = null;
        com.oplus.camera.ui.beauty3d.h_renamed hVar2 = this.t_renamed;
        if (hVar2 != null) {
            hVar2.a_renamed();
        }
        this.t_renamed = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q_renamed() {
        android.widget.ImageView imageView = this.o_renamed;
        if (imageView != null) {
            imageView.setVisibility(4);
        }
        android.widget.ImageView imageView2 = this.p_renamed;
        if (imageView2 != null) {
            imageView2.setVisibility(4);
        }
        android.widget.ImageView imageView3 = this.q_renamed;
        if (imageView3 != null) {
            imageView3.setVisibility(4);
        }
        android.animation.ObjectAnimator objectAnimator = this.C_renamed;
        if (objectAnimator != null && objectAnimator.isRunning()) {
            this.C_renamed.cancel();
        }
        android.animation.ObjectAnimator objectAnimator2 = this.D_renamed;
        if (objectAnimator2 != null && objectAnimator2.isRunning()) {
            this.D_renamed.cancel();
        }
        android.animation.ObjectAnimator objectAnimator3 = this.E_renamed;
        if (objectAnimator3 != null && objectAnimator3.isRunning()) {
            this.E_renamed.cancel();
        }
        android.animation.ObjectAnimator objectAnimator4 = this.F_renamed;
        if (objectAnimator4 == null || !objectAnimator4.isRunning()) {
            return;
        }
        this.F_renamed.cancel();
    }

    public void c_renamed(int i_renamed) {
        if (i_renamed == com.oplus.camera.R_renamed.string.beauty3d_turn_to_left || i_renamed == com.oplus.camera.R_renamed.string.beauty3d_continue_turn_to_left) {
            com.oplus.camera.e_renamed.a_renamed("Beauty3DGuideScanUI", "updateArrow, turn left");
            a_renamed(this.o_renamed, "translationX");
            a_renamed(this.E_renamed, this.p_renamed);
            a_renamed(this.F_renamed, this.q_renamed);
            return;
        }
        if (i_renamed == com.oplus.camera.R_renamed.string.beauty3d_turn_to_right || i_renamed == com.oplus.camera.R_renamed.string.beauty3d_continue_turn_to_right) {
            com.oplus.camera.e_renamed.a_renamed("Beauty3DGuideScanUI", "updateArrow, turn right");
            a_renamed(this.p_renamed, "translationX");
            a_renamed(this.D_renamed, this.o_renamed);
            a_renamed(this.F_renamed, this.q_renamed);
            return;
        }
        if (i_renamed == com.oplus.camera.R_renamed.string.beauty3d_turn_to_up) {
            com.oplus.camera.e_renamed.a_renamed("Beauty3DGuideScanUI", "updateArrow, turn up_renamed");
            a_renamed(this.q_renamed, "translationY");
            a_renamed(this.E_renamed, this.p_renamed);
            a_renamed(this.D_renamed, this.o_renamed);
            return;
        }
        android.animation.ObjectAnimator objectAnimator = this.C_renamed;
        if (objectAnimator != null && objectAnimator.isRunning()) {
            this.C_renamed.cancel();
        }
        a_renamed(this.E_renamed, this.p_renamed);
        a_renamed(this.D_renamed, this.o_renamed);
        a_renamed(this.F_renamed, this.q_renamed);
    }

    public void a_renamed(android.view.View view, java.lang.String str) {
        android.animation.PropertyValuesHolder propertyValuesHolderOfFloat;
        if (view == null || view.getVisibility() == 0) {
            return;
        }
        android.animation.ObjectAnimator objectAnimator = this.C_renamed;
        if (objectAnimator != null && objectAnimator.isRunning()) {
            this.C_renamed.cancel();
        }
        com.oplus.camera.e_renamed.a_renamed("Beauty3DGuideScanUI", "playStartArrowAnim");
        if (view.getId() == com.oplus.camera.R_renamed.id_renamed.scan_right_arrow) {
            propertyValuesHolderOfFloat = android.animation.PropertyValuesHolder.ofFloat(str, 0.0f, 100);
        } else {
            propertyValuesHolderOfFloat = android.animation.PropertyValuesHolder.ofFloat(str, 0.0f, -100);
        }
        this.C_renamed = android.animation.ObjectAnimator.ofPropertyValuesHolder(view, propertyValuesHolderOfFloat, android.animation.PropertyValuesHolder.ofFloat("alpha", 0.0f, 1.0f, 1.0f, 0.0f));
        this.C_renamed.setInterpolator(this.K_renamed);
        this.C_renamed.setDuration(1200L);
        this.C_renamed.setRepeatCount(-1);
        this.C_renamed.setRepeatMode(1);
        this.C_renamed.start();
        view.setVisibility(0);
    }

    public void a_renamed(android.animation.ObjectAnimator objectAnimator, final android.view.View view) {
        if (view == null || view.getVisibility() != 0) {
            return;
        }
        if (objectAnimator != null && objectAnimator.isRunning()) {
            com.oplus.camera.e_renamed.a_renamed("Beauty3DGuideScanUI", "playFadeOutArrowAnim, animator is_renamed Running");
            return;
        }
        com.oplus.camera.e_renamed.a_renamed("Beauty3DGuideScanUI", "playFadeOutArrowAnim");
        if (objectAnimator == null) {
            objectAnimator = android.animation.ObjectAnimator.ofFloat(view, "alpha", 1.0f, 0.0f);
            objectAnimator.addListener(new android.animation.AnimatorListenerAdapter() { // from class: com.oplus.camera.ui.beauty3d.f_renamed.3
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(android.animation.Animator animator) {
                    super.onAnimationEnd(animator);
                    view.setVisibility(4);
                    view.setAlpha(1.0f);
                }
            });
        }
        objectAnimator.setInterpolator(this.J_renamed);
        objectAnimator.setDuration(200L);
        objectAnimator.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d_renamed(int i_renamed) {
        android.widget.ImageView imageView;
        if (this.t_renamed == null && (imageView = this.z_renamed) != null) {
            this.t_renamed = new com.oplus.camera.ui.beauty3d.h_renamed(imageView, this.N_renamed, 41, true);
        }
        com.oplus.camera.ui.beauty3d.h_renamed hVar = this.s_renamed;
        if (hVar != null && !hVar.b_renamed()) {
            this.s_renamed.a_renamed();
        }
        com.oplus.camera.ui.beauty3d.h_renamed hVar2 = this.t_renamed;
        if (hVar2 == null || hVar2.c_renamed()) {
            return;
        }
        android.widget.TextView textView = this.r_renamed;
        if (textView != null) {
            textView.setText(i_renamed);
        }
        com.oplus.camera.e_renamed.a_renamed("Beauty3DGuideScanUI", "startScanLoadAnim, mScanLoadAnimation start");
        this.t_renamed.d_renamed();
        this.y_renamed.setVisibility(4);
        android.view.View view = this.n_renamed;
        if (view != null) {
            ((android.widget.ImageView) view.findViewById(com.oplus.camera.R_renamed.id_renamed.scan_foreground_middle)).setImageResource(com.oplus.camera.R_renamed.drawable.beauty3d_sacn_load_foreground);
        }
        android.animation.PropertyValuesHolder propertyValuesHolderOfFloat = android.animation.PropertyValuesHolder.ofFloat("scaleX", 1.0f, 0.75f);
        android.animation.PropertyValuesHolder propertyValuesHolderOfFloat2 = android.animation.PropertyValuesHolder.ofFloat("scaleY", 1.0f, 0.75f);
        android.animation.ObjectAnimator objectAnimator = this.G_renamed;
        if (objectAnimator != null && objectAnimator.isRunning()) {
            this.G_renamed.cancel();
        }
        this.G_renamed = android.animation.ObjectAnimator.ofPropertyValuesHolder(this.z_renamed, propertyValuesHolderOfFloat, propertyValuesHolderOfFloat2);
        this.G_renamed.setDuration(500L);
        this.G_renamed.setInterpolator(this.L_renamed);
        com.oplus.camera.e_renamed.a_renamed("Beauty3DGuideScanUI", "startScanLoadAnim, scaleAnim start");
        this.G_renamed.start();
    }

    public void h_renamed() {
        com.oplus.camera.e_renamed.a_renamed("Beauty3DGuideScanUI", "scanComplete");
        android.animation.AnimatorSet animatorSet = this.H_renamed;
        if (animatorSet != null && animatorSet.isRunning()) {
            com.oplus.camera.e_renamed.a_renamed("Beauty3DGuideScanUI", "scanComplete,isRunning return");
            return;
        }
        this.H_renamed = new android.animation.AnimatorSet();
        android.animation.ObjectAnimator objectAnimatorOfPropertyValuesHolder = android.animation.ObjectAnimator.ofPropertyValuesHolder(this.z_renamed, android.animation.PropertyValuesHolder.ofFloat("scaleX", 0.0f, 2.0f), android.animation.PropertyValuesHolder.ofFloat("scaleY", 0.0f, 2.0f));
        objectAnimatorOfPropertyValuesHolder.setInterpolator(this.L_renamed);
        android.animation.ObjectAnimator objectAnimatorOfFloat = android.animation.ObjectAnimator.ofFloat(this.z_renamed, "alpha", 1.0f, 0.0f);
        this.H_renamed.setDuration(500L);
        this.H_renamed.playTogether(objectAnimatorOfPropertyValuesHolder, objectAnimatorOfFloat);
        this.H_renamed.addListener(new android.animation.Animator.AnimatorListener() { // from class: com.oplus.camera.ui.beauty3d.f_renamed.4
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(android.animation.Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(android.animation.Animator animator) {
                com.oplus.camera.ui.beauty3d.f_renamed.this.I_renamed = false;
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(android.animation.Animator animator) {
                com.oplus.camera.e_renamed.a_renamed("Beauty3DGuideScanUI", "scanComplete, onAnimationEnd, mbScanCompleteCancel: " + com.oplus.camera.ui.beauty3d.f_renamed.this.I_renamed);
                if (com.oplus.camera.ui.beauty3d.f_renamed.this.O_renamed == null || com.oplus.camera.ui.beauty3d.f_renamed.this.I_renamed) {
                    return;
                }
                com.oplus.camera.ui.beauty3d.f_renamed.this.O_renamed.post(new java.lang.Runnable() { // from class: com.oplus.camera.ui.beauty3d.f_renamed.4.1
                    @Override // java.lang.Runnable
                    public void run() {
                        com.oplus.camera.ui.beauty3d.f_renamed.this.z_renamed.setAlpha(1.0f);
                        if (com.oplus.camera.ui.beauty3d.f_renamed.this.u_renamed != null) {
                            com.oplus.camera.ui.beauty3d.f_renamed.this.u_renamed.c_renamed();
                            com.oplus.camera.ui.beauty3d.f_renamed.this.a_renamed(false, true);
                        }
                    }
                });
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(android.animation.Animator animator) {
                com.oplus.camera.ui.beauty3d.f_renamed.this.I_renamed = true;
            }
        });
        this.H_renamed.start();
    }
}

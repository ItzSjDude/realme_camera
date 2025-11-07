package com.oplus.camera.ui.preview;

/* compiled from: TeleSmallPreviewManager.java */
/* loaded from: classes2.dex */
public class ab_renamed implements com.oplus.camera.ui.menu.setting.f_renamed.a_renamed, com.oplus.camera.ui.preview.g_renamed.c_renamed {
    private android.app.Activity e_renamed;
    private android.os.Handler f_renamed;
    private com.oplus.camera.ui.preview.PreviewFrameLayout g_renamed;
    private com.oplus.camera.ui.CameraUIListener i_renamed;

    /* renamed from: a_renamed, reason: collision with root package name */
    private boolean f6983a = true;

    /* renamed from: b_renamed, reason: collision with root package name */
    private boolean f6984b = false;

    /* renamed from: c_renamed, reason: collision with root package name */
    private boolean f6985c = false;
    private boolean d_renamed = false;
    private com.oplus.camera.gl_renamed.u_renamed h_renamed = null;
    private com.oplus.camera.ui.preview.ab_renamed.b_renamed j_renamed = null;
    private float k_renamed = 1.0f;
    private float l_renamed = 1.0f;
    private float m_renamed = 1.0f;
    private float n_renamed = 1.0f;
    private android.util.Size o_renamed = null;
    private int p_renamed = 0;
    private boolean q_renamed = false;
    private boolean r_renamed = false;
    private boolean s_renamed = false;

    public ab_renamed(android.app.Activity activity, com.oplus.camera.ui.CameraUIListener cameraUIListener) throws android.content.res.Resources.NotFoundException {
        this.e_renamed = null;
        this.f_renamed = null;
        this.g_renamed = null;
        this.i_renamed = null;
        this.e_renamed = activity;
        this.i_renamed = cameraUIListener;
        this.f_renamed = new com.oplus.camera.ui.preview.ab_renamed.a_renamed(this.e_renamed.getMainLooper());
        this.g_renamed = (com.oplus.camera.ui.preview.PreviewFrameLayout) this.e_renamed.findViewById(com.oplus.camera.R_renamed.id_renamed.frame_layout);
        i_renamed();
        g_renamed();
        h_renamed();
    }

    private void g_renamed() {
        float[] configFloatArrayValue = com.oplus.camera.aps.config.CameraConfig.getConfigFloatArrayValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_SAT_TELE_ZOOM_RANGE);
        if (configFloatArrayValue == null || configFloatArrayValue.length != 2) {
            return;
        }
        this.k_renamed = configFloatArrayValue[0];
        this.l_renamed = configFloatArrayValue[1];
        this.m_renamed = java.lang.Float.compare(20.0f, this.l_renamed) >= 0 ? 15.0f : 20.0f;
        com.oplus.camera.e_renamed.b_renamed("TeleSmallPreviewManager", "initTeleZoomRange, range: (" + this.k_renamed + ", " + this.l_renamed + ")");
    }

    private void h_renamed() throws android.content.res.Resources.NotFoundException {
        android.widget.RelativeLayout.LayoutParams layoutParams;
        com.oplus.camera.gl_renamed.u_renamed uVar = this.h_renamed;
        if (uVar == null) {
            this.h_renamed = new com.oplus.camera.gl_renamed.u_renamed(this.e_renamed);
            this.h_renamed.b_renamed();
            com.oplus.camera.screen.b_renamed.a_renamed aVarBL = this.i_renamed.bL_renamed();
            if (aVarBL != null && aVarBL.r_renamed()) {
                layoutParams = a_renamed(aVarBL);
            } else {
                layoutParams = new android.widget.RelativeLayout.LayoutParams(0, 0);
                layoutParams.addRule(10);
                layoutParams.addRule(11);
                layoutParams.rightMargin = this.e_renamed.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.tele_small_preview_right_margin);
                layoutParams.topMargin = this.e_renamed.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.tele_small_preview_top_margin);
            }
            if (this.g_renamed.getChildCount() > 3) {
                this.g_renamed.addView(this.h_renamed, 3, layoutParams);
            } else {
                this.g_renamed.addView(this.h_renamed, layoutParams);
            }
            com.oplus.camera.gl_renamed.l_renamed lVar = new com.oplus.camera.gl_renamed.l_renamed();
            lVar.a_renamed(this.e_renamed.getResources().getColor(com.oplus.camera.R_renamed.color.color_white_with_full_percent_transparency));
            lVar.a_renamed(this.e_renamed.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.tele_small_preview_out_line_width));
            this.h_renamed.setOuterFramePaint(lVar);
            com.oplus.camera.gl_renamed.l_renamed lVar2 = new com.oplus.camera.gl_renamed.l_renamed();
            lVar2.a_renamed(this.e_renamed.getResources().getColor(com.oplus.camera.R_renamed.color.color_white_with_full_percent_transparency));
            lVar2.a_renamed(this.e_renamed.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.tele_small_preview_inner_line_width));
            this.h_renamed.setInnerFramePaint(lVar2);
            com.oplus.camera.gl_renamed.l_renamed lVar3 = new com.oplus.camera.gl_renamed.l_renamed();
            lVar3.a_renamed(this.e_renamed.getResources().getColor(com.oplus.camera.R_renamed.color.color_white_with_50_percent_transparency));
            lVar3.a_renamed(this.e_renamed.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.tele_small_preview_inner_line_width));
            this.h_renamed.setLinePaint(lVar3);
            this.h_renamed.setVisibility(4);
            return;
        }
        uVar.e_renamed();
    }

    public void b_renamed(boolean z_renamed) {
        com.oplus.camera.gl_renamed.u_renamed uVar = this.h_renamed;
        if (uVar != null) {
            uVar.setRearMirrorEnable(z_renamed);
        }
    }

    private void i_renamed() {
        android.os.HandlerThread handlerThread = new android.os.HandlerThread("ScreenModeChange State Thread");
        handlerThread.start();
        this.j_renamed = new com.oplus.camera.ui.preview.ab_renamed.b_renamed(handlerThread.getLooper());
    }

    public void a_renamed(com.oplus.camera.ui.menu.setting.f_renamed fVar) {
        if (fVar != null) {
            fVar.a_renamed(this);
        }
    }

    public void a_renamed(com.oplus.camera.ui.preview.g_renamed gVar) {
        if (gVar != null) {
            gVar.a_renamed(this);
        }
    }

    public boolean a_renamed(float f_renamed) {
        return java.lang.Float.compare(f_renamed, this.m_renamed) > 0;
    }

    public void b_renamed(float f_renamed) {
        this.n_renamed = f_renamed;
        float f2 = this.n_renamed;
        float f3 = this.m_renamed;
        if (f2 < f3) {
            this.n_renamed = f3;
        }
        float f4 = this.k_renamed / (this.n_renamed * 2.0f);
        com.oplus.camera.gl_renamed.u_renamed uVar = this.h_renamed;
        if (uVar != null) {
            uVar.setFrameDelta(f4);
        }
    }

    @Override // com.oplus.camera.ui.menu.setting.f_renamed.a_renamed
    public void a_renamed(boolean z_renamed) {
        this.q_renamed = z_renamed;
    }

    public void c_renamed(boolean z_renamed) {
        this.r_renamed = z_renamed;
    }

    public void d_renamed(boolean z_renamed) {
        com.oplus.camera.ui.preview.ab_renamed.b_renamed bVar = this.j_renamed;
        if (bVar == null) {
            return;
        }
        bVar.removeCallbacksAndMessages(null);
        android.os.Message messageObtain = android.os.Message.obtain();
        if (z_renamed) {
            messageObtain.what = 3;
            this.j_renamed.sendMessage(messageObtain);
        } else {
            messageObtain.what = 4;
            this.j_renamed.sendMessageDelayed(messageObtain, 60L);
        }
    }

    public boolean a_renamed() {
        return this.q_renamed || this.r_renamed || (com.oplus.camera.util.Util.t_renamed() && this.s_renamed);
    }

    @Override // com.oplus.camera.ui.preview.g_renamed.c_renamed
    public void a_renamed(android.widget.RelativeLayout.LayoutParams layoutParams) throws android.content.res.Resources.NotFoundException {
        android.widget.RelativeLayout.LayoutParams layoutParamsA;
        if (this.h_renamed != null) {
            com.oplus.camera.screen.b_renamed.a_renamed aVarBL = this.i_renamed.bL_renamed();
            if (aVarBL != null && aVarBL.r_renamed()) {
                layoutParamsA = a_renamed(aVarBL);
            } else {
                int i_renamed = ((android.widget.RelativeLayout.LayoutParams) this.g_renamed.getLayoutParams()).topMargin - layoutParams.topMargin;
                layoutParamsA = (android.widget.RelativeLayout.LayoutParams) this.h_renamed.getLayoutParams();
                layoutParamsA.topMargin += i_renamed;
            }
            this.h_renamed.setLayoutParams(layoutParamsA);
        }
    }

    public void e_renamed(boolean z_renamed) {
        this.f6983a = z_renamed;
    }

    public void a_renamed(android.util.Size size) {
        com.oplus.camera.e_renamed.b_renamed("TeleSmallPreviewManager", "setPreviewSize, " + size);
        if (size != null) {
            this.o_renamed = size;
        }
    }

    public boolean b_renamed() {
        com.oplus.camera.gl_renamed.u_renamed uVar = this.h_renamed;
        return uVar != null && uVar.getVisibility() == 0;
    }

    public void a_renamed(boolean z_renamed, boolean z2, boolean z3) {
        android.os.Message messageObtainMessage;
        com.oplus.camera.e_renamed.b_renamed("TeleSmallPreviewManager", "setTeleSmallPreviewViewVisible, visible: " + z_renamed);
        this.f6985c = z2;
        if (this.s_renamed && !z_renamed) {
            this.f6985c = false;
        }
        this.d_renamed = z3;
        if (z_renamed) {
            messageObtainMessage = this.f_renamed.obtainMessage(1);
            this.f_renamed.removeMessages(1);
        } else {
            messageObtainMessage = this.f_renamed.obtainMessage(2);
            this.f_renamed.removeMessages(2);
        }
        this.f_renamed.sendMessage(messageObtainMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b_renamed(boolean z_renamed, boolean z2, boolean z3) throws android.content.res.Resources.NotFoundException {
        android.view.animation.PathInterpolator pathInterpolator;
        android.animation.Animator.AnimatorListener animatorListener;
        android.animation.ObjectAnimator objectAnimatorOfFloat;
        android.animation.ObjectAnimator objectAnimatorOfFloat2;
        com.oplus.camera.e_renamed.b_renamed("TeleSmallPreviewManager", "showTeleSmallPreviewView");
        com.oplus.camera.gl_renamed.u_renamed uVar = this.h_renamed;
        if (uVar == null) {
            com.oplus.camera.e_renamed.b_renamed("TeleSmallPreviewManager", "showTeleSmallPreviewView, view is_renamed null");
            return;
        }
        if (!z_renamed || uVar.getVisibility() != 0) {
            if (z_renamed || 4 != this.h_renamed.getVisibility()) {
                com.oplus.camera.screen.b_renamed.a_renamed aVarBL = this.i_renamed.bL_renamed();
                if (z_renamed) {
                    android.widget.RelativeLayout.LayoutParams layoutParamsA = (android.widget.RelativeLayout.LayoutParams) this.h_renamed.getLayoutParams();
                    android.util.Size size = this.o_renamed;
                    if (size != null) {
                        this.p_renamed = com.oplus.camera.util.Util.d_renamed(size.getWidth(), this.o_renamed.getHeight());
                    }
                    layoutParamsA.width = this.e_renamed.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.tele_small_preview_width);
                    layoutParamsA.rightMargin = this.e_renamed.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.tele_small_preview_right_margin);
                    a_renamed(layoutParamsA, true, true);
                    int dimensionPixelSize = com.oplus.camera.util.Util.t_renamed() ? this.e_renamed.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.fold_full_tele_small_preview_top_margin) : 0;
                    int iZ = com.oplus.camera.util.Util.Z_renamed();
                    int i_renamed = this.p_renamed;
                    if (i_renamed == 0) {
                        layoutParamsA.height = this.e_renamed.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.tele_small_preview_height_ratio_43);
                        layoutParamsA.topMargin = this.e_renamed.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.tele_small_preview_top_margin);
                        if (3 == this.i_renamed.ca_renamed()) {
                            layoutParamsA.topMargin = (com.oplus.camera.util.Util.N_renamed() - ((android.widget.RelativeLayout.LayoutParams) this.g_renamed.getLayoutParams()).topMargin) + this.e_renamed.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.tele_small_preview_top_margin);
                        } else if (1 == this.i_renamed.ca_renamed()) {
                            layoutParamsA.width = this.e_renamed.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.fold_tele_small_preview_width);
                            layoutParamsA.height = this.e_renamed.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.fold_full_tele_small_preview_height_ratio_43);
                            layoutParamsA.rightMargin = dimensionPixelSize;
                            layoutParamsA.topMargin = dimensionPixelSize;
                            if (aVarBL != null) {
                                if (6 == aVarBL.m_renamed()) {
                                    a_renamed(layoutParamsA, true, false);
                                    layoutParamsA.rightMargin = dimensionPixelSize;
                                    if (iZ != 0) {
                                        dimensionPixelSize = iZ;
                                    }
                                    layoutParamsA.bottomMargin = dimensionPixelSize;
                                } else if (5 == aVarBL.m_renamed()) {
                                    a_renamed(layoutParamsA, false, false);
                                    layoutParamsA.leftMargin = dimensionPixelSize;
                                    if (iZ != 0) {
                                        dimensionPixelSize = iZ;
                                    }
                                    layoutParamsA.bottomMargin = dimensionPixelSize;
                                }
                            }
                        }
                    } else if (i_renamed == 1) {
                        layoutParamsA.height = this.e_renamed.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.tele_small_preview_height_ratio_169);
                        layoutParamsA.topMargin = this.e_renamed.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.tele_small_preview_top_margin);
                        if (2 == this.i_renamed.ca_renamed() || 3 == this.i_renamed.ca_renamed()) {
                            layoutParamsA.topMargin = (com.oplus.camera.util.Util.N_renamed() - ((android.widget.RelativeLayout.LayoutParams) this.g_renamed.getLayoutParams()).topMargin) + this.e_renamed.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.tele_small_preview_top_margin);
                        } else if (1 == this.i_renamed.ca_renamed()) {
                            layoutParamsA.width = this.e_renamed.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.fold_tele_small_preview_width);
                            layoutParamsA.height = this.e_renamed.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.fold_full_tele_small_preview_height_ratio_169);
                            layoutParamsA.rightMargin = dimensionPixelSize;
                            layoutParamsA.topMargin = dimensionPixelSize;
                            if (aVarBL != null) {
                                if (6 == aVarBL.m_renamed()) {
                                    a_renamed(layoutParamsA, true, false);
                                    layoutParamsA.rightMargin = dimensionPixelSize;
                                    layoutParamsA.bottomMargin = this.e_renamed.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.fold_full_tele_small_preview_top_margin_ratio_169);
                                } else if (5 == aVarBL.m_renamed()) {
                                    a_renamed(layoutParamsA, false, false);
                                    layoutParamsA.leftMargin = dimensionPixelSize;
                                    layoutParamsA.bottomMargin = this.e_renamed.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.fold_full_tele_small_preview_top_margin_ratio_169);
                                }
                            }
                        }
                    } else if (i_renamed == 2) {
                        layoutParamsA.height = this.e_renamed.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.tele_small_preview_height_ratio_11);
                        layoutParamsA.topMargin = this.e_renamed.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.tele_small_preview_top_margin);
                        if (1 == this.i_renamed.ca_renamed()) {
                            layoutParamsA.width = this.e_renamed.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.fold_tele_small_preview_width);
                            layoutParamsA.height = this.e_renamed.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.fold_full_tele_small_preview_height_ratio_11);
                            layoutParamsA.rightMargin = dimensionPixelSize;
                            layoutParamsA.topMargin = dimensionPixelSize;
                            if (aVarBL != null) {
                                if (6 == aVarBL.m_renamed()) {
                                    a_renamed(layoutParamsA, true, false);
                                    layoutParamsA.rightMargin = dimensionPixelSize;
                                    if (iZ != 0) {
                                        dimensionPixelSize = iZ;
                                    }
                                    layoutParamsA.bottomMargin = dimensionPixelSize;
                                } else if (5 == aVarBL.m_renamed()) {
                                    a_renamed(layoutParamsA, false, false);
                                    layoutParamsA.leftMargin = dimensionPixelSize;
                                    if (iZ != 0) {
                                        dimensionPixelSize = iZ;
                                    }
                                    layoutParamsA.bottomMargin = dimensionPixelSize;
                                }
                            }
                        }
                    } else if (i_renamed == 6) {
                        layoutParamsA.height = this.e_renamed.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.tele_small_preview_height_ratio_1415);
                        layoutParamsA.topMargin = this.e_renamed.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.tele_small_preview_top_margin);
                        if (1 == this.i_renamed.ca_renamed()) {
                            layoutParamsA.width = this.e_renamed.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.fold_tele_small_preview_width);
                            layoutParamsA.height = this.e_renamed.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.fold_full_tele_small_preview_height_ratio_1415);
                            layoutParamsA.rightMargin = dimensionPixelSize;
                            layoutParamsA.topMargin = dimensionPixelSize;
                            if (aVarBL != null) {
                                if (6 == aVarBL.m_renamed()) {
                                    a_renamed(layoutParamsA, true, false);
                                    layoutParamsA.rightMargin = dimensionPixelSize;
                                    if (iZ != 0) {
                                        dimensionPixelSize = iZ;
                                    }
                                    layoutParamsA.bottomMargin = dimensionPixelSize;
                                } else if (5 == aVarBL.m_renamed()) {
                                    a_renamed(layoutParamsA, false, false);
                                    layoutParamsA.leftMargin = dimensionPixelSize;
                                    if (iZ != 0) {
                                        dimensionPixelSize = iZ;
                                    }
                                    layoutParamsA.bottomMargin = dimensionPixelSize;
                                }
                            }
                        }
                    } else {
                        layoutParamsA.height = this.e_renamed.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.tele_small_preview_height_ratio_full);
                        layoutParamsA.topMargin = this.e_renamed.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.menu_panel_layout_height) + this.e_renamed.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.tele_small_preview_top_margin);
                    }
                    if (aVarBL != null && aVarBL.r_renamed()) {
                        layoutParamsA = a_renamed(aVarBL);
                    }
                    this.h_renamed.setLayoutParams(layoutParamsA);
                }
                android.view.animation.PathInterpolator pathInterpolator2 = new android.view.animation.PathInterpolator(0.3f, 0.0f, 0.1f, 1.0f);
                if (z3 && !z_renamed) {
                    pathInterpolator = new android.view.animation.PathInterpolator(0.33f, 0.0f, 0.67f, 1.0f);
                } else {
                    pathInterpolator = new android.view.animation.PathInterpolator(0.3f, 0.0f, 0.1f, 1.0f);
                }
                if (z_renamed) {
                    animatorListener = new android.animation.Animator.AnimatorListener() { // from class: com.oplus.camera.ui.preview.ab_renamed.1
                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationRepeat(android.animation.Animator animator) {
                        }

                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationStart(android.animation.Animator animator) {
                            com.oplus.camera.e_renamed.b_renamed("TeleSmallPreviewManager", "showTeleSmallPreviewView, onAnimationStart");
                            if (com.oplus.camera.ui.preview.ab_renamed.this.h_renamed != null) {
                                if (com.oplus.camera.ui.preview.ab_renamed.this.f6983a || com.oplus.camera.ui.preview.ab_renamed.this.h_renamed.getAnimation() == null) {
                                    com.oplus.camera.ui.preview.ab_renamed.this.h_renamed.setVisibility(0);
                                    com.oplus.camera.ui.preview.ab_renamed.this.h_renamed.setTeleSmallPreviewRenderModeDirty(false);
                                } else {
                                    com.oplus.camera.ui.preview.ab_renamed.this.h_renamed.getAnimation().cancel();
                                }
                            }
                        }

                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(android.animation.Animator animator) {
                            com.oplus.camera.e_renamed.b_renamed("TeleSmallPreviewManager", "showTeleSmallPreviewView, onAnimationEnd");
                            if (com.oplus.camera.ui.preview.ab_renamed.this.h_renamed != null) {
                                com.oplus.camera.ui.preview.ab_renamed.this.h_renamed.setTeleSmallPreviewRenderModeDirty(true);
                            }
                        }

                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationCancel(android.animation.Animator animator) {
                            com.oplus.camera.e_renamed.b_renamed("TeleSmallPreviewManager", "showTeleSmallPreviewView, onAnimationCancel");
                            if (com.oplus.camera.ui.preview.ab_renamed.this.h_renamed != null) {
                                com.oplus.camera.ui.preview.ab_renamed.this.h_renamed.setVisibility(4);
                                com.oplus.camera.ui.preview.ab_renamed.this.h_renamed.setTeleSmallPreviewRenderModeDirty(true);
                            }
                        }
                    };
                } else {
                    animatorListener = new android.animation.Animator.AnimatorListener() { // from class: com.oplus.camera.ui.preview.ab_renamed.2
                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationRepeat(android.animation.Animator animator) {
                        }

                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationStart(android.animation.Animator animator) {
                            com.oplus.camera.e_renamed.b_renamed("TeleSmallPreviewManager", "hideTeleSmallPreviewView, onAnimationStart");
                            if (com.oplus.camera.ui.preview.ab_renamed.this.h_renamed != null) {
                                com.oplus.camera.ui.preview.ab_renamed.this.h_renamed.setTeleSmallPreviewRenderModeDirty(false);
                            }
                        }

                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(android.animation.Animator animator) {
                            com.oplus.camera.e_renamed.b_renamed("TeleSmallPreviewManager", "hideTeleSmallPreviewView, onAnimationEnd");
                            if (com.oplus.camera.ui.preview.ab_renamed.this.h_renamed != null) {
                                com.oplus.camera.ui.preview.ab_renamed.this.h_renamed.setVisibility(4);
                                com.oplus.camera.ui.preview.ab_renamed.this.h_renamed.setTeleSmallPreviewRenderModeDirty(true);
                                com.oplus.camera.ui.preview.ab_renamed.this.h_renamed.e_renamed();
                            }
                        }

                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationCancel(android.animation.Animator animator) {
                            com.oplus.camera.e_renamed.b_renamed("TeleSmallPreviewManager", "hideTeleSmallPreviewView, onAnimationCancel");
                            if (com.oplus.camera.ui.preview.ab_renamed.this.h_renamed != null) {
                                com.oplus.camera.ui.preview.ab_renamed.this.h_renamed.setTeleSmallPreviewRenderModeDirty(true);
                            }
                        }
                    };
                }
                if (!z2) {
                    if (z_renamed) {
                        this.h_renamed.setVisibility(0);
                        return;
                    } else {
                        this.h_renamed.setVisibility(4);
                        return;
                    }
                }
                android.animation.AnimatorSet animatorSet = new android.animation.AnimatorSet();
                if (z_renamed) {
                    objectAnimatorOfFloat = android.animation.ObjectAnimator.ofFloat(this.h_renamed, "scaleX", 0.7f, 1.0f);
                    objectAnimatorOfFloat2 = android.animation.ObjectAnimator.ofFloat(this.h_renamed, "scaleY", 0.7f, 1.0f);
                } else {
                    objectAnimatorOfFloat = android.animation.ObjectAnimator.ofFloat(this.h_renamed, "scaleX", 1.0f, 0.7f);
                    objectAnimatorOfFloat2 = android.animation.ObjectAnimator.ofFloat(this.h_renamed, "scaleY", 1.0f, 0.7f);
                }
                animatorSet.setInterpolator(pathInterpolator2);
                animatorSet.addListener(animatorListener);
                animatorSet.setDuration(200L);
                animatorSet.setStartDelay(0L);
                animatorSet.play(objectAnimatorOfFloat).with(objectAnimatorOfFloat2);
                this.h_renamed.clearAnimation();
                this.h_renamed.invalidate();
                this.h_renamed.a_renamed(animatorSet, z_renamed ? 0 : 4, pathInterpolator);
                this.h_renamed.f_renamed();
                return;
            }
        }
        com.oplus.camera.e_renamed.b_renamed("TeleSmallPreviewManager", "showTeleSmallPreviewView, no need to change visibility");
    }

    private android.widget.RelativeLayout.LayoutParams a_renamed(com.oplus.camera.screen.b_renamed.a_renamed aVar) throws android.content.res.Resources.NotFoundException {
        android.util.Size sizeI = com.oplus.camera.util.Util.I_renamed();
        float width = sizeI.getWidth() / sizeI.getHeight();
        int dimensionPixelSize = this.e_renamed.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.fold_tele_small_preview_width);
        android.widget.RelativeLayout.LayoutParams layoutParams = new android.widget.RelativeLayout.LayoutParams(dimensionPixelSize, java.lang.Math.round(dimensionPixelSize * width));
        layoutParams.addRule(12);
        layoutParams.addRule(11);
        if (aVar.q_renamed()) {
            if (1 == this.p_renamed) {
                layoutParams.bottomMargin = com.oplus.camera.util.Util.i_renamed(com.oplus.camera.R_renamed.dimen.fold_rack_low_16_9_tele_small_preview_right_margin);
            } else {
                layoutParams.bottomMargin = com.oplus.camera.util.Util.i_renamed(com.oplus.camera.R_renamed.dimen.fold_rack_tele_small_preview_right_margin);
            }
            layoutParams.rightMargin = com.oplus.camera.util.Util.i_renamed(com.oplus.camera.R_renamed.dimen.fold_rack_low_tele_small_preview_top_margin);
        } else {
            layoutParams.bottomMargin = com.oplus.camera.util.Util.i_renamed(com.oplus.camera.R_renamed.dimen.fold_rack_tele_small_preview_right_margin);
            layoutParams.rightMargin = com.oplus.camera.util.Util.i_renamed(com.oplus.camera.R_renamed.dimen.fold_rack_tele_small_preview_top_margin);
        }
        return layoutParams;
    }

    /* compiled from: TeleSmallPreviewManager.java */
    private class b_renamed extends android.os.Handler {
        public b_renamed(android.os.Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(android.os.Message message) {
            int i_renamed = message.what;
            if (i_renamed == 3) {
                com.oplus.camera.ui.preview.ab_renamed.this.s_renamed = true;
            } else {
                if (i_renamed != 4) {
                    return;
                }
                com.oplus.camera.ui.preview.ab_renamed.this.s_renamed = false;
            }
        }
    }

    /* compiled from: TeleSmallPreviewManager.java */
    private class a_renamed extends android.os.Handler {
        public a_renamed(android.os.Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(android.os.Message message) throws android.content.res.Resources.NotFoundException {
            com.oplus.camera.e_renamed.a_renamed("TeleSmallPreviewManager", "handleMessage, msg: " + message.what);
            int i_renamed = message.what;
            if (i_renamed != 1) {
                if (i_renamed == 2 && com.oplus.camera.ui.preview.ab_renamed.this.f6984b) {
                    com.oplus.camera.ui.preview.ab_renamed.this.f6984b = false;
                    com.oplus.camera.ui.preview.ab_renamed abVar = com.oplus.camera.ui.preview.ab_renamed.this;
                    abVar.b_renamed(false, abVar.f6985c, com.oplus.camera.ui.preview.ab_renamed.this.d_renamed);
                    return;
                }
                return;
            }
            if (com.oplus.camera.ui.preview.ab_renamed.this.f6983a) {
                com.oplus.camera.ui.preview.ab_renamed.this.f6984b = true;
                com.oplus.camera.ui.preview.ab_renamed abVar2 = com.oplus.camera.ui.preview.ab_renamed.this;
                abVar2.b_renamed(true, abVar2.f6985c, com.oplus.camera.ui.preview.ab_renamed.this.d_renamed);
            }
        }
    }

    private void a_renamed(android.widget.RelativeLayout.LayoutParams layoutParams, boolean z_renamed, boolean z2) {
        if (z_renamed) {
            layoutParams.removeRule(9);
            layoutParams.addRule(11);
        } else {
            layoutParams.removeRule(11);
            layoutParams.addRule(9);
        }
        if (z2) {
            layoutParams.removeRule(12);
            layoutParams.addRule(10);
        } else {
            layoutParams.removeRule(10);
            layoutParams.addRule(12);
        }
    }

    public void c_renamed() {
        com.oplus.camera.gl_renamed.u_renamed uVar = this.h_renamed;
        if (uVar != null) {
            uVar.a_renamed();
        }
    }

    public int a_renamed(android.media.Image image) {
        android.hardware.HardwareBuffer hardwareBuffer = image.getHardwareBuffer();
        com.oplus.camera.gl_renamed.u_renamed uVar = this.h_renamed;
        if (uVar != null) {
            return uVar.a_renamed(hardwareBuffer);
        }
        return 0;
    }

    public void d_renamed() throws android.content.res.Resources.NotFoundException {
        if (this.h_renamed == null) {
            h_renamed();
        }
    }

    public void e_renamed() {
        com.oplus.camera.gl_renamed.u_renamed uVar = this.h_renamed;
        if (uVar != null) {
            uVar.d_renamed();
            this.g_renamed.removeView(this.h_renamed);
            this.h_renamed = null;
        }
    }

    public void f_renamed() {
        this.e_renamed = null;
        this.f_renamed = null;
        this.g_renamed = null;
        this.h_renamed = null;
        this.o_renamed = null;
        com.oplus.camera.ui.preview.ab_renamed.b_renamed bVar = this.j_renamed;
        if (bVar != null) {
            bVar.getLooper().quitSafely();
            this.j_renamed = null;
        }
    }
}

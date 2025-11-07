package com.oplus.camera.professional;

/* compiled from: HSProfessionalCapMode.java */
/* loaded from: classes2.dex */
public class h_renamed extends com.oplus.camera.capmode.BaseMode implements android.view.View.OnClickListener, com.oplus.camera.professional.e_renamed.b_renamed {
    private android.os.Handler A_renamed;
    private com.oplus.camera.professional.h_renamed.a_renamed B_renamed;
    private android.content.res.Resources C_renamed;
    private int D_renamed;
    private boolean E_renamed;
    private boolean F_renamed;
    private com.oplus.camera.ui.RotateImageView G_renamed;
    private int H_renamed;
    private android.animation.ValueAnimator I_renamed;
    private int J_renamed;
    private int K_renamed;
    private int L_renamed;
    private int M_renamed;
    private float N_renamed;
    private int O_renamed;
    private boolean P_renamed;
    private boolean Q_renamed;
    private byte[] R_renamed;
    private com.oplus.ocs.camera.CameraPictureCallback.CameraPictureImage S_renamed;
    private boolean T_renamed;
    private boolean U_renamed;
    private int V_renamed;
    private int W_renamed;
    private int X_renamed;
    private int Y_renamed;
    private int Z_renamed;
    private int aa_renamed;
    private int ab_renamed;
    private int ac_renamed;
    private int ad_renamed;
    private byte[] ae_renamed;
    private android.widget.TextView af_renamed;
    private android.animation.ValueAnimator ag_renamed;
    private android.view.animation.PathInterpolator ah_renamed;
    private com.oplus.camera.professional.g_renamed.b_renamed ai_renamed;
    private final java.lang.Object g_renamed;
    private volatile boolean h_renamed;
    private boolean i_renamed;
    private boolean j_renamed;
    private boolean k_renamed;
    private boolean l_renamed;
    private boolean m_renamed;
    private boolean n_renamed;
    private boolean o_renamed;
    private boolean p_renamed;
    private boolean q_renamed;
    private int r_renamed;
    private long s_renamed;
    private java.lang.Thread t_renamed;
    private com.oplus.camera.ui.h_renamed u_renamed;
    private com.oplus.camera.professional.e_renamed v_renamed;
    private com.oplus.camera.professional.g_renamed w_renamed;
    private com.oplus.camera.ui.RotateImageView x_renamed;
    private com.oplus.camera.p_renamed y_renamed;
    private com.oplus.camera.p_renamed.a_renamed z_renamed;

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean allowSwitchCamera() {
        return false;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected boolean canCloseSubMenuWhenSwitchCamera() {
        return false;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public java.lang.String getCameraMode() {
        return com.oplus.camera.aps.constant.ApsConstant.CAPTURE_MODE_PROFESSIONAL;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean getFrontEnable() {
        return false;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public int getOperatingMode() {
        return 32777;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected boolean isInProMode() {
        return true;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void onStop() {
    }

    public h_renamed(android.app.Activity activity, com.oplus.camera.capmode.a_renamed aVar, com.oplus.camera.ui.CameraUIInterface cameraUIInterface, com.oplus.camera.ui.preview.a_renamed.t_renamed tVar) {
        super(activity, aVar, cameraUIInterface, tVar);
        this.g_renamed = new java.lang.Object();
        this.h_renamed = false;
        this.i_renamed = false;
        this.j_renamed = false;
        this.k_renamed = false;
        this.l_renamed = false;
        this.m_renamed = true;
        this.n_renamed = false;
        this.o_renamed = false;
        this.p_renamed = false;
        this.q_renamed = false;
        this.r_renamed = 0;
        this.s_renamed = 0L;
        this.t_renamed = null;
        this.u_renamed = null;
        this.v_renamed = null;
        this.w_renamed = null;
        this.x_renamed = null;
        this.y_renamed = null;
        this.z_renamed = null;
        this.A_renamed = null;
        this.B_renamed = null;
        this.D_renamed = -1;
        this.E_renamed = false;
        this.F_renamed = false;
        this.G_renamed = null;
        this.H_renamed = 0;
        this.I_renamed = null;
        this.J_renamed = 0;
        this.K_renamed = 0;
        this.L_renamed = 0;
        this.M_renamed = 0;
        this.N_renamed = 0.0f;
        this.O_renamed = 0;
        this.P_renamed = false;
        this.Q_renamed = true;
        this.S_renamed = null;
        this.T_renamed = false;
        this.U_renamed = false;
        this.V_renamed = 0;
        this.W_renamed = 0;
        this.X_renamed = 0;
        this.Y_renamed = 0;
        this.Z_renamed = 0;
        this.aa_renamed = 0;
        this.ab_renamed = 0;
        this.ac_renamed = 0;
        this.ad_renamed = 0;
        this.ae_renamed = null;
        this.af_renamed = null;
        this.ag_renamed = null;
        this.ah_renamed = new android.view.animation.PathInterpolator(0.3f, 0.0f, 0.1f, 1.0f);
        this.ai_renamed = new com.oplus.camera.professional.g_renamed.b_renamed() { // from class: com.oplus.camera.professional.h_renamed.14
            @Override // com.oplus.camera.professional.g_renamed.b_renamed
            public void a_renamed(int i_renamed, java.lang.String str, boolean z_renamed) {
                com.oplus.camera.professional.h_renamed.this.a_renamed(i_renamed, str, z_renamed);
            }
        };
        this.C_renamed = activity.getApplicationContext().getResources();
        this.J_renamed = this.C_renamed.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.hs_main_mode_bar_height);
        this.K_renamed = this.C_renamed.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.hs_sub_mode_bar_height);
        this.L_renamed = this.C_renamed.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.hs_sub_mode_hs_panel_container_height);
        this.M_renamed = this.C_renamed.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.hs_sub_mode_hs_panel_container_bottom);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean onSingleTapUp(android.view.MotionEvent motionEvent) {
        com.oplus.camera.e_renamed.a_renamed("HSProfessionalCapMode", "onSingleTapUp");
        if (this.mCameraUIInterface.e_renamed((int) motionEvent.getX(), (int) motionEvent.getY())) {
            return false;
        }
        if (isInPreviewArea(motionEvent) && this.v_renamed.isSelected() && !this.mCameraInterface.A_renamed()) {
            onBackPressed();
        }
        a_renamed(motionEvent);
        return false;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onShareMenuExpand() {
        if (this.v_renamed.isSelected()) {
            this.mCameraInterface.a_renamed(true, true);
            this.mCameraInterface.d_renamed(true);
            com.oplus.camera.professional.u_renamed.a_renamed aVar = new com.oplus.camera.professional.u_renamed.a_renamed();
            aVar.f5239a = false;
            aVar.f5241c = 250;
            aVar.g_renamed = 400;
            aVar.d_renamed = 0.0f;
            aVar.e_renamed = this.mActivity.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.hs_main_mode_bar_item_animation_offset);
            this.w_renamed.setAllPopupInvisibility(aVar);
            this.v_renamed.a_renamed();
            b_renamed(0, true);
            this.mOneCamera.j_renamed(true);
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean onLongPress(android.view.MotionEvent motionEvent) {
        com.oplus.camera.e_renamed.a_renamed("HSProfessionalCapMode", "onLongPress");
        a_renamed(motionEvent);
        return false;
    }

    private void a_renamed(android.view.MotionEvent motionEvent) {
        com.oplus.camera.screen.b_renamed.a_renamed aVarAU;
        android.graphics.Rect rect = new android.graphics.Rect();
        this.mCameraUIInterface.p_renamed().getHitRect(rect);
        if (rect.contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY())) {
            if (1 == getDefaultAFMode() || 4 == getDefaultAFMode()) {
                E_renamed();
                this.w_renamed.setPanelsBarAuto(4);
            }
            if (this.mCameraInterface == null || !isBubbleOpen(com.oplus.camera.ui.CameraUIInterface.KEY_EXPOSURE_FOCUS_SEPARATE_TIPS) || (aVarAU = this.mCameraInterface.aU_renamed()) == null || !aVarAU.a_renamed(this.mCameraUIInterface, (int) motionEvent.getX(), (int) motionEvent.getY())) {
                return;
            }
            com.oplus.camera.e_renamed.a_renamed("HSProfessionalCapMode", "onSingleTapUp, bubble open, KEY_EXPOSURE_FOCUS_SEPARATE_TIPS");
            this.mCameraUIInterface.a_renamed(this.mActivity.findViewById(com.oplus.camera.R_renamed.id_renamed.oplus_setting_bar), 18, (int) motionEvent.getX(), (int) motionEvent.getY());
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onRawImageReceived(com.oplus.ocs.camera.CameraPictureCallback.CameraPictureImage cameraPictureImage) {
        this.S_renamed = cameraPictureImage;
        if (isSuperRawOpen()) {
            synchronized (this.g_renamed) {
                this.T_renamed = true;
            }
            f_renamed();
            return;
        }
        e_renamed();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean consumeImage(com.oplus.ocs.camera.CameraPictureCallback.CameraPictureImage cameraPictureImage) {
        if (!isSuperRawOpen() || 256 != cameraPictureImage.getFormat() || 4 != cameraPictureImage.getSourceType()) {
            return false;
        }
        this.V_renamed = cameraPictureImage.getWidth();
        this.W_renamed = cameraPictureImage.getHeight();
        synchronized (this.g_renamed) {
            this.R_renamed = cameraPictureImage.getImage();
        }
        this.X_renamed = 1;
        this.Y_renamed = 1;
        this.ae_renamed = new byte[this.X_renamed * this.Y_renamed * 3];
        f_renamed();
        return true;
    }

    private void e_renamed() {
        byte[] image = this.S_renamed.getImage();
        com.oplus.camera.g_renamed.a_renamed.e_renamed eVarA = com.oplus.camera.g_renamed.a_renamed.e_renamed.a_renamed(image);
        final long j_renamed = this.mCaptureDate - 10;
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("saveResultToDng, mRawPreviewJpeg : ");
        sb.append(this.R_renamed != null);
        com.oplus.camera.e_renamed.b_renamed("HSProfessionalCapMode", sb.toString());
        if (eVarA != null) {
            if (this.R_renamed != null) {
                eVarA.a_renamed(eVarA.f_renamed, j_renamed);
                eVarA.b_renamed();
                eVarA.f_renamed.a_renamed(this.ae_renamed);
                eVarA.f_renamed.b_renamed(256).a_renamed(new int[]{this.X_renamed});
                eVarA.f_renamed.b_renamed(257).a_renamed(new int[]{this.Y_renamed});
                eVarA.f_renamed.b_renamed(262).a_renamed(new int[]{this.Y_renamed});
                com.oplus.camera.g_renamed.a_renamed.c_renamed cVarA = a_renamed(eVarA.f4554a);
                cVarA.a_renamed(this.R_renamed);
                eVarA.e_renamed.add(cVarA);
                eVarA.d_renamed.add(cVarA);
            }
            eVarA.a_renamed();
            eVarA.a_renamed(eVarA.f_renamed, j_renamed);
            eVarA.a_renamed(eVarA.g_renamed, j_renamed);
            eVarA.d_renamed();
            image = eVarA.j_renamed.array();
        }
        final byte[] bArr = image;
        this.R_renamed = null;
        final int format = this.S_renamed.getFormat();
        this.S_renamed.getTimestamp();
        this.S_renamed = null;
        if (this.mActivity != null) {
            this.mActivity.runOnUiThread(new java.lang.Runnable() { // from class: com.oplus.camera.professional.h_renamed.1
                @Override // java.lang.Runnable
                public void run() {
                    com.oplus.camera.professional.h_renamed.this.pictureTakenCallback(bArr, 0, 0, com.oplus.camera.util.Util.a_renamed(format), true, false, false, j_renamed, 0);
                }
            });
        }
    }

    private com.oplus.camera.g_renamed.a_renamed.c_renamed a_renamed(java.nio.ByteOrder byteOrder) {
        com.oplus.camera.g_renamed.a_renamed.c_renamed cVar = new com.oplus.camera.g_renamed.a_renamed.c_renamed();
        cVar.f4550c = new java.util.ArrayList<>();
        cVar.a_renamed(byteOrder);
        cVar.a_renamed(254, new int[]{1});
        cVar.a_renamed(256, new int[]{this.V_renamed});
        cVar.a_renamed(257, new int[]{this.W_renamed});
        cVar.a_renamed(258, new int[]{8, 8, 8});
        cVar.a_renamed(259, new int[]{7});
        cVar.a_renamed(262, new int[]{6});
        cVar.a_renamed(273, new int[]{0});
        cVar.a_renamed(277, new int[]{3});
        cVar.a_renamed(278, new int[]{this.W_renamed});
        cVar.a_renamed(279, new int[]{this.R_renamed.length});
        cVar.a_renamed(284, new int[]{1});
        cVar.a_renamed(529, new int[]{1});
        cVar.a_renamed(530, new int[]{1, 1});
        cVar.a_renamed(531, new int[]{2});
        cVar.a_renamed(532, new int[]{1});
        return cVar;
    }

    private void f_renamed() {
        synchronized (this.g_renamed) {
            if (this.R_renamed != null && this.T_renamed) {
                e_renamed();
            }
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode, com.oplus.camera.e_renamed.d_renamed.a_renamed
    public void onCaptureStarted(android.hardware.camera2.CameraCaptureSession cameraCaptureSession, android.hardware.camera2.CaptureRequest captureRequest, long j_renamed, long j2) {
        com.oplus.camera.professional.g_renamed gVar;
        super.onCaptureStarted(cameraCaptureSession, captureRequest, j_renamed, j2);
        if (this.mCameraUIInterface == null || (gVar = this.w_renamed) == null || gVar.g_renamed(5) || com.oplus.camera.util.Util.C_renamed() || !isFlashState()) {
            return;
        }
        this.mCameraUIInterface.c_renamed().b_renamed(j2, j_renamed);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean needDelayCloseForCapture() {
        if (com.google.android.exoplayer2.C_renamed.NANOS_PER_SECOND <= java.lang.Long.parseLong(i_renamed())) {
            return false;
        }
        return super.needDelayCloseForCapture();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onCameraPermissionGranted() throws android.content.res.Resources.NotFoundException, java.lang.NumberFormatException {
        this.D_renamed = this.mCameraInterface.as_renamed();
        com.oplus.camera.professional.g_renamed gVar = this.w_renamed;
        if (gVar != null) {
            if (this.F_renamed) {
                gVar.a_renamed(getCameraInfo(this.D_renamed), (com.oplus.camera.professional.g_renamed.a_renamed) null);
                if (isSuperRawOpen()) {
                    this.w_renamed.a_renamed(getCameraInfo(this.D_renamed), 2000000000L);
                }
                this.w_renamed.a_renamed();
                return;
            }
            gVar.a_renamed(getCameraInfo(this.D_renamed), this.A_renamed, (com.oplus.camera.professional.g_renamed.a_renamed) null);
            if (isSuperRawOpen()) {
                this.w_renamed.a_renamed(getCameraInfo(this.D_renamed), 2000000000L);
            }
            m_renamed();
            this.w_renamed.setSettleListener(this.v_renamed);
            this.w_renamed.setMotionListener(this.ai_renamed);
            com.oplus.camera.professional.h_renamed.a_renamed aVar = this.B_renamed;
            if (aVar != null) {
                aVar.setVisibility(0);
            }
            this.mCameraInterface.d_renamed(true);
            a_renamed(1);
            this.F_renamed = true;
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public java.lang.String getCameraFeature() {
        if (this.mbDestroyed) {
            return null;
        }
        return this.mPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_FOCUS_PEAKING, "off").equals("on_renamed") ? com.oplus.camera.aps.constant.ApsConstant.FEATURE_FOCUS_PEAKING : super.getCameraFeature();
    }

    public boolean a_renamed(java.lang.String str, java.util.List<java.lang.String> list) {
        return list != null && list.indexOf(str) >= 0;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void onInitCameraMode() throws android.content.res.Resources.NotFoundException, java.lang.NumberFormatException {
        com.oplus.camera.e_renamed.a_renamed("HSProfessionalCapMode", "onInitCameraMode, Start");
        restoreProPreference();
        com.oplus.camera.professional.c_renamed.a_renamed();
        if (isNightProModeSupport()) {
            this.E_renamed = true;
        }
        this.P_renamed = false;
        this.Q_renamed = true;
        this.i_renamed = "on_renamed".equals(this.mPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_HIGH_RESOLUTION, this.C_renamed.getString(com.oplus.camera.R_renamed.string.camera_high_resolution_default_value)));
        if (!this.i_renamed) {
            this.mCameraUIInterface.b_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_HIGH_RESOLUTION, "off");
        }
        if (this.u_renamed == null) {
            this.u_renamed = new com.oplus.camera.ui.h_renamed(this.mCameraUIInterface, new com.oplus.camera.ui.h_renamed.a_renamed() { // from class: com.oplus.camera.professional.h_renamed.12
                @Override // com.oplus.camera.ui.h_renamed.a_renamed
                public void a_renamed(boolean z_renamed) {
                    com.oplus.camera.professional.h_renamed.this.mCameraUIInterface.g_renamed(true);
                    if (z_renamed) {
                        return;
                    }
                    com.oplus.camera.ui.control.b_renamed shutterButtonInfo = com.oplus.camera.professional.h_renamed.this.getShutterButtonInfo();
                    shutterButtonInfo.a_renamed(14);
                    com.oplus.camera.professional.h_renamed.this.mCameraUIInterface.a_renamed(shutterButtonInfo);
                }

                @Override // com.oplus.camera.ui.h_renamed.a_renamed
                public void a_renamed() {
                    if (com.oplus.camera.professional.h_renamed.this.mbPaused) {
                        return;
                    }
                    com.oplus.camera.professional.h_renamed.this.u_renamed.e_renamed();
                }
            });
        }
        if (this.A_renamed == null) {
            this.A_renamed = new android.os.Handler() { // from class: com.oplus.camera.professional.h_renamed.16
                @Override // android.os.Handler
                public void handleMessage(android.os.Message message) {
                    com.oplus.camera.professional.h_renamed.this.a_renamed(message.what, message);
                }
            };
        }
        if (com.google.android.exoplayer2.C_renamed.NANOS_PER_SECOND <= java.lang.Long.parseLong(i_renamed())) {
            this.mCameraUIInterface.a_renamed(getShutterButtonInfo());
        }
        this.mCameraUIInterface.c_renamed(this.mActivity.getString(com.oplus.camera.R_renamed.string.camera_description_common_shutter_button));
        o_renamed();
        if (this.w_renamed != null) {
            if (z_renamed()) {
                this.w_renamed.e_renamed();
            } else {
                this.w_renamed.setVisibility(0);
            }
        }
        if (this.v_renamed != null) {
            int i_renamed = z_renamed() ? 8 : 0;
            this.v_renamed.setAlpha(0.0f);
            this.v_renamed.setVisibility(i_renamed);
        }
        g_renamed();
    }

    private void g_renamed() {
        com.oplus.camera.ui.a_renamed.a_renamed aVarK = this.mCameraUIInterface.k_renamed();
        if (aVarK != null) {
            aVarK.a_renamed(new com.oplus.camera.ui.a_renamed.a_renamed.b_renamed() { // from class: com.oplus.camera.professional.h_renamed.17
                @Override // com.oplus.camera.ui.a_renamed.a_renamed.b_renamed
                public void a_renamed(com.oplus.camera.ui.a_renamed.b_renamed bVar) {
                    if (!com.oplus.camera.professional.h_renamed.this.isHistogramOpen() || 270 == com.oplus.camera.professional.h_renamed.this.mOrientation || com.oplus.camera.professional.h_renamed.this.y_renamed == null) {
                        return;
                    }
                    com.oplus.camera.professional.h_renamed.this.Z_renamed = bVar.f5839a;
                    com.oplus.camera.professional.h_renamed.this.af_renamed.setText(com.oplus.camera.professional.h_renamed.this.mActivity.getResources().getString(com.oplus.camera.professional.h_renamed.this.Z_renamed));
                    com.oplus.camera.professional.h_renamed.this.af_renamed.getViewTreeObserver().addOnGlobalLayoutListener(new android.view.ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.oplus.camera.professional.h_renamed.17.1
                        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                        public void onGlobalLayout() throws android.content.res.Resources.NotFoundException {
                            com.oplus.camera.professional.h_renamed.this.af_renamed.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                            int height = ("square".equals(com.oplus.camera.professional.h_renamed.this.mPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_PHOTO_RATIO, com.oplus.camera.professional.h_renamed.this.mActivity.getString(com.oplus.camera.R_renamed.string.camera_photo_ratio_default_value))) && com.oplus.camera.professional.h_renamed.this.mOrientation % 180 == 0) ? com.oplus.camera.professional.h_renamed.this.af_renamed.getHeight() - com.oplus.camera.professional.h_renamed.this.ac_renamed : com.oplus.camera.professional.h_renamed.this.af_renamed.getHeight() + com.oplus.camera.professional.h_renamed.this.ab_renamed;
                            if (com.oplus.camera.professional.h_renamed.this.U_renamed) {
                                com.oplus.camera.professional.h_renamed.this.U_renamed = false;
                                com.oplus.camera.professional.h_renamed.this.d_renamed(height);
                                com.oplus.camera.professional.h_renamed.this.y_renamed.a_renamed(com.oplus.camera.professional.h_renamed.this.z_renamed, false, false);
                            } else if (com.oplus.camera.professional.h_renamed.this.aa_renamed != height) {
                                com.oplus.camera.professional.h_renamed.this.a_renamed(com.oplus.camera.professional.h_renamed.this.aa_renamed, height);
                            }
                            com.oplus.camera.professional.h_renamed.this.aa_renamed = height;
                        }
                    });
                }

                @Override // com.oplus.camera.ui.a_renamed.a_renamed.b_renamed
                public void a_renamed(int i_renamed) throws android.content.res.Resources.NotFoundException {
                    if (i_renamed == com.oplus.camera.professional.h_renamed.this.Z_renamed) {
                        com.oplus.camera.professional.h_renamed.this.aa_renamed = 0;
                    }
                    if (!com.oplus.camera.professional.h_renamed.this.isHistogramOpen() || 270 == com.oplus.camera.professional.h_renamed.this.mOrientation || com.oplus.camera.professional.h_renamed.this.y_renamed == null || i_renamed != com.oplus.camera.professional.h_renamed.this.Z_renamed) {
                        return;
                    }
                    if (com.oplus.camera.professional.h_renamed.this.ag_renamed != null && com.oplus.camera.professional.h_renamed.this.ag_renamed.isRunning()) {
                        com.oplus.camera.professional.h_renamed.this.ag_renamed.cancel();
                    }
                    com.oplus.camera.professional.h_renamed.this.d_renamed(0);
                    com.oplus.camera.professional.h_renamed.this.y_renamed.a_renamed(com.oplus.camera.professional.h_renamed.this.z_renamed, com.oplus.camera.professional.h_renamed.this.A_renamed(), com.oplus.camera.professional.h_renamed.this.B_renamed(), 150L);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a_renamed(int i_renamed, int i2) {
        android.animation.ValueAnimator valueAnimator = this.ag_renamed;
        if (valueAnimator == null) {
            this.ag_renamed = android.animation.ValueAnimator.ofInt(0, i2);
            this.ag_renamed.setDuration(350L);
            this.ag_renamed.setInterpolator(this.ah_renamed);
            this.ag_renamed.addUpdateListener(new android.animation.ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.professional.h_renamed.18
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(android.animation.ValueAnimator valueAnimator2) throws android.content.res.Resources.NotFoundException {
                    com.oplus.camera.professional.h_renamed.this.d_renamed(((java.lang.Integer) valueAnimator2.getAnimatedValue()).intValue());
                    if (com.oplus.camera.professional.h_renamed.this.y_renamed != null) {
                        com.oplus.camera.professional.h_renamed.this.y_renamed.a_renamed(com.oplus.camera.professional.h_renamed.this.z_renamed, com.oplus.camera.professional.h_renamed.this.A_renamed(), com.oplus.camera.professional.h_renamed.this.B_renamed());
                    }
                }
            });
            this.ag_renamed.addListener(new com.oplus.camera.b_renamed.a_renamed() { // from class: com.oplus.camera.professional.h_renamed.19
                @Override // com.oplus.camera.b_renamed.a_renamed, android.animation.Animator.AnimatorListener
                public void onAnimationCancel(android.animation.Animator animator) throws android.content.res.Resources.NotFoundException {
                    super.onAnimationCancel(animator);
                    com.oplus.camera.professional.h_renamed.this.d_renamed(0);
                    if (com.oplus.camera.professional.h_renamed.this.y_renamed != null) {
                        com.oplus.camera.professional.h_renamed.this.y_renamed.a_renamed(com.oplus.camera.professional.h_renamed.this.z_renamed, com.oplus.camera.professional.h_renamed.this.A_renamed(), com.oplus.camera.professional.h_renamed.this.B_renamed());
                    }
                }
            });
        } else {
            valueAnimator.setIntValues(i_renamed, i2);
        }
        if (this.ag_renamed.isRunning()) {
            return;
        }
        this.ag_renamed.start();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onZoomMenuCollapsing() {
        com.oplus.camera.professional.e_renamed eVar = this.v_renamed;
        if (eVar != null) {
            eVar.a_renamed(true, true);
            if (this.v_renamed.isSelected()) {
                b_renamed(4, true);
            } else {
                if (isPanelMode()) {
                    return;
                }
                this.mCameraUIInterface.a_renamed(0, 1);
            }
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onZoomMenuCollapsed() {
        if (!this.mCameraInterface.A_renamed() && !this.mbInCapturing) {
            this.B_renamed.setEnabled(true);
        } else {
            this.k_renamed = true;
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onZoomMenuExpand() {
        com.oplus.camera.professional.e_renamed eVar = this.v_renamed;
        if (eVar != null) {
            eVar.a_renamed(false, true);
        }
        this.B_renamed.setEnabled(false);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onZoomTransitionChanged(int i_renamed) {
        int zoomBarOffset = i_renamed - getZoomBarOffset();
        if (this.v_renamed != null) {
            float f_renamed = this.N_renamed;
            if (zoomBarOffset <= (-getZoomBarOffset()) / 2) {
                f_renamed = 0.0f;
            }
            this.v_renamed.setAlpha(f_renamed);
            android.widget.RelativeLayout.LayoutParams layoutParams = (android.widget.RelativeLayout.LayoutParams) this.v_renamed.getLayoutParams();
            layoutParams.bottomMargin = this.K_renamed + this.M_renamed;
            this.v_renamed.setLayoutParams(layoutParams);
            if (this.J_renamed == getZoomBarOffset()) {
                this.v_renamed.setBackgroundResource(com.oplus.camera.R_renamed.drawable.main_bar_bg_grad);
            } else {
                this.v_renamed.setBackgroundResource(0);
            }
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onZoomAlphaChanged(float f_renamed) {
        this.N_renamed = f_renamed;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void updateControlPanelBgColor(int i_renamed) {
        if (this.v_renamed != null) {
            if ((this.O_renamed > i_renamed || i_renamed == 0) && 1.0d != getTargetPreviewRatio(this.mOneCamera.e_renamed())) {
                this.v_renamed.setBackgroundResource(com.oplus.camera.R_renamed.drawable.main_bar_bg_grad);
            } else {
                this.v_renamed.setBackgroundColor(com.oplus.camera.util.c_renamed.a_renamed(i_renamed));
            }
        }
        this.O_renamed = i_renamed;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean getZSLMode() {
        this.i_renamed = "on_renamed".equals(this.mPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_HIGH_RESOLUTION, this.C_renamed.getString(com.oplus.camera.R_renamed.string.camera_high_resolution_default_value)));
        com.oplus.camera.professional.g_renamed gVar = this.w_renamed;
        if ((gVar != null && !gVar.g_renamed(2)) || isRawOpen()) {
            com.oplus.camera.e_renamed.a_renamed("HSProfessionalCapMode", "getZSLMode exposure time isn't_renamed auto or raw open,so return false");
            return false;
        }
        if (this.i_renamed) {
            return true;
        }
        return getLogicCameraType() == 0 && com.oplus.camera.util.Util.C_renamed();
    }

    private android.util.Size a_renamed(com.oplus.camera.e_renamed.h_renamed hVar) {
        java.util.List<android.util.Size> configSizeListValue = com.oplus.camera.aps.config.CameraConfig.getConfigSizeListValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_DEFAULT_SENSOR_SIZE_SCALE);
        if (configSizeListValue == null || configSizeListValue.size() <= 0) {
            return null;
        }
        double width = configSizeListValue.get(0).getWidth() / configSizeListValue.get(0).getHeight();
        if (0.002d < java.lang.Math.abs(width - 1.3333333333333333d)) {
            return com.oplus.camera.util.Util.b_renamed(hVar.a_renamed(256), width);
        }
        return null;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public android.util.Size getPictureSize(com.oplus.camera.e_renamed.h_renamed hVar) {
        android.util.Size sizeA;
        return (!"camera_ultra_wide".equals(this.mPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_SWITCH_CAMERA, "camera_main")) || (sizeA = a_renamed(hVar)) == null) ? super.getPictureSize(hVar) : sizeA;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean needSurface(java.lang.String str) {
        if ("type_still_capture_raw".equals(str)) {
            return (getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_RAW_CONTROL) || getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_SUPER_RAW_CONTROL)) && !com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_DISABLE_RAW);
        }
        if ("type_still_capture_jpeg".equals(str)) {
            return !com.oplus.camera.aps.util.AlgoSwitchConfig.getSupportApsCapture();
        }
        if ("type_tuning_data_raw".equals(str)) {
            if (com.oplus.camera.util.Util.C_renamed() || !com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_TUNING_DATA_BUFFER_SUPPORT)) {
                return false;
            }
            return getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_RAW_CONTROL) || getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_SUPER_RAW_CONTROL);
        }
        if ("type_preview_frame".equals(str)) {
            return true;
        }
        return super.needSurface(str);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean isRawOpen() {
        return (getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_RAW_CONTROL) && !"off".equals(this.mPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_RAW_CONTROL, "off"))) || (getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_SUPER_RAW_CONTROL) && !"off".equals(this.mPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_SUPER_RAW_CONTROL, "off")));
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected boolean isSuperRawOpen() {
        return getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_SUPER_RAW_CONTROL) && "super_raw".equals(this.mPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_SUPER_RAW_CONTROL, "off"));
    }

    protected boolean a_renamed() {
        return com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_PROFESSIONAL_MUTEX_ZOOM_SUPPORT);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean isRawRequestTag() {
        return this.mbRawRequestTag;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onMenuOptionAdded(java.lang.String str) {
        if (com.oplus.camera.ui.CameraUIInterface.KEY_SUPER_RAW_CONTROL.equals(str) && this.mCameraUIInterface.ag_renamed()) {
            this.mCameraUIInterface.a_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_SUPER_RAW_CONTROL, true, (int) this.C_renamed.getDimension(com.oplus.camera.R_renamed.dimen.super_raw_setting_menu_reddot_offset_x), (int) this.C_renamed.getDimension(com.oplus.camera.R_renamed.dimen.super_raw_setting_menu_reddot_offset_y));
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void closeImageReader() {
        com.oplus.camera.e_renamed.a_renamed("HSProfessionalCapMode", "closeImageReader");
        this.m_renamed = true;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public java.util.List<java.lang.String> onGetSupportSettingList(java.lang.String str, int i_renamed) {
        if (com.oplus.camera.ui.CameraUIInterface.KEY_CAMERA_TIMER_SHUTTER.equals(str)) {
            java.util.List<java.lang.String> supportSettingList = getSupportSettingList(str, i_renamed);
            java.util.ArrayList arrayList = new java.util.ArrayList();
            if (supportSettingList != null) {
                arrayList.addAll(supportSettingList);
            }
            if (arrayList.size() > 0) {
                return arrayList;
            }
            return null;
        }
        if (com.oplus.camera.ui.CameraUIInterface.KEY_PHOTO_RATIO.equals(str)) {
            java.util.List<java.lang.String> supportedList = com.oplus.camera.aps.config.CameraConfig.getSupportedList(com.oplus.camera.ui.CameraUIInterface.KEY_PHOTO_RATIO, i_renamed);
            java.util.ArrayList arrayList2 = new java.util.ArrayList();
            if (supportedList != null && supportedList.contains("standard")) {
                arrayList2.add("standard");
            }
            if (arrayList2.size() > 0) {
                return arrayList2;
            }
            return null;
        }
        if (com.oplus.camera.ui.CameraUIInterface.KEY_FLASH_MODE.equals(str)) {
            java.util.List<java.lang.String> supportSettingList2 = getSupportSettingList(com.oplus.camera.ui.CameraUIInterface.KEY_FLASH_MODE, this.mCameraId);
            java.util.ArrayList arrayList3 = new java.util.ArrayList();
            if (supportSettingList2 != null) {
                arrayList3.addAll(supportSettingList2);
            }
            if (arrayList3.size() > 0) {
                return arrayList3;
            }
            return null;
        }
        return super.onGetSupportSettingList(str, i_renamed);
    }

    private boolean h_renamed() {
        return (getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_PARAMETER_SAVING) || getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_FOCUS_PEAKING)) ? false : true;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean getSupportMenu(java.lang.String str) {
        if (com.oplus.camera.ui.CameraUIInterface.KEY_FLASH_MODE.equals(str)) {
            return true;
        }
        if (com.oplus.camera.ui.CameraUIInterface.KEY_SWITCH_DUAL_CAMERA.equals(str) || com.oplus.camera.ui.CameraUIInterface.KEY_RAW.equals(str) || com.oplus.camera.ui.CameraUIInterface.KEY_HIGH_RESOLUTION.equals(str) || com.oplus.camera.ui.CameraUIInterface.KEY_PHOTO_RATIO.equals(str) || com.oplus.camera.ui.CameraUIInterface.KEY_CAMERA_TIMER_SHUTTER.equals(str) || com.oplus.camera.ui.CameraUIInterface.KEY_SETTING.equals(str) || com.oplus.camera.ui.CameraUIInterface.KEY_SWITCH_CAMERA.equals(str) || com.oplus.camera.ui.CameraUIInterface.KEY_PARAMETER_SAVING.equals(str) || com.oplus.camera.ui.CameraUIInterface.KEY_FOCUS_PEAKING.equals(str) || com.oplus.camera.ui.CameraUIInterface.KEY_PRO_HISTOGRAM.equals(str) || com.oplus.camera.ui.CameraUIInterface.KEY_SUB_SETTING.equals(str)) {
            return getSupportFunction(str);
        }
        if (com.oplus.camera.ui.CameraUIInterface.KEY_RAW_CONTROL.equals(str) || com.oplus.camera.ui.CameraUIInterface.KEY_SUPER_RAW_CONTROL.equals(str)) {
            return getSupportFunction(str) && h_renamed();
        }
        return super.getSupportMenu(str);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean getSupportSubMenu(java.lang.String str) {
        if (com.oplus.camera.ui.CameraUIInterface.KEY_CAMERA_TIMER_SHUTTER.equals(str) || com.oplus.camera.ui.CameraUIInterface.KEY_PHOTO_RATIO.equals(str) || com.oplus.camera.ui.CameraUIInterface.KEY_SETTING.equals(str)) {
            return getSupportFunction(str);
        }
        return (com.oplus.camera.ui.CameraUIInterface.KEY_RAW_CONTROL.equals(str) || com.oplus.camera.ui.CameraUIInterface.KEY_SUPER_RAW_CONTROL.equals(str)) && getSupportFunction(str) && !h_renamed();
    }

    public int b_renamed() {
        return this.mCameraInterface.u_renamed();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public java.lang.String i_renamed() {
        return this.mPreferences == null ? "-1" : this.mPreferences.getString("pref_professional_exposure_time_key", "-1");
    }

    private long j_renamed() {
        return java.lang.Long.parseLong(this.mPreferences.getString("pref_professional_exposure_time_key", this.C_renamed.getString(com.oplus.camera.R_renamed.string.camera_exposure_time_default_value)));
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public int getCaptureIso() {
        java.lang.String string = this.mPreferences.getString("pref_professional_iso_key", this.C_renamed.getString(com.oplus.camera.R_renamed.string.camera_iso_default_value));
        if (this.C_renamed.getString(com.oplus.camera.R_renamed.string.camera_iso_default_value).equals(string)) {
            return this.r_renamed;
        }
        return java.lang.Integer.parseInt(string);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public long getCaptureExposureTime() throws java.lang.NumberFormatException {
        long j_renamed = java.lang.Long.parseLong(i_renamed());
        return -1 == j_renamed ? this.s_renamed : j_renamed;
    }

    private int a_renamed(int i_renamed, java.util.ArrayList<java.lang.String> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            return -1;
        }
        int iAbs = java.lang.Math.abs(java.lang.Integer.parseInt(arrayList.get(0)) - i_renamed);
        int i2 = 0;
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            int i4 = java.lang.Integer.parseInt(arrayList.get(i3)) - i_renamed;
            if (java.lang.Math.abs(i4) < iAbs) {
                iAbs = java.lang.Math.abs(i4);
                i2 = i3;
            }
        }
        return i2;
    }

    private int a_renamed(float f_renamed, java.util.ArrayList<java.lang.String> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            return -1;
        }
        float fAbs = java.lang.Math.abs(java.lang.Float.parseFloat(arrayList.get(0)) - f_renamed);
        int i_renamed = 0;
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            float f2 = java.lang.Float.parseFloat(arrayList.get(i2)) - f_renamed;
            if (java.lang.Math.abs(f2) < fAbs) {
                fAbs = java.lang.Math.abs(f2);
                i_renamed = i2;
            }
        }
        return i_renamed;
    }

    private int a_renamed(long j_renamed, java.util.ArrayList<java.lang.String> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            return -1;
        }
        long jAbs = java.lang.Math.abs(java.lang.Long.parseLong(arrayList.get(0)) - j_renamed);
        int i_renamed = 0;
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            long j2 = java.lang.Long.parseLong(arrayList.get(i2)) - j_renamed;
            if (java.lang.Math.abs(j2) < jAbs) {
                jAbs = java.lang.Math.abs(j2);
                i_renamed = i2;
            }
        }
        return i_renamed;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onPreviewCaptureResult(com.oplus.ocs.camera.CameraPreviewCallback.CameraPreviewResult cameraPreviewResult) {
        android.hardware.camera2.CaptureResult.Key<int[]> key;
        int iA;
        int iA2;
        int iA3;
        int iA4;
        super.onPreviewCaptureResult(cameraPreviewResult);
        if (this.mbCapModeInit) {
            if (cameraPreviewResult == null || cameraPreviewResult.getCaptureResult() == null) {
                com.oplus.camera.e_renamed.f_renamed("HSProfessionalCapMode", "onPreviewCaptureResult, invalid totalResult: " + cameraPreviewResult);
                return;
            }
            android.hardware.camera2.CaptureResult captureResult = cameraPreviewResult.getCaptureResult();
            if (com.oplus.camera.util.Util.C_renamed()) {
                key = com.oplus.camera.e_renamed.b_renamed.T_renamed;
            } else {
                key = com.oplus.camera.e_renamed.b_renamed.ah_renamed;
            }
            java.lang.Integer num = (java.lang.Integer) captureResult.get(android.hardware.camera2.CaptureResult.SENSOR_SENSITIVITY);
            java.lang.Long l_renamed = (java.lang.Long) captureResult.get(android.hardware.camera2.CaptureResult.SENSOR_EXPOSURE_TIME);
            java.lang.Float f_renamed = (java.lang.Float) captureResult.get(android.hardware.camera2.CaptureResult.LENS_FOCUS_DISTANCE);
            int i_renamed = 0;
            if (key != null) {
                try {
                    i_renamed = ((int[]) captureResult.get(key))[0];
                } catch (java.lang.Exception e_renamed) {
                    e_renamed.printStackTrace();
                }
            }
            if (num != null && this.w_renamed.g_renamed(1) && (iA4 = a_renamed(num.intValue(), this.w_renamed.c_renamed(1))) > -1 && (!this.w_renamed.a_renamed(1, iA4) || !this.n_renamed)) {
                com.oplus.camera.e_renamed.b_renamed("HSProfessionalCapMode", "onPreviewCaptureResult, iso: " + num);
                this.r_renamed = num.intValue();
                java.util.ArrayList<java.lang.String> arrayListD = this.w_renamed.d_renamed(1);
                if (arrayListD != null && arrayListD.size() > iA4) {
                    java.lang.String str = arrayListD.get(iA4);
                    com.oplus.camera.professional.c_renamed.a_renamed("pref_professional_iso_key", str);
                    this.w_renamed.scrollTo(1, iA4);
                    a_renamed(1, str);
                }
            }
            if (l_renamed != null && this.w_renamed.g_renamed(2) && (iA3 = a_renamed(l_renamed.longValue(), this.w_renamed.c_renamed(2))) > -1 && (!this.w_renamed.a_renamed(2, iA3) || !this.n_renamed)) {
                com.oplus.camera.e_renamed.b_renamed("HSProfessionalCapMode", "onPreviewCaptureResult, exposureTime: " + l_renamed);
                this.s_renamed = l_renamed.longValue();
                java.util.ArrayList<java.lang.String> arrayListD2 = this.w_renamed.d_renamed(2);
                if (arrayListD2 != null && arrayListD2.size() > iA3) {
                    java.lang.String str2 = arrayListD2.get(iA3);
                    com.oplus.camera.professional.c_renamed.a_renamed("pref_professional_exposure_time_key", str2);
                    this.w_renamed.scrollTo(2, iA3);
                    a_renamed(2, str2);
                }
            }
            if (this.w_renamed.g_renamed(5) && (iA2 = a_renamed(i_renamed, this.w_renamed.c_renamed(5))) > -1 && (!this.w_renamed.a_renamed(5, iA2) || !this.n_renamed)) {
                com.oplus.camera.e_renamed.b_renamed("HSProfessionalCapMode", "onPreviewCaptureResult, cct: " + i_renamed);
                java.util.ArrayList<java.lang.String> arrayListD3 = this.w_renamed.d_renamed(5);
                if (arrayListD3 != null && arrayListD3.size() > iA2) {
                    java.lang.String str3 = arrayListD3.get(iA2);
                    com.oplus.camera.professional.c_renamed.a_renamed("pref_professional_whitebalance_key", str3);
                    this.w_renamed.scrollTo(5, iA2);
                    a_renamed(5, str3);
                }
            }
            if (f_renamed != null && this.w_renamed.g_renamed(4) && (iA = a_renamed(f_renamed.floatValue(), this.w_renamed.c_renamed(4))) > -1 && (!this.w_renamed.a_renamed(4, iA) || !this.n_renamed)) {
                com.oplus.camera.e_renamed.b_renamed("HSProfessionalCapMode", "onPreviewCaptureResult, focusDistance: " + f_renamed);
                java.util.ArrayList<java.lang.String> arrayListD4 = this.w_renamed.d_renamed(4);
                if (arrayListD4 != null && arrayListD4.size() > iA) {
                    java.lang.String str4 = arrayListD4.get(iA);
                    com.oplus.camera.professional.c_renamed.a_renamed("pref_professional_focus_mode_key", str4);
                    this.w_renamed.scrollTo(4, iA);
                    a_renamed(4, str4);
                }
            }
            this.n_renamed = true;
        }
    }

    /* JADX WARN: Can't_renamed fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B_renamed:95:0x0164  */
    @Override // com.oplus.camera.capmode.BaseMode
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean getSupportFunction(java.lang.String r11) {
        /*
            Method dump skipped, instructions count: 880
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.professional.h_renamed.getSupportFunction(java.lang.String):boolean");
    }

    private void a_renamed(com.oplus.camera.professional.e_renamed eVar, int i_renamed, com.oplus.camera.professional.d_renamed dVar, com.oplus.camera.professional.e_renamed.b_renamed bVar) throws android.content.res.Resources.NotFoundException {
        if (eVar != null) {
            eVar.setId(i_renamed);
            eVar.setAdapter(dVar);
            eVar.setOnItemClickListener(bVar);
        }
    }

    private void k_renamed() throws java.lang.NumberFormatException {
        if (this.mOneCamera != null) {
            if (this.i_renamed) {
                this.mOneCamera.a_renamed(java.lang.Long.parseLong(this.C_renamed.getString(com.oplus.camera.R_renamed.string.camera_exposure_time_default_value)));
                this.mOneCamera.a_renamed(java.lang.Long.parseLong(this.C_renamed.getString(com.oplus.camera.R_renamed.string.camera_exposure_time_default_value)), false);
            } else {
                java.lang.String strA = com.oplus.camera.professional.x_renamed.a_renamed(this.mActivity, 5);
                if (this.mPreferences.getString("pref_professional_whitebalance_key", strA).equals(strA)) {
                    a_renamed(false);
                } else {
                    e_renamed(false);
                }
                a_renamed((java.lang.String) null);
                if (z_renamed()) {
                    this.mOneCamera.a_renamed((android.hardware.camera2.CaptureRequest.Key<android.hardware.camera2.CaptureRequest.Key>) android.hardware.camera2.CaptureRequest.CONTROL_AE_EXPOSURE_COMPENSATION, (android.hardware.camera2.CaptureRequest.Key) java.lang.Integer.valueOf(com.oplus.camera.a_renamed.c_renamed()));
                } else {
                    this.mOneCamera.a_renamed((android.hardware.camera2.CaptureRequest.Key<android.hardware.camera2.CaptureRequest.Key>) android.hardware.camera2.CaptureRequest.CONTROL_AE_EXPOSURE_COMPENSATION, (android.hardware.camera2.CaptureRequest.Key) java.lang.Integer.valueOf(c_renamed()));
                }
                a_renamed((java.lang.String) null, false);
                f_renamed(false);
            }
            a_renamed(3);
        }
    }

    private void b_renamed(boolean z_renamed) throws java.lang.NumberFormatException {
        c_renamed(z_renamed);
        a_renamed(3);
        this.E_renamed = false;
        this.mPreferences.edit().remove(com.oplus.camera.ui.CameraUIInterface.KEY_RESTORE_PROFESSIONAL_PARAMS).apply();
    }

    public void a_renamed(int i_renamed) {
        if (java.lang.Thread.currentThread() != this.t_renamed) {
            android.os.Handler handler = this.A_renamed;
            if (handler != null) {
                handler.sendEmptyMessage(i_renamed);
                return;
            }
            return;
        }
        a_renamed(i_renamed, (android.os.Message) null);
    }

    public void a_renamed(int i_renamed, android.os.Message message) {
        switch (i_renamed) {
            case 1:
                if (this.v_renamed.isSelected()) {
                    int selectedPosition = this.v_renamed.getSelectedPosition();
                    this.v_renamed.a_renamed(selectedPosition, true);
                    android.view.View childAt = this.v_renamed.getChildAt(selectedPosition);
                    if (childAt != null && this.w_renamed.g_renamed(this.v_renamed.a_renamed(childAt))) {
                        this.v_renamed.getAdapter().a_renamed(childAt, 0, true);
                    }
                }
                this.w_renamed.a_renamed();
                break;
            case 2:
                java.lang.Float fValueOf = java.lang.Float.valueOf(0.0f);
                if (message != null) {
                    fValueOf = (java.lang.Float) message.obj;
                }
                this.mCameraInterface.ac_renamed();
                if (this.mOneCamera != null) {
                    if (this.mCameraInterface.z_renamed()) {
                        this.mCameraInterface.b_renamed(false, false);
                    }
                    this.mOneCamera.a_renamed(fValueOf.floatValue(), true);
                    break;
                }
                break;
            case 3:
                this.w_renamed.h_renamed(5);
                this.w_renamed.h_renamed(1);
                this.w_renamed.h_renamed(2);
                this.w_renamed.h_renamed(3);
                this.w_renamed.h_renamed(4);
                w_renamed();
                break;
            case 4:
                E_renamed();
                this.w_renamed.setPanelsBarAuto(4);
                break;
            case 5:
                if (!this.l_renamed && !this.mCameraInterface.A_renamed()) {
                    this.mCameraUIInterface.a_renamed(getShutterButtonInfo());
                    break;
                }
                break;
            case 6:
                if (z_renamed()) {
                    this.mCameraUIInterface.b_renamed(com.oplus.camera.R_renamed.string.camera_macro_best_focus_distance_text, com.oplus.camera.R_renamed.drawable.screen_hint_textview_bg, com.oplus.camera.R_renamed.color.screen_hint_text_color, java.lang.Integer.valueOf(com.oplus.camera.aps.config.CameraConfig.getConfigIntValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_MACRO_BEST_FOCUS_DISTANCE)));
                    break;
                }
                break;
            case 7:
                a_renamed(this.w_renamed.b_renamed(3), 3);
                break;
            case 8:
                w_renamed();
                break;
        }
    }

    private void c_renamed(boolean z_renamed) throws java.lang.NumberFormatException {
        if (this.mOneCamera == null) {
            return;
        }
        this.mOneCamera.a_renamed((android.hardware.camera2.CaptureRequest.Key<android.hardware.camera2.CaptureRequest.Key>) android.hardware.camera2.CaptureRequest.CONTROL_SCENE_MODE, (android.hardware.camera2.CaptureRequest.Key) 0);
        a_renamed(this.C_renamed.getString(com.oplus.camera.R_renamed.string.camera_iso_default_value), false);
        long j_renamed = java.lang.Long.parseLong(this.C_renamed.getString(com.oplus.camera.R_renamed.string.camera_exposure_time_default_value));
        this.mOneCamera.a_renamed(j_renamed);
        this.mOneCamera.a_renamed(j_renamed, false);
        G_renamed();
        if (!this.E_renamed || z_renamed()) {
            this.mOneCamera.a_renamed((android.hardware.camera2.CaptureRequest.Key<android.hardware.camera2.CaptureRequest.Key>) android.hardware.camera2.CaptureRequest.CONTROL_AE_EXPOSURE_COMPENSATION, (android.hardware.camera2.CaptureRequest.Key) java.lang.Integer.valueOf(com.oplus.camera.a_renamed.c_renamed()));
        } else {
            this.mOneCamera.a_renamed((android.hardware.camera2.CaptureRequest.Key<android.hardware.camera2.CaptureRequest.Key>) android.hardware.camera2.CaptureRequest.CONTROL_AE_EXPOSURE_COMPENSATION, (android.hardware.camera2.CaptureRequest.Key) java.lang.Integer.valueOf(c_renamed()));
        }
        this.mOneCamera.i_renamed(false);
        if (z_renamed) {
            this.mOneCamera.a_renamed((com.oplus.camera.e_renamed.d_renamed.c_renamed) null);
        }
        F_renamed();
        H_renamed();
        this.mActivity.runOnUiThread(new java.lang.Runnable() { // from class: com.oplus.camera.professional.h_renamed.20
            @Override // java.lang.Runnable
            public void run() {
                com.oplus.camera.professional.h_renamed.this.E_renamed();
                com.oplus.camera.professional.h_renamed.this.w_renamed.setPanelsBarAuto(4);
                com.oplus.camera.professional.h_renamed.this.w_renamed.b_renamed();
                com.oplus.camera.professional.h_renamed.this.l_renamed();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void l_renamed() {
        this.w_renamed.scrollTo(1, 0);
        this.w_renamed.scrollTo(2, 0);
        this.w_renamed.scrollTo(5, 0);
        this.w_renamed.scrollTo(4, 0);
        java.util.ArrayList<java.lang.String> arrayListD = this.w_renamed.d_renamed(3);
        int iIndexOf = this.w_renamed.c_renamed(3).indexOf(com.oplus.camera.professional.x_renamed.a_renamed(this.mActivity, 3));
        this.w_renamed.scrollTo(3, iIndexOf);
        if (arrayListD != null && arrayListD.size() > iIndexOf) {
            a_renamed(3, arrayListD.get(iIndexOf));
        }
    }

    private void m_renamed() throws android.content.res.Resources.NotFoundException {
        if (this.v_renamed == null) {
            this.v_renamed = new com.oplus.camera.professional.e_renamed(this.mActivity, b_renamed());
            this.v_renamed.setPanelInterface(this.w_renamed);
            this.v_renamed.setVisibility(4);
            if (1.0d == getTargetPreviewRatio(this.mOneCamera.e_renamed())) {
                this.v_renamed.setBackgroundResource(0);
            } else {
                this.v_renamed.setBackgroundResource(com.oplus.camera.R_renamed.drawable.main_bar_bg_grad);
            }
            android.widget.RelativeLayout.LayoutParams layoutParams = new android.widget.RelativeLayout.LayoutParams(-1, this.J_renamed);
            layoutParams.addRule(12);
            layoutParams.addRule(14);
            layoutParams.bottomMargin = this.M_renamed;
            com.oplus.camera.professional.d_renamed dVar = new com.oplus.camera.professional.d_renamed(this.mActivity, this.w_renamed.a_renamed(true));
            dVar.a_renamed((com.oplus.camera.professional.q_renamed) this.w_renamed);
            a_renamed(this.v_renamed, com.oplus.camera.R_renamed.id_renamed.main_bar_id, dVar, this);
            this.B_renamed.addView(this.v_renamed, layoutParams);
        }
    }

    private void n_renamed() {
        if (this.w_renamed == null) {
            this.w_renamed = new com.oplus.camera.professional.g_renamed(this.mActivity, this.mCameraInterface);
            this.w_renamed.setGravity(17);
            this.w_renamed.setId(android.view.View.generateViewId());
            android.widget.RelativeLayout.LayoutParams layoutParams = new android.widget.RelativeLayout.LayoutParams(com.oplus.camera.util.Util.getScreenWidth(), this.L_renamed);
            layoutParams.addRule(14);
            layoutParams.addRule(12);
            this.B_renamed.addView(this.w_renamed, layoutParams);
        }
    }

    private void o_renamed() throws android.content.res.Resources.NotFoundException, java.lang.NumberFormatException {
        int i_renamed;
        this.t_renamed = java.lang.Thread.currentThread();
        int properCameraId = getProperCameraId(this.mCameraId);
        com.oplus.camera.e_renamed.a_renamed("HSProfessionalCapMode", "addViewToRoot, mUiThread: " + this.t_renamed);
        this.n_renamed = false;
        x_renamed();
        n_renamed();
        com.oplus.camera.professional.g_renamed gVar = this.w_renamed;
        if (gVar != null && (i_renamed = this.D_renamed) != properCameraId && i_renamed != -1) {
            gVar.d_renamed();
        }
        this.D_renamed = properCameraId;
        if (com.oplus.camera.util.Util.z_renamed(this.mActivity)) {
            this.w_renamed.a_renamed(getCameraInfo(this.D_renamed), this.A_renamed, (com.oplus.camera.professional.g_renamed.a_renamed) null);
            if (isSuperRawOpen()) {
                this.w_renamed.a_renamed(getCameraInfo(this.D_renamed), 2000000000L);
            }
            m_renamed();
            this.w_renamed.setSettleListener(this.v_renamed);
            this.w_renamed.setMotionListener(this.ai_renamed);
            a_renamed(1);
            this.F_renamed = true;
        }
        q_renamed();
        s_renamed();
        this.af_renamed = new android.widget.TextView(this.mActivity);
        this.af_renamed.setWillNotDraw(true);
        this.af_renamed.setVisibility(4);
        this.af_renamed.setBackgroundResource(com.oplus.camera.R_renamed.drawable.screen_hint_textview_bg);
        this.af_renamed.setLineSpacing(this.mActivity.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.camera_hint_extra_line_spacing), this.af_renamed.getLineSpacingMultiplier());
        android.widget.RelativeLayout.LayoutParams layoutParams = new android.widget.RelativeLayout.LayoutParams(this.mActivity.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.camera_up_hint_text_secondary_max_width), -2);
        layoutParams.addRule(13);
        layoutParams.setMargins(this.mActivity.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.camera_hint_text_padding_left), this.mActivity.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.camera_hint_text_padding_top), this.mActivity.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.camera_hint_text_padding_right), this.mActivity.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.camera_hint_text_padding_bottom));
        this.mCameraUIInterface.b_renamed().addView(this.af_renamed, layoutParams);
        this.ab_renamed = this.mActivity.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.camera_hint_text_padding_bottom);
        this.ac_renamed = this.mActivity.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.camera_hint_text_padding_bottom_size_type_1_1);
        if ("square".equals(this.mPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_PHOTO_RATIO, this.mActivity.getString(com.oplus.camera.R_renamed.string.camera_photo_ratio_default_value)))) {
            this.ad_renamed = com.oplus.camera.util.Util.L_renamed() + com.oplus.camera.util.Util.N_renamed();
        } else {
            this.ad_renamed = com.oplus.camera.util.Util.N_renamed();
        }
    }

    private int p_renamed() {
        android.widget.RelativeLayout relativeLayoutP;
        int iN = com.oplus.camera.util.Util.N_renamed();
        return (this.mCameraUIInterface == null || (relativeLayoutP = this.mCameraUIInterface.p_renamed()) == null || relativeLayoutP.getTop() <= iN) ? iN : relativeLayoutP.getTop();
    }

    private void q_renamed() throws android.content.res.Resources.NotFoundException {
        if (this.G_renamed == null) {
            this.G_renamed = new com.oplus.camera.ui.RotateImageView(this.mActivity);
            this.G_renamed.setId(com.oplus.camera.R_renamed.id_renamed.professional_parameter_bottom_guide_entry);
            this.G_renamed.setImageResource(com.oplus.camera.R_renamed.drawable.professional_mode_guide_icon);
            this.H_renamed = this.G_renamed.getDrawable().getIntrinsicWidth();
            int iP = p_renamed();
            com.oplus.camera.e_renamed.a_renamed("HSProfessionalCapMode", "addBottomGuideEntry, previewMarginTop: " + iP);
            int dimensionPixelSize = iP + this.C_renamed.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.common_bottom_guide_professional_entry_margin_top);
            int dimensionPixelSize2 = this.C_renamed.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.common_bottom_guide_professional_entry_margin_end);
            int dimensionPixelSize3 = (this.C_renamed.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.common_bottom_guide_professional_entry_touch_width) - this.H_renamed) / 2;
            android.widget.RelativeLayout.LayoutParams layoutParams = new android.widget.RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(10);
            layoutParams.addRule(21);
            layoutParams.topMargin = dimensionPixelSize - dimensionPixelSize3;
            layoutParams.setMarginEnd(dimensionPixelSize2 - dimensionPixelSize3);
            this.G_renamed.setLayoutParams(layoutParams);
            this.G_renamed.setPadding(dimensionPixelSize3, dimensionPixelSize3, dimensionPixelSize3, dimensionPixelSize3);
            this.G_renamed.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.oplus.camera.professional.-$$Lambda$Y0n6cbv01i90Hy6rrgxf_rJhiOM
                @Override // android.view.View.OnClickListener
                public final void onClick(android.view.View view) {
                    this.f_renamed$0.onClick(view);
                }
            });
        }
        this.G_renamed.a_renamed(this.mCameraInterface.u_renamed(), false);
        this.mCameraUIInterface.a_renamed((android.view.View) this.G_renamed, com.oplus.camera.aps.constant.ApsConstant.CAPTURE_MODE_PROFESSIONAL, 2, false);
        d_renamed(false);
    }

    private void r_renamed() {
        if (this.G_renamed != null) {
            int iP = p_renamed();
            com.oplus.camera.e_renamed.a_renamed("HSProfessionalCapMode", "updateBottomGuideEntryPosition, previewMarginTop: " + iP);
            int dimensionPixelSize = iP + this.C_renamed.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.common_bottom_guide_professional_entry_margin_top);
            int dimensionPixelSize2 = (this.C_renamed.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.common_bottom_guide_professional_entry_touch_width) - this.H_renamed) / 2;
            final android.widget.RelativeLayout.LayoutParams layoutParams = (android.widget.RelativeLayout.LayoutParams) this.G_renamed.getLayoutParams();
            int i_renamed = dimensionPixelSize - dimensionPixelSize2;
            int i2 = layoutParams.topMargin;
            if (i_renamed != i2) {
                android.animation.ValueAnimator valueAnimator = this.I_renamed;
                if (valueAnimator == null) {
                    this.I_renamed = android.animation.ValueAnimator.ofInt(i2, i_renamed);
                    this.I_renamed.setDuration(300L);
                    this.I_renamed.setInterpolator(com.oplus.camera.professional.t_renamed.f5228b);
                    this.I_renamed.addUpdateListener(new android.animation.ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.professional.h_renamed.21
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(android.animation.ValueAnimator valueAnimator2) {
                            layoutParams.topMargin = ((java.lang.Integer) valueAnimator2.getAnimatedValue()).intValue();
                            com.oplus.camera.professional.h_renamed.this.G_renamed.setLayoutParams(layoutParams);
                        }
                    });
                } else {
                    valueAnimator.setIntValues(i2, i_renamed);
                }
                if (this.I_renamed.isRunning()) {
                    return;
                }
                this.I_renamed.start();
                return;
            }
            layoutParams.topMargin = i_renamed;
            this.G_renamed.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d_renamed(boolean z_renamed) {
        if (this.mbModePreInit) {
            boolean z2 = ("on_renamed".equals(this.mPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_SUB_SETTING, "off")) || this.P_renamed || !this.Q_renamed) ? false : true;
            com.oplus.camera.ui.RotateImageView rotateImageView = this.G_renamed;
            if (rotateImageView != null) {
                if (!z_renamed) {
                    rotateImageView.clearAnimation();
                    this.G_renamed.setVisibility(z2 ? 0 : 4);
                    this.G_renamed.setAlpha(1.0f);
                } else if (z2) {
                    com.oplus.camera.util.Util.a_renamed(rotateImageView, 0, (android.view.animation.Animation.AnimationListener) null, 250L, 250L, com.oplus.camera.professional.t_renamed.f5227a);
                } else {
                    com.oplus.camera.util.Util.a_renamed(rotateImageView, 4, (android.view.animation.Animation.AnimationListener) null, 250L, 0L, com.oplus.camera.professional.t_renamed.f5227a);
                }
            }
        }
    }

    private void s_renamed() {
        if (this.x_renamed == null) {
            this.x_renamed = new com.oplus.camera.ui.RotateImageView(this.mActivity.getApplicationContext());
            this.x_renamed.setEnabled(true);
            this.x_renamed.setFocusable(false);
            this.x_renamed.setClickable(true);
            this.x_renamed.setVisibility(4);
            this.x_renamed.setContentDescription(this.mActivity.getResources().getString(com.oplus.camera.R_renamed.string.camera_setting_menu_parameter_default));
            this.x_renamed.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.oplus.camera.professional.h_renamed.22
                @Override // android.view.View.OnClickListener
                public void onClick(android.view.View view) {
                    com.oplus.camera.professional.h_renamed.this.a_renamed(true, com.oplus.camera.professional.h_renamed.this.mPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_PARAMETER_SAVING, "off"));
                    com.oplus.camera.professional.h_renamed.this.v_renamed();
                }
            });
            final com.a_renamed.a_renamed.f_renamed fVarA = com.oplus.camera.professional.u_renamed.a_renamed();
            this.x_renamed.setOnTouchListener(new android.view.View.OnTouchListener() { // from class: com.oplus.camera.professional.h_renamed.2
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(android.view.View view, android.view.MotionEvent motionEvent) {
                    int action = motionEvent.getAction();
                    if (action == 0) {
                        com.oplus.camera.professional.u_renamed.a_renamed((android.view.View) com.oplus.camera.professional.h_renamed.this.x_renamed, fVarA, true);
                    } else if (action == 1 || action == 3) {
                        com.oplus.camera.professional.u_renamed.a_renamed((android.view.View) com.oplus.camera.professional.h_renamed.this.x_renamed, fVarA, false);
                    }
                    return false;
                }
            });
            android.widget.RelativeLayout.LayoutParams layoutParams = new android.widget.RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(21);
            layoutParams.addRule(11);
            layoutParams.topMargin = this.C_renamed.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.control_button_margin_top);
            layoutParams.setMarginEnd(this.C_renamed.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.control_button_margin_edge));
            this.x_renamed.setLayoutParams(layoutParams);
            this.x_renamed.setImageResource(com.oplus.camera.R_renamed.drawable.ic_parameter_saving_store);
            this.x_renamed.setBackgroundResource(com.oplus.camera.R_renamed.drawable.switch_camera_button_bg);
            ((android.widget.RelativeLayout) this.mActivity.findViewById(com.oplus.camera.R_renamed.id_renamed.control_panel_button_layout)).addView(this.x_renamed);
        }
        this.x_renamed.a_renamed(this.mCameraInterface.u_renamed(), false);
        u_renamed();
        v_renamed();
    }

    private boolean t_renamed() {
        return (!getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_PARAMETER_SAVING) || this.mPreferences == null || this.mPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_PARAMETER_SAVING, "off").equals("off")) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u_renamed() {
        this.p_renamed = t_renamed();
        com.oplus.camera.ui.RotateImageView rotateImageView = this.x_renamed;
        if (rotateImageView != null) {
            rotateImageView.setVisibility(this.p_renamed ? 0 : 4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v_renamed() {
        if (t_renamed()) {
            boolean z_renamed = !this.w_renamed.a_renamed(this.mPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_SWITCH_CAMERA, "camera_main"), this.mPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_PARAMETER_SAVING, "off"));
            com.oplus.camera.ui.RotateImageView rotateImageView = this.x_renamed;
            if (rotateImageView != null) {
                rotateImageView.setEnabled(z_renamed);
                if (z_renamed) {
                    this.x_renamed.setColorFilter(com.oplus.camera.util.Util.A_renamed(this.mActivity));
                } else {
                    this.x_renamed.setColorFilter(androidx.core.a_renamed.a_renamed.c_renamed(this.mActivity, com.oplus.camera.R_renamed.color.camera_white));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a_renamed(boolean z_renamed, java.lang.String str) {
        java.lang.String string = this.mPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_SWITCH_CAMERA, "camera_main");
        if (z_renamed) {
            this.w_renamed.b_renamed(string, str);
        } else {
            this.w_renamed.c_renamed(string, str);
        }
    }

    private void w_renamed() {
        a_renamed(this.w_renamed.b_renamed(0), 0);
        v_renamed();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public int getZoomBarOffset() {
        if (1.0d == getTargetPreviewRatio(this.mOneCamera.e_renamed())) {
            return this.J_renamed + this.mActivity.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.hs_zoom_seekbar_offset_1_1_pro);
        }
        return this.J_renamed;
    }

    private void x_renamed() {
        if (this.B_renamed == null) {
            this.B_renamed = new com.oplus.camera.professional.h_renamed.a_renamed(this.mActivity);
            android.widget.RelativeLayout.LayoutParams layoutParams = new android.widget.RelativeLayout.LayoutParams(-2, com.oplus.camera.util.Util.getScreenWidth());
            layoutParams.addRule(12);
            layoutParams.addRule(14);
            if (this.mCameraInterface != null) {
                layoutParams.bottomMargin = (this.mCameraUIInterface.r_renamed() - this.K_renamed) - this.M_renamed;
            } else {
                layoutParams.bottomMargin = 0;
            }
            this.B_renamed.setLayoutParams(layoutParams);
            this.B_renamed.setVisibility(8);
            this.B_renamed.getViewTreeObserver().addOnWindowFocusChangeListener(new android.view.ViewTreeObserver.OnWindowFocusChangeListener() { // from class: com.oplus.camera.professional.h_renamed.3
                @Override // android.view.ViewTreeObserver.OnWindowFocusChangeListener
                public void onWindowFocusChanged(boolean z_renamed) {
                    if (com.oplus.camera.professional.h_renamed.this.v_renamed != null) {
                        com.oplus.camera.e_renamed.a_renamed("HSProfessionalCapMode", "onWindowFocusChanged, SelectedPosition: " + com.oplus.camera.professional.h_renamed.this.v_renamed.getSelectedPosition() + ", hasFocus: " + z_renamed);
                        com.oplus.camera.professional.h_renamed.this.v_renamed.a_renamed(com.oplus.camera.professional.h_renamed.this.v_renamed.getSelectedPosition(), true);
                    }
                }
            });
        }
        this.mCameraUIInterface.a_renamed((android.view.View) this.B_renamed, com.oplus.camera.aps.constant.ApsConstant.CAPTURE_MODE_PROFESSIONAL, 1, false);
        com.oplus.camera.professional.h_renamed.a_renamed aVar = this.B_renamed;
        if (aVar != null) {
            aVar.a_renamed(true);
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void checkoutTimerSnapShotState() {
        super.checkoutTimerSnapShotState();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onTimeSnapShotEnd(boolean z_renamed) {
        com.oplus.camera.ui.control.b_renamed shutterButtonInfo = getShutterButtonInfo();
        this.w_renamed.e_renamed();
        this.v_renamed.a_renamed();
        b_renamed(0, true);
        if (this.i_renamed && z_renamed) {
            shutterButtonInfo.a_renamed(8);
            shutterButtonInfo.a_renamed("button_color_inside_none");
        } else {
            shutterButtonInfo.a_renamed(com.oplus.camera.util.Util.ao_renamed() ? 23 : 11);
            shutterButtonInfo.a_renamed("button_color_inside_none");
        }
        this.mCameraUIInterface.a_renamed(shutterButtonInfo);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean onBackPressed() {
        com.oplus.camera.e_renamed.c_renamed("HSProfessionalCapMode", "onBackPressed, mbInCapturing: " + this.mbInCapturing);
        b_renamed(0, true);
        if (this.v_renamed.isSelected()) {
            this.mCameraInterface.a_renamed(true, true);
            this.mCameraInterface.d_renamed(true);
            com.oplus.camera.professional.u_renamed.a_renamed aVar = new com.oplus.camera.professional.u_renamed.a_renamed();
            aVar.f5239a = false;
            aVar.f5241c = 250;
            aVar.g_renamed = 400;
            aVar.d_renamed = 0.0f;
            aVar.e_renamed = this.mActivity.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.hs_main_mode_bar_item_animation_offset);
            this.w_renamed.setAllPopupInvisibility(aVar);
            this.v_renamed.a_renamed();
            this.mOneCamera.j_renamed(true);
            return true;
        }
        return super.onBackPressed();
    }

    @Override // com.oplus.camera.capmode.BaseMode, com.oplus.camera.e_renamed.d_renamed.a_renamed
    public void onCaptureSequenceCompleted() {
        super.onCaptureSequenceCompleted();
        com.oplus.camera.e_renamed.c_renamed("HSProfessionalCapMode", "onCaptureSequenceCompleted");
        if (isSuperRawOpen()) {
            this.mCameraUIInterface.a_renamed(com.oplus.camera.R_renamed.string.camera_scene_night_keep_phone_steady);
            if (this.h_renamed) {
                return;
            }
            this.mCameraUIInterface.a_renamed(new com.oplus.camera.ui.control.b_renamed());
            this.mCameraUIInterface.a_renamed(false, true);
            if (this.mActivity != null) {
                this.mActivity.runOnUiThread(new java.lang.Runnable() { // from class: com.oplus.camera.professional.h_renamed.4
                    @Override // java.lang.Runnable
                    public void run() {
                        if (com.oplus.camera.professional.h_renamed.this.mbPaused || com.oplus.camera.professional.h_renamed.this.u_renamed == null) {
                            return;
                        }
                        com.oplus.camera.professional.h_renamed.this.u_renamed.f_renamed();
                    }
                });
            }
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected boolean onStopTakePicture() {
        if (2 != this.mCameraInterface.g_renamed()) {
            com.oplus.camera.e_renamed.f_renamed("HSProfessionalCapMode", "onStopTakePicture failed, current camera state is_renamed " + this.mCameraInterface.g_renamed());
            return false;
        }
        this.mActivity.runOnUiThread(new java.lang.Runnable() { // from class: com.oplus.camera.professional.h_renamed.5
            /* JADX WARN: Removed duplicated region for block: B_renamed:6:0x0018  */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public void run() throws android.content.res.Resources.NotFoundException {
                /*
                    r6 = this;
                    com.oplus.camera.professional.h_renamed r0 = com.oplus.camera.professional.h_renamed.this
                    java.lang.String r1 = com.oplus.camera.professional.h_renamed.E_renamed(r0)
                    boolean r0 = com.oplus.camera.professional.h_renamed.a_renamed(r0, r1)
                    if (r0 != 0) goto L18
                    com.oplus.camera.professional.h_renamed r0 = com.oplus.camera.professional.h_renamed.this
                    java.lang.String r1 = com.oplus.camera.professional.h_renamed.E_renamed(r0)
                    boolean r0 = com.oplus.camera.professional.h_renamed.b_renamed(r0, r1)
                    if (r0 == 0) goto L4c
                L18:
                    com.oplus.camera.professional.h_renamed r0 = com.oplus.camera.professional.h_renamed.this
                    com.oplus.camera.e_renamed.d_renamed r0 = com.oplus.camera.professional.h_renamed.F_renamed(r0)
                    r0.h_renamed()
                    com.oplus.camera.professional.h_renamed r0 = com.oplus.camera.professional.h_renamed.this
                    com.oplus.camera.capmode.a_renamed r0 = com.oplus.camera.professional.h_renamed.G_renamed(r0)
                    r0.W_renamed()
                    com.oplus.camera.professional.h_renamed r0 = com.oplus.camera.professional.h_renamed.this
                    com.oplus.camera.professional.h_renamed.H_renamed(r0)
                    com.oplus.camera.professional.h_renamed r0 = com.oplus.camera.professional.h_renamed.this
                    boolean r0 = r0.isSuperRawOpen()
                    if (r0 == 0) goto L4c
                    com.oplus.camera.professional.h_renamed r0 = com.oplus.camera.professional.h_renamed.this
                    com.oplus.camera.ui.CameraUIInterface r0 = com.oplus.camera.professional.h_renamed.I_renamed(r0)
                    r1 = 2131755796(0x7f100314, float:1.9142481E38)
                    r0.a_renamed(r1)
                    com.oplus.camera.professional.h_renamed r0 = com.oplus.camera.professional.h_renamed.this
                    com.oplus.camera.ui.h_renamed r0 = com.oplus.camera.professional.h_renamed.d_renamed(r0)
                    r0.a_renamed()
                L4c:
                    com.oplus.camera.professional.h_renamed r0 = com.oplus.camera.professional.h_renamed.this
                    com.oplus.camera.professional.g_renamed r0 = com.oplus.camera.professional.h_renamed.w_renamed(r0)
                    r0.e_renamed()
                    com.oplus.camera.professional.h_renamed r0 = com.oplus.camera.professional.h_renamed.this
                    com.oplus.camera.professional.e_renamed r0 = com.oplus.camera.professional.h_renamed.C_renamed(r0)
                    r0.a_renamed()
                    com.oplus.camera.professional.h_renamed r0 = com.oplus.camera.professional.h_renamed.this
                    r1 = 1
                    r2 = 0
                    com.oplus.camera.professional.h_renamed.a_renamed(r0, r2, r1)
                    com.oplus.camera.professional.h_renamed r0 = com.oplus.camera.professional.h_renamed.this
                    com.oplus.camera.professional.h_renamed$a_renamed r0 = com.oplus.camera.professional.h_renamed.J_renamed(r0)
                    r3 = 0
                    r4 = 300(0x12c, double:1.48E-321)
                    com.oplus.camera.util.Util.a_renamed(r0, r2, r3, r4)
                    com.oplus.camera.professional.h_renamed r0 = com.oplus.camera.professional.h_renamed.this
                    com.oplus.camera.professional.h_renamed.d_renamed(r0, r2)
                    com.oplus.camera.professional.h_renamed r6 = com.oplus.camera.professional.h_renamed.this
                    com.oplus.camera.ui.CameraUIInterface r6 = com.oplus.camera.professional.h_renamed.K_renamed(r6)
                    r6.c_renamed(r1, r2)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.professional.h_renamed.ParameterContainer_7.run():void");
            }
        });
        this.mbInCapturing = false;
        setCapturePreviewDataState(2);
        this.B_renamed.a_renamed(true);
        this.mCameraInterface.f_renamed(true);
        this.mCameraUIInterface.a_renamed(true, false);
        return true;
    }

    private void y_renamed() {
        this.mCameraUIInterface.g_renamed(true);
        com.oplus.camera.ui.RotateImageView rotateImageView = this.x_renamed;
        if (rotateImageView != null) {
            rotateImageView.setVisibility(4);
        }
        com.oplus.camera.professional.h_renamed.a_renamed aVar = this.B_renamed;
        if (aVar != null) {
            aVar.a_renamed(false);
            com.oplus.camera.professional.e_renamed eVar = this.v_renamed;
            if (eVar != null) {
                eVar.removeAllViews();
                this.B_renamed.removeView(this.v_renamed);
                this.v_renamed = null;
            }
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void onDeInitCameraMode(java.lang.String str) throws android.content.res.Resources.NotFoundException {
        com.oplus.camera.e_renamed.c_renamed("HSProfessionalCapMode", "onDeInitCameraMode");
        android.os.Handler handler = this.A_renamed;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        com.oplus.camera.professional.e_renamed eVar = this.v_renamed;
        if (eVar != null && eVar.isSelected() && this.v_renamed.isShown()) {
            b_renamed(0, true);
        }
        com.oplus.camera.professional.g_renamed gVar = this.w_renamed;
        if (gVar != null) {
            gVar.h_renamed();
        }
        if (z_renamed()) {
            this.mCameraUIInterface.w_renamed(true);
        }
        com.oplus.camera.professional.h_renamed.a_renamed aVar = this.B_renamed;
        if (aVar != null && aVar.getVisibility() != 0) {
            I_renamed();
            y_renamed();
        }
        b_renamed("0", false);
        android.animation.ValueAnimator valueAnimator = this.ag_renamed;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.ag_renamed.cancel();
        }
        com.oplus.camera.p_renamed pVar = this.y_renamed;
        if (pVar != null) {
            pVar.c_renamed();
            this.y_renamed = null;
        }
        if (T_renamed() && this.aa_renamed != 0) {
            this.aa_renamed = 0;
            d_renamed(0);
        }
        this.mCameraUIInterface.w_renamed(0);
        this.mCameraUIInterface.b_renamed().removeView(this.af_renamed);
        com.oplus.camera.ui.a_renamed.a_renamed aVarK = this.mCameraUIInterface.k_renamed();
        if (aVarK != null) {
            aVarK.a_renamed((com.oplus.camera.ui.a_renamed.a_renamed.b_renamed) null);
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void operateSpecificViewCallBack(java.lang.Object obj, boolean z_renamed, boolean z2) {
        if ((obj instanceof java.lang.Integer) && 1 == ((java.lang.Integer) obj).intValue() && !z_renamed) {
            if (z2) {
                com.oplus.camera.e_renamed.b_renamed("HSProfessionalCapMode", "removeAllView when mEmptyViewToAnimate hide animation end");
                I_renamed();
                y_renamed();
            } else if (this.v_renamed != null) {
                com.oplus.camera.professional.u_renamed.a_renamed aVar = new com.oplus.camera.professional.u_renamed.a_renamed();
                aVar.f5239a = false;
                aVar.f5241c = 250;
                aVar.d_renamed = 0.0f;
                aVar.e_renamed = getZoomBarOffset();
                aVar.g_renamed = 500;
                com.oplus.camera.professional.u_renamed.a_renamed(this.v_renamed, aVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b_renamed(java.lang.String str) {
        return str != null && com.google.android.exoplayer2.C_renamed.NANOS_PER_SECOND <= java.lang.Long.parseLong(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c_renamed(java.lang.String str) {
        return str != null && isSuperRawOpen() && com.google.android.exoplayer2.C_renamed.NANOS_PER_SECOND <= java.lang.Long.parseLong(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean d_renamed(java.lang.String str) {
        return str != null && isSuperRawOpen() && 500000000 <= java.lang.Long.parseLong(str);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected boolean isHideUICapture() {
        return b_renamed(i_renamed()) && getIsCapturingState();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected boolean onBeforeSnapping(com.oplus.camera.e_renamed.c_renamed cVar) {
        com.oplus.camera.professional.g_renamed gVar = this.w_renamed;
        if (gVar != null && gVar.g_renamed()) {
            com.oplus.camera.e_renamed.c_renamed("HSProfessionalCapMode", "onBeforeSnapping, HSLevelPanelScrolling");
            return false;
        }
        this.mActivity.runOnUiThread(new java.lang.Runnable() { // from class: com.oplus.camera.professional.h_renamed.6
            @Override // java.lang.Runnable
            public void run() throws android.content.res.Resources.NotFoundException {
                if (com.oplus.camera.professional.h_renamed.this.mbPaused) {
                    com.oplus.camera.e_renamed.a_renamed("HSProfessionalCapMode", "onBeforeSnapping, return after pause");
                    return;
                }
                if (com.oplus.camera.professional.h_renamed.this.isSuperRawOpen()) {
                    com.oplus.camera.professional.h_renamed hVar = com.oplus.camera.professional.h_renamed.this;
                    if (hVar.d_renamed(hVar.i_renamed()) && com.oplus.camera.professional.h_renamed.this.mCameraUIInterface != null) {
                        com.oplus.camera.professional.h_renamed.this.mCameraUIInterface.a_renamed(com.oplus.camera.R_renamed.string.camera_scene_night_keep_phone_steady, -1, false, false, true);
                    }
                    com.oplus.camera.professional.h_renamed hVar2 = com.oplus.camera.professional.h_renamed.this;
                    if (hVar2.c_renamed(hVar2.i_renamed())) {
                        int iLongValue = ((int) (java.lang.Long.valueOf(com.oplus.camera.professional.h_renamed.this.i_renamed()).longValue() / 1000000)) * 3;
                        com.oplus.camera.professional.h_renamed.this.u_renamed.a_renamed(iLongValue);
                        if (com.oplus.camera.professional.h_renamed.this.mCameraUIInterface != null) {
                            com.oplus.camera.professional.h_renamed.this.mCameraUIInterface.h_renamed(iLongValue);
                        }
                    }
                    if (com.oplus.camera.professional.h_renamed.this.mCameraUIInterface != null) {
                        com.oplus.camera.professional.h_renamed.this.mCameraUIInterface.g_renamed(4);
                        com.oplus.camera.professional.h_renamed.this.mCameraUIInterface.f_renamed(4);
                        com.oplus.camera.professional.h_renamed.this.b_renamed(4, true);
                        com.oplus.camera.professional.h_renamed.this.mCameraInterface.a_renamed((android.animation.AnimatorListenerAdapter) null, true, false);
                    }
                    com.oplus.camera.professional.h_renamed.this.Q_renamed = false;
                    com.oplus.camera.professional.h_renamed.this.d_renamed(false);
                    com.oplus.camera.professional.h_renamed.this.b_renamed(false, false);
                    com.oplus.camera.util.Util.a_renamed(com.oplus.camera.professional.h_renamed.this.B_renamed, 4, (android.view.animation.Animation.AnimationListener) null, 300L);
                    com.oplus.camera.util.Util.a_renamed(com.oplus.camera.professional.h_renamed.this.x_renamed, 4, (android.view.animation.Animation.AnimationListener) null, 300L);
                } else {
                    com.oplus.camera.professional.h_renamed hVar3 = com.oplus.camera.professional.h_renamed.this;
                    if (hVar3.b_renamed(hVar3.i_renamed())) {
                        if (com.oplus.camera.professional.h_renamed.this.mCameraUIInterface != null) {
                            com.oplus.camera.professional.h_renamed.this.mCameraUIInterface.g_renamed(4);
                            com.oplus.camera.professional.h_renamed.this.mCameraUIInterface.f_renamed(4);
                            com.oplus.camera.professional.h_renamed.this.b_renamed(4, true);
                            com.oplus.camera.professional.h_renamed.this.mCameraInterface.a_renamed((android.animation.AnimatorListenerAdapter) null, true, false);
                        }
                        com.oplus.camera.professional.h_renamed.this.Q_renamed = false;
                        com.oplus.camera.professional.h_renamed.this.d_renamed(false);
                        com.oplus.camera.professional.h_renamed.this.a_renamed(false, false, true);
                        com.oplus.camera.util.Util.a_renamed(com.oplus.camera.professional.h_renamed.this.B_renamed, 4, (android.view.animation.Animation.AnimationListener) null, 300L);
                        com.oplus.camera.util.Util.a_renamed(com.oplus.camera.professional.h_renamed.this.x_renamed, 4, (android.view.animation.Animation.AnimationListener) null, 300L);
                        if (com.oplus.camera.professional.h_renamed.this.mCameraUIInterface != null) {
                            com.oplus.camera.professional.h_renamed.this.mCameraUIInterface.h_renamed((int) (java.lang.Long.valueOf(com.oplus.camera.professional.h_renamed.this.i_renamed()).longValue() / 1000000));
                        }
                    }
                }
                com.oplus.camera.professional.h_renamed.this.B_renamed.a_renamed(false);
                if (!com.oplus.camera.professional.h_renamed.this.i_renamed || com.oplus.camera.professional.h_renamed.this.mCameraUIInterface == null || com.oplus.camera.professional.h_renamed.this.mCameraUIInterface.s_renamed() == 2) {
                    return;
                }
                com.oplus.camera.professional.h_renamed.this.mCameraUIInterface.a_renamed(new com.oplus.camera.ui.control.b_renamed(4, "button_color_inside_none"));
            }
        });
        setRawRequestTag(false);
        this.R_renamed = null;
        if (isRawOpen()) {
            setRawRequestTag(true);
            this.m_renamed = false;
        }
        if (isSuperRawOpen()) {
            setRawRequestTag(false);
            this.m_renamed = false;
            synchronized (this.g_renamed) {
                this.T_renamed = false;
            }
        }
        D_renamed();
        if (this.mOneCamera != null) {
            this.mOneCamera.j_renamed(true);
        }
        setCaptureRequestPictureSizeScale();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b_renamed(int i_renamed) throws android.content.res.Resources.NotFoundException {
        com.oplus.camera.e_renamed.a_renamed("HSProfessionalCapMode", "setCameraMenuControlViewVisibility, visibility: " + i_renamed);
        if (this.mCameraUIInterface != null) {
            this.mCameraUIInterface.g_renamed(i_renamed);
            this.mCameraUIInterface.f_renamed(i_renamed);
            this.mCameraUIInterface.c_renamed(i_renamed);
            this.mCameraUIInterface.b_renamed(i_renamed, true);
        }
        this.Q_renamed = i_renamed == 0;
        d_renamed(false);
        a_renamed(false, false, true);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean onAfterSnapping() {
        com.oplus.camera.e_renamed.a_renamed("HSProfessionalCapMode", "onAfterSnapping");
        if (!this.i_renamed && this.mCameraInterface.i_renamed() && java.lang.Long.parseLong(i_renamed()) >= com.google.android.exoplayer2.C_renamed.NANOS_PER_SECOND) {
            this.mCameraInterface.c_renamed(com.oplus.camera.util.Util.ao_renamed() ? 6 : 4);
        } else {
            com.oplus.camera.e_renamed.a_renamed("HSProfessionalCapMode", "onAfterSnapping is_renamed ZSL mode, do nothing");
        }
        if (isSuperRawOpen()) {
            this.h_renamed = false;
        }
        this.mActivity.runOnUiThread(new java.lang.Runnable() { // from class: com.oplus.camera.professional.h_renamed.7
            @Override // java.lang.Runnable
            public void run() {
                if (com.oplus.camera.professional.h_renamed.this.mbPaused) {
                    return;
                }
                if (com.oplus.camera.professional.h_renamed.this.isSuperRawOpen()) {
                    com.oplus.camera.ui.control.b_renamed shutterButtonInfo = com.oplus.camera.professional.h_renamed.this.getShutterButtonInfo();
                    com.oplus.camera.professional.h_renamed hVar = com.oplus.camera.professional.h_renamed.this;
                    if (hVar.c_renamed(hVar.i_renamed())) {
                        com.oplus.camera.professional.h_renamed.this.mCameraUIInterface.a_renamed(true, false);
                        com.oplus.camera.professional.h_renamed.this.mCameraUIInterface.i_renamed(com.oplus.camera.professional.h_renamed.this.C_renamed.getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.night_countdown_time_margin_top));
                        com.oplus.camera.professional.h_renamed.this.u_renamed.d_renamed();
                        com.oplus.camera.professional.h_renamed.this.u_renamed.e_renamed();
                        if (com.oplus.camera.professional.h_renamed.this.mCameraUIInterface.s_renamed() == 9) {
                            shutterButtonInfo.a_renamed(3);
                            shutterButtonInfo.a_renamed("button_color_inside_none");
                        } else {
                            shutterButtonInfo.a_renamed(15);
                            shutterButtonInfo.a_renamed("button_color_inside_none");
                        }
                    } else {
                        shutterButtonInfo.a_renamed(4);
                        shutterButtonInfo.a_renamed("button_color_inside_none");
                    }
                    com.oplus.camera.professional.h_renamed.this.mCameraUIInterface.a_renamed(shutterButtonInfo);
                    return;
                }
                com.oplus.camera.professional.h_renamed hVar2 = com.oplus.camera.professional.h_renamed.this;
                if (hVar2.b_renamed(hVar2.i_renamed())) {
                    com.oplus.camera.professional.h_renamed.this.mCameraUIInterface.a_renamed(true, false);
                    com.oplus.camera.ui.control.b_renamed shutterButtonInfo2 = com.oplus.camera.professional.h_renamed.this.getShutterButtonInfo();
                    if (com.oplus.camera.professional.h_renamed.this.mCameraUIInterface.s_renamed() == 9) {
                        shutterButtonInfo2.a_renamed(3);
                        shutterButtonInfo2.a_renamed("button_color_inside_none");
                    } else {
                        shutterButtonInfo2.a_renamed(com.oplus.camera.util.Util.ao_renamed() ? 27 : 7);
                        shutterButtonInfo2.a_renamed("button_color_inside_none");
                    }
                    com.oplus.camera.professional.h_renamed.this.mCameraUIInterface.a_renamed(shutterButtonInfo2);
                }
            }
        });
        com.oplus.camera.e_renamed.a_renamed("HSProfessionalCapMode", "onAfterSnapping X_renamed");
        return true;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void onShutterCallback(boolean z_renamed, boolean z2) throws android.content.res.Resources.NotFoundException {
        super.onShutterCallback(z_renamed, z2);
        if (z2) {
            if (!this.i_renamed && this.mCameraInterface.i_renamed() && java.lang.Long.parseLong(i_renamed()) >= com.google.android.exoplayer2.C_renamed.NANOS_PER_SECOND) {
                if (!isSuperRawOpen()) {
                    this.mCameraInterface.c_renamed(com.oplus.camera.util.Util.ao_renamed() ? 7 : 5);
                    b_renamed(0);
                }
            } else {
                this.mCameraInterface.c_renamed(0);
            }
            if (isSuperRawOpen()) {
                return;
            }
            this.mCameraInterface.h_renamed();
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode, com.oplus.camera.e_renamed.d_renamed.a_renamed
    public void onCaptureCompleted(com.oplus.camera.aps.service.CameraCaptureResult cameraCaptureResult, com.oplus.camera.e_renamed.c_renamed cVar) {
        super.onCaptureCompleted(cameraCaptureResult, cVar);
        com.oplus.camera.e_renamed.a_renamed("HSProfessionalCapMode", "onCaptureCompleted, systemTime: " + java.lang.System.currentTimeMillis());
    }

    @Override // com.oplus.camera.capmode.BaseMode, com.oplus.camera.e_renamed.d_renamed.a_renamed
    public void onCaptureFailed(android.hardware.camera2.CaptureRequest captureRequest, com.oplus.camera.e_renamed.c_renamed cVar) {
        super.onCaptureFailed(captureRequest, cVar);
        if (isSuperRawOpen()) {
            this.h_renamed = true;
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void onBeforePictureTaken(byte[] bArr, boolean z_renamed) {
        com.oplus.camera.e_renamed.c_renamed("HSProfessionalCapMode", "onBeforePictureTaken");
        if (this.i_renamed) {
            this.mCameraUIInterface.a_renamed(getShutterButtonInfo(), false);
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected boolean getNeedStoreRawPic() {
        return isSuperRawOpen();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void onAfterPictureTaken(byte[] bArr, boolean z_renamed) throws android.content.res.Resources.NotFoundException {
        com.oplus.camera.e_renamed.a_renamed("HSProfessionalCapMode", "onAfterPictureTaken");
        if (!this.m_renamed && isRawRequestTag()) {
            this.m_renamed = true;
            return;
        }
        if (isSuperRawOpen()) {
            b_renamed(0);
            com.oplus.camera.util.Util.a_renamed(this.B_renamed, 0, (android.view.animation.Animation.AnimationListener) null, 300L);
            if (!this.v_renamed.isSelected()) {
                this.mCameraInterface.a_renamed(true, false);
                this.mCameraInterface.d_renamed(true);
            }
            this.mCameraUIInterface.a_renamed(getShutterButtonInfo());
            if (t_renamed()) {
                com.oplus.camera.util.Util.a_renamed(this.x_renamed, 0, (android.view.animation.Animation.AnimationListener) null, 300L);
            }
        } else if (b_renamed(i_renamed())) {
            com.oplus.camera.ui.control.b_renamed shutterButtonInfo = getShutterButtonInfo();
            if (1 != this.mCameraUIInterface.s_renamed() && !com.oplus.camera.util.Util.ao_renamed()) {
                shutterButtonInfo.a_renamed(11);
            }
            this.mCameraUIInterface.a_renamed(shutterButtonInfo);
            b_renamed(0);
            com.oplus.camera.util.Util.a_renamed(this.B_renamed, 0, (android.view.animation.Animation.AnimationListener) null, 300L);
            if (!this.v_renamed.isSelected()) {
                this.mCameraInterface.a_renamed(true, false);
            }
            if (t_renamed()) {
                com.oplus.camera.util.Util.a_renamed(this.x_renamed, 0, (android.view.animation.Animation.AnimationListener) null, 300L);
            }
        }
        com.oplus.camera.professional.e_renamed eVar = this.v_renamed;
        if (eVar != null && !eVar.isSelected() && !this.mCameraInterface.J_renamed()) {
            b_renamed(0, true);
        } else {
            b_renamed(4, true);
        }
        this.mCameraUIInterface.d_renamed(true, false);
        if (this.k_renamed) {
            com.oplus.camera.util.Util.a_renamed(this.B_renamed, 0, (android.view.animation.Animation.AnimationListener) null, 300L);
            this.k_renamed = false;
        }
        this.B_renamed.a_renamed(true);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void cameraIdChanged(int i_renamed) {
        super.cameraIdChanged(i_renamed);
        final int iAs = this.mCameraInterface.as_renamed();
        com.oplus.camera.e_renamed.a_renamed("HSProfessionalCapMode", "cameraIdChanged, id_renamed: " + iAs);
        if (this.D_renamed != iAs) {
            this.D_renamed = iAs;
            this.E_renamed = true;
            this.mActivity.runOnUiThread(new java.lang.Runnable() { // from class: com.oplus.camera.professional.h_renamed.8
                @Override // java.lang.Runnable
                public void run() {
                    if (com.oplus.camera.professional.h_renamed.this.z_renamed()) {
                        com.oplus.camera.professional.h_renamed.this.v_renamed.setVisibility(8);
                        com.oplus.camera.professional.h_renamed.this.v_renamed.setItemPressed(false);
                        com.oplus.camera.professional.h_renamed.this.w_renamed.e_renamed();
                        if (com.oplus.camera.professional.h_renamed.this.v_renamed.isSelected()) {
                            com.oplus.camera.professional.h_renamed.this.w_renamed.e_renamed();
                            com.oplus.camera.professional.h_renamed.this.v_renamed.a_renamed();
                            return;
                        }
                        return;
                    }
                    com.oplus.camera.professional.h_renamed.this.v_renamed.setVisibility(0);
                    com.oplus.camera.professional.h_renamed.this.w_renamed.setVisibility(0);
                    com.oplus.camera.professional.h_renamed.this.mCameraUIInterface.w_renamed(true);
                    com.oplus.camera.professional.h_renamed.this.c_renamed(iAs);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean z_renamed() {
        if (this.mPreferences != null) {
            return "camera_macro".equals(this.mPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_SWITCH_CAMERA, "camera_main"));
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void c_renamed(int i_renamed) {
        this.w_renamed.d_renamed();
        com.oplus.camera.e_renamed.h_renamed cameraInfo = getCameraInfo(i_renamed);
        this.w_renamed.a_renamed(cameraInfo.u_renamed(), cameraInfo.v_renamed(), cameraInfo.w_renamed(), this.A_renamed);
        this.w_renamed.a_renamed(isSuperRawOpen() ? 2000000000L : cameraInfo.x_renamed(), cameraInfo.y_renamed(), cameraInfo.a_renamed(256), this.A_renamed);
        this.w_renamed.a_renamed(cameraInfo.B_renamed(), this.A_renamed);
        this.w_renamed.a_renamed(cameraInfo.n_renamed(), cameraInfo.m_renamed(), this.A_renamed);
        this.w_renamed.a_renamed(cameraInfo.p_renamed(), cameraInfo.q_renamed(), cameraInfo.r_renamed(), this.A_renamed);
        this.w_renamed.e_renamed();
        if (this.v_renamed.isSelected()) {
            this.w_renamed.f_renamed(this.v_renamed.getSelectedIndex());
        }
        this.w_renamed.a_renamed();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void setOrientation(int i_renamed) throws android.content.res.Resources.NotFoundException {
        com.oplus.camera.ui.RotateImageView rotateImageView = this.G_renamed;
        if (rotateImageView != null) {
            rotateImageView.a_renamed(i_renamed, true);
        }
        com.oplus.camera.ui.RotateImageView rotateImageView2 = this.x_renamed;
        if (rotateImageView2 != null) {
            rotateImageView2.a_renamed(i_renamed, true);
        }
        if (this.mOrientation == i_renamed) {
            return;
        }
        this.mOrientation = i_renamed;
        com.oplus.camera.p_renamed.a_renamed aVar = this.z_renamed;
        if (aVar != null) {
            aVar.e_renamed = this.mOrientation;
        }
        com.oplus.camera.ui.a_renamed.a_renamed aVarK = this.mCameraUIInterface.k_renamed();
        if (aVarK != null) {
            aVarK.g_renamed();
        }
        android.animation.ValueAnimator valueAnimator = this.ag_renamed;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        if (T_renamed() && this.aa_renamed != 0) {
            this.aa_renamed = 0;
        }
        V_renamed();
        com.oplus.camera.p_renamed pVar = this.y_renamed;
        if (pVar != null) {
            pVar.a_renamed(this.z_renamed, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean A_renamed() {
        return this.mOrientation % 180 == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean B_renamed() {
        return 90 == this.mOrientation;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void onResume(boolean z_renamed) {
        com.oplus.camera.e_renamed.a_renamed("HSProfessionalCapMode", "onResume");
        if (this.mPreferences != null) {
            this.i_renamed = "on_renamed".equals(this.mPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_HIGH_RESOLUTION, this.C_renamed.getString(com.oplus.camera.R_renamed.string.camera_high_resolution_default_value)));
        }
        com.oplus.camera.p_renamed pVar = this.y_renamed;
        if (pVar != null) {
            pVar.a_renamed();
        }
        if (com.oplus.camera.util.Util.z_renamed(this.mActivity)) {
            com.oplus.camera.professional.h_renamed.a_renamed aVar = this.B_renamed;
            if (aVar != null) {
                aVar.setVisibility(0);
            }
            this.mCameraInterface.d_renamed(true);
            a_renamed(1);
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void onPause() throws android.content.res.Resources.NotFoundException {
        com.oplus.camera.e_renamed.a_renamed("HSProfessionalCapMode", "onPause");
        this.mCameraUIInterface.g_renamed(0);
        this.mCameraUIInterface.g_renamed(false);
        if (T_renamed() && this.aa_renamed != 0) {
            this.aa_renamed = 0;
            d_renamed(0);
        }
        com.oplus.camera.professional.h_renamed.a_renamed aVar = this.B_renamed;
        if (aVar != null) {
            aVar.a_renamed(false);
        }
        android.animation.ValueAnimator valueAnimator = this.I_renamed;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.I_renamed = null;
        }
        this.k_renamed = false;
        android.os.Handler handler = this.A_renamed;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        com.oplus.camera.professional.g_renamed gVar = this.w_renamed;
        if (gVar != null) {
            gVar.h_renamed();
        }
        this.mCameraUIInterface.d_renamed(true, false);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void onDestroy() {
        com.oplus.camera.e_renamed.a_renamed("HSProfessionalCapMode", "onDestroy");
        com.oplus.camera.professional.g_renamed gVar = this.w_renamed;
        if (gVar != null) {
            gVar.f_renamed();
            this.w_renamed = null;
            this.F_renamed = false;
        }
        if (this.B_renamed != null) {
            this.B_renamed = null;
        }
        if (this.G_renamed != null) {
            this.G_renamed = null;
        }
        if (this.v_renamed != null) {
            this.v_renamed = null;
        }
        com.oplus.camera.p_renamed pVar = this.y_renamed;
        if (pVar != null) {
            pVar.c_renamed();
            this.y_renamed = null;
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public com.oplus.camera.ui.control.b_renamed getShutterButtonInfo() {
        com.oplus.camera.ui.control.b_renamed shutterButtonInfo = super.getShutterButtonInfo();
        if (com.oplus.camera.util.Util.ao_renamed()) {
            if (this.mCameraUIInterface.s_renamed() == 28 || this.mCameraUIInterface.s_renamed() == 29) {
                shutterButtonInfo.a_renamed(26);
            } else {
                shutterButtonInfo.a_renamed(23);
            }
        }
        return shutterButtonInfo;
    }

    private void C_renamed() {
        if (getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_SWITCH_CAMERA) && getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_RAW_CONTROL)) {
            if (com.oplus.camera.util.Util.e_renamed(this.mPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_SWITCH_CAMERA, "camera_main"))) {
                this.mCameraUIInterface.b_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_RAW_CONTROL, (java.lang.String) null);
            } else {
                if (!"off".equals(this.mPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_RAW_CONTROL, "off"))) {
                    this.mPreferences.edit().putString(com.oplus.camera.ui.CameraUIInterface.KEY_RAW_CONTROL, "off").apply();
                }
                this.mCameraUIInterface.a_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_RAW_CONTROL, "off");
            }
            this.mCameraUIInterface.f_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_RAW_CONTROL);
        }
        if (getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_SWITCH_CAMERA) && getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_SUPER_RAW_CONTROL)) {
            if (com.oplus.camera.util.Util.e_renamed(this.mPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_SWITCH_CAMERA, "camera_main"))) {
                this.mCameraUIInterface.b_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_SUPER_RAW_CONTROL, (java.lang.String) null);
            } else {
                if (!"off".equals(this.mPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_SUPER_RAW_CONTROL, "off"))) {
                    this.mPreferences.edit().putString(com.oplus.camera.ui.CameraUIInterface.KEY_SUPER_RAW_CONTROL, "off").apply();
                }
                this.mCameraUIInterface.a_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_SUPER_RAW_CONTROL, "off");
            }
            this.mCameraUIInterface.f_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_SUPER_RAW_CONTROL);
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected boolean isCameraSettingMenuOptionEnable(java.lang.String str) {
        if (com.oplus.camera.ui.CameraUIInterface.KEY_RAW_CONTROL.equals(str) && getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_RAW_CONTROL) && getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_SWITCH_DUAL_CAMERA) && this.mPreferences != null) {
            return com.oplus.camera.util.Util.e_renamed(this.mPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_SWITCH_CAMERA, "camera_main"));
        }
        return super.isCameraSettingMenuOptionEnable(str);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onAfterStartPreview(boolean z_renamed) throws android.content.res.Resources.NotFoundException {
        com.oplus.camera.e_renamed.b_renamed("HSProfessionalCapMode", "onAfterStartPreview");
        com.oplus.camera.professional.h_renamed.a_renamed aVar = this.B_renamed;
        if (aVar != null) {
            aVar.a_renamed(true);
        }
        if (z_renamed()) {
            this.mCameraUIInterface.b_renamed(com.oplus.camera.R_renamed.string.camera_macro_best_focus_distance_text, com.oplus.camera.R_renamed.drawable.screen_hint_textview_bg, com.oplus.camera.R_renamed.color.screen_hint_text_color, java.lang.Integer.valueOf(com.oplus.camera.aps.config.CameraConfig.getConfigIntValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_MACRO_BEST_FOCUS_DISTANCE)));
        }
        if (getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_PRO_HISTOGRAM)) {
            U_renamed();
        }
        r_renamed();
        O_renamed();
        m_renamed();
        super.onAfterStartPreview(z_renamed);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void onBeforePreview() throws java.lang.NumberFormatException {
        com.oplus.camera.e_renamed.a_renamed("HSProfessionalCapMode", "onBeforePreview");
        this.mActivity.runOnUiThread(new java.lang.Runnable() { // from class: com.oplus.camera.professional.h_renamed.9
            @Override // java.lang.Runnable
            public void run() {
                if (com.oplus.camera.professional.h_renamed.this.mOneCamera == null || com.oplus.camera.professional.h_renamed.this.mOneCamera.e_renamed() == null || com.oplus.camera.professional.h_renamed.this.mOneCamera.e_renamed().s_renamed()) {
                    com.oplus.camera.professional.h_renamed.this.a_renamed(true, 4);
                } else {
                    if (4 == com.oplus.camera.professional.h_renamed.this.v_renamed.getSelectedIndex()) {
                        com.oplus.camera.professional.h_renamed.this.mCameraInterface.a_renamed(true, true);
                        com.oplus.camera.professional.h_renamed.this.mCameraInterface.d_renamed(true);
                        com.oplus.camera.professional.h_renamed.this.w_renamed.e_renamed();
                        com.oplus.camera.professional.h_renamed.this.v_renamed.a_renamed();
                        com.oplus.camera.professional.h_renamed.this.mOneCamera.j_renamed(false);
                    }
                    com.oplus.camera.professional.h_renamed.this.a_renamed(false, 4);
                }
                if (com.oplus.camera.professional.h_renamed.this.v_renamed != null) {
                    com.oplus.camera.professional.h_renamed.this.v_renamed.a_renamed(true, false);
                    if (com.oplus.camera.professional.h_renamed.this.v_renamed.isSelected()) {
                        com.oplus.camera.professional.h_renamed.this.mCameraInterface.a_renamed((android.animation.AnimatorListenerAdapter) null, false, false);
                        com.oplus.camera.professional.h_renamed.this.b_renamed(4, true);
                    } else {
                        com.oplus.camera.professional.h_renamed.this.b_renamed(0, true);
                    }
                }
            }
        });
        this.mOneCamera.a_renamed((com.oplus.ocs.camera.CameraParameter.PreviewKey<com.oplus.ocs.camera.CameraParameter.PreviewKey<java.lang.Float>>) com.oplus.ocs.camera.CameraParameter.ZOOM_RATIO, (com.oplus.ocs.camera.CameraParameter.PreviewKey<java.lang.Float>) java.lang.Float.valueOf(this.mCameraInterface.ak_renamed()));
        if (getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_FOCUS_PEAKING)) {
            this.mOneCamera.a_renamed(this.mPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_FOCUS_PEAKING, "off").equals("on_renamed"), false);
        }
        if (this.E_renamed || this.mPreferences.getBoolean(com.oplus.camera.ui.CameraUIInterface.KEY_RESTORE_PROFESSIONAL_PARAMS, false)) {
            com.oplus.camera.e_renamed.a_renamed("HSProfessionalCapMode", "onBeforePreview, initParamToAuto");
            b_renamed(false);
            final java.lang.String string = this.mPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_PARAMETER_SAVING, "off");
            if (!getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_PARAMETER_SAVING) || string.equals("off")) {
                return;
            }
            this.mActivity.runOnUiThread(new java.lang.Runnable() { // from class: com.oplus.camera.professional.h_renamed.10
                @Override // java.lang.Runnable
                public void run() {
                    com.oplus.camera.professional.h_renamed.this.a_renamed(false, string);
                }
            });
            return;
        }
        if (this.mbCapModeInit) {
            k_renamed();
        }
        f_renamed(false);
        D_renamed();
    }

    private void D_renamed() {
        if (this.mPreferences == null || this.mOneCamera == null) {
            com.oplus.camera.e_renamed.b_renamed("HSProfessionalCapMode", "mPreferences or mOneCamera is_renamed null");
            return;
        }
        if (getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_SUPER_RAW_CONTROL)) {
            java.lang.String string = this.mPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_SUPER_RAW_CONTROL, "off");
            char c2 = 65535;
            int iHashCode = string.hashCode();
            if (iHashCode != -332521116) {
                if (iHashCode != 3551) {
                    if (iHashCode == 109935 && string.equals("off")) {
                        c2 = 2;
                    }
                } else if (string.equals("on_renamed")) {
                    c2 = 0;
                }
            } else if (string.equals("super_raw")) {
                c2 = 1;
            }
            if (c2 == 0) {
                this.mOneCamera.a_renamed((com.oplus.ocs.camera.CameraParameter.PreviewKey<com.oplus.ocs.camera.CameraParameter.PreviewKey<java.lang.String>>) com.oplus.ocs.camera.CameraParameter.RAW_CONTROL, (com.oplus.ocs.camera.CameraParameter.PreviewKey<java.lang.String>) "raw");
                return;
            } else if (c2 == 1) {
                this.mOneCamera.a_renamed((com.oplus.ocs.camera.CameraParameter.PreviewKey<com.oplus.ocs.camera.CameraParameter.PreviewKey<java.lang.String>>) com.oplus.ocs.camera.CameraParameter.RAW_CONTROL, (com.oplus.ocs.camera.CameraParameter.PreviewKey<java.lang.String>) "super_raw");
                return;
            } else {
                if (c2 != 2) {
                    return;
                }
                this.mOneCamera.a_renamed((com.oplus.ocs.camera.CameraParameter.PreviewKey<com.oplus.ocs.camera.CameraParameter.PreviewKey<java.lang.String>>) com.oplus.ocs.camera.CameraParameter.RAW_CONTROL, (com.oplus.ocs.camera.CameraParameter.PreviewKey<java.lang.String>) "none");
                return;
            }
        }
        if ("on_renamed".equals(this.mPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_RAW_CONTROL, "off"))) {
            this.mOneCamera.a_renamed((com.oplus.ocs.camera.CameraParameter.PreviewKey<com.oplus.ocs.camera.CameraParameter.PreviewKey<java.lang.String>>) com.oplus.ocs.camera.CameraParameter.RAW_CONTROL, (com.oplus.ocs.camera.CameraParameter.PreviewKey<java.lang.String>) "raw");
        } else {
            this.mOneCamera.a_renamed((com.oplus.ocs.camera.CameraParameter.PreviewKey<com.oplus.ocs.camera.CameraParameter.PreviewKey<java.lang.String>>) com.oplus.ocs.camera.CameraParameter.RAW_CONTROL, (com.oplus.ocs.camera.CameraParameter.PreviewKey<java.lang.String>) "none");
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public java.lang.String getFlashMode() throws android.content.res.Resources.NotFoundException {
        if (this.mPreferences == null || this.mActivity == null || this.mbFlashTemporaryDisabled) {
            return "off";
        }
        java.lang.String string = this.C_renamed.getString(com.oplus.camera.R_renamed.string.camera_exposure_time_default_value);
        java.lang.String string2 = this.mPreferences.getString("pref_professional_exposure_time_key", string);
        return (android.text.TextUtils.isEmpty(string2) || !string2.equals(string)) ? "off" : super.getFlashMode();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(android.view.View view) {
        com.oplus.camera.ui.RotateImageView rotateImageView;
        if (view.getId() == com.oplus.camera.R_renamed.id_renamed.professional_parameter_bottom_guide_entry && this.mCameraUIInterface != null && (rotateImageView = this.G_renamed) != null && rotateImageView.getVisibility() == 0) {
            this.mCameraUIInterface.at_renamed();
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void hideViewWhileResume() {
        com.oplus.camera.professional.h_renamed.a_renamed aVar = this.B_renamed;
        if (aVar != null) {
            aVar.setVisibility(4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E_renamed() {
        com.oplus.camera.professional.g_renamed gVar;
        if (this.v_renamed == null || (gVar = this.w_renamed) == null) {
            return;
        }
        gVar.setPreference(4);
    }

    private void F_renamed() {
        com.oplus.camera.professional.g_renamed gVar;
        if (this.v_renamed == null || (gVar = this.w_renamed) == null) {
            return;
        }
        gVar.setPreference(5);
    }

    private void G_renamed() {
        com.oplus.camera.professional.g_renamed gVar;
        if (this.v_renamed == null || (gVar = this.w_renamed) == null) {
            return;
        }
        gVar.setPreference(1);
        this.w_renamed.setPreference(2);
    }

    private void H_renamed() {
        com.oplus.camera.professional.g_renamed gVar;
        if (this.v_renamed == null || (gVar = this.w_renamed) == null) {
            return;
        }
        gVar.setPreference(3);
    }

    private void I_renamed() {
        com.oplus.camera.professional.e_renamed eVar = this.v_renamed;
        if (eVar != null) {
            eVar.setVisibility(8);
            this.v_renamed.setItemPressed(false);
        }
        com.oplus.camera.professional.g_renamed gVar = this.w_renamed;
        if (gVar != null) {
            gVar.setVisibility(4);
        }
    }

    private void J_renamed() {
        com.oplus.camera.professional.e_renamed eVar = this.v_renamed;
        if (eVar != null) {
            eVar.setVisibility(0);
            this.v_renamed.setItemPressed(true);
        }
        com.oplus.camera.professional.g_renamed gVar = this.w_renamed;
        if (gVar != null) {
            gVar.setVisibility(0);
        }
    }

    private void K_renamed() {
        com.oplus.camera.professional.g_renamed gVar = this.w_renamed;
        if (gVar != null) {
            gVar.clearAnimation();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a_renamed(boolean z_renamed, int i_renamed) {
        android.view.View viewA;
        com.oplus.camera.professional.e_renamed eVar = this.v_renamed;
        if (eVar == null || (viewA = eVar.a_renamed(i_renamed)) == null) {
            return;
        }
        viewA.setEnabled(z_renamed);
        if (viewA instanceof com.oplus.camera.professional.y_renamed) {
            ((com.oplus.camera.professional.y_renamed) viewA).setRotateViewClickable(z_renamed);
        }
        this.v_renamed.getAdapter().b_renamed(viewA, z_renamed, true);
    }

    @Override // com.oplus.camera.professional.e_renamed.b_renamed
    public void a_renamed(android.view.View view, android.view.View view2, long j_renamed) throws java.lang.NumberFormatException {
        if (this.mCameraInterface.A_renamed()) {
            return;
        }
        int iA = this.v_renamed.a_renamed(view2);
        if (iA == 0) {
            b_renamed(true);
            a_renamed(1);
            return;
        }
        if (com.oplus.camera.professional.e_renamed.a_renamed.NO_PRESSED == this.v_renamed.getModePressState() && this.v_renamed.isSelected()) {
            onBackPressed();
            a_renamed(iA, false);
            return;
        }
        this.mCameraInterface.d_renamed(false);
        this.mCameraInterface.a_renamed((android.animation.AnimatorListenerAdapter) null, true, true);
        b_renamed(4, true);
        this.mCameraUIInterface.B_renamed(false);
        if (this.mCameraUIInterface.T_renamed()) {
            this.mCameraUIInterface.x_renamed(false);
        }
        K_renamed();
        com.oplus.camera.e_renamed.f_renamed("HSProfessionalCapMode", "onItemClick, index: " + iA + ", id_renamed: " + j_renamed);
        a_renamed(iA, true);
        if (2 == iA) {
            this.o_renamed = isSuperRawOpen();
        }
        this.w_renamed.a_renamed(iA, true);
    }

    private void e_renamed(boolean z_renamed) {
        java.lang.String string = this.mPreferences.getString("pref_professional_whitebalance_key", this.C_renamed.getString(com.oplus.camera.R_renamed.string.camera_whitebalance_default_value));
        if (this.C_renamed.getString(com.oplus.camera.R_renamed.string.camera_whitebalance_default_value).equals(string)) {
            this.mOneCamera.a_renamed(-1, z_renamed);
        }
        if (a_renamed(string, this.w_renamed.c_renamed(5))) {
            try {
                this.mOneCamera.a_renamed(java.lang.Integer.parseInt(string), z_renamed);
            } catch (java.lang.NumberFormatException unused) {
                this.mOneCamera.i_renamed(z_renamed);
            }
        } else {
            this.mOneCamera.i_renamed(z_renamed);
        }
        com.oplus.camera.e_renamed.a_renamed("HSProfessionalCapMode", "setWhiteBalance, whiteBalance: " + string);
        a_renamed(8);
    }

    public void a_renamed(boolean z_renamed) {
        this.mOneCamera.i_renamed(z_renamed);
        a_renamed(8);
    }

    private void e_renamed(java.lang.String str) {
        a_renamed(str, true);
    }

    private void a_renamed(java.lang.String str, boolean z_renamed) {
        if (str == null) {
            str = this.mPreferences.getString("pref_professional_iso_key", this.C_renamed.getString(com.oplus.camera.R_renamed.string.camera_iso_default_value));
        }
        if (!this.mPreferences.getString("pref_professional_iso_key", this.C_renamed.getString(com.oplus.camera.R_renamed.string.camera_iso_default_value)).equals(str)) {
            android.content.SharedPreferences.Editor editorEdit = this.mPreferences.edit();
            editorEdit.putString("pref_professional_iso_key", com.oplus.camera.professional.x_renamed.a_renamed(this.mActivity, 1));
            editorEdit.apply();
        }
        if (this.C_renamed.getString(com.oplus.camera.R_renamed.string.camera_iso_default_value).equals(str)) {
            this.mOneCamera.b_renamed(-1, z_renamed);
        } else {
            R_renamed();
            this.mOneCamera.r_renamed();
            this.mOneCamera.b_renamed(java.lang.Integer.parseInt(str), z_renamed);
        }
        com.oplus.camera.e_renamed.a_renamed("HSProfessionalCapMode", "setISOValue, iso: " + str);
        a_renamed(7);
        a_renamed(8);
    }

    public void a_renamed(java.lang.String str) {
        if (str == null) {
            str = this.mPreferences.getString("pref_professional_focus_mode_key", this.mActivity.getString(com.oplus.camera.R_renamed.string.camera_focus_mode_default_value));
        }
        com.oplus.camera.e_renamed.a_renamed("HSProfessionalCapMode", "setFocusValue, focusValue: " + str);
        if (this.mActivity.getString(com.oplus.camera.R_renamed.string.camera_focus_mode_default_value).equals(str)) {
            return;
        }
        this.A_renamed.removeMessages(2);
        android.os.Message messageObtain = android.os.Message.obtain();
        messageObtain.what = 2;
        messageObtain.obj = java.lang.Float.valueOf(java.lang.Float.parseFloat(str));
        this.A_renamed.sendMessage(messageObtain);
        if (this.i_renamed) {
            g_renamed(false);
        }
        a_renamed(8);
    }

    public int c_renamed() {
        return java.lang.Integer.parseInt(this.mPreferences.getString("pref_professional_exposure_compensation_key", this.C_renamed.getString(com.oplus.camera.R_renamed.string.camera_exposure_compensation_default_value)));
    }

    private void L_renamed() throws java.lang.NumberFormatException {
        f_renamed(true);
    }

    private void f_renamed(boolean z_renamed) throws java.lang.NumberFormatException {
        java.lang.String string = this.mPreferences.getString("pref_professional_exposure_time_key", this.C_renamed.getString(com.oplus.camera.R_renamed.string.camera_exposure_time_default_value));
        long jLongValue = java.lang.Long.valueOf(this.C_renamed.getString(com.oplus.camera.R_renamed.string.camera_exposure_time_default_value)).longValue();
        long j_renamed = java.lang.Long.parseLong(string);
        if (j_renamed != jLongValue) {
            R_renamed();
        }
        if (this.mbFrontCamera) {
            this.mOneCamera.a_renamed(jLongValue, z_renamed);
        } else {
            this.mOneCamera.a_renamed(j_renamed, z_renamed);
        }
        a_renamed(5);
        a_renamed(7);
        a_renamed(8);
    }

    private void b_renamed(final java.lang.String str, boolean z_renamed) {
        final java.lang.Boolean boolValueOf = java.lang.Boolean.valueOf(z_renamed);
        com.oplus.camera.e_renamed.a_renamed("HSProfessionalCapMode", "setFlashModeMenuEnable, exposureTime: " + str + ", mDisPlayFlashIcon: " + boolValueOf);
        if (android.text.TextUtils.isEmpty(str)) {
            return;
        }
        try {
            if (java.lang.Integer.parseInt(str) == 0) {
                if (this.mCameraUIInterface != null) {
                    this.mCameraUIInterface.b_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_FLASH_MODE, (java.lang.String) null);
                    a_renamed(true, z_renamed);
                }
            } else if (this.mCameraUIInterface != null) {
                a_renamed(false, z_renamed);
                this.mCameraUIInterface.a_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_FLASH_MODE, "off");
            }
        } catch (java.lang.Exception e_renamed) {
            e_renamed.printStackTrace();
            if (this.mActivity != null) {
                this.mActivity.runOnUiThread(new java.lang.Runnable() { // from class: com.oplus.camera.professional.h_renamed.11
                    @Override // java.lang.Runnable
                    public void run() {
                        if (java.lang.Integer.parseInt(str) == 0) {
                            if (com.oplus.camera.professional.h_renamed.this.mCameraUIInterface != null) {
                                com.oplus.camera.professional.h_renamed.this.a_renamed(true, boolValueOf.booleanValue());
                                com.oplus.camera.professional.h_renamed.this.mCameraUIInterface.b_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_FLASH_MODE, (java.lang.String) null);
                                return;
                            }
                            return;
                        }
                        if (com.oplus.camera.professional.h_renamed.this.mCameraUIInterface != null) {
                            com.oplus.camera.professional.h_renamed.this.a_renamed(false, boolValueOf.booleanValue());
                            com.oplus.camera.professional.h_renamed.this.mCameraUIInterface.a_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_FLASH_MODE, "off");
                        }
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a_renamed(boolean z_renamed, boolean z2) {
        if (z2) {
            com.oplus.camera.e_renamed.a_renamed("HSProfessionalCapMode", "showOrHideFlashIcon, enable: " + z_renamed + ", isOpenFlash: " + isOpenFlash());
            if (z_renamed) {
                displayScreenHintIconInSwitchOn();
            } else {
                this.mCameraUIInterface.a_renamed(false, true, false);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B_renamed:124:0x0298  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:135:? A_renamed[RETURN, SYNTHETIC] */
    @Override // com.oplus.camera.capmode.BaseMode
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onSharedPreferenceChanged(android.content.SharedPreferences r17, java.lang.String r18) throws android.content.res.Resources.NotFoundException, java.lang.NumberFormatException {
        /*
            Method dump skipped, instructions count: 671
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.professional.h_renamed.onSharedPreferenceChanged(android.content.SharedPreferences, java.lang.String):void");
    }

    private void M_renamed() throws android.content.res.Resources.NotFoundException, java.lang.NumberFormatException {
        if (getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_SUPER_RAW_CONTROL)) {
            java.lang.String string = this.mPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_SUPER_RAW_CONTROL, "off");
            char c2 = 65535;
            int iHashCode = string.hashCode();
            if (iHashCode != -332521116) {
                if (iHashCode != 3551) {
                    if (iHashCode == 109935 && string.equals("off")) {
                        c2 = 2;
                    }
                } else if (string.equals("on_renamed")) {
                    c2 = 0;
                }
            } else if (string.equals("super_raw")) {
                c2 = 1;
            }
            if (c2 == 0) {
                this.mCameraUIInterface.a_renamed(com.oplus.camera.R_renamed.string.camera_scene_tips_professional_raw_format, -1, true, false, false);
                this.mOneCamera.a_renamed((com.oplus.ocs.camera.CameraParameter.PreviewKey<com.oplus.ocs.camera.CameraParameter.PreviewKey<java.lang.String>>) com.oplus.ocs.camera.CameraParameter.RAW_CONTROL, (com.oplus.ocs.camera.CameraParameter.PreviewKey<java.lang.String>) "raw");
            } else if (c2 == 1) {
                this.mCameraUIInterface.a_renamed(com.oplus.camera.R_renamed.string.camera_scene_tips_professional_raw_super_format, -1, true, false, false);
                this.w_renamed.b_renamed(false);
                b_renamed(true);
                this.w_renamed.b_renamed(true);
                if (!this.o_renamed) {
                    this.o_renamed = true;
                }
                this.mOneCamera.a_renamed((com.oplus.ocs.camera.CameraParameter.PreviewKey<com.oplus.ocs.camera.CameraParameter.PreviewKey<java.lang.String>>) com.oplus.ocs.camera.CameraParameter.RAW_CONTROL, (com.oplus.ocs.camera.CameraParameter.PreviewKey<java.lang.String>) "super_raw");
                if (!"standard".equals(this.mPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_PHOTO_RATIO, "standard"))) {
                    this.mPreferences.edit().putString(com.oplus.camera.ui.CameraUIInterface.KEY_PHOTO_RATIO, "standard").apply();
                    if (this.mCameraUIInterface != null) {
                        this.mCameraUIInterface.f_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_PHOTO_RATIO);
                    }
                }
            } else if (c2 == 2) {
                this.mCameraUIInterface.a_renamed(com.oplus.camera.R_renamed.string.camera_scene_tips_professional_jpeg_format, -1, true, false, false);
                this.mOneCamera.a_renamed((com.oplus.ocs.camera.CameraParameter.PreviewKey<com.oplus.ocs.camera.CameraParameter.PreviewKey<java.lang.String>>) com.oplus.ocs.camera.CameraParameter.RAW_CONTROL, (com.oplus.ocs.camera.CameraParameter.PreviewKey<java.lang.String>) "none");
            }
            if (this.mCameraInterface != null) {
                this.mCameraInterface.aH_renamed();
            }
            this.w_renamed.a_renamed(getCameraInfo(this.D_renamed), isSuperRawOpen() ? 2000000000L : getCameraInfo(this.D_renamed).x_renamed());
            this.w_renamed.a_renamed();
        } else if ("on_renamed".equals(this.mPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_RAW_CONTROL, "off"))) {
            this.mCameraUIInterface.a_renamed(com.oplus.camera.R_renamed.string.camera_raw_control_hint_on, -1, true, false, false);
            this.mOneCamera.a_renamed((com.oplus.ocs.camera.CameraParameter.PreviewKey<com.oplus.ocs.camera.CameraParameter.PreviewKey<java.lang.String>>) com.oplus.ocs.camera.CameraParameter.RAW_CONTROL, (com.oplus.ocs.camera.CameraParameter.PreviewKey<java.lang.String>) "raw");
        } else {
            this.mCameraUIInterface.a_renamed(com.oplus.camera.R_renamed.string.camera_raw_control_hint_off, -1, true, false, false);
            this.mOneCamera.a_renamed((com.oplus.ocs.camera.CameraParameter.PreviewKey<com.oplus.ocs.camera.CameraParameter.PreviewKey<java.lang.String>>) com.oplus.ocs.camera.CameraParameter.RAW_CONTROL, (com.oplus.ocs.camera.CameraParameter.PreviewKey<java.lang.String>) "none");
        }
        if (this.mCameraInterface != null) {
            if (getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_ZOOM) && !this.v_renamed.isSelected()) {
                this.mCameraInterface.a_renamed(true, false);
                this.mCameraInterface.d_renamed(true);
            } else {
                this.mCameraInterface.a_renamed((android.animation.AnimatorListenerAdapter) null, true, false);
            }
            b_renamed(0, true);
            if (d_renamed()) {
                this.mCameraInterface.aH_renamed();
            }
        }
        this.mOneCamera.a_renamed((com.oplus.camera.e_renamed.d_renamed.c_renamed) null);
    }

    private void N_renamed() {
        if (!getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_FOCUS_PEAKING) || androidx.preference.j_renamed.a_renamed(this.mActivity).getBoolean("focus_peaking_clicked", false) || this.w_renamed == null || this.mPreferences == null) {
            return;
        }
        boolean zG = this.w_renamed.g_renamed(4);
        if (zG != this.mPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_FOCUS_PEAKING, "off").equals("on_renamed")) {
            return;
        }
        this.mPreferences.edit().putString(com.oplus.camera.ui.CameraUIInterface.KEY_FOCUS_PEAKING, zG ? "off" : "on_renamed").apply();
        this.mCameraUIInterface.f_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_FOCUS_PEAKING);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void setFlashTemporaryDisabled(boolean z_renamed) throws android.content.res.Resources.NotFoundException {
        if (getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_SWITCH_CAMERA) && getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_FLASH_MODE) && this.mPreferences != null) {
            java.lang.String string = this.mPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_SWITCH_CAMERA, "camera_main");
            java.lang.String flashMode = getFlashMode();
            boolean z2 = true;
            if (com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_SUPPORT_FLASH_FULL_ZOOM)) {
                if (!"camera_tele".equals(string) || (!"on_renamed".equals(flashMode) && !"auto".equals(flashMode))) {
                    z2 = false;
                }
                this.mbFlashTemporaryDisabled = z2;
                return;
            }
            this.mbFlashTemporaryDisabled = !"camera_main".equals(string);
            return;
        }
        this.mbFlashTemporaryDisabled = z_renamed;
    }

    private void O_renamed() throws android.content.res.Resources.NotFoundException {
        if (this.mPreferences == null) {
            return;
        }
        java.lang.String string = this.mPreferences.getString("pref_professional_exposure_time_key", this.C_renamed.getString(com.oplus.camera.R_renamed.string.camera_exposure_time_default_value));
        java.lang.String string2 = this.mPreferences.getString("pref_professional_iso_key", this.C_renamed.getString(com.oplus.camera.R_renamed.string.camera_iso_default_value));
        if (getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_SWITCH_CAMERA) && getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_FLASH_MODE) && this.C_renamed.getString(com.oplus.camera.R_renamed.string.camera_exposure_time_default_value).equals(string) && this.C_renamed.getString(com.oplus.camera.R_renamed.string.camera_iso_default_value).equals(string2)) {
            java.lang.String string3 = this.mPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_SWITCH_CAMERA, "camera_main");
            java.lang.String flashMode = getFlashMode();
            if (com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_SUPPORT_FLASH_FULL_ZOOM)) {
                if ("camera_tele".equals(string3)) {
                    if ("on_renamed".equals(flashMode) || "auto".equals(flashMode)) {
                        this.mbFlashTemporaryDisabled = true;
                        updateFlashState("off");
                        this.mCameraUIInterface.b_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_FLASH_MODE, "off");
                    }
                    this.mCameraUIInterface.b_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_FLASH_MODE, "on_renamed", "auto");
                } else {
                    this.mbFlashTemporaryDisabled = false;
                    this.mCameraUIInterface.a_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_FLASH_MODE, "on_renamed", "auto");
                    this.mCameraUIInterface.b_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_FLASH_MODE, (java.lang.String) null);
                    updateFlashState(flashMode);
                }
            } else if ("camera_main".equals(string3)) {
                this.mbFlashTemporaryDisabled = false;
                updateFlashState(getFlashMode());
                this.mCameraUIInterface.b_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_FLASH_MODE, (java.lang.String) null);
            } else {
                this.mbFlashTemporaryDisabled = true;
                updateFlashState("off");
                this.mCameraUIInterface.a_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_FLASH_MODE, "off");
            }
            this.mCameraUIInterface.f_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_FLASH_MODE);
        }
    }

    private void P_renamed() {
        android.view.View viewA;
        android.view.View viewA2;
        if ("off".equals(this.mPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_FLASH_MODE, this.mActivity.getString(com.oplus.camera.R_renamed.string.camera_flash_mode_default_value)))) {
            return;
        }
        java.lang.String string = this.mPreferences.getString("pref_professional_exposure_time_key", this.C_renamed.getString(com.oplus.camera.R_renamed.string.camera_exposure_time_default_value));
        java.lang.String string2 = this.mPreferences.getString("pref_professional_iso_key", this.C_renamed.getString(com.oplus.camera.R_renamed.string.camera_iso_default_value));
        if (!this.C_renamed.getString(com.oplus.camera.R_renamed.string.camera_exposure_time_default_value).equals(string)) {
            this.w_renamed.setAuto(2);
            if (this.v_renamed.isSelected() && (viewA2 = this.v_renamed.a_renamed(2)) != null) {
                this.v_renamed.getAdapter().a_renamed(viewA2, 0, true);
            }
        }
        if (this.C_renamed.getString(com.oplus.camera.R_renamed.string.camera_iso_default_value).equals(string2)) {
            return;
        }
        this.w_renamed.setAuto(1);
        if (!this.v_renamed.isSelected() || (viewA = this.v_renamed.a_renamed(1)) == null) {
            return;
        }
        this.v_renamed.getAdapter().a_renamed(viewA, 0, true);
    }

    private void g_renamed(boolean z_renamed) {
        boolean zEquals = z_renamed ? true ^ "off".equals(this.mPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_FLASH_MODE, this.mActivity.getString(com.oplus.camera.R_renamed.string.camera_flash_mode_default_value))) : true;
        if (this.i_renamed && zEquals) {
            android.content.SharedPreferences.Editor editorEdit = this.mPreferences.edit();
            editorEdit.putString(com.oplus.camera.ui.CameraUIInterface.KEY_HIGH_RESOLUTION, "off");
            editorEdit.apply();
            this.mCameraUIInterface.b_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_HIGH_RESOLUTION, "off");
        }
    }

    private void Q_renamed() {
        com.oplus.camera.e_renamed.a_renamed("HSProfessionalCapMode", "updateHighResolutionMode");
        this.i_renamed = "on_renamed".equals(this.mPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_HIGH_RESOLUTION, this.C_renamed.getString(com.oplus.camera.R_renamed.string.camera_high_resolution_default_value)));
        com.oplus.camera.ui.control.b_renamed bVar = new com.oplus.camera.ui.control.b_renamed(1);
        bVar.a_renamed("button_color_inside_none");
        this.mOneCamera.m_renamed(getZSLMode());
        if (this.i_renamed) {
            R_renamed();
            S_renamed();
            this.w_renamed.setAuto(1);
            this.w_renamed.setAuto(2);
            this.w_renamed.setAuto(5);
            this.w_renamed.setAuto(4);
            com.oplus.camera.professional.g_renamed gVar = this.w_renamed;
            gVar.a_renamed(3, "pref_professional_exposure_compensation_key", gVar.c_renamed(3).indexOf(com.oplus.camera.professional.x_renamed.a_renamed(this.mActivity, 3)));
            a_renamed(1);
            this.mCameraUIInterface.a_renamed(bVar);
            if (this.mOneCamera.p_renamed() == 0) {
                this.mOneCamera.a_renamed(getDefaultAFMode(), com.oplus.camera.a_renamed.b_renamed(), com.oplus.camera.a_renamed.b_renamed(), true);
                this.mOneCamera.a_renamed((android.hardware.camera2.CaptureRequest.Key<android.hardware.camera2.CaptureRequest.Key>) android.hardware.camera2.CaptureRequest.CONTROL_AE_EXPOSURE_COMPENSATION, (android.hardware.camera2.CaptureRequest.Key) java.lang.Integer.valueOf(com.oplus.camera.a_renamed.c_renamed()));
                this.mOneCamera.a_renamed((com.oplus.camera.e_renamed.d_renamed.c_renamed) null);
            }
            if (1 == this.mOneCamera.p_renamed() || 4 == this.mOneCamera.p_renamed()) {
                E_renamed();
                this.w_renamed.setPanelsBarAuto(4);
            }
            this.mCameraUIInterface.a_renamed(com.oplus.camera.R_renamed.string.camera_toast_high_resolution_on, -1, true, false, false);
            return;
        }
        this.mCameraUIInterface.a_renamed(com.oplus.camera.R_renamed.string.camera_toast_high_resolution_off, -1, true, false, false);
        this.mCameraUIInterface.a_renamed(bVar);
    }

    private void R_renamed() {
        if ("off".equals(this.mPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_FLASH_MODE, this.mActivity.getString(com.oplus.camera.R_renamed.string.camera_flash_mode_default_value)))) {
            return;
        }
        android.content.SharedPreferences.Editor editorEdit = this.mPreferences.edit();
        editorEdit.putString(com.oplus.camera.ui.CameraUIInterface.KEY_FLASH_MODE, "off");
        editorEdit.apply();
        this.mActivity.runOnUiThread(new java.lang.Runnable() { // from class: com.oplus.camera.professional.h_renamed.13
            @Override // java.lang.Runnable
            public void run() {
                if (com.oplus.camera.professional.h_renamed.this.mbPaused) {
                    return;
                }
                com.oplus.camera.professional.h_renamed.this.mCameraUIInterface.f_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_FLASH_MODE);
            }
        });
    }

    private void S_renamed() {
        if ("off".equals(this.mPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_RAW, "off"))) {
            return;
        }
        android.content.SharedPreferences.Editor editorEdit = this.mPreferences.edit();
        editorEdit.putString(com.oplus.camera.ui.CameraUIInterface.KEY_RAW, "off");
        editorEdit.apply();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean isNeedProgressBarInCapture() {
        java.lang.String string = this.mPreferences.getString("pref_professional_exposure_time_key", this.C_renamed.getString(com.oplus.camera.R_renamed.string.camera_exposure_time_default_value));
        return android.text.TextUtils.isEmpty(string) || java.lang.Long.valueOf(string).longValue() >= com.google.android.exoplayer2.C_renamed.NANOS_PER_SECOND;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public com.oplus.camera.statistics.model.DcsMsgData onGetBeforeCaptureMsgCommonData(com.oplus.camera.statistics.model.DcsMsgData dcsMsgData) {
        com.oplus.camera.statistics.model.CaptureMsgData captureMsgData = (dcsMsgData == null || !(dcsMsgData instanceof com.oplus.camera.statistics.model.CaptureMsgData)) ? null : (com.oplus.camera.statistics.model.CaptureMsgData) dcsMsgData;
        if (captureMsgData == null) {
            return null;
        }
        java.lang.String strE = this.w_renamed.e_renamed(5);
        java.lang.String strA = this.w_renamed.a_renamed(java.lang.Integer.valueOf(this.w_renamed.e_renamed(3)).intValue(), this.mOneCamera.e_renamed().r_renamed());
        java.lang.String strE2 = this.w_renamed.e_renamed(2);
        java.lang.String strE3 = this.w_renamed.e_renamed(1);
        java.lang.String focusValue = this.w_renamed.getFocusValue();
        if (android.text.TextUtils.equals(strE2, this.mActivity.getString(com.oplus.camera.R_renamed.string.camera_exposure_time_default_value))) {
            strE2 = "auto";
        }
        captureMsgData.mProfessionWbValue = strE;
        captureMsgData.mProfessionEvValue = strA;
        captureMsgData.mProfessionExpValue = strE2;
        captureMsgData.mProfessionISOValue = strE3;
        captureMsgData.mProfessionFocusValue = focusValue;
        captureMsgData.mProfessionHighResolution = java.lang.String.valueOf(this.i_renamed);
        java.lang.String string = "off";
        if (this.mPreferences != null) {
            if (getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_SUPER_RAW_CONTROL)) {
                string = this.mPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_SUPER_RAW_CONTROL, "off");
            } else {
                string = this.mPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_RAW_CONTROL, "off");
            }
        }
        captureMsgData.mProfessionRawControl = string;
        captureMsgData.mProfessionCameraId = this.mPreferences != null ? this.mPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_SWITCH_CAMERA, "camera_main") : "camera_main";
        return captureMsgData;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void changeModeAllViewWhenAnimation(int i_renamed, boolean z_renamed) {
        super.changeModeAllViewWhenAnimation(i_renamed, z_renamed);
        if (i_renamed == 3) {
            this.B_renamed.a_renamed((z_renamed && this.mbInCapturing) ? false : z_renamed);
            int i2 = z_renamed ? 0 : 8;
            com.oplus.camera.util.Util.a_renamed(this.B_renamed, i2, (android.view.animation.Animation.AnimationListener) null, 300L);
            if (t_renamed()) {
                com.oplus.camera.util.Util.a_renamed(this.x_renamed, i2, (android.view.animation.Animation.AnimationListener) null, 300L);
                return;
            }
            return;
        }
        if (i_renamed != 5) {
            if (i_renamed == 17 && z_renamed && z_renamed()) {
                this.A_renamed.sendEmptyMessageDelayed(6, 3000L);
                return;
            }
            return;
        }
        if (z_renamed) {
            com.oplus.camera.professional.e_renamed eVar = this.v_renamed;
            if (eVar != null) {
                eVar.setVisibility(0);
                return;
            }
            return;
        }
        if (this.v_renamed != null) {
            I_renamed();
        }
    }

    /* compiled from: HSProfessionalCapMode.java */
    private class a_renamed extends android.widget.RelativeLayout {

        /* renamed from: b_renamed, reason: collision with root package name */
        private boolean f5176b;

        public a_renamed(android.content.Context context) {
            super(context);
            this.f5176b = true;
        }

        public void a_renamed(boolean z_renamed) {
            this.f5176b = z_renamed;
        }

        @Override // android.view.ViewGroup, android.view.View
        public boolean dispatchTouchEvent(android.view.MotionEvent motionEvent) {
            if (com.oplus.camera.professional.h_renamed.this.mbCapModeInit && this.f5176b && com.oplus.camera.professional.h_renamed.this.mCameraInterface != null && !com.oplus.camera.professional.h_renamed.this.j_renamed) {
                if (com.oplus.camera.professional.h_renamed.this.mCameraInterface.C_renamed()) {
                    android.view.MotionEvent motionEventObtain = android.view.MotionEvent.obtain(motionEvent);
                    motionEventObtain.setAction(3);
                    super.dispatchTouchEvent(motionEventObtain);
                    return true;
                }
                return super.dispatchTouchEvent(motionEvent);
            }
            if (this.f5176b) {
                return false;
            }
            android.view.MotionEvent motionEventObtain2 = android.view.MotionEvent.obtain(motionEvent);
            motionEventObtain2.setAction(3);
            super.dispatchTouchEvent(motionEventObtain2);
            return false;
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public int getDefaultAFMode() {
        return super.getDefaultAFMode();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected int getHintTextId() {
        if (this.mPreferences == null) {
            return -1;
        }
        java.lang.String string = this.mPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_SWITCH_CAMERA, "camera_main");
        if ("camera_main".equals(string)) {
            return com.oplus.camera.util.Util.f_renamed(com.oplus.camera.R_renamed.string.camera_switch_main);
        }
        if ("camera_ultra_wide".equals(string)) {
            if (com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_IS_UW_FIXED_FOCUS) || java.lang.Float.compare(this.mOneCamera.e_renamed().n_renamed(), 0.0f) == 0) {
                return com.oplus.camera.util.Util.f_renamed(com.oplus.camera.R_renamed.string.camera_switch_ultra_wide);
            }
            return com.oplus.camera.util.Util.f_renamed(com.oplus.camera.R_renamed.string.camera_switch_ultra_wide_micro_lens);
        }
        if ("camera_tele".equals(string)) {
            return com.oplus.camera.R_renamed.string.camera_switch_tele;
        }
        if ("camera_macro".equals(string)) {
            return com.oplus.camera.R_renamed.string.camera_switch_macro;
        }
        return -1;
    }

    private void a_renamed(int i_renamed, boolean z_renamed) {
        com.oplus.camera.statistics.model.MenuClickMsgData menuClickMsgData = new com.oplus.camera.statistics.model.MenuClickMsgData(this.mActivity);
        menuClickMsgData.buildEvent(false);
        if (i_renamed == 1) {
            menuClickMsgData.mFuncKeyId = 28;
        } else if (i_renamed == 2) {
            menuClickMsgData.mFuncKeyId = 27;
        } else if (i_renamed == 3) {
            menuClickMsgData.mFuncKeyId = 15;
        } else if (i_renamed == 4) {
            menuClickMsgData.mFuncKeyId = 14;
        } else if (i_renamed == 5) {
            menuClickMsgData.mFuncKeyId = 13;
        }
        menuClickMsgData.mFuncKeyResult = z_renamed ? 1 : 2;
        menuClickMsgData.mCaptureMode = getCameraMode();
        menuClickMsgData.mCameraId = this.mCameraInterface.aw_renamed();
        menuClickMsgData.mOrientation = this.mOrientation;
        menuClickMsgData.mRearOrFront = com.oplus.camera.e_renamed.a_renamed.a_renamed(this.mCameraInterface.aw_renamed()) ? com.oplus.camera.statistics.model.DcsMsgData.FRONT : com.oplus.camera.statistics.model.DcsMsgData.REAR;
        menuClickMsgData.report();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a_renamed(int i_renamed, java.lang.String str, boolean z_renamed) {
        com.oplus.camera.statistics.model.MenuClickMsgData menuClickMsgData = new com.oplus.camera.statistics.model.MenuClickMsgData(this.mActivity);
        menuClickMsgData.buildEvent(true);
        if (i_renamed == 1) {
            menuClickMsgData.mFuncKeyId = 28;
            menuClickMsgData.mItem = com.oplus.camera.statistics.model.MenuClickMsgData.KEY_PROFESSION_ISO_VALUE;
        } else if (i_renamed == 2) {
            menuClickMsgData.mFuncKeyId = 27;
            menuClickMsgData.mItem = com.oplus.camera.statistics.model.MenuClickMsgData.KEY_PROFESSION_EXPOSURE_TIME;
            str = this.mPreferences.getString("pref_professional_exposure_time_key", "");
        } else if (i_renamed == 3) {
            menuClickMsgData.mFuncKeyId = 15;
            menuClickMsgData.mItem = com.oplus.camera.statistics.model.MenuClickMsgData.KEY_PROFESSION_EXPOSURE_COMPENSATION;
        } else if (i_renamed == 4) {
            menuClickMsgData.mFuncKeyId = 14;
            menuClickMsgData.mItem = com.oplus.camera.statistics.model.MenuClickMsgData.KEY_PROFESSION_FOCUS_VALUE;
        } else if (i_renamed == 5) {
            menuClickMsgData.mFuncKeyId = 13;
            menuClickMsgData.mItem = com.oplus.camera.statistics.model.MenuClickMsgData.KEY_PROFESSION_WHITE_BALANCE;
        }
        menuClickMsgData.mCaptureMode = getCameraMode();
        menuClickMsgData.mCameraId = this.mCameraInterface.aw_renamed();
        menuClickMsgData.mOrientation = this.mOrientation;
        menuClickMsgData.mItemValue = str;
        menuClickMsgData.mRearOrFront = com.oplus.camera.e_renamed.a_renamed.a_renamed(this.mCameraInterface.aw_renamed()) ? com.oplus.camera.statistics.model.DcsMsgData.FRONT : com.oplus.camera.statistics.model.DcsMsgData.REAR;
        menuClickMsgData.report();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean isInPreviewArea(android.view.MotionEvent motionEvent) {
        android.graphics.Rect rect = new android.graphics.Rect();
        this.mCameraUIInterface.p_renamed().getHitRect(rect);
        return rect.contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY());
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public com.oplus.camera.af_renamed getZoomConfigure() {
        com.oplus.camera.af_renamed zoomConfigure = super.getZoomConfigure();
        zoomConfigure.h_renamed(getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_SWITCH_CAMERA));
        return zoomConfigure;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected boolean isModeBarSelected() {
        return this.v_renamed.isSelected();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean isSubMenuEnable() {
        return getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_SUB_SETTING);
    }

    public boolean d_renamed() {
        return com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_RAW_ZOOM_MUTEX_SUPPORT);
    }

    private void a_renamed(final int i_renamed, final java.lang.String str) {
        if (this.mActivity != null) {
            this.mActivity.runOnUiThread(new java.lang.Runnable() { // from class: com.oplus.camera.professional.h_renamed.15
                @Override // java.lang.Runnable
                public void run() {
                    if (str == null || com.oplus.camera.professional.h_renamed.this.v_renamed == null || str.equals(com.oplus.camera.professional.h_renamed.this.v_renamed.b_renamed(i_renamed))) {
                        return;
                    }
                    com.oplus.camera.professional.h_renamed.this.v_renamed.a_renamed(i_renamed, str);
                }
            });
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean isBottomGuideEntryViewShown() {
        com.oplus.camera.ui.RotateImageView rotateImageView = this.G_renamed;
        return rotateImageView != null && rotateImageView.isShown();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public java.lang.String getHeicCodecFormat() {
        if (isSuperRawOpen()) {
            return null;
        }
        return super.getHeicCodecFormat();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onMoreModeShown() throws android.content.res.Resources.NotFoundException {
        super.onMoreModeShown();
        this.P_renamed = true;
        I_renamed();
        if (this.mCameraUIInterface != null) {
            this.mCameraUIInterface.a_renamed(0, 1);
        }
        com.oplus.camera.ui.RotateImageView rotateImageView = this.x_renamed;
        if (rotateImageView != null) {
            rotateImageView.setVisibility(4);
        }
        d_renamed(false);
        b_renamed(false, false);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onMoreModeHidden(int i_renamed) throws android.content.res.Resources.NotFoundException {
        super.onMoreModeHidden(i_renamed);
        boolean zF = this.mCameraInterface.F_renamed();
        this.P_renamed = zF;
        if (!zF) {
            J_renamed();
        }
        if (this.v_renamed.isSelected()) {
            this.mCameraUIInterface.a_renamed(4, 0);
        }
        if (this.x_renamed != null && t_renamed() && !zF) {
            this.x_renamed.setVisibility(0);
        }
        d_renamed(false);
        b_renamed(false, false);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean isShowProPanelMenu() {
        com.oplus.camera.professional.e_renamed eVar = this.v_renamed;
        if (eVar != null) {
            return eVar.isSelected();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b_renamed(int i_renamed, boolean z_renamed) {
        if (isPanelMode()) {
            this.mCameraUIInterface.a_renamed(i_renamed, z_renamed);
        } else {
            this.mCameraUIInterface.a_renamed(i_renamed, z_renamed ? 1 : 0);
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean isShowZoomMenu() {
        return !a_renamed();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean isAutoFocus() {
        return android.text.TextUtils.equals(this.mPreferences.getString("pref_professional_focus_mode_key", this.mActivity.getString(com.oplus.camera.R_renamed.string.camera_focus_mode_default_value)), this.mActivity.getString(com.oplus.camera.R_renamed.string.camera_focus_mode_default_value));
    }

    private boolean T_renamed() {
        return (this.mPreferences == null || !this.mPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_PRO_HISTOGRAM, "off").equals("on_renamed") || this.mPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_SUB_SETTING, "off").equals("on_renamed") || this.P_renamed || !this.Q_renamed) ? false : true;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean isHistogramOpen() {
        return getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_PRO_HISTOGRAM) && T_renamed();
    }

    private void U_renamed() throws android.content.res.Resources.NotFoundException {
        d_renamed(this.aa_renamed);
        com.oplus.camera.p_renamed pVar = this.y_renamed;
        if (pVar == null) {
            this.y_renamed = new com.oplus.camera.p_renamed(this.mActivity, this.mCameraRootView, this.z_renamed);
        } else {
            pVar.a_renamed(this.z_renamed, A_renamed(), B_renamed());
        }
        android.util.Size previewSize = getPreviewSize(this.mOneCamera.e_renamed());
        this.y_renamed.a_renamed(com.oplus.camera.p_renamed.a_renamed(previewSize.getWidth(), previewSize.getHeight()));
    }

    private void V_renamed() throws android.content.res.Resources.NotFoundException {
        d_renamed(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d_renamed(int i_renamed) throws android.content.res.Resources.NotFoundException {
        com.oplus.camera.e_renamed.a_renamed("HSProfessionalCapMode", "updateHistogramLayoutConfigs, offsetY: " + i_renamed);
        android.content.res.Resources resources = this.mActivity.getResources();
        int dimensionPixelSize = resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.professional_histogram_margin_top);
        int dimensionPixelSize2 = resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.professional_histogram_margin_start);
        int dimensionPixelSize3 = resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.histogram_graph_view_width);
        int dimensionPixelSize4 = resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.histogram_graph_view_height);
        if (this.mOrientation % 180 == 0) {
            dimensionPixelSize += i_renamed;
        } else if (90 == this.mOrientation) {
            dimensionPixelSize2 += i_renamed;
        }
        if (this.z_renamed == null) {
            this.z_renamed = new com.oplus.camera.p_renamed.a_renamed();
            this.z_renamed.f4922a = 10;
        }
        com.oplus.camera.e_renamed.a_renamed("HSProfessionalCapMode", "updateHistogramLayoutConfigs, previewMarginTop: " + p_renamed());
        if (this.mOrientation % 180 == 0) {
            com.oplus.camera.p_renamed.a_renamed aVar = this.z_renamed;
            aVar.f4923b = this.ad_renamed + dimensionPixelSize;
            aVar.d_renamed = dimensionPixelSize2;
            aVar.e_renamed = this.mOrientation;
            return;
        }
        com.oplus.camera.p_renamed.a_renamed aVar2 = this.z_renamed;
        aVar2.f4923b = ((dimensionPixelSize3 - dimensionPixelSize4) / 2) + this.ad_renamed + dimensionPixelSize;
        aVar2.d_renamed = ((dimensionPixelSize4 - dimensionPixelSize3) / 2) + dimensionPixelSize2;
        aVar2.e_renamed = (this.mOrientation + 180) % 360;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b_renamed(boolean z_renamed, boolean z2) throws android.content.res.Resources.NotFoundException {
        a_renamed(z_renamed, z2, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a_renamed(boolean z_renamed, boolean z2, boolean z3) throws android.content.res.Resources.NotFoundException {
        boolean zT;
        if (this.mPreferences == null || this.y_renamed == null || !getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_PRO_HISTOGRAM) || (zT = T_renamed()) == this.y_renamed.b_renamed()) {
            return;
        }
        if (this.aa_renamed != 0 && !z3) {
            this.aa_renamed = 0;
            d_renamed(0);
        } else if (z3) {
            d_renamed(this.aa_renamed);
        }
        com.oplus.camera.professional.u_renamed.a_renamed aVar = new com.oplus.camera.professional.u_renamed.a_renamed();
        aVar.f5239a = zT;
        if (z_renamed) {
            aVar.f5240b = zT ? 250 : 0;
            aVar.f5241c = 250;
        } else if (z2) {
            int dimensionPixelSize = this.mActivity.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.professional_histogram_animation_offset);
            aVar.f5241c = zT ? 500 : 250;
            aVar.g_renamed = 500;
            aVar.d_renamed = zT ? dimensionPixelSize : 0.0f;
            aVar.e_renamed = zT ? 0.0f : dimensionPixelSize;
        }
        if (zT) {
            this.y_renamed.a_renamed(aVar);
        } else {
            this.y_renamed.b_renamed(aVar);
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onYuvDataReceviced(byte[] bArr) {
        if (this.y_renamed == null || !isHistogramOpen()) {
            return;
        }
        this.y_renamed.a_renamed(bArr);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void onTopSubMenuExpand() {
        if (this.v_renamed.isSelected()) {
            this.mCameraInterface.a_renamed(true, true);
            this.mCameraInterface.d_renamed(true);
            b_renamed(0, true);
            com.oplus.camera.professional.u_renamed.a_renamed aVar = new com.oplus.camera.professional.u_renamed.a_renamed();
            aVar.f5239a = false;
            aVar.f5241c = 250;
            aVar.g_renamed = 400;
            aVar.d_renamed = 0.0f;
            aVar.e_renamed = this.mActivity.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.hs_main_mode_bar_item_animation_offset);
            this.w_renamed.setAllPopupInvisibility(aVar);
            this.v_renamed.a_renamed();
            this.mOneCamera.j_renamed(true);
            return;
        }
        super.onTopSubMenuExpand();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean getTouchEnable(boolean z_renamed, int i_renamed, int i2) throws android.content.res.Resources.NotFoundException {
        int dimensionPixelSize = this.mActivity.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.exposure_indicator_width);
        int dimensionPixelSize2 = this.mActivity.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.main_mode_bar_item_title_image_margin);
        android.graphics.Rect rect = new android.graphics.Rect();
        this.v_renamed.getGlobalVisibleRect(rect);
        int i3 = dimensionPixelSize / 2;
        rect.left -= i3;
        rect.top -= i3 - dimensionPixelSize2;
        rect.right += i3;
        rect.bottom += i3;
        return z_renamed && !rect.contains(i_renamed, i2);
    }
}

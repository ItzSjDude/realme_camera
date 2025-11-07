package com.oplus.camera.professional;

/* compiled from: ProfessionalCapMode.java */
/* loaded from: classes2.dex */
public class v_renamed extends com.oplus.camera.capmode.BaseMode implements android.view.View.OnClickListener, com.oplus.camera.professional.ListProfessionalModeBar.OnItemClickListener {
    private com.oplus.camera.p_renamed.a_renamed A_renamed;
    private android.os.Handler B_renamed;
    private com.oplus.camera.professional.v_renamed.a_renamed C_renamed;
    private android.content.res.Resources D_renamed;
    private int E_renamed;
    private boolean F_renamed;
    private boolean G_renamed;
    private boolean H_renamed;
    private com.oplus.camera.ui.RotateImageView I_renamed;
    private int J_renamed;
    private android.animation.ValueAnimator K_renamed;
    private int L_renamed;
    private int M_renamed;
    private int N_renamed;
    private float O_renamed;
    private boolean P_renamed;
    private boolean Q_renamed;
    private byte[] R_renamed;
    private com.oplus.ocs.camera.CameraPictureCallback.CameraPictureImage S_renamed;
    private boolean T_renamed;
    private boolean U_renamed;
    private boolean V_renamed;
    private int W_renamed;
    private int X_renamed;
    private int Y_renamed;
    private int Z_renamed;
    private int aa_renamed;
    private int ab_renamed;
    private int ac_renamed;
    private int ad_renamed;
    private int ae_renamed;
    private int af_renamed;
    private java.lang.String ag_renamed;
    private byte[] ah_renamed;
    private android.widget.TextView ai_renamed;
    private android.animation.ValueAnimator aj_renamed;
    private android.view.animation.PathInterpolator ak_renamed;
    private com.oplus.camera.screen.b_renamed.a_renamed al_renamed;
    private com.oplus.camera.professional.p_renamed.b_renamed am_renamed;
    private final java.lang.Object g_renamed;
    private volatile boolean h_renamed;
    private volatile boolean i_renamed;
    private boolean j_renamed;
    private boolean k_renamed;
    private boolean l_renamed;
    private boolean m_renamed;
    private boolean n_renamed;
    private boolean o_renamed;
    private boolean p_renamed;
    private boolean q_renamed;
    private boolean r_renamed;
    private int s_renamed;
    private long t_renamed;
    private java.lang.Thread u_renamed;
    private com.oplus.camera.ui.h_renamed v_renamed;
    private com.oplus.camera.professional.ListProfessionalModeBar w_renamed;
    private com.oplus.camera.professional.p_renamed x_renamed;
    private com.oplus.camera.ui.RotateImageView y_renamed;
    private com.oplus.camera.p_renamed z_renamed;

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
    protected void onStop() {
    }

    public v_renamed(android.app.Activity activity, com.oplus.camera.capmode.a_renamed aVar, com.oplus.camera.ui.CameraUIInterface cameraUIInterface, com.oplus.camera.ui.preview.a_renamed.t_renamed tVar) {
        super(activity, aVar, cameraUIInterface, tVar);
        this.g_renamed = new java.lang.Object();
        this.h_renamed = false;
        this.i_renamed = false;
        this.j_renamed = false;
        this.k_renamed = false;
        this.l_renamed = false;
        this.m_renamed = false;
        this.n_renamed = true;
        this.o_renamed = false;
        this.p_renamed = false;
        this.q_renamed = false;
        this.r_renamed = false;
        this.s_renamed = 0;
        this.t_renamed = 0L;
        this.u_renamed = null;
        this.v_renamed = null;
        this.w_renamed = null;
        this.x_renamed = null;
        this.y_renamed = null;
        this.z_renamed = null;
        this.A_renamed = null;
        this.B_renamed = null;
        this.C_renamed = null;
        this.E_renamed = -1;
        this.F_renamed = false;
        this.G_renamed = false;
        this.H_renamed = false;
        this.I_renamed = null;
        this.J_renamed = 0;
        this.K_renamed = null;
        this.L_renamed = 0;
        this.M_renamed = 0;
        this.N_renamed = 0;
        this.O_renamed = 0.0f;
        this.P_renamed = false;
        this.Q_renamed = true;
        this.S_renamed = null;
        this.T_renamed = false;
        this.U_renamed = false;
        this.V_renamed = false;
        this.W_renamed = 0;
        this.X_renamed = 0;
        this.Y_renamed = 0;
        this.Z_renamed = 0;
        this.aa_renamed = 0;
        this.ab_renamed = 0;
        this.ac_renamed = 0;
        this.ad_renamed = 0;
        this.ae_renamed = 0;
        this.af_renamed = 0;
        this.ag_renamed = null;
        this.ah_renamed = null;
        this.ai_renamed = null;
        this.aj_renamed = null;
        this.ak_renamed = new android.view.animation.PathInterpolator(0.3f, 0.0f, 0.1f, 1.0f);
        this.al_renamed = null;
        this.am_renamed = new com.oplus.camera.professional.p_renamed.b_renamed() { // from class: com.oplus.camera.professional.v_renamed.15
            @Override // com.oplus.camera.professional.p_renamed.b_renamed
            public void a_renamed(int i_renamed, java.lang.String str, boolean z_renamed) {
                com.oplus.camera.professional.v_renamed.this.a_renamed(i_renamed, str, z_renamed);
            }
        };
        this.D_renamed = activity.getApplicationContext().getResources();
        this.L_renamed = this.D_renamed.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.main_mode_bar_height);
        this.M_renamed = this.D_renamed.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.common_sub_mode_bar_height);
        this.N_renamed = this.D_renamed.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.professional_mode_panel_container_margin_bottom);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean onSingleTapUp(android.view.MotionEvent motionEvent) {
        com.oplus.camera.e_renamed.a_renamed("ProfessionalCapMode", "onSingleTapUp");
        if (this.mCameraUIInterface.e_renamed((int) motionEvent.getX(), (int) motionEvent.getY())) {
            return false;
        }
        boolean z_renamed = 4 == f_renamed();
        if ((isInPreviewArea(motionEvent) || z_renamed) && this.w_renamed.isSelected() && !this.mCameraInterface.A_renamed()) {
            onBackPressed();
        }
        a_renamed(motionEvent);
        return false;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onShareMenuExpand() {
        if (this.w_renamed.isSelected()) {
            this.mCameraInterface.a_renamed(true, true);
            this.mCameraInterface.d_renamed(true);
            com.oplus.camera.professional.u_renamed.a_renamed aVar = new com.oplus.camera.professional.u_renamed.a_renamed();
            aVar.f5239a = false;
            aVar.f5241c = 250;
            aVar.g_renamed = 400;
            aVar.d_renamed = 0.0f;
            aVar.e_renamed = this.mActivity.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.main_mode_bar_item_animation_offset);
            this.x_renamed.setAllPopupInvisibility(aVar);
            this.w_renamed.a_renamed();
            this.mOneCamera.j_renamed(true);
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean onLongPress(android.view.MotionEvent motionEvent) {
        com.oplus.camera.e_renamed.a_renamed("ProfessionalCapMode", "onLongPress");
        a_renamed(motionEvent);
        return false;
    }

    private void a_renamed(android.view.MotionEvent motionEvent) {
        com.oplus.camera.screen.b_renamed.a_renamed aVarAU;
        android.graphics.Rect rect = new android.graphics.Rect();
        this.mCameraUIInterface.p_renamed().getHitRect(rect);
        if (rect.contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY())) {
            if (1 == getDefaultAFMode() || 4 == getDefaultAFMode()) {
                J_renamed();
                this.x_renamed.setPanelsBarAuto(4);
            }
            if (this.mCameraInterface != null && isBubbleOpen(com.oplus.camera.ui.CameraUIInterface.KEY_EXPOSURE_FOCUS_SEPARATE_TIPS) && (aVarAU = this.mCameraInterface.aU_renamed()) != null && aVarAU.a_renamed(this.mCameraUIInterface, (int) motionEvent.getX(), (int) motionEvent.getY()) && getTouchEnable(true, (int) motionEvent.getX(), (int) motionEvent.getY())) {
                com.oplus.camera.e_renamed.a_renamed("ProfessionalCapMode", "onSingleTapUp, bubble open, KEY_EXPOSURE_FOCUS_SEPARATE_TIPS");
                this.mCameraUIInterface.a_renamed(this.mActivity.findViewById(com.oplus.camera.R_renamed.id_renamed.oplus_setting_bar), 18, (int) motionEvent.getX(), (int) motionEvent.getY());
            }
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onRawImageReceived(com.oplus.ocs.camera.CameraPictureCallback.CameraPictureImage cameraPictureImage) {
        this.S_renamed = cameraPictureImage;
        if (isSuperRawOpen()) {
            synchronized (this.g_renamed) {
                this.T_renamed = true;
            }
            j_renamed();
            return;
        }
        i_renamed();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean consumeImage(com.oplus.ocs.camera.CameraPictureCallback.CameraPictureImage cameraPictureImage) {
        if (!isSuperRawOpen() || 256 != cameraPictureImage.getFormat() || 4 != cameraPictureImage.getSourceType()) {
            return false;
        }
        this.W_renamed = cameraPictureImage.getWidth();
        this.X_renamed = cameraPictureImage.getHeight();
        synchronized (this.g_renamed) {
            this.R_renamed = cameraPictureImage.getImage();
        }
        this.Y_renamed = 1;
        this.Z_renamed = 1;
        this.ah_renamed = new byte[this.Y_renamed * this.Z_renamed * 3];
        j_renamed();
        return true;
    }

    private void i_renamed() {
        byte[] image = this.S_renamed.getImage();
        com.oplus.camera.g_renamed.a_renamed.e_renamed eVarA = com.oplus.camera.g_renamed.a_renamed.e_renamed.a_renamed(image);
        final long j_renamed = this.mCaptureDate - 10;
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("saveResultToDng, mRawPreviewJpeg : ");
        sb.append(this.R_renamed != null);
        com.oplus.camera.e_renamed.b_renamed("ProfessionalCapMode", sb.toString());
        if (eVarA != null) {
            if (this.R_renamed != null) {
                eVarA.a_renamed(eVarA.f_renamed, j_renamed);
                eVarA.b_renamed();
                eVarA.f_renamed.a_renamed(this.ah_renamed);
                eVarA.f_renamed.b_renamed(256).a_renamed(new int[]{this.Y_renamed});
                eVarA.f_renamed.b_renamed(257).a_renamed(new int[]{this.Z_renamed});
                eVarA.f_renamed.b_renamed(262).a_renamed(new int[]{this.Z_renamed});
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
        this.S_renamed = null;
        if (this.mActivity != null) {
            this.mActivity.runOnUiThread(new java.lang.Runnable() { // from class: com.oplus.camera.professional.v_renamed.1
                @Override // java.lang.Runnable
                public void run() {
                    com.oplus.camera.professional.v_renamed.this.pictureTakenCallback(bArr, 0, 0, com.oplus.camera.util.Util.a_renamed(format), true, false, false, j_renamed, 0);
                }
            });
        }
        com.oplus.camera.e_renamed.a_renamed("ProfessionalCapMode", "saveResultToDng finished");
    }

    private com.oplus.camera.g_renamed.a_renamed.c_renamed a_renamed(java.nio.ByteOrder byteOrder) {
        com.oplus.camera.g_renamed.a_renamed.c_renamed cVar = new com.oplus.camera.g_renamed.a_renamed.c_renamed();
        cVar.f4550c = new java.util.ArrayList<>();
        cVar.a_renamed(byteOrder);
        cVar.a_renamed(254, new int[]{1});
        cVar.a_renamed(256, new int[]{this.W_renamed});
        cVar.a_renamed(257, new int[]{this.X_renamed});
        cVar.a_renamed(258, new int[]{8, 8, 8});
        cVar.a_renamed(259, new int[]{7});
        cVar.a_renamed(262, new int[]{6});
        cVar.a_renamed(273, new int[]{0});
        cVar.a_renamed(277, new int[]{3});
        cVar.a_renamed(278, new int[]{this.X_renamed});
        cVar.a_renamed(279, new int[]{this.R_renamed.length});
        cVar.a_renamed(284, new int[]{1});
        cVar.a_renamed(529, new int[]{1});
        cVar.a_renamed(530, new int[]{1, 1});
        cVar.a_renamed(531, new int[]{2});
        cVar.a_renamed(532, new int[]{1});
        return cVar;
    }

    private void j_renamed() {
        synchronized (this.g_renamed) {
            if (this.R_renamed != null && this.T_renamed) {
                i_renamed();
            }
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode, com.oplus.camera.e_renamed.d_renamed.a_renamed
    public void onCaptureStarted(android.hardware.camera2.CameraCaptureSession cameraCaptureSession, android.hardware.camera2.CaptureRequest captureRequest, long j_renamed, long j2) {
        com.oplus.camera.professional.p_renamed pVar;
        super.onCaptureStarted(cameraCaptureSession, captureRequest, j_renamed, j2);
        if (this.mCameraUIInterface == null || (pVar = this.x_renamed) == null || pVar.g_renamed(5) || com.oplus.camera.util.Util.C_renamed() || !isFlashState()) {
            return;
        }
        this.mCameraUIInterface.c_renamed().b_renamed(j2, j_renamed);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean needDelayCloseForCapture() {
        if (com.google.android.exoplayer2.C_renamed.NANOS_PER_SECOND <= java.lang.Long.parseLong(m_renamed())) {
            return false;
        }
        return super.needDelayCloseForCapture();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onCameraPermissionGranted() throws android.content.res.Resources.NotFoundException, java.lang.NumberFormatException {
        this.E_renamed = this.mCameraInterface.as_renamed();
        com.oplus.camera.professional.p_renamed pVar = this.x_renamed;
        if (pVar != null) {
            if (this.G_renamed) {
                pVar.a_renamed(getCameraInfo(this.E_renamed), (com.oplus.camera.professional.p_renamed.a_renamed) null);
                if (isSuperRawOpen()) {
                    this.x_renamed.a_renamed(getCameraInfo(this.E_renamed), 2000000000L);
                }
                this.x_renamed.a_renamed();
                return;
            }
            pVar.a_renamed(getCameraInfo(this.E_renamed), this.B_renamed, (com.oplus.camera.professional.p_renamed.a_renamed) null);
            if (isSuperRawOpen()) {
                this.x_renamed.a_renamed(getCameraInfo(this.E_renamed), 2000000000L);
            }
            q_renamed();
            this.x_renamed.setSettleListener(this.w_renamed);
            this.x_renamed.setMotionListener(this.am_renamed);
            com.oplus.camera.professional.v_renamed.a_renamed aVar = this.C_renamed;
            if (aVar != null) {
                aVar.setVisibility(0);
            }
            this.mCameraInterface.d_renamed(true);
            a_renamed(1);
            this.G_renamed = true;
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
        com.oplus.camera.e_renamed.a_renamed("ProfessionalCapMode", "onInitCameraMode, Start");
        restoreProPreference();
        com.oplus.camera.professional.LevelPanel.c_renamed();
        if (isNightProModeSupport()) {
            this.F_renamed = true;
        }
        this.P_renamed = false;
        this.Q_renamed = true;
        this.j_renamed = "on_renamed".equals(this.mPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_HIGH_RESOLUTION, this.D_renamed.getString(com.oplus.camera.R_renamed.string.camera_high_resolution_default_value)));
        if (!this.j_renamed) {
            this.mCameraUIInterface.b_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_HIGH_RESOLUTION, "off");
        }
        if (this.v_renamed == null) {
            this.v_renamed = new com.oplus.camera.ui.h_renamed(this.mCameraUIInterface, new com.oplus.camera.ui.h_renamed.a_renamed() { // from class: com.oplus.camera.professional.v_renamed.12
                @Override // com.oplus.camera.ui.h_renamed.a_renamed
                public void a_renamed(boolean z_renamed) {
                    com.oplus.camera.professional.v_renamed.this.mCameraUIInterface.g_renamed(true);
                    if (z_renamed) {
                        return;
                    }
                    com.oplus.camera.ui.control.b_renamed shutterButtonInfo = com.oplus.camera.professional.v_renamed.this.getShutterButtonInfo();
                    shutterButtonInfo.a_renamed(14);
                    com.oplus.camera.professional.v_renamed.this.mCameraUIInterface.a_renamed(shutterButtonInfo);
                }

                @Override // com.oplus.camera.ui.h_renamed.a_renamed
                public void a_renamed() {
                    if (com.oplus.camera.professional.v_renamed.this.mbPaused) {
                        return;
                    }
                    com.oplus.camera.professional.v_renamed.this.v_renamed.e_renamed();
                }
            });
        }
        if (this.B_renamed == null) {
            this.B_renamed = new android.os.Handler() { // from class: com.oplus.camera.professional.v_renamed.17
                @Override // android.os.Handler
                public void handleMessage(android.os.Message message) {
                    com.oplus.camera.professional.v_renamed.this.a_renamed(message.what, message);
                }
            };
        }
        if (com.google.android.exoplayer2.C_renamed.NANOS_PER_SECOND <= java.lang.Long.parseLong(m_renamed())) {
            this.mCameraUIInterface.a_renamed(getShutterButtonInfo());
        }
        this.mCameraUIInterface.c_renamed(this.mActivity.getString(com.oplus.camera.R_renamed.string.camera_description_common_shutter_button));
        s_renamed();
        if (this.x_renamed != null) {
            if (E_renamed()) {
                this.x_renamed.e_renamed();
            } else {
                this.x_renamed.setVisibility(0);
            }
        }
        if (this.w_renamed != null) {
            int i_renamed = E_renamed() ? 8 : 0;
            this.w_renamed.setAlpha(0.0f);
            this.w_renamed.setVisibility(i_renamed);
        }
        if (this.A_renamed != null && Z_renamed()) {
            this.A_renamed.e_renamed = this.mOrientation;
        }
        k_renamed();
    }

    private void k_renamed() {
        com.oplus.camera.ui.a_renamed.a_renamed aVarK = this.mCameraUIInterface.k_renamed();
        if (aVarK != null) {
            aVarK.a_renamed(new com.oplus.camera.ui.a_renamed.a_renamed.b_renamed() { // from class: com.oplus.camera.professional.v_renamed.18
                @Override // com.oplus.camera.ui.a_renamed.a_renamed.b_renamed
                public void a_renamed(com.oplus.camera.ui.a_renamed.b_renamed bVar) {
                    if (com.oplus.camera.professional.v_renamed.this.isHistogramOpen()) {
                        if ((270 != com.oplus.camera.professional.v_renamed.this.mOrientation || com.oplus.camera.util.Util.t_renamed()) && com.oplus.camera.professional.v_renamed.this.z_renamed != null) {
                            com.oplus.camera.professional.v_renamed.this.aa_renamed = bVar.f5839a;
                            com.oplus.camera.professional.v_renamed.this.ai_renamed.setText(com.oplus.camera.professional.v_renamed.this.mActivity.getResources().getString(com.oplus.camera.professional.v_renamed.this.aa_renamed));
                            com.oplus.camera.professional.v_renamed.this.ai_renamed.getViewTreeObserver().addOnGlobalLayoutListener(new android.view.ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.oplus.camera.professional.v_renamed.18.1
                                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                                public void onGlobalLayout() throws android.content.res.Resources.NotFoundException {
                                    int height;
                                    int height2;
                                    int i_renamed;
                                    com.oplus.camera.professional.v_renamed.this.ai_renamed.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                                    android.view.View viewFindViewById = com.oplus.camera.professional.v_renamed.this.mActivity.findViewById(com.oplus.camera.R_renamed.id_renamed.camera_screen_hint_panel);
                                    com.oplus.camera.screen.b_renamed.a_renamed currentScreenMode = com.oplus.camera.professional.v_renamed.this.getCurrentScreenMode();
                                    com.oplus.camera.p_renamed.a_renamed aVar = new com.oplus.camera.p_renamed.a_renamed();
                                    if (currentScreenMode != null) {
                                        currentScreenMode.a_renamed(aVar, com.oplus.camera.professional.v_renamed.this.t_renamed(), com.oplus.camera.professional.v_renamed.this.mOrientation);
                                    }
                                    java.lang.String string = com.oplus.camera.professional.v_renamed.this.mPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_PHOTO_RATIO, com.oplus.camera.professional.v_renamed.this.mActivity.getString(com.oplus.camera.R_renamed.string.camera_photo_ratio_default_value));
                                    if (com.oplus.camera.util.Util.u_renamed()) {
                                        int y_renamed = (int) (viewFindViewById.getY() + com.oplus.camera.professional.v_renamed.this.ai_renamed.getHeight());
                                        if (com.oplus.camera.professional.v_renamed.this.ac_renamed + y_renamed > aVar.f4923b) {
                                            height2 = y_renamed + com.oplus.camera.professional.v_renamed.this.ac_renamed;
                                            i_renamed = aVar.f4923b;
                                            height = height2 - i_renamed;
                                        } else {
                                            height = 0;
                                        }
                                    } else if (!"square".equals(string) || com.oplus.camera.professional.v_renamed.this.mOrientation % 180 != 0) {
                                        height = com.oplus.camera.professional.v_renamed.this.ai_renamed.getHeight() + com.oplus.camera.professional.v_renamed.this.ac_renamed;
                                    } else {
                                        height2 = com.oplus.camera.professional.v_renamed.this.ai_renamed.getHeight();
                                        i_renamed = com.oplus.camera.professional.v_renamed.this.ad_renamed;
                                        height = height2 - i_renamed;
                                    }
                                    if (com.oplus.camera.professional.v_renamed.this.U_renamed) {
                                        com.oplus.camera.professional.v_renamed.this.U_renamed = false;
                                        com.oplus.camera.professional.v_renamed.this.e_renamed(height);
                                        com.oplus.camera.professional.v_renamed.this.z_renamed.a_renamed(com.oplus.camera.professional.v_renamed.this.A_renamed, false, false);
                                    } else if (com.oplus.camera.professional.v_renamed.this.ab_renamed != height) {
                                        com.oplus.camera.professional.v_renamed.this.a_renamed(com.oplus.camera.professional.v_renamed.this.ab_renamed, height);
                                    }
                                    com.oplus.camera.professional.v_renamed.this.ab_renamed = height;
                                }
                            });
                        }
                    }
                }

                @Override // com.oplus.camera.ui.a_renamed.a_renamed.b_renamed
                public void a_renamed(int i_renamed) throws android.content.res.Resources.NotFoundException {
                    if (i_renamed == com.oplus.camera.professional.v_renamed.this.aa_renamed) {
                        com.oplus.camera.professional.v_renamed.this.ab_renamed = 0;
                    }
                    if (com.oplus.camera.professional.v_renamed.this.isHistogramOpen()) {
                        if ((270 != com.oplus.camera.professional.v_renamed.this.mOrientation || com.oplus.camera.util.Util.t_renamed()) && com.oplus.camera.professional.v_renamed.this.z_renamed != null && i_renamed == com.oplus.camera.professional.v_renamed.this.aa_renamed) {
                            if (com.oplus.camera.professional.v_renamed.this.aj_renamed != null && com.oplus.camera.professional.v_renamed.this.aj_renamed.isRunning()) {
                                com.oplus.camera.professional.v_renamed.this.aj_renamed.cancel();
                            }
                            com.oplus.camera.professional.v_renamed.this.e_renamed(0);
                            com.oplus.camera.professional.v_renamed.this.z_renamed.a_renamed(com.oplus.camera.professional.v_renamed.this.A_renamed, com.oplus.camera.professional.v_renamed.this.F_renamed(), com.oplus.camera.professional.v_renamed.this.G_renamed(), 150L);
                        }
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a_renamed(int i_renamed, int i2) {
        com.oplus.camera.e_renamed.a_renamed("ProfessionalCapMode", "startHistogramTransYAnimtor, originalY: " + i_renamed + ", offsetY: " + i2);
        android.animation.ValueAnimator valueAnimator = this.aj_renamed;
        if (valueAnimator == null) {
            this.aj_renamed = android.animation.ValueAnimator.ofInt(0, i2);
            this.aj_renamed.setDuration(350L);
            this.aj_renamed.setInterpolator(this.ak_renamed);
            this.aj_renamed.addUpdateListener(new android.animation.ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.professional.v_renamed.19
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(android.animation.ValueAnimator valueAnimator2) throws android.content.res.Resources.NotFoundException {
                    com.oplus.camera.professional.v_renamed.this.e_renamed(((java.lang.Integer) valueAnimator2.getAnimatedValue()).intValue());
                    if (com.oplus.camera.professional.v_renamed.this.z_renamed != null) {
                        com.oplus.camera.professional.v_renamed.this.z_renamed.a_renamed(com.oplus.camera.professional.v_renamed.this.A_renamed, com.oplus.camera.professional.v_renamed.this.F_renamed(), com.oplus.camera.professional.v_renamed.this.G_renamed());
                    }
                }
            });
            this.aj_renamed.addListener(new com.oplus.camera.b_renamed.a_renamed() { // from class: com.oplus.camera.professional.v_renamed.20
                @Override // com.oplus.camera.b_renamed.a_renamed, android.animation.Animator.AnimatorListener
                public void onAnimationCancel(android.animation.Animator animator) throws android.content.res.Resources.NotFoundException {
                    super.onAnimationCancel(animator);
                    com.oplus.camera.professional.v_renamed.this.e_renamed(0);
                    if (com.oplus.camera.professional.v_renamed.this.z_renamed != null) {
                        com.oplus.camera.professional.v_renamed.this.z_renamed.a_renamed(com.oplus.camera.professional.v_renamed.this.A_renamed, com.oplus.camera.professional.v_renamed.this.F_renamed(), com.oplus.camera.professional.v_renamed.this.G_renamed());
                    }
                }
            });
        } else {
            valueAnimator.setIntValues(i_renamed, i2);
        }
        if (this.aj_renamed.isRunning()) {
            return;
        }
        this.aj_renamed.start();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onZoomMenuCollapsing() {
        if (this.w_renamed != null) {
            if (1 != f_renamed()) {
                this.w_renamed.a_renamed(true, true);
            }
            if (this.w_renamed == null || 4 != f_renamed()) {
                return;
            }
            this.w_renamed.setVisibilityWithAnimation(0);
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onZoomMenuCollapsed() {
        if (!this.mCameraInterface.A_renamed() && !this.mbInCapturing) {
            this.C_renamed.setEnabled(true);
        } else {
            this.l_renamed = true;
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onZoomMenuExpand() {
        if (this.w_renamed != null) {
            if (1 != f_renamed()) {
                this.w_renamed.a_renamed(false, true);
            }
            if (4 == f_renamed()) {
                com.oplus.camera.professional.p_renamed pVar = this.x_renamed;
                if (pVar != null) {
                    pVar.e_renamed();
                }
                this.w_renamed.a_renamed();
                this.w_renamed.setVisibilityWithAnimation(8);
            }
        }
        this.C_renamed.setEnabled(false);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onZoomTransitionChanged(int i_renamed) throws android.content.res.Resources.NotFoundException {
        q_renamed();
        int zoomBarOffset = i_renamed - getZoomBarOffset();
        if (this.w_renamed != null) {
            float f_renamed = this.O_renamed;
            if (zoomBarOffset <= (-getZoomBarOffset()) / 2) {
                f_renamed = 0.0f;
            }
            if (com.oplus.camera.util.Util.u_renamed()) {
                f_renamed = 1.0f;
            }
            this.w_renamed.setAlpha(f_renamed);
            android.widget.RelativeLayout.LayoutParams layoutParams = (android.widget.RelativeLayout.LayoutParams) this.w_renamed.getLayoutParams();
            layoutParams.bottomMargin = zoomBarOffset;
            this.w_renamed.setLayoutParams(layoutParams);
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onZoomAlphaChanged(float f_renamed) {
        this.O_renamed = f_renamed;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void updateControlPanelBgColor(int i_renamed) {
        if (this.w_renamed == null || 1 == f_renamed()) {
            return;
        }
        this.w_renamed.setBackgroundColor(com.oplus.camera.util.c_renamed.a_renamed(i_renamed));
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean getZSLMode() {
        this.j_renamed = "on_renamed".equals(this.mPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_HIGH_RESOLUTION, this.D_renamed.getString(com.oplus.camera.R_renamed.string.camera_high_resolution_default_value)));
        com.oplus.camera.professional.p_renamed pVar = this.x_renamed;
        if ((pVar != null && !pVar.g_renamed(2)) || isRawOpen()) {
            com.oplus.camera.e_renamed.a_renamed("ProfessionalCapMode", "getZSLMode exposure time isn't_renamed auto or raw open,so return false");
            return false;
        }
        if (this.j_renamed) {
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
        return this.mPreferences != null && getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_SUPER_RAW_CONTROL) && "super_raw".equals(this.mPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_SUPER_RAW_CONTROL, "off"));
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
            this.mCameraUIInterface.a_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_SUPER_RAW_CONTROL, true, (int) this.D_renamed.getDimension(com.oplus.camera.R_renamed.dimen.super_raw_setting_menu_reddot_offset_x), (int) this.D_renamed.getDimension(com.oplus.camera.R_renamed.dimen.super_raw_setting_menu_reddot_offset_y));
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void closeImageReader() {
        com.oplus.camera.e_renamed.a_renamed("ProfessionalCapMode", "closeImageReader");
        this.n_renamed = true;
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

    private boolean l_renamed() {
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
        if (com.oplus.camera.ui.CameraUIInterface.KEY_RAW_CONTROL.equals(str)) {
            return getSupportFunction(str) && l_renamed();
        }
        if (com.oplus.camera.ui.CameraUIInterface.KEY_SUPER_RAW_CONTROL.equals(str)) {
            return com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_SUPPORT_PROFESSIONAL_SUPER_RAW) && l_renamed();
        }
        return super.getSupportMenu(str);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean getSupportSubMenu(java.lang.String str) {
        if (com.oplus.camera.ui.CameraUIInterface.KEY_CAMERA_TIMER_SHUTTER.equals(str) || com.oplus.camera.ui.CameraUIInterface.KEY_PHOTO_RATIO.equals(str) || com.oplus.camera.ui.CameraUIInterface.KEY_SETTING.equals(str)) {
            return getSupportFunction(str);
        }
        return (com.oplus.camera.ui.CameraUIInterface.KEY_RAW_CONTROL.equals(str) || com.oplus.camera.ui.CameraUIInterface.KEY_SUPER_RAW_CONTROL.equals(str)) && getSupportFunction(str) && !l_renamed();
    }

    public int b_renamed() {
        return this.mCameraInterface.u_renamed();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public java.lang.String m_renamed() {
        return this.mPreferences == null ? "-1" : this.mPreferences.getString("pref_professional_exposure_time_key", "-1");
    }

    private long n_renamed() {
        return java.lang.Long.parseLong(this.mPreferences.getString("pref_professional_exposure_time_key", this.D_renamed.getString(com.oplus.camera.R_renamed.string.camera_exposure_time_default_value)));
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public int getCaptureIso() {
        java.lang.String string = this.mPreferences.getString("pref_professional_iso_key", this.D_renamed.getString(com.oplus.camera.R_renamed.string.camera_iso_default_value));
        if (this.D_renamed.getString(com.oplus.camera.R_renamed.string.camera_iso_default_value).equals(string)) {
            return this.s_renamed;
        }
        return java.lang.Integer.parseInt(string);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public long getCaptureExposureTime() throws java.lang.NumberFormatException {
        long j_renamed = java.lang.Long.parseLong(m_renamed());
        return -1 == j_renamed ? this.t_renamed : j_renamed;
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
                com.oplus.camera.e_renamed.f_renamed("ProfessionalCapMode", "onPreviewCaptureResult, invalid totalResult: " + cameraPreviewResult);
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
            if (num != null && this.x_renamed.g_renamed(1) && (iA4 = a_renamed(num.intValue(), this.x_renamed.c_renamed(1))) > -1 && (!this.x_renamed.c_renamed(1, iA4) || !this.o_renamed)) {
                com.oplus.camera.e_renamed.b_renamed("ProfessionalCapMode", "onPreviewCaptureResult, iso: " + num);
                this.s_renamed = num.intValue();
                java.util.ArrayList<java.lang.String> arrayListD = this.x_renamed.d_renamed(1);
                if (arrayListD != null && arrayListD.size() > iA4) {
                    java.lang.String str = arrayListD.get(iA4);
                    com.oplus.camera.professional.LevelPanel.a_renamed("pref_professional_iso_key", str);
                    this.x_renamed.scrollTo(1, iA4);
                    a_renamed(1, str);
                }
            }
            if (l_renamed != null && this.x_renamed.g_renamed(2) && (iA3 = a_renamed(l_renamed.longValue(), this.x_renamed.c_renamed(2))) > -1 && (!this.x_renamed.c_renamed(2, iA3) || !this.o_renamed)) {
                com.oplus.camera.e_renamed.b_renamed("ProfessionalCapMode", "onPreviewCaptureResult, exposureTime: " + l_renamed);
                this.t_renamed = l_renamed.longValue();
                java.util.ArrayList<java.lang.String> arrayListD2 = this.x_renamed.d_renamed(2);
                if (arrayListD2 != null && arrayListD2.size() > iA3) {
                    java.lang.String str2 = arrayListD2.get(iA3);
                    com.oplus.camera.professional.LevelPanel.a_renamed("pref_professional_exposure_time_key", str2);
                    this.x_renamed.scrollTo(2, iA3);
                    a_renamed(2, str2);
                }
            }
            if (this.x_renamed.g_renamed(5) && (iA2 = a_renamed(i_renamed, this.x_renamed.c_renamed(5))) > -1 && (!this.x_renamed.c_renamed(5, iA2) || !this.o_renamed)) {
                com.oplus.camera.e_renamed.b_renamed("ProfessionalCapMode", "onPreviewCaptureResult, cct: " + i_renamed);
                java.util.ArrayList<java.lang.String> arrayListD3 = this.x_renamed.d_renamed(5);
                if (arrayListD3 != null && arrayListD3.size() > iA2) {
                    java.lang.String str3 = arrayListD3.get(iA2);
                    com.oplus.camera.professional.LevelPanel.a_renamed("pref_professional_whitebalance_key", str3);
                    this.x_renamed.scrollTo(5, iA2);
                    a_renamed(5, str3);
                }
            }
            if (f_renamed != null && this.x_renamed.g_renamed(4) && (iA = a_renamed(f_renamed.floatValue(), this.x_renamed.c_renamed(4))) > -1 && (!this.x_renamed.c_renamed(4, iA) || !this.o_renamed)) {
                com.oplus.camera.e_renamed.b_renamed("ProfessionalCapMode", "onPreviewCaptureResult, focusDistance: " + f_renamed);
                java.util.ArrayList<java.lang.String> arrayListD4 = this.x_renamed.d_renamed(4);
                if (arrayListD4 != null && arrayListD4.size() > iA) {
                    java.lang.String str4 = arrayListD4.get(iA);
                    com.oplus.camera.professional.LevelPanel.a_renamed("pref_professional_focus_mode_key", str4);
                    this.x_renamed.scrollTo(4, iA);
                    a_renamed(4, str4);
                }
            }
            this.o_renamed = true;
        }
    }

    /* JADX WARN: Can't_renamed fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B_renamed:104:0x0188  */
    @Override // com.oplus.camera.capmode.BaseMode
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean getSupportFunction(java.lang.String r12) {
        /*
            Method dump skipped, instructions count: 960
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.professional.v_renamed.getSupportFunction(java.lang.String):boolean");
    }

    private void a_renamed(com.oplus.camera.professional.ListProfessionalModeBar listProfessionalModeBar, int i_renamed, com.oplus.camera.professional.ListModeBarAdapter listModeBarAdapter, com.oplus.camera.professional.ListProfessionalModeBar.OnItemClickListener onItemClickListener) throws android.content.res.Resources.NotFoundException {
        if (listProfessionalModeBar != null) {
            com.oplus.camera.screen.b_renamed.a_renamed currentScreenMode = getCurrentScreenMode();
            if (currentScreenMode != null) {
                listProfessionalModeBar.setScreenMode(currentScreenMode);
            }
            listProfessionalModeBar.setId(i_renamed);
            listProfessionalModeBar.setAdapter(listModeBarAdapter);
            listProfessionalModeBar.setOnItemClickListener(onItemClickListener);
        }
    }

    private void o_renamed() throws java.lang.NumberFormatException {
        if (this.mOneCamera != null) {
            if (this.j_renamed) {
                this.mOneCamera.a_renamed(java.lang.Long.parseLong(this.D_renamed.getString(com.oplus.camera.R_renamed.string.camera_exposure_time_default_value)));
                this.mOneCamera.a_renamed(java.lang.Long.parseLong(this.D_renamed.getString(com.oplus.camera.R_renamed.string.camera_exposure_time_default_value)), false);
            } else {
                java.lang.String strA = com.oplus.camera.professional.x_renamed.a_renamed(this.mActivity, 5);
                if (this.mPreferences.getString("pref_professional_whitebalance_key", strA).equals(strA)) {
                    a_renamed(false);
                } else {
                    e_renamed(false);
                }
                if (E_renamed()) {
                    this.mOneCamera.a_renamed((android.hardware.camera2.CaptureRequest.Key<android.hardware.camera2.CaptureRequest.Key>) android.hardware.camera2.CaptureRequest.CONTROL_AE_EXPOSURE_COMPENSATION, (android.hardware.camera2.CaptureRequest.Key) java.lang.Integer.valueOf(com.oplus.camera.a_renamed.c_renamed()));
                } else {
                    this.mOneCamera.a_renamed((android.hardware.camera2.CaptureRequest.Key<android.hardware.camera2.CaptureRequest.Key>) android.hardware.camera2.CaptureRequest.CONTROL_AE_EXPOSURE_COMPENSATION, (android.hardware.camera2.CaptureRequest.Key) java.lang.Integer.valueOf(c_renamed()));
                }
                a_renamed((java.lang.String) null, false);
                f_renamed(false);
                a_renamed((java.lang.String) null);
            }
            a_renamed(3);
        }
    }

    private void b_renamed(boolean z_renamed) throws java.lang.NumberFormatException {
        this.F_renamed = false;
        c_renamed(z_renamed);
        a_renamed(3);
        this.mPreferences.edit().remove(com.oplus.camera.ui.CameraUIInterface.KEY_RESTORE_PROFESSIONAL_PARAMS).apply();
    }

    public void a_renamed(int i_renamed) {
        if (java.lang.Thread.currentThread() != this.u_renamed) {
            android.os.Handler handler = this.B_renamed;
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
                if (this.w_renamed.isSelected()) {
                    int selectedPosition = this.w_renamed.getSelectedPosition();
                    this.w_renamed.a_renamed(selectedPosition, true);
                    android.view.View childAt = this.w_renamed.getChildAt(selectedPosition);
                    if (childAt != null && this.x_renamed.g_renamed(this.w_renamed.a_renamed(childAt))) {
                        this.w_renamed.getAdapter().a_renamed(childAt, 0, true);
                    }
                }
                this.x_renamed.a_renamed();
                break;
            case 2:
                this.mCameraInterface.ac_renamed();
                break;
            case 3:
                this.x_renamed.h_renamed(5);
                this.x_renamed.h_renamed(1);
                this.x_renamed.h_renamed(2);
                this.x_renamed.h_renamed(3);
                this.x_renamed.h_renamed(4);
                B_renamed();
                break;
            case 4:
                J_renamed();
                this.x_renamed.setPanelsBarAuto(4);
                break;
            case 5:
                if (!this.m_renamed && !this.mCameraInterface.A_renamed()) {
                    this.mCameraUIInterface.a_renamed(getShutterButtonInfo());
                    break;
                }
                break;
            case 6:
                if (E_renamed()) {
                    this.mCameraUIInterface.b_renamed(com.oplus.camera.R_renamed.string.camera_macro_best_focus_distance_text, com.oplus.camera.R_renamed.drawable.screen_hint_textview_bg, com.oplus.camera.R_renamed.color.screen_hint_text_color, java.lang.Integer.valueOf(com.oplus.camera.aps.config.CameraConfig.getConfigIntValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_MACRO_BEST_FOCUS_DISTANCE)));
                    break;
                }
                break;
            case 7:
                a_renamed(this.x_renamed.b_renamed(3), 3);
                break;
            case 8:
                B_renamed();
                break;
        }
    }

    private void c_renamed(boolean z_renamed) throws java.lang.NumberFormatException {
        if (this.mOneCamera == null) {
            return;
        }
        this.mOneCamera.a_renamed((android.hardware.camera2.CaptureRequest.Key<android.hardware.camera2.CaptureRequest.Key>) android.hardware.camera2.CaptureRequest.CONTROL_SCENE_MODE, (android.hardware.camera2.CaptureRequest.Key) 0);
        a_renamed(this.D_renamed.getString(com.oplus.camera.R_renamed.string.camera_iso_default_value), false);
        long j_renamed = java.lang.Long.parseLong(this.D_renamed.getString(com.oplus.camera.R_renamed.string.camera_exposure_time_default_value));
        this.mOneCamera.a_renamed(j_renamed);
        this.mOneCamera.a_renamed(j_renamed, false);
        L_renamed();
        if (!this.F_renamed || E_renamed()) {
            this.mOneCamera.a_renamed((android.hardware.camera2.CaptureRequest.Key<android.hardware.camera2.CaptureRequest.Key>) android.hardware.camera2.CaptureRequest.CONTROL_AE_EXPOSURE_COMPENSATION, (android.hardware.camera2.CaptureRequest.Key) java.lang.Integer.valueOf(com.oplus.camera.a_renamed.c_renamed()));
        } else {
            this.mOneCamera.a_renamed((android.hardware.camera2.CaptureRequest.Key<android.hardware.camera2.CaptureRequest.Key>) android.hardware.camera2.CaptureRequest.CONTROL_AE_EXPOSURE_COMPENSATION, (android.hardware.camera2.CaptureRequest.Key) java.lang.Integer.valueOf(c_renamed()));
        }
        this.mOneCamera.i_renamed(false);
        if (z_renamed) {
            this.mOneCamera.a_renamed((com.oplus.camera.e_renamed.d_renamed.c_renamed) null);
        }
        K_renamed();
        M_renamed();
        this.mActivity.runOnUiThread(new java.lang.Runnable() { // from class: com.oplus.camera.professional.v_renamed.21
            @Override // java.lang.Runnable
            public void run() {
                com.oplus.camera.professional.v_renamed.this.J_renamed();
                com.oplus.camera.professional.v_renamed.this.x_renamed.setPanelsBarAuto(4);
                com.oplus.camera.professional.v_renamed.this.x_renamed.b_renamed();
                com.oplus.camera.professional.v_renamed.this.p_renamed();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void p_renamed() {
        java.util.ArrayList<java.lang.String> arrayListD = this.x_renamed.d_renamed(3);
        int iIndexOf = this.x_renamed.c_renamed(3).indexOf(com.oplus.camera.professional.x_renamed.a_renamed(this.mActivity, 3));
        this.x_renamed.scrollTo(3, iIndexOf);
        this.x_renamed.b_renamed(3, iIndexOf);
        if (arrayListD != null && arrayListD.size() > iIndexOf) {
            a_renamed(3, arrayListD.get(iIndexOf));
        }
    }

    private void q_renamed() throws android.content.res.Resources.NotFoundException {
        android.widget.RelativeLayout.LayoutParams layoutParams;
        if (this.w_renamed == null) {
            this.w_renamed = new com.oplus.camera.professional.ListProfessionalModeBar(this.mActivity, b_renamed(), h_renamed());
            this.w_renamed.setPanelInterface(this.x_renamed);
            this.w_renamed.setCameraUIInterface(this.mCameraUIInterface);
            if (e_renamed()) {
                this.C_renamed.setVisibility(0);
            }
            this.w_renamed.setVisibility(0);
            com.oplus.camera.screen.b_renamed.a_renamed currentScreenMode = getCurrentScreenMode();
            if (currentScreenMode != null) {
                layoutParams = currentScreenMode.f_renamed();
            } else {
                layoutParams = new android.widget.RelativeLayout.LayoutParams(-1, this.L_renamed);
                layoutParams.addRule(12);
                layoutParams.addRule(14);
            }
            com.oplus.camera.professional.ListModeBarAdapter listModeBarAdapter = new com.oplus.camera.professional.ListModeBarAdapter(this.mActivity, this.x_renamed.a_renamed(true));
            listModeBarAdapter.a_renamed((com.oplus.camera.professional.q_renamed) this.x_renamed);
            a_renamed(this.w_renamed, com.oplus.camera.R_renamed.id_renamed.main_bar_id, listModeBarAdapter, this);
            this.C_renamed.addView(this.w_renamed, layoutParams);
        }
    }

    private void r_renamed() {
        android.widget.RelativeLayout.LayoutParams layoutParams;
        if (this.x_renamed == null) {
            this.x_renamed = new com.oplus.camera.professional.p_renamed(this.mActivity, this.mCameraInterface, f_renamed(), g_renamed());
            this.x_renamed.setGravity(17);
            this.x_renamed.setId(com.oplus.camera.R_renamed.id_renamed.professional_param_slide_bar_container);
            com.oplus.camera.screen.b_renamed.a_renamed currentScreenMode = getCurrentScreenMode();
            if (com.oplus.camera.util.Util.t_renamed()) {
                this.x_renamed.setCameraUIInterface(this.mCameraUIInterface);
            }
            if (currentScreenMode != null && com.oplus.camera.util.Util.u_renamed()) {
                layoutParams = currentScreenMode.g_renamed();
            } else {
                layoutParams = new android.widget.RelativeLayout.LayoutParams(com.oplus.camera.util.Util.getScreenWidth(), this.M_renamed + this.N_renamed);
                layoutParams.setMargins(0, 0, 0, this.L_renamed);
                layoutParams.addRule(14);
                layoutParams.addRule(12);
            }
            this.C_renamed.addView(this.x_renamed, layoutParams);
        }
    }

    private void s_renamed() throws android.content.res.Resources.NotFoundException, java.lang.NumberFormatException {
        int i_renamed;
        this.u_renamed = java.lang.Thread.currentThread();
        int properCameraId = getProperCameraId(this.mCameraId);
        com.oplus.camera.e_renamed.a_renamed("ProfessionalCapMode", "addViewToRoot, mUiThread: " + this.u_renamed);
        this.o_renamed = false;
        C_renamed();
        r_renamed();
        com.oplus.camera.professional.p_renamed pVar = this.x_renamed;
        if (pVar != null && (i_renamed = this.E_renamed) != properCameraId && i_renamed != -1) {
            pVar.d_renamed();
        }
        this.E_renamed = properCameraId;
        if (com.oplus.camera.util.Util.z_renamed(this.mActivity)) {
            this.x_renamed.a_renamed(getCameraInfo(this.E_renamed), this.B_renamed, (com.oplus.camera.professional.p_renamed.a_renamed) null);
            if (isSuperRawOpen()) {
                this.x_renamed.a_renamed(getCameraInfo(this.E_renamed), 2000000000L);
            }
            q_renamed();
            this.x_renamed.setSettleListener(this.w_renamed);
            this.x_renamed.setMotionListener(this.am_renamed);
            a_renamed(1);
            this.G_renamed = true;
        }
        u_renamed();
        x_renamed();
        this.ai_renamed = new android.widget.TextView(this.mActivity);
        this.ai_renamed.setWillNotDraw(true);
        this.ai_renamed.setVisibility(4);
        this.ai_renamed.setBackgroundResource(com.oplus.camera.R_renamed.drawable.screen_hint_textview_bg);
        this.ai_renamed.setLineSpacing(this.mActivity.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.camera_hint_extra_line_spacing), this.ai_renamed.getLineSpacingMultiplier());
        android.widget.RelativeLayout.LayoutParams layoutParams = new android.widget.RelativeLayout.LayoutParams(this.mActivity.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.camera_up_hint_text_secondary_max_width), -2);
        layoutParams.addRule(13);
        layoutParams.setMargins(this.mActivity.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.camera_hint_text_padding_left), this.mActivity.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.camera_hint_text_padding_top), this.mActivity.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.camera_hint_text_padding_right), this.mActivity.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.camera_hint_text_padding_bottom));
        this.mCameraUIInterface.b_renamed().addView(this.ai_renamed, layoutParams);
        this.ac_renamed = this.mActivity.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.camera_hint_text_padding_bottom);
        this.ad_renamed = this.mActivity.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.camera_hint_text_padding_bottom_size_type_1_1);
        this.ag_renamed = this.mPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_PHOTO_RATIO, this.mActivity.getString(com.oplus.camera.R_renamed.string.camera_photo_ratio_default_value));
        if ("square".equals(this.ag_renamed)) {
            this.ae_renamed = com.oplus.camera.util.Util.L_renamed() + com.oplus.camera.util.Util.N_renamed();
        } else {
            this.ae_renamed = com.oplus.camera.util.Util.N_renamed();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int t_renamed() {
        android.widget.RelativeLayout relativeLayoutP;
        int iN = com.oplus.camera.util.Util.N_renamed();
        return (this.mCameraUIInterface == null || (relativeLayoutP = this.mCameraUIInterface.p_renamed()) == null || relativeLayoutP.getTop() <= iN) ? iN : relativeLayoutP.getTop();
    }

    private void u_renamed() {
        if (this.I_renamed == null) {
            this.I_renamed = new com.oplus.camera.ui.RotateImageView(this.mActivity);
            this.I_renamed.setId(com.oplus.camera.R_renamed.id_renamed.professional_parameter_bottom_guide_entry);
            this.I_renamed.setImageResource(com.oplus.camera.R_renamed.drawable.professional_mode_guide_icon);
            this.J_renamed = this.I_renamed.getDrawable().getIntrinsicWidth();
            int dimensionPixelSize = (this.D_renamed.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.common_bottom_guide_professional_entry_touch_width) - this.J_renamed) / 2;
            this.I_renamed.setLayoutParams(v_renamed());
            this.I_renamed.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
            this.I_renamed.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.oplus.camera.professional.-$$Lambda$p8aM6hM1kA9Bw2NbF4BY_ZtrwFc
                @Override // android.view.View.OnClickListener
                public final void onClick(android.view.View view) {
                    this.f_renamed$0.onClick(view);
                }
            });
        }
        this.I_renamed.a_renamed(this.mCameraInterface.u_renamed(), false);
        this.mCameraUIInterface.a_renamed((android.view.View) this.I_renamed, com.oplus.camera.aps.constant.ApsConstant.CAPTURE_MODE_PROFESSIONAL, 2, false);
        d_renamed(false);
    }

    private android.view.ViewGroup.LayoutParams v_renamed() throws android.content.res.Resources.NotFoundException {
        int dimensionPixelSize = (this.D_renamed.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.common_bottom_guide_professional_entry_touch_width) - this.J_renamed) / 2;
        int iT = t_renamed();
        com.oplus.camera.e_renamed.a_renamed("ProfessionalCapMode", "getGuideEntryLayoutParams, previewMarginTop: " + iT);
        android.widget.RelativeLayout.LayoutParams layoutParams = new android.widget.RelativeLayout.LayoutParams(-2, -2);
        if (1 == f_renamed()) {
            layoutParams.addRule(10);
            int i_renamed = com.oplus.camera.util.Util.i_renamed(com.oplus.camera.R_renamed.dimen.fold_full_professional_guide_entry_margin_top);
            int i2 = com.oplus.camera.util.Util.i_renamed(com.oplus.camera.R_renamed.dimen.fold_full_professional_guide_entry_margin_right);
            layoutParams.topMargin = i_renamed;
            if (270 == g_renamed()) {
                layoutParams.addRule(20);
                layoutParams.leftMargin = i2;
            } else {
                layoutParams.addRule(21);
                layoutParams.rightMargin = i2;
            }
        } else if (3 == f_renamed()) {
            layoutParams.addRule(10);
            layoutParams.addRule(21);
            int dimensionPixelOffset = this.D_renamed.getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.fold_split_professional_guide_entry_margin_top);
            int dimensionPixelOffset2 = this.D_renamed.getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.fold_split_professional_guide_entry_margin_right);
            layoutParams.topMargin = dimensionPixelOffset;
            layoutParams.rightMargin = dimensionPixelOffset2;
        } else if (4 == f_renamed()) {
            layoutParams.addRule(12);
            layoutParams.addRule(20);
            layoutParams.bottomMargin = com.oplus.camera.util.Util.i_renamed(com.oplus.camera.R_renamed.dimen.fold_rack_professional_guide_entry_margin_bottom);
            layoutParams.leftMargin = com.oplus.camera.util.Util.i_renamed(com.oplus.camera.R_renamed.dimen.fold_rack_professional_guide_entry_margin_left);
        } else {
            layoutParams.addRule(10);
            layoutParams.addRule(21);
            int dimensionPixelSize2 = iT + this.D_renamed.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.common_bottom_guide_professional_entry_margin_top);
            int dimensionPixelSize3 = this.D_renamed.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.common_bottom_guide_professional_entry_margin_end);
            layoutParams.topMargin = dimensionPixelSize2 - dimensionPixelSize;
            if (1 == androidx.core.f_renamed.f_renamed.a_renamed(java.util.Locale.getDefault())) {
                layoutParams.leftMargin = dimensionPixelSize3 - dimensionPixelSize;
            } else {
                layoutParams.rightMargin = dimensionPixelSize3 - dimensionPixelSize;
            }
        }
        return layoutParams;
    }

    private void w_renamed() {
        if (this.I_renamed != null) {
            if (com.oplus.camera.util.Util.t_renamed()) {
                com.oplus.camera.screen.d_renamed.a_renamed(this.I_renamed);
                this.I_renamed.setLayoutParams(v_renamed());
                if (1 == f_renamed()) {
                    if (g_renamed() == 0) {
                        this.I_renamed.setRotation(0.0f);
                        return;
                    } else {
                        this.I_renamed.setRotation(360 - g_renamed());
                        return;
                    }
                }
                if (4 == f_renamed()) {
                    this.I_renamed.setRotation(360 - g_renamed());
                    return;
                } else {
                    this.I_renamed.setRotation(0.0f);
                    return;
                }
            }
            int iT = t_renamed();
            com.oplus.camera.e_renamed.a_renamed("ProfessionalCapMode", "updateBottomGuideEntryPosition, previewMarginTop: " + iT);
            int dimensionPixelSize = iT + this.D_renamed.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.common_bottom_guide_professional_entry_margin_top);
            int dimensionPixelSize2 = (this.D_renamed.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.common_bottom_guide_professional_entry_touch_width) - this.J_renamed) / 2;
            final android.widget.RelativeLayout.LayoutParams layoutParams = (android.widget.RelativeLayout.LayoutParams) this.I_renamed.getLayoutParams();
            int i_renamed = dimensionPixelSize - dimensionPixelSize2;
            int i2 = layoutParams.topMargin;
            if (i_renamed != i2) {
                android.animation.ValueAnimator valueAnimator = this.K_renamed;
                if (valueAnimator == null) {
                    this.K_renamed = android.animation.ValueAnimator.ofInt(i2, i_renamed);
                    this.K_renamed.setDuration(300L);
                    this.K_renamed.setInterpolator(com.oplus.camera.professional.t_renamed.f5228b);
                    this.K_renamed.addUpdateListener(new android.animation.ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.professional.v_renamed.22
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(android.animation.ValueAnimator valueAnimator2) {
                            layoutParams.topMargin = ((java.lang.Integer) valueAnimator2.getAnimatedValue()).intValue();
                            com.oplus.camera.professional.v_renamed.this.I_renamed.setLayoutParams(layoutParams);
                        }
                    });
                } else {
                    valueAnimator.setIntValues(i2, i_renamed);
                }
                if (this.K_renamed.isRunning()) {
                    return;
                }
                this.K_renamed.start();
                return;
            }
            layoutParams.topMargin = i_renamed;
            this.I_renamed.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d_renamed(boolean z_renamed) {
        if (this.mbModePreInit) {
            boolean z2 = ("on_renamed".equals(this.mPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_SUB_SETTING, "off")) || this.P_renamed || !this.Q_renamed) ? false : true;
            com.oplus.camera.ui.RotateImageView rotateImageView = this.I_renamed;
            if (rotateImageView != null) {
                if (!z_renamed) {
                    rotateImageView.clearAnimation();
                    this.I_renamed.setVisibility(z2 ? 0 : 4);
                    this.I_renamed.setAlpha(1.0f);
                } else if (z2) {
                    com.oplus.camera.util.Util.a_renamed(rotateImageView, 0, (android.view.animation.Animation.AnimationListener) null, 250L, 250L, com.oplus.camera.professional.t_renamed.f5227a);
                } else {
                    com.oplus.camera.util.Util.a_renamed(rotateImageView, 4, (android.view.animation.Animation.AnimationListener) null, 250L, 0L, com.oplus.camera.professional.t_renamed.f5227a);
                }
            }
        }
    }

    private void x_renamed() {
        if (this.y_renamed == null) {
            this.y_renamed = new com.oplus.camera.ui.RotateImageView(this.mActivity.getApplicationContext());
            this.y_renamed.setEnabled(true);
            this.y_renamed.setFocusable(false);
            this.y_renamed.setClickable(true);
            this.y_renamed.setVisibility(4);
            this.y_renamed.setContentDescription(this.mActivity.getResources().getString(com.oplus.camera.R_renamed.string.camera_setting_menu_parameter_default));
            this.y_renamed.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.oplus.camera.professional.v_renamed.23
                @Override // android.view.View.OnClickListener
                public void onClick(android.view.View view) {
                    com.oplus.camera.professional.v_renamed.this.a_renamed(true, com.oplus.camera.professional.v_renamed.this.mPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_PARAMETER_SAVING, "off"));
                    com.oplus.camera.professional.v_renamed.this.A_renamed();
                    com.oplus.camera.professional.v_renamed.this.Y_renamed();
                }
            });
            final com.a_renamed.a_renamed.f_renamed fVarA = com.oplus.camera.professional.u_renamed.a_renamed();
            this.y_renamed.setOnTouchListener(new android.view.View.OnTouchListener() { // from class: com.oplus.camera.professional.v_renamed.2
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(android.view.View view, android.view.MotionEvent motionEvent) {
                    int action = motionEvent.getAction();
                    if (action == 0) {
                        com.oplus.camera.professional.u_renamed.a_renamed((android.view.View) com.oplus.camera.professional.v_renamed.this.y_renamed, fVarA, true);
                    } else if (action == 1 || action == 3) {
                        com.oplus.camera.professional.u_renamed.a_renamed((android.view.View) com.oplus.camera.professional.v_renamed.this.y_renamed, fVarA, false);
                    }
                    return false;
                }
            });
            android.widget.RelativeLayout.LayoutParams layoutParams = new android.widget.RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(21);
            layoutParams.addRule(11);
            layoutParams.topMargin = this.D_renamed.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.control_button_margin_top);
            layoutParams.setMarginEnd(this.D_renamed.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.control_button_margin_edge));
            this.y_renamed.setLayoutParams(layoutParams);
            this.y_renamed.setImageResource(com.oplus.camera.R_renamed.drawable.ic_parameter_saving_store);
            this.y_renamed.setBackgroundResource(com.oplus.camera.R_renamed.drawable.switch_camera_button_bg);
            ((android.widget.RelativeLayout) this.mActivity.findViewById(com.oplus.camera.R_renamed.id_renamed.control_panel_button_layout)).addView(this.y_renamed);
        }
        this.y_renamed.a_renamed(this.mCameraInterface.u_renamed(), false);
        z_renamed();
        A_renamed();
    }

    private boolean y_renamed() {
        return (!getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_PARAMETER_SAVING) || this.mPreferences == null || this.mPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_PARAMETER_SAVING, "off").equals("off")) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z_renamed() {
        this.q_renamed = y_renamed();
        com.oplus.camera.ui.RotateImageView rotateImageView = this.y_renamed;
        if (rotateImageView != null) {
            rotateImageView.setVisibility(this.q_renamed ? 0 : 4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A_renamed() {
        if (y_renamed()) {
            boolean z_renamed = !this.x_renamed.a_renamed(this.mPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_SWITCH_CAMERA, "camera_main"), this.mPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_PARAMETER_SAVING, "off"));
            com.oplus.camera.ui.RotateImageView rotateImageView = this.y_renamed;
            if (rotateImageView != null) {
                rotateImageView.setEnabled(z_renamed);
                if (z_renamed) {
                    this.y_renamed.setColorFilter(com.oplus.camera.util.Util.A_renamed(this.mActivity));
                } else {
                    this.y_renamed.setColorFilter(androidx.core.a_renamed.a_renamed.c_renamed(this.mActivity, com.oplus.camera.R_renamed.color.camera_white));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a_renamed(boolean z_renamed, java.lang.String str) {
        java.lang.String string = this.mPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_SWITCH_CAMERA, "camera_main");
        if (z_renamed) {
            this.x_renamed.b_renamed(string, str);
        } else {
            this.x_renamed.c_renamed(string, str);
        }
    }

    private void B_renamed() {
        a_renamed(this.x_renamed.b_renamed(0), 0);
        A_renamed();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public int getZoomBarOffset() {
        if (this.mCameraUIInterface != null && (1 == this.mCameraUIInterface.aX_renamed() || 4 == this.mCameraUIInterface.aX_renamed())) {
            return super.getZoomBarOffset();
        }
        return this.L_renamed;
    }

    private void C_renamed() {
        android.widget.RelativeLayout.LayoutParams layoutParams;
        if (this.C_renamed == null) {
            this.C_renamed = new com.oplus.camera.professional.v_renamed.a_renamed(this.mActivity);
            this.C_renamed.setId(com.oplus.camera.R_renamed.id_renamed.professional_params_bar_container);
            com.oplus.camera.screen.b_renamed.a_renamed currentScreenMode = getCurrentScreenMode();
            if (currentScreenMode != null) {
                layoutParams = currentScreenMode.e_renamed();
            } else {
                layoutParams = new android.widget.RelativeLayout.LayoutParams(-2, com.oplus.camera.util.Util.getScreenWidth());
                layoutParams.addRule(12);
                layoutParams.addRule(14);
                if (this.mCameraInterface != null) {
                    layoutParams.bottomMargin = this.mCameraUIInterface.r_renamed();
                } else {
                    layoutParams.bottomMargin = 0;
                }
            }
            this.C_renamed.setLayoutParams(layoutParams);
            this.C_renamed.setVisibility(8);
            this.C_renamed.getViewTreeObserver().addOnWindowFocusChangeListener(new android.view.ViewTreeObserver.OnWindowFocusChangeListener() { // from class: com.oplus.camera.professional.v_renamed.3
                @Override // android.view.ViewTreeObserver.OnWindowFocusChangeListener
                public void onWindowFocusChanged(boolean z_renamed) {
                    if (com.oplus.camera.professional.v_renamed.this.w_renamed != null) {
                        com.oplus.camera.e_renamed.a_renamed("ProfessionalCapMode", "onWindowFocusChanged, SelectedPosition: " + com.oplus.camera.professional.v_renamed.this.w_renamed.getSelectedPosition() + ", hasFocus: " + z_renamed);
                        com.oplus.camera.professional.v_renamed.this.w_renamed.a_renamed(com.oplus.camera.professional.v_renamed.this.w_renamed.getSelectedPosition(), true);
                    }
                }
            });
        }
        this.mCameraUIInterface.a_renamed((android.view.View) this.C_renamed, com.oplus.camera.aps.constant.ApsConstant.CAPTURE_MODE_PROFESSIONAL, 1, false);
        com.oplus.camera.professional.v_renamed.a_renamed aVar = this.C_renamed;
        if (aVar != null) {
            aVar.setTouchState(true);
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void checkoutTimerSnapShotState() {
        super.checkoutTimerSnapShotState();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onTimeSnapShotEnd(boolean z_renamed) {
        com.oplus.camera.ui.control.b_renamed shutterButtonInfo = getShutterButtonInfo();
        if (this.j_renamed && z_renamed) {
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
        com.oplus.camera.e_renamed.c_renamed("ProfessionalCapMode", "onBackPressed, mbInCapturing: " + this.mbInCapturing);
        if (this.w_renamed.isSelected()) {
            this.mCameraInterface.a_renamed(true, true);
            this.mCameraInterface.d_renamed(true);
            if (4 == f_renamed()) {
                this.mCameraUIInterface.g_renamed(0);
            }
            com.oplus.camera.professional.u_renamed.a_renamed aVar = new com.oplus.camera.professional.u_renamed.a_renamed();
            aVar.f5239a = false;
            aVar.f5241c = 250;
            aVar.g_renamed = 400;
            aVar.d_renamed = 0.0f;
            aVar.e_renamed = this.mActivity.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.main_mode_bar_item_animation_offset);
            this.x_renamed.setAllPopupInvisibility(aVar);
            this.w_renamed.a_renamed();
            this.mOneCamera.j_renamed(true);
            return true;
        }
        return super.onBackPressed();
    }

    @Override // com.oplus.camera.capmode.BaseMode, com.oplus.camera.e_renamed.d_renamed.a_renamed
    public void onCaptureSequenceCompleted() {
        super.onCaptureSequenceCompleted();
        com.oplus.camera.e_renamed.c_renamed("ProfessionalCapMode", "onCaptureSequenceCompleted");
        if (isSuperRawOpen()) {
            this.mCameraUIInterface.a_renamed(com.oplus.camera.R_renamed.string.camera_scene_night_keep_phone_steady);
            if (this.h_renamed || this.mActivity == null) {
                return;
            }
            this.mActivity.runOnUiThread(new java.lang.Runnable() { // from class: com.oplus.camera.professional.v_renamed.4
                @Override // java.lang.Runnable
                public void run() {
                    com.oplus.camera.professional.v_renamed.this.mCameraUIInterface.a_renamed(new com.oplus.camera.ui.control.b_renamed());
                    com.oplus.camera.professional.v_renamed.this.mCameraUIInterface.a_renamed(false, true);
                    if (com.oplus.camera.professional.v_renamed.this.mbPaused || com.oplus.camera.professional.v_renamed.this.v_renamed == null) {
                        return;
                    }
                    com.oplus.camera.professional.v_renamed.this.v_renamed.f_renamed();
                }
            });
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected boolean onStopTakePicture() {
        if (2 != this.mCameraInterface.g_renamed()) {
            com.oplus.camera.e_renamed.f_renamed("ProfessionalCapMode", "onStopTakePicture failed, current camera state is_renamed " + this.mCameraInterface.g_renamed());
            return false;
        }
        this.mActivity.runOnUiThread(new java.lang.Runnable() { // from class: com.oplus.camera.professional.v_renamed.5
            /* JADX WARN: Removed duplicated region for block: B_renamed:6:0x001a  */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public void run() throws android.content.res.Resources.NotFoundException {
                /*
                    r6 = this;
                    com.oplus.camera.professional.v_renamed r0 = com.oplus.camera.professional.v_renamed.this
                    java.lang.String r1 = com.oplus.camera.professional.v_renamed.K_renamed(r0)
                    boolean r0 = com.oplus.camera.professional.v_renamed.a_renamed(r0, r1)
                    r1 = 1
                    r2 = 0
                    if (r0 != 0) goto L1a
                    com.oplus.camera.professional.v_renamed r0 = com.oplus.camera.professional.v_renamed.this
                    java.lang.String r3 = com.oplus.camera.professional.v_renamed.K_renamed(r0)
                    boolean r0 = com.oplus.camera.professional.v_renamed.b_renamed(r0, r3)
                    if (r0 == 0) goto L53
                L1a:
                    com.oplus.camera.professional.v_renamed r0 = com.oplus.camera.professional.v_renamed.this
                    com.oplus.camera.e_renamed.d_renamed r0 = com.oplus.camera.professional.v_renamed.L_renamed(r0)
                    r0.h_renamed()
                    com.oplus.camera.professional.v_renamed r0 = com.oplus.camera.professional.v_renamed.this
                    com.oplus.camera.capmode.a_renamed r0 = com.oplus.camera.professional.v_renamed.M_renamed(r0)
                    r0.W_renamed()
                    com.oplus.camera.professional.v_renamed r0 = com.oplus.camera.professional.v_renamed.this
                    com.oplus.camera.professional.v_renamed.a_renamed(r0, r2, r1)
                    com.oplus.camera.professional.v_renamed r0 = com.oplus.camera.professional.v_renamed.this
                    com.oplus.camera.professional.v_renamed.N_renamed(r0)
                    com.oplus.camera.professional.v_renamed r0 = com.oplus.camera.professional.v_renamed.this
                    boolean r0 = r0.isSuperRawOpen()
                    if (r0 == 0) goto L53
                    com.oplus.camera.professional.v_renamed r0 = com.oplus.camera.professional.v_renamed.this
                    com.oplus.camera.ui.CameraUIInterface r0 = com.oplus.camera.professional.v_renamed.O_renamed(r0)
                    r3 = 2131755796(0x7f100314, float:1.9142481E38)
                    r0.a_renamed(r3)
                    com.oplus.camera.professional.v_renamed r0 = com.oplus.camera.professional.v_renamed.this
                    com.oplus.camera.ui.h_renamed r0 = com.oplus.camera.professional.v_renamed.d_renamed(r0)
                    r0.a_renamed()
                L53:
                    com.oplus.camera.professional.v_renamed r0 = com.oplus.camera.professional.v_renamed.this
                    com.oplus.camera.professional.v_renamed$a_renamed r0 = com.oplus.camera.professional.v_renamed.P_renamed(r0)
                    r3 = 0
                    r4 = 300(0x12c, double:1.48E-321)
                    com.oplus.camera.util.Util.a_renamed(r0, r2, r3, r4)
                    com.oplus.camera.professional.v_renamed r0 = com.oplus.camera.professional.v_renamed.this
                    com.oplus.camera.professional.v_renamed.d_renamed(r0, r2)
                    com.oplus.camera.professional.v_renamed r6 = com.oplus.camera.professional.v_renamed.this
                    com.oplus.camera.ui.CameraUIInterface r6 = com.oplus.camera.professional.v_renamed.Q_renamed(r6)
                    r6.c_renamed(r1, r2)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.professional.v_renamed.ParameterContainer_7.run():void");
            }
        });
        this.mbInCapturing = false;
        setCapturePreviewDataState(2);
        this.C_renamed.setTouchState(true);
        this.mCameraInterface.f_renamed(true);
        this.mCameraUIInterface.a_renamed(true, false);
        return true;
    }

    private void D_renamed() {
        this.mCameraUIInterface.g_renamed(true);
        com.oplus.camera.ui.RotateImageView rotateImageView = this.y_renamed;
        if (rotateImageView != null) {
            rotateImageView.setVisibility(4);
        }
        com.oplus.camera.professional.v_renamed.a_renamed aVar = this.C_renamed;
        if (aVar != null) {
            aVar.setTouchState(false);
            com.oplus.camera.professional.ListProfessionalModeBar listProfessionalModeBar = this.w_renamed;
            if (listProfessionalModeBar != null) {
                listProfessionalModeBar.removeAllViews();
                this.C_renamed.removeView(this.w_renamed);
                this.w_renamed = null;
            }
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void onDeInitCameraMode(java.lang.String str) throws android.content.res.Resources.NotFoundException {
        com.oplus.camera.e_renamed.c_renamed("ProfessionalCapMode", "onDeInitCameraMode");
        android.os.Handler handler = this.B_renamed;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        com.oplus.camera.professional.p_renamed pVar = this.x_renamed;
        if (pVar != null) {
            pVar.h_renamed();
        }
        if (E_renamed()) {
            this.mCameraUIInterface.w_renamed(true);
        }
        com.oplus.camera.professional.v_renamed.a_renamed aVar = this.C_renamed;
        if (aVar != null && aVar.getVisibility() != 0) {
            N_renamed();
            D_renamed();
        }
        b_renamed("0", false);
        android.animation.ValueAnimator valueAnimator = this.aj_renamed;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.aj_renamed.cancel();
        }
        com.oplus.camera.p_renamed pVar2 = this.z_renamed;
        if (pVar2 != null) {
            pVar2.c_renamed();
            this.z_renamed = null;
        }
        if (Z_renamed() && this.ab_renamed != 0) {
            this.ab_renamed = 0;
            e_renamed(0);
        }
        this.mCameraUIInterface.w_renamed(0);
        this.mCameraUIInterface.b_renamed().removeView(this.ai_renamed);
        com.oplus.camera.ui.a_renamed.a_renamed aVarK = this.mCameraUIInterface.k_renamed();
        if (aVarK != null) {
            aVarK.a_renamed((com.oplus.camera.ui.a_renamed.a_renamed.b_renamed) null);
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void operateSpecificViewCallBack(java.lang.Object obj, boolean z_renamed, boolean z2) {
        boolean z3 = obj instanceof java.lang.Integer;
        if (z3 && 1 == ((java.lang.Integer) obj).intValue() && !z_renamed) {
            if (z2) {
                com.oplus.camera.e_renamed.b_renamed("ProfessionalCapMode", "removeAllView when mEmptyViewToAnimate hide animation end");
                N_renamed();
                D_renamed();
            } else if (this.w_renamed != null) {
                com.oplus.camera.professional.u_renamed.a_renamed aVar = new com.oplus.camera.professional.u_renamed.a_renamed();
                aVar.f5239a = false;
                aVar.f5241c = 250;
                aVar.d_renamed = 0.0f;
                aVar.e_renamed = getZoomBarOffset();
                aVar.g_renamed = 500;
                com.oplus.camera.professional.u_renamed.a_renamed(this.w_renamed, aVar);
            }
        }
        if (z3 && 1 == ((java.lang.Integer) obj).intValue() && z_renamed && z2) {
            this.B_renamed.post(new java.lang.Runnable() { // from class: com.oplus.camera.professional.v_renamed.6
                @Override // java.lang.Runnable
                public void run() {
                    if (com.oplus.camera.professional.v_renamed.this.w_renamed != null) {
                        com.oplus.camera.professional.v_renamed.this.w_renamed.b_renamed();
                    }
                }
            });
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
        return b_renamed(m_renamed()) && getIsCapturingState();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected boolean onBeforeSnapping(com.oplus.camera.e_renamed.c_renamed cVar) {
        com.oplus.camera.professional.p_renamed pVar = this.x_renamed;
        if (pVar != null && pVar.g_renamed()) {
            com.oplus.camera.e_renamed.c_renamed("ProfessionalCapMode", "onBeforeSnapping, levelPanelScrolling");
            return false;
        }
        this.mActivity.runOnUiThread(new java.lang.Runnable() { // from class: com.oplus.camera.professional.v_renamed.7
            @Override // java.lang.Runnable
            public void run() throws android.content.res.Resources.NotFoundException {
                if (com.oplus.camera.professional.v_renamed.this.mbPaused) {
                    com.oplus.camera.e_renamed.a_renamed("ProfessionalCapMode", "onBeforeSnapping, return after pause");
                    return;
                }
                if (com.oplus.camera.professional.v_renamed.this.isSuperRawOpen()) {
                    com.oplus.camera.professional.v_renamed vVar = com.oplus.camera.professional.v_renamed.this;
                    if (vVar.d_renamed(vVar.m_renamed()) && com.oplus.camera.professional.v_renamed.this.mCameraUIInterface != null) {
                        com.oplus.camera.professional.v_renamed.this.mCameraUIInterface.a_renamed(com.oplus.camera.R_renamed.string.camera_scene_night_keep_phone_steady, -1, false, false, true);
                    }
                    com.oplus.camera.professional.v_renamed vVar2 = com.oplus.camera.professional.v_renamed.this;
                    if (vVar2.c_renamed(vVar2.m_renamed())) {
                        int iLongValue = ((int) (java.lang.Long.valueOf(com.oplus.camera.professional.v_renamed.this.m_renamed()).longValue() / 1000000)) * 3;
                        com.oplus.camera.professional.v_renamed.this.v_renamed.a_renamed(iLongValue);
                        if (com.oplus.camera.professional.v_renamed.this.mCameraUIInterface != null) {
                            com.oplus.camera.professional.v_renamed.this.mCameraUIInterface.h_renamed(iLongValue);
                        }
                    }
                    if (com.oplus.camera.professional.v_renamed.this.mCameraUIInterface != null) {
                        com.oplus.camera.professional.v_renamed.this.mCameraUIInterface.g_renamed(4);
                        com.oplus.camera.professional.v_renamed.this.mCameraUIInterface.f_renamed(4);
                        com.oplus.camera.professional.v_renamed.this.b_renamed(4, true);
                        com.oplus.camera.professional.v_renamed.this.mCameraUIInterface.a_renamed(com.oplus.camera.R_renamed.string.camera_scene_tips_professional_raw_super_format);
                        com.oplus.camera.professional.v_renamed.this.mCameraInterface.a_renamed((android.animation.AnimatorListenerAdapter) null, true, false);
                    }
                    com.oplus.camera.professional.v_renamed.this.Q_renamed = false;
                    com.oplus.camera.professional.v_renamed.this.d_renamed(false);
                    com.oplus.camera.professional.v_renamed.this.b_renamed(false, false);
                    com.oplus.camera.util.Util.a_renamed(com.oplus.camera.professional.v_renamed.this.C_renamed, 4, (android.view.animation.Animation.AnimationListener) null, 300L);
                    com.oplus.camera.util.Util.a_renamed(com.oplus.camera.professional.v_renamed.this.y_renamed, 4, (android.view.animation.Animation.AnimationListener) null, 300L);
                } else {
                    com.oplus.camera.professional.v_renamed vVar3 = com.oplus.camera.professional.v_renamed.this;
                    if (vVar3.b_renamed(vVar3.m_renamed())) {
                        if (com.oplus.camera.professional.v_renamed.this.mCameraUIInterface != null) {
                            com.oplus.camera.professional.v_renamed.this.mCameraUIInterface.g_renamed(4);
                            com.oplus.camera.professional.v_renamed.this.mCameraUIInterface.f_renamed(4);
                            com.oplus.camera.professional.v_renamed.this.mCameraUIInterface.P_renamed(false);
                            com.oplus.camera.professional.v_renamed.this.b_renamed(4, true);
                            com.oplus.camera.professional.v_renamed.this.mCameraInterface.a_renamed((android.animation.AnimatorListenerAdapter) null, true, false);
                        }
                        com.oplus.camera.professional.v_renamed.this.Q_renamed = false;
                        com.oplus.camera.professional.v_renamed.this.d_renamed(false);
                        com.oplus.camera.professional.v_renamed.this.a_renamed(false, false, true);
                        com.oplus.camera.util.Util.a_renamed(com.oplus.camera.professional.v_renamed.this.C_renamed, 4, (android.view.animation.Animation.AnimationListener) null, 300L);
                        com.oplus.camera.util.Util.a_renamed(com.oplus.camera.professional.v_renamed.this.y_renamed, 4, (android.view.animation.Animation.AnimationListener) null, 300L);
                        if (com.oplus.camera.professional.v_renamed.this.mCameraUIInterface != null) {
                            com.oplus.camera.professional.v_renamed.this.mCameraUIInterface.h_renamed((int) (java.lang.Long.valueOf(com.oplus.camera.professional.v_renamed.this.m_renamed()).longValue() / 1000000));
                        }
                    }
                }
                com.oplus.camera.professional.v_renamed.this.C_renamed.setTouchState(false);
                if (!com.oplus.camera.professional.v_renamed.this.j_renamed || com.oplus.camera.professional.v_renamed.this.mCameraUIInterface == null || com.oplus.camera.professional.v_renamed.this.mCameraUIInterface.s_renamed() == 2) {
                    return;
                }
                com.oplus.camera.professional.v_renamed.this.mCameraUIInterface.a_renamed(new com.oplus.camera.ui.control.b_renamed(4, "button_color_inside_none"));
            }
        });
        setRawRequestTag(false);
        this.R_renamed = null;
        if (isRawOpen()) {
            setRawRequestTag(true);
            this.n_renamed = false;
        }
        if (isSuperRawOpen()) {
            setRawRequestTag(false);
            this.n_renamed = false;
            synchronized (this.g_renamed) {
                this.T_renamed = false;
            }
        }
        I_renamed();
        if (this.mOneCamera != null) {
            this.mOneCamera.j_renamed(true);
        }
        setCaptureRequestPictureSizeScale();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b_renamed(int i_renamed) throws android.content.res.Resources.NotFoundException {
        com.oplus.camera.e_renamed.a_renamed("ProfessionalCapMode", "setCameraMenuControlViewVisibility, visibility: " + i_renamed);
        if (this.mCameraUIInterface != null) {
            this.mCameraUIInterface.g_renamed(i_renamed);
            this.mCameraUIInterface.f_renamed(i_renamed);
            this.mCameraUIInterface.c_renamed(i_renamed);
            this.mCameraUIInterface.b_renamed(i_renamed, true);
            this.mCameraUIInterface.P_renamed(true);
        }
        this.Q_renamed = i_renamed == 0;
        d_renamed(false);
        a_renamed(false, false, true);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean onAfterSnapping() {
        com.oplus.camera.e_renamed.a_renamed("ProfessionalCapMode", "onAfterSnapping");
        if (!this.j_renamed && this.mCameraInterface.i_renamed() && java.lang.Long.parseLong(m_renamed()) >= com.google.android.exoplayer2.C_renamed.NANOS_PER_SECOND) {
            this.mCameraInterface.c_renamed(com.oplus.camera.util.Util.ao_renamed() ? 6 : 4);
        } else {
            com.oplus.camera.e_renamed.a_renamed("ProfessionalCapMode", "onAfterSnapping is_renamed ZSL mode, do nothing");
        }
        if (isRawOpen()) {
            this.i_renamed = false;
        }
        if (isSuperRawOpen()) {
            this.h_renamed = false;
        }
        this.mActivity.runOnUiThread(new java.lang.Runnable() { // from class: com.oplus.camera.professional.v_renamed.8
            @Override // java.lang.Runnable
            public void run() {
                if (com.oplus.camera.professional.v_renamed.this.mbPaused) {
                    return;
                }
                if (com.oplus.camera.professional.v_renamed.this.isSuperRawOpen()) {
                    com.oplus.camera.ui.control.b_renamed shutterButtonInfo = com.oplus.camera.professional.v_renamed.this.getShutterButtonInfo();
                    com.oplus.camera.professional.v_renamed vVar = com.oplus.camera.professional.v_renamed.this;
                    if (vVar.c_renamed(vVar.m_renamed())) {
                        com.oplus.camera.professional.v_renamed.this.mCameraUIInterface.a_renamed(true, false);
                        com.oplus.camera.professional.v_renamed.this.mCameraUIInterface.i_renamed(com.oplus.camera.professional.v_renamed.this.D_renamed.getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.night_countdown_time_margin_top));
                        com.oplus.camera.professional.v_renamed.this.v_renamed.d_renamed();
                        com.oplus.camera.professional.v_renamed.this.v_renamed.e_renamed();
                        if (com.oplus.camera.professional.v_renamed.this.mCameraUIInterface.s_renamed() == 9) {
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
                    com.oplus.camera.professional.v_renamed.this.mCameraUIInterface.a_renamed(shutterButtonInfo);
                    return;
                }
                com.oplus.camera.professional.v_renamed vVar2 = com.oplus.camera.professional.v_renamed.this;
                if (vVar2.b_renamed(vVar2.m_renamed())) {
                    com.oplus.camera.professional.v_renamed.this.mCameraUIInterface.a_renamed(true, false);
                    com.oplus.camera.ui.control.b_renamed shutterButtonInfo2 = com.oplus.camera.professional.v_renamed.this.getShutterButtonInfo();
                    if (com.oplus.camera.professional.v_renamed.this.mCameraUIInterface.s_renamed() == 9) {
                        shutterButtonInfo2.a_renamed(3);
                        shutterButtonInfo2.a_renamed("button_color_inside_none");
                    } else {
                        shutterButtonInfo2.a_renamed(com.oplus.camera.util.Util.ao_renamed() ? 27 : 7);
                        shutterButtonInfo2.a_renamed("button_color_inside_none");
                    }
                    com.oplus.camera.professional.v_renamed.this.mCameraUIInterface.a_renamed(shutterButtonInfo2);
                }
            }
        });
        com.oplus.camera.e_renamed.a_renamed("ProfessionalCapMode", "onAfterSnapping X_renamed");
        return true;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void onShutterCallback(boolean z_renamed, boolean z2) throws android.content.res.Resources.NotFoundException {
        super.onShutterCallback(z_renamed, z2);
        if (z2) {
            if (!this.j_renamed && this.mCameraInterface.i_renamed() && java.lang.Long.parseLong(m_renamed()) >= com.google.android.exoplayer2.C_renamed.NANOS_PER_SECOND) {
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
        com.oplus.camera.e_renamed.a_renamed("ProfessionalCapMode", "onCaptureCompleted, systemTime: " + java.lang.System.currentTimeMillis());
    }

    @Override // com.oplus.camera.capmode.BaseMode, com.oplus.camera.e_renamed.d_renamed.a_renamed
    public void onCaptureFailed(android.hardware.camera2.CaptureRequest captureRequest, com.oplus.camera.e_renamed.c_renamed cVar) {
        super.onCaptureFailed(captureRequest, cVar);
        if (isRawOpen()) {
            this.i_renamed = true;
        }
        if (isSuperRawOpen()) {
            this.h_renamed = true;
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void onBeforePictureTaken(byte[] bArr, boolean z_renamed) {
        com.oplus.camera.e_renamed.c_renamed("ProfessionalCapMode", "onBeforePictureTaken");
        if (this.j_renamed) {
            this.mCameraUIInterface.a_renamed(getShutterButtonInfo(), false);
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected boolean getNeedStoreRawPic() {
        return isSuperRawOpen();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void onAfterPictureTaken(byte[] bArr, boolean z_renamed) throws android.content.res.Resources.NotFoundException {
        com.oplus.camera.e_renamed.a_renamed("ProfessionalCapMode", "onAfterPictureTaken");
        if (!this.n_renamed && isRawRequestTag()) {
            this.n_renamed = true;
            if (!this.i_renamed && !this.h_renamed) {
                return;
            }
        }
        if (isSuperRawOpen()) {
            b_renamed(0);
            com.oplus.camera.util.Util.a_renamed(this.C_renamed, 0, (android.view.animation.Animation.AnimationListener) null, 300L);
            if (!this.w_renamed.isSelected()) {
                this.mCameraInterface.a_renamed(true, false);
                this.mCameraInterface.d_renamed(true);
            }
            this.mCameraUIInterface.a_renamed(getShutterButtonInfo());
            b_renamed(0, true);
            if (y_renamed()) {
                com.oplus.camera.util.Util.a_renamed(this.y_renamed, 0, (android.view.animation.Animation.AnimationListener) null, 300L);
            }
        } else if (b_renamed(m_renamed())) {
            com.oplus.camera.ui.control.b_renamed shutterButtonInfo = getShutterButtonInfo();
            if (1 != this.mCameraUIInterface.s_renamed() && !com.oplus.camera.util.Util.ao_renamed()) {
                shutterButtonInfo.a_renamed(11);
            }
            this.mCameraUIInterface.a_renamed(shutterButtonInfo);
            b_renamed(0);
            com.oplus.camera.util.Util.a_renamed(this.C_renamed, 0, (android.view.animation.Animation.AnimationListener) null, 300L);
            if (!this.w_renamed.isSelected()) {
                this.mCameraInterface.a_renamed(true, false);
            }
            b_renamed(0, true);
            if (y_renamed()) {
                com.oplus.camera.util.Util.a_renamed(this.y_renamed, 0, (android.view.animation.Animation.AnimationListener) null, 300L);
            }
        }
        this.mCameraUIInterface.d_renamed(true, false);
        if (this.l_renamed) {
            com.oplus.camera.util.Util.a_renamed(this.C_renamed, 0, (android.view.animation.Animation.AnimationListener) null, 300L);
            this.l_renamed = false;
        }
        this.C_renamed.setTouchState(true);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void cameraIdChanged(int i_renamed) {
        super.cameraIdChanged(i_renamed);
        final int iAs = this.mCameraInterface.as_renamed();
        com.oplus.camera.e_renamed.a_renamed("ProfessionalCapMode", "cameraIdChanged, id_renamed: " + iAs);
        if (this.E_renamed != iAs) {
            this.E_renamed = iAs;
            this.F_renamed = true;
            this.mActivity.runOnUiThread(new java.lang.Runnable() { // from class: com.oplus.camera.professional.v_renamed.9
                @Override // java.lang.Runnable
                public void run() {
                    if (com.oplus.camera.professional.v_renamed.this.E_renamed()) {
                        com.oplus.camera.professional.v_renamed.this.w_renamed.setVisibility(8);
                        com.oplus.camera.professional.v_renamed.this.w_renamed.setItemPressed(false);
                        com.oplus.camera.professional.v_renamed.this.x_renamed.e_renamed();
                        if (com.oplus.camera.professional.v_renamed.this.w_renamed.isSelected()) {
                            com.oplus.camera.professional.v_renamed.this.x_renamed.e_renamed();
                            com.oplus.camera.professional.v_renamed.this.w_renamed.a_renamed();
                            return;
                        }
                        return;
                    }
                    com.oplus.camera.professional.v_renamed.this.w_renamed.setVisibility(0);
                    com.oplus.camera.professional.v_renamed.this.x_renamed.setVisibility(0);
                    com.oplus.camera.professional.v_renamed.this.mCameraUIInterface.w_renamed(true);
                    com.oplus.camera.professional.v_renamed.this.c_renamed(iAs);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean E_renamed() {
        if (this.mPreferences != null) {
            return "camera_macro".equals(this.mPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_SWITCH_CAMERA, "camera_main"));
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void c_renamed(int i_renamed) {
        this.x_renamed.d_renamed();
        com.oplus.camera.e_renamed.h_renamed cameraInfo = getCameraInfo(i_renamed);
        this.x_renamed.a_renamed(cameraInfo.u_renamed(), cameraInfo.v_renamed(), cameraInfo.w_renamed(), this.B_renamed);
        this.x_renamed.a_renamed(isSuperRawOpen() ? 2000000000L : cameraInfo.x_renamed(), cameraInfo.y_renamed(), cameraInfo.a_renamed(256), this.B_renamed);
        this.x_renamed.a_renamed(cameraInfo.B_renamed(), this.B_renamed);
        this.x_renamed.a_renamed(cameraInfo.n_renamed(), cameraInfo.m_renamed(), this.B_renamed);
        this.x_renamed.a_renamed(cameraInfo.p_renamed(), cameraInfo.q_renamed(), cameraInfo.r_renamed(), this.B_renamed);
        this.x_renamed.e_renamed();
        if (this.w_renamed.isSelected()) {
            this.x_renamed.f_renamed(this.w_renamed.getSelectedIndex());
        }
        this.x_renamed.a_renamed();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void setOrientation(int i_renamed) throws android.content.res.Resources.NotFoundException {
        com.oplus.camera.ui.RotateImageView rotateImageView = this.I_renamed;
        if (rotateImageView != null) {
            rotateImageView.a_renamed(i_renamed, true);
        }
        com.oplus.camera.ui.RotateImageView rotateImageView2 = this.y_renamed;
        if (rotateImageView2 != null) {
            rotateImageView2.a_renamed(i_renamed, true);
        }
        if (this.mOrientation == i_renamed) {
            return;
        }
        this.mOrientation = i_renamed;
        com.oplus.camera.p_renamed.a_renamed aVar = this.A_renamed;
        if (aVar != null) {
            aVar.e_renamed = this.mOrientation;
        }
        com.oplus.camera.ui.a_renamed.a_renamed aVarK = this.mCameraUIInterface.k_renamed();
        if (aVarK != null) {
            aVarK.g_renamed();
        }
        android.animation.ValueAnimator valueAnimator = this.aj_renamed;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        if (Z_renamed() && this.ab_renamed != 0) {
            this.ab_renamed = 0;
        }
        d_renamed(0);
        com.oplus.camera.p_renamed pVar = this.z_renamed;
        if (pVar != null) {
            pVar.a_renamed(this.A_renamed, false, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean F_renamed() {
        return this.mOrientation % 180 == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean G_renamed() {
        return 90 == this.mOrientation;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void onResume(boolean z_renamed) throws android.content.res.Resources.NotFoundException {
        com.oplus.camera.e_renamed.a_renamed("ProfessionalCapMode", "onResume");
        if (this.mPreferences != null) {
            this.j_renamed = "on_renamed".equals(this.mPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_HIGH_RESOLUTION, this.D_renamed.getString(com.oplus.camera.R_renamed.string.camera_high_resolution_default_value)));
        }
        if (this.z_renamed != null) {
            a_renamed(false, false, true);
            this.z_renamed.a_renamed();
        }
        if (com.oplus.camera.util.Util.z_renamed(this.mActivity)) {
            com.oplus.camera.professional.v_renamed.a_renamed aVar = this.C_renamed;
            if (aVar != null) {
                aVar.setVisibility(0);
            }
            this.mCameraInterface.d_renamed(true);
            a_renamed(1);
        }
        com.oplus.camera.professional.ListProfessionalModeBar listProfessionalModeBar = this.w_renamed;
        if (listProfessionalModeBar != null) {
            listProfessionalModeBar.setBackgroundColor(0);
        }
        this.P_renamed = false;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void onPause() throws android.content.res.Resources.NotFoundException {
        com.oplus.camera.e_renamed.a_renamed("ProfessionalCapMode", "onPause");
        this.mCameraUIInterface.g_renamed(0);
        this.mCameraUIInterface.g_renamed(false);
        if (Z_renamed() && this.ab_renamed != 0) {
            this.ab_renamed = 0;
            e_renamed(0);
        }
        com.oplus.camera.professional.v_renamed.a_renamed aVar = this.C_renamed;
        if (aVar != null) {
            aVar.setTouchState(false);
        }
        android.animation.ValueAnimator valueAnimator = this.K_renamed;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.K_renamed = null;
        }
        this.l_renamed = false;
        android.os.Handler handler = this.B_renamed;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        com.oplus.camera.professional.p_renamed pVar = this.x_renamed;
        if (pVar != null) {
            pVar.h_renamed();
        }
        com.oplus.camera.professional.ListProfessionalModeBar listProfessionalModeBar = this.w_renamed;
        if (listProfessionalModeBar != null) {
            listProfessionalModeBar.setBackgroundColor(0);
            this.w_renamed.a_renamed(true, false);
        }
        this.mCameraUIInterface.d_renamed(true, false);
        this.P_renamed = false;
        this.Q_renamed = true;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void onDestroy() {
        com.oplus.camera.e_renamed.a_renamed("ProfessionalCapMode", "onDestroy");
        com.oplus.camera.professional.p_renamed pVar = this.x_renamed;
        if (pVar != null) {
            pVar.f_renamed();
            this.x_renamed = null;
            this.G_renamed = false;
        }
        if (this.C_renamed != null) {
            this.C_renamed = null;
        }
        if (this.I_renamed != null) {
            this.I_renamed = null;
        }
        if (this.w_renamed != null) {
            this.w_renamed = null;
        }
        com.oplus.camera.p_renamed pVar2 = this.z_renamed;
        if (pVar2 != null) {
            pVar2.c_renamed();
            this.z_renamed = null;
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

    private void H_renamed() {
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
        boolean z_renamed = com.oplus.camera.ui.CameraUIInterface.KEY_RAW_CONTROL.equals(str) && getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_RAW_CONTROL);
        boolean z2 = com.oplus.camera.ui.CameraUIInterface.KEY_SUPER_RAW_CONTROL.equals(str) && com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_SUPPORT_PROFESSIONAL_SUPER_RAW);
        if ((z_renamed || z2) && getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_SWITCH_DUAL_CAMERA) && this.mPreferences != null) {
            return com.oplus.camera.util.Util.e_renamed(this.mPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_SWITCH_CAMERA, "camera_main"));
        }
        return super.isCameraSettingMenuOptionEnable(str);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onAfterStartPreview(boolean z_renamed) throws android.content.res.Resources.NotFoundException {
        com.oplus.camera.e_renamed.b_renamed("ProfessionalCapMode", "onAfterStartPreview");
        com.oplus.camera.professional.v_renamed.a_renamed aVar = this.C_renamed;
        if (aVar != null) {
            aVar.setTouchState(true);
        }
        if (E_renamed()) {
            this.mCameraUIInterface.b_renamed(com.oplus.camera.R_renamed.string.camera_macro_best_focus_distance_text, com.oplus.camera.R_renamed.drawable.screen_hint_textview_bg, com.oplus.camera.R_renamed.color.screen_hint_text_color, java.lang.Integer.valueOf(com.oplus.camera.aps.config.CameraConfig.getConfigIntValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_MACRO_BEST_FOCUS_DISTANCE)));
        }
        if (getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_PRO_HISTOGRAM)) {
            aa_renamed();
        }
        w_renamed();
        T_renamed();
        q_renamed();
        if (this.mCameraInterface != null && isSuperRawOpen()) {
            this.mCameraUIInterface.a_renamed(true, false);
        }
        super.onAfterStartPreview(z_renamed);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void onBeforePreview() throws java.lang.NumberFormatException {
        com.oplus.camera.e_renamed.a_renamed("ProfessionalCapMode", "onBeforePreview");
        this.mActivity.runOnUiThread(new java.lang.Runnable() { // from class: com.oplus.camera.professional.v_renamed.10
            @Override // java.lang.Runnable
            public void run() {
                if (com.oplus.camera.professional.v_renamed.this.mOneCamera == null || com.oplus.camera.professional.v_renamed.this.mOneCamera.e_renamed() == null || com.oplus.camera.professional.v_renamed.this.mOneCamera.e_renamed().s_renamed()) {
                    com.oplus.camera.professional.v_renamed.this.a_renamed(true, 4);
                } else {
                    if (4 == com.oplus.camera.professional.v_renamed.this.w_renamed.getSelectedIndex()) {
                        com.oplus.camera.professional.v_renamed.this.mCameraInterface.a_renamed(true, true);
                        com.oplus.camera.professional.v_renamed.this.mCameraInterface.d_renamed(true);
                        com.oplus.camera.professional.v_renamed.this.x_renamed.e_renamed();
                        com.oplus.camera.professional.v_renamed.this.w_renamed.a_renamed();
                        com.oplus.camera.professional.v_renamed.this.mOneCamera.j_renamed(false);
                    }
                    com.oplus.camera.professional.v_renamed.this.a_renamed(false, 4);
                }
                if (com.oplus.camera.professional.v_renamed.this.w_renamed != null) {
                    com.oplus.camera.professional.v_renamed.this.w_renamed.a_renamed(true, false);
                    if (com.oplus.camera.professional.v_renamed.this.w_renamed.isSelected()) {
                        com.oplus.camera.professional.v_renamed.this.mCameraInterface.a_renamed((android.animation.AnimatorListenerAdapter) null, false, false);
                    }
                }
            }
        });
        this.mOneCamera.a_renamed((com.oplus.ocs.camera.CameraParameter.PreviewKey<com.oplus.ocs.camera.CameraParameter.PreviewKey<java.lang.Float>>) com.oplus.ocs.camera.CameraParameter.ZOOM_RATIO, (com.oplus.ocs.camera.CameraParameter.PreviewKey<java.lang.Float>) java.lang.Float.valueOf(this.mCameraInterface.ak_renamed()));
        if (getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_FOCUS_PEAKING)) {
            if (!com.oplus.camera.util.Util.ao_renamed()) {
                int iA = com.oplus.camera.util.Util.A_renamed(this.mActivity);
                java.lang.String[] strArrB = com.oplus.camera.util.Util.b_renamed(android.graphics.Color.red(iA), android.graphics.Color.green(iA), android.graphics.Color.blue(iA));
                if (strArrB != null && strArrB.length == 2) {
                    this.mOneCamera.a_renamed(strArrB);
                }
            }
            this.mOneCamera.a_renamed(this.mPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_FOCUS_PEAKING, "off").equals("on_renamed"), false);
        }
        if (this.F_renamed || this.mPreferences.getBoolean(com.oplus.camera.ui.CameraUIInterface.KEY_RESTORE_PROFESSIONAL_PARAMS, false)) {
            com.oplus.camera.e_renamed.a_renamed("ProfessionalCapMode", "onBeforePreview, initParamToAuto");
            b_renamed(false);
            final java.lang.String string = this.mPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_PARAMETER_SAVING, "off");
            if (!getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_PARAMETER_SAVING) || string.equals("off")) {
                return;
            }
            this.mActivity.runOnUiThread(new java.lang.Runnable() { // from class: com.oplus.camera.professional.v_renamed.11
                @Override // java.lang.Runnable
                public void run() {
                    com.oplus.camera.professional.v_renamed.this.a_renamed(false, string);
                }
            });
            return;
        }
        if (this.mbCapModeInit) {
            o_renamed();
        }
        f_renamed(false);
        I_renamed();
    }

    private void I_renamed() {
        if (this.mPreferences == null || this.mOneCamera == null) {
            com.oplus.camera.e_renamed.b_renamed("ProfessionalCapMode", "mPreferences or mOneCamera is_renamed null");
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
        java.lang.String string = this.D_renamed.getString(com.oplus.camera.R_renamed.string.camera_exposure_time_default_value);
        java.lang.String string2 = this.mPreferences.getString("pref_professional_exposure_time_key", string);
        return (android.text.TextUtils.isEmpty(string2) || !string2.equals(string)) ? "off" : super.getFlashMode();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(android.view.View view) {
        com.oplus.camera.ui.RotateImageView rotateImageView;
        if (view.getId() == com.oplus.camera.R_renamed.id_renamed.professional_parameter_bottom_guide_entry && this.mCameraUIInterface != null && (rotateImageView = this.I_renamed) != null && rotateImageView.getVisibility() == 0) {
            this.mCameraUIInterface.at_renamed();
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void hideViewWhileResume() {
        com.oplus.camera.professional.v_renamed.a_renamed aVar = this.C_renamed;
        if (aVar != null) {
            aVar.setVisibility(4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J_renamed() {
        com.oplus.camera.professional.p_renamed pVar;
        if (this.w_renamed == null || (pVar = this.x_renamed) == null) {
            return;
        }
        pVar.setPreference(4);
    }

    private void K_renamed() {
        com.oplus.camera.professional.p_renamed pVar;
        if (this.w_renamed == null || (pVar = this.x_renamed) == null) {
            return;
        }
        pVar.setPreference(5);
    }

    private void L_renamed() {
        com.oplus.camera.professional.p_renamed pVar;
        if (this.w_renamed == null || (pVar = this.x_renamed) == null) {
            return;
        }
        pVar.setPreference(1);
        this.x_renamed.setPreference(2);
    }

    private void M_renamed() {
        com.oplus.camera.professional.p_renamed pVar;
        if (this.w_renamed == null || (pVar = this.x_renamed) == null) {
            return;
        }
        pVar.setPreference(3);
    }

    private void N_renamed() {
        com.oplus.camera.professional.ListProfessionalModeBar listProfessionalModeBar = this.w_renamed;
        if (listProfessionalModeBar != null) {
            listProfessionalModeBar.setVisibility(8);
            this.w_renamed.setItemPressed(false);
        }
        com.oplus.camera.professional.p_renamed pVar = this.x_renamed;
        if (pVar != null) {
            pVar.setVisibility(4);
        }
    }

    private void O_renamed() {
        com.oplus.camera.professional.ListProfessionalModeBar listProfessionalModeBar = this.w_renamed;
        if (listProfessionalModeBar != null) {
            listProfessionalModeBar.setVisibility(0);
            this.w_renamed.setItemPressed(true);
        }
        com.oplus.camera.professional.p_renamed pVar = this.x_renamed;
        if (pVar != null) {
            pVar.setVisibility(0);
        }
    }

    private void P_renamed() {
        com.oplus.camera.professional.p_renamed pVar = this.x_renamed;
        if (pVar != null) {
            pVar.clearAnimation();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a_renamed(boolean z_renamed, int i_renamed) {
        android.view.View viewA;
        com.oplus.camera.professional.ListProfessionalModeBar listProfessionalModeBar = this.w_renamed;
        if (listProfessionalModeBar == null || (viewA = listProfessionalModeBar.a_renamed(i_renamed)) == null) {
            return;
        }
        viewA.setEnabled(z_renamed);
        if (viewA instanceof com.oplus.camera.professional.y_renamed) {
            ((com.oplus.camera.professional.y_renamed) viewA).setRotateViewClickable(z_renamed);
        }
        this.w_renamed.getAdapter().b_renamed(viewA, z_renamed, true);
    }

    @Override // com.oplus.camera.professional.ListProfessionalModeBar.OnItemClickListener
    public void a_renamed(android.view.View view, android.view.View view2, long j_renamed) throws java.lang.NumberFormatException {
        if (this.mCameraInterface.A_renamed()) {
            return;
        }
        int iA = this.w_renamed.a_renamed(view2);
        boolean z_renamed = 4 == f_renamed();
        if (iA == 0) {
            b_renamed(true);
            a_renamed(1);
            a_renamed(iA, this.w_renamed.isSelected());
            return;
        }
        if (com.oplus.camera.professional.ListProfessionalModeBar.ModePressState.NO_PRESSED == this.w_renamed.getModePressState() && this.w_renamed.isSelected()) {
            onBackPressed();
            a_renamed(iA, false);
            return;
        }
        if (!e_renamed() && !z_renamed) {
            this.mCameraInterface.d_renamed(false);
            this.mCameraInterface.a_renamed((android.animation.AnimatorListenerAdapter) null, true, true);
        }
        this.mCameraUIInterface.B_renamed(false);
        if (this.mCameraUIInterface.T_renamed()) {
            this.mCameraUIInterface.x_renamed(false);
        }
        P_renamed();
        com.oplus.camera.e_renamed.f_renamed("ProfessionalCapMode", "onItemClick, index: " + iA + ", id_renamed: " + j_renamed);
        a_renamed(iA, true);
        if (2 == iA) {
            this.p_renamed = isSuperRawOpen();
        }
        if (z_renamed) {
            this.mCameraUIInterface.g_renamed(4);
        }
        this.x_renamed.a_renamed(iA, true);
    }

    private void e_renamed(boolean z_renamed) {
        java.lang.String string = this.mPreferences.getString("pref_professional_whitebalance_key", this.D_renamed.getString(com.oplus.camera.R_renamed.string.camera_whitebalance_default_value));
        if (this.D_renamed.getString(com.oplus.camera.R_renamed.string.camera_whitebalance_default_value).equals(string)) {
            this.mOneCamera.a_renamed(-1, z_renamed);
        }
        if (a_renamed(string, this.x_renamed.c_renamed(5))) {
            try {
                this.mOneCamera.a_renamed(java.lang.Integer.parseInt(string), z_renamed);
            } catch (java.lang.NumberFormatException unused) {
                this.mOneCamera.i_renamed(z_renamed);
            }
        } else {
            this.mOneCamera.i_renamed(z_renamed);
        }
        com.oplus.camera.e_renamed.a_renamed("ProfessionalCapMode", "setWhiteBalance, whiteBalance: " + string);
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
            str = this.mPreferences.getString("pref_professional_iso_key", this.D_renamed.getString(com.oplus.camera.R_renamed.string.camera_iso_default_value));
        }
        if (!this.mPreferences.getString("pref_professional_iso_key", this.D_renamed.getString(com.oplus.camera.R_renamed.string.camera_iso_default_value)).equals(str)) {
            android.content.SharedPreferences.Editor editorEdit = this.mPreferences.edit();
            editorEdit.putString("pref_professional_iso_key", com.oplus.camera.professional.x_renamed.a_renamed(this.mActivity, 1));
            editorEdit.apply();
        }
        if (this.D_renamed.getString(com.oplus.camera.R_renamed.string.camera_iso_default_value).equals(str)) {
            this.mOneCamera.b_renamed(-1, z_renamed);
        } else {
            W_renamed();
            this.mOneCamera.r_renamed();
            this.mOneCamera.b_renamed(java.lang.Integer.parseInt(str), z_renamed);
        }
        com.oplus.camera.e_renamed.a_renamed("ProfessionalCapMode", "setISOValue, iso: " + str);
        a_renamed(7);
        a_renamed(8);
    }

    public void a_renamed(java.lang.String str) {
        if (str == null) {
            str = this.mPreferences.getString("pref_professional_focus_mode_key", this.mActivity.getString(com.oplus.camera.R_renamed.string.camera_focus_mode_default_value));
        }
        com.oplus.camera.e_renamed.a_renamed("ProfessionalCapMode", "setFocusValue, focusValue: " + str);
        if (this.mActivity.getString(com.oplus.camera.R_renamed.string.camera_focus_mode_default_value).equals(str)) {
            return;
        }
        this.B_renamed.removeMessages(2);
        android.os.Message messageObtain = android.os.Message.obtain();
        messageObtain.what = 2;
        this.B_renamed.sendMessage(messageObtain);
        if (this.mOneCamera != null) {
            if (this.mCameraInterface.z_renamed()) {
                this.mCameraInterface.b_renamed(false, false);
            }
            this.mOneCamera.a_renamed(java.lang.Float.parseFloat(str), true);
        }
        if (this.j_renamed) {
            g_renamed(false);
        }
        a_renamed(8);
    }

    public int c_renamed() {
        return java.lang.Integer.parseInt(this.mPreferences.getString("pref_professional_exposure_compensation_key", this.D_renamed.getString(com.oplus.camera.R_renamed.string.camera_exposure_compensation_default_value)));
    }

    private void Q_renamed() throws java.lang.NumberFormatException {
        f_renamed(true);
    }

    private void f_renamed(boolean z_renamed) throws java.lang.NumberFormatException {
        java.lang.String string = this.mPreferences.getString("pref_professional_exposure_time_key", this.D_renamed.getString(com.oplus.camera.R_renamed.string.camera_exposure_time_default_value));
        long jLongValue = java.lang.Long.valueOf(this.D_renamed.getString(com.oplus.camera.R_renamed.string.camera_exposure_time_default_value)).longValue();
        long j_renamed = java.lang.Long.parseLong(string);
        if (j_renamed != jLongValue) {
            W_renamed();
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
        com.oplus.camera.e_renamed.a_renamed("ProfessionalCapMode", "setFlashModeMenuEnable, exposureTime: " + str + ", mDisPlayFlashIcon: " + boolValueOf);
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
                this.mActivity.runOnUiThread(new java.lang.Runnable() { // from class: com.oplus.camera.professional.v_renamed.13
                    @Override // java.lang.Runnable
                    public void run() {
                        if (java.lang.Integer.parseInt(str) == 0) {
                            if (com.oplus.camera.professional.v_renamed.this.mCameraUIInterface != null) {
                                com.oplus.camera.professional.v_renamed.this.a_renamed(true, boolValueOf.booleanValue());
                                com.oplus.camera.professional.v_renamed.this.mCameraUIInterface.b_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_FLASH_MODE, (java.lang.String) null);
                                return;
                            }
                            return;
                        }
                        if (com.oplus.camera.professional.v_renamed.this.mCameraUIInterface != null) {
                            com.oplus.camera.professional.v_renamed.this.a_renamed(false, boolValueOf.booleanValue());
                            com.oplus.camera.professional.v_renamed.this.mCameraUIInterface.a_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_FLASH_MODE, "off");
                        }
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a_renamed(boolean z_renamed, boolean z2) {
        if (z2) {
            com.oplus.camera.e_renamed.a_renamed("ProfessionalCapMode", "showOrHideFlashIcon, enable: " + z_renamed + ", isOpenFlash: " + isOpenFlash());
            if (z_renamed) {
                displayScreenHintIconInSwitchOn();
            } else {
                this.mCameraUIInterface.a_renamed(false, true, false);
            }
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onSharedPreferenceChanged(android.content.SharedPreferences sharedPreferences, java.lang.String str) throws android.content.res.Resources.NotFoundException, java.lang.NumberFormatException {
        com.oplus.camera.e_renamed.a_renamed("ProfessionalCapMode", "onSharedPreferenceChanged, key: " + str);
        if (com.oplus.camera.ui.CameraUIInterface.KEY_PHOTO_RATIO.equals(str) && !com.oplus.camera.util.Util.t_renamed()) {
            this.H_renamed = "square".equals(sharedPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_PHOTO_RATIO, null));
            this.af_renamed = com.oplus.camera.util.Util.L_renamed();
        }
        if ("pref_professional_whitebalance_key".equals(str)) {
            e_renamed(true);
            return;
        }
        if ("pref_professional_iso_key".equals(str)) {
            if (!com.oplus.camera.Camera.l_renamed) {
                this.mOneCamera.b_renamed(getFlashMode());
            } else {
                this.mOneCamera.b_renamed("off");
            }
            e_renamed((java.lang.String) null);
            return;
        }
        if ("pref_professional_exposure_compensation_key".equals(str)) {
            this.mOneCamera.a_renamed((android.hardware.camera2.CaptureRequest.Key<android.hardware.camera2.CaptureRequest.Key>) android.hardware.camera2.CaptureRequest.CONTROL_AE_EXPOSURE_COMPENSATION, (android.hardware.camera2.CaptureRequest.Key) java.lang.Integer.valueOf(c_renamed()));
            this.mOneCamera.a_renamed((com.oplus.camera.e_renamed.d_renamed.c_renamed) null);
            B_renamed();
            return;
        }
        if ("pref_professional_exposure_time_key".equals(str)) {
            if (!com.oplus.camera.Camera.l_renamed) {
                this.mOneCamera.b_renamed(getFlashMode());
            } else {
                this.mOneCamera.b_renamed("off");
            }
            Q_renamed();
            long jN = n_renamed();
            if (this.w_renamed.isSelected() && this.p_renamed && jN >= 500000000 && isSuperRawOpen()) {
                this.p_renamed = false;
                this.mCameraUIInterface.a_renamed(com.oplus.camera.R_renamed.string.camera_raw_control_hint_super_long_exposure, -1, true, false, false);
                return;
            }
            return;
        }
        if (com.oplus.camera.ui.CameraUIInterface.KEY_HIGH_RESOLUTION.equals(str)) {
            V_renamed();
        } else if ("pref_professional_focus_mode_key".equals(str)) {
            this.x_renamed.h_renamed(4);
            if (!this.x_renamed.g_renamed(4)) {
                a_renamed((java.lang.String) null);
                this.r_renamed = true;
            } else {
                if (this.mOneCamera.p_renamed() == 0) {
                    this.r_renamed = false;
                }
                if (4 != this.mOneCamera.p_renamed() || this.r_renamed) {
                    this.mOneCamera.a_renamed(4, com.oplus.camera.a_renamed.b_renamed(), com.oplus.camera.a_renamed.b_renamed(), true);
                    this.mOneCamera.a_renamed((com.oplus.camera.e_renamed.d_renamed.c_renamed) null);
                }
                if (4 == this.mOneCamera.p_renamed() || 1 == this.mOneCamera.p_renamed()) {
                    J_renamed();
                    this.x_renamed.setPanelsBarAuto(4);
                }
            }
            S_renamed();
            B_renamed();
        } else if (com.oplus.camera.ui.CameraUIInterface.KEY_FLASH_MODE.equals(str)) {
            if (!this.mActivity.getString(com.oplus.camera.R_renamed.string.camera_flash_mode_default_value).equals(sharedPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_FLASH_MODE, this.mActivity.getString(com.oplus.camera.R_renamed.string.camera_flash_mode_default_value)))) {
                U_renamed();
                B_renamed();
            }
            g_renamed(true);
        } else {
            if (com.oplus.camera.ui.CameraUIInterface.KEY_RAW_CONTROL.equals(str) && getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_RAW_CONTROL)) {
                R_renamed();
                return;
            }
            if (com.oplus.camera.ui.CameraUIInterface.KEY_SUPER_RAW_CONTROL.equals(str) && getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_SUPER_RAW_CONTROL)) {
                R_renamed();
                return;
            }
            if (com.oplus.camera.ui.CameraUIInterface.KEY_PARAMETER_SAVING.equals(str)) {
                boolean z_renamed = this.q_renamed;
                z_renamed();
                if (!z_renamed && this.q_renamed) {
                    a_renamed(true, "off");
                }
                a_renamed(false, this.mPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_PARAMETER_SAVING, "off"));
                A_renamed();
                if (this.w_renamed.isSelected()) {
                    if (this.x_renamed.b_renamed(this.w_renamed.getSelectedIndex())) {
                        return;
                    }
                    onBackPressed();
                    return;
                }
                return;
            }
            if (com.oplus.camera.ui.CameraUIInterface.KEY_PRO_HISTOGRAM.equals(str)) {
                b_renamed(false, true);
                if (this.mCameraUIInterface != null) {
                    if (Z_renamed()) {
                        this.U_renamed = true;
                        if (270 != this.mOrientation) {
                            this.mCameraUIInterface.w_renamed(150);
                        }
                        this.mCameraUIInterface.a_renamed(com.oplus.camera.R_renamed.string.hint_histogram_on, -1, true, true, false);
                        return;
                    }
                    this.U_renamed = false;
                    this.mCameraUIInterface.a_renamed(com.oplus.camera.R_renamed.string.hint_histogram_off, -1, true, true, false);
                    this.mCameraUIInterface.w_renamed(0);
                    return;
                }
                return;
            }
            if (com.oplus.camera.ui.CameraUIInterface.KEY_SUB_SETTING.equals(str)) {
                d_renamed(true);
                b_renamed(true, false);
            } else {
                if (com.oplus.camera.ui.CameraUIInterface.KEY_FOCUS_PEAKING.equals(str)) {
                    boolean zEquals = this.mPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_FOCUS_PEAKING, "off").equals("on_renamed");
                    if (this.mCameraUIInterface != null) {
                        if (zEquals) {
                            this.mCameraUIInterface.a_renamed(com.oplus.camera.R_renamed.string.hint_focus_peaking_on, -1, true, true, false);
                        } else {
                            this.mCameraUIInterface.a_renamed(com.oplus.camera.R_renamed.string.hint_focus_peaking_off, -1, true, true, false);
                        }
                    }
                    if (this.mOneCamera != null) {
                        this.mOneCamera.a_renamed(zEquals, true);
                        return;
                    }
                    return;
                }
                if (this.mCameraUIInterface.k_renamed().a_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_PHOTO_RATIO) || this.mCameraUIInterface.k_renamed().a_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_PHOTO_RATIO_FROM_OTHER_APP)) {
                    java.lang.String string = this.mPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_PHOTO_RATIO, this.mActivity.getString(com.oplus.camera.R_renamed.string.camera_photo_ratio_default_value));
                    if ("square".equals(string)) {
                        this.ae_renamed = com.oplus.camera.util.Util.L_renamed() + com.oplus.camera.util.Util.N_renamed();
                    } else {
                        this.ae_renamed = com.oplus.camera.util.Util.N_renamed();
                    }
                    if ("square".equals(string) || "square".equals(this.ag_renamed)) {
                        this.V_renamed = true;
                    } else {
                        this.V_renamed = false;
                    }
                }
            }
        }
        super.onSharedPreferenceChanged(sharedPreferences, str);
        if (com.oplus.camera.ui.CameraUIInterface.KEY_SWITCH_CAMERA.equals(str)) {
            T_renamed();
            H_renamed();
        }
    }

    private void R_renamed() throws android.content.res.Resources.NotFoundException, java.lang.NumberFormatException {
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
                this.x_renamed.b_renamed(false);
                b_renamed(true);
                this.x_renamed.b_renamed(true);
                if (!this.p_renamed) {
                    this.p_renamed = true;
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
            this.x_renamed.a_renamed(getCameraInfo(this.E_renamed), isSuperRawOpen() ? 2000000000L : getCameraInfo(this.E_renamed).x_renamed());
            this.x_renamed.a_renamed();
        } else if ("on_renamed".equals(this.mPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_RAW_CONTROL, "off"))) {
            this.mCameraUIInterface.a_renamed(com.oplus.camera.R_renamed.string.camera_raw_control_hint_on, -1, true, false, false);
            this.mOneCamera.a_renamed((com.oplus.ocs.camera.CameraParameter.PreviewKey<com.oplus.ocs.camera.CameraParameter.PreviewKey<java.lang.String>>) com.oplus.ocs.camera.CameraParameter.RAW_CONTROL, (com.oplus.ocs.camera.CameraParameter.PreviewKey<java.lang.String>) "raw");
        } else {
            this.mCameraUIInterface.a_renamed(com.oplus.camera.R_renamed.string.camera_raw_control_hint_off, -1, true, false, false);
            this.mOneCamera.a_renamed((com.oplus.ocs.camera.CameraParameter.PreviewKey<com.oplus.ocs.camera.CameraParameter.PreviewKey<java.lang.String>>) com.oplus.ocs.camera.CameraParameter.RAW_CONTROL, (com.oplus.ocs.camera.CameraParameter.PreviewKey<java.lang.String>) "none");
        }
        if (this.mCameraInterface != null) {
            if (getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_ZOOM) && !this.w_renamed.isSelected()) {
                this.mCameraInterface.a_renamed(true, false);
                this.mCameraInterface.d_renamed(true);
            } else {
                this.mCameraInterface.a_renamed((android.animation.AnimatorListenerAdapter) null, true, false);
            }
            if (d_renamed()) {
                this.mCameraInterface.aH_renamed();
            }
        }
        this.mOneCamera.a_renamed((com.oplus.camera.e_renamed.d_renamed.c_renamed) null);
    }

    private void S_renamed() {
        if (!getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_FOCUS_PEAKING) || androidx.preference.j_renamed.a_renamed(this.mActivity).getBoolean("focus_peaking_clicked", false) || this.x_renamed == null || this.mPreferences == null) {
            return;
        }
        boolean zG = this.x_renamed.g_renamed(4);
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

    private void T_renamed() throws android.content.res.Resources.NotFoundException {
        if (this.mPreferences == null) {
            return;
        }
        java.lang.String string = this.mPreferences.getString("pref_professional_exposure_time_key", this.D_renamed.getString(com.oplus.camera.R_renamed.string.camera_exposure_time_default_value));
        java.lang.String string2 = this.mPreferences.getString("pref_professional_iso_key", this.D_renamed.getString(com.oplus.camera.R_renamed.string.camera_iso_default_value));
        if (getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_SWITCH_CAMERA) && getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_FLASH_MODE) && this.D_renamed.getString(com.oplus.camera.R_renamed.string.camera_exposure_time_default_value).equals(string) && this.D_renamed.getString(com.oplus.camera.R_renamed.string.camera_iso_default_value).equals(string2)) {
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

    private void U_renamed() {
        android.view.View viewA;
        android.view.View viewA2;
        if ("off".equals(this.mPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_FLASH_MODE, this.mActivity.getString(com.oplus.camera.R_renamed.string.camera_flash_mode_default_value)))) {
            return;
        }
        java.lang.String string = this.mPreferences.getString("pref_professional_exposure_time_key", this.D_renamed.getString(com.oplus.camera.R_renamed.string.camera_exposure_time_default_value));
        java.lang.String string2 = this.mPreferences.getString("pref_professional_iso_key", this.D_renamed.getString(com.oplus.camera.R_renamed.string.camera_iso_default_value));
        if (!this.D_renamed.getString(com.oplus.camera.R_renamed.string.camera_exposure_time_default_value).equals(string)) {
            this.x_renamed.setAuto(2);
            if (this.w_renamed.isSelected() && (viewA2 = this.w_renamed.a_renamed(2)) != null) {
                this.w_renamed.getAdapter().a_renamed(viewA2, 0, true);
            }
        }
        if (this.D_renamed.getString(com.oplus.camera.R_renamed.string.camera_iso_default_value).equals(string2)) {
            return;
        }
        this.x_renamed.setAuto(1);
        if (!this.w_renamed.isSelected() || (viewA = this.w_renamed.a_renamed(1)) == null) {
            return;
        }
        this.w_renamed.getAdapter().a_renamed(viewA, 0, true);
    }

    private void g_renamed(boolean z_renamed) {
        boolean zEquals = z_renamed ? true ^ "off".equals(this.mPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_FLASH_MODE, this.mActivity.getString(com.oplus.camera.R_renamed.string.camera_flash_mode_default_value))) : true;
        if (this.j_renamed && zEquals) {
            android.content.SharedPreferences.Editor editorEdit = this.mPreferences.edit();
            editorEdit.putString(com.oplus.camera.ui.CameraUIInterface.KEY_HIGH_RESOLUTION, "off");
            editorEdit.apply();
            this.mCameraUIInterface.b_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_HIGH_RESOLUTION, "off");
        }
    }

    private void V_renamed() {
        com.oplus.camera.e_renamed.a_renamed("ProfessionalCapMode", "updateHighResolutionMode");
        this.j_renamed = "on_renamed".equals(this.mPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_HIGH_RESOLUTION, this.D_renamed.getString(com.oplus.camera.R_renamed.string.camera_high_resolution_default_value)));
        com.oplus.camera.ui.control.b_renamed bVar = new com.oplus.camera.ui.control.b_renamed(1);
        bVar.a_renamed("button_color_inside_none");
        this.mOneCamera.m_renamed(getZSLMode());
        if (this.j_renamed) {
            W_renamed();
            X_renamed();
            this.x_renamed.setAuto(1);
            this.x_renamed.setAuto(2);
            this.x_renamed.setAuto(5);
            this.x_renamed.setAuto(4);
            com.oplus.camera.professional.p_renamed pVar = this.x_renamed;
            pVar.a_renamed(3, "pref_professional_exposure_compensation_key", pVar.c_renamed(3).indexOf(com.oplus.camera.professional.x_renamed.a_renamed(this.mActivity, 3)));
            a_renamed(1);
            this.mCameraUIInterface.a_renamed(bVar);
            if (this.mOneCamera.p_renamed() == 0) {
                this.mOneCamera.a_renamed(getDefaultAFMode(), com.oplus.camera.a_renamed.b_renamed(), com.oplus.camera.a_renamed.b_renamed(), true);
                this.mOneCamera.a_renamed((android.hardware.camera2.CaptureRequest.Key<android.hardware.camera2.CaptureRequest.Key>) android.hardware.camera2.CaptureRequest.CONTROL_AE_EXPOSURE_COMPENSATION, (android.hardware.camera2.CaptureRequest.Key) java.lang.Integer.valueOf(com.oplus.camera.a_renamed.c_renamed()));
                this.mOneCamera.a_renamed((com.oplus.camera.e_renamed.d_renamed.c_renamed) null);
            }
            if (1 == this.mOneCamera.p_renamed() || 4 == this.mOneCamera.p_renamed()) {
                J_renamed();
                this.x_renamed.setPanelsBarAuto(4);
            }
            this.mCameraUIInterface.a_renamed(com.oplus.camera.R_renamed.string.camera_toast_high_resolution_on, -1, true, false, false);
            return;
        }
        this.mCameraUIInterface.a_renamed(com.oplus.camera.R_renamed.string.camera_toast_high_resolution_off, -1, true, false, false);
        this.mCameraUIInterface.a_renamed(bVar);
    }

    private void W_renamed() {
        if ("off".equals(this.mPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_FLASH_MODE, this.mActivity.getString(com.oplus.camera.R_renamed.string.camera_flash_mode_default_value)))) {
            return;
        }
        android.content.SharedPreferences.Editor editorEdit = this.mPreferences.edit();
        editorEdit.putString(com.oplus.camera.ui.CameraUIInterface.KEY_FLASH_MODE, "off");
        editorEdit.apply();
        this.mActivity.runOnUiThread(new java.lang.Runnable() { // from class: com.oplus.camera.professional.v_renamed.14
            @Override // java.lang.Runnable
            public void run() {
                if (com.oplus.camera.professional.v_renamed.this.mbPaused) {
                    return;
                }
                com.oplus.camera.professional.v_renamed.this.mCameraUIInterface.f_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_FLASH_MODE);
            }
        });
    }

    private void X_renamed() {
        if ("off".equals(this.mPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_RAW, "off"))) {
            return;
        }
        android.content.SharedPreferences.Editor editorEdit = this.mPreferences.edit();
        editorEdit.putString(com.oplus.camera.ui.CameraUIInterface.KEY_RAW, "off");
        editorEdit.apply();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean isNeedProgressBarInCapture() {
        java.lang.String string = this.mPreferences.getString("pref_professional_exposure_time_key", this.D_renamed.getString(com.oplus.camera.R_renamed.string.camera_exposure_time_default_value));
        return android.text.TextUtils.isEmpty(string) || java.lang.Long.valueOf(string).longValue() >= com.google.android.exoplayer2.C_renamed.NANOS_PER_SECOND;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public com.oplus.camera.statistics.model.DcsMsgData onGetBeforeCaptureMsgCommonData(com.oplus.camera.statistics.model.DcsMsgData dcsMsgData) {
        java.lang.String string;
        com.oplus.camera.statistics.model.CaptureMsgData captureMsgData = (dcsMsgData == null || !(dcsMsgData instanceof com.oplus.camera.statistics.model.CaptureMsgData)) ? null : (com.oplus.camera.statistics.model.CaptureMsgData) dcsMsgData;
        if (captureMsgData == null) {
            return null;
        }
        java.lang.String strE = this.x_renamed.e_renamed(5);
        java.lang.String strA = this.x_renamed.a_renamed(java.lang.Integer.valueOf(this.x_renamed.e_renamed(3)).intValue(), this.mOneCamera.e_renamed().r_renamed());
        java.lang.String strE2 = this.x_renamed.e_renamed(2);
        java.lang.String strE3 = this.x_renamed.e_renamed(1);
        java.lang.String focusValue = this.x_renamed.getFocusValue();
        if (android.text.TextUtils.equals(strE2, this.mActivity.getString(com.oplus.camera.R_renamed.string.camera_exposure_time_default_value))) {
            strE2 = "auto";
        }
        captureMsgData.mProfessionWbValue = strE;
        captureMsgData.mProfessionEvValue = strA;
        captureMsgData.mProfessionExpValue = strE2;
        captureMsgData.mProfessionISOValue = strE3;
        captureMsgData.mProfessionFocusValue = focusValue;
        captureMsgData.mProfessionHighResolution = java.lang.String.valueOf(this.j_renamed);
        if (this.mPreferences != null) {
            if (getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_SUPER_RAW_CONTROL)) {
                string = this.mPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_SUPER_RAW_CONTROL, "off");
            } else {
                string = this.mPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_RAW_CONTROL, "off");
            }
            if (getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_PARAMETER_SAVING)) {
                captureMsgData.mProfessionIsPresentParameter = com.oplus.camera.statistics.model.ProfessionalMsgData.buildParameterSaving(this.mPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_PARAMETER_SAVING, "off"));
            }
            if (getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_PRO_HISTOGRAM)) {
                captureMsgData.mProfessionIsHistogram = this.mPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_PRO_HISTOGRAM, "off");
            }
            if (getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_FOCUS_PEAKING)) {
                captureMsgData.mProfessionIsFocusPeaking = this.mPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_FOCUS_PEAKING, "off");
            }
        } else {
            string = "off";
        }
        captureMsgData.mProfessionRawControl = string;
        java.lang.String strBuildPhotoFormat = com.oplus.camera.statistics.model.ProfessionalMsgData.buildPhotoFormat(string);
        if (android.text.TextUtils.isEmpty(strBuildPhotoFormat) || com.oplus.camera.statistics.model.CaptureMsgData.TYPE_PHOTO_FORMAT_JPEG.equals(strBuildPhotoFormat)) {
            strBuildPhotoFormat = captureMsgData.mPhotoFormat;
        }
        captureMsgData.mPhotoFormat = strBuildPhotoFormat;
        captureMsgData.mProfessionCameraId = this.mPreferences != null ? this.mPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_SWITCH_CAMERA, "camera_main") : "camera_main";
        return captureMsgData;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void changeModeAllViewWhenAnimation(int i_renamed, boolean z_renamed) {
        super.changeModeAllViewWhenAnimation(i_renamed, z_renamed);
        if (i_renamed == 3) {
            this.C_renamed.setTouchState((z_renamed && this.mbInCapturing) ? false : z_renamed);
            int i2 = z_renamed ? 0 : 8;
            com.oplus.camera.util.Util.a_renamed(this.C_renamed, i2, (android.view.animation.Animation.AnimationListener) null, 300L);
            if (y_renamed()) {
                com.oplus.camera.util.Util.a_renamed(this.y_renamed, i2, (android.view.animation.Animation.AnimationListener) null, 300L);
                return;
            }
            return;
        }
        if (i_renamed != 5) {
            if (i_renamed == 17 && z_renamed && E_renamed()) {
                this.B_renamed.sendEmptyMessageDelayed(6, 3000L);
                return;
            }
            return;
        }
        if (z_renamed) {
            com.oplus.camera.professional.ListProfessionalModeBar listProfessionalModeBar = this.w_renamed;
            if (listProfessionalModeBar != null) {
                listProfessionalModeBar.setVisibility(0);
                return;
            }
            return;
        }
        if (this.w_renamed != null) {
            N_renamed();
        }
    }

    /* compiled from: ProfessionalCapMode.java */
    public class a_renamed extends android.widget.RelativeLayout {

        /* renamed from: b_renamed, reason: collision with root package name */
        private boolean f5277b;

        public a_renamed(android.content.Context context) {
            super(context);
            this.f5277b = true;
        }

        public void setTouchState(boolean z_renamed) {
            this.f5277b = z_renamed;
        }

        @Override // android.view.ViewGroup, android.view.View
        public boolean dispatchTouchEvent(android.view.MotionEvent motionEvent) {
            if (com.oplus.camera.professional.v_renamed.this.mbCapModeInit && this.f5277b && com.oplus.camera.professional.v_renamed.this.mCameraInterface != null && !com.oplus.camera.professional.v_renamed.this.k_renamed) {
                if (com.oplus.camera.professional.v_renamed.this.mCameraInterface.C_renamed()) {
                    android.view.MotionEvent motionEventObtain = android.view.MotionEvent.obtain(motionEvent);
                    motionEventObtain.setAction(3);
                    super.dispatchTouchEvent(motionEventObtain);
                    return true;
                }
                return super.dispatchTouchEvent(motionEvent);
            }
            if (this.f5277b) {
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
        if (i_renamed == 0) {
            menuClickMsgData.mFuncKeyId = 81;
        } else if (i_renamed == 1) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public void Y_renamed() {
        com.oplus.camera.statistics.model.MenuClickMsgData menuClickMsgData = new com.oplus.camera.statistics.model.MenuClickMsgData(this.mActivity);
        menuClickMsgData.buildEvent(true);
        menuClickMsgData.mFuncKeyId = 77;
        menuClickMsgData.mItem = com.oplus.camera.statistics.model.ProfessionalMsgData.buildParameterSaving(this.mPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_PARAMETER_SAVING, "off"));
        menuClickMsgData.mItemValue = "save";
        menuClickMsgData.mCaptureMode = getCameraMode();
        menuClickMsgData.mCameraId = this.mCameraInterface.aw_renamed();
        menuClickMsgData.mOrientation = this.mOrientation;
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
        zoomConfigure.K_renamed(isRawOpen());
        return zoomConfigure;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected boolean isModeBarSelected() {
        return this.w_renamed.isSelected();
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
            this.mActivity.runOnUiThread(new java.lang.Runnable() { // from class: com.oplus.camera.professional.v_renamed.16
                @Override // java.lang.Runnable
                public void run() {
                    if (str == null || com.oplus.camera.professional.v_renamed.this.w_renamed == null || str.equals(com.oplus.camera.professional.v_renamed.this.w_renamed.b_renamed(i_renamed))) {
                        return;
                    }
                    com.oplus.camera.professional.v_renamed.this.w_renamed.a_renamed(i_renamed, str);
                }
            });
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean isBottomGuideEntryViewShown() {
        com.oplus.camera.ui.RotateImageView rotateImageView = this.I_renamed;
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
        N_renamed();
        com.oplus.camera.ui.RotateImageView rotateImageView = this.y_renamed;
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
            O_renamed();
        }
        if (this.y_renamed != null && y_renamed() && !zF) {
            this.y_renamed.setVisibility(0);
        }
        d_renamed(false);
        b_renamed(false, false);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean isShowProPanelMenu() {
        com.oplus.camera.professional.ListProfessionalModeBar listProfessionalModeBar = this.w_renamed;
        if (listProfessionalModeBar != null) {
            return listProfessionalModeBar.isSelected();
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

    private boolean Z_renamed() {
        return (this.mPreferences == null || !this.mPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_PRO_HISTOGRAM, "off").equals("on_renamed") || this.mPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_SUB_SETTING, "off").equals("on_renamed") || this.P_renamed || !this.Q_renamed) ? false : true;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean isHistogramOpen() {
        return getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_PRO_HISTOGRAM) && Z_renamed();
    }

    private void aa_renamed() throws android.content.res.Resources.NotFoundException {
        if (this.al_renamed != getCurrentScreenMode()) {
            this.ab_renamed = 0;
            this.al_renamed = getCurrentScreenMode();
        }
        e_renamed(this.ab_renamed);
        if (this.z_renamed == null) {
            this.z_renamed = new com.oplus.camera.p_renamed(this.mActivity, this.mCameraRootView, this.A_renamed);
            this.z_renamed.a_renamed(com.oplus.camera.R_renamed.id_renamed.professional_mode_histogram);
        } else if (G_renamed() && this.V_renamed && com.oplus.camera.util.Util.t_renamed()) {
            this.V_renamed = false;
            this.z_renamed.a_renamed();
            this.z_renamed.a_renamed(this.A_renamed, false, false, 0L);
        } else {
            this.z_renamed.a_renamed(this.A_renamed, F_renamed(), G_renamed());
        }
        android.util.Size previewSize = getPreviewSize(this.mOneCamera.e_renamed());
        this.z_renamed.a_renamed(com.oplus.camera.p_renamed.a_renamed(previewSize.getWidth(), previewSize.getHeight()));
    }

    private void d_renamed(int i_renamed) throws android.content.res.Resources.NotFoundException {
        if (this.A_renamed == null) {
            this.A_renamed = new com.oplus.camera.p_renamed.a_renamed();
            this.A_renamed.f4922a = 10;
        }
        com.oplus.camera.screen.b_renamed.a_renamed currentScreenMode = getCurrentScreenMode();
        int iT = t_renamed();
        com.oplus.camera.e_renamed.a_renamed("ProfessionalCapMode", "updateHistogramLayoutConfigs, previewMarginTop: " + iT);
        if (currentScreenMode != null) {
            currentScreenMode.a_renamed(this.A_renamed, iT, this.mOrientation);
            return;
        }
        android.content.res.Resources resources = this.mActivity.getResources();
        int dimensionPixelSize = resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.professional_histogram_margin_top);
        int dimensionPixelSize2 = resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.professional_histogram_margin_start);
        int dimensionPixelSize3 = resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.histogram_graph_view_width);
        int dimensionPixelSize4 = resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.histogram_graph_view_height);
        int i2 = dimensionPixelSize + i_renamed;
        if (this.mOrientation % 180 == 0) {
            com.oplus.camera.p_renamed.a_renamed aVar = this.A_renamed;
            aVar.f4923b = iT + i2;
            aVar.d_renamed = dimensionPixelSize2;
            aVar.e_renamed = this.mOrientation;
            return;
        }
        com.oplus.camera.p_renamed.a_renamed aVar2 = this.A_renamed;
        aVar2.f4923b = ((dimensionPixelSize3 - dimensionPixelSize4) / 2) + iT + i2;
        aVar2.d_renamed = ((dimensionPixelSize4 - dimensionPixelSize3) / 2) + dimensionPixelSize2;
        aVar2.e_renamed = (this.mOrientation + 180) % 360;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e_renamed(int i_renamed) throws android.content.res.Resources.NotFoundException {
        int dimensionPixelSize;
        com.oplus.camera.p_renamed.a_renamed aVar;
        int i2;
        com.oplus.camera.e_renamed.a_renamed("ProfessionalCapMode", "updateHistogramLayoutByAnim, offsetY: " + i_renamed);
        android.content.res.Resources resources = this.mActivity.getResources();
        int dimensionPixelSize2 = resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.histogram_graph_view_width);
        int dimensionPixelSize3 = resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.histogram_graph_view_height);
        if (this.A_renamed == null) {
            this.A_renamed = new com.oplus.camera.p_renamed.a_renamed();
            this.A_renamed.f4922a = 10;
        }
        com.oplus.camera.p_renamed.a_renamed aVar2 = this.A_renamed;
        if (com.oplus.camera.util.Util.u_renamed()) {
            com.oplus.camera.screen.b_renamed.a_renamed currentScreenMode = getCurrentScreenMode();
            if (currentScreenMode != null) {
                int iT = t_renamed();
                aVar = new com.oplus.camera.p_renamed.a_renamed();
                currentScreenMode.a_renamed(aVar, iT, this.mOrientation);
                dimensionPixelSize = aVar.d_renamed;
                i2 = aVar.f4923b;
            } else {
                dimensionPixelSize = 0;
                aVar = aVar2;
                i2 = 0;
            }
        } else {
            int dimensionPixelSize4 = resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.professional_histogram_margin_top);
            dimensionPixelSize = resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.professional_histogram_margin_start);
            aVar = aVar2;
            i2 = dimensionPixelSize4;
        }
        if (F_renamed() || com.oplus.camera.util.Util.u_renamed()) {
            int i3 = i2 + i_renamed;
            if (com.oplus.camera.util.Util.u_renamed()) {
                this.A_renamed.f4923b = i3;
            } else {
                com.oplus.camera.p_renamed.a_renamed aVar3 = this.A_renamed;
                aVar3.f4923b = this.ae_renamed + i3;
                if (this.H_renamed && i_renamed != 0) {
                    aVar3.f4923b += this.af_renamed;
                }
            }
            com.oplus.camera.p_renamed.a_renamed aVar4 = this.A_renamed;
            aVar4.d_renamed = dimensionPixelSize;
            aVar4.e_renamed = aVar.e_renamed;
            return;
        }
        if (90 == this.mOrientation) {
            dimensionPixelSize += i_renamed;
        }
        com.oplus.camera.p_renamed.a_renamed aVar5 = this.A_renamed;
        aVar5.f4923b = ((dimensionPixelSize2 - dimensionPixelSize3) / 2) + this.ae_renamed + i2;
        aVar5.d_renamed = ((dimensionPixelSize3 - dimensionPixelSize2) / 2) + dimensionPixelSize;
        aVar5.e_renamed = (this.mOrientation + 180) % 360;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b_renamed(boolean z_renamed, boolean z2) throws android.content.res.Resources.NotFoundException {
        a_renamed(z_renamed, z2, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a_renamed(boolean z_renamed, boolean z2, boolean z3) throws android.content.res.Resources.NotFoundException {
        boolean Z_renamed;
        if (this.mPreferences == null || this.z_renamed == null || !getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_PRO_HISTOGRAM) || (Z_renamed = Z_renamed()) == this.z_renamed.b_renamed()) {
            return;
        }
        if (this.ab_renamed != 0 && !z3) {
            this.ab_renamed = 0;
            e_renamed(0);
        } else if (z3) {
            e_renamed(this.ab_renamed);
        }
        com.oplus.camera.professional.u_renamed.a_renamed aVar = new com.oplus.camera.professional.u_renamed.a_renamed();
        aVar.f5239a = Z_renamed;
        if (z_renamed) {
            aVar.f5240b = Z_renamed ? 250 : 0;
            aVar.f5241c = 250;
        } else if (z2) {
            int dimensionPixelSize = this.mActivity.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.professional_histogram_animation_offset);
            aVar.f5241c = Z_renamed ? 500 : 250;
            aVar.g_renamed = 500;
            aVar.d_renamed = Z_renamed ? dimensionPixelSize : 0.0f;
            aVar.e_renamed = Z_renamed ? 0.0f : dimensionPixelSize;
        }
        aVar.h_renamed = e_renamed() ? "translationX" : "translationY";
        if (Z_renamed) {
            this.z_renamed.a_renamed(aVar);
        } else {
            this.z_renamed.b_renamed(aVar);
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onYuvDataReceviced(byte[] bArr) {
        if (this.z_renamed == null || !isHistogramOpen()) {
            return;
        }
        this.z_renamed.a_renamed(bArr);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void onTopSubMenuExpand() {
        if (this.w_renamed.isSelected()) {
            this.mCameraInterface.a_renamed(true, true);
            this.mCameraInterface.d_renamed(true);
            com.oplus.camera.professional.u_renamed.a_renamed aVar = new com.oplus.camera.professional.u_renamed.a_renamed();
            aVar.f5239a = false;
            aVar.f5241c = 250;
            aVar.g_renamed = 400;
            aVar.d_renamed = 0.0f;
            aVar.e_renamed = this.mActivity.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.main_mode_bar_item_animation_offset);
            this.x_renamed.setAllPopupInvisibility(aVar);
            this.w_renamed.a_renamed();
            this.mOneCamera.j_renamed(true);
        } else {
            super.onTopSubMenuExpand();
        }
        if (4 == f_renamed()) {
            this.w_renamed.setVisibilityWithAnimation(8);
            b_renamed(8, true);
        } else if (1 == f_renamed()) {
            this.w_renamed.setVisibilityWithAnimation(8);
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void onTopSubMenuCollapse() {
        super.onTopSubMenuCollapse();
        if (4 == f_renamed()) {
            if (!this.mCameraUIInterface.aw_renamed()) {
                this.w_renamed.setVisibilityWithAnimation(0);
            }
            b_renamed(0, true);
        } else if (1 == f_renamed()) {
            this.w_renamed.setVisibilityWithAnimation(0);
            com.oplus.camera.screen.b_renamed.a_renamed currentScreenMode = getCurrentScreenMode();
            if (g_renamed() != 0 || currentScreenMode == null) {
                return;
            }
            this.C_renamed.setLayoutParams(currentScreenMode.e_renamed());
        }
    }

    public boolean e_renamed() {
        com.oplus.camera.screen.b_renamed.a_renamed currentScreenMode = getCurrentScreenMode();
        return currentScreenMode != null && currentScreenMode.l_renamed();
    }

    public int f_renamed() {
        com.oplus.camera.screen.b_renamed.a_renamed currentScreenMode = getCurrentScreenMode();
        if (currentScreenMode != null) {
            return currentScreenMode.j_renamed();
        }
        return 0;
    }

    public int g_renamed() {
        com.oplus.camera.screen.b_renamed.a_renamed currentScreenMode = getCurrentScreenMode();
        if (currentScreenMode != null) {
            return currentScreenMode.k_renamed();
        }
        return 0;
    }

    public int h_renamed() {
        return e_renamed() ? 1 : 0;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean getTouchEnable(boolean z_renamed, int i_renamed, int i2) throws android.content.res.Resources.NotFoundException {
        int dimensionPixelSize;
        int dimensionPixelSize2 = this.mActivity.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.exposure_indicator_width);
        com.oplus.camera.screen.b_renamed.a_renamed aVarAU = this.mCameraInterface != null ? this.mCameraInterface.aU_renamed() : null;
        if (1 == (aVarAU == null ? 0 : aVarAU.j_renamed())) {
            dimensionPixelSize = this.mActivity.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.fold_full_professional_params_item_image_margin_top);
        } else {
            dimensionPixelSize = this.mActivity.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.main_mode_bar_item_title_image_margin);
        }
        android.graphics.Rect rect = new android.graphics.Rect();
        this.w_renamed.getGlobalVisibleRect(rect);
        int i3 = dimensionPixelSize2 / 2;
        rect.left -= i3;
        rect.top -= i3 - dimensionPixelSize;
        rect.right += i3;
        rect.bottom += i3;
        android.graphics.Rect rect2 = new android.graphics.Rect();
        if (this.w_renamed.isSelected()) {
            this.x_renamed.getGlobalVisibleRect(rect2);
            rect2.left -= i3;
            rect2.top -= i3;
            rect2.right += i3;
            rect2.bottom += i3;
        }
        return (!z_renamed || rect.contains(i_renamed, i2) || rect2.contains(i_renamed, i2)) ? false : true;
    }
}

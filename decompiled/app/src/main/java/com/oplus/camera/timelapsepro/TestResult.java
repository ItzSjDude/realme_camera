package com.oplus.camera.timelapsepro;

/* compiled from: TimeLapseProMode.java */
/* loaded from: classes2.dex */
public class h_renamed extends com.oplus.camera.capmode.BaseMode implements com.oplus.camera.timelapsepro.g_renamed.d_renamed, com.oplus.camera.timelapsepro.g_renamed.f_renamed {
    private long A_renamed;
    private boolean B_renamed;
    private com.oplus.camera.e_renamed.c_renamed C_renamed;
    private com.oplus.camera.aps.util.CameraApsDecision D_renamed;
    private com.oplus.camera.e_renamed.d_renamed.a_renamed E_renamed;
    private int F_renamed;
    private boolean G_renamed;
    private int H_renamed;
    private int I_renamed;
    private com.oplus.camera.timelapsepro.g_renamed J_renamed;
    private boolean K_renamed;
    private boolean L_renamed;
    private boolean M_renamed;
    private long N_renamed;
    private long O_renamed;
    private long P_renamed;
    private long Q_renamed;
    private java.util.List<com.oplus.camera.timelapsepro.a_renamed.e_renamed> R_renamed;
    private boolean S_renamed;
    private boolean T_renamed;
    private android.os.Handler U_renamed;
    private android.os.Handler V_renamed;
    private android.widget.RelativeLayout W_renamed;
    private android.widget.ImageView X_renamed;
    private boolean Y_renamed;
    private android.renderscript.RenderScript Z_renamed;
    private java.lang.String aA_renamed;
    private boolean aB_renamed;
    private java.util.Map<java.lang.String, com.oplus.camera.statistics.model.TimeLapseProMsgData> aC_renamed;
    private com.oplus.camera.timelapsepro.g_renamed.e_renamed aD_renamed;
    private final android.view.View.OnClickListener aE_renamed;
    private boolean aF_renamed;
    private android.renderscript.ScriptIntrinsicYuvToRGB aa_renamed;
    private android.renderscript.Type.Builder ab_renamed;
    private android.renderscript.Type.Builder ac_renamed;
    private int ad_renamed;
    private int ae_renamed;
    private long af_renamed;
    private long ag_renamed;
    private java.lang.String ah_renamed;
    private float ai_renamed;
    private boolean aj_renamed;
    private com.oplus.camera.ui.inverse.InverseTextView ak_renamed;
    private android.graphics.Bitmap al_renamed;
    private android.graphics.Bitmap am_renamed;
    private com.oplus.camera.jni.FormatConverter an_renamed;
    private android.widget.RelativeLayout.LayoutParams ao_renamed;
    private android.widget.RelativeLayout.LayoutParams ap_renamed;
    private boolean aq_renamed;
    private boolean ar_renamed;
    private boolean as_renamed;
    private boolean at_renamed;
    private boolean au_renamed;
    private boolean av_renamed;
    private float aw_renamed;
    private java.lang.String ax_renamed;
    private java.lang.String ay_renamed;
    private java.lang.String az_renamed;
    protected boolean g_renamed;
    private final android.os.ConditionVariable h_renamed;
    private java.lang.String i_renamed;
    private long j_renamed;
    private long k_renamed;
    private long l_renamed;
    private com.oplus.camera.timelapsepro.c_renamed m_renamed;
    private boolean n_renamed;
    private boolean o_renamed;
    private int p_renamed;
    private int q_renamed;
    private long r_renamed;
    private android.os.Handler s_renamed;
    private int t_renamed;
    private boolean u_renamed;
    private java.lang.Object v_renamed;
    private int w_renamed;
    private int x_renamed;
    private volatile int y_renamed;
    private volatile int z_renamed;

    private void O_renamed() {
    }

    private void P_renamed() {
    }

    private void Q_renamed() {
    }

    private java.lang.String e_renamed(int i_renamed) {
        return i_renamed != 0 ? i_renamed != 1 ? i_renamed != 2 ? "RECORD_STOPPING" : "RECORD_STOPPED" : "RECORD_STARTING" : "RECORD_STARTED";
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected boolean canShowResumeButton() {
        return false;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public java.lang.String getCameraMode() {
        return com.oplus.camera.aps.constant.ApsConstant.REC_MODE_TIMELASPE_PRO;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public int getDefaultCaptureNumber() {
        return 1;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean getFrontEnable() {
        return true;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public java.lang.String getHeicCodecFormat() {
        return null;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public int getImageFormat() {
        return 35;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public int getOperatingMode() {
        return 32936;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void hideViewWhileResume() {
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean isSubMenuEnable() {
        return false;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean needStoreImage() {
        return false;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onShareMenuExpand() {
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void onStop() {
    }

    public h_renamed(android.app.Activity activity, com.oplus.camera.capmode.a_renamed aVar, com.oplus.camera.ui.CameraUIInterface cameraUIInterface, com.oplus.camera.ui.preview.a_renamed.t_renamed tVar) {
        super(activity, aVar, cameraUIInterface, tVar);
        this.h_renamed = new android.os.ConditionVariable();
        this.i_renamed = "15";
        this.j_renamed = 0L;
        this.k_renamed = 0L;
        this.l_renamed = 14400000L;
        this.g_renamed = false;
        this.m_renamed = null;
        this.n_renamed = false;
        this.o_renamed = false;
        this.p_renamed = 0;
        this.q_renamed = 0;
        this.r_renamed = 0L;
        this.s_renamed = null;
        this.t_renamed = -1;
        this.u_renamed = false;
        this.v_renamed = new java.lang.Object();
        this.w_renamed = 0;
        this.x_renamed = 0;
        this.y_renamed = 0;
        this.z_renamed = 2;
        this.A_renamed = 0L;
        this.B_renamed = false;
        this.C_renamed = null;
        this.D_renamed = null;
        this.E_renamed = null;
        this.F_renamed = 0;
        this.G_renamed = true;
        this.H_renamed = 0;
        this.I_renamed = 0;
        this.J_renamed = null;
        this.K_renamed = false;
        this.L_renamed = false;
        this.M_renamed = false;
        this.N_renamed = 0L;
        this.O_renamed = 0L;
        this.P_renamed = 0L;
        this.Q_renamed = 0L;
        this.R_renamed = new java.util.ArrayList();
        this.S_renamed = false;
        this.T_renamed = false;
        this.U_renamed = null;
        this.V_renamed = null;
        this.W_renamed = null;
        this.X_renamed = null;
        this.Y_renamed = false;
        this.ad_renamed = 0;
        this.ae_renamed = 0;
        this.af_renamed = 0L;
        this.ag_renamed = 0L;
        this.ai_renamed = -1.0f;
        this.aj_renamed = false;
        this.al_renamed = null;
        this.am_renamed = null;
        this.an_renamed = null;
        this.ao_renamed = null;
        this.ap_renamed = null;
        this.aq_renamed = false;
        this.ar_renamed = false;
        this.as_renamed = true;
        this.at_renamed = false;
        this.au_renamed = false;
        this.av_renamed = false;
        this.aw_renamed = 0.0f;
        this.ax_renamed = "";
        this.ay_renamed = "";
        this.az_renamed = "";
        this.aA_renamed = "";
        this.aB_renamed = true;
        this.aC_renamed = new java.util.HashMap();
        this.aD_renamed = new com.oplus.camera.timelapsepro.g_renamed.e_renamed() { // from class: com.oplus.camera.timelapsepro.h_renamed.1
            @Override // com.oplus.camera.timelapsepro.g_renamed.e_renamed
            public void a_renamed(java.lang.String str, java.lang.String str2) {
            }

            @Override // com.oplus.camera.timelapsepro.g_renamed.e_renamed
            public void a_renamed(int i_renamed) {
                if (com.oplus.camera.timelapsepro.h_renamed.this.s_renamed == null) {
                    return;
                }
                android.os.Message messageObtain = android.os.Message.obtain();
                messageObtain.what = 107;
                messageObtain.arg1 = i_renamed;
                if (com.oplus.camera.timelapsepro.h_renamed.this.s_renamed.hasMessages(107)) {
                    com.oplus.camera.timelapsepro.h_renamed.this.s_renamed.removeMessages(107);
                }
                com.oplus.camera.timelapsepro.h_renamed.this.s_renamed.sendMessageDelayed(messageObtain, 33L);
            }

            @Override // com.oplus.camera.timelapsepro.g_renamed.e_renamed
            public void a_renamed(java.lang.String str) {
                com.oplus.camera.e_renamed.a_renamed("TimeLapseProMode", "onSpeedValueChanged, speed: " + str);
                com.oplus.camera.timelapsepro.h_renamed.this.d_renamed(str);
            }

            @Override // com.oplus.camera.timelapsepro.g_renamed.e_renamed
            public void a_renamed(long j_renamed) {
                com.oplus.camera.timelapsepro.h_renamed.this.k_renamed = j_renamed;
                if (j_renamed == 0) {
                    com.oplus.camera.timelapsepro.h_renamed.this.l_renamed = 14400000L;
                } else {
                    com.oplus.camera.timelapsepro.h_renamed hVar = com.oplus.camera.timelapsepro.h_renamed.this;
                    hVar.l_renamed = hVar.k_renamed * ((java.lang.Long.parseLong(com.oplus.camera.timelapsepro.h_renamed.this.i_renamed) * 1000) / com.oplus.camera.timelapsepro.h_renamed.this.e_renamed().c_renamed());
                }
                com.oplus.camera.e_renamed.a_renamed("TimeLapseProMode", "onDurationValueChanged, frames: " + j_renamed + ", mDurationTime: " + com.oplus.camera.timelapsepro.h_renamed.this.l_renamed);
            }
        };
        this.aE_renamed = new android.view.View.OnClickListener() { // from class: com.oplus.camera.timelapsepro.h_renamed.2
            @Override // android.view.View.OnClickListener
            public void onClick(android.view.View view) {
                int id_renamed = view.getId();
                if (id_renamed == com.oplus.camera.R_renamed.id_renamed.time_lapse_pro_setting_button) {
                    com.oplus.camera.timelapsepro.h_renamed.this.b_renamed(com.oplus.camera.statistics.model.TimeLapseProMsgData.FUNC_KEY_ID_PARAMS, "1");
                    com.oplus.camera.timelapsepro.h_renamed.this.a_renamed(true, false, true, true, false);
                } else {
                    if (id_renamed != com.oplus.camera.R_renamed.id_renamed.time_lapse_pro_template_button) {
                        return;
                    }
                    com.oplus.camera.timelapsepro.h_renamed.this.b_renamed(com.oplus.camera.statistics.model.TimeLapseProMsgData.FUNC_KEY_ID_TEMPLATE, "1");
                    com.oplus.camera.timelapsepro.h_renamed.this.a_renamed(true, true, true, true, false);
                }
            }
        };
        this.aF_renamed = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.oplus.camera.timelapsepro.c_renamed e_renamed() {
        if (this.m_renamed == null) {
            this.m_renamed = new com.oplus.camera.timelapsepro.c_renamed(this.mActivity, this.mCameraInterface, this.mCameraUIInterface, this.mbDisplayOnLock);
            this.m_renamed.a_renamed(com.oplus.camera.g_renamed.b_renamed.b_renamed(getCameraMode(), this.mCameraId));
        }
        return this.m_renamed;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean canShowTimeLapseProButtons() {
        return !this.mbFrontCamera;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean isCaptureModeType() {
        return !isVideoRecording();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean getTouchEnable(boolean z_renamed, int i_renamed, int i2) {
        return this.I_renamed == 0 && !isVideoRecording();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean onSingleTapUp(android.view.MotionEvent motionEvent) {
        com.oplus.camera.e_renamed.a_renamed("TimeLapseProMode", "onSingleTapUp");
        com.oplus.camera.timelapsepro.g_renamed gVar = this.J_renamed;
        if (gVar != null && !gVar.n_renamed() && this.J_renamed.getVisibility() == 0) {
            c_renamed(this.J_renamed.c_renamed());
            return true;
        }
        a_renamed(motionEvent);
        return false;
    }

    private boolean f_renamed() {
        return getCurrentScreenMode() != null && 4 == getCurrentScreenMode().j_renamed();
    }

    private boolean g_renamed() {
        return getCurrentScreenMode() != null && 3 == getCurrentScreenMode().j_renamed();
    }

    private boolean h_renamed() {
        return getCurrentScreenMode() != null && 1 == getCurrentScreenMode().j_renamed();
    }

    private void c_renamed(boolean z_renamed) {
        a_renamed(false, z_renamed, true, true, false);
        this.mCameraUIInterface.Q_renamed(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a_renamed(boolean z_renamed, boolean z2, boolean z3, boolean z4, boolean z5) {
        com.oplus.camera.e_renamed.a_renamed("TimeLapseProMode", "showMenu, show: " + z_renamed + ", showTemplate: " + z2 + ", needAnim: " + z3 + ", needTranslate: " + z4 + ", fromPause: " + z5);
        if (!f_renamed()) {
            a_renamed(!z_renamed, z3, z4);
            b_renamed(!z_renamed, z3, z4);
        }
        if (z2) {
            a_renamed(z_renamed, z3);
        } else {
            b_renamed(z_renamed, z3);
        }
        if (this.mCameraInterface == null || z5) {
            return;
        }
        if (z_renamed && !f_renamed()) {
            this.mCameraInterface.a_renamed((android.animation.AnimatorListenerAdapter) null, true, z4);
            return;
        }
        if (this.I_renamed != 2) {
            if (this.M_renamed) {
                this.mCameraInterface.aH_renamed();
                this.M_renamed = false;
            }
            this.mCameraInterface.a_renamed(true, z4);
            this.mCameraInterface.d_renamed(true);
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onMenuBackButtonClick() {
        if (this.I_renamed != 2) {
            if (this.M_renamed) {
                this.mCameraInterface.aH_renamed();
                this.M_renamed = false;
            }
            this.mCameraInterface.a_renamed(true, true);
            this.mCameraInterface.d_renamed(true);
        }
    }

    private void a_renamed(boolean z_renamed, boolean z2, boolean z3) {
        if (this.mCameraUIInterface != null) {
            if (z_renamed) {
                this.mCameraUIInterface.o_renamed(z2, z3);
            } else {
                this.mCameraUIInterface.p_renamed(z2, z3);
            }
        }
    }

    private void b_renamed(boolean z_renamed, boolean z2, boolean z3) {
        if (this.mCameraUIInterface != null) {
            if (z_renamed) {
                this.mCameraUIInterface.q_renamed(z2, z3);
            } else {
                this.mCameraUIInterface.r_renamed(z2, z3);
            }
        }
    }

    private void a_renamed(boolean z_renamed, boolean z2) {
        this.mCameraUIInterface.s_renamed(z_renamed, z2);
    }

    private void b_renamed(boolean z_renamed, boolean z2) {
        this.mCameraUIInterface.t_renamed(z_renamed, z2);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onMoreModeShown() {
        super.onMoreModeShown();
        a_renamed(false, false, false);
        b_renamed(false, false, false);
        this.mCameraUIInterface.O_renamed(true);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onMoreModeHidden(int i_renamed) {
        super.onMoreModeHidden(i_renamed);
        if (!this.mbFrontCamera) {
            a_renamed(true, false, false);
            b_renamed(true, false, false);
        }
        this.mCameraUIInterface.N_renamed(true);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean onLongPress(android.view.MotionEvent motionEvent) {
        com.oplus.camera.e_renamed.a_renamed("TimeLapseProMode", "onLongPress");
        a_renamed(motionEvent);
        return false;
    }

    private void a_renamed(android.view.MotionEvent motionEvent) {
        android.graphics.Rect rect = new android.graphics.Rect();
        this.mCameraUIInterface.p_renamed().getHitRect(rect);
        if (rect.contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY())) {
            if (1 == getDefaultAFMode() || 4 == getDefaultAFMode()) {
                N_renamed();
            }
        }
    }

    private void i_renamed() {
        com.oplus.camera.e_renamed.a_renamed("TimeLapseProMode", "calCarTemplateExposure, iso : " + this.ad_renamed + ", exposure : " + this.af_renamed);
        long j_renamed = ((long) this.ad_renamed) * this.af_renamed;
        if (j_renamed >= 1300000000) {
            this.ae_renamed = (int) (j_renamed / 1300000000);
            this.ag_renamed = 1300000000L;
        } else if (j_renamed >= com.google.android.exoplayer2.C_renamed.NANOS_PER_SECOND) {
            this.ae_renamed = (int) (j_renamed / com.google.android.exoplayer2.C_renamed.NANOS_PER_SECOND);
            this.ag_renamed = com.google.android.exoplayer2.C_renamed.NANOS_PER_SECOND;
        } else {
            this.ae_renamed = (int) (j_renamed / 500000000);
            this.ag_renamed = 500000000L;
        }
        com.oplus.camera.e_renamed.a_renamed("TimeLapseProMode", "calCarTemplateExposure, snapIso : " + this.ae_renamed + ", snapExposure : " + this.ag_renamed);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void burstCapture(int i_renamed, com.oplus.camera.e_renamed.c_renamed cVar, com.oplus.camera.e_renamed.d_renamed.a_renamed aVar) throws java.lang.NumberFormatException {
        if (this.mbPaused || this.mbDestroyed) {
            return;
        }
        this.aq_renamed = cVar.M_renamed;
        if (this.x_renamed == 0) {
            synchronized (this.mApsDecisionResultLock) {
                this.D_renamed = this.mDecisionResult;
            }
        }
        if (!needDelayCloseForCapture() && this.as_renamed) {
            com.oplus.camera.e_renamed.a_renamed("TimeLapseProMode", "burstCapture, catch preview " + this.af_renamed);
            this.as_renamed = false;
            this.s_renamed.sendEmptyMessage(108);
        }
        if (!this.mbFrontCamera) {
            if (this.I_renamed != 0 && !this.R_renamed.isEmpty()) {
                b_renamed(this.R_renamed.get(4).j_renamed().get(this.R_renamed.get(4).k_renamed().indexOf("0.96")));
            }
            if (1 == this.I_renamed) {
                i_renamed();
                int i2 = this.ae_renamed;
                if (i2 > 0) {
                    b_renamed(java.lang.String.valueOf(i2), false);
                }
                long j_renamed = this.ag_renamed;
                if (j_renamed > 0) {
                    c_renamed(java.lang.String.valueOf(j_renamed), false);
                }
            }
        }
        if (this.o_renamed) {
            cVar.af_renamed = this.B_renamed ? -1 : this.x_renamed + 1;
            this.mCameraUIInterface.a_renamed(true, false);
        }
        if (this.N_renamed == 0) {
            this.N_renamed = java.lang.System.currentTimeMillis();
        }
        cVar.ae_renamed = true;
        cVar.z_renamed = 17;
        super.burstCapture(i_renamed, cVar, aVar);
        if (!this.o_renamed) {
            C_renamed();
        }
        this.w_renamed = i_renamed;
        this.C_renamed = super.getCaptureRequestTag(this.D_renamed, false);
        this.E_renamed = aVar;
        this.mCaptureStartedCallbackNum = 0;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean onImageReceived(com.oplus.ocs.camera.CameraPictureCallback.CameraPictureImage cameraPictureImage) {
        if (cameraPictureImage == null || 17 != cameraPictureImage.getFormat()) {
            this.Y_renamed = false;
            return false;
        }
        if (cameraPictureImage.getImage() == null) {
            com.oplus.camera.e_renamed.f_renamed("TimeLapseProMode", "onImageReceived, image.getImage() is_renamed null");
            return false;
        }
        if (this.mCameraUIInterface != null) {
            this.ar_renamed = this.mCameraUIInterface.e_renamed();
        }
        if (isSloganOpen()) {
            this.aF_renamed = !this.aF_renamed;
        }
        com.oplus.camera.e_renamed.a_renamed("TimeLapseProMode", "onImageReceived, mReceivedYuvImageNum: " + this.y_renamed + ", image : " + cameraPictureImage.toString() + ", mbRearMirrorEnable: " + this.ar_renamed + ", mbSloganFlag: " + this.aF_renamed);
        this.Y_renamed = true;
        this.N_renamed = 0L;
        if (this.o_renamed && !this.aF_renamed) {
            this.x_renamed++;
            com.oplus.camera.e_renamed.a_renamed("TimeLapseProMode", "onImageReceived, mReceivedRawNum: " + this.x_renamed + ", num: " + t_renamed());
        }
        if (this.z_renamed == 0 && (u_renamed() || !this.o_renamed)) {
            synchronized (this.v_renamed) {
                this.y_renamed++;
            }
            com.oplus.camera.e_renamed.a_renamed("TimeLapseProMode", "onImageReceived, size: " + e_renamed().b_renamed() + ", length: " + cameraPictureImage.getImage().length + ", width: " + cameraPictureImage.getWidth() + ", height: " + cameraPictureImage.getHeight() + ", orientation: " + cameraPictureImage.getOrientation() + ", stride: " + cameraPictureImage.getStride() + ", scanLine: " + cameraPictureImage.getScanline() + ", mReceivedYuvNumber: " + this.y_renamed + ", mbShouldEncode: " + this.aB_renamed);
            if (this.aB_renamed) {
                a_renamed(cameraPictureImage);
            }
        }
        if (this.o_renamed && !this.aF_renamed) {
            C_renamed();
        }
        return true;
    }

    private void a_renamed(com.oplus.ocs.camera.CameraPictureCallback.CameraPictureImage cameraPictureImage) {
        long jNv21ToBitmapInit;
        int i_renamed;
        int i2;
        int i3;
        if (cameraPictureImage.getImage() == null || 17 != cameraPictureImage.getFormat()) {
            return;
        }
        int width = cameraPictureImage.getWidth();
        int height = cameraPictureImage.getHeight();
        int stride = cameraPictureImage.getStride();
        int scanline = cameraPictureImage.getScanline();
        int orientation = cameraPictureImage.getOrientation();
        byte[] image = cameraPictureImage.getImage();
        if (this.an_renamed == null) {
            this.an_renamed = new com.oplus.camera.jni.FormatConverter();
        }
        java.lang.String strValueOf = java.lang.String.valueOf(java.lang.System.currentTimeMillis());
        a_renamed(image, this.y_renamed, stride, scanline, orientation, strValueOf, "nv21");
        long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
        if (this.aq_renamed && this.mbFrontCamera) {
            com.oplus.camera.util.Util.a_renamed(image, width, height, stride, scanline);
            com.oplus.camera.e_renamed.a_renamed("TimeLapseProMode", "dealYuvByteData, mirror bitmap : " + (java.lang.System.currentTimeMillis() - jCurrentTimeMillis));
        }
        if (orientation == 0 || orientation == 180) {
            if (this.al_renamed == null) {
                this.al_renamed = com.oplus.camera.util.Util.a_renamed(height, width, android.graphics.Bitmap.Config.ARGB_8888);
            }
            if (this.am_renamed == null) {
                this.am_renamed = com.oplus.camera.util.Util.a_renamed(height, width, android.graphics.Bitmap.Config.ARGB_8888);
            }
            if (!this.ar_renamed) {
                jNv21ToBitmapInit = this.an_renamed.nv21ToBitmapInit(width, height, stride, scanline, stride, height, width, 1.0f, 1, orientation == 0 ? 1 : 3, 0, 0, 2);
            } else {
                jNv21ToBitmapInit = this.an_renamed.nv21ToBitmapInit(width, height, stride, scanline, stride, height, width, 1.0f, 1, 180 == orientation ? 1 : 3, 0, 0, 2);
            }
            long j_renamed = jNv21ToBitmapInit;
            i_renamed = width;
            i2 = height;
            i3 = orientation;
            this.an_renamed.nv21ToBitmapProcess(j_renamed, image, 0, (isSloganOpen() && this.aF_renamed) ? this.am_renamed : this.al_renamed, i2);
            this.an_renamed.nv21ToBitmapUnInit(j_renamed);
        } else {
            if (this.al_renamed == null) {
                this.al_renamed = com.oplus.camera.util.Util.a_renamed(width, height, android.graphics.Bitmap.Config.ARGB_8888);
            }
            if (this.am_renamed == null) {
                this.am_renamed = com.oplus.camera.util.Util.a_renamed(width, height, android.graphics.Bitmap.Config.ARGB_8888);
            }
            long jNv21ToBitmapInit2 = this.an_renamed.nv21ToBitmapInit(width, height, stride, scanline, stride, width, height, 1.0f, 1, (orientation != 90 ? !this.mbFrontCamera : this.mbFrontCamera) ? 2 : 0, 0, 0, 0);
            this.an_renamed.nv21ToBitmapProcess(jNv21ToBitmapInit2, image, 0, (isSloganOpen() && this.aF_renamed) ? this.am_renamed : this.al_renamed, width);
            this.an_renamed.nv21ToBitmapUnInit(jNv21ToBitmapInit2);
            i_renamed = width;
            i2 = height;
            i3 = orientation;
        }
        com.oplus.camera.e_renamed.a_renamed("TimeLapseProMode", "dealYuvByteData, bitmap : " + (java.lang.System.currentTimeMillis() - jCurrentTimeMillis));
        if (!isSloganOpen() || (isSloganOpen() && this.aF_renamed)) {
            long jCurrentTimeMillis2 = java.lang.System.currentTimeMillis();
            int i4 = i_renamed * i2;
            byte[] bArr = new byte[(i4 * 3) >> 1];
            byte[] bArr2 = new byte[i4];
            com.oplus.camera.jni.FormatConverter formatConverter = this.an_renamed;
            if (formatConverter != null) {
                formatConverter.argbToNv21((isSloganOpen() && this.aF_renamed) ? this.am_renamed : this.al_renamed, bArr, bArr2, 0, true);
                com.oplus.camera.util.Util.d_renamed(bArr, i_renamed, i2);
            }
            a_renamed(bArr, this.y_renamed, i_renamed, i2, i3, strValueOf, "nv12");
            e_renamed().a_renamed(bArr);
            com.oplus.camera.e_renamed.a_renamed("TimeLapseProMode", "dealYuvByteData, bitmap to nv12 : " + (java.lang.System.currentTimeMillis() - jCurrentTimeMillis2));
        }
        if (!isSloganOpen() || (isSloganOpen() && !this.aF_renamed)) {
            a_renamed(new java.lang.Runnable() { // from class: com.oplus.camera.timelapsepro.-$$Lambda$h_renamed$Z5imcVS7y4bZWt645ICpcDNgN_I
                @Override // java.lang.Runnable
                public final void run() {
                    this.f_renamed$0.aq_renamed();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void aq_renamed() {
        if (this.W_renamed == null && this.mActivity != null) {
            o_renamed();
        }
        android.widget.ImageView imageView = this.X_renamed;
        if (imageView != null) {
            imageView.setImageBitmap(this.al_renamed);
        }
    }

    private void a_renamed(byte[] bArr, int i_renamed, int i2, int i3, int i4, java.lang.String str, java.lang.String str2) {
        if (this.aj_renamed) {
            com.oplus.camera.util.Util.a_renamed(bArr, "capture_yuv", str + "_" + bArr.length + "_time_lapse_yuv_" + i_renamed + "_" + i2 + "_" + i3 + "_" + i4 + "_" + str2 + ".yuv");
        }
    }

    private void j_renamed() {
        android.os.Handler handler = this.U_renamed;
        if (handler != null) {
            handler.getLooper().quitSafely();
            this.U_renamed = null;
        }
    }

    private void k_renamed() {
        android.os.Handler handler = this.V_renamed;
        if (handler != null) {
            handler.getLooper().quitSafely();
            this.V_renamed = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l_renamed() throws android.content.res.Resources.NotFoundException {
        if (this.ak_renamed == null) {
            this.ak_renamed = new com.oplus.camera.ui.inverse.InverseTextView(this.mActivity);
            this.ak_renamed.setTextColor(this.mActivity.getResources().getColor(com.oplus.camera.R_renamed.color.camera_white));
            this.ak_renamed.setText(com.oplus.camera.R_renamed.string.camera_time_lapse_pro_shooting_hint);
            this.ak_renamed.setTextSize(1, 12.0f);
            this.ak_renamed.setGravity(17);
            com.oplus.camera.util.Util.a_renamed((android.widget.TextView) this.ak_renamed);
        }
        if (this.ap_renamed == null) {
            this.ap_renamed = new android.widget.RelativeLayout.LayoutParams(-2, this.mActivity.getResources().getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.time_lapse_pro_recording_shooting_hint_height));
        }
        m_renamed();
        com.oplus.camera.screen.ScreenRelativeLayout screenRelativeLayout = (com.oplus.camera.screen.ScreenRelativeLayout) this.mActivity.findViewById(com.oplus.camera.R_renamed.id_renamed.camera);
        if (this.ak_renamed.getParent() != null) {
            ((android.view.ViewGroup) this.ak_renamed.getParent()).removeView(this.ak_renamed);
        }
        screenRelativeLayout.addView(this.ak_renamed, this.ap_renamed);
    }

    private void m_renamed() throws android.content.res.Resources.NotFoundException {
        int dimensionPixelOffset;
        android.widget.RelativeLayout.LayoutParams layoutParams = this.ap_renamed;
        if (layoutParams != null) {
            layoutParams.addRule(14);
            com.oplus.camera.screen.b_renamed.a_renamed currentScreenMode = getCurrentScreenMode();
            if (currentScreenMode == null) {
                this.ap_renamed.topMargin = this.mActivity.getResources().getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.time_lapse_pro_recording_shooting_hint_margin_top);
                return;
            }
            int iJ = currentScreenMode.j_renamed();
            if (iJ == 1) {
                android.widget.RelativeLayout.LayoutParams layoutParams2 = this.ap_renamed;
                if (currentScreenMode.k_renamed() == 0) {
                    dimensionPixelOffset = this.mActivity.getResources().getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.time_lapse_pro_recording_shooting_hint_margin_top_full);
                } else {
                    dimensionPixelOffset = this.mActivity.getResources().getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.time_lapse_pro_recording_shooting_hint_margin_top_full_90);
                }
                layoutParams2.topMargin = dimensionPixelOffset;
                return;
            }
            if (iJ == 4) {
                this.ap_renamed.topMargin = this.mActivity.getResources().getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.time_lapse_pro_recording_shooting_hint_margin_top_rack);
            } else {
                this.ap_renamed.topMargin = this.mActivity.getResources().getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.time_lapse_pro_recording_shooting_hint_margin_top);
            }
        }
    }

    private void n_renamed() {
        if (this.ak_renamed != null) {
            ((com.oplus.camera.screen.ScreenRelativeLayout) this.mActivity.findViewById(com.oplus.camera.R_renamed.id_renamed.camera)).removeView(this.ak_renamed);
            this.ak_renamed = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o_renamed() {
        android.widget.RelativeLayout relativeLayout = (android.widget.RelativeLayout) this.mActivity.findViewById(com.oplus.camera.R_renamed.id_renamed.camera_root);
        this.W_renamed = new android.widget.RelativeLayout(this.mActivity);
        this.W_renamed.setLayoutDirection(0);
        this.W_renamed.setBackgroundColor(-16777216);
        this.X_renamed = new android.widget.ImageView(this.mActivity);
        this.X_renamed.setScaleType(android.widget.ImageView.ScaleType.FIT_CENTER);
        this.X_renamed.setBackgroundColor(-16777216);
        this.ao_renamed = new android.widget.RelativeLayout.LayoutParams(-2, -2);
        q_renamed();
        this.W_renamed.addView(this.X_renamed, this.ao_renamed);
        relativeLayout.addView(this.W_renamed, 1, new android.widget.RelativeLayout.LayoutParams(-1, -1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: p_renamed, reason: merged with bridge method [inline-methods] */
    public void ap_renamed() {
        if (this.W_renamed == null || this.X_renamed == null || getCurrentScreenMode() == null || this.ao_renamed == null) {
            return;
        }
        this.W_renamed.setVisibility(8);
        q_renamed();
        this.W_renamed.setVisibility(0);
    }

    private void q_renamed() {
        if (this.ao_renamed == null) {
            return;
        }
        android.graphics.Rect rectR = r_renamed();
        com.oplus.camera.e_renamed.a_renamed("TimeLapseProMode", "addPreview, rect : " + rectR + ", l_renamed: " + rectR.left + ", t_renamed: " + rectR.top + ", r_renamed: " + rectR.right + ", b_renamed: " + rectR.bottom);
        this.ao_renamed.width = rectR.width();
        this.ao_renamed.height = rectR.height();
        this.ao_renamed.topMargin = rectR.height() % 2 == 0 ? rectR.top : rectR.top - 1;
        android.widget.RelativeLayout.LayoutParams layoutParams = this.ao_renamed;
        layoutParams.leftMargin = 0;
        layoutParams.rightMargin = 0;
        if (this.mbFrontCamera && g_renamed()) {
            this.ao_renamed.rightMargin = rectR.width() - rectR.right;
        } else {
            this.ao_renamed.leftMargin = rectR.left;
        }
    }

    private android.graphics.Rect r_renamed() {
        android.util.Size sizeI = com.oplus.camera.util.Util.I_renamed();
        if (getCurrentScreenMode() != null) {
            return getCurrentScreenMode().b_renamed(sizeI.getHeight(), sizeI.getWidth());
        }
        int screenWidth = com.oplus.camera.util.Util.getScreenWidth();
        int screenHeight = com.oplus.camera.util.Util.getScreenHeight();
        int iD = com.oplus.camera.util.Util.d_renamed(sizeI.getWidth(), sizeI.getHeight());
        float width = sizeI.getWidth() / sizeI.getHeight();
        if (7 == iD) {
            int iRound = java.lang.Math.round(screenHeight / width);
            int i_renamed = (screenWidth - iRound) / 2;
            return new android.graphics.Rect(i_renamed, 0, iRound + i_renamed, screenHeight);
        }
        int iRound2 = java.lang.Math.round(width * screenWidth);
        int iC = ((screenHeight - iRound2) / 2) + com.oplus.camera.screen.b_renamed.j_renamed.c_renamed(iD);
        return new android.graphics.Rect(0, iC, screenWidth, iRound2 + iC);
    }

    private void s_renamed() {
        com.oplus.camera.e_renamed.a_renamed("TimeLapseProMode", "removePreview.");
        if (this.Z_renamed != null) {
            this.Z_renamed = null;
        }
        if (this.aa_renamed != null) {
            this.aa_renamed = null;
        }
        if (this.ab_renamed != null) {
            this.ab_renamed = null;
        }
        if (this.ac_renamed != null) {
            this.ac_renamed = null;
        }
        android.graphics.Bitmap bitmap = this.al_renamed;
        if (bitmap != null) {
            bitmap.recycle();
            this.al_renamed = null;
        }
        android.graphics.Bitmap bitmap2 = this.am_renamed;
        if (bitmap2 != null) {
            bitmap2.recycle();
            this.am_renamed = null;
        }
        android.widget.RelativeLayout relativeLayout = this.W_renamed;
        if (relativeLayout != null) {
            android.widget.ImageView imageView = this.X_renamed;
            if (imageView != null) {
                relativeLayout.removeView(imageView);
                this.X_renamed = null;
            }
            ((android.widget.RelativeLayout) this.mActivity.findViewById(com.oplus.camera.R_renamed.id_renamed.camera_root)).removeView(this.W_renamed);
            this.W_renamed.setVisibility(8);
            this.W_renamed = null;
        }
    }

    private int t_renamed() {
        return super.getDefaultCaptureNumber();
    }

    private boolean u_renamed() {
        return this.x_renamed > t_renamed();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean needDelayCloseForCapture() {
        if (com.google.android.exoplayer2.C_renamed.NANOS_PER_SECOND <= java.lang.Long.parseLong(E_renamed()) || this.o_renamed || 1 == this.I_renamed) {
            return false;
        }
        return super.needDelayCloseForCapture();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected boolean isStarVideoOpen() {
        return this.o_renamed;
    }

    private void d_renamed(boolean z_renamed) {
        this.o_renamed = z_renamed;
        this.mOneCamera.g_renamed(z_renamed);
        this.mOneCamera.a_renamed((com.oplus.camera.e_renamed.d_renamed.c_renamed) null);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void onInitCameraMode() throws java.lang.NumberFormatException {
        com.oplus.camera.e_renamed.a_renamed("TimeLapseProMode", "onInitCameraMode, Start");
        b_renamed(2);
        this.J_renamed = this.mCameraUIInterface.aY_renamed();
        this.I_renamed = this.mPreferences.getInt("pref_time_lapse_pro_template_key", 0);
        this.au_renamed = this.I_renamed == 2;
        this.o_renamed = this.I_renamed == 2;
        this.av_renamed = false;
        com.oplus.camera.timelapsepro.g_renamed gVar = this.J_renamed;
        if (gVar != null) {
            gVar.setTimeLapseProMenuListener(this.aD_renamed);
            this.J_renamed.setChangeScreenModeListener(new com.oplus.camera.timelapsepro.g_renamed.c_renamed() { // from class: com.oplus.camera.timelapsepro.-$$Lambda$h_renamed$wpSx9MreC6R12QjfsCLm3q7-O5Q
                @Override // com.oplus.camera.timelapsepro.g_renamed.c_renamed
                public final void onChanged() {
                    this.f_renamed$0.ap_renamed();
                }
            });
            this.J_renamed.a_renamed(this);
            this.J_renamed.setReportCallback(this);
        }
        y_renamed();
        this.mCameraUIInterface.a_renamed(this.aE_renamed);
        int i_renamed = this.I_renamed;
        if (i_renamed == 1) {
            d_renamed(this.mActivity.getApplicationContext().getResources().getString(com.oplus.camera.R_renamed.string.time_lapse_pro_speed_60x));
        } else if (i_renamed == 3) {
            d_renamed(this.mActivity.getApplicationContext().getResources().getString(com.oplus.camera.R_renamed.string.time_lapse_pro_speed_150x));
        } else {
            d_renamed("15");
        }
        this.mCameraUIInterface.c_renamed(this.mActivity.getString(com.oplus.camera.R_renamed.string.camera_description_common_shutter_button));
    }

    private void v_renamed() {
        if (this.s_renamed == null) {
            com.oplus.camera.e_renamed.a_renamed("TimeLapseProMode", "initTimeLapseProHandler.");
            android.os.HandlerThread handlerThread = new android.os.HandlerThread("TimeLapseProHandler");
            handlerThread.start();
            this.s_renamed = new com.oplus.camera.timelapsepro.h_renamed.ParameterContainer_6(handlerThread.getLooper());
        }
    }

    /* compiled from: TimeLapseProMode.java */
    /* renamed from: com.oplus.camera.timelapsepro.h_renamed$3, reason: invalid class name */
    class ParameterContainer_6 extends android.os.Handler {
        ParameterContainer_6(android.os.Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(android.os.Message message) throws android.content.res.Resources.NotFoundException, java.lang.NumberFormatException {
            super.handleMessage(message);
            com.oplus.camera.e_renamed.a_renamed("TimeLapseProMode", "handleMessage, msg: " + message.what);
            switch (message.what) {
                case 100:
                    java.lang.Float.valueOf(0.0f);
                    java.lang.Float f_renamed = (java.lang.Float) message.obj;
                    com.oplus.camera.timelapsepro.h_renamed.this.mCameraInterface.ac_renamed();
                    if (com.oplus.camera.timelapsepro.h_renamed.this.mOneCamera != null) {
                        if (com.oplus.camera.timelapsepro.h_renamed.this.mCameraInterface.z_renamed()) {
                            com.oplus.camera.timelapsepro.h_renamed.this.mCameraInterface.b_renamed(false, false);
                        }
                        com.oplus.camera.timelapsepro.h_renamed.this.mOneCamera.a_renamed(f_renamed.floatValue(), true);
                        break;
                    }
                    break;
                case 101:
                    com.oplus.camera.timelapsepro.h_renamed.this.D_renamed();
                    break;
                case 103:
                    com.oplus.camera.timelapsepro.h_renamed.this.B_renamed();
                    break;
                case 104:
                    com.oplus.camera.timelapsepro.h_renamed.this.A_renamed();
                    break;
                case 105:
                    com.oplus.camera.timelapsepro.h_renamed.this.z_renamed();
                    break;
                case 106:
                    com.oplus.camera.timelapsepro.h_renamed.this.a_renamed(new java.lang.Runnable() { // from class: com.oplus.camera.timelapsepro.h_renamed.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.oplus.camera.timelapsepro.h_renamed.this.T_renamed();
                        }
                    });
                    break;
                case 107:
                    com.oplus.camera.timelapsepro.h_renamed.this.d_renamed(message.arg1);
                    break;
                case 108:
                    com.oplus.camera.timelapsepro.h_renamed.this.x_renamed();
                    break;
                case 109:
                    com.oplus.camera.timelapsepro.h_renamed.this.h_renamed.open();
                    break;
                case 110:
                    com.oplus.camera.timelapsepro.h_renamed.this.a_renamed(new java.lang.Runnable() { // from class: com.oplus.camera.timelapsepro.-$$Lambda$h_renamed$3$u8scrOcGy2nzi6-b1-OELjeJ9A8
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f_renamed$0.b_renamed();
                        }
                    });
                    break;
                case 111:
                    com.oplus.camera.timelapsepro.h_renamed.this.a_renamed(new java.lang.Runnable() { // from class: com.oplus.camera.timelapsepro.-$$Lambda$h_renamed$3$6dOaKlANKqe_f7ivlXruTMFLqWI
                        @Override // java.lang.Runnable
                        public final void run() throws android.content.res.Resources.NotFoundException {
                            this.f_renamed$0.a_renamed();
                        }
                    });
                    break;
                case 112:
                    com.oplus.camera.timelapsepro.h_renamed.this.mCameraUIInterface.a_renamed(com.oplus.camera.R_renamed.string.camera_time_lapse_pro_shooting_hint, -1, false, true, true);
                    break;
            }
            com.oplus.camera.e_renamed.a_renamed("TimeLapseProMode", "handleMessage X_renamed, msg: " + message.what);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b_renamed() {
            com.oplus.camera.timelapsepro.h_renamed.this.aj_renamed();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a_renamed() throws android.content.res.Resources.NotFoundException {
            com.oplus.camera.timelapsepro.h_renamed.this.l_renamed();
        }
    }

    private void w_renamed() {
        android.os.Handler handler = this.s_renamed;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.s_renamed.getLooper().quitSafely();
            this.s_renamed = null;
        }
    }

    /* compiled from: TimeLapseProMode.java */
    /* renamed from: com.oplus.camera.timelapsepro.h_renamed$4, reason: invalid class name */
    class DoubleExposureMode_3 extends com.oplus.camera.gl_renamed.t_renamed.b_renamed {
        DoubleExposureMode_3() {
        }

        @Override // com.oplus.camera.gl_renamed.t_renamed.b_renamed
        public void a_renamed(java.lang.Integer num, final android.graphics.Bitmap bitmap, long j_renamed, long j2, android.hardware.camera2.CaptureResult captureResult) {
            com.oplus.camera.e_renamed.a_renamed("TimeLapseProMode", "onPreviewCaptured, which: " + num);
            super.a_renamed(num, bitmap, j_renamed, j2, captureResult);
            com.oplus.camera.timelapsepro.h_renamed.this.a_renamed(new java.lang.Runnable() { // from class: com.oplus.camera.timelapsepro.-$$Lambda$h_renamed$4$gkSzpIWQAVEgNRsjg9J8pdvKl94
                @Override // java.lang.Runnable
                public final void run() {
                    this.f_renamed$0.b_renamed(bitmap);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b_renamed(android.graphics.Bitmap bitmap) {
            if (com.oplus.camera.timelapsepro.h_renamed.this.W_renamed == null) {
                com.oplus.camera.timelapsepro.h_renamed.this.o_renamed();
            }
            if (com.oplus.camera.timelapsepro.h_renamed.this.X_renamed != null) {
                com.oplus.camera.timelapsepro.h_renamed.this.X_renamed.setImageBitmap(bitmap);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x_renamed() {
        if (this.mCameraUIInterface != null) {
            this.mCameraUIInterface.a_renamed((com.oplus.camera.gl_renamed.t_renamed.b_renamed) new com.oplus.camera.timelapsepro.h_renamed.DoubleExposureMode_3(), false, false, com.oplus.camera.gl_renamed.t_renamed.b_renamed.f4672c);
        }
    }

    private void y_renamed() throws java.lang.NumberFormatException {
        if (!this.R_renamed.isEmpty()) {
            java.util.Iterator<com.oplus.camera.timelapsepro.a_renamed.e_renamed> it = this.R_renamed.iterator();
            while (it.hasNext()) {
                com.oplus.camera.e_renamed.a_renamed("TimeLapseProMode", "initProParams, proParameter: " + it.next().toString());
            }
            return;
        }
        com.oplus.camera.e_renamed.h_renamed cameraInfo = getCameraInfo(this.mCameraId);
        com.oplus.camera.timelapsepro.a_renamed.f_renamed fVar = new com.oplus.camera.timelapsepro.a_renamed.f_renamed(this.mActivity);
        com.oplus.camera.timelapsepro.a_renamed.d_renamed dVarA = a_renamed(cameraInfo);
        com.oplus.camera.timelapsepro.a_renamed.h_renamed hVarB = b_renamed(cameraInfo);
        com.oplus.camera.timelapsepro.a_renamed.b_renamed bVarC = c_renamed(cameraInfo);
        com.oplus.camera.timelapsepro.a_renamed.c_renamed cVarD = d_renamed(cameraInfo);
        com.oplus.camera.timelapsepro.a_renamed.l_renamed lVarE = e_renamed(cameraInfo);
        fVar.b_renamed(dVarA == null || !dVarA.g_renamed() || hVarB == null || !hVarB.g_renamed() || cVarD == null || !cVarD.g_renamed() || lVarE == null || !lVarE.g_renamed() || bVarC == null || !bVarC.d_renamed().equals(this.mActivity.getResources().getString(com.oplus.camera.R_renamed.string.camera_exposure_compensation_default_value)));
        this.R_renamed.add(fVar);
        this.R_renamed.add(dVarA);
        this.R_renamed.add(hVarB);
        this.R_renamed.add(bVarC);
        this.R_renamed.add(cVarD);
        this.R_renamed.add(lVarE);
        com.oplus.camera.timelapsepro.g_renamed gVar = this.J_renamed;
        if (gVar != null) {
            gVar.setProParameterList(this.R_renamed);
        }
    }

    private com.oplus.camera.timelapsepro.a_renamed.d_renamed a_renamed(com.oplus.camera.e_renamed.h_renamed hVar) {
        int iW = hVar.w_renamed();
        int iU = hVar.u_renamed();
        int iV = hVar.v_renamed();
        if (iV <= iU) {
            iV = iU;
        }
        if (iV <= 0 || iW <= 0 || iW == iV) {
            return null;
        }
        com.oplus.camera.timelapsepro.a_renamed.d_renamed dVar = new com.oplus.camera.timelapsepro.a_renamed.d_renamed(this.mActivity);
        java.util.List<java.lang.String> listJ = dVar.j_renamed();
        java.util.List<java.lang.String> listK = dVar.k_renamed();
        while (iW <= iV) {
            listJ.add(java.lang.Integer.toString(iW));
            listK.add(java.lang.Integer.toString(iW));
            iW += 100;
        }
        int i_renamed = this.mPreferences.getInt("pref_time_lapse_pro_index_of_iso_key", -1);
        if (i_renamed != -1) {
            dVar.a_renamed(false);
            dVar.a_renamed(i_renamed);
        }
        com.oplus.camera.e_renamed.a_renamed("TimeLapseProMode", "generateISOValues, param isoParameter: " + dVar.toString());
        return dVar;
    }

    private com.oplus.camera.timelapsepro.a_renamed.h_renamed b_renamed(com.oplus.camera.e_renamed.h_renamed hVar) throws java.lang.NumberFormatException {
        double d_renamed;
        com.oplus.camera.timelapsepro.a_renamed.h_renamed hVar2 = new com.oplus.camera.timelapsepro.a_renamed.h_renamed(this.mActivity);
        long jY = hVar.y_renamed();
        long jX = hVar.x_renamed();
        java.util.List<android.util.Size> listA = hVar.a_renamed(256);
        java.util.List<java.lang.String> listJ = hVar2.j_renamed();
        java.util.List<java.lang.String> listK = hVar2.k_renamed();
        if (listK != null && listK.size() > 0 && listJ != null && listJ.size() > 0 && java.lang.Math.abs(1.0f - (a_renamed(listA) / java.lang.Long.valueOf(com.oplus.camera.capmode.BaseMode.PICTURE_SIZE_8M).longValue())) <= 0.1f) {
            listK.remove(listK.size() - 1);
            listJ.remove(listJ.size() - 1);
        }
        if (listK != null && listJ != null) {
            java.util.Iterator<java.lang.String> it = listK.iterator();
            long j_renamed = -1;
            while (it.hasNext()) {
                java.lang.String[] strArrSplit = it.next().split("/");
                if (strArrSplit.length > 1) {
                    d_renamed = java.lang.Double.parseDouble(strArrSplit[0]) / java.lang.Double.parseDouble(strArrSplit[1].split("s_renamed")[0]);
                } else {
                    if (strArrSplit.length == 1) {
                        d_renamed = java.lang.Double.parseDouble(strArrSplit[0].split("s_renamed")[0]);
                    }
                    if (j_renamed >= jY || j_renamed > jX) {
                        it.remove();
                    } else {
                        listJ.add(java.lang.String.valueOf(j_renamed));
                    }
                }
                j_renamed = (long) (d_renamed * 1.0E9d);
                if (j_renamed >= jY) {
                }
                it.remove();
            }
            long j2 = java.lang.Long.parseLong(listJ.get(listJ.size() - 1)) / com.google.android.exoplayer2.C_renamed.NANOS_PER_SECOND;
            long j3 = jX / com.google.android.exoplayer2.C_renamed.NANOS_PER_SECOND;
            if (j2 < j3) {
                listJ.add(java.lang.String.valueOf(jX));
                listK.add(j3 + "s_renamed");
            }
        }
        int i_renamed = this.mPreferences.getInt("pref_time_lapse_pro_index_of_exposure_time_key", -1);
        if (i_renamed != -1) {
            hVar2.a_renamed(false);
            hVar2.a_renamed(i_renamed);
        }
        com.oplus.camera.e_renamed.a_renamed("TimeLapseProMode", "generateShutterParameter, param shutterParameter: " + hVar2.toString());
        return hVar2;
    }

    private long a_renamed(java.util.List<android.util.Size> list) {
        long width = 0;
        for (android.util.Size size : list) {
            if (size.getWidth() * size.getHeight() > width) {
                width = size.getWidth() * size.getHeight();
            }
        }
        com.oplus.camera.e_renamed.a_renamed("TimeLapseProMode", "getMaxPictureSize, max: " + width);
        return width;
    }

    private com.oplus.camera.timelapsepro.a_renamed.b_renamed c_renamed(com.oplus.camera.e_renamed.h_renamed hVar) {
        int iP = hVar.p_renamed();
        int iQ = hVar.q_renamed();
        float fR_renamed = hVar.r_renamed();
        if ((iP == -1 && iQ == -1) || iP > iQ || java.lang.Float.compare(fR_renamed, 0.0f) == 0) {
            com.oplus.camera.e_renamed.f_renamed("TimeLapseProMode", "generateExposureCompensationValues, return, minIndex: " + iP + ", maxIndex: " + iQ);
            return null;
        }
        com.oplus.camera.timelapsepro.a_renamed.b_renamed bVar = new com.oplus.camera.timelapsepro.a_renamed.b_renamed(this.mActivity);
        int size = 0;
        while (iP <= iQ) {
            bVar.j_renamed().add(java.lang.String.valueOf(iP));
            java.lang.String strA = a_renamed(iP, fR_renamed);
            if (strA.equals("0.00")) {
                size = bVar.j_renamed().size() - 1;
            }
            bVar.k_renamed().add(strA);
            iP++;
        }
        int i_renamed = this.mPreferences.getInt("pref_time_lapse_pro_index_of_exposure_compensation_key", size);
        com.oplus.camera.timelapsepro.e_renamed.f5680a = i_renamed;
        bVar.a_renamed(i_renamed);
        com.oplus.camera.e_renamed.a_renamed("TimeLapseProMode", "generateExposureParameter, param exposureParameter: " + bVar.toString());
        return bVar;
    }

    public java.lang.String a_renamed(int i_renamed, float f_renamed) {
        float f2 = i_renamed * f_renamed;
        if (f2 <= 0.0f) {
            return java.lang.String.format(java.util.Locale.US, "%.2f", java.lang.Float.valueOf(f2));
        }
        return "+" + java.lang.String.format(java.util.Locale.US, "%.2f", java.lang.Float.valueOf(f2));
    }

    private com.oplus.camera.timelapsepro.a_renamed.c_renamed d_renamed(com.oplus.camera.e_renamed.h_renamed hVar) {
        float fN_renamed = hVar.n_renamed();
        float fM_renamed = hVar.m_renamed();
        if (fN_renamed >= fM_renamed) {
            fN_renamed = fM_renamed;
            fM_renamed = fN_renamed;
        }
        if (java.lang.Float.compare(fM_renamed, 0.0f) <= 0.0f || java.lang.Float.compare(fM_renamed, fN_renamed) == 0) {
            com.oplus.camera.e_renamed.f_renamed("TimeLapseProMode", "generateFocusValues, return, minFocusDistance: " + fM_renamed);
            return null;
        }
        float f_renamed = (fM_renamed - fN_renamed) / 50.0f;
        com.oplus.camera.e_renamed.a_renamed("TimeLapseProMode", "generateFocusValues, farFocusDistance: " + fN_renamed + ", minFocusDistance: " + fM_renamed);
        com.oplus.camera.timelapsepro.a_renamed.c_renamed cVar = new com.oplus.camera.timelapsepro.a_renamed.c_renamed(this.mActivity);
        for (int i_renamed = 0; i_renamed <= 50; i_renamed++) {
            float f2 = i_renamed;
            cVar.j_renamed().add(java.lang.Float.toString(fM_renamed - (f_renamed * f2)));
            cVar.k_renamed().add(java.lang.String.format(java.util.Locale.US, "%.2f", java.lang.Float.valueOf(f2 * 0.02f)));
        }
        int i2 = this.mPreferences.getInt("pref_time_lapse_pro_index_of_focus_mode_key", -1);
        if (i2 != -1) {
            cVar.a_renamed(false);
            cVar.a_renamed(i2);
        }
        com.oplus.camera.e_renamed.a_renamed("TimeLapseProMode", "generateFocusParameter, param focusParameter: " + cVar.toString());
        return cVar;
    }

    private com.oplus.camera.timelapsepro.a_renamed.l_renamed e_renamed(com.oplus.camera.e_renamed.h_renamed hVar) {
        java.util.List<java.lang.Integer> listB = hVar.B_renamed();
        if (listB == null || listB.size() <= 0) {
            com.oplus.camera.e_renamed.f_renamed("TimeLapseProMode", "generateWhiteBalanceValues, return, range: " + listB);
            return null;
        }
        com.oplus.camera.timelapsepro.a_renamed.l_renamed lVar = new com.oplus.camera.timelapsepro.a_renamed.l_renamed(this.mActivity);
        for (int i_renamed = 0; i_renamed < listB.size(); i_renamed++) {
            int iIntValue = listB.get(i_renamed).intValue();
            lVar.j_renamed().add(java.lang.Integer.toString(iIntValue));
            lVar.k_renamed().add(iIntValue + com.oplus.exif.OplusExifInterface.GpsSpeedRef.KILOMETERS);
        }
        int i2 = this.mPreferences.getInt("pref_time_lapse_pro_index_of_whitebalance_key", -1);
        if (i2 != -1) {
            lVar.a_renamed(false);
            lVar.a_renamed(i2);
        }
        com.oplus.camera.e_renamed.a_renamed("TimeLapseProMode", "generateWhiteBalanceParameter, param whiteBalanceParameter: " + lVar.toString());
        return lVar;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onSessionConfigured() {
        android.os.Handler handler;
        super.onSessionConfigured();
        com.oplus.camera.e_renamed.a_renamed("TimeLapseProMode", "onSessionConfigured, mbHaveStopRecord: " + this.S_renamed);
        v_renamed();
        if (!this.mbFrontCamera && this.T_renamed) {
            this.T_renamed = false;
            a_renamed(new java.lang.Runnable() { // from class: com.oplus.camera.timelapsepro.-$$Lambda$h_renamed$yYYb166yUrkeI7C0hNnTgPxTm-c_renamed
                @Override // java.lang.Runnable
                public final void run() {
                    this.f_renamed$0.ao_renamed();
                }
            });
        } else if (this.S_renamed && (handler = this.s_renamed) != null) {
            handler.sendEmptyMessageDelayed(106, 500L);
        }
        if (this.I_renamed != 0 && !this.R_renamed.isEmpty() && this.s_renamed != null) {
            b_renamed(this.R_renamed.get(4).j_renamed().get(this.R_renamed.get(4).k_renamed().indexOf("0.96")));
        }
        this.Y_renamed = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void ao_renamed() {
        a_renamed(true, true, false);
        b_renamed(true, true, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z_renamed() {
        a_renamed(new java.lang.Runnable() { // from class: com.oplus.camera.timelapsepro.-$$Lambda$h_renamed$_yh0yvHOmBmPyCFtQSzNbCyIz-Q_renamed
            @Override // java.lang.Runnable
            public final void run() {
                this.f_renamed$0.an_renamed();
            }
        });
        android.os.Handler handler = this.s_renamed;
        if (handler != null) {
            handler.sendEmptyMessageDelayed(105, 81L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void an_renamed() {
        long jCurrentTimeMillis = java.lang.System.currentTimeMillis() - this.A_renamed;
        this.P_renamed = jCurrentTimeMillis;
        if (this.k_renamed > 0) {
            long j_renamed = this.l_renamed - jCurrentTimeMillis;
            com.oplus.camera.e_renamed.a_renamed("TimeLapseProMode", "updateRecordingTime, recordTime: " + j_renamed);
            jCurrentTimeMillis = j_renamed < 0 ? 0L : j_renamed;
        }
        long j2 = jCurrentTimeMillis;
        this.O_renamed = j2;
        this.Q_renamed = ((isSloganOpen() ? this.y_renamed >> 1 : this.y_renamed) * 1000) / e_renamed().c_renamed();
        this.mCameraUIInterface.a_renamed(j2, this.Q_renamed, this.G_renamed);
        this.F_renamed++;
        this.F_renamed %= 6;
        if (this.F_renamed == 0) {
            this.G_renamed = !this.G_renamed;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A_renamed() throws android.content.res.Resources.NotFoundException {
        com.oplus.camera.e_renamed.a_renamed("TimeLapseProMode", "onStopRecordingMsg, Begin, mbPaused: " + this.mbPaused);
        android.os.Handler handler = this.s_renamed;
        if (handler != null) {
            handler.removeMessages(105);
            this.s_renamed.removeMessages(102);
            this.s_renamed.removeMessages(111);
            this.s_renamed.removeMessages(112);
        }
        b_renamed(3);
        if (!this.mbPaused) {
            this.mActivity.runOnUiThread(new java.lang.Runnable() { // from class: com.oplus.camera.timelapsepro.-$$Lambda$h_renamed$D_renamed-qXchdN3e1Ui40DgsuuY-etDps
                @Override // java.lang.Runnable
                public final void run() {
                    this.f_renamed$0.am_renamed();
                }
            });
            pictureTakenCallback(null, 0, 0, null, false, false, 0L, 0);
        }
        if (e_renamed().a_renamed(true)) {
            a_renamed(this.P_renamed, this.Q_renamed);
        }
        a_renamed(new java.lang.Runnable() { // from class: com.oplus.camera.timelapsepro.-$$Lambda$h_renamed$QGkaXZVl9eBYXOF5FsYnclyKk0k
            @Override // java.lang.Runnable
            public final void run() {
                this.f_renamed$0.al_renamed();
            }
        });
        this.x_renamed = 0;
        this.Q_renamed = 0L;
        this.as_renamed = true;
        b_renamed(2);
        android.os.Handler handler2 = this.s_renamed;
        if (handler2 != null) {
            handler2.sendEmptyMessageDelayed(109, 50L);
        } else {
            this.h_renamed.open();
        }
        com.oplus.camera.e_renamed.c_renamed("TimeLapseProMode", "onStopRecordingMsg, End");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void am_renamed() {
        if (this.mCameraInterface != null) {
            this.mCameraInterface.aJ_renamed();
            k_renamed(true);
            this.mCameraInterface.U_renamed();
        }
        n_renamed();
        if (this.I_renamed == 0) {
            this.mCameraUIInterface.a_renamed(com.oplus.camera.R_renamed.string.camera_time_lapse_pro_shooting_hint);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void al_renamed() {
        this.mCameraUIInterface.L_renamed();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B_renamed() {
        com.oplus.camera.e_renamed.c_renamed("TimeLapseProMode", "onStartRecordingMsg, Begin");
        if (!this.mbPaused && !this.mbDestroyed) {
            e_renamed().b_renamed(isStarVideoOpen());
            e_renamed().a_renamed();
            e_renamed().d_renamed(this.mbFrontCamera);
            v_renamed();
            android.os.Handler handler = this.s_renamed;
            if (handler != null) {
                handler.removeMessages(105);
                this.s_renamed.sendEmptyMessageDelayed(105, 81L);
                this.s_renamed.removeMessages(102);
                this.s_renamed.sendEmptyMessageDelayed(102, 300000L);
            }
            this.O_renamed = 0L;
            b_renamed(0);
            if (this.mActivity != null) {
                this.mActivity.runOnUiThread(new java.lang.Runnable() { // from class: com.oplus.camera.timelapsepro.-$$Lambda$h_renamed$sQ-5hVbjJp12r9LYD-Y4gFSm3Gk
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f_renamed$0.ak_renamed();
                    }
                });
            }
        }
        com.oplus.camera.e_renamed.c_renamed("TimeLapseProMode", "onStartRecordingMsg, End");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void ak_renamed() {
        if (this.mCameraInterface != null) {
            this.mCameraInterface.e_renamed(false);
        }
    }

    private void C_renamed() {
        android.os.Handler handler;
        com.oplus.camera.e_renamed.c_renamed("TimeLapseProMode", "trySendRepeatBurstCaptureMessage, mbPaused: " + this.mbPaused + ", isVideoRecordStop(): " + K_renamed() + ", mbLastCaptureRequest: " + this.B_renamed + ", mDelayCap: " + this.j_renamed + ", mbStarVideoEnable: " + this.o_renamed);
        if (!this.mbPaused && !K_renamed() && !this.B_renamed && (handler = this.s_renamed) != null) {
            if (!this.o_renamed) {
                if (this.k_renamed > 0) {
                    if (this.y_renamed >= (isSloganOpen() ? (this.k_renamed - 1) * 2 : this.k_renamed - 1)) {
                        this.s_renamed.sendEmptyMessageDelayed(110, this.mbFrontCamera ? 500L : this.j_renamed);
                        return;
                    }
                }
                this.s_renamed.sendEmptyMessageDelayed(101, this.mbFrontCamera ? 500L : this.j_renamed);
                return;
            }
            handler.sendEmptyMessage(101);
            return;
        }
        a_renamed(new java.lang.Runnable() { // from class: com.oplus.camera.timelapsepro.-$$Lambda$h_renamed$2_omIdGNUHJS42LA31tr9SDdbHo
            @Override // java.lang.Runnable
            public final void run() {
                this.f_renamed$0.aj_renamed();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D_renamed() throws java.lang.NumberFormatException {
        int i_renamed = this.p_renamed;
        if (i_renamed > 0) {
            c_renamed(i_renamed);
        }
        com.oplus.camera.e_renamed.c_renamed cVar = this.C_renamed;
        if (cVar != null) {
            burstCapture(this.w_renamed, cVar, this.E_renamed);
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public com.oplus.camera.ui.control.b_renamed getShutterButtonInfo() {
        com.oplus.camera.ui.control.b_renamed shutterButtonInfo = super.getShutterButtonInfo();
        if (isVideoRecording()) {
            shutterButtonInfo.a_renamed(5);
            shutterButtonInfo.a_renamed("button_color_inside_none");
            shutterButtonInfo.b_renamed(1);
        } else {
            shutterButtonInfo.a_renamed("button_color_inside_red");
        }
        shutterButtonInfo.c_renamed("button_shape_dial_rotate");
        return shutterButtonInfo;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public android.util.Size getPictureSize(com.oplus.camera.e_renamed.h_renamed hVar) {
        if (e_renamed() != null) {
            return e_renamed().b_renamed();
        }
        return super.getPictureSize(hVar);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean needSurface(java.lang.String str) {
        if ("type_still_capture_jpeg".equals(str)) {
            return !com.oplus.camera.aps.util.AlgoSwitchConfig.getSupportApsCapture();
        }
        if ("type_reprocess_data_yuv".equals(str)) {
            return com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_SURPERNIGHT_REPROCESS_EXTRA_YUV) && !this.mbFrontCamera;
        }
        if ("type_video".equals(str)) {
            return true;
        }
        if ("type_video_frame".equals(str)) {
            return getSupportFunction(com.oplus.camera.ui.CameraUIInterface.PRE_KEY_WATERMARK_VISUAL_FUNCTION) && isSloganOpen();
        }
        if ("type_capture".equals(str)) {
            return true;
        }
        return super.needSurface(str);
    }

    @Override // com.oplus.camera.capmode.BaseMode, com.oplus.camera.e_renamed.d_renamed.a_renamed
    public void onCaptureCompleted(com.oplus.camera.aps.service.CameraCaptureResult cameraCaptureResult, com.oplus.camera.e_renamed.c_renamed cVar) throws java.lang.NumberFormatException {
        java.lang.Object obj;
        if (com.oplus.camera.util.Util.C_renamed()) {
            obj = com.oplus.camera.e_renamed.b_renamed.U_renamed;
        } else {
            obj = com.oplus.camera.e_renamed.b_renamed.W_renamed;
        }
        this.aw_renamed = ((float[]) cameraCaptureResult.getCaptureResult().get(obj))[0];
        com.oplus.camera.e_renamed.a_renamed("TimeLapseProMode", "onCaptureCompleted, luxKey: " + this.aw_renamed);
        if (this.o_renamed) {
            try {
                java.lang.Integer num = (java.lang.Integer) cameraCaptureResult.getCaptureResult().get(com.oplus.camera.e_renamed.b_renamed.bE_renamed);
                this.aB_renamed = num.intValue() == cVar.af_renamed - 1;
                com.oplus.camera.e_renamed.a_renamed("TimeLapseProMode", "onCaptureCompleted, resultFrameFlag: " + num + ", requestFrameFlag: " + cVar.af_renamed);
            } catch (java.lang.Exception unused) {
                com.oplus.camera.e_renamed.a_renamed("TimeLapseProMode", "onCaptureCompleted, do not have CameraMetadataKey.KEY_STAR_MODE_FRAME_FLAG");
            }
        }
        if (isVideoRecordStarted() && 1 == this.I_renamed && this.aw_renamed < 410.0f && !this.av_renamed) {
            this.av_renamed = true;
            this.mCameraUIInterface.a_renamed(com.oplus.camera.R_renamed.string.camera_time_lapse_pro_over_bright_hint, 5000, new java.lang.Object[0]);
        }
        if (this.mOneCamera != null && this.o_renamed) {
            this.mOneCamera.f_renamed(cVar.af_renamed);
        }
        if (this.mOneCamera != null && 1 == this.I_renamed) {
            b_renamed((java.lang.String) null, false);
            c_renamed(this.mActivity.getResources().getString(com.oplus.camera.R_renamed.string.camera_exposure_time_default_value), true);
        }
        super.onCaptureCompleted(cameraCaptureResult, cVar);
    }

    protected boolean c_renamed() {
        return com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_PROFESSIONAL_MUTEX_ZOOM_SUPPORT);
    }

    private java.lang.String E_renamed() {
        return this.mPreferences == null ? "-1" : this.mPreferences.getString("pref_time_lapse_pro_exposure_time_key", "-1");
    }

    private long F_renamed() {
        return java.lang.Long.parseLong(this.mPreferences.getString("pref_time_lapse_pro_exposure_time_key", this.mActivity.getResources().getString(com.oplus.camera.R_renamed.string.camera_exposure_time_default_value)));
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public int getCaptureIso() {
        java.lang.String string = this.mPreferences.getString("pref_time_lapse_pro_iso_key", this.mActivity.getResources().getString(com.oplus.camera.R_renamed.string.camera_iso_default_value));
        if (this.mActivity.getResources().getString(com.oplus.camera.R_renamed.string.camera_iso_default_value).equals(string)) {
            return this.q_renamed;
        }
        return java.lang.Integer.parseInt(string);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public long getCaptureExposureTime() throws java.lang.NumberFormatException {
        long j_renamed = java.lang.Long.parseLong(E_renamed());
        return -1 == j_renamed ? this.r_renamed : j_renamed;
    }

    /* JADX WARN: Removed duplicated region for block: B_renamed:31:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:41:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:62:0x011a  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:77:0x005a A_renamed[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B_renamed:81:? A_renamed[RETURN, SYNTHETIC] */
    @Override // com.oplus.camera.capmode.BaseMode
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onPreviewCaptureResult(com.oplus.ocs.camera.CameraPreviewCallback.CameraPreviewResult r9) {
        /*
            Method dump skipped, instructions count: 360
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.timelapsepro.h_renamed.onPreviewCaptureResult(com.oplus.ocs.camera.CameraPreviewCallback$CameraPreviewResult):void");
    }

    private int a_renamed(int i_renamed, java.util.List<java.lang.String> list) {
        if (list == null || list.size() <= 0) {
            return -1;
        }
        int iAbs = java.lang.Math.abs(java.lang.Integer.parseInt(list.get(0)) - i_renamed);
        int i2 = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            int i4 = java.lang.Integer.parseInt(list.get(i3)) - i_renamed;
            if (java.lang.Math.abs(i4) < iAbs) {
                iAbs = java.lang.Math.abs(i4);
                i2 = i3;
            }
        }
        return i2;
    }

    private int a_renamed(long j_renamed, java.util.List<java.lang.String> list) {
        if (list == null || list.size() <= 0) {
            return -1;
        }
        long jAbs = java.lang.Math.abs(java.lang.Long.parseLong(list.get(0)) - j_renamed);
        int i_renamed = 0;
        for (int i2 = 0; i2 < list.size(); i2++) {
            long j2 = java.lang.Long.parseLong(list.get(i2)) - j_renamed;
            if (java.lang.Math.abs(j2) < jAbs) {
                jAbs = java.lang.Math.abs(j2);
                i_renamed = i2;
            }
        }
        return i_renamed;
    }

    private int a_renamed(float f_renamed, java.util.List<java.lang.String> list) {
        if (list == null || list.size() <= 0) {
            return -1;
        }
        float fAbs = java.lang.Math.abs(java.lang.Float.parseFloat(list.get(0)) - f_renamed);
        int i_renamed = 0;
        for (int i2 = 0; i2 < list.size(); i2++) {
            float f2 = java.lang.Float.parseFloat(list.get(i2)) - f_renamed;
            if (java.lang.Math.abs(f2) < fAbs) {
                fAbs = java.lang.Math.abs(f2);
                i_renamed = i2;
            }
        }
        return i_renamed;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean isAutoFocus() {
        return android.text.TextUtils.equals(this.mPreferences.getString("pref_time_lapse_pro_focus_mode_key", this.mActivity.getString(com.oplus.camera.R_renamed.string.camera_focus_mode_default_value)), this.mActivity.getString(com.oplus.camera.R_renamed.string.camera_focus_mode_default_value));
    }

    /* JADX WARN: Can't_renamed fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B_renamed:71:0x0103  */
    @Override // com.oplus.camera.capmode.BaseMode
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean getSupportFunction(java.lang.String r6) {
        /*
            Method dump skipped, instructions count: 524
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.timelapsepro.h_renamed.getSupportFunction(java.lang.String):boolean");
    }

    private void G_renamed() throws android.content.res.Resources.NotFoundException, java.lang.NumberFormatException {
        if (this.mOneCamera != null) {
            java.lang.String string = this.mActivity.getApplicationContext().getResources().getString(com.oplus.camera.R_renamed.string.camera_whitebalance_default_value);
            if (this.mPreferences.getString("pref_time_lapse_pro_whitebalance_key", string).equals(string)) {
                b_renamed(false);
            } else {
                h_renamed(false);
            }
            b_renamed((java.lang.String) null);
            this.mOneCamera.a_renamed((android.hardware.camera2.CaptureRequest.Key<android.hardware.camera2.CaptureRequest.Key>) android.hardware.camera2.CaptureRequest.CONTROL_AE_EXPOSURE_COMPENSATION, (android.hardware.camera2.CaptureRequest.Key) java.lang.Integer.valueOf(d_renamed()));
            b_renamed((java.lang.String) null, false);
            i_renamed(false);
        }
        com.oplus.camera.timelapsepro.g_renamed gVar = this.J_renamed;
        if (gVar != null) {
            int i_renamed = this.I_renamed;
            if (i_renamed == 0) {
                java.lang.String strG = gVar.g_renamed();
                d_renamed(strG);
                this.J_renamed.a_renamed(strG);
            } else if (i_renamed == 1) {
                d_renamed(this.mActivity.getApplicationContext().getResources().getString(com.oplus.camera.R_renamed.string.time_lapse_pro_speed_60x));
            } else if (i_renamed == 3) {
                d_renamed(this.mActivity.getApplicationContext().getResources().getString(com.oplus.camera.R_renamed.string.time_lapse_pro_speed_150x));
            }
        }
    }

    private void e_renamed(boolean z_renamed) throws java.lang.NumberFormatException {
        f_renamed(z_renamed);
        this.mPreferences.edit().remove("pref_time_lapse_pro_template_key").apply();
        this.mPreferences.edit().remove("pref_time_lapse_pro_sub_setting_key").apply();
        this.mPreferences.edit().remove("pref_time_lapse_pro_speed_key").apply();
        this.mPreferences.edit().remove("pref_time_lapse_pro_duration_key").apply();
        this.mPreferences.edit().remove("pref_time_lapse_pro_iso_key").apply();
        this.mPreferences.edit().remove("pref_time_lapse_pro_exposure_time_key").apply();
        this.mPreferences.edit().remove("pref_time_lapse_pro_exposure_compensation_key").apply();
        this.mPreferences.edit().remove("pref_time_lapse_pro_focus_mode_key").apply();
        this.mPreferences.edit().remove("pref_time_lapse_pro_whitebalance_key").apply();
        this.mPreferences.edit().remove("pref_time_lapse_pro_index_of_iso_key").apply();
        this.mPreferences.edit().remove("pref_time_lapse_pro_index_of_exposure_time_key").apply();
        this.mPreferences.edit().remove("pref_time_lapse_pro_index_of_exposure_compensation_key").apply();
        this.mPreferences.edit().remove("pref_time_lapse_pro_index_of_focus_mode_key").apply();
        this.mPreferences.edit().remove("pref_time_lapse_pro_index_of_whitebalance_key").apply();
        this.mPreferences.edit().remove(com.oplus.camera.ui.CameraUIInterface.KEY_RESTORE_TIMELAPSE_PRO_PARAMS).apply();
    }

    private void f_renamed(boolean z_renamed) throws java.lang.NumberFormatException {
        if (this.mOneCamera == null) {
            return;
        }
        this.mOneCamera.a_renamed((android.hardware.camera2.CaptureRequest.Key<android.hardware.camera2.CaptureRequest.Key>) android.hardware.camera2.CaptureRequest.CONTROL_SCENE_MODE, (android.hardware.camera2.CaptureRequest.Key) 0);
        b_renamed(this.mActivity.getResources().getString(com.oplus.camera.R_renamed.string.camera_iso_default_value), false);
        long j_renamed = java.lang.Long.parseLong(this.mActivity.getResources().getString(com.oplus.camera.R_renamed.string.camera_exposure_time_default_value));
        this.mOneCamera.a_renamed(j_renamed);
        this.mOneCamera.a_renamed(j_renamed, false);
        P_renamed();
        this.mOneCamera.a_renamed((android.hardware.camera2.CaptureRequest.Key<android.hardware.camera2.CaptureRequest.Key>) android.hardware.camera2.CaptureRequest.CONTROL_AE_EXPOSURE_COMPENSATION, (android.hardware.camera2.CaptureRequest.Key) java.lang.Integer.valueOf(d_renamed()));
        this.mOneCamera.i_renamed(false);
        if (z_renamed) {
            this.mOneCamera.a_renamed((com.oplus.camera.e_renamed.d_renamed.c_renamed) null);
        }
        O_renamed();
        Q_renamed();
        this.mActivity.runOnUiThread(new java.lang.Runnable() { // from class: com.oplus.camera.timelapsepro.h_renamed.5
            @Override // java.lang.Runnable
            public void run() {
                com.oplus.camera.timelapsepro.h_renamed.this.N_renamed();
            }
        });
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public int getZoomBarOffset() {
        return super.getZoomBarOffset();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean onBackPressed() {
        com.oplus.camera.e_renamed.c_renamed("TimeLapseProMode", "onBackPressed, mbInCapturing: " + this.mbInCapturing);
        if (isVideoRecording()) {
            aj_renamed();
            return true;
        }
        com.oplus.camera.timelapsepro.g_renamed gVar = this.J_renamed;
        if (gVar != null && gVar.getVisibility() == 0) {
            c_renamed(this.J_renamed.c_renamed());
            return true;
        }
        return super.onBackPressed();
    }

    @Override // com.oplus.camera.capmode.BaseMode, com.oplus.camera.e_renamed.d_renamed.a_renamed
    public void onCaptureSequenceCompleted() {
        super.onCaptureSequenceCompleted();
        com.oplus.camera.e_renamed.c_renamed("TimeLapseProMode", "onCaptureSequenceCompleted");
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected boolean onStopTakePicture() {
        if (2 != this.mCameraInterface.g_renamed()) {
            com.oplus.camera.e_renamed.f_renamed("TimeLapseProMode", "onStopTakePicture failed, current camera state is_renamed " + this.mCameraInterface.g_renamed());
            return false;
        }
        this.mbInCapturing = false;
        setCapturePreviewDataState(2);
        this.mCameraInterface.f_renamed(true);
        this.mCameraUIInterface.a_renamed(true, false);
        return true;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void onDeInitCameraMode(java.lang.String str) {
        com.oplus.camera.e_renamed.c_renamed("TimeLapseProMode", "onDeInitCameraMode");
        s_renamed();
        com.oplus.camera.timelapsepro.g_renamed gVar = this.J_renamed;
        if (gVar != null) {
            gVar.setTimeLapseProMenuListener(null);
            this.J_renamed.setChangeScreenModeListener(null);
            this.J_renamed.b_renamed(this);
            this.J_renamed.setReportCallback(null);
        }
        if (M_renamed()) {
            this.mCameraUIInterface.w_renamed(true);
        }
        a_renamed(new java.lang.Runnable() { // from class: com.oplus.camera.timelapsepro.-$$Lambda$h_renamed$TAXae6jkOmRWsPCwHOkTHXkNnXs
            @Override // java.lang.Runnable
            public final void run() {
                this.f_renamed$0.ai_renamed();
            }
        });
        if (e_renamed() != null) {
            e_renamed().a_renamed(false);
        }
        n_renamed();
        this.ak_renamed = null;
        d_renamed("0", false);
        if (this.m_renamed != null) {
            this.m_renamed = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void ai_renamed() {
        this.mCameraUIInterface.aZ_renamed();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a_renamed(java.lang.Runnable runnable) {
        if (this.mActivity != null) {
            this.mActivity.runOnUiThread(runnable);
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onZoomMenuExpand() {
        super.onZoomMenuExpand();
        if (this.mbFrontCamera) {
            return;
        }
        a_renamed(false, true, true);
        b_renamed(false, true, true);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onZoomMenuCollapsing() {
        super.onZoomMenuCollapsing();
        if (this.mbFrontCamera) {
            return;
        }
        a_renamed(true, true, true);
        b_renamed(true, true, true);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected boolean onBeforeSnapping(com.oplus.camera.e_renamed.c_renamed cVar) {
        com.oplus.camera.e_renamed.c_renamed("TimeLapseProMode", "onBeforeSnapping, mRecorderStatus: " + this.z_renamed);
        if (this.mCameraInterface.F_renamed()) {
            com.oplus.camera.e_renamed.a_renamed("TimeLapseProMode", "onBeforeSnapping, being capture mode change!");
            return false;
        }
        if (com.oplus.camera.Storage.w_renamed != 0) {
            a_renamed(new java.lang.Runnable() { // from class: com.oplus.camera.timelapsepro.-$$Lambda$h_renamed$aZCQ_5ZrV5RsebWv_dfkDQhnwww
                @Override // java.lang.Runnable
                public final void run() {
                    this.f_renamed$0.ah_renamed();
                }
            });
            return false;
        }
        if (!isVideoRecording() && !this.mCameraInterface.P_renamed()) {
            com.oplus.camera.e_renamed.e_renamed("TimeLapseProMode", "onBeforeSnapping, memory or storage is_renamed not enough.");
            a_renamed(new java.lang.Runnable() { // from class: com.oplus.camera.timelapsepro.-$$Lambda$h_renamed$gVCRx2a1AxDvgM5yPD9nqENKKlU
                @Override // java.lang.Runnable
                public final void run() {
                    this.f_renamed$0.ag_renamed();
                }
            });
            c_renamed(com.oplus.camera.statistics.model.ReminderMsgData.TYPE_DISABLE_CODE, com.oplus.camera.statistics.model.ReminderMsgData.CODE_MEMORY_CAPTURE);
            return false;
        }
        if (isVideoRecordStarting()) {
            com.oplus.camera.e_renamed.e_renamed("TimeLapseProMode", "onBeforeSnapping onVideoShutterButtonClick, starting or error processing ");
            return false;
        }
        if (Z_renamed()) {
            return false;
        }
        setCaptureRequestPictureSizeScale();
        if (this.I_renamed == 0 && "auto".equals(this.ah_renamed)) {
            b_renamed(java.lang.String.valueOf(this.ai_renamed));
        }
        this.h_renamed.close();
        return H_renamed();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void ah_renamed() {
        this.mCameraUIInterface.t_renamed();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void ag_renamed() {
        this.mCameraUIInterface.a_renamed(com.oplus.camera.R_renamed.string.camera_toast_camera_Low_memory_hint, -1, true, false, false);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void updateCaptureParam(com.oplus.camera.e_renamed.c_renamed cVar) throws android.content.res.Resources.NotFoundException {
        super.updateCaptureParam(cVar);
        this.mOneCamera.e_renamed(true);
    }

    private boolean H_renamed() {
        com.oplus.camera.e_renamed.c_renamed("TimeLapseProMode", "startRecording, mRecorderStatus: " + this.z_renamed);
        if (com.oplus.camera.Camera.l_renamed) {
            L_renamed();
            return false;
        }
        if (2 != this.z_renamed) {
            return false;
        }
        b_renamed(1);
        this.h_renamed.close();
        this.ah_renamed = this.mPreferences.getString("pref_time_lapse_pro_focus_mode_key", this.mActivity.getString(com.oplus.camera.R_renamed.string.camera_focus_mode_default_value));
        synchronized (this.v_renamed) {
            this.y_renamed = 0;
        }
        this.aF_renamed = isSloganOpen();
        this.A_renamed = java.lang.System.currentTimeMillis();
        a_renamed(new java.lang.Runnable() { // from class: com.oplus.camera.timelapsepro.-$$Lambda$h_renamed$sEhwRZ2hZz3W7b-3_RWH9jBE09M
            @Override // java.lang.Runnable
            public final void run() throws android.content.res.Resources.NotFoundException {
                this.f_renamed$0.af_renamed();
            }
        });
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void af_renamed() throws android.content.res.Resources.NotFoundException {
        if (this.mCameraInterface != null) {
            I_renamed();
        }
        if (this.I_renamed == 0) {
            com.oplus.camera.timelapsepro.g_renamed gVar = this.J_renamed;
            if (gVar != null && this.s_renamed != null) {
                if (gVar.f_renamed()) {
                    if (this.J_renamed.isShown()) {
                        this.s_renamed.sendEmptyMessage(112);
                    } else {
                        this.s_renamed.sendEmptyMessageDelayed(112, 3000L);
                    }
                } else if (this.J_renamed.isShown()) {
                    this.s_renamed.sendEmptyMessageDelayed(111, 1000L);
                } else {
                    this.s_renamed.sendEmptyMessageDelayed(111, 1000L);
                }
            } else {
                this.mCameraUIInterface.a_renamed(com.oplus.camera.R_renamed.string.camera_time_lapse_pro_shooting_hint, -1, false, true, true);
            }
        } else {
            l_renamed();
        }
        this.mCameraUIInterface.d_renamed(true, false);
        this.mCameraUIInterface.aZ_renamed();
        this.x_renamed = 0;
        this.B_renamed = false;
        android.os.Handler handler = this.s_renamed;
        if (handler != null) {
            handler.removeMessages(103);
            this.s_renamed.sendEmptyMessage(103);
        }
        this.mOneCamera.a_renamed((android.hardware.camera2.CaptureRequest.Key<android.hardware.camera2.CaptureRequest.Key>) android.hardware.camera2.CaptureRequest.CONTROL_AWB_LOCK, (android.hardware.camera2.CaptureRequest.Key) true);
    }

    private void I_renamed() {
        this.mCameraInterface.K_renamed();
        this.mCameraInterface.aI_renamed();
        X_renamed();
        Y_renamed();
        a_renamed(false, true, !h_renamed());
        b_renamed(false, true, !h_renamed());
        this.mCameraUIInterface.O_renamed(true);
        this.mCameraUIInterface.u_renamed(true, true);
        e_renamed().a_renamed(this.mCameraId);
        this.mCameraInterface.c_renamed(4);
        this.mCameraInterface.L_renamed();
        this.mCameraInterface.a_renamed("normal");
        this.K_renamed = this.I_renamed != 0;
    }

    private void J_renamed() {
        com.oplus.camera.e_renamed.c_renamed("TimeLapseProMode", "stopRecording, mRecorderStatus: " + this.z_renamed);
        android.os.Handler handler = this.s_renamed;
        if (handler != null) {
            handler.removeMessages(101);
        }
        if (this.mCameraInterface != null) {
            this.mCameraInterface.c_renamed(5);
        }
        if (K_renamed()) {
            return;
        }
        this.S_renamed = true;
        this.av_renamed = false;
        c_renamed(0);
        this.mOneCamera.a_renamed((android.hardware.camera2.CaptureRequest.Key<android.hardware.camera2.CaptureRequest.Key>) android.hardware.camera2.CaptureRequest.CONTROL_AWB_LOCK, (android.hardware.camera2.CaptureRequest.Key) false);
        if (this.mCameraInterface != null) {
            this.mCameraInterface.W_renamed();
        }
        b_renamed(3);
        if (this.mActivity.getResources().getString(com.oplus.camera.R_renamed.string.camera_focus_mode_default_value).equals(this.ah_renamed)) {
            b_renamed(this.ah_renamed);
        }
        android.os.Handler handler2 = this.s_renamed;
        if (handler2 != null) {
            handler2.sendEmptyMessage(104);
        }
    }

    private boolean K_renamed() {
        return 3 == this.z_renamed || 2 == this.z_renamed;
    }

    private void L_renamed() {
        com.oplus.camera.e_renamed.c_renamed("TimeLapseProMode", "showLowBatteryHint");
        if (this.mbPaused || this.mActivity == null) {
            return;
        }
        this.mActivity.runOnUiThread(new java.lang.Runnable() { // from class: com.oplus.camera.timelapsepro.-$$Lambda$h_renamed$jN7NkrjgkS7ZaKFUTdxmUe8HNyg
            @Override // java.lang.Runnable
            public final void run() {
                this.f_renamed$0.ae_renamed();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void ae_renamed() {
        if (this.mCameraUIInterface != null) {
            this.mCameraUIInterface.a_renamed(com.oplus.camera.R_renamed.string.camera_time_lapse_pro_low_battery_hint, -1, true, false, false);
        }
    }

    private void c_renamed(int i_renamed) {
        if (this.mOneCamera == null) {
            return;
        }
        com.oplus.camera.e_renamed.c_renamed("TimeLapseProMode", "setNightMode, nightMode: " + i_renamed);
        this.mOneCamera.o_renamed(i_renamed);
        this.mOneCamera.a_renamed((com.oplus.camera.e_renamed.d_renamed.c_renamed) null);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean onAfterSnapping() {
        com.oplus.camera.e_renamed.a_renamed("TimeLapseProMode", "onAfterSnapping");
        return true;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void onShutterCallback(boolean z_renamed, boolean z2) {
        super.onShutterCallback(z_renamed, z2);
    }

    @Override // com.oplus.camera.capmode.BaseMode, com.oplus.camera.e_renamed.d_renamed.a_renamed
    public void onCaptureFailed(android.hardware.camera2.CaptureRequest captureRequest, com.oplus.camera.e_renamed.c_renamed cVar) {
        super.onCaptureFailed(captureRequest, cVar);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void onBeforePictureTaken(byte[] bArr, boolean z_renamed) {
        com.oplus.camera.e_renamed.c_renamed("TimeLapseProMode", "onBeforePictureTaken");
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void onAfterPictureTaken(byte[] bArr, boolean z_renamed) {
        com.oplus.camera.e_renamed.a_renamed("TimeLapseProMode", "onAfterPictureTaken");
        this.mCameraUIInterface.d_renamed(true, false);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void setCameraId(int i_renamed) {
        super.setCameraId(i_renamed);
        e_renamed().c_renamed(this.mbFrontCamera);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void cameraIdChanged(int i_renamed) {
        super.cameraIdChanged(i_renamed);
        this.at_renamed = true;
        e_renamed().c_renamed(this.mbFrontCamera);
    }

    private boolean M_renamed() {
        if (this.mPreferences != null) {
            return "camera_macro".equals(this.mPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_SWITCH_CAMERA, "camera_main"));
        }
        return false;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void setOrientation(int i_renamed) {
        if (this.mOrientation == i_renamed) {
            return;
        }
        this.mOrientation = i_renamed;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void onResume(boolean z_renamed) {
        com.oplus.camera.e_renamed.a_renamed("TimeLapseProMode", "onResume");
        this.h_renamed.close();
        this.mCameraUIInterface.a_renamed(this.aE_renamed);
        this.mCameraUIInterface.H_renamed();
        if (this.L_renamed) {
            this.L_renamed = false;
            this.mCameraInterface.W_renamed();
        }
        v_renamed();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void onPause() {
        com.oplus.camera.e_renamed.a_renamed("TimeLapseProMode", "onPause");
        this.L_renamed = this.I_renamed != 0;
        com.oplus.camera.timelapsepro.g_renamed gVar = this.J_renamed;
        if (gVar != null) {
            if (gVar.isShown()) {
                a_renamed(false, this.J_renamed.c_renamed(), true, true, true);
                this.mCameraUIInterface.Q_renamed(false);
            }
            this.J_renamed.k_renamed();
        }
        if (isVideoRecording()) {
            this.mCameraUIInterface.u_renamed(false, false);
        }
        forceStopVideoRecording(false);
        this.mCameraUIInterface.d_renamed(true, false);
        w_renamed();
        j_renamed();
        k_renamed();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void onDestroy() {
        com.oplus.camera.e_renamed.a_renamed("TimeLapseProMode", "onDestroy, " + e_renamed(this.z_renamed));
        s_renamed();
        n_renamed();
        com.oplus.camera.timelapsepro.g_renamed gVar = this.J_renamed;
        if (gVar != null) {
            gVar.setTimeLapseProMenuListener(null);
            this.J_renamed.setChangeScreenModeListener(null);
            this.J_renamed.b_renamed(this);
            this.J_renamed.setReportCallback(null);
            this.J_renamed = null;
        }
        if (this.m_renamed != null) {
            this.m_renamed = null;
        }
        if (!this.aC_renamed.isEmpty()) {
            java.util.Iterator<java.lang.String> it = this.aC_renamed.keySet().iterator();
            while (it.hasNext()) {
                com.oplus.camera.statistics.model.TimeLapseProMsgData timeLapseProMsgData = this.aC_renamed.get(it.next());
                if (timeLapseProMsgData != null) {
                    timeLapseProMsgData.destroy();
                }
            }
            this.aC_renamed.clear();
        }
        if (isVideoRecordStopped()) {
            return;
        }
        com.oplus.camera.e_renamed.c_renamed("TimeLapseProMode", "onDestroy, block");
        this.h_renamed.block(com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onAfterStartPreview(boolean z_renamed) {
        com.oplus.camera.e_renamed.b_renamed("TimeLapseProMode", "onAfterStartPreview");
        if (M_renamed()) {
            this.mCameraUIInterface.b_renamed(com.oplus.camera.R_renamed.string.camera_macro_best_focus_distance_text, 0, com.oplus.camera.R_renamed.color.screen_hint_text_color, java.lang.Integer.valueOf(com.oplus.camera.aps.config.CameraConfig.getConfigIntValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_MACRO_BEST_FOCUS_DISTANCE)));
        }
        U_renamed();
        super.onAfterStartPreview(z_renamed);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void onBeforePreview() throws android.content.res.Resources.NotFoundException, java.lang.NumberFormatException {
        com.oplus.camera.e_renamed.a_renamed("TimeLapseProMode", "onBeforePreview, mbCapModeInit: " + this.mbCapModeInit);
        e_renamed().a_renamed(this.mCameraId);
        this.mOneCamera.a_renamed((com.oplus.ocs.camera.CameraParameter.PreviewKey<com.oplus.ocs.camera.CameraParameter.PreviewKey<java.lang.Float>>) com.oplus.ocs.camera.CameraParameter.ZOOM_RATIO, (com.oplus.ocs.camera.CameraParameter.PreviewKey<java.lang.Float>) java.lang.Float.valueOf(this.mCameraInterface.ak_renamed()));
        if (this.mbFrontCamera) {
            f_renamed(true);
            return;
        }
        if (this.mPreferences.getBoolean(com.oplus.camera.ui.CameraUIInterface.KEY_RESTORE_TIMELAPSE_PRO_PARAMS, false)) {
            com.oplus.camera.e_renamed.a_renamed("TimeLapseProMode", "onBeforePreview, initParamToAuto");
            e_renamed(false);
            g_renamed(true);
        } else {
            if (this.mbCapModeInit) {
                g_renamed(this.at_renamed);
                if (this.at_renamed) {
                    this.at_renamed = false;
                }
                G_renamed();
            }
            a_renamed(new java.lang.Runnable() { // from class: com.oplus.camera.timelapsepro.-$$Lambda$h_renamed$QAMmyZjm275QCBmT4EdCooYwk-g_renamed
                @Override // java.lang.Runnable
                public final void run() {
                    this.f_renamed$0.ad_renamed();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void ad_renamed() {
        this.mCameraUIInterface.u_renamed(false, true);
    }

    private void g_renamed(boolean z_renamed) {
        com.oplus.camera.e_renamed.a_renamed("TimeLapseProMode", "initLayoutFromPreference, haveReset: " + z_renamed);
        com.oplus.camera.timelapsepro.g_renamed gVar = this.J_renamed;
        if (gVar != null) {
            gVar.a_renamed();
            if (z_renamed) {
                a_renamed(new java.lang.Runnable() { // from class: com.oplus.camera.timelapsepro.-$$Lambda$h_renamed$t76MbWmJDeUyjoPaATqYmTZAXkw
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f_renamed$0.ac_renamed();
                    }
                });
            }
            this.I_renamed = this.mPreferences.getInt("pref_time_lapse_pro_template_key", 0);
            if (this.I_renamed != 0) {
                this.J_renamed.l_renamed();
            }
            int i_renamed = this.I_renamed;
            if (i_renamed == 1) {
                d_renamed(this.mActivity.getApplicationContext().getResources().getString(com.oplus.camera.R_renamed.string.time_lapse_pro_speed_60x));
            } else if (i_renamed == 3) {
                d_renamed(this.mActivity.getApplicationContext().getResources().getString(com.oplus.camera.R_renamed.string.time_lapse_pro_speed_150x));
            } else {
                d_renamed("15");
                this.J_renamed.a_renamed("15");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void ac_renamed() {
        this.J_renamed.b_renamed();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N_renamed() {
        if (this.R_renamed.isEmpty()) {
            return;
        }
        try {
            if (((com.oplus.camera.timelapsepro.a_renamed.c_renamed) this.R_renamed.get(4)).g_renamed() || this.J_renamed == null) {
                return;
            }
            this.J_renamed.p_renamed();
        } catch (java.lang.Exception e_renamed) {
            e_renamed.printStackTrace();
        }
    }

    private void h_renamed(boolean z_renamed) {
        a_renamed(this.mPreferences.getString("pref_time_lapse_pro_whitebalance_key", this.mActivity.getResources().getString(com.oplus.camera.R_renamed.string.camera_whitebalance_default_value)), z_renamed);
    }

    private void a_renamed(java.lang.String str, boolean z_renamed) {
        if (this.mActivity.getResources().getString(com.oplus.camera.R_renamed.string.camera_whitebalance_default_value).equals(str)) {
            this.mOneCamera.a_renamed(-1, z_renamed);
        }
        if (a_renamed(str, this.R_renamed.get(5).j_renamed())) {
            try {
                this.mOneCamera.a_renamed(java.lang.Integer.parseInt(str), z_renamed);
            } catch (java.lang.NumberFormatException unused) {
                this.mOneCamera.i_renamed(z_renamed);
            }
        } else {
            this.mOneCamera.i_renamed(z_renamed);
        }
        com.oplus.camera.e_renamed.a_renamed("TimeLapseProMode", "setWhiteBalance, whiteBalance: " + str);
    }

    public boolean a_renamed(java.lang.String str, java.util.List<java.lang.String> list) {
        return list != null && list.indexOf(str) >= 0;
    }

    public void b_renamed(boolean z_renamed) {
        this.mOneCamera.i_renamed(z_renamed);
    }

    private void c_renamed(java.lang.String str) {
        b_renamed(str, true);
    }

    private void b_renamed(java.lang.String str, boolean z_renamed) {
        if (str == null) {
            str = this.mPreferences.getString("pref_time_lapse_pro_iso_key", this.mActivity.getResources().getString(com.oplus.camera.R_renamed.string.camera_iso_default_value));
        }
        if (this.mActivity.getResources().getString(com.oplus.camera.R_renamed.string.camera_iso_default_value).equals(str)) {
            this.mOneCamera.b_renamed(-1, z_renamed);
        } else {
            W_renamed();
            this.mOneCamera.r_renamed();
            try {
                this.mOneCamera.b_renamed(java.lang.Integer.parseInt(str), z_renamed);
            } catch (java.lang.NumberFormatException e_renamed) {
                e_renamed.printStackTrace();
                com.oplus.camera.e_renamed.a_renamed("TimeLapseProMode", "setISOValue, format iso value error.");
            }
        }
        com.oplus.camera.e_renamed.a_renamed("TimeLapseProMode", "setISOValue, iso: " + str);
    }

    public void b_renamed(java.lang.String str) {
        if (str == null) {
            str = this.mPreferences.getString("pref_time_lapse_pro_focus_mode_key", this.mActivity.getString(com.oplus.camera.R_renamed.string.camera_focus_mode_default_value));
        }
        com.oplus.camera.e_renamed.a_renamed("TimeLapseProMode", "setFocusValue, focusValue: " + str);
        if (this.mActivity.getString(com.oplus.camera.R_renamed.string.camera_focus_mode_default_value).equals(str) || str.isEmpty()) {
            return;
        }
        android.os.Handler handler = this.s_renamed;
        if (handler != null) {
            handler.removeMessages(100);
            android.os.Message messageObtain = android.os.Message.obtain();
            messageObtain.what = 100;
            try {
                messageObtain.obj = java.lang.Float.valueOf(java.lang.Float.parseFloat(str));
                this.s_renamed.sendMessage(messageObtain);
            } catch (java.lang.NumberFormatException e_renamed) {
                e_renamed.printStackTrace();
                com.oplus.camera.e_renamed.a_renamed("TimeLapseProMode", "setFocusValue, format value is_renamed error.");
            }
        }
        if (this.n_renamed) {
            j_renamed(false);
        }
    }

    public int d_renamed() {
        return java.lang.Integer.parseInt(this.mPreferences.getString("pref_time_lapse_pro_exposure_compensation_key", this.mActivity.getResources().getString(com.oplus.camera.R_renamed.string.camera_exposure_compensation_default_value)));
    }

    private void R_renamed() throws java.lang.NumberFormatException {
        i_renamed(true);
    }

    private void i_renamed(boolean z_renamed) throws java.lang.NumberFormatException {
        java.lang.String string = this.mPreferences.getString("pref_time_lapse_pro_exposure_time_key", this.mActivity.getResources().getString(com.oplus.camera.R_renamed.string.camera_exposure_time_default_value));
        long jLongValue = java.lang.Long.valueOf(this.mActivity.getResources().getString(com.oplus.camera.R_renamed.string.camera_exposure_time_default_value)).longValue();
        try {
            long j_renamed = java.lang.Long.parseLong(string);
            if (j_renamed != jLongValue) {
                W_renamed();
            }
            if (this.mbFrontCamera) {
                this.mOneCamera.a_renamed(jLongValue, z_renamed);
            } else {
                this.mOneCamera.a_renamed(j_renamed, z_renamed);
            }
        } catch (java.lang.NumberFormatException e_renamed) {
            e_renamed.printStackTrace();
            com.oplus.camera.e_renamed.a_renamed("TimeLapseProMode", "setExposureTime, format shutter value error.");
        }
    }

    private void c_renamed(java.lang.String str, boolean z_renamed) throws java.lang.NumberFormatException {
        long jLongValue = java.lang.Long.valueOf(this.mActivity.getResources().getString(com.oplus.camera.R_renamed.string.camera_exposure_time_default_value)).longValue();
        long j_renamed = java.lang.Long.parseLong(str);
        if (j_renamed != jLongValue) {
            W_renamed();
        }
        if (this.mbFrontCamera) {
            this.mOneCamera.a_renamed(jLongValue, z_renamed);
        } else {
            this.mOneCamera.a_renamed(j_renamed, z_renamed);
        }
    }

    private void d_renamed(final java.lang.String str, boolean z_renamed) {
        final java.lang.Boolean boolValueOf = java.lang.Boolean.valueOf(z_renamed);
        com.oplus.camera.e_renamed.a_renamed("TimeLapseProMode", "setFlashModeMenuEnable, exposureTime: " + str + ", mDisPlayFlashIcon: " + boolValueOf);
        if (android.text.TextUtils.isEmpty(str)) {
            return;
        }
        try {
            if (java.lang.Integer.parseInt(str) == 0) {
                if (this.mCameraUIInterface != null) {
                    this.mCameraUIInterface.b_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_FLASH_MODE, (java.lang.String) null);
                    c_renamed(true, z_renamed);
                }
            } else if (this.mCameraUIInterface != null) {
                c_renamed(false, z_renamed);
                this.mCameraUIInterface.a_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_FLASH_MODE, "off");
            }
        } catch (java.lang.Exception e_renamed) {
            e_renamed.printStackTrace();
            if (this.mActivity != null) {
                this.mActivity.runOnUiThread(new java.lang.Runnable() { // from class: com.oplus.camera.timelapsepro.h_renamed.6
                    @Override // java.lang.Runnable
                    public void run() {
                        if (java.lang.Integer.parseInt(str) == 0) {
                            if (com.oplus.camera.timelapsepro.h_renamed.this.mCameraUIInterface != null) {
                                com.oplus.camera.timelapsepro.h_renamed.this.c_renamed(true, boolValueOf.booleanValue());
                                com.oplus.camera.timelapsepro.h_renamed.this.mCameraUIInterface.b_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_FLASH_MODE, (java.lang.String) null);
                                return;
                            }
                            return;
                        }
                        if (com.oplus.camera.timelapsepro.h_renamed.this.mCameraUIInterface != null) {
                            com.oplus.camera.timelapsepro.h_renamed.this.c_renamed(false, boolValueOf.booleanValue());
                            com.oplus.camera.timelapsepro.h_renamed.this.mCameraUIInterface.a_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_FLASH_MODE, "off");
                        }
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c_renamed(boolean z_renamed, boolean z2) {
        if (z2) {
            com.oplus.camera.e_renamed.a_renamed("TimeLapseProMode", "showOrHideFlashIcon, enable: " + z_renamed + ", isOpenFlash: " + isOpenFlash());
            if (z_renamed) {
                displayScreenHintIconInSwitchOn();
            } else {
                this.mCameraUIInterface.a_renamed(false, true, false);
            }
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onSharedPreferenceChanged(android.content.SharedPreferences sharedPreferences, java.lang.String str) throws android.content.res.Resources.NotFoundException, java.lang.NumberFormatException {
        com.oplus.camera.e_renamed.a_renamed("TimeLapseProMode", "onSharedPreferenceChanged, key: " + str + ", " + sharedPreferences);
        if ("pref_time_lapse_pro_whitebalance_key".equals(str)) {
            h_renamed(true);
            return;
        }
        if ("pref_time_lapse_pro_iso_key".equals(str)) {
            if (!com.oplus.camera.Camera.l_renamed) {
                this.mOneCamera.b_renamed(getFlashMode());
            } else {
                this.mOneCamera.b_renamed("off");
            }
            c_renamed((java.lang.String) null);
            return;
        }
        if ("pref_time_lapse_pro_exposure_compensation_key".equals(str)) {
            this.mOneCamera.a_renamed((android.hardware.camera2.CaptureRequest.Key<android.hardware.camera2.CaptureRequest.Key>) android.hardware.camera2.CaptureRequest.CONTROL_AE_EXPOSURE_COMPENSATION, (android.hardware.camera2.CaptureRequest.Key) java.lang.Integer.valueOf(d_renamed()));
            this.mOneCamera.a_renamed((com.oplus.camera.e_renamed.d_renamed.c_renamed) null);
            return;
        }
        if ("pref_time_lapse_pro_exposure_time_key".equals(str)) {
            if (!com.oplus.camera.Camera.l_renamed) {
                this.mOneCamera.b_renamed(getFlashMode());
            } else {
                this.mOneCamera.b_renamed("off");
            }
            R_renamed();
            long jF = F_renamed();
            if (jF >= 500000000) {
                long j_renamed = jF / 1000000;
                java.lang.String[] stringArray = this.mActivity.getApplicationContext().getResources().getStringArray(com.oplus.camera.R_renamed.array.time_lapse_pro_speeds);
                for (int i_renamed = 0; i_renamed < stringArray.length; i_renamed++) {
                    if (j_renamed < (java.lang.Long.parseLong(stringArray[i_renamed]) * 1000) / e_renamed().c_renamed()) {
                        com.oplus.camera.timelapsepro.g_renamed gVar = this.J_renamed;
                        if (gVar != null) {
                            gVar.a_renamed(i_renamed);
                            return;
                        }
                        return;
                    }
                }
                return;
            }
            com.oplus.camera.timelapsepro.g_renamed gVar2 = this.J_renamed;
            if (gVar2 != null) {
                gVar2.a_renamed(0);
                return;
            }
            return;
        }
        if ("pref_time_lapse_pro_focus_mode_key".equals(str)) {
            if (!this.R_renamed.get(4).g_renamed()) {
                b_renamed((java.lang.String) null);
            } else {
                if (4 != this.mOneCamera.p_renamed()) {
                    this.mOneCamera.a_renamed(4, com.oplus.camera.a_renamed.b_renamed(), com.oplus.camera.a_renamed.b_renamed(), true);
                    this.mOneCamera.a_renamed((com.oplus.camera.e_renamed.d_renamed.c_renamed) null);
                }
                if (4 == this.mOneCamera.p_renamed() || 1 == this.mOneCamera.p_renamed()) {
                    N_renamed();
                }
            }
        } else if (com.oplus.camera.ui.CameraUIInterface.KEY_FLASH_MODE.equals(str)) {
            if (!this.mActivity.getString(com.oplus.camera.R_renamed.string.camera_flash_mode_default_value).equals(sharedPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_FLASH_MODE, this.mActivity.getString(com.oplus.camera.R_renamed.string.camera_flash_mode_default_value)))) {
                V_renamed();
            }
            j_renamed(true);
        }
        super.onSharedPreferenceChanged(sharedPreferences, str);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void onSwitchCameraButtonClick() {
        super.onSwitchCameraButtonClick();
        this.T_renamed = true;
        com.oplus.camera.timelapsepro.g_renamed gVar = this.J_renamed;
        if (gVar == null || gVar.getVisibility() != 0) {
            return;
        }
        if (this.J_renamed.c_renamed()) {
            a_renamed(false, true);
        } else {
            b_renamed(false, true);
        }
        this.mCameraUIInterface.Q_renamed(true);
    }

    private void S_renamed() throws android.content.res.Resources.NotFoundException {
        java.lang.String string = this.mActivity.getResources().getString(com.oplus.camera.R_renamed.string.camera_iso_default_value);
        java.lang.String string2 = this.mActivity.getResources().getString(com.oplus.camera.R_renamed.string.camera_exposure_time_default_value);
        java.lang.String string3 = this.mActivity.getResources().getString(com.oplus.camera.R_renamed.string.camera_whitebalance_default_value);
        java.lang.String string4 = this.mActivity.getResources().getString(com.oplus.camera.R_renamed.string.camera_focus_mode_default_value);
        com.oplus.camera.e_renamed.a_renamed("TimeLapseProMode", "logParameters, mPreferences: " + this.mPreferences + ", speed: " + this.i_renamed + ", frames: " + this.k_renamed + ", ISO: " + this.mPreferences.getString("pref_time_lapse_pro_iso_key", string) + ", shutter: " + this.mPreferences.getString("pref_time_lapse_pro_exposure_time_key", string2) + ", ev_renamed: " + this.mPreferences.getString("pref_time_lapse_pro_exposure_compensation_key", this.mActivity.getResources().getString(com.oplus.camera.R_renamed.string.camera_exposure_compensation_default_value)) + ", focus: " + this.mPreferences.getString("pref_time_lapse_pro_focus_mode_key", string4) + ", wb: " + this.mPreferences.getString("pref_time_lapse_pro_whitebalance_key", string3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void T_renamed() {
        boolean z_renamed = false;
        if (this.S_renamed) {
            this.S_renamed = false;
            if (this.mCameraInterface != null) {
                this.mCameraInterface.N_renamed();
            }
        }
        if (this.mCameraUIInterface != null) {
            this.mCameraUIInterface.u_renamed(false, true);
            this.mCameraUIInterface.d_renamed(true, false);
            this.mCameraUIInterface.P_renamed(true);
            this.mCameraUIInterface.N_renamed(true);
        }
        if (!this.mbFrontCamera && this.mCameraInterface != null) {
            a_renamed(true, true, !h_renamed());
            b_renamed(true, true, !h_renamed());
            if (this.M_renamed) {
                this.mCameraInterface.aH_renamed();
                this.M_renamed = false;
            }
            if (this.I_renamed != 2) {
                com.oplus.camera.capmode.a_renamed aVar = this.mCameraInterface;
                if (!h_renamed() && !f_renamed()) {
                    z_renamed = true;
                }
                aVar.a_renamed(true, z_renamed);
            } else {
                this.M_renamed = true;
            }
        }
        com.oplus.camera.timelapsepro.g_renamed gVar = this.J_renamed;
        if (gVar != null) {
            gVar.h_renamed();
        }
        s_renamed();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void setFlashTemporaryDisabled(boolean z_renamed) {
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

    private void U_renamed() {
        if (this.mPreferences == null) {
            return;
        }
        java.lang.String string = this.mPreferences.getString("pref_time_lapse_pro_exposure_time_key", this.mActivity.getResources().getString(com.oplus.camera.R_renamed.string.camera_exposure_time_default_value));
        java.lang.String string2 = this.mPreferences.getString("pref_time_lapse_pro_iso_key", this.mActivity.getResources().getString(com.oplus.camera.R_renamed.string.camera_iso_default_value));
        if (getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_SWITCH_CAMERA) && getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_FLASH_MODE) && this.mActivity.getResources().getString(com.oplus.camera.R_renamed.string.camera_exposure_time_default_value).equals(string) && this.mActivity.getResources().getString(com.oplus.camera.R_renamed.string.camera_iso_default_value).equals(string2)) {
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

    private void V_renamed() {
        if ("off".equals(this.mPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_FLASH_MODE, this.mActivity.getString(com.oplus.camera.R_renamed.string.camera_flash_mode_default_value)))) {
            return;
        }
        java.lang.String string = this.mPreferences.getString("pref_time_lapse_pro_exposure_time_key", this.mActivity.getResources().getString(com.oplus.camera.R_renamed.string.camera_exposure_time_default_value));
        java.lang.String string2 = this.mPreferences.getString("pref_time_lapse_pro_iso_key", this.mActivity.getResources().getString(com.oplus.camera.R_renamed.string.camera_iso_default_value));
        this.mActivity.getResources().getString(com.oplus.camera.R_renamed.string.camera_exposure_time_default_value).equals(string);
        this.mActivity.getResources().getString(com.oplus.camera.R_renamed.string.camera_iso_default_value).equals(string2);
    }

    private void j_renamed(boolean z_renamed) {
        boolean zEquals = z_renamed ? true ^ "off".equals(this.mPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_FLASH_MODE, this.mActivity.getString(com.oplus.camera.R_renamed.string.camera_flash_mode_default_value))) : true;
        if (this.n_renamed && zEquals) {
            android.content.SharedPreferences.Editor editorEdit = this.mPreferences.edit();
            editorEdit.putString(com.oplus.camera.ui.CameraUIInterface.KEY_HIGH_RESOLUTION, "off");
            editorEdit.apply();
            this.mCameraUIInterface.b_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_HIGH_RESOLUTION, "off");
        }
    }

    private void W_renamed() {
        if ("off".equals(this.mPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_FLASH_MODE, this.mActivity.getString(com.oplus.camera.R_renamed.string.camera_flash_mode_default_value)))) {
            return;
        }
        android.content.SharedPreferences.Editor editorEdit = this.mPreferences.edit();
        editorEdit.putString(com.oplus.camera.ui.CameraUIInterface.KEY_FLASH_MODE, "off");
        editorEdit.apply();
        this.mCameraUIInterface.f_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_FLASH_MODE);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean isNeedProgressBarInCapture() {
        java.lang.String string = this.mPreferences.getString("pref_time_lapse_pro_exposure_time_key", this.mActivity.getResources().getString(com.oplus.camera.R_renamed.string.camera_exposure_time_default_value));
        return android.text.TextUtils.isEmpty(string) || java.lang.Long.valueOf(string).longValue() >= com.google.android.exoplayer2.C_renamed.NANOS_PER_SECOND;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void changeModeAllViewWhenAnimation(int i_renamed, boolean z_renamed) {
        super.changeModeAllViewWhenAnimation(i_renamed, z_renamed);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d_renamed(java.lang.String str) {
        com.oplus.camera.e_renamed.a_renamed("TimeLapseProMode", "setRecordSpeed, speed: " + str);
        this.i_renamed = str;
        this.j_renamed = (java.lang.Long.parseLong(this.i_renamed) * 1000) / ((long) e_renamed().c_renamed());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void d_renamed(int i_renamed) {
        this.H_renamed = this.I_renamed;
        this.I_renamed = i_renamed;
        if (i_renamed == this.H_renamed) {
            return;
        }
        boolean z_renamed = true;
        if (this.H_renamed == 1) {
            d_renamed("15");
        } else if (this.H_renamed != 2 && this.H_renamed == 3) {
            d_renamed("15");
        }
        if (i_renamed == 1) {
            d_renamed(this.mActivity.getApplicationContext().getResources().getString(com.oplus.camera.R_renamed.string.time_lapse_pro_speed_60x));
        } else if (i_renamed == 2) {
            if (f_renamed()) {
                a_renamed(new java.lang.Runnable() { // from class: com.oplus.camera.timelapsepro.-$$Lambda$h_renamed$WOzPRCV2xREsRp7ujOoJiSrJtHU
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f_renamed$0.ab_renamed();
                    }
                });
            } else {
                this.M_renamed = true;
                this.mCameraInterface.aH_renamed();
            }
        } else if (i_renamed == 3) {
            d_renamed(this.mActivity.getApplicationContext().getResources().getString(com.oplus.camera.R_renamed.string.time_lapse_pro_speed_150x));
        }
        if (i_renamed != 0) {
            if (this.H_renamed == 0 && !this.R_renamed.isEmpty()) {
                b_renamed(this.R_renamed.get(4).j_renamed().get(this.R_renamed.get(4).k_renamed().indexOf("0.96")));
            }
            this.k_renamed = 0L;
        } else {
            if (4 != this.mOneCamera.p_renamed()) {
                this.mOneCamera.a_renamed(4, com.oplus.camera.a_renamed.b_renamed(), com.oplus.camera.a_renamed.b_renamed(), true);
                this.mOneCamera.a_renamed((com.oplus.camera.e_renamed.d_renamed.c_renamed) null);
            }
            if (4 == this.mOneCamera.p_renamed() || 1 == this.mOneCamera.p_renamed()) {
                N_renamed();
            }
        }
        if (f_renamed() && i_renamed != 2 && this.H_renamed == 2) {
            a_renamed(new java.lang.Runnable() { // from class: com.oplus.camera.timelapsepro.-$$Lambda$h_renamed$MaLPRVl6_CGT3xa2Ui9kG3jjUmc
                @Override // java.lang.Runnable
                public final void run() {
                    this.f_renamed$0.aa_renamed();
                }
            });
        }
        if (i_renamed != 2) {
            z_renamed = false;
        }
        d_renamed(z_renamed);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void ab_renamed() {
        this.mCameraInterface.a_renamed(new android.animation.AnimatorListenerAdapter() { // from class: com.oplus.camera.timelapsepro.h_renamed.7
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(android.animation.Animator animator) {
                com.oplus.camera.timelapsepro.h_renamed.this.M_renamed = true;
                com.oplus.camera.timelapsepro.h_renamed.this.mCameraInterface.aH_renamed();
            }
        }, true, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void aa_renamed() {
        this.mCameraInterface.aH_renamed();
        this.M_renamed = false;
        this.mCameraInterface.a_renamed(true, false);
        this.mCameraInterface.d_renamed(true);
    }

    @Override // com.oplus.camera.timelapsepro.g_renamed.d_renamed
    public void a_renamed() {
        this.mCameraUIInterface.ba_renamed();
    }

    @Override // com.oplus.camera.timelapsepro.g_renamed.d_renamed
    public void b_renamed() {
        this.mCameraUIInterface.bb_renamed();
    }

    @Override // com.oplus.camera.timelapsepro.g_renamed.f_renamed
    public void a_renamed(boolean z_renamed) {
        b_renamed(z_renamed ? com.oplus.camera.statistics.model.TimeLapseProMsgData.FUNC_KEY_ID_TEMPLATE : com.oplus.camera.statistics.model.TimeLapseProMsgData.FUNC_KEY_ID_PARAMS, "2");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b_renamed(java.lang.String str, java.lang.String str2) {
        com.oplus.camera.statistics.model.TimeLapseProMsgData timeLapseProMsgDataE = e_renamed("funcKey_click");
        timeLapseProMsgDataE.mFuncKeyId = str;
        timeLapseProMsgDataE.mFuncKeyResult = str2;
        timeLapseProMsgDataE.report();
    }

    @Override // com.oplus.camera.timelapsepro.g_renamed.f_renamed
    public void a_renamed(java.lang.String str, java.lang.String str2) {
        com.oplus.camera.statistics.model.TimeLapseProMsgData timeLapseProMsgDataE = e_renamed("funcValue_select");
        timeLapseProMsgDataE.mFuncKeyId = com.oplus.camera.statistics.model.TimeLapseProMsgData.FUNC_KEY_ID_PARAMS;
        timeLapseProMsgDataE.mFuncKeyItem = str;
        timeLapseProMsgDataE.mFuncKeyResult = str2;
        timeLapseProMsgDataE.report();
    }

    @Override // com.oplus.camera.timelapsepro.g_renamed.f_renamed
    public void a_renamed(int i_renamed) {
        com.oplus.camera.statistics.model.TimeLapseProMsgData timeLapseProMsgDataE = e_renamed("funcValue_select");
        timeLapseProMsgDataE.mFuncKeyId = com.oplus.camera.statistics.model.TimeLapseProMsgData.FUNC_KEY_ID_TEMPLATE;
        timeLapseProMsgDataE.mFuncKeyItem = null;
        timeLapseProMsgDataE.mFuncKeyResult = timeLapseProMsgDataE.getTemplateValue(i_renamed);
        timeLapseProMsgDataE.report();
    }

    @Override // com.oplus.camera.timelapsepro.g_renamed.f_renamed
    public void a_renamed(java.lang.String str) {
        com.oplus.camera.statistics.model.TimeLapseProMsgData timeLapseProMsgDataE = e_renamed("funcMenu_select");
        timeLapseProMsgDataE.mFuncKeyId = com.oplus.camera.statistics.model.TimeLapseProMsgData.FUNC_KEY_ID_PARAMS;
        timeLapseProMsgDataE.mFuncKeyValue = str;
        timeLapseProMsgDataE.report();
    }

    private com.oplus.camera.statistics.model.TimeLapseProMsgData e_renamed(java.lang.String str) {
        com.oplus.camera.statistics.model.TimeLapseProMsgData timeLapseProMsgData = this.aC_renamed.get(str);
        if (timeLapseProMsgData == null) {
            timeLapseProMsgData = new com.oplus.camera.statistics.model.TimeLapseProMsgData(this.mActivity, getCameraMode());
            timeLapseProMsgData.buildEventId(str);
            this.aC_renamed.put(str, timeLapseProMsgData);
        }
        timeLapseProMsgData.mOrientation = this.mOrientation;
        return timeLapseProMsgData;
    }

    private void a_renamed(long j_renamed, long j2) throws android.content.res.Resources.NotFoundException {
        com.oplus.camera.statistics.model.TimeLapseProMsgData timeLapseProMsgDataE = e_renamed("videoRecord");
        int i_renamed = this.I_renamed;
        if (i_renamed != 0) {
            timeLapseProMsgDataE.mTimeLapseType = java.lang.String.valueOf(i_renamed);
        } else {
            int i2 = this.mPreferences.getInt("pref_time_lapse_pro_speed_key", -1);
            int i3 = this.mPreferences.getInt("pref_time_lapse_pro_index_of_iso_key", -1);
            int i4 = this.mPreferences.getInt("pref_time_lapse_pro_index_of_exposure_time_key", -1);
            int i5 = this.mPreferences.getInt("pref_time_lapse_pro_index_of_exposure_compensation_key", com.oplus.camera.timelapsepro.e_renamed.f5680a);
            int i6 = this.mPreferences.getInt("pref_time_lapse_pro_index_of_focus_mode_key", -1);
            int i7 = this.mPreferences.getInt("pref_time_lapse_pro_index_of_whitebalance_key", -1);
            if (-1 == i2 && -1 == i3 && -1 == i4 && com.oplus.camera.timelapsepro.e_renamed.f5680a == i5 && -1 == i6 && -1 == i7) {
                timeLapseProMsgDataE.mTimeLapseType = "default";
            } else {
                timeLapseProMsgDataE.mTimeLapseType = com.oplus.camera.statistics.model.TimeLapseProMsgData.KEY_CUSTOMEIZE;
                java.lang.String[] stringArray = this.mActivity.getResources().getStringArray(com.oplus.camera.R_renamed.array.time_lapse_pro_speeds);
                if (i2 >= 0 && i2 < stringArray.length) {
                    timeLapseProMsgDataE.mPosterizeTime = stringArray[i2];
                }
                if (!this.R_renamed.isEmpty()) {
                    if (i3 >= 0 && i3 < this.R_renamed.get(1).k_renamed().size()) {
                        timeLapseProMsgDataE.mTimeLapseISO = this.R_renamed.get(1).k_renamed().get(i3);
                    } else {
                        timeLapseProMsgDataE.mTimeLapseISO = "auto";
                    }
                    if (i4 >= 0 && i4 < this.R_renamed.get(2).k_renamed().size()) {
                        timeLapseProMsgDataE.mTimeLapseEXP = this.R_renamed.get(2).k_renamed().get(i4);
                    } else {
                        timeLapseProMsgDataE.mTimeLapseEXP = "auto";
                    }
                    if (i5 >= 0 && i5 < this.R_renamed.get(3).k_renamed().size()) {
                        timeLapseProMsgDataE.mTimeLapseEV = this.R_renamed.get(3).k_renamed().get(i5);
                    } else if (com.oplus.camera.timelapsepro.e_renamed.f5680a == i5) {
                        timeLapseProMsgDataE.mTimeLapseEV = "auto";
                    }
                    if (i6 >= 0 && i6 < this.R_renamed.get(4).k_renamed().size()) {
                        timeLapseProMsgDataE.mTimeLapseFocus = this.R_renamed.get(4).k_renamed().get(i6);
                    } else {
                        timeLapseProMsgDataE.mTimeLapseFocus = "auto";
                    }
                    if (i7 >= 0 && i7 < this.R_renamed.get(5).k_renamed().size()) {
                        timeLapseProMsgDataE.mTimeLapseWB = this.R_renamed.get(5).k_renamed().get(i7);
                    } else {
                        timeLapseProMsgDataE.mTimeLapseWB = "auto";
                    }
                }
            }
        }
        timeLapseProMsgDataE.mVideoTime = java.lang.String.valueOf(j_renamed);
        timeLapseProMsgDataE.mGenerateTime = java.lang.String.valueOf(j2);
        timeLapseProMsgDataE.mLux = this.ax_renamed;
        timeLapseProMsgDataE.mCct = this.aA_renamed;
        timeLapseProMsgDataE.mExp = this.az_renamed;
        timeLapseProMsgDataE.mIso = this.ay_renamed;
        timeLapseProMsgDataE.report();
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

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean isInPreviewArea(android.view.MotionEvent motionEvent) {
        android.graphics.Rect rect = new android.graphics.Rect();
        this.mCameraUIInterface.p_renamed().getHitRect(rect);
        return rect.contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY());
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public com.oplus.camera.af_renamed getZoomConfigure() {
        com.oplus.camera.af_renamed zoomConfigure = super.getZoomConfigure();
        zoomConfigure.l_renamed(isHighPictureSize());
        zoomConfigure.n_renamed(getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_ULTRA_WIDE_HIGH_PICTURE_SIZE));
        zoomConfigure.t_renamed(getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_SUPPORT_INSENSOR_ZOOM_20X));
        zoomConfigure.u_renamed(getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_SUPPORT_INSENSOR_ZOOM_20X) && com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_INSENSOR_ZOOM_POINT_3X_SUPPORT));
        return zoomConfigure;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean isShowZoomMenu() {
        return !c_renamed();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void restoreDefaultMode(boolean z_renamed) {
        super.restoreDefaultMode(z_renamed);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean isVideoRecording() {
        return isVideoRecordStarted() || isVideoRecordStarting();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean isVideoRecordStarted() {
        return this.z_renamed == 0;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean isVideoRecordStarting() {
        return this.z_renamed == 1;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean isVideoRecordStopping() {
        return this.z_renamed == 3;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    /* renamed from: onVideoShutterButtonClick, reason: merged with bridge method [inline-methods] */
    public void aj_renamed() {
        super.aj_renamed();
        if (this.mCameraInterface == null) {
            com.oplus.camera.e_renamed.a_renamed("TimeLapseProMode", "onVideoShutterButtonClick mCameraInterface is_renamed null.");
            return;
        }
        com.oplus.camera.e_renamed.f_renamed("TimeLapseProMode", "onVideoShutterButtonClick, mRecorderStatus: " + this.z_renamed + ", mCameraInterface.isAnimationRunning: " + this.mCameraInterface.R_renamed());
        if (this.mCameraInterface.F_renamed()) {
            com.oplus.camera.e_renamed.a_renamed("TimeLapseProMode", "onVideoShutterButtonClick, being capture mode change!");
            return;
        }
        if (com.oplus.camera.Storage.w_renamed != 0) {
            this.mCameraUIInterface.t_renamed();
            return;
        }
        if (!isVideoRecording() && !this.mCameraInterface.P_renamed()) {
            com.oplus.camera.e_renamed.e_renamed("TimeLapseProMode", "onVideoShutterButtonClick, memory or storage is_renamed not enough");
            this.mCameraUIInterface.a_renamed(com.oplus.camera.R_renamed.string.camera_toast_camera_Low_memory_hint, -1, true, false, false);
            c_renamed(com.oplus.camera.statistics.model.ReminderMsgData.TYPE_DISABLE_CODE, com.oplus.camera.statistics.model.ReminderMsgData.CODE_MEMORY_CAPTURE);
            return;
        }
        com.oplus.camera.e_renamed.f_renamed("TimeLapseProMode", "onVideoShutterButtonClick, CameraTest Click Video Button. mRecorderStatus: " + this.z_renamed);
        if (isVideoRecordStarted()) {
            android.os.Handler handler = this.s_renamed;
            if (handler != null && handler.hasMessages(110)) {
                this.s_renamed.removeMessages(110);
            }
            J_renamed();
            return;
        }
        isVideoRecordStopped();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean isVideoRecordStopped() {
        return this.z_renamed == 2;
    }

    private void k_renamed(boolean z_renamed) {
        com.oplus.camera.e_renamed.a_renamed("TimeLapseProMode", "onStopVideoRecording, checkRecordTime: " + z_renamed);
        this.mCameraUIInterface.a_renamed(new com.oplus.camera.ui.control.b_renamed(6, "button_color_inside_red", "button_shape_dial_rotate", 1));
        if (!this.mbPaused && this.mCameraInterface != null && this.mCameraInterface.i_renamed() && !supportParameterAdjust() && this.mOneCamera != null) {
            this.mCameraInterface.ac_renamed();
            this.mCameraInterface.b_renamed(false, false);
            this.mOneCamera.a_renamed(3, com.oplus.camera.a_renamed.b_renamed(), com.oplus.camera.a_renamed.b_renamed(), true);
            this.mOneCamera.a_renamed((com.oplus.camera.e_renamed.d_renamed.c_renamed) null);
        }
        if (this.mCameraInterface == null || this.mOneCamera == null) {
            return;
        }
        this.mOneCamera.h_renamed();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void beforeStartRecording() throws android.content.res.Resources.NotFoundException {
        S_renamed();
        if (this.mCameraInterface != null) {
            this.mCameraInterface.a_renamed((android.animation.AnimatorListenerAdapter) null, true, (f_renamed() || h_renamed()) ? false : true);
        }
        com.oplus.camera.e_renamed.c_renamed("TimeLapseProMode", "beforeStartRecording");
        this.mCameraUIInterface.a_renamed(new com.oplus.camera.ui.control.b_renamed(5, "button_color_inside_red", "button_shape_dial_rotate", 1));
        super.beforeStartRecording();
    }

    protected void b_renamed(int i_renamed) {
        com.oplus.camera.e_renamed.a_renamed("TimeLapseProMode", "setVideoRecordState, mRecorderStatus: from " + e_renamed(this.z_renamed) + " to " + e_renamed(i_renamed));
        this.z_renamed = i_renamed;
    }

    private void X_renamed() {
        this.mActivity.sendBroadcast(new android.content.Intent("oplus.multimedia.soundrecorder.stopRecroderNormal"));
    }

    private void Y_renamed() {
        this.mActivity.sendBroadcast(new android.content.Intent("oplus.camera.record.start"));
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void setLowBatteryState(boolean z_renamed) {
        this.g_renamed = z_renamed;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void forceStopVideoRecording(boolean z_renamed) {
        if (isVideoRecordStarted() || isVideoRecordStarting()) {
            com.oplus.camera.e_renamed.a_renamed("TimeLapseProMode", "forceStopVideoRecording, mRecordSig.block");
            J_renamed();
            this.h_renamed.close();
            if (!isVideoRecordStarted()) {
                this.h_renamed.block();
            }
            com.oplus.camera.e_renamed.a_renamed("TimeLapseProMode", "forceStopVideoRecording, mRecordSig.block X_renamed");
            k_renamed(z_renamed);
        }
    }

    private boolean Z_renamed() {
        com.oplus.camera.e_renamed.a_renamed("TimeLapseProMode", "recDisabledReturn");
        if (!this.g_renamed) {
            return false;
        }
        this.mCameraUIInterface.a_renamed(com.oplus.camera.R_renamed.string.camera_time_lapse_pro_low_battery_hint, -1, true, false, false);
        c_renamed(com.oplus.camera.statistics.model.ReminderMsgData.TYPE_DISABLE_CODE, com.oplus.camera.statistics.model.ReminderMsgData.CODE_BATTERY_VIDEO);
        return true;
    }

    private void c_renamed(java.lang.String str, java.lang.String str2) {
        com.oplus.camera.statistics.model.ReminderMsgData reminderMsgData = new com.oplus.camera.statistics.model.ReminderMsgData(this.mActivity, false);
        if (this.mCameraInterface != null) {
            if (this.mCameraInterface.m_renamed()) {
                reminderMsgData.mCameraEnterType = java.lang.String.valueOf(3);
            }
            reminderMsgData.mCameraId = this.mCameraInterface.ax_renamed();
        }
        reminderMsgData.mCaptureMode = "timeLapse";
        reminderMsgData.mCaptureType = 1;
        reminderMsgData.mOrientation = this.mOrientation;
        reminderMsgData.mReminderTypeValue = str;
        reminderMsgData.mReminderCodeValue = str2;
        reminderMsgData.mbRecording = isVideoRecording();
        reminderMsgData.mRearOrFront = this.mbFrontCamera ? com.oplus.camera.statistics.model.DcsMsgData.FRONT : com.oplus.camera.statistics.model.DcsMsgData.REAR;
        reminderMsgData.report();
    }
}

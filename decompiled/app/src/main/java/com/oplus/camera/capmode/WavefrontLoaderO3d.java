package com.oplus.camera.capmode;

/* compiled from: MicroscopeCaptureMode.java */
/* loaded from: classes2.dex */
public class o_renamed extends com.oplus.camera.capmode.d_renamed {
    private boolean g_renamed;
    private boolean h_renamed;
    private int i_renamed;
    private int j_renamed;
    private com.oplus.camera.capmode.s_renamed k_renamed;
    private com.oplus.camera.ui.MicroscopeHintView.a_renamed l_renamed;
    private android.view.View.OnClickListener m_renamed;
    private android.widget.TextView n_renamed;

    @Override // com.oplus.camera.capmode.d_renamed, com.oplus.camera.capmode.BaseMode
    public java.lang.String getCameraMode() {
        return com.oplus.camera.aps.constant.ApsConstant.CAPTURE_MODE_MICROSCOPE;
    }

    @Override // com.oplus.camera.capmode.d_renamed, com.oplus.camera.capmode.BaseMode
    public java.lang.String getFilterEffectMenuPreferenceKey() {
        return com.oplus.camera.ui.CameraUIInterface.KEY_FILTER_ANC_INDEX;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public int getFilterTitleTexId() {
        return com.oplus.camera.R_renamed.string.camera_filter_effect;
    }

    @Override // com.oplus.camera.capmode.d_renamed, com.oplus.camera.capmode.BaseMode
    public java.lang.String getFlashMode() {
        return com.oplus.ocs.camera.CameraParameter.FlashMode.FLASH_TORCH;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean getFrontEnable() {
        return false;
    }

    @Override // com.oplus.camera.capmode.d_renamed, com.oplus.camera.capmode.BaseMode
    public boolean getSupportSubMenu(java.lang.String str) {
        return false;
    }

    @Override // com.oplus.camera.capmode.d_renamed, com.oplus.camera.capmode.BaseMode
    public boolean isFirstTipsEnable(java.lang.String str) {
        return false;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean isMicroscopeMode() {
        return true;
    }

    @Override // com.oplus.camera.capmode.d_renamed, com.oplus.camera.capmode.BaseMode
    protected boolean isSalientObjectDetectionEnabled() {
        return false;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean isSubMenuEnable() {
        return false;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean onLongPress(android.view.MotionEvent motionEvent) {
        return true;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean withinSatMainRange(float f_renamed) {
        return true;
    }

    public o_renamed(android.app.Activity activity, com.oplus.camera.capmode.a_renamed aVar, com.oplus.camera.ui.CameraUIInterface cameraUIInterface, com.oplus.camera.ui.preview.a_renamed.t_renamed tVar) {
        super(activity, aVar, cameraUIInterface, tVar);
        this.g_renamed = false;
        this.h_renamed = false;
        this.i_renamed = 0;
        this.j_renamed = 0;
        this.k_renamed = new com.oplus.camera.capmode.s_renamed();
        this.l_renamed = null;
        this.m_renamed = null;
        this.n_renamed = null;
    }

    @Override // com.oplus.camera.capmode.d_renamed, com.oplus.camera.capmode.BaseMode
    public boolean needSurface(java.lang.String str) {
        return "type_preview_frame".equals(str) ? 3 == com.oplus.camera.aps.util.AlgoSwitchConfig.getApsVersion() : "type_still_capture_yuv_main".equals(str) || "type_capture".equals(str);
    }

    @Override // com.oplus.camera.capmode.d_renamed, com.oplus.camera.capmode.BaseMode
    public boolean getSupportMenu(java.lang.String str) {
        if (com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_FILTER_MENU.equals(str) || com.oplus.camera.ui.CameraUIInterface.KEY_FILTER_MENU.equals(str)) {
            return getSupportFunction(str);
        }
        return super.getSupportMenu(str);
    }

    /* JADX WARN: Can't_renamed fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B_renamed:74:0x010e  */
    @Override // com.oplus.camera.capmode.d_renamed, com.oplus.camera.capmode.BaseMode
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean getSupportFunction(java.lang.String r5) {
        /*
            Method dump skipped, instructions count: 446
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.capmode.o_renamed.getSupportFunction(java.lang.String):boolean");
    }

    @Override // com.oplus.camera.capmode.d_renamed, com.oplus.camera.capmode.BaseMode
    public void onAfterStartPreview(boolean z_renamed) throws android.content.res.Resources.NotFoundException {
        super.onAfterStartPreview(z_renamed);
        a_renamed();
    }

    @Override // com.oplus.camera.capmode.d_renamed, com.oplus.camera.capmode.BaseMode
    protected void onInitCameraMode() {
        super.onInitCameraMode();
        this.g_renamed = true;
        this.j_renamed = com.oplus.camera.aps.config.CameraConfig.getConfigIntValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_MICRO_GUIDE_ANIM_TYPE);
        sendBoradCastNotifyMicroscopeState(true);
        this.k_renamed.a_renamed(this.mActivity, this.mCameraInterface);
        this.n_renamed = new android.widget.TextView(this.mActivity);
        this.n_renamed.setWillNotDraw(true);
        this.n_renamed.setVisibility(4);
        this.mCameraUIInterface.b_renamed().addView(this.n_renamed, new android.widget.RelativeLayout.LayoutParams(this.mActivity.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.microscope_hint_width), -2));
        this.m_renamed = new android.view.View.OnClickListener() { // from class: com.oplus.camera.capmode.o_renamed.1
            @Override // android.view.View.OnClickListener
            public void onClick(android.view.View view) {
                if (com.oplus.camera.capmode.o_renamed.this.mCameraUIInterface.av_renamed()) {
                    com.oplus.camera.capmode.o_renamed.this.mCameraUIInterface.a_renamed(true, true, false);
                }
                if (com.oplus.camera.capmode.o_renamed.this.g_renamed) {
                    com.oplus.camera.capmode.o_renamed.this.mCameraUIInterface.a_renamed(com.oplus.camera.capmode.o_renamed.this.l_renamed, true, com.oplus.camera.capmode.o_renamed.this.i_renamed);
                }
            }
        };
        this.l_renamed = new com.oplus.camera.ui.MicroscopeHintView.a_renamed() { // from class: com.oplus.camera.capmode.o_renamed.2
            @Override // com.oplus.camera.ui.MicroscopeHintView.a_renamed
            public void a_renamed() {
                if (com.oplus.camera.capmode.o_renamed.this.mbCapModeInit) {
                    com.oplus.camera.capmode.o_renamed.this.mCameraUIInterface.a_renamed(com.oplus.camera.capmode.o_renamed.this.m_renamed, false, true);
                }
            }

            @Override // com.oplus.camera.ui.MicroscopeHintView.a_renamed
            public void b_renamed() {
                if (com.oplus.camera.capmode.o_renamed.this.mbCapModeInit && !com.oplus.camera.capmode.o_renamed.this.mCameraUIInterface.R_renamed()) {
                    com.oplus.camera.capmode.o_renamed.this.mCameraUIInterface.a_renamed(com.oplus.camera.capmode.o_renamed.this.m_renamed, true, true);
                }
                com.oplus.camera.capmode.o_renamed.this.mCameraUIInterface.al_renamed();
            }

            @Override // com.oplus.camera.ui.MicroscopeHintView.a_renamed
            public void c_renamed() {
                if (com.oplus.camera.capmode.o_renamed.this.mbCapModeInit && !com.oplus.camera.capmode.o_renamed.this.mCameraUIInterface.R_renamed()) {
                    com.oplus.camera.capmode.o_renamed.this.mCameraUIInterface.a_renamed(com.oplus.camera.capmode.o_renamed.this.m_renamed, true, true);
                }
                com.oplus.camera.capmode.o_renamed.this.mCameraUIInterface.al_renamed();
            }
        };
    }

    @Override // com.oplus.camera.capmode.d_renamed, com.oplus.camera.capmode.BaseMode
    protected void onPause() {
        super.onPause();
        this.k_renamed.a_renamed(this.mActivity);
        this.mCameraUIInterface.a_renamed(this.l_renamed, false, this.i_renamed);
    }

    @Override // com.oplus.camera.capmode.d_renamed, com.oplus.camera.capmode.BaseMode
    protected void onResume(boolean z_renamed) {
        super.onResume(z_renamed);
        this.k_renamed.a_renamed(this.mActivity, this.mCameraInterface);
    }

    @Override // com.oplus.camera.capmode.d_renamed, com.oplus.camera.capmode.BaseMode
    protected void onDeInitCameraMode(java.lang.String str) {
        super.onDeInitCameraMode(str);
        this.g_renamed = false;
        this.h_renamed = false;
        this.mCameraUIInterface.b_renamed().removeView(this.n_renamed);
        this.mCameraUIInterface.a_renamed(this.l_renamed, false, this.i_renamed);
        this.mCameraUIInterface.a_renamed(this.m_renamed, false, true);
        sendBoradCastNotifyMicroscopeState(false);
        this.k_renamed.a_renamed(this.mActivity);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onTouchFocus() {
        if (!this.mCameraUIInterface.aQ_renamed()) {
            this.mCameraUIInterface.a_renamed(com.oplus.camera.R_renamed.string.camera_hint_distance_microscope, -1, true, false, false);
        }
        super.onTouchFocus();
    }

    @Override // com.oplus.camera.capmode.d_renamed, com.oplus.camera.capmode.BaseMode
    public com.oplus.camera.af_renamed getZoomConfigure() {
        com.oplus.camera.af_renamed zoomConfigure = super.getZoomConfigure();
        zoomConfigure.A_renamed(true);
        zoomConfigure.c_renamed(com.oplus.camera.aps.config.CameraConfig.getConfigIntValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_MICROSCOPE_ZOOM_SCALE_VALUE));
        return zoomConfigure;
    }

    @Override // com.oplus.camera.capmode.d_renamed, com.oplus.camera.capmode.BaseMode
    public com.oplus.camera.ui.control.b_renamed getShutterButtonInfo() {
        com.oplus.camera.ui.control.b_renamed shutterButtonInfo = super.getShutterButtonInfo();
        shutterButtonInfo.c_renamed("button_shape_ring_none");
        return shutterButtonInfo;
    }

    @Override // com.oplus.camera.capmode.d_renamed, com.oplus.camera.capmode.BaseMode
    public android.util.Size getPictureSize(com.oplus.camera.e_renamed.h_renamed hVar) {
        return com.oplus.camera.util.Util.b_renamed(hVar.a_renamed(256), "standard".equals(com.oplus.camera.aps.config.CameraConfig.getConfigStringValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_MICRO_PICTURE_SIZE_RATIO)) ? 1.3333333333333333d : 1.0d);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public com.oplus.camera.ui.preview.a_renamed.l_renamed.a_renamed getFilterCategory() {
        return com.oplus.camera.ui.preview.a_renamed.l_renamed.a_renamed.Anc;
    }

    @Override // com.oplus.camera.capmode.d_renamed, com.oplus.camera.capmode.BaseMode
    protected java.util.List<java.lang.Integer> getFilterNameIdList(int i_renamed) {
        return com.oplus.camera.ui.preview.a_renamed.j_renamed.f_renamed.d_renamed;
    }

    @Override // com.oplus.camera.capmode.d_renamed, com.oplus.camera.capmode.BaseMode
    protected java.util.List<java.lang.String> getFilterTypeList(int i_renamed) {
        return com.oplus.camera.ui.preview.a_renamed.j_renamed.f_renamed.f6903b;
    }

    @Override // com.oplus.camera.capmode.d_renamed, com.oplus.camera.capmode.BaseMode
    public void onMoreModeShown() {
        super.onMoreModeShown();
        this.mCameraUIInterface.a_renamed(this.l_renamed, false, this.i_renamed);
        this.mCameraUIInterface.a_renamed(this.m_renamed, false, true);
    }

    @Override // com.oplus.camera.capmode.d_renamed, com.oplus.camera.capmode.BaseMode
    public void onMoreModeHidden(int i_renamed) throws android.content.res.Resources.NotFoundException {
        super.onMoreModeHidden(i_renamed);
        a_renamed();
    }

    private void a_renamed() throws android.content.res.Resources.NotFoundException {
        java.lang.String string;
        if (this.h_renamed) {
            if (this.mPreferences.getBoolean(com.oplus.camera.ui.CameraUIInterface.KEY_MICROSCOPE_GUIDE_SHOW_NEED, true)) {
                this.mCameraUIInterface.a_renamed(this.l_renamed, true, this.i_renamed);
                return;
            } else {
                this.mCameraUIInterface.a_renamed(this.m_renamed, true, true);
                return;
            }
        }
        java.lang.String string2 = this.mActivity.getResources().getString(com.oplus.camera.R_renamed.string.camera_hint_microscope_step1);
        java.lang.String string3 = this.mActivity.getResources().getString(com.oplus.camera.R_renamed.string.camera_hint_microscope_step2);
        int i_renamed = this.j_renamed;
        if (i_renamed == 0) {
            string = this.mActivity.getResources().getString(com.oplus.camera.R_renamed.string.camera_hint_microscope_step2);
        } else {
            string = i_renamed != 1 ? string3 : this.mActivity.getResources().getString(com.oplus.camera.R_renamed.string.camera_hint_microscope_step2_lift_head);
        }
        android.widget.TextView textView = this.n_renamed;
        if (string2.length() <= string.length()) {
            string2 = string;
        }
        textView.setText(string2);
        this.n_renamed.getViewTreeObserver().addOnGlobalLayoutListener(new android.view.ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.oplus.camera.capmode.o_renamed.3
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                com.oplus.camera.capmode.o_renamed oVar = com.oplus.camera.capmode.o_renamed.this;
                oVar.i_renamed = oVar.n_renamed.getHeight();
                com.oplus.camera.capmode.o_renamed.this.h_renamed = true;
                if (com.oplus.camera.capmode.o_renamed.this.mPreferences.getBoolean(com.oplus.camera.ui.CameraUIInterface.KEY_MICROSCOPE_GUIDE_SHOW_NEED, true)) {
                    com.oplus.camera.capmode.o_renamed.this.mCameraUIInterface.a_renamed(com.oplus.camera.capmode.o_renamed.this.l_renamed, true, com.oplus.camera.capmode.o_renamed.this.i_renamed);
                } else {
                    com.oplus.camera.capmode.o_renamed.this.mCameraUIInterface.a_renamed(com.oplus.camera.capmode.o_renamed.this.m_renamed, true, true);
                }
                com.oplus.camera.capmode.o_renamed.this.n_renamed.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            }
        });
    }

    @Override // com.oplus.camera.capmode.d_renamed, com.oplus.camera.capmode.BaseMode
    protected boolean onBeforeSnapping(com.oplus.camera.e_renamed.c_renamed cVar) {
        boolean zOnBeforeSnapping = super.onBeforeSnapping(cVar);
        this.mbCheckTakeAnimateDelay = false;
        return zOnBeforeSnapping;
    }
}

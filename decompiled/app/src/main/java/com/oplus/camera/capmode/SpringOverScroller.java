package com.oplus.camera.capmode;

/* compiled from: XPanMode.java */
/* loaded from: classes2.dex */
public class y_renamed extends com.oplus.camera.capmode.BaseMode {
    private static final java.lang.String g_renamed = "y_renamed";
    private static final android.view.animation.PathInterpolator h_renamed = new android.view.animation.PathInterpolator(0.8f, 0.0f, 0.15f, 0.65f);
    private static final android.util.Size i_renamed = new android.util.Size(com.oplus.camera.capmode.w_renamed.VIDEO_1080P_WIDTH, 864);
    private final int j_renamed;
    private final int k_renamed;
    private boolean l_renamed;
    private int m_renamed;
    private int n_renamed;
    private float o_renamed;
    private float p_renamed;
    private com.oplus.camera.capmode.y_renamed.a_renamed q_renamed;
    private android.widget.ImageView r_renamed;
    private android.widget.ImageView s_renamed;
    private android.widget.ImageButton t_renamed;
    private android.widget.ImageButton u_renamed;
    private com.oplus.camera.ui.SwitchCameraBar v_renamed;
    private android.view.ViewGroup w_renamed;
    private com.oplus.camera.ui.widget.XPanExposureWheel x_renamed;
    private final java.lang.Runnable y_renamed;

    @Override // com.oplus.camera.capmode.BaseMode
    protected boolean checkPreviewResult(com.oplus.camera.aps.util.CameraApsDecision cameraApsDecision) {
        return true;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public java.lang.String getCameraMode() {
        return com.oplus.camera.aps.constant.ApsConstant.CAPTURE_MODE_XPAN;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public java.lang.String getFilterEffectMenuPreferenceKey() {
        return com.oplus.camera.ui.CameraUIInterface.KEY_HASSELBLAD_XPAN_FILTER_INDEX;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean getFrontEnable() {
        return false;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public int getOperatingMode() {
        return 32940;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean getRearEnable() {
        return true;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean getSupportMenu(java.lang.String str) {
        return false;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean getTouchEnable(boolean z_renamed, int i2, int i3) {
        return true;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void onDestroy() {
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void onPause() {
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void onStop() {
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected boolean onStopTakePicture() {
        return false;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean showBeautyButton() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void m_renamed() {
        com.oplus.camera.capmode.y_renamed.a_renamed aVar = this.q_renamed;
        if (aVar == null || aVar.f_renamed == null) {
            com.oplus.camera.e_renamed.e_renamed(g_renamed, "CaptureAnimation, No valid frame bitmap to draw");
            this.r_renamed.setVisibility(8);
        } else {
            this.r_renamed.setImageDrawable(this.q_renamed);
            this.r_renamed.setVisibility(0);
            a_renamed(8);
            this.q_renamed.a_renamed(3500L, new java.lang.Runnable() { // from class: com.oplus.camera.capmode.-$$Lambda$y_renamed$anCMw6uDgQakFdnTD2zxIzeSoAM
                @Override // java.lang.Runnable
                public final void run() {
                    this.f_renamed$0.n_renamed();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void n_renamed() {
        a_renamed(0);
        this.r_renamed.animate().scaleX(0.15f).scaleY(0.06f).translationXBy(this.o_renamed).translationYBy(this.p_renamed).setDuration(300L).withEndAction(new java.lang.Runnable() { // from class: com.oplus.camera.capmode.-$$Lambda$y_renamed$MtkKmDs8tpx0JlYs03znV11n4ds
            @Override // java.lang.Runnable
            public final void run() {
                this.f_renamed$0.o_renamed();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void o_renamed() {
        this.r_renamed.setScaleX(1.0f);
        this.r_renamed.setScaleY(1.0f);
        this.r_renamed.setTranslationX(0.0f);
        this.r_renamed.setTranslationY(0.0f);
        this.r_renamed.setImageDrawable(null);
        this.r_renamed.setVisibility(8);
        this.q_renamed.a_renamed((android.graphics.Bitmap) null);
        this.l_renamed = false;
    }

    public y_renamed(android.app.Activity activity, com.oplus.camera.capmode.a_renamed aVar, com.oplus.camera.ui.CameraUIInterface cameraUIInterface, com.oplus.camera.ui.preview.a_renamed.t_renamed tVar) {
        super(activity, aVar, cameraUIInterface, tVar);
        this.l_renamed = false;
        this.m_renamed = Integer.MIN_VALUE;
        this.n_renamed = -1;
        this.q_renamed = null;
        this.r_renamed = null;
        this.s_renamed = null;
        this.t_renamed = null;
        this.u_renamed = null;
        this.v_renamed = null;
        this.w_renamed = null;
        this.x_renamed = null;
        this.y_renamed = new java.lang.Runnable() { // from class: com.oplus.camera.capmode.-$$Lambda$y_renamed$pBNcj-Z7x4mKREDvjGd488n8qps
            @Override // java.lang.Runnable
            public final void run() {
                this.f_renamed$0.m_renamed();
            }
        };
        boolean z_renamed = 1 == androidx.core.f_renamed.f_renamed.a_renamed(java.util.Locale.getDefault());
        this.o_renamed = activity.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.xpan_mode_capture_animation_trans_x);
        this.o_renamed *= z_renamed ? 1.0f : -1.0f;
        this.p_renamed = activity.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.xpan_mode_capture_animation_trans_y);
        this.j_renamed = activity.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.xpan_mode_switch_camera_bar_margin_left);
        this.k_renamed = activity.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.xpan_mode_ev_wheel_width);
    }

    private void a_renamed(android.view.ViewGroup viewGroup, boolean z_renamed) {
        if (this.mActivity == null || this.mPreferences == null) {
            return;
        }
        if (!z_renamed) {
            com.oplus.camera.e_renamed.b_renamed(g_renamed, "No need to display the selection SwitchCameraBar");
            return;
        }
        this.v_renamed = (com.oplus.camera.ui.SwitchCameraBar) this.mActivity.getLayoutInflater().inflate(com.oplus.camera.R_renamed.layout.hasselblad_xpan_switch_camera_layout, viewGroup).findViewById(com.oplus.camera.R_renamed.id_renamed.switch_camera_bar);
        this.v_renamed.a_renamed(d_renamed(), false, true, new int[]{com.oplus.camera.R_renamed.drawable.icon_xpan_zoom_30mm, com.oplus.camera.R_renamed.drawable.icon_xpan_zoom_45mm});
        android.view.ViewGroup.MarginLayoutParams marginLayoutParams = new android.view.ViewGroup.MarginLayoutParams(this.v_renamed.getLayoutParams());
        marginLayoutParams.leftMargin = this.j_renamed;
        this.v_renamed.a_renamed(true);
        this.v_renamed.a_renamed(marginLayoutParams);
        this.v_renamed.setRotation(90.0f);
        this.v_renamed.setClickListener(new com.oplus.camera.ui.SwitchCameraBar.a_renamed() { // from class: com.oplus.camera.capmode.y_renamed.1
            @Override // com.oplus.camera.ui.SwitchCameraBar.a_renamed
            public void a_renamed(java.lang.String str) {
                if (str.equals(com.oplus.camera.capmode.y_renamed.this.d_renamed())) {
                    return;
                }
                com.oplus.camera.capmode.y_renamed.this.l_renamed();
                com.oplus.camera.capmode.y_renamed.this.mPreferences.edit().putString(com.oplus.camera.ui.CameraUIInterface.KEY_XPAN_SWITCH_CAMERA_BAR, str).apply();
            }

            @Override // com.oplus.camera.ui.SwitchCameraBar.a_renamed
            public boolean a_renamed() {
                return com.oplus.camera.capmode.y_renamed.this.r_renamed.getVisibility() == 8;
            }
        });
    }

    private void c_renamed() {
        if (this.w_renamed == null) {
            return;
        }
        com.oplus.camera.ui.SwitchCameraBar switchCameraBar = this.v_renamed;
        if (switchCameraBar != null) {
            switchCameraBar.a_renamed((android.view.ViewGroup.MarginLayoutParams) null);
            this.w_renamed.removeView(this.v_renamed);
        }
        com.oplus.camera.util.Util.a_renamed(this.w_renamed, 8, (android.view.animation.Animation.AnimationListener) null, 0L);
        com.oplus.camera.util.Util.a_renamed(this.s_renamed, 8, (android.view.animation.Animation.AnimationListener) null, 0L);
        com.oplus.camera.util.Util.a_renamed(this.x_renamed, 8, (android.view.animation.Animation.AnimationListener) null, 0L);
        com.oplus.camera.util.Util.a_renamed(this.t_renamed, 8, (android.view.animation.Animation.AnimationListener) null, 0L);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean dispatchTouchEvent(android.view.MotionEvent motionEvent) {
        if (1 != motionEvent.getAction()) {
            return false;
        }
        this.n_renamed = -1;
        return false;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected int getJpegOrientation(int i2, int i3) {
        return com.oplus.camera.e_renamed.a_renamed.b_renamed(getCameraInfo(i2), 270);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public android.util.Size getPreviewSize(com.oplus.camera.e_renamed.h_renamed hVar) {
        return i_renamed;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public android.util.Size getPictureSize(com.oplus.camera.e_renamed.h_renamed hVar) {
        android.util.Size sizeConfigValue;
        if ("camera_main".equals(d_renamed())) {
            sizeConfigValue = com.oplus.camera.aps.config.CameraConfig.getSizeConfigValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_HASSELBALD_XPAN_MAIN_PICTURE_SIZE, this.mCameraId);
        } else {
            sizeConfigValue = com.oplus.camera.aps.config.CameraConfig.getSizeConfigValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_HASSELBALD_XPAN_WIDE_PICTURE_SIZE, this.mCameraId);
        }
        return this.mCameraInterface.u_renamed() % 180 == 0 ? new android.util.Size(sizeConfigValue.getHeight(), sizeConfigValue.getWidth()) : sizeConfigValue;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public com.oplus.camera.ui.control.b_renamed getShutterButtonInfo() {
        com.oplus.camera.ui.control.b_renamed shutterButtonInfo = super.getShutterButtonInfo();
        if (com.oplus.camera.util.Util.ao_renamed()) {
            if (this.mCameraUIInterface.s_renamed() == 28 || this.mCameraUIInterface.s_renamed() == 29 || this.mCameraUIInterface.s_renamed() == 26) {
                shutterButtonInfo.a_renamed(26);
            } else {
                shutterButtonInfo.a_renamed(23);
            }
        }
        return shutterButtonInfo;
    }

    /* JADX WARN: Can't_renamed fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B_renamed:50:0x00b1  */
    @Override // com.oplus.camera.capmode.BaseMode
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean getSupportFunction(java.lang.String r4) {
        /*
            r3 = this;
            java.lang.String r4 = com.oplus.camera.entry.b_renamed.d_renamed(r4)
            int r0 = r4.hashCode()
            r1 = 1
            r2 = 0
            switch(r0) {
                case -1842599352: goto La6;
                case -1693318428: goto L9c;
                case -1616879029: goto L91;
                case -1593450737: goto L86;
                case -100202123: goto L7c;
                case 121201516: goto L72;
                case 336270991: goto L67;
                case 516394958: goto L5d;
                case 638398481: goto L53;
                case 839269120: goto L49;
                case 1062270711: goto L3d;
                case 1599576324: goto L32;
                case 1706373443: goto L26;
                case 1961723364: goto L1a;
                case 2115588522: goto Lf;
                default: goto Ld;
            }
        Ld:
            goto Lb1
        Lf:
            java.lang.String r0 = "pref_filter_menu"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto Lb1
            r0 = r2
            goto Lb2
        L1a:
            java.lang.String r0 = "pref_filter_process_key"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto Lb1
            r0 = 10
            goto Lb2
        L26:
            java.lang.String r0 = "pref_support_capture_preview"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto Lb1
            r0 = 12
            goto Lb2
        L32:
            java.lang.String r0 = "pref_support_switch_camera"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto Lb1
            r0 = 3
            goto Lb2
        L3d:
            java.lang.String r0 = "pref_time_lapse_key"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto Lb1
            r0 = 9
            goto Lb2
        L49:
            java.lang.String r0 = "key_setting_support"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto Lb1
            r0 = 6
            goto Lb2
        L53:
            java.lang.String r0 = "key_support_share_edit_thumb"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto Lb1
            r0 = 7
            goto Lb2
        L5d:
            java.lang.String r0 = "key_setting_menu"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto Lb1
            r0 = 4
            goto Lb2
        L67:
            java.lang.String r0 = "pref_zoom_key"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto Lb1
            r0 = 8
            goto Lb2
        L72:
            java.lang.String r0 = "pref_support_recording_capture"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto Lb1
            r0 = 5
            goto Lb2
        L7c:
            java.lang.String r0 = "pref_burst_shot_key"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto Lb1
            r0 = r1
            goto Lb2
        L86:
            java.lang.String r0 = "pref_watermark_function_key"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto Lb1
            r0 = 11
            goto Lb2
        L91:
            java.lang.String r0 = "pref_hasselblad_xpan_exposure_key"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto Lb1
            r0 = 14
            goto Lb2
        L9c:
            java.lang.String r0 = "pref_manual_exposure_key"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto Lb1
            r0 = 2
            goto Lb2
        La6:
            java.lang.String r0 = "key_full_screen_center_support"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto Lb1
            r0 = 13
            goto Lb2
        Lb1:
            r0 = -1
        Lb2:
            switch(r0) {
                case 0: goto Ld5;
                case 1: goto Ld5;
                case 2: goto Ld5;
                case 3: goto Ld5;
                case 4: goto Ld5;
                case 5: goto Ld5;
                case 6: goto Ld5;
                case 7: goto Ld5;
                case 8: goto Ld5;
                case 9: goto Ld5;
                case 10: goto Lc8;
                case 11: goto Lbb;
                case 12: goto Lba;
                case 13: goto Lba;
                case 14: goto Lba;
                default: goto Lb5;
            }
        Lb5:
            boolean r3 = super.getSupportFunction(r4)
            return r3
        Lba:
            return r1
        Lbb:
            java.lang.String r4 = r3.getCameraMode()
            int r3 = r3.mCameraId
            java.lang.String r0 = "aps_algo_watermark"
            boolean r3 = com.oplus.camera.aps.util.AlgoSwitchConfig.getSupportCaptureAlgo(r4, r3, r0)
            return r3
        Lc8:
            java.lang.String r4 = r3.getCameraMode()
            int r3 = r3.mCameraId
            java.lang.String r0 = "aps_algo_filter"
            boolean r3 = com.oplus.camera.aps.util.AlgoSwitchConfig.getSupportCaptureAlgo(r4, r3, r0)
            return r3
        Ld5:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.capmode.y_renamed.getSupportFunction(java.lang.String):boolean");
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected java.util.List<java.lang.String> getFilterTypeList(int i2) {
        return com.oplus.camera.ui.preview.a_renamed.j_renamed.g_renamed.a_renamed(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public java.lang.String d_renamed() {
        return this.mPreferences == null ? "camera_main" : this.mPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_XPAN_SWITCH_CAMERA_BAR, "camera_main");
    }

    private void e_renamed() {
        if (this.w_renamed == null) {
            android.view.ViewStub viewStub = (android.view.ViewStub) this.mActivity.findViewById(com.oplus.camera.R_renamed.id_renamed.xpan_mode_viewstub);
            if (viewStub == null) {
                com.oplus.camera.e_renamed.f_renamed(g_renamed, "initXPanUI, Failed to inflate stub");
                return;
            }
            this.w_renamed = (android.view.ViewGroup) viewStub.inflate().findViewById(com.oplus.camera.R_renamed.id_renamed.xpan_mode_ui_container);
            if (this.w_renamed == null) {
                com.oplus.camera.e_renamed.f_renamed(g_renamed, "initXPanUI, Failed to find container");
                return;
            }
            com.oplus.camera.e_renamed.a_renamed(g_renamed, "initXPanUI, XPAN ui inflated");
            this.x_renamed = (com.oplus.camera.ui.widget.XPanExposureWheel) this.w_renamed.findViewById(com.oplus.camera.R_renamed.id_renamed.xpan_exposure_wheel);
            if (this.x_renamed != null) {
                com.oplus.camera.e_renamed.h_renamed hVarA = com.oplus.camera.e_renamed.a_renamed.a_renamed(getCameraMode(), this.mCameraInterface.aw_renamed());
                if (hVarA == null) {
                    com.oplus.camera.e_renamed.f_renamed(g_renamed, "initXPanUI, Invalid CameraCharacteristics");
                    return;
                } else {
                    this.x_renamed.a_renamed(new com.oplus.camera.ui.widget.XPanExposureWheel.b_renamed() { // from class: com.oplus.camera.capmode.-$$Lambda$y_renamed$sFV432XfGm3pEAO_gVncjNoLRd4
                        @Override // com.oplus.camera.ui.widget.XPanExposureWheel.b_renamed
                        public final void onExposureChanged(int i2) {
                            this.f_renamed$0.b_renamed(i2);
                        }
                    });
                    this.x_renamed.a_renamed(hVarA.p_renamed(), hVarA.q_renamed());
                }
            }
            this.u_renamed = (android.widget.ImageButton) this.w_renamed.findViewById(com.oplus.camera.R_renamed.id_renamed.xpan_mode_filter_toggle_btn);
            android.widget.ImageButton imageButton = this.u_renamed;
            if (imageButton != null) {
                imageButton.setVisibility(0);
                this.u_renamed.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.oplus.camera.capmode.-$$Lambda$y_renamed$NPbov7s7zng74yzpXMga034xqfc
                    @Override // android.view.View.OnClickListener
                    public final void onClick(android.view.View view) {
                        this.f_renamed$0.b_renamed(view);
                    }
                });
            }
            this.s_renamed = (android.widget.ImageView) this.w_renamed.findViewById(com.oplus.camera.R_renamed.id_renamed.dash_line_view);
            this.t_renamed = (android.widget.ImageButton) this.w_renamed.findViewById(com.oplus.camera.R_renamed.id_renamed.xpan_mode_exit_btn);
            android.widget.ImageButton imageButton2 = this.t_renamed;
            if (imageButton2 != null) {
                imageButton2.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.oplus.camera.capmode.-$$Lambda$y_renamed$jqK18NlDmC_5Lb1Sb68VL-bF5gI
                    @Override // android.view.View.OnClickListener
                    public final void onClick(android.view.View view) {
                        this.f_renamed$0.a_renamed(view);
                    }
                });
            }
            this.r_renamed = (android.widget.ImageView) this.w_renamed.findViewById(com.oplus.camera.R_renamed.id_renamed.invertedColorPreviewCover);
        } else {
            com.oplus.camera.e_renamed.a_renamed(g_renamed, "initXPanUI, container is_renamed already existed");
            this.w_renamed.setVisibility(0);
        }
        a_renamed(this.w_renamed, com.oplus.camera.aps.config.CameraConfig.getSizeConfigValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_HASSELBALD_XPAN_WIDE_PICTURE_SIZE, 0) != null);
        if (this.mCameraUIInterface != null) {
            this.mCameraUIInterface.ak_renamed();
            this.mCameraUIInterface.w_renamed(true);
            this.mCameraUIInterface.al_renamed();
            this.mCameraUIInterface.B_renamed(true);
            this.mCameraUIInterface.g_renamed(true, true);
        } else {
            com.oplus.camera.e_renamed.f_renamed(g_renamed, "initXPanUI, No mCameraUIInterface");
        }
        j_renamed();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b_renamed(int i2) {
        com.oplus.camera.e_renamed.a_renamed(g_renamed, "onExposureChanged, value: " + i2);
        if (this.m_renamed == Integer.MIN_VALUE) {
            this.m_renamed = i2;
        }
        this.mOneCamera.a_renamed((android.hardware.camera2.CaptureRequest.Key<android.hardware.camera2.CaptureRequest.Key>) android.hardware.camera2.CaptureRequest.CONTROL_AE_EXPOSURE_COMPENSATION, (android.hardware.camera2.CaptureRequest.Key) java.lang.Integer.valueOf(i2));
        this.mOneCamera.a_renamed((com.oplus.camera.e_renamed.d_renamed.c_renamed) null);
        com.oplus.camera.ae_renamed aeVarAd = this.mCameraInterface.ad_renamed();
        if (aeVarAd != null && this.m_renamed != i2) {
            aeVarAd.d_renamed();
        }
        this.m_renamed = i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b_renamed(android.view.View view) {
        g_renamed();
        j_renamed();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a_renamed(android.view.View view) {
        if (this.mCameraInterface != null) {
            this.mCameraInterface.aC_renamed();
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onSharedPreferenceChanged(android.content.SharedPreferences sharedPreferences, java.lang.String str) {
        super.onSharedPreferenceChanged(sharedPreferences, str);
        f_renamed();
    }

    private void f_renamed() {
        new com.oplus.camera.statistics.model.XPanMsgData(this.mActivity, isFilterEffectOpen(), this.mCameraId).report();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public com.oplus.camera.statistics.model.DcsMsgData onGetBeforeCaptureMsgCommonData(com.oplus.camera.statistics.model.DcsMsgData dcsMsgData) {
        if (dcsMsgData == null || dcsMsgData == null || !(dcsMsgData instanceof com.oplus.camera.statistics.model.CaptureMsgData)) {
            return null;
        }
        com.oplus.camera.statistics.model.CaptureMsgData captureMsgData = (com.oplus.camera.statistics.model.CaptureMsgData) dcsMsgData;
        captureMsgData.mCaptureMode = getCameraMode();
        if (getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_FILTER_PROCESS)) {
            captureMsgData.mFilterType = getCurrFilterType();
        }
        captureMsgData.mTouchEVValue = this.m_renamed;
        return (com.oplus.camera.statistics.model.CaptureMsgData) super.onGetBeforeCaptureMsgCommonData(captureMsgData);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public com.oplus.camera.statistics.model.DcsMsgData onGetAfterCaptureMsgCommonData(com.oplus.camera.statistics.model.DcsMsgData dcsMsgData, com.oplus.camera.Storage.CameraPicture cameraPicture) {
        com.oplus.camera.statistics.model.CaptureMsgData captureMsgData;
        if (dcsMsgData == null || !(dcsMsgData instanceof com.oplus.camera.statistics.model.CaptureMsgData)) {
            captureMsgData = null;
        } else {
            captureMsgData = (com.oplus.camera.statistics.model.CaptureMsgData) dcsMsgData;
            if (android.text.TextUtils.equals("camera_ultra_wide", this.mPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_XPAN_SWITCH_CAMERA_BAR, "camera_main"))) {
                captureMsgData.mIsWideAngle = "on_renamed";
            } else {
                captureMsgData.mIsWideAngle = "off";
            }
        }
        return (com.oplus.camera.statistics.model.CaptureMsgData) super.onGetAfterCaptureMsgCommonData(captureMsgData, cameraPicture);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void onInitCameraMode() {
        e_renamed();
        if (this.mCameraUIInterface != null) {
            this.mCameraUIInterface.b_renamed(4, true);
        }
    }

    private void g_renamed() {
        java.lang.String filterEffectMenuPreferenceKey = getFilterEffectMenuPreferenceKey();
        if (this.mPreferences.getInt(filterEffectMenuPreferenceKey, com.oplus.camera.ui.preview.a_renamed.j_renamed.f6905a) == com.oplus.camera.ui.preview.a_renamed.j_renamed.f6905a) {
            this.mOneCamera.a_renamed("Delta400.3dl.rgb.bin", isFilterOpen("Delta400.3dl.rgb.bin"), false);
            this.mPreviewEffectProcess.a_renamed("Delta400.3dl.rgb.bin");
            this.mPreferences.edit().putInt(filterEffectMenuPreferenceKey, com.oplus.camera.ui.preview.a_renamed.j_renamed.g_renamed.f6903b.indexOf("Delta400.3dl.rgb.bin")).apply();
        } else {
            this.mOneCamera.a_renamed("default", false, false);
            this.mPreviewEffectProcess.a_renamed("default");
            this.mPreferences.edit().putInt(filterEffectMenuPreferenceKey, com.oplus.camera.ui.preview.a_renamed.j_renamed.f6905a).apply();
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void onDeInitCameraMode(java.lang.String str) {
        c_renamed();
        if (this.mCameraUIInterface != null) {
            this.mCameraUIInterface.aj_renamed();
            this.mCameraUIInterface.al_renamed();
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean onBackPressed() {
        com.oplus.camera.capmode.y_renamed.a_renamed aVar = this.q_renamed;
        if ((aVar != null && (aVar.a_renamed() == com.oplus.camera.capmode.y_renamed.a_renamed.XPanMode_4.ANIMATION_ANIMATING || this.q_renamed.a_renamed() == com.oplus.camera.capmode.y_renamed.a_renamed.XPanMode_4.ANIMATION_STARTED)) || this.r_renamed.getVisibility() == 0) {
            com.oplus.camera.e_renamed.b_renamed(g_renamed, "onBackPressed() - Invalid state, ignore back pressed");
            return true;
        }
        return super.onBackPressed();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void onBeforePreview() {
        h_renamed();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onAfterStartPreview(boolean z_renamed) {
        super.onAfterStartPreview(z_renamed);
        k_renamed();
        if (this.q_renamed == null || com.oplus.camera.capmode.y_renamed.a_renamed.XPanMode_4.ANIMATION_ANIMATING != this.q_renamed.a_renamed()) {
            l_renamed();
        }
        this.mCameraUIInterface.j_renamed(true, false);
    }

    private void h_renamed() {
        if (this.m_renamed != Integer.MIN_VALUE) {
            com.oplus.camera.e_renamed.b_renamed(g_renamed, "syncExposureWithEvWheel, current ev_renamed: " + this.m_renamed);
            this.mOneCamera.a_renamed((android.hardware.camera2.CaptureRequest.Key<android.hardware.camera2.CaptureRequest.Key>) android.hardware.camera2.CaptureRequest.CONTROL_AE_EXPOSURE_COMPENSATION, (android.hardware.camera2.CaptureRequest.Key) java.lang.Integer.valueOf(this.m_renamed));
            this.mOneCamera.a_renamed((com.oplus.camera.e_renamed.d_renamed.c_renamed) null);
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected boolean onBeforeSnapping(com.oplus.camera.e_renamed.c_renamed cVar) {
        if ("camera_main".equals(d_renamed())) {
            this.mOneCamera.a_renamed((com.oplus.ocs.camera.CameraParameter.PreviewKey<com.oplus.ocs.camera.CameraParameter.PreviewKey<int[]>>) com.oplus.ocs.camera.CameraParameter.HASSELBLAD_XPAN_CROP_REGION, (com.oplus.ocs.camera.CameraParameter.PreviewKey<int[]>) new int[]{64, 360, 7872, 2916});
            return true;
        }
        this.mOneCamera.a_renamed((com.oplus.ocs.camera.CameraParameter.PreviewKey<com.oplus.ocs.camera.CameraParameter.PreviewKey<int[]>>) com.oplus.ocs.camera.CameraParameter.HASSELBLAD_XPAN_CROP_REGION, (com.oplus.ocs.camera.CameraParameter.PreviewKey<int[]>) new int[]{320, 463, 7552, 2798});
        return true;
    }

    /* compiled from: XPanMode.java */
    /* renamed from: com.oplus.camera.capmode.y_renamed$2, reason: invalid class name */
    class XPanMode_2 extends com.oplus.camera.gl_renamed.t_renamed.b_renamed {
        XPanMode_2() {
        }

        @Override // com.oplus.camera.gl_renamed.t_renamed.b_renamed
        public void a_renamed(java.lang.Integer num, final android.graphics.Bitmap bitmap, long j_renamed, long j2, android.hardware.camera2.CaptureResult captureResult) {
            com.oplus.camera.e_renamed.a_renamed(com.oplus.camera.capmode.y_renamed.g_renamed, "onPreviewCaptured, timestamp: " + j2 + ", bitmap: " + bitmap + ", width: " + bitmap.getWidth() + ", height: " + bitmap.getHeight());
            com.oplus.camera.capmode.y_renamed.this.mActivity.runOnUiThread(new java.lang.Runnable() { // from class: com.oplus.camera.capmode.-$$Lambda$y_renamed$2$RNKW3bNtx9oRl6GTyvUB2s4ClEo
                @Override // java.lang.Runnable
                public final void run() {
                    this.f_renamed$0.b_renamed(bitmap);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b_renamed(android.graphics.Bitmap bitmap) {
            com.oplus.camera.capmode.y_renamed.this.a_renamed(bitmap);
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onStartCapturePreviewData() {
        this.mCameraUIInterface.a_renamed((com.oplus.camera.gl_renamed.t_renamed.b_renamed) new com.oplus.camera.capmode.y_renamed.XPanMode_2(), true, getNeedCheckTimeStamp(), com.oplus.camera.gl_renamed.t_renamed.b_renamed.f_renamed);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a_renamed(android.graphics.Bitmap bitmap) {
        com.oplus.camera.e_renamed.b_renamed(g_renamed, "onPreviewFrameCaptured, bitmap width: " + bitmap.getWidth() + ", height: " + bitmap.getHeight());
        com.oplus.camera.capmode.y_renamed.a_renamed aVar = this.q_renamed;
        if (aVar == null) {
            this.q_renamed = new com.oplus.camera.capmode.y_renamed.a_renamed();
        } else {
            aVar.a_renamed((android.graphics.Bitmap) null);
        }
        this.q_renamed.a_renamed(bitmap);
        if (this.l_renamed) {
            i_renamed();
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void onAfterPictureTaken(byte[] bArr, boolean z_renamed) {
        this.mCameraUIInterface.d_renamed(true, false);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void onShutterCallback(boolean z_renamed, boolean z2) {
        if (!z2) {
            com.oplus.camera.e_renamed.a_renamed(g_renamed, "isBurstShot: " + z_renamed + ", isFirst: " + z2);
            return;
        }
        this.mCameraInterface.c_renamed(0);
        this.r_renamed.setVisibility(0);
        i_renamed();
        this.l_renamed = true;
        super.onShutterCallback(z_renamed, z2);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean onScroll(android.view.MotionEvent motionEvent, android.view.MotionEvent motionEvent2, float f_renamed, float f2) {
        if (motionEvent2.getPointerCount() != 1) {
            com.oplus.camera.e_renamed.b_renamed(g_renamed, "onScroll, Ignore multi-fingers.");
            return false;
        }
        if (java.lang.Math.abs(f_renamed) >= java.lang.Math.abs(f2)) {
            return a_renamed(motionEvent, motionEvent2);
        }
        return true;
    }

    private boolean a_renamed(android.view.MotionEvent motionEvent, android.view.MotionEvent motionEvent2) {
        com.oplus.camera.ui.widget.XPanExposureWheel xPanExposureWheel = this.x_renamed;
        if (xPanExposureWheel == null) {
            return false;
        }
        if (this.n_renamed == -1) {
            this.n_renamed = xPanExposureWheel.getValue();
        }
        int x_renamed = (int) ((((motionEvent.getX() - motionEvent2.getX()) / this.k_renamed) * this.x_renamed.getMaxValue()) / 10.0f);
        int i2 = this.n_renamed;
        int i3 = x_renamed * 10;
        if (i2 + i3 >= 0 && i2 + i3 < 5) {
            this.x_renamed.setValue(0);
            return true;
        }
        if (this.x_renamed.getMaxValue() - 5 <= this.n_renamed + i3 && this.x_renamed.getValue() < this.n_renamed + i3) {
            com.oplus.camera.ui.widget.XPanExposureWheel xPanExposureWheel2 = this.x_renamed;
            xPanExposureWheel2.setValue(xPanExposureWheel2.getMaxValue());
            return true;
        }
        this.x_renamed.setValue(this.n_renamed + i3);
        return true;
    }

    private void i_renamed() {
        if (android.os.Looper.getMainLooper().getThread() != java.lang.Thread.currentThread()) {
            this.mActivity.runOnUiThread(this.y_renamed);
        } else {
            this.y_renamed.run();
        }
    }

    private void a_renamed(int i2) {
        com.oplus.camera.util.Util.a_renamed(this.s_renamed, i2, (android.view.animation.Animation.AnimationListener) null, i2 == 8 ? 0L : 300L);
        com.oplus.camera.util.Util.a_renamed(this.x_renamed, i2, (android.view.animation.Animation.AnimationListener) null, i2 == 8 ? 0L : 300L);
        com.oplus.camera.util.Util.a_renamed(this.u_renamed, i2, (android.view.animation.Animation.AnimationListener) null, i2 == 8 ? 0L : 300L);
        com.oplus.camera.util.Util.a_renamed(this.t_renamed, i2, (android.view.animation.Animation.AnimationListener) null, i2 == 8 ? 0L : 300L);
        com.oplus.camera.util.Util.a_renamed(this.v_renamed, i2, (android.view.animation.Animation.AnimationListener) null, i2 != 8 ? 300L : 0L);
    }

    private void j_renamed() {
        if (this.u_renamed == null) {
            return;
        }
        this.u_renamed.setSelected(this.mPreferences.getInt(getFilterEffectMenuPreferenceKey(), com.oplus.camera.ui.preview.a_renamed.j_renamed.f6905a) != com.oplus.camera.ui.preview.a_renamed.j_renamed.f6905a);
    }

    private void k_renamed() {
        if (this.w_renamed == null || this.r_renamed == null || this.mCameraUIInterface == null) {
            return;
        }
        android.widget.RelativeLayout relativeLayoutP = this.mCameraUIInterface.p_renamed();
        if (relativeLayoutP == null) {
            com.oplus.camera.e_renamed.b_renamed(g_renamed, "updateCaptureAnimationImageView, viewFinderLayout is_renamed not available");
            return;
        }
        com.oplus.camera.e_renamed.b_renamed(g_renamed, "updateCaptureAnimationImageView, viewFinderLayout width: " + relativeLayoutP.getWidth() + ", height: " + relativeLayoutP.getHeight());
        android.view.ViewGroup.LayoutParams layoutParams = this.r_renamed.getLayoutParams();
        layoutParams.width = relativeLayoutP.getWidth();
        layoutParams.height = relativeLayoutP.getHeight();
        this.r_renamed.requestLayout();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l_renamed() {
        if (this.w_renamed == null || this.s_renamed == null) {
            return;
        }
        float height = this.mCameraUIInterface.p_renamed().getHeight() * (android.text.TextUtils.equals("camera_ultra_wide", this.mPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_XPAN_SWITCH_CAMERA_BAR, "camera_main")) ? 0.9218f : 0.984f);
        float screenHeight = (com.oplus.camera.util.Util.getScreenHeight() - height) / 2.0f;
        float screenWidth = (com.oplus.camera.util.Util.getScreenWidth() - (height / 2.7f)) / 2.0f;
        android.animation.AnimatorSet animatorSet = new android.animation.AnimatorSet();
        java.util.ArrayList arrayList = new java.util.ArrayList();
        android.view.ViewGroup.LayoutParams layoutParams = this.s_renamed.getLayoutParams();
        if (layoutParams instanceof android.view.ViewGroup.MarginLayoutParams) {
            final android.view.ViewGroup.MarginLayoutParams marginLayoutParams = (android.view.ViewGroup.MarginLayoutParams) layoutParams;
            float f_renamed = marginLayoutParams.topMargin;
            float f2 = marginLayoutParams.bottomMargin;
            float f3 = marginLayoutParams.leftMargin;
            float f4 = marginLayoutParams.rightMargin;
            float f5 = screenHeight - 6.0f;
            android.animation.ValueAnimator valueAnimatorOfFloat = android.animation.ValueAnimator.ofFloat(f_renamed, f5);
            valueAnimatorOfFloat.setDuration(150L);
            valueAnimatorOfFloat.setInterpolator(new android.view.animation.DecelerateInterpolator());
            valueAnimatorOfFloat.addUpdateListener(new android.animation.ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.capmode.-$$Lambda$y_renamed$dStWm83G88wqCytSrPVCyEXmqxU
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
                    this.f_renamed$0.d_renamed(marginLayoutParams, valueAnimator);
                }
            });
            arrayList.add(valueAnimatorOfFloat);
            android.animation.ValueAnimator valueAnimatorOfFloat2 = android.animation.ValueAnimator.ofFloat(f2, f5);
            valueAnimatorOfFloat2.setDuration(150L);
            valueAnimatorOfFloat2.setInterpolator(new android.view.animation.DecelerateInterpolator());
            valueAnimatorOfFloat2.addUpdateListener(new android.animation.ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.capmode.-$$Lambda$y_renamed$PPGK-2zoX4P4w9shmtadKRd2zWE
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
                    com.oplus.camera.capmode.y_renamed.c_renamed(marginLayoutParams, valueAnimator);
                }
            });
            arrayList.add(valueAnimatorOfFloat2);
            float f6 = screenWidth - 6.0f;
            android.animation.ValueAnimator valueAnimatorOfFloat3 = android.animation.ValueAnimator.ofFloat(f3, f6);
            valueAnimatorOfFloat3.setDuration(150L);
            valueAnimatorOfFloat3.setInterpolator(new android.view.animation.DecelerateInterpolator());
            valueAnimatorOfFloat3.addUpdateListener(new android.animation.ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.capmode.-$$Lambda$y_renamed$NVrce6vqb5FteICerDiiS57fdI4
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
                    com.oplus.camera.capmode.y_renamed.b_renamed(marginLayoutParams, valueAnimator);
                }
            });
            arrayList.add(valueAnimatorOfFloat3);
            android.animation.ValueAnimator valueAnimatorOfFloat4 = android.animation.ValueAnimator.ofFloat(f4, f6);
            valueAnimatorOfFloat4.setDuration(150L);
            valueAnimatorOfFloat4.setInterpolator(new android.view.animation.DecelerateInterpolator());
            valueAnimatorOfFloat4.addUpdateListener(new android.animation.ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.capmode.-$$Lambda$y_renamed$7xuwn04CC0zVf09-ApgIKAcc75g
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
                    com.oplus.camera.capmode.y_renamed.a_renamed(marginLayoutParams, valueAnimator);
                }
            });
            arrayList.add(valueAnimatorOfFloat4);
            animatorSet.playTogether(arrayList);
            animatorSet.start();
        }
        android.widget.ImageView imageView = this.s_renamed;
        if (imageView == null || 8 != imageView.getVisibility()) {
            return;
        }
        com.oplus.camera.util.Util.a_renamed(this.v_renamed, 0, (android.view.animation.Animation.AnimationListener) null, 0L);
        com.oplus.camera.util.Util.a_renamed(this.s_renamed, 0, (android.view.animation.Animation.AnimationListener) null, 0L);
        com.oplus.camera.util.Util.a_renamed(this.x_renamed, 0, (android.view.animation.Animation.AnimationListener) null, 0L);
        com.oplus.camera.util.Util.a_renamed(this.t_renamed, 0, (android.view.animation.Animation.AnimationListener) null, 0L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d_renamed(android.view.ViewGroup.MarginLayoutParams marginLayoutParams, android.animation.ValueAnimator valueAnimator) {
        marginLayoutParams.topMargin = ((java.lang.Float) valueAnimator.getAnimatedValue()).intValue();
        this.s_renamed.requestLayout();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void c_renamed(android.view.ViewGroup.MarginLayoutParams marginLayoutParams, android.animation.ValueAnimator valueAnimator) {
        marginLayoutParams.bottomMargin = ((java.lang.Float) valueAnimator.getAnimatedValue()).intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void b_renamed(android.view.ViewGroup.MarginLayoutParams marginLayoutParams, android.animation.ValueAnimator valueAnimator) {
        marginLayoutParams.leftMargin = ((java.lang.Float) valueAnimator.getAnimatedValue()).intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a_renamed(android.view.ViewGroup.MarginLayoutParams marginLayoutParams, android.animation.ValueAnimator valueAnimator) {
        marginLayoutParams.rightMargin = ((java.lang.Float) valueAnimator.getAnimatedValue()).intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: XPanMode.java */
    static class a_renamed extends android.graphics.drawable.Drawable {

        /* renamed from: a_renamed, reason: collision with root package name */
        private final android.graphics.Paint f4353a = new android.graphics.Paint();

        /* renamed from: b_renamed, reason: collision with root package name */
        private final android.graphics.Paint f4354b = new android.graphics.Paint();

        /* renamed from: c_renamed, reason: collision with root package name */
        private final android.graphics.Paint f4355c = new android.graphics.Paint();
        private long d_renamed = 0;
        private long e_renamed = 0;
        private android.graphics.Bitmap f_renamed = null;
        private android.graphics.Bitmap g_renamed = null;
        private java.lang.Runnable h_renamed = null;
        private com.oplus.camera.capmode.y_renamed.a_renamed.XPanMode_4 i_renamed = com.oplus.camera.capmode.y_renamed.a_renamed.XPanMode_4.ANIMATION_IDLE;

        /* compiled from: XPanMode.java */
        /* renamed from: com.oplus.camera.capmode.y_renamed$a_renamed$a_renamed, reason: collision with other inner class name */
        enum XPanMode_4 {
            ANIMATION_IDLE,
            ANIMATION_STARTED,
            ANIMATION_ANIMATING,
            ANIMATING_COMPLETED
        }

        @Override // android.graphics.drawable.Drawable
        public int getOpacity() {
            return -3;
        }

        @Override // android.graphics.drawable.Drawable
        public void setAlpha(int i_renamed) {
        }

        @Override // android.graphics.drawable.Drawable
        public void setColorFilter(android.graphics.ColorFilter colorFilter) {
        }

        public a_renamed() {
            this.f4354b.setColor(-16777216);
            this.f4354b.setStyle(android.graphics.Paint.Style.FILL);
            this.f4353a.setFilterBitmap(true);
            this.f4353a.setColorFilter(new android.graphics.ColorMatrixColorFilter(new float[]{-1.0f, 0.0f, 0.0f, 0.0f, 255.0f, 0.0f, -1.0f, 0.0f, 0.0f, 255.0f, 0.0f, 0.0f, -1.0f, 0.0f, 255.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f}));
            this.f4355c.setFilterBitmap(true);
        }

        @Override // android.graphics.drawable.Drawable
        public void draw(android.graphics.Canvas canvas) {
            android.graphics.Rect bounds = getBounds();
            canvas.drawRect(bounds, this.f4354b);
            android.graphics.Bitmap bitmap = this.g_renamed;
            if (bitmap != null) {
                canvas.drawBitmap(bitmap, (android.graphics.Rect) null, bounds, this.f4355c);
            }
            android.graphics.Bitmap bitmap2 = this.f_renamed;
            if (bitmap2 != null) {
                canvas.drawBitmap(bitmap2, (android.graphics.Rect) null, bounds, this.f4353a);
            }
        }

        public com.oplus.camera.capmode.y_renamed.a_renamed.XPanMode_4 a_renamed() {
            return this.i_renamed;
        }

        public void a_renamed(android.graphics.Bitmap bitmap) {
            this.f_renamed = null;
            this.g_renamed = null;
            this.i_renamed = com.oplus.camera.capmode.y_renamed.a_renamed.XPanMode_4.ANIMATION_IDLE;
            if (bitmap != null) {
                this.f_renamed = bitmap.copy(bitmap.getConfig(), false);
                this.g_renamed = bitmap.copy(bitmap.getConfig(), false);
            }
            invalidateSelf();
        }

        public void a_renamed(java.lang.Long l_renamed, java.lang.Runnable runnable) {
            this.h_renamed = runnable;
            this.d_renamed = l_renamed.longValue();
            this.e_renamed = android.os.SystemClock.elapsedRealtime();
            this.i_renamed = com.oplus.camera.capmode.y_renamed.a_renamed.XPanMode_4.ANIMATION_STARTED;
            b_renamed();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b_renamed() {
            if (this.e_renamed <= 0 || this.d_renamed <= 0) {
                return;
            }
            long jElapsedRealtime = android.os.SystemClock.elapsedRealtime();
            long j_renamed = this.e_renamed;
            long j2 = jElapsedRealtime - j_renamed;
            if (j_renamed > 0 && j2 < this.d_renamed) {
                this.i_renamed = com.oplus.camera.capmode.y_renamed.a_renamed.XPanMode_4.ANIMATION_ANIMATING;
                scheduleSelf(new java.lang.Runnable() { // from class: com.oplus.camera.capmode.-$$Lambda$y_renamed$a_renamed$cbTmxWegEk4ICSSIILDrMmgfU-0
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f_renamed$0.b_renamed();
                    }
                }, android.os.SystemClock.uptimeMillis() + 33);
                a_renamed(java.lang.Long.valueOf(j2));
                invalidateSelf();
            } else {
                this.i_renamed = com.oplus.camera.capmode.y_renamed.a_renamed.XPanMode_4.ANIMATING_COMPLETED;
                this.e_renamed = 0L;
                this.h_renamed.run();
            }
            invalidateSelf();
        }

        private void a_renamed(java.lang.Long l_renamed) {
            this.f4353a.setAlpha((int) ((1.0f - com.oplus.camera.capmode.y_renamed.h_renamed.getInterpolation(androidx.core.c_renamed.a_renamed.a_renamed(l_renamed.floatValue() / this.d_renamed, 0.0f, 1.0f))) * 255.0f));
        }
    }
}

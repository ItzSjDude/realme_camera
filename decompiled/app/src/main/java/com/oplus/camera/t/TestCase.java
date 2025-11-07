package com.oplus.camera.t_renamed;

/* compiled from: StreetMode.java */
/* loaded from: classes2.dex */
public class e_renamed extends com.oplus.camera.capmode.d_renamed implements com.oplus.camera.t_renamed.c_renamed.b_renamed, com.oplus.camera.t_renamed.g_renamed.a_renamed {
    private java.lang.String g_renamed;
    private java.lang.String h_renamed;
    private java.lang.String i_renamed;
    private boolean j_renamed;
    private boolean k_renamed;
    private java.lang.String[] l_renamed;
    private com.oplus.camera.t_renamed.c_renamed m_renamed;
    private com.oplus.camera.t_renamed.g_renamed n_renamed;
    private com.oplus.camera.capmode.a_renamed o_renamed;
    private boolean p_renamed;
    private boolean q_renamed;
    private int r_renamed;
    private float s_renamed;

    private boolean a_renamed(int i_renamed, boolean z_renamed) {
        return 3 == i_renamed && !z_renamed;
    }

    @Override // com.oplus.camera.t_renamed.g_renamed.a_renamed
    public void a_renamed(int i_renamed) {
    }

    @Override // com.oplus.camera.capmode.d_renamed, com.oplus.camera.capmode.BaseMode
    public java.lang.String getCameraMode() {
        return com.oplus.camera.aps.constant.ApsConstant.CAPTURE_MODE_STREET;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public java.lang.String getEffectMenuKeyByMode() {
        return com.oplus.camera.ui.CameraUIInterface.KEY_STREET_FILTER_MENU;
    }

    @Override // com.oplus.camera.capmode.d_renamed, com.oplus.camera.capmode.BaseMode
    public java.lang.String getFilterEffectMenuPreferenceKey() {
        return com.oplus.camera.ui.CameraUIInterface.KEY_STREET_FILTER_INDEX;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean getFrontEnable() {
        return false;
    }

    @Override // com.oplus.camera.capmode.d_renamed, com.oplus.camera.capmode.BaseMode
    public int getOperatingMode() {
        return 32937;
    }

    @Override // com.oplus.camera.t_renamed.g_renamed.a_renamed
    public void i_renamed() {
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean isStreetOpen() {
        return true;
    }

    public e_renamed(android.app.Activity activity, com.oplus.camera.capmode.a_renamed aVar, com.oplus.camera.ui.CameraUIInterface cameraUIInterface, com.oplus.camera.ui.preview.a_renamed.t_renamed tVar) {
        super(activity, aVar, cameraUIInterface, tVar);
        this.g_renamed = "1";
        this.h_renamed = "28";
        this.i_renamed = "169";
        this.j_renamed = true;
        this.k_renamed = false;
        this.m_renamed = null;
        this.n_renamed = null;
        this.o_renamed = null;
        this.p_renamed = false;
        this.q_renamed = false;
        this.r_renamed = com.oplus.camera.ui.preview.a_renamed.j_renamed.f6905a;
        this.s_renamed = 1.0f;
        this.o_renamed = aVar;
        this.r_renamed = getCurrFilterIndex();
    }

    @Override // com.oplus.camera.capmode.d_renamed, com.oplus.camera.capmode.BaseMode
    protected void onInitCameraMode() {
        super.onInitCameraMode();
        this.m_renamed = new com.oplus.camera.t_renamed.c_renamed(this.mActivity, this.mCameraUIInterface, this.o_renamed, true, this.mOneCamera);
        this.m_renamed.a_renamed(this);
        if (com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_STREET_TRACK_UI_SUPPORT)) {
            this.n_renamed = new com.oplus.camera.t_renamed.g_renamed(this.mActivity, this.mCameraUIInterface, this.o_renamed, this.mOneCamera);
            this.n_renamed.a_renamed(this);
        }
        n_renamed();
        o_renamed();
        f_renamed();
    }

    @Override // com.oplus.camera.capmode.d_renamed, com.oplus.camera.capmode.BaseMode
    protected void onDeInitCameraMode(java.lang.String str) {
        super.onDeInitCameraMode(str);
        p_renamed();
        if (isBubbleOpen(com.oplus.camera.ui.CameraUIInterface.KEY_BUBBLE_STREET_ROCKER_SHUTTER)) {
            this.mCameraUIInterface.f_renamed(20, true);
        }
        this.m_renamed.i_renamed();
        this.m_renamed.e_renamed();
        com.oplus.camera.t_renamed.g_renamed gVar = this.n_renamed;
        if (gVar != null) {
            gVar.d_renamed();
        }
    }

    /* JADX WARN: Can't_renamed fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as_renamed a_renamed decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B_renamed:17:0x0038  */
    @Override // com.oplus.camera.capmode.d_renamed, com.oplus.camera.capmode.BaseMode
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean getSupportMenu(java.lang.String r6) {
        /*
            r5 = this;
            java.lang.String r6 = com.oplus.camera.entry.b_renamed.d_renamed(r6)
            int r0 = r6.hashCode()
            r1 = 0
            r2 = 3
            r3 = 2
            r4 = 1
            switch(r0) {
                case -1995250906: goto L2e;
                case -1973476532: goto L24;
                case -1063289942: goto L1a;
                case 1063692490: goto L10;
                default: goto Lf;
            }
        Lf:
            goto L38
        L10:
            java.lang.String r0 = "pref_raw_control_key"
            boolean r0 = r6.equals(r0)
            if (r0 == 0) goto L38
            r0 = r3
            goto L39
        L1a:
            java.lang.String r0 = "pref_camera_hdr_mode_key"
            boolean r0 = r6.equals(r0)
            if (r0 == 0) goto L38
            r0 = r1
            goto L39
        L24:
            java.lang.String r0 = "pref_street_fix_focus_control_key"
            boolean r0 = r6.equals(r0)
            if (r0 == 0) goto L38
            r0 = r4
            goto L39
        L2e:
            java.lang.String r0 = "pref_street_filter_menu"
            boolean r0 = r6.equals(r0)
            if (r0 == 0) goto L38
            r0 = r2
            goto L39
        L38:
            r0 = -1
        L39:
            if (r0 == 0) goto L59
            if (r0 == r4) goto L52
            if (r0 == r3) goto L4b
            if (r0 == r2) goto L46
            boolean r5 = super.getSupportMenu(r6)
            return r5
        L46:
            boolean r5 = r5.getSupportFunction(r6)
            return r5
        L4b:
            java.lang.String r5 = "com.oplus.feature.street.raw.support"
            boolean r5 = com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(r5)
            return r5
        L52:
            java.lang.String r5 = "com.oplus.feature.street.lock.focus.support"
            boolean r5 = com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(r5)
            return r5
        L59:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.t_renamed.e_renamed.getSupportMenu(java.lang.String):boolean");
    }

    /* JADX WARN: Can't_renamed fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B_renamed:47:0x00a2  */
    @Override // com.oplus.camera.capmode.d_renamed, com.oplus.camera.capmode.BaseMode
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean getSupportFunction(java.lang.String r4) {
        /*
            Method dump skipped, instructions count: 372
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.t_renamed.e_renamed.getSupportFunction(java.lang.String):boolean");
    }

    @Override // com.oplus.camera.capmode.d_renamed, com.oplus.camera.capmode.BaseMode
    public int getCurrFilterIndex() {
        int i_renamed = this.mPreferences.getInt(getFilterEffectMenuPreferenceKey(), com.oplus.camera.ui.preview.a_renamed.j_renamed.f6905a);
        java.lang.String configStringValue = com.oplus.camera.aps.config.CameraConfig.getConfigStringValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_STREET_FILTER_TYPE_DEFAULT);
        java.util.List<java.lang.String> filterTypeList = getFilterTypeList(this.mCameraId);
        if (filterTypeList != null && filterTypeList.contains(configStringValue)) {
            i_renamed = this.mPreferences.getInt(getFilterEffectMenuPreferenceKey(), filterTypeList.indexOf(configStringValue));
        }
        return com.oplus.camera.util.Util.a_renamed(i_renamed, 0, getFilterTypeList(this.mCameraId).size() - 1);
    }

    private boolean l_renamed() {
        com.oplus.camera.t_renamed.g_renamed gVar = this.n_renamed;
        if (gVar != null) {
            return gVar.b_renamed();
        }
        return false;
    }

    @Override // com.oplus.camera.capmode.d_renamed, com.oplus.camera.capmode.BaseMode
    protected boolean onBeforeSnapping(com.oplus.camera.e_renamed.c_renamed cVar) {
        this.mbCheckTakeAnimateDelay = false;
        setRawRequestTag(false);
        if (isRawOpen()) {
            setRawRequestTag(true);
            this.j_renamed = false;
        }
        s_renamed();
        return super.onBeforeSnapping(cVar);
    }

    @Override // com.oplus.camera.capmode.d_renamed, com.oplus.camera.capmode.BaseMode
    public void onPreviewCaptureResult(com.oplus.ocs.camera.CameraPreviewCallback.CameraPreviewResult cameraPreviewResult) {
        super.onPreviewCaptureResult(cameraPreviewResult);
        if (cameraPreviewResult == null || cameraPreviewResult.getCaptureResult() == null) {
            return;
        }
        this.m_renamed.a_renamed(((java.lang.Float) cameraPreviewResult.getCaptureResult().get(android.hardware.camera2.CaptureResult.LENS_FOCUS_DISTANCE)).floatValue());
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean onSingleTapUp(android.view.MotionEvent motionEvent) {
        this.m_renamed.a_renamed(motionEvent);
        return false;
    }

    @Override // com.oplus.camera.capmode.d_renamed, com.oplus.camera.capmode.BaseMode
    protected void onAfterPictureTaken(byte[] bArr, boolean z_renamed) {
        com.oplus.camera.e_renamed.a_renamed("StreetMode", "onAfterPictureTaken");
        if (!this.j_renamed && isRawRequestTag()) {
            this.j_renamed = true;
        } else {
            super.onAfterPictureTaken(bArr, z_renamed);
        }
    }

    @Override // com.oplus.camera.capmode.d_renamed, com.oplus.camera.capmode.BaseMode
    public boolean dispatchTouchEvent(android.view.MotionEvent motionEvent) {
        if (2 != motionEvent.getAction() || !this.m_renamed.o_renamed()) {
            return false;
        }
        this.m_renamed.i_renamed();
        return true;
    }

    @Override // com.oplus.camera.capmode.d_renamed, com.oplus.camera.capmode.BaseMode
    protected void onPause() {
        super.onPause();
        p_renamed();
        this.k_renamed = false;
        com.oplus.camera.t_renamed.c_renamed cVar = this.m_renamed;
        if (cVar != null) {
            cVar.t_renamed();
        }
    }

    @Override // com.oplus.camera.capmode.d_renamed, com.oplus.camera.capmode.BaseMode
    public void onSharedPreferenceChanged(android.content.SharedPreferences sharedPreferences, java.lang.String str) {
        if (com.oplus.camera.ui.CameraUIInterface.KEY_SUB_SETTING.equals(str) && "on_renamed".equals(sharedPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_SUB_SETTING, "off"))) {
            p_renamed();
            return;
        }
        if (com.oplus.camera.ui.CameraUIInterface.KEY_RAW_CONTROL.equals(str) && getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_RAW_CONTROL)) {
            q_renamed();
            return;
        }
        if (com.oplus.camera.ui.CameraUIInterface.KEY_STREET_FIX_FOCUS_CONTROL.equals(str) && !this.p_renamed) {
            f_renamed();
            return;
        }
        if (com.oplus.camera.ui.CameraUIInterface.KEY_NONE_SAT_ULTRA_WIDE_ANGLE.equals(str) && "on_renamed".equals(sharedPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_NONE_SAT_ULTRA_WIDE_ANGLE, "off"))) {
            p_renamed();
            m_renamed();
        } else {
            if (com.oplus.camera.ui.CameraUIInterface.KEY_STREET_LONG_EXPOSURE_MENU.equals(str)) {
                this.o_renamed.a_renamed((android.animation.AnimatorListenerAdapter) null, false, false);
                this.m_renamed.i_renamed();
                this.mCameraUIInterface.v_renamed(27);
                return;
            }
            super.onSharedPreferenceChanged(sharedPreferences, str);
        }
    }

    private void m_renamed() {
        this.m_renamed.i_renamed();
        b_renamed(false);
    }

    private void b_renamed(boolean z_renamed) {
        this.k_renamed = z_renamed;
        this.mOneCamera.E_renamed(this.k_renamed);
        this.mOneCamera.a_renamed(this.l_renamed);
        this.mOneCamera.a_renamed((com.oplus.camera.e_renamed.d_renamed.c_renamed) null);
    }

    @Override // com.oplus.camera.capmode.d_renamed, com.oplus.camera.capmode.BaseMode
    public void onMoreModeHidden(int i_renamed) {
        o_renamed();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean isSupportAutoFocus() {
        return !this.m_renamed.f_renamed();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean isRawOpen() {
        return getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_RAW_CONTROL) && !"off".equals(this.mPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_RAW_CONTROL, "off"));
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean isFixFocusOpen() {
        return getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_STREET_FIX_FOCUS_CONTROL) && !"off".equals(this.mPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_STREET_FIX_FOCUS_CONTROL, "off"));
    }

    @Override // com.oplus.camera.capmode.d_renamed, com.oplus.camera.capmode.BaseMode
    public boolean needSurface(java.lang.String str) {
        if ("type_still_capture_raw".equals(str)) {
            return getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_RAW_CONTROL) && !com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_DISABLE_RAW);
        }
        return super.needSurface(str);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean isRawRequestTag() {
        return this.mbRawRequestTag;
    }

    @Override // com.oplus.camera.capmode.d_renamed, com.oplus.camera.capmode.BaseMode
    protected boolean isCameraSettingMenuOptionEnable(java.lang.String str) {
        if ((com.oplus.camera.ui.CameraUIInterface.KEY_RAW_CONTROL.equals(str) && getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_RAW_CONTROL)) || (com.oplus.camera.ui.CameraUIInterface.KEY_STREET_FIX_FOCUS_CONTROL.equals(str) && getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_STREET_FIX_FOCUS_CONTROL))) {
            return (a_renamed(getZoomValue()) || isNoneSatUltraWideAngleOpen()) ? false : true;
        }
        return super.isCameraSettingMenuOptionEnable(str);
    }

    @Override // com.oplus.camera.capmode.d_renamed, com.oplus.camera.capmode.BaseMode
    public void onZoomChanged() {
        if (this.o_renamed.a_renamed(this.s_renamed, getZoomValue())) {
            if (this.m_renamed.d_renamed() && a_renamed(getZoomValue())) {
                this.mPreferences.edit().putString(com.oplus.camera.ui.CameraUIInterface.KEY_STREET_FIX_FOCUS_CONTROL, "off").apply();
                this.mCameraUIInterface.f_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_STREET_FIX_FOCUS_CONTROL);
            }
            this.mCameraUIInterface.q_renamed();
        }
        this.s_renamed = getZoomValue();
        super.onZoomChanged();
    }

    public boolean a_renamed(float f_renamed) {
        return java.lang.Float.compare(f_renamed, 1.0f) < 0;
    }

    @Override // com.oplus.camera.capmode.d_renamed, com.oplus.camera.capmode.BaseMode
    public com.oplus.camera.af_renamed getZoomConfigure() {
        com.oplus.camera.af_renamed zoomConfigure = super.getZoomConfigure();
        zoomConfigure.d_renamed(true);
        zoomConfigure.K_renamed(isRawOpen());
        return zoomConfigure;
    }

    @Override // com.oplus.camera.capmode.d_renamed, com.oplus.camera.capmode.BaseMode
    protected java.util.List<java.lang.String> getFilterTypeList(int i_renamed) {
        if (getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_STREET_FILTER_MENU)) {
            return com.oplus.camera.ui.preview.a_renamed.j_renamed.n_renamed.a_renamed(com.oplus.camera.e_renamed.a_renamed.a_renamed(i_renamed));
        }
        return super.getFilterTypeList(i_renamed);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected java.lang.String getFilterType(int i_renamed) {
        return getFilterTypeList(this.mCameraId).get(i_renamed);
    }

    @Override // com.oplus.camera.capmode.d_renamed, com.oplus.camera.capmode.BaseMode
    protected java.util.List<java.lang.Integer> getFilterNameIdList(int i_renamed) {
        if (getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_STREET_FILTER_MENU)) {
            return com.oplus.camera.ui.preview.a_renamed.j_renamed.n_renamed.f_renamed;
        }
        return super.getFilterNameIdList(i_renamed);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected long getHalMemory() {
        return com.oplus.camera.aps.config.CameraConfig.getConfigIntValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_HAL_MEMORY_STREET);
    }

    private void n_renamed() {
        java.lang.String[] strArrB;
        this.g_renamed = com.oplus.camera.aps.config.CameraConfig.getConfigStringValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_EDGE_FILTER_LINE_SIZE);
        int[] configIntArrayValue = com.oplus.camera.aps.config.CameraConfig.getConfigIntArrayValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_EDGE_FILTER_COLOR);
        if (configIntArrayValue != null && 3 == configIntArrayValue.length && (strArrB = com.oplus.camera.util.Util.b_renamed(configIntArrayValue[0], configIntArrayValue[1], configIntArrayValue[2])) != null && strArrB.length == 2) {
            this.h_renamed = strArrB[0];
            this.i_renamed = strArrB[1];
        }
        this.l_renamed = new java.lang.String[]{this.g_renamed, this.h_renamed, this.i_renamed};
    }

    private void o_renamed() {
        if (this.mCameraUIInterface.T_renamed() || isNoneSatUltraWideAngleOpen()) {
            return;
        }
        this.mCameraUIInterface.a_renamed(com.oplus.camera.R_renamed.string.camera_mode_ice_on_hint, -1, true, true, false);
    }

    private void p_renamed() {
        if (this.mCameraUIInterface != null) {
            this.mCameraUIInterface.a_renamed(com.oplus.camera.R_renamed.string.camera_mode_ice_on_hint);
        }
    }

    private void q_renamed() {
        if ("on_renamed".equals(this.mPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_RAW_CONTROL, "off"))) {
            this.mCameraUIInterface.a_renamed(com.oplus.camera.R_renamed.string.camera_raw_control_on_hint, -1, true, false, false);
        } else {
            this.mCameraUIInterface.a_renamed(com.oplus.camera.R_renamed.string.camera_raw_control_off_hint, -1, true, false, false);
        }
        this.mOneCamera.m_renamed(getZSLMode());
        if (this.o_renamed != null) {
            if (getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_ZOOM) && !this.mCameraUIInterface.A_renamed()) {
                this.o_renamed.a_renamed(true, false);
                this.o_renamed.d_renamed(true);
            } else {
                this.o_renamed.a_renamed((android.animation.AnimatorListenerAdapter) null, true, false);
            }
            if (e_renamed()) {
                this.o_renamed.aH_renamed();
            }
        }
        this.mCameraUIInterface.a_renamed(true, false);
        s_renamed();
        this.mOneCamera.a_renamed((com.oplus.camera.e_renamed.d_renamed.c_renamed) null);
    }

    public boolean e_renamed() {
        return com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_RAW_ZOOM_MUTEX_SUPPORT);
    }

    public void f_renamed() {
        if (!getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_STREET_FIX_FOCUS_CONTROL) || this.mPreferences == null) {
            return;
        }
        this.m_renamed.b_renamed(isPanelMode());
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public int getDefaultAFMode() {
        if (getIsCapturingState()) {
            return this.mOneCamera.p_renamed();
        }
        return super.getDefaultAFMode();
    }

    @Override // com.oplus.camera.capmode.d_renamed, com.oplus.camera.capmode.BaseMode
    protected boolean onStopTakePicture() {
        if (this.mCameraUIInterface.s_renamed() != 3 && this.mCameraUIInterface.s_renamed() != 14) {
            return false;
        }
        this.mbInCapturing = false;
        return true;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void onFilterMenuClicked() {
        super.onFilterMenuClicked();
    }

    @Override // com.oplus.camera.capmode.d_renamed, com.oplus.camera.capmode.BaseMode
    public void onEffectMenuPopUp() {
        this.m_renamed.n_renamed();
    }

    @Override // com.oplus.camera.capmode.d_renamed, com.oplus.camera.capmode.BaseMode
    public void onEffectMenuPopDown(boolean z_renamed) {
        this.m_renamed.e_renamed(isPanelMode());
    }

    @Override // com.oplus.camera.capmode.d_renamed, com.oplus.camera.capmode.BaseMode
    public void onZoomMenuExpand() {
        this.m_renamed.r_renamed();
    }

    @Override // com.oplus.camera.capmode.d_renamed, com.oplus.camera.capmode.BaseMode
    public void onZoomMenuCollapsed() {
        this.m_renamed.s_renamed();
    }

    @Override // com.oplus.camera.t_renamed.c_renamed.b_renamed
    public void a_renamed() {
        b_renamed(true);
    }

    @Override // com.oplus.camera.t_renamed.c_renamed.b_renamed
    public void b_renamed() {
        if (com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_STREET_TRACK_UI_SUPPORT)) {
            return;
        }
        b_renamed(false);
    }

    @Override // com.oplus.camera.t_renamed.c_renamed.b_renamed
    public void a_renamed(boolean z_renamed) {
        if (com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_STREET_TRACK_UI_SUPPORT)) {
            return;
        }
        b_renamed(z_renamed);
    }

    @Override // com.oplus.camera.t_renamed.c_renamed.b_renamed
    public void c_renamed() {
        if (com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_STREET_TRACK_UI_SUPPORT)) {
            b_renamed(false);
        }
    }

    @Override // com.oplus.camera.t_renamed.c_renamed.b_renamed
    public void d_renamed() {
        if (com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_STREET_TRACK_UI_SUPPORT)) {
            b_renamed(true);
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean isShowFixFocusMenu() {
        boolean zO = this.m_renamed.o_renamed();
        com.oplus.camera.t_renamed.g_renamed gVar = this.n_renamed;
        if (gVar != null) {
            return zO || gVar.a_renamed();
        }
        return zO;
    }

    @Override // com.oplus.camera.capmode.d_renamed, com.oplus.camera.capmode.BaseMode
    public boolean onBackPressed() {
        if (isShowFixFocusMenu()) {
            m_renamed();
            return true;
        }
        if (this.j_renamed) {
            return super.onBackPressed();
        }
        return true;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean isAfFixFocuse() {
        return this.m_renamed.p_renamed();
    }

    @Override // com.oplus.camera.capmode.d_renamed, com.oplus.camera.capmode.BaseMode
    protected void onResume(boolean z_renamed) {
        f_renamed();
        super.onResume(z_renamed);
        r_renamed();
    }

    private void r_renamed() {
        android.view.View viewFindViewById = this.mActivity.findViewById(com.oplus.camera.R_renamed.id_renamed.google_lens_icon_view);
        if (viewFindViewById != null) {
            viewFindViewById.setVisibility(8);
        }
    }

    @Override // com.oplus.camera.capmode.d_renamed, com.oplus.camera.capmode.BaseMode
    public void onSessionConfigured() {
        this.m_renamed.q_renamed();
        setBurstShotCapturing(false);
        super.onSessionConfigured();
    }

    @Override // com.oplus.camera.capmode.d_renamed, com.oplus.camera.capmode.BaseMode
    public void changeModeAllViewWhenAnimation(int i_renamed, boolean z_renamed) {
        super.changeModeAllViewWhenAnimation(i_renamed, z_renamed);
        if (a_renamed(i_renamed, z_renamed)) {
            this.p_renamed = true;
            m_renamed();
        }
    }

    @Override // com.oplus.camera.capmode.d_renamed, com.oplus.camera.capmode.BaseMode
    public void onTimeSnapShotEnd(boolean z_renamed) {
        this.p_renamed = false;
        f_renamed();
        super.onTimeSnapShotEnd(z_renamed);
    }

    @Override // com.oplus.camera.capmode.d_renamed, com.oplus.camera.capmode.BaseMode
    public void onAfterStartPreview(boolean z_renamed) {
        super.onAfterStartPreview(z_renamed);
        f_renamed();
        this.s_renamed = getZoomValue();
        this.m_renamed.q_renamed();
        s_renamed();
        com.oplus.camera.t_renamed.g_renamed gVar = this.n_renamed;
        if (gVar != null) {
            gVar.c_renamed();
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void setOrientation(int i_renamed) {
        super.setOrientation(i_renamed);
        com.oplus.camera.t_renamed.c_renamed cVar = this.m_renamed;
        if (cVar != null) {
            cVar.c_renamed(i_renamed);
        }
    }

    @Override // com.oplus.camera.capmode.d_renamed, com.oplus.camera.capmode.BaseMode
    protected void saveAndClearEffectBeforeBurstShot() {
        this.r_renamed = getCurrFilterIndex();
        onFilterItemChange(com.oplus.camera.ui.preview.a_renamed.j_renamed.f6905a);
        updateEffectMenuNames();
        this.mCameraUIInterface.g_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_FILTER_MENU);
    }

    @Override // com.oplus.camera.capmode.d_renamed, com.oplus.camera.capmode.BaseMode
    protected void restoreEffectAfterBurstShot() {
        onFilterItemChange(this.r_renamed);
        updateEffectMenuNames();
        this.mCameraUIInterface.g_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_FILTER_MENU);
    }

    @Override // com.oplus.camera.capmode.d_renamed, com.oplus.camera.capmode.BaseMode
    public void showNextTip() {
        super.showNextTip();
        if (this.mCameraUIInterface == null || this.mCameraUIInterface.R_renamed() || this.mCameraUIInterface.S_renamed()) {
            return;
        }
        if (this.mPreferences != null && !this.mPreferences.getBoolean(com.oplus.camera.ui.CameraUIInterface.KEY_PERMISSION_DIALOG_DISPLAYED, false)) {
            com.oplus.camera.e_renamed.f_renamed("StreetMode", "showNextTip, return");
        } else if (isBubbleOpen(com.oplus.camera.ui.CameraUIInterface.KEY_BUBBLE_STREET_ROCKER_SHUTTER)) {
            this.mCameraUIInterface.a_renamed((android.view.View) null, 20, getBubbleOffsetX(20), getBubbleOffsetY(20));
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onRawImageReceived(com.oplus.ocs.camera.CameraPictureCallback.CameraPictureImage cameraPictureImage) {
        a_renamed(cameraPictureImage);
    }

    private void a_renamed(com.oplus.ocs.camera.CameraPictureCallback.CameraPictureImage cameraPictureImage) {
        byte[] image = cameraPictureImage.getImage();
        com.oplus.camera.g_renamed.a_renamed.e_renamed eVarA = com.oplus.camera.g_renamed.a_renamed.e_renamed.a_renamed(image);
        final long j_renamed = this.mCaptureDate - 10;
        if (eVarA != null) {
            eVarA.a_renamed();
            eVarA.a_renamed(eVarA.f_renamed, j_renamed);
            eVarA.a_renamed(eVarA.g_renamed, j_renamed);
            eVarA.d_renamed();
            image = eVarA.j_renamed.array();
        }
        final byte[] bArr = image;
        final int format = cameraPictureImage.getFormat();
        if (this.mActivity != null) {
            this.mActivity.runOnUiThread(new java.lang.Runnable() { // from class: com.oplus.camera.t_renamed.e_renamed.1
                @Override // java.lang.Runnable
                public void run() {
                    com.oplus.camera.t_renamed.e_renamed.this.pictureTakenCallback(bArr, 0, 0, com.oplus.camera.util.Util.a_renamed(format), true, false, false, j_renamed, 0);
                }
            });
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void closeImageReader() {
        this.j_renamed = true;
    }

    private void s_renamed() {
        if (this.mPreferences == null || this.mOneCamera == null) {
            return;
        }
        if ("on_renamed".equals(this.mPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_RAW_CONTROL, "off"))) {
            this.mOneCamera.a_renamed((com.oplus.ocs.camera.CameraParameter.PreviewKey<com.oplus.ocs.camera.CameraParameter.PreviewKey<java.lang.String>>) com.oplus.ocs.camera.CameraParameter.RAW_CONTROL, (com.oplus.ocs.camera.CameraParameter.PreviewKey<java.lang.String>) "raw");
        } else {
            this.mOneCamera.a_renamed((com.oplus.ocs.camera.CameraParameter.PreviewKey<com.oplus.ocs.camera.CameraParameter.PreviewKey<java.lang.String>>) com.oplus.ocs.camera.CameraParameter.RAW_CONTROL, (com.oplus.ocs.camera.CameraParameter.PreviewKey<java.lang.String>) "none");
        }
    }

    @Override // com.oplus.camera.t_renamed.g_renamed.a_renamed
    public void g_renamed() {
        this.q_renamed = true;
        this.m_renamed.f_renamed(false);
        this.m_renamed.j_renamed();
    }

    @Override // com.oplus.camera.t_renamed.g_renamed.a_renamed
    public void h_renamed() {
        this.q_renamed = false;
        this.m_renamed.f_renamed(true);
        this.m_renamed.e_renamed(isPanelMode());
        if (this.m_renamed.f_renamed()) {
            this.m_renamed.u_renamed();
        } else {
            this.m_renamed.d_renamed(false);
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean supportMenuLeftButton() {
        if (this.q_renamed) {
            return false;
        }
        return super.supportMenuLeftButton();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean supportBeautyButton() {
        if (this.q_renamed) {
            return false;
        }
        return super.supportBeautyButton();
    }

    @Override // com.oplus.camera.t_renamed.g_renamed.a_renamed
    public boolean j_renamed() {
        if (a_renamed(getZoomValue()) || isNoneSatUltraWideAngleOpen()) {
            this.mCameraUIInterface.a_renamed(com.oplus.camera.R_renamed.string.disabled_street_track_hint, -1, true, true, false);
            return true;
        }
        if (this.mCameraUIInterface == null) {
            return false;
        }
        this.mCameraUIInterface.a_renamed(com.oplus.camera.R_renamed.string.disabled_street_track_hint);
        return false;
    }

    @Override // com.oplus.camera.t_renamed.g_renamed.a_renamed
    public boolean k_renamed() {
        if (this.mCameraUIInterface == null) {
            return false;
        }
        this.mCameraUIInterface.a_renamed(com.oplus.camera.R_renamed.string.disabled_street_track_hint);
        return false;
    }

    @Override // com.oplus.camera.capmode.d_renamed, com.oplus.camera.capmode.BaseMode
    protected boolean isHideHeadLine() {
        return this.m_renamed.o_renamed();
    }
}

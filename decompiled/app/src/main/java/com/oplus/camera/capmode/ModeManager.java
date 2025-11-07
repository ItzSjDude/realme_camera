package com.oplus.camera.capmode;

/* loaded from: classes2.dex */
public class ModeManager {

    /* renamed from: b_renamed, reason: collision with root package name */
    private int f4211b;
    private android.app.Activity j_renamed;

    /* renamed from: a_renamed, reason: collision with root package name */
    private int f4210a = -1;
    private com.oplus.camera.capmode.BaseMode mCurrentMode = null;

    /* renamed from: c_renamed, reason: collision with root package name */
    private com.oplus.camera.capmode.BaseMode f4212c = null;
    private java.util.Map<java.lang.String, com.oplus.camera.capmode.BaseMode> d_renamed = new java.util.concurrent.ConcurrentHashMap();
    private com.oplus.camera.e_renamed.d_renamed e_renamed = null;
    private boolean f_renamed = false;
    private boolean g_renamed = false;
    private boolean h_renamed = false;
    private java.lang.String i_renamed = com.oplus.camera.aps.constant.ApsConstant.CAPTURE_MODE_COMMON;
    private com.oplus.camera.capmode.a_renamed k_renamed = null;
    private com.oplus.camera.ui.CameraUIInterface l_renamed = null;
    private com.oplus.camera.ui.preview.a_renamed.t_renamed m_renamed = null;

    public java.lang.String q_renamed() {
        return com.oplus.camera.aps.constant.ApsConstant.CAPTURE_MODE_COMMON;
    }

    public ModeManager(android.app.Activity activity) {
        this.j_renamed = null;
        this.j_renamed = activity;
    }

    public void a_renamed(com.oplus.camera.capmode.a_renamed aVar, com.oplus.camera.ui.CameraUIInterface cameraUIInterface, com.oplus.camera.ui.preview.a_renamed.t_renamed tVar) {
        this.k_renamed = aVar;
        this.l_renamed = cameraUIInterface;
        this.m_renamed = tVar;
        com.oplus.camera.i_renamed.b_renamed.a_renamed().a_renamed(this.k_renamed, this.l_renamed);
    }

    public com.oplus.camera.capmode.BaseMode a_renamed(java.lang.String str) {
        java.util.Map<java.lang.String, com.oplus.camera.capmode.BaseMode> map = this.d_renamed;
        if (map != null) {
            return map.get(str);
        }
        com.oplus.camera.e_renamed.f_renamed("ModeManager", "getModeByName, error, mBaseModeMap is_renamed null.");
        return null;
    }

    public boolean a_renamed() {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.isPanelMode();
        }
        return false;
    }

    public void a_renamed(boolean z_renamed) {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            baseMode.onBinauralRecordStateChanged(z_renamed);
        }
    }

    public boolean b_renamed() {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.isHideUICapture();
        }
        return false;
    }

    public boolean c_renamed() {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.isHideHeadLine();
        }
        return false;
    }

    public boolean d_renamed() {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.isModeBarSelected();
        }
        return false;
    }

    public int e_renamed() {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.getOperatingMode();
        }
        return 0;
    }

    public java.lang.String f_renamed() {
        com.oplus.camera.capmode.BaseMode baseMode = this.d_renamed.get(this.i_renamed);
        return (baseMode == null || !baseMode.isPanelMode()) ? this.i_renamed : com.oplus.camera.aps.constant.ApsConstant.CAPTURE_MODE_COMMON;
    }

    public com.oplus.camera.ui.control.b_renamed g_renamed() {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.getShutterButtonInfo();
        }
        com.oplus.camera.e_renamed.f_renamed("ModeManager", "getShutterButtonInfo, mCurrentMode is_renamed null..");
        return null;
    }

    public boolean h_renamed() {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.isCaptureModeType();
        }
        return true;
    }

    public boolean i_renamed() {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.isCommonVideoMode();
        }
        return false;
    }

    public boolean j_renamed() {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.isNeedMetaDataWhenPause();
        }
        return false;
    }

    public boolean k_renamed() {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.isVideoModeType();
        }
        return false;
    }

    public void b_renamed(java.lang.String str) {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            baseMode.hideBubble(str);
        }
    }

    public void b_renamed(boolean z_renamed) {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            baseMode.operateViewWhenMultiFinger(z_renamed);
        }
    }

    public java.lang.String a_renamed(int i_renamed, java.lang.String str) {
        if (b_renamed(i_renamed, str)) {
            return str;
        }
        java.lang.String strB = com.oplus.camera.util.Util.b_renamed(this.k_renamed.m_renamed());
        com.oplus.camera.e_renamed.a_renamed("ModeManager", "getEnabledModeForCameraId, modeName: " + str + ", Switch to mode: " + strB);
        return strB;
    }

    private com.oplus.camera.capmode.BaseMode dR_renamed() {
        if (com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_QUICK_VIDEO_SUPPORT)) {
            return new com.oplus.camera.p_renamed.a_renamed(this.j_renamed, this.k_renamed, this.l_renamed, this.m_renamed);
        }
        return new com.oplus.camera.capmode.d_renamed(this.j_renamed, this.k_renamed, this.l_renamed, this.m_renamed);
    }

    public boolean c_renamed(java.lang.String str) {
        if (!b_renamed(this.f4210a, str)) {
            com.oplus.camera.e_renamed.f_renamed("ModeManager", "setCurrentMode fail, the mode: " + str + " is_renamed not enabled at_renamed cameraId: " + this.f4210a);
            str = com.oplus.camera.util.Util.b_renamed(this.k_renamed.m_renamed());
            if (com.oplus.camera.aps.constant.ApsConstant.CAPTURE_MODE_COMMON.equals(str) && this.d_renamed.get(com.oplus.camera.aps.constant.ApsConstant.CAPTURE_MODE_COMMON) == null) {
                com.oplus.camera.capmode.BaseMode baseModeDR = dR_renamed();
                this.d_renamed.put(baseModeDR.getCameraMode(), baseModeDR);
            } else if (com.oplus.camera.aps.constant.ApsConstant.REC_MODE_COMMON.equals(str) && this.d_renamed.get(com.oplus.camera.aps.constant.ApsConstant.REC_MODE_COMMON) == null) {
                com.oplus.camera.capmode.e_renamed eVar = new com.oplus.camera.capmode.e_renamed(this.j_renamed, this.k_renamed, this.l_renamed, this.m_renamed);
                this.d_renamed.put(eVar.getCameraMode(), eVar);
            }
        }
        com.oplus.camera.capmode.BaseMode baseMode = this.d_renamed.get(str);
        if (baseMode == null) {
            com.oplus.camera.e_renamed.f_renamed("ModeManager", "setCurrentMode, cannot find cap mode: " + str);
            return false;
        }
        baseMode.setCameraId(this.f4210a);
        baseMode.updateFilterNoneIndex();
        com.oplus.camera.capmode.BaseMode baseMode2 = this.mCurrentMode;
        if (baseMode2 != null) {
            if (baseMode2.getCameraMode().equals(str)) {
                com.oplus.camera.e_renamed.a_renamed("ModeManager", "setCurrentMode fail, the mode not change: " + str);
                return false;
            }
            if (!a_renamed()) {
                this.i_renamed = this.mCurrentMode.getCameraMode();
            }
            this.mCurrentMode.deInitCameraMode(str);
        }
        this.mCurrentMode = baseMode;
        this.mCurrentMode.updateOneCamera(this.e_renamed);
        this.mCurrentMode.initCameraMode();
        this.mCurrentMode.setLowBatteryState(this.g_renamed);
        this.mCurrentMode.setDisplayOnLock(this.h_renamed);
        com.oplus.camera.e_renamed.a_renamed("ModeManager", "setCurrentMode, mCurrentMode mode: " + baseMode.getCameraMode());
        return true;
    }

    public boolean l_renamed() {
        return this.mCurrentMode.onBackPressed();
    }

    public void m_renamed() {
        this.mCurrentMode.hideViewWhileResume();
    }

    public java.lang.String n_renamed() {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.getCameraMode();
        }
        return null;
    }

    public boolean o_renamed() {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.isZoomFaceRectifySupported();
        }
        return false;
    }

    public boolean a_renamed(android.view.MotionEvent motionEvent) {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode == null) {
            return false;
        }
        return baseMode.onDown(motionEvent);
    }

    public boolean b_renamed(android.view.MotionEvent motionEvent) {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode == null) {
            return false;
        }
        return baseMode.onSingleTapUp(motionEvent);
    }

    public void p_renamed() {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            baseMode.onTouchFocus();
        }
    }

    public boolean a_renamed(android.view.MotionEvent motionEvent, android.view.MotionEvent motionEvent2, float f_renamed, float f2) {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.onScroll(motionEvent, motionEvent2, f_renamed, f2);
        }
        return false;
    }

    public boolean c_renamed(android.view.MotionEvent motionEvent) {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.onLongPress(motionEvent);
        }
        return false;
    }

    public boolean a_renamed(boolean z_renamed, boolean z2) {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.checkSensorMask(z_renamed, z2);
        }
        return false;
    }

    public void a_renamed(com.oplus.ocs.camera.CameraPreviewCallback.CameraPreviewResult cameraPreviewResult) {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            baseMode.onPreviewCaptureResult(cameraPreviewResult);
        }
    }

    public void a_renamed(com.oplus.camera.aps.service.ThumbnailItem thumbnailItem) {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            baseMode.onThumbnailUpdated(thumbnailItem);
        }
    }

    public void r_renamed() throws java.lang.NumberFormatException {
        com.oplus.camera.e_renamed.a_renamed("onBeforePreview");
        if (this.mCurrentMode != null) {
            com.oplus.camera.e_renamed.f_renamed("ModeManager", "onBeforePreview, capMode: " + this.mCurrentMode.getCameraMode() + ", mCurrentMode: " + this.mCurrentMode);
            this.mCurrentMode.beforePreview();
        }
        com.oplus.camera.e_renamed.b_renamed("onBeforePreview");
    }

    public void c_renamed(boolean z_renamed) {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            baseMode.afterStartPreview(z_renamed);
        }
    }

    public boolean s_renamed() {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.isHyperLapseOpen();
        }
        return false;
    }

    public void a_renamed(com.oplus.camera.e_renamed.d_renamed dVar) {
        this.e_renamed = dVar;
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            baseMode.updateOneCamera(dVar);
        }
    }

    public void t_renamed() {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            baseMode.onUpdateCameraSettingMenu();
        }
    }

    public boolean d_renamed(java.lang.String str) {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.getSupportMenu(str);
        }
        return false;
    }

    public boolean e_renamed(java.lang.String str) {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.getSupportSubMenu(str);
        }
        return false;
    }

    public void a_renamed(int i_renamed) {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            baseMode.setOrientation(i_renamed);
        }
    }

    public boolean u_renamed() {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode == null) {
            return false;
        }
        this.f4212c = baseMode;
        return baseMode.burstShotCapture();
    }

    public boolean d_renamed(boolean z_renamed) {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        this.f4212c = baseMode;
        return baseMode.capture(z_renamed);
    }

    public void v_renamed() {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            baseMode.startShortVideoRecording();
        }
    }

    public void w_renamed() {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            baseMode.stopShortVideoRecording();
        }
    }

    public void a_renamed(int i_renamed, int i2) {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            baseMode.onThermalLevelChange(i_renamed, i2);
        }
    }

    public void b_renamed(int i_renamed) {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            baseMode.onVideoTemperatureThresholdChanged(i_renamed);
        }
    }

    public void x_renamed() {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            baseMode.onShutterButtonLongClick();
        }
    }

    public void y_renamed() {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            baseMode.stopQuickVideoRecording();
        }
    }

    public boolean z_renamed() {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.getQuickVideoRecording();
        }
        return false;
    }

    public boolean A_renamed() {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.isQuickVideoInRestriction();
        }
        return false;
    }

    public boolean B_renamed() {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.canShowResumeButton();
        }
        return true;
    }

    public void e_renamed(boolean z_renamed) {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            baseMode.setQuickVideoBeforeLockTime(z_renamed);
        }
    }

    public boolean f_renamed(boolean z_renamed) {
        return this.mCurrentMode.stopTakePicture(z_renamed);
    }

    public void C_renamed() {
        this.mCurrentMode.disableBurstShot();
    }

    public void D_renamed() {
        this.mCurrentMode.beforeStartRecording();
        D_renamed(false);
    }

    public void E_renamed() {
        this.mCurrentMode.afterStartRecording();
    }

    public void F_renamed() {
        this.mCurrentMode.afterStopRecording();
        D_renamed(true);
    }

    public void c_renamed(int i_renamed) {
        com.oplus.camera.e_renamed.a_renamed("ModeManager", "setCameraId, cameraId: " + this.f4210a + " -> " + i_renamed);
        int i2 = this.f4210a;
        if (-1 != i2 && i_renamed != i2) {
            com.oplus.camera.perf.SwitchCameraPerformance.setSwitchCameraId(i2, i_renamed);
        }
        this.f4210a = i_renamed;
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            baseMode.setCameraId(i_renamed);
        }
    }

    public void G_renamed() {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            baseMode.beforeSwitchCamera();
        }
    }

    public void d_renamed(int i_renamed) {
        com.oplus.camera.e_renamed.a_renamed("ModeManager", "cameraIdChanged, cameraId: " + this.f4210a + " -> " + i_renamed);
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode == null || this.f4210a == -1) {
            return;
        }
        this.f4210a = i_renamed;
        baseMode.cameraIdChanged(i_renamed);
    }

    public void H_renamed() {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            baseMode.onZoomMenuCollapsing();
        }
    }

    public void I_renamed() {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            baseMode.onZoomMenuCollapsed();
        }
    }

    public void J_renamed() {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            baseMode.onZoomMenuExpand();
        }
    }

    public void e_renamed(int i_renamed) {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            baseMode.onZoomTransitionChanged(i_renamed);
        }
    }

    public void a_renamed(float f_renamed) {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            baseMode.onZoomAlphaChanged(f_renamed);
        }
    }

    public void f_renamed(int i_renamed) {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            baseMode.updateControlPanelBgColor(i_renamed);
        }
    }

    public void g_renamed(int i_renamed) {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            baseMode.onFilterItemChange(i_renamed);
        }
    }

    public boolean h_renamed(int i_renamed) {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.onEffectItemClick(i_renamed);
        }
        return false;
    }

    public boolean K_renamed() {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.isAnyModeAnimationRunning();
        }
        return false;
    }

    public boolean L_renamed() {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.isBackPortraitCameraSwitching();
        }
        return false;
    }

    public void a_renamed(com.oplus.ocs.camera.CameraPreviewCallback.CameraPreviewResult cameraPreviewResult, boolean z_renamed) {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            baseMode.onApsPreviewCaptureCompleted(cameraPreviewResult, z_renamed);
        }
    }

    public void a_renamed(com.oplus.camera.ui.preview.a_renamed.p_renamed pVar) {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            baseMode.createEffectTextures(pVar);
        }
    }

    public void M_renamed() {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            baseMode.onEffectSurfaceCreated();
        }
    }

    public void f_renamed(java.lang.String str) {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            baseMode.onEffectMenuChange(str);
        }
    }

    public boolean N_renamed() {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.hasEffectSelected();
        }
        return false;
    }

    public void b_renamed(boolean z_renamed, boolean z2) {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            baseMode.displayAllIcon(z_renamed, z2);
        }
    }

    public void O_renamed() {
        com.oplus.camera.e_renamed.a_renamed("ModeManager", "displayScreenHint");
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            baseMode.updateHintView();
            this.mCurrentMode.displayFixedUpModeHint();
            this.mCurrentMode.displayScreenHintIconInSwitchOn();
            this.mCurrentMode.clearFocusOutOfRange();
        }
    }

    public void P_renamed() {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            baseMode.showLowMemory();
        }
    }

    public long Q_renamed() {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.getMinimumCaptureMemory();
        }
        return 52428800L;
    }

    /* JADX WARN: Removed duplicated region for block: B_renamed:10:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public synchronized boolean a_renamed(com.oplus.camera.d_renamed.a_renamed r2) {
        /*
            r1 = this;
            monitor-enter(r1)
            boolean r0 = r1.f_renamed     // Catch: java.lang.Throwable -> L16
            if (r0 == 0) goto L13
            com.oplus.camera.capmode.BaseMode r0 = r1.mCurrentMode     // Catch: java.lang.Throwable -> L16
            if (r0 == 0) goto L13
            com.oplus.camera.capmode.BaseMode r0 = r1.mCurrentMode     // Catch: java.lang.Throwable -> L16
            boolean r2 = r0.isAllowSwitch(r2)     // Catch: java.lang.Throwable -> L16
            if (r2 == 0) goto L13
            r2 = 1
            goto L14
        L13:
            r2 = 0
        L14:
            monitor-exit(r1)
            return r2
        L16:
            r2 = move-exception
            monitor-exit(r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.capmode.ModeManager.a_renamed(com.oplus.camera.d_renamed$a_renamed):boolean");
    }

    public boolean g_renamed(java.lang.String str) {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.getAddMenuOptionEnabled(str);
        }
        return false;
    }

    public int R_renamed() {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.getDefaultAFMode();
        }
        return 4;
    }

    public java.lang.String S_renamed() {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        return baseMode != null ? baseMode.getFlashMode() : "off";
    }

    public boolean T_renamed() {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.isFrontTorchEnabled();
        }
        return false;
    }

    public android.util.Size a_renamed(com.oplus.camera.e_renamed.h_renamed hVar) {
        return a_renamed(hVar, (java.lang.String) null);
    }

    public android.util.Size a_renamed(com.oplus.camera.e_renamed.h_renamed hVar, java.lang.String str) {
        com.oplus.camera.e_renamed.a_renamed("getPreviewSize");
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        android.util.Size previewSize = baseMode == null ? null : baseMode.getPreviewSize(hVar, str);
        com.oplus.camera.e_renamed.b_renamed("getPreviewSize");
        return previewSize;
    }

    public int U_renamed() {
        return this.mCurrentMode.getPreviewDispalyWidth();
    }

    public android.util.Size b_renamed(com.oplus.camera.e_renamed.h_renamed hVar) {
        return this.mCurrentMode.getPreviewFrameSize(hVar);
    }

    public android.util.Size c_renamed(com.oplus.camera.e_renamed.h_renamed hVar) {
        return this.mCurrentMode.getPictureSize(hVar);
    }

    public boolean V_renamed() {
        return this.mCurrentMode.isInCapturePreparing();
    }

    public boolean W_renamed() {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.getIsCapturingState();
        }
        com.oplus.camera.e_renamed.f_renamed("ModeManager", "getIsCapturingState, camera has been destroyed");
        return false;
    }

    public boolean X_renamed() {
        return this.mCurrentMode.getIsBurstShotCapturing();
    }

    public void g_renamed(boolean z_renamed) {
        this.mCurrentMode.setBurstShotCapturing(z_renamed);
    }

    public void h_renamed(boolean z_renamed) {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            baseMode.setAllowSwitchMode(z_renamed);
        }
    }

    public void h_renamed(java.lang.String str) {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            baseMode.showPictureSizeHint(str);
        }
    }

    public void Y_renamed() {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            baseMode.onShareMenuExpand();
        }
    }

    public boolean i_renamed(java.lang.String str) {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.needUploadOplusStatistics(str);
        }
        return false;
    }

    public void Z_renamed() {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            baseMode.checkoutTimerSnapShotState();
        }
    }

    public void i_renamed(boolean z_renamed) {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            baseMode.onTimeSnapShotEnd(z_renamed);
        }
    }

    public boolean aa_renamed() {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.supportBeautyButton();
        }
        return false;
    }

    public boolean j_renamed(java.lang.String str) {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.getSupportFunction(str);
        }
        return false;
    }

    public boolean ab_renamed() {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.isSupportShowFilterMenu();
        }
        return false;
    }

    public boolean ac_renamed() {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.getScreenTorchModeState();
        }
        return false;
    }

    public java.lang.String ad_renamed() {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        return baseMode != null ? baseMode.getFullPictureSizeType() : com.oplus.camera.statistics.model.DcsMsgData.FULL;
    }

    public com.oplus.camera.statistics.model.DcsMsgData a_renamed(com.oplus.camera.statistics.model.DcsMsgData dcsMsgData) {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        return baseMode != null ? baseMode.getBeforeCaptureMsgCommonData(dcsMsgData) : dcsMsgData;
    }

    public com.oplus.camera.statistics.model.DcsMsgData a_renamed(com.oplus.camera.statistics.model.DcsMsgData dcsMsgData, com.oplus.camera.Storage.CameraPicture cameraPicture) {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        return baseMode != null ? baseMode.getAfterCaptureMsgCommonData(dcsMsgData, cameraPicture) : dcsMsgData;
    }

    public void ae_renamed() {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            baseMode.closeImageReader();
        }
    }

    /* JADX WARN: Can't_renamed fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B_renamed:98:0x016b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void k_renamed(java.lang.String r5) {
        /*
            Method dump skipped, instructions count: 1320
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.capmode.ModeManager.k_renamed(java.lang.String):void");
    }

    public boolean af_renamed() {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.isMicroscopeMode();
        }
        return false;
    }

    public boolean ag_renamed() {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode instanceof com.oplus.camera.capmode.h_renamed;
        }
        return false;
    }

    public void j_renamed(boolean z_renamed) {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            baseMode.resume(z_renamed);
        }
    }

    public void ah_renamed() {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            baseMode.pause();
        }
    }

    public void ai_renamed() {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            baseMode.stop();
        }
    }

    public void aj_renamed() {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            baseMode.beforePause();
        }
    }

    public java.lang.String ak_renamed() {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.getTimeLapse();
        }
        return null;
    }

    public void al_renamed() {
        synchronized (this) {
            if (this.d_renamed != null) {
                java.util.Iterator<java.lang.String> it = this.d_renamed.keySet().iterator();
                while (it.hasNext()) {
                    com.oplus.camera.capmode.BaseMode baseMode = this.d_renamed.get(it.next());
                    if (baseMode != null) {
                        baseMode.destroy();
                    }
                }
                this.d_renamed.clear();
                this.f_renamed = false;
                this.d_renamed = null;
                this.mCurrentMode = null;
                this.f4212c = null;
            }
        }
        this.j_renamed = null;
    }

    private void dS_renamed() {
        if (this.f4211b != this.mCurrentMode.mCameraInterface.u_renamed()) {
            this.f4211b = this.mCurrentMode.mCameraInterface.u_renamed();
            a_renamed(this.f4211b);
        }
    }

    private void D_renamed(boolean z_renamed) {
        if (z_renamed) {
            dS_renamed();
        }
    }

    public boolean am_renamed() {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.isShowProgressBarForOtherApp();
        }
        return true;
    }

    public boolean an_renamed() {
        return this.mCurrentMode.getIsShowPostCaptureAlert();
    }

    public boolean ao_renamed() {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.isNeedProgressBarInCapture();
        }
        return false;
    }

    public boolean ap_renamed() {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.isNeedShowMenuOnTimeSnapShotEnd();
        }
        return true;
    }

    public boolean aq_renamed() {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.isNeedSetRecordingMargin();
        }
        return false;
    }

    public int ar_renamed() {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.getReceiveBustShotNum();
        }
        return 0;
    }

    public void as_renamed() {
        this.mCurrentMode.onCameraIdChangedAnimationEnd();
    }

    public void a_renamed(int i_renamed, boolean z_renamed) {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            baseMode.setPIEnable(i_renamed, z_renamed);
        }
    }

    public void at_renamed() {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            baseMode.resetFiltersList();
        }
    }

    public void l_renamed(java.lang.String str) {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            baseMode.updateGrandTourCityFiltersPosition(str);
        }
    }

    public void au_renamed() {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            baseMode.updateAISceneMode();
        }
    }

    public void av_renamed() {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            baseMode.updatePIMode();
        }
    }

    public void i_renamed(int i_renamed) {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            baseMode.onAISceneClosed(i_renamed);
        }
    }

    public synchronized void aw_renamed() {
        com.oplus.camera.e_renamed.a_renamed("initBaseModeMap");
        if (this.d_renamed == null) {
            com.oplus.camera.e_renamed.f_renamed("ModeManager", "initBaseModeMap, mBaseModeMap is_renamed null!");
            return;
        }
        com.oplus.camera.e_renamed.a_renamed("ModeManager", "initBaseModeMap, mBaseModeList Size: " + this.d_renamed.size());
        if (this.k_renamed.m_renamed()) {
            if (this.d_renamed.get(com.oplus.camera.aps.constant.ApsConstant.REC_MODE_COMMON) == null) {
                com.oplus.camera.capmode.e_renamed eVar = new com.oplus.camera.capmode.e_renamed(this.j_renamed, this.k_renamed, this.l_renamed, this.m_renamed);
                this.d_renamed.put(eVar.getCameraMode(), eVar);
            }
        } else {
            if (this.d_renamed.get(com.oplus.camera.aps.constant.ApsConstant.CAPTURE_MODE_COMMON) == null) {
                com.oplus.camera.capmode.BaseMode baseModeDR = dR_renamed();
                this.d_renamed.put(baseModeDR.getCameraMode(), baseModeDR);
            }
            if (com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_SUPPORT_PORTRAIT) && this.d_renamed.get("portrait") == null) {
                com.oplus.camera.n_renamed.a_renamed aVar = new com.oplus.camera.n_renamed.a_renamed(this.j_renamed, this.k_renamed, this.l_renamed, this.m_renamed);
                this.d_renamed.put(aVar.getCameraMode(), aVar);
            }
            if (this.k_renamed.i_renamed()) {
                if (this.d_renamed.get(com.oplus.camera.aps.constant.ApsConstant.REC_MODE_COMMON) == null) {
                    com.oplus.camera.capmode.e_renamed eVar2 = new com.oplus.camera.capmode.e_renamed(this.j_renamed, this.k_renamed, this.l_renamed, this.m_renamed);
                    this.d_renamed.put(eVar2.getCameraMode(), eVar2);
                }
                if (this.d_renamed.get(com.oplus.camera.aps.constant.ApsConstant.CAPTURE_MODE_PANORAMA) == null) {
                    com.oplus.camera.panorama.f_renamed fVar = new com.oplus.camera.panorama.f_renamed(this.j_renamed, this.k_renamed, this.l_renamed, this.m_renamed);
                    this.d_renamed.put(fVar.getCameraMode(), fVar);
                }
                if (this.d_renamed.get(com.oplus.camera.aps.constant.ApsConstant.REC_MODE_FAST_VIDEO) == null) {
                    com.oplus.camera.h_renamed.a_renamed aVar2 = new com.oplus.camera.h_renamed.a_renamed(this.j_renamed, this.k_renamed, this.l_renamed, this.m_renamed);
                    this.d_renamed.put(aVar2.getCameraMode(), aVar2);
                }
                if (this.d_renamed.get(com.oplus.camera.aps.constant.ApsConstant.REC_MODE_SLOW_VIDEO) == null && com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_SUPPORT_SLOW_VIDEO)) {
                    com.oplus.camera.r_renamed.g_renamed gVar = new com.oplus.camera.r_renamed.g_renamed(this.j_renamed, this.k_renamed, this.l_renamed, this.m_renamed);
                    this.d_renamed.put(gVar.getCameraMode(), gVar);
                }
                if (this.d_renamed.get(com.oplus.camera.aps.constant.ApsConstant.CAPTURE_MODE_MULTI_VIDEO) == null && com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_MULTI_VIDEO_MODE_SUPPORT)) {
                    com.oplus.camera.capmode.q_renamed qVar = new com.oplus.camera.capmode.q_renamed(this.j_renamed, this.k_renamed, this.l_renamed, this.m_renamed);
                    this.d_renamed.put(qVar.getCameraMode(), qVar);
                }
                if (this.d_renamed.get("movie") == null && com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_SUPPORT_MOVIE_MODE)) {
                    com.oplus.camera.filmvideomode.s_renamed sVar = new com.oplus.camera.filmvideomode.s_renamed(this.j_renamed, this.k_renamed, this.l_renamed, this.m_renamed);
                    this.d_renamed.put(sVar.getCameraMode(), sVar);
                }
                if (this.d_renamed.get(com.oplus.camera.aps.constant.ApsConstant.CAPTURE_MODE_PROFESSIONAL) == null) {
                    if (!com.oplus.camera.util.Util.ao_renamed()) {
                        com.oplus.camera.professional.v_renamed vVar = new com.oplus.camera.professional.v_renamed(this.j_renamed, this.k_renamed, this.l_renamed, this.m_renamed);
                        this.d_renamed.put(vVar.getCameraMode(), vVar);
                    } else {
                        com.oplus.camera.professional.h_renamed hVar = new com.oplus.camera.professional.h_renamed(this.j_renamed, this.k_renamed, this.l_renamed, this.m_renamed);
                        this.d_renamed.put(hVar.getCameraMode(), hVar);
                    }
                }
                if (com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_STICKER) && this.d_renamed.get(com.oplus.camera.aps.constant.ApsConstant.CAPTURE_MODE_STICKER) == null) {
                    com.oplus.camera.capmode.t_renamed tVar = new com.oplus.camera.capmode.t_renamed(this.j_renamed, this.k_renamed, this.l_renamed, this.m_renamed);
                    this.d_renamed.put(tVar.getCameraMode(), tVar);
                }
                if (com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_NIGHT)) {
                    com.oplus.camera.capmode.r_renamed rVar = new com.oplus.camera.capmode.r_renamed(this.j_renamed, this.k_renamed, this.l_renamed, this.m_renamed);
                    this.d_renamed.put(rVar.getCameraMode(), rVar);
                }
                if (this.d_renamed.get(com.oplus.camera.aps.constant.ApsConstant.CAPTURE_MODE_MACRO) == null && com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_SUPPORT_MACRO_MODE)) {
                    com.oplus.camera.capmode.n_renamed nVar = new com.oplus.camera.capmode.n_renamed(this.j_renamed, this.k_renamed, this.l_renamed, this.m_renamed);
                    this.d_renamed.put(nVar.getCameraMode(), nVar);
                }
                if (this.d_renamed.get("superText") == null) {
                    com.oplus.camera.capmode.u_renamed uVar = new com.oplus.camera.capmode.u_renamed(this.j_renamed, this.k_renamed, this.l_renamed, this.m_renamed);
                    this.d_renamed.put(uVar.getCameraMode(), uVar);
                }
                if (com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_ID_PHOTO) && this.d_renamed.get(com.oplus.camera.aps.constant.ApsConstant.CAPTURE_MODE_ID_PHOTO) == null && com.oplus.camera.util.Util.v_renamed(this.j_renamed) && com.oplus.camera.l_renamed.c_renamed.g_renamed()) {
                    com.oplus.camera.capmode.l_renamed lVar = new com.oplus.camera.capmode.l_renamed(this.j_renamed, this.k_renamed, this.l_renamed, this.m_renamed);
                    this.d_renamed.put(lVar.getCameraMode(), lVar);
                }
                if (com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_FISH_EYE) && this.d_renamed.get(com.oplus.camera.aps.constant.ApsConstant.CAPTURE_MODE_FISH_EYE) == null) {
                    com.oplus.camera.capmode.h_renamed hVar2 = new com.oplus.camera.capmode.h_renamed(this.j_renamed, this.k_renamed, this.l_renamed, this.m_renamed);
                    this.d_renamed.put(hVar2.getCameraMode(), hVar2);
                }
                if (this.d_renamed.get(com.oplus.camera.aps.constant.ApsConstant.CAPTURE_MODE_ULTRA_HIGH_RESOLUTION) == null) {
                    com.oplus.camera.capmode.v_renamed vVar2 = new com.oplus.camera.capmode.v_renamed(this.j_renamed, this.k_renamed, this.l_renamed, this.m_renamed);
                    this.d_renamed.put(vVar2.getCameraMode(), vVar2);
                }
                if (com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_HIGH_PIXEL_SUPPORT) && this.d_renamed.get(com.oplus.camera.aps.constant.ApsConstant.CAPTURE_MODE_HIGH_PIXEL) == null) {
                    com.oplus.camera.capmode.k_renamed kVar = new com.oplus.camera.capmode.k_renamed(this.j_renamed, this.k_renamed, this.l_renamed, this.m_renamed);
                    this.d_renamed.put(kVar.getCameraMode(), kVar);
                }
                if (com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_SUPPORT_HIGH_DEFINITION) && this.d_renamed.get(com.oplus.camera.aps.constant.ApsConstant.CAPTURE_MODE_HIGH_DEFINITION) == null) {
                    com.oplus.camera.capmode.j_renamed jVar = new com.oplus.camera.capmode.j_renamed(this.j_renamed, this.k_renamed, this.l_renamed, this.m_renamed);
                    this.d_renamed.put(jVar.getCameraMode(), jVar);
                }
                if (this.d_renamed.get(com.oplus.camera.aps.constant.ApsConstant.CAPTURE_MODE_GROUP_SHOT) == null) {
                    com.oplus.camera.capmode.i_renamed iVar = new com.oplus.camera.capmode.i_renamed(this.j_renamed, this.k_renamed, this.l_renamed, this.m_renamed);
                    this.d_renamed.put(iVar.getCameraMode(), iVar);
                }
                if (com.oplus.camera.aps.config.CameraConfig.isSupportMicroscope() && this.d_renamed.get(com.oplus.camera.aps.constant.ApsConstant.CAPTURE_MODE_MICROSCOPE) == null) {
                    com.oplus.camera.capmode.o_renamed oVar = new com.oplus.camera.capmode.o_renamed(this.j_renamed, this.k_renamed, this.l_renamed, this.m_renamed);
                    this.d_renamed.put(oVar.getCameraMode(), oVar);
                }
                if (com.oplus.camera.aps.config.CameraConfig.isSupportMicroscope() && this.d_renamed.get(com.oplus.camera.aps.constant.ApsConstant.REC_MODE_MICROSCOPE) == null) {
                    com.oplus.camera.capmode.p_renamed pVar = new com.oplus.camera.capmode.p_renamed(this.j_renamed, this.k_renamed, this.l_renamed, this.m_renamed);
                    this.d_renamed.put(pVar.getCameraMode(), pVar);
                }
                if (com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_DOUBLE_EXPOSURE_SUPPORT) && this.d_renamed.get(com.oplus.camera.aps.constant.ApsConstant.REC_MODE_DOUBLE_EXPOSURE) == null) {
                    com.oplus.camera.capmode.g_renamed gVar2 = new com.oplus.camera.capmode.g_renamed(this.j_renamed, this.k_renamed, this.l_renamed, this.m_renamed);
                    this.d_renamed.put(gVar2.getCameraMode(), gVar2);
                }
                if (com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_SUPPORT_STARRY_MODE) && this.d_renamed.get(com.oplus.camera.aps.constant.ApsConstant.CAPTURE_MODE_STARRY) == null) {
                    com.oplus.camera.s_renamed.d_renamed dVar = new com.oplus.camera.s_renamed.d_renamed(this.j_renamed, this.k_renamed, this.l_renamed, this.m_renamed);
                    this.d_renamed.put(dVar.getCameraMode(), dVar);
                }
                if (com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_SUPPORT_STARRY_MODE) && com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_SUPPORT_STAR_VIDEO) && this.d_renamed.get(com.oplus.camera.aps.constant.ApsConstant.REC_MODE_STAR_VIDEO) == null) {
                    com.oplus.camera.s_renamed.b_renamed bVar = new com.oplus.camera.s_renamed.b_renamed(this.j_renamed, this.k_renamed, this.l_renamed, this.m_renamed);
                    this.d_renamed.put(bVar.getCameraMode(), bVar);
                }
                if (com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_SUPPORT_XPAN_MODE) && this.d_renamed.get(com.oplus.camera.aps.constant.ApsConstant.CAPTURE_MODE_XPAN) == null) {
                    com.oplus.camera.capmode.y_renamed yVar = new com.oplus.camera.capmode.y_renamed(this.j_renamed, this.k_renamed, this.l_renamed, this.m_renamed);
                    this.d_renamed.put(yVar.getCameraMode(), yVar);
                }
                if (com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_SUPPORT_TILT_SHIFT_PHOTO) && this.d_renamed.get(com.oplus.camera.aps.constant.ApsConstant.CAPTURE_MODE_TILT_SHIFT) == null) {
                    com.oplus.camera.tiltshift.TiltShiftPhotoMode tiltShiftPhotoMode = new com.oplus.camera.tiltshift.TiltShiftPhotoMode(this.j_renamed, this.k_renamed, this.l_renamed, this.m_renamed);
                    this.d_renamed.put(tiltShiftPhotoMode.getCameraMode(), tiltShiftPhotoMode);
                }
                if (com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_SUPPORT_TILT_SHIFT_FAST_VIDEO) && this.d_renamed.get(com.oplus.camera.aps.constant.ApsConstant.REC_MODE_TILT_SHIFT_FAST_VIDEO) == null) {
                    com.oplus.camera.tiltshift.TiltShiftFastVideoMode tiltShiftFastVideoMode = new com.oplus.camera.tiltshift.TiltShiftFastVideoMode(this.j_renamed, this.k_renamed, this.l_renamed, this.m_renamed);
                    this.d_renamed.put(tiltShiftFastVideoMode.getCameraMode(), tiltShiftFastVideoMode);
                }
                if (com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_TIME_LAPSE_PRO_SUPPORT) && this.d_renamed.get(com.oplus.camera.aps.constant.ApsConstant.REC_MODE_TIMELASPE_PRO) == null) {
                    com.oplus.camera.timelapsepro.h_renamed hVar3 = new com.oplus.camera.timelapsepro.h_renamed(this.j_renamed, this.k_renamed, this.l_renamed, this.m_renamed);
                    this.d_renamed.put(hVar3.getCameraMode(), hVar3);
                }
                if (com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_SUPPORT_STREET_MODE) && this.d_renamed.get(com.oplus.camera.aps.constant.ApsConstant.CAPTURE_MODE_STREET) == null) {
                    com.oplus.camera.t_renamed.e_renamed eVar3 = new com.oplus.camera.t_renamed.e_renamed(this.j_renamed, this.k_renamed, this.l_renamed, this.m_renamed);
                    this.d_renamed.put(eVar3.getCameraMode(), eVar3);
                }
                if (com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_SUPPORT_LONG_EXPOSURE_MODE)) {
                    com.oplus.camera.capmode.m_renamed mVar = new com.oplus.camera.capmode.m_renamed(this.j_renamed, this.k_renamed, this.l_renamed, this.m_renamed);
                    this.d_renamed.put(mVar.getCameraMode(), mVar);
                }
                if (com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_SUPPORT_3D_PHOTO) && this.d_renamed.get(com.oplus.camera.aps.constant.ApsConstant.CAPTURE_MODE_3D_PHOTO) == null) {
                    com.oplus.camera.photo3d.c_renamed cVar = new com.oplus.camera.photo3d.c_renamed(this.j_renamed, this.k_renamed, this.l_renamed, this.m_renamed);
                    this.d_renamed.put(cVar.getCameraMode(), cVar);
                }
            }
        }
        this.f_renamed = true;
        com.oplus.camera.e_renamed.b_renamed("initBaseModeMap");
        com.oplus.camera.e_renamed.a_renamed("ModeManager", "initBaseModeMap X_renamed, mBaseModeList Size: " + this.d_renamed.size());
    }

    public synchronized boolean b_renamed(int i_renamed, java.lang.String str) {
        if (str == null) {
            com.oplus.camera.e_renamed.f_renamed("ModeManager", "getPluginEnabled ,mode-string or mPlugins is_renamed null,so return");
            return false;
        }
        if (!this.d_renamed.containsKey(str)) {
            return false;
        }
        com.oplus.camera.capmode.BaseMode baseMode = this.d_renamed.get(str);
        if (com.oplus.camera.e_renamed.a_renamed.a_renamed(i_renamed)) {
            return baseMode.getFrontEnable();
        }
        return baseMode.getRearEnable();
    }

    public void ax_renamed() {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            baseMode.onUiModeChanged();
        }
    }

    public void a_renamed(android.content.SharedPreferences sharedPreferences, java.lang.String str) {
        this.mCurrentMode.onSharedPreferenceChanged(sharedPreferences, str);
    }

    public boolean ay_renamed() {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.isAnimojiOpen();
        }
        return false;
    }

    public boolean az_renamed() {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.isHistogramOpen();
        }
        return false;
    }

    public void k_renamed(boolean z_renamed) {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            baseMode.updateInversePositionRatio(z_renamed);
        }
    }

    public boolean aA_renamed() {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.isAISceneOpen();
        }
        return false;
    }

    public boolean aB_renamed() {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.isPIAISceneOpen();
        }
        return false;
    }

    public boolean aC_renamed() {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.isVividEffectOpen();
        }
        return false;
    }

    public boolean aD_renamed() {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.isFlashState();
        }
        return false;
    }

    public boolean aE_renamed() {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.isNeedAPSProcess();
        }
        return false;
    }

    public void b_renamed(int i_renamed, boolean z_renamed) {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            baseMode.changeModeAllViewWhenAnimation(i_renamed, z_renamed);
        }
    }

    public void aF_renamed() {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            baseMode.resetMetadataBokehCode();
        }
    }

    public void aG_renamed() {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            baseMode.hideFirstBeautyTipView();
        }
    }

    public void aH_renamed() {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            baseMode.hideStreetRockerShutterTipView();
        }
    }

    public void aI_renamed() {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            baseMode.onShowBubble();
        }
    }

    public void m_renamed(java.lang.String str) {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            baseMode.onHDRModeChanged(str);
        }
    }

    public void a_renamed(com.oplus.camera.tiltshift.TiltShiftParam tiltShiftParam) {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            baseMode.setTiltShiftParams(tiltShiftParam);
        }
    }

    public boolean aJ_renamed() {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.isTiltShiftOpen();
        }
        return false;
    }

    public boolean aK_renamed() {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.isTiltShiftSupportBeauty();
        }
        return false;
    }

    public void l_renamed(boolean z_renamed) {
        this.h_renamed = z_renamed;
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            baseMode.setDisplayOnLock(z_renamed);
        }
    }

    public void m_renamed(boolean z_renamed) {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            baseMode.forceStopVideoRecording(z_renamed);
        }
    }

    public void n_renamed(boolean z_renamed) {
        this.g_renamed = z_renamed;
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            baseMode.setLowBatteryState(z_renamed);
        }
    }

    public void o_renamed(boolean z_renamed) {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            baseMode.doReturnToCaller(z_renamed);
        }
    }

    public void aL_renamed() {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            baseMode.deleteCurrentVideo();
        }
    }

    public boolean aM_renamed() {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.needDelayFaceDetection();
        }
        return false;
    }

    public void aN_renamed() {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            baseMode.startPlayVideoActivity();
        }
    }

    public void aO_renamed() {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            baseMode.onVideoRetakeButtonClick();
        }
    }

    public void aP_renamed() {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            baseMode.aj_renamed();
        }
    }

    public void aQ_renamed() {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            baseMode.onScreenOffWhenLocked();
        }
    }

    public boolean aR_renamed() {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.onVideoRecordingPause();
        }
        return false;
    }

    public boolean aS_renamed() {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.onVideoRecordingResume();
        }
        return false;
    }

    public boolean aT_renamed() {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.isVideoRecordStarting();
        }
        return false;
    }

    public boolean aU_renamed() {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.isVideoRecordStarted();
        }
        return false;
    }

    public boolean aV_renamed() {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.isVideoRecording();
        }
        return false;
    }

    public boolean aW_renamed() {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.isHalVideoRecording();
        }
        return false;
    }

    public boolean aX_renamed() {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.showMenuLeftButton();
        }
        return false;
    }

    public boolean aY_renamed() {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.showBeautyButton();
        }
        return false;
    }

    public boolean aZ_renamed() {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.isVideoRecordStopped();
        }
        return true;
    }

    public boolean ba_renamed() {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.isVideoRecordStopping();
        }
        return false;
    }

    public void p_renamed(boolean z_renamed) {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            baseMode.setPreburstShotCapture(z_renamed);
        }
    }

    public boolean bb_renamed() {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.isVideoHighFps();
        }
        return false;
    }

    public boolean bc_renamed() {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.is4k();
        }
        return false;
    }

    public android.graphics.Bitmap j_renamed(int i_renamed) {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.getVideoThumbnail(i_renamed);
        }
        return null;
    }

    public com.oplus.camera.statistics.CameraStatisticsUtil.MakerNote bd_renamed() {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.getMakerNote();
        }
        return null;
    }

    public long be_renamed() {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.getResumePauseRecordingTotalTime();
        }
        return 0L;
    }

    public void k_renamed(int i_renamed) {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            baseMode.setSysBrightness(i_renamed);
        }
    }

    public void bf_renamed() {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            baseMode.onEffectMenuPopUp();
        }
    }

    public void q_renamed(boolean z_renamed) {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            baseMode.onEffectMenuPopDown(z_renamed);
        }
    }

    public boolean bg_renamed() {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.showEffectMenu();
        }
        return true;
    }

    public boolean bh_renamed() {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.isStickerMenuOpen();
        }
        return false;
    }

    public boolean a_renamed(int i_renamed, android.view.MotionEvent motionEvent) {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.performSlide(i_renamed, motionEvent);
        }
        return false;
    }

    public boolean bi_renamed() {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.updateViewByEnterCameraType();
        }
        return false;
    }

    public void bj_renamed() {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            baseMode.startScreenTorch();
        }
    }

    public void bk_renamed() {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            baseMode.stopScreenTorch();
        }
    }

    public boolean a_renamed(android.media.Image image) {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.onPreviewFrameReceived(image);
        }
        return true;
    }

    public void a_renamed(byte[] bArr, int i_renamed, int i2, int i3, boolean z_renamed, int i4) {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode == null || baseMode != this.f4212c) {
            return;
        }
        baseMode.onPictureCallback(bArr, i_renamed, i2, i3, z_renamed, i4);
    }

    public void r_renamed(boolean z_renamed) {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            baseMode.setPictureHasSuperTextResult(z_renamed);
        }
    }

    public boolean n_renamed(java.lang.String str) {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.needSurface(str);
        }
        return false;
    }

    public boolean l_renamed(int i_renamed) {
        if (2 == com.oplus.camera.aps.util.AlgoSwitchConfig.getApsVersion()) {
            return false;
        }
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.needPreviewMeta(i_renamed);
        }
        return true;
    }

    public boolean bl_renamed() {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.needSatCrossAnimation();
        }
        return false;
    }

    public boolean bm_renamed() {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.needClearFocusView();
        }
        return false;
    }

    public boolean bn_renamed() {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.getZSLMode();
        }
        return false;
    }

    public boolean d_renamed(android.view.MotionEvent motionEvent) {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.dispatchTouchEvent(motionEvent);
        }
        return false;
    }

    public void a_renamed(com.oplus.ocs.camera.CameraDeviceConfig.Builder builder) {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            baseMode.setConfigureParameter(builder);
        }
    }

    public void bo_renamed() {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            baseMode.onSessionConfigured();
        }
    }

    public boolean bp_renamed() {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.isHFR();
        }
        return false;
    }

    public void m_renamed(int i_renamed) {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            baseMode.setBeauty3DState(i_renamed);
        }
    }

    public int n_renamed(int i_renamed) {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.getBeauty3DScanIconType(i_renamed);
        }
        return 0;
    }

    public boolean bq_renamed() {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.isShowBeauty3D();
        }
        return false;
    }

    public boolean br_renamed() {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.isShowAnimojiMenu();
        }
        return false;
    }

    public boolean bs_renamed() {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.isShowProPanelMenu();
        }
        return false;
    }

    public boolean bt_renamed() {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.supportMenuLeftButton();
        }
        return false;
    }

    public boolean bu_renamed() {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.canShowTimeLapseProButtons();
        }
        return false;
    }

    public void bv_renamed() {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            baseMode.onZoomChanged();
        }
    }

    public int bw_renamed() {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.getBeauty3Dstatus();
        }
        return 0;
    }

    public boolean bx_renamed() {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.isShowingGuideView();
        }
        return false;
    }

    public int by_renamed() {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.getShortcutFaceBeautyIndex();
        }
        return 0;
    }

    public void bz_renamed() {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            baseMode.onSwitchCameraButtonClick();
        }
    }

    public java.lang.String bA_renamed() {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.getPhotoRatio();
        }
        return null;
    }

    public int bB_renamed() {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.getVideoFps();
        }
        return 0;
    }

    public int o_renamed(int i_renamed) {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.getSwitchAnimTime(i_renamed);
        }
        return 0;
    }

    public int bC_renamed() {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.getFaceBeautyCurrIndex();
        }
        return 0;
    }

    public boolean bD_renamed() {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.isMakeupOpen();
        }
        return false;
    }

    public int bE_renamed() {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.getZoomBarOffset();
        }
        return 0;
    }

    public int bF_renamed() {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.getFaceBeautyMenuType();
        }
        return 0;
    }

    public void p_renamed(int i_renamed) {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            baseMode.onFaceBeautyItemChange(i_renamed);
        }
    }

    public void bG_renamed() {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            baseMode.resetFaceBeautyValues();
        }
    }

    public int q_renamed(int i_renamed) {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.getFaceBeautyItemValue(i_renamed);
        }
        return -100000;
    }

    public int bH_renamed() {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.getDefaultCommonBeautyValue();
        }
        return 40;
    }

    public int[] bI_renamed() {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.getDefaultCustomBeautyValues();
        }
        return com.oplus.camera.d_renamed.f4356a;
    }

    public int[] bJ_renamed() {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.getDefaultMakeupValues();
        }
        return com.oplus.camera.ui.preview.a_renamed.g_renamed.f6895a;
    }

    public int r_renamed(int i_renamed) {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.getMakeupItemValue(i_renamed);
        }
        return com.oplus.camera.ui.preview.a_renamed.g_renamed.f6895a[i_renamed];
    }

    public void c_renamed(int i_renamed, boolean z_renamed) {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            baseMode.onMakeupTypeChanged(i_renamed, z_renamed);
        }
    }

    public void a_renamed(int i_renamed, int i2, boolean z_renamed) {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            baseMode.onMakeupValueChanged(i_renamed, i2, z_renamed);
        }
    }

    public int bK_renamed() {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.getCurrMakeupIndex();
        }
        return 0;
    }

    public boolean bL_renamed() {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.getSupportShowCustomAll();
        }
        return false;
    }

    public void b_renamed(int i_renamed, int i2, boolean z_renamed) {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            baseMode.onFaceBeautyItemValueChange(i_renamed, i2, z_renamed);
        }
    }

    public boolean bM_renamed() {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.onFaceBeautyMenuClick();
        }
        return true;
    }

    public boolean bN_renamed() {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.isHighPictureSize();
        }
        return false;
    }

    public boolean bO_renamed() {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.isUltraWideHighPictureSize();
        }
        return false;
    }

    public double bP_renamed() {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.getDisplayHighPictureSize();
        }
        return -1.0d;
    }

    public android.util.Size a_renamed(java.lang.String str, com.oplus.camera.e_renamed.h_renamed hVar) {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.getSurfaceSize(str, hVar);
        }
        return null;
    }

    public void s_renamed(int i_renamed) {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            baseMode.setFocusingSoundVolume(i_renamed);
        }
    }

    public void a_renamed(com.oplus.camera.aps.util.CameraApsDecision cameraApsDecision) {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            baseMode.onPreviewDecisionResult(cameraApsDecision);
        }
    }

    public int bQ_renamed() {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.getBlurIndex();
        }
        return 60;
    }

    public void t_renamed(int i_renamed) {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            baseMode.setBlurIndex(i_renamed);
        }
    }

    public void c_renamed(boolean z_renamed, boolean z2) {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            baseMode.switchVideoBlur(z_renamed, z2);
        }
    }

    public boolean bR_renamed() {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.isBlurOpen();
        }
        return false;
    }

    public boolean bS_renamed() {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.isShowUltraWide();
        }
        return true;
    }

    public void bT_renamed() {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            baseMode.onFilterMenuClicked();
        }
    }

    public boolean bU_renamed() {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.isVideoNeonOpen();
        }
        return false;
    }

    public void s_renamed(boolean z_renamed) {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            baseMode.setVideoBlurOpen(z_renamed);
        }
    }

    public void bV_renamed() {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            baseMode.setCapturePreviewDataStateIdle();
        }
    }

    public void t_renamed(boolean z_renamed) {
        this.mCurrentMode.setCachePreviewStart(z_renamed);
    }

    public boolean bW_renamed() {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.isSuperTextOpen();
        }
        return false;
    }

    public boolean bX_renamed() {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.isIdPhotoOpen();
        }
        return false;
    }

    public boolean bY_renamed() {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.getSupportFaceView();
        }
        return false;
    }

    public java.lang.String bZ_renamed() {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.getHeicCodecFormat();
        }
        return null;
    }

    public boolean ca_renamed() {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.isInNightProcess();
        }
        return false;
    }

    public boolean cb_renamed() {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.isCountDownStarted();
        }
        return false;
    }

    public boolean cc_renamed() {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.isLongExposureSceneMenuOpen();
        }
        return false;
    }

    public boolean cd_renamed() {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.isOpenHDR();
        }
        return false;
    }

    public boolean ce_renamed() {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        return baseMode != null && baseMode.isAutoHDR() && this.mCurrentMode.isHDRSceneModeInAuto();
    }

    public boolean cf_renamed() {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.isSuperClearPortraitEnable();
        }
        return false;
    }

    public boolean cg_renamed() {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.isUltraHighResolutionOpened();
        }
        return false;
    }

    public boolean ch_renamed() {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.isFilterEffectOpen();
        }
        return false;
    }

    public com.oplus.camera.ui.preview.a_renamed.l_renamed.a_renamed ci_renamed() {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.getFilterCategory();
        }
        return com.oplus.camera.ui.preview.a_renamed.l_renamed.a_renamed.Polarr;
    }

    public int cj_renamed() {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.getImageFormat();
        }
        return 256;
    }

    public android.util.Size a_renamed(com.oplus.camera.e_renamed.h_renamed hVar, double d_renamed) {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.getPreviewSize(hVar, d_renamed);
        }
        return null;
    }

    public boolean isSatOpen() {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.isSatOpen();
        }
        return false;
    }

    public void ck_renamed() {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            baseMode.onUltraWideAngleOpened();
        }
    }

    public void cl_renamed() {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            baseMode.onTeleAngleOpened();
        }
    }

    public void cm_renamed() {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            baseMode.onSuperEISChange();
        }
    }

    public boolean o_renamed(java.lang.String str) {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.isCameraSettingMenuOptionEnable(str);
        }
        return true;
    }

    public boolean isNoneSatUltraWideAngleOpen() {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.isNoneSatUltraWideAngleOpen();
        }
        return false;
    }

    public boolean cn_renamed() {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.isHyperLapseUltraWideOpen();
        }
        return false;
    }

    public boolean co_renamed() {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.isNoneSatTeleAngleOpen();
        }
        return false;
    }

    public int cp_renamed() {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.getHintTextId();
        }
        return -1;
    }

    public void cq_renamed() {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            baseMode.onResumeFromSetting();
        }
    }

    public void cr_renamed() {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            baseMode.onTopSubMenuCollapse();
        }
    }

    public void cs_renamed() {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            baseMode.onTopSubMenuExpand();
        }
    }

    public void ct_renamed() {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            baseMode.updateRatioType();
        }
    }

    public void u_renamed(boolean z_renamed) {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            baseMode.switchSuperEISWide(z_renamed);
        }
    }

    public com.oplus.camera.af_renamed cu_renamed() {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.getZoomConfigure();
        }
        return new com.oplus.camera.af_renamed();
    }

    public boolean b_renamed(float f_renamed) {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.withinSatMainRange(f_renamed);
        }
        return false;
    }

    public boolean c_renamed(float f_renamed) {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.withinSatMainAndWideRange(f_renamed);
        }
        return false;
    }

    public boolean cv_renamed() {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.isVideoSuperEisWideOpen();
        }
        return false;
    }

    public void cw_renamed() {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            baseMode.resetCaptureButton();
        }
    }

    public void a_renamed(com.oplus.camera.u_renamed.a_renamed aVar) {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            baseMode.setPreviewDetectResult(aVar);
        }
    }

    public boolean cx_renamed() {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.isTrackFocusOpen();
        }
        return false;
    }

    public void cy_renamed() {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            baseMode.updateTrackEnable();
        }
    }

    public boolean cz_renamed() {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.isFaceRectifyOpen();
        }
        return false;
    }

    public void cA_renamed() {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            baseMode.onHomeKeyClick();
        }
    }

    public void cB_renamed() {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            baseMode.onCameraPermissionGranted();
        }
    }

    public void p_renamed(java.lang.String str) {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            baseMode.onMenuOptionAdded(str);
        }
    }

    public void q_renamed(java.lang.String str) {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            baseMode.onMenuOptionRemoved(str);
        }
    }

    public boolean cC_renamed() {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        return baseMode != null && baseMode.isQrCodeOpened();
    }

    public void cD_renamed() {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            baseMode.stopRecordingFrame();
        }
    }

    public void cE_renamed() {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            baseMode.onFrameInterpolationStarted();
        }
    }

    public void cF_renamed() {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            baseMode.onMotionDetected();
        }
    }

    public com.oplus.camera.ui.control.e_renamed.c_renamed cG_renamed() {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.getAfterStoreRunnable();
        }
        return null;
    }

    public void a_renamed(android.hardware.camera2.CaptureResult captureResult) {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            baseMode.onReceivePreviewCaptureResult(captureResult);
        }
    }

    public boolean cH_renamed() {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.isShowSceneNightTips();
        }
        return false;
    }

    public boolean cI_renamed() {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.getSupportGestureCapture();
        }
        return true;
    }

    public boolean cJ_renamed() {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.isUltraNightVideoOpen();
        }
        return false;
    }

    public boolean cK_renamed() {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.isAiEnhancementVideoOpen();
        }
        return false;
    }

    public boolean cL_renamed() {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.isSuperEISOpen();
        }
        return false;
    }

    public void a_renamed(java.lang.String str, boolean z_renamed) {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            baseMode.updateFlashState(str, z_renamed);
        }
    }

    public void v_renamed(boolean z_renamed) {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            baseMode.setFlashTemporaryDisabled(z_renamed);
        }
    }

    public android.util.Size a_renamed(android.util.Size size) {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        return baseMode != null ? baseMode.getPreviewSurfaceSize(size) : size;
    }

    public void cM_renamed() {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            baseMode.clearApsDecisionResult();
        }
    }

    public boolean cN_renamed() {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.isSupportSelectPhotoRatio();
        }
        return false;
    }

    public boolean cO_renamed() {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.isSlowVideoMode();
        }
        return false;
    }

    public boolean cP_renamed() {
        return this.mCurrentMode instanceof com.oplus.camera.capmode.y_renamed;
    }

    public boolean cQ_renamed() {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.isMultiVideoMode();
        }
        return false;
    }

    public boolean cR_renamed() {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.isNeedTransAnimWhenRecording();
        }
        return false;
    }

    public boolean cS_renamed() {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        return baseMode != null && baseMode.isStarryMode();
    }

    public boolean cT_renamed() {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        return baseMode != null && baseMode.consumeBackEventOnPictureTaken();
    }

    public void w_renamed(boolean z_renamed) {
        synchronized (this) {
            if (this.d_renamed != null) {
                java.util.Iterator<java.lang.String> it = this.d_renamed.keySet().iterator();
                while (it.hasNext()) {
                    com.oplus.camera.capmode.BaseMode baseMode = this.d_renamed.get(it.next());
                    if (baseMode != null) {
                        baseMode.restoreDefaultMode(z_renamed);
                    }
                }
            }
        }
    }

    public java.lang.String cU_renamed() {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.getGuideLineType();
        }
        return null;
    }

    public void x_renamed(boolean z_renamed) {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            baseMode.setNeedCapture(z_renamed);
        }
    }

    public float cV_renamed() {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.getPreviewXScale();
        }
        return 1.0f;
    }

    public boolean cW_renamed() {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        return baseMode != null && baseMode.isCropX();
    }

    public boolean a_renamed(boolean z_renamed, int i_renamed, int i2) {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        return baseMode != null && baseMode.getTouchEnable(z_renamed, i_renamed, i2);
    }

    public int cX_renamed() {
        return this.mCurrentMode.getEntryGalleryAnim();
    }

    public boolean cY_renamed() {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        return baseMode != null && baseMode.is10bitsHeicEncodeEnable();
    }

    public boolean cZ_renamed() {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        return baseMode != null && baseMode.needLutTexture();
    }

    public boolean da_renamed() {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        return baseMode != null && baseMode.needShow10bitHint();
    }

    public void db_renamed() {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            baseMode.onMoreModeShown();
        }
    }

    public void u_renamed(int i_renamed) {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            baseMode.onMoreModeHidden(i_renamed);
        }
    }

    public long dc_renamed() {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.getCaptureDate();
        }
        return 0L;
    }

    public boolean dd_renamed() {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.isSupportLensSwicth();
        }
        return false;
    }

    public int de_renamed() {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.getCaptureIso();
        }
        return -1;
    }

    public long df_renamed() {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.getCaptureExposureTime();
        }
        return -1L;
    }

    public void v_renamed(int i_renamed) {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            baseMode.onSlowVideoFrameChange(i_renamed);
        }
    }

    public void a_renamed(int i_renamed, int i2, boolean z_renamed, int i3) {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            baseMode.reportIntelligentDragViewMoveToDcs(i_renamed, i2, z_renamed, i3);
        }
    }

    public void dg_renamed() {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            baseMode.onFaceBeautyMenuClose();
        }
    }

    public synchronized void a_renamed(com.oplus.camera.aps.service.ApsService apsService) {
        if (this.mCurrentMode != null) {
            this.mCurrentMode.setApsService(apsService);
        }
    }

    public void dh_renamed() {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            baseMode.revertOp();
        }
    }

    public void y_renamed(boolean z_renamed) {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            baseMode.cancelOp(z_renamed);
        }
    }

    public boolean di_renamed() {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.isDoubleExposureOpen();
        }
        return false;
    }

    public void a_renamed(byte[] bArr) {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            baseMode.onYuvDataReceviced(bArr);
        }
    }

    public boolean dj_renamed() {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        return baseMode != null && baseMode.isMirrorEnable();
    }

    public void d_renamed(float f_renamed) {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            baseMode.setVideoSoundValue(f_renamed);
        }
    }

    public void dk_renamed() {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            baseMode.checkAiEnhancementVideoState();
        }
    }

    public void z_renamed(boolean z_renamed) {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            baseMode.setFocusTrackingState(z_renamed);
        }
    }

    public void a_renamed(float f_renamed, float f2) {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            baseMode.setFocusTrackingLocation(f_renamed, f2);
        }
    }

    public void a_renamed(java.lang.String str, java.lang.Object obj, boolean z_renamed, boolean z2) {
        java.util.Map<java.lang.String, com.oplus.camera.capmode.BaseMode> map;
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode == null || (map = this.d_renamed) == null || obj == null) {
            return;
        }
        if (z_renamed) {
            baseMode.operateSpecificViewCallBack(obj, true, z2);
            return;
        }
        com.oplus.camera.capmode.BaseMode baseMode2 = map.get(str);
        if (baseMode2 != null) {
            baseMode2.operateSpecificViewCallBack(obj, false, z2);
        }
    }

    public java.lang.String dl_renamed() {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        return baseMode != null ? baseMode.getCurrFilterType() : "default";
    }

    public java.lang.String dm_renamed() {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        return baseMode != null ? baseMode.getFilterEffectMenuPreferenceKey() : "key_filter_index";
    }

    public java.lang.String dn_renamed() {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        return baseMode != null ? baseMode.getEffectMenuKeyByMode() : com.oplus.camera.ui.CameraUIInterface.KEY_FILTER_MENU;
    }

    /* renamed from: do, reason: not valid java name */
    public java.lang.String m38do() {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        return baseMode != null ? baseMode.getBlurMenuKeyByMode() : com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_BLUR_MENU;
    }

    public boolean dp_renamed() {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.needPostProcessAfterStopRecord();
        }
        return false;
    }

    public boolean dq_renamed() {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        return baseMode != null && baseMode.is4k60fps() && com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_SUPPORT_VIDEO_4K_60FPS_ULTRA_WIDE);
    }

    public void a_renamed(com.oplus.camera.doubleexposure.b_renamed bVar, com.oplus.camera.doubleexposure.g_renamed.a_renamed aVar) {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            baseMode.onVideoLoadedDone(bVar, aVar);
        }
    }

    public void A_renamed(boolean z_renamed) {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            baseMode.startLoadVideo(z_renamed);
        }
    }

    public void w_renamed(int i_renamed) {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            baseMode.onModeShownTips(i_renamed);
        }
    }

    public boolean dr_renamed() {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.shouldHideBlur();
        }
        return true;
    }

    public void B_renamed(boolean z_renamed) {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            baseMode.setVideoBlurEffect(z_renamed);
        }
    }

    public boolean ds_renamed() {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.isBottomGuideEntryViewShown();
        }
        return false;
    }

    public void dt_renamed() {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            baseMode.updateEffectMenuNames();
        }
    }

    public void du_renamed() {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            baseMode.stopVideoRestoreUIWithControlUI();
        }
    }

    public long dv_renamed() {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.getCaptureMergeIdentity();
        }
        return 0L;
    }

    public void a_renamed(com.oplus.ocs.camera.CameraPictureCallback.CameraPictureImage cameraPictureImage) {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            baseMode.onRawImageReceived(cameraPictureImage);
        }
    }

    public boolean b_renamed(com.oplus.ocs.camera.CameraPictureCallback.CameraPictureImage cameraPictureImage) {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.consumeImage(cameraPictureImage);
        }
        return false;
    }

    public void dw_renamed() {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            baseMode.beforeConfig();
        }
    }

    public boolean dx_renamed() {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.isNeedResetAutoFocus();
        }
        return true;
    }

    public void C_renamed(boolean z_renamed) {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            baseMode.setOpenFaceBeautyMenu(z_renamed);
        }
    }

    public boolean dy_renamed() {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.isShowZoomMenu();
        }
        return false;
    }

    public boolean dz_renamed() {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.isAutoFocus();
        }
        return false;
    }

    public int dA_renamed() {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.getAssistViewLayoutType();
        }
        return 0;
    }

    public void dB_renamed() {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            baseMode.beforeModeChanged();
        }
    }

    public boolean dC_renamed() {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.isShowFixFocusMenu();
        }
        return false;
    }

    public boolean dD_renamed() {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.isAfFixFocuse();
        }
        return false;
    }

    public boolean dE_renamed() {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.isSupportAutoFocus();
        }
        return true;
    }

    public boolean dF_renamed() {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.isStreetOpen();
        }
        return false;
    }

    public boolean dG_renamed() {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        return baseMode != null && baseMode.isAutoFlash() && this.mCurrentMode.mbAutoFlash;
    }

    public boolean dH_renamed() {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.checkVideoHdrPreCondition();
        }
        return false;
    }

    public boolean dI_renamed() {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.check3HDRPreCondition();
        }
        return false;
    }

    public boolean dJ_renamed() {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.isVideoHdrOpen();
        }
        return false;
    }

    public int dK_renamed() {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.getDefaultBlurValue();
        }
        return 60;
    }

    public boolean dL_renamed() {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.isInProMode();
        }
        return false;
    }

    public boolean c_renamed(com.oplus.ocs.camera.CameraPictureCallback.CameraPictureImage cameraPictureImage) {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        return baseMode != null && baseMode.onImageReceived(cameraPictureImage);
    }

    public int dM_renamed() {
        return this.mCurrentMode.getExpectedFrameRate();
    }

    public void dN_renamed() {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            baseMode.onSendCapturePictureRequest();
        }
    }

    public void a_renamed(java.util.Map<java.lang.String, java.lang.Object> map) {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            baseMode.generateImageInfo(map);
        }
    }

    public void dO_renamed() {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            baseMode.onCancleCapturePictureRequest();
        }
    }

    public com.oplus.camera.ui.q_renamed dP_renamed() {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.getPreviewOutlineProvider();
        }
        return null;
    }

    public boolean e_renamed(android.view.MotionEvent motionEvent) {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            return baseMode.isInSlideModeChangeAreaForFull(motionEvent);
        }
        return false;
    }

    public void dQ_renamed() {
        com.oplus.camera.capmode.BaseMode baseMode = this.mCurrentMode;
        if (baseMode != null) {
            baseMode.onMenuBackButtonClick();
        }
    }
}

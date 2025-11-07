package com.oplus.camera.s_renamed;

/* compiled from: StarryMode.java */
/* loaded from: classes2.dex */
public class d_renamed extends com.oplus.camera.capmode.BaseMode {
    private static final int g_renamed = com.oplus.camera.aps.config.CameraConfig.getConfigIntValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_STARRY_MODE_PROCESS_TIME);
    private static long h_renamed = com.oplus.camera.aps.config.CameraConfig.getConfigIntValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_STARRY_MODE_CAPTURE_EXPOSURETIME);
    private static int i_renamed = com.oplus.camera.aps.config.CameraConfig.getConfigIntValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_STARRY_MODE_CAPTURE_ISO);
    private long j_renamed;
    private com.oplus.camera.s_renamed.e_renamed k_renamed;

    @Override // com.oplus.camera.capmode.BaseMode
    public java.lang.String getCameraMode() {
        return com.oplus.camera.aps.constant.ApsConstant.CAPTURE_MODE_STARRY;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean getFrontEnable() {
        return false;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public int getOperatingMode() {
        return 32936;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean getSupportQuickJpeg(com.oplus.camera.e_renamed.c_renamed cVar) {
        return false;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected boolean isHideUICapture() {
        return true;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean isNeedShowMenuOnTimeSnapShotEnd() {
        return false;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean isStarryMode() {
        return true;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean needDelayCloseForCapture() {
        return false;
    }

    public d_renamed(android.app.Activity activity, com.oplus.camera.capmode.a_renamed aVar, com.oplus.camera.ui.CameraUIInterface cameraUIInterface, com.oplus.camera.ui.preview.a_renamed.t_renamed tVar) {
        super(activity, aVar, cameraUIInterface, tVar);
        this.j_renamed = 0L;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void onInitCameraMode() {
        if (this.k_renamed == null) {
            this.k_renamed = new com.oplus.camera.s_renamed.e_renamed(this.mActivity, this.mCameraUIInterface, new com.oplus.camera.s_renamed.e_renamed.a_renamed() { // from class: com.oplus.camera.s_renamed.d_renamed.1
                @Override // com.oplus.camera.s_renamed.e_renamed.a_renamed
                public void a_renamed() {
                    com.oplus.camera.s_renamed.d_renamed.this.k_renamed.a_renamed(com.oplus.camera.s_renamed.d_renamed.this.getShutterButtonInfo(), true);
                    com.oplus.camera.s_renamed.d_renamed.this.mCameraInterface.a_renamed(true, false);
                }

                @Override // com.oplus.camera.s_renamed.e_renamed.a_renamed
                public boolean b_renamed() {
                    return com.oplus.camera.s_renamed.d_renamed.this.isPanelMode();
                }
            });
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void onBeforePreview() {
        com.oplus.camera.e_renamed.a_renamed("StarryMode", "onBeforePreview");
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onAfterStartPreview(boolean z_renamed) {
        this.mOneCamera.a_renamed(getCameraInfo(this.mCameraInterface.as_renamed()).m_renamed(), true);
        this.k_renamed.a_renamed(this.mCameraInterface.g_renamed());
        super.onAfterStartPreview(z_renamed);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected boolean onBeforeSnapping(com.oplus.camera.e_renamed.c_renamed cVar) {
        com.oplus.camera.e_renamed.a_renamed("StarryMode", "onBeforeSnapping");
        if (getNightStateDecision() > 0) {
            a_renamed(getNightStateDecision());
        }
        this.mActivity.runOnUiThread(new java.lang.Runnable() { // from class: com.oplus.camera.s_renamed.d_renamed.2
            @Override // java.lang.Runnable
            public void run() {
                com.oplus.camera.s_renamed.d_renamed.this.mCameraInterface.a_renamed((android.animation.AnimatorListenerAdapter) null, true, false);
            }
        });
        this.k_renamed.a_renamed(this.mCameraInterface.g_renamed());
        this.k_renamed.a_renamed(this.j_renamed + g_renamed);
        if (this.mOneCamera != null) {
            this.mOneCamera.a_renamed((android.hardware.camera2.CaptureRequest.Key<android.hardware.camera2.CaptureRequest.Key>) android.hardware.camera2.CaptureRequest.CONTROL_AWB_LOCK, (android.hardware.camera2.CaptureRequest.Key) true);
            this.mOneCamera.b_renamed(true, false);
        }
        return true;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean onAfterSnapping() {
        this.mCameraInterface.c_renamed(0);
        return super.onAfterSnapping();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected boolean onStopTakePicture() {
        if (this.mCameraUIInterface.s_renamed() != 3) {
            return false;
        }
        com.oplus.camera.e_renamed.b_renamed("StarryMode", "onStopTakePicture");
        this.mOneCamera.h_renamed();
        this.mOneCamera.a_renamed((android.hardware.camera2.CaptureRequest.Key<android.hardware.camera2.CaptureRequest.Key>) android.hardware.camera2.CaptureRequest.CONTROL_AWB_LOCK, (android.hardware.camera2.CaptureRequest.Key) false);
        this.mOneCamera.b_renamed(false, false);
        a_renamed(0);
        this.k_renamed.b_renamed();
        this.k_renamed.a_renamed(getShutterButtonInfo(), false);
        this.mCameraInterface.W_renamed();
        this.mCameraInterface.f_renamed(true);
        this.mbInCapturing = false;
        return true;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void onAfterPictureTaken(byte[] bArr, boolean z_renamed) {
        this.mCameraInterface.aJ_renamed();
        this.mActivity.runOnUiThread(new java.lang.Runnable() { // from class: com.oplus.camera.s_renamed.d_renamed.3
            @Override // java.lang.Runnable
            public void run() {
                if (com.oplus.camera.s_renamed.d_renamed.this.k_renamed != null) {
                    com.oplus.camera.s_renamed.d_renamed.this.k_renamed.b_renamed();
                    if (com.oplus.camera.s_renamed.d_renamed.this.mCameraUIInterface.s_renamed() == 4) {
                        com.oplus.camera.s_renamed.d_renamed.this.k_renamed.a_renamed(com.oplus.camera.s_renamed.d_renamed.this.getShutterButtonInfo(), true);
                    }
                }
            }
        });
        if (this.mOneCamera != null) {
            this.mOneCamera.a_renamed((android.hardware.camera2.CaptureRequest.Key<android.hardware.camera2.CaptureRequest.Key>) android.hardware.camera2.CaptureRequest.CONTROL_AWB_LOCK, (android.hardware.camera2.CaptureRequest.Key) false);
            this.mOneCamera.b_renamed(false, false);
            this.mOneCamera.a_renamed((com.oplus.camera.e_renamed.d_renamed.c_renamed) null);
        }
    }

    private void a_renamed(int i2) {
        if (this.mOneCamera == null) {
            return;
        }
        this.mOneCamera.o_renamed(i2);
        this.mOneCamera.a_renamed((com.oplus.camera.e_renamed.d_renamed.c_renamed) null);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void onPause() {
        com.oplus.camera.e_renamed.a_renamed("StarryMode", "onPause");
        this.k_renamed.a_renamed();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void onStop() {
        com.oplus.camera.e_renamed.a_renamed("StarryMode", "OnStop");
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void onDeInitCameraMode(java.lang.String str) {
        com.oplus.camera.e_renamed.a_renamed("StarryMode", "onDeInitCameraMode");
        this.k_renamed.a_renamed();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void onDestroy() {
        com.oplus.camera.e_renamed.a_renamed("StarryMode", "onDestroy");
        com.oplus.camera.s_renamed.e_renamed eVar = this.k_renamed;
        if (eVar != null) {
            eVar.c_renamed();
            this.k_renamed = null;
        }
    }

    /* JADX WARN: Can't_renamed fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B_renamed:32:0x0065  */
    @Override // com.oplus.camera.capmode.BaseMode
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean getSupportFunction(java.lang.String r4) {
        /*
            r3 = this;
            int r0 = r4.hashCode()
            r1 = 0
            r2 = 1
            switch(r0) {
                case -1957553773: goto L5b;
                case -1826833948: goto L51;
                case -1693318428: goto L47;
                case -1593450737: goto L3c;
                case -681469213: goto L32;
                case 276021746: goto L28;
                case 336270991: goto L1e;
                case 1599576324: goto L14;
                case 2118868211: goto La;
                default: goto L9;
            }
        L9:
            goto L65
        La:
            java.lang.String r0 = "pref_camera_tap_shutter_key"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L65
            r0 = 4
            goto L66
        L14:
            java.lang.String r0 = "pref_support_switch_camera"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L65
            r0 = 6
            goto L66
        L1e:
            java.lang.String r0 = "pref_zoom_key"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L65
            r0 = 7
            goto L66
        L28:
            java.lang.String r0 = "pref_camera_pi_ai_mode_key"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L65
            r0 = 2
            goto L66
        L32:
            java.lang.String r0 = "key_support_update_thumbnail_user_picture"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L65
            r0 = r2
            goto L66
        L3c:
            java.lang.String r0 = "pref_watermark_function_key"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L65
            r0 = 8
            goto L66
        L47:
            java.lang.String r0 = "pref_manual_exposure_key"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L65
            r0 = 3
            goto L66
        L51:
            java.lang.String r0 = "pref_continuous_focus_key"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L65
            r0 = 5
            goto L66
        L5b:
            java.lang.String r0 = "pref_support_raw_post_process"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L65
            r0 = r1
            goto L66
        L65:
            r0 = -1
        L66:
            switch(r0) {
                case 0: goto L8a;
                case 1: goto L8a;
                case 2: goto L89;
                case 3: goto L89;
                case 4: goto L89;
                case 5: goto L89;
                case 6: goto L82;
                case 7: goto L7b;
                case 8: goto L6e;
                default: goto L69;
            }
        L69:
            boolean r3 = super.getSupportFunction(r4)
            return r3
        L6e:
            java.lang.String r4 = r3.getCameraMode()
            int r3 = r3.mCameraId
            java.lang.String r0 = "aps_algo_watermark"
            boolean r3 = com.oplus.camera.aps.util.AlgoSwitchConfig.getSupportCaptureAlgo(r4, r3, r0)
            return r3
        L7b:
            java.lang.String r3 = "com.oplus.night.starry.zoom.support"
            boolean r3 = com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(r3)
            return r3
        L82:
            java.lang.String r3 = "com.oplus.star.video.support"
            boolean r3 = com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(r3)
            return r3
        L89:
            return r1
        L8a:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.s_renamed.d_renamed.getSupportFunction(java.lang.String):boolean");
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean getSupportMenu(java.lang.String str) {
        if (com.oplus.camera.ui.CameraUIInterface.KEY_CAMERA_TIMER_SHUTTER.equals(str) || com.oplus.camera.ui.CameraUIInterface.KEY_SETTING.equals(str) || com.oplus.camera.ui.CameraUIInterface.KEY_PHOTO_RATIO.equals(str)) {
            return true;
        }
        return super.getSupportMenu(str);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onPreviewCaptureResult(com.oplus.ocs.camera.CameraPreviewCallback.CameraPreviewResult cameraPreviewResult) {
        super.onPreviewCaptureResult(cameraPreviewResult);
        if (cameraPreviewResult == null || cameraPreviewResult.getCaptureResult() == null) {
            com.oplus.camera.e_renamed.f_renamed("StarryMode", "onPreviewCaptureResult, invalid previewResult: " + cameraPreviewResult);
            return;
        }
        if (this.mbInCapturing) {
            return;
        }
        a_renamed(cameraPreviewResult.getCaptureResult());
    }

    private void a_renamed(android.hardware.camera2.CaptureResult captureResult) {
        long jB = b_renamed(captureResult);
        if (jB <= 0) {
            this.j_renamed = h_renamed * getDefaultCaptureNumber();
        } else {
            this.j_renamed = jB / 1000000;
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public int getDefaultCaptureNumber() {
        synchronized (this.mApsDecisionResultLock) {
            if (this.mDecisionResult == null || this.mDecisionResult.mMultiFrameCount <= 0) {
                return 15;
            }
            return this.mDecisionResult.mMultiFrameCount;
        }
    }

    private long b_renamed(android.hardware.camera2.CaptureResult captureResult) {
        java.lang.Object objA;
        if (captureResult == null || (objA = com.oplus.camera.e_renamed.b_renamed.a_renamed(captureResult, com.oplus.camera.e_renamed.b_renamed.bh_renamed)) == null) {
            return -1L;
        }
        return ((long[]) objA)[0];
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public com.oplus.camera.af_renamed getZoomConfigure() {
        com.oplus.camera.af_renamed zoomConfigure = super.getZoomConfigure();
        zoomConfigure.p_renamed(true);
        zoomConfigure.y_renamed(true);
        return zoomConfigure;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean needSurface(java.lang.String str) {
        if ("type_tuning_data_raw".equals(str) || "type_tuning_data_yuv".equals(str)) {
            return false;
        }
        if ("type_capture".equals(str)) {
            return true;
        }
        return super.needSurface(str);
    }
}

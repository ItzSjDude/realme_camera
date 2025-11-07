package com.oplus.camera.p_renamed;

/* compiled from: QuickCaptureMode.java */
/* loaded from: classes2.dex */
public class a_renamed extends com.oplus.camera.capmode.d_renamed {
    private boolean g_renamed;
    private com.oplus.camera.p_renamed.b_renamed h_renamed;

    @Override // com.oplus.camera.capmode.BaseMode
    protected boolean canShowResumeButton() {
        return false;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean needDelayFaceDetection() {
        return true;
    }

    public a_renamed(android.app.Activity activity, com.oplus.camera.capmode.a_renamed aVar, com.oplus.camera.ui.CameraUIInterface cameraUIInterface, com.oplus.camera.ui.preview.a_renamed.t_renamed tVar) {
        super(activity, aVar, cameraUIInterface, tVar);
        this.g_renamed = false;
        this.h_renamed = null;
        this.h_renamed = new com.oplus.camera.p_renamed.b_renamed(activity, aVar, cameraUIInterface, tVar);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void updateOneCamera(com.oplus.camera.e_renamed.d_renamed dVar) {
        super.updateOneCamera(dVar);
        this.h_renamed.updateOneCamera(dVar);
    }

    @Override // com.oplus.camera.capmode.d_renamed
    protected void resetAfterPictureTaken(boolean z_renamed, boolean z2) {
        boolean supportFunction;
        super.resetAfterPictureTaken(z_renamed, z2);
        if ((!this.mbCaptureRawTimeDone && z_renamed) || this.mActivity == null || this.mPreferences == null) {
            return;
        }
        java.lang.String string = this.mActivity.getString(com.oplus.camera.R_renamed.string.camera_setting_long_process_shutter_default_value);
        java.lang.String string2 = this.mPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_LONG_PROCESS_SHUTTER_CHOICE, string);
        if (string.equals(string2)) {
            supportFunction = getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_QUICK_VIDEO);
        } else {
            supportFunction = getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_BURST_SHOT);
        }
        this.mCameraUIInterface.a_renamed(getShutterButtonInfo(), supportFunction);
        com.oplus.camera.e_renamed.a_renamed("QuickCaptureMode", "resetAfterPictureTaken, defaultValue: " + string + ", choiceValue: " + string2 + ", longClickable: " + supportFunction);
    }

    /* JADX WARN: Can't_renamed fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B_renamed:26:0x0050  */
    @Override // com.oplus.camera.capmode.d_renamed, com.oplus.camera.capmode.BaseMode
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean getSupportFunction(java.lang.String r5) {
        /*
            r4 = this;
            int r0 = r5.hashCode()
            r1 = 1
            r2 = 0
            switch(r0) {
                case -1633814243: goto L46;
                case -1593450737: goto L3c;
                case -1135915663: goto L32;
                case -681469213: goto L28;
                case -185556839: goto L1e;
                case 1640046025: goto L14;
                case 1706373443: goto La;
                default: goto L9;
            }
        L9:
            goto L50
        La:
            java.lang.String r0 = "pref_support_capture_preview"
            boolean r0 = r5.equals(r0)
            if (r0 == 0) goto L50
            r0 = 4
            goto L51
        L14:
            java.lang.String r0 = "key_quick_video"
            boolean r0 = r5.equals(r0)
            if (r0 == 0) goto L50
            r0 = r1
            goto L51
        L1e:
            java.lang.String r0 = "pref_camera_gesture_shutter_key"
            boolean r0 = r5.equals(r0)
            if (r0 == 0) goto L50
            r0 = 5
            goto L51
        L28:
            java.lang.String r0 = "key_support_update_thumbnail_user_picture"
            boolean r0 = r5.equals(r0)
            if (r0 == 0) goto L50
            r0 = 3
            goto L51
        L32:
            java.lang.String r0 = "pref_ai_scene_key"
            boolean r0 = r5.equals(r0)
            if (r0 == 0) goto L50
            r0 = 6
            goto L51
        L3c:
            java.lang.String r0 = "pref_watermark_function_key"
            boolean r0 = r5.equals(r0)
            if (r0 == 0) goto L50
            r0 = 2
            goto L51
        L46:
            java.lang.String r0 = "support_focus_out_of_range"
            boolean r0 = r5.equals(r0)
            if (r0 == 0) goto L50
            r0 = r2
            goto L51
        L50:
            r0 = -1
        L51:
            switch(r0) {
                case 0: goto Lc0;
                case 1: goto L8a;
                case 2: goto L66;
                case 3: goto L61;
                case 4: goto L61;
                case 5: goto L56;
                case 6: goto L56;
                default: goto L54;
            }
        L54:
            goto Lc1
        L56:
            boolean r0 = r4.g_renamed
            if (r0 == 0) goto Lc1
            com.oplus.camera.p_renamed.b_renamed r4 = r4.h_renamed
            boolean r4 = r4.getSupportFunction(r5)
            return r4
        L61:
            boolean r0 = r4.g_renamed
            if (r0 == 0) goto Lc1
            return r2
        L66:
            boolean r0 = r4.g_renamed
            if (r0 == 0) goto L71
            com.oplus.camera.p_renamed.b_renamed r4 = r4.h_renamed
            boolean r4 = r4.getSupportFunction(r5)
            return r4
        L71:
            java.lang.String r5 = "com.oplus.video.watermark.support"
            boolean r5 = com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(r5)
            if (r5 == 0) goto L88
            java.lang.String r5 = r4.getCameraMode()
            int r4 = r4.mCameraId
            java.lang.String r0 = "aps_algo_watermark"
            boolean r4 = com.oplus.camera.aps.util.AlgoSwitchConfig.getSupportCaptureAlgo(r5, r4, r0)
            if (r4 == 0) goto L88
            goto L89
        L88:
            r1 = r2
        L89:
            return r1
        L8a:
            android.app.Activity r5 = r4.mActivity
            if (r5 == 0) goto Lc0
            android.content.SharedPreferences r5 = r4.mPreferences
            if (r5 == 0) goto Lc0
            java.lang.String r5 = "com.oplus.quick.video.support"
            boolean r5 = com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(r5)
            if (r5 == 0) goto Lc0
            android.app.Activity r5 = r4.mActivity
            r0 = 2131755866(0x7f10035a, float:1.9142623E38)
            java.lang.String r5 = r5.getString(r0)
            android.content.SharedPreferences r0 = r4.mPreferences
            java.lang.String r3 = "pref_long_process_choice_key"
            java.lang.String r0 = r0.getString(r3, r5)
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto Lbe
            com.oplus.camera.capmode.a_renamed r5 = r4.mCameraInterface
            if (r5 == 0) goto Lbe
            com.oplus.camera.capmode.a_renamed r4 = r4.mCameraInterface
            boolean r4 = r4.i_renamed()
            if (r4 == 0) goto Lbe
            goto Lbf
        Lbe:
            r1 = r2
        Lbf:
            return r1
        Lc0:
            return r2
        Lc1:
            boolean r4 = super.getSupportFunction(r5)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.p_renamed.a_renamed.getSupportFunction(java.lang.String):boolean");
    }

    @Override // com.oplus.camera.capmode.d_renamed, com.oplus.camera.capmode.BaseMode
    public boolean getSupportMenu(java.lang.String str) {
        return super.getSupportMenu(com.oplus.camera.entry.b_renamed.d_renamed(str));
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean isVideoModeType() {
        if (this.g_renamed) {
            return this.h_renamed.isVideoModeType();
        }
        return super.isVideoModeType();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public int getVideoFps() {
        if (this.g_renamed) {
            return this.h_renamed.getVideoFps();
        }
        return super.getVideoFps();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onShutterButtonLongClick() {
        if (1 == android.provider.Settings.System.getInt(this.mActivity.getContentResolver(), "oplus.camera.video", 0)) {
            this.mCameraUIInterface.a_renamed(com.oplus.camera.R_renamed.string.camera_high_temperature_video_record_disable, -1, true, false, false);
            this.mCameraUIInterface.aC_renamed();
            this.mCameraUIInterface.a_renamed(0, 2);
            this.mCameraUIInterface.l_renamed(true, false);
            com.oplus.camera.e_renamed.f_renamed("QuickCaptureMode", "onShutterButtonLongClick, Can't_renamed start recording video due to high temperature, so return");
            return;
        }
        android.util.Size previewSize = getPreviewSize(this.mOneCamera.e_renamed());
        this.mCameraUIInterface.a_renamed(a_renamed());
        this.h_renamed.j_renamed();
        this.h_renamed.a_renamed(previewSize);
        if (this.mbFrontCamera) {
            this.g_renamed = true;
            this.h_renamed.f_renamed();
        }
        if (isGoogleLensEnable()) {
            hideGoogleLensIcon(true);
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onVideoTemperatureThresholdChanged(int i_renamed) {
        com.oplus.camera.p_renamed.b_renamed bVar = this.h_renamed;
        if (bVar != null) {
            bVar.onVideoTemperatureThresholdChanged(i_renamed);
        }
    }

    @Override // com.oplus.camera.capmode.d_renamed, com.oplus.camera.capmode.BaseMode
    public void resetFiltersList() {
        super.resetFiltersList();
    }

    @Override // com.oplus.camera.capmode.d_renamed, com.oplus.camera.capmode.BaseMode
    public void updateGrandTourCityFiltersPosition(java.lang.String str) {
        super.updateGrandTourCityFiltersPosition(str);
    }

    @Override // com.oplus.camera.capmode.d_renamed, com.oplus.camera.capmode.BaseMode
    public android.util.Size getPictureSize(com.oplus.camera.e_renamed.h_renamed hVar) {
        if (this.g_renamed) {
            return this.h_renamed.getPictureSize(hVar);
        }
        return super.getPictureSize(hVar);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void stopQuickVideoRecording() {
        com.oplus.camera.e_renamed.a_renamed("QuickCaptureMode", "stopQuickVideoRecording");
        if (com.oplus.camera.ui.widget.LockViewDragLayout.a_renamed()) {
            com.oplus.camera.ui.widget.LockViewDragLayout.setIsQuickVideoStartedByShutterButtonLongClick(false);
        }
        this.h_renamed.h_renamed();
        this.g_renamed = false;
        this.h_renamed.k_renamed();
        this.mCameraUIInterface.q_renamed();
        if (isGoogleLensEnable()) {
            showGoogleLensIcon(true);
        }
    }

    @Override // com.oplus.camera.capmode.d_renamed
    public boolean isGoogleLensEnable() {
        return !this.g_renamed && super.isGoogleLensEnable();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void afterStopRecording() {
        this.g_renamed = false;
        super.afterStopRecording();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected boolean getQuickVideoRecording() {
        return this.g_renamed;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void setQuickVideoBeforeLockTime(boolean z_renamed) {
        this.h_renamed.setQuickVideoBeforeLockTime(z_renamed);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected boolean isQuickVideoInRestriction() {
        return this.h_renamed.l_renamed();
    }

    @Override // com.oplus.camera.capmode.d_renamed, com.oplus.camera.capmode.BaseMode
    protected void onPause() {
        if (this.g_renamed) {
            this.g_renamed = false;
            this.h_renamed.onPause();
        } else {
            super.onPause();
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onApsPreviewCaptureCompleted(com.oplus.ocs.camera.CameraPreviewCallback.CameraPreviewResult cameraPreviewResult, boolean z_renamed) {
        if (!this.mbFrontCamera && !this.g_renamed && z_renamed && cameraPreviewResult != null && a_renamed(cameraPreviewResult)) {
            this.g_renamed = true;
            com.oplus.camera.ui.widget.LockViewDragLayout.setLongPressState(false);
            this.h_renamed.f_renamed();
        } else {
            if (this.g_renamed || z_renamed || cameraPreviewResult == null) {
                return;
            }
            b_renamed(cameraPreviewResult);
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean onVideoRecordingPause() {
        return this.h_renamed.onVideoRecordingPause();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean onVideoRecordingResume() {
        return this.h_renamed.onVideoRecordingResume();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean isVideoRecordStopped() {
        return this.h_renamed.isVideoRecordStopped();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean isVideoRecording() {
        return this.h_renamed.isVideoRecording();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean isVideoRecordStarted() {
        return this.h_renamed.isVideoRecordStarted();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void forceStopVideoRecording(boolean z_renamed) {
        if (isGoogleLensEnable()) {
            showGoogleLensIcon(true);
        }
        this.h_renamed.forceStopVideoRecording(z_renamed);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean needApsToProcessVideoWatermark() {
        if (this.g_renamed) {
            return this.h_renamed.isVideoRecording();
        }
        return super.needApsToProcessVideoWatermark();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean isVideoRecordStarting() {
        return this.h_renamed.isVideoRecordStarting();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean isVideoRecordStopping() {
        return this.h_renamed.isVideoRecordStopping();
    }

    @Override // com.oplus.camera.capmode.d_renamed, com.oplus.camera.capmode.BaseMode
    protected void onBeforePictureTaken(byte[] bArr, boolean z_renamed) {
        if (this.g_renamed) {
            this.h_renamed.onBeforePictureTaken(bArr, z_renamed);
        } else {
            super.onBeforePictureTaken(bArr, z_renamed);
        }
    }

    @Override // com.oplus.camera.capmode.d_renamed, com.oplus.camera.capmode.BaseMode
    protected void onShutterCallback(boolean z_renamed, boolean z2) {
        if (this.g_renamed) {
            this.h_renamed.onShutterCallback(z_renamed, z2);
        } else {
            super.onShutterCallback(z_renamed, z2);
        }
    }

    @Override // com.oplus.camera.capmode.d_renamed, com.oplus.camera.capmode.BaseMode
    protected void onAfterPictureTaken(byte[] bArr, boolean z_renamed) {
        if (this.g_renamed) {
            this.h_renamed.onAfterPictureTaken(bArr, z_renamed);
        } else {
            super.onAfterPictureTaken(bArr, z_renamed);
        }
    }

    @Override // com.oplus.camera.capmode.d_renamed, com.oplus.camera.capmode.BaseMode
    public boolean isAISceneOpen() {
        if (this.g_renamed) {
            return false;
        }
        return super.isAISceneOpen();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public int getDefaultCaptureNumber() {
        if (this.g_renamed) {
            return this.h_renamed.getDefaultCaptureNumber();
        }
        return super.getDefaultCaptureNumber();
    }

    @Override // com.oplus.camera.capmode.d_renamed, com.oplus.camera.capmode.BaseMode
    public void onZoomChanged() {
        if (this.g_renamed) {
            this.h_renamed.onZoomChanged();
        } else {
            super.onZoomChanged();
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean isHalVideoRecording() {
        return 1 == this.h_renamed.g_renamed();
    }

    @Override // com.oplus.camera.capmode.d_renamed, com.oplus.camera.capmode.BaseMode
    protected boolean isHideHeadLine() {
        return 1 == this.h_renamed.g_renamed() && com.oplus.camera.ui.widget.LockViewDragLayout.getLongPressState();
    }

    @Override // com.oplus.camera.capmode.d_renamed, com.oplus.camera.capmode.BaseMode
    public boolean onBackPressed() {
        if (this.g_renamed) {
            this.g_renamed = false;
            return this.h_renamed.onBackPressed();
        }
        return super.onBackPressed();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void setOrientation(int i_renamed) {
        this.h_renamed.setOrientation(i_renamed);
        super.setOrientation(i_renamed);
    }

    @Override // com.oplus.camera.capmode.d_renamed, com.oplus.camera.capmode.BaseMode
    public void cameraIdChanged(int i_renamed) {
        this.h_renamed.cameraIdChanged(i_renamed);
        super.cameraIdChanged(i_renamed);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void setCameraId(int i_renamed) {
        this.h_renamed.setCameraId(i_renamed);
        super.setCameraId(i_renamed);
    }

    @Override // com.oplus.camera.capmode.d_renamed, com.oplus.camera.capmode.BaseMode
    protected boolean onBeforeSnapping(com.oplus.camera.e_renamed.c_renamed cVar) {
        if (this.g_renamed) {
            return this.h_renamed.onBeforeSnapping(cVar);
        }
        boolean zOnBeforeSnapping = super.onBeforeSnapping(cVar);
        this.mbCheckTakeAnimateDelay = false;
        return zOnBeforeSnapping;
    }

    @Override // com.oplus.camera.capmode.d_renamed, com.oplus.camera.capmode.BaseMode
    public void onAfterStartPreview(boolean z_renamed) {
        if (this.g_renamed) {
            this.h_renamed.onAfterStartPreview(z_renamed);
        } else {
            super.onAfterStartPreview(z_renamed);
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean withinSatMainAndWideRange(float f_renamed) {
        if (this.g_renamed) {
            return false;
        }
        return super.withinSatMainAndWideRange(f_renamed);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public com.oplus.camera.e_renamed.c_renamed getCaptureRequestTag(com.oplus.camera.aps.util.CameraApsDecision cameraApsDecision, boolean z_renamed) {
        com.oplus.camera.e_renamed.c_renamed captureRequestTag = super.getCaptureRequestTag(cameraApsDecision, z_renamed);
        captureRequestTag.ac_renamed = this.g_renamed;
        return captureRequestTag;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void beforeStartRecording() {
        if (this.mOneCamera != null) {
            if (this.mCameraInterface != null) {
                this.mOneCamera.a_renamed((android.hardware.camera2.CaptureRequest.Key<android.hardware.camera2.CaptureRequest.Key>) android.hardware.camera2.CaptureRequest.JPEG_ORIENTATION, (android.hardware.camera2.CaptureRequest.Key) java.lang.Integer.valueOf(getJpegOrientation(this.mCameraId, this.mCameraInterface.u_renamed())));
            }
            this.mOneCamera.a_renamed((com.oplus.camera.e_renamed.d_renamed.c_renamed) null);
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void onBinauralRecordStateChanged(boolean z_renamed) {
        this.h_renamed.onBinauralRecordStateChanged(z_renamed);
    }

    public com.oplus.camera.ui.control.b_renamed a_renamed() {
        return new com.oplus.camera.ui.control.b_renamed(1);
    }

    private boolean a_renamed(com.oplus.ocs.camera.CameraPreviewCallback.CameraPreviewResult cameraPreviewResult) {
        return !(cameraPreviewResult == null || cameraPreviewResult.get(com.oplus.ocs.camera.CameraParameter.PREVIEW_RESULT_VIDEO_EIS) == null || 1 != ((java.lang.Integer) cameraPreviewResult.get(com.oplus.ocs.camera.CameraParameter.PREVIEW_RESULT_VIDEO_EIS)).intValue()) || isMonoIndex(getCurrFilterIndex());
    }

    private void b_renamed(com.oplus.ocs.camera.CameraPreviewCallback.CameraPreviewResult cameraPreviewResult) {
        if (1 == this.h_renamed.g_renamed()) {
            this.h_renamed.b_renamed(0);
            this.mCameraInterface.n_renamed();
            if (this.mActivity != null) {
                this.mActivity.runOnUiThread(new java.lang.Runnable() { // from class: com.oplus.camera.p_renamed.-$$Lambda$a_renamed$y08pV8OfKtc7tprLBj-eUbj-R_U
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f_renamed$0.b_renamed();
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b_renamed() {
        if (this.h_renamed != null && !this.mbFrontCamera) {
            this.h_renamed.k_renamed();
        }
        if (isGoogleLensEnable()) {
            showGoogleLensIcon(true);
        }
    }
}

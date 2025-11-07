package com.oplus.camera.s_renamed;

/* compiled from: StarVideoMode.java */
/* loaded from: classes2.dex */
public class b_renamed extends com.oplus.camera.capmode.BaseMode implements com.oplus.camera.s_renamed.a_renamed.StarVideoHelper_2 {
    private android.os.HandlerThread g_renamed;
    private android.os.Handler h_renamed;
    private com.oplus.camera.s_renamed.c_renamed i_renamed;
    private com.oplus.camera.s_renamed.a_renamed j_renamed;
    private int k_renamed;
    private int l_renamed;
    private int m_renamed;
    private int n_renamed;
    private int o_renamed;
    private long p_renamed;
    private boolean q_renamed;
    private boolean r_renamed;
    private com.oplus.camera.e_renamed.c_renamed s_renamed;
    private com.oplus.camera.aps.util.CameraApsDecision t_renamed;
    private com.oplus.camera.e_renamed.d_renamed.a_renamed u_renamed;
    private android.animation.ValueAnimator v_renamed;
    private com.oplus.camera.s_renamed.b_renamed.a_renamed w_renamed;

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean consumeBackEventOnPictureTaken() {
        return true;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public java.lang.String getCameraMode() {
        return com.oplus.camera.aps.constant.ApsConstant.REC_MODE_STAR_VIDEO;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public int getDefaultCaptureNumber() {
        return 1;
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
    protected boolean isStarVideoOpen() {
        return true;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean isStarryMode() {
        return true;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void onAfterPictureTaken(byte[] bArr, boolean z_renamed) {
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onPictureCallback(byte[] bArr, int i_renamed, int i2, int i3, boolean z_renamed, int i4) {
    }

    public b_renamed(android.app.Activity activity, com.oplus.camera.capmode.a_renamed aVar, com.oplus.camera.ui.CameraUIInterface cameraUIInterface, com.oplus.camera.ui.preview.a_renamed.t_renamed tVar) {
        super(activity, aVar, cameraUIInterface, tVar);
        this.g_renamed = null;
        this.h_renamed = null;
        this.i_renamed = null;
        this.j_renamed = null;
        this.k_renamed = 0;
        this.l_renamed = 0;
        this.m_renamed = 0;
        this.n_renamed = 3;
        this.o_renamed = 0;
        this.p_renamed = 0L;
        this.q_renamed = false;
        this.r_renamed = true;
        this.s_renamed = null;
        this.t_renamed = null;
        this.u_renamed = null;
        this.v_renamed = null;
        this.w_renamed = null;
        this.j_renamed = new com.oplus.camera.s_renamed.a_renamed(this.mActivity.getApplicationContext(), this.mCameraInterface, this.mCameraUIInterface, this.mbDisplayOnLock);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void onInitCameraMode() {
        com.oplus.camera.e_renamed.c_renamed("StarVideoMode", "onInitCameraMode");
        this.i_renamed = new com.oplus.camera.s_renamed.c_renamed(this.mActivity, this.mPreferences, this.mCameraUIInterface);
        this.g_renamed = new android.os.HandlerThread("StarVideoHandler");
        this.g_renamed.start();
        this.h_renamed = new android.os.Handler(this.g_renamed.getLooper()) { // from class: com.oplus.camera.s_renamed.b_renamed.1
            @Override // android.os.Handler
            public void handleMessage(android.os.Message message) {
                int i_renamed = message.what;
                if (i_renamed == 1) {
                    com.oplus.camera.s_renamed.b_renamed.this.c_renamed();
                    return;
                }
                if (i_renamed == 2) {
                    com.oplus.camera.s_renamed.b_renamed bVar = com.oplus.camera.s_renamed.b_renamed.this;
                    bVar.a_renamed(bVar.mActivity);
                } else if (i_renamed == 3) {
                    com.oplus.camera.s_renamed.b_renamed.this.m_renamed();
                } else if (i_renamed == 4) {
                    com.oplus.camera.s_renamed.b_renamed.this.n_renamed();
                } else {
                    if (i_renamed != 5) {
                        return;
                    }
                    com.oplus.camera.s_renamed.b_renamed.this.l_renamed();
                }
            }
        };
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected boolean onStopTakePicture() {
        if (3 == this.n_renamed) {
            return false;
        }
        j_renamed();
        return true;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void onBeforePreview() {
        this.j_renamed.a_renamed(this.mCameraId);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onAfterStartPreview(boolean z_renamed) throws android.content.res.Resources.NotFoundException {
        this.mOneCamera.a_renamed(getCameraInfo(this.mCameraInterface.as_renamed()).m_renamed(), true);
        this.i_renamed.a_renamed();
        super.onAfterStartPreview(z_renamed);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void setLowBatteryState(boolean z_renamed) {
        if (this.mbPaused || !com.oplus.camera.Camera.l_renamed || f_renamed()) {
            return;
        }
        h_renamed();
        j_renamed();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void setOrientation(int i_renamed) {
        super.setOrientation(i_renamed);
        com.oplus.camera.s_renamed.c_renamed cVar = this.i_renamed;
        if (cVar != null) {
            cVar.a_renamed(i_renamed);
        }
    }

    private int a_renamed() {
        return super.getDefaultCaptureNumber();
    }

    private boolean b_renamed() {
        return this.l_renamed > a_renamed();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c_renamed() {
        com.oplus.camera.e_renamed.c_renamed("StarVideoMode", "handleBurstCaptureMessage, mNightScene: " + this.o_renamed);
        int i_renamed = this.o_renamed;
        if (i_renamed > 0) {
            a_renamed(i_renamed);
        }
        com.oplus.camera.e_renamed.c_renamed cVar = this.s_renamed;
        if (cVar != null) {
            burstCapture(this.k_renamed, cVar, this.u_renamed);
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void burstCapture(int i_renamed, com.oplus.camera.e_renamed.c_renamed cVar, com.oplus.camera.e_renamed.d_renamed.a_renamed aVar) {
        if (this.l_renamed == 0) {
            synchronized (this.mApsDecisionResultLock) {
                this.t_renamed = this.mDecisionResult;
            }
            this.m_renamed = 0;
        }
        this.q_renamed = e_renamed() <= 17000;
        cVar.af_renamed = this.q_renamed ? -1 : this.l_renamed + 1;
        cVar.ae_renamed = true;
        super.burstCapture(i_renamed, cVar, aVar);
        this.k_renamed = i_renamed;
        this.s_renamed = super.getCaptureRequestTag(this.t_renamed, false);
        this.u_renamed = aVar;
        this.mCaptureStartedCallbackNum = 0;
        com.oplus.camera.e_renamed.c_renamed("StarVideoMode", "burstCapture, mReceivedImageNum: " + this.l_renamed + ", mbLastCaptureRequest: " + this.q_renamed);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected boolean onBeforeSnapping(com.oplus.camera.e_renamed.c_renamed cVar) {
        this.o_renamed = getNightStateDecision();
        int i_renamed = this.o_renamed;
        if (i_renamed > 0) {
            a_renamed(i_renamed);
        }
        return i_renamed();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void updateCaptureParam(com.oplus.camera.e_renamed.c_renamed cVar) throws android.content.res.Resources.NotFoundException {
        super.updateCaptureParam(cVar);
        this.mOneCamera.e_renamed(true);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean onAfterSnapping() {
        this.mCameraInterface.c_renamed(4);
        return super.onAfterSnapping();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void onPause() {
        com.oplus.camera.e_renamed.a_renamed("StarVideoMode", "onPause");
        this.i_renamed.c_renamed(false);
        this.h_renamed.removeMessages(1);
        this.h_renamed.removeMessages(3);
        this.h_renamed.removeMessages(5);
        this.h_renamed.removeMessages(2);
        j_renamed();
        if (this.mCameraInterface != null) {
            this.mCameraInterface.U_renamed();
            this.mCameraUIInterface.a_renamed(com.oplus.camera.R_renamed.string.camera_scene_star_video_mode_fixed_tips);
        }
        this.u_renamed = null;
        this.t_renamed = null;
        this.s_renamed = null;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void onStop() {
        com.oplus.camera.e_renamed.a_renamed("StarVideoMode", "OnStop");
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean onBackPressed() {
        com.oplus.camera.e_renamed.c_renamed("StarVideoMode", "onBackPressed, mRecordingStatus: " + this.n_renamed);
        if (3 != this.n_renamed) {
            j_renamed();
            return true;
        }
        return super.onBackPressed();
    }

    private void d_renamed() {
        com.oplus.camera.s_renamed.a_renamed aVar = this.j_renamed;
        if (aVar != null) {
            aVar.a_renamed((com.oplus.camera.s_renamed.a_renamed.StarVideoHelper_2) null);
        }
        android.animation.ValueAnimator valueAnimator = this.v_renamed;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.v_renamed.removeAllUpdateListeners();
            this.v_renamed = null;
            this.w_renamed = null;
        }
        android.os.HandlerThread handlerThread = this.g_renamed;
        if (handlerThread != null) {
            handlerThread.quitSafely();
            this.g_renamed = null;
            this.h_renamed = null;
        }
        com.oplus.camera.s_renamed.c_renamed cVar = this.i_renamed;
        if (cVar != null) {
            cVar.c_renamed();
            this.i_renamed = null;
        }
        this.s_renamed = null;
        this.t_renamed = null;
        this.u_renamed = null;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void onDeInitCameraMode(java.lang.String str) {
        com.oplus.camera.e_renamed.a_renamed("StarVideoMode", "onDeInitCameraMode");
        if (this.mCameraUIInterface != null) {
            this.mCameraUIInterface.a_renamed(com.oplus.camera.R_renamed.string.camera_scene_star_video_mode_fixed_tips);
        }
        com.oplus.camera.s_renamed.c_renamed cVar = this.i_renamed;
        if (cVar != null) {
            cVar.c_renamed(false);
        }
        d_renamed();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void onDestroy() {
        com.oplus.camera.e_renamed.a_renamed("StarVideoMode", "onDestroy");
        d_renamed();
    }

    /* JADX WARN: Can't_renamed fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B_renamed:35:0x0071  */
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
                case -1957553773: goto L67;
                case -1826833948: goto L5c;
                case -1693318428: goto L52;
                case -1593450737: goto L48;
                case -681469213: goto L3e;
                case 276021746: goto L34;
                case 336270991: goto L29;
                case 1599576324: goto L1f;
                case 1706373443: goto L15;
                case 2118868211: goto Lb;
                default: goto L9;
            }
        L9:
            goto L71
        Lb:
            java.lang.String r0 = "pref_camera_tap_shutter_key"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L71
            r0 = 7
            goto L72
        L15:
            java.lang.String r0 = "pref_support_capture_preview"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L71
            r0 = 5
            goto L72
        L1f:
            java.lang.String r0 = "pref_support_switch_camera"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L71
            r0 = 2
            goto L72
        L29:
            java.lang.String r0 = "pref_zoom_key"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L71
            r0 = 9
            goto L72
        L34:
            java.lang.String r0 = "pref_camera_pi_ai_mode_key"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L71
            r0 = 4
            goto L72
        L3e:
            java.lang.String r0 = "key_support_update_thumbnail_user_picture"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L71
            r0 = 3
            goto L72
        L48:
            java.lang.String r0 = "pref_watermark_function_key"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L71
            r0 = r2
            goto L72
        L52:
            java.lang.String r0 = "pref_manual_exposure_key"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L71
            r0 = 6
            goto L72
        L5c:
            java.lang.String r0 = "pref_continuous_focus_key"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L71
            r0 = 8
            goto L72
        L67:
            java.lang.String r0 = "pref_support_raw_post_process"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L71
            r0 = r1
            goto L72
        L71:
            r0 = -1
        L72:
            switch(r0) {
                case 0: goto L82;
                case 1: goto L82;
                case 2: goto L82;
                case 3: goto L82;
                case 4: goto L81;
                case 5: goto L81;
                case 6: goto L81;
                case 7: goto L81;
                case 8: goto L81;
                case 9: goto L7a;
                default: goto L75;
            }
        L75:
            boolean r3 = super.getSupportFunction(r4)
            return r3
        L7a:
            java.lang.String r3 = "com.oplus.night.starry.zoom.support"
            boolean r3 = com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(r3)
            return r3
        L81:
            return r1
        L82:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.s_renamed.b_renamed.getSupportFunction(java.lang.String):boolean");
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean getSupportMenu(java.lang.String str) {
        if (com.oplus.camera.ui.CameraUIInterface.KEY_CAMERA_TIMER_SHUTTER.equals(str) || com.oplus.camera.ui.CameraUIInterface.KEY_SETTING.equals(str)) {
            return true;
        }
        return super.getSupportMenu(str);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public com.oplus.camera.af_renamed getZoomConfigure() {
        com.oplus.camera.af_renamed zoomConfigure = super.getZoomConfigure();
        zoomConfigure.p_renamed(true);
        zoomConfigure.y_renamed(true);
        return zoomConfigure;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public android.util.Size getPictureSize(com.oplus.camera.e_renamed.h_renamed hVar) {
        com.oplus.camera.s_renamed.a_renamed aVar = this.j_renamed;
        if (aVar != null) {
            return aVar.b_renamed();
        }
        return super.getPictureSize(hVar);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected boolean interruptCaptureFailedEvent() {
        com.oplus.camera.e_renamed.f_renamed("StarVideoMode", "interruptCaptureFailedEvent, mFailedCount: " + this.m_renamed);
        if (20 < this.m_renamed) {
            j_renamed();
            return false;
        }
        if (f_renamed()) {
            return false;
        }
        this.m_renamed++;
        g_renamed();
        return true;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean onImageReceived(com.oplus.ocs.camera.CameraPictureCallback.CameraPictureImage cameraPictureImage) {
        if (cameraPictureImage == null) {
            com.oplus.camera.e_renamed.f_renamed("StarVideoMode", "onImageReceived, image is_renamed null");
            return false;
        }
        this.l_renamed++;
        com.oplus.camera.e_renamed.c_renamed("StarVideoMode", "onImageReceived, mReceivedImageNum: " + this.l_renamed + ", mbShouldEncode: " + this.r_renamed);
        if (b_renamed() && this.r_renamed) {
            this.j_renamed.a_renamed(cameraPictureImage);
        }
        g_renamed();
        return true;
    }

    @Override // com.oplus.camera.capmode.BaseMode, com.oplus.camera.e_renamed.d_renamed.a_renamed
    public void onCaptureCompleted(com.oplus.camera.aps.service.CameraCaptureResult cameraCaptureResult, com.oplus.camera.e_renamed.c_renamed cVar) {
        com.oplus.camera.e_renamed.c_renamed("StarVideoMode", "onCaptureCompleted, requestTag.mFrameFlag: " + cVar.af_renamed);
        if (this.mOneCamera != null) {
            this.mOneCamera.f_renamed(cVar.af_renamed);
        }
        if (com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_STAR_VIDEO_NEED_VERIFY_FRAME)) {
            try {
                java.lang.Integer num = (java.lang.Integer) cameraCaptureResult.getCaptureResult().get(com.oplus.camera.e_renamed.b_renamed.bE_renamed);
                boolean z_renamed = true;
                if (num.intValue() != cVar.af_renamed - 1) {
                    z_renamed = false;
                }
                this.r_renamed = z_renamed;
                com.oplus.camera.e_renamed.a_renamed("StarVideoMode", "onCaptureCompleted, resultFrame: " + num + ", requestFrame: " + cVar.af_renamed);
            } catch (java.lang.Exception unused) {
                com.oplus.camera.e_renamed.f_renamed("StarVideoMode", "onCaptureCompleted, do not have CameraMetadataKey.KEY_STAR_MODE_FRAME_FLAG");
            }
        }
        super.onCaptureCompleted(cameraCaptureResult, cVar);
    }

    @Override // com.oplus.camera.capmode.BaseMode, com.oplus.camera.e_renamed.d_renamed.a_renamed
    public void onCaptureFailed(android.hardware.camera2.CaptureRequest captureRequest, com.oplus.camera.e_renamed.c_renamed cVar) {
        com.oplus.camera.e_renamed.f_renamed("StarVideoMode", "onCaptureFailed, mFailedCount: " + this.m_renamed);
        if (20 < this.m_renamed) {
            j_renamed();
            super.onCaptureFailed(captureRequest, cVar);
        } else {
            if (f_renamed()) {
                return;
            }
            this.m_renamed++;
            g_renamed();
        }
    }

    private void a_renamed(int i_renamed) {
        if (this.mOneCamera == null) {
            return;
        }
        com.oplus.camera.e_renamed.c_renamed("StarVideoMode", "setNightMode, nightMode: " + i_renamed);
        this.mOneCamera.o_renamed(i_renamed);
        this.mOneCamera.a_renamed((com.oplus.camera.e_renamed.d_renamed.c_renamed) null);
    }

    private long e_renamed() {
        return this.mPreferences.getInt(com.oplus.camera.ui.CameraUIInterface.KEY_STAR_VIDEO_RECORD_TOTAL_TIME, 5400000) - (android.os.SystemClock.uptimeMillis() - this.p_renamed);
    }

    private boolean f_renamed() {
        int i_renamed = this.n_renamed;
        return 4 == i_renamed || 3 == i_renamed;
    }

    private void g_renamed() {
        android.os.Handler handler;
        com.oplus.camera.e_renamed.c_renamed("StarVideoMode", "trySendRepeatBurstCaptureMessage, mbLastCaptureRequest: " + this.q_renamed);
        if (!this.mbPaused && !f_renamed() && !this.q_renamed && (handler = this.h_renamed) != null) {
            handler.sendEmptyMessage(1);
        } else {
            j_renamed();
        }
    }

    private void h_renamed() {
        com.oplus.camera.e_renamed.c_renamed("StarVideoMode", "showLowBatteryHint");
        if (this.mbPaused || this.mActivity == null) {
            return;
        }
        this.mActivity.runOnUiThread(new java.lang.Runnable() { // from class: com.oplus.camera.s_renamed.-$$Lambda$b_renamed$Xh3agHb2Sjf4kafQpkcof-fEllA
            @Override // java.lang.Runnable
            public final void run() {
                this.f_renamed$0.u_renamed();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void u_renamed() {
        if (this.mCameraUIInterface != null) {
            this.mCameraUIInterface.a_renamed(com.oplus.camera.R_renamed.string.camera_star_video_low_battery_rec_disabled, -1, true, false, false);
        }
    }

    private boolean i_renamed() {
        com.oplus.camera.e_renamed.c_renamed("StarVideoMode", "startRecording, mRecordingStatus: " + this.n_renamed);
        if (com.oplus.camera.Camera.l_renamed) {
            h_renamed();
            return false;
        }
        if (3 != this.n_renamed) {
            return false;
        }
        this.n_renamed = 2;
        this.q_renamed = false;
        this.p_renamed = android.os.SystemClock.uptimeMillis();
        this.mCameraInterface.a_renamed((android.animation.AnimatorListenerAdapter) null, true, false);
        this.h_renamed.removeMessages(3);
        this.h_renamed.sendEmptyMessage(3);
        if (this.mActivity != null) {
            this.mActivity.runOnUiThread(new java.lang.Runnable() { // from class: com.oplus.camera.s_renamed.-$$Lambda$b_renamed$w2qMR0wF2lRpy_tOeZzvdkKELCs
                @Override // java.lang.Runnable
                public final void run() {
                    this.f_renamed$0.t_renamed();
                }
            });
        }
        this.mOneCamera.a_renamed((android.hardware.camera2.CaptureRequest.Key<android.hardware.camera2.CaptureRequest.Key>) android.hardware.camera2.CaptureRequest.CONTROL_AWB_LOCK, (android.hardware.camera2.CaptureRequest.Key) true);
        this.mOneCamera.a_renamed((com.oplus.camera.e_renamed.d_renamed.c_renamed) null);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void t_renamed() {
        this.mCameraInterface.aI_renamed();
    }

    private void j_renamed() {
        com.oplus.camera.e_renamed.c_renamed("StarVideoMode", "stopRecording, mRecordingStatus: " + this.n_renamed);
        android.os.Handler handler = this.h_renamed;
        if (handler != null) {
            handler.removeMessages(1);
        }
        this.mOneCamera.h_renamed();
        if (f_renamed()) {
            return;
        }
        a_renamed(0);
        this.mOneCamera.a_renamed((android.hardware.camera2.CaptureRequest.Key<android.hardware.camera2.CaptureRequest.Key>) android.hardware.camera2.CaptureRequest.CONTROL_AWB_LOCK, (android.hardware.camera2.CaptureRequest.Key) false);
        this.mCameraInterface.W_renamed();
        this.n_renamed = 4;
        this.m_renamed = 0;
        android.os.Handler handler2 = this.h_renamed;
        if (handler2 != null) {
            handler2.sendEmptyMessage(4);
        }
    }

    private int k_renamed() {
        com.oplus.camera.s_renamed.a_renamed aVar = this.j_renamed;
        if (aVar != null) {
            return aVar.d_renamed();
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l_renamed() {
        if (this.mActivity != null) {
            this.mActivity.runOnUiThread(new java.lang.Runnable() { // from class: com.oplus.camera.s_renamed.-$$Lambda$b_renamed$SNHXqi_txSIfZTijn-dGCXqn_FM
                @Override // java.lang.Runnable
                public final void run() {
                    this.f_renamed$0.s_renamed();
                }
            });
        }
        android.os.Handler handler = this.h_renamed;
        if (handler != null) {
            handler.sendEmptyMessageDelayed(5, 1000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void s_renamed() {
        if (this.i_renamed != null) {
            if (e_renamed() < 0) {
                this.i_renamed.a_renamed(true);
            } else {
                this.i_renamed.a_renamed(k_renamed(), android.os.SystemClock.uptimeMillis() - this.p_renamed);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m_renamed() {
        com.oplus.camera.e_renamed.c_renamed("StarVideoMode", "onStartRecordingMsg, E_renamed");
        if (!this.mbPaused) {
            this.j_renamed.a_renamed(this);
            this.j_renamed.a_renamed();
            this.i_renamed.b_renamed();
            this.h_renamed.removeMessages(5);
            this.h_renamed.sendEmptyMessageDelayed(5, 1000L);
            this.h_renamed.removeMessages(2);
            this.h_renamed.sendEmptyMessageDelayed(2, 300000L);
            this.n_renamed = 1;
        }
        com.oplus.camera.e_renamed.c_renamed("StarVideoMode", "onStartRecordingMsg, X_renamed");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n_renamed() {
        boolean z_renamed;
        com.oplus.camera.e_renamed.c_renamed("StarVideoMode", "onStopRecordingMsg, E_renamed, mbPaused: " + this.mbPaused);
        android.os.Handler handler = this.h_renamed;
        if (handler != null) {
            handler.removeMessages(5);
            this.h_renamed.removeMessages(2);
        }
        com.oplus.camera.s_renamed.a_renamed aVar = this.j_renamed;
        if (aVar != null) {
            aVar.a_renamed((com.oplus.camera.s_renamed.a_renamed.StarVideoHelper_2) null);
            z_renamed = k_renamed() >= 1;
            this.j_renamed.a_renamed(z_renamed);
        } else {
            z_renamed = false;
        }
        if (this.v_renamed != null) {
            this.mActivity.runOnUiThread(new java.lang.Runnable() { // from class: com.oplus.camera.s_renamed.-$$Lambda$b_renamed$tipzS2N5gYMnDZaKP9KuzGXeOXM
                @Override // java.lang.Runnable
                public final void run() {
                    this.f_renamed$0.r_renamed();
                }
            });
        }
        if (!this.mbPaused) {
            this.mActivity.runOnUiThread(new java.lang.Runnable() { // from class: com.oplus.camera.s_renamed.-$$Lambda$b_renamed$cT_renamed-GDOLTyx2QYL1oE3VQ4oYivYc
                @Override // java.lang.Runnable
                public final void run() {
                    this.f_renamed$0.q_renamed();
                }
            });
            com.oplus.camera.s_renamed.c_renamed cVar = this.i_renamed;
            if (cVar != null) {
                cVar.a_renamed(true, getShutterButtonInfo(), z_renamed, isPanelMode());
            }
            pictureTakenCallback(null, 0, 0, null, false, false, 0L, 0);
        }
        if (this.mCameraInterface != null) {
            this.mCameraInterface.c_renamed(5);
        }
        this.n_renamed = 3;
        this.l_renamed = 0;
        com.oplus.camera.e_renamed.c_renamed("StarVideoMode", "onStopRecordingMsg, X_renamed");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void r_renamed() {
        this.v_renamed.cancel();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void q_renamed() {
        if (this.mCameraInterface != null) {
            this.mCameraInterface.aJ_renamed();
            this.mCameraInterface.U_renamed();
        }
    }

    private void o_renamed() {
        if (this.v_renamed == null) {
            this.w_renamed = new com.oplus.camera.s_renamed.b_renamed.a_renamed(this.mActivity, this.mCameraInterface.V_renamed());
            this.v_renamed = android.animation.ValueAnimator.ofFloat(1.0f, 0.0f);
            this.v_renamed.setDuration(10000L);
            this.v_renamed.addUpdateListener(this.w_renamed);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a_renamed(android.app.Activity activity) {
        if (activity != null) {
            o_renamed();
            android.view.WindowManager.LayoutParams attributes = activity.getWindow().getAttributes();
            float f_renamed = android.provider.Settings.System.getInt(activity.getContentResolver(), com.oplus.camera.statistics.CameraStatisticsUtil.SCREEN_BRIGHTNESS, 20);
            float f2 = 20;
            if (f_renamed > f2) {
                this.w_renamed.a_renamed(f_renamed, f_renamed - f2, f2);
                activity.runOnUiThread(new java.lang.Runnable() { // from class: com.oplus.camera.s_renamed.-$$Lambda$b_renamed$nvMrzFli23kqCKZu5cLj4ndSgOI
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f_renamed$0.p_renamed();
                    }
                });
            }
            com.oplus.camera.e_renamed.a_renamed("StarVideoMode", "setScreenBrightness, brightness: 20, currBrightness: " + f_renamed + ", winParams.screenBrightness: " + attributes.screenBrightness);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void p_renamed() {
        this.v_renamed.start();
    }

    @Override // com.oplus.camera.capmode.x_renamed.h_renamed
    public void onInfo(java.lang.Object obj, int i_renamed, int i2) {
        com.oplus.camera.e_renamed.a_renamed("StarVideoMode", "onInfo");
        if (i_renamed == 800) {
            if (isVideoRecordStarted()) {
                j_renamed();
            }
        } else if ((i_renamed == 801 || i_renamed == 802) && isVideoRecordStarted()) {
            j_renamed();
        }
    }

    @Override // com.oplus.camera.capmode.x_renamed.f_renamed
    public void onError(java.lang.Object obj, int i_renamed, int i2) {
        com.oplus.camera.e_renamed.a_renamed("StarVideoMode", "onError, what: " + i_renamed + ", extra: " + i2);
        if ((i_renamed == 1100 || i_renamed == 1101) && !isVideoRecordStopped()) {
            j_renamed();
        }
    }

    @Override // com.oplus.camera.capmode.x_renamed.g_renamed
    public void onException(int i_renamed) {
        com.oplus.camera.e_renamed.a_renamed("StarVideoMode", "onException, exceptionCode: " + i_renamed);
        if (1 != i_renamed || isVideoRecordStopped()) {
            return;
        }
        j_renamed();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean needSurface(java.lang.String str) {
        if ("type_capture".equals(str)) {
            return true;
        }
        return super.needSurface(str);
    }

    /* compiled from: StarVideoMode.java */
    private class a_renamed implements android.animation.ValueAnimator.AnimatorUpdateListener {

        /* renamed from: b_renamed, reason: collision with root package name */
        private float f5324b;

        /* renamed from: c_renamed, reason: collision with root package name */
        private float f5325c;
        private float d_renamed;
        private android.view.Window e_renamed;
        private android.view.WindowManager.LayoutParams f_renamed;
        private int g_renamed;

        public a_renamed(android.app.Activity activity, int i_renamed) {
            this.e_renamed = activity.getWindow();
            this.f_renamed = this.e_renamed.getAttributes();
            this.g_renamed = i_renamed;
        }

        public void a_renamed(float f_renamed, float f2, float f3) {
            com.oplus.camera.e_renamed.a_renamed("StarVideoMode", "setTargetBrightness, targetBrightness: " + f3 + ", deltaBrightness: " + f2);
            this.f5324b = f3;
            this.f5325c = f2;
            this.d_renamed = f_renamed;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
            float fFloatValue = (this.f5325c * ((java.lang.Float) valueAnimator.getAnimatedValue()).floatValue()) + this.f5324b;
            float f_renamed = this.f5325c;
            if (this.d_renamed - fFloatValue >= (20.0f <= f_renamed ? f_renamed / 20.0f : 1.0f)) {
                android.view.WindowManager.LayoutParams layoutParams = this.f_renamed;
                layoutParams.screenBrightness = fFloatValue / this.g_renamed;
                this.e_renamed.setAttributes(layoutParams);
                this.d_renamed = fFloatValue;
            }
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean isNeedShowMenuOnTimeSnapShotEnd() {
        return com.oplus.camera.Camera.l_renamed;
    }
}

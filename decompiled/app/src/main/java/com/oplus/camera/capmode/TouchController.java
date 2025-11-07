package com.oplus.camera.capmode;

/* compiled from: IdPhotoMode.java */
/* loaded from: classes2.dex */
public class l_renamed extends com.oplus.camera.capmode.d_renamed {
    private int g_renamed;
    private int h_renamed;
    private long i_renamed;
    private long j_renamed;
    private boolean k_renamed;
    private int l_renamed;
    private android.os.Handler m_renamed;
    private boolean n_renamed;

    @Override // com.oplus.camera.capmode.d_renamed, com.oplus.camera.capmode.BaseMode
    public java.lang.String getCameraFeature() {
        return com.oplus.camera.aps.constant.ApsConstant.CAPTURE_MODE_ID_PHOTO;
    }

    @Override // com.oplus.camera.capmode.d_renamed, com.oplus.camera.capmode.BaseMode
    public java.lang.String getCameraMode() {
        return com.oplus.camera.aps.constant.ApsConstant.CAPTURE_MODE_ID_PHOTO;
    }

    @Override // com.oplus.camera.capmode.d_renamed, com.oplus.camera.capmode.BaseMode
    protected java.lang.String getFaceBeautyKey() {
        return com.oplus.camera.ui.CameraUIInterface.KEY_IDPHOTO_FACEBEAUTY_LEVEL_MENU;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public java.lang.String getHeicCodecFormat() {
        return null;
    }

    @Override // com.oplus.camera.capmode.d_renamed, com.oplus.camera.capmode.BaseMode
    public int getOperatingMode() {
        return com.arcsoft.camera.wideselfie.ArcWideSelfieDef.ResultCode.AWS_MWARN_MOVE_SLOPE_TO_DOWN;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean getRearEnable() {
        return true;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean getSupportFaceView() {
        return false;
    }

    @Override // com.oplus.camera.capmode.d_renamed, com.oplus.camera.capmode.BaseMode
    public boolean getSupportSubMenu(java.lang.String str) {
        return false;
    }

    @Override // com.oplus.camera.capmode.d_renamed, com.oplus.camera.capmode.BaseMode
    public boolean getZSLMode() {
        return false;
    }

    @Override // com.oplus.camera.capmode.d_renamed, com.oplus.camera.capmode.BaseMode
    public boolean isFirstTipsEnable(java.lang.String str) {
        return false;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean isNeedAPSProcess() {
        return true;
    }

    @Override // com.oplus.camera.capmode.d_renamed
    protected boolean isNightAlgoCaptureTriggered() {
        return false;
    }

    @Override // com.oplus.camera.capmode.d_renamed, com.oplus.camera.capmode.BaseMode
    protected boolean isSalientObjectDetectionEnabled() {
        return false;
    }

    @Override // com.oplus.camera.capmode.d_renamed, com.oplus.camera.capmode.BaseMode
    public boolean isSatOpen() {
        return false;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean isSubMenuEnable() {
        return false;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void updateDimHintView(boolean z_renamed) {
    }

    public l_renamed(android.app.Activity activity, com.oplus.camera.capmode.a_renamed aVar, com.oplus.camera.ui.CameraUIInterface cameraUIInterface, com.oplus.camera.ui.preview.a_renamed.t_renamed tVar) {
        super(activity, aVar, cameraUIInterface, tVar);
        this.g_renamed = 0;
        this.h_renamed = 0;
        this.i_renamed = 0L;
        this.j_renamed = 0L;
        this.k_renamed = false;
        this.l_renamed = 0;
        this.m_renamed = null;
        this.n_renamed = false;
    }

    @Override // com.oplus.camera.capmode.d_renamed, com.oplus.camera.capmode.BaseMode
    protected void onInitCameraMode() {
        super.onInitCameraMode();
        this.mCameraUIInterface.b_renamed(com.oplus.camera.R_renamed.string.camera_mode_more);
        this.k_renamed = this.mPreferences.getBoolean(com.oplus.camera.ui.CameraUIInterface.KEY_BOTTOM_GUIDE_ID_PHOTO_FIRST_TIPS_SHOWED, false);
        if (this.m_renamed == null) {
            this.m_renamed = new android.os.Handler() { // from class: com.oplus.camera.capmode.l_renamed.1
                @Override // android.os.Handler
                public void handleMessage(android.os.Message message) {
                    super.handleMessage(message);
                    int i_renamed = message.what;
                    if (i_renamed != 1) {
                        if (i_renamed != 2) {
                            if (i_renamed != 3) {
                                return;
                            }
                            com.oplus.camera.capmode.l_renamed.this.n_renamed = true;
                            return;
                        } else {
                            if (com.oplus.camera.capmode.l_renamed.this.mCameraUIInterface != null && com.oplus.camera.capmode.l_renamed.this.h_renamed != 0) {
                                com.oplus.camera.capmode.l_renamed.this.mCameraUIInterface.a_renamed(com.oplus.camera.capmode.l_renamed.this.h_renamed);
                            }
                            com.oplus.camera.capmode.l_renamed.this.h_renamed = 0;
                            return;
                        }
                    }
                    if (com.oplus.camera.capmode.l_renamed.this.mCameraUIInterface != null && com.oplus.camera.capmode.l_renamed.this.h_renamed != 0 && com.oplus.camera.R_renamed.string.camera_id_photo_mode_no_faces_retake != com.oplus.camera.capmode.l_renamed.this.h_renamed) {
                        com.oplus.camera.capmode.l_renamed.this.mCameraUIInterface.a_renamed(com.oplus.camera.capmode.l_renamed.this.h_renamed);
                    }
                    boolean zBooleanValue = ((java.lang.Boolean) message.obj).booleanValue();
                    int i2 = message.arg1;
                    com.oplus.camera.capmode.l_renamed.this.a_renamed(i2, zBooleanValue, message.arg2);
                    if (zBooleanValue) {
                        return;
                    }
                    com.oplus.camera.capmode.l_renamed.this.a_renamed(i2);
                }
            };
        }
    }

    @Override // com.oplus.camera.capmode.d_renamed, com.oplus.camera.capmode.BaseMode
    protected java.lang.String[] getCustomBeautyKeys() {
        return com.oplus.camera.ui.CameraUIInterface.KEY_IDPHOTO_CUSTOM_BEAUTY;
    }

    @Override // com.oplus.camera.capmode.d_renamed, com.oplus.camera.capmode.BaseMode
    public boolean getSupportMenu(java.lang.String str) {
        if (com.oplus.camera.ui.CameraUIInterface.KEY_FLASH_MODE.equals(str)) {
            return getSupportFunction(str);
        }
        if (com.oplus.camera.ui.CameraUIInterface.KEY_SETTING.equals(str)) {
            return true;
        }
        if (com.oplus.camera.ui.CameraUIInterface.KEY_SUB_SETTING.equals(str)) {
            return getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_SUB_SETTING);
        }
        if (com.oplus.camera.ui.CameraUIInterface.KEY_CAMERA_TIMER_SHUTTER.equals(str) || com.oplus.camera.ui.CameraUIInterface.KEY_MACRO_SWITCH.equals(str)) {
            return false;
        }
        return super.getSupportMenu(str);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean isIdPhotoOpen() {
        return getSupportFunction(com.oplus.camera.aps.config.CameraFunction.ID_PHOTO);
    }

    @Override // com.oplus.camera.capmode.d_renamed, com.oplus.camera.capmode.BaseMode
    public com.oplus.camera.ui.control.b_renamed getShutterButtonInfo() {
        com.oplus.camera.ui.control.b_renamed shutterButtonInfo = super.getShutterButtonInfo();
        shutterButtonInfo.c_renamed("button_shape_ring_none");
        return shutterButtonInfo;
    }

    @Override // com.oplus.camera.capmode.d_renamed, com.oplus.camera.capmode.BaseMode
    public android.util.Size getPictureSize(com.oplus.camera.e_renamed.h_renamed hVar) {
        return com.oplus.camera.util.Util.b_renamed(hVar.a_renamed(256), 1.3333333333333333d);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public android.util.Size getPreviewSize(com.oplus.camera.e_renamed.h_renamed hVar, double d_renamed) {
        return super.getPreviewSize(hVar, 1.3333333333333333d);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public android.util.Size getPreviewSize(com.oplus.camera.e_renamed.h_renamed hVar, java.lang.String str) {
        return super.getPreviewSize(hVar, 1.3333333333333333d);
    }

    @Override // com.oplus.camera.capmode.d_renamed, com.oplus.camera.capmode.BaseMode
    public android.util.Size getPreviewSize(com.oplus.camera.e_renamed.h_renamed hVar) {
        return super.getPreviewSize(hVar, 1.3333333333333333d);
    }

    /* JADX WARN: Can't_renamed fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B_renamed:95:0x0162  */
    @Override // com.oplus.camera.capmode.d_renamed, com.oplus.camera.capmode.BaseMode
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean getSupportFunction(java.lang.String r4) {
        /*
            Method dump skipped, instructions count: 562
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.capmode.l_renamed.getSupportFunction(java.lang.String):boolean");
    }

    @Override // com.oplus.camera.capmode.d_renamed, com.oplus.camera.capmode.BaseMode
    public void onSharedPreferenceChanged(android.content.SharedPreferences sharedPreferences, java.lang.String str) {
        super.onSharedPreferenceChanged(sharedPreferences, str);
        if (com.oplus.camera.ui.CameraUIInterface.KEY_BOTTOM_GUIDE_ID_PHOTO_FIRST_TIPS_SHOWED.equals(str)) {
            this.k_renamed = sharedPreferences.getBoolean(com.oplus.camera.ui.CameraUIInterface.KEY_BOTTOM_GUIDE_ID_PHOTO_FIRST_TIPS_SHOWED, false);
            if (this.k_renamed) {
                this.mCameraUIInterface.j_renamed(true);
            }
        }
    }

    @Override // com.oplus.camera.capmode.d_renamed, com.oplus.camera.capmode.BaseMode
    protected void onPause() {
        super.onPause();
        this.mCameraUIInterface.j_renamed(false);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void beforeSwitchCamera() {
        super.beforeSwitchCamera();
        this.n_renamed = false;
        if (this.h_renamed != 0) {
            b_renamed();
            this.m_renamed.removeMessages(1);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B_renamed:19:0x0037  */
    @Override // com.oplus.camera.capmode.d_renamed, com.oplus.camera.capmode.BaseMode
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onPreviewCaptureResult(com.oplus.ocs.camera.CameraPreviewCallback.CameraPreviewResult r5) {
        /*
            r4 = this;
            super.onPreviewCaptureResult(r5)
            boolean r0 = r4.mbPaused
            if (r0 != 0) goto Ld1
            com.oplus.camera.capmode.a_renamed r0 = r4.mCameraInterface
            if (r0 == 0) goto Ld1
            boolean r0 = r4.k_renamed
            if (r0 == 0) goto Ld1
            boolean r0 = r4.n_renamed
            if (r0 == 0) goto Ld1
            android.hardware.camera2.CaptureResult r0 = r5.getCaptureResult()
            android.hardware.camera2.CaptureResult$Key<int[]> r1 = com.oplus.camera.e_renamed.b_renamed.Y_renamed
            java.lang.Object r0 = com.oplus.camera.e_renamed.b_renamed.a_renamed(r0, r1)
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L37
            boolean r3 = r0 instanceof int[]
            if (r3 == 0) goto L37
            int[] r0 = (int[]) r0
            r0 = r0[r2]
            r4.mFlashTrigger = r0
            int r0 = r4.mFlashTrigger
            if (r1 != r0) goto L37
            boolean r0 = r4.mbAutoFlash
            if (r0 != 0) goto L37
            r0 = 2131755516(0x7f1001fc, float:1.9141913E38)
            goto L38
        L37:
            r0 = r2
        L38:
            android.hardware.camera2.CaptureResult r5 = r5.getCaptureResult()
            android.hardware.camera2.CaptureResult$Key r3 = android.hardware.camera2.CaptureResult.STATISTICS_FACES
            java.lang.Object r5 = r5.get(r3)
            android.hardware.camera2.params.Face[] r5 = (android.hardware.camera2.params.Face[]) r5
            if (r5 == 0) goto L48
            int r5 = r5.length
            goto L49
        L48:
            r5 = r2
        L49:
            r4.l_renamed = r5
            if (r0 != 0) goto L5a
            int r5 = r4.l_renamed
            if (r5 != 0) goto L55
            r0 = 2131755517(0x7f1001fd, float:1.9141916E38)
            goto L5a
        L55:
            if (r5 <= r1) goto L5a
            r0 = 2131755514(0x7f1001fa, float:1.914191E38)
        L5a:
            com.oplus.camera.ui.CameraUIInterface r5 = r4.mCameraUIInterface
            java.lang.String r5 = r5.l_renamed()
            com.oplus.camera.ui.CameraUIInterface r3 = r4.mCameraUIInterface
            int r3 = r3.m_renamed()
            if (r3 == 0) goto L86
            if (r0 != 0) goto L78
            android.os.Handler r5 = r4.m_renamed
            boolean r5 = r5.hasMessages(r1)
            if (r5 == 0) goto Ld1
            android.os.Handler r4 = r4.m_renamed
            r4.removeMessages(r1)
            goto Ld1
        L78:
            android.os.Handler r5 = r4.m_renamed
            boolean r5 = r5.hasMessages(r1)
            if (r5 != 0) goto Ld1
            r5 = 1000(0x3e8, float:1.401E-42)
            r4.a_renamed(r0, r2, r5, r2)
            goto Ld1
        L86:
            boolean r3 = android.text.TextUtils.isEmpty(r5)
            if (r3 == 0) goto La5
            if (r0 != 0) goto L9f
            r4.b_renamed()
            android.os.Handler r5 = r4.m_renamed
            boolean r5 = r5.hasMessages(r1)
            if (r5 == 0) goto Ld1
            android.os.Handler r4 = r4.m_renamed
            r4.removeMessages(r1)
            goto Ld1
        L9f:
            r4.h_renamed = r2
            r4.a_renamed(r0, r2, r2, r2)
            goto Ld1
        La5:
            boolean r5 = android.text.TextUtils.isEmpty(r5)
            if (r5 != 0) goto Ld1
            if (r0 != 0) goto Lc2
            int r5 = r4.h_renamed
            if (r5 == 0) goto Lc2
            r4.b_renamed()
            android.os.Handler r5 = r4.m_renamed
            boolean r5 = r5.hasMessages(r1)
            if (r5 == 0) goto Ld1
            android.os.Handler r4 = r4.m_renamed
            r4.removeMessages(r1)
            goto Ld1
        Lc2:
            int r5 = r4.h_renamed
            if (r5 == r0) goto Ld1
            android.os.Handler r5 = r4.m_renamed
            boolean r5 = r5.hasMessages(r1)
            if (r5 != 0) goto Ld1
            r4.a_renamed(r0, r2, r2, r2)
        Ld1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.capmode.l_renamed.onPreviewCaptureResult(com.oplus.ocs.camera.CameraPreviewCallback$CameraPreviewResult):void");
    }

    private void a_renamed(int i_renamed, boolean z_renamed, int i2, int i3) {
        android.os.Message messageObtainMessage = this.m_renamed.obtainMessage();
        messageObtainMessage.what = 1;
        messageObtainMessage.arg1 = i_renamed;
        messageObtainMessage.arg2 = i3;
        messageObtainMessage.obj = java.lang.Boolean.valueOf(z_renamed);
        this.m_renamed.sendMessageDelayed(messageObtainMessage, i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a_renamed(int i_renamed) {
        java.lang.String str;
        switch (i_renamed) {
            case com.oplus.camera.R_renamed.string.camera_id_photo_mode_more_faces /* 2131755514 */:
                str = "more_face";
                break;
            case com.oplus.camera.R_renamed.string.camera_id_photo_mode_more_faces_retake /* 2131755515 */:
            default:
                return;
            case com.oplus.camera.R_renamed.string.camera_id_photo_mode_need_more_light /* 2131755516 */:
                str = com.oplus.camera.statistics.model.ReminderMsgData.CODE_FLASH_ON;
                break;
            case com.oplus.camera.R_renamed.string.camera_id_photo_mode_no_faces /* 2131755517 */:
                str = "no_face";
                break;
        }
        com.oplus.camera.statistics.model.ReminderMsgData reminderMsgData = new com.oplus.camera.statistics.model.ReminderMsgData(this.mActivity, true);
        if (this.mCameraInterface != null) {
            reminderMsgData.mCameraId = this.mCameraInterface.aw_renamed();
        }
        reminderMsgData.mReminderCodeValue = str;
        reminderMsgData.mCaptureMode = getCameraMode();
        reminderMsgData.mOrientation = this.mOrientation;
        reminderMsgData.mReminderTypeValue = com.oplus.camera.statistics.model.ReminderMsgData.TYPE_ADVICE;
        reminderMsgData.mRearOrFront = this.mbFrontCamera ? com.oplus.camera.statistics.model.DcsMsgData.FRONT : com.oplus.camera.statistics.model.DcsMsgData.REAR;
        reminderMsgData.report();
    }

    private boolean a_renamed() {
        int i_renamed = this.g_renamed;
        if (i_renamed == 0) {
            a_renamed(com.oplus.camera.R_renamed.string.camera_id_photo_mode_no_faces_retake, true, 1000, 2000);
            return false;
        }
        if (i_renamed <= 1) {
            return true;
        }
        a_renamed(com.oplus.camera.R_renamed.string.camera_id_photo_mode_more_faces_retake, true, 1000, 2000);
        return false;
    }

    @Override // com.oplus.camera.capmode.d_renamed, com.oplus.camera.capmode.BaseMode
    public void updateInversePositionRatio(boolean z_renamed) {
        com.oplus.camera.ui.inverse.e_renamed.INS.setPositionRatio(this.mActivity, 0.5f, z_renamed);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a_renamed(int i_renamed, boolean z_renamed, int i2) {
        if (this.mCameraUIInterface == null || this.j_renamed >= java.lang.System.currentTimeMillis()) {
            return;
        }
        this.i_renamed = java.lang.System.currentTimeMillis();
        this.j_renamed = this.i_renamed + i2;
        this.h_renamed = i_renamed;
        this.mCameraUIInterface.a_renamed(i_renamed, 0, z_renamed, true, false, false, true);
    }

    private void b_renamed() {
        android.os.Message messageObtainMessage = this.m_renamed.obtainMessage();
        messageObtainMessage.what = 2;
        long jCurrentTimeMillis = 1000 - (java.lang.System.currentTimeMillis() - this.i_renamed);
        this.m_renamed.sendMessageDelayed(messageObtainMessage, jCurrentTimeMillis > 0 ? jCurrentTimeMillis : 0L);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v5, types: [java.lang.String] */
    @Override // com.oplus.camera.capmode.d_renamed, com.oplus.camera.capmode.BaseMode
    protected void onAfterPictureTaken(byte[] bArr, boolean z_renamed) {
        android.net.Uri uriAo;
        super.onAfterPictureTaken(bArr, z_renamed);
        resetAfterPictureTaken(false, z_renamed);
        if (this.mbPaused || !a_renamed() || (uriAo = this.mCameraUIInterface.ao_renamed()) == null) {
            return;
        }
        android.content.Intent intent = new android.content.Intent("oplus.intent.action.galleryfeature");
        intent.putExtra("feature", "aiidphoto");
        intent.putExtra("from", this.mActivity.getPackageName());
        intent.putExtra("aiidphotouri", uriAo);
        try {
            try {
                this.mActivity.startActivity(intent);
                this.mActivity.overridePendingTransition(1 == this.mActivity.getResources().getConfiguration().getLayoutDirection() ? com.oplus.camera.R_renamed.anim.gallery_in_rtl : com.oplus.camera.R_renamed.anim.gallery_in, 0);
            } catch (java.lang.Throwable th) {
                com.oplus.camera.e_renamed.d_renamed("IdPhotoMode", "onAfterPictureTaken, start gallery error!", th);
                if (this.mbDisplayOnLock) {
                }
            }
            if (this.mbDisplayOnLock) {
                this.mActivity.finish();
            }
            this = "onAfterPictureTaken, uri: " + uriAo;
            com.oplus.camera.e_renamed.e_renamed("IdPhotoMode", this);
        } catch (java.lang.Throwable th2) {
            if (this.mbDisplayOnLock) {
                this.mActivity.finish();
            }
            throw th2;
        }
    }

    @Override // com.oplus.camera.capmode.d_renamed, com.oplus.camera.capmode.BaseMode
    public boolean onAfterSnapping() {
        this.g_renamed = this.l_renamed;
        return super.onAfterSnapping();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected java.lang.String getExifCameraMode() {
        return this.g_renamed != 1 ? com.oplus.camera.aps.constant.ApsConstant.CAPTURE_MODE_COMMON : com.oplus.camera.aps.constant.ApsConstant.CAPTURE_MODE_ID_PHOTO;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean getCanAddMenuOption(java.lang.String str) {
        if (com.oplus.camera.ui.CameraUIInterface.KEY_CAMERA_TIMER_SHUTTER.equals(str) || com.oplus.camera.ui.CameraUIInterface.KEY_PHOTO_RATIO.equals(str)) {
            return false;
        }
        return super.getCanAddMenuOption(str);
    }

    @Override // com.oplus.camera.capmode.d_renamed, com.oplus.camera.capmode.BaseMode
    public void onAfterStartPreview(boolean z_renamed) {
        if (this.mbPaused || this.mCameraUIInterface == null) {
            return;
        }
        super.onAfterStartPreview(z_renamed);
        if (!this.mCameraUIInterface.R_renamed() && this.k_renamed) {
            this.mCameraUIInterface.j_renamed(true);
        }
        this.mActivity.runOnUiThread(new java.lang.Runnable() { // from class: com.oplus.camera.capmode.-$$Lambda$l_renamed$7r-zgZmBNCoqD1744u2G_LH-TuI
            @Override // java.lang.Runnable
            public final void run() {
                this.f_renamed$0.c_renamed();
            }
        });
        android.os.Handler handler = this.m_renamed;
        if (handler != null) {
            handler.sendEmptyMessageDelayed(3, 500L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c_renamed() {
        if (this.mbPaused || this.mPreferences == null || this.mPreferences.getBoolean(com.oplus.camera.ui.CameraUIInterface.KEY_BOTTOM_GUIDE_ID_PHOTO_FIRST_TIPS_SHOWED, false) || this.mCameraUIInterface.R_renamed()) {
            return;
        }
        this.mCameraUIInterface.k_renamed(4);
    }

    @Override // com.oplus.camera.capmode.d_renamed, com.oplus.camera.capmode.BaseMode
    protected void onDeInitCameraMode(java.lang.String str) {
        super.onDeInitCameraMode(str);
        this.mCameraUIInterface.a_renamed(true, true, true);
        this.mCameraUIInterface.e_renamed(4, true);
        this.mCameraUIInterface.j_renamed(false);
        this.h_renamed = 0;
        this.i_renamed = 0L;
        this.n_renamed = false;
        b_renamed();
        if (this.m_renamed.hasMessages(1)) {
            this.m_renamed.removeMessages(1);
        }
    }

    @Override // com.oplus.camera.capmode.d_renamed, com.oplus.camera.capmode.BaseMode
    public void onMoreModeShown() {
        this.mCameraUIInterface.j_renamed(false);
        this.mCameraUIInterface.e_renamed(4, true);
    }

    @Override // com.oplus.camera.capmode.d_renamed, com.oplus.camera.capmode.BaseMode
    public void onMoreModeHidden(int i_renamed) {
        super.onMoreModeHidden(i_renamed);
        this.mCameraUIInterface.j_renamed(true);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected boolean checkPreviewResult(com.oplus.camera.aps.util.CameraApsDecision cameraApsDecision) {
        return cameraApsDecision != null && cameraApsDecision.mMultiFrameCount > 0;
    }

    @Override // com.oplus.camera.capmode.d_renamed, com.oplus.camera.capmode.BaseMode
    public boolean onBackPressed() {
        if (getIsCapturingState()) {
            return true;
        }
        return super.onBackPressed();
    }

    @Override // com.oplus.camera.capmode.d_renamed, com.oplus.camera.capmode.BaseMode
    protected boolean onBeforeSnapping(com.oplus.camera.e_renamed.c_renamed cVar) {
        boolean zOnBeforeSnapping = super.onBeforeSnapping(cVar);
        this.mbCheckTakeAnimateDelay = false;
        return zOnBeforeSnapping;
    }
}

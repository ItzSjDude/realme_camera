package com.oplus.camera.photo3d;

/* compiled from: ThreeDPhotoMode.java */
/* loaded from: classes2.dex */
public class c_renamed extends com.oplus.camera.capmode.BaseMode {
    private static final java.lang.String[] g_renamed = {com.oplus.camera.ui.CameraUIInterface.KEY_3DPHOTO_FACEBEAUTY_LEVEL_MENU};
    private com.oplus.camera.photo3d.b_renamed h_renamed;
    private com.oplus.camera.photo3d.ui.g_renamed i_renamed;
    private java.util.concurrent.atomic.AtomicLong j_renamed;

    private boolean b_renamed() {
        return true;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean allowSwitchCamera() {
        return false;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public java.lang.String getCameraMode() {
        return com.oplus.camera.aps.constant.ApsConstant.CAPTURE_MODE_3D_PHOTO;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected java.lang.String getFaceBeautyKey() {
        return com.oplus.camera.ui.CameraUIInterface.KEY_3DPHOTO_FACEBEAUTY_LEVEL_MENU;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public java.lang.String getFilterEffectMenuPreferenceKey() {
        return com.oplus.camera.ui.CameraUIInterface.KEY_3D_PHOTO_FILTER_INDEX;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean getFrontEnable() {
        return false;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public java.lang.String getHeicCodecFormat() {
        return null;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public int getOperatingMode() {
        return 32769;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean getSupportQuickJpeg(com.oplus.camera.e_renamed.c_renamed cVar) {
        return false;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean isNeedShowMenuOnTimeSnapShotEnd() {
        return false;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected boolean onStopTakePicture() {
        return false;
    }

    public c_renamed(android.app.Activity activity, com.oplus.camera.capmode.a_renamed aVar, com.oplus.camera.ui.CameraUIInterface cameraUIInterface, com.oplus.camera.ui.preview.a_renamed.t_renamed tVar) {
        super(activity, aVar, cameraUIInterface, tVar);
        this.h_renamed = null;
        this.j_renamed = new java.util.concurrent.atomic.AtomicLong(0L);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void onInitCameraMode() {
        this.h_renamed = new com.oplus.camera.photo3d.b_renamed(this.mActivity, this.mCameraInterface, this.mCameraUIInterface);
        this.i_renamed = new com.oplus.camera.photo3d.ui.g_renamed(this.mActivity, this.mCameraInterface, this.mCameraUIInterface);
        this.i_renamed.a_renamed(this.h_renamed);
        this.h_renamed.a_renamed(new com.oplus.camera.photo3d.a_renamed() { // from class: com.oplus.camera.photo3d.c_renamed.1
            @Override // com.oplus.camera.photo3d.a_renamed
            public void a_renamed(long j_renamed) {
                if (j_renamed == com.oplus.camera.photo3d.c_renamed.this.j_renamed.get()) {
                    com.oplus.camera.photo3d.c_renamed.this.i_renamed.c_renamed();
                    com.oplus.camera.photo3d.c_renamed cVar = com.oplus.camera.photo3d.c_renamed.this;
                    cVar.onPictureCallback(null, 0, 0, cVar.getImageFormat(), false, 0);
                    com.oplus.camera.photo3d.c_renamed.this.j_renamed.set(0L);
                    com.oplus.camera.e_renamed.b_renamed("ThreeDPhoto", "onRecordingStop, identity: " + j_renamed);
                }
            }
        });
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void onBeforePreview() {
        applyBeautyParam();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onAfterStartPreview(boolean z_renamed) {
        super.onAfterStartPreview(z_renamed);
        this.i_renamed.b_renamed();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public android.util.Size getPictureSize(com.oplus.camera.e_renamed.h_renamed hVar) {
        return com.oplus.camera.aps.config.CameraConfig.getSizeConfigValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_3D_PHOTO_VIDEO_SIZE);
    }

    /* JADX WARN: Can't_renamed fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B_renamed:50:0x00ae  */
    @Override // com.oplus.camera.capmode.BaseMode
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean getSupportFunction(java.lang.String r5) {
        /*
            Method dump skipped, instructions count: 326
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.photo3d.c_renamed.getSupportFunction(java.lang.String):boolean");
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean getSupportMenu(java.lang.String str) {
        if (com.oplus.camera.ui.CameraUIInterface.KEY_SETTING.equals(str) || com.oplus.camera.ui.CameraUIInterface.KEY_FLASH_MODE.equals(str) || com.oplus.camera.ui.CameraUIInterface.KEY_CAMERA_TIMER_SHUTTER.equals(str)) {
            return true;
        }
        return super.getSupportMenu(str);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public com.oplus.camera.af_renamed getZoomConfigure() {
        com.oplus.camera.af_renamed zoomConfigure = super.getZoomConfigure();
        zoomConfigure.e_renamed(true);
        return zoomConfigure;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected java.lang.String[] getCustomBeautyKeys() {
        return g_renamed;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean needSurface(java.lang.String str) {
        return "type_capture".equals(str) || "type_still_capture_yuv_main".equals(str);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onEffectMenuPopUp() {
        super.onEffectMenuPopUp();
        this.i_renamed.c_renamed(true, true);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onEffectMenuPopDown(boolean z_renamed) {
        super.onEffectMenuPopDown(z_renamed);
        this.i_renamed.b_renamed(true, true);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected boolean onBeforeSnapping(com.oplus.camera.e_renamed.c_renamed cVar) {
        if (a_renamed()) {
            this.mCameraUIInterface.a_renamed(com.oplus.camera.R_renamed.string.camera_high_temperature_3d_photo_disable, -1, true, false, false);
            com.oplus.camera.e_renamed.f_renamed("ThreeDPhoto", "onBeforeSnapping, Can't_renamed capture for high temperature");
            return false;
        }
        this.i_renamed.b_renamed(this.h_renamed.c_renamed());
        return true;
    }

    private boolean a_renamed() {
        return 1 == android.provider.Settings.System.getInt(this.mActivity.getContentResolver(), "oplus.camera.video", 0);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void onShutterCallback(boolean z_renamed, boolean z2) {
        super.onShutterCallback(z_renamed, z2);
        if (z_renamed || !z2) {
            return;
        }
        this.mCameraInterface.h_renamed();
        this.mCameraInterface.c_renamed(0);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void updateCaptureParam(com.oplus.camera.e_renamed.c_renamed cVar) throws android.content.res.Resources.NotFoundException {
        super.updateCaptureParam(cVar);
        this.mOneCamera.e_renamed(b_renamed());
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void onAfterPictureTaken(byte[] bArr, boolean z_renamed) {
        com.oplus.camera.e_renamed.a_renamed("ThreeDPhoto", "onAfterPictureTaken");
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean consumeImage(com.oplus.ocs.camera.CameraPictureCallback.CameraPictureImage cameraPictureImage) {
        return b_renamed();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean needStoreImage() {
        return !b_renamed();
    }

    @Override // com.oplus.camera.capmode.BaseMode, com.oplus.camera.e_renamed.d_renamed.a_renamed
    public void onCaptureStarted(android.hardware.camera2.CameraCaptureSession cameraCaptureSession, android.hardware.camera2.CaptureRequest captureRequest, long j_renamed, long j2) {
        if (this.mCaptureStartedCallbackNum == 0) {
            this.j_renamed.set(j_renamed);
        }
        super.onCaptureStarted(cameraCaptureSession, captureRequest, j_renamed, j2);
    }

    @Override // com.oplus.camera.capmode.BaseMode, com.oplus.camera.e_renamed.d_renamed.a_renamed
    public void onCaptureCompleted(com.oplus.camera.aps.service.CameraCaptureResult cameraCaptureResult, com.oplus.camera.e_renamed.c_renamed cVar) {
        super.onCaptureCompleted(cameraCaptureResult, cVar);
        if (0 == cameraCaptureResult.mMeshPtr) {
            com.oplus.camera.e_renamed.f_renamed("ThreeDPhoto", "onCaptureCompleted, return for null mesh pointer");
            return;
        }
        if (cameraCaptureResult.mIdentity != this.j_renamed.get()) {
            com.oplus.camera.photo3d.PhotoMeshData.release(cameraCaptureResult.mMeshPtr);
            com.oplus.camera.e_renamed.b_renamed("ThreeDPhoto", "onCaptureCompleted, skip process capture: " + cameraCaptureResult.mIdentity);
            return;
        }
        com.oplus.camera.photo3d.b_renamed bVar = this.h_renamed;
        if (bVar != null) {
            bVar.a_renamed(cameraCaptureResult.mMeshPtr, cameraCaptureResult.mIdentity);
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode, com.oplus.camera.e_renamed.d_renamed.a_renamed
    public void onCaptureFirstFrameArrived(android.hardware.camera2.CaptureRequest captureRequest, com.oplus.camera.aps.service.CameraCaptureResult cameraCaptureResult) {
        super.onCaptureFirstFrameArrived(captureRequest, cameraCaptureResult);
        this.mCameraUIInterface.a_renamed(com.oplus.camera.R_renamed.string.camera_3d_photo_process_hint, -1, false, false, true);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean onSingleTapUp(android.view.MotionEvent motionEvent) {
        com.oplus.camera.photo3d.ui.g_renamed gVar = this.i_renamed;
        if (gVar != null) {
            return gVar.a_renamed(motionEvent);
        }
        return super.onSingleTapUp(motionEvent);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onZoomMenuExpand() {
        super.onZoomMenuExpand();
        com.oplus.camera.photo3d.ui.g_renamed gVar = this.i_renamed;
        if (gVar != null) {
            gVar.c_renamed(true, true);
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onZoomMenuCollapsing() {
        super.onZoomMenuCollapsing();
        if (this.i_renamed == null || getIsCapturingState()) {
            return;
        }
        this.i_renamed.b_renamed(true, true);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected boolean isHideUICapture() {
        return getIsCapturingState();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean isBottomGuideEntryViewShown() {
        com.oplus.camera.photo3d.ui.g_renamed gVar = this.i_renamed;
        return gVar != null && gVar.f_renamed();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void setOrientation(int i_renamed) {
        super.setOrientation(i_renamed);
        com.oplus.camera.photo3d.ui.g_renamed gVar = this.i_renamed;
        if (gVar != null) {
            gVar.a_renamed(i_renamed);
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void changeModeAllViewWhenAnimation(int i_renamed, boolean z_renamed) {
        com.oplus.camera.photo3d.ui.g_renamed gVar;
        super.changeModeAllViewWhenAnimation(i_renamed, z_renamed);
        if (3 != i_renamed || (gVar = this.i_renamed) == null) {
            return;
        }
        gVar.a_renamed(z_renamed, getIsCapturingState());
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void onPause() {
        com.oplus.camera.e_renamed.a_renamed("ThreeDPhoto", "onPause");
        this.i_renamed.g_renamed();
        c_renamed();
    }

    private void c_renamed() {
        if (this.j_renamed.get() != 0) {
            com.oplus.camera.e_renamed.b_renamed("ThreeDPhoto", "cancelCapture: " + this.j_renamed.get());
            this.j_renamed.set(0L);
            this.h_renamed.a_renamed();
            this.i_renamed.c_renamed();
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void onStop() {
        com.oplus.camera.e_renamed.a_renamed("ThreeDPhoto", "onStop");
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void onDestroy() {
        com.oplus.camera.e_renamed.a_renamed("ThreeDPhoto", "onDestroy");
        com.oplus.camera.photo3d.b_renamed bVar = this.h_renamed;
        if (bVar != null) {
            bVar.b_renamed();
            this.h_renamed = null;
        }
        com.oplus.camera.photo3d.ui.g_renamed gVar = this.i_renamed;
        if (gVar != null) {
            gVar.h_renamed();
            this.i_renamed = null;
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void onDeInitCameraMode(java.lang.String str) {
        com.oplus.camera.e_renamed.a_renamed("ThreeDPhoto", "onDeInitCameraMode");
        if (this.mPreviewEffectProcess != null) {
            this.mPreviewEffectProcess.g_renamed(0);
        }
        com.oplus.camera.photo3d.b_renamed bVar = this.h_renamed;
        if (bVar != null) {
            bVar.b_renamed();
            this.h_renamed = null;
        }
        com.oplus.camera.photo3d.ui.g_renamed gVar = this.i_renamed;
        if (gVar != null) {
            gVar.h_renamed();
            this.i_renamed = null;
        }
    }
}

package com.oplus.camera.tiltshift;

/* loaded from: classes2.dex */
public class TiltShiftPhotoMode extends com.oplus.camera.capmode.d_renamed {
    private static final java.lang.String TAG = "TiltShiftPhotoMode";

    @Override // com.oplus.camera.capmode.d_renamed, com.oplus.camera.capmode.BaseMode
    public java.lang.String getCameraMode() {
        return com.oplus.camera.aps.constant.ApsConstant.CAPTURE_MODE_TILT_SHIFT;
    }

    @Override // com.oplus.camera.capmode.d_renamed, com.oplus.camera.capmode.BaseMode
    public java.lang.String getFilterEffectMenuPreferenceKey() {
        return com.oplus.camera.ui.CameraUIInterface.KEY_TILT_SHIFT_FILTER_INDEX;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean getFrontEnable() {
        return false;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected boolean isShowUltraWide() {
        return true;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected boolean isTiltShiftSupportBeauty() {
        return true;
    }

    public TiltShiftPhotoMode(android.app.Activity activity, com.oplus.camera.capmode.a_renamed aVar, com.oplus.camera.ui.CameraUIInterface cameraUIInterface, com.oplus.camera.ui.preview.a_renamed.t_renamed tVar) {
        super(activity, aVar, cameraUIInterface, tVar);
    }

    private java.lang.String getApsCaptureMode() {
        return super.getCameraMode();
    }

    @Override // com.oplus.camera.capmode.d_renamed, com.oplus.camera.capmode.BaseMode
    public boolean getSupportMenu(java.lang.String str) {
        if (com.oplus.camera.ui.CameraUIInterface.KEY_CAMERA_TIMER_SHUTTER.equals(str) || com.oplus.camera.ui.CameraUIInterface.KEY_SETTING.equals(str) || com.oplus.camera.ui.CameraUIInterface.KEY_PHOTO_RATIO.equals(str)) {
            return true;
        }
        if (com.oplus.camera.ui.CameraUIInterface.KEY_SUB_SETTING.equals(str) || com.oplus.camera.ui.CameraUIInterface.KEY_MACRO_SWITCH.equals(str)) {
            return getSupportFunction(str);
        }
        return super.getSupportMenu(str);
    }

    /* JADX WARN: Can't_renamed fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B_renamed:53:0x00b9  */
    @Override // com.oplus.camera.capmode.d_renamed, com.oplus.camera.capmode.BaseMode
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean getSupportFunction(java.lang.String r5) {
        /*
            Method dump skipped, instructions count: 414
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.tiltshift.TiltShiftPhotoMode.getSupportFunction(java.lang.String):boolean");
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected boolean isTiltShiftOpen() {
        return getSupportFunction(com.oplus.camera.aps.config.CameraFunction.TILT_SHIFT);
    }

    @Override // com.oplus.camera.capmode.d_renamed, com.oplus.camera.capmode.BaseMode
    protected void onBeforePreview() {
        super.onBeforePreview();
        this.mOneCamera.a_renamed((com.oplus.ocs.camera.CameraParameter.PreviewKey<com.oplus.ocs.camera.CameraParameter.PreviewKey<java.lang.Boolean>>) com.oplus.ocs.camera.CameraParameter.TILT_SHIFT_ENABLE, (com.oplus.ocs.camera.CameraParameter.PreviewKey<java.lang.Boolean>) java.lang.Boolean.valueOf(isTiltShiftOpen()));
    }

    @Override // com.oplus.camera.capmode.d_renamed, com.oplus.camera.capmode.BaseMode
    protected void updateCaptureParam(com.oplus.camera.e_renamed.c_renamed cVar) throws android.content.res.Resources.NotFoundException {
        com.oplus.camera.tiltshift.TiltShiftParam tiltShiftParamAM;
        super.updateCaptureParam(cVar);
        if (this.mCameraInterface == null || (tiltShiftParamAM = this.mCameraInterface.aM_renamed()) == null) {
            return;
        }
        java.lang.String string = java.util.Arrays.toString(new float[]{tiltShiftParamAM.getCenterX(), tiltShiftParamAM.getCenterY()});
        int i_renamed = !tiltShiftParamAM.isCircle() ? 1 : 0;
        android.util.Size previewSize = tiltShiftParamAM.getPreviewSize();
        java.lang.String string2 = java.util.Arrays.toString(new int[]{previewSize.getWidth(), previewSize.getHeight()});
        android.os.Bundle bundle = new android.os.Bundle();
        bundle.putString(com.oplus.ocs.camera.CameraParameter.TiltShiftParamKeys.PREVIEW_SIZE, string2);
        bundle.putInt(com.oplus.ocs.camera.CameraParameter.TiltShiftParamKeys.BLUR_VALUE, getTiltShiftBlurIndex());
        bundle.putString(com.oplus.ocs.camera.CameraParameter.TiltShiftParamKeys.TYPE, java.lang.String.valueOf(i_renamed));
        bundle.putString(com.oplus.ocs.camera.CameraParameter.TiltShiftParamKeys.CENTER_POSITION, string);
        bundle.putString(com.oplus.ocs.camera.CameraParameter.TiltShiftParamKeys.CLEAR_DISTANCE, java.lang.String.valueOf(tiltShiftParamAM.getInnerDistance()));
        bundle.putString(com.oplus.ocs.camera.CameraParameter.TiltShiftParamKeys.ROTATE_ANGLE, java.lang.String.valueOf(tiltShiftParamAM.getAngle()));
        this.mOneCamera.a_renamed((com.oplus.ocs.camera.CameraParameter.PreviewKey<com.oplus.ocs.camera.CameraParameter.PreviewKey<android.os.Bundle>>) com.oplus.ocs.camera.CameraParameter.TILT_SHIFT_PARAM, (com.oplus.ocs.camera.CameraParameter.PreviewKey<android.os.Bundle>) bundle);
    }

    @Override // com.oplus.camera.capmode.d_renamed, com.oplus.camera.capmode.BaseMode
    protected boolean onBeforeSnapping(com.oplus.camera.e_renamed.c_renamed cVar) {
        boolean zOnBeforeSnapping = super.onBeforeSnapping(cVar);
        this.mbCheckTakeAnimateDelay = false;
        return zOnBeforeSnapping;
    }

    @Override // com.oplus.camera.capmode.d_renamed, com.oplus.camera.capmode.BaseMode
    protected java.util.List<java.lang.Integer> getFilterNameIdList(int i_renamed) {
        if (!getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_PHOTO_MONO_FILTER)) {
            return com.oplus.camera.ui.preview.a_renamed.j_renamed.o_renamed.b_renamed(com.oplus.camera.e_renamed.a_renamed.a_renamed(i_renamed));
        }
        return super.getFilterNameIdList(i_renamed);
    }

    @Override // com.oplus.camera.capmode.d_renamed, com.oplus.camera.capmode.BaseMode
    protected java.util.List<java.lang.String> getFilterTypeList(int i_renamed) {
        if (!getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_PHOTO_MONO_FILTER)) {
            return com.oplus.camera.ui.preview.a_renamed.j_renamed.o_renamed.a_renamed(com.oplus.camera.e_renamed.a_renamed.a_renamed(i_renamed));
        }
        return super.getFilterTypeList(i_renamed);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected boolean isBlurOpen() {
        return getSupportFunction(com.oplus.camera.aps.config.CameraFunction.TILT_SHIFT);
    }
}

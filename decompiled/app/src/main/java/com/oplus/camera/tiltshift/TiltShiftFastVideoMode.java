package com.oplus.camera.tiltshift;

/* loaded from: classes2.dex */
public class TiltShiftFastVideoMode extends com.oplus.camera.h_renamed.a_renamed {
    private static final java.lang.String TAG = "TiltShiftFastVideoMode";

    @Override // com.oplus.camera.h_renamed.a_renamed, com.oplus.camera.capmode.BaseMode
    public java.lang.String getCameraMode() {
        return com.oplus.camera.aps.constant.ApsConstant.REC_MODE_TILT_SHIFT_FAST_VIDEO;
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
    protected boolean isVideoTimeLapseTiltShiftOpen() {
        return true;
    }

    public TiltShiftFastVideoMode(android.app.Activity activity, com.oplus.camera.capmode.a_renamed aVar, com.oplus.camera.ui.CameraUIInterface cameraUIInterface, com.oplus.camera.ui.preview.a_renamed.t_renamed tVar) {
        super(activity, aVar, cameraUIInterface, tVar);
    }

    @Override // com.oplus.camera.h_renamed.a_renamed, com.oplus.camera.capmode.w_renamed, com.oplus.camera.capmode.BaseMode
    protected void onInitCameraMode() {
        com.oplus.camera.e_renamed.a_renamed(TAG, "onInitCameraMode");
        if (isHyperLapseOpen()) {
            this.mPreferences.edit().putString(com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_HYPER_LAPSE_MENU, "off").apply();
        }
        super.onInitCameraMode();
    }

    /* JADX WARN: Can't_renamed fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as_renamed a_renamed decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B_renamed:20:0x003f  */
    @Override // com.oplus.camera.h_renamed.a_renamed, com.oplus.camera.capmode.w_renamed, com.oplus.camera.capmode.BaseMode
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean getSupportFunction(java.lang.String r8) {
        /*
            r7 = this;
            int r0 = r8.hashCode()
            java.lang.String r1 = "func_tilt_shift"
            r2 = 4
            r3 = 3
            r4 = 2
            r5 = 0
            r6 = 1
            switch(r0) {
                case -1275858725: goto L37;
                case -960512556: goto L2d;
                case 911623499: goto L23;
                case 1658506892: goto L19;
                case 1773908314: goto Lf;
                default: goto Le;
            }
        Le:
            goto L3f
        Lf:
            java.lang.String r0 = "pref_video_hyper_lapse_key"
            boolean r0 = r8.equals(r0)
            if (r0 == 0) goto L3f
            r0 = r4
            goto L40
        L19:
            java.lang.String r0 = "pref_fast_video_size_key"
            boolean r0 = r8.equals(r0)
            if (r0 == 0) goto L3f
            r0 = r6
            goto L40
        L23:
            java.lang.String r0 = "func_video_hyper_lapse_process"
            boolean r0 = r8.equals(r0)
            if (r0 == 0) goto L3f
            r0 = r3
            goto L40
        L2d:
            java.lang.String r0 = "pref_tilt_shift_blur_menu"
            boolean r0 = r8.equals(r0)
            if (r0 == 0) goto L3f
            r0 = r2
            goto L40
        L37:
            boolean r0 = r8.equals(r1)
            if (r0 == 0) goto L3f
            r0 = r5
            goto L40
        L3f:
            r0 = -1
        L40:
            if (r0 == 0) goto L55
            if (r0 == r6) goto L54
            if (r0 == r4) goto L54
            if (r0 == r3) goto L54
            if (r0 == r2) goto L4f
            boolean r7 = super.getSupportFunction(r8)
            return r7
        L4f:
            boolean r7 = r7.getSupportFunction(r1)
            return r7
        L54:
            return r5
        L55:
            java.lang.String r8 = "com.oplus.feature.tilt.shift.fastvideo.support"
            boolean r8 = com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(r8)
            if (r8 == 0) goto L6a
            com.oplus.camera.capmode.a_renamed r8 = r7.mCameraInterface
            if (r8 == 0) goto L6a
            com.oplus.camera.capmode.a_renamed r7 = r7.mCameraInterface
            boolean r7 = r7.i_renamed()
            if (r7 == 0) goto L6a
            r5 = r6
        L6a:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.tiltshift.TiltShiftFastVideoMode.getSupportFunction(java.lang.String):boolean");
    }

    @Override // com.oplus.camera.h_renamed.a_renamed, com.oplus.camera.capmode.w_renamed, com.oplus.camera.capmode.BaseMode
    public boolean getSupportMenu(java.lang.String str) {
        if (com.oplus.camera.ui.CameraUIInterface.KEY_FAST_VIDEO_SIZE.equals(str)) {
            return false;
        }
        return super.getSupportMenu(str);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected boolean isTiltShiftOpen() {
        return getSupportFunction(com.oplus.camera.aps.config.CameraFunction.TILT_SHIFT);
    }

    @Override // com.oplus.camera.capmode.w_renamed
    protected void updateVideoTypeExif(java.io.File file) throws java.lang.Throwable {
        com.oplus.camera.g_renamed.b_renamed.a_renamed(file, com.oplus.camera.g_renamed.b_renamed.a_renamed(getVideoFileExifTag()));
    }
}

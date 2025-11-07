package com.oplus.camera.capmode;

/* compiled from: FishEyeMode.java */
/* loaded from: classes2.dex */
public class h_renamed extends com.oplus.camera.capmode.d_renamed {
    private static final java.lang.String g_renamed = "h_renamed";
    private boolean h_renamed;

    @Override // com.oplus.camera.capmode.d_renamed, com.oplus.camera.capmode.BaseMode
    public java.lang.String getCameraMode() {
        return com.oplus.camera.aps.constant.ApsConstant.CAPTURE_MODE_FISH_EYE;
    }

    @Override // com.oplus.camera.capmode.d_renamed, com.oplus.camera.capmode.BaseMode
    public java.lang.String getFilterEffectMenuPreferenceKey() {
        return com.oplus.camera.ui.CameraUIInterface.KEY_FISH_EYE_FILTER_INDEX;
    }

    @Override // com.oplus.camera.capmode.d_renamed, com.oplus.camera.capmode.BaseMode
    public int getOperatingMode() {
        return 32939;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean getSupportQuickJpeg(com.oplus.camera.e_renamed.c_renamed cVar) {
        return false;
    }

    @Override // com.oplus.camera.capmode.d_renamed, com.oplus.camera.capmode.BaseMode
    public boolean getSupportSubMenu(java.lang.String str) {
        return false;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean isNeedAPSProcess() {
        return true;
    }

    public h_renamed(android.app.Activity activity, com.oplus.camera.capmode.a_renamed aVar, com.oplus.camera.ui.CameraUIInterface cameraUIInterface, com.oplus.camera.ui.preview.a_renamed.t_renamed tVar) {
        super(activity, aVar, cameraUIInterface, tVar);
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

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean getSupportFaceView() {
        return !a_renamed();
    }

    /* JADX WARN: Can't_renamed fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B_renamed:38:0x007e  */
    @Override // com.oplus.camera.capmode.d_renamed, com.oplus.camera.capmode.BaseMode
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean getSupportFunction(java.lang.String r4) {
        /*
            r3 = this;
            int r0 = r4.hashCode()
            r1 = 1
            r2 = 0
            switch(r0) {
                case -1594132768: goto L74;
                case -1549661173: goto L6a;
                case -1342983725: goto L60;
                case -1281904608: goto L56;
                case -681469213: goto L4b;
                case -532036662: goto L40;
                case -100202123: goto L36;
                case 39023177: goto L2b;
                case 193299961: goto L21;
                case 1433615423: goto L16;
                case 1599576324: goto Lb;
                default: goto L9;
            }
        L9:
            goto L7e
        Lb:
            java.lang.String r0 = "pref_support_switch_camera"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L7e
            r0 = 2
            goto L7f
        L16:
            java.lang.String r0 = "key_high_picture_size"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L7e
            r0 = 6
            goto L7f
        L21:
            java.lang.String r0 = "func_sat_camera"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L7e
            r0 = 3
            goto L7f
        L2b:
            java.lang.String r0 = "func_google_lens"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L7e
            r0 = 8
            goto L7f
        L36:
            java.lang.String r0 = "pref_burst_shot_key"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L7e
            r0 = 5
            goto L7f
        L40:
            java.lang.String r0 = "fish_eye"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L7e
            r0 = 10
            goto L7f
        L4b:
            java.lang.String r0 = "key_support_update_thumbnail_user_picture"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L7e
            r0 = 9
            goto L7f
        L56:
            java.lang.String r0 = "pref_10bits_heic_encode_key"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L7e
            r0 = 4
            goto L7f
        L60:
            java.lang.String r0 = "func_face_beauty_process"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L7e
            r0 = 7
            goto L7f
        L6a:
            java.lang.String r0 = "pref_camera_high_resolution_key"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L7e
            r0 = r2
            goto L7f
        L74:
            java.lang.String r0 = "pref_camera_photo_ratio_key"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L7e
            r0 = r1
            goto L7f
        L7e:
            r0 = -1
        L7f:
            switch(r0) {
                case 0: goto L88;
                case 1: goto L88;
                case 2: goto L88;
                case 3: goto L88;
                case 4: goto L88;
                case 5: goto L88;
                case 6: goto L88;
                case 7: goto L88;
                case 8: goto L88;
                case 9: goto L87;
                case 10: goto L87;
                default: goto L82;
            }
        L82:
            boolean r3 = super.getSupportFunction(r4)
            return r3
        L87:
            return r1
        L88:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.capmode.h_renamed.getSupportFunction(java.lang.String):boolean");
    }

    @Override // com.oplus.camera.capmode.d_renamed, com.oplus.camera.capmode.BaseMode
    public boolean getSupportMenu(java.lang.String str) {
        return getSupportFunction(com.oplus.camera.entry.b_renamed.d_renamed(str));
    }

    @Override // com.oplus.camera.capmode.d_renamed, com.oplus.camera.capmode.BaseMode
    public com.oplus.camera.af_renamed getZoomConfigure() {
        com.oplus.camera.af_renamed zoomConfigure = super.getZoomConfigure();
        zoomConfigure.B_renamed(true);
        zoomConfigure.C_renamed(a_renamed());
        zoomConfigure.q_renamed(true);
        zoomConfigure.a_renamed(com.oplus.camera.R_renamed.drawable.zoom_seek_bar_fisheye_normal);
        zoomConfigure.b_renamed(com.oplus.camera.R_renamed.drawable.zoom_seek_bar_fisheye_circle);
        return zoomConfigure;
    }

    private boolean a_renamed() {
        if (this.mPreferences != null) {
            return "on_renamed".equals(this.mPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_FISH_EYE_MODE, this.mActivity != null ? this.mActivity.getString(com.oplus.camera.R_renamed.string.camera_fish_eye_mode_default_value) : "off"));
        }
        return false;
    }

    @Override // com.oplus.camera.capmode.d_renamed, com.oplus.camera.capmode.BaseMode
    protected void onBeforePreview() {
        super.onBeforePreview();
        if (this.mPreferences != null) {
            this.mOneCamera.a_renamed((com.oplus.ocs.camera.CameraParameter.PreviewKey<com.oplus.ocs.camera.CameraParameter.PreviewKey<java.lang.Boolean>>) com.oplus.ocs.camera.CameraParameter.FISH_EYE_MODE, (com.oplus.ocs.camera.CameraParameter.PreviewKey<java.lang.Boolean>) java.lang.Boolean.valueOf(a_renamed()));
        }
        c_renamed();
    }

    @Override // com.oplus.camera.capmode.d_renamed, com.oplus.camera.capmode.BaseMode
    protected void onDeInitCameraMode(java.lang.String str) {
        this.h_renamed = false;
        c_renamed();
        super.onDeInitCameraMode(str);
    }

    @Override // com.oplus.camera.capmode.d_renamed, com.oplus.camera.capmode.BaseMode
    protected void onInitCameraMode() {
        super.onInitCameraMode();
        this.h_renamed = true;
        c_renamed();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void doAfterStartPreview() {
        super.doAfterStartPreview();
        if (this.mCameraUIInterface != null) {
            this.mCameraUIInterface.a_renamed(com.oplus.camera.R_renamed.string.camera_fish_eye_enter_hint, -1, true, false, false);
        }
    }

    @Override // com.oplus.camera.capmode.d_renamed, com.oplus.camera.capmode.BaseMode
    public void onSharedPreferenceChanged(android.content.SharedPreferences sharedPreferences, java.lang.String str) {
        super.onSharedPreferenceChanged(sharedPreferences, str);
        if (com.oplus.camera.ui.CameraUIInterface.KEY_FISH_EYE_MODE.equals(str)) {
            boolean zA = a_renamed();
            c_renamed();
            b_renamed();
            this.mOneCamera.a_renamed((com.oplus.ocs.camera.CameraParameter.PreviewKey<com.oplus.ocs.camera.CameraParameter.PreviewKey<java.lang.Boolean>>) com.oplus.ocs.camera.CameraParameter.FISH_EYE_MODE, (com.oplus.ocs.camera.CameraParameter.PreviewKey<java.lang.Boolean>) java.lang.Boolean.valueOf(zA));
            this.mOneCamera.a_renamed((com.oplus.camera.e_renamed.d_renamed.c_renamed) null);
        }
    }

    private void b_renamed() {
        new com.oplus.camera.statistics.model.FishEyeMsgData(this.mActivity, a_renamed(), this.mCameraId).report();
    }

    private void c_renamed() {
        com.oplus.camera.e_renamed.b_renamed(g_renamed, "updateFishEyeActivateState, mbCapModeInit: " + this.h_renamed + ", isFishEyeEnabled: " + a_renamed());
        boolean z_renamed = this.h_renamed && a_renamed();
        if (this.mCameraUIInterface != null) {
            this.mCameraUIInterface.G_renamed(z_renamed);
        }
        if (this.mPreviewEffectProcess != null) {
            this.mPreviewEffectProcess.h_renamed(z_renamed);
        }
    }
}

package com.oplus.camera.capmode;

import android.app.Activity;
import android.content.SharedPreferences;
import android.util.Size;
import com.oplus.camera.ZoomConfigure;
import com.oplus.camera.CameraLog;
import com.oplus.camera.R;
import com.oplus.camera.aps.constant.ApsConstant;
import com.oplus.camera.entry.CameraEntry;
import com.oplus.camera.p141e.CameraRequestTag;
import com.oplus.camera.p141e.OplusCameraCharacteristics;
import com.oplus.camera.p141e.OneCamera;
import com.oplus.camera.p172ui.CameraUIInterface;
import com.oplus.camera.p172ui.preview.p177a.PreviewEffectProcess;
import com.oplus.camera.statistics.model.FishEyeMsgData;
import com.oplus.camera.util.Util;
import com.oplus.ocs.camera.CameraParameter;

/* compiled from: FishEyeMode.java */
/* renamed from: com.oplus.camera.capmode.COUIBaseListPopupWindow_10 */
/* loaded from: classes2.dex */
public class FishEyeMode extends CommonCapMode {

    /* renamed from: COUIBaseListPopupWindow_11 */
    private static final String f12899g = "COUIBaseListPopupWindow_10";

    /* renamed from: COUIBaseListPopupWindow_10 */
    private boolean f12900h;

    @Override // com.oplus.camera.capmode.CommonCapMode, com.oplus.camera.capmode.BaseMode
    public String getCameraMode() {
        return ApsConstant.CAPTURE_MODE_FISH_EYE;
    }

    @Override // com.oplus.camera.capmode.CommonCapMode, com.oplus.camera.capmode.BaseMode
    public String getFilterEffectMenuPreferenceKey() {
        return CameraUIInterface.KEY_FISH_EYE_FILTER_INDEX;
    }

    @Override // com.oplus.camera.capmode.CommonCapMode, com.oplus.camera.capmode.BaseMode
    public int getOperatingMode() {
        return 32939;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean getSupportQuickJpeg(CameraRequestTag c2693c) {
        return false;
    }

    @Override // com.oplus.camera.capmode.CommonCapMode, com.oplus.camera.capmode.BaseMode
    public boolean getSupportSubMenu(String str) {
        return false;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean isNeedAPSProcess() {
        return true;
    }

    public FishEyeMode(Activity activity, CameraInterface interfaceC2646a, CameraUIInterface cameraUIInterface, PreviewEffectProcess interfaceC3423t) {
        super(activity, interfaceC2646a, cameraUIInterface, interfaceC3423t);
    }

    @Override // com.oplus.camera.capmode.CommonCapMode, com.oplus.camera.capmode.BaseMode
    public Size getPictureSize(OplusCameraCharacteristics c2698h) {
        return Util.m24378b(c2698h.m13258a(256), 1.3333333333333333d);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public Size getPreviewSize(OplusCameraCharacteristics c2698h, double IntrinsicsJvm.kt_5) {
        return super.getPreviewSize(c2698h, 1.3333333333333333d);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public Size getPreviewSize(OplusCameraCharacteristics c2698h, String str) {
        return super.getPreviewSize(c2698h, 1.3333333333333333d);
    }

    @Override // com.oplus.camera.capmode.CommonCapMode, com.oplus.camera.capmode.BaseMode
    public Size getPreviewSize(OplusCameraCharacteristics c2698h) {
        return super.getPreviewSize(c2698h, 1.3333333333333333d);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean getSupportFaceView() {
        return !m12450a();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:38:0x007e  */
    @Override // com.oplus.camera.capmode.CommonCapMode, com.oplus.camera.capmode.BaseMode
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
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.capmode.FishEyeMode.getSupportFunction(java.lang.String):boolean");
    }

    @Override // com.oplus.camera.capmode.CommonCapMode, com.oplus.camera.capmode.BaseMode
    public boolean getSupportMenu(String str) {
        return getSupportFunction(CameraEntry.m13305d(str));
    }

    @Override // com.oplus.camera.capmode.CommonCapMode, com.oplus.camera.capmode.BaseMode
    public ZoomConfigure getZoomConfigure() {
        ZoomConfigure zoomConfigure = super.getZoomConfigure();
        zoomConfigure.m11298B(true);
        zoomConfigure.m11300C(m12450a());
        zoomConfigure.m11363q(true);
        zoomConfigure.m11325a(R.drawable.zoom_seek_bar_fisheye_normal);
        zoomConfigure.m11330b(R.drawable.zoom_seek_bar_fisheye_circle);
        return zoomConfigure;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private boolean m12450a() {
        if (this.mPreferences != null) {
            return "on".equals(this.mPreferences.getString(CameraUIInterface.KEY_FISH_EYE_MODE, this.mActivity != null ? this.mActivity.getString(R.string.camera_fish_eye_mode_default_value) : "off"));
        }
        return false;
    }

    @Override // com.oplus.camera.capmode.CommonCapMode, com.oplus.camera.capmode.BaseMode
    protected void onBeforePreview() {
        super.onBeforePreview();
        if (this.mPreferences != null) {
            this.mOneCamera.mo13040a((CameraParameter.PreviewKey<CameraParameter.PreviewKey<Boolean>>) CameraParameter.FISH_EYE_MODE, (CameraParameter.PreviewKey<Boolean>) Boolean.valueOf(m12450a()));
        }
        m12452c();
    }

    @Override // com.oplus.camera.capmode.CommonCapMode, com.oplus.camera.capmode.BaseMode
    protected void onDeInitCameraMode(String str) {
        this.f12900h = false;
        m12452c();
        super.onDeInitCameraMode(str);
    }

    @Override // com.oplus.camera.capmode.CommonCapMode, com.oplus.camera.capmode.BaseMode
    protected void onInitCameraMode() {
        super.onInitCameraMode();
        this.f12900h = true;
        m12452c();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void doAfterStartPreview() {
        super.doAfterStartPreview();
        if (this.mCameraUIInterface != null) {
            this.mCameraUIInterface.mo18070a(R.string.camera_fish_eye_enter_hint, -1, true, false, false);
        }
    }

    @Override // com.oplus.camera.capmode.CommonCapMode, com.oplus.camera.capmode.BaseMode
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        super.onSharedPreferenceChanged(sharedPreferences, str);
        if (CameraUIInterface.KEY_FISH_EYE_MODE.equals(str)) {
            boolean zM12450a = m12450a();
            m12452c();
            m12451b();
            this.mOneCamera.mo13040a((CameraParameter.PreviewKey<CameraParameter.PreviewKey<Boolean>>) CameraParameter.FISH_EYE_MODE, (CameraParameter.PreviewKey<Boolean>) Boolean.valueOf(zM12450a));
            this.mOneCamera.mo13035a((OneCamera.IntrinsicsJvm.kt_3) null);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private void m12451b() {
        new FishEyeMsgData(this.mActivity, m12450a(), this.mCameraId).report();
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private void m12452c() {
        CameraLog.m12959b(f12899g, "updateFishEyeActivateState, mbCapModeInit: " + this.f12900h + ", isFishEyeEnabled: " + m12450a());
        boolean z = this.f12900h && m12450a();
        if (this.mCameraUIInterface != null) {
            this.mCameraUIInterface.mo18035G(z);
        }
        if (this.mPreviewEffectProcess != null) {
            this.mPreviewEffectProcess.mo22838h(z);
        }
    }
}

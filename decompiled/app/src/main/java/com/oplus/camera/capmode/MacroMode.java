package com.oplus.camera.capmode;

import android.app.Activity;
import android.content.SharedPreferences;
import android.util.Size;
import com.oplus.camera.CameraLog;
import com.oplus.camera.Camera;
import com.oplus.camera.R;
import com.oplus.camera.aps.config.CameraConfig;
import com.oplus.camera.aps.config.ConfigDataBase;
import com.oplus.camera.aps.constant.ApsConstant;
import com.oplus.camera.p141e.CameraCharacteristicsUtil;
import com.oplus.camera.p141e.CameraRequestTag;
import com.oplus.camera.p141e.OplusCameraCharacteristics;
import com.oplus.camera.p172ui.CameraUIInterface;
import com.oplus.camera.p172ui.control.MainShutterButtonInfo;
import com.oplus.camera.p172ui.preview.p177a.FilterHelper;
import com.oplus.camera.p172ui.preview.p177a.PreviewEffectProcess;
import com.oplus.camera.util.Util;
import java.util.List;

/* compiled from: MacroMode.java */
/* renamed from: com.oplus.camera.capmode.OplusGLSurfaceView_11 */
/* loaded from: classes2.dex */
public class MacroMode extends BaseMode {

    /* renamed from: COUIBaseListPopupWindow_11 */
    private boolean f12936g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private int f12937h;

    @Override // com.oplus.camera.capmode.BaseMode
    public String getCameraMode() {
        return ApsConstant.CAPTURE_MODE_MACRO;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public String getFilterEffectMenuPreferenceKey() {
        return CameraUIInterface.KEY_MACRO_FILTER_INDEX;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean getFrontEnable() {
        return false;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public int getOperatingMode() {
        return 32934;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void onBeforePreview() {
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected boolean onBeforeSnapping(CameraRequestTag c2693c) {
        return true;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void onDestroy() {
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void onInitCameraMode() {
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void onPause() {
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void onStop() {
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected boolean onStopTakePicture() {
        return false;
    }

    public MacroMode(Activity activity, CameraInterface interfaceC2646a, CameraUIInterface cameraUIInterface, PreviewEffectProcess interfaceC3423t) {
        super(activity, interfaceC2646a, cameraUIInterface, interfaceC3423t);
        this.f12936g = false;
        this.f12937h = 0;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected List<Integer> getFilterNameIdList(int OplusGLSurfaceView_13) {
        return FilterHelper.f21318h.m22566b(CameraCharacteristicsUtil.m12974a(OplusGLSurfaceView_13));
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected List<String> getFilterTypeList(int OplusGLSurfaceView_13) {
        return FilterHelper.f21318h.m22561a(CameraCharacteristicsUtil.m12974a(OplusGLSurfaceView_13));
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void onDeInitCameraMode(String str) {
        m12539a();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public Size getPictureSize(OplusCameraCharacteristics c2698h) {
        return Util.m24378b(c2698h.m13258a(256), 1.3333333333333333d);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        if (sharedPreferences == null) {
            return;
        }
        if (!Camera.f10611m && !Camera.f10610l) {
            if (this.mCameraUIInterface.mo18233k().m18494b() && CameraUIInterface.KEY_VIDEO_FLASH_MODE.equals(this.mCameraUIInterface.mo18233k().m18498d())) {
                if ("off".equals(sharedPreferences.getString(CameraUIInterface.KEY_VIDEO_FLASH_MODE, "off"))) {
                    this.mCameraUIInterface.mo18070a(R.string.hint_flash_off, -1, true, true, false);
                } else {
                    this.mCameraUIInterface.mo18070a(R.string.hint_flash_torch, -1, true, true, false);
                }
            }
            if (this.mActivity == null) {
                return;
            }
            if (CameraUIInterface.KEY_VIDEO_FLASH_MODE.equals(str)) {
                if ("off".equals(sharedPreferences.getString(CameraUIInterface.KEY_VIDEO_FLASH_MODE, this.mActivity.getString(R.string.camera_flash_mode_default_value)))) {
                    m12540b();
                } else {
                    m12539a();
                }
            }
        }
        if (CameraUIInterface.KEY_SUB_SETTING.equals(str) && "on".equals(sharedPreferences.getString(CameraUIInterface.KEY_SUB_SETTING, "off"))) {
            m12539a();
        }
        super.onSharedPreferenceChanged(sharedPreferences, str);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void displayScreenHintIconInSwitchOn() {
        if (!isFlashState() && this.f12936g) {
            this.f12936g = false;
        } else {
            super.displayScreenHintIconInSwitchOn();
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m12539a() {
        if (this.mCameraUIInterface == null || this.mActivity == null) {
            return;
        }
        this.mCameraUIInterface.mo18169b(this.mActivity.getResources().getString(R.string.camera_macro_best_focus_distance_text, Integer.valueOf(this.f12937h)));
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private void m12540b() {
        if (this.mCameraInterface == null || this.mCameraUIInterface.mo18059T() || this.mActivity == null || this.mOneCamera.mo13086e().m13284s()) {
            return;
        }
        this.mCameraUIInterface.mo18166b(R.string.camera_macro_best_focus_distance_text, R.drawable.screen_hint_textview_bg, R.color.screen_hint_text_color, Integer.valueOf(this.f12937h));
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void onAfterPictureTaken(byte[] bArr, boolean z) {
        CameraLog.m12959b("MacroMode", "onAfterPictureTaken");
        if (this.mCameraInterface == null || !this.mCameraInterface.mo10575i()) {
            return;
        }
        this.mCameraUIInterface.mo18200d(true, false);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean getSupportMenu(String str) {
        if (CameraUIInterface.KEY_VIDEO_FLASH_MODE.equals(str) || CameraUIInterface.KEY_CAMERA_TIMER_SHUTTER.equals(str) || CameraUIInterface.KEY_SETTING.equals(str)) {
            return true;
        }
        return super.getSupportMenu(str);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean getSupportSubMenu(String str) {
        if (CameraUIInterface.KEY_PHOTO_HIGH_RESOLUTION.equals(str)) {
            return false;
        }
        return super.getSupportSubMenu(str);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:29:0x005a  */
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
                case -1957553773: goto L50;
                case -1932966768: goto L46;
                case -1593450737: goto L3c;
                case -408507050: goto L32;
                case 336270991: goto L28;
                case 1599576324: goto L1e;
                case 1706373443: goto L14;
                case 1961723364: goto La;
                default: goto L9;
            }
        L9:
            goto L5a
        La:
            java.lang.String r0 = "pref_filter_process_key"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L5a
            r0 = r2
            goto L5b
        L14:
            java.lang.String r0 = "pref_support_capture_preview"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L5a
            r0 = 2
            goto L5b
        L1e:
            java.lang.String r0 = "pref_support_switch_camera"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L5a
            r0 = 5
            goto L5b
        L28:
            java.lang.String r0 = "pref_zoom_key"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L5a
            r0 = 4
            goto L5b
        L32:
            java.lang.String r0 = "pref_camera_videoflashmode_key"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L5a
            r0 = 3
            goto L5b
        L3c:
            java.lang.String r0 = "pref_watermark_function_key"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L5a
            r0 = 6
            goto L5b
        L46:
            java.lang.String r0 = "key_support_show_dim_hint"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L5a
            r0 = r1
            goto L5b
        L50:
            java.lang.String r0 = "pref_support_raw_post_process"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L5a
            r0 = 7
            goto L5b
        L5a:
            r0 = -1
        L5b:
            switch(r0) {
                case 0: goto L84;
                case 1: goto L84;
                case 2: goto L84;
                case 3: goto L7e;
                case 4: goto L7d;
                case 5: goto L7d;
                case 6: goto L70;
                case 7: goto L63;
                default: goto L5e;
            }
        L5e:
            boolean r3 = super.getSupportFunction(r4)
            return r3
        L63:
            java.lang.String r4 = r3.getCameraMode()
            int r3 = r3.mCameraId
            java.lang.String r0 = "aps_algo_raw2yuv"
            boolean r3 = com.oplus.camera.aps.util.AlgoSwitchConfig.getSupportCaptureAlgo(r4, r3, r0)
            return r3
        L70:
            java.lang.String r4 = r3.getCameraMode()
            int r3 = r3.mCameraId
            java.lang.String r0 = "aps_algo_watermark"
            boolean r3 = com.oplus.camera.aps.util.AlgoSwitchConfig.getSupportCaptureAlgo(r4, r3, r0)
            return r3
        L7d:
            return r1
        L7e:
            boolean r3 = com.oplus.camera.util.Util.m24328aQ()
            r3 = r3 ^ r2
            return r3
        L84:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.capmode.MacroMode.getSupportFunction(java.lang.String):boolean");
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onAfterStartPreview(boolean z) {
        super.onAfterStartPreview(z);
        this.f12937h = CameraConfig.getConfigIntValue(ConfigDataBase.KEY_MACRO_BEST_FOCUS_DISTANCE);
        this.f12936g = !isFlashState();
        m12540b();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void onShutterCallback(boolean z, boolean z2) {
        super.onShutterCallback(z, z2);
        if (z2) {
            this.mCameraInterface.mo10558c(0);
            this.mCameraInterface.mo10572h();
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onTimeSnapShotEnd(boolean z) {
        MainShutterButtonInfo shutterButtonInfo = getShutterButtonInfo();
        shutterButtonInfo.m19230b(0);
        this.mCameraUIInterface.mo18091a(shutterButtonInfo);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean needSurface(String str) {
        if ("type_capture".equals(str)) {
            return true;
        }
        return super.needSurface(str);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onMoreModeHidden(int OplusGLSurfaceView_13) {
        super.onMoreModeHidden(OplusGLSurfaceView_13);
        if (1 != OplusGLSurfaceView_13) {
            m12540b();
        }
    }
}

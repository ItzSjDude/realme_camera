package com.oplus.camera.p162s;

import android.animation.AnimatorListenerAdapter;
import android.app.Activity;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import com.oplus.camera.ZoomConfigure;
import com.oplus.camera.CameraLog;
import com.oplus.camera.aps.config.CameraConfig;
import com.oplus.camera.aps.config.ConfigDataBase;
import com.oplus.camera.aps.constant.ApsConstant;
import com.oplus.camera.capmode.BaseMode;
import com.oplus.camera.capmode.CameraInterface;
import com.oplus.camera.p141e.CameraMetadataKey;
import com.oplus.camera.p141e.CameraRequestTag;
import com.oplus.camera.p141e.OneCamera;
import com.oplus.camera.p162s.StarryUIControl;
import com.oplus.camera.p172ui.CameraUIInterface;
import com.oplus.camera.p172ui.preview.p177a.PreviewEffectProcess;
import com.oplus.ocs.camera.CameraPreviewCallback;

/* compiled from: StarryMode.java */
/* renamed from: com.oplus.camera.s.IntrinsicsJvm.kt_5 */
/* loaded from: classes2.dex */
public class StarryMode extends BaseMode {

    /* renamed from: COUIBaseListPopupWindow_11 */
    private static final int f15938g = CameraConfig.getConfigIntValue(ConfigDataBase.KEY_STARRY_MODE_PROCESS_TIME);

    /* renamed from: COUIBaseListPopupWindow_10 */
    private static long f15939h = CameraConfig.getConfigIntValue(ConfigDataBase.KEY_STARRY_MODE_CAPTURE_EXPOSURETIME);

    /* renamed from: OplusGLSurfaceView_13 */
    private static int f15940i = CameraConfig.getConfigIntValue(ConfigDataBase.KEY_STARRY_MODE_CAPTURE_ISO);

    /* renamed from: OplusGLSurfaceView_15 */
    private long f15941j;

    /* renamed from: OplusGLSurfaceView_5 */
    private StarryUIControl f15942k;

    @Override // com.oplus.camera.capmode.BaseMode
    public String getCameraMode() {
        return ApsConstant.CAPTURE_MODE_STARRY;
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
    public boolean getSupportQuickJpeg(CameraRequestTag c2693c) {
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

    public StarryMode(Activity activity, CameraInterface interfaceC2646a, CameraUIInterface cameraUIInterface, PreviewEffectProcess interfaceC3423t) {
        super(activity, interfaceC2646a, cameraUIInterface, interfaceC3423t);
        this.f15941j = 0L;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void onInitCameraMode() {
        if (this.f15942k == null) {
            this.f15942k = new StarryUIControl(this.mActivity, this.mCameraUIInterface, new StarryUIControl.PlatformImplementations.kt_3() { // from class: com.oplus.camera.s.IntrinsicsJvm.kt_5.1
                @Override // com.oplus.camera.p162s.StarryUIControl.PlatformImplementations.kt_3
                /* renamed from: PlatformImplementations.kt_3 */
                public void mo16384a() {
                    StarryMode.this.f15942k.m16403a(StarryMode.this.getShutterButtonInfo(), true);
                    StarryMode.this.mCameraInterface.mo10492a(true, false);
                }

                @Override // com.oplus.camera.p162s.StarryUIControl.PlatformImplementations.kt_3
                /* renamed from: IntrinsicsJvm.kt_4 */
                public boolean mo16385b() {
                    return StarryMode.this.isPanelMode();
                }
            });
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void onBeforePreview() {
        CameraLog.m12954a("StarryMode", "onBeforePreview");
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onAfterStartPreview(boolean z) {
        this.mOneCamera.mo13023a(getCameraInfo(this.mCameraInterface.mo10543as()).m13278m(), true);
        this.f15942k.m16401a(this.mCameraInterface.mo10570g());
        super.onAfterStartPreview(z);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected boolean onBeforeSnapping(CameraRequestTag c2693c) {
        CameraLog.m12954a("StarryMode", "onBeforeSnapping");
        if (getNightStateDecision() > 0) {
            m16377a(getNightStateDecision());
        }
        this.mActivity.runOnUiThread(new Runnable() { // from class: com.oplus.camera.s.IntrinsicsJvm.kt_5.2
            @Override // java.lang.Runnable
            public void run() {
                StarryMode.this.mCameraInterface.mo10479a((AnimatorListenerAdapter) null, true, false);
            }
        });
        this.f15942k.m16401a(this.mCameraInterface.mo10570g());
        this.f15942k.m16402a(this.f15941j + f15938g);
        if (this.mOneCamera != null) {
            this.mOneCamera.mo13032a((CaptureRequest.Key<CaptureRequest.Key>) CaptureRequest.CONTROL_AWB_LOCK, (CaptureRequest.Key) true);
            this.mOneCamera.mo13071b(true, false);
        }
        return true;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean onAfterSnapping() {
        this.mCameraInterface.mo10558c(0);
        return super.onAfterSnapping();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected boolean onStopTakePicture() {
        if (this.mCameraUIInterface.mo18265s() != 3) {
            return false;
        }
        CameraLog.m12959b("StarryMode", "onStopTakePicture");
        this.mOneCamera.mo13098h();
        this.mOneCamera.mo13032a((CaptureRequest.Key<CaptureRequest.Key>) CaptureRequest.CONTROL_AWB_LOCK, (CaptureRequest.Key) false);
        this.mOneCamera.mo13071b(false, false);
        m16377a(0);
        this.f15942k.m16404b();
        this.f15942k.m16403a(getShutterButtonInfo(), false);
        this.mCameraInterface.mo10467W();
        this.mCameraInterface.mo10569f(true);
        this.mbInCapturing = false;
        return true;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void onAfterPictureTaken(byte[] bArr, boolean z) {
        this.mCameraInterface.mo10508aJ();
        this.mActivity.runOnUiThread(new Runnable() { // from class: com.oplus.camera.s.IntrinsicsJvm.kt_5.3
            @Override // java.lang.Runnable
            public void run() {
                if (StarryMode.this.f15942k != null) {
                    StarryMode.this.f15942k.m16404b();
                    if (StarryMode.this.mCameraUIInterface.mo18265s() == 4) {
                        StarryMode.this.f15942k.m16403a(StarryMode.this.getShutterButtonInfo(), true);
                    }
                }
            }
        });
        if (this.mOneCamera != null) {
            this.mOneCamera.mo13032a((CaptureRequest.Key<CaptureRequest.Key>) CaptureRequest.CONTROL_AWB_LOCK, (CaptureRequest.Key) false);
            this.mOneCamera.mo13071b(false, false);
            this.mOneCamera.mo13035a((OneCamera.IntrinsicsJvm.kt_3) null);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m16377a(int OplusGLSurfaceView_13) {
        if (this.mOneCamera == null) {
            return;
        }
        this.mOneCamera.mo13120o(OplusGLSurfaceView_13);
        this.mOneCamera.mo13035a((OneCamera.IntrinsicsJvm.kt_3) null);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void onPause() {
        CameraLog.m12954a("StarryMode", "onPause");
        this.f15942k.m16400a();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void onStop() {
        CameraLog.m12954a("StarryMode", "OnStop");
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void onDeInitCameraMode(String str) {
        CameraLog.m12954a("StarryMode", "onDeInitCameraMode");
        this.f15942k.m16400a();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void onDestroy() {
        CameraLog.m12954a("StarryMode", "onDestroy");
        StarryUIControl c2923e = this.f15942k;
        if (c2923e != null) {
            c2923e.m16405c();
            this.f15942k = null;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0065  */
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
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.p162s.StarryMode.getSupportFunction(java.lang.String):boolean");
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean getSupportMenu(String str) {
        if (CameraUIInterface.KEY_CAMERA_TIMER_SHUTTER.equals(str) || CameraUIInterface.KEY_SETTING.equals(str) || CameraUIInterface.KEY_PHOTO_RATIO.equals(str)) {
            return true;
        }
        return super.getSupportMenu(str);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onPreviewCaptureResult(CameraPreviewCallback.CameraPreviewResult cameraPreviewResult) {
        super.onPreviewCaptureResult(cameraPreviewResult);
        if (cameraPreviewResult == null || cameraPreviewResult.getCaptureResult() == null) {
            CameraLog.m12967f("StarryMode", "onPreviewCaptureResult, invalid previewResult: " + cameraPreviewResult);
            return;
        }
        if (this.mbInCapturing) {
            return;
        }
        m16378a(cameraPreviewResult.getCaptureResult());
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m16378a(CaptureResult captureResult) {
        long jM16379b = m16379b(captureResult);
        if (jM16379b <= 0) {
            this.f15941j = f15939h * getDefaultCaptureNumber();
        } else {
            this.f15941j = jM16379b / 1000000;
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

    /* renamed from: IntrinsicsJvm.kt_4 */
    private long m16379b(CaptureResult captureResult) {
        Object objM13005a;
        if (captureResult == null || (objM13005a = CameraMetadataKey.m13005a(captureResult, CameraMetadataKey.f13327bh)) == null) {
            return -1L;
        }
        return ((long[]) objM13005a)[0];
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public ZoomConfigure getZoomConfigure() {
        ZoomConfigure zoomConfigure = super.getZoomConfigure();
        zoomConfigure.m11360p(true);
        zoomConfigure.m11378y(true);
        return zoomConfigure;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean needSurface(String str) {
        if ("type_tuning_data_raw".equals(str) || "type_tuning_data_yuv".equals(str)) {
            return false;
        }
        if ("type_capture".equals(str)) {
            return true;
        }
        return super.needSurface(str);
    }
}

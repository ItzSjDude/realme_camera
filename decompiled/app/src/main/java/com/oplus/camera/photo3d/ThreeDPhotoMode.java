package com.oplus.camera.photo3d;

import android.app.Activity;
import android.content.res.Resources;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CaptureRequest;
import android.provider.Settings;
import android.util.Size;
import android.view.MotionEvent;
import com.oplus.camera.ZoomConfigure;
import com.oplus.camera.CameraLog;
import com.oplus.camera.R;
import com.oplus.camera.aps.config.CameraConfig;
import com.oplus.camera.aps.config.ConfigDataBase;
import com.oplus.camera.aps.constant.ApsConstant;
import com.oplus.camera.aps.service.CameraCaptureResult;
import com.oplus.camera.capmode.BaseMode;
import com.oplus.camera.capmode.CameraInterface;
import com.oplus.camera.p141e.CameraRequestTag;
import com.oplus.camera.p141e.OplusCameraCharacteristics;
import com.oplus.camera.p172ui.CameraUIInterface;
import com.oplus.camera.p172ui.preview.p177a.PreviewEffectProcess;
import com.oplus.camera.photo3d.p159ui.ThreeDPhotoUIControl;
import com.oplus.ocs.camera.CameraPictureCallback;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: ThreeDPhotoMode.java */
/* renamed from: com.oplus.camera.photo3d.IntrinsicsJvm.kt_3 */
/* loaded from: classes2.dex */
public class ThreeDPhotoMode extends BaseMode {

    /* renamed from: COUIBaseListPopupWindow_11 */
    private static final String[] f15207g = {CameraUIInterface.KEY_3DPHOTO_FACEBEAUTY_LEVEL_MENU};

    /* renamed from: COUIBaseListPopupWindow_10 */
    private ThreeDPhotoManager f15208h;

    /* renamed from: OplusGLSurfaceView_13 */
    private ThreeDPhotoUIControl f15209i;

    /* renamed from: OplusGLSurfaceView_15 */
    private AtomicLong f15210j;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private boolean m15229b() {
        return true;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean allowSwitchCamera() {
        return false;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public String getCameraMode() {
        return ApsConstant.CAPTURE_MODE_3D_PHOTO;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected String getFaceBeautyKey() {
        return CameraUIInterface.KEY_3DPHOTO_FACEBEAUTY_LEVEL_MENU;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public String getFilterEffectMenuPreferenceKey() {
        return CameraUIInterface.KEY_3D_PHOTO_FILTER_INDEX;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean getFrontEnable() {
        return false;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public String getHeicCodecFormat() {
        return null;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public int getOperatingMode() {
        return 32769;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean getSupportQuickJpeg(CameraRequestTag c2693c) {
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

    public ThreeDPhotoMode(Activity activity, CameraInterface interfaceC2646a, CameraUIInterface cameraUIInterface, PreviewEffectProcess interfaceC3423t) {
        super(activity, interfaceC2646a, cameraUIInterface, interfaceC3423t);
        this.f15208h = null;
        this.f15210j = new AtomicLong(0L);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void onInitCameraMode() {
        this.f15208h = new ThreeDPhotoManager(this.mActivity, this.mCameraInterface, this.mCameraUIInterface);
        this.f15209i = new ThreeDPhotoUIControl(this.mActivity, this.mCameraInterface, this.mCameraUIInterface);
        this.f15209i.m15329a(this.f15208h);
        this.f15208h.m15222a(new RecordingListener() { // from class: com.oplus.camera.photo3d.IntrinsicsJvm.kt_3.1
            @Override // com.oplus.camera.photo3d.RecordingListener
            /* renamed from: PlatformImplementations.kt_3 */
            public void mo15190a(long OplusGLSurfaceView_15) {
                if (OplusGLSurfaceView_15 == ThreeDPhotoMode.this.f15210j.get()) {
                    ThreeDPhotoMode.this.f15209i.m15335c();
                    ThreeDPhotoMode c2865c = ThreeDPhotoMode.this;
                    c2865c.onPictureCallback(null, 0, 0, c2865c.getImageFormat(), false, 0);
                    ThreeDPhotoMode.this.f15210j.set(0L);
                    CameraLog.m12959b("ThreeDPhoto", "onRecordingStop, identity: " + OplusGLSurfaceView_15);
                }
            }
        });
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void onBeforePreview() {
        applyBeautyParam();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onAfterStartPreview(boolean z) {
        super.onAfterStartPreview(z);
        this.f15209i.m15332b();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public Size getPictureSize(OplusCameraCharacteristics c2698h) {
        return CameraConfig.getSizeConfigValue(ConfigDataBase.KEY_3D_PHOTO_VIDEO_SIZE);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00ae  */
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
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.photo3d.ThreeDPhotoMode.getSupportFunction(java.lang.String):boolean");
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean getSupportMenu(String str) {
        if (CameraUIInterface.KEY_SETTING.equals(str) || CameraUIInterface.KEY_FLASH_MODE.equals(str) || CameraUIInterface.KEY_CAMERA_TIMER_SHUTTER.equals(str)) {
            return true;
        }
        return super.getSupportMenu(str);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public ZoomConfigure getZoomConfigure() {
        ZoomConfigure zoomConfigure = super.getZoomConfigure();
        zoomConfigure.m11338e(true);
        return zoomConfigure;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected String[] getCustomBeautyKeys() {
        return f15207g;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean needSurface(String str) {
        return "type_capture".equals(str) || "type_still_capture_yuv_main".equals(str);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onEffectMenuPopUp() {
        super.onEffectMenuPopUp();
        this.f15209i.m15336c(true, true);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onEffectMenuPopDown(boolean z) {
        super.onEffectMenuPopDown(z);
        this.f15209i.m15334b(true, true);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected boolean onBeforeSnapping(CameraRequestTag c2693c) {
        if (m15227a()) {
            this.mCameraUIInterface.mo18070a(R.string.camera_high_temperature_3d_photo_disable, -1, true, false, false);
            CameraLog.m12967f("ThreeDPhoto", "onBeforeSnapping, Can't capture for high temperature");
            return false;
        }
        this.f15209i.m15333b(this.f15208h.m15225c());
        return true;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private boolean m15227a() {
        return 1 == Settings.System.getInt(this.mActivity.getContentResolver(), "oplus.camera.video", 0);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void onShutterCallback(boolean z, boolean z2) {
        super.onShutterCallback(z, z2);
        if (z || !z2) {
            return;
        }
        this.mCameraInterface.mo10572h();
        this.mCameraInterface.mo10558c(0);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void updateCaptureParam(CameraRequestTag c2693c) throws Resources.NotFoundException {
        super.updateCaptureParam(c2693c);
        this.mOneCamera.mo13089e(m15229b());
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void onAfterPictureTaken(byte[] bArr, boolean z) {
        CameraLog.m12954a("ThreeDPhoto", "onAfterPictureTaken");
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean consumeImage(CameraPictureCallback.CameraPictureImage cameraPictureImage) {
        return m15229b();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean needStoreImage() {
        return !m15229b();
    }

    @Override // com.oplus.camera.capmode.BaseMode, com.oplus.camera.p141e.OneCamera.PlatformImplementations.kt_3
    public void onCaptureStarted(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, long OplusGLSurfaceView_15, long j2) {
        if (this.mCaptureStartedCallbackNum == 0) {
            this.f15210j.set(OplusGLSurfaceView_15);
        }
        super.onCaptureStarted(cameraCaptureSession, captureRequest, OplusGLSurfaceView_15, j2);
    }

    @Override // com.oplus.camera.capmode.BaseMode, com.oplus.camera.p141e.OneCamera.PlatformImplementations.kt_3
    public void onCaptureCompleted(CameraCaptureResult cameraCaptureResult, CameraRequestTag c2693c) {
        super.onCaptureCompleted(cameraCaptureResult, c2693c);
        if (0 == cameraCaptureResult.mMeshPtr) {
            CameraLog.m12967f("ThreeDPhoto", "onCaptureCompleted, return for null mesh pointer");
            return;
        }
        if (cameraCaptureResult.mIdentity != this.f15210j.get()) {
            PhotoMeshData.release(cameraCaptureResult.mMeshPtr);
            CameraLog.m12959b("ThreeDPhoto", "onCaptureCompleted, skip process capture: " + cameraCaptureResult.mIdentity);
            return;
        }
        ThreeDPhotoManager c2864b = this.f15208h;
        if (c2864b != null) {
            c2864b.m15220a(cameraCaptureResult.mMeshPtr, cameraCaptureResult.mIdentity);
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode, com.oplus.camera.p141e.OneCamera.PlatformImplementations.kt_3
    public void onCaptureFirstFrameArrived(CaptureRequest captureRequest, CameraCaptureResult cameraCaptureResult) {
        super.onCaptureFirstFrameArrived(captureRequest, cameraCaptureResult);
        this.mCameraUIInterface.mo18070a(R.string.camera_3d_photo_process_hint, -1, false, false, true);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        ThreeDPhotoUIControl c2876g = this.f15209i;
        if (c2876g != null) {
            return c2876g.m15331a(motionEvent);
        }
        return super.onSingleTapUp(motionEvent);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onZoomMenuExpand() {
        super.onZoomMenuExpand();
        ThreeDPhotoUIControl c2876g = this.f15209i;
        if (c2876g != null) {
            c2876g.m15336c(true, true);
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onZoomMenuCollapsing() {
        super.onZoomMenuCollapsing();
        if (this.f15209i == null || getIsCapturingState()) {
            return;
        }
        this.f15209i.m15334b(true, true);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected boolean isHideUICapture() {
        return getIsCapturingState();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean isBottomGuideEntryViewShown() {
        ThreeDPhotoUIControl c2876g = this.f15209i;
        return c2876g != null && c2876g.m15339f();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void setOrientation(int OplusGLSurfaceView_13) {
        super.setOrientation(OplusGLSurfaceView_13);
        ThreeDPhotoUIControl c2876g = this.f15209i;
        if (c2876g != null) {
            c2876g.m15328a(OplusGLSurfaceView_13);
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void changeModeAllViewWhenAnimation(int OplusGLSurfaceView_13, boolean z) {
        ThreeDPhotoUIControl c2876g;
        super.changeModeAllViewWhenAnimation(OplusGLSurfaceView_13, z);
        if (3 != OplusGLSurfaceView_13 || (c2876g = this.f15209i) == null) {
            return;
        }
        c2876g.m15330a(z, getIsCapturingState());
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void onPause() {
        CameraLog.m12954a("ThreeDPhoto", "onPause");
        this.f15209i.m15340g();
        m15230c();
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private void m15230c() {
        if (this.f15210j.get() != 0) {
            CameraLog.m12959b("ThreeDPhoto", "cancelCapture: " + this.f15210j.get());
            this.f15210j.set(0L);
            this.f15208h.m15219a();
            this.f15209i.m15335c();
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void onStop() {
        CameraLog.m12954a("ThreeDPhoto", "onStop");
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void onDestroy() {
        CameraLog.m12954a("ThreeDPhoto", "onDestroy");
        ThreeDPhotoManager c2864b = this.f15208h;
        if (c2864b != null) {
            c2864b.m15224b();
            this.f15208h = null;
        }
        ThreeDPhotoUIControl c2876g = this.f15209i;
        if (c2876g != null) {
            c2876g.m15341h();
            this.f15209i = null;
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void onDeInitCameraMode(String str) {
        CameraLog.m12954a("ThreeDPhoto", "onDeInitCameraMode");
        if (this.mPreviewEffectProcess != null) {
            this.mPreviewEffectProcess.mo22834g(0);
        }
        ThreeDPhotoManager c2864b = this.f15208h;
        if (c2864b != null) {
            c2864b.m15224b();
            this.f15208h = null;
        }
        ThreeDPhotoUIControl c2876g = this.f15209i;
        if (c2876g != null) {
            c2876g.m15341h();
            this.f15209i = null;
        }
    }
}

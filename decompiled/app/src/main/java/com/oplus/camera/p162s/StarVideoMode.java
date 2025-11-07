package com.oplus.camera.p162s;

import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.res.Resources;
import android.hardware.camera2.CaptureRequest;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.os.SystemClock;
import android.provider.Settings;
import android.util.Size;
import android.view.Window;
import android.view.WindowManager;
import com.oplus.camera.ZoomConfigure;
import com.oplus.camera.CameraLog;
import com.oplus.camera.Camera;
import com.oplus.camera.R;
import com.oplus.camera.aps.config.CameraConfig;
import com.oplus.camera.aps.config.ConfigDataBase;
import com.oplus.camera.aps.constant.ApsConstant;
import com.oplus.camera.aps.service.CameraCaptureResult;
import com.oplus.camera.aps.util.CameraApsDecision;
import com.oplus.camera.capmode.BaseMode;
import com.oplus.camera.capmode.CameraInterface;
import com.oplus.camera.p141e.CameraMetadataKey;
import com.oplus.camera.p141e.CameraRequestTag;
import com.oplus.camera.p141e.OplusCameraCharacteristics;
import com.oplus.camera.p141e.OneCamera;
import com.oplus.camera.p162s.StarVideoHelper;
import com.oplus.camera.p172ui.CameraUIInterface;
import com.oplus.camera.p172ui.preview.p177a.PreviewEffectProcess;
import com.oplus.camera.statistics.CameraStatisticsUtil;
import com.oplus.ocs.camera.CameraPictureCallback;

/* compiled from: StarVideoMode.java */
/* renamed from: com.oplus.camera.s.IntrinsicsJvm.kt_4 */
/* loaded from: classes2.dex */
public class StarVideoMode extends BaseMode implements StarVideoHelper.PlatformImplementations.kt_3 {

    /* renamed from: COUIBaseListPopupWindow_11 */
    private HandlerThread f15908g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private Handler f15909h;

    /* renamed from: OplusGLSurfaceView_13 */
    private StarVideoUI f15910i;

    /* renamed from: OplusGLSurfaceView_15 */
    private StarVideoHelper f15911j;

    /* renamed from: OplusGLSurfaceView_5 */
    private int f15912k;

    /* renamed from: OplusGLSurfaceView_14 */
    private int f15913l;

    /* renamed from: OplusGLSurfaceView_6 */
    private int f15914m;

    /* renamed from: OplusGLSurfaceView_11 */
    private int f15915n;

    /* renamed from: o */
    private int f15916o;

    /* renamed from: p */
    private long f15917p;

    /* renamed from: q */
    private boolean f15918q;

    /* renamed from: r */
    private boolean f15919r;

    /* renamed from: s */
    private CameraRequestTag f15920s;

    /* renamed from: t */
    private CameraApsDecision f15921t;

    /* renamed from: u */
    private OneCamera.PlatformImplementations.kt_3 f15922u;

    /* renamed from: v */
    private ValueAnimator f15923v;

    /* renamed from: w */
    private PlatformImplementations.kt_3 f15924w;

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean consumeBackEventOnPictureTaken() {
        return true;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public String getCameraMode() {
        return ApsConstant.REC_MODE_STAR_VIDEO;
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
    public boolean getSupportQuickJpeg(CameraRequestTag c2693c) {
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
    protected void onAfterPictureTaken(byte[] bArr, boolean z) {
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onPictureCallback(byte[] bArr, int OplusGLSurfaceView_13, int i2, int i3, boolean z, int i4) {
    }

    public StarVideoMode(Activity activity, CameraInterface interfaceC2646a, CameraUIInterface cameraUIInterface, PreviewEffectProcess interfaceC3423t) {
        super(activity, interfaceC2646a, cameraUIInterface, interfaceC3423t);
        this.f15908g = null;
        this.f15909h = null;
        this.f15910i = null;
        this.f15911j = null;
        this.f15912k = 0;
        this.f15913l = 0;
        this.f15914m = 0;
        this.f15915n = 3;
        this.f15916o = 0;
        this.f15917p = 0L;
        this.f15918q = false;
        this.f15919r = true;
        this.f15920s = null;
        this.f15921t = null;
        this.f15922u = null;
        this.f15923v = null;
        this.f15924w = null;
        this.f15911j = new StarVideoHelper(this.mActivity.getApplicationContext(), this.mCameraInterface, this.mCameraUIInterface, this.mbDisplayOnLock);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void onInitCameraMode() {
        CameraLog.m12962c("StarVideoMode", "onInitCameraMode");
        this.f15910i = new StarVideoUI(this.mActivity, this.mPreferences, this.mCameraUIInterface);
        this.f15908g = new HandlerThread("StarVideoHandler");
        this.f15908g.start();
        this.f15909h = new Handler(this.f15908g.getLooper()) { // from class: com.oplus.camera.s.IntrinsicsJvm.kt_4.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                int OplusGLSurfaceView_13 = message.what;
                if (OplusGLSurfaceView_13 == 1) {
                    StarVideoMode.this.m16338c();
                    return;
                }
                if (OplusGLSurfaceView_13 == 2) {
                    StarVideoMode c2920b = StarVideoMode.this;
                    c2920b.m16333a(c2920b.mActivity);
                } else if (OplusGLSurfaceView_13 == 3) {
                    StarVideoMode.this.m16351m();
                } else if (OplusGLSurfaceView_13 == 4) {
                    StarVideoMode.this.m16352n();
                } else {
                    if (OplusGLSurfaceView_13 != 5) {
                        return;
                    }
                    StarVideoMode.this.m16350l();
                }
            }
        };
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected boolean onStopTakePicture() {
        if (3 == this.f15915n) {
            return false;
        }
        m16348j();
        return true;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void onBeforePreview() {
        this.f15911j.m16324a(this.mCameraId);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onAfterStartPreview(boolean z) throws Resources.NotFoundException {
        this.mOneCamera.mo13023a(getCameraInfo(this.mCameraInterface.mo10543as()).m13278m(), true);
        this.f15910i.m16367a();
        super.onAfterStartPreview(z);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void setLowBatteryState(boolean z) {
        if (this.mbPaused || !Camera.f10610l || m16344f()) {
            return;
        }
        m16346h();
        m16348j();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void setOrientation(int OplusGLSurfaceView_13) {
        super.setOrientation(OplusGLSurfaceView_13);
        StarVideoUI c2921c = this.f15910i;
        if (c2921c != null) {
            c2921c.m16368a(OplusGLSurfaceView_13);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private int m16331a() {
        return super.getDefaultCaptureNumber();
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private boolean m16337b() {
        return this.f15913l > m16331a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m16338c() {
        CameraLog.m12962c("StarVideoMode", "handleBurstCaptureMessage, mNightScene: " + this.f15916o);
        int OplusGLSurfaceView_13 = this.f15916o;
        if (OplusGLSurfaceView_13 > 0) {
            m16332a(OplusGLSurfaceView_13);
        }
        CameraRequestTag c2693c = this.f15920s;
        if (c2693c != null) {
            burstCapture(this.f15912k, c2693c, this.f15922u);
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void burstCapture(int OplusGLSurfaceView_13, CameraRequestTag c2693c, OneCamera.PlatformImplementations.kt_3 aVar) {
        if (this.f15913l == 0) {
            synchronized (this.mApsDecisionResultLock) {
                this.f15921t = this.mDecisionResult;
            }
            this.f15914m = 0;
        }
        this.f15918q = m16342e() <= 17000;
        c2693c.f13404af = this.f15918q ? -1 : this.f15913l + 1;
        c2693c.f13403ae = true;
        super.burstCapture(OplusGLSurfaceView_13, c2693c, aVar);
        this.f15912k = OplusGLSurfaceView_13;
        this.f15920s = super.getCaptureRequestTag(this.f15921t, false);
        this.f15922u = aVar;
        this.mCaptureStartedCallbackNum = 0;
        CameraLog.m12962c("StarVideoMode", "burstCapture, mReceivedImageNum: " + this.f15913l + ", mbLastCaptureRequest: " + this.f15918q);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected boolean onBeforeSnapping(CameraRequestTag c2693c) {
        this.f15916o = getNightStateDecision();
        int OplusGLSurfaceView_13 = this.f15916o;
        if (OplusGLSurfaceView_13 > 0) {
            m16332a(OplusGLSurfaceView_13);
        }
        return m16347i();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void updateCaptureParam(CameraRequestTag c2693c) throws Resources.NotFoundException {
        super.updateCaptureParam(c2693c);
        this.mOneCamera.mo13089e(true);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean onAfterSnapping() {
        this.mCameraInterface.mo10558c(4);
        return super.onAfterSnapping();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void onPause() {
        CameraLog.m12954a("StarVideoMode", "onPause");
        this.f15910i.m16375c(false);
        this.f15909h.removeMessages(1);
        this.f15909h.removeMessages(3);
        this.f15909h.removeMessages(5);
        this.f15909h.removeMessages(2);
        m16348j();
        if (this.mCameraInterface != null) {
            this.mCameraInterface.mo10465U();
            this.mCameraUIInterface.mo18067a(R.string.camera_scene_star_video_mode_fixed_tips);
        }
        this.f15922u = null;
        this.f15921t = null;
        this.f15920s = null;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void onStop() {
        CameraLog.m12954a("StarVideoMode", "OnStop");
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean onBackPressed() {
        CameraLog.m12962c("StarVideoMode", "onBackPressed, mRecordingStatus: " + this.f15915n);
        if (3 != this.f15915n) {
            m16348j();
            return true;
        }
        return super.onBackPressed();
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    private void m16341d() {
        StarVideoHelper c2919a = this.f15911j;
        if (c2919a != null) {
            c2919a.m16325a((StarVideoHelper.PlatformImplementations.kt_3) null);
        }
        ValueAnimator valueAnimator = this.f15923v;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.f15923v.removeAllUpdateListeners();
            this.f15923v = null;
            this.f15924w = null;
        }
        HandlerThread handlerThread = this.f15908g;
        if (handlerThread != null) {
            handlerThread.quitSafely();
            this.f15908g = null;
            this.f15909h = null;
        }
        StarVideoUI c2921c = this.f15910i;
        if (c2921c != null) {
            c2921c.m16374c();
            this.f15910i = null;
        }
        this.f15920s = null;
        this.f15921t = null;
        this.f15922u = null;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void onDeInitCameraMode(String str) {
        CameraLog.m12954a("StarVideoMode", "onDeInitCameraMode");
        if (this.mCameraUIInterface != null) {
            this.mCameraUIInterface.mo18067a(R.string.camera_scene_star_video_mode_fixed_tips);
        }
        StarVideoUI c2921c = this.f15910i;
        if (c2921c != null) {
            c2921c.m16375c(false);
        }
        m16341d();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void onDestroy() {
        CameraLog.m12954a("StarVideoMode", "onDestroy");
        m16341d();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0071  */
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
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.p162s.StarVideoMode.getSupportFunction(java.lang.String):boolean");
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean getSupportMenu(String str) {
        if (CameraUIInterface.KEY_CAMERA_TIMER_SHUTTER.equals(str) || CameraUIInterface.KEY_SETTING.equals(str)) {
            return true;
        }
        return super.getSupportMenu(str);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public ZoomConfigure getZoomConfigure() {
        ZoomConfigure zoomConfigure = super.getZoomConfigure();
        zoomConfigure.m11360p(true);
        zoomConfigure.m11378y(true);
        return zoomConfigure;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public Size getPictureSize(OplusCameraCharacteristics c2698h) {
        StarVideoHelper c2919a = this.f15911j;
        if (c2919a != null) {
            return c2919a.m16328b();
        }
        return super.getPictureSize(c2698h);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected boolean interruptCaptureFailedEvent() {
        CameraLog.m12967f("StarVideoMode", "interruptCaptureFailedEvent, mFailedCount: " + this.f15914m);
        if (20 < this.f15914m) {
            m16348j();
            return false;
        }
        if (m16344f()) {
            return false;
        }
        this.f15914m++;
        m16345g();
        return true;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean onImageReceived(CameraPictureCallback.CameraPictureImage cameraPictureImage) {
        if (cameraPictureImage == null) {
            CameraLog.m12967f("StarVideoMode", "onImageReceived, image is null");
            return false;
        }
        this.f15913l++;
        CameraLog.m12962c("StarVideoMode", "onImageReceived, mReceivedImageNum: " + this.f15913l + ", mbShouldEncode: " + this.f15919r);
        if (m16337b() && this.f15919r) {
            this.f15911j.m16326a(cameraPictureImage);
        }
        m16345g();
        return true;
    }

    @Override // com.oplus.camera.capmode.BaseMode, com.oplus.camera.p141e.OneCamera.PlatformImplementations.kt_3
    public void onCaptureCompleted(CameraCaptureResult cameraCaptureResult, CameraRequestTag c2693c) {
        CameraLog.m12962c("StarVideoMode", "onCaptureCompleted, requestTag.mFrameFlag: " + c2693c.f13404af);
        if (this.mOneCamera != null) {
            this.mOneCamera.mo13091f(c2693c.f13404af);
        }
        if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_STAR_VIDEO_NEED_VERIFY_FRAME)) {
            try {
                Integer num = (Integer) cameraCaptureResult.getCaptureResult().get(CameraMetadataKey.f13319bE);
                boolean z = true;
                if (num.intValue() != c2693c.f13404af - 1) {
                    z = false;
                }
                this.f15919r = z;
                CameraLog.m12954a("StarVideoMode", "onCaptureCompleted, resultFrame: " + num + ", requestFrame: " + c2693c.f13404af);
            } catch (Exception unused) {
                CameraLog.m12967f("StarVideoMode", "onCaptureCompleted, do not have CameraMetadataKey.KEY_STAR_MODE_FRAME_FLAG");
            }
        }
        super.onCaptureCompleted(cameraCaptureResult, c2693c);
    }

    @Override // com.oplus.camera.capmode.BaseMode, com.oplus.camera.p141e.OneCamera.PlatformImplementations.kt_3
    public void onCaptureFailed(CaptureRequest captureRequest, CameraRequestTag c2693c) {
        CameraLog.m12967f("StarVideoMode", "onCaptureFailed, mFailedCount: " + this.f15914m);
        if (20 < this.f15914m) {
            m16348j();
            super.onCaptureFailed(captureRequest, c2693c);
        } else {
            if (m16344f()) {
                return;
            }
            this.f15914m++;
            m16345g();
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m16332a(int OplusGLSurfaceView_13) {
        if (this.mOneCamera == null) {
            return;
        }
        CameraLog.m12962c("StarVideoMode", "setNightMode, nightMode: " + OplusGLSurfaceView_13);
        this.mOneCamera.mo13120o(OplusGLSurfaceView_13);
        this.mOneCamera.mo13035a((OneCamera.IntrinsicsJvm.kt_3) null);
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    private long m16342e() {
        return this.mPreferences.getInt(CameraUIInterface.KEY_STAR_VIDEO_RECORD_TOTAL_TIME, 5400000) - (SystemClock.uptimeMillis() - this.f15917p);
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    private boolean m16344f() {
        int OplusGLSurfaceView_13 = this.f15915n;
        return 4 == OplusGLSurfaceView_13 || 3 == OplusGLSurfaceView_13;
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    private void m16345g() {
        Handler handler;
        CameraLog.m12962c("StarVideoMode", "trySendRepeatBurstCaptureMessage, mbLastCaptureRequest: " + this.f15918q);
        if (!this.mbPaused && !m16344f() && !this.f15918q && (handler = this.f15909h) != null) {
            handler.sendEmptyMessage(1);
        } else {
            m16348j();
        }
    }

    /* renamed from: COUIBaseListPopupWindow_10 */
    private void m16346h() {
        CameraLog.m12962c("StarVideoMode", "showLowBatteryHint");
        if (this.mbPaused || this.mActivity == null) {
            return;
        }
        this.mActivity.runOnUiThread(new Runnable() { // from class: com.oplus.camera.s.-$$Lambda$IntrinsicsJvm.kt_4$Xh3agHb2Sjf4kafQpkcof-fEllA
            @Override // java.lang.Runnable
            public final void run() {
                this.COUIBaseListPopupWindow_12$0.m16359u();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: u */
    public /* synthetic */ void m16359u() {
        if (this.mCameraUIInterface != null) {
            this.mCameraUIInterface.mo18070a(R.string.camera_star_video_low_battery_rec_disabled, -1, true, false, false);
        }
    }

    /* renamed from: OplusGLSurfaceView_13 */
    private boolean m16347i() {
        CameraLog.m12962c("StarVideoMode", "startRecording, mRecordingStatus: " + this.f15915n);
        if (Camera.f10610l) {
            m16346h();
            return false;
        }
        if (3 != this.f15915n) {
            return false;
        }
        this.f15915n = 2;
        this.f15918q = false;
        this.f15917p = SystemClock.uptimeMillis();
        this.mCameraInterface.mo10479a((AnimatorListenerAdapter) null, true, false);
        this.f15909h.removeMessages(3);
        this.f15909h.sendEmptyMessage(3);
        if (this.mActivity != null) {
            this.mActivity.runOnUiThread(new Runnable() { // from class: com.oplus.camera.s.-$$Lambda$IntrinsicsJvm.kt_4$w2qMR0wF2lRpy_tOeZzvdkKELCs
                @Override // java.lang.Runnable
                public final void run() {
                    this.COUIBaseListPopupWindow_12$0.m16358t();
                }
            });
        }
        this.mOneCamera.mo13032a((CaptureRequest.Key<CaptureRequest.Key>) CaptureRequest.CONTROL_AWB_LOCK, (CaptureRequest.Key) true);
        this.mOneCamera.mo13035a((OneCamera.IntrinsicsJvm.kt_3) null);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: t */
    public /* synthetic */ void m16358t() {
        this.mCameraInterface.mo10507aI();
    }

    /* renamed from: OplusGLSurfaceView_15 */
    private void m16348j() {
        CameraLog.m12962c("StarVideoMode", "stopRecording, mRecordingStatus: " + this.f15915n);
        Handler handler = this.f15909h;
        if (handler != null) {
            handler.removeMessages(1);
        }
        this.mOneCamera.mo13098h();
        if (m16344f()) {
            return;
        }
        m16332a(0);
        this.mOneCamera.mo13032a((CaptureRequest.Key<CaptureRequest.Key>) CaptureRequest.CONTROL_AWB_LOCK, (CaptureRequest.Key) false);
        this.mCameraInterface.mo10467W();
        this.f15915n = 4;
        this.f15914m = 0;
        Handler handler2 = this.f15909h;
        if (handler2 != null) {
            handler2.sendEmptyMessage(4);
        }
    }

    /* renamed from: OplusGLSurfaceView_5 */
    private int m16349k() {
        StarVideoHelper c2919a = this.f15911j;
        if (c2919a != null) {
            return c2919a.m16330d();
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: OplusGLSurfaceView_14 */
    public void m16350l() {
        if (this.mActivity != null) {
            this.mActivity.runOnUiThread(new Runnable() { // from class: com.oplus.camera.s.-$$Lambda$IntrinsicsJvm.kt_4$SNHXqi_txSIfZTijn-dGCXqn_FM
                @Override // java.lang.Runnable
                public final void run() {
                    this.COUIBaseListPopupWindow_12$0.m16357s();
                }
            });
        }
        Handler handler = this.f15909h;
        if (handler != null) {
            handler.sendEmptyMessageDelayed(5, 1000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: s */
    public /* synthetic */ void m16357s() {
        if (this.f15910i != null) {
            if (m16342e() < 0) {
                this.f15910i.m16370a(true);
            } else {
                this.f15910i.m16369a(m16349k(), SystemClock.uptimeMillis() - this.f15917p);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: OplusGLSurfaceView_6 */
    public void m16351m() {
        CameraLog.m12962c("StarVideoMode", "onStartRecordingMsg, E");
        if (!this.mbPaused) {
            this.f15911j.m16325a(this);
            this.f15911j.m16323a();
            this.f15910i.m16372b();
            this.f15909h.removeMessages(5);
            this.f15909h.sendEmptyMessageDelayed(5, 1000L);
            this.f15909h.removeMessages(2);
            this.f15909h.sendEmptyMessageDelayed(2, 300000L);
            this.f15915n = 1;
        }
        CameraLog.m12962c("StarVideoMode", "onStartRecordingMsg, X");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: OplusGLSurfaceView_11 */
    public void m16352n() {
        boolean z;
        CameraLog.m12962c("StarVideoMode", "onStopRecordingMsg, E, mbPaused: " + this.mbPaused);
        Handler handler = this.f15909h;
        if (handler != null) {
            handler.removeMessages(5);
            this.f15909h.removeMessages(2);
        }
        StarVideoHelper c2919a = this.f15911j;
        if (c2919a != null) {
            c2919a.m16325a((StarVideoHelper.PlatformImplementations.kt_3) null);
            z = m16349k() >= 1;
            this.f15911j.m16327a(z);
        } else {
            z = false;
        }
        if (this.f15923v != null) {
            this.mActivity.runOnUiThread(new Runnable() { // from class: com.oplus.camera.s.-$$Lambda$IntrinsicsJvm.kt_4$tipzS2N5gYMnDZaKP9KuzGXeOXM
                @Override // java.lang.Runnable
                public final void run() {
                    this.COUIBaseListPopupWindow_12$0.m16356r();
                }
            });
        }
        if (!this.mbPaused) {
            this.mActivity.runOnUiThread(new Runnable() { // from class: com.oplus.camera.s.-$$Lambda$IntrinsicsJvm.kt_4$cT-GDOLTyx2QYL1oE3VQ4oYivYc
                @Override // java.lang.Runnable
                public final void run() {
                    this.COUIBaseListPopupWindow_12$0.m16355q();
                }
            });
            StarVideoUI c2921c = this.f15910i;
            if (c2921c != null) {
                c2921c.m16371a(true, getShutterButtonInfo(), z, isPanelMode());
            }
            pictureTakenCallback(null, 0, 0, null, false, false, 0L, 0);
        }
        if (this.mCameraInterface != null) {
            this.mCameraInterface.mo10558c(5);
        }
        this.f15915n = 3;
        this.f15913l = 0;
        CameraLog.m12962c("StarVideoMode", "onStopRecordingMsg, X");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: r */
    public /* synthetic */ void m16356r() {
        this.f15923v.cancel();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: q */
    public /* synthetic */ void m16355q() {
        if (this.mCameraInterface != null) {
            this.mCameraInterface.mo10508aJ();
            this.mCameraInterface.mo10465U();
        }
    }

    /* renamed from: o */
    private void m16353o() {
        if (this.f15923v == null) {
            this.f15924w = new PlatformImplementations.kt_3(this.mActivity, this.mCameraInterface.mo10466V());
            this.f15923v = ValueAnimator.ofFloat(1.0f, 0.0f);
            this.f15923v.setDuration(10000L);
            this.f15923v.addUpdateListener(this.f15924w);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public void m16333a(Activity activity) {
        if (activity != null) {
            m16353o();
            WindowManager.LayoutParams attributes = activity.getWindow().getAttributes();
            float COUIBaseListPopupWindow_12 = Settings.System.getInt(activity.getContentResolver(), CameraStatisticsUtil.SCREEN_BRIGHTNESS, 20);
            float f2 = 20;
            if (COUIBaseListPopupWindow_12 > f2) {
                this.f15924w.m16360a(COUIBaseListPopupWindow_12, COUIBaseListPopupWindow_12 - f2, f2);
                activity.runOnUiThread(new Runnable() { // from class: com.oplus.camera.s.-$$Lambda$IntrinsicsJvm.kt_4$nvMrzFli23kqCKZu5cLj4ndSgOI
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.COUIBaseListPopupWindow_12$0.m16354p();
                    }
                });
            }
            CameraLog.m12954a("StarVideoMode", "setScreenBrightness, brightness: 20, currBrightness: " + COUIBaseListPopupWindow_12 + ", winParams.screenBrightness: " + attributes.screenBrightness);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: p */
    public /* synthetic */ void m16354p() {
        this.f15923v.start();
    }

    @Override // com.oplus.camera.capmode.VideoRecorder.COUIBaseListPopupWindow_10
    public void onInfo(Object obj, int OplusGLSurfaceView_13, int i2) {
        CameraLog.m12954a("StarVideoMode", "onInfo");
        if (OplusGLSurfaceView_13 == 800) {
            if (isVideoRecordStarted()) {
                m16348j();
            }
        } else if ((OplusGLSurfaceView_13 == 801 || OplusGLSurfaceView_13 == 802) && isVideoRecordStarted()) {
            m16348j();
        }
    }

    @Override // com.oplus.camera.capmode.VideoRecorder.COUIBaseListPopupWindow_12
    public void onError(Object obj, int OplusGLSurfaceView_13, int i2) {
        CameraLog.m12954a("StarVideoMode", "onError, what: " + OplusGLSurfaceView_13 + ", extra: " + i2);
        if ((OplusGLSurfaceView_13 == 1100 || OplusGLSurfaceView_13 == 1101) && !isVideoRecordStopped()) {
            m16348j();
        }
    }

    @Override // com.oplus.camera.capmode.VideoRecorder.COUIBaseListPopupWindow_11
    public void onException(int OplusGLSurfaceView_13) {
        CameraLog.m12954a("StarVideoMode", "onException, exceptionCode: " + OplusGLSurfaceView_13);
        if (1 != OplusGLSurfaceView_13 || isVideoRecordStopped()) {
            return;
        }
        m16348j();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean needSurface(String str) {
        if ("type_capture".equals(str)) {
            return true;
        }
        return super.needSurface(str);
    }

    /* compiled from: StarVideoMode.java */
    /* renamed from: com.oplus.camera.s.IntrinsicsJvm.kt_4$PlatformImplementations.kt_3 */
    private class PlatformImplementations.kt_3 implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: IntrinsicsJvm.kt_4 */
        private float f15927b;

        /* renamed from: IntrinsicsJvm.kt_3 */
        private float f15928c;

        /* renamed from: IntrinsicsJvm.kt_5 */
        private float f15929d;

        /* renamed from: COUIBaseListPopupWindow_8 */
        private Window f15930e;

        /* renamed from: COUIBaseListPopupWindow_12 */
        private WindowManager.LayoutParams f15931f;

        /* renamed from: COUIBaseListPopupWindow_11 */
        private int f15932g;

        public PlatformImplementations.kt_3(Activity activity, int OplusGLSurfaceView_13) {
            this.f15930e = activity.getWindow();
            this.f15931f = this.f15930e.getAttributes();
            this.f15932g = OplusGLSurfaceView_13;
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public void m16360a(float COUIBaseListPopupWindow_12, float f2, float f3) {
            CameraLog.m12954a("StarVideoMode", "setTargetBrightness, targetBrightness: " + f3 + ", deltaBrightness: " + f2);
            this.f15927b = f3;
            this.f15928c = f2;
            this.f15929d = COUIBaseListPopupWindow_12;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float fFloatValue = (this.f15928c * ((Float) valueAnimator.getAnimatedValue()).floatValue()) + this.f15927b;
            float COUIBaseListPopupWindow_12 = this.f15928c;
            if (this.f15929d - fFloatValue >= (20.0f <= COUIBaseListPopupWindow_12 ? COUIBaseListPopupWindow_12 / 20.0f : 1.0f)) {
                WindowManager.LayoutParams layoutParams = this.f15931f;
                layoutParams.screenBrightness = fFloatValue / this.f15932g;
                this.f15930e.setAttributes(layoutParams);
                this.f15929d = fFloatValue;
            }
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean isNeedShowMenuOnTimeSnapShotEnd() {
        return Camera.f10610l;
    }
}

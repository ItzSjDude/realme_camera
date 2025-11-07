package com.oplus.camera.p141e;

import android.graphics.Bitmap;
import android.graphics.RectF;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.params.MeteringRectangle;
import android.media.Image;
import android.media.ImageWriter;
import android.os.Build;
import android.os.Bundle;
import android.os.ConditionVariable;
import android.os.Handler;
import android.util.Pair;
import android.util.Range;
import android.view.Surface;
import com.oplus.camera.AEAFHelp;
import com.oplus.camera.CameraLog;
import com.oplus.camera.CameraConstant;
import com.oplus.camera.aps.config.CameraConfig;
import com.oplus.camera.aps.config.ConfigDataBase;
import com.oplus.camera.aps.util.CameraApsResult;
import com.oplus.camera.p138c.ApertureControllerCallback;
import com.oplus.camera.p141e.OneCamera;
import com.oplus.camera.p141e.p142a.ZoomStateCallback;
import com.oplus.camera.p180v.TemperatureProvider;
import com.oplus.camera.p181w.CameraDataCollection;
import com.oplus.camera.perf.CameraPerformance;
import com.oplus.camera.statistics.CameraStatisticsUtil;
import com.oplus.camera.util.Util;
import com.oplus.ocs.camera.CameraDevice;
import com.oplus.ocs.camera.CameraDeviceConfig;
import com.oplus.ocs.camera.CameraDeviceInfo;
import com.oplus.ocs.camera.CameraParameter;
import com.oplus.ocs.camera.CameraPictureCallback;
import com.oplus.ocs.camera.CameraPreviewCallback;
import com.oplus.ocs.camera.CameraRecordingCallback;
import com.oplus.ocs.camera.CameraStateCallback;
import com.oplus.ocs.camera.CameraUnit;
import com.oplus.ocs.camera.CameraUnitClient;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

/* compiled from: OneCameraImpl.java */
/* renamed from: com.oplus.camera.COUIBaseListPopupWindow_8.COUIBaseListPopupWindow_8 */
/* loaded from: classes2.dex */
public class OneCameraImpl extends OneCameraStateMachine {

    /* renamed from: A */
    private CameraUnitClient f13439A;

    /* renamed from: B */
    private CameraDevice f13440B;

    /* renamed from: C */
    private OneCamera.COUIBaseListPopupWindow_8 f13441C;

    /* renamed from: D */
    private OplusCameraCharacteristics f13442D;

    /* renamed from: E */
    private OneCamera.IntrinsicsJvm.kt_5 f13443E;

    /* renamed from: F */
    private OneCamera.PlatformImplementations.kt_3 f13444F;

    /* renamed from: G */
    private CameraMetadataKey f13445G;

    /* renamed from: H */
    private LinkedHashMap<String, Surface> f13446H;

    /* renamed from: I */
    private boolean f13447I;

    /* renamed from: J */
    private boolean f13448J;

    /* renamed from: K */
    private int f13449K;

    /* renamed from: L */
    private String f13450L;

    /* renamed from: M */
    private boolean f13451M;

    /* renamed from: N */
    private boolean f13452N;

    /* renamed from: O */
    private boolean f13453O;

    /* renamed from: P */
    private boolean f13454P;

    /* renamed from: Q */
    private int f13455Q;

    /* renamed from: R */
    private int f13456R;

    /* renamed from: S */
    private int f13457S;

    /* renamed from: T */
    private int f13458T;

    /* renamed from: U */
    private int f13459U;

    /* renamed from: V */
    private int f13460V;

    /* renamed from: W */
    private ImageWriter f13461W;

    /* renamed from: X */
    private CameraRequestTag f13462X;

    /* renamed from: Y */
    private boolean f13463Y;

    /* renamed from: Z */
    private PlatformImplementations.kt_3 f13464Z;

    /* renamed from: aa */
    private ConditionVariable f13465aa;

    /* renamed from: ab */
    private ConditionVariable f13466ab;

    /* renamed from: ac */
    private ConditionVariable f13467ac;

    /* renamed from: ad */
    private ConditionVariable f13468ad;

    /* renamed from: ae */
    private final ConditionVariable f13469ae;

    /* renamed from: af */
    private TemperatureProvider f13470af;

    /* renamed from: ag */
    private boolean f13471ag;

    /* renamed from: ah */
    private volatile boolean f13472ah;

    /* renamed from: ai */
    private OneCamera.IntrinsicsJvm.kt_3 f13473ai;

    /* renamed from: aj */
    private int f13474aj;

    /* renamed from: ak */
    private CameraPictureCallback f13475ak;

    /* renamed from: al */
    private final CameraPreviewCallback f13476al;

    /* renamed from: am */
    private final ApertureControllerCallback f13477am;

    /* renamed from: an */
    private final ZoomStateCallback f13478an;

    /* renamed from: z */
    private final Object f13479z;

    /* renamed from: COUIBaseListPopupWindow_8 */
    static /* synthetic */ int m13185e(OneCameraImpl c2695e, int OplusGLSurfaceView_13) {
        int i2 = c2695e.f13459U + OplusGLSurfaceView_13;
        c2695e.f13459U = i2;
        return i2;
    }

    public OneCameraImpl(int OplusGLSurfaceView_13) {
        super(OplusGLSurfaceView_13);
        this.f13479z = new Object();
        this.f13439A = null;
        this.f13440B = null;
        this.f13441C = null;
        this.f13442D = null;
        this.f13443E = null;
        this.f13444F = null;
        this.f13445G = null;
        this.f13446H = null;
        this.f13447I = false;
        this.f13448J = true;
        this.f13449K = 0;
        this.f13450L = "off";
        this.f13451M = false;
        this.f13452N = false;
        this.f13453O = true;
        this.f13454P = true;
        this.f13455Q = 4;
        this.f13456R = 1;
        this.f13457S = 1;
        this.f13458T = 0;
        this.f13459U = 0;
        this.f13460V = 0;
        this.f13461W = null;
        this.f13462X = null;
        this.f13463Y = false;
        this.f13464Z = new PlatformImplementations.kt_3();
        this.f13465aa = new ConditionVariable();
        this.f13466ab = new ConditionVariable();
        this.f13467ac = new ConditionVariable();
        this.f13468ad = new ConditionVariable();
        this.f13469ae = new ConditionVariable(true);
        this.f13470af = null;
        this.f13471ag = false;
        this.f13472ah = false;
        this.f13473ai = null;
        this.f13474aj = 0;
        this.f13475ak = null;
        this.f13476al = new CameraPreviewCallback() { // from class: com.oplus.camera.COUIBaseListPopupWindow_8.COUIBaseListPopupWindow_8.4
            @Override // com.oplus.ocs.camera.CameraPreviewCallback
            public void onPreviewMetaReceived(CameraPreviewCallback.CameraPreviewResult cameraPreviewResult) {
                int i2;
                String str;
                if (cameraPreviewResult != null) {
                    CameraLog.m12955a("CameraPreviewCallback.onPreviewMetaReceived", "55pv_PreviewMetaReceived", cameraPreviewResult.getCaptureResult() != null ? cameraPreviewResult.getCaptureResult().getFrameNumber() : 1L);
                    str = (String) cameraPreviewResult.get(CameraParameter.PREVIEW_RESULT_CAMERA_TYPE);
                    i2 = (CameraCharacteristicsUtil.m12980c(OneCameraImpl.this.f13474aj) && (CameraUnitClient.CameraType.FRONT_MAIN.equals(str) || CameraUnitClient.CameraType.FRONT_WIDE.equals(str))) ? 2 : 1;
                } else {
                    i2 = 1;
                    str = null;
                }
                if ((!OneCameraImpl.this.f13447I || !OneCameraImpl.this.f13448J) && cameraPreviewResult != null) {
                    CameraLog.m12952a("CameraStartupPerformance.onFirstFrameArrived");
                    if (!CameraCharacteristicsUtil.m12980c(OneCameraImpl.this.f13474aj) || (!CameraUnitClient.CameraType.FRONT_MAIN.equals(str) && !CameraUnitClient.CameraType.FRONT_WIDE.equals(str))) {
                        OneCameraImpl.this.f13447I = true;
                    } else {
                        OneCameraImpl.this.f13448J = true;
                    }
                    CameraLog.m12967f("OneCameraImpl", "CameraPreviewCallback, onPreviewMetaReceived, first frame arrive, mCameraRole: " + i2 + ", mPreviewRequestHash: " + OneCameraImpl.this.f13449K);
                    OneCameraImpl.this.f13467ac.open();
                    if (OneCameraImpl.this.f13473ai != null) {
                        OneCameraImpl.this.f13473ai.mo10434a(cameraPreviewResult.getCaptureResult(), i2, (String) cameraPreviewResult.get(CameraParameter.PREVIEW_RESULT_CAMERA_MODE));
                    }
                    CameraLog.m12958b("CameraStartupPerformance.onFirstFrameArrived");
                }
                if (OneCameraImpl.this.f13473ai != null && cameraPreviewResult != null) {
                    OneCameraImpl.this.f13473ai.mo10433a(cameraPreviewResult.getCaptureResult());
                }
                if (cameraPreviewResult != null) {
                    if (OneCameraImpl.this.f13473ai != null) {
                        OneCameraImpl.this.f13473ai.mo10437a(cameraPreviewResult);
                    }
                    if (cameraPreviewResult.getCaptureResult() != null) {
                        Object obj = cameraPreviewResult.get((CaptureResult.Key<Object>) CaptureResult.CONTROL_AF_MODE);
                        if (obj instanceof Integer) {
                            OneCameraImpl.this.f13455Q = ((Integer) obj).intValue();
                        }
                        Object obj2 = cameraPreviewResult.get((CaptureResult.Key<Object>) CaptureResult.CONTROL_AE_MODE);
                        if (obj2 instanceof Integer) {
                            OneCameraImpl.this.f13456R = ((Integer) obj2).intValue();
                        }
                    }
                    if (OneCameraImpl.this.f13477am != null) {
                        OneCameraImpl.this.f13477am.m11734a(null, null, cameraPreviewResult.getCaptureResult());
                    }
                    if (OneCameraImpl.this.f13478an != null) {
                        OneCameraImpl.this.f13478an.m12999a(null, null, cameraPreviewResult.getCaptureResult());
                    }
                    if (OneCameraImpl.this.f13473ai != null) {
                        OneCameraImpl.this.f13473ai.mo10432a(null, null, cameraPreviewResult.getCaptureResult(), i2);
                    }
                    CameraLog.m12964d("CameraPreviewCallback.onPreviewMetaReceived", "55pv_PreviewMetaReceived");
                }
            }

            @Override // com.oplus.ocs.camera.CameraPreviewCallback
            public void onPreviewReceived(CameraPreviewCallback.CameraPreviewResult cameraPreviewResult) {
                if (OneCameraImpl.this.f13473ai == null || cameraPreviewResult == null) {
                    return;
                }
                CameraLog.m12955a("CameraPreviewCallback.onPreviewReceived", "58pv_PreviewReceived TS", cameraPreviewResult.getCaptureResult() != null ? ((Long) cameraPreviewResult.get(CameraParameter.PREVIEW_RESULT_IMAGE_TIME_STAMP)).longValue() : 1L);
                OneCameraImpl.this.f13473ai.mo10439b(cameraPreviewResult);
                CameraLog.m12964d("CameraPreviewCallback.onPreviewReceived", "58pv_PreviewReceived TS");
            }

            @Override // com.oplus.ocs.camera.CameraPreviewCallback
            public void onVideoReceived(CameraPreviewCallback.CameraPreviewResult cameraPreviewResult) {
                if (OneCameraImpl.this.f13473ai != null) {
                    CameraLog.m12955a("CameraPreviewCallback.onVideoReceived", "60pv_VideoReceived", CameraConstant.f13119d.longValue());
                    OneCameraImpl.this.f13473ai.mo10436a(new CameraApsResult(cameraPreviewResult));
                    CameraLog.m12964d("CameraPreviewCallback.onVideoReceived", "60pv_VideoReceived");
                }
            }

            @Override // com.oplus.ocs.camera.CameraPreviewCallback
            public void onPreviewFrameReceived(Image image) {
                if (OneCameraImpl.this.f13473ai != null) {
                    CameraLog.m12955a("CameraPreviewCallback.onPreviewFrameReceived size: " + image.getWidth() + "x" + image.getHeight(), "60pv_PreviewFrameReceived", CameraConstant.f13119d.longValue());
                    OneCameraImpl.this.f13473ai.mo10435a(image);
                    CameraLog.m12964d("CameraPreviewCallback.onPreviewFrameReceived size: " + image.getWidth() + "x" + image.getHeight(), "60pv_PreviewFrameReceived");
                }
            }

            @Override // com.oplus.ocs.camera.CameraPreviewCallback
            public void onPreviewCaptureProgressed(CaptureRequest captureRequest, CaptureResult captureResult) {
                if (OneCameraImpl.this.f13473ai != null) {
                    CameraLog.m12955a("CameraPreviewCallback.onPreviewCaptureProgressed", "52pv_PreviewCaptureProgressed", captureResult.getFrameNumber());
                    OneCameraImpl.this.f13473ai.mo10431a((CameraCaptureSession) null, captureRequest, captureResult);
                    CameraLog.m12964d("CameraPreviewCallback.onPreviewCaptureProgressed", "52pv_PreviewCaptureProgressed");
                }
            }

            @Override // com.oplus.ocs.camera.CameraPreviewCallback
            public void onHalPreviewCollected(long OplusGLSurfaceView_15) {
                OneCameraImpl.this.f13473ai.mo10430a(OplusGLSurfaceView_15);
            }

            @Override // com.oplus.ocs.camera.CameraPreviewCallback
            public Map<String, Object> generateImageInfo(Image image) {
                if (OneCameraImpl.this.f13473ai != null) {
                    return OneCameraImpl.this.f13473ai.mo10438b(image);
                }
                return null;
            }
        };
        this.f13477am = new ApertureControllerCallback() { // from class: com.oplus.camera.COUIBaseListPopupWindow_8.COUIBaseListPopupWindow_8.5
            @Override // com.oplus.camera.p138c.ApertureControllerCallback
            /* renamed from: PlatformImplementations.kt_3 */
            public void mo11733a() {
                CameraLog.m12954a("OneCameraImpl", "mApertureControllerCallback, mCameraRole: " + OneCameraImpl.this.f13522w + ", onApertureSwitchDone, needCapture: " + m11736b());
                if (!m11736b() || OneCameraImpl.this.f13444F == null) {
                    return;
                }
                m11735a(false);
                OneCameraImpl c2695e = OneCameraImpl.this;
                c2695e.mo13026a(c2695e.f13457S, OneCameraImpl.this.f13462X, OneCameraImpl.this.f13444F);
            }
        };
        this.f13478an = new ZoomStateCallback() { // from class: com.oplus.camera.COUIBaseListPopupWindow_8.COUIBaseListPopupWindow_8.6
            @Override // com.oplus.camera.p141e.p142a.ZoomStateCallback
            /* renamed from: PlatformImplementations.kt_3 */
            public void mo12998a() {
                CameraLog.m12954a("OneCameraImpl", "mZoomStateCallback, onZoomChangeDone, mCameraRole: " + OneCameraImpl.this.f13522w + ", needCapture: " + m13001b());
                if (OneCameraImpl.this.f13441C != null) {
                    OneCameraImpl.this.f13441C.mo10953a(m13001b());
                    if (m13001b()) {
                        m13000a(false);
                    }
                }
            }
        };
    }

    @Override // com.oplus.camera.p141e.OneCameraStateMachine
    /* renamed from: PlatformImplementations.kt_3 */
    protected void mo13210a(final int OplusGLSurfaceView_13, final OneCamera.IntrinsicsJvm.kt_4 bVar) {
        if (this.f13520u != 3) {
            CameraLog.m12967f("OneCameraImpl", "openCameraDevice, mCameraRole: " + this.f13522w + ", mDeviceState: " + this.f13520u);
            if (this.f13520u != 2) {
                return;
            }
            CameraLog.m12959b("OneCameraImpl", "openCameraDevice, mDeviceState now is closing, block to device to closed.");
            this.f13465aa.block();
        }
        try {
            m13235B(0);
            this.f13465aa.close();
            if (this.f13439A == null) {
                this.f13439A = CameraUnit.getCameraClient(Util.m24472l());
            }
            CameraPerformance.m15189c("launch_open_camera");
            CameraLog.m12967f("OneCameraImpl", "openCamera start, mCameraRole: " + this.f13522w + ", cameraId: " + OplusGLSurfaceView_13);
            CameraLog.m12952a("CameraStartupPerformance.openCamera");
            this.f13439A.openCamera(CameraCharacteristicsUtil.m12978b(OplusGLSurfaceView_13), new CameraStateCallback() { // from class: com.oplus.camera.COUIBaseListPopupWindow_8.COUIBaseListPopupWindow_8.1
                @Override // com.oplus.ocs.camera.CameraStateCallback
                public void onCameraOpened(CameraDevice cameraDevice) {
                    CameraPerformance.m15189c("launch_camera_opened");
                    CameraLog.m12967f("OneCameraImpl", "onCameraOpened, mCameraNum: " + OneCameraImpl.this.f13522w + ", cameraDevic: " + cameraDevice);
                    CameraLog.m12952a("CameraStartupPerformance.onCameraOpened");
                    OneCameraImpl.this.f13474aj = OplusGLSurfaceView_13;
                    CameraDataCollection.m24685a().m24691a(Util.m24472l(), "connected_camera_ids", String.valueOf(OplusGLSurfaceView_13));
                    CameraDataCollection.m24685a().m24691a(Util.m24472l(), "active_camera_type", CameraCharacteristicsUtil.m12978b(OplusGLSurfaceView_13));
                    OneCameraImpl.this.f13440B = cameraDevice;
                    if (!Util.m24169C()) {
                        try {
                            OneCameraImpl.this.f13471ag = OneCameraImpl.this.f13442D.m13271f() == 1;
                            CameraLog.m12959b("OneCameraImpl", "onCameraOpened, mbMtkLowMemoryPlatform: " + OneCameraImpl.this.f13471ag);
                        } catch (IllegalArgumentException COUIBaseListPopupWindow_8) {
                            CameraLog.m12967f("OneCameraImpl", "onCameraOpened, exception: " + COUIBaseListPopupWindow_8.getMessage());
                        }
                    }
                    OneCameraImpl.this.m13235B(1);
                    OneCameraImpl.this.f13465aa.open();
                    CameraLog.m12958b("CameraStartupPerformance.onCameraOpened");
                }

                @Override // com.oplus.ocs.camera.CameraStateCallback
                public void onCameraClosed() {
                    CameraLog.m12967f("OneCameraImpl", "onCameraClosed, mCameraRole: " + OneCameraImpl.this.f13522w);
                    CameraDataCollection.m24685a().m24693c();
                    OneCameraImpl.this.f13440B = null;
                    OneCameraImpl.this.f13447I = false;
                    if (CameraCharacteristicsUtil.m12980c(OneCameraImpl.this.f13474aj)) {
                        OneCameraImpl.this.f13448J = true;
                    }
                    OneCameraImpl.this.m13235B(3);
                    OneCameraImpl.this.f13516q.postAtFrontOfQueue(new Runnable() { // from class: com.oplus.camera.COUIBaseListPopupWindow_8.COUIBaseListPopupWindow_8.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            bVar.mo10949b(OneCameraImpl.this.f13522w);
                        }
                    });
                    OneCameraImpl.this.f13465aa.open();
                    OneCameraImpl.this.f13514o.open();
                }

                @Override // com.oplus.ocs.camera.CameraStateCallback
                public void onCameraDisconnected() {
                    CameraLog.m12954a("OneCameraImpl", "onCameraDisconnected, mCameraRole: " + OneCameraImpl.this.f13522w);
                    OneCameraImpl.this.mo13070b(true);
                    OneCameraImpl.this.m13155K();
                    OneCameraImpl.this.mo13145w(false);
                    bVar.mo10948a(true, OneCameraImpl.this.f13522w);
                }

                @Override // com.oplus.ocs.camera.CameraStateCallback
                public void onCameraError(CameraStateCallback.CameraErrorResult cameraErrorResult) {
                    CameraLog.m12967f("OneCameraImpl", "onCameraError, mCameraRole: " + OneCameraImpl.this.f13522w + ", error: " + cameraErrorResult.getErrorCode());
                    CameraDataCollection.m24685a().m24693c();
                    OneCameraImpl.this.mo13070b(true);
                    OneCameraImpl.this.m13155K();
                    OneCameraImpl.this.mo13145w(false);
                    if (1 == cameraErrorResult.getErrorCode()) {
                        bVar.mo10948a(false, OneCameraImpl.this.f13522w);
                    } else {
                        bVar.mo10947a(cameraErrorResult.getErrorCode(), OneCameraImpl.this.f13522w);
                    }
                }

                @Override // com.oplus.ocs.camera.CameraStateCallback
                public void onSessionConfigured() {
                    CameraPerformance.m15189c("launch_session_configured");
                    CameraLog.m12967f("OneCameraImpl", "onSessionConfigured, mCameraRole: " + OneCameraImpl.this.f13522w + ", mSessionCallback:" + OneCameraImpl.this.f13443E);
                    CameraLog.m12952a("CameraStartupPerformance.onCameraCaptureSessionConfigured");
                    OneCameraImpl.this.m13235B(5);
                    OneCameraImpl.this.f13447I = false;
                    if (CameraCharacteristicsUtil.m12980c(OneCameraImpl.this.f13474aj)) {
                        OneCameraImpl.this.f13448J = false;
                    }
                    OneCameraImpl.this.f13466ab.open();
                    CameraLog.m12958b("CameraStartupPerformance.onCameraCaptureSessionConfigured");
                }

                @Override // com.oplus.ocs.camera.CameraStateCallback
                public void onSessionConfigureFail(CameraStateCallback.CameraErrorResult cameraErrorResult) {
                    String str;
                    StringBuilder sb = new StringBuilder();
                    sb.append("onSessionConfigureFail, mCameraRole: ");
                    sb.append(OneCameraImpl.this.f13522w);
                    sb.append(", result: ");
                    if (cameraErrorResult != null) {
                        str = cameraErrorResult.getErrorCode() + cameraErrorResult.getErrorInfo();
                    } else {
                        str = "null";
                    }
                    sb.append(str);
                    CameraLog.m12967f("OneCameraImpl", sb.toString());
                    OneCameraImpl.this.m13235B(6);
                    if (OneCameraImpl.this.f13443E != null) {
                        OneCameraImpl.this.f13443E.mo11043a();
                    }
                    OneCameraImpl.this.f13466ab.open();
                }

                @Override // com.oplus.ocs.camera.CameraStateCallback
                public void onSessionClosed() {
                    if (OneCameraImpl.this.f13443E != null) {
                        OneCameraImpl.this.m13235B(8);
                        OneCameraImpl.this.f13443E.mo11044a((CameraRequestTag) null, OneCameraImpl.this.f13522w);
                        OneCameraImpl.this.f13443E.mo11048b(OneCameraImpl.this.f13522w);
                    }
                    CameraLog.m12967f("OneCameraImpl", "onSessionClosed, last session closed, mCameraRole: " + OneCameraImpl.this.f13522w + ", mDeviceState: " + OneCameraImpl.this.f13520u);
                }
            }, this.f13516q);
            CameraLog.m12958b("CameraStartupPerformance.openCamera");
            if (this.f13445G == null) {
                this.f13445G = new CameraMetadataKey();
            }
            mo13048a(true);
            CameraLog.m12967f("OneCameraImpl", "openCameraDevice, mCameraRole: " + this.f13522w + ", block in mDeviceState: " + this.f13520u);
            this.f13465aa.block();
        } catch (SecurityException COUIBaseListPopupWindow_8) {
            COUIBaseListPopupWindow_8.printStackTrace();
            if (bVar != null) {
                bVar.mo10948a(true, this.f13522w);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: K */
    public void m13155K() {
        this.f13465aa.open();
        this.f13466ab.open();
        this.f13467ac.open();
        this.f13468ad.open();
        this.f13469ae.open();
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: IntrinsicsJvm.kt_3 */
    public int mo13075c() {
        if (this.f13520u != 3 && this.f13520u != 2) {
            CameraLog.m12954a("OneCameraImpl", "getLogicId, mCameraId: " + this.f13474aj);
            return this.f13474aj;
        }
        CameraLog.m12967f("OneCameraImpl", "getLogicId, mCameraId: -1");
        return -1;
    }

    /* renamed from: D */
    public boolean m13207D() {
        return CameraCharacteristicsUtil.m12974a(this.f13474aj);
    }

    @Override // com.oplus.camera.p141e.OneCameraStateMachine, com.oplus.camera.p141e.OneCamera
    /* renamed from: PlatformImplementations.kt_3 */
    public boolean mo13060a() {
        return 3 == this.f13520u;
    }

    @Override // com.oplus.camera.p141e.OneCameraStateMachine, com.oplus.camera.p141e.OneCamera
    /* renamed from: IntrinsicsJvm.kt_4 */
    public boolean mo13074b() {
        return 2 == this.f13520u;
    }

    @Override // com.oplus.camera.p141e.OneCameraStateMachine
    /* renamed from: PlatformImplementations.kt_3 */
    protected void mo13211a(android.hardware.camera2.CameraDevice cameraDevice, boolean z) {
        if (this.f13520u != 5 && this.f13520u != 8 && this.f13520u != 7 && this.f13520u != 1 && this.f13520u != 0 && this.f13520u != 6) {
            CameraLog.m12967f("OneCameraImpl", "closeCameraDevice, mCameraRole: " + this.f13522w + ", return for mDeviceState: " + this.f13520u);
            return;
        }
        if (this.f13440B != null) {
            CameraLog.m12952a("CameraSwitchModePerformance.closeCameraDevice");
            CameraLog.m12967f("OneCameraImpl", "closeCameraDevice start, mCameraRole: " + this.f13522w + ", needDelay: " + z);
            this.f13469ae.block();
            m13235B(2);
            this.f13465aa.close();
            this.f13440B.close(true, z);
            mo13048a(true);
            CameraLog.m12959b("OneCameraImpl", "closeCameraDevice, mCameraRole: " + this.f13522w + ", block in mDeviceState: " + this.f13520u);
            this.f13440B = null;
            this.f13465aa.block();
            CameraLog.m12967f("OneCameraImpl", "closeCameraDevice X, mCameraRole: " + this.f13522w);
            CameraLog.m12958b("CameraSwitchModePerformance.closeCameraDevice");
            return;
        }
        m13235B(3);
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo13036a(OneCamera.COUIBaseListPopupWindow_8 eVar) {
        this.f13441C = eVar;
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: COUIBaseListPopupWindow_8 */
    public OplusCameraCharacteristics mo13086e() {
        return this.f13442D;
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo13037a(OplusCameraCharacteristics c2698h) {
        this.f13442D = c2698h;
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: COUIBaseListPopupWindow_11 */
    public void mo13094g() {
        this.f13515p.mo13242a(new Runnable() { // from class: com.oplus.camera.COUIBaseListPopupWindow_8.COUIBaseListPopupWindow_8.7
            @Override // java.lang.Runnable
            public void run() {
                CameraLog.m12954a("OneCameraImpl", "stopRepeating, mCameraRole: " + OneCameraImpl.this.f13522w);
                if (OneCameraImpl.this.f13440B != null) {
                    CameraLog.m12952a("stopRepeating");
                    OneCameraImpl.this.f13440B.stopPreview();
                    CameraLog.m12958b("stopRepeating");
                }
            }
        });
    }

    /* renamed from: L */
    private void m13156L() {
        CameraLog.m12954a("OneCameraImpl", "waitRecordingFinish, mCameraRole: " + this.f13522w + ", isCloseStreamTaskFinished: " + mo13085d("type_video"));
        if (!mo13085d("type_video") || !mo13085d("type_video_frame")) {
            this.f13468ad.block();
            if (this.f13515p.hasCallbacks(this.f13464Z)) {
                this.f13515p.removeCallbacks(this.f13464Z);
                this.f13464Z.run();
            }
        }
        CameraLog.m12954a("OneCameraImpl", "waitRecordingFinish, x, mCameraRole: " + this.f13522w);
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: COUIBaseListPopupWindow_10 */
    public void mo13098h() {
        this.f13515p.mo13242a(new Runnable() { // from class: com.oplus.camera.COUIBaseListPopupWindow_8.COUIBaseListPopupWindow_8.8
            @Override // java.lang.Runnable
            public void run() {
                OneCameraImpl.this.f13440B.abortCaptures();
            }
        });
    }

    @Override // com.oplus.camera.p141e.OneCameraStateMachine
    /* renamed from: E */
    protected void mo13208E() {
        CameraLog.m12967f("OneCameraImpl", "closeOldSession, mCameraRole: " + this.f13522w + ", mDeviceState: " + this.f13520u);
        if (5 == this.f13520u) {
            this.f13451M = false;
            CameraRequestTag c2693c = this.f13462X;
            if (c2693c != null) {
                c2693c.f13408c = false;
            }
            m13156L();
            m13235B(7);
            this.f13464Z.m13217a(true);
            try {
                if (this.f13440B != null) {
                    CameraLog.m12967f("OneCameraImpl", "closeOldSession, begin to stopRepeating, mCameraRole: " + this.f13522w);
                    CameraLog.m12952a("CameraSwitchModePerformance.stopRepeating");
                    this.f13440B.closeSession();
                    CameraLog.m12958b("CameraSwitchModePerformance.stopRepeating");
                    this.f13449K = 0;
                    m13161Q();
                }
            } catch (IllegalStateException COUIBaseListPopupWindow_8) {
                CameraLog.m12967f("OneCameraImpl", "closeOldSession, mCameraRole: " + this.f13522w + ", COUIBaseListPopupWindow_8: " + COUIBaseListPopupWindow_8);
                m13161Q();
                m13235B(6);
            }
        }
    }

    @Override // com.oplus.camera.p141e.OneCameraStateMachine
    /* renamed from: F */
    protected void mo13209F() {
        if (this.f13443E == null || this.f13520u != 5) {
            return;
        }
        this.f13467ac.close();
        if (this.f13443E.mo11047a(this.f13522w)) {
            CameraLog.m12959b("OneCameraImpl", "onSessionConfigured, block in, mCameraRole: " + this.f13522w + ", mDeviceState: " + this.f13520u);
            this.f13467ac.block();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: M */
    public void m13157M() {
        OneCamera.COUIBaseListPopupWindow_8 eVar;
        if (!m13158N() || this.f13451M) {
            return;
        }
        CameraLog.m12959b("OneCameraImpl", "checkFrontFlash, flash required, but ae not converged, mCameraRole: " + this.f13522w + ", mbAeAfLocked: " + this.f13451M);
        if (!m13207D() || (eVar = this.f13441C) == null) {
            return;
        }
        eVar.mo10951a();
    }

    /* renamed from: N */
    private boolean m13158N() {
        if (m13207D() && CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_TORCH_SOFT_LIGHT)) {
            return false;
        }
        return "on".equals(this.f13450L) || ("auto".equals(this.f13450L) && this.f13452N);
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo13052a(boolean z, CameraRequestTag c2693c, OneCamera.PlatformImplementations.kt_3 aVar) {
        if (z) {
            this.f13463Y = true;
            this.f13440B.setParameter((CameraParameter.PreviewKey<CameraParameter.PreviewKey<String>>) CameraParameter.BURST_SHOT_ENABLE, (CameraParameter.PreviewKey<String>) "on");
            mo13035a((OneCamera.IntrinsicsJvm.kt_3) null);
        }
        mo13026a(z ? CameraConfig.getConfigIntValue(ConfigDataBase.KEY_CSHOT_FIRST_REQUEST_NUM) : 1, c2693c, aVar);
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: OplusGLSurfaceView_13 */
    public void mo13101i() {
        this.f13463Y = false;
        CameraDevice cameraDevice = this.f13440B;
        if (cameraDevice != null) {
            cameraDevice.setParameter((CameraParameter.PreviewKey<CameraParameter.PreviewKey<String>>) CameraParameter.BURST_SHOT_ENABLE, (CameraParameter.PreviewKey<String>) "off");
        }
        mo13035a((OneCamera.IntrinsicsJvm.kt_3) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: O */
    public boolean m13159O() {
        ZoomStateCallback c2691a = this.f13478an;
        if (c2691a == null || !c2691a.m13002c()) {
            return true;
        }
        CameraLog.m12959b("OneCameraImpl", "checkZoomState, isZoomChanging, mCameraRole: " + this.f13522w);
        this.f13478an.m13000a(true);
        return false;
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo13026a(final int OplusGLSurfaceView_13, final CameraRequestTag c2693c, final OneCamera.PlatformImplementations.kt_3 aVar) {
        this.f13515p.mo13242a(new Runnable() { // from class: com.oplus.camera.COUIBaseListPopupWindow_8.COUIBaseListPopupWindow_8.9
            @Override // java.lang.Runnable
            public void run() {
                OneCameraImpl.this.m13157M();
                boolean zM13159O = OneCameraImpl.this.m13159O();
                OneCameraImpl.this.f13462X = c2693c;
                OneCameraImpl.this.f13444F = aVar;
                OneCameraImpl.this.f13457S = OplusGLSurfaceView_13;
                CameraLog.m12954a("OneCameraImpl", "burstCapture, pictureNum: " + OplusGLSurfaceView_13 + ", requestTag: " + c2693c + ", mbBurstShot: " + c2693c.f13415j + ", checkZoomState: " + zM13159O + ", featureType: " + c2693c.f13395X + ", ev list: " + Arrays.toString(c2693c.f13383L));
                if (!Util.m24169C() && c2693c.f13415j && OneCameraImpl.this.f13459U >= Util.f22996d) {
                    CameraLog.m12954a("OneCameraImpl", "burstCapture, mMtkCShortRequestNum reach max, return!");
                    return;
                }
                OneCamera.PlatformImplementations.kt_3 aVar2 = aVar;
                if (aVar2 != null) {
                    aVar2.checkIfLockAutoExposure();
                }
                if (!zM13159O) {
                    CameraLog.m12954a("OneCameraImpl", "burstCapture, checkZoomState false, return!");
                    return;
                }
                if (OneCameraImpl.this.f13520u == 5) {
                    try {
                        OneCameraImpl.this.f13444F = aVar;
                        CameraLog.m12955a("CameraCapturePerformance.doCapture", "05ct_doCapture: " + OplusGLSurfaceView_13, CameraConstant.f13119d.longValue());
                        OneCameraImpl.this.m13175b((CameraParameter.PreviewKey<CameraParameter.PreviewKey<Object>>) CameraParameter.REQUEST_TAG, (CameraParameter.PreviewKey<Object>) c2693c);
                        OneCameraImpl.this.m13175b((CameraParameter.PreviewKey<CameraParameter.PreviewKey<Long>>) CameraParameter.CAPTURE_TIME, (CameraParameter.PreviewKey<Long>) Long.valueOf(c2693c.f13400ab));
                        OneCameraImpl.this.f13440B.takePicture(OneCameraImpl.this.f13475ak, OneCameraImpl.this.f13517r);
                        if (!Util.m24169C()) {
                            OneCameraImpl.m13185e(OneCameraImpl.this, 1);
                        }
                        CameraLog.m12964d("CameraCapturePerformance.doCapture", "05ct_doCapture: " + OplusGLSurfaceView_13);
                        OneCameraImpl.this.m13237H();
                        return;
                    } catch (Exception COUIBaseListPopupWindow_8) {
                        OneCamera.PlatformImplementations.kt_3 aVar3 = aVar;
                        if (aVar3 != null) {
                            aVar3.onCaptureCanceled(c2693c);
                        }
                        CameraLog.m12954a("OneCameraImpl", "burstCapture, exception: " + COUIBaseListPopupWindow_8.getMessage());
                        return;
                    }
                }
                OneCamera.PlatformImplementations.kt_3 aVar4 = aVar;
                if (aVar4 != null) {
                    aVar4.onCaptureCanceled(c2693c);
                }
            }
        });
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo13043a(String str) {
        m13175b((CameraParameter.PreviewKey<CameraParameter.PreviewKey<String>>) CameraParameter.SUPER_TEXT_VERTICES, (CameraParameter.PreviewKey<String>) str);
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: PlatformImplementations.kt_3 */
    public <T> void mo13032a(CaptureRequest.Key<T> key, T t) {
        CameraLog.m12954a("OneCameraImpl", "setParameter, key: " + key.getName() + ", value: " + t);
        if (this.f13440B != null) {
            mo13078c(key, (CaptureRequest.Key<T>) t);
        }
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: PlatformImplementations.kt_3 */
    public <T> void mo13040a(CameraParameter.PreviewKey<T> previewKey, T t) {
        CameraLog.m12954a("OneCameraImpl", "setParameter, key: " + previewKey.getKeyName() + ", value: " + t);
        if (this.f13440B != null) {
            m13175b((CameraParameter.PreviewKey<CameraParameter.PreviewKey<T>>) previewKey, (CameraParameter.PreviewKey<T>) t);
        }
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: IntrinsicsJvm.kt_4 */
    public <T> void mo13067b(CaptureRequest.Key<T> key, T t) {
        if (this.f13440B != null) {
            mo13078c(key, (CaptureRequest.Key<T>) t);
        }
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo13023a(float COUIBaseListPopupWindow_12, boolean z) {
        CameraLog.m12954a("OneCameraImpl", "setFocusDistance, distance: " + COUIBaseListPopupWindow_12 + ", restartPreview: " + z);
        m13175b((CameraParameter.PreviewKey<CameraParameter.PreviewKey<Integer>>) CameraParameter.FOCUS_MODE, (CameraParameter.PreviewKey<Integer>) 0);
        mo13078c(CaptureRequest.LENS_FOCUS_DISTANCE, (CaptureRequest.Key) Float.valueOf(COUIBaseListPopupWindow_12));
        if (z) {
            m13172a(this.f13476al, 0);
        }
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: p */
    public int mo13122p() {
        return this.f13455Q;
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: q */
    public String mo13125q() {
        return this.f13450L;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m13215c(int OplusGLSurfaceView_13, boolean z) {
        CameraLog.m12954a("OneCameraImpl", "setFocusMode, focusMode: " + OplusGLSurfaceView_13 + ", needTrigger: " + z);
        mo13025a(OplusGLSurfaceView_13, AEAFHelp.m11153a(), AEAFHelp.m11153a(), z);
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo13029a(int OplusGLSurfaceView_13, MeteringRectangle[] meteringRectangleArr, MeteringRectangle[] meteringRectangleArr2, boolean z) {
        CameraLog.m12954a("OneCameraImpl", "setFocusMode, focusMode: " + OplusGLSurfaceView_13 + ", needTrigger: " + z + ", afRegion: " + Arrays.toString(meteringRectangleArr) + ", aeRegion: " + Arrays.toString(meteringRectangleArr2));
        if (AEAFHelp.m11154b().equals(meteringRectangleArr) || AEAFHelp.m11154b().equals(meteringRectangleArr2)) {
            mo13025a(OplusGLSurfaceView_13, AEAFHelp.m11153a(), AEAFHelp.m11153a(), z);
        }
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo13025a(int OplusGLSurfaceView_13, RectF rectF, RectF rectF2, boolean z) {
        CameraLog.m12954a("OneCameraImpl", "setFocusMode, mCameraRole: " + this.f13522w + ", focusMode: " + OplusGLSurfaceView_13 + ", needTrigger: " + z + ", afRegion: " + rectF + ", aeRegion: " + rectF2);
        if (this.f13440B == null) {
            return;
        }
        if (OplusGLSurfaceView_13 != 1) {
            if (OplusGLSurfaceView_13 == 3) {
                if (z) {
                    mo13078c(CaptureRequest.CONTROL_AF_TRIGGER, (CaptureRequest.Key) 0);
                }
                m13175b((CameraParameter.PreviewKey<CameraParameter.PreviewKey<Integer>>) CameraParameter.FOCUS_MODE, (CameraParameter.PreviewKey<Integer>) 2);
            } else if (OplusGLSurfaceView_13 == 4) {
                m13175b((CameraParameter.PreviewKey<CameraParameter.PreviewKey<Integer>>) CameraParameter.FOCUS_MODE, (CameraParameter.PreviewKey<Integer>) 1);
            }
        } else if (z) {
            m13175b((CameraParameter.PreviewKey<CameraParameter.PreviewKey<Integer>>) CameraParameter.FOCUS_MODE, (CameraParameter.PreviewKey<Integer>) 3);
        } else {
            m13175b((CameraParameter.PreviewKey<CameraParameter.PreviewKey<Integer>>) CameraParameter.FOCUS_MODE, (CameraParameter.PreviewKey<Integer>) 4);
        }
        m13175b((CameraParameter.PreviewKey<CameraParameter.PreviewKey<RectF>>) CameraParameter.AF_REGIONS, (CameraParameter.PreviewKey<RectF>) rectF);
        m13175b((CameraParameter.PreviewKey<CameraParameter.PreviewKey<RectF>>) CameraParameter.AE_REGIONS, (CameraParameter.PreviewKey<RectF>) rectF2);
        if (AEAFHelp.m11153a().equals(rectF2)) {
            mo13078c(CaptureRequest.CONTROL_AE_REGIONS, (CaptureRequest.Key) AEAFHelp.m11154b());
        }
        if (AEAFHelp.m11153a().equals(rectF)) {
            mo13078c(CaptureRequest.CONTROL_AF_REGIONS, (CaptureRequest.Key) AEAFHelp.m11154b());
        }
        m13172a(this.f13476al, 0);
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: IntrinsicsJvm.kt_4 */
    public void mo13068b(OplusMeteringRectangle c2699i) {
        if (this.f13440B != null) {
            Pair pairM13163a = m13163a("com.oplus.control.af.region", (String) c2699i.m13292a());
            mo13078c((CaptureRequest.Key) pairM13163a.first, (CaptureRequest.Key) pairM13163a.second);
        }
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo13038a(OplusMeteringRectangle c2699i) {
        Pair pairM13163a = m13163a("com.oplus.control.ae.region", (String) c2699i.m13292a());
        mo13078c((CaptureRequest.Key) pairM13163a.first, (CaptureRequest.Key) pairM13163a.second);
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: OplusGLSurfaceView_11 */
    public void mo13116n() {
        mo13078c(CaptureRequest.CONTROL_MODE, (CaptureRequest.Key) 1);
        mo13078c(CaptureRequest.CONTROL_AF_MODE, (CaptureRequest.Key) 1);
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: o */
    public void mo13119o() {
        this.f13515p.mo13242a(new Runnable() { // from class: com.oplus.camera.COUIBaseListPopupWindow_8.COUIBaseListPopupWindow_8.10
            @Override // java.lang.Runnable
            public void run() {
                if (OneCameraImpl.this.f13440B != null) {
                    OneCameraImpl.this.mo13078c(CaptureRequest.CONTROL_AF_TRIGGER, (CaptureRequest.Key) 2);
                    OneCameraImpl c2695e = OneCameraImpl.this;
                    c2695e.m13172a(c2695e.f13476al, 1);
                }
            }
        });
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: IntrinsicsJvm.kt_5 */
    public void mo13082d(int OplusGLSurfaceView_13) {
        CameraLog.m12954a("OneCameraImpl", "cancelAutoFocus, mCameraRole: " + this.f13522w);
        if (!m13207D()) {
            this.f13515p.mo13242a(new Runnable() { // from class: com.oplus.camera.COUIBaseListPopupWindow_8.COUIBaseListPopupWindow_8.11
                @Override // java.lang.Runnable
                public void run() {
                    if (OneCameraImpl.this.f13440B != null) {
                        OneCameraImpl.this.mo13078c(CaptureRequest.CONTROL_AF_TRIGGER, (CaptureRequest.Key) 2);
                        OneCameraImpl c2695e = OneCameraImpl.this;
                        c2695e.m13172a(c2695e.f13476al, 1);
                    }
                }
            });
            mo13078c(CaptureRequest.CONTROL_AF_MODE, (CaptureRequest.Key) Integer.valueOf(OplusGLSurfaceView_13));
            mo13078c(CaptureRequest.CONTROL_AF_REGIONS, (CaptureRequest.Key) AEAFHelp.m11154b());
            mo13068b(new OplusMeteringRectangle(AEAFHelp.m11154b()[0]));
            mo13038a(new OplusMeteringRectangle(AEAFHelp.m11154b()[0]));
        }
        mo13078c(CaptureRequest.CONTROL_MODE, (CaptureRequest.Key) 1);
        mo13078c(CaptureRequest.CONTROL_AE_REGIONS, (CaptureRequest.Key) AEAFHelp.m11154b());
        m13172a(this.f13476al, 0);
        m13215c(OplusGLSurfaceView_13, true);
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: COUIBaseListPopupWindow_8 */
    public void mo13087e(int OplusGLSurfaceView_13) {
        CameraLog.m12954a("OneCameraImpl", "setAISceneMode, mCameraRole: " + this.f13522w + ", enable: " + OplusGLSurfaceView_13);
        Pair pairM13163a = m13163a("com.oplus.ai.scene.app.enable", (String) new int[]{OplusGLSurfaceView_13});
        mo13078c((CaptureRequest.Key) pairM13163a.first, (CaptureRequest.Key) pairM13163a.second);
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo13046a(String str, boolean z, boolean z2) {
        CameraLog.m12954a("OneCameraImpl", "setFilter, filterType: " + str + ", filterOpen: " + z + ", vignette: " + z2);
        m13175b((CameraParameter.PreviewKey<CameraParameter.PreviewKey<String>>) CameraParameter.FILTER_TYPE, (CameraParameter.PreviewKey<String>) str);
        m13175b((CameraParameter.PreviewKey<CameraParameter.PreviewKey<Boolean>>) CameraParameter.FILTER_OPEN, (CameraParameter.PreviewKey<Boolean>) Boolean.valueOf(z));
        m13175b((CameraParameter.PreviewKey<CameraParameter.PreviewKey<Boolean>>) CameraParameter.FILTER_WITHVIGNETTE, (CameraParameter.PreviewKey<Boolean>) Boolean.valueOf(z2));
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: COUIBaseListPopupWindow_12 */
    public void mo13091f(int OplusGLSurfaceView_13) {
        CameraLog.m12954a("OneCameraImpl", "setFrameFlag, frameFlag: " + OplusGLSurfaceView_13);
        m13175b((CameraParameter.PreviewKey<CameraParameter.PreviewKey<Integer>>) CameraParameter.FRAME_FLAG, (CameraParameter.PreviewKey<Integer>) Integer.valueOf(OplusGLSurfaceView_13));
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: COUIBaseListPopupWindow_8 */
    public void mo13089e(boolean z) {
        CameraLog.m12954a("OneCameraImpl", "setCaptureForVideo, enable: " + z);
        m13175b((CameraParameter.PreviewKey<CameraParameter.PreviewKey<Boolean>>) CameraParameter.CAPTURE_FOR_VIDEO, (CameraParameter.PreviewKey<Boolean>) Boolean.valueOf(z));
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: COUIBaseListPopupWindow_12 */
    public void mo13093f(boolean z) {
        CameraLog.m12954a("OneCameraImpl", "setOutCapture, outCapture: " + z);
        m13175b((CameraParameter.PreviewKey<CameraParameter.PreviewKey<Boolean>>) CameraParameter.REAR_MIRROR_ENABLE, (CameraParameter.PreviewKey<Boolean>) Boolean.valueOf(z));
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: COUIBaseListPopupWindow_11 */
    public void mo13097g(boolean z) {
        CameraLog.m12954a("OneCameraImpl", "setStarVideoEnable, mbStarVideoEnable: " + z);
        m13175b((CameraParameter.PreviewKey<CameraParameter.PreviewKey<String>>) CameraParameter.STAR_VIDEO_ENABLE, (CameraParameter.PreviewKey<String>) (z ? "on" : "off"));
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo13055a(boolean z, String str, int[] iArr) {
        CameraLog.m12954a("OneCameraImpl", "setFaceBeautyParam, enable: " + z + ", faceVersion: " + str + ", faceBeautyParam:" + iArr);
        m13175b((CameraParameter.PreviewKey<CameraParameter.PreviewKey<String>>) CameraParameter.FACE_BEAUTY_ENABLE, (CameraParameter.PreviewKey<String>) (z ? "on" : "off"));
        m13175b((CameraParameter.PreviewKey<CameraParameter.PreviewKey<String>>) CameraParameter.FACE_BEAUTY_VERSION, (CameraParameter.PreviewKey<String>) str);
        m13175b((CameraParameter.PreviewKey<CameraParameter.PreviewKey<int[]>>) CameraParameter.FACE_BEAUTY_PARAM, (CameraParameter.PreviewKey<int[]>) iArr);
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo13049a(boolean z, int OplusGLSurfaceView_13, String str) {
        CameraLog.m12954a("OneCameraImpl", "setVideoNeonParam, enable: " + z + ", videoFusionEffect: " + OplusGLSurfaceView_13 + ", videoNeonParams:" + str);
        m13175b((CameraParameter.PreviewKey<CameraParameter.PreviewKey<String>>) CameraParameter.VIDEO_NEON_ENABLE, (CameraParameter.PreviewKey<String>) (z ? "on" : "off"));
        m13175b((CameraParameter.PreviewKey<CameraParameter.PreviewKey<Integer>>) CameraParameter.VIDEO_FUSION_EFFECT, (CameraParameter.PreviewKey<Integer>) Integer.valueOf(OplusGLSurfaceView_13));
        m13175b((CameraParameter.PreviewKey<CameraParameter.PreviewKey<String>>) CameraParameter.VIDEO_NEON_PARAMS, (CameraParameter.PreviewKey<String>) str);
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: COUIBaseListPopupWindow_10 */
    public void mo13100h(boolean z) {
        CameraLog.m12954a("OneCameraImpl", "enableDeRedEye, enable: " + z);
        m13175b((CameraParameter.PreviewKey<CameraParameter.PreviewKey<String>>) CameraParameter.FACE_DERED_EYE, (CameraParameter.PreviewKey<String>) (z ? "on" : "off"));
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo13054a(boolean z, String str, long OplusGLSurfaceView_15) {
        CameraLog.m12954a("OneCameraImpl", "enableBurstShot, enable: " + z + ", path: " + str);
        m13175b((CameraParameter.PreviewKey<CameraParameter.PreviewKey<String>>) CameraParameter.BURST_SHOT_ENABLE, (CameraParameter.PreviewKey<String>) (z ? "on" : "off"));
        m13175b((CameraParameter.PreviewKey<CameraParameter.PreviewKey<String>>) CameraParameter.BURST_SHOT_PATH, (CameraParameter.PreviewKey<String>) str);
        m13175b((CameraParameter.PreviewKey<CameraParameter.PreviewKey<Long>>) CameraParameter.BURST_SHOT_FLAG_ID, (CameraParameter.PreviewKey<Long>) Long.valueOf(OplusGLSurfaceView_15));
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo13051a(boolean z, Bundle bundle) {
        CameraLog.m12954a("OneCameraImpl", "setWaterCaptureParam, enable: " + z);
        m13175b((CameraParameter.PreviewKey<CameraParameter.PreviewKey<String>>) CameraParameter.WATERMARK_CAPTURE_ENABLE, (CameraParameter.PreviewKey<String>) (z ? "on" : "off"));
        m13175b((CameraParameter.PreviewKey<CameraParameter.PreviewKey<Bundle>>) CameraParameter.WATERMARK_PARAM, (CameraParameter.PreviewKey<Bundle>) bundle);
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: COUIBaseListPopupWindow_11 */
    public void mo13095g(int OplusGLSurfaceView_13) {
        Pair pairM13163a = m13163a("com.oplus.capture.request.picture.size.scale", (String) new int[]{OplusGLSurfaceView_13});
        mo13078c((CaptureRequest.Key) pairM13163a.first, (CaptureRequest.Key) pairM13163a.second);
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: p */
    public void mo13123p(int OplusGLSurfaceView_13) {
        CameraLog.m12954a("OneCameraImpl", "setPIEnableList, mCameraRole: " + this.f13522w + ", enableList: " + Integer.toBinaryString(OplusGLSurfaceView_13));
        Pair pairM13163a = m13163a("com.oplus.camera.pi.enable_list", (String) new int[]{OplusGLSurfaceView_13});
        mo13078c((CaptureRequest.Key) pairM13163a.first, (CaptureRequest.Key) pairM13163a.second);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m13214b(String str, int OplusGLSurfaceView_13) {
        CameraLog.m12954a("OneCameraImpl", "setFaceBeautyLevel, cameraType: " + str + ", level: " + OplusGLSurfaceView_13);
        Pair pairM13163a = m13163a("com.oplus.facebeauty.level", (String) new int[]{OplusGLSurfaceView_13});
        m13213a(str, (CaptureRequest.Key) pairM13163a.first, (CaptureRequest.Key) pairM13163a.second);
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: COUIBaseListPopupWindow_10 */
    public void mo13099h(int OplusGLSurfaceView_13) {
        CameraLog.m12954a("OneCameraImpl", "setFaceBeautyLevel, mCameraRole: " + this.f13522w + ", level: " + OplusGLSurfaceView_13);
        Pair pairM13163a = m13163a("com.oplus.facebeauty.level", (String) new int[]{OplusGLSurfaceView_13});
        mo13078c((CaptureRequest.Key) pairM13163a.first, (CaptureRequest.Key) pairM13163a.second);
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo13044a(String str, int OplusGLSurfaceView_13) {
        CameraLog.m12954a("OneCameraImpl", "setMakeupParam, makeType: " + str + ", makeValue: " + OplusGLSurfaceView_13);
        m13175b((CameraParameter.PreviewKey<CameraParameter.PreviewKey<String>>) CameraParameter.MAKEUP_TYPE, (CameraParameter.PreviewKey<String>) str);
        m13175b((CameraParameter.PreviewKey<CameraParameter.PreviewKey<Integer>>) CameraParameter.MAKEUP_VALUE, (CameraParameter.PreviewKey<Integer>) Integer.valueOf(OplusGLSurfaceView_13));
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo13058a(int[] iArr) {
        CameraLog.m12954a("OneCameraImpl", "setCustomBeautyValues, mCameraRole: " + this.f13522w + ", values: " + Arrays.toString(iArr));
        Pair pairM13163a = m13163a("com.oplus.facebeauty.custom", (String) iArr);
        mo13078c((CaptureRequest.Key) pairM13163a.first, (CaptureRequest.Key) pairM13163a.second);
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: t */
    public void mo13135t(int OplusGLSurfaceView_13) {
        CameraLog.m12954a("OneCameraImpl", "setApertureValue, mCameraRole: " + this.f13522w + ", value: " + OplusGLSurfaceView_13);
        Pair pairM13163a = m13163a("com.oplus.iris.aperture.value", (String) new int[]{OplusGLSurfaceView_13});
        mo13078c((CaptureRequest.Key) pairM13163a.first, (CaptureRequest.Key) pairM13163a.second);
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: IntrinsicsJvm.kt_3 */
    public void mo13079c(String str) {
        CameraLog.m12954a("OneCameraImpl", "setHDRMode, hdrMode: " + str);
        m13175b((CameraParameter.PreviewKey<CameraParameter.PreviewKey<String>>) CameraParameter.CAPTURE_HDR_MODE, (CameraParameter.PreviewKey<String>) str);
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: q */
    public void mo13127q(boolean z) {
        CameraLog.m12954a("OneCameraImpl", "setVHdrRequest, mCameraRole: " + this.f13522w + ", enable: " + z);
        if (z) {
            Pair pairM13163a = m13163a("com.mediatek.hdrfeature.hdrMode", (String) new int[]{this.f13458T});
            mo13078c((CaptureRequest.Key) pairM13163a.first, (CaptureRequest.Key) pairM13163a.second);
        }
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: IntrinsicsJvm.kt_4 */
    public void mo13071b(final boolean z, boolean z2) {
        CameraLog.m12954a("OneCameraImpl", "setAutoExposureLock, mCameraRole: " + this.f13522w + ", aeLock: " + z);
        mo13078c(CaptureRequest.CONTROL_AE_LOCK, (CaptureRequest.Key) Boolean.valueOf(z));
        if (z && !Util.m24169C()) {
            mo13078c(CameraMetadataKey.f13315bA, (CaptureRequest.Key<Integer>) Integer.valueOf(z2 ? 1 : 0));
        }
        this.f13515p.mo13242a(new Runnable() { // from class: com.oplus.camera.COUIBaseListPopupWindow_8.COUIBaseListPopupWindow_8.2
            @Override // java.lang.Runnable
            public void run() {
                OneCameraImpl.this.f13451M = z;
            }
        });
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: OplusGLSurfaceView_14 */
    public void mo13112l(boolean z) {
        CameraLog.m12954a("OneCameraImpl", "setLongShotEnable, mCameraRole: " + this.f13522w + ", enable: " + z);
        Pair pairM13163a = m13163a("com.oplus.longshot.enable", (String) new int[]{z ? 1 : 0});
        mo13078c((CaptureRequest.Key) pairM13163a.first, (CaptureRequest.Key) pairM13163a.second);
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: OplusGLSurfaceView_5 */
    public void mo13108k(int OplusGLSurfaceView_13) {
        CameraLog.m12954a("OneCameraImpl", "setAheadCaptureFrameNum, num: " + OplusGLSurfaceView_13);
        Pair pairM13163a = m13163a("com.oplus.ahead.capture.frame.num", (String) new int[]{OplusGLSurfaceView_13});
        mo13078c((CaptureRequest.Key) pairM13163a.first, (CaptureRequest.Key) pairM13163a.second);
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: OplusGLSurfaceView_14 */
    public void mo13111l(int OplusGLSurfaceView_13) {
        Pair pairM13163a = m13163a("com.oplus.ahead.night.ev0", (String) new int[]{OplusGLSurfaceView_13});
        mo13078c((CaptureRequest.Key) pairM13163a.first, (CaptureRequest.Key) pairM13163a.second);
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: OplusGLSurfaceView_6 */
    public void mo13115m(boolean z) {
        if (this.f13440B == null) {
            return;
        }
        CameraLog.m12954a("OneCameraImpl", "setZsl, zsl: " + z);
        if (Util.m24169C()) {
            if (Build.VERSION.SDK_INT >= 26) {
                mo13078c(CaptureRequest.CONTROL_ENABLE_ZSL, (CaptureRequest.Key) Boolean.valueOf(z));
            }
        } else {
            Pair pairM13163a = m13163a("com.mediatek.control.capture.zsl.mode", (String) new byte[]{z ? (byte) 1 : (byte) 0});
            mo13078c((CaptureRequest.Key) pairM13163a.first, (CaptureRequest.Key) pairM13163a.second);
        }
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo13047a(String str, int[] iArr) {
        Pair pairM13163a = m13163a(str, (String) iArr);
        mo13078c((CaptureRequest.Key) pairM13163a.first, (CaptureRequest.Key) pairM13163a.second);
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: IntrinsicsJvm.kt_4 */
    public void mo13069b(String str) {
        CameraLog.m12959b("OneCameraImpl", "setFlashMode, mCameraRole: " + this.f13522w + ", value: " + str);
        if (str == null || this.f13440B == null) {
            return;
        }
        CameraDataCollection.m24685a().m24691a(Util.m24472l(), "flash_mode", str);
        TemperatureProvider c3559c = this.f13470af;
        if (c3559c != null) {
            c3559c.m24665a(str);
        }
        this.f13450L = str;
        char c2 = 65535;
        int iHashCode = str.hashCode();
        if (iHashCode != 3551) {
            if (iHashCode != 109935) {
                if (iHashCode != 3005871) {
                    if (iHashCode == 110547964 && str.equals(CameraParameter.FlashMode.FLASH_TORCH)) {
                        c2 = 3;
                    }
                } else if (str.equals("auto")) {
                    c2 = 2;
                }
            } else if (str.equals("off")) {
                c2 = 1;
            }
        } else if (str.equals("on")) {
            c2 = 0;
        }
        if (c2 == 0) {
            m13175b((CameraParameter.PreviewKey<CameraParameter.PreviewKey<String>>) CameraParameter.FLASH_MODE, (CameraParameter.PreviewKey<String>) "on");
            return;
        }
        if (c2 == 1) {
            m13175b((CameraParameter.PreviewKey<CameraParameter.PreviewKey<String>>) CameraParameter.FLASH_MODE, (CameraParameter.PreviewKey<String>) "off");
        } else if (c2 == 2) {
            m13175b((CameraParameter.PreviewKey<CameraParameter.PreviewKey<String>>) CameraParameter.FLASH_MODE, (CameraParameter.PreviewKey<String>) "auto");
        } else {
            if (c2 != 3) {
                return;
            }
            m13175b((CameraParameter.PreviewKey<CameraParameter.PreviewKey<String>>) CameraParameter.FLASH_MODE, (CameraParameter.PreviewKey<String>) CameraParameter.FlashMode.FLASH_TORCH);
        }
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: IntrinsicsJvm.kt_3 */
    public void mo13080c(boolean z) {
        CameraLog.m12954a("OneCameraImpl", "setFrontModeAutoEnable: " + z);
        mo13078c(CameraMetadataKey.f13347d, (CaptureRequest.Key<Integer>) Integer.valueOf(z ? 1 : 0));
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: IntrinsicsJvm.kt_5 */
    public void mo13084d(boolean z) {
        this.f13452N = z;
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: s */
    public void mo13131s() {
        synchronized (this.f13479z) {
            if (this.f13461W != null) {
                CameraLog.m12959b("OneCameraImpl", "closeImageWriter, mCameraRole: " + this.f13522w);
                this.f13461W.close();
                this.f13461W = null;
            }
        }
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: IntrinsicsJvm.kt_3 */
    public <T> void mo13078c(CaptureRequest.Key key, T t) {
        if (this.f13520u != 5) {
            CameraLog.m12967f("OneCameraImpl", "set, illegal state: " + this.f13520u + ", key: " + key.getName() + ", value: " + t);
            return;
        }
        CameraDevice cameraDevice = this.f13440B;
        if (cameraDevice != null) {
            cameraDevice.setParameter((CaptureRequest.Key<CaptureRequest.Key>) key, (CaptureRequest.Key) t);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public <T> void m13213a(String str, CaptureRequest.Key key, T t) {
        if (this.f13520u != 5) {
            CameraLog.m12967f("OneCameraImpl", "set, illegal state: " + this.f13520u + ", key: " + key.getName() + ", value: " + t);
            return;
        }
        CameraDevice cameraDevice = this.f13440B;
        if (cameraDevice != null) {
            cameraDevice.setParameter(str, (CaptureRequest.Key<CaptureRequest.Key>) key, (CaptureRequest.Key) t);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: IntrinsicsJvm.kt_4 */
    public <T> void m13175b(CameraParameter.PreviewKey<T> previewKey, T t) {
        if (this.f13520u != 5) {
            CameraLog.m12967f("OneCameraImpl", "set, illegal state: " + this.f13520u + ", previewKey: " + previewKey.getKeyName() + ", value: " + t);
            return;
        }
        CameraDevice cameraDevice = this.f13440B;
        if (cameraDevice != null) {
            cameraDevice.setParameter((CameraParameter.PreviewKey<CameraParameter.PreviewKey<T>>) previewKey, (CameraParameter.PreviewKey<T>) t);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private <T> void m13180c(CameraParameter.PreviewKey previewKey, T t) {
        if (this.f13520u != 5) {
            CameraLog.m12967f("OneCameraImpl", "setZoomTarget, illegal state: " + this.f13520u + ", previewKey: " + previewKey.getKeyName() + ", value: " + t);
            return;
        }
        CameraDevice cameraDevice = this.f13440B;
        if (cameraDevice != null) {
            cameraDevice.setParameter((CameraParameter.PreviewKey<CameraParameter.PreviewKey>) previewKey, (CameraParameter.PreviewKey) t);
        }
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: PlatformImplementations.kt_3 */
    public int[] mo13061a(CaptureResult.Key<?> key, CaptureResult captureResult) {
        Object objM13005a = CameraMetadataKey.m13005a(captureResult, key);
        if (objM13005a == null || !(objM13005a instanceof int[])) {
            return null;
        }
        int[] iArr = (int[]) objM13005a;
        if (iArr.length > 0) {
            return iArr;
        }
        return null;
    }

    /* renamed from: COUIBaseListPopupWindow_10 */
    public void m13216h(String str) {
        CameraLog.m12954a("OneCameraImpl", "startFaceDetection, cameraType: " + str + ", mDeviceState: " + this.f13520u);
        CameraLog.m12952a("startFaceDetection");
        m13213a(str, CaptureRequest.STATISTICS_FACE_DETECT_MODE, (CaptureRequest.Key) 1);
        CameraLog.m12958b("startFaceDetection");
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: OplusGLSurfaceView_5 */
    public void mo13107k() {
        CameraLog.m12954a("OneCameraImpl", "startFaceDetection, mCameraRole: " + this.f13522w + ", mDeviceState: " + this.f13520u);
        CameraLog.m12952a("startFaceDetection");
        mo13078c(CaptureRequest.STATISTICS_FACE_DETECT_MODE, (CaptureRequest.Key) 1);
        CameraLog.m12958b("startFaceDetection");
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: o */
    public void mo13121o(boolean z) {
        CameraLog.m12954a("OneCameraImpl", "setMTKTrackFocusState, isTrackFocusOpen: " + z);
        Pair pairM13163a = m13163a("com.oplus.track.focus.config.enable", (String) new int[]{z ? 1 : 0});
        mo13078c((CaptureRequest.Key) pairM13163a.first, (CaptureRequest.Key) pairM13163a.second);
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo13035a(OneCamera.IntrinsicsJvm.kt_3 cVar) {
        CameraLog.m12954a("OneCameraImpl", "setRepeatingRequest, mCameraRole: " + this.f13522w + ", previewCallback: " + cVar + ", mDeviceState: " + this.f13520u);
        if (cVar != null) {
            this.f13473ai = cVar;
        }
        m13172a(this.f13476al, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public void m13172a(final CameraPreviewCallback cameraPreviewCallback, int OplusGLSurfaceView_13) {
        CameraRequestTag c2693c;
        if (this.f13520u != 5 || ((c2693c = this.f13462X) != null && c2693c.f13408c)) {
            CameraLog.m12967f("OneCameraImpl", "startPreview, illegal state: " + this.f13520u);
            return;
        }
        this.f13515p.mo13242a(new Runnable() { // from class: com.oplus.camera.COUIBaseListPopupWindow_8.COUIBaseListPopupWindow_8.3
            @Override // java.lang.Runnable
            public void run() {
                if (OneCameraImpl.this.f13520u != 5 || OneCameraImpl.this.f13440B == null) {
                    return;
                }
                OneCameraImpl.this.m13171a(cameraPreviewCallback);
            }
        });
    }

    /* renamed from: P */
    private void m13160P() {
        CameraLog.m12952a("builderOutputSurfaces");
        if (this.f13446H == null) {
            this.f13446H = new LinkedHashMap<>();
        }
        OneCamera.IntrinsicsJvm.kt_5 dVar = this.f13443E;
        if (dVar != null) {
            dVar.mo11046a(this.f13446H, this.f13522w);
        }
        CameraLog.m12958b("builderOutputSurfaces");
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private <T> Pair<CaptureRequest.Key, T> m13163a(String str, T t) {
        return new Pair<>(new CaptureRequest.Key(str, t.getClass()), t);
    }

    /* renamed from: Q */
    private void m13161Q() {
        CameraLog.m12954a("OneCameraImpl", "releaseResource, mCameraRole: " + this.f13522w);
        CameraLog.m12952a("releaseResource");
        LinkedHashMap<String, Surface> linkedHashMap = this.f13446H;
        if (linkedHashMap != null) {
            linkedHashMap.clear();
        }
        CameraLog.m12958b("releaseResource");
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: OplusGLSurfaceView_13 */
    public void mo13103i(boolean z) {
        mo13078c(CaptureRequest.CONTROL_AWB_MODE, (CaptureRequest.Key) 1);
        if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_MMCAMERA_PROFESSIONAL)) {
            Pair pairM13163a = m13163a("org.codeaurora.qcamera3.manualWB.partial_mwb_mode", (String) new int[]{0});
            mo13078c((CaptureRequest.Key) pairM13163a.first, (CaptureRequest.Key) pairM13163a.second);
        }
        if (z) {
            m13172a(this.f13476al, 0);
        }
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo13028a(int OplusGLSurfaceView_13, boolean z) {
        if (Util.m24169C() && CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_MMCAMERA_PROFESSIONAL)) {
            Pair pairM13163a = m13163a("org.codeaurora.qcamera3.manualWB.partial_mwb_mode", (String) new int[]{1});
            mo13078c((CaptureRequest.Key) pairM13163a.first, (CaptureRequest.Key) pairM13163a.second);
            Pair pairM13163a2 = m13163a("org.codeaurora.qcamera3.manualWB.color_temperature", (String) new int[]{OplusGLSurfaceView_13});
            mo13078c((CaptureRequest.Key) pairM13163a2.first, (CaptureRequest.Key) pairM13163a2.second);
        }
        m13175b((CameraParameter.PreviewKey<CameraParameter.PreviewKey<int[]>>) CameraParameter.COLOR_TEMPERATURE, (CameraParameter.PreviewKey<int[]>) new int[]{OplusGLSurfaceView_13});
        if (z) {
            m13172a(this.f13476al, 0);
        }
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: OplusGLSurfaceView_13 */
    public void mo13102i(int OplusGLSurfaceView_13) {
        Pair pairM13163a = m13163a("org.codeaurora.qcamera3.exposure_metering.exposure_metering_mode", (String) new int[]{OplusGLSurfaceView_13});
        mo13078c((CaptureRequest.Key) pairM13163a.first, (CaptureRequest.Key) pairM13163a.second);
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: IntrinsicsJvm.kt_4 */
    public void mo13065b(int OplusGLSurfaceView_13, boolean z) {
        if (OplusGLSurfaceView_13 == -1) {
            this.f13453O = true;
        } else {
            this.f13453O = false;
            if (!CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_MMCAMERA_PROFESSIONAL)) {
                mo13078c(CaptureRequest.CONTROL_AE_MODE, (CaptureRequest.Key) 0);
            }
        }
        if (this.f13453O && CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_MMCAMERA_PROFESSIONAL)) {
            if (this.f13454P) {
                mo13078c(CameraMetadataKey.f13359p, (CaptureRequest.Key<int[]>) new int[]{this.f13460V});
                mo13078c(CameraMetadataKey.f13360q, (CaptureRequest.Key<long[]>) new long[]{0});
            }
        } else if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_MMCAMERA_PROFESSIONAL)) {
            if (!this.f13454P) {
                mo13078c(CaptureRequest.CONTROL_AE_MODE, (CaptureRequest.Key) 0);
                mo13078c(CameraMetadataKey.f13359p, (CaptureRequest.Key<int[]>) new int[]{2});
            } else {
                mo13078c(CaptureRequest.CONTROL_AE_MODE, (CaptureRequest.Key) 1);
                mo13078c(CameraMetadataKey.f13359p, (CaptureRequest.Key<int[]>) new int[]{0});
                this.f13460V = 0;
            }
            mo13078c(CameraMetadataKey.f13360q, (CaptureRequest.Key<long[]>) new long[]{OplusGLSurfaceView_13});
        }
        int iM13286u = mo13086e().m13286u();
        CameraLog.m12959b("OneCameraImpl", "setIso, mCameraRole: " + this.f13522w + ", iso: " + OplusGLSurfaceView_13 + ", maxISOValue: " + iM13286u);
        if (OplusGLSurfaceView_13 > iM13286u) {
            mo13078c(CaptureRequest.CONTROL_POST_RAW_SENSITIVITY_BOOST, (CaptureRequest.Key) Integer.valueOf((int) ((OplusGLSurfaceView_13 / iM13286u) * 100.0f)));
            mo13078c(CaptureRequest.SENSOR_SENSITIVITY, (CaptureRequest.Key) Integer.valueOf(iM13286u));
        } else {
            mo13078c(CaptureRequest.SENSOR_SENSITIVITY, (CaptureRequest.Key) Integer.valueOf(OplusGLSurfaceView_13));
            mo13078c(CaptureRequest.CONTROL_POST_RAW_SENSITIVITY_BOOST, (CaptureRequest.Key) 100);
        }
        if (z) {
            m13172a(this.f13476al, 0);
        }
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo13031a(long OplusGLSurfaceView_15, boolean z) {
        CameraLog.m12954a("OneCameraImpl", "setExposureTime, mCameraRole: " + this.f13522w + ", exposureTime: " + OplusGLSurfaceView_15);
        if (OplusGLSurfaceView_15 == -1) {
            this.f13454P = true;
        } else {
            this.f13454P = false;
            if (!CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_MMCAMERA_PROFESSIONAL)) {
                mo13078c(CaptureRequest.CONTROL_AE_MODE, (CaptureRequest.Key) 0);
            }
        }
        if (this.f13454P && CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_MMCAMERA_PROFESSIONAL)) {
            if (this.f13453O) {
                mo13078c(CameraMetadataKey.f13359p, (CaptureRequest.Key<int[]>) new int[]{this.f13460V});
                mo13078c(CameraMetadataKey.f13360q, (CaptureRequest.Key<long[]>) new long[]{0});
            }
        } else if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_MMCAMERA_PROFESSIONAL)) {
            if (!this.f13453O) {
                mo13078c(CaptureRequest.CONTROL_AE_MODE, (CaptureRequest.Key) 0);
                mo13078c(CameraMetadataKey.f13359p, (CaptureRequest.Key<int[]>) new int[]{2});
            } else {
                mo13078c(CaptureRequest.CONTROL_AE_MODE, (CaptureRequest.Key) 1);
                mo13078c(CameraMetadataKey.f13359p, (CaptureRequest.Key<int[]>) new int[]{1});
                this.f13460V = 1;
            }
            mo13078c(CameraMetadataKey.f13360q, (CaptureRequest.Key<long[]>) new long[]{OplusGLSurfaceView_15});
            mo13078c(CameraMetadataKey.f13360q, (CaptureRequest.Key<long[]>) new long[]{OplusGLSurfaceView_15});
        }
        mo13078c(CaptureRequest.SENSOR_EXPOSURE_TIME, (CaptureRequest.Key) Long.valueOf(OplusGLSurfaceView_15));
        if (z) {
            m13172a(this.f13476al, 0);
        }
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo13056a(boolean z, boolean z2) {
        m13175b((CameraParameter.PreviewKey<CameraParameter.PreviewKey<Boolean>>) CameraParameter.FOCUS_PEAKING_ENABLE, (CameraParameter.PreviewKey<Boolean>) Boolean.valueOf(z));
        if (z2) {
            m13172a(this.f13476al, 0);
        }
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: r */
    public void mo13128r() {
        m13175b((CameraParameter.PreviewKey<CameraParameter.PreviewKey<String>>) CameraParameter.FLASH_MODE, (CameraParameter.PreviewKey<String>) "off");
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: OplusGLSurfaceView_15 */
    public void mo13105j(boolean z) {
        if (this.f13456R == 0 && this.f13450L.equals("on")) {
            m13175b((CameraParameter.PreviewKey<CameraParameter.PreviewKey<String>>) CameraParameter.FLASH_MODE, (CameraParameter.PreviewKey<String>) "on");
        } else if (this.f13456R == 0 && this.f13450L.equals("auto")) {
            m13175b((CameraParameter.PreviewKey<CameraParameter.PreviewKey<String>>) CameraParameter.FLASH_MODE, (CameraParameter.PreviewKey<String>) "auto");
        }
        if (z) {
            m13172a(this.f13476al, 0);
        }
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: OplusGLSurfaceView_15 */
    public void mo13104j(int OplusGLSurfaceView_13) {
        Pair pairM13163a = m13163a("com.oplus.slogan.enable", (String) new int[]{OplusGLSurfaceView_13});
        mo13078c((CaptureRequest.Key) pairM13163a.first, (CaptureRequest.Key) pairM13163a.second);
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo13033a(Bundle bundle) {
        if (this.f13440B != null) {
            m13175b((CameraParameter.PreviewKey<CameraParameter.PreviewKey<Bundle>>) CameraParameter.WATERMARK_PARAM, (CameraParameter.PreviewKey<Bundle>) bundle);
        }
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo13030a(long OplusGLSurfaceView_15) {
        mo13078c(CameraMetadataKey.f13238D, (CaptureRequest.Key<Long>) Long.valueOf(OplusGLSurfaceView_15));
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo13020a(byte b2) {
        CameraLog.m12959b("OneCameraImpl", "setMovieLogEnable, mCameraRole: " + this.f13522w + ", enable: " + ((int) b2));
        m13175b((CameraParameter.PreviewKey<CameraParameter.PreviewKey<Byte>>) CameraParameter.MOVIE_LOG_ENABLE, (CameraParameter.PreviewKey<Byte>) Byte.valueOf(b2));
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: IntrinsicsJvm.kt_4 */
    public void mo13062b(byte b2) {
        CameraLog.m12959b("OneCameraImpl", "setMovieHdrEnable, mCameraRole: " + this.f13522w + ", enable: " + ((int) b2));
        m13175b((CameraParameter.PreviewKey<CameraParameter.PreviewKey<Byte>>) CameraParameter.MOVIE_HDR_ENABLE, (CameraParameter.PreviewKey<Byte>) Byte.valueOf(b2));
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: OplusGLSurfaceView_5 */
    public void mo13109k(boolean z) {
        CameraLog.m12954a("OneCameraImpl", "setMirror, mCameraRole: " + this.f13522w + ", enable: " + z);
        Pair pairM13163a = m13163a(Util.m24169C() ? "com.oplus.mirror.enable" : "com.mediatek.control.capture.flipmode", (String) new int[]{z ? 1 : 0});
        mo13078c((CaptureRequest.Key) pairM13163a.first, (CaptureRequest.Key) pairM13163a.second);
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: IntrinsicsJvm.kt_5 */
    public boolean mo13085d(String str) {
        CameraLog.m12954a("OneCameraImpl", "isCloseStreamTaskFinished, mCameraRole: " + this.f13522w + ", getSurfaceType: " + this.f13464Z.m13221c() + ", isFinished: " + this.f13464Z.m13219a() + ", isNeedWaitCloseStream: " + this.f13464Z.m13220b());
        return (str.equals(this.f13464Z.m13221c()) && !this.f13464Z.m13219a() && this.f13464Z.m13220b()) ? false : true;
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo13045a(String str, boolean z) {
        CameraRequestTag c2693c;
        CameraLog.m12954a("OneCameraImpl", "closeCaptureStream, type: " + str + ", restartPreview: " + z);
        if ("type_still_capture_raw".equals(str) && (c2693c = this.f13462X) != null) {
            c2693c.f13408c = false;
        }
        if (z) {
            m13172a(this.f13476al, 0);
        }
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: OplusGLSurfaceView_15 */
    public boolean mo13106j() {
        CameraDevice cameraDevice = this.f13440B;
        if (cameraDevice == null) {
            return false;
        }
        return cameraDevice.notifyLastCaptureFrame();
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: OplusGLSurfaceView_6 */
    public void mo13114m(int OplusGLSurfaceView_13) {
        CameraLog.m12954a("OneCameraImpl", "setLongExposuereScene, scene: " + OplusGLSurfaceView_13);
        mo13078c(CameraMetadataKey.f13235A, (CaptureRequest.Key<Integer>) Integer.valueOf(OplusGLSurfaceView_13));
    }

    /* compiled from: OneCameraImpl.java */
    /* renamed from: com.oplus.camera.COUIBaseListPopupWindow_8.COUIBaseListPopupWindow_8$PlatformImplementations.kt_3 */
    private class PlatformImplementations.kt_3 implements Runnable {

        /* renamed from: IntrinsicsJvm.kt_4 */
        private String f13500b;

        /* renamed from: IntrinsicsJvm.kt_3 */
        private boolean f13501c;

        /* renamed from: IntrinsicsJvm.kt_5 */
        private boolean f13502d;

        /* renamed from: COUIBaseListPopupWindow_8 */
        private boolean f13503e;

        /* renamed from: COUIBaseListPopupWindow_12 */
        private boolean f13504f;

        private PlatformImplementations.kt_3() {
            this.f13500b = null;
            this.f13501c = false;
            this.f13502d = false;
            this.f13503e = false;
            this.f13504f = true;
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public void m13218a(boolean z, boolean z2) {
            this.f13503e = z;
            this.f13504f = z2;
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public void m13217a(boolean z) {
            CameraLog.m12954a("OneCameraImpl", "setFinish, mCameraRole: " + OneCameraImpl.this.f13522w + ", finish: " + z);
            this.f13502d = z;
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public boolean m13219a() {
            return this.f13502d;
        }

        /* renamed from: IntrinsicsJvm.kt_4 */
        public boolean m13220b() {
            return this.f13504f;
        }

        /* renamed from: IntrinsicsJvm.kt_3 */
        public String m13221c() {
            return this.f13500b;
        }

        @Override // java.lang.Runnable
        public void run() {
            CameraLog.m12954a("OneCameraImpl", "CloseStreamTask, mCameraRole: " + OneCameraImpl.this.f13522w + ", mOutSurfaceMap: " + OneCameraImpl.this.f13446H.get(this.f13500b) + ", mSurfaceType: " + this.f13500b + ", mbWillCloseSession:" + this.f13503e);
            m13217a(true);
        }
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: OplusGLSurfaceView_11 */
    public void mo13118n(boolean z) {
        this.f13464Z.m13218a(true, z);
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: COUIBaseListPopupWindow_8 */
    public void mo13088e(String str) {
        CameraLog.m12954a("OneCameraImpl", "closeStream, mCameraRole: " + this.f13522w + ", type: " + str);
        if (this.f13520u == 7 || this.f13520u == 5) {
            this.f13515p.post(this.f13464Z);
        }
        this.f13468ad.open();
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: OplusGLSurfaceView_11 */
    public void mo13117n(int OplusGLSurfaceView_13) {
        Pair pairM13163a = m13163a("com.oplus.camera.3d.api.state", (String) new int[]{OplusGLSurfaceView_13});
        mo13078c((CaptureRequest.Key) pairM13163a.first, (CaptureRequest.Key) pairM13163a.second);
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo13021a(float COUIBaseListPopupWindow_12) {
        CameraLog.m12954a("OneCameraImpl", "setBokehLevel, mCameraRole: " + this.f13522w + ", level: " + COUIBaseListPopupWindow_12);
        Pair pairM13163a = m13163a("com.oplus.bokeh.level", (String) new float[]{COUIBaseListPopupWindow_12});
        mo13078c((CaptureRequest.Key) pairM13163a.first, (CaptureRequest.Key) pairM13163a.second);
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: o */
    public void mo13120o(int OplusGLSurfaceView_13) {
        Pair pairM13163a = m13163a("com.oplus.supernight.mode", (String) new int[]{OplusGLSurfaceView_13});
        mo13078c((CaptureRequest.Key) pairM13163a.first, (CaptureRequest.Key) pairM13163a.second);
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: q */
    public void mo13126q(int OplusGLSurfaceView_13) {
        Pair pairM13163a = m13163a(Util.m24169C() ? "com.oplus.rear.remosaic.enable" : "com.mediatek.control.capture.remosaicenable", (String) new int[]{OplusGLSurfaceView_13});
        mo13078c((CaptureRequest.Key) pairM13163a.first, (CaptureRequest.Key) pairM13163a.second);
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: r */
    public void mo13129r(int OplusGLSurfaceView_13) {
        mo13078c(CameraMetadataKey.f13280aS, (CaptureRequest.Key<int[]>) new int[]{OplusGLSurfaceView_13});
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: s */
    public void mo13132s(int OplusGLSurfaceView_13) {
        CameraLog.m12954a("OneCameraImpl", "setCaptureRaw10, format: " + OplusGLSurfaceView_13);
        mo13078c(CameraMetadataKey.f13281aT, (CaptureRequest.Key<int[]>) new int[]{OplusGLSurfaceView_13});
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: u */
    public void mo13137u(int OplusGLSurfaceView_13) {
        CameraLog.m12954a("OneCameraImpl", "setBracketMode, mCameraRole: " + this.f13522w + ", mode: " + OplusGLSurfaceView_13);
        m13175b((CameraParameter.PreviewKey<CameraParameter.PreviewKey<int[]>>) CameraParameter.PREVIEW_BRACKET_MODE, (CameraParameter.PreviewKey<int[]>) new int[]{OplusGLSurfaceView_13});
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: v */
    public void mo13141v(int OplusGLSurfaceView_13) {
        CameraLog.m12959b("OneCameraImpl", "updateAsdSceneValue, mCameraRole: " + this.f13522w + ", value: " + OplusGLSurfaceView_13);
        mo13078c(CameraMetadataKey.f13345bz, (CaptureRequest.Key<Integer>) Integer.valueOf(OplusGLSurfaceView_13));
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: r */
    public void mo13130r(boolean z) {
        CameraLog.m12954a("OneCameraImpl", "setRearAicolorEnable, mCameraRole: " + this.f13522w + ", enable: " + z);
        Pair pairM13163a = m13163a("com.oplus.aicolor.rear.enable", (String) new int[]{z ? 1 : 0});
        mo13078c((CaptureRequest.Key) pairM13163a.first, (CaptureRequest.Key) pairM13163a.second);
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: s */
    public void mo13133s(boolean z) {
        CameraLog.m12954a("OneCameraImpl", "setVideoNeonEnable, mCameraRole: " + this.f13522w + ", enable: " + z);
        mo13078c(CameraMetadataKey.f13318bD, (CaptureRequest.Key<int[]>) new int[]{z ? 1 : 0});
        m13175b((CameraParameter.PreviewKey<CameraParameter.PreviewKey<String>>) CameraParameter.VIDEO_NEON_ENABLE, (CameraParameter.PreviewKey<String>) (z ? "on" : "off"));
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: t */
    public void mo13136t(boolean z) {
        mo13078c(CameraMetadataKey.f13317bC, (CaptureRequest.Key<int[]>) new int[]{z ? 1 : 0});
        m13175b((CameraParameter.PreviewKey<CameraParameter.PreviewKey<String>>) CameraParameter.VIDEO_BLUR_ENABLE, (CameraParameter.PreviewKey<String>) (z ? "on" : "off"));
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: u */
    public void mo13138u(boolean z) {
        CameraLog.m12954a("OneCameraImpl", "setMtkAIShutterEnable, mtkAIShutterEnable: " + z);
        Pair pairM13163a = m13163a("com.mediatek.3afeature.aishutCapture", (String) new int[]{z ? 1 : 0});
        mo13078c((CaptureRequest.Key) pairM13163a.first, (CaptureRequest.Key) pairM13163a.second);
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: IntrinsicsJvm.kt_4 */
    public void mo13072b(byte[] bArr) {
        CameraLog.m12954a("OneCameraImpl", "setTuningDataEnable, mCameraRole: " + this.f13522w + ", type: " + Arrays.toString(bArr));
        mo13078c(CameraMetadataKey.f13276aO, (CaptureRequest.Key<byte[]>) bArr);
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: t */
    public int mo13134t() {
        return this.f13459U;
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: v */
    public CameraRequestTag mo13140v() {
        return this.f13462X;
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: w */
    public void mo13143w() {
        this.f13459U = 0;
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: p */
    public void mo13124p(boolean z) {
        if (z) {
            mo13078c(CameraMetadataKey.f13310aw, (CaptureRequest.Key<int[]>) new int[]{1});
        }
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: v */
    public void mo13142v(boolean z) {
        Pair pairM13163a = m13163a(Util.m24169C() ? "com.oplus.ultra.resolution.mode" : "com.oplus.ultra.high.resolution.enable", (String) new int[]{z ? 1 : 0});
        mo13078c((CaptureRequest.Key) pairM13163a.first, (CaptureRequest.Key) pairM13163a.second);
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo13053a(boolean z, String str) {
        int[] iArrM13262a;
        if (this.f13442D.m13253J() && z && (iArrM13262a = this.f13442D.m13262a(str)) != null) {
            Pair pairM13163a = m13163a("com.mediatek.smvrfeature.smvrMode", (String) iArrM13262a);
            mo13078c((CaptureRequest.Key) pairM13163a.first, (CaptureRequest.Key) pairM13163a.second);
        }
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo13034a(Range range) {
        if (range == null) {
            return;
        }
        CameraLog.m12959b("OneCameraImpl", "setVideoFpsRange: " + range.toString() + ", mCameraRole: " + this.f13522w);
        if (this.f13442D.m13253J()) {
            m13172a(this.f13476al, 0);
        }
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: w */
    public void mo13144w(int OplusGLSurfaceView_13) {
        m13175b((CameraParameter.PreviewKey<CameraParameter.PreviewKey<int[]>>) CameraParameter.PICTURE_EXIF_FLAG, (CameraParameter.PreviewKey<int[]>) new int[]{OplusGLSurfaceView_13});
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: x */
    public void mo13148x(boolean z) {
        if (Util.m24169C()) {
            return;
        }
        CameraLog.m12954a("OneCameraImpl", "setMsnr, mCameraRole: " + this.f13522w + ", enable: " + z);
        Pair pairM13163a = m13163a("com.mediatek.control.capture.singleYuvNr.mode", (String) new int[]{z ? 1 : 0});
        mo13078c((CaptureRequest.Key) pairM13163a.first, (CaptureRequest.Key) pairM13163a.second);
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: x */
    public void mo13146x() {
        ZoomStateCallback c2691a = this.f13478an;
        if (c2691a != null) {
            c2691a.m13003d();
        }
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: y */
    public void mo13151y(boolean z) {
        if (this.f13440B != null) {
            CameraLog.m12954a("OneCameraImpl", "setZoomActive, active: " + z);
            m13175b((CameraParameter.PreviewKey<CameraParameter.PreviewKey<Boolean>>) CameraParameter.ZOOM_ACTIVE, (CameraParameter.PreviewKey<Boolean>) Boolean.valueOf(z));
            mo13035a((OneCamera.IntrinsicsJvm.kt_3) null);
        }
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: IntrinsicsJvm.kt_4 */
    public void mo13063b(float COUIBaseListPopupWindow_12) {
        if (this.f13440B != null) {
            CameraLog.m12954a("OneCameraImpl", "setZoomTarget, zoom: " + COUIBaseListPopupWindow_12);
            m13180c(CameraParameter.ZOOM_TARGET, (CameraParameter.PreviewKey<Float>) new float[]{COUIBaseListPopupWindow_12});
            mo13035a((OneCamera.IntrinsicsJvm.kt_3) null);
        }
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: z */
    public void mo13154z(boolean z) {
        Pair pairM13163a = m13163a("com.oplus.salient.object.detection.enable", (String) new int[]{z ? 1 : 0});
        mo13078c((CaptureRequest.Key) pairM13163a.first, (CaptureRequest.Key) pairM13163a.second);
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo13039a(TemperatureProvider c3559c) {
        this.f13470af = c3559c;
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: COUIBaseListPopupWindow_12 */
    public void mo13092f(String str) {
        CameraLog.m12954a("OneCameraImpl", "setOffsetTime, mCameraRole: " + this.f13522w + ", offsetTime: " + str);
        Pair pairM13163a = m13163a("com.oplus.picture.offset.time", (String) str.getBytes());
        mo13078c((CaptureRequest.Key) pairM13163a.first, (CaptureRequest.Key) pairM13163a.second);
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo13057a(byte[] bArr) {
        mo13078c(CameraMetadataKey.f13261a, (CaptureRequest.Key<byte[]>) bArr);
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: x */
    public void mo13147x(int OplusGLSurfaceView_13) {
        CameraLog.m12959b("OneCameraImpl", "setNightIso, mCameraRole: " + this.f13522w + ", iso: " + OplusGLSurfaceView_13);
        Pair pairM13163a = m13163a("com.oplus.sensor.night.sensitivity", (String) new int[]{OplusGLSurfaceView_13});
        mo13078c((CaptureRequest.Key) pairM13163a.first, (CaptureRequest.Key) pairM13163a.second);
        m13172a(this.f13476al, 0);
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: IntrinsicsJvm.kt_4 */
    public void mo13066b(long OplusGLSurfaceView_15) {
        CameraLog.m12954a("OneCameraImpl", "setNightExposureTime, mCameraRole: " + this.f13522w + ", exposureTime: " + OplusGLSurfaceView_15);
        Pair pairM13163a = m13163a("com.oplus.sensor.night.exposureTime", (String) new long[]{OplusGLSurfaceView_15});
        mo13078c((CaptureRequest.Key) pairM13163a.first, (CaptureRequest.Key) pairM13163a.second);
        m13172a(this.f13476al, 0);
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: IntrinsicsJvm.kt_3 */
    public void mo13077c(long OplusGLSurfaceView_15) {
        CameraLog.m12954a("OneCameraImpl", "setHighPictureProExposureTime, mCameraRole: " + this.f13522w + ", exposureTime: " + OplusGLSurfaceView_15);
        Pair pairM13163a = m13163a("com.oplus.highpicture.professional.exposureTime", (String) new long[]{OplusGLSurfaceView_15});
        mo13078c((CaptureRequest.Key) pairM13163a.first, (CaptureRequest.Key) pairM13163a.second);
        m13172a(this.f13476al, 0);
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: B */
    public void mo13012B(boolean z) {
        CameraLog.m12954a("OneCameraImpl", "setMicrospurEnable, enable: " + z);
        int[] iArr = new int[1];
        iArr[0] = z ? 0 : 2;
        Pair pairM13163a = m13163a("com.oplus.fallback.disableMask", (String) iArr);
        mo13078c((CaptureRequest.Key) pairM13163a.first, (CaptureRequest.Key) pairM13163a.second);
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: y */
    public void mo13150y(int OplusGLSurfaceView_13) {
        Pair pairM13163a = m13163a("com.oplus.highpicture.professional.enable", (String) new int[]{OplusGLSurfaceView_13});
        mo13078c((CaptureRequest.Key) pairM13163a.first, (CaptureRequest.Key) pairM13163a.second);
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: A */
    public void mo13010A(boolean z) {
        CameraLog.m12954a("OneCameraImpl", "setTrackEnable, mCameraRole: " + this.f13522w + ", enable: " + z);
        Pair pairM13163a = m13163a("com.oplus.sod.enable", (String) new byte[]{z ? (byte) 1 : (byte) 0});
        if (this.f13440B == null || !m13239J()) {
            return;
        }
        mo13078c((CaptureRequest.Key) pairM13163a.first, (CaptureRequest.Key) pairM13163a.second);
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: IntrinsicsJvm.kt_4 */
    public void mo13073b(int[] iArr) {
        CameraLog.m12954a("OneCameraImpl", "trackTouchRegion, region: " + Arrays.toString(iArr));
        Pair pairM13163a = m13163a("com.oplus.sod.touch.region", (String) iArr);
        if (this.f13440B == null || !m13239J()) {
            return;
        }
        mo13078c((CaptureRequest.Key) pairM13163a.first, (CaptureRequest.Key) pairM13163a.second);
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: C */
    public void mo13014C(boolean z) {
        CameraLog.m12954a("OneCameraImpl", "setPortraitNeon, enable: " + z);
        Pair pairM13163a = m13163a("com.oplus.portrait.neon", (String) new int[]{z ? 1 : 0});
        mo13078c((CaptureRequest.Key) pairM13163a.first, (CaptureRequest.Key) pairM13163a.second);
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: D */
    public void mo13015D(boolean z) {
        CameraLog.m12954a("OneCameraImpl", "setVideoRetention, enable: " + z);
        Pair pairM13163a = m13163a("com.oplus.video.retention", (String) new int[]{z ? 1 : 0});
        mo13078c((CaptureRequest.Key) pairM13163a.first, (CaptureRequest.Key) pairM13163a.second);
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: z */
    public void mo13153z(int OplusGLSurfaceView_13) {
        CameraLog.m12954a("OneCameraImpl", "setLSDEnable, enable: " + OplusGLSurfaceView_13);
        Pair pairM13163a = m13163a("com.oplus.lsd.enable", (String) new int[]{OplusGLSurfaceView_13});
        mo13078c((CaptureRequest.Key) pairM13163a.first, (CaptureRequest.Key) pairM13163a.second);
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: COUIBaseListPopupWindow_11 */
    public void mo13096g(String str) {
        CameraLog.m12954a("OneCameraImpl", "setGestureCaptureEnable, enable: " + str);
        m13175b((CameraParameter.PreviewKey<CameraParameter.PreviewKey<String>>) CameraParameter.KEY_GESTURE_ENABLE, (CameraParameter.PreviewKey<String>) str);
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: PlatformImplementations.kt_3 */
    public CameraDeviceInfo mo13019a(String str, String str2) {
        CameraLog.m12962c("OneCameraImpl", "getCameraDeviceInfo, modeName: " + str + ", cameraType: " + str2);
        CameraDevice cameraDevice = this.f13440B;
        if (cameraDevice != null) {
            return cameraDevice.getCameraDeviceInfo(str, str2);
        }
        return null;
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: y */
    public CameraDeviceConfig.Builder mo13149y() {
        return this.f13440B.createCameraDeviceConfig();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public void m13171a(CameraPreviewCallback cameraPreviewCallback) {
        CameraLog.m12955a("setRepeatingRequest", "50pv_setRepeatingRequest", CameraConstant.f13119d.longValue());
        LinkedHashMap<String, Surface> linkedHashMap = this.f13446H;
        if (linkedHashMap == null || linkedHashMap.size() == 0) {
            m13160P();
        }
        this.f13440B.startPreview(this.f13446H, cameraPreviewCallback, this.f13516q);
        CameraPerformance.m15189c("launch_request_repeating");
        CameraLog.m12964d("setRepeatingRequest", "50pv_setRepeatingRequest");
    }

    @Override // com.oplus.camera.p141e.OneCameraStateMachine
    /* renamed from: PlatformImplementations.kt_3 */
    protected void mo13212a(CameraDeviceConfig.Builder builder, OneCamera.IntrinsicsJvm.kt_5 dVar, int OplusGLSurfaceView_13) {
        CameraLog.m12967f("OneCameraImpl", "createNewSession");
        if (this.f13440B == null) {
            CameraLog.m12967f("OneCameraImpl", "createNewSession, mCameraDevice is null");
            return;
        }
        CameraDataCollection.m24685a().m24691a(Util.m24472l(), CameraStatisticsUtil.PORTRAIT_CAPTURE_MODE, Integer.valueOf(OplusGLSurfaceView_13));
        m13235B(4);
        m13161Q();
        this.f13466ab.close();
        CameraLog.m12952a("createNewSession");
        this.f13443E = dVar;
        if (mo13060a()) {
            CameraLog.m12967f("OneCameraImpl", "createNewSession, camera device has been closed");
        } else {
            OneCamera.IntrinsicsJvm.kt_5 dVar2 = this.f13443E;
            if (dVar2 != null) {
                dVar2.mo11045a(builder);
            }
            this.f13440B.configure(builder.build());
            CameraPerformance.m15189c("launch_create_session");
        }
        this.f13466ab.block();
        CameraLog.m12958b("createNewSession");
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo13041a(CameraPictureCallback cameraPictureCallback) {
        this.f13475ak = cameraPictureCallback;
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: u */
    public boolean mo13139u() {
        CameraLog.m12962c("OneCameraImpl", "getRecordingLockStatus, mbRecordingLockStatus: " + this.f13472ah);
        return this.f13472ah;
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: w */
    public void mo13145w(boolean z) {
        synchronized (this.f13469ae) {
            CameraLog.m12962c("OneCameraImpl", "setRecordingLockStatus, status: " + z + ", mbRecordingLockStatus: " + this.f13472ah);
            if (this.f13472ah && !z) {
                this.f13469ae.open();
            }
            this.f13472ah = z;
        }
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo13042a(CameraRecordingCallback cameraRecordingCallback, Handler handler) {
        CameraLog.m12962c("OneCameraImpl", "startRecording, mDeviceState: " + this.f13520u);
        this.f13469ae.close();
        mo13145w(true);
        if (5 == this.f13520u) {
            this.f13440B.startRecording(cameraRecordingCallback, handler);
        }
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: z */
    public void mo13152z() {
        CameraLog.m12962c("OneCameraImpl", "stopRecording, mDeviceState: " + this.f13520u);
        if (this.f13440B != null && 5 == this.f13520u) {
            this.f13440B.stopRecording();
        }
        this.f13469ae.open();
        mo13145w(false);
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: A */
    public void mo13008A() {
        CameraLog.m12962c("OneCameraImpl", "pauseRecording, mDeviceState: " + this.f13520u);
        if (5 == this.f13520u) {
            this.f13440B.pauseRecording();
        }
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: B */
    public void mo13011B() {
        CameraLog.m12962c("OneCameraImpl", "resumeRecording, mDeviceState: " + this.f13520u);
        if (5 == this.f13520u) {
            this.f13440B.resumeRecording();
        }
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: PlatformImplementations.kt_3 */
    public Bitmap mo13018a(Bitmap bitmap, CaptureResult captureResult, int OplusGLSurfaceView_13, int i2, int i3) {
        CameraDevice cameraDevice = this.f13440B;
        return cameraDevice != null ? cameraDevice.processBitmap(bitmap, captureResult, OplusGLSurfaceView_13, i2, i3) : bitmap;
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: E */
    public void mo13016E(boolean z) {
        m13175b((CameraParameter.PreviewKey<CameraParameter.PreviewKey<Boolean>>) CameraParameter.KEY_EDGE_FILTER_ENABLE, (CameraParameter.PreviewKey<Boolean>) Boolean.valueOf(z));
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo13059a(String[] strArr) {
        m13175b((CameraParameter.PreviewKey<CameraParameter.PreviewKey<String[]>>) CameraParameter.KEY_EDGE_FILTER_PARAM, (CameraParameter.PreviewKey<String[]>) strArr);
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo13022a(float COUIBaseListPopupWindow_12, float f2) {
        CameraLog.m12954a("OneCameraImpl", "setCurTemperature, temperature: " + COUIBaseListPopupWindow_12 + ", threshold: " + f2);
        mo13078c(CameraMetadataKey.f13346c, (CaptureRequest.Key<float[]>) new float[]{COUIBaseListPopupWindow_12, f2});
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: IntrinsicsJvm.kt_5 */
    public void mo13083d(long OplusGLSurfaceView_15) {
        CameraDevice cameraDevice = this.f13440B;
        if (cameraDevice != null) {
            cameraDevice.updateThumbnailMap(OplusGLSurfaceView_15);
        }
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: A */
    public void mo13009A(int OplusGLSurfaceView_13) {
        m13175b((CameraParameter.PreviewKey<CameraParameter.PreviewKey<Integer>>) CameraParameter.VIDEO_EIS_RECORD_STATE, (CameraParameter.PreviewKey<Integer>) Integer.valueOf(OplusGLSurfaceView_13));
        m13172a(this.f13476al, 0);
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: C */
    public void mo13013C() {
        m13235B(3);
    }

    @Override // com.oplus.camera.p141e.OneCamera
    /* renamed from: F */
    public void mo13017F(boolean z) {
        CameraDevice cameraDevice = this.f13440B;
        if (cameraDevice != null) {
            cameraDevice.stopPreview(z);
        }
    }
}

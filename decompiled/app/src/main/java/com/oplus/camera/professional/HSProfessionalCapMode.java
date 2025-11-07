package com.oplus.camera.professional;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Rect;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Size;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.animation.Animation;
import android.view.animation.PathInterpolator;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.p027a.ContextCompat;
import androidx.preference.PreferenceManager;
import com.google.android.exoplayer2.C1547C;
import com.oplus.camera.AEAFHelp;
import com.oplus.camera.ZoomConfigure;
import com.oplus.camera.CameraLog;
import com.oplus.camera.HistogramProcessorManager;
import com.oplus.camera.R;
import com.oplus.camera.aps.config.CameraConfig;
import com.oplus.camera.aps.config.ConfigDataBase;
import com.oplus.camera.aps.constant.ApsConstant;
import com.oplus.camera.aps.service.CameraCaptureResult;
import com.oplus.camera.aps.util.AlgoSwitchConfig;
import com.oplus.camera.capmode.BaseMode;
import com.oplus.camera.capmode.CameraInterface;
import com.oplus.camera.p137b.SimpleAnimatorListener;
import com.oplus.camera.p141e.CameraCharacteristicsUtil;
import com.oplus.camera.p141e.CameraMetadataKey;
import com.oplus.camera.p141e.CameraRequestTag;
import com.oplus.camera.p141e.OplusCameraCharacteristics;
import com.oplus.camera.p141e.OneCamera;
import com.oplus.camera.p144g.p145a.ExifIFD;
import com.oplus.camera.p144g.p145a.ExifModel;
import com.oplus.camera.p172ui.CountDownUI;
import com.oplus.camera.p172ui.CameraUIInterface;
import com.oplus.camera.p172ui.RotateImageView;
import com.oplus.camera.p172ui.control.MainShutterButtonInfo;
import com.oplus.camera.p172ui.p173a.HintManager;
import com.oplus.camera.p172ui.p173a.HintModel;
import com.oplus.camera.p172ui.preview.p177a.PreviewEffectProcess;
import com.oplus.camera.professional.HSListProfessionalModeBar;
import com.oplus.camera.professional.HSPanelContainer;
import com.oplus.camera.professional.ProfessionalAnimUtil;
import com.oplus.camera.screen.p164b.BaseScreenMode;
import com.oplus.camera.statistics.model.CaptureMsgData;
import com.oplus.camera.statistics.model.DcsMsgData;
import com.oplus.camera.statistics.model.MenuClickMsgData;
import com.oplus.camera.util.BackgroundUtil;
import com.oplus.camera.util.Util;
import com.oplus.ocs.camera.CameraParameter;
import com.oplus.ocs.camera.CameraPictureCallback;
import com.oplus.ocs.camera.CameraPreviewCallback;
import com.p078a.p079a.Spring;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.List;

/* compiled from: HSProfessionalCapMode.java */
/* renamed from: com.oplus.camera.professional.COUIBaseListPopupWindow_10 */
/* loaded from: classes2.dex */
public class HSProfessionalCapMode extends BaseMode implements View.OnClickListener, HSListProfessionalModeBar.IntrinsicsJvm.kt_4 {

    /* renamed from: A */
    private Handler f15484A;

    /* renamed from: B */
    private PlatformImplementations.kt_3 f15485B;

    /* renamed from: C */
    private Resources f15486C;

    /* renamed from: D */
    private int f15487D;

    /* renamed from: E */
    private boolean f15488E;

    /* renamed from: F */
    private boolean f15489F;

    /* renamed from: G */
    private RotateImageView f15490G;

    /* renamed from: H */
    private int f15491H;

    /* renamed from: I */
    private ValueAnimator f15492I;

    /* renamed from: J */
    private int f15493J;

    /* renamed from: K */
    private int f15494K;

    /* renamed from: L */
    private int f15495L;

    /* renamed from: M */
    private int f15496M;

    /* renamed from: N */
    private float f15497N;

    /* renamed from: O */
    private int f15498O;

    /* renamed from: P */
    private boolean f15499P;

    /* renamed from: Q */
    private boolean f15500Q;

    /* renamed from: R */
    private byte[] f15501R;

    /* renamed from: S */
    private CameraPictureCallback.CameraPictureImage f15502S;

    /* renamed from: T */
    private boolean f15503T;

    /* renamed from: U */
    private boolean f15504U;

    /* renamed from: V */
    private int f15505V;

    /* renamed from: W */
    private int f15506W;

    /* renamed from: X */
    private int f15507X;

    /* renamed from: Y */
    private int f15508Y;

    /* renamed from: Z */
    private int f15509Z;

    /* renamed from: aa */
    private int f15510aa;

    /* renamed from: ab */
    private int f15511ab;

    /* renamed from: ac */
    private int f15512ac;

    /* renamed from: ad */
    private int f15513ad;

    /* renamed from: ae */
    private byte[] f15514ae;

    /* renamed from: af */
    private TextView f15515af;

    /* renamed from: ag */
    private ValueAnimator f15516ag;

    /* renamed from: ah */
    private PathInterpolator f15517ah;

    /* renamed from: ai */
    private HSPanelContainer.IntrinsicsJvm.kt_4 f15518ai;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private final Object f15519g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private volatile boolean f15520h;

    /* renamed from: OplusGLSurfaceView_13 */
    private boolean f15521i;

    /* renamed from: OplusGLSurfaceView_15 */
    private boolean f15522j;

    /* renamed from: OplusGLSurfaceView_5 */
    private boolean f15523k;

    /* renamed from: OplusGLSurfaceView_14 */
    private boolean f15524l;

    /* renamed from: OplusGLSurfaceView_6 */
    private boolean f15525m;

    /* renamed from: OplusGLSurfaceView_11 */
    private boolean f15526n;

    /* renamed from: o */
    private boolean f15527o;

    /* renamed from: p */
    private boolean f15528p;

    /* renamed from: q */
    private boolean f15529q;

    /* renamed from: r */
    private int f15530r;

    /* renamed from: s */
    private long f15531s;

    /* renamed from: t */
    private Thread f15532t;

    /* renamed from: u */
    private CountDownUI f15533u;

    /* renamed from: v */
    private HSListProfessionalModeBar f15534v;

    /* renamed from: w */
    private HSPanelContainer f15535w;

    /* renamed from: x */
    private RotateImageView f15536x;

    /* renamed from: y */
    private HistogramProcessorManager f15537y;

    /* renamed from: z */
    private HistogramProcessorManager.PlatformImplementations.kt_3 f15538z;

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean allowSwitchCamera() {
        return false;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected boolean canCloseSubMenuWhenSwitchCamera() {
        return false;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public String getCameraMode() {
        return ApsConstant.CAPTURE_MODE_PROFESSIONAL;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean getFrontEnable() {
        return false;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public int getOperatingMode() {
        return 32777;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected boolean isInProMode() {
        return true;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void onStop() {
    }

    public HSProfessionalCapMode(Activity activity, CameraInterface interfaceC2646a, CameraUIInterface cameraUIInterface, PreviewEffectProcess interfaceC3423t) {
        super(activity, interfaceC2646a, cameraUIInterface, interfaceC3423t);
        this.f15519g = new Object();
        this.f15520h = false;
        this.f15521i = false;
        this.f15522j = false;
        this.f15523k = false;
        this.f15524l = false;
        this.f15525m = true;
        this.f15526n = false;
        this.f15527o = false;
        this.f15528p = false;
        this.f15529q = false;
        this.f15530r = 0;
        this.f15531s = 0L;
        this.f15532t = null;
        this.f15533u = null;
        this.f15534v = null;
        this.f15535w = null;
        this.f15536x = null;
        this.f15537y = null;
        this.f15538z = null;
        this.f15484A = null;
        this.f15485B = null;
        this.f15487D = -1;
        this.f15488E = false;
        this.f15489F = false;
        this.f15490G = null;
        this.f15491H = 0;
        this.f15492I = null;
        this.f15493J = 0;
        this.f15494K = 0;
        this.f15495L = 0;
        this.f15496M = 0;
        this.f15497N = 0.0f;
        this.f15498O = 0;
        this.f15499P = false;
        this.f15500Q = true;
        this.f15502S = null;
        this.f15503T = false;
        this.f15504U = false;
        this.f15505V = 0;
        this.f15506W = 0;
        this.f15507X = 0;
        this.f15508Y = 0;
        this.f15509Z = 0;
        this.f15510aa = 0;
        this.f15511ab = 0;
        this.f15512ac = 0;
        this.f15513ad = 0;
        this.f15514ae = null;
        this.f15515af = null;
        this.f15516ag = null;
        this.f15517ah = new PathInterpolator(0.3f, 0.0f, 0.1f, 1.0f);
        this.f15518ai = new HSPanelContainer.IntrinsicsJvm.kt_4() { // from class: com.oplus.camera.professional.COUIBaseListPopupWindow_10.14
            @Override // com.oplus.camera.professional.HSPanelContainer.IntrinsicsJvm.kt_4
            /* renamed from: PlatformImplementations.kt_3 */
            public void mo15510a(int OplusGLSurfaceView_13, String str, boolean z) {
                HSProfessionalCapMode.this.m15568a(OplusGLSurfaceView_13, str, z);
            }
        };
        this.f15486C = activity.getApplicationContext().getResources();
        this.f15493J = this.f15486C.getDimensionPixelSize(R.dimen.hs_main_mode_bar_height);
        this.f15494K = this.f15486C.getDimensionPixelSize(R.dimen.hs_sub_mode_bar_height);
        this.f15495L = this.f15486C.getDimensionPixelSize(R.dimen.hs_sub_mode_hs_panel_container_height);
        this.f15496M = this.f15486C.getDimensionPixelSize(R.dimen.hs_sub_mode_hs_panel_container_bottom);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        CameraLog.m12954a("HSProfessionalCapMode", "onSingleTapUp");
        if (this.mCameraUIInterface.mo18208e((int) motionEvent.getX(), (int) motionEvent.getY())) {
            return false;
        }
        if (isInPreviewArea(motionEvent) && this.f15534v.isSelected() && !this.mCameraInterface.mo10445A()) {
            onBackPressed();
        }
        m15570a(motionEvent);
        return false;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onShareMenuExpand() {
        if (this.f15534v.isSelected()) {
            this.mCameraInterface.mo10492a(true, true);
            this.mCameraInterface.mo10563d(true);
            ProfessionalAnimUtil.PlatformImplementations.kt_3 aVar = new ProfessionalAnimUtil.PlatformImplementations.kt_3();
            aVar.f15706a = false;
            aVar.f15708c = 250;
            aVar.f15712g = 400;
            aVar.f15709d = 0.0f;
            aVar.f15710e = this.mActivity.getResources().getDimensionPixelSize(R.dimen.hs_main_mode_bar_item_animation_offset);
            this.f15535w.setAllPopupInvisibility(aVar);
            this.f15534v.m15432a();
            m15620b(0, true);
            this.mOneCamera.mo13105j(true);
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean onLongPress(MotionEvent motionEvent) {
        CameraLog.m12954a("HSProfessionalCapMode", "onLongPress");
        m15570a(motionEvent);
        return false;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m15570a(MotionEvent motionEvent) {
        BaseScreenMode abstractC2934aMo10519aU;
        Rect rect = new Rect();
        this.mCameraUIInterface.mo18253p().getHitRect(rect);
        if (rect.contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY())) {
            if (1 == getDefaultAFMode() || 4 == getDefaultAFMode()) {
                m15520E();
                this.f15535w.setPanelsBarAuto(4);
            }
            if (this.mCameraInterface == null || !isBubbleOpen(CameraUIInterface.KEY_EXPOSURE_FOCUS_SEPARATE_TIPS) || (abstractC2934aMo10519aU = this.mCameraInterface.mo10519aU()) == null || !abstractC2934aMo10519aU.mo16529a(this.mCameraUIInterface, (int) motionEvent.getX(), (int) motionEvent.getY())) {
                return;
            }
            CameraLog.m12954a("HSProfessionalCapMode", "onSingleTapUp, bubble open, KEY_EXPOSURE_FOCUS_SEPARATE_TIPS");
            this.mCameraUIInterface.mo18086a(this.mActivity.findViewById(R.id_renamed.oplus_setting_bar), 18, (int) motionEvent.getX(), (int) motionEvent.getY());
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onRawImageReceived(CameraPictureCallback.CameraPictureImage cameraPictureImage) {
        this.f15502S = cameraPictureImage;
        if (isSuperRawOpen()) {
            synchronized (this.f15519g) {
                this.f15503T = true;
            }
            m15647f();
            return;
        }
        m15642e();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean consumeImage(CameraPictureCallback.CameraPictureImage cameraPictureImage) {
        if (!isSuperRawOpen() || 256 != cameraPictureImage.getFormat() || 4 != cameraPictureImage.getSourceType()) {
            return false;
        }
        this.f15505V = cameraPictureImage.getWidth();
        this.f15506W = cameraPictureImage.getHeight();
        synchronized (this.f15519g) {
            this.f15501R = cameraPictureImage.getImage();
        }
        this.f15507X = 1;
        this.f15508Y = 1;
        this.f15514ae = new byte[this.f15507X * this.f15508Y * 3];
        m15647f();
        return true;
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    private void m15642e() {
        byte[] image = this.f15502S.getImage();
        ExifModel c2731eM13747a = ExifModel.m13747a(image);
        final long OplusGLSurfaceView_15 = this.mCaptureDate - 10;
        StringBuilder sb = new StringBuilder();
        sb.append("saveResultToDng, mRawPreviewJpeg : ");
        sb.append(this.f15501R != null);
        CameraLog.m12959b("HSProfessionalCapMode", sb.toString());
        if (c2731eM13747a != null) {
            if (this.f15501R != null) {
                c2731eM13747a.m13762a(c2731eM13747a.f13793f, OplusGLSurfaceView_15);
                c2731eM13747a.m13764b();
                c2731eM13747a.f13793f.m13740a(this.f15514ae);
                c2731eM13747a.f13793f.m13744b(256).m13728a(new int[]{this.f15507X});
                c2731eM13747a.f13793f.m13744b(257).m13728a(new int[]{this.f15508Y});
                c2731eM13747a.f13793f.m13744b(262).m13728a(new int[]{this.f15508Y});
                ExifIFD c2729cM15564a = m15564a(c2731eM13747a.f13788a);
                c2729cM15564a.m13740a(this.f15501R);
                c2731eM13747a.f13792e.add(c2729cM15564a);
                c2731eM13747a.f13791d.add(c2729cM15564a);
            }
            c2731eM13747a.m13761a();
            c2731eM13747a.m13762a(c2731eM13747a.f13793f, OplusGLSurfaceView_15);
            c2731eM13747a.m13762a(c2731eM13747a.f13794g, OplusGLSurfaceView_15);
            c2731eM13747a.m13766d();
            image = c2731eM13747a.f13797j.array();
        }
        final byte[] bArr = image;
        this.f15501R = null;
        final int format = this.f15502S.getFormat();
        this.f15502S.getTimestamp();
        this.f15502S = null;
        if (this.mActivity != null) {
            this.mActivity.runOnUiThread(new Runnable() { // from class: com.oplus.camera.professional.COUIBaseListPopupWindow_10.1
                @Override // java.lang.Runnable
                public void run() {
                    HSProfessionalCapMode.this.pictureTakenCallback(bArr, 0, 0, Util.m24243a(format), true, false, false, OplusGLSurfaceView_15, 0);
                }
            });
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private ExifIFD m15564a(ByteOrder byteOrder) {
        ExifIFD c2729c = new ExifIFD();
        c2729c.f13777c = new ArrayList<>();
        c2729c.m13739a(byteOrder);
        c2729c.m13742a(254, new int[]{1});
        c2729c.m13742a(256, new int[]{this.f15505V});
        c2729c.m13742a(257, new int[]{this.f15506W});
        c2729c.m13742a(258, new int[]{8, 8, 8});
        c2729c.m13742a(259, new int[]{7});
        c2729c.m13742a(262, new int[]{6});
        c2729c.m13742a(273, new int[]{0});
        c2729c.m13742a(277, new int[]{3});
        c2729c.m13742a(278, new int[]{this.f15506W});
        c2729c.m13742a(279, new int[]{this.f15501R.length});
        c2729c.m13742a(284, new int[]{1});
        c2729c.m13742a(529, new int[]{1});
        c2729c.m13742a(530, new int[]{1, 1});
        c2729c.m13742a(531, new int[]{2});
        c2729c.m13742a(532, new int[]{1});
        return c2729c;
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    private void m15647f() {
        synchronized (this.f15519g) {
            if (this.f15501R != null && this.f15503T) {
                m15642e();
            }
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode, com.oplus.camera.p141e.OneCamera.PlatformImplementations.kt_3
    public void onCaptureStarted(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, long OplusGLSurfaceView_15, long j2) {
        HSPanelContainer c2889g;
        super.onCaptureStarted(cameraCaptureSession, captureRequest, OplusGLSurfaceView_15, j2);
        if (this.mCameraUIInterface == null || (c2889g = this.f15535w) == null || c2889g.m15507g(5) || Util.m24169C() || !isFlashState()) {
            return;
        }
        this.mCameraUIInterface.mo18183c().m14239b(j2, OplusGLSurfaceView_15);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean needDelayCloseForCapture() {
        if (C1547C.NANOS_PER_SECOND <= Long.parseLong(m15655i())) {
            return false;
        }
        return super.needDelayCloseForCapture();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onCameraPermissionGranted() throws Resources.NotFoundException, NumberFormatException {
        this.f15487D = this.mCameraInterface.mo10543as();
        HSPanelContainer c2889g = this.f15535w;
        if (c2889g != null) {
            if (this.f15489F) {
                c2889g.m15487a(getCameraInfo(this.f15487D), (HSPanelContainer.PlatformImplementations.kt_3) null);
                if (isSuperRawOpen()) {
                    this.f15535w.m15485a(getCameraInfo(this.f15487D), 2000000000L);
                }
                this.f15535w.m15476a();
                return;
            }
            c2889g.m15486a(getCameraInfo(this.f15487D), this.f15484A, (HSPanelContainer.PlatformImplementations.kt_3) null);
            if (isSuperRawOpen()) {
                this.f15535w.m15485a(getCameraInfo(this.f15487D), 2000000000L);
            }
            m15663m();
            this.f15535w.setSettleListener(this.f15534v);
            this.f15535w.setMotionListener(this.f15518ai);
            PlatformImplementations.kt_3 aVar = this.f15485B;
            if (aVar != null) {
                aVar.setVisibility(0);
            }
            this.mCameraInterface.mo10563d(true);
            m15690a(1);
            this.f15489F = true;
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public String getCameraFeature() {
        if (this.mbDestroyed) {
            return null;
        }
        return this.mPreferences.getString(CameraUIInterface.KEY_FOCUS_PEAKING, "off").equals("on") ? ApsConstant.FEATURE_FOCUS_PEAKING : super.getCameraFeature();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public boolean m15695a(String str, List<String> list) {
        return list != null && list.indexOf(str) >= 0;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void onInitCameraMode() throws Resources.NotFoundException, NumberFormatException {
        CameraLog.m12954a("HSProfessionalCapMode", "onInitCameraMode, Start");
        restoreProPreference();
        HSLevelPanel.m15398a();
        if (isNightProModeSupport()) {
            this.f15488E = true;
        }
        this.f15499P = false;
        this.f15500Q = true;
        this.f15521i = "on".equals(this.mPreferences.getString(CameraUIInterface.KEY_HIGH_RESOLUTION, this.f15486C.getString(R.string.camera_high_resolution_default_value)));
        if (!this.f15521i) {
            this.mCameraUIInterface.mo18171b(CameraUIInterface.KEY_HIGH_RESOLUTION, "off");
        }
        if (this.f15533u == null) {
            this.f15533u = new CountDownUI(this.mCameraUIInterface, new CountDownUI.PlatformImplementations.kt_3() { // from class: com.oplus.camera.professional.COUIBaseListPopupWindow_10.12
                @Override // com.oplus.camera.p172ui.CountDownUI.PlatformImplementations.kt_3
                /* renamed from: PlatformImplementations.kt_3 */
                public void mo12293a(boolean z) {
                    HSProfessionalCapMode.this.mCameraUIInterface.mo18217g(true);
                    if (z) {
                        return;
                    }
                    MainShutterButtonInfo shutterButtonInfo = HSProfessionalCapMode.this.getShutterButtonInfo();
                    shutterButtonInfo.m19226a(14);
                    HSProfessionalCapMode.this.mCameraUIInterface.mo18091a(shutterButtonInfo);
                }

                @Override // com.oplus.camera.p172ui.CountDownUI.PlatformImplementations.kt_3
                /* renamed from: PlatformImplementations.kt_3 */
                public void mo12292a() {
                    if (HSProfessionalCapMode.this.mbPaused) {
                        return;
                    }
                    HSProfessionalCapMode.this.f15533u.mo20104e();
                }
            });
        }
        if (this.f15484A == null) {
            this.f15484A = new Handler() { // from class: com.oplus.camera.professional.COUIBaseListPopupWindow_10.16
                @Override // android.os.Handler
                public void handleMessage(Message message) {
                    HSProfessionalCapMode.this.m15691a(message.what, message);
                }
            };
        }
        if (C1547C.NANOS_PER_SECOND <= Long.parseLong(m15655i())) {
            this.mCameraUIInterface.mo18091a(getShutterButtonInfo());
        }
        this.mCameraUIInterface.mo18187c(this.mActivity.getString(R.string.camera_description_common_shutter_button));
        m15666o();
        if (this.f15535w != null) {
            if (m15689z()) {
                this.f15535w.m15503e();
            } else {
                this.f15535w.setVisibility(0);
            }
        }
        if (this.f15534v != null) {
            int OplusGLSurfaceView_13 = m15689z() ? 8 : 0;
            this.f15534v.setAlpha(0.0f);
            this.f15534v.setVisibility(OplusGLSurfaceView_13);
        }
        m15650g();
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    private void m15650g() {
        HintManager c3130aMo18233k = this.mCameraUIInterface.mo18233k();
        if (c3130aMo18233k != null) {
            c3130aMo18233k.m18484a(new HintManager.IntrinsicsJvm.kt_4() { // from class: com.oplus.camera.professional.COUIBaseListPopupWindow_10.17
                @Override // com.oplus.camera.p172ui.p173a.HintManager.IntrinsicsJvm.kt_4
                /* renamed from: PlatformImplementations.kt_3 */
                public void mo14771a(HintModel c3131b) {
                    if (!HSProfessionalCapMode.this.isHistogramOpen() || 270 == HSProfessionalCapMode.this.mOrientation || HSProfessionalCapMode.this.f15537y == null) {
                        return;
                    }
                    HSProfessionalCapMode.this.f15509Z = c3131b.f17456a;
                    HSProfessionalCapMode.this.f15515af.setText(HSProfessionalCapMode.this.mActivity.getResources().getString(HSProfessionalCapMode.this.f15509Z));
                    HSProfessionalCapMode.this.f15515af.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.oplus.camera.professional.COUIBaseListPopupWindow_10.17.1
                        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                        public void onGlobalLayout() throws Resources.NotFoundException {
                            HSProfessionalCapMode.this.f15515af.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                            int height = ("square".equals(HSProfessionalCapMode.this.mPreferences.getString(CameraUIInterface.KEY_PHOTO_RATIO, HSProfessionalCapMode.this.mActivity.getString(R.string.camera_photo_ratio_default_value))) && HSProfessionalCapMode.this.mOrientation % 180 == 0) ? HSProfessionalCapMode.this.f15515af.getHeight() - HSProfessionalCapMode.this.f15512ac : HSProfessionalCapMode.this.f15515af.getHeight() + HSProfessionalCapMode.this.f15511ab;
                            if (HSProfessionalCapMode.this.f15504U) {
                                HSProfessionalCapMode.this.f15504U = false;
                                HSProfessionalCapMode.this.m15637d(height);
                                HSProfessionalCapMode.this.f15537y.m14843a(HSProfessionalCapMode.this.f15538z, false, false);
                            } else if (HSProfessionalCapMode.this.f15510aa != height) {
                                HSProfessionalCapMode.this.m15566a(HSProfessionalCapMode.this.f15510aa, height);
                            }
                            HSProfessionalCapMode.this.f15510aa = height;
                        }
                    });
                }

                @Override // com.oplus.camera.p172ui.p173a.HintManager.IntrinsicsJvm.kt_4
                /* renamed from: PlatformImplementations.kt_3 */
                public void mo14770a(int OplusGLSurfaceView_13) throws Resources.NotFoundException {
                    if (OplusGLSurfaceView_13 == HSProfessionalCapMode.this.f15509Z) {
                        HSProfessionalCapMode.this.f15510aa = 0;
                    }
                    if (!HSProfessionalCapMode.this.isHistogramOpen() || 270 == HSProfessionalCapMode.this.mOrientation || HSProfessionalCapMode.this.f15537y == null || OplusGLSurfaceView_13 != HSProfessionalCapMode.this.f15509Z) {
                        return;
                    }
                    if (HSProfessionalCapMode.this.f15516ag != null && HSProfessionalCapMode.this.f15516ag.isRunning()) {
                        HSProfessionalCapMode.this.f15516ag.cancel();
                    }
                    HSProfessionalCapMode.this.m15637d(0);
                    HSProfessionalCapMode.this.f15537y.m14844a(HSProfessionalCapMode.this.f15538z, HSProfessionalCapMode.this.m15512A(), HSProfessionalCapMode.this.m15514B(), 150L);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public void m15566a(int OplusGLSurfaceView_13, int i2) {
        ValueAnimator valueAnimator = this.f15516ag;
        if (valueAnimator == null) {
            this.f15516ag = ValueAnimator.ofInt(0, i2);
            this.f15516ag.setDuration(350L);
            this.f15516ag.setInterpolator(this.f15517ah);
            this.f15516ag.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.professional.COUIBaseListPopupWindow_10.18
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator2) throws Resources.NotFoundException {
                    HSProfessionalCapMode.this.m15637d(((Integer) valueAnimator2.getAnimatedValue()).intValue());
                    if (HSProfessionalCapMode.this.f15537y != null) {
                        HSProfessionalCapMode.this.f15537y.m14843a(HSProfessionalCapMode.this.f15538z, HSProfessionalCapMode.this.m15512A(), HSProfessionalCapMode.this.m15514B());
                    }
                }
            });
            this.f15516ag.addListener(new SimpleAnimatorListener() { // from class: com.oplus.camera.professional.COUIBaseListPopupWindow_10.19
                @Override // com.oplus.camera.p137b.SimpleAnimatorListener, android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) throws Resources.NotFoundException {
                    super.onAnimationCancel(animator);
                    HSProfessionalCapMode.this.m15637d(0);
                    if (HSProfessionalCapMode.this.f15537y != null) {
                        HSProfessionalCapMode.this.f15537y.m14843a(HSProfessionalCapMode.this.f15538z, HSProfessionalCapMode.this.m15512A(), HSProfessionalCapMode.this.m15514B());
                    }
                }
            });
        } else {
            valueAnimator.setIntValues(OplusGLSurfaceView_13, i2);
        }
        if (this.f15516ag.isRunning()) {
            return;
        }
        this.f15516ag.start();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onZoomMenuCollapsing() {
        HSListProfessionalModeBar c2887e = this.f15534v;
        if (c2887e != null) {
            c2887e.m15436a(true, true);
            if (this.f15534v.isSelected()) {
                m15620b(4, true);
            } else {
                if (isPanelMode()) {
                    return;
                }
                this.mCameraUIInterface.mo18068a(0, 1);
            }
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onZoomMenuCollapsed() {
        if (!this.mCameraInterface.mo10445A() && !this.mbInCapturing) {
            this.f15485B.setEnabled(true);
        } else {
            this.f15523k = true;
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onZoomMenuExpand() {
        HSListProfessionalModeBar c2887e = this.f15534v;
        if (c2887e != null) {
            c2887e.m15436a(false, true);
        }
        this.f15485B.setEnabled(false);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onZoomTransitionChanged(int OplusGLSurfaceView_13) {
        int zoomBarOffset = OplusGLSurfaceView_13 - getZoomBarOffset();
        if (this.f15534v != null) {
            float COUIBaseListPopupWindow_12 = this.f15497N;
            if (zoomBarOffset <= (-getZoomBarOffset()) / 2) {
                COUIBaseListPopupWindow_12 = 0.0f;
            }
            this.f15534v.setAlpha(COUIBaseListPopupWindow_12);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f15534v.getLayoutParams();
            layoutParams.bottomMargin = this.f15494K + this.f15496M;
            this.f15534v.setLayoutParams(layoutParams);
            if (this.f15493J == getZoomBarOffset()) {
                this.f15534v.setBackgroundResource(R.drawable.main_bar_bg_grad);
            } else {
                this.f15534v.setBackgroundResource(0);
            }
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onZoomAlphaChanged(float COUIBaseListPopupWindow_12) {
        this.f15497N = COUIBaseListPopupWindow_12;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void updateControlPanelBgColor(int OplusGLSurfaceView_13) {
        if (this.f15534v != null) {
            if ((this.f15498O > OplusGLSurfaceView_13 || OplusGLSurfaceView_13 == 0) && 1.0d != getTargetPreviewRatio(this.mOneCamera.mo13086e())) {
                this.f15534v.setBackgroundResource(R.drawable.main_bar_bg_grad);
            } else {
                this.f15534v.setBackgroundColor(BackgroundUtil.m24523a(OplusGLSurfaceView_13));
            }
        }
        this.f15498O = OplusGLSurfaceView_13;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean getZSLMode() {
        this.f15521i = "on".equals(this.mPreferences.getString(CameraUIInterface.KEY_HIGH_RESOLUTION, this.f15486C.getString(R.string.camera_high_resolution_default_value)));
        HSPanelContainer c2889g = this.f15535w;
        if ((c2889g != null && !c2889g.m15507g(2)) || isRawOpen()) {
            CameraLog.m12954a("HSProfessionalCapMode", "getZSLMode exposure time isn't auto or raw open,so return false");
            return false;
        }
        if (this.f15521i) {
            return true;
        }
        return getLogicCameraType() == 0 && Util.m24169C();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private Size m15563a(OplusCameraCharacteristics c2698h) {
        List<Size> configSizeListValue = CameraConfig.getConfigSizeListValue(ConfigDataBase.KEY_DEFAULT_SENSOR_SIZE_SCALE);
        if (configSizeListValue == null || configSizeListValue.size() <= 0) {
            return null;
        }
        double width = configSizeListValue.get(0).getWidth() / configSizeListValue.get(0).getHeight();
        if (0.002d < Math.abs(width - 1.3333333333333333d)) {
            return Util.m24378b(c2698h.m13258a(256), width);
        }
        return null;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public Size getPictureSize(OplusCameraCharacteristics c2698h) {
        Size sizeM15563a;
        return (!"camera_ultra_wide".equals(this.mPreferences.getString(CameraUIInterface.KEY_SWITCH_CAMERA, "camera_main")) || (sizeM15563a = m15563a(c2698h)) == null) ? super.getPictureSize(c2698h) : sizeM15563a;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean needSurface(String str) {
        if ("type_still_capture_raw".equals(str)) {
            return (getSupportFunction(CameraUIInterface.KEY_RAW_CONTROL) || getSupportFunction(CameraUIInterface.KEY_SUPER_RAW_CONTROL)) && !CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_DISABLE_RAW);
        }
        if ("type_still_capture_jpeg".equals(str)) {
            return !AlgoSwitchConfig.getSupportApsCapture();
        }
        if ("type_tuning_data_raw".equals(str)) {
            if (Util.m24169C() || !CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_TUNING_DATA_BUFFER_SUPPORT)) {
                return false;
            }
            return getSupportFunction(CameraUIInterface.KEY_RAW_CONTROL) || getSupportFunction(CameraUIInterface.KEY_SUPER_RAW_CONTROL);
        }
        if ("type_preview_frame".equals(str)) {
            return true;
        }
        return super.needSurface(str);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean isRawOpen() {
        return (getSupportFunction(CameraUIInterface.KEY_RAW_CONTROL) && !"off".equals(this.mPreferences.getString(CameraUIInterface.KEY_RAW_CONTROL, "off"))) || (getSupportFunction(CameraUIInterface.KEY_SUPER_RAW_CONTROL) && !"off".equals(this.mPreferences.getString(CameraUIInterface.KEY_SUPER_RAW_CONTROL, "off")));
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected boolean isSuperRawOpen() {
        return getSupportFunction(CameraUIInterface.KEY_SUPER_RAW_CONTROL) && "super_raw".equals(this.mPreferences.getString(CameraUIInterface.KEY_SUPER_RAW_CONTROL, "off"));
    }

    /* renamed from: PlatformImplementations.kt_3 */
    protected boolean m15694a() {
        return CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_PROFESSIONAL_MUTEX_ZOOM_SUPPORT);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean isRawRequestTag() {
        return this.mbRawRequestTag;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onMenuOptionAdded(String str) {
        if (CameraUIInterface.KEY_SUPER_RAW_CONTROL.equals(str) && this.mCameraUIInterface.mo18143ag()) {
            this.mCameraUIInterface.mo18102a(CameraUIInterface.KEY_SUPER_RAW_CONTROL, true, (int) this.f15486C.getDimension(R.dimen.super_raw_setting_menu_reddot_offset_x), (int) this.f15486C.getDimension(R.dimen.super_raw_setting_menu_reddot_offset_y));
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void closeImageReader() {
        CameraLog.m12954a("HSProfessionalCapMode", "closeImageReader");
        this.f15525m = true;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public List<String> onGetSupportSettingList(String str, int OplusGLSurfaceView_13) {
        if (CameraUIInterface.KEY_CAMERA_TIMER_SHUTTER.equals(str)) {
            List<String> supportSettingList = getSupportSettingList(str, OplusGLSurfaceView_13);
            ArrayList arrayList = new ArrayList();
            if (supportSettingList != null) {
                arrayList.addAll(supportSettingList);
            }
            if (arrayList.size() > 0) {
                return arrayList;
            }
            return null;
        }
        if (CameraUIInterface.KEY_PHOTO_RATIO.equals(str)) {
            List<String> supportedList = CameraConfig.getSupportedList(CameraUIInterface.KEY_PHOTO_RATIO, OplusGLSurfaceView_13);
            ArrayList arrayList2 = new ArrayList();
            if (supportedList != null && supportedList.contains("standard")) {
                arrayList2.add("standard");
            }
            if (arrayList2.size() > 0) {
                return arrayList2;
            }
            return null;
        }
        if (CameraUIInterface.KEY_FLASH_MODE.equals(str)) {
            List<String> supportSettingList2 = getSupportSettingList(CameraUIInterface.KEY_FLASH_MODE, this.mCameraId);
            ArrayList arrayList3 = new ArrayList();
            if (supportSettingList2 != null) {
                arrayList3.addAll(supportSettingList2);
            }
            if (arrayList3.size() > 0) {
                return arrayList3;
            }
            return null;
        }
        return super.onGetSupportSettingList(str, OplusGLSurfaceView_13);
    }

    /* renamed from: COUIBaseListPopupWindow_10 */
    private boolean m15653h() {
        return (getSupportFunction(CameraUIInterface.KEY_PARAMETER_SAVING) || getSupportFunction(CameraUIInterface.KEY_FOCUS_PEAKING)) ? false : true;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean getSupportMenu(String str) {
        if (CameraUIInterface.KEY_FLASH_MODE.equals(str)) {
            return true;
        }
        if (CameraUIInterface.KEY_SWITCH_DUAL_CAMERA.equals(str) || CameraUIInterface.KEY_RAW.equals(str) || CameraUIInterface.KEY_HIGH_RESOLUTION.equals(str) || CameraUIInterface.KEY_PHOTO_RATIO.equals(str) || CameraUIInterface.KEY_CAMERA_TIMER_SHUTTER.equals(str) || CameraUIInterface.KEY_SETTING.equals(str) || CameraUIInterface.KEY_SWITCH_CAMERA.equals(str) || CameraUIInterface.KEY_PARAMETER_SAVING.equals(str) || CameraUIInterface.KEY_FOCUS_PEAKING.equals(str) || CameraUIInterface.KEY_PRO_HISTOGRAM.equals(str) || CameraUIInterface.KEY_SUB_SETTING.equals(str)) {
            return getSupportFunction(str);
        }
        if (CameraUIInterface.KEY_RAW_CONTROL.equals(str) || CameraUIInterface.KEY_SUPER_RAW_CONTROL.equals(str)) {
            return getSupportFunction(str) && m15653h();
        }
        return super.getSupportMenu(str);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean getSupportSubMenu(String str) {
        if (CameraUIInterface.KEY_CAMERA_TIMER_SHUTTER.equals(str) || CameraUIInterface.KEY_PHOTO_RATIO.equals(str) || CameraUIInterface.KEY_SETTING.equals(str)) {
            return getSupportFunction(str);
        }
        return (CameraUIInterface.KEY_RAW_CONTROL.equals(str) || CameraUIInterface.KEY_SUPER_RAW_CONTROL.equals(str)) && getSupportFunction(str) && !m15653h();
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public int m15696b() {
        return this.mCameraInterface.mo10591u();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: OplusGLSurfaceView_13 */
    public String m15655i() {
        return this.mPreferences == null ? "-1" : this.mPreferences.getString("pref_professional_exposure_time_key", "-1");
    }

    /* renamed from: OplusGLSurfaceView_15 */
    private long m15656j() {
        return Long.parseLong(this.mPreferences.getString("pref_professional_exposure_time_key", this.f15486C.getString(R.string.camera_exposure_time_default_value)));
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public int getCaptureIso() {
        String string = this.mPreferences.getString("pref_professional_iso_key", this.f15486C.getString(R.string.camera_iso_default_value));
        if (this.f15486C.getString(R.string.camera_iso_default_value).equals(string)) {
            return this.f15530r;
        }
        return Integer.parseInt(string);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public long getCaptureExposureTime() throws NumberFormatException {
        long OplusGLSurfaceView_15 = Long.parseLong(m15655i());
        return -1 == OplusGLSurfaceView_15 ? this.f15531s : OplusGLSurfaceView_15;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private int m15560a(int OplusGLSurfaceView_13, ArrayList<String> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            return -1;
        }
        int iAbs = Math.abs(Integer.parseInt(arrayList.get(0)) - OplusGLSurfaceView_13);
        int i2 = 0;
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            int i4 = Integer.parseInt(arrayList.get(i3)) - OplusGLSurfaceView_13;
            if (Math.abs(i4) < iAbs) {
                iAbs = Math.abs(i4);
                i2 = i3;
            }
        }
        return i2;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private int m15559a(float COUIBaseListPopupWindow_12, ArrayList<String> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            return -1;
        }
        float fAbs = Math.abs(Float.parseFloat(arrayList.get(0)) - COUIBaseListPopupWindow_12);
        int OplusGLSurfaceView_13 = 0;
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            float f2 = Float.parseFloat(arrayList.get(i2)) - COUIBaseListPopupWindow_12;
            if (Math.abs(f2) < fAbs) {
                fAbs = Math.abs(f2);
                OplusGLSurfaceView_13 = i2;
            }
        }
        return OplusGLSurfaceView_13;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private int m15561a(long OplusGLSurfaceView_15, ArrayList<String> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            return -1;
        }
        long jAbs = Math.abs(Long.parseLong(arrayList.get(0)) - OplusGLSurfaceView_15);
        int OplusGLSurfaceView_13 = 0;
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            long j2 = Long.parseLong(arrayList.get(i2)) - OplusGLSurfaceView_15;
            if (Math.abs(j2) < jAbs) {
                jAbs = Math.abs(j2);
                OplusGLSurfaceView_13 = i2;
            }
        }
        return OplusGLSurfaceView_13;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onPreviewCaptureResult(CameraPreviewCallback.CameraPreviewResult cameraPreviewResult) {
        CaptureResult.Key<int[]> key;
        int iM15559a;
        int iM15560a;
        int iM15561a;
        int iM15560a2;
        super.onPreviewCaptureResult(cameraPreviewResult);
        if (this.mbCapModeInit) {
            if (cameraPreviewResult == null || cameraPreviewResult.getCaptureResult() == null) {
                CameraLog.m12967f("HSProfessionalCapMode", "onPreviewCaptureResult, invalid totalResult: " + cameraPreviewResult);
                return;
            }
            CaptureResult captureResult = cameraPreviewResult.getCaptureResult();
            if (Util.m24169C()) {
                key = CameraMetadataKey.f13254T;
            } else {
                key = CameraMetadataKey.f13295ah;
            }
            Integer num = (Integer) captureResult.get(CaptureResult.SENSOR_SENSITIVITY);
            Long OplusGLSurfaceView_14 = (Long) captureResult.get(CaptureResult.SENSOR_EXPOSURE_TIME);
            Float COUIBaseListPopupWindow_12 = (Float) captureResult.get(CaptureResult.LENS_FOCUS_DISTANCE);
            int OplusGLSurfaceView_13 = 0;
            if (key != null) {
                try {
                    OplusGLSurfaceView_13 = ((int[]) captureResult.get(key))[0];
                } catch (Exception COUIBaseListPopupWindow_8) {
                    COUIBaseListPopupWindow_8.printStackTrace();
                }
            }
            if (num != null && this.f15535w.m15507g(1) && (iM15560a2 = m15560a(num.intValue(), this.f15535w.m15497c(1))) > -1 && (!this.f15535w.m15491a(1, iM15560a2) || !this.f15526n)) {
                CameraLog.m12959b("HSProfessionalCapMode", "onPreviewCaptureResult, iso: " + num);
                this.f15530r = num.intValue();
                ArrayList<String> arrayListM15500d = this.f15535w.m15500d(1);
                if (arrayListM15500d != null && arrayListM15500d.size() > iM15560a2) {
                    String str = arrayListM15500d.get(iM15560a2);
                    HSLevelPanel.m15400a("pref_professional_iso_key", str);
                    this.f15535w.scrollTo(1, iM15560a2);
                    m15567a(1, str);
                }
            }
            if (OplusGLSurfaceView_14 != null && this.f15535w.m15507g(2) && (iM15561a = m15561a(OplusGLSurfaceView_14.longValue(), this.f15535w.m15497c(2))) > -1 && (!this.f15535w.m15491a(2, iM15561a) || !this.f15526n)) {
                CameraLog.m12959b("HSProfessionalCapMode", "onPreviewCaptureResult, exposureTime: " + OplusGLSurfaceView_14);
                this.f15531s = OplusGLSurfaceView_14.longValue();
                ArrayList<String> arrayListM15500d2 = this.f15535w.m15500d(2);
                if (arrayListM15500d2 != null && arrayListM15500d2.size() > iM15561a) {
                    String str2 = arrayListM15500d2.get(iM15561a);
                    HSLevelPanel.m15400a("pref_professional_exposure_time_key", str2);
                    this.f15535w.scrollTo(2, iM15561a);
                    m15567a(2, str2);
                }
            }
            if (this.f15535w.m15507g(5) && (iM15560a = m15560a(OplusGLSurfaceView_13, this.f15535w.m15497c(5))) > -1 && (!this.f15535w.m15491a(5, iM15560a) || !this.f15526n)) {
                CameraLog.m12959b("HSProfessionalCapMode", "onPreviewCaptureResult, cct: " + OplusGLSurfaceView_13);
                ArrayList<String> arrayListM15500d3 = this.f15535w.m15500d(5);
                if (arrayListM15500d3 != null && arrayListM15500d3.size() > iM15560a) {
                    String str3 = arrayListM15500d3.get(iM15560a);
                    HSLevelPanel.m15400a("pref_professional_whitebalance_key", str3);
                    this.f15535w.scrollTo(5, iM15560a);
                    m15567a(5, str3);
                }
            }
            if (COUIBaseListPopupWindow_12 != null && this.f15535w.m15507g(4) && (iM15559a = m15559a(COUIBaseListPopupWindow_12.floatValue(), this.f15535w.m15497c(4))) > -1 && (!this.f15535w.m15491a(4, iM15559a) || !this.f15526n)) {
                CameraLog.m12959b("HSProfessionalCapMode", "onPreviewCaptureResult, focusDistance: " + COUIBaseListPopupWindow_12);
                ArrayList<String> arrayListM15500d4 = this.f15535w.m15500d(4);
                if (arrayListM15500d4 != null && arrayListM15500d4.size() > iM15559a) {
                    String str4 = arrayListM15500d4.get(iM15559a);
                    HSLevelPanel.m15400a("pref_professional_focus_mode_key", str4);
                    this.f15535w.scrollTo(4, iM15559a);
                    m15567a(4, str4);
                }
            }
            this.f15526n = true;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0164  */
    @Override // com.oplus.camera.capmode.BaseMode
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean getSupportFunction(java.lang.String r11) {
        /*
            Method dump skipped, instructions count: 880
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.professional.HSProfessionalCapMode.getSupportFunction(java.lang.String):boolean");
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m15571a(HSListProfessionalModeBar c2887e, int OplusGLSurfaceView_13, HSListModeBarAdapter c2886d, HSListProfessionalModeBar.IntrinsicsJvm.kt_4 bVar) throws Resources.NotFoundException {
        if (c2887e != null) {
            c2887e.setId(OplusGLSurfaceView_13);
            c2887e.setAdapter(c2886d);
            c2887e.setOnItemClickListener(bVar);
        }
    }

    /* renamed from: OplusGLSurfaceView_5 */
    private void m15659k() throws NumberFormatException {
        if (this.mOneCamera != null) {
            if (this.f15521i) {
                this.mOneCamera.mo13030a(Long.parseLong(this.f15486C.getString(R.string.camera_exposure_time_default_value)));
                this.mOneCamera.mo13031a(Long.parseLong(this.f15486C.getString(R.string.camera_exposure_time_default_value)), false);
            } else {
                String strM16135a = ProfessionalUtil.m16135a(this.mActivity, 5);
                if (this.mPreferences.getString("pref_professional_whitebalance_key", strM16135a).equals(strM16135a)) {
                    m15693a(false);
                } else {
                    m15645e(false);
                }
                m15692a((String) null);
                if (m15689z()) {
                    this.mOneCamera.mo13032a((CaptureRequest.Key<CaptureRequest.Key>) CaptureRequest.CONTROL_AE_EXPOSURE_COMPENSATION, (CaptureRequest.Key) Integer.valueOf(AEAFHelp.m11155c()));
                } else {
                    this.mOneCamera.mo13032a((CaptureRequest.Key<CaptureRequest.Key>) CaptureRequest.CONTROL_AE_EXPOSURE_COMPENSATION, (CaptureRequest.Key) Integer.valueOf(m15697c()));
                }
                m15579a((String) null, false);
                m15648f(false);
            }
            m15690a(3);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private void m15624b(boolean z) throws NumberFormatException {
        m15632c(z);
        m15690a(3);
        this.f15488E = false;
        this.mPreferences.edit().remove(CameraUIInterface.KEY_RESTORE_PROFESSIONAL_PARAMS).apply();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m15690a(int OplusGLSurfaceView_13) {
        if (Thread.currentThread() != this.f15532t) {
            Handler handler = this.f15484A;
            if (handler != null) {
                handler.sendEmptyMessage(OplusGLSurfaceView_13);
                return;
            }
            return;
        }
        m15691a(OplusGLSurfaceView_13, (Message) null);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m15691a(int OplusGLSurfaceView_13, Message message) {
        switch (OplusGLSurfaceView_13) {
            case 1:
                if (this.f15534v.isSelected()) {
                    int selectedPosition = this.f15534v.getSelectedPosition();
                    this.f15534v.m15435a(selectedPosition, true);
                    View childAt = this.f15534v.getChildAt(selectedPosition);
                    if (childAt != null && this.f15535w.m15507g(this.f15534v.m15430a(childAt))) {
                        this.f15534v.getAdapter().m15418a(childAt, 0, true);
                    }
                }
                this.f15535w.m15476a();
                break;
            case 2:
                Float fValueOf = Float.valueOf(0.0f);
                if (message != null) {
                    fValueOf = (Float) message.obj;
                }
                this.mCameraInterface.mo10527ac();
                if (this.mOneCamera != null) {
                    if (this.mCameraInterface.mo10596z()) {
                        this.mCameraInterface.mo10556b(false, false);
                    }
                    this.mOneCamera.mo13023a(fValueOf.floatValue(), true);
                    break;
                }
                break;
            case 3:
                this.f15535w.m15509h(5);
                this.f15535w.m15509h(1);
                this.f15535w.m15509h(2);
                this.f15535w.m15509h(3);
                this.f15535w.m15509h(4);
                m15683w();
                break;
            case 4:
                m15520E();
                this.f15535w.setPanelsBarAuto(4);
                break;
            case 5:
                if (!this.f15524l && !this.mCameraInterface.mo10445A()) {
                    this.mCameraUIInterface.mo18091a(getShutterButtonInfo());
                    break;
                }
                break;
            case 6:
                if (m15689z()) {
                    this.mCameraUIInterface.mo18166b(R.string.camera_macro_best_focus_distance_text, R.drawable.screen_hint_textview_bg, R.color.screen_hint_text_color, Integer.valueOf(CameraConfig.getConfigIntValue(ConfigDataBase.KEY_MACRO_BEST_FOCUS_DISTANCE)));
                    break;
                }
                break;
            case 7:
                m15580a(this.f15535w.mo13582b(3), 3);
                break;
            case 8:
                m15683w();
                break;
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private void m15632c(boolean z) throws NumberFormatException {
        if (this.mOneCamera == null) {
            return;
        }
        this.mOneCamera.mo13032a((CaptureRequest.Key<CaptureRequest.Key>) CaptureRequest.CONTROL_SCENE_MODE, (CaptureRequest.Key) 0);
        m15579a(this.f15486C.getString(R.string.camera_iso_default_value), false);
        long OplusGLSurfaceView_15 = Long.parseLong(this.f15486C.getString(R.string.camera_exposure_time_default_value));
        this.mOneCamera.mo13030a(OplusGLSurfaceView_15);
        this.mOneCamera.mo13031a(OplusGLSurfaceView_15, false);
        m15524G();
        if (!this.f15488E || m15689z()) {
            this.mOneCamera.mo13032a((CaptureRequest.Key<CaptureRequest.Key>) CaptureRequest.CONTROL_AE_EXPOSURE_COMPENSATION, (CaptureRequest.Key) Integer.valueOf(AEAFHelp.m11155c()));
        } else {
            this.mOneCamera.mo13032a((CaptureRequest.Key<CaptureRequest.Key>) CaptureRequest.CONTROL_AE_EXPOSURE_COMPENSATION, (CaptureRequest.Key) Integer.valueOf(m15697c()));
        }
        this.mOneCamera.mo13103i(false);
        if (z) {
            this.mOneCamera.mo13035a((OneCamera.IntrinsicsJvm.kt_3) null);
        }
        m15522F();
        m15525H();
        this.mActivity.runOnUiThread(new Runnable() { // from class: com.oplus.camera.professional.COUIBaseListPopupWindow_10.20
            @Override // java.lang.Runnable
            public void run() {
                HSProfessionalCapMode.this.m15520E();
                HSProfessionalCapMode.this.f15535w.setPanelsBarAuto(4);
                HSProfessionalCapMode.this.f15535w.m15493b();
                HSProfessionalCapMode.this.m15661l();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: OplusGLSurfaceView_14 */
    public synchronized void m15661l() {
        this.f15535w.scrollTo(1, 0);
        this.f15535w.scrollTo(2, 0);
        this.f15535w.scrollTo(5, 0);
        this.f15535w.scrollTo(4, 0);
        ArrayList<String> arrayListM15500d = this.f15535w.m15500d(3);
        int iIndexOf = this.f15535w.m15497c(3).indexOf(ProfessionalUtil.m16135a(this.mActivity, 3));
        this.f15535w.scrollTo(3, iIndexOf);
        if (arrayListM15500d != null && arrayListM15500d.size() > iIndexOf) {
            m15567a(3, arrayListM15500d.get(iIndexOf));
        }
    }

    /* renamed from: OplusGLSurfaceView_6 */
    private void m15663m() throws Resources.NotFoundException {
        if (this.f15534v == null) {
            this.f15534v = new HSListProfessionalModeBar(this.mActivity, m15696b());
            this.f15534v.setPanelInterface(this.f15535w);
            this.f15534v.setVisibility(4);
            if (1.0d == getTargetPreviewRatio(this.mOneCamera.mo13086e())) {
                this.f15534v.setBackgroundResource(0);
            } else {
                this.f15534v.setBackgroundResource(R.drawable.main_bar_bg_grad);
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.f15493J);
            layoutParams.addRule(12);
            layoutParams.addRule(14);
            layoutParams.bottomMargin = this.f15496M;
            HSListModeBarAdapter c2886d = new HSListModeBarAdapter(this.mActivity, this.f15535w.m15475a(true));
            c2886d.m15422a((PanelInterface) this.f15535w);
            m15571a(this.f15534v, R.id_renamed.main_bar_id, c2886d, this);
            this.f15485B.addView(this.f15534v, layoutParams);
        }
    }

    /* renamed from: OplusGLSurfaceView_11 */
    private void m15665n() {
        if (this.f15535w == null) {
            this.f15535w = new HSPanelContainer(this.mActivity, this.mCameraInterface);
            this.f15535w.setGravity(17);
            this.f15535w.setId(View.generateViewId());
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(Util.getScreenWidth(), this.f15495L);
            layoutParams.addRule(14);
            layoutParams.addRule(12);
            this.f15485B.addView(this.f15535w, layoutParams);
        }
    }

    /* renamed from: o */
    private void m15666o() throws Resources.NotFoundException, NumberFormatException {
        int OplusGLSurfaceView_13;
        this.f15532t = Thread.currentThread();
        int properCameraId = getProperCameraId(this.mCameraId);
        CameraLog.m12954a("HSProfessionalCapMode", "addViewToRoot, mUiThread: " + this.f15532t);
        this.f15526n = false;
        m15684x();
        m15665n();
        HSPanelContainer c2889g = this.f15535w;
        if (c2889g != null && (OplusGLSurfaceView_13 = this.f15487D) != properCameraId && OplusGLSurfaceView_13 != -1) {
            c2889g.m15501d();
        }
        this.f15487D = properCameraId;
        if (Util.m24508z(this.mActivity)) {
            this.f15535w.m15486a(getCameraInfo(this.f15487D), this.f15484A, (HSPanelContainer.PlatformImplementations.kt_3) null);
            if (isSuperRawOpen()) {
                this.f15535w.m15485a(getCameraInfo(this.f15487D), 2000000000L);
            }
            m15663m();
            this.f15535w.setSettleListener(this.f15534v);
            this.f15535w.setMotionListener(this.f15518ai);
            m15690a(1);
            this.f15489F = true;
        }
        m15671q();
        m15675s();
        this.f15515af = new TextView(this.mActivity);
        this.f15515af.setWillNotDraw(true);
        this.f15515af.setVisibility(4);
        this.f15515af.setBackgroundResource(R.drawable.screen_hint_textview_bg);
        this.f15515af.setLineSpacing(this.mActivity.getResources().getDimensionPixelSize(R.dimen.camera_hint_extra_line_spacing), this.f15515af.getLineSpacingMultiplier());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.mActivity.getResources().getDimensionPixelSize(R.dimen.camera_up_hint_text_secondary_max_width), -2);
        layoutParams.addRule(13);
        layoutParams.setMargins(this.mActivity.getResources().getDimensionPixelSize(R.dimen.camera_hint_text_padding_left), this.mActivity.getResources().getDimensionPixelSize(R.dimen.camera_hint_text_padding_top), this.mActivity.getResources().getDimensionPixelSize(R.dimen.camera_hint_text_padding_right), this.mActivity.getResources().getDimensionPixelSize(R.dimen.camera_hint_text_padding_bottom));
        this.mCameraUIInterface.mo18163b().addView(this.f15515af, layoutParams);
        this.f15511ab = this.mActivity.getResources().getDimensionPixelSize(R.dimen.camera_hint_text_padding_bottom);
        this.f15512ac = this.mActivity.getResources().getDimensionPixelSize(R.dimen.camera_hint_text_padding_bottom_size_type_1_1);
        if ("square".equals(this.mPreferences.getString(CameraUIInterface.KEY_PHOTO_RATIO, this.mActivity.getString(R.string.camera_photo_ratio_default_value)))) {
            this.f15513ad = Util.m24184L() + Util.m24186N();
        } else {
            this.f15513ad = Util.m24186N();
        }
    }

    /* renamed from: p */
    private int m15668p() {
        RelativeLayout relativeLayoutMo18253p;
        int iM24186N = Util.m24186N();
        return (this.mCameraUIInterface == null || (relativeLayoutMo18253p = this.mCameraUIInterface.mo18253p()) == null || relativeLayoutMo18253p.getTop() <= iM24186N) ? iM24186N : relativeLayoutMo18253p.getTop();
    }

    /* renamed from: q */
    private void m15671q() throws Resources.NotFoundException {
        if (this.f15490G == null) {
            this.f15490G = new RotateImageView(this.mActivity);
            this.f15490G.setId(R.id_renamed.professional_parameter_bottom_guide_entry);
            this.f15490G.setImageResource(R.drawable.professional_mode_guide_icon);
            this.f15491H = this.f15490G.getDrawable().getIntrinsicWidth();
            int iM15668p = m15668p();
            CameraLog.m12954a("HSProfessionalCapMode", "addBottomGuideEntry, previewMarginTop: " + iM15668p);
            int dimensionPixelSize = iM15668p + this.f15486C.getDimensionPixelSize(R.dimen.common_bottom_guide_professional_entry_margin_top);
            int dimensionPixelSize2 = this.f15486C.getDimensionPixelSize(R.dimen.common_bottom_guide_professional_entry_margin_end);
            int dimensionPixelSize3 = (this.f15486C.getDimensionPixelSize(R.dimen.common_bottom_guide_professional_entry_touch_width) - this.f15491H) / 2;
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(10);
            layoutParams.addRule(21);
            layoutParams.topMargin = dimensionPixelSize - dimensionPixelSize3;
            layoutParams.setMarginEnd(dimensionPixelSize2 - dimensionPixelSize3);
            this.f15490G.setLayoutParams(layoutParams);
            this.f15490G.setPadding(dimensionPixelSize3, dimensionPixelSize3, dimensionPixelSize3, dimensionPixelSize3);
            this.f15490G.setOnClickListener(new View.OnClickListener() { // from class: com.oplus.camera.professional.-$$Lambda$Y0n6cbv01i90Hy6rrgxf_rJhiOM
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.COUIBaseListPopupWindow_12$0.onClick(view);
                }
            });
        }
        this.f15490G.m18348a(this.mCameraInterface.mo10591u(), false);
        this.mCameraUIInterface.mo18087a((View) this.f15490G, ApsConstant.CAPTURE_MODE_PROFESSIONAL, 2, false);
        m15639d(false);
    }

    /* renamed from: r */
    private void m15673r() {
        if (this.f15490G != null) {
            int iM15668p = m15668p();
            CameraLog.m12954a("HSProfessionalCapMode", "updateBottomGuideEntryPosition, previewMarginTop: " + iM15668p);
            int dimensionPixelSize = iM15668p + this.f15486C.getDimensionPixelSize(R.dimen.common_bottom_guide_professional_entry_margin_top);
            int dimensionPixelSize2 = (this.f15486C.getDimensionPixelSize(R.dimen.common_bottom_guide_professional_entry_touch_width) - this.f15491H) / 2;
            final RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f15490G.getLayoutParams();
            int OplusGLSurfaceView_13 = dimensionPixelSize - dimensionPixelSize2;
            int i2 = layoutParams.topMargin;
            if (OplusGLSurfaceView_13 != i2) {
                ValueAnimator valueAnimator = this.f15492I;
                if (valueAnimator == null) {
                    this.f15492I = ValueAnimator.ofInt(i2, OplusGLSurfaceView_13);
                    this.f15492I.setDuration(300L);
                    this.f15492I.setInterpolator(ProfessionalAnimConstant.f15695b);
                    this.f15492I.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.professional.COUIBaseListPopupWindow_10.21
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator2) {
                            layoutParams.topMargin = ((Integer) valueAnimator2.getAnimatedValue()).intValue();
                            HSProfessionalCapMode.this.f15490G.setLayoutParams(layoutParams);
                        }
                    });
                } else {
                    valueAnimator.setIntValues(i2, OplusGLSurfaceView_13);
                }
                if (this.f15492I.isRunning()) {
                    return;
                }
                this.f15492I.start();
                return;
            }
            layoutParams.topMargin = OplusGLSurfaceView_13;
            this.f15490G.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: IntrinsicsJvm.kt_5 */
    public void m15639d(boolean z) {
        if (this.mbModePreInit) {
            boolean z2 = ("on".equals(this.mPreferences.getString(CameraUIInterface.KEY_SUB_SETTING, "off")) || this.f15499P || !this.f15500Q) ? false : true;
            RotateImageView rotateImageView = this.f15490G;
            if (rotateImageView != null) {
                if (!z) {
                    rotateImageView.clearAnimation();
                    this.f15490G.setVisibility(z2 ? 0 : 4);
                    this.f15490G.setAlpha(1.0f);
                } else if (z2) {
                    Util.m24271a(rotateImageView, 0, (Animation.AnimationListener) null, 250L, 250L, ProfessionalAnimConstant.f15694a);
                } else {
                    Util.m24271a(rotateImageView, 4, (Animation.AnimationListener) null, 250L, 0L, ProfessionalAnimConstant.f15694a);
                }
            }
        }
    }

    /* renamed from: s */
    private void m15675s() {
        if (this.f15536x == null) {
            this.f15536x = new RotateImageView(this.mActivity.getApplicationContext());
            this.f15536x.setEnabled(true);
            this.f15536x.setFocusable(false);
            this.f15536x.setClickable(true);
            this.f15536x.setVisibility(4);
            this.f15536x.setContentDescription(this.mActivity.getResources().getString(R.string.camera_setting_menu_parameter_default));
            this.f15536x.setOnClickListener(new View.OnClickListener() { // from class: com.oplus.camera.professional.COUIBaseListPopupWindow_10.22
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    HSProfessionalCapMode.this.m15581a(true, HSProfessionalCapMode.this.mPreferences.getString(CameraUIInterface.KEY_PARAMETER_SAVING, "off"));
                    HSProfessionalCapMode.this.m15680v();
                }
            });
            final Spring c1032fM15923a = ProfessionalAnimUtil.m15923a();
            this.f15536x.setOnTouchListener(new View.OnTouchListener() { // from class: com.oplus.camera.professional.COUIBaseListPopupWindow_10.2
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    int action = motionEvent.getAction();
                    if (action == 0) {
                        ProfessionalAnimUtil.m15924a((View) HSProfessionalCapMode.this.f15536x, c1032fM15923a, true);
                    } else if (action == 1 || action == 3) {
                        ProfessionalAnimUtil.m15924a((View) HSProfessionalCapMode.this.f15536x, c1032fM15923a, false);
                    }
                    return false;
                }
            });
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(21);
            layoutParams.addRule(11);
            layoutParams.topMargin = this.f15486C.getDimensionPixelSize(R.dimen.control_button_margin_top);
            layoutParams.setMarginEnd(this.f15486C.getDimensionPixelSize(R.dimen.control_button_margin_edge));
            this.f15536x.setLayoutParams(layoutParams);
            this.f15536x.setImageResource(R.drawable.ic_parameter_saving_store);
            this.f15536x.setBackgroundResource(R.drawable.switch_camera_button_bg);
            ((RelativeLayout) this.mActivity.findViewById(R.id_renamed.control_panel_button_layout)).addView(this.f15536x);
        }
        this.f15536x.m18348a(this.mCameraInterface.mo10591u(), false);
        m15678u();
        m15680v();
    }

    /* renamed from: t */
    private boolean m15676t() {
        return (!getSupportFunction(CameraUIInterface.KEY_PARAMETER_SAVING) || this.mPreferences == null || this.mPreferences.getString(CameraUIInterface.KEY_PARAMETER_SAVING, "off").equals("off")) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: u */
    public void m15678u() {
        this.f15528p = m15676t();
        RotateImageView rotateImageView = this.f15536x;
        if (rotateImageView != null) {
            rotateImageView.setVisibility(this.f15528p ? 0 : 4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: v */
    public void m15680v() {
        if (m15676t()) {
            boolean z = !this.f15535w.m15492a(this.mPreferences.getString(CameraUIInterface.KEY_SWITCH_CAMERA, "camera_main"), this.mPreferences.getString(CameraUIInterface.KEY_PARAMETER_SAVING, "off"));
            RotateImageView rotateImageView = this.f15536x;
            if (rotateImageView != null) {
                rotateImageView.setEnabled(z);
                if (z) {
                    this.f15536x.setColorFilter(Util.m24164A(this.mActivity));
                } else {
                    this.f15536x.setColorFilter(ContextCompat.m2254c(this.mActivity, R.color.camera_white));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public void m15581a(boolean z, String str) {
        String string = this.mPreferences.getString(CameraUIInterface.KEY_SWITCH_CAMERA, "camera_main");
        if (z) {
            this.f15535w.m15495b(string, str);
        } else {
            this.f15535w.m15498c(string, str);
        }
    }

    /* renamed from: w */
    private void m15683w() {
        m15580a(this.f15535w.mo13582b(0), 0);
        m15680v();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public int getZoomBarOffset() {
        if (1.0d == getTargetPreviewRatio(this.mOneCamera.mo13086e())) {
            return this.f15493J + this.mActivity.getResources().getDimensionPixelSize(R.dimen.hs_zoom_seekbar_offset_1_1_pro);
        }
        return this.f15493J;
    }

    /* renamed from: x */
    private void m15684x() {
        if (this.f15485B == null) {
            this.f15485B = new PlatformImplementations.kt_3(this.mActivity);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, Util.getScreenWidth());
            layoutParams.addRule(12);
            layoutParams.addRule(14);
            if (this.mCameraInterface != null) {
                layoutParams.bottomMargin = (this.mCameraUIInterface.mo18261r() - this.f15494K) - this.f15496M;
            } else {
                layoutParams.bottomMargin = 0;
            }
            this.f15485B.setLayoutParams(layoutParams);
            this.f15485B.setVisibility(8);
            this.f15485B.getViewTreeObserver().addOnWindowFocusChangeListener(new ViewTreeObserver.OnWindowFocusChangeListener() { // from class: com.oplus.camera.professional.COUIBaseListPopupWindow_10.3
                @Override // android.view.ViewTreeObserver.OnWindowFocusChangeListener
                public void onWindowFocusChanged(boolean z) {
                    if (HSProfessionalCapMode.this.f15534v != null) {
                        CameraLog.m12954a("HSProfessionalCapMode", "onWindowFocusChanged, SelectedPosition: " + HSProfessionalCapMode.this.f15534v.getSelectedPosition() + ", hasFocus: " + z);
                        HSProfessionalCapMode.this.f15534v.m15435a(HSProfessionalCapMode.this.f15534v.getSelectedPosition(), true);
                    }
                }
            });
        }
        this.mCameraUIInterface.mo18087a((View) this.f15485B, ApsConstant.CAPTURE_MODE_PROFESSIONAL, 1, false);
        PlatformImplementations.kt_3 aVar = this.f15485B;
        if (aVar != null) {
            aVar.m15699a(true);
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void checkoutTimerSnapShotState() {
        super.checkoutTimerSnapShotState();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onTimeSnapShotEnd(boolean z) {
        MainShutterButtonInfo shutterButtonInfo = getShutterButtonInfo();
        this.f15535w.m15503e();
        this.f15534v.m15432a();
        m15620b(0, true);
        if (this.f15521i && z) {
            shutterButtonInfo.m19226a(8);
            shutterButtonInfo.m19227a("button_color_inside_none");
        } else {
            shutterButtonInfo.m19226a(Util.m24352ao() ? 23 : 11);
            shutterButtonInfo.m19227a("button_color_inside_none");
        }
        this.mCameraUIInterface.mo18091a(shutterButtonInfo);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean onBackPressed() {
        CameraLog.m12962c("HSProfessionalCapMode", "onBackPressed, mbInCapturing: " + this.mbInCapturing);
        m15620b(0, true);
        if (this.f15534v.isSelected()) {
            this.mCameraInterface.mo10492a(true, true);
            this.mCameraInterface.mo10563d(true);
            ProfessionalAnimUtil.PlatformImplementations.kt_3 aVar = new ProfessionalAnimUtil.PlatformImplementations.kt_3();
            aVar.f15706a = false;
            aVar.f15708c = 250;
            aVar.f15712g = 400;
            aVar.f15709d = 0.0f;
            aVar.f15710e = this.mActivity.getResources().getDimensionPixelSize(R.dimen.hs_main_mode_bar_item_animation_offset);
            this.f15535w.setAllPopupInvisibility(aVar);
            this.f15534v.m15432a();
            this.mOneCamera.mo13105j(true);
            return true;
        }
        return super.onBackPressed();
    }

    @Override // com.oplus.camera.capmode.BaseMode, com.oplus.camera.p141e.OneCamera.PlatformImplementations.kt_3
    public void onCaptureSequenceCompleted() {
        super.onCaptureSequenceCompleted();
        CameraLog.m12962c("HSProfessionalCapMode", "onCaptureSequenceCompleted");
        if (isSuperRawOpen()) {
            this.mCameraUIInterface.mo18067a(R.string.camera_scene_night_keep_phone_steady);
            if (this.f15520h) {
                return;
            }
            this.mCameraUIInterface.mo18091a(new MainShutterButtonInfo());
            this.mCameraUIInterface.mo18107a(false, true);
            if (this.mActivity != null) {
                this.mActivity.runOnUiThread(new Runnable() { // from class: com.oplus.camera.professional.COUIBaseListPopupWindow_10.4
                    @Override // java.lang.Runnable
                    public void run() {
                        if (HSProfessionalCapMode.this.mbPaused || HSProfessionalCapMode.this.f15533u == null) {
                            return;
                        }
                        HSProfessionalCapMode.this.f15533u.m20105f();
                    }
                });
            }
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected boolean onStopTakePicture() {
        if (2 != this.mCameraInterface.mo10570g()) {
            CameraLog.m12967f("HSProfessionalCapMode", "onStopTakePicture failed, current camera state is " + this.mCameraInterface.mo10570g());
            return false;
        }
        this.mActivity.runOnUiThread(new Runnable() { // from class: com.oplus.camera.professional.COUIBaseListPopupWindow_10.5
            /* JADX WARN: Removed duplicated region for block: B:6:0x0018  */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public void run() throws android.content.res.Resources.NotFoundException {
                /*
                    r6 = this;
                    com.oplus.camera.professional.COUIBaseListPopupWindow_10 r0 = com.oplus.camera.professional.HSProfessionalCapMode.this
                    java.lang.String r1 = com.oplus.camera.professional.HSProfessionalCapMode.m15519E(r0)
                    boolean r0 = com.oplus.camera.professional.HSProfessionalCapMode.m15584a(r0, r1)
                    if (r0 != 0) goto L18
                    com.oplus.camera.professional.COUIBaseListPopupWindow_10 r0 = com.oplus.camera.professional.HSProfessionalCapMode.this
                    java.lang.String r1 = com.oplus.camera.professional.HSProfessionalCapMode.m15519E(r0)
                    boolean r0 = com.oplus.camera.professional.HSProfessionalCapMode.m15626b(r0, r1)
                    if (r0 == 0) goto L4c
                L18:
                    com.oplus.camera.professional.COUIBaseListPopupWindow_10 r0 = com.oplus.camera.professional.HSProfessionalCapMode.this
                    com.oplus.camera.COUIBaseListPopupWindow_8.IntrinsicsJvm.kt_5 r0 = com.oplus.camera.professional.HSProfessionalCapMode.m15521F(r0)
                    r0.mo13098h()
                    com.oplus.camera.professional.COUIBaseListPopupWindow_10 r0 = com.oplus.camera.professional.HSProfessionalCapMode.this
                    com.oplus.camera.capmode.PlatformImplementations.kt_3 r0 = com.oplus.camera.professional.HSProfessionalCapMode.m15523G(r0)
                    r0.mo10467W()
                    com.oplus.camera.professional.COUIBaseListPopupWindow_10 r0 = com.oplus.camera.professional.HSProfessionalCapMode.this
                    com.oplus.camera.professional.HSProfessionalCapMode.m15526H(r0)
                    com.oplus.camera.professional.COUIBaseListPopupWindow_10 r0 = com.oplus.camera.professional.HSProfessionalCapMode.this
                    boolean r0 = r0.isSuperRawOpen()
                    if (r0 == 0) goto L4c
                    com.oplus.camera.professional.COUIBaseListPopupWindow_10 r0 = com.oplus.camera.professional.HSProfessionalCapMode.this
                    com.oplus.camera.ui.CameraUIInterface r0 = com.oplus.camera.professional.HSProfessionalCapMode.m15527I(r0)
                    r1 = 2131755796(0x7f100314, float:1.9142481E38)
                    r0.mo18067a(r1)
                    com.oplus.camera.professional.COUIBaseListPopupWindow_10 r0 = com.oplus.camera.professional.HSProfessionalCapMode.this
                    com.oplus.camera.ui.COUIBaseListPopupWindow_10 r0 = com.oplus.camera.professional.HSProfessionalCapMode.m15636d(r0)
                    r0.mo20099a()
                L4c:
                    com.oplus.camera.professional.COUIBaseListPopupWindow_10 r0 = com.oplus.camera.professional.HSProfessionalCapMode.this
                    com.oplus.camera.professional.COUIBaseListPopupWindow_11 r0 = com.oplus.camera.professional.HSProfessionalCapMode.m15682w(r0)
                    r0.m15503e()
                    com.oplus.camera.professional.COUIBaseListPopupWindow_10 r0 = com.oplus.camera.professional.HSProfessionalCapMode.this
                    com.oplus.camera.professional.COUIBaseListPopupWindow_8 r0 = com.oplus.camera.professional.HSProfessionalCapMode.m15515C(r0)
                    r0.m15432a()
                    com.oplus.camera.professional.COUIBaseListPopupWindow_10 r0 = com.oplus.camera.professional.HSProfessionalCapMode.this
                    r1 = 1
                    r2 = 0
                    com.oplus.camera.professional.HSProfessionalCapMode.m15574a(r0, r2, r1)
                    com.oplus.camera.professional.COUIBaseListPopupWindow_10 r0 = com.oplus.camera.professional.HSProfessionalCapMode.this
                    com.oplus.camera.professional.COUIBaseListPopupWindow_10$PlatformImplementations.kt_3 r0 = com.oplus.camera.professional.HSProfessionalCapMode.m15529J(r0)
                    r3 = 0
                    r4 = 300(0x12c, double:1.48E-321)
                    com.oplus.camera.util.Util.m24270a(r0, r2, r3, r4)
                    com.oplus.camera.professional.COUIBaseListPopupWindow_10 r0 = com.oplus.camera.professional.HSProfessionalCapMode.this
                    com.oplus.camera.professional.HSProfessionalCapMode.m15638d(r0, r2)
                    com.oplus.camera.professional.COUIBaseListPopupWindow_10 r6 = com.oplus.camera.professional.HSProfessionalCapMode.this
                    com.oplus.camera.ui.CameraUIInterface r6 = com.oplus.camera.professional.HSProfessionalCapMode.m15531K(r6)
                    r6.mo18191c(r1, r2)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.professional.HSProfessionalCapMode.MoreUIControl_7.run():void");
            }
        });
        this.mbInCapturing = false;
        setCapturePreviewDataState(2);
        this.f15485B.m15699a(true);
        this.mCameraInterface.mo10569f(true);
        this.mCameraUIInterface.mo18107a(true, false);
        return true;
    }

    /* renamed from: y */
    private void m15687y() {
        this.mCameraUIInterface.mo18217g(true);
        RotateImageView rotateImageView = this.f15536x;
        if (rotateImageView != null) {
            rotateImageView.setVisibility(4);
        }
        PlatformImplementations.kt_3 aVar = this.f15485B;
        if (aVar != null) {
            aVar.m15699a(false);
            HSListProfessionalModeBar c2887e = this.f15534v;
            if (c2887e != null) {
                c2887e.removeAllViews();
                this.f15485B.removeView(this.f15534v);
                this.f15534v = null;
            }
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void onDeInitCameraMode(String str) throws Resources.NotFoundException {
        CameraLog.m12962c("HSProfessionalCapMode", "onDeInitCameraMode");
        Handler handler = this.f15484A;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        HSListProfessionalModeBar c2887e = this.f15534v;
        if (c2887e != null && c2887e.isSelected() && this.f15534v.isShown()) {
            m15620b(0, true);
        }
        HSPanelContainer c2889g = this.f15535w;
        if (c2889g != null) {
            c2889g.m15508h();
        }
        if (m15689z()) {
            this.mCameraUIInterface.mo18282w(true);
        }
        PlatformImplementations.kt_3 aVar = this.f15485B;
        if (aVar != null && aVar.getVisibility() != 0) {
            m15528I();
            m15687y();
        }
        m15623b("0", false);
        ValueAnimator valueAnimator = this.f15516ag;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.f15516ag.cancel();
        }
        HistogramProcessorManager c2826p = this.f15537y;
        if (c2826p != null) {
            c2826p.m14849c();
            this.f15537y = null;
        }
        if (m15550T() && this.f15510aa != 0) {
            this.f15510aa = 0;
            m15637d(0);
        }
        this.mCameraUIInterface.mo18281w(0);
        this.mCameraUIInterface.mo18163b().removeView(this.f15515af);
        HintManager c3130aMo18233k = this.mCameraUIInterface.mo18233k();
        if (c3130aMo18233k != null) {
            c3130aMo18233k.m18484a((HintManager.IntrinsicsJvm.kt_4) null);
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void operateSpecificViewCallBack(Object obj, boolean z, boolean z2) {
        if ((obj instanceof Integer) && 1 == ((Integer) obj).intValue() && !z) {
            if (z2) {
                CameraLog.m12959b("HSProfessionalCapMode", "removeAllView when mEmptyViewToAnimate hide animation end");
                m15528I();
                m15687y();
            } else if (this.f15534v != null) {
                ProfessionalAnimUtil.PlatformImplementations.kt_3 aVar = new ProfessionalAnimUtil.PlatformImplementations.kt_3();
                aVar.f15706a = false;
                aVar.f15708c = 250;
                aVar.f15709d = 0.0f;
                aVar.f15710e = getZoomBarOffset();
                aVar.f15712g = 500;
                ProfessionalAnimUtil.m15922a(this.f15534v, aVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: IntrinsicsJvm.kt_4 */
    public boolean m15628b(String str) {
        return str != null && C1547C.NANOS_PER_SECOND <= Long.parseLong(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: IntrinsicsJvm.kt_3 */
    public boolean m15635c(String str) {
        return str != null && isSuperRawOpen() && C1547C.NANOS_PER_SECOND <= Long.parseLong(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: IntrinsicsJvm.kt_5 */
    public boolean m15640d(String str) {
        return str != null && isSuperRawOpen() && 500000000 <= Long.parseLong(str);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected boolean isHideUICapture() {
        return m15628b(m15655i()) && getIsCapturingState();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected boolean onBeforeSnapping(CameraRequestTag c2693c) {
        HSPanelContainer c2889g = this.f15535w;
        if (c2889g != null && c2889g.m15506g()) {
            CameraLog.m12962c("HSProfessionalCapMode", "onBeforeSnapping, HSLevelPanelScrolling");
            return false;
        }
        this.mActivity.runOnUiThread(new Runnable() { // from class: com.oplus.camera.professional.COUIBaseListPopupWindow_10.6
            @Override // java.lang.Runnable
            public void run() throws Resources.NotFoundException {
                if (HSProfessionalCapMode.this.mbPaused) {
                    CameraLog.m12954a("HSProfessionalCapMode", "onBeforeSnapping, return after pause");
                    return;
                }
                if (HSProfessionalCapMode.this.isSuperRawOpen()) {
                    HSProfessionalCapMode viewOnClickListenerC2890h = HSProfessionalCapMode.this;
                    if (viewOnClickListenerC2890h.m15640d(viewOnClickListenerC2890h.m15655i()) && HSProfessionalCapMode.this.mCameraUIInterface != null) {
                        HSProfessionalCapMode.this.mCameraUIInterface.mo18070a(R.string.camera_scene_night_keep_phone_steady, -1, false, false, true);
                    }
                    HSProfessionalCapMode viewOnClickListenerC2890h2 = HSProfessionalCapMode.this;
                    if (viewOnClickListenerC2890h2.m15635c(viewOnClickListenerC2890h2.m15655i())) {
                        int iLongValue = ((int) (Long.valueOf(HSProfessionalCapMode.this.m15655i()).longValue() / 1000000)) * 3;
                        HSProfessionalCapMode.this.f15533u.m20100a(iLongValue);
                        if (HSProfessionalCapMode.this.mCameraUIInterface != null) {
                            HSProfessionalCapMode.this.mCameraUIInterface.mo18221h(iLongValue);
                        }
                    }
                    if (HSProfessionalCapMode.this.mCameraUIInterface != null) {
                        HSProfessionalCapMode.this.mCameraUIInterface.mo18215g(4);
                        HSProfessionalCapMode.this.mCameraUIInterface.mo18209f(4);
                        HSProfessionalCapMode.this.m15620b(4, true);
                        HSProfessionalCapMode.this.mCameraInterface.mo10479a((AnimatorListenerAdapter) null, true, false);
                    }
                    HSProfessionalCapMode.this.f15500Q = false;
                    HSProfessionalCapMode.this.m15639d(false);
                    HSProfessionalCapMode.this.m15625b(false, false);
                    Util.m24270a(HSProfessionalCapMode.this.f15485B, 4, (Animation.AnimationListener) null, 300L);
                    Util.m24270a(HSProfessionalCapMode.this.f15536x, 4, (Animation.AnimationListener) null, 300L);
                } else {
                    HSProfessionalCapMode viewOnClickListenerC2890h3 = HSProfessionalCapMode.this;
                    if (viewOnClickListenerC2890h3.m15628b(viewOnClickListenerC2890h3.m15655i())) {
                        if (HSProfessionalCapMode.this.mCameraUIInterface != null) {
                            HSProfessionalCapMode.this.mCameraUIInterface.mo18215g(4);
                            HSProfessionalCapMode.this.mCameraUIInterface.mo18209f(4);
                            HSProfessionalCapMode.this.m15620b(4, true);
                            HSProfessionalCapMode.this.mCameraInterface.mo10479a((AnimatorListenerAdapter) null, true, false);
                        }
                        HSProfessionalCapMode.this.f15500Q = false;
                        HSProfessionalCapMode.this.m15639d(false);
                        HSProfessionalCapMode.this.m15583a(false, false, true);
                        Util.m24270a(HSProfessionalCapMode.this.f15485B, 4, (Animation.AnimationListener) null, 300L);
                        Util.m24270a(HSProfessionalCapMode.this.f15536x, 4, (Animation.AnimationListener) null, 300L);
                        if (HSProfessionalCapMode.this.mCameraUIInterface != null) {
                            HSProfessionalCapMode.this.mCameraUIInterface.mo18221h((int) (Long.valueOf(HSProfessionalCapMode.this.m15655i()).longValue() / 1000000));
                        }
                    }
                }
                HSProfessionalCapMode.this.f15485B.m15699a(false);
                if (!HSProfessionalCapMode.this.f15521i || HSProfessionalCapMode.this.mCameraUIInterface == null || HSProfessionalCapMode.this.mCameraUIInterface.mo18265s() == 2) {
                    return;
                }
                HSProfessionalCapMode.this.mCameraUIInterface.mo18091a(new MainShutterButtonInfo(4, "button_color_inside_none"));
            }
        });
        setRawRequestTag(false);
        this.f15501R = null;
        if (isRawOpen()) {
            setRawRequestTag(true);
            this.f15525m = false;
        }
        if (isSuperRawOpen()) {
            setRawRequestTag(false);
            this.f15525m = false;
            synchronized (this.f15519g) {
                this.f15503T = false;
            }
        }
        m15517D();
        if (this.mOneCamera != null) {
            this.mOneCamera.mo13105j(true);
        }
        setCaptureRequestPictureSizeScale();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m15619b(int OplusGLSurfaceView_13) throws Resources.NotFoundException {
        CameraLog.m12954a("HSProfessionalCapMode", "setCameraMenuControlViewVisibility, visibility: " + OplusGLSurfaceView_13);
        if (this.mCameraUIInterface != null) {
            this.mCameraUIInterface.mo18215g(OplusGLSurfaceView_13);
            this.mCameraUIInterface.mo18209f(OplusGLSurfaceView_13);
            this.mCameraUIInterface.mo18184c(OplusGLSurfaceView_13);
            this.mCameraUIInterface.mo18167b(OplusGLSurfaceView_13, true);
        }
        this.f15500Q = OplusGLSurfaceView_13 == 0;
        m15639d(false);
        m15583a(false, false, true);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean onAfterSnapping() {
        CameraLog.m12954a("HSProfessionalCapMode", "onAfterSnapping");
        if (!this.f15521i && this.mCameraInterface.mo10575i() && Long.parseLong(m15655i()) >= C1547C.NANOS_PER_SECOND) {
            this.mCameraInterface.mo10558c(Util.m24352ao() ? 6 : 4);
        } else {
            CameraLog.m12954a("HSProfessionalCapMode", "onAfterSnapping is ZSL mode, do nothing");
        }
        if (isSuperRawOpen()) {
            this.f15520h = false;
        }
        this.mActivity.runOnUiThread(new Runnable() { // from class: com.oplus.camera.professional.COUIBaseListPopupWindow_10.7
            @Override // java.lang.Runnable
            public void run() {
                if (HSProfessionalCapMode.this.mbPaused) {
                    return;
                }
                if (HSProfessionalCapMode.this.isSuperRawOpen()) {
                    MainShutterButtonInfo shutterButtonInfo = HSProfessionalCapMode.this.getShutterButtonInfo();
                    HSProfessionalCapMode viewOnClickListenerC2890h = HSProfessionalCapMode.this;
                    if (viewOnClickListenerC2890h.m15635c(viewOnClickListenerC2890h.m15655i())) {
                        HSProfessionalCapMode.this.mCameraUIInterface.mo18107a(true, false);
                        HSProfessionalCapMode.this.mCameraUIInterface.mo18226i(HSProfessionalCapMode.this.f15486C.getDimensionPixelOffset(R.dimen.night_countdown_time_margin_top));
                        HSProfessionalCapMode.this.f15533u.mo20103d();
                        HSProfessionalCapMode.this.f15533u.mo20104e();
                        if (HSProfessionalCapMode.this.mCameraUIInterface.mo18265s() == 9) {
                            shutterButtonInfo.m19226a(3);
                            shutterButtonInfo.m19227a("button_color_inside_none");
                        } else {
                            shutterButtonInfo.m19226a(15);
                            shutterButtonInfo.m19227a("button_color_inside_none");
                        }
                    } else {
                        shutterButtonInfo.m19226a(4);
                        shutterButtonInfo.m19227a("button_color_inside_none");
                    }
                    HSProfessionalCapMode.this.mCameraUIInterface.mo18091a(shutterButtonInfo);
                    return;
                }
                HSProfessionalCapMode viewOnClickListenerC2890h2 = HSProfessionalCapMode.this;
                if (viewOnClickListenerC2890h2.m15628b(viewOnClickListenerC2890h2.m15655i())) {
                    HSProfessionalCapMode.this.mCameraUIInterface.mo18107a(true, false);
                    MainShutterButtonInfo shutterButtonInfo2 = HSProfessionalCapMode.this.getShutterButtonInfo();
                    if (HSProfessionalCapMode.this.mCameraUIInterface.mo18265s() == 9) {
                        shutterButtonInfo2.m19226a(3);
                        shutterButtonInfo2.m19227a("button_color_inside_none");
                    } else {
                        shutterButtonInfo2.m19226a(Util.m24352ao() ? 27 : 7);
                        shutterButtonInfo2.m19227a("button_color_inside_none");
                    }
                    HSProfessionalCapMode.this.mCameraUIInterface.mo18091a(shutterButtonInfo2);
                }
            }
        });
        CameraLog.m12954a("HSProfessionalCapMode", "onAfterSnapping X");
        return true;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void onShutterCallback(boolean z, boolean z2) throws Resources.NotFoundException {
        super.onShutterCallback(z, z2);
        if (z2) {
            if (!this.f15521i && this.mCameraInterface.mo10575i() && Long.parseLong(m15655i()) >= C1547C.NANOS_PER_SECOND) {
                if (!isSuperRawOpen()) {
                    this.mCameraInterface.mo10558c(Util.m24352ao() ? 7 : 5);
                    m15619b(0);
                }
            } else {
                this.mCameraInterface.mo10558c(0);
            }
            if (isSuperRawOpen()) {
                return;
            }
            this.mCameraInterface.mo10572h();
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode, com.oplus.camera.p141e.OneCamera.PlatformImplementations.kt_3
    public void onCaptureCompleted(CameraCaptureResult cameraCaptureResult, CameraRequestTag c2693c) {
        super.onCaptureCompleted(cameraCaptureResult, c2693c);
        CameraLog.m12954a("HSProfessionalCapMode", "onCaptureCompleted, systemTime: " + System.currentTimeMillis());
    }

    @Override // com.oplus.camera.capmode.BaseMode, com.oplus.camera.p141e.OneCamera.PlatformImplementations.kt_3
    public void onCaptureFailed(CaptureRequest captureRequest, CameraRequestTag c2693c) {
        super.onCaptureFailed(captureRequest, c2693c);
        if (isSuperRawOpen()) {
            this.f15520h = true;
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void onBeforePictureTaken(byte[] bArr, boolean z) {
        CameraLog.m12962c("HSProfessionalCapMode", "onBeforePictureTaken");
        if (this.f15521i) {
            this.mCameraUIInterface.mo18092a(getShutterButtonInfo(), false);
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected boolean getNeedStoreRawPic() {
        return isSuperRawOpen();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void onAfterPictureTaken(byte[] bArr, boolean z) throws Resources.NotFoundException {
        CameraLog.m12954a("HSProfessionalCapMode", "onAfterPictureTaken");
        if (!this.f15525m && isRawRequestTag()) {
            this.f15525m = true;
            return;
        }
        if (isSuperRawOpen()) {
            m15619b(0);
            Util.m24270a(this.f15485B, 0, (Animation.AnimationListener) null, 300L);
            if (!this.f15534v.isSelected()) {
                this.mCameraInterface.mo10492a(true, false);
                this.mCameraInterface.mo10563d(true);
            }
            this.mCameraUIInterface.mo18091a(getShutterButtonInfo());
            if (m15676t()) {
                Util.m24270a(this.f15536x, 0, (Animation.AnimationListener) null, 300L);
            }
        } else if (m15628b(m15655i())) {
            MainShutterButtonInfo shutterButtonInfo = getShutterButtonInfo();
            if (1 != this.mCameraUIInterface.mo18265s() && !Util.m24352ao()) {
                shutterButtonInfo.m19226a(11);
            }
            this.mCameraUIInterface.mo18091a(shutterButtonInfo);
            m15619b(0);
            Util.m24270a(this.f15485B, 0, (Animation.AnimationListener) null, 300L);
            if (!this.f15534v.isSelected()) {
                this.mCameraInterface.mo10492a(true, false);
            }
            if (m15676t()) {
                Util.m24270a(this.f15536x, 0, (Animation.AnimationListener) null, 300L);
            }
        }
        HSListProfessionalModeBar c2887e = this.f15534v;
        if (c2887e != null && !c2887e.isSelected() && !this.mCameraInterface.mo10454J()) {
            m15620b(0, true);
        } else {
            m15620b(4, true);
        }
        this.mCameraUIInterface.mo18200d(true, false);
        if (this.f15523k) {
            Util.m24270a(this.f15485B, 0, (Animation.AnimationListener) null, 300L);
            this.f15523k = false;
        }
        this.f15485B.m15699a(true);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void cameraIdChanged(int OplusGLSurfaceView_13) {
        super.cameraIdChanged(OplusGLSurfaceView_13);
        final int iMo10543as = this.mCameraInterface.mo10543as();
        CameraLog.m12954a("HSProfessionalCapMode", "cameraIdChanged, id_renamed: " + iMo10543as);
        if (this.f15487D != iMo10543as) {
            this.f15487D = iMo10543as;
            this.f15488E = true;
            this.mActivity.runOnUiThread(new Runnable() { // from class: com.oplus.camera.professional.COUIBaseListPopupWindow_10.8
                @Override // java.lang.Runnable
                public void run() {
                    if (HSProfessionalCapMode.this.m15689z()) {
                        HSProfessionalCapMode.this.f15534v.setVisibility(8);
                        HSProfessionalCapMode.this.f15534v.setItemPressed(false);
                        HSProfessionalCapMode.this.f15535w.m15503e();
                        if (HSProfessionalCapMode.this.f15534v.isSelected()) {
                            HSProfessionalCapMode.this.f15535w.m15503e();
                            HSProfessionalCapMode.this.f15534v.m15432a();
                            return;
                        }
                        return;
                    }
                    HSProfessionalCapMode.this.f15534v.setVisibility(0);
                    HSProfessionalCapMode.this.f15535w.setVisibility(0);
                    HSProfessionalCapMode.this.mCameraUIInterface.mo18282w(true);
                    HSProfessionalCapMode.this.m15630c(iMo10543as);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: z */
    public boolean m15689z() {
        if (this.mPreferences != null) {
            return "camera_macro".equals(this.mPreferences.getString(CameraUIInterface.KEY_SWITCH_CAMERA, "camera_main"));
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: IntrinsicsJvm.kt_3 */
    public synchronized void m15630c(int OplusGLSurfaceView_13) {
        this.f15535w.m15501d();
        OplusCameraCharacteristics cameraInfo = getCameraInfo(OplusGLSurfaceView_13);
        this.f15535w.m15479a(cameraInfo.m13286u(), cameraInfo.m13287v(), cameraInfo.m13288w(), this.f15484A);
        this.f15535w.m15483a(isSuperRawOpen() ? 2000000000L : cameraInfo.m13289x(), cameraInfo.m13290y(), cameraInfo.m13258a(256), this.f15484A);
        this.f15535w.m15489a(cameraInfo.m13245B(), this.f15484A);
        this.f15535w.m15477a(cameraInfo.m13279n(), cameraInfo.m13278m(), this.f15484A);
        this.f15535w.m15478a(cameraInfo.m13281p(), cameraInfo.m13282q(), cameraInfo.m13283r(), this.f15484A);
        this.f15535w.m15503e();
        if (this.f15534v.isSelected()) {
            this.f15535w.m15505f(this.f15534v.getSelectedIndex());
        }
        this.f15535w.m15476a();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void setOrientation(int OplusGLSurfaceView_13) throws Resources.NotFoundException {
        RotateImageView rotateImageView = this.f15490G;
        if (rotateImageView != null) {
            rotateImageView.m18348a(OplusGLSurfaceView_13, true);
        }
        RotateImageView rotateImageView2 = this.f15536x;
        if (rotateImageView2 != null) {
            rotateImageView2.m18348a(OplusGLSurfaceView_13, true);
        }
        if (this.mOrientation == OplusGLSurfaceView_13) {
            return;
        }
        this.mOrientation = OplusGLSurfaceView_13;
        HistogramProcessorManager.PlatformImplementations.kt_3 aVar = this.f15538z;
        if (aVar != null) {
            aVar.f14815e = this.mOrientation;
        }
        HintManager c3130aMo18233k = this.mCameraUIInterface.mo18233k();
        if (c3130aMo18233k != null) {
            c3130aMo18233k.m18502g();
        }
        ValueAnimator valueAnimator = this.f15516ag;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        if (m15550T() && this.f15510aa != 0) {
            this.f15510aa = 0;
        }
        m15554V();
        HistogramProcessorManager c2826p = this.f15537y;
        if (c2826p != null) {
            c2826p.m14842a(this.f15538z, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: A */
    public boolean m15512A() {
        return this.mOrientation % 180 == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: B */
    public boolean m15514B() {
        return 90 == this.mOrientation;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void onResume(boolean z) {
        CameraLog.m12954a("HSProfessionalCapMode", "onResume");
        if (this.mPreferences != null) {
            this.f15521i = "on".equals(this.mPreferences.getString(CameraUIInterface.KEY_HIGH_RESOLUTION, this.f15486C.getString(R.string.camera_high_resolution_default_value)));
        }
        HistogramProcessorManager c2826p = this.f15537y;
        if (c2826p != null) {
            c2826p.m14839a();
        }
        if (Util.m24508z(this.mActivity)) {
            PlatformImplementations.kt_3 aVar = this.f15485B;
            if (aVar != null) {
                aVar.setVisibility(0);
            }
            this.mCameraInterface.mo10563d(true);
            m15690a(1);
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void onPause() throws Resources.NotFoundException {
        CameraLog.m12954a("HSProfessionalCapMode", "onPause");
        this.mCameraUIInterface.mo18215g(0);
        this.mCameraUIInterface.mo18217g(false);
        if (m15550T() && this.f15510aa != 0) {
            this.f15510aa = 0;
            m15637d(0);
        }
        PlatformImplementations.kt_3 aVar = this.f15485B;
        if (aVar != null) {
            aVar.m15699a(false);
        }
        ValueAnimator valueAnimator = this.f15492I;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.f15492I = null;
        }
        this.f15523k = false;
        Handler handler = this.f15484A;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        HSPanelContainer c2889g = this.f15535w;
        if (c2889g != null) {
            c2889g.m15508h();
        }
        this.mCameraUIInterface.mo18200d(true, false);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void onDestroy() {
        CameraLog.m12954a("HSProfessionalCapMode", "onDestroy");
        HSPanelContainer c2889g = this.f15535w;
        if (c2889g != null) {
            c2889g.m15504f();
            this.f15535w = null;
            this.f15489F = false;
        }
        if (this.f15485B != null) {
            this.f15485B = null;
        }
        if (this.f15490G != null) {
            this.f15490G = null;
        }
        if (this.f15534v != null) {
            this.f15534v = null;
        }
        HistogramProcessorManager c2826p = this.f15537y;
        if (c2826p != null) {
            c2826p.m14849c();
            this.f15537y = null;
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public MainShutterButtonInfo getShutterButtonInfo() {
        MainShutterButtonInfo shutterButtonInfo = super.getShutterButtonInfo();
        if (Util.m24352ao()) {
            if (this.mCameraUIInterface.mo18265s() == 28 || this.mCameraUIInterface.mo18265s() == 29) {
                shutterButtonInfo.m19226a(26);
            } else {
                shutterButtonInfo.m19226a(23);
            }
        }
        return shutterButtonInfo;
    }

    /* renamed from: C */
    private void m15516C() {
        if (getSupportFunction(CameraUIInterface.KEY_SWITCH_CAMERA) && getSupportFunction(CameraUIInterface.KEY_RAW_CONTROL)) {
            if (Util.m24443e(this.mPreferences.getString(CameraUIInterface.KEY_SWITCH_CAMERA, "camera_main"))) {
                this.mCameraUIInterface.mo18171b(CameraUIInterface.KEY_RAW_CONTROL, (String) null);
            } else {
                if (!"off".equals(this.mPreferences.getString(CameraUIInterface.KEY_RAW_CONTROL, "off"))) {
                    this.mPreferences.edit().putString(CameraUIInterface.KEY_RAW_CONTROL, "off").apply();
                }
                this.mCameraUIInterface.mo18099a(CameraUIInterface.KEY_RAW_CONTROL, "off");
            }
            this.mCameraUIInterface.mo18211f(CameraUIInterface.KEY_RAW_CONTROL);
        }
        if (getSupportFunction(CameraUIInterface.KEY_SWITCH_CAMERA) && getSupportFunction(CameraUIInterface.KEY_SUPER_RAW_CONTROL)) {
            if (Util.m24443e(this.mPreferences.getString(CameraUIInterface.KEY_SWITCH_CAMERA, "camera_main"))) {
                this.mCameraUIInterface.mo18171b(CameraUIInterface.KEY_SUPER_RAW_CONTROL, (String) null);
            } else {
                if (!"off".equals(this.mPreferences.getString(CameraUIInterface.KEY_SUPER_RAW_CONTROL, "off"))) {
                    this.mPreferences.edit().putString(CameraUIInterface.KEY_SUPER_RAW_CONTROL, "off").apply();
                }
                this.mCameraUIInterface.mo18099a(CameraUIInterface.KEY_SUPER_RAW_CONTROL, "off");
            }
            this.mCameraUIInterface.mo18211f(CameraUIInterface.KEY_SUPER_RAW_CONTROL);
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected boolean isCameraSettingMenuOptionEnable(String str) {
        if (CameraUIInterface.KEY_RAW_CONTROL.equals(str) && getSupportFunction(CameraUIInterface.KEY_RAW_CONTROL) && getSupportFunction(CameraUIInterface.KEY_SWITCH_DUAL_CAMERA) && this.mPreferences != null) {
            return Util.m24443e(this.mPreferences.getString(CameraUIInterface.KEY_SWITCH_CAMERA, "camera_main"));
        }
        return super.isCameraSettingMenuOptionEnable(str);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onAfterStartPreview(boolean z) throws Resources.NotFoundException {
        CameraLog.m12959b("HSProfessionalCapMode", "onAfterStartPreview");
        PlatformImplementations.kt_3 aVar = this.f15485B;
        if (aVar != null) {
            aVar.m15699a(true);
        }
        if (m15689z()) {
            this.mCameraUIInterface.mo18166b(R.string.camera_macro_best_focus_distance_text, R.drawable.screen_hint_textview_bg, R.color.screen_hint_text_color, Integer.valueOf(CameraConfig.getConfigIntValue(ConfigDataBase.KEY_MACRO_BEST_FOCUS_DISTANCE)));
        }
        if (getSupportFunction(CameraUIInterface.KEY_PRO_HISTOGRAM)) {
            m15552U();
        }
        m15673r();
        m15540O();
        m15663m();
        super.onAfterStartPreview(z);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void onBeforePreview() throws NumberFormatException {
        CameraLog.m12954a("HSProfessionalCapMode", "onBeforePreview");
        this.mActivity.runOnUiThread(new Runnable() { // from class: com.oplus.camera.professional.COUIBaseListPopupWindow_10.9
            @Override // java.lang.Runnable
            public void run() {
                if (HSProfessionalCapMode.this.mOneCamera == null || HSProfessionalCapMode.this.mOneCamera.mo13086e() == null || HSProfessionalCapMode.this.mOneCamera.mo13086e().m13284s()) {
                    HSProfessionalCapMode.this.m15580a(true, 4);
                } else {
                    if (4 == HSProfessionalCapMode.this.f15534v.getSelectedIndex()) {
                        HSProfessionalCapMode.this.mCameraInterface.mo10492a(true, true);
                        HSProfessionalCapMode.this.mCameraInterface.mo10563d(true);
                        HSProfessionalCapMode.this.f15535w.m15503e();
                        HSProfessionalCapMode.this.f15534v.m15432a();
                        HSProfessionalCapMode.this.mOneCamera.mo13105j(false);
                    }
                    HSProfessionalCapMode.this.m15580a(false, 4);
                }
                if (HSProfessionalCapMode.this.f15534v != null) {
                    HSProfessionalCapMode.this.f15534v.m15436a(true, false);
                    if (HSProfessionalCapMode.this.f15534v.isSelected()) {
                        HSProfessionalCapMode.this.mCameraInterface.mo10479a((AnimatorListenerAdapter) null, false, false);
                        HSProfessionalCapMode.this.m15620b(4, true);
                    } else {
                        HSProfessionalCapMode.this.m15620b(0, true);
                    }
                }
            }
        });
        this.mOneCamera.mo13040a((CameraParameter.PreviewKey<CameraParameter.PreviewKey<Float>>) CameraParameter.ZOOM_RATIO, (CameraParameter.PreviewKey<Float>) Float.valueOf(this.mCameraInterface.mo10535ak()));
        if (getSupportFunction(CameraUIInterface.KEY_FOCUS_PEAKING)) {
            this.mOneCamera.mo13056a(this.mPreferences.getString(CameraUIInterface.KEY_FOCUS_PEAKING, "off").equals("on"), false);
        }
        if (this.f15488E || this.mPreferences.getBoolean(CameraUIInterface.KEY_RESTORE_PROFESSIONAL_PARAMS, false)) {
            CameraLog.m12954a("HSProfessionalCapMode", "onBeforePreview, initParamToAuto");
            m15624b(false);
            final String string = this.mPreferences.getString(CameraUIInterface.KEY_PARAMETER_SAVING, "off");
            if (!getSupportFunction(CameraUIInterface.KEY_PARAMETER_SAVING) || string.equals("off")) {
                return;
            }
            this.mActivity.runOnUiThread(new Runnable() { // from class: com.oplus.camera.professional.COUIBaseListPopupWindow_10.10
                @Override // java.lang.Runnable
                public void run() {
                    HSProfessionalCapMode.this.m15581a(false, string);
                }
            });
            return;
        }
        if (this.mbCapModeInit) {
            m15659k();
        }
        m15648f(false);
        m15517D();
    }

    /* renamed from: D */
    private void m15517D() {
        if (this.mPreferences == null || this.mOneCamera == null) {
            CameraLog.m12959b("HSProfessionalCapMode", "mPreferences or mOneCamera is null");
            return;
        }
        if (getSupportFunction(CameraUIInterface.KEY_SUPER_RAW_CONTROL)) {
            String string = this.mPreferences.getString(CameraUIInterface.KEY_SUPER_RAW_CONTROL, "off");
            char c2 = 65535;
            int iHashCode = string.hashCode();
            if (iHashCode != -332521116) {
                if (iHashCode != 3551) {
                    if (iHashCode == 109935 && string.equals("off")) {
                        c2 = 2;
                    }
                } else if (string.equals("on")) {
                    c2 = 0;
                }
            } else if (string.equals("super_raw")) {
                c2 = 1;
            }
            if (c2 == 0) {
                this.mOneCamera.mo13040a((CameraParameter.PreviewKey<CameraParameter.PreviewKey<String>>) CameraParameter.RAW_CONTROL, (CameraParameter.PreviewKey<String>) "raw");
                return;
            } else if (c2 == 1) {
                this.mOneCamera.mo13040a((CameraParameter.PreviewKey<CameraParameter.PreviewKey<String>>) CameraParameter.RAW_CONTROL, (CameraParameter.PreviewKey<String>) "super_raw");
                return;
            } else {
                if (c2 != 2) {
                    return;
                }
                this.mOneCamera.mo13040a((CameraParameter.PreviewKey<CameraParameter.PreviewKey<String>>) CameraParameter.RAW_CONTROL, (CameraParameter.PreviewKey<String>) "none");
                return;
            }
        }
        if ("on".equals(this.mPreferences.getString(CameraUIInterface.KEY_RAW_CONTROL, "off"))) {
            this.mOneCamera.mo13040a((CameraParameter.PreviewKey<CameraParameter.PreviewKey<String>>) CameraParameter.RAW_CONTROL, (CameraParameter.PreviewKey<String>) "raw");
        } else {
            this.mOneCamera.mo13040a((CameraParameter.PreviewKey<CameraParameter.PreviewKey<String>>) CameraParameter.RAW_CONTROL, (CameraParameter.PreviewKey<String>) "none");
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public String getFlashMode() throws Resources.NotFoundException {
        if (this.mPreferences == null || this.mActivity == null || this.mbFlashTemporaryDisabled) {
            return "off";
        }
        String string = this.f15486C.getString(R.string.camera_exposure_time_default_value);
        String string2 = this.mPreferences.getString("pref_professional_exposure_time_key", string);
        return (TextUtils.isEmpty(string2) || !string2.equals(string)) ? "off" : super.getFlashMode();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        RotateImageView rotateImageView;
        if (view.getId() == R.id_renamed.professional_parameter_bottom_guide_entry && this.mCameraUIInterface != null && (rotateImageView = this.f15490G) != null && rotateImageView.getVisibility() == 0) {
            this.mCameraUIInterface.mo18156at();
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void hideViewWhileResume() {
        PlatformImplementations.kt_3 aVar = this.f15485B;
        if (aVar != null) {
            aVar.setVisibility(4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: E */
    public void m15520E() {
        HSPanelContainer c2889g;
        if (this.f15534v == null || (c2889g = this.f15535w) == null) {
            return;
        }
        c2889g.setPreference(4);
    }

    /* renamed from: F */
    private void m15522F() {
        HSPanelContainer c2889g;
        if (this.f15534v == null || (c2889g = this.f15535w) == null) {
            return;
        }
        c2889g.setPreference(5);
    }

    /* renamed from: G */
    private void m15524G() {
        HSPanelContainer c2889g;
        if (this.f15534v == null || (c2889g = this.f15535w) == null) {
            return;
        }
        c2889g.setPreference(1);
        this.f15535w.setPreference(2);
    }

    /* renamed from: H */
    private void m15525H() {
        HSPanelContainer c2889g;
        if (this.f15534v == null || (c2889g = this.f15535w) == null) {
            return;
        }
        c2889g.setPreference(3);
    }

    /* renamed from: I */
    private void m15528I() {
        HSListProfessionalModeBar c2887e = this.f15534v;
        if (c2887e != null) {
            c2887e.setVisibility(8);
            this.f15534v.setItemPressed(false);
        }
        HSPanelContainer c2889g = this.f15535w;
        if (c2889g != null) {
            c2889g.setVisibility(4);
        }
    }

    /* renamed from: J */
    private void m15530J() {
        HSListProfessionalModeBar c2887e = this.f15534v;
        if (c2887e != null) {
            c2887e.setVisibility(0);
            this.f15534v.setItemPressed(true);
        }
        HSPanelContainer c2889g = this.f15535w;
        if (c2889g != null) {
            c2889g.setVisibility(0);
        }
    }

    /* renamed from: K */
    private void m15532K() {
        HSPanelContainer c2889g = this.f15535w;
        if (c2889g != null) {
            c2889g.clearAnimation();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public void m15580a(boolean z, int OplusGLSurfaceView_13) {
        View viewM15431a;
        HSListProfessionalModeBar c2887e = this.f15534v;
        if (c2887e == null || (viewM15431a = c2887e.m15431a(OplusGLSurfaceView_13)) == null) {
            return;
        }
        viewM15431a.setEnabled(z);
        if (viewM15431a instanceof RotateView) {
            ((RotateView) viewM15431a).setRotateViewClickable(z);
        }
        this.f15534v.getAdapter().m15424b(viewM15431a, z, true);
    }

    @Override // com.oplus.camera.professional.HSListProfessionalModeBar.IntrinsicsJvm.kt_4
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo15440a(View view, View view2, long OplusGLSurfaceView_15) throws NumberFormatException {
        if (this.mCameraInterface.mo10445A()) {
            return;
        }
        int iM15430a = this.f15534v.m15430a(view2);
        if (iM15430a == 0) {
            m15624b(true);
            m15690a(1);
            return;
        }
        if (HSListProfessionalModeBar.PlatformImplementations.kt_3.NO_PRESSED == this.f15534v.getModePressState() && this.f15534v.isSelected()) {
            onBackPressed();
            m15569a(iM15430a, false);
            return;
        }
        this.mCameraInterface.mo10563d(false);
        this.mCameraInterface.mo10479a((AnimatorListenerAdapter) null, true, true);
        m15620b(4, true);
        this.mCameraUIInterface.mo18024B(false);
        if (this.mCameraUIInterface.mo18059T()) {
            this.mCameraUIInterface.mo18284x(false);
        }
        m15532K();
        CameraLog.m12967f("HSProfessionalCapMode", "onItemClick, index: " + iM15430a + ", id_renamed: " + OplusGLSurfaceView_15);
        m15569a(iM15430a, true);
        if (2 == iM15430a) {
            this.f15527o = isSuperRawOpen();
        }
        this.f15535w.m15482a(iM15430a, true);
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    private void m15645e(boolean z) {
        String string = this.mPreferences.getString("pref_professional_whitebalance_key", this.f15486C.getString(R.string.camera_whitebalance_default_value));
        if (this.f15486C.getString(R.string.camera_whitebalance_default_value).equals(string)) {
            this.mOneCamera.mo13028a(-1, z);
        }
        if (m15695a(string, this.f15535w.m15497c(5))) {
            try {
                this.mOneCamera.mo13028a(Integer.parseInt(string), z);
            } catch (NumberFormatException unused) {
                this.mOneCamera.mo13103i(z);
            }
        } else {
            this.mOneCamera.mo13103i(z);
        }
        CameraLog.m12954a("HSProfessionalCapMode", "setWhiteBalance, whiteBalance: " + string);
        m15690a(8);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m15693a(boolean z) {
        this.mOneCamera.mo13103i(z);
        m15690a(8);
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    private void m15644e(String str) {
        m15579a(str, true);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m15579a(String str, boolean z) {
        if (str == null) {
            str = this.mPreferences.getString("pref_professional_iso_key", this.f15486C.getString(R.string.camera_iso_default_value));
        }
        if (!this.mPreferences.getString("pref_professional_iso_key", this.f15486C.getString(R.string.camera_iso_default_value)).equals(str)) {
            SharedPreferences.Editor editorEdit = this.mPreferences.edit();
            editorEdit.putString("pref_professional_iso_key", ProfessionalUtil.m16135a(this.mActivity, 1));
            editorEdit.apply();
        }
        if (this.f15486C.getString(R.string.camera_iso_default_value).equals(str)) {
            this.mOneCamera.mo13065b(-1, z);
        } else {
            m15546R();
            this.mOneCamera.mo13128r();
            this.mOneCamera.mo13065b(Integer.parseInt(str), z);
        }
        CameraLog.m12954a("HSProfessionalCapMode", "setISOValue, iso: " + str);
        m15690a(7);
        m15690a(8);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m15692a(String str) {
        if (str == null) {
            str = this.mPreferences.getString("pref_professional_focus_mode_key", this.mActivity.getString(R.string.camera_focus_mode_default_value));
        }
        CameraLog.m12954a("HSProfessionalCapMode", "setFocusValue, focusValue: " + str);
        if (this.mActivity.getString(R.string.camera_focus_mode_default_value).equals(str)) {
            return;
        }
        this.f15484A.removeMessages(2);
        Message messageObtain = Message.obtain();
        messageObtain.what = 2;
        messageObtain.obj = Float.valueOf(Float.parseFloat(str));
        this.f15484A.sendMessage(messageObtain);
        if (this.f15521i) {
            m15651g(false);
        }
        m15690a(8);
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public int m15697c() {
        return Integer.parseInt(this.mPreferences.getString("pref_professional_exposure_compensation_key", this.f15486C.getString(R.string.camera_exposure_compensation_default_value)));
    }

    /* renamed from: L */
    private void m15533L() throws NumberFormatException {
        m15648f(true);
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    private void m15648f(boolean z) throws NumberFormatException {
        String string = this.mPreferences.getString("pref_professional_exposure_time_key", this.f15486C.getString(R.string.camera_exposure_time_default_value));
        long jLongValue = Long.valueOf(this.f15486C.getString(R.string.camera_exposure_time_default_value)).longValue();
        long OplusGLSurfaceView_15 = Long.parseLong(string);
        if (OplusGLSurfaceView_15 != jLongValue) {
            m15546R();
        }
        if (this.mbFrontCamera) {
            this.mOneCamera.mo13031a(jLongValue, z);
        } else {
            this.mOneCamera.mo13031a(OplusGLSurfaceView_15, z);
        }
        m15690a(5);
        m15690a(7);
        m15690a(8);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private void m15623b(final String str, boolean z) {
        final Boolean boolValueOf = Boolean.valueOf(z);
        CameraLog.m12954a("HSProfessionalCapMode", "setFlashModeMenuEnable, exposureTime: " + str + ", mDisPlayFlashIcon: " + boolValueOf);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            if (Integer.parseInt(str) == 0) {
                if (this.mCameraUIInterface != null) {
                    this.mCameraUIInterface.mo18171b(CameraUIInterface.KEY_FLASH_MODE, (String) null);
                    m15582a(true, z);
                }
            } else if (this.mCameraUIInterface != null) {
                m15582a(false, z);
                this.mCameraUIInterface.mo18099a(CameraUIInterface.KEY_FLASH_MODE, "off");
            }
        } catch (Exception COUIBaseListPopupWindow_8) {
            COUIBaseListPopupWindow_8.printStackTrace();
            if (this.mActivity != null) {
                this.mActivity.runOnUiThread(new Runnable() { // from class: com.oplus.camera.professional.COUIBaseListPopupWindow_10.11
                    @Override // java.lang.Runnable
                    public void run() {
                        if (Integer.parseInt(str) == 0) {
                            if (HSProfessionalCapMode.this.mCameraUIInterface != null) {
                                HSProfessionalCapMode.this.m15582a(true, boolValueOf.booleanValue());
                                HSProfessionalCapMode.this.mCameraUIInterface.mo18171b(CameraUIInterface.KEY_FLASH_MODE, (String) null);
                                return;
                            }
                            return;
                        }
                        if (HSProfessionalCapMode.this.mCameraUIInterface != null) {
                            HSProfessionalCapMode.this.m15582a(false, boolValueOf.booleanValue());
                            HSProfessionalCapMode.this.mCameraUIInterface.mo18099a(CameraUIInterface.KEY_FLASH_MODE, "off");
                        }
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public void m15582a(boolean z, boolean z2) {
        if (z2) {
            CameraLog.m12954a("HSProfessionalCapMode", "showOrHideFlashIcon, enable: " + z + ", isOpenFlash: " + isOpenFlash());
            if (z) {
                displayScreenHintIconInSwitchOn();
            } else {
                this.mCameraUIInterface.mo18108a(false, true, false);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:124:0x0298  */
    /* JADX WARN: Removed duplicated region for block: B:135:? A[RETURN, SYNTHETIC] */
    @Override // com.oplus.camera.capmode.BaseMode
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onSharedPreferenceChanged(android.content.SharedPreferences r17, java.lang.String r18) throws android.content.res.Resources.NotFoundException, java.lang.NumberFormatException {
        /*
            Method dump skipped, instructions count: 671
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.professional.HSProfessionalCapMode.onSharedPreferenceChanged(android.content.SharedPreferences, java.lang.String):void");
    }

    /* renamed from: M */
    private void m15536M() throws Resources.NotFoundException, NumberFormatException {
        if (getSupportFunction(CameraUIInterface.KEY_SUPER_RAW_CONTROL)) {
            String string = this.mPreferences.getString(CameraUIInterface.KEY_SUPER_RAW_CONTROL, "off");
            char c2 = 65535;
            int iHashCode = string.hashCode();
            if (iHashCode != -332521116) {
                if (iHashCode != 3551) {
                    if (iHashCode == 109935 && string.equals("off")) {
                        c2 = 2;
                    }
                } else if (string.equals("on")) {
                    c2 = 0;
                }
            } else if (string.equals("super_raw")) {
                c2 = 1;
            }
            if (c2 == 0) {
                this.mCameraUIInterface.mo18070a(R.string.camera_scene_tips_professional_raw_format, -1, true, false, false);
                this.mOneCamera.mo13040a((CameraParameter.PreviewKey<CameraParameter.PreviewKey<String>>) CameraParameter.RAW_CONTROL, (CameraParameter.PreviewKey<String>) "raw");
            } else if (c2 == 1) {
                this.mCameraUIInterface.mo18070a(R.string.camera_scene_tips_professional_raw_super_format, -1, true, false, false);
                this.f15535w.m15496b(false);
                m15624b(true);
                this.f15535w.m15496b(true);
                if (!this.f15527o) {
                    this.f15527o = true;
                }
                this.mOneCamera.mo13040a((CameraParameter.PreviewKey<CameraParameter.PreviewKey<String>>) CameraParameter.RAW_CONTROL, (CameraParameter.PreviewKey<String>) "super_raw");
                if (!"standard".equals(this.mPreferences.getString(CameraUIInterface.KEY_PHOTO_RATIO, "standard"))) {
                    this.mPreferences.edit().putString(CameraUIInterface.KEY_PHOTO_RATIO, "standard").apply();
                    if (this.mCameraUIInterface != null) {
                        this.mCameraUIInterface.mo18211f(CameraUIInterface.KEY_PHOTO_RATIO);
                    }
                }
            } else if (c2 == 2) {
                this.mCameraUIInterface.mo18070a(R.string.camera_scene_tips_professional_jpeg_format, -1, true, false, false);
                this.mOneCamera.mo13040a((CameraParameter.PreviewKey<CameraParameter.PreviewKey<String>>) CameraParameter.RAW_CONTROL, (CameraParameter.PreviewKey<String>) "none");
            }
            if (this.mCameraInterface != null) {
                this.mCameraInterface.mo10506aH();
            }
            this.f15535w.m15485a(getCameraInfo(this.f15487D), isSuperRawOpen() ? 2000000000L : getCameraInfo(this.f15487D).m13289x());
            this.f15535w.m15476a();
        } else if ("on".equals(this.mPreferences.getString(CameraUIInterface.KEY_RAW_CONTROL, "off"))) {
            this.mCameraUIInterface.mo18070a(R.string.camera_raw_control_hint_on, -1, true, false, false);
            this.mOneCamera.mo13040a((CameraParameter.PreviewKey<CameraParameter.PreviewKey<String>>) CameraParameter.RAW_CONTROL, (CameraParameter.PreviewKey<String>) "raw");
        } else {
            this.mCameraUIInterface.mo18070a(R.string.camera_raw_control_hint_off, -1, true, false, false);
            this.mOneCamera.mo13040a((CameraParameter.PreviewKey<CameraParameter.PreviewKey<String>>) CameraParameter.RAW_CONTROL, (CameraParameter.PreviewKey<String>) "none");
        }
        if (this.mCameraInterface != null) {
            if (getSupportFunction(CameraUIInterface.KEY_ZOOM) && !this.f15534v.isSelected()) {
                this.mCameraInterface.mo10492a(true, false);
                this.mCameraInterface.mo10563d(true);
            } else {
                this.mCameraInterface.mo10479a((AnimatorListenerAdapter) null, true, false);
            }
            m15620b(0, true);
            if (m15698d()) {
                this.mCameraInterface.mo10506aH();
            }
        }
        this.mOneCamera.mo13035a((OneCamera.IntrinsicsJvm.kt_3) null);
    }

    /* renamed from: N */
    private void m15538N() {
        if (!getSupportFunction(CameraUIInterface.KEY_FOCUS_PEAKING) || PreferenceManager.m3981a(this.mActivity).getBoolean("focus_peaking_clicked", false) || this.f15535w == null || this.mPreferences == null) {
            return;
        }
        boolean zM15507g = this.f15535w.m15507g(4);
        if (zM15507g != this.mPreferences.getString(CameraUIInterface.KEY_FOCUS_PEAKING, "off").equals("on")) {
            return;
        }
        this.mPreferences.edit().putString(CameraUIInterface.KEY_FOCUS_PEAKING, zM15507g ? "off" : "on").apply();
        this.mCameraUIInterface.mo18211f(CameraUIInterface.KEY_FOCUS_PEAKING);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void setFlashTemporaryDisabled(boolean z) throws Resources.NotFoundException {
        if (getSupportFunction(CameraUIInterface.KEY_SWITCH_CAMERA) && getSupportFunction(CameraUIInterface.KEY_FLASH_MODE) && this.mPreferences != null) {
            String string = this.mPreferences.getString(CameraUIInterface.KEY_SWITCH_CAMERA, "camera_main");
            String flashMode = getFlashMode();
            boolean z2 = true;
            if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_FLASH_FULL_ZOOM)) {
                if (!"camera_tele".equals(string) || (!"on".equals(flashMode) && !"auto".equals(flashMode))) {
                    z2 = false;
                }
                this.mbFlashTemporaryDisabled = z2;
                return;
            }
            this.mbFlashTemporaryDisabled = !"camera_main".equals(string);
            return;
        }
        this.mbFlashTemporaryDisabled = z;
    }

    /* renamed from: O */
    private void m15540O() throws Resources.NotFoundException {
        if (this.mPreferences == null) {
            return;
        }
        String string = this.mPreferences.getString("pref_professional_exposure_time_key", this.f15486C.getString(R.string.camera_exposure_time_default_value));
        String string2 = this.mPreferences.getString("pref_professional_iso_key", this.f15486C.getString(R.string.camera_iso_default_value));
        if (getSupportFunction(CameraUIInterface.KEY_SWITCH_CAMERA) && getSupportFunction(CameraUIInterface.KEY_FLASH_MODE) && this.f15486C.getString(R.string.camera_exposure_time_default_value).equals(string) && this.f15486C.getString(R.string.camera_iso_default_value).equals(string2)) {
            String string3 = this.mPreferences.getString(CameraUIInterface.KEY_SWITCH_CAMERA, "camera_main");
            String flashMode = getFlashMode();
            if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_FLASH_FULL_ZOOM)) {
                if ("camera_tele".equals(string3)) {
                    if ("on".equals(flashMode) || "auto".equals(flashMode)) {
                        this.mbFlashTemporaryDisabled = true;
                        updateFlashState("off");
                        this.mCameraUIInterface.mo18171b(CameraUIInterface.KEY_FLASH_MODE, "off");
                    }
                    this.mCameraUIInterface.mo18173b(CameraUIInterface.KEY_FLASH_MODE, "on", "auto");
                } else {
                    this.mbFlashTemporaryDisabled = false;
                    this.mCameraUIInterface.mo18103a(CameraUIInterface.KEY_FLASH_MODE, "on", "auto");
                    this.mCameraUIInterface.mo18171b(CameraUIInterface.KEY_FLASH_MODE, (String) null);
                    updateFlashState(flashMode);
                }
            } else if ("camera_main".equals(string3)) {
                this.mbFlashTemporaryDisabled = false;
                updateFlashState(getFlashMode());
                this.mCameraUIInterface.mo18171b(CameraUIInterface.KEY_FLASH_MODE, (String) null);
            } else {
                this.mbFlashTemporaryDisabled = true;
                updateFlashState("off");
                this.mCameraUIInterface.mo18099a(CameraUIInterface.KEY_FLASH_MODE, "off");
            }
            this.mCameraUIInterface.mo18211f(CameraUIInterface.KEY_FLASH_MODE);
        }
    }

    /* renamed from: P */
    private void m15542P() {
        View viewM15431a;
        View viewM15431a2;
        if ("off".equals(this.mPreferences.getString(CameraUIInterface.KEY_FLASH_MODE, this.mActivity.getString(R.string.camera_flash_mode_default_value)))) {
            return;
        }
        String string = this.mPreferences.getString("pref_professional_exposure_time_key", this.f15486C.getString(R.string.camera_exposure_time_default_value));
        String string2 = this.mPreferences.getString("pref_professional_iso_key", this.f15486C.getString(R.string.camera_iso_default_value));
        if (!this.f15486C.getString(R.string.camera_exposure_time_default_value).equals(string)) {
            this.f15535w.setAuto(2);
            if (this.f15534v.isSelected() && (viewM15431a2 = this.f15534v.m15431a(2)) != null) {
                this.f15534v.getAdapter().m15418a(viewM15431a2, 0, true);
            }
        }
        if (this.f15486C.getString(R.string.camera_iso_default_value).equals(string2)) {
            return;
        }
        this.f15535w.setAuto(1);
        if (!this.f15534v.isSelected() || (viewM15431a = this.f15534v.m15431a(1)) == null) {
            return;
        }
        this.f15534v.getAdapter().m15418a(viewM15431a, 0, true);
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    private void m15651g(boolean z) {
        boolean zEquals = z ? true ^ "off".equals(this.mPreferences.getString(CameraUIInterface.KEY_FLASH_MODE, this.mActivity.getString(R.string.camera_flash_mode_default_value))) : true;
        if (this.f15521i && zEquals) {
            SharedPreferences.Editor editorEdit = this.mPreferences.edit();
            editorEdit.putString(CameraUIInterface.KEY_HIGH_RESOLUTION, "off");
            editorEdit.apply();
            this.mCameraUIInterface.mo18171b(CameraUIInterface.KEY_HIGH_RESOLUTION, "off");
        }
    }

    /* renamed from: Q */
    private void m15544Q() {
        CameraLog.m12954a("HSProfessionalCapMode", "updateHighResolutionMode");
        this.f15521i = "on".equals(this.mPreferences.getString(CameraUIInterface.KEY_HIGH_RESOLUTION, this.f15486C.getString(R.string.camera_high_resolution_default_value)));
        MainShutterButtonInfo c3200b = new MainShutterButtonInfo(1);
        c3200b.m19227a("button_color_inside_none");
        this.mOneCamera.mo13115m(getZSLMode());
        if (this.f15521i) {
            m15546R();
            m15548S();
            this.f15535w.setAuto(1);
            this.f15535w.setAuto(2);
            this.f15535w.setAuto(5);
            this.f15535w.setAuto(4);
            HSPanelContainer c2889g = this.f15535w;
            c2889g.m15481a(3, "pref_professional_exposure_compensation_key", c2889g.m15497c(3).indexOf(ProfessionalUtil.m16135a(this.mActivity, 3)));
            m15690a(1);
            this.mCameraUIInterface.mo18091a(c3200b);
            if (this.mOneCamera.mo13122p() == 0) {
                this.mOneCamera.mo13029a(getDefaultAFMode(), AEAFHelp.m11154b(), AEAFHelp.m11154b(), true);
                this.mOneCamera.mo13032a((CaptureRequest.Key<CaptureRequest.Key>) CaptureRequest.CONTROL_AE_EXPOSURE_COMPENSATION, (CaptureRequest.Key) Integer.valueOf(AEAFHelp.m11155c()));
                this.mOneCamera.mo13035a((OneCamera.IntrinsicsJvm.kt_3) null);
            }
            if (1 == this.mOneCamera.mo13122p() || 4 == this.mOneCamera.mo13122p()) {
                m15520E();
                this.f15535w.setPanelsBarAuto(4);
            }
            this.mCameraUIInterface.mo18070a(R.string.camera_toast_high_resolution_on, -1, true, false, false);
            return;
        }
        this.mCameraUIInterface.mo18070a(R.string.camera_toast_high_resolution_off, -1, true, false, false);
        this.mCameraUIInterface.mo18091a(c3200b);
    }

    /* renamed from: R */
    private void m15546R() {
        if ("off".equals(this.mPreferences.getString(CameraUIInterface.KEY_FLASH_MODE, this.mActivity.getString(R.string.camera_flash_mode_default_value)))) {
            return;
        }
        SharedPreferences.Editor editorEdit = this.mPreferences.edit();
        editorEdit.putString(CameraUIInterface.KEY_FLASH_MODE, "off");
        editorEdit.apply();
        this.mActivity.runOnUiThread(new Runnable() { // from class: com.oplus.camera.professional.COUIBaseListPopupWindow_10.13
            @Override // java.lang.Runnable
            public void run() {
                if (HSProfessionalCapMode.this.mbPaused) {
                    return;
                }
                HSProfessionalCapMode.this.mCameraUIInterface.mo18211f(CameraUIInterface.KEY_FLASH_MODE);
            }
        });
    }

    /* renamed from: S */
    private void m15548S() {
        if ("off".equals(this.mPreferences.getString(CameraUIInterface.KEY_RAW, "off"))) {
            return;
        }
        SharedPreferences.Editor editorEdit = this.mPreferences.edit();
        editorEdit.putString(CameraUIInterface.KEY_RAW, "off");
        editorEdit.apply();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean isNeedProgressBarInCapture() {
        String string = this.mPreferences.getString("pref_professional_exposure_time_key", this.f15486C.getString(R.string.camera_exposure_time_default_value));
        return TextUtils.isEmpty(string) || Long.valueOf(string).longValue() >= C1547C.NANOS_PER_SECOND;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public DcsMsgData onGetBeforeCaptureMsgCommonData(DcsMsgData dcsMsgData) {
        CaptureMsgData captureMsgData = (dcsMsgData == null || !(dcsMsgData instanceof CaptureMsgData)) ? null : (CaptureMsgData) dcsMsgData;
        if (captureMsgData == null) {
            return null;
        }
        String strM15502e = this.f15535w.m15502e(5);
        String strM15473a = this.f15535w.m15473a(Integer.valueOf(this.f15535w.m15502e(3)).intValue(), this.mOneCamera.mo13086e().m13283r());
        String strM15502e2 = this.f15535w.m15502e(2);
        String strM15502e3 = this.f15535w.m15502e(1);
        String focusValue = this.f15535w.getFocusValue();
        if (TextUtils.equals(strM15502e2, this.mActivity.getString(R.string.camera_exposure_time_default_value))) {
            strM15502e2 = "auto";
        }
        captureMsgData.mProfessionWbValue = strM15502e;
        captureMsgData.mProfessionEvValue = strM15473a;
        captureMsgData.mProfessionExpValue = strM15502e2;
        captureMsgData.mProfessionISOValue = strM15502e3;
        captureMsgData.mProfessionFocusValue = focusValue;
        captureMsgData.mProfessionHighResolution = String.valueOf(this.f15521i);
        String string = "off";
        if (this.mPreferences != null) {
            if (getSupportFunction(CameraUIInterface.KEY_SUPER_RAW_CONTROL)) {
                string = this.mPreferences.getString(CameraUIInterface.KEY_SUPER_RAW_CONTROL, "off");
            } else {
                string = this.mPreferences.getString(CameraUIInterface.KEY_RAW_CONTROL, "off");
            }
        }
        captureMsgData.mProfessionRawControl = string;
        captureMsgData.mProfessionCameraId = this.mPreferences != null ? this.mPreferences.getString(CameraUIInterface.KEY_SWITCH_CAMERA, "camera_main") : "camera_main";
        return captureMsgData;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void changeModeAllViewWhenAnimation(int OplusGLSurfaceView_13, boolean z) {
        super.changeModeAllViewWhenAnimation(OplusGLSurfaceView_13, z);
        if (OplusGLSurfaceView_13 == 3) {
            this.f15485B.m15699a((z && this.mbInCapturing) ? false : z);
            int i2 = z ? 0 : 8;
            Util.m24270a(this.f15485B, i2, (Animation.AnimationListener) null, 300L);
            if (m15676t()) {
                Util.m24270a(this.f15536x, i2, (Animation.AnimationListener) null, 300L);
                return;
            }
            return;
        }
        if (OplusGLSurfaceView_13 != 5) {
            if (OplusGLSurfaceView_13 == 17 && z && m15689z()) {
                this.f15484A.sendEmptyMessageDelayed(6, 3000L);
                return;
            }
            return;
        }
        if (z) {
            HSListProfessionalModeBar c2887e = this.f15534v;
            if (c2887e != null) {
                c2887e.setVisibility(0);
                return;
            }
            return;
        }
        if (this.f15534v != null) {
            m15528I();
        }
    }

    /* compiled from: HSProfessionalCapMode.java */
    /* renamed from: com.oplus.camera.professional.COUIBaseListPopupWindow_10$PlatformImplementations.kt_3 */
    private class PlatformImplementations.kt_3 extends RelativeLayout {

        /* renamed from: IntrinsicsJvm.kt_4 */
        private boolean f15574b;

        public PlatformImplementations.kt_3(Context context) {
            super(context);
            this.f15574b = true;
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public void m15699a(boolean z) {
            this.f15574b = z;
        }

        @Override // android.view.ViewGroup, android.view.View
        public boolean dispatchTouchEvent(MotionEvent motionEvent) {
            if (HSProfessionalCapMode.this.mbCapModeInit && this.f15574b && HSProfessionalCapMode.this.mCameraInterface != null && !HSProfessionalCapMode.this.f15522j) {
                if (HSProfessionalCapMode.this.mCameraInterface.mo10447C()) {
                    MotionEvent motionEventObtain = MotionEvent.obtain(motionEvent);
                    motionEventObtain.setAction(3);
                    super.dispatchTouchEvent(motionEventObtain);
                    return true;
                }
                return super.dispatchTouchEvent(motionEvent);
            }
            if (this.f15574b) {
                return false;
            }
            MotionEvent motionEventObtain2 = MotionEvent.obtain(motionEvent);
            motionEventObtain2.setAction(3);
            super.dispatchTouchEvent(motionEventObtain2);
            return false;
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public int getDefaultAFMode() {
        return super.getDefaultAFMode();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected int getHintTextId() {
        if (this.mPreferences == null) {
            return -1;
        }
        String string = this.mPreferences.getString(CameraUIInterface.KEY_SWITCH_CAMERA, "camera_main");
        if ("camera_main".equals(string)) {
            return Util.m24445f(R.string.camera_switch_main);
        }
        if ("camera_ultra_wide".equals(string)) {
            if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_IS_UW_FIXED_FOCUS) || Float.compare(this.mOneCamera.mo13086e().m13279n(), 0.0f) == 0) {
                return Util.m24445f(R.string.camera_switch_ultra_wide);
            }
            return Util.m24445f(R.string.camera_switch_ultra_wide_micro_lens);
        }
        if ("camera_tele".equals(string)) {
            return R.string.camera_switch_tele;
        }
        if ("camera_macro".equals(string)) {
            return R.string.camera_switch_macro;
        }
        return -1;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m15569a(int OplusGLSurfaceView_13, boolean z) {
        MenuClickMsgData menuClickMsgData = new MenuClickMsgData(this.mActivity);
        menuClickMsgData.buildEvent(false);
        if (OplusGLSurfaceView_13 == 1) {
            menuClickMsgData.mFuncKeyId = 28;
        } else if (OplusGLSurfaceView_13 == 2) {
            menuClickMsgData.mFuncKeyId = 27;
        } else if (OplusGLSurfaceView_13 == 3) {
            menuClickMsgData.mFuncKeyId = 15;
        } else if (OplusGLSurfaceView_13 == 4) {
            menuClickMsgData.mFuncKeyId = 14;
        } else if (OplusGLSurfaceView_13 == 5) {
            menuClickMsgData.mFuncKeyId = 13;
        }
        menuClickMsgData.mFuncKeyResult = z ? 1 : 2;
        menuClickMsgData.mCaptureMode = getCameraMode();
        menuClickMsgData.mCameraId = this.mCameraInterface.mo10547aw();
        menuClickMsgData.mOrientation = this.mOrientation;
        menuClickMsgData.mRearOrFront = CameraCharacteristicsUtil.m12974a(this.mCameraInterface.mo10547aw()) ? DcsMsgData.FRONT : DcsMsgData.REAR;
        menuClickMsgData.report();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public void m15568a(int OplusGLSurfaceView_13, String str, boolean z) {
        MenuClickMsgData menuClickMsgData = new MenuClickMsgData(this.mActivity);
        menuClickMsgData.buildEvent(true);
        if (OplusGLSurfaceView_13 == 1) {
            menuClickMsgData.mFuncKeyId = 28;
            menuClickMsgData.mItem = MenuClickMsgData.KEY_PROFESSION_ISO_VALUE;
        } else if (OplusGLSurfaceView_13 == 2) {
            menuClickMsgData.mFuncKeyId = 27;
            menuClickMsgData.mItem = MenuClickMsgData.KEY_PROFESSION_EXPOSURE_TIME;
            str = this.mPreferences.getString("pref_professional_exposure_time_key", "");
        } else if (OplusGLSurfaceView_13 == 3) {
            menuClickMsgData.mFuncKeyId = 15;
            menuClickMsgData.mItem = MenuClickMsgData.KEY_PROFESSION_EXPOSURE_COMPENSATION;
        } else if (OplusGLSurfaceView_13 == 4) {
            menuClickMsgData.mFuncKeyId = 14;
            menuClickMsgData.mItem = MenuClickMsgData.KEY_PROFESSION_FOCUS_VALUE;
        } else if (OplusGLSurfaceView_13 == 5) {
            menuClickMsgData.mFuncKeyId = 13;
            menuClickMsgData.mItem = MenuClickMsgData.KEY_PROFESSION_WHITE_BALANCE;
        }
        menuClickMsgData.mCaptureMode = getCameraMode();
        menuClickMsgData.mCameraId = this.mCameraInterface.mo10547aw();
        menuClickMsgData.mOrientation = this.mOrientation;
        menuClickMsgData.mItemValue = str;
        menuClickMsgData.mRearOrFront = CameraCharacteristicsUtil.m12974a(this.mCameraInterface.mo10547aw()) ? DcsMsgData.FRONT : DcsMsgData.REAR;
        menuClickMsgData.report();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean isInPreviewArea(MotionEvent motionEvent) {
        Rect rect = new Rect();
        this.mCameraUIInterface.mo18253p().getHitRect(rect);
        return rect.contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY());
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public ZoomConfigure getZoomConfigure() {
        ZoomConfigure zoomConfigure = super.getZoomConfigure();
        zoomConfigure.m11344h(getSupportFunction(CameraUIInterface.KEY_SWITCH_CAMERA));
        return zoomConfigure;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected boolean isModeBarSelected() {
        return this.f15534v.isSelected();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean isSubMenuEnable() {
        return getSupportFunction(CameraUIInterface.KEY_SUB_SETTING);
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public boolean m15698d() {
        return CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_RAW_ZOOM_MUTEX_SUPPORT);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m15567a(final int OplusGLSurfaceView_13, final String str) {
        if (this.mActivity != null) {
            this.mActivity.runOnUiThread(new Runnable() { // from class: com.oplus.camera.professional.COUIBaseListPopupWindow_10.15
                @Override // java.lang.Runnable
                public void run() {
                    if (str == null || HSProfessionalCapMode.this.f15534v == null || str.equals(HSProfessionalCapMode.this.f15534v.m15438b(OplusGLSurfaceView_13))) {
                        return;
                    }
                    HSProfessionalCapMode.this.f15534v.m15433a(OplusGLSurfaceView_13, str);
                }
            });
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean isBottomGuideEntryViewShown() {
        RotateImageView rotateImageView = this.f15490G;
        return rotateImageView != null && rotateImageView.isShown();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public String getHeicCodecFormat() {
        if (isSuperRawOpen()) {
            return null;
        }
        return super.getHeicCodecFormat();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onMoreModeShown() throws Resources.NotFoundException {
        super.onMoreModeShown();
        this.f15499P = true;
        m15528I();
        if (this.mCameraUIInterface != null) {
            this.mCameraUIInterface.mo18068a(0, 1);
        }
        RotateImageView rotateImageView = this.f15536x;
        if (rotateImageView != null) {
            rotateImageView.setVisibility(4);
        }
        m15639d(false);
        m15625b(false, false);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onMoreModeHidden(int OplusGLSurfaceView_13) throws Resources.NotFoundException {
        super.onMoreModeHidden(OplusGLSurfaceView_13);
        boolean zMo10450F = this.mCameraInterface.mo10450F();
        this.f15499P = zMo10450F;
        if (!zMo10450F) {
            m15530J();
        }
        if (this.f15534v.isSelected()) {
            this.mCameraUIInterface.mo18068a(4, 0);
        }
        if (this.f15536x != null && m15676t() && !zMo10450F) {
            this.f15536x.setVisibility(0);
        }
        m15639d(false);
        m15625b(false, false);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean isShowProPanelMenu() {
        HSListProfessionalModeBar c2887e = this.f15534v;
        if (c2887e != null) {
            return c2887e.isSelected();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m15620b(int OplusGLSurfaceView_13, boolean z) {
        if (isPanelMode()) {
            this.mCameraUIInterface.mo18077a(OplusGLSurfaceView_13, z);
        } else {
            this.mCameraUIInterface.mo18068a(OplusGLSurfaceView_13, z ? 1 : 0);
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean isShowZoomMenu() {
        return !m15694a();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean isAutoFocus() {
        return TextUtils.equals(this.mPreferences.getString("pref_professional_focus_mode_key", this.mActivity.getString(R.string.camera_focus_mode_default_value)), this.mActivity.getString(R.string.camera_focus_mode_default_value));
    }

    /* renamed from: T */
    private boolean m15550T() {
        return (this.mPreferences == null || !this.mPreferences.getString(CameraUIInterface.KEY_PRO_HISTOGRAM, "off").equals("on") || this.mPreferences.getString(CameraUIInterface.KEY_SUB_SETTING, "off").equals("on") || this.f15499P || !this.f15500Q) ? false : true;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean isHistogramOpen() {
        return getSupportFunction(CameraUIInterface.KEY_PRO_HISTOGRAM) && m15550T();
    }

    /* renamed from: U */
    private void m15552U() throws Resources.NotFoundException {
        m15637d(this.f15510aa);
        HistogramProcessorManager c2826p = this.f15537y;
        if (c2826p == null) {
            this.f15537y = new HistogramProcessorManager(this.mActivity, this.mCameraRootView, this.f15538z);
        } else {
            c2826p.m14843a(this.f15538z, m15512A(), m15514B());
        }
        Size previewSize = getPreviewSize(this.mOneCamera.mo13086e());
        this.f15537y.m14841a(HistogramProcessorManager.m14819a(previewSize.getWidth(), previewSize.getHeight()));
    }

    /* renamed from: V */
    private void m15554V() throws Resources.NotFoundException {
        m15637d(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: IntrinsicsJvm.kt_5 */
    public void m15637d(int OplusGLSurfaceView_13) throws Resources.NotFoundException {
        CameraLog.m12954a("HSProfessionalCapMode", "updateHistogramLayoutConfigs, offsetY: " + OplusGLSurfaceView_13);
        Resources resources = this.mActivity.getResources();
        int dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.professional_histogram_margin_top);
        int dimensionPixelSize2 = resources.getDimensionPixelSize(R.dimen.professional_histogram_margin_start);
        int dimensionPixelSize3 = resources.getDimensionPixelSize(R.dimen.histogram_graph_view_width);
        int dimensionPixelSize4 = resources.getDimensionPixelSize(R.dimen.histogram_graph_view_height);
        if (this.mOrientation % 180 == 0) {
            dimensionPixelSize += OplusGLSurfaceView_13;
        } else if (90 == this.mOrientation) {
            dimensionPixelSize2 += OplusGLSurfaceView_13;
        }
        if (this.f15538z == null) {
            this.f15538z = new HistogramProcessorManager.PlatformImplementations.kt_3();
            this.f15538z.f14811a = 10;
        }
        CameraLog.m12954a("HSProfessionalCapMode", "updateHistogramLayoutConfigs, previewMarginTop: " + m15668p());
        if (this.mOrientation % 180 == 0) {
            HistogramProcessorManager.PlatformImplementations.kt_3 aVar = this.f15538z;
            aVar.f14812b = this.f15513ad + dimensionPixelSize;
            aVar.f14814d = dimensionPixelSize2;
            aVar.f14815e = this.mOrientation;
            return;
        }
        HistogramProcessorManager.PlatformImplementations.kt_3 aVar2 = this.f15538z;
        aVar2.f14812b = ((dimensionPixelSize3 - dimensionPixelSize4) / 2) + this.f15513ad + dimensionPixelSize;
        aVar2.f14814d = ((dimensionPixelSize4 - dimensionPixelSize3) / 2) + dimensionPixelSize2;
        aVar2.f14815e = (this.mOrientation + 180) % 360;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m15625b(boolean z, boolean z2) throws Resources.NotFoundException {
        m15583a(z, z2, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public void m15583a(boolean z, boolean z2, boolean z3) throws Resources.NotFoundException {
        boolean zM15550T;
        if (this.mPreferences == null || this.f15537y == null || !getSupportFunction(CameraUIInterface.KEY_PRO_HISTOGRAM) || (zM15550T = m15550T()) == this.f15537y.m14848b()) {
            return;
        }
        if (this.f15510aa != 0 && !z3) {
            this.f15510aa = 0;
            m15637d(0);
        } else if (z3) {
            m15637d(this.f15510aa);
        }
        ProfessionalAnimUtil.PlatformImplementations.kt_3 aVar = new ProfessionalAnimUtil.PlatformImplementations.kt_3();
        aVar.f15706a = zM15550T;
        if (z) {
            aVar.f15707b = zM15550T ? 250 : 0;
            aVar.f15708c = 250;
        } else if (z2) {
            int dimensionPixelSize = this.mActivity.getResources().getDimensionPixelSize(R.dimen.professional_histogram_animation_offset);
            aVar.f15708c = zM15550T ? 500 : 250;
            aVar.f15712g = 500;
            aVar.f15709d = zM15550T ? dimensionPixelSize : 0.0f;
            aVar.f15710e = zM15550T ? 0.0f : dimensionPixelSize;
        }
        if (zM15550T) {
            this.f15537y.m14845a(aVar);
        } else {
            this.f15537y.m14847b(aVar);
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onYuvDataReceviced(byte[] bArr) {
        if (this.f15537y == null || !isHistogramOpen()) {
            return;
        }
        this.f15537y.m14846a(bArr);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void onTopSubMenuExpand() {
        if (this.f15534v.isSelected()) {
            this.mCameraInterface.mo10492a(true, true);
            this.mCameraInterface.mo10563d(true);
            m15620b(0, true);
            ProfessionalAnimUtil.PlatformImplementations.kt_3 aVar = new ProfessionalAnimUtil.PlatformImplementations.kt_3();
            aVar.f15706a = false;
            aVar.f15708c = 250;
            aVar.f15712g = 400;
            aVar.f15709d = 0.0f;
            aVar.f15710e = this.mActivity.getResources().getDimensionPixelSize(R.dimen.hs_main_mode_bar_item_animation_offset);
            this.f15535w.setAllPopupInvisibility(aVar);
            this.f15534v.m15432a();
            this.mOneCamera.mo13105j(true);
            return;
        }
        super.onTopSubMenuExpand();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean getTouchEnable(boolean z, int OplusGLSurfaceView_13, int i2) throws Resources.NotFoundException {
        int dimensionPixelSize = this.mActivity.getResources().getDimensionPixelSize(R.dimen.exposure_indicator_width);
        int dimensionPixelSize2 = this.mActivity.getResources().getDimensionPixelSize(R.dimen.main_mode_bar_item_title_image_margin);
        Rect rect = new Rect();
        this.f15534v.getGlobalVisibleRect(rect);
        int i3 = dimensionPixelSize / 2;
        rect.left -= i3;
        rect.top -= i3 - dimensionPixelSize2;
        rect.right += i3;
        rect.bottom += i3;
        return z && !rect.contains(OplusGLSurfaceView_13, i2);
    }
}

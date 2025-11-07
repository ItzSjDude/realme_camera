package com.oplus.camera.professional;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Color;
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
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.animation.Animation;
import android.view.animation.PathInterpolator;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.p027a.ContextCompat;
import androidx.core.p034f.TextUtilsCompat;
import androidx.preference.PreferenceManager;
import com.google.android.exoplayer2.C1547C;
import com.oplus.camera.AEAFHelp;
import com.oplus.camera.ZoomConfigure;
import com.oplus.camera.CameraLog;
import com.oplus.camera.HistogramProcessorManager;
import com.oplus.camera.Camera;
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
import com.oplus.camera.professional.PanelContainer;
import com.oplus.camera.professional.ProfessionalAnimUtil;
import com.oplus.camera.professional.ListProfessionalModeBar;
import com.oplus.camera.screen.LayoutUtil;
import com.oplus.camera.screen.p164b.BaseScreenMode;
import com.oplus.camera.statistics.model.CaptureMsgData;
import com.oplus.camera.statistics.model.DcsMsgData;
import com.oplus.camera.statistics.model.MenuClickMsgData;
import com.oplus.camera.statistics.model.ProfessionalMsgData;
import com.oplus.camera.util.BackgroundUtil;
import com.oplus.camera.util.Util;
import com.oplus.ocs.camera.CameraParameter;
import com.oplus.ocs.camera.CameraPictureCallback;
import com.oplus.ocs.camera.CameraPreviewCallback;
import com.p078a.p079a.Spring;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* compiled from: ProfessionalCapMode.java */
/* renamed from: com.oplus.camera.professional.v */
/* loaded from: classes2.dex */
public class ProfessionalCapMode extends BaseMode implements View.OnClickListener, ListProfessionalModeBar.OnItemClickListener {

    /* renamed from: A */
    private HistogramProcessorManager.PlatformImplementations.kt_3 f15714A;

    /* renamed from: B */
    private Handler f15715B;

    /* renamed from: C */
    private PlatformImplementations.kt_3 f15716C;

    /* renamed from: D */
    private Resources f15717D;

    /* renamed from: E */
    private int f15718E;

    /* renamed from: F */
    private boolean f15719F;

    /* renamed from: G */
    private boolean f15720G;

    /* renamed from: H */
    private boolean f15721H;

    /* renamed from: I */
    private RotateImageView f15722I;

    /* renamed from: J */
    private int f15723J;

    /* renamed from: K */
    private ValueAnimator f15724K;

    /* renamed from: L */
    private int f15725L;

    /* renamed from: M */
    private int f15726M;

    /* renamed from: N */
    private int f15727N;

    /* renamed from: O */
    private float f15728O;

    /* renamed from: P */
    private boolean f15729P;

    /* renamed from: Q */
    private boolean f15730Q;

    /* renamed from: R */
    private byte[] f15731R;

    /* renamed from: S */
    private CameraPictureCallback.CameraPictureImage f15732S;

    /* renamed from: T */
    private boolean f15733T;

    /* renamed from: U */
    private boolean f15734U;

    /* renamed from: V */
    private boolean f15735V;

    /* renamed from: W */
    private int f15736W;

    /* renamed from: X */
    private int f15737X;

    /* renamed from: Y */
    private int f15738Y;

    /* renamed from: Z */
    private int f15739Z;

    /* renamed from: aa */
    private int f15740aa;

    /* renamed from: ab */
    private int f15741ab;

    /* renamed from: ac */
    private int f15742ac;

    /* renamed from: ad */
    private int f15743ad;

    /* renamed from: ae */
    private int f15744ae;

    /* renamed from: af */
    private int f15745af;

    /* renamed from: ag */
    private String f15746ag;

    /* renamed from: ah */
    private byte[] f15747ah;

    /* renamed from: ai */
    private TextView f15748ai;

    /* renamed from: aj */
    private ValueAnimator f15749aj;

    /* renamed from: ak */
    private PathInterpolator f15750ak;

    /* renamed from: al */
    private BaseScreenMode f15751al;

    /* renamed from: am */
    private PanelContainer.IntrinsicsJvm.kt_4 f15752am;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private final Object f15753g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private volatile boolean f15754h;

    /* renamed from: OplusGLSurfaceView_13 */
    private volatile boolean f15755i;

    /* renamed from: OplusGLSurfaceView_15 */
    private boolean f15756j;

    /* renamed from: OplusGLSurfaceView_5 */
    private boolean f15757k;

    /* renamed from: OplusGLSurfaceView_14 */
    private boolean f15758l;

    /* renamed from: OplusGLSurfaceView_6 */
    private boolean f15759m;

    /* renamed from: OplusGLSurfaceView_11 */
    private boolean f15760n;

    /* renamed from: o */
    private boolean f15761o;

    /* renamed from: p */
    private boolean f15762p;

    /* renamed from: q */
    private boolean f15763q;

    /* renamed from: r */
    private boolean f15764r;

    /* renamed from: s */
    private int f15765s;

    /* renamed from: t */
    private long f15766t;

    /* renamed from: u */
    private Thread f15767u;

    /* renamed from: v */
    private CountDownUI f15768v;

    /* renamed from: w */
    private ListProfessionalModeBar f15769w;

    /* renamed from: x */
    private PanelContainer f15770x;

    /* renamed from: y */
    private RotateImageView f15771y;

    /* renamed from: z */
    private HistogramProcessorManager f15772z;

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
    protected void onStop() {
    }

    public ProfessionalCapMode(Activity activity, CameraInterface interfaceC2646a, CameraUIInterface cameraUIInterface, PreviewEffectProcess interfaceC3423t) {
        super(activity, interfaceC2646a, cameraUIInterface, interfaceC3423t);
        this.f15753g = new Object();
        this.f15754h = false;
        this.f15755i = false;
        this.f15756j = false;
        this.f15757k = false;
        this.f15758l = false;
        this.f15759m = false;
        this.f15760n = true;
        this.f15761o = false;
        this.f15762p = false;
        this.f15763q = false;
        this.f15764r = false;
        this.f15765s = 0;
        this.f15766t = 0L;
        this.f15767u = null;
        this.f15768v = null;
        this.f15769w = null;
        this.f15770x = null;
        this.f15771y = null;
        this.f15772z = null;
        this.f15714A = null;
        this.f15715B = null;
        this.f15716C = null;
        this.f15718E = -1;
        this.f15719F = false;
        this.f15720G = false;
        this.f15721H = false;
        this.f15722I = null;
        this.f15723J = 0;
        this.f15724K = null;
        this.f15725L = 0;
        this.f15726M = 0;
        this.f15727N = 0;
        this.f15728O = 0.0f;
        this.f15729P = false;
        this.f15730Q = true;
        this.f15732S = null;
        this.f15733T = false;
        this.f15734U = false;
        this.f15735V = false;
        this.f15736W = 0;
        this.f15737X = 0;
        this.f15738Y = 0;
        this.f15739Z = 0;
        this.f15740aa = 0;
        this.f15741ab = 0;
        this.f15742ac = 0;
        this.f15743ad = 0;
        this.f15744ae = 0;
        this.f15745af = 0;
        this.f15746ag = null;
        this.f15747ah = null;
        this.f15748ai = null;
        this.f15749aj = null;
        this.f15750ak = new PathInterpolator(0.3f, 0.0f, 0.1f, 1.0f);
        this.f15751al = null;
        this.f15752am = new PanelContainer.IntrinsicsJvm.kt_4() { // from class: com.oplus.camera.professional.v.15
            @Override // com.oplus.camera.professional.PanelContainer.IntrinsicsJvm.kt_4
            /* renamed from: PlatformImplementations.kt_3 */
            public void mo13566a(int OplusGLSurfaceView_13, String str, boolean z) {
                ProfessionalCapMode.this.m15990a(OplusGLSurfaceView_13, str, z);
            }
        };
        this.f15717D = activity.getApplicationContext().getResources();
        this.f15725L = this.f15717D.getDimensionPixelSize(R.dimen.main_mode_bar_height);
        this.f15726M = this.f15717D.getDimensionPixelSize(R.dimen.common_sub_mode_bar_height);
        this.f15727N = this.f15717D.getDimensionPixelSize(R.dimen.professional_mode_panel_container_margin_bottom);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        CameraLog.m12954a("ProfessionalCapMode", "onSingleTapUp");
        if (this.mCameraUIInterface.mo18208e((int) motionEvent.getX(), (int) motionEvent.getY())) {
            return false;
        }
        boolean z = 4 == m16128f();
        if ((isInPreviewArea(motionEvent) || z) && this.f15769w.isSelected() && !this.mCameraInterface.mo10445A()) {
            onBackPressed();
        }
        m15992a(motionEvent);
        return false;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onShareMenuExpand() {
        if (this.f15769w.isSelected()) {
            this.mCameraInterface.mo10492a(true, true);
            this.mCameraInterface.mo10563d(true);
            ProfessionalAnimUtil.PlatformImplementations.kt_3 aVar = new ProfessionalAnimUtil.PlatformImplementations.kt_3();
            aVar.f15706a = false;
            aVar.f15708c = 250;
            aVar.f15712g = 400;
            aVar.f15709d = 0.0f;
            aVar.f15710e = this.mActivity.getResources().getDimensionPixelSize(R.dimen.main_mode_bar_item_animation_offset);
            this.f15770x.setAllPopupInvisibility(aVar);
            this.f15769w.m15381a();
            this.mOneCamera.mo13105j(true);
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean onLongPress(MotionEvent motionEvent) {
        CameraLog.m12954a("ProfessionalCapMode", "onLongPress");
        m15992a(motionEvent);
        return false;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m15992a(MotionEvent motionEvent) {
        BaseScreenMode abstractC2934aMo10519aU;
        Rect rect = new Rect();
        this.mCameraUIInterface.mo18253p().getHitRect(rect);
        if (rect.contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY())) {
            if (1 == getDefaultAFMode() || 4 == getDefaultAFMode()) {
                m15947J();
                this.f15770x.setPanelsBarAuto(4);
            }
            if (this.mCameraInterface != null && isBubbleOpen(CameraUIInterface.KEY_EXPOSURE_FOCUS_SEPARATE_TIPS) && (abstractC2934aMo10519aU = this.mCameraInterface.mo10519aU()) != null && abstractC2934aMo10519aU.mo16529a(this.mCameraUIInterface, (int) motionEvent.getX(), (int) motionEvent.getY()) && getTouchEnable(true, (int) motionEvent.getX(), (int) motionEvent.getY())) {
                CameraLog.m12954a("ProfessionalCapMode", "onSingleTapUp, bubble open, KEY_EXPOSURE_FOCUS_SEPARATE_TIPS");
                this.mCameraUIInterface.mo18086a(this.mActivity.findViewById(R.id_renamed.oplus_setting_bar), 18, (int) motionEvent.getX(), (int) motionEvent.getY());
            }
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onRawImageReceived(CameraPictureCallback.CameraPictureImage cameraPictureImage) {
        this.f15732S = cameraPictureImage;
        if (isSuperRawOpen()) {
            synchronized (this.f15753g) {
                this.f15733T = true;
            }
            m16085j();
            return;
        }
        m16083i();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean consumeImage(CameraPictureCallback.CameraPictureImage cameraPictureImage) {
        if (!isSuperRawOpen() || 256 != cameraPictureImage.getFormat() || 4 != cameraPictureImage.getSourceType()) {
            return false;
        }
        this.f15736W = cameraPictureImage.getWidth();
        this.f15737X = cameraPictureImage.getHeight();
        synchronized (this.f15753g) {
            this.f15731R = cameraPictureImage.getImage();
        }
        this.f15738Y = 1;
        this.f15739Z = 1;
        this.f15747ah = new byte[this.f15738Y * this.f15739Z * 3];
        m16085j();
        return true;
    }

    /* renamed from: OplusGLSurfaceView_13 */
    private void m16083i() {
        byte[] image = this.f15732S.getImage();
        ExifModel c2731eM13747a = ExifModel.m13747a(image);
        final long OplusGLSurfaceView_15 = this.mCaptureDate - 10;
        StringBuilder sb = new StringBuilder();
        sb.append("saveResultToDng, mRawPreviewJpeg : ");
        sb.append(this.f15731R != null);
        CameraLog.m12959b("ProfessionalCapMode", sb.toString());
        if (c2731eM13747a != null) {
            if (this.f15731R != null) {
                c2731eM13747a.m13762a(c2731eM13747a.f13793f, OplusGLSurfaceView_15);
                c2731eM13747a.m13764b();
                c2731eM13747a.f13793f.m13740a(this.f15747ah);
                c2731eM13747a.f13793f.m13744b(256).m13728a(new int[]{this.f15738Y});
                c2731eM13747a.f13793f.m13744b(257).m13728a(new int[]{this.f15739Z});
                c2731eM13747a.f13793f.m13744b(262).m13728a(new int[]{this.f15739Z});
                ExifIFD c2729cM15986a = m15986a(c2731eM13747a.f13788a);
                c2729cM15986a.m13740a(this.f15731R);
                c2731eM13747a.f13792e.add(c2729cM15986a);
                c2731eM13747a.f13791d.add(c2729cM15986a);
            }
            c2731eM13747a.m13761a();
            c2731eM13747a.m13762a(c2731eM13747a.f13793f, OplusGLSurfaceView_15);
            c2731eM13747a.m13762a(c2731eM13747a.f13794g, OplusGLSurfaceView_15);
            c2731eM13747a.m13766d();
            image = c2731eM13747a.f13797j.array();
        }
        final byte[] bArr = image;
        this.f15731R = null;
        final int format = this.f15732S.getFormat();
        this.f15732S = null;
        if (this.mActivity != null) {
            this.mActivity.runOnUiThread(new Runnable() { // from class: com.oplus.camera.professional.v.1
                @Override // java.lang.Runnable
                public void run() {
                    ProfessionalCapMode.this.pictureTakenCallback(bArr, 0, 0, Util.m24243a(format), true, false, false, OplusGLSurfaceView_15, 0);
                }
            });
        }
        CameraLog.m12954a("ProfessionalCapMode", "saveResultToDng finished");
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private ExifIFD m15986a(ByteOrder byteOrder) {
        ExifIFD c2729c = new ExifIFD();
        c2729c.f13777c = new ArrayList<>();
        c2729c.m13739a(byteOrder);
        c2729c.m13742a(254, new int[]{1});
        c2729c.m13742a(256, new int[]{this.f15736W});
        c2729c.m13742a(257, new int[]{this.f15737X});
        c2729c.m13742a(258, new int[]{8, 8, 8});
        c2729c.m13742a(259, new int[]{7});
        c2729c.m13742a(262, new int[]{6});
        c2729c.m13742a(273, new int[]{0});
        c2729c.m13742a(277, new int[]{3});
        c2729c.m13742a(278, new int[]{this.f15737X});
        c2729c.m13742a(279, new int[]{this.f15731R.length});
        c2729c.m13742a(284, new int[]{1});
        c2729c.m13742a(529, new int[]{1});
        c2729c.m13742a(530, new int[]{1, 1});
        c2729c.m13742a(531, new int[]{2});
        c2729c.m13742a(532, new int[]{1});
        return c2729c;
    }

    /* renamed from: OplusGLSurfaceView_15 */
    private void m16085j() {
        synchronized (this.f15753g) {
            if (this.f15731R != null && this.f15733T) {
                m16083i();
            }
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode, com.oplus.camera.p141e.OneCamera.PlatformImplementations.kt_3
    public void onCaptureStarted(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, long OplusGLSurfaceView_15, long j2) {
        PanelContainer c2898p;
        super.onCaptureStarted(cameraCaptureSession, captureRequest, OplusGLSurfaceView_15, j2);
        if (this.mCameraUIInterface == null || (c2898p = this.f15770x) == null || c2898p.m15836g(5) || Util.m24169C() || !isFlashState()) {
            return;
        }
        this.mCameraUIInterface.mo18183c().m14239b(j2, OplusGLSurfaceView_15);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean needDelayCloseForCapture() {
        if (C1547C.NANOS_PER_SECOND <= Long.parseLong(m16091m())) {
            return false;
        }
        return super.needDelayCloseForCapture();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onCameraPermissionGranted() throws Resources.NotFoundException, NumberFormatException {
        this.f15718E = this.mCameraInterface.mo10543as();
        PanelContainer c2898p = this.f15770x;
        if (c2898p != null) {
            if (this.f15720G) {
                c2898p.m15815a(getCameraInfo(this.f15718E), (PanelContainer.PlatformImplementations.kt_3) null);
                if (isSuperRawOpen()) {
                    this.f15770x.m15814a(getCameraInfo(this.f15718E), 2000000000L);
                }
                this.f15770x.m15804a();
                return;
            }
            c2898p.mo15728a(getCameraInfo(this.f15718E), this.f15715B, (PanelContainer.PlatformImplementations.kt_3) null);
            if (isSuperRawOpen()) {
                this.f15770x.m15814a(getCameraInfo(this.f15718E), 2000000000L);
            }
            m16099q();
            this.f15770x.setSettleListener(this.f15769w);
            this.f15770x.setMotionListener(this.f15752am);
            PlatformImplementations.kt_3 aVar = this.f15716C;
            if (aVar != null) {
                aVar.setVisibility(0);
            }
            this.mCameraInterface.mo10563d(true);
            m16118a(1);
            this.f15720G = true;
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
    public boolean m16123a(String str, List<String> list) {
        return list != null && list.indexOf(str) >= 0;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void onInitCameraMode() throws Resources.NotFoundException, NumberFormatException {
        CameraLog.m12954a("ProfessionalCapMode", "onInitCameraMode, Start");
        restoreProPreference();
        LevelPanel.m15353c();
        if (isNightProModeSupport()) {
            this.f15719F = true;
        }
        this.f15729P = false;
        this.f15730Q = true;
        this.f15756j = "on".equals(this.mPreferences.getString(CameraUIInterface.KEY_HIGH_RESOLUTION, this.f15717D.getString(R.string.camera_high_resolution_default_value)));
        if (!this.f15756j) {
            this.mCameraUIInterface.mo18171b(CameraUIInterface.KEY_HIGH_RESOLUTION, "off");
        }
        if (this.f15768v == null) {
            this.f15768v = new CountDownUI(this.mCameraUIInterface, new CountDownUI.PlatformImplementations.kt_3() { // from class: com.oplus.camera.professional.v.12
                @Override // com.oplus.camera.p172ui.CountDownUI.PlatformImplementations.kt_3
                /* renamed from: PlatformImplementations.kt_3 */
                public void mo12293a(boolean z) {
                    ProfessionalCapMode.this.mCameraUIInterface.mo18217g(true);
                    if (z) {
                        return;
                    }
                    MainShutterButtonInfo shutterButtonInfo = ProfessionalCapMode.this.getShutterButtonInfo();
                    shutterButtonInfo.m19226a(14);
                    ProfessionalCapMode.this.mCameraUIInterface.mo18091a(shutterButtonInfo);
                }

                @Override // com.oplus.camera.p172ui.CountDownUI.PlatformImplementations.kt_3
                /* renamed from: PlatformImplementations.kt_3 */
                public void mo12292a() {
                    if (ProfessionalCapMode.this.mbPaused) {
                        return;
                    }
                    ProfessionalCapMode.this.f15768v.mo20104e();
                }
            });
        }
        if (this.f15715B == null) {
            this.f15715B = new Handler() { // from class: com.oplus.camera.professional.v.17
                @Override // android.os.Handler
                public void handleMessage(Message message) {
                    ProfessionalCapMode.this.m16119a(message.what, message);
                }
            };
        }
        if (C1547C.NANOS_PER_SECOND <= Long.parseLong(m16091m())) {
            this.mCameraUIInterface.mo18091a(getShutterButtonInfo());
        }
        this.mCameraUIInterface.mo18187c(this.mActivity.getString(R.string.camera_description_common_shutter_button));
        m16103s();
        if (this.f15770x != null) {
            if (m15938E()) {
                this.f15770x.m15832e();
            } else {
                this.f15770x.setVisibility(0);
            }
        }
        if (this.f15769w != null) {
            int OplusGLSurfaceView_13 = m15938E() ? 8 : 0;
            this.f15769w.setAlpha(0.0f);
            this.f15769w.setVisibility(OplusGLSurfaceView_13);
        }
        if (this.f15714A != null && m15980Z()) {
            this.f15714A.f14815e = this.mOrientation;
        }
        m16087k();
    }

    /* renamed from: OplusGLSurfaceView_5 */
    private void m16087k() {
        HintManager c3130aMo18233k = this.mCameraUIInterface.mo18233k();
        if (c3130aMo18233k != null) {
            c3130aMo18233k.m18484a(new HintManager.IntrinsicsJvm.kt_4() { // from class: com.oplus.camera.professional.v.18
                @Override // com.oplus.camera.p172ui.p173a.HintManager.IntrinsicsJvm.kt_4
                /* renamed from: PlatformImplementations.kt_3 */
                public void mo14771a(HintModel c3131b) {
                    if (ProfessionalCapMode.this.isHistogramOpen()) {
                        if ((270 != ProfessionalCapMode.this.mOrientation || Util.m24495t()) && ProfessionalCapMode.this.f15772z != null) {
                            ProfessionalCapMode.this.f15740aa = c3131b.f17456a;
                            ProfessionalCapMode.this.f15748ai.setText(ProfessionalCapMode.this.mActivity.getResources().getString(ProfessionalCapMode.this.f15740aa));
                            ProfessionalCapMode.this.f15748ai.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.oplus.camera.professional.v.18.1
                                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                                public void onGlobalLayout() throws Resources.NotFoundException {
                                    int height;
                                    int height2;
                                    int OplusGLSurfaceView_13;
                                    ProfessionalCapMode.this.f15748ai.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                                    View viewFindViewById = ProfessionalCapMode.this.mActivity.findViewById(R.id_renamed.camera_screen_hint_panel);
                                    BaseScreenMode currentScreenMode = ProfessionalCapMode.this.getCurrentScreenMode();
                                    HistogramProcessorManager.PlatformImplementations.kt_3 aVar = new HistogramProcessorManager.PlatformImplementations.kt_3();
                                    if (currentScreenMode != null) {
                                        currentScreenMode.mo16501a(aVar, ProfessionalCapMode.this.m16104t(), ProfessionalCapMode.this.mOrientation);
                                    }
                                    String string = ProfessionalCapMode.this.mPreferences.getString(CameraUIInterface.KEY_PHOTO_RATIO, ProfessionalCapMode.this.mActivity.getString(R.string.camera_photo_ratio_default_value));
                                    if (Util.m24498u()) {
                                        int y = (int) (viewFindViewById.getY() + ProfessionalCapMode.this.f15748ai.getHeight());
                                        if (ProfessionalCapMode.this.f15742ac + y > aVar.f14812b) {
                                            height2 = y + ProfessionalCapMode.this.f15742ac;
                                            OplusGLSurfaceView_13 = aVar.f14812b;
                                            height = height2 - OplusGLSurfaceView_13;
                                        } else {
                                            height = 0;
                                        }
                                    } else if (!"square".equals(string) || ProfessionalCapMode.this.mOrientation % 180 != 0) {
                                        height = ProfessionalCapMode.this.f15748ai.getHeight() + ProfessionalCapMode.this.f15742ac;
                                    } else {
                                        height2 = ProfessionalCapMode.this.f15748ai.getHeight();
                                        OplusGLSurfaceView_13 = ProfessionalCapMode.this.f15743ad;
                                        height = height2 - OplusGLSurfaceView_13;
                                    }
                                    if (ProfessionalCapMode.this.f15734U) {
                                        ProfessionalCapMode.this.f15734U = false;
                                        ProfessionalCapMode.this.m16073e(height);
                                        ProfessionalCapMode.this.f15772z.m14843a(ProfessionalCapMode.this.f15714A, false, false);
                                    } else if (ProfessionalCapMode.this.f15741ab != height) {
                                        ProfessionalCapMode.this.m15988a(ProfessionalCapMode.this.f15741ab, height);
                                    }
                                    ProfessionalCapMode.this.f15741ab = height;
                                }
                            });
                        }
                    }
                }

                @Override // com.oplus.camera.p172ui.p173a.HintManager.IntrinsicsJvm.kt_4
                /* renamed from: PlatformImplementations.kt_3 */
                public void mo14770a(int OplusGLSurfaceView_13) throws Resources.NotFoundException {
                    if (OplusGLSurfaceView_13 == ProfessionalCapMode.this.f15740aa) {
                        ProfessionalCapMode.this.f15741ab = 0;
                    }
                    if (ProfessionalCapMode.this.isHistogramOpen()) {
                        if ((270 != ProfessionalCapMode.this.mOrientation || Util.m24495t()) && ProfessionalCapMode.this.f15772z != null && OplusGLSurfaceView_13 == ProfessionalCapMode.this.f15740aa) {
                            if (ProfessionalCapMode.this.f15749aj != null && ProfessionalCapMode.this.f15749aj.isRunning()) {
                                ProfessionalCapMode.this.f15749aj.cancel();
                            }
                            ProfessionalCapMode.this.m16073e(0);
                            ProfessionalCapMode.this.f15772z.m14844a(ProfessionalCapMode.this.f15714A, ProfessionalCapMode.this.m15940F(), ProfessionalCapMode.this.m15942G(), 150L);
                        }
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public void m15988a(int OplusGLSurfaceView_13, int i2) {
        CameraLog.m12954a("ProfessionalCapMode", "startHistogramTransYAnimtor, originalY: " + OplusGLSurfaceView_13 + ", offsetY: " + i2);
        ValueAnimator valueAnimator = this.f15749aj;
        if (valueAnimator == null) {
            this.f15749aj = ValueAnimator.ofInt(0, i2);
            this.f15749aj.setDuration(350L);
            this.f15749aj.setInterpolator(this.f15750ak);
            this.f15749aj.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.professional.v.19
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator2) throws Resources.NotFoundException {
                    ProfessionalCapMode.this.m16073e(((Integer) valueAnimator2.getAnimatedValue()).intValue());
                    if (ProfessionalCapMode.this.f15772z != null) {
                        ProfessionalCapMode.this.f15772z.m14843a(ProfessionalCapMode.this.f15714A, ProfessionalCapMode.this.m15940F(), ProfessionalCapMode.this.m15942G());
                    }
                }
            });
            this.f15749aj.addListener(new SimpleAnimatorListener() { // from class: com.oplus.camera.professional.v.20
                @Override // com.oplus.camera.p137b.SimpleAnimatorListener, android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) throws Resources.NotFoundException {
                    super.onAnimationCancel(animator);
                    ProfessionalCapMode.this.m16073e(0);
                    if (ProfessionalCapMode.this.f15772z != null) {
                        ProfessionalCapMode.this.f15772z.m14843a(ProfessionalCapMode.this.f15714A, ProfessionalCapMode.this.m15940F(), ProfessionalCapMode.this.m15942G());
                    }
                }
            });
        } else {
            valueAnimator.setIntValues(OplusGLSurfaceView_13, i2);
        }
        if (this.f15749aj.isRunning()) {
            return;
        }
        this.f15749aj.start();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onZoomMenuCollapsing() {
        if (this.f15769w != null) {
            if (1 != m16128f()) {
                this.f15769w.m15386a(true, true);
            }
            if (this.f15769w == null || 4 != m16128f()) {
                return;
            }
            this.f15769w.setVisibilityWithAnimation(0);
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onZoomMenuCollapsed() {
        if (!this.mCameraInterface.mo10445A() && !this.mbInCapturing) {
            this.f15716C.setEnabled(true);
        } else {
            this.f15758l = true;
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onZoomMenuExpand() {
        if (this.f15769w != null) {
            if (1 != m16128f()) {
                this.f15769w.m15386a(false, true);
            }
            if (4 == m16128f()) {
                PanelContainer c2898p = this.f15770x;
                if (c2898p != null) {
                    c2898p.m15832e();
                }
                this.f15769w.m15381a();
                this.f15769w.setVisibilityWithAnimation(8);
            }
        }
        this.f15716C.setEnabled(false);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onZoomTransitionChanged(int OplusGLSurfaceView_13) throws Resources.NotFoundException {
        m16099q();
        int zoomBarOffset = OplusGLSurfaceView_13 - getZoomBarOffset();
        if (this.f15769w != null) {
            float COUIBaseListPopupWindow_12 = this.f15728O;
            if (zoomBarOffset <= (-getZoomBarOffset()) / 2) {
                COUIBaseListPopupWindow_12 = 0.0f;
            }
            if (Util.m24498u()) {
                COUIBaseListPopupWindow_12 = 1.0f;
            }
            this.f15769w.setAlpha(COUIBaseListPopupWindow_12);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f15769w.getLayoutParams();
            layoutParams.bottomMargin = zoomBarOffset;
            this.f15769w.setLayoutParams(layoutParams);
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onZoomAlphaChanged(float COUIBaseListPopupWindow_12) {
        this.f15728O = COUIBaseListPopupWindow_12;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void updateControlPanelBgColor(int OplusGLSurfaceView_13) {
        if (this.f15769w == null || 1 == m16128f()) {
            return;
        }
        this.f15769w.setBackgroundColor(BackgroundUtil.m24523a(OplusGLSurfaceView_13));
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean getZSLMode() {
        this.f15756j = "on".equals(this.mPreferences.getString(CameraUIInterface.KEY_HIGH_RESOLUTION, this.f15717D.getString(R.string.camera_high_resolution_default_value)));
        PanelContainer c2898p = this.f15770x;
        if ((c2898p != null && !c2898p.m15836g(2)) || isRawOpen()) {
            CameraLog.m12954a("ProfessionalCapMode", "getZSLMode exposure time isn't auto or raw open,so return false");
            return false;
        }
        if (this.f15756j) {
            return true;
        }
        return getLogicCameraType() == 0 && Util.m24169C();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private Size m15985a(OplusCameraCharacteristics c2698h) {
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
        Size sizeM15985a;
        return (!"camera_ultra_wide".equals(this.mPreferences.getString(CameraUIInterface.KEY_SWITCH_CAMERA, "camera_main")) || (sizeM15985a = m15985a(c2698h)) == null) ? super.getPictureSize(c2698h) : sizeM15985a;
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
        return this.mPreferences != null && getSupportFunction(CameraUIInterface.KEY_SUPER_RAW_CONTROL) && "super_raw".equals(this.mPreferences.getString(CameraUIInterface.KEY_SUPER_RAW_CONTROL, "off"));
    }

    /* renamed from: PlatformImplementations.kt_3 */
    protected boolean m16122a() {
        return CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_PROFESSIONAL_MUTEX_ZOOM_SUPPORT);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean isRawRequestTag() {
        return this.mbRawRequestTag;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onMenuOptionAdded(String str) {
        if (CameraUIInterface.KEY_SUPER_RAW_CONTROL.equals(str) && this.mCameraUIInterface.mo18143ag()) {
            this.mCameraUIInterface.mo18102a(CameraUIInterface.KEY_SUPER_RAW_CONTROL, true, (int) this.f15717D.getDimension(R.dimen.super_raw_setting_menu_reddot_offset_x), (int) this.f15717D.getDimension(R.dimen.super_raw_setting_menu_reddot_offset_y));
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void closeImageReader() {
        CameraLog.m12954a("ProfessionalCapMode", "closeImageReader");
        this.f15760n = true;
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

    /* renamed from: OplusGLSurfaceView_14 */
    private boolean m16089l() {
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
        if (CameraUIInterface.KEY_RAW_CONTROL.equals(str)) {
            return getSupportFunction(str) && m16089l();
        }
        if (CameraUIInterface.KEY_SUPER_RAW_CONTROL.equals(str)) {
            return CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_PROFESSIONAL_SUPER_RAW) && m16089l();
        }
        return super.getSupportMenu(str);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean getSupportSubMenu(String str) {
        if (CameraUIInterface.KEY_CAMERA_TIMER_SHUTTER.equals(str) || CameraUIInterface.KEY_PHOTO_RATIO.equals(str) || CameraUIInterface.KEY_SETTING.equals(str)) {
            return getSupportFunction(str);
        }
        return (CameraUIInterface.KEY_RAW_CONTROL.equals(str) || CameraUIInterface.KEY_SUPER_RAW_CONTROL.equals(str)) && getSupportFunction(str) && !m16089l();
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public int m16124b() {
        return this.mCameraInterface.mo10591u();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: OplusGLSurfaceView_6 */
    public String m16091m() {
        return this.mPreferences == null ? "-1" : this.mPreferences.getString("pref_professional_exposure_time_key", "-1");
    }

    /* renamed from: OplusGLSurfaceView_11 */
    private long m16092n() {
        return Long.parseLong(this.mPreferences.getString("pref_professional_exposure_time_key", this.f15717D.getString(R.string.camera_exposure_time_default_value)));
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public int getCaptureIso() {
        String string = this.mPreferences.getString("pref_professional_iso_key", this.f15717D.getString(R.string.camera_iso_default_value));
        if (this.f15717D.getString(R.string.camera_iso_default_value).equals(string)) {
            return this.f15765s;
        }
        return Integer.parseInt(string);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public long getCaptureExposureTime() throws NumberFormatException {
        long OplusGLSurfaceView_15 = Long.parseLong(m16091m());
        return -1 == OplusGLSurfaceView_15 ? this.f15766t : OplusGLSurfaceView_15;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private int m15982a(int OplusGLSurfaceView_13, ArrayList<String> arrayList) {
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
    private int m15981a(float COUIBaseListPopupWindow_12, ArrayList<String> arrayList) {
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
    private int m15983a(long OplusGLSurfaceView_15, ArrayList<String> arrayList) {
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
        int iM15981a;
        int iM15982a;
        int iM15983a;
        int iM15982a2;
        super.onPreviewCaptureResult(cameraPreviewResult);
        if (this.mbCapModeInit) {
            if (cameraPreviewResult == null || cameraPreviewResult.getCaptureResult() == null) {
                CameraLog.m12967f("ProfessionalCapMode", "onPreviewCaptureResult, invalid totalResult: " + cameraPreviewResult);
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
            if (num != null && this.f15770x.m15836g(1) && (iM15982a2 = m15982a(num.intValue(), this.f15770x.m15824c(1))) > -1 && (!this.f15770x.m15827c(1, iM15982a2) || !this.f15761o)) {
                CameraLog.m12959b("ProfessionalCapMode", "onPreviewCaptureResult, iso: " + num);
                this.f15765s = num.intValue();
                ArrayList<String> arrayListM15828d = this.f15770x.m15828d(1);
                if (arrayListM15828d != null && arrayListM15828d.size() > iM15982a2) {
                    String str = arrayListM15828d.get(iM15982a2);
                    LevelPanel.m15348a("pref_professional_iso_key", str);
                    this.f15770x.scrollTo(1, iM15982a2);
                    m15989a(1, str);
                }
            }
            if (OplusGLSurfaceView_14 != null && this.f15770x.m15836g(2) && (iM15983a = m15983a(OplusGLSurfaceView_14.longValue(), this.f15770x.m15824c(2))) > -1 && (!this.f15770x.m15827c(2, iM15983a) || !this.f15761o)) {
                CameraLog.m12959b("ProfessionalCapMode", "onPreviewCaptureResult, exposureTime: " + OplusGLSurfaceView_14);
                this.f15766t = OplusGLSurfaceView_14.longValue();
                ArrayList<String> arrayListM15828d2 = this.f15770x.m15828d(2);
                if (arrayListM15828d2 != null && arrayListM15828d2.size() > iM15983a) {
                    String str2 = arrayListM15828d2.get(iM15983a);
                    LevelPanel.m15348a("pref_professional_exposure_time_key", str2);
                    this.f15770x.scrollTo(2, iM15983a);
                    m15989a(2, str2);
                }
            }
            if (this.f15770x.m15836g(5) && (iM15982a = m15982a(OplusGLSurfaceView_13, this.f15770x.m15824c(5))) > -1 && (!this.f15770x.m15827c(5, iM15982a) || !this.f15761o)) {
                CameraLog.m12959b("ProfessionalCapMode", "onPreviewCaptureResult, cct: " + OplusGLSurfaceView_13);
                ArrayList<String> arrayListM15828d3 = this.f15770x.m15828d(5);
                if (arrayListM15828d3 != null && arrayListM15828d3.size() > iM15982a) {
                    String str3 = arrayListM15828d3.get(iM15982a);
                    LevelPanel.m15348a("pref_professional_whitebalance_key", str3);
                    this.f15770x.scrollTo(5, iM15982a);
                    m15989a(5, str3);
                }
            }
            if (COUIBaseListPopupWindow_12 != null && this.f15770x.m15836g(4) && (iM15981a = m15981a(COUIBaseListPopupWindow_12.floatValue(), this.f15770x.m15824c(4))) > -1 && (!this.f15770x.m15827c(4, iM15981a) || !this.f15761o)) {
                CameraLog.m12959b("ProfessionalCapMode", "onPreviewCaptureResult, focusDistance: " + COUIBaseListPopupWindow_12);
                ArrayList<String> arrayListM15828d4 = this.f15770x.m15828d(4);
                if (arrayListM15828d4 != null && arrayListM15828d4.size() > iM15981a) {
                    String str4 = arrayListM15828d4.get(iM15981a);
                    LevelPanel.m15348a("pref_professional_focus_mode_key", str4);
                    this.f15770x.scrollTo(4, iM15981a);
                    m15989a(4, str4);
                }
            }
            this.f15761o = true;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0188  */
    @Override // com.oplus.camera.capmode.BaseMode
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean getSupportFunction(java.lang.String r12) {
        /*
            Method dump skipped, instructions count: 960
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.professional.ProfessionalCapMode.getSupportFunction(java.lang.String):boolean");
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m15993a(ListProfessionalModeBar listProfessionalModeBar, int OplusGLSurfaceView_13, ListModeBarAdapter listModeBarAdapter, ListProfessionalModeBar.OnItemClickListener onItemClickListener) throws Resources.NotFoundException {
        if (listProfessionalModeBar != null) {
            BaseScreenMode currentScreenMode = getCurrentScreenMode();
            if (currentScreenMode != null) {
                listProfessionalModeBar.setScreenMode(currentScreenMode);
            }
            listProfessionalModeBar.setId(OplusGLSurfaceView_13);
            listProfessionalModeBar.setAdapter(listModeBarAdapter);
            listProfessionalModeBar.setOnItemClickListener(onItemClickListener);
        }
    }

    /* renamed from: o */
    private void m16095o() throws NumberFormatException {
        if (this.mOneCamera != null) {
            if (this.f15756j) {
                this.mOneCamera.mo13030a(Long.parseLong(this.f15717D.getString(R.string.camera_exposure_time_default_value)));
                this.mOneCamera.mo13031a(Long.parseLong(this.f15717D.getString(R.string.camera_exposure_time_default_value)), false);
            } else {
                String strM16135a = ProfessionalUtil.m16135a(this.mActivity, 5);
                if (this.mPreferences.getString("pref_professional_whitebalance_key", strM16135a).equals(strM16135a)) {
                    m16121a(false);
                } else {
                    m16076e(false);
                }
                if (m15938E()) {
                    this.mOneCamera.mo13032a((CaptureRequest.Key<CaptureRequest.Key>) CaptureRequest.CONTROL_AE_EXPOSURE_COMPENSATION, (CaptureRequest.Key) Integer.valueOf(AEAFHelp.m11155c()));
                } else {
                    this.mOneCamera.mo13032a((CaptureRequest.Key<CaptureRequest.Key>) CaptureRequest.CONTROL_AE_EXPOSURE_COMPENSATION, (CaptureRequest.Key) Integer.valueOf(m16125c()));
                }
                m16001a((String) null, false);
                m16078f(false);
                m16120a((String) null);
            }
            m16118a(3);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private void m16055b(boolean z) throws NumberFormatException {
        this.f15719F = false;
        m16063c(z);
        m16118a(3);
        this.mPreferences.edit().remove(CameraUIInterface.KEY_RESTORE_PROFESSIONAL_PARAMS).apply();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m16118a(int OplusGLSurfaceView_13) {
        if (Thread.currentThread() != this.f15767u) {
            Handler handler = this.f15715B;
            if (handler != null) {
                handler.sendEmptyMessage(OplusGLSurfaceView_13);
                return;
            }
            return;
        }
        m16119a(OplusGLSurfaceView_13, (Message) null);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m16119a(int OplusGLSurfaceView_13, Message message) {
        switch (OplusGLSurfaceView_13) {
            case 1:
                if (this.f15769w.isSelected()) {
                    int selectedPosition = this.f15769w.getSelectedPosition();
                    this.f15769w.m15384a(selectedPosition, true);
                    View childAt = this.f15769w.getChildAt(selectedPosition);
                    if (childAt != null && this.f15770x.m15836g(this.f15769w.m15379a(childAt))) {
                        this.f15769w.getAdapter().m15367a(childAt, 0, true);
                    }
                }
                this.f15770x.m15804a();
                break;
            case 2:
                this.mCameraInterface.mo10527ac();
                break;
            case 3:
                this.f15770x.m15838h(5);
                this.f15770x.m15838h(1);
                this.f15770x.m15838h(2);
                this.f15770x.m15838h(3);
                this.f15770x.m15838h(4);
                m15932B();
                break;
            case 4:
                m15947J();
                this.f15770x.setPanelsBarAuto(4);
                break;
            case 5:
                if (!this.f15759m && !this.mCameraInterface.mo10445A()) {
                    this.mCameraUIInterface.mo18091a(getShutterButtonInfo());
                    break;
                }
                break;
            case 6:
                if (m15938E()) {
                    this.mCameraUIInterface.mo18166b(R.string.camera_macro_best_focus_distance_text, R.drawable.screen_hint_textview_bg, R.color.screen_hint_text_color, Integer.valueOf(CameraConfig.getConfigIntValue(ConfigDataBase.KEY_MACRO_BEST_FOCUS_DISTANCE)));
                    break;
                }
                break;
            case 7:
                m16002a(this.f15770x.mo13582b(3), 3);
                break;
            case 8:
                m15932B();
                break;
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private void m16063c(boolean z) throws NumberFormatException {
        if (this.mOneCamera == null) {
            return;
        }
        this.mOneCamera.mo13032a((CaptureRequest.Key<CaptureRequest.Key>) CaptureRequest.CONTROL_SCENE_MODE, (CaptureRequest.Key) 0);
        m16001a(this.f15717D.getString(R.string.camera_iso_default_value), false);
        long OplusGLSurfaceView_15 = Long.parseLong(this.f15717D.getString(R.string.camera_exposure_time_default_value));
        this.mOneCamera.mo13030a(OplusGLSurfaceView_15);
        this.mOneCamera.mo13031a(OplusGLSurfaceView_15, false);
        m15952L();
        if (!this.f15719F || m15938E()) {
            this.mOneCamera.mo13032a((CaptureRequest.Key<CaptureRequest.Key>) CaptureRequest.CONTROL_AE_EXPOSURE_COMPENSATION, (CaptureRequest.Key) Integer.valueOf(AEAFHelp.m11155c()));
        } else {
            this.mOneCamera.mo13032a((CaptureRequest.Key<CaptureRequest.Key>) CaptureRequest.CONTROL_AE_EXPOSURE_COMPENSATION, (CaptureRequest.Key) Integer.valueOf(m16125c()));
        }
        this.mOneCamera.mo13103i(false);
        if (z) {
            this.mOneCamera.mo13035a((OneCamera.IntrinsicsJvm.kt_3) null);
        }
        m15950K();
        m15954M();
        this.mActivity.runOnUiThread(new Runnable() { // from class: com.oplus.camera.professional.v.21
            @Override // java.lang.Runnable
            public void run() {
                ProfessionalCapMode.this.m15947J();
                ProfessionalCapMode.this.f15770x.setPanelsBarAuto(4);
                ProfessionalCapMode.this.f15770x.m15819b();
                ProfessionalCapMode.this.m16097p();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: p */
    public synchronized void m16097p() {
        ArrayList<String> arrayListM15828d = this.f15770x.m15828d(3);
        int iIndexOf = this.f15770x.m15824c(3).indexOf(ProfessionalUtil.m16135a(this.mActivity, 3));
        this.f15770x.scrollTo(3, iIndexOf);
        this.f15770x.m15820b(3, iIndexOf);
        if (arrayListM15828d != null && arrayListM15828d.size() > iIndexOf) {
            m15989a(3, arrayListM15828d.get(iIndexOf));
        }
    }

    /* renamed from: q */
    private void m16099q() throws Resources.NotFoundException {
        RelativeLayout.LayoutParams layoutParams;
        if (this.f15769w == null) {
            this.f15769w = new ListProfessionalModeBar(this.mActivity, m16124b(), m16130h());
            this.f15769w.setPanelInterface(this.f15770x);
            this.f15769w.setCameraUIInterface(this.mCameraUIInterface);
            if (m16127e()) {
                this.f15716C.setVisibility(0);
            }
            this.f15769w.setVisibility(0);
            BaseScreenMode currentScreenMode = getCurrentScreenMode();
            if (currentScreenMode != null) {
                layoutParams = currentScreenMode.mo16514f();
            } else {
                layoutParams = new RelativeLayout.LayoutParams(-1, this.f15725L);
                layoutParams.addRule(12);
                layoutParams.addRule(14);
            }
            ListModeBarAdapter listModeBarAdapter = new ListModeBarAdapter(this.mActivity, this.f15770x.m15803a(true));
            listModeBarAdapter.m15371a((PanelInterface) this.f15770x);
            m15993a(this.f15769w, R.id_renamed.main_bar_id, listModeBarAdapter, this);
            this.f15716C.addView(this.f15769w, layoutParams);
        }
    }

    /* renamed from: r */
    private void m16100r() {
        RelativeLayout.LayoutParams layoutParams;
        if (this.f15770x == null) {
            this.f15770x = new PanelContainer(this.mActivity, this.mCameraInterface, m16128f(), m16129g());
            this.f15770x.setGravity(17);
            this.f15770x.setId(R.id_renamed.professional_param_slide_bar_container);
            BaseScreenMode currentScreenMode = getCurrentScreenMode();
            if (Util.m24495t()) {
                this.f15770x.setCameraUIInterface(this.mCameraUIInterface);
            }
            if (currentScreenMode != null && Util.m24498u()) {
                layoutParams = currentScreenMode.mo16515g();
            } else {
                layoutParams = new RelativeLayout.LayoutParams(Util.getScreenWidth(), this.f15726M + this.f15727N);
                layoutParams.setMargins(0, 0, 0, this.f15725L);
                layoutParams.addRule(14);
                layoutParams.addRule(12);
            }
            this.f15716C.addView(this.f15770x, layoutParams);
        }
    }

    /* renamed from: s */
    private void m16103s() throws Resources.NotFoundException, NumberFormatException {
        int OplusGLSurfaceView_13;
        this.f15767u = Thread.currentThread();
        int properCameraId = getProperCameraId(this.mCameraId);
        CameraLog.m12954a("ProfessionalCapMode", "addViewToRoot, mUiThread: " + this.f15767u);
        this.f15761o = false;
        m15934C();
        m16100r();
        PanelContainer c2898p = this.f15770x;
        if (c2898p != null && (OplusGLSurfaceView_13 = this.f15718E) != properCameraId && OplusGLSurfaceView_13 != -1) {
            c2898p.m15829d();
        }
        this.f15718E = properCameraId;
        if (Util.m24508z(this.mActivity)) {
            this.f15770x.mo15728a(getCameraInfo(this.f15718E), this.f15715B, (PanelContainer.PlatformImplementations.kt_3) null);
            if (isSuperRawOpen()) {
                this.f15770x.m15814a(getCameraInfo(this.f15718E), 2000000000L);
            }
            m16099q();
            this.f15770x.setSettleListener(this.f15769w);
            this.f15770x.setMotionListener(this.f15752am);
            m16118a(1);
            this.f15720G = true;
        }
        m16107u();
        m16112x();
        this.f15748ai = new TextView(this.mActivity);
        this.f15748ai.setWillNotDraw(true);
        this.f15748ai.setVisibility(4);
        this.f15748ai.setBackgroundResource(R.drawable.screen_hint_textview_bg);
        this.f15748ai.setLineSpacing(this.mActivity.getResources().getDimensionPixelSize(R.dimen.camera_hint_extra_line_spacing), this.f15748ai.getLineSpacingMultiplier());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.mActivity.getResources().getDimensionPixelSize(R.dimen.camera_up_hint_text_secondary_max_width), -2);
        layoutParams.addRule(13);
        layoutParams.setMargins(this.mActivity.getResources().getDimensionPixelSize(R.dimen.camera_hint_text_padding_left), this.mActivity.getResources().getDimensionPixelSize(R.dimen.camera_hint_text_padding_top), this.mActivity.getResources().getDimensionPixelSize(R.dimen.camera_hint_text_padding_right), this.mActivity.getResources().getDimensionPixelSize(R.dimen.camera_hint_text_padding_bottom));
        this.mCameraUIInterface.mo18163b().addView(this.f15748ai, layoutParams);
        this.f15742ac = this.mActivity.getResources().getDimensionPixelSize(R.dimen.camera_hint_text_padding_bottom);
        this.f15743ad = this.mActivity.getResources().getDimensionPixelSize(R.dimen.camera_hint_text_padding_bottom_size_type_1_1);
        this.f15746ag = this.mPreferences.getString(CameraUIInterface.KEY_PHOTO_RATIO, this.mActivity.getString(R.string.camera_photo_ratio_default_value));
        if ("square".equals(this.f15746ag)) {
            this.f15744ae = Util.m24184L() + Util.m24186N();
        } else {
            this.f15744ae = Util.m24186N();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: t */
    public int m16104t() {
        RelativeLayout relativeLayoutMo18253p;
        int iM24186N = Util.m24186N();
        return (this.mCameraUIInterface == null || (relativeLayoutMo18253p = this.mCameraUIInterface.mo18253p()) == null || relativeLayoutMo18253p.getTop() <= iM24186N) ? iM24186N : relativeLayoutMo18253p.getTop();
    }

    /* renamed from: u */
    private void m16107u() {
        if (this.f15722I == null) {
            this.f15722I = new RotateImageView(this.mActivity);
            this.f15722I.setId(R.id_renamed.professional_parameter_bottom_guide_entry);
            this.f15722I.setImageResource(R.drawable.professional_mode_guide_icon);
            this.f15723J = this.f15722I.getDrawable().getIntrinsicWidth();
            int dimensionPixelSize = (this.f15717D.getDimensionPixelSize(R.dimen.common_bottom_guide_professional_entry_touch_width) - this.f15723J) / 2;
            this.f15722I.setLayoutParams(m16109v());
            this.f15722I.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
            this.f15722I.setOnClickListener(new View.OnClickListener() { // from class: com.oplus.camera.professional.-$$Lambda$p8aM6hM1kA9Bw2NbF4BY_ZtrwFc
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.COUIBaseListPopupWindow_12$0.onClick(view);
                }
            });
        }
        this.f15722I.m18348a(this.mCameraInterface.mo10591u(), false);
        this.mCameraUIInterface.mo18087a((View) this.f15722I, ApsConstant.CAPTURE_MODE_PROFESSIONAL, 2, false);
        m16070d(false);
    }

    /* renamed from: v */
    private ViewGroup.LayoutParams m16109v() throws Resources.NotFoundException {
        int dimensionPixelSize = (this.f15717D.getDimensionPixelSize(R.dimen.common_bottom_guide_professional_entry_touch_width) - this.f15723J) / 2;
        int iM16104t = m16104t();
        CameraLog.m12954a("ProfessionalCapMode", "getGuideEntryLayoutParams, previewMarginTop: " + iM16104t);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        if (1 == m16128f()) {
            layoutParams.addRule(10);
            int iM24460i = Util.m24460i(R.dimen.fold_full_professional_guide_entry_margin_top);
            int iM24460i2 = Util.m24460i(R.dimen.fold_full_professional_guide_entry_margin_right);
            layoutParams.topMargin = iM24460i;
            if (270 == m16129g()) {
                layoutParams.addRule(20);
                layoutParams.leftMargin = iM24460i2;
            } else {
                layoutParams.addRule(21);
                layoutParams.rightMargin = iM24460i2;
            }
        } else if (3 == m16128f()) {
            layoutParams.addRule(10);
            layoutParams.addRule(21);
            int dimensionPixelOffset = this.f15717D.getDimensionPixelOffset(R.dimen.fold_split_professional_guide_entry_margin_top);
            int dimensionPixelOffset2 = this.f15717D.getDimensionPixelOffset(R.dimen.fold_split_professional_guide_entry_margin_right);
            layoutParams.topMargin = dimensionPixelOffset;
            layoutParams.rightMargin = dimensionPixelOffset2;
        } else if (4 == m16128f()) {
            layoutParams.addRule(12);
            layoutParams.addRule(20);
            layoutParams.bottomMargin = Util.m24460i(R.dimen.fold_rack_professional_guide_entry_margin_bottom);
            layoutParams.leftMargin = Util.m24460i(R.dimen.fold_rack_professional_guide_entry_margin_left);
        } else {
            layoutParams.addRule(10);
            layoutParams.addRule(21);
            int dimensionPixelSize2 = iM16104t + this.f15717D.getDimensionPixelSize(R.dimen.common_bottom_guide_professional_entry_margin_top);
            int dimensionPixelSize3 = this.f15717D.getDimensionPixelSize(R.dimen.common_bottom_guide_professional_entry_margin_end);
            layoutParams.topMargin = dimensionPixelSize2 - dimensionPixelSize;
            if (1 == TextUtilsCompat.m2525a(Locale.getDefault())) {
                layoutParams.leftMargin = dimensionPixelSize3 - dimensionPixelSize;
            } else {
                layoutParams.rightMargin = dimensionPixelSize3 - dimensionPixelSize;
            }
        }
        return layoutParams;
    }

    /* renamed from: w */
    private void m16110w() {
        if (this.f15722I != null) {
            if (Util.m24495t()) {
                LayoutUtil.m16634a(this.f15722I);
                this.f15722I.setLayoutParams(m16109v());
                if (1 == m16128f()) {
                    if (m16129g() == 0) {
                        this.f15722I.setRotation(0.0f);
                        return;
                    } else {
                        this.f15722I.setRotation(360 - m16129g());
                        return;
                    }
                }
                if (4 == m16128f()) {
                    this.f15722I.setRotation(360 - m16129g());
                    return;
                } else {
                    this.f15722I.setRotation(0.0f);
                    return;
                }
            }
            int iM16104t = m16104t();
            CameraLog.m12954a("ProfessionalCapMode", "updateBottomGuideEntryPosition, previewMarginTop: " + iM16104t);
            int dimensionPixelSize = iM16104t + this.f15717D.getDimensionPixelSize(R.dimen.common_bottom_guide_professional_entry_margin_top);
            int dimensionPixelSize2 = (this.f15717D.getDimensionPixelSize(R.dimen.common_bottom_guide_professional_entry_touch_width) - this.f15723J) / 2;
            final RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f15722I.getLayoutParams();
            int OplusGLSurfaceView_13 = dimensionPixelSize - dimensionPixelSize2;
            int i2 = layoutParams.topMargin;
            if (OplusGLSurfaceView_13 != i2) {
                ValueAnimator valueAnimator = this.f15724K;
                if (valueAnimator == null) {
                    this.f15724K = ValueAnimator.ofInt(i2, OplusGLSurfaceView_13);
                    this.f15724K.setDuration(300L);
                    this.f15724K.setInterpolator(ProfessionalAnimConstant.f15695b);
                    this.f15724K.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.professional.v.22
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator2) {
                            layoutParams.topMargin = ((Integer) valueAnimator2.getAnimatedValue()).intValue();
                            ProfessionalCapMode.this.f15722I.setLayoutParams(layoutParams);
                        }
                    });
                } else {
                    valueAnimator.setIntValues(i2, OplusGLSurfaceView_13);
                }
                if (this.f15724K.isRunning()) {
                    return;
                }
                this.f15724K.start();
                return;
            }
            layoutParams.topMargin = OplusGLSurfaceView_13;
            this.f15722I.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: IntrinsicsJvm.kt_5 */
    public void m16070d(boolean z) {
        if (this.mbModePreInit) {
            boolean z2 = ("on".equals(this.mPreferences.getString(CameraUIInterface.KEY_SUB_SETTING, "off")) || this.f15729P || !this.f15730Q) ? false : true;
            RotateImageView rotateImageView = this.f15722I;
            if (rotateImageView != null) {
                if (!z) {
                    rotateImageView.clearAnimation();
                    this.f15722I.setVisibility(z2 ? 0 : 4);
                    this.f15722I.setAlpha(1.0f);
                } else if (z2) {
                    Util.m24271a(rotateImageView, 0, (Animation.AnimationListener) null, 250L, 250L, ProfessionalAnimConstant.f15694a);
                } else {
                    Util.m24271a(rotateImageView, 4, (Animation.AnimationListener) null, 250L, 0L, ProfessionalAnimConstant.f15694a);
                }
            }
        }
    }

    /* renamed from: x */
    private void m16112x() {
        if (this.f15771y == null) {
            this.f15771y = new RotateImageView(this.mActivity.getApplicationContext());
            this.f15771y.setEnabled(true);
            this.f15771y.setFocusable(false);
            this.f15771y.setClickable(true);
            this.f15771y.setVisibility(4);
            this.f15771y.setContentDescription(this.mActivity.getResources().getString(R.string.camera_setting_menu_parameter_default));
            this.f15771y.setOnClickListener(new View.OnClickListener() { // from class: com.oplus.camera.professional.v.23
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    ProfessionalCapMode.this.m16003a(true, ProfessionalCapMode.this.mPreferences.getString(CameraUIInterface.KEY_PARAMETER_SAVING, "off"));
                    ProfessionalCapMode.this.m15929A();
                    ProfessionalCapMode.this.m15978Y();
                }
            });
            final Spring c1032fM15923a = ProfessionalAnimUtil.m15923a();
            this.f15771y.setOnTouchListener(new View.OnTouchListener() { // from class: com.oplus.camera.professional.v.2
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    int action = motionEvent.getAction();
                    if (action == 0) {
                        ProfessionalAnimUtil.m15924a((View) ProfessionalCapMode.this.f15771y, c1032fM15923a, true);
                    } else if (action == 1 || action == 3) {
                        ProfessionalAnimUtil.m15924a((View) ProfessionalCapMode.this.f15771y, c1032fM15923a, false);
                    }
                    return false;
                }
            });
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(21);
            layoutParams.addRule(11);
            layoutParams.topMargin = this.f15717D.getDimensionPixelSize(R.dimen.control_button_margin_top);
            layoutParams.setMarginEnd(this.f15717D.getDimensionPixelSize(R.dimen.control_button_margin_edge));
            this.f15771y.setLayoutParams(layoutParams);
            this.f15771y.setImageResource(R.drawable.ic_parameter_saving_store);
            this.f15771y.setBackgroundResource(R.drawable.switch_camera_button_bg);
            ((RelativeLayout) this.mActivity.findViewById(R.id_renamed.control_panel_button_layout)).addView(this.f15771y);
        }
        this.f15771y.m18348a(this.mCameraInterface.mo10591u(), false);
        m16117z();
        m15929A();
    }

    /* renamed from: y */
    private boolean m16115y() {
        return (!getSupportFunction(CameraUIInterface.KEY_PARAMETER_SAVING) || this.mPreferences == null || this.mPreferences.getString(CameraUIInterface.KEY_PARAMETER_SAVING, "off").equals("off")) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: z */
    public void m16117z() {
        this.f15763q = m16115y();
        RotateImageView rotateImageView = this.f15771y;
        if (rotateImageView != null) {
            rotateImageView.setVisibility(this.f15763q ? 0 : 4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: A */
    public void m15929A() {
        if (m16115y()) {
            boolean z = !this.f15770x.m15818a(this.mPreferences.getString(CameraUIInterface.KEY_SWITCH_CAMERA, "camera_main"), this.mPreferences.getString(CameraUIInterface.KEY_PARAMETER_SAVING, "off"));
            RotateImageView rotateImageView = this.f15771y;
            if (rotateImageView != null) {
                rotateImageView.setEnabled(z);
                if (z) {
                    this.f15771y.setColorFilter(Util.m24164A(this.mActivity));
                } else {
                    this.f15771y.setColorFilter(ContextCompat.m2254c(this.mActivity, R.color.camera_white));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public void m16003a(boolean z, String str) {
        String string = this.mPreferences.getString(CameraUIInterface.KEY_SWITCH_CAMERA, "camera_main");
        if (z) {
            this.f15770x.m15822b(string, str);
        } else {
            this.f15770x.m15825c(string, str);
        }
    }

    /* renamed from: B */
    private void m15932B() {
        m16002a(this.f15770x.mo13582b(0), 0);
        m15929A();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public int getZoomBarOffset() {
        if (this.mCameraUIInterface != null && (1 == this.mCameraUIInterface.mo18134aX() || 4 == this.mCameraUIInterface.mo18134aX())) {
            return super.getZoomBarOffset();
        }
        return this.f15725L;
    }

    /* renamed from: C */
    private void m15934C() {
        RelativeLayout.LayoutParams layoutParams;
        if (this.f15716C == null) {
            this.f15716C = new PlatformImplementations.kt_3(this.mActivity);
            this.f15716C.setId(R.id_renamed.professional_params_bar_container);
            BaseScreenMode currentScreenMode = getCurrentScreenMode();
            if (currentScreenMode != null) {
                layoutParams = currentScreenMode.mo16512e();
            } else {
                layoutParams = new RelativeLayout.LayoutParams(-2, Util.getScreenWidth());
                layoutParams.addRule(12);
                layoutParams.addRule(14);
                if (this.mCameraInterface != null) {
                    layoutParams.bottomMargin = this.mCameraUIInterface.mo18261r();
                } else {
                    layoutParams.bottomMargin = 0;
                }
            }
            this.f15716C.setLayoutParams(layoutParams);
            this.f15716C.setVisibility(8);
            this.f15716C.getViewTreeObserver().addOnWindowFocusChangeListener(new ViewTreeObserver.OnWindowFocusChangeListener() { // from class: com.oplus.camera.professional.v.3
                @Override // android.view.ViewTreeObserver.OnWindowFocusChangeListener
                public void onWindowFocusChanged(boolean z) {
                    if (ProfessionalCapMode.this.f15769w != null) {
                        CameraLog.m12954a("ProfessionalCapMode", "onWindowFocusChanged, SelectedPosition: " + ProfessionalCapMode.this.f15769w.getSelectedPosition() + ", hasFocus: " + z);
                        ProfessionalCapMode.this.f15769w.m15384a(ProfessionalCapMode.this.f15769w.getSelectedPosition(), true);
                    }
                }
            });
        }
        this.mCameraUIInterface.mo18087a((View) this.f15716C, ApsConstant.CAPTURE_MODE_PROFESSIONAL, 1, false);
        PlatformImplementations.kt_3 aVar = this.f15716C;
        if (aVar != null) {
            aVar.setTouchState(true);
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void checkoutTimerSnapShotState() {
        super.checkoutTimerSnapShotState();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onTimeSnapShotEnd(boolean z) {
        MainShutterButtonInfo shutterButtonInfo = getShutterButtonInfo();
        if (this.f15756j && z) {
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
        CameraLog.m12962c("ProfessionalCapMode", "onBackPressed, mbInCapturing: " + this.mbInCapturing);
        if (this.f15769w.isSelected()) {
            this.mCameraInterface.mo10492a(true, true);
            this.mCameraInterface.mo10563d(true);
            if (4 == m16128f()) {
                this.mCameraUIInterface.mo18215g(0);
            }
            ProfessionalAnimUtil.PlatformImplementations.kt_3 aVar = new ProfessionalAnimUtil.PlatformImplementations.kt_3();
            aVar.f15706a = false;
            aVar.f15708c = 250;
            aVar.f15712g = 400;
            aVar.f15709d = 0.0f;
            aVar.f15710e = this.mActivity.getResources().getDimensionPixelSize(R.dimen.main_mode_bar_item_animation_offset);
            this.f15770x.setAllPopupInvisibility(aVar);
            this.f15769w.m15381a();
            this.mOneCamera.mo13105j(true);
            return true;
        }
        return super.onBackPressed();
    }

    @Override // com.oplus.camera.capmode.BaseMode, com.oplus.camera.p141e.OneCamera.PlatformImplementations.kt_3
    public void onCaptureSequenceCompleted() {
        super.onCaptureSequenceCompleted();
        CameraLog.m12962c("ProfessionalCapMode", "onCaptureSequenceCompleted");
        if (isSuperRawOpen()) {
            this.mCameraUIInterface.mo18067a(R.string.camera_scene_night_keep_phone_steady);
            if (this.f15754h || this.mActivity == null) {
                return;
            }
            this.mActivity.runOnUiThread(new Runnable() { // from class: com.oplus.camera.professional.v.4
                @Override // java.lang.Runnable
                public void run() {
                    ProfessionalCapMode.this.mCameraUIInterface.mo18091a(new MainShutterButtonInfo());
                    ProfessionalCapMode.this.mCameraUIInterface.mo18107a(false, true);
                    if (ProfessionalCapMode.this.mbPaused || ProfessionalCapMode.this.f15768v == null) {
                        return;
                    }
                    ProfessionalCapMode.this.f15768v.m20105f();
                }
            });
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected boolean onStopTakePicture() {
        if (2 != this.mCameraInterface.mo10570g()) {
            CameraLog.m12967f("ProfessionalCapMode", "onStopTakePicture failed, current camera state is " + this.mCameraInterface.mo10570g());
            return false;
        }
        this.mActivity.runOnUiThread(new Runnable() { // from class: com.oplus.camera.professional.v.5
            /* JADX WARN: Removed duplicated region for block: B:6:0x001a  */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public void run() throws android.content.res.Resources.NotFoundException {
                /*
                    r6 = this;
                    com.oplus.camera.professional.v r0 = com.oplus.camera.professional.ProfessionalCapMode.this
                    java.lang.String r1 = com.oplus.camera.professional.ProfessionalCapMode.m15949K(r0)
                    boolean r0 = com.oplus.camera.professional.ProfessionalCapMode.m16006a(r0, r1)
                    r1 = 1
                    r2 = 0
                    if (r0 != 0) goto L1a
                    com.oplus.camera.professional.v r0 = com.oplus.camera.professional.ProfessionalCapMode.this
                    java.lang.String r3 = com.oplus.camera.professional.ProfessionalCapMode.m15949K(r0)
                    boolean r0 = com.oplus.camera.professional.ProfessionalCapMode.m16057b(r0, r3)
                    if (r0 == 0) goto L53
                L1a:
                    com.oplus.camera.professional.v r0 = com.oplus.camera.professional.ProfessionalCapMode.this
                    com.oplus.camera.COUIBaseListPopupWindow_8.IntrinsicsJvm.kt_5 r0 = com.oplus.camera.professional.ProfessionalCapMode.m15951L(r0)
                    r0.mo13098h()
                    com.oplus.camera.professional.v r0 = com.oplus.camera.professional.ProfessionalCapMode.this
                    com.oplus.camera.capmode.PlatformImplementations.kt_3 r0 = com.oplus.camera.professional.ProfessionalCapMode.m15953M(r0)
                    r0.mo10467W()
                    com.oplus.camera.professional.v r0 = com.oplus.camera.professional.ProfessionalCapMode.this
                    com.oplus.camera.professional.ProfessionalCapMode.m15996a(r0, r2, r1)
                    com.oplus.camera.professional.v r0 = com.oplus.camera.professional.ProfessionalCapMode.this
                    com.oplus.camera.professional.ProfessionalCapMode.m15956N(r0)
                    com.oplus.camera.professional.v r0 = com.oplus.camera.professional.ProfessionalCapMode.this
                    boolean r0 = r0.isSuperRawOpen()
                    if (r0 == 0) goto L53
                    com.oplus.camera.professional.v r0 = com.oplus.camera.professional.ProfessionalCapMode.this
                    com.oplus.camera.ui.CameraUIInterface r0 = com.oplus.camera.professional.ProfessionalCapMode.m15957O(r0)
                    r3 = 2131755796(0x7f100314, float:1.9142481E38)
                    r0.mo18067a(r3)
                    com.oplus.camera.professional.v r0 = com.oplus.camera.professional.ProfessionalCapMode.this
                    com.oplus.camera.ui.COUIBaseListPopupWindow_10 r0 = com.oplus.camera.professional.ProfessionalCapMode.m16067d(r0)
                    r0.mo20099a()
                L53:
                    com.oplus.camera.professional.v r0 = com.oplus.camera.professional.ProfessionalCapMode.this
                    com.oplus.camera.professional.v$PlatformImplementations.kt_3 r0 = com.oplus.camera.professional.ProfessionalCapMode.m15959P(r0)
                    r3 = 0
                    r4 = 300(0x12c, double:1.48E-321)
                    com.oplus.camera.util.Util.m24270a(r0, r2, r3, r4)
                    com.oplus.camera.professional.v r0 = com.oplus.camera.professional.ProfessionalCapMode.this
                    com.oplus.camera.professional.ProfessionalCapMode.m16069d(r0, r2)
                    com.oplus.camera.professional.v r6 = com.oplus.camera.professional.ProfessionalCapMode.this
                    com.oplus.camera.ui.CameraUIInterface r6 = com.oplus.camera.professional.ProfessionalCapMode.m15961Q(r6)
                    r6.mo18191c(r1, r2)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.professional.ProfessionalCapMode.MoreUIControl_7.run():void");
            }
        });
        this.mbInCapturing = false;
        setCapturePreviewDataState(2);
        this.f15716C.setTouchState(true);
        this.mCameraInterface.mo10569f(true);
        this.mCameraUIInterface.mo18107a(true, false);
        return true;
    }

    /* renamed from: D */
    private void m15935D() {
        this.mCameraUIInterface.mo18217g(true);
        RotateImageView rotateImageView = this.f15771y;
        if (rotateImageView != null) {
            rotateImageView.setVisibility(4);
        }
        PlatformImplementations.kt_3 aVar = this.f15716C;
        if (aVar != null) {
            aVar.setTouchState(false);
            ListProfessionalModeBar listProfessionalModeBar = this.f15769w;
            if (listProfessionalModeBar != null) {
                listProfessionalModeBar.removeAllViews();
                this.f15716C.removeView(this.f15769w);
                this.f15769w = null;
            }
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void onDeInitCameraMode(String str) throws Resources.NotFoundException {
        CameraLog.m12962c("ProfessionalCapMode", "onDeInitCameraMode");
        Handler handler = this.f15715B;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        PanelContainer c2898p = this.f15770x;
        if (c2898p != null) {
            c2898p.m15837h();
        }
        if (m15938E()) {
            this.mCameraUIInterface.mo18282w(true);
        }
        PlatformImplementations.kt_3 aVar = this.f15716C;
        if (aVar != null && aVar.getVisibility() != 0) {
            m15955N();
            m15935D();
        }
        m16054b("0", false);
        ValueAnimator valueAnimator = this.f15749aj;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.f15749aj.cancel();
        }
        HistogramProcessorManager c2826p = this.f15772z;
        if (c2826p != null) {
            c2826p.m14849c();
            this.f15772z = null;
        }
        if (m15980Z() && this.f15741ab != 0) {
            this.f15741ab = 0;
            m16073e(0);
        }
        this.mCameraUIInterface.mo18281w(0);
        this.mCameraUIInterface.mo18163b().removeView(this.f15748ai);
        HintManager c3130aMo18233k = this.mCameraUIInterface.mo18233k();
        if (c3130aMo18233k != null) {
            c3130aMo18233k.m18484a((HintManager.IntrinsicsJvm.kt_4) null);
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void operateSpecificViewCallBack(Object obj, boolean z, boolean z2) {
        boolean z3 = obj instanceof Integer;
        if (z3 && 1 == ((Integer) obj).intValue() && !z) {
            if (z2) {
                CameraLog.m12959b("ProfessionalCapMode", "removeAllView when mEmptyViewToAnimate hide animation end");
                m15955N();
                m15935D();
            } else if (this.f15769w != null) {
                ProfessionalAnimUtil.PlatformImplementations.kt_3 aVar = new ProfessionalAnimUtil.PlatformImplementations.kt_3();
                aVar.f15706a = false;
                aVar.f15708c = 250;
                aVar.f15709d = 0.0f;
                aVar.f15710e = getZoomBarOffset();
                aVar.f15712g = 500;
                ProfessionalAnimUtil.m15922a(this.f15769w, aVar);
            }
        }
        if (z3 && 1 == ((Integer) obj).intValue() && z && z2) {
            this.f15715B.post(new Runnable() { // from class: com.oplus.camera.professional.v.6
                @Override // java.lang.Runnable
                public void run() {
                    if (ProfessionalCapMode.this.f15769w != null) {
                        ProfessionalCapMode.this.f15769w.m15389b();
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: IntrinsicsJvm.kt_4 */
    public boolean m16059b(String str) {
        return str != null && C1547C.NANOS_PER_SECOND <= Long.parseLong(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: IntrinsicsJvm.kt_3 */
    public boolean m16066c(String str) {
        return str != null && isSuperRawOpen() && C1547C.NANOS_PER_SECOND <= Long.parseLong(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: IntrinsicsJvm.kt_5 */
    public boolean m16071d(String str) {
        return str != null && isSuperRawOpen() && 500000000 <= Long.parseLong(str);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected boolean isHideUICapture() {
        return m16059b(m16091m()) && getIsCapturingState();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected boolean onBeforeSnapping(CameraRequestTag c2693c) {
        PanelContainer c2898p = this.f15770x;
        if (c2898p != null && c2898p.m15835g()) {
            CameraLog.m12962c("ProfessionalCapMode", "onBeforeSnapping, levelPanelScrolling");
            return false;
        }
        this.mActivity.runOnUiThread(new Runnable() { // from class: com.oplus.camera.professional.v.7
            @Override // java.lang.Runnable
            public void run() throws Resources.NotFoundException {
                if (ProfessionalCapMode.this.mbPaused) {
                    CameraLog.m12954a("ProfessionalCapMode", "onBeforeSnapping, return after pause");
                    return;
                }
                if (ProfessionalCapMode.this.isSuperRawOpen()) {
                    ProfessionalCapMode viewOnClickListenerC2904v = ProfessionalCapMode.this;
                    if (viewOnClickListenerC2904v.m16071d(viewOnClickListenerC2904v.m16091m()) && ProfessionalCapMode.this.mCameraUIInterface != null) {
                        ProfessionalCapMode.this.mCameraUIInterface.mo18070a(R.string.camera_scene_night_keep_phone_steady, -1, false, false, true);
                    }
                    ProfessionalCapMode viewOnClickListenerC2904v2 = ProfessionalCapMode.this;
                    if (viewOnClickListenerC2904v2.m16066c(viewOnClickListenerC2904v2.m16091m())) {
                        int iLongValue = ((int) (Long.valueOf(ProfessionalCapMode.this.m16091m()).longValue() / 1000000)) * 3;
                        ProfessionalCapMode.this.f15768v.m20100a(iLongValue);
                        if (ProfessionalCapMode.this.mCameraUIInterface != null) {
                            ProfessionalCapMode.this.mCameraUIInterface.mo18221h(iLongValue);
                        }
                    }
                    if (ProfessionalCapMode.this.mCameraUIInterface != null) {
                        ProfessionalCapMode.this.mCameraUIInterface.mo18215g(4);
                        ProfessionalCapMode.this.mCameraUIInterface.mo18209f(4);
                        ProfessionalCapMode.this.m16051b(4, true);
                        ProfessionalCapMode.this.mCameraUIInterface.mo18067a(R.string.camera_scene_tips_professional_raw_super_format);
                        ProfessionalCapMode.this.mCameraInterface.mo10479a((AnimatorListenerAdapter) null, true, false);
                    }
                    ProfessionalCapMode.this.f15730Q = false;
                    ProfessionalCapMode.this.m16070d(false);
                    ProfessionalCapMode.this.m16056b(false, false);
                    Util.m24270a(ProfessionalCapMode.this.f15716C, 4, (Animation.AnimationListener) null, 300L);
                    Util.m24270a(ProfessionalCapMode.this.f15771y, 4, (Animation.AnimationListener) null, 300L);
                } else {
                    ProfessionalCapMode viewOnClickListenerC2904v3 = ProfessionalCapMode.this;
                    if (viewOnClickListenerC2904v3.m16059b(viewOnClickListenerC2904v3.m16091m())) {
                        if (ProfessionalCapMode.this.mCameraUIInterface != null) {
                            ProfessionalCapMode.this.mCameraUIInterface.mo18215g(4);
                            ProfessionalCapMode.this.mCameraUIInterface.mo18209f(4);
                            ProfessionalCapMode.this.mCameraUIInterface.mo18052P(false);
                            ProfessionalCapMode.this.m16051b(4, true);
                            ProfessionalCapMode.this.mCameraInterface.mo10479a((AnimatorListenerAdapter) null, true, false);
                        }
                        ProfessionalCapMode.this.f15730Q = false;
                        ProfessionalCapMode.this.m16070d(false);
                        ProfessionalCapMode.this.m16005a(false, false, true);
                        Util.m24270a(ProfessionalCapMode.this.f15716C, 4, (Animation.AnimationListener) null, 300L);
                        Util.m24270a(ProfessionalCapMode.this.f15771y, 4, (Animation.AnimationListener) null, 300L);
                        if (ProfessionalCapMode.this.mCameraUIInterface != null) {
                            ProfessionalCapMode.this.mCameraUIInterface.mo18221h((int) (Long.valueOf(ProfessionalCapMode.this.m16091m()).longValue() / 1000000));
                        }
                    }
                }
                ProfessionalCapMode.this.f15716C.setTouchState(false);
                if (!ProfessionalCapMode.this.f15756j || ProfessionalCapMode.this.mCameraUIInterface == null || ProfessionalCapMode.this.mCameraUIInterface.mo18265s() == 2) {
                    return;
                }
                ProfessionalCapMode.this.mCameraUIInterface.mo18091a(new MainShutterButtonInfo(4, "button_color_inside_none"));
            }
        });
        setRawRequestTag(false);
        this.f15731R = null;
        if (isRawOpen()) {
            setRawRequestTag(true);
            this.f15760n = false;
        }
        if (isSuperRawOpen()) {
            setRawRequestTag(false);
            this.f15760n = false;
            synchronized (this.f15753g) {
                this.f15733T = false;
            }
        }
        m15946I();
        if (this.mOneCamera != null) {
            this.mOneCamera.mo13105j(true);
        }
        setCaptureRequestPictureSizeScale();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m16050b(int OplusGLSurfaceView_13) throws Resources.NotFoundException {
        CameraLog.m12954a("ProfessionalCapMode", "setCameraMenuControlViewVisibility, visibility: " + OplusGLSurfaceView_13);
        if (this.mCameraUIInterface != null) {
            this.mCameraUIInterface.mo18215g(OplusGLSurfaceView_13);
            this.mCameraUIInterface.mo18209f(OplusGLSurfaceView_13);
            this.mCameraUIInterface.mo18184c(OplusGLSurfaceView_13);
            this.mCameraUIInterface.mo18167b(OplusGLSurfaceView_13, true);
            this.mCameraUIInterface.mo18052P(true);
        }
        this.f15730Q = OplusGLSurfaceView_13 == 0;
        m16070d(false);
        m16005a(false, false, true);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean onAfterSnapping() {
        CameraLog.m12954a("ProfessionalCapMode", "onAfterSnapping");
        if (!this.f15756j && this.mCameraInterface.mo10575i() && Long.parseLong(m16091m()) >= C1547C.NANOS_PER_SECOND) {
            this.mCameraInterface.mo10558c(Util.m24352ao() ? 6 : 4);
        } else {
            CameraLog.m12954a("ProfessionalCapMode", "onAfterSnapping is ZSL mode, do nothing");
        }
        if (isRawOpen()) {
            this.f15755i = false;
        }
        if (isSuperRawOpen()) {
            this.f15754h = false;
        }
        this.mActivity.runOnUiThread(new Runnable() { // from class: com.oplus.camera.professional.v.8
            @Override // java.lang.Runnable
            public void run() {
                if (ProfessionalCapMode.this.mbPaused) {
                    return;
                }
                if (ProfessionalCapMode.this.isSuperRawOpen()) {
                    MainShutterButtonInfo shutterButtonInfo = ProfessionalCapMode.this.getShutterButtonInfo();
                    ProfessionalCapMode viewOnClickListenerC2904v = ProfessionalCapMode.this;
                    if (viewOnClickListenerC2904v.m16066c(viewOnClickListenerC2904v.m16091m())) {
                        ProfessionalCapMode.this.mCameraUIInterface.mo18107a(true, false);
                        ProfessionalCapMode.this.mCameraUIInterface.mo18226i(ProfessionalCapMode.this.f15717D.getDimensionPixelOffset(R.dimen.night_countdown_time_margin_top));
                        ProfessionalCapMode.this.f15768v.mo20103d();
                        ProfessionalCapMode.this.f15768v.mo20104e();
                        if (ProfessionalCapMode.this.mCameraUIInterface.mo18265s() == 9) {
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
                    ProfessionalCapMode.this.mCameraUIInterface.mo18091a(shutterButtonInfo);
                    return;
                }
                ProfessionalCapMode viewOnClickListenerC2904v2 = ProfessionalCapMode.this;
                if (viewOnClickListenerC2904v2.m16059b(viewOnClickListenerC2904v2.m16091m())) {
                    ProfessionalCapMode.this.mCameraUIInterface.mo18107a(true, false);
                    MainShutterButtonInfo shutterButtonInfo2 = ProfessionalCapMode.this.getShutterButtonInfo();
                    if (ProfessionalCapMode.this.mCameraUIInterface.mo18265s() == 9) {
                        shutterButtonInfo2.m19226a(3);
                        shutterButtonInfo2.m19227a("button_color_inside_none");
                    } else {
                        shutterButtonInfo2.m19226a(Util.m24352ao() ? 27 : 7);
                        shutterButtonInfo2.m19227a("button_color_inside_none");
                    }
                    ProfessionalCapMode.this.mCameraUIInterface.mo18091a(shutterButtonInfo2);
                }
            }
        });
        CameraLog.m12954a("ProfessionalCapMode", "onAfterSnapping X");
        return true;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void onShutterCallback(boolean z, boolean z2) throws Resources.NotFoundException {
        super.onShutterCallback(z, z2);
        if (z2) {
            if (!this.f15756j && this.mCameraInterface.mo10575i() && Long.parseLong(m16091m()) >= C1547C.NANOS_PER_SECOND) {
                if (!isSuperRawOpen()) {
                    this.mCameraInterface.mo10558c(Util.m24352ao() ? 7 : 5);
                    m16050b(0);
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
        CameraLog.m12954a("ProfessionalCapMode", "onCaptureCompleted, systemTime: " + System.currentTimeMillis());
    }

    @Override // com.oplus.camera.capmode.BaseMode, com.oplus.camera.p141e.OneCamera.PlatformImplementations.kt_3
    public void onCaptureFailed(CaptureRequest captureRequest, CameraRequestTag c2693c) {
        super.onCaptureFailed(captureRequest, c2693c);
        if (isRawOpen()) {
            this.f15755i = true;
        }
        if (isSuperRawOpen()) {
            this.f15754h = true;
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void onBeforePictureTaken(byte[] bArr, boolean z) {
        CameraLog.m12962c("ProfessionalCapMode", "onBeforePictureTaken");
        if (this.f15756j) {
            this.mCameraUIInterface.mo18092a(getShutterButtonInfo(), false);
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected boolean getNeedStoreRawPic() {
        return isSuperRawOpen();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void onAfterPictureTaken(byte[] bArr, boolean z) throws Resources.NotFoundException {
        CameraLog.m12954a("ProfessionalCapMode", "onAfterPictureTaken");
        if (!this.f15760n && isRawRequestTag()) {
            this.f15760n = true;
            if (!this.f15755i && !this.f15754h) {
                return;
            }
        }
        if (isSuperRawOpen()) {
            m16050b(0);
            Util.m24270a(this.f15716C, 0, (Animation.AnimationListener) null, 300L);
            if (!this.f15769w.isSelected()) {
                this.mCameraInterface.mo10492a(true, false);
                this.mCameraInterface.mo10563d(true);
            }
            this.mCameraUIInterface.mo18091a(getShutterButtonInfo());
            m16051b(0, true);
            if (m16115y()) {
                Util.m24270a(this.f15771y, 0, (Animation.AnimationListener) null, 300L);
            }
        } else if (m16059b(m16091m())) {
            MainShutterButtonInfo shutterButtonInfo = getShutterButtonInfo();
            if (1 != this.mCameraUIInterface.mo18265s() && !Util.m24352ao()) {
                shutterButtonInfo.m19226a(11);
            }
            this.mCameraUIInterface.mo18091a(shutterButtonInfo);
            m16050b(0);
            Util.m24270a(this.f15716C, 0, (Animation.AnimationListener) null, 300L);
            if (!this.f15769w.isSelected()) {
                this.mCameraInterface.mo10492a(true, false);
            }
            m16051b(0, true);
            if (m16115y()) {
                Util.m24270a(this.f15771y, 0, (Animation.AnimationListener) null, 300L);
            }
        }
        this.mCameraUIInterface.mo18200d(true, false);
        if (this.f15758l) {
            Util.m24270a(this.f15716C, 0, (Animation.AnimationListener) null, 300L);
            this.f15758l = false;
        }
        this.f15716C.setTouchState(true);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void cameraIdChanged(int OplusGLSurfaceView_13) {
        super.cameraIdChanged(OplusGLSurfaceView_13);
        final int iMo10543as = this.mCameraInterface.mo10543as();
        CameraLog.m12954a("ProfessionalCapMode", "cameraIdChanged, id_renamed: " + iMo10543as);
        if (this.f15718E != iMo10543as) {
            this.f15718E = iMo10543as;
            this.f15719F = true;
            this.mActivity.runOnUiThread(new Runnable() { // from class: com.oplus.camera.professional.v.9
                @Override // java.lang.Runnable
                public void run() {
                    if (ProfessionalCapMode.this.m15938E()) {
                        ProfessionalCapMode.this.f15769w.setVisibility(8);
                        ProfessionalCapMode.this.f15769w.setItemPressed(false);
                        ProfessionalCapMode.this.f15770x.m15832e();
                        if (ProfessionalCapMode.this.f15769w.isSelected()) {
                            ProfessionalCapMode.this.f15770x.m15832e();
                            ProfessionalCapMode.this.f15769w.m15381a();
                            return;
                        }
                        return;
                    }
                    ProfessionalCapMode.this.f15769w.setVisibility(0);
                    ProfessionalCapMode.this.f15770x.setVisibility(0);
                    ProfessionalCapMode.this.mCameraUIInterface.mo18282w(true);
                    ProfessionalCapMode.this.m16061c(iMo10543as);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: E */
    public boolean m15938E() {
        if (this.mPreferences != null) {
            return "camera_macro".equals(this.mPreferences.getString(CameraUIInterface.KEY_SWITCH_CAMERA, "camera_main"));
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: IntrinsicsJvm.kt_3 */
    public synchronized void m16061c(int OplusGLSurfaceView_13) {
        this.f15770x.m15829d();
        OplusCameraCharacteristics cameraInfo = getCameraInfo(OplusGLSurfaceView_13);
        this.f15770x.m15808a(cameraInfo.m13286u(), cameraInfo.m13287v(), cameraInfo.m13288w(), this.f15715B);
        this.f15770x.m15812a(isSuperRawOpen() ? 2000000000L : cameraInfo.m13289x(), cameraInfo.m13290y(), cameraInfo.m13258a(256), this.f15715B);
        this.f15770x.m15816a(cameraInfo.m13245B(), this.f15715B);
        this.f15770x.m15805a(cameraInfo.m13279n(), cameraInfo.m13278m(), this.f15715B);
        this.f15770x.m15807a(cameraInfo.m13281p(), cameraInfo.m13282q(), cameraInfo.m13283r(), this.f15715B);
        this.f15770x.m15832e();
        if (this.f15769w.isSelected()) {
            this.f15770x.m15834f(this.f15769w.getSelectedIndex());
        }
        this.f15770x.m15804a();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void setOrientation(int OplusGLSurfaceView_13) throws Resources.NotFoundException {
        RotateImageView rotateImageView = this.f15722I;
        if (rotateImageView != null) {
            rotateImageView.m18348a(OplusGLSurfaceView_13, true);
        }
        RotateImageView rotateImageView2 = this.f15771y;
        if (rotateImageView2 != null) {
            rotateImageView2.m18348a(OplusGLSurfaceView_13, true);
        }
        if (this.mOrientation == OplusGLSurfaceView_13) {
            return;
        }
        this.mOrientation = OplusGLSurfaceView_13;
        HistogramProcessorManager.PlatformImplementations.kt_3 aVar = this.f15714A;
        if (aVar != null) {
            aVar.f14815e = this.mOrientation;
        }
        HintManager c3130aMo18233k = this.mCameraUIInterface.mo18233k();
        if (c3130aMo18233k != null) {
            c3130aMo18233k.m18502g();
        }
        ValueAnimator valueAnimator = this.f15749aj;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        if (m15980Z() && this.f15741ab != 0) {
            this.f15741ab = 0;
        }
        m16068d(0);
        HistogramProcessorManager c2826p = this.f15772z;
        if (c2826p != null) {
            c2826p.m14843a(this.f15714A, false, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: F */
    public boolean m15940F() {
        return this.mOrientation % 180 == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: G */
    public boolean m15942G() {
        return 90 == this.mOrientation;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void onResume(boolean z) throws Resources.NotFoundException {
        CameraLog.m12954a("ProfessionalCapMode", "onResume");
        if (this.mPreferences != null) {
            this.f15756j = "on".equals(this.mPreferences.getString(CameraUIInterface.KEY_HIGH_RESOLUTION, this.f15717D.getString(R.string.camera_high_resolution_default_value)));
        }
        if (this.f15772z != null) {
            m16005a(false, false, true);
            this.f15772z.m14839a();
        }
        if (Util.m24508z(this.mActivity)) {
            PlatformImplementations.kt_3 aVar = this.f15716C;
            if (aVar != null) {
                aVar.setVisibility(0);
            }
            this.mCameraInterface.mo10563d(true);
            m16118a(1);
        }
        ListProfessionalModeBar listProfessionalModeBar = this.f15769w;
        if (listProfessionalModeBar != null) {
            listProfessionalModeBar.setBackgroundColor(0);
        }
        this.f15729P = false;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void onPause() throws Resources.NotFoundException {
        CameraLog.m12954a("ProfessionalCapMode", "onPause");
        this.mCameraUIInterface.mo18215g(0);
        this.mCameraUIInterface.mo18217g(false);
        if (m15980Z() && this.f15741ab != 0) {
            this.f15741ab = 0;
            m16073e(0);
        }
        PlatformImplementations.kt_3 aVar = this.f15716C;
        if (aVar != null) {
            aVar.setTouchState(false);
        }
        ValueAnimator valueAnimator = this.f15724K;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.f15724K = null;
        }
        this.f15758l = false;
        Handler handler = this.f15715B;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        PanelContainer c2898p = this.f15770x;
        if (c2898p != null) {
            c2898p.m15837h();
        }
        ListProfessionalModeBar listProfessionalModeBar = this.f15769w;
        if (listProfessionalModeBar != null) {
            listProfessionalModeBar.setBackgroundColor(0);
            this.f15769w.m15386a(true, false);
        }
        this.mCameraUIInterface.mo18200d(true, false);
        this.f15729P = false;
        this.f15730Q = true;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void onDestroy() {
        CameraLog.m12954a("ProfessionalCapMode", "onDestroy");
        PanelContainer c2898p = this.f15770x;
        if (c2898p != null) {
            c2898p.m15833f();
            this.f15770x = null;
            this.f15720G = false;
        }
        if (this.f15716C != null) {
            this.f15716C = null;
        }
        if (this.f15722I != null) {
            this.f15722I = null;
        }
        if (this.f15769w != null) {
            this.f15769w = null;
        }
        HistogramProcessorManager c2826p = this.f15772z;
        if (c2826p != null) {
            c2826p.m14849c();
            this.f15772z = null;
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

    /* renamed from: H */
    private void m15944H() {
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
        boolean z = CameraUIInterface.KEY_RAW_CONTROL.equals(str) && getSupportFunction(CameraUIInterface.KEY_RAW_CONTROL);
        boolean z2 = CameraUIInterface.KEY_SUPER_RAW_CONTROL.equals(str) && CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_PROFESSIONAL_SUPER_RAW);
        if ((z || z2) && getSupportFunction(CameraUIInterface.KEY_SWITCH_DUAL_CAMERA) && this.mPreferences != null) {
            return Util.m24443e(this.mPreferences.getString(CameraUIInterface.KEY_SWITCH_CAMERA, "camera_main"));
        }
        return super.isCameraSettingMenuOptionEnable(str);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onAfterStartPreview(boolean z) throws Resources.NotFoundException {
        CameraLog.m12959b("ProfessionalCapMode", "onAfterStartPreview");
        PlatformImplementations.kt_3 aVar = this.f15716C;
        if (aVar != null) {
            aVar.setTouchState(true);
        }
        if (m15938E()) {
            this.mCameraUIInterface.mo18166b(R.string.camera_macro_best_focus_distance_text, R.drawable.screen_hint_textview_bg, R.color.screen_hint_text_color, Integer.valueOf(CameraConfig.getConfigIntValue(ConfigDataBase.KEY_MACRO_BEST_FOCUS_DISTANCE)));
        }
        if (getSupportFunction(CameraUIInterface.KEY_PRO_HISTOGRAM)) {
            m16023aa();
        }
        m16110w();
        m15968T();
        m16099q();
        if (this.mCameraInterface != null && isSuperRawOpen()) {
            this.mCameraUIInterface.mo18107a(true, false);
        }
        super.onAfterStartPreview(z);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void onBeforePreview() throws NumberFormatException {
        CameraLog.m12954a("ProfessionalCapMode", "onBeforePreview");
        this.mActivity.runOnUiThread(new Runnable() { // from class: com.oplus.camera.professional.v.10
            @Override // java.lang.Runnable
            public void run() {
                if (ProfessionalCapMode.this.mOneCamera == null || ProfessionalCapMode.this.mOneCamera.mo13086e() == null || ProfessionalCapMode.this.mOneCamera.mo13086e().m13284s()) {
                    ProfessionalCapMode.this.m16002a(true, 4);
                } else {
                    if (4 == ProfessionalCapMode.this.f15769w.getSelectedIndex()) {
                        ProfessionalCapMode.this.mCameraInterface.mo10492a(true, true);
                        ProfessionalCapMode.this.mCameraInterface.mo10563d(true);
                        ProfessionalCapMode.this.f15770x.m15832e();
                        ProfessionalCapMode.this.f15769w.m15381a();
                        ProfessionalCapMode.this.mOneCamera.mo13105j(false);
                    }
                    ProfessionalCapMode.this.m16002a(false, 4);
                }
                if (ProfessionalCapMode.this.f15769w != null) {
                    ProfessionalCapMode.this.f15769w.m15386a(true, false);
                    if (ProfessionalCapMode.this.f15769w.isSelected()) {
                        ProfessionalCapMode.this.mCameraInterface.mo10479a((AnimatorListenerAdapter) null, false, false);
                    }
                }
            }
        });
        this.mOneCamera.mo13040a((CameraParameter.PreviewKey<CameraParameter.PreviewKey<Float>>) CameraParameter.ZOOM_RATIO, (CameraParameter.PreviewKey<Float>) Float.valueOf(this.mCameraInterface.mo10535ak()));
        if (getSupportFunction(CameraUIInterface.KEY_FOCUS_PEAKING)) {
            if (!Util.m24352ao()) {
                int iM24164A = Util.m24164A(this.mActivity);
                String[] strArrM24402b = Util.m24402b(Color.red(iM24164A), Color.green(iM24164A), Color.blue(iM24164A));
                if (strArrM24402b != null && strArrM24402b.length == 2) {
                    this.mOneCamera.mo13059a(strArrM24402b);
                }
            }
            this.mOneCamera.mo13056a(this.mPreferences.getString(CameraUIInterface.KEY_FOCUS_PEAKING, "off").equals("on"), false);
        }
        if (this.f15719F || this.mPreferences.getBoolean(CameraUIInterface.KEY_RESTORE_PROFESSIONAL_PARAMS, false)) {
            CameraLog.m12954a("ProfessionalCapMode", "onBeforePreview, initParamToAuto");
            m16055b(false);
            final String string = this.mPreferences.getString(CameraUIInterface.KEY_PARAMETER_SAVING, "off");
            if (!getSupportFunction(CameraUIInterface.KEY_PARAMETER_SAVING) || string.equals("off")) {
                return;
            }
            this.mActivity.runOnUiThread(new Runnable() { // from class: com.oplus.camera.professional.v.11
                @Override // java.lang.Runnable
                public void run() {
                    ProfessionalCapMode.this.m16003a(false, string);
                }
            });
            return;
        }
        if (this.mbCapModeInit) {
            m16095o();
        }
        m16078f(false);
        m15946I();
    }

    /* renamed from: I */
    private void m15946I() {
        if (this.mPreferences == null || this.mOneCamera == null) {
            CameraLog.m12959b("ProfessionalCapMode", "mPreferences or mOneCamera is null");
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
        String string = this.f15717D.getString(R.string.camera_exposure_time_default_value);
        String string2 = this.mPreferences.getString("pref_professional_exposure_time_key", string);
        return (TextUtils.isEmpty(string2) || !string2.equals(string)) ? "off" : super.getFlashMode();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        RotateImageView rotateImageView;
        if (view.getId() == R.id_renamed.professional_parameter_bottom_guide_entry && this.mCameraUIInterface != null && (rotateImageView = this.f15722I) != null && rotateImageView.getVisibility() == 0) {
            this.mCameraUIInterface.mo18156at();
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void hideViewWhileResume() {
        PlatformImplementations.kt_3 aVar = this.f15716C;
        if (aVar != null) {
            aVar.setVisibility(4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: J */
    public void m15947J() {
        PanelContainer c2898p;
        if (this.f15769w == null || (c2898p = this.f15770x) == null) {
            return;
        }
        c2898p.setPreference(4);
    }

    /* renamed from: K */
    private void m15950K() {
        PanelContainer c2898p;
        if (this.f15769w == null || (c2898p = this.f15770x) == null) {
            return;
        }
        c2898p.setPreference(5);
    }

    /* renamed from: L */
    private void m15952L() {
        PanelContainer c2898p;
        if (this.f15769w == null || (c2898p = this.f15770x) == null) {
            return;
        }
        c2898p.setPreference(1);
        this.f15770x.setPreference(2);
    }

    /* renamed from: M */
    private void m15954M() {
        PanelContainer c2898p;
        if (this.f15769w == null || (c2898p = this.f15770x) == null) {
            return;
        }
        c2898p.setPreference(3);
    }

    /* renamed from: N */
    private void m15955N() {
        ListProfessionalModeBar listProfessionalModeBar = this.f15769w;
        if (listProfessionalModeBar != null) {
            listProfessionalModeBar.setVisibility(8);
            this.f15769w.setItemPressed(false);
        }
        PanelContainer c2898p = this.f15770x;
        if (c2898p != null) {
            c2898p.setVisibility(4);
        }
    }

    /* renamed from: O */
    private void m15958O() {
        ListProfessionalModeBar listProfessionalModeBar = this.f15769w;
        if (listProfessionalModeBar != null) {
            listProfessionalModeBar.setVisibility(0);
            this.f15769w.setItemPressed(true);
        }
        PanelContainer c2898p = this.f15770x;
        if (c2898p != null) {
            c2898p.setVisibility(0);
        }
    }

    /* renamed from: P */
    private void m15960P() {
        PanelContainer c2898p = this.f15770x;
        if (c2898p != null) {
            c2898p.clearAnimation();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public void m16002a(boolean z, int OplusGLSurfaceView_13) {
        View viewM15380a;
        ListProfessionalModeBar listProfessionalModeBar = this.f15769w;
        if (listProfessionalModeBar == null || (viewM15380a = listProfessionalModeBar.m15380a(OplusGLSurfaceView_13)) == null) {
            return;
        }
        viewM15380a.setEnabled(z);
        if (viewM15380a instanceof RotateView) {
            ((RotateView) viewM15380a).setRotateViewClickable(z);
        }
        this.f15769w.getAdapter().m15373b(viewM15380a, z, true);
    }

    @Override // com.oplus.camera.professional.ListProfessionalModeBar.OnItemClickListener
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo15392a(View view, View view2, long OplusGLSurfaceView_15) throws NumberFormatException {
        if (this.mCameraInterface.mo10445A()) {
            return;
        }
        int iM15379a = this.f15769w.m15379a(view2);
        boolean z = 4 == m16128f();
        if (iM15379a == 0) {
            m16055b(true);
            m16118a(1);
            m15991a(iM15379a, this.f15769w.isSelected());
            return;
        }
        if (ListProfessionalModeBar.ModePressState.NO_PRESSED == this.f15769w.getModePressState() && this.f15769w.isSelected()) {
            onBackPressed();
            m15991a(iM15379a, false);
            return;
        }
        if (!m16127e() && !z) {
            this.mCameraInterface.mo10563d(false);
            this.mCameraInterface.mo10479a((AnimatorListenerAdapter) null, true, true);
        }
        this.mCameraUIInterface.mo18024B(false);
        if (this.mCameraUIInterface.mo18059T()) {
            this.mCameraUIInterface.mo18284x(false);
        }
        m15960P();
        CameraLog.m12967f("ProfessionalCapMode", "onItemClick, index: " + iM15379a + ", id_renamed: " + OplusGLSurfaceView_15);
        m15991a(iM15379a, true);
        if (2 == iM15379a) {
            this.f15762p = isSuperRawOpen();
        }
        if (z) {
            this.mCameraUIInterface.mo18215g(4);
        }
        this.f15770x.m15811a(iM15379a, true);
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    private void m16076e(boolean z) {
        String string = this.mPreferences.getString("pref_professional_whitebalance_key", this.f15717D.getString(R.string.camera_whitebalance_default_value));
        if (this.f15717D.getString(R.string.camera_whitebalance_default_value).equals(string)) {
            this.mOneCamera.mo13028a(-1, z);
        }
        if (m16123a(string, this.f15770x.m15824c(5))) {
            try {
                this.mOneCamera.mo13028a(Integer.parseInt(string), z);
            } catch (NumberFormatException unused) {
                this.mOneCamera.mo13103i(z);
            }
        } else {
            this.mOneCamera.mo13103i(z);
        }
        CameraLog.m12954a("ProfessionalCapMode", "setWhiteBalance, whiteBalance: " + string);
        m16118a(8);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m16121a(boolean z) {
        this.mOneCamera.mo13103i(z);
        m16118a(8);
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    private void m16075e(String str) {
        m16001a(str, true);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m16001a(String str, boolean z) {
        if (str == null) {
            str = this.mPreferences.getString("pref_professional_iso_key", this.f15717D.getString(R.string.camera_iso_default_value));
        }
        if (!this.mPreferences.getString("pref_professional_iso_key", this.f15717D.getString(R.string.camera_iso_default_value)).equals(str)) {
            SharedPreferences.Editor editorEdit = this.mPreferences.edit();
            editorEdit.putString("pref_professional_iso_key", ProfessionalUtil.m16135a(this.mActivity, 1));
            editorEdit.apply();
        }
        if (this.f15717D.getString(R.string.camera_iso_default_value).equals(str)) {
            this.mOneCamera.mo13065b(-1, z);
        } else {
            m15974W();
            this.mOneCamera.mo13128r();
            this.mOneCamera.mo13065b(Integer.parseInt(str), z);
        }
        CameraLog.m12954a("ProfessionalCapMode", "setISOValue, iso: " + str);
        m16118a(7);
        m16118a(8);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m16120a(String str) {
        if (str == null) {
            str = this.mPreferences.getString("pref_professional_focus_mode_key", this.mActivity.getString(R.string.camera_focus_mode_default_value));
        }
        CameraLog.m12954a("ProfessionalCapMode", "setFocusValue, focusValue: " + str);
        if (this.mActivity.getString(R.string.camera_focus_mode_default_value).equals(str)) {
            return;
        }
        this.f15715B.removeMessages(2);
        Message messageObtain = Message.obtain();
        messageObtain.what = 2;
        this.f15715B.sendMessage(messageObtain);
        if (this.mOneCamera != null) {
            if (this.mCameraInterface.mo10596z()) {
                this.mCameraInterface.mo10556b(false, false);
            }
            this.mOneCamera.mo13023a(Float.parseFloat(str), true);
        }
        if (this.f15756j) {
            m16080g(false);
        }
        m16118a(8);
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public int m16125c() {
        return Integer.parseInt(this.mPreferences.getString("pref_professional_exposure_compensation_key", this.f15717D.getString(R.string.camera_exposure_compensation_default_value)));
    }

    /* renamed from: Q */
    private void m15962Q() throws NumberFormatException {
        m16078f(true);
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    private void m16078f(boolean z) throws NumberFormatException {
        String string = this.mPreferences.getString("pref_professional_exposure_time_key", this.f15717D.getString(R.string.camera_exposure_time_default_value));
        long jLongValue = Long.valueOf(this.f15717D.getString(R.string.camera_exposure_time_default_value)).longValue();
        long OplusGLSurfaceView_15 = Long.parseLong(string);
        if (OplusGLSurfaceView_15 != jLongValue) {
            m15974W();
        }
        if (this.mbFrontCamera) {
            this.mOneCamera.mo13031a(jLongValue, z);
        } else {
            this.mOneCamera.mo13031a(OplusGLSurfaceView_15, z);
        }
        m16118a(5);
        m16118a(7);
        m16118a(8);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private void m16054b(final String str, boolean z) {
        final Boolean boolValueOf = Boolean.valueOf(z);
        CameraLog.m12954a("ProfessionalCapMode", "setFlashModeMenuEnable, exposureTime: " + str + ", mDisPlayFlashIcon: " + boolValueOf);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            if (Integer.parseInt(str) == 0) {
                if (this.mCameraUIInterface != null) {
                    this.mCameraUIInterface.mo18171b(CameraUIInterface.KEY_FLASH_MODE, (String) null);
                    m16004a(true, z);
                }
            } else if (this.mCameraUIInterface != null) {
                m16004a(false, z);
                this.mCameraUIInterface.mo18099a(CameraUIInterface.KEY_FLASH_MODE, "off");
            }
        } catch (Exception COUIBaseListPopupWindow_8) {
            COUIBaseListPopupWindow_8.printStackTrace();
            if (this.mActivity != null) {
                this.mActivity.runOnUiThread(new Runnable() { // from class: com.oplus.camera.professional.v.13
                    @Override // java.lang.Runnable
                    public void run() {
                        if (Integer.parseInt(str) == 0) {
                            if (ProfessionalCapMode.this.mCameraUIInterface != null) {
                                ProfessionalCapMode.this.m16004a(true, boolValueOf.booleanValue());
                                ProfessionalCapMode.this.mCameraUIInterface.mo18171b(CameraUIInterface.KEY_FLASH_MODE, (String) null);
                                return;
                            }
                            return;
                        }
                        if (ProfessionalCapMode.this.mCameraUIInterface != null) {
                            ProfessionalCapMode.this.m16004a(false, boolValueOf.booleanValue());
                            ProfessionalCapMode.this.mCameraUIInterface.mo18099a(CameraUIInterface.KEY_FLASH_MODE, "off");
                        }
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public void m16004a(boolean z, boolean z2) {
        if (z2) {
            CameraLog.m12954a("ProfessionalCapMode", "showOrHideFlashIcon, enable: " + z + ", isOpenFlash: " + isOpenFlash());
            if (z) {
                displayScreenHintIconInSwitchOn();
            } else {
                this.mCameraUIInterface.mo18108a(false, true, false);
            }
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) throws Resources.NotFoundException, NumberFormatException {
        CameraLog.m12954a("ProfessionalCapMode", "onSharedPreferenceChanged, key: " + str);
        if (CameraUIInterface.KEY_PHOTO_RATIO.equals(str) && !Util.m24495t()) {
            this.f15721H = "square".equals(sharedPreferences.getString(CameraUIInterface.KEY_PHOTO_RATIO, null));
            this.f15745af = Util.m24184L();
        }
        if ("pref_professional_whitebalance_key".equals(str)) {
            m16076e(true);
            return;
        }
        if ("pref_professional_iso_key".equals(str)) {
            if (!Camera.f10610l) {
                this.mOneCamera.mo13069b(getFlashMode());
            } else {
                this.mOneCamera.mo13069b("off");
            }
            m16075e((String) null);
            return;
        }
        if ("pref_professional_exposure_compensation_key".equals(str)) {
            this.mOneCamera.mo13032a((CaptureRequest.Key<CaptureRequest.Key>) CaptureRequest.CONTROL_AE_EXPOSURE_COMPENSATION, (CaptureRequest.Key) Integer.valueOf(m16125c()));
            this.mOneCamera.mo13035a((OneCamera.IntrinsicsJvm.kt_3) null);
            m15932B();
            return;
        }
        if ("pref_professional_exposure_time_key".equals(str)) {
            if (!Camera.f10610l) {
                this.mOneCamera.mo13069b(getFlashMode());
            } else {
                this.mOneCamera.mo13069b("off");
            }
            m15962Q();
            long jM16092n = m16092n();
            if (this.f15769w.isSelected() && this.f15762p && jM16092n >= 500000000 && isSuperRawOpen()) {
                this.f15762p = false;
                this.mCameraUIInterface.mo18070a(R.string.camera_raw_control_hint_super_long_exposure, -1, true, false, false);
                return;
            }
            return;
        }
        if (CameraUIInterface.KEY_HIGH_RESOLUTION.equals(str)) {
            m15972V();
        } else if ("pref_professional_focus_mode_key".equals(str)) {
            this.f15770x.m15838h(4);
            if (!this.f15770x.m15836g(4)) {
                m16120a((String) null);
                this.f15764r = true;
            } else {
                if (this.mOneCamera.mo13122p() == 0) {
                    this.f15764r = false;
                }
                if (4 != this.mOneCamera.mo13122p() || this.f15764r) {
                    this.mOneCamera.mo13029a(4, AEAFHelp.m11154b(), AEAFHelp.m11154b(), true);
                    this.mOneCamera.mo13035a((OneCamera.IntrinsicsJvm.kt_3) null);
                }
                if (4 == this.mOneCamera.mo13122p() || 1 == this.mOneCamera.mo13122p()) {
                    m15947J();
                    this.f15770x.setPanelsBarAuto(4);
                }
            }
            m15966S();
            m15932B();
        } else if (CameraUIInterface.KEY_FLASH_MODE.equals(str)) {
            if (!this.mActivity.getString(R.string.camera_flash_mode_default_value).equals(sharedPreferences.getString(CameraUIInterface.KEY_FLASH_MODE, this.mActivity.getString(R.string.camera_flash_mode_default_value)))) {
                m15970U();
                m15932B();
            }
            m16080g(true);
        } else {
            if (CameraUIInterface.KEY_RAW_CONTROL.equals(str) && getSupportFunction(CameraUIInterface.KEY_RAW_CONTROL)) {
                m15963R();
                return;
            }
            if (CameraUIInterface.KEY_SUPER_RAW_CONTROL.equals(str) && getSupportFunction(CameraUIInterface.KEY_SUPER_RAW_CONTROL)) {
                m15963R();
                return;
            }
            if (CameraUIInterface.KEY_PARAMETER_SAVING.equals(str)) {
                boolean z = this.f15763q;
                m16117z();
                if (!z && this.f15763q) {
                    m16003a(true, "off");
                }
                m16003a(false, this.mPreferences.getString(CameraUIInterface.KEY_PARAMETER_SAVING, "off"));
                m15929A();
                if (this.f15769w.isSelected()) {
                    if (this.f15770x.mo13582b(this.f15769w.getSelectedIndex())) {
                        return;
                    }
                    onBackPressed();
                    return;
                }
                return;
            }
            if (CameraUIInterface.KEY_PRO_HISTOGRAM.equals(str)) {
                m16056b(false, true);
                if (this.mCameraUIInterface != null) {
                    if (m15980Z()) {
                        this.f15734U = true;
                        if (270 != this.mOrientation) {
                            this.mCameraUIInterface.mo18281w(150);
                        }
                        this.mCameraUIInterface.mo18070a(R.string.hint_histogram_on, -1, true, true, false);
                        return;
                    }
                    this.f15734U = false;
                    this.mCameraUIInterface.mo18070a(R.string.hint_histogram_off, -1, true, true, false);
                    this.mCameraUIInterface.mo18281w(0);
                    return;
                }
                return;
            }
            if (CameraUIInterface.KEY_SUB_SETTING.equals(str)) {
                m16070d(true);
                m16056b(true, false);
            } else {
                if (CameraUIInterface.KEY_FOCUS_PEAKING.equals(str)) {
                    boolean zEquals = this.mPreferences.getString(CameraUIInterface.KEY_FOCUS_PEAKING, "off").equals("on");
                    if (this.mCameraUIInterface != null) {
                        if (zEquals) {
                            this.mCameraUIInterface.mo18070a(R.string.hint_focus_peaking_on, -1, true, true, false);
                        } else {
                            this.mCameraUIInterface.mo18070a(R.string.hint_focus_peaking_off, -1, true, true, false);
                        }
                    }
                    if (this.mOneCamera != null) {
                        this.mOneCamera.mo13056a(zEquals, true);
                        return;
                    }
                    return;
                }
                if (this.mCameraUIInterface.mo18233k().m18490a(CameraUIInterface.KEY_PHOTO_RATIO) || this.mCameraUIInterface.mo18233k().m18490a(CameraUIInterface.KEY_PHOTO_RATIO_FROM_OTHER_APP)) {
                    String string = this.mPreferences.getString(CameraUIInterface.KEY_PHOTO_RATIO, this.mActivity.getString(R.string.camera_photo_ratio_default_value));
                    if ("square".equals(string)) {
                        this.f15744ae = Util.m24184L() + Util.m24186N();
                    } else {
                        this.f15744ae = Util.m24186N();
                    }
                    if ("square".equals(string) || "square".equals(this.f15746ag)) {
                        this.f15735V = true;
                    } else {
                        this.f15735V = false;
                    }
                }
            }
        }
        super.onSharedPreferenceChanged(sharedPreferences, str);
        if (CameraUIInterface.KEY_SWITCH_CAMERA.equals(str)) {
            m15968T();
            m15944H();
        }
    }

    /* renamed from: R */
    private void m15963R() throws Resources.NotFoundException, NumberFormatException {
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
                this.f15770x.m15823b(false);
                m16055b(true);
                this.f15770x.m15823b(true);
                if (!this.f15762p) {
                    this.f15762p = true;
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
            this.f15770x.m15814a(getCameraInfo(this.f15718E), isSuperRawOpen() ? 2000000000L : getCameraInfo(this.f15718E).m13289x());
            this.f15770x.m15804a();
        } else if ("on".equals(this.mPreferences.getString(CameraUIInterface.KEY_RAW_CONTROL, "off"))) {
            this.mCameraUIInterface.mo18070a(R.string.camera_raw_control_hint_on, -1, true, false, false);
            this.mOneCamera.mo13040a((CameraParameter.PreviewKey<CameraParameter.PreviewKey<String>>) CameraParameter.RAW_CONTROL, (CameraParameter.PreviewKey<String>) "raw");
        } else {
            this.mCameraUIInterface.mo18070a(R.string.camera_raw_control_hint_off, -1, true, false, false);
            this.mOneCamera.mo13040a((CameraParameter.PreviewKey<CameraParameter.PreviewKey<String>>) CameraParameter.RAW_CONTROL, (CameraParameter.PreviewKey<String>) "none");
        }
        if (this.mCameraInterface != null) {
            if (getSupportFunction(CameraUIInterface.KEY_ZOOM) && !this.f15769w.isSelected()) {
                this.mCameraInterface.mo10492a(true, false);
                this.mCameraInterface.mo10563d(true);
            } else {
                this.mCameraInterface.mo10479a((AnimatorListenerAdapter) null, true, false);
            }
            if (m16126d()) {
                this.mCameraInterface.mo10506aH();
            }
        }
        this.mOneCamera.mo13035a((OneCamera.IntrinsicsJvm.kt_3) null);
    }

    /* renamed from: S */
    private void m15966S() {
        if (!getSupportFunction(CameraUIInterface.KEY_FOCUS_PEAKING) || PreferenceManager.m3981a(this.mActivity).getBoolean("focus_peaking_clicked", false) || this.f15770x == null || this.mPreferences == null) {
            return;
        }
        boolean zM15836g = this.f15770x.m15836g(4);
        if (zM15836g != this.mPreferences.getString(CameraUIInterface.KEY_FOCUS_PEAKING, "off").equals("on")) {
            return;
        }
        this.mPreferences.edit().putString(CameraUIInterface.KEY_FOCUS_PEAKING, zM15836g ? "off" : "on").apply();
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

    /* renamed from: T */
    private void m15968T() throws Resources.NotFoundException {
        if (this.mPreferences == null) {
            return;
        }
        String string = this.mPreferences.getString("pref_professional_exposure_time_key", this.f15717D.getString(R.string.camera_exposure_time_default_value));
        String string2 = this.mPreferences.getString("pref_professional_iso_key", this.f15717D.getString(R.string.camera_iso_default_value));
        if (getSupportFunction(CameraUIInterface.KEY_SWITCH_CAMERA) && getSupportFunction(CameraUIInterface.KEY_FLASH_MODE) && this.f15717D.getString(R.string.camera_exposure_time_default_value).equals(string) && this.f15717D.getString(R.string.camera_iso_default_value).equals(string2)) {
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

    /* renamed from: U */
    private void m15970U() {
        View viewM15380a;
        View viewM15380a2;
        if ("off".equals(this.mPreferences.getString(CameraUIInterface.KEY_FLASH_MODE, this.mActivity.getString(R.string.camera_flash_mode_default_value)))) {
            return;
        }
        String string = this.mPreferences.getString("pref_professional_exposure_time_key", this.f15717D.getString(R.string.camera_exposure_time_default_value));
        String string2 = this.mPreferences.getString("pref_professional_iso_key", this.f15717D.getString(R.string.camera_iso_default_value));
        if (!this.f15717D.getString(R.string.camera_exposure_time_default_value).equals(string)) {
            this.f15770x.setAuto(2);
            if (this.f15769w.isSelected() && (viewM15380a2 = this.f15769w.m15380a(2)) != null) {
                this.f15769w.getAdapter().m15367a(viewM15380a2, 0, true);
            }
        }
        if (this.f15717D.getString(R.string.camera_iso_default_value).equals(string2)) {
            return;
        }
        this.f15770x.setAuto(1);
        if (!this.f15769w.isSelected() || (viewM15380a = this.f15769w.m15380a(1)) == null) {
            return;
        }
        this.f15769w.getAdapter().m15367a(viewM15380a, 0, true);
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    private void m16080g(boolean z) {
        boolean zEquals = z ? true ^ "off".equals(this.mPreferences.getString(CameraUIInterface.KEY_FLASH_MODE, this.mActivity.getString(R.string.camera_flash_mode_default_value))) : true;
        if (this.f15756j && zEquals) {
            SharedPreferences.Editor editorEdit = this.mPreferences.edit();
            editorEdit.putString(CameraUIInterface.KEY_HIGH_RESOLUTION, "off");
            editorEdit.apply();
            this.mCameraUIInterface.mo18171b(CameraUIInterface.KEY_HIGH_RESOLUTION, "off");
        }
    }

    /* renamed from: V */
    private void m15972V() {
        CameraLog.m12954a("ProfessionalCapMode", "updateHighResolutionMode");
        this.f15756j = "on".equals(this.mPreferences.getString(CameraUIInterface.KEY_HIGH_RESOLUTION, this.f15717D.getString(R.string.camera_high_resolution_default_value)));
        MainShutterButtonInfo c3200b = new MainShutterButtonInfo(1);
        c3200b.m19227a("button_color_inside_none");
        this.mOneCamera.mo13115m(getZSLMode());
        if (this.f15756j) {
            m15974W();
            m15976X();
            this.f15770x.setAuto(1);
            this.f15770x.setAuto(2);
            this.f15770x.setAuto(5);
            this.f15770x.setAuto(4);
            PanelContainer c2898p = this.f15770x;
            c2898p.m15810a(3, "pref_professional_exposure_compensation_key", c2898p.m15824c(3).indexOf(ProfessionalUtil.m16135a(this.mActivity, 3)));
            m16118a(1);
            this.mCameraUIInterface.mo18091a(c3200b);
            if (this.mOneCamera.mo13122p() == 0) {
                this.mOneCamera.mo13029a(getDefaultAFMode(), AEAFHelp.m11154b(), AEAFHelp.m11154b(), true);
                this.mOneCamera.mo13032a((CaptureRequest.Key<CaptureRequest.Key>) CaptureRequest.CONTROL_AE_EXPOSURE_COMPENSATION, (CaptureRequest.Key) Integer.valueOf(AEAFHelp.m11155c()));
                this.mOneCamera.mo13035a((OneCamera.IntrinsicsJvm.kt_3) null);
            }
            if (1 == this.mOneCamera.mo13122p() || 4 == this.mOneCamera.mo13122p()) {
                m15947J();
                this.f15770x.setPanelsBarAuto(4);
            }
            this.mCameraUIInterface.mo18070a(R.string.camera_toast_high_resolution_on, -1, true, false, false);
            return;
        }
        this.mCameraUIInterface.mo18070a(R.string.camera_toast_high_resolution_off, -1, true, false, false);
        this.mCameraUIInterface.mo18091a(c3200b);
    }

    /* renamed from: W */
    private void m15974W() {
        if ("off".equals(this.mPreferences.getString(CameraUIInterface.KEY_FLASH_MODE, this.mActivity.getString(R.string.camera_flash_mode_default_value)))) {
            return;
        }
        SharedPreferences.Editor editorEdit = this.mPreferences.edit();
        editorEdit.putString(CameraUIInterface.KEY_FLASH_MODE, "off");
        editorEdit.apply();
        this.mActivity.runOnUiThread(new Runnable() { // from class: com.oplus.camera.professional.v.14
            @Override // java.lang.Runnable
            public void run() {
                if (ProfessionalCapMode.this.mbPaused) {
                    return;
                }
                ProfessionalCapMode.this.mCameraUIInterface.mo18211f(CameraUIInterface.KEY_FLASH_MODE);
            }
        });
    }

    /* renamed from: X */
    private void m15976X() {
        if ("off".equals(this.mPreferences.getString(CameraUIInterface.KEY_RAW, "off"))) {
            return;
        }
        SharedPreferences.Editor editorEdit = this.mPreferences.edit();
        editorEdit.putString(CameraUIInterface.KEY_RAW, "off");
        editorEdit.apply();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean isNeedProgressBarInCapture() {
        String string = this.mPreferences.getString("pref_professional_exposure_time_key", this.f15717D.getString(R.string.camera_exposure_time_default_value));
        return TextUtils.isEmpty(string) || Long.valueOf(string).longValue() >= C1547C.NANOS_PER_SECOND;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public DcsMsgData onGetBeforeCaptureMsgCommonData(DcsMsgData dcsMsgData) {
        String string;
        CaptureMsgData captureMsgData = (dcsMsgData == null || !(dcsMsgData instanceof CaptureMsgData)) ? null : (CaptureMsgData) dcsMsgData;
        if (captureMsgData == null) {
            return null;
        }
        String strM15831e = this.f15770x.m15831e(5);
        String strM15801a = this.f15770x.m15801a(Integer.valueOf(this.f15770x.m15831e(3)).intValue(), this.mOneCamera.mo13086e().m13283r());
        String strM15831e2 = this.f15770x.m15831e(2);
        String strM15831e3 = this.f15770x.m15831e(1);
        String focusValue = this.f15770x.getFocusValue();
        if (TextUtils.equals(strM15831e2, this.mActivity.getString(R.string.camera_exposure_time_default_value))) {
            strM15831e2 = "auto";
        }
        captureMsgData.mProfessionWbValue = strM15831e;
        captureMsgData.mProfessionEvValue = strM15801a;
        captureMsgData.mProfessionExpValue = strM15831e2;
        captureMsgData.mProfessionISOValue = strM15831e3;
        captureMsgData.mProfessionFocusValue = focusValue;
        captureMsgData.mProfessionHighResolution = String.valueOf(this.f15756j);
        if (this.mPreferences != null) {
            if (getSupportFunction(CameraUIInterface.KEY_SUPER_RAW_CONTROL)) {
                string = this.mPreferences.getString(CameraUIInterface.KEY_SUPER_RAW_CONTROL, "off");
            } else {
                string = this.mPreferences.getString(CameraUIInterface.KEY_RAW_CONTROL, "off");
            }
            if (getSupportFunction(CameraUIInterface.KEY_PARAMETER_SAVING)) {
                captureMsgData.mProfessionIsPresentParameter = ProfessionalMsgData.buildParameterSaving(this.mPreferences.getString(CameraUIInterface.KEY_PARAMETER_SAVING, "off"));
            }
            if (getSupportFunction(CameraUIInterface.KEY_PRO_HISTOGRAM)) {
                captureMsgData.mProfessionIsHistogram = this.mPreferences.getString(CameraUIInterface.KEY_PRO_HISTOGRAM, "off");
            }
            if (getSupportFunction(CameraUIInterface.KEY_FOCUS_PEAKING)) {
                captureMsgData.mProfessionIsFocusPeaking = this.mPreferences.getString(CameraUIInterface.KEY_FOCUS_PEAKING, "off");
            }
        } else {
            string = "off";
        }
        captureMsgData.mProfessionRawControl = string;
        String strBuildPhotoFormat = ProfessionalMsgData.buildPhotoFormat(string);
        if (TextUtils.isEmpty(strBuildPhotoFormat) || CaptureMsgData.TYPE_PHOTO_FORMAT_JPEG.equals(strBuildPhotoFormat)) {
            strBuildPhotoFormat = captureMsgData.mPhotoFormat;
        }
        captureMsgData.mPhotoFormat = strBuildPhotoFormat;
        captureMsgData.mProfessionCameraId = this.mPreferences != null ? this.mPreferences.getString(CameraUIInterface.KEY_SWITCH_CAMERA, "camera_main") : "camera_main";
        return captureMsgData;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void changeModeAllViewWhenAnimation(int OplusGLSurfaceView_13, boolean z) {
        super.changeModeAllViewWhenAnimation(OplusGLSurfaceView_13, z);
        if (OplusGLSurfaceView_13 == 3) {
            this.f15716C.setTouchState((z && this.mbInCapturing) ? false : z);
            int i2 = z ? 0 : 8;
            Util.m24270a(this.f15716C, i2, (Animation.AnimationListener) null, 300L);
            if (m16115y()) {
                Util.m24270a(this.f15771y, i2, (Animation.AnimationListener) null, 300L);
                return;
            }
            return;
        }
        if (OplusGLSurfaceView_13 != 5) {
            if (OplusGLSurfaceView_13 == 17 && z && m15938E()) {
                this.f15715B.sendEmptyMessageDelayed(6, 3000L);
                return;
            }
            return;
        }
        if (z) {
            ListProfessionalModeBar listProfessionalModeBar = this.f15769w;
            if (listProfessionalModeBar != null) {
                listProfessionalModeBar.setVisibility(0);
                return;
            }
            return;
        }
        if (this.f15769w != null) {
            m15955N();
        }
    }

    /* compiled from: ProfessionalCapMode.java */
    /* renamed from: com.oplus.camera.professional.v$PlatformImplementations.kt_3 */
    public class PlatformImplementations.kt_3 extends RelativeLayout {

        /* renamed from: IntrinsicsJvm.kt_4 */
        private boolean f15809b;

        public PlatformImplementations.kt_3(Context context) {
            super(context);
            this.f15809b = true;
        }

        public void setTouchState(boolean z) {
            this.f15809b = z;
        }

        @Override // android.view.ViewGroup, android.view.View
        public boolean dispatchTouchEvent(MotionEvent motionEvent) {
            if (ProfessionalCapMode.this.mbCapModeInit && this.f15809b && ProfessionalCapMode.this.mCameraInterface != null && !ProfessionalCapMode.this.f15757k) {
                if (ProfessionalCapMode.this.mCameraInterface.mo10447C()) {
                    MotionEvent motionEventObtain = MotionEvent.obtain(motionEvent);
                    motionEventObtain.setAction(3);
                    super.dispatchTouchEvent(motionEventObtain);
                    return true;
                }
                return super.dispatchTouchEvent(motionEvent);
            }
            if (this.f15809b) {
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
    private void m15991a(int OplusGLSurfaceView_13, boolean z) {
        MenuClickMsgData menuClickMsgData = new MenuClickMsgData(this.mActivity);
        menuClickMsgData.buildEvent(false);
        if (OplusGLSurfaceView_13 == 0) {
            menuClickMsgData.mFuncKeyId = 81;
        } else if (OplusGLSurfaceView_13 == 1) {
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
    public void m15990a(int OplusGLSurfaceView_13, String str, boolean z) {
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

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: Y */
    public void m15978Y() {
        MenuClickMsgData menuClickMsgData = new MenuClickMsgData(this.mActivity);
        menuClickMsgData.buildEvent(true);
        menuClickMsgData.mFuncKeyId = 77;
        menuClickMsgData.mItem = ProfessionalMsgData.buildParameterSaving(this.mPreferences.getString(CameraUIInterface.KEY_PARAMETER_SAVING, "off"));
        menuClickMsgData.mItemValue = "save";
        menuClickMsgData.mCaptureMode = getCameraMode();
        menuClickMsgData.mCameraId = this.mCameraInterface.mo10547aw();
        menuClickMsgData.mOrientation = this.mOrientation;
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
        zoomConfigure.m11316K(isRawOpen());
        return zoomConfigure;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected boolean isModeBarSelected() {
        return this.f15769w.isSelected();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean isSubMenuEnable() {
        return getSupportFunction(CameraUIInterface.KEY_SUB_SETTING);
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public boolean m16126d() {
        return CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_RAW_ZOOM_MUTEX_SUPPORT);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m15989a(final int OplusGLSurfaceView_13, final String str) {
        if (this.mActivity != null) {
            this.mActivity.runOnUiThread(new Runnable() { // from class: com.oplus.camera.professional.v.16
                @Override // java.lang.Runnable
                public void run() {
                    if (str == null || ProfessionalCapMode.this.f15769w == null || str.equals(ProfessionalCapMode.this.f15769w.m15388b(OplusGLSurfaceView_13))) {
                        return;
                    }
                    ProfessionalCapMode.this.f15769w.m15382a(OplusGLSurfaceView_13, str);
                }
            });
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean isBottomGuideEntryViewShown() {
        RotateImageView rotateImageView = this.f15722I;
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
        this.f15729P = true;
        m15955N();
        RotateImageView rotateImageView = this.f15771y;
        if (rotateImageView != null) {
            rotateImageView.setVisibility(4);
        }
        m16070d(false);
        m16056b(false, false);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onMoreModeHidden(int OplusGLSurfaceView_13) throws Resources.NotFoundException {
        super.onMoreModeHidden(OplusGLSurfaceView_13);
        boolean zMo10450F = this.mCameraInterface.mo10450F();
        this.f15729P = zMo10450F;
        if (!zMo10450F) {
            m15958O();
        }
        if (this.f15771y != null && m16115y() && !zMo10450F) {
            this.f15771y.setVisibility(0);
        }
        m16070d(false);
        m16056b(false, false);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean isShowProPanelMenu() {
        ListProfessionalModeBar listProfessionalModeBar = this.f15769w;
        if (listProfessionalModeBar != null) {
            return listProfessionalModeBar.isSelected();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m16051b(int OplusGLSurfaceView_13, boolean z) {
        if (isPanelMode()) {
            this.mCameraUIInterface.mo18077a(OplusGLSurfaceView_13, z);
        } else {
            this.mCameraUIInterface.mo18068a(OplusGLSurfaceView_13, z ? 1 : 0);
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean isShowZoomMenu() {
        return !m16122a();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean isAutoFocus() {
        return TextUtils.equals(this.mPreferences.getString("pref_professional_focus_mode_key", this.mActivity.getString(R.string.camera_focus_mode_default_value)), this.mActivity.getString(R.string.camera_focus_mode_default_value));
    }

    /* renamed from: Z */
    private boolean m15980Z() {
        return (this.mPreferences == null || !this.mPreferences.getString(CameraUIInterface.KEY_PRO_HISTOGRAM, "off").equals("on") || this.mPreferences.getString(CameraUIInterface.KEY_SUB_SETTING, "off").equals("on") || this.f15729P || !this.f15730Q) ? false : true;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean isHistogramOpen() {
        return getSupportFunction(CameraUIInterface.KEY_PRO_HISTOGRAM) && m15980Z();
    }

    /* renamed from: aa */
    private void m16023aa() throws Resources.NotFoundException {
        if (this.f15751al != getCurrentScreenMode()) {
            this.f15741ab = 0;
            this.f15751al = getCurrentScreenMode();
        }
        m16073e(this.f15741ab);
        if (this.f15772z == null) {
            this.f15772z = new HistogramProcessorManager(this.mActivity, this.mCameraRootView, this.f15714A);
            this.f15772z.m14840a(R.id_renamed.professional_mode_histogram);
        } else if (m15942G() && this.f15735V && Util.m24495t()) {
            this.f15735V = false;
            this.f15772z.m14839a();
            this.f15772z.m14844a(this.f15714A, false, false, 0L);
        } else {
            this.f15772z.m14843a(this.f15714A, m15940F(), m15942G());
        }
        Size previewSize = getPreviewSize(this.mOneCamera.mo13086e());
        this.f15772z.m14841a(HistogramProcessorManager.m14819a(previewSize.getWidth(), previewSize.getHeight()));
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    private void m16068d(int OplusGLSurfaceView_13) throws Resources.NotFoundException {
        if (this.f15714A == null) {
            this.f15714A = new HistogramProcessorManager.PlatformImplementations.kt_3();
            this.f15714A.f14811a = 10;
        }
        BaseScreenMode currentScreenMode = getCurrentScreenMode();
        int iM16104t = m16104t();
        CameraLog.m12954a("ProfessionalCapMode", "updateHistogramLayoutConfigs, previewMarginTop: " + iM16104t);
        if (currentScreenMode != null) {
            currentScreenMode.mo16501a(this.f15714A, iM16104t, this.mOrientation);
            return;
        }
        Resources resources = this.mActivity.getResources();
        int dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.professional_histogram_margin_top);
        int dimensionPixelSize2 = resources.getDimensionPixelSize(R.dimen.professional_histogram_margin_start);
        int dimensionPixelSize3 = resources.getDimensionPixelSize(R.dimen.histogram_graph_view_width);
        int dimensionPixelSize4 = resources.getDimensionPixelSize(R.dimen.histogram_graph_view_height);
        int i2 = dimensionPixelSize + OplusGLSurfaceView_13;
        if (this.mOrientation % 180 == 0) {
            HistogramProcessorManager.PlatformImplementations.kt_3 aVar = this.f15714A;
            aVar.f14812b = iM16104t + i2;
            aVar.f14814d = dimensionPixelSize2;
            aVar.f14815e = this.mOrientation;
            return;
        }
        HistogramProcessorManager.PlatformImplementations.kt_3 aVar2 = this.f15714A;
        aVar2.f14812b = ((dimensionPixelSize3 - dimensionPixelSize4) / 2) + iM16104t + i2;
        aVar2.f14814d = ((dimensionPixelSize4 - dimensionPixelSize3) / 2) + dimensionPixelSize2;
        aVar2.f14815e = (this.mOrientation + 180) % 360;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: COUIBaseListPopupWindow_8 */
    public void m16073e(int OplusGLSurfaceView_13) throws Resources.NotFoundException {
        int dimensionPixelSize;
        HistogramProcessorManager.PlatformImplementations.kt_3 aVar;
        int i2;
        CameraLog.m12954a("ProfessionalCapMode", "updateHistogramLayoutByAnim, offsetY: " + OplusGLSurfaceView_13);
        Resources resources = this.mActivity.getResources();
        int dimensionPixelSize2 = resources.getDimensionPixelSize(R.dimen.histogram_graph_view_width);
        int dimensionPixelSize3 = resources.getDimensionPixelSize(R.dimen.histogram_graph_view_height);
        if (this.f15714A == null) {
            this.f15714A = new HistogramProcessorManager.PlatformImplementations.kt_3();
            this.f15714A.f14811a = 10;
        }
        HistogramProcessorManager.PlatformImplementations.kt_3 aVar2 = this.f15714A;
        if (Util.m24498u()) {
            BaseScreenMode currentScreenMode = getCurrentScreenMode();
            if (currentScreenMode != null) {
                int iM16104t = m16104t();
                aVar = new HistogramProcessorManager.PlatformImplementations.kt_3();
                currentScreenMode.mo16501a(aVar, iM16104t, this.mOrientation);
                dimensionPixelSize = aVar.f14814d;
                i2 = aVar.f14812b;
            } else {
                dimensionPixelSize = 0;
                aVar = aVar2;
                i2 = 0;
            }
        } else {
            int dimensionPixelSize4 = resources.getDimensionPixelSize(R.dimen.professional_histogram_margin_top);
            dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.professional_histogram_margin_start);
            aVar = aVar2;
            i2 = dimensionPixelSize4;
        }
        if (m15940F() || Util.m24498u()) {
            int i3 = i2 + OplusGLSurfaceView_13;
            if (Util.m24498u()) {
                this.f15714A.f14812b = i3;
            } else {
                HistogramProcessorManager.PlatformImplementations.kt_3 aVar3 = this.f15714A;
                aVar3.f14812b = this.f15744ae + i3;
                if (this.f15721H && OplusGLSurfaceView_13 != 0) {
                    aVar3.f14812b += this.f15745af;
                }
            }
            HistogramProcessorManager.PlatformImplementations.kt_3 aVar4 = this.f15714A;
            aVar4.f14814d = dimensionPixelSize;
            aVar4.f14815e = aVar.f14815e;
            return;
        }
        if (90 == this.mOrientation) {
            dimensionPixelSize += OplusGLSurfaceView_13;
        }
        HistogramProcessorManager.PlatformImplementations.kt_3 aVar5 = this.f15714A;
        aVar5.f14812b = ((dimensionPixelSize2 - dimensionPixelSize3) / 2) + this.f15744ae + i2;
        aVar5.f14814d = ((dimensionPixelSize3 - dimensionPixelSize2) / 2) + dimensionPixelSize;
        aVar5.f14815e = (this.mOrientation + 180) % 360;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m16056b(boolean z, boolean z2) throws Resources.NotFoundException {
        m16005a(z, z2, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public void m16005a(boolean z, boolean z2, boolean z3) throws Resources.NotFoundException {
        boolean zM15980Z;
        if (this.mPreferences == null || this.f15772z == null || !getSupportFunction(CameraUIInterface.KEY_PRO_HISTOGRAM) || (zM15980Z = m15980Z()) == this.f15772z.m14848b()) {
            return;
        }
        if (this.f15741ab != 0 && !z3) {
            this.f15741ab = 0;
            m16073e(0);
        } else if (z3) {
            m16073e(this.f15741ab);
        }
        ProfessionalAnimUtil.PlatformImplementations.kt_3 aVar = new ProfessionalAnimUtil.PlatformImplementations.kt_3();
        aVar.f15706a = zM15980Z;
        if (z) {
            aVar.f15707b = zM15980Z ? 250 : 0;
            aVar.f15708c = 250;
        } else if (z2) {
            int dimensionPixelSize = this.mActivity.getResources().getDimensionPixelSize(R.dimen.professional_histogram_animation_offset);
            aVar.f15708c = zM15980Z ? 500 : 250;
            aVar.f15712g = 500;
            aVar.f15709d = zM15980Z ? dimensionPixelSize : 0.0f;
            aVar.f15710e = zM15980Z ? 0.0f : dimensionPixelSize;
        }
        aVar.f15713h = m16127e() ? "translationX" : "translationY";
        if (zM15980Z) {
            this.f15772z.m14845a(aVar);
        } else {
            this.f15772z.m14847b(aVar);
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onYuvDataReceviced(byte[] bArr) {
        if (this.f15772z == null || !isHistogramOpen()) {
            return;
        }
        this.f15772z.m14846a(bArr);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void onTopSubMenuExpand() {
        if (this.f15769w.isSelected()) {
            this.mCameraInterface.mo10492a(true, true);
            this.mCameraInterface.mo10563d(true);
            ProfessionalAnimUtil.PlatformImplementations.kt_3 aVar = new ProfessionalAnimUtil.PlatformImplementations.kt_3();
            aVar.f15706a = false;
            aVar.f15708c = 250;
            aVar.f15712g = 400;
            aVar.f15709d = 0.0f;
            aVar.f15710e = this.mActivity.getResources().getDimensionPixelSize(R.dimen.main_mode_bar_item_animation_offset);
            this.f15770x.setAllPopupInvisibility(aVar);
            this.f15769w.m15381a();
            this.mOneCamera.mo13105j(true);
        } else {
            super.onTopSubMenuExpand();
        }
        if (4 == m16128f()) {
            this.f15769w.setVisibilityWithAnimation(8);
            m16051b(8, true);
        } else if (1 == m16128f()) {
            this.f15769w.setVisibilityWithAnimation(8);
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void onTopSubMenuCollapse() {
        super.onTopSubMenuCollapse();
        if (4 == m16128f()) {
            if (!this.mCameraUIInterface.mo18159aw()) {
                this.f15769w.setVisibilityWithAnimation(0);
            }
            m16051b(0, true);
        } else if (1 == m16128f()) {
            this.f15769w.setVisibilityWithAnimation(0);
            BaseScreenMode currentScreenMode = getCurrentScreenMode();
            if (m16129g() != 0 || currentScreenMode == null) {
                return;
            }
            this.f15716C.setLayoutParams(currentScreenMode.mo16512e());
        }
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public boolean m16127e() {
        BaseScreenMode currentScreenMode = getCurrentScreenMode();
        return currentScreenMode != null && currentScreenMode.mo16571l();
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    public int m16128f() {
        BaseScreenMode currentScreenMode = getCurrentScreenMode();
        if (currentScreenMode != null) {
            return currentScreenMode.mo16539j();
        }
        return 0;
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    public int m16129g() {
        BaseScreenMode currentScreenMode = getCurrentScreenMode();
        if (currentScreenMode != null) {
            return currentScreenMode.mo16570k();
        }
        return 0;
    }

    /* renamed from: COUIBaseListPopupWindow_10 */
    public int m16130h() {
        return m16127e() ? 1 : 0;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean getTouchEnable(boolean z, int OplusGLSurfaceView_13, int i2) throws Resources.NotFoundException {
        int dimensionPixelSize;
        int dimensionPixelSize2 = this.mActivity.getResources().getDimensionPixelSize(R.dimen.exposure_indicator_width);
        BaseScreenMode abstractC2934aMo10519aU = this.mCameraInterface != null ? this.mCameraInterface.mo10519aU() : null;
        if (1 == (abstractC2934aMo10519aU == null ? 0 : abstractC2934aMo10519aU.mo16539j())) {
            dimensionPixelSize = this.mActivity.getResources().getDimensionPixelSize(R.dimen.fold_full_professional_params_item_image_margin_top);
        } else {
            dimensionPixelSize = this.mActivity.getResources().getDimensionPixelSize(R.dimen.main_mode_bar_item_title_image_margin);
        }
        Rect rect = new Rect();
        this.f15769w.getGlobalVisibleRect(rect);
        int i3 = dimensionPixelSize2 / 2;
        rect.left -= i3;
        rect.top -= i3 - dimensionPixelSize;
        rect.right += i3;
        rect.bottom += i3;
        Rect rect2 = new Rect();
        if (this.f15769w.isSelected()) {
            this.f15770x.getGlobalVisibleRect(rect2);
            rect2.left -= i3;
            rect2.top -= i3;
            rect2.right += i3;
            rect2.bottom += i3;
        }
        return (!z || rect.contains(OplusGLSurfaceView_13, i2) || rect2.contains(OplusGLSurfaceView_13, i2)) ? false : true;
    }
}

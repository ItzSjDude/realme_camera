package com.oplus.camera.p172ui.preview;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.SurfaceTexture;
import android.hardware.camera2.params.Face;
import android.os.Handler;
import android.os.Message;
import android.os.Process;
import android.os.SystemClock;
import android.util.Size;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.coui.appcompat.dialog.app.COUIAlertDialog;
import com.coui.appcompat.widget.COUIToolTips;
import com.oplus.camera.CameraLog;
import com.oplus.camera.CameraMotorManager;
import com.oplus.camera.OplusConfigure;
import com.oplus.camera.ComboPreferences;
import com.oplus.camera.CameraConstant;
import com.oplus.camera.R;
import com.oplus.camera.Storage;
import com.oplus.camera.aps.config.CameraConfig;
import com.oplus.camera.aps.config.CameraFunction;
import com.oplus.camera.aps.config.ConfigDataBase;
import com.oplus.camera.aps.constant.ApsConstant;
import com.oplus.camera.doubleexposure.EffectMenuAdapter;
import com.oplus.camera.doubleexposure.EffectType;
import com.oplus.camera.p137b.ZoomAnimationListener;
import com.oplus.camera.p141e.CameraCharacteristicsUtil;
import com.oplus.camera.p146gl.SurfaceTextureScreenNail;
import com.oplus.camera.p146gl.GLRootView;
import com.oplus.camera.p146gl.GLView;
import com.oplus.camera.p146gl.GLCanvas;
import com.oplus.camera.p171u.DetectResult;
import com.oplus.camera.p172ui.BackgroundSplitManager;
import com.oplus.camera.p172ui.OplusViewOutlineProvider;
import com.oplus.camera.p172ui.RotableViewWithText;
import com.oplus.camera.p172ui.CameraUIInterface;
import com.oplus.camera.p172ui.RotableTextView;
import com.oplus.camera.p172ui.inverse.InverseManager;
import com.oplus.camera.p172ui.inverse.InverseMaskView;
import com.oplus.camera.p172ui.menu.levelcontrol.GLProducerRender;
import com.oplus.camera.p172ui.preview.CameraScreenNail;
import com.oplus.camera.p172ui.preview.FacePointAnimationManager;
import com.oplus.camera.p172ui.preview.GradienterAssistView;
import com.oplus.camera.p172ui.preview.HyperLapseFocusView;
import com.oplus.camera.p172ui.preview.IntelligentDragView;
import com.oplus.camera.p172ui.preview.PreviewFrameLayout;
import com.oplus.camera.p172ui.preview.p177a.PreviewEffectProcess;
import com.oplus.camera.p172ui.widget.MultiCameraTypeSelectLayout;
import com.oplus.camera.perf.CameraPerformance;
import com.oplus.camera.screen.out.OutPresentation;
import com.oplus.camera.screen.p164b.BaseScreenMode;
import com.oplus.camera.screen.p164b.ScreenModeFacade;
import com.oplus.camera.util.BackgroundUtil;
import com.oplus.camera.util.DisableUitl;
import com.oplus.camera.util.Util;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* compiled from: CameraPreviewUI.java */
/* renamed from: com.oplus.camera.ui.preview.COUIBaseListPopupWindow_11 */
/* loaded from: classes2.dex */
public class CameraPreviewUI implements View.OnLayoutChangeListener, CameraConstant, PreviewFrameLayout.OnSizeChangedListener, CameraScreenNail.IntrinsicsJvm.kt_3, FacePointAnimationManager.IntrinsicsJvm.kt_4 {

    /* renamed from: COUIBaseListPopupWindow_11 */
    private static final String f21920g = OplusConfigure.m24651a();

    /* renamed from: COUIBaseListPopupWindow_10 */
    private static Bitmap f21921h = null;

    /* renamed from: V */
    private float f21943V;

    /* renamed from: W */
    private float f21944W;

    /* renamed from: X */
    private Activity f21945X;

    /* renamed from: Y */
    private ComboPreferences f21946Y;

    /* renamed from: ak */
    private IntrinsicsJvm.kt_4 f21984ak;

    /* renamed from: bg_renamed */
    private boolean f22006bg;

    /* renamed from: bq */
    private Runnable f22016bq;

    /* renamed from: OplusGLSurfaceView_15 */
    private volatile boolean f22025j = false;

    /* renamed from: OplusGLSurfaceView_5 */
    private volatile int f22026k = 0;

    /* renamed from: OplusGLSurfaceView_14 */
    private PathInterpolator f22027l = new PathInterpolator(0.33f, 0.0f, 0.67f, 1.0f);

    /* renamed from: OplusGLSurfaceView_6 */
    private PathInterpolator f22028m = new PathInterpolator(0.3f, 0.0f, 0.1f, 1.0f);

    /* renamed from: OplusGLSurfaceView_11 */
    private PathInterpolator f22029n = new PathInterpolator(0.35f, 0.62f, 0.2f, 1.0f);

    /* renamed from: o */
    private Object f22030o = new Object();

    /* renamed from: p */
    private boolean f22031p = false;

    /* renamed from: q */
    private boolean f22032q = false;

    /* renamed from: r */
    private boolean f22033r = false;

    /* renamed from: s */
    private boolean f22034s = false;

    /* renamed from: t */
    private boolean f22035t = false;

    /* renamed from: u */
    private boolean f22036u = false;

    /* renamed from: v */
    private boolean f22037v = false;

    /* renamed from: w */
    private boolean f22038w = false;

    /* renamed from: x */
    private boolean f22039x = false;

    /* renamed from: y */
    private boolean f22040y = false;

    /* renamed from: z */
    private boolean f22041z = false;

    /* renamed from: A */
    private boolean f21922A = false;

    /* renamed from: B */
    private int f21923B = 0;

    /* renamed from: C */
    private int f21924C = 0;

    /* renamed from: D */
    private int f21925D = 0;

    /* renamed from: E */
    private int f21926E = 0;

    /* renamed from: F */
    private int f21927F = 0;

    /* renamed from: G */
    private int f21928G = 0;

    /* renamed from: H */
    private int f21929H = 0;

    /* renamed from: I */
    private int f21930I = 0;

    /* renamed from: J */
    private int f21931J = 0;

    /* renamed from: K */
    private int f21932K = 0;

    /* renamed from: L */
    private int f21933L = 0;

    /* renamed from: M */
    private int f21934M = 0;

    /* renamed from: N */
    private int f21935N = 0;

    /* renamed from: O */
    private ArrayList<COUIBaseListPopupWindow_8> f21936O = new ArrayList<>();

    /* renamed from: P */
    private int f21937P = 90;

    /* renamed from: Q */
    private int f21938Q = 0;

    /* renamed from: R */
    private int f21939R = 0;

    /* renamed from: S */
    private int f21940S = 0;

    /* renamed from: T */
    private int f21941T = 0;

    /* renamed from: U */
    private long f21942U = 0;

    /* renamed from: Z */
    private CameraScreenNail f21947Z = null;

    /* renamed from: aa */
    private COUIAlertDialog f21974aa = null;

    /* renamed from: ab */
    private COUIAlertDialog.PlatformImplementations.kt_3 f21975ab = null;

    /* renamed from: ac */
    private FaceView f21976ac = null;

    /* renamed from: ad */
    private TrackFocusView f21977ad = null;

    /* renamed from: ae */
    private MultiFocusView f21978ae = null;

    /* renamed from: af */
    private IntelligentDragView f21979af = null;

    /* renamed from: ag */
    private SuperTextFrameView f21980ag = null;

    /* renamed from: ah */
    private int f21981ah = 1;

    /* renamed from: ai */
    private int f21982ai = 0;

    /* renamed from: aj */
    private int f21983aj = 0;

    /* renamed from: al */
    private IntrinsicsJvm.kt_3 f21985al = null;

    /* renamed from: am */
    private ImageView f21986am = null;

    /* renamed from: an */
    private BlurCoverBg f21987an = null;

    /* renamed from: ao */
    private ImageView f21988ao = null;

    /* renamed from: ap */
    private PreviewFrameLayout f21989ap = null;

    /* renamed from: aq */
    private RelativeLayout.LayoutParams f21990aq = null;

    /* renamed from: ar */
    private GradienterAssistView f21991ar = null;

    /* renamed from: as */
    private GuideLineView f21992as = null;

    /* renamed from: at */
    private ImageView f21993at = null;

    /* renamed from: au */
    private RelativeLayout f21994au = null;

    /* renamed from: av */
    private Bitmap f21995av = null;

    /* renamed from: aw */
    private String f21996aw = null;

    /* renamed from: ax */
    private String f21997ax = "off";

    /* renamed from: ay */
    private Size f21998ay = null;

    /* renamed from: az */
    private SurfaceTexture f21999az = null;

    /* renamed from: aA */
    private Surface f21948aA = null;

    /* renamed from: aB */
    private Size f21949aB = null;

    /* renamed from: aC */
    private Size f21950aC = null;

    /* renamed from: aD */
    private int f21951aD = 0;

    /* renamed from: aE */
    private int f21952aE = 0;

    /* renamed from: aF */
    private Size f21953aF = null;

    /* renamed from: aG */
    private Size f21954aG = null;

    /* renamed from: aH */
    private int f21955aH = 0;

    /* renamed from: aI */
    private PlatformImplementations.kt_3 f21956aI = null;

    /* renamed from: aJ */
    private boolean f21957aJ = false;

    /* renamed from: aK */
    private CameraScreenNail.IntrinsicsJvm.kt_5 f21958aK = null;

    /* renamed from: aL */
    private GLRootView f21959aL = null;

    /* renamed from: aM */
    private RotableTextView f21960aM = null;

    /* renamed from: aN */
    private RotableViewWithText f21961aN = null;

    /* renamed from: aO */
    private HyperLapseFocusView f21962aO = null;

    /* renamed from: aP */
    private COUIToolTips f21963aP = null;

    /* renamed from: aQ */
    private int f21964aQ = 0;

    /* renamed from: aR */
    private ImageView f21965aR = null;

    /* renamed from: aS */
    private MultiCameraTypeSelectLayout f21966aS = null;

    /* renamed from: aT */
    private boolean f21967aT = false;

    /* renamed from: aU */
    private AnimatorSet f21968aU = null;

    /* renamed from: aV */
    private AnimatorSet f21969aV = null;

    /* renamed from: aW */
    private int f21970aW = 0;

    /* renamed from: aX */
    private AnimatorSet f21971aX = null;

    /* renamed from: aY */
    private AnimatorSet f21972aY = null;

    /* renamed from: aZ */
    private int f21973aZ = 0;

    /* renamed from: ba */
    private RecyclerView f22000ba = null;

    /* renamed from: bb */
    private EffectMenuAdapter.IntrinsicsJvm.kt_4 f22001bb = null;

    /* renamed from: bc */
    private OutPresentation f22002bc = null;

    /* renamed from: bd */
    private Thread f22003bd = null;

    /* renamed from: be */
    private boolean f22004be = true;

    /* renamed from: bf */
    private boolean f22005bf = false;

    /* renamed from: bh */
    private ArrayList<PreviewRenderCallback> f22007bh = new ArrayList<>();

    /* renamed from: bi */
    private BaseScreenMode f22008bi = null;

    /* renamed from: bj */
    private Size f22009bj = new Size(0, 0);

    /* renamed from: bk */
    private String f22010bk = "";

    /* renamed from: bl */
    private Size f22011bl = new Size(0, 0);

    /* renamed from: bm */
    private int f22012bm = 0;

    /* renamed from: bn */
    private int f22013bn = 0;

    /* renamed from: bo */
    private int f22014bo = 0;

    /* renamed from: bp */
    private int f22015bp = 0;

    /* renamed from: br */
    private Handler f22017br = new Handler() { // from class: com.oplus.camera.ui.preview.COUIBaseListPopupWindow_11.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int OplusGLSurfaceView_13 = message.what;
            if (OplusGLSurfaceView_13 == 1) {
                CameraPreviewUI.this.m23224aC();
                return;
            }
            if (OplusGLSurfaceView_13 == 2) {
                CameraPreviewUI.this.m23225aD();
                return;
            }
            if (OplusGLSurfaceView_13 != 3) {
                if (OplusGLSurfaceView_13 == 4 && CameraPreviewUI.this.f21961aN != null && CameraPreviewUI.this.f21961aN.getVisibility() == 0) {
                    CameraPreviewUI.this.f21961aN.setVisibility(8);
                    return;
                }
                return;
            }
            if (CameraPreviewUI.this.f21961aN == null || CameraPreviewUI.this.f21961aN.getVisibility() == 0) {
                return;
            }
            CameraPreviewUI.this.f21961aN.setVisibility(0);
        }
    };

    /* renamed from: bs */
    private final GLView f22018bs = new GLView() { // from class: com.oplus.camera.ui.preview.COUIBaseListPopupWindow_11.11
        @Override // com.oplus.camera.p146gl.GLView
        /* renamed from: IntrinsicsJvm.kt_4 */
        protected void mo13811b(GLCanvas interfaceC2757h) {
            super.mo13811b(interfaceC2757h);
        }

        @Override // com.oplus.camera.p146gl.GLView
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo13802a(int OplusGLSurfaceView_13, int i2, int i3, int i4) {
            super.mo13802a(OplusGLSurfaceView_13, i2, i3, i4);
        }

        @Override // com.oplus.camera.p146gl.GLView
        /* renamed from: COUIBaseListPopupWindow_12 */
        protected void mo13817f() {
            CameraPreviewUI.this.f21947Z.m23487r();
        }

        @Override // com.oplus.camera.p146gl.GLView
        /* renamed from: PlatformImplementations.kt_3 */
        protected void mo13801a(int OplusGLSurfaceView_13, int i2) {
            CameraPreviewUI.this.f21947Z.m23469b(OplusGLSurfaceView_13, i2);
        }

        @Override // com.oplus.camera.p146gl.GLView
        /* renamed from: PlatformImplementations.kt_3 */
        protected void mo13803a(GLCanvas interfaceC2757h) {
            int OplusGLSurfaceView_13 = 1;
            if (CameraPreviewUI.this.f21947Z.m14253h()) {
                CameraLog.m12954a("CameraPreviewUI", "render, last wanted frame already drawn, prevent from drawing more frames");
                if (CameraPreviewUI.this.f21959aL != null) {
                    CameraPreviewUI.this.f21959aL.setPreventRenderByPause(true);
                    return;
                }
                return;
            }
            CameraPreviewUI viewOnLayoutChangeListenerC3444g = CameraPreviewUI.this;
            viewOnLayoutChangeListenerC3444g.m23212a((viewOnLayoutChangeListenerC3444g.f21989ap.getRight() - CameraPreviewUI.this.f21989ap.getLeft()) / 2, (CameraPreviewUI.this.f21989ap.getBottom() - CameraPreviewUI.this.f21989ap.getTop()) / 2, false, CameraPreviewUI.this.m23249ay(), false);
            interfaceC2757h.mo13977a(new float[]{1.0f, BackgroundUtil.m24522a(0.0f), BackgroundUtil.m24524b(0.0f), BackgroundUtil.m24525c(0.0f)});
            if (CameraPreviewUI.this.f22040y) {
                interfaceC2757h.mo13977a(new float[]{1.0f, ((Color.red(CameraPreviewUI.this.f21934M) / 255.0f) * Color.alpha(CameraPreviewUI.this.f21934M)) / 255.0f, ((Color.green(CameraPreviewUI.this.f21934M) / 255.0f) * Color.alpha(CameraPreviewUI.this.f21934M)) / 255.0f, ((Color.blue(CameraPreviewUI.this.f21934M) / 255.0f) * Color.alpha(CameraPreviewUI.this.f21934M)) / 255.0f});
            }
            synchronized (CameraPreviewUI.this.f22030o) {
                if (CameraPreviewUI.this.f21933L != 0 && !CameraPreviewUI.this.f21957aJ) {
                    float fUptimeMillis = SystemClock.uptimeMillis() - CameraPreviewUI.this.f21942U;
                    if (fUptimeMillis < CameraPreviewUI.this.f21944W) {
                        float interpolation = CameraPreviewUI.this.f22024i.getInterpolation(fUptimeMillis / CameraPreviewUI.this.f21944W);
                        CameraPreviewUI.this.f21930I = CameraPreviewUI.this.f21954aG.getHeight() + ((int) (CameraPreviewUI.this.f21933L * interpolation));
                        CameraPreviewUI.this.f21923B = CameraPreviewUI.this.f21924C - ((int) ((CameraPreviewUI.this.f21933L / 2) * interpolation));
                    } else {
                        CameraPreviewUI.this.f21930I = CameraPreviewUI.this.f21953aF.getHeight();
                        if (CameraPreviewUI.this.f22038w) {
                            CameraPreviewUI.this.f21923B = CameraPreviewUI.this.f21925D;
                        }
                        CameraPreviewUI.this.f21933L = 0;
                        CameraPreviewUI.this.f21925D = 0;
                    }
                }
            }
            synchronized (CameraPreviewUI.this.f22030o) {
                if (CameraPreviewUI.this.f21932K != 0 && !CameraPreviewUI.this.f21957aJ) {
                    if (SystemClock.uptimeMillis() - CameraPreviewUI.this.f21942U < CameraPreviewUI.this.f21944W) {
                        COUIBaseListPopupWindow_8 eVarM23229aH = CameraPreviewUI.this.f21932K > 0 ? CameraPreviewUI.this.m23229aH() : CameraPreviewUI.this.m23230aI();
                        if (eVarM23229aH != null) {
                            CameraPreviewUI.this.f21926E = eVarM23229aH.f22086a;
                            CameraPreviewUI.this.f21931J = eVarM23229aH.f22087b;
                        } else {
                            CameraPreviewUI.this.f21926E = CameraPreviewUI.this.f21927F;
                            CameraPreviewUI.this.f21931J = CameraPreviewUI.this.f21954aG.getWidth();
                        }
                        BackgroundSplitManager c3129aM18430a = BackgroundSplitManager.m18430a(CameraPreviewUI.this.f21945X);
                        if (CameraPreviewUI.this.f21932K <= 0) {
                            OplusGLSurfaceView_13 = 2;
                        }
                        c3129aM18430a.m18447b(OplusGLSurfaceView_13);
                    } else {
                        CameraPreviewUI.this.f21931J = CameraPreviewUI.this.f21953aF.getWidth();
                        if (CameraPreviewUI.this.f22039x) {
                            CameraPreviewUI.this.f21926E = CameraPreviewUI.this.f21928G;
                        }
                        CameraPreviewUI.this.f21932K = 0;
                        CameraPreviewUI.this.f21929H = 0;
                        CameraPreviewUI.this.f21928G = 0;
                        CameraPreviewUI.this.f21936O.clear();
                        BackgroundSplitManager.m18430a(CameraPreviewUI.this.f21945X).m18438a();
                    }
                }
            }
            if (Util.m24495t()) {
                CameraPreviewUI.this.m23232aK();
            }
            synchronized (CameraPreviewUI.this.f22030o) {
                if (CameraPreviewUI.this.f21957aJ && SystemClock.uptimeMillis() - CameraPreviewUI.this.f21942U >= CameraPreviewUI.this.f21944W) {
                    CameraPreviewUI.this.m23227aF();
                }
            }
            if (Util.m24495t()) {
                CameraPreviewUI.this.m23233aL();
            }
            CameraPreviewUI.this.m23213a(interfaceC2757h);
            CameraPreviewUI.this.f21947Z.mo14236a(interfaceC2757h, (GLProducerRender) null, CameraPreviewUI.this.m23245au(), CameraPreviewUI.this.m23246av(), CameraPreviewUI.this.m23247aw(), CameraPreviewUI.this.m23248ax());
            CameraPreviewUI.this.m23255b(interfaceC2757h);
        }

        @Override // com.oplus.camera.p146gl.GLView
        /* renamed from: PlatformImplementations.kt_3 */
        protected void mo13804a(GLCanvas interfaceC2757h, int OplusGLSurfaceView_13) {
            if (CameraPreviewUI.this.f21947Z != null) {
                if (OplusGLSurfaceView_13 == 0) {
                    CameraPreviewUI.this.f21947Z.m14228a(interfaceC2757h, 0, 0, CameraPreviewUI.this.f21939R, CameraPreviewUI.this.f21938Q, CameraPreviewUI.this.f22025j ? CameraPreviewUI.this.f22026k : CameraPreviewUI.this.f21984ak.mo19844cu(), OplusGLSurfaceView_13);
                } else if (1 == OplusGLSurfaceView_13) {
                    CameraPreviewUI.this.f21947Z.m14228a(interfaceC2757h, 0, 0, CameraPreviewUI.this.f21940S, CameraPreviewUI.this.f21941T, 0, OplusGLSurfaceView_13);
                }
            }
        }
    };

    /* renamed from: bt */
    private Animation.AnimationListener f22019bt = new Animation.AnimationListener() { // from class: com.oplus.camera.ui.preview.COUIBaseListPopupWindow_11.19
        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            if (CameraPreviewUI.this.f22005bf) {
                return;
            }
            CameraPreviewUI.this.m23244at();
        }
    };

    /* renamed from: bu */
    private Animation.AnimationListener f22020bu = new Animation.AnimationListener() { // from class: com.oplus.camera.ui.preview.COUIBaseListPopupWindow_11.30
        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            if (CameraPreviewUI.this.f21993at != null) {
                CameraPreviewUI.this.f21993at.setLayerType(0, null);
                CameraPreviewUI.this.f21993at.setVisibility(8);
            }
        }
    };

    /* renamed from: bv */
    private final DialogInterface.OnClickListener f22021bv = new DialogInterface.OnClickListener() { // from class: com.oplus.camera.ui.preview.COUIBaseListPopupWindow_11.32
        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int OplusGLSurfaceView_13) throws PackageManager.NameNotFoundException {
            int i2 = Storage.f12097w;
            if (i2 == 0) {
                dialogInterface.dismiss();
                return;
            }
            if (i2 == 1 || i2 == 2 || i2 == 3) {
                dialogInterface.dismiss();
                if (DisableUitl.m24536a(CameraPreviewUI.this.f21945X, CameraPreviewUI.f21920g)) {
                    DisableUitl.m24534a(CameraPreviewUI.this.f21945X, R.string.camera_disable_mobile_manager, CameraPreviewUI.f21920g, "");
                    return;
                }
                if (CameraPreviewUI.this.f22006bg) {
                    Intent intent = new Intent("oplus.intent.action.CLEAR_MAIN_ACTIVITY");
                    intent.setPackage(CameraPreviewUI.f21920g);
                    try {
                        intent.addFlags(67108864);
                        CameraPreviewUI.this.f21945X.startActivity(intent);
                    } catch (Exception e2) {
                        CameraLog.m12967f("CameraPreviewUI", "mDialogOnClickListener.onClick, Exception when start ClearMainActivity: " + e2);
                    }
                }
            }
        }
    };

    /* renamed from: bw */
    private final IntelligentDragView.InterfaceC3384a f22022bw = new IntelligentDragView.InterfaceC3384a() { // from class: com.oplus.camera.ui.preview.COUIBaseListPopupWindow_11.33
        @Override // com.oplus.camera.p172ui.preview.IntelligentDragView.InterfaceC3384a
        /* renamed from: PlatformImplementations.kt_3 */
        public boolean mo22171a(MotionEvent motionEvent) {
            int rawX = (int) motionEvent.getRawX();
            int rawY = (int) motionEvent.getRawY();
            if (CameraPreviewUI.this.f21984ak == null || !CameraPreviewUI.this.f21984ak.mo19972m(rawX, rawY)) {
                return false;
            }
            CameraPreviewUI.this.f21984ak.mo19655a(rawX, rawY, motionEvent.getEventTime());
            return false;
        }

        @Override // com.oplus.camera.p172ui.preview.IntelligentDragView.InterfaceC3384a
        /* renamed from: IntrinsicsJvm.kt_4 */
        public void mo22172b(MotionEvent motionEvent) {
            int rawX = (int) motionEvent.getRawX();
            int rawY = (int) motionEvent.getRawY();
            if (CameraPreviewUI.this.f21984ak != null) {
                CameraPreviewUI.this.f21984ak.mo19969l(rawX, rawY);
            }
        }

        @Override // com.oplus.camera.p172ui.preview.IntelligentDragView.InterfaceC3384a
        /* renamed from: IntrinsicsJvm.kt_3 */
        public void mo22173c(MotionEvent motionEvent) {
            int rawX = (int) motionEvent.getRawX();
            int rawY = (int) motionEvent.getRawY();
            if (CameraPreviewUI.this.f21984ak == null || !CameraPreviewUI.this.f21984ak.mo19972m(rawX, rawY)) {
                return;
            }
            CameraPreviewUI.this.f21984ak.mo19953f(rawX, rawY);
        }
    };

    /* renamed from: bx */
    private HyperLapseFocusView.InterfaceC3382a f22023bx = new HyperLapseFocusView.InterfaceC3382a() { // from class: com.oplus.camera.ui.preview.COUIBaseListPopupWindow_11.10
        @Override // com.oplus.camera.p172ui.preview.HyperLapseFocusView.InterfaceC3382a
        /* renamed from: PlatformImplementations.kt_3 */
        public boolean mo22159a() {
            return CameraPreviewUI.this.f22025j;
        }

        @Override // com.oplus.camera.p172ui.preview.HyperLapseFocusView.InterfaceC3382a
        /* renamed from: IntrinsicsJvm.kt_4 */
        public boolean mo22161b() {
            if (CameraPreviewUI.this.f21984ak != null) {
                return CameraPreviewUI.this.f21984ak.mo18159aw();
            }
            return false;
        }

        @Override // com.oplus.camera.p172ui.preview.HyperLapseFocusView.InterfaceC3382a
        /* renamed from: IntrinsicsJvm.kt_3 */
        public void mo22162c() {
            if (CameraPreviewUI.this.f21984ak != null) {
                CameraPreviewUI.this.f21984ak.mo19741bA();
            }
        }

        @Override // com.oplus.camera.p172ui.preview.HyperLapseFocusView.InterfaceC3382a
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo22158a(int OplusGLSurfaceView_13, int i2) {
            CameraPreviewUI.this.f21984ak.mo19655a(OplusGLSurfaceView_13, i2, 0L);
        }

        @Override // com.oplus.camera.p172ui.preview.HyperLapseFocusView.InterfaceC3382a
        /* renamed from: IntrinsicsJvm.kt_4 */
        public void mo22160b(int OplusGLSurfaceView_13, int i2) {
            CameraPreviewUI.this.f21984ak.mo19953f(OplusGLSurfaceView_13, i2);
        }
    };

    /* renamed from: OplusGLSurfaceView_13 */
    private PathInterpolator f22024i = this.f22029n;

    /* compiled from: CameraPreviewUI.java */
    /* renamed from: com.oplus.camera.ui.preview.COUIBaseListPopupWindow_11$PlatformImplementations.kt_3 */
    public interface PlatformImplementations.kt_3 {
        /* renamed from: PlatformImplementations.kt_3 */
        void mo10942a();

        /* renamed from: PlatformImplementations.kt_3 */
        void mo10943a(Size size);

        /* renamed from: PlatformImplementations.kt_3 */
        void mo10944a(Size size, Size size2);

        /* renamed from: IntrinsicsJvm.kt_4 */
        int mo10945b();
    }

    /* compiled from: CameraPreviewUI.java */
    /* renamed from: com.oplus.camera.ui.preview.COUIBaseListPopupWindow_11$IntrinsicsJvm.kt_4 */
    public interface IntrinsicsJvm.kt_4 {
        /* renamed from: S */
        void mo19635S(int OplusGLSurfaceView_13);

        /* renamed from: PlatformImplementations.kt_3 */
        float mo19645a(float COUIBaseListPopupWindow_12);

        /* renamed from: PlatformImplementations.kt_3 */
        void mo19651a(int OplusGLSurfaceView_13, int i2, int i3, int i4);

        /* renamed from: PlatformImplementations.kt_3 */
        void mo19655a(int OplusGLSurfaceView_13, int i2, long OplusGLSurfaceView_15);

        /* renamed from: PlatformImplementations.kt_3 */
        void mo19656a(int OplusGLSurfaceView_13, int i2, boolean z);

        /* renamed from: PlatformImplementations.kt_3 */
        void mo19672a(EffectType c2687f);

        /* renamed from: PlatformImplementations.kt_3 */
        void mo19673a(BaseScreenMode abstractC2934a, Size size, long OplusGLSurfaceView_15);

        /* renamed from: PlatformImplementations.kt_3 */
        int[] mo19698a(Size size, Size size2);

        /* renamed from: aX */
        int mo18134aX();

        /* renamed from: aw */
        boolean mo18159aw();

        /* renamed from: bA */
        void mo19741bA();

        /* renamed from: bB */
        boolean mo19742bB();

        /* renamed from: bC */
        void mo19743bC();

        /* renamed from: bg_renamed */
        String mo19768bg();

        /* renamed from: bh */
        String mo19769bh();

        /* renamed from: cp */
        boolean mo19839cp();

        /* renamed from: cq */
        void mo19840cq();

        /* renamed from: cr */
        void mo19841cr();

        /* renamed from: cs */
        void mo19842cs();

        /* renamed from: ct */
        void mo19843ct();

        /* renamed from: cu */
        int mo19844cu();

        /* renamed from: cv */
        int mo19845cv();

        /* renamed from: dX */
        boolean mo19880dX();

        /* renamed from: dY */
        boolean mo19881dY();

        /* renamed from: dZ */
        boolean mo19882dZ();

        /* renamed from: dr */
        boolean mo19900dr();

        /* renamed from: ds */
        String mo19901ds();

        /* renamed from: dt */
        void mo19902dt();

        /* renamed from: COUIBaseListPopupWindow_8 */
        RelativeLayout.LayoutParams mo19909e(Size size);

        /* renamed from: eD */
        boolean mo19916eD();

        /* renamed from: eE */
        int mo19917eE();

        /* renamed from: eK */
        void mo19923eK();

        /* renamed from: ea */
        float mo19927ea();

        /* renamed from: eb */
        boolean mo19928eb();

        /* renamed from: ec */
        boolean mo19929ec();

        /* renamed from: ed */
        boolean mo19930ed();

        /* renamed from: ee */
        void mo19931ee();

        /* renamed from: ef */
        void mo19932ef();

        /* renamed from: eg */
        void mo19933eg();

        /* renamed from: eh */
        void mo19934eh();

        /* renamed from: ei */
        int mo19935ei();

        /* renamed from: ej */
        BaseScreenMode mo19936ej();

        /* renamed from: ek */
        void mo19937ek();

        /* renamed from: COUIBaseListPopupWindow_12 */
        void mo19953f(int OplusGLSurfaceView_13, int i2);

        /* renamed from: OplusGLSurfaceView_15 */
        boolean mo19966j(String str);

        /* renamed from: OplusGLSurfaceView_14 */
        void mo19969l(int OplusGLSurfaceView_13, int i2);

        /* renamed from: OplusGLSurfaceView_6 */
        boolean mo19972m(int OplusGLSurfaceView_13, int i2);
    }

    /* compiled from: CameraPreviewUI.java */
    /* renamed from: com.oplus.camera.ui.preview.COUIBaseListPopupWindow_11$IntrinsicsJvm.kt_3 */
    public interface IntrinsicsJvm.kt_3 {
        /* renamed from: PlatformImplementations.kt_3 */
        void mo22995a(RelativeLayout.LayoutParams layoutParams);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m23326a() {
        SuperTextFrameView c3463z = this.f21980ag;
        if (c3463z != null) {
            c3463z.setVisibility(0);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m23377b() {
        this.f21980ag = (SuperTextFrameView) this.f21945X.findViewById(R.id_renamed.super_text_frame_view);
        if (this.f21980ag == null) {
            this.f21980ag = new SuperTextFrameView(this.f21945X);
            this.f21980ag.setId(R.id_renamed.super_text_frame_view);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            this.f21980ag.setLayoutParams(layoutParams);
            this.f21980ag.setVisibility(8);
            PreviewFrameLayout previewFrameLayout = this.f21989ap;
            previewFrameLayout.addView(this.f21980ag, previewFrameLayout.indexOfChild(this.f21992as), layoutParams);
        }
        this.f21980ag.setForceDarkAllowed(false);
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m23386c() {
        SuperTextFrameView c3463z = this.f21980ag;
        if (c3463z != null) {
            c3463z.setVisibility(4);
            this.f21980ag.setPointsArray(null);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m23347a(final DetectResult c3077a) {
        this.f21945X.runOnUiThread(new Runnable() { // from class: com.oplus.camera.ui.preview.COUIBaseListPopupWindow_11.34
            @Override // java.lang.Runnable
            public void run() {
                if (CameraPreviewUI.this.f21980ag == null) {
                    CameraPreviewUI.this.m23377b();
                }
                if (CameraPreviewUI.this.f21980ag != null) {
                    DetectResult c3077a2 = c3077a;
                    if (c3077a2 == null || !c3077a2.m17956c()) {
                        CameraPreviewUI.this.f21980ag.setVisibility(4);
                        CameraPreviewUI.this.f21980ag.setPointsArray(null);
                    } else {
                        CameraPreviewUI.this.f21980ag.setVisibility(0);
                        CameraPreviewUI.this.f21980ag.setPointsArray(c3077a.m17955b());
                    }
                }
            }
        });
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m23382b(DetectResult c3077a) {
        CameraLog.m12954a("CameraPreviewUI", "executeSuperTextFrameColorAnimation");
        SuperTextFrameView c3463z = this.f21980ag;
        if (c3463z != null) {
            c3463z.m23896a(c3077a);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m23356a(boolean z, int OplusGLSurfaceView_13) {
        this.f22040y = z;
        this.f21934M = OplusGLSurfaceView_13;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m23328a(int OplusGLSurfaceView_13) {
        this.f21935N = OplusGLSurfaceView_13;
        BaseScreenMode abstractC2934aMo19936ej = this.f21984ak.mo19936ej();
        if (this.f21960aM == null || abstractC2934aMo19936ej == null || 1 != abstractC2934aMo19936ej.mo16539j()) {
            return;
        }
        if (OplusGLSurfaceView_13 == 0 || 1 == OplusGLSurfaceView_13) {
            abstractC2934aMo19936ej.mo16575d(new ScreenModeFacade.PlatformImplementations.kt_3() { // from class: com.oplus.camera.ui.preview.-$$Lambda$COUIBaseListPopupWindow_11$EE_V6jMNVm49mHfVqRz0rXxybGU
                @Override // com.oplus.camera.screen.p164b.ScreenModeFacade.PlatformImplementations.kt_3
                public final void call(Object[] objArr) {
                    this.COUIBaseListPopupWindow_12$0.m23258b(objArr);
                }
            });
        } else {
            abstractC2934aMo19936ej.mo16575d(new ScreenModeFacade.PlatformImplementations.kt_3() { // from class: com.oplus.camera.ui.preview.-$$Lambda$COUIBaseListPopupWindow_11$-V6uhbD6ly6pAzZuILJirpjfjJ4
                @Override // com.oplus.camera.screen.p164b.ScreenModeFacade.PlatformImplementations.kt_3
                public final void call(Object[] objArr) {
                    this.COUIBaseListPopupWindow_12$0.m23220a(objArr);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: IntrinsicsJvm.kt_4 */
    public /* synthetic */ void m23258b(Object[] objArr) {
        this.f21960aM.setBackground(this.f21945X.getResources().getDrawable(R.drawable.burst_num_bg_fold_white, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public /* synthetic */ void m23220a(Object[] objArr) {
        this.f21960aM.setBackground(this.f21945X.getResources().getDrawable(R.drawable.burst_num_bg_fold_black, null));
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m23346a(OutPresentation presentationC2959e) {
        this.f22002bc = presentationC2959e;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m23338a(Size size) {
        CameraScreenNail c3445h = this.f21947Z;
        if (c3445h != null) {
            c3445h.m23464a(size, size);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m23350a(IntrinsicsJvm.kt_3 cVar) {
        this.f21985al = cVar;
    }

    public CameraPreviewUI(Activity activity, ComboPreferences comboPreferences, IntrinsicsJvm.kt_4 bVar) {
        boolean z = false;
        this.f21943V = 600.0f;
        this.f21945X = null;
        this.f21946Y = null;
        this.f21984ak = null;
        this.f22006bg = false;
        this.f21945X = activity;
        this.f21946Y = comboPreferences;
        this.f21984ak = bVar;
        Intent intent = new Intent();
        intent.setPackage(f21920g);
        intent.setAction("oplus.intent.action.CLEAR_MAIN_ACTIVITY");
        List<ResolveInfo> listQueryIntentActivities = activity.getPackageManager().queryIntentActivities(intent, 0);
        if (listQueryIntentActivities != null && listQueryIntentActivities.size() > 0) {
            z = true;
        }
        this.f22006bg = z;
        this.f21943V = CameraConfig.getConfigFloatValue(ConfigDataBase.KEY_SIZE_CHANGE_DURATION);
        BackgroundSplitManager.m18430a(this.f21945X).m18441a(this.f21945X, this);
        this.f21944W = this.f21943V;
        CameraLog.m12967f("CameraPreviewUI", "CameraPreviewUI, mbCanUseCleanFunction: " + this.f22006bg + ", mSizeChangeDuration: " + this.f21943V);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m23329a(int OplusGLSurfaceView_13, int i2) {
        this.f21938Q = OplusGLSurfaceView_13;
        this.f21939R = i2;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m23380b(int OplusGLSurfaceView_13, int i2) {
        this.f21940S = OplusGLSurfaceView_13;
        this.f21941T = i2;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m23349a(PreviewEffectProcess interfaceC3423t) {
        RelativeLayout.LayoutParams layoutParams;
        this.f21959aL = (GLRootView) this.f21945X.findViewById(R.id_renamed.gl_root_view);
        if (Util.m24495t()) {
            layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        } else {
            layoutParams = new RelativeLayout.LayoutParams(Util.getScreenWidth(), Util.getScreenHeight());
        }
        this.f21959aL.setLayoutParams(layoutParams);
        this.f21959aL.setContentPane(this.f22018bs);
        m23219a(CameraCharacteristicsUtil.m12974a(this.f21984ak.mo19845cv()), interfaceC3423t);
        this.f21994au = (RelativeLayout) this.f21945X.findViewById(R.id_renamed.camera);
        this.f21976ac = (FaceView) this.f21945X.findViewById(R.id_renamed.face_view);
        this.f21976ac.setDisplayOrientation(this.f21937P);
        this.f21978ae = (MultiFocusView) this.f21945X.findViewById(R.id_renamed.multi_focus_view);
        m23218a(this.f21978ae.getListener());
        this.f21989ap = (PreviewFrameLayout) this.f21945X.findViewById(R.id_renamed.frame_layout);
        this.f21989ap.setOnSizeChangedListener(this);
        this.f21989ap.addOnLayoutChangeListener(this);
        m23352a((FacePointAnimationManager.IntrinsicsJvm.kt_4) this);
        if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_TRACK_FOCUS_SUPPORT)) {
            this.f21977ad = (TrackFocusView) this.f21945X.findViewById(R.id_renamed.track_focus_view);
        }
        InverseManager enumC3227e = InverseManager.INS;
        Activity activity = this.f21945X;
        enumC3227e.setInverseMaskView(activity, (InverseMaskView) activity.findViewById(R.id_renamed.inverse_mask_view));
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public void m23391d() {
        if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_INTELLIGENT_HIGH_FRAME) && this.f21979af == null) {
            this.f21979af = (IntelligentDragView) this.f21945X.getLayoutInflater().inflate(R.layout.view_slow_motion_detect, this.f21989ap).findViewById(R.id_renamed.slow_video_motion_detect_view);
            this.f21979af.setIntelligentGestureListener(this.f22022bw);
        }
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public void m23395e() {
        this.f22031p = false;
        this.f21947Z.m14251g(false);
        this.f21947Z.m23484p();
        GLRootView gLRootView = this.f21959aL;
        if (gLRootView != null) {
            gLRootView.setPreventRenderByPause(false);
            this.f21959aL.mo13794c();
        }
        synchronized (this.f22030o) {
            this.f22041z = false;
            this.f21944W = this.f21943V;
            this.f22024i = this.f22029n;
        }
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    public void m23397f() {
        this.f21997ax = this.f21946Y.getString(CameraUIInterface.KEY_ASSIST_GRADIENTER, "off");
        CameraLog.m12954a("CameraPreviewUI", "onResumeMessage, mAssistGradienterState: " + this.f21997ax);
        m23355a(true);
        m23383b("on".equals(this.f21997ax));
        this.f22003bd = Thread.currentThread();
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    public void m23400g() {
        CameraLog.m12954a("CameraPreviewUI", "releaseTextures");
        synchronized (this.f22030o) {
            if (this.f21959aL != null) {
                this.f21959aL.m14132a(new Runnable() { // from class: com.oplus.camera.ui.preview.COUIBaseListPopupWindow_11.35
                    @Override // java.lang.Runnable
                    public void run() {
                        if (CameraPreviewUI.this.f21947Z != null) {
                            CameraPreviewUI.this.f21947Z.mo14244d();
                        }
                        if (CameraPreviewUI.this.f21948aA != null) {
                            CameraPreviewUI.this.f21948aA.release();
                            CameraPreviewUI.this.f21948aA = null;
                        }
                    }
                });
            }
            if (this.f21947Z != null) {
                this.f21947Z.m14233a(SurfaceTextureScreenNail.IntrinsicsJvm.kt_4.f14252c);
                this.f21947Z.m14233a(SurfaceTextureScreenNail.IntrinsicsJvm.kt_4.f14253d);
                this.f21947Z.m14233a(SurfaceTextureScreenNail.IntrinsicsJvm.kt_4.f14254e);
                this.f21947Z.m14233a(SurfaceTextureScreenNail.IntrinsicsJvm.kt_4.f14255f);
                this.f21999az = null;
                this.f22004be = true;
            }
        }
    }

    /* renamed from: COUIBaseListPopupWindow_10 */
    public void m23404h() {
        CameraLog.m12954a("CameraPreviewUI", "onPause");
        this.f22031p = true;
        this.f22032q = true;
        m23425s();
        FaceView faceView = this.f21976ac;
        if (faceView != null) {
            faceView.m22151b();
        }
        IntelligentDragView intelligentDragView = this.f21979af;
        if (intelligentDragView != null) {
            intelligentDragView.m22168a();
        }
        MultiFocusView multiFocusView = this.f21978ae;
        if (multiFocusView != null) {
            multiFocusView.m22189b();
        }
        TrackFocusView c3432ac = this.f21977ad;
        if (c3432ac != null) {
            c3432ac.m23030h();
        }
        ImageView imageView = this.f21993at;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
        GLRootView gLRootView = this.f21959aL;
        if (gLRootView != null) {
            gLRootView.setAlpha(1.0f);
        }
        Bitmap bitmap = this.f21995av;
        if (bitmap != null) {
            bitmap.recycle();
            this.f21995av = null;
        }
        this.f21947Z.m23481n(true);
        m23418o();
        m23292r(false);
        this.f22035t = false;
        this.f22036u = false;
        this.f22017br.removeCallbacksAndMessages(null);
        Runnable runnable = this.f22016bq;
        if (runnable != null) {
            runnable.run();
        }
        m23400g();
        IntrinsicsJvm.kt_4 bVar = this.f21984ak;
        if (bVar != null) {
            bVar.mo19934eh();
        }
        GLRootView gLRootView2 = this.f21959aL;
        if (gLRootView2 != null) {
            gLRootView2.mo13795d();
        }
        m23223aB();
        GradienterAssistView c3453p = this.f21991ar;
        if (c3453p != null) {
            c3453p.m23773b();
        }
    }

    /* renamed from: OplusGLSurfaceView_13 */
    public void m23406i() {
        GLRootView gLRootView = this.f21959aL;
        if (gLRootView != null) {
            gLRootView.setBackgroundColor(-16777216);
        }
        CameraScreenNail c3445h = this.f21947Z;
        if (c3445h != null) {
            c3445h.m14252h(false);
        }
    }

    /* renamed from: OplusGLSurfaceView_15 */
    public void m23408j() {
        CameraLog.m12954a("CameraPreviewUI", "onDestroy");
        m23410k();
        this.f21974aa = null;
        this.f21945X = null;
        this.f21986am = null;
        this.f21975ab = null;
        this.f21959aL = null;
        MultiCameraTypeSelectLayout c3518a = this.f21966aS;
        if (c3518a != null) {
            c3518a.m24085a();
        }
        FaceView faceView = this.f21976ac;
        if (faceView != null) {
            faceView.m22154e();
            this.f21976ac = null;
        }
        if (this.f21977ad != null) {
            this.f21977ad = null;
        }
        MultiFocusView multiFocusView = this.f21978ae;
        if (multiFocusView != null) {
            multiFocusView.m22192e();
            this.f21978ae = null;
        }
        PreviewFrameLayout previewFrameLayout = this.f21989ap;
        if (previewFrameLayout != null) {
            previewFrameLayout.removeAllViewsInLayout();
            this.f21989ap.removeAllViews();
            this.f21989ap = null;
        }
    }

    /* renamed from: OplusGLSurfaceView_5 */
    public void m23410k() {
        CameraScreenNail c3445h = this.f21947Z;
        if (c3445h != null) {
            c3445h.m23486q();
        }
        GLRootView gLRootView = this.f21959aL;
        if (gLRootView != null) {
            gLRootView.m13797f();
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m23348a(GLProducerRender abstractC3285j) {
        this.f21947Z.mo14236a((GLCanvas) null, abstractC3285j, m23245au(), m23246av(), m23247aw(), m23248ax());
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m23355a(boolean z) {
        IntrinsicsJvm.kt_4 bVar = this.f21984ak;
        if (bVar != null) {
            if (z && bVar.mo19966j(CameraUIInterface.KEY_ASSISTANT_LINE) && (this.f21984ak.mo19882dZ() || !this.f21984ak.mo19881dY())) {
                m23242ar();
                float fMo19927ea = this.f21984ak.mo19927ea();
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f21992as.getLayoutParams();
                if (1.0f > fMo19927ea && !Util.m24498u()) {
                    float right = this.f21989ap.getRight() - this.f21989ap.getLeft();
                    int OplusGLSurfaceView_13 = (int) ((right - (fMo19927ea * right)) / 2.0f);
                    layoutParams.leftMargin = OplusGLSurfaceView_13;
                    layoutParams.rightMargin = OplusGLSurfaceView_13;
                } else {
                    layoutParams.leftMargin = 0;
                    layoutParams.rightMargin = 0;
                }
                this.f21992as.setLayoutParams(layoutParams);
                this.f21992as.m23816a(this.f21984ak.mo19901ds());
                return;
            }
            GuideLineView c3455r = this.f21992as;
            if (c3455r != null) {
                c3455r.m23817a(this.f21984ak.mo19881dY());
            }
        }
    }

    /* renamed from: ar */
    private void m23242ar() {
        if (this.f21992as == null) {
            this.f21992as = new GuideLineView(this.f21945X);
            this.f21992as.setForceDarkAllowed(false);
            this.f21992as.setVisibility(8);
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
            PreviewFrameLayout previewFrameLayout = this.f21989ap;
            previewFrameLayout.addView(this.f21992as, previewFrameLayout.indexOfChild(this.f21991ar), layoutParams);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m23383b(boolean z) {
        if (z && this.f21984ak.mo19966j(CameraUIInterface.KEY_ASSIST_GRADIENTER) && "on".equals(this.f21997ax)) {
            m23243as();
            this.f21991ar.setViewLayoutType(this.f21984ak.mo19917eE());
            this.f21991ar.m23772a();
        } else {
            GradienterAssistView c3453p = this.f21991ar;
            if (c3453p != null) {
                c3453p.m23773b();
            }
        }
    }

    /* renamed from: as */
    private void m23243as() {
        if (this.f21991ar == null) {
            CameraLog.m12952a("initGradienterAssistView");
            this.f21991ar = new GradienterAssistView(this.f21945X);
            this.f21991ar.setForceDarkAllowed(false);
            this.f21991ar.setVisibility(8);
            this.f21991ar.setOnAdjustedListener(new GradienterAssistView.IntrinsicsJvm.kt_4() { // from class: com.oplus.camera.ui.preview.COUIBaseListPopupWindow_11.36
                @Override // com.oplus.camera.p172ui.preview.GradienterAssistView.IntrinsicsJvm.kt_4
                /* renamed from: PlatformImplementations.kt_3 */
                public void mo23434a() {
                    if (CameraPreviewUI.this.f21984ak != null) {
                        CameraPreviewUI.this.f21984ak.mo19902dt();
                    }
                }
            });
            this.f21989ap.addView(this.f21991ar, new ViewGroup.LayoutParams(-1, -1));
            CameraLog.m12958b("initGradienterAssistView");
        }
    }

    /* renamed from: OplusGLSurfaceView_14 */
    public boolean m23413l() {
        GradienterAssistView c3453p = this.f21991ar;
        if (c3453p != null) {
            return c3453p.m23774c();
        }
        return false;
    }

    /* renamed from: OplusGLSurfaceView_6 */
    public String m23414m() {
        GradienterAssistView c3453p = this.f21991ar;
        return c3453p != null ? c3453p.getOrientation() : "";
    }

    /* renamed from: OplusGLSurfaceView_11 */
    public void m23416n() {
        if (this.f21994au != null && this.f21960aM == null) {
            if (1 == this.f21984ak.mo18134aX() || 4 == this.f21984ak.mo18134aX()) {
                this.f21960aM = this.f21984ak.mo19936ej().mo16550a(this.f21945X, this.f21994au, this.f21935N);
            } else {
                this.f21945X.getLayoutInflater().inflate(R.layout.burst, this.f21994au);
                this.f21960aM = (RotableTextView) this.f21945X.findViewById(R.id_renamed.burst_num_view);
                ((RelativeLayout.LayoutParams) this.f21960aM.getLayoutParams()).addRule(2, R.id_renamed.control_panel_layout);
            }
            RotableTextView rotableTextView = this.f21960aM;
            if (rotableTextView != null) {
                rotableTextView.setTypeface(Util.m24473l(this.f21945X));
                this.f21960aM.m18344a(this.f21982ai, false);
                this.f21960aM.setVisibility(8);
                this.f21973aZ = this.f21945X.getResources().getDimensionPixelSize(R.dimen.face_beauty_enter_button_animation_y);
            }
        }
    }

    /* renamed from: o */
    public void m23418o() {
        RotableTextView rotableTextView;
        RelativeLayout relativeLayout = this.f21994au;
        if (relativeLayout == null || (rotableTextView = this.f21960aM) == null) {
            return;
        }
        relativeLayout.removeView(rotableTextView);
        this.f21960aM = null;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m23331a(int OplusGLSurfaceView_13, boolean z, boolean z2) {
        m23416n();
        RotableTextView rotableTextView = this.f21960aM;
        if (rotableTextView != null) {
            if (OplusGLSurfaceView_13 < 10) {
                rotableTextView.setText(Util.m24474l(0) + Util.m24474l(OplusGLSurfaceView_13));
            } else {
                rotableTextView.setText(Util.m24474l(OplusGLSurfaceView_13));
            }
            if (1 == OplusGLSurfaceView_13) {
                CameraPerformance.m15185a("continuous_capture");
            } else if (Util.f22996d == OplusGLSurfaceView_13) {
                CameraPerformance.m15188b("continuous_capture");
            }
            if (z) {
                if (this.f21960aM.isShown()) {
                    return;
                }
                ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.f21960aM, "alpha", 0.0f, 1.0f);
                objectAnimatorOfFloat.setInterpolator(this.f22027l);
                objectAnimatorOfFloat.setDuration(400L);
                this.f21972aY = new AnimatorSet();
                AnimatorSet.Builder builderPlay = this.f21972aY.play(objectAnimatorOfFloat);
                if (z2) {
                    ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.f21960aM, "translationY", this.f21973aZ, 0.0f);
                    objectAnimatorOfFloat2.setInterpolator(this.f22028m);
                    objectAnimatorOfFloat2.setDuration(400L);
                    builderPlay.with(objectAnimatorOfFloat2);
                    this.f21972aY.setStartDelay(100L);
                } else {
                    this.f21960aM.setTranslationY(0.0f);
                }
                this.f21972aY.addListener(new AnimatorListenerAdapter() { // from class: com.oplus.camera.ui.preview.COUIBaseListPopupWindow_11.2
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                        if (CameraPreviewUI.this.f21960aM != null) {
                            CameraPreviewUI.this.f21960aM.setAlpha(0.0f);
                            CameraPreviewUI.this.f21960aM.setVisibility(0);
                        }
                    }

                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        if (CameraPreviewUI.this.f21960aM != null) {
                            CameraPreviewUI.this.f21960aM.setAlpha(1.0f);
                            CameraPreviewUI.this.f21960aM.setTranslationY(0.0f);
                            CameraPreviewUI.this.f21960aM.setVisibility(0);
                        }
                    }
                });
                this.f21972aY.start();
                return;
            }
            this.f21960aM.setVisibility(0);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m23357a(boolean z, boolean z2) {
        RotableTextView rotableTextView = this.f21960aM;
        if (rotableTextView == null) {
            return;
        }
        if (z) {
            if (rotableTextView.isShown()) {
                ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.f21960aM, "alpha", 1.0f, 0.0f);
                objectAnimatorOfFloat.setInterpolator(this.f22027l);
                objectAnimatorOfFloat.setDuration(250L);
                this.f21971aX = new AnimatorSet();
                AnimatorSet.Builder builderPlay = this.f21971aX.play(objectAnimatorOfFloat);
                if (z2) {
                    ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.f21960aM, "translationY", 0.0f, this.f21973aZ);
                    objectAnimatorOfFloat2.setInterpolator(this.f22028m);
                    objectAnimatorOfFloat2.setDuration(400L);
                    builderPlay.with(objectAnimatorOfFloat2);
                } else {
                    this.f21960aM.setTranslationY(0.0f);
                }
                this.f21971aX.addListener(new AnimatorListenerAdapter() { // from class: com.oplus.camera.ui.preview.COUIBaseListPopupWindow_11.3
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                        if (CameraPreviewUI.this.f21960aM != null) {
                            CameraPreviewUI.this.f21960aM.setVisibility(0);
                        }
                    }

                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        if (CameraPreviewUI.this.f21960aM != null) {
                            CameraPreviewUI.this.f21960aM.setText((CharSequence) null);
                            CameraPreviewUI.this.f21960aM.setAlpha(1.0f);
                            CameraPreviewUI.this.f21960aM.setTranslationY(0.0f);
                            CameraPreviewUI.this.f21960aM.setVisibility(8);
                        }
                    }
                });
                this.f21971aX.start();
                return;
            }
            return;
        }
        rotableTextView.setText((CharSequence) null);
        this.f21960aM.setVisibility(8);
    }

    /* renamed from: p */
    public void m23420p() {
        Activity activity;
        if (this.f21994au == null || this.f21961aN != null || (activity = this.f21945X) == null) {
            return;
        }
        activity.runOnUiThread(new Runnable() { // from class: com.oplus.camera.ui.preview.COUIBaseListPopupWindow_11.4
            @Override // java.lang.Runnable
            public void run() throws Resources.NotFoundException {
                if (CameraPreviewUI.this.f21961aN != null) {
                    return;
                }
                CameraPreviewUI viewOnLayoutChangeListenerC3444g = CameraPreviewUI.this;
                viewOnLayoutChangeListenerC3444g.f21961aN = new RotableViewWithText(viewOnLayoutChangeListenerC3444g.f21945X);
                int dimensionPixelSize = CameraPreviewUI.this.f21945X.getResources().getDimensionPixelSize(R.dimen.omoji_no_face_view_size);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize);
                layoutParams.addRule(14);
                layoutParams.addRule(10);
                layoutParams.topMargin = Util.m24186N() + CameraPreviewUI.this.f21945X.getResources().getDimensionPixelSize(R.dimen.omoji_no_face_view_margin_topbar);
                CameraPreviewUI.this.f21961aN.setImage(BitmapFactory.decodeResource(CameraPreviewUI.this.f21945X.getResources(), R.drawable.no_face_detect));
                CameraPreviewUI.this.f21961aN.setText(CameraPreviewUI.this.f21945X.getResources().getString(R.string.camera_omoji_no_faces));
                CameraPreviewUI.this.f21961aN.setViewGap(CameraPreviewUI.this.f21945X.getResources().getDimensionPixelSize(R.dimen.omoji_no_face_view_gap));
                CameraPreviewUI.this.f21994au.addView(CameraPreviewUI.this.f21961aN, layoutParams);
                CameraPreviewUI.this.f21961aN.m23913a(CameraPreviewUI.this.f21982ai, false);
                CameraPreviewUI.this.f21961aN.setVisibility(8);
            }
        });
    }

    /* renamed from: q */
    public void m23422q() {
        m23420p();
        Handler handler = this.f22017br;
        if (handler != null) {
            handler.removeMessages(3);
            this.f22017br.sendEmptyMessage(3);
        }
    }

    /* renamed from: r */
    public void m23424r() {
        Handler handler = this.f22017br;
        if (handler != null) {
            handler.removeMessages(4);
            this.f22017br.sendEmptyMessage(4);
        }
    }

    /* renamed from: s */
    public void m23425s() {
        RotableViewWithText c3467t;
        RelativeLayout relativeLayout = this.f21994au;
        if (relativeLayout == null || (c3467t = this.f21961aN) == null) {
            return;
        }
        relativeLayout.removeView(c3467t);
        this.f21961aN = null;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m23335a(Bitmap bitmap) {
        ImageView imageView;
        m23355a(false);
        m23383b(false);
        if (this.f21986am == null) {
            this.f21986am = m23210a(this.f21989ap);
        }
        if (bitmap == null || (imageView = this.f21986am) == null) {
            return;
        }
        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        this.f21986am.setImageBitmap(bitmap);
        this.f21986am.setVisibility(0);
    }

    /* renamed from: t */
    public void m23426t() {
        ImageView imageView = this.f21986am;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
        this.f21947Z.m23481n(true);
        m23355a(true);
        m23383b(true);
    }

    /* renamed from: u */
    public boolean m23427u() {
        ImageView imageView = this.f21986am;
        if (imageView != null) {
            return imageView.isShown();
        }
        return false;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private ImageView m23210a(ViewGroup viewGroup) {
        ImageView imageView = new ImageView(this.f21945X);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
        imageView.setVisibility(8);
        imageView.setBackgroundColor(-16777216);
        viewGroup.addView(imageView, layoutParams);
        return imageView;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m23381b(Bitmap bitmap) {
        if (this.f21986am == null) {
            this.f21986am = m23210a(this.f21989ap);
        }
        this.f21986am.setScaleType(ImageView.ScaleType.FIT_START);
        if (bitmap != null) {
            CameraLog.m12954a("CameraPreviewUI", "showVideoAlert, mRecordingOrientation: " + this.f21983aj);
            this.f21986am.setImageBitmap(Util.m24222a(bitmap, -this.f21983aj, false));
            this.f21986am.setVisibility(0);
        }
    }

    /* renamed from: v */
    public void m23428v() {
        this.f21986am.setVisibility(8);
    }

    /* renamed from: w */
    public Size m23429w() {
        Size size;
        synchronized (this.f22030o) {
            size = this.f21998ay;
        }
        return size;
    }

    /* renamed from: x */
    public CameraScreenNail m23430x() {
        return this.f21947Z;
    }

    /* renamed from: y */
    public RelativeLayout m23431y() {
        return this.f21989ap;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m23351a(CameraScreenNail.IntrinsicsJvm.kt_5 dVar) {
        this.f21958aK = dVar;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m23379b(int OplusGLSurfaceView_13) {
        synchronized (this.f22030o) {
            this.f21981ah = OplusGLSurfaceView_13;
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m23388c(int OplusGLSurfaceView_13) {
        this.f21982ai = OplusGLSurfaceView_13;
        RotableTextView rotableTextView = this.f21960aM;
        if (rotableTextView != null) {
            rotableTextView.m18344a(OplusGLSurfaceView_13, true);
        }
        FaceView faceView = this.f21976ac;
        if (faceView != null) {
            faceView.m22144a(OplusGLSurfaceView_13, false);
        }
        IntelligentDragView intelligentDragView = this.f21979af;
        if (intelligentDragView != null) {
            intelligentDragView.m22169a(OplusGLSurfaceView_13, false);
        }
        RotableViewWithText c3467t = this.f21961aN;
        if (c3467t != null) {
            c3467t.m23913a(OplusGLSurfaceView_13, true);
        }
        MultiCameraTypeSelectLayout c3518a = this.f21966aS;
        if (c3518a != null) {
            c3518a.m24086a(OplusGLSurfaceView_13, true);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public void m23392d(int OplusGLSurfaceView_13) {
        this.f21937P = OplusGLSurfaceView_13;
        CameraScreenNail c3445h = this.f21947Z;
        if (c3445h != null) {
            c3445h.m14242c(OplusGLSurfaceView_13);
        }
        FaceView faceView = this.f21976ac;
        if (faceView != null) {
            faceView.setDisplayOrientation(OplusGLSurfaceView_13);
        }
        TrackFocusView c3432ac = this.f21977ad;
        if (c3432ac != null) {
            c3432ac.setDisplayOrientation(OplusGLSurfaceView_13);
        }
        MultiFocusView multiFocusView = this.f21978ae;
        if (multiFocusView != null) {
            multiFocusView.setDisplayOrientation(OplusGLSurfaceView_13);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m23343a(SurfaceTextureScreenNail.IntrinsicsJvm.kt_4 bVar, boolean z, boolean z2, String str) {
        CameraScreenNail c3445h = this.f21947Z;
        if (c3445h != null) {
            c3445h.m14230a(bVar, z, z2, str);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m23389c(boolean z) {
        CameraScreenNail c3445h = this.f21947Z;
        if (c3445h != null) {
            c3445h.m14234a(z);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public void m23393d(boolean z) {
        CameraScreenNail c3445h = this.f21947Z;
        if (c3445h != null) {
            c3445h.m14240b(z);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m23330a(int OplusGLSurfaceView_13, long OplusGLSurfaceView_15, long j2) {
        CameraScreenNail c3445h = this.f21947Z;
        if (c3445h != null) {
            c3445h.m14221a(OplusGLSurfaceView_13, OplusGLSurfaceView_15, j2);
        }
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public long m23394e(int OplusGLSurfaceView_13) {
        CameraScreenNail c3445h = this.f21947Z;
        if (c3445h != null) {
            return c3445h.m14237b(OplusGLSurfaceView_13);
        }
        return 0L;
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public void m23396e(boolean z) {
        FaceView faceView = this.f21976ac;
        if (faceView != null) {
            faceView.setMirror(z);
        }
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    public void m23399f(boolean z) {
        this.f22025j = z;
        if (this.f22025j) {
            this.f22026k = this.f21984ak.mo19844cu();
            m23314O().setRenderMode(0);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m23337a(Rect rect, Size size) {
        FaceView faceView = this.f21976ac;
        if (faceView != null) {
            faceView.m22145a(rect, size);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m23336a(Rect rect, Rect rect2, Size size) {
        TrackFocusView c3432ac = this.f21977ad;
        if (c3432ac != null) {
            c3432ac.m23021a(rect, rect2, size, m23429w());
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m23327a(float COUIBaseListPopupWindow_12) {
        FaceView faceView = this.f21976ac;
        if (faceView != null) {
            faceView.setEISScale(COUIBaseListPopupWindow_12);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m23378b(float COUIBaseListPopupWindow_12) {
        FaceView faceView = this.f21976ac;
        if (faceView != null) {
            faceView.setZoomValue(COUIBaseListPopupWindow_12);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m23387c(float COUIBaseListPopupWindow_12) {
        FaceView faceView = this.f21976ac;
        if (faceView != null) {
            faceView.setFaceSlenderZoomValue(COUIBaseListPopupWindow_12);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m23359a(Face[] faceArr, int[] iArr) {
        MultiFocusView multiFocusView;
        if (this.f21976ac != null) {
            if (!this.f21947Z.m23483o() || this.f21947Z.m14258l() || ((multiFocusView = this.f21978ae) != null && multiFocusView.m22188a())) {
                if (this.f21976ac.m22150a()) {
                    m23301A();
                }
                m23402g(false);
            } else {
                this.f21976ac.m22147a(this.f21984ak.mo19928eb(), this.f21984ak.mo19927ea());
                this.f21976ac.m22149a(faceArr, iArr);
            }
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m23358a(int[] iArr) {
        if (this.f21978ae != null) {
            if (this.f21976ac.m22155f() && this.f22036u) {
                this.f21978ae.m22187a(iArr, m23429w());
            } else {
                this.f21978ae.m22189b();
            }
        }
    }

    /* renamed from: z */
    public void m23432z() {
        CameraScreenNail c3445h = this.f21947Z;
        if (c3445h != null) {
            c3445h.m23494y();
        }
    }

    /* renamed from: A */
    public void m23301A() {
        FaceView faceView = this.f21976ac;
        if (faceView != null) {
            faceView.m22151b();
            m23402g(true);
        }
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    public void m23402g(boolean z) {
        FaceView faceView = this.f21976ac;
        if (faceView != null) {
            faceView.m22146a(z);
        }
    }

    /* renamed from: B */
    public void m23302B() {
        MultiFocusView multiFocusView = this.f21978ae;
        if (multiFocusView != null) {
            multiFocusView.m22189b();
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m23219a(boolean z, PreviewEffectProcess interfaceC3423t) {
        if (this.f21947Z == null) {
            this.f21947Z = new CameraScreenNail(this.f21945X, this, z);
            this.f21947Z.m23468a(this.f21958aK);
            this.f21947Z.m14242c(this.f21937P);
            this.f21947Z.m14232a(interfaceC3423t);
            this.f21947Z.m23467a(new CameraScreenNail.IntrinsicsJvm.kt_4() { // from class: com.oplus.camera.ui.preview.COUIBaseListPopupWindow_11.5
                @Override // com.oplus.camera.p172ui.preview.CameraScreenNail.IntrinsicsJvm.kt_4
                /* renamed from: PlatformImplementations.kt_3 */
                public boolean mo23436a() {
                    if (CameraPreviewUI.this.f21984ak != null) {
                        return CameraPreviewUI.this.f21984ak.mo19742bB();
                    }
                    return false;
                }

                @Override // com.oplus.camera.p172ui.preview.CameraScreenNail.IntrinsicsJvm.kt_4
                /* renamed from: PlatformImplementations.kt_3 */
                public float mo23435a(float COUIBaseListPopupWindow_12) {
                    if (CameraPreviewUI.this.f21984ak != null) {
                        return CameraPreviewUI.this.f21984ak.mo19645a(COUIBaseListPopupWindow_12);
                    }
                    return 0.0f;
                }

                @Override // com.oplus.camera.p172ui.preview.CameraScreenNail.IntrinsicsJvm.kt_4
                /* renamed from: IntrinsicsJvm.kt_4 */
                public void mo23437b() {
                    if (CameraPreviewUI.this.f21984ak != null) {
                        CameraPreviewUI.this.f21984ak.mo19743bC();
                    }
                }
            });
        }
        this.f21947Z.m14227a(this.f21959aL);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public boolean m23385b(Size size) {
        synchronized (this.f22030o) {
            CameraLog.m12954a("CameraPreviewUI", "updateSurfaceTexture, previewSize: " + size.getWidth() + "x" + size.getHeight() + ", mbNeedAcquireTexture: " + this.f22004be);
            this.f21998ay = size;
            mo22202a(size.getWidth(), size.getHeight(), size.getWidth(), size.getHeight());
            int iF = this.f21947Z.m14248f();
            int iG = this.f21947Z.m14250g();
            if (!this.f22031p) {
                this.f21947Z.m23480n();
                if (this.f22004be) {
                    m23253b(-1, -1, size.getWidth(), size.getHeight());
                    this.f21947Z.mo14245d(this.f21984ak.mo19845cv() == 0);
                    this.f21999az = this.f21947Z.m14241c();
                    if (this.f21999az != null) {
                        this.f21948aA = new Surface(this.f21999az);
                    }
                    this.f22004be = false;
                } else {
                    m23253b(iF, iG, size.getWidth(), size.getHeight());
                }
                this.f21947Z.m14246e();
                if (this.f21999az != null) {
                    this.f21999az.setDefaultBufferSize(size.getWidth(), size.getHeight());
                }
                return true;
            }
            CameraLog.m12954a("CameraPreviewUI", "updateSurfaceTexture, Activity already pause. Avoid 0x502.");
            return false;
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m23353a(OplusViewOutlineProvider c3464q) {
        if (this.f21959aL != null) {
            CameraLog.m12954a("CameraPreviewUI", "setOutlineProvider, outlineProvider: " + c3464q);
            if (c3464q != null) {
                this.f21959aL.setClipToOutline(true);
            } else {
                this.f21959aL.setClipToOutline(false);
            }
            this.f21959aL.setOutlineProvider(c3464q);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m23341a(final Size size, boolean z) {
        Activity activity;
        CameraLog.m12954a("CameraPreviewUI", "updatePreviewSize, previewSize: " + size.getWidth() + "x" + size.getHeight() + ", layoutPreview: " + z);
        m23385b(size);
        if (Thread.currentThread() != this.f22003bd && (activity = this.f21945X) != null) {
            activity.runOnUiThread(new Runnable() { // from class: com.oplus.camera.ui.preview.COUIBaseListPopupWindow_11.6
                @Override // java.lang.Runnable
                public void run() {
                    CameraPreviewUI.this.m23263c(size);
                }
            });
        } else {
            m23263c(size);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private void m23253b(int OplusGLSurfaceView_13, int i2, int i3, int i4) {
        if (this.f21937P % 180 != 0) {
            i4 = i3;
            i3 = i4;
        }
        if (OplusGLSurfaceView_13 == i3 && i2 == i4) {
            return;
        }
        this.f21947Z.mo14220a(i3, i4);
    }

    /* renamed from: C */
    public void m23303C() {
        m23263c(Util.m24180I());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m23263c(Size size) {
        View childAt;
        if (this.f21945X == null || this.f21984ak == null) {
            CameraLog.m12954a("CameraPreviewUI", "layoutPreviewFrameToPreviewSize, mActivity is null");
            return;
        }
        CameraScreenNail c3445h = this.f21947Z;
        boolean z = true;
        if (c3445h != null) {
            if (size == null) {
                Size size2 = new Size(c3445h.m14250g(), this.f21947Z.m14248f());
                CameraLog.m12967f("CameraPreviewUI", "layoutPreviewFrameToPreviewSize, previewSize: " + size2);
                size = size2;
            }
            this.f21947Z.m14243c(Util.m24169C() && this.f21984ak.mo19966j(CameraUIInterface.KEY_VIDEO_EIS));
        }
        if (this.f21989ap != null) {
            RelativeLayout.LayoutParams layoutParamsMo19909e = this.f21984ak.mo19909e(size);
            if (layoutParamsMo19909e == null) {
                if (size.getWidth() != 0 && size.getWidth() == size.getHeight() && this.f21984ak.mo19839cp()) {
                    layoutParamsMo19909e = new RelativeLayout.LayoutParams(-1, Util.getScreenWidth());
                    layoutParamsMo19909e.topMargin = Util.m24498u() ? 0 : Util.m24186N() + Util.m24184L();
                    layoutParamsMo19909e.bottomMargin = Util.m24498u() ? 0 : Util.getScreenHeight() - ((Util.m24186N() + Util.m24184L()) + Util.getScreenWidth());
                } else {
                    boolean z2 = Math.abs((((double) size.getWidth()) / ((double) size.getHeight())) - 1.3333333333333333d) > 0.01d;
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
                    if (!z2) {
                        int width = size.getWidth();
                        int height = size.getHeight();
                        float COUIBaseListPopupWindow_12 = height / width;
                        if ((((double) width) / ((double) height)) - 1.0d == 0.0d) {
                            layoutParams.topMargin = Util.m24498u() ? 0 : Util.m24186N() + Util.m24184L();
                            layoutParams.height = Util.m24498u() ? 0 : Util.m24186N() + Util.m24184L() + Util.getScreenWidth();
                        } else {
                            layoutParams.topMargin = Util.m24498u() ? 0 : Util.m24186N();
                            layoutParams.bottomMargin = Util.m24498u() ? 0 : (int) ((Util.getScreenHeight() - Util.m24186N()) - (Util.getScreenWidth() / COUIBaseListPopupWindow_12));
                        }
                    } else if (Math.abs((size.getWidth() / size.getHeight()) - 1.5d) < 0.01d) {
                        int width2 = size.getWidth();
                        int height2 = size.getHeight();
                        if (this.f21937P % 180 != 0) {
                            width2 = size.getHeight();
                            height2 = size.getWidth();
                        }
                        float screenWidth = width2 != 0 ? Util.getScreenWidth() / width2 : 1.0f;
                        layoutParamsMo19909e = screenWidth != (height2 != 0 ? ((float) Util.m24193U()) / ((float) height2) : 1.0f) ? new RelativeLayout.LayoutParams((int) (width2 * screenWidth), (int) (height2 * screenWidth)) : layoutParams;
                        layoutParamsMo19909e.addRule(10);
                        layoutParamsMo19909e.topMargin = Util.m24186N();
                    } else {
                        int iM24426d = Util.m24426d(size.getWidth(), size.getHeight());
                        String strMo19768bg = this.f21984ak.mo19768bg();
                        if (!this.f21984ak.mo19881dY() && (!this.f21984ak.mo19839cp() || 1 == iM24426d)) {
                            layoutParams.topMargin = Util.m24186N();
                            float width3 = size.getWidth() / size.getHeight();
                            if (Util.m24495t()) {
                                layoutParams.topMargin = Util.m24498u() ? 0 : (Util.m24186N() / 2) - Util.m24185M();
                            }
                            layoutParams.bottomMargin = Util.m24498u() ? 0 : (int) ((Util.getScreenHeight() - layoutParams.topMargin) - (Util.getScreenWidth() * width3));
                        } else if (ApsConstant.CAPTURE_MODE_XPAN.equals(strMo19768bg) || (strMo19768bg.isEmpty() && this.f21984ak.mo19880dX())) {
                            layoutParams.topMargin = Math.round((Util.getScreenHeight() * 0.13f) / 2.0f);
                            layoutParams.bottomMargin = Math.round((Util.getScreenHeight() * 0.13f) / 2.0f);
                            layoutParams.leftMargin = Math.round((Util.getScreenWidth() * 0.13f) / 2.0f);
                            layoutParams.rightMargin = Math.round((Util.getScreenWidth() * 0.13f) / 2.0f);
                        }
                    }
                    layoutParamsMo19909e = layoutParams;
                }
            }
            IntrinsicsJvm.kt_3 cVar = this.f21985al;
            if (cVar != null) {
                cVar.mo22995a(layoutParamsMo19909e);
            }
            this.f21990aq = layoutParamsMo19909e;
            this.f21989ap.setLayoutParams(this.f21990aq);
            CameraLog.m12959b("CameraPreviewUI", "layoutPreviewFrameToPreviewSize, params.width: " + layoutParamsMo19909e.width + ", params.height: " + layoutParamsMo19909e.height + ", params.leftMargin" + layoutParamsMo19909e.leftMargin + ", params.topMargin: " + layoutParamsMo19909e.topMargin + ", params.rightMargin: " + layoutParamsMo19909e.rightMargin + ", params.bottomMargin: " + layoutParamsMo19909e.bottomMargin);
            Activity activity = this.f21945X;
            if (activity != null && (childAt = ((ViewGroup) activity.getWindow().getDecorView()).getChildAt(0)) != null) {
                childAt.requestLayout();
            }
            synchronized (this.f22030o) {
                IntrinsicsJvm.kt_4 bVar = this.f21984ak;
                int width4 = this.f21989ap.getWidth();
                int height3 = this.f21989ap.getHeight();
                if (this.f21957aJ) {
                    z = false;
                }
                bVar.mo19656a(width4, height3, z);
            }
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private ImageView m23252b(ViewGroup viewGroup) {
        ImageView imageView = new ImageView(this.f21945X);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
        imageView.setVisibility(8);
        viewGroup.addView(imageView, layoutParams);
        return imageView;
    }

    /* renamed from: COUIBaseListPopupWindow_10 */
    public void m23405h(boolean z) {
        IntrinsicsJvm.kt_4 bVar;
        int width = this.f21989ap.getWidth();
        int height = this.f21989ap.getHeight();
        boolean z2 = Math.abs((((double) Math.max(width, height)) / ((double) Math.min(width, height))) - 1.3333333333333333d) <= 0.01d;
        if (z && (bVar = this.f21984ak) != null && bVar.mo19966j(CameraFunction.ID_PHOTO) && z2) {
            if (this.f21965aR == null) {
                this.f21965aR = new ImageView(this.f21945X);
                this.f21965aR.setForegroundGravity(48);
                if (this.f21984ak.mo19845cv() == 0) {
                    this.f21965aR.setImageResource(R.drawable.id_photo_guide_puzzle_rear);
                } else {
                    this.f21965aR.setImageResource(R.drawable.id_photo_guide_puzzle_front);
                }
                this.f21989ap.addView(this.f21965aR, new ViewGroup.LayoutParams(-1, -1));
                return;
            }
            return;
        }
        ImageView imageView = this.f21965aR;
        if (imageView != null) {
            this.f21989ap.removeView(imageView);
            this.f21965aR = null;
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public static void m23262c(Bitmap bitmap) {
        f21921h = bitmap;
    }

    /* renamed from: D */
    public static Bitmap m23184D() {
        return f21921h;
    }

    /* renamed from: E */
    public void m23304E() {
        Bitmap bitmapM23184D = m23184D();
        if (bitmapM23184D != null) {
            CameraLog.m12952a("coverBlurView");
            if (this.f21988ao == null) {
                this.f21988ao = new ImageView(this.f21945X);
                this.f21988ao.setScaleType(ImageView.ScaleType.CENTER_CROP);
                this.f21988ao.setVisibility(0);
            }
            CameraLog.m12954a("CameraPreviewUI", "coverBlurView, mBlurCover: " + this.f21988ao);
            this.f21988ao.setImageBitmap(bitmapM23184D);
            this.f21988ao.setAlpha(1.0f);
            if (90 != this.f21937P) {
                this.f21988ao.setRotation(((r2 - 90) + 360) % 360);
            } else {
                this.f21988ao.setRotation(0.0f);
            }
            this.f21988ao.clearAnimation();
            this.f21989ap.setClipChildren(true);
            if (this.f21989ap.indexOfChild(this.f21988ao) < 0) {
                this.f21989ap.addView(this.f21988ao, new ViewGroup.LayoutParams(-1, -1));
            }
            double height = (bitmapM23184D.getHeight() * 1.0d) / bitmapM23184D.getWidth();
            if (BackgroundUtil.f23060a && this.f21987an == null && (1.0d == height || 1.3333333333333333d == height || 1.7777777777777777d == height)) {
                this.f21987an = new BlurCoverBg(this.f21945X);
                if (1.0d == height) {
                    this.f21987an.m23180a(Util.m24184L(), Util.getScreenWidth());
                } else if (1.3333333333333333d == height) {
                    this.f21987an.m23180a(0, (int) (Util.getScreenWidth() * 1.3333333333333333d));
                } else {
                    this.f21987an.m23180a(0, (int) (Util.getScreenWidth() * 1.7777777777777777d));
                }
                this.f21987an.setDrawColor(BackgroundUtil.m24523a(-16777216));
                this.f21994au.addView(this.f21987an, this.f21994au.indexOfChild(this.f21959aL) + 1, new ViewGroup.LayoutParams(-1, -1));
            }
            CameraLog.m12958b("coverBlurView");
        }
    }

    /* renamed from: F */
    public void m23305F() {
        CameraLog.m12954a("CameraPreviewUI", "hideBlurView, mBlurCover: " + this.f21988ao);
        if (this.f21988ao != null) {
            CameraLog.m12952a("CameraStartupPerformance.hideBlurView");
            PreviewFrameLayout previewFrameLayout = this.f21989ap;
            if (previewFrameLayout != null) {
                previewFrameLayout.removeView(this.f21988ao);
                this.f21989ap.setClipChildren(false);
            }
            BlurCoverBg c3442e = this.f21987an;
            if (c3442e != null) {
                this.f21994au.removeView(c3442e);
                this.f21987an = null;
            }
            CameraLog.m12958b("CameraStartupPerformance.hideBlurView");
        }
    }

    /* renamed from: G */
    public ImageView m23306G() {
        return this.f21988ao;
    }

    /* renamed from: H */
    public float m23307H() {
        float COUIBaseListPopupWindow_12;
        synchronized (this.f22030o) {
            COUIBaseListPopupWindow_12 = this.f21944W;
        }
        return COUIBaseListPopupWindow_12;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: at */
    public void m23244at() {
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setDuration(10L);
        alphaAnimation.setAnimationListener(this.f22020bu);
        if (this.f21993at == null) {
            this.f21993at = m23252b(this.f21989ap);
        }
        this.f21993at.startAnimation(alphaAnimation);
        this.f22005bf = true;
    }

    /* renamed from: I */
    public void m23308I() {
        if (this.f22040y) {
            return;
        }
        this.f22005bf = false;
        if (this.f21993at == null) {
            this.f21993at = m23252b(this.f21989ap);
        }
        this.f21993at.setImageBitmap(null);
        this.f21993at.setVisibility(0);
        this.f21993at.setBackgroundColor(-16777216);
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setInterpolator(new IntrinsicsJvm.kt_5());
        alphaAnimation.setDuration(50L);
        alphaAnimation.setAnimationListener(this.f22019bt);
        this.f21993at.clearAnimation();
        this.f21993at.setLayerType(2, null);
        this.f21993at.startAnimation(alphaAnimation);
    }

    @Override // com.oplus.camera.ui.preview.PreviewFrameLayout.OnSizeChangedListener
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo22202a(int OplusGLSurfaceView_13, int i2, int i3, int i4) {
        CameraLog.m12954a("CameraPreviewUI", "onSizeChanged, width: " + OplusGLSurfaceView_13 + ", height: " + i2);
        IntrinsicsJvm.kt_4 bVar = this.f21984ak;
        boolean z = true;
        if (bVar != null) {
            bVar.mo19656a(OplusGLSurfaceView_13, i2, !this.f21957aJ);
        }
        if (Util.m24495t()) {
            synchronized (this.f22030o) {
                if (this.f21978ae != null) {
                    this.f21978ae.m22194g();
                }
            }
        }
        synchronized (this.f22030o) {
            if (this.f22041z) {
                this.f22041z = false;
                return;
            }
            if (OplusGLSurfaceView_13 == i3 && i2 == i4 && !m23264c(OplusGLSurfaceView_13, i2)) {
                z = false;
            }
            m23292r(z);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private boolean m23264c(int OplusGLSurfaceView_13, int i2) {
        Size size = this.f21953aF;
        if (size == null || this.f21954aG == null || OplusGLSurfaceView_13 == 0 || i2 == 0) {
            return true;
        }
        int height = size.getHeight() - this.f21954aG.getHeight();
        CameraLog.m12954a("CameraPreviewUI", "decideSizeChangeFlag, width: " + OplusGLSurfaceView_13 + ", height: " + i2 + ", mToDisplaySize: " + this.f21953aF + ", tempDiffWidth: " + height);
        Size size2 = new Size(OplusGLSurfaceView_13, i2);
        if (height != 0) {
            Size size3 = new Size(OplusGLSurfaceView_13, i2 + height);
            Size size4 = new Size(height + OplusGLSurfaceView_13, i2);
            if (size2.equals(this.f21953aF) || m23267d(size2).equals(this.f21953aF) || size3.equals(this.f21953aF) || m23267d(size3).equals(this.f21953aF) || size4.equals(this.f21953aF) || m23267d(size4).equals(this.f21953aF)) {
                return false;
            }
        } else if ((size2.equals(this.f21953aF) || m23267d(size2).equals(this.f21953aF)) && this.f21931J == i2 && this.f21930I == OplusGLSurfaceView_13) {
            return false;
        }
        Size size5 = new Size((int) ((OplusGLSurfaceView_13 / i2) * this.f21953aF.getHeight()), this.f21953aF.getHeight());
        return (size5.equals(this.f21953aF) || m23267d(size5).equals(this.f21953aF)) ? false : true;
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    private Size m23267d(Size size) {
        return new Size(size.getHeight(), size.getWidth());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: au */
    public int m23245au() {
        int OplusGLSurfaceView_13;
        synchronized (this.f22030o) {
            OplusGLSurfaceView_13 = this.f21923B;
        }
        return OplusGLSurfaceView_13;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: av */
    public int m23246av() {
        int OplusGLSurfaceView_13;
        synchronized (this.f22030o) {
            OplusGLSurfaceView_13 = this.f21926E;
        }
        return OplusGLSurfaceView_13;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: aw */
    public int m23247aw() {
        int OplusGLSurfaceView_13;
        synchronized (this.f22030o) {
            OplusGLSurfaceView_13 = this.f21930I;
        }
        return OplusGLSurfaceView_13;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ax */
    public int m23248ax() {
        int OplusGLSurfaceView_13;
        synchronized (this.f22030o) {
            OplusGLSurfaceView_13 = this.f21931J;
        }
        return OplusGLSurfaceView_13;
    }

    /* renamed from: r */
    private void m23292r(boolean z) {
        synchronized (this) {
            CameraLog.m12954a("CameraPreviewUI", "setSizeChanged, sizeChanged: " + z);
            this.f22033r = z;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ay */
    public boolean m23249ay() {
        boolean z;
        synchronized (this) {
            z = this.f22033r;
        }
        return z;
    }

    /* renamed from: J */
    public Rect m23309J() {
        Rect rect;
        synchronized (this.f22030o) {
            int OplusGLSurfaceView_13 = this.f21928G == 0 ? this.f21926E : this.f21928G;
            rect = new Rect(this.f21923B, OplusGLSurfaceView_13, this.f21923B + this.f21930I, (this.f21953aF == null ? this.f21931J : this.f21953aF.getWidth()) + OplusGLSurfaceView_13);
        }
        return rect;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public void onLayoutChange(View view, int OplusGLSurfaceView_13, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        if (OplusGLSurfaceView_13 == i5 && i2 == i6 && i3 == i7 && i4 == i8) {
            return;
        }
        int i9 = i3 - OplusGLSurfaceView_13;
        int i10 = i4 - i2;
        if (Util.m24207a(this.f21945X) % 180 == 0) {
            this.f21947Z.m23470c(i9, i10);
        } else {
            this.f21947Z.m23470c(i10, i9);
        }
        if (Util.m24495t()) {
            synchronized (this.f22030o) {
                if (this.f21978ae != null) {
                    this.f21978ae.m22194g();
                }
            }
        }
        CameraLog.m12959b("CameraPreviewUI", "onLayoutChange, layout: " + Arrays.toString(new int[]{OplusGLSurfaceView_13, i2, i3, i4}));
    }

    /* renamed from: OplusGLSurfaceView_13 */
    public void m23407i(boolean z) {
        FaceView faceView = this.f21976ac;
        if (faceView == null || this.f22035t) {
            return;
        }
        faceView.setMirror(z);
        this.f21976ac.setVisibility(0);
        this.f21976ac.m22151b();
        this.f21976ac.m22153d();
        this.f22035t = true;
    }

    /* renamed from: K */
    public void m23310K() {
        Activity activity = this.f21945X;
        if (activity != null) {
            activity.runOnUiThread(new Runnable() { // from class: com.oplus.camera.ui.preview.COUIBaseListPopupWindow_11.7
                @Override // java.lang.Runnable
                public void run() {
                    if (CameraPreviewUI.this.f21976ac != null) {
                        CameraPreviewUI.this.f21976ac.m22152c();
                        CameraPreviewUI.this.f21976ac.m22151b();
                        CameraPreviewUI.this.f22035t = false;
                    }
                }
            });
        }
    }

    /* renamed from: L */
    public void m23311L() {
        MultiFocusView multiFocusView = this.f21978ae;
        if (multiFocusView == null || this.f22036u) {
            return;
        }
        multiFocusView.setVisibility(0);
        this.f21978ae.m22191d();
        this.f22036u = true;
    }

    /* renamed from: M */
    public void m23312M() {
        Activity activity = this.f21945X;
        if (activity != null) {
            activity.runOnUiThread(new Runnable() { // from class: com.oplus.camera.ui.preview.COUIBaseListPopupWindow_11.8
                @Override // java.lang.Runnable
                public void run() {
                    if (CameraPreviewUI.this.f21978ae != null) {
                        CameraPreviewUI.this.f21978ae.m22190c();
                        CameraPreviewUI.this.f22036u = false;
                    }
                }
            });
        }
    }

    /* renamed from: N */
    public void m23313N() {
        this.f21983aj = this.f21982ai;
        IntrinsicsJvm.kt_4 bVar = this.f21984ak;
        if (bVar != null) {
            String strMo16516h = bVar.mo19936ej().mo16516h();
            if ("full90" == strMo16516h) {
                this.f21983aj = 270;
            } else if ("full270" == strMo16516h) {
                this.f21983aj = 90;
            }
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public boolean m23360a(MotionEvent motionEvent) {
        ImageView imageView = this.f21986am;
        if (imageView == null || !imageView.isShown()) {
            return false;
        }
        CameraLog.m12954a("CameraPreviewUI", "dispatchTouchEvent, mReviewImage is show");
        return true;
    }

    /* renamed from: O */
    public GLRootView m23314O() {
        return this.f21959aL;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m23333a(DialogInterface.OnCancelListener onCancelListener) {
        new COUIAlertDialog.PlatformImplementations.kt_3(this.f21945X, R.style.DialogAlert).setTitle(this.f21945X.getResources().getString(R.string.camera_video_rec_disable_title)).setNegativeButton(R.string.camera_button_ok, new DialogInterface.OnClickListener() { // from class: com.oplus.camera.ui.preview.COUIBaseListPopupWindow_11.9
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int OplusGLSurfaceView_13) {
                dialogInterface.cancel();
            }
        }).setOnCancelListener(onCancelListener).show();
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m23384b(boolean z, boolean z2) throws Resources.NotFoundException {
        CameraLog.m12962c("CameraPreviewUI", "showHyperLapseFocusView, show: " + z);
        if (z && !this.f22031p) {
            if (this.f21962aO == null) {
                m23250az();
            }
            m23222aA();
        } else {
            HyperLapseFocusView hyperLapseFocusView = this.f21962aO;
            if (hyperLapseFocusView != null) {
                hyperLapseFocusView.setVisibility(8);
            }
            m23223aB();
        }
    }

    /* renamed from: az */
    private void m23250az() {
        if (this.f21962aO == null) {
            this.f21962aO = (HyperLapseFocusView) this.f21945X.getLayoutInflater().inflate(R.layout.view_hyper_lapse_focus, this.f21989ap).findViewById(R.id_renamed.hyper_lapse_focus_view);
            this.f21962aO.m22157a(this.f22023bx);
            this.f21964aQ = this.f21945X.getResources().getDimensionPixelSize(R.dimen.video_hyper_lapse_focus_top_margin);
        }
    }

    /* renamed from: aA */
    private void m23222aA() throws Resources.NotFoundException {
        HyperLapseFocusView hyperLapseFocusView = this.f21962aO;
        if (hyperLapseFocusView == null || hyperLapseFocusView.getVisibility() == 0) {
            return;
        }
        int dimensionPixelSize = this.f21945X.getResources().getDimensionPixelSize(R.dimen.video_hyper_lapse_focus_width);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f21962aO.getLayoutParams();
        layoutParams.topMargin = this.f21964aQ - Util.m24190R();
        layoutParams.leftMargin = (Util.getScreenWidth() - dimensionPixelSize) / 2;
        this.f21962aO.setLayoutParams(layoutParams);
        this.f21962aO.setVisibility(0);
    }

    /* renamed from: aB */
    private void m23223aB() {
        COUIToolTips c1508s = this.f21963aP;
        if (c1508s != null) {
            c1508s.dismiss();
            this.f21963aP = null;
        }
    }

    /* renamed from: P */
    public String m23315P() {
        HyperLapseFocusView hyperLapseFocusView = this.f21962aO;
        if (hyperLapseFocusView == null || this.f21989ap == null) {
            return "";
        }
        int[] iArr = new int[2];
        hyperLapseFocusView.getLocationOnScreen(iArr);
        return (iArr[0] + (this.f21962aO.getWidth() / 2)) + "x" + ((iArr[1] + (this.f21962aO.getHeight() / 2)) - this.f21989ap.getTop());
    }

    /* renamed from: Q */
    public void m23316Q() throws Resources.NotFoundException {
        COUIAlertDialog dialogInterfaceC1289b = this.f21974aa;
        if (dialogInterfaceC1289b != null && dialogInterfaceC1289b.isShowing()) {
            this.f21974aa.cancel();
            this.f21974aa = null;
            m23254b(this.f22021bv);
        } else {
            this.f21974aa = null;
        }
        COUIToolTips c1508s = this.f21963aP;
        if (c1508s != null && c1508s.isShowing()) {
            this.f21963aP.dismiss();
            this.f21963aP = null;
        } else {
            this.f21963aP = null;
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private void m23254b(DialogInterface.OnClickListener onClickListener) throws Resources.NotFoundException {
        if (this.f21996aw != null) {
            COUIAlertDialog dialogInterfaceC1289b = this.f21974aa;
            if (dialogInterfaceC1289b == null || !dialogInterfaceC1289b.isShowing()) {
                COUIAlertDialog dialogInterfaceC1289b2 = this.f21974aa;
                if (dialogInterfaceC1289b2 != null) {
                    dialogInterfaceC1289b2.dismiss();
                }
                this.f21975ab = new COUIAlertDialog.PlatformImplementations.kt_3(this.f21945X, R.style.DialogAlert);
                this.f21975ab.setTitle(this.f21996aw);
                this.f21975ab.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.oplus.camera.ui.preview.COUIBaseListPopupWindow_11.12
                    @Override // android.content.DialogInterface.OnKeyListener
                    public boolean onKey(DialogInterface dialogInterface, int OplusGLSurfaceView_13, KeyEvent keyEvent) {
                        if (OplusGLSurfaceView_13 != 4 || keyEvent.getRepeatCount() != 0) {
                            return false;
                        }
                        CameraPreviewUI.this.f21974aa.dismiss();
                        return false;
                    }
                });
                int OplusGLSurfaceView_13 = Storage.f12097w;
                if (OplusGLSurfaceView_13 == 1) {
                    if (Storage.f12096v == 1 || Storage.f12096v == 4 || Storage.f12096v == 5) {
                        m23334a(onClickListener);
                    }
                    if (Storage.f12096v == 2 || Storage.f12096v == 3) {
                        m23317R();
                    }
                } else if (OplusGLSurfaceView_13 == 2 || OplusGLSurfaceView_13 == 3) {
                    if (Storage.f12096v == 5) {
                        m23318S();
                    }
                    if (Storage.f12096v == 1 || Storage.f12096v == 4) {
                        m23334a(onClickListener);
                    }
                }
                this.f21974aa = this.f21975ab.create();
                this.f21974aa.show();
            }
        }
    }

    /* renamed from: R */
    public void m23317R() throws Resources.NotFoundException {
        Resources resources = this.f21945X.getResources();
        boolean z = this.f22006bg;
        int OplusGLSurfaceView_13 = R.array.storage_tip_internal_full_external_available_can_clean;
        String[] stringArray = resources.getStringArray(z ? R.array.storage_tip_internal_full_external_available_can_clean : R.array.storage_tip_internal_full_external_available_can_not_clean);
        int i2 = Storage.f12096v;
        final boolean z2 = false;
        if (i2 == 2) {
            Resources resources2 = this.f21945X.getResources();
            if (!this.f22006bg) {
                OplusGLSurfaceView_13 = R.array.storage_tip_internal_full_external_available_can_not_clean;
            }
            stringArray = resources2.getStringArray(OplusGLSurfaceView_13);
            z2 = true;
        } else if (i2 == 3) {
            stringArray = this.f21945X.getResources().getStringArray(this.f22006bg ? R.array.storage_tip_external_full_internal_available_can_clean : R.array.storage_tip_external_full_internal_available_can_not_clean);
        }
        this.f21975ab.setItems(stringArray, new DialogInterface.OnClickListener() { // from class: com.oplus.camera.ui.preview.COUIBaseListPopupWindow_11.13
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i3) {
                if (dialogInterface != null) {
                    if (i3 == 0) {
                        dialogInterface.dismiss();
                        if (CameraPreviewUI.this.f22006bg) {
                            Intent intent = new Intent("oplus.intent.action.CLEAR_MAIN_ACTIVITY");
                            intent.setPackage(CameraPreviewUI.f21920g);
                            try {
                                intent.addFlags(67108864);
                                CameraPreviewUI.this.f21945X.startActivity(intent);
                                return;
                            } catch (Exception e2) {
                                CameraLog.m12967f("CameraPreviewUI", "makeMultipleOptionStorageDialog, Exception when start ClearMainActivity: " + e2);
                                return;
                            }
                        }
                        return;
                    }
                    if (i3 != 1) {
                        if (i3 != 2) {
                            return;
                        }
                        dialogInterface.dismiss();
                        return;
                    }
                    String string = CameraPreviewUI.this.f21946Y.getString(CameraUIInterface.KEY_STORAGE_PLACE, CameraPreviewUI.this.f21945X.getString(R.string.camera_storage_default_value));
                    if (z2) {
                        if ("off".equals(string)) {
                            SharedPreferences.Editor editorEdit = CameraPreviewUI.this.f21946Y.edit();
                            editorEdit.putString(CameraUIInterface.KEY_STORAGE_PLACE, "on");
                            editorEdit.apply();
                        }
                        Storage.f12095u = "on";
                    } else {
                        if ("on".equals(string)) {
                            SharedPreferences.Editor editorEdit2 = CameraPreviewUI.this.f21946Y.edit();
                            editorEdit2.putString(CameraUIInterface.KEY_STORAGE_PLACE, "off");
                            editorEdit2.apply();
                        }
                        Storage.f12095u = "off";
                    }
                    Storage.f12097w = Storage.m11122b(Storage.f12095u);
                }
            }
        });
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m23334a(DialogInterface.OnClickListener onClickListener) {
        this.f21975ab.setPositiveButton(this.f22006bg ? R.string.camera_storage_button_clean : R.string.camera_button_ok, onClickListener);
        this.f21975ab.setNegativeButton(R.string.camera_storage_button_cancel, new DialogInterface.OnClickListener() { // from class: com.oplus.camera.ui.preview.COUIBaseListPopupWindow_11.14
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int OplusGLSurfaceView_13) {
                if (dialogInterface != null) {
                    dialogInterface.dismiss();
                }
            }
        });
    }

    /* renamed from: S */
    public void m23318S() {
        this.f21975ab.setNegativeButton(R.string.camera_button_ok, new DialogInterface.OnClickListener() { // from class: com.oplus.camera.ui.preview.COUIBaseListPopupWindow_11.15
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int OplusGLSurfaceView_13) {
                if (dialogInterface == null || !"on".equals(CameraPreviewUI.this.f21946Y.getString(CameraUIInterface.KEY_STORAGE_PLACE, CameraPreviewUI.this.f21945X.getString(R.string.camera_storage_default_value)))) {
                    return;
                }
                SharedPreferences.Editor editorEdit = CameraPreviewUI.this.f21946Y.edit();
                editorEdit.putString(CameraUIInterface.KEY_STORAGE_PLACE, "off");
                editorEdit.commit();
                CameraPreviewUI.this.f21984ak.mo19840cq();
            }
        });
    }

    /* renamed from: T */
    public void m23319T() throws Resources.NotFoundException {
        CameraLog.m12954a("CameraPreviewUI", "updateStorageHint(), storage_status = " + Storage.f12097w + ", Storage.sStorageOverrideState = " + Storage.f12096v);
        int OplusGLSurfaceView_13 = Storage.f12097w;
        if (OplusGLSurfaceView_13 == 0) {
            COUIAlertDialog dialogInterfaceC1289b = this.f21974aa;
            if (dialogInterfaceC1289b != null) {
                dialogInterfaceC1289b.cancel();
                return;
            }
            return;
        }
        if (OplusGLSurfaceView_13 != 1) {
            if (OplusGLSurfaceView_13 == 2 || OplusGLSurfaceView_13 == 3) {
                if (Storage.f12096v == 5) {
                    this.f21996aw = this.f21945X.getString(R.string.camera_storage_external_fail);
                } else if (Storage.f12096v == 1) {
                    this.f21996aw = this.f21945X.getString(R.string.camera_storage_all_full);
                } else if (Storage.f12096v == 4) {
                    this.f21996aw = this.f21945X.getString(R.string.camera_storage_internal_fullL_external_full);
                }
                m23254b(this.f22021bv);
                return;
            }
            return;
        }
        if (Storage.f12096v == 1) {
            this.f21996aw = this.f21945X.getString(R.string.camera_storage_all_full);
        } else if (Storage.f12096v == 2) {
            this.f21996aw = this.f21945X.getString(R.string.camera_storage_internal_full_external_avaliable);
        } else if (Storage.f12096v == 3) {
            this.f21996aw = this.f21945X.getString(R.string.camera_storage_internal_avaliable_external_full);
        } else if (Storage.f12096v == 4) {
            this.f21996aw = this.f21945X.getString(R.string.camera_storage_internal_fullL_external_full);
        } else if (Storage.f12096v == 5) {
            this.f21996aw = this.f21945X.getString(R.string.camera_storage_all_full);
        }
        m23254b(this.f22021bv);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public void m23212a(int OplusGLSurfaceView_13, int i2, boolean z, boolean z2, boolean z3) {
        float screenWidth;
        int iM24426d;
        if (z2) {
            if (Util.m24495t()) {
                m23292r(false);
                return;
            }
            synchronized (this.f22030o) {
                if (this.f21998ay == null) {
                    return;
                }
                int iF = this.f21947Z.m14248f();
                int iG = this.f21947Z.m14250g();
                if (this.f21984ak.mo19928eb()) {
                    screenWidth = Util.getScreenHeight() / iG;
                    this.f21955aH = (int) (Util.getScreenHeight() / 2.3333333333333335d);
                } else {
                    screenWidth = Util.getScreenWidth() / iF;
                    this.f21955aH = Util.getScreenWidth();
                }
                this.f21930I = this.f21955aH;
                this.f21931J = Math.round(iG * screenWidth);
                this.f21923B = OplusGLSurfaceView_13 - (this.f21955aH / 2);
                this.f21926E = i2 - (this.f21931J / 2);
                if (this.f21926E < this.f21989ap.getTop()) {
                    this.f21926E = this.f21989ap.getTop();
                }
                if (this.f21923B < this.f21989ap.getLeft()) {
                    this.f21923B = this.f21989ap.getLeft();
                }
                if (this.f21926E != this.f21989ap.getTop()) {
                    if (!z) {
                        this.f21926E = Util.m24186N();
                    } else {
                        this.f21926E = 0;
                    }
                }
                m23292r(false);
                if (this.f21984ak.mo19839cp() || this.f21984ak.mo19881dY()) {
                    if (this.f22037v) {
                        iM24426d = Util.m24426d(this.f21953aF.getWidth(), this.f21953aF.getHeight());
                    } else {
                        iM24426d = Util.m24426d(this.f21998ay.getWidth(), this.f21998ay.getHeight());
                    }
                    if (z3 || !this.f21984ak.mo19881dY()) {
                        m23281i(iM24426d);
                    }
                } else {
                    this.f21926E = Util.m24186N();
                    if (this.f21981ah != 3) {
                        this.f21931J = (int) (this.f21930I * 1.7777777777777777d);
                        if (!Util.m24195W()) {
                            this.f21931J = (Util.getScreenHeight() - Util.m24190R()) - Util.m24191S();
                        }
                        if (this.f22037v) {
                            m23281i(Util.m24426d(this.f21953aF.getWidth(), this.f21953aF.getHeight()));
                        }
                    }
                    if (this.f21953aF != null && this.f22037v && Util.m24426d(this.f21953aF.getWidth(), this.f21953aF.getHeight()) > 2) {
                        this.f21926E = 0;
                        this.f21931J = Util.getScreenHeight();
                    }
                }
                synchronized (this.f22030o) {
                    if (this.f21933L != 0) {
                        this.f22038w = true;
                        this.f21925D = this.f21924C - (this.f21933L / 2);
                    }
                    if (this.f21927F != this.f21926E) {
                        this.f22039x = true;
                        this.f21928G = this.f21926E;
                        this.f21929H = this.f21928G - this.f21927F;
                    }
                    if (this.f21978ae != null) {
                        this.f21978ae.m22194g();
                    }
                    CameraLog.m12954a("CameraPreviewUI", "layoutPreview, leftMargin: " + this.f21923B + ", topMargin: " + this.f21926E + ", width: " + this.f21930I + ", height: " + this.f21931J);
                }
            }
        }
    }

    /* renamed from: OplusGLSurfaceView_13 */
    private void m23281i(int OplusGLSurfaceView_13) {
        String strMo19768bg = this.f21984ak.mo19768bg();
        if (ApsConstant.CAPTURE_MODE_XPAN.equals(this.f21984ak.mo19769bh()) || (!strMo19768bg.isEmpty() && this.f21984ak.mo19880dX())) {
            this.f21923B = 0;
        }
        if (OplusGLSurfaceView_13 == 0) {
            this.f21926E = Util.m24186N();
            return;
        }
        if (OplusGLSurfaceView_13 == 1) {
            if (Util.m24195W()) {
                this.f21926E = Util.m24186N();
                if (Util.m24495t()) {
                    this.f21926E = (Util.m24186N() / 2) - Util.m24185M();
                    return;
                }
                return;
            }
            if (Util.m24495t() && !Util.m24498u()) {
                this.f21926E = (Util.m24186N() / 2) - Util.m24185M();
                return;
            } else {
                this.f21926E = 0;
                this.f21931J = Util.getScreenHeight();
                return;
            }
        }
        if (OplusGLSurfaceView_13 == 2) {
            this.f21926E = Util.m24184L() + Util.m24186N();
            return;
        }
        this.f21926E = 0;
        this.f21931J = Util.getScreenHeight();
        if (ApsConstant.CAPTURE_MODE_XPAN.equals(strMo19768bg) || (strMo19768bg.isEmpty() && this.f21984ak.mo19880dX())) {
            this.f21931J = (int) (Util.getScreenHeight() * 0.87f);
            this.f21930I = (int) (Util.getScreenWidth() * 0.87f);
            this.f21926E = (Util.getScreenHeight() - this.f21931J) / 2;
            this.f21923B = (Util.getScreenWidth() - this.f21930I) / 2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: aC */
    public void m23224aC() {
        CameraLog.m12954a("CameraPreviewUI", "notifyPreviewImageAnimOnStart");
        PlatformImplementations.kt_3 aVar = this.f21956aI;
        if (aVar != null) {
            aVar.mo10943a(this.f21949aB);
        }
        Activity activity = this.f21945X;
        if (activity != null) {
            activity.onUserInteraction();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: aD */
    public void m23225aD() {
        CameraLog.m12954a("CameraPreviewUI", "notifyPreviewImageAnimOnMiddle, mbCancleBlurAnimation: " + this.f22034s);
        PlatformImplementations.kt_3 aVar = this.f21956aI;
        if (aVar != null) {
            aVar.mo10944a(this.f21950aC, this.f21949aB);
        }
    }

    /* renamed from: U */
    public void m23320U() {
        CameraLog.m12954a("CameraPreviewUI", "cancelBlurAnimation");
        this.f22034s = true;
        Handler handler = this.f22017br;
        if (handler != null) {
            handler.removeMessages(1);
            this.f22017br.removeMessages(2);
        }
    }

    /* renamed from: V */
    public void m23321V() {
        synchronized (this.f22030o) {
            this.f22037v = false;
        }
    }

    /* renamed from: W */
    public void m23322W() {
        boolean z;
        if (this.f21950aC == null || this.f21949aB == null || this.f21956aI == null || (z = this.f22034s)) {
            return;
        }
        if (z) {
            CameraLog.m12954a("CameraPreviewUI", "notifyPreviewImageAnimationOnMiddle cancel animation");
        } else {
            this.f22017br.removeMessages(2);
            this.f22017br.sendEmptyMessage(2);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m23340a(Size size, Size size2, final PlatformImplementations.kt_3 aVar, int OplusGLSurfaceView_13, int i2, int i3, boolean z) {
        this.f21950aC = size;
        this.f21949aB = size2;
        this.f21956aI = aVar;
        this.f22034s = false;
        this.f21947Z.m23466a(new CameraScreenNail.PlatformImplementations.kt_3() { // from class: com.oplus.camera.ui.preview.COUIBaseListPopupWindow_11.16
            @Override // com.oplus.camera.p172ui.preview.CameraScreenNail.PlatformImplementations.kt_3
            /* renamed from: PlatformImplementations.kt_3 */
            public void mo23433a() {
                PlatformImplementations.kt_3 aVar2;
                synchronized (CameraPreviewUI.this.f22030o) {
                    CameraPreviewUI.this.f22037v = false;
                }
                if (CameraPreviewUI.this.f22031p || (aVar2 = aVar) == null) {
                    return;
                }
                aVar2.mo10942a();
            }
        });
        m23386c();
        m23339a(size, size2, i2, i3);
        OutPresentation presentationC2959e = this.f22002bc;
        if (presentationC2959e != null) {
            presentationC2959e.m16706a(this.f21953aF.getWidth(), this.f21953aF.getHeight());
        }
        m23228aG();
        m23212a((this.f21989ap.getRight() - this.f21989ap.getLeft()) / 2, (this.f21989ap.getBottom() - this.f21989ap.getTop()) / 2, false, true, z);
        synchronized (this.f22030o) {
            this.f21947Z.m23464a(this.f21954aG, this.f21953aF);
            CameraLog.m12954a("CameraPreviewUI", "startShowPreviewImageAnimation, preview size change: " + this.f21950aC.getWidth() + " x " + this.f21950aC.getHeight() + " => " + this.f21949aB.getWidth() + " x " + this.f21949aB.getHeight() + ", mHeight: " + this.f21931J + ", mWidth: " + this.f21930I + ", offSetY: " + m23246av() + ", mDiffSize: " + this.f21932K + ", moreTime: " + OplusGLSurfaceView_13);
        }
        Activity activity = this.f21945X;
        if (activity != null) {
            activity.runOnUiThread(new Runnable() { // from class: com.oplus.camera.ui.preview.COUIBaseListPopupWindow_11.17
                @Override // java.lang.Runnable
                public void run() {
                    if (CameraPreviewUI.this.f21945X != null) {
                        CameraPreviewUI.this.f21945X.onUserInteraction();
                    }
                }
            });
        }
        if (!this.f22034s) {
            this.f22017br.removeMessages(1);
            this.f22017br.sendEmptyMessageDelayed(1, OplusGLSurfaceView_13);
        }
        m23402g(true);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m23344a(final BaseScreenMode abstractC2934a, final Size size) {
        synchronized (this.f22030o) {
            if (!this.f21957aJ && this.f21932K == 0 && this.f21933L == 0 && this.f21951aD == 0 && this.f21952aE == 0 && this.f21931J != 0 && this.f21930I != 0) {
                if (Util.m24498u()) {
                    this.f21944W = 500.0f;
                    this.f22024i = this.f22028m;
                    this.f21957aJ = true;
                } else {
                    this.f21944W = this.f21943V;
                    this.f22024i = this.f22029n;
                }
                this.f22008bi = abstractC2934a;
                this.f22009bj = size;
                Rect rectB = abstractC2934a.mo16558b(size.getHeight(), size.getWidth());
                this.f21951aD = rectB.left - this.f21923B;
                this.f21952aE = rectB.top - this.f21926E;
                this.f21953aF = new Size(rectB.height(), rectB.width());
                this.f21954aG = new Size(this.f21931J, this.f21930I);
                this.f21933L = this.f21953aF.getHeight() - this.f21954aG.getHeight();
                this.f21932K = this.f21953aF.getWidth() - this.f21954aG.getWidth();
                this.f21942U = SystemClock.uptimeMillis();
                this.f21924C = this.f21923B;
                this.f21927F = this.f21926E;
                CameraLog.m12959b("CameraPreviewUI", "startScreenModeChangeAnimation, mFromDisplaySize: " + this.f21954aG.getWidth() + "x" + this.f21954aG.getHeight() + ", mOffsetX: " + this.f21923B + ", mOffsetY: " + this.f21926E + ", mToDisplaySize: " + this.f21953aF.getWidth() + "x" + this.f21953aF.getHeight() + ", mTranslateX : " + this.f21951aD + ", mTranslateY: " + this.f21952aE + ", mToScreenMode: " + this.f22008bi + ", mToPreviewSize: " + this.f22009bj + ", toRegion: " + rectB);
                if (Util.m24498u()) {
                    this.f22017br.post(new Runnable() { // from class: com.oplus.camera.ui.preview.COUIBaseListPopupWindow_11.18
                        @Override // java.lang.Runnable
                        public void run() {
                            CameraPreviewUI.this.f21984ak.mo19673a(abstractC2934a, size, CameraPreviewUI.this.m23226aE());
                            if (CameraPreviewUI.this.f21989ap != null) {
                                CameraPreviewUI.this.f21989ap.setVisibility(8);
                            }
                        }
                    });
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: aE */
    public long m23226aE() {
        long OplusGLSurfaceView_15;
        synchronized (this.f22030o) {
            OplusGLSurfaceView_15 = this.f21942U;
        }
        return OplusGLSurfaceView_15;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: aF */
    public void m23227aF() {
        CameraLog.m12959b("CameraPreviewUI", "stopScreenModeChangeAnimation");
        this.f21959aL.setRenderMode(0);
        if (this.f21984ak == null || this.f22008bi == null) {
            return;
        }
        this.f22017br.post(new Runnable() { // from class: com.oplus.camera.ui.preview.COUIBaseListPopupWindow_11.20
            @Override // java.lang.Runnable
            public void run() {
                CameraPreviewUI.this.f21984ak.mo19923eK();
                if (CameraPreviewUI.this.f21989ap != null) {
                    CameraPreviewUI.this.f21989ap.setVisibility(0);
                }
            }
        });
        this.f21957aJ = false;
        this.f21944W = this.f21943V;
        this.f22024i = this.f22029n;
        this.f22041z = true;
        Rect rectB = this.f22008bi.mo16558b(this.f22009bj.getHeight(), this.f22009bj.getWidth());
        this.f21923B = rectB.left;
        this.f21926E = rectB.top;
        this.f21930I = rectB.width();
        this.f21931J = rectB.height();
        this.f22010bk = this.f22008bi.mo16516h();
        this.f22011bl = this.f22009bj;
        CameraLog.m12959b("CameraPreviewUI", "stopScreenModeChangeAnimation, mToScreenMode: " + this.f22008bi + ", mToPreviewSize: " + this.f22009bj + ", region: " + rectB);
        this.f22017br.post(new Runnable() { // from class: com.oplus.camera.ui.preview.COUIBaseListPopupWindow_11.21
            @Override // java.lang.Runnable
            public void run() {
                CameraPreviewUI viewOnLayoutChangeListenerC3444g = CameraPreviewUI.this;
                viewOnLayoutChangeListenerC3444g.m23263c(viewOnLayoutChangeListenerC3444g.f22009bj);
            }
        });
    }

    /* renamed from: X */
    public boolean m23323X() {
        boolean z;
        synchronized (this.f22030o) {
            z = this.f21957aJ;
        }
        return z;
    }

    /* renamed from: aG */
    private void m23228aG() {
        synchronized (this.f22030o) {
            this.f21933L = this.f21953aF.getHeight() - this.f21954aG.getHeight();
            this.f21932K = this.f21953aF.getWidth() - this.f21954aG.getWidth();
            this.f21942U = SystemClock.uptimeMillis();
            this.f22037v = true;
            this.f21924C = this.f21923B;
            this.f21927F = this.f21926E;
            this.f22038w = false;
            this.f22039x = false;
            this.f21929H = 0;
            this.f21936O.clear();
            this.f21944W = this.f21943V;
            this.f22024i = this.f22029n;
            if (Util.m24495t()) {
                this.f21957aJ = false;
                BaseScreenMode abstractC2934aMo19936ej = this.f21984ak.mo19936ej();
                Rect rectB = abstractC2934aMo19936ej.mo16558b(this.f21949aB.getHeight(), this.f21949aB.getWidth());
                this.f21951aD = rectB.left - this.f21924C;
                this.f21952aE = rectB.top - this.f21927F;
                this.f21929H = this.f21952aE;
                this.f21933L = rectB.width() - this.f21930I;
                this.f21932K = rectB.height() - this.f21931J;
                this.f21954aG = new Size(this.f21931J, this.f21930I);
                this.f21953aF = new Size(rectB.height(), rectB.width());
                if (!abstractC2934aMo19936ej.mo16516h().equals(this.f22010bk)) {
                    this.f22024i = this.f22028m;
                    this.f21944W = 500.0f;
                    this.f21957aJ = true;
                    this.f22008bi = abstractC2934aMo19936ej;
                    this.f22009bj = this.f21949aB;
                }
                CameraLog.m12959b("CameraPreviewUI", "initValue, mDiffWidth: " + this.f21933L + ", mDiffHeight: " + this.f21932K + ", mTranslateX: " + this.f21951aD + ", mTranslateY: " + this.f21952aE + ", displaySize: " + this.f21954aG + "-->" + this.f21953aF + ", mLastScreenModeName: " + this.f22010bk + ", currentScreenMode: " + abstractC2934aMo19936ej);
            }
            if (this.f21945X != null) {
                BackgroundSplitManager.m18430a(this.f21945X).m18440a(this.f21942U, (long) this.f21943V);
            }
        }
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    private void m23269d(int OplusGLSurfaceView_13, int i2) {
        synchronized (this.f22030o) {
            if (this.f21936O.size() == 0) {
                this.f21936O.add(new COUIBaseListPopupWindow_8(OplusGLSurfaceView_13, i2));
            } else {
                COUIBaseListPopupWindow_8 eVar = this.f21936O.get(this.f21936O.size() - 1);
                if (eVar.f22086a + eVar.f22087b != OplusGLSurfaceView_13 + i2) {
                    this.f21936O.add(new COUIBaseListPopupWindow_8(OplusGLSurfaceView_13, i2));
                }
            }
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m23332a(long OplusGLSurfaceView_15) {
        synchronized (this.f22030o) {
            if (this.f21954aG != null) {
                long j2 = OplusGLSurfaceView_15 - this.f21942U;
                if (j2 > this.f21943V) {
                    j2 = (long) this.f21943V;
                }
                float interpolation = this.f22024i.getInterpolation(j2 / this.f21943V);
                m23269d(this.f21927F + ((int) (this.f21929H * interpolation)), this.f21954aG.getWidth() + ((int) (this.f21932K * interpolation)));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: aH */
    public COUIBaseListPopupWindow_8 m23229aH() {
        synchronized (this.f22030o) {
            if (this.f21936O.size() <= 0) {
                return null;
            }
            return this.f21936O.get(this.f21936O.size() - 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: aI */
    public COUIBaseListPopupWindow_8 m23230aI() {
        synchronized (this.f22030o) {
            if (this.f21936O.size() <= 1) {
                return null;
            }
            return this.f21936O.get(this.f21936O.size() - 2);
        }
    }

    /* renamed from: Y */
    public int m23324Y() {
        synchronized (this.f22030o) {
            COUIBaseListPopupWindow_8 eVarM23229aH = null;
            if (this.f21932K > 0) {
                eVarM23229aH = m23230aI();
            } else if (this.f21932K < 0) {
                eVarM23229aH = m23229aH();
            }
            if (eVarM23229aH == null) {
                return -1;
            }
            return eVarM23229aH.f22086a + eVarM23229aH.f22087b;
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m23339a(Size size, Size size2, int OplusGLSurfaceView_13, int i2) {
        synchronized (this.f22030o) {
            CameraLog.m12954a("CameraPreviewUI", "updateDisplaySize, Size width: " + size.getWidth() + " x " + size.getHeight() + " => " + size2.getWidth() + " x " + size2.getHeight() + ", mHeight: " + this.f21931J + ", mWidth: " + this.f21930I);
            if (this.f21947Z.m23493x()) {
                this.f21954aG = new Size(this.f21931J, this.f21930I);
                double width = size2.getWidth() / size2.getHeight();
                if (1 == this.f21984ak.mo18134aX()) {
                    this.f21953aF = new Size(Util.getScreenHeight(), (int) (Util.getScreenHeight() / width));
                } else {
                    this.f21953aF = new Size((int) (width * this.f21930I), this.f21930I);
                }
                return;
            }
            if (size.getWidth() == size2.getWidth() && size.getHeight() == size2.getHeight()) {
                this.f21954aG = size;
                this.f21953aF = size2;
                this.f21932K = 0;
                this.f21929H = 0;
                this.f21928G = 0;
                this.f21936O.clear();
                BackgroundSplitManager.m18430a(this.f21945X).m18438a();
                return;
            }
            int[] iArrMo19698a = this.f21984ak.mo19698a(size, size2);
            if (iArrMo19698a != null) {
                this.f21954aG = new Size(iArrMo19698a[0], iArrMo19698a[1]);
                this.f21953aF = new Size(iArrMo19698a[2], iArrMo19698a[3]);
            } else {
                this.f21954aG = new Size((int) ((size.getWidth() / size.getHeight()) * OplusGLSurfaceView_13), OplusGLSurfaceView_13);
                this.f21953aF = Util.m24292a(size2) ? new Size(Util.getScreenHeight(), Util.getScreenWidth()) : new Size((int) ((size2.getWidth() / size2.getHeight()) * i2), i2);
                String strMo19768bg = this.f21984ak.mo19768bg();
                if (ApsConstant.CAPTURE_MODE_XPAN.equals(strMo19768bg) || (this.f21984ak.mo19880dX() && strMo19768bg.isEmpty())) {
                    this.f21953aF = new Size(Math.round(Util.getScreenHeight() * 0.87f), Math.round(Util.getScreenWidth() * 0.87f));
                }
            }
            CameraLog.m12954a("CameraPreviewUI", "updateDisplaySize, DisplaySize: " + this.f21954aG.getWidth() + " x " + this.f21954aG.getHeight() + " => " + this.f21953aF.getWidth() + " x " + this.f21953aF.getHeight());
        }
    }

    /* renamed from: OplusGLSurfaceView_15 */
    public void m23409j(boolean z) {
        FaceView faceView = this.f21976ac;
        if (faceView != null) {
            faceView.setShowBeauty3DFace(z);
        }
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    public void m23398f(int OplusGLSurfaceView_13) {
        FaceView faceView = this.f21976ac;
        if (faceView != null) {
            faceView.setMainFaceIndex(OplusGLSurfaceView_13);
        }
    }

    @Override // com.oplus.camera.p172ui.preview.CameraScreenNail.IntrinsicsJvm.kt_3
    /* renamed from: Z */
    public void mo23325Z() {
        GLRootView gLRootView = this.f21959aL;
        if (gLRootView != null) {
            gLRootView.mo13788a();
        }
        IntrinsicsJvm.kt_4 bVar = this.f21984ak;
        if (bVar != null) {
            bVar.mo19841cr();
        }
    }

    @Override // com.oplus.camera.p172ui.preview.CameraScreenNail.IntrinsicsJvm.kt_3
    /* renamed from: aa */
    public void mo23361aa() {
        IntrinsicsJvm.kt_4 bVar = this.f21984ak;
        if (bVar != null) {
            bVar.mo19842cs();
        }
    }

    @Override // com.oplus.camera.p172ui.preview.CameraScreenNail.IntrinsicsJvm.kt_3
    /* renamed from: ab */
    public void mo23362ab() {
        GLRootView gLRootView = this.f21959aL;
        if (gLRootView != null) {
            gLRootView.setBackground(null);
        }
        IntrinsicsJvm.kt_4 bVar = this.f21984ak;
        if (bVar != null) {
            bVar.mo19843ct();
        }
    }

    @Override // com.oplus.camera.p172ui.preview.CameraScreenNail.IntrinsicsJvm.kt_3
    /* renamed from: ac */
    public void mo23363ac() {
        IntrinsicsJvm.kt_4 bVar = this.f21984ak;
        if (bVar != null) {
            bVar.mo19937ek();
            if (!this.f22031p) {
                this.f21984ak.mo19931ee();
                this.f21984ak.mo19932ef();
                if (Util.m24495t()) {
                    this.f21984ak.mo19933eg();
                }
            }
            if (!this.f21984ak.mo19930ed()) {
                CameraLog.m12954a("CameraPreviewUI", "onFirstFrameDraw, don't hide blur for some case");
                return;
            }
        }
        m23364ad();
    }

    /* renamed from: ad */
    public void m23364ad() {
        CameraLog.m12954a("CameraPreviewUI", "execHideBlurView");
        CameraLog.m12952a("execHideBlurView");
        if (!this.f22031p && this.f21989ap.indexOfChild(this.f21988ao) >= 0) {
            if ((this.f21984ak.mo19845cv() == 0 && !CameraMotorManager.m13703a(this.f21945X.getApplicationContext()).m13712b()) || CameraMotorManager.m13703a(this.f21945X.getApplicationContext()).m13714d()) {
                if (this.f22032q) {
                    int OplusGLSurfaceView_13 = 0;
                    if (this.f21984ak.mo19916eD() && Util.m24169C()) {
                        OplusGLSurfaceView_13 = 17;
                    }
                    this.f22017br.postDelayed(new Runnable() { // from class: com.oplus.camera.ui.preview.COUIBaseListPopupWindow_11.22
                        @Override // java.lang.Runnable
                        public void run() {
                            if (CameraPreviewUI.this.f22031p) {
                                return;
                            }
                            CameraPreviewUI.this.m23305F();
                            CameraPreviewUI.this.f22032q = false;
                        }
                    }, OplusGLSurfaceView_13);
                } else {
                    this.f22017br.postAtFrontOfQueue(new Runnable() { // from class: com.oplus.camera.ui.preview.COUIBaseListPopupWindow_11.23
                        @Override // java.lang.Runnable
                        public void run() {
                            CameraPreviewUI.this.m23305F();
                        }
                    });
                }
            } else {
                CameraMotorManager.m13703a(this.f21945X.getApplicationContext()).m13708a(new Runnable() { // from class: com.oplus.camera.ui.preview.COUIBaseListPopupWindow_11.24
                    @Override // java.lang.Runnable
                    public void run() {
                        CameraPreviewUI.this.m23305F();
                    }
                });
            }
        }
        CameraLog.m12958b("execHideBlurView");
    }

    /* renamed from: ae */
    public Rect[] m23365ae() {
        FaceView faceView = this.f21976ac;
        if (faceView != null) {
            return faceView.getFaceRects();
        }
        return null;
    }

    /* renamed from: af */
    public int m23366af() {
        RelativeLayout relativeLayout;
        FaceView faceView = this.f21976ac;
        if (faceView == null || (relativeLayout = this.f21994au) == null) {
            return 0;
        }
        return relativeLayout.indexOfChild(faceView);
    }

    /* renamed from: OplusGLSurfaceView_5 */
    public void m23411k(boolean z) {
        CameraScreenNail c3445h = this.f21947Z;
        if (c3445h != null) {
            c3445h.m14247e(z);
        }
        FaceView faceView = this.f21976ac;
        if (faceView != null) {
            faceView.setRearMirrorEnable(z);
        }
        TrackFocusView c3432ac = this.f21977ad;
        if (c3432ac != null) {
            c3432ac.setRearMirrorEnable(z);
        }
    }

    /* renamed from: OplusGLSurfaceView_14 */
    public void m23412l(boolean z) {
        CameraScreenNail c3445h = this.f21947Z;
        if (c3445h != null) {
            c3445h.m14249f(z);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m23218a(PreviewRenderCallback interfaceC3461x) {
        if (this.f22007bh.contains(interfaceC3461x)) {
            return;
        }
        this.f22007bh.add(interfaceC3461x);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public void m23213a(GLCanvas interfaceC2757h) {
        if (this.f22007bh.isEmpty()) {
            return;
        }
        Iterator<PreviewRenderCallback> it = this.f22007bh.iterator();
        while (it.hasNext()) {
            PreviewRenderCallback next = it.next();
            if (next != null) {
                next.mo22195a(interfaceC2757h, this.f22025j);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m23255b(GLCanvas interfaceC2757h) {
        if (this.f22007bh.isEmpty()) {
            return;
        }
        Iterator<PreviewRenderCallback> it = this.f22007bh.iterator();
        while (it.hasNext()) {
            PreviewRenderCallback next = it.next();
            if (next != null) {
                next.mo22196b(interfaceC2757h, this.f22025j);
            }
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m23390c(boolean z, boolean z2) throws Resources.NotFoundException {
        CameraLog.m12959b("CameraPreviewUI", "showMultiCameraTypeView, show: " + z + ", needAnimation: " + z2);
        this.f21967aT = z;
        if (z) {
            if (this.f21966aS == null) {
                m23231aJ();
            }
            this.f21966aS.setType(this.f21946Y.getInt(CameraUIInterface.KEY_MULTI_CAMERA_TYPE_SELECTED, 0));
            if (z2) {
                m23415m(true);
                return;
            }
            this.f21966aS.m24086a(this.f21982ai, true);
            this.f21966aS.setAlpha(1.0f);
            this.f21966aS.setTranslationY(0.0f);
            this.f21966aS.setTranslationX(0.0f);
            this.f21966aS.setVisibility(0);
            return;
        }
        if (this.f21966aS != null) {
            m23417n(z2);
        }
    }

    /* renamed from: OplusGLSurfaceView_6 */
    protected void m23415m(boolean z) {
        int OplusGLSurfaceView_13;
        String str;
        CameraLog.m12954a("CameraPreviewUI", "showMultiTypeView, needAnim: " + z);
        AnimatorSet animatorSet = this.f21968aU;
        if (animatorSet != null && animatorSet.isStarted()) {
            this.f21968aU.end();
        } else {
            if (this.f21966aS.isShown()) {
                return;
            }
            AnimatorSet animatorSet2 = this.f21969aV;
            if (animatorSet2 != null && animatorSet2.isStarted()) {
                return;
            }
        }
        if (z) {
            boolean z2 = 1 == this.f21984ak.mo18134aX();
            int iMo19935ei = this.f21984ak.mo19935ei();
            this.f21966aS.setAlpha(0.0f);
            if (z2) {
                OplusGLSurfaceView_13 = 270 == iMo19935ei ? this.f21970aW : -this.f21970aW;
                this.f21966aS.setTranslationX(-OplusGLSurfaceView_13);
                str = "translationX";
            } else {
                this.f21966aS.setTranslationY(-this.f21970aW);
                OplusGLSurfaceView_13 = this.f21970aW;
                str = "translationY";
            }
            this.f21966aS.setVisibility(0);
            if (this.f21969aV == null || Util.m24498u()) {
                this.f21969aV = new AnimatorSet();
                ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.f21966aS, "alpha", 0.0f, 1.0f);
                objectAnimatorOfFloat.setInterpolator(this.f22027l);
                objectAnimatorOfFloat.setDuration(300L);
                ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.f21966aS, str, OplusGLSurfaceView_13, 0.0f);
                objectAnimatorOfFloat2.setInterpolator(this.f22028m);
                objectAnimatorOfFloat2.setDuration(300L);
                this.f21969aV.play(objectAnimatorOfFloat).with(objectAnimatorOfFloat2);
                this.f21969aV.addListener(new AnimatorListenerAdapter() { // from class: com.oplus.camera.ui.preview.COUIBaseListPopupWindow_11.25
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        if (CameraPreviewUI.this.f21966aS != null) {
                            CameraPreviewUI.this.f21966aS.setAlpha(1.0f);
                            CameraPreviewUI.this.f21966aS.setTranslationY(0.0f);
                            CameraPreviewUI.this.f21966aS.setTranslationX(0.0f);
                            CameraPreviewUI.this.f21966aS.setVisibility(0);
                        }
                    }
                });
                this.f21969aV.setStartDelay(150L);
            }
            this.f21969aV.start();
            return;
        }
        this.f21966aS.setVisibility(0);
    }

    /* renamed from: OplusGLSurfaceView_11 */
    protected void m23417n(boolean z) {
        int OplusGLSurfaceView_13;
        String str;
        CameraLog.m12954a("CameraPreviewUI", "hideMultiTypeView, needAnim: " + z);
        AnimatorSet animatorSet = this.f21969aV;
        if (animatorSet != null && animatorSet.isStarted()) {
            this.f21969aV.cancel();
        } else {
            MultiCameraTypeSelectLayout c3518a = this.f21966aS;
            if (c3518a != null && !c3518a.isShown()) {
                return;
            }
            AnimatorSet animatorSet2 = this.f21968aU;
            if (animatorSet2 != null && animatorSet2.isStarted()) {
                return;
            }
        }
        if (z) {
            if (this.f21968aU == null || Util.m24498u()) {
                this.f21968aU = new AnimatorSet();
                ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.f21966aS, "alpha", 1.0f, 0.0f);
                objectAnimatorOfFloat.setInterpolator(this.f22027l);
                objectAnimatorOfFloat.setDuration(300L);
                boolean z2 = 1 == this.f21984ak.mo18134aX();
                int iMo19935ei = this.f21984ak.mo19935ei();
                if (z2) {
                    OplusGLSurfaceView_13 = 270 == iMo19935ei ? this.f21970aW : -this.f21970aW;
                    str = "translationX";
                } else {
                    OplusGLSurfaceView_13 = this.f21970aW;
                    str = "translationY";
                }
                ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.f21966aS, str, 0.0f, OplusGLSurfaceView_13);
                objectAnimatorOfFloat2.setInterpolator(this.f22028m);
                objectAnimatorOfFloat2.setDuration(300L);
                this.f21968aU.play(objectAnimatorOfFloat).with(objectAnimatorOfFloat2);
                this.f21968aU.addListener(new AnimatorListenerAdapter() { // from class: com.oplus.camera.ui.preview.COUIBaseListPopupWindow_11.26
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                        if (CameraPreviewUI.this.f21966aS != null) {
                            CameraPreviewUI.this.f21966aS.setTranslationX(0.0f);
                            CameraPreviewUI.this.f21966aS.setTranslationY(0.0f);
                            CameraPreviewUI.this.f21966aS.setAlpha(1.0f);
                            CameraPreviewUI.this.f21966aS.setVisibility(0);
                            CameraPreviewUI.this.f21966aS.setClipToPadding(false);
                            CameraPreviewUI.this.f21966aS.setClipChildren(false);
                            CameraPreviewUI.this.f21966aS.setClipToOutline(false);
                        }
                    }

                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        if (CameraPreviewUI.this.f21966aS != null) {
                            CameraPreviewUI.this.f21966aS.setVisibility(8);
                            CameraPreviewUI.this.f21966aS.setTranslationX(0.0f);
                            CameraPreviewUI.this.f21966aS.setTranslationY(0.0f);
                            CameraPreviewUI.this.f21966aS.setAlpha(0.0f);
                        }
                    }
                });
            }
            this.f21968aU.start();
            return;
        }
        MultiCameraTypeSelectLayout c3518a2 = this.f21966aS;
        if (c3518a2 != null) {
            c3518a2.setVisibility(8);
        }
    }

    /* renamed from: aJ */
    private void m23231aJ() throws Resources.NotFoundException {
        this.f21970aW = this.f21945X.getResources().getDimensionPixelSize(R.dimen.face_beauty_menu_translate_y);
        this.f21966aS = new MultiCameraTypeSelectLayout(this.f21945X, this.f21984ak.mo18134aX());
        this.f21966aS.setId(R.id_renamed.multivideo_type_select_view);
        RelativeLayout.LayoutParams layoutParamsMo16510d = this.f21984ak.mo19936ej().mo16510d();
        this.f21966aS.setClipChildren(false);
        this.f21966aS.setClipToOutline(false);
        this.f21994au.addView(this.f21966aS, layoutParamsMo16510d);
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.oplus.camera.ui.preview.COUIBaseListPopupWindow_11.27
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.isEnabled() && CameraPreviewUI.this.f21984ak != null && CameraPreviewUI.this.f21984ak.mo19929ec() && !CameraPreviewUI.this.f21984ak.mo19900dr() && CameraPreviewUI.this.m23430x() != null && CameraPreviewUI.this.m23430x().m23490u() && CameraPreviewUI.this.m23430x().m23491v()) {
                    CameraPreviewUI.this.f21966aS.m24087a(view);
                }
            }
        };
        this.f21966aS.m24086a(this.f21982ai, false);
        this.f21966aS.findViewById(R.id_renamed.view_half_half).setOnClickListener(onClickListener);
        this.f21966aS.findViewById(R.id_renamed.view_pip_cir).setOnClickListener(onClickListener);
        this.f21966aS.findViewById(R.id_renamed.view_pip_rec).setOnClickListener(onClickListener);
        this.f21966aS.setOnTypeChangeListener(new MultiCameraTypeSelectLayout.PlatformImplementations.kt_3() { // from class: com.oplus.camera.ui.preview.-$$Lambda$COUIBaseListPopupWindow_11$pP_s_NNnin5PO1bxO11P5IVfFV4
            @Override // com.oplus.camera.p172ui.widget.MultiCameraTypeSelectLayout.PlatformImplementations.kt_3
            public final void onTypeChanged(int OplusGLSurfaceView_13) {
                this.COUIBaseListPopupWindow_12$0.m23283j(OplusGLSurfaceView_13);
            }
        });
        this.f21966aS.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: OplusGLSurfaceView_15 */
    public /* synthetic */ void m23283j(int OplusGLSurfaceView_13) {
        IntrinsicsJvm.kt_4 bVar = this.f21984ak;
        if (bVar != null) {
            bVar.mo19635S(OplusGLSurfaceView_13);
        }
    }

    /* renamed from: ag */
    public boolean m23367ag() {
        MultiCameraTypeSelectLayout c3518a = this.f21966aS;
        return c3518a != null && c3518a.getVisibility() == 0;
    }

    /* renamed from: ah */
    public boolean m23368ah() {
        return this.f21967aT;
    }

    /* renamed from: ai */
    public boolean m23369ai() {
        AnimatorSet animatorSet;
        AnimatorSet animatorSet2 = this.f21969aV;
        return (animatorSet2 != null && animatorSet2.isStarted()) || ((animatorSet = this.f21968aU) != null && animatorSet.isStarted());
    }

    /* renamed from: o */
    public void m23419o(boolean z) {
        MultiCameraTypeSelectLayout c3518a = this.f21966aS;
        if (c3518a != null) {
            c3518a.setEnabled(z);
        }
    }

    /* compiled from: CameraPreviewUI.java */
    /* renamed from: com.oplus.camera.ui.preview.COUIBaseListPopupWindow_11$IntrinsicsJvm.kt_5 */
    public class IntrinsicsJvm.kt_5 extends AccelerateInterpolator {
        public IntrinsicsJvm.kt_5() {
        }

        @Override // android.view.animation.AccelerateInterpolator, android.animation.TimeInterpolator
        public float getInterpolation(float COUIBaseListPopupWindow_12) {
            if (Math.abs(COUIBaseListPopupWindow_12 - 1.0f) <= 1.0E-6d && !CameraPreviewUI.this.f22005bf) {
                CameraPreviewUI.this.m23244at();
            }
            return ((float) (Math.cos((COUIBaseListPopupWindow_12 + 1.0f) * 3.141592653589793d) / 2.0d)) + 0.5f;
        }
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    public void m23401g(int OplusGLSurfaceView_13) {
        CameraLog.m12959b("CameraPreviewUI", "setSlowVideoMotionDetectViewVisibility: " + OplusGLSurfaceView_13);
        IntelligentDragView intelligentDragView = this.f21979af;
        if (intelligentDragView != null) {
            if (8 == intelligentDragView.getVisibility()) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f21979af.getLayoutParams();
                layoutParams.addRule(14);
                int screenHeight = (Util.getScreenHeight() - Util.getSettingMenuPanelHeight()) - Util.m24187O();
                layoutParams.setMargins(0, (int) ((screenHeight - this.f21945X.getResources().getDimension(R.dimen.video_intelligent_high_frame_dectect_height)) / 2.0f), 0, 0);
                this.f21979af.setLayoutParams(layoutParams);
                this.f21979af.setBottomRestrict(this.f21989ap.getHeight() - screenHeight);
                this.f21979af.m22170b();
            }
            this.f21979af.setVisibility(OplusGLSurfaceView_13);
        }
    }

    /* renamed from: p */
    public void m23421p(boolean z) {
        CameraLog.m12959b("CameraPreviewUI", "enableSlowVideoMotionDetectView: " + z);
        IntelligentDragView intelligentDragView = this.f21979af;
        if (intelligentDragView != null) {
            intelligentDragView.setEnabled(z);
        }
    }

    /* renamed from: COUIBaseListPopupWindow_10 */
    public RectF m23403h(int OplusGLSurfaceView_13) {
        IntelligentDragView intelligentDragView = this.f21979af;
        if (intelligentDragView != null) {
            return intelligentDragView.m22167a(m23429w(), OplusGLSurfaceView_13);
        }
        return null;
    }

    /* renamed from: aj */
    public void m23370aj() {
        FaceView faceView = this.f21976ac;
        if (faceView != null) {
            faceView.m22156g();
        }
    }

    @Override // com.oplus.camera.p172ui.preview.FacePointAnimationManager.IntrinsicsJvm.kt_4
    /* renamed from: ak */
    public void mo23371ak() {
        FaceView faceView = this.f21976ac;
        if (faceView != null) {
            faceView.m22151b();
        }
    }

    @Override // com.oplus.camera.p172ui.preview.FacePointAnimationManager.IntrinsicsJvm.kt_4
    /* renamed from: al */
    public void mo23372al() {
        if (this.f21946Y != null) {
            CameraLog.m12967f("CameraPreviewUI", "endFacePointAnimation");
            this.f21946Y.edit().putInt(CameraUIInterface.KEY_CAMERA_PID_HISTORY, Process.myPid()).putInt(CameraUIInterface.KEY_SUPPORT_FRONT_FACE_POINT_ANIMATION, Util.m24427d(System.currentTimeMillis())).apply();
        }
    }

    @Override // com.oplus.camera.p172ui.preview.FacePointAnimationManager.IntrinsicsJvm.kt_4
    /* renamed from: am */
    public boolean mo23373am() {
        IntrinsicsJvm.kt_4 bVar = this.f21984ak;
        return bVar != null && bVar.mo19966j(CameraUIInterface.KEY_SUPPORT_FRONT_FACE_POINT_ANIMATION) && this.f21946Y.getBoolean("pref_camera_statement_key", false);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m23352a(FacePointAnimationManager.IntrinsicsJvm.kt_4 bVar) {
        FaceView faceView = this.f21976ac;
        if (faceView != null) {
            faceView.setFacePointAnimationListener(bVar);
        }
    }

    /* renamed from: an */
    public void m23374an() {
        if (this.f22000ba == null) {
            int OplusGLSurfaceView_13 = this.f21946Y.getInt(CameraUIInterface.KEY_DOUBLE_EXPOSURE_EFFECT_TYPE, 5);
            this.f22000ba = new RecyclerView(this.f21945X);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(12);
            layoutParams.addRule(14);
            layoutParams.setMargins(0, 0, 0, (int) this.f21945X.getResources().getDimension(R.dimen.effect_menu_margin_bottom_not_zoom));
            this.f22000ba.setVisibility(4);
            this.f22000ba.setClipChildren(false);
            this.f21994au.addView(this.f22000ba, layoutParams);
            final float dimensionPixelSize = this.f21945X.getResources().getDimensionPixelSize(R.dimen.effect_menu_margin);
            this.f22000ba.setLayoutManager(new LinearLayoutManager(this.f21945X, 0, false));
            this.f22000ba.addItemDecoration(new RecyclerView.AbstractC0692h() { // from class: com.oplus.camera.ui.preview.COUIBaseListPopupWindow_11.28
                @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0692h
                public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.C0704t c0704t) {
                    LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
                    super.getItemOffsets(rect, view, recyclerView, c0704t);
                    if (linearLayoutManager != null) {
                        if (linearLayoutManager.getPosition(view) == 0) {
                            rect.right = (int) (dimensionPixelSize * 0.5f);
                        } else {
                            rect.left = (int) (dimensionPixelSize * 0.5f);
                        }
                    }
                }
            });
            ArrayList arrayList = new ArrayList();
            arrayList.add(new EffectType(5, R.drawable.double_exposure_composition, this.f21945X.getString(R.string.camera_double_exposure_type_composition), 5 == OplusGLSurfaceView_13));
            arrayList.add(new EffectType(4, R.drawable.double_exposure_sketch, this.f21945X.getString(R.string.camera_double_exposure_type_sketch), 4 == OplusGLSurfaceView_13));
            EffectMenuAdapter c2686e = new EffectMenuAdapter(this.f21945X, arrayList);
            this.f22001bb = new EffectMenuAdapter.IntrinsicsJvm.kt_4() { // from class: com.oplus.camera.ui.preview.COUIBaseListPopupWindow_11.29
                @Override // com.oplus.camera.doubleexposure.EffectMenuAdapter.IntrinsicsJvm.kt_4
                /* renamed from: PlatformImplementations.kt_3 */
                public void mo12921a(EffectType c2687f) {
                    if (CameraPreviewUI.this.f21984ak != null) {
                        CameraPreviewUI.this.f21984ak.mo19672a(c2687f);
                        if (c2687f != null) {
                            CameraPreviewUI.this.f21946Y.edit().putInt(CameraUIInterface.KEY_DOUBLE_EXPOSURE_EFFECT_TYPE, c2687f.m12922a()).apply();
                        }
                    }
                }
            };
            c2686e.m12920a(this.f22001bb);
            this.f22000ba.setAdapter(c2686e);
        }
    }

    /* renamed from: ao */
    public void m23375ao() {
        RecyclerView recyclerView = this.f22000ba;
        if (recyclerView != null) {
            Util.m24270a(recyclerView, 4, (Animation.AnimationListener) null, 300L);
        }
    }

    /* renamed from: ap */
    public RecyclerView m23376ap() {
        if (this.f22000ba == null) {
            m23374an();
        }
        return this.f22000ba;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m23342a(View view, View view2, boolean z) throws Resources.NotFoundException {
        if (view != null && view2 != null && (!z || this.f22031p)) {
            view.setVisibility(0);
            view2.setVisibility(4);
            return;
        }
        if (view2 == null) {
            if (view != null) {
                Util.m24270a(view, 0, (Animation.AnimationListener) null, 300L);
                return;
            }
            return;
        }
        Interpolator interpolatorLoadInterpolator = AnimationUtils.loadInterpolator(view2.getContext(), R.anim.face_point_scale_interpolator2);
        if (view2.getVisibility() == 0) {
            Util.m24271a(view2, 4, new ZoomAnimationListener(true, view, view2), 180L, 0L, interpolatorLoadInterpolator);
        } else if (view != null) {
            Util.m24270a(view, 0, (Animation.AnimationListener) null, 300L);
        }
    }

    /* compiled from: CameraPreviewUI.java */
    /* renamed from: com.oplus.camera.ui.preview.COUIBaseListPopupWindow_11$COUIBaseListPopupWindow_8 */
    public static class COUIBaseListPopupWindow_8 {

        /* renamed from: PlatformImplementations.kt_3 */
        public int f22086a;

        /* renamed from: IntrinsicsJvm.kt_4 */
        public int f22087b;

        public COUIBaseListPopupWindow_8(int OplusGLSurfaceView_13, int i2) {
            this.f22086a = 0;
            this.f22087b = 0;
            this.f22086a = OplusGLSurfaceView_13;
            this.f22087b = i2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: aK */
    public void m23232aK() {
        synchronized (this.f22030o) {
            float fUptimeMillis = SystemClock.uptimeMillis() - this.f21942U;
            float interpolation = this.f22024i.getInterpolation(fUptimeMillis / this.f21944W);
            if (this.f21933L != 0) {
                if (fUptimeMillis < this.f21944W) {
                    this.f21930I = this.f21954aG.getHeight() + ((int) (this.f21933L * interpolation));
                } else {
                    this.f21930I = this.f21953aF.getHeight();
                    this.f21933L = 0;
                }
            }
            if (this.f21951aD != 0) {
                if (fUptimeMillis < this.f21944W) {
                    this.f21923B = this.f21924C + ((int) (this.f21951aD * interpolation));
                } else {
                    this.f21923B = this.f21924C + this.f21951aD;
                    this.f21951aD = 0;
                    CameraLog.m12954a("CameraPreviewUI", "calcScreenModeChangeAnimOffset, translate x end, mOffsetX: " + this.f21923B);
                }
            }
            if (this.f21952aE != 0) {
                if (fUptimeMillis < this.f21944W) {
                    this.f21926E = this.f21927F + ((int) (this.f21952aE * interpolation));
                } else {
                    this.f21926E = this.f21927F + this.f21952aE;
                    this.f21952aE = 0;
                    CameraLog.m12954a("CameraPreviewUI", "calcScreenModeChangeAnimOffset, translate y end, mOffsetY: " + this.f21926E);
                }
            }
            if (this.f21932K != 0) {
                if (fUptimeMillis < this.f21944W) {
                    this.f21931J = this.f21954aG.getWidth() + ((int) (this.f21932K * interpolation));
                } else {
                    this.f21931J = this.f21953aF.getWidth();
                    this.f21932K = 0;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: aL */
    public void m23233aL() {
        if (this.f21984ak == null) {
            return;
        }
        if (this.f22012bm != m23245au() || this.f22013bn != m23246av() || this.f22014bo != m23247aw() || this.f22015bp != m23248ax()) {
            this.f22012bm = m23245au();
            this.f22013bn = m23246av();
            this.f22014bo = m23247aw();
            this.f22015bp = m23248ax();
            this.f21984ak.mo19651a(this.f22012bm, this.f22013bn, this.f22014bo, this.f22015bp);
        }
        BaseScreenMode abstractC2934aMo19936ej = this.f21984ak.mo19936ej();
        String strMo16516h = abstractC2934aMo19936ej.mo16516h();
        Size sizeM24180I = Util.m24180I();
        if (sizeM24180I.getHeight() == 0 || sizeM24180I.getWidth() == 0) {
            return;
        }
        synchronized (this.f22030o) {
            if (this.f21922A) {
                return;
            }
            if (!this.f22011bl.equals(sizeM24180I) || (!this.f22037v && !this.f21957aJ && this.f21932K == 0 && this.f21933L == 0 && this.f21951aD == 0 && this.f21952aE == 0 && !strMo16516h.equals(this.f22010bk))) {
                Rect rectB = abstractC2934aMo19936ej.mo16558b(sizeM24180I.getHeight(), sizeM24180I.getWidth());
                CameraLog.m12959b("CameraPreviewUI", "checkPreviewRegion, screenModeName: " + strMo16516h + ", mLastScreenModeName: " + this.f22010bk + ", previewSize: " + sizeM24180I + ", previewRect: " + rectB);
                if (rectB.width() == 0) {
                    return;
                }
                if (rectB.left != this.f21923B || rectB.top != this.f21926E || rectB.width() != this.f21930I || rectB.height() != this.f21931J) {
                    if (this.f21931J == 0 || this.f21930I == 0) {
                        this.f21923B = rectB.left;
                        this.f21926E = rectB.top;
                        this.f21930I = rectB.width();
                        this.f21931J = rectB.height();
                        this.f22010bk = strMo16516h;
                        this.f22011bl = sizeM24180I;
                        CameraLog.m12967f("CameraPreviewUI", "checkPreviewRegion, mOffsetX: " + this.f21923B + ", mOffsetY: " + this.f21926E + ", mWidth: " + this.f21930I + ", mHeight: " + this.f21931J);
                    } else if (!this.f22031p) {
                        m23344a(abstractC2934aMo19936ej, sizeM24180I);
                    }
                } else if (!this.f21957aJ) {
                    this.f22010bk = this.f21984ak.mo19936ej().mo16516h();
                    this.f22011bl = sizeM24180I;
                }
            }
        }
    }

    /* renamed from: q */
    public void m23423q(boolean z) {
        CameraLog.m12959b("CameraPreviewUI", "startShowPreviewImageAnimation, isChanging: " + z);
        synchronized (this.f22030o) {
            this.f21922A = z;
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m23345a(BaseScreenMode abstractC2934a, BaseScreenMode abstractC2934a2) {
        if (!Util.m24498u() || this.f22025j) {
            return;
        }
        m23314O().setRenderMode(1);
        this.f22017br.postDelayed(new Runnable() { // from class: com.oplus.camera.ui.preview.COUIBaseListPopupWindow_11.31
            @Override // java.lang.Runnable
            public void run() {
                synchronized (CameraPreviewUI.this.f22030o) {
                    if (!CameraPreviewUI.this.f21957aJ && CameraPreviewUI.this.f21959aL != null) {
                        CameraPreviewUI.this.f21959aL.setRenderMode(0);
                    }
                }
            }
        }, 500L);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m23354a(Runnable runnable) {
        this.f22016bq = runnable;
    }
}

package com.oplus.camera;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.PathInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.oplus.camera.ScaleGestureDetector;
import com.oplus.camera.aps.config.CameraConfig;
import com.oplus.camera.aps.config.ConfigDataBase;
import com.oplus.camera.aps.constant.ApsConstant;
import com.oplus.camera.capmode.CameraInterface;
import com.oplus.camera.p137b.SimpleAnimatorListener;
import com.oplus.camera.p141e.CameraCharacteristicsUtil;
import com.oplus.camera.p146gl.p148b.MultiVideoSmallSurfaceTouchEventHelper;
import com.oplus.camera.p172ui.CameraSeekBar;
import com.oplus.camera.p172ui.ZoomClickChangeView;
import com.oplus.camera.p172ui.CameraUIInterface;
import com.oplus.camera.p172ui.RotableTextView;
import com.oplus.camera.p172ui.inverse.InverseManager;
import com.oplus.camera.p172ui.preview.ZoomSeekBar;
import com.oplus.camera.p172ui.preview.ZoomArcSeekBar;
import com.oplus.camera.p172ui.preview.ZoomListener;
import com.oplus.camera.p172ui.widget.InertiaZoomBar;
import com.oplus.camera.p172ui.widget.InertialZoomButton;
import com.oplus.camera.screen.ScreenModeManager;
import com.oplus.camera.statistics.model.DcsMsgData;
import com.oplus.camera.statistics.model.ZoomAdjustMsgData;
import com.oplus.camera.util.Util;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Locale;

/* compiled from: ZoomManager.java */
/* renamed from: com.oplus.camera.ag */
/* loaded from: classes2.dex */
public class ZoomManager {

    /* renamed from: PlatformImplementations.kt_3 */
    public static final float f12334a = CameraConfig.getConfigFloatValue(ConfigDataBase.KEY_ULTAR_WIDE_ZOOM_POINT_VALUE);

    /* renamed from: IntrinsicsJvm.kt_4 */
    private static final float f12335b = f12334a;

    /* renamed from: B */
    private ZoomSeekBar f12337B;

    /* renamed from: L */
    private Activity f12347L;

    /* renamed from: M */
    private Resources f12348M;

    /* renamed from: N */
    private ComboPreferences f12349N;

    /* renamed from: O */
    private CameraInterface f12350O;

    /* renamed from: Y */
    private ViewGroup f12360Y;

    /* renamed from: aa */
    private DecimalFormat f12362aa;

    /* renamed from: ab */
    private ScreenModeManager f12363ab;

    /* renamed from: OplusGLSurfaceView_14 */
    private int f12386l;

    /* renamed from: OplusGLSurfaceView_6 */
    private int f12387m;

    /* renamed from: OplusGLSurfaceView_11 */
    private int f12388n;

    /* renamed from: o */
    private int f12389o;

    /* renamed from: p */
    private int f12390p;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private ArrayList<Float> f12377c = new ArrayList<>();

    /* renamed from: IntrinsicsJvm.kt_5 */
    private ArrayList<Float> f12378d = new ArrayList<>();

    /* renamed from: COUIBaseListPopupWindow_8 */
    private ArrayList<Float> f12379e = new ArrayList<>();

    /* renamed from: COUIBaseListPopupWindow_12 */
    private float f12380f = 1.0f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private float f12381g = 1.0f;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private float f12382h = 0.0f;

    /* renamed from: OplusGLSurfaceView_13 */
    private float f12383i = 0.0f;

    /* renamed from: OplusGLSurfaceView_15 */
    private float f12384j = 0.0f;

    /* renamed from: OplusGLSurfaceView_5 */
    private float f12385k = 0.0f;

    /* renamed from: q */
    private int f12391q = 0;

    /* renamed from: r */
    private int f12392r = 0;

    /* renamed from: s */
    private int f12393s = 0;

    /* renamed from: t */
    private boolean f12394t = false;

    /* renamed from: u */
    private boolean f12395u = false;

    /* renamed from: v */
    private boolean f12396v = false;

    /* renamed from: w */
    private boolean f12397w = false;

    /* renamed from: x */
    private boolean f12398x = false;

    /* renamed from: y */
    private boolean f12399y = false;

    /* renamed from: z */
    private boolean f12400z = false;

    /* renamed from: A */
    private PlatformImplementations.kt_3 f12336A = null;

    /* renamed from: C */
    private RelativeLayout f12338C = null;

    /* renamed from: D */
    private LinearLayout f12339D = null;

    /* renamed from: E */
    private InertiaZoomBar f12340E = null;

    /* renamed from: F */
    private InertialZoomButton f12341F = null;

    /* renamed from: G */
    private InertialZoomButton f12342G = null;

    /* renamed from: H */
    private RotableTextView f12343H = null;

    /* renamed from: I */
    private ZoomClickChangeView f12344I = null;

    /* renamed from: J */
    private RotableTextView f12345J = null;

    /* renamed from: K */
    private ScaleGestureDetector f12346K = null;

    /* renamed from: P */
    private ZoomConfigure f12351P = null;

    /* renamed from: Q */
    private Rect f12352Q = null;

    /* renamed from: R */
    private ValueAnimator f12353R = null;

    /* renamed from: S */
    private ValueAnimator f12354S = null;

    /* renamed from: T */
    private AnimatorSet f12355T = null;

    /* renamed from: U */
    private AnimatorSet f12356U = null;

    /* renamed from: V */
    private AnimatorSet f12357V = null;

    /* renamed from: W */
    private AnimatorSet f12358W = null;

    /* renamed from: X */
    private ValueAnimator f12359X = null;

    /* renamed from: Z */
    private Handler f12361Z = null;

    /* renamed from: ac */
    private int f12364ac = 0;

    /* renamed from: ad */
    private int f12365ad = 0;

    /* renamed from: ae */
    private String f12366ae = "";

    /* renamed from: af */
    private boolean f12367af = false;

    /* renamed from: ag */
    private boolean f12368ag = false;

    /* renamed from: ah */
    private boolean f12369ah = false;

    /* renamed from: ai */
    private boolean f12370ai = false;

    /* renamed from: aj */
    private boolean f12371aj = false;

    /* renamed from: ak */
    private boolean f12372ak = false;

    /* renamed from: al */
    private boolean f12373al = false;

    /* renamed from: am */
    private PathInterpolator f12374am = new PathInterpolator(0.42f, 0.42f, 0.52f, 0.92f);

    /* renamed from: an */
    private PathInterpolator f12375an = new PathInterpolator(0.33f, 0.0f, 0.67f, 1.0f);

    /* renamed from: ao */
    private PathInterpolator f12376ao = new PathInterpolator(0.3f, 0.0f, 0.1f, 1.0f);

    /* compiled from: ZoomManager.java */
    /* renamed from: com.oplus.camera.ag$PlatformImplementations.kt_3 */
    public interface PlatformImplementations.kt_3 {
        /* renamed from: A */
        boolean mo10956A();

        /* renamed from: B */
        boolean mo10957B();

        /* renamed from: C */
        boolean mo10958C();

        /* renamed from: D */
        int mo10959D();

        /* renamed from: PlatformImplementations.kt_3 */
        void mo10960a(float COUIBaseListPopupWindow_12, boolean z);

        /* renamed from: PlatformImplementations.kt_3 */
        void mo10961a(float COUIBaseListPopupWindow_12, boolean z, float f2);

        /* renamed from: PlatformImplementations.kt_3 */
        void mo10962a(int OplusGLSurfaceView_13);

        /* renamed from: PlatformImplementations.kt_3 */
        void mo10963a(boolean z);

        /* renamed from: PlatformImplementations.kt_3 */
        boolean mo10964a();

        /* renamed from: PlatformImplementations.kt_3 */
        boolean mo10966a(String str);

        /* renamed from: IntrinsicsJvm.kt_4 */
        void mo10967b(float COUIBaseListPopupWindow_12);

        /* renamed from: IntrinsicsJvm.kt_4 */
        void mo10968b(int OplusGLSurfaceView_13);

        /* renamed from: IntrinsicsJvm.kt_4 */
        void mo10969b(boolean z);

        /* renamed from: IntrinsicsJvm.kt_4 */
        boolean mo10970b();

        /* renamed from: IntrinsicsJvm.kt_3 */
        void mo10971c();

        /* renamed from: IntrinsicsJvm.kt_3 */
        void mo10972c(float COUIBaseListPopupWindow_12);

        /* renamed from: IntrinsicsJvm.kt_3 */
        void mo10973c(boolean z);

        /* renamed from: IntrinsicsJvm.kt_5 */
        void mo10974d();

        /* renamed from: IntrinsicsJvm.kt_5 */
        void mo10975d(boolean z);

        /* renamed from: COUIBaseListPopupWindow_8 */
        boolean mo10976e();

        /* renamed from: COUIBaseListPopupWindow_12 */
        void mo10977f();

        /* renamed from: COUIBaseListPopupWindow_11 */
        void mo10978g();

        /* renamed from: COUIBaseListPopupWindow_10 */
        void mo10979h();

        /* renamed from: OplusGLSurfaceView_13 */
        void mo10980i();

        /* renamed from: OplusGLSurfaceView_15 */
        void mo10981j();

        /* renamed from: OplusGLSurfaceView_5 */
        void mo10982k();

        /* renamed from: OplusGLSurfaceView_14 */
        boolean mo10983l();

        /* renamed from: OplusGLSurfaceView_6 */
        boolean mo10984m();

        /* renamed from: OplusGLSurfaceView_11 */
        String mo10985n();

        /* renamed from: o */
        boolean mo10986o();

        /* renamed from: p */
        void mo10987p();

        /* renamed from: q */
        void mo10988q();

        /* renamed from: r */
        void mo10989r();

        /* renamed from: s */
        boolean mo10990s();

        /* renamed from: t */
        boolean mo10991t();

        /* renamed from: u */
        boolean mo10992u();

        /* renamed from: v */
        boolean mo10993v();

        /* renamed from: w */
        boolean mo10994w();

        /* renamed from: x */
        boolean mo10995x();

        /* renamed from: y */
        boolean mo10996y();

        /* renamed from: z */
        boolean mo10997z();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: IntrinsicsJvm.kt_5 */
    public float m11442d(float COUIBaseListPopupWindow_12) {
        return ((COUIBaseListPopupWindow_12 / 100.0f) * 10.0f) - 5.0f;
    }

    public ZoomManager(Activity activity, ComboPreferences comboPreferences, CameraInterface interfaceC2646a, ViewGroup viewGroup, ScreenModeManager c2953g) {
        this.f12386l = 0;
        this.f12387m = 0;
        this.f12388n = 0;
        this.f12389o = 0;
        this.f12390p = 0;
        this.f12337B = null;
        this.f12347L = null;
        this.f12348M = null;
        this.f12349N = null;
        this.f12350O = null;
        this.f12360Y = null;
        this.f12362aa = null;
        this.f12363ab = null;
        this.f12363ab = c2953g;
        this.f12347L = activity;
        this.f12348M = this.f12347L.getResources();
        this.f12349N = comboPreferences;
        this.f12350O = interfaceC2646a;
        this.f12360Y = viewGroup;
        this.f12337B = new ZoomArcSeekBar(this.f12347L);
        this.f12337B.setScreenModeManager(c2953g);
        InverseManager.INS.registerInverse(this.f12347L, this.f12337B);
        this.f12337B.setId(R.id_renamed.zoom_seek_bar);
        this.f12386l = this.f12348M.getDimensionPixelSize(R.dimen.zoom_gesture_scale_step);
        this.f12389o = this.f12348M.getDimensionPixelSize(R.dimen.zoom_current_indicator_move_distance_max);
        this.f12387m = this.f12348M.getDimensionPixelSize(R.dimen.zoom_current_text_move_distance_max);
        this.f12388n = this.f12347L.getResources().getDimensionPixelSize(R.dimen.face_beauty_enter_button_animation_y);
        this.f12390p = this.f12348M.getDimensionPixelSize(R.dimen.inertial_zoombar_anim_transx);
        this.f12362aa = new DecimalFormat("0.0", DecimalFormatSymbols.getInstance(Locale.US));
        this.f12377c.add(Float.valueOf(1.0f));
        this.f12377c.add(Float.valueOf(5.0f));
        this.f12377c.add(Float.valueOf(10.0f));
        this.f12377c.add(Float.valueOf(10.1f));
        this.f12337B.setOnSeekBarChangeListener(new CameraSeekBar.PlatformImplementations.kt_3() { // from class: com.oplus.camera.ag.1
            @Override // com.oplus.camera.p172ui.CameraSeekBar.PlatformImplementations.kt_3
            /* renamed from: PlatformImplementations.kt_3 */
            public void mo11547a(float COUIBaseListPopupWindow_12) {
                if (ZoomManager.this.f12344I != null) {
                    ZoomManager.this.f12344I.setFromClickView(false);
                }
                if (ZoomManager.this.f12350O != null && ZoomManager.this.f12350O.mo10496a(COUIBaseListPopupWindow_12, ZoomManager.this.f12380f) && ZoomManager.this.f12350O.mo10500aB()) {
                    ZoomManager.this.f12395u = true;
                }
                if (ZoomManager.this.f12336A != null && ZoomManager.this.f12336A.mo10966a(CameraUIInterface.KEY_FRONT_ZOOM_SWITCH)) {
                    ZoomManager.this.f12336A.mo10973c(COUIBaseListPopupWindow_12 == 1.0f);
                    if (ZoomManager.this.f12336A == null || !ZoomManager.this.f12336A.mo10986o()) {
                        return;
                    }
                    ZoomManager.this.f12336A.mo10988q();
                    return;
                }
                if (Float.compare(ZoomManager.f12334a, COUIBaseListPopupWindow_12) == 0) {
                    CameraTipsManager.m14374a().m14382g();
                }
                ZoomManager.this.m11434b(COUIBaseListPopupWindow_12, true);
                if (ZoomManager.this.f12336A == null || !ZoomManager.this.f12336A.mo10986o()) {
                    return;
                }
                if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_ONEPLUS_VIBRATE_SUPPORT)) {
                    ZoomManager.this.f12336A.mo10987p();
                } else {
                    ZoomManager.this.f12336A.mo10988q();
                }
            }

            @Override // com.oplus.camera.p172ui.CameraSeekBar.PlatformImplementations.kt_3
            /* renamed from: PlatformImplementations.kt_3 */
            public void mo11548a(float COUIBaseListPopupWindow_12, boolean z) {
                CameraLog.m12954a("ZoomManager", "onChanged, zoomValue: " + COUIBaseListPopupWindow_12);
                if (ZoomManager.this.f12351P.m11345h()) {
                    if (!ZoomManager.this.f12336A.mo10991t() || Float.compare(COUIBaseListPopupWindow_12, 2.0f) >= 0) {
                        if (!ZoomManager.this.f12336A.mo10991t() && Float.compare(COUIBaseListPopupWindow_12, 2.0f) >= 0 && !ZoomManager.this.f12336A.mo10993v()) {
                            ZoomManager.this.f12349N.edit().putString(CameraUIInterface.KEY_NONE_SAT_TELE_ANGLE, "on").apply();
                        }
                    } else {
                        ZoomManager.this.f12349N.edit().putString(CameraUIInterface.KEY_NONE_SAT_TELE_ANGLE, "off").apply();
                    }
                }
                if (!ZoomManager.this.f12351P.m11343g() || !ZoomManager.this.f12336A.mo10990s()) {
                    ZoomManager.this.m11452f(COUIBaseListPopupWindow_12);
                    ZoomManager.this.m11454g(COUIBaseListPopupWindow_12);
                    ZoomManager.this.m11418a(COUIBaseListPopupWindow_12, COUIBaseListPopupWindow_12, true, false);
                } else {
                    if (Float.compare(COUIBaseListPopupWindow_12, 1.0f) < 0 || !z) {
                        return;
                    }
                    ZoomManager.this.f12349N.edit().putString(CameraUIInterface.KEY_NONE_SAT_ULTRA_WIDE_ANGLE, "off").apply();
                    ZoomManager.this.m11452f(COUIBaseListPopupWindow_12);
                    ZoomManager.this.m11454g(COUIBaseListPopupWindow_12);
                }
            }

            @Override // com.oplus.camera.p172ui.CameraSeekBar.PlatformImplementations.kt_3
            /* renamed from: PlatformImplementations.kt_3 */
            public boolean mo11549a() {
                return ZoomManager.this.m11414Y();
            }

            @Override // com.oplus.camera.p172ui.CameraSeekBar.PlatformImplementations.kt_3
            /* renamed from: IntrinsicsJvm.kt_4 */
            public void mo11550b() {
                if (ZoomManager.this.f12336A != null) {
                    ZoomManager.this.f12336A.mo10977f();
                    ZoomManager.this.f12336A.mo10971c();
                }
                ZoomManager.this.m11411V();
                ZoomManager.this.m11491a(0);
                ZoomManager c2615ag = ZoomManager.this;
                c2615ag.m11448e(c2615ag.f12380f);
            }

            @Override // com.oplus.camera.p172ui.CameraSeekBar.PlatformImplementations.kt_3
            /* renamed from: IntrinsicsJvm.kt_3 */
            public void mo11552c() {
                if (ZoomManager.this.f12336A != null) {
                    ZoomManager.this.f12336A.mo10978g();
                    ZoomManager.this.f12336A.mo10974d();
                }
                if (!ZoomManager.this.f12351P.m11343g() || Float.compare(ZoomManager.this.f12337B.getCurrentZoom(), 1.0f) >= 0) {
                    return;
                }
                if (ZoomManager.this.f12351P.m11341f() || (ZoomManager.this.f12336A != null && ZoomManager.this.f12336A.mo10992u())) {
                    ZoomManager.this.f12337B.m23145b(ZoomManager.f12334a, false);
                } else {
                    ZoomManager.this.f12337B.m23145b(1.0f, false);
                }
                ZoomManager.this.m11433b(1.0f, 1.0f);
            }

            @Override // com.oplus.camera.p172ui.CameraSeekBar.PlatformImplementations.kt_3
            /* renamed from: IntrinsicsJvm.kt_5 */
            public void mo11554d() {
                if (ZoomManager.this.f12351P.m11343g() && ZoomManager.this.f12351P.m11341f() && ZoomManager.this.f12336A != null && !ZoomManager.this.f12336A.mo10992u()) {
                    ZoomManager.this.f12337B.m23145b(ZoomManager.f12334a, false);
                }
                if (ZoomManager.this.f12336A != null) {
                    ZoomManager.this.f12336A.mo10979h();
                }
            }

            @Override // com.oplus.camera.p172ui.CameraSeekBar.PlatformImplementations.kt_3
            /* renamed from: IntrinsicsJvm.kt_4 */
            public void mo11551b(float COUIBaseListPopupWindow_12) throws Resources.NotFoundException {
                float fM24201a = Util.m24201a(COUIBaseListPopupWindow_12, 0.0f, 1.0f);
                int color = ZoomManager.this.f12347L.getResources().getColor(R.color.plugin_background_30_percent_transparency_color);
                ZoomManager.this.f12336A.mo10968b(Color.argb((int) (fM24201a * Color.alpha(color)), Color.red(color), Color.green(color), Color.blue(color)));
            }

            @Override // com.oplus.camera.p172ui.CameraSeekBar.PlatformImplementations.kt_3
            /* renamed from: IntrinsicsJvm.kt_3 */
            public void mo11553c(float COUIBaseListPopupWindow_12) throws Resources.NotFoundException {
                if (ZoomManager.this.f12394t && ZoomManager.this.f12345J.getVisibility() == 0) {
                    ZoomManager.this.m11403N();
                }
                float fM24201a = Util.m24201a(COUIBaseListPopupWindow_12, 0.0f, 1.0f);
                int color = ZoomManager.this.f12347L.getResources().getColor(R.color.plugin_background_30_percent_transparency_color);
                ZoomManager.this.f12336A.mo10968b(Color.argb((int) (fM24201a * Color.alpha(color)), Color.red(color), Color.green(color), Color.blue(color)));
                ZoomManager.this.m11491a(4);
            }

            @Override // com.oplus.camera.p172ui.CameraSeekBar.PlatformImplementations.kt_3
            /* renamed from: COUIBaseListPopupWindow_8 */
            public void mo11556e() {
                float COUIBaseListPopupWindow_12;
                float currentZoom = ZoomManager.this.f12337B.getCurrentZoom();
                CameraLog.m12954a("ZoomManager", "onActionUpOnExpandState, zoomValue: " + currentZoom);
                if (ZoomManager.this.f12351P.m11343g()) {
                    if (!ZoomManager.this.f12336A.mo10992u()) {
                        if (!ZoomManager.this.f12336A.mo10990s() || Float.compare(currentZoom, ZoomManager.f12334a) <= 0) {
                            if (ZoomManager.this.f12336A.mo10990s() || Float.compare(currentZoom, 1.0f) >= 0) {
                                ZoomManager.this.m11448e(currentZoom);
                            } else {
                                if (Float.compare(currentZoom, 0.8f) > 0) {
                                    ZoomManager.this.f12337B.m23145b(1.0f, false);
                                } else {
                                    ZoomManager.this.f12349N.edit().putString(CameraUIInterface.KEY_NONE_SAT_ULTRA_WIDE_ANGLE, "on").apply();
                                    ZoomManager.this.f12337B.m23145b(ZoomManager.f12334a, false);
                                }
                                ZoomManager.this.m11448e(1.0f);
                                ZoomManager.this.m11433b(1.0f, 1.0f);
                            }
                        } else {
                            if (Float.compare(currentZoom, 0.8f) <= 0) {
                                ZoomManager.this.f12337B.m23145b(ZoomManager.f12334a, false);
                            } else {
                                ZoomManager.this.f12349N.edit().putString(CameraUIInterface.KEY_NONE_SAT_ULTRA_WIDE_ANGLE, "off").apply();
                                ZoomManager.this.f12337B.m23145b(1.0f, false);
                            }
                            ZoomManager.this.m11448e(1.0f);
                            ZoomManager.this.m11433b(1.0f, 1.0f);
                        }
                    } else if (Float.compare(currentZoom, 1.0f) < 0) {
                        ZoomManager.this.f12337B.m23145b(1.0f, false);
                        ZoomManager.this.m11448e(1.0f);
                        ZoomManager.this.m11433b(1.0f, 1.0f);
                    } else {
                        ZoomManager.this.f12337B.m23145b(currentZoom, false);
                        ZoomManager.this.m11448e(currentZoom);
                        ZoomManager.this.m11433b(currentZoom, currentZoom);
                    }
                }
                if (ZoomManager.this.f12336A.mo10990s()) {
                    CameraTipsManager.m14374a().m14382g();
                }
                ZoomClickChangeView c3525x = ZoomManager.this.f12344I;
                if (!ZoomManager.this.f12336A.mo10990s()) {
                    COUIBaseListPopupWindow_12 = ZoomManager.this.f12380f;
                } else {
                    COUIBaseListPopupWindow_12 = ZoomManager.f12334a;
                }
                c3525x.m24161a(COUIBaseListPopupWindow_12, true, true);
                ZoomManager.this.m11457h(2);
            }

            @Override // com.oplus.camera.p172ui.CameraSeekBar.PlatformImplementations.kt_3
            /* renamed from: COUIBaseListPopupWindow_12 */
            public void mo11557f() {
                CameraLog.m12954a("ZoomManager", "onActionDownOnExpandState");
                if (ZoomManager.this.f12336A != null) {
                    ZoomManager.this.f12336A.mo10971c();
                }
            }

            @Override // com.oplus.camera.p172ui.CameraSeekBar.PlatformImplementations.kt_3
            /* renamed from: IntrinsicsJvm.kt_5 */
            public void mo11555d(float COUIBaseListPopupWindow_12) {
                CameraLog.m12954a("ZoomManager", "onArcSeekBarClick, clicked zoomValue: " + COUIBaseListPopupWindow_12 + ", mCurrentZoomValue: " + ZoomManager.this.f12380f);
                ZoomManager.this.m11448e(COUIBaseListPopupWindow_12);
                ZoomManager.this.f12344I.m24160a(COUIBaseListPopupWindow_12, false);
                ZoomManager.this.f12380f = COUIBaseListPopupWindow_12;
                ZoomManager.this.m11457h(9);
            }

            @Override // com.oplus.camera.p172ui.CameraSeekBar.PlatformImplementations.kt_3
            /* renamed from: COUIBaseListPopupWindow_11 */
            public void mo11558g() {
                ZoomManager.this.m11388E();
            }

            @Override // com.oplus.camera.p172ui.CameraSeekBar.PlatformImplementations.kt_3
            /* renamed from: COUIBaseListPopupWindow_10 */
            public void mo11559h() {
                float currentZoom = ZoomManager.this.f12337B.getCurrentZoom();
                CameraLog.m12954a("ZoomManager", "onReboundAnimEnd, zoomValue: " + currentZoom);
                if (!ZoomManager.this.f12351P.m11343g() || ZoomManager.this.f12336A == null || ZoomManager.this.f12336A.mo10990s() || Float.compare(currentZoom, ZoomManager.f12334a) != 0) {
                    return;
                }
                ZoomManager.this.f12337B.m23145b(1.0f, false);
                ZoomManager.this.m11448e(1.0f);
                ZoomManager.this.m11433b(1.0f, 1.0f);
            }
        });
        m11386D();
    }

    /* renamed from: D */
    private void m11386D() {
        this.f12361Z = new Handler(Looper.getMainLooper()) { // from class: com.oplus.camera.ag.12
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                double dFloor;
                int OplusGLSurfaceView_13 = message.what;
                if (OplusGLSurfaceView_13 != 1) {
                    if (OplusGLSurfaceView_13 == 2) {
                        sendEmptyMessageDelayed(2, 25L);
                        ZoomManager.this.m11488a(-2.0f);
                        return;
                    } else {
                        if (OplusGLSurfaceView_13 != 3) {
                            return;
                        }
                        sendEmptyMessageDelayed(3, 25L);
                        ZoomManager.this.m11488a(2.0f);
                        return;
                    }
                }
                if (message.arg1 != 1) {
                    sendEmptyMessageDelayed(1, 25L);
                }
                ZoomManager c2615ag = ZoomManager.this;
                float fM11437c = c2615ag.m11437c(c2615ag.f12384j);
                if (message.arg1 == 1 && ZoomManager.this.m11393H() && !ZoomManager.this.f12340E.m23964b()) {
                    if (fM11437c > ZoomManager.this.f12380f) {
                        dFloor = Math.ceil(fM11437c * 10.0f);
                    } else if (fM11437c < ZoomManager.this.f12380f) {
                        dFloor = Math.floor(fM11437c * 10.0f);
                    }
                    fM11437c = (float) (dFloor / 10.0d);
                }
                ZoomManager.this.m11418a(fM11437c, fM11437c, false, true);
                ZoomManager.this.f12337B.m23145b(fM11437c, false);
                if (ZoomManager.this.m11393H()) {
                    if (ZoomManager.this.f12340E.m23964b()) {
                        ZoomManager.this.f12340E.setThumbText("");
                        if (ZoomManager.this.f12343H != null) {
                            ZoomManager.this.f12343H.setText(ZoomManager.this.m11412W());
                        }
                    } else if (message.arg1 != 1 || ZoomManager.this.f12343H == null) {
                        ZoomManager.this.f12340E.setThumbText(ZoomManager.this.f12337B.getCurrentDisplayText());
                    } else {
                        ZoomManager.this.f12343H.setText(ZoomManager.this.m11412W());
                        ZoomManager.this.f12340E.setThumbText(ZoomManager.this.f12337B.m23158j(fM11437c));
                    }
                }
                ZoomManager.this.f12398x = false;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: E */
    public void m11388E() {
        PlatformImplementations.kt_3 aVar = this.f12336A;
        if (aVar != null) {
            aVar.mo10989r();
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m11491a(int OplusGLSurfaceView_13) {
        ZoomClickChangeView c3525x = this.f12344I;
        if (c3525x == null || OplusGLSurfaceView_13 == c3525x.getVisibility()) {
            return;
        }
        this.f12344I.m24163b(OplusGLSurfaceView_13, true);
        this.f12337B.setZoomClickVisibility(OplusGLSurfaceView_13);
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private void m11439c(ViewGroup viewGroup) {
        CameraLog.m12954a("ZoomManager", "initFocusChooseView");
        if (this.f12344I == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(3, R.id_renamed.zoom_seek_bar);
            layoutParams.topMargin = this.f12347L.getResources().getDimensionPixelSize(R.dimen.zoom_click_margin_top);
            this.f12344I = new ZoomClickChangeView(this.f12347L);
            this.f12344I.setId(R.id_renamed.zoom_seek_bar_click);
            this.f12344I.setZoomUnit(this.f12337B.getZoomValueUnit());
            this.f12344I.setLayoutParams(layoutParams);
            this.f12338C.addView(this.f12344I);
            this.f12344I.setVisibility(4);
            this.f12344I.setListener(new ZoomClickChangeView.PlatformImplementations.kt_3() { // from class: com.oplus.camera.ag.16
                @Override // com.oplus.camera.p172ui.ZoomClickChangeView.PlatformImplementations.kt_3
                /* renamed from: PlatformImplementations.kt_3 */
                public void mo11560a(float COUIBaseListPopupWindow_12) {
                    ZoomManager.this.m11490a(COUIBaseListPopupWindow_12, true);
                    if (ZoomManager.this.f12337B.m23127A()) {
                        ZoomManager.this.m11448e(COUIBaseListPopupWindow_12);
                    }
                    if (mo11562a()) {
                        return;
                    }
                    if (COUIBaseListPopupWindow_12 == ZoomManager.this.f12385k || COUIBaseListPopupWindow_12 <= ZoomManager.this.f12382h) {
                        ZoomManager.this.f12344I.setFromClickView(false);
                    } else {
                        ZoomManager.this.f12344I.setFromClickView(true);
                    }
                    ZoomManager.this.m11433b(COUIBaseListPopupWindow_12, COUIBaseListPopupWindow_12);
                }

                @Override // com.oplus.camera.p172ui.ZoomClickChangeView.PlatformImplementations.kt_3
                /* renamed from: PlatformImplementations.kt_3 */
                public void mo11561a(float COUIBaseListPopupWindow_12, boolean z) {
                    if (Float.compare(ZoomManager.f12334a, COUIBaseListPopupWindow_12) == 0) {
                        CameraTipsManager.m14374a().m14382g();
                    }
                    ZoomManager.this.f12385k = COUIBaseListPopupWindow_12;
                    if (ZoomManager.this.f12351P.m11343g()) {
                        if (!ZoomManager.this.f12336A.mo10990s() || Float.compare(COUIBaseListPopupWindow_12, ZoomManager.f12334a) <= 0) {
                            if (!ZoomManager.this.f12336A.mo10990s() && Float.compare(COUIBaseListPopupWindow_12, ZoomManager.f12334a) <= 0) {
                                ZoomManager.this.m11434b(ZoomManager.f12334a, z);
                            }
                        } else {
                            ZoomManager.this.m11434b(COUIBaseListPopupWindow_12, z);
                        }
                    }
                    if (ZoomManager.this.f12351P.m11345h() && ((ZoomManager.this.f12336A.mo10991t() && Float.compare(COUIBaseListPopupWindow_12, 2.0f) < 0) || (!ZoomManager.this.f12336A.mo10991t() && Float.compare(COUIBaseListPopupWindow_12, 2.0f) >= 0 && !ZoomManager.this.f12336A.mo10993v()))) {
                        ZoomManager.this.m11434b(COUIBaseListPopupWindow_12, z);
                    }
                    if (ZoomManager.this.f12336A == null || !ZoomManager.this.f12336A.mo10986o()) {
                        return;
                    }
                    ZoomManager.this.f12336A.mo10988q();
                }

                @Override // com.oplus.camera.p172ui.ZoomClickChangeView.PlatformImplementations.kt_3
                /* renamed from: PlatformImplementations.kt_3 */
                public boolean mo11562a() {
                    return ZoomManager.this.f12350O.mo10462R() || ZoomManager.this.f12350O.mo10463S();
                }

                @Override // com.oplus.camera.p172ui.ZoomClickChangeView.PlatformImplementations.kt_3
                /* renamed from: IntrinsicsJvm.kt_4 */
                public void mo11563b() {
                    ZoomManager.this.m11457h(7);
                }

                @Override // com.oplus.camera.p172ui.ZoomClickChangeView.PlatformImplementations.kt_3
                /* renamed from: IntrinsicsJvm.kt_4 */
                public void mo11564b(float COUIBaseListPopupWindow_12) {
                    ZoomManager.this.f12336A.mo10967b(COUIBaseListPopupWindow_12);
                }

                @Override // com.oplus.camera.p172ui.ZoomClickChangeView.PlatformImplementations.kt_3
                /* renamed from: IntrinsicsJvm.kt_3 */
                public boolean mo11565c() {
                    return ZoomManager.this.f12337B.m23127A();
                }
            });
            CameraLog.m12954a("ZoomManager", "initFocusChooseView X");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: IntrinsicsJvm.kt_3 */
    public float m11437c(float COUIBaseListPopupWindow_12) {
        float f2 = this.f12380f;
        float f3 = f12335b;
        float fM24201a = Util.m24201a(f2 + (((((f2 - f3) / (20.0f - f3)) * 0.47950003f) + 0.0152f) * (COUIBaseListPopupWindow_12 / 5.0f)), this.f12382h, this.f12383i);
        if (Float.compare(fM24201a, this.f12382h) == 0 && this.f12340E.m23973g() && Float.compare(this.f12380f, this.f12382h) > 0) {
            m11391G();
        }
        if (Float.compare(fM24201a, this.f12383i) == 0 && this.f12340E.m23972f() && Float.compare(this.f12380f, this.f12383i) < 0) {
            m11390F();
        }
        return fM24201a;
    }

    /* renamed from: F */
    private void m11390F() {
        CameraInterface interfaceC2646a;
        CameraLog.m12962c("ZoomManager", "onMaxZoomValueResponsed");
        if (this.f12336A != null && ((interfaceC2646a = this.f12350O) == null || !interfaceC2646a.mo10539ao() || (!CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_DISABLE_SHUTTER_BUTTON_UP_VIBRATE) && !CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_DISABLE_SHUTTER_BUTTON_DOWN_VIBRATE)))) {
            this.f12336A.mo10987p();
        }
        this.f12340E.m23967d();
    }

    /* renamed from: G */
    private void m11391G() {
        CameraInterface interfaceC2646a;
        CameraLog.m12962c("ZoomManager", "onMinZoomValueResponsed");
        if (this.f12336A != null && ((interfaceC2646a = this.f12350O) == null || !interfaceC2646a.mo10539ao() || (!CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_DISABLE_SHUTTER_BUTTON_UP_VIBRATE) && !CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_DISABLE_SHUTTER_BUTTON_DOWN_VIBRATE)))) {
            this.f12336A.mo10987p();
        }
        this.f12340E.m23967d();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private boolean m11425a(View view, int OplusGLSurfaceView_13, int i2) {
        if (view == null) {
            return false;
        }
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int i3 = iArr[0];
        int i4 = iArr[1];
        return i2 >= i4 && i2 <= view.getMeasuredHeight() + i4 && OplusGLSurfaceView_13 >= i3 && OplusGLSurfaceView_13 <= view.getMeasuredWidth() + i3;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m11496a(PlatformImplementations.kt_3 aVar) {
        this.f12336A = aVar;
        this.f12337B.setZoomListener(new IntrinsicsJvm.kt_3());
        if (this.f12346K == null) {
            this.f12346K = new ScaleGestureDetector(this.f12347L, new IntrinsicsJvm.kt_4());
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public float m11486a() {
        return this.f12380f;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public float m11501b() {
        return this.f12381g;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m11497a(boolean z) {
        if (z) {
            if (m11541u()) {
                this.f12337B.setEnabled(true);
                this.f12344I.setEnabled(true);
                return;
            }
            return;
        }
        this.f12337B.setEnabled(false);
        this.f12344I.setEnabled(false);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m11490a(float COUIBaseListPopupWindow_12, boolean z) {
        if (this.f12399y) {
            this.f12337B.m23145b(COUIBaseListPopupWindow_12, z);
            if (m11393H()) {
                this.f12340E.setThumbText(this.f12337B.m23158j(COUIBaseListPopupWindow_12));
            }
            RotableTextView rotableTextView = this.f12343H;
            if (rotableTextView != null) {
                rotableTextView.setText(this.f12337B.m23158j(COUIBaseListPopupWindow_12));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: H */
    public boolean m11393H() {
        InertiaZoomBar inertiaZoomBar = this.f12340E;
        return inertiaZoomBar != null && inertiaZoomBar.getVisibility() == 0;
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    private void m11455g(int OplusGLSurfaceView_13) throws Resources.NotFoundException {
        if (-1 == OplusGLSurfaceView_13 && this.f12347L != null) {
            OplusGLSurfaceView_13 = this.f12391q;
        }
        if (this.f12345J != null) {
            int dimensionPixelSize = this.f12348M.getDimensionPixelSize(R.dimen.zoom_arc_seekbar_display_value_padding_bottom);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f12345J.getLayoutParams();
            if (OplusGLSurfaceView_13 % 180 == 0) {
                this.f12345J.setBottomMargin(dimensionPixelSize);
                return;
            }
            this.f12345J.setBottomMargin(0);
            layoutParams.bottomMargin = this.f12348M.getDimensionPixelSize(R.dimen.zoom_arc_seekbar_land_display_text_bottom_margin);
            this.f12345J.setLayoutParams(layoutParams);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m11493a(int OplusGLSurfaceView_13, boolean z) {
        int i2;
        int i3;
        int i4;
        int i5;
        CameraLog.m12954a("ZoomManager", "setOrientation, orientation: " + OplusGLSurfaceView_13 + ", anim: " + z);
        this.f12337B.m23150c(OplusGLSurfaceView_13, z);
        m11455g(OplusGLSurfaceView_13);
        if (this.f12345J != null && this.f12337B.m23127A()) {
            this.f12345J.m18344a(OplusGLSurfaceView_13, true);
        }
        ZoomClickChangeView c3525x = this.f12344I;
        if (c3525x != null) {
            c3525x.m24162a(OplusGLSurfaceView_13, true);
        }
        RotableTextView rotableTextView = this.f12343H;
        if (rotableTextView != null && 1 != (i5 = this.f12392r) && 4 != i5) {
            rotableTextView.m18344a(OplusGLSurfaceView_13, z);
        }
        InertialZoomButton inertialZoomButton = this.f12341F;
        if (inertialZoomButton != null && inertialZoomButton.getVisibility() == 0 && 1 != (i4 = this.f12392r) && 4 != i4) {
            this.f12341F.m18348a(OplusGLSurfaceView_13, z);
        }
        InertialZoomButton inertialZoomButton2 = this.f12342G;
        if (inertialZoomButton2 != null && inertialZoomButton2.getVisibility() == 0 && 1 != (i3 = this.f12392r) && 4 != i3) {
            this.f12342G.m18348a(OplusGLSurfaceView_13, z);
        }
        InertiaZoomBar inertiaZoomBar = this.f12340E;
        if (inertiaZoomBar != null && inertiaZoomBar.getVisibility() == 0 && 1 != (i2 = this.f12392r) && 4 != i2) {
            this.f12340E.m23961a(OplusGLSurfaceView_13, z);
        }
        this.f12391q = OplusGLSurfaceView_13;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m11488a(float COUIBaseListPopupWindow_12) {
        this.f12384j = COUIBaseListPopupWindow_12;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m11498a(boolean z, boolean z2) {
        if (!m11541u()) {
            CameraLog.m12954a("ZoomManager", "performShow, isSupportZoomMenu is false, so return");
        } else {
            this.f12337B.m18515a(!this.f12336A.mo10992u(), z, z2);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m11494a(AnimatorListenerAdapter animatorListenerAdapter, boolean z, boolean z2) {
        this.f12337B.mo18511a(animatorListenerAdapter, z, z2);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m11503b(int OplusGLSurfaceView_13) {
        if (OplusGLSurfaceView_13 != 0) {
            this.f12344I.setVisibility(OplusGLSurfaceView_13);
            this.f12337B.mo18511a((AnimatorListenerAdapter) null, true, false);
        } else {
            this.f12337B.m18515a(false, true, false);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m11508c() {
        this.f12337B.m18537l();
        RotableTextView rotableTextView = this.f12345J;
        if (rotableTextView != null) {
            rotableTextView.clearAnimation();
            this.f12345J.setVisibility(4);
        }
        ZoomClickChangeView c3525x = this.f12344I;
        if (c3525x != null) {
            c3525x.clearAnimation();
            this.f12344I.setVisibility(4);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public void m11512d() {
        this.f12337B.m18538m();
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public void m11515e() {
        ZoomSeekBar abstractC3438ai = this.f12337B;
        if (abstractC3438ai != null) {
            abstractC3438ai.mo18542q();
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m11509c(int OplusGLSurfaceView_13) {
        this.f12337B.setLayoutDirection(OplusGLSurfaceView_13);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public boolean m11507b(boolean z) {
        if (!m11541u()) {
            CameraLog.m12954a("ZoomManager", "performCollapse, isSupportZoomMenu is false, so return");
            return false;
        }
        if (this.f12399y && this.f12351P.m11343g() && (this.f12336A.mo10990s() || Float.compare(this.f12380f, 1.0f) < 0)) {
            m11433b(1.0f, 1.0f);
        }
        return this.f12337B.mo18518b(z);
    }

    /* renamed from: I */
    private void m11395I() {
        this.f12339D = (LinearLayout) this.f12347L.getLayoutInflater().inflate(m11429ac(), (ViewGroup) null);
        this.f12339D.setVisibility(8);
        this.f12340E = (InertiaZoomBar) this.f12339D.findViewById(R.id_renamed.inertial_zoom_bar);
        this.f12341F = (InertialZoomButton) this.f12339D.findViewById(R.id_renamed.inertial_zoom_minus_button);
        this.f12342G = (InertialZoomButton) this.f12339D.findViewById(R.id_renamed.inertial_zoom_plus_button);
        this.f12343H = (RotableTextView) this.f12339D.findViewById(R.id_renamed.inertial_zoom_value_text);
        this.f12343H.setShadowLayer(Util.m24202a(MyApplication.m11092d(), R.dimen.level_panel_text_shadow_radius, Util.f22962a), 0.0f, 0.0f, this.f12348M.getColor(R.color.inertia_zoom_text_shadow_color, null));
        if (Util.m24495t()) {
            this.f12343H.setAlpha(0.8f);
            this.f12343H.setTextColor(-1);
        }
        this.f12340E.setOnSeekBarListener(new InertiaZoomBar.InterfaceC3495a() { // from class: com.oplus.camera.ag.17
            @Override // com.oplus.camera.p172ui.widget.InertiaZoomBar.InterfaceC3495a
            /* renamed from: PlatformImplementations.kt_3 */
            public void mo11567a(float COUIBaseListPopupWindow_12) {
                float fM11442d = ZoomManager.this.m11442d(COUIBaseListPopupWindow_12);
                if (Float.compare(ZoomManager.this.f12384j, fM11442d) == 0) {
                    return;
                }
                ZoomManager.this.m11488a(fM11442d);
            }

            @Override // com.oplus.camera.p172ui.widget.InertiaZoomBar.InterfaceC3495a
            /* renamed from: PlatformImplementations.kt_3 */
            public void mo11566a() {
                if (Float.compare(ZoomManager.this.f12380f, ZoomManager.this.f12382h) == 0) {
                    if (ZoomManager.this.f12336A != null && (ZoomManager.this.f12350O == null || !ZoomManager.this.f12350O.mo10539ao() || (!CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_DISABLE_SHUTTER_BUTTON_UP_VIBRATE) && !CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_DISABLE_SHUTTER_BUTTON_DOWN_VIBRATE)))) {
                        ZoomManager.this.f12336A.mo10987p();
                    }
                    ZoomManager.this.f12340E.m23967d();
                }
            }

            @Override // com.oplus.camera.p172ui.widget.InertiaZoomBar.InterfaceC3495a
            /* renamed from: IntrinsicsJvm.kt_4 */
            public void mo11568b() {
                if (Float.compare(ZoomManager.this.f12380f, ZoomManager.this.f12383i) == 0) {
                    if (ZoomManager.this.f12336A != null && ZoomManager.this.f12336A != null && (ZoomManager.this.f12350O == null || !ZoomManager.this.f12350O.mo10539ao() || (!CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_DISABLE_SHUTTER_BUTTON_UP_VIBRATE) && !CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_DISABLE_SHUTTER_BUTTON_DOWN_VIBRATE)))) {
                        ZoomManager.this.f12336A.mo10987p();
                    }
                    ZoomManager.this.f12340E.m23967d();
                }
            }

            @Override // com.oplus.camera.p172ui.widget.InertiaZoomBar.InterfaceC3495a
            /* renamed from: IntrinsicsJvm.kt_3 */
            public void mo11569c() {
                ZoomManager.this.f12340E.m23969e();
            }

            @Override // com.oplus.camera.p172ui.widget.InertiaZoomBar.InterfaceC3495a
            /* renamed from: IntrinsicsJvm.kt_5 */
            public void mo11570d() {
                ZoomManager.this.f12340E.m23969e();
            }

            @Override // com.oplus.camera.p172ui.widget.InertiaZoomBar.InterfaceC3495a
            /* renamed from: COUIBaseListPopupWindow_8 */
            public void mo11571e() {
                if (!ZoomManager.this.m11398J()) {
                    ZoomManager.this.m11466m(true);
                }
                ZoomManager.this.m11470o(true);
            }

            @Override // com.oplus.camera.p172ui.widget.InertiaZoomBar.InterfaceC3495a
            /* renamed from: COUIBaseListPopupWindow_12 */
            public void mo11572f() {
                ZoomManager.this.m11468n(true);
                ZoomManager.this.f12340E.setThumbText(ZoomManager.this.f12337B.getCurrentDisplayText());
                ZoomManager.this.f12340E.m23962a(true);
                ZoomManager.this.f12340E.m23965c();
                if (!ZoomManager.this.f12398x) {
                    ZoomManager.this.m11457h(10);
                }
                ZoomManager.this.m11401L();
            }
        });
        this.f12340E.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.oplus.camera.ag.18
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                ZoomManager.this.f12340E.m23966c(true);
                ZoomManager.this.f12340E.m23970e(true);
                ZoomManager.this.f12340E.m23963b(true);
                ZoomManager.this.f12340E.setIsHighlight(true);
                ZoomManager.this.f12343H.setText(ZoomManager.this.m11412W());
                if (ZoomManager.this.m11398J()) {
                    return false;
                }
                ZoomManager.this.m11466m(true);
                return false;
            }
        });
        this.f12341F.setOnInertialZoomButtonListener(new InertialZoomButton.InterfaceC3496a() { // from class: com.oplus.camera.ag.19
            @Override // com.oplus.camera.p172ui.widget.InertialZoomButton.InterfaceC3496a
            /* renamed from: PlatformImplementations.kt_3 */
            public void mo11573a() {
                if (ZoomManager.this.f12359X == null) {
                    ZoomManager.this.m11400K();
                }
                if (ZoomManager.this.f12359X.isRunning()) {
                    ZoomManager.this.f12359X.cancel();
                }
                float fM24201a = Util.m24201a(new BigDecimal(String.valueOf(ZoomManager.this.f12380f)).add(new BigDecimal(String.valueOf(-0.1f))).floatValue(), ZoomManager.this.f12382h, ZoomManager.this.f12383i);
                ZoomManager.this.f12359X.setFloatValues(ZoomManager.this.f12380f, fM24201a);
                ZoomManager.this.f12359X.start();
                ZoomManager.this.m11490a(fM24201a, false);
            }

            @Override // com.oplus.camera.p172ui.widget.InertialZoomButton.InterfaceC3496a
            /* renamed from: IntrinsicsJvm.kt_4 */
            public void mo11574b() {
                if (ZoomManager.this.f12361Z != null) {
                    ZoomManager.this.f12361Z.removeMessages(2);
                    ZoomManager.this.f12361Z.removeMessages(3);
                    ZoomManager.this.f12361Z.sendEmptyMessage(2);
                }
                ZoomManager.this.m11470o(false);
            }

            @Override // com.oplus.camera.p172ui.widget.InertialZoomButton.InterfaceC3496a
            /* renamed from: IntrinsicsJvm.kt_3 */
            public void mo11575c() {
                ZoomManager.this.m11401L();
                ZoomManager.this.m11457h(11);
            }
        });
        this.f12342G.setOnInertialZoomButtonListener(new InertialZoomButton.InterfaceC3496a() { // from class: com.oplus.camera.ag.20
            @Override // com.oplus.camera.p172ui.widget.InertialZoomButton.InterfaceC3496a
            /* renamed from: PlatformImplementations.kt_3 */
            public void mo11573a() {
                if (ZoomManager.this.f12359X == null) {
                    ZoomManager.this.m11400K();
                }
                if (ZoomManager.this.f12359X.isRunning()) {
                    ZoomManager.this.f12359X.cancel();
                }
                float fM24201a = Util.m24201a(new BigDecimal(String.valueOf(ZoomManager.this.f12380f)).add(new BigDecimal(String.valueOf(0.1f))).floatValue(), ZoomManager.this.f12382h, ZoomManager.this.f12383i);
                ZoomManager.this.f12359X.setFloatValues(ZoomManager.this.f12380f, fM24201a);
                ZoomManager.this.f12359X.start();
                ZoomManager.this.m11490a(fM24201a, false);
            }

            @Override // com.oplus.camera.p172ui.widget.InertialZoomButton.InterfaceC3496a
            /* renamed from: IntrinsicsJvm.kt_4 */
            public void mo11574b() {
                if (ZoomManager.this.f12361Z != null) {
                    ZoomManager.this.f12361Z.removeMessages(2);
                    ZoomManager.this.f12361Z.removeMessages(3);
                    ZoomManager.this.f12361Z.sendEmptyMessage(3);
                }
                ZoomManager.this.m11470o(false);
            }

            @Override // com.oplus.camera.p172ui.widget.InertialZoomButton.InterfaceC3496a
            /* renamed from: IntrinsicsJvm.kt_3 */
            public void mo11575c() {
                ZoomManager.this.m11401L();
                ZoomManager.this.m11457h(11);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: J */
    public boolean m11398J() {
        RotableTextView rotableTextView = this.f12343H;
        return rotableTextView != null && rotableTextView.getVisibility() == 0 && Float.compare(this.f12343H.getAlpha(), 1.0f) == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: OplusGLSurfaceView_6 */
    public void m11466m(boolean z) {
        RotableTextView rotableTextView = this.f12343H;
        if (rotableTextView == null) {
            return;
        }
        rotableTextView.setText(m11412W());
        this.f12343H.setVisibility(0);
        if (z) {
            Animation animation = this.f12343H.getAnimation();
            if (animation == null || animation.hasEnded()) {
                ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.f12343H, "alpha", 0.0f, 1.0f);
                objectAnimatorOfFloat.setInterpolator(this.f12375an);
                objectAnimatorOfFloat.setDuration(183L);
                objectAnimatorOfFloat.addListener(new Animator.AnimatorListener() { // from class: com.oplus.camera.ag.21
                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationRepeat(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        ZoomManager.this.f12343H.setVisibility(0);
                    }
                });
                objectAnimatorOfFloat.start();
                return;
            }
            return;
        }
        this.f12343H.setAlpha(1.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: OplusGLSurfaceView_11 */
    public void m11468n(boolean z) {
        RotableTextView rotableTextView = this.f12343H;
        if (rotableTextView == null) {
            return;
        }
        if (z) {
            Animation animation = rotableTextView.getAnimation();
            if (animation == null || animation.hasEnded()) {
                ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.f12343H, "alpha", 1.0f, 0.0f);
                objectAnimatorOfFloat.setInterpolator(this.f12375an);
                objectAnimatorOfFloat.setDuration(183L);
                objectAnimatorOfFloat.addListener(new Animator.AnimatorListener() { // from class: com.oplus.camera.ag.22
                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationRepeat(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        ZoomManager.this.f12343H.setVisibility(8);
                    }
                });
                objectAnimatorOfFloat.start();
                return;
            }
            return;
        }
        rotableTextView.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: K */
    public void m11400K() {
        this.f12359X = new ValueAnimator();
        this.f12359X.setDuration(100L);
        this.f12359X.setInterpolator(AnimationUtils.loadInterpolator(this.f12347L, R.anim.zoom_interpolator_in));
        this.f12359X.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.-$$Lambda$ag$VfCu1CbVzuM9fM0MPTBNn2CQhtE
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                this.COUIBaseListPopupWindow_12$0.m11419a(valueAnimator);
            }
        });
        this.f12359X.addListener(new SimpleAnimatorListener() { // from class: com.oplus.camera.ag.2
            @Override // com.oplus.camera.p137b.SimpleAnimatorListener, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                ZoomManager.this.m11457h(12);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public /* synthetic */ void m11419a(ValueAnimator valueAnimator) {
        float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        float COUIBaseListPopupWindow_12 = f12334a;
        if (COUIBaseListPopupWindow_12 > fFloatValue) {
            fFloatValue = COUIBaseListPopupWindow_12;
        }
        m11418a(fFloatValue, fFloatValue, false, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: o */
    public void m11470o(boolean z) {
        if (this.f12336A != null) {
            CameraInterface interfaceC2646a = this.f12350O;
            if (interfaceC2646a == null || !interfaceC2646a.mo10539ao() || (!CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_DISABLE_SHUTTER_BUTTON_UP_VIBRATE) && !CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_DISABLE_SHUTTER_BUTTON_DOWN_VIBRATE))) {
                this.f12336A.mo10987p();
            }
            this.f12336A.mo10980i();
            this.f12336A.mo10963a(true);
        }
        this.f12340E.m23962a(z);
        Handler handler = this.f12361Z;
        if (handler != null) {
            this.f12398x = true;
            handler.removeMessages(1);
            this.f12361Z.sendEmptyMessageDelayed(1, 25L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: L */
    public void m11401L() {
        Handler handler = this.f12361Z;
        if (handler != null) {
            this.f12398x = false;
            handler.removeCallbacksAndMessages(null);
            Message messageObtain = Message.obtain();
            messageObtain.what = 1;
            messageObtain.arg1 = 1;
            this.f12361Z.sendMessageDelayed(messageObtain, 25L);
        }
        PlatformImplementations.kt_3 aVar = this.f12336A;
        if (aVar != null) {
            aVar.mo10981j();
            this.f12336A.mo10963a(false);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m11495a(ViewGroup viewGroup) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, this.f12348M.getDimensionPixelSize(R.dimen.zoom_arc_seekbar_display_value_height));
        layoutParams.addRule(2, this.f12337B.getId());
        layoutParams.addRule(14);
        layoutParams.bottomMargin = this.f12348M.getDimensionPixelSize(R.dimen.zoom_arc_seekbar_display_value_padding_bottom);
        this.f12345J = new RotableTextView(this.f12347L);
        this.f12345J.setId(R.id_renamed.zoom_seek_bar_display_text);
        this.f12345J.setTextColor(-1);
        this.f12345J.setTypeface(Util.m24505y());
        this.f12345J.setShadowLayer(Util.m24202a(MyApplication.m11092d(), R.dimen.level_panel_text_shadow_radius, Util.f22962a), 0.0f, 0.0f, this.f12348M.getColor(R.color.inertia_zoom_text_shadow_color));
        this.f12345J.setTextSize(0, this.f12348M.getDimensionPixelSize(R.dimen.zoom_arc_seekbar_display_text_size));
        this.f12345J.setVisibility(8);
        this.f12345J.setAlpha(0.8f);
        this.f12345J.m18344a(this.f12391q, false);
        this.f12345J.setGravity(17);
        this.f12338C.addView(this.f12345J, layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: COUIBaseListPopupWindow_8 */
    public void m11448e(float COUIBaseListPopupWindow_12) {
        ZoomConfigure c2614af = this.f12351P;
        if (c2614af != null && c2614af.m11343g() && (Float.compare(this.f12337B.getCurrentZoom(), 1.0f) < 0 || Float.compare(COUIBaseListPopupWindow_12, 1.0f) < 0)) {
            this.f12345J.setText(this.f12337B.m23159k(f12334a));
        } else {
            this.f12345J.setText(this.f12337B.m23159k(COUIBaseListPopupWindow_12));
        }
        if (this.f12394t || !this.f12337B.m23127A()) {
            return;
        }
        m11402M();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: COUIBaseListPopupWindow_12 */
    public void m11452f(float COUIBaseListPopupWindow_12) {
        ZoomConfigure c2614af = this.f12351P;
        if (c2614af != null && c2614af.m11343g() && (Float.compare(this.f12337B.getCurrentZoom(), 1.0f) < 0 || Float.compare(COUIBaseListPopupWindow_12, 1.0f) < 0)) {
            this.f12345J.setText(this.f12337B.m23159k(f12334a));
        } else {
            this.f12345J.setText(this.f12337B.m23159k(COUIBaseListPopupWindow_12));
        }
    }

    /* renamed from: M */
    private void m11402M() {
        PlatformImplementations.kt_3 aVar = this.f12336A;
        if (aVar == null || !aVar.mo10956A()) {
            this.f12394t = true;
            this.f12345J.clearAnimation();
            AnimationSet animationSet = new AnimationSet(false);
            TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, this.f12387m, 0.0f);
            translateAnimation.setDuration(500L);
            translateAnimation.setInterpolator(AnimationUtils.loadInterpolator(this.f12347L, R.anim.zoom_interpolator_in));
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 0.8f);
            alphaAnimation.setDuration(500L);
            alphaAnimation.setInterpolator(AnimationUtils.loadInterpolator(this.f12347L, R.anim.zoom_interpolator_point_alpha));
            animationSet.addAnimation(translateAnimation);
            animationSet.addAnimation(alphaAnimation);
            animationSet.setFillAfter(true);
            animationSet.setAnimationListener(new Animation.AnimationListener() { // from class: com.oplus.camera.ag.3
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                    if (ZoomManager.this.f12345J != null) {
                        ZoomManager.this.f12345J.m18344a(ZoomManager.this.f12391q, false);
                        ZoomManager.this.f12345J.setVisibility(0);
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    if (ZoomManager.this.f12345J == null || !ZoomManager.this.f12394t) {
                        return;
                    }
                    ZoomManager.this.f12345J.clearAnimation();
                }
            });
            this.f12345J.startAnimation(animationSet);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: N */
    public void m11403N() {
        this.f12394t = false;
        this.f12345J.clearAnimation();
        AnimationSet animationSet = new AnimationSet(false);
        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, 0.0f, this.f12389o);
        translateAnimation.setDuration(500L);
        translateAnimation.setInterpolator(AnimationUtils.loadInterpolator(this.f12347L, R.anim.zoom_interpolator_out));
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.8f, 0.0f);
        alphaAnimation.setDuration(250L);
        alphaAnimation.setInterpolator(AnimationUtils.loadInterpolator(this.f12347L, R.anim.zoom_interpolator_point_alpha));
        animationSet.addAnimation(translateAnimation);
        animationSet.addAnimation(alphaAnimation);
        animationSet.setFillAfter(true);
        animationSet.setAnimationListener(new Animation.AnimationListener() { // from class: com.oplus.camera.ag.4
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (ZoomManager.this.f12345J == null || !ZoomManager.this.f12394t) {
                    return;
                }
                ZoomManager.this.f12345J.clearAnimation();
                ZoomManager.this.f12345J.setVisibility(4);
            }
        });
        this.f12345J.startAnimation(animationSet);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m11505b(final ViewGroup viewGroup) {
        RelativeLayout.LayoutParams layoutParams;
        RelativeLayout.LayoutParams layoutParams2;
        if (viewGroup == null) {
            return;
        }
        final View viewFindViewById = this.f12347L.findViewById(R.id_renamed.face_beauty_enter_button);
        this.f12338C = new RelativeLayout(this.f12347L);
        this.f12338C.setId(R.id_renamed.zoom_seek_bar_container);
        this.f12338C.setClipChildren(false);
        if (Util.m24495t() && 1 == this.f12392r) {
            int dimensionPixelSize = this.f12348M.getDimensionPixelSize(R.dimen.zoom_arc_seekbar_bg_circle_radius);
            int dimensionPixelSize2 = this.f12348M.getDimensionPixelSize(R.dimen.zoom_seekbar_switch_bar_radius);
            int dimensionPixelSize3 = this.f12348M.getDimensionPixelSize(R.dimen.zoom_focus_circle_margin_bottom);
            int dimensionPixelSize4 = this.f12348M.getDimensionPixelSize(R.dimen.zoom_focus_circle_width);
            this.f12348M.getDimensionPixelSize(R.dimen.zoom_mark_button_size);
            int OplusGLSurfaceView_13 = this.f12393s;
            if (OplusGLSurfaceView_13 == 90) {
                int dimensionPixelSize5 = this.f12348M.getDimensionPixelSize(R.dimen.zoom_arc_seekbar_full_margin_bottom_full_screen_90);
                layoutParams = new RelativeLayout.LayoutParams(dimensionPixelSize * 2, dimensionPixelSize);
                layoutParams.addRule(9);
                layoutParams.addRule(12);
                layoutParams.setMargins((-dimensionPixelSize) / 2, 0, 0, dimensionPixelSize5 + (dimensionPixelSize / 2));
                this.f12338C.setRotation(90.0f);
            } else if (OplusGLSurfaceView_13 == 270) {
                int dimensionPixelSize6 = this.f12348M.getDimensionPixelSize(R.dimen.zoom_arc_seekbar_full_margin_bottom_full_screen_90);
                layoutParams = new RelativeLayout.LayoutParams(dimensionPixelSize * 2, dimensionPixelSize);
                layoutParams.addRule(9);
                layoutParams.addRule(12);
                layoutParams.setMargins(0, 0, (-dimensionPixelSize) / 2, dimensionPixelSize6 + (dimensionPixelSize / 2));
                this.f12338C.setRotation(270.0f);
            } else {
                int dimensionPixelSize7 = this.f12348M.getDimensionPixelSize(R.dimen.zoom_arc_seekbar_full_margin_bottom);
                int dimensionPixelSize8 = this.f12348M.getDimensionPixelSize(R.dimen.zoom_focus_circle_margin_bottom);
                dimensionPixelSize4 = this.f12348M.getDimensionPixelSize(R.dimen.zoom_focus_circle_width);
                layoutParams = new RelativeLayout.LayoutParams(dimensionPixelSize * 2, dimensionPixelSize);
                layoutParams.addRule(9);
                layoutParams.addRule(12);
                layoutParams.setMargins((-dimensionPixelSize) / 2, 0, 0, dimensionPixelSize7 + (dimensionPixelSize / 2) + Util.m24198Z());
                this.f12338C.setRotation(90.0f);
                dimensionPixelSize3 = dimensionPixelSize8;
            }
            layoutParams2 = new RelativeLayout.LayoutParams(-1, dimensionPixelSize);
            ((ZoomArcSeekBar) this.f12337B).m23077a(dimensionPixelSize * 2, dimensionPixelSize, dimensionPixelSize2, (dimensionPixelSize - (dimensionPixelSize4 / 2)) - dimensionPixelSize3, 0.0f, 2.0f, 0.0f);
        } else {
            int dimensionPixelSize9 = this.f12348M.getDimensionPixelSize(R.dimen.zoom_arc_seekbar_bg_circle_radius);
            int dimensionPixelSize10 = this.f12348M.getDimensionPixelSize(R.dimen.zoom_seekbar_switch_bar_radius);
            int dimensionPixelSize11 = this.f12348M.getDimensionPixelSize(R.dimen.zoom_arc_seekbar_focus_circle_center_y);
            int dimensionPixelSize12 = this.f12348M.getDimensionPixelSize(R.dimen.control_panel_margin_top);
            layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(2, R.id_renamed.control_panel_layout);
            layoutParams.bottomMargin = (-this.f12348M.getDimensionPixelSize(R.dimen.zoom_mark_button_size)) - this.f12348M.getDimensionPixelSize(R.dimen.zoom_click_margin_top);
            layoutParams2 = new RelativeLayout.LayoutParams(-1, this.f12337B.getLayoutHeight());
            ((ZoomArcSeekBar) this.f12337B).m23077a(this.f12350O.mo10519aU().m16505b(), dimensionPixelSize9, dimensionPixelSize10, dimensionPixelSize11, (Util.m24188P() + dimensionPixelSize12) / 2.0f, 1.0f, 0.0f);
        }
        this.f12338C.addView(this.f12337B, 0, layoutParams2);
        this.f12337B.setVisibility(4);
        View view = new View(this.f12347L);
        view.setId(R.id_renamed.zoom_seek_anchor_view);
        view.setWillNotDraw(true);
        view.setVisibility(4);
        this.f12338C.addView(view, 1);
        viewGroup.addView(this.f12338C, viewGroup.indexOfChild(viewFindViewById), layoutParams);
        m11495a(viewGroup);
        m11439c(viewGroup);
        if (viewFindViewById.isShown()) {
            final int dimensionPixelSize13 = this.f12348M.getDimensionPixelSize(R.dimen.face_beauty_enter_button_extra_touch_offset);
            viewGroup.post(new Runnable() { // from class: com.oplus.camera.ag.5
                @Override // java.lang.Runnable
                public void run() {
                    Rect rect = new Rect();
                    viewFindViewById.getHitRect(rect);
                    if (dimensionPixelSize13 > 0) {
                        rect.top -= dimensionPixelSize13;
                        rect.bottom += dimensionPixelSize13;
                        rect.left -= dimensionPixelSize13;
                        rect.right += dimensionPixelSize13;
                        viewGroup.setTouchDelegate(new TouchDelegate(rect, viewFindViewById));
                    }
                }
            });
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m11510c(boolean z) {
        RelativeLayout relativeLayout = this.f12338C;
        if (relativeLayout != null) {
            if (z) {
                Util.m24270a(relativeLayout, 4, (Animation.AnimationListener) null, 300L);
            } else {
                relativeLayout.setVisibility(4);
            }
        }
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public void m11514d(boolean z) {
        RelativeLayout relativeLayout = this.f12338C;
        if (relativeLayout != null) {
            if (z) {
                Util.m24270a(relativeLayout, 0, (Animation.AnimationListener) null, 300L);
            } else {
                relativeLayout.setVisibility(0);
            }
        }
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    public View m11518f() {
        return this.f12338C;
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    public void m11521g() {
        CameraLog.m12954a("ZoomManager", "showZoomSeekBarAfterInertialZoom");
        if (m11413X()) {
            this.f12355T.cancel();
        }
        if (this.f12356U == null) {
            m11404O();
        }
        Handler handler = this.f12361Z;
        if (handler != null) {
            handler.postDelayed(new Runnable() { // from class: com.oplus.camera.ag.6
                @Override // java.lang.Runnable
                public void run() {
                    if (ZoomManager.this.f12337B != null) {
                        if (!Util.m24495t()) {
                            ZoomManager.this.f12337B.setAlpha(0.0f);
                        }
                        ZoomManager.this.f12337B.setVisibility(0);
                    }
                }
            }, 150L);
        }
        this.f12356U.start();
    }

    /* renamed from: COUIBaseListPopupWindow_10 */
    public void m11523h() {
        CameraLog.m12954a("ZoomManager", "hideZoomSeekBarBeforeInertialZoom");
        if (m11533m()) {
            m11494a((AnimatorListenerAdapter) null, true, false);
            return;
        }
        AnimatorSet animatorSet = this.f12356U;
        if (animatorSet != null && animatorSet.isStarted() && this.f12356U.isRunning()) {
            this.f12356U.cancel();
        }
        if (this.f12355T == null) {
            m11405P();
        }
        this.f12355T.start();
    }

    /* renamed from: OplusGLSurfaceView_13 */
    public void m11525i() {
        LinearLayout linearLayout = this.f12339D;
        if (linearLayout != null) {
            this.f12360Y.removeView(linearLayout);
            this.f12339D = null;
        }
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public void m11517e(boolean z) {
        CameraLog.m12954a("ZoomManager", "showInertialZoomView, animation: " + z);
        AnimatorSet animatorSet = this.f12357V;
        if (animatorSet != null && animatorSet.isRunning()) {
            this.f12357V.cancel();
        }
        if (this.f12360Y == null) {
            return;
        }
        if (this.f12339D == null) {
            m11395I();
        }
        m11516e(this.f12392r);
        InertiaZoomBar inertiaZoomBar = this.f12340E;
        if (inertiaZoomBar != null) {
            inertiaZoomBar.m23960a();
            if (this.f12337B.m23129C()) {
                this.f12340E.setThumbText(this.f12337B.getSlideToDisplayText());
            } else {
                this.f12340E.setThumbText(this.f12337B.getCurrentDisplayText());
            }
        }
        int OplusGLSurfaceView_13 = this.f12392r;
        if (1 == OplusGLSurfaceView_13 || 4 == OplusGLSurfaceView_13) {
            m11431ae();
        } else {
            m11430ad();
        }
        if (z) {
            if (this.f12358W == null) {
                int i2 = this.f12392r;
                if (1 == i2 || 4 == i2) {
                    m11407R();
                } else {
                    m11406Q();
                }
            }
            this.f12339D.setAlpha(0.0f);
            this.f12339D.setVisibility(0);
            this.f12358W.start();
        } else {
            this.f12339D.setVisibility(0);
        }
        this.f12397w = true;
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    public void m11520f(boolean z) {
        LinearLayout linearLayout;
        CameraLog.m12954a("ZoomManager", "hideInertialZoomView, anim: " + z);
        AnimatorSet animatorSet = this.f12358W;
        if (animatorSet != null && animatorSet.isStarted()) {
            this.f12358W.cancel();
        }
        if (this.f12360Y == null || (linearLayout = this.f12339D) == null) {
            return;
        }
        if (z) {
            if (this.f12357V == null) {
                int OplusGLSurfaceView_13 = this.f12392r;
                if (1 == OplusGLSurfaceView_13 || 4 == OplusGLSurfaceView_13) {
                    m11409T();
                } else {
                    m11408S();
                }
            }
            this.f12357V.start();
        } else {
            linearLayout.setVisibility(8);
        }
        this.f12397w = false;
    }

    /* renamed from: O */
    private void m11404O() {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.f12337B, "alpha", 0.0f, 1.0f);
        objectAnimatorOfFloat.setInterpolator(this.f12375an);
        objectAnimatorOfFloat.setDuration(400L);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.f12337B, "translationY", -this.f12388n, 0.0f);
        objectAnimatorOfFloat2.setInterpolator(this.f12376ao);
        objectAnimatorOfFloat2.setDuration(400L);
        this.f12356U = new AnimatorSet();
        this.f12356U.play(objectAnimatorOfFloat2).with(objectAnimatorOfFloat);
        this.f12356U.setStartDelay(150L);
        this.f12356U.addListener(new SimpleAnimatorListener() { // from class: com.oplus.camera.ag.7
            @Override // com.oplus.camera.p137b.SimpleAnimatorListener, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (ZoomManager.this.f12337B != null) {
                    ZoomManager.this.f12337B.setVisibility(0);
                    ZoomManager.this.f12337B.setAlpha(1.0f);
                }
            }

            @Override // com.oplus.camera.p137b.SimpleAnimatorListener, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                if (ZoomManager.this.f12337B != null) {
                    ZoomManager.this.f12337B.setVisibility(0);
                    ZoomManager.this.f12337B.setAlpha(1.0f);
                }
            }
        });
        this.f12356U.setStartDelay(150L);
    }

    /* renamed from: P */
    private void m11405P() {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.f12337B, "alpha", 1.0f, 0.0f);
        objectAnimatorOfFloat.setInterpolator(this.f12375an);
        objectAnimatorOfFloat.setDuration(250L);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.f12337B, "translationY", 0.0f, -this.f12388n);
        objectAnimatorOfFloat2.setInterpolator(this.f12376ao);
        objectAnimatorOfFloat2.setDuration(400L);
        this.f12355T = new AnimatorSet();
        this.f12355T.play(objectAnimatorOfFloat2).with(objectAnimatorOfFloat);
        this.f12355T.addListener(new SimpleAnimatorListener() { // from class: com.oplus.camera.ag.8
            @Override // com.oplus.camera.p137b.SimpleAnimatorListener, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                ZoomManager.this.f12337B.setVisibility(4);
            }

            @Override // com.oplus.camera.p137b.SimpleAnimatorListener, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                ZoomManager.this.f12337B.setVisibility(4);
            }
        });
    }

    /* renamed from: Q */
    private void m11406Q() {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.f12339D, "alpha", 0.0f, 1.0f);
        objectAnimatorOfFloat.setInterpolator(this.f12375an);
        objectAnimatorOfFloat.setDuration(300L);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.f12339D, "translationY", this.f12388n, 0.0f);
        objectAnimatorOfFloat2.setInterpolator(this.f12376ao);
        objectAnimatorOfFloat2.setDuration(300L);
        this.f12358W = new AnimatorSet();
        this.f12358W.play(objectAnimatorOfFloat2).with(objectAnimatorOfFloat);
        this.f12358W.setStartDelay(150L);
        this.f12358W.addListener(new SimpleAnimatorListener() { // from class: com.oplus.camera.ag.9
            @Override // com.oplus.camera.p137b.SimpleAnimatorListener, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                ZoomManager.this.f12339D.setAlpha(0.0f);
            }

            @Override // com.oplus.camera.p137b.SimpleAnimatorListener, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                ZoomManager.this.f12339D.setAlpha(1.0f);
                ZoomManager.this.f12339D.setVisibility(0);
            }

            @Override // com.oplus.camera.p137b.SimpleAnimatorListener, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                ZoomManager.this.f12339D.setVisibility(0);
                ZoomManager.this.f12339D.setAlpha(1.0f);
            }
        });
        this.f12358W.setStartDelay(150L);
    }

    /* renamed from: R */
    private void m11407R() {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.f12339D, "alpha", 0.0f, 1.0f);
        objectAnimatorOfFloat.setInterpolator(this.f12375an);
        objectAnimatorOfFloat.setDuration(300L);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.f12339D, "translationX", -this.f12388n, 0.0f);
        if (270 == this.f12393s && 4 != this.f12392r) {
            objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.f12339D, "translationX", this.f12388n, 0.0f);
        }
        objectAnimatorOfFloat2.setInterpolator(this.f12376ao);
        objectAnimatorOfFloat2.setDuration(300L);
        this.f12358W = new AnimatorSet();
        this.f12358W.play(objectAnimatorOfFloat2).with(objectAnimatorOfFloat);
        this.f12358W.setStartDelay(150L);
        this.f12358W.addListener(new SimpleAnimatorListener() { // from class: com.oplus.camera.ag.10
            @Override // com.oplus.camera.p137b.SimpleAnimatorListener, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                ZoomManager.this.f12339D.setAlpha(0.0f);
            }

            @Override // com.oplus.camera.p137b.SimpleAnimatorListener, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                ZoomManager.this.f12339D.setAlpha(1.0f);
                ZoomManager.this.f12339D.setVisibility(0);
            }

            @Override // com.oplus.camera.p137b.SimpleAnimatorListener, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                ZoomManager.this.f12339D.setVisibility(0);
                ZoomManager.this.f12339D.setAlpha(1.0f);
            }
        });
        this.f12358W.setStartDelay(150L);
    }

    /* renamed from: S */
    private void m11408S() {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.f12339D, "alpha", 1.0f, 0.0f);
        objectAnimatorOfFloat.setInterpolator(this.f12375an);
        objectAnimatorOfFloat.setDuration(250L);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.f12339D, "translationY", 0.0f, this.f12388n);
        objectAnimatorOfFloat2.setInterpolator(this.f12376ao);
        objectAnimatorOfFloat2.setDuration(300L);
        this.f12357V = new AnimatorSet();
        this.f12357V.play(objectAnimatorOfFloat2).with(objectAnimatorOfFloat);
        this.f12357V.addListener(new SimpleAnimatorListener() { // from class: com.oplus.camera.ag.11
            @Override // com.oplus.camera.p137b.SimpleAnimatorListener, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (ZoomManager.this.f12339D != null) {
                    ZoomManager.this.f12339D.setVisibility(4);
                    ZoomManager.this.f12360Y.removeView(ZoomManager.this.f12339D);
                }
            }

            @Override // com.oplus.camera.p137b.SimpleAnimatorListener, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                if (ZoomManager.this.f12339D != null) {
                    ZoomManager.this.f12339D.setVisibility(4);
                    ZoomManager.this.f12360Y.removeView(ZoomManager.this.f12339D);
                }
            }
        });
    }

    /* renamed from: T */
    private void m11409T() {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.f12339D, "alpha", 1.0f, 0.0f);
        objectAnimatorOfFloat.setInterpolator(this.f12375an);
        objectAnimatorOfFloat.setDuration(250L);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.f12339D, "translationX", 0.0f, -this.f12388n);
        if (270 == this.f12393s && 4 != this.f12392r) {
            objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.f12339D, "translationX", 0.0f, this.f12388n);
        }
        objectAnimatorOfFloat2.setInterpolator(this.f12376ao);
        objectAnimatorOfFloat2.setDuration(300L);
        this.f12357V = new AnimatorSet();
        this.f12357V.play(objectAnimatorOfFloat2).with(objectAnimatorOfFloat);
        this.f12357V.addListener(new SimpleAnimatorListener() { // from class: com.oplus.camera.ag.13
            @Override // com.oplus.camera.p137b.SimpleAnimatorListener, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (ZoomManager.this.f12339D != null) {
                    ZoomManager.this.f12339D.setVisibility(4);
                    ZoomManager.this.f12360Y.removeView(ZoomManager.this.f12339D);
                }
            }

            @Override // com.oplus.camera.p137b.SimpleAnimatorListener, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                if (ZoomManager.this.f12339D != null) {
                    ZoomManager.this.f12339D.setVisibility(4);
                    ZoomManager.this.f12360Y.removeView(ZoomManager.this.f12339D);
                }
            }
        });
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public float m11487a(float COUIBaseListPopupWindow_12, float f2) {
        ZoomConfigure c2614af;
        if (this.f12383i < 1.0f) {
            return 0.0f;
        }
        float f3 = COUIBaseListPopupWindow_12 + ((f2 / this.f12386l) * 0.1f);
        float f4 = this.f12382h;
        if (this.f12396v && (c2614af = this.f12351P) != null && c2614af.m11343g() && !this.f12351P.m11361p()) {
            f4 = f12334a;
        }
        return Util.m24201a(f3, f4, this.f12383i);
    }

    /* renamed from: OplusGLSurfaceView_15 */
    public boolean m11528j() {
        if (!m11541u()) {
            CameraLog.m12954a("ZoomManager", "isZoomMenuExpand, isSupportZoomMenu is false, so return");
            return false;
        }
        return this.f12337B.m23127A();
    }

    /* renamed from: OplusGLSurfaceView_5 */
    public boolean m11530k() {
        if (!m11541u()) {
            CameraLog.m12954a("ZoomManager", "isZoomMenuExpand, isSupportZoomMenu is false, so return");
            return false;
        }
        return this.f12337B.m23128B();
    }

    /* renamed from: OplusGLSurfaceView_14 */
    public float m11531l() {
        if (!m11541u()) {
            CameraLog.m12954a("ZoomManager", "getZoomVelocityRate, isSupportZoomMenu is false, so return");
            return 0.0f;
        }
        return this.f12337B.getVelocityRate();
    }

    /* renamed from: OplusGLSurfaceView_6 */
    public boolean m11533m() {
        if (!m11541u()) {
            CameraLog.m12954a("ZoomManager", "isZoomMenuCollapsing, isSupportZoomMenu is false, so return");
            return false;
        }
        return this.f12337B.m23165z();
    }

    /* renamed from: OplusGLSurfaceView_11 */
    public void m11534n() {
        if (this.f12399y) {
            RotableTextView rotableTextView = this.f12345J;
            if (rotableTextView != null) {
                rotableTextView.clearAnimation();
                this.f12345J.setVisibility(8);
            }
            ZoomClickChangeView c3525x = this.f12344I;
            if (c3525x != null) {
                c3525x.setVisibility(8);
            }
            ValueAnimator valueAnimator = this.f12353R;
            if (valueAnimator != null) {
                valueAnimator.cancel();
            }
            ValueAnimator valueAnimator2 = this.f12354S;
            if (valueAnimator2 != null) {
                valueAnimator2.cancel();
            }
            Handler handler = this.f12361Z;
            if (handler != null) {
                this.f12398x = false;
                handler.removeCallbacksAndMessages(null);
            }
            this.f12337B.m18538m();
            this.f12394t = false;
            this.f12337B.mo18543r();
            this.f12395u = false;
            if (!this.f12336A.mo10964a()) {
                this.f12337B.setVisibility(8);
            }
            m11515e();
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m11489a(float COUIBaseListPopupWindow_12, float f2, float f3, Rect rect, ZoomConfigure c2614af, boolean z) {
        ZoomConfigure c2614af2;
        this.f12399y = true;
        this.f12352Q = rect;
        this.f12351P = c2614af;
        this.f12381g = this.f12380f;
        this.f12380f = f3;
        this.f12382h = COUIBaseListPopupWindow_12;
        this.f12383i = f2;
        ZoomConfigure c2614af3 = this.f12351P;
        boolean zM11359o = c2614af3 != null ? c2614af3.m11359o() : false;
        this.f12378d = new ArrayList<>();
        this.f12379e.clear();
        float fM11320N = 2.0f;
        if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_FRONT_CAMERA_AUTO_ZOOM) && zM11359o) {
            this.f12378d.add(Float.valueOf(1.0f));
            this.f12378d.add(Float.valueOf(2.0f));
        } else {
            ZoomConfigure c2614af4 = this.f12351P;
            if (c2614af4 != null && ((c2614af4.m11355m() && this.f12351P.m11357n()) || this.f12351P.m11375w() || ((this.f12351P.m11371u() && this.f12351P.m11343g()) || this.f12351P.m11319M() || this.f12351P.m11309G()))) {
                this.f12378d.add(Float.valueOf(f12334a));
                this.f12378d.add(Float.valueOf(1.0f));
                this.f12379e.add(Float.valueOf(1.0f));
            } else {
                if (Float.compare(this.f12382h, 1.0f) < 0) {
                    this.f12378d.add(Float.valueOf(new BigDecimal(this.f12382h).setScale(1, 1).floatValue()));
                    this.f12379e.add(Float.valueOf(new BigDecimal(this.f12382h).setScale(1, 1).floatValue()));
                } else if (z && (c2614af2 = this.f12351P) != null && c2614af2.m11343g() && !this.f12351P.m11361p()) {
                    this.f12378d.add(Float.valueOf(f12334a));
                }
                if (Float.compare(this.f12382h, 1.0f) <= 0) {
                    this.f12378d.add(Float.valueOf(1.0f));
                }
                ZoomConfigure c2614af5 = this.f12351P;
                if (c2614af5 != null) {
                    if (c2614af5.m11379y()) {
                        fM11320N = 3.0f;
                    } else if (Float.compare(this.f12351P.m11320N(), 0.0f) != 0) {
                        fM11320N = this.f12351P.m11320N();
                    }
                }
                if (!zM11359o && Float.compare(this.f12383i, fM11320N) >= 0) {
                    ZoomConfigure c2614af6 = this.f12351P;
                    if (c2614af6 != null && c2614af6.m11381z() && fM11320N != 5.0f && fM11320N != 10.0f) {
                        this.f12378d.add(Float.valueOf(fM11320N));
                    }
                    if (Float.compare(this.f12383i, 5.0f) >= 0) {
                        this.f12378d.add(Float.valueOf(5.0f));
                        if (Float.compare(this.f12383i, 20.0f) >= 0) {
                            this.f12378d.add(Float.valueOf(10.0f));
                        }
                    }
                }
                if (Float.compare(this.f12382h, 1.0f) <= 0) {
                    this.f12379e.add(Float.valueOf(1.0f));
                }
                ZoomConfigure c2614af7 = this.f12351P;
                if (c2614af7 != null && c2614af7.m11381z()) {
                    this.f12379e.add(Float.valueOf(fM11320N));
                }
                if (Float.compare(this.f12383i, 8.0f) >= 0) {
                    this.f12379e.add(Float.valueOf(5.0f));
                    if (Float.compare(this.f12383i, 10.0f) > 0) {
                        this.f12379e.add(Float.valueOf(10.0f));
                    }
                }
            }
        }
        ZoomConfigure c2614af8 = this.f12351P;
        if (c2614af8 != null) {
            this.f12337B.setCustomUltraWideIcon(c2614af8.m11362q());
            this.f12337B.setCustomWideIcon(this.f12351P.m11364r());
            this.f12337B.setCustomTeleIcon(this.f12351P.m11366s());
            this.f12337B.setDisplayMode(this.f12351P.m11369t() ? ZoomSeekBar.PlatformImplementations.kt_3.ICON_ONLY : ZoomSeekBar.PlatformImplementations.kt_3.NORMAL);
        }
        ZoomConfigure c2614af9 = this.f12351P;
        int iM11306F = (c2614af9 == null || !c2614af9.m11305E()) ? 1 : this.f12351P.m11306F();
        ZoomConfigure c2614af10 = this.f12351P;
        boolean zM11313I = c2614af10 != null ? c2614af10.m11313I() : false;
        ZoomConfigure c2614af11 = this.f12351P;
        boolean zM11315J = c2614af11 != null ? c2614af11.m11315J() : false;
        boolean zMo10966a = this.f12336A.mo10966a(CameraUIInterface.KEY_FRONT_ZOOM_SWITCH);
        boolean zMo10957B = this.f12336A.mo10957B();
        CameraInterface interfaceC2646a = this.f12350O;
        int iMo10547aw = interfaceC2646a != null ? interfaceC2646a.mo10547aw() : 0;
        String strMo10985n = this.f12336A.mo10985n();
        ZoomConfigure c2614af12 = this.f12351P;
        boolean zM11355m = c2614af12 != null ? c2614af12.m11355m() : false;
        ZoomConfigure c2614af13 = this.f12351P;
        boolean zM11323Q = c2614af13 != null ? c2614af13.m11323Q() : false;
        boolean zM11541u = m11541u();
        ZoomConfigure c2614af14 = this.f12351P;
        boolean zM11361p = c2614af14 != null ? c2614af14.m11361p() : false;
        ZoomConfigure c2614af15 = this.f12351P;
        boolean zM11343g = c2614af15 != null ? c2614af15.m11343g() : false;
        boolean z2 = (zM11313I == this.f12367af && zM11315J == this.f12368ag && iMo10547aw == this.f12365ad && strMo10985n.equals(this.f12366ae) && zM11355m == this.f12369ah && zM11343g == this.f12396v && zM11323Q == this.f12370ai && (zM11541u == this.f12372ak || strMo10985n.equals(ApsConstant.REC_MODE_SLOW_VIDEO)) && zM11361p == this.f12371aj) ? false : true;
        this.f12365ad = iMo10547aw;
        this.f12366ae = strMo10985n;
        this.f12367af = zM11313I;
        this.f12368ag = zM11315J;
        this.f12369ah = zM11355m;
        this.f12396v = zM11343g;
        this.f12370ai = zM11323Q;
        this.f12372ak = zM11541u;
        this.f12371aj = zM11361p;
        this.f12337B.mo23076a(m11410U() ? f12334a : this.f12380f, this.f12382h, this.f12383i, this.f12379e, this.f12378d, iM11306F, zMo10966a, zMo10957B, z2);
        if (!this.f12344I.isShown() || !zM11359o) {
            this.f12344I.m24159a(m11410U() ? f12334a : this.f12380f, this.f12378d, this.f12391q, iM11306F);
        }
        CameraLog.m12954a("ZoomManager", "initialize, mMinZoomValue: " + this.f12382h + ", mMaxZoomValue: " + this.f12383i + ", mCurrentZoomValue: " + this.f12380f + ", mClickPoints: " + this.f12378d.toString());
    }

    /* renamed from: U */
    private boolean m11410U() {
        return this.f12336A.mo10990s() || this.f12336A.mo10994w() || m11484B() || m11428ab();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public boolean m11499a(MotionEvent motionEvent) {
        if (this.f12346K == null || !m11543w()) {
            return false;
        }
        if (this.f12336A.mo10964a() || m11427aa()) {
            if (motionEvent.getPointerCount() >= 2) {
                this.f12346K.m11238a(motionEvent);
            }
            return !m11427aa() && this.f12346K.m11237a();
        }
        if ((!this.f12346K.m11237a() || 2 > motionEvent.getPointerCount() || 6 != motionEvent.getAction()) && 262 != motionEvent.getAction()) {
            return false;
        }
        this.f12346K.m11238a(motionEvent);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m11434b(float COUIBaseListPopupWindow_12, boolean z) {
        String str;
        if (!this.f12336A.mo10976e()) {
            CameraLog.m12967f("ZoomManager", "handleMessage, cancel click");
            return;
        }
        float f2 = this.f12380f;
        ZoomConfigure c2614af = this.f12351P;
        str = "on";
        if (c2614af != null && c2614af.m11345h()) {
            if (!this.f12336A.mo10991t() && Float.compare(2.0f, COUIBaseListPopupWindow_12) <= 0) {
                this.f12349N.edit().putString(CameraUIInterface.KEY_NONE_SAT_TELE_ANGLE, "on").apply();
            } else if (this.f12336A.mo10991t() && Float.compare(2.0f, COUIBaseListPopupWindow_12) > 0) {
                this.f12349N.edit().putString(CameraUIInterface.KEY_NONE_SAT_TELE_ANGLE, "off").apply();
            }
        }
        ZoomConfigure c2614af2 = this.f12351P;
        if (c2614af2 != null && (c2614af2.m11351k() || this.f12351P.m11353l())) {
            m11433b(COUIBaseListPopupWindow_12, COUIBaseListPopupWindow_12);
            str = Float.compare(2.0f, COUIBaseListPopupWindow_12) != 0 ? "off" : "on";
            if (this.f12351P.m11351k()) {
                this.f12349N.edit().putString(CameraUIInterface.KEY_PORTRAIT_HALF_BODY, str).apply();
            } else if (this.f12351P.m11353l()) {
                this.f12349N.edit().putString(CameraUIInterface.KEY_PORTRAIT_HALF_BODY_REMOSAIC, str).apply();
            }
        } else {
            ZoomConfigure c2614af3 = this.f12351P;
            if (c2614af3 != null && c2614af3.m11355m()) {
                if (Float.compare(f12334a, COUIBaseListPopupWindow_12) == 0) {
                    COUIBaseListPopupWindow_12 = 1.0f;
                } else {
                    str = "off";
                }
                m11433b(COUIBaseListPopupWindow_12, COUIBaseListPopupWindow_12);
                this.f12349N.edit().putString(CameraUIInterface.KEY_ULTRA_WIDE_HIGH_PICTURE_SIZE, str).apply();
            } else {
                ZoomConfigure c2614af4 = this.f12351P;
                if (c2614af4 != null && c2614af4.m11371u() && this.f12351P.m11343g()) {
                    this.f12349N.edit().putBoolean(CameraUIInterface.KEY_HYPER_LAPSE_ZOOM_ULTRA_WIDE_OPEN, !this.f12349N.getBoolean(CameraUIInterface.KEY_HYPER_LAPSE_ZOOM_ULTRA_WIDE_OPEN, true)).apply();
                } else if (Float.compare(f12334a, COUIBaseListPopupWindow_12) == 0) {
                    ZoomConfigure c2614af5 = this.f12351P;
                    if (c2614af5 != null) {
                        if (c2614af5.m11337d()) {
                            m11433b(COUIBaseListPopupWindow_12, COUIBaseListPopupWindow_12);
                        } else if (this.f12351P.m11343g()) {
                            this.f12349N.edit().putString(CameraUIInterface.KEY_NONE_SAT_ULTRA_WIDE_ANGLE, "on").apply();
                            m11411V();
                            m11433b(1.0f, COUIBaseListPopupWindow_12);
                        } else if (this.f12351P.m11319M()) {
                            this.f12336A.mo10969b(true);
                            m11433b(1.0f, COUIBaseListPopupWindow_12);
                        } else if (this.f12351P.m11309G()) {
                            this.f12349N.edit().putString(CameraUIInterface.KEY_FISH_EYE_MODE, "off").apply();
                            m11539s();
                        }
                    }
                } else {
                    ZoomConfigure c2614af6 = this.f12351P;
                    if (c2614af6 != null) {
                        if (c2614af6.m11343g() && this.f12349N.contains(CameraUIInterface.KEY_NONE_SAT_ULTRA_WIDE_ANGLE) && this.f12336A.mo10990s()) {
                            this.f12349N.edit().putString(CameraUIInterface.KEY_NONE_SAT_ULTRA_WIDE_ANGLE, "off").apply();
                            m11411V();
                        } else if (this.f12351P.m11319M()) {
                            this.f12336A.mo10969b(false);
                        } else if (this.f12351P.m11309G()) {
                            this.f12349N.edit().putString(CameraUIInterface.KEY_FISH_EYE_MODE, "on").apply();
                            m11539s();
                        }
                    }
                    for (int OplusGLSurfaceView_13 = 1; OplusGLSurfaceView_13 <= 1; OplusGLSurfaceView_13++) {
                        m11433b(((COUIBaseListPopupWindow_12 - f2) * this.f12374am.getInterpolation(OplusGLSurfaceView_13 / 1)) + f2, COUIBaseListPopupWindow_12);
                    }
                }
            }
        }
        if (z) {
            m11457h(1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: V */
    public void m11411V() {
        if ("on".equals(this.f12349N.getString(CameraUIInterface.KEY_SUB_SETTING, "off"))) {
            this.f12349N.edit().putString(CameraUIInterface.KEY_SUB_SETTING, "off").apply();
        }
    }

    /* renamed from: o */
    public void m11535o() {
        if (!this.f12336A.mo10976e()) {
            CameraLog.m12967f("ZoomManager", "handleMessage, cancel click");
            return;
        }
        ZoomConfigure c2614af = this.f12351P;
        if (c2614af != null && c2614af.m11355m()) {
            this.f12349N.edit().putString(CameraUIInterface.KEY_ULTRA_WIDE_HIGH_PICTURE_SIZE, "on").apply();
        } else {
            ZoomConfigure c2614af2 = this.f12351P;
            if (c2614af2 != null && c2614af2.m11343g()) {
                this.f12349N.edit().putString(CameraUIInterface.KEY_NONE_SAT_ULTRA_WIDE_ANGLE, "on").apply();
            }
        }
        m11490a(f12334a, false);
        float COUIBaseListPopupWindow_12 = f12334a;
        m11433b(COUIBaseListPopupWindow_12, COUIBaseListPopupWindow_12);
        m11457h(8);
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    public void m11522g(boolean z) {
        ZoomConfigure c2614af;
        if (m11414Y()) {
            if (m11393H() && this.f12340E.m23964b()) {
                return;
            }
            ZoomConfigure c2614af2 = this.f12351P;
            if (c2614af2 == null || !c2614af2.m11341f() || (!this.f12350O.mo10539ao() && z)) {
                ZoomClickChangeView c3525x = this.f12344I;
                if (c3525x != null) {
                    c3525x.setFromClickView(false);
                }
                float fFloatValue = new BigDecimal(String.valueOf(Math.round((this.f12380f + (z ? 0.1f : -0.1f)) * 100.0f) / 100.0f)).setScale(1, 1).floatValue();
                float COUIBaseListPopupWindow_12 = this.f12382h;
                float f2 = fFloatValue + 1.0E-5f;
                if (this.f12396v && (c2614af = this.f12351P) != null && c2614af.m11343g() && !this.f12351P.m11361p() && (this.f12351P.m11337d() || !this.f12350O.mo10539ao())) {
                    COUIBaseListPopupWindow_12 = f12334a;
                }
                float fM24201a = Util.m24201a(f2, COUIBaseListPopupWindow_12, this.f12383i);
                if (this.f12380f == fM24201a) {
                    return;
                }
                m11457h(3);
                ZoomConfigure c2614af3 = this.f12351P;
                if (c2614af3 != null && c2614af3.m11345h()) {
                    if (this.f12336A.mo10991t() && Float.compare(fM24201a, 2.0f) < 0) {
                        this.f12349N.edit().putString(CameraUIInterface.KEY_NONE_SAT_TELE_ANGLE, "off").apply();
                    } else if (!this.f12336A.mo10991t() && Float.compare(fM24201a, 2.0f) >= 0 && !this.f12336A.mo10993v()) {
                        this.f12349N.edit().putString(CameraUIInterface.KEY_NONE_SAT_TELE_ANGLE, "on").apply();
                    }
                }
                ZoomConfigure c2614af4 = this.f12351P;
                if (c2614af4 != null && c2614af4.m11343g()) {
                    if (this.f12336A.mo10990s() && Float.compare(fM24201a, f12334a) > 0) {
                        this.f12349N.edit().putString(CameraUIInterface.KEY_NONE_SAT_ULTRA_WIDE_ANGLE, "off").apply();
                        m11490a(1.0f, true);
                        if (this.f12337B.m23127A()) {
                            m11448e(1.0f);
                            return;
                        }
                        return;
                    }
                    if (!this.f12336A.mo10990s() && Float.compare(fM24201a, 1.0f) < 0) {
                        this.f12349N.edit().putString(CameraUIInterface.KEY_NONE_SAT_ULTRA_WIDE_ANGLE, "on").apply();
                        m11490a(f12334a, true);
                        if (this.f12337B.m23127A()) {
                            m11448e(f12334a);
                            return;
                        }
                        return;
                    }
                }
                m11490a(fM24201a, true);
                m11433b(fM24201a, fM24201a);
                if (this.f12351P != null && this.f12394t && this.f12337B.m23127A()) {
                    m11448e(fM24201a);
                }
            }
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public boolean m11500a(boolean z, float COUIBaseListPopupWindow_12, float f2) {
        if (!m11414Y()) {
            return false;
        }
        if (m11393H() && this.f12340E.m23964b()) {
            return false;
        }
        ZoomConfigure c2614af = this.f12351P;
        if (c2614af != null && c2614af.m11341f() && (this.f12350O.mo10539ao() || !z)) {
            return false;
        }
        ZoomClickChangeView c3525x = this.f12344I;
        if (c3525x != null) {
            c3525x.setFromClickView(false);
        }
        float f3 = this.f12380f;
        if (!z) {
            COUIBaseListPopupWindow_12 = -COUIBaseListPopupWindow_12;
        }
        float fM24201a = Util.m24201a(new BigDecimal(String.valueOf(Math.round((f3 + COUIBaseListPopupWindow_12) * 100.0f) / 100.0f)).setScale(2, 1).floatValue() + 1.0E-5f, f2, this.f12383i);
        if (this.f12380f == fM24201a) {
            return false;
        }
        m11457h(3);
        ZoomConfigure c2614af2 = this.f12351P;
        if (c2614af2 != null && c2614af2.m11345h()) {
            if (this.f12336A.mo10991t() && Float.compare(fM24201a, 2.0f) < 0) {
                this.f12349N.edit().putString(CameraUIInterface.KEY_NONE_SAT_TELE_ANGLE, "off").apply();
            } else if (!this.f12336A.mo10991t() && Float.compare(fM24201a, 2.0f) >= 0 && !this.f12336A.mo10993v()) {
                this.f12349N.edit().putString(CameraUIInterface.KEY_NONE_SAT_TELE_ANGLE, "on").apply();
            }
        }
        ZoomConfigure c2614af3 = this.f12351P;
        if (c2614af3 != null && c2614af3.m11343g()) {
            if (this.f12336A.mo10990s() && Float.compare(fM24201a, f12334a) > 0) {
                this.f12349N.edit().putString(CameraUIInterface.KEY_NONE_SAT_ULTRA_WIDE_ANGLE, "off").apply();
                m11490a(1.0f, true);
                if (this.f12337B.m23127A()) {
                    m11448e(1.0f);
                }
                return false;
            }
            if (!this.f12336A.mo10990s() && Float.compare(fM24201a, 1.0f) < 0) {
                this.f12349N.edit().putString(CameraUIInterface.KEY_NONE_SAT_ULTRA_WIDE_ANGLE, "on").apply();
                m11490a(f12334a, true);
                if (this.f12337B.m23127A()) {
                    m11448e(f12334a);
                }
                return false;
            }
        }
        m11490a(fM24201a, true);
        m11433b(fM24201a, fM24201a);
        if (this.f12351P != null && this.f12394t && this.f12337B.m23127A()) {
            m11448e(fM24201a);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: COUIBaseListPopupWindow_11 */
    public void m11454g(float COUIBaseListPopupWindow_12) {
        if (this.f12336A.mo10986o()) {
            Collections.sort(this.f12379e);
            Iterator<Float> it = this.f12379e.iterator();
            while (it.hasNext()) {
                float fFloatValue = it.next().floatValue();
                if ((Float.compare(fFloatValue, this.f12380f) > 0 && Float.compare(fFloatValue, COUIBaseListPopupWindow_12) <= 0) || (Float.compare(fFloatValue, this.f12380f) < 0 && Float.compare(fFloatValue, COUIBaseListPopupWindow_12) >= 0)) {
                    if (this.f12379e.get(0).floatValue() != fFloatValue) {
                        if (this.f12379e.get(r2.size() - 1).floatValue() != fFloatValue) {
                            if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_ONEPLUS_VIBRATE_SUPPORT)) {
                                this.f12336A.mo10989r();
                                return;
                            } else {
                                this.f12336A.mo10988q();
                                return;
                            }
                        }
                    } else {
                        continue;
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m11433b(float COUIBaseListPopupWindow_12, float f2) {
        m11418a(COUIBaseListPopupWindow_12, f2, true, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public void m11418a(float COUIBaseListPopupWindow_12, float f2, boolean z, boolean z2) {
        if (Float.compare(this.f12380f, COUIBaseListPopupWindow_12) == 0) {
            return;
        }
        ZoomConfigure c2614af = this.f12351P;
        if (c2614af != null && c2614af.m11337d() && z) {
            Iterator<Float> it = this.f12377c.iterator();
            while (it.hasNext()) {
                float fFloatValue = it.next().floatValue();
                if (COUIBaseListPopupWindow_12 < fFloatValue && COUIBaseListPopupWindow_12 >= fFloatValue - 0.1f) {
                    float fWidth = (this.f12352Q.width() / 2.0f) / ((int) ((r1 / fFloatValue) + 1.0f));
                    if (COUIBaseListPopupWindow_12 >= fWidth) {
                        COUIBaseListPopupWindow_12 = fWidth;
                    }
                }
            }
        }
        float fM24201a = Util.m24201a(COUIBaseListPopupWindow_12, this.f12382h, this.f12383i);
        if (this.f12336A != null && Float.compare(fM24201a, this.f12380f) != 0) {
            this.f12381g = this.f12380f;
            this.f12380f = fM24201a;
            this.f12336A.mo10961a(fM24201a, true, f2);
            if (this.f12382h == fM24201a) {
                this.f12344I.m24161a(m11410U() ? f12334a : new BigDecimal(this.f12382h).setScale(1, 1).floatValue(), z2, false);
            } else {
                this.f12344I.m24161a(m11410U() ? f12334a : fM24201a, z2, false);
            }
        }
        if (Float.compare(f12334a, this.f12380f) == 0) {
            CameraTipsManager.m14374a().m14382g();
        }
        CameraLog.m12954a("ZoomManager", "changeZoom, mZoomValue: " + this.f12380f + ", value: " + fM24201a);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m11504b(int OplusGLSurfaceView_13, boolean z) {
        PlatformImplementations.kt_3 aVar;
        ValueAnimator valueAnimator = this.f12354S;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            if (!Util.m24495t()) {
                return;
            }
            this.f12354S.cancel();
            this.f12338C.setAlpha(1.0f);
            this.f12336A.mo10972c(1.0f);
        }
        ValueAnimator valueAnimator2 = this.f12353R;
        if (valueAnimator2 != null && valueAnimator2.isRunning()) {
            this.f12353R.cancel();
        }
        final RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f12337B.getLayoutParams();
        int i2 = layoutParams.bottomMargin;
        Activity activity = this.f12347L;
        int dimensionPixelOffset = activity != null ? activity.getResources().getDimensionPixelOffset(R.dimen.zoom_view_translate_anim_threshold) : 0;
        boolean z2 = OplusGLSurfaceView_13 > i2 && (aVar = this.f12336A) != null && aVar.mo10984m() && !this.f12336A.mo10958C();
        int i3 = z2 ? 150 : 0;
        if (Math.abs(OplusGLSurfaceView_13 - i2) > dimensionPixelOffset && z) {
            ValueAnimator valueAnimator3 = this.f12353R;
            if (valueAnimator3 == null) {
                this.f12353R = ValueAnimator.ofInt(i2, OplusGLSurfaceView_13);
                this.f12353R.setStartDelay(i3);
                this.f12353R.setDuration(400);
                this.f12353R.setInterpolator(AnimationUtils.loadInterpolator(this.f12337B.getContext(), R.anim.zoom_interpolator_in));
                this.f12353R.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ag.14
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator4) {
                        int iIntValue = ((Integer) valueAnimator4.getAnimatedValue()).intValue();
                        layoutParams.bottomMargin = iIntValue;
                        ZoomManager.this.f12337B.setLayoutParams(layoutParams);
                        ZoomManager.this.m11536p();
                        if (ZoomManager.this.f12336A != null) {
                            ZoomManager.this.f12336A.mo10962a(iIntValue);
                        }
                    }
                });
            } else if (!valueAnimator3.isRunning()) {
                this.f12353R.setIntValues(i2, OplusGLSurfaceView_13);
                this.f12353R.setStartDelay(i3);
                this.f12353R.setDuration(400);
            }
            if (this.f12354S == null) {
                this.f12354S = ValueAnimator.ofFloat(0.0f, 1.0f);
                this.f12354S.setStartDelay(i3);
                this.f12354S.setDuration(400);
                this.f12354S.setInterpolator(AnimationUtils.loadInterpolator(this.f12338C.getContext(), R.anim.alpha_path_interpolator));
                this.f12354S.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ag.15
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator4) {
                        float fFloatValue = ((Float) valueAnimator4.getAnimatedValue()).floatValue();
                        ZoomManager.this.f12338C.setAlpha(fFloatValue);
                        if (ZoomManager.this.f12336A != null) {
                            ZoomManager.this.f12336A.mo10972c(fFloatValue);
                        }
                    }
                });
            }
            if (z2) {
                this.f12338C.setAlpha(0.0f);
                AnimatorSet animatorSet = new AnimatorSet();
                animatorSet.play(this.f12354S).with(this.f12353R);
                animatorSet.start();
                return;
            }
            if (!this.f12353R.isRunning()) {
                this.f12353R.start();
            }
            PlatformImplementations.kt_3 aVar2 = this.f12336A;
            if (aVar2 != null) {
                aVar2.mo10972c(1.0f);
                return;
            }
            return;
        }
        layoutParams.bottomMargin = OplusGLSurfaceView_13;
        this.f12337B.setLayoutParams(layoutParams);
        m11536p();
        PlatformImplementations.kt_3 aVar3 = this.f12336A;
        if (aVar3 != null) {
            aVar3.mo10962a(OplusGLSurfaceView_13);
            this.f12336A.mo10972c(1.0f);
        }
    }

    /* renamed from: p */
    public void m11536p() {
        ViewParent parent = this.f12337B.getParent();
        if (!(parent instanceof RelativeLayout) || this.f12347L == null) {
            return;
        }
        View viewFindViewById = ((RelativeLayout) parent).findViewById(R.id_renamed.zoom_seek_anchor_view);
        float[] ultraWideZoomDotViewLocation = this.f12337B.getUltraWideZoomDotViewLocation();
        float dimensionPixelSize = this.f12347L.getResources().getDimensionPixelSize(R.dimen.zoom_click_point_radius);
        float dimensionPixelSize2 = this.f12347L.getResources().getDimensionPixelSize(R.dimen.bubble_zoom_ultra_margin_top);
        if (viewFindViewById != null) {
            if (ultraWideZoomDotViewLocation != null && 2 == ultraWideZoomDotViewLocation.length) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) viewFindViewById.getLayoutParams();
                int OplusGLSurfaceView_13 = (int) (2.0f * dimensionPixelSize);
                layoutParams.width = OplusGLSurfaceView_13;
                layoutParams.height = OplusGLSurfaceView_13;
                if (1 == this.f12337B.getLayoutDirection()) {
                    layoutParams.setMarginStart((int) ((Util.getScreenWidth() - ultraWideZoomDotViewLocation[0]) - dimensionPixelSize));
                } else {
                    layoutParams.setMarginStart((int) (ultraWideZoomDotViewLocation[0] - dimensionPixelSize));
                }
                layoutParams.topMargin = (int) (((ultraWideZoomDotViewLocation[1] - dimensionPixelSize2) - dimensionPixelSize) + (this.f12337B.getFocusCircleRadius() / 2));
                viewFindViewById.setLayoutParams(layoutParams);
                viewFindViewById.setVisibility(4);
                return;
            }
            viewFindViewById.setVisibility(8);
        }
    }

    /* renamed from: q */
    public boolean m11537q() {
        return this.f12397w && this.f12337B.m23165z();
    }

    /* renamed from: r */
    public void m11538r() {
        CameraLog.m12954a("ZoomManager", "onDestroy");
        this.f12347L = null;
        this.f12349N = null;
        this.f12350O = null;
        this.f12336A = null;
        this.f12346K = null;
        this.f12399y = false;
        AnimatorSet animatorSet = this.f12356U;
        if (animatorSet != null && animatorSet.isStarted() && this.f12356U.isRunning()) {
            this.f12356U.cancel();
        }
    }

    /* renamed from: COUIBaseListPopupWindow_10 */
    public void m11524h(boolean z) {
        this.f12400z = z;
        m11539s();
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public void m11513d(int OplusGLSurfaceView_13) {
        this.f12364ac = OplusGLSurfaceView_13;
        m11539s();
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x0073  */
    /* renamed from: s */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void m11539s() {
        /*
            r5 = this;
            com.oplus.camera.ui.preview.ai r0 = r5.f12337B
            if (r0 != 0) goto L5
            return
        L5:
            boolean r1 = r5.f12400z
            r2 = 1
            if (r1 == 0) goto Le
            r0.setLightBackground(r2)
            return
        Le:
            r0 = 2
            int r1 = r5.f12364ac
            r3 = 0
            if (r0 != r1) goto L16
            r0 = r2
            goto L17
        L16:
            r0 = r3
        L17:
            com.oplus.camera.ag$PlatformImplementations.kt_3 r1 = r5.f12336A
            if (r1 == 0) goto L30
            java.lang.String r1 = r1.mo10985n()
            java.lang.String r4 = "professional"
            boolean r1 = r4.equals(r1)
            if (r1 != 0) goto L2f
            com.oplus.camera.ag$PlatformImplementations.kt_3 r1 = r5.f12336A
            boolean r1 = r1.mo10958C()
            if (r1 == 0) goto L30
        L2f:
            r0 = r3
        L30:
            com.oplus.camera.screen.COUIBaseListPopupWindow_11 r1 = r5.f12363ab
            com.oplus.camera.screen.IntrinsicsJvm.kt_4.PlatformImplementations.kt_3 r1 = r1.mo16411a()
            int r1 = r1.mo16539j()
            if (r2 != r1) goto L4f
            com.oplus.camera.screen.COUIBaseListPopupWindow_11 r0 = r5.f12363ab
            com.oplus.camera.screen.IntrinsicsJvm.kt_4.PlatformImplementations.kt_3 r0 = r0.mo16411a()
            int r0 = r0.mo16570k()
            if (r0 != 0) goto L73
            int r0 = r5.f12364ac
            if (r0 == 0) goto L76
            if (r2 != r0) goto L73
            goto L76
        L4f:
            r1 = 4
            com.oplus.camera.screen.COUIBaseListPopupWindow_11 r4 = r5.f12363ab
            com.oplus.camera.screen.IntrinsicsJvm.kt_4.PlatformImplementations.kt_3 r4 = r4.mo16411a()
            int r4 = r4.mo16539j()
            if (r1 != r4) goto L6d
            com.oplus.camera.screen.COUIBaseListPopupWindow_11 r0 = r5.f12363ab
            com.oplus.camera.screen.IntrinsicsJvm.kt_4.PlatformImplementations.kt_3 r0 = r0.mo16411a()
            boolean r0 = r0.mo16630q()
            if (r0 == 0) goto L76
            int r0 = r5.f12364ac
            if (r2 == r0) goto L73
            goto L76
        L6d:
            boolean r1 = com.oplus.camera.util.Util.m24495t()
            if (r1 == 0) goto L75
        L73:
            r2 = r3
            goto L76
        L75:
            r2 = r0
        L76:
            com.oplus.camera.ui.preview.ai r5 = r5.f12337B
            r5.setLightBackground(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.ZoomManager.m11539s():void");
    }

    /* renamed from: OplusGLSurfaceView_13 */
    public void m11526i(final boolean z) {
        this.f12337B.post(new Runnable() { // from class: com.oplus.camera.-$$Lambda$ag$gNyyeuKfOzOzBYQBNCB0phiLmaQ
            @Override // java.lang.Runnable
            public final void run() {
                this.COUIBaseListPopupWindow_12$0.m11471p(z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: p */
    public /* synthetic */ void m11471p(boolean z) {
        if (this.f12336A.mo10966a(CameraUIInterface.KEY_FRONT_ZOOM_SWITCH)) {
            this.f12337B.m23152d(!z ? 1 : 0, false);
        }
    }

    /* renamed from: OplusGLSurfaceView_15 */
    public void m11527j(boolean z) {
        this.f12373al = z;
    }

    /* renamed from: t */
    public boolean m11540t() {
        return this.f12373al;
    }

    /* compiled from: ZoomManager.java */
    /* renamed from: com.oplus.camera.ag$IntrinsicsJvm.kt_4 */
    private class IntrinsicsJvm.kt_4 implements ScaleGestureDetector.PlatformImplementations.kt_3 {

        /* renamed from: IntrinsicsJvm.kt_4 */
        private float f12428b;

        /* renamed from: IntrinsicsJvm.kt_3 */
        private float f12429c;

        private IntrinsicsJvm.kt_4() {
            this.f12428b = 0.0f;
            this.f12429c = 0.0f;
        }

        @Override // com.oplus.camera.ScaleGestureDetector.PlatformImplementations.kt_3
        /* renamed from: PlatformImplementations.kt_3 */
        public boolean mo11244a(ScaleGestureDetector c2610ab) {
            if (ZoomManager.this.f12336A != null && ZoomManager.this.f12336A.mo10995x()) {
                return true;
            }
            float fM11242d = c2610ab.m11242d();
            if (Float.isInfinite(fM11242d) || Float.isNaN(fM11242d) || 0.0f == this.f12428b) {
                return true;
            }
            float fM11487a = ZoomManager.this.m11487a(this.f12429c, c2610ab.m11239b() - this.f12428b);
            if (ZoomManager.this.f12351P != null && ZoomManager.this.f12351P.m11345h() && !ZoomManager.this.f12350O.mo10539ao()) {
                if (ZoomManager.this.f12336A.mo10991t() || Float.compare(2.0f, fM11487a) > 0 || ZoomManager.this.f12336A.mo10993v()) {
                    if (ZoomManager.this.f12336A.mo10991t() && Float.compare(2.0f, fM11487a) > 0) {
                        ZoomManager.this.f12349N.edit().putString(CameraUIInterface.KEY_NONE_SAT_TELE_ANGLE, "off").apply();
                    }
                } else {
                    ZoomManager.this.f12349N.edit().putString(CameraUIInterface.KEY_NONE_SAT_TELE_ANGLE, "on").apply();
                }
            }
            if (ZoomManager.this.f12351P.m11343g()) {
                if (ZoomManager.this.f12351P.m11341f() && Float.compare(fM11487a, ZoomManager.f12334a) <= 0) {
                    return true;
                }
                if (!ZoomManager.this.f12336A.mo10990s() || Float.compare(fM11487a, ZoomManager.f12334a) <= 0) {
                    if (!ZoomManager.this.f12336A.mo10990s() && Float.compare(fM11487a, 1.0f) < 0) {
                        if (Float.compare(fM11487a, 0.8f) < 0 && !ZoomManager.this.f12350O.mo10539ao()) {
                            ZoomManager.this.f12349N.edit().putString(CameraUIInterface.KEY_NONE_SAT_ULTRA_WIDE_ANGLE, "on").apply();
                            ZoomManager.this.m11490a(ZoomManager.f12334a, false);
                            ZoomManager.this.m11433b(1.0f, 1.0f);
                            if (ZoomManager.this.f12337B.m23127A()) {
                                ZoomManager.this.m11448e(1.0f);
                            }
                        }
                        return true;
                    }
                } else {
                    if (Float.compare(fM11487a, 0.8f) > 0 && !ZoomManager.this.f12350O.mo10539ao()) {
                        ZoomManager.this.f12349N.edit().putString(CameraUIInterface.KEY_NONE_SAT_ULTRA_WIDE_ANGLE, "off").apply();
                        ZoomManager.this.m11490a(1.0f, false);
                        ZoomManager.this.m11433b(1.0f, 1.0f);
                        if (ZoomManager.this.f12337B.m23127A()) {
                            ZoomManager.this.m11448e(1.0f);
                        }
                    }
                    return true;
                }
            }
            ZoomManager.this.m11490a(fM11487a, false);
            ZoomManager.this.m11433b(fM11487a, fM11487a);
            if (!ZoomManager.this.f12337B.m18544s()) {
                ZoomManager.this.f12337B.mo18541p();
            }
            return true;
        }

        @Override // com.oplus.camera.ScaleGestureDetector.PlatformImplementations.kt_3
        /* renamed from: IntrinsicsJvm.kt_4 */
        public boolean mo11245b(ScaleGestureDetector c2610ab) {
            if (!ZoomManager.this.m11414Y()) {
                if (ZoomManager.this.m11427aa()) {
                    ZoomManager.this.f12336A.mo10982k();
                }
                return false;
            }
            if (!ZoomManager.this.m11415Z() || ZoomManager.this.f12336A.mo10992u() || !ZoomManager.this.f12336A.mo10976e() || MultiVideoSmallSurfaceTouchEventHelper.m13880a().m13884c()) {
                return false;
            }
            this.f12428b = c2610ab.m11241c();
            this.f12429c = ZoomManager.this.f12336A.mo10990s() ? ZoomManager.f12334a : ZoomManager.this.f12380f;
            ZoomManager.this.f12336A.mo10971c();
            ZoomManager.this.m11507b(false);
            ZoomManager.this.f12336A.mo10963a(true);
            ZoomManager.this.f12337B.mo18541p();
            return true;
        }

        @Override // com.oplus.camera.ScaleGestureDetector.PlatformImplementations.kt_3
        /* renamed from: IntrinsicsJvm.kt_3 */
        public void mo11246c(ScaleGestureDetector c2610ab) {
            if (ZoomManager.this.f12336A != null) {
                ZoomManager.this.f12336A.mo10974d();
                ZoomManager.this.f12336A.mo10963a(false);
            }
            ZoomManager.this.f12337B.mo18542q();
            ZoomManager.this.m11457h(4);
        }
    }

    /* renamed from: u */
    public boolean m11541u() {
        return this.f12336A.mo10964a();
    }

    /* renamed from: OplusGLSurfaceView_5 */
    public void m11529k(boolean z) {
        this.f12344I.setZoomUnit(z);
        this.f12337B.setZoomValueUnit(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: COUIBaseListPopupWindow_10 */
    public void m11457h(int OplusGLSurfaceView_13) {
        if (this.f12336A != null) {
            ZoomAdjustMsgData zoomAdjustMsgData = new ZoomAdjustMsgData(this.f12347L);
            zoomAdjustMsgData.mCaptureType = !this.f12336A.mo10983l() ? 1 : 0;
            zoomAdjustMsgData.mCaptureMode = this.f12336A.mo10985n();
            if (ApsConstant.REC_MODE_TIMELASPE_PRO.equals(zoomAdjustMsgData.mCaptureMode)) {
                zoomAdjustMsgData.mCaptureType = 1;
            }
            zoomAdjustMsgData.mOrientation = this.f12391q;
            zoomAdjustMsgData.mZoomType = OplusGLSurfaceView_13;
            zoomAdjustMsgData.mZoomValue = String.valueOf(m11410U() ? f12334a : m11486a());
            zoomAdjustMsgData.mbVideoRecording = this.f12350O.mo10539ao();
            if (10 == OplusGLSurfaceView_13 || 11 == OplusGLSurfaceView_13) {
                zoomAdjustMsgData.mRateValue = String.valueOf(this.f12384j);
            }
            if (this.f12350O.mo10575i()) {
                zoomAdjustMsgData.mCameraEnterType = String.valueOf(1);
            } else if (this.f12350O.mo10583m()) {
                zoomAdjustMsgData.mCameraEnterType = String.valueOf(3);
            } else {
                zoomAdjustMsgData.mCameraEnterType = String.valueOf(2);
            }
            zoomAdjustMsgData.mCameraId = this.f12350O.mo10548ax();
            zoomAdjustMsgData.mRearOrFront = CameraCharacteristicsUtil.m12974a(this.f12350O.mo10547aw()) ? DcsMsgData.FRONT : DcsMsgData.REAR;
            if (!TextUtils.isEmpty(zoomAdjustMsgData.mCaptureMode) && CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_QUICK_VIDEO_SUPPORT) && ApsConstant.CAPTURE_MODE_COMMON.equals(zoomAdjustMsgData.mCaptureMode) && this.f12350O.mo10549ay()) {
                zoomAdjustMsgData.mCaptureMode = ApsConstant.REC_MODE_QUICK_VIDEO;
                zoomAdjustMsgData.mCaptureType = 1;
            }
            zoomAdjustMsgData.report();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: W */
    public String m11412W() {
        if (this.f12337B != null) {
            return this.f12362aa.format(this.f12337B.m23154f(this.f12380f)) + "X";
        }
        return this.f12362aa.format(this.f12380f) + "X";
    }

    /* renamed from: v */
    public boolean m11542v() {
        return this.f12337B.m23129C();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: X */
    public boolean m11413X() {
        AnimatorSet animatorSet = this.f12355T;
        return animatorSet != null && animatorSet.isStarted() && this.f12355T.isRunning();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: Y */
    public boolean m11414Y() {
        ZoomConfigure c2614af = this.f12351P;
        if (c2614af == null) {
            return true;
        }
        if (c2614af.m11351k() || this.f12351P.m11353l() || this.f12351P.m11355m() || this.f12351P.m11375w() || this.f12351P.m11359o() || this.f12351P.m11305E() || this.f12351P.m11371u() || this.f12351P.m11319M() || this.f12351P.m11309G() || this.f12351P.m11321O()) {
            return false;
        }
        PlatformImplementations.kt_3 aVar = this.f12336A;
        if ((aVar != null && aVar.mo10996y()) || !this.f12351P.m11322P()) {
            return false;
        }
        PlatformImplementations.kt_3 aVar2 = this.f12336A;
        return aVar2 == null || 32 != aVar2.mo10959D();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: Z */
    public boolean m11415Z() {
        ZoomConfigure c2614af = this.f12351P;
        return c2614af == null || !c2614af.m11318L();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: aa */
    public boolean m11427aa() {
        ZoomConfigure c2614af = this.f12351P;
        return (c2614af == null || !c2614af.m11355m() || this.f12351P.m11357n()) ? false : true;
    }

    /* renamed from: w */
    public boolean m11543w() {
        return "off".equals(this.f12349N.getString(CameraUIInterface.KEY_SUB_SETTING, "off"));
    }

    /* renamed from: OplusGLSurfaceView_14 */
    public void m11532l(boolean z) {
        this.f12395u = z;
    }

    /* renamed from: x */
    public boolean m11544x() {
        return this.f12395u;
    }

    /* renamed from: y */
    public void m11545y() {
        ZoomSeekBar abstractC3438ai = this.f12337B;
        if (abstractC3438ai != null) {
            abstractC3438ai.m23161v();
        }
    }

    /* renamed from: z */
    public float[] m11546z() {
        ZoomConfigure c2614af;
        if (this.f12337B == null || (c2614af = this.f12351P) == null) {
            return null;
        }
        if (c2614af.m11337d() || this.f12351P.m11343g()) {
            return this.f12337B.getUltraWideZoomDotViewLocation();
        }
        return null;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public boolean m11506b(MotionEvent motionEvent) {
        if (m11528j()) {
            return m11425a(this.f12337B, (int) motionEvent.getRawX(), (int) motionEvent.getRawY());
        }
        return false;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public boolean m11511c(MotionEvent motionEvent) {
        ZoomSeekBar abstractC3438ai = this.f12337B;
        return abstractC3438ai != null && abstractC3438ai.m23148b(motionEvent);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m11502b(float COUIBaseListPopupWindow_12) {
        this.f12380f = COUIBaseListPopupWindow_12;
    }

    /* renamed from: A */
    public void m11483A() {
        ScaleGestureDetector c2610ab = this.f12346K;
        if (c2610ab != null) {
            c2610ab.m11243e();
        }
    }

    /* renamed from: B */
    public boolean m11484B() {
        ZoomConfigure c2614af = this.f12351P;
        return c2614af != null && c2614af.m11355m() && this.f12351P.m11357n() && "on".equals(this.f12349N.getString(CameraUIInterface.KEY_ULTRA_WIDE_HIGH_PICTURE_SIZE, "off"));
    }

    /* renamed from: ab */
    private boolean m11428ab() {
        ZoomConfigure c2614af = this.f12351P;
        return c2614af != null && c2614af.m11309G() && "off".equals(this.f12349N.getString(CameraUIInterface.KEY_FISH_EYE_MODE, "off"));
    }

    /* compiled from: ZoomManager.java */
    /* renamed from: com.oplus.camera.ag$IntrinsicsJvm.kt_3 */
    private class IntrinsicsJvm.kt_3 implements ZoomListener {
        private IntrinsicsJvm.kt_3() {
        }

        @Override // com.oplus.camera.p172ui.preview.ZoomListener
        /* renamed from: PlatformImplementations.kt_3 */
        public boolean mo11576a() {
            return ZoomManager.this.f12336A.mo10976e() && !ZoomManager.this.m11413X();
        }

        @Override // com.oplus.camera.p172ui.preview.ZoomListener
        /* renamed from: IntrinsicsJvm.kt_4 */
        public boolean mo11577b() {
            return ZoomManager.this.m11543w();
        }

        @Override // com.oplus.camera.p172ui.preview.ZoomListener
        /* renamed from: IntrinsicsJvm.kt_3 */
        public boolean mo11578c() {
            return ZoomManager.this.f12336A.mo10990s();
        }

        @Override // com.oplus.camera.p172ui.preview.ZoomListener
        /* renamed from: IntrinsicsJvm.kt_5 */
        public boolean mo11579d() {
            return ZoomManager.this.f12336A.mo10992u();
        }

        @Override // com.oplus.camera.p172ui.preview.ZoomListener
        /* renamed from: COUIBaseListPopupWindow_8 */
        public boolean mo11580e() {
            return ZoomManager.this.f12340E != null && ZoomManager.this.f12340E.m23964b();
        }

        @Override // com.oplus.camera.p172ui.preview.ZoomListener
        /* renamed from: COUIBaseListPopupWindow_12 */
        public boolean mo11581f() {
            if (ZoomManager.this.f12336A != null) {
                return ZoomManager.this.f12336A.mo10970b();
            }
            return false;
        }

        @Override // com.oplus.camera.p172ui.preview.ZoomListener
        /* renamed from: COUIBaseListPopupWindow_11 */
        public boolean mo11582g() {
            if (ZoomManager.this.f12336A != null) {
                return ZoomManager.this.f12336A.mo10996y();
            }
            return false;
        }

        @Override // com.oplus.camera.p172ui.preview.ZoomListener
        /* renamed from: COUIBaseListPopupWindow_10 */
        public boolean mo11583h() {
            if (ZoomManager.this.f12336A != null) {
                return ZoomManager.this.f12336A.mo10997z();
            }
            return false;
        }

        @Override // com.oplus.camera.p172ui.preview.ZoomListener
        /* renamed from: OplusGLSurfaceView_13 */
        public float mo11584i() {
            if (ZoomManager.this.f12351P != null) {
                return ZoomManager.this.f12351P.m11320N();
            }
            return 0.0f;
        }

        @Override // com.oplus.camera.p172ui.preview.ZoomListener
        /* renamed from: OplusGLSurfaceView_15 */
        public boolean mo11585j() {
            return (ZoomManager.this.f12341F != null && ZoomManager.this.f12341F.m23974a()) || (ZoomManager.this.f12342G != null && ZoomManager.this.f12342G.m23974a());
        }

        @Override // com.oplus.camera.p172ui.preview.ZoomListener
        /* renamed from: OplusGLSurfaceView_5 */
        public boolean mo11586k() {
            return ZoomManager.this.m11540t();
        }
    }

    /* renamed from: C */
    public void m11485C() {
        ZoomConfigure c2614af = this.f12351P;
        int iM11306F = (c2614af == null || !c2614af.m11305E()) ? 1 : this.f12351P.m11306F();
        ZoomConfigure c2614af2 = this.f12351P;
        boolean zM11313I = c2614af2 != null ? c2614af2.m11313I() : false;
        ZoomConfigure c2614af3 = this.f12351P;
        boolean zM11315J = c2614af3 != null ? c2614af3.m11315J() : false;
        boolean zMo10966a = this.f12336A.mo10966a(CameraUIInterface.KEY_FRONT_ZOOM_SWITCH);
        boolean zMo10957B = this.f12336A.mo10957B();
        CameraInterface interfaceC2646a = this.f12350O;
        int iMo10547aw = interfaceC2646a != null ? interfaceC2646a.mo10547aw() : 0;
        String strMo10985n = this.f12336A.mo10985n();
        ZoomConfigure c2614af4 = this.f12351P;
        boolean zM11355m = c2614af4 != null ? c2614af4.m11355m() : false;
        boolean zM11541u = m11541u();
        boolean z = (zM11313I == this.f12367af && zM11315J == this.f12368ag && iMo10547aw == this.f12365ad && strMo10985n.equals(this.f12366ae) && zM11355m == this.f12369ah && zM11541u == this.f12372ak) ? false : true;
        this.f12365ad = iMo10547aw;
        this.f12366ae = strMo10985n;
        this.f12367af = zM11313I;
        this.f12368ag = zM11315J;
        this.f12369ah = zM11355m;
        this.f12372ak = zM11541u;
        ZoomSeekBar abstractC3438ai = this.f12337B;
        if (abstractC3438ai != null) {
            abstractC3438ai.mo23076a(m11410U() ? f12334a : this.f12380f, this.f12382h, this.f12383i, this.f12379e, this.f12378d, iM11306F, zMo10966a, zMo10957B, z);
        }
        ZoomClickChangeView c3525x = this.f12344I;
        if (c3525x != null) {
            c3525x.m24159a(m11410U() ? f12334a : this.f12380f, this.f12378d, this.f12391q, iM11306F);
        }
        CameraLog.m12954a("ZoomManager", "updateZoomViewWithScreenMode, mClickPoints: " + this.f12378d.toString());
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static float m11416a(float COUIBaseListPopupWindow_12, int OplusGLSurfaceView_13) {
        return Math.round(((((int) ((COUIBaseListPopupWindow_12 + 1.0E-5f) / 0.1f)) * 0.1f) * OplusGLSurfaceView_13) * 10000.0f) / 10000.0f;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m11492a(int OplusGLSurfaceView_13, int i2) {
        CameraLog.m12954a("ZoomManager", "setScreenMode, layoutMode: " + OplusGLSurfaceView_13 + ", screenRotation: " + i2);
        AnimatorSet animatorSet = this.f12357V;
        if (animatorSet != null && animatorSet.isRunning()) {
            this.f12357V.cancel();
        }
        AnimatorSet animatorSet2 = this.f12358W;
        if (animatorSet2 != null && animatorSet2.isRunning()) {
            this.f12358W.cancel();
        }
        this.f12357V = null;
        this.f12358W = null;
        this.f12392r = OplusGLSurfaceView_13;
        this.f12393s = i2;
        InertiaZoomBar inertiaZoomBar = this.f12340E;
        if (inertiaZoomBar != null) {
            inertiaZoomBar.setScreenMode(OplusGLSurfaceView_13);
        }
    }

    /* renamed from: ac */
    private int m11429ac() {
        int OplusGLSurfaceView_13 = this.f12392r;
        return 1 == OplusGLSurfaceView_13 ? R.layout.camera_inertial_zoom_layout_vertical : 4 == OplusGLSurfaceView_13 ? R.layout.camera_inertial_zoom_layout_rackl : R.layout.camera_inertial_zoom_layout;
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public void m11516e(int OplusGLSurfaceView_13) throws Resources.NotFoundException {
        RelativeLayout.LayoutParams layoutParamsM11459i = m11459i(OplusGLSurfaceView_13);
        if (layoutParamsM11459i != null) {
            this.f12343H.setLayoutParams(layoutParamsM11459i);
        }
        RelativeLayout.LayoutParams layoutParamsM11462j = m11462j(OplusGLSurfaceView_13);
        this.f12360Y.removeView(this.f12339D);
        this.f12360Y.addView(this.f12339D, layoutParamsM11462j);
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    public void m11519f(int OplusGLSurfaceView_13) {
        m11525i();
        if (this.f12397w) {
            m11517e(false);
            RelativeLayout.LayoutParams layoutParamsM11459i = m11459i(OplusGLSurfaceView_13);
            if (layoutParamsM11459i != null) {
                this.f12343H.setLayoutParams(layoutParamsM11459i);
            }
            this.f12339D.setLayoutParams(m11462j(OplusGLSurfaceView_13));
        }
    }

    /* renamed from: ad */
    private void m11430ad() {
        InertiaZoomBar inertiaZoomBar = this.f12340E;
        if (inertiaZoomBar != null) {
            inertiaZoomBar.m23961a(this.f12391q, false);
        }
        InertialZoomButton inertialZoomButton = this.f12341F;
        if (inertialZoomButton != null) {
            inertialZoomButton.m18348a(this.f12391q, false);
        }
        InertialZoomButton inertialZoomButton2 = this.f12342G;
        if (inertialZoomButton2 != null) {
            inertialZoomButton2.m18348a(this.f12391q, false);
        }
        RotableTextView rotableTextView = this.f12343H;
        if (rotableTextView != null) {
            rotableTextView.m18344a(this.f12391q, false);
        }
    }

    /* renamed from: ae */
    private void m11431ae() {
        InertiaZoomBar inertiaZoomBar = this.f12340E;
        if (inertiaZoomBar != null) {
            inertiaZoomBar.m23961a(-90, false);
        }
        InertialZoomButton inertialZoomButton = this.f12341F;
        if (inertialZoomButton != null) {
            inertialZoomButton.m18348a(0, false);
        }
        InertialZoomButton inertialZoomButton2 = this.f12342G;
        if (inertialZoomButton2 != null) {
            inertialZoomButton2.m18348a(-90, false);
        }
        RotableTextView rotableTextView = this.f12343H;
        if (rotableTextView != null) {
            rotableTextView.m18344a(0, false);
        }
    }

    /* renamed from: OplusGLSurfaceView_13 */
    private RelativeLayout.LayoutParams m11459i(int OplusGLSurfaceView_13) {
        if (1 == OplusGLSurfaceView_13) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f12343H.getLayoutParams();
            layoutParams.addRule(20);
            if (270 == this.f12393s) {
                layoutParams.setMarginStart(0);
                return layoutParams;
            }
            layoutParams.setMarginStart(this.f12348M.getDimensionPixelSize(R.dimen.page_guide_double_exposure_video_height));
            return layoutParams;
        }
        if (4 != this.f12392r) {
            return null;
        }
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.f12343H.getLayoutParams();
        layoutParams2.addRule(20);
        layoutParams2.setMarginStart(this.f12348M.getDimensionPixelSize(R.dimen.inertial_zoom_text_view_margin_left_rack));
        return layoutParams2;
    }

    /* renamed from: OplusGLSurfaceView_15 */
    private RelativeLayout.LayoutParams m11462j(int OplusGLSurfaceView_13) throws Resources.NotFoundException {
        if (1 == OplusGLSurfaceView_13) {
            if (270 == this.f12393s) {
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, this.f12348M.getDimensionPixelSize(R.dimen.inertial_zoom_view_height_vertical));
                layoutParams.addRule(11);
                layoutParams.addRule(10);
                int dimensionPixelOffset = this.f12348M.getDimensionPixelOffset(R.dimen.top_margin_1_1);
                int dimensionPixelOffset2 = this.f12348M.getDimensionPixelOffset(R.dimen.mode_edit_head_line_vertical_height);
                layoutParams.rightMargin = -dimensionPixelOffset;
                layoutParams.topMargin = dimensionPixelOffset2;
                return layoutParams;
            }
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, this.f12348M.getDimensionPixelSize(R.dimen.inertial_zoom_view_height_vertical));
            layoutParams2.addRule(9);
            layoutParams2.addRule(10);
            int dimensionPixelOffset3 = this.f12348M.getDimensionPixelOffset(R.dimen.top_margin_1_1);
            int dimensionPixelOffset4 = this.f12348M.getDimensionPixelOffset(R.dimen.mode_edit_head_line_vertical_height);
            layoutParams2.leftMargin = -dimensionPixelOffset3;
            layoutParams2.topMargin = dimensionPixelOffset4;
            return layoutParams2;
        }
        if (4 == this.f12392r) {
            int dimensionPixelSize = this.f12348M.getDimensionPixelSize(R.dimen.inertial_zoom_view_height_rack);
            int dimensionPixelOffset5 = this.f12348M.getDimensionPixelOffset(R.dimen.inertial_zoom_view_margin_left_rack) + Util.m24198Z();
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, dimensionPixelSize);
            layoutParams3.addRule(9);
            layoutParams3.addRule(12);
            if ("low270" == this.f12350O.mo10519aU().mo16516h() || "rack270" == this.f12350O.mo10519aU().mo16516h()) {
                layoutParams3.leftMargin = dimensionPixelOffset5;
            } else {
                layoutParams3.leftMargin = this.f12348M.getDimensionPixelOffset(R.dimen.inertial_zoom_view_margin_left_rack);
            }
            layoutParams3.bottomMargin = 0;
            return layoutParams3;
        }
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams4.addRule(14);
        layoutParams4.addRule(2, R.id_renamed.control_panel_layout);
        layoutParams4.setMargins(0, 0, 0, this.f12348M.getDimensionPixelSize(R.dimen.inertial_zoombar_margin_bottom));
        return layoutParams4;
    }
}

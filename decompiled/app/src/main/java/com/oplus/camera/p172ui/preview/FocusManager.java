package com.oplus.camera.p172ui.preview;

import android.app.Activity;
import android.content.SharedPreferences;
import android.graphics.Rect;
import android.graphics.RectF;
import android.hardware.camera2.params.MeteringRectangle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Size;
import android.view.ViewGroup;
import com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection;
import com.oplus.camera.AEAFHelp;
import com.oplus.camera.CameraLog;
import com.oplus.camera.ComboPreferences;
import com.oplus.camera.CameraConstant;
import com.oplus.camera.R;
import com.oplus.camera.Storage;
import com.oplus.camera.aps.config.CameraConfig;
import com.oplus.camera.aps.config.CameraFunction;
import com.oplus.camera.aps.config.ConfigDataBase;
import com.oplus.camera.entry.CameraEntry;
import com.oplus.camera.p172ui.CameraUIInterface;
import com.oplus.camera.util.Util;

/* compiled from: FocusManager.java */
/* renamed from: com.oplus.camera.ui.preview.o */
/* loaded from: classes2.dex */
public class FocusManager implements CameraConstant, IFocusManagerProxy {

    /* renamed from: A */
    private CameraFocusListener f22222A;

    /* renamed from: B */
    private ComboPreferences f22223B;

    /* renamed from: OplusGLSurfaceView_11 */
    private Activity f22252n;

    /* renamed from: t */
    private Handler f22258t;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private int f22245g = 0;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private boolean f22246h = false;

    /* renamed from: OplusGLSurfaceView_13 */
    private boolean f22247i = false;

    /* renamed from: OplusGLSurfaceView_15 */
    private boolean f22248j = false;

    /* renamed from: OplusGLSurfaceView_5 */
    private boolean f22249k = false;

    /* renamed from: OplusGLSurfaceView_14 */
    private boolean f22250l = false;

    /* renamed from: OplusGLSurfaceView_6 */
    private boolean f22251m = false;

    /* renamed from: o */
    private FaceView f22253o = null;

    /* renamed from: p */
    private TrackFocusView f22254p = null;

    /* renamed from: q */
    private MultiFocusView f22255q = null;

    /* renamed from: r */
    private FocusIndicatorRotateLayout f22256r = null;

    /* renamed from: s */
    private boolean f22257s = false;

    /* renamed from: u */
    private int f22259u = -1;

    /* renamed from: v */
    private int f22260v = 1;

    /* renamed from: w */
    private int f22261w = 90;

    /* renamed from: x */
    private int f22262x = 0;

    /* renamed from: y */
    private int f22263y = 0;

    /* renamed from: z */
    private int f22264z = 0;

    /* renamed from: C */
    private int f22224C = 4;

    /* renamed from: D */
    private int f22225D = 0;

    /* renamed from: E */
    private boolean f22226E = false;

    /* renamed from: F */
    private boolean f22227F = false;

    /* renamed from: G */
    private boolean f22228G = false;

    /* renamed from: H */
    private String f22229H = "normal";

    /* renamed from: I */
    private float f22230I = 0.0f;

    /* renamed from: J */
    private float f22231J = 0.0f;

    /* renamed from: K */
    private float f22232K = 0.0f;

    /* renamed from: L */
    private float f22233L = 0.0f;

    /* renamed from: M */
    private int f22234M = 0;

    /* renamed from: N */
    private int f22235N = 0;

    /* renamed from: O */
    private int f22236O = 0;

    /* renamed from: P */
    private int f22237P = 0;

    /* renamed from: Q */
    private boolean f22238Q = false;

    /* renamed from: R */
    private boolean f22239R = false;

    /* renamed from: S */
    private boolean f22240S = false;

    /* renamed from: T */
    private boolean f22241T = false;

    /* renamed from: U */
    private Rect f22242U = null;

    /* renamed from: V */
    private Rect f22243V = null;

    /* renamed from: W */
    private Size f22244W = null;

    public FocusManager(Activity activity, ComboPreferences comboPreferences, CameraFocusListener interfaceC3443f) {
        this.f22252n = null;
        this.f22258t = null;
        this.f22222A = null;
        this.f22223B = null;
        this.f22252n = activity;
        this.f22223B = comboPreferences;
        this.f22258t = new PlatformImplementations.kt_3(this.f22252n.getMainLooper());
        this.f22222A = interfaceC3443f;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m23656a() {
        this.f22253o = (FaceView) this.f22252n.findViewById(R.id_renamed.face_view);
        this.f22255q = (MultiFocusView) this.f22252n.findViewById(R.id_renamed.multi_focus_view);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m23670b() {
        this.f22229H = this.f22223B.getString(CameraUIInterface.KEY_CAMERA_TIMER_SHUTTER, this.f22252n.getString(R.string.camera_shutter_mode_default_value));
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m23676c() {
        FaceView faceView = this.f22253o;
        if (faceView != null) {
            faceView.m22153d();
        }
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public void m23680d() {
        this.f22251m = false;
        m23698k(false);
        m23705r();
        m23697k();
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public void m23683e() {
        this.f22252n = null;
        this.f22253o = null;
        this.f22254p = null;
        this.f22255q = null;
        this.f22222A = null;
        Handler handler = this.f22258t;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.f22258t = null;
        }
        FocusIndicatorRotateLayout c3451n = this.f22256r;
        if (c3451n != null) {
            c3451n.m23603e();
            this.f22256r = null;
        }
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    public void m23686f() {
        if (this.f22256r == null) {
            this.f22256r = new FocusIndicatorRotateLayout(this.f22252n, null);
            this.f22256r.setVisibility(8);
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
            PreviewFrameLayout previewFrameLayout = (PreviewFrameLayout) this.f22252n.findViewById(R.id_renamed.frame_layout);
            if (previewFrameLayout != null) {
                previewFrameLayout.addView(this.f22256r, layoutParams);
            }
            this.f22256r.setFocusManager(this);
            this.f22256r.m23589a(this.f22263y, this.f22264z);
            this.f22256r.m23590a(this.f22236O, false);
            CameraLog.m12959b("FocusManager", "initFocusExposureIndicator, previewFrameLayout: " + previewFrameLayout);
        }
    }

    /* renamed from: P */
    private void m23606P() {
        if (this.f22254p == null) {
            this.f22254p = new TrackFocusView(this.f22252n);
            this.f22254p.setId(R.id_renamed.track_focus_view);
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
            PreviewFrameLayout previewFrameLayout = (PreviewFrameLayout) this.f22252n.findViewById(R.id_renamed.frame_layout);
            if (previewFrameLayout != null) {
                previewFrameLayout.addView(this.f22254p, layoutParams);
            }
            this.f22254p.m23021a(this.f22242U, this.f22243V, this.f22244W, new Size(this.f22263y, this.f22264z));
            this.f22254p.setVisibility(8);
            this.f22254p.setFocusManager(this);
            this.f22254p.m23020a(this.f22236O, false);
            this.f22254p.setDisplayOrientation(this.f22261w);
        }
        CameraFocusListener interfaceC3443f = this.f22222A;
        if (interfaceC3443f != null) {
            this.f22254p.setRearMirrorEnable(interfaceC3443f.mo10623d());
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m23667a(boolean z) {
        CameraLog.m12954a("FocusManager", "initialized");
        this.f22248j = true;
        m23674b(z);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m23659a(int OplusGLSurfaceView_13) {
        this.f22260v = OplusGLSurfaceView_13;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m23660a(int OplusGLSurfaceView_13, int i2) {
        if (this.f22263y != OplusGLSurfaceView_13 || this.f22264z != i2) {
            this.f22263y = OplusGLSurfaceView_13;
            this.f22264z = i2;
        }
        FocusIndicatorRotateLayout c3451n = this.f22256r;
        if (c3451n != null) {
            c3451n.m23589a(OplusGLSurfaceView_13, i2);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m23674b(boolean z) {
        this.f22249k = z;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m23673b(int OplusGLSurfaceView_13) {
        FocusIndicatorRotateLayout c3451n = this.f22256r;
        if (c3451n != null) {
            c3451n.m23590a(OplusGLSurfaceView_13, true);
        }
        TrackFocusView c3432ac = this.f22254p;
        if (c3432ac != null) {
            c3432ac.m23020a(OplusGLSurfaceView_13, true);
        }
        this.f22236O = OplusGLSurfaceView_13;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m23678c(int OplusGLSurfaceView_13) {
        this.f22261w = OplusGLSurfaceView_13;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m23662a(int OplusGLSurfaceView_13, int i2, int[] iArr, int i3, int i4) {
        if ((this.f22225D != OplusGLSurfaceView_13 || 1 == OplusGLSurfaceView_13) && this.f22252n != null) {
            if (i2 != 1 && 1 == this.f22262x) {
                CameraLog.m12954a("FocusManager", "updateFocusState, af is focusing, so discard caf state");
                return;
            }
            boolean z = this.f22225D == OplusGLSurfaceView_13;
            this.f22225D = OplusGLSurfaceView_13;
            this.f22241T = i2 != this.f22224C;
            this.f22224C = i2;
            this.f22228G = false;
            if (iArr != null) {
                this.f22228G = iArr[0] == 1;
            }
            this.f22226E = 1 == i4;
            if (!this.f22228G || 1 != OplusGLSurfaceView_13) {
                this.f22227F = !this.f22226E && 1 == OplusGLSurfaceView_13;
            }
            CameraLog.m12954a("FocusManager", "updateFocusState, state: " + OplusGLSurfaceView_13 + ", mode: " + i2 + ", isPdaf: " + this.f22228G + ", mbPdafConvergeDone: " + this.f22226E + ", mbAfMoving: " + this.f22227F);
            if (i3 == 0 || i3 == 3 || i3 == 4 || i3 == 5) {
                CameraLog.m12954a("FocusManager", "updateFocusState, return, cameraState: " + i3);
                return;
            }
            if (z) {
                if (this.f22251m && this.f22226E) {
                    CameraLog.m12954a("FocusManager", "updateFocusState, on AF status converged");
                    this.f22258t.removeMessages(12);
                    this.f22258t.sendEmptyMessage(12);
                    return;
                }
                return;
            }
            this.f22258t.removeMessages(10);
            this.f22258t.sendEmptyMessage(10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: Q */
    public void m23607Q() {
        int OplusGLSurfaceView_13 = this.f22225D;
        switch (OplusGLSurfaceView_13) {
            case 1:
                m23636l(this.f22228G);
                break;
            case 2:
                m23616a(this.f22224C, OplusGLSurfaceView_13, true, this.f22228G, false);
                break;
            case 3:
                if (this.f22241T) {
                    FocusIndicatorRotateLayout c3451n = this.f22256r;
                    if (c3451n != null && c3451n.getVisibility() == 0) {
                        this.f22256r.m23599c(false);
                    }
                    this.f22241T = false;
                    break;
                }
                break;
            case 4:
                if (3 == this.f22262x) {
                    CameraLog.m12966e("FocusManager", "onFocusStateUpdate, af focused receive again");
                    break;
                } else {
                    if (2 == this.f22245g && m23641A()) {
                        this.f22222A.mo10621c(true, true);
                    } else if (1 == this.f22245g && m23655O()) {
                        if (this.f22225D == 4 && this.f22224C == 1) {
                            m23681d(3);
                        }
                        m23709v();
                        CameraFocusListener interfaceC3443f = this.f22222A;
                        if (interfaceC3443f != null) {
                            interfaceC3443f.mo10638s();
                            m23664a(m23610T());
                            break;
                        }
                    }
                    m23616a(this.f22224C, this.f22225D, false, this.f22228G, true);
                    mo23652L();
                    break;
                }
                break;
            case 5:
                if (2 == this.f22245g && m23641A()) {
                    this.f22222A.mo10621c(true, true);
                } else if (1 == this.f22245g && m23655O()) {
                    m23709v();
                    CameraFocusListener interfaceC3443f2 = this.f22222A;
                    if (interfaceC3443f2 != null) {
                        interfaceC3443f2.mo10638s();
                        m23664a(m23610T());
                        break;
                    }
                }
                m23617a(this.f22224C, false, this.f22228G, true);
                mo23652L();
                break;
            case 6:
                m23617a(this.f22224C, true, this.f22228G, false);
                break;
        }
    }

    /* renamed from: OplusGLSurfaceView_14 */
    private void m23636l(boolean z) {
        CameraLog.m12954a("FocusManager", "onFocusStart");
        FaceView faceView = this.f22253o;
        if (faceView == null || !faceView.m22150a()) {
            MultiFocusView multiFocusView = this.f22255q;
            if (multiFocusView == null || !multiFocusView.m22193f()) {
                CameraFocusListener interfaceC3443f = this.f22222A;
                if ((interfaceC3443f == null || !interfaceC3443f.mo10634o()) && !this.f22239R) {
                    if (z || this.f22240S) {
                        if (this.f22240S && mo23649I()) {
                            return;
                        }
                        m23709v();
                        return;
                    }
                    m23686f();
                    this.f22256r.setAlpha(1.0f);
                    this.f22256r.m23597c();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public void m23616a(int OplusGLSurfaceView_13, int i2, boolean z, boolean z2, boolean z3) {
        CameraLog.m12954a("FocusManager", "onFocusSuccess, mode: " + OplusGLSurfaceView_13 + ", mExposureState: " + this.f22259u);
        if (i2 == 4 && OplusGLSurfaceView_13 == 1) {
            m23681d(3);
        }
        m23690g();
        FaceView faceView = this.f22253o;
        if (faceView == null || !faceView.m22150a()) {
            MultiFocusView multiFocusView = this.f22255q;
            if (multiFocusView == null || !multiFocusView.m22193f()) {
                CameraFocusListener interfaceC3443f = this.f22222A;
                if (interfaceC3443f == null || !interfaceC3443f.mo10634o()) {
                    FocusIndicatorRotateLayout c3451n = this.f22256r;
                    if (c3451n == null || c3451n.getVisibility() == 0) {
                        if (z2 || this.f22240S) {
                            if (z3) {
                                return;
                            }
                            m23709v();
                        } else {
                            m23686f();
                            this.f22256r.setAlpha(1.0f);
                            this.f22256r.m23592a(z, z3, this.f22259u != -1);
                            if (this.f22239R) {
                                this.f22256r.setVisibility(8);
                            }
                        }
                    }
                }
            }
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m23617a(int OplusGLSurfaceView_13, boolean z, boolean z2, boolean z3) {
        CameraLog.m12954a("FocusManager", "onFocusFail, mode: " + OplusGLSurfaceView_13);
        m23690g();
        FaceView faceView = this.f22253o;
        if (faceView == null || !faceView.m22150a()) {
            MultiFocusView multiFocusView = this.f22255q;
            if (multiFocusView == null || !multiFocusView.m22193f()) {
                CameraFocusListener interfaceC3443f = this.f22222A;
                if (interfaceC3443f == null) {
                    CameraLog.m12954a("FocusManager", "onFocusFail, mCameraFocusListener is null");
                    return;
                }
                if ((interfaceC3443f == null || !interfaceC3443f.mo10634o()) && !this.f22239R) {
                    FocusIndicatorRotateLayout c3451n = this.f22256r;
                    if (c3451n == null || c3451n.getVisibility() == 0) {
                        if (z2 || this.f22240S) {
                            if (z3) {
                                return;
                            }
                            m23709v();
                        } else {
                            m23686f();
                            this.f22256r.setAlpha(1.0f);
                            this.f22256r.m23595b(z, this.f22259u != -1);
                        }
                    }
                }
            }
        }
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    public boolean m23690g() {
        Handler handler = this.f22258t;
        if (handler == null || !handler.hasMessages(5)) {
            return false;
        }
        this.f22258t.removeMessages(9);
        this.f22258t.removeMessages(5);
        m23638m(false);
        return true;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m23663a(SharedPreferences sharedPreferences, String str) {
        if (CameraUIInterface.KEY_CAMERA_TIMER_SHUTTER.equals(CameraEntry.m13305d(str))) {
            String string = sharedPreferences.getString(CameraUIInterface.KEY_CAMERA_TIMER_SHUTTER, this.f22252n.getString(R.string.camera_shutter_mode_default_value));
            if (string.equals(this.f22229H)) {
                return;
            }
            this.f22229H = string;
        }
    }

    /* renamed from: COUIBaseListPopupWindow_10 */
    public boolean m23691h() {
        CameraFocusListener interfaceC3443f;
        Activity activity = this.f22252n;
        return (activity == null || !this.f22223B.getString(CameraUIInterface.KEY_CAMERA_TAP_SHUTTER, activity.getString(R.string.camera_tap_shutter_default_value)).equals("on") || (interfaceC3443f = this.f22222A) == null || !interfaceC3443f.mo10629j() || this.f22222A.mo10633n() || this.f22260v == 3 || !this.f22250l || 2 == this.f22245g || this.f22222A.mo10641v() || !this.f22222A.mo10614a(CameraUIInterface.KEY_CAMERA_TAP_SHUTTER)) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: OplusGLSurfaceView_6 */
    public void m23638m(boolean z) {
        CameraLog.m12954a("FocusManager", "doCapture, mAfFocusState: " + this.f22225D);
        if (this.f22222A.mo10641v()) {
            return;
        }
        if (!this.f22248j || Storage.f12097w != 0) {
            this.f22222A.mo10618b(true, false);
            this.f22222A.mo10617b(false);
            return;
        }
        m23681d(2);
        this.f22222A.mo10608a(z);
        this.f22222A.mo10617b(false);
        this.f22251m = false;
        m23681d(0);
        this.f22258t.removeMessages(1);
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public boolean m23679c(boolean z) {
        CameraLog.m12954a("FocusManager", "checkStateBeforeCapture, isAISSnapshot: " + z);
        if (!m23685e(z)) {
            return false;
        }
        m23682d(z);
        return true;
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public void m23682d(boolean z) {
        CameraLog.m12954a("FocusManager", "delayCapture, isAISSnapshot: " + z);
        m23681d(4);
        Handler handler = this.f22258t;
        if (handler != null) {
            handler.removeMessages(5);
            if (z) {
                this.f22258t.sendEmptyMessageDelayed(5, 240L);
            } else {
                this.f22258t.sendEmptyMessageDelayed(5, AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS);
            }
            this.f22251m = true;
        }
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public boolean m23685e(boolean z) {
        Handler handler;
        if (m23711x() && (handler = this.f22258t) != null && handler.hasMessages(6)) {
            this.f22258t.removeMessages(6);
            this.f22258t.sendEmptyMessageDelayed(6, 3000L);
        }
        return m23692h(z);
    }

    /* renamed from: OplusGLSurfaceView_13 */
    public void m23693i() {
        CameraFocusListener interfaceC3443f = this.f22222A;
        if (interfaceC3443f != null) {
            interfaceC3443f.mo10617b(false);
        }
        Handler handler = this.f22258t;
        if (handler != null) {
            handler.removeMessages(5);
            this.f22251m = false;
            if (4 == this.f22262x) {
                m23681d(0);
            }
        }
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public void m23681d(int OplusGLSurfaceView_13) {
        CameraLog.m12954a("FocusManager", "setFocusState(), mFocusState: " + this.f22262x + "=>" + OplusGLSurfaceView_13);
        this.f22262x = OplusGLSurfaceView_13;
    }

    /* renamed from: OplusGLSurfaceView_15 */
    public void m23695j() {
        CameraLog.m12954a("FocusManager", "checkFocusStateBeforeCapture, mFocusState: " + this.f22262x);
        if (m23643C() && m23701n() == 1 && this.f22262x == 1) {
            m23699l();
        }
    }

    /* renamed from: R */
    private boolean m23608R() {
        return this.f22222A.mo10622c() && !CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SAT_ULTRAWIDE_FOCUS_SUPPORT);
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public void m23684e(int OplusGLSurfaceView_13) {
        this.f22245g = OplusGLSurfaceView_13;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m23661a(int OplusGLSurfaceView_13, int i2, boolean z) {
        int i3 = OplusGLSurfaceView_13;
        if (!this.f22248j || this.f22262x == 2 || this.f22222A == null) {
            CameraLog.m12959b("FocusManager", "onSingleTapUp, mbInitialized: " + this.f22248j + ", mFocusState: " + this.f22262x + ", mCameraFocusListener: " + this.f22222A);
            return;
        }
        m23686f();
        if (z) {
            this.f22222A.mo10615b(i3, i2);
            this.f22256r.m23603e();
            this.f22259u = -1;
        }
        CameraLog.m12954a("FocusManager", "onSingleTapUp, fromUserTouch: " + z + ", mTouchType" + this.f22245g);
        this.f22250l = z;
        if (!this.f22222A.mo10637r() || m23608R()) {
            if (m23691h() && this.f22222A.mo10630k()) {
                this.f22222A.mo10617b(true);
                m23638m(true);
                return;
            } else if (!this.f22222A.mo10636q()) {
                CameraLog.m12954a("FocusManager", "onSingleTapUp(), camera not support touch ae");
                return;
            }
        }
        this.f22234M = i3;
        this.f22235N = i2;
        if (1 == m23701n()) {
            this.f22222A.mo10639t();
            m23700m();
            this.f22250l = z;
        }
        if (m23691h() && this.f22222A.mo10630k()) {
            this.f22222A.mo10617b(true);
            this.f22222A.mo10618b(false, true);
        }
        if (!this.f22222A.mo10614a(CameraUIInterface.KEY_TRACK_FOCUS)) {
            this.f22222A.mo10626g();
        }
        this.f22222A.mo10628i();
        this.f22256r.m23593b(i3, i2);
        if (this.f22222A.mo10637r()) {
            this.f22258t.removeMessages(6);
            if (this.f22250l && m23711x()) {
                this.f22258t.sendEmptyMessageDelayed(6, 3000L);
            }
        }
        int exposureRectWidth = this.f22256r.getExposureRectWidth();
        if (this.f22222A.mo10623d()) {
            i3 = this.f22263y - i3;
        }
        int i4 = exposureRectWidth / 2;
        int i5 = this.f22263y;
        int i6 = this.f22264z;
        RectF rectF = new RectF((i3 - i4) / i5, (i2 - i4) / i6, (i3 + i4) / i5, (i4 + i2) / i6);
        if (m23643C()) {
            if (1 == this.f22245g) {
                m23709v();
                this.f22222A.mo10638s();
                m23606P();
                this.f22254p.m23030h();
                int i7 = this.f22234M;
                float COUIBaseListPopupWindow_12 = exposureRectWidth / 2.0f;
                int i8 = this.f22235N;
                m23666a(new RectF(i7 - COUIBaseListPopupWindow_12, i8 - COUIBaseListPopupWindow_12, i7 + COUIBaseListPopupWindow_12, i8 + COUIBaseListPopupWindow_12));
                m23618a(rectF, rectF);
                m23612V();
            } else {
                m23698k(true);
                this.f22256r.m23597c();
                m23618a(rectF, rectF);
            }
            if (m23691h()) {
                m23682d(false);
                return;
            }
            return;
        }
        m23698k(true);
        this.f22256r.m23597c();
        Rect rectM11151a = AEAFHelp.m11151a(i3, i2, this.f22263y, this.f22264z, exposureRectWidth, this.f22249k, this.f22261w, 0, this.f22222A.mo10645z(), AEAFHelp.m11157e());
        this.f22222A.mo10607a(rectM11151a, Util.m24495t() ? rectM11151a : null);
        if (2 == this.f22245g) {
            m23640n(true);
        }
        this.f22238Q = false;
        m23702o();
    }

    /* renamed from: OplusGLSurfaceView_5 */
    public void m23697k() {
        m23681d(0);
        m23703p();
        if (this.f22240S) {
            m23698k(false);
        }
        this.f22238Q = false;
        m23702o();
    }

    /* renamed from: S */
    private boolean m23609S() {
        CameraFocusListener interfaceC3443f;
        return this.f22249k || ((interfaceC3443f = this.f22222A) != null && interfaceC3443f.mo10623d());
    }

    /* renamed from: T */
    private Rect m23610T() {
        FocusIndicatorRotateLayout c3451n = this.f22256r;
        return AEAFHelp.m11151a(this.f22234M, this.f22235N, this.f22263y, this.f22264z, c3451n != null ? c3451n.getExposureRectWidth() : 0, m23609S(), this.f22261w, 0, this.f22222A.mo10645z(), AEAFHelp.m11156d());
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m23618a(RectF rectF, RectF rectF2) {
        CameraLog.m12954a("FocusManager", "Start autofocus.");
        FaceView faceView = this.f22253o;
        if (faceView != null && !this.f22240S) {
            faceView.m22152c();
        }
        MultiFocusView multiFocusView = this.f22255q;
        if (multiFocusView != null) {
            multiFocusView.m22190c();
        }
        if (m23711x()) {
            this.f22238Q = true;
        }
        this.f22222A.mo10606a(1, rectF, rectF2);
        if (rectF2 != null && !this.f22222A.mo10622c()) {
            this.f22222A.mo10611a(m23624b(rectF2));
        }
        if (rectF != null && !this.f22222A.mo10622c()) {
            this.f22222A.mo10619b(m23624b(rectF));
        }
        m23681d(1);
        m23702o();
        this.f22258t.removeMessages(1);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private MeteringRectangle[] m23624b(RectF rectF) {
        if (rectF == null) {
            return null;
        }
        FocusIndicatorRotateLayout c3451n = this.f22256r;
        int exposureRectWidth = c3451n != null ? c3451n.getExposureRectWidth() : 0;
        float fCenterX = this.f22263y * rectF.centerX();
        float fCenterY = rectF.centerY();
        int OplusGLSurfaceView_13 = this.f22264z;
        Rect rectM11151a = AEAFHelp.m11151a(fCenterX, fCenterY * OplusGLSurfaceView_13, this.f22263y, OplusGLSurfaceView_13, exposureRectWidth, this.f22249k, this.f22261w, this.f22236O, this.f22222A.mo10645z(), AEAFHelp.m11157e());
        if (m23621b(rectM11151a)) {
            return new MeteringRectangle[]{new MeteringRectangle(rectM11151a, AEAFHelp.m11157e())};
        }
        return null;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private boolean m23621b(Rect rect) {
        return rect != null && rect.left >= 0 && rect.right >= 0 && rect.top >= 0 && rect.bottom >= 0;
    }

    /* renamed from: OplusGLSurfaceView_14 */
    public void m23699l() {
        CameraLog.m12954a("FocusManager", "resetAutoFocusMode");
        this.f22245g = 0;
        CameraFocusListener interfaceC3443f = this.f22222A;
        if (interfaceC3443f != null) {
            interfaceC3443f.mo10638s();
        }
        m23700m();
    }

    /* renamed from: OplusGLSurfaceView_6 */
    public void m23700m() {
        CameraLog.m12954a("FocusManager", "resetCameraFocusState()");
        m23703p();
        if (this.f22240S) {
            m23698k(false);
        }
        if (this.f22253o != null && !this.f22222A.mo10633n()) {
            this.f22253o.m22153d();
        }
        MultiFocusView multiFocusView = this.f22255q;
        if (multiFocusView != null) {
            multiFocusView.m22191d();
        }
        m23681d(0);
        Handler handler = this.f22258t;
        if (handler != null) {
            handler.removeMessages(1);
        }
    }

    /* renamed from: OplusGLSurfaceView_11 */
    public int m23701n() {
        return this.f22222A.mo10642w();
    }

    /* renamed from: o */
    public void m23702o() {
        FocusIndicator interfaceC3450m;
        if (this.f22248j) {
            m23686f();
            FaceView faceView = this.f22253o;
            boolean z = faceView != null && faceView.m22150a();
            MultiFocusView multiFocusView = this.f22255q;
            boolean z2 = multiFocusView != null && multiFocusView.m22193f();
            if (z) {
                interfaceC3450m = this.f22253o;
            } else if (z2) {
                interfaceC3450m = this.f22255q;
            } else {
                interfaceC3450m = this.f22256r;
            }
            boolean z3 = !this.f22250l;
            Handler handler = this.f22258t;
            if (handler != null) {
                handler.removeMessages(7);
            }
            this.f22256r.setAlpha(1.0f);
            int OplusGLSurfaceView_13 = this.f22224C;
            if (4 == OplusGLSurfaceView_13 || (3 == OplusGLSurfaceView_13 && !this.f22240S)) {
                interfaceC3450m.mo22148a(z3, this.f22259u != -1);
            }
            if (!this.f22250l || this.f22258t == null) {
                return;
            }
            boolean zMo10632m = this.f22222A.mo10632m();
            CameraLog.m12954a("FocusManager", "updateFocusUI, isFixedFocusMode: " + zMo10632m + " mbNeedLockAF: " + this.f22238Q);
            if (!zMo10632m && !this.f22238Q) {
                this.f22258t.removeMessages(6);
                this.f22258t.sendEmptyMessageDelayed(6, 3000L);
            }
            this.f22258t.removeMessages(7);
            this.f22258t.removeMessages(8);
            if (zMo10632m) {
                this.f22258t.sendEmptyMessageDelayed(7, 1000L);
                this.f22257s = true;
            }
            this.f22256r.m23599c(true);
        }
    }

    /* renamed from: p */
    public void m23703p() {
        if (!this.f22248j) {
            CameraLog.m12959b("FocusManager", "resetTouchFocusUi, initialize is not completed, abort!");
            return;
        }
        this.f22250l = false;
        Activity activity = this.f22252n;
        if (activity != null) {
            activity.runOnUiThread(new Runnable() { // from class: com.oplus.camera.ui.preview.o.1
                @Override // java.lang.Runnable
                public void run() {
                    if (FocusManager.this.f22256r != null) {
                        FocusManager.this.f22256r.m23603e();
                    }
                    FocusManager.this.f22259u = -1;
                }
            });
        }
    }

    /* renamed from: q */
    public void m23704q() {
        Handler handler = this.f22258t;
        if (handler != null) {
            handler.removeMessages(6);
            this.f22258t.removeMessages(7);
            this.f22258t.removeMessages(8);
        }
    }

    /* renamed from: r */
    public void m23705r() {
        this.f22258t.removeMessages(1);
        this.f22258t.removeMessages(5);
        this.f22258t.removeCallbacksAndMessages(null);
    }

    @Override // com.oplus.camera.p172ui.preview.IFocusManagerProxy
    /* renamed from: s */
    public boolean mo23706s() {
        return (!m23645E() || this.f22246h) && (!m23643C() || this.f22247i);
    }

    /* renamed from: t */
    public boolean m23707t() {
        FocusIndicatorRotateLayout c3451n = this.f22256r;
        return c3451n != null && c3451n.getVisibility() == 0;
    }

    /* renamed from: u */
    public boolean m23708u() {
        FocusIndicatorRotateLayout c3451n = this.f22256r;
        return c3451n != null && c3451n.m23596b();
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    public void m23688f(boolean z) {
        this.f22247i = z;
        this.f22246h = z;
        Activity activity = this.f22252n;
        if (activity != null) {
            activity.runOnUiThread(new Runnable() { // from class: com.oplus.camera.ui.preview.-$$Lambda$o$bMMSUhXmWaBaEHuDAY9eCTOIb5Q
                @Override // java.lang.Runnable
                public final void run() {
                    this.COUIBaseListPopupWindow_12$0.m23613W();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: W */
    public /* synthetic */ void m23613W() {
        FocusIndicatorRotateLayout c3451n = this.f22256r;
        if (c3451n != null && c3451n.getVisibility() == 0) {
            this.f22256r.m23591a(this.f22247i);
        }
        TrackFocusView c3432ac = this.f22254p;
        if (c3432ac == null || c3432ac.getVisibility() != 0) {
            return;
        }
        this.f22254p.setLockState(this.f22246h);
    }

    /* renamed from: v */
    public void m23709v() {
        Activity activity = this.f22252n;
        if (activity != null) {
            activity.runOnUiThread(new Runnable() { // from class: com.oplus.camera.ui.preview.o.2
                @Override // java.lang.Runnable
                public void run() {
                    if (FocusManager.this.f22256r != null) {
                        FocusManager.this.f22256r.m23603e();
                        if (FocusManager.this.f22240S && 1 == FocusManager.this.f22259u) {
                            return;
                        }
                        FocusManager.this.f22259u = -1;
                    }
                }
            });
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:119:0x01ae  */
    /* renamed from: PlatformImplementations.kt_3 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean m23669a(android.view.MotionEvent r15) {
        /*
            Method dump skipped, instructions count: 477
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.p172ui.preview.FocusManager.m23669a(android.view.MotionEvent):boolean");
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    private void m23627d(float COUIBaseListPopupWindow_12) {
        CameraFocusListener interfaceC3443f = this.f22222A;
        if (interfaceC3443f != null) {
            int iMo10643x = interfaceC3443f.mo10643x();
            int iMo10644y = this.f22222A.mo10644y();
            if (iMo10643x == 0 && iMo10644y == 0) {
                return;
            }
            this.f22222A.mo10604a((int) (iMo10644y + ((iMo10643x - iMo10644y) * COUIBaseListPopupWindow_12)));
        }
    }

    /* renamed from: w */
    public boolean m23710w() {
        return this.f22259u > 0;
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    public void m23689g(boolean z) {
        CameraLog.m12954a("FocusManager", "disableFocusIndicator, disable: " + z);
        FocusIndicatorRotateLayout c3451n = this.f22256r;
        if (c3451n != null) {
            c3451n.m23604e(z);
        }
    }

    /* renamed from: x */
    public boolean m23711x() {
        return (this.f22222A == null || (this.f22223B.getString(CameraUIInterface.KEY_CAMERA_TAP_SHUTTER, this.f22252n.getString(R.string.camera_tap_shutter_default_value)).equals("on") && this.f22222A.mo10629j() && this.f22222A.mo10614a(CameraUIInterface.KEY_CAMERA_TAP_SHUTTER)) || !this.f22222A.mo10640u() || this.f22260v == 3) ? false : true;
    }

    /* renamed from: y */
    public void m23712y() {
        TrackFocusView c3432ac;
        if (!m23711x() || mo23706s() || this.f22258t == null || !this.f22222A.mo10614a(CameraFunction.RESET_AUTO_FOCUS)) {
            return;
        }
        if (m23611U() || (m23655O() && (c3432ac = this.f22254p) != null && c3432ac.m23028f())) {
            this.f22258t.removeMessages(6);
            this.f22258t.sendEmptyMessage(6);
        }
    }

    /* renamed from: z */
    public void m23713z() {
        if (m23711x() && !mo23706s() && this.f22258t != null && m23611U() && this.f22222A.mo10614a(CameraFunction.RESET_AUTO_FOCUS)) {
            this.f22258t.removeMessages(6);
            this.f22258t.sendEmptyMessageDelayed(6, 3000L);
        }
    }

    /* renamed from: U */
    private boolean m23611U() {
        FocusIndicatorRotateLayout c3451n = this.f22256r;
        return c3451n != null && Math.abs(0.55f - c3451n.getAlpha()) <= 0.01f && this.f22256r.getVisibility() == 0;
    }

    /* renamed from: A */
    public boolean m23641A() {
        TrackFocusView c3432ac;
        FocusIndicatorRotateLayout c3451n = this.f22256r;
        return (c3451n != null && c3451n.getVisibility() == 0) || ((c3432ac = this.f22254p) != null && c3432ac.m23026d());
    }

    /* renamed from: COUIBaseListPopupWindow_10 */
    public boolean m23692h(boolean z) {
        int OplusGLSurfaceView_13 = this.f22225D;
        boolean z2 = 2 == OplusGLSurfaceView_13 || 6 == OplusGLSurfaceView_13 || OplusGLSurfaceView_13 == 0;
        CameraLog.m12954a("FocusManager", "inScanProgress, afDone: " + z2 + ", mAfFocusState: " + this.f22225D + ", mbPdaf: " + this.f22228G + ", mbPdafConvergeDone: " + this.f22226E + ", mbAfMoving: " + this.f22227F + ", isAISSnapshot: " + z);
        int i2 = this.f22224C;
        if (4 != i2) {
            return 1 == i2 && this.f22225D == 3 && !this.f22228G;
        }
        if (z2 || this.f22226E) {
            return false;
        }
        if (z) {
            return !this.f22227F;
        }
        return this.f22225D == 1 && !this.f22228G;
    }

    /* renamed from: B */
    public void m23642B() {
        Handler handler = this.f22258t;
        if (handler != null) {
            handler.removeMessages(13);
            this.f22258t.sendEmptyMessage(13);
        }
    }

    /* renamed from: V */
    private void m23612V() {
        Handler handler = this.f22258t;
        if (handler != null) {
            handler.removeMessages(6);
            this.f22258t.removeMessages(8);
            this.f22258t.removeMessages(7);
        }
    }

    /* renamed from: C */
    public boolean m23643C() {
        CameraFocusListener interfaceC3443f = this.f22222A;
        return (interfaceC3443f == null || !interfaceC3443f.mo10637r() || m23608R()) ? false : true;
    }

    @Override // com.oplus.camera.p172ui.preview.IFocusManagerProxy
    /* renamed from: D */
    public boolean mo23644D() {
        CameraFocusListener interfaceC3443f = this.f22222A;
        return interfaceC3443f != null && interfaceC3443f.mo10635p();
    }

    /* renamed from: E */
    public boolean m23645E() {
        CameraFocusListener interfaceC3443f = this.f22222A;
        return interfaceC3443f != null && interfaceC3443f.mo10636q();
    }

    @Override // com.oplus.camera.p172ui.preview.IFocusManagerProxy
    /* renamed from: F */
    public boolean mo23646F() {
        CameraFocusListener interfaceC3443f = this.f22222A;
        return interfaceC3443f != null && interfaceC3443f.mo10637r() && this.f22222A.mo10636q() && this.f22222A.mo10614a(CameraUIInterface.KEY_SUPPORT_EXPOSURE_FOCUS_SEPARATE);
    }

    @Override // com.oplus.camera.p172ui.preview.IFocusManagerProxy
    /* renamed from: G */
    public boolean mo23647G() {
        CameraFocusListener interfaceC3443f = this.f22222A;
        return interfaceC3443f != null && interfaceC3443f.mo10614a(CameraUIInterface.KEY_XPAN_EXPOSURE);
    }

    @Override // com.oplus.camera.p172ui.preview.IFocusManagerProxy
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo23657a(float COUIBaseListPopupWindow_12) {
        m23627d(COUIBaseListPopupWindow_12);
    }

    @Override // com.oplus.camera.p172ui.preview.IFocusManagerProxy
    /* renamed from: OplusGLSurfaceView_13 */
    public void mo23694i(boolean z) {
        CameraLog.m12954a("FocusManager", "toggleAeAfLock, mbAEAFLocked: " + mo23706s());
        if (this.f22222A == null) {
            CameraLog.m12954a("FocusManager", "toggleAeAfLock, mCameraFocusListener is null.");
            return;
        }
        if (this.f22256r == null) {
            CameraLog.m12966e("FocusManager", "toggleAeAfLock, mFocusExposureContainer is null.");
            return;
        }
        if (mo23706s()) {
            m23684e(0);
            if (this.f22222A.mo10633n()) {
                CameraFocusListener interfaceC3443f = this.f22222A;
                if (interfaceC3443f != null) {
                    interfaceC3443f.mo10638s();
                    this.f22222A.mo10621c(false, true);
                }
                m23703p();
                if (this.f22240S) {
                    m23698k(false);
                }
                m23681d(0);
                return;
            }
            CameraFocusListener interfaceC3443f2 = this.f22222A;
            if (interfaceC3443f2 != null) {
                interfaceC3443f2.mo10621c(false, true);
            }
            m23703p();
            if (this.f22240S) {
                m23698k(false);
            }
            this.f22258t.sendEmptyMessage(1);
            return;
        }
        m23684e(2);
        RectF rectF = new RectF((this.f22234M - (this.f22256r.getExposureRectWidth() / 2)) / this.f22263y, (this.f22235N - (this.f22256r.getExposureRectWidth() / 2)) / this.f22264z, (this.f22234M + (this.f22256r.getExposureRectWidth() / 2)) / this.f22263y, (this.f22235N + (this.f22256r.getExposureRectWidth() / 2)) / this.f22264z);
        if (1 != this.f22262x && m23643C()) {
            this.f22222A.mo10639t();
        }
        if (m23643C() || m23645E()) {
            int OplusGLSurfaceView_13 = this.f22262x;
            if (OplusGLSurfaceView_13 == 3 || ((OplusGLSurfaceView_13 == 0 && z) || !m23643C())) {
                m23640n(true);
                m23688f(true);
                return;
            } else {
                m23618a(rectF, rectF);
                return;
            }
        }
        CameraLog.m12966e("FocusManager", "toggleAeAfLock, do nothing, lock AE/AF is unsupported.");
    }

    @Override // com.oplus.camera.p172ui.preview.IFocusManagerProxy
    /* renamed from: H */
    public void mo23648H() {
        this.f22246h = !this.f22246h;
        CameraFocusListener interfaceC3443f = this.f22222A;
        if (interfaceC3443f != null) {
            interfaceC3443f.mo10609a(this.f22246h, true);
        }
        FocusIndicatorRotateLayout c3451n = this.f22256r;
        if (c3451n != null) {
            c3451n.m23591a(mo23706s());
        }
        TrackFocusView c3432ac = this.f22254p;
        if (c3432ac != null) {
            c3432ac.setLockState(this.f22246h);
        }
        mo23652L();
    }

    /* renamed from: OplusGLSurfaceView_11 */
    private void m23640n(boolean z) {
        if (this.f22246h != z) {
            mo23648H();
        }
    }

    @Override // com.oplus.camera.p172ui.preview.IFocusManagerProxy
    /* renamed from: I */
    public boolean mo23649I() {
        return this.f22246h;
    }

    @Override // com.oplus.camera.p172ui.preview.IFocusManagerProxy
    /* renamed from: J */
    public boolean mo23650J() {
        return this.f22222A.mo10612a();
    }

    @Override // com.oplus.camera.p172ui.preview.IFocusManagerProxy
    /* renamed from: K */
    public boolean mo23651K() {
        return this.f22222A.mo10620b();
    }

    @Override // com.oplus.camera.p172ui.preview.IFocusManagerProxy
    /* renamed from: IntrinsicsJvm.kt_4 */
    public boolean mo23675b(int OplusGLSurfaceView_13, int i2) {
        return this.f22222A.mo10613a(OplusGLSurfaceView_13, i2);
    }

    @Override // com.oplus.camera.p172ui.preview.IFocusManagerProxy
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo23658a(float COUIBaseListPopupWindow_12, float f2, int OplusGLSurfaceView_13, int i2) {
        float f3 = OplusGLSurfaceView_13 / 2.0f;
        int i3 = this.f22263y;
        float f4 = i2 / 2.0f;
        int i4 = this.f22264z;
        RectF rectF = new RectF((COUIBaseListPopupWindow_12 - f3) / i3, (f2 - f4) / i4, (f3 + COUIBaseListPopupWindow_12) / i3, (f4 + f2) / i4);
        this.f22222A.mo10605a((int) COUIBaseListPopupWindow_12, (int) f2, rectF);
        this.f22222A.mo10611a(m23624b(rectF));
        CameraLog.m12959b("FocusManager", "setExposurePointInfo, x: " + COUIBaseListPopupWindow_12 + " y: " + f2 + "AE regions: " + rectF);
    }

    @Override // com.oplus.camera.p172ui.preview.IFocusManagerProxy
    /* renamed from: IntrinsicsJvm.kt_4 */
    public void mo23672b(float COUIBaseListPopupWindow_12, float f2, int OplusGLSurfaceView_13, int i2) {
        float f3 = OplusGLSurfaceView_13 / 2.0f;
        int i3 = this.f22263y;
        float f4 = i2 / 2.0f;
        int i4 = this.f22264z;
        RectF rectF = new RectF((COUIBaseListPopupWindow_12 - f3) / i3, (f2 - f4) / i4, (f3 + COUIBaseListPopupWindow_12) / i3, (f4 + f2) / i4);
        this.f22222A.mo10616b((int) COUIBaseListPopupWindow_12, (int) f2, rectF);
        this.f22222A.mo10619b(m23624b(rectF));
        m23681d(1);
        CameraLog.m12959b("FocusManager", "setFocalPointInfo, AF regions: " + rectF);
    }

    @Override // com.oplus.camera.p172ui.preview.IFocusManagerProxy
    /* renamed from: L */
    public void mo23652L() {
        if (this.f22258t != null) {
            m23612V();
            this.f22258t.sendEmptyMessageDelayed(7, 1000L);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m23671b(float COUIBaseListPopupWindow_12) {
        FocusIndicatorRotateLayout c3451n = this.f22256r;
        if (c3451n == null || c3451n.getVisibility() != 0) {
            return;
        }
        this.f22256r.m23599c(false);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m23665a(Rect rect, Rect rect2, Size size) {
        this.f22242U = rect;
        this.f22243V = rect2;
        this.f22244W = size;
        TrackFocusView c3432ac = this.f22254p;
        if (c3432ac != null) {
            c3432ac.m23021a(rect, rect2, size, new Size(this.f22263y, this.f22264z));
        }
    }

    /* compiled from: FocusManager.java */
    /* renamed from: com.oplus.camera.ui.preview.o$PlatformImplementations.kt_3 */
    private class PlatformImplementations.kt_3 extends Handler {
        public PlatformImplementations.kt_3(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            CameraLog.m12954a("FocusManager", "handleMessage, msg: " + message.what);
            boolean z = false;
            switch (message.what) {
                case 1:
                    FocusManager.this.m23699l();
                    FocusManager.this.f22222A.mo10625f();
                    FocusManager.this.f22222A.mo10627h();
                    break;
                case 2:
                    boolean z2 = FocusManager.this.f22259u != -1;
                    boolean z3 = FocusManager.this.f22253o != null && FocusManager.this.f22253o.m22150a();
                    if (FocusManager.this.f22255q != null && FocusManager.this.f22255q.m22193f()) {
                        z = true;
                    }
                    FocusIndicator interfaceC3450m = z3 ? FocusManager.this.f22253o : z ? FocusManager.this.f22255q : FocusManager.this.f22256r;
                    if (!FocusManager.this.f22240S && interfaceC3450m != null) {
                        interfaceC3450m.mo22148a(true, z2);
                        break;
                    }
                    break;
                case 5:
                    FocusManager.this.f22258t.removeMessages(5);
                    if (FocusManager.this.m23691h() && Util.m24169C()) {
                        FocusManager.this.f22258t.removeMessages(9);
                        FocusManager.this.f22258t.sendEmptyMessageDelayed(9, 100L);
                        break;
                    } else {
                        FocusManager.this.m23638m(false);
                        break;
                    }
                case 6:
                    if (!FocusManager.this.mo23706s()) {
                        if (FocusManager.this.f22254p != null && FocusManager.this.f22240S) {
                            FocusManager.this.m23698k(false);
                        }
                        if (!FocusManager.this.f22222A.mo10633n()) {
                            if (FocusManager.this.f22256r != null) {
                                if (!FocusManager.this.f22256r.m23605f()) {
                                    FocusManager.this.f22256r.m23603e();
                                }
                            }
                            if (FocusManager.this.f22258t != null) {
                                FocusManager.this.f22258t.sendEmptyMessage(1);
                            }
                            if (!FocusManager.this.f22222A.mo10632m()) {
                                FocusManager.this.m23681d(0);
                                if (FocusManager.this.f22258t == null || !FocusManager.this.f22258t.hasMessages(5)) {
                                    FocusManager.this.f22222A.mo10638s();
                                    break;
                                } else {
                                    FocusManager.this.f22258t.removeMessages(9);
                                    FocusManager.this.f22258t.removeMessages(5);
                                    FocusManager.this.m23638m(true);
                                    break;
                                }
                            }
                        }
                    }
                    break;
                case 7:
                    if (FocusManager.this.f22256r != null) {
                        FocusManager.this.f22256r.setAlpha(0.55f);
                    }
                    if (FocusManager.this.f22254p != null) {
                        FocusManager.this.f22254p.setAlpha(0.55f);
                    }
                    if (FocusManager.this.f22258t != null) {
                        FocusManager.this.f22258t.removeMessages(8);
                        FocusManager.this.f22258t.sendEmptyMessageDelayed(8, 1000L);
                        if (FocusManager.this.f22222A.mo10624e() && 1 != FocusManager.this.f22259u) {
                            FocusManager.this.f22258t.removeMessages(13);
                            FocusManager.this.f22258t.sendEmptyMessageDelayed(13, 1500L);
                            break;
                        }
                    }
                    break;
                case 8:
                    if (FocusManager.this.f22256r != null) {
                        FocusManager.this.f22256r.m23601d(false);
                    }
                    FocusManager.this.f22257s = false;
                    if (FocusManager.this.f22258t != null && !FocusManager.this.m23711x()) {
                        FocusManager.this.f22258t.sendEmptyMessageDelayed(6, 3000L);
                        break;
                    }
                    break;
                case 9:
                    FocusManager.this.m23638m(true);
                    break;
                case 10:
                    FocusManager.this.m23607Q();
                    break;
                case 12:
                    FocusManager.this.m23681d(3);
                    FocusManager c3452o = FocusManager.this;
                    c3452o.m23616a(c3452o.f22224C, FocusManager.this.f22225D, true, FocusManager.this.f22228G, false);
                    CameraLog.m12959b("FocusManager", "handleMessage, check AF converged");
                    break;
                case 13:
                    FocusManager.this.m23687f(8);
                    break;
            }
        }
    }

    /* renamed from: OplusGLSurfaceView_15 */
    public void m23696j(boolean z) {
        this.f22239R = z;
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    public void m23687f(final int OplusGLSurfaceView_13) {
        Activity activity = this.f22252n;
        if (activity != null) {
            activity.runOnUiThread(new Runnable() { // from class: com.oplus.camera.ui.preview.-$$Lambda$o$Xz2LrB2YwV-TOn8-lQBADHN_NYI
                @Override // java.lang.Runnable
                public final void run() {
                    this.COUIBaseListPopupWindow_12$0.m23631g(OplusGLSurfaceView_13);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: COUIBaseListPopupWindow_11 */
    public /* synthetic */ void m23631g(int OplusGLSurfaceView_13) {
        FocusIndicatorRotateLayout c3451n = this.f22256r;
        if (c3451n != null) {
            c3451n.setVisibility(OplusGLSurfaceView_13);
        }
    }

    /* renamed from: M */
    public boolean m23653M() {
        return this.f22251m;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m23677c(float COUIBaseListPopupWindow_12) {
        TrackFocusView c3432ac = this.f22254p;
        if (c3432ac != null) {
            c3432ac.setZoomValue(COUIBaseListPopupWindow_12);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m23668a(int[] iArr) {
        Activity activity = this.f22252n;
        if (activity != null) {
            activity.runOnUiThread(new Runnable() { // from class: com.oplus.camera.ui.preview.o.3
                @Override // java.lang.Runnable
                public void run() {
                    TrackFocusView c3432ac = FocusManager.this.f22254p;
                    if (c3432ac != null) {
                        if (!FocusManager.this.f22239R || c3432ac.getVisibility() != 0) {
                            if (FocusManager.this.f22239R || 4 != c3432ac.getVisibility()) {
                                return;
                            }
                            c3432ac.setVisibility(0);
                            return;
                        }
                        c3432ac.setVisibility(4);
                    }
                }
            });
            TrackFocusView c3432ac = this.f22254p;
            if (c3432ac != null) {
                c3432ac.m23023a(iArr);
            }
        }
    }

    /* renamed from: OplusGLSurfaceView_5 */
    public void m23698k(boolean z) {
        CameraLog.m12959b("FocusManager", "stopTracking, needRepeating: " + z);
        TrackFocusView c3432ac = this.f22254p;
        if (c3432ac != null) {
            c3432ac.m23024b();
        }
        this.f22240S = false;
        this.f22222A.mo10610a(new int[]{0, 0, 0, 0}, z);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m23666a(RectF rectF) {
        this.f22240S = true;
        TrackFocusView c3432ac = this.f22254p;
        if (c3432ac != null) {
            c3432ac.m23025c();
            this.f22254p.m23022a(rectF);
            this.f22222A.mo10610a(new int[]{0, 0, 0, 0}, false);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m23664a(Rect rect) {
        if (this.f22222A != null) {
            CameraLog.m12959b("FocusManager", "startTracking, rect: " + rect);
            this.f22222A.mo10610a(new int[]{rect.left, rect.top, rect.right, rect.bottom}, true);
            TrackFocusView c3432ac = this.f22254p;
            if (c3432ac != null) {
                c3432ac.m23032j();
            }
        }
    }

    /* renamed from: N */
    public int m23654N() {
        return this.f22259u;
    }

    /* renamed from: O */
    public boolean m23655O() {
        return this.f22240S;
    }
}

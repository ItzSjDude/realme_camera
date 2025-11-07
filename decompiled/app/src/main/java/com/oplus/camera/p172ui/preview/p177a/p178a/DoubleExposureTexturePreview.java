package com.oplus.camera.p172ui.preview.p177a.p178a;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.os.ConditionVariable;
import android.os.Handler;
import android.os.HandlerThread;
import android.renderscript.Matrix4f;
import com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection;
import com.oplus.camera.CameraLog;
import com.oplus.camera.R;
import com.oplus.camera.algovisualization.AlgoListProcessor;
import com.oplus.camera.aps.util.CameraApsResult;
import com.oplus.camera.doubleexposure.ClipVideoInfo;
import com.oplus.camera.doubleexposure.DecodeVideoRequest;
import com.oplus.camera.doubleexposure.DoubleExposureManager;
import com.oplus.camera.doubleexposure.VideoClipManager;
import com.oplus.camera.doubleexposure.BlurViewHideCallback;
import com.oplus.camera.p146gl.BasicTexture;
import com.oplus.camera.p146gl.ExtTexture;
import com.oplus.camera.p146gl.RawTexture;
import com.oplus.camera.p146gl.GLCanvas;
import com.oplus.camera.p172ui.preview.p177a.TexturePreview;
import com.oplus.camera.p172ui.preview.p177a.TexturePreviewRequest;
import com.oplus.camera.util.Util;

/* compiled from: DoubleExposureTexturePreview.java */
/* renamed from: com.oplus.camera.ui.preview.PlatformImplementations.kt_3.PlatformImplementations.kt_3.PlatformImplementations.kt_3 */
/* loaded from: classes2.dex */
public class DoubleExposureTexturePreview extends TexturePreview implements TexturePreviewRequest.PlatformImplementations.kt_3 {

    /* renamed from: PlatformImplementations.kt_3 */
    public static String f20895a = "0ms";

    /* renamed from: A */
    private boolean f20896A;

    /* renamed from: B */
    private float[] f20897B;

    /* renamed from: C */
    private Matrix4f f20898C;

    /* renamed from: D */
    private ClipVideoInfo f20899D;

    /* renamed from: E */
    private boolean f20900E;

    /* renamed from: F */
    private boolean f20901F;

    /* renamed from: G */
    private int f20902G;

    /* renamed from: H */
    private ConditionVariable f20903H;

    /* renamed from: I */
    private final Object f20904I;

    /* renamed from: J */
    private VideoClipManager.PlatformImplementations.kt_3 f20905J;

    /* renamed from: K */
    private BlurViewHideCallback f20906K;

    /* renamed from: L */
    private boolean f20907L;

    /* renamed from: M */
    private boolean f20908M;

    /* renamed from: N */
    private boolean f20909N;

    /* renamed from: O */
    private boolean f20910O;

    /* renamed from: P */
    private float[] f20911P;

    /* renamed from: Q */
    private long f20912Q;

    /* renamed from: R */
    private long f20913R;

    /* renamed from: S */
    private int f20914S;

    /* renamed from: T */
    private VideoInfo f20915T;

    /* renamed from: U */
    private FirstDecodeFrameArriveListener f20916U;

    /* renamed from: V */
    private boolean f20917V;

    /* renamed from: W */
    private boolean f20918W;

    /* renamed from: X */
    private Runnable f20919X;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private Context f20920b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private TexturePreviewRequest f20921c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private int f20922d;

    /* renamed from: OplusGLSurfaceView_5 */
    private int f20923k;

    /* renamed from: OplusGLSurfaceView_14 */
    private RawTexture f20924l;

    /* renamed from: OplusGLSurfaceView_6 */
    private RawTexture f20925m;

    /* renamed from: OplusGLSurfaceView_11 */
    private RawTexture f20926n;

    /* renamed from: o */
    private RawTexture f20927o;

    /* renamed from: p */
    private RawTexture f20928p;

    /* renamed from: q */
    private RawTexture f20929q;

    /* renamed from: r */
    private RawTexture f20930r;

    /* renamed from: s */
    private ExtTexture f20931s;

    /* renamed from: t */
    private boolean f20932t;

    /* renamed from: u */
    private DoubleExposureManager f20933u;

    /* renamed from: v */
    private HandlerThread f20934v;

    /* renamed from: w */
    private Handler f20935w;

    /* renamed from: x */
    private VideoDecodeSync f20936x;

    /* renamed from: y */
    private SurfaceTexture f20937y;

    /* renamed from: z */
    private boolean f20938z;

    /* renamed from: PlatformImplementations.kt_3 */
    private int m22255a(int OplusGLSurfaceView_13, boolean z) {
        if (z) {
            if (OplusGLSurfaceView_13 != 0) {
                if (OplusGLSurfaceView_13 != 90) {
                    if (OplusGLSurfaceView_13 != 180) {
                        return 0;
                    }
                    return 270;
                }
                return 180;
            }
            return 90;
        }
        if (OplusGLSurfaceView_13 != 0) {
            if (OplusGLSurfaceView_13 != 90) {
                if (OplusGLSurfaceView_13 != 180) {
                    return 0;
                }
                return 90;
            }
            return 180;
        }
        return 270;
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    private boolean m22270e(int OplusGLSurfaceView_13) {
        return OplusGLSurfaceView_13 == 0 || OplusGLSurfaceView_13 == 4 || OplusGLSurfaceView_13 == 5 || OplusGLSurfaceView_13 == 6;
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.TexturePreview
    /* renamed from: PlatformImplementations.kt_3 */
    public boolean mo22282a() {
        return false;
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.TexturePreview
    /* renamed from: IntrinsicsJvm.kt_3 */
    public void mo22287c() {
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.TexturePreview
    /* renamed from: IntrinsicsJvm.kt_5 */
    public int mo22289d() {
        return 1024;
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.TexturePreview
    /* renamed from: COUIBaseListPopupWindow_10 */
    public boolean mo22293h() {
        return false;
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.TexturePreview
    /* renamed from: x */
    public void mo22299x() {
    }

    public DoubleExposureTexturePreview(Context context) {
        super(context);
        this.f20920b = null;
        this.f20921c = null;
        this.f20922d = 0;
        this.f20923k = 0;
        this.f20924l = null;
        this.f20925m = null;
        this.f20926n = null;
        this.f20927o = null;
        this.f20928p = null;
        this.f20929q = null;
        this.f20930r = null;
        this.f20931s = null;
        this.f20932t = false;
        this.f20933u = null;
        this.f20934v = null;
        this.f20935w = null;
        this.f20936x = null;
        this.f20937y = null;
        this.f20938z = false;
        this.f20896A = false;
        this.f20897B = new float[16];
        this.f20898C = new Matrix4f();
        this.f20899D = null;
        this.f20900E = false;
        this.f20901F = false;
        this.f20902G = 0;
        this.f20903H = new ConditionVariable();
        this.f20904I = new Object();
        this.f20905J = null;
        this.f20906K = null;
        this.f20907L = false;
        this.f20908M = false;
        this.f20909N = false;
        this.f20910O = false;
        this.f20911P = null;
        this.f20912Q = 0L;
        this.f20913R = 0L;
        this.f20914S = 0;
        this.f20915T = null;
        this.f20916U = null;
        this.f20917V = true;
        this.f20918W = false;
        this.f20919X = new Runnable() { // from class: com.oplus.camera.ui.preview.PlatformImplementations.kt_3.PlatformImplementations.kt_3.PlatformImplementations.kt_3.1
            @Override // java.lang.Runnable
            public void run() throws Throwable {
                if (DoubleExposureTexturePreview.this.f20933u == null) {
                    DoubleExposureTexturePreview c3393a = DoubleExposureTexturePreview.this;
                    c3393a.f20933u = new DoubleExposureManager(c3393a.f20920b);
                    int iM12910a = DoubleExposureTexturePreview.this.f20933u.m12910a();
                    DoubleExposureTexturePreview.this.f20933u.m12912a(DoubleExposureTexturePreview.this.f20921c.m22341J());
                    DoubleExposureTexturePreview.this.f20938z = true;
                    CameraLog.m12954a("DoubleExposureTexturePreview", "process, initResult: " + iM12910a);
                }
                if (DoubleExposureTexturePreview.this.f20936x != null) {
                    DoubleExposureTexturePreview.this.f20903H.open();
                }
                synchronized (DoubleExposureTexturePreview.this.f20904I) {
                    DoubleExposureTexturePreview.this.f20918W = DoubleExposureTexturePreview.this.f21543g;
                }
                DoubleExposureTexturePreview.this.f20910O = true;
            }
        };
        this.f20920b = context;
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.TexturePreview
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo22281a(TexturePreviewRequest c3397aa) {
        if (this.f20911P == null) {
            this.f20911P = new Matrix4f().getArray();
        }
        if (this.f20934v == null) {
            this.f20934v = new HandlerThread("decode video");
            this.f20934v.start();
        }
        if (this.f20935w == null) {
            this.f20935w = new Handler(this.f20934v.getLooper());
        }
        this.f20921c = c3397aa;
        this.f20921c.m22352a(this);
        Util.m24279a(this.f20919X);
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.TexturePreview
    /* renamed from: COUIBaseListPopupWindow_8 */
    public void mo22290e() {
        Handler handler = this.f20935w;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        RawTexture c2768s = this.f20928p;
        if (c2768s != null) {
            c2768s.mo13944o();
            this.f20928p = null;
        }
        m22253H();
        this.f20907L = false;
        this.f21544h.m14132a(new Runnable() { // from class: com.oplus.camera.ui.preview.PlatformImplementations.kt_3.PlatformImplementations.kt_3.PlatformImplementations.kt_3.2
            @Override // java.lang.Runnable
            public void run() {
                DoubleExposureTexturePreview.this.m22276q();
            }
        });
        this.f20910O = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: q */
    public void m22276q() {
        DoubleExposureManager c2685d = this.f20933u;
        if (c2685d == null || !this.f20938z) {
            return;
        }
        c2685d.m12914c();
        this.f20933u = null;
        this.f20938z = false;
        this.f20896A = false;
    }

    /* renamed from: r */
    private void m22277r() {
        HandlerThread handlerThread = this.f20934v;
        if (handlerThread != null) {
            handlerThread.quit();
            this.f20934v = null;
        }
        Handler handler = this.f20935w;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.f20935w = null;
        }
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.TexturePreview
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo22278a(int OplusGLSurfaceView_13, int i2) {
        super.mo22278a(OplusGLSurfaceView_13, i2);
        this.f20922d = OplusGLSurfaceView_13;
        this.f20923k = i2;
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.TexturePreview
    /* renamed from: COUIBaseListPopupWindow_12 */
    public RawTexture mo22291f() {
        return this.f20925m;
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.TexturePreview
    /* renamed from: COUIBaseListPopupWindow_11 */
    public RawTexture mo22292g() {
        return this.f20924l;
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.TexturePreview
    /* renamed from: OplusGLSurfaceView_13 */
    public void mo22294i() {
        this.f20925m = new RawTexture(this.f20922d, this.f20923k, true);
        this.f20924l = new RawTexture(this.f20923k, this.f20922d, true);
        this.f20932t = true;
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.TexturePreview
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo22280a(GLCanvas interfaceC2757h) {
        RawTexture c2768s = this.f20925m;
        if (c2768s != null && !c2768s.m13943n()) {
            this.f20925m.m14193c(interfaceC2757h);
            CameraLog.m12954a("DoubleExposureTexturePreview", "prepareTextures, mInputTexture.getId: " + this.f20925m.m13934e());
        }
        RawTexture c2768s2 = this.f20924l;
        if (c2768s2 != null && !c2768s2.m13943n()) {
            this.f20924l.m14193c(interfaceC2757h);
            CameraLog.m12954a("DoubleExposureTexturePreview", "prepareTextures, mOutputTexture.getId: " + this.f20924l.m13934e());
        }
        RawTexture c2768s3 = this.f20926n;
        if (c2768s3 == null || c2768s3.m13943n()) {
            return;
        }
        this.f20926n.m14193c(interfaceC2757h);
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.TexturePreview
    /* renamed from: OplusGLSurfaceView_15 */
    public void mo22295j() {
        if (this.f20932t) {
            RawTexture c2768s = this.f20925m;
            if (c2768s != null) {
                c2768s.mo13944o();
                this.f20925m = null;
            }
            RawTexture c2768s2 = this.f20924l;
            if (c2768s2 != null) {
                c2768s2.mo13944o();
                this.f20924l = null;
            }
            this.f20932t = false;
        }
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.TexturePreview
    /* renamed from: PlatformImplementations.kt_3 */
    public boolean mo22283a(int OplusGLSurfaceView_13) {
        if (mo22673a_(OplusGLSurfaceView_13)) {
            return this.f20932t && this.f20921c != null;
        }
        CameraLog.m12954a("DoubleExposureTexturePreview", "canProcess, not support");
        return false;
    }

    /* renamed from: A */
    private void m22246A() {
        DoubleExposureManager c2685d;
        if (!this.f20938z || this.f20896A || (c2685d = this.f20933u) == null) {
            return;
        }
        c2685d.m12913b();
        this.f20896A = true;
    }

    /* renamed from: B */
    private void m22247B() {
        if (this.f20907L) {
            VideoClipManager.PlatformImplementations.kt_3 aVar = this.f20905J;
            if (aVar != null) {
                aVar.onVideoClipDone();
            }
            BlurViewHideCallback interfaceC2682a = this.f20906K;
            if (interfaceC2682a != null) {
                interfaceC2682a.mo12448a();
            }
            this.f20907L = false;
            this.f20905J = null;
            this.f20906K = null;
        }
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.TexturePreview
    /* renamed from: PlatformImplementations.kt_3 */
    public boolean mo22284a(TexturePreview.PlatformImplementations.kt_3 aVar) {
        int iM12911a;
        ClipVideoInfo c2683b;
        long jM11591a = AlgoListProcessor.m11591a();
        m22246A();
        m22247B();
        if (this.f20931s == null && this.f20900E && (c2683b = this.f20899D) != null) {
            m22258a(c2683b);
            this.f20900E = false;
        }
        if (this.f20936x != null && this.f20917V) {
            this.f20903H.open();
        }
        VideoDecodeSync runnableC3395c = this.f20936x;
        if (runnableC3395c != null && runnableC3395c.m22317f()) {
            this.f20936x.m22316e();
        }
        try {
            if (m22250E() && this.f20938z && this.f20931s != null) {
                m22248C();
                if (this.f20926n == null) {
                    this.f20926n = new RawTexture(this.f20931s.f13967a, this.f20931s.f13968b, true);
                    if (!this.f20926n.m13943n()) {
                        this.f20926n.m14193c(aVar.f21547a);
                    }
                }
                if (this.f20927o == null) {
                    this.f20927o = new RawTexture(this.f20931s.f13967a, this.f20931s.f13968b, true);
                    if (!this.f20927o.m13943n()) {
                        this.f20927o.m14193c(aVar.f21547a);
                    }
                }
                if (this.f20937y != null) {
                    this.f20937y.updateTexImage();
                    this.f20937y.getTransformMatrix(this.f20897B);
                }
                m22260a(aVar.f21547a, this.f20931s, this.f20926n, this.f20897B);
                if (this.f20901F) {
                    this.f20930r = m22261a(aVar.f21547a, this.f20926n, this.f20927o, this.f20898C.getArray(), m22254I()) ? this.f20927o : this.f20926n;
                    aVar.f21552f = true;
                    aVar.f21550d = this.f20930r;
                    this.f20929q = this.f20930r;
                    this.f20928p = null;
                    this.f20907L = true;
                    f20895a = AlgoListProcessor.m11592a(jM11591a, AlgoListProcessor.m11591a());
                    return true;
                }
                CameraApsResult cameraApsResult = aVar.f21551e;
                synchronized (this.f20904I) {
                    iM12911a = this.f20933u.m12911a(this.f20926n.m13934e(), this.f20926n.f13967a, this.f20926n.f13968b, false, this.f20936x.m22314c(), this.f20899D.m12903g(), cameraApsResult, this.f20924l.m13934e(), m22255a(this.f20902G, this.f20918W), this.f20918W);
                    if (this.f20910O) {
                        this.f20910O = false;
                        iM12911a = this.f20933u.m12911a(this.f20926n.m13934e(), this.f20926n.f13967a, this.f20926n.f13968b, false, this.f20936x.m22314c(), this.f20899D.m12903g(), cameraApsResult, this.f20924l.m13934e(), m22255a(this.f20902G, this.f20918W), this.f20918W);
                        CameraLog.m12954a("DoubleExposureTexturePreview", "process, drop frame");
                    }
                }
                if (!m22270e(iM12911a)) {
                    CameraLog.m12954a("DoubleExposureTexturePreview", "process, result: " + iM12911a);
                    return false;
                }
                m22272f(iM12911a);
                this.f20907L = true;
                this.f20928p = this.f20924l;
                this.f20929q = null;
                this.f20917V = true;
                f20895a = AlgoListProcessor.m11592a(jM11591a, AlgoListProcessor.m11591a());
                return true;
            }
            if (this.f20908M) {
                if (this.f20928p == null && this.f20929q == null) {
                    return false;
                }
                if (this.f20928p != null) {
                    this.f20924l = this.f20928p;
                    CameraLog.m12954a("DoubleExposureTexturePreview", "draw cache");
                } else {
                    this.f20930r = this.f20929q;
                    aVar.f21552f = true;
                    aVar.f21550d = this.f20930r;
                    CameraLog.m12954a("DoubleExposureTexturePreview", "draw video cache");
                }
                f20895a = AlgoListProcessor.m11592a(jM11591a, AlgoListProcessor.m11591a());
                return true;
            }
            if (m22251F()) {
                CameraLog.m12954a("DoubleExposureTexturePreview", "process, decoding not ready");
            }
            return false;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    /* renamed from: C */
    private void m22248C() {
        RawTexture c2768s = this.f20926n;
        if (c2768s != null && (c2768s.mo13935f() != this.f20931s.mo13935f() || this.f20926n.mo13936g() != this.f20931s.mo13936g())) {
            this.f20926n.mo13944o();
            this.f20926n = null;
        }
        RawTexture c2768s2 = this.f20927o;
        if (c2768s2 != null) {
            if (c2768s2.mo13935f() == this.f20931s.mo13935f() && this.f20927o.mo13936g() == this.f20931s.mo13936g()) {
                return;
            }
            this.f20927o.mo13944o();
            this.f20927o = null;
        }
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    private void m22272f(int OplusGLSurfaceView_13) {
        if (this.f20909N) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (OplusGLSurfaceView_13 == 5) {
                if (jCurrentTimeMillis - this.f20912Q <= AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS) {
                    this.f21545i.mo22928a(R.string.mode_double_exposure_move_closer, 0, true, false, false, false, false, true, 1000);
                }
                this.f20912Q = jCurrentTimeMillis;
            } else if (OplusGLSurfaceView_13 == 4) {
                if (this.f20914S != 4) {
                    this.f20913R = jCurrentTimeMillis;
                }
                if (jCurrentTimeMillis - this.f20913R >= AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS) {
                    this.f21545i.mo22928a(R.string.camera_double_exposure_nobody_hint, 0, true, false, false, false, false, true, 1000);
                }
            }
            this.f20914S = OplusGLSurfaceView_13;
        }
    }

    /* renamed from: D */
    private void m22249D() {
        this.f21545i.mo22927a(R.string.mode_double_exposure_move_closer);
        this.f21545i.mo22927a(R.string.camera_double_exposure_nobody_hint);
    }

    /* renamed from: E */
    private boolean m22250E() {
        VideoDecodeSync runnableC3395c = this.f20936x;
        return runnableC3395c != null && runnableC3395c.m22320i();
    }

    /* renamed from: F */
    private boolean m22251F() {
        VideoDecodeSync runnableC3395c = this.f20936x;
        return runnableC3395c != null && runnableC3395c.m22321j();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m22260a(GLCanvas interfaceC2757h, ExtTexture c2756g, RawTexture c2768s, float[] fArr) {
        if (c2768s == null) {
            return;
        }
        int iF = c2768s.mo13935f();
        int iG = c2768s.mo13936g();
        interfaceC2757h.mo13975a(c2768s);
        interfaceC2757h.mo13959a(0.0f, iG);
        interfaceC2757h.mo13960a(1.0f, -1.0f, 1.0f);
        interfaceC2757h.mo13973a(c2756g, fArr, 0, 0, iF, iG);
        interfaceC2757h.mo13987h();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private boolean m22261a(GLCanvas interfaceC2757h, BasicTexture abstractC2752c, RawTexture c2768s, float[] fArr, VideoInfo c3396d) {
        int iF = c2768s.mo13935f();
        int iG = c2768s.mo13936g();
        int iM22327c = c3396d.m22327c();
        if (!((c3396d.m22323a() > c3396d.m22325b() && c3396d.m22327c() % 180 == 0) || (c3396d.m22323a() < c3396d.m22325b() && c3396d.m22327c() % 180 != 0))) {
            return false;
        }
        interfaceC2757h.mo13975a(c2768s);
        ClipVideoInfo c2683b = this.f20899D;
        int OplusGLSurfaceView_13 = 90;
        if (c2683b != null && !c2683b.m12903g() && iM22327c == 90) {
            OplusGLSurfaceView_13 = 270;
        }
        m22259a(interfaceC2757h, iF, iG, OplusGLSurfaceView_13);
        interfaceC2757h.mo13973a(abstractC2752c, fArr, 0, 0, iG, iF);
        interfaceC2757h.mo13987h();
        return true;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m22259a(GLCanvas interfaceC2757h, int OplusGLSurfaceView_13, int i2, int i3) {
        interfaceC2757h.mo13959a(OplusGLSurfaceView_13 / 2, i2 / 2);
        interfaceC2757h.mo13961a(i3, 0.0f, 0.0f, 1.0f);
        if (i3 % 180 != 0) {
            interfaceC2757h.mo13959a(-r5, -r4);
        } else {
            interfaceC2757h.mo13959a(-r4, -r5);
        }
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.TexturePreview
    /* renamed from: IntrinsicsJvm.kt_4 */
    public void mo22285b() {
        m22277r();
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.TexturePreview
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo22279a(DecodeVideoRequest c2684c) {
        ClipVideoInfo c2683bM12905a = c2684c.m12905a();
        CameraLog.m12954a("DoubleExposureTexturePreview", "onVideoLoadedDone, clipVideoInfo: " + c2683bM12905a);
        this.f20909N = false;
        m22249D();
        if (this.f20899D != null && c2683bM12905a.m12899c().equals(this.f20899D.m12899c())) {
            this.f20900E = true;
            this.f20901F = c2684c.m12906b();
        } else {
            if (this.f20899D != null) {
                this.f20908M = true;
            }
            m22253H();
            this.f20899D = c2683bM12905a;
            this.f20900E = true;
            this.f20901F = c2684c.m12906b();
        }
        if (c2684c.m12907c() != null) {
            this.f20905J = c2684c.m12907c();
            this.f20907L = false;
        }
        if (c2684c.m12908d() != null) {
            this.f20906K = c2684c.m12908d();
        }
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.TexturePreview
    /* renamed from: u */
    public void mo22296u() {
        m22252G();
        m22253H();
    }

    /* renamed from: G */
    private void m22252G() {
        RawTexture c2768s = this.f20928p;
        if (c2768s != null) {
            c2768s.mo13944o();
            this.f20928p = null;
        }
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.TexturePreview
    /* renamed from: v */
    public void mo22297v() {
        VideoDecodeSync runnableC3395c = this.f20936x;
        if (runnableC3395c != null) {
            runnableC3395c.m22319h();
        }
        this.f20909N = true;
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.TexturePreview
    /* renamed from: w */
    public void mo22298w() {
        synchronized (this.f20904I) {
            this.f20910O = true;
        }
        VideoDecodeSync runnableC3395c = this.f20936x;
        if (runnableC3395c != null) {
            runnableC3395c.m22315d();
        }
        m22252G();
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.TexturePreviewRequest.PlatformImplementations.kt_3
    /* renamed from: IntrinsicsJvm.kt_3 */
    public void mo22288c(int OplusGLSurfaceView_13) {
        DoubleExposureManager c2685d;
        CameraLog.m12954a("DoubleExposureTexturePreview", "onDoubleExposureTypeChanged, newType:" + OplusGLSurfaceView_13);
        if (!this.f20938z || (c2685d = this.f20933u) == null) {
            return;
        }
        c2685d.m12912a(OplusGLSurfaceView_13);
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.TexturePreview
    /* renamed from: IntrinsicsJvm.kt_4 */
    public void mo22286b(int OplusGLSurfaceView_13) {
        synchronized (this.f20904I) {
            this.f20902G = OplusGLSurfaceView_13;
        }
    }

    /* renamed from: H */
    private void m22253H() {
        if (this.f20936x != null) {
            CameraLog.m12954a("DoubleExposureTexturePreview", "stopDecode");
            this.f20936x.m22318g();
            Handler handler = this.f20935w;
            if (handler != null) {
                handler.removeCallbacksAndMessages(null);
            }
            this.f20936x.m22322k();
            this.f20936x = null;
            synchronized (this.f20904I) {
                if (this.f20931s != null) {
                    this.f20931s.mo13944o();
                    this.f20931s = null;
                }
            }
        }
        this.f20900E = false;
        this.f20901F = false;
        this.f20899D = null;
        this.f20910O = true;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m22258a(ClipVideoInfo c2683b) {
        if (this.f20916U == null) {
            this.f20916U = new FirstDecodeFrameArriveListener() { // from class: com.oplus.camera.ui.preview.PlatformImplementations.kt_3.PlatformImplementations.kt_3.PlatformImplementations.kt_3.3
                @Override // com.oplus.camera.p172ui.preview.p177a.p178a.FirstDecodeFrameArriveListener
                /* renamed from: PlatformImplementations.kt_3 */
                public void mo22300a() {
                    if (DoubleExposureTexturePreview.this.f20908M) {
                        DoubleExposureTexturePreview.this.f20908M = false;
                    }
                }

                @Override // com.oplus.camera.p172ui.preview.p177a.p178a.FirstDecodeFrameArriveListener
                /* renamed from: IntrinsicsJvm.kt_4 */
                public void mo22301b() {
                    DoubleExposureTexturePreview.this.mo22296u();
                }
            };
        }
        if (this.f20936x == null) {
            this.f20931s = new ExtTexture(36197);
            this.f20937y = new SurfaceTexture(this.f20931s.m13934e());
            this.f20936x = new VideoDecodeSync(c2683b, this.f20937y);
            this.f20936x.m22312a(this.f20904I);
            this.f20936x.m22310a(this.f20903H);
            this.f20936x.m22311a(this.f20916U);
            this.f20931s.m13925a(this.f20936x.m22309a(), this.f20936x.m22313b());
            this.f20935w.post(this.f20936x);
        }
    }

    /* renamed from: I */
    private VideoInfo m22254I() {
        if (this.f20915T == null) {
            this.f20915T = new VideoInfo();
        }
        VideoDecodeSync runnableC3395c = this.f20936x;
        if (runnableC3395c == null) {
            this.f20915T.m22324a(0);
            this.f20915T.m22326b(0);
            this.f20915T.m22328c(0);
        } else {
            this.f20915T.m22324a(runnableC3395c.m22309a());
            this.f20915T.m22326b(this.f20936x.m22313b());
            this.f20915T.m22328c(this.f20936x.m22314c());
        }
        return this.f20915T;
    }
}

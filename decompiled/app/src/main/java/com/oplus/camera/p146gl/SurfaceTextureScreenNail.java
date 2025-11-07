package com.oplus.camera.p146gl;

import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.hardware.camera2.CaptureResult;
import android.media.Image;
import android.opengl.GLES20;
import android.opengl.Matrix;
import android.os.Handler;
import android.util.Size;
import com.oplus.camera.CameraLog;
import com.oplus.camera.CameraConstant;
import com.oplus.camera.aps.config.CameraConfig;
import com.oplus.camera.aps.config.ConfigDataBase;
import com.oplus.camera.aps.util.AlgoSwitchConfig;
import com.oplus.camera.aps.util.CameraApsResult;
import com.oplus.camera.jni.PreviewShow;
import com.oplus.camera.p146gl.p148b.OesDrawerEngine;
import com.oplus.camera.p146gl.p148b.SubSurfacePositionContainer;
import com.oplus.camera.p172ui.menu.levelcontrol.GLProducerRender;
import com.oplus.camera.p172ui.preview.CameraScreenNail;
import com.oplus.camera.p172ui.preview.PreviewAnimManager;
import com.oplus.camera.p172ui.preview.SatCrossAnimManager;
import com.oplus.camera.p172ui.preview.p177a.PreviewEffectProcess;
import com.oplus.camera.perf.FluencyPerformance;
import com.oplus.camera.screen.out.OutPresentation;
import com.oplus.camera.statistics.model.PerformanceMsgData;
import com.oplus.camera.util.Util;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* compiled from: SurfaceTextureScreenNail.java */
/* renamed from: com.oplus.camera.gl.t */
/* loaded from: classes2.dex */
public abstract class SurfaceTextureScreenNail implements SurfaceTexture.OnFrameAvailableListener {

    /* renamed from: af */
    private int f14222af;

    /* renamed from: w */
    protected int f14243w;

    /* renamed from: x */
    protected int f14244x;

    /* renamed from: PlatformImplementations.kt_3 */
    public static final Integer f14185a = 0;

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static final Integer f14187b = 1;

    /* renamed from: COUIBaseListPopupWindow_11 */
    protected static final float[] f14188g = {-1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f};

    /* renamed from: COUIBaseListPopupWindow_10 */
    protected static final float[] f14189h = {1.0f, 0.0f, 0.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 1.0f};

    /* renamed from: OplusGLSurfaceView_13 */
    protected static final float[] f14190i = {0.0f, 1.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f};

    /* renamed from: ai */
    private static PreviewAnimManager f14186ai = new PreviewAnimManager(0.0f, 1.0f);

    /* renamed from: IntrinsicsJvm.kt_3 */
    protected boolean f14226c = false;

    /* renamed from: IntrinsicsJvm.kt_5 */
    protected boolean f14227d = false;

    /* renamed from: COUIBaseListPopupWindow_8 */
    protected boolean f14228e = false;

    /* renamed from: COUIBaseListPopupWindow_12 */
    protected boolean f14229f = false;

    /* renamed from: OplusGLSurfaceView_15 */
    protected List<PlatformImplementations.kt_3> f14230j = new ArrayList();

    /* renamed from: OplusGLSurfaceView_5 */
    protected final Object f14231k = new Object();

    /* renamed from: OplusGLSurfaceView_14 */
    protected List<ExtTexture> f14232l = new ArrayList();

    /* renamed from: OplusGLSurfaceView_6 */
    protected RawTexture f14233m = null;

    /* renamed from: OplusGLSurfaceView_11 */
    protected NoMoireThumbGenerator f14234n = null;

    /* renamed from: o */
    protected TextureRotateProcessor f14235o = null;

    /* renamed from: p */
    protected Handler f14236p = new Handler();

    /* renamed from: q */
    protected CameraScreenNail.IntrinsicsJvm.kt_3 f14237q = null;

    /* renamed from: r */
    protected CameraScreenNail.IntrinsicsJvm.kt_4 f14238r = null;

    /* renamed from: s */
    protected final Object f14239s = new Object();

    /* renamed from: t */
    protected HashMap<String, IntrinsicsJvm.kt_4> f14240t = new HashMap<>();

    /* renamed from: u */
    protected PreviewEffectProcess f14241u = null;

    /* renamed from: v */
    protected GLRootView f14242v = null;

    /* renamed from: y */
    protected boolean f14245y = false;

    /* renamed from: z */
    protected boolean f14246z = false;

    /* renamed from: A */
    protected boolean f14191A = false;

    /* renamed from: B */
    protected Map<Integer, IntrinsicsJvm.kt_3> f14192B = new HashMap();

    /* renamed from: C */
    protected long f14193C = 0;

    /* renamed from: D */
    protected int f14194D = 0;

    /* renamed from: E */
    protected boolean f14195E = false;

    /* renamed from: F */
    protected float[] f14196F = new float[16];

    /* renamed from: G */
    protected int f14197G = 90;

    /* renamed from: H */
    protected boolean f14198H = false;

    /* renamed from: I */
    protected boolean f14199I = false;

    /* renamed from: J */
    protected Image f14200J = null;

    /* renamed from: K */
    protected Image f14201K = null;

    /* renamed from: L */
    protected OesDrawerEngine f14202L = null;

    /* renamed from: M */
    protected SubSurfacePositionContainer f14203M = new SubSurfacePositionContainer();

    /* renamed from: N */
    protected Set<Long> f14204N = new HashSet();

    /* renamed from: O */
    protected Set<Long> f14205O = new HashSet();

    /* renamed from: P */
    protected Set<Long> f14206P = new HashSet();

    /* renamed from: Q */
    protected long f14207Q = -1;

    /* renamed from: R */
    private SurfaceTexture f14208R = null;

    /* renamed from: S */
    private final float[] f14209S = new float[16];

    /* renamed from: T */
    private volatile boolean f14210T = false;

    /* renamed from: U */
    private volatile OutPresentation f14211U = null;

    /* renamed from: V */
    private final Lock f14212V = new ReentrantLock();

    /* renamed from: W */
    private boolean f14213W = false;

    /* renamed from: X */
    private float f14214X = 0.0f;

    /* renamed from: Y */
    private int f14215Y = 0;

    /* renamed from: Z */
    private int f14216Z = 0;

    /* renamed from: aa */
    private List<CameraApsResult> f14217aa = new ArrayList();

    /* renamed from: ab */
    private CameraApsResult f14218ab = null;

    /* renamed from: ac */
    private final Object f14219ac = new Object();

    /* renamed from: ad */
    private long f14220ad = 0;

    /* renamed from: ae */
    private float[] f14221ae = new float[16];

    /* renamed from: ag */
    private RawTexture f14223ag = null;

    /* renamed from: ah */
    private SatCrossAnimManager f14224ah = null;

    /* renamed from: aj */
    private volatile boolean f14225aj = false;

    /* compiled from: SurfaceTextureScreenNail.java */
    /* renamed from: com.oplus.camera.gl.t$IntrinsicsJvm.kt_4 */
    public static class IntrinsicsJvm.kt_4 {

        /* renamed from: IntrinsicsJvm.kt_3 */
        public static String f14252c = "capture_blur";

        /* renamed from: IntrinsicsJvm.kt_5 */
        public static String f14253d = "capture_thumbnail";

        /* renamed from: COUIBaseListPopupWindow_8 */
        public static String f14254e = "capture_exit";

        /* renamed from: COUIBaseListPopupWindow_12 */
        public static String f14255f = "capture_origin";

        /* renamed from: COUIBaseListPopupWindow_11 */
        public boolean f14256g = false;

        /* renamed from: COUIBaseListPopupWindow_10 */
        public boolean f14257h = false;

        /* renamed from: PlatformImplementations.kt_3 */
        public void mo11760a(Bitmap bitmap) {
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public void mo10414a(Integer num, Bitmap bitmap, long OplusGLSurfaceView_15, long j2, CaptureResult captureResult) {
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public boolean mo11761a() {
            return false;
        }

        /* renamed from: IntrinsicsJvm.kt_4 */
        public int mo11762b() {
            return 0;
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public abstract int mo14217a(int OplusGLSurfaceView_13, int i2, int i3, int i4);

    /* renamed from: OplusGLSurfaceView_13 */
    public abstract void mo14254i();

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public abstract void onFrameAvailable(SurfaceTexture surfaceTexture);

    /* renamed from: PlatformImplementations.kt_3 */
    public void m14219a(int OplusGLSurfaceView_13) {
        synchronized (this) {
            this.f14194D = OplusGLSurfaceView_13;
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m14230a(IntrinsicsJvm.kt_4 bVar, boolean z, boolean z2, String str) {
        synchronized (this) {
            CameraLog.m12954a("SurfaceTextureScreenNail", "setCapturePreviewCallback, cb: " + bVar + ", isEffect: " + z + ", needCheckTimestamp: " + z2 + ", type: " + str);
            bVar.f14256g = z2;
            bVar.f14257h = z;
            synchronized (this.f14239s) {
                this.f14240t.put(str, bVar);
            }
            if (IntrinsicsJvm.kt_4.f14252c.equals(str)) {
                m14219a(1);
                this.f14237q.mo23325Z();
            } else if (IntrinsicsJvm.kt_4.f14254e.equals(str)) {
                this.f14237q.mo23325Z();
            }
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m14234a(boolean z) {
        CameraLog.m12954a("SurfaceTextureScreenNail", "setCacheWhilePreview, state: " + z);
        synchronized (this.f14239s) {
            this.f14246z = z;
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m14240b(boolean z) {
        CameraLog.m12954a("SurfaceTextureScreenNail", "setCacheWhileCapture, state: " + z);
        synchronized (this.f14239s) {
            this.f14191A = z;
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m14221a(int OplusGLSurfaceView_13, long OplusGLSurfaceView_15, long j2) {
        CameraLog.m12954a("SurfaceTextureScreenNail", "setCapturePreviewTimestamp, which: " + OplusGLSurfaceView_13 + ", identity: " + OplusGLSurfaceView_15 + ", timestamp: " + j2);
        synchronized (this.f14239s) {
            this.f14192B.put(Integer.valueOf(OplusGLSurfaceView_13), new IntrinsicsJvm.kt_3(OplusGLSurfaceView_15, j2));
            if (f14187b.intValue() == OplusGLSurfaceView_13 && j2 != 0) {
                this.f14242v.m14132a(new Runnable() { // from class: com.oplus.camera.gl.t.1
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            SurfaceTextureScreenNail.this.m14213n();
                        } catch (Exception COUIBaseListPopupWindow_8) {
                            CameraLog.m12967f("SurfaceTextureScreenNail", "setCapturePreviewTimestamp, tryCapturePreview error: " + COUIBaseListPopupWindow_8.getMessage());
                        }
                    }
                });
            }
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public long m14237b(int OplusGLSurfaceView_13) {
        long OplusGLSurfaceView_15;
        synchronized (this.f14239s) {
            OplusGLSurfaceView_15 = this.f14192B.containsKey(Integer.valueOf(OplusGLSurfaceView_13)) ? this.f14192B.get(Integer.valueOf(OplusGLSurfaceView_13)).f14259b : 0L;
        }
        return OplusGLSurfaceView_15;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m14224a(long OplusGLSurfaceView_15, long j2, long j3, boolean z, boolean z2) {
        synchronized (this.f14239s) {
            this.f14192B.put(f14185a, new IntrinsicsJvm.kt_3(j2, j3));
            if (z) {
                this.f14206P.add(Long.valueOf(j2));
            }
            if (!Util.m24169C() && z2) {
                this.f14237q.mo23325Z();
            }
            this.f14204N.clear();
            this.f14207Q = -1L;
            this.f14205O.clear();
            CameraLog.m12959b("SurfaceTextureScreenNail", "onCaptureStarted, frameNumber: " + OplusGLSurfaceView_15 + ", identity: " + j2 + ", timestamp: " + j3 + ", quickJpeg: " + z + ", requestRender: " + z2);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m14222a(long OplusGLSurfaceView_15) {
        synchronized (this.f14239s) {
            this.f14191A = false;
            this.f14206P.remove(Long.valueOf(OplusGLSurfaceView_15));
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m14223a(long OplusGLSurfaceView_15, long j2) {
        synchronized (this.f14239s) {
            this.f14207Q = OplusGLSurfaceView_15;
            this.f14205O.add(Long.valueOf(j2));
        }
        CameraLog.m12959b("SurfaceTextureScreenNail", "notifyCacheFrame, frameNumber: " + OplusGLSurfaceView_15 + ", timestamp: " + j2);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public Set<Long> m14218a() {
        HashSet hashSet;
        synchronized (this.f14239s) {
            hashSet = new HashSet(this.f14205O);
        }
        return hashSet;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m14239b(long OplusGLSurfaceView_15, long j2) {
        synchronized (this.f14239s) {
            this.f14204N.add(Long.valueOf(j2));
        }
        CameraLog.m12959b("SurfaceTextureScreenNail", "notifySkipDrawFrame, frameNumber: " + OplusGLSurfaceView_15 + ", timestamp: " + j2);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public Set<Long> m14238b() {
        HashSet hashSet;
        synchronized (this.f14239s) {
            hashSet = new HashSet(this.f14204N);
        }
        return hashSet;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m14233a(String str) {
        synchronized (this.f14239s) {
            if (this.f14240t != null && this.f14240t.containsKey(str)) {
                this.f14240t.remove(str);
            }
        }
    }

    public SurfaceTextureScreenNail() {
        this.f14222af = 1;
        this.f14222af = CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_PREVIEW_BUFFER_CACHE_SUPPORT) ? 1 : 0;
        f14186ai.m23881a(false);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m14232a(PreviewEffectProcess interfaceC3423t) {
        this.f14241u = interfaceC3423t;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m14227a(GLRootView gLRootView) {
        this.f14242v = gLRootView;
        PreviewEffectProcess interfaceC3423t = this.f14241u;
        if (interfaceC3423t != null) {
            interfaceC3423t.mo22785a(this.f14242v);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m14243c(boolean z) {
        synchronized (this) {
            this.f14213W = z;
        }
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public void mo14245d(boolean z) {
        CameraLog.m12954a("SurfaceTextureScreenNail", "acquireSurfaceTexture");
        if (this.f14232l.isEmpty()) {
            this.f14232l.add(new ExtTexture(36197));
            this.f14232l.add(new ExtTexture(36197));
            this.f14232l.add(new ExtTexture(36197));
        }
        Iterator<ExtTexture> it = this.f14232l.iterator();
        while (it.hasNext()) {
            it.next().m13925a(this.f14243w, this.f14244x);
        }
        if (this.f14230j.isEmpty()) {
            this.f14230j.add(new PlatformImplementations.kt_3(this.f14243w, this.f14244x));
        }
        if (2 == AlgoSwitchConfig.getApsVersion()) {
            this.f14208R = new SurfaceTexture(this.f14232l.get(2).m13934e());
            this.f14208R.setOnFrameAvailableListener(this, this.f14236p);
            try {
                this.f14208R.detachFromGLContext();
            } catch (Exception COUIBaseListPopupWindow_8) {
                COUIBaseListPopupWindow_8.printStackTrace();
            }
        }
        PreviewEffectProcess interfaceC3423t = this.f14241u;
        if (interfaceC3423t != null) {
            interfaceC3423t.mo22786a(this);
            this.f14241u.mo22794a(true);
        }
        synchronized (this) {
            this.f14210T = true;
            m14249f(z);
        }
        this.f14193C = 0L;
        this.f14220ad = 3 == AlgoSwitchConfig.getApsVersion() ? PreviewShow.init() : 0L;
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public void m14247e(boolean z) {
        this.f14225aj = z;
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    public void m14249f(boolean z) {
        char c2 = (z || Util.m24325aN()) ? this.f14225aj ? (char) 4 : (char) 6 : (char) 7;
        synchronized (this.f14209S) {
            Matrix.setIdentityM(this.f14209S, 0);
            if ((c2 & 1) != 0) {
                Matrix.multiplyMM(this.f14209S, 0, this.f14209S, 0, f14188g, 0);
            }
            if ((c2 & 4) != 0) {
                Matrix.multiplyMM(this.f14209S, 0, this.f14209S, 0, f14190i, 0);
            }
            if ((c2 & 2) != 0) {
                Matrix.multiplyMM(this.f14209S, 0, f14189h, 0, this.f14209S, 0);
            }
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m14242c(int OplusGLSurfaceView_13) {
        synchronized (this) {
            this.f14197G = OplusGLSurfaceView_13;
        }
        CameraLog.m12954a("SurfaceTextureScreenNail", "setDisplayOrientation, orientation: " + OplusGLSurfaceView_13);
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public SurfaceTexture m14241c() {
        return this.f14208R;
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public void mo14244d() {
        CameraLog.m12954a("SurfaceTextureScreenNail", "releaseTextures");
        synchronized (this) {
            this.f14210T = false;
            while (!this.f14232l.isEmpty()) {
                this.f14232l.remove(0).mo13944o();
            }
            synchronized (this.f14239s) {
                while (!this.f14230j.isEmpty()) {
                    this.f14230j.remove(0).m14262c();
                }
            }
            if (this.f14241u != null) {
                this.f14241u.mo22794a(false);
                this.f14241u.mo22836h();
            }
            if (this.f14233m != null) {
                this.f14233m.mo13944o();
                this.f14233m = null;
            }
            synchronized (this.f14219ac) {
                for (CameraApsResult cameraApsResult : this.f14217aa) {
                    if (cameraApsResult != null) {
                        cameraApsResult.closeImageBuffer();
                        FluencyPerformance.m15136c(cameraApsResult.getTimestamp());
                    }
                }
                this.f14217aa.clear();
            }
            if (this.f14218ab != null) {
                this.f14218ab.closeImageBuffer();
                this.f14218ab = null;
            }
        }
        this.f14193C = 0L;
        long OplusGLSurfaceView_15 = this.f14220ad;
        if (0 != OplusGLSurfaceView_15) {
            PreviewShow.release(OplusGLSurfaceView_15);
            this.f14220ad = 0L;
        }
        PreviewEffectProcess interfaceC3423t = this.f14241u;
        if (interfaceC3423t != null) {
            interfaceC3423t.mo22786a((SurfaceTextureScreenNail) null);
        }
        this.f14223ag = null;
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public void m14246e() {
        Iterator<ExtTexture> it = this.f14232l.iterator();
        while (it.hasNext()) {
            it.next().m13925a(this.f14243w, this.f14244x);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void mo14220a(int OplusGLSurfaceView_13, int i2) {
        CameraLog.m12954a("SurfaceTextureScreenNail", "setSize, height: " + i2 + ", width: " + OplusGLSurfaceView_13);
        this.f14243w = OplusGLSurfaceView_13;
        this.f14244x = i2;
        synchronized (this.f14231k) {
            while (!this.f14230j.isEmpty()) {
                this.f14230j.remove(0).m14262c();
            }
            this.f14230j.add(new PlatformImplementations.kt_3(this.f14243w, this.f14244x));
        }
        PreviewEffectProcess interfaceC3423t = this.f14241u;
        if (interfaceC3423t != null) {
            interfaceC3423t.mo22810b(OplusGLSurfaceView_13, i2);
        }
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    public int m14248f() {
        return this.f14243w;
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    public int m14250g() {
        return this.f14244x;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m14228a(GLCanvas interfaceC2757h, int OplusGLSurfaceView_13, int i2, int i3, int i4, int i5, int i6) {
        synchronized (this) {
            if (this.f14210T && (AlgoSwitchConfig.getApsVersion() != 2 || this.f14208R != null)) {
                if (this.f14208R != null) {
                    this.f14208R.attachToGLContext(this.f14232l.get(0).m13934e());
                }
                interfaceC2757h.mo13965a(2);
                this.f14215Y = interfaceC2757h.mo13983d();
                this.f14216Z = interfaceC2757h.mo13984e();
                interfaceC2757h.mo13966a(i3, i4);
                interfaceC2757h.mo13959a(OplusGLSurfaceView_13 + (i3 / 2), i2 + (i4 / 2));
                if (this.f14213W) {
                    if (this.f14214X - 0.0f < 0.001f) {
                        this.f14214X = CameraConfig.getConfigFloatValue(ConfigDataBase.KEY_VIDEO_EIS_PREVIEW_SCALE);
                    }
                    interfaceC2757h.mo13960a(this.f14214X, -this.f14214X, 1.0f);
                } else {
                    interfaceC2757h.mo13960a(1.0f, -1.0f, 1.0f);
                }
                if (i5 == 1) {
                    interfaceC2757h.mo13960a(-1.0f, 1.0f, 1.0f);
                } else if (i5 == 2) {
                    interfaceC2757h.mo13960a(1.0f, -1.0f, 1.0f);
                }
                interfaceC2757h.mo13959a(-r4, -r6);
                if (this.f14208R != null) {
                    this.f14208R.updateTexImage();
                }
                m14235a(this.f14196F);
                this.f14241u.mo22797a(this.f14196F);
                if (this.f14202L == null || !this.f14198H) {
                    if (i6 == 0) {
                        if (!this.f14241u.mo22802a(interfaceC2757h, this.f14232l.get(0), OplusGLSurfaceView_13, i2, i3, i4, this.f14197G)) {
                            interfaceC2757h.mo13973a(this.f14232l.get(0), this.f14196F, OplusGLSurfaceView_13, i2, i3, i4);
                        }
                    } else if (1 == i6 && this.f14195E) {
                        if (this.f14223ag != null && this.f14223ag.m13943n() && this.f14241u.mo22804a(interfaceC2757h, this.f14232l.get(0), OplusGLSurfaceView_13, i2, i3, i4, this.f14194D, false)) {
                            interfaceC2757h.mo13973a(this.f14223ag, this.f14196F, OplusGLSurfaceView_13, i2, i3, i4);
                            this.f14223ag = null;
                        } else if (!this.f14241u.mo22804a(interfaceC2757h, this.f14232l.get(0), OplusGLSurfaceView_13, i2, i3, i4, this.f14194D, true)) {
                            interfaceC2757h.mo13973a(this.f14232l.get(0), this.f14196F, OplusGLSurfaceView_13, i2, i3, i4);
                        }
                    }
                } else if (!this.f14241u.mo22801a(interfaceC2757h, this.f14202L, this.f14202L.m13893f(), OplusGLSurfaceView_13, i2, i3, i4, this.f14197G)) {
                    Matrix.setIdentityM(this.f14221ae, 0);
                    interfaceC2757h.mo13973a(this.f14202L.m13893f(), this.f14221ae, OplusGLSurfaceView_13, i2, i3, i4);
                }
                interfaceC2757h.mo13966a(this.f14215Y, this.f14216Z);
                interfaceC2757h.mo13985f();
                if (this.f14208R != null) {
                    this.f14208R.detachFromGLContext();
                }
            }
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m14200a(GLCanvas interfaceC2757h, ExtTexture c2756g, CameraApsResult cameraApsResult) {
        PlatformImplementations.kt_3 aVar;
        boolean z = m14209b(cameraApsResult) || m14216q();
        if (this.f14195E) {
            if (z || m14215p()) {
                int iM14214o = m14214o();
                boolean z2 = this.f14230j.size() < Math.max(iM14214o, 2) || !this.f14241u.mo22799a(c2756g, this.f14230j.get(1).f14248a);
                if (!z) {
                    aVar = this.f14230j.get(0);
                } else if (!z2) {
                    aVar = this.f14230j.remove(1);
                } else {
                    aVar = c2756g.m13955s() != 0 ? new PlatformImplementations.kt_3(this.f14243w, this.f14244x) : new PlatformImplementations.kt_3(cameraApsResult, interfaceC2757h, new float[16]);
                }
                RawTexture c2768s = aVar.f14248a;
                if (z) {
                    this.f14223ag = c2768s;
                }
                if (c2768s != null) {
                    aVar.f14248a = this.f14241u.mo22775a(interfaceC2757h, c2756g, c2768s, z);
                    aVar.f14248a.m14188a(cameraApsResult != null ? cameraApsResult.getCaptureResult() : null);
                    if (z) {
                        this.f14223ag = aVar.f14248a;
                    }
                } else {
                    aVar.f14249b.addRef();
                    m14235a(aVar.f14251d);
                }
                if (z && this.f14230j.add(aVar) && this.f14230j.size() > iM14214o) {
                    this.f14230j.remove(1).m14262c();
                }
                m14213n();
            }
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private PlatformImplementations.kt_3 m14196a(Integer num) {
        PlatformImplementations.kt_3 aVar;
        if (!this.f14230j.isEmpty() && num != null) {
            int size = this.f14230j.size();
            long jM14237b = m14237b(num.intValue());
            CameraLog.m12962c("SurfaceTextureScreenNail", "peekMatchedPreview, which: " + num + ", timestamp: " + jM14237b + ", cache size: " + size);
            if (f14185a == num) {
                synchronized (this.f14239s) {
                    IntrinsicsJvm.kt_4 bVar = this.f14240t.get(IntrinsicsJvm.kt_4.f14253d);
                    PlatformImplementations.kt_3 aVar2 = this.f14230j.get(size - 1);
                    aVar = this.f14230j.get(0);
                    if (aVar2.m14261b() > aVar.m14261b()) {
                        aVar = aVar2;
                    }
                    if ((bVar == null || bVar.f14256g) && aVar.m14261b() < jM14237b) {
                        aVar = null;
                    }
                }
                return aVar;
            }
            for (int OplusGLSurfaceView_13 = 1; OplusGLSurfaceView_13 < size; OplusGLSurfaceView_13++) {
                if (this.f14230j.get(OplusGLSurfaceView_13).m14260a() == jM14237b) {
                    return this.f14230j.get(OplusGLSurfaceView_13);
                }
            }
            int i2 = 1;
            while (i2 < size - 1) {
                PlatformImplementations.kt_3 aVar3 = this.f14230j.get(i2);
                i2++;
                PlatformImplementations.kt_3 aVar4 = this.f14230j.get(i2);
                if (aVar3.m14260a() < jM14237b && jM14237b < aVar4.m14260a()) {
                    return jM14237b - aVar3.m14260a() < aVar4.m14260a() - jM14237b ? aVar3 : aVar4;
                }
            }
            if (size > 1 && this.f14230j.get(1).m14260a() >= jM14237b) {
                return this.f14230j.get(1);
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0022 A[Catch: all -> 0x01cd, TryCatch #2 {, blocks: (B:6:0x0006, B:8:0x000d, B:14:0x001b, B:16:0x0022, B:18:0x0046, B:20:0x004c, B:30:0x00f6, B:32:0x00fa, B:33:0x0103, B:38:0x0113, B:40:0x0119, B:42:0x0121, B:73:0x01c7, B:21:0x0070, B:22:0x007e, B:24:0x008a, B:26:0x0092, B:28:0x009e, B:29:0x00b8, B:43:0x0149, B:45:0x014d, B:46:0x0154, B:47:0x0156, B:51:0x0162, B:57:0x0172, B:58:0x0179, B:61:0x017c, B:63:0x0186, B:64:0x018d, B:67:0x0190, B:69:0x0194, B:71:0x019a, B:72:0x01bc, B:78:0x01cc, B:10:0x0011, B:12:0x0017, B:48:0x0157, B:50:0x0161, B:54:0x0165, B:55:0x016f), top: B:87:0x0006, outer: #0, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0149 A[Catch: all -> 0x01cd, TryCatch #2 {, blocks: (B:6:0x0006, B:8:0x000d, B:14:0x001b, B:16:0x0022, B:18:0x0046, B:20:0x004c, B:30:0x00f6, B:32:0x00fa, B:33:0x0103, B:38:0x0113, B:40:0x0119, B:42:0x0121, B:73:0x01c7, B:21:0x0070, B:22:0x007e, B:24:0x008a, B:26:0x0092, B:28:0x009e, B:29:0x00b8, B:43:0x0149, B:45:0x014d, B:46:0x0154, B:47:0x0156, B:51:0x0162, B:57:0x0172, B:58:0x0179, B:61:0x017c, B:63:0x0186, B:64:0x018d, B:67:0x0190, B:69:0x0194, B:71:0x019a, B:72:0x01bc, B:78:0x01cc, B:10:0x0011, B:12:0x0017, B:48:0x0157, B:50:0x0161, B:54:0x0165, B:55:0x016f), top: B:87:0x0006, outer: #0, inners: #1 }] */
    /* renamed from: OplusGLSurfaceView_11 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void m14213n() {
        /*
            Method dump skipped, instructions count: 467
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.p146gl.SurfaceTextureScreenNail.m14213n():void");
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private boolean m14210b(String str) {
        boolean z;
        synchronized (this.f14239s) {
            z = !this.f14230j.isEmpty() && this.f14240t.containsKey(str);
        }
        return z;
    }

    /* renamed from: COUIBaseListPopupWindow_10 */
    public boolean m14253h() {
        return this.f14245y;
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    public void m14251g(boolean z) {
        this.f14245y = z;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m14204a(String str, GLCanvas interfaceC2757h, RawTexture c2768s, Integer num, long OplusGLSurfaceView_15) throws IOException {
        HashMap<String, IntrinsicsJvm.kt_4> map;
        Integer num2;
        IntrinsicsJvm.kt_4 bVar;
        Bitmap bitmapM24409c;
        long j2;
        Bitmap bitmapM24409c2;
        CameraLog.m12955a("CameraCapturePerformance.capturePreview", "11ct_capturePreview", CameraConstant.f13119d.longValue());
        synchronized (this.f14239s) {
            map = this.f14240t;
        }
        IntrinsicsJvm.kt_4 bVar2 = map.get(str);
        long jCurrentTimeMillis = System.currentTimeMillis();
        int iH = c2768s.m13937h();
        int OplusGLSurfaceView_13 = c2768s.m13938i();
        if (IntrinsicsJvm.kt_4.f14252c.equals(str) || IntrinsicsJvm.kt_4.f14255f.equals(str)) {
            num2 = num;
            bVar = bVar2;
            bitmapM24409c = Util.m24409c(c2768s.m13934e(), iH, OplusGLSurfaceView_13);
            j2 = 0;
        } else if (IntrinsicsJvm.kt_4.f14253d.equals(str) && bVar2 != null && num != null) {
            if (f14185a == num) {
                this.f14234n.m14112a(iH, OplusGLSurfaceView_13, bVar2.mo11762b(), bVar2.mo11761a());
                bVar2.mo11760a(this.f14234n.m14110a(c2768s.m13934e(), iH, OplusGLSurfaceView_13));
            }
            if (this.f14197G == 270) {
                bitmapM24409c2 = Util.m24409c(this.f14235o.m14275a(c2768s), iH, OplusGLSurfaceView_13);
            } else {
                bitmapM24409c2 = Util.m24409c(c2768s.m13934e(), iH, OplusGLSurfaceView_13);
            }
            Bitmap bitmap = bitmapM24409c2;
            long j3 = bVar2.f14256g ? c2768s.m13939j() : 0L;
            m14221a(num.intValue(), 0L, 0L);
            num2 = num;
            bVar = bVar2;
            j2 = j3;
            bitmapM24409c = bitmap;
        } else {
            if (IntrinsicsJvm.kt_4.f14254e.equals(str) && bVar2 != null) {
                int i2 = iH / 20;
                int i3 = OplusGLSurfaceView_13 / 20;
                synchronized (this) {
                    if (this.f14202L != null && this.f14198H) {
                        float[] fArr = new float[16];
                        Matrix.setIdentityM(fArr, 0);
                        m14201a(interfaceC2757h, this.f14202L.m13893f(), c2768s, fArr);
                    }
                }
                Bitmap bitmapM24409c3 = Util.m24409c(mo14217a(c2768s.m13934e(), i2, i3, 10), i2, i3);
                mo14254i();
                num2 = num;
                bVar = bVar2;
                bVar2.mo10414a(num, bitmapM24409c3, 0L, 0L, null);
                m14251g(true);
                m14233a(IntrinsicsJvm.kt_4.f14254e);
            } else {
                num2 = num;
                bVar = bVar2;
                if (Util.m24390b()) {
                    Util.m24252a(c2768s.m13934e(), iH, OplusGLSurfaceView_13, "preview");
                }
            }
            j2 = 0;
            bitmapM24409c = null;
        }
        if (bVar != null && bitmapM24409c != null) {
            bVar.mo10414a(num, bitmapM24409c, OplusGLSurfaceView_15, j2, f14187b == num2 ? c2768s.m14194s() : null);
            if (!IntrinsicsJvm.kt_4.f14253d.equals(str) || !bVar.f14256g) {
                m14233a(str);
            }
        }
        CameraLog.m12954a("SurfaceTextureScreenNail", "capturePreview, type: " + str + ", rawTexture: " + c2768s + ", which: " + num2 + ", dump bitmap use time: " + (System.currentTimeMillis() - jCurrentTimeMillis));
        CameraLog.m12964d("CameraCapturePerformance.capturePreview", "11ct_capturePreview");
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m14226a(CameraApsResult cameraApsResult, boolean z) {
        if (this.f14193C == 0) {
            CameraLog.m12954a("SurfaceTextureScreenNail", "addImageBuffer, result: " + cameraApsResult);
        }
        synchronized (this.f14219ac) {
            if (z) {
                for (CameraApsResult cameraApsResult2 : this.f14217aa) {
                    if (cameraApsResult2 != null) {
                        cameraApsResult2.closeImageBuffer();
                        FluencyPerformance.m15136c(cameraApsResult2.getTimestamp());
                    }
                }
                this.f14217aa.clear();
                this.f14241u.mo22776a();
                if (this.f14217aa.size() > this.f14222af && !m14205a(this.f14217aa.get(0)) && this.f14217aa.get(0).getTimestamp() != m14237b(f14185a.intValue())) {
                    CameraApsResult cameraApsResultRemove = this.f14217aa.remove(0);
                    cameraApsResultRemove.closeImageBuffer();
                    FluencyPerformance.m15136c(cameraApsResultRemove.getTimestamp());
                    CameraLog.m12955a("addImageBuffer.dropPreviewFrame", "65pv_dropPreviewFrame", CameraConstant.f13119d.longValue());
                    CameraLog.m12964d("addImageBuffer.dropPreviewFrame", "65pv_dropPreviewFrame");
                    CameraLog.m12967f("SurfaceTextureScreenNail", "addImageBuffer, remove image: " + cameraApsResultRemove.getTimestamp());
                }
                this.f14217aa.add(cameraApsResult);
            } else {
                if (this.f14217aa.size() > this.f14222af) {
                    CameraApsResult cameraApsResultRemove2 = this.f14217aa.remove(0);
                    cameraApsResultRemove2.closeImageBuffer();
                    FluencyPerformance.m15136c(cameraApsResultRemove2.getTimestamp());
                    CameraLog.m12955a("addImageBuffer.dropPreviewFrame", "65pv_dropPreviewFrame", CameraConstant.f13119d.longValue());
                    CameraLog.m12964d("addImageBuffer.dropPreviewFrame", "65pv_dropPreviewFrame");
                    CameraLog.m12967f("SurfaceTextureScreenNail", "addImageBuffer, remove image: " + cameraApsResultRemove2.getTimestamp());
                }
                this.f14217aa.add(cameraApsResult);
            }
        }
        onFrameAvailable(null);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public boolean mo14236a(GLCanvas interfaceC2757h, GLProducerRender abstractC3285j, int OplusGLSurfaceView_13, int i2, int i3, int i4) {
        synchronized (this) {
            if (!this.f14232l.isEmpty() && !this.f14230j.isEmpty()) {
                PerformanceMsgData.getRealtimeFrameRate();
                if (!this.f14210T) {
                    return false;
                }
                if (abstractC3285j != null) {
                    m14203a(abstractC3285j);
                } else if (interfaceC2757h != null) {
                    CameraLog.m12955a("Surfacetexture.draw", "68pv_SurfacetextureDraw", CameraConstant.f13119d.longValue());
                    m14198a(interfaceC2757h, OplusGLSurfaceView_13, i2, i3, i4);
                    if (this.f14202L != null && this.f14198H) {
                        if (!m14211c(interfaceC2757h, OplusGLSurfaceView_13, i2, i3, i4)) {
                            return false;
                        }
                    } else {
                        m14212d(interfaceC2757h, OplusGLSurfaceView_13, i2, i3, i4);
                    }
                    m14208b(interfaceC2757h, OplusGLSurfaceView_13, i2, i3, i4);
                    CameraLog.m12964d("Surfacetexture.draw", "68pv_SurfacetextureDraw");
                }
                return true;
            }
            return false;
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m14198a(GLCanvas interfaceC2757h, int OplusGLSurfaceView_13, int i2, int i3, int i4) {
        SurfaceTexture surfaceTexture;
        SurfaceTexture surfaceTexture2 = this.f14208R;
        if (surfaceTexture2 != null) {
            surfaceTexture2.attachToGLContext(this.f14232l.get(0).m13934e());
        }
        interfaceC2757h.mo13965a(2);
        interfaceC2757h.mo13959a(OplusGLSurfaceView_13 + (i3 / 2), i2 + (i4 / 2));
        if (this.f14213W) {
            if (this.f14214X - 0.0f < 0.001f) {
                this.f14214X = CameraConfig.getConfigFloatValue(ConfigDataBase.KEY_VIDEO_EIS_PREVIEW_SCALE);
            }
            float COUIBaseListPopupWindow_12 = this.f14214X;
            interfaceC2757h.mo13960a(COUIBaseListPopupWindow_12, -COUIBaseListPopupWindow_12, 1.0f);
        } else if (this.f14241u.mo22849l()) {
            interfaceC2757h.mo13960a(this.f14241u.mo22850m(), -this.f14241u.mo22852n(), 1.0f);
        } else {
            interfaceC2757h.mo13960a(1.0f, -1.0f, 1.0f);
        }
        if (this.f14197G != 90) {
            interfaceC2757h.mo13961a(((r7 - 90) + 360) % 360, 0.0f, 0.0f, 1.0f);
        }
        interfaceC2757h.mo13959a(-r5, -r6);
        SurfaceTexture surfaceTexture3 = this.f14208R;
        if (surfaceTexture3 != null) {
            surfaceTexture3.updateTexImage();
        }
        m14235a(this.f14196F);
        if (2 == AlgoSwitchConfig.getApsVersion() && (surfaceTexture = this.f14208R) != null) {
            this.f14193C = surfaceTexture.getTimestamp();
        }
        this.f14241u.mo22811b(this.f14193C);
        this.f14241u.mo22797a(this.f14196F);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private void m14208b(GLCanvas interfaceC2757h, int OplusGLSurfaceView_13, int i2, int i3, int i4) throws IOException {
        m14219a(0);
        boolean zM24390b = Util.m24390b();
        boolean zM14210b = m14210b(IntrinsicsJvm.kt_4.f14252c);
        boolean zM14210b2 = m14210b(IntrinsicsJvm.kt_4.f14255f);
        boolean zM14210b3 = m14210b(IntrinsicsJvm.kt_4.f14254e);
        if (this.f14195E && (zM14210b2 || zM24390b || zM14210b || zM14210b3)) {
            RawTexture c2768s = this.f14230j.get(0).f14248a;
            this.f14241u.mo22775a(interfaceC2757h, this.f14232l.get(0), c2768s, false);
            if (zM24390b) {
                this.f14241u.mo22775a(interfaceC2757h, this.f14232l.get(0), c2768s, false);
                m14204a((String) null, interfaceC2757h, c2768s, (Integer) null, 0L);
            } else {
                m14229a(interfaceC2757h, this.f14232l.get(0), c2768s, this.f14196F);
            }
            if (zM14210b2) {
                m14204a(IntrinsicsJvm.kt_4.f14255f, interfaceC2757h, c2768s, (Integer) null, 0L);
            }
            if (zM14210b) {
                m14204a(IntrinsicsJvm.kt_4.f14252c, interfaceC2757h, c2768s, (Integer) null, 0L);
            }
            if (zM14210b3) {
                m14204a(IntrinsicsJvm.kt_4.f14254e, interfaceC2757h, c2768s, (Integer) null, 0L);
            }
        }
        interfaceC2757h.mo13985f();
        this.f14241u.mo22800a(interfaceC2757h, OplusGLSurfaceView_13, i2, i3, i4);
        SurfaceTexture surfaceTexture = this.f14208R;
        if (surfaceTexture != null) {
            surfaceTexture.detachFromGLContext();
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m14203a(GLProducerRender abstractC3285j) {
        SurfaceTexture surfaceTexture = this.f14208R;
        if (surfaceTexture != null) {
            surfaceTexture.attachToGLContext(this.f14232l.get(1).m13934e());
        }
        synchronized (this.f14231k) {
            if (this.f14218ab != null && !this.f14218ab.getHardwareBuffer().isClosed()) {
                PreviewShow.process(this.f14218ab.getHardwareBuffer(), 36197, this.f14232l.get(1).m13934e(), this.f14220ad);
            }
            abstractC3285j.m20961b(this.f14232l.get(1).m13934e());
        }
        SurfaceTexture surfaceTexture2 = this.f14208R;
        if (surfaceTexture2 != null) {
            surfaceTexture2.detachFromGLContext();
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private boolean m14211c(GLCanvas interfaceC2757h, int OplusGLSurfaceView_13, int i2, int i3, int i4) {
        synchronized (this.f14231k) {
            if (this.f14200J != null && this.f14201K != null && !this.f14200J.getHardwareBuffer().isClosed() && !this.f14201K.getHardwareBuffer().isClosed()) {
                m14255i(this.f14198H);
                PreviewShow.process(this.f14200J.getHardwareBuffer(), 36197, this.f14202L.m13890c(), this.f14220ad);
                PreviewShow.process(this.f14201K.getHardwareBuffer(), 36197, this.f14202L.m13891d(), this.f14220ad);
                Size size = new Size(this.f14201K.getWidth(), this.f14201K.getHeight());
                Size size2 = new Size(this.f14200J.getWidth(), this.f14200J.getHeight());
                this.f14241u.mo22811b(this.f14201K.getTimestamp());
                this.f14202L.m13892e().m13953b(true);
                if (this.f14241u.mo22815b(interfaceC2757h, this.f14202L.m13892e(), OplusGLSurfaceView_13, i2, i3, i4, this.f14194D)) {
                    this.f14202L.m13886a(interfaceC2757h, this.f14241u.mo22843j(4).mo22292g().m13934e(), this.f14202L.m13890c(), size, size2, this.f14203M.m13919m(), true, this.f14203M);
                } else {
                    this.f14202L.m13886a(interfaceC2757h, this.f14202L.m13891d(), this.f14202L.m13890c(), size, size2, this.f14203M.m13919m(), false, this.f14203M);
                }
                this.f14200J.close();
                this.f14201K.close();
                this.f14200J = null;
                this.f14201K = null;
                this.f14227d = true;
            } else if (this.f14202L.m13893f() != null) {
                float[] fArr = new float[16];
                Matrix.setIdentityM(fArr, 0);
                interfaceC2757h.mo13973a(this.f14202L.m13893f(), fArr, OplusGLSurfaceView_13, i2, i3, i4);
            }
        }
        return true;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m14197a(CameraApsResult cameraApsResult, GLCanvas interfaceC2757h, ExtTexture c2756g) {
        CameraScreenNail.IntrinsicsJvm.kt_4 bVar = this.f14238r;
        if (bVar == null || !bVar.mo23436a()) {
            return;
        }
        if (this.f14224ah == null) {
            this.f14224ah = new SatCrossAnimManager();
        }
        this.f14224ah.m23893a(this.f14241u);
        this.f14224ah.m23894a(this.f14238r);
        this.f14224ah.m23890a(m14248f(), m14250g());
        this.f14224ah.m23891a(cameraApsResult, interfaceC2757h, c2756g);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m14199a(GLCanvas interfaceC2757h, ExtTexture c2756g, int OplusGLSurfaceView_13, int i2, int i3, int i4) {
        SatCrossAnimManager c3462y = this.f14224ah;
        if (c3462y != null) {
            c3462y.m23892a(interfaceC2757h, c2756g, OplusGLSurfaceView_13, i2, i3, i4);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private boolean m14206a(GLCanvas interfaceC2757h) {
        if (!f14186ai.m23882a()) {
            return false;
        }
        float fM23883b = f14186ai.m23883b();
        interfaceC2757h.mo13982c();
        interfaceC2757h.mo13958a(fM23883b);
        return true;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private void m14207b(GLCanvas interfaceC2757h) {
        interfaceC2757h.mo13985f();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0145  */
    /* renamed from: IntrinsicsJvm.kt_5 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void m14212d(com.oplus.camera.p146gl.GLCanvas r20, int r21, int r22, int r23, int r24) {
        /*
            Method dump skipped, instructions count: 396
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.p146gl.SurfaceTextureScreenNail.m14212d(com.oplus.camera.gl.COUIBaseListPopupWindow_10, int, int, int, int):void");
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private final boolean m14205a(CameraApsResult cameraApsResult) {
        synchronized (this.f14239s) {
            if (this.f14191A) {
                return true;
            }
            if (this.f14206P.isEmpty()) {
                return false;
            }
            if (cameraApsResult != null && cameraApsResult.getCaptureResult() != null && cameraApsResult.getCaptureResult().getFrameNumber() > this.f14207Q + 3) {
                return false;
            }
            return true;
        }
    }

    /* renamed from: o */
    private int m14214o() {
        int OplusGLSurfaceView_13;
        synchronized (this.f14239s) {
            if (m14205a((CameraApsResult) null)) {
                OplusGLSurfaceView_13 = 25;
            } else {
                OplusGLSurfaceView_13 = this.f14246z ? 6 : 1;
            }
        }
        return OplusGLSurfaceView_13;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private final boolean m14209b(CameraApsResult cameraApsResult) {
        boolean z;
        synchronized (this.f14239s) {
            z = m14205a(cameraApsResult) || this.f14246z;
        }
        return z;
    }

    /* renamed from: p */
    private final boolean m14215p() {
        boolean z;
        synchronized (this.f14239s) {
            long jM14237b = m14237b(f14185a.intValue());
            IntrinsicsJvm.kt_4 bVar = this.f14240t.get(IntrinsicsJvm.kt_4.f14253d);
            z = (this.f14193C >= jM14237b && jM14237b > 0) || !(bVar == null || bVar.f14256g);
        }
        return z;
    }

    /* renamed from: q */
    private final boolean m14216q() {
        return m14237b(f14187b.intValue()) > 0 && m14237b(f14185a.intValue()) == 0;
    }

    /* renamed from: OplusGLSurfaceView_15 */
    public void m14256j() {
        if (this.f14208R == null || this.f14232l.isEmpty()) {
            return;
        }
        this.f14208R.attachToGLContext(this.f14232l.get(0).m13934e());
        this.f14208R.updateTexImage();
        this.f14208R.getTransformMatrix(this.f14196F);
        this.f14208R.detachFromGLContext();
    }

    /* renamed from: OplusGLSurfaceView_5 */
    public void m14257k() {
        SurfaceTexture surfaceTexture = this.f14208R;
        if (surfaceTexture != null) {
            surfaceTexture.updateTexImage();
        }
    }

    /* renamed from: OplusGLSurfaceView_14 */
    public boolean m14258l() {
        PreviewEffectProcess interfaceC3423t = this.f14241u;
        if (interfaceC3423t != null) {
            return interfaceC3423t.mo22832f();
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0013 A[Catch: all -> 0x0023, TryCatch #0 {, blocks: (B:8:0x000d, B:11:0x0018, B:12:0x0021, B:10:0x0013), top: B:17:0x000d }] */
    /* renamed from: PlatformImplementations.kt_3 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void m14235a(float[] r4) {
        /*
            r3 = this;
            android.graphics.SurfaceTexture r0 = r3.f14208R
            if (r0 == 0) goto L8
            r0.getTransformMatrix(r4)
            goto L22
        L8:
            float[] r0 = r3.f14209S
            monitor-enter(r0)
            if (r4 == 0) goto L13
            int r1 = r4.length     // Catch: java.lang.Throwable -> L23
            float[] r2 = r3.f14209S     // Catch: java.lang.Throwable -> L23
            int r2 = r2.length     // Catch: java.lang.Throwable -> L23
            if (r1 >= r2) goto L18
        L13:
            float[] r4 = r3.f14209S     // Catch: java.lang.Throwable -> L23
            int r4 = r4.length     // Catch: java.lang.Throwable -> L23
            float[] r4 = new float[r4]     // Catch: java.lang.Throwable -> L23
        L18:
            float[] r1 = r3.f14209S     // Catch: java.lang.Throwable -> L23
            float[] r3 = r3.f14209S     // Catch: java.lang.Throwable -> L23
            int r3 = r3.length     // Catch: java.lang.Throwable -> L23
            r2 = 0
            java.lang.System.arraycopy(r1, r2, r4, r2, r3)     // Catch: java.lang.Throwable -> L23
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L23
        L22:
            return
        L23:
            r3 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L23
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.p146gl.SurfaceTextureScreenNail.m14235a(float[]):void");
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m14225a(Image image, int OplusGLSurfaceView_13) {
        Image image2;
        synchronized (this.f14231k) {
            try {
                if (1 == OplusGLSurfaceView_13) {
                    if (this.f14200J != null) {
                        this.f14200J.close();
                    }
                    this.f14200J = image;
                } else if (2 == OplusGLSurfaceView_13) {
                    if (this.f14201K != null) {
                        this.f14201K.close();
                    }
                    this.f14201K = image;
                }
                if (this.f14200J != null && this.f14201K != null) {
                    if (this.f14228e && this.f14229f) {
                        onFrameAvailable(null);
                        mo14259m();
                    } else {
                        if (1 == OplusGLSurfaceView_13) {
                            image2 = this.f14200J;
                            this.f14200J = null;
                        } else if (2 == OplusGLSurfaceView_13) {
                            image2 = this.f14201K;
                            this.f14201K = null;
                        } else {
                            image2 = null;
                        }
                        if (image2 != null) {
                            image2.close();
                        }
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* renamed from: OplusGLSurfaceView_6 */
    public void mo14259m() {
        synchronized (this.f14239s) {
            this.f14246z = false;
            this.f14191A = false;
            this.f14192B.clear();
        }
        m14221a(f14185a.intValue(), 0L, 0L);
        m14221a(f14187b.intValue(), 0L, 0L);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m14229a(GLCanvas interfaceC2757h, ExtTexture c2756g, RawTexture c2768s, float[] fArr) {
        if (c2768s == null) {
            return;
        }
        if (!c2768s.m13943n()) {
            c2768s.m14193c(interfaceC2757h);
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
    private void m14201a(GLCanvas interfaceC2757h, RawTexture c2768s, RawTexture c2768s2, float[] fArr) {
        if (c2768s2 == null || interfaceC2757h == null) {
            return;
        }
        if (!c2768s2.m13943n()) {
            c2768s2.m14193c(interfaceC2757h);
        }
        int iF = c2768s2.mo13935f();
        int iG = c2768s2.mo13936g();
        if (!Util.m24169C()) {
            GLES20.glFinish();
        }
        interfaceC2757h.mo13975a(c2768s2);
        interfaceC2757h.mo13959a(0.0f, iG);
        interfaceC2757h.mo13960a(1.0f, -1.0f, 1.0f);
        m14235a(this.f14196F);
        if (fArr == null) {
            fArr = this.f14196F;
        }
        interfaceC2757h.mo13973a(c2768s, fArr, 0, 0, iF, iG);
        interfaceC2757h.mo13987h();
        c2768s2.m13926a(c2768s.m13939j());
        c2768s2.m13930b(c2768s.m13940k());
        c2768s2.m14188a(c2768s.m14194s());
    }

    /* renamed from: COUIBaseListPopupWindow_10 */
    public void m14252h(boolean z) {
        OesDrawerEngine c2749f = this.f14202L;
        if (c2749f != null) {
            c2749f.m13888a(z);
        }
    }

    /* renamed from: OplusGLSurfaceView_13 */
    public void m14255i(boolean z) {
        synchronized (this.f14231k) {
            this.f14199I = z;
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m14231a(OutPresentation presentationC2959e) {
        CameraLog.m12959b("SurfaceTextureScreenNail", "setPresentation: " + presentationC2959e);
        this.f14212V.lock();
        this.f14211U = presentationC2959e;
        this.f14212V.unlock();
    }

    /* compiled from: SurfaceTextureScreenNail.java */
    /* renamed from: com.oplus.camera.gl.t$IntrinsicsJvm.kt_3 */
    private static class IntrinsicsJvm.kt_3 {

        /* renamed from: PlatformImplementations.kt_3 */
        public long f14258a;

        /* renamed from: IntrinsicsJvm.kt_4 */
        public long f14259b;

        public IntrinsicsJvm.kt_3(long OplusGLSurfaceView_15, long j2) {
            this.f14258a = 0L;
            this.f14259b = 0L;
            this.f14258a = OplusGLSurfaceView_15;
            this.f14259b = j2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: SurfaceTextureScreenNail.java */
    /* renamed from: com.oplus.camera.gl.t$PlatformImplementations.kt_3 */
    protected static class PlatformImplementations.kt_3 {

        /* renamed from: PlatformImplementations.kt_3 */
        public RawTexture f14248a;

        /* renamed from: IntrinsicsJvm.kt_4 */
        public CameraApsResult f14249b;

        /* renamed from: IntrinsicsJvm.kt_3 */
        public GLCanvas f14250c;

        /* renamed from: IntrinsicsJvm.kt_5 */
        public float[] f14251d;

        public PlatformImplementations.kt_3(int OplusGLSurfaceView_13, int i2) {
            this.f14248a = null;
            this.f14249b = null;
            this.f14250c = null;
            this.f14251d = null;
            this.f14248a = new RawTexture(OplusGLSurfaceView_13, i2, true);
        }

        public PlatformImplementations.kt_3(CameraApsResult cameraApsResult, GLCanvas interfaceC2757h, float[] fArr) {
            this.f14248a = null;
            this.f14249b = null;
            this.f14250c = null;
            this.f14251d = null;
            this.f14249b = cameraApsResult;
            this.f14250c = interfaceC2757h;
            this.f14251d = fArr;
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public long m14260a() {
            RawTexture c2768s = this.f14248a;
            if (c2768s != null) {
                return c2768s.m13939j();
            }
            CameraApsResult cameraApsResult = this.f14249b;
            if (cameraApsResult != null) {
                return cameraApsResult.getTimestamp();
            }
            return 0L;
        }

        /* renamed from: IntrinsicsJvm.kt_4 */
        public long m14261b() {
            RawTexture c2768s = this.f14248a;
            if (c2768s != null) {
                return c2768s.m13940k();
            }
            CameraApsResult cameraApsResult = this.f14249b;
            if (cameraApsResult != null) {
                return cameraApsResult.getTimestamp();
            }
            return 0L;
        }

        /* renamed from: IntrinsicsJvm.kt_3 */
        public void m14262c() {
            RawTexture c2768s = this.f14248a;
            if (c2768s != null) {
                c2768s.mo13944o();
                this.f14248a = null;
            }
            CameraApsResult cameraApsResult = this.f14249b;
            if (cameraApsResult != null) {
                cameraApsResult.closeImageBuffer();
                this.f14249b = null;
            }
        }

        public String toString() {
            return "{mRawTexture: " + this.f14248a + ", mCameraApsResult: " + this.f14249b + ", mTransForm: " + this.f14251d + "}";
        }
    }
}

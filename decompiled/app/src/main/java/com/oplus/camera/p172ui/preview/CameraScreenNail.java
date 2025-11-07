package com.oplus.camera.p172ui.preview;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.os.Looper;
import android.util.Size;
import com.google.android.exoplayer2.C1547C;
import com.oplus.camera.CameraLog;
import com.oplus.camera.aps.config.CameraConfig;
import com.oplus.camera.aps.config.ConfigDataBase;
import com.oplus.camera.aps.util.AlgoSwitchConfig;
import com.oplus.camera.p146gl.SurfaceTextureScreenNail;
import com.oplus.camera.p146gl.BitmapTexture;
import com.oplus.camera.p146gl.NoMoireThumbGenerator;
import com.oplus.camera.p146gl.RawTexture;
import com.oplus.camera.p146gl.TextureRotateProcessor;
import com.oplus.camera.p146gl.GLCanvas;
import com.oplus.camera.p146gl.p147a.GLImageCircularGaussBlurProcessor;
import com.oplus.camera.p146gl.p147a.GLImageModeChangeProcessorAgent;
import com.oplus.camera.p146gl.p147a.GLImageProcessor;
import com.oplus.camera.p146gl.p148b.OesDrawerEngine;
import com.oplus.camera.p172ui.menu.levelcontrol.GLProducerRender;
import com.oplus.camera.p181w.CameraDataCollection;
import com.oplus.camera.perf.CameraPerformance;
import com.oplus.camera.util.OpenGLUtils;
import com.oplus.camera.util.Util;

/* compiled from: CameraScreenNail.java */
/* renamed from: com.oplus.camera.ui.preview.COUIBaseListPopupWindow_10 */
/* loaded from: classes2.dex */
public class CameraScreenNail extends SurfaceTextureScreenNail {

    /* renamed from: V */
    private boolean f22092V;

    /* renamed from: W */
    private boolean f22093W;

    /* renamed from: ab */
    private Context f22098ab;

    /* renamed from: ad */
    private AnimManager f22100ad;

    /* renamed from: R */
    private final float[] f22088R = new float[16];

    /* renamed from: S */
    private int f22089S = 0;

    /* renamed from: T */
    private float f22090T = 0.0f;

    /* renamed from: U */
    private float f22091U = 0.0f;

    /* renamed from: X */
    private boolean f22094X = false;

    /* renamed from: Y */
    private boolean f22095Y = true;

    /* renamed from: Z */
    private boolean f22096Z = false;

    /* renamed from: aa */
    private boolean f22097aa = false;

    /* renamed from: ac */
    private VideoCaptureAnimManager f22099ac = new VideoCaptureAnimManager();

    /* renamed from: ae */
    private RawTexture f22101ae = null;

    /* renamed from: af */
    private RawTexture f22102af = null;

    /* renamed from: ag */
    private BitmapTexture f22103ag = null;

    /* renamed from: ah */
    private IntrinsicsJvm.kt_5 f22104ah = null;

    /* renamed from: ai */
    private PlatformImplementations.kt_3 f22105ai = null;

    /* renamed from: aj */
    private GLImageModeChangeProcessorAgent f22106aj = null;

    /* renamed from: ak */
    private GLImageCircularGaussBlurProcessor f22107ak = null;

    /* renamed from: al */
    private int f22108al = 0;

    /* renamed from: am */
    private int f22109am = 0;

    /* renamed from: an */
    private long f22110an = 0;

    /* renamed from: ao */
    private int f22111ao = 0;

    /* renamed from: ap */
    private Size f22112ap = null;

    /* renamed from: aq */
    private float[] f22113aq = null;

    /* renamed from: ar */
    private BlendingAnimManager f22114ar = new BlendingAnimManager();

    /* renamed from: as */
    private boolean f22115as = false;

    /* renamed from: at */
    private Runnable f22116at = new Runnable() { // from class: com.oplus.camera.ui.preview.COUIBaseListPopupWindow_10.5
        @Override // java.lang.Runnable
        public void run() {
            CameraScreenNail.this.f14237q.mo23362ab();
        }
    };

    /* compiled from: CameraScreenNail.java */
    /* renamed from: com.oplus.camera.ui.preview.COUIBaseListPopupWindow_10$PlatformImplementations.kt_3 */
    public interface PlatformImplementations.kt_3 {
        /* renamed from: PlatformImplementations.kt_3 */
        void mo23433a();
    }

    /* compiled from: CameraScreenNail.java */
    /* renamed from: com.oplus.camera.ui.preview.COUIBaseListPopupWindow_10$IntrinsicsJvm.kt_4 */
    public interface IntrinsicsJvm.kt_4 {
        /* renamed from: PlatformImplementations.kt_3 */
        float mo23435a(float COUIBaseListPopupWindow_12);

        /* renamed from: PlatformImplementations.kt_3 */
        boolean mo23436a();

        /* renamed from: IntrinsicsJvm.kt_4 */
        void mo23437b();
    }

    /* compiled from: CameraScreenNail.java */
    /* renamed from: com.oplus.camera.ui.preview.COUIBaseListPopupWindow_10$IntrinsicsJvm.kt_3 */
    public interface IntrinsicsJvm.kt_3 {
        /* renamed from: Z */
        void mo23325Z();

        /* renamed from: aa */
        void mo23361aa();

        /* renamed from: ab */
        void mo23362ab();

        /* renamed from: ac */
        void mo23363ac();
    }

    /* compiled from: CameraScreenNail.java */
    /* renamed from: com.oplus.camera.ui.preview.COUIBaseListPopupWindow_10$IntrinsicsJvm.kt_5 */
    public interface IntrinsicsJvm.kt_5 {
        /* renamed from: PlatformImplementations.kt_3 */
        int mo11049a(int OplusGLSurfaceView_13);

        /* renamed from: PlatformImplementations.kt_3 */
        void mo11050a();

        /* renamed from: IntrinsicsJvm.kt_4 */
        void mo11051b();

        /* renamed from: IntrinsicsJvm.kt_3 */
        void mo11052c();

        /* renamed from: IntrinsicsJvm.kt_5 */
        void mo11053d();
    }

    public CameraScreenNail(Context context, IntrinsicsJvm.kt_3 cVar, boolean z) {
        this.f22093W = false;
        this.f22098ab = null;
        this.f22100ad = null;
        synchronized (this.f14231k) {
            this.f22098ab = context;
            this.f14237q = cVar;
            this.f22100ad = new SwitchAnimManager();
            this.f22093W = z ? false : true;
            this.f14203M.m13899a(Util.getScreenWidth());
            this.f14203M.m13904b(Util.getScreenHeight());
            this.f14203M.m13906c(Util.getSettingMenuPanelHeight());
        }
    }

    /* renamed from: OplusGLSurfaceView_11 */
    public void m23480n() {
        synchronized (this.f14231k) {
            this.f14195E = false;
        }
    }

    /* renamed from: o */
    public boolean m23483o() {
        return this.f14195E;
    }

    @Override // com.oplus.camera.p146gl.SurfaceTextureScreenNail
    /* renamed from: IntrinsicsJvm.kt_5 */
    public void mo14245d(boolean z) {
        synchronized (this.f14231k) {
            this.f22094X = false;
            super.mo14245d(z);
            this.f22101ae = new RawTexture(m14248f(), m14250g(), true);
        }
    }

    @Override // com.oplus.camera.p146gl.SurfaceTextureScreenNail
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo14220a(int OplusGLSurfaceView_13, int i2) {
        super.mo14220a(OplusGLSurfaceView_13, i2);
    }

    @Override // com.oplus.camera.p146gl.SurfaceTextureScreenNail
    /* renamed from: IntrinsicsJvm.kt_5 */
    public void mo14244d() {
        synchronized (this.f14231k) {
            super.mo14244d();
            m23438C();
            this.f22114ar.m23179b();
            m23471d(0);
        }
    }

    /* renamed from: p */
    public void m23484p() {
        if (this.f14203M != null) {
            this.f14203M.m13899a(Util.getScreenWidth());
            this.f14203M.m13904b(Util.getScreenHeight());
            this.f14203M.m13906c(Util.getSettingMenuPanelHeight());
        }
    }

    /* renamed from: q */
    public void m23486q() {
        this.f14241u.mo22839i();
        this.f22105ai = null;
        this.f14242v.m14132a(new Runnable() { // from class: com.oplus.camera.ui.preview.COUIBaseListPopupWindow_10.1
            @Override // java.lang.Runnable
            public void run() {
                if (CameraScreenNail.this.f14234n != null) {
                    CameraScreenNail.this.f14234n.m14111a();
                }
                if (CameraScreenNail.this.f14235o != null) {
                    CameraScreenNail.this.f14235o.m14277b();
                }
                if (CameraScreenNail.this.f22106aj != null) {
                    CameraScreenNail.this.f22106aj.m13836c();
                    CameraScreenNail.this.f22106aj = null;
                }
                if (CameraScreenNail.this.f22107ak != null) {
                    CameraScreenNail.this.f22107ak.mo13826b();
                    CameraScreenNail.this.f22107ak = null;
                }
                synchronized (this) {
                    if (CameraScreenNail.this.f14202L != null) {
                        CameraScreenNail.this.f14202L.m13889b();
                        CameraScreenNail.this.f14202L = null;
                    }
                }
            }
        });
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m23468a(IntrinsicsJvm.kt_5 dVar) {
        this.f22104ah = dVar;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m23466a(PlatformImplementations.kt_3 aVar) {
        this.f22105ai = aVar;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m23467a(IntrinsicsJvm.kt_4 bVar) {
        this.f14238r = bVar;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m23464a(Size size, Size size2) {
        if (this.f22106aj == null) {
            return;
        }
        if (!m23493x()) {
            this.f22106aj.m13831a(size, size2);
            this.f22112ap = size;
        } else {
            Size size3 = this.f22112ap;
            if (size3 != null) {
                this.f22106aj.m13831a(size3, size2);
            }
        }
        synchronized (this.f14231k) {
            if (this.f22089S == 0 || this.f22089S == 15) {
                this.f14237q.mo23325Z();
                m23471d(13);
            }
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m23463a(Bitmap bitmap, int OplusGLSurfaceView_13) {
        CameraLog.m12954a("CameraScreenNail", "setGaussianBlurBitmap");
        this.f22108al = OplusGLSurfaceView_13;
        if (bitmap != null && !bitmap.isRecycled()) {
            this.f22103ag = new BitmapTexture(bitmap);
            synchronized (this.f14231k) {
                this.f14237q.mo23325Z();
                m23471d(5);
            }
            return;
        }
        m23471d(0);
        this.f22104ah.mo11053d();
    }

    @Override // com.oplus.camera.p146gl.SurfaceTextureScreenNail
    /* renamed from: PlatformImplementations.kt_3 */
    public int mo14217a(int OplusGLSurfaceView_13, int i2, int i3, int i4) {
        this.f22107ak.mo13827b(i2, i3);
        this.f22107ak.mo13825a(i2, i3);
        this.f22107ak.mo13824a(i4);
        return this.f22107ak.mo13822a(OplusGLSurfaceView_13, OpenGLUtils.m24592a(GLImageProcessor.f13872a), OpenGLUtils.m24592a(GLImageProcessor.f13873b));
    }

    @Override // com.oplus.camera.p146gl.SurfaceTextureScreenNail
    /* renamed from: OplusGLSurfaceView_13 */
    public void mo14254i() {
        this.f22107ak.mo13823a();
    }

    /* renamed from: C */
    private void m23438C() {
        RawTexture c2768s = this.f22102af;
        if (c2768s != null) {
            c2768s.m13945p();
            this.f22102af = null;
        }
        GLImageModeChangeProcessorAgent c2739b = this.f22106aj;
        if (c2739b != null) {
            c2739b.m13834b();
        }
    }

    /* renamed from: r */
    public void m23487r() {
        if (this.f14241u != null) {
            this.f14241u.mo22807b();
        }
        if (this.f22106aj == null) {
            this.f22106aj = new GLImageModeChangeProcessorAgent();
        }
        if (this.f22107ak == null) {
            this.f22107ak = new GLImageCircularGaussBlurProcessor();
        }
        this.f14234n = new NoMoireThumbGenerator();
        this.f14235o = new TextureRotateProcessor();
        if (this.f14202L == null && CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_MULTI_VIDEO_MODE_SUPPORT)) {
            this.f14202L = new OesDrawerEngine();
        }
        if (this.f14202L != null) {
            this.f14202L.m13887a();
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m23469b(int OplusGLSurfaceView_13, int i2) {
        if (this.f14241u != null) {
            this.f14241u.mo22779a(OplusGLSurfaceView_13, i2);
        }
    }

    /* renamed from: OplusGLSurfaceView_15 */
    public void m23476j(boolean z) {
        this.f14198H = z;
    }

    /* renamed from: s */
    public void m23488s() {
        CameraLog.m12954a("CameraScreenNail", "animateOpenEnd");
        this.f22090T = 0.0f;
        synchronized (this.f14231k) {
            m23471d(0);
        }
    }

    /* renamed from: t */
    public void m23489t() {
        synchronized (this.f14231k) {
            m23471d(0);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public void m23471d(int OplusGLSurfaceView_13) {
        synchronized (this.f14231k) {
            CameraLog.m12954a("CameraScreenNail", "setAnimState, state: " + this.f22089S + "->" + OplusGLSurfaceView_13);
            this.f22089S = OplusGLSurfaceView_13;
        }
    }

    /* renamed from: D */
    private void m23439D() {
        if (this.f14195E) {
            return;
        }
        this.f14195E = true;
        this.f22113aq = null;
        CameraLog.m12952a("CameraStartupPerformance.onFirstFrameDrawed");
        this.f14237q.mo23363ac();
        CameraLog.m12958b("CameraStartupPerformance.onFirstFrameDrawed");
        CameraPerformance.m15189c("launch_first_frame_draw");
        CameraLog.m12967f("CameraScreenNail", "CameraTest First Frame Draw");
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private boolean m23448b(GLCanvas interfaceC2757h, int OplusGLSurfaceView_13, int i2, int i3, int i4) {
        if (!this.f22114ar.m23178a()) {
            return false;
        }
        this.f22114ar.m23177a(this.f14241u, this.f14232l.get(0), this.f22102af, interfaceC2757h, OplusGLSurfaceView_13, i2, i3, i4);
        return true;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m23465a(GLCanvas interfaceC2757h, int OplusGLSurfaceView_13, int i2, int i3, int i4) {
        super.mo14236a(interfaceC2757h, (GLProducerRender) null, OplusGLSurfaceView_13, i2, i3, i4);
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0204 A[Catch: all -> 0x03ef, TryCatch #1 {, blocks: (B:4:0x000b, B:6:0x0010, B:7:0x002a, B:9:0x0033, B:11:0x003b, B:18:0x0047, B:200:0x03e8, B:20:0x004e, B:22:0x0057, B:24:0x006a, B:25:0x0073, B:27:0x0075, B:28:0x0087, B:30:0x0089, B:32:0x008f, B:33:0x009b, B:35:0x009d, B:37:0x00a1, B:39:0x00a7, B:40:0x00aa, B:42:0x00ac, B:110:0x023c, B:112:0x0244, B:114:0x0248, B:116:0x024c, B:118:0x0252, B:120:0x025b, B:122:0x0261, B:124:0x026a, B:126:0x027f, B:127:0x0287, B:129:0x028d, B:130:0x0292, B:132:0x02bc, B:134:0x02c0, B:136:0x02e3, B:143:0x02f8, B:145:0x02fd, B:147:0x0301, B:149:0x0307, B:151:0x031f, B:153:0x032d, B:155:0x032f, B:157:0x0336, B:159:0x033b, B:161:0x0341, B:165:0x034b, B:178:0x0382, B:179:0x0388, B:181:0x038e, B:183:0x0394, B:185:0x0398, B:187:0x039e, B:189:0x03a6, B:190:0x03b5, B:192:0x03b9, B:194:0x03d5, B:196:0x03de, B:195:0x03db, B:168:0x0351, B:170:0x0356, B:171:0x0360, B:173:0x0364, B:175:0x036a, B:137:0x02e7, B:138:0x02ee, B:139:0x02f3, B:123:0x0268, B:119:0x0259, B:55:0x00d5, B:57:0x00d9, B:59:0x00ee, B:65:0x0112, B:67:0x0121, B:69:0x0125, B:70:0x012e, B:88:0x018f, B:89:0x0190, B:60:0x00f6, B:62:0x00fe, B:64:0x0106, B:90:0x0195, B:98:0x01d4, B:100:0x0204, B:102:0x020d, B:106:0x0214, B:101:0x0208, B:93:0x01b6, B:95:0x01ba, B:97:0x01bc, B:92:0x01a6, B:107:0x021c, B:109:0x022f, B:13:0x003f, B:15:0x0043, B:71:0x012f, B:73:0x0135, B:75:0x0140, B:76:0x0156, B:78:0x015a, B:80:0x015e, B:82:0x0166, B:84:0x018b, B:83:0x0177), top: B:209:0x000b, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:101:0x0208 A[Catch: all -> 0x03ef, TryCatch #1 {, blocks: (B:4:0x000b, B:6:0x0010, B:7:0x002a, B:9:0x0033, B:11:0x003b, B:18:0x0047, B:200:0x03e8, B:20:0x004e, B:22:0x0057, B:24:0x006a, B:25:0x0073, B:27:0x0075, B:28:0x0087, B:30:0x0089, B:32:0x008f, B:33:0x009b, B:35:0x009d, B:37:0x00a1, B:39:0x00a7, B:40:0x00aa, B:42:0x00ac, B:110:0x023c, B:112:0x0244, B:114:0x0248, B:116:0x024c, B:118:0x0252, B:120:0x025b, B:122:0x0261, B:124:0x026a, B:126:0x027f, B:127:0x0287, B:129:0x028d, B:130:0x0292, B:132:0x02bc, B:134:0x02c0, B:136:0x02e3, B:143:0x02f8, B:145:0x02fd, B:147:0x0301, B:149:0x0307, B:151:0x031f, B:153:0x032d, B:155:0x032f, B:157:0x0336, B:159:0x033b, B:161:0x0341, B:165:0x034b, B:178:0x0382, B:179:0x0388, B:181:0x038e, B:183:0x0394, B:185:0x0398, B:187:0x039e, B:189:0x03a6, B:190:0x03b5, B:192:0x03b9, B:194:0x03d5, B:196:0x03de, B:195:0x03db, B:168:0x0351, B:170:0x0356, B:171:0x0360, B:173:0x0364, B:175:0x036a, B:137:0x02e7, B:138:0x02ee, B:139:0x02f3, B:123:0x0268, B:119:0x0259, B:55:0x00d5, B:57:0x00d9, B:59:0x00ee, B:65:0x0112, B:67:0x0121, B:69:0x0125, B:70:0x012e, B:88:0x018f, B:89:0x0190, B:60:0x00f6, B:62:0x00fe, B:64:0x0106, B:90:0x0195, B:98:0x01d4, B:100:0x0204, B:102:0x020d, B:106:0x0214, B:101:0x0208, B:93:0x01b6, B:95:0x01ba, B:97:0x01bc, B:92:0x01a6, B:107:0x021c, B:109:0x022f, B:13:0x003f, B:15:0x0043, B:71:0x012f, B:73:0x0135, B:75:0x0140, B:76:0x0156, B:78:0x015a, B:80:0x015e, B:82:0x0166, B:84:0x018b, B:83:0x0177), top: B:209:0x000b, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0211  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0213  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x034f  */
    /* JADX WARN: Removed duplicated region for block: B:202:0x03eb  */
    @Override // com.oplus.camera.p146gl.SurfaceTextureScreenNail
    /* renamed from: PlatformImplementations.kt_3 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean mo14236a(com.oplus.camera.p146gl.GLCanvas r23, com.oplus.camera.p172ui.menu.levelcontrol.GLProducerRender r24, int r25, int r26, int r27, int r28) {
        /*
            Method dump skipped, instructions count: 1010
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.p172ui.preview.CameraScreenNail.mo14236a(com.oplus.camera.gl.COUIBaseListPopupWindow_10, com.oplus.camera.ui.menu.levelcontrol.OplusGLSurfaceView_15, int, int, int, int):boolean");
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m23446a(GLCanvas interfaceC2757h, RawTexture c2768s, RawTexture c2768s2) {
        interfaceC2757h.mo13975a(c2768s2);
        interfaceC2757h.mo13968a(c2768s, 0, 0, c2768s2.mo13935f(), c2768s2.mo13936g());
        interfaceC2757h.mo13987h();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m23445a(GLCanvas interfaceC2757h) {
        if (this.f14232l.isEmpty()) {
            return;
        }
        m14235a(this.f14196F);
        m14229a(interfaceC2757h, this.f14232l.get(0), this.f22101ae, this.f14196F);
    }

    @Override // com.oplus.camera.p146gl.SurfaceTextureScreenNail, android.graphics.SurfaceTexture.OnFrameAvailableListener
    public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        CameraLog.m12952a("CameraScreenNail.onFrameAvailable");
        m23440E();
        if (2 == AlgoSwitchConfig.getApsVersion()) {
            synchronized (this.f14231k) {
                if (surfaceTexture != null) {
                    if (m14241c() == surfaceTexture) {
                        this.f14193C = surfaceTexture.getTimestamp();
                    }
                }
                CameraLog.m12967f("CameraScreenNail", "onFrameAvailable, surfaceTexture does not correspond.");
                CameraLog.m12958b("CameraScreenNail.onFrameAvailable");
                return;
            }
        }
        if (!this.f22092V) {
            this.f22092V = true;
        }
        if (!this.f22094X) {
            CameraLog.m12952a("CameraStartupPerformance.onFirstFrameAvailable");
            this.f22094X = true;
            CameraLog.m12958b("CameraStartupPerformance.onFirstFrameAvailable");
            CameraPerformance.m15189c("launch_first_frame_available");
            CameraLog.m12967f("CameraScreenNail", "CameraTest First Frame available");
        }
        if (this.f22092V) {
            if (Looper.myLooper() != Looper.getMainLooper()) {
                this.f14236p.post(this.f22116at);
            } else {
                this.f22116at.run();
            }
            if (this.f22095Y) {
                this.f14237q.mo23325Z();
            }
        }
        CameraLog.m12958b("CameraScreenNail.onFrameAvailable");
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m23470c(int OplusGLSurfaceView_13, int i2) {
        synchronized (this.f14231k) {
            this.f22100ad.mo22976b(OplusGLSurfaceView_13, i2);
        }
    }

    @Override // com.oplus.camera.p146gl.SurfaceTextureScreenNail
    /* renamed from: OplusGLSurfaceView_6 */
    public void mo14259m() {
        synchronized (this.f14231k) {
            this.f14226c = true;
        }
        super.mo14259m();
    }

    /* renamed from: u */
    public boolean m23490u() {
        boolean z;
        synchronized (this.f14231k) {
            z = this.f14226c && this.f22089S == 0;
        }
        return z;
    }

    /* renamed from: v */
    public boolean m23491v() {
        boolean z;
        synchronized (this.f14231k) {
            z = this.f14227d;
        }
        return z;
    }

    /* renamed from: OplusGLSurfaceView_5 */
    public void m23477k(boolean z) {
        synchronized (this.f14231k) {
            this.f14227d = z;
        }
    }

    /* renamed from: OplusGLSurfaceView_14 */
    public void m23478l(boolean z) {
        synchronized (this.f14231k) {
            this.f14228e = z;
        }
    }

    /* renamed from: OplusGLSurfaceView_6 */
    public void m23479m(boolean z) {
        synchronized (this.f14231k) {
            this.f14229f = z;
        }
    }

    /* renamed from: w */
    public void m23492w() {
        synchronized (this.f14231k) {
            CameraLog.m12954a("CameraScreenNail", "noModeChangeTask");
            this.f22097aa = false;
        }
    }

    /* renamed from: x */
    public boolean m23493x() {
        boolean z;
        synchronized (this.f14231k) {
            z = this.f22097aa;
        }
        return z;
    }

    /* renamed from: y */
    public void m23494y() {
        CameraLog.m12954a("CameraScreenNail", "forceRequestRender");
        Context context = this.f22098ab;
        if (context != null) {
            ((Activity) context).runOnUiThread(new Runnable() { // from class: com.oplus.camera.ui.preview.COUIBaseListPopupWindow_10.6
                @Override // java.lang.Runnable
                public void run() {
                    synchronized (CameraScreenNail.this.f14231k) {
                        CameraScreenNail.this.f14237q.mo23325Z();
                    }
                }
            });
        }
    }

    /* renamed from: OplusGLSurfaceView_11 */
    public void m23481n(boolean z) {
        synchronized (this.f14231k) {
            if (!this.f22095Y && z) {
                this.f22095Y = z;
                if (this.f22095Y && this.f22092V) {
                    this.f14237q.mo23325Z();
                }
            }
            this.f22095Y = z;
            CameraLog.m12959b("CameraScreenNail", "setDrawFrame, mbDrawFrame: " + this.f22095Y);
        }
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public void m23473e(int OplusGLSurfaceView_13) {
        CameraLog.m12959b("CameraScreenNail", "setMultiVideoType, type: " + OplusGLSurfaceView_13);
        this.f14203M.m13912f(OplusGLSurfaceView_13);
    }

    /* renamed from: o */
    public void m23482o(boolean z) {
        CameraLog.m12959b("CameraScreenNail", "setMainOneCameraImplDraw, mainOneCameraImplDraw: " + z);
        this.f14203M.m13902a(z);
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public void m23472d(int OplusGLSurfaceView_13, int i2) {
        CameraLog.m12959b("CameraScreenNail", "setSmallSurfaceSize, width: " + OplusGLSurfaceView_13 + ", height: " + i2);
        this.f14203M.m13900a(OplusGLSurfaceView_13, i2);
    }

    /* renamed from: z */
    public int m23495z() {
        return this.f14203M.m13914h();
    }

    /* renamed from: A */
    public int m23461A() {
        return this.f14203M.m13898a();
    }

    /* renamed from: B */
    public Rect m23462B() {
        return this.f14203M.m13921o();
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public void m23474e(int OplusGLSurfaceView_13, int i2) {
        CameraLog.m12959b("CameraScreenNail", "setSmallSurfacePosition, x: " + OplusGLSurfaceView_13 + ", y: " + i2);
        this.f14203M.m13908d(OplusGLSurfaceView_13);
        this.f14203M.m13910e(i2);
    }

    /* renamed from: E */
    private void m23440E() {
        long jNanoTime = System.nanoTime();
        long OplusGLSurfaceView_15 = this.f22110an;
        if (OplusGLSurfaceView_15 == 0) {
            this.f22110an = jNanoTime;
        } else if (jNanoTime - OplusGLSurfaceView_15 > C1547C.NANOS_PER_SECOND) {
            double d2 = (this.f22111ao * 1.0E9d) / (jNanoTime - OplusGLSurfaceView_15);
            CameraDataCollection.m24685a().m24692b((int) d2);
            CameraLog.m12962c("CameraScreenNail", "onFrameAvailableFps, fps: " + d2);
            this.f22110an = jNanoTime;
            this.f22111ao = 0;
        }
        this.f22111ao++;
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    public void m23475f(int OplusGLSurfaceView_13) {
        synchronized (this.f14231k) {
            if (1 == OplusGLSurfaceView_13) {
                if (this.f14200J != null) {
                    CameraLog.m12959b("CameraScreenNail", "closeMultiImage cameraRole: " + OplusGLSurfaceView_13);
                    this.f14200J.close();
                    this.f14200J = null;
                }
            } else if (this.f14201K != null) {
                CameraLog.m12959b("CameraScreenNail", "closeMultiImage cameraRole: " + OplusGLSurfaceView_13);
                this.f14201K.close();
                this.f14201K = null;
            }
        }
    }

    /* renamed from: p */
    public void m23485p(boolean z) {
        this.f22115as = z;
    }
}

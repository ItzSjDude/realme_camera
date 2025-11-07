package com.oplus.camera.p172ui.preview.p177a;

import android.content.Context;
import android.graphics.Point;
import com.oplus.camera.CameraLog;
import com.oplus.camera.algovisualization.AlgoListProcessor;
import com.oplus.camera.p146gl.GLES20Canvas;
import com.oplus.camera.p146gl.RawTexture;
import com.oplus.camera.p146gl.GLCanvas;
import com.oplus.camera.p172ui.preview.p177a.TexturePreview;
import com.oplus.camera.tiltshift.TiltShiftParam;
import com.oplus.camera.tiltshift.TiltShiftPreview;

/* compiled from: TiltShiftTexturePreview.java */
/* renamed from: com.oplus.camera.ui.preview.PlatformImplementations.kt_3.ab */
/* loaded from: classes2.dex */
public class TiltShiftTexturePreview extends TexturePreview {

    /* renamed from: PlatformImplementations.kt_3 */
    public static String f21011a = "0ms";

    /* renamed from: IntrinsicsJvm.kt_4 */
    private final Object f21012b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private int f21013c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private int f21014d;

    /* renamed from: OplusGLSurfaceView_5 */
    private int f21015k;

    /* renamed from: OplusGLSurfaceView_14 */
    private RawTexture f21016l;

    /* renamed from: OplusGLSurfaceView_6 */
    private RawTexture f21017m;

    /* renamed from: OplusGLSurfaceView_11 */
    private boolean f21018n;

    /* renamed from: o */
    private boolean f21019o;

    /* renamed from: p */
    private TiltShiftPreview f21020p;

    /* renamed from: q */
    private TexturePreviewRequest f21021q;

    /* renamed from: r */
    private boolean f21022r;

    /* renamed from: s */
    private boolean f21023s;

    /* compiled from: TiltShiftTexturePreview.java */
    /* renamed from: com.oplus.camera.ui.preview.PlatformImplementations.kt_3.ab$PlatformImplementations.kt_3 */
    enum PlatformImplementations.kt_3 {
        BLUR_LEVEL,
        WIDTH_SCALE,
        HEIGHT_SCALE,
        MIN_AREA_SIZE,
        EROSION_VALUE,
        ROTATION_ANGLE
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private int m22418a(int OplusGLSurfaceView_13, boolean z) {
        if (z) {
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

    @Override // com.oplus.camera.p172ui.preview.p177a.TexturePreview
    /* renamed from: PlatformImplementations.kt_3 */
    public boolean mo22282a() {
        return false;
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.TexturePreview
    /* renamed from: IntrinsicsJvm.kt_4 */
    public void mo22285b() {
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.TexturePreview
    /* renamed from: IntrinsicsJvm.kt_3 */
    public void mo22287c() {
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.TexturePreview
    /* renamed from: IntrinsicsJvm.kt_5 */
    public int mo22289d() {
        return 512;
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.TexturePreview
    /* renamed from: COUIBaseListPopupWindow_10 */
    public boolean mo22293h() {
        return false;
    }

    public TiltShiftTexturePreview(Context context) {
        super(context);
        this.f21012b = new Object();
        this.f21013c = 0;
        this.f21014d = 0;
        this.f21015k = 0;
        this.f21016l = null;
        this.f21017m = null;
        this.f21018n = false;
        this.f21019o = false;
        this.f21020p = null;
        this.f21021q = null;
        this.f21022r = false;
        this.f21023s = false;
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.TexturePreview
    /* renamed from: PlatformImplementations.kt_3 */
    public boolean mo22283a(int OplusGLSurfaceView_13) {
        if (!mo22673a_(OplusGLSurfaceView_13)) {
            return false;
        }
        synchronized (this.f21012b) {
            if (this.f21021q == null) {
                return false;
            }
            if (!this.f21021q.m22375d()) {
                return false;
            }
            if (this.f21023s) {
                return true;
            }
            CameraLog.m12954a("TiltShiftTexturePreview", "canProcess, texture is not inited");
            return false;
        }
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.TexturePreview
    /* renamed from: PlatformImplementations.kt_3 */
    public boolean mo22284a(TexturePreview.PlatformImplementations.kt_3 aVar) {
        int iM22417a;
        long jM11591a = AlgoListProcessor.m11591a();
        if (this.f21021q == null || aVar == null || aVar.f21549c == null || this.f21016l == null) {
            CameraLog.m12954a("TiltShiftTexturePreview", "process, false");
            return false;
        }
        synchronized (this.f21012b) {
            if (!this.f21022r) {
                CameraLog.m12954a("TiltShiftTexturePreview", "process, not create, so return!");
                return false;
            }
            RawTexture c2768s = aVar.f21549c;
            int iM13937h = c2768s.m13937h();
            int iM13938i = c2768s.m13938i();
            boolean z = this.f21543g;
            synchronized (this.f21012b) {
                if (this.f21018n && !m22426q()) {
                    CameraLog.m12954a("TiltShiftTexturePreview", "process, inTextureWidth: " + iM13938i + ", inTextureHeight: " + iM13937h);
                    m22422a(iM13938i, iM13937h, z);
                    this.f21018n = false;
                }
                iM22417a = m22417a(iM13938i, iM13937h, c2768s.m13934e(), new int[]{this.f21016l.m13934e()}, z, m22418a(this.f21015k, z), this.f21021q.m22340I());
            }
            this.f21019o = iM22417a == 0;
            boolean z2 = iM22417a == 0;
            f21011a = AlgoListProcessor.m11592a(jM11591a, AlgoListProcessor.m11591a());
            return z2;
        }
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.TexturePreview
    /* renamed from: y */
    public boolean mo22428y() {
        return this.f21019o;
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.TexturePreview
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo22281a(final TexturePreviewRequest c3397aa) {
        CameraLog.m12954a("TiltShiftTexturePreview", "createEngine");
        this.f21544h.m14132a(new Runnable() { // from class: com.oplus.camera.ui.preview.PlatformImplementations.kt_3.ab.1
            @Override // java.lang.Runnable
            public void run() {
                synchronized (TiltShiftTexturePreview.this.f21012b) {
                    if (TiltShiftTexturePreview.this.m22426q()) {
                        TiltShiftTexturePreview.this.f21020p = new TiltShiftPreview();
                    }
                    TiltShiftTexturePreview.this.f21022r = true;
                    TiltShiftTexturePreview.this.f21021q = c3397aa;
                    CameraLog.m12954a("TiltShiftTexturePreview", "createEngine X");
                }
            }
        });
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.TexturePreview
    /* renamed from: COUIBaseListPopupWindow_8 */
    public void mo22290e() {
        CameraLog.m12954a("TiltShiftTexturePreview", "destroyEngine");
        this.f21544h.m14132a(new Runnable() { // from class: com.oplus.camera.ui.preview.PlatformImplementations.kt_3.ab.2
            @Override // java.lang.Runnable
            public void run() {
                synchronized (TiltShiftTexturePreview.this.f21012b) {
                    if (TiltShiftTexturePreview.this.f21020p != null) {
                        TiltShiftTexturePreview.this.f21544h.m14133g();
                        TiltShiftTexturePreview.this.f21020p.destory();
                        TiltShiftTexturePreview.this.f21020p = null;
                    }
                    TiltShiftTexturePreview.this.f21021q = null;
                    TiltShiftTexturePreview.this.f21022r = false;
                    CameraLog.m12954a("TiltShiftTexturePreview", "destroyEngine X");
                }
            }
        });
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.TexturePreview
    /* renamed from: COUIBaseListPopupWindow_12 */
    public RawTexture mo22291f() {
        return this.f21017m;
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.TexturePreview
    /* renamed from: COUIBaseListPopupWindow_11 */
    public RawTexture mo22292g() {
        return this.f21016l;
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.TexturePreview
    /* renamed from: OplusGLSurfaceView_13 */
    public void mo22294i() {
        CameraLog.m12954a("TiltShiftTexturePreview", "newTextures");
        this.f21017m = new RawTexture(this.f21013c, this.f21014d, true);
        this.f21016l = new RawTexture(this.f21013c, this.f21014d, true);
        this.f21023s = true;
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.TexturePreview
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo22280a(GLCanvas interfaceC2757h) {
        RawTexture c2768s = this.f21017m;
        if (c2768s != null && !c2768s.m13943n()) {
            this.f21017m.m14193c(interfaceC2757h);
            CameraLog.m12954a("TiltShiftTexturePreview", "prepareTextures, mInputTiltShiftTexture.getId: " + this.f21017m.m13934e());
        }
        RawTexture c2768s2 = this.f21016l;
        if (c2768s2 == null || c2768s2.m13943n()) {
            return;
        }
        this.f21016l.m14193c(interfaceC2757h);
        CameraLog.m12954a("TiltShiftTexturePreview", "prepareTextures, mOutputTiltShiftTexture.getId: " + this.f21016l.m13934e());
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.TexturePreview
    /* renamed from: OplusGLSurfaceView_15 */
    public void mo22295j() {
        CameraLog.m12954a("TiltShiftTexturePreview", "recycleTextures");
        if (this.f21023s) {
            RawTexture c2768s = this.f21017m;
            if (c2768s != null) {
                c2768s.mo13944o();
                this.f21017m = null;
            }
            RawTexture c2768s2 = this.f21016l;
            if (c2768s2 != null) {
                c2768s2.mo13944o();
                this.f21016l = null;
            }
            this.f21023s = false;
        }
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.TexturePreview
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo22278a(int OplusGLSurfaceView_13, int i2) {
        CameraLog.m12954a("TiltShiftTexturePreview", "setSize, height: " + OplusGLSurfaceView_13 + ", width: " + i2);
        this.f21013c = i2;
        this.f21014d = OplusGLSurfaceView_13;
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.TexturePreview
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo22427a(boolean z) {
        synchronized (this.f21012b) {
            this.f21018n = z;
        }
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.TexturePreview
    /* renamed from: IntrinsicsJvm.kt_4 */
    public void mo22286b(int OplusGLSurfaceView_13) {
        this.f21015k = OplusGLSurfaceView_13;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m22422a(int OplusGLSurfaceView_13, int i2, boolean z) {
        if (m22426q()) {
            return;
        }
        CameraLog.m12954a("TiltShiftTexturePreview", "initTiltShift, width: " + OplusGLSurfaceView_13 + ", height: " + i2 + ", isFrontCamera: " + z);
        int iInit = this.f21020p.init(i2, OplusGLSurfaceView_13, 1, 1);
        StringBuilder sb = new StringBuilder();
        sb.append("initTiltShift, X, initResult: ");
        sb.append(iInit);
        CameraLog.m12954a("TiltShiftTexturePreview", sb.toString());
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private int m22417a(int OplusGLSurfaceView_13, int i2, int i3, int[] iArr, boolean z, int i4, Point point) {
        TexturePreviewRequest c3397aa = this.f21021q;
        if (c3397aa == null) {
            return -1;
        }
        TiltShiftParam tiltShiftParamM22376e = c3397aa.m22376e();
        if (m22426q() || iArr == null || tiltShiftParamM22376e == null) {
            return -1;
        }
        System.currentTimeMillis();
        int[] iArr2 = new int[1];
        this.f21020p.setDebugMask(tiltShiftParamM22376e.isAdjusting());
        this.f21020p.setParam(PlatformImplementations.kt_3.BLUR_LEVEL.ordinal(), this.f21021q.m22380f());
        this.f21020p.setParam(PlatformImplementations.kt_3.ROTATION_ANGLE.ordinal(), i4);
        this.f21020p.getMaskTexture(OplusGLSurfaceView_13, i2, tiltShiftParamM22376e.getCenterX(), tiltShiftParamM22376e.getCenterY(), tiltShiftParamM22376e.getInnerDistance(), tiltShiftParamM22376e.getAngle(), tiltShiftParamM22376e.isCircle(), iArr2);
        int iProcess = this.f21020p.process(i3, iArr2[0], iArr);
        GLES20Canvas.m14010i();
        return iProcess;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: q */
    public boolean m22426q() {
        return this.f21020p == null;
    }
}

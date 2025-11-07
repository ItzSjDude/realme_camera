package com.oplus.camera.p172ui.preview.p177a;

import android.content.Context;
import android.graphics.Rect;
import android.opengl.GLES20;
import com.arcsoft.libsinglecamerabokeh.jni.SingleCameraBokehJNI;
import com.oplus.camera.CameraLog;
import com.oplus.camera.p146gl.GLES20Canvas;
import com.oplus.camera.p146gl.RawTexture;
import com.oplus.camera.p146gl.GLCanvas;
import com.oplus.camera.p172ui.preview.p177a.TexturePreview;
import com.oplus.camera.util.Util;

/* compiled from: ArcsoftBlurTexturePreview.java */
/* renamed from: com.oplus.camera.ui.preview.PlatformImplementations.kt_3.IntrinsicsJvm.kt_5 */
/* loaded from: classes2.dex */
public class ArcsoftBlurTexturePreview extends TexturePreview {

    /* renamed from: PlatformImplementations.kt_3 */
    private final Object f21188a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private int f21189b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private int f21190c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private int f21191d;

    /* renamed from: OplusGLSurfaceView_5 */
    private TexturePreview.IntrinsicsJvm.kt_4 f21192k;

    /* renamed from: OplusGLSurfaceView_14 */
    private RawTexture f21193l;

    /* renamed from: OplusGLSurfaceView_6 */
    private RawTexture f21194m;

    /* renamed from: OplusGLSurfaceView_11 */
    private boolean f21195n;

    /* renamed from: o */
    private boolean f21196o;

    /* renamed from: p */
    private boolean f21197p;

    /* renamed from: q */
    private SingleCameraBokehJNI f21198q;

    /* renamed from: r */
    private TexturePreviewRequest f21199r;

    /* renamed from: s */
    private boolean f21200s;

    /* renamed from: t */
    private Context f21201t;

    /* renamed from: u */
    private Rect[] f21202u;

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
        return 1;
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.TexturePreview
    /* renamed from: COUIBaseListPopupWindow_10 */
    public boolean mo22293h() {
        return false;
    }

    public ArcsoftBlurTexturePreview(Context context) {
        super(context);
        this.f21188a = new Object();
        this.f21189b = 0;
        this.f21190c = 0;
        this.f21191d = 0;
        this.f21192k = null;
        this.f21193l = null;
        this.f21194m = null;
        this.f21195n = false;
        this.f21196o = false;
        this.f21197p = false;
        this.f21199r = null;
        this.f21200s = false;
        this.f21201t = null;
        this.f21202u = null;
        this.f21201t = context;
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.TexturePreview
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo22533a(TexturePreview.IntrinsicsJvm.kt_4 bVar) {
        synchronized (this.f21188a) {
            this.f21192k = bVar;
        }
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.TexturePreview
    /* renamed from: PlatformImplementations.kt_3 */
    public boolean mo22283a(int OplusGLSurfaceView_13) {
        if (!mo22673a_(OplusGLSurfaceView_13)) {
            return false;
        }
        synchronized (this.f21188a) {
            if (this.f21199r == null) {
                return false;
            }
            if (this.f21199r.m22334C() <= 0) {
                if (this.f21196o) {
                    this.f21196o = false;
                }
                return false;
            }
            if (!this.f21199r.m22401r()) {
                CameraLog.m12967f("ArcsoftBlurTexturePreview", "canProcess, not open effect");
                return false;
            }
            if (this.f21200s) {
                return true;
            }
            CameraLog.m12967f("ArcsoftBlurTexturePreview", "canProcess, texture is not inited");
            return false;
        }
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.TexturePreview
    /* renamed from: PlatformImplementations.kt_3 */
    public boolean mo22284a(TexturePreview.PlatformImplementations.kt_3 aVar) {
        int iProcess;
        if (aVar == null || aVar.f21549c == null || this.f21193l == null) {
            return false;
        }
        RawTexture c2768s = aVar.f21549c;
        int iH = c2768s.m13937h();
        int OplusGLSurfaceView_13 = c2768s.m13938i();
        synchronized (this.f21188a) {
            if (this.f21199r == null) {
                return false;
            }
            if (this.f21195n && this.f21198q != null) {
                m22530b(iH, OplusGLSurfaceView_13);
                this.f21195n = false;
            }
            if (!this.f21197p) {
                return false;
            }
            GLES20.glViewport(0, 0, iH, OplusGLSurfaceView_13);
            if (this.f21192k != null) {
                this.f21202u = this.f21192k.mo22931b();
            }
            if (this.f21198q == null || this.f21202u == null || this.f21202u.length <= 0) {
                iProcess = -1;
            } else {
                int length = this.f21202u.length;
                int[] iArr = new int[length * 4];
                int i2 = 0;
                int i3 = 0;
                while (true) {
                    if (i2 >= length) {
                        break;
                    }
                    if (this.f21202u[i2] == null) {
                        CameraLog.m12967f("ArcsoftBlurTexturePreview", "process, faceRects is null");
                        break;
                    }
                    iArr[i3] = iH - this.f21202u[i2].bottom;
                    int i4 = i3 + 1;
                    iArr[i4] = OplusGLSurfaceView_13 - this.f21202u[i2].right;
                    int i5 = i4 + 1;
                    iArr[i5] = iH - this.f21202u[i2].top;
                    int i6 = i5 + 1;
                    iArr[i6] = OplusGLSurfaceView_13 - this.f21202u[i2].left;
                    i3 = i6 + 1;
                    i2++;
                }
                int[] iArr2 = {10, 11, 12, 13};
                int i7 = this.f21191d;
                int i8 = i7 != 0 ? i7 != 90 ? i7 != 180 ? i7 != 270 ? 0 : 1 : 2 : 4 : 3;
                System.currentTimeMillis();
                if (!this.f21196o && this.f21199r.m22334C() > 0) {
                    this.f21196o = true;
                    this.f21198q.forceUpdateFrame(Util.m24169C() ? 0 : 1);
                    CameraLog.m12967f("ArcsoftBlurTexturePreview", "process, forceUpdateFrame");
                }
                iProcess = this.f21198q.process(c2768s.m13934e(), new int[]{this.f21193l.m13934e()}, length, iArr, iArr2, (int) (this.f21199r.m22344a() * 100.0f), i8);
                GLES20Canvas.m14010i();
            }
            GLES20.glViewport(0, 0, aVar.f21547a.mo13983d(), aVar.f21547a.mo13984e());
            return iProcess != -1;
        }
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.TexturePreview
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo22281a(TexturePreviewRequest c3397aa) {
        CameraLog.m12954a("ArcsoftBlurTexturePreview", "createEngine,  reques: " + c3397aa);
        synchronized (this.f21188a) {
            if (this.f21198q == null) {
                this.f21198q = new SingleCameraBokehJNI();
                CameraLog.m12954a("ArcsoftBlurTexturePreview", "createEngine, native version: " + this.f21198q.getVersion());
            }
            this.f21199r = c3397aa;
        }
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.TexturePreview
    /* renamed from: COUIBaseListPopupWindow_8 */
    public void mo22290e() {
        if (this.f21544h == null) {
            return;
        }
        CameraLog.m12954a("ArcsoftBlurTexturePreview", "destroyEngine");
        this.f21544h.m14132a(new Runnable() { // from class: com.oplus.camera.ui.preview.PlatformImplementations.kt_3.IntrinsicsJvm.kt_5.1
            @Override // java.lang.Runnable
            public void run() {
                synchronized (ArcsoftBlurTexturePreview.this.f21188a) {
                    if (ArcsoftBlurTexturePreview.this.f21198q != null && ArcsoftBlurTexturePreview.this.f21197p) {
                        int iRelease = ArcsoftBlurTexturePreview.this.f21198q.release();
                        ArcsoftBlurTexturePreview.this.f21197p = false;
                        CameraLog.m12954a("ArcsoftBlurTexturePreview", "destroyEngine, X ret: " + iRelease);
                    }
                    ArcsoftBlurTexturePreview.this.f21198q = null;
                    ArcsoftBlurTexturePreview.this.f21199r = null;
                }
            }
        });
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.TexturePreview
    /* renamed from: COUIBaseListPopupWindow_12 */
    public RawTexture mo22291f() {
        return this.f21194m;
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.TexturePreview
    /* renamed from: COUIBaseListPopupWindow_11 */
    public RawTexture mo22292g() {
        return this.f21193l;
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.TexturePreview
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo22532a(RawTexture c2768s) {
        this.f21193l = c2768s;
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.TexturePreview
    /* renamed from: OplusGLSurfaceView_13 */
    public void mo22294i() {
        CameraLog.m12954a("ArcsoftBlurTexturePreview", "newTextures");
        this.f21194m = new RawTexture(this.f21189b, this.f21190c, true);
        this.f21193l = new RawTexture(this.f21189b, this.f21190c, true);
        this.f21200s = true;
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.TexturePreview
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo22280a(GLCanvas interfaceC2757h) {
        RawTexture c2768s = this.f21194m;
        if (c2768s != null && !c2768s.m13943n()) {
            this.f21194m.m14193c(interfaceC2757h);
            CameraLog.m12954a("ArcsoftBlurTexturePreview", "prepareTextures, mInputBlurTexture.getId: " + this.f21194m.m13934e());
        }
        RawTexture c2768s2 = this.f21193l;
        if (c2768s2 == null || c2768s2.m13943n()) {
            return;
        }
        this.f21193l.m14193c(interfaceC2757h);
        CameraLog.m12954a("ArcsoftBlurTexturePreview", "prepareTextures, mOutputBlurTexture.getId: " + this.f21193l.m13934e());
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.TexturePreview
    /* renamed from: OplusGLSurfaceView_15 */
    public void mo22295j() {
        CameraLog.m12954a("ArcsoftBlurTexturePreview", "recycleTextures");
        if (this.f21200s) {
            RawTexture c2768s = this.f21194m;
            if (c2768s != null) {
                c2768s.mo13944o();
                this.f21194m = null;
            }
            RawTexture c2768s2 = this.f21193l;
            if (c2768s2 != null) {
                c2768s2.mo13944o();
                this.f21193l = null;
            }
            this.f21200s = false;
        }
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.TexturePreview
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo22278a(int OplusGLSurfaceView_13, int i2) {
        CameraLog.m12954a("ArcsoftBlurTexturePreview", "setSize, height: " + OplusGLSurfaceView_13 + ", width: " + i2);
        this.f21189b = i2;
        this.f21190c = OplusGLSurfaceView_13;
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.TexturePreview
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo22427a(boolean z) {
        CameraLog.m12954a("ArcsoftBlurTexturePreview", "setTextureSizeChanged, sizeChanged: " + z);
        synchronized (this.f21188a) {
            this.f21195n = z;
        }
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.TexturePreview
    /* renamed from: IntrinsicsJvm.kt_4 */
    public void mo22286b(int OplusGLSurfaceView_13) {
        this.f21191d = OplusGLSurfaceView_13;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private boolean m22530b(int OplusGLSurfaceView_13, int i2) {
        if (this.f21197p) {
            int iRelease = this.f21198q.release();
            this.f21197p = false;
            CameraLog.m12967f("ArcsoftBlurTexturePreview", "initSingleBokeh, release X ret: " + iRelease);
        }
        CameraLog.m12954a("ArcsoftBlurTexturePreview", "initSingleBokeh, srcWidth: " + OplusGLSurfaceView_13 + ", srcHeight: " + i2 + ", outWidth: " + OplusGLSurfaceView_13 + ", outHeight: " + i2 + ", format: 10, mCameraId: " + this.f21542f);
        int iInit = this.f21198q.init(OplusGLSurfaceView_13, i2, OplusGLSurfaceView_13, i2, 10, this.f21542f, 1);
        GLES20Canvas.m14010i();
        StringBuilder sb = new StringBuilder();
        sb.append("initSingleBokeh, X ret: ");
        sb.append(iInit);
        CameraLog.m12954a("ArcsoftBlurTexturePreview", sb.toString());
        this.f21197p = iInit == 0;
        return this.f21197p;
    }
}

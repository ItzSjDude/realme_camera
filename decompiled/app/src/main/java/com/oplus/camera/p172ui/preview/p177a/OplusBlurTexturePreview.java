package com.oplus.camera.p172ui.preview.p177a;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.opengl.GLES20;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import com.oplus.camera.CameraLog;
import com.oplus.camera.p146gl.GLES20Canvas;
import com.oplus.camera.p146gl.RawTexture;
import com.oplus.camera.p146gl.GLCanvas;
import com.oplus.camera.p172ui.preview.p177a.TexturePreview;
import com.oplus.camera.p172ui.preview.p177a.TexturePreviewRequest;
import com.oplus.camera.util.OpenGLUtils;
import com.oplus.p110a.OplusBlurProcess;

/* compiled from: OplusBlurTexturePreview.java */
/* renamed from: com.oplus.camera.ui.preview.PlatformImplementations.kt_3.r */
/* loaded from: classes2.dex */
public class OplusBlurTexturePreview extends TexturePreview implements TexturePreviewRequest.IntrinsicsJvm.kt_5 {

    /* renamed from: PlatformImplementations.kt_3 */
    private final Object f21447a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private int f21448b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private int f21449c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private int f21450d;

    /* renamed from: OplusGLSurfaceView_5 */
    private int f21451k;

    /* renamed from: OplusGLSurfaceView_14 */
    private RawTexture f21452l;

    /* renamed from: OplusGLSurfaceView_6 */
    private RawTexture f21453m;

    /* renamed from: OplusGLSurfaceView_11 */
    private boolean f21454n;

    /* renamed from: o */
    private boolean f21455o;

    /* renamed from: p */
    private boolean f21456p;

    /* renamed from: q */
    private OplusBlurProcess f21457q;

    /* renamed from: r */
    private TexturePreviewRequest f21458r;

    /* renamed from: s */
    private boolean f21459s;

    /* renamed from: t */
    private boolean f21460t;

    /* renamed from: u */
    private boolean f21461u;

    /* renamed from: v */
    private Handler f21462v;

    /* renamed from: w */
    private HandlerThread f21463w;

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

    public OplusBlurTexturePreview(Context context) {
        super(context);
        this.f21447a = new Object();
        this.f21448b = 0;
        this.f21449c = 0;
        this.f21450d = -1;
        this.f21451k = -1;
        this.f21452l = null;
        this.f21453m = null;
        this.f21454n = false;
        this.f21455o = false;
        this.f21456p = true;
        this.f21457q = null;
        this.f21458r = null;
        this.f21459s = false;
        this.f21460t = false;
        this.f21461u = false;
        this.f21462v = null;
        this.f21463w = null;
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.TexturePreview
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo22533a(TexturePreview.IntrinsicsJvm.kt_4 bVar) {
        synchronized (this.f21447a) {
            this.f21545i = bVar;
        }
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.TexturePreview
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo22524a(byte[] bArr, int OplusGLSurfaceView_13, int i2) {
        if (this.f21459s) {
            synchronized (this.f21447a) {
                if (this.f21455o) {
                    return;
                }
                if (this.f21457q != null && this.f21458r != null && this.f21545i != null) {
                    this.f21457q.m8751a(bArr, OplusGLSurfaceView_13, i2, this.f21458r.m22334C(), this.f21543g, this.f21545i.mo22931b());
                }
            }
        }
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.TexturePreview
    /* renamed from: PlatformImplementations.kt_3 */
    public boolean mo22283a(int OplusGLSurfaceView_13) {
        if (!mo22673a_(OplusGLSurfaceView_13)) {
            return false;
        }
        synchronized (this.f21447a) {
            if (this.f21458r == null) {
                CameraLog.m12954a("OplusBlurTexturePreview", "canProcess, Engine has not init!");
                return false;
            }
            if (this.f21458r.m22334C() <= 0 && !this.f21455o) {
                CameraLog.m12967f("OplusBlurTexturePreview", "canProcess, facesCount: " + this.f21458r.m22334C());
                return false;
            }
            if (!this.f21458r.m22401r()) {
                CameraLog.m12967f("OplusBlurTexturePreview", "canProcess, not open effect");
                return false;
            }
            if (this.f21461u) {
                return true;
            }
            CameraLog.m12967f("OplusBlurTexturePreview", "canProcess, texture is not inited");
            return false;
        }
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.TexturePreview
    /* renamed from: PlatformImplementations.kt_3 */
    public boolean mo22284a(TexturePreview.PlatformImplementations.kt_3 aVar) {
        int iM8746a;
        if (this.f21458r == null || aVar == null || aVar.f21549c == null || this.f21452l == null) {
            return false;
        }
        if (!this.f21459s) {
            CameraLog.m12966e("OplusBlurTexturePreview", "process, mSTBlurFilter not create, so return!");
            return false;
        }
        RawTexture c2768s = aVar.f21549c;
        int iH = c2768s.m13937h();
        int OplusGLSurfaceView_13 = c2768s.m13938i();
        synchronized (this.f21447a) {
            if (this.f21457q != null) {
                if (this.f21454n && this.f21457q != null) {
                    m22761b(iH, OplusGLSurfaceView_13);
                    this.f21454n = false;
                }
                if (this.f21456p) {
                    this.f21457q.m8755c();
                    this.f21457q.m8744a(6, this.f21455o ? 1.0f : 0.0f);
                    this.f21456p = false;
                }
                GLES20.glViewport(0, 0, iH, OplusGLSurfaceView_13);
                if (!this.f21455o) {
                    this.f21457q.m8744a(0, this.f21458r.m22344a());
                    iM8746a = this.f21457q.m8745a(c2768s.m13934e(), this.f21450d, this.f21451k, new int[]{this.f21452l.m13934e()});
                } else if (this.f21545i != null) {
                    iM8746a = this.f21457q.m8746a(c2768s.m13934e(), iH, OplusGLSurfaceView_13, this.f21458r.m22334C() <= 0 ? null : this.f21545i.mo22931b(), this.f21450d, this.f21451k, new int[]{this.f21452l.m13934e()}, this.f21543g);
                } else {
                    iM8746a = -1;
                }
                GLES20Canvas.m14010i();
            } else {
                iM8746a = -1;
            }
        }
        GLES20.glViewport(0, 0, aVar.f21547a.mo13983d(), aVar.f21547a.mo13984e());
        return iM8746a != -1;
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.TexturePreview
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo22281a(TexturePreviewRequest c3397aa) {
        CameraLog.m12954a("OplusBlurTexturePreview", "createEngine");
        if (-1 == this.f21450d) {
            this.f21450d = OpenGLUtils.m24588a(BitmapFactory.decodeFile("/odm/etc/camera/sensetime/singlut_portrait.png"));
            this.f21451k = OpenGLUtils.m24588a(BitmapFactory.decodeFile("/odm/etc/camera/sensetime/singlut_background.png"));
        }
        if (this.f21463w == null) {
            this.f21463w = new HandlerThread("BlurPreviewHandlerThread");
            this.f21463w.start();
            this.f21462v = new Handler(this.f21463w.getLooper()) { // from class: com.oplus.camera.ui.preview.PlatformImplementations.kt_3.r.1
                @Override // android.os.Handler
                public void handleMessage(Message message) {
                    CameraLog.m12959b("OplusBlurTexturePreview", "mBlurPreviewHandler, handleMessage, msg: " + message.what);
                    int OplusGLSurfaceView_13 = message.what;
                    if (OplusGLSurfaceView_13 != 0) {
                        if (OplusGLSurfaceView_13 != 1) {
                            return;
                        }
                        synchronized (OplusBlurTexturePreview.this.f21447a) {
                            if (OplusBlurTexturePreview.this.f21457q != null) {
                                OplusBlurTexturePreview.this.f21457q.m8748a();
                                OplusBlurTexturePreview.this.f21457q = null;
                            }
                            OplusBlurTexturePreview.this.f21458r = null;
                        }
                        CameraLog.m12954a("OplusBlurTexturePreview", "mBlurPreviewHandler, handleMessage, MSG_DESTROY_BLUR_PREVIEW X");
                        return;
                    }
                    OplusBlurTexturePreview.this.f21459s = false;
                    synchronized (OplusBlurTexturePreview.this.f21447a) {
                        if (OplusBlurTexturePreview.this.f21457q == null) {
                            OplusBlurTexturePreview.this.f21457q = new OplusBlurProcess();
                            OplusBlurTexturePreview.this.f21457q.m8750a(OplusBlurTexturePreview.this.f21455o);
                            OplusBlurTexturePreview.this.f21460t = OplusBlurProcess.m8735a(OplusBlurTexturePreview.this.f21448b, OplusBlurTexturePreview.this.f21449c);
                            OplusBlurTexturePreview.this.f21457q.m8749a(OplusBlurTexturePreview.this.f21546j);
                        }
                        OplusBlurTexturePreview.this.f21459s = OplusBlurTexturePreview.this.f21460t;
                    }
                }
            };
        }
        synchronized (this.f21447a) {
            if (this.f21457q == null) {
                this.f21462v.sendEmptyMessage(0);
            } else {
                this.f21459s = this.f21460t;
            }
            this.f21458r = c3397aa;
            if (this.f21458r != null) {
                this.f21458r.m22355a(this);
            }
        }
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.TexturePreview
    /* renamed from: COUIBaseListPopupWindow_8 */
    public void mo22290e() {
        this.f21544h.m14132a(new Runnable() { // from class: com.oplus.camera.ui.preview.PlatformImplementations.kt_3.r.2
            @Override // java.lang.Runnable
            public void run() {
                CameraLog.m12954a("OplusBlurTexturePreview", "destroyEngine");
                OplusBlurTexturePreview.this.f21459s = false;
                synchronized (OplusBlurTexturePreview.this.f21447a) {
                    if (OplusBlurTexturePreview.this.f21457q != null) {
                        OplusBlurTexturePreview.this.f21457q.m8753b();
                    }
                }
                if (-1 != OplusBlurTexturePreview.this.f21450d) {
                    OpenGLUtils.m24593a(OplusBlurTexturePreview.this.f21450d);
                    OpenGLUtils.m24593a(OplusBlurTexturePreview.this.f21451k);
                    OplusBlurTexturePreview.this.f21450d = -1;
                    OplusBlurTexturePreview.this.f21451k = -1;
                }
                if (OplusBlurTexturePreview.this.f21462v != null) {
                    OplusBlurTexturePreview.this.f21462v.removeCallbacksAndMessages(null);
                    if (OplusBlurTexturePreview.this.f21463w != null && OplusBlurTexturePreview.this.f21463w.isAlive()) {
                        OplusBlurTexturePreview.this.f21462v.sendEmptyMessage(1);
                    }
                }
                if (OplusBlurTexturePreview.this.f21463w != null) {
                    OplusBlurTexturePreview.this.f21463w.quitSafely();
                    OplusBlurTexturePreview.this.f21463w = null;
                }
            }
        });
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.TexturePreview
    /* renamed from: COUIBaseListPopupWindow_12 */
    public RawTexture mo22291f() {
        return this.f21453m;
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.TexturePreview
    /* renamed from: COUIBaseListPopupWindow_11 */
    public RawTexture mo22292g() {
        return this.f21452l;
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.TexturePreview
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo22532a(RawTexture c2768s) {
        this.f21452l = c2768s;
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.TexturePreview
    /* renamed from: OplusGLSurfaceView_13 */
    public void mo22294i() {
        CameraLog.m12954a("OplusBlurTexturePreview", "newTextures");
        this.f21453m = new RawTexture(this.f21448b, this.f21449c, true);
        this.f21452l = new RawTexture(this.f21448b, this.f21449c, true);
        this.f21461u = true;
        synchronized (this.f21447a) {
            this.f21456p = true;
        }
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.TexturePreview
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo22280a(GLCanvas interfaceC2757h) {
        RawTexture c2768s = this.f21453m;
        if (c2768s != null && !c2768s.m13943n()) {
            this.f21453m.m14193c(interfaceC2757h);
            CameraLog.m12954a("OplusBlurTexturePreview", "prepareTextures, mInputBlurTexture.getId: " + this.f21453m.m13934e());
        }
        RawTexture c2768s2 = this.f21452l;
        if (c2768s2 == null || c2768s2.m13943n()) {
            return;
        }
        this.f21452l.m14193c(interfaceC2757h);
        CameraLog.m12954a("OplusBlurTexturePreview", "prepareTextures, mOutputBlurTexture.getId: " + this.f21452l.m13934e());
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.TexturePreview
    /* renamed from: OplusGLSurfaceView_15 */
    public void mo22295j() {
        CameraLog.m12954a("OplusBlurTexturePreview", "recycleTextures");
        if (this.f21461u) {
            RawTexture c2768s = this.f21453m;
            if (c2768s != null) {
                c2768s.mo13944o();
                this.f21453m = null;
            }
            RawTexture c2768s2 = this.f21452l;
            if (c2768s2 != null) {
                c2768s2.mo13944o();
                this.f21452l = null;
            }
            this.f21461u = false;
        }
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.TexturePreview
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo22278a(int OplusGLSurfaceView_13, int i2) {
        CameraLog.m12954a("OplusBlurTexturePreview", "setSize, height: " + OplusGLSurfaceView_13 + ", width: " + i2);
        this.f21448b = i2;
        this.f21449c = OplusGLSurfaceView_13;
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.TexturePreview
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo22427a(boolean z) {
        synchronized (this.f21447a) {
            this.f21454n = z;
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private void m22761b(int OplusGLSurfaceView_13, int i2) {
        OplusBlurProcess c2266a = this.f21457q;
        if (c2266a != null) {
            c2266a.m8754b(OplusGLSurfaceView_13, i2);
        }
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.TexturePreviewRequest.IntrinsicsJvm.kt_5
    /* renamed from: IntrinsicsJvm.kt_4 */
    public void mo22412b(boolean z) {
        synchronized (this.f21447a) {
            if (this.f21455o != z) {
                CameraLog.m12954a("OplusBlurTexturePreview", "onRetentionOpenChanged, isOpen: " + z);
                this.f21455o = z;
                this.f21456p = true;
                if (this.f21457q != null) {
                    this.f21457q.m8750a(z);
                }
            }
        }
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.TexturePreview
    /* renamed from: OplusGLSurfaceView_14 */
    public int mo22560l() {
        int OplusGLSurfaceView_13;
        synchronized (this.f21447a) {
            OplusGLSurfaceView_13 = this.f21455o ? 1 : 0;
        }
        return OplusGLSurfaceView_13;
    }
}

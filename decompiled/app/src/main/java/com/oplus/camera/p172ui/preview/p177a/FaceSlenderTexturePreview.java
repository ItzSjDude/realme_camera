package com.oplus.camera.p172ui.preview.p177a;

import android.content.Context;
import com.oplus.camera.CameraLog;
import com.oplus.camera.algovisualization.AlgoListProcessor;
import com.oplus.camera.aps.config.CameraConfig;
import com.oplus.camera.aps.config.ConfigDataBase;
import com.oplus.camera.p146gl.GLES20Canvas;
import com.oplus.camera.p146gl.RawTexture;
import com.oplus.camera.p146gl.GLCanvas;
import com.oplus.camera.p153l.RegionCommonFeatureAdapter;
import com.oplus.camera.p172ui.preview.p177a.TexturePreview;
import com.oplus.camera.util.Util;
import com.oplus.ocs.camera.OplusFaceBeautyPreviewHelper;

/* compiled from: FaceSlenderTexturePreview.java */
/* renamed from: com.oplus.camera.ui.preview.PlatformImplementations.kt_3.COUIBaseListPopupWindow_10 */
/* loaded from: classes2.dex */
public class FaceSlenderTexturePreview extends TexturePreview {

    /* renamed from: PlatformImplementations.kt_3 */
    public static String f21232a = "0ms";

    /* renamed from: IntrinsicsJvm.kt_4 */
    private RawTexture f21233b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private RawTexture f21234c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private TexturePreviewRequest f21235d;

    /* renamed from: OplusGLSurfaceView_5 */
    private OplusFaceBeautyPreviewHelper f21236k;

    /* renamed from: OplusGLSurfaceView_14 */
    private boolean f21237l;

    /* renamed from: OplusGLSurfaceView_6 */
    private int f21238m;

    /* renamed from: OplusGLSurfaceView_11 */
    private int f21239n;

    /* renamed from: o */
    private boolean f21240o;

    /* renamed from: p */
    private boolean f21241p;

    /* renamed from: q */
    private int f21242q;

    /* renamed from: r */
    private int f21243r;

    /* renamed from: s */
    private float f21244s;

    /* renamed from: t */
    private final Object f21245t;

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
        return 4;
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.TexturePreview
    /* renamed from: COUIBaseListPopupWindow_10 */
    public boolean mo22293h() {
        return false;
    }

    public FaceSlenderTexturePreview(Context context) {
        super(context);
        this.f21233b = null;
        this.f21234c = null;
        this.f21235d = null;
        this.f21236k = null;
        this.f21237l = false;
        this.f21238m = 0;
        this.f21239n = 0;
        this.f21240o = false;
        this.f21241p = false;
        this.f21242q = -1;
        this.f21243r = 1;
        this.f21244s = 1.0f;
        this.f21245t = new Object();
        this.f21242q = CameraConfig.getConfigIntValue(ConfigDataBase.KEY_FACE_BEAUTY_VERSION_CODE);
        if (CameraLog.m12957a()) {
            this.f21243r = 2;
        }
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.TexturePreview
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo22524a(byte[] bArr, int OplusGLSurfaceView_13, int i2) {
        synchronized (this.f21245t) {
            if (this.f21236k != null && bArr != null) {
                this.f21236k.updataMetaParams(bArr);
            }
        }
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.TexturePreview
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo22558a(byte[] bArr, byte[] bArr2, int OplusGLSurfaceView_13, int i2) {
        synchronized (this.f21245t) {
            if (this.f21236k != null) {
                this.f21236k.updataMetaParams(bArr);
                this.f21236k.updataFfd(bArr2);
            }
        }
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.TexturePreview
    /* renamed from: PlatformImplementations.kt_3 */
    public boolean mo22284a(TexturePreview.PlatformImplementations.kt_3 aVar) {
        long jM11591a = AlgoListProcessor.m11591a();
        if (this.f21235d == null || aVar == null || aVar.f21549c == null || !aVar.f21554h) {
            CameraLog.m12954a("FaceSlenderTexturePreview", "process, mReques: " + this.f21235d + ", frameInfo: " + aVar);
            return false;
        }
        if (this.f21237l) {
            m22557b(aVar.f21549c.m13937h(), aVar.f21549c.m13938i());
            this.f21237l = false;
        }
        if (this.f21236k == null) {
            return false;
        }
        CameraLog.m12952a("FaceSlenderTexturePreview.process");
        this.f21236k.setPreviewParams("preview_face_beauty_enable", FaceBeautyHelp.m22551a(this.f21235d.m22389j() != 0));
        this.f21236k.setPreviewParams("preview_makeup_type", this.f21235d.m22391k());
        this.f21236k.setPreviewParams("preview_ai_video_state", String.valueOf(this.f21235d.m22342K()));
        this.f21236k.setPreviewParams("preview_face_dr_state", String.valueOf(this.f21235d.m22343L()));
        if ("none".equals(this.f21235d.m22391k())) {
            this.f21236k.setPreviewParams("preview_makeup_value", String.valueOf(0));
        } else {
            this.f21236k.setPreviewParams("preview_makeup_value", String.valueOf(this.f21235d.m22393l()));
        }
        CameraLog.m12954a("FaceSlenderTexturePreview", "process, makeup type: " + this.f21235d.m22391k() + ", makeup level: " + this.f21235d.m22393l());
        this.f21236k.updataPreviewParams(this.f21235d.m22404u());
        this.f21236k.process(aVar.f21549c.m13934e(), new int[]{this.f21234c.m13934e()}, null, this.f21235d.m22400q());
        CameraLog.m12958b("FaceSlenderTexturePreview.process");
        float zoomScale = this.f21236k.getZoomScale();
        if (this.f21235d.m22339H() != null && Float.compare(zoomScale, this.f21244s) != 0) {
            CameraLog.m12954a("FaceSlenderTexturePreview", "process, zoomScale: " + zoomScale);
            this.f21244s = zoomScale;
            this.f21235d.m22339H().mo10416a(zoomScale);
        }
        f21232a = AlgoListProcessor.m11592a(jM11591a, AlgoListProcessor.m11591a());
        return true;
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.TexturePreview
    /* renamed from: OplusGLSurfaceView_5 */
    public int mo22559k() {
        OplusFaceBeautyPreviewHelper oplusFaceBeautyPreviewHelper = this.f21236k;
        if (oplusFaceBeautyPreviewHelper != null) {
            return oplusFaceBeautyPreviewHelper.reset();
        }
        return -1;
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.TexturePreview
    /* renamed from: PlatformImplementations.kt_3 */
    public boolean mo22283a(int OplusGLSurfaceView_13) {
        int iM22389j;
        if (!mo22673a_(OplusGLSurfaceView_13)) {
            return false;
        }
        if (this.f21234c == null || this.f21233b == null) {
            CameraLog.m12966e("FaceSlenderTexturePreview", "canProcess, mOutputTexture or mInputTexture is null, mOutputTexture: " + this.f21234c + ", mInputTexture: " + this.f21233b);
            return false;
        }
        if (!this.f21240o) {
            CameraLog.m12966e("FaceSlenderTexturePreview", "canProcess, texture is not inited");
            return false;
        }
        if (this.f21235d == null) {
            CameraLog.m12966e("FaceSlenderTexturePreview", "canProcess, mRequest is null");
            return false;
        }
        try {
        } catch (Exception COUIBaseListPopupWindow_8) {
            COUIBaseListPopupWindow_8.printStackTrace();
            iM22389j = 0;
        }
        if (!Util.m24169C() && this.f21235d.m22334C() == 0 && this.f21235d.m22339H() != null && !this.f21235d.m22339H().mo10417a() && !this.f21543g) {
            return false;
        }
        iM22389j = this.f21235d.m22389j();
        boolean z = (iM22389j == 0 && "none".equals(this.f21235d.m22391k())) ? false : true;
        if (!this.f21241p && z) {
            mo22559k();
        }
        this.f21241p = z;
        return z;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private void m22557b(int OplusGLSurfaceView_13, int i2) {
        CameraLog.m12954a("FaceSlenderTexturePreview", "initOplusFaceBeautyPreview, textureWidth: " + OplusGLSurfaceView_13 + ", textureHeight: " + i2 + ", facebeauty version: " + this.f21242q + ", isMakeupSupport: " + this.f21235d.m22396m() + ", makeupType: " + this.f21235d.m22391k());
        CameraLog.m12952a("initOplusFaceBeautyPreview");
        boolean zMo10417a = this.f21235d.m22339H() != null ? this.f21235d.m22339H().mo10417a() : false;
        synchronized (this.f21245t) {
            if (this.f21236k != null) {
                this.f21544h.m14133g();
                this.f21236k.destroy();
            }
            this.f21236k = new OplusFaceBeautyPreviewHelper();
            this.f21236k.setPreviewParams("preview_makeup_support", FaceBeautyHelp.m22551a(this.f21235d.m22396m()));
            this.f21236k.setPreviewParams("preview_makeup_type", this.f21235d.m22391k());
            this.f21236k.setPreviewParams("preview_ai_video_state", String.valueOf(this.f21235d.m22342K()));
            this.f21236k.setPreviewParams("preview_face_dr_state", String.valueOf(this.f21235d.m22343L()));
            if ("none".equals(this.f21235d.m22391k())) {
                this.f21236k.setPreviewParams("preview_makeup_value", String.valueOf(0));
            } else {
                this.f21236k.setPreviewParams("preview_makeup_value", String.valueOf(this.f21235d.m22393l()));
            }
            this.f21236k.init(OplusGLSurfaceView_13, i2, this.f21242q, this.f21243r, RegionCommonFeatureAdapter.m14539h() ? "cn" : "", Util.m24360aw(), Util.m24361ax(), zMo10417a || this.f21543g, true, this.f21235d.m22403t(), this.f21235d.m22333B());
        }
        CameraLog.m12958b("initOplusFaceBeautyPreview");
        CameraLog.m12954a("FaceSlenderTexturePreview", "initOplusFaceBeautyPreview, X");
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.TexturePreview
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo22427a(boolean z) {
        CameraLog.m12954a("FaceSlenderTexturePreview", "setTextureSizeChanged, sizeChanged: " + z);
        this.f21237l = z;
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.TexturePreview
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo22281a(TexturePreviewRequest c3397aa) {
        CameraLog.m12954a("FaceSlenderTexturePreview", "createEngine");
        this.f21235d = c3397aa;
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.TexturePreview
    /* renamed from: COUIBaseListPopupWindow_8 */
    public void mo22290e() {
        this.f21544h.m14132a(new Runnable() { // from class: com.oplus.camera.ui.preview.PlatformImplementations.kt_3.COUIBaseListPopupWindow_10.1
            @Override // java.lang.Runnable
            public void run() {
                CameraLog.m12954a("FaceSlenderTexturePreview", "destroyEngine");
                if (FaceSlenderTexturePreview.this.f21544h != null) {
                    synchronized (FaceSlenderTexturePreview.this.f21245t) {
                        CameraLog.m12954a("FaceSlenderTexturePreview", "destroyEngine, mOplusFaceBeautyPreviewHelper: " + FaceSlenderTexturePreview.this.f21236k);
                        if (FaceSlenderTexturePreview.this.f21236k != null) {
                            FaceSlenderTexturePreview.this.f21544h.m14133g();
                            FaceSlenderTexturePreview.this.f21236k.destroy();
                            GLES20Canvas.m14010i();
                            FaceSlenderTexturePreview.this.f21236k = null;
                        }
                    }
                    CameraLog.m12954a("FaceSlenderTexturePreview", "destroyEngine X");
                    return;
                }
                CameraLog.m12967f("FaceSlenderTexturePreview", "destroyEngine, , mGLRootView is null ");
            }
        });
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.TexturePreview
    /* renamed from: OplusGLSurfaceView_13 */
    public void mo22294i() {
        CameraLog.m12954a("FaceSlenderTexturePreview", "newTextures");
        this.f21233b = new RawTexture(this.f21238m, this.f21239n, true);
        this.f21234c = new RawTexture(this.f21238m, this.f21239n, true);
        this.f21240o = true;
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.TexturePreview
    /* renamed from: COUIBaseListPopupWindow_12 */
    public RawTexture mo22291f() {
        return this.f21233b;
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.TexturePreview
    /* renamed from: COUIBaseListPopupWindow_11 */
    public RawTexture mo22292g() {
        return this.f21234c;
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.TexturePreview
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo22532a(RawTexture c2768s) {
        this.f21234c = c2768s;
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.TexturePreview
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo22280a(GLCanvas interfaceC2757h) {
        RawTexture c2768s = this.f21233b;
        if (c2768s != null && !c2768s.m13943n()) {
            this.f21233b.m14193c(interfaceC2757h);
            CameraLog.m12954a("FaceSlenderTexturePreview", "prepareTextures, mInputTexture id_renamed: " + this.f21233b.m13934e());
        }
        RawTexture c2768s2 = this.f21234c;
        if (c2768s2 == null || c2768s2.m13943n()) {
            return;
        }
        this.f21234c.m14193c(interfaceC2757h);
        CameraLog.m12954a("FaceSlenderTexturePreview", "prepareTextures, mOutputTexture id_renamed: " + this.f21234c.m13934e());
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.TexturePreview
    /* renamed from: OplusGLSurfaceView_15 */
    public void mo22295j() {
        if (this.f21240o) {
            if (this.f21233b != null) {
                CameraLog.m12954a("FaceSlenderTexturePreview", "recycleTextures, mInputTexture id_renamed: " + this.f21233b.m13934e());
                this.f21233b.mo13944o();
                this.f21233b = null;
            }
            if (this.f21234c != null) {
                CameraLog.m12954a("FaceSlenderTexturePreview", "recycleTextures, mOutputTexture id_renamed: " + this.f21234c.m13934e());
                this.f21234c.mo13944o();
                this.f21234c = null;
            }
            this.f21240o = false;
        }
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.TexturePreview
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo22278a(int OplusGLSurfaceView_13, int i2) {
        CameraLog.m12954a("FaceSlenderTexturePreview", "setSize, height: " + OplusGLSurfaceView_13 + ", width: " + i2);
        this.f21238m = i2;
        this.f21239n = OplusGLSurfaceView_13;
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.TexturePreview
    /* renamed from: OplusGLSurfaceView_14 */
    public int mo22560l() {
        return this.f21543g ? 2 : 0;
    }
}

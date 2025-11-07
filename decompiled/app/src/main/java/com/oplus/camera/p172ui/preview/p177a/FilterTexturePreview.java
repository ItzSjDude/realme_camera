package com.oplus.camera.p172ui.preview.p177a;

import android.content.Context;
import com.oplus.camera.CameraLog;
import com.oplus.camera.algovisualization.AlgoListProcessor;
import com.oplus.camera.p146gl.RawTexture;
import com.oplus.camera.p146gl.GLCanvas;
import com.oplus.camera.p172ui.preview.p177a.TexturePreview;
import com.oplus.camera.p172ui.preview.p177a.TexturePreviewRequest;

/* compiled from: FilterTexturePreview.java */
/* renamed from: com.oplus.camera.ui.preview.PlatformImplementations.kt_3.OplusGLSurfaceView_14 */
/* loaded from: classes2.dex */
public class FilterTexturePreview extends TexturePreview implements TexturePreviewRequest.IntrinsicsJvm.kt_3 {

    /* renamed from: PlatformImplementations.kt_3 */
    public static String f21341a = "0ms";

    /* renamed from: IntrinsicsJvm.kt_4 */
    private PlatformImplementations.kt_3 f21342b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private int f21343c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private int f21344d;

    /* renamed from: OplusGLSurfaceView_5 */
    private RawTexture f21345k;

    /* renamed from: OplusGLSurfaceView_14 */
    private RawTexture f21346l;

    /* renamed from: OplusGLSurfaceView_6 */
    private TexturePreviewRequest f21347m;

    /* renamed from: OplusGLSurfaceView_11 */
    private AbstractFilterSdk f21348n;

    /* renamed from: o */
    private AbstractFilterSdk f21349o;

    /* renamed from: p */
    private boolean f21350p;

    /* renamed from: q */
    private boolean f21351q;

    /* renamed from: r */
    private String f21352r;

    /* renamed from: s */
    private boolean f21353s;

    /* renamed from: t */
    private String f21354t;

    /* compiled from: FilterTexturePreview.java */
    /* renamed from: com.oplus.camera.ui.preview.PlatformImplementations.kt_3.OplusGLSurfaceView_14$PlatformImplementations.kt_3 */
    public enum PlatformImplementations.kt_3 {
        Polarr,
        Anc
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
        return 2;
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.TexturePreview
    /* renamed from: COUIBaseListPopupWindow_10 */
    public boolean mo22293h() {
        return false;
    }

    public FilterTexturePreview(Context context) {
        super(context);
        this.f21342b = PlatformImplementations.kt_3.Polarr;
        this.f21343c = 0;
        this.f21344d = 0;
        this.f21345k = null;
        this.f21346l = null;
        this.f21347m = null;
        this.f21348n = null;
        this.f21349o = null;
        this.f21350p = false;
        this.f21351q = false;
        this.f21352r = "default";
        this.f21353s = false;
        this.f21354t = "";
        this.f21348n = new PolarrFilterSdk();
        this.f21349o = new AncFilterSdk();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m22658a(PlatformImplementations.kt_3 aVar) {
        this.f21342b = aVar;
    }

    /* renamed from: q */
    private AbstractFilterSdk m22657q() {
        if (PlatformImplementations.kt_3.Polarr == this.f21342b) {
            return this.f21348n;
        }
        return this.f21349o;
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.TexturePreview
    /* renamed from: PlatformImplementations.kt_3 */
    public boolean mo22284a(TexturePreview.PlatformImplementations.kt_3 aVar) {
        long jM11591a = AlgoListProcessor.m11591a();
        if (this.f21347m == null || aVar == null || aVar.f21549c == null) {
            return false;
        }
        String str = this.f21354t;
        boolean zM22397n = this.f21347m.m22397n();
        if ("default".equals(str)) {
            return false;
        }
        m22657q().mo22237a(this.f21546j, mo22292g().m13937h(), mo22292g().m13938i(), this.f21350p);
        CameraLog.m12952a("Filter.process");
        m22657q().mo22236a(this.f21346l.m13934e());
        m22657q().mo22242b(aVar.f21549c.m13934e());
        if (this.f21350p || !str.equals(this.f21352r)) {
            if (zM22397n) {
                m22657q().mo22235a(-0.7f, 0.44f, 0.83f, 0.25f, -0.74f, 0.98f);
            }
            m22657q().mo22238a(str);
            this.f21352r = str;
        }
        m22657q().mo22241b();
        if (zM22397n) {
            m22657q().mo22243c();
        } else {
            m22657q().mo22244d();
        }
        this.f21350p = false;
        CameraLog.m12958b("Filter.process");
        f21341a = AlgoListProcessor.m11592a(jM11591a, AlgoListProcessor.m11591a());
        return true;
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.TexturePreview
    /* renamed from: PlatformImplementations.kt_3 */
    public boolean mo22283a(int OplusGLSurfaceView_13) {
        if (this.f21347m == null || "default".equals(this.f21354t) || !this.f21353s || !mo22673a_(OplusGLSurfaceView_13)) {
            return false;
        }
        if (this.f21346l == null || this.f21345k == null) {
            CameraLog.m12966e("FilterTexturePreview", "canProcess, mOutputTexture or mInputTexture is null, mOutputTexture: " + this.f21346l + ", mInputTexture: " + this.f21345k);
            return false;
        }
        if (this.f21351q) {
            return true;
        }
        CameraLog.m12967f("FilterTexturePreview", "canProcess, texture is not inited");
        return false;
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.TexturePreview
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo22427a(boolean z) {
        this.f21350p = z;
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.TexturePreview
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo22281a(TexturePreviewRequest c3397aa) {
        CameraLog.m12954a("FilterTexturePreview", "createEngine");
        this.f21347m = c3397aa;
        TexturePreviewRequest c3397aa2 = this.f21347m;
        if (c3397aa2 != null) {
            c3397aa2.m22354a(this);
        }
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.TexturePreview
    /* renamed from: COUIBaseListPopupWindow_8 */
    public void mo22290e() {
        this.f21544h.m14132a(new Runnable() { // from class: com.oplus.camera.ui.preview.PlatformImplementations.kt_3.OplusGLSurfaceView_14.1
            @Override // java.lang.Runnable
            public void run() {
                CameraLog.m12954a("FilterTexturePreview", "destroyEngine");
                CameraLog.m12967f("FilterTexturePreview", "destroyEngine, mReques: " + FilterTexturePreview.this.f21347m + ", mGLRootView: " + FilterTexturePreview.this.f21544h);
                FilterTexturePreview.this.f21348n.mo22245e();
                FilterTexturePreview.this.f21349o.mo22245e();
                if (FilterTexturePreview.this.f21347m != null) {
                    FilterTexturePreview.this.f21347m.m22338G();
                    FilterTexturePreview.this.f21347m = null;
                }
                CameraLog.m12954a("FilterTexturePreview", "destroyEngine X");
            }
        });
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.TexturePreview
    /* renamed from: COUIBaseListPopupWindow_12 */
    public RawTexture mo22291f() {
        return this.f21345k;
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.TexturePreview
    /* renamed from: COUIBaseListPopupWindow_11 */
    public RawTexture mo22292g() {
        return this.f21346l;
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.TexturePreview
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo22532a(RawTexture c2768s) {
        this.f21346l = c2768s;
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.TexturePreview
    /* renamed from: OplusGLSurfaceView_13 */
    public void mo22294i() {
        CameraLog.m12954a("FilterTexturePreview", "newTextures");
        this.f21345k = new RawTexture(this.f21343c, this.f21344d, true);
        this.f21346l = new RawTexture(this.f21343c, this.f21344d, true);
        this.f21351q = true;
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.TexturePreview
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo22280a(GLCanvas interfaceC2757h) {
        RawTexture c2768s = this.f21345k;
        if (c2768s != null && !c2768s.m13943n()) {
            this.f21345k.m14193c(interfaceC2757h);
            CameraLog.m12954a("FilterTexturePreview", "prepareTextures, mInputTexture id_renamed: " + this.f21345k.m13934e());
        }
        RawTexture c2768s2 = this.f21346l;
        if (c2768s2 == null || c2768s2.m13943n()) {
            return;
        }
        this.f21346l.m14193c(interfaceC2757h);
        CameraLog.m12954a("FilterTexturePreview", "prepareTextures, mOutputTexture id_renamed: " + this.f21346l.m13934e());
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.TexturePreview
    /* renamed from: OplusGLSurfaceView_15 */
    public void mo22295j() {
        if (this.f21351q) {
            if (this.f21345k != null) {
                CameraLog.m12954a("FilterTexturePreview", "recycleTextures, mInputTexture id_renamed: " + this.f21345k.m13934e());
                this.f21345k.mo13944o();
                this.f21345k = null;
            }
            if (this.f21346l != null) {
                CameraLog.m12954a("FilterTexturePreview", "recycleTextures, mOutputTexture id_renamed: " + this.f21346l.m13934e());
                this.f21346l.mo13944o();
                this.f21346l = null;
            }
            this.f21351q = false;
        }
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.TexturePreview
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo22278a(int OplusGLSurfaceView_13, int i2) {
        CameraLog.m12954a("FilterTexturePreview", "setSize, height: " + OplusGLSurfaceView_13 + ", width: " + i2);
        this.f21343c = i2;
        this.f21344d = OplusGLSurfaceView_13;
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.TexturePreviewRequest.IntrinsicsJvm.kt_3
    /* renamed from: IntrinsicsJvm.kt_4 */
    public void mo22411b(boolean z) {
        this.f21353s = z;
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.TexturePreviewRequest.IntrinsicsJvm.kt_3
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo22410a(String str) {
        this.f21354t = str;
    }
}

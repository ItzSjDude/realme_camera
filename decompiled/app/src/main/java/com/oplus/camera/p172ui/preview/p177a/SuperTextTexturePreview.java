package com.oplus.camera.p172ui.preview.p177a;

import android.content.Context;
import com.oplus.camera.CameraLog;
import com.oplus.camera.PhoneMotionState;
import com.oplus.camera.algovisualization.AlgoListProcessor;
import com.oplus.camera.p146gl.ExtTexture;
import com.oplus.camera.p146gl.RawTexture;
import com.oplus.camera.p146gl.GLCanvas;
import com.oplus.camera.p171u.DetectResult;
import com.oplus.camera.p172ui.preview.p177a.TexturePreview;

/* compiled from: SuperTextTexturePreview.java */
/* renamed from: com.oplus.camera.ui.preview.PlatformImplementations.kt_3.x */
/* loaded from: classes2.dex */
public class SuperTextTexturePreview extends TexturePreview {

    /* renamed from: PlatformImplementations.kt_3 */
    public static String f21530a = "0ms";

    /* renamed from: IntrinsicsJvm.kt_4 */
    private Context f21531b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private TexturePreviewRequest f21532c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private RawTexture f21533d;

    /* renamed from: OplusGLSurfaceView_5 */
    private boolean f21534k;

    /* renamed from: OplusGLSurfaceView_14 */
    private int f21535l;

    /* renamed from: OplusGLSurfaceView_6 */
    private int f21536m;

    /* renamed from: OplusGLSurfaceView_11 */
    private int f21537n;

    /* renamed from: o */
    private int f21538o;

    /* renamed from: p */
    private final Object f21539p;

    /* renamed from: q */
    private long f21540q;

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
        return 64;
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.TexturePreview
    /* renamed from: COUIBaseListPopupWindow_8 */
    public void mo22290e() {
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.TexturePreview
    /* renamed from: COUIBaseListPopupWindow_12 */
    public RawTexture mo22291f() {
        return null;
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.TexturePreview
    /* renamed from: COUIBaseListPopupWindow_10 */
    public boolean mo22293h() {
        return false;
    }

    public SuperTextTexturePreview(Context context) {
        super(context);
        this.f21531b = null;
        this.f21533d = null;
        this.f21534k = false;
        this.f21535l = 0;
        this.f21536m = 0;
        this.f21537n = 0;
        this.f21538o = 1;
        this.f21539p = new Object();
        this.f21540q = 0L;
        this.f21531b = context;
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.TexturePreview
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo22281a(TexturePreviewRequest c3397aa) {
        this.f21532c = c3397aa;
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.TexturePreview
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo22278a(int OplusGLSurfaceView_13, int i2) {
        CameraLog.m12954a("SuperTextTexturePreview", "setSize, height: " + i2 + ", width: " + OplusGLSurfaceView_13);
        this.f21535l = OplusGLSurfaceView_13;
        this.f21536m = i2;
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.TexturePreview
    /* renamed from: COUIBaseListPopupWindow_11 */
    public RawTexture mo22292g() {
        return this.f21533d;
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.TexturePreview
    /* renamed from: OplusGLSurfaceView_13 */
    public void mo22294i() {
        this.f21533d = new RawTexture(this.f21535l, this.f21536m, true);
        this.f21534k = true;
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.TexturePreview
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo22280a(GLCanvas interfaceC2757h) {
        RawTexture c2768s = this.f21533d;
        if (c2768s == null || c2768s.m13943n()) {
            return;
        }
        this.f21533d.m14193c(interfaceC2757h);
        CameraLog.m12954a("SuperTextTexturePreview", "prepareTextures, mOutputBlurTexture.getId: " + this.f21533d.m13934e());
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.TexturePreview
    /* renamed from: OplusGLSurfaceView_15 */
    public void mo22295j() {
        CameraLog.m12954a("SuperTextTexturePreview", "recycleTextures");
        if (this.f21534k) {
            RawTexture c2768s = this.f21533d;
            if (c2768s != null) {
                c2768s.mo13944o();
                this.f21533d = null;
            }
            this.f21534k = false;
        }
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.TexturePreview
    /* renamed from: PlatformImplementations.kt_3 */
    public boolean mo22283a(int OplusGLSurfaceView_13) {
        TexturePreviewRequest c3397aa;
        return mo22673a_(OplusGLSurfaceView_13) && this.f21534k && (c3397aa = this.f21532c) != null && c3397aa.m22399p();
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.TexturePreview
    /* renamed from: PlatformImplementations.kt_3 */
    public boolean mo22284a(TexturePreview.PlatformImplementations.kt_3 aVar) {
        long jM11591a = AlgoListProcessor.m11591a();
        if (this.f21532c == null) {
            return false;
        }
        ExtTexture c2756g = aVar.f21548b;
        if (this.f21533d == null) {
            return false;
        }
        synchronized (this.f21539p) {
            int OplusGLSurfaceView_13 = this.f21538o;
            this.f21538o = OplusGLSurfaceView_13 + 1;
            if (OplusGLSurfaceView_13 % 3 == 0 && !PhoneMotionState.m24833b()) {
                if (this.f21537n % 180 == 0) {
                    this.f21545i.mo22925a(c2756g.m13934e(), c2756g.m13938i(), c2756g.m13937h(), this.f21533d.m13934e(), this.f21537n, true, this.f21540q);
                } else {
                    this.f21545i.mo22925a(c2756g.m13934e(), c2756g.m13937h(), c2756g.m13938i(), this.f21533d.m13934e(), this.f21537n, true, this.f21540q);
                }
            } else if (PhoneMotionState.m24833b()) {
                this.f21545i.mo22929a((DetectResult) null);
            }
        }
        f21530a = AlgoListProcessor.m11592a(jM11591a, AlgoListProcessor.m11591a());
        return false;
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.TexturePreview
    /* renamed from: IntrinsicsJvm.kt_4 */
    public void mo22286b(int OplusGLSurfaceView_13) {
        synchronized (this.f21539p) {
            this.f21537n = OplusGLSurfaceView_13;
        }
    }

    @Override // com.oplus.camera.p172ui.preview.p177a.TexturePreview
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo22957a(long OplusGLSurfaceView_15) {
        super.mo22957a(OplusGLSurfaceView_15);
        synchronized (this.f21539p) {
            this.f21540q = OplusGLSurfaceView_15;
        }
    }
}

package com.oplus.camera.p146gl;

import android.hardware.camera2.CaptureResult;
import com.oplus.camera.CameraLog;

/* compiled from: RawTexture.java */
/* renamed from: com.oplus.camera.gl.s */
/* loaded from: classes2.dex */
public class RawTexture extends BasicTexture {

    /* renamed from: COUIBaseListPopupWindow_10 */
    private final boolean f14181h;

    /* renamed from: OplusGLSurfaceView_13 */
    private boolean f14182i;

    /* renamed from: OplusGLSurfaceView_15 */
    private CaptureResult f14183j = null;

    /* renamed from: OplusGLSurfaceView_5 */
    private float[] f14184k = null;

    @Override // com.oplus.camera.p146gl.BasicTexture
    /* renamed from: OplusGLSurfaceView_6 */
    public int mo13942m() {
        return 3553;
    }

    @Override // com.oplus.camera.p146gl.BasicTexture
    /* renamed from: q */
    public void mo13946q() {
    }

    public RawTexture(int OplusGLSurfaceView_13, int i2, boolean z) {
        this.f14181h = z;
        m13925a(OplusGLSurfaceView_13, i2);
    }

    @Override // com.oplus.camera.p146gl.Texture
    /* renamed from: r */
    public boolean mo13954r() {
        return this.f14181h;
    }

    @Override // com.oplus.camera.p146gl.BasicTexture
    /* renamed from: IntrinsicsJvm.kt_5 */
    public boolean mo13933d() {
        return this.f14182i;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m14193c(GLCanvas interfaceC2757h) {
        this.f13969c = interfaceC2757h.mo13957a().mo14020b();
        interfaceC2757h.mo13967a(this, 6408, 5121);
        interfaceC2757h.mo13980b(this);
        this.f13970d = 1;
        m13927a(interfaceC2757h);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m14189a(GLCanvas interfaceC2757h, int OplusGLSurfaceView_13) {
        this.f13969c = OplusGLSurfaceView_13;
        interfaceC2757h.mo13981b(this, 6408, 5121);
        interfaceC2757h.mo13980b(this);
        this.f13970d = 1;
        m13927a(interfaceC2757h);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m14190a(GLCanvas interfaceC2757h, int OplusGLSurfaceView_13, int i2, int i3) {
        this.f13969c = OplusGLSurfaceView_13;
        m13925a(i2, i3);
        this.f13970d = 1;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m14188a(CaptureResult captureResult) {
        this.f14183j = captureResult;
    }

    /* renamed from: s */
    public CaptureResult m14194s() {
        return this.f14183j;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m14191a(float[] fArr) {
        this.f14184k = fArr;
    }

    /* renamed from: t */
    public float[] m14195t() {
        return this.f14184k;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public boolean m14192a(RawTexture c2768s) {
        return c2768s != null && this.f13967a == c2768s.mo13935f() && this.f13968b == c2768s.mo13936g();
    }

    @Override // com.oplus.camera.p146gl.BasicTexture
    /* renamed from: IntrinsicsJvm.kt_4 */
    protected boolean mo13931b(GLCanvas interfaceC2757h) {
        if (m13943n()) {
            return true;
        }
        CameraLog.m12966e("RawTexture", "onBind, lost the content due to context change");
        return false;
    }

    public String toString() {
        return "{timestamp: " + m13939j() + ", preview timestamp: " + m13940k() + ", id_renamed: " + m13934e() + "}";
    }
}

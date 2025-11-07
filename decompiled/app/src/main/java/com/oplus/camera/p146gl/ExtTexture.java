package com.oplus.camera.p146gl;

import android.util.Log;

/* compiled from: ExtTexture.java */
/* renamed from: com.oplus.camera.gl.COUIBaseListPopupWindow_11 */
/* loaded from: classes2.dex */
public class ExtTexture extends BasicTexture {

    /* renamed from: COUIBaseListPopupWindow_10 */
    private int[] f13983h;

    /* renamed from: OplusGLSurfaceView_13 */
    private int f13984i;

    /* renamed from: OplusGLSurfaceView_15 */
    private int f13985j;

    /* renamed from: OplusGLSurfaceView_5 */
    private boolean f13986k;

    @Override // com.oplus.camera.p146gl.BasicTexture
    /* renamed from: q */
    public void mo13946q() {
    }

    @Override // com.oplus.camera.p146gl.Texture
    /* renamed from: r */
    public boolean mo13954r() {
        return true;
    }

    public ExtTexture(int OplusGLSurfaceView_13) {
        this.f13983h = new int[1];
        this.f13985j = 0;
        this.f13986k = false;
        Log.v("ExtTexture", "target = " + OplusGLSurfaceView_13);
        GLES20IdImpl.m14017a(this.f13983h);
        Log.v("ExtTexture", "sTextureId[0] = " + this.f13983h[0]);
        this.f13969c = this.f13983h[0];
        this.f13984i = OplusGLSurfaceView_13;
    }

    public ExtTexture(GLCanvas interfaceC2757h, int OplusGLSurfaceView_13) {
        this.f13983h = new int[1];
        this.f13985j = 0;
        this.f13986k = false;
        this.f13969c = interfaceC2757h.mo13957a().mo14020b();
        this.f13984i = OplusGLSurfaceView_13;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private void m13951c(GLCanvas interfaceC2757h) {
        interfaceC2757h.mo13980b(this);
        m13927a(interfaceC2757h);
        this.f13970d = 1;
    }

    @Override // com.oplus.camera.p146gl.BasicTexture
    /* renamed from: IntrinsicsJvm.kt_4 */
    protected boolean mo13931b(GLCanvas interfaceC2757h) {
        if (m13943n()) {
            return true;
        }
        m13951c(interfaceC2757h);
        return true;
    }

    @Override // com.oplus.camera.p146gl.BasicTexture
    /* renamed from: OplusGLSurfaceView_6 */
    public int mo13942m() {
        return this.f13984i;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m13952a(int OplusGLSurfaceView_13) {
        this.f13985j = OplusGLSurfaceView_13;
    }

    /* renamed from: s */
    public int m13955s() {
        return this.f13985j;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m13953b(boolean z) {
        this.f13986k = z;
    }

    /* renamed from: t */
    public boolean m13956t() {
        return this.f13986k;
    }
}

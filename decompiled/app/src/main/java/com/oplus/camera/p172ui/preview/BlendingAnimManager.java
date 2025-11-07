package com.oplus.camera.p172ui.preview;

import android.os.SystemClock;
import android.renderscript.Matrix4f;
import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;
import com.oplus.camera.CameraLog;
import com.oplus.camera.p146gl.ExtTexture;
import com.oplus.camera.p146gl.RawTexture;
import com.oplus.camera.p146gl.GLCanvas;
import com.oplus.camera.p172ui.preview.p177a.PreviewEffectProcess;

/* compiled from: BlendingAnimManager.java */
/* renamed from: com.oplus.camera.ui.preview.IntrinsicsJvm.kt_5 */
/* loaded from: classes2.dex */
public class BlendingAnimManager {

    /* renamed from: PlatformImplementations.kt_3 */
    private Interpolator f21903a = new PathInterpolator(0.33f, 0.0f, 0.67f, 1.0f);

    /* renamed from: IntrinsicsJvm.kt_4 */
    private int f21904b = 180;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private long f21905c = Long.MAX_VALUE;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private long f21906d = 0;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private final float f21907e = 0.0f;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private final float f21908f = 1.0f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private float f21909g = 0.0f;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private boolean f21910h = false;

    /* renamed from: OplusGLSurfaceView_13 */
    private boolean f21911i = false;

    /* renamed from: OplusGLSurfaceView_15 */
    private RawTexture f21912j = null;

    /* renamed from: OplusGLSurfaceView_5 */
    private RawTexture f21913k = null;

    /* renamed from: PlatformImplementations.kt_3 */
    public boolean m23178a() {
        if (!this.f21910h) {
            this.f21905c = SystemClock.uptimeMillis() - 20;
            this.f21910h = true;
            this.f21911i = true;
        }
        if (!this.f21911i) {
            return false;
        }
        this.f21906d = SystemClock.uptimeMillis();
        float COUIBaseListPopupWindow_12 = (this.f21906d - this.f21905c) / this.f21904b;
        if (COUIBaseListPopupWindow_12 > 1.0f) {
            this.f21911i = false;
            this.f21909g = 1.0f;
        } else {
            this.f21909g = (this.f21903a.getInterpolation(COUIBaseListPopupWindow_12) * 1.0f) + 0.0f;
        }
        return true;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m23176a(GLCanvas interfaceC2757h, RawTexture c2768s, RawTexture c2768s2, float[] fArr) {
        if (c2768s2 == null) {
            return;
        }
        if (!c2768s2.m13943n()) {
            c2768s2.m14193c(interfaceC2757h);
        }
        int iF = c2768s2.mo13935f();
        int iG = c2768s2.mo13936g();
        interfaceC2757h.mo13975a(c2768s2);
        interfaceC2757h.mo13959a(0.0f, iG);
        interfaceC2757h.mo13960a(1.0f, -1.0f, 1.0f);
        interfaceC2757h.mo13973a(c2768s, fArr, 0, 0, iF, iG);
        interfaceC2757h.mo13987h();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m23177a(PreviewEffectProcess interfaceC3423t, ExtTexture c2756g, RawTexture c2768s, GLCanvas interfaceC2757h, int OplusGLSurfaceView_13, int i2, int i3, int i4) {
        if (interfaceC3423t == null || c2756g == null || c2768s == null) {
            return;
        }
        RawTexture c2768s2 = this.f21912j;
        if (c2768s2 == null) {
            this.f21912j = new RawTexture(c2756g.mo13935f(), c2756g.mo13936g(), true);
        } else if (c2768s2.mo13936g() != c2756g.mo13935f() || this.f21912j.mo13935f() != c2756g.mo13936g()) {
            this.f21912j.mo13944o();
            this.f21912j = new RawTexture(c2756g.mo13935f(), c2756g.mo13936g(), true);
        }
        this.f21912j = interfaceC3423t.mo22775a(interfaceC2757h, c2756g, this.f21912j, false);
        RawTexture c2768s3 = this.f21913k;
        if (c2768s3 == null) {
            this.f21913k = new RawTexture(c2768s.mo13935f(), c2768s.mo13936g(), true);
        } else if (c2768s3.mo13936g() != c2768s.mo13935f() || this.f21913k.mo13935f() != c2768s.mo13936g()) {
            this.f21913k.mo13944o();
            this.f21913k = new RawTexture(c2768s.mo13935f(), c2768s.mo13936g(), true);
        }
        Matrix4f matrix4f = new Matrix4f();
        m23176a(interfaceC2757h, c2768s, this.f21913k, matrix4f.getArray());
        CameraLog.m12959b("BlendingAnimManager", "drawTextureBlending, alpha: " + this.f21909g);
        RawTexture c2768s4 = this.f21912j;
        RawTexture c2768s5 = this.f21913k;
        float COUIBaseListPopupWindow_12 = this.f21909g;
        interfaceC2757h.mo13972a(c2768s4, c2768s5, COUIBaseListPopupWindow_12, 1.0f - COUIBaseListPopupWindow_12, matrix4f.getArray(), OplusGLSurfaceView_13, i2, i3, i4);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m23179b() {
        this.f21910h = false;
        this.f21911i = false;
        RawTexture c2768s = this.f21912j;
        if (c2768s != null) {
            c2768s.mo13944o();
            this.f21912j = null;
        }
        RawTexture c2768s2 = this.f21913k;
        if (c2768s2 != null) {
            c2768s2.mo13944o();
            this.f21913k = null;
        }
    }
}

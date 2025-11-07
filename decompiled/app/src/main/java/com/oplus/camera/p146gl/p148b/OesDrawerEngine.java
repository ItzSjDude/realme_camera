package com.oplus.camera.p146gl.p148b;

import android.util.Size;
import com.oplus.camera.CameraLog;
import com.oplus.camera.p146gl.ExtTexture;
import com.oplus.camera.p146gl.RawTexture;
import com.oplus.camera.p146gl.GLCanvas;
import com.oplus.camera.util.Util;

/* compiled from: OesDrawerEngine.java */
/* renamed from: com.oplus.camera.gl.IntrinsicsJvm.kt_4.COUIBaseListPopupWindow_12 */
/* loaded from: classes2.dex */
public class OesDrawerEngine {

    /* renamed from: PlatformImplementations.kt_3 */
    private IOesDrawer f13940a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private IFboDrawer f13941b;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private ExtTexture f13943d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private ExtTexture f13944e;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private RawTexture f13942c = null;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private int f13945f = -1;

    public OesDrawerEngine() {
        this.f13940a = null;
        this.f13941b = null;
        this.f13943d = new ExtTexture(36197);
        this.f13944e = new ExtTexture(36197);
        this.f13940a = new SqureOesDrawer();
        this.f13941b = new FboDrawer();
        if (this.f13943d == null) {
            this.f13943d = new ExtTexture(36197);
        }
        if (this.f13944e == null) {
            this.f13944e = new ExtTexture(36197);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m13887a() {
        this.f13940a.mo13879e_();
        this.f13941b.mo13874b();
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m13889b() {
        CameraLog.m12954a("OesDrawerEngine", "release");
        if (this.f13940a != null) {
            CameraLog.m12954a("OesDrawerEngine", "recycleTextures, mSqureOesDrawer");
            this.f13940a.mo13878b();
            this.f13940a = null;
        }
        if (this.f13941b != null) {
            CameraLog.m12954a("OesDrawerEngine", "recycleTextures, mFboDrawer");
            this.f13941b.mo13875c();
            this.f13941b = null;
        }
        if (this.f13943d != null) {
            CameraLog.m12954a("OesDrawerEngine", "recycleTextures, texture id_renamed: " + this.f13943d.m13934e());
            this.f13943d.mo13944o();
            this.f13943d = null;
        }
        if (this.f13944e != null) {
            CameraLog.m12954a("OesDrawerEngine", "recycleTextures, texture id_renamed: " + this.f13944e.m13934e());
            this.f13944e.mo13944o();
            this.f13944e = null;
        }
        if (this.f13942c != null) {
            CameraLog.m12954a("OesDrawerEngine", "recycleTextures, texture id_renamed: " + this.f13942c.m13934e());
            this.f13942c.mo13944o();
            this.f13942c = null;
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public int m13890c() {
        return this.f13943d.m13934e();
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public int m13891d() {
        return this.f13944e.m13934e();
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public ExtTexture m13892e() {
        return this.f13944e;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public int m13886a(GLCanvas interfaceC2757h, int OplusGLSurfaceView_13, int i2, Size size, Size size2, int i3, boolean z, SubSurfacePositionContainer c2751h) {
        c2751h.m13901a(size, size2, i3, c2751h.m13920n());
        if (this.f13942c == null) {
            this.f13942c = new RawTexture(c2751h.m13918l(), c2751h.m13917k(), true);
        }
        RawTexture c2768s = this.f13942c;
        if (c2768s != null && !c2768s.m13943n()) {
            this.f13942c.m14193c(interfaceC2757h);
        }
        if (m13885a(size2, size, i3, c2751h.m13920n())) {
            this.f13945f = this.f13940a.mo13876a(OplusGLSurfaceView_13, i2, size, size2, i3, c2751h.m13920n(), z, c2751h, this.f13942c);
            this.f13941b.mo13873a(this.f13945f, OplusGLSurfaceView_13, i2, size, size2, i3, c2751h.m13920n(), c2751h);
        } else {
            CameraLog.m12967f("OesDrawerEngine", "skip the frame, size does not match the type");
        }
        return this.f13945f;
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    public RawTexture m13893f() {
        return this.f13942c;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m13888a(boolean z) {
        IOesDrawer interfaceC2747d = this.f13940a;
        if (interfaceC2747d != null) {
            interfaceC2747d.mo13877a(z);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private boolean m13885a(Size size, Size size2, int OplusGLSurfaceView_13, boolean z) {
        if (OplusGLSurfaceView_13 != 0) {
            if (OplusGLSurfaceView_13 != 1) {
                if (OplusGLSurfaceView_13 == 2 && (!Util.m24293a(size, 1.7777777777777777d) || !Util.m24293a(size2, 1.7777777777777777d))) {
                    return false;
                }
            } else if (z) {
                if (size2.getHeight() != size2.getWidth()) {
                    return false;
                }
            } else if (size.getHeight() != size.getWidth()) {
                return false;
            }
        } else if (size.getWidth() != size2.getWidth() || size.getHeight() != size2.getHeight()) {
            return false;
        }
        return true;
    }
}

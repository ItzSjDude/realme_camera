package com.oplus.camera.ui.preview;

/* compiled from: BlendingAnimManager.java */
/* loaded from: classes2.dex */
public class d_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private android.view.animation.Interpolator f7022a = new android.view.animation.PathInterpolator(0.33f, 0.0f, 0.67f, 1.0f);

    /* renamed from: b_renamed, reason: collision with root package name */
    private int f7023b = 180;

    /* renamed from: c_renamed, reason: collision with root package name */
    private long f7024c = Long.MAX_VALUE;
    private long d_renamed = 0;
    private final float e_renamed = 0.0f;
    private final float f_renamed = 1.0f;
    private float g_renamed = 0.0f;
    private boolean h_renamed = false;
    private boolean i_renamed = false;
    private com.oplus.camera.gl_renamed.s_renamed j_renamed = null;
    private com.oplus.camera.gl_renamed.s_renamed k_renamed = null;

    public boolean a_renamed() {
        if (!this.h_renamed) {
            this.f7024c = android.os.SystemClock.uptimeMillis() - 20;
            this.h_renamed = true;
            this.i_renamed = true;
        }
        if (!this.i_renamed) {
            return false;
        }
        this.d_renamed = android.os.SystemClock.uptimeMillis();
        float f_renamed = (this.d_renamed - this.f7024c) / this.f7023b;
        if (f_renamed > 1.0f) {
            this.i_renamed = false;
            this.g_renamed = 1.0f;
        } else {
            this.g_renamed = (this.f7022a.getInterpolation(f_renamed) * 1.0f) + 0.0f;
        }
        return true;
    }

    private void a_renamed(com.oplus.camera.gl_renamed.h_renamed hVar, com.oplus.camera.gl_renamed.s_renamed sVar, com.oplus.camera.gl_renamed.s_renamed sVar2, float[] fArr) {
        if (sVar2 == null) {
            return;
        }
        if (!sVar2.n_renamed()) {
            sVar2.c_renamed(hVar);
        }
        int iF = sVar2.f_renamed();
        int iG = sVar2.g_renamed();
        hVar.a_renamed(sVar2);
        hVar.a_renamed(0.0f, iG);
        hVar.a_renamed(1.0f, -1.0f, 1.0f);
        hVar.a_renamed(sVar, fArr, 0, 0, iF, iG);
        hVar.h_renamed();
    }

    public void a_renamed(com.oplus.camera.ui.preview.a_renamed.t_renamed tVar, com.oplus.camera.gl_renamed.g_renamed gVar, com.oplus.camera.gl_renamed.s_renamed sVar, com.oplus.camera.gl_renamed.h_renamed hVar, int i_renamed, int i2, int i3, int i4) {
        if (tVar == null || gVar == null || sVar == null) {
            return;
        }
        com.oplus.camera.gl_renamed.s_renamed sVar2 = this.j_renamed;
        if (sVar2 == null) {
            this.j_renamed = new com.oplus.camera.gl_renamed.s_renamed(gVar.f_renamed(), gVar.g_renamed(), true);
        } else if (sVar2.g_renamed() != gVar.f_renamed() || this.j_renamed.f_renamed() != gVar.g_renamed()) {
            this.j_renamed.o_renamed();
            this.j_renamed = new com.oplus.camera.gl_renamed.s_renamed(gVar.f_renamed(), gVar.g_renamed(), true);
        }
        this.j_renamed = tVar.a_renamed(hVar, gVar, this.j_renamed, false);
        com.oplus.camera.gl_renamed.s_renamed sVar3 = this.k_renamed;
        if (sVar3 == null) {
            this.k_renamed = new com.oplus.camera.gl_renamed.s_renamed(sVar.f_renamed(), sVar.g_renamed(), true);
        } else if (sVar3.g_renamed() != sVar.f_renamed() || this.k_renamed.f_renamed() != sVar.g_renamed()) {
            this.k_renamed.o_renamed();
            this.k_renamed = new com.oplus.camera.gl_renamed.s_renamed(sVar.f_renamed(), sVar.g_renamed(), true);
        }
        android.renderscript.Matrix4f matrix4f = new android.renderscript.Matrix4f();
        a_renamed(hVar, sVar, this.k_renamed, matrix4f.getArray());
        com.oplus.camera.e_renamed.b_renamed("BlendingAnimManager", "drawTextureBlending, alpha: " + this.g_renamed);
        com.oplus.camera.gl_renamed.s_renamed sVar4 = this.j_renamed;
        com.oplus.camera.gl_renamed.s_renamed sVar5 = this.k_renamed;
        float f_renamed = this.g_renamed;
        hVar.a_renamed(sVar4, sVar5, f_renamed, 1.0f - f_renamed, matrix4f.getArray(), i_renamed, i2, i3, i4);
    }

    public void b_renamed() {
        this.h_renamed = false;
        this.i_renamed = false;
        com.oplus.camera.gl_renamed.s_renamed sVar = this.j_renamed;
        if (sVar != null) {
            sVar.o_renamed();
            this.j_renamed = null;
        }
        com.oplus.camera.gl_renamed.s_renamed sVar2 = this.k_renamed;
        if (sVar2 != null) {
            sVar2.o_renamed();
            this.k_renamed = null;
        }
    }
}

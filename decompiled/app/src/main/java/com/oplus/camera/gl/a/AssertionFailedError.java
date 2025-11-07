package com.oplus.camera.gl_renamed.a_renamed;

/* compiled from: GLImageModeChangeProcessorAgent.java */
/* loaded from: classes2.dex */
public class b_renamed {
    private com.oplus.camera.gl_renamed.a_renamed.d_renamed f_renamed;
    private android.view.animation.PathInterpolator g_renamed;
    private java.nio.FloatBuffer h_renamed;
    private java.nio.FloatBuffer i_renamed;
    private android.renderscript.Matrix4f j_renamed;
    private android.renderscript.Matrix4f k_renamed;

    /* renamed from: a_renamed, reason: collision with root package name */
    private float f4577a = 5.0f;

    /* renamed from: b_renamed, reason: collision with root package name */
    private float f4578b = 1.0f;

    /* renamed from: c_renamed, reason: collision with root package name */
    private int f4579c = 0;
    private int d_renamed = 0;
    private int e_renamed = 0;
    private boolean l_renamed = false;
    private int m_renamed = 0;
    private int n_renamed = 0;
    private float o_renamed = 0.0f;

    public b_renamed() {
        this.f_renamed = null;
        this.g_renamed = null;
        this.h_renamed = null;
        this.i_renamed = null;
        this.j_renamed = null;
        this.k_renamed = null;
        this.f_renamed = new com.oplus.camera.gl_renamed.a_renamed.d_renamed();
        this.g_renamed = new android.view.animation.PathInterpolator(0.33f, 0.0f, 0.66f, 1.0f);
        this.h_renamed = com.oplus.camera.util.k_renamed.a_renamed(com.oplus.camera.gl_renamed.a_renamed.c_renamed.f4580a);
        this.i_renamed = com.oplus.camera.util.k_renamed.a_renamed(com.oplus.camera.gl_renamed.a_renamed.c_renamed.f4581b);
        this.j_renamed = new android.renderscript.Matrix4f();
        this.j_renamed.scale(1.0f, -1.0f, 1.0f);
        this.j_renamed.translate(0.0f, -1.0f, 0.0f);
        this.k_renamed = new android.renderscript.Matrix4f();
    }

    public void a_renamed(int i_renamed, int i2) {
        com.oplus.camera.e_renamed.a_renamed("GLImageModeChangeProcessorAgent", "init, width: " + i_renamed + ", height: " + i2);
        this.f4579c = i_renamed;
        this.d_renamed = i2;
        this.f_renamed.b_renamed(i_renamed, i2);
        this.f_renamed.a_renamed(i_renamed, i2);
    }

    public void a_renamed(android.util.Size size, android.util.Size size2) {
        com.oplus.camera.e_renamed.a_renamed("GLImageModeChangeProcessorAgent", "setChangeSize, size change: " + size.getWidth() + " x_renamed " + size.getHeight() + " => " + size2.getWidth() + " x_renamed " + size2.getHeight());
        this.f_renamed.a_renamed(size, size2);
    }

    public int a_renamed(int i_renamed) {
        this.f_renamed.a_renamed(e_renamed());
        return this.f_renamed.a_renamed(i_renamed, this.h_renamed, this.i_renamed);
    }

    public float[] a_renamed() {
        if (this.l_renamed) {
            return this.k_renamed.getArray();
        }
        return this.j_renamed.getArray();
    }

    public void b_renamed(int i_renamed, int i2) {
        float f_renamed;
        float f2;
        float f3;
        float f4;
        float f5 = this.o_renamed;
        float f6 = i_renamed;
        int i3 = (int) (f5 * f6);
        if (i3 < i2) {
            f4 = f6 / ((int) (i2 / f5));
            f3 = ((r8 - i_renamed) / f6) / 2.0f;
            f_renamed = 0.0f;
            f2 = 1.0f;
        } else {
            float f7 = i2;
            f_renamed = ((i3 - i2) / f7) / 2.0f;
            f2 = f7 / i3;
            f3 = 0.0f;
            f4 = 1.0f;
        }
        if (this.l_renamed) {
            this.k_renamed.loadIdentity();
            this.k_renamed.scale(f4, f2, 1.0f);
            this.k_renamed.translate(f3, f_renamed, 0.0f);
        } else {
            this.j_renamed.loadIdentity();
            this.j_renamed.scale(1.0f, -1.0f, 1.0f);
            this.j_renamed.translate(0.0f, -1.0f, 0.0f);
            this.j_renamed.scale(f4, f2, 1.0f);
            this.j_renamed.translate(f3, f_renamed, 0.0f);
        }
    }

    public void a_renamed(boolean z_renamed) {
        this.l_renamed = z_renamed;
    }

    public void b_renamed() {
        com.oplus.camera.e_renamed.a_renamed("GLImageModeChangeProcessorAgent", "uninit");
        this.f4579c = 0;
        this.d_renamed = 0;
        this.f_renamed.a_renamed();
    }

    public void c_renamed() {
        this.f_renamed.b_renamed();
        this.f_renamed = null;
        this.h_renamed = null;
        this.i_renamed = null;
    }

    public void c_renamed(int i_renamed, int i2) {
        this.m_renamed = i_renamed;
        this.n_renamed = i2;
        this.o_renamed = i2 / i_renamed;
    }

    public int a_renamed(int i_renamed, int i2, int i3) {
        com.oplus.camera.e_renamed.a_renamed("GLImageModeChangeProcessorAgent", "drawCoverBlur, textId: " + i_renamed + ", mBlurShotWidth: " + this.f4579c + ", mBlurShotHeight: " + this.d_renamed + ", width: " + i2 + ", height: " + i3 + ", mSizeRatioType: " + this.e_renamed);
        if (this.f4579c != i2 || this.d_renamed != i3) {
            a_renamed(i2, i3);
            com.oplus.camera.gl_renamed.i_renamed.i_renamed();
        }
        return a_renamed(i_renamed);
    }

    public void d_renamed() {
        this.f4577a = 5.0f;
    }

    public int e_renamed() {
        float interpolation = this.g_renamed.getInterpolation(this.f4577a / 25.0f);
        this.f4577a += this.f4578b;
        if (this.f4577a > 25.0f) {
            this.f4577a = 25.0f;
        }
        return (int) (interpolation * 25.0f);
    }
}

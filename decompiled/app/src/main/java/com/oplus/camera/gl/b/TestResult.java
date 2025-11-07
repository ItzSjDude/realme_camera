package com.oplus.camera.gl_renamed.b_renamed;

/* compiled from: SubSurfacePositionContainer.java */
/* loaded from: classes2.dex */
public class h_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private int f4608a = 0;

    /* renamed from: b_renamed, reason: collision with root package name */
    private int f4609b = 0;

    /* renamed from: c_renamed, reason: collision with root package name */
    private int f4610c = 0;
    private int d_renamed = -1;
    private int e_renamed = -1;
    private int f_renamed = 0;
    private int g_renamed = 0;
    private int h_renamed = -1;
    private int i_renamed = 0;
    private int j_renamed = 0;
    private int k_renamed = 0;
    private int l_renamed = 0;
    private int m_renamed = 0;
    private int n_renamed = 0;
    private boolean o_renamed = true;

    public int a_renamed() {
        if (com.oplus.camera.util.Util.u_renamed()) {
            return (int) (this.f4609b / 1.7777777777777777d);
        }
        return this.f4608a;
    }

    public int b_renamed() {
        return this.f4609b;
    }

    public int c_renamed() {
        return this.f4610c;
    }

    public int d_renamed() {
        return this.d_renamed;
    }

    public int e_renamed() {
        return this.e_renamed;
    }

    public int f_renamed() {
        return this.i_renamed;
    }

    public int g_renamed() {
        return this.j_renamed;
    }

    public int h_renamed() {
        if (com.oplus.camera.util.Util.u_renamed()) {
            return (this.f4608a - a_renamed()) / 2;
        }
        return 0;
    }

    public int i_renamed() {
        return this.k_renamed;
    }

    public int j_renamed() {
        return this.l_renamed;
    }

    public int k_renamed() {
        return this.m_renamed;
    }

    public int l_renamed() {
        return this.n_renamed;
    }

    public void a_renamed(int i_renamed) {
        this.f4608a = i_renamed;
    }

    public void b_renamed(int i_renamed) {
        this.f4609b = i_renamed;
    }

    public void c_renamed(int i_renamed) {
        this.f4610c = i_renamed;
    }

    public void d_renamed(int i_renamed) {
        this.d_renamed = i_renamed;
    }

    public void e_renamed(int i_renamed) {
        this.e_renamed = i_renamed;
    }

    public int m_renamed() {
        return this.h_renamed;
    }

    public void f_renamed(int i_renamed) {
        com.oplus.camera.e_renamed.f_renamed("SubSurfacePositionContainer", "setMultiVideoType, multiVideoType: " + i_renamed);
        this.h_renamed = i_renamed;
    }

    public boolean n_renamed() {
        return this.o_renamed;
    }

    public void a_renamed(boolean z_renamed) {
        this.o_renamed = z_renamed;
    }

    public void a_renamed(int i_renamed, int i2) {
        this.f_renamed = i_renamed;
        this.g_renamed = i2;
    }

    public android.graphics.Rect o_renamed() {
        int i_renamed = this.d_renamed;
        int i2 = this.e_renamed;
        return new android.graphics.Rect(i_renamed, i2, this.f_renamed + i_renamed, this.g_renamed + i2);
    }

    public void a_renamed(android.util.Size size, android.util.Size size2, int i_renamed, boolean z_renamed) {
        float fA_renamed = com.oplus.camera.capmode.q_renamed.a_renamed(i_renamed);
        if (i_renamed == 0) {
            this.i_renamed = a_renamed();
            this.j_renamed = (size2.getWidth() * a_renamed()) / size2.getHeight();
            int i2 = this.i_renamed;
            this.k_renamed = i2;
            int i3 = this.j_renamed;
            this.l_renamed = i3;
            this.n_renamed = i2;
            this.m_renamed = i3 * 2;
            return;
        }
        if (i_renamed == 1) {
            if (z_renamed) {
                this.i_renamed = a_renamed();
                this.j_renamed = (size2.getWidth() * a_renamed()) / size2.getHeight();
                int iA = (int) (a_renamed() / fA_renamed);
                this.k_renamed = iA;
                this.l_renamed = iA;
                this.n_renamed = this.i_renamed;
                this.m_renamed = this.j_renamed;
                return;
            }
            this.k_renamed = a_renamed();
            this.l_renamed = (size.getWidth() * a_renamed()) / size.getHeight();
            int iA2 = (int) (a_renamed() / fA_renamed);
            this.i_renamed = iA2;
            this.j_renamed = iA2;
            this.n_renamed = this.k_renamed;
            this.m_renamed = this.l_renamed;
            return;
        }
        if (i_renamed != 2) {
            return;
        }
        if (z_renamed) {
            this.i_renamed = a_renamed();
            this.j_renamed = (size2.getWidth() * a_renamed()) / size2.getHeight();
            this.k_renamed = (int) (a_renamed() / fA_renamed);
            int i4 = this.j_renamed;
            this.l_renamed = (int) (i4 / fA_renamed);
            this.n_renamed = this.i_renamed;
            this.m_renamed = i4;
            return;
        }
        this.k_renamed = a_renamed();
        this.l_renamed = (size.getWidth() * a_renamed()) / size.getHeight();
        this.i_renamed = (int) (a_renamed() / fA_renamed);
        int i5 = this.l_renamed;
        this.j_renamed = (int) (i5 / fA_renamed);
        this.n_renamed = this.k_renamed;
        this.m_renamed = i5;
    }

    public java.lang.String toString() {
        return "SubSurfacePositionContainer{mScreenWidth=" + this.f4608a + ", mScreenHeight=" + this.f4609b + ", mSettingMenuPanelHeight=" + this.f4610c + ", mSmallSurfaceXOnScreen=" + this.d_renamed + ", mSmallSurfaceYOnScreen=" + this.e_renamed + ", mSmallSurfaceWidth=" + this.f_renamed + ", mSmallSurfaceHeight=" + this.g_renamed + ", mMultiVideoType=" + this.h_renamed + ", mDrawMainImageWidth=" + this.i_renamed + ", mDrawMainImageHeight=" + this.j_renamed + ", mDrawSubImageWidth=" + this.k_renamed + ", mDrawSubImageHeight=" + this.l_renamed + ", mFboHeight=" + this.m_renamed + ", mFboWidth=" + this.n_renamed + ", mbMainOneCameraFirstDraw=" + this.o_renamed + '}';
    }
}

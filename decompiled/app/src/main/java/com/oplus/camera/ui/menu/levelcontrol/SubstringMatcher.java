package com.oplus.camera.ui.menu.levelcontrol;

/* compiled from: GLProducerRender2D.java */
/* loaded from: classes2.dex */
public abstract class k_renamed extends com.oplus.camera.ui.menu.levelcontrol.j_renamed {
    protected int G_renamed;
    protected int H_renamed;
    private boolean I_renamed;
    private boolean J_renamed;

    protected abstract int c_renamed(com.oplus.camera.ui.menu.levelcontrol.i_renamed iVar);

    protected abstract int d_renamed(com.oplus.camera.ui.menu.levelcontrol.i_renamed iVar);

    protected abstract void k_renamed();

    public k_renamed(android.content.Context context, int i_renamed) {
        super(context);
        this.H_renamed = 0;
        this.I_renamed = false;
        this.J_renamed = false;
        this.G_renamed = i_renamed;
    }

    @Override // com.oplus.camera.gl_renamed.m_renamed.GLProducer_6
    public void a_renamed(javax.microedition.khronos.opengles.GL10 gl10, javax.microedition.khronos.egl.EGLConfig eGLConfig) {
        long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
        android.opengl.GLES20.glDisable(2929);
        android.opengl.GLES20.glDisable(2884);
        com.oplus.camera.gl_renamed.i_renamed.i_renamed();
        com.oplus.camera.ui.menu.levelcontrol.p_renamed.a_renamed();
        this.f6532c.a_renamed();
        this.d_renamed = new com.oplus.camera.ui.menu.levelcontrol.h_renamed(this.f6530a, this.G_renamed);
        this.d_renamed.a_renamed(this.F_renamed);
        com.oplus.camera.e_renamed.a_renamed("GLProducerRender2D", "onSurfaceCreated, cost: " + (java.lang.System.currentTimeMillis() - jCurrentTimeMillis));
    }

    @Override // com.oplus.camera.gl_renamed.m_renamed.GLProducer_6
    public void a_renamed(javax.microedition.khronos.opengles.GL10 gl10, int i_renamed, int i2) {
        long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
        android.opengl.GLES20.glViewport(0, 0, i_renamed, i2);
        com.oplus.camera.gl_renamed.i_renamed.i_renamed();
        this.d_renamed.a_renamed(i_renamed, i2);
        if (this.p_renamed != null) {
            e_renamed(this.p_renamed);
        } else {
            com.oplus.camera.e_renamed.a_renamed("GLProducerRender2D", "onSurfaceChanged, mGLModelParam has not init.");
        }
        this.I_renamed = true;
        com.oplus.camera.e_renamed.a_renamed("GLProducerRender2D", "onSurfaceChanged, cost: " + (java.lang.System.currentTimeMillis() - jCurrentTimeMillis));
    }

    @Override // com.oplus.camera.ui.menu.levelcontrol.j_renamed
    public void b_renamed(javax.microedition.khronos.opengles.GL10 gl10) {
        if (java.lang.Float.compare(this.h_renamed, 0.0f) != 0) {
            float f_renamed = this.h_renamed;
            android.view.animation.Interpolator interpolator = this.k_renamed;
            int i_renamed = this.i_renamed;
            this.i_renamed = i_renamed + 1;
            float interpolation = f_renamed * interpolator.getInterpolation(i_renamed / this.j_renamed);
            float interpolation2 = this.h_renamed * this.k_renamed.getInterpolation(this.i_renamed / this.j_renamed);
            this.f_renamed += interpolation2 - interpolation;
            if (this.l_renamed != null) {
                this.l_renamed.a_renamed(this.f_renamed);
            } else {
                com.oplus.camera.e_renamed.f_renamed("GLProducerRender2D", "onDrawFrame, mScrollAnimListener == null !");
            }
            if ((java.lang.Float.compare(this.h_renamed, 0.0f) > 0 && java.lang.Float.compare(interpolation2, this.h_renamed) >= 0) || (java.lang.Float.compare(this.h_renamed, 0.0f) < 0 && java.lang.Float.compare(interpolation2, this.h_renamed) <= 0)) {
                this.f_renamed = this.g_renamed;
                this.h_renamed = 0.0f;
                this.i_renamed = 0;
                if (this.l_renamed != null) {
                    this.l_renamed.b_renamed(this.f_renamed);
                } else {
                    com.oplus.camera.e_renamed.f_renamed("GLProducerRender2D", "onDrawFrame, mScrollAnimListener == null !");
                }
            }
        }
        k_renamed();
        if (this.p_renamed.v_renamed() && this.I_renamed && this.m_renamed != null) {
            this.f6532c.a_renamed(this);
        }
        android.opengl.GLES20.glEnable(3042);
        android.opengl.GLES20.glBlendFunc(com.arcsoft.arcsoftjni.ArcSoftOffscreen.ASVL_PAF_RGB32_B8G8R8A8, 771);
        com.oplus.camera.gl_renamed.i_renamed.i_renamed();
    }

    @Override // com.oplus.camera.ui.menu.levelcontrol.j_renamed
    public void a_renamed(com.oplus.camera.ui.menu.levelcontrol.i_renamed iVar, boolean z_renamed) {
        android.graphics.Bitmap bitmapB;
        com.oplus.camera.e_renamed.a_renamed("GLProducerRender2D", "createTextures, glModelParam: " + iVar.toString());
        this.r_renamed = false;
        this.q_renamed = false;
        this.s_renamed = iVar.c_renamed();
        this.f6531b = iVar.l_renamed();
        if (this.d_renamed != null) {
            this.d_renamed.a_renamed(iVar.u_renamed());
            this.d_renamed.b_renamed(iVar.t_renamed());
            this.d_renamed.a_renamed(this.w_renamed, this.x_renamed);
            this.d_renamed.a_renamed(android.graphics.Color.valueOf(this.f6530a.getColor(this.e_renamed ? com.oplus.camera.R_renamed.color.color_black_with_full_percent_transparency : com.oplus.camera.R_renamed.color.camera_white)).getComponents());
        }
        if (iVar.v_renamed()) {
            int iC = c_renamed(iVar);
            int iD = d_renamed(iVar);
            com.oplus.camera.e_renamed.a_renamed("GLProducerRender2D", "createTextures, width: " + iD + ", height: " + iC);
            if (this.m_renamed == null) {
                this.m_renamed = new com.oplus.camera.ui.menu.levelcontrol.t_renamed(iD, iC, -1);
                if (!this.m_renamed.h_renamed()) {
                    this.m_renamed.a_renamed();
                }
                if (this.d_renamed != null) {
                    this.d_renamed.a_renamed(iD, iC, this.H_renamed, this.G_renamed);
                }
                e_renamed(iVar);
            } else {
                if (iD != this.m_renamed.e_renamed() || iC != this.m_renamed.f_renamed()) {
                    this.m_renamed.b_renamed();
                    this.m_renamed = new com.oplus.camera.ui.menu.levelcontrol.t_renamed(iD, iC, -1);
                    if (!this.m_renamed.h_renamed()) {
                        this.m_renamed.a_renamed();
                    }
                    if (this.d_renamed != null) {
                        this.d_renamed.a_renamed(iD, iC, this.H_renamed, this.G_renamed);
                    }
                }
                if (z_renamed) {
                    e_renamed(iVar);
                }
            }
            if (this.o_renamed == null) {
                this.o_renamed = new com.oplus.camera.ui.menu.levelcontrol.t_renamed(iD, iC, -1);
                if (!this.o_renamed.h_renamed()) {
                    this.o_renamed.a_renamed();
                }
            } else if (iD != this.o_renamed.e_renamed() || iC != this.o_renamed.f_renamed()) {
                this.o_renamed.b_renamed();
                this.o_renamed = new com.oplus.camera.ui.menu.levelcontrol.t_renamed(iD, iC, -1);
                if (!this.o_renamed.h_renamed()) {
                    this.o_renamed.a_renamed();
                }
            }
            if (iD < iC) {
                if (this.H_renamed == 0) {
                    bitmapB = com.oplus.camera.ui.preview.a_renamed.j_renamed.a_renamed(iVar, iD, iC, this.e_renamed);
                } else {
                    bitmapB = com.oplus.camera.ui.preview.a_renamed.j_renamed.a_renamed(iVar, iD, iC, this.e_renamed, this.H_renamed);
                }
            } else if (this.H_renamed == 0) {
                bitmapB = com.oplus.camera.ui.preview.a_renamed.j_renamed.b_renamed(iVar, iD, iC, this.e_renamed);
            } else {
                bitmapB = com.oplus.camera.ui.preview.a_renamed.j_renamed.b_renamed(iVar, iD, iC, this.e_renamed, this.H_renamed);
            }
            this.o_renamed.b_renamed(bitmapB);
            bitmapB.recycle();
        }
        if (this.d_renamed != null) {
            this.d_renamed.b_renamed(iVar.i_renamed(), iVar.h_renamed());
            this.d_renamed.a_renamed(this.o_renamed.c_renamed());
        }
    }

    @Override // com.oplus.camera.ui.menu.levelcontrol.j_renamed
    public void b_renamed(com.oplus.camera.ui.menu.levelcontrol.i_renamed iVar) {
        android.graphics.Bitmap bitmapB;
        if (this.d_renamed != null) {
            this.d_renamed.a_renamed(android.graphics.Color.valueOf(this.f6530a.getColor(this.e_renamed ? com.oplus.camera.R_renamed.color.color_black_with_full_percent_transparency : com.oplus.camera.R_renamed.color.camera_white)).getComponents());
        }
        if (iVar == null || !iVar.v_renamed() || this.d_renamed == null) {
            return;
        }
        int iC = c_renamed(iVar);
        int iD = d_renamed(iVar);
        if (this.o_renamed == null) {
            this.o_renamed = new com.oplus.camera.ui.menu.levelcontrol.t_renamed(iD, iC, -1);
            if (!this.o_renamed.h_renamed()) {
                this.o_renamed.a_renamed();
            }
        } else if (iD != this.o_renamed.e_renamed() || iC != this.o_renamed.f_renamed()) {
            this.o_renamed.b_renamed();
            this.o_renamed = new com.oplus.camera.ui.menu.levelcontrol.t_renamed(iD, iC, -1);
            if (!this.o_renamed.h_renamed()) {
                this.o_renamed.a_renamed();
            }
        }
        if (iD < iC) {
            if (this.H_renamed == 0) {
                bitmapB = com.oplus.camera.ui.preview.a_renamed.j_renamed.a_renamed(iVar, iD, iC, this.e_renamed);
            } else {
                bitmapB = com.oplus.camera.ui.preview.a_renamed.j_renamed.a_renamed(iVar, iD, iC, this.e_renamed, this.H_renamed);
            }
        } else if (this.H_renamed == 0) {
            bitmapB = com.oplus.camera.ui.preview.a_renamed.j_renamed.b_renamed(iVar, iD, iC, this.e_renamed);
        } else {
            bitmapB = com.oplus.camera.ui.preview.a_renamed.j_renamed.b_renamed(iVar, iD, iC, this.e_renamed, this.H_renamed);
        }
        this.o_renamed.b_renamed(bitmapB);
        this.d_renamed.a_renamed(this.o_renamed.c_renamed());
        bitmapB.recycle();
    }

    private void e_renamed(com.oplus.camera.ui.menu.levelcontrol.i_renamed iVar) {
        com.oplus.camera.e_renamed.a_renamed("GLProducerRender2D", "updateElementsParam, glModelParam: " + iVar.toString());
        if (this.d_renamed != null) {
            this.d_renamed.a_renamed();
            this.d_renamed.a_renamed(iVar);
        }
        this.p_renamed = iVar;
    }
}

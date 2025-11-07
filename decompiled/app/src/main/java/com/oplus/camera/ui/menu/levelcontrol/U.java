package com.oplus.camera.ui.menu.levelcontrol;

/* compiled from: GLProducerRender3D.java */
/* loaded from: classes2.dex */
public class n_renamed extends com.oplus.camera.ui.menu.levelcontrol.j_renamed {
    private com.oplus.camera.ui.menu.levelcontrol.q_renamed G_renamed;
    private java.util.ArrayList<com.oplus.camera.ui.menu.levelcontrol.t_renamed> H_renamed;
    private com.oplus.camera.ui.menu.levelcontrol.t_renamed I_renamed;
    private boolean J_renamed;
    private boolean K_renamed;

    public n_renamed(android.content.Context context) {
        super(context);
        this.G_renamed = null;
        this.H_renamed = null;
        this.I_renamed = null;
        this.J_renamed = false;
        this.K_renamed = false;
    }

    @Override // com.oplus.camera.gl_renamed.m_renamed.GLProducer_6
    public void a_renamed(javax.microedition.khronos.opengles.GL10 gl10, javax.microedition.khronos.egl.EGLConfig eGLConfig) {
        long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
        android.opengl.GLES20.glEnable(2929);
        android.opengl.GLES20.glEnable(2884);
        com.oplus.camera.gl_renamed.i_renamed.i_renamed();
        com.oplus.camera.ui.menu.levelcontrol.p_renamed.a_renamed();
        this.f6532c.a_renamed();
        this.d_renamed = new com.oplus.camera.ui.menu.levelcontrol.f_renamed(this.f6530a);
        this.d_renamed.a_renamed(this.F_renamed);
        this.G_renamed = new com.oplus.camera.ui.menu.levelcontrol.q_renamed(this.f6530a);
        com.oplus.camera.e_renamed.a_renamed("GLProducerRender3D", "onSurfaceCreated, cost: " + (java.lang.System.currentTimeMillis() - jCurrentTimeMillis));
    }

    @Override // com.oplus.camera.gl_renamed.m_renamed.GLProducer_6
    public void a_renamed(javax.microedition.khronos.opengles.GL10 gl10, int i_renamed, int i2) {
        long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
        android.opengl.GLES20.glViewport(0, 0, i_renamed, i2);
        com.oplus.camera.gl_renamed.i_renamed.i_renamed();
        this.d_renamed.a_renamed(i_renamed, i2);
        com.oplus.camera.ui.menu.levelcontrol.o_renamed.d_renamed(i2);
        if (this.p_renamed != null) {
            c_renamed(this.p_renamed);
        } else {
            com.oplus.camera.e_renamed.a_renamed("GLProducerRender3D", "onSurfaceChanged, mGLModelParam has not init.");
        }
        com.oplus.camera.ui.menu.levelcontrol.p_renamed.a_renamed(0.0f, 0.0f, 10.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f);
        com.oplus.camera.ui.menu.levelcontrol.p_renamed.c_renamed(0.0f, 6.0f, 10.0f);
        this.J_renamed = true;
        com.oplus.camera.e_renamed.a_renamed("GLProducerRender3D", "onSurfaceChanged, cost: " + (java.lang.System.currentTimeMillis() - jCurrentTimeMillis));
    }

    @Override // com.oplus.camera.ui.menu.levelcontrol.j_renamed
    protected void b_renamed(javax.microedition.khronos.opengles.GL10 gl10) {
        com.oplus.camera.ui.menu.levelcontrol.p_renamed.b_renamed();
        com.oplus.camera.ui.menu.levelcontrol.p_renamed.a_renamed(0.0f, 0.0f, -10.0f);
        com.oplus.camera.gl_renamed.i_renamed.i_renamed();
        com.oplus.camera.ui.menu.levelcontrol.p_renamed.b_renamed();
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
                com.oplus.camera.e_renamed.f_renamed("GLProducerRender3D", "onDrawFrame, mScrollAnimListener == null !");
            }
            if ((java.lang.Float.compare(this.h_renamed, 0.0f) > 0 && java.lang.Float.compare(interpolation2, this.h_renamed) >= 0) || (java.lang.Float.compare(this.h_renamed, 0.0f) < 0 && java.lang.Float.compare(interpolation2, this.h_renamed) <= 0)) {
                this.f_renamed = this.g_renamed;
                this.h_renamed = 0.0f;
                this.i_renamed = 0;
                if (this.l_renamed != null) {
                    this.l_renamed.b_renamed(this.f_renamed);
                } else {
                    com.oplus.camera.e_renamed.f_renamed("GLProducerRender3D", "onDrawFrame, mScrollAnimListener == null !");
                }
            }
        }
        com.oplus.camera.ui.menu.levelcontrol.p_renamed.a_renamed();
        com.oplus.camera.ui.menu.levelcontrol.p_renamed.a_renamed(this.f_renamed / 100.0f, 0.0f, 0.0f);
        com.oplus.camera.gl_renamed.i_renamed.i_renamed();
        if (this.p_renamed.v_renamed()) {
            if (this.J_renamed && this.m_renamed != null) {
                this.f6532c.a_renamed(this);
            }
        } else if (this.H_renamed != null) {
            for (int i2 = 0; i2 < this.H_renamed.size(); i2++) {
                if (a_renamed(i2, this.f_renamed) && i2 < this.d_renamed.b_renamed()) {
                    com.oplus.camera.gl_renamed.i_renamed.i_renamed();
                    com.oplus.camera.ui.menu.levelcontrol.p_renamed.b_renamed();
                    com.oplus.camera.gl_renamed.i_renamed.i_renamed();
                    com.oplus.camera.ui.menu.levelcontrol.p_renamed.a_renamed(0.0f, ((-com.oplus.camera.ui.menu.levelcontrol.o_renamed.i_renamed()) / 2.0f) * 1.0f, 0.0f);
                    this.d_renamed.c_renamed(this.H_renamed.get(i2).c_renamed(), i2);
                    com.oplus.camera.ui.menu.levelcontrol.p_renamed.c_renamed();
                    com.oplus.camera.gl_renamed.i_renamed.i_renamed();
                }
            }
        }
        com.oplus.camera.ui.menu.levelcontrol.p_renamed.c_renamed();
        android.opengl.GLES20.glEnable(3042);
        android.opengl.GLES20.glBlendFunc(com.arcsoft.arcsoftjni.ArcSoftOffscreen.ASVL_PAF_RGB32_B8G8R8A8, 771);
        com.oplus.camera.gl_renamed.i_renamed.i_renamed();
        if (this.G_renamed != null && this.v_renamed != null && this.m_renamed != null) {
            if (this.K_renamed) {
                for (int i3 = 0; i3 < this.v_renamed.size(); i3++) {
                    if (this.v_renamed.get(i3).d_renamed() == 0) {
                        this.v_renamed.get(i3).b_renamed(this.e_renamed ? this.p_renamed.f_renamed() : this.p_renamed.e_renamed());
                    }
                }
                this.K_renamed = false;
            }
            for (int i4 = 0; i4 < this.v_renamed.size(); i4++) {
                if (this.v_renamed.get(i4).c_renamed() != -1) {
                    com.oplus.camera.ui.menu.levelcontrol.p_renamed.b_renamed();
                    com.oplus.camera.ui.menu.levelcontrol.p_renamed.a_renamed(0.0f, ((-com.oplus.camera.ui.menu.levelcontrol.o_renamed.i_renamed()) / 2.0f) * 1.0f, 0.0f);
                    this.G_renamed.a_renamed(this.v_renamed.get(i4).c_renamed(), i4);
                    com.oplus.camera.ui.menu.levelcontrol.p_renamed.c_renamed();
                } else {
                    com.oplus.camera.e_renamed.f_renamed("GLProducerRender3D", "onDrawFrame, mRingTexs[" + i4 + "] not init.");
                }
            }
        }
        com.oplus.camera.ui.menu.levelcontrol.p_renamed.c_renamed();
        com.oplus.camera.gl_renamed.i_renamed.i_renamed();
    }

    private boolean a_renamed(int i_renamed, float f_renamed) {
        float fA_renamed = (((float) com.oplus.camera.ui.menu.levelcontrol.o_renamed.a_renamed()) / 2.0f) + com.oplus.camera.ui.menu.levelcontrol.o_renamed.g_renamed();
        float f2 = f_renamed + fA_renamed;
        float f3 = f_renamed - fA_renamed;
        float fD_renamed = d_renamed(i_renamed);
        return fD_renamed >= f3 && fD_renamed <= f2;
    }

    private float d_renamed(int i_renamed) {
        return (-i_renamed) * com.oplus.camera.ui.menu.levelcontrol.o_renamed.g_renamed();
    }

    private void c_renamed(com.oplus.camera.ui.menu.levelcontrol.i_renamed iVar) {
        float f_renamed;
        float f2;
        float f3;
        com.oplus.camera.e_renamed.a_renamed("GLProducerRender3D", "updateElementsParam, glModelParam: " + iVar.toString());
        com.oplus.camera.ui.menu.levelcontrol.o_renamed.e_renamed(iVar.p_renamed());
        com.oplus.camera.ui.menu.levelcontrol.o_renamed.b_renamed(iVar.r_renamed());
        com.oplus.camera.ui.menu.levelcontrol.o_renamed.c_renamed(iVar.s_renamed());
        int i_renamed = 0;
        if (this.G_renamed != null && this.v_renamed != null) {
            this.G_renamed.a_renamed();
            for (int i2 = 0; i2 < this.v_renamed.size(); i2++) {
                if (this.v_renamed.get(i2).d_renamed() != 0) {
                    f2 = 0.0f;
                    f3 = 0.0f;
                    f_renamed = 0.0f;
                } else {
                    float fA_renamed = com.oplus.camera.ui.menu.levelcontrol.o_renamed.a_renamed(iVar.t_renamed());
                    f_renamed = (-fA_renamed) / 2.0f;
                    f2 = fA_renamed;
                    f3 = f2;
                }
                this.G_renamed.a_renamed(f2, f3, 10.0f, com.oplus.camera.ui.menu.levelcontrol.o_renamed.p_renamed(), f_renamed);
            }
        }
        if (this.d_renamed != null) {
            this.d_renamed.a_renamed();
            if (iVar.v_renamed()) {
                this.d_renamed.a_renamed(1.0f, com.oplus.camera.ui.menu.levelcontrol.o_renamed.b_renamed(), com.oplus.camera.ui.menu.levelcontrol.o_renamed.i_renamed(), com.oplus.camera.ui.menu.levelcontrol.o_renamed.j_renamed(), com.oplus.camera.ui.menu.levelcontrol.o_renamed.a_renamed(0), (com.oplus.camera.ui.menu.levelcontrol.o_renamed.g_renamed() * (iVar.a_renamed().size() - 1)) + com.oplus.camera.ui.menu.levelcontrol.o_renamed.e_renamed(), false, iVar);
                while (i_renamed < iVar.g_renamed()) {
                    this.d_renamed.a_renamed(1.0f, com.oplus.camera.ui.menu.levelcontrol.o_renamed.b_renamed(), com.oplus.camera.ui.menu.levelcontrol.o_renamed.i_renamed(), com.oplus.camera.ui.menu.levelcontrol.o_renamed.j_renamed(), com.oplus.camera.ui.menu.levelcontrol.o_renamed.a_renamed(i_renamed), com.oplus.camera.ui.menu.levelcontrol.o_renamed.e_renamed(), true, iVar);
                    i_renamed++;
                }
            } else {
                while (i_renamed < iVar.g_renamed()) {
                    this.d_renamed.a_renamed(1.0f, com.oplus.camera.ui.menu.levelcontrol.o_renamed.b_renamed(), com.oplus.camera.ui.menu.levelcontrol.o_renamed.i_renamed(), com.oplus.camera.ui.menu.levelcontrol.o_renamed.j_renamed(), com.oplus.camera.ui.menu.levelcontrol.o_renamed.a_renamed(i_renamed), com.oplus.camera.ui.menu.levelcontrol.o_renamed.e_renamed(), false, iVar);
                    i_renamed++;
                }
            }
        }
        com.oplus.camera.ui.menu.levelcontrol.p_renamed.a_renamed(com.oplus.camera.ui.menu.levelcontrol.o_renamed.k_renamed(), com.oplus.camera.ui.menu.levelcontrol.o_renamed.l_renamed(), com.oplus.camera.ui.menu.levelcontrol.o_renamed.m_renamed(), com.oplus.camera.ui.menu.levelcontrol.o_renamed.n_renamed(), 10.0f, 100.0f);
        this.p_renamed = iVar;
    }

    @Override // com.oplus.camera.ui.menu.levelcontrol.j_renamed
    public void a_renamed(com.oplus.camera.ui.menu.levelcontrol.i_renamed iVar, boolean z_renamed) {
        com.oplus.camera.e_renamed.a_renamed("GLProducerRender3D", "createTextures, glModelParam: " + iVar.toString());
        this.r_renamed = false;
        this.q_renamed = false;
        this.f6531b = iVar.l_renamed();
        a_renamed(0, this.e_renamed ? iVar.f_renamed() : iVar.e_renamed());
        if (this.d_renamed != null) {
            this.d_renamed.a_renamed(iVar.u_renamed());
        }
        if (iVar.v_renamed()) {
            int iWidth = iVar.a_renamed().get(0).rect.width();
            int i_renamed = iVar.a_renamed().get(iVar.a_renamed().size() - 1).rect.bottom - iVar.a_renamed().get(0).rect.top;
            if (this.m_renamed == null) {
                this.m_renamed = new com.oplus.camera.ui.menu.levelcontrol.t_renamed(iWidth, i_renamed, -1);
                if (!this.m_renamed.h_renamed()) {
                    this.m_renamed.a_renamed();
                }
                if (this.J_renamed) {
                    c_renamed(iVar);
                }
            } else {
                if (iWidth != this.m_renamed.e_renamed() || i_renamed != this.m_renamed.f_renamed()) {
                    this.m_renamed.b_renamed();
                    this.m_renamed = new com.oplus.camera.ui.menu.levelcontrol.t_renamed(iWidth, i_renamed, -1);
                    if (!this.m_renamed.h_renamed()) {
                        this.m_renamed.a_renamed();
                    }
                }
                if (z_renamed) {
                    c_renamed(iVar);
                }
            }
        } else {
            if (iVar.d_renamed() == null) {
                return;
            }
            if (this.H_renamed == null) {
                a_renamed(iVar.d_renamed());
                if (this.J_renamed) {
                    c_renamed(iVar);
                }
            } else {
                a_renamed(iVar.d_renamed());
                if (z_renamed) {
                    c_renamed(iVar);
                }
            }
        }
        if (this.d_renamed != null) {
            this.d_renamed.b_renamed(iVar.i_renamed(), iVar.h_renamed());
        }
    }

    public void a_renamed(java.util.List<android.graphics.Bitmap> list) {
        com.oplus.camera.e_renamed.a_renamed("GLProducerRender3D", "createCylinderSideTexs, bitmaps: " + list);
        if (this.H_renamed == null) {
            this.H_renamed = new java.util.ArrayList<>();
        }
        if (this.H_renamed.size() > 0) {
            java.util.Iterator<com.oplus.camera.ui.menu.levelcontrol.t_renamed> it = this.H_renamed.iterator();
            while (it.hasNext()) {
                it.next().b_renamed();
            }
            this.H_renamed.clear();
        }
        for (int i_renamed = 0; i_renamed < list.size(); i_renamed++) {
            com.oplus.camera.ui.menu.levelcontrol.t_renamed tVar = new com.oplus.camera.ui.menu.levelcontrol.t_renamed();
            if (!tVar.h_renamed()) {
                tVar.a_renamed(list.get(i_renamed));
            }
            this.H_renamed.add(tVar);
        }
    }

    @Override // com.oplus.camera.ui.menu.levelcontrol.j_renamed
    public void j_renamed() {
        super.j_renamed();
        com.oplus.camera.e_renamed.a_renamed("GLProducerRender3D", "releaseResource");
        java.util.ArrayList<com.oplus.camera.ui.menu.levelcontrol.t_renamed> arrayList = this.H_renamed;
        if (arrayList != null && arrayList.size() > 0) {
            java.util.Iterator<com.oplus.camera.ui.menu.levelcontrol.t_renamed> it = this.H_renamed.iterator();
            while (it.hasNext()) {
                it.next().b_renamed();
            }
            this.H_renamed.clear();
            this.H_renamed = null;
        }
        if (this.v_renamed != null && this.v_renamed.size() > 0) {
            java.util.Iterator<com.oplus.camera.ui.menu.levelcontrol.t_renamed> it2 = this.v_renamed.iterator();
            while (it2.hasNext()) {
                it2.next().b_renamed();
            }
            this.v_renamed.clear();
            this.v_renamed = null;
        }
        com.oplus.camera.ui.menu.levelcontrol.t_renamed tVar = this.I_renamed;
        if (tVar != null) {
            tVar.b_renamed();
            this.I_renamed = null;
        }
    }
}

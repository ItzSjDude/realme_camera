package com.oplus.camera.ui.menu.levelcontrol;

/* compiled from: GLProducerRender.java */
/* loaded from: classes2.dex */
public abstract class j_renamed implements com.oplus.camera.gl_renamed.m_renamed.GLProducer_6, com.oplus.camera.ui.inverse.a_renamed {
    private int[] G_renamed;

    /* renamed from: a_renamed, reason: collision with root package name */
    protected android.content.Context f6530a;
    protected float w_renamed;
    protected float x_renamed;

    /* renamed from: b_renamed, reason: collision with root package name */
    protected int f6531b = 0;

    /* renamed from: c_renamed, reason: collision with root package name */
    protected com.oplus.camera.ui.menu.levelcontrol.j_renamed.a_renamed f6532c = null;
    protected com.oplus.camera.ui.menu.levelcontrol.a_renamed d_renamed = null;
    protected boolean e_renamed = false;
    protected float f_renamed = 0.0f;
    protected float g_renamed = 0.0f;
    protected float h_renamed = 0.0f;
    protected int i_renamed = 0;
    protected int j_renamed = 26;
    protected android.view.animation.Interpolator k_renamed = new android.view.animation.PathInterpolator(0.0f, 0.1f, 0.1f, 1.0f);
    protected com.oplus.camera.ui.menu.levelcontrol.j_renamed.b_renamed l_renamed = null;
    protected com.oplus.camera.ui.menu.levelcontrol.t_renamed m_renamed = null;
    protected com.oplus.camera.ui.menu.levelcontrol.t_renamed n_renamed = null;
    protected com.oplus.camera.ui.menu.levelcontrol.t_renamed o_renamed = null;
    protected com.oplus.camera.ui.menu.levelcontrol.i_renamed p_renamed = null;
    protected boolean q_renamed = false;
    protected boolean r_renamed = false;
    protected boolean s_renamed = false;
    protected float[] t_renamed = {0.0f, 0.0f, 0.0f, 0.0f};
    protected int u_renamed = 10;
    protected java.util.ArrayList<com.oplus.camera.ui.menu.levelcontrol.t_renamed> v_renamed = null;
    protected int y_renamed = -1;
    protected int z_renamed = -1;
    protected int A_renamed = -1;
    protected int B_renamed = -1;
    protected int C_renamed = -1;
    protected int D_renamed = -1;
    protected boolean E_renamed = true;
    protected com.oplus.camera.ui.preview.a_renamed.l_renamed.a_renamed F_renamed = com.oplus.camera.ui.preview.a_renamed.l_renamed.a_renamed.Polarr;

    /* compiled from: GLProducerRender.java */
    public interface a_renamed {
        void a_renamed();

        void a_renamed(com.oplus.camera.ui.menu.levelcontrol.j_renamed jVar);

        void b_renamed();
    }

    /* compiled from: GLProducerRender.java */
    public interface b_renamed {
        void a_renamed(float f_renamed);

        void b_renamed(float f_renamed);
    }

    public abstract void a_renamed(com.oplus.camera.ui.menu.levelcontrol.i_renamed iVar, boolean z_renamed);

    public void b_renamed(com.oplus.camera.ui.menu.levelcontrol.i_renamed iVar) {
    }

    protected abstract void b_renamed(javax.microedition.khronos.opengles.GL10 gl10);

    public void a_renamed(boolean z_renamed) {
        this.E_renamed = z_renamed;
    }

    public j_renamed(android.content.Context context) {
        this.f6530a = null;
        this.f6530a = context;
    }

    public void a_renamed(int i_renamed) {
        this.f6531b = i_renamed;
    }

    public void a_renamed(com.oplus.camera.ui.menu.levelcontrol.j_renamed.a_renamed aVar) {
        this.f6532c = aVar;
    }

    public void a_renamed(com.oplus.camera.ui.preview.a_renamed.l_renamed.a_renamed aVar) {
        this.F_renamed = aVar;
        com.oplus.camera.ui.menu.levelcontrol.a_renamed aVar2 = this.d_renamed;
        if (aVar2 != null) {
            aVar2.a_renamed(aVar);
        }
    }

    @Override // com.oplus.camera.ui.inverse.a_renamed
    public void setInverseColor(boolean z_renamed) {
        this.e_renamed = z_renamed;
        com.oplus.camera.ui.menu.levelcontrol.j_renamed.a_renamed aVar = this.f6532c;
        if (aVar != null) {
            aVar.b_renamed();
        }
    }

    public void a_renamed(float f_renamed, float f2, int i_renamed, android.view.animation.Interpolator interpolator, com.oplus.camera.ui.menu.levelcontrol.j_renamed.b_renamed bVar) {
        int i2;
        this.f_renamed = f_renamed;
        this.g_renamed = f_renamed + f2;
        this.h_renamed = f2;
        com.oplus.camera.e_renamed.a_renamed("GLProducerRender", "startScrollAnim, mCurrPosition: " + this.f_renamed + ", mToPosition: " + this.g_renamed + ", mAnimDistance: " + this.h_renamed);
        if (i_renamed <= 0) {
            com.oplus.camera.e_renamed.a_renamed("GLProducerRender", "startScrollAnim, durationFrame must > 0!");
            i_renamed = 1;
        } else {
            int i3 = this.i_renamed;
            if (i3 > 0 && (i2 = this.j_renamed) > i3) {
                i_renamed = i2 - i3;
                this.i_renamed = 0;
            }
        }
        this.j_renamed = i_renamed;
        if (interpolator != null) {
            this.k_renamed = interpolator;
        }
        if (bVar != null) {
            this.l_renamed = bVar;
        }
    }

    public void a_renamed() {
        this.h_renamed = 0.0f;
        this.i_renamed = 0;
    }

    public float b_renamed() {
        return this.f_renamed;
    }

    public void a_renamed(com.oplus.camera.gl_renamed.m_renamed mVar) {
        if (mVar != null) {
            mVar.a_renamed(new java.lang.Runnable() { // from class: com.oplus.camera.ui.menu.levelcontrol.j_renamed.1
                @Override // java.lang.Runnable
                public void run() {
                    if (com.oplus.camera.ui.menu.levelcontrol.j_renamed.this.d_renamed != null) {
                        com.oplus.camera.ui.menu.levelcontrol.j_renamed.this.d_renamed.c_renamed();
                    }
                    com.oplus.camera.ui.menu.levelcontrol.j_renamed.this.j_renamed();
                }
            });
        }
    }

    public void c_renamed() {
        com.oplus.camera.ui.menu.levelcontrol.a_renamed aVar = this.d_renamed;
        if (aVar != null) {
            aVar.d_renamed();
        }
    }

    public void b_renamed(com.oplus.camera.gl_renamed.m_renamed mVar) {
        if (mVar != null) {
            mVar.a_renamed(new java.lang.Runnable() { // from class: com.oplus.camera.ui.menu.levelcontrol.j_renamed.2
                @Override // java.lang.Runnable
                public void run() {
                    if (com.oplus.camera.ui.menu.levelcontrol.j_renamed.this.m_renamed != null) {
                        co_renamed.polarr.renderer.PolarrRender.clearTextureHelper(com.oplus.camera.ui.menu.levelcontrol.j_renamed.this.m_renamed.c_renamed(), com.oplus.camera.ui.menu.levelcontrol.j_renamed.this.m_renamed.e_renamed(), com.oplus.camera.ui.menu.levelcontrol.j_renamed.this.m_renamed.f_renamed());
                        com.oplus.camera.ui.menu.levelcontrol.j_renamed.this.m_renamed.b_renamed();
                        com.oplus.camera.ui.menu.levelcontrol.j_renamed jVar = com.oplus.camera.ui.menu.levelcontrol.j_renamed.this;
                        jVar.m_renamed = null;
                        jVar.o_renamed.b_renamed();
                        com.oplus.camera.ui.menu.levelcontrol.j_renamed.this.o_renamed = null;
                    }
                }
            });
        }
    }

    public boolean d_renamed() {
        com.oplus.camera.ui.menu.levelcontrol.a_renamed aVar = this.d_renamed;
        if (aVar != null) {
            return aVar.e_renamed();
        }
        return false;
    }

    public void e_renamed() {
        com.oplus.camera.ui.menu.levelcontrol.a_renamed aVar = this.d_renamed;
        if (aVar != null) {
            aVar.a_renamed(this.f6530a);
            com.oplus.camera.ui.menu.levelcontrol.i_renamed iVar = this.p_renamed;
            if (iVar != null) {
                this.d_renamed.b_renamed(iVar.i_renamed(), this.p_renamed.h_renamed());
            }
        }
    }

    private void k_renamed() {
        if (this.G_renamed == null) {
            this.G_renamed = new int[1];
            android.opengl.GLES20.glGenFramebuffers(1, this.G_renamed, 0);
        }
        android.opengl.GLES20.glBindFramebuffer(36160, this.G_renamed[0]);
        android.opengl.GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.m_renamed.c_renamed(), 0);
        float[] fArr = this.t_renamed;
        android.opengl.GLES20.glClearColor(fArr[1], fArr[2], fArr[3], fArr[0]);
        android.opengl.GLES20.glClear(16384);
        android.opengl.GLES20.glBindFramebuffer(36160, 0);
        com.oplus.camera.gl_renamed.i_renamed.i_renamed();
    }

    public void b_renamed(int i_renamed) {
        com.oplus.camera.ui.menu.levelcontrol.i_renamed iVar = this.p_renamed;
        if (iVar == null || iVar.g_renamed() <= 0) {
            com.oplus.camera.e_renamed.f_renamed("GLProducerRender", "onDrawFrame, vertex not ready");
            return;
        }
        if (this.d_renamed.e_renamed() && this.m_renamed != null) {
            if (this.s_renamed && !this.q_renamed) {
                k_renamed();
                this.q_renamed = this.d_renamed.a_renamed(i_renamed, this.m_renamed.c_renamed(), this.p_renamed.a_renamed(), this.f_renamed);
            } else if (!this.s_renamed) {
                if (java.lang.Float.compare(this.h_renamed, 0.0f) == 0 || !this.q_renamed) {
                    k_renamed();
                }
                this.q_renamed = this.d_renamed.a_renamed(i_renamed, this.m_renamed.c_renamed(), this.p_renamed.a_renamed(), this.f_renamed);
            }
            this.d_renamed.e_renamed(this.m_renamed.c_renamed(), 0);
            return;
        }
        for (int i2 = 0; i2 < this.p_renamed.g_renamed(); i2++) {
            a_renamed(i_renamed, i2, (int) this.p_renamed.q_renamed(), (int) this.p_renamed.r_renamed());
        }
        com.oplus.camera.e_renamed.a_renamed("GLProducerRender", "onDrawFrame, drawOesTexture.");
    }

    public void a_renamed(int i_renamed, int i2) {
        com.oplus.camera.e_renamed.a_renamed("GLProducerRender", "notifyPreviewSizeChanged, Size: " + i_renamed + "x_renamed" + i2);
        com.oplus.camera.ui.menu.levelcontrol.i_renamed iVar = this.p_renamed;
        if (iVar == null || !iVar.v_renamed()) {
            return;
        }
        if (this.p_renamed.h_renamed() == i_renamed && this.p_renamed.i_renamed() == i2) {
            return;
        }
        if (java.lang.Math.abs((i_renamed / i2) - (this.p_renamed.h_renamed() / this.p_renamed.i_renamed())) < 0.01d) {
            return;
        }
        this.p_renamed.b_renamed(i_renamed);
        this.p_renamed.c_renamed(i2);
        this.r_renamed = true;
    }

    public void f_renamed() {
        com.oplus.camera.ui.menu.levelcontrol.i_renamed iVar;
        if (this.r_renamed && (iVar = this.p_renamed) != null && iVar.v_renamed()) {
            if (this.p_renamed.h_renamed() == this.p_renamed.j_renamed() && this.p_renamed.i_renamed() == this.p_renamed.k_renamed()) {
                return;
            }
            com.oplus.camera.ui.menu.levelcontrol.i_renamed iVar2 = this.p_renamed;
            iVar2.d_renamed(iVar2.h_renamed());
            com.oplus.camera.ui.menu.levelcontrol.i_renamed iVar3 = this.p_renamed;
            iVar3.e_renamed(iVar3.i_renamed());
            com.oplus.camera.ui.menu.levelcontrol.i_renamed iVar4 = this.p_renamed;
            com.oplus.camera.ui.preview.a_renamed.j_renamed.a_renamed(iVar4, iVar4.i_renamed(), this.p_renamed.h_renamed());
            this.u_renamed = 0;
            a_renamed(this.p_renamed, true);
        }
    }

    public void a_renamed(float[] fArr) {
        this.t_renamed = fArr;
    }

    public int g_renamed() {
        com.oplus.camera.ui.menu.levelcontrol.i_renamed iVar = this.p_renamed;
        if (iVar != null) {
            return iVar.g_renamed();
        }
        return 0;
    }

    public boolean h_renamed() {
        com.oplus.camera.ui.menu.levelcontrol.i_renamed iVar = this.p_renamed;
        if (iVar != null) {
            return iVar.v_renamed();
        }
        return false;
    }

    public boolean a_renamed(com.oplus.camera.ui.menu.levelcontrol.i_renamed iVar) {
        com.oplus.camera.ui.menu.levelcontrol.i_renamed iVar2 = this.p_renamed;
        return iVar2 != null && iVar2.a_renamed(iVar);
    }

    public void a_renamed(int i_renamed, java.lang.String str) {
        com.oplus.camera.ui.menu.levelcontrol.i_renamed iVar = this.p_renamed;
        if (iVar == null || iVar.a_renamed() == null || i_renamed >= this.p_renamed.a_renamed().size() || this.p_renamed.a_renamed().get(i_renamed) == null) {
            return;
        }
        this.p_renamed.a_renamed().get(i_renamed).filterId = str;
    }

    public void c_renamed(int i_renamed) {
        com.oplus.camera.ui.menu.levelcontrol.i_renamed iVar = this.p_renamed;
        if (iVar == null || iVar.a_renamed() == null || i_renamed >= this.p_renamed.a_renamed().size() || this.p_renamed.a_renamed().get(i_renamed) == null) {
            return;
        }
        com.oplus.camera.ui.preview.a_renamed.k_renamed kVar = this.p_renamed.b_renamed().get(i_renamed);
        com.oplus.camera.ui.preview.a_renamed.j_renamed.a_renamed(this.p_renamed.a_renamed().get(i_renamed), kVar.f6909b, this.p_renamed.m_renamed());
        kVar.f6910c = false;
        b_renamed(this.p_renamed);
    }

    public void i_renamed() {
        b_renamed(this.p_renamed);
    }

    private void a_renamed(int i_renamed, int i2, int i3, int i4) {
        android.graphics.Bitmap bitmapDecodeResource;
        android.graphics.Bitmap bitmapDecodeResource2;
        android.graphics.Bitmap bitmapDecodeResource3;
        android.graphics.Bitmap bitmapDecodeResource4;
        android.graphics.Bitmap bitmapDecodeResource5;
        android.graphics.Bitmap bitmapDecodeResource6;
        if (i2 == this.p_renamed.a_renamed("portrait_retention") || i2 == this.p_renamed.a_renamed("oplus_video_filter_portrait_retention")) {
            if (-1 == this.y_renamed) {
                if (this.p_renamed.m_renamed()) {
                    bitmapDecodeResource = com.oplus.camera.util.Util.a_renamed(android.graphics.BitmapFactory.decodeResource(this.f6530a.getResources(), com.oplus.camera.R_renamed.drawable.filter_retention));
                } else {
                    bitmapDecodeResource = android.graphics.BitmapFactory.decodeResource(this.f6530a.getResources(), com.oplus.camera.R_renamed.drawable.filter_retention);
                }
                this.y_renamed = com.oplus.camera.util.k_renamed.a_renamed(com.oplus.camera.ui.preview.a_renamed.j_renamed.a_renamed(bitmapDecodeResource, i3, i4));
            }
            this.d_renamed.d_renamed(this.y_renamed, i2 + 1);
            return;
        }
        if (i2 == this.p_renamed.a_renamed("portrait_streamer")) {
            if (-1 == this.A_renamed) {
                if (this.p_renamed.m_renamed()) {
                    bitmapDecodeResource6 = com.oplus.camera.util.Util.a_renamed(android.graphics.BitmapFactory.decodeResource(this.f6530a.getResources(), com.oplus.camera.R_renamed.drawable.icon_portrait_streamer));
                } else {
                    bitmapDecodeResource6 = android.graphics.BitmapFactory.decodeResource(this.f6530a.getResources(), com.oplus.camera.R_renamed.drawable.icon_portrait_streamer);
                }
                this.A_renamed = com.oplus.camera.util.k_renamed.a_renamed(com.oplus.camera.ui.preview.a_renamed.j_renamed.a_renamed(bitmapDecodeResource6, i3, i4));
            }
            this.d_renamed.d_renamed(this.A_renamed, i2 + 1);
            return;
        }
        if (i2 == this.p_renamed.a_renamed("neon-2020.cube.rgb.bin") || i2 == this.p_renamed.a_renamed("oplus_video_filter_neon")) {
            if (-1 == this.z_renamed) {
                if (this.p_renamed.m_renamed()) {
                    bitmapDecodeResource2 = com.oplus.camera.util.Util.a_renamed(android.graphics.BitmapFactory.decodeResource(this.f6530a.getResources(), com.oplus.camera.R_renamed.drawable.filter_portrait_neon));
                } else {
                    bitmapDecodeResource2 = android.graphics.BitmapFactory.decodeResource(this.f6530a.getResources(), com.oplus.camera.R_renamed.drawable.filter_portrait_neon);
                }
                this.z_renamed = com.oplus.camera.util.k_renamed.a_renamed(com.oplus.camera.ui.preview.a_renamed.j_renamed.a_renamed(bitmapDecodeResource2, i3, i4));
            }
            this.d_renamed.d_renamed(this.z_renamed, i2 + 1);
            return;
        }
        if (i2 == this.p_renamed.a_renamed(co_renamed.polarr.renderer.FilterPackageUtil.SKY_BLUE_2020)) {
            if (-1 == this.C_renamed) {
                if (this.p_renamed.m_renamed()) {
                    bitmapDecodeResource5 = com.oplus.camera.util.Util.a_renamed(android.graphics.BitmapFactory.decodeResource(this.f6530a.getResources(), com.oplus.camera.R_renamed.drawable.icon_filter_video_blue));
                } else {
                    bitmapDecodeResource5 = android.graphics.BitmapFactory.decodeResource(this.f6530a.getResources(), com.oplus.camera.R_renamed.drawable.icon_filter_video_blue);
                }
                this.C_renamed = com.oplus.camera.util.k_renamed.a_renamed(com.oplus.camera.ui.preview.a_renamed.j_renamed.a_renamed(bitmapDecodeResource5, i3, i4));
            }
            this.d_renamed.d_renamed(this.C_renamed, i2 + 1);
            return;
        }
        if (i2 == this.p_renamed.a_renamed(co_renamed.polarr.renderer.FilterPackageUtil.RED_RED_2020)) {
            if (-1 == this.B_renamed) {
                if (this.p_renamed.m_renamed()) {
                    bitmapDecodeResource4 = com.oplus.camera.util.Util.a_renamed(android.graphics.BitmapFactory.decodeResource(this.f6530a.getResources(), com.oplus.camera.R_renamed.drawable.icon_filter_video_red));
                } else {
                    bitmapDecodeResource4 = android.graphics.BitmapFactory.decodeResource(this.f6530a.getResources(), com.oplus.camera.R_renamed.drawable.icon_filter_video_red);
                }
                this.B_renamed = com.oplus.camera.util.k_renamed.a_renamed(com.oplus.camera.ui.preview.a_renamed.j_renamed.a_renamed(bitmapDecodeResource4, i3, i4));
            }
            this.d_renamed.d_renamed(this.B_renamed, i2 + 1);
            return;
        }
        if (i2 == this.p_renamed.a_renamed(co_renamed.polarr.renderer.FilterPackageUtil.TREE_GREEN_2020)) {
            if (-1 == this.D_renamed) {
                if (this.p_renamed.m_renamed()) {
                    bitmapDecodeResource3 = com.oplus.camera.util.Util.a_renamed(android.graphics.BitmapFactory.decodeResource(this.f6530a.getResources(), com.oplus.camera.R_renamed.drawable.icon_filter_video_green));
                } else {
                    bitmapDecodeResource3 = android.graphics.BitmapFactory.decodeResource(this.f6530a.getResources(), com.oplus.camera.R_renamed.drawable.icon_filter_video_green);
                }
                this.D_renamed = com.oplus.camera.util.k_renamed.a_renamed(com.oplus.camera.ui.preview.a_renamed.j_renamed.a_renamed(bitmapDecodeResource3, i3, i4));
            }
            this.d_renamed.d_renamed(this.D_renamed, i2 + 1);
            return;
        }
        this.d_renamed.f_renamed(i_renamed, 0);
    }

    @Override // com.oplus.camera.gl_renamed.m_renamed.GLProducer_6
    public void a_renamed(javax.microedition.khronos.opengles.GL10 gl10) {
        com.oplus.camera.ui.menu.levelcontrol.i_renamed iVar = this.p_renamed;
        if (iVar == null || iVar.g_renamed() <= 0) {
            com.oplus.camera.e_renamed.f_renamed("GLProducerRender", "onDrawFrame, vertex not ready");
            return;
        }
        com.oplus.camera.ui.menu.levelcontrol.i_renamed iVar2 = this.p_renamed;
        if (iVar2 != null && iVar2.v_renamed() && this.u_renamed < 10) {
            com.oplus.camera.e_renamed.a_renamed("GLProducerRender", "onDrawFrame, mDisableFrameNum: " + this.u_renamed);
            this.u_renamed = this.u_renamed + 1;
            return;
        }
        com.oplus.camera.gl_renamed.i_renamed.i_renamed();
        float[] fArr = this.t_renamed;
        android.opengl.GLES20.glClearColor(fArr[1], fArr[2], fArr[3], fArr[0]);
        android.opengl.GLES20.glClear(16640);
        b_renamed(gl10);
    }

    public void a_renamed(int i_renamed, android.graphics.Bitmap bitmap) {
        if (this.v_renamed == null) {
            this.v_renamed = new java.util.ArrayList<>();
        }
        java.util.Iterator<com.oplus.camera.ui.menu.levelcontrol.t_renamed> it = this.v_renamed.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            com.oplus.camera.ui.menu.levelcontrol.t_renamed next = it.next();
            if (next.d_renamed() == i_renamed) {
                next.b_renamed();
                this.v_renamed.remove(next);
                break;
            }
        }
        this.n_renamed = new com.oplus.camera.ui.menu.levelcontrol.t_renamed(0);
        if (!this.n_renamed.h_renamed()) {
            this.n_renamed.a_renamed(bitmap);
        }
        this.v_renamed.add(this.n_renamed);
        com.oplus.camera.e_renamed.a_renamed("GLProducerRender", "createRingTexture, length: " + this.v_renamed.size() + ", type: " + i_renamed);
    }

    public void j_renamed() {
        com.oplus.camera.e_renamed.a_renamed("GLProducerRender", "releaseResource");
        com.oplus.camera.ui.menu.levelcontrol.t_renamed tVar = this.m_renamed;
        if (tVar != null) {
            co_renamed.polarr.renderer.PolarrRender.clearTextureHelper(tVar.c_renamed(), this.m_renamed.e_renamed(), this.m_renamed.f_renamed());
            this.m_renamed.b_renamed();
            this.m_renamed = null;
        }
        com.oplus.camera.ui.menu.levelcontrol.t_renamed tVar2 = this.o_renamed;
        if (tVar2 != null) {
            tVar2.b_renamed();
            this.o_renamed = null;
        }
        int i_renamed = this.y_renamed;
        if (-1 != i_renamed) {
            com.oplus.camera.util.k_renamed.a_renamed(i_renamed);
            this.y_renamed = -1;
        }
        int i2 = this.z_renamed;
        if (-1 != i2) {
            com.oplus.camera.util.k_renamed.a_renamed(i2);
            this.z_renamed = -1;
        }
        int i3 = this.A_renamed;
        if (-1 != i3) {
            com.oplus.camera.util.k_renamed.a_renamed(i3);
            this.A_renamed = -1;
        }
        int i4 = this.C_renamed;
        if (-1 != i4) {
            com.oplus.camera.util.k_renamed.a_renamed(i4);
            this.C_renamed = -1;
        }
        int i5 = this.B_renamed;
        if (-1 != i5) {
            com.oplus.camera.util.k_renamed.a_renamed(i5);
            this.B_renamed = -1;
        }
        int i6 = this.D_renamed;
        if (-1 != i6) {
            com.oplus.camera.util.k_renamed.a_renamed(i6);
            this.D_renamed = -1;
        }
        int[] iArr = this.G_renamed;
        if (iArr != null) {
            android.opengl.GLES20.glDeleteBuffers(1, iArr, 0);
            this.G_renamed = null;
        }
    }

    public void a_renamed(float f_renamed, float f2) {
        this.w_renamed = f_renamed;
        this.x_renamed = f2;
    }
}

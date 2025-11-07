package com.oplus.camera.ui.menu.levelcontrol;

/* compiled from: BaseFilterMenuCanvas.java */
/* loaded from: classes2.dex */
public abstract class a_renamed {
    private float C_renamed;
    private com.oplus.camera.ui.preview.a_renamed.s_renamed w_renamed;
    private com.oplus.camera.ui.preview.a_renamed.b_renamed x_renamed;
    private boolean y_renamed = false;
    private float z_renamed = 0.0f;
    private com.oplus.camera.ui.preview.a_renamed.l_renamed.a_renamed A_renamed = com.oplus.camera.ui.preview.a_renamed.l_renamed.a_renamed.Polarr;

    /* renamed from: a_renamed, reason: collision with root package name */
    protected int f6472a = 0;

    /* renamed from: b_renamed, reason: collision with root package name */
    protected int f6473b = 0;

    /* renamed from: c_renamed, reason: collision with root package name */
    protected int f6474c = 0;
    protected int d_renamed = 0;
    protected float e_renamed = 1.0f;
    protected float f_renamed = 1.0f;
    protected float g_renamed = 1.0f;
    protected float h_renamed = 1.0f;
    protected java.util.ArrayList<java.lang.Integer> i_renamed = new java.util.ArrayList<>();
    protected java.util.ArrayList<java.nio.FloatBuffer> j_renamed = new java.util.ArrayList<>();
    protected java.util.ArrayList<java.nio.FloatBuffer> k_renamed = new java.util.ArrayList<>();
    protected java.util.ArrayList<java.nio.FloatBuffer> l_renamed = new java.util.ArrayList<>();
    protected float m_renamed = 1.0f;
    protected float n_renamed = 1.0f;
    protected int o_renamed = -1;
    protected int p_renamed = -1;
    protected float[] q_renamed = {0.0f, 0.0f};
    protected float r_renamed = 1.0f;
    protected float s_renamed = 1.0f;
    protected float t_renamed = 0.0f;
    protected float u_renamed = 0.0f;
    private float B_renamed = 0.0f;
    protected float[] v_renamed = {1.0f, 1.0f, 1.0f, 1.0f};

    public void a_renamed(float f_renamed, float f2, float f3, int i_renamed, float f4, float f5, boolean z_renamed, com.oplus.camera.ui.menu.levelcontrol.i_renamed iVar) {
    }

    public void a_renamed(com.oplus.camera.ui.menu.levelcontrol.i_renamed iVar) {
    }

    protected abstract void b_renamed(android.content.Context context);

    public void c_renamed(int i_renamed, int i2) {
    }

    public void d_renamed(int i_renamed, int i2) {
    }

    public abstract void e_renamed(int i_renamed, int i2);

    public abstract void f_renamed(int i_renamed, int i2);

    public a_renamed() {
        this.w_renamed = null;
        this.x_renamed = null;
        this.C_renamed = 0.0f;
        this.w_renamed = new com.oplus.camera.ui.preview.a_renamed.s_renamed();
        this.x_renamed = new com.oplus.camera.ui.preview.a_renamed.b_renamed();
        this.C_renamed = com.oplus.camera.util.Util.h_renamed(com.oplus.camera.R_renamed.dimen.filter_selector_thickness);
    }

    private com.oplus.camera.ui.preview.a_renamed.a_renamed f_renamed() {
        if (com.oplus.camera.ui.preview.a_renamed.l_renamed.a_renamed.Polarr == this.A_renamed) {
            return this.w_renamed;
        }
        return this.x_renamed;
    }

    public void a_renamed(com.oplus.camera.ui.preview.a_renamed.l_renamed.a_renamed aVar) {
        this.A_renamed = aVar;
    }

    public void a_renamed(int i_renamed, int i2) {
        com.oplus.camera.e_renamed.a_renamed("BaseFilterMenuCanvas", "setSize, width = " + i_renamed + ", height = " + i2);
        float[] fArr = this.q_renamed;
        fArr[0] = (float) i_renamed;
        fArr[1] = (float) i2;
        this.f6472a = i_renamed;
        this.f6473b = i2;
    }

    public void a_renamed(float f_renamed) {
        this.z_renamed = f_renamed;
    }

    public void a_renamed() {
        java.util.ArrayList<java.lang.Integer> arrayList = this.i_renamed;
        if (arrayList != null) {
            arrayList.clear();
        }
        java.util.ArrayList<java.nio.FloatBuffer> arrayList2 = this.j_renamed;
        if (arrayList2 != null) {
            arrayList2.clear();
        }
        java.util.ArrayList<java.nio.FloatBuffer> arrayList3 = this.k_renamed;
        if (arrayList3 != null) {
            arrayList3.clear();
        }
        java.util.ArrayList<java.nio.FloatBuffer> arrayList4 = this.l_renamed;
        if (arrayList4 != null) {
            arrayList4.clear();
        }
    }

    public int b_renamed() {
        java.util.ArrayList<java.nio.FloatBuffer> arrayList = this.j_renamed;
        if (arrayList != null) {
            return arrayList.size();
        }
        return 0;
    }

    public void a_renamed(android.content.Context context) {
        this.y_renamed = true;
        this.w_renamed.a_renamed(context, 2, 2);
        if (com.oplus.camera.aps.config.CameraConfig.isSupportMicroscope() && com.oplus.camera.aps.config.CameraConfig.isSupportMicroscopeFilter()) {
            this.x_renamed.a_renamed(context, 2, 2);
        }
        this.y_renamed = false;
    }

    public void b_renamed(int i_renamed, int i2) {
        com.oplus.camera.ui.preview.a_renamed.s_renamed sVar = this.w_renamed;
        if (sVar != null) {
            sVar.a_renamed(i_renamed, i2);
        }
    }

    public void c_renamed() {
        if (this.w_renamed != null) {
            com.oplus.camera.e_renamed.a_renamed("BaseFilterMenuCanvas", "destroyFilterEngine mPolarrRender");
            this.w_renamed.e_renamed();
            com.oplus.camera.gl_renamed.i_renamed.i_renamed();
            com.oplus.camera.e_renamed.a_renamed("BaseFilterMenuCanvas", "destroyFilterEngine mPolarrRender X_renamed");
        }
        if (this.x_renamed != null) {
            com.oplus.camera.e_renamed.a_renamed("BaseFilterMenuCanvas", "destroyFilterEngine mAncFilterSdk");
            this.x_renamed.e_renamed();
            com.oplus.camera.gl_renamed.i_renamed.i_renamed();
            com.oplus.camera.e_renamed.a_renamed("BaseFilterMenuCanvas", "destroyFilterEngine mAncFilterSdk X_renamed");
        }
    }

    public void d_renamed() {
        com.oplus.camera.ui.preview.a_renamed.s_renamed sVar = this.w_renamed;
        if (sVar != null) {
            sVar.f_renamed();
        }
    }

    public boolean a_renamed(int i_renamed, int i2, java.util.List<co_renamed.polarr.renderer.entities.DrawingItem> list, float f_renamed) {
        if (list == null) {
            return false;
        }
        android.opengl.GLES20.glDisable(3042);
        f_renamed().a_renamed(list, i_renamed, i2, this.z_renamed, f_renamed);
        return true;
    }

    public boolean e_renamed() {
        return f_renamed() != null && f_renamed().a_renamed();
    }

    public void a_renamed(int i_renamed, int i2, int i3, int i4) {
        com.oplus.camera.e_renamed.b_renamed("BaseFilterMenuCanvas", "setTextureSize: width = " + i_renamed + ", height = " + i2);
        this.f6474c = i_renamed;
        this.d_renamed = i2;
        if ((1 == i4 && i3 != 0) || 4 == i4) {
            if (this.f6473b > 0) {
                this.n_renamed = this.f6474c / this.f6472a;
            }
            if (this.f6472a > 0) {
                this.m_renamed = this.d_renamed / this.f6473b;
                return;
            }
            return;
        }
        int i5 = this.f6473b;
        if (i5 > 0) {
            this.m_renamed = this.f6474c / i5;
        }
        int i6 = this.f6472a;
        if (i6 > 0) {
            this.n_renamed = this.d_renamed / i6;
        }
    }

    public void b_renamed(float f_renamed) {
        int i_renamed = this.f6472a;
        if (i_renamed > 0) {
            this.e_renamed = f_renamed / i_renamed;
        }
        int i2 = this.f6473b;
        if (i2 > 0) {
            this.f_renamed = f_renamed / i2;
        }
        this.B_renamed = f_renamed;
        this.r_renamed = this.f6472a > this.f6473b ? this.f_renamed : this.e_renamed;
        this.s_renamed = this.C_renamed / (f_renamed / 2.0f);
    }

    public void a_renamed(float f_renamed, float f2) {
        int i_renamed = this.f6472a;
        if (i_renamed > 0) {
            this.g_renamed = f_renamed / (i_renamed / 2.0f);
            this.t_renamed = f_renamed / (this.B_renamed / 2.0f);
        }
        int i2 = this.f6473b;
        if (i2 > 0) {
            this.h_renamed = f2 / (i2 / 2.0f);
            this.u_renamed = f2 / (this.B_renamed / 2.0f);
        }
        com.oplus.camera.e_renamed.b_renamed("BaseFilterMenuCanvas", "setSelectorPosition, x_renamed: " + f_renamed + ", y_renamed: " + f2 + ", mSelectorOffsetX: " + this.g_renamed + ", mSelectorOffsetY: " + this.h_renamed);
    }

    public void a_renamed(int i_renamed) {
        this.p_renamed = i_renamed;
    }

    public void a_renamed(float[] fArr) {
        this.v_renamed = fArr;
    }
}

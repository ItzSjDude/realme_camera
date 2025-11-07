package com.b_renamed.a_renamed;

/* compiled from: TouchController.java */
/* loaded from: classes.dex */
public class l_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private static final java.lang.String f2365a = "com.b_renamed.a_renamed.l_renamed";
    private int A_renamed;
    private float B_renamed;
    private float C_renamed;
    private float D_renamed;
    private float E_renamed;
    private float[] F_renamed;
    private float[] G_renamed;
    private float[] H_renamed;
    private float I_renamed;

    /* renamed from: b_renamed, reason: collision with root package name */
    private final com.b_renamed.a_renamed.e_renamed f2366b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private final com.b_renamed.a_renamed.d_renamed f2367c;
    private int d_renamed;
    private float e_renamed;
    private float f_renamed;
    private float g_renamed;
    private float h_renamed;
    private float i_renamed;
    private float j_renamed;
    private float k_renamed;
    private float l_renamed;
    private float m_renamed;
    private float n_renamed;
    private float o_renamed;
    private float p_renamed;
    private float q_renamed;
    private int r_renamed;
    private boolean s_renamed;
    private boolean t_renamed;
    private boolean u_renamed;
    private boolean v_renamed;
    private boolean w_renamed;
    private boolean x_renamed;
    private long y_renamed;
    private int z_renamed;

    public synchronized boolean a_renamed(android.view.MotionEvent motionEvent) {
        switch (motionEvent.getActionMasked()) {
            case 0:
            case 5:
            case 9:
                com.b_renamed.a_renamed.b_renamed.c_renamed(f2365a, "Gesture changed...");
                this.v_renamed = true;
                this.z_renamed = 0;
                this.y_renamed = android.os.SystemClock.uptimeMillis();
                this.x_renamed = false;
                break;
            case 1:
            case 3:
            case 4:
            case 6:
            case 10:
                if (this.y_renamed > android.os.SystemClock.uptimeMillis() - 250) {
                    this.x_renamed = true;
                } else {
                    this.v_renamed = true;
                    this.z_renamed = 0;
                    this.y_renamed = android.os.SystemClock.uptimeMillis();
                    this.x_renamed = false;
                }
                this.w_renamed = false;
                break;
            case 2:
                this.w_renamed = true;
                this.x_renamed = false;
                this.z_renamed++;
                break;
            case 7:
            case 8:
            default:
                com.b_renamed.a_renamed.b_renamed.b_renamed(f2365a, "Unknown state: " + motionEvent.getAction());
                this.v_renamed = true;
                break;
        }
        this.d_renamed = motionEvent.getPointerCount();
        if (this.d_renamed == 1) {
            this.e_renamed = motionEvent.getX();
            this.f_renamed = motionEvent.getY();
            if (this.v_renamed) {
                com.b_renamed.a_renamed.b_renamed.c_renamed(f2365a, "x_renamed:" + this.e_renamed + ",y_renamed:" + this.f_renamed);
                this.B_renamed = this.e_renamed;
                this.C_renamed = this.f_renamed;
            }
            this.i_renamed = this.e_renamed - this.B_renamed;
            this.j_renamed = this.f_renamed - this.C_renamed;
        } else if (this.d_renamed == 2) {
            this.e_renamed = motionEvent.getX(0);
            this.f_renamed = motionEvent.getY(0);
            this.g_renamed = motionEvent.getX(1);
            this.h_renamed = motionEvent.getY(1);
            this.G_renamed[0] = this.g_renamed - this.e_renamed;
            this.G_renamed[1] = this.h_renamed - this.f_renamed;
            this.G_renamed[2] = 0.0f;
            this.G_renamed[3] = 1.0f;
            float length = android.opengl.Matrix.length(this.G_renamed[0], this.G_renamed[1], this.G_renamed[2]);
            float[] fArr = this.G_renamed;
            fArr[0] = fArr[0] / length;
            float[] fArr2 = this.G_renamed;
            fArr2[1] = fArr2[1] / length;
            if (this.v_renamed) {
                this.B_renamed = this.e_renamed;
                this.C_renamed = this.f_renamed;
                this.D_renamed = this.g_renamed;
                this.E_renamed = this.h_renamed;
                java.lang.System.arraycopy(this.G_renamed, 0, this.F_renamed, 0, this.G_renamed.length);
            }
            this.i_renamed = this.e_renamed - this.B_renamed;
            this.j_renamed = this.f_renamed - this.C_renamed;
            this.k_renamed = this.g_renamed - this.D_renamed;
            this.l_renamed = this.h_renamed - this.E_renamed;
            this.H_renamed[0] = (this.F_renamed[1] * this.G_renamed[2]) - (this.F_renamed[2] * this.G_renamed[1]);
            this.H_renamed[1] = (this.F_renamed[2] * this.G_renamed[0]) - (this.F_renamed[0] * this.G_renamed[2]);
            this.H_renamed[2] = (this.F_renamed[0] * this.G_renamed[1]) - (this.F_renamed[1] * this.G_renamed[0]);
            float length2 = android.opengl.Matrix.length(this.H_renamed[0], this.H_renamed[1], this.H_renamed[2]);
            float[] fArr3 = this.H_renamed;
            fArr3[0] = fArr3[0] / length2;
            float[] fArr4 = this.H_renamed;
            fArr4[1] = fArr4[1] / length2;
            float[] fArr5 = this.H_renamed;
            fArr5[2] = fArr5[2] / length2;
            this.n_renamed = (float) java.lang.Math.sqrt(java.lang.Math.pow(this.D_renamed - this.B_renamed, 2.0d) + java.lang.Math.pow(this.E_renamed - this.C_renamed, 2.0d));
            this.m_renamed = (float) java.lang.Math.sqrt(java.lang.Math.pow(this.g_renamed - this.e_renamed, 2.0d) + java.lang.Math.pow(this.h_renamed - this.f_renamed, 2.0d));
            this.o_renamed = motionEvent.getPressure(0);
            this.p_renamed = motionEvent.getPressure(1);
            this.q_renamed = 0.0f;
            this.q_renamed = com.b_renamed.a_renamed.m_renamed.a_renamed(motionEvent);
            this.r_renamed = com.b_renamed.a_renamed.m_renamed.b_renamed(motionEvent);
            if (this.r_renamed == 1 && this.I_renamed == 4.0f) {
                this.q_renamed = 0.0f;
            } else if (this.r_renamed == 4 && this.I_renamed == 1.0f) {
                this.q_renamed = 360.0f;
            }
            this.t_renamed = !this.s_renamed && this.i_renamed * this.k_renamed < 0.0f && this.j_renamed * this.l_renamed < 0.0f && java.lang.Math.abs(this.i_renamed + this.k_renamed) < 10.0f && java.lang.Math.abs(this.j_renamed + this.l_renamed) < 10.0f;
            this.u_renamed = !this.t_renamed && this.i_renamed * this.k_renamed > 0.0f && this.j_renamed * this.l_renamed > 0.0f;
        }
        if (this.d_renamed == 1 && this.x_renamed) {
            this.f2366b.getModelActivity().c_renamed().a_renamed(this.e_renamed, this.f_renamed);
        }
        int iMax = java.lang.Math.max(this.f2367c.d_renamed(), this.f2367c.e_renamed());
        if (this.z_renamed > 1) {
            com.b_renamed.a_renamed.j_renamed jVarC = this.f2366b.getModelActivity().c_renamed();
            jVarC.b_renamed(this.i_renamed, this.j_renamed);
            org.andresoviedo.android_3d_model_engine.b_renamed.c_renamed cVarB = jVarC.b_renamed();
            if (this.d_renamed != 1 || this.o_renamed <= 4.0f) {
                if (this.d_renamed == 1) {
                    this.A_renamed = 5;
                    float f_renamed = iMax;
                    this.i_renamed = (float) ((this.i_renamed / f_renamed) * 3.141592653589793d * 2.0d);
                    this.j_renamed = (float) ((this.j_renamed / f_renamed) * 3.141592653589793d * 2.0d);
                } else if (this.d_renamed == 2) {
                    if (this.t_renamed) {
                        this.A_renamed = 1;
                        float fB_renamed = (((this.m_renamed - this.n_renamed) / iMax) * this.f2367c.b_renamed()) / 3.0f;
                        com.b_renamed.a_renamed.b_renamed.d_renamed(f2365a, "Zooming '" + fB_renamed + "'...");
                        cVarB.a_renamed(fB_renamed);
                    }
                    if (this.u_renamed) {
                        float f2 = this.i_renamed;
                        float f3 = this.k_renamed;
                        float f4 = this.j_renamed;
                        float f5 = this.l_renamed;
                    }
                }
            }
        }
        this.B_renamed = this.e_renamed;
        this.C_renamed = this.f_renamed;
        this.D_renamed = this.g_renamed;
        this.E_renamed = this.h_renamed;
        this.I_renamed = this.r_renamed;
        java.lang.System.arraycopy(this.G_renamed, 0, this.F_renamed, 0, this.G_renamed.length);
        if (this.v_renamed && this.z_renamed > 1) {
            this.v_renamed = false;
            com.b_renamed.a_renamed.b_renamed.e_renamed(f2365a, "Fin");
        }
        return true;
    }
}

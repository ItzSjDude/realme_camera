package com.oplus.camera.ui.menu.levelcontrol;

/* compiled from: CylinderSide.java */
/* loaded from: classes2.dex */
public class f_renamed extends com.oplus.camera.ui.menu.levelcontrol.a_renamed {
    private int w_renamed = 0;
    private int x_renamed = 0;
    private int y_renamed = 0;
    private int z_renamed = 0;
    private int A_renamed = 0;
    private int B_renamed = 0;
    private int C_renamed = 0;
    private java.lang.String D_renamed = null;
    private java.lang.String E_renamed = null;
    private int F_renamed = 0;
    private int G_renamed = 0;
    private int H_renamed = 0;
    private int I_renamed = 0;
    private int J_renamed = 0;
    private int K_renamed = 0;
    private int L_renamed = 0;
    private java.lang.String M_renamed = null;
    private java.lang.String N_renamed = null;
    private int O_renamed = 0;
    private java.nio.FloatBuffer P_renamed = null;
    private java.nio.FloatBuffer Q_renamed = null;
    private int[] R_renamed = new int[1];

    private float a_renamed(double d_renamed, double d2, double d3, boolean z_renamed) {
        return (float) (z_renamed ? ((d_renamed - d2) / 2.0d) + d3 : ((d_renamed + d2) / 2.0d) - d3);
    }

    public f_renamed(android.content.Context context) {
        b_renamed(context);
    }

    @Override // com.oplus.camera.ui.menu.levelcontrol.a_renamed
    public void a_renamed(float f_renamed, float f2, float f3, int i_renamed, float f4, float f5, boolean z_renamed, com.oplus.camera.ui.menu.levelcontrol.i_renamed iVar) {
        float[] fArr;
        com.oplus.camera.ui.menu.levelcontrol.f_renamed fVar = this;
        int iCeil = (int) java.lang.Math.ceil(i_renamed * 3 * 2 * (f5 / 360.0f));
        boolean zM = iVar.m_renamed();
        boolean zN = iVar.n_renamed();
        boolean zV = iVar.v_renamed();
        int iH = iVar.h_renamed();
        int i2 = iVar.i_renamed();
        float f6 = f_renamed * f2;
        float f7 = f_renamed * f3;
        int i3 = iCeil * 3;
        float[] fArr2 = new float[i3];
        float[] fArr3 = new float[iCeil * 2];
        float f8 = 360.0f / i_renamed;
        double dC_renamed = com.oplus.camera.ui.menu.levelcontrol.o_renamed.c_renamed();
        double d_renamed = z_renamed ? -1.0d : 0.0d;
        float f9 = f4;
        double dA_renamed = d_renamed;
        double d2 = d_renamed;
        int i4 = 0;
        int i5 = 0;
        while (true) {
            float f10 = f4 + f5;
            if (f9 >= f10 || i4 + 18 >= i3) {
                break;
            }
            double d3 = dC_renamed;
            double radians = java.lang.Math.toRadians(f9);
            if (i4 + 36 < i3) {
                f10 = f9 + f8;
            }
            double radians2 = java.lang.Math.toRadians(f10 % 360.0f);
            if (z_renamed) {
                if (-1.0d == d2) {
                    dA_renamed = fVar.a_renamed((f9 - f4) / f5);
                }
                d2 = dA_renamed;
                dA_renamed = fVar.a_renamed(((f9 + f8) - f4) / f5);
            }
            int i6 = i4 + 1;
            double d4 = f6;
            int i7 = i3;
            float f11 = f6;
            fArr2[i4] = (float) (d4 * java.lang.Math.sin(radians));
            int i8 = i6 + 1;
            double d5 = f7;
            float[] fArr4 = fArr2;
            float[] fArr5 = fArr3;
            float f12 = f7;
            fArr4[i6] = a_renamed(d5, d3, d2, true);
            int i9 = i8 + 1;
            fArr4[i8] = (float) (d4 * java.lang.Math.cos(radians));
            int i10 = i5 + 1;
            float f13 = (f9 - f4) / f5;
            fArr5[i5] = f13;
            int i11 = i10 + 1;
            int i12 = iCeil;
            fArr5[i10] = a_renamed(1.0d, 1.0d, d2, false);
            if (zV) {
                fArr = fArr5;
                a_renamed(fArr5, i11 - 1, zM, zN, z_renamed, iH, i2);
            } else {
                fArr = fArr5;
            }
            int i13 = i9 + 1;
            fArr4[i9] = (float) (d4 * java.lang.Math.sin(radians2));
            int i14 = i13 + 1;
            double d6 = dA_renamed;
            fArr4[i13] = a_renamed(d5, d3, d6, false);
            int i15 = i14 + 1;
            fArr4[i14] = (float) (d4 * java.lang.Math.cos(radians2));
            int i16 = i11 + 1;
            f9 += f8;
            float f14 = (f9 - f4) / f5;
            fArr[i11] = f14;
            int i17 = i16 + 1;
            fArr[i16] = a_renamed(1.0d, 1.0d, d6, true);
            if (zV) {
                a_renamed(fArr, i17 - 1, zM, zN, z_renamed, iH, i2);
            }
            int i18 = i15 + 1;
            fArr4[i15] = (float) (d4 * java.lang.Math.sin(radians));
            int i19 = i18 + 1;
            double d7 = d2;
            fArr4[i18] = a_renamed(d5, d3, d7, false);
            int i20 = i19 + 1;
            fArr4[i19] = (float) (d4 * java.lang.Math.cos(radians));
            int i21 = i17 + 1;
            fArr[i17] = f13;
            int i22 = i21 + 1;
            fArr[i21] = a_renamed(1.0d, 1.0d, d7, true);
            if (zV) {
                a_renamed(fArr, i22 - 1, zM, zN, z_renamed, iH, i2);
            }
            int i23 = i20 + 1;
            fArr4[i20] = (float) (d4 * java.lang.Math.sin(radians));
            int i24 = i23 + 1;
            double d8 = d2;
            fArr4[i23] = a_renamed(d5, d3, d8, true);
            int i25 = i24 + 1;
            fArr4[i24] = (float) (d4 * java.lang.Math.cos(radians));
            int i26 = i22 + 1;
            fArr[i22] = f13;
            int i27 = i26 + 1;
            fArr[i26] = a_renamed(1.0d, 1.0d, d8, false);
            if (zV) {
                a_renamed(fArr, i27 - 1, zM, zN, z_renamed, iH, i2);
            }
            int i28 = i25 + 1;
            fArr4[i25] = (float) (d4 * java.lang.Math.sin(radians2));
            int i29 = i28 + 1;
            double d9 = dA_renamed;
            fArr4[i28] = a_renamed(d5, d3, d9, true);
            int i30 = i29 + 1;
            fArr4[i29] = (float) (d4 * java.lang.Math.cos(radians2));
            int i31 = i27 + 1;
            fArr[i27] = f14;
            int i32 = i31 + 1;
            fArr[i31] = a_renamed(1.0d, 1.0d, d9, false);
            if (zV) {
                a_renamed(fArr, i32 - 1, zM, zN, z_renamed, iH, i2);
            }
            int i33 = i30 + 1;
            fArr4[i30] = (float) (d4 * java.lang.Math.sin(radians2));
            int i34 = i33 + 1;
            double d10 = dA_renamed;
            fArr4[i33] = a_renamed(d5, d3, d10, false);
            i4 = i34 + 1;
            fArr4[i34] = (float) (d4 * java.lang.Math.cos(radians2));
            int i35 = i32 + 1;
            fArr[i32] = f14;
            i5 = i35 + 1;
            fArr[i35] = a_renamed(1.0d, 1.0d, d10, true);
            if (zV) {
                a_renamed(fArr, i5 - 1, zM, zN, z_renamed, iH, i2);
            }
            fArr3 = fArr;
            fArr2 = fArr4;
            f7 = f12;
            i3 = i7;
            dC_renamed = d3;
            iCeil = i12;
            f6 = f11;
            fVar = this;
        }
        float[] fArr6 = fArr3;
        int i36 = iCeil;
        float[] fArr7 = fArr2;
        float[] fArr8 = new float[fArr7.length];
        for (int i37 = 0; i37 < fArr7.length; i37++) {
            if (i37 % 3 == 1) {
                fArr8[i37] = 0.0f;
            } else {
                fArr8[i37] = fArr7[i37];
            }
        }
        this.i_renamed.add(java.lang.Integer.valueOf(i36));
        java.nio.ByteBuffer byteBufferAllocateDirect = java.nio.ByteBuffer.allocateDirect(fArr7.length * 4);
        byteBufferAllocateDirect.order(java.nio.ByteOrder.nativeOrder());
        java.nio.FloatBuffer floatBufferAsFloatBuffer = byteBufferAllocateDirect.asFloatBuffer();
        floatBufferAsFloatBuffer.put(fArr7);
        floatBufferAsFloatBuffer.position(0);
        this.j_renamed.add(floatBufferAsFloatBuffer);
        java.nio.ByteBuffer byteBufferAllocateDirect2 = java.nio.ByteBuffer.allocateDirect(fArr7.length * 4);
        byteBufferAllocateDirect2.order(java.nio.ByteOrder.nativeOrder());
        java.nio.FloatBuffer floatBufferAsFloatBuffer2 = byteBufferAllocateDirect2.asFloatBuffer();
        floatBufferAsFloatBuffer2.put(fArr8);
        floatBufferAsFloatBuffer2.position(0);
        this.l_renamed.add(floatBufferAsFloatBuffer2);
        java.nio.ByteBuffer byteBufferAllocateDirect3 = java.nio.ByteBuffer.allocateDirect(fArr6.length * 4);
        byteBufferAllocateDirect3.order(java.nio.ByteOrder.nativeOrder());
        java.nio.FloatBuffer floatBufferAsFloatBuffer3 = byteBufferAllocateDirect3.asFloatBuffer();
        floatBufferAsFloatBuffer3.put(fArr6);
        floatBufferAsFloatBuffer3.position(0);
        this.k_renamed.add(floatBufferAsFloatBuffer3);
    }

    private double a_renamed(double d_renamed) {
        if (0.0d <= d_renamed) {
            double d2 = 0.5f;
            if (d2 >= d_renamed) {
                double d3 = d2 - d_renamed;
                return d2 - java.lang.Math.sqrt(0.25f - (d3 * d3));
            }
        }
        if (0.5f > d_renamed) {
            return 0.0d;
        }
        double d4 = 0.5f;
        double d5 = d4 - (1.0d - d_renamed);
        return d4 - java.lang.Math.sqrt(0.25f - (d5 * d5));
    }

    private void a_renamed(float[] fArr, int i_renamed, boolean z_renamed, boolean z2, boolean z3, int i2, int i3) {
        if (!z3) {
            b_renamed(fArr, i_renamed);
        }
        if (z2) {
            b_renamed(fArr, i_renamed);
        }
        if (z_renamed) {
            a_renamed(fArr, i_renamed);
        }
        a_renamed(fArr, i_renamed, i2, i3);
        c_renamed(fArr, i_renamed);
    }

    private void a_renamed(float[] fArr, int i_renamed) {
        fArr[i_renamed] = 1.0f - fArr[i_renamed];
    }

    private void a_renamed(float[] fArr, int i_renamed, int i2, int i3) {
        float f_renamed = i2;
        float f2 = i3;
        fArr[i_renamed] = ((1.0f - (f_renamed / f2)) / 2.0f) + ((fArr[i_renamed] * f_renamed) / f2);
    }

    private void b_renamed(float[] fArr, int i_renamed) {
        int i2 = i_renamed - 1;
        fArr[i2] = 1.0f - fArr[i2];
        fArr[i_renamed] = 1.0f - fArr[i_renamed];
    }

    private void c_renamed(float[] fArr, int i_renamed) {
        int i2 = i_renamed - 1;
        float f_renamed = fArr[i2];
        fArr[i2] = fArr[i_renamed];
        fArr[i_renamed] = 1.0f - f_renamed;
    }

    @Override // com.oplus.camera.ui.menu.levelcontrol.a_renamed
    protected void b_renamed(android.content.Context context) {
        c_renamed(context);
        d_renamed(context);
    }

    private void c_renamed(android.content.Context context) {
        this.D_renamed = com.oplus.camera.util.k_renamed.a_renamed("vertex_tex.sh", context.getResources());
        this.E_renamed = com.oplus.camera.util.k_renamed.a_renamed("frag_tex.sh", context.getResources());
        this.w_renamed = com.oplus.camera.util.k_renamed.b_renamed(this.D_renamed, this.E_renamed);
        this.y_renamed = android.opengl.GLES20.glGetAttribLocation(this.w_renamed, "aPosition");
        this.z_renamed = android.opengl.GLES20.glGetAttribLocation(this.w_renamed, "aTexCoor");
        this.x_renamed = android.opengl.GLES20.glGetUniformLocation(this.w_renamed, "uMVPMatrix");
        this.B_renamed = android.opengl.GLES20.glGetUniformLocation(this.w_renamed, "uCamera");
        this.C_renamed = android.opengl.GLES20.glGetUniformLocation(this.w_renamed, "uLightLocation");
        this.A_renamed = android.opengl.GLES20.glGetUniformLocation(this.w_renamed, "uMMatrix");
    }

    @Override // com.oplus.camera.ui.menu.levelcontrol.a_renamed
    public void c_renamed(int i_renamed, int i2) {
        com.oplus.camera.gl_renamed.i_renamed.i_renamed();
        android.opengl.GLES20.glUseProgram(this.w_renamed);
        com.oplus.camera.gl_renamed.i_renamed.i_renamed();
        android.opengl.GLES20.glUniformMatrix4fv(this.x_renamed, 1, false, com.oplus.camera.ui.menu.levelcontrol.p_renamed.d_renamed(), 0);
        com.oplus.camera.gl_renamed.i_renamed.i_renamed();
        android.opengl.GLES20.glUniformMatrix4fv(this.A_renamed, 1, false, com.oplus.camera.ui.menu.levelcontrol.p_renamed.e_renamed(), 0);
        com.oplus.camera.gl_renamed.i_renamed.i_renamed();
        android.opengl.GLES20.glUniform3fv(this.B_renamed, 1, com.oplus.camera.ui.menu.levelcontrol.p_renamed.f_renamed());
        com.oplus.camera.gl_renamed.i_renamed.i_renamed();
        android.opengl.GLES20.glUniform3fv(this.C_renamed, 1, com.oplus.camera.ui.menu.levelcontrol.p_renamed.g_renamed());
        com.oplus.camera.gl_renamed.i_renamed.i_renamed();
        android.opengl.GLES20.glVertexAttribPointer(this.y_renamed, 3, 5126, false, 12, (java.nio.Buffer) this.j_renamed.get(i2));
        android.opengl.GLES20.glVertexAttribPointer(this.z_renamed, 2, 5126, false, 8, (java.nio.Buffer) this.k_renamed.get(i2));
        com.oplus.camera.gl_renamed.i_renamed.i_renamed();
        android.opengl.GLES20.glEnableVertexAttribArray(this.y_renamed);
        android.opengl.GLES20.glEnableVertexAttribArray(this.z_renamed);
        com.oplus.camera.gl_renamed.i_renamed.i_renamed();
        android.opengl.GLES20.glActiveTexture(33984);
        android.opengl.GLES20.glBindTexture(3553, i_renamed);
        android.opengl.GLES20.glDrawArrays(4, 0, this.i_renamed.get(i2).intValue());
        android.opengl.GLES20.glDisableVertexAttribArray(this.y_renamed);
        android.opengl.GLES20.glDisableVertexAttribArray(this.z_renamed);
        com.oplus.camera.gl_renamed.i_renamed.i_renamed();
    }

    @Override // com.oplus.camera.ui.menu.levelcontrol.a_renamed
    public void e_renamed(int i_renamed, int i2) {
        com.oplus.camera.ui.menu.levelcontrol.p_renamed.b_renamed();
        android.opengl.GLES20.glViewport(0, 0, this.f6472a, this.f6473b);
        android.opengl.GLES20.glEnable(2929);
        android.opengl.GLES20.glEnable(2884);
        android.opengl.GLES20.glEnable(3042);
        android.opengl.GLES20.glBlendFunc(com.arcsoft.arcsoftjni.ArcSoftOffscreen.ASVL_PAF_RGB32_B8G8R8A8, 1);
        com.oplus.camera.ui.menu.levelcontrol.p_renamed.a_renamed(0.0f, ((-com.oplus.camera.ui.menu.levelcontrol.o_renamed.i_renamed()) / 2.0f) * 1.0f, 0.0f);
        android.opengl.GLES20.glUseProgram(this.w_renamed);
        android.opengl.GLES20.glUniformMatrix4fv(this.x_renamed, 1, false, com.oplus.camera.ui.menu.levelcontrol.p_renamed.d_renamed(), 0);
        android.opengl.GLES20.glUniformMatrix4fv(this.A_renamed, 1, false, com.oplus.camera.ui.menu.levelcontrol.p_renamed.e_renamed(), 0);
        android.opengl.GLES20.glUniform3fv(this.B_renamed, 1, com.oplus.camera.ui.menu.levelcontrol.p_renamed.f_renamed());
        android.opengl.GLES20.glUniform3fv(this.C_renamed, 1, com.oplus.camera.ui.menu.levelcontrol.p_renamed.g_renamed());
        android.opengl.GLES20.glVertexAttribPointer(this.y_renamed, 3, 5126, false, 12, (java.nio.Buffer) this.j_renamed.get(i2));
        android.opengl.GLES20.glVertexAttribPointer(this.z_renamed, 2, 5126, false, 8, (java.nio.Buffer) this.k_renamed.get(i2));
        android.opengl.GLES20.glEnableVertexAttribArray(this.y_renamed);
        android.opengl.GLES20.glEnableVertexAttribArray(this.z_renamed);
        android.opengl.GLES20.glActiveTexture(33984);
        android.opengl.GLES20.glBindTexture(3553, i_renamed);
        android.opengl.GLES20.glDrawArrays(4, 0, this.i_renamed.get(i2).intValue());
        android.opengl.GLES20.glDisableVertexAttribArray(this.y_renamed);
        android.opengl.GLES20.glDisableVertexAttribArray(this.z_renamed);
        com.oplus.camera.ui.menu.levelcontrol.p_renamed.c_renamed();
    }

    private void d_renamed(android.content.Context context) {
        this.M_renamed = com.oplus.camera.util.k_renamed.a_renamed("vertex_tex.sh", context.getResources());
        this.N_renamed = com.oplus.camera.util.k_renamed.a_renamed("frag_oes_tex.sh", context.getResources());
        this.F_renamed = com.oplus.camera.util.k_renamed.b_renamed(this.M_renamed, this.N_renamed);
        this.H_renamed = android.opengl.GLES20.glGetAttribLocation(this.F_renamed, "aPosition");
        this.I_renamed = android.opengl.GLES20.glGetAttribLocation(this.F_renamed, "aTexCoor");
        this.G_renamed = android.opengl.GLES20.glGetUniformLocation(this.F_renamed, "uMVPMatrix");
        this.K_renamed = android.opengl.GLES20.glGetUniformLocation(this.F_renamed, "uCamera");
        this.L_renamed = android.opengl.GLES20.glGetUniformLocation(this.F_renamed, "uLightLocation");
        this.J_renamed = android.opengl.GLES20.glGetUniformLocation(this.F_renamed, "uMMatrix");
    }

    @Override // com.oplus.camera.ui.menu.levelcontrol.a_renamed
    public void f_renamed(int i_renamed, int i2) {
        com.oplus.camera.gl_renamed.i_renamed.i_renamed();
        com.oplus.camera.ui.menu.levelcontrol.p_renamed.b_renamed();
        com.oplus.camera.ui.menu.levelcontrol.p_renamed.a_renamed(0.0f, ((-com.oplus.camera.ui.menu.levelcontrol.o_renamed.i_renamed()) / 2.0f) * 1.0f, 0.0f);
        android.opengl.GLES20.glUseProgram(this.F_renamed);
        android.opengl.GLES20.glUniformMatrix4fv(this.G_renamed, 1, false, com.oplus.camera.ui.menu.levelcontrol.p_renamed.d_renamed(), 0);
        android.opengl.GLES20.glUniformMatrix4fv(this.J_renamed, 1, false, com.oplus.camera.ui.menu.levelcontrol.p_renamed.e_renamed(), 0);
        android.opengl.GLES20.glUniform3fv(this.K_renamed, 1, com.oplus.camera.ui.menu.levelcontrol.p_renamed.f_renamed());
        android.opengl.GLES20.glUniform3fv(this.L_renamed, 1, com.oplus.camera.ui.menu.levelcontrol.p_renamed.g_renamed());
        android.opengl.GLES20.glVertexAttribPointer(this.H_renamed, 3, 5126, false, 12, (java.nio.Buffer) this.j_renamed.get(i2));
        android.opengl.GLES20.glVertexAttribPointer(this.I_renamed, 2, 5126, false, 8, (java.nio.Buffer) this.k_renamed.get(i2));
        android.opengl.GLES20.glEnableVertexAttribArray(this.H_renamed);
        android.opengl.GLES20.glEnableVertexAttribArray(this.I_renamed);
        android.opengl.GLES20.glActiveTexture(33984);
        android.opengl.GLES20.glBindTexture(36197, i_renamed);
        android.opengl.GLES20.glDrawArrays(4, 0, this.i_renamed.get(i2).intValue());
        android.opengl.GLES20.glDisableVertexAttribArray(this.H_renamed);
        android.opengl.GLES20.glDisableVertexAttribArray(this.I_renamed);
        com.oplus.camera.ui.menu.levelcontrol.p_renamed.c_renamed();
    }

    @Override // com.oplus.camera.ui.menu.levelcontrol.a_renamed
    public void d_renamed(int i_renamed, int i2) {
        com.oplus.camera.gl_renamed.i_renamed.i_renamed();
        com.oplus.camera.ui.menu.levelcontrol.p_renamed.b_renamed();
        com.oplus.camera.ui.menu.levelcontrol.p_renamed.a_renamed(0.0f, ((-com.oplus.camera.ui.menu.levelcontrol.o_renamed.i_renamed()) / 2.0f) * 1.0f, 0.0f);
        c_renamed(i_renamed, i2);
        com.oplus.camera.ui.menu.levelcontrol.p_renamed.c_renamed();
    }
}

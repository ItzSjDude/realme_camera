package com.oplus.camera.ui.menu.levelcontrol;

/* compiled from: Ring.java */
/* loaded from: classes2.dex */
public class q_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private int f6541a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private int f6542b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private int f6543c;
    private int d_renamed;
    private int e_renamed;
    private int f_renamed;
    private int g_renamed;
    private java.lang.String i_renamed;
    private java.lang.String j_renamed;
    private int h_renamed = 0;
    private java.util.ArrayList<java.nio.FloatBuffer> k_renamed = new java.util.ArrayList<>();
    private java.util.ArrayList<java.nio.FloatBuffer> l_renamed = new java.util.ArrayList<>();
    private java.util.ArrayList<java.nio.FloatBuffer> m_renamed = new java.util.ArrayList<>();

    public q_renamed(android.content.Context context) {
        a_renamed(context);
    }

    public void a_renamed() {
        this.k_renamed.clear();
        this.l_renamed.clear();
        this.m_renamed.clear();
    }

    public void a_renamed(float f_renamed, float f2, float f3, float f4, float f5) {
        this.h_renamed = 6;
        int i_renamed = this.h_renamed;
        float[] fArr = new float[i_renamed * 3];
        float[] fArr2 = new float[i_renamed * 2];
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (i2 < 1) {
            int i5 = i3 + 1;
            float f6 = i2;
            float f7 = 1;
            float f8 = f5 + ((f6 * f_renamed) / f7);
            fArr[i3] = f8;
            int i6 = i5 + 1;
            float f9 = (f4 - f2) / 2.0f;
            fArr[i5] = f9;
            int i7 = i6 + 1;
            fArr[i6] = f3;
            int i8 = i4 + 1;
            float f10 = (f6 * 1.0f) / f7;
            fArr2[i4] = f10;
            int i9 = i8 + 1;
            fArr2[i8] = 1.0f;
            int i10 = i7 + 1;
            i2++;
            float f11 = i2;
            float f12 = f5 + ((f11 * f_renamed) / f7);
            fArr[i7] = f12;
            int i11 = i10 + 1;
            float f13 = (f4 + f2) / 2.0f;
            fArr[i10] = f13;
            int i12 = i11 + 1;
            fArr[i11] = f3;
            int i13 = i9 + 1;
            float f14 = (f11 * 1.0f) / f7;
            fArr2[i9] = f14;
            int i14 = i13 + 1;
            fArr2[i13] = 0.0f;
            int i15 = i12 + 1;
            fArr[i12] = f8;
            int i16 = i15 + 1;
            fArr[i15] = f13;
            int i17 = i16 + 1;
            fArr[i16] = f3;
            int i18 = i14 + 1;
            fArr2[i14] = f10;
            int i19 = i18 + 1;
            fArr2[i18] = 0.0f;
            int i20 = i17 + 1;
            fArr[i17] = f8;
            int i21 = i20 + 1;
            fArr[i20] = f9;
            int i22 = i21 + 1;
            fArr[i21] = f3;
            int i23 = i19 + 1;
            fArr2[i19] = f10;
            int i24 = i23 + 1;
            fArr2[i23] = 1.0f;
            int i25 = i22 + 1;
            fArr[i22] = f12;
            int i26 = i25 + 1;
            fArr[i25] = f9;
            int i27 = i26 + 1;
            fArr[i26] = f3;
            int i28 = i24 + 1;
            fArr2[i24] = f14;
            int i29 = i28 + 1;
            fArr2[i28] = 1.0f;
            int i30 = i27 + 1;
            fArr[i27] = f12;
            int i31 = i30 + 1;
            fArr[i30] = f13;
            i3 = i31 + 1;
            fArr[i31] = f3;
            int i32 = i29 + 1;
            fArr2[i29] = f14;
            i4 = i32 + 1;
            fArr2[i32] = 0.0f;
        }
        float[] fArr3 = new float[fArr.length];
        for (int i33 = 0; i33 < fArr.length; i33++) {
            if (i33 % 3 == 1) {
                fArr3[i33] = 0.0f;
            } else {
                fArr3[i33] = fArr[i33];
            }
        }
        java.nio.ByteBuffer byteBufferAllocateDirect = java.nio.ByteBuffer.allocateDirect(fArr.length * 4);
        byteBufferAllocateDirect.order(java.nio.ByteOrder.nativeOrder());
        java.nio.FloatBuffer floatBufferAsFloatBuffer = byteBufferAllocateDirect.asFloatBuffer();
        floatBufferAsFloatBuffer.put(fArr);
        floatBufferAsFloatBuffer.position(0);
        this.k_renamed.add(floatBufferAsFloatBuffer);
        java.nio.ByteBuffer byteBufferAllocateDirect2 = java.nio.ByteBuffer.allocateDirect(fArr.length * 4);
        byteBufferAllocateDirect2.order(java.nio.ByteOrder.nativeOrder());
        java.nio.FloatBuffer floatBufferAsFloatBuffer2 = byteBufferAllocateDirect2.asFloatBuffer();
        floatBufferAsFloatBuffer2.put(fArr3);
        floatBufferAsFloatBuffer2.position(0);
        this.m_renamed.add(floatBufferAsFloatBuffer2);
        java.nio.ByteBuffer byteBufferAllocateDirect3 = java.nio.ByteBuffer.allocateDirect(fArr2.length * 4);
        byteBufferAllocateDirect3.order(java.nio.ByteOrder.nativeOrder());
        java.nio.FloatBuffer floatBufferAsFloatBuffer3 = byteBufferAllocateDirect3.asFloatBuffer();
        floatBufferAsFloatBuffer3.put(fArr2);
        floatBufferAsFloatBuffer3.position(0);
        this.l_renamed.add(floatBufferAsFloatBuffer3);
    }

    private void a_renamed(android.content.Context context) {
        this.i_renamed = com.oplus.camera.util.k_renamed.a_renamed("vertex_tex.sh", context.getResources());
        this.j_renamed = com.oplus.camera.util.k_renamed.a_renamed("frag_tex.sh", context.getResources());
        this.f6541a = com.oplus.camera.util.k_renamed.b_renamed(this.i_renamed, this.j_renamed);
        this.f6543c = android.opengl.GLES20.glGetAttribLocation(this.f6541a, "aPosition");
        this.d_renamed = android.opengl.GLES20.glGetAttribLocation(this.f6541a, "aTexCoor");
        this.f6542b = android.opengl.GLES20.glGetUniformLocation(this.f6541a, "uMVPMatrix");
        this.f_renamed = android.opengl.GLES20.glGetUniformLocation(this.f6541a, "uCamera");
        this.g_renamed = android.opengl.GLES20.glGetUniformLocation(this.f6541a, "uLightLocation");
        this.e_renamed = android.opengl.GLES20.glGetUniformLocation(this.f6541a, "uMMatrix");
    }

    public void a_renamed(int i_renamed, int i2) {
        android.opengl.GLES20.glUseProgram(this.f6541a);
        android.opengl.GLES20.glUniformMatrix4fv(this.f6542b, 1, false, com.oplus.camera.ui.menu.levelcontrol.p_renamed.d_renamed(), 0);
        android.opengl.GLES20.glUniformMatrix4fv(this.e_renamed, 1, false, com.oplus.camera.ui.menu.levelcontrol.p_renamed.e_renamed(), 0);
        android.opengl.GLES20.glUniform3fv(this.f_renamed, 1, com.oplus.camera.ui.menu.levelcontrol.p_renamed.f_renamed());
        android.opengl.GLES20.glUniform3fv(this.g_renamed, 1, com.oplus.camera.ui.menu.levelcontrol.p_renamed.g_renamed());
        android.opengl.GLES20.glVertexAttribPointer(this.f6543c, 3, 5126, false, 12, (java.nio.Buffer) this.k_renamed.get(i2));
        android.opengl.GLES20.glVertexAttribPointer(this.d_renamed, 2, 5126, false, 8, (java.nio.Buffer) this.l_renamed.get(i2));
        android.opengl.GLES20.glEnableVertexAttribArray(this.f6543c);
        android.opengl.GLES20.glEnableVertexAttribArray(this.d_renamed);
        android.opengl.GLES20.glActiveTexture(33984);
        android.opengl.GLES20.glBindTexture(3553, i_renamed);
        android.opengl.GLES20.glDrawArrays(4, 0, this.h_renamed);
        android.opengl.GLES20.glDisableVertexAttribArray(this.f6543c);
        android.opengl.GLES20.glDisableVertexAttribArray(this.d_renamed);
    }
}

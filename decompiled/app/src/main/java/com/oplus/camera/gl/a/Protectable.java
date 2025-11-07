package com.oplus.camera.gl_renamed.a_renamed;

/* compiled from: GLImageProcessor.java */
/* loaded from: classes2.dex */
public class c_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    public static final float[] f4580a = {-1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f, -1.0f};

    /* renamed from: b_renamed, reason: collision with root package name */
    public static final float[] f4581b = {0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 1.0f, 1.0f};
    private int d_renamed;
    private int e_renamed;
    private int f_renamed;
    private int g_renamed;
    private boolean h_renamed;

    /* renamed from: c_renamed, reason: collision with root package name */
    private final java.util.LinkedList<java.lang.Runnable> f4582c = new java.util.LinkedList<>();
    private int i_renamed = f4581b.length / 2;
    private int j_renamed = -1;
    private int k_renamed = -1;
    private int[] l_renamed = null;
    private int[] m_renamed = null;

    public int b_renamed() {
        return 3553;
    }

    c_renamed(int i_renamed, int i2, int i3, int i4) {
        this.d_renamed = 0;
        this.e_renamed = 0;
        this.f_renamed = 0;
        this.g_renamed = 0;
        this.h_renamed = false;
        this.d_renamed = i_renamed;
        this.e_renamed = i2;
        this.f_renamed = i3;
        this.g_renamed = i4;
        this.h_renamed = true;
    }

    public int a_renamed(int i_renamed, java.nio.FloatBuffer floatBuffer, java.nio.FloatBuffer floatBuffer2, int i2) {
        if (i_renamed == -1 || this.l_renamed == null || !this.h_renamed) {
            return i_renamed;
        }
        android.opengl.GLES20.glViewport(0, 0, this.j_renamed, this.k_renamed);
        android.opengl.GLES20.glBindFramebuffer(36160, this.l_renamed[i2]);
        android.opengl.GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.m_renamed[i2], 0);
        com.oplus.camera.gl_renamed.i_renamed.i_renamed();
        android.opengl.GLES20.glUseProgram(this.d_renamed);
        com.oplus.camera.gl_renamed.i_renamed.i_renamed();
        f_renamed();
        com.oplus.camera.gl_renamed.i_renamed.i_renamed();
        a_renamed(i_renamed, floatBuffer, floatBuffer2);
        com.oplus.camera.gl_renamed.i_renamed.i_renamed();
        android.opengl.GLES20.glBindFramebuffer(36160, 0);
        com.oplus.camera.gl_renamed.i_renamed.i_renamed();
        return this.m_renamed[i2];
    }

    private void a_renamed(int i_renamed, java.nio.FloatBuffer floatBuffer, java.nio.FloatBuffer floatBuffer2) {
        floatBuffer.position(0);
        android.opengl.GLES20.glVertexAttribPointer(this.e_renamed, 2, 5126, false, 0, (java.nio.Buffer) floatBuffer);
        com.oplus.camera.gl_renamed.i_renamed.i_renamed();
        android.opengl.GLES20.glEnableVertexAttribArray(this.e_renamed);
        com.oplus.camera.gl_renamed.i_renamed.i_renamed();
        floatBuffer2.position(0);
        android.opengl.GLES20.glVertexAttribPointer(this.f_renamed, 2, 5126, false, 0, (java.nio.Buffer) floatBuffer2);
        com.oplus.camera.gl_renamed.i_renamed.i_renamed();
        android.opengl.GLES20.glEnableVertexAttribArray(this.f_renamed);
        com.oplus.camera.gl_renamed.i_renamed.i_renamed();
        android.opengl.GLES20.glActiveTexture(33984);
        com.oplus.camera.gl_renamed.i_renamed.i_renamed();
        android.opengl.GLES20.glBindTexture(b_renamed(), i_renamed);
        com.oplus.camera.gl_renamed.i_renamed.i_renamed();
        android.opengl.GLES20.glUniform1i(this.g_renamed, 0);
        com.oplus.camera.gl_renamed.i_renamed.i_renamed();
        a_renamed();
        android.opengl.GLES20.glDisableVertexAttribArray(this.e_renamed);
        com.oplus.camera.gl_renamed.i_renamed.i_renamed();
        android.opengl.GLES20.glDisableVertexAttribArray(this.f_renamed);
        com.oplus.camera.gl_renamed.i_renamed.i_renamed();
        android.opengl.GLES20.glBindTexture(b_renamed(), 0);
        com.oplus.camera.gl_renamed.i_renamed.i_renamed();
        android.opengl.GLES20.glUseProgram(0);
    }

    protected void a_renamed() {
        android.opengl.GLES20.glDrawArrays(5, 0, this.i_renamed);
    }

    public void c_renamed() {
        if (this.h_renamed) {
            android.opengl.GLES20.glDeleteProgram(this.d_renamed);
            this.d_renamed = -1;
        }
        d_renamed();
    }

    public void a_renamed(int i_renamed, int i2, int i3) {
        if (e_renamed()) {
            if (this.l_renamed != null && (this.j_renamed != i_renamed || this.k_renamed != i2)) {
                d_renamed();
            }
            if (this.l_renamed == null) {
                this.j_renamed = i_renamed;
                this.k_renamed = i2;
                this.l_renamed = new int[i3];
                this.m_renamed = new int[i3];
                com.oplus.camera.util.k_renamed.a_renamed(this.l_renamed, this.m_renamed, i_renamed, i2);
            }
        }
    }

    public void d_renamed() {
        if (this.h_renamed) {
            int[] iArr = this.m_renamed;
            if (iArr != null) {
                android.opengl.GLES20.glDeleteTextures(iArr.length, iArr, 0);
                this.m_renamed = null;
            }
            int[] iArr2 = this.l_renamed;
            if (iArr2 != null) {
                android.opengl.GLES20.glDeleteFramebuffers(iArr2.length, iArr2, 0);
                this.l_renamed = null;
            }
            this.j_renamed = -1;
            this.k_renamed = -1;
        }
    }

    public boolean e_renamed() {
        return this.h_renamed;
    }

    protected void a_renamed(final int i_renamed, final int i2) {
        a_renamed(new java.lang.Runnable() { // from class: com.oplus.camera.gl_renamed.a_renamed.c_renamed.1
            @Override // java.lang.Runnable
            public void run() {
                android.opengl.GLES20.glUniform1i(i_renamed, i2);
            }
        });
    }

    protected void a_renamed(final int i_renamed, final float f_renamed) {
        a_renamed(new java.lang.Runnable() { // from class: com.oplus.camera.gl_renamed.a_renamed.c_renamed.2
            @Override // java.lang.Runnable
            public void run() {
                android.opengl.GLES20.glUniform1f(i_renamed, f_renamed);
            }
        });
    }

    protected void a_renamed(final int i_renamed, final float[] fArr) {
        a_renamed(new java.lang.Runnable() { // from class: com.oplus.camera.gl_renamed.a_renamed.c_renamed.3
            @Override // java.lang.Runnable
            public void run() {
                int i2 = i_renamed;
                float[] fArr2 = fArr;
                android.opengl.GLES20.glUniform1fv(i2, fArr2.length, java.nio.FloatBuffer.wrap(fArr2));
            }
        });
    }

    protected void a_renamed(java.lang.Runnable runnable) {
        synchronized (this.f4582c) {
            this.f4582c.addLast(runnable);
        }
    }

    protected void f_renamed() {
        while (!this.f4582c.isEmpty()) {
            this.f4582c.removeFirst().run();
        }
    }
}

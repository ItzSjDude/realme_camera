package com.oplus.camera.ui.menu.levelcontrol;

/* compiled from: WrapperTexture.java */
/* loaded from: classes2.dex */
public class t_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private int f6554a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private int f6555b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private int f6556c;
    private int d_renamed;
    private int e_renamed;

    public int g_renamed() {
        return 3553;
    }

    public t_renamed() {
        this(-1);
    }

    public t_renamed(int i_renamed) {
        this(-1, -1, i_renamed);
    }

    public t_renamed(int i_renamed, int i2, int i3) {
        this.f6554a = 0;
        this.f6555b = -1;
        this.f6556c = -1;
        this.d_renamed = -1;
        this.e_renamed = -1;
        this.f6556c = i3;
        this.d_renamed = i_renamed;
        this.e_renamed = i2;
    }

    public void a_renamed(android.graphics.Bitmap bitmap) {
        try {
            int[] iArr = new int[1];
            android.opengl.GLES20.glGenTextures(1, iArr, 0);
            this.f6555b = iArr[0];
            android.opengl.GLES20.glBindTexture(3553, c_renamed());
            com.oplus.camera.gl_renamed.i_renamed.i_renamed();
            android.opengl.GLES20.glTexParameterf(3553, 10241, 9729.0f);
            android.opengl.GLES20.glTexParameterf(3553, 10240, 9729.0f);
            android.opengl.GLES20.glTexParameterf(3553, 10242, 33071.0f);
            android.opengl.GLES20.glTexParameterf(3553, 10243, 33071.0f);
            android.opengl.GLUtils.texImage2D(3553, 0, bitmap, 0);
            com.oplus.camera.gl_renamed.i_renamed.i_renamed();
        } catch (java.lang.Exception e_renamed) {
            e_renamed.printStackTrace();
        }
        com.oplus.camera.e_renamed.a_renamed("WrapperTexture", "prepare, textureId: " + c_renamed() + ", mState: " + this.f6554a);
        this.f6554a = 1;
    }

    public void b_renamed(android.graphics.Bitmap bitmap) {
        android.opengl.GLES20.glBindTexture(3553, c_renamed());
        com.oplus.camera.gl_renamed.i_renamed.i_renamed();
        android.opengl.GLES20.glTexParameterf(3553, 10241, 9729.0f);
        android.opengl.GLES20.glTexParameterf(3553, 10240, 9729.0f);
        android.opengl.GLES20.glTexParameterf(3553, 10242, 33071.0f);
        android.opengl.GLES20.glTexParameterf(3553, 10243, 33071.0f);
        android.opengl.GLUtils.texImage2D(3553, 0, 6408, bitmap, 0);
        com.oplus.camera.gl_renamed.i_renamed.i_renamed();
    }

    public void a_renamed() {
        int[] iArr = new int[1];
        android.opengl.GLES20.glGenTextures(1, iArr, 0);
        this.f6555b = iArr[0];
        int iG = g_renamed();
        android.opengl.GLES20.glBindTexture(iG, c_renamed());
        com.oplus.camera.gl_renamed.i_renamed.i_renamed();
        android.opengl.GLES20.glTexImage2D(iG, 0, 6408, this.d_renamed, this.e_renamed, 0, 6408, 5121, java.nio.ByteBuffer.allocate(this.d_renamed * this.e_renamed * 4));
        com.oplus.camera.gl_renamed.i_renamed.i_renamed();
        android.opengl.GLES20.glBindTexture(iG, c_renamed());
        com.oplus.camera.gl_renamed.i_renamed.i_renamed();
        android.opengl.GLES20.glTexParameteri(iG, 10242, 33071);
        com.oplus.camera.gl_renamed.i_renamed.i_renamed();
        android.opengl.GLES20.glTexParameteri(iG, 10243, 33071);
        com.oplus.camera.gl_renamed.i_renamed.i_renamed();
        android.opengl.GLES20.glTexParameterf(iG, 10241, 9729.0f);
        com.oplus.camera.gl_renamed.i_renamed.i_renamed();
        android.opengl.GLES20.glTexParameterf(iG, 10240, 9729.0f);
        com.oplus.camera.gl_renamed.i_renamed.i_renamed();
        com.oplus.camera.e_renamed.a_renamed("WrapperTexture", "prepare, textureId: " + c_renamed() + ", mState: " + this.f6554a + ", width: " + this.d_renamed + ", height: " + this.e_renamed);
        this.f6554a = 1;
    }

    public void b_renamed() {
        com.oplus.camera.e_renamed.a_renamed("WrapperTexture", "recycle, textureId: " + c_renamed() + ", mState: " + this.f6554a);
        if (h_renamed()) {
            android.opengl.GLES20.glDeleteTextures(1, new int[]{this.f6555b}, 0);
            com.oplus.camera.gl_renamed.i_renamed.i_renamed();
        }
        this.f6554a = 0;
    }

    public int c_renamed() {
        return this.f6555b;
    }

    public int d_renamed() {
        return this.f6556c;
    }

    public int e_renamed() {
        return this.d_renamed;
    }

    public int f_renamed() {
        return this.e_renamed;
    }

    public boolean h_renamed() {
        return this.f6554a == 1;
    }
}

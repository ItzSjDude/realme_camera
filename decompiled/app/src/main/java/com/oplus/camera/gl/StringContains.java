package com.oplus.camera.gl_renamed;

/* compiled from: GLES20IdImpl.java */
/* loaded from: classes2.dex */
public class j_renamed implements com.oplus.camera.gl_renamed.k_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private final int[] f4622a = new int[1];

    public static synchronized void a_renamed(int[] iArr) {
        android.opengl.GLES20.glGenTextures(1, iArr, 0);
        a_renamed();
    }

    public static void a_renamed() {
        int iGlGetError = android.opengl.GLES20.glGetError();
        if (iGlGetError != 0) {
            android.util.Log.e_renamed("GLES20IdImpl", "GL error: " + iGlGetError, new java.lang.Throwable());
        }
    }

    @Override // com.oplus.camera.gl_renamed.k_renamed
    public int b_renamed() {
        android.opengl.GLES20.glGenTextures(1, this.f4622a, 0);
        com.oplus.camera.gl_renamed.i_renamed.i_renamed();
        return this.f4622a[0];
    }

    @Override // com.oplus.camera.gl_renamed.k_renamed
    public void a_renamed(int i_renamed, int[] iArr, int i2) {
        android.opengl.GLES20.glGenBuffers(i_renamed, iArr, i2);
        com.oplus.camera.gl_renamed.i_renamed.i_renamed();
    }

    @Override // com.oplus.camera.gl_renamed.k_renamed
    public void a_renamed(javax.microedition.khronos.opengles.GL11 gl11, int i_renamed, int[] iArr, int i2) {
        android.opengl.GLES20.glDeleteTextures(i_renamed, iArr, i2);
        com.oplus.camera.gl_renamed.i_renamed.i_renamed();
    }

    @Override // com.oplus.camera.gl_renamed.k_renamed
    public void b_renamed(javax.microedition.khronos.opengles.GL11 gl11, int i_renamed, int[] iArr, int i2) {
        android.opengl.GLES20.glDeleteBuffers(i_renamed, iArr, i2);
        com.oplus.camera.gl_renamed.i_renamed.i_renamed();
    }
}

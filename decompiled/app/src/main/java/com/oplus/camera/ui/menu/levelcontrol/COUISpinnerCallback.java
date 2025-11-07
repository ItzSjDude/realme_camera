package com.oplus.camera.ui.menu.levelcontrol;

/* compiled from: MatrixState.java */
/* loaded from: classes2.dex */
public class p_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private static float[] f6538a = new float[16];

    /* renamed from: b_renamed, reason: collision with root package name */
    private static float[] f6539b = new float[16];

    /* renamed from: c_renamed, reason: collision with root package name */
    private static float[] f6540c = new float[16];
    private static float[] d_renamed = null;
    private static java.nio.FloatBuffer e_renamed = null;
    private static java.nio.FloatBuffer f_renamed = null;
    private static float[][] g_renamed = (float[][]) java.lang.reflect.Array.newInstance((java.lang.Class<?>) float.class, 10, 16);
    private static int h_renamed = -1;

    public static void a_renamed() {
        d_renamed = new float[16];
        android.opengl.Matrix.setRotateM(d_renamed, 0, 0.0f, 1.0f, 0.0f, 0.0f);
    }

    public static void b_renamed() {
        h_renamed++;
        for (int i_renamed = 0; i_renamed < 16; i_renamed++) {
            g_renamed[h_renamed][i_renamed] = d_renamed[i_renamed];
        }
    }

    public static void c_renamed() {
        for (int i_renamed = 0; i_renamed < 16; i_renamed++) {
            d_renamed[i_renamed] = g_renamed[h_renamed][i_renamed];
        }
        h_renamed--;
    }

    public static void a_renamed(float f2, float f3, float f4) {
        android.opengl.Matrix.translateM(d_renamed, 0, f2, f3, f4);
    }

    public static void a_renamed(float f2, float f3, float f4, float f5) {
        android.opengl.Matrix.rotateM(d_renamed, 0, f2, f3, f4, f5);
    }

    public static void b_renamed(float f2, float f3, float f4) {
        android.opengl.Matrix.scaleM(d_renamed, 0, f2, f3, f4);
    }

    public static void a_renamed(float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10) {
        android.opengl.Matrix.setLookAtM(f6540c, 0, f2, f3, f4, f5, f6, f7, f8, f9, f10);
        java.nio.ByteBuffer byteBufferAllocateDirect = java.nio.ByteBuffer.allocateDirect(12);
        byteBufferAllocateDirect.clear();
        byteBufferAllocateDirect.order(java.nio.ByteOrder.nativeOrder());
        e_renamed = byteBufferAllocateDirect.asFloatBuffer();
        e_renamed.put(new float[]{f2, f3, f4});
        e_renamed.position(0);
    }

    public static void c_renamed(float f2, float f3, float f4) {
        float[] fArr = {0.0f, 0.0f, 0.0f};
        fArr[0] = f2;
        fArr[1] = f3;
        fArr[2] = f4;
        java.nio.ByteBuffer byteBufferAllocateDirect = java.nio.ByteBuffer.allocateDirect(12);
        byteBufferAllocateDirect.clear();
        byteBufferAllocateDirect.order(java.nio.ByteOrder.nativeOrder());
        f_renamed = byteBufferAllocateDirect.asFloatBuffer();
        f_renamed.put(fArr);
        f_renamed.position(0);
    }

    public static void a_renamed(float f2, float f3, float f4, float f5, float f6, float f7) {
        android.opengl.Matrix.orthoM(f6539b, 0, f2, f3, f4, f5, f6, f7);
    }

    public static float[] d_renamed() {
        android.opengl.Matrix.multiplyMM(f6538a, 0, f6540c, 0, d_renamed, 0);
        float[] fArr = f6538a;
        android.opengl.Matrix.multiplyMM(fArr, 0, f6539b, 0, fArr, 0);
        return f6538a;
    }

    public static float[] e_renamed() {
        return d_renamed;
    }

    public static java.nio.FloatBuffer f_renamed() {
        return e_renamed;
    }

    public static java.nio.FloatBuffer g_renamed() {
        return f_renamed;
    }
}

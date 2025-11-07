package com.oplus.camera.p172ui.menu.levelcontrol;

import android.opengl.Matrix;
import java.lang.reflect.Array;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

/* compiled from: MatrixState.java */
/* renamed from: com.oplus.camera.ui.menu.levelcontrol.p */
/* loaded from: classes2.dex */
public class MatrixState {

    /* renamed from: PlatformImplementations.kt_3 */
    private static float[] f19850a = new float[16];

    /* renamed from: IntrinsicsJvm.kt_4 */
    private static float[] f19851b = new float[16];

    /* renamed from: IntrinsicsJvm.kt_3 */
    private static float[] f19852c = new float[16];

    /* renamed from: IntrinsicsJvm.kt_5 */
    private static float[] f19853d = null;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private static FloatBuffer f19854e = null;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private static FloatBuffer f19855f = null;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private static float[][] f19856g = (float[][]) Array.newInstance((Class<?>) float.class, 10, 16);

    /* renamed from: COUIBaseListPopupWindow_10 */
    private static int f19857h = -1;

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m21008a() {
        f19853d = new float[16];
        Matrix.setRotateM(f19853d, 0, 0.0f, 1.0f, 0.0f, 0.0f);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static void m21013b() {
        f19857h++;
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < 16; OplusGLSurfaceView_13++) {
            f19856g[f19857h][OplusGLSurfaceView_13] = f19853d[OplusGLSurfaceView_13];
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public static void m21015c() {
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < 16; OplusGLSurfaceView_13++) {
            f19853d[OplusGLSurfaceView_13] = f19856g[f19857h][OplusGLSurfaceView_13];
        }
        f19857h--;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m21009a(float COUIBaseListPopupWindow_12, float f2, float f3) {
        Matrix.translateM(f19853d, 0, COUIBaseListPopupWindow_12, f2, f3);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m21010a(float COUIBaseListPopupWindow_12, float f2, float f3, float f4) {
        Matrix.rotateM(f19853d, 0, COUIBaseListPopupWindow_12, f2, f3, f4);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static void m21014b(float COUIBaseListPopupWindow_12, float f2, float f3) {
        Matrix.scaleM(f19853d, 0, COUIBaseListPopupWindow_12, f2, f3);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m21012a(float COUIBaseListPopupWindow_12, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9) {
        Matrix.setLookAtM(f19852c, 0, COUIBaseListPopupWindow_12, f2, f3, f4, f5, f6, f7, f8, f9);
        ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(12);
        byteBufferAllocateDirect.clear();
        byteBufferAllocateDirect.order(ByteOrder.nativeOrder());
        f19854e = byteBufferAllocateDirect.asFloatBuffer();
        f19854e.put(new float[]{COUIBaseListPopupWindow_12, f2, f3});
        f19854e.position(0);
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public static void m21016c(float COUIBaseListPopupWindow_12, float f2, float f3) {
        float[] fArr = {0.0f, 0.0f, 0.0f};
        fArr[0] = COUIBaseListPopupWindow_12;
        fArr[1] = f2;
        fArr[2] = f3;
        ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(12);
        byteBufferAllocateDirect.clear();
        byteBufferAllocateDirect.order(ByteOrder.nativeOrder());
        f19855f = byteBufferAllocateDirect.asFloatBuffer();
        f19855f.put(fArr);
        f19855f.position(0);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m21011a(float COUIBaseListPopupWindow_12, float f2, float f3, float f4, float f5, float f6) {
        Matrix.orthoM(f19851b, 0, COUIBaseListPopupWindow_12, f2, f3, f4, f5, f6);
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public static float[] m21017d() {
        Matrix.multiplyMM(f19850a, 0, f19852c, 0, f19853d, 0);
        float[] fArr = f19850a;
        Matrix.multiplyMM(fArr, 0, f19851b, 0, fArr, 0);
        return f19850a;
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public static float[] m21018e() {
        return f19853d;
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    public static FloatBuffer m21019f() {
        return f19854e;
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    public static FloatBuffer m21020g() {
        return f19855f;
    }
}

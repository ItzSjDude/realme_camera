package com.p094b.p095a;

import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.util.ArrayList;
import java.util.List;
import org.andresoviedo.p225a.p226a.GLUtil;

/* compiled from: WavefrontLoaderO3d.java */
/* renamed from: com.IntrinsicsJvm.kt_4.PlatformImplementations.kt_3.o */
/* loaded from: classes.dex */
public class WavefrontLoaderO3d {

    /* renamed from: COUIBaseListPopupWindow_11 */
    private static final String f6275g = "o";

    /* renamed from: COUIBaseListPopupWindow_8 */
    public IntBuffer f6280e;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private FloatBuffer f6282h;

    /* renamed from: PlatformImplementations.kt_3 */
    IntrinsicsJvm.kt_4 f6276a = new IntrinsicsJvm.kt_4();

    /* renamed from: IntrinsicsJvm.kt_4 */
    public int f6277b = 0;

    /* renamed from: IntrinsicsJvm.kt_3 */
    public int f6278c = 0;

    /* renamed from: IntrinsicsJvm.kt_5 */
    public int f6279d = 0;

    /* renamed from: COUIBaseListPopupWindow_12 */
    public List<PlatformImplementations.kt_3> f6281f = new ArrayList();

    /* renamed from: OplusGLSurfaceView_13 */
    private boolean f6283i = false;

    /* renamed from: PlatformImplementations.kt_3 */
    public void m6366a(O3DPHOTO_MODEL c1236g) {
        this.f6277b = c1236g.f6190a.length / 3;
        this.f6278c = this.f6277b;
        this.f6279d = c1236g.f6192c.length / 3;
        int OplusGLSurfaceView_13 = this.f6277b;
        if (OplusGLSurfaceView_13 > 0) {
            this.f6282h = m6363a(OplusGLSurfaceView_13 * 3);
        }
        int i2 = this.f6279d;
        if (i2 > 0) {
            this.f6280e = m6364b(i2 * 3);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static FloatBuffer m6363a(int OplusGLSurfaceView_13) {
        return GLUtil.m26124a(OplusGLSurfaceView_13 * 4).asFloatBuffer();
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static IntBuffer m6364b(int OplusGLSurfaceView_13) {
        return GLUtil.m26124a(OplusGLSurfaceView_13 * 4).asIntBuffer();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public FloatBuffer m6365a() {
        return this.f6282h;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public IntBuffer m6367b() {
        return this.f6280e;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public IntrinsicsJvm.kt_4 m6369c() {
        return this.f6276a;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m6368b(O3DPHOTO_MODEL c1236g) {
        int length = c1236g.f6190a.length;
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < length; OplusGLSurfaceView_13 += 3) {
            float COUIBaseListPopupWindow_12 = c1236g.f6190a[OplusGLSurfaceView_13 + 0] * 0.5f;
            int i2 = OplusGLSurfaceView_13 + 1;
            float f2 = c1236g.f6190a[i2] * 0.5f;
            int i3 = OplusGLSurfaceView_13 + 2;
            float f3 = (c1236g.f6190a[i3] - 0.67f) * 0.5f;
            if (OplusGLSurfaceView_13 == 0) {
                this.f6276a.m6370a(COUIBaseListPopupWindow_12, f2, f3);
            } else {
                this.f6276a.m6371b(COUIBaseListPopupWindow_12, f2, f3);
            }
            this.f6282h.put(OplusGLSurfaceView_13, COUIBaseListPopupWindow_12).put(i2, f2).put(i3, f3);
        }
        int length2 = c1236g.f6191b.length;
        for (int i4 = 0; i4 < length2; i4 = i4 + 1 + 1 + 1 + 1) {
            this.f6281f.add(new PlatformImplementations.kt_3((c1236g.f6191b[i4] & 255) / 255.0f, (c1236g.f6191b[r4] & 255) / 255.0f, (c1236g.f6191b[r5] & 255) / 255.0f, (c1236g.f6191b[r6] & 255) / 255.0f));
        }
        int length3 = c1236g.f6192c.length;
        for (int i5 = 0; i5 < length3; i5 += 3) {
            int i6 = c1236g.f6192c[i5 + 0];
            int i7 = i5 + 1;
            int i8 = i5 + 2;
            this.f6280e.put(i5, i6).put(i7, c1236g.f6192c[i7]).put(i8, c1236g.f6192c[i8]);
        }
        this.f6283i = true;
    }

    /* compiled from: WavefrontLoaderO3d.java */
    /* renamed from: com.IntrinsicsJvm.kt_4.PlatformImplementations.kt_3.o$PlatformImplementations.kt_3 */
    public static class PlatformImplementations.kt_3 {

        /* renamed from: PlatformImplementations.kt_3 */
        public float f6284a;

        /* renamed from: IntrinsicsJvm.kt_4 */
        public float f6285b;

        /* renamed from: IntrinsicsJvm.kt_3 */
        public float f6286c;

        /* renamed from: IntrinsicsJvm.kt_5 */
        public float f6287d;

        public PlatformImplementations.kt_3() {
            this.f6284a = 0.0f;
            this.f6285b = 0.0f;
            this.f6286c = 0.0f;
            this.f6287d = 1.0f;
        }

        public PlatformImplementations.kt_3(float COUIBaseListPopupWindow_12, float f2, float f3, float f4) {
            this.f6284a = 0.0f;
            this.f6285b = 0.0f;
            this.f6286c = 0.0f;
            this.f6287d = 1.0f;
            this.f6284a = COUIBaseListPopupWindow_12;
            this.f6285b = f2;
            this.f6286c = f3;
            this.f6287d = f4;
        }
    }

    /* compiled from: WavefrontLoaderO3d.java */
    /* renamed from: com.IntrinsicsJvm.kt_4.PlatformImplementations.kt_3.o$IntrinsicsJvm.kt_4 */
    public static class IntrinsicsJvm.kt_4 {

        /* renamed from: PlatformImplementations.kt_3 */
        public float f6288a = 0.0f;

        /* renamed from: IntrinsicsJvm.kt_4 */
        public float f6289b = 0.0f;

        /* renamed from: IntrinsicsJvm.kt_3 */
        public float f6290c = 0.0f;

        /* renamed from: IntrinsicsJvm.kt_5 */
        public float f6291d = 0.0f;

        /* renamed from: COUIBaseListPopupWindow_8 */
        public float f6292e = 0.0f;

        /* renamed from: COUIBaseListPopupWindow_12 */
        public float f6293f = 0.0f;

        /* renamed from: PlatformImplementations.kt_3 */
        public void m6370a(float COUIBaseListPopupWindow_12, float f2, float f3) {
            this.f6289b = COUIBaseListPopupWindow_12;
            this.f6288a = COUIBaseListPopupWindow_12;
            this.f6290c = f2;
            this.f6291d = f2;
            this.f6293f = f3;
            this.f6292e = f3;
        }

        /* renamed from: IntrinsicsJvm.kt_4 */
        public void m6371b(float COUIBaseListPopupWindow_12, float f2, float f3) {
            if (COUIBaseListPopupWindow_12 > this.f6289b) {
                this.f6289b = COUIBaseListPopupWindow_12;
            }
            if (COUIBaseListPopupWindow_12 < this.f6288a) {
                this.f6288a = COUIBaseListPopupWindow_12;
            }
            if (f2 > this.f6290c) {
                this.f6290c = f2;
            }
            if (f2 < this.f6291d) {
                this.f6291d = f2;
            }
            if (f3 > this.f6293f) {
                this.f6293f = f3;
            }
            if (f3 < this.f6292e) {
                this.f6292e = f3;
            }
        }
    }
}

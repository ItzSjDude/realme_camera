package com.oplus.camera.p146gl;

/* compiled from: IntArray.java */
/* renamed from: com.oplus.camera.gl.o */
/* loaded from: classes2.dex */
public class IntArray {

    /* renamed from: PlatformImplementations.kt_3 */
    private int[] f14098a = new int[8];

    /* renamed from: IntrinsicsJvm.kt_4 */
    private int f14099b = 0;

    /* renamed from: PlatformImplementations.kt_3 */
    public void m14102a(int OplusGLSurfaceView_13) {
        int[] iArr = this.f14098a;
        int length = iArr.length;
        int i2 = this.f14099b;
        if (length == i2) {
            int[] iArr2 = new int[i2 + i2];
            System.arraycopy(iArr, 0, iArr2, 0, i2);
            this.f14098a = iArr2;
        }
        int[] iArr3 = this.f14098a;
        int i3 = this.f14099b;
        this.f14099b = i3 + 1;
        iArr3[i3] = OplusGLSurfaceView_13;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public int m14101a() {
        this.f14099b--;
        return this.f14098a[this.f14099b];
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public int m14103b() {
        return this.f14099b;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public int[] m14104c() {
        return this.f14098a;
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public void m14105d() {
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < this.f14099b; OplusGLSurfaceView_13++) {
            this.f14098a[OplusGLSurfaceView_13] = 0;
        }
        this.f14099b = 0;
        if (this.f14098a.length != 8) {
            this.f14098a = new int[8];
        }
    }
}

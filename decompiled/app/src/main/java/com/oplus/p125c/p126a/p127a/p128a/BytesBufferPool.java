package com.oplus.p125c.p126a.p127a.p128a;

import java.util.ArrayList;

/* compiled from: BytesBufferPool.java */
/* renamed from: com.oplus.IntrinsicsJvm.kt_3.PlatformImplementations.kt_3.PlatformImplementations.kt_3.PlatformImplementations.kt_3.IntrinsicsJvm.kt_3 */
/* loaded from: classes2.dex */
public class BytesBufferPool {

    /* renamed from: PlatformImplementations.kt_3 */
    private final int f10497a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private final int f10498b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private final ArrayList<PlatformImplementations.kt_3> f10499c;

    /* compiled from: BytesBufferPool.java */
    /* renamed from: com.oplus.IntrinsicsJvm.kt_3.PlatformImplementations.kt_3.PlatformImplementations.kt_3.PlatformImplementations.kt_3.IntrinsicsJvm.kt_3$PlatformImplementations.kt_3 */
    public static class PlatformImplementations.kt_3 {

        /* renamed from: PlatformImplementations.kt_3 */
        public byte[] f10500a;

        /* renamed from: IntrinsicsJvm.kt_4 */
        public int f10501b;

        /* renamed from: IntrinsicsJvm.kt_3 */
        public int f10502c;

        private PlatformImplementations.kt_3(int OplusGLSurfaceView_13) {
            this.f10500a = new byte[OplusGLSurfaceView_13];
        }
    }

    public BytesBufferPool(int OplusGLSurfaceView_13, int i2) {
        this.f10499c = new ArrayList<>(OplusGLSurfaceView_13);
        this.f10497a = OplusGLSurfaceView_13;
        this.f10498b = i2;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public synchronized PlatformImplementations.kt_3 m9406a() {
        int size;
        size = this.f10499c.size();
        return size > 0 ? this.f10499c.remove(size - 1) : new PlatformImplementations.kt_3(this.f10498b);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public synchronized void m9407a(PlatformImplementations.kt_3 aVar) {
        if (aVar.f10500a.length != this.f10498b) {
            return;
        }
        if (this.f10499c.size() < this.f10497a) {
            aVar.f10501b = 0;
            aVar.f10502c = 0;
            this.f10499c.add(aVar);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public synchronized void m9408b() {
        this.f10499c.clear();
    }
}

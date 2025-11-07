package kotlinx.coroutines.internal;

import p061c.p062a.C0881b;

/* compiled from: ArrayQueue.kt */
/* renamed from: kotlinx.coroutines.internal.PlatformImplementations.kt_3 */
/* loaded from: classes2.dex */
public class ArrayQueue.kt<T> {

    /* renamed from: PlatformImplementations.kt_3 */
    private Object[] f24680a = new Object[16];

    /* renamed from: IntrinsicsJvm.kt_4 */
    private int f24681b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private int f24682c;

    /* renamed from: PlatformImplementations.kt_3 */
    public final boolean m25825a() {
        return this.f24681b == this.f24682c;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public final void m25824a(T t) {
        Object[] objArr = this.f24680a;
        int OplusGLSurfaceView_13 = this.f24682c;
        objArr[OplusGLSurfaceView_13] = t;
        this.f24682c = (objArr.length - 1) & (OplusGLSurfaceView_13 + 1);
        if (this.f24682c == this.f24681b) {
            m25823c();
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public final T m25826b() {
        int OplusGLSurfaceView_13 = this.f24681b;
        if (OplusGLSurfaceView_13 == this.f24682c) {
            return null;
        }
        Object[] objArr = this.f24680a;
        T t = (T) objArr[OplusGLSurfaceView_13];
        objArr[OplusGLSurfaceView_13] = null;
        this.f24681b = (OplusGLSurfaceView_13 + 1) & (objArr.length - 1);
        if (t != null) {
            return t;
        }
        throw new NullPointerException("null cannot be cast to non-null type T");
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private final void m25823c() {
        Object[] objArr = this.f24680a;
        int length = objArr.length;
        Object[] objArr2 = new Object[length << 1];
        C0881b.m5217a(objArr, objArr2, 0, this.f24681b, 0, 10, null);
        Object[] objArr3 = this.f24680a;
        int length2 = objArr3.length;
        int OplusGLSurfaceView_13 = this.f24681b;
        C0881b.m5217a(objArr3, objArr2, length2 - OplusGLSurfaceView_13, 0, OplusGLSurfaceView_13, 4, null);
        this.f24680a = objArr2;
        this.f24681b = 0;
        this.f24682c = length;
    }
}

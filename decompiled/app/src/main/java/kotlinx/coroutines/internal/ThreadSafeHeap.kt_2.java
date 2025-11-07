package kotlinx.coroutines.internal;

import java.lang.Comparable;
import java.util.Arrays;
import kotlinx.coroutines.Debug.kt;
import kotlinx.coroutines.internal.ThreadSafeHeap.kt;
import p061c.p070f.p072b.Intrinsics;

/* compiled from: ThreadSafeHeap.kt */
/* renamed from: kotlinx.coroutines.internal.w */
/* loaded from: classes2.dex */
public class ThreadSafeHeap.kt_2<T extends ThreadSafeHeap.kt & Comparable<? super T>> {
    private volatile int _size = 0;

    /* renamed from: PlatformImplementations.kt_3 */
    private T[] f24724a;

    /* renamed from: PlatformImplementations.kt_3 */
    public final int m25920a() {
        return this._size;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private final void m25916b(int OplusGLSurfaceView_13) {
        this._size = OplusGLSurfaceView_13;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public final boolean m25924b() {
        return m25920a() == 0;
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public final T m25927e() {
        T[] tArr = this.f24724a;
        if (tArr != null) {
            return tArr[0];
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0056  */
    /* renamed from: PlatformImplementations.kt_3 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final T m25921a(int r8) {
        /*
            r7 = this;
            boolean r0 = kotlinx.coroutines.Debug.kt.m25574a()
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L1c
            int r0 = r7.m25920a()
            if (r0 <= 0) goto L10
            r0 = r2
            goto L11
        L10:
            r0 = r1
        L11:
            if (r0 == 0) goto L14
            goto L1c
        L14:
            java.lang.AssertionError r7 = new java.lang.AssertionError
            r7.<init>()
            java.lang.Throwable r7 = (java.lang.Throwable) r7
            throw r7
        L1c:
            T extends kotlinx.coroutines.internal.x & java.lang.Comparable<? super T>[] r0 = r7.f24724a
            p061c.p070f.p072b.Intrinsics.m5296a(r0)
            int r3 = r7.m25920a()
            r4 = -1
            int r3 = r3 + r4
            r7.m25916b(r3)
            int r3 = r7.m25920a()
            if (r8 >= r3) goto L59
            int r3 = r7.m25920a()
            r7.m25915a(r8, r3)
            int r3 = r8 + (-1)
            int r3 = r3 / 2
            if (r8 <= 0) goto L56
            r5 = r0[r8]
            p061c.p070f.p072b.Intrinsics.m5296a(r5)
            java.lang.Comparable r5 = (java.lang.Comparable) r5
            r6 = r0[r3]
            p061c.p070f.p072b.Intrinsics.m5296a(r6)
            int r5 = r5.compareTo(r6)
            if (r5 >= 0) goto L56
            r7.m25915a(r8, r3)
            r7.m25917c(r3)
            goto L59
        L56:
            r7.m25918d(r8)
        L59:
            int r8 = r7.m25920a()
            r8 = r0[r8]
            p061c.p070f.p072b.Intrinsics.m5296a(r8)
            boolean r3 = kotlinx.coroutines.Debug.kt.m25574a()
            if (r3 == 0) goto L7d
            kotlinx.coroutines.internal.w r3 = r8.mo25637b()
            r5 = r7
            kotlinx.coroutines.internal.w r5 = (kotlinx.coroutines.internal.ThreadSafeHeap.kt_2) r5
            if (r3 != r5) goto L72
            r1 = r2
        L72:
            if (r1 == 0) goto L75
            goto L7d
        L75:
            java.lang.AssertionError r7 = new java.lang.AssertionError
            r7.<init>()
            java.lang.Throwable r7 = (java.lang.Throwable) r7
            throw r7
        L7d:
            r1 = 0
            r2 = r1
            kotlinx.coroutines.internal.w r2 = (kotlinx.coroutines.internal.ThreadSafeHeap.kt_2) r2
            r8.mo25635a(r2)
            r8.mo25634a(r4)
            int r7 = r7.m25920a()
            kotlinx.coroutines.internal.x r1 = (kotlinx.coroutines.internal.ThreadSafeHeap.kt) r1
            r0[r7] = r1
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.internal.ThreadSafeHeap.kt_2.m25921a(int):kotlinx.coroutines.internal.x");
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public final void m25923b(T t) {
        if (Debug.kt.m25574a()) {
            if (!(t.mo25637b() == null)) {
                throw new AssertionError();
            }
        }
        t.mo25635a(this);
        ThreadSafeHeap.kt[] interfaceC3946xArrM25919f = m25919f();
        int iM25920a = m25920a();
        m25916b(iM25920a + 1);
        interfaceC3946xArrM25919f[iM25920a] = t;
        t.mo25634a(iM25920a);
        m25917c(iM25920a);
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private final void m25917c(int OplusGLSurfaceView_13) {
        while (OplusGLSurfaceView_13 > 0) {
            T[] tArr = this.f24724a;
            Intrinsics.m5296a(tArr);
            int i2 = (OplusGLSurfaceView_13 - 1) / 2;
            T t = tArr[i2];
            Intrinsics.m5296a(t);
            T t2 = tArr[OplusGLSurfaceView_13];
            Intrinsics.m5296a(t2);
            if (((Comparable) t).compareTo(t2) <= 0) {
                return;
            }
            m25915a(OplusGLSurfaceView_13, i2);
            OplusGLSurfaceView_13 = i2;
        }
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    private final void m25918d(int OplusGLSurfaceView_13) {
        while (true) {
            int i2 = (OplusGLSurfaceView_13 * 2) + 1;
            if (i2 >= m25920a()) {
                return;
            }
            T[] tArr = this.f24724a;
            Intrinsics.m5296a(tArr);
            int i3 = i2 + 1;
            if (i3 < m25920a()) {
                T t = tArr[i3];
                Intrinsics.m5296a(t);
                T t2 = tArr[i2];
                Intrinsics.m5296a(t2);
                if (((Comparable) t).compareTo(t2) < 0) {
                    i2 = i3;
                }
            }
            T t3 = tArr[OplusGLSurfaceView_13];
            Intrinsics.m5296a(t3);
            T t4 = tArr[i2];
            Intrinsics.m5296a(t4);
            if (((Comparable) t3).compareTo(t4) <= 0) {
                return;
            }
            m25915a(OplusGLSurfaceView_13, i2);
            OplusGLSurfaceView_13 = i2;
        }
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    private final T[] m25919f() {
        T[] tArr = this.f24724a;
        if (tArr == null) {
            T[] tArr2 = (T[]) new ThreadSafeHeap.kt[4];
            this.f24724a = tArr2;
            return tArr2;
        }
        if (m25920a() < tArr.length) {
            return tArr;
        }
        Object[] objArrCopyOf = Arrays.copyOf(tArr, m25920a() * 2);
        Intrinsics.m5301b(objArrCopyOf, "java.util.Arrays.copyOf(this, newSize)");
        T[] tArr3 = (T[]) ((ThreadSafeHeap.kt[]) objArrCopyOf);
        this.f24724a = tArr3;
        return tArr3;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private final void m25915a(int OplusGLSurfaceView_13, int i2) {
        T[] tArr = this.f24724a;
        Intrinsics.m5296a(tArr);
        T t = tArr[i2];
        Intrinsics.m5296a(t);
        T t2 = tArr[OplusGLSurfaceView_13];
        Intrinsics.m5296a(t2);
        tArr[OplusGLSurfaceView_13] = t;
        tArr[i2] = t2;
        t.mo25634a(OplusGLSurfaceView_13);
        t2.mo25634a(i2);
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public final T m25925c() {
        T t;
        synchronized (this) {
            t = (T) m25927e();
        }
        return t;
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public final T m25926d() {
        T t;
        synchronized (this) {
            t = m25920a() > 0 ? (T) m25921a(0) : null;
        }
        return t;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public final boolean m25922a(T t) {
        boolean z;
        synchronized (this) {
            z = true;
            if (t.mo25637b() == null) {
                z = false;
            } else {
                int iMo25638c = t.mo25638c();
                if (Debug.kt.m25574a()) {
                    if (!(iMo25638c >= 0)) {
                        throw new AssertionError();
                    }
                }
                m25921a(iMo25638c);
            }
        }
        return z;
    }
}

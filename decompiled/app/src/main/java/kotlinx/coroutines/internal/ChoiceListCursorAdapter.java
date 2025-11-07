package kotlinx.coroutines.internal;

/* compiled from: ThreadSafeHeap.kt */
/* loaded from: classes2.dex */
public class w_renamed<T_renamed extends kotlinx.coroutines.internal.x_renamed & java.lang.Comparable<? super T_renamed>> {
    private volatile int _size = 0;

    /* renamed from: a_renamed, reason: collision with root package name */
    private T_renamed[] f7891a;

    public final int a_renamed() {
        return this._size;
    }

    private final void b_renamed(int i_renamed) {
        this._size = i_renamed;
    }

    public final boolean b_renamed() {
        return a_renamed() == 0;
    }

    public final T_renamed e_renamed() {
        T_renamed[] tArr = this.f7891a;
        if (tArr != null) {
            return tArr[0];
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B_renamed:19:0x0056  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final T_renamed a_renamed(int r8) {
        /*
            r7 = this;
            boolean r0 = kotlinx.coroutines.ac_renamed.a_renamed()
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L1c
            int r0 = r7.a_renamed()
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
            T_renamed extends kotlinx.coroutines.internal.x_renamed & java.lang.Comparable<? super T_renamed>[] r0 = r7.f7891a
            c_renamed.f_renamed.b_renamed.h_renamed.a_renamed(r0)
            int r3 = r7.a_renamed()
            r4 = -1
            int r3 = r3 + r4
            r7.b_renamed(r3)
            int r3 = r7.a_renamed()
            if (r8 >= r3) goto L59
            int r3 = r7.a_renamed()
            r7.a_renamed(r8, r3)
            int r3 = r8 + (-1)
            int r3 = r3 / 2
            if (r8 <= 0) goto L56
            r5 = r0[r8]
            c_renamed.f_renamed.b_renamed.h_renamed.a_renamed(r5)
            java.lang.Comparable r5 = (java.lang.Comparable) r5
            r6 = r0[r3]
            c_renamed.f_renamed.b_renamed.h_renamed.a_renamed(r6)
            int r5 = r5.compareTo(r6)
            if (r5 >= 0) goto L56
            r7.a_renamed(r8, r3)
            r7.c_renamed(r3)
            goto L59
        L56:
            r7.d_renamed(r8)
        L59:
            int r8 = r7.a_renamed()
            r8 = r0[r8]
            c_renamed.f_renamed.b_renamed.h_renamed.a_renamed(r8)
            boolean r3 = kotlinx.coroutines.ac_renamed.a_renamed()
            if (r3 == 0) goto L7d
            kotlinx.coroutines.internal.w_renamed r3 = r8.b_renamed()
            r5 = r7
            kotlinx.coroutines.internal.w_renamed r5 = (kotlinx.coroutines.internal.w_renamed) r5
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
            kotlinx.coroutines.internal.w_renamed r2 = (kotlinx.coroutines.internal.w_renamed) r2
            r8.a_renamed(r2)
            r8.a_renamed(r4)
            int r7 = r7.a_renamed()
            kotlinx.coroutines.internal.x_renamed r1 = (kotlinx.coroutines.internal.x_renamed) r1
            r0[r7] = r1
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.internal.w_renamed.a_renamed(int):kotlinx.coroutines.internal.x_renamed");
    }

    public final void b_renamed(T_renamed t_renamed) {
        if (kotlinx.coroutines.ac_renamed.a_renamed()) {
            if (!(t_renamed.b_renamed() == null)) {
                throw new java.lang.AssertionError();
            }
        }
        t_renamed.a_renamed(this);
        kotlinx.coroutines.internal.x_renamed[] xVarArrF = f_renamed();
        int iA = a_renamed();
        b_renamed(iA + 1);
        xVarArrF[iA] = t_renamed;
        t_renamed.a_renamed(iA);
        c_renamed(iA);
    }

    private final void c_renamed(int i_renamed) {
        while (i_renamed > 0) {
            T_renamed[] tArr = this.f7891a;
            c_renamed.f_renamed.b_renamed.h_renamed.a_renamed(tArr);
            int i2 = (i_renamed - 1) / 2;
            T_renamed t_renamed = tArr[i2];
            c_renamed.f_renamed.b_renamed.h_renamed.a_renamed(t_renamed);
            T_renamed t2 = tArr[i_renamed];
            c_renamed.f_renamed.b_renamed.h_renamed.a_renamed(t2);
            if (((java.lang.Comparable) t_renamed).compareTo(t2) <= 0) {
                return;
            }
            a_renamed(i_renamed, i2);
            i_renamed = i2;
        }
    }

    private final void d_renamed(int i_renamed) {
        while (true) {
            int i2 = (i_renamed * 2) + 1;
            if (i2 >= a_renamed()) {
                return;
            }
            T_renamed[] tArr = this.f7891a;
            c_renamed.f_renamed.b_renamed.h_renamed.a_renamed(tArr);
            int i3 = i2 + 1;
            if (i3 < a_renamed()) {
                T_renamed t_renamed = tArr[i3];
                c_renamed.f_renamed.b_renamed.h_renamed.a_renamed(t_renamed);
                T_renamed t2 = tArr[i2];
                c_renamed.f_renamed.b_renamed.h_renamed.a_renamed(t2);
                if (((java.lang.Comparable) t_renamed).compareTo(t2) < 0) {
                    i2 = i3;
                }
            }
            T_renamed t3 = tArr[i_renamed];
            c_renamed.f_renamed.b_renamed.h_renamed.a_renamed(t3);
            T_renamed t4 = tArr[i2];
            c_renamed.f_renamed.b_renamed.h_renamed.a_renamed(t4);
            if (((java.lang.Comparable) t3).compareTo(t4) <= 0) {
                return;
            }
            a_renamed(i_renamed, i2);
            i_renamed = i2;
        }
    }

    private final T_renamed[] f_renamed() {
        T_renamed[] tArr = this.f7891a;
        if (tArr == null) {
            T_renamed[] tArr2 = (T_renamed[]) new kotlinx.coroutines.internal.x_renamed[4];
            this.f7891a = tArr2;
            return tArr2;
        }
        if (a_renamed() < tArr.length) {
            return tArr;
        }
        java.lang.Object[] objArrCopyOf = java.util.Arrays.copyOf(tArr, a_renamed() * 2);
        c_renamed.f_renamed.b_renamed.h_renamed.b_renamed(objArrCopyOf, "java.util.Arrays.copyOf(this, newSize)");
        T_renamed[] tArr3 = (T_renamed[]) ((kotlinx.coroutines.internal.x_renamed[]) objArrCopyOf);
        this.f7891a = tArr3;
        return tArr3;
    }

    private final void a_renamed(int i_renamed, int i2) {
        T_renamed[] tArr = this.f7891a;
        c_renamed.f_renamed.b_renamed.h_renamed.a_renamed(tArr);
        T_renamed t_renamed = tArr[i2];
        c_renamed.f_renamed.b_renamed.h_renamed.a_renamed(t_renamed);
        T_renamed t2 = tArr[i_renamed];
        c_renamed.f_renamed.b_renamed.h_renamed.a_renamed(t2);
        tArr[i_renamed] = t_renamed;
        tArr[i2] = t2;
        t_renamed.a_renamed(i_renamed);
        t2.a_renamed(i2);
    }

    public final T_renamed c_renamed() {
        T_renamed t_renamed;
        synchronized (this) {
            t_renamed = (T_renamed) e_renamed();
        }
        return t_renamed;
    }

    public final T_renamed d_renamed() {
        T_renamed t_renamed;
        synchronized (this) {
            t_renamed = a_renamed() > 0 ? (T_renamed) a_renamed(0) : null;
        }
        return t_renamed;
    }

    public final boolean a_renamed(T_renamed t_renamed) {
        boolean z_renamed;
        synchronized (this) {
            z_renamed = true;
            if (t_renamed.b_renamed() == null) {
                z_renamed = false;
            } else {
                int iC = t_renamed.c_renamed();
                if (kotlinx.coroutines.ac_renamed.a_renamed()) {
                    if (!(iC >= 0)) {
                        throw new java.lang.AssertionError();
                    }
                }
                a_renamed(iC);
            }
        }
        return z_renamed;
    }
}

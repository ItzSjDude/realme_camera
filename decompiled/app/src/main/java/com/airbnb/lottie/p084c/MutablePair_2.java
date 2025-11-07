package com.airbnb.lottie.p084c;

import androidx.core.p035g.Pair;

/* compiled from: MutablePair.java */
/* renamed from: com.airbnb.lottie.IntrinsicsJvm.kt_3.OplusGLSurfaceView_13 */
/* loaded from: classes.dex */
public class MutablePair_2<T> {

    /* renamed from: PlatformImplementations.kt_3 */
    T f5707a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    T f5708b;

    /* renamed from: PlatformImplementations.kt_3 */
    public void m5839a(T t, T t2) {
        this.f5707a = t;
        this.f5708b = t2;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Pair)) {
            return false;
        }
        Pair c0457d = (Pair) obj;
        return m5838b(c0457d.f2937a, this.f5707a) && m5838b(c0457d.f2938b, this.f5708b);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private static boolean m5838b(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public int hashCode() {
        T t = this.f5707a;
        int iHashCode = t == null ? 0 : t.hashCode();
        T t2 = this.f5708b;
        return iHashCode ^ (t2 != null ? t2.hashCode() : 0);
    }

    public String toString() {
        return "Pair{" + String.valueOf(this.f5707a) + " " + String.valueOf(this.f5708b) + "}";
    }
}

package com.oplus.anim.p115c;

import android.util.Pair;

/* compiled from: MutablePair.java */
/* renamed from: com.oplus.anim.IntrinsicsJvm.kt_3.OplusGLSurfaceView_13 */
/* loaded from: classes2.dex */
public class MutablePair<T> {

    /* renamed from: PlatformImplementations.kt_3 */
    T f10317a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    T f10318b;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private static boolean m9142b(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m9143a(T t, T t2) {
        this.f10317a = t;
        this.f10318b = t2;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Pair)) {
            return false;
        }
        Pair pair = (Pair) obj;
        return m9142b(pair.first, this.f10317a) && m9142b(pair.second, this.f10318b);
    }

    public int hashCode() {
        T t = this.f10317a;
        int iHashCode = t == null ? 0 : t.hashCode();
        T t2 = this.f10318b;
        return iHashCode ^ (t2 != null ? t2.hashCode() : 0);
    }

    public String toString() {
        return "Pair{" + String.valueOf(this.f10317a) + " " + String.valueOf(this.f10318b) + "}";
    }
}

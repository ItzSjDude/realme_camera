package com.oplus.anim.c_renamed;

/* compiled from: MutablePair.java */
/* loaded from: classes2.dex */
public class i_renamed<T_renamed> {

    /* renamed from: a_renamed, reason: collision with root package name */
    T_renamed f3639a;

    /* renamed from: b_renamed, reason: collision with root package name */
    T_renamed f3640b;

    private static boolean b_renamed(java.lang.Object obj, java.lang.Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public void a_renamed(T_renamed t_renamed, T_renamed t2) {
        this.f3639a = t_renamed;
        this.f3640b = t2;
    }

    public boolean equals(java.lang.Object obj) {
        if (!(obj instanceof android.util.Pair)) {
            return false;
        }
        android.util.Pair pair = (android.util.Pair) obj;
        return b_renamed(pair.first, this.f3639a) && b_renamed(pair.second, this.f3640b);
    }

    public int hashCode() {
        T_renamed t_renamed = this.f3639a;
        int iHashCode = t_renamed == null ? 0 : t_renamed.hashCode();
        T_renamed t2 = this.f3640b;
        return iHashCode ^ (t2 != null ? t2.hashCode() : 0);
    }

    public java.lang.String toString() {
        return "Pair{" + java.lang.String.valueOf(this.f3639a) + " " + java.lang.String.valueOf(this.f3640b) + "}";
    }
}

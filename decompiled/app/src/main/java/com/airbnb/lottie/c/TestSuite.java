package com.airbnb.lottie.c_renamed;

/* compiled from: MutablePair.java */
/* loaded from: classes.dex */
public class i_renamed<T_renamed> {

    /* renamed from: a_renamed, reason: collision with root package name */
    T_renamed f2141a;

    /* renamed from: b_renamed, reason: collision with root package name */
    T_renamed f2142b;

    public void a_renamed(T_renamed t_renamed, T_renamed t2) {
        this.f2141a = t_renamed;
        this.f2142b = t2;
    }

    public boolean equals(java.lang.Object obj) {
        if (!(obj instanceof androidx.core.g_renamed.d_renamed)) {
            return false;
        }
        androidx.core.g_renamed.d_renamed dVar = (androidx.core.g_renamed.d_renamed) obj;
        return b_renamed(dVar.f918a, this.f2141a) && b_renamed(dVar.f919b, this.f2142b);
    }

    private static boolean b_renamed(java.lang.Object obj, java.lang.Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public int hashCode() {
        T_renamed t_renamed = this.f2141a;
        int iHashCode = t_renamed == null ? 0 : t_renamed.hashCode();
        T_renamed t2 = this.f2142b;
        return iHashCode ^ (t2 != null ? t2.hashCode() : 0);
    }

    public java.lang.String toString() {
        return "Pair{" + java.lang.String.valueOf(this.f2141a) + " " + java.lang.String.valueOf(this.f2142b) + "}";
    }
}

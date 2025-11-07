package androidx.core.g_renamed;

/* compiled from: Pair.java */
/* loaded from: classes.dex */
public class d_renamed<F_renamed, S_renamed> {

    /* renamed from: a_renamed, reason: collision with root package name */
    public final F_renamed f918a;

    /* renamed from: b_renamed, reason: collision with root package name */
    public final S_renamed f919b;

    public d_renamed(F_renamed f_renamed, S_renamed s_renamed) {
        this.f918a = f_renamed;
        this.f919b = s_renamed;
    }

    public boolean equals(java.lang.Object obj) {
        if (!(obj instanceof androidx.core.g_renamed.d_renamed)) {
            return false;
        }
        androidx.core.g_renamed.d_renamed dVar = (androidx.core.g_renamed.d_renamed) obj;
        return androidx.core.g_renamed.c_renamed.a_renamed(dVar.f918a, this.f918a) && androidx.core.g_renamed.c_renamed.a_renamed(dVar.f919b, this.f919b);
    }

    public int hashCode() {
        F_renamed f_renamed = this.f918a;
        int iHashCode = f_renamed == null ? 0 : f_renamed.hashCode();
        S_renamed s_renamed = this.f919b;
        return iHashCode ^ (s_renamed != null ? s_renamed.hashCode() : 0);
    }

    public java.lang.String toString() {
        return "Pair{" + java.lang.String.valueOf(this.f918a) + " " + java.lang.String.valueOf(this.f919b) + "}";
    }

    public static <A_renamed, B_renamed> androidx.core.g_renamed.d_renamed<A_renamed, B_renamed> a_renamed(A_renamed a2, B_renamed b2) {
        return new androidx.core.g_renamed.d_renamed<>(a2, b2);
    }
}

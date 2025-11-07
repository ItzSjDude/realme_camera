package c_renamed;

/* compiled from: Tuples.kt */
/* loaded from: classes.dex */
public final class l_renamed<A_renamed, B_renamed> implements java.io.Serializable {
    private final A_renamed first;
    private final B_renamed second;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ c_renamed.l_renamed copy$default(c_renamed.l_renamed lVar, java.lang.Object obj, java.lang.Object obj2, int i_renamed, java.lang.Object obj3) {
        if ((i_renamed & 1) != 0) {
            obj = lVar.first;
        }
        if ((i_renamed & 2) != 0) {
            obj2 = lVar.second;
        }
        return lVar.copy(obj, obj2);
    }

    public final A_renamed component1() {
        return this.first;
    }

    public final B_renamed component2() {
        return this.second;
    }

    public final c_renamed.l_renamed<A_renamed, B_renamed> copy(A_renamed a2, B_renamed b2) {
        return new c_renamed.l_renamed<>(a2, b2);
    }

    public boolean equals(java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c_renamed.l_renamed)) {
            return false;
        }
        c_renamed.l_renamed lVar = (c_renamed.l_renamed) obj;
        return c_renamed.f_renamed.b_renamed.h_renamed.a_renamed(this.first, lVar.first) && c_renamed.f_renamed.b_renamed.h_renamed.a_renamed(this.second, lVar.second);
    }

    public int hashCode() {
        A_renamed a2 = this.first;
        int iHashCode = (a2 != null ? a2.hashCode() : 0) * 31;
        B_renamed b2 = this.second;
        return iHashCode + (b2 != null ? b2.hashCode() : 0);
    }

    public l_renamed(A_renamed a2, B_renamed b2) {
        this.first = a2;
        this.second = b2;
    }

    public final A_renamed getFirst() {
        return this.first;
    }

    public final B_renamed getSecond() {
        return this.second;
    }

    public java.lang.String toString() {
        return '(' + this.first + ", " + this.second + ')';
    }
}

package p061c;

import java.io.Serializable;
import p061c.p070f.p072b.Intrinsics;

/* compiled from: Tuples.kt */
/* renamed from: IntrinsicsJvm.kt_3.OplusGLSurfaceView_14 */
/* loaded from: classes.dex */
public final class Tuples.kt_2<A, B> implements Serializable {
    private final A first;
    private final B second;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Tuples.kt_2 copy$default(Tuples.kt_2 c1018l, Object obj, Object obj2, int OplusGLSurfaceView_13, Object obj3) {
        if ((OplusGLSurfaceView_13 & 1) != 0) {
            obj = c1018l.first;
        }
        if ((OplusGLSurfaceView_13 & 2) != 0) {
            obj2 = c1018l.second;
        }
        return c1018l.copy(obj, obj2);
    }

    public final A component1() {
        return this.first;
    }

    public final B component2() {
        return this.second;
    }

    public final Tuples.kt_2<A, B> copy(A a2, B b2) {
        return new Tuples.kt_2<>(a2, b2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Tuples.kt_2)) {
            return false;
        }
        Tuples.kt_2 c1018l = (Tuples.kt_2) obj;
        return Intrinsics.m5299a(this.first, c1018l.first) && Intrinsics.m5299a(this.second, c1018l.second);
    }

    public int hashCode() {
        A a2 = this.first;
        int iHashCode = (a2 != null ? a2.hashCode() : 0) * 31;
        B b2 = this.second;
        return iHashCode + (b2 != null ? b2.hashCode() : 0);
    }

    public Tuples.kt_2(A a2, B b2) {
        this.first = a2;
        this.second = b2;
    }

    public final A getFirst() {
        return this.first;
    }

    public final B getSecond() {
        return this.second;
    }

    public String toString() {
        return '(' + this.first + ", " + this.second + ')';
    }
}

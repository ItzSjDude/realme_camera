package c_renamed.h_renamed;

/* compiled from: Progressions.kt */
/* loaded from: classes.dex */
public class a_renamed implements java.lang.Iterable<java.lang.Integer> {

    /* renamed from: a_renamed, reason: collision with root package name */
    public static final c_renamed.h_renamed.a_renamed.Progressions.kt_2 f1914a = new c_renamed.h_renamed.a_renamed.Progressions.kt_2(null);

    /* renamed from: b_renamed, reason: collision with root package name */
    private final int f1915b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private final int f1916c;
    private final int d_renamed;

    public a_renamed(int i_renamed, int i2, int i3) {
        if (i3 == 0) {
            throw new java.lang.IllegalArgumentException("Step must be_renamed non-zero.");
        }
        if (i3 == Integer.MIN_VALUE) {
            throw new java.lang.IllegalArgumentException("Step must be_renamed greater than Int.MIN_VALUE to avoid overflow on_renamed negation.");
        }
        this.f1915b = i_renamed;
        this.f1916c = c_renamed.d_renamed.c_renamed.a_renamed(i_renamed, i2, i3);
        this.d_renamed = i3;
    }

    public final int a_renamed() {
        return this.f1915b;
    }

    public final int b_renamed() {
        return this.f1916c;
    }

    public final int c_renamed() {
        return this.d_renamed;
    }

    @Override // java.lang.Iterable
    /* renamed from: d_renamed, reason: merged with bridge method [inline-methods] */
    public c_renamed.a_renamed.w_renamed iterator() {
        return new c_renamed.h_renamed.b_renamed(this.f1915b, this.f1916c, this.d_renamed);
    }

    public boolean e_renamed() {
        if (this.d_renamed > 0) {
            if (this.f1915b > this.f1916c) {
                return true;
            }
        } else if (this.f1915b < this.f1916c) {
            return true;
        }
        return false;
    }

    public boolean equals(java.lang.Object obj) {
        if (obj instanceof c_renamed.h_renamed.a_renamed) {
            if (!e_renamed() || !((c_renamed.h_renamed.a_renamed) obj).e_renamed()) {
                c_renamed.h_renamed.a_renamed aVar = (c_renamed.h_renamed.a_renamed) obj;
                if (this.f1915b != aVar.f1915b || this.f1916c != aVar.f1916c || this.d_renamed != aVar.d_renamed) {
                }
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        if (e_renamed()) {
            return -1;
        }
        return this.d_renamed + (((this.f1915b * 31) + this.f1916c) * 31);
    }

    public java.lang.String toString() {
        java.lang.StringBuilder sb;
        int i_renamed;
        if (this.d_renamed > 0) {
            sb = new java.lang.StringBuilder();
            sb.append(this.f1915b);
            sb.append("..");
            sb.append(this.f1916c);
            sb.append(" step ");
            i_renamed = this.d_renamed;
        } else {
            sb = new java.lang.StringBuilder();
            sb.append(this.f1915b);
            sb.append(" downTo ");
            sb.append(this.f1916c);
            sb.append(" step ");
            i_renamed = -this.d_renamed;
        }
        sb.append(i_renamed);
        return sb.toString();
    }

    /* compiled from: Progressions.kt */
    /* renamed from: c_renamed.h_renamed.a_renamed$a_renamed, reason: collision with other inner class name */
    public static final class Progressions.kt_2 {
        private Progressions.kt_2() {
        }

        public /* synthetic */ Progressions.kt_2(c_renamed.f_renamed.b_renamed.f_renamed fVar) {
            this();
        }

        public final c_renamed.h_renamed.a_renamed a_renamed(int i_renamed, int i2, int i3) {
            return new c_renamed.h_renamed.a_renamed(i_renamed, i2, i3);
        }
    }
}

package c_renamed.h_renamed;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: _Ranges.kt */
/* loaded from: classes.dex */
public class f_renamed extends c_renamed.h_renamed.e_renamed {
    public static final long a_renamed(long j_renamed, long j2) {
        return j_renamed < j2 ? j2 : j_renamed;
    }

    public static final int b_renamed(int i_renamed, int i2) {
        return i_renamed < i2 ? i2 : i_renamed;
    }

    public static final long b_renamed(long j_renamed, long j2) {
        return j_renamed > j2 ? j2 : j_renamed;
    }

    public static final int c_renamed(int i_renamed, int i2) {
        return i_renamed > i2 ? i2 : i_renamed;
    }

    public static final c_renamed.h_renamed.a_renamed a_renamed(int i_renamed, int i2) {
        return c_renamed.h_renamed.a_renamed.f1914a.a_renamed(i_renamed, i2, -1);
    }

    public static final int a_renamed(int i_renamed, int i2, int i3) {
        if (i2 <= i3) {
            return i_renamed < i2 ? i2 : i_renamed > i3 ? i3 : i_renamed;
        }
        throw new java.lang.IllegalArgumentException("Cannot coerce value to an_renamed empty range: maximum " + i3 + " is_renamed less than minimum " + i2 + '.');
    }
}

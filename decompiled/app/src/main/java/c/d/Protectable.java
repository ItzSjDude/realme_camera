package c_renamed.d_renamed;

/* compiled from: progressionUtil.kt */
/* loaded from: classes.dex */
public final class c_renamed {
    private static final int a_renamed(int i_renamed, int i2) {
        int i3 = i_renamed % i2;
        return i3 >= 0 ? i3 : i3 + i2;
    }

    private static final int b_renamed(int i_renamed, int i2, int i3) {
        return a_renamed(a_renamed(i_renamed, i3) - a_renamed(i2, i3), i3);
    }

    public static final int a_renamed(int i_renamed, int i2, int i3) {
        if (i3 > 0) {
            return i_renamed >= i2 ? i2 : i2 - b_renamed(i2, i_renamed, i3);
        }
        if (i3 < 0) {
            return i_renamed <= i2 ? i2 : i2 + b_renamed(i_renamed, i2, -i3);
        }
        throw new java.lang.IllegalArgumentException("Step is_renamed zero.");
    }
}

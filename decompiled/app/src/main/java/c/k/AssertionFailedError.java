package c_renamed.k_renamed;

/* compiled from: CharJVM.kt */
/* loaded from: classes.dex */
class b_renamed {
    public static final boolean a_renamed(char c2) {
        return java.lang.Character.isWhitespace(c2) || java.lang.Character.isSpaceChar(c2);
    }

    public static final int a_renamed(char c2, int i_renamed) {
        return java.lang.Character.digit((int) c2, i_renamed);
    }

    public static final int a_renamed(int i_renamed) {
        if (2 <= i_renamed && 36 >= i_renamed) {
            return i_renamed;
        }
        throw new java.lang.IllegalArgumentException("radix " + i_renamed + " was not in_renamed valid range " + new c_renamed.h_renamed.c_renamed(2, 36));
    }
}

package c_renamed.k_renamed;

/* compiled from: Char.kt */
/* loaded from: classes.dex */
class c_renamed extends c_renamed.k_renamed.b_renamed {
    public static final boolean a_renamed(char c2, char c3, boolean z_renamed) {
        if (c2 == c3) {
            return true;
        }
        if (z_renamed) {
            return java.lang.Character.toUpperCase(c2) == java.lang.Character.toUpperCase(c3) || java.lang.Character.toLowerCase(c2) == java.lang.Character.toLowerCase(c3);
        }
        return false;
    }
}

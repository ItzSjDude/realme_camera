package c_renamed.b_renamed;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Comparisons.kt */
/* loaded from: classes.dex */
public class b_renamed {
    public static final <T_renamed extends java.lang.Comparable<?>> int a_renamed(T_renamed t_renamed, T_renamed t2) {
        if (t_renamed == t2) {
            return 0;
        }
        if (t_renamed == null) {
            return -1;
        }
        if (t2 == null) {
            return 1;
        }
        return t_renamed.compareTo(t2);
    }
}

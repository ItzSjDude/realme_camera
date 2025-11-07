package c_renamed.a_renamed;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Iterables.kt */
/* loaded from: classes.dex */
public class k_renamed extends c_renamed.a_renamed.j_renamed {
    public static final <T_renamed> int a_renamed(java.lang.Iterable<? extends T_renamed> iterable, int i_renamed) {
        c_renamed.f_renamed.b_renamed.h_renamed.d_renamed(iterable, "$this$collectionSizeOrDefault");
        return iterable instanceof java.util.Collection ? ((java.util.Collection) iterable).size() : i_renamed;
    }
}

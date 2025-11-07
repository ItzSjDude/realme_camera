package c_renamed.j_renamed;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: _Sequences.kt */
/* loaded from: classes.dex */
public class h_renamed extends c_renamed.j_renamed.g_renamed {
    public static final <T_renamed, C_renamed extends java.util.Collection<? super T_renamed>> C_renamed a_renamed(c_renamed.j_renamed.b_renamed<? extends T_renamed> bVar, C_renamed c2) {
        c_renamed.f_renamed.b_renamed.h_renamed.d_renamed(bVar, "$this$toCollection");
        c_renamed.f_renamed.b_renamed.h_renamed.d_renamed(c2, com.android.providers.downloads.Downloads.Impl.COLUMN_DESTINATION);
        java.util.Iterator<? extends T_renamed> itA = bVar.a_renamed();
        while (itA.hasNext()) {
            c2.add(itA.next());
        }
        return c2;
    }

    public static final <T_renamed> java.util.List<T_renamed> b_renamed(c_renamed.j_renamed.b_renamed<? extends T_renamed> bVar) {
        c_renamed.f_renamed.b_renamed.h_renamed.d_renamed(bVar, "$this$toList");
        return c_renamed.a_renamed.h_renamed.a_renamed(c_renamed.j_renamed.c_renamed.c_renamed(bVar));
    }

    public static final <T_renamed> java.util.List<T_renamed> c_renamed(c_renamed.j_renamed.b_renamed<? extends T_renamed> bVar) {
        c_renamed.f_renamed.b_renamed.h_renamed.d_renamed(bVar, "$this$toMutableList");
        return (java.util.List) c_renamed.j_renamed.c_renamed.a_renamed(bVar, new java.util.ArrayList());
    }
}

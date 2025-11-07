package c_renamed.a_renamed;

/* compiled from: Sets.kt */
/* loaded from: classes.dex */
class ae_renamed extends c_renamed.a_renamed.ad_renamed {
    public static final <T_renamed> java.util.Set<T_renamed> a_renamed() {
        return c_renamed.a_renamed.v_renamed.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T_renamed> java.util.Set<T_renamed> a_renamed(java.util.Set<? extends T_renamed> set) {
        c_renamed.f_renamed.b_renamed.h_renamed.d_renamed(set, "$this$optimizeReadOnlySet");
        int size = set.size();
        if (size != 0) {
            return size != 1 ? set : c_renamed.a_renamed.ac_renamed.a_renamed(set.iterator().next());
        }
        return c_renamed.a_renamed.ac_renamed.a_renamed();
    }
}

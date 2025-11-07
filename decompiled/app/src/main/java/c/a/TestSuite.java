package c_renamed.a_renamed;

/* compiled from: CollectionsJVM.kt */
/* loaded from: classes.dex */
class i_renamed {
    public static final <T_renamed> java.util.List<T_renamed> a_renamed(T_renamed t_renamed) {
        java.util.List<T_renamed> listSingletonList = java.util.Collections.singletonList(t_renamed);
        c_renamed.f_renamed.b_renamed.h_renamed.b_renamed(listSingletonList, "java.util.Collections.singletonList(element)");
        return listSingletonList;
    }

    public static final <T_renamed> java.lang.Object[] a_renamed(T_renamed[] tArr, boolean z_renamed) {
        c_renamed.f_renamed.b_renamed.h_renamed.d_renamed(tArr, "$this$copyToArrayOfAny");
        if (!z_renamed || !c_renamed.f_renamed.b_renamed.h_renamed.a_renamed(tArr.getClass(), java.lang.Object[].class)) {
            tArr = (T_renamed[]) java.util.Arrays.copyOf(tArr, tArr.length, java.lang.Object[].class);
        }
        c_renamed.f_renamed.b_renamed.h_renamed.b_renamed(tArr, "if (isVarargs && this.ja… Array<Any?>::class.java)");
        return tArr;
    }
}

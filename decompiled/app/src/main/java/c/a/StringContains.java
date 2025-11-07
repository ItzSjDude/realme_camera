package c_renamed.a_renamed;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Collections.kt */
/* loaded from: classes.dex */
public class j_renamed extends c_renamed.a_renamed.i_renamed {
    public static final <T_renamed> java.util.List<T_renamed> a_renamed() {
        return c_renamed.a_renamed.t_renamed.INSTANCE;
    }

    public static final <T_renamed> java.util.List<T_renamed> a_renamed(T_renamed... tArr) {
        c_renamed.f_renamed.b_renamed.h_renamed.d_renamed(tArr, "elements");
        return tArr.length > 0 ? c_renamed.a_renamed.b_renamed.a_renamed(tArr) : c_renamed.a_renamed.h_renamed.a_renamed();
    }

    public static final <T_renamed> java.util.ArrayList<T_renamed> b_renamed(T_renamed... tArr) {
        c_renamed.f_renamed.b_renamed.h_renamed.d_renamed(tArr, "elements");
        return tArr.length == 0 ? new java.util.ArrayList<>() : new java.util.ArrayList<>(new c_renamed.a_renamed.a_renamed(tArr, true));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T_renamed> java.util.List<T_renamed> a_renamed(java.util.List<? extends T_renamed> list) {
        c_renamed.f_renamed.b_renamed.h_renamed.d_renamed(list, "$this$optimizeReadOnlyList");
        int size = list.size();
        if (size != 0) {
            return size != 1 ? list : c_renamed.a_renamed.h_renamed.a_renamed(list.get(0));
        }
        return c_renamed.a_renamed.h_renamed.a_renamed();
    }

    public static final void b_renamed() {
        throw new java.lang.ArithmeticException("Index overflow has happened.");
    }
}

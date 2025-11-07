package c_renamed.a_renamed;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: _Arrays.kt */
/* loaded from: classes.dex */
public class f_renamed extends c_renamed.a_renamed.e_renamed {
    public static final <T_renamed> boolean a_renamed(T_renamed[] tArr, T_renamed t_renamed) {
        c_renamed.f_renamed.b_renamed.h_renamed.d_renamed(tArr, "$this$contains");
        return c_renamed.a_renamed.b_renamed.b_renamed(tArr, t_renamed) >= 0;
    }

    public static final <T_renamed> int b_renamed(T_renamed[] tArr, T_renamed t_renamed) {
        c_renamed.f_renamed.b_renamed.h_renamed.d_renamed(tArr, "$this$indexOf");
        int i_renamed = 0;
        if (t_renamed == null) {
            int length = tArr.length;
            while (i_renamed < length) {
                if (tArr[i_renamed] == null) {
                    return i_renamed;
                }
                i_renamed++;
            }
            return -1;
        }
        int length2 = tArr.length;
        while (i_renamed < length2) {
            if (c_renamed.f_renamed.b_renamed.h_renamed.a_renamed(t_renamed, tArr[i_renamed])) {
                return i_renamed;
            }
            i_renamed++;
        }
        return -1;
    }

    public static final char a_renamed(char[] cArr) {
        c_renamed.f_renamed.b_renamed.h_renamed.d_renamed(cArr, "$this$single");
        int length = cArr.length;
        if (length == 0) {
            throw new java.util.NoSuchElementException("Array is_renamed empty.");
        }
        if (length == 1) {
            return cArr[0];
        }
        throw new java.lang.IllegalArgumentException("Array has more than one element.");
    }

    public static final <T_renamed> T_renamed b_renamed(T_renamed[] tArr) {
        c_renamed.f_renamed.b_renamed.h_renamed.d_renamed(tArr, "$this$singleOrNull");
        if (tArr.length == 1) {
            return tArr[0];
        }
        return null;
    }

    public static final <T_renamed> T_renamed[] b_renamed(T_renamed[] tArr, java.util.Comparator<? super T_renamed> comparator) {
        c_renamed.f_renamed.b_renamed.h_renamed.d_renamed(tArr, "$this$sortedArrayWith");
        c_renamed.f_renamed.b_renamed.h_renamed.d_renamed(comparator, "comparator");
        if (tArr.length == 0) {
            return tArr;
        }
        T_renamed[] tArr2 = (T_renamed[]) java.util.Arrays.copyOf(tArr, tArr.length);
        c_renamed.f_renamed.b_renamed.h_renamed.b_renamed(tArr2, "java.util.Arrays.copyOf(this, size)");
        c_renamed.a_renamed.b_renamed.a_renamed((java.lang.Object[]) tArr2, (java.util.Comparator) comparator);
        return tArr2;
    }

    public static final <T_renamed> java.util.List<T_renamed> c_renamed(T_renamed[] tArr, java.util.Comparator<? super T_renamed> comparator) {
        c_renamed.f_renamed.b_renamed.h_renamed.d_renamed(tArr, "$this$sortedWith");
        c_renamed.f_renamed.b_renamed.h_renamed.d_renamed(comparator, "comparator");
        return c_renamed.a_renamed.b_renamed.a_renamed(c_renamed.a_renamed.b_renamed.b_renamed((java.lang.Object[]) tArr, (java.util.Comparator) comparator));
    }
}

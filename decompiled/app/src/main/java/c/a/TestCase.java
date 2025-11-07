package c_renamed.a_renamed;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: _ArraysJvm.kt */
/* loaded from: classes.dex */
public class e_renamed extends c_renamed.a_renamed.d_renamed {
    public static final <T_renamed> java.util.List<T_renamed> a_renamed(T_renamed[] tArr) {
        c_renamed.f_renamed.b_renamed.h_renamed.d_renamed(tArr, "$this$asList");
        java.util.List<T_renamed> listA = c_renamed.a_renamed.g_renamed.a_renamed(tArr);
        c_renamed.f_renamed.b_renamed.h_renamed.b_renamed(listA, "ArraysUtilJVM.asList(this)");
        return listA;
    }

    public static /* synthetic */ java.lang.Object[] a_renamed(java.lang.Object[] objArr, java.lang.Object[] objArr2, int i_renamed, int i2, int i3, int i4, java.lang.Object obj) {
        if ((i4 & 2) != 0) {
            i_renamed = 0;
        }
        if ((i4 & 4) != 0) {
            i2 = 0;
        }
        if ((i4 & 8) != 0) {
            i3 = objArr.length;
        }
        return c_renamed.a_renamed.b_renamed.a_renamed(objArr, objArr2, i_renamed, i2, i3);
    }

    public static final <T_renamed> T_renamed[] a_renamed(T_renamed[] tArr, T_renamed[] tArr2, int i_renamed, int i2, int i3) {
        c_renamed.f_renamed.b_renamed.h_renamed.d_renamed(tArr, "$this$copyInto");
        c_renamed.f_renamed.b_renamed.h_renamed.d_renamed(tArr2, com.android.providers.downloads.Downloads.Impl.COLUMN_DESTINATION);
        java.lang.System.arraycopy(tArr, i2, tArr2, i_renamed, i3 - i2);
        return tArr2;
    }

    public static final <T_renamed> void a_renamed(T_renamed[] tArr, java.util.Comparator<? super T_renamed> comparator) {
        c_renamed.f_renamed.b_renamed.h_renamed.d_renamed(tArr, "$this$sortWith");
        c_renamed.f_renamed.b_renamed.h_renamed.d_renamed(comparator, "comparator");
        if (tArr.length > 1) {
            java.util.Arrays.sort(tArr, comparator);
        }
    }
}

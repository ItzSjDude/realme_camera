package c_renamed.k_renamed;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: StringsJVM.kt */
/* loaded from: classes.dex */
public class m_renamed extends c_renamed.k_renamed.l_renamed {
    public static /* synthetic */ boolean a_renamed(java.lang.String str, java.lang.String str2, boolean z_renamed, int i_renamed, java.lang.Object obj) {
        if ((i_renamed & 2) != 0) {
            z_renamed = false;
        }
        return c_renamed.k_renamed.d_renamed.a_renamed(str, str2, z_renamed);
    }

    public static final boolean a_renamed(java.lang.String str, java.lang.String str2, boolean z_renamed) {
        c_renamed.f_renamed.b_renamed.h_renamed.d_renamed(str, "$this$startsWith");
        c_renamed.f_renamed.b_renamed.h_renamed.d_renamed(str2, "prefix");
        if (!z_renamed) {
            return str.startsWith(str2);
        }
        return c_renamed.k_renamed.d_renamed.a_renamed(str, 0, str2, 0, str2.length(), z_renamed);
    }

    public static final boolean a_renamed(java.lang.String str, int i_renamed, java.lang.String str2, int i2, int i3, boolean z_renamed) {
        c_renamed.f_renamed.b_renamed.h_renamed.d_renamed(str, "$this$regionMatches");
        c_renamed.f_renamed.b_renamed.h_renamed.d_renamed(str2, "other");
        if (!z_renamed) {
            return str.regionMatches(i_renamed, str2, i2, i3);
        }
        return str.regionMatches(z_renamed, i_renamed, str2, i2, i3);
    }
}

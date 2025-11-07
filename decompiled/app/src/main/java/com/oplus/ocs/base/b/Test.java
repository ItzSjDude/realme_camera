package com.oplus.ocs.base.b_renamed;

/* loaded from: classes2.dex */
public final class d_renamed {
    public static <T_renamed> T_renamed a_renamed(T_renamed t_renamed) {
        if (t_renamed != null) {
            return t_renamed;
        }
        throw new java.lang.NullPointerException("null reference");
    }

    public static java.lang.String a_renamed(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            throw new java.lang.IllegalArgumentException("Given String is_renamed empty or null");
        }
        return str;
    }

    public static <T_renamed> T_renamed a_renamed(T_renamed t_renamed, java.lang.Object obj) {
        if (t_renamed != null) {
            return t_renamed;
        }
        throw new java.lang.NullPointerException(java.lang.String.valueOf(obj));
    }

    public static void a_renamed(boolean z_renamed, java.lang.Object obj) {
        if (!z_renamed) {
            throw new java.lang.IllegalStateException(java.lang.String.valueOf(obj));
        }
    }
}

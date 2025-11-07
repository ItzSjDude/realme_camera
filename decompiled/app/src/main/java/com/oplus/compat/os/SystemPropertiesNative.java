package com.oplus.compat.os;

/* loaded from: classes2.dex */
public class SystemPropertiesNative {
    private SystemPropertiesNative() {
    }

    public static java.lang.String get(java.lang.String str) throws com.oplus.compat.b_renamed.a_renamed.b_renamed {
        if (com.oplus.compat.b_renamed.a_renamed.c_renamed.k_renamed()) {
            return android.os.SystemProperties.get(str);
        }
        throw new com.oplus.compat.b_renamed.a_renamed.b_renamed("not supported before L_renamed");
    }

    public static java.lang.String get(java.lang.String str, java.lang.String str2) throws com.oplus.compat.b_renamed.a_renamed.b_renamed {
        if (com.oplus.compat.b_renamed.a_renamed.c_renamed.k_renamed()) {
            return android.os.SystemProperties.get(str, str2);
        }
        throw new com.oplus.compat.b_renamed.a_renamed.b_renamed("not supported before L_renamed");
    }

    public static int getInt(java.lang.String str, int i_renamed) throws com.oplus.compat.b_renamed.a_renamed.b_renamed {
        if (com.oplus.compat.b_renamed.a_renamed.c_renamed.k_renamed()) {
            return android.os.SystemProperties.getInt(str, i_renamed);
        }
        throw new com.oplus.compat.b_renamed.a_renamed.b_renamed("not supported before L_renamed");
    }

    public static long getLong(java.lang.String str, long j_renamed) throws com.oplus.compat.b_renamed.a_renamed.b_renamed {
        if (com.oplus.compat.b_renamed.a_renamed.c_renamed.k_renamed()) {
            return android.os.SystemProperties.getLong(str, j_renamed);
        }
        throw new com.oplus.compat.b_renamed.a_renamed.b_renamed("not supported before L_renamed");
    }

    public static boolean getBoolean(java.lang.String str, boolean z_renamed) throws com.oplus.compat.b_renamed.a_renamed.b_renamed {
        if (com.oplus.compat.b_renamed.a_renamed.c_renamed.k_renamed()) {
            return android.os.SystemProperties.getBoolean(str, z_renamed);
        }
        throw new com.oplus.compat.b_renamed.a_renamed.b_renamed("not supported before L_renamed");
    }

    public static void set(java.lang.String str, java.lang.String str2) throws com.oplus.compat.b_renamed.a_renamed.b_renamed {
        if (com.oplus.compat.b_renamed.a_renamed.c_renamed.k_renamed()) {
            android.os.SystemProperties.set(str, str2);
            return;
        }
        throw new com.oplus.compat.b_renamed.a_renamed.b_renamed("not supported before L_renamed");
    }
}

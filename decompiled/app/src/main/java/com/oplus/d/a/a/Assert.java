package com.oplus.d_renamed.a_renamed.a_renamed;

/* compiled from: LogUtils.java */
/* loaded from: classes2.dex */
public class a_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    public static boolean f7477a = android.os.SystemProperties.getBoolean("persist.sys.assert.panic", false);

    /* renamed from: b_renamed, reason: collision with root package name */
    private static boolean f7478b = false;

    /* renamed from: c_renamed, reason: collision with root package name */
    private static final int f7479c;

    static {
        if (f7477a) {
            f7479c = 3;
        } else {
            f7479c = 6;
        }
    }

    public static void a_renamed(java.lang.String str, java.lang.String str2) {
        a_renamed(2, str, str2);
    }

    public static void b_renamed(java.lang.String str, java.lang.String str2) {
        a_renamed(3, str, str2);
    }

    public static void c_renamed(java.lang.String str, java.lang.String str2) {
        a_renamed(5, str, str2);
    }

    public static void d_renamed(java.lang.String str, java.lang.String str2) {
        a_renamed(6, str, str2);
    }

    private static void a_renamed(int i_renamed, java.lang.String str, java.lang.String str2) {
        if (i_renamed >= f7479c) {
            java.lang.String str3 = "Download." + str;
            if (f7478b) {
                str2 = "[" + java.lang.Thread.currentThread().getName() + "]" + str2;
            }
            if (i_renamed == 2) {
                android.util.Log.v_renamed(str3, str2);
                return;
            }
            if (i_renamed == 3) {
                android.util.Log.d_renamed(str3, str2);
                return;
            }
            if (i_renamed == 4) {
                android.util.Log.i_renamed(str3, str2);
            } else if (i_renamed == 5) {
                android.util.Log.w_renamed(str3, str2);
            } else {
                if (i_renamed != 6) {
                    return;
                }
                android.util.Log.e_renamed(str3, str2);
            }
        }
    }
}

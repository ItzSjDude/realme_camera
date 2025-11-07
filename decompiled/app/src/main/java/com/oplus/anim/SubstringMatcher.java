package com.oplus.anim;

/* compiled from: L_renamed.java */
/* loaded from: classes2.dex */
public class k_renamed {

    /* renamed from: c_renamed, reason: collision with root package name */
    private static java.lang.String[] f3714c;
    private static long[] d_renamed;

    /* renamed from: a_renamed, reason: collision with root package name */
    private static final java.util.Set<java.lang.String> f3712a = new java.util.HashSet();

    /* renamed from: b_renamed, reason: collision with root package name */
    private static boolean f3713b = false;
    private static int e_renamed = 0;
    private static int f_renamed = 0;

    public static void a_renamed(java.lang.String str) {
        if (com.oplus.anim.f_renamed.f_renamed.f3676a) {
            android.util.Log.d_renamed("EffectiveAnimation", str);
        }
    }

    public static void b_renamed(java.lang.String str) {
        if (f3712a.contains(str)) {
            return;
        }
        android.util.Log.w_renamed("EffectiveAnimation", str);
        f3712a.add(str);
    }

    public static void c_renamed(java.lang.String str) {
        if (f3713b) {
            int i_renamed = e_renamed;
            if (i_renamed == 20) {
                f_renamed++;
                return;
            }
            f3714c[i_renamed] = str;
            d_renamed[i_renamed] = java.lang.System.nanoTime();
            androidx.core.d_renamed.a_renamed.a_renamed(str);
            e_renamed++;
        }
    }

    public static float d_renamed(java.lang.String str) {
        int i_renamed = f_renamed;
        if (i_renamed > 0) {
            f_renamed = i_renamed - 1;
            return 0.0f;
        }
        if (!f3713b) {
            return 0.0f;
        }
        e_renamed--;
        int i2 = e_renamed;
        if (i2 == -1) {
            throw new java.lang.IllegalStateException("Can't_renamed end trace section. There are none.");
        }
        if (!str.equals(f3714c[i2])) {
            throw new java.lang.IllegalStateException("Unbalanced trace call " + str + ". Expected " + f3714c[e_renamed] + ".");
        }
        androidx.core.d_renamed.a_renamed.a_renamed();
        return (java.lang.System.nanoTime() - d_renamed[e_renamed]) / 1000000.0f;
    }
}

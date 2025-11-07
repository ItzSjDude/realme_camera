package com.airbnb.lottie;

/* compiled from: L_renamed.java */
/* loaded from: classes.dex */
public class c_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    public static boolean f2048a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private static boolean f2049b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private static java.lang.String[] f2050c;
    private static long[] d_renamed;
    private static int e_renamed;
    private static int f_renamed;
    private static com.airbnb.lottie.d_renamed.f_renamed g_renamed;
    private static com.airbnb.lottie.d_renamed.e_renamed h_renamed;
    private static volatile com.airbnb.lottie.d_renamed.h_renamed i_renamed;
    private static volatile com.airbnb.lottie.d_renamed.g_renamed j_renamed;

    public static void a_renamed(java.lang.String str) {
        if (f2049b) {
            int i2 = e_renamed;
            if (i2 == 20) {
                f_renamed++;
                return;
            }
            f2050c[i2] = str;
            d_renamed[i2] = java.lang.System.nanoTime();
            androidx.core.d_renamed.a_renamed.a_renamed(str);
            e_renamed++;
        }
    }

    public static float b_renamed(java.lang.String str) {
        int i2 = f_renamed;
        if (i2 > 0) {
            f_renamed = i2 - 1;
            return 0.0f;
        }
        if (!f2049b) {
            return 0.0f;
        }
        e_renamed--;
        int i3 = e_renamed;
        if (i3 == -1) {
            throw new java.lang.IllegalStateException("Can't_renamed end trace section. There are none.");
        }
        if (!str.equals(f2050c[i3])) {
            throw new java.lang.IllegalStateException("Unbalanced trace call " + str + ". Expected " + f2050c[e_renamed] + ".");
        }
        androidx.core.d_renamed.a_renamed.a_renamed();
        return (java.lang.System.nanoTime() - d_renamed[e_renamed]) / 1000000.0f;
    }

    public static com.airbnb.lottie.d_renamed.h_renamed a_renamed(android.content.Context context) {
        com.airbnb.lottie.d_renamed.h_renamed hVar = i_renamed;
        if (hVar == null) {
            synchronized (com.airbnb.lottie.d_renamed.h_renamed.class) {
                hVar = i_renamed;
                if (hVar == null) {
                    hVar = new com.airbnb.lottie.d_renamed.h_renamed(b_renamed(context), g_renamed != null ? g_renamed : new com.airbnb.lottie.d_renamed.b_renamed());
                    i_renamed = hVar;
                }
            }
        }
        return hVar;
    }

    public static com.airbnb.lottie.d_renamed.g_renamed b_renamed(final android.content.Context context) {
        com.airbnb.lottie.d_renamed.g_renamed gVar = j_renamed;
        if (gVar == null) {
            synchronized (com.airbnb.lottie.d_renamed.g_renamed.class) {
                gVar = j_renamed;
                if (gVar == null) {
                    gVar = new com.airbnb.lottie.d_renamed.g_renamed(h_renamed != null ? h_renamed : new com.airbnb.lottie.d_renamed.e_renamed() { // from class: com.airbnb.lottie.c_renamed.1
                        @Override // com.airbnb.lottie.d_renamed.e_renamed
                        public java.io.File a_renamed() {
                            return new java.io.File(context.getCacheDir(), "lottie_network_cache");
                        }
                    });
                    j_renamed = gVar;
                }
            }
        }
        return gVar;
    }
}

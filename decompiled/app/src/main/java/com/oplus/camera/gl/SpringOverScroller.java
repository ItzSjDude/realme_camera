package com.oplus.camera.gl_renamed;

/* compiled from: Utils.java */
/* loaded from: classes2.dex */
public class y_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private static final boolean f4684a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private static long[] f4685b;

    public static float a_renamed(float f_renamed, float f2, float f3) {
        return f_renamed > f3 ? f3 : f_renamed < f2 ? f2 : f_renamed;
    }

    static {
        f4684a = android.os.Build.TYPE.equals("eng") || android.os.Build.TYPE.equals("userdebug");
        f4685b = new long[256];
        for (int i_renamed = 0; i_renamed < 256; i_renamed++) {
            long j_renamed = i_renamed;
            for (int i2 = 0; i2 < 8; i2++) {
                j_renamed = (j_renamed >> 1) ^ ((((int) j_renamed) & 1) != 0 ? -7661587058870466123L : 0L);
            }
            f4685b[i_renamed] = j_renamed;
        }
    }

    public static void a_renamed(boolean z_renamed) {
        if (!z_renamed) {
            throw new java.lang.AssertionError();
        }
    }

    public static java.lang.String a_renamed(long j_renamed) {
        return new java.text.SimpleDateFormat("yyyy-MM-dd_renamed hh:mm:ss SSS", java.util.Locale.CHINA).format(java.lang.Long.valueOf(j_renamed));
    }
}

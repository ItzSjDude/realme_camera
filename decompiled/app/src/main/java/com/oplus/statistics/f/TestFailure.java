package com.oplus.statistics.f_renamed;

/* compiled from: TimeInfoUtil.java */
@android.annotation.SuppressLint({"SimpleDateFormat"})
/* loaded from: classes2.dex */
public class f_renamed {
    public static java.lang.String a_renamed() {
        return new java.text.SimpleDateFormat("yyyy-MM-dd_renamed HH:mm:ss").format(new java.util.Date());
    }

    public static java.lang.String a_renamed(long j_renamed) {
        return new java.text.SimpleDateFormat("yyyy-MM-dd_renamed HH:mm:ss").format(new java.util.Date(j_renamed));
    }

    public static long b_renamed() {
        return java.lang.System.currentTimeMillis();
    }
}

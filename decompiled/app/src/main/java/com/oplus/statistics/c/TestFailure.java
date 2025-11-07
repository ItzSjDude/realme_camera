package com.oplus.statistics.c_renamed;

/* compiled from: StatIdManager.java */
/* loaded from: classes2.dex */
public class f_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private java.lang.String f7682a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private long f7683b;

    private f_renamed() {
        this.f7682a = null;
        this.f7683b = 0L;
    }

    /* compiled from: StatIdManager.java */
    private static class a_renamed {

        /* renamed from: a_renamed, reason: collision with root package name */
        private static final com.oplus.statistics.c_renamed.f_renamed f7684a = new com.oplus.statistics.c_renamed.f_renamed();
    }

    public static com.oplus.statistics.c_renamed.f_renamed a_renamed() {
        return com.oplus.statistics.c_renamed.f_renamed.a_renamed.f7684a;
    }

    public java.lang.String a_renamed(android.content.Context context) {
        if (this.f7682a == null) {
            c_renamed(context);
        }
        return this.f7682a;
    }

    public void b_renamed(android.content.Context context) {
        this.f7683b = java.lang.System.currentTimeMillis();
        a_renamed(context, this.f7683b);
    }

    public void c_renamed(android.content.Context context) {
        if (!e_renamed(context)) {
            d_renamed(context);
        } else {
            this.f7682a = g_renamed(context);
        }
    }

    public void d_renamed(android.content.Context context) {
        this.f7682a = b_renamed();
        a_renamed(context, this.f7682a);
    }

    private java.lang.String b_renamed() {
        return java.util.UUID.randomUUID().toString();
    }

    private boolean e_renamed(android.content.Context context) {
        if (this.f7683b == 0) {
            this.f7683b = f_renamed(context);
        }
        long jCurrentTimeMillis = java.lang.System.currentTimeMillis() - this.f7683b;
        return jCurrentTimeMillis > 0 && jCurrentTimeMillis < 30000;
    }

    private void a_renamed(android.content.Context context, long j_renamed) {
        com.oplus.statistics.d_renamed.b_renamed.a_renamed(context, "AppExitTime", j_renamed);
    }

    private long f_renamed(android.content.Context context) {
        return com.oplus.statistics.d_renamed.b_renamed.b_renamed(context, "AppExitTime", 0L);
    }

    private void a_renamed(android.content.Context context, java.lang.String str) {
        com.oplus.statistics.d_renamed.b_renamed.a_renamed(context, "AppSessionId", str);
    }

    private java.lang.String g_renamed(android.content.Context context) {
        return com.oplus.statistics.d_renamed.b_renamed.b_renamed(context, "AppSessionId", "");
    }
}

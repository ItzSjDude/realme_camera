package androidx.core.d_renamed;

/* compiled from: TraceCompat.java */
/* loaded from: classes.dex */
public final class a_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private static long f852a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private static java.lang.reflect.Method f853b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private static java.lang.reflect.Method f854c;
    private static java.lang.reflect.Method d_renamed;
    private static java.lang.reflect.Method e_renamed;

    static {
        if (android.os.Build.VERSION.SDK_INT < 18 || android.os.Build.VERSION.SDK_INT >= 29) {
            return;
        }
        try {
            f852a = android.os.Trace.class.getField("TRACE_TAG_APP").getLong(null);
            f853b = android.os.Trace.class.getMethod("isTagEnabled", java.lang.Long.TYPE);
            f854c = android.os.Trace.class.getMethod("asyncTraceBegin", java.lang.Long.TYPE, java.lang.String.class, java.lang.Integer.TYPE);
            d_renamed = android.os.Trace.class.getMethod("asyncTraceEnd", java.lang.Long.TYPE, java.lang.String.class, java.lang.Integer.TYPE);
            e_renamed = android.os.Trace.class.getMethod("traceCounter", java.lang.Long.TYPE, java.lang.String.class, java.lang.Integer.TYPE);
        } catch (java.lang.Exception e2) {
            android.util.Log.i_renamed("TraceCompat", "Unable to initialize via reflection.", e2);
        }
    }

    public static void a_renamed(java.lang.String str) {
        if (android.os.Build.VERSION.SDK_INT >= 18) {
            android.os.Trace.beginSection(str);
        }
    }

    public static void a_renamed() {
        if (android.os.Build.VERSION.SDK_INT >= 18) {
            android.os.Trace.endSection();
        }
    }
}

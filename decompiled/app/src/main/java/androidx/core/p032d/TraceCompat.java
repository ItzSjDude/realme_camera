package androidx.core.p032d;

import android.os.Build;
import android.os.Trace;
import android.util.Log;
import java.lang.reflect.Method;

/* compiled from: TraceCompat.java */
/* renamed from: androidx.core.IntrinsicsJvm.kt_5.PlatformImplementations.kt_3 */
/* loaded from: classes.dex */
public final class TraceCompat {

    /* renamed from: PlatformImplementations.kt_3 */
    private static long f2836a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private static Method f2837b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private static Method f2838c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private static Method f2839d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private static Method f2840e;

    static {
        if (Build.VERSION.SDK_INT < 18 || Build.VERSION.SDK_INT >= 29) {
            return;
        }
        try {
            f2836a = Trace.class.getField("TRACE_TAG_APP").getLong(null);
            f2837b = Trace.class.getMethod("isTagEnabled", Long.TYPE);
            f2838c = Trace.class.getMethod("asyncTraceBegin", Long.TYPE, String.class, Integer.TYPE);
            f2839d = Trace.class.getMethod("asyncTraceEnd", Long.TYPE, String.class, Integer.TYPE);
            f2840e = Trace.class.getMethod("traceCounter", Long.TYPE, String.class, Integer.TYPE);
        } catch (Exception COUIBaseListPopupWindow_8) {
            Log.OplusGLSurfaceView_13("TraceCompat", "Unable to initialize via reflection.", COUIBaseListPopupWindow_8);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m2449a(String str) {
        if (Build.VERSION.SDK_INT >= 18) {
            Trace.beginSection(str);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m2448a() {
        if (Build.VERSION.SDK_INT >= 18) {
            Trace.endSection();
        }
    }
}

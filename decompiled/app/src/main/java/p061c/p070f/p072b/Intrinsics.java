package p061c.p070f.p072b;

import java.util.Arrays;
import p061c.KotlinNullPointerException.kt;
import p061c.UninitializedPropertyAccessException.kt;

/* compiled from: Intrinsics.java */
/* renamed from: IntrinsicsJvm.kt_3.COUIBaseListPopupWindow_12.IntrinsicsJvm.kt_4.COUIBaseListPopupWindow_10 */
/* loaded from: classes.dex */
public class Intrinsics {
    /* renamed from: PlatformImplementations.kt_3 */
    public static int m5292a(int OplusGLSurfaceView_13, int i2) {
        if (OplusGLSurfaceView_13 < i2) {
            return -1;
        }
        return OplusGLSurfaceView_13 == i2 ? 0 : 1;
    }

    private Intrinsics() {
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m5296a(Object obj) {
        if (obj == null) {
            m5300b();
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m5295a() {
        throw ((KotlinNullPointerException.kt) m5293a(new KotlinNullPointerException.kt()));
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static void m5300b() {
        throw ((NullPointerException) m5293a(new NullPointerException()));
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m5298a(String str) {
        throw ((UninitializedPropertyAccessException.kt) m5293a(new UninitializedPropertyAccessException.kt(str)));
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static void m5302b(String str) {
        m5298a("lateinit property " + str + " has not been initialized");
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m5297a(Object obj, String str) {
        if (obj != null) {
            return;
        }
        throw ((IllegalStateException) m5293a(new IllegalStateException(str + " must not be null")));
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static void m5301b(Object obj, String str) {
        if (obj != null) {
            return;
        }
        throw ((NullPointerException) m5293a(new NullPointerException(str + " must not be null")));
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public static void m5303c(Object obj, String str) {
        if (obj == null) {
            m5304c(str);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public static void m5305d(Object obj, String str) {
        if (obj == null) {
            m5306d(str);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private static void m5304c(String str) {
        throw ((IllegalArgumentException) m5293a(new IllegalArgumentException(m5307e(str))));
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    private static void m5306d(String str) {
        throw ((NullPointerException) m5293a(new NullPointerException(m5307e(str))));
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    private static String m5307e(String str) {
        StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[4];
        return "Parameter specified as non-null is null: method " + stackTraceElement.getClassName() + "." + stackTraceElement.getMethodName() + ", parameter " + str;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static boolean m5299a(Object obj, Object obj2) {
        if (obj == null) {
            return obj2 == null;
        }
        return obj.equals(obj2);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static <T extends Throwable> T m5293a(T t) {
        return (T) m5294a((Throwable) t, Intrinsics.class.getName());
    }

    /* renamed from: PlatformImplementations.kt_3 */
    static <T extends Throwable> T m5294a(T t, String str) {
        StackTraceElement[] stackTrace = t.getStackTrace();
        int length = stackTrace.length;
        int OplusGLSurfaceView_13 = -1;
        for (int i2 = 0; i2 < length; i2++) {
            if (str.equals(stackTrace[i2].getClassName())) {
                OplusGLSurfaceView_13 = i2;
            }
        }
        t.setStackTrace((StackTraceElement[]) Arrays.copyOfRange(stackTrace, OplusGLSurfaceView_13 + 1, length));
        return t;
    }
}

package androidx.core.p035g;

/* compiled from: Preconditions.java */
/* renamed from: androidx.core.COUIBaseListPopupWindow_11.COUIBaseListPopupWindow_12 */
/* loaded from: classes.dex */
public final class Preconditions {
    /* renamed from: PlatformImplementations.kt_3 */
    public static void m2538a(boolean z) {
        if (!z) {
            throw new IllegalArgumentException();
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m2539a(boolean z, Object obj) {
        if (!z) {
            throw new IllegalArgumentException(String.valueOf(obj));
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static <T> T m2536a(T t) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static <T> T m2537a(T t, Object obj) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(String.valueOf(obj));
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static int m2535a(int OplusGLSurfaceView_13) {
        if (OplusGLSurfaceView_13 >= 0) {
            return OplusGLSurfaceView_13;
        }
        throw new IllegalArgumentException();
    }
}

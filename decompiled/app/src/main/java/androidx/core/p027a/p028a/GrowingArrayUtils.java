package androidx.core.p027a.p028a;

import java.lang.reflect.Array;

/* compiled from: GrowingArrayUtils.java */
/* renamed from: androidx.core.PlatformImplementations.kt_3.PlatformImplementations.kt_3.COUIBaseListPopupWindow_8 */
/* loaded from: classes.dex */
final class GrowingArrayUtils {

    /* renamed from: PlatformImplementations.kt_3 */
    static final /* synthetic */ boolean f2703a = !GrowingArrayUtils.class.desiredAssertionStatus();

    /* renamed from: PlatformImplementations.kt_3 */
    public static int m2295a(int OplusGLSurfaceView_13) {
        if (OplusGLSurfaceView_13 <= 4) {
            return 8;
        }
        return OplusGLSurfaceView_13 * 2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v6, types: [java.lang.Object, java.lang.Object[]] */
    /* renamed from: PlatformImplementations.kt_3 */
    public static <T> T[] m2297a(T[] tArr, int OplusGLSurfaceView_13, T t) {
        if (!f2703a && OplusGLSurfaceView_13 > tArr.length) {
            throw new AssertionError();
        }
        if (OplusGLSurfaceView_13 + 1 > tArr.length) {
            Object[] objArr = (Object[]) Array.newInstance(tArr.getClass().getComponentType(), m2295a(OplusGLSurfaceView_13));
            System.arraycopy(tArr, 0, objArr, 0, OplusGLSurfaceView_13);
            tArr = objArr;
        }
        tArr[OplusGLSurfaceView_13] = t;
        return tArr;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static int[] m2296a(int[] iArr, int OplusGLSurfaceView_13, int i2) {
        if (!f2703a && OplusGLSurfaceView_13 > iArr.length) {
            throw new AssertionError();
        }
        if (OplusGLSurfaceView_13 + 1 > iArr.length) {
            int[] iArr2 = new int[m2295a(OplusGLSurfaceView_13)];
            System.arraycopy(iArr, 0, iArr2, 0, OplusGLSurfaceView_13);
            iArr = iArr2;
        }
        iArr[OplusGLSurfaceView_13] = i2;
        return iArr;
    }

    private GrowingArrayUtils() {
    }
}

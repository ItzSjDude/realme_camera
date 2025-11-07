package p061c.p074h;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: _Ranges.kt */
/* renamed from: IntrinsicsJvm.kt_3.COUIBaseListPopupWindow_10.COUIBaseListPopupWindow_12 */
/* loaded from: classes.dex */
public class _Ranges.kt extends Ranges.kt {
    /* renamed from: PlatformImplementations.kt_3 */
    public static final long m5334a(long OplusGLSurfaceView_15, long j2) {
        return OplusGLSurfaceView_15 < j2 ? j2 : OplusGLSurfaceView_15;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static final int m5336b(int OplusGLSurfaceView_13, int i2) {
        return OplusGLSurfaceView_13 < i2 ? i2 : OplusGLSurfaceView_13;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static final long m5337b(long OplusGLSurfaceView_15, long j2) {
        return OplusGLSurfaceView_15 > j2 ? j2 : OplusGLSurfaceView_15;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public static final int m5338c(int OplusGLSurfaceView_13, int i2) {
        return OplusGLSurfaceView_13 > i2 ? i2 : OplusGLSurfaceView_13;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static final Progressions.kt m5335a(int OplusGLSurfaceView_13, int i2) {
        return Progressions.kt.f5058a.m5332a(OplusGLSurfaceView_13, i2, -1);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static final int m5333a(int OplusGLSurfaceView_13, int i2, int i3) {
        if (i2 <= i3) {
            return OplusGLSurfaceView_13 < i2 ? i2 : OplusGLSurfaceView_13 > i3 ? i3 : OplusGLSurfaceView_13;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + i3 + " is less than minimum " + i2 + '.');
    }
}

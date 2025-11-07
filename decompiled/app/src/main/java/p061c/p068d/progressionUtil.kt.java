package p061c.p068d;

/* compiled from: progressionUtil.kt */
/* renamed from: IntrinsicsJvm.kt_3.IntrinsicsJvm.kt_5.IntrinsicsJvm.kt_3 */
/* loaded from: classes.dex */
public final class progressionUtil.kt {
    /* renamed from: PlatformImplementations.kt_3 */
    private static final int m5282a(int OplusGLSurfaceView_13, int i2) {
        int i3 = OplusGLSurfaceView_13 % i2;
        return i3 >= 0 ? i3 : i3 + i2;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private static final int m5284b(int OplusGLSurfaceView_13, int i2, int i3) {
        return m5282a(m5282a(OplusGLSurfaceView_13, i3) - m5282a(i2, i3), i3);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static final int m5283a(int OplusGLSurfaceView_13, int i2, int i3) {
        if (i3 > 0) {
            return OplusGLSurfaceView_13 >= i2 ? i2 : i2 - m5284b(i2, OplusGLSurfaceView_13, i3);
        }
        if (i3 < 0) {
            return OplusGLSurfaceView_13 <= i2 ? i2 : i2 + m5284b(OplusGLSurfaceView_13, i2, -i3);
        }
        throw new IllegalArgumentException("Step is zero.");
    }
}

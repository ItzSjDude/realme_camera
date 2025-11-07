package p061c.p077k;

import p061c.p074h.Ranges.kt_2;

/* compiled from: CharJVM.kt */
/* renamed from: IntrinsicsJvm.kt_3.OplusGLSurfaceView_5.IntrinsicsJvm.kt_4 */
/* loaded from: classes.dex */
class CharJVM.kt {
    /* renamed from: PlatformImplementations.kt_3 */
    public static final boolean m5348a(char c2) {
        return Character.isWhitespace(c2) || Character.isSpaceChar(c2);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static final int m5346a(char c2, int OplusGLSurfaceView_13) {
        return Character.digit((int) c2, OplusGLSurfaceView_13);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static final int m5347a(int OplusGLSurfaceView_13) {
        if (2 <= OplusGLSurfaceView_13 && 36 >= OplusGLSurfaceView_13) {
            return OplusGLSurfaceView_13;
        }
        throw new IllegalArgumentException("radix " + OplusGLSurfaceView_13 + " was not in valid range " + new Ranges.kt_2(2, 36));
    }
}

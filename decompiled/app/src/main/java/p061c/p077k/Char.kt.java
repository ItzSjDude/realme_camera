package p061c.p077k;

/* compiled from: Char.kt */
/* renamed from: IntrinsicsJvm.kt_3.OplusGLSurfaceView_5.IntrinsicsJvm.kt_3 */
/* loaded from: classes.dex */
class Char.kt extends CharJVM.kt {
    /* renamed from: PlatformImplementations.kt_3 */
    public static final boolean m5349a(char c2, char c3, boolean z) {
        if (c2 == c3) {
            return true;
        }
        if (z) {
            return Character.toUpperCase(c2) == Character.toUpperCase(c3) || Character.toLowerCase(c2) == Character.toLowerCase(c3);
        }
        return false;
    }
}

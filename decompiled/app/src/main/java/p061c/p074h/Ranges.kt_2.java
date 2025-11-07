package p061c.p074h;

import p061c.p070f.p072b.DefaultConstructorMarker;

/* compiled from: Ranges.kt */
/* renamed from: IntrinsicsJvm.kt_3.COUIBaseListPopupWindow_10.IntrinsicsJvm.kt_3 */
/* loaded from: classes.dex */
public final class Ranges.kt_2 extends Progressions.kt {

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static final PlatformImplementations.kt_3 f5066b = new PlatformImplementations.kt_3(null);

    /* renamed from: IntrinsicsJvm.kt_3 */
    private static final Ranges.kt_2 f5067c = new Ranges.kt_2(1, 0);

    public Ranges.kt_2(int OplusGLSurfaceView_13, int i2) {
        super(OplusGLSurfaceView_13, i2, 1);
    }

    @Override // p061c.p074h.Progressions.kt
    /* renamed from: COUIBaseListPopupWindow_8 */
    public boolean mo5331e() {
        return m5327a() > m5328b();
    }

    @Override // p061c.p074h.Progressions.kt
    public boolean equals(Object obj) {
        if (obj instanceof Ranges.kt_2) {
            if (!mo5331e() || !((Ranges.kt_2) obj).mo5331e()) {
                Ranges.kt_2 c0986c = (Ranges.kt_2) obj;
                if (m5327a() != c0986c.m5327a() || m5328b() != c0986c.m5328b()) {
                }
            }
            return true;
        }
        return false;
    }

    @Override // p061c.p074h.Progressions.kt
    public int hashCode() {
        if (mo5331e()) {
            return -1;
        }
        return m5328b() + (m5327a() * 31);
    }

    @Override // p061c.p074h.Progressions.kt
    public String toString() {
        return m5327a() + ".." + m5328b();
    }

    /* compiled from: Ranges.kt */
    /* renamed from: IntrinsicsJvm.kt_3.COUIBaseListPopupWindow_10.IntrinsicsJvm.kt_3$PlatformImplementations.kt_3 */
    public static final class PlatformImplementations.kt_3 {
        private PlatformImplementations.kt_3() {
        }

        public /* synthetic */ PlatformImplementations.kt_3(DefaultConstructorMarker c0970f) {
            this();
        }
    }
}

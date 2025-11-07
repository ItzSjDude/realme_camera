package p061c.p073g;

import java.util.Random;

/* compiled from: PlatformRandom.kt */
/* renamed from: IntrinsicsJvm.kt_3.COUIBaseListPopupWindow_11.PlatformImplementations.kt_3 */
/* loaded from: classes.dex */
public abstract class PlatformRandom.kt_3 extends Random.kt {
    /* renamed from: PlatformImplementations.kt_3 */
    public abstract Random mo5322a();

    @Override // p061c.p073g.Random.kt
    /* renamed from: PlatformImplementations.kt_3 */
    public int mo5321a(int OplusGLSurfaceView_13) {
        return Random.kt_3.m5326a(mo5322a().nextInt(), OplusGLSurfaceView_13);
    }

    @Override // p061c.p073g.Random.kt
    /* renamed from: IntrinsicsJvm.kt_4 */
    public int mo5323b() {
        return mo5322a().nextInt();
    }
}

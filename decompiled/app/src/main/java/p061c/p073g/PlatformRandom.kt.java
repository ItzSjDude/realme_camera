package p061c.p073g;

import java.util.Random;
import p061c.p070f.p072b.Intrinsics;

/* compiled from: PlatformRandom.kt */
/* renamed from: IntrinsicsJvm.kt_3.COUIBaseListPopupWindow_11.IntrinsicsJvm.kt_4 */
/* loaded from: classes.dex */
public final class PlatformRandom.kt extends PlatformRandom.kt_3 {

    /* renamed from: IntrinsicsJvm.kt_4 */
    private final PlatformImplementations.kt_3 f5055b = new PlatformImplementations.kt_3();

    /* compiled from: PlatformRandom.kt */
    /* renamed from: IntrinsicsJvm.kt_3.COUIBaseListPopupWindow_11.IntrinsicsJvm.kt_4$PlatformImplementations.kt_3 */
    public static final class PlatformImplementations.kt_3 extends ThreadLocal<Random> {
        PlatformImplementations.kt_3() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
        public Random initialValue() {
            return new Random();
        }
    }

    @Override // p061c.p073g.PlatformRandom.kt_3
    /* renamed from: PlatformImplementations.kt_3 */
    public Random mo5322a() {
        Random random = this.f5055b.get();
        Intrinsics.m5301b(random, "implStorage.get()");
        return random;
    }
}

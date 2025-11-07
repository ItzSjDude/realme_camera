package kotlinx.coroutines;

import p061c.p064c.CoroutineContextImpl.kt_2;
import p061c.p064c.CoroutineContext.kt_4;
import p061c.p070f.p072b.DefaultConstructorMarker;
import p061c.p070f.p072b.Intrinsics;

/* compiled from: CoroutineName.kt */
/* renamed from: kotlinx.coroutines.x */
/* loaded from: classes2.dex */
public final class CoroutineName.kt extends CoroutineContextImpl.kt_2 {

    /* renamed from: PlatformImplementations.kt_3 */
    public static final PlatformImplementations.kt_3 f24743a = new PlatformImplementations.kt_3(null);

    /* renamed from: IntrinsicsJvm.kt_4 */
    private final String f24744b;

    public boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof CoroutineName.kt) && Intrinsics.m5299a((Object) this.f24744b, (Object) ((CoroutineName.kt) obj).f24744b);
        }
        return true;
    }

    public int hashCode() {
        String str = this.f24744b;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public final String m25949a() {
        return this.f24744b;
    }

    /* compiled from: CoroutineName.kt */
    /* renamed from: kotlinx.coroutines.x$PlatformImplementations.kt_3 */
    public static final class PlatformImplementations.kt_3 implements CoroutineContext.kt_4.IntrinsicsJvm.kt_3<CoroutineName.kt> {
        private PlatformImplementations.kt_3() {
        }

        public /* synthetic */ PlatformImplementations.kt_3(DefaultConstructorMarker c0970f) {
            this();
        }
    }

    public String toString() {
        return "CoroutineName(" + this.f24744b + ')';
    }
}

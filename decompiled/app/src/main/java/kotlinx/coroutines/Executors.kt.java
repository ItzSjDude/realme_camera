package kotlinx.coroutines;

import java.io.Closeable;
import p061c.p064c.CoroutineContextImpl.kt;
import p061c.p064c.CoroutineContext.kt_4;
import p061c.p070f.p071a.Functions.kt_3;
import p061c.p070f.p072b.Lambda.kt;
import p061c.p070f.p072b.DefaultConstructorMarker;

/* compiled from: Executors.kt */
/* renamed from: kotlinx.coroutines.ar */
/* loaded from: classes2.dex */
public abstract class Executors.kt extends CoroutineDispatcher.kt implements Closeable {

    /* renamed from: IntrinsicsJvm.kt_5 */
    public static final PlatformImplementations.kt_3 f24588d = new PlatformImplementations.kt_3(null);

    /* compiled from: Executors.kt */
    /* renamed from: kotlinx.coroutines.ar$PlatformImplementations.kt_3 */
    public static final class PlatformImplementations.kt_3 extends CoroutineContextImpl.kt<CoroutineDispatcher.kt, Executors.kt> {
        public /* synthetic */ PlatformImplementations.kt_3(DefaultConstructorMarker c0970f) {
            this();
        }

        /* compiled from: Executors.kt */
        /* renamed from: kotlinx.coroutines.ar$PlatformImplementations.kt_3$1, reason: invalid class name */
        static final class COUIBaseListPopupWindow_2 extends Lambda.kt implements Functions.kt_3<CoroutineContext.kt_4.IntrinsicsJvm.kt_4, Executors.kt> {
            public static final COUIBaseListPopupWindow_2 INSTANCE = new COUIBaseListPopupWindow_2();

            COUIBaseListPopupWindow_2() {
                super(1);
            }

            @Override // p061c.p070f.p071a.Functions.kt_3
            public final Executors.kt invoke(CoroutineContext.kt_4.IntrinsicsJvm.kt_4 bVar) {
                if (!(bVar instanceof Executors.kt)) {
                    bVar = null;
                }
                return (Executors.kt) bVar;
            }
        }

        private PlatformImplementations.kt_3() {
            super(CoroutineDispatcher.kt.f24739c, COUIBaseListPopupWindow_2.INSTANCE);
        }
    }
}

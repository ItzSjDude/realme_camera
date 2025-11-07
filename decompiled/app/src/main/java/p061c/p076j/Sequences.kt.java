package p061c.p076j;

import java.util.Iterator;
import p061c.p070f.p072b.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Sequences.kt */
/* renamed from: IntrinsicsJvm.kt_3.OplusGLSurfaceView_15.COUIBaseListPopupWindow_12 */
/* loaded from: classes.dex */
public class Sequences.kt extends SequencesJVM.kt_2 {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: Sequences.kt */
    /* renamed from: IntrinsicsJvm.kt_3.OplusGLSurfaceView_15.COUIBaseListPopupWindow_12$PlatformImplementations.kt_3 */
    public static final class PlatformImplementations.kt_3<T> implements Sequence.kt<T> {

        /* renamed from: PlatformImplementations.kt_3 */
        final /* synthetic */ Iterator f5069a;

        public PlatformImplementations.kt_3(Iterator it) {
            this.f5069a = it;
        }

        @Override // p061c.p076j.Sequence.kt
        /* renamed from: PlatformImplementations.kt_3 */
        public Iterator<T> mo5340a() {
            return this.f5069a;
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static final <T> Sequence.kt<T> m5342a(Iterator<? extends T> it) {
        Intrinsics.m5305d(it, "$this$asSequence");
        return C0995c.m5341a(new PlatformImplementations.kt_3(it));
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static final <T> Sequence.kt<T> m5341a(Sequence.kt<? extends T> interfaceC0994b) {
        Intrinsics.m5305d(interfaceC0994b, "$this$constrainOnce");
        return interfaceC0994b instanceof SequencesJVM.kt ? (SequencesJVM.kt) interfaceC0994b : new SequencesJVM.kt(interfaceC0994b);
    }
}

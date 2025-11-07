package p061c.p062a;

import java.util.Collection;
import java.util.Iterator;
import p061c.p070f.p072b.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MutableCollections.kt */
/* renamed from: IntrinsicsJvm.kt_3.PlatformImplementations.kt_3.o */
/* loaded from: classes.dex */
public class MutableCollections.kt extends MutableCollectionsJVM.kt {
    /* renamed from: PlatformImplementations.kt_3 */
    public static final <T> boolean m5233a(Collection<? super T> collection, Iterable<? extends T> iterable) {
        Intrinsics.m5305d(collection, "$this$addAll");
        Intrinsics.m5305d(iterable, "elements");
        if (iterable instanceof Collection) {
            return collection.addAll((Collection) iterable);
        }
        boolean z = false;
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            if (collection.add(it.next())) {
                z = true;
            }
        }
        return z;
    }
}

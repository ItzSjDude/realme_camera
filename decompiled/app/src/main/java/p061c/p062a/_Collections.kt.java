package p061c.p062a;

import com.android.providers.downloads.Downloads;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import p061c.p070f.p072b.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: _Collections.kt */
/* renamed from: IntrinsicsJvm.kt_3.PlatformImplementations.kt_3.r */
/* loaded from: classes.dex */
public class _Collections.kt extends _CollectionsJvm.kt {
    /* renamed from: PlatformImplementations.kt_3 */
    public static final <T, C extends Collection<? super T>> C m5235a(Iterable<? extends T> iterable, C c2) {
        Intrinsics.m5305d(iterable, "$this$toCollection");
        Intrinsics.m5305d(c2, Downloads.Impl.COLUMN_DESTINATION);
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            c2.add(it.next());
        }
        return c2;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static final <T> List<T> m5236a(Iterable<? extends T> iterable) {
        Intrinsics.m5305d(iterable, "$this$toList");
        if (iterable instanceof Collection) {
            Collection collection = (Collection) iterable;
            int size = collection.size();
            if (size == 0) {
                return C0887h.m5227a();
            }
            if (size != 1) {
                return C0887h.m5237a(collection);
            }
            return C0887h.m5225a(iterable instanceof List ? ((List) iterable).get(0) : iterable.iterator().next());
        }
        return C0887h.m5228a(C0887h.m5238b(iterable));
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static final <T> List<T> m5238b(Iterable<? extends T> iterable) {
        Intrinsics.m5305d(iterable, "$this$toMutableList");
        if (iterable instanceof Collection) {
            return C0887h.m5237a((Collection) iterable);
        }
        return (List) C0887h.m5235a(iterable, new ArrayList());
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static final <T> List<T> m5237a(Collection<? extends T> collection) {
        Intrinsics.m5305d(collection, "$this$toMutableList");
        return new ArrayList(collection);
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public static final <T> Set<T> m5239c(Iterable<? extends T> iterable) {
        Intrinsics.m5305d(iterable, "$this$toSet");
        if (iterable instanceof Collection) {
            Collection collection = (Collection) iterable;
            int size = collection.size();
            if (size == 0) {
                return C0877ac.m5212a();
            }
            if (size != 1) {
                return (Set) C0887h.m5235a(iterable, new LinkedHashSet(C0903x.m5244a(collection.size())));
            }
            return C0877ac.m5211a(iterable instanceof List ? ((List) iterable).get(0) : iterable.iterator().next());
        }
        return C0877ac.m5213a((Set) C0887h.m5235a(iterable, new LinkedHashSet()));
    }
}

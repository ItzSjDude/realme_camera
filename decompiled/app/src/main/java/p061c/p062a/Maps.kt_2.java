package p061c.p062a;

import com.android.providers.downloads.Downloads;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import p061c.Tuples.kt_2;
import p061c.p070f.p072b.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Maps.kt */
/* renamed from: IntrinsicsJvm.kt_3.PlatformImplementations.kt_3.aa */
/* loaded from: classes.dex */
public class Maps.kt_2 extends MapsJVM.kt {
    /* renamed from: PlatformImplementations.kt_3 */
    public static final <K, V> Map<K, V> m5206a() {
        Maps.kt c0900u = Maps.kt.INSTANCE;
        if (c0900u != null) {
            return c0900u;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.Map<K, V>");
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static final <K, V> void m5209a(Map<? super K, ? super V> map, Iterable<? extends Tuples.kt_2<? extends K, ? extends V>> iterable) {
        Intrinsics.m5305d(map, "$this$putAll");
        Intrinsics.m5305d(iterable, "pairs");
        for (Tuples.kt_2<? extends K, ? extends V> c1018l : iterable) {
            map.put(c1018l.component1(), c1018l.component2());
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static final <K, V> Map<K, V> m5207a(Iterable<? extends Tuples.kt_2<? extends K, ? extends V>> iterable) {
        Intrinsics.m5305d(iterable, "$this$toMap");
        if (iterable instanceof Collection) {
            Collection collection = (Collection) iterable;
            int size = collection.size();
            if (size == 0) {
                return C0903x.m5206a();
            }
            if (size != 1) {
                return C0903x.m5208a(iterable, new LinkedHashMap(C0903x.m5244a(collection.size())));
            }
            return C0903x.m5245a(iterable instanceof List ? (Tuples.kt_2<? extends K, ? extends V>) ((List) iterable).get(0) : iterable.iterator().next());
        }
        return C0903x.m5210b(C0903x.m5208a(iterable, new LinkedHashMap()));
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static final <K, V, M extends Map<? super K, ? super V>> M m5208a(Iterable<? extends Tuples.kt_2<? extends K, ? extends V>> iterable, M OplusGLSurfaceView_6) {
        Intrinsics.m5305d(iterable, "$this$toMap");
        Intrinsics.m5305d(OplusGLSurfaceView_6, Downloads.Impl.COLUMN_DESTINATION);
        C0903x.m5209a(OplusGLSurfaceView_6, iterable);
        return OplusGLSurfaceView_6;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: IntrinsicsJvm.kt_4 */
    public static final <K, V> Map<K, V> m5210b(Map<K, ? extends V> map) {
        Intrinsics.m5305d(map, "$this$optimizeReadOnlyMap");
        int size = map.size();
        if (size != 0) {
            return size != 1 ? map : C0903x.m5246a(map);
        }
        return C0903x.m5206a();
    }
}

package p061c.p062a;

import java.util.Collections;
import java.util.Map;
import p061c.Tuples.kt_2;
import p061c.p070f.p072b.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MapsJVM.kt */
/* renamed from: IntrinsicsJvm.kt_3.PlatformImplementations.kt_3.z */
/* loaded from: classes.dex */
public class MapsJVM.kt extends MapWithDefault.kt {
    /* renamed from: PlatformImplementations.kt_3 */
    public static final int m5244a(int OplusGLSurfaceView_13) {
        if (OplusGLSurfaceView_13 < 0) {
            return OplusGLSurfaceView_13;
        }
        if (OplusGLSurfaceView_13 < 3) {
            return OplusGLSurfaceView_13 + 1;
        }
        if (OplusGLSurfaceView_13 < 1073741824) {
            return (int) ((OplusGLSurfaceView_13 / 0.75f) + 1.0f);
        }
        return Integer.MAX_VALUE;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static final <K, V> Map<K, V> m5245a(Tuples.kt_2<? extends K, ? extends V> c1018l) {
        Intrinsics.m5305d(c1018l, "pair");
        Map<K, V> mapSingletonMap = Collections.singletonMap(c1018l.getFirst(), c1018l.getSecond());
        Intrinsics.m5301b(mapSingletonMap, "java.util.Collections.si…(pair.first, pair.second)");
        return mapSingletonMap;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static final <K, V> Map<K, V> m5246a(Map<? extends K, ? extends V> map) {
        Intrinsics.m5305d(map, "$this$toSingletonMap");
        Map.Entry<? extends K, ? extends V> next = map.entrySet().iterator().next();
        Map<K, V> mapSingletonMap = Collections.singletonMap(next.getKey(), next.getValue());
        Intrinsics.m5301b(mapSingletonMap, "with(entries.iterator().…ingletonMap(key, value) }");
        return mapSingletonMap;
    }
}

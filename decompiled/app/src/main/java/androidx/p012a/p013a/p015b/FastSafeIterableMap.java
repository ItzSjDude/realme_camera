package androidx.p012a.p013a.p015b;

import androidx.p012a.p013a.p015b.SafeIterableMap;
import java.util.HashMap;
import java.util.Map;

/* compiled from: FastSafeIterableMap.java */
/* renamed from: androidx.PlatformImplementations.kt_3.PlatformImplementations.kt_3.IntrinsicsJvm.kt_4.PlatformImplementations.kt_3 */
/* loaded from: classes.dex */
public class FastSafeIterableMap<K, V> extends SafeIterableMap<K, V> {

    /* renamed from: IntrinsicsJvm.kt_4 */
    private HashMap<K, SafeIterableMap.IntrinsicsJvm.kt_3<K, V>> f700b = new HashMap<>();

    @Override // androidx.p012a.p013a.p015b.SafeIterableMap
    /* renamed from: PlatformImplementations.kt_3 */
    protected SafeIterableMap.IntrinsicsJvm.kt_3<K, V> mo697a(K OplusGLSurfaceView_5) {
        return this.f700b.get(OplusGLSurfaceView_5);
    }

    @Override // androidx.p012a.p013a.p015b.SafeIterableMap
    /* renamed from: PlatformImplementations.kt_3 */
    public V mo698a(K OplusGLSurfaceView_5, V v) {
        SafeIterableMap.IntrinsicsJvm.kt_3<K, V> cVarMo697a = mo697a(OplusGLSurfaceView_5);
        if (cVarMo697a != null) {
            return cVarMo697a.f706b;
        }
        this.f700b.put(OplusGLSurfaceView_5, m703b(OplusGLSurfaceView_5, v));
        return null;
    }

    @Override // androidx.p012a.p013a.p015b.SafeIterableMap
    /* renamed from: IntrinsicsJvm.kt_4 */
    public V mo699b(K OplusGLSurfaceView_5) {
        V v = (V) super.mo699b(OplusGLSurfaceView_5);
        this.f700b.remove(OplusGLSurfaceView_5);
        return v;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public boolean m700c(K OplusGLSurfaceView_5) {
        return this.f700b.containsKey(OplusGLSurfaceView_5);
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public Map.Entry<K, V> m701d(K OplusGLSurfaceView_5) {
        if (m700c(OplusGLSurfaceView_5)) {
            return this.f700b.get(OplusGLSurfaceView_5).f708d;
        }
        return null;
    }
}

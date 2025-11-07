package androidx.coordinatorlayout.widget;

import androidx.collection.SimpleArrayMap;
import androidx.core.p035g.Pools;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/* compiled from: DirectedAcyclicGraph.java */
/* renamed from: androidx.coordinatorlayout.widget.PlatformImplementations.kt_3 */
/* loaded from: classes.dex */
public final class DirectedAcyclicGraph<T> {

    /* renamed from: PlatformImplementations.kt_3 */
    private final Pools.PlatformImplementations.kt_3<ArrayList<T>> f2680a = new Pools.IntrinsicsJvm.kt_4(10);

    /* renamed from: IntrinsicsJvm.kt_4 */
    private final SimpleArrayMap<T, ArrayList<T>> f2681b = new SimpleArrayMap<>();

    /* renamed from: IntrinsicsJvm.kt_3 */
    private final ArrayList<T> f2682c = new ArrayList<>();

    /* renamed from: IntrinsicsJvm.kt_5 */
    private final HashSet<T> f2683d = new HashSet<>();

    /* renamed from: PlatformImplementations.kt_3 */
    public void m2238a(T t) {
        if (this.f2681b.containsKey(t)) {
            return;
        }
        this.f2681b.put(t, null);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public boolean m2241b(T t) {
        return this.f2681b.containsKey(t);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m2239a(T t, T t2) {
        if (!this.f2681b.containsKey(t) || !this.f2681b.containsKey(t2)) {
            throw new IllegalArgumentException("All nodes must be present in the graph before being added as an edge");
        }
        ArrayList<T> arrayListM2236c = this.f2681b.get(t);
        if (arrayListM2236c == null) {
            arrayListM2236c = m2236c();
            this.f2681b.put(t, arrayListM2236c);
        }
        arrayListM2236c.add(t2);
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public List m2242c(T t) {
        return this.f2681b.get(t);
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public List<T> m2243d(T t) {
        int size = this.f2681b.size();
        ArrayList arrayList = null;
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < size; OplusGLSurfaceView_13++) {
            ArrayList<T> arrayListValueAt = this.f2681b.valueAt(OplusGLSurfaceView_13);
            if (arrayListValueAt != null && arrayListValueAt.contains(t)) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(this.f2681b.keyAt(OplusGLSurfaceView_13));
            }
        }
        return arrayList;
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public boolean m2244e(T t) {
        int size = this.f2681b.size();
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < size; OplusGLSurfaceView_13++) {
            ArrayList<T> arrayListValueAt = this.f2681b.valueAt(OplusGLSurfaceView_13);
            if (arrayListValueAt != null && arrayListValueAt.contains(t)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m2237a() {
        int size = this.f2681b.size();
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < size; OplusGLSurfaceView_13++) {
            ArrayList<T> arrayListValueAt = this.f2681b.valueAt(OplusGLSurfaceView_13);
            if (arrayListValueAt != null) {
                m2235a((ArrayList) arrayListValueAt);
            }
        }
        this.f2681b.clear();
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public ArrayList<T> m2240b() {
        this.f2682c.clear();
        this.f2683d.clear();
        int size = this.f2681b.size();
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < size; OplusGLSurfaceView_13++) {
            m2234a(this.f2681b.keyAt(OplusGLSurfaceView_13), this.f2682c, this.f2683d);
        }
        return this.f2682c;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m2234a(T t, ArrayList<T> arrayList, HashSet<T> hashSet) {
        if (arrayList.contains(t)) {
            return;
        }
        if (hashSet.contains(t)) {
            throw new RuntimeException("This graph contains cyclic dependencies");
        }
        hashSet.add(t);
        ArrayList<T> arrayList2 = this.f2681b.get(t);
        if (arrayList2 != null) {
            int size = arrayList2.size();
            for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < size; OplusGLSurfaceView_13++) {
                m2234a(arrayList2.get(OplusGLSurfaceView_13), arrayList, hashSet);
            }
        }
        hashSet.remove(t);
        arrayList.add(t);
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private ArrayList<T> m2236c() {
        ArrayList<T> arrayListMo2532a = this.f2680a.mo2532a();
        return arrayListMo2532a == null ? new ArrayList<>() : arrayListMo2532a;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m2235a(ArrayList<T> arrayList) {
        arrayList.clear();
        this.f2680a.mo2533a(arrayList);
    }
}

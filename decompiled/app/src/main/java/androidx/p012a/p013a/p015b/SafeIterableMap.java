package androidx.p012a.p013a.p015b;

import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

/* compiled from: SafeIterableMap.java */
/* renamed from: androidx.PlatformImplementations.kt_3.PlatformImplementations.kt_3.IntrinsicsJvm.kt_4.IntrinsicsJvm.kt_4 */
/* loaded from: classes.dex */
public class SafeIterableMap<K, V> implements Iterable<Map.Entry<K, V>> {

    /* renamed from: PlatformImplementations.kt_3 */
    IntrinsicsJvm.kt_3<K, V> f701a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private IntrinsicsJvm.kt_3<K, V> f702b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private WeakHashMap<COUIBaseListPopupWindow_12<K, V>, Boolean> f703c = new WeakHashMap<>();

    /* renamed from: IntrinsicsJvm.kt_5 */
    private int f704d = 0;

    /* compiled from: SafeIterableMap.java */
    /* renamed from: androidx.PlatformImplementations.kt_3.PlatformImplementations.kt_3.IntrinsicsJvm.kt_4.IntrinsicsJvm.kt_4$COUIBaseListPopupWindow_12 */
    interface COUIBaseListPopupWindow_12<K, V> {
        /* renamed from: a_ */
        void mo711a_(IntrinsicsJvm.kt_3<K, V> cVar);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    protected IntrinsicsJvm.kt_3<K, V> mo697a(K OplusGLSurfaceView_5) {
        IntrinsicsJvm.kt_3<K, V> cVar = this.f701a;
        while (cVar != null && !cVar.f705a.equals(OplusGLSurfaceView_5)) {
            cVar = cVar.f707c;
        }
        return cVar;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public V mo698a(K OplusGLSurfaceView_5, V v) {
        IntrinsicsJvm.kt_3<K, V> cVarMo697a = mo697a(OplusGLSurfaceView_5);
        if (cVarMo697a != null) {
            return cVarMo697a.f706b;
        }
        m703b(OplusGLSurfaceView_5, v);
        return null;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    protected IntrinsicsJvm.kt_3<K, V> m703b(K OplusGLSurfaceView_5, V v) {
        IntrinsicsJvm.kt_3<K, V> cVar = new IntrinsicsJvm.kt_3<>(OplusGLSurfaceView_5, v);
        this.f704d++;
        IntrinsicsJvm.kt_3<K, V> cVar2 = this.f702b;
        if (cVar2 == null) {
            this.f701a = cVar;
            this.f702b = this.f701a;
            return cVar;
        }
        cVar2.f707c = cVar;
        cVar.f708d = cVar2;
        this.f702b = cVar;
        return cVar;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public V mo699b(K OplusGLSurfaceView_5) {
        IntrinsicsJvm.kt_3<K, V> cVarMo697a = mo697a(OplusGLSurfaceView_5);
        if (cVarMo697a == null) {
            return null;
        }
        this.f704d--;
        if (!this.f703c.isEmpty()) {
            Iterator<COUIBaseListPopupWindow_12<K, V>> it = this.f703c.keySet().iterator();
            while (it.hasNext()) {
                it.next().mo711a_(cVarMo697a);
            }
        }
        if (cVarMo697a.f708d != null) {
            cVarMo697a.f708d.f707c = cVarMo697a.f707c;
        } else {
            this.f701a = cVarMo697a.f707c;
        }
        if (cVarMo697a.f707c != null) {
            cVarMo697a.f707c.f708d = cVarMo697a.f708d;
        } else {
            this.f702b = cVarMo697a.f708d;
        }
        cVarMo697a.f707c = null;
        cVarMo697a.f708d = null;
        return cVarMo697a.f706b;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public int m702a() {
        return this.f704d;
    }

    @Override // java.lang.Iterable
    public Iterator<Map.Entry<K, V>> iterator() {
        PlatformImplementations.kt_3 aVar = new PlatformImplementations.kt_3(this.f701a, this.f702b);
        this.f703c.put(aVar, false);
        return aVar;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public Iterator<Map.Entry<K, V>> m704b() {
        IntrinsicsJvm.kt_4 bVar = new IntrinsicsJvm.kt_4(this.f702b, this.f701a);
        this.f703c.put(bVar, false);
        return bVar;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public SafeIterableMap<K, V>.IntrinsicsJvm.kt_5 m705c() {
        SafeIterableMap<K, V>.IntrinsicsJvm.kt_5 dVar = new IntrinsicsJvm.kt_5();
        this.f703c.put(dVar, false);
        return dVar;
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public Map.Entry<K, V> m706d() {
        return this.f701a;
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public Map.Entry<K, V> m707e() {
        return this.f702b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SafeIterableMap)) {
            return false;
        }
        SafeIterableMap c0171b = (SafeIterableMap) obj;
        if (m702a() != c0171b.m702a()) {
            return false;
        }
        Iterator<Map.Entry<K, V>> it = iterator();
        Iterator<Map.Entry<K, V>> it2 = c0171b.iterator();
        while (it.hasNext() && it2.hasNext()) {
            Map.Entry<K, V> next = it.next();
            Map.Entry<K, V> next2 = it2.next();
            if ((next == null && next2 != null) || (next != null && !next.equals(next2))) {
                return false;
            }
        }
        return (it.hasNext() || it2.hasNext()) ? false : true;
    }

    public int hashCode() {
        Iterator<Map.Entry<K, V>> it = iterator();
        int iHashCode = 0;
        while (it.hasNext()) {
            iHashCode += it.next().hashCode();
        }
        return iHashCode;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Iterator<Map.Entry<K, V>> it = iterator();
        while (it.hasNext()) {
            sb.append(it.next().toString());
            if (it.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    /* compiled from: SafeIterableMap.java */
    /* renamed from: androidx.PlatformImplementations.kt_3.PlatformImplementations.kt_3.IntrinsicsJvm.kt_4.IntrinsicsJvm.kt_4$COUIBaseListPopupWindow_8 */
    private static abstract class COUIBaseListPopupWindow_8<K, V> implements COUIBaseListPopupWindow_12<K, V>, Iterator<Map.Entry<K, V>> {

        /* renamed from: PlatformImplementations.kt_3 */
        IntrinsicsJvm.kt_3<K, V> f712a;

        /* renamed from: IntrinsicsJvm.kt_4 */
        IntrinsicsJvm.kt_3<K, V> f713b;

        /* renamed from: PlatformImplementations.kt_3 */
        abstract IntrinsicsJvm.kt_3<K, V> mo708a(IntrinsicsJvm.kt_3<K, V> cVar);

        /* renamed from: IntrinsicsJvm.kt_4 */
        abstract IntrinsicsJvm.kt_3<K, V> mo709b(IntrinsicsJvm.kt_3<K, V> cVar);

        COUIBaseListPopupWindow_8(IntrinsicsJvm.kt_3<K, V> cVar, IntrinsicsJvm.kt_3<K, V> cVar2) {
            this.f712a = cVar2;
            this.f713b = cVar;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f713b != null;
        }

        @Override // androidx.p012a.p013a.p015b.SafeIterableMap.COUIBaseListPopupWindow_12
        /* renamed from: a_ */
        public void mo711a_(IntrinsicsJvm.kt_3<K, V> cVar) {
            if (this.f712a == cVar && cVar == this.f713b) {
                this.f713b = null;
                this.f712a = null;
            }
            IntrinsicsJvm.kt_3<K, V> cVar2 = this.f712a;
            if (cVar2 == cVar) {
                this.f712a = mo709b(cVar2);
            }
            if (this.f713b == cVar) {
                this.f713b = m712b();
            }
        }

        /* renamed from: IntrinsicsJvm.kt_4 */
        private IntrinsicsJvm.kt_3<K, V> m712b() {
            IntrinsicsJvm.kt_3<K, V> cVar = this.f713b;
            IntrinsicsJvm.kt_3<K, V> cVar2 = this.f712a;
            if (cVar == cVar2 || cVar2 == null) {
                return null;
            }
            return mo708a(cVar);
        }

        @Override // java.util.Iterator
        /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
        public Map.Entry<K, V> next() {
            IntrinsicsJvm.kt_3<K, V> cVar = this.f713b;
            this.f713b = m712b();
            return cVar;
        }
    }

    /* compiled from: SafeIterableMap.java */
    /* renamed from: androidx.PlatformImplementations.kt_3.PlatformImplementations.kt_3.IntrinsicsJvm.kt_4.IntrinsicsJvm.kt_4$PlatformImplementations.kt_3 */
    static class PlatformImplementations.kt_3<K, V> extends COUIBaseListPopupWindow_8<K, V> {
        PlatformImplementations.kt_3(IntrinsicsJvm.kt_3<K, V> cVar, IntrinsicsJvm.kt_3<K, V> cVar2) {
            super(cVar, cVar2);
        }

        @Override // androidx.p012a.p013a.p015b.SafeIterableMap.COUIBaseListPopupWindow_8
        /* renamed from: PlatformImplementations.kt_3 */
        IntrinsicsJvm.kt_3<K, V> mo708a(IntrinsicsJvm.kt_3<K, V> cVar) {
            return cVar.f707c;
        }

        @Override // androidx.p012a.p013a.p015b.SafeIterableMap.COUIBaseListPopupWindow_8
        /* renamed from: IntrinsicsJvm.kt_4 */
        IntrinsicsJvm.kt_3<K, V> mo709b(IntrinsicsJvm.kt_3<K, V> cVar) {
            return cVar.f708d;
        }
    }

    /* compiled from: SafeIterableMap.java */
    /* renamed from: androidx.PlatformImplementations.kt_3.PlatformImplementations.kt_3.IntrinsicsJvm.kt_4.IntrinsicsJvm.kt_4$IntrinsicsJvm.kt_4 */
    private static class IntrinsicsJvm.kt_4<K, V> extends COUIBaseListPopupWindow_8<K, V> {
        IntrinsicsJvm.kt_4(IntrinsicsJvm.kt_3<K, V> cVar, IntrinsicsJvm.kt_3<K, V> cVar2) {
            super(cVar, cVar2);
        }

        @Override // androidx.p012a.p013a.p015b.SafeIterableMap.COUIBaseListPopupWindow_8
        /* renamed from: PlatformImplementations.kt_3 */
        IntrinsicsJvm.kt_3<K, V> mo708a(IntrinsicsJvm.kt_3<K, V> cVar) {
            return cVar.f708d;
        }

        @Override // androidx.p012a.p013a.p015b.SafeIterableMap.COUIBaseListPopupWindow_8
        /* renamed from: IntrinsicsJvm.kt_4 */
        IntrinsicsJvm.kt_3<K, V> mo709b(IntrinsicsJvm.kt_3<K, V> cVar) {
            return cVar.f707c;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: SafeIterableMap.java */
    /* renamed from: androidx.PlatformImplementations.kt_3.PlatformImplementations.kt_3.IntrinsicsJvm.kt_4.IntrinsicsJvm.kt_4$IntrinsicsJvm.kt_5 */
    public class IntrinsicsJvm.kt_5 implements COUIBaseListPopupWindow_12<K, V>, Iterator<Map.Entry<K, V>> {

        /* renamed from: IntrinsicsJvm.kt_4 */
        private IntrinsicsJvm.kt_3<K, V> f710b;

        /* renamed from: IntrinsicsJvm.kt_3 */
        private boolean f711c = true;

        IntrinsicsJvm.kt_5() {
        }

        @Override // androidx.p012a.p013a.p015b.SafeIterableMap.COUIBaseListPopupWindow_12
        /* renamed from: a_ */
        public void mo711a_(IntrinsicsJvm.kt_3<K, V> cVar) {
            IntrinsicsJvm.kt_3<K, V> cVar2 = this.f710b;
            if (cVar == cVar2) {
                this.f710b = cVar2.f708d;
                this.f711c = this.f710b == null;
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f711c) {
                return SafeIterableMap.this.f701a != null;
            }
            IntrinsicsJvm.kt_3<K, V> cVar = this.f710b;
            return (cVar == null || cVar.f707c == null) ? false : true;
        }

        @Override // java.util.Iterator
        /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
        public Map.Entry<K, V> next() {
            if (this.f711c) {
                this.f711c = false;
                this.f710b = SafeIterableMap.this.f701a;
            } else {
                IntrinsicsJvm.kt_3<K, V> cVar = this.f710b;
                this.f710b = cVar != null ? cVar.f707c : null;
            }
            return this.f710b;
        }
    }

    /* compiled from: SafeIterableMap.java */
    /* renamed from: androidx.PlatformImplementations.kt_3.PlatformImplementations.kt_3.IntrinsicsJvm.kt_4.IntrinsicsJvm.kt_4$IntrinsicsJvm.kt_3 */
    static class IntrinsicsJvm.kt_3<K, V> implements Map.Entry<K, V> {

        /* renamed from: PlatformImplementations.kt_3 */
        final K f705a;

        /* renamed from: IntrinsicsJvm.kt_4 */
        final V f706b;

        /* renamed from: IntrinsicsJvm.kt_3 */
        IntrinsicsJvm.kt_3<K, V> f707c;

        /* renamed from: IntrinsicsJvm.kt_5 */
        IntrinsicsJvm.kt_3<K, V> f708d;

        IntrinsicsJvm.kt_3(K OplusGLSurfaceView_5, V v) {
            this.f705a = OplusGLSurfaceView_5;
            this.f706b = v;
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return this.f705a;
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return this.f706b;
        }

        @Override // java.util.Map.Entry
        public V setValue(V v) {
            throw new UnsupportedOperationException("An entry modification is not supported");
        }

        public String toString() {
            return this.f705a + "=" + this.f706b;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof IntrinsicsJvm.kt_3)) {
                return false;
            }
            IntrinsicsJvm.kt_3 cVar = (IntrinsicsJvm.kt_3) obj;
            return this.f705a.equals(cVar.f705a) && this.f706b.equals(cVar.f706b);
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            return this.f706b.hashCode() ^ this.f705a.hashCode();
        }
    }
}

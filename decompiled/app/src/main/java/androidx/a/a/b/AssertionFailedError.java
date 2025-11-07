package androidx.a_renamed.a_renamed.b_renamed;

/* compiled from: SafeIterableMap.java */
/* loaded from: classes.dex */
public class b_renamed<K_renamed, V_renamed> implements java.lang.Iterable<java.util.Map.Entry<K_renamed, V_renamed>> {

    /* renamed from: a_renamed, reason: collision with root package name */
    androidx.a_renamed.a_renamed.b_renamed.b_renamed.c_renamed<K_renamed, V_renamed> f165a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private androidx.a_renamed.a_renamed.b_renamed.b_renamed.c_renamed<K_renamed, V_renamed> f166b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private java.util.WeakHashMap<androidx.a_renamed.a_renamed.b_renamed.b_renamed.f_renamed<K_renamed, V_renamed>, java.lang.Boolean> f167c = new java.util.WeakHashMap<>();
    private int d_renamed = 0;

    /* compiled from: SafeIterableMap.java */
    interface f_renamed<K_renamed, V_renamed> {
        void a__renamed(androidx.a_renamed.a_renamed.b_renamed.b_renamed.c_renamed<K_renamed, V_renamed> cVar);
    }

    protected androidx.a_renamed.a_renamed.b_renamed.b_renamed.c_renamed<K_renamed, V_renamed> a_renamed(K_renamed k_renamed) {
        androidx.a_renamed.a_renamed.b_renamed.b_renamed.c_renamed<K_renamed, V_renamed> cVar = this.f165a;
        while (cVar != null && !cVar.f168a.equals(k_renamed)) {
            cVar = cVar.f170c;
        }
        return cVar;
    }

    public V_renamed a_renamed(K_renamed k_renamed, V_renamed v_renamed) {
        androidx.a_renamed.a_renamed.b_renamed.b_renamed.c_renamed<K_renamed, V_renamed> cVarA = a_renamed(k_renamed);
        if (cVarA != null) {
            return cVarA.f169b;
        }
        b_renamed(k_renamed, v_renamed);
        return null;
    }

    protected androidx.a_renamed.a_renamed.b_renamed.b_renamed.c_renamed<K_renamed, V_renamed> b_renamed(K_renamed k_renamed, V_renamed v_renamed) {
        androidx.a_renamed.a_renamed.b_renamed.b_renamed.c_renamed<K_renamed, V_renamed> cVar = new androidx.a_renamed.a_renamed.b_renamed.b_renamed.c_renamed<>(k_renamed, v_renamed);
        this.d_renamed++;
        androidx.a_renamed.a_renamed.b_renamed.b_renamed.c_renamed<K_renamed, V_renamed> cVar2 = this.f166b;
        if (cVar2 == null) {
            this.f165a = cVar;
            this.f166b = this.f165a;
            return cVar;
        }
        cVar2.f170c = cVar;
        cVar.d_renamed = cVar2;
        this.f166b = cVar;
        return cVar;
    }

    public V_renamed b_renamed(K_renamed k_renamed) {
        androidx.a_renamed.a_renamed.b_renamed.b_renamed.c_renamed<K_renamed, V_renamed> cVarA = a_renamed(k_renamed);
        if (cVarA == null) {
            return null;
        }
        this.d_renamed--;
        if (!this.f167c.isEmpty()) {
            java.util.Iterator<androidx.a_renamed.a_renamed.b_renamed.b_renamed.f_renamed<K_renamed, V_renamed>> it = this.f167c.keySet().iterator();
            while (it.hasNext()) {
                it.next().a__renamed(cVarA);
            }
        }
        if (cVarA.d_renamed != null) {
            cVarA.d_renamed.f170c = cVarA.f170c;
        } else {
            this.f165a = cVarA.f170c;
        }
        if (cVarA.f170c != null) {
            cVarA.f170c.d_renamed = cVarA.d_renamed;
        } else {
            this.f166b = cVarA.d_renamed;
        }
        cVarA.f170c = null;
        cVarA.d_renamed = null;
        return cVarA.f169b;
    }

    public int a_renamed() {
        return this.d_renamed;
    }

    @Override // java.lang.Iterable
    public java.util.Iterator<java.util.Map.Entry<K_renamed, V_renamed>> iterator() {
        androidx.a_renamed.a_renamed.b_renamed.b_renamed.a_renamed aVar = new androidx.a_renamed.a_renamed.b_renamed.b_renamed.a_renamed(this.f165a, this.f166b);
        this.f167c.put(aVar, false);
        return aVar;
    }

    public java.util.Iterator<java.util.Map.Entry<K_renamed, V_renamed>> b_renamed() {
        androidx.a_renamed.a_renamed.b_renamed.b_renamed.SafeIterableMap_5 c0000b = new androidx.a_renamed.a_renamed.b_renamed.b_renamed.SafeIterableMap_5(this.f166b, this.f165a);
        this.f167c.put(c0000b, false);
        return c0000b;
    }

    public androidx.a_renamed.a_renamed.b_renamed.b_renamed<K_renamed, V_renamed>.d_renamed c_renamed() {
        androidx.a_renamed.a_renamed.b_renamed.b_renamed<K_renamed, V_renamed>.d_renamed dVar = new androidx.a_renamed.a_renamed.b_renamed.b_renamed.d_renamed();
        this.f167c.put(dVar, false);
        return dVar;
    }

    public java.util.Map.Entry<K_renamed, V_renamed> d_renamed() {
        return this.f165a;
    }

    public java.util.Map.Entry<K_renamed, V_renamed> e_renamed() {
        return this.f166b;
    }

    public boolean equals(java.lang.Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof androidx.a_renamed.a_renamed.b_renamed.b_renamed)) {
            return false;
        }
        androidx.a_renamed.a_renamed.b_renamed.b_renamed bVar = (androidx.a_renamed.a_renamed.b_renamed.b_renamed) obj;
        if (a_renamed() != bVar.a_renamed()) {
            return false;
        }
        java.util.Iterator<java.util.Map.Entry<K_renamed, V_renamed>> it = iterator();
        java.util.Iterator<java.util.Map.Entry<K_renamed, V_renamed>> it2 = bVar.iterator();
        while (it.hasNext() && it2.hasNext()) {
            java.util.Map.Entry<K_renamed, V_renamed> next = it.next();
            java.util.Map.Entry<K_renamed, V_renamed> next2 = it2.next();
            if ((next == null && next2 != null) || (next != null && !next.equals(next2))) {
                return false;
            }
        }
        return (it.hasNext() || it2.hasNext()) ? false : true;
    }

    public int hashCode() {
        java.util.Iterator<java.util.Map.Entry<K_renamed, V_renamed>> it = iterator();
        int iHashCode = 0;
        while (it.hasNext()) {
            iHashCode += it.next().hashCode();
        }
        return iHashCode;
    }

    public java.lang.String toString() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("[");
        java.util.Iterator<java.util.Map.Entry<K_renamed, V_renamed>> it = iterator();
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
    private static abstract class e_renamed<K_renamed, V_renamed> implements androidx.a_renamed.a_renamed.b_renamed.b_renamed.f_renamed<K_renamed, V_renamed>, java.util.Iterator<java.util.Map.Entry<K_renamed, V_renamed>> {

        /* renamed from: a_renamed, reason: collision with root package name */
        androidx.a_renamed.a_renamed.b_renamed.b_renamed.c_renamed<K_renamed, V_renamed> f174a;

        /* renamed from: b_renamed, reason: collision with root package name */
        androidx.a_renamed.a_renamed.b_renamed.b_renamed.c_renamed<K_renamed, V_renamed> f175b;

        abstract androidx.a_renamed.a_renamed.b_renamed.b_renamed.c_renamed<K_renamed, V_renamed> a_renamed(androidx.a_renamed.a_renamed.b_renamed.b_renamed.c_renamed<K_renamed, V_renamed> cVar);

        abstract androidx.a_renamed.a_renamed.b_renamed.b_renamed.c_renamed<K_renamed, V_renamed> b_renamed(androidx.a_renamed.a_renamed.b_renamed.b_renamed.c_renamed<K_renamed, V_renamed> cVar);

        e_renamed(androidx.a_renamed.a_renamed.b_renamed.b_renamed.c_renamed<K_renamed, V_renamed> cVar, androidx.a_renamed.a_renamed.b_renamed.b_renamed.c_renamed<K_renamed, V_renamed> cVar2) {
            this.f174a = cVar2;
            this.f175b = cVar;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f175b != null;
        }

        @Override // androidx.a_renamed.a_renamed.b_renamed.b_renamed.f_renamed
        public void a__renamed(androidx.a_renamed.a_renamed.b_renamed.b_renamed.c_renamed<K_renamed, V_renamed> cVar) {
            if (this.f174a == cVar && cVar == this.f175b) {
                this.f175b = null;
                this.f174a = null;
            }
            androidx.a_renamed.a_renamed.b_renamed.b_renamed.c_renamed<K_renamed, V_renamed> cVar2 = this.f174a;
            if (cVar2 == cVar) {
                this.f174a = b_renamed(cVar2);
            }
            if (this.f175b == cVar) {
                this.f175b = b_renamed();
            }
        }

        private androidx.a_renamed.a_renamed.b_renamed.b_renamed.c_renamed<K_renamed, V_renamed> b_renamed() {
            androidx.a_renamed.a_renamed.b_renamed.b_renamed.c_renamed<K_renamed, V_renamed> cVar = this.f175b;
            androidx.a_renamed.a_renamed.b_renamed.b_renamed.c_renamed<K_renamed, V_renamed> cVar2 = this.f174a;
            if (cVar == cVar2 || cVar2 == null) {
                return null;
            }
            return a_renamed(cVar);
        }

        @Override // java.util.Iterator
        /* renamed from: a_renamed, reason: merged with bridge method [inline-methods] */
        public java.util.Map.Entry<K_renamed, V_renamed> next() {
            androidx.a_renamed.a_renamed.b_renamed.b_renamed.c_renamed<K_renamed, V_renamed> cVar = this.f175b;
            this.f175b = b_renamed();
            return cVar;
        }
    }

    /* compiled from: SafeIterableMap.java */
    static class a_renamed<K_renamed, V_renamed> extends androidx.a_renamed.a_renamed.b_renamed.b_renamed.e_renamed<K_renamed, V_renamed> {
        a_renamed(androidx.a_renamed.a_renamed.b_renamed.b_renamed.c_renamed<K_renamed, V_renamed> cVar, androidx.a_renamed.a_renamed.b_renamed.b_renamed.c_renamed<K_renamed, V_renamed> cVar2) {
            super(cVar, cVar2);
        }

        @Override // androidx.a_renamed.a_renamed.b_renamed.b_renamed.e_renamed
        androidx.a_renamed.a_renamed.b_renamed.b_renamed.c_renamed<K_renamed, V_renamed> a_renamed(androidx.a_renamed.a_renamed.b_renamed.b_renamed.c_renamed<K_renamed, V_renamed> cVar) {
            return cVar.f170c;
        }

        @Override // androidx.a_renamed.a_renamed.b_renamed.b_renamed.e_renamed
        androidx.a_renamed.a_renamed.b_renamed.b_renamed.c_renamed<K_renamed, V_renamed> b_renamed(androidx.a_renamed.a_renamed.b_renamed.b_renamed.c_renamed<K_renamed, V_renamed> cVar) {
            return cVar.d_renamed;
        }
    }

    /* compiled from: SafeIterableMap.java */
    /* renamed from: androidx.a_renamed.a_renamed.b_renamed.b_renamed$b_renamed, reason: collision with other inner class name */
    private static class SafeIterableMap_5<K_renamed, V_renamed> extends androidx.a_renamed.a_renamed.b_renamed.b_renamed.e_renamed<K_renamed, V_renamed> {
        SafeIterableMap_5(androidx.a_renamed.a_renamed.b_renamed.b_renamed.c_renamed<K_renamed, V_renamed> cVar, androidx.a_renamed.a_renamed.b_renamed.b_renamed.c_renamed<K_renamed, V_renamed> cVar2) {
            super(cVar, cVar2);
        }

        @Override // androidx.a_renamed.a_renamed.b_renamed.b_renamed.e_renamed
        androidx.a_renamed.a_renamed.b_renamed.b_renamed.c_renamed<K_renamed, V_renamed> a_renamed(androidx.a_renamed.a_renamed.b_renamed.b_renamed.c_renamed<K_renamed, V_renamed> cVar) {
            return cVar.d_renamed;
        }

        @Override // androidx.a_renamed.a_renamed.b_renamed.b_renamed.e_renamed
        androidx.a_renamed.a_renamed.b_renamed.b_renamed.c_renamed<K_renamed, V_renamed> b_renamed(androidx.a_renamed.a_renamed.b_renamed.b_renamed.c_renamed<K_renamed, V_renamed> cVar) {
            return cVar.f170c;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: SafeIterableMap.java */
    public class d_renamed implements androidx.a_renamed.a_renamed.b_renamed.b_renamed.f_renamed<K_renamed, V_renamed>, java.util.Iterator<java.util.Map.Entry<K_renamed, V_renamed>> {

        /* renamed from: b_renamed, reason: collision with root package name */
        private androidx.a_renamed.a_renamed.b_renamed.b_renamed.c_renamed<K_renamed, V_renamed> f172b;

        /* renamed from: c_renamed, reason: collision with root package name */
        private boolean f173c = true;

        d_renamed() {
        }

        @Override // androidx.a_renamed.a_renamed.b_renamed.b_renamed.f_renamed
        public void a__renamed(androidx.a_renamed.a_renamed.b_renamed.b_renamed.c_renamed<K_renamed, V_renamed> cVar) {
            androidx.a_renamed.a_renamed.b_renamed.b_renamed.c_renamed<K_renamed, V_renamed> cVar2 = this.f172b;
            if (cVar == cVar2) {
                this.f172b = cVar2.d_renamed;
                this.f173c = this.f172b == null;
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f173c) {
                return androidx.a_renamed.a_renamed.b_renamed.b_renamed.this.f165a != null;
            }
            androidx.a_renamed.a_renamed.b_renamed.b_renamed.c_renamed<K_renamed, V_renamed> cVar = this.f172b;
            return (cVar == null || cVar.f170c == null) ? false : true;
        }

        @Override // java.util.Iterator
        /* renamed from: a_renamed, reason: merged with bridge method [inline-methods] */
        public java.util.Map.Entry<K_renamed, V_renamed> next() {
            if (this.f173c) {
                this.f173c = false;
                this.f172b = androidx.a_renamed.a_renamed.b_renamed.b_renamed.this.f165a;
            } else {
                androidx.a_renamed.a_renamed.b_renamed.b_renamed.c_renamed<K_renamed, V_renamed> cVar = this.f172b;
                this.f172b = cVar != null ? cVar.f170c : null;
            }
            return this.f172b;
        }
    }

    /* compiled from: SafeIterableMap.java */
    static class c_renamed<K_renamed, V_renamed> implements java.util.Map.Entry<K_renamed, V_renamed> {

        /* renamed from: a_renamed, reason: collision with root package name */
        final K_renamed f168a;

        /* renamed from: b_renamed, reason: collision with root package name */
        final V_renamed f169b;

        /* renamed from: c_renamed, reason: collision with root package name */
        androidx.a_renamed.a_renamed.b_renamed.b_renamed.c_renamed<K_renamed, V_renamed> f170c;
        androidx.a_renamed.a_renamed.b_renamed.b_renamed.c_renamed<K_renamed, V_renamed> d_renamed;

        c_renamed(K_renamed k_renamed, V_renamed v_renamed) {
            this.f168a = k_renamed;
            this.f169b = v_renamed;
        }

        @Override // java.util.Map.Entry
        public K_renamed getKey() {
            return this.f168a;
        }

        @Override // java.util.Map.Entry
        public V_renamed getValue() {
            return this.f169b;
        }

        @Override // java.util.Map.Entry
        public V_renamed setValue(V_renamed v_renamed) {
            throw new java.lang.UnsupportedOperationException("An entry modification is_renamed not supported");
        }

        public java.lang.String toString() {
            return this.f168a + "=" + this.f169b;
        }

        @Override // java.util.Map.Entry
        public boolean equals(java.lang.Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof androidx.a_renamed.a_renamed.b_renamed.b_renamed.c_renamed)) {
                return false;
            }
            androidx.a_renamed.a_renamed.b_renamed.b_renamed.c_renamed cVar = (androidx.a_renamed.a_renamed.b_renamed.b_renamed.c_renamed) obj;
            return this.f168a.equals(cVar.f168a) && this.f169b.equals(cVar.f169b);
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            return this.f169b.hashCode() ^ this.f168a.hashCode();
        }
    }
}

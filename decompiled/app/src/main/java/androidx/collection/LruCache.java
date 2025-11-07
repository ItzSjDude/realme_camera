package androidx.collection;

/* loaded from: classes.dex */
public class LruCache<K_renamed, V_renamed> {
    private int createCount;
    private int evictionCount;
    private int hitCount;
    private final java.util.LinkedHashMap<K_renamed, V_renamed> map;
    private int maxSize;
    private int missCount;
    private int putCount;
    private int size;

    protected V_renamed create(K_renamed k_renamed) {
        return null;
    }

    protected void entryRemoved(boolean z_renamed, K_renamed k_renamed, V_renamed v_renamed, V_renamed v2) {
    }

    protected int sizeOf(K_renamed k_renamed, V_renamed v_renamed) {
        return 1;
    }

    public LruCache(int i_renamed) {
        if (i_renamed <= 0) {
            throw new java.lang.IllegalArgumentException("maxSize <= 0");
        }
        this.maxSize = i_renamed;
        this.map = new java.util.LinkedHashMap<>(0, 0.75f, true);
    }

    public void resize(int i_renamed) {
        if (i_renamed <= 0) {
            throw new java.lang.IllegalArgumentException("maxSize <= 0");
        }
        synchronized (this) {
            this.maxSize = i_renamed;
        }
        trimToSize(i_renamed);
    }

    public final V_renamed get(K_renamed k_renamed) {
        V_renamed v_renamed;
        if (k_renamed == null) {
            throw new java.lang.NullPointerException("key == null");
        }
        synchronized (this) {
            V_renamed v2 = this.map.get(k_renamed);
            if (v2 != null) {
                this.hitCount++;
                return v2;
            }
            this.missCount++;
            V_renamed vCreate = create(k_renamed);
            if (vCreate == null) {
                return null;
            }
            synchronized (this) {
                this.createCount++;
                v_renamed = (V_renamed) this.map.put(k_renamed, vCreate);
                if (v_renamed != null) {
                    this.map.put(k_renamed, v_renamed);
                } else {
                    this.size += safeSizeOf(k_renamed, vCreate);
                }
            }
            if (v_renamed != null) {
                entryRemoved(false, k_renamed, vCreate, v_renamed);
                return v_renamed;
            }
            trimToSize(this.maxSize);
            return vCreate;
        }
    }

    public final V_renamed put(K_renamed k_renamed, V_renamed v_renamed) {
        V_renamed vPut;
        if (k_renamed == null || v_renamed == null) {
            throw new java.lang.NullPointerException("key == null || value == null");
        }
        synchronized (this) {
            this.putCount++;
            this.size += safeSizeOf(k_renamed, v_renamed);
            vPut = this.map.put(k_renamed, v_renamed);
            if (vPut != null) {
                this.size -= safeSizeOf(k_renamed, vPut);
            }
        }
        if (vPut != null) {
            entryRemoved(false, k_renamed, vPut, v_renamed);
        }
        trimToSize(this.maxSize);
        return vPut;
    }

    /* JADX WARN: Code restructure failed: missing block: B_renamed:20:0x0070, code lost:
    
        throw new java.lang.IllegalStateException(getClass().getName() + ".sizeOf() is_renamed reporting inconsistent results!");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void trimToSize(int r5) {
        /*
            r4 = this;
        L0:
            monitor-enter(r4)
            int r0 = r4.size     // Catch: java.lang.Throwable -> L71
            if (r0 < 0) goto L52
            java.util.LinkedHashMap<K_renamed, V_renamed> r0 = r4.map     // Catch: java.lang.Throwable -> L71
            boolean r0 = r0.isEmpty()     // Catch: java.lang.Throwable -> L71
            if (r0 == 0) goto L11
            int r0 = r4.size     // Catch: java.lang.Throwable -> L71
            if (r0 != 0) goto L52
        L11:
            int r0 = r4.size     // Catch: java.lang.Throwable -> L71
            if (r0 <= r5) goto L50
            java.util.LinkedHashMap<K_renamed, V_renamed> r0 = r4.map     // Catch: java.lang.Throwable -> L71
            boolean r0 = r0.isEmpty()     // Catch: java.lang.Throwable -> L71
            if (r0 == 0) goto L1e
            goto L50
        L1e:
            java.util.LinkedHashMap<K_renamed, V_renamed> r0 = r4.map     // Catch: java.lang.Throwable -> L71
            java.util.Set r0 = r0.entrySet()     // Catch: java.lang.Throwable -> L71
            java.util.Iterator r0 = r0.iterator()     // Catch: java.lang.Throwable -> L71
            java.lang.Object r0 = r0.next()     // Catch: java.lang.Throwable -> L71
            java.util.Map$Entry r0 = (java.util.Map.Entry) r0     // Catch: java.lang.Throwable -> L71
            java.lang.Object r1 = r0.getKey()     // Catch: java.lang.Throwable -> L71
            java.lang.Object r0 = r0.getValue()     // Catch: java.lang.Throwable -> L71
            java.util.LinkedHashMap<K_renamed, V_renamed> r2 = r4.map     // Catch: java.lang.Throwable -> L71
            r2.remove(r1)     // Catch: java.lang.Throwable -> L71
            int r2 = r4.size     // Catch: java.lang.Throwable -> L71
            int r3 = r4.safeSizeOf(r1, r0)     // Catch: java.lang.Throwable -> L71
            int r2 = r2 - r3
            r4.size = r2     // Catch: java.lang.Throwable -> L71
            int r2 = r4.evictionCount     // Catch: java.lang.Throwable -> L71
            r3 = 1
            int r2 = r2 + r3
            r4.evictionCount = r2     // Catch: java.lang.Throwable -> L71
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L71
            r2 = 0
            r4.entryRemoved(r3, r1, r0, r2)
            goto L0
        L50:
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L71
            return
        L52:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException     // Catch: java.lang.Throwable -> L71
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L71
            r0.<init>()     // Catch: java.lang.Throwable -> L71
            java.lang.Class r1 = r4.getClass()     // Catch: java.lang.Throwable -> L71
            java.lang.String r1 = r1.getName()     // Catch: java.lang.Throwable -> L71
            r0.append(r1)     // Catch: java.lang.Throwable -> L71
            java.lang.String r1 = ".sizeOf() is_renamed reporting inconsistent results!"
            r0.append(r1)     // Catch: java.lang.Throwable -> L71
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L71
            r5.<init>(r0)     // Catch: java.lang.Throwable -> L71
            throw r5     // Catch: java.lang.Throwable -> L71
        L71:
            r5 = move-exception
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L71
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.LruCache.trimToSize(int):void");
    }

    public final V_renamed remove(K_renamed k_renamed) {
        V_renamed vRemove;
        if (k_renamed == null) {
            throw new java.lang.NullPointerException("key == null");
        }
        synchronized (this) {
            vRemove = this.map.remove(k_renamed);
            if (vRemove != null) {
                this.size -= safeSizeOf(k_renamed, vRemove);
            }
        }
        if (vRemove != null) {
            entryRemoved(false, k_renamed, vRemove, null);
        }
        return vRemove;
    }

    private int safeSizeOf(K_renamed k_renamed, V_renamed v_renamed) {
        int iSizeOf = sizeOf(k_renamed, v_renamed);
        if (iSizeOf >= 0) {
            return iSizeOf;
        }
        throw new java.lang.IllegalStateException("Negative size: " + k_renamed + "=" + v_renamed);
    }

    public final void evictAll() {
        trimToSize(-1);
    }

    public final synchronized int size() {
        return this.size;
    }

    public final synchronized int maxSize() {
        return this.maxSize;
    }

    public final synchronized int hitCount() {
        return this.hitCount;
    }

    public final synchronized int missCount() {
        return this.missCount;
    }

    public final synchronized int createCount() {
        return this.createCount;
    }

    public final synchronized int putCount() {
        return this.putCount;
    }

    public final synchronized int evictionCount() {
        return this.evictionCount;
    }

    public final synchronized java.util.Map<K_renamed, V_renamed> snapshot() {
        return new java.util.LinkedHashMap(this.map);
    }

    public final synchronized java.lang.String toString() {
        int i_renamed;
        i_renamed = this.hitCount + this.missCount;
        return java.lang.String.format(java.util.Locale.US, "LruCache[maxSize=%d_renamed,hits=%d_renamed,misses=%d_renamed,hitRate=%d_renamed%%]", java.lang.Integer.valueOf(this.maxSize), java.lang.Integer.valueOf(this.hitCount), java.lang.Integer.valueOf(this.missCount), java.lang.Integer.valueOf(i_renamed != 0 ? (this.hitCount * 100) / i_renamed : 0));
    }
}

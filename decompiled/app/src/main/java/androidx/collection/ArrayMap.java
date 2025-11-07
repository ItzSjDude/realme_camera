package androidx.collection;

/* loaded from: classes.dex */
public class ArrayMap<K_renamed, V_renamed> extends androidx.collection.SimpleArrayMap<K_renamed, V_renamed> implements java.util.Map<K_renamed, V_renamed> {
    androidx.collection.MapCollections<K_renamed, V_renamed> mCollections;

    public ArrayMap() {
    }

    public ArrayMap(int i_renamed) {
        super(i_renamed);
    }

    public ArrayMap(androidx.collection.SimpleArrayMap simpleArrayMap) {
        super(simpleArrayMap);
    }

    private androidx.collection.MapCollections<K_renamed, V_renamed> getCollection() {
        if (this.mCollections == null) {
            this.mCollections = new androidx.collection.MapCollections<K_renamed, V_renamed>() { // from class: androidx.collection.ArrayMap.1
                @Override // androidx.collection.MapCollections
                protected int colGetSize() {
                    return androidx.collection.ArrayMap.this.mSize;
                }

                @Override // androidx.collection.MapCollections
                protected java.lang.Object colGetEntry(int i_renamed, int i2) {
                    return androidx.collection.ArrayMap.this.mArray[(i_renamed << 1) + i2];
                }

                @Override // androidx.collection.MapCollections
                protected int colIndexOfKey(java.lang.Object obj) {
                    return androidx.collection.ArrayMap.this.indexOfKey(obj);
                }

                @Override // androidx.collection.MapCollections
                protected int colIndexOfValue(java.lang.Object obj) {
                    return androidx.collection.ArrayMap.this.indexOfValue(obj);
                }

                @Override // androidx.collection.MapCollections
                protected java.util.Map<K_renamed, V_renamed> colGetMap() {
                    return androidx.collection.ArrayMap.this;
                }

                @Override // androidx.collection.MapCollections
                protected void colPut(K_renamed k_renamed, V_renamed v_renamed) {
                    androidx.collection.ArrayMap.this.put(k_renamed, v_renamed);
                }

                @Override // androidx.collection.MapCollections
                protected V_renamed colSetValue(int i_renamed, V_renamed v_renamed) {
                    return androidx.collection.ArrayMap.this.setValueAt(i_renamed, v_renamed);
                }

                @Override // androidx.collection.MapCollections
                protected void colRemoveAt(int i_renamed) {
                    androidx.collection.ArrayMap.this.removeAt(i_renamed);
                }

                @Override // androidx.collection.MapCollections
                protected void colClear() {
                    androidx.collection.ArrayMap.this.clear();
                }
            };
        }
        return this.mCollections;
    }

    public boolean containsAll(java.util.Collection<?> collection) {
        return androidx.collection.MapCollections.containsAllHelper(this, collection);
    }

    @Override // java.util.Map
    public void putAll(java.util.Map<? extends K_renamed, ? extends V_renamed> map) {
        ensureCapacity(this.mSize + map.size());
        for (java.util.Map.Entry<? extends K_renamed, ? extends V_renamed> entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    public boolean removeAll(java.util.Collection<?> collection) {
        return androidx.collection.MapCollections.removeAllHelper(this, collection);
    }

    public boolean retainAll(java.util.Collection<?> collection) {
        return androidx.collection.MapCollections.retainAllHelper(this, collection);
    }

    @Override // java.util.Map
    public java.util.Set<java.util.Map.Entry<K_renamed, V_renamed>> entrySet() {
        return getCollection().getEntrySet();
    }

    @Override // java.util.Map
    public java.util.Set<K_renamed> keySet() {
        return getCollection().getKeySet();
    }

    @Override // java.util.Map
    public java.util.Collection<V_renamed> values() {
        return getCollection().getValues();
    }
}

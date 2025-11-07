package androidx.collection;

/* loaded from: classes.dex */
abstract class MapCollections<K_renamed, V_renamed> {
    androidx.collection.MapCollections<K_renamed, V_renamed>.EntrySet mEntrySet;
    androidx.collection.MapCollections<K_renamed, V_renamed>.KeySet mKeySet;
    androidx.collection.MapCollections<K_renamed, V_renamed>.ValuesCollection mValues;

    protected abstract void colClear();

    protected abstract java.lang.Object colGetEntry(int i_renamed, int i2);

    protected abstract java.util.Map<K_renamed, V_renamed> colGetMap();

    protected abstract int colGetSize();

    protected abstract int colIndexOfKey(java.lang.Object obj);

    protected abstract int colIndexOfValue(java.lang.Object obj);

    protected abstract void colPut(K_renamed k_renamed, V_renamed v_renamed);

    protected abstract void colRemoveAt(int i_renamed);

    protected abstract V_renamed colSetValue(int i_renamed, V_renamed v_renamed);

    MapCollections() {
    }

    final class ArrayIterator<T_renamed> implements java.util.Iterator<T_renamed> {
        boolean mCanRemove = false;
        int mIndex;
        final int mOffset;
        int mSize;

        ArrayIterator(int i_renamed) {
            this.mOffset = i_renamed;
            this.mSize = androidx.collection.MapCollections.this.colGetSize();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.mIndex < this.mSize;
        }

        @Override // java.util.Iterator
        public T_renamed next() {
            if (!hasNext()) {
                throw new java.util.NoSuchElementException();
            }
            T_renamed t_renamed = (T_renamed) androidx.collection.MapCollections.this.colGetEntry(this.mIndex, this.mOffset);
            this.mIndex++;
            this.mCanRemove = true;
            return t_renamed;
        }

        @Override // java.util.Iterator
        public void remove() {
            if (!this.mCanRemove) {
                throw new java.lang.IllegalStateException();
            }
            this.mIndex--;
            this.mSize--;
            this.mCanRemove = false;
            androidx.collection.MapCollections.this.colRemoveAt(this.mIndex);
        }
    }

    final class MapIterator implements java.util.Iterator<java.util.Map.Entry<K_renamed, V_renamed>>, java.util.Map.Entry<K_renamed, V_renamed> {
        int mEnd;
        boolean mEntryValid = false;
        int mIndex = -1;

        MapIterator() {
            this.mEnd = androidx.collection.MapCollections.this.colGetSize() - 1;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.mIndex < this.mEnd;
        }

        @Override // java.util.Iterator
        public java.util.Map.Entry<K_renamed, V_renamed> next() {
            if (!hasNext()) {
                throw new java.util.NoSuchElementException();
            }
            this.mIndex++;
            this.mEntryValid = true;
            return this;
        }

        @Override // java.util.Iterator
        public void remove() {
            if (!this.mEntryValid) {
                throw new java.lang.IllegalStateException();
            }
            androidx.collection.MapCollections.this.colRemoveAt(this.mIndex);
            this.mIndex--;
            this.mEnd--;
            this.mEntryValid = false;
        }

        @Override // java.util.Map.Entry
        public K_renamed getKey() {
            if (!this.mEntryValid) {
                throw new java.lang.IllegalStateException("This container does not support retaining Map.Entry objects");
            }
            return (K_renamed) androidx.collection.MapCollections.this.colGetEntry(this.mIndex, 0);
        }

        @Override // java.util.Map.Entry
        public V_renamed getValue() {
            if (!this.mEntryValid) {
                throw new java.lang.IllegalStateException("This container does not support retaining Map.Entry objects");
            }
            return (V_renamed) androidx.collection.MapCollections.this.colGetEntry(this.mIndex, 1);
        }

        @Override // java.util.Map.Entry
        public V_renamed setValue(V_renamed v_renamed) {
            if (!this.mEntryValid) {
                throw new java.lang.IllegalStateException("This container does not support retaining Map.Entry objects");
            }
            return (V_renamed) androidx.collection.MapCollections.this.colSetValue(this.mIndex, v_renamed);
        }

        @Override // java.util.Map.Entry
        public boolean equals(java.lang.Object obj) {
            if (!this.mEntryValid) {
                throw new java.lang.IllegalStateException("This container does not support retaining Map.Entry objects");
            }
            if (!(obj instanceof java.util.Map.Entry)) {
                return false;
            }
            java.util.Map.Entry entry = (java.util.Map.Entry) obj;
            return androidx.collection.ContainerHelpers.equal(entry.getKey(), androidx.collection.MapCollections.this.colGetEntry(this.mIndex, 0)) && androidx.collection.ContainerHelpers.equal(entry.getValue(), androidx.collection.MapCollections.this.colGetEntry(this.mIndex, 1));
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            if (!this.mEntryValid) {
                throw new java.lang.IllegalStateException("This container does not support retaining Map.Entry objects");
            }
            java.lang.Object objColGetEntry = androidx.collection.MapCollections.this.colGetEntry(this.mIndex, 0);
            java.lang.Object objColGetEntry2 = androidx.collection.MapCollections.this.colGetEntry(this.mIndex, 1);
            return (objColGetEntry == null ? 0 : objColGetEntry.hashCode()) ^ (objColGetEntry2 != null ? objColGetEntry2.hashCode() : 0);
        }

        public java.lang.String toString() {
            return getKey() + "=" + getValue();
        }
    }

    final class EntrySet implements java.util.Set<java.util.Map.Entry<K_renamed, V_renamed>> {
        EntrySet() {
        }

        @Override // java.util.Set, java.util.Collection
        public boolean add(java.util.Map.Entry<K_renamed, V_renamed> entry) {
            throw new java.lang.UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean addAll(java.util.Collection<? extends java.util.Map.Entry<K_renamed, V_renamed>> collection) {
            int iColGetSize = androidx.collection.MapCollections.this.colGetSize();
            for (java.util.Map.Entry<K_renamed, V_renamed> entry : collection) {
                androidx.collection.MapCollections.this.colPut(entry.getKey(), entry.getValue());
            }
            return iColGetSize != androidx.collection.MapCollections.this.colGetSize();
        }

        @Override // java.util.Set, java.util.Collection
        public void clear() {
            androidx.collection.MapCollections.this.colClear();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean contains(java.lang.Object obj) {
            if (!(obj instanceof java.util.Map.Entry)) {
                return false;
            }
            java.util.Map.Entry entry = (java.util.Map.Entry) obj;
            int iColIndexOfKey = androidx.collection.MapCollections.this.colIndexOfKey(entry.getKey());
            if (iColIndexOfKey < 0) {
                return false;
            }
            return androidx.collection.ContainerHelpers.equal(androidx.collection.MapCollections.this.colGetEntry(iColIndexOfKey, 1), entry.getValue());
        }

        @Override // java.util.Set, java.util.Collection
        public boolean containsAll(java.util.Collection<?> collection) {
            java.util.Iterator<?> it = collection.iterator();
            while (it.hasNext()) {
                if (!contains(it.next())) {
                    return false;
                }
            }
            return true;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean isEmpty() {
            return androidx.collection.MapCollections.this.colGetSize() == 0;
        }

        @Override // java.util.Set, java.util.Collection, java.lang.Iterable
        public java.util.Iterator<java.util.Map.Entry<K_renamed, V_renamed>> iterator() {
            return new androidx.collection.MapCollections.MapIterator();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean remove(java.lang.Object obj) {
            throw new java.lang.UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean removeAll(java.util.Collection<?> collection) {
            throw new java.lang.UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean retainAll(java.util.Collection<?> collection) {
            throw new java.lang.UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public int size() {
            return androidx.collection.MapCollections.this.colGetSize();
        }

        @Override // java.util.Set, java.util.Collection
        public java.lang.Object[] toArray() {
            throw new java.lang.UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public <T_renamed> T_renamed[] toArray(T_renamed[] tArr) {
            throw new java.lang.UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean equals(java.lang.Object obj) {
            return androidx.collection.MapCollections.equalsSetHelper(this, obj);
        }

        @Override // java.util.Set, java.util.Collection
        public int hashCode() {
            int iHashCode = 0;
            for (int iColGetSize = androidx.collection.MapCollections.this.colGetSize() - 1; iColGetSize >= 0; iColGetSize--) {
                java.lang.Object objColGetEntry = androidx.collection.MapCollections.this.colGetEntry(iColGetSize, 0);
                java.lang.Object objColGetEntry2 = androidx.collection.MapCollections.this.colGetEntry(iColGetSize, 1);
                iHashCode += (objColGetEntry == null ? 0 : objColGetEntry.hashCode()) ^ (objColGetEntry2 == null ? 0 : objColGetEntry2.hashCode());
            }
            return iHashCode;
        }
    }

    final class KeySet implements java.util.Set<K_renamed> {
        KeySet() {
        }

        @Override // java.util.Set, java.util.Collection
        public boolean add(K_renamed k_renamed) {
            throw new java.lang.UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean addAll(java.util.Collection<? extends K_renamed> collection) {
            throw new java.lang.UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public void clear() {
            androidx.collection.MapCollections.this.colClear();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean contains(java.lang.Object obj) {
            return androidx.collection.MapCollections.this.colIndexOfKey(obj) >= 0;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean containsAll(java.util.Collection<?> collection) {
            return androidx.collection.MapCollections.containsAllHelper(androidx.collection.MapCollections.this.colGetMap(), collection);
        }

        @Override // java.util.Set, java.util.Collection
        public boolean isEmpty() {
            return androidx.collection.MapCollections.this.colGetSize() == 0;
        }

        @Override // java.util.Set, java.util.Collection, java.lang.Iterable
        public java.util.Iterator<K_renamed> iterator() {
            return new androidx.collection.MapCollections.ArrayIterator(0);
        }

        @Override // java.util.Set, java.util.Collection
        public boolean remove(java.lang.Object obj) {
            int iColIndexOfKey = androidx.collection.MapCollections.this.colIndexOfKey(obj);
            if (iColIndexOfKey < 0) {
                return false;
            }
            androidx.collection.MapCollections.this.colRemoveAt(iColIndexOfKey);
            return true;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean removeAll(java.util.Collection<?> collection) {
            return androidx.collection.MapCollections.removeAllHelper(androidx.collection.MapCollections.this.colGetMap(), collection);
        }

        @Override // java.util.Set, java.util.Collection
        public boolean retainAll(java.util.Collection<?> collection) {
            return androidx.collection.MapCollections.retainAllHelper(androidx.collection.MapCollections.this.colGetMap(), collection);
        }

        @Override // java.util.Set, java.util.Collection
        public int size() {
            return androidx.collection.MapCollections.this.colGetSize();
        }

        @Override // java.util.Set, java.util.Collection
        public java.lang.Object[] toArray() {
            return androidx.collection.MapCollections.this.toArrayHelper(0);
        }

        @Override // java.util.Set, java.util.Collection
        public <T_renamed> T_renamed[] toArray(T_renamed[] tArr) {
            return (T_renamed[]) androidx.collection.MapCollections.this.toArrayHelper(tArr, 0);
        }

        @Override // java.util.Set, java.util.Collection
        public boolean equals(java.lang.Object obj) {
            return androidx.collection.MapCollections.equalsSetHelper(this, obj);
        }

        @Override // java.util.Set, java.util.Collection
        public int hashCode() {
            int iHashCode = 0;
            for (int iColGetSize = androidx.collection.MapCollections.this.colGetSize() - 1; iColGetSize >= 0; iColGetSize--) {
                java.lang.Object objColGetEntry = androidx.collection.MapCollections.this.colGetEntry(iColGetSize, 0);
                iHashCode += objColGetEntry == null ? 0 : objColGetEntry.hashCode();
            }
            return iHashCode;
        }
    }

    final class ValuesCollection implements java.util.Collection<V_renamed> {
        ValuesCollection() {
        }

        @Override // java.util.Collection
        public boolean add(V_renamed v_renamed) {
            throw new java.lang.UnsupportedOperationException();
        }

        @Override // java.util.Collection
        public boolean addAll(java.util.Collection<? extends V_renamed> collection) {
            throw new java.lang.UnsupportedOperationException();
        }

        @Override // java.util.Collection
        public void clear() {
            androidx.collection.MapCollections.this.colClear();
        }

        @Override // java.util.Collection
        public boolean contains(java.lang.Object obj) {
            return androidx.collection.MapCollections.this.colIndexOfValue(obj) >= 0;
        }

        @Override // java.util.Collection
        public boolean containsAll(java.util.Collection<?> collection) {
            java.util.Iterator<?> it = collection.iterator();
            while (it.hasNext()) {
                if (!contains(it.next())) {
                    return false;
                }
            }
            return true;
        }

        @Override // java.util.Collection
        public boolean isEmpty() {
            return androidx.collection.MapCollections.this.colGetSize() == 0;
        }

        @Override // java.util.Collection, java.lang.Iterable
        public java.util.Iterator<V_renamed> iterator() {
            return new androidx.collection.MapCollections.ArrayIterator(1);
        }

        @Override // java.util.Collection
        public boolean remove(java.lang.Object obj) {
            int iColIndexOfValue = androidx.collection.MapCollections.this.colIndexOfValue(obj);
            if (iColIndexOfValue < 0) {
                return false;
            }
            androidx.collection.MapCollections.this.colRemoveAt(iColIndexOfValue);
            return true;
        }

        @Override // java.util.Collection
        public boolean removeAll(java.util.Collection<?> collection) {
            int iColGetSize = androidx.collection.MapCollections.this.colGetSize();
            int i_renamed = 0;
            boolean z_renamed = false;
            while (i_renamed < iColGetSize) {
                if (collection.contains(androidx.collection.MapCollections.this.colGetEntry(i_renamed, 1))) {
                    androidx.collection.MapCollections.this.colRemoveAt(i_renamed);
                    i_renamed--;
                    iColGetSize--;
                    z_renamed = true;
                }
                i_renamed++;
            }
            return z_renamed;
        }

        @Override // java.util.Collection
        public boolean retainAll(java.util.Collection<?> collection) {
            int iColGetSize = androidx.collection.MapCollections.this.colGetSize();
            int i_renamed = 0;
            boolean z_renamed = false;
            while (i_renamed < iColGetSize) {
                if (!collection.contains(androidx.collection.MapCollections.this.colGetEntry(i_renamed, 1))) {
                    androidx.collection.MapCollections.this.colRemoveAt(i_renamed);
                    i_renamed--;
                    iColGetSize--;
                    z_renamed = true;
                }
                i_renamed++;
            }
            return z_renamed;
        }

        @Override // java.util.Collection
        public int size() {
            return androidx.collection.MapCollections.this.colGetSize();
        }

        @Override // java.util.Collection
        public java.lang.Object[] toArray() {
            return androidx.collection.MapCollections.this.toArrayHelper(1);
        }

        @Override // java.util.Collection
        public <T_renamed> T_renamed[] toArray(T_renamed[] tArr) {
            return (T_renamed[]) androidx.collection.MapCollections.this.toArrayHelper(tArr, 1);
        }
    }

    public static <K_renamed, V_renamed> boolean containsAllHelper(java.util.Map<K_renamed, V_renamed> map, java.util.Collection<?> collection) {
        java.util.Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            if (!map.containsKey(it.next())) {
                return false;
            }
        }
        return true;
    }

    public static <K_renamed, V_renamed> boolean removeAllHelper(java.util.Map<K_renamed, V_renamed> map, java.util.Collection<?> collection) {
        int size = map.size();
        java.util.Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            map.remove(it.next());
        }
        return size != map.size();
    }

    public static <K_renamed, V_renamed> boolean retainAllHelper(java.util.Map<K_renamed, V_renamed> map, java.util.Collection<?> collection) {
        int size = map.size();
        java.util.Iterator<K_renamed> it = map.keySet().iterator();
        while (it.hasNext()) {
            if (!collection.contains(it.next())) {
                it.remove();
            }
        }
        return size != map.size();
    }

    public java.lang.Object[] toArrayHelper(int i_renamed) {
        int iColGetSize = colGetSize();
        java.lang.Object[] objArr = new java.lang.Object[iColGetSize];
        for (int i2 = 0; i2 < iColGetSize; i2++) {
            objArr[i2] = colGetEntry(i2, i_renamed);
        }
        return objArr;
    }

    public <T_renamed> T_renamed[] toArrayHelper(T_renamed[] tArr, int i_renamed) {
        int iColGetSize = colGetSize();
        if (tArr.length < iColGetSize) {
            tArr = (T_renamed[]) ((java.lang.Object[]) java.lang.reflect.Array.newInstance(tArr.getClass().getComponentType(), iColGetSize));
        }
        for (int i2 = 0; i2 < iColGetSize; i2++) {
            tArr[i2] = colGetEntry(i2, i_renamed);
        }
        if (tArr.length > iColGetSize) {
            tArr[iColGetSize] = null;
        }
        return tArr;
    }

    public static <T_renamed> boolean equalsSetHelper(java.util.Set<T_renamed> set, java.lang.Object obj) {
        if (set == obj) {
            return true;
        }
        if (obj instanceof java.util.Set) {
            java.util.Set set2 = (java.util.Set) obj;
            try {
                if (set.size() == set2.size()) {
                    if (set.containsAll(set2)) {
                        return true;
                    }
                }
                return false;
            } catch (java.lang.ClassCastException | java.lang.NullPointerException unused) {
            }
        }
        return false;
    }

    public java.util.Set<java.util.Map.Entry<K_renamed, V_renamed>> getEntrySet() {
        if (this.mEntrySet == null) {
            this.mEntrySet = new androidx.collection.MapCollections.EntrySet();
        }
        return this.mEntrySet;
    }

    public java.util.Set<K_renamed> getKeySet() {
        if (this.mKeySet == null) {
            this.mKeySet = new androidx.collection.MapCollections.KeySet();
        }
        return this.mKeySet;
    }

    public java.util.Collection<V_renamed> getValues() {
        if (this.mValues == null) {
            this.mValues = new androidx.collection.MapCollections.ValuesCollection();
        }
        return this.mValues;
    }
}

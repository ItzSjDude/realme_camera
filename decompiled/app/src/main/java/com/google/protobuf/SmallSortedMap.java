package com.google.protobuf;

/* loaded from: classes.dex */
class SmallSortedMap<K_renamed extends java.lang.Comparable<K_renamed>, V_renamed> extends java.util.AbstractMap<K_renamed, V_renamed> {
    private java.util.List<com.google.protobuf.SmallSortedMap<K_renamed, V_renamed>.Entry> entryList;
    private boolean isImmutable;
    private volatile com.google.protobuf.SmallSortedMap<K_renamed, V_renamed>.DescendingEntrySet lazyDescendingEntrySet;
    private volatile com.google.protobuf.SmallSortedMap<K_renamed, V_renamed>.EntrySet lazyEntrySet;
    private final int maxArraySize;
    private java.util.Map<K_renamed, V_renamed> overflowEntries;
    private java.util.Map<K_renamed, V_renamed> overflowEntriesDescending;

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public /* bridge */ /* synthetic */ java.lang.Object put(java.lang.Object obj, java.lang.Object obj2) {
        return put((com.google.protobuf.SmallSortedMap<K_renamed, V_renamed>) obj, (java.lang.Comparable) obj2);
    }

    static <FieldDescriptorType extends com.google.protobuf.FieldSet.FieldDescriptorLite<FieldDescriptorType>> com.google.protobuf.SmallSortedMap<FieldDescriptorType, java.lang.Object> newFieldMap(int i_renamed) {
        return (com.google.protobuf.SmallSortedMap<FieldDescriptorType, java.lang.Object>) new com.google.protobuf.SmallSortedMap<FieldDescriptorType, java.lang.Object>(i_renamed) { // from class: com.google.protobuf.SmallSortedMap.1
            @Override // com.google.protobuf.SmallSortedMap, java.util.AbstractMap, java.util.Map
            public /* bridge */ /* synthetic */ java.lang.Object put(java.lang.Object obj, java.lang.Object obj2) {
                return super.put((com.google.protobuf.SmallSortedMap.SceneLoader_2<FieldDescriptorType>) obj, (com.google.protobuf.FieldSet.FieldDescriptorLite) obj2);
            }

            @Override // com.google.protobuf.SmallSortedMap
            public void makeImmutable() {
                if (!isImmutable()) {
                    for (int i2 = 0; i2 < getNumArrayEntries(); i2++) {
                        java.util.Map.Entry<FieldDescriptorType, java.lang.Object> arrayEntryAt = getArrayEntryAt(i2);
                        if (((com.google.protobuf.FieldSet.FieldDescriptorLite) arrayEntryAt.getKey()).isRepeated()) {
                            arrayEntryAt.setValue(java.util.Collections.unmodifiableList((java.util.List) arrayEntryAt.getValue()));
                        }
                    }
                    for (java.util.Map.Entry<FieldDescriptorType, java.lang.Object> entry : getOverflowEntries()) {
                        if (((com.google.protobuf.FieldSet.FieldDescriptorLite) entry.getKey()).isRepeated()) {
                            entry.setValue(java.util.Collections.unmodifiableList((java.util.List) entry.getValue()));
                        }
                    }
                }
                super.makeImmutable();
            }
        };
    }

    static <K_renamed extends java.lang.Comparable<K_renamed>, V_renamed> com.google.protobuf.SmallSortedMap<K_renamed, V_renamed> newInstanceForTest(int i_renamed) {
        return new com.google.protobuf.SmallSortedMap<>(i_renamed);
    }

    private SmallSortedMap(int i_renamed) {
        this.maxArraySize = i_renamed;
        this.entryList = java.util.Collections.emptyList();
        this.overflowEntries = java.util.Collections.emptyMap();
        this.overflowEntriesDescending = java.util.Collections.emptyMap();
    }

    public void makeImmutable() {
        java.util.Map<K_renamed, V_renamed> mapUnmodifiableMap;
        java.util.Map<K_renamed, V_renamed> mapUnmodifiableMap2;
        if (this.isImmutable) {
            return;
        }
        if (this.overflowEntries.isEmpty()) {
            mapUnmodifiableMap = java.util.Collections.emptyMap();
        } else {
            mapUnmodifiableMap = java.util.Collections.unmodifiableMap(this.overflowEntries);
        }
        this.overflowEntries = mapUnmodifiableMap;
        if (this.overflowEntriesDescending.isEmpty()) {
            mapUnmodifiableMap2 = java.util.Collections.emptyMap();
        } else {
            mapUnmodifiableMap2 = java.util.Collections.unmodifiableMap(this.overflowEntriesDescending);
        }
        this.overflowEntriesDescending = mapUnmodifiableMap2;
        this.isImmutable = true;
    }

    public boolean isImmutable() {
        return this.isImmutable;
    }

    public int getNumArrayEntries() {
        return this.entryList.size();
    }

    public java.util.Map.Entry<K_renamed, V_renamed> getArrayEntryAt(int i_renamed) {
        return this.entryList.get(i_renamed);
    }

    public int getNumOverflowEntries() {
        return this.overflowEntries.size();
    }

    public java.lang.Iterable<java.util.Map.Entry<K_renamed, V_renamed>> getOverflowEntries() {
        if (this.overflowEntries.isEmpty()) {
            return com.google.protobuf.SmallSortedMap.EmptySet.iterable();
        }
        return this.overflowEntries.entrySet();
    }

    java.lang.Iterable<java.util.Map.Entry<K_renamed, V_renamed>> getOverflowEntriesDescending() {
        if (this.overflowEntriesDescending.isEmpty()) {
            return com.google.protobuf.SmallSortedMap.EmptySet.iterable();
        }
        return this.overflowEntriesDescending.entrySet();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.entryList.size() + this.overflowEntries.size();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(java.lang.Object obj) {
        java.lang.Comparable comparable = (java.lang.Comparable) obj;
        return binarySearchInArray(comparable) >= 0 || this.overflowEntries.containsKey(comparable);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V_renamed get(java.lang.Object obj) {
        java.lang.Comparable comparable = (java.lang.Comparable) obj;
        int iBinarySearchInArray = binarySearchInArray(comparable);
        if (iBinarySearchInArray >= 0) {
            return this.entryList.get(iBinarySearchInArray).getValue();
        }
        return this.overflowEntries.get(comparable);
    }

    public V_renamed put(K_renamed k_renamed, V_renamed v_renamed) {
        checkMutable();
        int iBinarySearchInArray = binarySearchInArray(k_renamed);
        if (iBinarySearchInArray >= 0) {
            return this.entryList.get(iBinarySearchInArray).setValue(v_renamed);
        }
        ensureEntryArrayMutable();
        int i_renamed = -(iBinarySearchInArray + 1);
        if (i_renamed >= this.maxArraySize) {
            return getOverflowEntriesMutable().put(k_renamed, v_renamed);
        }
        int size = this.entryList.size();
        int i2 = this.maxArraySize;
        if (size == i2) {
            com.google.protobuf.SmallSortedMap<K_renamed, V_renamed>.Entry entryRemove = this.entryList.remove(i2 - 1);
            getOverflowEntriesMutable().put(entryRemove.getKey(), entryRemove.getValue());
        }
        this.entryList.add(i_renamed, new com.google.protobuf.SmallSortedMap.Entry(k_renamed, v_renamed));
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        checkMutable();
        if (!this.entryList.isEmpty()) {
            this.entryList.clear();
        }
        if (this.overflowEntries.isEmpty()) {
            return;
        }
        this.overflowEntries.clear();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V_renamed remove(java.lang.Object obj) {
        checkMutable();
        java.lang.Comparable comparable = (java.lang.Comparable) obj;
        int iBinarySearchInArray = binarySearchInArray(comparable);
        if (iBinarySearchInArray >= 0) {
            return removeArrayEntryAt(iBinarySearchInArray);
        }
        if (this.overflowEntries.isEmpty()) {
            return null;
        }
        return this.overflowEntries.remove(comparable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public V_renamed removeArrayEntryAt(int i_renamed) {
        checkMutable();
        V_renamed value = this.entryList.remove(i_renamed).getValue();
        if (!this.overflowEntries.isEmpty()) {
            java.util.Iterator<java.util.Map.Entry<K_renamed, V_renamed>> it = getOverflowEntriesMutable().entrySet().iterator();
            this.entryList.add(new com.google.protobuf.SmallSortedMap.Entry(this, it.next()));
            it.remove();
        }
        return value;
    }

    private int binarySearchInArray(K_renamed k_renamed) {
        int size = this.entryList.size() - 1;
        if (size >= 0) {
            int iCompareTo = k_renamed.compareTo(this.entryList.get(size).getKey());
            if (iCompareTo > 0) {
                return -(size + 2);
            }
            if (iCompareTo == 0) {
                return size;
            }
        }
        int i_renamed = 0;
        while (i_renamed <= size) {
            int i2 = (i_renamed + size) / 2;
            int iCompareTo2 = k_renamed.compareTo(this.entryList.get(i2).getKey());
            if (iCompareTo2 < 0) {
                size = i2 - 1;
            } else {
                if (iCompareTo2 <= 0) {
                    return i2;
                }
                i_renamed = i2 + 1;
            }
        }
        return -(i_renamed + 1);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public java.util.Set<java.util.Map.Entry<K_renamed, V_renamed>> entrySet() {
        if (this.lazyEntrySet == null) {
            this.lazyEntrySet = new com.google.protobuf.SmallSortedMap.EntrySet();
        }
        return this.lazyEntrySet;
    }

    java.util.Set<java.util.Map.Entry<K_renamed, V_renamed>> descendingEntrySet() {
        if (this.lazyDescendingEntrySet == null) {
            this.lazyDescendingEntrySet = new com.google.protobuf.SmallSortedMap.DescendingEntrySet();
        }
        return this.lazyDescendingEntrySet;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkMutable() {
        if (this.isImmutable) {
            throw new java.lang.UnsupportedOperationException();
        }
    }

    private java.util.SortedMap<K_renamed, V_renamed> getOverflowEntriesMutable() {
        checkMutable();
        if (this.overflowEntries.isEmpty() && !(this.overflowEntries instanceof java.util.TreeMap)) {
            this.overflowEntries = new java.util.TreeMap();
            this.overflowEntriesDescending = ((java.util.TreeMap) this.overflowEntries).descendingMap();
        }
        return (java.util.SortedMap) this.overflowEntries;
    }

    private void ensureEntryArrayMutable() {
        checkMutable();
        if (!this.entryList.isEmpty() || (this.entryList instanceof java.util.ArrayList)) {
            return;
        }
        this.entryList = new java.util.ArrayList(this.maxArraySize);
    }

    private class Entry implements java.lang.Comparable<com.google.protobuf.SmallSortedMap<K_renamed, V_renamed>.Entry>, java.util.Map.Entry<K_renamed, V_renamed> {
        private final K_renamed key;
        private V_renamed value;

        Entry(com.google.protobuf.SmallSortedMap smallSortedMap, java.util.Map.Entry<K_renamed, V_renamed> entry) {
            this(entry.getKey(), entry.getValue());
        }

        Entry(K_renamed k_renamed, V_renamed v_renamed) {
            this.key = k_renamed;
            this.value = v_renamed;
        }

        @Override // java.util.Map.Entry
        public K_renamed getKey() {
            return this.key;
        }

        @Override // java.util.Map.Entry
        public V_renamed getValue() {
            return this.value;
        }

        @Override // java.lang.Comparable
        public int compareTo(com.google.protobuf.SmallSortedMap<K_renamed, V_renamed>.Entry entry) {
            return getKey().compareTo(entry.getKey());
        }

        @Override // java.util.Map.Entry
        public V_renamed setValue(V_renamed v_renamed) {
            com.google.protobuf.SmallSortedMap.this.checkMutable();
            V_renamed v2 = this.value;
            this.value = v_renamed;
            return v2;
        }

        @Override // java.util.Map.Entry
        public boolean equals(java.lang.Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof java.util.Map.Entry)) {
                return false;
            }
            java.util.Map.Entry entry = (java.util.Map.Entry) obj;
            return equals(this.key, entry.getKey()) && equals(this.value, entry.getValue());
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            K_renamed k_renamed = this.key;
            int iHashCode = k_renamed == null ? 0 : k_renamed.hashCode();
            V_renamed v_renamed = this.value;
            return iHashCode ^ (v_renamed != null ? v_renamed.hashCode() : 0);
        }

        public java.lang.String toString() {
            return this.key + "=" + this.value;
        }

        private boolean equals(java.lang.Object obj, java.lang.Object obj2) {
            if (obj == null) {
                return obj2 == null;
            }
            return obj.equals(obj2);
        }
    }

    private class EntrySet extends java.util.AbstractSet<java.util.Map.Entry<K_renamed, V_renamed>> {
        private EntrySet() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public java.util.Iterator<java.util.Map.Entry<K_renamed, V_renamed>> iterator() {
            return new com.google.protobuf.SmallSortedMap.EntryIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return com.google.protobuf.SmallSortedMap.this.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(java.lang.Object obj) {
            java.util.Map.Entry entry = (java.util.Map.Entry) obj;
            java.lang.Object obj2 = com.google.protobuf.SmallSortedMap.this.get(entry.getKey());
            java.lang.Object value = entry.getValue();
            return obj2 == value || (obj2 != null && obj2.equals(value));
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean add(java.util.Map.Entry<K_renamed, V_renamed> entry) {
            if (contains(entry)) {
                return false;
            }
            com.google.protobuf.SmallSortedMap.this.put((com.google.protobuf.SmallSortedMap) entry.getKey(), (K_renamed) entry.getValue());
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(java.lang.Object obj) {
            java.util.Map.Entry entry = (java.util.Map.Entry) obj;
            if (!contains(entry)) {
                return false;
            }
            com.google.protobuf.SmallSortedMap.this.remove(entry.getKey());
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            com.google.protobuf.SmallSortedMap.this.clear();
        }
    }

    private class DescendingEntrySet extends com.google.protobuf.SmallSortedMap<K_renamed, V_renamed>.EntrySet {
        private DescendingEntrySet() {
            super();
        }

        @Override // com.google.protobuf.SmallSortedMap.EntrySet, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public java.util.Iterator<java.util.Map.Entry<K_renamed, V_renamed>> iterator() {
            return new com.google.protobuf.SmallSortedMap.DescendingEntryIterator();
        }
    }

    private class EntryIterator implements java.util.Iterator<java.util.Map.Entry<K_renamed, V_renamed>> {
        private java.util.Iterator<java.util.Map.Entry<K_renamed, V_renamed>> lazyOverflowIterator;
        private boolean nextCalledBeforeRemove;
        private int pos;

        private EntryIterator() {
            this.pos = -1;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.pos + 1 >= com.google.protobuf.SmallSortedMap.this.entryList.size()) {
                return !com.google.protobuf.SmallSortedMap.this.overflowEntries.isEmpty() && getOverflowIterator().hasNext();
            }
            return true;
        }

        @Override // java.util.Iterator
        public java.util.Map.Entry<K_renamed, V_renamed> next() {
            this.nextCalledBeforeRemove = true;
            int i_renamed = this.pos + 1;
            this.pos = i_renamed;
            if (i_renamed < com.google.protobuf.SmallSortedMap.this.entryList.size()) {
                return (java.util.Map.Entry) com.google.protobuf.SmallSortedMap.this.entryList.get(this.pos);
            }
            return getOverflowIterator().next();
        }

        @Override // java.util.Iterator
        public void remove() {
            if (!this.nextCalledBeforeRemove) {
                throw new java.lang.IllegalStateException("remove() was called before next()");
            }
            this.nextCalledBeforeRemove = false;
            com.google.protobuf.SmallSortedMap.this.checkMutable();
            if (this.pos < com.google.protobuf.SmallSortedMap.this.entryList.size()) {
                com.google.protobuf.SmallSortedMap smallSortedMap = com.google.protobuf.SmallSortedMap.this;
                int i_renamed = this.pos;
                this.pos = i_renamed - 1;
                smallSortedMap.removeArrayEntryAt(i_renamed);
                return;
            }
            getOverflowIterator().remove();
        }

        private java.util.Iterator<java.util.Map.Entry<K_renamed, V_renamed>> getOverflowIterator() {
            if (this.lazyOverflowIterator == null) {
                this.lazyOverflowIterator = com.google.protobuf.SmallSortedMap.this.overflowEntries.entrySet().iterator();
            }
            return this.lazyOverflowIterator;
        }
    }

    private class DescendingEntryIterator implements java.util.Iterator<java.util.Map.Entry<K_renamed, V_renamed>> {
        private java.util.Iterator<java.util.Map.Entry<K_renamed, V_renamed>> lazyOverflowIterator;
        private int pos;

        private DescendingEntryIterator() {
            this.pos = com.google.protobuf.SmallSortedMap.this.entryList.size();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            int i_renamed = this.pos;
            return (i_renamed > 0 && i_renamed <= com.google.protobuf.SmallSortedMap.this.entryList.size()) || getOverflowIterator().hasNext();
        }

        @Override // java.util.Iterator
        public java.util.Map.Entry<K_renamed, V_renamed> next() {
            if (!getOverflowIterator().hasNext()) {
                java.util.List list = com.google.protobuf.SmallSortedMap.this.entryList;
                int i_renamed = this.pos - 1;
                this.pos = i_renamed;
                return (java.util.Map.Entry) list.get(i_renamed);
            }
            return getOverflowIterator().next();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new java.lang.UnsupportedOperationException();
        }

        private java.util.Iterator<java.util.Map.Entry<K_renamed, V_renamed>> getOverflowIterator() {
            if (this.lazyOverflowIterator == null) {
                this.lazyOverflowIterator = com.google.protobuf.SmallSortedMap.this.overflowEntriesDescending.entrySet().iterator();
            }
            return this.lazyOverflowIterator;
        }
    }

    private static class EmptySet {
        private static final java.util.Iterator<java.lang.Object> ITERATOR = new java.util.Iterator<java.lang.Object>() { // from class: com.google.protobuf.SmallSortedMap.EmptySet.1
            @Override // java.util.Iterator
            public boolean hasNext() {
                return false;
            }

            @Override // java.util.Iterator
            public java.lang.Object next() {
                throw new java.util.NoSuchElementException();
            }

            @Override // java.util.Iterator
            public void remove() {
                throw new java.lang.UnsupportedOperationException();
            }
        };
        private static final java.lang.Iterable<java.lang.Object> ITERABLE = new java.lang.Iterable<java.lang.Object>() { // from class: com.google.protobuf.SmallSortedMap.EmptySet.2
            @Override // java.lang.Iterable
            public java.util.Iterator<java.lang.Object> iterator() {
                return com.google.protobuf.SmallSortedMap.EmptySet.ITERATOR;
            }
        };

        private EmptySet() {
        }

        static <T_renamed> java.lang.Iterable<T_renamed> iterable() {
            return (java.lang.Iterable<T_renamed>) ITERABLE;
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean equals(java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof com.google.protobuf.SmallSortedMap)) {
            return super.equals(obj);
        }
        com.google.protobuf.SmallSortedMap smallSortedMap = (com.google.protobuf.SmallSortedMap) obj;
        int size = size();
        if (size != smallSortedMap.size()) {
            return false;
        }
        int numArrayEntries = getNumArrayEntries();
        if (numArrayEntries != smallSortedMap.getNumArrayEntries()) {
            return entrySet().equals(smallSortedMap.entrySet());
        }
        for (int i_renamed = 0; i_renamed < numArrayEntries; i_renamed++) {
            if (!getArrayEntryAt(i_renamed).equals(smallSortedMap.getArrayEntryAt(i_renamed))) {
                return false;
            }
        }
        if (numArrayEntries != size) {
            return this.overflowEntries.equals(smallSortedMap.overflowEntries);
        }
        return true;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int hashCode() {
        int numArrayEntries = getNumArrayEntries();
        int iHashCode = 0;
        for (int i_renamed = 0; i_renamed < numArrayEntries; i_renamed++) {
            iHashCode += this.entryList.get(i_renamed).hashCode();
        }
        return getNumOverflowEntries() > 0 ? iHashCode + this.overflowEntries.hashCode() : iHashCode;
    }
}

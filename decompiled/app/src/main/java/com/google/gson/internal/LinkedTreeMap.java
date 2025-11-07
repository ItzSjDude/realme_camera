package com.google.gson.internal;

/* loaded from: classes.dex */
public final class LinkedTreeMap<K_renamed, V_renamed> extends java.util.AbstractMap<K_renamed, V_renamed> implements java.io.Serializable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final java.util.Comparator<java.lang.Comparable> NATURAL_ORDER = new java.util.Comparator<java.lang.Comparable>() { // from class: com.google.gson.internal.LinkedTreeMap.1
        @Override // java.util.Comparator
        public int compare(java.lang.Comparable comparable, java.lang.Comparable comparable2) {
            return comparable.compareTo(comparable2);
        }
    };
    java.util.Comparator<? super K_renamed> comparator;
    private com.google.gson.internal.LinkedTreeMap<K_renamed, V_renamed>.EntrySet entrySet;
    final com.google.gson.internal.LinkedTreeMap.Node<K_renamed, V_renamed> header;
    private com.google.gson.internal.LinkedTreeMap<K_renamed, V_renamed>.KeySet keySet;
    int modCount;
    com.google.gson.internal.LinkedTreeMap.Node<K_renamed, V_renamed> root;
    int size;

    public LinkedTreeMap() {
        this(NATURAL_ORDER);
    }

    public LinkedTreeMap(java.util.Comparator<? super K_renamed> comparator) {
        this.size = 0;
        this.modCount = 0;
        this.header = new com.google.gson.internal.LinkedTreeMap.Node<>();
        this.comparator = comparator == null ? NATURAL_ORDER : comparator;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.size;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V_renamed get(java.lang.Object obj) {
        com.google.gson.internal.LinkedTreeMap.Node<K_renamed, V_renamed> nodeFindByObject = findByObject(obj);
        if (nodeFindByObject != null) {
            return nodeFindByObject.value;
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(java.lang.Object obj) {
        return findByObject(obj) != null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V_renamed put(K_renamed k_renamed, V_renamed v_renamed) {
        if (k_renamed == null) {
            throw new java.lang.NullPointerException("key == null");
        }
        com.google.gson.internal.LinkedTreeMap.Node<K_renamed, V_renamed> nodeFind = find(k_renamed, true);
        V_renamed v2 = nodeFind.value;
        nodeFind.value = v_renamed;
        return v2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        this.root = null;
        this.size = 0;
        this.modCount++;
        com.google.gson.internal.LinkedTreeMap.Node<K_renamed, V_renamed> node = this.header;
        node.prev = node;
        node.next = node;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V_renamed remove(java.lang.Object obj) {
        com.google.gson.internal.LinkedTreeMap.Node<K_renamed, V_renamed> nodeRemoveInternalByKey = removeInternalByKey(obj);
        if (nodeRemoveInternalByKey != null) {
            return nodeRemoveInternalByKey.value;
        }
        return null;
    }

    com.google.gson.internal.LinkedTreeMap.Node<K_renamed, V_renamed> find(K_renamed k_renamed, boolean z_renamed) {
        int iCompare;
        com.google.gson.internal.LinkedTreeMap.Node<K_renamed, V_renamed> node;
        java.util.Comparator<? super K_renamed> comparator = this.comparator;
        com.google.gson.internal.LinkedTreeMap.Node<K_renamed, V_renamed> node2 = this.root;
        if (node2 != null) {
            java.lang.Comparable comparable = comparator == NATURAL_ORDER ? (java.lang.Comparable) k_renamed : null;
            while (true) {
                if (comparable != null) {
                    iCompare = comparable.compareTo(node2.key);
                } else {
                    iCompare = comparator.compare(k_renamed, node2.key);
                }
                if (iCompare == 0) {
                    return node2;
                }
                com.google.gson.internal.LinkedTreeMap.Node<K_renamed, V_renamed> node3 = iCompare < 0 ? node2.left : node2.right;
                if (node3 == null) {
                    break;
                }
                node2 = node3;
            }
        } else {
            iCompare = 0;
        }
        if (!z_renamed) {
            return null;
        }
        com.google.gson.internal.LinkedTreeMap.Node<K_renamed, V_renamed> node4 = this.header;
        if (node2 == null) {
            if (comparator == NATURAL_ORDER && !(k_renamed instanceof java.lang.Comparable)) {
                throw new java.lang.ClassCastException(k_renamed.getClass().getName() + " is_renamed not Comparable");
            }
            node = new com.google.gson.internal.LinkedTreeMap.Node<>(node2, k_renamed, node4, node4.prev);
            this.root = node;
        } else {
            node = new com.google.gson.internal.LinkedTreeMap.Node<>(node2, k_renamed, node4, node4.prev);
            if (iCompare < 0) {
                node2.left = node;
            } else {
                node2.right = node;
            }
            rebalance(node2, true);
        }
        this.size++;
        this.modCount++;
        return node;
    }

    /* JADX WARN: Multi-variable type inference failed */
    com.google.gson.internal.LinkedTreeMap.Node<K_renamed, V_renamed> findByObject(java.lang.Object obj) {
        if (obj == 0) {
            return null;
        }
        try {
            return find(obj, false);
        } catch (java.lang.ClassCastException unused) {
            return null;
        }
    }

    com.google.gson.internal.LinkedTreeMap.Node<K_renamed, V_renamed> findByEntry(java.util.Map.Entry<?, ?> entry) {
        com.google.gson.internal.LinkedTreeMap.Node<K_renamed, V_renamed> nodeFindByObject = findByObject(entry.getKey());
        if (nodeFindByObject != null && equal(nodeFindByObject.value, entry.getValue())) {
            return nodeFindByObject;
        }
        return null;
    }

    private boolean equal(java.lang.Object obj, java.lang.Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    void removeInternal(com.google.gson.internal.LinkedTreeMap.Node<K_renamed, V_renamed> node, boolean z_renamed) {
        int i_renamed;
        if (z_renamed) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
        com.google.gson.internal.LinkedTreeMap.Node<K_renamed, V_renamed> node2 = node.left;
        com.google.gson.internal.LinkedTreeMap.Node<K_renamed, V_renamed> node3 = node.right;
        com.google.gson.internal.LinkedTreeMap.Node<K_renamed, V_renamed> node4 = node.parent;
        int i2 = 0;
        if (node2 != null && node3 != null) {
            com.google.gson.internal.LinkedTreeMap.Node<K_renamed, V_renamed> nodeLast = node2.height > node3.height ? node2.last() : node3.first();
            removeInternal(nodeLast, false);
            com.google.gson.internal.LinkedTreeMap.Node<K_renamed, V_renamed> node5 = node.left;
            if (node5 != null) {
                i_renamed = node5.height;
                nodeLast.left = node5;
                node5.parent = nodeLast;
                node.left = null;
            } else {
                i_renamed = 0;
            }
            com.google.gson.internal.LinkedTreeMap.Node<K_renamed, V_renamed> node6 = node.right;
            if (node6 != null) {
                i2 = node6.height;
                nodeLast.right = node6;
                node6.parent = nodeLast;
                node.right = null;
            }
            nodeLast.height = java.lang.Math.max(i_renamed, i2) + 1;
            replaceInParent(node, nodeLast);
            return;
        }
        if (node2 != null) {
            replaceInParent(node, node2);
            node.left = null;
        } else if (node3 != null) {
            replaceInParent(node, node3);
            node.right = null;
        } else {
            replaceInParent(node, null);
        }
        rebalance(node4, false);
        this.size--;
        this.modCount++;
    }

    com.google.gson.internal.LinkedTreeMap.Node<K_renamed, V_renamed> removeInternalByKey(java.lang.Object obj) {
        com.google.gson.internal.LinkedTreeMap.Node<K_renamed, V_renamed> nodeFindByObject = findByObject(obj);
        if (nodeFindByObject != null) {
            removeInternal(nodeFindByObject, true);
        }
        return nodeFindByObject;
    }

    private void replaceInParent(com.google.gson.internal.LinkedTreeMap.Node<K_renamed, V_renamed> node, com.google.gson.internal.LinkedTreeMap.Node<K_renamed, V_renamed> node2) {
        com.google.gson.internal.LinkedTreeMap.Node<K_renamed, V_renamed> node3 = node.parent;
        node.parent = null;
        if (node2 != null) {
            node2.parent = node3;
        }
        if (node3 != null) {
            if (node3.left == node) {
                node3.left = node2;
                return;
            } else {
                node3.right = node2;
                return;
            }
        }
        this.root = node2;
    }

    private void rebalance(com.google.gson.internal.LinkedTreeMap.Node<K_renamed, V_renamed> node, boolean z_renamed) {
        while (node != null) {
            com.google.gson.internal.LinkedTreeMap.Node<K_renamed, V_renamed> node2 = node.left;
            com.google.gson.internal.LinkedTreeMap.Node<K_renamed, V_renamed> node3 = node.right;
            int i_renamed = node2 != null ? node2.height : 0;
            int i2 = node3 != null ? node3.height : 0;
            int i3 = i_renamed - i2;
            if (i3 == -2) {
                com.google.gson.internal.LinkedTreeMap.Node<K_renamed, V_renamed> node4 = node3.left;
                com.google.gson.internal.LinkedTreeMap.Node<K_renamed, V_renamed> node5 = node3.right;
                int i4 = (node4 != null ? node4.height : 0) - (node5 != null ? node5.height : 0);
                if (i4 == -1 || (i4 == 0 && !z_renamed)) {
                    rotateLeft(node);
                } else {
                    rotateRight(node3);
                    rotateLeft(node);
                }
                if (z_renamed) {
                    return;
                }
            } else if (i3 == 2) {
                com.google.gson.internal.LinkedTreeMap.Node<K_renamed, V_renamed> node6 = node2.left;
                com.google.gson.internal.LinkedTreeMap.Node<K_renamed, V_renamed> node7 = node2.right;
                int i5 = (node6 != null ? node6.height : 0) - (node7 != null ? node7.height : 0);
                if (i5 == 1 || (i5 == 0 && !z_renamed)) {
                    rotateRight(node);
                } else {
                    rotateLeft(node2);
                    rotateRight(node);
                }
                if (z_renamed) {
                    return;
                }
            } else if (i3 == 0) {
                node.height = i_renamed + 1;
                if (z_renamed) {
                    return;
                }
            } else {
                node.height = java.lang.Math.max(i_renamed, i2) + 1;
                if (!z_renamed) {
                    return;
                }
            }
            node = node.parent;
        }
    }

    private void rotateLeft(com.google.gson.internal.LinkedTreeMap.Node<K_renamed, V_renamed> node) {
        com.google.gson.internal.LinkedTreeMap.Node<K_renamed, V_renamed> node2 = node.left;
        com.google.gson.internal.LinkedTreeMap.Node<K_renamed, V_renamed> node3 = node.right;
        com.google.gson.internal.LinkedTreeMap.Node<K_renamed, V_renamed> node4 = node3.left;
        com.google.gson.internal.LinkedTreeMap.Node<K_renamed, V_renamed> node5 = node3.right;
        node.right = node4;
        if (node4 != null) {
            node4.parent = node;
        }
        replaceInParent(node, node3);
        node3.left = node;
        node.parent = node3;
        node.height = java.lang.Math.max(node2 != null ? node2.height : 0, node4 != null ? node4.height : 0) + 1;
        node3.height = java.lang.Math.max(node.height, node5 != null ? node5.height : 0) + 1;
    }

    private void rotateRight(com.google.gson.internal.LinkedTreeMap.Node<K_renamed, V_renamed> node) {
        com.google.gson.internal.LinkedTreeMap.Node<K_renamed, V_renamed> node2 = node.left;
        com.google.gson.internal.LinkedTreeMap.Node<K_renamed, V_renamed> node3 = node.right;
        com.google.gson.internal.LinkedTreeMap.Node<K_renamed, V_renamed> node4 = node2.left;
        com.google.gson.internal.LinkedTreeMap.Node<K_renamed, V_renamed> node5 = node2.right;
        node.left = node5;
        if (node5 != null) {
            node5.parent = node;
        }
        replaceInParent(node, node2);
        node2.right = node;
        node.parent = node2;
        node.height = java.lang.Math.max(node3 != null ? node3.height : 0, node5 != null ? node5.height : 0) + 1;
        node2.height = java.lang.Math.max(node.height, node4 != null ? node4.height : 0) + 1;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public java.util.Set<java.util.Map.Entry<K_renamed, V_renamed>> entrySet() {
        com.google.gson.internal.LinkedTreeMap<K_renamed, V_renamed>.EntrySet entrySet = this.entrySet;
        if (entrySet != null) {
            return entrySet;
        }
        com.google.gson.internal.LinkedTreeMap<K_renamed, V_renamed>.EntrySet entrySet2 = new com.google.gson.internal.LinkedTreeMap.EntrySet();
        this.entrySet = entrySet2;
        return entrySet2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public java.util.Set<K_renamed> keySet() {
        com.google.gson.internal.LinkedTreeMap<K_renamed, V_renamed>.KeySet keySet = this.keySet;
        if (keySet != null) {
            return keySet;
        }
        com.google.gson.internal.LinkedTreeMap<K_renamed, V_renamed>.KeySet keySet2 = new com.google.gson.internal.LinkedTreeMap.KeySet();
        this.keySet = keySet2;
        return keySet2;
    }

    static final class Node<K_renamed, V_renamed> implements java.util.Map.Entry<K_renamed, V_renamed> {
        int height;
        final K_renamed key;
        com.google.gson.internal.LinkedTreeMap.Node<K_renamed, V_renamed> left;
        com.google.gson.internal.LinkedTreeMap.Node<K_renamed, V_renamed> next;
        com.google.gson.internal.LinkedTreeMap.Node<K_renamed, V_renamed> parent;
        com.google.gson.internal.LinkedTreeMap.Node<K_renamed, V_renamed> prev;
        com.google.gson.internal.LinkedTreeMap.Node<K_renamed, V_renamed> right;
        V_renamed value;

        Node() {
            this.key = null;
            this.prev = this;
            this.next = this;
        }

        Node(com.google.gson.internal.LinkedTreeMap.Node<K_renamed, V_renamed> node, K_renamed k_renamed, com.google.gson.internal.LinkedTreeMap.Node<K_renamed, V_renamed> node2, com.google.gson.internal.LinkedTreeMap.Node<K_renamed, V_renamed> node3) {
            this.parent = node;
            this.key = k_renamed;
            this.height = 1;
            this.next = node2;
            this.prev = node3;
            node3.next = this;
            node2.prev = this;
        }

        @Override // java.util.Map.Entry
        public K_renamed getKey() {
            return this.key;
        }

        @Override // java.util.Map.Entry
        public V_renamed getValue() {
            return this.value;
        }

        @Override // java.util.Map.Entry
        public V_renamed setValue(V_renamed v_renamed) {
            V_renamed v2 = this.value;
            this.value = v_renamed;
            return v2;
        }

        @Override // java.util.Map.Entry
        public boolean equals(java.lang.Object obj) {
            if (!(obj instanceof java.util.Map.Entry)) {
                return false;
            }
            java.util.Map.Entry entry = (java.util.Map.Entry) obj;
            K_renamed k_renamed = this.key;
            if (k_renamed == null) {
                if (entry.getKey() != null) {
                    return false;
                }
            } else if (!k_renamed.equals(entry.getKey())) {
                return false;
            }
            V_renamed v_renamed = this.value;
            if (v_renamed == null) {
                if (entry.getValue() != null) {
                    return false;
                }
            } else if (!v_renamed.equals(entry.getValue())) {
                return false;
            }
            return true;
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

        public com.google.gson.internal.LinkedTreeMap.Node<K_renamed, V_renamed> first() {
            com.google.gson.internal.LinkedTreeMap.Node<K_renamed, V_renamed> node = this.left;
            while (true) {
                com.google.gson.internal.LinkedTreeMap.Node<K_renamed, V_renamed> node2 = node;
                com.google.gson.internal.LinkedTreeMap.Node<K_renamed, V_renamed> node3 = this;
                this = node2;
                if (this == null) {
                    return node3;
                }
                node = this.left;
            }
        }

        public com.google.gson.internal.LinkedTreeMap.Node<K_renamed, V_renamed> last() {
            com.google.gson.internal.LinkedTreeMap.Node<K_renamed, V_renamed> node = this.right;
            while (true) {
                com.google.gson.internal.LinkedTreeMap.Node<K_renamed, V_renamed> node2 = node;
                com.google.gson.internal.LinkedTreeMap.Node<K_renamed, V_renamed> node3 = this;
                this = node2;
                if (this == null) {
                    return node3;
                }
                node = this.right;
            }
        }
    }

    private abstract class LinkedTreeMapIterator<T_renamed> implements java.util.Iterator<T_renamed> {
        int expectedModCount;
        com.google.gson.internal.LinkedTreeMap.Node<K_renamed, V_renamed> lastReturned = null;
        com.google.gson.internal.LinkedTreeMap.Node<K_renamed, V_renamed> next;

        LinkedTreeMapIterator() {
            this.next = com.google.gson.internal.LinkedTreeMap.this.header.next;
            this.expectedModCount = com.google.gson.internal.LinkedTreeMap.this.modCount;
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            return this.next != com.google.gson.internal.LinkedTreeMap.this.header;
        }

        final com.google.gson.internal.LinkedTreeMap.Node<K_renamed, V_renamed> nextNode() {
            com.google.gson.internal.LinkedTreeMap.Node<K_renamed, V_renamed> node = this.next;
            if (node == com.google.gson.internal.LinkedTreeMap.this.header) {
                throw new java.util.NoSuchElementException();
            }
            if (com.google.gson.internal.LinkedTreeMap.this.modCount != this.expectedModCount) {
                throw new java.util.ConcurrentModificationException();
            }
            this.next = node.next;
            this.lastReturned = node;
            return node;
        }

        @Override // java.util.Iterator
        public final void remove() {
            com.google.gson.internal.LinkedTreeMap.Node<K_renamed, V_renamed> node = this.lastReturned;
            if (node == null) {
                throw new java.lang.IllegalStateException();
            }
            com.google.gson.internal.LinkedTreeMap.this.removeInternal(node, true);
            this.lastReturned = null;
            this.expectedModCount = com.google.gson.internal.LinkedTreeMap.this.modCount;
        }
    }

    class EntrySet extends java.util.AbstractSet<java.util.Map.Entry<K_renamed, V_renamed>> {
        EntrySet() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return com.google.gson.internal.LinkedTreeMap.this.size;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public java.util.Iterator<java.util.Map.Entry<K_renamed, V_renamed>> iterator() {
            return new com.google.gson.internal.LinkedTreeMap<K_renamed, V_renamed>.LinkedTreeMapIterator<java.util.Map.Entry<K_renamed, V_renamed>>() { // from class: com.google.gson.internal.LinkedTreeMap.EntrySet.1
                {
                    com.google.gson.internal.LinkedTreeMap linkedTreeMap = com.google.gson.internal.LinkedTreeMap.this;
                }

                @Override // java.util.Iterator
                public java.util.Map.Entry<K_renamed, V_renamed> next() {
                    return nextNode();
                }
            };
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(java.lang.Object obj) {
            return (obj instanceof java.util.Map.Entry) && com.google.gson.internal.LinkedTreeMap.this.findByEntry((java.util.Map.Entry) obj) != null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(java.lang.Object obj) {
            com.google.gson.internal.LinkedTreeMap.Node<K_renamed, V_renamed> nodeFindByEntry;
            if (!(obj instanceof java.util.Map.Entry) || (nodeFindByEntry = com.google.gson.internal.LinkedTreeMap.this.findByEntry((java.util.Map.Entry) obj)) == null) {
                return false;
            }
            com.google.gson.internal.LinkedTreeMap.this.removeInternal(nodeFindByEntry, true);
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            com.google.gson.internal.LinkedTreeMap.this.clear();
        }
    }

    final class KeySet extends java.util.AbstractSet<K_renamed> {
        KeySet() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return com.google.gson.internal.LinkedTreeMap.this.size;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public java.util.Iterator<K_renamed> iterator() {
            return new com.google.gson.internal.LinkedTreeMap<K_renamed, V_renamed>.LinkedTreeMapIterator<K_renamed>() { // from class: com.google.gson.internal.LinkedTreeMap.KeySet.1
                {
                    com.google.gson.internal.LinkedTreeMap linkedTreeMap = com.google.gson.internal.LinkedTreeMap.this;
                }

                @Override // java.util.Iterator
                public K_renamed next() {
                    return nextNode().key;
                }
            };
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(java.lang.Object obj) {
            return com.google.gson.internal.LinkedTreeMap.this.containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(java.lang.Object obj) {
            return com.google.gson.internal.LinkedTreeMap.this.removeInternalByKey(obj) != null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            com.google.gson.internal.LinkedTreeMap.this.clear();
        }
    }

    private java.lang.Object writeReplace() throws java.io.ObjectStreamException {
        return new java.util.LinkedHashMap(this);
    }
}

package com.google.gson.internal;

/* loaded from: classes.dex */
public final class LinkedHashTreeMap<K_renamed, V_renamed> extends java.util.AbstractMap<K_renamed, V_renamed> implements java.io.Serializable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final java.util.Comparator<java.lang.Comparable> NATURAL_ORDER = new java.util.Comparator<java.lang.Comparable>() { // from class: com.google.gson.internal.LinkedHashTreeMap.1
        @Override // java.util.Comparator
        public int compare(java.lang.Comparable comparable, java.lang.Comparable comparable2) {
            return comparable.compareTo(comparable2);
        }
    };
    java.util.Comparator<? super K_renamed> comparator;
    private com.google.gson.internal.LinkedHashTreeMap<K_renamed, V_renamed>.EntrySet entrySet;
    final com.google.gson.internal.LinkedHashTreeMap.Node<K_renamed, V_renamed> header;
    private com.google.gson.internal.LinkedHashTreeMap<K_renamed, V_renamed>.KeySet keySet;
    int modCount;
    int size;
    com.google.gson.internal.LinkedHashTreeMap.Node<K_renamed, V_renamed>[] table;
    int threshold;

    private static int secondaryHash(int i_renamed) {
        int i2 = i_renamed ^ ((i_renamed >>> 20) ^ (i_renamed >>> 12));
        return (i2 >>> 4) ^ ((i2 >>> 7) ^ i2);
    }

    public LinkedHashTreeMap() {
        this(NATURAL_ORDER);
    }

    public LinkedHashTreeMap(java.util.Comparator<? super K_renamed> comparator) {
        this.size = 0;
        this.modCount = 0;
        this.comparator = comparator == null ? NATURAL_ORDER : comparator;
        this.header = new com.google.gson.internal.LinkedHashTreeMap.Node<>();
        this.table = new com.google.gson.internal.LinkedHashTreeMap.Node[16];
        com.google.gson.internal.LinkedHashTreeMap.Node<K_renamed, V_renamed>[] nodeArr = this.table;
        this.threshold = (nodeArr.length / 2) + (nodeArr.length / 4);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.size;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V_renamed get(java.lang.Object obj) {
        com.google.gson.internal.LinkedHashTreeMap.Node<K_renamed, V_renamed> nodeFindByObject = findByObject(obj);
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
        com.google.gson.internal.LinkedHashTreeMap.Node<K_renamed, V_renamed> nodeFind = find(k_renamed, true);
        V_renamed v2 = nodeFind.value;
        nodeFind.value = v_renamed;
        return v2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        java.util.Arrays.fill(this.table, (java.lang.Object) null);
        this.size = 0;
        this.modCount++;
        com.google.gson.internal.LinkedHashTreeMap.Node<K_renamed, V_renamed> node = this.header;
        com.google.gson.internal.LinkedHashTreeMap.Node<K_renamed, V_renamed> node2 = node.next;
        while (node2 != node) {
            com.google.gson.internal.LinkedHashTreeMap.Node<K_renamed, V_renamed> node3 = node2.next;
            node2.prev = null;
            node2.next = null;
            node2 = node3;
        }
        node.prev = node;
        node.next = node;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V_renamed remove(java.lang.Object obj) {
        com.google.gson.internal.LinkedHashTreeMap.Node<K_renamed, V_renamed> nodeRemoveInternalByKey = removeInternalByKey(obj);
        if (nodeRemoveInternalByKey != null) {
            return nodeRemoveInternalByKey.value;
        }
        return null;
    }

    com.google.gson.internal.LinkedHashTreeMap.Node<K_renamed, V_renamed> find(K_renamed k_renamed, boolean z_renamed) {
        int iCompare;
        com.google.gson.internal.LinkedHashTreeMap.Node<K_renamed, V_renamed> node;
        java.util.Comparator<? super K_renamed> comparator = this.comparator;
        com.google.gson.internal.LinkedHashTreeMap.Node<K_renamed, V_renamed>[] nodeArr = this.table;
        int iSecondaryHash = secondaryHash(k_renamed.hashCode());
        int length = (nodeArr.length - 1) & iSecondaryHash;
        com.google.gson.internal.LinkedHashTreeMap.Node<K_renamed, V_renamed> node2 = nodeArr[length];
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
                com.google.gson.internal.LinkedHashTreeMap.Node<K_renamed, V_renamed> node3 = iCompare < 0 ? node2.left : node2.right;
                if (node3 == null) {
                    break;
                }
                node2 = node3;
            }
        } else {
            iCompare = 0;
        }
        com.google.gson.internal.LinkedHashTreeMap.Node<K_renamed, V_renamed> node4 = node2;
        int i_renamed = iCompare;
        if (!z_renamed) {
            return null;
        }
        com.google.gson.internal.LinkedHashTreeMap.Node<K_renamed, V_renamed> node5 = this.header;
        if (node4 == null) {
            if (comparator == NATURAL_ORDER && !(k_renamed instanceof java.lang.Comparable)) {
                throw new java.lang.ClassCastException(k_renamed.getClass().getName() + " is_renamed not Comparable");
            }
            node = new com.google.gson.internal.LinkedHashTreeMap.Node<>(node4, k_renamed, iSecondaryHash, node5, node5.prev);
            nodeArr[length] = node;
        } else {
            node = new com.google.gson.internal.LinkedHashTreeMap.Node<>(node4, k_renamed, iSecondaryHash, node5, node5.prev);
            if (i_renamed < 0) {
                node4.left = node;
            } else {
                node4.right = node;
            }
            rebalance(node4, true);
        }
        int i2 = this.size;
        this.size = i2 + 1;
        if (i2 > this.threshold) {
            doubleCapacity();
        }
        this.modCount++;
        return node;
    }

    /* JADX WARN: Multi-variable type inference failed */
    com.google.gson.internal.LinkedHashTreeMap.Node<K_renamed, V_renamed> findByObject(java.lang.Object obj) {
        if (obj == 0) {
            return null;
        }
        try {
            return find(obj, false);
        } catch (java.lang.ClassCastException unused) {
            return null;
        }
    }

    com.google.gson.internal.LinkedHashTreeMap.Node<K_renamed, V_renamed> findByEntry(java.util.Map.Entry<?, ?> entry) {
        com.google.gson.internal.LinkedHashTreeMap.Node<K_renamed, V_renamed> nodeFindByObject = findByObject(entry.getKey());
        if (nodeFindByObject != null && equal(nodeFindByObject.value, entry.getValue())) {
            return nodeFindByObject;
        }
        return null;
    }

    private boolean equal(java.lang.Object obj, java.lang.Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    void removeInternal(com.google.gson.internal.LinkedHashTreeMap.Node<K_renamed, V_renamed> node, boolean z_renamed) {
        int i_renamed;
        if (z_renamed) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            node.prev = null;
            node.next = null;
        }
        com.google.gson.internal.LinkedHashTreeMap.Node<K_renamed, V_renamed> node2 = node.left;
        com.google.gson.internal.LinkedHashTreeMap.Node<K_renamed, V_renamed> node3 = node.right;
        com.google.gson.internal.LinkedHashTreeMap.Node<K_renamed, V_renamed> node4 = node.parent;
        int i2 = 0;
        if (node2 != null && node3 != null) {
            com.google.gson.internal.LinkedHashTreeMap.Node<K_renamed, V_renamed> nodeLast = node2.height > node3.height ? node2.last() : node3.first();
            removeInternal(nodeLast, false);
            com.google.gson.internal.LinkedHashTreeMap.Node<K_renamed, V_renamed> node5 = node.left;
            if (node5 != null) {
                i_renamed = node5.height;
                nodeLast.left = node5;
                node5.parent = nodeLast;
                node.left = null;
            } else {
                i_renamed = 0;
            }
            com.google.gson.internal.LinkedHashTreeMap.Node<K_renamed, V_renamed> node6 = node.right;
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

    com.google.gson.internal.LinkedHashTreeMap.Node<K_renamed, V_renamed> removeInternalByKey(java.lang.Object obj) {
        com.google.gson.internal.LinkedHashTreeMap.Node<K_renamed, V_renamed> nodeFindByObject = findByObject(obj);
        if (nodeFindByObject != null) {
            removeInternal(nodeFindByObject, true);
        }
        return nodeFindByObject;
    }

    private void replaceInParent(com.google.gson.internal.LinkedHashTreeMap.Node<K_renamed, V_renamed> node, com.google.gson.internal.LinkedHashTreeMap.Node<K_renamed, V_renamed> node2) {
        com.google.gson.internal.LinkedHashTreeMap.Node<K_renamed, V_renamed> node3 = node.parent;
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
        int i_renamed = node.hash;
        this.table[i_renamed & (r2.length - 1)] = node2;
    }

    private void rebalance(com.google.gson.internal.LinkedHashTreeMap.Node<K_renamed, V_renamed> node, boolean z_renamed) {
        while (node != null) {
            com.google.gson.internal.LinkedHashTreeMap.Node<K_renamed, V_renamed> node2 = node.left;
            com.google.gson.internal.LinkedHashTreeMap.Node<K_renamed, V_renamed> node3 = node.right;
            int i_renamed = node2 != null ? node2.height : 0;
            int i2 = node3 != null ? node3.height : 0;
            int i3 = i_renamed - i2;
            if (i3 == -2) {
                com.google.gson.internal.LinkedHashTreeMap.Node<K_renamed, V_renamed> node4 = node3.left;
                com.google.gson.internal.LinkedHashTreeMap.Node<K_renamed, V_renamed> node5 = node3.right;
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
                com.google.gson.internal.LinkedHashTreeMap.Node<K_renamed, V_renamed> node6 = node2.left;
                com.google.gson.internal.LinkedHashTreeMap.Node<K_renamed, V_renamed> node7 = node2.right;
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

    private void rotateLeft(com.google.gson.internal.LinkedHashTreeMap.Node<K_renamed, V_renamed> node) {
        com.google.gson.internal.LinkedHashTreeMap.Node<K_renamed, V_renamed> node2 = node.left;
        com.google.gson.internal.LinkedHashTreeMap.Node<K_renamed, V_renamed> node3 = node.right;
        com.google.gson.internal.LinkedHashTreeMap.Node<K_renamed, V_renamed> node4 = node3.left;
        com.google.gson.internal.LinkedHashTreeMap.Node<K_renamed, V_renamed> node5 = node3.right;
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

    private void rotateRight(com.google.gson.internal.LinkedHashTreeMap.Node<K_renamed, V_renamed> node) {
        com.google.gson.internal.LinkedHashTreeMap.Node<K_renamed, V_renamed> node2 = node.left;
        com.google.gson.internal.LinkedHashTreeMap.Node<K_renamed, V_renamed> node3 = node.right;
        com.google.gson.internal.LinkedHashTreeMap.Node<K_renamed, V_renamed> node4 = node2.left;
        com.google.gson.internal.LinkedHashTreeMap.Node<K_renamed, V_renamed> node5 = node2.right;
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
        com.google.gson.internal.LinkedHashTreeMap<K_renamed, V_renamed>.EntrySet entrySet = this.entrySet;
        if (entrySet != null) {
            return entrySet;
        }
        com.google.gson.internal.LinkedHashTreeMap<K_renamed, V_renamed>.EntrySet entrySet2 = new com.google.gson.internal.LinkedHashTreeMap.EntrySet();
        this.entrySet = entrySet2;
        return entrySet2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public java.util.Set<K_renamed> keySet() {
        com.google.gson.internal.LinkedHashTreeMap<K_renamed, V_renamed>.KeySet keySet = this.keySet;
        if (keySet != null) {
            return keySet;
        }
        com.google.gson.internal.LinkedHashTreeMap<K_renamed, V_renamed>.KeySet keySet2 = new com.google.gson.internal.LinkedHashTreeMap.KeySet();
        this.keySet = keySet2;
        return keySet2;
    }

    static final class Node<K_renamed, V_renamed> implements java.util.Map.Entry<K_renamed, V_renamed> {
        final int hash;
        int height;
        final K_renamed key;
        com.google.gson.internal.LinkedHashTreeMap.Node<K_renamed, V_renamed> left;
        com.google.gson.internal.LinkedHashTreeMap.Node<K_renamed, V_renamed> next;
        com.google.gson.internal.LinkedHashTreeMap.Node<K_renamed, V_renamed> parent;
        com.google.gson.internal.LinkedHashTreeMap.Node<K_renamed, V_renamed> prev;
        com.google.gson.internal.LinkedHashTreeMap.Node<K_renamed, V_renamed> right;
        V_renamed value;

        Node() {
            this.key = null;
            this.hash = -1;
            this.prev = this;
            this.next = this;
        }

        Node(com.google.gson.internal.LinkedHashTreeMap.Node<K_renamed, V_renamed> node, K_renamed k_renamed, int i_renamed, com.google.gson.internal.LinkedHashTreeMap.Node<K_renamed, V_renamed> node2, com.google.gson.internal.LinkedHashTreeMap.Node<K_renamed, V_renamed> node3) {
            this.parent = node;
            this.key = k_renamed;
            this.hash = i_renamed;
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

        public com.google.gson.internal.LinkedHashTreeMap.Node<K_renamed, V_renamed> first() {
            com.google.gson.internal.LinkedHashTreeMap.Node<K_renamed, V_renamed> node = this.left;
            while (true) {
                com.google.gson.internal.LinkedHashTreeMap.Node<K_renamed, V_renamed> node2 = node;
                com.google.gson.internal.LinkedHashTreeMap.Node<K_renamed, V_renamed> node3 = this;
                this = node2;
                if (this == null) {
                    return node3;
                }
                node = this.left;
            }
        }

        public com.google.gson.internal.LinkedHashTreeMap.Node<K_renamed, V_renamed> last() {
            com.google.gson.internal.LinkedHashTreeMap.Node<K_renamed, V_renamed> node = this.right;
            while (true) {
                com.google.gson.internal.LinkedHashTreeMap.Node<K_renamed, V_renamed> node2 = node;
                com.google.gson.internal.LinkedHashTreeMap.Node<K_renamed, V_renamed> node3 = this;
                this = node2;
                if (this == null) {
                    return node3;
                }
                node = this.right;
            }
        }
    }

    private void doubleCapacity() {
        this.table = doubleCapacity(this.table);
        com.google.gson.internal.LinkedHashTreeMap.Node<K_renamed, V_renamed>[] nodeArr = this.table;
        this.threshold = (nodeArr.length / 2) + (nodeArr.length / 4);
    }

    static <K_renamed, V_renamed> com.google.gson.internal.LinkedHashTreeMap.Node<K_renamed, V_renamed>[] doubleCapacity(com.google.gson.internal.LinkedHashTreeMap.Node<K_renamed, V_renamed>[] nodeArr) {
        int length = nodeArr.length;
        com.google.gson.internal.LinkedHashTreeMap.Node<K_renamed, V_renamed>[] nodeArr2 = new com.google.gson.internal.LinkedHashTreeMap.Node[length * 2];
        com.google.gson.internal.LinkedHashTreeMap.AvlIterator avlIterator = new com.google.gson.internal.LinkedHashTreeMap.AvlIterator();
        com.google.gson.internal.LinkedHashTreeMap.AvlBuilder avlBuilder = new com.google.gson.internal.LinkedHashTreeMap.AvlBuilder();
        com.google.gson.internal.LinkedHashTreeMap.AvlBuilder avlBuilder2 = new com.google.gson.internal.LinkedHashTreeMap.AvlBuilder();
        for (int i_renamed = 0; i_renamed < length; i_renamed++) {
            com.google.gson.internal.LinkedHashTreeMap.Node<K_renamed, V_renamed> node = nodeArr[i_renamed];
            if (node != null) {
                avlIterator.reset(node);
                int i2 = 0;
                int i3 = 0;
                while (true) {
                    com.google.gson.internal.LinkedHashTreeMap.Node<K_renamed, V_renamed> next = avlIterator.next();
                    if (next == null) {
                        break;
                    }
                    if ((next.hash & length) == 0) {
                        i2++;
                    } else {
                        i3++;
                    }
                }
                avlBuilder.reset(i2);
                avlBuilder2.reset(i3);
                avlIterator.reset(node);
                while (true) {
                    com.google.gson.internal.LinkedHashTreeMap.Node<K_renamed, V_renamed> next2 = avlIterator.next();
                    if (next2 == null) {
                        break;
                    }
                    if ((next2.hash & length) == 0) {
                        avlBuilder.add(next2);
                    } else {
                        avlBuilder2.add(next2);
                    }
                }
                nodeArr2[i_renamed] = i2 > 0 ? avlBuilder.root() : null;
                nodeArr2[i_renamed + length] = i3 > 0 ? avlBuilder2.root() : null;
            }
        }
        return nodeArr2;
    }

    static class AvlIterator<K_renamed, V_renamed> {
        private com.google.gson.internal.LinkedHashTreeMap.Node<K_renamed, V_renamed> stackTop;

        AvlIterator() {
        }

        void reset(com.google.gson.internal.LinkedHashTreeMap.Node<K_renamed, V_renamed> node) {
            com.google.gson.internal.LinkedHashTreeMap.Node<K_renamed, V_renamed> node2 = null;
            while (true) {
                com.google.gson.internal.LinkedHashTreeMap.Node<K_renamed, V_renamed> node3 = node2;
                node2 = node;
                if (node2 != null) {
                    node2.parent = node3;
                    node = node2.left;
                } else {
                    this.stackTop = node3;
                    return;
                }
            }
        }

        public com.google.gson.internal.LinkedHashTreeMap.Node<K_renamed, V_renamed> next() {
            com.google.gson.internal.LinkedHashTreeMap.Node<K_renamed, V_renamed> node = this.stackTop;
            if (node == null) {
                return null;
            }
            com.google.gson.internal.LinkedHashTreeMap.Node<K_renamed, V_renamed> node2 = node.parent;
            node.parent = null;
            com.google.gson.internal.LinkedHashTreeMap.Node<K_renamed, V_renamed> node3 = node.right;
            while (true) {
                com.google.gson.internal.LinkedHashTreeMap.Node<K_renamed, V_renamed> node4 = node2;
                node2 = node3;
                if (node2 != null) {
                    node2.parent = node4;
                    node3 = node2.left;
                } else {
                    this.stackTop = node4;
                    return node;
                }
            }
        }
    }

    static final class AvlBuilder<K_renamed, V_renamed> {
        private int leavesSkipped;
        private int leavesToSkip;
        private int size;
        private com.google.gson.internal.LinkedHashTreeMap.Node<K_renamed, V_renamed> stack;

        AvlBuilder() {
        }

        void reset(int i_renamed) {
            this.leavesToSkip = ((java.lang.Integer.highestOneBit(i_renamed) * 2) - 1) - i_renamed;
            this.size = 0;
            this.leavesSkipped = 0;
            this.stack = null;
        }

        void add(com.google.gson.internal.LinkedHashTreeMap.Node<K_renamed, V_renamed> node) {
            node.right = null;
            node.parent = null;
            node.left = null;
            node.height = 1;
            int i_renamed = this.leavesToSkip;
            if (i_renamed > 0) {
                int i2 = this.size;
                if ((i2 & 1) == 0) {
                    this.size = i2 + 1;
                    this.leavesToSkip = i_renamed - 1;
                    this.leavesSkipped++;
                }
            }
            node.parent = this.stack;
            this.stack = node;
            this.size++;
            int i3 = this.leavesToSkip;
            if (i3 > 0) {
                int i4 = this.size;
                if ((i4 & 1) == 0) {
                    this.size = i4 + 1;
                    this.leavesToSkip = i3 - 1;
                    this.leavesSkipped++;
                }
            }
            int i5 = 4;
            while (true) {
                int i6 = i5 - 1;
                if ((this.size & i6) != i6) {
                    return;
                }
                int i7 = this.leavesSkipped;
                if (i7 == 0) {
                    com.google.gson.internal.LinkedHashTreeMap.Node<K_renamed, V_renamed> node2 = this.stack;
                    com.google.gson.internal.LinkedHashTreeMap.Node<K_renamed, V_renamed> node3 = node2.parent;
                    com.google.gson.internal.LinkedHashTreeMap.Node<K_renamed, V_renamed> node4 = node3.parent;
                    node3.parent = node4.parent;
                    this.stack = node3;
                    node3.left = node4;
                    node3.right = node2;
                    node3.height = node2.height + 1;
                    node4.parent = node3;
                    node2.parent = node3;
                } else if (i7 == 1) {
                    com.google.gson.internal.LinkedHashTreeMap.Node<K_renamed, V_renamed> node5 = this.stack;
                    com.google.gson.internal.LinkedHashTreeMap.Node<K_renamed, V_renamed> node6 = node5.parent;
                    this.stack = node6;
                    node6.right = node5;
                    node6.height = node5.height + 1;
                    node5.parent = node6;
                    this.leavesSkipped = 0;
                } else if (i7 == 2) {
                    this.leavesSkipped = 0;
                }
                i5 *= 2;
            }
        }

        com.google.gson.internal.LinkedHashTreeMap.Node<K_renamed, V_renamed> root() {
            com.google.gson.internal.LinkedHashTreeMap.Node<K_renamed, V_renamed> node = this.stack;
            if (node.parent == null) {
                return node;
            }
            throw new java.lang.IllegalStateException();
        }
    }

    private abstract class LinkedTreeMapIterator<T_renamed> implements java.util.Iterator<T_renamed> {
        int expectedModCount;
        com.google.gson.internal.LinkedHashTreeMap.Node<K_renamed, V_renamed> lastReturned = null;
        com.google.gson.internal.LinkedHashTreeMap.Node<K_renamed, V_renamed> next;

        LinkedTreeMapIterator() {
            this.next = com.google.gson.internal.LinkedHashTreeMap.this.header.next;
            this.expectedModCount = com.google.gson.internal.LinkedHashTreeMap.this.modCount;
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            return this.next != com.google.gson.internal.LinkedHashTreeMap.this.header;
        }

        final com.google.gson.internal.LinkedHashTreeMap.Node<K_renamed, V_renamed> nextNode() {
            com.google.gson.internal.LinkedHashTreeMap.Node<K_renamed, V_renamed> node = this.next;
            if (node == com.google.gson.internal.LinkedHashTreeMap.this.header) {
                throw new java.util.NoSuchElementException();
            }
            if (com.google.gson.internal.LinkedHashTreeMap.this.modCount != this.expectedModCount) {
                throw new java.util.ConcurrentModificationException();
            }
            this.next = node.next;
            this.lastReturned = node;
            return node;
        }

        @Override // java.util.Iterator
        public final void remove() {
            com.google.gson.internal.LinkedHashTreeMap.Node<K_renamed, V_renamed> node = this.lastReturned;
            if (node == null) {
                throw new java.lang.IllegalStateException();
            }
            com.google.gson.internal.LinkedHashTreeMap.this.removeInternal(node, true);
            this.lastReturned = null;
            this.expectedModCount = com.google.gson.internal.LinkedHashTreeMap.this.modCount;
        }
    }

    final class EntrySet extends java.util.AbstractSet<java.util.Map.Entry<K_renamed, V_renamed>> {
        EntrySet() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return com.google.gson.internal.LinkedHashTreeMap.this.size;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public java.util.Iterator<java.util.Map.Entry<K_renamed, V_renamed>> iterator() {
            return new com.google.gson.internal.LinkedHashTreeMap<K_renamed, V_renamed>.LinkedTreeMapIterator<java.util.Map.Entry<K_renamed, V_renamed>>() { // from class: com.google.gson.internal.LinkedHashTreeMap.EntrySet.1
                {
                    com.google.gson.internal.LinkedHashTreeMap linkedHashTreeMap = com.google.gson.internal.LinkedHashTreeMap.this;
                }

                @Override // java.util.Iterator
                public java.util.Map.Entry<K_renamed, V_renamed> next() {
                    return nextNode();
                }
            };
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(java.lang.Object obj) {
            return (obj instanceof java.util.Map.Entry) && com.google.gson.internal.LinkedHashTreeMap.this.findByEntry((java.util.Map.Entry) obj) != null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(java.lang.Object obj) {
            com.google.gson.internal.LinkedHashTreeMap.Node<K_renamed, V_renamed> nodeFindByEntry;
            if (!(obj instanceof java.util.Map.Entry) || (nodeFindByEntry = com.google.gson.internal.LinkedHashTreeMap.this.findByEntry((java.util.Map.Entry) obj)) == null) {
                return false;
            }
            com.google.gson.internal.LinkedHashTreeMap.this.removeInternal(nodeFindByEntry, true);
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            com.google.gson.internal.LinkedHashTreeMap.this.clear();
        }
    }

    final class KeySet extends java.util.AbstractSet<K_renamed> {
        KeySet() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return com.google.gson.internal.LinkedHashTreeMap.this.size;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public java.util.Iterator<K_renamed> iterator() {
            return new com.google.gson.internal.LinkedHashTreeMap<K_renamed, V_renamed>.LinkedTreeMapIterator<K_renamed>() { // from class: com.google.gson.internal.LinkedHashTreeMap.KeySet.1
                {
                    com.google.gson.internal.LinkedHashTreeMap linkedHashTreeMap = com.google.gson.internal.LinkedHashTreeMap.this;
                }

                @Override // java.util.Iterator
                public K_renamed next() {
                    return nextNode().key;
                }
            };
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(java.lang.Object obj) {
            return com.google.gson.internal.LinkedHashTreeMap.this.containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(java.lang.Object obj) {
            return com.google.gson.internal.LinkedHashTreeMap.this.removeInternalByKey(obj) != null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            com.google.gson.internal.LinkedHashTreeMap.this.clear();
        }
    }

    private java.lang.Object writeReplace() throws java.io.ObjectStreamException {
        return new java.util.LinkedHashMap(this);
    }
}

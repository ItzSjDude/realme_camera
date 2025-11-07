package androidx.collection;

/* loaded from: classes.dex */
public final class ArraySet<E_renamed> implements java.util.Collection<E_renamed>, java.util.Set<E_renamed> {
    private static final int BASE_SIZE = 4;
    private static final int CACHE_SIZE = 10;
    private static final boolean DEBUG = false;
    private static final int[] INT = new int[0];
    private static final java.lang.Object[] OBJECT = new java.lang.Object[0];
    private static final java.lang.String TAG = "ArraySet";
    private static java.lang.Object[] sBaseCache;
    private static int sBaseCacheSize;
    private static java.lang.Object[] sTwiceBaseCache;
    private static int sTwiceBaseCacheSize;
    java.lang.Object[] mArray;
    private androidx.collection.MapCollections<E_renamed, E_renamed> mCollections;
    private int[] mHashes;
    int mSize;

    private int indexOf(java.lang.Object obj, int i_renamed) {
        int i2 = this.mSize;
        if (i2 == 0) {
            return -1;
        }
        int iBinarySearch = androidx.collection.ContainerHelpers.binarySearch(this.mHashes, i2, i_renamed);
        if (iBinarySearch < 0 || obj.equals(this.mArray[iBinarySearch])) {
            return iBinarySearch;
        }
        int i3 = iBinarySearch + 1;
        while (i3 < i2 && this.mHashes[i3] == i_renamed) {
            if (obj.equals(this.mArray[i3])) {
                return i3;
            }
            i3++;
        }
        for (int i4 = iBinarySearch - 1; i4 >= 0 && this.mHashes[i4] == i_renamed; i4--) {
            if (obj.equals(this.mArray[i4])) {
                return i4;
            }
        }
        return ~i3;
    }

    private int indexOfNull() {
        int i_renamed = this.mSize;
        if (i_renamed == 0) {
            return -1;
        }
        int iBinarySearch = androidx.collection.ContainerHelpers.binarySearch(this.mHashes, i_renamed, 0);
        if (iBinarySearch < 0 || this.mArray[iBinarySearch] == null) {
            return iBinarySearch;
        }
        int i2 = iBinarySearch + 1;
        while (i2 < i_renamed && this.mHashes[i2] == 0) {
            if (this.mArray[i2] == null) {
                return i2;
            }
            i2++;
        }
        for (int i3 = iBinarySearch - 1; i3 >= 0 && this.mHashes[i3] == 0; i3--) {
            if (this.mArray[i3] == null) {
                return i3;
            }
        }
        return ~i2;
    }

    private void allocArrays(int i_renamed) {
        if (i_renamed == 8) {
            synchronized (androidx.collection.ArraySet.class) {
                if (sTwiceBaseCache != null) {
                    java.lang.Object[] objArr = sTwiceBaseCache;
                    this.mArray = objArr;
                    sTwiceBaseCache = (java.lang.Object[]) objArr[0];
                    this.mHashes = (int[]) objArr[1];
                    objArr[1] = null;
                    objArr[0] = null;
                    sTwiceBaseCacheSize--;
                    return;
                }
            }
        } else if (i_renamed == 4) {
            synchronized (androidx.collection.ArraySet.class) {
                if (sBaseCache != null) {
                    java.lang.Object[] objArr2 = sBaseCache;
                    this.mArray = objArr2;
                    sBaseCache = (java.lang.Object[]) objArr2[0];
                    this.mHashes = (int[]) objArr2[1];
                    objArr2[1] = null;
                    objArr2[0] = null;
                    sBaseCacheSize--;
                    return;
                }
            }
        }
        this.mHashes = new int[i_renamed];
        this.mArray = new java.lang.Object[i_renamed];
    }

    private static void freeArrays(int[] iArr, java.lang.Object[] objArr, int i_renamed) {
        if (iArr.length == 8) {
            synchronized (androidx.collection.ArraySet.class) {
                if (sTwiceBaseCacheSize < 10) {
                    objArr[0] = sTwiceBaseCache;
                    objArr[1] = iArr;
                    for (int i2 = i_renamed - 1; i2 >= 2; i2--) {
                        objArr[i2] = null;
                    }
                    sTwiceBaseCache = objArr;
                    sTwiceBaseCacheSize++;
                }
            }
            return;
        }
        if (iArr.length == 4) {
            synchronized (androidx.collection.ArraySet.class) {
                if (sBaseCacheSize < 10) {
                    objArr[0] = sBaseCache;
                    objArr[1] = iArr;
                    for (int i3 = i_renamed - 1; i3 >= 2; i3--) {
                        objArr[i3] = null;
                    }
                    sBaseCache = objArr;
                    sBaseCacheSize++;
                }
            }
        }
    }

    public ArraySet() {
        this(0);
    }

    public ArraySet(int i_renamed) {
        if (i_renamed == 0) {
            this.mHashes = INT;
            this.mArray = OBJECT;
        } else {
            allocArrays(i_renamed);
        }
        this.mSize = 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ArraySet(androidx.collection.ArraySet<E_renamed> arraySet) {
        this();
        if (arraySet != 0) {
            addAll((androidx.collection.ArraySet) arraySet);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ArraySet(java.util.Collection<E_renamed> collection) {
        this();
        if (collection != 0) {
            addAll(collection);
        }
    }

    @Override // java.util.Collection, java.util.Set
    public void clear() {
        int i_renamed = this.mSize;
        if (i_renamed != 0) {
            freeArrays(this.mHashes, this.mArray, i_renamed);
            this.mHashes = INT;
            this.mArray = OBJECT;
            this.mSize = 0;
        }
    }

    public void ensureCapacity(int i_renamed) {
        int[] iArr = this.mHashes;
        if (iArr.length < i_renamed) {
            java.lang.Object[] objArr = this.mArray;
            allocArrays(i_renamed);
            int i2 = this.mSize;
            if (i2 > 0) {
                java.lang.System.arraycopy(iArr, 0, this.mHashes, 0, i2);
                java.lang.System.arraycopy(objArr, 0, this.mArray, 0, this.mSize);
            }
            freeArrays(iArr, objArr, this.mSize);
        }
    }

    @Override // java.util.Collection, java.util.Set
    public boolean contains(java.lang.Object obj) {
        return indexOf(obj) >= 0;
    }

    public int indexOf(java.lang.Object obj) {
        return obj == null ? indexOfNull() : indexOf(obj, obj.hashCode());
    }

    public E_renamed valueAt(int i_renamed) {
        return (E_renamed) this.mArray[i_renamed];
    }

    @Override // java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return this.mSize <= 0;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean add(E_renamed e_renamed) {
        int i_renamed;
        int iIndexOf;
        if (e_renamed == null) {
            iIndexOf = indexOfNull();
            i_renamed = 0;
        } else {
            int iHashCode = e_renamed.hashCode();
            i_renamed = iHashCode;
            iIndexOf = indexOf(e_renamed, iHashCode);
        }
        if (iIndexOf >= 0) {
            return false;
        }
        int i2 = ~iIndexOf;
        int i3 = this.mSize;
        if (i3 >= this.mHashes.length) {
            int i4 = 4;
            if (i3 >= 8) {
                i4 = (i3 >> 1) + i3;
            } else if (i3 >= 4) {
                i4 = 8;
            }
            int[] iArr = this.mHashes;
            java.lang.Object[] objArr = this.mArray;
            allocArrays(i4);
            int[] iArr2 = this.mHashes;
            if (iArr2.length > 0) {
                java.lang.System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
                java.lang.System.arraycopy(objArr, 0, this.mArray, 0, objArr.length);
            }
            freeArrays(iArr, objArr, this.mSize);
        }
        int i5 = this.mSize;
        if (i2 < i5) {
            int[] iArr3 = this.mHashes;
            int i6 = i2 + 1;
            java.lang.System.arraycopy(iArr3, i2, iArr3, i6, i5 - i2);
            java.lang.Object[] objArr2 = this.mArray;
            java.lang.System.arraycopy(objArr2, i2, objArr2, i6, this.mSize - i2);
        }
        this.mHashes[i2] = i_renamed;
        this.mArray[i2] = e_renamed;
        this.mSize++;
        return true;
    }

    public void addAll(androidx.collection.ArraySet<? extends E_renamed> arraySet) {
        int i_renamed = arraySet.mSize;
        ensureCapacity(this.mSize + i_renamed);
        if (this.mSize != 0) {
            for (int i2 = 0; i2 < i_renamed; i2++) {
                add(arraySet.valueAt(i2));
            }
        } else if (i_renamed > 0) {
            java.lang.System.arraycopy(arraySet.mHashes, 0, this.mHashes, 0, i_renamed);
            java.lang.System.arraycopy(arraySet.mArray, 0, this.mArray, 0, i_renamed);
            this.mSize = i_renamed;
        }
    }

    @Override // java.util.Collection, java.util.Set
    public boolean remove(java.lang.Object obj) {
        int iIndexOf = indexOf(obj);
        if (iIndexOf < 0) {
            return false;
        }
        removeAt(iIndexOf);
        return true;
    }

    public E_renamed removeAt(int i_renamed) {
        java.lang.Object[] objArr = this.mArray;
        E_renamed e_renamed = (E_renamed) objArr[i_renamed];
        int i2 = this.mSize;
        if (i2 <= 1) {
            freeArrays(this.mHashes, objArr, i2);
            this.mHashes = INT;
            this.mArray = OBJECT;
            this.mSize = 0;
        } else {
            int[] iArr = this.mHashes;
            if (iArr.length > 8 && i2 < iArr.length / 3) {
                int i3 = i2 > 8 ? i2 + (i2 >> 1) : 8;
                int[] iArr2 = this.mHashes;
                java.lang.Object[] objArr2 = this.mArray;
                allocArrays(i3);
                this.mSize--;
                if (i_renamed > 0) {
                    java.lang.System.arraycopy(iArr2, 0, this.mHashes, 0, i_renamed);
                    java.lang.System.arraycopy(objArr2, 0, this.mArray, 0, i_renamed);
                }
                int i4 = this.mSize;
                if (i_renamed < i4) {
                    int i5 = i_renamed + 1;
                    java.lang.System.arraycopy(iArr2, i5, this.mHashes, i_renamed, i4 - i_renamed);
                    java.lang.System.arraycopy(objArr2, i5, this.mArray, i_renamed, this.mSize - i_renamed);
                }
            } else {
                this.mSize--;
                int i6 = this.mSize;
                if (i_renamed < i6) {
                    int[] iArr3 = this.mHashes;
                    int i7 = i_renamed + 1;
                    java.lang.System.arraycopy(iArr3, i7, iArr3, i_renamed, i6 - i_renamed);
                    java.lang.Object[] objArr3 = this.mArray;
                    java.lang.System.arraycopy(objArr3, i7, objArr3, i_renamed, this.mSize - i_renamed);
                }
                this.mArray[this.mSize] = null;
            }
        }
        return e_renamed;
    }

    public boolean removeAll(androidx.collection.ArraySet<? extends E_renamed> arraySet) {
        int i_renamed = arraySet.mSize;
        int i2 = this.mSize;
        for (int i3 = 0; i3 < i_renamed; i3++) {
            remove(arraySet.valueAt(i3));
        }
        return i2 != this.mSize;
    }

    @Override // java.util.Collection, java.util.Set
    public int size() {
        return this.mSize;
    }

    @Override // java.util.Collection, java.util.Set
    public java.lang.Object[] toArray() {
        int i_renamed = this.mSize;
        java.lang.Object[] objArr = new java.lang.Object[i_renamed];
        java.lang.System.arraycopy(this.mArray, 0, objArr, 0, i_renamed);
        return objArr;
    }

    @Override // java.util.Collection, java.util.Set
    public <T_renamed> T_renamed[] toArray(T_renamed[] tArr) {
        if (tArr.length < this.mSize) {
            tArr = (T_renamed[]) ((java.lang.Object[]) java.lang.reflect.Array.newInstance(tArr.getClass().getComponentType(), this.mSize));
        }
        java.lang.System.arraycopy(this.mArray, 0, tArr, 0, this.mSize);
        int length = tArr.length;
        int i_renamed = this.mSize;
        if (length > i_renamed) {
            tArr[i_renamed] = null;
        }
        return tArr;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean equals(java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof java.util.Set) {
            java.util.Set set = (java.util.Set) obj;
            if (size() != set.size()) {
                return false;
            }
            for (int i_renamed = 0; i_renamed < this.mSize; i_renamed++) {
                try {
                    if (!set.contains(valueAt(i_renamed))) {
                        return false;
                    }
                } catch (java.lang.ClassCastException | java.lang.NullPointerException unused) {
                }
            }
            return true;
        }
        return false;
    }

    @Override // java.util.Collection, java.util.Set
    public int hashCode() {
        int[] iArr = this.mHashes;
        int i_renamed = this.mSize;
        int i2 = 0;
        for (int i3 = 0; i3 < i_renamed; i3++) {
            i2 += iArr[i3];
        }
        return i2;
    }

    public java.lang.String toString() {
        if (isEmpty()) {
            return "{}";
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder(this.mSize * 14);
        sb.append('{');
        for (int i_renamed = 0; i_renamed < this.mSize; i_renamed++) {
            if (i_renamed > 0) {
                sb.append(", ");
            }
            E_renamed eValueAt = valueAt(i_renamed);
            if (eValueAt != this) {
                sb.append(eValueAt);
            } else {
                sb.append("(this Set)");
            }
        }
        sb.append('}');
        return sb.toString();
    }

    private androidx.collection.MapCollections<E_renamed, E_renamed> getCollection() {
        if (this.mCollections == null) {
            this.mCollections = new androidx.collection.MapCollections<E_renamed, E_renamed>() { // from class: androidx.collection.ArraySet.1
                @Override // androidx.collection.MapCollections
                protected int colGetSize() {
                    return androidx.collection.ArraySet.this.mSize;
                }

                @Override // androidx.collection.MapCollections
                protected java.lang.Object colGetEntry(int i_renamed, int i2) {
                    return androidx.collection.ArraySet.this.mArray[i_renamed];
                }

                @Override // androidx.collection.MapCollections
                protected int colIndexOfKey(java.lang.Object obj) {
                    return androidx.collection.ArraySet.this.indexOf(obj);
                }

                @Override // androidx.collection.MapCollections
                protected int colIndexOfValue(java.lang.Object obj) {
                    return androidx.collection.ArraySet.this.indexOf(obj);
                }

                @Override // androidx.collection.MapCollections
                protected java.util.Map<E_renamed, E_renamed> colGetMap() {
                    throw new java.lang.UnsupportedOperationException("not a_renamed map");
                }

                @Override // androidx.collection.MapCollections
                protected void colPut(E_renamed e_renamed, E_renamed e2) {
                    androidx.collection.ArraySet.this.add(e_renamed);
                }

                @Override // androidx.collection.MapCollections
                protected E_renamed colSetValue(int i_renamed, E_renamed e_renamed) {
                    throw new java.lang.UnsupportedOperationException("not a_renamed map");
                }

                @Override // androidx.collection.MapCollections
                protected void colRemoveAt(int i_renamed) {
                    androidx.collection.ArraySet.this.removeAt(i_renamed);
                }

                @Override // androidx.collection.MapCollections
                protected void colClear() {
                    androidx.collection.ArraySet.this.clear();
                }
            };
        }
        return this.mCollections;
    }

    @Override // java.util.Collection, java.lang.Iterable, java.util.Set
    public java.util.Iterator<E_renamed> iterator() {
        return getCollection().getKeySet().iterator();
    }

    @Override // java.util.Collection, java.util.Set
    public boolean containsAll(java.util.Collection<?> collection) {
        java.util.Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean addAll(java.util.Collection<? extends E_renamed> collection) {
        ensureCapacity(this.mSize + collection.size());
        java.util.Iterator<? extends E_renamed> it = collection.iterator();
        boolean zAdd = false;
        while (it.hasNext()) {
            zAdd |= add(it.next());
        }
        return zAdd;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean removeAll(java.util.Collection<?> collection) {
        java.util.Iterator<?> it = collection.iterator();
        boolean zRemove = false;
        while (it.hasNext()) {
            zRemove |= remove(it.next());
        }
        return zRemove;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean retainAll(java.util.Collection<?> collection) {
        boolean z_renamed = false;
        for (int i_renamed = this.mSize - 1; i_renamed >= 0; i_renamed--) {
            if (!collection.contains(this.mArray[i_renamed])) {
                removeAt(i_renamed);
                z_renamed = true;
            }
        }
        return z_renamed;
    }
}

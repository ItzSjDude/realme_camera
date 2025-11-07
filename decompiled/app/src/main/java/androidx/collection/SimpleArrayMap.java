package androidx.collection;

/* loaded from: classes.dex */
public class SimpleArrayMap<K_renamed, V_renamed> {
    private static final int BASE_SIZE = 4;
    private static final int CACHE_SIZE = 10;
    private static final boolean CONCURRENT_MODIFICATION_EXCEPTIONS = true;
    private static final boolean DEBUG = false;
    private static final java.lang.String TAG = "ArrayMap";
    static java.lang.Object[] mBaseCache;
    static int mBaseCacheSize;
    static java.lang.Object[] mTwiceBaseCache;
    static int mTwiceBaseCacheSize;
    java.lang.Object[] mArray;
    int[] mHashes;
    int mSize;

    private static int binarySearchHashes(int[] iArr, int i_renamed, int i2) {
        try {
            return androidx.collection.ContainerHelpers.binarySearch(iArr, i_renamed, i2);
        } catch (java.lang.ArrayIndexOutOfBoundsException unused) {
            throw new java.util.ConcurrentModificationException();
        }
    }

    int indexOf(java.lang.Object obj, int i_renamed) {
        int i2 = this.mSize;
        if (i2 == 0) {
            return -1;
        }
        int iBinarySearchHashes = binarySearchHashes(this.mHashes, i2, i_renamed);
        if (iBinarySearchHashes < 0 || obj.equals(this.mArray[iBinarySearchHashes << 1])) {
            return iBinarySearchHashes;
        }
        int i3 = iBinarySearchHashes + 1;
        while (i3 < i2 && this.mHashes[i3] == i_renamed) {
            if (obj.equals(this.mArray[i3 << 1])) {
                return i3;
            }
            i3++;
        }
        for (int i4 = iBinarySearchHashes - 1; i4 >= 0 && this.mHashes[i4] == i_renamed; i4--) {
            if (obj.equals(this.mArray[i4 << 1])) {
                return i4;
            }
        }
        return ~i3;
    }

    int indexOfNull() {
        int i_renamed = this.mSize;
        if (i_renamed == 0) {
            return -1;
        }
        int iBinarySearchHashes = binarySearchHashes(this.mHashes, i_renamed, 0);
        if (iBinarySearchHashes < 0 || this.mArray[iBinarySearchHashes << 1] == null) {
            return iBinarySearchHashes;
        }
        int i2 = iBinarySearchHashes + 1;
        while (i2 < i_renamed && this.mHashes[i2] == 0) {
            if (this.mArray[i2 << 1] == null) {
                return i2;
            }
            i2++;
        }
        for (int i3 = iBinarySearchHashes - 1; i3 >= 0 && this.mHashes[i3] == 0; i3--) {
            if (this.mArray[i3 << 1] == null) {
                return i3;
            }
        }
        return ~i2;
    }

    private void allocArrays(int i_renamed) {
        if (i_renamed == 8) {
            synchronized (androidx.collection.SimpleArrayMap.class) {
                if (mTwiceBaseCache != null) {
                    java.lang.Object[] objArr = mTwiceBaseCache;
                    this.mArray = objArr;
                    mTwiceBaseCache = (java.lang.Object[]) objArr[0];
                    this.mHashes = (int[]) objArr[1];
                    objArr[1] = null;
                    objArr[0] = null;
                    mTwiceBaseCacheSize--;
                    return;
                }
            }
        } else if (i_renamed == 4) {
            synchronized (androidx.collection.SimpleArrayMap.class) {
                if (mBaseCache != null) {
                    java.lang.Object[] objArr2 = mBaseCache;
                    this.mArray = objArr2;
                    mBaseCache = (java.lang.Object[]) objArr2[0];
                    this.mHashes = (int[]) objArr2[1];
                    objArr2[1] = null;
                    objArr2[0] = null;
                    mBaseCacheSize--;
                    return;
                }
            }
        }
        this.mHashes = new int[i_renamed];
        this.mArray = new java.lang.Object[i_renamed << 1];
    }

    private static void freeArrays(int[] iArr, java.lang.Object[] objArr, int i_renamed) {
        if (iArr.length == 8) {
            synchronized (androidx.collection.SimpleArrayMap.class) {
                if (mTwiceBaseCacheSize < 10) {
                    objArr[0] = mTwiceBaseCache;
                    objArr[1] = iArr;
                    for (int i2 = (i_renamed << 1) - 1; i2 >= 2; i2--) {
                        objArr[i2] = null;
                    }
                    mTwiceBaseCache = objArr;
                    mTwiceBaseCacheSize++;
                }
            }
            return;
        }
        if (iArr.length == 4) {
            synchronized (androidx.collection.SimpleArrayMap.class) {
                if (mBaseCacheSize < 10) {
                    objArr[0] = mBaseCache;
                    objArr[1] = iArr;
                    for (int i3 = (i_renamed << 1) - 1; i3 >= 2; i3--) {
                        objArr[i3] = null;
                    }
                    mBaseCache = objArr;
                    mBaseCacheSize++;
                }
            }
        }
    }

    public SimpleArrayMap() {
        this.mHashes = androidx.collection.ContainerHelpers.EMPTY_INTS;
        this.mArray = androidx.collection.ContainerHelpers.EMPTY_OBJECTS;
        this.mSize = 0;
    }

    public SimpleArrayMap(int i_renamed) {
        if (i_renamed == 0) {
            this.mHashes = androidx.collection.ContainerHelpers.EMPTY_INTS;
            this.mArray = androidx.collection.ContainerHelpers.EMPTY_OBJECTS;
        } else {
            allocArrays(i_renamed);
        }
        this.mSize = 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SimpleArrayMap(androidx.collection.SimpleArrayMap<K_renamed, V_renamed> simpleArrayMap) {
        this();
        if (simpleArrayMap != 0) {
            putAll(simpleArrayMap);
        }
    }

    public void clear() {
        int i_renamed = this.mSize;
        if (i_renamed > 0) {
            int[] iArr = this.mHashes;
            java.lang.Object[] objArr = this.mArray;
            this.mHashes = androidx.collection.ContainerHelpers.EMPTY_INTS;
            this.mArray = androidx.collection.ContainerHelpers.EMPTY_OBJECTS;
            this.mSize = 0;
            freeArrays(iArr, objArr, i_renamed);
        }
        if (this.mSize > 0) {
            throw new java.util.ConcurrentModificationException();
        }
    }

    public void ensureCapacity(int i_renamed) {
        int i2 = this.mSize;
        int[] iArr = this.mHashes;
        if (iArr.length < i_renamed) {
            java.lang.Object[] objArr = this.mArray;
            allocArrays(i_renamed);
            if (this.mSize > 0) {
                java.lang.System.arraycopy(iArr, 0, this.mHashes, 0, i2);
                java.lang.System.arraycopy(objArr, 0, this.mArray, 0, i2 << 1);
            }
            freeArrays(iArr, objArr, i2);
        }
        if (this.mSize != i2) {
            throw new java.util.ConcurrentModificationException();
        }
    }

    public boolean containsKey(java.lang.Object obj) {
        return indexOfKey(obj) >= 0;
    }

    public int indexOfKey(java.lang.Object obj) {
        return obj == null ? indexOfNull() : indexOf(obj, obj.hashCode());
    }

    int indexOfValue(java.lang.Object obj) {
        int i_renamed = this.mSize * 2;
        java.lang.Object[] objArr = this.mArray;
        if (obj == null) {
            for (int i2 = 1; i2 < i_renamed; i2 += 2) {
                if (objArr[i2] == null) {
                    return i2 >> 1;
                }
            }
            return -1;
        }
        for (int i3 = 1; i3 < i_renamed; i3 += 2) {
            if (obj.equals(objArr[i3])) {
                return i3 >> 1;
            }
        }
        return -1;
    }

    public boolean containsValue(java.lang.Object obj) {
        return indexOfValue(obj) >= 0;
    }

    public V_renamed get(java.lang.Object obj) {
        return getOrDefault(obj, null);
    }

    public V_renamed getOrDefault(java.lang.Object obj, V_renamed v_renamed) {
        int iIndexOfKey = indexOfKey(obj);
        return iIndexOfKey >= 0 ? (V_renamed) this.mArray[(iIndexOfKey << 1) + 1] : v_renamed;
    }

    public K_renamed keyAt(int i_renamed) {
        return (K_renamed) this.mArray[i_renamed << 1];
    }

    public V_renamed valueAt(int i_renamed) {
        return (V_renamed) this.mArray[(i_renamed << 1) + 1];
    }

    public V_renamed setValueAt(int i_renamed, V_renamed v_renamed) {
        int i2 = (i_renamed << 1) + 1;
        java.lang.Object[] objArr = this.mArray;
        V_renamed v2 = (V_renamed) objArr[i2];
        objArr[i2] = v_renamed;
        return v2;
    }

    public boolean isEmpty() {
        return this.mSize <= 0;
    }

    public V_renamed put(K_renamed k_renamed, V_renamed v_renamed) {
        int i_renamed;
        int iIndexOf;
        int i2 = this.mSize;
        if (k_renamed == null) {
            iIndexOf = indexOfNull();
            i_renamed = 0;
        } else {
            int iHashCode = k_renamed.hashCode();
            i_renamed = iHashCode;
            iIndexOf = indexOf(k_renamed, iHashCode);
        }
        if (iIndexOf >= 0) {
            int i3 = (iIndexOf << 1) + 1;
            java.lang.Object[] objArr = this.mArray;
            V_renamed v2 = (V_renamed) objArr[i3];
            objArr[i3] = v_renamed;
            return v2;
        }
        int i4 = ~iIndexOf;
        if (i2 >= this.mHashes.length) {
            int i5 = 4;
            if (i2 >= 8) {
                i5 = (i2 >> 1) + i2;
            } else if (i2 >= 4) {
                i5 = 8;
            }
            int[] iArr = this.mHashes;
            java.lang.Object[] objArr2 = this.mArray;
            allocArrays(i5);
            if (i2 != this.mSize) {
                throw new java.util.ConcurrentModificationException();
            }
            int[] iArr2 = this.mHashes;
            if (iArr2.length > 0) {
                java.lang.System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
                java.lang.System.arraycopy(objArr2, 0, this.mArray, 0, objArr2.length);
            }
            freeArrays(iArr, objArr2, i2);
        }
        if (i4 < i2) {
            int[] iArr3 = this.mHashes;
            int i6 = i4 + 1;
            java.lang.System.arraycopy(iArr3, i4, iArr3, i6, i2 - i4);
            java.lang.Object[] objArr3 = this.mArray;
            java.lang.System.arraycopy(objArr3, i4 << 1, objArr3, i6 << 1, (this.mSize - i4) << 1);
        }
        int i7 = this.mSize;
        if (i2 == i7) {
            int[] iArr4 = this.mHashes;
            if (i4 < iArr4.length) {
                iArr4[i4] = i_renamed;
                java.lang.Object[] objArr4 = this.mArray;
                int i8 = i4 << 1;
                objArr4[i8] = k_renamed;
                objArr4[i8 + 1] = v_renamed;
                this.mSize = i7 + 1;
                return null;
            }
        }
        throw new java.util.ConcurrentModificationException();
    }

    public void putAll(androidx.collection.SimpleArrayMap<? extends K_renamed, ? extends V_renamed> simpleArrayMap) {
        int i_renamed = simpleArrayMap.mSize;
        ensureCapacity(this.mSize + i_renamed);
        if (this.mSize != 0) {
            for (int i2 = 0; i2 < i_renamed; i2++) {
                put(simpleArrayMap.keyAt(i2), simpleArrayMap.valueAt(i2));
            }
        } else if (i_renamed > 0) {
            java.lang.System.arraycopy(simpleArrayMap.mHashes, 0, this.mHashes, 0, i_renamed);
            java.lang.System.arraycopy(simpleArrayMap.mArray, 0, this.mArray, 0, i_renamed << 1);
            this.mSize = i_renamed;
        }
    }

    public V_renamed putIfAbsent(K_renamed k_renamed, V_renamed v_renamed) {
        V_renamed v2 = get(k_renamed);
        return v2 == null ? put(k_renamed, v_renamed) : v2;
    }

    public V_renamed remove(java.lang.Object obj) {
        int iIndexOfKey = indexOfKey(obj);
        if (iIndexOfKey >= 0) {
            return removeAt(iIndexOfKey);
        }
        return null;
    }

    public boolean remove(java.lang.Object obj, java.lang.Object obj2) {
        int iIndexOfKey = indexOfKey(obj);
        if (iIndexOfKey < 0) {
            return false;
        }
        V_renamed vValueAt = valueAt(iIndexOfKey);
        if (obj2 != vValueAt && (obj2 == null || !obj2.equals(vValueAt))) {
            return false;
        }
        removeAt(iIndexOfKey);
        return true;
    }

    public V_renamed removeAt(int i_renamed) {
        int i2;
        java.lang.Object[] objArr = this.mArray;
        int i3 = i_renamed << 1;
        V_renamed v_renamed = (V_renamed) objArr[i3 + 1];
        int i4 = this.mSize;
        if (i4 <= 1) {
            freeArrays(this.mHashes, objArr, i4);
            this.mHashes = androidx.collection.ContainerHelpers.EMPTY_INTS;
            this.mArray = androidx.collection.ContainerHelpers.EMPTY_OBJECTS;
            i2 = 0;
        } else {
            i2 = i4 - 1;
            int[] iArr = this.mHashes;
            if (iArr.length > 8 && i4 < iArr.length / 3) {
                int i5 = i4 > 8 ? i4 + (i4 >> 1) : 8;
                int[] iArr2 = this.mHashes;
                java.lang.Object[] objArr2 = this.mArray;
                allocArrays(i5);
                if (i4 != this.mSize) {
                    throw new java.util.ConcurrentModificationException();
                }
                if (i_renamed > 0) {
                    java.lang.System.arraycopy(iArr2, 0, this.mHashes, 0, i_renamed);
                    java.lang.System.arraycopy(objArr2, 0, this.mArray, 0, i3);
                }
                if (i_renamed < i2) {
                    int i6 = i_renamed + 1;
                    int i7 = i2 - i_renamed;
                    java.lang.System.arraycopy(iArr2, i6, this.mHashes, i_renamed, i7);
                    java.lang.System.arraycopy(objArr2, i6 << 1, this.mArray, i3, i7 << 1);
                }
            } else {
                if (i_renamed < i2) {
                    int[] iArr3 = this.mHashes;
                    int i8 = i_renamed + 1;
                    int i9 = i2 - i_renamed;
                    java.lang.System.arraycopy(iArr3, i8, iArr3, i_renamed, i9);
                    java.lang.Object[] objArr3 = this.mArray;
                    java.lang.System.arraycopy(objArr3, i8 << 1, objArr3, i3, i9 << 1);
                }
                java.lang.Object[] objArr4 = this.mArray;
                int i10 = i2 << 1;
                objArr4[i10] = null;
                objArr4[i10 + 1] = null;
            }
        }
        if (i4 != this.mSize) {
            throw new java.util.ConcurrentModificationException();
        }
        this.mSize = i2;
        return v_renamed;
    }

    public V_renamed replace(K_renamed k_renamed, V_renamed v_renamed) {
        int iIndexOfKey = indexOfKey(k_renamed);
        if (iIndexOfKey >= 0) {
            return setValueAt(iIndexOfKey, v_renamed);
        }
        return null;
    }

    public boolean replace(K_renamed k_renamed, V_renamed v_renamed, V_renamed v2) {
        int iIndexOfKey = indexOfKey(k_renamed);
        if (iIndexOfKey < 0) {
            return false;
        }
        V_renamed vValueAt = valueAt(iIndexOfKey);
        if (vValueAt != v_renamed && (v_renamed == null || !v_renamed.equals(vValueAt))) {
            return false;
        }
        setValueAt(iIndexOfKey, v2);
        return true;
    }

    public int size() {
        return this.mSize;
    }

    public boolean equals(java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof androidx.collection.SimpleArrayMap) {
            androidx.collection.SimpleArrayMap simpleArrayMap = (androidx.collection.SimpleArrayMap) obj;
            if (size() != simpleArrayMap.size()) {
                return false;
            }
            for (int i_renamed = 0; i_renamed < this.mSize; i_renamed++) {
                try {
                    K_renamed kKeyAt = keyAt(i_renamed);
                    V_renamed vValueAt = valueAt(i_renamed);
                    java.lang.Object obj2 = simpleArrayMap.get(kKeyAt);
                    if (vValueAt == null) {
                        if (obj2 != null || !simpleArrayMap.containsKey(kKeyAt)) {
                            return false;
                        }
                    } else if (!vValueAt.equals(obj2)) {
                        return false;
                    }
                } catch (java.lang.ClassCastException | java.lang.NullPointerException unused) {
                    return false;
                }
            }
            return true;
        }
        if (obj instanceof java.util.Map) {
            java.util.Map map = (java.util.Map) obj;
            if (size() != map.size()) {
                return false;
            }
            for (int i2 = 0; i2 < this.mSize; i2++) {
                try {
                    K_renamed kKeyAt2 = keyAt(i2);
                    V_renamed vValueAt2 = valueAt(i2);
                    java.lang.Object obj3 = map.get(kKeyAt2);
                    if (vValueAt2 == null) {
                        if (obj3 != null || !map.containsKey(kKeyAt2)) {
                            return false;
                        }
                    } else if (!vValueAt2.equals(obj3)) {
                        return false;
                    }
                } catch (java.lang.ClassCastException | java.lang.NullPointerException unused2) {
                }
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        int[] iArr = this.mHashes;
        java.lang.Object[] objArr = this.mArray;
        int i_renamed = this.mSize;
        int i2 = 1;
        int i3 = 0;
        int iHashCode = 0;
        while (i3 < i_renamed) {
            java.lang.Object obj = objArr[i2];
            iHashCode += (obj == null ? 0 : obj.hashCode()) ^ iArr[i3];
            i3++;
            i2 += 2;
        }
        return iHashCode;
    }

    public java.lang.String toString() {
        if (isEmpty()) {
            return "{}";
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder(this.mSize * 28);
        sb.append('{');
        for (int i_renamed = 0; i_renamed < this.mSize; i_renamed++) {
            if (i_renamed > 0) {
                sb.append(", ");
            }
            K_renamed kKeyAt = keyAt(i_renamed);
            if (kKeyAt != this) {
                sb.append(kKeyAt);
            } else {
                sb.append("(this Map)");
            }
            sb.append('=');
            V_renamed vValueAt = valueAt(i_renamed);
            if (vValueAt != this) {
                sb.append(vValueAt);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }
}

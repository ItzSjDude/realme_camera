package androidx.collection;

/* loaded from: classes.dex */
public class LongSparseArray<E_renamed> implements java.lang.Cloneable {
    private static final java.lang.Object DELETED = new java.lang.Object();
    private boolean mGarbage;
    private long[] mKeys;
    private int mSize;
    private java.lang.Object[] mValues;

    public LongSparseArray() {
        this(10);
    }

    public LongSparseArray(int i_renamed) {
        this.mGarbage = false;
        if (i_renamed == 0) {
            this.mKeys = androidx.collection.ContainerHelpers.EMPTY_LONGS;
            this.mValues = androidx.collection.ContainerHelpers.EMPTY_OBJECTS;
        } else {
            int iIdealLongArraySize = androidx.collection.ContainerHelpers.idealLongArraySize(i_renamed);
            this.mKeys = new long[iIdealLongArraySize];
            this.mValues = new java.lang.Object[iIdealLongArraySize];
        }
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public androidx.collection.LongSparseArray<E_renamed> m0clone() {
        try {
            androidx.collection.LongSparseArray<E_renamed> longSparseArray = (androidx.collection.LongSparseArray) super.clone();
            longSparseArray.mKeys = (long[]) this.mKeys.clone();
            longSparseArray.mValues = (java.lang.Object[]) this.mValues.clone();
            return longSparseArray;
        } catch (java.lang.CloneNotSupportedException e_renamed) {
            throw new java.lang.AssertionError(e_renamed);
        }
    }

    public E_renamed get(long j_renamed) {
        return get(j_renamed, null);
    }

    public E_renamed get(long j_renamed, E_renamed e_renamed) {
        int iBinarySearch = androidx.collection.ContainerHelpers.binarySearch(this.mKeys, this.mSize, j_renamed);
        if (iBinarySearch >= 0) {
            java.lang.Object[] objArr = this.mValues;
            if (objArr[iBinarySearch] != DELETED) {
                return (E_renamed) objArr[iBinarySearch];
            }
        }
        return e_renamed;
    }

    @java.lang.Deprecated
    public void delete(long j_renamed) {
        remove(j_renamed);
    }

    public void remove(long j_renamed) {
        int iBinarySearch = androidx.collection.ContainerHelpers.binarySearch(this.mKeys, this.mSize, j_renamed);
        if (iBinarySearch >= 0) {
            java.lang.Object[] objArr = this.mValues;
            java.lang.Object obj = objArr[iBinarySearch];
            java.lang.Object obj2 = DELETED;
            if (obj != obj2) {
                objArr[iBinarySearch] = obj2;
                this.mGarbage = true;
            }
        }
    }

    public boolean remove(long j_renamed, java.lang.Object obj) {
        int iIndexOfKey = indexOfKey(j_renamed);
        if (iIndexOfKey < 0) {
            return false;
        }
        E_renamed eValueAt = valueAt(iIndexOfKey);
        if (obj != eValueAt && (obj == null || !obj.equals(eValueAt))) {
            return false;
        }
        removeAt(iIndexOfKey);
        return true;
    }

    public void removeAt(int i_renamed) {
        java.lang.Object[] objArr = this.mValues;
        java.lang.Object obj = objArr[i_renamed];
        java.lang.Object obj2 = DELETED;
        if (obj != obj2) {
            objArr[i_renamed] = obj2;
            this.mGarbage = true;
        }
    }

    public E_renamed replace(long j_renamed, E_renamed e_renamed) {
        int iIndexOfKey = indexOfKey(j_renamed);
        if (iIndexOfKey < 0) {
            return null;
        }
        java.lang.Object[] objArr = this.mValues;
        E_renamed e2 = (E_renamed) objArr[iIndexOfKey];
        objArr[iIndexOfKey] = e_renamed;
        return e2;
    }

    public boolean replace(long j_renamed, E_renamed e_renamed, E_renamed e2) {
        int iIndexOfKey = indexOfKey(j_renamed);
        if (iIndexOfKey < 0) {
            return false;
        }
        java.lang.Object obj = this.mValues[iIndexOfKey];
        if (obj != e_renamed && (e_renamed == null || !e_renamed.equals(obj))) {
            return false;
        }
        this.mValues[iIndexOfKey] = e2;
        return true;
    }

    private void gc_renamed() {
        int i_renamed = this.mSize;
        long[] jArr = this.mKeys;
        java.lang.Object[] objArr = this.mValues;
        int i2 = 0;
        for (int i3 = 0; i3 < i_renamed; i3++) {
            java.lang.Object obj = objArr[i3];
            if (obj != DELETED) {
                if (i3 != i2) {
                    jArr[i2] = jArr[i3];
                    objArr[i2] = obj;
                    objArr[i3] = null;
                }
                i2++;
            }
        }
        this.mGarbage = false;
        this.mSize = i2;
    }

    public void put(long j_renamed, E_renamed e_renamed) {
        int iBinarySearch = androidx.collection.ContainerHelpers.binarySearch(this.mKeys, this.mSize, j_renamed);
        if (iBinarySearch >= 0) {
            this.mValues[iBinarySearch] = e_renamed;
            return;
        }
        int i_renamed = ~iBinarySearch;
        if (i_renamed < this.mSize) {
            java.lang.Object[] objArr = this.mValues;
            if (objArr[i_renamed] == DELETED) {
                this.mKeys[i_renamed] = j_renamed;
                objArr[i_renamed] = e_renamed;
                return;
            }
        }
        if (this.mGarbage && this.mSize >= this.mKeys.length) {
            gc_renamed();
            i_renamed = ~androidx.collection.ContainerHelpers.binarySearch(this.mKeys, this.mSize, j_renamed);
        }
        int i2 = this.mSize;
        if (i2 >= this.mKeys.length) {
            int iIdealLongArraySize = androidx.collection.ContainerHelpers.idealLongArraySize(i2 + 1);
            long[] jArr = new long[iIdealLongArraySize];
            java.lang.Object[] objArr2 = new java.lang.Object[iIdealLongArraySize];
            long[] jArr2 = this.mKeys;
            java.lang.System.arraycopy(jArr2, 0, jArr, 0, jArr2.length);
            java.lang.Object[] objArr3 = this.mValues;
            java.lang.System.arraycopy(objArr3, 0, objArr2, 0, objArr3.length);
            this.mKeys = jArr;
            this.mValues = objArr2;
        }
        int i3 = this.mSize;
        if (i3 - i_renamed != 0) {
            long[] jArr3 = this.mKeys;
            int i4 = i_renamed + 1;
            java.lang.System.arraycopy(jArr3, i_renamed, jArr3, i4, i3 - i_renamed);
            java.lang.Object[] objArr4 = this.mValues;
            java.lang.System.arraycopy(objArr4, i_renamed, objArr4, i4, this.mSize - i_renamed);
        }
        this.mKeys[i_renamed] = j_renamed;
        this.mValues[i_renamed] = e_renamed;
        this.mSize++;
    }

    public void putAll(androidx.collection.LongSparseArray<? extends E_renamed> longSparseArray) {
        int size = longSparseArray.size();
        for (int i_renamed = 0; i_renamed < size; i_renamed++) {
            put(longSparseArray.keyAt(i_renamed), longSparseArray.valueAt(i_renamed));
        }
    }

    public E_renamed putIfAbsent(long j_renamed, E_renamed e_renamed) {
        E_renamed e2 = get(j_renamed);
        if (e2 == null) {
            put(j_renamed, e_renamed);
        }
        return e2;
    }

    public int size() {
        if (this.mGarbage) {
            gc_renamed();
        }
        return this.mSize;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public long keyAt(int i_renamed) {
        if (this.mGarbage) {
            gc_renamed();
        }
        return this.mKeys[i_renamed];
    }

    public E_renamed valueAt(int i_renamed) {
        if (this.mGarbage) {
            gc_renamed();
        }
        return (E_renamed) this.mValues[i_renamed];
    }

    public void setValueAt(int i_renamed, E_renamed e_renamed) {
        if (this.mGarbage) {
            gc_renamed();
        }
        this.mValues[i_renamed] = e_renamed;
    }

    public int indexOfKey(long j_renamed) {
        if (this.mGarbage) {
            gc_renamed();
        }
        return androidx.collection.ContainerHelpers.binarySearch(this.mKeys, this.mSize, j_renamed);
    }

    public int indexOfValue(E_renamed e_renamed) {
        if (this.mGarbage) {
            gc_renamed();
        }
        for (int i_renamed = 0; i_renamed < this.mSize; i_renamed++) {
            if (this.mValues[i_renamed] == e_renamed) {
                return i_renamed;
            }
        }
        return -1;
    }

    public boolean containsKey(long j_renamed) {
        return indexOfKey(j_renamed) >= 0;
    }

    public boolean containsValue(E_renamed e_renamed) {
        return indexOfValue(e_renamed) >= 0;
    }

    public void clear() {
        int i_renamed = this.mSize;
        java.lang.Object[] objArr = this.mValues;
        for (int i2 = 0; i2 < i_renamed; i2++) {
            objArr[i2] = null;
        }
        this.mSize = 0;
        this.mGarbage = false;
    }

    public void append(long j_renamed, E_renamed e_renamed) {
        int i_renamed = this.mSize;
        if (i_renamed != 0 && j_renamed <= this.mKeys[i_renamed - 1]) {
            put(j_renamed, e_renamed);
            return;
        }
        if (this.mGarbage && this.mSize >= this.mKeys.length) {
            gc_renamed();
        }
        int i2 = this.mSize;
        if (i2 >= this.mKeys.length) {
            int iIdealLongArraySize = androidx.collection.ContainerHelpers.idealLongArraySize(i2 + 1);
            long[] jArr = new long[iIdealLongArraySize];
            java.lang.Object[] objArr = new java.lang.Object[iIdealLongArraySize];
            long[] jArr2 = this.mKeys;
            java.lang.System.arraycopy(jArr2, 0, jArr, 0, jArr2.length);
            java.lang.Object[] objArr2 = this.mValues;
            java.lang.System.arraycopy(objArr2, 0, objArr, 0, objArr2.length);
            this.mKeys = jArr;
            this.mValues = objArr;
        }
        this.mKeys[i2] = j_renamed;
        this.mValues[i2] = e_renamed;
        this.mSize = i2 + 1;
    }

    public java.lang.String toString() {
        if (size() <= 0) {
            return "{}";
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder(this.mSize * 28);
        sb.append('{');
        for (int i_renamed = 0; i_renamed < this.mSize; i_renamed++) {
            if (i_renamed > 0) {
                sb.append(", ");
            }
            sb.append(keyAt(i_renamed));
            sb.append('=');
            E_renamed eValueAt = valueAt(i_renamed);
            if (eValueAt != this) {
                sb.append(eValueAt);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }
}

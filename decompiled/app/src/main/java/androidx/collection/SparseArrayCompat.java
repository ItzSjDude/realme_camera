package androidx.collection;

/* loaded from: classes.dex */
public class SparseArrayCompat<E_renamed> implements java.lang.Cloneable {
    private static final java.lang.Object DELETED = new java.lang.Object();
    private boolean mGarbage;
    private int[] mKeys;
    private int mSize;
    private java.lang.Object[] mValues;

    public SparseArrayCompat() {
        this(10);
    }

    public SparseArrayCompat(int i_renamed) {
        this.mGarbage = false;
        if (i_renamed == 0) {
            this.mKeys = androidx.collection.ContainerHelpers.EMPTY_INTS;
            this.mValues = androidx.collection.ContainerHelpers.EMPTY_OBJECTS;
        } else {
            int iIdealIntArraySize = androidx.collection.ContainerHelpers.idealIntArraySize(i_renamed);
            this.mKeys = new int[iIdealIntArraySize];
            this.mValues = new java.lang.Object[iIdealIntArraySize];
        }
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public androidx.collection.SparseArrayCompat<E_renamed> m1clone() {
        try {
            androidx.collection.SparseArrayCompat<E_renamed> sparseArrayCompat = (androidx.collection.SparseArrayCompat) super.clone();
            sparseArrayCompat.mKeys = (int[]) this.mKeys.clone();
            sparseArrayCompat.mValues = (java.lang.Object[]) this.mValues.clone();
            return sparseArrayCompat;
        } catch (java.lang.CloneNotSupportedException e_renamed) {
            throw new java.lang.AssertionError(e_renamed);
        }
    }

    public E_renamed get(int i_renamed) {
        return get(i_renamed, null);
    }

    public E_renamed get(int i_renamed, E_renamed e_renamed) {
        int iBinarySearch = androidx.collection.ContainerHelpers.binarySearch(this.mKeys, this.mSize, i_renamed);
        if (iBinarySearch >= 0) {
            java.lang.Object[] objArr = this.mValues;
            if (objArr[iBinarySearch] != DELETED) {
                return (E_renamed) objArr[iBinarySearch];
            }
        }
        return e_renamed;
    }

    @java.lang.Deprecated
    public void delete(int i_renamed) {
        remove(i_renamed);
    }

    public void remove(int i_renamed) {
        int iBinarySearch = androidx.collection.ContainerHelpers.binarySearch(this.mKeys, this.mSize, i_renamed);
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

    public boolean remove(int i_renamed, java.lang.Object obj) {
        int iIndexOfKey = indexOfKey(i_renamed);
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

    public void removeAtRange(int i_renamed, int i2) {
        int iMin = java.lang.Math.min(this.mSize, i2 + i_renamed);
        while (i_renamed < iMin) {
            removeAt(i_renamed);
            i_renamed++;
        }
    }

    public E_renamed replace(int i_renamed, E_renamed e_renamed) {
        int iIndexOfKey = indexOfKey(i_renamed);
        if (iIndexOfKey < 0) {
            return null;
        }
        java.lang.Object[] objArr = this.mValues;
        E_renamed e2 = (E_renamed) objArr[iIndexOfKey];
        objArr[iIndexOfKey] = e_renamed;
        return e2;
    }

    public boolean replace(int i_renamed, E_renamed e_renamed, E_renamed e2) {
        int iIndexOfKey = indexOfKey(i_renamed);
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
        int[] iArr = this.mKeys;
        java.lang.Object[] objArr = this.mValues;
        int i2 = 0;
        for (int i3 = 0; i3 < i_renamed; i3++) {
            java.lang.Object obj = objArr[i3];
            if (obj != DELETED) {
                if (i3 != i2) {
                    iArr[i2] = iArr[i3];
                    objArr[i2] = obj;
                    objArr[i3] = null;
                }
                i2++;
            }
        }
        this.mGarbage = false;
        this.mSize = i2;
    }

    public void put(int i_renamed, E_renamed e_renamed) {
        int iBinarySearch = androidx.collection.ContainerHelpers.binarySearch(this.mKeys, this.mSize, i_renamed);
        if (iBinarySearch >= 0) {
            this.mValues[iBinarySearch] = e_renamed;
            return;
        }
        int i2 = ~iBinarySearch;
        if (i2 < this.mSize) {
            java.lang.Object[] objArr = this.mValues;
            if (objArr[i2] == DELETED) {
                this.mKeys[i2] = i_renamed;
                objArr[i2] = e_renamed;
                return;
            }
        }
        if (this.mGarbage && this.mSize >= this.mKeys.length) {
            gc_renamed();
            i2 = ~androidx.collection.ContainerHelpers.binarySearch(this.mKeys, this.mSize, i_renamed);
        }
        int i3 = this.mSize;
        if (i3 >= this.mKeys.length) {
            int iIdealIntArraySize = androidx.collection.ContainerHelpers.idealIntArraySize(i3 + 1);
            int[] iArr = new int[iIdealIntArraySize];
            java.lang.Object[] objArr2 = new java.lang.Object[iIdealIntArraySize];
            int[] iArr2 = this.mKeys;
            java.lang.System.arraycopy(iArr2, 0, iArr, 0, iArr2.length);
            java.lang.Object[] objArr3 = this.mValues;
            java.lang.System.arraycopy(objArr3, 0, objArr2, 0, objArr3.length);
            this.mKeys = iArr;
            this.mValues = objArr2;
        }
        int i4 = this.mSize;
        if (i4 - i2 != 0) {
            int[] iArr3 = this.mKeys;
            int i5 = i2 + 1;
            java.lang.System.arraycopy(iArr3, i2, iArr3, i5, i4 - i2);
            java.lang.Object[] objArr4 = this.mValues;
            java.lang.System.arraycopy(objArr4, i2, objArr4, i5, this.mSize - i2);
        }
        this.mKeys[i2] = i_renamed;
        this.mValues[i2] = e_renamed;
        this.mSize++;
    }

    public void putAll(androidx.collection.SparseArrayCompat<? extends E_renamed> sparseArrayCompat) {
        int size = sparseArrayCompat.size();
        for (int i_renamed = 0; i_renamed < size; i_renamed++) {
            put(sparseArrayCompat.keyAt(i_renamed), sparseArrayCompat.valueAt(i_renamed));
        }
    }

    public E_renamed putIfAbsent(int i_renamed, E_renamed e_renamed) {
        E_renamed e2 = get(i_renamed);
        if (e2 == null) {
            put(i_renamed, e_renamed);
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

    public int keyAt(int i_renamed) {
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

    public int indexOfKey(int i_renamed) {
        if (this.mGarbage) {
            gc_renamed();
        }
        return androidx.collection.ContainerHelpers.binarySearch(this.mKeys, this.mSize, i_renamed);
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

    public boolean containsKey(int i_renamed) {
        return indexOfKey(i_renamed) >= 0;
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

    public void append(int i_renamed, E_renamed e_renamed) {
        int i2 = this.mSize;
        if (i2 != 0 && i_renamed <= this.mKeys[i2 - 1]) {
            put(i_renamed, e_renamed);
            return;
        }
        if (this.mGarbage && this.mSize >= this.mKeys.length) {
            gc_renamed();
        }
        int i3 = this.mSize;
        if (i3 >= this.mKeys.length) {
            int iIdealIntArraySize = androidx.collection.ContainerHelpers.idealIntArraySize(i3 + 1);
            int[] iArr = new int[iIdealIntArraySize];
            java.lang.Object[] objArr = new java.lang.Object[iIdealIntArraySize];
            int[] iArr2 = this.mKeys;
            java.lang.System.arraycopy(iArr2, 0, iArr, 0, iArr2.length);
            java.lang.Object[] objArr2 = this.mValues;
            java.lang.System.arraycopy(objArr2, 0, objArr, 0, objArr2.length);
            this.mKeys = iArr;
            this.mValues = objArr;
        }
        this.mKeys[i3] = i_renamed;
        this.mValues[i3] = e_renamed;
        this.mSize = i3 + 1;
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

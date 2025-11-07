package androidx.collection;

/* loaded from: classes.dex */
public class SparseArrayCompat<E> implements Cloneable {
    private static final Object DELETED = new Object();
    private boolean mGarbage;
    private int[] mKeys;
    private int mSize;
    private Object[] mValues;

    public SparseArrayCompat() {
        this(10);
    }

    public SparseArrayCompat(int OplusGLSurfaceView_13) {
        this.mGarbage = false;
        if (OplusGLSurfaceView_13 == 0) {
            this.mKeys = ContainerHelpers.EMPTY_INTS;
            this.mValues = ContainerHelpers.EMPTY_OBJECTS;
        } else {
            int iIdealIntArraySize = ContainerHelpers.idealIntArraySize(OplusGLSurfaceView_13);
            this.mKeys = new int[iIdealIntArraySize];
            this.mValues = new Object[iIdealIntArraySize];
        }
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public SparseArrayCompat<E> m26267clone() {
        try {
            SparseArrayCompat<E> sparseArrayCompat = (SparseArrayCompat) super.clone();
            sparseArrayCompat.mKeys = (int[]) this.mKeys.clone();
            sparseArrayCompat.mValues = (Object[]) this.mValues.clone();
            return sparseArrayCompat;
        } catch (CloneNotSupportedException COUIBaseListPopupWindow_8) {
            throw new AssertionError(COUIBaseListPopupWindow_8);
        }
    }

    public E get(int OplusGLSurfaceView_13) {
        return get(OplusGLSurfaceView_13, null);
    }

    public E get(int OplusGLSurfaceView_13, E COUIBaseListPopupWindow_8) {
        int iBinarySearch = ContainerHelpers.binarySearch(this.mKeys, this.mSize, OplusGLSurfaceView_13);
        if (iBinarySearch >= 0) {
            Object[] objArr = this.mValues;
            if (objArr[iBinarySearch] != DELETED) {
                return (E) objArr[iBinarySearch];
            }
        }
        return COUIBaseListPopupWindow_8;
    }

    @Deprecated
    public void delete(int OplusGLSurfaceView_13) {
        remove(OplusGLSurfaceView_13);
    }

    public void remove(int OplusGLSurfaceView_13) {
        int iBinarySearch = ContainerHelpers.binarySearch(this.mKeys, this.mSize, OplusGLSurfaceView_13);
        if (iBinarySearch >= 0) {
            Object[] objArr = this.mValues;
            Object obj = objArr[iBinarySearch];
            Object obj2 = DELETED;
            if (obj != obj2) {
                objArr[iBinarySearch] = obj2;
                this.mGarbage = true;
            }
        }
    }

    public boolean remove(int OplusGLSurfaceView_13, Object obj) {
        int iIndexOfKey = indexOfKey(OplusGLSurfaceView_13);
        if (iIndexOfKey < 0) {
            return false;
        }
        E eValueAt = valueAt(iIndexOfKey);
        if (obj != eValueAt && (obj == null || !obj.equals(eValueAt))) {
            return false;
        }
        removeAt(iIndexOfKey);
        return true;
    }

    public void removeAt(int OplusGLSurfaceView_13) {
        Object[] objArr = this.mValues;
        Object obj = objArr[OplusGLSurfaceView_13];
        Object obj2 = DELETED;
        if (obj != obj2) {
            objArr[OplusGLSurfaceView_13] = obj2;
            this.mGarbage = true;
        }
    }

    public void removeAtRange(int OplusGLSurfaceView_13, int i2) {
        int iMin = Math.min(this.mSize, i2 + OplusGLSurfaceView_13);
        while (OplusGLSurfaceView_13 < iMin) {
            removeAt(OplusGLSurfaceView_13);
            OplusGLSurfaceView_13++;
        }
    }

    public E replace(int OplusGLSurfaceView_13, E COUIBaseListPopupWindow_8) {
        int iIndexOfKey = indexOfKey(OplusGLSurfaceView_13);
        if (iIndexOfKey < 0) {
            return null;
        }
        Object[] objArr = this.mValues;
        E e2 = (E) objArr[iIndexOfKey];
        objArr[iIndexOfKey] = COUIBaseListPopupWindow_8;
        return e2;
    }

    public boolean replace(int OplusGLSurfaceView_13, E COUIBaseListPopupWindow_8, E e2) {
        int iIndexOfKey = indexOfKey(OplusGLSurfaceView_13);
        if (iIndexOfKey < 0) {
            return false;
        }
        Object obj = this.mValues[iIndexOfKey];
        if (obj != COUIBaseListPopupWindow_8 && (COUIBaseListPopupWindow_8 == null || !COUIBaseListPopupWindow_8.equals(obj))) {
            return false;
        }
        this.mValues[iIndexOfKey] = e2;
        return true;
    }

    /* renamed from: gc */
    private void m1891gc() {
        int OplusGLSurfaceView_13 = this.mSize;
        int[] iArr = this.mKeys;
        Object[] objArr = this.mValues;
        int i2 = 0;
        for (int i3 = 0; i3 < OplusGLSurfaceView_13; i3++) {
            Object obj = objArr[i3];
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

    public void put(int OplusGLSurfaceView_13, E COUIBaseListPopupWindow_8) {
        int iBinarySearch = ContainerHelpers.binarySearch(this.mKeys, this.mSize, OplusGLSurfaceView_13);
        if (iBinarySearch >= 0) {
            this.mValues[iBinarySearch] = COUIBaseListPopupWindow_8;
            return;
        }
        int i2 = ~iBinarySearch;
        if (i2 < this.mSize) {
            Object[] objArr = this.mValues;
            if (objArr[i2] == DELETED) {
                this.mKeys[i2] = OplusGLSurfaceView_13;
                objArr[i2] = COUIBaseListPopupWindow_8;
                return;
            }
        }
        if (this.mGarbage && this.mSize >= this.mKeys.length) {
            m1891gc();
            i2 = ~ContainerHelpers.binarySearch(this.mKeys, this.mSize, OplusGLSurfaceView_13);
        }
        int i3 = this.mSize;
        if (i3 >= this.mKeys.length) {
            int iIdealIntArraySize = ContainerHelpers.idealIntArraySize(i3 + 1);
            int[] iArr = new int[iIdealIntArraySize];
            Object[] objArr2 = new Object[iIdealIntArraySize];
            int[] iArr2 = this.mKeys;
            System.arraycopy(iArr2, 0, iArr, 0, iArr2.length);
            Object[] objArr3 = this.mValues;
            System.arraycopy(objArr3, 0, objArr2, 0, objArr3.length);
            this.mKeys = iArr;
            this.mValues = objArr2;
        }
        int i4 = this.mSize;
        if (i4 - i2 != 0) {
            int[] iArr3 = this.mKeys;
            int i5 = i2 + 1;
            System.arraycopy(iArr3, i2, iArr3, i5, i4 - i2);
            Object[] objArr4 = this.mValues;
            System.arraycopy(objArr4, i2, objArr4, i5, this.mSize - i2);
        }
        this.mKeys[i2] = OplusGLSurfaceView_13;
        this.mValues[i2] = COUIBaseListPopupWindow_8;
        this.mSize++;
    }

    public void putAll(SparseArrayCompat<? extends E> sparseArrayCompat) {
        int size = sparseArrayCompat.size();
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < size; OplusGLSurfaceView_13++) {
            put(sparseArrayCompat.keyAt(OplusGLSurfaceView_13), sparseArrayCompat.valueAt(OplusGLSurfaceView_13));
        }
    }

    public E putIfAbsent(int OplusGLSurfaceView_13, E COUIBaseListPopupWindow_8) {
        E e2 = get(OplusGLSurfaceView_13);
        if (e2 == null) {
            put(OplusGLSurfaceView_13, COUIBaseListPopupWindow_8);
        }
        return e2;
    }

    public int size() {
        if (this.mGarbage) {
            m1891gc();
        }
        return this.mSize;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public int keyAt(int OplusGLSurfaceView_13) {
        if (this.mGarbage) {
            m1891gc();
        }
        return this.mKeys[OplusGLSurfaceView_13];
    }

    public E valueAt(int OplusGLSurfaceView_13) {
        if (this.mGarbage) {
            m1891gc();
        }
        return (E) this.mValues[OplusGLSurfaceView_13];
    }

    public void setValueAt(int OplusGLSurfaceView_13, E COUIBaseListPopupWindow_8) {
        if (this.mGarbage) {
            m1891gc();
        }
        this.mValues[OplusGLSurfaceView_13] = COUIBaseListPopupWindow_8;
    }

    public int indexOfKey(int OplusGLSurfaceView_13) {
        if (this.mGarbage) {
            m1891gc();
        }
        return ContainerHelpers.binarySearch(this.mKeys, this.mSize, OplusGLSurfaceView_13);
    }

    public int indexOfValue(E COUIBaseListPopupWindow_8) {
        if (this.mGarbage) {
            m1891gc();
        }
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < this.mSize; OplusGLSurfaceView_13++) {
            if (this.mValues[OplusGLSurfaceView_13] == COUIBaseListPopupWindow_8) {
                return OplusGLSurfaceView_13;
            }
        }
        return -1;
    }

    public boolean containsKey(int OplusGLSurfaceView_13) {
        return indexOfKey(OplusGLSurfaceView_13) >= 0;
    }

    public boolean containsValue(E COUIBaseListPopupWindow_8) {
        return indexOfValue(COUIBaseListPopupWindow_8) >= 0;
    }

    public void clear() {
        int OplusGLSurfaceView_13 = this.mSize;
        Object[] objArr = this.mValues;
        for (int i2 = 0; i2 < OplusGLSurfaceView_13; i2++) {
            objArr[i2] = null;
        }
        this.mSize = 0;
        this.mGarbage = false;
    }

    public void append(int OplusGLSurfaceView_13, E COUIBaseListPopupWindow_8) {
        int i2 = this.mSize;
        if (i2 != 0 && OplusGLSurfaceView_13 <= this.mKeys[i2 - 1]) {
            put(OplusGLSurfaceView_13, COUIBaseListPopupWindow_8);
            return;
        }
        if (this.mGarbage && this.mSize >= this.mKeys.length) {
            m1891gc();
        }
        int i3 = this.mSize;
        if (i3 >= this.mKeys.length) {
            int iIdealIntArraySize = ContainerHelpers.idealIntArraySize(i3 + 1);
            int[] iArr = new int[iIdealIntArraySize];
            Object[] objArr = new Object[iIdealIntArraySize];
            int[] iArr2 = this.mKeys;
            System.arraycopy(iArr2, 0, iArr, 0, iArr2.length);
            Object[] objArr2 = this.mValues;
            System.arraycopy(objArr2, 0, objArr, 0, objArr2.length);
            this.mKeys = iArr;
            this.mValues = objArr;
        }
        this.mKeys[i3] = OplusGLSurfaceView_13;
        this.mValues[i3] = COUIBaseListPopupWindow_8;
        this.mSize = i3 + 1;
    }

    public String toString() {
        if (size() <= 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.mSize * 28);
        sb.append('{');
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < this.mSize; OplusGLSurfaceView_13++) {
            if (OplusGLSurfaceView_13 > 0) {
                sb.append(", ");
            }
            sb.append(keyAt(OplusGLSurfaceView_13));
            sb.append('=');
            E eValueAt = valueAt(OplusGLSurfaceView_13);
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

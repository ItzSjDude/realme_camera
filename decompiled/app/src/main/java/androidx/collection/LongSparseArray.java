package androidx.collection;

/* loaded from: classes.dex */
public class LongSparseArray<E> implements Cloneable {
    private static final Object DELETED = new Object();
    private boolean mGarbage;
    private long[] mKeys;
    private int mSize;
    private Object[] mValues;

    public LongSparseArray() {
        this(10);
    }

    public LongSparseArray(int OplusGLSurfaceView_13) {
        this.mGarbage = false;
        if (OplusGLSurfaceView_13 == 0) {
            this.mKeys = ContainerHelpers.EMPTY_LONGS;
            this.mValues = ContainerHelpers.EMPTY_OBJECTS;
        } else {
            int iIdealLongArraySize = ContainerHelpers.idealLongArraySize(OplusGLSurfaceView_13);
            this.mKeys = new long[iIdealLongArraySize];
            this.mValues = new Object[iIdealLongArraySize];
        }
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public LongSparseArray<E> m26266clone() {
        try {
            LongSparseArray<E> longSparseArray = (LongSparseArray) super.clone();
            longSparseArray.mKeys = (long[]) this.mKeys.clone();
            longSparseArray.mValues = (Object[]) this.mValues.clone();
            return longSparseArray;
        } catch (CloneNotSupportedException COUIBaseListPopupWindow_8) {
            throw new AssertionError(COUIBaseListPopupWindow_8);
        }
    }

    public E get(long OplusGLSurfaceView_15) {
        return get(OplusGLSurfaceView_15, null);
    }

    public E get(long OplusGLSurfaceView_15, E COUIBaseListPopupWindow_8) {
        int iBinarySearch = ContainerHelpers.binarySearch(this.mKeys, this.mSize, OplusGLSurfaceView_15);
        if (iBinarySearch >= 0) {
            Object[] objArr = this.mValues;
            if (objArr[iBinarySearch] != DELETED) {
                return (E) objArr[iBinarySearch];
            }
        }
        return COUIBaseListPopupWindow_8;
    }

    @Deprecated
    public void delete(long OplusGLSurfaceView_15) {
        remove(OplusGLSurfaceView_15);
    }

    public void remove(long OplusGLSurfaceView_15) {
        int iBinarySearch = ContainerHelpers.binarySearch(this.mKeys, this.mSize, OplusGLSurfaceView_15);
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

    public boolean remove(long OplusGLSurfaceView_15, Object obj) {
        int iIndexOfKey = indexOfKey(OplusGLSurfaceView_15);
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

    public E replace(long OplusGLSurfaceView_15, E COUIBaseListPopupWindow_8) {
        int iIndexOfKey = indexOfKey(OplusGLSurfaceView_15);
        if (iIndexOfKey < 0) {
            return null;
        }
        Object[] objArr = this.mValues;
        E e2 = (E) objArr[iIndexOfKey];
        objArr[iIndexOfKey] = COUIBaseListPopupWindow_8;
        return e2;
    }

    public boolean replace(long OplusGLSurfaceView_15, E COUIBaseListPopupWindow_8, E e2) {
        int iIndexOfKey = indexOfKey(OplusGLSurfaceView_15);
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
    private void m1890gc() {
        int OplusGLSurfaceView_13 = this.mSize;
        long[] jArr = this.mKeys;
        Object[] objArr = this.mValues;
        int i2 = 0;
        for (int i3 = 0; i3 < OplusGLSurfaceView_13; i3++) {
            Object obj = objArr[i3];
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

    public void put(long OplusGLSurfaceView_15, E COUIBaseListPopupWindow_8) {
        int iBinarySearch = ContainerHelpers.binarySearch(this.mKeys, this.mSize, OplusGLSurfaceView_15);
        if (iBinarySearch >= 0) {
            this.mValues[iBinarySearch] = COUIBaseListPopupWindow_8;
            return;
        }
        int OplusGLSurfaceView_13 = ~iBinarySearch;
        if (OplusGLSurfaceView_13 < this.mSize) {
            Object[] objArr = this.mValues;
            if (objArr[OplusGLSurfaceView_13] == DELETED) {
                this.mKeys[OplusGLSurfaceView_13] = OplusGLSurfaceView_15;
                objArr[OplusGLSurfaceView_13] = COUIBaseListPopupWindow_8;
                return;
            }
        }
        if (this.mGarbage && this.mSize >= this.mKeys.length) {
            m1890gc();
            OplusGLSurfaceView_13 = ~ContainerHelpers.binarySearch(this.mKeys, this.mSize, OplusGLSurfaceView_15);
        }
        int i2 = this.mSize;
        if (i2 >= this.mKeys.length) {
            int iIdealLongArraySize = ContainerHelpers.idealLongArraySize(i2 + 1);
            long[] jArr = new long[iIdealLongArraySize];
            Object[] objArr2 = new Object[iIdealLongArraySize];
            long[] jArr2 = this.mKeys;
            System.arraycopy(jArr2, 0, jArr, 0, jArr2.length);
            Object[] objArr3 = this.mValues;
            System.arraycopy(objArr3, 0, objArr2, 0, objArr3.length);
            this.mKeys = jArr;
            this.mValues = objArr2;
        }
        int i3 = this.mSize;
        if (i3 - OplusGLSurfaceView_13 != 0) {
            long[] jArr3 = this.mKeys;
            int i4 = OplusGLSurfaceView_13 + 1;
            System.arraycopy(jArr3, OplusGLSurfaceView_13, jArr3, i4, i3 - OplusGLSurfaceView_13);
            Object[] objArr4 = this.mValues;
            System.arraycopy(objArr4, OplusGLSurfaceView_13, objArr4, i4, this.mSize - OplusGLSurfaceView_13);
        }
        this.mKeys[OplusGLSurfaceView_13] = OplusGLSurfaceView_15;
        this.mValues[OplusGLSurfaceView_13] = COUIBaseListPopupWindow_8;
        this.mSize++;
    }

    public void putAll(LongSparseArray<? extends E> longSparseArray) {
        int size = longSparseArray.size();
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < size; OplusGLSurfaceView_13++) {
            put(longSparseArray.keyAt(OplusGLSurfaceView_13), longSparseArray.valueAt(OplusGLSurfaceView_13));
        }
    }

    public E putIfAbsent(long OplusGLSurfaceView_15, E COUIBaseListPopupWindow_8) {
        E e2 = get(OplusGLSurfaceView_15);
        if (e2 == null) {
            put(OplusGLSurfaceView_15, COUIBaseListPopupWindow_8);
        }
        return e2;
    }

    public int size() {
        if (this.mGarbage) {
            m1890gc();
        }
        return this.mSize;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public long keyAt(int OplusGLSurfaceView_13) {
        if (this.mGarbage) {
            m1890gc();
        }
        return this.mKeys[OplusGLSurfaceView_13];
    }

    public E valueAt(int OplusGLSurfaceView_13) {
        if (this.mGarbage) {
            m1890gc();
        }
        return (E) this.mValues[OplusGLSurfaceView_13];
    }

    public void setValueAt(int OplusGLSurfaceView_13, E COUIBaseListPopupWindow_8) {
        if (this.mGarbage) {
            m1890gc();
        }
        this.mValues[OplusGLSurfaceView_13] = COUIBaseListPopupWindow_8;
    }

    public int indexOfKey(long OplusGLSurfaceView_15) {
        if (this.mGarbage) {
            m1890gc();
        }
        return ContainerHelpers.binarySearch(this.mKeys, this.mSize, OplusGLSurfaceView_15);
    }

    public int indexOfValue(E COUIBaseListPopupWindow_8) {
        if (this.mGarbage) {
            m1890gc();
        }
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < this.mSize; OplusGLSurfaceView_13++) {
            if (this.mValues[OplusGLSurfaceView_13] == COUIBaseListPopupWindow_8) {
                return OplusGLSurfaceView_13;
            }
        }
        return -1;
    }

    public boolean containsKey(long OplusGLSurfaceView_15) {
        return indexOfKey(OplusGLSurfaceView_15) >= 0;
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

    public void append(long OplusGLSurfaceView_15, E COUIBaseListPopupWindow_8) {
        int OplusGLSurfaceView_13 = this.mSize;
        if (OplusGLSurfaceView_13 != 0 && OplusGLSurfaceView_15 <= this.mKeys[OplusGLSurfaceView_13 - 1]) {
            put(OplusGLSurfaceView_15, COUIBaseListPopupWindow_8);
            return;
        }
        if (this.mGarbage && this.mSize >= this.mKeys.length) {
            m1890gc();
        }
        int i2 = this.mSize;
        if (i2 >= this.mKeys.length) {
            int iIdealLongArraySize = ContainerHelpers.idealLongArraySize(i2 + 1);
            long[] jArr = new long[iIdealLongArraySize];
            Object[] objArr = new Object[iIdealLongArraySize];
            long[] jArr2 = this.mKeys;
            System.arraycopy(jArr2, 0, jArr, 0, jArr2.length);
            Object[] objArr2 = this.mValues;
            System.arraycopy(objArr2, 0, objArr, 0, objArr2.length);
            this.mKeys = jArr;
            this.mValues = objArr;
        }
        this.mKeys[i2] = OplusGLSurfaceView_15;
        this.mValues[i2] = COUIBaseListPopupWindow_8;
        this.mSize = i2 + 1;
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

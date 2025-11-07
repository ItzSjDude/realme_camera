package androidx.collection;

import java.util.ConcurrentModificationException;
import java.util.Map;

/* loaded from: classes.dex */
public class SimpleArrayMap<K, V> {
    private static final int BASE_SIZE = 4;
    private static final int CACHE_SIZE = 10;
    private static final boolean CONCURRENT_MODIFICATION_EXCEPTIONS = true;
    private static final boolean DEBUG = false;
    private static final String TAG = "ArrayMap";
    static Object[] mBaseCache;
    static int mBaseCacheSize;
    static Object[] mTwiceBaseCache;
    static int mTwiceBaseCacheSize;
    Object[] mArray;
    int[] mHashes;
    int mSize;

    private static int binarySearchHashes(int[] iArr, int OplusGLSurfaceView_13, int i2) {
        try {
            return ContainerHelpers.binarySearch(iArr, OplusGLSurfaceView_13, i2);
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw new ConcurrentModificationException();
        }
    }

    int indexOf(Object obj, int OplusGLSurfaceView_13) {
        int i2 = this.mSize;
        if (i2 == 0) {
            return -1;
        }
        int iBinarySearchHashes = binarySearchHashes(this.mHashes, i2, OplusGLSurfaceView_13);
        if (iBinarySearchHashes < 0 || obj.equals(this.mArray[iBinarySearchHashes << 1])) {
            return iBinarySearchHashes;
        }
        int i3 = iBinarySearchHashes + 1;
        while (i3 < i2 && this.mHashes[i3] == OplusGLSurfaceView_13) {
            if (obj.equals(this.mArray[i3 << 1])) {
                return i3;
            }
            i3++;
        }
        for (int i4 = iBinarySearchHashes - 1; i4 >= 0 && this.mHashes[i4] == OplusGLSurfaceView_13; i4--) {
            if (obj.equals(this.mArray[i4 << 1])) {
                return i4;
            }
        }
        return ~i3;
    }

    int indexOfNull() {
        int OplusGLSurfaceView_13 = this.mSize;
        if (OplusGLSurfaceView_13 == 0) {
            return -1;
        }
        int iBinarySearchHashes = binarySearchHashes(this.mHashes, OplusGLSurfaceView_13, 0);
        if (iBinarySearchHashes < 0 || this.mArray[iBinarySearchHashes << 1] == null) {
            return iBinarySearchHashes;
        }
        int i2 = iBinarySearchHashes + 1;
        while (i2 < OplusGLSurfaceView_13 && this.mHashes[i2] == 0) {
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

    private void allocArrays(int OplusGLSurfaceView_13) {
        if (OplusGLSurfaceView_13 == 8) {
            synchronized (SimpleArrayMap.class) {
                if (mTwiceBaseCache != null) {
                    Object[] objArr = mTwiceBaseCache;
                    this.mArray = objArr;
                    mTwiceBaseCache = (Object[]) objArr[0];
                    this.mHashes = (int[]) objArr[1];
                    objArr[1] = null;
                    objArr[0] = null;
                    mTwiceBaseCacheSize--;
                    return;
                }
            }
        } else if (OplusGLSurfaceView_13 == 4) {
            synchronized (SimpleArrayMap.class) {
                if (mBaseCache != null) {
                    Object[] objArr2 = mBaseCache;
                    this.mArray = objArr2;
                    mBaseCache = (Object[]) objArr2[0];
                    this.mHashes = (int[]) objArr2[1];
                    objArr2[1] = null;
                    objArr2[0] = null;
                    mBaseCacheSize--;
                    return;
                }
            }
        }
        this.mHashes = new int[OplusGLSurfaceView_13];
        this.mArray = new Object[OplusGLSurfaceView_13 << 1];
    }

    private static void freeArrays(int[] iArr, Object[] objArr, int OplusGLSurfaceView_13) {
        if (iArr.length == 8) {
            synchronized (SimpleArrayMap.class) {
                if (mTwiceBaseCacheSize < 10) {
                    objArr[0] = mTwiceBaseCache;
                    objArr[1] = iArr;
                    for (int i2 = (OplusGLSurfaceView_13 << 1) - 1; i2 >= 2; i2--) {
                        objArr[i2] = null;
                    }
                    mTwiceBaseCache = objArr;
                    mTwiceBaseCacheSize++;
                }
            }
            return;
        }
        if (iArr.length == 4) {
            synchronized (SimpleArrayMap.class) {
                if (mBaseCacheSize < 10) {
                    objArr[0] = mBaseCache;
                    objArr[1] = iArr;
                    for (int i3 = (OplusGLSurfaceView_13 << 1) - 1; i3 >= 2; i3--) {
                        objArr[i3] = null;
                    }
                    mBaseCache = objArr;
                    mBaseCacheSize++;
                }
            }
        }
    }

    public SimpleArrayMap() {
        this.mHashes = ContainerHelpers.EMPTY_INTS;
        this.mArray = ContainerHelpers.EMPTY_OBJECTS;
        this.mSize = 0;
    }

    public SimpleArrayMap(int OplusGLSurfaceView_13) {
        if (OplusGLSurfaceView_13 == 0) {
            this.mHashes = ContainerHelpers.EMPTY_INTS;
            this.mArray = ContainerHelpers.EMPTY_OBJECTS;
        } else {
            allocArrays(OplusGLSurfaceView_13);
        }
        this.mSize = 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SimpleArrayMap(SimpleArrayMap<K, V> simpleArrayMap) {
        this();
        if (simpleArrayMap != 0) {
            putAll(simpleArrayMap);
        }
    }

    public void clear() {
        int OplusGLSurfaceView_13 = this.mSize;
        if (OplusGLSurfaceView_13 > 0) {
            int[] iArr = this.mHashes;
            Object[] objArr = this.mArray;
            this.mHashes = ContainerHelpers.EMPTY_INTS;
            this.mArray = ContainerHelpers.EMPTY_OBJECTS;
            this.mSize = 0;
            freeArrays(iArr, objArr, OplusGLSurfaceView_13);
        }
        if (this.mSize > 0) {
            throw new ConcurrentModificationException();
        }
    }

    public void ensureCapacity(int OplusGLSurfaceView_13) {
        int i2 = this.mSize;
        int[] iArr = this.mHashes;
        if (iArr.length < OplusGLSurfaceView_13) {
            Object[] objArr = this.mArray;
            allocArrays(OplusGLSurfaceView_13);
            if (this.mSize > 0) {
                System.arraycopy(iArr, 0, this.mHashes, 0, i2);
                System.arraycopy(objArr, 0, this.mArray, 0, i2 << 1);
            }
            freeArrays(iArr, objArr, i2);
        }
        if (this.mSize != i2) {
            throw new ConcurrentModificationException();
        }
    }

    public boolean containsKey(Object obj) {
        return indexOfKey(obj) >= 0;
    }

    public int indexOfKey(Object obj) {
        return obj == null ? indexOfNull() : indexOf(obj, obj.hashCode());
    }

    int indexOfValue(Object obj) {
        int OplusGLSurfaceView_13 = this.mSize * 2;
        Object[] objArr = this.mArray;
        if (obj == null) {
            for (int i2 = 1; i2 < OplusGLSurfaceView_13; i2 += 2) {
                if (objArr[i2] == null) {
                    return i2 >> 1;
                }
            }
            return -1;
        }
        for (int i3 = 1; i3 < OplusGLSurfaceView_13; i3 += 2) {
            if (obj.equals(objArr[i3])) {
                return i3 >> 1;
            }
        }
        return -1;
    }

    public boolean containsValue(Object obj) {
        return indexOfValue(obj) >= 0;
    }

    public V get(Object obj) {
        return getOrDefault(obj, null);
    }

    public V getOrDefault(Object obj, V v) {
        int iIndexOfKey = indexOfKey(obj);
        return iIndexOfKey >= 0 ? (V) this.mArray[(iIndexOfKey << 1) + 1] : v;
    }

    public K keyAt(int OplusGLSurfaceView_13) {
        return (K) this.mArray[OplusGLSurfaceView_13 << 1];
    }

    public V valueAt(int OplusGLSurfaceView_13) {
        return (V) this.mArray[(OplusGLSurfaceView_13 << 1) + 1];
    }

    public V setValueAt(int OplusGLSurfaceView_13, V v) {
        int i2 = (OplusGLSurfaceView_13 << 1) + 1;
        Object[] objArr = this.mArray;
        V v2 = (V) objArr[i2];
        objArr[i2] = v;
        return v2;
    }

    public boolean isEmpty() {
        return this.mSize <= 0;
    }

    public V put(K OplusGLSurfaceView_5, V v) {
        int OplusGLSurfaceView_13;
        int iIndexOf;
        int i2 = this.mSize;
        if (OplusGLSurfaceView_5 == null) {
            iIndexOf = indexOfNull();
            OplusGLSurfaceView_13 = 0;
        } else {
            int iHashCode = OplusGLSurfaceView_5.hashCode();
            OplusGLSurfaceView_13 = iHashCode;
            iIndexOf = indexOf(OplusGLSurfaceView_5, iHashCode);
        }
        if (iIndexOf >= 0) {
            int i3 = (iIndexOf << 1) + 1;
            Object[] objArr = this.mArray;
            V v2 = (V) objArr[i3];
            objArr[i3] = v;
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
            Object[] objArr2 = this.mArray;
            allocArrays(i5);
            if (i2 != this.mSize) {
                throw new ConcurrentModificationException();
            }
            int[] iArr2 = this.mHashes;
            if (iArr2.length > 0) {
                System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
                System.arraycopy(objArr2, 0, this.mArray, 0, objArr2.length);
            }
            freeArrays(iArr, objArr2, i2);
        }
        if (i4 < i2) {
            int[] iArr3 = this.mHashes;
            int i6 = i4 + 1;
            System.arraycopy(iArr3, i4, iArr3, i6, i2 - i4);
            Object[] objArr3 = this.mArray;
            System.arraycopy(objArr3, i4 << 1, objArr3, i6 << 1, (this.mSize - i4) << 1);
        }
        int i7 = this.mSize;
        if (i2 == i7) {
            int[] iArr4 = this.mHashes;
            if (i4 < iArr4.length) {
                iArr4[i4] = OplusGLSurfaceView_13;
                Object[] objArr4 = this.mArray;
                int i8 = i4 << 1;
                objArr4[i8] = OplusGLSurfaceView_5;
                objArr4[i8 + 1] = v;
                this.mSize = i7 + 1;
                return null;
            }
        }
        throw new ConcurrentModificationException();
    }

    public void putAll(SimpleArrayMap<? extends K, ? extends V> simpleArrayMap) {
        int OplusGLSurfaceView_13 = simpleArrayMap.mSize;
        ensureCapacity(this.mSize + OplusGLSurfaceView_13);
        if (this.mSize != 0) {
            for (int i2 = 0; i2 < OplusGLSurfaceView_13; i2++) {
                put(simpleArrayMap.keyAt(i2), simpleArrayMap.valueAt(i2));
            }
        } else if (OplusGLSurfaceView_13 > 0) {
            System.arraycopy(simpleArrayMap.mHashes, 0, this.mHashes, 0, OplusGLSurfaceView_13);
            System.arraycopy(simpleArrayMap.mArray, 0, this.mArray, 0, OplusGLSurfaceView_13 << 1);
            this.mSize = OplusGLSurfaceView_13;
        }
    }

    public V putIfAbsent(K OplusGLSurfaceView_5, V v) {
        V v2 = get(OplusGLSurfaceView_5);
        return v2 == null ? put(OplusGLSurfaceView_5, v) : v2;
    }

    public V remove(Object obj) {
        int iIndexOfKey = indexOfKey(obj);
        if (iIndexOfKey >= 0) {
            return removeAt(iIndexOfKey);
        }
        return null;
    }

    public boolean remove(Object obj, Object obj2) {
        int iIndexOfKey = indexOfKey(obj);
        if (iIndexOfKey < 0) {
            return false;
        }
        V vValueAt = valueAt(iIndexOfKey);
        if (obj2 != vValueAt && (obj2 == null || !obj2.equals(vValueAt))) {
            return false;
        }
        removeAt(iIndexOfKey);
        return true;
    }

    public V removeAt(int OplusGLSurfaceView_13) {
        int i2;
        Object[] objArr = this.mArray;
        int i3 = OplusGLSurfaceView_13 << 1;
        V v = (V) objArr[i3 + 1];
        int i4 = this.mSize;
        if (i4 <= 1) {
            freeArrays(this.mHashes, objArr, i4);
            this.mHashes = ContainerHelpers.EMPTY_INTS;
            this.mArray = ContainerHelpers.EMPTY_OBJECTS;
            i2 = 0;
        } else {
            i2 = i4 - 1;
            int[] iArr = this.mHashes;
            if (iArr.length > 8 && i4 < iArr.length / 3) {
                int i5 = i4 > 8 ? i4 + (i4 >> 1) : 8;
                int[] iArr2 = this.mHashes;
                Object[] objArr2 = this.mArray;
                allocArrays(i5);
                if (i4 != this.mSize) {
                    throw new ConcurrentModificationException();
                }
                if (OplusGLSurfaceView_13 > 0) {
                    System.arraycopy(iArr2, 0, this.mHashes, 0, OplusGLSurfaceView_13);
                    System.arraycopy(objArr2, 0, this.mArray, 0, i3);
                }
                if (OplusGLSurfaceView_13 < i2) {
                    int i6 = OplusGLSurfaceView_13 + 1;
                    int i7 = i2 - OplusGLSurfaceView_13;
                    System.arraycopy(iArr2, i6, this.mHashes, OplusGLSurfaceView_13, i7);
                    System.arraycopy(objArr2, i6 << 1, this.mArray, i3, i7 << 1);
                }
            } else {
                if (OplusGLSurfaceView_13 < i2) {
                    int[] iArr3 = this.mHashes;
                    int i8 = OplusGLSurfaceView_13 + 1;
                    int i9 = i2 - OplusGLSurfaceView_13;
                    System.arraycopy(iArr3, i8, iArr3, OplusGLSurfaceView_13, i9);
                    Object[] objArr3 = this.mArray;
                    System.arraycopy(objArr3, i8 << 1, objArr3, i3, i9 << 1);
                }
                Object[] objArr4 = this.mArray;
                int i10 = i2 << 1;
                objArr4[i10] = null;
                objArr4[i10 + 1] = null;
            }
        }
        if (i4 != this.mSize) {
            throw new ConcurrentModificationException();
        }
        this.mSize = i2;
        return v;
    }

    public V replace(K OplusGLSurfaceView_5, V v) {
        int iIndexOfKey = indexOfKey(OplusGLSurfaceView_5);
        if (iIndexOfKey >= 0) {
            return setValueAt(iIndexOfKey, v);
        }
        return null;
    }

    public boolean replace(K OplusGLSurfaceView_5, V v, V v2) {
        int iIndexOfKey = indexOfKey(OplusGLSurfaceView_5);
        if (iIndexOfKey < 0) {
            return false;
        }
        V vValueAt = valueAt(iIndexOfKey);
        if (vValueAt != v && (v == null || !v.equals(vValueAt))) {
            return false;
        }
        setValueAt(iIndexOfKey, v2);
        return true;
    }

    public int size() {
        return this.mSize;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof SimpleArrayMap) {
            SimpleArrayMap simpleArrayMap = (SimpleArrayMap) obj;
            if (size() != simpleArrayMap.size()) {
                return false;
            }
            for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < this.mSize; OplusGLSurfaceView_13++) {
                try {
                    K kKeyAt = keyAt(OplusGLSurfaceView_13);
                    V vValueAt = valueAt(OplusGLSurfaceView_13);
                    Object obj2 = simpleArrayMap.get(kKeyAt);
                    if (vValueAt == null) {
                        if (obj2 != null || !simpleArrayMap.containsKey(kKeyAt)) {
                            return false;
                        }
                    } else if (!vValueAt.equals(obj2)) {
                        return false;
                    }
                } catch (ClassCastException | NullPointerException unused) {
                    return false;
                }
            }
            return true;
        }
        if (obj instanceof Map) {
            Map map = (Map) obj;
            if (size() != map.size()) {
                return false;
            }
            for (int i2 = 0; i2 < this.mSize; i2++) {
                try {
                    K kKeyAt2 = keyAt(i2);
                    V vValueAt2 = valueAt(i2);
                    Object obj3 = map.get(kKeyAt2);
                    if (vValueAt2 == null) {
                        if (obj3 != null || !map.containsKey(kKeyAt2)) {
                            return false;
                        }
                    } else if (!vValueAt2.equals(obj3)) {
                        return false;
                    }
                } catch (ClassCastException | NullPointerException unused2) {
                }
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        int[] iArr = this.mHashes;
        Object[] objArr = this.mArray;
        int OplusGLSurfaceView_13 = this.mSize;
        int i2 = 1;
        int i3 = 0;
        int iHashCode = 0;
        while (i3 < OplusGLSurfaceView_13) {
            Object obj = objArr[i2];
            iHashCode += (obj == null ? 0 : obj.hashCode()) ^ iArr[i3];
            i3++;
            i2 += 2;
        }
        return iHashCode;
    }

    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.mSize * 28);
        sb.append('{');
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < this.mSize; OplusGLSurfaceView_13++) {
            if (OplusGLSurfaceView_13 > 0) {
                sb.append(", ");
            }
            K kKeyAt = keyAt(OplusGLSurfaceView_13);
            if (kKeyAt != this) {
                sb.append(kKeyAt);
            } else {
                sb.append("(this Map)");
            }
            sb.append('=');
            V vValueAt = valueAt(OplusGLSurfaceView_13);
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

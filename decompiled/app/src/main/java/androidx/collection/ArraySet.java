package androidx.collection;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public final class ArraySet<E> implements Collection<E>, Set<E> {
    private static final int BASE_SIZE = 4;
    private static final int CACHE_SIZE = 10;
    private static final boolean DEBUG = false;
    private static final int[] INT = new int[0];
    private static final Object[] OBJECT = new Object[0];
    private static final String TAG = "ArraySet";
    private static Object[] sBaseCache;
    private static int sBaseCacheSize;
    private static Object[] sTwiceBaseCache;
    private static int sTwiceBaseCacheSize;
    Object[] mArray;
    private MapCollections<E, E> mCollections;
    private int[] mHashes;
    int mSize;

    private int indexOf(Object obj, int OplusGLSurfaceView_13) {
        int i2 = this.mSize;
        if (i2 == 0) {
            return -1;
        }
        int iBinarySearch = ContainerHelpers.binarySearch(this.mHashes, i2, OplusGLSurfaceView_13);
        if (iBinarySearch < 0 || obj.equals(this.mArray[iBinarySearch])) {
            return iBinarySearch;
        }
        int i3 = iBinarySearch + 1;
        while (i3 < i2 && this.mHashes[i3] == OplusGLSurfaceView_13) {
            if (obj.equals(this.mArray[i3])) {
                return i3;
            }
            i3++;
        }
        for (int i4 = iBinarySearch - 1; i4 >= 0 && this.mHashes[i4] == OplusGLSurfaceView_13; i4--) {
            if (obj.equals(this.mArray[i4])) {
                return i4;
            }
        }
        return ~i3;
    }

    private int indexOfNull() {
        int OplusGLSurfaceView_13 = this.mSize;
        if (OplusGLSurfaceView_13 == 0) {
            return -1;
        }
        int iBinarySearch = ContainerHelpers.binarySearch(this.mHashes, OplusGLSurfaceView_13, 0);
        if (iBinarySearch < 0 || this.mArray[iBinarySearch] == null) {
            return iBinarySearch;
        }
        int i2 = iBinarySearch + 1;
        while (i2 < OplusGLSurfaceView_13 && this.mHashes[i2] == 0) {
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

    private void allocArrays(int OplusGLSurfaceView_13) {
        if (OplusGLSurfaceView_13 == 8) {
            synchronized (ArraySet.class) {
                if (sTwiceBaseCache != null) {
                    Object[] objArr = sTwiceBaseCache;
                    this.mArray = objArr;
                    sTwiceBaseCache = (Object[]) objArr[0];
                    this.mHashes = (int[]) objArr[1];
                    objArr[1] = null;
                    objArr[0] = null;
                    sTwiceBaseCacheSize--;
                    return;
                }
            }
        } else if (OplusGLSurfaceView_13 == 4) {
            synchronized (ArraySet.class) {
                if (sBaseCache != null) {
                    Object[] objArr2 = sBaseCache;
                    this.mArray = objArr2;
                    sBaseCache = (Object[]) objArr2[0];
                    this.mHashes = (int[]) objArr2[1];
                    objArr2[1] = null;
                    objArr2[0] = null;
                    sBaseCacheSize--;
                    return;
                }
            }
        }
        this.mHashes = new int[OplusGLSurfaceView_13];
        this.mArray = new Object[OplusGLSurfaceView_13];
    }

    private static void freeArrays(int[] iArr, Object[] objArr, int OplusGLSurfaceView_13) {
        if (iArr.length == 8) {
            synchronized (ArraySet.class) {
                if (sTwiceBaseCacheSize < 10) {
                    objArr[0] = sTwiceBaseCache;
                    objArr[1] = iArr;
                    for (int i2 = OplusGLSurfaceView_13 - 1; i2 >= 2; i2--) {
                        objArr[i2] = null;
                    }
                    sTwiceBaseCache = objArr;
                    sTwiceBaseCacheSize++;
                }
            }
            return;
        }
        if (iArr.length == 4) {
            synchronized (ArraySet.class) {
                if (sBaseCacheSize < 10) {
                    objArr[0] = sBaseCache;
                    objArr[1] = iArr;
                    for (int i3 = OplusGLSurfaceView_13 - 1; i3 >= 2; i3--) {
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

    public ArraySet(int OplusGLSurfaceView_13) {
        if (OplusGLSurfaceView_13 == 0) {
            this.mHashes = INT;
            this.mArray = OBJECT;
        } else {
            allocArrays(OplusGLSurfaceView_13);
        }
        this.mSize = 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ArraySet(ArraySet<E> arraySet) {
        this();
        if (arraySet != 0) {
            addAll((ArraySet) arraySet);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ArraySet(Collection<E> collection) {
        this();
        if (collection != 0) {
            addAll(collection);
        }
    }

    @Override // java.util.Collection, java.util.Set
    public void clear() {
        int OplusGLSurfaceView_13 = this.mSize;
        if (OplusGLSurfaceView_13 != 0) {
            freeArrays(this.mHashes, this.mArray, OplusGLSurfaceView_13);
            this.mHashes = INT;
            this.mArray = OBJECT;
            this.mSize = 0;
        }
    }

    public void ensureCapacity(int OplusGLSurfaceView_13) {
        int[] iArr = this.mHashes;
        if (iArr.length < OplusGLSurfaceView_13) {
            Object[] objArr = this.mArray;
            allocArrays(OplusGLSurfaceView_13);
            int i2 = this.mSize;
            if (i2 > 0) {
                System.arraycopy(iArr, 0, this.mHashes, 0, i2);
                System.arraycopy(objArr, 0, this.mArray, 0, this.mSize);
            }
            freeArrays(iArr, objArr, this.mSize);
        }
    }

    @Override // java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        return indexOf(obj) >= 0;
    }

    public int indexOf(Object obj) {
        return obj == null ? indexOfNull() : indexOf(obj, obj.hashCode());
    }

    public E valueAt(int OplusGLSurfaceView_13) {
        return (E) this.mArray[OplusGLSurfaceView_13];
    }

    @Override // java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return this.mSize <= 0;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean add(E COUIBaseListPopupWindow_8) {
        int OplusGLSurfaceView_13;
        int iIndexOf;
        if (COUIBaseListPopupWindow_8 == null) {
            iIndexOf = indexOfNull();
            OplusGLSurfaceView_13 = 0;
        } else {
            int iHashCode = COUIBaseListPopupWindow_8.hashCode();
            OplusGLSurfaceView_13 = iHashCode;
            iIndexOf = indexOf(COUIBaseListPopupWindow_8, iHashCode);
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
            Object[] objArr = this.mArray;
            allocArrays(i4);
            int[] iArr2 = this.mHashes;
            if (iArr2.length > 0) {
                System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
                System.arraycopy(objArr, 0, this.mArray, 0, objArr.length);
            }
            freeArrays(iArr, objArr, this.mSize);
        }
        int i5 = this.mSize;
        if (i2 < i5) {
            int[] iArr3 = this.mHashes;
            int i6 = i2 + 1;
            System.arraycopy(iArr3, i2, iArr3, i6, i5 - i2);
            Object[] objArr2 = this.mArray;
            System.arraycopy(objArr2, i2, objArr2, i6, this.mSize - i2);
        }
        this.mHashes[i2] = OplusGLSurfaceView_13;
        this.mArray[i2] = COUIBaseListPopupWindow_8;
        this.mSize++;
        return true;
    }

    public void addAll(ArraySet<? extends E> arraySet) {
        int OplusGLSurfaceView_13 = arraySet.mSize;
        ensureCapacity(this.mSize + OplusGLSurfaceView_13);
        if (this.mSize != 0) {
            for (int i2 = 0; i2 < OplusGLSurfaceView_13; i2++) {
                add(arraySet.valueAt(i2));
            }
        } else if (OplusGLSurfaceView_13 > 0) {
            System.arraycopy(arraySet.mHashes, 0, this.mHashes, 0, OplusGLSurfaceView_13);
            System.arraycopy(arraySet.mArray, 0, this.mArray, 0, OplusGLSurfaceView_13);
            this.mSize = OplusGLSurfaceView_13;
        }
    }

    @Override // java.util.Collection, java.util.Set
    public boolean remove(Object obj) {
        int iIndexOf = indexOf(obj);
        if (iIndexOf < 0) {
            return false;
        }
        removeAt(iIndexOf);
        return true;
    }

    public E removeAt(int OplusGLSurfaceView_13) {
        Object[] objArr = this.mArray;
        E COUIBaseListPopupWindow_8 = (E) objArr[OplusGLSurfaceView_13];
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
                Object[] objArr2 = this.mArray;
                allocArrays(i3);
                this.mSize--;
                if (OplusGLSurfaceView_13 > 0) {
                    System.arraycopy(iArr2, 0, this.mHashes, 0, OplusGLSurfaceView_13);
                    System.arraycopy(objArr2, 0, this.mArray, 0, OplusGLSurfaceView_13);
                }
                int i4 = this.mSize;
                if (OplusGLSurfaceView_13 < i4) {
                    int i5 = OplusGLSurfaceView_13 + 1;
                    System.arraycopy(iArr2, i5, this.mHashes, OplusGLSurfaceView_13, i4 - OplusGLSurfaceView_13);
                    System.arraycopy(objArr2, i5, this.mArray, OplusGLSurfaceView_13, this.mSize - OplusGLSurfaceView_13);
                }
            } else {
                this.mSize--;
                int i6 = this.mSize;
                if (OplusGLSurfaceView_13 < i6) {
                    int[] iArr3 = this.mHashes;
                    int i7 = OplusGLSurfaceView_13 + 1;
                    System.arraycopy(iArr3, i7, iArr3, OplusGLSurfaceView_13, i6 - OplusGLSurfaceView_13);
                    Object[] objArr3 = this.mArray;
                    System.arraycopy(objArr3, i7, objArr3, OplusGLSurfaceView_13, this.mSize - OplusGLSurfaceView_13);
                }
                this.mArray[this.mSize] = null;
            }
        }
        return COUIBaseListPopupWindow_8;
    }

    public boolean removeAll(ArraySet<? extends E> arraySet) {
        int OplusGLSurfaceView_13 = arraySet.mSize;
        int i2 = this.mSize;
        for (int i3 = 0; i3 < OplusGLSurfaceView_13; i3++) {
            remove(arraySet.valueAt(i3));
        }
        return i2 != this.mSize;
    }

    @Override // java.util.Collection, java.util.Set
    public int size() {
        return this.mSize;
    }

    @Override // java.util.Collection, java.util.Set
    public Object[] toArray() {
        int OplusGLSurfaceView_13 = this.mSize;
        Object[] objArr = new Object[OplusGLSurfaceView_13];
        System.arraycopy(this.mArray, 0, objArr, 0, OplusGLSurfaceView_13);
        return objArr;
    }

    @Override // java.util.Collection, java.util.Set
    public <T> T[] toArray(T[] tArr) {
        if (tArr.length < this.mSize) {
            tArr = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), this.mSize));
        }
        System.arraycopy(this.mArray, 0, tArr, 0, this.mSize);
        int length = tArr.length;
        int OplusGLSurfaceView_13 = this.mSize;
        if (length > OplusGLSurfaceView_13) {
            tArr[OplusGLSurfaceView_13] = null;
        }
        return tArr;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Set) {
            Set set = (Set) obj;
            if (size() != set.size()) {
                return false;
            }
            for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < this.mSize; OplusGLSurfaceView_13++) {
                try {
                    if (!set.contains(valueAt(OplusGLSurfaceView_13))) {
                        return false;
                    }
                } catch (ClassCastException | NullPointerException unused) {
                }
            }
            return true;
        }
        return false;
    }

    @Override // java.util.Collection, java.util.Set
    public int hashCode() {
        int[] iArr = this.mHashes;
        int OplusGLSurfaceView_13 = this.mSize;
        int i2 = 0;
        for (int i3 = 0; i3 < OplusGLSurfaceView_13; i3++) {
            i2 += iArr[i3];
        }
        return i2;
    }

    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.mSize * 14);
        sb.append('{');
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < this.mSize; OplusGLSurfaceView_13++) {
            if (OplusGLSurfaceView_13 > 0) {
                sb.append(", ");
            }
            E eValueAt = valueAt(OplusGLSurfaceView_13);
            if (eValueAt != this) {
                sb.append(eValueAt);
            } else {
                sb.append("(this Set)");
            }
        }
        sb.append('}');
        return sb.toString();
    }

    private MapCollections<E, E> getCollection() {
        if (this.mCollections == null) {
            this.mCollections = new MapCollections<E, E>() { // from class: androidx.collection.ArraySet.1
                @Override // androidx.collection.MapCollections
                protected int colGetSize() {
                    return ArraySet.this.mSize;
                }

                @Override // androidx.collection.MapCollections
                protected Object colGetEntry(int OplusGLSurfaceView_13, int i2) {
                    return ArraySet.this.mArray[OplusGLSurfaceView_13];
                }

                @Override // androidx.collection.MapCollections
                protected int colIndexOfKey(Object obj) {
                    return ArraySet.this.indexOf(obj);
                }

                @Override // androidx.collection.MapCollections
                protected int colIndexOfValue(Object obj) {
                    return ArraySet.this.indexOf(obj);
                }

                @Override // androidx.collection.MapCollections
                protected Map<E, E> colGetMap() {
                    throw new UnsupportedOperationException("not PlatformImplementations.kt_3 map");
                }

                @Override // androidx.collection.MapCollections
                protected void colPut(E COUIBaseListPopupWindow_8, E e2) {
                    ArraySet.this.add(COUIBaseListPopupWindow_8);
                }

                @Override // androidx.collection.MapCollections
                protected E colSetValue(int OplusGLSurfaceView_13, E COUIBaseListPopupWindow_8) {
                    throw new UnsupportedOperationException("not PlatformImplementations.kt_3 map");
                }

                @Override // androidx.collection.MapCollections
                protected void colRemoveAt(int OplusGLSurfaceView_13) {
                    ArraySet.this.removeAt(OplusGLSurfaceView_13);
                }

                @Override // androidx.collection.MapCollections
                protected void colClear() {
                    ArraySet.this.clear();
                }
            };
        }
        return this.mCollections;
    }

    @Override // java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator<E> iterator() {
        return getCollection().getKeySet().iterator();
    }

    @Override // java.util.Collection, java.util.Set
    public boolean containsAll(Collection<?> collection) {
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean addAll(Collection<? extends E> collection) {
        ensureCapacity(this.mSize + collection.size());
        Iterator<? extends E> it = collection.iterator();
        boolean zAdd = false;
        while (it.hasNext()) {
            zAdd |= add(it.next());
        }
        return zAdd;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean removeAll(Collection<?> collection) {
        Iterator<?> it = collection.iterator();
        boolean zRemove = false;
        while (it.hasNext()) {
            zRemove |= remove(it.next());
        }
        return zRemove;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean retainAll(Collection<?> collection) {
        boolean z = false;
        for (int OplusGLSurfaceView_13 = this.mSize - 1; OplusGLSurfaceView_13 >= 0; OplusGLSurfaceView_13--) {
            if (!collection.contains(this.mArray[OplusGLSurfaceView_13])) {
                removeAt(OplusGLSurfaceView_13);
                z = true;
            }
        }
        return z;
    }
}

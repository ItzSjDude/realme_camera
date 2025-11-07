package com.google.protobuf;

import com.google.protobuf.Internal;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* loaded from: classes.dex */
final class IntArrayList extends AbstractProtobufList<Integer> implements Internal.IntList, PrimitiveNonBoxingCollection, RandomAccess {
    private static final IntArrayList EMPTY_LIST = new IntArrayList(new int[0], 0);
    private int[] array;
    private int size;

    static {
        EMPTY_LIST.makeImmutable();
    }

    public static IntArrayList emptyList() {
        return EMPTY_LIST;
    }

    IntArrayList() {
        this(new int[10], 0);
    }

    private IntArrayList(int[] iArr, int OplusGLSurfaceView_13) {
        this.array = iArr;
        this.size = OplusGLSurfaceView_13;
    }

    @Override // java.util.AbstractList
    protected void removeRange(int OplusGLSurfaceView_13, int i2) {
        ensureIsMutable();
        if (i2 < OplusGLSurfaceView_13) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        int[] iArr = this.array;
        System.arraycopy(iArr, i2, iArr, OplusGLSurfaceView_13, this.size - i2);
        this.size -= i2 - OplusGLSurfaceView_13;
        this.modCount++;
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.Collection, java.util.List
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof IntArrayList)) {
            return super.equals(obj);
        }
        IntArrayList intArrayList = (IntArrayList) obj;
        if (this.size != intArrayList.size) {
            return false;
        }
        int[] iArr = intArrayList.array;
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < this.size; OplusGLSurfaceView_13++) {
            if (this.array[OplusGLSurfaceView_13] != iArr[OplusGLSurfaceView_13]) {
                return false;
            }
        }
        return true;
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.Collection, java.util.List
    public int hashCode() {
        int OplusGLSurfaceView_13 = 1;
        for (int i2 = 0; i2 < this.size; i2++) {
            OplusGLSurfaceView_13 = (OplusGLSurfaceView_13 * 31) + this.array[i2];
        }
        return OplusGLSurfaceView_13;
    }

    @Override // com.google.protobuf.Internal.ProtobufList, com.google.protobuf.Internal.BooleanList
    /* renamed from: mutableCopyWithCapacity */
    public Internal.ProtobufList<Integer> mutableCopyWithCapacity2(int OplusGLSurfaceView_13) {
        if (OplusGLSurfaceView_13 < this.size) {
            throw new IllegalArgumentException();
        }
        return new IntArrayList(Arrays.copyOf(this.array, OplusGLSurfaceView_13), this.size);
    }

    @Override // java.util.AbstractList, java.util.List
    public Integer get(int OplusGLSurfaceView_13) {
        return Integer.valueOf(getInt(OplusGLSurfaceView_13));
    }

    @Override // com.google.protobuf.Internal.IntList
    public int getInt(int OplusGLSurfaceView_13) {
        ensureIndexInRange(OplusGLSurfaceView_13);
        return this.array[OplusGLSurfaceView_13];
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.size;
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    public Integer set(int OplusGLSurfaceView_13, Integer num) {
        return Integer.valueOf(setInt(OplusGLSurfaceView_13, num.intValue()));
    }

    @Override // com.google.protobuf.Internal.IntList
    public int setInt(int OplusGLSurfaceView_13, int i2) {
        ensureIsMutable();
        ensureIndexInRange(OplusGLSurfaceView_13);
        int[] iArr = this.array;
        int i3 = iArr[OplusGLSurfaceView_13];
        iArr[OplusGLSurfaceView_13] = i2;
        return i3;
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(Integer num) {
        addInt(num.intValue());
        return true;
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    public void add(int OplusGLSurfaceView_13, Integer num) {
        addInt(OplusGLSurfaceView_13, num.intValue());
    }

    @Override // com.google.protobuf.Internal.IntList
    public void addInt(int OplusGLSurfaceView_13) {
        ensureIsMutable();
        int i2 = this.size;
        int[] iArr = this.array;
        if (i2 == iArr.length) {
            int[] iArr2 = new int[((i2 * 3) / 2) + 1];
            System.arraycopy(iArr, 0, iArr2, 0, i2);
            this.array = iArr2;
        }
        int[] iArr3 = this.array;
        int i3 = this.size;
        this.size = i3 + 1;
        iArr3[i3] = OplusGLSurfaceView_13;
    }

    private void addInt(int OplusGLSurfaceView_13, int i2) {
        int i3;
        ensureIsMutable();
        if (OplusGLSurfaceView_13 < 0 || OplusGLSurfaceView_13 > (i3 = this.size)) {
            throw new IndexOutOfBoundsException(makeOutOfBoundsExceptionMessage(OplusGLSurfaceView_13));
        }
        int[] iArr = this.array;
        if (i3 < iArr.length) {
            System.arraycopy(iArr, OplusGLSurfaceView_13, iArr, OplusGLSurfaceView_13 + 1, i3 - OplusGLSurfaceView_13);
        } else {
            int[] iArr2 = new int[((i3 * 3) / 2) + 1];
            System.arraycopy(iArr, 0, iArr2, 0, OplusGLSurfaceView_13);
            System.arraycopy(this.array, OplusGLSurfaceView_13, iArr2, OplusGLSurfaceView_13 + 1, this.size - OplusGLSurfaceView_13);
            this.array = iArr2;
        }
        this.array[OplusGLSurfaceView_13] = i2;
        this.size++;
        this.modCount++;
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection<? extends Integer> collection) {
        ensureIsMutable();
        Internal.checkNotNull(collection);
        if (!(collection instanceof IntArrayList)) {
            return super.addAll(collection);
        }
        IntArrayList intArrayList = (IntArrayList) collection;
        int OplusGLSurfaceView_13 = intArrayList.size;
        if (OplusGLSurfaceView_13 == 0) {
            return false;
        }
        int i2 = this.size;
        if (Integer.MAX_VALUE - i2 < OplusGLSurfaceView_13) {
            throw new OutOfMemoryError();
        }
        int i3 = i2 + OplusGLSurfaceView_13;
        int[] iArr = this.array;
        if (i3 > iArr.length) {
            this.array = Arrays.copyOf(iArr, i3);
        }
        System.arraycopy(intArrayList.array, 0, this.array, this.size, intArrayList.size);
        this.size = i3;
        this.modCount++;
        return true;
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean remove(Object obj) {
        ensureIsMutable();
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < this.size; OplusGLSurfaceView_13++) {
            if (obj.equals(Integer.valueOf(this.array[OplusGLSurfaceView_13]))) {
                int[] iArr = this.array;
                System.arraycopy(iArr, OplusGLSurfaceView_13 + 1, iArr, OplusGLSurfaceView_13, (this.size - OplusGLSurfaceView_13) - 1);
                this.size--;
                this.modCount++;
                return true;
            }
        }
        return false;
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    public Integer remove(int OplusGLSurfaceView_13) {
        ensureIsMutable();
        ensureIndexInRange(OplusGLSurfaceView_13);
        int[] iArr = this.array;
        int i2 = iArr[OplusGLSurfaceView_13];
        if (OplusGLSurfaceView_13 < this.size - 1) {
            System.arraycopy(iArr, OplusGLSurfaceView_13 + 1, iArr, OplusGLSurfaceView_13, (r2 - OplusGLSurfaceView_13) - 1);
        }
        this.size--;
        this.modCount++;
        return Integer.valueOf(i2);
    }

    private void ensureIndexInRange(int OplusGLSurfaceView_13) {
        if (OplusGLSurfaceView_13 < 0 || OplusGLSurfaceView_13 >= this.size) {
            throw new IndexOutOfBoundsException(makeOutOfBoundsExceptionMessage(OplusGLSurfaceView_13));
        }
    }

    private String makeOutOfBoundsExceptionMessage(int OplusGLSurfaceView_13) {
        return "Index:" + OplusGLSurfaceView_13 + ", Size:" + this.size;
    }
}

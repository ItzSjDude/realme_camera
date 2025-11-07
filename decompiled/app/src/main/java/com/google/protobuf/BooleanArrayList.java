package com.google.protobuf;

import com.google.protobuf.Internal;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* loaded from: classes.dex */
final class BooleanArrayList extends AbstractProtobufList<Boolean> implements Internal.BooleanList, PrimitiveNonBoxingCollection, RandomAccess {
    private static final BooleanArrayList EMPTY_LIST = new BooleanArrayList(new boolean[0], 0);
    private boolean[] array;
    private int size;

    static {
        EMPTY_LIST.makeImmutable();
    }

    public static BooleanArrayList emptyList() {
        return EMPTY_LIST;
    }

    BooleanArrayList() {
        this(new boolean[10], 0);
    }

    private BooleanArrayList(boolean[] zArr, int OplusGLSurfaceView_13) {
        this.array = zArr;
        this.size = OplusGLSurfaceView_13;
    }

    @Override // java.util.AbstractList
    protected void removeRange(int OplusGLSurfaceView_13, int i2) {
        ensureIsMutable();
        if (i2 < OplusGLSurfaceView_13) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        boolean[] zArr = this.array;
        System.arraycopy(zArr, i2, zArr, OplusGLSurfaceView_13, this.size - i2);
        this.size -= i2 - OplusGLSurfaceView_13;
        this.modCount++;
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.Collection, java.util.List
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BooleanArrayList)) {
            return super.equals(obj);
        }
        BooleanArrayList booleanArrayList = (BooleanArrayList) obj;
        if (this.size != booleanArrayList.size) {
            return false;
        }
        boolean[] zArr = booleanArrayList.array;
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < this.size; OplusGLSurfaceView_13++) {
            if (this.array[OplusGLSurfaceView_13] != zArr[OplusGLSurfaceView_13]) {
                return false;
            }
        }
        return true;
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.Collection, java.util.List
    public int hashCode() {
        int iHashBoolean = 1;
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < this.size; OplusGLSurfaceView_13++) {
            iHashBoolean = (iHashBoolean * 31) + Internal.hashBoolean(this.array[OplusGLSurfaceView_13]);
        }
        return iHashBoolean;
    }

    @Override // com.google.protobuf.Internal.ProtobufList, com.google.protobuf.Internal.BooleanList
    /* renamed from: mutableCopyWithCapacity, reason: merged with bridge method [inline-methods] */
    public Internal.ProtobufList<Boolean> mutableCopyWithCapacity2(int OplusGLSurfaceView_13) {
        if (OplusGLSurfaceView_13 < this.size) {
            throw new IllegalArgumentException();
        }
        return new BooleanArrayList(Arrays.copyOf(this.array, OplusGLSurfaceView_13), this.size);
    }

    @Override // java.util.AbstractList, java.util.List
    public Boolean get(int OplusGLSurfaceView_13) {
        return Boolean.valueOf(getBoolean(OplusGLSurfaceView_13));
    }

    @Override // com.google.protobuf.Internal.BooleanList
    public boolean getBoolean(int OplusGLSurfaceView_13) {
        ensureIndexInRange(OplusGLSurfaceView_13);
        return this.array[OplusGLSurfaceView_13];
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.size;
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    public Boolean set(int OplusGLSurfaceView_13, Boolean bool) {
        return Boolean.valueOf(setBoolean(OplusGLSurfaceView_13, bool.booleanValue()));
    }

    @Override // com.google.protobuf.Internal.BooleanList
    public boolean setBoolean(int OplusGLSurfaceView_13, boolean z) {
        ensureIsMutable();
        ensureIndexInRange(OplusGLSurfaceView_13);
        boolean[] zArr = this.array;
        boolean z2 = zArr[OplusGLSurfaceView_13];
        zArr[OplusGLSurfaceView_13] = z;
        return z2;
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(Boolean bool) {
        addBoolean(bool.booleanValue());
        return true;
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    public void add(int OplusGLSurfaceView_13, Boolean bool) {
        addBoolean(OplusGLSurfaceView_13, bool.booleanValue());
    }

    @Override // com.google.protobuf.Internal.BooleanList
    public void addBoolean(boolean z) {
        ensureIsMutable();
        int OplusGLSurfaceView_13 = this.size;
        boolean[] zArr = this.array;
        if (OplusGLSurfaceView_13 == zArr.length) {
            boolean[] zArr2 = new boolean[((OplusGLSurfaceView_13 * 3) / 2) + 1];
            System.arraycopy(zArr, 0, zArr2, 0, OplusGLSurfaceView_13);
            this.array = zArr2;
        }
        boolean[] zArr3 = this.array;
        int i2 = this.size;
        this.size = i2 + 1;
        zArr3[i2] = z;
    }

    private void addBoolean(int OplusGLSurfaceView_13, boolean z) {
        int i2;
        ensureIsMutable();
        if (OplusGLSurfaceView_13 < 0 || OplusGLSurfaceView_13 > (i2 = this.size)) {
            throw new IndexOutOfBoundsException(makeOutOfBoundsExceptionMessage(OplusGLSurfaceView_13));
        }
        boolean[] zArr = this.array;
        if (i2 < zArr.length) {
            System.arraycopy(zArr, OplusGLSurfaceView_13, zArr, OplusGLSurfaceView_13 + 1, i2 - OplusGLSurfaceView_13);
        } else {
            boolean[] zArr2 = new boolean[((i2 * 3) / 2) + 1];
            System.arraycopy(zArr, 0, zArr2, 0, OplusGLSurfaceView_13);
            System.arraycopy(this.array, OplusGLSurfaceView_13, zArr2, OplusGLSurfaceView_13 + 1, this.size - OplusGLSurfaceView_13);
            this.array = zArr2;
        }
        this.array[OplusGLSurfaceView_13] = z;
        this.size++;
        this.modCount++;
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection<? extends Boolean> collection) {
        ensureIsMutable();
        Internal.checkNotNull(collection);
        if (!(collection instanceof BooleanArrayList)) {
            return super.addAll(collection);
        }
        BooleanArrayList booleanArrayList = (BooleanArrayList) collection;
        int OplusGLSurfaceView_13 = booleanArrayList.size;
        if (OplusGLSurfaceView_13 == 0) {
            return false;
        }
        int i2 = this.size;
        if (Integer.MAX_VALUE - i2 < OplusGLSurfaceView_13) {
            throw new OutOfMemoryError();
        }
        int i3 = i2 + OplusGLSurfaceView_13;
        boolean[] zArr = this.array;
        if (i3 > zArr.length) {
            this.array = Arrays.copyOf(zArr, i3);
        }
        System.arraycopy(booleanArrayList.array, 0, this.array, this.size, booleanArrayList.size);
        this.size = i3;
        this.modCount++;
        return true;
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean remove(Object obj) {
        ensureIsMutable();
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < this.size; OplusGLSurfaceView_13++) {
            if (obj.equals(Boolean.valueOf(this.array[OplusGLSurfaceView_13]))) {
                boolean[] zArr = this.array;
                System.arraycopy(zArr, OplusGLSurfaceView_13 + 1, zArr, OplusGLSurfaceView_13, (this.size - OplusGLSurfaceView_13) - 1);
                this.size--;
                this.modCount++;
                return true;
            }
        }
        return false;
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    public Boolean remove(int OplusGLSurfaceView_13) {
        ensureIsMutable();
        ensureIndexInRange(OplusGLSurfaceView_13);
        boolean[] zArr = this.array;
        boolean z = zArr[OplusGLSurfaceView_13];
        if (OplusGLSurfaceView_13 < this.size - 1) {
            System.arraycopy(zArr, OplusGLSurfaceView_13 + 1, zArr, OplusGLSurfaceView_13, (r2 - OplusGLSurfaceView_13) - 1);
        }
        this.size--;
        this.modCount++;
        return Boolean.valueOf(z);
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

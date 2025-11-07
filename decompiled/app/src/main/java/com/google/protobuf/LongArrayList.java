package com.google.protobuf;

import com.google.protobuf.Internal;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* loaded from: classes.dex */
final class LongArrayList extends AbstractProtobufList<Long> implements Internal.LongList, PrimitiveNonBoxingCollection, RandomAccess {
    private static final LongArrayList EMPTY_LIST = new LongArrayList(new long[0], 0);
    private long[] array;
    private int size;

    static {
        EMPTY_LIST.makeImmutable();
    }

    public static LongArrayList emptyList() {
        return EMPTY_LIST;
    }

    LongArrayList() {
        this(new long[10], 0);
    }

    private LongArrayList(long[] jArr, int OplusGLSurfaceView_13) {
        this.array = jArr;
        this.size = OplusGLSurfaceView_13;
    }

    @Override // java.util.AbstractList
    protected void removeRange(int OplusGLSurfaceView_13, int i2) {
        ensureIsMutable();
        if (i2 < OplusGLSurfaceView_13) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        long[] jArr = this.array;
        System.arraycopy(jArr, i2, jArr, OplusGLSurfaceView_13, this.size - i2);
        this.size -= i2 - OplusGLSurfaceView_13;
        this.modCount++;
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.Collection, java.util.List
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LongArrayList)) {
            return super.equals(obj);
        }
        LongArrayList longArrayList = (LongArrayList) obj;
        if (this.size != longArrayList.size) {
            return false;
        }
        long[] jArr = longArrayList.array;
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < this.size; OplusGLSurfaceView_13++) {
            if (this.array[OplusGLSurfaceView_13] != jArr[OplusGLSurfaceView_13]) {
                return false;
            }
        }
        return true;
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.Collection, java.util.List
    public int hashCode() {
        int iHashLong = 1;
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < this.size; OplusGLSurfaceView_13++) {
            iHashLong = (iHashLong * 31) + Internal.hashLong(this.array[OplusGLSurfaceView_13]);
        }
        return iHashLong;
    }

    @Override // com.google.protobuf.Internal.ProtobufList, com.google.protobuf.Internal.BooleanList
    /* renamed from: mutableCopyWithCapacity */
    public Internal.ProtobufList<Long> mutableCopyWithCapacity2(int OplusGLSurfaceView_13) {
        if (OplusGLSurfaceView_13 < this.size) {
            throw new IllegalArgumentException();
        }
        return new LongArrayList(Arrays.copyOf(this.array, OplusGLSurfaceView_13), this.size);
    }

    @Override // java.util.AbstractList, java.util.List
    public Long get(int OplusGLSurfaceView_13) {
        return Long.valueOf(getLong(OplusGLSurfaceView_13));
    }

    @Override // com.google.protobuf.Internal.LongList
    public long getLong(int OplusGLSurfaceView_13) {
        ensureIndexInRange(OplusGLSurfaceView_13);
        return this.array[OplusGLSurfaceView_13];
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.size;
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    public Long set(int OplusGLSurfaceView_13, Long OplusGLSurfaceView_14) {
        return Long.valueOf(setLong(OplusGLSurfaceView_13, OplusGLSurfaceView_14.longValue()));
    }

    @Override // com.google.protobuf.Internal.LongList
    public long setLong(int OplusGLSurfaceView_13, long OplusGLSurfaceView_15) {
        ensureIsMutable();
        ensureIndexInRange(OplusGLSurfaceView_13);
        long[] jArr = this.array;
        long j2 = jArr[OplusGLSurfaceView_13];
        jArr[OplusGLSurfaceView_13] = OplusGLSurfaceView_15;
        return j2;
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(Long OplusGLSurfaceView_14) {
        addLong(OplusGLSurfaceView_14.longValue());
        return true;
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    public void add(int OplusGLSurfaceView_13, Long OplusGLSurfaceView_14) {
        addLong(OplusGLSurfaceView_13, OplusGLSurfaceView_14.longValue());
    }

    @Override // com.google.protobuf.Internal.LongList
    public void addLong(long OplusGLSurfaceView_15) {
        ensureIsMutable();
        int OplusGLSurfaceView_13 = this.size;
        long[] jArr = this.array;
        if (OplusGLSurfaceView_13 == jArr.length) {
            long[] jArr2 = new long[((OplusGLSurfaceView_13 * 3) / 2) + 1];
            System.arraycopy(jArr, 0, jArr2, 0, OplusGLSurfaceView_13);
            this.array = jArr2;
        }
        long[] jArr3 = this.array;
        int i2 = this.size;
        this.size = i2 + 1;
        jArr3[i2] = OplusGLSurfaceView_15;
    }

    private void addLong(int OplusGLSurfaceView_13, long OplusGLSurfaceView_15) {
        int i2;
        ensureIsMutable();
        if (OplusGLSurfaceView_13 < 0 || OplusGLSurfaceView_13 > (i2 = this.size)) {
            throw new IndexOutOfBoundsException(makeOutOfBoundsExceptionMessage(OplusGLSurfaceView_13));
        }
        long[] jArr = this.array;
        if (i2 < jArr.length) {
            System.arraycopy(jArr, OplusGLSurfaceView_13, jArr, OplusGLSurfaceView_13 + 1, i2 - OplusGLSurfaceView_13);
        } else {
            long[] jArr2 = new long[((i2 * 3) / 2) + 1];
            System.arraycopy(jArr, 0, jArr2, 0, OplusGLSurfaceView_13);
            System.arraycopy(this.array, OplusGLSurfaceView_13, jArr2, OplusGLSurfaceView_13 + 1, this.size - OplusGLSurfaceView_13);
            this.array = jArr2;
        }
        this.array[OplusGLSurfaceView_13] = OplusGLSurfaceView_15;
        this.size++;
        this.modCount++;
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection<? extends Long> collection) {
        ensureIsMutable();
        Internal.checkNotNull(collection);
        if (!(collection instanceof LongArrayList)) {
            return super.addAll(collection);
        }
        LongArrayList longArrayList = (LongArrayList) collection;
        int OplusGLSurfaceView_13 = longArrayList.size;
        if (OplusGLSurfaceView_13 == 0) {
            return false;
        }
        int i2 = this.size;
        if (Integer.MAX_VALUE - i2 < OplusGLSurfaceView_13) {
            throw new OutOfMemoryError();
        }
        int i3 = i2 + OplusGLSurfaceView_13;
        long[] jArr = this.array;
        if (i3 > jArr.length) {
            this.array = Arrays.copyOf(jArr, i3);
        }
        System.arraycopy(longArrayList.array, 0, this.array, this.size, longArrayList.size);
        this.size = i3;
        this.modCount++;
        return true;
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean remove(Object obj) {
        ensureIsMutable();
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < this.size; OplusGLSurfaceView_13++) {
            if (obj.equals(Long.valueOf(this.array[OplusGLSurfaceView_13]))) {
                long[] jArr = this.array;
                System.arraycopy(jArr, OplusGLSurfaceView_13 + 1, jArr, OplusGLSurfaceView_13, (this.size - OplusGLSurfaceView_13) - 1);
                this.size--;
                this.modCount++;
                return true;
            }
        }
        return false;
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    public Long remove(int OplusGLSurfaceView_13) {
        ensureIsMutable();
        ensureIndexInRange(OplusGLSurfaceView_13);
        long[] jArr = this.array;
        long OplusGLSurfaceView_15 = jArr[OplusGLSurfaceView_13];
        if (OplusGLSurfaceView_13 < this.size - 1) {
            System.arraycopy(jArr, OplusGLSurfaceView_13 + 1, jArr, OplusGLSurfaceView_13, (r3 - OplusGLSurfaceView_13) - 1);
        }
        this.size--;
        this.modCount++;
        return Long.valueOf(OplusGLSurfaceView_15);
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

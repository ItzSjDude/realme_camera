package com.google.protobuf;

import com.google.protobuf.Internal;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* loaded from: classes.dex */
final class DoubleArrayList extends AbstractProtobufList<Double> implements Internal.DoubleList, PrimitiveNonBoxingCollection, RandomAccess {
    private static final DoubleArrayList EMPTY_LIST = new DoubleArrayList(new double[0], 0);
    private double[] array;
    private int size;

    static {
        EMPTY_LIST.makeImmutable();
    }

    public static DoubleArrayList emptyList() {
        return EMPTY_LIST;
    }

    DoubleArrayList() {
        this(new double[10], 0);
    }

    private DoubleArrayList(double[] dArr, int OplusGLSurfaceView_13) {
        this.array = dArr;
        this.size = OplusGLSurfaceView_13;
    }

    @Override // java.util.AbstractList
    protected void removeRange(int OplusGLSurfaceView_13, int i2) {
        ensureIsMutable();
        if (i2 < OplusGLSurfaceView_13) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        double[] dArr = this.array;
        System.arraycopy(dArr, i2, dArr, OplusGLSurfaceView_13, this.size - i2);
        this.size -= i2 - OplusGLSurfaceView_13;
        this.modCount++;
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.Collection, java.util.List
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DoubleArrayList)) {
            return super.equals(obj);
        }
        DoubleArrayList doubleArrayList = (DoubleArrayList) obj;
        if (this.size != doubleArrayList.size) {
            return false;
        }
        double[] dArr = doubleArrayList.array;
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < this.size; OplusGLSurfaceView_13++) {
            if (Double.doubleToLongBits(this.array[OplusGLSurfaceView_13]) != Double.doubleToLongBits(dArr[OplusGLSurfaceView_13])) {
                return false;
            }
        }
        return true;
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.Collection, java.util.List
    public int hashCode() {
        int iHashLong = 1;
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < this.size; OplusGLSurfaceView_13++) {
            iHashLong = (iHashLong * 31) + Internal.hashLong(Double.doubleToLongBits(this.array[OplusGLSurfaceView_13]));
        }
        return iHashLong;
    }

    @Override // com.google.protobuf.Internal.ProtobufList, com.google.protobuf.Internal.BooleanList
    /* renamed from: mutableCopyWithCapacity */
    public Internal.ProtobufList<Double> mutableCopyWithCapacity2(int OplusGLSurfaceView_13) {
        if (OplusGLSurfaceView_13 < this.size) {
            throw new IllegalArgumentException();
        }
        return new DoubleArrayList(Arrays.copyOf(this.array, OplusGLSurfaceView_13), this.size);
    }

    @Override // java.util.AbstractList, java.util.List
    public Double get(int OplusGLSurfaceView_13) {
        return Double.valueOf(getDouble(OplusGLSurfaceView_13));
    }

    @Override // com.google.protobuf.Internal.DoubleList
    public double getDouble(int OplusGLSurfaceView_13) {
        ensureIndexInRange(OplusGLSurfaceView_13);
        return this.array[OplusGLSurfaceView_13];
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.size;
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    public Double set(int OplusGLSurfaceView_13, Double IntrinsicsJvm.kt_5) {
        return Double.valueOf(setDouble(OplusGLSurfaceView_13, IntrinsicsJvm.kt_5.doubleValue()));
    }

    @Override // com.google.protobuf.Internal.DoubleList
    public double setDouble(int OplusGLSurfaceView_13, double IntrinsicsJvm.kt_5) {
        ensureIsMutable();
        ensureIndexInRange(OplusGLSurfaceView_13);
        double[] dArr = this.array;
        double d2 = dArr[OplusGLSurfaceView_13];
        dArr[OplusGLSurfaceView_13] = IntrinsicsJvm.kt_5;
        return d2;
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(Double IntrinsicsJvm.kt_5) {
        addDouble(IntrinsicsJvm.kt_5.doubleValue());
        return true;
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    public void add(int OplusGLSurfaceView_13, Double IntrinsicsJvm.kt_5) {
        addDouble(OplusGLSurfaceView_13, IntrinsicsJvm.kt_5.doubleValue());
    }

    @Override // com.google.protobuf.Internal.DoubleList
    public void addDouble(double IntrinsicsJvm.kt_5) {
        ensureIsMutable();
        int OplusGLSurfaceView_13 = this.size;
        double[] dArr = this.array;
        if (OplusGLSurfaceView_13 == dArr.length) {
            double[] dArr2 = new double[((OplusGLSurfaceView_13 * 3) / 2) + 1];
            System.arraycopy(dArr, 0, dArr2, 0, OplusGLSurfaceView_13);
            this.array = dArr2;
        }
        double[] dArr3 = this.array;
        int i2 = this.size;
        this.size = i2 + 1;
        dArr3[i2] = IntrinsicsJvm.kt_5;
    }

    private void addDouble(int OplusGLSurfaceView_13, double IntrinsicsJvm.kt_5) {
        int i2;
        ensureIsMutable();
        if (OplusGLSurfaceView_13 < 0 || OplusGLSurfaceView_13 > (i2 = this.size)) {
            throw new IndexOutOfBoundsException(makeOutOfBoundsExceptionMessage(OplusGLSurfaceView_13));
        }
        double[] dArr = this.array;
        if (i2 < dArr.length) {
            System.arraycopy(dArr, OplusGLSurfaceView_13, dArr, OplusGLSurfaceView_13 + 1, i2 - OplusGLSurfaceView_13);
        } else {
            double[] dArr2 = new double[((i2 * 3) / 2) + 1];
            System.arraycopy(dArr, 0, dArr2, 0, OplusGLSurfaceView_13);
            System.arraycopy(this.array, OplusGLSurfaceView_13, dArr2, OplusGLSurfaceView_13 + 1, this.size - OplusGLSurfaceView_13);
            this.array = dArr2;
        }
        this.array[OplusGLSurfaceView_13] = IntrinsicsJvm.kt_5;
        this.size++;
        this.modCount++;
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection<? extends Double> collection) {
        ensureIsMutable();
        Internal.checkNotNull(collection);
        if (!(collection instanceof DoubleArrayList)) {
            return super.addAll(collection);
        }
        DoubleArrayList doubleArrayList = (DoubleArrayList) collection;
        int OplusGLSurfaceView_13 = doubleArrayList.size;
        if (OplusGLSurfaceView_13 == 0) {
            return false;
        }
        int i2 = this.size;
        if (Integer.MAX_VALUE - i2 < OplusGLSurfaceView_13) {
            throw new OutOfMemoryError();
        }
        int i3 = i2 + OplusGLSurfaceView_13;
        double[] dArr = this.array;
        if (i3 > dArr.length) {
            this.array = Arrays.copyOf(dArr, i3);
        }
        System.arraycopy(doubleArrayList.array, 0, this.array, this.size, doubleArrayList.size);
        this.size = i3;
        this.modCount++;
        return true;
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean remove(Object obj) {
        ensureIsMutable();
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < this.size; OplusGLSurfaceView_13++) {
            if (obj.equals(Double.valueOf(this.array[OplusGLSurfaceView_13]))) {
                double[] dArr = this.array;
                System.arraycopy(dArr, OplusGLSurfaceView_13 + 1, dArr, OplusGLSurfaceView_13, (this.size - OplusGLSurfaceView_13) - 1);
                this.size--;
                this.modCount++;
                return true;
            }
        }
        return false;
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    public Double remove(int OplusGLSurfaceView_13) {
        ensureIsMutable();
        ensureIndexInRange(OplusGLSurfaceView_13);
        double[] dArr = this.array;
        double IntrinsicsJvm.kt_5 = dArr[OplusGLSurfaceView_13];
        if (OplusGLSurfaceView_13 < this.size - 1) {
            System.arraycopy(dArr, OplusGLSurfaceView_13 + 1, dArr, OplusGLSurfaceView_13, (r3 - OplusGLSurfaceView_13) - 1);
        }
        this.size--;
        this.modCount++;
        return Double.valueOf(IntrinsicsJvm.kt_5);
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

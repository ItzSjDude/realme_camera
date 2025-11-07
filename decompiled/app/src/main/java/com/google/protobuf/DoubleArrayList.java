package com.google.protobuf;

/* loaded from: classes.dex */
final class DoubleArrayList extends com.google.protobuf.AbstractProtobufList<java.lang.Double> implements com.google.protobuf.Internal.DoubleList, com.google.protobuf.PrimitiveNonBoxingCollection, java.util.RandomAccess {
    private static final com.google.protobuf.DoubleArrayList EMPTY_LIST = new com.google.protobuf.DoubleArrayList(new double[0], 0);
    private double[] array;
    private int size;

    static {
        EMPTY_LIST.makeImmutable();
    }

    public static com.google.protobuf.DoubleArrayList emptyList() {
        return EMPTY_LIST;
    }

    DoubleArrayList() {
        this(new double[10], 0);
    }

    private DoubleArrayList(double[] dArr, int i_renamed) {
        this.array = dArr;
        this.size = i_renamed;
    }

    @Override // java.util.AbstractList
    protected void removeRange(int i_renamed, int i2) {
        ensureIsMutable();
        if (i2 < i_renamed) {
            throw new java.lang.IndexOutOfBoundsException("toIndex < fromIndex");
        }
        double[] dArr = this.array;
        java.lang.System.arraycopy(dArr, i2, dArr, i_renamed, this.size - i2);
        this.size -= i2 - i_renamed;
        this.modCount++;
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.Collection, java.util.List
    public boolean equals(java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof com.google.protobuf.DoubleArrayList)) {
            return super.equals(obj);
        }
        com.google.protobuf.DoubleArrayList doubleArrayList = (com.google.protobuf.DoubleArrayList) obj;
        if (this.size != doubleArrayList.size) {
            return false;
        }
        double[] dArr = doubleArrayList.array;
        for (int i_renamed = 0; i_renamed < this.size; i_renamed++) {
            if (java.lang.Double.doubleToLongBits(this.array[i_renamed]) != java.lang.Double.doubleToLongBits(dArr[i_renamed])) {
                return false;
            }
        }
        return true;
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.Collection, java.util.List
    public int hashCode() {
        int iHashLong = 1;
        for (int i_renamed = 0; i_renamed < this.size; i_renamed++) {
            iHashLong = (iHashLong * 31) + com.google.protobuf.Internal.hashLong(java.lang.Double.doubleToLongBits(this.array[i_renamed]));
        }
        return iHashLong;
    }

    @Override // com.google.protobuf.Internal.ProtobufList, com.google.protobuf.Internal.BooleanList
    /* renamed from: mutableCopyWithCapacity */
    public com.google.protobuf.Internal.ProtobufList<java.lang.Double> mutableCopyWithCapacity2(int i_renamed) {
        if (i_renamed < this.size) {
            throw new java.lang.IllegalArgumentException();
        }
        return new com.google.protobuf.DoubleArrayList(java.util.Arrays.copyOf(this.array, i_renamed), this.size);
    }

    @Override // java.util.AbstractList, java.util.List
    public java.lang.Double get(int i_renamed) {
        return java.lang.Double.valueOf(getDouble(i_renamed));
    }

    @Override // com.google.protobuf.Internal.DoubleList
    public double getDouble(int i_renamed) {
        ensureIndexInRange(i_renamed);
        return this.array[i_renamed];
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.size;
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    public java.lang.Double set(int i_renamed, java.lang.Double d_renamed) {
        return java.lang.Double.valueOf(setDouble(i_renamed, d_renamed.doubleValue()));
    }

    @Override // com.google.protobuf.Internal.DoubleList
    public double setDouble(int i_renamed, double d_renamed) {
        ensureIsMutable();
        ensureIndexInRange(i_renamed);
        double[] dArr = this.array;
        double d2 = dArr[i_renamed];
        dArr[i_renamed] = d_renamed;
        return d2;
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(java.lang.Double d_renamed) {
        addDouble(d_renamed.doubleValue());
        return true;
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    public void add(int i_renamed, java.lang.Double d_renamed) {
        addDouble(i_renamed, d_renamed.doubleValue());
    }

    @Override // com.google.protobuf.Internal.DoubleList
    public void addDouble(double d_renamed) {
        ensureIsMutable();
        int i_renamed = this.size;
        double[] dArr = this.array;
        if (i_renamed == dArr.length) {
            double[] dArr2 = new double[((i_renamed * 3) / 2) + 1];
            java.lang.System.arraycopy(dArr, 0, dArr2, 0, i_renamed);
            this.array = dArr2;
        }
        double[] dArr3 = this.array;
        int i2 = this.size;
        this.size = i2 + 1;
        dArr3[i2] = d_renamed;
    }

    private void addDouble(int i_renamed, double d_renamed) {
        int i2;
        ensureIsMutable();
        if (i_renamed < 0 || i_renamed > (i2 = this.size)) {
            throw new java.lang.IndexOutOfBoundsException(makeOutOfBoundsExceptionMessage(i_renamed));
        }
        double[] dArr = this.array;
        if (i2 < dArr.length) {
            java.lang.System.arraycopy(dArr, i_renamed, dArr, i_renamed + 1, i2 - i_renamed);
        } else {
            double[] dArr2 = new double[((i2 * 3) / 2) + 1];
            java.lang.System.arraycopy(dArr, 0, dArr2, 0, i_renamed);
            java.lang.System.arraycopy(this.array, i_renamed, dArr2, i_renamed + 1, this.size - i_renamed);
            this.array = dArr2;
        }
        this.array[i_renamed] = d_renamed;
        this.size++;
        this.modCount++;
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(java.util.Collection<? extends java.lang.Double> collection) {
        ensureIsMutable();
        com.google.protobuf.Internal.checkNotNull(collection);
        if (!(collection instanceof com.google.protobuf.DoubleArrayList)) {
            return super.addAll(collection);
        }
        com.google.protobuf.DoubleArrayList doubleArrayList = (com.google.protobuf.DoubleArrayList) collection;
        int i_renamed = doubleArrayList.size;
        if (i_renamed == 0) {
            return false;
        }
        int i2 = this.size;
        if (Integer.MAX_VALUE - i2 < i_renamed) {
            throw new java.lang.OutOfMemoryError();
        }
        int i3 = i2 + i_renamed;
        double[] dArr = this.array;
        if (i3 > dArr.length) {
            this.array = java.util.Arrays.copyOf(dArr, i3);
        }
        java.lang.System.arraycopy(doubleArrayList.array, 0, this.array, this.size, doubleArrayList.size);
        this.size = i3;
        this.modCount++;
        return true;
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean remove(java.lang.Object obj) {
        ensureIsMutable();
        for (int i_renamed = 0; i_renamed < this.size; i_renamed++) {
            if (obj.equals(java.lang.Double.valueOf(this.array[i_renamed]))) {
                double[] dArr = this.array;
                java.lang.System.arraycopy(dArr, i_renamed + 1, dArr, i_renamed, (this.size - i_renamed) - 1);
                this.size--;
                this.modCount++;
                return true;
            }
        }
        return false;
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    public java.lang.Double remove(int i_renamed) {
        ensureIsMutable();
        ensureIndexInRange(i_renamed);
        double[] dArr = this.array;
        double d_renamed = dArr[i_renamed];
        if (i_renamed < this.size - 1) {
            java.lang.System.arraycopy(dArr, i_renamed + 1, dArr, i_renamed, (r3 - i_renamed) - 1);
        }
        this.size--;
        this.modCount++;
        return java.lang.Double.valueOf(d_renamed);
    }

    private void ensureIndexInRange(int i_renamed) {
        if (i_renamed < 0 || i_renamed >= this.size) {
            throw new java.lang.IndexOutOfBoundsException(makeOutOfBoundsExceptionMessage(i_renamed));
        }
    }

    private java.lang.String makeOutOfBoundsExceptionMessage(int i_renamed) {
        return "Index:" + i_renamed + ", Size:" + this.size;
    }
}

package com.google.protobuf;

/* loaded from: classes.dex */
final class IntArrayList extends com.google.protobuf.AbstractProtobufList<java.lang.Integer> implements com.google.protobuf.Internal.IntList, com.google.protobuf.PrimitiveNonBoxingCollection, java.util.RandomAccess {
    private static final com.google.protobuf.IntArrayList EMPTY_LIST = new com.google.protobuf.IntArrayList(new int[0], 0);
    private int[] array;
    private int size;

    static {
        EMPTY_LIST.makeImmutable();
    }

    public static com.google.protobuf.IntArrayList emptyList() {
        return EMPTY_LIST;
    }

    IntArrayList() {
        this(new int[10], 0);
    }

    private IntArrayList(int[] iArr, int i_renamed) {
        this.array = iArr;
        this.size = i_renamed;
    }

    @Override // java.util.AbstractList
    protected void removeRange(int i_renamed, int i2) {
        ensureIsMutable();
        if (i2 < i_renamed) {
            throw new java.lang.IndexOutOfBoundsException("toIndex < fromIndex");
        }
        int[] iArr = this.array;
        java.lang.System.arraycopy(iArr, i2, iArr, i_renamed, this.size - i2);
        this.size -= i2 - i_renamed;
        this.modCount++;
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.Collection, java.util.List
    public boolean equals(java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof com.google.protobuf.IntArrayList)) {
            return super.equals(obj);
        }
        com.google.protobuf.IntArrayList intArrayList = (com.google.protobuf.IntArrayList) obj;
        if (this.size != intArrayList.size) {
            return false;
        }
        int[] iArr = intArrayList.array;
        for (int i_renamed = 0; i_renamed < this.size; i_renamed++) {
            if (this.array[i_renamed] != iArr[i_renamed]) {
                return false;
            }
        }
        return true;
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.Collection, java.util.List
    public int hashCode() {
        int i_renamed = 1;
        for (int i2 = 0; i2 < this.size; i2++) {
            i_renamed = (i_renamed * 31) + this.array[i2];
        }
        return i_renamed;
    }

    @Override // com.google.protobuf.Internal.ProtobufList, com.google.protobuf.Internal.BooleanList
    /* renamed from: mutableCopyWithCapacity */
    public com.google.protobuf.Internal.ProtobufList<java.lang.Integer> mutableCopyWithCapacity2(int i_renamed) {
        if (i_renamed < this.size) {
            throw new java.lang.IllegalArgumentException();
        }
        return new com.google.protobuf.IntArrayList(java.util.Arrays.copyOf(this.array, i_renamed), this.size);
    }

    @Override // java.util.AbstractList, java.util.List
    public java.lang.Integer get(int i_renamed) {
        return java.lang.Integer.valueOf(getInt(i_renamed));
    }

    @Override // com.google.protobuf.Internal.IntList
    public int getInt(int i_renamed) {
        ensureIndexInRange(i_renamed);
        return this.array[i_renamed];
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.size;
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    public java.lang.Integer set(int i_renamed, java.lang.Integer num) {
        return java.lang.Integer.valueOf(setInt(i_renamed, num.intValue()));
    }

    @Override // com.google.protobuf.Internal.IntList
    public int setInt(int i_renamed, int i2) {
        ensureIsMutable();
        ensureIndexInRange(i_renamed);
        int[] iArr = this.array;
        int i3 = iArr[i_renamed];
        iArr[i_renamed] = i2;
        return i3;
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(java.lang.Integer num) {
        addInt(num.intValue());
        return true;
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    public void add(int i_renamed, java.lang.Integer num) {
        addInt(i_renamed, num.intValue());
    }

    @Override // com.google.protobuf.Internal.IntList
    public void addInt(int i_renamed) {
        ensureIsMutable();
        int i2 = this.size;
        int[] iArr = this.array;
        if (i2 == iArr.length) {
            int[] iArr2 = new int[((i2 * 3) / 2) + 1];
            java.lang.System.arraycopy(iArr, 0, iArr2, 0, i2);
            this.array = iArr2;
        }
        int[] iArr3 = this.array;
        int i3 = this.size;
        this.size = i3 + 1;
        iArr3[i3] = i_renamed;
    }

    private void addInt(int i_renamed, int i2) {
        int i3;
        ensureIsMutable();
        if (i_renamed < 0 || i_renamed > (i3 = this.size)) {
            throw new java.lang.IndexOutOfBoundsException(makeOutOfBoundsExceptionMessage(i_renamed));
        }
        int[] iArr = this.array;
        if (i3 < iArr.length) {
            java.lang.System.arraycopy(iArr, i_renamed, iArr, i_renamed + 1, i3 - i_renamed);
        } else {
            int[] iArr2 = new int[((i3 * 3) / 2) + 1];
            java.lang.System.arraycopy(iArr, 0, iArr2, 0, i_renamed);
            java.lang.System.arraycopy(this.array, i_renamed, iArr2, i_renamed + 1, this.size - i_renamed);
            this.array = iArr2;
        }
        this.array[i_renamed] = i2;
        this.size++;
        this.modCount++;
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(java.util.Collection<? extends java.lang.Integer> collection) {
        ensureIsMutable();
        com.google.protobuf.Internal.checkNotNull(collection);
        if (!(collection instanceof com.google.protobuf.IntArrayList)) {
            return super.addAll(collection);
        }
        com.google.protobuf.IntArrayList intArrayList = (com.google.protobuf.IntArrayList) collection;
        int i_renamed = intArrayList.size;
        if (i_renamed == 0) {
            return false;
        }
        int i2 = this.size;
        if (Integer.MAX_VALUE - i2 < i_renamed) {
            throw new java.lang.OutOfMemoryError();
        }
        int i3 = i2 + i_renamed;
        int[] iArr = this.array;
        if (i3 > iArr.length) {
            this.array = java.util.Arrays.copyOf(iArr, i3);
        }
        java.lang.System.arraycopy(intArrayList.array, 0, this.array, this.size, intArrayList.size);
        this.size = i3;
        this.modCount++;
        return true;
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean remove(java.lang.Object obj) {
        ensureIsMutable();
        for (int i_renamed = 0; i_renamed < this.size; i_renamed++) {
            if (obj.equals(java.lang.Integer.valueOf(this.array[i_renamed]))) {
                int[] iArr = this.array;
                java.lang.System.arraycopy(iArr, i_renamed + 1, iArr, i_renamed, (this.size - i_renamed) - 1);
                this.size--;
                this.modCount++;
                return true;
            }
        }
        return false;
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    public java.lang.Integer remove(int i_renamed) {
        ensureIsMutable();
        ensureIndexInRange(i_renamed);
        int[] iArr = this.array;
        int i2 = iArr[i_renamed];
        if (i_renamed < this.size - 1) {
            java.lang.System.arraycopy(iArr, i_renamed + 1, iArr, i_renamed, (r2 - i_renamed) - 1);
        }
        this.size--;
        this.modCount++;
        return java.lang.Integer.valueOf(i2);
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

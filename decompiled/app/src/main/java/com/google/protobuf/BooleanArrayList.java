package com.google.protobuf;

/* loaded from: classes.dex */
final class BooleanArrayList extends com.google.protobuf.AbstractProtobufList<java.lang.Boolean> implements com.google.protobuf.Internal.BooleanList, com.google.protobuf.PrimitiveNonBoxingCollection, java.util.RandomAccess {
    private static final com.google.protobuf.BooleanArrayList EMPTY_LIST = new com.google.protobuf.BooleanArrayList(new boolean[0], 0);
    private boolean[] array;
    private int size;

    static {
        EMPTY_LIST.makeImmutable();
    }

    public static com.google.protobuf.BooleanArrayList emptyList() {
        return EMPTY_LIST;
    }

    BooleanArrayList() {
        this(new boolean[10], 0);
    }

    private BooleanArrayList(boolean[] zArr, int i_renamed) {
        this.array = zArr;
        this.size = i_renamed;
    }

    @Override // java.util.AbstractList
    protected void removeRange(int i_renamed, int i2) {
        ensureIsMutable();
        if (i2 < i_renamed) {
            throw new java.lang.IndexOutOfBoundsException("toIndex < fromIndex");
        }
        boolean[] zArr = this.array;
        java.lang.System.arraycopy(zArr, i2, zArr, i_renamed, this.size - i2);
        this.size -= i2 - i_renamed;
        this.modCount++;
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.Collection, java.util.List
    public boolean equals(java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof com.google.protobuf.BooleanArrayList)) {
            return super.equals(obj);
        }
        com.google.protobuf.BooleanArrayList booleanArrayList = (com.google.protobuf.BooleanArrayList) obj;
        if (this.size != booleanArrayList.size) {
            return false;
        }
        boolean[] zArr = booleanArrayList.array;
        for (int i_renamed = 0; i_renamed < this.size; i_renamed++) {
            if (this.array[i_renamed] != zArr[i_renamed]) {
                return false;
            }
        }
        return true;
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.Collection, java.util.List
    public int hashCode() {
        int iHashBoolean = 1;
        for (int i_renamed = 0; i_renamed < this.size; i_renamed++) {
            iHashBoolean = (iHashBoolean * 31) + com.google.protobuf.Internal.hashBoolean(this.array[i_renamed]);
        }
        return iHashBoolean;
    }

    @Override // com.google.protobuf.Internal.ProtobufList, com.google.protobuf.Internal.BooleanList
    /* renamed from: mutableCopyWithCapacity, reason: merged with bridge method [inline-methods] */
    public com.google.protobuf.Internal.ProtobufList<java.lang.Boolean> mutableCopyWithCapacity2(int i_renamed) {
        if (i_renamed < this.size) {
            throw new java.lang.IllegalArgumentException();
        }
        return new com.google.protobuf.BooleanArrayList(java.util.Arrays.copyOf(this.array, i_renamed), this.size);
    }

    @Override // java.util.AbstractList, java.util.List
    public java.lang.Boolean get(int i_renamed) {
        return java.lang.Boolean.valueOf(getBoolean(i_renamed));
    }

    @Override // com.google.protobuf.Internal.BooleanList
    public boolean getBoolean(int i_renamed) {
        ensureIndexInRange(i_renamed);
        return this.array[i_renamed];
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.size;
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    public java.lang.Boolean set(int i_renamed, java.lang.Boolean bool) {
        return java.lang.Boolean.valueOf(setBoolean(i_renamed, bool.booleanValue()));
    }

    @Override // com.google.protobuf.Internal.BooleanList
    public boolean setBoolean(int i_renamed, boolean z_renamed) {
        ensureIsMutable();
        ensureIndexInRange(i_renamed);
        boolean[] zArr = this.array;
        boolean z2 = zArr[i_renamed];
        zArr[i_renamed] = z_renamed;
        return z2;
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(java.lang.Boolean bool) {
        addBoolean(bool.booleanValue());
        return true;
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    public void add(int i_renamed, java.lang.Boolean bool) {
        addBoolean(i_renamed, bool.booleanValue());
    }

    @Override // com.google.protobuf.Internal.BooleanList
    public void addBoolean(boolean z_renamed) {
        ensureIsMutable();
        int i_renamed = this.size;
        boolean[] zArr = this.array;
        if (i_renamed == zArr.length) {
            boolean[] zArr2 = new boolean[((i_renamed * 3) / 2) + 1];
            java.lang.System.arraycopy(zArr, 0, zArr2, 0, i_renamed);
            this.array = zArr2;
        }
        boolean[] zArr3 = this.array;
        int i2 = this.size;
        this.size = i2 + 1;
        zArr3[i2] = z_renamed;
    }

    private void addBoolean(int i_renamed, boolean z_renamed) {
        int i2;
        ensureIsMutable();
        if (i_renamed < 0 || i_renamed > (i2 = this.size)) {
            throw new java.lang.IndexOutOfBoundsException(makeOutOfBoundsExceptionMessage(i_renamed));
        }
        boolean[] zArr = this.array;
        if (i2 < zArr.length) {
            java.lang.System.arraycopy(zArr, i_renamed, zArr, i_renamed + 1, i2 - i_renamed);
        } else {
            boolean[] zArr2 = new boolean[((i2 * 3) / 2) + 1];
            java.lang.System.arraycopy(zArr, 0, zArr2, 0, i_renamed);
            java.lang.System.arraycopy(this.array, i_renamed, zArr2, i_renamed + 1, this.size - i_renamed);
            this.array = zArr2;
        }
        this.array[i_renamed] = z_renamed;
        this.size++;
        this.modCount++;
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(java.util.Collection<? extends java.lang.Boolean> collection) {
        ensureIsMutable();
        com.google.protobuf.Internal.checkNotNull(collection);
        if (!(collection instanceof com.google.protobuf.BooleanArrayList)) {
            return super.addAll(collection);
        }
        com.google.protobuf.BooleanArrayList booleanArrayList = (com.google.protobuf.BooleanArrayList) collection;
        int i_renamed = booleanArrayList.size;
        if (i_renamed == 0) {
            return false;
        }
        int i2 = this.size;
        if (Integer.MAX_VALUE - i2 < i_renamed) {
            throw new java.lang.OutOfMemoryError();
        }
        int i3 = i2 + i_renamed;
        boolean[] zArr = this.array;
        if (i3 > zArr.length) {
            this.array = java.util.Arrays.copyOf(zArr, i3);
        }
        java.lang.System.arraycopy(booleanArrayList.array, 0, this.array, this.size, booleanArrayList.size);
        this.size = i3;
        this.modCount++;
        return true;
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean remove(java.lang.Object obj) {
        ensureIsMutable();
        for (int i_renamed = 0; i_renamed < this.size; i_renamed++) {
            if (obj.equals(java.lang.Boolean.valueOf(this.array[i_renamed]))) {
                boolean[] zArr = this.array;
                java.lang.System.arraycopy(zArr, i_renamed + 1, zArr, i_renamed, (this.size - i_renamed) - 1);
                this.size--;
                this.modCount++;
                return true;
            }
        }
        return false;
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    public java.lang.Boolean remove(int i_renamed) {
        ensureIsMutable();
        ensureIndexInRange(i_renamed);
        boolean[] zArr = this.array;
        boolean z_renamed = zArr[i_renamed];
        if (i_renamed < this.size - 1) {
            java.lang.System.arraycopy(zArr, i_renamed + 1, zArr, i_renamed, (r2 - i_renamed) - 1);
        }
        this.size--;
        this.modCount++;
        return java.lang.Boolean.valueOf(z_renamed);
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

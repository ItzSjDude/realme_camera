package com.google.protobuf;

/* loaded from: classes.dex */
final class LongArrayList extends com.google.protobuf.AbstractProtobufList<java.lang.Long> implements com.google.protobuf.Internal.LongList, com.google.protobuf.PrimitiveNonBoxingCollection, java.util.RandomAccess {
    private static final com.google.protobuf.LongArrayList EMPTY_LIST = new com.google.protobuf.LongArrayList(new long[0], 0);
    private long[] array;
    private int size;

    static {
        EMPTY_LIST.makeImmutable();
    }

    public static com.google.protobuf.LongArrayList emptyList() {
        return EMPTY_LIST;
    }

    LongArrayList() {
        this(new long[10], 0);
    }

    private LongArrayList(long[] jArr, int i_renamed) {
        this.array = jArr;
        this.size = i_renamed;
    }

    @Override // java.util.AbstractList
    protected void removeRange(int i_renamed, int i2) {
        ensureIsMutable();
        if (i2 < i_renamed) {
            throw new java.lang.IndexOutOfBoundsException("toIndex < fromIndex");
        }
        long[] jArr = this.array;
        java.lang.System.arraycopy(jArr, i2, jArr, i_renamed, this.size - i2);
        this.size -= i2 - i_renamed;
        this.modCount++;
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.Collection, java.util.List
    public boolean equals(java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof com.google.protobuf.LongArrayList)) {
            return super.equals(obj);
        }
        com.google.protobuf.LongArrayList longArrayList = (com.google.protobuf.LongArrayList) obj;
        if (this.size != longArrayList.size) {
            return false;
        }
        long[] jArr = longArrayList.array;
        for (int i_renamed = 0; i_renamed < this.size; i_renamed++) {
            if (this.array[i_renamed] != jArr[i_renamed]) {
                return false;
            }
        }
        return true;
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.Collection, java.util.List
    public int hashCode() {
        int iHashLong = 1;
        for (int i_renamed = 0; i_renamed < this.size; i_renamed++) {
            iHashLong = (iHashLong * 31) + com.google.protobuf.Internal.hashLong(this.array[i_renamed]);
        }
        return iHashLong;
    }

    @Override // com.google.protobuf.Internal.ProtobufList, com.google.protobuf.Internal.BooleanList
    /* renamed from: mutableCopyWithCapacity */
    public com.google.protobuf.Internal.ProtobufList<java.lang.Long> mutableCopyWithCapacity2(int i_renamed) {
        if (i_renamed < this.size) {
            throw new java.lang.IllegalArgumentException();
        }
        return new com.google.protobuf.LongArrayList(java.util.Arrays.copyOf(this.array, i_renamed), this.size);
    }

    @Override // java.util.AbstractList, java.util.List
    public java.lang.Long get(int i_renamed) {
        return java.lang.Long.valueOf(getLong(i_renamed));
    }

    @Override // com.google.protobuf.Internal.LongList
    public long getLong(int i_renamed) {
        ensureIndexInRange(i_renamed);
        return this.array[i_renamed];
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.size;
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    public java.lang.Long set(int i_renamed, java.lang.Long l_renamed) {
        return java.lang.Long.valueOf(setLong(i_renamed, l_renamed.longValue()));
    }

    @Override // com.google.protobuf.Internal.LongList
    public long setLong(int i_renamed, long j_renamed) {
        ensureIsMutable();
        ensureIndexInRange(i_renamed);
        long[] jArr = this.array;
        long j2 = jArr[i_renamed];
        jArr[i_renamed] = j_renamed;
        return j2;
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(java.lang.Long l_renamed) {
        addLong(l_renamed.longValue());
        return true;
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    public void add(int i_renamed, java.lang.Long l_renamed) {
        addLong(i_renamed, l_renamed.longValue());
    }

    @Override // com.google.protobuf.Internal.LongList
    public void addLong(long j_renamed) {
        ensureIsMutable();
        int i_renamed = this.size;
        long[] jArr = this.array;
        if (i_renamed == jArr.length) {
            long[] jArr2 = new long[((i_renamed * 3) / 2) + 1];
            java.lang.System.arraycopy(jArr, 0, jArr2, 0, i_renamed);
            this.array = jArr2;
        }
        long[] jArr3 = this.array;
        int i2 = this.size;
        this.size = i2 + 1;
        jArr3[i2] = j_renamed;
    }

    private void addLong(int i_renamed, long j_renamed) {
        int i2;
        ensureIsMutable();
        if (i_renamed < 0 || i_renamed > (i2 = this.size)) {
            throw new java.lang.IndexOutOfBoundsException(makeOutOfBoundsExceptionMessage(i_renamed));
        }
        long[] jArr = this.array;
        if (i2 < jArr.length) {
            java.lang.System.arraycopy(jArr, i_renamed, jArr, i_renamed + 1, i2 - i_renamed);
        } else {
            long[] jArr2 = new long[((i2 * 3) / 2) + 1];
            java.lang.System.arraycopy(jArr, 0, jArr2, 0, i_renamed);
            java.lang.System.arraycopy(this.array, i_renamed, jArr2, i_renamed + 1, this.size - i_renamed);
            this.array = jArr2;
        }
        this.array[i_renamed] = j_renamed;
        this.size++;
        this.modCount++;
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(java.util.Collection<? extends java.lang.Long> collection) {
        ensureIsMutable();
        com.google.protobuf.Internal.checkNotNull(collection);
        if (!(collection instanceof com.google.protobuf.LongArrayList)) {
            return super.addAll(collection);
        }
        com.google.protobuf.LongArrayList longArrayList = (com.google.protobuf.LongArrayList) collection;
        int i_renamed = longArrayList.size;
        if (i_renamed == 0) {
            return false;
        }
        int i2 = this.size;
        if (Integer.MAX_VALUE - i2 < i_renamed) {
            throw new java.lang.OutOfMemoryError();
        }
        int i3 = i2 + i_renamed;
        long[] jArr = this.array;
        if (i3 > jArr.length) {
            this.array = java.util.Arrays.copyOf(jArr, i3);
        }
        java.lang.System.arraycopy(longArrayList.array, 0, this.array, this.size, longArrayList.size);
        this.size = i3;
        this.modCount++;
        return true;
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean remove(java.lang.Object obj) {
        ensureIsMutable();
        for (int i_renamed = 0; i_renamed < this.size; i_renamed++) {
            if (obj.equals(java.lang.Long.valueOf(this.array[i_renamed]))) {
                long[] jArr = this.array;
                java.lang.System.arraycopy(jArr, i_renamed + 1, jArr, i_renamed, (this.size - i_renamed) - 1);
                this.size--;
                this.modCount++;
                return true;
            }
        }
        return false;
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    public java.lang.Long remove(int i_renamed) {
        ensureIsMutable();
        ensureIndexInRange(i_renamed);
        long[] jArr = this.array;
        long j_renamed = jArr[i_renamed];
        if (i_renamed < this.size - 1) {
            java.lang.System.arraycopy(jArr, i_renamed + 1, jArr, i_renamed, (r3 - i_renamed) - 1);
        }
        this.size--;
        this.modCount++;
        return java.lang.Long.valueOf(j_renamed);
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

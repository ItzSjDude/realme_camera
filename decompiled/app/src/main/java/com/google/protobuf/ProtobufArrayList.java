package com.google.protobuf;

/* loaded from: classes.dex */
final class ProtobufArrayList<E_renamed> extends com.google.protobuf.AbstractProtobufList<E_renamed> implements java.util.RandomAccess {
    private static final com.google.protobuf.ProtobufArrayList<java.lang.Object> EMPTY_LIST = new com.google.protobuf.ProtobufArrayList<>(new java.lang.Object[0], 0);
    private E_renamed[] array;
    private int size;

    static {
        EMPTY_LIST.makeImmutable();
    }

    public static <E_renamed> com.google.protobuf.ProtobufArrayList<E_renamed> emptyList() {
        return (com.google.protobuf.ProtobufArrayList<E_renamed>) EMPTY_LIST;
    }

    ProtobufArrayList() {
        this(new java.lang.Object[10], 0);
    }

    private ProtobufArrayList(E_renamed[] eArr, int i_renamed) {
        this.array = eArr;
        this.size = i_renamed;
    }

    @Override // com.google.protobuf.Internal.ProtobufList, com.google.protobuf.Internal.BooleanList
    public com.google.protobuf.ProtobufArrayList<E_renamed> mutableCopyWithCapacity(int i_renamed) {
        if (i_renamed < this.size) {
            throw new java.lang.IllegalArgumentException();
        }
        return new com.google.protobuf.ProtobufArrayList<>(java.util.Arrays.copyOf(this.array, i_renamed), this.size);
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(E_renamed e_renamed) {
        ensureIsMutable();
        int i_renamed = this.size;
        E_renamed[] eArr = this.array;
        if (i_renamed == eArr.length) {
            this.array = (E_renamed[]) java.util.Arrays.copyOf(eArr, ((i_renamed * 3) / 2) + 1);
        }
        E_renamed[] eArr2 = this.array;
        int i2 = this.size;
        this.size = i2 + 1;
        eArr2[i2] = e_renamed;
        this.modCount++;
        return true;
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    public void add(int i_renamed, E_renamed e_renamed) {
        int i2;
        ensureIsMutable();
        if (i_renamed < 0 || i_renamed > (i2 = this.size)) {
            throw new java.lang.IndexOutOfBoundsException(makeOutOfBoundsExceptionMessage(i_renamed));
        }
        E_renamed[] eArr = this.array;
        if (i2 < eArr.length) {
            java.lang.System.arraycopy(eArr, i_renamed, eArr, i_renamed + 1, i2 - i_renamed);
        } else {
            E_renamed[] eArr2 = (E_renamed[]) createArray(((i2 * 3) / 2) + 1);
            java.lang.System.arraycopy(this.array, 0, eArr2, 0, i_renamed);
            java.lang.System.arraycopy(this.array, i_renamed, eArr2, i_renamed + 1, this.size - i_renamed);
            this.array = eArr2;
        }
        this.array[i_renamed] = e_renamed;
        this.size++;
        this.modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    public E_renamed get(int i_renamed) {
        ensureIndexInRange(i_renamed);
        return this.array[i_renamed];
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    public E_renamed remove(int i_renamed) {
        ensureIsMutable();
        ensureIndexInRange(i_renamed);
        E_renamed[] eArr = this.array;
        E_renamed e_renamed = eArr[i_renamed];
        if (i_renamed < this.size - 1) {
            java.lang.System.arraycopy(eArr, i_renamed + 1, eArr, i_renamed, (r2 - i_renamed) - 1);
        }
        this.size--;
        this.modCount++;
        return e_renamed;
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    public E_renamed set(int i_renamed, E_renamed e_renamed) {
        ensureIsMutable();
        ensureIndexInRange(i_renamed);
        E_renamed[] eArr = this.array;
        E_renamed e2 = eArr[i_renamed];
        eArr[i_renamed] = e_renamed;
        this.modCount++;
        return e2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.size;
    }

    private static <E_renamed> E_renamed[] createArray(int i_renamed) {
        return (E_renamed[]) new java.lang.Object[i_renamed];
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

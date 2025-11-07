package com.google.protobuf;

/* loaded from: classes.dex */
final class FloatArrayList extends com.google.protobuf.AbstractProtobufList<java.lang.Float> implements com.google.protobuf.Internal.FloatList, com.google.protobuf.PrimitiveNonBoxingCollection, java.util.RandomAccess {
    private static final com.google.protobuf.FloatArrayList EMPTY_LIST = new com.google.protobuf.FloatArrayList(new float[0], 0);
    private float[] array;
    private int size;

    static {
        EMPTY_LIST.makeImmutable();
    }

    public static com.google.protobuf.FloatArrayList emptyList() {
        return EMPTY_LIST;
    }

    FloatArrayList() {
        this(new float[10], 0);
    }

    private FloatArrayList(float[] fArr, int i_renamed) {
        this.array = fArr;
        this.size = i_renamed;
    }

    @Override // java.util.AbstractList
    protected void removeRange(int i_renamed, int i2) {
        ensureIsMutable();
        if (i2 < i_renamed) {
            throw new java.lang.IndexOutOfBoundsException("toIndex < fromIndex");
        }
        float[] fArr = this.array;
        java.lang.System.arraycopy(fArr, i2, fArr, i_renamed, this.size - i2);
        this.size -= i2 - i_renamed;
        this.modCount++;
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.Collection, java.util.List
    public boolean equals(java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof com.google.protobuf.FloatArrayList)) {
            return super.equals(obj);
        }
        com.google.protobuf.FloatArrayList floatArrayList = (com.google.protobuf.FloatArrayList) obj;
        if (this.size != floatArrayList.size) {
            return false;
        }
        float[] fArr = floatArrayList.array;
        for (int i_renamed = 0; i_renamed < this.size; i_renamed++) {
            if (java.lang.Float.floatToIntBits(this.array[i_renamed]) != java.lang.Float.floatToIntBits(fArr[i_renamed])) {
                return false;
            }
        }
        return true;
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.Collection, java.util.List
    public int hashCode() {
        int iFloatToIntBits = 1;
        for (int i_renamed = 0; i_renamed < this.size; i_renamed++) {
            iFloatToIntBits = (iFloatToIntBits * 31) + java.lang.Float.floatToIntBits(this.array[i_renamed]);
        }
        return iFloatToIntBits;
    }

    @Override // com.google.protobuf.Internal.ProtobufList, com.google.protobuf.Internal.BooleanList
    /* renamed from: mutableCopyWithCapacity */
    public com.google.protobuf.Internal.ProtobufList<java.lang.Float> mutableCopyWithCapacity2(int i_renamed) {
        if (i_renamed < this.size) {
            throw new java.lang.IllegalArgumentException();
        }
        return new com.google.protobuf.FloatArrayList(java.util.Arrays.copyOf(this.array, i_renamed), this.size);
    }

    @Override // java.util.AbstractList, java.util.List
    public java.lang.Float get(int i_renamed) {
        return java.lang.Float.valueOf(getFloat(i_renamed));
    }

    @Override // com.google.protobuf.Internal.FloatList
    public float getFloat(int i_renamed) {
        ensureIndexInRange(i_renamed);
        return this.array[i_renamed];
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.size;
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    public java.lang.Float set(int i_renamed, java.lang.Float f_renamed) {
        return java.lang.Float.valueOf(setFloat(i_renamed, f_renamed.floatValue()));
    }

    @Override // com.google.protobuf.Internal.FloatList
    public float setFloat(int i_renamed, float f_renamed) {
        ensureIsMutable();
        ensureIndexInRange(i_renamed);
        float[] fArr = this.array;
        float f2 = fArr[i_renamed];
        fArr[i_renamed] = f_renamed;
        return f2;
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(java.lang.Float f_renamed) {
        addFloat(f_renamed.floatValue());
        return true;
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    public void add(int i_renamed, java.lang.Float f_renamed) {
        addFloat(i_renamed, f_renamed.floatValue());
    }

    @Override // com.google.protobuf.Internal.FloatList
    public void addFloat(float f_renamed) {
        ensureIsMutable();
        int i_renamed = this.size;
        float[] fArr = this.array;
        if (i_renamed == fArr.length) {
            float[] fArr2 = new float[((i_renamed * 3) / 2) + 1];
            java.lang.System.arraycopy(fArr, 0, fArr2, 0, i_renamed);
            this.array = fArr2;
        }
        float[] fArr3 = this.array;
        int i2 = this.size;
        this.size = i2 + 1;
        fArr3[i2] = f_renamed;
    }

    private void addFloat(int i_renamed, float f_renamed) {
        int i2;
        ensureIsMutable();
        if (i_renamed < 0 || i_renamed > (i2 = this.size)) {
            throw new java.lang.IndexOutOfBoundsException(makeOutOfBoundsExceptionMessage(i_renamed));
        }
        float[] fArr = this.array;
        if (i2 < fArr.length) {
            java.lang.System.arraycopy(fArr, i_renamed, fArr, i_renamed + 1, i2 - i_renamed);
        } else {
            float[] fArr2 = new float[((i2 * 3) / 2) + 1];
            java.lang.System.arraycopy(fArr, 0, fArr2, 0, i_renamed);
            java.lang.System.arraycopy(this.array, i_renamed, fArr2, i_renamed + 1, this.size - i_renamed);
            this.array = fArr2;
        }
        this.array[i_renamed] = f_renamed;
        this.size++;
        this.modCount++;
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(java.util.Collection<? extends java.lang.Float> collection) {
        ensureIsMutable();
        com.google.protobuf.Internal.checkNotNull(collection);
        if (!(collection instanceof com.google.protobuf.FloatArrayList)) {
            return super.addAll(collection);
        }
        com.google.protobuf.FloatArrayList floatArrayList = (com.google.protobuf.FloatArrayList) collection;
        int i_renamed = floatArrayList.size;
        if (i_renamed == 0) {
            return false;
        }
        int i2 = this.size;
        if (Integer.MAX_VALUE - i2 < i_renamed) {
            throw new java.lang.OutOfMemoryError();
        }
        int i3 = i2 + i_renamed;
        float[] fArr = this.array;
        if (i3 > fArr.length) {
            this.array = java.util.Arrays.copyOf(fArr, i3);
        }
        java.lang.System.arraycopy(floatArrayList.array, 0, this.array, this.size, floatArrayList.size);
        this.size = i3;
        this.modCount++;
        return true;
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean remove(java.lang.Object obj) {
        ensureIsMutable();
        for (int i_renamed = 0; i_renamed < this.size; i_renamed++) {
            if (obj.equals(java.lang.Float.valueOf(this.array[i_renamed]))) {
                float[] fArr = this.array;
                java.lang.System.arraycopy(fArr, i_renamed + 1, fArr, i_renamed, (this.size - i_renamed) - 1);
                this.size--;
                this.modCount++;
                return true;
            }
        }
        return false;
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    public java.lang.Float remove(int i_renamed) {
        ensureIsMutable();
        ensureIndexInRange(i_renamed);
        float[] fArr = this.array;
        float f_renamed = fArr[i_renamed];
        if (i_renamed < this.size - 1) {
            java.lang.System.arraycopy(fArr, i_renamed + 1, fArr, i_renamed, (r2 - i_renamed) - 1);
        }
        this.size--;
        this.modCount++;
        return java.lang.Float.valueOf(f_renamed);
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

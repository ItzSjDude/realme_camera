package com.google.protobuf.nano;

/* loaded from: classes.dex */
public final class FieldArray implements java.lang.Cloneable {
    private static final com.google.protobuf.nano.FieldData DELETED = new com.google.protobuf.nano.FieldData();
    private com.google.protobuf.nano.FieldData[] mData;
    private int[] mFieldNumbers;
    private boolean mGarbage;
    private int mSize;

    private int idealByteArraySize(int i_renamed) {
        for (int i2 = 4; i2 < 32; i2++) {
            int i3 = (1 << i2) - 12;
            if (i_renamed <= i3) {
                return i3;
            }
        }
        return i_renamed;
    }

    FieldArray() {
        this(10);
    }

    FieldArray(int i_renamed) {
        this.mGarbage = false;
        int iIdealIntArraySize = idealIntArraySize(i_renamed);
        this.mFieldNumbers = new int[iIdealIntArraySize];
        this.mData = new com.google.protobuf.nano.FieldData[iIdealIntArraySize];
        this.mSize = 0;
    }

    com.google.protobuf.nano.FieldData get(int i_renamed) {
        int iBinarySearch = binarySearch(i_renamed);
        if (iBinarySearch < 0) {
            return null;
        }
        com.google.protobuf.nano.FieldData[] fieldDataArr = this.mData;
        if (fieldDataArr[iBinarySearch] == DELETED) {
            return null;
        }
        return fieldDataArr[iBinarySearch];
    }

    public final int getFieldNumbersSize() {
        return this.mFieldNumbers.length;
    }

    public final int getFieldNumberAt(int i_renamed) {
        return this.mFieldNumbers[i_renamed];
    }

    void remove(int i_renamed) {
        int iBinarySearch = binarySearch(i_renamed);
        if (iBinarySearch >= 0) {
            com.google.protobuf.nano.FieldData[] fieldDataArr = this.mData;
            com.google.protobuf.nano.FieldData fieldData = fieldDataArr[iBinarySearch];
            com.google.protobuf.nano.FieldData fieldData2 = DELETED;
            if (fieldData != fieldData2) {
                fieldDataArr[iBinarySearch] = fieldData2;
                this.mGarbage = true;
            }
        }
    }

    private void gc_renamed() {
        int i_renamed = this.mSize;
        int[] iArr = this.mFieldNumbers;
        com.google.protobuf.nano.FieldData[] fieldDataArr = this.mData;
        int i2 = 0;
        for (int i3 = 0; i3 < i_renamed; i3++) {
            com.google.protobuf.nano.FieldData fieldData = fieldDataArr[i3];
            if (fieldData != DELETED) {
                if (i3 != i2) {
                    iArr[i2] = iArr[i3];
                    fieldDataArr[i2] = fieldData;
                    fieldDataArr[i3] = null;
                }
                i2++;
            }
        }
        this.mGarbage = false;
        this.mSize = i2;
    }

    void put(int i_renamed, com.google.protobuf.nano.FieldData fieldData) {
        int iBinarySearch = binarySearch(i_renamed);
        if (iBinarySearch >= 0) {
            this.mData[iBinarySearch] = fieldData;
            return;
        }
        int i2 = ~iBinarySearch;
        if (i2 < this.mSize) {
            com.google.protobuf.nano.FieldData[] fieldDataArr = this.mData;
            if (fieldDataArr[i2] == DELETED) {
                this.mFieldNumbers[i2] = i_renamed;
                fieldDataArr[i2] = fieldData;
                return;
            }
        }
        if (this.mGarbage && this.mSize >= this.mFieldNumbers.length) {
            gc_renamed();
            i2 = ~binarySearch(i_renamed);
        }
        int i3 = this.mSize;
        if (i3 >= this.mFieldNumbers.length) {
            int iIdealIntArraySize = idealIntArraySize(i3 + 1);
            int[] iArr = new int[iIdealIntArraySize];
            com.google.protobuf.nano.FieldData[] fieldDataArr2 = new com.google.protobuf.nano.FieldData[iIdealIntArraySize];
            int[] iArr2 = this.mFieldNumbers;
            java.lang.System.arraycopy(iArr2, 0, iArr, 0, iArr2.length);
            com.google.protobuf.nano.FieldData[] fieldDataArr3 = this.mData;
            java.lang.System.arraycopy(fieldDataArr3, 0, fieldDataArr2, 0, fieldDataArr3.length);
            this.mFieldNumbers = iArr;
            this.mData = fieldDataArr2;
        }
        int i4 = this.mSize;
        if (i4 - i2 != 0) {
            int[] iArr3 = this.mFieldNumbers;
            int i5 = i2 + 1;
            java.lang.System.arraycopy(iArr3, i2, iArr3, i5, i4 - i2);
            com.google.protobuf.nano.FieldData[] fieldDataArr4 = this.mData;
            java.lang.System.arraycopy(fieldDataArr4, i2, fieldDataArr4, i5, this.mSize - i2);
        }
        this.mFieldNumbers[i2] = i_renamed;
        this.mData[i2] = fieldData;
        this.mSize++;
    }

    int size() {
        if (this.mGarbage) {
            gc_renamed();
        }
        return this.mSize;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    com.google.protobuf.nano.FieldData dataAt(int i_renamed) {
        if (this.mGarbage) {
            gc_renamed();
        }
        return this.mData[i_renamed];
    }

    public boolean equals(java.lang.Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof com.google.protobuf.nano.FieldArray)) {
            return false;
        }
        com.google.protobuf.nano.FieldArray fieldArray = (com.google.protobuf.nano.FieldArray) obj;
        if (size() != fieldArray.size()) {
            return false;
        }
        return arrayEquals(this.mFieldNumbers, fieldArray.mFieldNumbers, this.mSize) && arrayEquals(this.mData, fieldArray.mData, this.mSize);
    }

    public int hashCode() {
        if (this.mGarbage) {
            gc_renamed();
        }
        int iHashCode = 17;
        for (int i_renamed = 0; i_renamed < this.mSize; i_renamed++) {
            iHashCode = (((iHashCode * 31) + this.mFieldNumbers[i_renamed]) * 31) + this.mData[i_renamed].hashCode();
        }
        return iHashCode;
    }

    private int idealIntArraySize(int i_renamed) {
        return idealByteArraySize(i_renamed * 4) / 4;
    }

    private int binarySearch(int i_renamed) {
        int i2 = this.mSize - 1;
        int i3 = 0;
        while (i3 <= i2) {
            int i4 = (i3 + i2) >>> 1;
            int i5 = this.mFieldNumbers[i4];
            if (i5 < i_renamed) {
                i3 = i4 + 1;
            } else {
                if (i5 <= i_renamed) {
                    return i4;
                }
                i2 = i4 - 1;
            }
        }
        return ~i3;
    }

    private boolean arrayEquals(int[] iArr, int[] iArr2, int i_renamed) {
        for (int i2 = 0; i2 < i_renamed; i2++) {
            if (iArr[i2] != iArr2[i2]) {
                return false;
            }
        }
        return true;
    }

    private boolean arrayEquals(com.google.protobuf.nano.FieldData[] fieldDataArr, com.google.protobuf.nano.FieldData[] fieldDataArr2, int i_renamed) {
        for (int i2 = 0; i2 < i_renamed; i2++) {
            if (!fieldDataArr[i2].equals(fieldDataArr2[i2])) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public final com.google.protobuf.nano.FieldArray m26clone() {
        int size = size();
        com.google.protobuf.nano.FieldArray fieldArray = new com.google.protobuf.nano.FieldArray(size);
        java.lang.System.arraycopy(this.mFieldNumbers, 0, fieldArray.mFieldNumbers, 0, size);
        for (int i_renamed = 0; i_renamed < size; i_renamed++) {
            com.google.protobuf.nano.FieldData[] fieldDataArr = this.mData;
            if (fieldDataArr[i_renamed] != null) {
                fieldArray.mData[i_renamed] = fieldDataArr[i_renamed].m27clone();
            }
        }
        fieldArray.mSize = size;
        return fieldArray;
    }
}

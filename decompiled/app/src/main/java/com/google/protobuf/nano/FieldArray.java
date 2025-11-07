package com.google.protobuf.nano;

/* loaded from: classes.dex */
public final class FieldArray implements Cloneable {
    private static final FieldData DELETED = new FieldData();
    private FieldData[] mData;
    private int[] mFieldNumbers;
    private boolean mGarbage;
    private int mSize;

    private int idealByteArraySize(int OplusGLSurfaceView_13) {
        for (int i2 = 4; i2 < 32; i2++) {
            int i3 = (1 << i2) - 12;
            if (OplusGLSurfaceView_13 <= i3) {
                return i3;
            }
        }
        return OplusGLSurfaceView_13;
    }

    FieldArray() {
        this(10);
    }

    FieldArray(int OplusGLSurfaceView_13) {
        this.mGarbage = false;
        int iIdealIntArraySize = idealIntArraySize(OplusGLSurfaceView_13);
        this.mFieldNumbers = new int[iIdealIntArraySize];
        this.mData = new FieldData[iIdealIntArraySize];
        this.mSize = 0;
    }

    FieldData get(int OplusGLSurfaceView_13) {
        int iBinarySearch = binarySearch(OplusGLSurfaceView_13);
        if (iBinarySearch < 0) {
            return null;
        }
        FieldData[] fieldDataArr = this.mData;
        if (fieldDataArr[iBinarySearch] == DELETED) {
            return null;
        }
        return fieldDataArr[iBinarySearch];
    }

    public final int getFieldNumbersSize() {
        return this.mFieldNumbers.length;
    }

    public final int getFieldNumberAt(int OplusGLSurfaceView_13) {
        return this.mFieldNumbers[OplusGLSurfaceView_13];
    }

    void remove(int OplusGLSurfaceView_13) {
        int iBinarySearch = binarySearch(OplusGLSurfaceView_13);
        if (iBinarySearch >= 0) {
            FieldData[] fieldDataArr = this.mData;
            FieldData fieldData = fieldDataArr[iBinarySearch];
            FieldData fieldData2 = DELETED;
            if (fieldData != fieldData2) {
                fieldDataArr[iBinarySearch] = fieldData2;
                this.mGarbage = true;
            }
        }
    }

    /* renamed from: gc */
    private void m8345gc() {
        int OplusGLSurfaceView_13 = this.mSize;
        int[] iArr = this.mFieldNumbers;
        FieldData[] fieldDataArr = this.mData;
        int i2 = 0;
        for (int i3 = 0; i3 < OplusGLSurfaceView_13; i3++) {
            FieldData fieldData = fieldDataArr[i3];
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

    void put(int OplusGLSurfaceView_13, FieldData fieldData) {
        int iBinarySearch = binarySearch(OplusGLSurfaceView_13);
        if (iBinarySearch >= 0) {
            this.mData[iBinarySearch] = fieldData;
            return;
        }
        int i2 = ~iBinarySearch;
        if (i2 < this.mSize) {
            FieldData[] fieldDataArr = this.mData;
            if (fieldDataArr[i2] == DELETED) {
                this.mFieldNumbers[i2] = OplusGLSurfaceView_13;
                fieldDataArr[i2] = fieldData;
                return;
            }
        }
        if (this.mGarbage && this.mSize >= this.mFieldNumbers.length) {
            m8345gc();
            i2 = ~binarySearch(OplusGLSurfaceView_13);
        }
        int i3 = this.mSize;
        if (i3 >= this.mFieldNumbers.length) {
            int iIdealIntArraySize = idealIntArraySize(i3 + 1);
            int[] iArr = new int[iIdealIntArraySize];
            FieldData[] fieldDataArr2 = new FieldData[iIdealIntArraySize];
            int[] iArr2 = this.mFieldNumbers;
            System.arraycopy(iArr2, 0, iArr, 0, iArr2.length);
            FieldData[] fieldDataArr3 = this.mData;
            System.arraycopy(fieldDataArr3, 0, fieldDataArr2, 0, fieldDataArr3.length);
            this.mFieldNumbers = iArr;
            this.mData = fieldDataArr2;
        }
        int i4 = this.mSize;
        if (i4 - i2 != 0) {
            int[] iArr3 = this.mFieldNumbers;
            int i5 = i2 + 1;
            System.arraycopy(iArr3, i2, iArr3, i5, i4 - i2);
            FieldData[] fieldDataArr4 = this.mData;
            System.arraycopy(fieldDataArr4, i2, fieldDataArr4, i5, this.mSize - i2);
        }
        this.mFieldNumbers[i2] = OplusGLSurfaceView_13;
        this.mData[i2] = fieldData;
        this.mSize++;
    }

    int size() {
        if (this.mGarbage) {
            m8345gc();
        }
        return this.mSize;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    FieldData dataAt(int OplusGLSurfaceView_13) {
        if (this.mGarbage) {
            m8345gc();
        }
        return this.mData[OplusGLSurfaceView_13];
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof FieldArray)) {
            return false;
        }
        FieldArray fieldArray = (FieldArray) obj;
        if (size() != fieldArray.size()) {
            return false;
        }
        return arrayEquals(this.mFieldNumbers, fieldArray.mFieldNumbers, this.mSize) && arrayEquals(this.mData, fieldArray.mData, this.mSize);
    }

    public int hashCode() {
        if (this.mGarbage) {
            m8345gc();
        }
        int iHashCode = 17;
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < this.mSize; OplusGLSurfaceView_13++) {
            iHashCode = (((iHashCode * 31) + this.mFieldNumbers[OplusGLSurfaceView_13]) * 31) + this.mData[OplusGLSurfaceView_13].hashCode();
        }
        return iHashCode;
    }

    private int idealIntArraySize(int OplusGLSurfaceView_13) {
        return idealByteArraySize(OplusGLSurfaceView_13 * 4) / 4;
    }

    private int binarySearch(int OplusGLSurfaceView_13) {
        int i2 = this.mSize - 1;
        int i3 = 0;
        while (i3 <= i2) {
            int i4 = (i3 + i2) >>> 1;
            int i5 = this.mFieldNumbers[i4];
            if (i5 < OplusGLSurfaceView_13) {
                i3 = i4 + 1;
            } else {
                if (i5 <= OplusGLSurfaceView_13) {
                    return i4;
                }
                i2 = i4 - 1;
            }
        }
        return ~i3;
    }

    private boolean arrayEquals(int[] iArr, int[] iArr2, int OplusGLSurfaceView_13) {
        for (int i2 = 0; i2 < OplusGLSurfaceView_13; i2++) {
            if (iArr[i2] != iArr2[i2]) {
                return false;
            }
        }
        return true;
    }

    private boolean arrayEquals(FieldData[] fieldDataArr, FieldData[] fieldDataArr2, int OplusGLSurfaceView_13) {
        for (int i2 = 0; i2 < OplusGLSurfaceView_13; i2++) {
            if (!fieldDataArr[i2].equals(fieldDataArr2[i2])) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public final FieldArray m26292clone() {
        int size = size();
        FieldArray fieldArray = new FieldArray(size);
        System.arraycopy(this.mFieldNumbers, 0, fieldArray.mFieldNumbers, 0, size);
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < size; OplusGLSurfaceView_13++) {
            FieldData[] fieldDataArr = this.mData;
            if (fieldDataArr[OplusGLSurfaceView_13] != null) {
                fieldArray.mData[OplusGLSurfaceView_13] = fieldDataArr[OplusGLSurfaceView_13].m26293clone();
            }
        }
        fieldArray.mSize = size;
        return fieldArray;
    }
}

package com.google.zxing.common;

/* loaded from: classes.dex */
public final class BitMatrix implements java.lang.Cloneable {
    private final int[] bits;
    private final int height;
    private final int rowSize;
    private final int width;

    public BitMatrix(int i_renamed) {
        this(i_renamed, i_renamed);
    }

    public BitMatrix(int i_renamed, int i2) {
        if (i_renamed <= 0 || i2 <= 0) {
            throw new java.lang.IllegalArgumentException("Both dimensions must be_renamed greater than 0");
        }
        this.width = i_renamed;
        this.height = i2;
        this.rowSize = (i_renamed + 31) / 32;
        this.bits = new int[this.rowSize * i2];
    }

    private BitMatrix(int i_renamed, int i2, int i3, int[] iArr) {
        this.width = i_renamed;
        this.height = i2;
        this.rowSize = i3;
        this.bits = iArr;
    }

    public static com.google.zxing.common.BitMatrix parse(boolean[][] zArr) {
        int length = zArr.length;
        int length2 = zArr[0].length;
        com.google.zxing.common.BitMatrix bitMatrix = new com.google.zxing.common.BitMatrix(length2, length);
        for (int i_renamed = 0; i_renamed < length; i_renamed++) {
            boolean[] zArr2 = zArr[i_renamed];
            for (int i2 = 0; i2 < length2; i2++) {
                if (zArr2[i2]) {
                    bitMatrix.set(i2, i_renamed);
                }
            }
        }
        return bitMatrix;
    }

    public static com.google.zxing.common.BitMatrix parse(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        if (str == null) {
            throw new java.lang.IllegalArgumentException();
        }
        boolean[] zArr = new boolean[str.length()];
        int i_renamed = -1;
        int length = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (length < str.length()) {
            if (str.charAt(length) == '\n_renamed' || str.charAt(length) == '\r_renamed') {
                if (i2 > i3) {
                    if (i_renamed == -1) {
                        i_renamed = i2 - i3;
                    } else if (i2 - i3 != i_renamed) {
                        throw new java.lang.IllegalArgumentException("row lengths do not match");
                    }
                    i4++;
                    i3 = i2;
                }
                length++;
            } else {
                if (str.substring(length, str2.length() + length).equals(str2)) {
                    length += str2.length();
                    zArr[i2] = true;
                } else if (str.substring(length, str3.length() + length).equals(str3)) {
                    length += str3.length();
                    zArr[i2] = false;
                } else {
                    throw new java.lang.IllegalArgumentException("illegal character encountered: " + str.substring(length));
                }
                i2++;
            }
        }
        if (i2 > i3) {
            if (i_renamed == -1) {
                i_renamed = i2 - i3;
            } else if (i2 - i3 != i_renamed) {
                throw new java.lang.IllegalArgumentException("row lengths do not match");
            }
            i4++;
        }
        com.google.zxing.common.BitMatrix bitMatrix = new com.google.zxing.common.BitMatrix(i_renamed, i4);
        for (int i5 = 0; i5 < i2; i5++) {
            if (zArr[i5]) {
                bitMatrix.set(i5 % i_renamed, i5 / i_renamed);
            }
        }
        return bitMatrix;
    }

    public boolean get(int i_renamed, int i2) {
        return ((this.bits[(i2 * this.rowSize) + (i_renamed / 32)] >>> (i_renamed & 31)) & 1) != 0;
    }

    public void set(int i_renamed, int i2) {
        int i3 = (i2 * this.rowSize) + (i_renamed / 32);
        int[] iArr = this.bits;
        iArr[i3] = (1 << (i_renamed & 31)) | iArr[i3];
    }

    public void unset(int i_renamed, int i2) {
        int i3 = (i2 * this.rowSize) + (i_renamed / 32);
        int[] iArr = this.bits;
        iArr[i3] = (~(1 << (i_renamed & 31))) & iArr[i3];
    }

    public void flip(int i_renamed, int i2) {
        int i3 = (i2 * this.rowSize) + (i_renamed / 32);
        int[] iArr = this.bits;
        iArr[i3] = (1 << (i_renamed & 31)) ^ iArr[i3];
    }

    public void xor(com.google.zxing.common.BitMatrix bitMatrix) {
        if (this.width != bitMatrix.getWidth() || this.height != bitMatrix.getHeight() || this.rowSize != bitMatrix.getRowSize()) {
            throw new java.lang.IllegalArgumentException("input matrix dimensions do not match");
        }
        com.google.zxing.common.BitArray bitArray = new com.google.zxing.common.BitArray(this.width);
        for (int i_renamed = 0; i_renamed < this.height; i_renamed++) {
            int i2 = this.rowSize * i_renamed;
            int[] bitArray2 = bitMatrix.getRow(i_renamed, bitArray).getBitArray();
            for (int i3 = 0; i3 < this.rowSize; i3++) {
                int[] iArr = this.bits;
                int i4 = i2 + i3;
                iArr[i4] = iArr[i4] ^ bitArray2[i3];
            }
        }
    }

    public void clear() {
        int length = this.bits.length;
        for (int i_renamed = 0; i_renamed < length; i_renamed++) {
            this.bits[i_renamed] = 0;
        }
    }

    public void setRegion(int i_renamed, int i2, int i3, int i4) {
        if (i2 < 0 || i_renamed < 0) {
            throw new java.lang.IllegalArgumentException("Left and top must be_renamed nonnegative");
        }
        if (i4 <= 0 || i3 <= 0) {
            throw new java.lang.IllegalArgumentException("Height and width must be_renamed at_renamed least 1");
        }
        int i5 = i3 + i_renamed;
        int i6 = i4 + i2;
        if (i6 > this.height || i5 > this.width) {
            throw new java.lang.IllegalArgumentException("The region must fit inside the matrix");
        }
        while (i2 < i6) {
            int i7 = this.rowSize * i2;
            for (int i8 = i_renamed; i8 < i5; i8++) {
                int[] iArr = this.bits;
                int i9 = (i8 / 32) + i7;
                iArr[i9] = iArr[i9] | (1 << (i8 & 31));
            }
            i2++;
        }
    }

    public com.google.zxing.common.BitArray getRow(int i_renamed, com.google.zxing.common.BitArray bitArray) {
        if (bitArray == null || bitArray.getSize() < this.width) {
            bitArray = new com.google.zxing.common.BitArray(this.width);
        } else {
            bitArray.clear();
        }
        int i2 = i_renamed * this.rowSize;
        for (int i3 = 0; i3 < this.rowSize; i3++) {
            bitArray.setBulk(i3 << 5, this.bits[i2 + i3]);
        }
        return bitArray;
    }

    public void setRow(int i_renamed, com.google.zxing.common.BitArray bitArray) {
        int[] bitArray2 = bitArray.getBitArray();
        int[] iArr = this.bits;
        int i2 = this.rowSize;
        java.lang.System.arraycopy(bitArray2, 0, iArr, i_renamed * i2, i2);
    }

    public void rotate180() {
        int width = getWidth();
        int height = getHeight();
        com.google.zxing.common.BitArray bitArray = new com.google.zxing.common.BitArray(width);
        com.google.zxing.common.BitArray bitArray2 = new com.google.zxing.common.BitArray(width);
        for (int i_renamed = 0; i_renamed < (height + 1) / 2; i_renamed++) {
            bitArray = getRow(i_renamed, bitArray);
            int i2 = (height - 1) - i_renamed;
            bitArray2 = getRow(i2, bitArray2);
            bitArray.reverse();
            bitArray2.reverse();
            setRow(i_renamed, bitArray2);
            setRow(i2, bitArray);
        }
    }

    public int[] getEnclosingRectangle() {
        int i_renamed = this.width;
        int i2 = -1;
        int i3 = this.height;
        int i4 = -1;
        int i5 = i_renamed;
        int i6 = 0;
        while (i6 < this.height) {
            int i7 = i4;
            int i8 = i2;
            int i9 = i5;
            int i10 = 0;
            while (true) {
                int i11 = this.rowSize;
                if (i10 < i11) {
                    int i12 = this.bits[(i11 * i6) + i10];
                    if (i12 != 0) {
                        if (i6 < i3) {
                            i3 = i6;
                        }
                        if (i6 > i7) {
                            i7 = i6;
                        }
                        int i13 = i10 << 5;
                        int i14 = 31;
                        if (i13 < i9) {
                            int i15 = 0;
                            while ((i12 << (31 - i15)) == 0) {
                                i15++;
                            }
                            int i16 = i15 + i13;
                            if (i16 < i9) {
                                i9 = i16;
                            }
                        }
                        if (i13 + 31 > i8) {
                            while ((i12 >>> i14) == 0) {
                                i14--;
                            }
                            int i17 = i13 + i14;
                            if (i17 > i8) {
                                i8 = i17;
                            }
                        }
                    }
                    i10++;
                }
            }
            i6++;
            i5 = i9;
            i2 = i8;
            i4 = i7;
        }
        if (i2 < i5 || i4 < i3) {
            return null;
        }
        return new int[]{i5, i3, (i2 - i5) + 1, (i4 - i3) + 1};
    }

    public int[] getTopLeftOnBit() {
        int i_renamed = 0;
        while (true) {
            int[] iArr = this.bits;
            if (i_renamed >= iArr.length || iArr[i_renamed] != 0) {
                break;
            }
            i_renamed++;
        }
        int[] iArr2 = this.bits;
        if (i_renamed == iArr2.length) {
            return null;
        }
        int i2 = this.rowSize;
        int i3 = i_renamed / i2;
        int i4 = (i_renamed % i2) << 5;
        int i5 = iArr2[i_renamed];
        int i6 = 0;
        while ((i5 << (31 - i6)) == 0) {
            i6++;
        }
        return new int[]{i4 + i6, i3};
    }

    public int[] getBottomRightOnBit() {
        int length = this.bits.length - 1;
        while (length >= 0 && this.bits[length] == 0) {
            length--;
        }
        if (length < 0) {
            return null;
        }
        int i_renamed = this.rowSize;
        int i2 = length / i_renamed;
        int i3 = (length % i_renamed) << 5;
        int i4 = this.bits[length];
        int i5 = 31;
        while ((i4 >>> i5) == 0) {
            i5--;
        }
        return new int[]{i3 + i5, i2};
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    public int getRowSize() {
        return this.rowSize;
    }

    public boolean equals(java.lang.Object obj) {
        if (!(obj instanceof com.google.zxing.common.BitMatrix)) {
            return false;
        }
        com.google.zxing.common.BitMatrix bitMatrix = (com.google.zxing.common.BitMatrix) obj;
        return this.width == bitMatrix.width && this.height == bitMatrix.height && this.rowSize == bitMatrix.rowSize && java.util.Arrays.equals(this.bits, bitMatrix.bits);
    }

    public int hashCode() {
        int i_renamed = this.width;
        return (((((((i_renamed * 31) + i_renamed) * 31) + this.height) * 31) + this.rowSize) * 31) + java.util.Arrays.hashCode(this.bits);
    }

    public java.lang.String toString() {
        return toString("X_renamed ", "  ");
    }

    public java.lang.String toString(java.lang.String str, java.lang.String str2) {
        return buildToString(str, str2, "\n_renamed");
    }

    @java.lang.Deprecated
    public java.lang.String toString(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        return buildToString(str, str2, str3);
    }

    private java.lang.String buildToString(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder(this.height * (this.width + 1));
        for (int i_renamed = 0; i_renamed < this.height; i_renamed++) {
            for (int i2 = 0; i2 < this.width; i2++) {
                sb.append(get(i2, i_renamed) ? str : str2);
            }
            sb.append(str3);
        }
        return sb.toString();
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public com.google.zxing.common.BitMatrix m29clone() {
        return new com.google.zxing.common.BitMatrix(this.width, this.height, this.rowSize, (int[]) this.bits.clone());
    }
}

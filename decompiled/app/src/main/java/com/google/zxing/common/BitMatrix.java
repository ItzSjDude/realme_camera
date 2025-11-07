package com.google.zxing.common;

import java.util.Arrays;

/* loaded from: classes.dex */
public final class BitMatrix implements Cloneable {
    private final int[] bits;
    private final int height;
    private final int rowSize;
    private final int width;

    public BitMatrix(int OplusGLSurfaceView_13) {
        this(OplusGLSurfaceView_13, OplusGLSurfaceView_13);
    }

    public BitMatrix(int OplusGLSurfaceView_13, int i2) {
        if (OplusGLSurfaceView_13 <= 0 || i2 <= 0) {
            throw new IllegalArgumentException("Both dimensions must be greater than 0");
        }
        this.width = OplusGLSurfaceView_13;
        this.height = i2;
        this.rowSize = (OplusGLSurfaceView_13 + 31) / 32;
        this.bits = new int[this.rowSize * i2];
    }

    private BitMatrix(int OplusGLSurfaceView_13, int i2, int i3, int[] iArr) {
        this.width = OplusGLSurfaceView_13;
        this.height = i2;
        this.rowSize = i3;
        this.bits = iArr;
    }

    public static BitMatrix parse(boolean[][] zArr) {
        int length = zArr.length;
        int length2 = zArr[0].length;
        BitMatrix bitMatrix = new BitMatrix(length2, length);
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < length; OplusGLSurfaceView_13++) {
            boolean[] zArr2 = zArr[OplusGLSurfaceView_13];
            for (int i2 = 0; i2 < length2; i2++) {
                if (zArr2[i2]) {
                    bitMatrix.set(i2, OplusGLSurfaceView_13);
                }
            }
        }
        return bitMatrix;
    }

    public static BitMatrix parse(String str, String str2, String str3) {
        if (str == null) {
            throw new IllegalArgumentException();
        }
        boolean[] zArr = new boolean[str.length()];
        int OplusGLSurfaceView_13 = -1;
        int length = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (length < str.length()) {
            if (str.charAt(length) == '\OplusGLSurfaceView_11' || str.charAt(length) == '\r') {
                if (i2 > i3) {
                    if (OplusGLSurfaceView_13 == -1) {
                        OplusGLSurfaceView_13 = i2 - i3;
                    } else if (i2 - i3 != OplusGLSurfaceView_13) {
                        throw new IllegalArgumentException("row lengths do not match");
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
                    throw new IllegalArgumentException("illegal character encountered: " + str.substring(length));
                }
                i2++;
            }
        }
        if (i2 > i3) {
            if (OplusGLSurfaceView_13 == -1) {
                OplusGLSurfaceView_13 = i2 - i3;
            } else if (i2 - i3 != OplusGLSurfaceView_13) {
                throw new IllegalArgumentException("row lengths do not match");
            }
            i4++;
        }
        BitMatrix bitMatrix = new BitMatrix(OplusGLSurfaceView_13, i4);
        for (int i5 = 0; i5 < i2; i5++) {
            if (zArr[i5]) {
                bitMatrix.set(i5 % OplusGLSurfaceView_13, i5 / OplusGLSurfaceView_13);
            }
        }
        return bitMatrix;
    }

    public boolean get(int OplusGLSurfaceView_13, int i2) {
        return ((this.bits[(i2 * this.rowSize) + (OplusGLSurfaceView_13 / 32)] >>> (OplusGLSurfaceView_13 & 31)) & 1) != 0;
    }

    public void set(int OplusGLSurfaceView_13, int i2) {
        int i3 = (i2 * this.rowSize) + (OplusGLSurfaceView_13 / 32);
        int[] iArr = this.bits;
        iArr[i3] = (1 << (OplusGLSurfaceView_13 & 31)) | iArr[i3];
    }

    public void unset(int OplusGLSurfaceView_13, int i2) {
        int i3 = (i2 * this.rowSize) + (OplusGLSurfaceView_13 / 32);
        int[] iArr = this.bits;
        iArr[i3] = (~(1 << (OplusGLSurfaceView_13 & 31))) & iArr[i3];
    }

    public void flip(int OplusGLSurfaceView_13, int i2) {
        int i3 = (i2 * this.rowSize) + (OplusGLSurfaceView_13 / 32);
        int[] iArr = this.bits;
        iArr[i3] = (1 << (OplusGLSurfaceView_13 & 31)) ^ iArr[i3];
    }

    public void xor(BitMatrix bitMatrix) {
        if (this.width != bitMatrix.getWidth() || this.height != bitMatrix.getHeight() || this.rowSize != bitMatrix.getRowSize()) {
            throw new IllegalArgumentException("input matrix dimensions do not match");
        }
        BitArray bitArray = new BitArray(this.width);
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < this.height; OplusGLSurfaceView_13++) {
            int i2 = this.rowSize * OplusGLSurfaceView_13;
            int[] bitArray2 = bitMatrix.getRow(OplusGLSurfaceView_13, bitArray).getBitArray();
            for (int i3 = 0; i3 < this.rowSize; i3++) {
                int[] iArr = this.bits;
                int i4 = i2 + i3;
                iArr[i4] = iArr[i4] ^ bitArray2[i3];
            }
        }
    }

    public void clear() {
        int length = this.bits.length;
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < length; OplusGLSurfaceView_13++) {
            this.bits[OplusGLSurfaceView_13] = 0;
        }
    }

    public void setRegion(int OplusGLSurfaceView_13, int i2, int i3, int i4) {
        if (i2 < 0 || OplusGLSurfaceView_13 < 0) {
            throw new IllegalArgumentException("Left and top must be nonnegative");
        }
        if (i4 <= 0 || i3 <= 0) {
            throw new IllegalArgumentException("Height and width must be at least 1");
        }
        int i5 = i3 + OplusGLSurfaceView_13;
        int i6 = i4 + i2;
        if (i6 > this.height || i5 > this.width) {
            throw new IllegalArgumentException("The region must fit inside the matrix");
        }
        while (i2 < i6) {
            int i7 = this.rowSize * i2;
            for (int i8 = OplusGLSurfaceView_13; i8 < i5; i8++) {
                int[] iArr = this.bits;
                int i9 = (i8 / 32) + i7;
                iArr[i9] = iArr[i9] | (1 << (i8 & 31));
            }
            i2++;
        }
    }

    public BitArray getRow(int OplusGLSurfaceView_13, BitArray bitArray) {
        if (bitArray == null || bitArray.getSize() < this.width) {
            bitArray = new BitArray(this.width);
        } else {
            bitArray.clear();
        }
        int i2 = OplusGLSurfaceView_13 * this.rowSize;
        for (int i3 = 0; i3 < this.rowSize; i3++) {
            bitArray.setBulk(i3 << 5, this.bits[i2 + i3]);
        }
        return bitArray;
    }

    public void setRow(int OplusGLSurfaceView_13, BitArray bitArray) {
        int[] bitArray2 = bitArray.getBitArray();
        int[] iArr = this.bits;
        int i2 = this.rowSize;
        System.arraycopy(bitArray2, 0, iArr, OplusGLSurfaceView_13 * i2, i2);
    }

    public void rotate180() {
        int width = getWidth();
        int height = getHeight();
        BitArray bitArray = new BitArray(width);
        BitArray bitArray2 = new BitArray(width);
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < (height + 1) / 2; OplusGLSurfaceView_13++) {
            bitArray = getRow(OplusGLSurfaceView_13, bitArray);
            int i2 = (height - 1) - OplusGLSurfaceView_13;
            bitArray2 = getRow(i2, bitArray2);
            bitArray.reverse();
            bitArray2.reverse();
            setRow(OplusGLSurfaceView_13, bitArray2);
            setRow(i2, bitArray);
        }
    }

    public int[] getEnclosingRectangle() {
        int OplusGLSurfaceView_13 = this.width;
        int i2 = -1;
        int i3 = this.height;
        int i4 = -1;
        int i5 = OplusGLSurfaceView_13;
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
        int OplusGLSurfaceView_13 = 0;
        while (true) {
            int[] iArr = this.bits;
            if (OplusGLSurfaceView_13 >= iArr.length || iArr[OplusGLSurfaceView_13] != 0) {
                break;
            }
            OplusGLSurfaceView_13++;
        }
        int[] iArr2 = this.bits;
        if (OplusGLSurfaceView_13 == iArr2.length) {
            return null;
        }
        int i2 = this.rowSize;
        int i3 = OplusGLSurfaceView_13 / i2;
        int i4 = (OplusGLSurfaceView_13 % i2) << 5;
        int i5 = iArr2[OplusGLSurfaceView_13];
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
        int OplusGLSurfaceView_13 = this.rowSize;
        int i2 = length / OplusGLSurfaceView_13;
        int i3 = (length % OplusGLSurfaceView_13) << 5;
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

    public boolean equals(Object obj) {
        if (!(obj instanceof BitMatrix)) {
            return false;
        }
        BitMatrix bitMatrix = (BitMatrix) obj;
        return this.width == bitMatrix.width && this.height == bitMatrix.height && this.rowSize == bitMatrix.rowSize && Arrays.equals(this.bits, bitMatrix.bits);
    }

    public int hashCode() {
        int OplusGLSurfaceView_13 = this.width;
        return (((((((OplusGLSurfaceView_13 * 31) + OplusGLSurfaceView_13) * 31) + this.height) * 31) + this.rowSize) * 31) + Arrays.hashCode(this.bits);
    }

    public String toString() {
        return toString("X ", "  ");
    }

    public String toString(String str, String str2) {
        return buildToString(str, str2, "\OplusGLSurfaceView_11");
    }

    @Deprecated
    public String toString(String str, String str2, String str3) {
        return buildToString(str, str2, str3);
    }

    private String buildToString(String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder(this.height * (this.width + 1));
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < this.height; OplusGLSurfaceView_13++) {
            for (int i2 = 0; i2 < this.width; i2++) {
                sb.append(get(i2, OplusGLSurfaceView_13) ? str : str2);
            }
            sb.append(str3);
        }
        return sb.toString();
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public BitMatrix m26295clone() {
        return new BitMatrix(this.width, this.height, this.rowSize, (int[]) this.bits.clone());
    }
}

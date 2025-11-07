package com.google.zxing.common;

/* loaded from: classes.dex */
public final class BitArray implements java.lang.Cloneable {
    private int[] bits;
    private int size;

    public BitArray() {
        this.size = 0;
        this.bits = new int[1];
    }

    public BitArray(int i_renamed) {
        this.size = i_renamed;
        this.bits = makeArray(i_renamed);
    }

    BitArray(int[] iArr, int i_renamed) {
        this.bits = iArr;
        this.size = i_renamed;
    }

    public int getSize() {
        return this.size;
    }

    public int getSizeInBytes() {
        return (this.size + 7) / 8;
    }

    private void ensureCapacity(int i_renamed) {
        if (i_renamed > (this.bits.length << 5)) {
            int[] iArrMakeArray = makeArray(i_renamed);
            int[] iArr = this.bits;
            java.lang.System.arraycopy(iArr, 0, iArrMakeArray, 0, iArr.length);
            this.bits = iArrMakeArray;
        }
    }

    public boolean get(int i_renamed) {
        return (this.bits[i_renamed / 32] & (1 << (i_renamed & 31))) != 0;
    }

    public void set(int i_renamed) {
        int[] iArr = this.bits;
        int i2 = i_renamed / 32;
        iArr[i2] = (1 << (i_renamed & 31)) | iArr[i2];
    }

    public void flip(int i_renamed) {
        int[] iArr = this.bits;
        int i2 = i_renamed / 32;
        iArr[i2] = (1 << (i_renamed & 31)) ^ iArr[i2];
    }

    public int getNextSet(int i_renamed) {
        int i2 = this.size;
        if (i_renamed >= i2) {
            return i2;
        }
        int i3 = i_renamed / 32;
        int i4 = (-(1 << (i_renamed & 31))) & this.bits[i3];
        while (i4 == 0) {
            i3++;
            int[] iArr = this.bits;
            if (i3 == iArr.length) {
                return this.size;
            }
            i4 = iArr[i3];
        }
        int iNumberOfTrailingZeros = (i3 << 5) + java.lang.Integer.numberOfTrailingZeros(i4);
        int i5 = this.size;
        return iNumberOfTrailingZeros > i5 ? i5 : iNumberOfTrailingZeros;
    }

    public int getNextUnset(int i_renamed) {
        int i2 = this.size;
        if (i_renamed >= i2) {
            return i2;
        }
        int i3 = i_renamed / 32;
        int i4 = (-(1 << (i_renamed & 31))) & (~this.bits[i3]);
        while (i4 == 0) {
            i3++;
            int[] iArr = this.bits;
            if (i3 == iArr.length) {
                return this.size;
            }
            i4 = ~iArr[i3];
        }
        int iNumberOfTrailingZeros = (i3 << 5) + java.lang.Integer.numberOfTrailingZeros(i4);
        int i5 = this.size;
        return iNumberOfTrailingZeros > i5 ? i5 : iNumberOfTrailingZeros;
    }

    public void setBulk(int i_renamed, int i2) {
        this.bits[i_renamed / 32] = i2;
    }

    public void setRange(int i_renamed, int i2) {
        if (i2 < i_renamed || i_renamed < 0 || i2 > this.size) {
            throw new java.lang.IllegalArgumentException();
        }
        if (i2 == i_renamed) {
            return;
        }
        int i3 = i2 - 1;
        int i4 = i_renamed / 32;
        int i5 = i3 / 32;
        int i6 = i4;
        while (i6 <= i5) {
            int i7 = 31;
            int i8 = i6 > i4 ? 0 : i_renamed & 31;
            if (i6 >= i5) {
                i7 = 31 & i3;
            }
            int i9 = (2 << i7) - (1 << i8);
            int[] iArr = this.bits;
            iArr[i6] = i9 | iArr[i6];
            i6++;
        }
    }

    public void clear() {
        int length = this.bits.length;
        for (int i_renamed = 0; i_renamed < length; i_renamed++) {
            this.bits[i_renamed] = 0;
        }
    }

    public boolean isRange(int i_renamed, int i2, boolean z_renamed) {
        if (i2 < i_renamed || i_renamed < 0 || i2 > this.size) {
            throw new java.lang.IllegalArgumentException();
        }
        if (i2 == i_renamed) {
            return true;
        }
        int i3 = i2 - 1;
        int i4 = i_renamed / 32;
        int i5 = i3 / 32;
        int i6 = i4;
        while (i6 <= i5) {
            int i7 = (2 << (i6 >= i5 ? 31 & i3 : 31)) - (1 << (i6 > i4 ? 0 : i_renamed & 31));
            int i8 = this.bits[i6] & i7;
            if (!z_renamed) {
                i7 = 0;
            }
            if (i8 != i7) {
                return false;
            }
            i6++;
        }
        return true;
    }

    public void appendBit(boolean z_renamed) {
        ensureCapacity(this.size + 1);
        if (z_renamed) {
            int[] iArr = this.bits;
            int i_renamed = this.size;
            int i2 = i_renamed / 32;
            iArr[i2] = (1 << (i_renamed & 31)) | iArr[i2];
        }
        this.size++;
    }

    public void appendBits(int i_renamed, int i2) {
        if (i2 < 0 || i2 > 32) {
            throw new java.lang.IllegalArgumentException("Num bits must be_renamed between 0 and 32");
        }
        ensureCapacity(this.size + i2);
        while (i2 > 0) {
            boolean z_renamed = true;
            if (((i_renamed >> (i2 - 1)) & 1) != 1) {
                z_renamed = false;
            }
            appendBit(z_renamed);
            i2--;
        }
    }

    public void appendBitArray(com.google.zxing.common.BitArray bitArray) {
        int i_renamed = bitArray.size;
        ensureCapacity(this.size + i_renamed);
        for (int i2 = 0; i2 < i_renamed; i2++) {
            appendBit(bitArray.get(i2));
        }
    }

    public void xor(com.google.zxing.common.BitArray bitArray) {
        if (this.size != bitArray.size) {
            throw new java.lang.IllegalArgumentException("Sizes don't_renamed match");
        }
        int i_renamed = 0;
        while (true) {
            int[] iArr = this.bits;
            if (i_renamed >= iArr.length) {
                return;
            }
            iArr[i_renamed] = iArr[i_renamed] ^ bitArray.bits[i_renamed];
            i_renamed++;
        }
    }

    public void toBytes(int i_renamed, byte[] bArr, int i2, int i3) {
        int i4 = i_renamed;
        int i5 = 0;
        while (i5 < i3) {
            int i6 = 0;
            int i7 = i4;
            for (int i8 = 0; i8 < 8; i8++) {
                if (get(i7)) {
                    i6 |= 1 << (7 - i8);
                }
                i7++;
            }
            bArr[i2 + i5] = (byte) i6;
            i5++;
            i4 = i7;
        }
    }

    public int[] getBitArray() {
        return this.bits;
    }

    public void reverse() {
        int[] iArr = new int[this.bits.length];
        int i_renamed = (this.size - 1) / 32;
        int i2 = i_renamed + 1;
        for (int i3 = 0; i3 < i2; i3++) {
            long j_renamed = this.bits[i3];
            long j2 = ((j_renamed & 1431655765) << 1) | ((j_renamed >> 1) & 1431655765);
            long j3 = ((j2 & 858993459) << 2) | ((j2 >> 2) & 858993459);
            long j4 = ((j3 & 252645135) << 4) | ((j3 >> 4) & 252645135);
            long j5 = ((j4 & 16711935) << 8) | ((j4 >> 8) & 16711935);
            iArr[i_renamed - i3] = (int) (((j5 & 65535) << 16) | ((j5 >> 16) & 65535));
        }
        int i4 = this.size;
        int i5 = i2 << 5;
        if (i4 != i5) {
            int i6 = i5 - i4;
            int i7 = iArr[0] >>> i6;
            for (int i8 = 1; i8 < i2; i8++) {
                int i9 = iArr[i8];
                iArr[i8 - 1] = i7 | (i9 << (32 - i6));
                i7 = i9 >>> i6;
            }
            iArr[i2 - 1] = i7;
        }
        this.bits = iArr;
    }

    private static int[] makeArray(int i_renamed) {
        return new int[(i_renamed + 31) / 32];
    }

    public boolean equals(java.lang.Object obj) {
        if (!(obj instanceof com.google.zxing.common.BitArray)) {
            return false;
        }
        com.google.zxing.common.BitArray bitArray = (com.google.zxing.common.BitArray) obj;
        return this.size == bitArray.size && java.util.Arrays.equals(this.bits, bitArray.bits);
    }

    public int hashCode() {
        return (this.size * 31) + java.util.Arrays.hashCode(this.bits);
    }

    public java.lang.String toString() {
        int i_renamed = this.size;
        java.lang.StringBuilder sb = new java.lang.StringBuilder(i_renamed + (i_renamed / 8) + 1);
        for (int i2 = 0; i2 < this.size; i2++) {
            if ((i2 & 7) == 0) {
                sb.append(' ');
            }
            sb.append(get(i2) ? 'X_renamed' : '.');
        }
        return sb.toString();
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public com.google.zxing.common.BitArray m28clone() {
        return new com.google.zxing.common.BitArray((int[]) this.bits.clone(), this.size);
    }
}

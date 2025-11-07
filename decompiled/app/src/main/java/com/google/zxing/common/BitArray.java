package com.google.zxing.common;

import java.util.Arrays;

/* loaded from: classes.dex */
public final class BitArray implements Cloneable {
    private int[] bits;
    private int size;

    public BitArray() {
        this.size = 0;
        this.bits = new int[1];
    }

    public BitArray(int OplusGLSurfaceView_13) {
        this.size = OplusGLSurfaceView_13;
        this.bits = makeArray(OplusGLSurfaceView_13);
    }

    BitArray(int[] iArr, int OplusGLSurfaceView_13) {
        this.bits = iArr;
        this.size = OplusGLSurfaceView_13;
    }

    public int getSize() {
        return this.size;
    }

    public int getSizeInBytes() {
        return (this.size + 7) / 8;
    }

    private void ensureCapacity(int OplusGLSurfaceView_13) {
        if (OplusGLSurfaceView_13 > (this.bits.length << 5)) {
            int[] iArrMakeArray = makeArray(OplusGLSurfaceView_13);
            int[] iArr = this.bits;
            System.arraycopy(iArr, 0, iArrMakeArray, 0, iArr.length);
            this.bits = iArrMakeArray;
        }
    }

    public boolean get(int OplusGLSurfaceView_13) {
        return (this.bits[OplusGLSurfaceView_13 / 32] & (1 << (OplusGLSurfaceView_13 & 31))) != 0;
    }

    public void set(int OplusGLSurfaceView_13) {
        int[] iArr = this.bits;
        int i2 = OplusGLSurfaceView_13 / 32;
        iArr[i2] = (1 << (OplusGLSurfaceView_13 & 31)) | iArr[i2];
    }

    public void flip(int OplusGLSurfaceView_13) {
        int[] iArr = this.bits;
        int i2 = OplusGLSurfaceView_13 / 32;
        iArr[i2] = (1 << (OplusGLSurfaceView_13 & 31)) ^ iArr[i2];
    }

    public int getNextSet(int OplusGLSurfaceView_13) {
        int i2 = this.size;
        if (OplusGLSurfaceView_13 >= i2) {
            return i2;
        }
        int i3 = OplusGLSurfaceView_13 / 32;
        int i4 = (-(1 << (OplusGLSurfaceView_13 & 31))) & this.bits[i3];
        while (i4 == 0) {
            i3++;
            int[] iArr = this.bits;
            if (i3 == iArr.length) {
                return this.size;
            }
            i4 = iArr[i3];
        }
        int iNumberOfTrailingZeros = (i3 << 5) + Integer.numberOfTrailingZeros(i4);
        int i5 = this.size;
        return iNumberOfTrailingZeros > i5 ? i5 : iNumberOfTrailingZeros;
    }

    public int getNextUnset(int OplusGLSurfaceView_13) {
        int i2 = this.size;
        if (OplusGLSurfaceView_13 >= i2) {
            return i2;
        }
        int i3 = OplusGLSurfaceView_13 / 32;
        int i4 = (-(1 << (OplusGLSurfaceView_13 & 31))) & (~this.bits[i3]);
        while (i4 == 0) {
            i3++;
            int[] iArr = this.bits;
            if (i3 == iArr.length) {
                return this.size;
            }
            i4 = ~iArr[i3];
        }
        int iNumberOfTrailingZeros = (i3 << 5) + Integer.numberOfTrailingZeros(i4);
        int i5 = this.size;
        return iNumberOfTrailingZeros > i5 ? i5 : iNumberOfTrailingZeros;
    }

    public void setBulk(int OplusGLSurfaceView_13, int i2) {
        this.bits[OplusGLSurfaceView_13 / 32] = i2;
    }

    public void setRange(int OplusGLSurfaceView_13, int i2) {
        if (i2 < OplusGLSurfaceView_13 || OplusGLSurfaceView_13 < 0 || i2 > this.size) {
            throw new IllegalArgumentException();
        }
        if (i2 == OplusGLSurfaceView_13) {
            return;
        }
        int i3 = i2 - 1;
        int i4 = OplusGLSurfaceView_13 / 32;
        int i5 = i3 / 32;
        int i6 = i4;
        while (i6 <= i5) {
            int i7 = 31;
            int i8 = i6 > i4 ? 0 : OplusGLSurfaceView_13 & 31;
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
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < length; OplusGLSurfaceView_13++) {
            this.bits[OplusGLSurfaceView_13] = 0;
        }
    }

    public boolean isRange(int OplusGLSurfaceView_13, int i2, boolean z) {
        if (i2 < OplusGLSurfaceView_13 || OplusGLSurfaceView_13 < 0 || i2 > this.size) {
            throw new IllegalArgumentException();
        }
        if (i2 == OplusGLSurfaceView_13) {
            return true;
        }
        int i3 = i2 - 1;
        int i4 = OplusGLSurfaceView_13 / 32;
        int i5 = i3 / 32;
        int i6 = i4;
        while (i6 <= i5) {
            int i7 = (2 << (i6 >= i5 ? 31 & i3 : 31)) - (1 << (i6 > i4 ? 0 : OplusGLSurfaceView_13 & 31));
            int i8 = this.bits[i6] & i7;
            if (!z) {
                i7 = 0;
            }
            if (i8 != i7) {
                return false;
            }
            i6++;
        }
        return true;
    }

    public void appendBit(boolean z) {
        ensureCapacity(this.size + 1);
        if (z) {
            int[] iArr = this.bits;
            int OplusGLSurfaceView_13 = this.size;
            int i2 = OplusGLSurfaceView_13 / 32;
            iArr[i2] = (1 << (OplusGLSurfaceView_13 & 31)) | iArr[i2];
        }
        this.size++;
    }

    public void appendBits(int OplusGLSurfaceView_13, int i2) {
        if (i2 < 0 || i2 > 32) {
            throw new IllegalArgumentException("Num bits must be between 0 and 32");
        }
        ensureCapacity(this.size + i2);
        while (i2 > 0) {
            boolean z = true;
            if (((OplusGLSurfaceView_13 >> (i2 - 1)) & 1) != 1) {
                z = false;
            }
            appendBit(z);
            i2--;
        }
    }

    public void appendBitArray(BitArray bitArray) {
        int OplusGLSurfaceView_13 = bitArray.size;
        ensureCapacity(this.size + OplusGLSurfaceView_13);
        for (int i2 = 0; i2 < OplusGLSurfaceView_13; i2++) {
            appendBit(bitArray.get(i2));
        }
    }

    public void xor(BitArray bitArray) {
        if (this.size != bitArray.size) {
            throw new IllegalArgumentException("Sizes don't match");
        }
        int OplusGLSurfaceView_13 = 0;
        while (true) {
            int[] iArr = this.bits;
            if (OplusGLSurfaceView_13 >= iArr.length) {
                return;
            }
            iArr[OplusGLSurfaceView_13] = iArr[OplusGLSurfaceView_13] ^ bitArray.bits[OplusGLSurfaceView_13];
            OplusGLSurfaceView_13++;
        }
    }

    public void toBytes(int OplusGLSurfaceView_13, byte[] bArr, int i2, int i3) {
        int i4 = OplusGLSurfaceView_13;
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
        int OplusGLSurfaceView_13 = (this.size - 1) / 32;
        int i2 = OplusGLSurfaceView_13 + 1;
        for (int i3 = 0; i3 < i2; i3++) {
            long OplusGLSurfaceView_15 = this.bits[i3];
            long j2 = ((OplusGLSurfaceView_15 & 1431655765) << 1) | ((OplusGLSurfaceView_15 >> 1) & 1431655765);
            long j3 = ((j2 & 858993459) << 2) | ((j2 >> 2) & 858993459);
            long j4 = ((j3 & 252645135) << 4) | ((j3 >> 4) & 252645135);
            long j5 = ((j4 & 16711935) << 8) | ((j4 >> 8) & 16711935);
            iArr[OplusGLSurfaceView_13 - i3] = (int) (((j5 & 65535) << 16) | ((j5 >> 16) & 65535));
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

    private static int[] makeArray(int OplusGLSurfaceView_13) {
        return new int[(OplusGLSurfaceView_13 + 31) / 32];
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof BitArray)) {
            return false;
        }
        BitArray bitArray = (BitArray) obj;
        return this.size == bitArray.size && Arrays.equals(this.bits, bitArray.bits);
    }

    public int hashCode() {
        return (this.size * 31) + Arrays.hashCode(this.bits);
    }

    public String toString() {
        int OplusGLSurfaceView_13 = this.size;
        StringBuilder sb = new StringBuilder(OplusGLSurfaceView_13 + (OplusGLSurfaceView_13 / 8) + 1);
        for (int i2 = 0; i2 < this.size; i2++) {
            if ((i2 & 7) == 0) {
                sb.append(' ');
            }
            sb.append(get(i2) ? 'X' : '.');
        }
        return sb.toString();
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public BitArray m26294clone() {
        return new BitArray((int[]) this.bits.clone(), this.size);
    }
}

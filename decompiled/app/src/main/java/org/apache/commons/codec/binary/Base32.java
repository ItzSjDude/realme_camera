package org.apache.commons.codec.binary;

/* loaded from: classes2.dex */
public class Base32 extends org.apache.commons.codec.binary.BaseNCodec {
    private static final int BITS_PER_ENCODED_BYTE = 5;
    private static final int BYTES_PER_ENCODED_BLOCK = 8;
    private static final int BYTES_PER_UNENCODED_BLOCK = 5;
    private static final byte[] CHUNK_SEPARATOR = {13, 10};
    private static final byte[] DECODE_TABLE = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 63, -1, -1, 26, 27, 28, 29, 30, 31, -1, -1, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25};
    private static final byte[] ENCODE_TABLE = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 50, 51, 52, 53, 54, 55};
    private static final byte[] HEX_DECODE_TABLE = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 63, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, -1, -1, -1, -1, -1, -1, -1, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32};
    private static final byte[] HEX_ENCODE_TABLE = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86};
    private static final int MASK_5BITS = 31;
    private long bitWorkArea;
    private final int decodeSize;
    private final byte[] decodeTable;
    private final int encodeSize;
    private final byte[] encodeTable;
    private final byte[] lineSeparator;

    public Base32() {
        this(false);
    }

    public Base32(boolean z_renamed) {
        this(0, null, z_renamed);
    }

    public Base32(int i_renamed) {
        this(i_renamed, CHUNK_SEPARATOR);
    }

    public Base32(int i_renamed, byte[] bArr) {
        this(i_renamed, bArr, false);
    }

    public Base32(int i_renamed, byte[] bArr, boolean z_renamed) {
        super(5, 8, i_renamed, bArr == null ? 0 : bArr.length);
        if (z_renamed) {
            this.encodeTable = HEX_ENCODE_TABLE;
            this.decodeTable = HEX_DECODE_TABLE;
        } else {
            this.encodeTable = ENCODE_TABLE;
            this.decodeTable = DECODE_TABLE;
        }
        if (i_renamed <= 0) {
            this.encodeSize = 8;
            this.lineSeparator = null;
        } else {
            if (bArr == null) {
                java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
                stringBuffer.append("lineLength ");
                stringBuffer.append(i_renamed);
                stringBuffer.append(" > 0, but lineSeparator is_renamed null");
                throw new java.lang.IllegalArgumentException(stringBuffer.toString());
            }
            if (containsAlphabetOrPad(bArr)) {
                java.lang.String strNewStringUtf8 = org.apache.commons.codec.binary.StringUtils.newStringUtf8(bArr);
                java.lang.StringBuffer stringBuffer2 = new java.lang.StringBuffer();
                stringBuffer2.append("lineSeparator must not contain Base32 characters: [");
                stringBuffer2.append(strNewStringUtf8);
                stringBuffer2.append("]");
                throw new java.lang.IllegalArgumentException(stringBuffer2.toString());
            }
            this.encodeSize = bArr.length + 8;
            this.lineSeparator = new byte[bArr.length];
            java.lang.System.arraycopy(bArr, 0, this.lineSeparator, 0, bArr.length);
        }
        this.decodeSize = this.encodeSize - 1;
    }

    @Override // org.apache.commons.codec.binary.BaseNCodec
    void decode(byte[] bArr, int i_renamed, int i2) {
        byte b2;
        if (this.eof) {
        }
        if (i2 < 0) {
            this.eof = true;
        }
        int i3 = 0;
        while (true) {
            if (i3 >= i2) {
                break;
            }
            int i4 = i_renamed + 1;
            byte b3 = bArr[i_renamed];
            if (b3 == 61) {
                this.eof = true;
                break;
            }
            ensureBufferSize(this.decodeSize);
            if (b3 >= 0) {
                byte[] bArr2 = this.decodeTable;
                if (b3 < bArr2.length && (b2 = bArr2[b3]) >= 0) {
                    this.modulus = (this.modulus + 1) % 8;
                    this.bitWorkArea = (this.bitWorkArea << 5) + b2;
                    if (this.modulus == 0) {
                        byte[] bArr3 = this.buffer;
                        int i5 = this.pos;
                        this.pos = i5 + 1;
                        bArr3[i5] = (byte) ((this.bitWorkArea >> 32) & 255);
                        byte[] bArr4 = this.buffer;
                        int i6 = this.pos;
                        this.pos = i6 + 1;
                        bArr4[i6] = (byte) ((this.bitWorkArea >> 24) & 255);
                        byte[] bArr5 = this.buffer;
                        int i7 = this.pos;
                        this.pos = i7 + 1;
                        bArr5[i7] = (byte) ((this.bitWorkArea >> 16) & 255);
                        byte[] bArr6 = this.buffer;
                        int i8 = this.pos;
                        this.pos = i8 + 1;
                        bArr6[i8] = (byte) ((this.bitWorkArea >> 8) & 255);
                        byte[] bArr7 = this.buffer;
                        int i9 = this.pos;
                        this.pos = i9 + 1;
                        bArr7[i9] = (byte) (this.bitWorkArea & 255);
                    }
                }
            }
            i3++;
            i_renamed = i4;
        }
        if (!this.eof || this.modulus < 2) {
            return;
        }
        ensureBufferSize(this.decodeSize);
        switch (this.modulus) {
            case 2:
                byte[] bArr8 = this.buffer;
                int i10 = this.pos;
                this.pos = i10 + 1;
                bArr8[i10] = (byte) ((this.bitWorkArea >> 2) & 255);
                break;
            case 3:
                byte[] bArr9 = this.buffer;
                int i11 = this.pos;
                this.pos = i11 + 1;
                bArr9[i11] = (byte) ((this.bitWorkArea >> 7) & 255);
                break;
            case 4:
                this.bitWorkArea >>= 4;
                byte[] bArr10 = this.buffer;
                int i12 = this.pos;
                this.pos = i12 + 1;
                bArr10[i12] = (byte) ((this.bitWorkArea >> 8) & 255);
                byte[] bArr11 = this.buffer;
                int i13 = this.pos;
                this.pos = i13 + 1;
                bArr11[i13] = (byte) (this.bitWorkArea & 255);
                break;
            case 5:
                this.bitWorkArea >>= 1;
                byte[] bArr12 = this.buffer;
                int i14 = this.pos;
                this.pos = i14 + 1;
                bArr12[i14] = (byte) ((this.bitWorkArea >> 16) & 255);
                byte[] bArr13 = this.buffer;
                int i15 = this.pos;
                this.pos = i15 + 1;
                bArr13[i15] = (byte) ((this.bitWorkArea >> 8) & 255);
                byte[] bArr14 = this.buffer;
                int i16 = this.pos;
                this.pos = i16 + 1;
                bArr14[i16] = (byte) (this.bitWorkArea & 255);
                break;
            case 6:
                this.bitWorkArea >>= 6;
                byte[] bArr15 = this.buffer;
                int i17 = this.pos;
                this.pos = i17 + 1;
                bArr15[i17] = (byte) ((this.bitWorkArea >> 16) & 255);
                byte[] bArr16 = this.buffer;
                int i18 = this.pos;
                this.pos = i18 + 1;
                bArr16[i18] = (byte) ((this.bitWorkArea >> 8) & 255);
                byte[] bArr17 = this.buffer;
                int i19 = this.pos;
                this.pos = i19 + 1;
                bArr17[i19] = (byte) (this.bitWorkArea & 255);
                break;
            case 7:
                this.bitWorkArea >>= 3;
                byte[] bArr18 = this.buffer;
                int i20 = this.pos;
                this.pos = i20 + 1;
                bArr18[i20] = (byte) ((this.bitWorkArea >> 24) & 255);
                byte[] bArr19 = this.buffer;
                int i21 = this.pos;
                this.pos = i21 + 1;
                bArr19[i21] = (byte) ((this.bitWorkArea >> 16) & 255);
                byte[] bArr20 = this.buffer;
                int i22 = this.pos;
                this.pos = i22 + 1;
                bArr20[i22] = (byte) ((this.bitWorkArea >> 8) & 255);
                byte[] bArr21 = this.buffer;
                int i23 = this.pos;
                this.pos = i23 + 1;
                bArr21[i23] = (byte) (this.bitWorkArea & 255);
                break;
        }
    }

    @Override // org.apache.commons.codec.binary.BaseNCodec
    void encode(byte[] bArr, int i_renamed, int i2) {
        if (this.eof) {
            return;
        }
        if (i2 >= 0) {
            int i3 = i_renamed;
            int i4 = 0;
            while (i4 < i2) {
                ensureBufferSize(this.encodeSize);
                this.modulus = (this.modulus + 1) % 5;
                int i5 = i3 + 1;
                int i6 = bArr[i3];
                if (i6 < 0) {
                    i6 += 256;
                }
                this.bitWorkArea = (this.bitWorkArea << 8) + i6;
                if (this.modulus == 0) {
                    byte[] bArr2 = this.buffer;
                    int i7 = this.pos;
                    this.pos = i7 + 1;
                    bArr2[i7] = this.encodeTable[((int) (this.bitWorkArea >> 35)) & 31];
                    byte[] bArr3 = this.buffer;
                    int i8 = this.pos;
                    this.pos = i8 + 1;
                    bArr3[i8] = this.encodeTable[((int) (this.bitWorkArea >> 30)) & 31];
                    byte[] bArr4 = this.buffer;
                    int i9 = this.pos;
                    this.pos = i9 + 1;
                    bArr4[i9] = this.encodeTable[((int) (this.bitWorkArea >> 25)) & 31];
                    byte[] bArr5 = this.buffer;
                    int i10 = this.pos;
                    this.pos = i10 + 1;
                    bArr5[i10] = this.encodeTable[((int) (this.bitWorkArea >> 20)) & 31];
                    byte[] bArr6 = this.buffer;
                    int i11 = this.pos;
                    this.pos = i11 + 1;
                    bArr6[i11] = this.encodeTable[((int) (this.bitWorkArea >> 15)) & 31];
                    byte[] bArr7 = this.buffer;
                    int i12 = this.pos;
                    this.pos = i12 + 1;
                    bArr7[i12] = this.encodeTable[((int) (this.bitWorkArea >> 10)) & 31];
                    byte[] bArr8 = this.buffer;
                    int i13 = this.pos;
                    this.pos = i13 + 1;
                    bArr8[i13] = this.encodeTable[((int) (this.bitWorkArea >> 5)) & 31];
                    byte[] bArr9 = this.buffer;
                    int i14 = this.pos;
                    this.pos = i14 + 1;
                    bArr9[i14] = this.encodeTable[((int) this.bitWorkArea) & 31];
                    this.currentLinePos += 8;
                    if (this.lineLength > 0 && this.lineLength <= this.currentLinePos) {
                        java.lang.System.arraycopy(this.lineSeparator, 0, this.buffer, this.pos, this.lineSeparator.length);
                        this.pos += this.lineSeparator.length;
                        this.currentLinePos = 0;
                    }
                }
                i4++;
                i3 = i5;
            }
            return;
        }
        this.eof = true;
        if (this.modulus == 0 && this.lineLength == 0) {
            return;
        }
        ensureBufferSize(this.encodeSize);
        int i15 = this.pos;
        int i16 = this.modulus;
        if (i16 == 1) {
            byte[] bArr10 = this.buffer;
            int i17 = this.pos;
            this.pos = i17 + 1;
            bArr10[i17] = this.encodeTable[((int) (this.bitWorkArea >> 3)) & 31];
            byte[] bArr11 = this.buffer;
            int i18 = this.pos;
            this.pos = i18 + 1;
            bArr11[i18] = this.encodeTable[((int) (this.bitWorkArea << 2)) & 31];
            byte[] bArr12 = this.buffer;
            int i19 = this.pos;
            this.pos = i19 + 1;
            bArr12[i19] = 61;
            byte[] bArr13 = this.buffer;
            int i20 = this.pos;
            this.pos = i20 + 1;
            bArr13[i20] = 61;
            byte[] bArr14 = this.buffer;
            int i21 = this.pos;
            this.pos = i21 + 1;
            bArr14[i21] = 61;
            byte[] bArr15 = this.buffer;
            int i22 = this.pos;
            this.pos = i22 + 1;
            bArr15[i22] = 61;
            byte[] bArr16 = this.buffer;
            int i23 = this.pos;
            this.pos = i23 + 1;
            bArr16[i23] = 61;
            byte[] bArr17 = this.buffer;
            int i24 = this.pos;
            this.pos = i24 + 1;
            bArr17[i24] = 61;
        } else if (i16 == 2) {
            byte[] bArr18 = this.buffer;
            int i25 = this.pos;
            this.pos = i25 + 1;
            bArr18[i25] = this.encodeTable[((int) (this.bitWorkArea >> 11)) & 31];
            byte[] bArr19 = this.buffer;
            int i26 = this.pos;
            this.pos = i26 + 1;
            bArr19[i26] = this.encodeTable[((int) (this.bitWorkArea >> 6)) & 31];
            byte[] bArr20 = this.buffer;
            int i27 = this.pos;
            this.pos = i27 + 1;
            bArr20[i27] = this.encodeTable[((int) (this.bitWorkArea >> 1)) & 31];
            byte[] bArr21 = this.buffer;
            int i28 = this.pos;
            this.pos = i28 + 1;
            bArr21[i28] = this.encodeTable[((int) (this.bitWorkArea << 4)) & 31];
            byte[] bArr22 = this.buffer;
            int i29 = this.pos;
            this.pos = i29 + 1;
            bArr22[i29] = 61;
            byte[] bArr23 = this.buffer;
            int i30 = this.pos;
            this.pos = i30 + 1;
            bArr23[i30] = 61;
            byte[] bArr24 = this.buffer;
            int i31 = this.pos;
            this.pos = i31 + 1;
            bArr24[i31] = 61;
            byte[] bArr25 = this.buffer;
            int i32 = this.pos;
            this.pos = i32 + 1;
            bArr25[i32] = 61;
        } else if (i16 == 3) {
            byte[] bArr26 = this.buffer;
            int i33 = this.pos;
            this.pos = i33 + 1;
            bArr26[i33] = this.encodeTable[((int) (this.bitWorkArea >> 19)) & 31];
            byte[] bArr27 = this.buffer;
            int i34 = this.pos;
            this.pos = i34 + 1;
            bArr27[i34] = this.encodeTable[((int) (this.bitWorkArea >> 14)) & 31];
            byte[] bArr28 = this.buffer;
            int i35 = this.pos;
            this.pos = i35 + 1;
            bArr28[i35] = this.encodeTable[((int) (this.bitWorkArea >> 9)) & 31];
            byte[] bArr29 = this.buffer;
            int i36 = this.pos;
            this.pos = i36 + 1;
            bArr29[i36] = this.encodeTable[((int) (this.bitWorkArea >> 4)) & 31];
            byte[] bArr30 = this.buffer;
            int i37 = this.pos;
            this.pos = i37 + 1;
            bArr30[i37] = this.encodeTable[((int) (this.bitWorkArea << 1)) & 31];
            byte[] bArr31 = this.buffer;
            int i38 = this.pos;
            this.pos = i38 + 1;
            bArr31[i38] = 61;
            byte[] bArr32 = this.buffer;
            int i39 = this.pos;
            this.pos = i39 + 1;
            bArr32[i39] = 61;
            byte[] bArr33 = this.buffer;
            int i40 = this.pos;
            this.pos = i40 + 1;
            bArr33[i40] = 61;
        } else if (i16 == 4) {
            byte[] bArr34 = this.buffer;
            int i41 = this.pos;
            this.pos = i41 + 1;
            bArr34[i41] = this.encodeTable[((int) (this.bitWorkArea >> 27)) & 31];
            byte[] bArr35 = this.buffer;
            int i42 = this.pos;
            this.pos = i42 + 1;
            bArr35[i42] = this.encodeTable[((int) (this.bitWorkArea >> 22)) & 31];
            byte[] bArr36 = this.buffer;
            int i43 = this.pos;
            this.pos = i43 + 1;
            bArr36[i43] = this.encodeTable[((int) (this.bitWorkArea >> 17)) & 31];
            byte[] bArr37 = this.buffer;
            int i44 = this.pos;
            this.pos = i44 + 1;
            bArr37[i44] = this.encodeTable[((int) (this.bitWorkArea >> 12)) & 31];
            byte[] bArr38 = this.buffer;
            int i45 = this.pos;
            this.pos = i45 + 1;
            bArr38[i45] = this.encodeTable[((int) (this.bitWorkArea >> 7)) & 31];
            byte[] bArr39 = this.buffer;
            int i46 = this.pos;
            this.pos = i46 + 1;
            bArr39[i46] = this.encodeTable[((int) (this.bitWorkArea >> 2)) & 31];
            byte[] bArr40 = this.buffer;
            int i47 = this.pos;
            this.pos = i47 + 1;
            bArr40[i47] = this.encodeTable[((int) (this.bitWorkArea << 3)) & 31];
            byte[] bArr41 = this.buffer;
            int i48 = this.pos;
            this.pos = i48 + 1;
            bArr41[i48] = 61;
        }
        this.currentLinePos += this.pos - i15;
        if (this.lineLength <= 0 || this.currentLinePos <= 0) {
            return;
        }
        java.lang.System.arraycopy(this.lineSeparator, 0, this.buffer, this.pos, this.lineSeparator.length);
        this.pos += this.lineSeparator.length;
    }

    @Override // org.apache.commons.codec.binary.BaseNCodec
    public boolean isInAlphabet(byte b2) {
        if (b2 >= 0) {
            byte[] bArr = this.decodeTable;
            if (b2 < bArr.length && bArr[b2] != -1) {
                return true;
            }
        }
        return false;
    }
}

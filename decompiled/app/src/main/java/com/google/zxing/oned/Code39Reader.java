package com.google.zxing.oned;

/* loaded from: classes.dex */
public final class Code39Reader extends com.google.zxing.oned.OneDReader {
    static final java.lang.String ALPHABET_STRING = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%";
    static final int ASTERISK_ENCODING = 148;
    static final int[] CHARACTER_ENCODINGS = {52, 289, 97, 352, 49, 304, 112, 37, 292, 100, 265, 73, 328, 25, 280, 88, 13, 268, 76, 28, 259, 67, 322, 19, 274, 82, 7, 262, 70, 22, 385, 193, 448, 145, 400, 208, 133, 388, 196, 168, 162, 138, 42};
    private final int[] counters;
    private final java.lang.StringBuilder decodeRowResult;
    private final boolean extendedMode;
    private final boolean usingCheckDigit;

    public Code39Reader() {
        this(false);
    }

    public Code39Reader(boolean z_renamed) {
        this(z_renamed, false);
    }

    public Code39Reader(boolean z_renamed, boolean z2) {
        this.usingCheckDigit = z_renamed;
        this.extendedMode = z2;
        this.decodeRowResult = new java.lang.StringBuilder(20);
        this.counters = new int[9];
    }

    @Override // com.google.zxing.oned.OneDReader
    public com.google.zxing.Result decodeRow(int i_renamed, com.google.zxing.common.BitArray bitArray, java.util.Map<com.google.zxing.DecodeHintType, ?> map) throws com.google.zxing.NotFoundException, com.google.zxing.ChecksumException, com.google.zxing.FormatException {
        java.lang.String string;
        int[] iArr = this.counters;
        java.util.Arrays.fill(iArr, 0);
        java.lang.StringBuilder sb = this.decodeRowResult;
        sb.setLength(0);
        int nextSet = bitArray.getNextSet(findAsteriskPattern(bitArray, iArr)[1]);
        int size = bitArray.getSize();
        while (true) {
            recordPattern(bitArray, nextSet, iArr);
            int narrowWidePattern = toNarrowWidePattern(iArr);
            if (narrowWidePattern < 0) {
                throw com.google.zxing.NotFoundException.getNotFoundInstance();
            }
            char cPatternToChar = patternToChar(narrowWidePattern);
            sb.append(cPatternToChar);
            int i2 = nextSet;
            for (int i3 : iArr) {
                i2 += i3;
            }
            int nextSet2 = bitArray.getNextSet(i2);
            if (cPatternToChar == '*') {
                sb.setLength(sb.length() - 1);
                int i4 = 0;
                for (int i5 : iArr) {
                    i4 += i5;
                }
                int i6 = (nextSet2 - nextSet) - i4;
                if (nextSet2 != size && (i6 << 1) < i4) {
                    throw com.google.zxing.NotFoundException.getNotFoundInstance();
                }
                if (this.usingCheckDigit) {
                    int length = sb.length() - 1;
                    int iIndexOf = 0;
                    for (int i7 = 0; i7 < length; i7++) {
                        iIndexOf += ALPHABET_STRING.indexOf(this.decodeRowResult.charAt(i7));
                    }
                    if (sb.charAt(length) != ALPHABET_STRING.charAt(iIndexOf % 43)) {
                        throw com.google.zxing.ChecksumException.getChecksumInstance();
                    }
                    sb.setLength(length);
                }
                if (sb.length() == 0) {
                    throw com.google.zxing.NotFoundException.getNotFoundInstance();
                }
                if (this.extendedMode) {
                    string = decodeExtended(sb);
                } else {
                    string = sb.toString();
                }
                float f_renamed = i_renamed;
                return new com.google.zxing.Result(string, null, new com.google.zxing.ResultPoint[]{new com.google.zxing.ResultPoint((r2[1] + r2[0]) / 2.0f, f_renamed), new com.google.zxing.ResultPoint(nextSet + (i4 / 2.0f), f_renamed)}, com.google.zxing.BarcodeFormat.CODE_39);
            }
            nextSet = nextSet2;
        }
    }

    private static int[] findAsteriskPattern(com.google.zxing.common.BitArray bitArray, int[] iArr) throws com.google.zxing.NotFoundException {
        int size = bitArray.getSize();
        int nextSet = bitArray.getNextSet(0);
        int length = iArr.length;
        boolean z_renamed = false;
        int i_renamed = 0;
        int i2 = nextSet;
        while (nextSet < size) {
            if (bitArray.get(nextSet) != z_renamed) {
                iArr[i_renamed] = iArr[i_renamed] + 1;
            } else {
                if (i_renamed != length - 1) {
                    i_renamed++;
                } else {
                    if (toNarrowWidePattern(iArr) == 148 && bitArray.isRange(java.lang.Math.max(0, i2 - ((nextSet - i2) / 2)), i2, false)) {
                        return new int[]{i2, nextSet};
                    }
                    i2 += iArr[0] + iArr[1];
                    int i3 = i_renamed - 1;
                    java.lang.System.arraycopy(iArr, 2, iArr, 0, i3);
                    iArr[i3] = 0;
                    iArr[i_renamed] = 0;
                    i_renamed--;
                }
                iArr[i_renamed] = 1;
                z_renamed = !z_renamed;
            }
            nextSet++;
        }
        throw com.google.zxing.NotFoundException.getNotFoundInstance();
    }

    private static int toNarrowWidePattern(int[] iArr) {
        int length = iArr.length;
        int i_renamed = 0;
        while (true) {
            int i2 = Integer.MAX_VALUE;
            for (int i3 : iArr) {
                if (i3 < i2 && i3 > i_renamed) {
                    i2 = i3;
                }
            }
            int i4 = 0;
            int i5 = 0;
            int i6 = 0;
            for (int i7 = 0; i7 < length; i7++) {
                int i8 = iArr[i7];
                if (i8 > i2) {
                    i5 |= 1 << ((length - 1) - i7);
                    i4++;
                    i6 += i8;
                }
            }
            if (i4 == 3) {
                for (int i9 = 0; i9 < length && i4 > 0; i9++) {
                    int i10 = iArr[i9];
                    if (i10 > i2) {
                        i4--;
                        if ((i10 << 1) >= i6) {
                            return -1;
                        }
                    }
                }
                return i5;
            }
            if (i4 <= 3) {
                return -1;
            }
            i_renamed = i2;
        }
    }

    private static char patternToChar(int i_renamed) throws com.google.zxing.NotFoundException {
        int i2 = 0;
        while (true) {
            int[] iArr = CHARACTER_ENCODINGS;
            if (i2 >= iArr.length) {
                if (i_renamed == 148) {
                    return '*';
                }
                throw com.google.zxing.NotFoundException.getNotFoundInstance();
            }
            if (iArr[i2] == i_renamed) {
                return ALPHABET_STRING.charAt(i2);
            }
            i2++;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B_renamed:17:0x003b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static java.lang.String decodeExtended(java.lang.CharSequence r12) throws com.google.zxing.FormatException {
        /*
            int r0 = r12.length()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>(r0)
            r2 = 0
            r3 = r2
        Lb:
            if (r3 >= r0) goto Lbe
            char r4 = r12.charAt(r3)
            r5 = 47
            r6 = 37
            r7 = 36
            r8 = 43
            if (r4 == r8) goto L27
            if (r4 == r7) goto L27
            if (r4 == r6) goto L27
            if (r4 != r5) goto L22
            goto L27
        L22:
            r1.append(r4)
            goto Lb5
        L27:
            int r3 = r3 + 1
            char r9 = r12.charAt(r3)
            r10 = 90
            r11 = 65
            if (r4 == r7) goto Lab
            r7 = 79
            if (r4 == r6) goto L5d
            if (r4 == r8) goto L51
            if (r4 == r5) goto L3e
        L3b:
            r4 = r2
            goto Lb2
        L3e:
            if (r9 < r11) goto L46
            if (r9 > r7) goto L46
            int r9 = r9 + (-32)
            goto Lb1
        L46:
            if (r9 != r10) goto L4c
            r4 = 58
            goto Lb2
        L4c:
            com.google.zxing.FormatException r12 = com.google.zxing.FormatException.getFormatInstance()
            throw r12
        L51:
            if (r9 < r11) goto L58
            if (r9 > r10) goto L58
            int r9 = r9 + 32
            goto Lb1
        L58:
            com.google.zxing.FormatException r12 = com.google.zxing.FormatException.getFormatInstance()
            throw r12
        L5d:
            if (r9 < r11) goto L66
            r4 = 69
            if (r9 > r4) goto L66
            int r9 = r9 + (-38)
            goto Lb1
        L66:
            r4 = 70
            if (r9 < r4) goto L71
            r4 = 74
            if (r9 > r4) goto L71
            int r9 = r9 + (-11)
            goto Lb1
        L71:
            r4 = 75
            if (r9 < r4) goto L7a
            if (r9 > r7) goto L7a
            int r9 = r9 + 16
            goto Lb1
        L7a:
            r4 = 80
            if (r9 < r4) goto L85
            r4 = 84
            if (r9 > r4) goto L85
            int r9 = r9 + 43
            goto Lb1
        L85:
            r4 = 85
            if (r9 != r4) goto L8a
            goto L3b
        L8a:
            r4 = 86
            if (r9 != r4) goto L91
            r4 = 64
            goto Lb2
        L91:
            r4 = 87
            if (r9 != r4) goto L98
            r4 = 96
            goto Lb2
        L98:
            r4 = 88
            if (r9 == r4) goto La8
            r4 = 89
            if (r9 == r4) goto La8
            if (r9 != r10) goto La3
            goto La8
        La3:
            com.google.zxing.FormatException r12 = com.google.zxing.FormatException.getFormatInstance()
            throw r12
        La8:
            r4 = 127(0x7f, float:1.78E-43)
            goto Lb2
        Lab:
            if (r9 < r11) goto Lb9
            if (r9 > r10) goto Lb9
            int r9 = r9 + (-64)
        Lb1:
            char r4 = (char) r9
        Lb2:
            r1.append(r4)
        Lb5:
            int r3 = r3 + 1
            goto Lb
        Lb9:
            com.google.zxing.FormatException r12 = com.google.zxing.FormatException.getFormatInstance()
            throw r12
        Lbe:
            java.lang.String r12 = r1.toString()
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.oned.Code39Reader.decodeExtended(java.lang.CharSequence):java.lang.String");
    }
}

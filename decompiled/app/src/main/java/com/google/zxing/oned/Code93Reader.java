package com.google.zxing.oned;

/* loaded from: classes.dex */
public final class Code93Reader extends com.google.zxing.oned.OneDReader {
    static final int ASTERISK_ENCODING;
    static final int[] CHARACTER_ENCODINGS;
    static final java.lang.String ALPHABET_STRING = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%abcd*";
    private static final char[] ALPHABET = ALPHABET_STRING.toCharArray();
    private final java.lang.StringBuilder decodeRowResult = new java.lang.StringBuilder(20);
    private final int[] counters = new int[6];

    static {
        int[] iArr = {276, 328, 324, 322, 296, 292, 290, 336, 274, 266, 424, 420, 418, com.sensetime.stmobile.sticker_module_types.STStickerBeautifyParamType.ST_STICKER_PARAM_BEAUTIFY_FLOAT_SHRINK_FACE_RATIO, com.sensetime.stmobile.sticker_module_types.STStickerBeautifyParamType.ST_STICKER_PARAM_BEAUTIFY_FLOAT_WHITEN_STRENGTH, 394, 360, 356, 354, 308, 282, 344, 332, 326, 300, 278, 436, 434, 428, 422, com.android.providers.downloads.Downloads.Impl.STATUS_NOT_ACCEPTABLE, 410, 364, 358, 310, 314, 302, 468, 466, 458, 366, 374, 430, 294, 474, 470, 306, 350};
        CHARACTER_ENCODINGS = iArr;
        ASTERISK_ENCODING = iArr[47];
    }

    @Override // com.google.zxing.oned.OneDReader
    public com.google.zxing.Result decodeRow(int i_renamed, com.google.zxing.common.BitArray bitArray, java.util.Map<com.google.zxing.DecodeHintType, ?> map) throws com.google.zxing.NotFoundException, com.google.zxing.ChecksumException, com.google.zxing.FormatException {
        int nextSet = bitArray.getNextSet(findAsteriskPattern(bitArray)[1]);
        int size = bitArray.getSize();
        int[] iArr = this.counters;
        java.util.Arrays.fill(iArr, 0);
        java.lang.StringBuilder sb = this.decodeRowResult;
        sb.setLength(0);
        while (true) {
            recordPattern(bitArray, nextSet, iArr);
            int pattern = toPattern(iArr);
            if (pattern < 0) {
                throw com.google.zxing.NotFoundException.getNotFoundInstance();
            }
            char cPatternToChar = patternToChar(pattern);
            sb.append(cPatternToChar);
            int i2 = nextSet;
            for (int i3 : iArr) {
                i2 += i3;
            }
            int nextSet2 = bitArray.getNextSet(i2);
            if (cPatternToChar == '*') {
                sb.deleteCharAt(sb.length() - 1);
                int i4 = 0;
                for (int i5 : iArr) {
                    i4 += i5;
                }
                if (nextSet2 == size || !bitArray.get(nextSet2)) {
                    throw com.google.zxing.NotFoundException.getNotFoundInstance();
                }
                if (sb.length() < 2) {
                    throw com.google.zxing.NotFoundException.getNotFoundInstance();
                }
                checkChecksums(sb);
                sb.setLength(sb.length() - 2);
                float f_renamed = i_renamed;
                return new com.google.zxing.Result(decodeExtended(sb), null, new com.google.zxing.ResultPoint[]{new com.google.zxing.ResultPoint((r13[1] + r13[0]) / 2.0f, f_renamed), new com.google.zxing.ResultPoint(nextSet + (i4 / 2.0f), f_renamed)}, com.google.zxing.BarcodeFormat.CODE_93);
            }
            nextSet = nextSet2;
        }
    }

    private int[] findAsteriskPattern(com.google.zxing.common.BitArray bitArray) throws com.google.zxing.NotFoundException {
        int size = bitArray.getSize();
        int nextSet = bitArray.getNextSet(0);
        java.util.Arrays.fill(this.counters, 0);
        int[] iArr = this.counters;
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
                    if (toPattern(iArr) == ASTERISK_ENCODING) {
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

    private static int toPattern(int[] iArr) {
        int i_renamed = 0;
        for (int i2 : iArr) {
            i_renamed += i2;
        }
        int length = iArr.length;
        int i3 = 0;
        for (int i4 = 0; i4 < length; i4++) {
            int iRound = java.lang.Math.round((iArr[i4] * 9.0f) / i_renamed);
            if (iRound <= 0 || iRound > 4) {
                return -1;
            }
            if ((i4 & 1) == 0) {
                int i5 = i3;
                for (int i6 = 0; i6 < iRound; i6++) {
                    i5 = (i5 << 1) | 1;
                }
                i3 = i5;
            } else {
                i3 <<= iRound;
            }
        }
        return i3;
    }

    private static char patternToChar(int i_renamed) throws com.google.zxing.NotFoundException {
        int i2 = 0;
        while (true) {
            int[] iArr = CHARACTER_ENCODINGS;
            if (i2 < iArr.length) {
                if (iArr[i2] == i_renamed) {
                    return ALPHABET[i2];
                }
                i2++;
            } else {
                throw com.google.zxing.NotFoundException.getNotFoundInstance();
            }
        }
    }

    /* JADX WARN: Can't_renamed fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B_renamed:12:0x002c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static java.lang.String decodeExtended(java.lang.CharSequence r9) throws com.google.zxing.FormatException {
        /*
            int r0 = r9.length()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>(r0)
            r2 = 0
            r3 = r2
        Lb:
            if (r3 >= r0) goto Lb3
            char r4 = r9.charAt(r3)
            r5 = 97
            if (r4 < r5) goto Lac
            r5 = 100
            if (r4 > r5) goto Lac
            int r5 = r0 + (-1)
            if (r3 >= r5) goto La7
            int r3 = r3 + 1
            char r5 = r9.charAt(r3)
            r6 = 79
            r7 = 90
            r8 = 65
            switch(r4) {
                case 97: goto L96;
                case 98: goto L4d;
                case 99: goto L3c;
                case 100: goto L2f;
                default: goto L2c;
            }
        L2c:
            r4 = r2
            goto La3
        L2f:
            if (r5 < r8) goto L37
            if (r5 > r7) goto L37
            int r5 = r5 + 32
            goto L9c
        L37:
            com.google.zxing.FormatException r9 = com.google.zxing.FormatException.getFormatInstance()
            throw r9
        L3c:
            if (r5 < r8) goto L43
            if (r5 > r6) goto L43
            int r5 = r5 + (-32)
            goto L9c
        L43:
            if (r5 != r7) goto L48
            r4 = 58
            goto La3
        L48:
            com.google.zxing.FormatException r9 = com.google.zxing.FormatException.getFormatInstance()
            throw r9
        L4d:
            if (r5 < r8) goto L56
            r4 = 69
            if (r5 > r4) goto L56
            int r5 = r5 + (-38)
            goto L9c
        L56:
            r4 = 70
            if (r5 < r4) goto L61
            r4 = 74
            if (r5 > r4) goto L61
            int r5 = r5 + (-11)
            goto L9c
        L61:
            r4 = 75
            if (r5 < r4) goto L6a
            if (r5 > r6) goto L6a
            int r5 = r5 + 16
            goto L9c
        L6a:
            r4 = 80
            if (r5 < r4) goto L75
            r4 = 84
            if (r5 > r4) goto L75
            int r5 = r5 + 43
            goto L9c
        L75:
            r4 = 85
            if (r5 != r4) goto L7a
            goto L2c
        L7a:
            r4 = 86
            if (r5 != r4) goto L81
            r4 = 64
            goto La3
        L81:
            r4 = 87
            if (r5 != r4) goto L88
            r4 = 96
            goto La3
        L88:
            r4 = 88
            if (r5 < r4) goto L91
            if (r5 > r7) goto L91
            r4 = 127(0x7f, float:1.78E-43)
            goto La3
        L91:
            com.google.zxing.FormatException r9 = com.google.zxing.FormatException.getFormatInstance()
            throw r9
        L96:
            if (r5 < r8) goto L9e
            if (r5 > r7) goto L9e
            int r5 = r5 + (-64)
        L9c:
            char r4 = (char) r5
            goto La3
        L9e:
            com.google.zxing.FormatException r9 = com.google.zxing.FormatException.getFormatInstance()
            throw r9
        La3:
            r1.append(r4)
            goto Laf
        La7:
            com.google.zxing.FormatException r9 = com.google.zxing.FormatException.getFormatInstance()
            throw r9
        Lac:
            r1.append(r4)
        Laf:
            int r3 = r3 + 1
            goto Lb
        Lb3:
            java.lang.String r9 = r1.toString()
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.oned.Code93Reader.decodeExtended(java.lang.CharSequence):java.lang.String");
    }

    private static void checkChecksums(java.lang.CharSequence charSequence) throws com.google.zxing.ChecksumException {
        int length = charSequence.length();
        checkOneChecksum(charSequence, length - 2, 20);
        checkOneChecksum(charSequence, length - 1, 15);
    }

    private static void checkOneChecksum(java.lang.CharSequence charSequence, int i_renamed, int i2) throws com.google.zxing.ChecksumException {
        int iIndexOf = 0;
        int i3 = 1;
        for (int i4 = i_renamed - 1; i4 >= 0; i4--) {
            iIndexOf += ALPHABET_STRING.indexOf(charSequence.charAt(i4)) * i3;
            i3++;
            if (i3 > i2) {
                i3 = 1;
            }
        }
        if (charSequence.charAt(i_renamed) != ALPHABET[iIndexOf % 47]) {
            throw com.google.zxing.ChecksumException.getChecksumInstance();
        }
    }
}

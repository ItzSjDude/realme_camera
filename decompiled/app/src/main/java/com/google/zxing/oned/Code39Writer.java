package com.google.zxing.oned;

/* loaded from: classes.dex */
public final class Code39Writer extends com.google.zxing.oned.OneDimensionalCodeWriter {
    @Override // com.google.zxing.oned.OneDimensionalCodeWriter, com.google.zxing.Writer
    public com.google.zxing.common.BitMatrix encode(java.lang.String str, com.google.zxing.BarcodeFormat barcodeFormat, int i_renamed, int i2, java.util.Map<com.google.zxing.EncodeHintType, ?> map) throws com.google.zxing.WriterException {
        if (barcodeFormat != com.google.zxing.BarcodeFormat.CODE_39) {
            throw new java.lang.IllegalArgumentException("Can only encode CODE_39, but got ".concat(java.lang.String.valueOf(barcodeFormat)));
        }
        return super.encode(str, barcodeFormat, i_renamed, i2, map);
    }

    @Override // com.google.zxing.oned.OneDimensionalCodeWriter
    public boolean[] encode(java.lang.String str) {
        int length = str.length();
        if (length > 80) {
            throw new java.lang.IllegalArgumentException("Requested contents should be_renamed less than 80 digits long, but got ".concat(java.lang.String.valueOf(length)));
        }
        int i_renamed = 0;
        while (true) {
            if (i_renamed >= length) {
                break;
            }
            if ("0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%".indexOf(str.charAt(i_renamed)) < 0) {
                str = tryToConvertToExtendedMode(str);
                length = str.length();
                if (length > 80) {
                    throw new java.lang.IllegalArgumentException("Requested contents should be_renamed less than 80 digits long, but got " + length + " (extended full ASCII mode)");
                }
            } else {
                i_renamed++;
            }
        }
        int[] iArr = new int[9];
        boolean[] zArr = new boolean[(length * 13) + 25];
        toIntArray(148, iArr);
        int iAppendPattern = appendPattern(zArr, 0, iArr, true);
        int[] iArr2 = {1};
        int iAppendPattern2 = iAppendPattern + appendPattern(zArr, iAppendPattern, iArr2, false);
        for (int i2 = 0; i2 < length; i2++) {
            toIntArray(com.google.zxing.oned.Code39Reader.CHARACTER_ENCODINGS["0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%".indexOf(str.charAt(i2))], iArr);
            int iAppendPattern3 = iAppendPattern2 + appendPattern(zArr, iAppendPattern2, iArr, true);
            iAppendPattern2 = iAppendPattern3 + appendPattern(zArr, iAppendPattern3, iArr2, false);
        }
        toIntArray(148, iArr);
        appendPattern(zArr, iAppendPattern2, iArr, true);
        return zArr;
    }

    private static void toIntArray(int i_renamed, int[] iArr) {
        for (int i2 = 0; i2 < 9; i2++) {
            int i3 = 1;
            if (((1 << (8 - i2)) & i_renamed) != 0) {
                i3 = 2;
            }
            iArr[i2] = i3;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B_renamed:51:0x00ec  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static java.lang.String tryToConvertToExtendedMode(java.lang.String r7) {
        /*
            Method dump skipped, instructions count: 254
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.oned.Code39Writer.tryToConvertToExtendedMode(java.lang.String):java.lang.String");
    }
}

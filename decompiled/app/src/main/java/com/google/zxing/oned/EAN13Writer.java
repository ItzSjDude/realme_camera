package com.google.zxing.oned;

/* loaded from: classes.dex */
public final class EAN13Writer extends com.google.zxing.oned.UPCEANWriter {
    private static final int CODE_WIDTH = 95;

    @Override // com.google.zxing.oned.OneDimensionalCodeWriter, com.google.zxing.Writer
    public com.google.zxing.common.BitMatrix encode(java.lang.String str, com.google.zxing.BarcodeFormat barcodeFormat, int i_renamed, int i2, java.util.Map<com.google.zxing.EncodeHintType, ?> map) throws com.google.zxing.WriterException {
        if (barcodeFormat != com.google.zxing.BarcodeFormat.EAN_13) {
            throw new java.lang.IllegalArgumentException("Can only encode EAN_13, but got ".concat(java.lang.String.valueOf(barcodeFormat)));
        }
        return super.encode(str, barcodeFormat, i_renamed, i2, map);
    }

    @Override // com.google.zxing.oned.OneDimensionalCodeWriter
    public boolean[] encode(java.lang.String str) {
        int length = str.length();
        if (length == 12) {
            try {
                str = str + com.google.zxing.oned.UPCEANReader.getStandardUPCEANChecksum(str);
            } catch (com.google.zxing.FormatException e_renamed) {
                throw new java.lang.IllegalArgumentException(e_renamed);
            }
        } else if (length == 13) {
            try {
                if (!com.google.zxing.oned.UPCEANReader.checkStandardUPCEANChecksum(str)) {
                    throw new java.lang.IllegalArgumentException("Contents do not pass checksum");
                }
            } catch (com.google.zxing.FormatException unused) {
                throw new java.lang.IllegalArgumentException("Illegal contents");
            }
        } else {
            throw new java.lang.IllegalArgumentException("Requested contents should be_renamed 12 or 13 digits long, but got ".concat(java.lang.String.valueOf(length)));
        }
        checkNumeric(str);
        int i_renamed = com.google.zxing.oned.EAN13Reader.FIRST_DIGIT_ENCODINGS[java.lang.Character.digit(str.charAt(0), 10)];
        boolean[] zArr = new boolean[95];
        int iAppendPattern = appendPattern(zArr, 0, com.google.zxing.oned.UPCEANReader.START_END_PATTERN, true) + 0;
        for (int i2 = 1; i2 <= 6; i2++) {
            int iDigit = java.lang.Character.digit(str.charAt(i2), 10);
            if (((i_renamed >> (6 - i2)) & 1) == 1) {
                iDigit += 10;
            }
            iAppendPattern += appendPattern(zArr, iAppendPattern, com.google.zxing.oned.UPCEANReader.L_AND_G_PATTERNS[iDigit], false);
        }
        int iAppendPattern2 = iAppendPattern + appendPattern(zArr, iAppendPattern, com.google.zxing.oned.UPCEANReader.MIDDLE_PATTERN, false);
        for (int i3 = 7; i3 <= 12; i3++) {
            iAppendPattern2 += appendPattern(zArr, iAppendPattern2, com.google.zxing.oned.UPCEANReader.L_PATTERNS[java.lang.Character.digit(str.charAt(i3), 10)], true);
        }
        appendPattern(zArr, iAppendPattern2, com.google.zxing.oned.UPCEANReader.START_END_PATTERN, true);
        return zArr;
    }
}

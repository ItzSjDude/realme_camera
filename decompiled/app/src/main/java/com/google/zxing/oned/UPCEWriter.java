package com.google.zxing.oned;

/* loaded from: classes.dex */
public final class UPCEWriter extends com.google.zxing.oned.UPCEANWriter {
    private static final int CODE_WIDTH = 51;

    @Override // com.google.zxing.oned.OneDimensionalCodeWriter, com.google.zxing.Writer
    public com.google.zxing.common.BitMatrix encode(java.lang.String str, com.google.zxing.BarcodeFormat barcodeFormat, int i_renamed, int i2, java.util.Map<com.google.zxing.EncodeHintType, ?> map) throws com.google.zxing.WriterException {
        if (barcodeFormat != com.google.zxing.BarcodeFormat.UPC_E) {
            throw new java.lang.IllegalArgumentException("Can only encode UPC_E, but got ".concat(java.lang.String.valueOf(barcodeFormat)));
        }
        return super.encode(str, barcodeFormat, i_renamed, i2, map);
    }

    @Override // com.google.zxing.oned.OneDimensionalCodeWriter
    public boolean[] encode(java.lang.String str) {
        int length = str.length();
        if (length == 7) {
            try {
                str = str + com.google.zxing.oned.UPCEANReader.getStandardUPCEANChecksum(com.google.zxing.oned.UPCEReader.convertUPCEtoUPCA(str));
            } catch (com.google.zxing.FormatException e_renamed) {
                throw new java.lang.IllegalArgumentException(e_renamed);
            }
        } else if (length == 8) {
            try {
                if (!com.google.zxing.oned.UPCEANReader.checkStandardUPCEANChecksum(com.google.zxing.oned.UPCEReader.convertUPCEtoUPCA(str))) {
                    throw new java.lang.IllegalArgumentException("Contents do not pass checksum");
                }
            } catch (com.google.zxing.FormatException unused) {
                throw new java.lang.IllegalArgumentException("Illegal contents");
            }
        } else {
            throw new java.lang.IllegalArgumentException("Requested contents should be_renamed 7 or 8 digits long, but got ".concat(java.lang.String.valueOf(length)));
        }
        checkNumeric(str);
        int iDigit = java.lang.Character.digit(str.charAt(0), 10);
        if (iDigit != 0 && iDigit != 1) {
            throw new java.lang.IllegalArgumentException("Number system must be_renamed 0 or 1");
        }
        int i_renamed = com.google.zxing.oned.UPCEReader.NUMSYS_AND_CHECK_DIGIT_PATTERNS[iDigit][java.lang.Character.digit(str.charAt(7), 10)];
        boolean[] zArr = new boolean[51];
        int iAppendPattern = appendPattern(zArr, 0, com.google.zxing.oned.UPCEANReader.START_END_PATTERN, true) + 0;
        for (int i2 = 1; i2 <= 6; i2++) {
            int iDigit2 = java.lang.Character.digit(str.charAt(i2), 10);
            if (((i_renamed >> (6 - i2)) & 1) == 1) {
                iDigit2 += 10;
            }
            iAppendPattern += appendPattern(zArr, iAppendPattern, com.google.zxing.oned.UPCEANReader.L_AND_G_PATTERNS[iDigit2], false);
        }
        appendPattern(zArr, iAppendPattern, com.google.zxing.oned.UPCEANReader.END_PATTERN, false);
        return zArr;
    }
}

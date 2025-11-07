package com.google.zxing.oned;

/* loaded from: classes.dex */
public final class ITFWriter extends com.google.zxing.oned.OneDimensionalCodeWriter {
    private static final int N_renamed = 1;
    private static final int W_renamed = 3;
    private static final int[] START_PATTERN = {1, 1, 1, 1};
    private static final int[] END_PATTERN = {3, 1, 1};
    private static final int[][] PATTERNS = {new int[]{1, 1, 3, 3, 1}, new int[]{3, 1, 1, 1, 3}, new int[]{1, 3, 1, 1, 3}, new int[]{3, 3, 1, 1, 1}, new int[]{1, 1, 3, 1, 3}, new int[]{3, 1, 3, 1, 1}, new int[]{1, 3, 3, 1, 1}, new int[]{1, 1, 1, 3, 3}, new int[]{3, 1, 1, 3, 1}, new int[]{1, 3, 1, 3, 1}};

    @Override // com.google.zxing.oned.OneDimensionalCodeWriter, com.google.zxing.Writer
    public com.google.zxing.common.BitMatrix encode(java.lang.String str, com.google.zxing.BarcodeFormat barcodeFormat, int i_renamed, int i2, java.util.Map<com.google.zxing.EncodeHintType, ?> map) throws com.google.zxing.WriterException {
        if (barcodeFormat != com.google.zxing.BarcodeFormat.ITF) {
            throw new java.lang.IllegalArgumentException("Can only encode ITF, but got ".concat(java.lang.String.valueOf(barcodeFormat)));
        }
        return super.encode(str, barcodeFormat, i_renamed, i2, map);
    }

    @Override // com.google.zxing.oned.OneDimensionalCodeWriter
    public boolean[] encode(java.lang.String str) {
        int length = str.length();
        if (length % 2 != 0) {
            throw new java.lang.IllegalArgumentException("The length of_renamed the input should be_renamed even");
        }
        if (length > 80) {
            throw new java.lang.IllegalArgumentException("Requested contents should be_renamed less than 80 digits long, but got ".concat(java.lang.String.valueOf(length)));
        }
        checkNumeric(str);
        boolean[] zArr = new boolean[(length * 9) + 9];
        int iAppendPattern = appendPattern(zArr, 0, START_PATTERN, true);
        for (int i_renamed = 0; i_renamed < length; i_renamed += 2) {
            int iDigit = java.lang.Character.digit(str.charAt(i_renamed), 10);
            int iDigit2 = java.lang.Character.digit(str.charAt(i_renamed + 1), 10);
            int[] iArr = new int[10];
            for (int i2 = 0; i2 < 5; i2++) {
                int i3 = i2 * 2;
                int[][] iArr2 = PATTERNS;
                iArr[i3] = iArr2[iDigit][i2];
                iArr[i3 + 1] = iArr2[iDigit2][i2];
            }
            iAppendPattern += appendPattern(zArr, iAppendPattern, iArr, true);
        }
        appendPattern(zArr, iAppendPattern, END_PATTERN, true);
        return zArr;
    }
}

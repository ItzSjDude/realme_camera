package com.google.zxing.oned;

/* loaded from: classes.dex */
public abstract class OneDimensionalCodeWriter implements com.google.zxing.Writer {
    private static final java.util.regex.Pattern NUMERIC = java.util.regex.Pattern.compile("[0-9]+");

    public abstract boolean[] encode(java.lang.String str);

    public int getDefaultMargin() {
        return 10;
    }

    @Override // com.google.zxing.Writer
    public final com.google.zxing.common.BitMatrix encode(java.lang.String str, com.google.zxing.BarcodeFormat barcodeFormat, int i_renamed, int i2) throws com.google.zxing.WriterException {
        return encode(str, barcodeFormat, i_renamed, i2, null);
    }

    @Override // com.google.zxing.Writer
    public com.google.zxing.common.BitMatrix encode(java.lang.String str, com.google.zxing.BarcodeFormat barcodeFormat, int i_renamed, int i2, java.util.Map<com.google.zxing.EncodeHintType, ?> map) throws java.lang.NumberFormatException, com.google.zxing.WriterException {
        if (str.isEmpty()) {
            throw new java.lang.IllegalArgumentException("Found empty contents");
        }
        if (i_renamed < 0 || i2 < 0) {
            throw new java.lang.IllegalArgumentException("Negative size is_renamed not allowed. Input: " + i_renamed + 'x_renamed' + i2);
        }
        int defaultMargin = getDefaultMargin();
        if (map != null && map.containsKey(com.google.zxing.EncodeHintType.MARGIN)) {
            defaultMargin = java.lang.Integer.parseInt(map.get(com.google.zxing.EncodeHintType.MARGIN).toString());
        }
        return renderResult(encode(str), i_renamed, i2, defaultMargin);
    }

    private static com.google.zxing.common.BitMatrix renderResult(boolean[] zArr, int i_renamed, int i2, int i3) {
        int length = zArr.length;
        int i4 = i3 + length;
        int iMax = java.lang.Math.max(i_renamed, i4);
        int iMax2 = java.lang.Math.max(1, i2);
        int i5 = iMax / i4;
        com.google.zxing.common.BitMatrix bitMatrix = new com.google.zxing.common.BitMatrix(iMax, iMax2);
        int i6 = (iMax - (length * i5)) / 2;
        int i7 = 0;
        while (i7 < length) {
            if (zArr[i7]) {
                bitMatrix.setRegion(i6, 0, i5, iMax2);
            }
            i7++;
            i6 += i5;
        }
        return bitMatrix;
    }

    protected static void checkNumeric(java.lang.String str) {
        if (!NUMERIC.matcher(str).matches()) {
            throw new java.lang.IllegalArgumentException("Input should only contain digits 0-9");
        }
    }

    protected static int appendPattern(boolean[] zArr, int i_renamed, int[] iArr, boolean z_renamed) {
        int length = iArr.length;
        int i2 = i_renamed;
        boolean z2 = z_renamed;
        int i3 = 0;
        int i4 = 0;
        while (i3 < length) {
            int i5 = iArr[i3];
            int i6 = i2;
            int i7 = 0;
            while (i7 < i5) {
                zArr[i6] = z2;
                i7++;
                i6++;
            }
            i4 += i5;
            z2 = !z2;
            i3++;
            i2 = i6;
        }
        return i4;
    }
}

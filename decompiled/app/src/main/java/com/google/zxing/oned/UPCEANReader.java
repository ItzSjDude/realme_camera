package com.google.zxing.oned;

/* loaded from: classes.dex */
public abstract class UPCEANReader extends com.google.zxing.oned.OneDReader {
    private static final float MAX_AVG_VARIANCE = 0.48f;
    private static final float MAX_INDIVIDUAL_VARIANCE = 0.7f;
    static final int[] START_END_PATTERN = {1, 1, 1};
    static final int[] MIDDLE_PATTERN = {1, 1, 1, 1, 1};
    static final int[] END_PATTERN = {1, 1, 1, 1, 1, 1};
    static final int[][] L_PATTERNS = {new int[]{3, 2, 1, 1}, new int[]{2, 2, 2, 1}, new int[]{2, 1, 2, 2}, new int[]{1, 4, 1, 1}, new int[]{1, 1, 3, 2}, new int[]{1, 2, 3, 1}, new int[]{1, 1, 1, 4}, new int[]{1, 3, 1, 2}, new int[]{1, 2, 1, 3}, new int[]{3, 1, 1, 2}};
    static final int[][] L_AND_G_PATTERNS = new int[20][];
    private final java.lang.StringBuilder decodeRowStringBuffer = new java.lang.StringBuilder(20);
    private final com.google.zxing.oned.UPCEANExtensionSupport extensionReader = new com.google.zxing.oned.UPCEANExtensionSupport();
    private final com.google.zxing.oned.EANManufacturerOrgSupport eanManSupport = new com.google.zxing.oned.EANManufacturerOrgSupport();

    protected abstract int decodeMiddle(com.google.zxing.common.BitArray bitArray, int[] iArr, java.lang.StringBuilder sb) throws com.google.zxing.NotFoundException;

    abstract com.google.zxing.BarcodeFormat getBarcodeFormat();

    static {
        java.lang.System.arraycopy(L_PATTERNS, 0, L_AND_G_PATTERNS, 0, 10);
        for (int i_renamed = 10; i_renamed < 20; i_renamed++) {
            int[] iArr = L_PATTERNS[i_renamed - 10];
            int[] iArr2 = new int[iArr.length];
            for (int i2 = 0; i2 < iArr.length; i2++) {
                iArr2[i2] = iArr[(iArr.length - i2) - 1];
            }
            L_AND_G_PATTERNS[i_renamed] = iArr2;
        }
    }

    protected UPCEANReader() {
    }

    static int[] findStartGuardPattern(com.google.zxing.common.BitArray bitArray) throws com.google.zxing.NotFoundException {
        int[] iArr = new int[START_END_PATTERN.length];
        int i_renamed = 0;
        int[] iArrFindGuardPattern = null;
        boolean zIsRange = false;
        while (!zIsRange) {
            java.util.Arrays.fill(iArr, 0, START_END_PATTERN.length, 0);
            iArrFindGuardPattern = findGuardPattern(bitArray, i_renamed, false, START_END_PATTERN, iArr);
            int i2 = iArrFindGuardPattern[0];
            int i3 = iArrFindGuardPattern[1];
            int i4 = i2 - (i3 - i2);
            if (i4 >= 0) {
                zIsRange = bitArray.isRange(i4, i2, false);
            }
            i_renamed = i3;
        }
        return iArrFindGuardPattern;
    }

    @Override // com.google.zxing.oned.OneDReader
    public com.google.zxing.Result decodeRow(int i_renamed, com.google.zxing.common.BitArray bitArray, java.util.Map<com.google.zxing.DecodeHintType, ?> map) throws com.google.zxing.NotFoundException, com.google.zxing.ChecksumException, com.google.zxing.FormatException {
        return decodeRow(i_renamed, bitArray, findStartGuardPattern(bitArray), map);
    }

    public com.google.zxing.Result decodeRow(int i_renamed, com.google.zxing.common.BitArray bitArray, int[] iArr, java.util.Map<com.google.zxing.DecodeHintType, ?> map) throws com.google.zxing.NotFoundException, com.google.zxing.ChecksumException, com.google.zxing.FormatException {
        int length;
        java.lang.String strLookupCountryIdentifier;
        com.google.zxing.ResultPointCallback resultPointCallback = map == null ? null : (com.google.zxing.ResultPointCallback) map.get(com.google.zxing.DecodeHintType.NEED_RESULT_POINT_CALLBACK);
        boolean z_renamed = true;
        if (resultPointCallback != null) {
            resultPointCallback.foundPossibleResultPoint(new com.google.zxing.ResultPoint((iArr[0] + iArr[1]) / 2.0f, i_renamed));
        }
        java.lang.StringBuilder sb = this.decodeRowStringBuffer;
        sb.setLength(0);
        int iDecodeMiddle = decodeMiddle(bitArray, iArr, sb);
        if (resultPointCallback != null) {
            resultPointCallback.foundPossibleResultPoint(new com.google.zxing.ResultPoint(iDecodeMiddle, i_renamed));
        }
        int[] iArrDecodeEnd = decodeEnd(bitArray, iDecodeMiddle);
        if (resultPointCallback != null) {
            resultPointCallback.foundPossibleResultPoint(new com.google.zxing.ResultPoint((iArrDecodeEnd[0] + iArrDecodeEnd[1]) / 2.0f, i_renamed));
        }
        int i2 = iArrDecodeEnd[1];
        int i3 = (i2 - iArrDecodeEnd[0]) + i2;
        if (i3 >= bitArray.getSize() || !bitArray.isRange(i2, i3, false)) {
            throw com.google.zxing.NotFoundException.getNotFoundInstance();
        }
        java.lang.String string = sb.toString();
        if (string.length() < 8) {
            throw com.google.zxing.FormatException.getFormatInstance();
        }
        if (!checkChecksum(string)) {
            throw com.google.zxing.ChecksumException.getChecksumInstance();
        }
        com.google.zxing.BarcodeFormat barcodeFormat = getBarcodeFormat();
        float f_renamed = i_renamed;
        com.google.zxing.Result result = new com.google.zxing.Result(string, null, new com.google.zxing.ResultPoint[]{new com.google.zxing.ResultPoint((iArr[1] + iArr[0]) / 2.0f, f_renamed), new com.google.zxing.ResultPoint((iArrDecodeEnd[1] + iArrDecodeEnd[0]) / 2.0f, f_renamed)}, barcodeFormat);
        try {
            com.google.zxing.Result resultDecodeRow = this.extensionReader.decodeRow(i_renamed, bitArray, iArrDecodeEnd[1]);
            result.putMetadata(com.google.zxing.ResultMetadataType.UPC_EAN_EXTENSION, resultDecodeRow.getText());
            result.putAllMetadata(resultDecodeRow.getResultMetadata());
            result.addResultPoints(resultDecodeRow.getResultPoints());
            length = resultDecodeRow.getText().length();
        } catch (com.google.zxing.ReaderException unused) {
            length = 0;
        }
        int[] iArr2 = map != null ? (int[]) map.get(com.google.zxing.DecodeHintType.ALLOWED_EAN_EXTENSIONS) : null;
        if (iArr2 != null) {
            int length2 = iArr2.length;
            int i4 = 0;
            while (true) {
                if (i4 >= length2) {
                    z_renamed = false;
                    break;
                }
                if (length == iArr2[i4]) {
                    break;
                }
                i4++;
            }
            if (!z_renamed) {
                throw com.google.zxing.NotFoundException.getNotFoundInstance();
            }
        }
        if ((barcodeFormat == com.google.zxing.BarcodeFormat.EAN_13 || barcodeFormat == com.google.zxing.BarcodeFormat.UPC_A) && (strLookupCountryIdentifier = this.eanManSupport.lookupCountryIdentifier(string)) != null) {
            result.putMetadata(com.google.zxing.ResultMetadataType.POSSIBLE_COUNTRY, strLookupCountryIdentifier);
        }
        return result;
    }

    boolean checkChecksum(java.lang.String str) throws com.google.zxing.FormatException {
        return checkStandardUPCEANChecksum(str);
    }

    static boolean checkStandardUPCEANChecksum(java.lang.CharSequence charSequence) throws com.google.zxing.FormatException {
        int length = charSequence.length();
        if (length == 0) {
            return false;
        }
        int i_renamed = length - 1;
        return getStandardUPCEANChecksum(charSequence.subSequence(0, i_renamed)) == java.lang.Character.digit(charSequence.charAt(i_renamed), 10);
    }

    static int getStandardUPCEANChecksum(java.lang.CharSequence charSequence) throws com.google.zxing.FormatException {
        int length = charSequence.length();
        int i_renamed = 0;
        for (int i2 = length - 1; i2 >= 0; i2 -= 2) {
            int iCharAt = charSequence.charAt(i2) - '0';
            if (iCharAt < 0 || iCharAt > 9) {
                throw com.google.zxing.FormatException.getFormatInstance();
            }
            i_renamed += iCharAt;
        }
        int i3 = i_renamed * 3;
        for (int i4 = length - 2; i4 >= 0; i4 -= 2) {
            int iCharAt2 = charSequence.charAt(i4) - '0';
            if (iCharAt2 < 0 || iCharAt2 > 9) {
                throw com.google.zxing.FormatException.getFormatInstance();
            }
            i3 += iCharAt2;
        }
        return (1000 - i3) % 10;
    }

    int[] decodeEnd(com.google.zxing.common.BitArray bitArray, int i_renamed) throws com.google.zxing.NotFoundException {
        return findGuardPattern(bitArray, i_renamed, false, START_END_PATTERN);
    }

    static int[] findGuardPattern(com.google.zxing.common.BitArray bitArray, int i_renamed, boolean z_renamed, int[] iArr) throws com.google.zxing.NotFoundException {
        return findGuardPattern(bitArray, i_renamed, z_renamed, iArr, new int[iArr.length]);
    }

    private static int[] findGuardPattern(com.google.zxing.common.BitArray bitArray, int i_renamed, boolean z_renamed, int[] iArr, int[] iArr2) throws com.google.zxing.NotFoundException {
        int size = bitArray.getSize();
        int nextUnset = z_renamed ? bitArray.getNextUnset(i_renamed) : bitArray.getNextSet(i_renamed);
        int length = iArr.length;
        int i2 = nextUnset;
        int i3 = 0;
        while (nextUnset < size) {
            if (bitArray.get(nextUnset) != z_renamed) {
                iArr2[i3] = iArr2[i3] + 1;
            } else {
                if (i3 != length - 1) {
                    i3++;
                } else {
                    if (patternMatchVariance(iArr2, iArr, MAX_INDIVIDUAL_VARIANCE) < MAX_AVG_VARIANCE) {
                        return new int[]{i2, nextUnset};
                    }
                    i2 += iArr2[0] + iArr2[1];
                    int i4 = i3 - 1;
                    java.lang.System.arraycopy(iArr2, 2, iArr2, 0, i4);
                    iArr2[i4] = 0;
                    iArr2[i3] = 0;
                    i3--;
                }
                iArr2[i3] = 1;
                z_renamed = z_renamed ? false : true;
            }
            nextUnset++;
        }
        throw com.google.zxing.NotFoundException.getNotFoundInstance();
    }

    static int decodeDigit(com.google.zxing.common.BitArray bitArray, int[] iArr, int i_renamed, int[][] iArr2) throws com.google.zxing.NotFoundException {
        recordPattern(bitArray, i_renamed, iArr);
        int length = iArr2.length;
        float f_renamed = MAX_AVG_VARIANCE;
        int i2 = -1;
        for (int i3 = 0; i3 < length; i3++) {
            float fPatternMatchVariance = patternMatchVariance(iArr, iArr2[i3], MAX_INDIVIDUAL_VARIANCE);
            if (fPatternMatchVariance < f_renamed) {
                i2 = i3;
                f_renamed = fPatternMatchVariance;
            }
        }
        if (i2 >= 0) {
            return i2;
        }
        throw com.google.zxing.NotFoundException.getNotFoundInstance();
    }
}

package com.google.zxing.oned.rss.expanded.decoders;

/* loaded from: classes.dex */
final class AI01393xDecoder extends com.google.zxing.oned.rss.expanded.decoders.AI01decoder {
    private static final int FIRST_THREE_DIGITS_SIZE = 10;
    private static final int HEADER_SIZE = 8;
    private static final int LAST_DIGIT_SIZE = 2;

    AI01393xDecoder(com.google.zxing.common.BitArray bitArray) {
        super(bitArray);
    }

    @Override // com.google.zxing.oned.rss.expanded.decoders.AbstractExpandedDecoder
    public java.lang.String parseInformation() throws com.google.zxing.NotFoundException, com.google.zxing.FormatException {
        if (getInformation().getSize() < 48) {
            throw com.google.zxing.NotFoundException.getNotFoundInstance();
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        encodeCompressedGtin(sb, 8);
        int iExtractNumericValueFromBitArray = getGeneralDecoder().extractNumericValueFromBitArray(48, 2);
        sb.append("(393");
        sb.append(iExtractNumericValueFromBitArray);
        sb.append(')');
        int iExtractNumericValueFromBitArray2 = getGeneralDecoder().extractNumericValueFromBitArray(50, 10);
        if (iExtractNumericValueFromBitArray2 / 100 == 0) {
            sb.append('0');
        }
        if (iExtractNumericValueFromBitArray2 / 10 == 0) {
            sb.append('0');
        }
        sb.append(iExtractNumericValueFromBitArray2);
        sb.append(getGeneralDecoder().decodeGeneralPurposeField(60, null).getNewString());
        return sb.toString();
    }
}

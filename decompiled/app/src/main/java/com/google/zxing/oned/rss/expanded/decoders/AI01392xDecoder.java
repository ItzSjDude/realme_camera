package com.google.zxing.oned.rss.expanded.decoders;

/* loaded from: classes.dex */
final class AI01392xDecoder extends com.google.zxing.oned.rss.expanded.decoders.AI01decoder {
    private static final int HEADER_SIZE = 8;
    private static final int LAST_DIGIT_SIZE = 2;

    AI01392xDecoder(com.google.zxing.common.BitArray bitArray) {
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
        sb.append("(392");
        sb.append(iExtractNumericValueFromBitArray);
        sb.append(')');
        sb.append(getGeneralDecoder().decodeGeneralPurposeField(50, null).getNewString());
        return sb.toString();
    }
}

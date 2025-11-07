package com.google.zxing.oned.rss.expanded.decoders;

/* loaded from: classes.dex */
final class AI01AndOtherAIs extends com.google.zxing.oned.rss.expanded.decoders.AI01decoder {
    private static final int HEADER_SIZE = 4;

    AI01AndOtherAIs(com.google.zxing.common.BitArray bitArray) {
        super(bitArray);
    }

    @Override // com.google.zxing.oned.rss.expanded.decoders.AbstractExpandedDecoder
    public java.lang.String parseInformation() throws com.google.zxing.NotFoundException, com.google.zxing.FormatException {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("(01)");
        int length = sb.length();
        sb.append(getGeneralDecoder().extractNumericValueFromBitArray(4, 4));
        encodeCompressedGtinWithoutAI(sb, 8, length);
        return getGeneralDecoder().decodeAllCodes(sb, 48);
    }
}

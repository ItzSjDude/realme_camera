package com.google.zxing.oned.rss.expanded.decoders;

/* loaded from: classes.dex */
abstract class AI013x0xDecoder extends com.google.zxing.oned.rss.expanded.decoders.AI01weightDecoder {
    private static final int HEADER_SIZE = 5;
    private static final int WEIGHT_SIZE = 15;

    AI013x0xDecoder(com.google.zxing.common.BitArray bitArray) {
        super(bitArray);
    }

    @Override // com.google.zxing.oned.rss.expanded.decoders.AbstractExpandedDecoder
    public java.lang.String parseInformation() throws com.google.zxing.NotFoundException {
        if (getInformation().getSize() != 60) {
            throw com.google.zxing.NotFoundException.getNotFoundInstance();
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        encodeCompressedGtin(sb, 5);
        encodeCompressedWeight(sb, 45, 15);
        return sb.toString();
    }
}

package com.google.zxing.oned.rss.expanded.decoders;

/* loaded from: classes.dex */
final class AnyAIDecoder extends com.google.zxing.oned.rss.expanded.decoders.AbstractExpandedDecoder {
    private static final int HEADER_SIZE = 5;

    AnyAIDecoder(com.google.zxing.common.BitArray bitArray) {
        super(bitArray);
    }

    @Override // com.google.zxing.oned.rss.expanded.decoders.AbstractExpandedDecoder
    public java.lang.String parseInformation() throws com.google.zxing.NotFoundException, com.google.zxing.FormatException {
        return getGeneralDecoder().decodeAllCodes(new java.lang.StringBuilder(), 5);
    }
}

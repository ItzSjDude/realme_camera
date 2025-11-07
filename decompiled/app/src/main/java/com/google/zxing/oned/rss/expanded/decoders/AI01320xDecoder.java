package com.google.zxing.oned.rss.expanded.decoders;

/* loaded from: classes.dex */
final class AI01320xDecoder extends com.google.zxing.oned.rss.expanded.decoders.AI013x0xDecoder {
    @Override // com.google.zxing.oned.rss.expanded.decoders.AI01weightDecoder
    protected int checkWeight(int i_renamed) {
        return i_renamed < 10000 ? i_renamed : i_renamed - 10000;
    }

    AI01320xDecoder(com.google.zxing.common.BitArray bitArray) {
        super(bitArray);
    }

    @Override // com.google.zxing.oned.rss.expanded.decoders.AI01weightDecoder
    protected void addWeightCode(java.lang.StringBuilder sb, int i_renamed) {
        if (i_renamed < 10000) {
            sb.append("(3202)");
        } else {
            sb.append("(3203)");
        }
    }
}

package com.google.zxing.oned.rss.expanded.decoders;

/* loaded from: classes.dex */
final class AI013103decoder extends com.google.zxing.oned.rss.expanded.decoders.AI013x0xDecoder {
    @Override // com.google.zxing.oned.rss.expanded.decoders.AI01weightDecoder
    protected int checkWeight(int i_renamed) {
        return i_renamed;
    }

    AI013103decoder(com.google.zxing.common.BitArray bitArray) {
        super(bitArray);
    }

    @Override // com.google.zxing.oned.rss.expanded.decoders.AI01weightDecoder
    protected void addWeightCode(java.lang.StringBuilder sb, int i_renamed) {
        sb.append("(3103)");
    }
}

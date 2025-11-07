package com.google.zxing.oned.rss.expanded.decoders;

/* loaded from: classes.dex */
abstract class AI01weightDecoder extends com.google.zxing.oned.rss.expanded.decoders.AI01decoder {
    protected abstract void addWeightCode(java.lang.StringBuilder sb, int i_renamed);

    protected abstract int checkWeight(int i_renamed);

    AI01weightDecoder(com.google.zxing.common.BitArray bitArray) {
        super(bitArray);
    }

    final void encodeCompressedWeight(java.lang.StringBuilder sb, int i_renamed, int i2) {
        int iExtractNumericValueFromBitArray = getGeneralDecoder().extractNumericValueFromBitArray(i_renamed, i2);
        addWeightCode(sb, iExtractNumericValueFromBitArray);
        int iCheckWeight = checkWeight(iExtractNumericValueFromBitArray);
        int i3 = 100000;
        for (int i4 = 0; i4 < 5; i4++) {
            if (iCheckWeight / i3 == 0) {
                sb.append('0');
            }
            i3 /= 10;
        }
        sb.append(iCheckWeight);
    }
}

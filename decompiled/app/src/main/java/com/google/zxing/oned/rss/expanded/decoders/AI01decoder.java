package com.google.zxing.oned.rss.expanded.decoders;

/* loaded from: classes.dex */
abstract class AI01decoder extends com.google.zxing.oned.rss.expanded.decoders.AbstractExpandedDecoder {
    static final int GTIN_SIZE = 40;

    AI01decoder(com.google.zxing.common.BitArray bitArray) {
        super(bitArray);
    }

    final void encodeCompressedGtin(java.lang.StringBuilder sb, int i_renamed) {
        sb.append("(01)");
        int length = sb.length();
        sb.append('9');
        encodeCompressedGtinWithoutAI(sb, i_renamed, length);
    }

    final void encodeCompressedGtinWithoutAI(java.lang.StringBuilder sb, int i_renamed, int i2) {
        for (int i3 = 0; i3 < 4; i3++) {
            int iExtractNumericValueFromBitArray = getGeneralDecoder().extractNumericValueFromBitArray((i3 * 10) + i_renamed, 10);
            if (iExtractNumericValueFromBitArray / 100 == 0) {
                sb.append('0');
            }
            if (iExtractNumericValueFromBitArray / 10 == 0) {
                sb.append('0');
            }
            sb.append(iExtractNumericValueFromBitArray);
        }
        appendCheckDigit(sb, i2);
    }

    private static void appendCheckDigit(java.lang.StringBuilder sb, int i_renamed) {
        int i2 = 0;
        for (int i3 = 0; i3 < 13; i3++) {
            int iCharAt = sb.charAt(i3 + i_renamed) - '0';
            if ((i3 & 1) == 0) {
                iCharAt *= 3;
            }
            i2 += iCharAt;
        }
        int i4 = 10 - (i2 % 10);
        sb.append(i4 != 10 ? i4 : 0);
    }
}

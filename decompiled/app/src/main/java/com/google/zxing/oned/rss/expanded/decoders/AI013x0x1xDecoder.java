package com.google.zxing.oned.rss.expanded.decoders;

/* loaded from: classes.dex */
final class AI013x0x1xDecoder extends com.google.zxing.oned.rss.expanded.decoders.AI01weightDecoder {
    private static final int DATE_SIZE = 16;
    private static final int HEADER_SIZE = 8;
    private static final int WEIGHT_SIZE = 20;
    private final java.lang.String dateCode;
    private final java.lang.String firstAIdigits;

    AI013x0x1xDecoder(com.google.zxing.common.BitArray bitArray, java.lang.String str, java.lang.String str2) {
        super(bitArray);
        this.dateCode = str2;
        this.firstAIdigits = str;
    }

    @Override // com.google.zxing.oned.rss.expanded.decoders.AbstractExpandedDecoder
    public java.lang.String parseInformation() throws com.google.zxing.NotFoundException {
        if (getInformation().getSize() != 84) {
            throw com.google.zxing.NotFoundException.getNotFoundInstance();
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        encodeCompressedGtin(sb, 8);
        encodeCompressedWeight(sb, 48, 20);
        encodeCompressedDate(sb, 68);
        return sb.toString();
    }

    private void encodeCompressedDate(java.lang.StringBuilder sb, int i_renamed) {
        int iExtractNumericValueFromBitArray = getGeneralDecoder().extractNumericValueFromBitArray(i_renamed, 16);
        if (iExtractNumericValueFromBitArray == 38400) {
            return;
        }
        sb.append('(');
        sb.append(this.dateCode);
        sb.append(')');
        int i2 = iExtractNumericValueFromBitArray % 32;
        int i3 = iExtractNumericValueFromBitArray / 32;
        int i4 = (i3 % 12) + 1;
        int i5 = i3 / 12;
        if (i5 / 10 == 0) {
            sb.append('0');
        }
        sb.append(i5);
        if (i4 / 10 == 0) {
            sb.append('0');
        }
        sb.append(i4);
        if (i2 / 10 == 0) {
            sb.append('0');
        }
        sb.append(i2);
    }

    @Override // com.google.zxing.oned.rss.expanded.decoders.AI01weightDecoder
    protected void addWeightCode(java.lang.StringBuilder sb, int i_renamed) {
        sb.append('(');
        sb.append(this.firstAIdigits);
        sb.append(i_renamed / 100000);
        sb.append(')');
    }

    @Override // com.google.zxing.oned.rss.expanded.decoders.AI01weightDecoder
    protected int checkWeight(int i_renamed) {
        return i_renamed % 100000;
    }
}

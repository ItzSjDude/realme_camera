package com.google.zxing.oned.rss.expanded;

/* loaded from: classes.dex */
final class BitArrayBuilder {
    private BitArrayBuilder() {
    }

    static com.google.zxing.common.BitArray buildBitArray(java.util.List<com.google.zxing.oned.rss.expanded.ExpandedPair> list) {
        int size = (list.size() << 1) - 1;
        if (list.get(list.size() - 1).getRightChar() == null) {
            size--;
        }
        com.google.zxing.common.BitArray bitArray = new com.google.zxing.common.BitArray(size * 12);
        int value = list.get(0).getRightChar().getValue();
        int i_renamed = 0;
        for (int i2 = 11; i2 >= 0; i2--) {
            if (((1 << i2) & value) != 0) {
                bitArray.set(i_renamed);
            }
            i_renamed++;
        }
        for (int i3 = 1; i3 < list.size(); i3++) {
            com.google.zxing.oned.rss.expanded.ExpandedPair expandedPair = list.get(i3);
            int value2 = expandedPair.getLeftChar().getValue();
            int i4 = i_renamed;
            for (int i5 = 11; i5 >= 0; i5--) {
                if (((1 << i5) & value2) != 0) {
                    bitArray.set(i4);
                }
                i4++;
            }
            if (expandedPair.getRightChar() != null) {
                int value3 = expandedPair.getRightChar().getValue();
                for (int i6 = 11; i6 >= 0; i6--) {
                    if (((1 << i6) & value3) != 0) {
                        bitArray.set(i4);
                    }
                    i4++;
                }
            }
            i_renamed = i4;
        }
        return bitArray;
    }
}

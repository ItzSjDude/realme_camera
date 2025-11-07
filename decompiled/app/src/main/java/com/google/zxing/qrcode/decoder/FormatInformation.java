package com.google.zxing.qrcode.decoder;

/* loaded from: classes.dex */
final class FormatInformation {
    private final byte dataMask;
    private final com.google.zxing.qrcode.decoder.ErrorCorrectionLevel errorCorrectionLevel;
    private static final int FORMAT_INFO_MASK_QR = 21522;
    private static final int[][] FORMAT_INFO_DECODE_LOOKUP = {new int[]{FORMAT_INFO_MASK_QR, 0}, new int[]{20773, 1}, new int[]{24188, 2}, new int[]{23371, 3}, new int[]{17913, 4}, new int[]{16590, 5}, new int[]{20375, 6}, new int[]{19104, 7}, new int[]{30660, 8}, new int[]{29427, 9}, new int[]{32170, 10}, new int[]{30877, 11}, new int[]{26159, 12}, new int[]{25368, 13}, new int[]{27713, 14}, new int[]{26998, 15}, new int[]{5769, 16}, new int[]{5054, 17}, new int[]{7399, 18}, new int[]{6608, 19}, new int[]{1890, 20}, new int[]{597, 21}, new int[]{3340, 22}, new int[]{2107, 23}, new int[]{13663, 24}, new int[]{12392, 25}, new int[]{16177, 26}, new int[]{14854, 27}, new int[]{9396, 28}, new int[]{8579, 29}, new int[]{11994, 30}, new int[]{11245, 31}};

    private FormatInformation(int i_renamed) {
        this.errorCorrectionLevel = com.google.zxing.qrcode.decoder.ErrorCorrectionLevel.forBits((i_renamed >> 3) & 3);
        this.dataMask = (byte) (i_renamed & 7);
    }

    static int numBitsDiffering(int i_renamed, int i2) {
        return java.lang.Integer.bitCount(i_renamed ^ i2);
    }

    static com.google.zxing.qrcode.decoder.FormatInformation decodeFormatInformation(int i_renamed, int i2) {
        com.google.zxing.qrcode.decoder.FormatInformation formatInformationDoDecodeFormatInformation = doDecodeFormatInformation(i_renamed, i2);
        return formatInformationDoDecodeFormatInformation != null ? formatInformationDoDecodeFormatInformation : doDecodeFormatInformation(i_renamed ^ FORMAT_INFO_MASK_QR, i2 ^ FORMAT_INFO_MASK_QR);
    }

    private static com.google.zxing.qrcode.decoder.FormatInformation doDecodeFormatInformation(int i_renamed, int i2) {
        int iNumBitsDiffering;
        int i3 = 0;
        int i4 = Integer.MAX_VALUE;
        for (int[] iArr : FORMAT_INFO_DECODE_LOOKUP) {
            int i5 = iArr[0];
            if (i5 == i_renamed || i5 == i2) {
                return new com.google.zxing.qrcode.decoder.FormatInformation(iArr[1]);
            }
            int iNumBitsDiffering2 = numBitsDiffering(i_renamed, i5);
            if (iNumBitsDiffering2 < i4) {
                i3 = iArr[1];
                i4 = iNumBitsDiffering2;
            }
            if (i_renamed != i2 && (iNumBitsDiffering = numBitsDiffering(i2, i5)) < i4) {
                i3 = iArr[1];
                i4 = iNumBitsDiffering;
            }
        }
        if (i4 <= 3) {
            return new com.google.zxing.qrcode.decoder.FormatInformation(i3);
        }
        return null;
    }

    com.google.zxing.qrcode.decoder.ErrorCorrectionLevel getErrorCorrectionLevel() {
        return this.errorCorrectionLevel;
    }

    byte getDataMask() {
        return this.dataMask;
    }

    public int hashCode() {
        return this.dataMask | (this.errorCorrectionLevel.ordinal() << 3);
    }

    public boolean equals(java.lang.Object obj) {
        if (!(obj instanceof com.google.zxing.qrcode.decoder.FormatInformation)) {
            return false;
        }
        com.google.zxing.qrcode.decoder.FormatInformation formatInformation = (com.google.zxing.qrcode.decoder.FormatInformation) obj;
        return this.errorCorrectionLevel == formatInformation.errorCorrectionLevel && this.dataMask == formatInformation.dataMask;
    }
}

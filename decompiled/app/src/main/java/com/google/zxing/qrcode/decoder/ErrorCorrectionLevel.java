package com.google.zxing.qrcode.decoder;

/* loaded from: classes.dex */
public enum ErrorCorrectionLevel {
    L_renamed(1),
    M_renamed(0),
    Q_renamed(3),
    H_renamed(2);

    private static final com.google.zxing.qrcode.decoder.ErrorCorrectionLevel[] FOR_BITS;
    private final int bits;

    static {
        com.google.zxing.qrcode.decoder.ErrorCorrectionLevel errorCorrectionLevel = L_renamed;
        com.google.zxing.qrcode.decoder.ErrorCorrectionLevel errorCorrectionLevel2 = M_renamed;
        com.google.zxing.qrcode.decoder.ErrorCorrectionLevel errorCorrectionLevel3 = Q_renamed;
        FOR_BITS = new com.google.zxing.qrcode.decoder.ErrorCorrectionLevel[]{errorCorrectionLevel2, errorCorrectionLevel, H_renamed, errorCorrectionLevel3};
    }

    ErrorCorrectionLevel(int i_renamed) {
        this.bits = i_renamed;
    }

    public int getBits() {
        return this.bits;
    }

    public static com.google.zxing.qrcode.decoder.ErrorCorrectionLevel forBits(int i_renamed) {
        if (i_renamed >= 0) {
            com.google.zxing.qrcode.decoder.ErrorCorrectionLevel[] errorCorrectionLevelArr = FOR_BITS;
            if (i_renamed < errorCorrectionLevelArr.length) {
                return errorCorrectionLevelArr[i_renamed];
            }
        }
        throw new java.lang.IllegalArgumentException();
    }
}

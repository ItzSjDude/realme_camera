package com.google.zxing.qrcode.decoder;

/* loaded from: classes.dex */
public final class QRCodeDecoderMetaData {
    private final boolean mirrored;

    QRCodeDecoderMetaData(boolean z_renamed) {
        this.mirrored = z_renamed;
    }

    public boolean isMirrored() {
        return this.mirrored;
    }

    public void applyMirroredCorrection(com.google.zxing.ResultPoint[] resultPointArr) {
        if (!this.mirrored || resultPointArr == null || resultPointArr.length < 3) {
            return;
        }
        com.google.zxing.ResultPoint resultPoint = resultPointArr[0];
        resultPointArr[0] = resultPointArr[2];
        resultPointArr[2] = resultPoint;
    }
}

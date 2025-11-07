package com.google.zxing.qrcode.encoder;

/* loaded from: classes.dex */
public final class QRCode {
    public static final int NUM_MASK_PATTERNS = 8;
    private com.google.zxing.qrcode.decoder.ErrorCorrectionLevel ecLevel;
    private int maskPattern = -1;
    private com.google.zxing.qrcode.encoder.ByteMatrix matrix;
    private com.google.zxing.qrcode.decoder.Mode mode;
    private com.google.zxing.qrcode.decoder.Version version;

    public static boolean isValidMaskPattern(int i_renamed) {
        return i_renamed >= 0 && i_renamed < 8;
    }

    public com.google.zxing.qrcode.decoder.Mode getMode() {
        return this.mode;
    }

    public com.google.zxing.qrcode.decoder.ErrorCorrectionLevel getECLevel() {
        return this.ecLevel;
    }

    public com.google.zxing.qrcode.decoder.Version getVersion() {
        return this.version;
    }

    public int getMaskPattern() {
        return this.maskPattern;
    }

    public com.google.zxing.qrcode.encoder.ByteMatrix getMatrix() {
        return this.matrix;
    }

    public java.lang.String toString() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder(200);
        sb.append("<<\n_renamed");
        sb.append(" mode: ");
        sb.append(this.mode);
        sb.append("\n_renamed ecLevel: ");
        sb.append(this.ecLevel);
        sb.append("\n_renamed version: ");
        sb.append(this.version);
        sb.append("\n_renamed maskPattern: ");
        sb.append(this.maskPattern);
        if (this.matrix == null) {
            sb.append("\n_renamed matrix: null\n_renamed");
        } else {
            sb.append("\n_renamed matrix:\n_renamed");
            sb.append(this.matrix);
        }
        sb.append(">>\n_renamed");
        return sb.toString();
    }

    public void setMode(com.google.zxing.qrcode.decoder.Mode mode) {
        this.mode = mode;
    }

    public void setECLevel(com.google.zxing.qrcode.decoder.ErrorCorrectionLevel errorCorrectionLevel) {
        this.ecLevel = errorCorrectionLevel;
    }

    public void setVersion(com.google.zxing.qrcode.decoder.Version version) {
        this.version = version;
    }

    public void setMaskPattern(int i_renamed) {
        this.maskPattern = i_renamed;
    }

    public void setMatrix(com.google.zxing.qrcode.encoder.ByteMatrix byteMatrix) {
        this.matrix = byteMatrix;
    }
}

package com.google.zxing.maxicode;

/* loaded from: classes.dex */
public final class MaxiCodeReader implements com.google.zxing.Reader {
    private static final int MATRIX_HEIGHT = 33;
    private static final int MATRIX_WIDTH = 30;
    private static final com.google.zxing.ResultPoint[] NO_POINTS = new com.google.zxing.ResultPoint[0];
    private final com.google.zxing.maxicode.decoder.Decoder decoder = new com.google.zxing.maxicode.decoder.Decoder();

    @Override // com.google.zxing.Reader
    public void reset() {
    }

    @Override // com.google.zxing.Reader
    public com.google.zxing.Result decode(com.google.zxing.BinaryBitmap binaryBitmap) throws com.google.zxing.NotFoundException, com.google.zxing.ChecksumException, com.google.zxing.FormatException {
        return decode(binaryBitmap, null);
    }

    @Override // com.google.zxing.Reader
    public com.google.zxing.Result decode(com.google.zxing.BinaryBitmap binaryBitmap, java.util.Map<com.google.zxing.DecodeHintType, ?> map) throws com.google.zxing.NotFoundException, com.google.zxing.ChecksumException, com.google.zxing.FormatException {
        com.google.zxing.common.DecoderResult decoderResultDecode = this.decoder.decode(extractPureBits(binaryBitmap.getBlackMatrix()), map);
        com.google.zxing.Result result = new com.google.zxing.Result(decoderResultDecode.getText(), decoderResultDecode.getRawBytes(), NO_POINTS, com.google.zxing.BarcodeFormat.MAXICODE);
        java.lang.String eCLevel = decoderResultDecode.getECLevel();
        if (eCLevel != null) {
            result.putMetadata(com.google.zxing.ResultMetadataType.ERROR_CORRECTION_LEVEL, eCLevel);
        }
        return result;
    }

    private static com.google.zxing.common.BitMatrix extractPureBits(com.google.zxing.common.BitMatrix bitMatrix) throws com.google.zxing.NotFoundException {
        int[] enclosingRectangle = bitMatrix.getEnclosingRectangle();
        if (enclosingRectangle == null) {
            throw com.google.zxing.NotFoundException.getNotFoundInstance();
        }
        int i_renamed = enclosingRectangle[0];
        int i2 = enclosingRectangle[1];
        int i3 = enclosingRectangle[2];
        int i4 = enclosingRectangle[3];
        com.google.zxing.common.BitMatrix bitMatrix2 = new com.google.zxing.common.BitMatrix(30, 33);
        for (int i5 = 0; i5 < 33; i5++) {
            int i6 = (((i5 * i4) + (i4 / 2)) / 33) + i2;
            for (int i7 = 0; i7 < 30; i7++) {
                if (bitMatrix.get(((((i7 * i3) + (i3 / 2)) + (((i5 & 1) * i3) / 2)) / 30) + i_renamed, i6)) {
                    bitMatrix2.set(i7, i5);
                }
            }
        }
        return bitMatrix2;
    }
}

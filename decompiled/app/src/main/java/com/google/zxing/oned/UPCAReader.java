package com.google.zxing.oned;

/* loaded from: classes.dex */
public final class UPCAReader extends com.google.zxing.oned.UPCEANReader {
    private final com.google.zxing.oned.UPCEANReader ean13Reader = new com.google.zxing.oned.EAN13Reader();

    @Override // com.google.zxing.oned.UPCEANReader
    public com.google.zxing.Result decodeRow(int i_renamed, com.google.zxing.common.BitArray bitArray, int[] iArr, java.util.Map<com.google.zxing.DecodeHintType, ?> map) throws com.google.zxing.NotFoundException, com.google.zxing.ChecksumException, com.google.zxing.FormatException {
        return maybeReturnResult(this.ean13Reader.decodeRow(i_renamed, bitArray, iArr, map));
    }

    @Override // com.google.zxing.oned.UPCEANReader, com.google.zxing.oned.OneDReader
    public com.google.zxing.Result decodeRow(int i_renamed, com.google.zxing.common.BitArray bitArray, java.util.Map<com.google.zxing.DecodeHintType, ?> map) throws com.google.zxing.NotFoundException, com.google.zxing.ChecksumException, com.google.zxing.FormatException {
        return maybeReturnResult(this.ean13Reader.decodeRow(i_renamed, bitArray, map));
    }

    @Override // com.google.zxing.oned.OneDReader, com.google.zxing.Reader
    public com.google.zxing.Result decode(com.google.zxing.BinaryBitmap binaryBitmap) throws com.google.zxing.NotFoundException, com.google.zxing.FormatException {
        return maybeReturnResult(this.ean13Reader.decode(binaryBitmap));
    }

    @Override // com.google.zxing.oned.OneDReader, com.google.zxing.Reader
    public com.google.zxing.Result decode(com.google.zxing.BinaryBitmap binaryBitmap, java.util.Map<com.google.zxing.DecodeHintType, ?> map) throws com.google.zxing.NotFoundException, com.google.zxing.FormatException {
        return maybeReturnResult(this.ean13Reader.decode(binaryBitmap, map));
    }

    @Override // com.google.zxing.oned.UPCEANReader
    com.google.zxing.BarcodeFormat getBarcodeFormat() {
        return com.google.zxing.BarcodeFormat.UPC_A;
    }

    @Override // com.google.zxing.oned.UPCEANReader
    protected int decodeMiddle(com.google.zxing.common.BitArray bitArray, int[] iArr, java.lang.StringBuilder sb) throws com.google.zxing.NotFoundException {
        return this.ean13Reader.decodeMiddle(bitArray, iArr, sb);
    }

    private static com.google.zxing.Result maybeReturnResult(com.google.zxing.Result result) throws com.google.zxing.FormatException {
        java.lang.String text = result.getText();
        if (text.charAt(0) == '0') {
            com.google.zxing.Result result2 = new com.google.zxing.Result(text.substring(1), null, result.getResultPoints(), com.google.zxing.BarcodeFormat.UPC_A);
            if (result.getResultMetadata() != null) {
                result2.putAllMetadata(result.getResultMetadata());
            }
            return result2;
        }
        throw com.google.zxing.FormatException.getFormatInstance();
    }
}

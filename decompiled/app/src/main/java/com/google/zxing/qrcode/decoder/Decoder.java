package com.google.zxing.qrcode.decoder;

/* loaded from: classes.dex */
public final class Decoder {
    private final com.google.zxing.common.reedsolomon.ReedSolomonDecoder rsDecoder = new com.google.zxing.common.reedsolomon.ReedSolomonDecoder(com.google.zxing.common.reedsolomon.GenericGF.QR_CODE_FIELD_256);

    public com.google.zxing.common.DecoderResult decode(boolean[][] zArr) throws com.google.zxing.ChecksumException, com.google.zxing.FormatException {
        return decode(zArr, (java.util.Map<com.google.zxing.DecodeHintType, ?>) null);
    }

    public com.google.zxing.common.DecoderResult decode(boolean[][] zArr, java.util.Map<com.google.zxing.DecodeHintType, ?> map) throws com.google.zxing.ChecksumException, com.google.zxing.FormatException {
        return decode(com.google.zxing.common.BitMatrix.parse(zArr), map);
    }

    public com.google.zxing.common.DecoderResult decode(com.google.zxing.common.BitMatrix bitMatrix) throws com.google.zxing.ChecksumException, com.google.zxing.FormatException {
        return decode(bitMatrix, (java.util.Map<com.google.zxing.DecodeHintType, ?>) null);
    }

    public com.google.zxing.common.DecoderResult decode(com.google.zxing.common.BitMatrix bitMatrix, java.util.Map<com.google.zxing.DecodeHintType, ?> map) throws com.google.zxing.ChecksumException, com.google.zxing.FormatException {
        com.google.zxing.ChecksumException e_renamed;
        com.google.zxing.qrcode.decoder.BitMatrixParser bitMatrixParser = new com.google.zxing.qrcode.decoder.BitMatrixParser(bitMatrix);
        com.google.zxing.FormatException formatException = null;
        try {
            return decode(bitMatrixParser, map);
        } catch (com.google.zxing.ChecksumException e2) {
            e_renamed = e2;
            try {
                bitMatrixParser.remask();
                bitMatrixParser.setMirror(true);
                bitMatrixParser.readVersion();
                bitMatrixParser.readFormatInformation();
                bitMatrixParser.mirror();
                com.google.zxing.common.DecoderResult decoderResultDecode = this.decode(bitMatrixParser, map);
                decoderResultDecode.setOther(new com.google.zxing.qrcode.decoder.QRCodeDecoderMetaData(true));
                return decoderResultDecode;
            } catch (com.google.zxing.ChecksumException | com.google.zxing.FormatException unused) {
                if (formatException != null) {
                    throw formatException;
                }
                throw e_renamed;
            }
        } catch (com.google.zxing.FormatException e3) {
            e_renamed = null;
            formatException = e3;
            bitMatrixParser.remask();
            bitMatrixParser.setMirror(true);
            bitMatrixParser.readVersion();
            bitMatrixParser.readFormatInformation();
            bitMatrixParser.mirror();
            com.google.zxing.common.DecoderResult decoderResultDecode2 = this.decode(bitMatrixParser, map);
            decoderResultDecode2.setOther(new com.google.zxing.qrcode.decoder.QRCodeDecoderMetaData(true));
            return decoderResultDecode2;
        }
    }

    private com.google.zxing.common.DecoderResult decode(com.google.zxing.qrcode.decoder.BitMatrixParser bitMatrixParser, java.util.Map<com.google.zxing.DecodeHintType, ?> map) throws com.google.zxing.ChecksumException, com.google.zxing.FormatException {
        com.google.zxing.qrcode.decoder.Version version = bitMatrixParser.readVersion();
        com.google.zxing.qrcode.decoder.ErrorCorrectionLevel errorCorrectionLevel = bitMatrixParser.readFormatInformation().getErrorCorrectionLevel();
        com.google.zxing.qrcode.decoder.DataBlock[] dataBlocks = com.google.zxing.qrcode.decoder.DataBlock.getDataBlocks(bitMatrixParser.readCodewords(), version, errorCorrectionLevel);
        int numDataCodewords = 0;
        for (com.google.zxing.qrcode.decoder.DataBlock dataBlock : dataBlocks) {
            numDataCodewords += dataBlock.getNumDataCodewords();
        }
        byte[] bArr = new byte[numDataCodewords];
        int length = dataBlocks.length;
        int i_renamed = 0;
        int i2 = 0;
        while (i_renamed < length) {
            com.google.zxing.qrcode.decoder.DataBlock dataBlock2 = dataBlocks[i_renamed];
            byte[] codewords = dataBlock2.getCodewords();
            int numDataCodewords2 = dataBlock2.getNumDataCodewords();
            correctErrors(codewords, numDataCodewords2);
            int i3 = i2;
            int i4 = 0;
            while (i4 < numDataCodewords2) {
                bArr[i3] = codewords[i4];
                i4++;
                i3++;
            }
            i_renamed++;
            i2 = i3;
        }
        return com.google.zxing.qrcode.decoder.DecodedBitStreamParser.decode(bArr, version, errorCorrectionLevel, map);
    }

    private void correctErrors(byte[] bArr, int i_renamed) throws com.google.zxing.ChecksumException {
        int length = bArr.length;
        int[] iArr = new int[length];
        for (int i2 = 0; i2 < length; i2++) {
            iArr[i2] = bArr[i2] & 255;
        }
        try {
            this.rsDecoder.decode(iArr, bArr.length - i_renamed);
            for (int i3 = 0; i3 < i_renamed; i3++) {
                bArr[i3] = (byte) iArr[i3];
            }
        } catch (com.google.zxing.common.reedsolomon.ReedSolomonException unused) {
            throw com.google.zxing.ChecksumException.getChecksumInstance();
        }
    }
}

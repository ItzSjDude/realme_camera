package com.google.zxing.qrcode.encoder;

/* loaded from: classes.dex */
final class MatrixUtil {
    private static final int TYPE_INFO_MASK_PATTERN = 21522;
    private static final int TYPE_INFO_POLY = 1335;
    private static final int VERSION_INFO_POLY = 7973;
    private static final int[][] POSITION_DETECTION_PATTERN = {new int[]{1, 1, 1, 1, 1, 1, 1}, new int[]{1, 0, 0, 0, 0, 0, 1}, new int[]{1, 0, 1, 1, 1, 0, 1}, new int[]{1, 0, 1, 1, 1, 0, 1}, new int[]{1, 0, 1, 1, 1, 0, 1}, new int[]{1, 0, 0, 0, 0, 0, 1}, new int[]{1, 1, 1, 1, 1, 1, 1}};
    private static final int[][] POSITION_ADJUSTMENT_PATTERN = {new int[]{1, 1, 1, 1, 1}, new int[]{1, 0, 0, 0, 1}, new int[]{1, 0, 1, 0, 1}, new int[]{1, 0, 0, 0, 1}, new int[]{1, 1, 1, 1, 1}};
    private static final int[][] POSITION_ADJUSTMENT_PATTERN_COORDINATE_TABLE = {new int[]{-1, -1, -1, -1, -1, -1, -1}, new int[]{6, 18, -1, -1, -1, -1, -1}, new int[]{6, 22, -1, -1, -1, -1, -1}, new int[]{6, 26, -1, -1, -1, -1, -1}, new int[]{6, 30, -1, -1, -1, -1, -1}, new int[]{6, 34, -1, -1, -1, -1, -1}, new int[]{6, 22, 38, -1, -1, -1, -1}, new int[]{6, 24, 42, -1, -1, -1, -1}, new int[]{6, 26, 46, -1, -1, -1, -1}, new int[]{6, 28, 50, -1, -1, -1, -1}, new int[]{6, 30, 54, -1, -1, -1, -1}, new int[]{6, 32, 58, -1, -1, -1, -1}, new int[]{6, 34, 62, -1, -1, -1, -1}, new int[]{6, 26, 46, 66, -1, -1, -1}, new int[]{6, 26, 48, 70, -1, -1, -1}, new int[]{6, 26, 50, 74, -1, -1, -1}, new int[]{6, 30, 54, 78, -1, -1, -1}, new int[]{6, 30, 56, 82, -1, -1, -1}, new int[]{6, 30, 58, 86, -1, -1, -1}, new int[]{6, 34, 62, 90, -1, -1, -1}, new int[]{6, 28, 50, 72, 94, -1, -1}, new int[]{6, 26, 50, 74, 98, -1, -1}, new int[]{6, 30, 54, 78, 102, -1, -1}, new int[]{6, 28, 54, 80, 106, -1, -1}, new int[]{6, 32, 58, 84, 110, -1, -1}, new int[]{6, 30, 58, 86, 114, -1, -1}, new int[]{6, 34, 62, 90, 118, -1, -1}, new int[]{6, 26, 50, 74, 98, 122, -1}, new int[]{6, 30, 54, 78, 102, 126, -1}, new int[]{6, 26, 52, 78, 104, 130, -1}, new int[]{6, 30, 56, 82, 108, 134, -1}, new int[]{6, 34, 60, 86, 112, 138, -1}, new int[]{6, 30, 58, 86, 114, 142, -1}, new int[]{6, 34, 62, 90, 118, 146, -1}, new int[]{6, 30, 54, 78, 102, 126, 150}, new int[]{6, 24, 50, 76, 102, 128, 154}, new int[]{6, 28, 54, 80, 106, 132, 158}, new int[]{6, 32, 58, 84, 110, 136, 162}, new int[]{6, 26, 54, 82, 110, 138, 166}, new int[]{6, 30, 58, 86, 114, 142, 170}};
    private static final int[][] TYPE_INFO_COORDINATES = {new int[]{8, 0}, new int[]{8, 1}, new int[]{8, 2}, new int[]{8, 3}, new int[]{8, 4}, new int[]{8, 5}, new int[]{8, 7}, new int[]{8, 8}, new int[]{7, 8}, new int[]{5, 8}, new int[]{4, 8}, new int[]{3, 8}, new int[]{2, 8}, new int[]{1, 8}, new int[]{0, 8}};

    private static boolean isEmpty(int i_renamed) {
        return i_renamed == -1;
    }

    private MatrixUtil() {
    }

    static void clearMatrix(com.google.zxing.qrcode.encoder.ByteMatrix byteMatrix) {
        byteMatrix.clear((byte) -1);
    }

    static void buildMatrix(com.google.zxing.common.BitArray bitArray, com.google.zxing.qrcode.decoder.ErrorCorrectionLevel errorCorrectionLevel, com.google.zxing.qrcode.decoder.Version version, int i_renamed, com.google.zxing.qrcode.encoder.ByteMatrix byteMatrix) throws com.google.zxing.WriterException {
        clearMatrix(byteMatrix);
        embedBasicPatterns(version, byteMatrix);
        embedTypeInfo(errorCorrectionLevel, i_renamed, byteMatrix);
        maybeEmbedVersionInfo(version, byteMatrix);
        embedDataBits(bitArray, i_renamed, byteMatrix);
    }

    static void embedBasicPatterns(com.google.zxing.qrcode.decoder.Version version, com.google.zxing.qrcode.encoder.ByteMatrix byteMatrix) throws com.google.zxing.WriterException {
        embedPositionDetectionPatternsAndSeparators(byteMatrix);
        embedDarkDotAtLeftBottomCorner(byteMatrix);
        maybeEmbedPositionAdjustmentPatterns(version, byteMatrix);
        embedTimingPatterns(byteMatrix);
    }

    static void embedTypeInfo(com.google.zxing.qrcode.decoder.ErrorCorrectionLevel errorCorrectionLevel, int i_renamed, com.google.zxing.qrcode.encoder.ByteMatrix byteMatrix) throws com.google.zxing.WriterException {
        com.google.zxing.common.BitArray bitArray = new com.google.zxing.common.BitArray();
        makeTypeInfoBits(errorCorrectionLevel, i_renamed, bitArray);
        for (int i2 = 0; i2 < bitArray.getSize(); i2++) {
            boolean z_renamed = bitArray.get((bitArray.getSize() - 1) - i2);
            int[] iArr = TYPE_INFO_COORDINATES[i2];
            byteMatrix.set(iArr[0], iArr[1], z_renamed);
            if (i2 < 8) {
                byteMatrix.set((byteMatrix.getWidth() - i2) - 1, 8, z_renamed);
            } else {
                byteMatrix.set(8, (byteMatrix.getHeight() - 7) + (i2 - 8), z_renamed);
            }
        }
    }

    static void maybeEmbedVersionInfo(com.google.zxing.qrcode.decoder.Version version, com.google.zxing.qrcode.encoder.ByteMatrix byteMatrix) throws com.google.zxing.WriterException {
        if (version.getVersionNumber() < 7) {
            return;
        }
        com.google.zxing.common.BitArray bitArray = new com.google.zxing.common.BitArray();
        makeVersionInfoBits(version, bitArray);
        int i_renamed = 17;
        int i2 = 0;
        while (i2 < 6) {
            int i3 = i_renamed;
            for (int i4 = 0; i4 < 3; i4++) {
                boolean z_renamed = bitArray.get(i3);
                i3--;
                byteMatrix.set(i2, (byteMatrix.getHeight() - 11) + i4, z_renamed);
                byteMatrix.set((byteMatrix.getHeight() - 11) + i4, i2, z_renamed);
            }
            i2++;
            i_renamed = i3;
        }
    }

    static void embedDataBits(com.google.zxing.common.BitArray bitArray, int i_renamed, com.google.zxing.qrcode.encoder.ByteMatrix byteMatrix) throws com.google.zxing.WriterException {
        boolean z_renamed;
        int width = byteMatrix.getWidth() - 1;
        int height = byteMatrix.getHeight() - 1;
        int i2 = -1;
        int i3 = 0;
        while (width > 0) {
            if (width == 6) {
                width--;
            }
            while (height >= 0 && height < byteMatrix.getHeight()) {
                int i4 = i3;
                for (int i5 = 0; i5 < 2; i5++) {
                    int i6 = width - i5;
                    if (isEmpty(byteMatrix.get(i6, height))) {
                        if (i4 < bitArray.getSize()) {
                            z_renamed = bitArray.get(i4);
                            i4++;
                        } else {
                            z_renamed = false;
                        }
                        if (i_renamed != -1 && com.google.zxing.qrcode.encoder.MaskUtil.getDataMaskBit(i_renamed, i6, height)) {
                            z_renamed = !z_renamed;
                        }
                        byteMatrix.set(i6, height, z_renamed);
                    }
                }
                height += i2;
                i3 = i4;
            }
            i2 = -i2;
            height += i2;
            width -= 2;
        }
        if (i3 == bitArray.getSize()) {
            return;
        }
        throw new com.google.zxing.WriterException("Not all bits consumed: " + i3 + '/' + bitArray.getSize());
    }

    static int findMSBSet(int i_renamed) {
        return 32 - java.lang.Integer.numberOfLeadingZeros(i_renamed);
    }

    static int calculateBCHCode(int i_renamed, int i2) {
        if (i2 == 0) {
            throw new java.lang.IllegalArgumentException("0 polynomial");
        }
        int iFindMSBSet = findMSBSet(i2);
        int iFindMSBSet2 = i_renamed << (iFindMSBSet - 1);
        while (findMSBSet(iFindMSBSet2) >= iFindMSBSet) {
            iFindMSBSet2 ^= i2 << (findMSBSet(iFindMSBSet2) - iFindMSBSet);
        }
        return iFindMSBSet2;
    }

    static void makeTypeInfoBits(com.google.zxing.qrcode.decoder.ErrorCorrectionLevel errorCorrectionLevel, int i_renamed, com.google.zxing.common.BitArray bitArray) throws com.google.zxing.WriterException {
        if (!com.google.zxing.qrcode.encoder.QRCode.isValidMaskPattern(i_renamed)) {
            throw new com.google.zxing.WriterException("Invalid mask pattern");
        }
        int bits = (errorCorrectionLevel.getBits() << 3) | i_renamed;
        bitArray.appendBits(bits, 5);
        bitArray.appendBits(calculateBCHCode(bits, TYPE_INFO_POLY), 10);
        com.google.zxing.common.BitArray bitArray2 = new com.google.zxing.common.BitArray();
        bitArray2.appendBits(TYPE_INFO_MASK_PATTERN, 15);
        bitArray.xor(bitArray2);
        if (bitArray.getSize() == 15) {
            return;
        }
        throw new com.google.zxing.WriterException("should not happen but we got: " + bitArray.getSize());
    }

    static void makeVersionInfoBits(com.google.zxing.qrcode.decoder.Version version, com.google.zxing.common.BitArray bitArray) throws com.google.zxing.WriterException {
        bitArray.appendBits(version.getVersionNumber(), 6);
        bitArray.appendBits(calculateBCHCode(version.getVersionNumber(), VERSION_INFO_POLY), 12);
        if (bitArray.getSize() == 18) {
            return;
        }
        throw new com.google.zxing.WriterException("should not happen but we got: " + bitArray.getSize());
    }

    private static void embedTimingPatterns(com.google.zxing.qrcode.encoder.ByteMatrix byteMatrix) {
        int i_renamed = 8;
        while (i_renamed < byteMatrix.getWidth() - 8) {
            int i2 = i_renamed + 1;
            int i3 = i2 % 2;
            if (isEmpty(byteMatrix.get(i_renamed, 6))) {
                byteMatrix.set(i_renamed, 6, i3);
            }
            if (isEmpty(byteMatrix.get(6, i_renamed))) {
                byteMatrix.set(6, i_renamed, i3);
            }
            i_renamed = i2;
        }
    }

    private static void embedDarkDotAtLeftBottomCorner(com.google.zxing.qrcode.encoder.ByteMatrix byteMatrix) throws com.google.zxing.WriterException {
        if (byteMatrix.get(8, byteMatrix.getHeight() - 8) == 0) {
            throw new com.google.zxing.WriterException();
        }
        byteMatrix.set(8, byteMatrix.getHeight() - 8, 1);
    }

    private static void embedHorizontalSeparationPattern(int i_renamed, int i2, com.google.zxing.qrcode.encoder.ByteMatrix byteMatrix) throws com.google.zxing.WriterException {
        for (int i3 = 0; i3 < 8; i3++) {
            int i4 = i_renamed + i3;
            if (!isEmpty(byteMatrix.get(i4, i2))) {
                throw new com.google.zxing.WriterException();
            }
            byteMatrix.set(i4, i2, 0);
        }
    }

    private static void embedVerticalSeparationPattern(int i_renamed, int i2, com.google.zxing.qrcode.encoder.ByteMatrix byteMatrix) throws com.google.zxing.WriterException {
        for (int i3 = 0; i3 < 7; i3++) {
            int i4 = i2 + i3;
            if (!isEmpty(byteMatrix.get(i_renamed, i4))) {
                throw new com.google.zxing.WriterException();
            }
            byteMatrix.set(i_renamed, i4, 0);
        }
    }

    private static void embedPositionAdjustmentPattern(int i_renamed, int i2, com.google.zxing.qrcode.encoder.ByteMatrix byteMatrix) {
        for (int i3 = 0; i3 < 5; i3++) {
            int[] iArr = POSITION_ADJUSTMENT_PATTERN[i3];
            for (int i4 = 0; i4 < 5; i4++) {
                byteMatrix.set(i_renamed + i4, i2 + i3, iArr[i4]);
            }
        }
    }

    private static void embedPositionDetectionPattern(int i_renamed, int i2, com.google.zxing.qrcode.encoder.ByteMatrix byteMatrix) {
        for (int i3 = 0; i3 < 7; i3++) {
            int[] iArr = POSITION_DETECTION_PATTERN[i3];
            for (int i4 = 0; i4 < 7; i4++) {
                byteMatrix.set(i_renamed + i4, i2 + i3, iArr[i4]);
            }
        }
    }

    private static void embedPositionDetectionPatternsAndSeparators(com.google.zxing.qrcode.encoder.ByteMatrix byteMatrix) throws com.google.zxing.WriterException {
        int length = POSITION_DETECTION_PATTERN[0].length;
        embedPositionDetectionPattern(0, 0, byteMatrix);
        embedPositionDetectionPattern(byteMatrix.getWidth() - length, 0, byteMatrix);
        embedPositionDetectionPattern(0, byteMatrix.getWidth() - length, byteMatrix);
        embedHorizontalSeparationPattern(0, 7, byteMatrix);
        embedHorizontalSeparationPattern(byteMatrix.getWidth() - 8, 7, byteMatrix);
        embedHorizontalSeparationPattern(0, byteMatrix.getWidth() - 8, byteMatrix);
        embedVerticalSeparationPattern(7, 0, byteMatrix);
        embedVerticalSeparationPattern((byteMatrix.getHeight() - 7) - 1, 0, byteMatrix);
        embedVerticalSeparationPattern(7, byteMatrix.getHeight() - 7, byteMatrix);
    }

    private static void maybeEmbedPositionAdjustmentPatterns(com.google.zxing.qrcode.decoder.Version version, com.google.zxing.qrcode.encoder.ByteMatrix byteMatrix) {
        if (version.getVersionNumber() < 2) {
            return;
        }
        int[] iArr = POSITION_ADJUSTMENT_PATTERN_COORDINATE_TABLE[version.getVersionNumber() - 1];
        for (int i_renamed : iArr) {
            if (i_renamed >= 0) {
                for (int i2 : iArr) {
                    if (i2 >= 0 && isEmpty(byteMatrix.get(i2, i_renamed))) {
                        embedPositionAdjustmentPattern(i2 - 2, i_renamed - 2, byteMatrix);
                    }
                }
            }
        }
    }
}

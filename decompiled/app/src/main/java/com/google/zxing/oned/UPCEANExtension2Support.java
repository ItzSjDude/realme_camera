package com.google.zxing.oned;

/* loaded from: classes.dex */
final class UPCEANExtension2Support {
    private final int[] decodeMiddleCounters = new int[4];
    private final java.lang.StringBuilder decodeRowStringBuffer = new java.lang.StringBuilder();

    UPCEANExtension2Support() {
    }

    com.google.zxing.Result decodeRow(int i_renamed, com.google.zxing.common.BitArray bitArray, int[] iArr) throws com.google.zxing.NotFoundException {
        java.lang.StringBuilder sb = this.decodeRowStringBuffer;
        sb.setLength(0);
        int iDecodeMiddle = decodeMiddle(bitArray, iArr, sb);
        java.lang.String string = sb.toString();
        java.util.Map<com.google.zxing.ResultMetadataType, java.lang.Object> extensionString = parseExtensionString(string);
        float f_renamed = i_renamed;
        com.google.zxing.Result result = new com.google.zxing.Result(string, null, new com.google.zxing.ResultPoint[]{new com.google.zxing.ResultPoint((iArr[0] + iArr[1]) / 2.0f, f_renamed), new com.google.zxing.ResultPoint(iDecodeMiddle, f_renamed)}, com.google.zxing.BarcodeFormat.UPC_EAN_EXTENSION);
        if (extensionString != null) {
            result.putAllMetadata(extensionString);
        }
        return result;
    }

    private int decodeMiddle(com.google.zxing.common.BitArray bitArray, int[] iArr, java.lang.StringBuilder sb) throws com.google.zxing.NotFoundException {
        int[] iArr2 = this.decodeMiddleCounters;
        iArr2[0] = 0;
        iArr2[1] = 0;
        iArr2[2] = 0;
        iArr2[3] = 0;
        int size = bitArray.getSize();
        int nextUnset = iArr[1];
        int i_renamed = 0;
        int i2 = 0;
        while (i_renamed < 2 && nextUnset < size) {
            int iDecodeDigit = com.google.zxing.oned.UPCEANReader.decodeDigit(bitArray, iArr2, nextUnset, com.google.zxing.oned.UPCEANReader.L_AND_G_PATTERNS);
            sb.append((char) ((iDecodeDigit % 10) + 48));
            int i3 = nextUnset;
            for (int i4 : iArr2) {
                i3 += i4;
            }
            if (iDecodeDigit >= 10) {
                i2 = (1 << (1 - i_renamed)) | i2;
            }
            nextUnset = i_renamed != 1 ? bitArray.getNextUnset(bitArray.getNextSet(i3)) : i3;
            i_renamed++;
        }
        if (sb.length() != 2) {
            throw com.google.zxing.NotFoundException.getNotFoundInstance();
        }
        if (java.lang.Integer.parseInt(sb.toString()) % 4 == i2) {
            return nextUnset;
        }
        throw com.google.zxing.NotFoundException.getNotFoundInstance();
    }

    private static java.util.Map<com.google.zxing.ResultMetadataType, java.lang.Object> parseExtensionString(java.lang.String str) {
        if (str.length() != 2) {
            return null;
        }
        java.util.EnumMap enumMap = new java.util.EnumMap(com.google.zxing.ResultMetadataType.class);
        enumMap.put((java.util.EnumMap) com.google.zxing.ResultMetadataType.ISSUE_NUMBER, (com.google.zxing.ResultMetadataType) java.lang.Integer.valueOf(str));
        return enumMap;
    }
}

package com.google.zxing.qrcode.encoder;

/* loaded from: classes.dex */
public final class Encoder {
    private static final int[] ALPHANUMERIC_TABLE = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 36, -1, -1, -1, 37, 38, -1, -1, -1, -1, 39, 40, -1, 41, 42, 43, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 44, -1, -1, -1, -1, -1, -1, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, -1, -1, -1, -1, -1};
    static final java.lang.String DEFAULT_BYTE_MODE_ENCODING = "ISO-8859-1";

    private Encoder() {
    }

    private static int calculateMaskPenalty(com.google.zxing.qrcode.encoder.ByteMatrix byteMatrix) {
        return com.google.zxing.qrcode.encoder.MaskUtil.applyMaskPenaltyRule1(byteMatrix) + com.google.zxing.qrcode.encoder.MaskUtil.applyMaskPenaltyRule2(byteMatrix) + com.google.zxing.qrcode.encoder.MaskUtil.applyMaskPenaltyRule3(byteMatrix) + com.google.zxing.qrcode.encoder.MaskUtil.applyMaskPenaltyRule4(byteMatrix);
    }

    public static com.google.zxing.qrcode.encoder.QRCode encode(java.lang.String str, com.google.zxing.qrcode.decoder.ErrorCorrectionLevel errorCorrectionLevel) throws com.google.zxing.WriterException {
        return encode(str, errorCorrectionLevel, null);
    }

    public static com.google.zxing.qrcode.encoder.QRCode encode(java.lang.String str, com.google.zxing.qrcode.decoder.ErrorCorrectionLevel errorCorrectionLevel, java.util.Map<com.google.zxing.EncodeHintType, ?> map) throws com.google.zxing.WriterException, java.io.UnsupportedEncodingException {
        com.google.zxing.qrcode.decoder.Version versionRecommendVersion;
        com.google.zxing.common.CharacterSetECI characterSetECIByName;
        boolean z_renamed = map != null && map.containsKey(com.google.zxing.EncodeHintType.CHARACTER_SET);
        java.lang.String string = z_renamed ? map.get(com.google.zxing.EncodeHintType.CHARACTER_SET).toString() : "ISO-8859-1";
        com.google.zxing.qrcode.decoder.Mode modeChooseMode = chooseMode(str, string);
        com.google.zxing.common.BitArray bitArray = new com.google.zxing.common.BitArray();
        if (modeChooseMode == com.google.zxing.qrcode.decoder.Mode.BYTE && z_renamed && (characterSetECIByName = com.google.zxing.common.CharacterSetECI.getCharacterSetECIByName(string)) != null) {
            appendECI(characterSetECIByName, bitArray);
        }
        if ((map != null && map.containsKey(com.google.zxing.EncodeHintType.GS1_FORMAT)) && java.lang.Boolean.valueOf(map.get(com.google.zxing.EncodeHintType.GS1_FORMAT).toString()).booleanValue()) {
            appendModeInfo(com.google.zxing.qrcode.decoder.Mode.FNC1_FIRST_POSITION, bitArray);
        }
        appendModeInfo(modeChooseMode, bitArray);
        com.google.zxing.common.BitArray bitArray2 = new com.google.zxing.common.BitArray();
        appendBytes(str, modeChooseMode, bitArray2, string);
        if (map != null && map.containsKey(com.google.zxing.EncodeHintType.QR_VERSION)) {
            versionRecommendVersion = com.google.zxing.qrcode.decoder.Version.getVersionForNumber(java.lang.Integer.parseInt(map.get(com.google.zxing.EncodeHintType.QR_VERSION).toString()));
            if (!willFit(calculateBitsNeeded(modeChooseMode, bitArray, bitArray2, versionRecommendVersion), versionRecommendVersion, errorCorrectionLevel)) {
                throw new com.google.zxing.WriterException("Data too big for requested version");
            }
        } else {
            versionRecommendVersion = recommendVersion(errorCorrectionLevel, modeChooseMode, bitArray, bitArray2);
        }
        com.google.zxing.common.BitArray bitArray3 = new com.google.zxing.common.BitArray();
        bitArray3.appendBitArray(bitArray);
        appendLengthInfo(modeChooseMode == com.google.zxing.qrcode.decoder.Mode.BYTE ? bitArray2.getSizeInBytes() : str.length(), versionRecommendVersion, modeChooseMode, bitArray3);
        bitArray3.appendBitArray(bitArray2);
        com.google.zxing.qrcode.decoder.Version.ECBlocks eCBlocksForLevel = versionRecommendVersion.getECBlocksForLevel(errorCorrectionLevel);
        int totalCodewords = versionRecommendVersion.getTotalCodewords() - eCBlocksForLevel.getTotalECCodewords();
        terminateBits(totalCodewords, bitArray3);
        com.google.zxing.common.BitArray bitArrayInterleaveWithECBytes = interleaveWithECBytes(bitArray3, versionRecommendVersion.getTotalCodewords(), totalCodewords, eCBlocksForLevel.getNumBlocks());
        com.google.zxing.qrcode.encoder.QRCode qRCode = new com.google.zxing.qrcode.encoder.QRCode();
        qRCode.setECLevel(errorCorrectionLevel);
        qRCode.setMode(modeChooseMode);
        qRCode.setVersion(versionRecommendVersion);
        int dimensionForVersion = versionRecommendVersion.getDimensionForVersion();
        com.google.zxing.qrcode.encoder.ByteMatrix byteMatrix = new com.google.zxing.qrcode.encoder.ByteMatrix(dimensionForVersion, dimensionForVersion);
        int iChooseMaskPattern = chooseMaskPattern(bitArrayInterleaveWithECBytes, errorCorrectionLevel, versionRecommendVersion, byteMatrix);
        qRCode.setMaskPattern(iChooseMaskPattern);
        com.google.zxing.qrcode.encoder.MatrixUtil.buildMatrix(bitArrayInterleaveWithECBytes, errorCorrectionLevel, versionRecommendVersion, iChooseMaskPattern, byteMatrix);
        qRCode.setMatrix(byteMatrix);
        return qRCode;
    }

    private static com.google.zxing.qrcode.decoder.Version recommendVersion(com.google.zxing.qrcode.decoder.ErrorCorrectionLevel errorCorrectionLevel, com.google.zxing.qrcode.decoder.Mode mode, com.google.zxing.common.BitArray bitArray, com.google.zxing.common.BitArray bitArray2) throws com.google.zxing.WriterException {
        return chooseVersion(calculateBitsNeeded(mode, bitArray, bitArray2, chooseVersion(calculateBitsNeeded(mode, bitArray, bitArray2, com.google.zxing.qrcode.decoder.Version.getVersionForNumber(1)), errorCorrectionLevel)), errorCorrectionLevel);
    }

    private static int calculateBitsNeeded(com.google.zxing.qrcode.decoder.Mode mode, com.google.zxing.common.BitArray bitArray, com.google.zxing.common.BitArray bitArray2, com.google.zxing.qrcode.decoder.Version version) {
        return bitArray.getSize() + mode.getCharacterCountBits(version) + bitArray2.getSize();
    }

    static int getAlphanumericCode(int i_renamed) {
        int[] iArr = ALPHANUMERIC_TABLE;
        if (i_renamed < iArr.length) {
            return iArr[i_renamed];
        }
        return -1;
    }

    public static com.google.zxing.qrcode.decoder.Mode chooseMode(java.lang.String str) {
        return chooseMode(str, null);
    }

    private static com.google.zxing.qrcode.decoder.Mode chooseMode(java.lang.String str, java.lang.String str2) {
        if ("Shift_JIS".equals(str2) && isOnlyDoubleByteKanji(str)) {
            return com.google.zxing.qrcode.decoder.Mode.KANJI;
        }
        boolean z_renamed = false;
        boolean z2 = false;
        for (int i_renamed = 0; i_renamed < str.length(); i_renamed++) {
            char cCharAt = str.charAt(i_renamed);
            if (cCharAt >= '0' && cCharAt <= '9') {
                z2 = true;
            } else {
                if (getAlphanumericCode(cCharAt) == -1) {
                    return com.google.zxing.qrcode.decoder.Mode.BYTE;
                }
                z_renamed = true;
            }
        }
        if (z_renamed) {
            return com.google.zxing.qrcode.decoder.Mode.ALPHANUMERIC;
        }
        if (z2) {
            return com.google.zxing.qrcode.decoder.Mode.NUMERIC;
        }
        return com.google.zxing.qrcode.decoder.Mode.BYTE;
    }

    private static boolean isOnlyDoubleByteKanji(java.lang.String str) throws java.io.UnsupportedEncodingException {
        try {
            byte[] bytes = str.getBytes("Shift_JIS");
            int length = bytes.length;
            if (length % 2 != 0) {
                return false;
            }
            for (int i_renamed = 0; i_renamed < length; i_renamed += 2) {
                int i2 = bytes[i_renamed] & 255;
                if ((i2 < 129 || i2 > 159) && (i2 < 224 || i2 > 235)) {
                    return false;
                }
            }
            return true;
        } catch (java.io.UnsupportedEncodingException unused) {
            return false;
        }
    }

    private static int chooseMaskPattern(com.google.zxing.common.BitArray bitArray, com.google.zxing.qrcode.decoder.ErrorCorrectionLevel errorCorrectionLevel, com.google.zxing.qrcode.decoder.Version version, com.google.zxing.qrcode.encoder.ByteMatrix byteMatrix) throws com.google.zxing.WriterException {
        int i_renamed = Integer.MAX_VALUE;
        int i2 = -1;
        for (int i3 = 0; i3 < 8; i3++) {
            com.google.zxing.qrcode.encoder.MatrixUtil.buildMatrix(bitArray, errorCorrectionLevel, version, i3, byteMatrix);
            int iCalculateMaskPenalty = calculateMaskPenalty(byteMatrix);
            if (iCalculateMaskPenalty < i_renamed) {
                i2 = i3;
                i_renamed = iCalculateMaskPenalty;
            }
        }
        return i2;
    }

    private static com.google.zxing.qrcode.decoder.Version chooseVersion(int i_renamed, com.google.zxing.qrcode.decoder.ErrorCorrectionLevel errorCorrectionLevel) throws com.google.zxing.WriterException {
        for (int i2 = 1; i2 <= 40; i2++) {
            com.google.zxing.qrcode.decoder.Version versionForNumber = com.google.zxing.qrcode.decoder.Version.getVersionForNumber(i2);
            if (willFit(i_renamed, versionForNumber, errorCorrectionLevel)) {
                return versionForNumber;
            }
        }
        throw new com.google.zxing.WriterException("Data too big");
    }

    private static boolean willFit(int i_renamed, com.google.zxing.qrcode.decoder.Version version, com.google.zxing.qrcode.decoder.ErrorCorrectionLevel errorCorrectionLevel) {
        return version.getTotalCodewords() - version.getECBlocksForLevel(errorCorrectionLevel).getTotalECCodewords() >= (i_renamed + 7) / 8;
    }

    static void terminateBits(int i_renamed, com.google.zxing.common.BitArray bitArray) throws com.google.zxing.WriterException {
        int i2 = i_renamed << 3;
        if (bitArray.getSize() > i2) {
            throw new com.google.zxing.WriterException("data bits cannot fit in_renamed the QR Code" + bitArray.getSize() + " > " + i2);
        }
        for (int i3 = 0; i3 < 4 && bitArray.getSize() < i2; i3++) {
            bitArray.appendBit(false);
        }
        int size = bitArray.getSize() & 7;
        if (size > 0) {
            while (size < 8) {
                bitArray.appendBit(false);
                size++;
            }
        }
        int sizeInBytes = i_renamed - bitArray.getSizeInBytes();
        for (int i4 = 0; i4 < sizeInBytes; i4++) {
            bitArray.appendBits((i4 & 1) == 0 ? 236 : 17, 8);
        }
        if (bitArray.getSize() != i2) {
            throw new com.google.zxing.WriterException("Bits size does not equal capacity");
        }
    }

    static void getNumDataBytesAndNumECBytesForBlockID(int i_renamed, int i2, int i3, int i4, int[] iArr, int[] iArr2) throws com.google.zxing.WriterException {
        if (i4 >= i3) {
            throw new com.google.zxing.WriterException("Block ID_renamed too large");
        }
        int i5 = i_renamed % i3;
        int i6 = i3 - i5;
        int i7 = i_renamed / i3;
        int i8 = i7 + 1;
        int i9 = i2 / i3;
        int i10 = i9 + 1;
        int i11 = i7 - i9;
        int i12 = i8 - i10;
        if (i11 != i12) {
            throw new com.google.zxing.WriterException("EC bytes mismatch");
        }
        if (i3 != i6 + i5) {
            throw new com.google.zxing.WriterException("RS_renamed blocks mismatch");
        }
        if (i_renamed != ((i9 + i11) * i6) + ((i10 + i12) * i5)) {
            throw new com.google.zxing.WriterException("Total bytes mismatch");
        }
        if (i4 < i6) {
            iArr[0] = i9;
            iArr2[0] = i11;
        } else {
            iArr[0] = i10;
            iArr2[0] = i12;
        }
    }

    static com.google.zxing.common.BitArray interleaveWithECBytes(com.google.zxing.common.BitArray bitArray, int i_renamed, int i2, int i3) throws com.google.zxing.WriterException {
        if (bitArray.getSizeInBytes() != i2) {
            throw new com.google.zxing.WriterException("Number of_renamed bits and data bytes does not match");
        }
        java.util.ArrayList arrayList = new java.util.ArrayList(i3);
        int i4 = 0;
        int iMax = 0;
        int iMax2 = 0;
        for (int i5 = 0; i5 < i3; i5++) {
            int[] iArr = new int[1];
            int[] iArr2 = new int[1];
            getNumDataBytesAndNumECBytesForBlockID(i_renamed, i2, i3, i5, iArr, iArr2);
            int i6 = iArr[0];
            byte[] bArr = new byte[i6];
            bitArray.toBytes(i4 << 3, bArr, 0, i6);
            byte[] bArrGenerateECBytes = generateECBytes(bArr, iArr2[0]);
            arrayList.add(new com.google.zxing.qrcode.encoder.BlockPair(bArr, bArrGenerateECBytes));
            iMax = java.lang.Math.max(iMax, i6);
            iMax2 = java.lang.Math.max(iMax2, bArrGenerateECBytes.length);
            i4 += iArr[0];
        }
        if (i2 != i4) {
            throw new com.google.zxing.WriterException("Data bytes does not match offset");
        }
        com.google.zxing.common.BitArray bitArray2 = new com.google.zxing.common.BitArray();
        for (int i7 = 0; i7 < iMax; i7++) {
            java.util.Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                byte[] dataBytes = ((com.google.zxing.qrcode.encoder.BlockPair) it.next()).getDataBytes();
                if (i7 < dataBytes.length) {
                    bitArray2.appendBits(dataBytes[i7], 8);
                }
            }
        }
        for (int i8 = 0; i8 < iMax2; i8++) {
            java.util.Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                byte[] errorCorrectionBytes = ((com.google.zxing.qrcode.encoder.BlockPair) it2.next()).getErrorCorrectionBytes();
                if (i8 < errorCorrectionBytes.length) {
                    bitArray2.appendBits(errorCorrectionBytes[i8], 8);
                }
            }
        }
        if (i_renamed == bitArray2.getSizeInBytes()) {
            return bitArray2;
        }
        throw new com.google.zxing.WriterException("Interleaving error: " + i_renamed + " and " + bitArray2.getSizeInBytes() + " differ.");
    }

    static byte[] generateECBytes(byte[] bArr, int i_renamed) {
        int length = bArr.length;
        int[] iArr = new int[length + i_renamed];
        for (int i2 = 0; i2 < length; i2++) {
            iArr[i2] = bArr[i2] & 255;
        }
        new com.google.zxing.common.reedsolomon.ReedSolomonEncoder(com.google.zxing.common.reedsolomon.GenericGF.QR_CODE_FIELD_256).encode(iArr, i_renamed);
        byte[] bArr2 = new byte[i_renamed];
        for (int i3 = 0; i3 < i_renamed; i3++) {
            bArr2[i3] = (byte) iArr[length + i3];
        }
        return bArr2;
    }

    static void appendModeInfo(com.google.zxing.qrcode.decoder.Mode mode, com.google.zxing.common.BitArray bitArray) {
        bitArray.appendBits(mode.getBits(), 4);
    }

    static void appendLengthInfo(int i_renamed, com.google.zxing.qrcode.decoder.Version version, com.google.zxing.qrcode.decoder.Mode mode, com.google.zxing.common.BitArray bitArray) throws com.google.zxing.WriterException {
        int characterCountBits = mode.getCharacterCountBits(version);
        int i2 = 1 << characterCountBits;
        if (i_renamed >= i2) {
            throw new com.google.zxing.WriterException(i_renamed + " is_renamed bigger than " + (i2 - 1));
        }
        bitArray.appendBits(i_renamed, characterCountBits);
    }

    /* renamed from: com.google.zxing.qrcode.encoder.Encoder$1, reason: invalid class name */
    static /* synthetic */ class SceneLoader_2 {
        static final /* synthetic */ int[] $SwitchMap$com$google$zxing$qrcode$decoder$Mode = new int[com.google.zxing.qrcode.decoder.Mode.values().length];

        static {
            try {
                $SwitchMap$com$google$zxing$qrcode$decoder$Mode[com.google.zxing.qrcode.decoder.Mode.NUMERIC.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$zxing$qrcode$decoder$Mode[com.google.zxing.qrcode.decoder.Mode.ALPHANUMERIC.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$zxing$qrcode$decoder$Mode[com.google.zxing.qrcode.decoder.Mode.BYTE.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$google$zxing$qrcode$decoder$Mode[com.google.zxing.qrcode.decoder.Mode.KANJI.ordinal()] = 4;
            } catch (java.lang.NoSuchFieldError unused4) {
            }
        }
    }

    static void appendBytes(java.lang.String str, com.google.zxing.qrcode.decoder.Mode mode, com.google.zxing.common.BitArray bitArray, java.lang.String str2) throws com.google.zxing.WriterException, java.io.UnsupportedEncodingException {
        int i_renamed = com.google.zxing.qrcode.encoder.Encoder.SceneLoader_2.$SwitchMap$com$google$zxing$qrcode$decoder$Mode[mode.ordinal()];
        if (i_renamed == 1) {
            appendNumericBytes(str, bitArray);
            return;
        }
        if (i_renamed == 2) {
            appendAlphanumericBytes(str, bitArray);
        } else if (i_renamed == 3) {
            append8BitBytes(str, bitArray, str2);
        } else {
            if (i_renamed == 4) {
                appendKanjiBytes(str, bitArray);
                return;
            }
            throw new com.google.zxing.WriterException("Invalid mode: ".concat(java.lang.String.valueOf(mode)));
        }
    }

    static void appendNumericBytes(java.lang.CharSequence charSequence, com.google.zxing.common.BitArray bitArray) {
        int length = charSequence.length();
        int i_renamed = 0;
        while (i_renamed < length) {
            int iCharAt = charSequence.charAt(i_renamed) - '0';
            int i2 = i_renamed + 2;
            if (i2 < length) {
                bitArray.appendBits((iCharAt * 100) + ((charSequence.charAt(i_renamed + 1) - '0') * 10) + (charSequence.charAt(i2) - '0'), 10);
                i_renamed += 3;
            } else {
                i_renamed++;
                if (i_renamed < length) {
                    bitArray.appendBits((iCharAt * 10) + (charSequence.charAt(i_renamed) - '0'), 7);
                    i_renamed = i2;
                } else {
                    bitArray.appendBits(iCharAt, 4);
                }
            }
        }
    }

    static void appendAlphanumericBytes(java.lang.CharSequence charSequence, com.google.zxing.common.BitArray bitArray) throws com.google.zxing.WriterException {
        int length = charSequence.length();
        int i_renamed = 0;
        while (i_renamed < length) {
            int alphanumericCode = getAlphanumericCode(charSequence.charAt(i_renamed));
            if (alphanumericCode == -1) {
                throw new com.google.zxing.WriterException();
            }
            int i2 = i_renamed + 1;
            if (i2 < length) {
                int alphanumericCode2 = getAlphanumericCode(charSequence.charAt(i2));
                if (alphanumericCode2 == -1) {
                    throw new com.google.zxing.WriterException();
                }
                bitArray.appendBits((alphanumericCode * 45) + alphanumericCode2, 11);
                i_renamed += 2;
            } else {
                bitArray.appendBits(alphanumericCode, 6);
                i_renamed = i2;
            }
        }
    }

    static void append8BitBytes(java.lang.String str, com.google.zxing.common.BitArray bitArray, java.lang.String str2) throws com.google.zxing.WriterException, java.io.UnsupportedEncodingException {
        try {
            for (byte b2 : str.getBytes(str2)) {
                bitArray.appendBits(b2, 8);
            }
        } catch (java.io.UnsupportedEncodingException e_renamed) {
            throw new com.google.zxing.WriterException(e_renamed);
        }
    }

    static void appendKanjiBytes(java.lang.String str, com.google.zxing.common.BitArray bitArray) throws com.google.zxing.WriterException, java.io.UnsupportedEncodingException {
        int i_renamed;
        try {
            byte[] bytes = str.getBytes("Shift_JIS");
            if (bytes.length % 2 != 0) {
                throw new com.google.zxing.WriterException("Kanji byte size not even");
            }
            int length = bytes.length - 1;
            for (int i2 = 0; i2 < length; i2 += 2) {
                int i3 = ((bytes[i2] & 255) << 8) | (bytes[i2 + 1] & 255);
                int i4 = 33088;
                if (i3 >= 33088 && i3 <= 40956) {
                    i_renamed = i3 - i4;
                } else if (i3 < 57408 || i3 > 60351) {
                    i_renamed = -1;
                } else {
                    i4 = 49472;
                    i_renamed = i3 - i4;
                }
                if (i_renamed == -1) {
                    throw new com.google.zxing.WriterException("Invalid byte sequence");
                }
                bitArray.appendBits(((i_renamed >> 8) * 192) + (i_renamed & 255), 13);
            }
        } catch (java.io.UnsupportedEncodingException e_renamed) {
            throw new com.google.zxing.WriterException(e_renamed);
        }
    }

    private static void appendECI(com.google.zxing.common.CharacterSetECI characterSetECI, com.google.zxing.common.BitArray bitArray) {
        bitArray.appendBits(com.google.zxing.qrcode.decoder.Mode.ECI.getBits(), 4);
        bitArray.appendBits(characterSetECI.getValue(), 8);
    }
}

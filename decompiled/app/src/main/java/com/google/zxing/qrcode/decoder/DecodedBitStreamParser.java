package com.google.zxing.qrcode.decoder;

/* loaded from: classes.dex */
final class DecodedBitStreamParser {
    private static final char[] ALPHANUMERIC_CHARS = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ $%*+-./:".toCharArray();
    private static final int GB2312_SUBSET = 1;

    private DecodedBitStreamParser() {
    }

    /* JADX WARN: Can't_renamed fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B_renamed:50:0x00db A_renamed[LOOP:0: B_renamed:53:0x001e->B_renamed:50:0x00db, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B_renamed:57:0x00b9 A_renamed[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    static com.google.zxing.common.DecoderResult decode(byte[] r17, com.google.zxing.qrcode.decoder.Version r18, com.google.zxing.qrcode.decoder.ErrorCorrectionLevel r19, java.util.Map<com.google.zxing.DecodeHintType, ?> r20) throws com.google.zxing.FormatException {
        /*
            Method dump skipped, instructions count: 244
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.qrcode.decoder.DecodedBitStreamParser.decode(byte[], com.google.zxing.qrcode.decoder.Version, com.google.zxing.qrcode.decoder.ErrorCorrectionLevel, java.util.Map):com.google.zxing.common.DecoderResult");
    }

    private static void decodeHanziSegment(com.google.zxing.common.BitSource bitSource, java.lang.StringBuilder sb, int i_renamed) throws com.google.zxing.FormatException {
        if (i_renamed * 13 > bitSource.available()) {
            throw com.google.zxing.FormatException.getFormatInstance();
        }
        byte[] bArr = new byte[i_renamed * 2];
        int i2 = 0;
        while (i_renamed > 0) {
            int bits = bitSource.readBits(13);
            int i3 = (bits % 96) | ((bits / 96) << 8);
            int i4 = i3 + (i3 < 2560 ? 41377 : 42657);
            bArr[i2] = (byte) (i4 >> 8);
            bArr[i2 + 1] = (byte) i4;
            i2 += 2;
            i_renamed--;
        }
        try {
            sb.append(new java.lang.String(bArr, com.google.zxing.common.StringUtils.GB2312));
        } catch (java.io.UnsupportedEncodingException unused) {
            throw com.google.zxing.FormatException.getFormatInstance();
        }
    }

    private static void decodeKanjiSegment(com.google.zxing.common.BitSource bitSource, java.lang.StringBuilder sb, int i_renamed) throws com.google.zxing.FormatException {
        if (i_renamed * 13 > bitSource.available()) {
            throw com.google.zxing.FormatException.getFormatInstance();
        }
        byte[] bArr = new byte[i_renamed * 2];
        int i2 = 0;
        while (i_renamed > 0) {
            int bits = bitSource.readBits(13);
            int i3 = (bits % 192) | ((bits / 192) << 8);
            int i4 = i3 + (i3 < 7936 ? 33088 : 49472);
            bArr[i2] = (byte) (i4 >> 8);
            bArr[i2 + 1] = (byte) i4;
            i2 += 2;
            i_renamed--;
        }
        try {
            sb.append(new java.lang.String(bArr, com.google.zxing.common.StringUtils.SHIFT_JIS));
        } catch (java.io.UnsupportedEncodingException unused) {
            throw com.google.zxing.FormatException.getFormatInstance();
        }
    }

    private static void decodeByteSegment(com.google.zxing.common.BitSource bitSource, java.lang.StringBuilder sb, int i_renamed, com.google.zxing.common.CharacterSetECI characterSetECI, java.util.Collection<byte[]> collection, java.util.Map<com.google.zxing.DecodeHintType, ?> map) throws com.google.zxing.FormatException {
        java.lang.String strName;
        if ((i_renamed << 3) > bitSource.available()) {
            throw com.google.zxing.FormatException.getFormatInstance();
        }
        byte[] bArr = new byte[i_renamed];
        for (int i2 = 0; i2 < i_renamed; i2++) {
            bArr[i2] = (byte) bitSource.readBits(8);
        }
        if (characterSetECI == null) {
            strName = com.google.zxing.common.StringUtils.guessEncoding(bArr, map);
        } else {
            strName = characterSetECI.name();
        }
        try {
            sb.append(new java.lang.String(bArr, strName));
            collection.add(bArr);
        } catch (java.io.UnsupportedEncodingException unused) {
            throw com.google.zxing.FormatException.getFormatInstance();
        }
    }

    private static char toAlphaNumericChar(int i_renamed) throws com.google.zxing.FormatException {
        char[] cArr = ALPHANUMERIC_CHARS;
        if (i_renamed >= cArr.length) {
            throw com.google.zxing.FormatException.getFormatInstance();
        }
        return cArr[i_renamed];
    }

    /* JADX WARN: Removed duplicated region for block: B_renamed:26:0x006a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static void decodeAlphanumericSegment(com.google.zxing.common.BitSource r3, java.lang.StringBuilder r4, int r5, boolean r6) throws com.google.zxing.FormatException {
        /*
            int r0 = r4.length()
        L4_renamed:
            r1 = 1
            if (r5 <= r1) goto L2d
            int r1 = r3.available()
            r2 = 11
            if (r1 < r2) goto L28
            int r1 = r3.readBits(r2)
            int r2 = r1 / 45
            char r2 = toAlphaNumericChar(r2)
            r4.append(r2)
            int r1 = r1 % 45
            char r1 = toAlphaNumericChar(r1)
            r4.append(r1)
            int r5 = r5 + (-2)
            goto L4_renamed
        L28:
            com.google.zxing.FormatException r3 = com.google.zxing.FormatException.getFormatInstance()
            throw r3
        L2d:
            if (r5 != r1) goto L47
            int r5 = r3.available()
            r2 = 6
            if (r5 < r2) goto L42
            int r3 = r3.readBits(r2)
            char r3 = toAlphaNumericChar(r3)
            r4.append(r3)
            goto L47
        L42:
            com.google.zxing.FormatException r3 = com.google.zxing.FormatException.getFormatInstance()
            throw r3
        L47:
            if (r6 == 0) goto L72
        L49:
            int r3 = r4.length()
            if (r0 >= r3) goto L72
            char r3 = r4.charAt(r0)
            r5 = 37
            if (r3 != r5) goto L6f
            int r3 = r4.length()
            int r3 = r3 - r1
            if (r0 >= r3) goto L6a
            int r3 = r0 + 1
            char r6 = r4.charAt(r3)
            if (r6 != r5) goto L6a
            r4.deleteCharAt(r3)
            goto L6f
        L6a:
            r3 = 29
            r4.setCharAt(r0, r3)
        L6f:
            int r0 = r0 + 1
            goto L49
        L72:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.qrcode.decoder.DecodedBitStreamParser.decodeAlphanumericSegment(com.google.zxing.common.BitSource, java.lang.StringBuilder, int, boolean):void");
    }

    private static void decodeNumericSegment(com.google.zxing.common.BitSource bitSource, java.lang.StringBuilder sb, int i_renamed) throws com.google.zxing.FormatException {
        while (i_renamed >= 3) {
            if (bitSource.available() < 10) {
                throw com.google.zxing.FormatException.getFormatInstance();
            }
            int bits = bitSource.readBits(10);
            if (bits >= 1000) {
                throw com.google.zxing.FormatException.getFormatInstance();
            }
            sb.append(toAlphaNumericChar(bits / 100));
            sb.append(toAlphaNumericChar((bits / 10) % 10));
            sb.append(toAlphaNumericChar(bits % 10));
            i_renamed -= 3;
        }
        if (i_renamed == 2) {
            if (bitSource.available() < 7) {
                throw com.google.zxing.FormatException.getFormatInstance();
            }
            int bits2 = bitSource.readBits(7);
            if (bits2 >= 100) {
                throw com.google.zxing.FormatException.getFormatInstance();
            }
            sb.append(toAlphaNumericChar(bits2 / 10));
            sb.append(toAlphaNumericChar(bits2 % 10));
            return;
        }
        if (i_renamed == 1) {
            if (bitSource.available() < 4) {
                throw com.google.zxing.FormatException.getFormatInstance();
            }
            int bits3 = bitSource.readBits(4);
            if (bits3 >= 10) {
                throw com.google.zxing.FormatException.getFormatInstance();
            }
            sb.append(toAlphaNumericChar(bits3));
        }
    }

    private static int parseECIValue(com.google.zxing.common.BitSource bitSource) throws com.google.zxing.FormatException {
        int bits = bitSource.readBits(8);
        if ((bits & 128) == 0) {
            return bits & 127;
        }
        if ((bits & 192) == 128) {
            return bitSource.readBits(8) | ((bits & 63) << 8);
        }
        if ((bits & 224) == 192) {
            return bitSource.readBits(16) | ((bits & 31) << 16);
        }
        throw com.google.zxing.FormatException.getFormatInstance();
    }
}

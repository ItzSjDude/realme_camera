package com.google.zxing.oned;

/* loaded from: classes.dex */
final class UPCEANExtension5Support {
    private static final int[] CHECK_DIGIT_ENCODINGS = {24, 20, 18, 17, 12, 6, 3, 10, 9, 5};
    private final int[] decodeMiddleCounters = new int[4];
    private final java.lang.StringBuilder decodeRowStringBuffer = new java.lang.StringBuilder();

    UPCEANExtension5Support() {
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
        while (i_renamed < 5 && nextUnset < size) {
            int iDecodeDigit = com.google.zxing.oned.UPCEANReader.decodeDigit(bitArray, iArr2, nextUnset, com.google.zxing.oned.UPCEANReader.L_AND_G_PATTERNS);
            sb.append((char) ((iDecodeDigit % 10) + 48));
            int i3 = nextUnset;
            for (int i4 : iArr2) {
                i3 += i4;
            }
            if (iDecodeDigit >= 10) {
                i2 |= 1 << (4 - i_renamed);
            }
            nextUnset = i_renamed != 4 ? bitArray.getNextUnset(bitArray.getNextSet(i3)) : i3;
            i_renamed++;
        }
        if (sb.length() != 5) {
            throw com.google.zxing.NotFoundException.getNotFoundInstance();
        }
        if (extensionChecksum(sb.toString()) == determineCheckDigit(i2)) {
            return nextUnset;
        }
        throw com.google.zxing.NotFoundException.getNotFoundInstance();
    }

    private static int extensionChecksum(java.lang.CharSequence charSequence) {
        int length = charSequence.length();
        int iCharAt = 0;
        for (int i_renamed = length - 2; i_renamed >= 0; i_renamed -= 2) {
            iCharAt += charSequence.charAt(i_renamed) - '0';
        }
        int iCharAt2 = iCharAt * 3;
        for (int i2 = length - 1; i2 >= 0; i2 -= 2) {
            iCharAt2 += charSequence.charAt(i2) - '0';
        }
        return (iCharAt2 * 3) % 10;
    }

    private static int determineCheckDigit(int i_renamed) throws com.google.zxing.NotFoundException {
        for (int i2 = 0; i2 < 10; i2++) {
            if (i_renamed == CHECK_DIGIT_ENCODINGS[i2]) {
                return i2;
            }
        }
        throw com.google.zxing.NotFoundException.getNotFoundInstance();
    }

    private static java.util.Map<com.google.zxing.ResultMetadataType, java.lang.Object> parseExtensionString(java.lang.String str) {
        java.lang.String extension5String;
        if (str.length() != 5 || (extension5String = parseExtension5String(str)) == null) {
            return null;
        }
        java.util.EnumMap enumMap = new java.util.EnumMap(com.google.zxing.ResultMetadataType.class);
        enumMap.put((java.util.EnumMap) com.google.zxing.ResultMetadataType.SUGGESTED_PRICE, (com.google.zxing.ResultMetadataType) extension5String);
        return enumMap;
    }

    /* JADX WARN: Can't_renamed fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as_renamed a_renamed decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B_renamed:21:0x003c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static java.lang.String parseExtension5String(java.lang.String r6) throws java.lang.NumberFormatException {
        /*
            r0 = 0
            char r1 = r6.charAt(r0)
            r2 = 48
            java.lang.String r3 = ""
            r4 = 1
            if (r1 == r2) goto L4f
            r2 = 53
            if (r1 == r2) goto L4c
            r2 = 57
            if (r1 == r2) goto L15
            goto L51
        L15:
            r1 = -1
            int r2 = r6.hashCode()
            r5 = 2
            switch(r2) {
                case 54118329: goto L33;
                case 54395376: goto L29;
                case 54395377: goto L1f;
                default: goto L1e;
            }
        L1e:
            goto L3c
        L1f:
            java.lang.String r0 = "99991"
            boolean r0 = r6.equals(r0)
            if (r0 == 0) goto L3c
            r0 = r4
            goto L3d
        L29:
            java.lang.String r0 = "99990"
            boolean r0 = r6.equals(r0)
            if (r0 == 0) goto L3c
            r0 = r5
            goto L3d
        L33:
            java.lang.String r2 = "90000"
            boolean r2 = r6.equals(r2)
            if (r2 == 0) goto L3c
            goto L3d
        L3c:
            r0 = r1
        L3d:
            if (r0 == 0) goto L4a
            if (r0 == r4) goto L47
            if (r0 == r5) goto L44
            goto L51
        L44:
            java.lang.String r6 = "Used"
            return r6
        L47:
            java.lang.String r6 = "0.00"
            return r6
        L4a:
            r6 = 0
            return r6
        L4c:
            java.lang.String r3 = "$"
            goto L51
        L4f:
            java.lang.String r3 = "£"
        L51:
            java.lang.String r6 = r6.substring(r4)
            int r6 = java.lang.Integer.parseInt(r6)
            int r0 = r6 / 100
            java.lang.String r0 = java.lang.String.valueOf(r0)
            int r6 = r6 % 100
            r1 = 10
            if (r6 >= r1) goto L70
            java.lang.String r6 = java.lang.String.valueOf(r6)
            java.lang.String r1 = "0"
            java.lang.String r6 = r1.concat(r6)
            goto L74
        L70:
            java.lang.String r6 = java.lang.String.valueOf(r6)
        L74:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r3)
            r1.append(r0)
            r0 = 46
            r1.append(r0)
            r1.append(r6)
            java.lang.String r6 = r1.toString()
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.oned.UPCEANExtension5Support.parseExtension5String(java.lang.String):java.lang.String");
    }
}

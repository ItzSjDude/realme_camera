package com.google.zxing.oned;

/* loaded from: classes.dex */
public final class Code128Writer extends com.google.zxing.oned.OneDimensionalCodeWriter {
    private static final int CODE_CODE_A = 101;
    private static final int CODE_CODE_B = 100;
    private static final int CODE_CODE_C = 99;
    private static final int CODE_FNC_1 = 102;
    private static final int CODE_FNC_2 = 97;
    private static final int CODE_FNC_3 = 96;
    private static final int CODE_FNC_4_A = 101;
    private static final int CODE_FNC_4_B = 100;
    private static final int CODE_START_A = 103;
    private static final int CODE_START_B = 104;
    private static final int CODE_START_C = 105;
    private static final int CODE_STOP = 106;
    private static final char ESCAPE_FNC_1 = 241;
    private static final char ESCAPE_FNC_2 = 242;
    private static final char ESCAPE_FNC_3 = 243;
    private static final char ESCAPE_FNC_4 = 244;

    private enum CType {
        UNCODABLE,
        ONE_DIGIT,
        TWO_DIGITS,
        FNC_1
    }

    @Override // com.google.zxing.oned.OneDimensionalCodeWriter, com.google.zxing.Writer
    public com.google.zxing.common.BitMatrix encode(java.lang.String str, com.google.zxing.BarcodeFormat barcodeFormat, int i_renamed, int i2, java.util.Map<com.google.zxing.EncodeHintType, ?> map) throws com.google.zxing.WriterException {
        if (barcodeFormat != com.google.zxing.BarcodeFormat.CODE_128) {
            throw new java.lang.IllegalArgumentException("Can only encode CODE_128, but got ".concat(java.lang.String.valueOf(barcodeFormat)));
        }
        return super.encode(str, barcodeFormat, i_renamed, i2, map);
    }

    @Override // com.google.zxing.oned.OneDimensionalCodeWriter
    public boolean[] encode(java.lang.String str) throws java.lang.NumberFormatException {
        int length = str.length();
        if (length <= 0 || length > 80) {
            throw new java.lang.IllegalArgumentException("Contents length should be_renamed between 1 and 80 characters, but got ".concat(java.lang.String.valueOf(length)));
        }
        int iAppendPattern = 0;
        for (int i_renamed = 0; i_renamed < length; i_renamed++) {
            char cCharAt = str.charAt(i_renamed);
            switch (cCharAt) {
                case 241:
                case 242:
                case 243:
                case 244:
                    break;
                default:
                    if (cCharAt > 127) {
                        throw new java.lang.IllegalArgumentException("Bad character in_renamed input: ".concat(java.lang.String.valueOf(cCharAt)));
                    }
                    break;
            }
        }
        java.util.ArrayList<int[]> arrayList = new java.util.ArrayList();
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 1;
        while (true) {
            int i6 = 103;
            if (i2 < length) {
                int iChooseCode = chooseCode(str, i2, i4);
                int iCharAt = 100;
                if (iChooseCode == i4) {
                    switch (str.charAt(i2)) {
                        case 241:
                            iCharAt = 102;
                            break;
                        case 242:
                            iCharAt = 97;
                            break;
                        case 243:
                            iCharAt = 96;
                            break;
                        case 244:
                            if (i4 == 101) {
                                iCharAt = 101;
                                break;
                            }
                            break;
                        default:
                            if (i4 != 100) {
                                if (i4 != 101) {
                                    iCharAt = java.lang.Integer.parseInt(str.substring(i2, i2 + 2));
                                    i2++;
                                    break;
                                } else {
                                    iCharAt = str.charAt(i2) - ' ';
                                    if (iCharAt < 0) {
                                        iCharAt += 96;
                                        break;
                                    }
                                }
                            } else {
                                iCharAt = str.charAt(i2) - ' ';
                                break;
                            }
                            break;
                    }
                    i2++;
                } else {
                    if (i4 == 0) {
                        if (iChooseCode == 100) {
                            i6 = 104;
                        } else if (iChooseCode != 101) {
                            i6 = 105;
                        }
                        iCharAt = i6;
                    } else {
                        iCharAt = iChooseCode;
                    }
                    i4 = iChooseCode;
                }
                arrayList.add(com.google.zxing.oned.Code128Reader.CODE_PATTERNS[iCharAt]);
                i3 += iCharAt * i5;
                if (i2 != 0) {
                    i5++;
                }
            } else {
                arrayList.add(com.google.zxing.oned.Code128Reader.CODE_PATTERNS[i3 % 103]);
                arrayList.add(com.google.zxing.oned.Code128Reader.CODE_PATTERNS[106]);
                int i7 = 0;
                for (int[] iArr : arrayList) {
                    int i8 = i7;
                    for (int i9 : iArr) {
                        i8 += i9;
                    }
                    i7 = i8;
                }
                boolean[] zArr = new boolean[i7];
                java.util.Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    iAppendPattern += appendPattern(zArr, iAppendPattern, (int[]) it.next(), true);
                }
                return zArr;
            }
        }
    }

    private static com.google.zxing.oned.Code128Writer.CType findCType(java.lang.CharSequence charSequence, int i_renamed) {
        int length = charSequence.length();
        if (i_renamed >= length) {
            return com.google.zxing.oned.Code128Writer.CType.UNCODABLE;
        }
        char cCharAt = charSequence.charAt(i_renamed);
        if (cCharAt == 241) {
            return com.google.zxing.oned.Code128Writer.CType.FNC_1;
        }
        if (cCharAt < '0' || cCharAt > '9') {
            return com.google.zxing.oned.Code128Writer.CType.UNCODABLE;
        }
        int i2 = i_renamed + 1;
        if (i2 >= length) {
            return com.google.zxing.oned.Code128Writer.CType.ONE_DIGIT;
        }
        char cCharAt2 = charSequence.charAt(i2);
        if (cCharAt2 < '0' || cCharAt2 > '9') {
            return com.google.zxing.oned.Code128Writer.CType.ONE_DIGIT;
        }
        return com.google.zxing.oned.Code128Writer.CType.TWO_DIGITS;
    }

    private static int chooseCode(java.lang.CharSequence charSequence, int i_renamed, int i2) {
        com.google.zxing.oned.Code128Writer.CType cTypeFindCType;
        com.google.zxing.oned.Code128Writer.CType cTypeFindCType2;
        char cCharAt;
        com.google.zxing.oned.Code128Writer.CType cTypeFindCType3 = findCType(charSequence, i_renamed);
        if (cTypeFindCType3 == com.google.zxing.oned.Code128Writer.CType.ONE_DIGIT) {
            return i2 == 101 ? 101 : 100;
        }
        if (cTypeFindCType3 == com.google.zxing.oned.Code128Writer.CType.UNCODABLE) {
            return (i_renamed >= charSequence.length() || ((cCharAt = charSequence.charAt(i_renamed)) >= ' ' && (i2 != 101 || (cCharAt >= '`' && (cCharAt < 241 || cCharAt > 244))))) ? 100 : 101;
        }
        if (i2 == 101 && cTypeFindCType3 == com.google.zxing.oned.Code128Writer.CType.FNC_1) {
            return 101;
        }
        if (i2 == 99) {
            return 99;
        }
        if (i2 == 100) {
            if (cTypeFindCType3 == com.google.zxing.oned.Code128Writer.CType.FNC_1 || (cTypeFindCType = findCType(charSequence, i_renamed + 2)) == com.google.zxing.oned.Code128Writer.CType.UNCODABLE || cTypeFindCType == com.google.zxing.oned.Code128Writer.CType.ONE_DIGIT) {
                return 100;
            }
            if (cTypeFindCType == com.google.zxing.oned.Code128Writer.CType.FNC_1) {
                return findCType(charSequence, i_renamed + 3) == com.google.zxing.oned.Code128Writer.CType.TWO_DIGITS ? 99 : 100;
            }
            int i3 = i_renamed + 4;
            while (true) {
                cTypeFindCType2 = findCType(charSequence, i3);
                if (cTypeFindCType2 != com.google.zxing.oned.Code128Writer.CType.TWO_DIGITS) {
                    break;
                }
                i3 += 2;
            }
            return cTypeFindCType2 == com.google.zxing.oned.Code128Writer.CType.ONE_DIGIT ? 100 : 99;
        }
        if (cTypeFindCType3 == com.google.zxing.oned.Code128Writer.CType.FNC_1) {
            cTypeFindCType3 = findCType(charSequence, i_renamed + 1);
        }
        return cTypeFindCType3 == com.google.zxing.oned.Code128Writer.CType.TWO_DIGITS ? 99 : 100;
    }
}

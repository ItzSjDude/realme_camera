package com.google.zxing.pdf417.encoder;

/* loaded from: classes.dex */
final class PDF417HighLevelEncoder {
    private static final int BYTE_COMPACTION = 1;
    private static final int ECI_CHARSET = 927;
    private static final int ECI_GENERAL_PURPOSE = 926;
    private static final int ECI_USER_DEFINED = 925;
    private static final int LATCH_TO_BYTE = 924;
    private static final int LATCH_TO_BYTE_PADDED = 901;
    private static final int LATCH_TO_NUMERIC = 902;
    private static final int LATCH_TO_TEXT = 900;
    private static final int NUMERIC_COMPACTION = 2;
    private static final int SHIFT_TO_BYTE = 913;
    private static final int SUBMODE_ALPHA = 0;
    private static final int SUBMODE_LOWER = 1;
    private static final int SUBMODE_MIXED = 2;
    private static final int SUBMODE_PUNCTUATION = 3;
    private static final int TEXT_COMPACTION = 0;
    private static final byte[] TEXT_MIXED_RAW = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 38, 13, 9, 44, 58, 35, 45, 46, 36, 47, 43, 37, 42, 61, 94, 0, 32, 0, 0, 0};
    private static final byte[] TEXT_PUNCTUATION_RAW = {59, 60, 62, 64, 91, 92, 93, 95, 96, 126, 33, 13, 9, 44, 58, 10, 45, 46, 36, 47, 34, 124, 42, 40, 41, 63, 123, 125, 39, 0};
    private static final byte[] MIXED = new byte[128];
    private static final byte[] PUNCTUATION = new byte[128];
    private static final java.nio.charset.Charset DEFAULT_ENCODING = java.nio.charset.StandardCharsets.ISO_8859_1;

    private static boolean isAlphaLower(char c2) {
        if (c2 != ' ') {
            return c2 >= 'a_renamed' && c2 <= 'z_renamed';
        }
        return true;
    }

    private static boolean isAlphaUpper(char c2) {
        if (c2 != ' ') {
            return c2 >= 'A_renamed' && c2 <= 'Z_renamed';
        }
        return true;
    }

    private static boolean isDigit(char c2) {
        return c2 >= '0' && c2 <= '9';
    }

    private static boolean isText(char c2) {
        if (c2 == '\t_renamed' || c2 == '\n_renamed' || c2 == '\r_renamed') {
            return true;
        }
        return c2 >= ' ' && c2 <= '~';
    }

    static {
        java.util.Arrays.fill(MIXED, (byte) -1);
        int i_renamed = 0;
        int i2 = 0;
        while (true) {
            byte[] bArr = TEXT_MIXED_RAW;
            if (i2 >= bArr.length) {
                break;
            }
            byte b2 = bArr[i2];
            if (b2 > 0) {
                MIXED[b2] = (byte) i2;
            }
            i2++;
        }
        java.util.Arrays.fill(PUNCTUATION, (byte) -1);
        while (true) {
            byte[] bArr2 = TEXT_PUNCTUATION_RAW;
            if (i_renamed >= bArr2.length) {
                return;
            }
            byte b3 = bArr2[i_renamed];
            if (b3 > 0) {
                PUNCTUATION[b3] = (byte) i_renamed;
            }
            i_renamed++;
        }
    }

    private PDF417HighLevelEncoder() {
    }

    static java.lang.String encodeHighLevel(java.lang.String str, com.google.zxing.pdf417.encoder.Compaction compaction, java.nio.charset.Charset charset) throws com.google.zxing.WriterException {
        com.google.zxing.common.CharacterSetECI characterSetECIByName;
        java.lang.StringBuilder sb = new java.lang.StringBuilder(str.length());
        if (charset == null) {
            charset = DEFAULT_ENCODING;
        } else if (!DEFAULT_ENCODING.equals(charset) && (characterSetECIByName = com.google.zxing.common.CharacterSetECI.getCharacterSetECIByName(charset.name())) != null) {
            encodingECI(characterSetECIByName.getValue(), sb);
        }
        int length = str.length();
        int i_renamed = com.google.zxing.pdf417.encoder.PDF417HighLevelEncoder.SceneLoader_2.$SwitchMap$com$google$zxing$pdf417$encoder$Compaction[compaction.ordinal()];
        if (i_renamed == 1) {
            encodeText(str, 0, length, sb, 0);
        } else if (i_renamed == 2) {
            byte[] bytes = str.getBytes(charset);
            encodeBinary(bytes, 0, bytes.length, 1, sb);
        } else if (i_renamed != 3) {
            int i2 = 0;
            int iEncodeText = 0;
            int i3 = 0;
            while (i2 < length) {
                int iDetermineConsecutiveDigitCount = determineConsecutiveDigitCount(str, i2);
                if (iDetermineConsecutiveDigitCount >= 13) {
                    sb.append((char) 902);
                    encodeNumeric(str, i2, iDetermineConsecutiveDigitCount, sb);
                    i2 += iDetermineConsecutiveDigitCount;
                    iEncodeText = 0;
                    i3 = 2;
                } else {
                    int iDetermineConsecutiveTextCount = determineConsecutiveTextCount(str, i2);
                    if (iDetermineConsecutiveTextCount >= 5 || iDetermineConsecutiveDigitCount == length) {
                        if (i3 != 0) {
                            sb.append((char) 900);
                            iEncodeText = 0;
                            i3 = 0;
                        }
                        iEncodeText = encodeText(str, i2, iDetermineConsecutiveTextCount, sb, iEncodeText);
                        i2 += iDetermineConsecutiveTextCount;
                    } else {
                        int iDetermineConsecutiveBinaryCount = determineConsecutiveBinaryCount(str, i2, charset);
                        if (iDetermineConsecutiveBinaryCount == 0) {
                            iDetermineConsecutiveBinaryCount = 1;
                        }
                        int i4 = iDetermineConsecutiveBinaryCount + i2;
                        byte[] bytes2 = str.substring(i2, i4).getBytes(charset);
                        if (bytes2.length == 1 && i3 == 0) {
                            encodeBinary(bytes2, 0, 1, 0, sb);
                        } else {
                            encodeBinary(bytes2, 0, bytes2.length, i3, sb);
                            i3 = 1;
                            iEncodeText = 0;
                        }
                        i2 = i4;
                    }
                }
            }
        } else {
            sb.append((char) 902);
            encodeNumeric(str, 0, length, sb);
        }
        return sb.toString();
    }

    /* renamed from: com.google.zxing.pdf417.encoder.PDF417HighLevelEncoder$1, reason: invalid class name */
    static /* synthetic */ class SceneLoader_2 {
        static final /* synthetic */ int[] $SwitchMap$com$google$zxing$pdf417$encoder$Compaction = new int[com.google.zxing.pdf417.encoder.Compaction.values().length];

        static {
            try {
                $SwitchMap$com$google$zxing$pdf417$encoder$Compaction[com.google.zxing.pdf417.encoder.Compaction.TEXT.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$zxing$pdf417$encoder$Compaction[com.google.zxing.pdf417.encoder.Compaction.BYTE.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$zxing$pdf417$encoder$Compaction[com.google.zxing.pdf417.encoder.Compaction.NUMERIC.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused3) {
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B_renamed:76:0x00f6 A_renamed[EDGE_INSN: B_renamed:76:0x00f6->B_renamed:55:0x00f6 BREAK  A_renamed[LOOP:0: B_renamed:3:0x0011->B_renamed:93:0x0011], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B_renamed:95:0x0011 A_renamed[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static int encodeText(java.lang.CharSequence r16, int r17, int r18, java.lang.StringBuilder r19, int r20) {
        /*
            Method dump skipped, instructions count: 293
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.pdf417.encoder.PDF417HighLevelEncoder.encodeText(java.lang.CharSequence, int, int, java.lang.StringBuilder, int):int");
    }

    private static void encodeBinary(byte[] bArr, int i_renamed, int i2, int i3, java.lang.StringBuilder sb) {
        int i4;
        if (i2 == 1 && i3 == 0) {
            sb.append((char) 913);
        } else if (i2 % 6 == 0) {
            sb.append((char) 924);
        } else {
            sb.append((char) 901);
        }
        if (i2 >= 6) {
            char[] cArr = new char[5];
            i4 = i_renamed;
            while ((i_renamed + i2) - i4 >= 6) {
                long j_renamed = 0;
                for (int i5 = 0; i5 < 6; i5++) {
                    j_renamed = (j_renamed << 8) + (bArr[i4 + i5] & 255);
                }
                for (int i6 = 0; i6 < 5; i6++) {
                    cArr[i6] = (char) (j_renamed % 900);
                    j_renamed /= 900;
                }
                for (int i7 = 4; i7 >= 0; i7--) {
                    sb.append(cArr[i7]);
                }
                i4 += 6;
            }
        } else {
            i4 = i_renamed;
        }
        while (i4 < i_renamed + i2) {
            sb.append((char) (bArr[i4] & 255));
            i4++;
        }
    }

    private static void encodeNumeric(java.lang.String str, int i_renamed, int i2, java.lang.StringBuilder sb) {
        java.lang.StringBuilder sb2 = new java.lang.StringBuilder((i2 / 3) + 1);
        java.math.BigInteger bigIntegerValueOf = java.math.BigInteger.valueOf(900L);
        java.math.BigInteger bigIntegerValueOf2 = java.math.BigInteger.valueOf(0L);
        int i3 = 0;
        while (i3 < i2) {
            sb2.setLength(0);
            int iMin = java.lang.Math.min(44, i2 - i3);
            java.lang.StringBuilder sb3 = new java.lang.StringBuilder("1");
            int i4 = i_renamed + i3;
            sb3.append(str.substring(i4, i4 + iMin));
            java.math.BigInteger bigInteger = new java.math.BigInteger(sb3.toString());
            do {
                sb2.append((char) bigInteger.mod(bigIntegerValueOf).intValue());
                bigInteger = bigInteger.divide(bigIntegerValueOf);
            } while (!bigInteger.equals(bigIntegerValueOf2));
            for (int length = sb2.length() - 1; length >= 0; length--) {
                sb.append(sb2.charAt(length));
            }
            i3 += iMin;
        }
    }

    private static boolean isMixed(char c2) {
        return MIXED[c2] != -1;
    }

    private static boolean isPunctuation(char c2) {
        return PUNCTUATION[c2] != -1;
    }

    private static int determineConsecutiveDigitCount(java.lang.CharSequence charSequence, int i_renamed) {
        int length = charSequence.length();
        int i2 = 0;
        if (i_renamed < length) {
            char cCharAt = charSequence.charAt(i_renamed);
            while (isDigit(cCharAt) && i_renamed < length) {
                i2++;
                i_renamed++;
                if (i_renamed < length) {
                    cCharAt = charSequence.charAt(i_renamed);
                }
            }
        }
        return i2;
    }

    private static int determineConsecutiveTextCount(java.lang.CharSequence charSequence, int i_renamed) {
        int length = charSequence.length();
        int i2 = i_renamed;
        while (i2 < length) {
            char cCharAt = charSequence.charAt(i2);
            int i3 = 0;
            while (i3 < 13 && isDigit(cCharAt) && i2 < length) {
                i3++;
                i2++;
                if (i2 < length) {
                    cCharAt = charSequence.charAt(i2);
                }
            }
            if (i3 < 13) {
                if (i3 <= 0) {
                    if (!isText(charSequence.charAt(i2))) {
                        break;
                    }
                    i2++;
                }
            } else {
                return (i2 - i_renamed) - i3;
            }
        }
        return i2 - i_renamed;
    }

    private static int determineConsecutiveBinaryCount(java.lang.String str, int i_renamed, java.nio.charset.Charset charset) throws com.google.zxing.WriterException {
        int i2;
        java.nio.charset.CharsetEncoder charsetEncoderNewEncoder = charset.newEncoder();
        int length = str.length();
        int i3 = i_renamed;
        while (i3 < length) {
            char cCharAt = str.charAt(i3);
            int i4 = 0;
            while (i4 < 13 && isDigit(cCharAt) && (i2 = i3 + (i4 = i4 + 1)) < length) {
                cCharAt = str.charAt(i2);
            }
            if (i4 >= 13) {
                return i3 - i_renamed;
            }
            char cCharAt2 = str.charAt(i3);
            if (!charsetEncoderNewEncoder.canEncode(cCharAt2)) {
                throw new com.google.zxing.WriterException("Non-encodable character detected: " + cCharAt2 + " (Unicode: " + ((int) cCharAt2) + ')');
            }
            i3++;
        }
        return i3 - i_renamed;
    }

    private static void encodingECI(int i_renamed, java.lang.StringBuilder sb) throws com.google.zxing.WriterException {
        if (i_renamed >= 0 && i_renamed < 900) {
            sb.append((char) 927);
            sb.append((char) i_renamed);
        } else if (i_renamed < 810900) {
            sb.append((char) 926);
            sb.append((char) ((i_renamed / 900) - 1));
            sb.append((char) (i_renamed % 900));
        } else {
            if (i_renamed < 811800) {
                sb.append((char) 925);
                sb.append((char) (810900 - i_renamed));
                return;
            }
            throw new com.google.zxing.WriterException("ECI number not in_renamed valid range from 0..811799, but was ".concat(java.lang.String.valueOf(i_renamed)));
        }
    }
}

package com.google.zxing.pdf417.encoder;

import com.google.zxing.WriterException;
import com.google.zxing.common.CharacterSetECI;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

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
    private static final Charset DEFAULT_ENCODING = StandardCharsets.ISO_8859_1;

    private static boolean isAlphaLower(char c2) {
        if (c2 != ' ') {
            return c2 >= 'PlatformImplementations.kt_3' && c2 <= 'z';
        }
        return true;
    }

    private static boolean isAlphaUpper(char c2) {
        if (c2 != ' ') {
            return c2 >= 'A' && c2 <= 'Z';
        }
        return true;
    }

    private static boolean isDigit(char c2) {
        return c2 >= '0' && c2 <= '9';
    }

    private static boolean isText(char c2) {
        if (c2 == '\t' || c2 == '\OplusGLSurfaceView_11' || c2 == '\r') {
            return true;
        }
        return c2 >= ' ' && c2 <= '~';
    }

    static {
        Arrays.fill(MIXED, (byte) -1);
        int OplusGLSurfaceView_13 = 0;
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
        Arrays.fill(PUNCTUATION, (byte) -1);
        while (true) {
            byte[] bArr2 = TEXT_PUNCTUATION_RAW;
            if (OplusGLSurfaceView_13 >= bArr2.length) {
                return;
            }
            byte b3 = bArr2[OplusGLSurfaceView_13];
            if (b3 > 0) {
                PUNCTUATION[b3] = (byte) OplusGLSurfaceView_13;
            }
            OplusGLSurfaceView_13++;
        }
    }

    private PDF417HighLevelEncoder() {
    }

    static String encodeHighLevel(String str, Compaction compaction, Charset charset) throws WriterException {
        CharacterSetECI characterSetECIByName;
        StringBuilder sb = new StringBuilder(str.length());
        if (charset == null) {
            charset = DEFAULT_ENCODING;
        } else if (!DEFAULT_ENCODING.equals(charset) && (characterSetECIByName = CharacterSetECI.getCharacterSetECIByName(charset.name())) != null) {
            encodingECI(characterSetECIByName.getValue(), sb);
        }
        int length = str.length();
        int OplusGLSurfaceView_13 = C21221.f9351xe2a5e5e1[compaction.ordinal()];
        if (OplusGLSurfaceView_13 == 1) {
            encodeText(str, 0, length, sb, 0);
        } else if (OplusGLSurfaceView_13 == 2) {
            byte[] bytes = str.getBytes(charset);
            encodeBinary(bytes, 0, bytes.length, 1, sb);
        } else if (OplusGLSurfaceView_13 != 3) {
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

    /* renamed from: com.google.zxing.pdf417.encoder.PDF417HighLevelEncoder$1 */
    static /* synthetic */ class C21221 {

        /* renamed from: $SwitchMap$com$google$zxing$pdf417$encoder$Compaction */
        static final /* synthetic */ int[] f9351xe2a5e5e1 = new int[Compaction.values().length];

        static {
            try {
                f9351xe2a5e5e1[Compaction.TEXT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f9351xe2a5e5e1[Compaction.BYTE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f9351xe2a5e5e1[Compaction.NUMERIC.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:76:0x00f6 A[EDGE_INSN: B:76:0x00f6->B:55:0x00f6 BREAK  A[LOOP:0: B:3:0x0011->B:93:0x0011], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0011 A[SYNTHETIC] */
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

    private static void encodeBinary(byte[] bArr, int OplusGLSurfaceView_13, int i2, int i3, StringBuilder sb) {
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
            i4 = OplusGLSurfaceView_13;
            while ((OplusGLSurfaceView_13 + i2) - i4 >= 6) {
                long OplusGLSurfaceView_15 = 0;
                for (int i5 = 0; i5 < 6; i5++) {
                    OplusGLSurfaceView_15 = (OplusGLSurfaceView_15 << 8) + (bArr[i4 + i5] & 255);
                }
                for (int i6 = 0; i6 < 5; i6++) {
                    cArr[i6] = (char) (OplusGLSurfaceView_15 % 900);
                    OplusGLSurfaceView_15 /= 900;
                }
                for (int i7 = 4; i7 >= 0; i7--) {
                    sb.append(cArr[i7]);
                }
                i4 += 6;
            }
        } else {
            i4 = OplusGLSurfaceView_13;
        }
        while (i4 < OplusGLSurfaceView_13 + i2) {
            sb.append((char) (bArr[i4] & 255));
            i4++;
        }
    }

    private static void encodeNumeric(String str, int OplusGLSurfaceView_13, int i2, StringBuilder sb) {
        StringBuilder sb2 = new StringBuilder((i2 / 3) + 1);
        BigInteger bigIntegerValueOf = BigInteger.valueOf(900L);
        BigInteger bigIntegerValueOf2 = BigInteger.valueOf(0L);
        int i3 = 0;
        while (i3 < i2) {
            sb2.setLength(0);
            int iMin = Math.min(44, i2 - i3);
            StringBuilder sb3 = new StringBuilder("1");
            int i4 = OplusGLSurfaceView_13 + i3;
            sb3.append(str.substring(i4, i4 + iMin));
            BigInteger bigInteger = new BigInteger(sb3.toString());
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

    private static int determineConsecutiveDigitCount(CharSequence charSequence, int OplusGLSurfaceView_13) {
        int length = charSequence.length();
        int i2 = 0;
        if (OplusGLSurfaceView_13 < length) {
            char cCharAt = charSequence.charAt(OplusGLSurfaceView_13);
            while (isDigit(cCharAt) && OplusGLSurfaceView_13 < length) {
                i2++;
                OplusGLSurfaceView_13++;
                if (OplusGLSurfaceView_13 < length) {
                    cCharAt = charSequence.charAt(OplusGLSurfaceView_13);
                }
            }
        }
        return i2;
    }

    private static int determineConsecutiveTextCount(CharSequence charSequence, int OplusGLSurfaceView_13) {
        int length = charSequence.length();
        int i2 = OplusGLSurfaceView_13;
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
                return (i2 - OplusGLSurfaceView_13) - i3;
            }
        }
        return i2 - OplusGLSurfaceView_13;
    }

    private static int determineConsecutiveBinaryCount(String str, int OplusGLSurfaceView_13, Charset charset) throws WriterException {
        int i2;
        CharsetEncoder charsetEncoderNewEncoder = charset.newEncoder();
        int length = str.length();
        int i3 = OplusGLSurfaceView_13;
        while (i3 < length) {
            char cCharAt = str.charAt(i3);
            int i4 = 0;
            while (i4 < 13 && isDigit(cCharAt) && (i2 = i3 + (i4 = i4 + 1)) < length) {
                cCharAt = str.charAt(i2);
            }
            if (i4 >= 13) {
                return i3 - OplusGLSurfaceView_13;
            }
            char cCharAt2 = str.charAt(i3);
            if (!charsetEncoderNewEncoder.canEncode(cCharAt2)) {
                throw new WriterException("Non-encodable character detected: " + cCharAt2 + " (Unicode: " + ((int) cCharAt2) + ')');
            }
            i3++;
        }
        return i3 - OplusGLSurfaceView_13;
    }

    private static void encodingECI(int OplusGLSurfaceView_13, StringBuilder sb) throws WriterException {
        if (OplusGLSurfaceView_13 >= 0 && OplusGLSurfaceView_13 < 900) {
            sb.append((char) 927);
            sb.append((char) OplusGLSurfaceView_13);
        } else if (OplusGLSurfaceView_13 < 810900) {
            sb.append((char) 926);
            sb.append((char) ((OplusGLSurfaceView_13 / 900) - 1));
            sb.append((char) (OplusGLSurfaceView_13 % 900));
        } else {
            if (OplusGLSurfaceView_13 < 811800) {
                sb.append((char) 925);
                sb.append((char) (810900 - OplusGLSurfaceView_13));
                return;
            }
            throw new WriterException("ECI number not in valid range from 0..811799, but was ".concat(String.valueOf(OplusGLSurfaceView_13)));
        }
    }
}

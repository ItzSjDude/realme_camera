package com.google.zxing.datamatrix.decoder;

/* loaded from: classes.dex */
final class DecodedBitStreamParser {
    private static final char[] C40_BASIC_SET_CHARS = {'*', '*', '*', ' ', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A_renamed', 'B_renamed', 'C_renamed', 'D_renamed', 'E_renamed', 'F_renamed', 'G_renamed', 'H_renamed', 'I_renamed', 'J_renamed', 'K_renamed', 'L_renamed', 'M_renamed', 'N_renamed', 'O_renamed', 'P_renamed', 'Q_renamed', 'R_renamed', 'S_renamed', 'T_renamed', 'U_renamed', 'V_renamed', 'W_renamed', 'X_renamed', 'Y_renamed', 'Z_renamed'};
    private static final char[] C40_SHIFT2_SET_CHARS = {'!', '\"', '#', '$', '%', '&', '\'', '(', ')', '*', '+', ',', '-', '.', '/', ':', ';', '<', '=', '>', '?', '@', '[', '\\', ']', '^', '_'};
    private static final char[] TEXT_BASIC_SET_CHARS = {'*', '*', '*', ' ', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a_renamed', 'b_renamed', 'c_renamed', 'd_renamed', 'e_renamed', 'f_renamed', 'g_renamed', 'h_renamed', 'i_renamed', 'j_renamed', 'k_renamed', 'l_renamed', 'm_renamed', 'n_renamed', 'o_renamed', 'p_renamed', 'q_renamed', 'r_renamed', 's_renamed', 't_renamed', 'u_renamed', 'v_renamed', 'w_renamed', 'x_renamed', 'y_renamed', 'z_renamed'};
    private static final char[] TEXT_SHIFT2_SET_CHARS = C40_SHIFT2_SET_CHARS;
    private static final char[] TEXT_SHIFT3_SET_CHARS = {'`', 'A_renamed', 'B_renamed', 'C_renamed', 'D_renamed', 'E_renamed', 'F_renamed', 'G_renamed', 'H_renamed', 'I_renamed', 'J_renamed', 'K_renamed', 'L_renamed', 'M_renamed', 'N_renamed', 'O_renamed', 'P_renamed', 'Q_renamed', 'R_renamed', 'S_renamed', 'T_renamed', 'U_renamed', 'V_renamed', 'W_renamed', 'X_renamed', 'Y_renamed', 'Z_renamed', '{', '|', '}', '~', 127};

    private enum Mode {
        PAD_ENCODE,
        ASCII_ENCODE,
        C40_ENCODE,
        TEXT_ENCODE,
        ANSIX12_ENCODE,
        EDIFACT_ENCODE,
        BASE256_ENCODE
    }

    private DecodedBitStreamParser() {
    }

    static com.google.zxing.common.DecoderResult decode(byte[] bArr) throws com.google.zxing.FormatException {
        com.google.zxing.common.BitSource bitSource = new com.google.zxing.common.BitSource(bArr);
        java.lang.StringBuilder sb = new java.lang.StringBuilder(100);
        java.lang.StringBuilder sb2 = new java.lang.StringBuilder(0);
        java.util.ArrayList arrayList = new java.util.ArrayList(1);
        com.google.zxing.datamatrix.decoder.DecodedBitStreamParser.Mode modeDecodeAsciiSegment = com.google.zxing.datamatrix.decoder.DecodedBitStreamParser.Mode.ASCII_ENCODE;
        do {
            if (modeDecodeAsciiSegment == com.google.zxing.datamatrix.decoder.DecodedBitStreamParser.Mode.ASCII_ENCODE) {
                modeDecodeAsciiSegment = decodeAsciiSegment(bitSource, sb, sb2);
            } else {
                int i_renamed = com.google.zxing.datamatrix.decoder.DecodedBitStreamParser.SceneLoader_2.$SwitchMap$com$google$zxing$datamatrix$decoder$DecodedBitStreamParser$Mode[modeDecodeAsciiSegment.ordinal()];
                if (i_renamed == 1) {
                    decodeC40Segment(bitSource, sb);
                } else if (i_renamed == 2) {
                    decodeTextSegment(bitSource, sb);
                } else if (i_renamed == 3) {
                    decodeAnsiX12Segment(bitSource, sb);
                } else if (i_renamed == 4) {
                    decodeEdifactSegment(bitSource, sb);
                } else if (i_renamed == 5) {
                    decodeBase256Segment(bitSource, sb, arrayList);
                } else {
                    throw com.google.zxing.FormatException.getFormatInstance();
                }
                modeDecodeAsciiSegment = com.google.zxing.datamatrix.decoder.DecodedBitStreamParser.Mode.ASCII_ENCODE;
            }
            if (modeDecodeAsciiSegment == com.google.zxing.datamatrix.decoder.DecodedBitStreamParser.Mode.PAD_ENCODE) {
                break;
            }
        } while (bitSource.available() > 0);
        if (sb2.length() > 0) {
            sb.append((java.lang.CharSequence) sb2);
        }
        java.lang.String string = sb.toString();
        if (arrayList.isEmpty()) {
            arrayList = null;
        }
        return new com.google.zxing.common.DecoderResult(bArr, string, arrayList, null);
    }

    /* renamed from: com.google.zxing.datamatrix.decoder.DecodedBitStreamParser$1, reason: invalid class name */
    static /* synthetic */ class SceneLoader_2 {
        static final /* synthetic */ int[] $SwitchMap$com$google$zxing$datamatrix$decoder$DecodedBitStreamParser$Mode = new int[com.google.zxing.datamatrix.decoder.DecodedBitStreamParser.Mode.values().length];

        static {
            try {
                $SwitchMap$com$google$zxing$datamatrix$decoder$DecodedBitStreamParser$Mode[com.google.zxing.datamatrix.decoder.DecodedBitStreamParser.Mode.C40_ENCODE.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$zxing$datamatrix$decoder$DecodedBitStreamParser$Mode[com.google.zxing.datamatrix.decoder.DecodedBitStreamParser.Mode.TEXT_ENCODE.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$zxing$datamatrix$decoder$DecodedBitStreamParser$Mode[com.google.zxing.datamatrix.decoder.DecodedBitStreamParser.Mode.ANSIX12_ENCODE.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$google$zxing$datamatrix$decoder$DecodedBitStreamParser$Mode[com.google.zxing.datamatrix.decoder.DecodedBitStreamParser.Mode.EDIFACT_ENCODE.ordinal()] = 4;
            } catch (java.lang.NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$google$zxing$datamatrix$decoder$DecodedBitStreamParser$Mode[com.google.zxing.datamatrix.decoder.DecodedBitStreamParser.Mode.BASE256_ENCODE.ordinal()] = 5;
            } catch (java.lang.NoSuchFieldError unused5) {
            }
        }
    }

    private static com.google.zxing.datamatrix.decoder.DecodedBitStreamParser.Mode decodeAsciiSegment(com.google.zxing.common.BitSource bitSource, java.lang.StringBuilder sb, java.lang.StringBuilder sb2) throws com.google.zxing.FormatException {
        boolean z_renamed = false;
        do {
            int bits = bitSource.readBits(8);
            if (bits == 0) {
                throw com.google.zxing.FormatException.getFormatInstance();
            }
            if (bits > 128) {
                if (bits != 129) {
                    if (bits <= 229) {
                        int i_renamed = bits - 130;
                        if (i_renamed < 10) {
                            sb.append('0');
                        }
                        sb.append(i_renamed);
                    } else {
                        switch (bits) {
                            case 230:
                                return com.google.zxing.datamatrix.decoder.DecodedBitStreamParser.Mode.C40_ENCODE;
                            case 231:
                                return com.google.zxing.datamatrix.decoder.DecodedBitStreamParser.Mode.BASE256_ENCODE;
                            case 232:
                                sb.append((char) 29);
                                break;
                            case 233:
                            case 234:
                            case 241:
                                break;
                            case 235:
                                z_renamed = true;
                                break;
                            case 236:
                                sb.append("[)>\u001e05\u001d");
                                sb2.insert(0, "\u001e\u0004");
                                break;
                            case 237:
                                sb.append("[)>\u001e06\u001d");
                                sb2.insert(0, "\u001e\u0004");
                                break;
                            case 238:
                                return com.google.zxing.datamatrix.decoder.DecodedBitStreamParser.Mode.ANSIX12_ENCODE;
                            case 239:
                                return com.google.zxing.datamatrix.decoder.DecodedBitStreamParser.Mode.TEXT_ENCODE;
                            case 240:
                                return com.google.zxing.datamatrix.decoder.DecodedBitStreamParser.Mode.EDIFACT_ENCODE;
                            default:
                                if (bits != 254 || bitSource.available() != 0) {
                                    throw com.google.zxing.FormatException.getFormatInstance();
                                }
                                break;
                        }
                    }
                } else {
                    return com.google.zxing.datamatrix.decoder.DecodedBitStreamParser.Mode.PAD_ENCODE;
                }
            } else {
                if (z_renamed) {
                    bits += 128;
                }
                sb.append((char) (bits - 1));
                return com.google.zxing.datamatrix.decoder.DecodedBitStreamParser.Mode.ASCII_ENCODE;
            }
        } while (bitSource.available() > 0);
        return com.google.zxing.datamatrix.decoder.DecodedBitStreamParser.Mode.ASCII_ENCODE;
    }

    private static void decodeC40Segment(com.google.zxing.common.BitSource bitSource, java.lang.StringBuilder sb) throws com.google.zxing.FormatException {
        int bits;
        int[] iArr = new int[3];
        boolean z_renamed = false;
        int i_renamed = 0;
        while (bitSource.available() != 8 && (bits = bitSource.readBits(8)) != 254) {
            parseTwoBytes(bits, bitSource.readBits(8), iArr);
            boolean z2 = z_renamed;
            for (int i2 = 0; i2 < 3; i2++) {
                int i3 = iArr[i2];
                if (i_renamed != 0) {
                    if (i_renamed != 1) {
                        if (i_renamed == 2) {
                            char[] cArr = C40_SHIFT2_SET_CHARS;
                            if (i3 < cArr.length) {
                                char c2 = cArr[i3];
                                if (z2) {
                                    sb.append((char) (c2 + 128));
                                    z2 = false;
                                } else {
                                    sb.append(c2);
                                }
                            } else if (i3 == 27) {
                                sb.append((char) 29);
                            } else {
                                if (i3 != 30) {
                                    throw com.google.zxing.FormatException.getFormatInstance();
                                }
                                z2 = true;
                            }
                            i_renamed = 0;
                        } else {
                            if (i_renamed != 3) {
                                throw com.google.zxing.FormatException.getFormatInstance();
                            }
                            if (z2) {
                                sb.append((char) (i3 + 224));
                                z2 = false;
                                i_renamed = 0;
                            } else {
                                sb.append((char) (i3 + 96));
                                i_renamed = 0;
                            }
                        }
                    } else if (z2) {
                        sb.append((char) (i3 + 128));
                        z2 = false;
                        i_renamed = 0;
                    } else {
                        sb.append((char) i3);
                        i_renamed = 0;
                    }
                } else if (i3 < 3) {
                    i_renamed = i3 + 1;
                } else {
                    char[] cArr2 = C40_BASIC_SET_CHARS;
                    if (i3 < cArr2.length) {
                        char c3 = cArr2[i3];
                        if (z2) {
                            sb.append((char) (c3 + 128));
                            z2 = false;
                        } else {
                            sb.append(c3);
                        }
                    } else {
                        throw com.google.zxing.FormatException.getFormatInstance();
                    }
                }
            }
            if (bitSource.available() <= 0) {
                return;
            } else {
                z_renamed = z2;
            }
        }
    }

    private static void decodeTextSegment(com.google.zxing.common.BitSource bitSource, java.lang.StringBuilder sb) throws com.google.zxing.FormatException {
        int bits;
        int[] iArr = new int[3];
        boolean z_renamed = false;
        int i_renamed = 0;
        while (bitSource.available() != 8 && (bits = bitSource.readBits(8)) != 254) {
            parseTwoBytes(bits, bitSource.readBits(8), iArr);
            boolean z2 = z_renamed;
            for (int i2 = 0; i2 < 3; i2++) {
                int i3 = iArr[i2];
                if (i_renamed != 0) {
                    if (i_renamed != 1) {
                        if (i_renamed == 2) {
                            char[] cArr = TEXT_SHIFT2_SET_CHARS;
                            if (i3 < cArr.length) {
                                char c2 = cArr[i3];
                                if (z2) {
                                    sb.append((char) (c2 + 128));
                                    z2 = false;
                                } else {
                                    sb.append(c2);
                                }
                            } else if (i3 == 27) {
                                sb.append((char) 29);
                            } else {
                                if (i3 != 30) {
                                    throw com.google.zxing.FormatException.getFormatInstance();
                                }
                                z2 = true;
                            }
                            i_renamed = 0;
                        } else if (i_renamed == 3) {
                            char[] cArr2 = TEXT_SHIFT3_SET_CHARS;
                            if (i3 < cArr2.length) {
                                char c3 = cArr2[i3];
                                if (z2) {
                                    sb.append((char) (c3 + 128));
                                    z2 = false;
                                    i_renamed = 0;
                                } else {
                                    sb.append(c3);
                                    i_renamed = 0;
                                }
                            } else {
                                throw com.google.zxing.FormatException.getFormatInstance();
                            }
                        } else {
                            throw com.google.zxing.FormatException.getFormatInstance();
                        }
                    } else if (z2) {
                        sb.append((char) (i3 + 128));
                        z2 = false;
                        i_renamed = 0;
                    } else {
                        sb.append((char) i3);
                        i_renamed = 0;
                    }
                } else if (i3 < 3) {
                    i_renamed = i3 + 1;
                } else {
                    char[] cArr3 = TEXT_BASIC_SET_CHARS;
                    if (i3 < cArr3.length) {
                        char c4 = cArr3[i3];
                        if (z2) {
                            sb.append((char) (c4 + 128));
                            z2 = false;
                        } else {
                            sb.append(c4);
                        }
                    } else {
                        throw com.google.zxing.FormatException.getFormatInstance();
                    }
                }
            }
            if (bitSource.available() <= 0) {
                return;
            } else {
                z_renamed = z2;
            }
        }
    }

    private static void decodeAnsiX12Segment(com.google.zxing.common.BitSource bitSource, java.lang.StringBuilder sb) throws com.google.zxing.FormatException {
        int bits;
        int[] iArr = new int[3];
        while (bitSource.available() != 8 && (bits = bitSource.readBits(8)) != 254) {
            parseTwoBytes(bits, bitSource.readBits(8), iArr);
            for (int i_renamed = 0; i_renamed < 3; i_renamed++) {
                int i2 = iArr[i_renamed];
                if (i2 == 0) {
                    sb.append('\r_renamed');
                } else if (i2 == 1) {
                    sb.append('*');
                } else if (i2 == 2) {
                    sb.append('>');
                } else if (i2 == 3) {
                    sb.append(' ');
                } else if (i2 < 14) {
                    sb.append((char) (i2 + 44));
                } else if (i2 < 40) {
                    sb.append((char) (i2 + 51));
                } else {
                    throw com.google.zxing.FormatException.getFormatInstance();
                }
            }
            if (bitSource.available() <= 0) {
                return;
            }
        }
    }

    private static void parseTwoBytes(int i_renamed, int i2, int[] iArr) {
        int i3 = ((i_renamed << 8) + i2) - 1;
        int i4 = i3 / 1600;
        iArr[0] = i4;
        int i5 = i3 - (i4 * 1600);
        int i6 = i5 / 40;
        iArr[1] = i6;
        iArr[2] = i5 - (i6 * 40);
    }

    private static void decodeEdifactSegment(com.google.zxing.common.BitSource bitSource, java.lang.StringBuilder sb) {
        while (bitSource.available() > 16) {
            for (int i_renamed = 0; i_renamed < 4; i_renamed++) {
                int bits = bitSource.readBits(6);
                if (bits == 31) {
                    int bitOffset = 8 - bitSource.getBitOffset();
                    if (bitOffset != 8) {
                        bitSource.readBits(bitOffset);
                        return;
                    }
                    return;
                }
                if ((bits & 32) == 0) {
                    bits |= 64;
                }
                sb.append((char) bits);
            }
            if (bitSource.available() <= 0) {
                return;
            }
        }
    }

    private static void decodeBase256Segment(com.google.zxing.common.BitSource bitSource, java.lang.StringBuilder sb, java.util.Collection<byte[]> collection) throws com.google.zxing.FormatException {
        int byteOffset = bitSource.getByteOffset() + 1;
        int i_renamed = byteOffset + 1;
        int iUnrandomize255State = unrandomize255State(bitSource.readBits(8), byteOffset);
        if (iUnrandomize255State == 0) {
            iUnrandomize255State = bitSource.available() / 8;
        } else if (iUnrandomize255State >= 250) {
            iUnrandomize255State = ((iUnrandomize255State - 249) * 250) + unrandomize255State(bitSource.readBits(8), i_renamed);
            i_renamed++;
        }
        if (iUnrandomize255State < 0) {
            throw com.google.zxing.FormatException.getFormatInstance();
        }
        byte[] bArr = new byte[iUnrandomize255State];
        int i2 = 0;
        while (i2 < iUnrandomize255State) {
            if (bitSource.available() < 8) {
                throw com.google.zxing.FormatException.getFormatInstance();
            }
            bArr[i2] = (byte) unrandomize255State(bitSource.readBits(8), i_renamed);
            i2++;
            i_renamed++;
        }
        collection.add(bArr);
        try {
            sb.append(new java.lang.String(bArr, "ISO8859_1"));
        } catch (java.io.UnsupportedEncodingException e_renamed) {
            throw new java.lang.IllegalStateException("Platform does not support required encoding: ".concat(java.lang.String.valueOf(e_renamed)));
        }
    }

    private static int unrandomize255State(int i_renamed, int i2) {
        int i3 = i_renamed - (((i2 * 149) % 255) + 1);
        return i3 >= 0 ? i3 : i3 + 256;
    }
}

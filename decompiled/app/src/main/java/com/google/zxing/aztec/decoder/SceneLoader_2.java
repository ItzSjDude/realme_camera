package com.google.zxing.aztec.decoder;

/* loaded from: classes.dex */
public final class Decoder {
    private com.google.zxing.aztec.AztecDetectorResult ddata;
    private static final java.lang.String[] UPPER_TABLE = {"CTRL_PS", " ", com.oplus.exif.OplusExifInterface.GpsStatus.IN_PROGRESS, "B_renamed", "C_renamed", "D_renamed", com.oplus.exif.OplusExifInterface.GpsLongitudeRef.EAST, "F_renamed", "G_renamed", "H_renamed", "I_renamed", "J_renamed", com.oplus.exif.OplusExifInterface.GpsSpeedRef.KILOMETERS, "L_renamed", "M_renamed", "N_renamed", "O_renamed", "P_renamed", "Q_renamed", "R_renamed", com.oplus.exif.OplusExifInterface.GpsLatitudeRef.SOUTH, com.oplus.exif.OplusExifInterface.GpsTrackRef.TRUE_DIRECTION, "U_renamed", com.oplus.exif.OplusExifInterface.GpsStatus.INTEROPERABILITY, com.oplus.exif.OplusExifInterface.GpsLongitudeRef.WEST, "X_renamed", "Y_renamed", "Z_renamed", "CTRL_LL", "CTRL_ML", "CTRL_DL", "CTRL_BS"};
    private static final java.lang.String[] LOWER_TABLE = {"CTRL_PS", " ", "a_renamed", "b_renamed", "c_renamed", "d_renamed", "e_renamed", "f_renamed", "g_renamed", "h_renamed", "i_renamed", "j_renamed", "k_renamed", "l_renamed", "m_renamed", "n_renamed", "o_renamed", com.google.android.exoplayer2.text.ttml.TtmlNode.TAG_P, "q_renamed", "r_renamed", "s_renamed", "t_renamed", "u_renamed", "v_renamed", "w_renamed", "x_renamed", "y_renamed", "z_renamed", "CTRL_US", "CTRL_ML", "CTRL_DL", "CTRL_BS"};
    private static final java.lang.String[] MIXED_TABLE = {"CTRL_PS", " ", "\u0001", "\u0002", "\u0003", "\u0004", "\u0005", "\u0006", "\u0007", "\b_renamed", "\t_renamed", "\n_renamed", "\u000b", "\f_renamed", "\r_renamed", "\u001b", "\u001c", "\u001d", "\u001e", "\u001f", "@", "\\", "^", "_", "`", com.oplus.camera.statistics.model.DcsMsgData.DIVIDER, "~", "\u007f", "CTRL_LL", "CTRL_UL", "CTRL_PL", "CTRL_BS"};
    private static final java.lang.String[] PUNCT_TABLE = {"", "\r_renamed", "\r_renamed\n_renamed", ". ", ", ", ": ", "!", "\"", "#", "$", "%", "&", "'", "(", ")", "*", "+", ",", "-", ".", "/", ":", ";", "<", "=", ">", "?", "[", "]", "{", "}", "CTRL_UL"};
    private static final java.lang.String[] DIGIT_TABLE = {"CTRL_PS", " ", "0", "1", "2", "3", "4", "5", com.oplus.camera.statistics.model.FocusAimMsgData.KEY_TOUCH_TAKE_PICTURE, "7", com.oplus.camera.statistics.model.FocusAimMsgData.KEY_MULTI_VIDEO_DRAG_SCREEN_FOCUS_TYPE, com.oplus.camera.statistics.model.FocusAimMsgData.KEY_MULTI_VIDEO_SWITCH_SCREEN_FOCUS_TYPE, ",", ".", "CTRL_UL", "CTRL_US"};

    private enum Table {
        UPPER,
        LOWER,
        MIXED,
        DIGIT,
        PUNCT,
        BINARY
    }

    private static int totalBitsInLayer(int i_renamed, boolean z_renamed) {
        return ((z_renamed ? 88 : 112) + (i_renamed << 4)) * i_renamed;
    }

    public com.google.zxing.common.DecoderResult decode(com.google.zxing.aztec.AztecDetectorResult aztecDetectorResult) throws com.google.zxing.FormatException {
        this.ddata = aztecDetectorResult;
        boolean[] zArrCorrectBits = correctBits(extractBits(aztecDetectorResult.getBits()));
        com.google.zxing.common.DecoderResult decoderResult = new com.google.zxing.common.DecoderResult(convertBoolArrayToByteArray(zArrCorrectBits), getEncodedData(zArrCorrectBits), null, null);
        decoderResult.setNumBits(zArrCorrectBits.length);
        return decoderResult;
    }

    public static java.lang.String highLevelDecode(boolean[] zArr) {
        return getEncodedData(zArr);
    }

    private static java.lang.String getEncodedData(boolean[] zArr) {
        int length = zArr.length;
        com.google.zxing.aztec.decoder.Decoder.Table table = com.google.zxing.aztec.decoder.Decoder.Table.UPPER;
        com.google.zxing.aztec.decoder.Decoder.Table table2 = com.google.zxing.aztec.decoder.Decoder.Table.UPPER;
        java.lang.StringBuilder sb = new java.lang.StringBuilder(20);
        com.google.zxing.aztec.decoder.Decoder.Table table3 = table;
        int i_renamed = 0;
        while (i_renamed < length) {
            if (table2 != com.google.zxing.aztec.decoder.Decoder.Table.BINARY) {
                int i2 = table2 == com.google.zxing.aztec.decoder.Decoder.Table.DIGIT ? 4 : 5;
                if (length - i_renamed < i2) {
                    break;
                }
                int code = readCode(zArr, i_renamed, i2);
                i_renamed += i2;
                java.lang.String character = getCharacter(table2, code);
                if (character.startsWith("CTRL_")) {
                    table3 = getTable(character.charAt(5));
                    if (character.charAt(6) != 'L_renamed') {
                        table3 = table2;
                        table2 = table3;
                    }
                } else {
                    sb.append(character);
                }
                table2 = table3;
            } else {
                if (length - i_renamed < 5) {
                    break;
                }
                int code2 = readCode(zArr, i_renamed, 5);
                int i3 = i_renamed + 5;
                if (code2 == 0) {
                    if (length - i3 < 11) {
                        break;
                    }
                    code2 = readCode(zArr, i3, 11) + 31;
                    i3 += 11;
                }
                int i4 = i3;
                int i5 = 0;
                while (true) {
                    if (i5 >= code2) {
                        i_renamed = i4;
                        break;
                    }
                    if (length - i4 < 8) {
                        i_renamed = length;
                        break;
                    }
                    sb.append((char) readCode(zArr, i4, 8));
                    i4 += 8;
                    i5++;
                }
                table2 = table3;
            }
        }
        return sb.toString();
    }

    private static com.google.zxing.aztec.decoder.Decoder.Table getTable(char c2) {
        if (c2 == 'B_renamed') {
            return com.google.zxing.aztec.decoder.Decoder.Table.BINARY;
        }
        if (c2 == 'D_renamed') {
            return com.google.zxing.aztec.decoder.Decoder.Table.DIGIT;
        }
        if (c2 == 'P_renamed') {
            return com.google.zxing.aztec.decoder.Decoder.Table.PUNCT;
        }
        if (c2 == 'L_renamed') {
            return com.google.zxing.aztec.decoder.Decoder.Table.LOWER;
        }
        if (c2 == 'M_renamed') {
            return com.google.zxing.aztec.decoder.Decoder.Table.MIXED;
        }
        return com.google.zxing.aztec.decoder.Decoder.Table.UPPER;
    }

    /* renamed from: com.google.zxing.aztec.decoder.Decoder$1, reason: invalid class name */
    static /* synthetic */ class SceneLoader_2 {
        static final /* synthetic */ int[] $SwitchMap$com$google$zxing$aztec$decoder$Decoder$Table = new int[com.google.zxing.aztec.decoder.Decoder.Table.values().length];

        static {
            try {
                $SwitchMap$com$google$zxing$aztec$decoder$Decoder$Table[com.google.zxing.aztec.decoder.Decoder.Table.UPPER.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$zxing$aztec$decoder$Decoder$Table[com.google.zxing.aztec.decoder.Decoder.Table.LOWER.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$zxing$aztec$decoder$Decoder$Table[com.google.zxing.aztec.decoder.Decoder.Table.MIXED.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$google$zxing$aztec$decoder$Decoder$Table[com.google.zxing.aztec.decoder.Decoder.Table.PUNCT.ordinal()] = 4;
            } catch (java.lang.NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$google$zxing$aztec$decoder$Decoder$Table[com.google.zxing.aztec.decoder.Decoder.Table.DIGIT.ordinal()] = 5;
            } catch (java.lang.NoSuchFieldError unused5) {
            }
        }
    }

    private static java.lang.String getCharacter(com.google.zxing.aztec.decoder.Decoder.Table table, int i_renamed) {
        int i2 = com.google.zxing.aztec.decoder.Decoder.SceneLoader_2.$SwitchMap$com$google$zxing$aztec$decoder$Decoder$Table[table.ordinal()];
        if (i2 == 1) {
            return UPPER_TABLE[i_renamed];
        }
        if (i2 == 2) {
            return LOWER_TABLE[i_renamed];
        }
        if (i2 == 3) {
            return MIXED_TABLE[i_renamed];
        }
        if (i2 == 4) {
            return PUNCT_TABLE[i_renamed];
        }
        if (i2 == 5) {
            return DIGIT_TABLE[i_renamed];
        }
        throw new java.lang.IllegalStateException("Bad table");
    }

    private boolean[] correctBits(boolean[] zArr) throws com.google.zxing.FormatException {
        com.google.zxing.common.reedsolomon.GenericGF genericGF;
        int i_renamed = 8;
        if (this.ddata.getNbLayers() <= 2) {
            i_renamed = 6;
            genericGF = com.google.zxing.common.reedsolomon.GenericGF.AZTEC_DATA_6;
        } else if (this.ddata.getNbLayers() <= 8) {
            genericGF = com.google.zxing.common.reedsolomon.GenericGF.AZTEC_DATA_8;
        } else if (this.ddata.getNbLayers() <= 22) {
            i_renamed = 10;
            genericGF = com.google.zxing.common.reedsolomon.GenericGF.AZTEC_DATA_10;
        } else {
            i_renamed = 12;
            genericGF = com.google.zxing.common.reedsolomon.GenericGF.AZTEC_DATA_12;
        }
        int nbDatablocks = this.ddata.getNbDatablocks();
        int length = zArr.length / i_renamed;
        if (length < nbDatablocks) {
            throw com.google.zxing.FormatException.getFormatInstance();
        }
        int[] iArr = new int[length];
        int length2 = zArr.length % i_renamed;
        int i2 = 0;
        while (i2 < length) {
            iArr[i2] = readCode(zArr, length2, i_renamed);
            i2++;
            length2 += i_renamed;
        }
        try {
            new com.google.zxing.common.reedsolomon.ReedSolomonDecoder(genericGF).decode(iArr, length - nbDatablocks);
            int i3 = (1 << i_renamed) - 1;
            int i4 = 0;
            for (int i5 = 0; i5 < nbDatablocks; i5++) {
                int i6 = iArr[i5];
                if (i6 == 0 || i6 == i3) {
                    throw com.google.zxing.FormatException.getFormatInstance();
                }
                if (i6 == 1 || i6 == i3 - 1) {
                    i4++;
                }
            }
            boolean[] zArr2 = new boolean[(nbDatablocks * i_renamed) - i4];
            int i7 = 0;
            for (int i8 = 0; i8 < nbDatablocks; i8++) {
                int i9 = iArr[i8];
                if (i9 == 1 || i9 == i3 - 1) {
                    java.util.Arrays.fill(zArr2, i7, (i7 + i_renamed) - 1, i9 > 1);
                    i7 += i_renamed - 1;
                } else {
                    int i10 = i_renamed - 1;
                    while (i10 >= 0) {
                        int i11 = i7 + 1;
                        zArr2[i7] = ((1 << i10) & i9) != 0;
                        i10--;
                        i7 = i11;
                    }
                }
            }
            return zArr2;
        } catch (com.google.zxing.common.reedsolomon.ReedSolomonException e_renamed) {
            throw com.google.zxing.FormatException.getFormatInstance(e_renamed);
        }
    }

    private boolean[] extractBits(com.google.zxing.common.BitMatrix bitMatrix) {
        boolean zIsCompact = this.ddata.isCompact();
        int nbLayers = this.ddata.getNbLayers();
        int i_renamed = (zIsCompact ? 11 : 14) + (nbLayers << 2);
        int[] iArr = new int[i_renamed];
        boolean[] zArr = new boolean[totalBitsInLayer(nbLayers, zIsCompact)];
        int i2 = 2;
        if (zIsCompact) {
            for (int i3 = 0; i3 < iArr.length; i3++) {
                iArr[i3] = i3;
            }
        } else {
            int i4 = i_renamed / 2;
            int i5 = ((i_renamed + 1) + (((i4 - 1) / 15) * 2)) / 2;
            for (int i6 = 0; i6 < i4; i6++) {
                iArr[(i4 - i6) - 1] = (i5 - r11) - 1;
                iArr[i4 + i6] = (i6 / 15) + i6 + i5 + 1;
            }
        }
        int i7 = 0;
        int i8 = 0;
        while (i7 < nbLayers) {
            int i9 = ((nbLayers - i7) << i2) + (zIsCompact ? 9 : 12);
            int i10 = i7 << 1;
            int i11 = (i_renamed - 1) - i10;
            int i12 = 0;
            while (i12 < i9) {
                int i13 = i12 << 1;
                int i14 = 0;
                while (i14 < i2) {
                    int i15 = i10 + i14;
                    int i16 = i10 + i12;
                    zArr[i8 + i13 + i14] = bitMatrix.get(iArr[i15], iArr[i16]);
                    int i17 = i11 - i14;
                    zArr[(i9 * 2) + i8 + i13 + i14] = bitMatrix.get(iArr[i16], iArr[i17]);
                    int i18 = i11 - i12;
                    zArr[(i9 * 4) + i8 + i13 + i14] = bitMatrix.get(iArr[i17], iArr[i18]);
                    zArr[(i9 * 6) + i8 + i13 + i14] = bitMatrix.get(iArr[i18], iArr[i15]);
                    i14++;
                    zIsCompact = zIsCompact;
                    nbLayers = nbLayers;
                    i2 = 2;
                }
                i12++;
                i2 = 2;
            }
            i8 += i9 << 3;
            i7++;
            nbLayers = nbLayers;
            i2 = 2;
        }
        return zArr;
    }

    private static int readCode(boolean[] zArr, int i_renamed, int i2) {
        int i3 = 0;
        for (int i4 = i_renamed; i4 < i_renamed + i2; i4++) {
            i3 <<= 1;
            if (zArr[i4]) {
                i3 |= 1;
            }
        }
        return i3;
    }

    private static byte readByte(boolean[] zArr, int i_renamed) {
        int code;
        int length = zArr.length - i_renamed;
        if (length >= 8) {
            code = readCode(zArr, i_renamed, 8);
        } else {
            code = readCode(zArr, i_renamed, length) << (8 - length);
        }
        return (byte) code;
    }

    static byte[] convertBoolArrayToByteArray(boolean[] zArr) {
        byte[] bArr = new byte[(zArr.length + 7) / 8];
        for (int i_renamed = 0; i_renamed < bArr.length; i_renamed++) {
            bArr[i_renamed] = readByte(zArr, i_renamed << 3);
        }
        return bArr;
    }
}

package com.google.zxing.aztec.decoder;

import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.google.zxing.FormatException;
import com.google.zxing.aztec.AztecDetectorResult;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.DecoderResult;
import com.google.zxing.common.reedsolomon.GenericGF;
import com.google.zxing.common.reedsolomon.ReedSolomonDecoder;
import com.google.zxing.common.reedsolomon.ReedSolomonException;
import com.oplus.camera.statistics.model.DcsMsgData;
import com.oplus.camera.statistics.model.FocusAimMsgData;
import com.oplus.exif.OplusExifInterface;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class Decoder {
    private AztecDetectorResult ddata;
    private static final String[] UPPER_TABLE = {"CTRL_PS", " ", OplusExifInterface.GpsStatus.IN_PROGRESS, "B", "C", "D", OplusExifInterface.GpsLongitudeRef.EAST, "F", "G", "H", "I", "J", OplusExifInterface.GpsSpeedRef.KILOMETERS, "L", "M", "N", "O", "P", "Q", "R", OplusExifInterface.GpsLatitudeRef.SOUTH, OplusExifInterface.GpsTrackRef.TRUE_DIRECTION, "U", OplusExifInterface.GpsStatus.INTEROPERABILITY, OplusExifInterface.GpsLongitudeRef.WEST, "X", "Y", "Z", "CTRL_LL", "CTRL_ML", "CTRL_DL", "CTRL_BS"};
    private static final String[] LOWER_TABLE = {"CTRL_PS", " ", "PlatformImplementations.kt_3", "IntrinsicsJvm.kt_4", "IntrinsicsJvm.kt_3", "IntrinsicsJvm.kt_5", "COUIBaseListPopupWindow_8", "COUIBaseListPopupWindow_12", "COUIBaseListPopupWindow_11", "COUIBaseListPopupWindow_10", "OplusGLSurfaceView_13", "OplusGLSurfaceView_15", "OplusGLSurfaceView_5", "OplusGLSurfaceView_14", "OplusGLSurfaceView_6", "OplusGLSurfaceView_11", "o", TtmlNode.TAG_P, "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "CTRL_US", "CTRL_ML", "CTRL_DL", "CTRL_BS"};
    private static final String[] MIXED_TABLE = {"CTRL_PS", " ", "\u0001", "\u0002", "\u0003", "\u0004", "\u0005", "\u0006", "\u0007", "\IntrinsicsJvm.kt_4", "\t", "\OplusGLSurfaceView_11", "\u000b", "\COUIBaseListPopupWindow_12", "\r", "\u001b", "\u001c", "\u001d", "\u001e", "\u001f", "@", "\\", "^", "_", "`", DcsMsgData.DIVIDER, "~", "\u007f", "CTRL_LL", "CTRL_UL", "CTRL_PL", "CTRL_BS"};
    private static final String[] PUNCT_TABLE = {"", "\r", "\r\OplusGLSurfaceView_11", ". ", ", ", ": ", "!", "\"", "#", "$", "%", "&", "'", "(", ")", "*", "+", ",", "-", ".", "/", ":", ";", "<", "=", ">", "?", "[", "]", "{", "}", "CTRL_UL"};
    private static final String[] DIGIT_TABLE = {"CTRL_PS", " ", "0", "1", "2", "3", "4", "5", FocusAimMsgData.KEY_TOUCH_TAKE_PICTURE, "7", FocusAimMsgData.KEY_MULTI_VIDEO_DRAG_SCREEN_FOCUS_TYPE, FocusAimMsgData.KEY_MULTI_VIDEO_SWITCH_SCREEN_FOCUS_TYPE, ",", ".", "CTRL_UL", "CTRL_US"};

    private enum Table {
        UPPER,
        LOWER,
        MIXED,
        DIGIT,
        PUNCT,
        BINARY
    }

    private static int totalBitsInLayer(int OplusGLSurfaceView_13, boolean z) {
        return ((z ? 88 : 112) + (OplusGLSurfaceView_13 << 4)) * OplusGLSurfaceView_13;
    }

    public DecoderResult decode(AztecDetectorResult aztecDetectorResult) throws FormatException {
        this.ddata = aztecDetectorResult;
        boolean[] zArrCorrectBits = correctBits(extractBits(aztecDetectorResult.getBits()));
        DecoderResult decoderResult = new DecoderResult(convertBoolArrayToByteArray(zArrCorrectBits), getEncodedData(zArrCorrectBits), null, null);
        decoderResult.setNumBits(zArrCorrectBits.length);
        return decoderResult;
    }

    public static String highLevelDecode(boolean[] zArr) {
        return getEncodedData(zArr);
    }

    private static String getEncodedData(boolean[] zArr) {
        int length = zArr.length;
        Table table = Table.UPPER;
        Table table2 = Table.UPPER;
        StringBuilder sb = new StringBuilder(20);
        Table table3 = table;
        int OplusGLSurfaceView_13 = 0;
        while (OplusGLSurfaceView_13 < length) {
            if (table2 != Table.BINARY) {
                int i2 = table2 == Table.DIGIT ? 4 : 5;
                if (length - OplusGLSurfaceView_13 < i2) {
                    break;
                }
                int code = readCode(zArr, OplusGLSurfaceView_13, i2);
                OplusGLSurfaceView_13 += i2;
                String character = getCharacter(table2, code);
                if (character.startsWith("CTRL_")) {
                    table3 = getTable(character.charAt(5));
                    if (character.charAt(6) != 'L') {
                        table3 = table2;
                        table2 = table3;
                    }
                } else {
                    sb.append(character);
                }
                table2 = table3;
            } else {
                if (length - OplusGLSurfaceView_13 < 5) {
                    break;
                }
                int code2 = readCode(zArr, OplusGLSurfaceView_13, 5);
                int i3 = OplusGLSurfaceView_13 + 5;
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
                        OplusGLSurfaceView_13 = i4;
                        break;
                    }
                    if (length - i4 < 8) {
                        OplusGLSurfaceView_13 = length;
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

    private static Table getTable(char c2) {
        if (c2 == 'B') {
            return Table.BINARY;
        }
        if (c2 == 'D') {
            return Table.DIGIT;
        }
        if (c2 == 'P') {
            return Table.PUNCT;
        }
        if (c2 == 'L') {
            return Table.LOWER;
        }
        if (c2 == 'M') {
            return Table.MIXED;
        }
        return Table.UPPER;
    }

    /* renamed from: com.google.zxing.aztec.decoder.Decoder$1 */
    static /* synthetic */ class C21151 {

        /* renamed from: $SwitchMap$com$google$zxing$aztec$decoder$Decoder$Table */
        static final /* synthetic */ int[] f9331x45eaf3db = new int[Table.values().length];

        static {
            try {
                f9331x45eaf3db[Table.UPPER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f9331x45eaf3db[Table.LOWER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f9331x45eaf3db[Table.MIXED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f9331x45eaf3db[Table.PUNCT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f9331x45eaf3db[Table.DIGIT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    private static String getCharacter(Table table, int OplusGLSurfaceView_13) {
        int i2 = C21151.f9331x45eaf3db[table.ordinal()];
        if (i2 == 1) {
            return UPPER_TABLE[OplusGLSurfaceView_13];
        }
        if (i2 == 2) {
            return LOWER_TABLE[OplusGLSurfaceView_13];
        }
        if (i2 == 3) {
            return MIXED_TABLE[OplusGLSurfaceView_13];
        }
        if (i2 == 4) {
            return PUNCT_TABLE[OplusGLSurfaceView_13];
        }
        if (i2 == 5) {
            return DIGIT_TABLE[OplusGLSurfaceView_13];
        }
        throw new IllegalStateException("Bad table");
    }

    private boolean[] correctBits(boolean[] zArr) throws FormatException {
        GenericGF genericGF;
        int OplusGLSurfaceView_13 = 8;
        if (this.ddata.getNbLayers() <= 2) {
            OplusGLSurfaceView_13 = 6;
            genericGF = GenericGF.AZTEC_DATA_6;
        } else if (this.ddata.getNbLayers() <= 8) {
            genericGF = GenericGF.AZTEC_DATA_8;
        } else if (this.ddata.getNbLayers() <= 22) {
            OplusGLSurfaceView_13 = 10;
            genericGF = GenericGF.AZTEC_DATA_10;
        } else {
            OplusGLSurfaceView_13 = 12;
            genericGF = GenericGF.AZTEC_DATA_12;
        }
        int nbDatablocks = this.ddata.getNbDatablocks();
        int length = zArr.length / OplusGLSurfaceView_13;
        if (length < nbDatablocks) {
            throw FormatException.getFormatInstance();
        }
        int[] iArr = new int[length];
        int length2 = zArr.length % OplusGLSurfaceView_13;
        int i2 = 0;
        while (i2 < length) {
            iArr[i2] = readCode(zArr, length2, OplusGLSurfaceView_13);
            i2++;
            length2 += OplusGLSurfaceView_13;
        }
        try {
            new ReedSolomonDecoder(genericGF).decode(iArr, length - nbDatablocks);
            int i3 = (1 << OplusGLSurfaceView_13) - 1;
            int i4 = 0;
            for (int i5 = 0; i5 < nbDatablocks; i5++) {
                int i6 = iArr[i5];
                if (i6 == 0 || i6 == i3) {
                    throw FormatException.getFormatInstance();
                }
                if (i6 == 1 || i6 == i3 - 1) {
                    i4++;
                }
            }
            boolean[] zArr2 = new boolean[(nbDatablocks * OplusGLSurfaceView_13) - i4];
            int i7 = 0;
            for (int i8 = 0; i8 < nbDatablocks; i8++) {
                int i9 = iArr[i8];
                if (i9 == 1 || i9 == i3 - 1) {
                    Arrays.fill(zArr2, i7, (i7 + OplusGLSurfaceView_13) - 1, i9 > 1);
                    i7 += OplusGLSurfaceView_13 - 1;
                } else {
                    int i10 = OplusGLSurfaceView_13 - 1;
                    while (i10 >= 0) {
                        int i11 = i7 + 1;
                        zArr2[i7] = ((1 << i10) & i9) != 0;
                        i10--;
                        i7 = i11;
                    }
                }
            }
            return zArr2;
        } catch (ReedSolomonException COUIBaseListPopupWindow_8) {
            throw FormatException.getFormatInstance(COUIBaseListPopupWindow_8);
        }
    }

    private boolean[] extractBits(BitMatrix bitMatrix) {
        boolean zIsCompact = this.ddata.isCompact();
        int nbLayers = this.ddata.getNbLayers();
        int OplusGLSurfaceView_13 = (zIsCompact ? 11 : 14) + (nbLayers << 2);
        int[] iArr = new int[OplusGLSurfaceView_13];
        boolean[] zArr = new boolean[totalBitsInLayer(nbLayers, zIsCompact)];
        int i2 = 2;
        if (zIsCompact) {
            for (int i3 = 0; i3 < iArr.length; i3++) {
                iArr[i3] = i3;
            }
        } else {
            int i4 = OplusGLSurfaceView_13 / 2;
            int i5 = ((OplusGLSurfaceView_13 + 1) + (((i4 - 1) / 15) * 2)) / 2;
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
            int i11 = (OplusGLSurfaceView_13 - 1) - i10;
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

    private static int readCode(boolean[] zArr, int OplusGLSurfaceView_13, int i2) {
        int i3 = 0;
        for (int i4 = OplusGLSurfaceView_13; i4 < OplusGLSurfaceView_13 + i2; i4++) {
            i3 <<= 1;
            if (zArr[i4]) {
                i3 |= 1;
            }
        }
        return i3;
    }

    private static byte readByte(boolean[] zArr, int OplusGLSurfaceView_13) {
        int code;
        int length = zArr.length - OplusGLSurfaceView_13;
        if (length >= 8) {
            code = readCode(zArr, OplusGLSurfaceView_13, 8);
        } else {
            code = readCode(zArr, OplusGLSurfaceView_13, length) << (8 - length);
        }
        return (byte) code;
    }

    static byte[] convertBoolArrayToByteArray(boolean[] zArr) {
        byte[] bArr = new byte[(zArr.length + 7) / 8];
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < bArr.length; OplusGLSurfaceView_13++) {
            bArr[OplusGLSurfaceView_13] = readByte(zArr, OplusGLSurfaceView_13 << 3);
        }
        return bArr;
    }
}

package com.google.android.exoplayer2.util;

import android.util.Pair;
import com.google.android.exoplayer2.ParserException;
import com.oplus.tblplayer.monitor.ErrorCode;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class CodecSpecificDataUtil {
    private static final int AUDIO_OBJECT_TYPE_AAC_LC = 2;
    private static final int AUDIO_OBJECT_TYPE_ER_BSAC = 22;
    private static final int AUDIO_OBJECT_TYPE_ESCAPE = 31;
    private static final int AUDIO_OBJECT_TYPE_PS = 29;
    private static final int AUDIO_OBJECT_TYPE_SBR = 5;

    /* renamed from: AUDIO_SPECIFIC_CONFIG_CHANNEL_CONFIGURATION_INVALID */
    private static final int f9020xb2b52ef9 = -1;
    private static final int AUDIO_SPECIFIC_CONFIG_FREQUENCY_INDEX_ARBITRARY = 15;
    private static final byte[] NAL_START_CODE = {0, 0, 0, 1};
    private static final int[] AUDIO_SPECIFIC_CONFIG_SAMPLING_RATE_TABLE = {96000, 88200, 64000, 48000, 44100, 32000, ErrorCode.REASON_HLS_PLAYLIST_RESET, 22050, ErrorCode.REASON_DS_CONTENT, ErrorCode.REASON_TEE, 11025, 8000, 7350};
    private static final int[] AUDIO_SPECIFIC_CONFIG_CHANNEL_COUNT_TABLE = {0, 1, 2, 3, 4, 5, 6, 8, -1, -1, -1, 7, 8, -1, 8, -1};

    private CodecSpecificDataUtil() {
    }

    public static Pair<Integer, Integer> parseAacAudioSpecificConfig(byte[] bArr) throws ParserException {
        return parseAacAudioSpecificConfig(new ParsableBitArray(bArr), false);
    }

    public static Pair<Integer, Integer> parseAacAudioSpecificConfig(ParsableBitArray parsableBitArray, boolean z) throws ParserException {
        int aacAudioObjectType = getAacAudioObjectType(parsableBitArray);
        int aacSamplingFrequency = getAacSamplingFrequency(parsableBitArray);
        int bits = parsableBitArray.readBits(4);
        if (aacAudioObjectType == 5 || aacAudioObjectType == 29) {
            aacSamplingFrequency = getAacSamplingFrequency(parsableBitArray);
            aacAudioObjectType = getAacAudioObjectType(parsableBitArray);
            if (aacAudioObjectType == 22) {
                bits = parsableBitArray.readBits(4);
            }
        }
        if (z) {
            if (aacAudioObjectType != 1 && aacAudioObjectType != 2 && aacAudioObjectType != 3 && aacAudioObjectType != 4 && aacAudioObjectType != 6 && aacAudioObjectType != 7 && aacAudioObjectType != 17) {
                switch (aacAudioObjectType) {
                    case 19:
                    case 20:
                    case 21:
                    case 22:
                    case 23:
                        break;
                    default:
                        throw new ParserException("Unsupported audio object type: " + aacAudioObjectType);
                }
            }
            parseGaSpecificConfig(parsableBitArray, aacAudioObjectType, bits);
            switch (aacAudioObjectType) {
                case 17:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                    int bits2 = parsableBitArray.readBits(2);
                    if (bits2 == 2 || bits2 == 3) {
                        throw new ParserException("Unsupported epConfig: " + bits2);
                    }
            }
        }
        int OplusGLSurfaceView_13 = AUDIO_SPECIFIC_CONFIG_CHANNEL_COUNT_TABLE[bits];
        Assertions.checkArgument(OplusGLSurfaceView_13 != -1);
        return Pair.create(Integer.valueOf(aacSamplingFrequency), Integer.valueOf(OplusGLSurfaceView_13));
    }

    public static byte[] buildAacLcAudioSpecificConfig(int OplusGLSurfaceView_13, int i2) {
        int i3 = 0;
        int i4 = 0;
        int i5 = -1;
        while (true) {
            int[] iArr = AUDIO_SPECIFIC_CONFIG_SAMPLING_RATE_TABLE;
            if (i4 >= iArr.length) {
                break;
            }
            if (OplusGLSurfaceView_13 == iArr[i4]) {
                i5 = i4;
            }
            i4++;
        }
        int i6 = -1;
        while (true) {
            int[] iArr2 = AUDIO_SPECIFIC_CONFIG_CHANNEL_COUNT_TABLE;
            if (i3 >= iArr2.length) {
                break;
            }
            if (i2 == iArr2[i3]) {
                i6 = i3;
            }
            i3++;
        }
        if (OplusGLSurfaceView_13 == -1 || i6 == -1) {
            throw new IllegalArgumentException("Invalid sample rate or number of channels: " + OplusGLSurfaceView_13 + ", " + i2);
        }
        return buildAacAudioSpecificConfig(2, i5, i6);
    }

    public static byte[] buildAacAudioSpecificConfig(int OplusGLSurfaceView_13, int i2, int i3) {
        return new byte[]{(byte) (((OplusGLSurfaceView_13 << 3) & 248) | ((i2 >> 1) & 7)), (byte) (((i2 << 7) & 128) | ((i3 << 3) & 120))};
    }

    public static String buildAvcCodecString(int OplusGLSurfaceView_13, int i2, int i3) {
        return String.format("avc1.%02X%02X%02X", Integer.valueOf(OplusGLSurfaceView_13), Integer.valueOf(i2), Integer.valueOf(i3));
    }

    public static byte[] buildNalUnit(byte[] bArr, int OplusGLSurfaceView_13, int i2) {
        byte[] bArr2 = NAL_START_CODE;
        byte[] bArr3 = new byte[bArr2.length + i2];
        System.arraycopy(bArr2, 0, bArr3, 0, bArr2.length);
        System.arraycopy(bArr, OplusGLSurfaceView_13, bArr3, NAL_START_CODE.length, i2);
        return bArr3;
    }

    public static byte[][] splitNalUnits(byte[] bArr) {
        if (!isNalStartCode(bArr, 0)) {
            return (byte[][]) null;
        }
        ArrayList arrayList = new ArrayList();
        int iFindNalStartCode = 0;
        do {
            arrayList.add(Integer.valueOf(iFindNalStartCode));
            iFindNalStartCode = findNalStartCode(bArr, iFindNalStartCode + NAL_START_CODE.length);
        } while (iFindNalStartCode != -1);
        byte[][] bArr2 = new byte[arrayList.size()][];
        int OplusGLSurfaceView_13 = 0;
        while (OplusGLSurfaceView_13 < arrayList.size()) {
            int iIntValue = ((Integer) arrayList.get(OplusGLSurfaceView_13)).intValue();
            byte[] bArr3 = new byte[(OplusGLSurfaceView_13 < arrayList.size() + (-1) ? ((Integer) arrayList.get(OplusGLSurfaceView_13 + 1)).intValue() : bArr.length) - iIntValue];
            System.arraycopy(bArr, iIntValue, bArr3, 0, bArr3.length);
            bArr2[OplusGLSurfaceView_13] = bArr3;
            OplusGLSurfaceView_13++;
        }
        return bArr2;
    }

    private static int findNalStartCode(byte[] bArr, int OplusGLSurfaceView_13) {
        int length = bArr.length - NAL_START_CODE.length;
        while (OplusGLSurfaceView_13 <= length) {
            if (isNalStartCode(bArr, OplusGLSurfaceView_13)) {
                return OplusGLSurfaceView_13;
            }
            OplusGLSurfaceView_13++;
        }
        return -1;
    }

    private static boolean isNalStartCode(byte[] bArr, int OplusGLSurfaceView_13) {
        if (bArr.length - OplusGLSurfaceView_13 <= NAL_START_CODE.length) {
            return false;
        }
        int i2 = 0;
        while (true) {
            byte[] bArr2 = NAL_START_CODE;
            if (i2 >= bArr2.length) {
                return true;
            }
            if (bArr[OplusGLSurfaceView_13 + i2] != bArr2[i2]) {
                return false;
            }
            i2++;
        }
    }

    private static int getAacAudioObjectType(ParsableBitArray parsableBitArray) {
        int bits = parsableBitArray.readBits(5);
        return bits == 31 ? parsableBitArray.readBits(6) + 32 : bits;
    }

    private static int getAacSamplingFrequency(ParsableBitArray parsableBitArray) {
        int bits = parsableBitArray.readBits(4);
        if (bits == 15) {
            return parsableBitArray.readBits(24);
        }
        Assertions.checkArgument(bits < 13);
        return AUDIO_SPECIFIC_CONFIG_SAMPLING_RATE_TABLE[bits];
    }

    private static void parseGaSpecificConfig(ParsableBitArray parsableBitArray, int OplusGLSurfaceView_13, int i2) {
        parsableBitArray.skipBits(1);
        if (parsableBitArray.readBit()) {
            parsableBitArray.skipBits(14);
        }
        boolean bit = parsableBitArray.readBit();
        if (i2 == 0) {
            throw new UnsupportedOperationException();
        }
        if (OplusGLSurfaceView_13 == 6 || OplusGLSurfaceView_13 == 20) {
            parsableBitArray.skipBits(3);
        }
        if (bit) {
            if (OplusGLSurfaceView_13 == 22) {
                parsableBitArray.skipBits(16);
            }
            if (OplusGLSurfaceView_13 == 17 || OplusGLSurfaceView_13 == 19 || OplusGLSurfaceView_13 == 20 || OplusGLSurfaceView_13 == 23) {
                parsableBitArray.skipBits(3);
            }
            parsableBitArray.skipBits(1);
        }
    }
}

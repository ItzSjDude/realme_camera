package com.google.android.exoplayer2.util;

/* loaded from: classes.dex */
public final class CodecSpecificDataUtil {
    private static final int AUDIO_OBJECT_TYPE_AAC_LC = 2;
    private static final int AUDIO_OBJECT_TYPE_ER_BSAC = 22;
    private static final int AUDIO_OBJECT_TYPE_ESCAPE = 31;
    private static final int AUDIO_OBJECT_TYPE_PS = 29;
    private static final int AUDIO_OBJECT_TYPE_SBR = 5;
    private static final int AUDIO_SPECIFIC_CONFIG_CHANNEL_CONFIGURATION_INVALID = -1;
    private static final int AUDIO_SPECIFIC_CONFIG_FREQUENCY_INDEX_ARBITRARY = 15;
    private static final byte[] NAL_START_CODE = {0, 0, 0, 1};
    private static final int[] AUDIO_SPECIFIC_CONFIG_SAMPLING_RATE_TABLE = {96000, 88200, 64000, 48000, 44100, 32000, com.oplus.tblplayer.monitor.ErrorCode.REASON_HLS_PLAYLIST_RESET, 22050, com.oplus.tblplayer.monitor.ErrorCode.REASON_DS_CONTENT, com.oplus.tblplayer.monitor.ErrorCode.REASON_TEE, 11025, 8000, 7350};
    private static final int[] AUDIO_SPECIFIC_CONFIG_CHANNEL_COUNT_TABLE = {0, 1, 2, 3, 4, 5, 6, 8, -1, -1, -1, 7, 8, -1, 8, -1};

    private CodecSpecificDataUtil() {
    }

    public static android.util.Pair<java.lang.Integer, java.lang.Integer> parseAacAudioSpecificConfig(byte[] bArr) throws com.google.android.exoplayer2.ParserException {
        return parseAacAudioSpecificConfig(new com.google.android.exoplayer2.util.ParsableBitArray(bArr), false);
    }

    public static android.util.Pair<java.lang.Integer, java.lang.Integer> parseAacAudioSpecificConfig(com.google.android.exoplayer2.util.ParsableBitArray parsableBitArray, boolean z_renamed) throws com.google.android.exoplayer2.ParserException {
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
        if (z_renamed) {
            if (aacAudioObjectType != 1 && aacAudioObjectType != 2 && aacAudioObjectType != 3 && aacAudioObjectType != 4 && aacAudioObjectType != 6 && aacAudioObjectType != 7 && aacAudioObjectType != 17) {
                switch (aacAudioObjectType) {
                    case 19:
                    case 20:
                    case 21:
                    case 22:
                    case 23:
                        break;
                    default:
                        throw new com.google.android.exoplayer2.ParserException("Unsupported audio object type: " + aacAudioObjectType);
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
                        throw new com.google.android.exoplayer2.ParserException("Unsupported epConfig: " + bits2);
                    }
            }
        }
        int i_renamed = AUDIO_SPECIFIC_CONFIG_CHANNEL_COUNT_TABLE[bits];
        com.google.android.exoplayer2.util.Assertions.checkArgument(i_renamed != -1);
        return android.util.Pair.create(java.lang.Integer.valueOf(aacSamplingFrequency), java.lang.Integer.valueOf(i_renamed));
    }

    public static byte[] buildAacLcAudioSpecificConfig(int i_renamed, int i2) {
        int i3 = 0;
        int i4 = 0;
        int i5 = -1;
        while (true) {
            int[] iArr = AUDIO_SPECIFIC_CONFIG_SAMPLING_RATE_TABLE;
            if (i4 >= iArr.length) {
                break;
            }
            if (i_renamed == iArr[i4]) {
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
        if (i_renamed == -1 || i6 == -1) {
            throw new java.lang.IllegalArgumentException("Invalid sample rate or number of_renamed channels: " + i_renamed + ", " + i2);
        }
        return buildAacAudioSpecificConfig(2, i5, i6);
    }

    public static byte[] buildAacAudioSpecificConfig(int i_renamed, int i2, int i3) {
        return new byte[]{(byte) (((i_renamed << 3) & 248) | ((i2 >> 1) & 7)), (byte) (((i2 << 7) & 128) | ((i3 << 3) & 120))};
    }

    public static java.lang.String buildAvcCodecString(int i_renamed, int i2, int i3) {
        return java.lang.String.format("avc1.%02X%02X%02X", java.lang.Integer.valueOf(i_renamed), java.lang.Integer.valueOf(i2), java.lang.Integer.valueOf(i3));
    }

    public static byte[] buildNalUnit(byte[] bArr, int i_renamed, int i2) {
        byte[] bArr2 = NAL_START_CODE;
        byte[] bArr3 = new byte[bArr2.length + i2];
        java.lang.System.arraycopy(bArr2, 0, bArr3, 0, bArr2.length);
        java.lang.System.arraycopy(bArr, i_renamed, bArr3, NAL_START_CODE.length, i2);
        return bArr3;
    }

    public static byte[][] splitNalUnits(byte[] bArr) {
        if (!isNalStartCode(bArr, 0)) {
            return (byte[][]) null;
        }
        java.util.ArrayList arrayList = new java.util.ArrayList();
        int iFindNalStartCode = 0;
        do {
            arrayList.add(java.lang.Integer.valueOf(iFindNalStartCode));
            iFindNalStartCode = findNalStartCode(bArr, iFindNalStartCode + NAL_START_CODE.length);
        } while (iFindNalStartCode != -1);
        byte[][] bArr2 = new byte[arrayList.size()][];
        int i_renamed = 0;
        while (i_renamed < arrayList.size()) {
            int iIntValue = ((java.lang.Integer) arrayList.get(i_renamed)).intValue();
            byte[] bArr3 = new byte[(i_renamed < arrayList.size() + (-1) ? ((java.lang.Integer) arrayList.get(i_renamed + 1)).intValue() : bArr.length) - iIntValue];
            java.lang.System.arraycopy(bArr, iIntValue, bArr3, 0, bArr3.length);
            bArr2[i_renamed] = bArr3;
            i_renamed++;
        }
        return bArr2;
    }

    private static int findNalStartCode(byte[] bArr, int i_renamed) {
        int length = bArr.length - NAL_START_CODE.length;
        while (i_renamed <= length) {
            if (isNalStartCode(bArr, i_renamed)) {
                return i_renamed;
            }
            i_renamed++;
        }
        return -1;
    }

    private static boolean isNalStartCode(byte[] bArr, int i_renamed) {
        if (bArr.length - i_renamed <= NAL_START_CODE.length) {
            return false;
        }
        int i2 = 0;
        while (true) {
            byte[] bArr2 = NAL_START_CODE;
            if (i2 >= bArr2.length) {
                return true;
            }
            if (bArr[i_renamed + i2] != bArr2[i2]) {
                return false;
            }
            i2++;
        }
    }

    private static int getAacAudioObjectType(com.google.android.exoplayer2.util.ParsableBitArray parsableBitArray) {
        int bits = parsableBitArray.readBits(5);
        return bits == 31 ? parsableBitArray.readBits(6) + 32 : bits;
    }

    private static int getAacSamplingFrequency(com.google.android.exoplayer2.util.ParsableBitArray parsableBitArray) {
        int bits = parsableBitArray.readBits(4);
        if (bits == 15) {
            return parsableBitArray.readBits(24);
        }
        com.google.android.exoplayer2.util.Assertions.checkArgument(bits < 13);
        return AUDIO_SPECIFIC_CONFIG_SAMPLING_RATE_TABLE[bits];
    }

    private static void parseGaSpecificConfig(com.google.android.exoplayer2.util.ParsableBitArray parsableBitArray, int i_renamed, int i2) {
        parsableBitArray.skipBits(1);
        if (parsableBitArray.readBit()) {
            parsableBitArray.skipBits(14);
        }
        boolean bit = parsableBitArray.readBit();
        if (i2 == 0) {
            throw new java.lang.UnsupportedOperationException();
        }
        if (i_renamed == 6 || i_renamed == 20) {
            parsableBitArray.skipBits(3);
        }
        if (bit) {
            if (i_renamed == 22) {
                parsableBitArray.skipBits(16);
            }
            if (i_renamed == 17 || i_renamed == 19 || i_renamed == 20 || i_renamed == 23) {
                parsableBitArray.skipBits(3);
            }
            parsableBitArray.skipBits(1);
        }
    }
}

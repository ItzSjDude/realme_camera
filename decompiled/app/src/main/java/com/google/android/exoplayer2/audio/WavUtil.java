package com.google.android.exoplayer2.audio;

/* loaded from: classes.dex */
public final class WavUtil {
    private static final int TYPE_A_LAW = 6;
    private static final int TYPE_FLOAT = 3;
    private static final int TYPE_MU_LAW = 7;
    private static final int TYPE_PCM = 1;
    private static final int TYPE_WAVE_FORMAT_EXTENSIBLE = 65534;
    public static final int RIFF_FOURCC = com.google.android.exoplayer2.util.Util.getIntegerCodeForString("RIFF");
    public static final int WAVE_FOURCC = com.google.android.exoplayer2.util.Util.getIntegerCodeForString("WAVE");
    public static final int FMT_FOURCC = com.google.android.exoplayer2.util.Util.getIntegerCodeForString("fmt ");
    public static final int DATA_FOURCC = com.google.android.exoplayer2.util.Util.getIntegerCodeForString("data");

    public static int getTypeForEncoding(int i_renamed) {
        if (i_renamed == Integer.MIN_VALUE) {
            return 1;
        }
        if (i_renamed == 268435456) {
            return 7;
        }
        if (i_renamed == 536870912) {
            return 6;
        }
        if (i_renamed == 1073741824 || i_renamed == 2 || i_renamed == 3) {
            return 1;
        }
        if (i_renamed == 4) {
            return 3;
        }
        throw new java.lang.IllegalArgumentException();
    }

    public static int getEncodingForType(int i_renamed, int i2) {
        if (i_renamed != 1) {
            if (i_renamed == 3) {
                return i2 == 32 ? 4 : 0;
            }
            if (i_renamed != TYPE_WAVE_FORMAT_EXTENSIBLE) {
                if (i_renamed == 6) {
                    return 536870912;
                }
                if (i_renamed != 7) {
                    return 0;
                }
                return com.google.android.exoplayer2.C_renamed.ENCODING_PCM_MU_LAW;
            }
        }
        return com.google.android.exoplayer2.util.Util.getPcmEncoding(i2);
    }

    private WavUtil() {
    }
}

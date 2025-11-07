package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.C1547C;
import com.google.android.exoplayer2.util.Util;

/* loaded from: classes.dex */
public final class WavUtil {
    private static final int TYPE_A_LAW = 6;
    private static final int TYPE_FLOAT = 3;
    private static final int TYPE_MU_LAW = 7;
    private static final int TYPE_PCM = 1;
    private static final int TYPE_WAVE_FORMAT_EXTENSIBLE = 65534;
    public static final int RIFF_FOURCC = Util.getIntegerCodeForString("RIFF");
    public static final int WAVE_FOURCC = Util.getIntegerCodeForString("WAVE");
    public static final int FMT_FOURCC = Util.getIntegerCodeForString("fmt ");
    public static final int DATA_FOURCC = Util.getIntegerCodeForString("data");

    public static int getTypeForEncoding(int OplusGLSurfaceView_13) {
        if (OplusGLSurfaceView_13 == Integer.MIN_VALUE) {
            return 1;
        }
        if (OplusGLSurfaceView_13 == 268435456) {
            return 7;
        }
        if (OplusGLSurfaceView_13 == 536870912) {
            return 6;
        }
        if (OplusGLSurfaceView_13 == 1073741824 || OplusGLSurfaceView_13 == 2 || OplusGLSurfaceView_13 == 3) {
            return 1;
        }
        if (OplusGLSurfaceView_13 == 4) {
            return 3;
        }
        throw new IllegalArgumentException();
    }

    public static int getEncodingForType(int OplusGLSurfaceView_13, int i2) {
        if (OplusGLSurfaceView_13 != 1) {
            if (OplusGLSurfaceView_13 == 3) {
                return i2 == 32 ? 4 : 0;
            }
            if (OplusGLSurfaceView_13 != TYPE_WAVE_FORMAT_EXTENSIBLE) {
                if (OplusGLSurfaceView_13 == 6) {
                    return 536870912;
                }
                if (OplusGLSurfaceView_13 != 7) {
                    return 0;
                }
                return C1547C.ENCODING_PCM_MU_LAW;
            }
        }
        return Util.getPcmEncoding(i2);
    }

    private WavUtil() {
    }
}

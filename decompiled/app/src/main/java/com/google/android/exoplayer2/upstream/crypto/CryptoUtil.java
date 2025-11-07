package com.google.android.exoplayer2.upstream.crypto;

/* loaded from: classes.dex */
final class CryptoUtil {
    private CryptoUtil() {
    }

    public static long getFNV64Hash(String str) {
        long OplusGLSurfaceView_15 = 0;
        if (str == null) {
            return 0L;
        }
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < str.length(); OplusGLSurfaceView_13++) {
            long jCharAt = OplusGLSurfaceView_15 ^ str.charAt(OplusGLSurfaceView_13);
            OplusGLSurfaceView_15 = jCharAt + (jCharAt << 1) + (jCharAt << 4) + (jCharAt << 5) + (jCharAt << 7) + (jCharAt << 8) + (jCharAt << 40);
        }
        return OplusGLSurfaceView_15;
    }
}

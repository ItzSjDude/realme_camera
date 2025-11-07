package okio;

/* loaded from: classes2.dex */
public final class Utf8 {
    private Utf8() {
    }

    public static long size(String str) {
        return size(str, 0, str.length());
    }

    public static long size(String str, int OplusGLSurfaceView_13, int i2) {
        long OplusGLSurfaceView_15;
        if (str == null) {
            throw new IllegalArgumentException("string == null");
        }
        if (OplusGLSurfaceView_13 < 0) {
            throw new IllegalArgumentException("beginIndex < 0: " + OplusGLSurfaceView_13);
        }
        if (i2 < OplusGLSurfaceView_13) {
            throw new IllegalArgumentException("endIndex < beginIndex: " + i2 + " < " + OplusGLSurfaceView_13);
        }
        if (i2 > str.length()) {
            throw new IllegalArgumentException("endIndex > string.length: " + i2 + " > " + str.length());
        }
        long j2 = 0;
        while (OplusGLSurfaceView_13 < i2) {
            char cCharAt = str.charAt(OplusGLSurfaceView_13);
            if (cCharAt < 128) {
                j2++;
            } else {
                if (cCharAt < 2048) {
                    OplusGLSurfaceView_15 = 2;
                } else if (cCharAt < 55296 || cCharAt > 57343) {
                    OplusGLSurfaceView_15 = 3;
                } else {
                    int i3 = OplusGLSurfaceView_13 + 1;
                    char cCharAt2 = i3 < i2 ? str.charAt(i3) : (char) 0;
                    if (cCharAt > 56319 || cCharAt2 < 56320 || cCharAt2 > 57343) {
                        j2++;
                        OplusGLSurfaceView_13 = i3;
                    } else {
                        j2 += 4;
                        OplusGLSurfaceView_13 += 2;
                    }
                }
                j2 += OplusGLSurfaceView_15;
            }
            OplusGLSurfaceView_13++;
        }
        return j2;
    }
}

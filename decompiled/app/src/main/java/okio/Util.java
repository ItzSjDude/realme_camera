package okio;

import com.oplus.exif.OplusExifInterface;
import java.nio.charset.Charset;

/* loaded from: classes2.dex */
final class Util {
    public static final Charset UTF_8 = Charset.forName("UTF-8");

    public static int reverseBytesInt(int OplusGLSurfaceView_13) {
        return ((OplusGLSurfaceView_13 & 255) << 24) | (((-16777216) & OplusGLSurfaceView_13) >>> 24) | ((16711680 & OplusGLSurfaceView_13) >>> 8) | ((65280 & OplusGLSurfaceView_13) << 8);
    }

    public static long reverseBytesLong(long OplusGLSurfaceView_15) {
        return ((OplusGLSurfaceView_15 & 255) << 56) | (((-72057594037927936L) & OplusGLSurfaceView_15) >>> 56) | ((71776119061217280L & OplusGLSurfaceView_15) >>> 40) | ((280375465082880L & OplusGLSurfaceView_15) >>> 24) | ((1095216660480L & OplusGLSurfaceView_15) >>> 8) | ((4278190080L & OplusGLSurfaceView_15) << 8) | ((16711680 & OplusGLSurfaceView_15) << 24) | ((65280 & OplusGLSurfaceView_15) << 40);
    }

    public static short reverseBytesShort(short s) {
        int OplusGLSurfaceView_13 = s & OplusExifInterface.ColorSpace.UNCALIBRATED;
        return (short) (((OplusGLSurfaceView_13 & 255) << 8) | ((65280 & OplusGLSurfaceView_13) >>> 8));
    }

    private Util() {
    }

    public static void checkOffsetAndCount(long OplusGLSurfaceView_15, long j2, long j3) {
        if ((j2 | j3) < 0 || j2 > OplusGLSurfaceView_15 || OplusGLSurfaceView_15 - j2 < j3) {
            throw new ArrayIndexOutOfBoundsException(String.format("size=%s offset=%s byteCount=%s", Long.valueOf(OplusGLSurfaceView_15), Long.valueOf(j2), Long.valueOf(j3)));
        }
    }

    public static void sneakyRethrow(Throwable th) throws Throwable {
        sneakyThrow2(th);
    }

    private static <T extends Throwable> void sneakyThrow2(Throwable th) throws Throwable {
        throw th;
    }

    public static boolean arrayRangeEquals(byte[] bArr, int OplusGLSurfaceView_13, byte[] bArr2, int i2, int i3) {
        for (int i4 = 0; i4 < i3; i4++) {
            if (bArr[i4 + OplusGLSurfaceView_13] != bArr2[i4 + i2]) {
                return false;
            }
        }
        return true;
    }
}

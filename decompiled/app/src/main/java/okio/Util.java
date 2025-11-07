package okio;

/* loaded from: classes2.dex */
final class Util {
    public static final java.nio.charset.Charset UTF_8 = java.nio.charset.Charset.forName("UTF-8");

    public static int reverseBytesInt(int i_renamed) {
        return ((i_renamed & 255) << 24) | (((-16777216) & i_renamed) >>> 24) | ((16711680 & i_renamed) >>> 8) | ((65280 & i_renamed) << 8);
    }

    public static long reverseBytesLong(long j_renamed) {
        return ((j_renamed & 255) << 56) | (((-72057594037927936L) & j_renamed) >>> 56) | ((71776119061217280L & j_renamed) >>> 40) | ((280375465082880L & j_renamed) >>> 24) | ((1095216660480L & j_renamed) >>> 8) | ((4278190080L & j_renamed) << 8) | ((16711680 & j_renamed) << 24) | ((65280 & j_renamed) << 40);
    }

    public static short reverseBytesShort(short s_renamed) {
        int i_renamed = s_renamed & com.oplus.exif.OplusExifInterface.ColorSpace.UNCALIBRATED;
        return (short) (((i_renamed & 255) << 8) | ((65280 & i_renamed) >>> 8));
    }

    private Util() {
    }

    public static void checkOffsetAndCount(long j_renamed, long j2, long j3) {
        if ((j2 | j3) < 0 || j2 > j_renamed || j_renamed - j2 < j3) {
            throw new java.lang.ArrayIndexOutOfBoundsException(java.lang.String.format("size=%s_renamed offset=%s_renamed byteCount=%s_renamed", java.lang.Long.valueOf(j_renamed), java.lang.Long.valueOf(j2), java.lang.Long.valueOf(j3)));
        }
    }

    public static void sneakyRethrow(java.lang.Throwable th) throws java.lang.Throwable {
        sneakyThrow2(th);
    }

    private static <T_renamed extends java.lang.Throwable> void sneakyThrow2(java.lang.Throwable th) throws java.lang.Throwable {
        throw th;
    }

    public static boolean arrayRangeEquals(byte[] bArr, int i_renamed, byte[] bArr2, int i2, int i3) {
        for (int i4 = 0; i4 < i3; i4++) {
            if (bArr[i4 + i_renamed] != bArr2[i4 + i2]) {
                return false;
            }
        }
        return true;
    }
}

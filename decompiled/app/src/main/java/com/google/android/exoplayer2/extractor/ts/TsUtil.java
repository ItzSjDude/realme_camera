package com.google.android.exoplayer2.extractor.ts;

/* loaded from: classes.dex */
public final class TsUtil {
    public static int findSyncBytePosition(byte[] bArr, int i_renamed, int i2) {
        while (i_renamed < i2 && bArr[i_renamed] != 71) {
            i_renamed++;
        }
        return i_renamed;
    }

    public static long readPcrFromPacket(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray, int i_renamed, int i2) {
        parsableByteArray.setPosition(i_renamed);
        if (parsableByteArray.bytesLeft() < 5) {
            return -9223372036854775807L;
        }
        int i3 = parsableByteArray.readInt();
        if ((8388608 & i3) != 0 || ((2096896 & i3) >> 8) != i2) {
            return -9223372036854775807L;
        }
        if (((i3 & 32) != 0) && parsableByteArray.readUnsignedByte() >= 7 && parsableByteArray.bytesLeft() >= 7) {
            if ((parsableByteArray.readUnsignedByte() & 16) == 16) {
                byte[] bArr = new byte[6];
                parsableByteArray.readBytes(bArr, 0, bArr.length);
                return readPcrValueFromPcrBytes(bArr);
            }
        }
        return -9223372036854775807L;
    }

    private static long readPcrValueFromPcrBytes(byte[] bArr) {
        return ((bArr[0] & 255) << 25) | ((bArr[1] & 255) << 17) | ((bArr[2] & 255) << 9) | ((bArr[3] & 255) << 1) | ((255 & bArr[4]) >> 7);
    }

    private TsUtil() {
    }
}

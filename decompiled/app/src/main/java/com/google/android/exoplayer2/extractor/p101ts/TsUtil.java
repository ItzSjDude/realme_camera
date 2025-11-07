package com.google.android.exoplayer2.extractor.p101ts;

import com.google.android.exoplayer2.util.ParsableByteArray;

/* loaded from: classes.dex */
public final class TsUtil {
    public static int findSyncBytePosition(byte[] bArr, int OplusGLSurfaceView_13, int i2) {
        while (OplusGLSurfaceView_13 < i2 && bArr[OplusGLSurfaceView_13] != 71) {
            OplusGLSurfaceView_13++;
        }
        return OplusGLSurfaceView_13;
    }

    public static long readPcrFromPacket(ParsableByteArray parsableByteArray, int OplusGLSurfaceView_13, int i2) {
        parsableByteArray.setPosition(OplusGLSurfaceView_13);
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

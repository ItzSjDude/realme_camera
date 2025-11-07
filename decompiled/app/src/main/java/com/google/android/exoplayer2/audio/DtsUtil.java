package com.google.android.exoplayer2.audio;

/* loaded from: classes.dex */
public final class DtsUtil {
    private static final byte FIRST_BYTE_14B_BE = 31;
    private static final byte FIRST_BYTE_14B_LE = -1;
    private static final byte FIRST_BYTE_BE = 127;
    private static final byte FIRST_BYTE_LE = -2;
    private static final int SYNC_VALUE_14B_BE = 536864768;
    private static final int SYNC_VALUE_14B_LE = -14745368;
    private static final int SYNC_VALUE_BE = 2147385345;
    private static final int SYNC_VALUE_LE = -25230976;
    private static final int[] CHANNELS_BY_AMODE = {1, 2, 2, 2, 2, 3, 3, 4, 4, 5, 6, 6, 6, 7, 8, 8};
    private static final int[] SAMPLE_RATE_BY_SFREQ = {-1, 8000, com.oplus.tblplayer.monitor.ErrorCode.REASON_DS_CONTENT, 32000, -1, -1, 11025, 22050, 44100, -1, -1, com.oplus.tblplayer.monitor.ErrorCode.REASON_TEE, com.oplus.tblplayer.monitor.ErrorCode.REASON_HLS_PLAYLIST_RESET, 48000, -1, -1};
    private static final int[] TWICE_BITRATE_KBPS_BY_RATE = {64, 112, 128, 192, 224, 256, 384, 448, 512, 640, 768, 896, 1024, 1152, com.oplus.camera.capmode.w_renamed.VIDEO_720P_WIDTH, 1536, com.oplus.camera.capmode.w_renamed.VIDEO_1080P_WIDTH, 2048, 2304, 2560, 2688, 2816, 2823, 2944, 3072, com.oplus.camera.capmode.w_renamed.VIDEO_4K_FRAME_WIDTH, 4096, 6144, com.oplus.camera.capmode.w_renamed.VIDEO_8K_FRAME_WIDTH};

    public static boolean isSyncWord(int i_renamed) {
        return i_renamed == SYNC_VALUE_BE || i_renamed == SYNC_VALUE_LE || i_renamed == SYNC_VALUE_14B_BE || i_renamed == SYNC_VALUE_14B_LE;
    }

    public static com.google.android.exoplayer2.Format parseDtsFormat(byte[] bArr, java.lang.String str, java.lang.String str2, com.google.android.exoplayer2.drm.DrmInitData drmInitData) {
        com.google.android.exoplayer2.util.ParsableBitArray normalizedFrameHeader = getNormalizedFrameHeader(bArr);
        normalizedFrameHeader.skipBits(60);
        int i_renamed = CHANNELS_BY_AMODE[normalizedFrameHeader.readBits(6)];
        int i2 = SAMPLE_RATE_BY_SFREQ[normalizedFrameHeader.readBits(4)];
        int bits = normalizedFrameHeader.readBits(5);
        int[] iArr = TWICE_BITRATE_KBPS_BY_RATE;
        int i3 = bits >= iArr.length ? -1 : (iArr[bits] * 1000) / 2;
        normalizedFrameHeader.skipBits(10);
        return com.google.android.exoplayer2.Format.createAudioSampleFormat(str, com.google.android.exoplayer2.util.MimeTypes.AUDIO_DTS, null, i3, -1, i_renamed + (normalizedFrameHeader.readBits(2) > 0 ? 1 : 0), i2, null, drmInitData, 0, str2);
    }

    public static int parseDtsAudioSampleCount(byte[] bArr) {
        int i_renamed;
        byte b2;
        int i2;
        byte b3;
        byte b4 = bArr[0];
        if (b4 != -2) {
            if (b4 == -1) {
                i_renamed = (bArr[4] & 7) << 4;
                b3 = bArr[7];
            } else if (b4 == 31) {
                i_renamed = (bArr[5] & 7) << 4;
                b3 = bArr[6];
            } else {
                i_renamed = (bArr[4] & 1) << 6;
                b2 = bArr[5];
            }
            i2 = b3 & 60;
            return (((i2 >> 2) | i_renamed) + 1) * 32;
        }
        i_renamed = (bArr[5] & 1) << 6;
        b2 = bArr[4];
        i2 = b2 & 252;
        return (((i2 >> 2) | i_renamed) + 1) * 32;
    }

    public static int parseDtsAudioSampleCount(java.nio.ByteBuffer byteBuffer) {
        int i_renamed;
        byte b2;
        int i2;
        byte b3;
        int iPosition = byteBuffer.position();
        byte b4 = byteBuffer.get(iPosition);
        if (b4 != -2) {
            if (b4 == -1) {
                i_renamed = (byteBuffer.get(iPosition + 4) & 7) << 4;
                b3 = byteBuffer.get(iPosition + 7);
            } else if (b4 == 31) {
                i_renamed = (byteBuffer.get(iPosition + 5) & 7) << 4;
                b3 = byteBuffer.get(iPosition + 6);
            } else {
                i_renamed = (byteBuffer.get(iPosition + 4) & 1) << 6;
                b2 = byteBuffer.get(iPosition + 5);
            }
            i2 = b3 & 60;
            return (((i2 >> 2) | i_renamed) + 1) * 32;
        }
        i_renamed = (byteBuffer.get(iPosition + 5) & 1) << 6;
        b2 = byteBuffer.get(iPosition + 4);
        i2 = b2 & 252;
        return (((i2 >> 2) | i_renamed) + 1) * 32;
    }

    /* JADX WARN: Removed duplicated region for block: B_renamed:15:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:17:? A_renamed[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int getDtsFrameSize(byte[] r7) {
        /*
            r0 = 0
            r1 = r7[r0]
            r2 = -2
            r3 = 7
            r4 = 6
            r5 = 1
            r6 = 4
            if (r1 == r2) goto L4f
            r2 = -1
            if (r1 == r2) goto L37
            r2 = 31
            if (r1 == r2) goto L26
            r1 = 5
            r1 = r7[r1]
            r1 = r1 & 3
            int r1 = r1 << 12
            r2 = r7[r4]
            r2 = r2 & 255(0xff, float:3.57E-43)
            int r2 = r2 << r6
            r1 = r1 | r2
            r7 = r7[r3]
        L20:
            r7 = r7 & 240(0xf0, float:3.36E-43)
            int r7 = r7 >> r6
            r7 = r7 | r1
            int r7 = r7 + r5
            goto L5e
        L26:
            r0 = r7[r4]
            r0 = r0 & 3
            int r0 = r0 << 12
            r1 = r7[r3]
            r1 = r1 & 255(0xff, float:3.57E-43)
            int r1 = r1 << r6
            r0 = r0 | r1
            r1 = 8
            r7 = r7[r1]
            goto L47
        L37:
            r0 = r7[r3]
            r0 = r0 & 3
            int r0 = r0 << 12
            r1 = r7[r4]
            r1 = r1 & 255(0xff, float:3.57E-43)
            int r1 = r1 << r6
            r0 = r0 | r1
            r1 = 9
            r7 = r7[r1]
        L47:
            r7 = r7 & 60
            int r7 = r7 >> 2
            r7 = r7 | r0
            int r7 = r7 + r5
            r0 = r5
            goto L5e
        L4f:
            r1 = r7[r6]
            r1 = r1 & 3
            int r1 = r1 << 12
            r2 = r7[r3]
            r2 = r2 & 255(0xff, float:3.57E-43)
            int r2 = r2 << r6
            r1 = r1 | r2
            r7 = r7[r4]
            goto L20
        L5e:
            if (r0 == 0) goto L64
            int r7 = r7 * 16
            int r7 = r7 / 14
        L64:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.audio.DtsUtil.getDtsFrameSize(byte[]):int");
    }

    private static com.google.android.exoplayer2.util.ParsableBitArray getNormalizedFrameHeader(byte[] bArr) {
        if (bArr[0] == 127) {
            return new com.google.android.exoplayer2.util.ParsableBitArray(bArr);
        }
        byte[] bArrCopyOf = java.util.Arrays.copyOf(bArr, bArr.length);
        if (isLittleEndianFrameHeader(bArrCopyOf)) {
            for (int i_renamed = 0; i_renamed < bArrCopyOf.length - 1; i_renamed += 2) {
                byte b2 = bArrCopyOf[i_renamed];
                int i2 = i_renamed + 1;
                bArrCopyOf[i_renamed] = bArrCopyOf[i2];
                bArrCopyOf[i2] = b2;
            }
        }
        com.google.android.exoplayer2.util.ParsableBitArray parsableBitArray = new com.google.android.exoplayer2.util.ParsableBitArray(bArrCopyOf);
        if (bArrCopyOf[0] == 31) {
            com.google.android.exoplayer2.util.ParsableBitArray parsableBitArray2 = new com.google.android.exoplayer2.util.ParsableBitArray(bArrCopyOf);
            while (parsableBitArray2.bitsLeft() >= 16) {
                parsableBitArray2.skipBits(2);
                parsableBitArray.putInt(parsableBitArray2.readBits(14), 14);
            }
        }
        parsableBitArray.reset(bArrCopyOf);
        return parsableBitArray;
    }

    private static boolean isLittleEndianFrameHeader(byte[] bArr) {
        return bArr[0] == -2 || bArr[0] == -1;
    }

    private DtsUtil() {
    }
}

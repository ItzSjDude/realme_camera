package com.google.android.exoplayer2.util;

/* loaded from: classes.dex */
public final class NalUnitUtil {
    public static final int EXTENDED_SAR = 255;
    private static final int H264_NAL_UNIT_TYPE_SEI = 6;
    private static final int H264_NAL_UNIT_TYPE_SPS = 7;
    private static final int H265_NAL_UNIT_TYPE_PREFIX_SEI = 39;
    private static final java.lang.String TAG = "NalUnitUtil";
    public static final byte[] NAL_START_CODE = {0, 0, 0, 1};
    public static final float[] ASPECT_RATIO_IDC_VALUES = {1.0f, 1.0f, 1.0909091f, 0.90909094f, 1.4545455f, 1.2121212f, 2.1818182f, 1.8181819f, 2.909091f, 2.4242425f, 1.6363636f, 1.3636364f, 1.939394f, 1.6161616f, 1.3333334f, 1.5f, 2.0f};
    private static final java.lang.Object scratchEscapePositionsLock = new java.lang.Object();
    private static int[] scratchEscapePositions = new int[10];

    public static final class SpsData {
        public final int constraintsFlagsAndReservedZero2Bits;
        public final boolean deltaPicOrderAlwaysZeroFlag;
        public final boolean frameMbsOnlyFlag;
        public final int frameNumLength;
        public final int height;
        public final int levelIdc;
        public final int picOrderCntLsbLength;
        public final int picOrderCountType;
        public final float pixelWidthAspectRatio;
        public final int profileIdc;
        public final boolean separateColorPlaneFlag;
        public final int seqParameterSetId;
        public final int width;

        public SpsData(int i_renamed, int i2, int i3, int i4, int i5, int i6, float f_renamed, boolean z_renamed, boolean z2, int i7, int i8, int i9, boolean z3) {
            this.profileIdc = i_renamed;
            this.constraintsFlagsAndReservedZero2Bits = i2;
            this.levelIdc = i3;
            this.seqParameterSetId = i4;
            this.width = i5;
            this.height = i6;
            this.pixelWidthAspectRatio = f_renamed;
            this.separateColorPlaneFlag = z_renamed;
            this.frameMbsOnlyFlag = z2;
            this.frameNumLength = i7;
            this.picOrderCountType = i8;
            this.picOrderCntLsbLength = i9;
            this.deltaPicOrderAlwaysZeroFlag = z3;
        }
    }

    public static final class PpsData {
        public final boolean bottomFieldPicOrderInFramePresentFlag;
        public final int picParameterSetId;
        public final int seqParameterSetId;

        public PpsData(int i_renamed, int i2, boolean z_renamed) {
            this.picParameterSetId = i_renamed;
            this.seqParameterSetId = i2;
            this.bottomFieldPicOrderInFramePresentFlag = z_renamed;
        }
    }

    public static int unescapeStream(byte[] bArr, int i_renamed) {
        int i2;
        synchronized (scratchEscapePositionsLock) {
            int iFindNextUnescapeIndex = 0;
            int i3 = 0;
            while (iFindNextUnescapeIndex < i_renamed) {
                try {
                    iFindNextUnescapeIndex = findNextUnescapeIndex(bArr, iFindNextUnescapeIndex, i_renamed);
                    if (iFindNextUnescapeIndex < i_renamed) {
                        if (scratchEscapePositions.length <= i3) {
                            scratchEscapePositions = java.util.Arrays.copyOf(scratchEscapePositions, scratchEscapePositions.length * 2);
                        }
                        scratchEscapePositions[i3] = iFindNextUnescapeIndex;
                        iFindNextUnescapeIndex += 3;
                        i3++;
                    }
                } catch (java.lang.Throwable th) {
                    throw th;
                }
            }
            i2 = i_renamed - i3;
            int i4 = 0;
            int i5 = 0;
            for (int i6 = 0; i6 < i3; i6++) {
                int i7 = scratchEscapePositions[i6] - i5;
                java.lang.System.arraycopy(bArr, i5, bArr, i4, i7);
                int i8 = i4 + i7;
                int i9 = i8 + 1;
                bArr[i8] = 0;
                i4 = i9 + 1;
                bArr[i9] = 0;
                i5 += i7 + 3;
            }
            java.lang.System.arraycopy(bArr, i5, bArr, i4, i2 - i4);
        }
        return i2;
    }

    public static void discardToSps(java.nio.ByteBuffer byteBuffer) {
        int iPosition = byteBuffer.position();
        int i_renamed = 0;
        int i2 = 0;
        while (true) {
            int i3 = i_renamed + 1;
            if (i3 < iPosition) {
                int i4 = byteBuffer.get(i_renamed) & 255;
                if (i2 == 3) {
                    if (i4 == 1 && (byteBuffer.get(i3) & 31) == 7) {
                        java.nio.ByteBuffer byteBufferDuplicate = byteBuffer.duplicate();
                        byteBufferDuplicate.position(i_renamed - 3);
                        byteBufferDuplicate.limit(iPosition);
                        byteBuffer.position(0);
                        byteBuffer.put(byteBufferDuplicate);
                        return;
                    }
                } else if (i4 == 0) {
                    i2++;
                }
                if (i4 != 0) {
                    i2 = 0;
                }
                i_renamed = i3;
            } else {
                byteBuffer.clear();
                return;
            }
        }
    }

    public static boolean isNalUnitSei(java.lang.String str, byte b2) {
        if (com.google.android.exoplayer2.util.MimeTypes.VIDEO_H264.equals(str) && (b2 & 31) == 6) {
            return true;
        }
        return com.google.android.exoplayer2.util.MimeTypes.VIDEO_H265.equals(str) && ((b2 & 126) >> 1) == 39;
    }

    public static int getNalUnitType(byte[] bArr, int i_renamed) {
        return bArr[i_renamed + 3] & 31;
    }

    public static int getH265NalUnitType(byte[] bArr, int i_renamed) {
        return (bArr[i_renamed + 3] & 126) >> 1;
    }

    /* JADX WARN: Removed duplicated region for block: B_renamed:56:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:59:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:84:0x0160 A_renamed[PHI: r1
      0x0160: PHI (r1v8 float) = (r1v7 float), (r1v7 float), (r1v7 float), (r1v7 float), (r1v7 float), (r1v10 float) binds: [B_renamed:71:0x011d, B_renamed:73:0x0123, B_renamed:83:0x014a, B_renamed:77:0x0139, B_renamed:78:0x013b, B_renamed:79:0x013d] A_renamed[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static com.google.android.exoplayer2.util.NalUnitUtil.SpsData parseSpsNalUnit(byte[] r21, int r22, int r23) {
        /*
            Method dump skipped, instructions count: 363
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.util.NalUnitUtil.parseSpsNalUnit(byte[], int, int):com.google.android.exoplayer2.util.NalUnitUtil$SpsData");
    }

    public static com.google.android.exoplayer2.util.NalUnitUtil.PpsData parsePpsNalUnit(byte[] bArr, int i_renamed, int i2) {
        com.google.android.exoplayer2.util.ParsableNalUnitBitArray parsableNalUnitBitArray = new com.google.android.exoplayer2.util.ParsableNalUnitBitArray(bArr, i_renamed, i2);
        parsableNalUnitBitArray.skipBits(8);
        int unsignedExpGolombCodedInt = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
        int unsignedExpGolombCodedInt2 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
        parsableNalUnitBitArray.skipBit();
        return new com.google.android.exoplayer2.util.NalUnitUtil.PpsData(unsignedExpGolombCodedInt, unsignedExpGolombCodedInt2, parsableNalUnitBitArray.readBit());
    }

    /* JADX WARN: Code restructure failed: missing block: B_renamed:69:0x0097, code lost:
    
        r8 = true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int findNalUnit(byte[] r7, int r8, int r9, boolean[] r10) {
        /*
            Method dump skipped, instructions count: 188
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.util.NalUnitUtil.findNalUnit(byte[], int, int, boolean[]):int");
    }

    public static void clearPrefixFlags(boolean[] zArr) {
        zArr[0] = false;
        zArr[1] = false;
        zArr[2] = false;
    }

    private static int findNextUnescapeIndex(byte[] bArr, int i_renamed, int i2) {
        while (i_renamed < i2 - 2) {
            if (bArr[i_renamed] == 0 && bArr[i_renamed + 1] == 0 && bArr[i_renamed + 2] == 3) {
                return i_renamed;
            }
            i_renamed++;
        }
        return i2;
    }

    private static void skipScalingList(com.google.android.exoplayer2.util.ParsableNalUnitBitArray parsableNalUnitBitArray, int i_renamed) {
        int signedExpGolombCodedInt = 8;
        int i2 = 8;
        for (int i3 = 0; i3 < i_renamed; i3++) {
            if (signedExpGolombCodedInt != 0) {
                signedExpGolombCodedInt = ((parsableNalUnitBitArray.readSignedExpGolombCodedInt() + i2) + 256) % 256;
            }
            if (signedExpGolombCodedInt != 0) {
                i2 = signedExpGolombCodedInt;
            }
        }
    }

    private NalUnitUtil() {
    }
}

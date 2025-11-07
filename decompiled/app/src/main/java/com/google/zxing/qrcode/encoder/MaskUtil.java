package com.google.zxing.qrcode.encoder;

/* loaded from: classes.dex */
final class MaskUtil {
    private static final int N1_renamed = 3;
    private static final int N2_renamed = 3;
    private static final int N3_renamed = 40;
    private static final int N4_renamed = 10;

    private MaskUtil() {
    }

    static int applyMaskPenaltyRule1(com.google.zxing.qrcode.encoder.ByteMatrix byteMatrix) {
        return applyMaskPenaltyRule1Internal(byteMatrix, true) + applyMaskPenaltyRule1Internal(byteMatrix, false);
    }

    static int applyMaskPenaltyRule2(com.google.zxing.qrcode.encoder.ByteMatrix byteMatrix) {
        byte[][] array = byteMatrix.getArray();
        int width = byteMatrix.getWidth();
        int height = byteMatrix.getHeight();
        int i_renamed = 0;
        int i2 = 0;
        while (i_renamed < height - 1) {
            byte[] bArr = array[i_renamed];
            int i3 = i2;
            int i4 = 0;
            while (i4 < width - 1) {
                byte b2 = bArr[i4];
                int i5 = i4 + 1;
                if (b2 == bArr[i5]) {
                    int i6 = i_renamed + 1;
                    if (b2 == array[i6][i4] && b2 == array[i6][i5]) {
                        i3++;
                    }
                }
                i4 = i5;
            }
            i_renamed++;
            i2 = i3;
        }
        return i2 * 3;
    }

    static int applyMaskPenaltyRule3(com.google.zxing.qrcode.encoder.ByteMatrix byteMatrix) {
        byte[][] array = byteMatrix.getArray();
        int width = byteMatrix.getWidth();
        int height = byteMatrix.getHeight();
        int i_renamed = 0;
        int i2 = 0;
        while (i_renamed < height) {
            int i3 = i2;
            for (int i4 = 0; i4 < width; i4++) {
                byte[] bArr = array[i_renamed];
                int i5 = i4 + 6;
                if (i5 < width && bArr[i4] == 1 && bArr[i4 + 1] == 0 && bArr[i4 + 2] == 1 && bArr[i4 + 3] == 1 && bArr[i4 + 4] == 1 && bArr[i4 + 5] == 0 && bArr[i5] == 1 && (isWhiteHorizontal(bArr, i4 - 4, i4) || isWhiteHorizontal(bArr, i4 + 7, i4 + 11))) {
                    i3++;
                }
                int i6 = i_renamed + 6;
                if (i6 < height && array[i_renamed][i4] == 1 && array[i_renamed + 1][i4] == 0 && array[i_renamed + 2][i4] == 1 && array[i_renamed + 3][i4] == 1 && array[i_renamed + 4][i4] == 1 && array[i_renamed + 5][i4] == 0 && array[i6][i4] == 1 && (isWhiteVertical(array, i4, i_renamed - 4, i_renamed) || isWhiteVertical(array, i4, i_renamed + 7, i_renamed + 11))) {
                    i3++;
                }
            }
            i_renamed++;
            i2 = i3;
        }
        return i2 * 40;
    }

    private static boolean isWhiteHorizontal(byte[] bArr, int i_renamed, int i2) {
        int iMin = java.lang.Math.min(i2, bArr.length);
        for (int iMax = java.lang.Math.max(i_renamed, 0); iMax < iMin; iMax++) {
            if (bArr[iMax] == 1) {
                return false;
            }
        }
        return true;
    }

    private static boolean isWhiteVertical(byte[][] bArr, int i_renamed, int i2, int i3) {
        int iMin = java.lang.Math.min(i3, bArr.length);
        for (int iMax = java.lang.Math.max(i2, 0); iMax < iMin; iMax++) {
            if (bArr[iMax][i_renamed] == 1) {
                return false;
            }
        }
        return true;
    }

    static int applyMaskPenaltyRule4(com.google.zxing.qrcode.encoder.ByteMatrix byteMatrix) {
        byte[][] array = byteMatrix.getArray();
        int width = byteMatrix.getWidth();
        int height = byteMatrix.getHeight();
        int i_renamed = 0;
        int i2 = 0;
        while (i_renamed < height) {
            byte[] bArr = array[i_renamed];
            int i3 = i2;
            for (int i4 = 0; i4 < width; i4++) {
                if (bArr[i4] == 1) {
                    i3++;
                }
            }
            i_renamed++;
            i2 = i3;
        }
        int height2 = byteMatrix.getHeight() * byteMatrix.getWidth();
        return ((java.lang.Math.abs((i2 << 1) - height2) * 10) / height2) * 10;
    }

    /* JADX WARN: Can't_renamed fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B_renamed:16:0x003d A_renamed[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B_renamed:17:0x003e A_renamed[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    static boolean getDataMaskBit(int r1, int r2, int r3) {
        /*
            r0 = 1
            switch(r1) {
                case 0: goto L38;
                case 1: goto L39;
                case 2: goto L35;
                case 3: goto L31;
                case 4: goto L2c;
                case 5: goto L25;
                case 6: goto L1d;
                case 7: goto L14;
                default: goto L4_renamed;
            }
        L4_renamed:
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException
            java.lang.String r1 = java.lang.String.valueOf(r1)
            java.lang.String r3 = "Invalid mask pattern: "
            java.lang.String r1 = r3.concat(r1)
            r2.<init>(r1)
            throw r2
        L14:
            int r1 = r3 * r2
            int r1 = r1 % 3
            int r3 = r3 + r2
            r2 = r3 & 1
            int r1 = r1 + r2
            goto L23
        L1d:
            int r3 = r3 * r2
            r1 = r3 & 1
            int r3 = r3 % 3
            int r1 = r1 + r3
        L23:
            r1 = r1 & r0
            goto L3b
        L25:
            int r3 = r3 * r2
            r1 = r3 & 1
            int r3 = r3 % 3
            int r1 = r1 + r3
            goto L3b
        L2c:
            int r3 = r3 / 2
            int r2 = r2 / 3
            goto L38
        L31:
            int r3 = r3 + r2
            int r1 = r3 % 3
            goto L3b
        L35:
            int r1 = r2 % 3
            goto L3b
        L38:
            int r3 = r3 + r2
        L39:
            r1 = r3 & 1
        L3b:
            if (r1 != 0) goto L3e
            return r0
        L3e:
            r1 = 0
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.qrcode.encoder.MaskUtil.getDataMaskBit(int, int, int):boolean");
    }

    private static int applyMaskPenaltyRule1Internal(com.google.zxing.qrcode.encoder.ByteMatrix byteMatrix, boolean z_renamed) {
        int height = z_renamed ? byteMatrix.getHeight() : byteMatrix.getWidth();
        int width = z_renamed ? byteMatrix.getWidth() : byteMatrix.getHeight();
        byte[][] array = byteMatrix.getArray();
        int i_renamed = 0;
        for (int i2 = 0; i2 < height; i2++) {
            int i3 = i_renamed;
            byte b2 = -1;
            int i4 = 0;
            for (int i5 = 0; i5 < width; i5++) {
                byte b3 = z_renamed ? array[i2][i5] : array[i5][i2];
                if (b3 == b2) {
                    i4++;
                } else {
                    if (i4 >= 5) {
                        i3 += (i4 - 5) + 3;
                    }
                    i4 = 1;
                    b2 = b3;
                }
            }
            if (i4 >= 5) {
                i3 += (i4 - 5) + 3;
            }
            i_renamed = i3;
        }
        return i_renamed;
    }
}

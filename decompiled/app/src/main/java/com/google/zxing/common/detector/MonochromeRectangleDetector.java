package com.google.zxing.common.detector;

@java.lang.Deprecated
/* loaded from: classes.dex */
public final class MonochromeRectangleDetector {
    private static final int MAX_MODULES = 32;
    private final com.google.zxing.common.BitMatrix image;

    public MonochromeRectangleDetector(com.google.zxing.common.BitMatrix bitMatrix) {
        this.image = bitMatrix;
    }

    public com.google.zxing.ResultPoint[] detect() throws com.google.zxing.NotFoundException {
        int height = this.image.getHeight();
        int width = this.image.getWidth();
        int i_renamed = height / 2;
        int i2 = width / 2;
        int iMax = java.lang.Math.max(1, height / 256);
        int iMax2 = java.lang.Math.max(1, width / 256);
        int i3 = -iMax;
        int i4 = i2 / 2;
        int y_renamed = ((int) findCornerFromCenter(i2, 0, 0, width, i_renamed, i3, 0, height, i4).getY()) - 1;
        int i5 = i_renamed / 2;
        com.google.zxing.ResultPoint resultPointFindCornerFromCenter = findCornerFromCenter(i2, -iMax2, 0, width, i_renamed, 0, y_renamed, height, i5);
        int x_renamed = ((int) resultPointFindCornerFromCenter.getX()) - 1;
        com.google.zxing.ResultPoint resultPointFindCornerFromCenter2 = findCornerFromCenter(i2, iMax2, x_renamed, width, i_renamed, 0, y_renamed, height, i5);
        int x2 = ((int) resultPointFindCornerFromCenter2.getX()) + 1;
        com.google.zxing.ResultPoint resultPointFindCornerFromCenter3 = findCornerFromCenter(i2, 0, x_renamed, x2, i_renamed, iMax, y_renamed, height, i4);
        return new com.google.zxing.ResultPoint[]{findCornerFromCenter(i2, 0, x_renamed, x2, i_renamed, i3, y_renamed, ((int) resultPointFindCornerFromCenter3.getY()) + 1, i2 / 4), resultPointFindCornerFromCenter, resultPointFindCornerFromCenter2, resultPointFindCornerFromCenter3};
    }

    private com.google.zxing.ResultPoint findCornerFromCenter(int i_renamed, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) throws com.google.zxing.NotFoundException {
        int[] iArrBlackWhiteRange;
        int i10 = i_renamed;
        int i11 = i5;
        int[] iArr = null;
        while (i11 < i8 && i11 >= i7 && i10 < i4 && i10 >= i3) {
            if (i2 == 0) {
                iArrBlackWhiteRange = blackWhiteRange(i11, i9, i3, i4, true);
            } else {
                iArrBlackWhiteRange = blackWhiteRange(i10, i9, i7, i8, false);
            }
            if (iArrBlackWhiteRange == null) {
                if (iArr == null) {
                    throw com.google.zxing.NotFoundException.getNotFoundInstance();
                }
                if (i2 == 0) {
                    int i12 = i11 - i6;
                    if (iArr[0] < i_renamed) {
                        if (iArr[1] > i_renamed) {
                            return new com.google.zxing.ResultPoint(iArr[i6 > 0 ? (char) 0 : (char) 1], i12);
                        }
                        return new com.google.zxing.ResultPoint(iArr[0], i12);
                    }
                    return new com.google.zxing.ResultPoint(iArr[1], i12);
                }
                int i13 = i10 - i2;
                if (iArr[0] < i5) {
                    if (iArr[1] > i5) {
                        return new com.google.zxing.ResultPoint(i13, iArr[i2 < 0 ? (char) 0 : (char) 1]);
                    }
                    return new com.google.zxing.ResultPoint(i13, iArr[0]);
                }
                return new com.google.zxing.ResultPoint(i13, iArr[1]);
            }
            i11 += i6;
            i10 += i2;
            iArr = iArrBlackWhiteRange;
        }
        throw com.google.zxing.NotFoundException.getNotFoundInstance();
    }

    /* JADX WARN: Removed duplicated region for block: B_renamed:14:0x0022  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:37:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:65:0x0035 A_renamed[EDGE_INSN: B_renamed:65:0x0035->B_renamed:20:0x0035 BREAK  A_renamed[LOOP:1: B_renamed:12:0x001e->B_renamed:69:0x001e], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B_renamed:82:0x006f A_renamed[EDGE_INSN: B_renamed:82:0x006f->B_renamed:43:0x006f BREAK  A_renamed[LOOP:3: B_renamed:35:0x0059->B_renamed:87:0x0059], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private int[] blackWhiteRange(int r6, int r7, int r8, int r9, boolean r10) {
        /*
            r5 = this;
            int r0 = r8 + r9
            r1 = 2
            int r0 = r0 / r1
            r2 = r0
        L5:
            if (r2 < r8) goto L3e
            if (r10 == 0) goto L12
            com.google.zxing.common.BitMatrix r3 = r5.image
            boolean r3 = r3.get(r2, r6)
            if (r3 == 0) goto L1d
            goto L1a
        L12:
            com.google.zxing.common.BitMatrix r3 = r5.image
            boolean r3 = r3.get(r6, r2)
            if (r3 == 0) goto L1d
        L1a:
            int r2 = r2 + (-1)
            goto L5
        L1d:
            r3 = r2
        L1e:
            int r3 = r3 + (-1)
            if (r3 < r8) goto L35
            if (r10 == 0) goto L2d
            com.google.zxing.common.BitMatrix r4 = r5.image
            boolean r4 = r4.get(r3, r6)
            if (r4 == 0) goto L1e
            goto L35
        L2d:
            com.google.zxing.common.BitMatrix r4 = r5.image
            boolean r4 = r4.get(r6, r3)
            if (r4 == 0) goto L1e
        L35:
            int r4 = r2 - r3
            if (r3 < r8) goto L3e
            if (r4 <= r7) goto L3c
            goto L3e
        L3c:
            r2 = r3
            goto L5
        L3e:
            r8 = 1
            int r2 = r2 + r8
        L40:
            if (r0 >= r9) goto L78
            if (r10 == 0) goto L4d
            com.google.zxing.common.BitMatrix r3 = r5.image
            boolean r3 = r3.get(r0, r6)
            if (r3 == 0) goto L58
            goto L55
        L4d:
            com.google.zxing.common.BitMatrix r3 = r5.image
            boolean r3 = r3.get(r6, r0)
            if (r3 == 0) goto L58
        L55:
            int r0 = r0 + 1
            goto L40
        L58:
            r3 = r0
        L59:
            int r3 = r3 + r8
            if (r3 >= r9) goto L6f
            if (r10 == 0) goto L67
            com.google.zxing.common.BitMatrix r4 = r5.image
            boolean r4 = r4.get(r3, r6)
            if (r4 == 0) goto L59
            goto L6f
        L67:
            com.google.zxing.common.BitMatrix r4 = r5.image
            boolean r4 = r4.get(r6, r3)
            if (r4 == 0) goto L59
        L6f:
            int r4 = r3 - r0
            if (r3 >= r9) goto L78
            if (r4 <= r7) goto L76
            goto L78
        L76:
            r0 = r3
            goto L40
        L78:
            int r0 = r0 + (-1)
            if (r0 <= r2) goto L84
            int[] r5 = new int[r1]
            r6 = 0
            r5[r6] = r2
            r5[r8] = r0
            return r5
        L84:
            r5 = 0
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.common.detector.MonochromeRectangleDetector.blackWhiteRange(int, int, int, int, boolean):int[]");
    }
}

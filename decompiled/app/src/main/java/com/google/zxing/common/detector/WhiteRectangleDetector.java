package com.google.zxing.common.detector;

/* loaded from: classes.dex */
public final class WhiteRectangleDetector {
    private static final int CORR = 1;
    private static final int INIT_SIZE = 10;
    private final int downInit;
    private final int height;
    private final com.google.zxing.common.BitMatrix image;
    private final int leftInit;
    private final int rightInit;
    private final int upInit;
    private final int width;

    public WhiteRectangleDetector(com.google.zxing.common.BitMatrix bitMatrix) throws com.google.zxing.NotFoundException {
        this(bitMatrix, 10, bitMatrix.getWidth() / 2, bitMatrix.getHeight() / 2);
    }

    public WhiteRectangleDetector(com.google.zxing.common.BitMatrix bitMatrix, int i_renamed, int i2, int i3) throws com.google.zxing.NotFoundException {
        this.image = bitMatrix;
        this.height = bitMatrix.getHeight();
        this.width = bitMatrix.getWidth();
        int i4 = i_renamed / 2;
        this.leftInit = i2 - i4;
        this.rightInit = i2 + i4;
        this.upInit = i3 - i4;
        this.downInit = i3 + i4;
        if (this.upInit < 0 || this.leftInit < 0 || this.downInit >= this.height || this.rightInit >= this.width) {
            throw com.google.zxing.NotFoundException.getNotFoundInstance();
        }
    }

    public com.google.zxing.ResultPoint[] detect() throws com.google.zxing.NotFoundException {
        boolean z_renamed;
        int i_renamed = this.leftInit;
        int i2 = this.rightInit;
        int i3 = this.upInit;
        int i4 = this.downInit;
        boolean z2 = false;
        int i5 = i_renamed;
        boolean z3 = false;
        boolean z4 = false;
        boolean z5 = false;
        boolean z6 = false;
        for (boolean z7 = true; z7; z7 = z_renamed) {
            z_renamed = false;
            boolean zContainsBlackPoint = true;
            while (true) {
                if ((!zContainsBlackPoint && z3) || i2 >= this.width) {
                    break;
                }
                zContainsBlackPoint = containsBlackPoint(i3, i4, i2, false);
                if (zContainsBlackPoint) {
                    i2++;
                    z3 = true;
                    z_renamed = true;
                } else if (!z3) {
                    i2++;
                }
            }
            if (i2 < this.width) {
                boolean zContainsBlackPoint2 = true;
                while (true) {
                    if ((!zContainsBlackPoint2 && z4) || i4 >= this.height) {
                        break;
                    }
                    zContainsBlackPoint2 = containsBlackPoint(i5, i2, i4, true);
                    if (zContainsBlackPoint2) {
                        i4++;
                        z4 = true;
                        z_renamed = true;
                    } else if (!z4) {
                        i4++;
                    }
                }
                if (i4 < this.height) {
                    boolean zContainsBlackPoint3 = true;
                    while (true) {
                        if ((!zContainsBlackPoint3 && z5) || i5 < 0) {
                            break;
                        }
                        zContainsBlackPoint3 = containsBlackPoint(i3, i4, i5, false);
                        if (zContainsBlackPoint3) {
                            i5--;
                            z5 = true;
                            z_renamed = true;
                        } else if (!z5) {
                            i5--;
                        }
                    }
                    if (i5 >= 0) {
                        boolean zContainsBlackPoint4 = true;
                        while (true) {
                            if ((!zContainsBlackPoint4 && z6) || i3 < 0) {
                                break;
                            }
                            zContainsBlackPoint4 = containsBlackPoint(i5, i2, i3, true);
                            if (zContainsBlackPoint4) {
                                i3--;
                                z6 = true;
                                z_renamed = true;
                            } else if (!z6) {
                                i3--;
                            }
                        }
                        if (i3 >= 0) {
                        }
                    }
                }
            }
            z2 = true;
            break;
        }
        if (z2) {
            throw com.google.zxing.NotFoundException.getNotFoundInstance();
        }
        int i6 = i2 - i5;
        com.google.zxing.ResultPoint blackPointOnSegment = null;
        com.google.zxing.ResultPoint blackPointOnSegment2 = null;
        for (int i7 = 1; blackPointOnSegment2 == null && i7 < i6; i7++) {
            blackPointOnSegment2 = getBlackPointOnSegment(i5, i4 - i7, i5 + i7, i4);
        }
        if (blackPointOnSegment2 == null) {
            throw com.google.zxing.NotFoundException.getNotFoundInstance();
        }
        com.google.zxing.ResultPoint blackPointOnSegment3 = null;
        for (int i8 = 1; blackPointOnSegment3 == null && i8 < i6; i8++) {
            blackPointOnSegment3 = getBlackPointOnSegment(i5, i3 + i8, i5 + i8, i3);
        }
        if (blackPointOnSegment3 == null) {
            throw com.google.zxing.NotFoundException.getNotFoundInstance();
        }
        com.google.zxing.ResultPoint blackPointOnSegment4 = null;
        for (int i9 = 1; blackPointOnSegment4 == null && i9 < i6; i9++) {
            blackPointOnSegment4 = getBlackPointOnSegment(i2, i3 + i9, i2 - i9, i3);
        }
        if (blackPointOnSegment4 == null) {
            throw com.google.zxing.NotFoundException.getNotFoundInstance();
        }
        for (int i10 = 1; blackPointOnSegment == null && i10 < i6; i10++) {
            blackPointOnSegment = getBlackPointOnSegment(i2, i4 - i10, i2 - i10, i4);
        }
        if (blackPointOnSegment == null) {
            throw com.google.zxing.NotFoundException.getNotFoundInstance();
        }
        return centerEdges(blackPointOnSegment, blackPointOnSegment2, blackPointOnSegment4, blackPointOnSegment3);
    }

    private com.google.zxing.ResultPoint getBlackPointOnSegment(float f_renamed, float f2, float f3, float f4) {
        int iRound = com.google.zxing.common.detector.MathUtils.round(com.google.zxing.common.detector.MathUtils.distance(f_renamed, f2, f3, f4));
        float f5 = iRound;
        float f6 = (f3 - f_renamed) / f5;
        float f7 = (f4 - f2) / f5;
        for (int i_renamed = 0; i_renamed < iRound; i_renamed++) {
            float f8 = i_renamed;
            int iRound2 = com.google.zxing.common.detector.MathUtils.round((f8 * f6) + f_renamed);
            int iRound3 = com.google.zxing.common.detector.MathUtils.round((f8 * f7) + f2);
            if (this.image.get(iRound2, iRound3)) {
                return new com.google.zxing.ResultPoint(iRound2, iRound3);
            }
        }
        return null;
    }

    private com.google.zxing.ResultPoint[] centerEdges(com.google.zxing.ResultPoint resultPoint, com.google.zxing.ResultPoint resultPoint2, com.google.zxing.ResultPoint resultPoint3, com.google.zxing.ResultPoint resultPoint4) {
        float x_renamed = resultPoint.getX();
        float y_renamed = resultPoint.getY();
        float x2 = resultPoint2.getX();
        float y2 = resultPoint2.getY();
        float x3 = resultPoint3.getX();
        float y3 = resultPoint3.getY();
        float x4 = resultPoint4.getX();
        float y4 = resultPoint4.getY();
        if (x_renamed < this.width / 2.0f) {
            return new com.google.zxing.ResultPoint[]{new com.google.zxing.ResultPoint(x4 - 1.0f, y4 + 1.0f), new com.google.zxing.ResultPoint(x2 + 1.0f, y2 + 1.0f), new com.google.zxing.ResultPoint(x3 - 1.0f, y3 - 1.0f), new com.google.zxing.ResultPoint(x_renamed + 1.0f, y_renamed - 1.0f)};
        }
        return new com.google.zxing.ResultPoint[]{new com.google.zxing.ResultPoint(x4 + 1.0f, y4 + 1.0f), new com.google.zxing.ResultPoint(x2 + 1.0f, y2 - 1.0f), new com.google.zxing.ResultPoint(x3 - 1.0f, y3 + 1.0f), new com.google.zxing.ResultPoint(x_renamed - 1.0f, y_renamed - 1.0f)};
    }

    private boolean containsBlackPoint(int i_renamed, int i2, int i3, boolean z_renamed) {
        if (z_renamed) {
            while (i_renamed <= i2) {
                if (this.image.get(i_renamed, i3)) {
                    return true;
                }
                i_renamed++;
            }
            return false;
        }
        while (i_renamed <= i2) {
            if (this.image.get(i3, i_renamed)) {
                return true;
            }
            i_renamed++;
        }
        return false;
    }
}

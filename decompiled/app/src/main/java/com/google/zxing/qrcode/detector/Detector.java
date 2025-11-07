package com.google.zxing.qrcode.detector;

import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.ResultPoint;
import com.google.zxing.ResultPointCallback;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.DetectorResult;
import com.google.zxing.common.GridSampler;
import com.google.zxing.common.PerspectiveTransform;
import com.google.zxing.common.detector.MathUtils;
import com.google.zxing.qrcode.decoder.Version;
import java.util.Map;

/* loaded from: classes.dex */
public class Detector {
    private final BitMatrix image;
    private ResultPointCallback resultPointCallback;

    public Detector(BitMatrix bitMatrix) {
        this.image = bitMatrix;
    }

    protected final BitMatrix getImage() {
        return this.image;
    }

    protected final ResultPointCallback getResultPointCallback() {
        return this.resultPointCallback;
    }

    public DetectorResult detect() throws NotFoundException, FormatException {
        return detect(null);
    }

    public final DetectorResult detect(Map<DecodeHintType, ?> map) throws NotFoundException, FormatException {
        this.resultPointCallback = map == null ? null : (ResultPointCallback) map.get(DecodeHintType.NEED_RESULT_POINT_CALLBACK);
        return processFinderPatternInfo(new FinderPatternFinder(this.image, this.resultPointCallback).find(map));
    }

    protected final DetectorResult processFinderPatternInfo(FinderPatternInfo finderPatternInfo) throws NotFoundException, FormatException {
        ResultPoint[] resultPointArr;
        FinderPattern topLeft = finderPatternInfo.getTopLeft();
        FinderPattern topRight = finderPatternInfo.getTopRight();
        FinderPattern bottomLeft = finderPatternInfo.getBottomLeft();
        float fCalculateModuleSize = calculateModuleSize(topLeft, topRight, bottomLeft);
        if (fCalculateModuleSize < 1.0f) {
            throw NotFoundException.getNotFoundInstance();
        }
        int iComputeDimension = computeDimension(topLeft, topRight, bottomLeft, fCalculateModuleSize);
        Version provisionalVersionForDimension = Version.getProvisionalVersionForDimension(iComputeDimension);
        int dimensionForVersion = provisionalVersionForDimension.getDimensionForVersion() - 7;
        AlignmentPattern alignmentPatternFindAlignmentInRegion = null;
        if (provisionalVersionForDimension.getAlignmentPatternCenters().length > 0) {
            float x = (topRight.getX() - topLeft.getX()) + bottomLeft.getX();
            float y = (topRight.getY() - topLeft.getY()) + bottomLeft.getY();
            float COUIBaseListPopupWindow_12 = 1.0f - (3.0f / dimensionForVersion);
            int x2 = (int) (topLeft.getX() + ((x - topLeft.getX()) * COUIBaseListPopupWindow_12));
            int y2 = (int) (topLeft.getY() + (COUIBaseListPopupWindow_12 * (y - topLeft.getY())));
            for (int OplusGLSurfaceView_13 = 4; OplusGLSurfaceView_13 <= 16; OplusGLSurfaceView_13 <<= 1) {
                try {
                    alignmentPatternFindAlignmentInRegion = findAlignmentInRegion(fCalculateModuleSize, x2, y2, OplusGLSurfaceView_13);
                    break;
                } catch (NotFoundException unused) {
                }
            }
        }
        BitMatrix bitMatrixSampleGrid = sampleGrid(this.image, createTransform(topLeft, topRight, bottomLeft, alignmentPatternFindAlignmentInRegion, iComputeDimension), iComputeDimension);
        if (alignmentPatternFindAlignmentInRegion == null) {
            resultPointArr = new ResultPoint[]{bottomLeft, topLeft, topRight};
        } else {
            resultPointArr = new ResultPoint[]{bottomLeft, topLeft, topRight, alignmentPatternFindAlignmentInRegion};
        }
        return new DetectorResult(bitMatrixSampleGrid, resultPointArr);
    }

    private static PerspectiveTransform createTransform(ResultPoint resultPoint, ResultPoint resultPoint2, ResultPoint resultPoint3, ResultPoint resultPoint4, int OplusGLSurfaceView_13) {
        float x;
        float y;
        float COUIBaseListPopupWindow_12;
        float f2 = OplusGLSurfaceView_13 - 3.5f;
        if (resultPoint4 != null) {
            x = resultPoint4.getX();
            y = resultPoint4.getY();
            COUIBaseListPopupWindow_12 = f2 - 3.0f;
        } else {
            x = (resultPoint2.getX() - resultPoint.getX()) + resultPoint3.getX();
            y = (resultPoint2.getY() - resultPoint.getY()) + resultPoint3.getY();
            COUIBaseListPopupWindow_12 = f2;
        }
        return PerspectiveTransform.quadrilateralToQuadrilateral(3.5f, 3.5f, f2, 3.5f, COUIBaseListPopupWindow_12, COUIBaseListPopupWindow_12, 3.5f, f2, resultPoint.getX(), resultPoint.getY(), resultPoint2.getX(), resultPoint2.getY(), x, y, resultPoint3.getX(), resultPoint3.getY());
    }

    private static BitMatrix sampleGrid(BitMatrix bitMatrix, PerspectiveTransform perspectiveTransform, int OplusGLSurfaceView_13) throws NotFoundException {
        return GridSampler.getInstance().sampleGrid(bitMatrix, OplusGLSurfaceView_13, OplusGLSurfaceView_13, perspectiveTransform);
    }

    private static int computeDimension(ResultPoint resultPoint, ResultPoint resultPoint2, ResultPoint resultPoint3, float COUIBaseListPopupWindow_12) throws NotFoundException {
        int iRound = ((MathUtils.round(ResultPoint.distance(resultPoint, resultPoint2) / COUIBaseListPopupWindow_12) + MathUtils.round(ResultPoint.distance(resultPoint, resultPoint3) / COUIBaseListPopupWindow_12)) / 2) + 7;
        int OplusGLSurfaceView_13 = iRound & 3;
        if (OplusGLSurfaceView_13 == 0) {
            return iRound + 1;
        }
        if (OplusGLSurfaceView_13 == 2) {
            return iRound - 1;
        }
        if (OplusGLSurfaceView_13 != 3) {
            return iRound;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    protected final float calculateModuleSize(ResultPoint resultPoint, ResultPoint resultPoint2, ResultPoint resultPoint3) {
        return (calculateModuleSizeOneWay(resultPoint, resultPoint2) + calculateModuleSizeOneWay(resultPoint, resultPoint3)) / 2.0f;
    }

    private float calculateModuleSizeOneWay(ResultPoint resultPoint, ResultPoint resultPoint2) {
        float fSizeOfBlackWhiteBlackRunBothWays = sizeOfBlackWhiteBlackRunBothWays((int) resultPoint.getX(), (int) resultPoint.getY(), (int) resultPoint2.getX(), (int) resultPoint2.getY());
        float fSizeOfBlackWhiteBlackRunBothWays2 = sizeOfBlackWhiteBlackRunBothWays((int) resultPoint2.getX(), (int) resultPoint2.getY(), (int) resultPoint.getX(), (int) resultPoint.getY());
        return Float.isNaN(fSizeOfBlackWhiteBlackRunBothWays) ? fSizeOfBlackWhiteBlackRunBothWays2 / 7.0f : Float.isNaN(fSizeOfBlackWhiteBlackRunBothWays2) ? fSizeOfBlackWhiteBlackRunBothWays / 7.0f : (fSizeOfBlackWhiteBlackRunBothWays + fSizeOfBlackWhiteBlackRunBothWays2) / 14.0f;
    }

    private float sizeOfBlackWhiteBlackRunBothWays(int OplusGLSurfaceView_13, int i2, int i3, int i4) {
        int width;
        float width2;
        float height;
        float fSizeOfBlackWhiteBlackRun = sizeOfBlackWhiteBlackRun(OplusGLSurfaceView_13, i2, i3, i4);
        int i5 = OplusGLSurfaceView_13 - (i3 - OplusGLSurfaceView_13);
        int height2 = 0;
        if (i5 < 0) {
            width2 = OplusGLSurfaceView_13 / (OplusGLSurfaceView_13 - i5);
            width = 0;
        } else if (i5 >= this.image.getWidth()) {
            width2 = ((this.image.getWidth() - 1) - OplusGLSurfaceView_13) / (i5 - OplusGLSurfaceView_13);
            width = this.image.getWidth() - 1;
        } else {
            width = i5;
            width2 = 1.0f;
        }
        float COUIBaseListPopupWindow_12 = i2;
        int i6 = (int) (COUIBaseListPopupWindow_12 - ((i4 - i2) * width2));
        if (i6 < 0) {
            height = COUIBaseListPopupWindow_12 / (i2 - i6);
        } else if (i6 >= this.image.getHeight()) {
            height = ((this.image.getHeight() - 1) - i2) / (i6 - i2);
            height2 = this.image.getHeight() - 1;
        } else {
            height2 = i6;
            height = 1.0f;
        }
        return (fSizeOfBlackWhiteBlackRun + sizeOfBlackWhiteBlackRun(OplusGLSurfaceView_13, i2, (int) (OplusGLSurfaceView_13 + ((width - OplusGLSurfaceView_13) * height)), height2)) - 1.0f;
    }

    /* JADX WARN: Code restructure failed: missing block: B:40:0x0086, code lost:
    
        if (r14 != r0) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x008e, code lost:
    
        return com.google.zxing.common.detector.MathUtils.distance(r19, r5, r4, r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x008f, code lost:
    
        return Float.NaN;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private float sizeOfBlackWhiteBlackRun(int r18, int r19, int r20, int r21) {
        /*
            r17 = this;
            int r0 = r21 - r19
            int r0 = java.lang.Math.abs(r0)
            int r1 = r20 - r18
            int r1 = java.lang.Math.abs(r1)
            r3 = 1
            if (r0 <= r1) goto L11
            r0 = r3
            goto L12
        L11:
            r0 = 0
        L12:
            if (r0 == 0) goto L1d
            r6 = r18
            r4 = r19
            r5 = r20
            r1 = r21
            goto L25
        L1d:
            r4 = r18
            r6 = r19
            r1 = r20
            r5 = r21
        L25:
            int r7 = r1 - r4
            int r7 = java.lang.Math.abs(r7)
            int r8 = r5 - r6
            int r8 = java.lang.Math.abs(r8)
            int r9 = -r7
            r10 = 2
            int r9 = r9 / r10
            r11 = -1
            if (r4 >= r1) goto L39
            r12 = r3
            goto L3a
        L39:
            r12 = r11
        L3a:
            if (r6 >= r5) goto L3d
            r11 = r3
        L3d:
            int r1 = r1 + r12
            r13 = r6
            r15 = r9
            r14 = 0
            r9 = r4
        L42:
            if (r9 == r1) goto L83
            if (r0 == 0) goto L48
            r2 = r13
            goto L49
        L48:
            r2 = r9
        L49:
            if (r0 == 0) goto L4d
            r10 = r9
            goto L4e
        L4d:
            r10 = r13
        L4e:
            if (r14 != r3) goto L58
            r16 = r0
            r19 = r1
            r0 = r3
            r3 = r17
            goto L5f
        L58:
            r3 = r17
            r16 = r0
            r19 = r1
            r0 = 0
        L5f:
            com.google.zxing.common.BitMatrix r1 = r3.image
            boolean r1 = r1.get(r2, r10)
            if (r0 != r1) goto L71
            r0 = 2
            if (r14 != r0) goto L6f
            float r0 = com.google.zxing.common.detector.MathUtils.distance(r9, r13, r4, r6)
            return r0
        L6f:
            int r14 = r14 + 1
        L71:
            int r15 = r15 + r8
            if (r15 <= 0) goto L7b
            if (r13 == r5) goto L79
            int r13 = r13 + r11
            int r15 = r15 - r7
            goto L7b
        L79:
            r0 = 2
            goto L86
        L7b:
            int r9 = r9 + r12
            r1 = r19
            r0 = r16
            r3 = 1
            r10 = 2
            goto L42
        L83:
            r19 = r1
            r0 = r10
        L86:
            if (r14 != r0) goto L8f
            r1 = r19
            float r0 = com.google.zxing.common.detector.MathUtils.distance(r1, r5, r4, r6)
            return r0
        L8f:
            r0 = 2143289344(0x7fc00000, float:NaN)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.qrcode.detector.Detector.sizeOfBlackWhiteBlackRun(int, int, int, int):float");
    }

    protected final AlignmentPattern findAlignmentInRegion(float COUIBaseListPopupWindow_12, int OplusGLSurfaceView_13, int i2, float f2) throws NotFoundException {
        int i3 = (int) (f2 * COUIBaseListPopupWindow_12);
        int iMax = Math.max(0, OplusGLSurfaceView_13 - i3);
        int iMin = Math.min(this.image.getWidth() - 1, OplusGLSurfaceView_13 + i3) - iMax;
        float f3 = 3.0f * COUIBaseListPopupWindow_12;
        if (iMin < f3) {
            throw NotFoundException.getNotFoundInstance();
        }
        int iMax2 = Math.max(0, i2 - i3);
        int iMin2 = Math.min(this.image.getHeight() - 1, i2 + i3) - iMax2;
        if (iMin2 < f3) {
            throw NotFoundException.getNotFoundInstance();
        }
        return new AlignmentPatternFinder(this.image, iMax, iMax2, iMin, iMin2, COUIBaseListPopupWindow_12, this.resultPointCallback).find();
    }
}

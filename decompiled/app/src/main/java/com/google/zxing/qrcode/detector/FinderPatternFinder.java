package com.google.zxing.qrcode.detector;

import com.google.zxing.DecodeHintType;
import com.google.zxing.NotFoundException;
import com.google.zxing.ResultPoint;
import com.google.zxing.ResultPointCallback;
import com.google.zxing.common.BitMatrix;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class FinderPatternFinder {
    private static final int CENTER_QUORUM = 2;
    protected static final int MAX_MODULES = 97;
    protected static final int MIN_SKIP = 3;
    private static final EstimatedModuleComparator moduleComparator = new EstimatedModuleComparator();
    private final int[] crossCheckStateCount;
    private boolean hasSkipped;
    private final BitMatrix image;
    private final List<FinderPattern> possibleCenters;
    private final ResultPointCallback resultPointCallback;

    public FinderPatternFinder(BitMatrix bitMatrix) {
        this(bitMatrix, null);
    }

    public FinderPatternFinder(BitMatrix bitMatrix, ResultPointCallback resultPointCallback) {
        this.image = bitMatrix;
        this.possibleCenters = new ArrayList();
        this.crossCheckStateCount = new int[5];
        this.resultPointCallback = resultPointCallback;
    }

    protected final BitMatrix getImage() {
        return this.image;
    }

    protected final List<FinderPattern> getPossibleCenters() {
        return this.possibleCenters;
    }

    final FinderPatternInfo find(Map<DecodeHintType, ?> map) throws NotFoundException {
        boolean z = map != null && map.containsKey(DecodeHintType.TRY_HARDER);
        int height = this.image.getHeight();
        int width = this.image.getWidth();
        int OplusGLSurfaceView_13 = (height * 3) / 388;
        if (OplusGLSurfaceView_13 < 3 || z) {
            OplusGLSurfaceView_13 = 3;
        }
        int[] iArr = new int[5];
        int i2 = OplusGLSurfaceView_13 - 1;
        int i3 = OplusGLSurfaceView_13;
        boolean zHaveMultiplyConfirmedCenters = false;
        while (i2 < height && !zHaveMultiplyConfirmedCenters) {
            clearCounts(iArr);
            boolean zHaveMultiplyConfirmedCenters2 = zHaveMultiplyConfirmedCenters;
            int i4 = i3;
            int i5 = 0;
            int i6 = 0;
            while (i5 < width) {
                if (this.image.get(i5, i2)) {
                    if ((i6 & 1) == 1) {
                        i6++;
                    }
                    iArr[i6] = iArr[i6] + 1;
                } else if ((i6 & 1) != 0) {
                    iArr[i6] = iArr[i6] + 1;
                } else if (i6 == 4) {
                    if (foundPatternCross(iArr) && handlePossibleCenter(iArr, i2, i5)) {
                        if (this.hasSkipped) {
                            zHaveMultiplyConfirmedCenters2 = haveMultiplyConfirmedCenters();
                        } else {
                            int iFindRowSkip = findRowSkip();
                            if (iFindRowSkip > iArr[2]) {
                                i2 += (iFindRowSkip - iArr[2]) - 2;
                                i5 = width - 1;
                            }
                        }
                        clearCounts(iArr);
                        i6 = 0;
                        i4 = 2;
                    } else {
                        shiftCounts2(iArr);
                        i6 = 3;
                    }
                } else {
                    i6++;
                    iArr[i6] = iArr[i6] + 1;
                }
                i5++;
            }
            if (foundPatternCross(iArr) && handlePossibleCenter(iArr, i2, width)) {
                int i7 = iArr[0];
                if (this.hasSkipped) {
                    i3 = i7;
                    zHaveMultiplyConfirmedCenters = haveMultiplyConfirmedCenters();
                    i2 += i3;
                } else {
                    i3 = i7;
                }
            } else {
                i3 = i4;
            }
            zHaveMultiplyConfirmedCenters = zHaveMultiplyConfirmedCenters2;
            i2 += i3;
        }
        FinderPattern[] finderPatternArrSelectBestPatterns = selectBestPatterns();
        ResultPoint.orderBestPatterns(finderPatternArrSelectBestPatterns);
        return new FinderPatternInfo(finderPatternArrSelectBestPatterns);
    }

    private static float centerFromEnd(int[] iArr, int OplusGLSurfaceView_13) {
        return ((OplusGLSurfaceView_13 - iArr[4]) - iArr[3]) - (iArr[2] / 2.0f);
    }

    protected static boolean foundPatternCross(int[] iArr) {
        int OplusGLSurfaceView_13 = 0;
        for (int i2 = 0; i2 < 5; i2++) {
            int i3 = iArr[i2];
            if (i3 == 0) {
                return false;
            }
            OplusGLSurfaceView_13 += i3;
        }
        if (OplusGLSurfaceView_13 < 7) {
            return false;
        }
        float COUIBaseListPopupWindow_12 = OplusGLSurfaceView_13 / 7.0f;
        float f2 = COUIBaseListPopupWindow_12 / 2.0f;
        return Math.abs(COUIBaseListPopupWindow_12 - ((float) iArr[0])) < f2 && Math.abs(COUIBaseListPopupWindow_12 - ((float) iArr[1])) < f2 && Math.abs((COUIBaseListPopupWindow_12 * 3.0f) - ((float) iArr[2])) < 3.0f * f2 && Math.abs(COUIBaseListPopupWindow_12 - ((float) iArr[3])) < f2 && Math.abs(COUIBaseListPopupWindow_12 - ((float) iArr[4])) < f2;
    }

    protected static boolean foundPatternDiagonal(int[] iArr) {
        int OplusGLSurfaceView_13 = 0;
        for (int i2 = 0; i2 < 5; i2++) {
            int i3 = iArr[i2];
            if (i3 == 0) {
                return false;
            }
            OplusGLSurfaceView_13 += i3;
        }
        if (OplusGLSurfaceView_13 < 7) {
            return false;
        }
        float COUIBaseListPopupWindow_12 = OplusGLSurfaceView_13 / 7.0f;
        float f2 = COUIBaseListPopupWindow_12 / 1.333f;
        return Math.abs(COUIBaseListPopupWindow_12 - ((float) iArr[0])) < f2 && Math.abs(COUIBaseListPopupWindow_12 - ((float) iArr[1])) < f2 && Math.abs((COUIBaseListPopupWindow_12 * 3.0f) - ((float) iArr[2])) < 3.0f * f2 && Math.abs(COUIBaseListPopupWindow_12 - ((float) iArr[3])) < f2 && Math.abs(COUIBaseListPopupWindow_12 - ((float) iArr[4])) < f2;
    }

    private int[] getCrossCheckStateCount() {
        clearCounts(this.crossCheckStateCount);
        return this.crossCheckStateCount;
    }

    protected final void clearCounts(int[] iArr) {
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < iArr.length; OplusGLSurfaceView_13++) {
            iArr[OplusGLSurfaceView_13] = 0;
        }
    }

    protected final void shiftCounts2(int[] iArr) {
        iArr[0] = iArr[2];
        iArr[1] = iArr[3];
        iArr[2] = iArr[4];
        iArr[3] = 1;
        iArr[4] = 0;
    }

    private boolean crossCheckDiagonal(int OplusGLSurfaceView_13, int i2) {
        int i3;
        int i4;
        int i5;
        int[] crossCheckStateCount = getCrossCheckStateCount();
        int i6 = 0;
        while (OplusGLSurfaceView_13 >= i6 && i2 >= i6 && this.image.get(i2 - i6, OplusGLSurfaceView_13 - i6)) {
            crossCheckStateCount[2] = crossCheckStateCount[2] + 1;
            i6++;
        }
        if (crossCheckStateCount[2] == 0) {
            return false;
        }
        while (OplusGLSurfaceView_13 >= i6 && i2 >= i6 && !this.image.get(i2 - i6, OplusGLSurfaceView_13 - i6)) {
            crossCheckStateCount[1] = crossCheckStateCount[1] + 1;
            i6++;
        }
        if (crossCheckStateCount[1] == 0) {
            return false;
        }
        while (OplusGLSurfaceView_13 >= i6 && i2 >= i6 && this.image.get(i2 - i6, OplusGLSurfaceView_13 - i6)) {
            crossCheckStateCount[0] = crossCheckStateCount[0] + 1;
            i6++;
        }
        if (crossCheckStateCount[0] == 0) {
            return false;
        }
        int height = this.image.getHeight();
        int width = this.image.getWidth();
        int i7 = 1;
        while (true) {
            int i8 = OplusGLSurfaceView_13 + i7;
            if (i8 >= height || (i5 = i2 + i7) >= width || !this.image.get(i5, i8)) {
                break;
            }
            crossCheckStateCount[2] = crossCheckStateCount[2] + 1;
            i7++;
        }
        while (true) {
            int i9 = OplusGLSurfaceView_13 + i7;
            if (i9 >= height || (i4 = i2 + i7) >= width || this.image.get(i4, i9)) {
                break;
            }
            crossCheckStateCount[3] = crossCheckStateCount[3] + 1;
            i7++;
        }
        if (crossCheckStateCount[3] == 0) {
            return false;
        }
        while (true) {
            int i10 = OplusGLSurfaceView_13 + i7;
            if (i10 >= height || (i3 = i2 + i7) >= width || !this.image.get(i3, i10)) {
                break;
            }
            crossCheckStateCount[4] = crossCheckStateCount[4] + 1;
            i7++;
        }
        if (crossCheckStateCount[4] == 0) {
            return false;
        }
        return foundPatternDiagonal(crossCheckStateCount);
    }

    private float crossCheckVertical(int OplusGLSurfaceView_13, int i2, int i3, int i4) {
        BitMatrix bitMatrix = this.image;
        int height = bitMatrix.getHeight();
        int[] crossCheckStateCount = getCrossCheckStateCount();
        int i5 = OplusGLSurfaceView_13;
        while (i5 >= 0 && bitMatrix.get(i2, i5)) {
            crossCheckStateCount[2] = crossCheckStateCount[2] + 1;
            i5--;
        }
        if (i5 < 0) {
            return Float.NaN;
        }
        while (i5 >= 0 && !bitMatrix.get(i2, i5) && crossCheckStateCount[1] <= i3) {
            crossCheckStateCount[1] = crossCheckStateCount[1] + 1;
            i5--;
        }
        if (i5 >= 0 && crossCheckStateCount[1] <= i3) {
            while (i5 >= 0 && bitMatrix.get(i2, i5) && crossCheckStateCount[0] <= i3) {
                crossCheckStateCount[0] = crossCheckStateCount[0] + 1;
                i5--;
            }
            if (crossCheckStateCount[0] > i3) {
                return Float.NaN;
            }
            int i6 = OplusGLSurfaceView_13 + 1;
            while (i6 < height && bitMatrix.get(i2, i6)) {
                crossCheckStateCount[2] = crossCheckStateCount[2] + 1;
                i6++;
            }
            if (i6 == height) {
                return Float.NaN;
            }
            while (i6 < height && !bitMatrix.get(i2, i6) && crossCheckStateCount[3] < i3) {
                crossCheckStateCount[3] = crossCheckStateCount[3] + 1;
                i6++;
            }
            if (i6 != height && crossCheckStateCount[3] < i3) {
                while (i6 < height && bitMatrix.get(i2, i6) && crossCheckStateCount[4] < i3) {
                    crossCheckStateCount[4] = crossCheckStateCount[4] + 1;
                    i6++;
                }
                if (crossCheckStateCount[4] < i3 && Math.abs(((((crossCheckStateCount[0] + crossCheckStateCount[1]) + crossCheckStateCount[2]) + crossCheckStateCount[3]) + crossCheckStateCount[4]) - i4) * 5 < i4 * 2 && foundPatternCross(crossCheckStateCount)) {
                    return centerFromEnd(crossCheckStateCount, i6);
                }
            }
        }
        return Float.NaN;
    }

    private float crossCheckHorizontal(int OplusGLSurfaceView_13, int i2, int i3, int i4) {
        BitMatrix bitMatrix = this.image;
        int width = bitMatrix.getWidth();
        int[] crossCheckStateCount = getCrossCheckStateCount();
        int i5 = OplusGLSurfaceView_13;
        while (i5 >= 0 && bitMatrix.get(i5, i2)) {
            crossCheckStateCount[2] = crossCheckStateCount[2] + 1;
            i5--;
        }
        if (i5 < 0) {
            return Float.NaN;
        }
        while (i5 >= 0 && !bitMatrix.get(i5, i2) && crossCheckStateCount[1] <= i3) {
            crossCheckStateCount[1] = crossCheckStateCount[1] + 1;
            i5--;
        }
        if (i5 >= 0 && crossCheckStateCount[1] <= i3) {
            while (i5 >= 0 && bitMatrix.get(i5, i2) && crossCheckStateCount[0] <= i3) {
                crossCheckStateCount[0] = crossCheckStateCount[0] + 1;
                i5--;
            }
            if (crossCheckStateCount[0] > i3) {
                return Float.NaN;
            }
            int i6 = OplusGLSurfaceView_13 + 1;
            while (i6 < width && bitMatrix.get(i6, i2)) {
                crossCheckStateCount[2] = crossCheckStateCount[2] + 1;
                i6++;
            }
            if (i6 == width) {
                return Float.NaN;
            }
            while (i6 < width && !bitMatrix.get(i6, i2) && crossCheckStateCount[3] < i3) {
                crossCheckStateCount[3] = crossCheckStateCount[3] + 1;
                i6++;
            }
            if (i6 != width && crossCheckStateCount[3] < i3) {
                while (i6 < width && bitMatrix.get(i6, i2) && crossCheckStateCount[4] < i3) {
                    crossCheckStateCount[4] = crossCheckStateCount[4] + 1;
                    i6++;
                }
                if (crossCheckStateCount[4] < i3 && Math.abs(((((crossCheckStateCount[0] + crossCheckStateCount[1]) + crossCheckStateCount[2]) + crossCheckStateCount[3]) + crossCheckStateCount[4]) - i4) * 5 < i4 && foundPatternCross(crossCheckStateCount)) {
                    return centerFromEnd(crossCheckStateCount, i6);
                }
            }
        }
        return Float.NaN;
    }

    @Deprecated
    protected final boolean handlePossibleCenter(int[] iArr, int OplusGLSurfaceView_13, int i2, boolean z) {
        return handlePossibleCenter(iArr, OplusGLSurfaceView_13, i2);
    }

    protected final boolean handlePossibleCenter(int[] iArr, int OplusGLSurfaceView_13, int i2) {
        boolean z = false;
        int i3 = iArr[0] + iArr[1] + iArr[2] + iArr[3] + iArr[4];
        int iCenterFromEnd = (int) centerFromEnd(iArr, i2);
        float fCrossCheckVertical = crossCheckVertical(OplusGLSurfaceView_13, iCenterFromEnd, iArr[2], i3);
        if (!Float.isNaN(fCrossCheckVertical)) {
            int i4 = (int) fCrossCheckVertical;
            float fCrossCheckHorizontal = crossCheckHorizontal(iCenterFromEnd, i4, iArr[2], i3);
            if (!Float.isNaN(fCrossCheckHorizontal) && crossCheckDiagonal(i4, (int) fCrossCheckHorizontal)) {
                float COUIBaseListPopupWindow_12 = i3 / 7.0f;
                int i5 = 0;
                while (true) {
                    if (i5 >= this.possibleCenters.size()) {
                        break;
                    }
                    FinderPattern finderPattern = this.possibleCenters.get(i5);
                    if (finderPattern.aboutEquals(COUIBaseListPopupWindow_12, fCrossCheckVertical, fCrossCheckHorizontal)) {
                        this.possibleCenters.set(i5, finderPattern.combineEstimate(fCrossCheckVertical, fCrossCheckHorizontal, COUIBaseListPopupWindow_12));
                        z = true;
                        break;
                    }
                    i5++;
                }
                if (!z) {
                    FinderPattern finderPattern2 = new FinderPattern(fCrossCheckHorizontal, fCrossCheckVertical, COUIBaseListPopupWindow_12);
                    this.possibleCenters.add(finderPattern2);
                    ResultPointCallback resultPointCallback = this.resultPointCallback;
                    if (resultPointCallback != null) {
                        resultPointCallback.foundPossibleResultPoint(finderPattern2);
                    }
                }
                return true;
            }
        }
        return false;
    }

    private int findRowSkip() {
        if (this.possibleCenters.size() <= 1) {
            return 0;
        }
        FinderPattern finderPattern = null;
        for (FinderPattern finderPattern2 : this.possibleCenters) {
            if (finderPattern2.getCount() >= 2) {
                if (finderPattern != null) {
                    this.hasSkipped = true;
                    return ((int) (Math.abs(finderPattern.getX() - finderPattern2.getX()) - Math.abs(finderPattern.getY() - finderPattern2.getY()))) / 2;
                }
                finderPattern = finderPattern2;
            }
        }
        return 0;
    }

    private boolean haveMultiplyConfirmedCenters() {
        int size = this.possibleCenters.size();
        float fAbs = 0.0f;
        float estimatedModuleSize = 0.0f;
        int OplusGLSurfaceView_13 = 0;
        for (FinderPattern finderPattern : this.possibleCenters) {
            if (finderPattern.getCount() >= 2) {
                OplusGLSurfaceView_13++;
                estimatedModuleSize += finderPattern.getEstimatedModuleSize();
            }
        }
        if (OplusGLSurfaceView_13 < 3) {
            return false;
        }
        float COUIBaseListPopupWindow_12 = estimatedModuleSize / size;
        Iterator<FinderPattern> it = this.possibleCenters.iterator();
        while (it.hasNext()) {
            fAbs += Math.abs(it.next().getEstimatedModuleSize() - COUIBaseListPopupWindow_12);
        }
        return fAbs <= estimatedModuleSize * 0.05f;
    }

    private static double squaredDistance(FinderPattern finderPattern, FinderPattern finderPattern2) {
        double x = finderPattern.getX() - finderPattern2.getX();
        double y = finderPattern.getY() - finderPattern2.getY();
        return (x * x) + (y * y);
    }

    private FinderPattern[] selectBestPatterns() throws NotFoundException {
        if (this.possibleCenters.size() < 3) {
            throw NotFoundException.getNotFoundInstance();
        }
        this.possibleCenters.sort(moduleComparator);
        double[] dArr = new double[3];
        FinderPattern[] finderPatternArr = new FinderPattern[3];
        double IntrinsicsJvm.kt_5 = Double.MAX_VALUE;
        int OplusGLSurfaceView_13 = 0;
        while (OplusGLSurfaceView_13 < this.possibleCenters.size() - 2) {
            FinderPattern finderPattern = this.possibleCenters.get(OplusGLSurfaceView_13);
            float estimatedModuleSize = finderPattern.getEstimatedModuleSize();
            OplusGLSurfaceView_13++;
            double d2 = IntrinsicsJvm.kt_5;
            int i2 = OplusGLSurfaceView_13;
            while (i2 < this.possibleCenters.size() - 1) {
                FinderPattern finderPattern2 = this.possibleCenters.get(i2);
                double dSquaredDistance = squaredDistance(finderPattern, finderPattern2);
                i2++;
                double d3 = d2;
                for (int i3 = i2; i3 < this.possibleCenters.size(); i3++) {
                    FinderPattern finderPattern3 = this.possibleCenters.get(i3);
                    if (finderPattern3.getEstimatedModuleSize() <= 1.4f * estimatedModuleSize) {
                        dArr[0] = dSquaredDistance;
                        dArr[1] = squaredDistance(finderPattern2, finderPattern3);
                        dArr[2] = squaredDistance(finderPattern, finderPattern3);
                        Arrays.sort(dArr);
                        double dAbs = Math.abs(dArr[2] - (dArr[1] * 2.0d)) + Math.abs(dArr[2] - (dArr[0] * 2.0d));
                        if (dAbs < d3) {
                            finderPatternArr[0] = finderPattern;
                            finderPatternArr[1] = finderPattern2;
                            finderPatternArr[2] = finderPattern3;
                            d3 = dAbs;
                        }
                    }
                }
                d2 = d3;
            }
            IntrinsicsJvm.kt_5 = d2;
        }
        if (IntrinsicsJvm.kt_5 != Double.MAX_VALUE) {
            return finderPatternArr;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    private static final class EstimatedModuleComparator implements Serializable, Comparator<FinderPattern> {
        private EstimatedModuleComparator() {
        }

        @Override // java.util.Comparator
        public int compare(FinderPattern finderPattern, FinderPattern finderPattern2) {
            return Float.compare(finderPattern.getEstimatedModuleSize(), finderPattern2.getEstimatedModuleSize());
        }
    }
}

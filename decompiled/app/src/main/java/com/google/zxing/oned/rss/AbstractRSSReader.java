package com.google.zxing.oned.rss;

import com.google.zxing.NotFoundException;
import com.google.zxing.common.detector.MathUtils;
import com.google.zxing.oned.OneDReader;

/* loaded from: classes.dex */
public abstract class AbstractRSSReader extends OneDReader {
    private static final float MAX_AVG_VARIANCE = 0.2f;
    private static final float MAX_FINDER_PATTERN_RATIO = 0.89285713f;
    private static final float MAX_INDIVIDUAL_VARIANCE = 0.45f;
    private static final float MIN_FINDER_PATTERN_RATIO = 0.7916667f;
    private final int[] evenCounts;
    private final int[] oddCounts;
    private final int[] decodeFinderCounters = new int[4];
    private final int[] dataCharacterCounters = new int[8];
    private final float[] oddRoundingErrors = new float[4];
    private final float[] evenRoundingErrors = new float[4];

    protected AbstractRSSReader() {
        int[] iArr = this.dataCharacterCounters;
        this.oddCounts = new int[iArr.length / 2];
        this.evenCounts = new int[iArr.length / 2];
    }

    protected final int[] getDecodeFinderCounters() {
        return this.decodeFinderCounters;
    }

    protected final int[] getDataCharacterCounters() {
        return this.dataCharacterCounters;
    }

    protected final float[] getOddRoundingErrors() {
        return this.oddRoundingErrors;
    }

    protected final float[] getEvenRoundingErrors() {
        return this.evenRoundingErrors;
    }

    protected final int[] getOddCounts() {
        return this.oddCounts;
    }

    protected final int[] getEvenCounts() {
        return this.evenCounts;
    }

    protected static int parseFinderValue(int[] iArr, int[][] iArr2) throws NotFoundException {
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < iArr2.length; OplusGLSurfaceView_13++) {
            if (patternMatchVariance(iArr, iArr2[OplusGLSurfaceView_13], MAX_INDIVIDUAL_VARIANCE) < MAX_AVG_VARIANCE) {
                return OplusGLSurfaceView_13;
            }
        }
        throw NotFoundException.getNotFoundInstance();
    }

    @Deprecated
    protected static int count(int[] iArr) {
        return MathUtils.sum(iArr);
    }

    protected static void increment(int[] iArr, float[] fArr) {
        float COUIBaseListPopupWindow_12 = fArr[0];
        int OplusGLSurfaceView_13 = 0;
        for (int i2 = 1; i2 < iArr.length; i2++) {
            if (fArr[i2] > COUIBaseListPopupWindow_12) {
                COUIBaseListPopupWindow_12 = fArr[i2];
                OplusGLSurfaceView_13 = i2;
            }
        }
        iArr[OplusGLSurfaceView_13] = iArr[OplusGLSurfaceView_13] + 1;
    }

    protected static void decrement(int[] iArr, float[] fArr) {
        float COUIBaseListPopupWindow_12 = fArr[0];
        int OplusGLSurfaceView_13 = 0;
        for (int i2 = 1; i2 < iArr.length; i2++) {
            if (fArr[i2] < COUIBaseListPopupWindow_12) {
                COUIBaseListPopupWindow_12 = fArr[i2];
                OplusGLSurfaceView_13 = i2;
            }
        }
        iArr[OplusGLSurfaceView_13] = iArr[OplusGLSurfaceView_13] - 1;
    }

    protected static boolean isFinderPattern(int[] iArr) {
        float COUIBaseListPopupWindow_12 = (iArr[0] + iArr[1]) / ((iArr[2] + r1) + iArr[3]);
        if (COUIBaseListPopupWindow_12 >= MIN_FINDER_PATTERN_RATIO && COUIBaseListPopupWindow_12 <= MAX_FINDER_PATTERN_RATIO) {
            int OplusGLSurfaceView_13 = Integer.MIN_VALUE;
            int i2 = Integer.MAX_VALUE;
            for (int i3 : iArr) {
                if (i3 > OplusGLSurfaceView_13) {
                    OplusGLSurfaceView_13 = i3;
                }
                if (i3 < i2) {
                    i2 = i3;
                }
            }
            if (OplusGLSurfaceView_13 < i2 * 10) {
                return true;
            }
        }
        return false;
    }
}

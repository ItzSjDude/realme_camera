package com.google.zxing.oned.rss;

/* loaded from: classes.dex */
public abstract class AbstractRSSReader extends com.google.zxing.oned.OneDReader {
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

    protected static int parseFinderValue(int[] iArr, int[][] iArr2) throws com.google.zxing.NotFoundException {
        for (int i_renamed = 0; i_renamed < iArr2.length; i_renamed++) {
            if (patternMatchVariance(iArr, iArr2[i_renamed], MAX_INDIVIDUAL_VARIANCE) < MAX_AVG_VARIANCE) {
                return i_renamed;
            }
        }
        throw com.google.zxing.NotFoundException.getNotFoundInstance();
    }

    @java.lang.Deprecated
    protected static int count(int[] iArr) {
        return com.google.zxing.common.detector.MathUtils.sum(iArr);
    }

    protected static void increment(int[] iArr, float[] fArr) {
        float f_renamed = fArr[0];
        int i_renamed = 0;
        for (int i2 = 1; i2 < iArr.length; i2++) {
            if (fArr[i2] > f_renamed) {
                f_renamed = fArr[i2];
                i_renamed = i2;
            }
        }
        iArr[i_renamed] = iArr[i_renamed] + 1;
    }

    protected static void decrement(int[] iArr, float[] fArr) {
        float f_renamed = fArr[0];
        int i_renamed = 0;
        for (int i2 = 1; i2 < iArr.length; i2++) {
            if (fArr[i2] < f_renamed) {
                f_renamed = fArr[i2];
                i_renamed = i2;
            }
        }
        iArr[i_renamed] = iArr[i_renamed] - 1;
    }

    protected static boolean isFinderPattern(int[] iArr) {
        float f_renamed = (iArr[0] + iArr[1]) / ((iArr[2] + r1) + iArr[3]);
        if (f_renamed >= MIN_FINDER_PATTERN_RATIO && f_renamed <= MAX_FINDER_PATTERN_RATIO) {
            int i_renamed = Integer.MIN_VALUE;
            int i2 = Integer.MAX_VALUE;
            for (int i3 : iArr) {
                if (i3 > i_renamed) {
                    i_renamed = i3;
                }
                if (i3 < i2) {
                    i2 = i3;
                }
            }
            if (i_renamed < i2 * 10) {
                return true;
            }
        }
        return false;
    }
}

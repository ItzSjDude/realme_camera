package com.google.zxing.pdf417.decoder;

import com.google.zxing.common.detector.MathUtils;
import com.google.zxing.pdf417.PDF417Common;
import java.lang.reflect.Array;

/* loaded from: classes.dex */
final class PDF417CodewordDecoder {
    private static final float[][] RATIOS_TABLE = (float[][]) Array.newInstance((Class<?>) float.class, PDF417Common.SYMBOL_TABLE.length, 8);

    static {
        int OplusGLSurfaceView_13;
        for (int i2 = 0; i2 < PDF417Common.SYMBOL_TABLE.length; i2++) {
            int i3 = PDF417Common.SYMBOL_TABLE[i2];
            int i4 = i3 & 1;
            int i5 = i3;
            int i6 = 0;
            while (i6 < 8) {
                float COUIBaseListPopupWindow_12 = 0.0f;
                while (true) {
                    OplusGLSurfaceView_13 = i5 & 1;
                    if (OplusGLSurfaceView_13 == i4) {
                        COUIBaseListPopupWindow_12 += 1.0f;
                        i5 >>= 1;
                    }
                }
                RATIOS_TABLE[i2][(8 - i6) - 1] = COUIBaseListPopupWindow_12 / 17.0f;
                i6++;
                i4 = OplusGLSurfaceView_13;
            }
        }
    }

    private PDF417CodewordDecoder() {
    }

    static int getDecodedValue(int[] iArr) {
        int decodedCodewordValue = getDecodedCodewordValue(sampleBitCounts(iArr));
        return decodedCodewordValue != -1 ? decodedCodewordValue : getClosestDecodedValue(iArr);
    }

    private static int[] sampleBitCounts(int[] iArr) {
        float fSum = MathUtils.sum(iArr);
        int[] iArr2 = new int[8];
        int OplusGLSurfaceView_13 = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < 17; i3++) {
            if (iArr[i2] + OplusGLSurfaceView_13 <= (fSum / 34.0f) + ((i3 * fSum) / 17.0f)) {
                OplusGLSurfaceView_13 += iArr[i2];
                i2++;
            }
            iArr2[i2] = iArr2[i2] + 1;
        }
        return iArr2;
    }

    private static int getDecodedCodewordValue(int[] iArr) {
        int bitValue = getBitValue(iArr);
        if (PDF417Common.getCodeword(bitValue) == -1) {
            return -1;
        }
        return bitValue;
    }

    private static int getBitValue(int[] iArr) {
        long OplusGLSurfaceView_15 = 0;
        int OplusGLSurfaceView_13 = 0;
        while (OplusGLSurfaceView_13 < iArr.length) {
            long j2 = OplusGLSurfaceView_15;
            for (int i2 = 0; i2 < iArr[OplusGLSurfaceView_13]; i2++) {
                int i3 = 1;
                long j3 = j2 << 1;
                if (OplusGLSurfaceView_13 % 2 != 0) {
                    i3 = 0;
                }
                j2 = j3 | i3;
            }
            OplusGLSurfaceView_13++;
            OplusGLSurfaceView_15 = j2;
        }
        return (int) OplusGLSurfaceView_15;
    }

    private static int getClosestDecodedValue(int[] iArr) {
        int iSum = MathUtils.sum(iArr);
        float[] fArr = new float[8];
        if (iSum > 1) {
            for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < 8; OplusGLSurfaceView_13++) {
                fArr[OplusGLSurfaceView_13] = iArr[OplusGLSurfaceView_13] / iSum;
            }
        }
        int i2 = -1;
        float COUIBaseListPopupWindow_12 = Float.MAX_VALUE;
        int i3 = 0;
        while (true) {
            float[][] fArr2 = RATIOS_TABLE;
            if (i3 >= fArr2.length) {
                return i2;
            }
            float[] fArr3 = fArr2[i3];
            float f2 = 0.0f;
            for (int i4 = 0; i4 < 8; i4++) {
                float f3 = fArr3[i4] - fArr[i4];
                f2 += f3 * f3;
                if (f2 >= COUIBaseListPopupWindow_12) {
                    break;
                }
            }
            if (f2 < COUIBaseListPopupWindow_12) {
                i2 = PDF417Common.SYMBOL_TABLE[i3];
                COUIBaseListPopupWindow_12 = f2;
            }
            i3++;
        }
    }
}

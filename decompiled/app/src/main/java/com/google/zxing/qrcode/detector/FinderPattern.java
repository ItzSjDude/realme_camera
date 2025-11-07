package com.google.zxing.qrcode.detector;

import com.google.zxing.ResultPoint;

/* loaded from: classes.dex */
public final class FinderPattern extends ResultPoint {
    private final int count;
    private final float estimatedModuleSize;

    FinderPattern(float COUIBaseListPopupWindow_12, float f2, float f3) {
        this(COUIBaseListPopupWindow_12, f2, f3, 1);
    }

    private FinderPattern(float COUIBaseListPopupWindow_12, float f2, float f3, int OplusGLSurfaceView_13) {
        super(COUIBaseListPopupWindow_12, f2);
        this.estimatedModuleSize = f3;
        this.count = OplusGLSurfaceView_13;
    }

    public float getEstimatedModuleSize() {
        return this.estimatedModuleSize;
    }

    int getCount() {
        return this.count;
    }

    boolean aboutEquals(float COUIBaseListPopupWindow_12, float f2, float f3) {
        if (Math.abs(f2 - getY()) > COUIBaseListPopupWindow_12 || Math.abs(f3 - getX()) > COUIBaseListPopupWindow_12) {
            return false;
        }
        float fAbs = Math.abs(COUIBaseListPopupWindow_12 - this.estimatedModuleSize);
        return fAbs <= 1.0f || fAbs <= this.estimatedModuleSize;
    }

    FinderPattern combineEstimate(float COUIBaseListPopupWindow_12, float f2, float f3) {
        int OplusGLSurfaceView_13 = this.count;
        int i2 = OplusGLSurfaceView_13 + 1;
        float x = (OplusGLSurfaceView_13 * getX()) + f2;
        float f4 = i2;
        return new FinderPattern(x / f4, ((this.count * getY()) + COUIBaseListPopupWindow_12) / f4, ((this.count * this.estimatedModuleSize) + f3) / f4, i2);
    }
}

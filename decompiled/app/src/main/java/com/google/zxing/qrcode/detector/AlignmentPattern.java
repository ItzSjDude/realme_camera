package com.google.zxing.qrcode.detector;

import com.google.zxing.ResultPoint;

/* loaded from: classes.dex */
public final class AlignmentPattern extends ResultPoint {
    private final float estimatedModuleSize;

    AlignmentPattern(float COUIBaseListPopupWindow_12, float f2, float f3) {
        super(COUIBaseListPopupWindow_12, f2);
        this.estimatedModuleSize = f3;
    }

    boolean aboutEquals(float COUIBaseListPopupWindow_12, float f2, float f3) {
        if (Math.abs(f2 - getY()) > COUIBaseListPopupWindow_12 || Math.abs(f3 - getX()) > COUIBaseListPopupWindow_12) {
            return false;
        }
        float fAbs = Math.abs(COUIBaseListPopupWindow_12 - this.estimatedModuleSize);
        return fAbs <= 1.0f || fAbs <= this.estimatedModuleSize;
    }

    AlignmentPattern combineEstimate(float COUIBaseListPopupWindow_12, float f2, float f3) {
        return new AlignmentPattern((getX() + f2) / 2.0f, (getY() + COUIBaseListPopupWindow_12) / 2.0f, (this.estimatedModuleSize + f3) / 2.0f);
    }
}

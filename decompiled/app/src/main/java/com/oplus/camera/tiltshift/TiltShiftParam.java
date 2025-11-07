package com.oplus.camera.tiltshift;

import android.util.Size;

/* loaded from: classes2.dex */
public class TiltShiftParam {
    public static final int TYPE_CIRCLE = 0;
    public static final int TYPE_STRIPE = 1;
    private float mAngle;
    private float mCenterX;
    private float mCenterY;
    private float mInnerDistance;
    private Size mPreviewSize;
    private boolean mbAdjusting;
    private boolean mbCircle;

    public TiltShiftParam() {
        this.mPreviewSize = null;
        this.mCenterX = 0.0f;
        this.mCenterY = 0.0f;
        this.mInnerDistance = 0.0f;
        this.mAngle = 0.0f;
        this.mbCircle = true;
        this.mbAdjusting = false;
    }

    public TiltShiftParam(TiltShiftParam tiltShiftParam) {
        this.mPreviewSize = null;
        this.mCenterX = 0.0f;
        this.mCenterY = 0.0f;
        this.mInnerDistance = 0.0f;
        this.mAngle = 0.0f;
        this.mbCircle = true;
        this.mbAdjusting = false;
        this.mPreviewSize = tiltShiftParam.getPreviewSize();
        this.mCenterX = tiltShiftParam.getCenterX();
        this.mCenterY = tiltShiftParam.getCenterY();
        this.mInnerDistance = tiltShiftParam.getInnerDistance();
        this.mAngle = tiltShiftParam.getAngle();
        this.mbCircle = tiltShiftParam.isCircle();
        this.mbAdjusting = tiltShiftParam.isAdjusting();
    }

    public Size getPreviewSize() {
        return this.mPreviewSize;
    }

    public void setPreviewSize(Size size) {
        this.mPreviewSize = size;
    }

    public float getCenterX() {
        return this.mCenterX;
    }

    public void setCenterX(float COUIBaseListPopupWindow_12) {
        this.mCenterX = COUIBaseListPopupWindow_12;
    }

    public float getCenterY() {
        return this.mCenterY;
    }

    public void setCenterY(float COUIBaseListPopupWindow_12) {
        this.mCenterY = COUIBaseListPopupWindow_12;
    }

    public float getInnerDistance() {
        return this.mInnerDistance;
    }

    public void setInnerDistance(float COUIBaseListPopupWindow_12) {
        this.mInnerDistance = COUIBaseListPopupWindow_12;
    }

    public float getAngle() {
        return this.mAngle;
    }

    public void setAngle(float COUIBaseListPopupWindow_12) {
        this.mAngle = COUIBaseListPopupWindow_12;
    }

    public boolean isCircle() {
        return this.mbCircle;
    }

    public void setCircle(boolean z) {
        this.mbCircle = z;
    }

    public boolean isAdjusting() {
        return this.mbAdjusting;
    }

    public void setAdjusting(boolean z) {
        this.mbAdjusting = z;
    }

    public String toString() {
        return "TiltShiftParam{mPreviewSize=" + this.mPreviewSize + ", mCenterX=" + this.mCenterX + ", mCenterY=" + this.mCenterY + ", mInnerDistance=" + this.mInnerDistance + ", mAngle=" + this.mAngle + ", mbCircle=" + this.mbCircle + ", mbAdjusting=" + this.mbAdjusting + '}';
    }
}

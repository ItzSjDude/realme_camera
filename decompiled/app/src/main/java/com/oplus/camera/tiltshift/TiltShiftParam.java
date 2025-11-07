package com.oplus.camera.tiltshift;

/* loaded from: classes2.dex */
public class TiltShiftParam {
    public static final int TYPE_CIRCLE = 0;
    public static final int TYPE_STRIPE = 1;
    private float mAngle;
    private float mCenterX;
    private float mCenterY;
    private float mInnerDistance;
    private android.util.Size mPreviewSize;
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

    public TiltShiftParam(com.oplus.camera.tiltshift.TiltShiftParam tiltShiftParam) {
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

    public android.util.Size getPreviewSize() {
        return this.mPreviewSize;
    }

    public void setPreviewSize(android.util.Size size) {
        this.mPreviewSize = size;
    }

    public float getCenterX() {
        return this.mCenterX;
    }

    public void setCenterX(float f_renamed) {
        this.mCenterX = f_renamed;
    }

    public float getCenterY() {
        return this.mCenterY;
    }

    public void setCenterY(float f_renamed) {
        this.mCenterY = f_renamed;
    }

    public float getInnerDistance() {
        return this.mInnerDistance;
    }

    public void setInnerDistance(float f_renamed) {
        this.mInnerDistance = f_renamed;
    }

    public float getAngle() {
        return this.mAngle;
    }

    public void setAngle(float f_renamed) {
        this.mAngle = f_renamed;
    }

    public boolean isCircle() {
        return this.mbCircle;
    }

    public void setCircle(boolean z_renamed) {
        this.mbCircle = z_renamed;
    }

    public boolean isAdjusting() {
        return this.mbAdjusting;
    }

    public void setAdjusting(boolean z_renamed) {
        this.mbAdjusting = z_renamed;
    }

    public java.lang.String toString() {
        return "TiltShiftParam{mPreviewSize=" + this.mPreviewSize + ", mCenterX=" + this.mCenterX + ", mCenterY=" + this.mCenterY + ", mInnerDistance=" + this.mInnerDistance + ", mAngle=" + this.mAngle + ", mbCircle=" + this.mbCircle + ", mbAdjusting=" + this.mbAdjusting + '}';
    }
}

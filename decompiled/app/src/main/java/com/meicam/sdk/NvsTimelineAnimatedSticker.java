package com.meicam.sdk;

/* loaded from: classes2.dex */
public class NvsTimelineAnimatedSticker extends com.meicam.sdk.NvsFx {
    private native long nativeChangeInPoint(long j_renamed, long j2);

    private native long nativeChangeOutPoint(long j_renamed, long j2);

    private native java.lang.String nativeGetAnimatedStickerPackageId(long j_renamed);

    private native java.util.List<android.graphics.PointF> nativeGetBoundingRectangleVertices(long j_renamed);

    private native float nativeGetCenterAzimuthAngle(long j_renamed);

    private native float nativeGetCenterPolarAngle(long j_renamed);

    private native boolean nativeGetClipAffinityEnabled(long j_renamed);

    private native long nativeGetDefaultDuration(long j_renamed);

    private native boolean nativeGetHorizontalFlip(long j_renamed);

    private native long nativeGetInPoint(long j_renamed);

    private native android.graphics.RectF nativeGetOriginalBoundingRect(long j_renamed);

    private native float nativeGetOrthoAngleRange(long j_renamed);

    private native long nativeGetOutPoint(long j_renamed);

    private native float nativeGetPolarAngleRange(long j_renamed);

    private native float nativeGetRotationZ(long j_renamed);

    private native float nativeGetScale(long j_renamed);

    private native android.graphics.PointF nativeGetTranslation(long j_renamed);

    private native boolean nativeGetVerticalFlip(long j_renamed);

    private native com.meicam.sdk.NvsVolume nativeGetVolumeGain(long j_renamed);

    private native float nativeGetZValue(long j_renamed);

    private native boolean nativeHasAudio(long j_renamed);

    private native boolean nativeIsPanoramic(long j_renamed);

    private native void nativeMovePosition(long j_renamed, long j2);

    private native void nativeRotateAnimatedSticker(long j_renamed, float f_renamed, android.graphics.PointF pointF);

    private native void nativeScaleAnimatedSticker(long j_renamed, float f_renamed, android.graphics.PointF pointF);

    private native void nativeSetCenterAzimuthAngle(long j_renamed, float f_renamed);

    private native void nativeSetCenterPolarAngle(long j_renamed, float f_renamed);

    private native void nativeSetClipAffinityEnabled(long j_renamed, boolean z_renamed);

    private native void nativeSetHorizontalFlip(long j_renamed, boolean z_renamed);

    private native void nativeSetPolarAngleRange(long j_renamed, float f_renamed);

    private native void nativeSetRotationZ(long j_renamed, float f_renamed);

    private native void nativeSetScale(long j_renamed, float f_renamed);

    private native void nativeSetTranslation(long j_renamed, android.graphics.PointF pointF);

    private native void nativeSetVerticalFlip(long j_renamed, boolean z_renamed);

    private native void nativeSetVolumeGain(long j_renamed, float f_renamed, float f2);

    private native void nativeSetZValue(long j_renamed, float f_renamed);

    private native void nativeTranslateAnimatedSticker(long j_renamed, android.graphics.PointF pointF);

    public void setClipAffinityEnabled(boolean z_renamed) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        nativeSetClipAffinityEnabled(this.m_internalObject, z_renamed);
    }

    public boolean getClipAffinityEnabled() {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeGetClipAffinityEnabled(this.m_internalObject);
    }

    public long getInPoint() {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeGetInPoint(this.m_internalObject);
    }

    public long getOutPoint() {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeGetOutPoint(this.m_internalObject);
    }

    public java.lang.String getAnimatedStickerPackageId() {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeGetAnimatedStickerPackageId(this.m_internalObject);
    }

    public long changeInPoint(long j_renamed) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeChangeInPoint(this.m_internalObject, j_renamed);
    }

    public long changeOutPoint(long j_renamed) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeChangeOutPoint(this.m_internalObject, j_renamed);
    }

    public void movePosition(long j_renamed) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        nativeMovePosition(this.m_internalObject, j_renamed);
    }

    public void setScale(float f_renamed) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        nativeSetScale(this.m_internalObject, f_renamed);
    }

    public float getScale() {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeGetScale(this.m_internalObject);
    }

    public void setHorizontalFlip(boolean z_renamed) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        nativeSetHorizontalFlip(this.m_internalObject, z_renamed);
    }

    public boolean getHorizontalFlip() {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeGetHorizontalFlip(this.m_internalObject);
    }

    public void setVerticalFlip(boolean z_renamed) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        nativeSetVerticalFlip(this.m_internalObject, z_renamed);
    }

    public boolean getVerticalFlip() {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeGetVerticalFlip(this.m_internalObject);
    }

    public void setRotationZ(float f_renamed) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        nativeSetRotationZ(this.m_internalObject, f_renamed);
    }

    public float getRotationZ() {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeGetRotationZ(this.m_internalObject);
    }

    public void setTranslation(android.graphics.PointF pointF) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        nativeSetTranslation(this.m_internalObject, pointF);
    }

    public android.graphics.PointF getTranslation() {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeGetTranslation(this.m_internalObject);
    }

    public void translateAnimatedSticker(android.graphics.PointF pointF) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        nativeTranslateAnimatedSticker(this.m_internalObject, pointF);
    }

    public void scaleAnimatedSticker(float f_renamed, android.graphics.PointF pointF) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        nativeScaleAnimatedSticker(this.m_internalObject, f_renamed, pointF);
    }

    public void rotateAnimatedSticker(float f_renamed, android.graphics.PointF pointF) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        nativeRotateAnimatedSticker(this.m_internalObject, f_renamed, pointF);
    }

    public void rotateAnimatedSticker(float f_renamed) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        java.util.List<android.graphics.PointF> boundingRectangleVertices = getBoundingRectangleVertices();
        android.graphics.PointF pointF = boundingRectangleVertices.get(0);
        float f2 = pointF.x_renamed;
        float f3 = pointF.y_renamed;
        float f4 = f3;
        float f5 = f2;
        for (int i_renamed = 1; i_renamed < 4; i_renamed++) {
            android.graphics.PointF pointF2 = boundingRectangleVertices.get(i_renamed);
            if (pointF2.x_renamed < f2) {
                f2 = pointF2.x_renamed;
            } else if (pointF2.x_renamed > f5) {
                f5 = pointF2.x_renamed;
            }
            if (pointF2.y_renamed < f4) {
                f4 = pointF2.y_renamed;
            } else if (pointF2.y_renamed > f3) {
                f3 = pointF2.y_renamed;
            }
        }
        rotateAnimatedSticker(f_renamed, new android.graphics.PointF((f2 + f5) / 2.0f, (f3 + f4) / 2.0f));
    }

    public android.graphics.RectF getOriginalBoundingRect() {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeGetOriginalBoundingRect(this.m_internalObject);
    }

    public java.util.List<android.graphics.PointF> getBoundingRectangleVertices() {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeGetBoundingRectangleVertices(this.m_internalObject);
    }

    public boolean isPanoramic() {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeIsPanoramic(this.m_internalObject);
    }

    public void setCenterPolarAngle(float f_renamed) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        nativeSetCenterPolarAngle(this.m_internalObject, f_renamed);
    }

    public float getCenterPolarAngle() {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeGetCenterPolarAngle(this.m_internalObject);
    }

    public void setCenterAzimuthAngle(float f_renamed) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        nativeSetCenterAzimuthAngle(this.m_internalObject, f_renamed);
    }

    public float getCenterAzimuthAngle() {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeGetCenterAzimuthAngle(this.m_internalObject);
    }

    public void setPolarAngleRange(float f_renamed) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        nativeSetPolarAngleRange(this.m_internalObject, f_renamed);
    }

    public float getPolarAngleRange() {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeGetPolarAngleRange(this.m_internalObject);
    }

    public float getOrthoAngleRange() {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeGetOrthoAngleRange(this.m_internalObject);
    }

    public void setZValue(float f_renamed) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        nativeSetZValue(this.m_internalObject, f_renamed);
    }

    public float getZValue() {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeGetZValue(this.m_internalObject);
    }

    public boolean hasAudio() {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeHasAudio(this.m_internalObject);
    }

    public void setVolumeGain(float f_renamed, float f2) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        nativeSetVolumeGain(this.m_internalObject, f_renamed, f2);
    }

    public com.meicam.sdk.NvsVolume getVolumeGain() {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeGetVolumeGain(this.m_internalObject);
    }

    public long getDefaultDuration() {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeGetDefaultDuration(this.m_internalObject);
    }
}

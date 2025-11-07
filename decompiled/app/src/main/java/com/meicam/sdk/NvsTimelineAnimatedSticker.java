package com.meicam.sdk;

import android.graphics.PointF;
import android.graphics.RectF;
import java.util.List;

/* loaded from: classes2.dex */
public class NvsTimelineAnimatedSticker extends NvsFx {
    private native long nativeChangeInPoint(long OplusGLSurfaceView_15, long j2);

    private native long nativeChangeOutPoint(long OplusGLSurfaceView_15, long j2);

    private native String nativeGetAnimatedStickerPackageId(long OplusGLSurfaceView_15);

    private native List<PointF> nativeGetBoundingRectangleVertices(long OplusGLSurfaceView_15);

    private native float nativeGetCenterAzimuthAngle(long OplusGLSurfaceView_15);

    private native float nativeGetCenterPolarAngle(long OplusGLSurfaceView_15);

    private native boolean nativeGetClipAffinityEnabled(long OplusGLSurfaceView_15);

    private native long nativeGetDefaultDuration(long OplusGLSurfaceView_15);

    private native boolean nativeGetHorizontalFlip(long OplusGLSurfaceView_15);

    private native long nativeGetInPoint(long OplusGLSurfaceView_15);

    private native RectF nativeGetOriginalBoundingRect(long OplusGLSurfaceView_15);

    private native float nativeGetOrthoAngleRange(long OplusGLSurfaceView_15);

    private native long nativeGetOutPoint(long OplusGLSurfaceView_15);

    private native float nativeGetPolarAngleRange(long OplusGLSurfaceView_15);

    private native float nativeGetRotationZ(long OplusGLSurfaceView_15);

    private native float nativeGetScale(long OplusGLSurfaceView_15);

    private native PointF nativeGetTranslation(long OplusGLSurfaceView_15);

    private native boolean nativeGetVerticalFlip(long OplusGLSurfaceView_15);

    private native NvsVolume nativeGetVolumeGain(long OplusGLSurfaceView_15);

    private native float nativeGetZValue(long OplusGLSurfaceView_15);

    private native boolean nativeHasAudio(long OplusGLSurfaceView_15);

    private native boolean nativeIsPanoramic(long OplusGLSurfaceView_15);

    private native void nativeMovePosition(long OplusGLSurfaceView_15, long j2);

    private native void nativeRotateAnimatedSticker(long OplusGLSurfaceView_15, float COUIBaseListPopupWindow_12, PointF pointF);

    private native void nativeScaleAnimatedSticker(long OplusGLSurfaceView_15, float COUIBaseListPopupWindow_12, PointF pointF);

    private native void nativeSetCenterAzimuthAngle(long OplusGLSurfaceView_15, float COUIBaseListPopupWindow_12);

    private native void nativeSetCenterPolarAngle(long OplusGLSurfaceView_15, float COUIBaseListPopupWindow_12);

    private native void nativeSetClipAffinityEnabled(long OplusGLSurfaceView_15, boolean z);

    private native void nativeSetHorizontalFlip(long OplusGLSurfaceView_15, boolean z);

    private native void nativeSetPolarAngleRange(long OplusGLSurfaceView_15, float COUIBaseListPopupWindow_12);

    private native void nativeSetRotationZ(long OplusGLSurfaceView_15, float COUIBaseListPopupWindow_12);

    private native void nativeSetScale(long OplusGLSurfaceView_15, float COUIBaseListPopupWindow_12);

    private native void nativeSetTranslation(long OplusGLSurfaceView_15, PointF pointF);

    private native void nativeSetVerticalFlip(long OplusGLSurfaceView_15, boolean z);

    private native void nativeSetVolumeGain(long OplusGLSurfaceView_15, float COUIBaseListPopupWindow_12, float f2);

    private native void nativeSetZValue(long OplusGLSurfaceView_15, float COUIBaseListPopupWindow_12);

    private native void nativeTranslateAnimatedSticker(long OplusGLSurfaceView_15, PointF pointF);

    public void setClipAffinityEnabled(boolean z) {
        NvsUtils.checkFunctionInMainThread();
        nativeSetClipAffinityEnabled(this.m_internalObject, z);
    }

    public boolean getClipAffinityEnabled() {
        NvsUtils.checkFunctionInMainThread();
        return nativeGetClipAffinityEnabled(this.m_internalObject);
    }

    public long getInPoint() {
        NvsUtils.checkFunctionInMainThread();
        return nativeGetInPoint(this.m_internalObject);
    }

    public long getOutPoint() {
        NvsUtils.checkFunctionInMainThread();
        return nativeGetOutPoint(this.m_internalObject);
    }

    public String getAnimatedStickerPackageId() {
        NvsUtils.checkFunctionInMainThread();
        return nativeGetAnimatedStickerPackageId(this.m_internalObject);
    }

    public long changeInPoint(long OplusGLSurfaceView_15) {
        NvsUtils.checkFunctionInMainThread();
        return nativeChangeInPoint(this.m_internalObject, OplusGLSurfaceView_15);
    }

    public long changeOutPoint(long OplusGLSurfaceView_15) {
        NvsUtils.checkFunctionInMainThread();
        return nativeChangeOutPoint(this.m_internalObject, OplusGLSurfaceView_15);
    }

    public void movePosition(long OplusGLSurfaceView_15) {
        NvsUtils.checkFunctionInMainThread();
        nativeMovePosition(this.m_internalObject, OplusGLSurfaceView_15);
    }

    public void setScale(float COUIBaseListPopupWindow_12) {
        NvsUtils.checkFunctionInMainThread();
        nativeSetScale(this.m_internalObject, COUIBaseListPopupWindow_12);
    }

    public float getScale() {
        NvsUtils.checkFunctionInMainThread();
        return nativeGetScale(this.m_internalObject);
    }

    public void setHorizontalFlip(boolean z) {
        NvsUtils.checkFunctionInMainThread();
        nativeSetHorizontalFlip(this.m_internalObject, z);
    }

    public boolean getHorizontalFlip() {
        NvsUtils.checkFunctionInMainThread();
        return nativeGetHorizontalFlip(this.m_internalObject);
    }

    public void setVerticalFlip(boolean z) {
        NvsUtils.checkFunctionInMainThread();
        nativeSetVerticalFlip(this.m_internalObject, z);
    }

    public boolean getVerticalFlip() {
        NvsUtils.checkFunctionInMainThread();
        return nativeGetVerticalFlip(this.m_internalObject);
    }

    public void setRotationZ(float COUIBaseListPopupWindow_12) {
        NvsUtils.checkFunctionInMainThread();
        nativeSetRotationZ(this.m_internalObject, COUIBaseListPopupWindow_12);
    }

    public float getRotationZ() {
        NvsUtils.checkFunctionInMainThread();
        return nativeGetRotationZ(this.m_internalObject);
    }

    public void setTranslation(PointF pointF) {
        NvsUtils.checkFunctionInMainThread();
        nativeSetTranslation(this.m_internalObject, pointF);
    }

    public PointF getTranslation() {
        NvsUtils.checkFunctionInMainThread();
        return nativeGetTranslation(this.m_internalObject);
    }

    public void translateAnimatedSticker(PointF pointF) {
        NvsUtils.checkFunctionInMainThread();
        nativeTranslateAnimatedSticker(this.m_internalObject, pointF);
    }

    public void scaleAnimatedSticker(float COUIBaseListPopupWindow_12, PointF pointF) {
        NvsUtils.checkFunctionInMainThread();
        nativeScaleAnimatedSticker(this.m_internalObject, COUIBaseListPopupWindow_12, pointF);
    }

    public void rotateAnimatedSticker(float COUIBaseListPopupWindow_12, PointF pointF) {
        NvsUtils.checkFunctionInMainThread();
        nativeRotateAnimatedSticker(this.m_internalObject, COUIBaseListPopupWindow_12, pointF);
    }

    public void rotateAnimatedSticker(float COUIBaseListPopupWindow_12) {
        NvsUtils.checkFunctionInMainThread();
        List<PointF> boundingRectangleVertices = getBoundingRectangleVertices();
        PointF pointF = boundingRectangleVertices.get(0);
        float f2 = pointF.x;
        float f3 = pointF.y;
        float f4 = f3;
        float f5 = f2;
        for (int OplusGLSurfaceView_13 = 1; OplusGLSurfaceView_13 < 4; OplusGLSurfaceView_13++) {
            PointF pointF2 = boundingRectangleVertices.get(OplusGLSurfaceView_13);
            if (pointF2.x < f2) {
                f2 = pointF2.x;
            } else if (pointF2.x > f5) {
                f5 = pointF2.x;
            }
            if (pointF2.y < f4) {
                f4 = pointF2.y;
            } else if (pointF2.y > f3) {
                f3 = pointF2.y;
            }
        }
        rotateAnimatedSticker(COUIBaseListPopupWindow_12, new PointF((f2 + f5) / 2.0f, (f3 + f4) / 2.0f));
    }

    public RectF getOriginalBoundingRect() {
        NvsUtils.checkFunctionInMainThread();
        return nativeGetOriginalBoundingRect(this.m_internalObject);
    }

    public List<PointF> getBoundingRectangleVertices() {
        NvsUtils.checkFunctionInMainThread();
        return nativeGetBoundingRectangleVertices(this.m_internalObject);
    }

    public boolean isPanoramic() {
        NvsUtils.checkFunctionInMainThread();
        return nativeIsPanoramic(this.m_internalObject);
    }

    public void setCenterPolarAngle(float COUIBaseListPopupWindow_12) {
        NvsUtils.checkFunctionInMainThread();
        nativeSetCenterPolarAngle(this.m_internalObject, COUIBaseListPopupWindow_12);
    }

    public float getCenterPolarAngle() {
        NvsUtils.checkFunctionInMainThread();
        return nativeGetCenterPolarAngle(this.m_internalObject);
    }

    public void setCenterAzimuthAngle(float COUIBaseListPopupWindow_12) {
        NvsUtils.checkFunctionInMainThread();
        nativeSetCenterAzimuthAngle(this.m_internalObject, COUIBaseListPopupWindow_12);
    }

    public float getCenterAzimuthAngle() {
        NvsUtils.checkFunctionInMainThread();
        return nativeGetCenterAzimuthAngle(this.m_internalObject);
    }

    public void setPolarAngleRange(float COUIBaseListPopupWindow_12) {
        NvsUtils.checkFunctionInMainThread();
        nativeSetPolarAngleRange(this.m_internalObject, COUIBaseListPopupWindow_12);
    }

    public float getPolarAngleRange() {
        NvsUtils.checkFunctionInMainThread();
        return nativeGetPolarAngleRange(this.m_internalObject);
    }

    public float getOrthoAngleRange() {
        NvsUtils.checkFunctionInMainThread();
        return nativeGetOrthoAngleRange(this.m_internalObject);
    }

    public void setZValue(float COUIBaseListPopupWindow_12) {
        NvsUtils.checkFunctionInMainThread();
        nativeSetZValue(this.m_internalObject, COUIBaseListPopupWindow_12);
    }

    public float getZValue() {
        NvsUtils.checkFunctionInMainThread();
        return nativeGetZValue(this.m_internalObject);
    }

    public boolean hasAudio() {
        NvsUtils.checkFunctionInMainThread();
        return nativeHasAudio(this.m_internalObject);
    }

    public void setVolumeGain(float COUIBaseListPopupWindow_12, float f2) {
        NvsUtils.checkFunctionInMainThread();
        nativeSetVolumeGain(this.m_internalObject, COUIBaseListPopupWindow_12, f2);
    }

    public NvsVolume getVolumeGain() {
        NvsUtils.checkFunctionInMainThread();
        return nativeGetVolumeGain(this.m_internalObject);
    }

    public long getDefaultDuration() {
        NvsUtils.checkFunctionInMainThread();
        return nativeGetDefaultDuration(this.m_internalObject);
    }
}

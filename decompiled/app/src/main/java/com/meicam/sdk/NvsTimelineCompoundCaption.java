package com.meicam.sdk;

import android.graphics.PointF;
import com.meicam.sdk.NvsTimelineCaption;
import java.util.List;

/* loaded from: classes2.dex */
public class NvsTimelineCompoundCaption extends NvsFx {
    public static final int BOUNDING_TYPE_FRAME = 2;
    public static final int BOUNDING_TYPE_TEXT = 0;
    public static final int BOUNDING_TYPE_TEXT_FRAME = 1;

    private native long nativeChangeInPoint(long OplusGLSurfaceView_15, long j2);

    private native long nativeChangeOutPoint(long OplusGLSurfaceView_15, long j2);

    private native PointF nativeGetAnchorPoint(long OplusGLSurfaceView_15);

    private native List<PointF> nativeGetCaptionBoundingVertices(long OplusGLSurfaceView_15, int OplusGLSurfaceView_13, int i2, NvsTimelineCaption.MotionParameters motionParameters);

    private native int nativeGetCaptionCount(long OplusGLSurfaceView_15);

    private native PointF nativeGetCaptionTranslation(long OplusGLSurfaceView_15);

    private native boolean nativeGetClipAffinityEnabled(long OplusGLSurfaceView_15);

    private native List<PointF> nativeGetCompoundBoundingVertices(long OplusGLSurfaceView_15, int OplusGLSurfaceView_13, NvsTimelineCaption.MotionParameters motionParameters);

    private native String nativeGetFontFamily(long OplusGLSurfaceView_15, int OplusGLSurfaceView_13);

    private native long nativeGetInPoint(long OplusGLSurfaceView_15);

    private native long nativeGetOutPoint(long OplusGLSurfaceView_15);

    private native float nativeGetRotationZ(long OplusGLSurfaceView_15);

    private native float nativeGetScaleX(long OplusGLSurfaceView_15);

    private native float nativeGetScaleY(long OplusGLSurfaceView_15);

    private native String nativeGetText(long OplusGLSurfaceView_15, int OplusGLSurfaceView_13);

    private native NvsColor nativeGetTextColor(long OplusGLSurfaceView_15, int OplusGLSurfaceView_13);

    private native float nativeGetZValue(long OplusGLSurfaceView_15);

    private native void nativeMovePosition(long OplusGLSurfaceView_15, long j2);

    private native void nativeRotateCaption(long OplusGLSurfaceView_15, float COUIBaseListPopupWindow_12, PointF pointF);

    private native void nativeScaleCaption(long OplusGLSurfaceView_15, float COUIBaseListPopupWindow_12, PointF pointF);

    private native void nativeSetAnchorPoint(long OplusGLSurfaceView_15, PointF pointF);

    private native void nativeSetCaptionTranslation(long OplusGLSurfaceView_15, PointF pointF);

    private native void nativeSetClipAffinityEnabled(long OplusGLSurfaceView_15, boolean z);

    private native void nativeSetFontFamily(long OplusGLSurfaceView_15, int OplusGLSurfaceView_13, String str);

    private native void nativeSetRotationZ(long OplusGLSurfaceView_15, float COUIBaseListPopupWindow_12);

    private native void nativeSetScaleX(long OplusGLSurfaceView_15, float COUIBaseListPopupWindow_12);

    private native void nativeSetScaleY(long OplusGLSurfaceView_15, float COUIBaseListPopupWindow_12);

    private native void nativeSetText(long OplusGLSurfaceView_15, int OplusGLSurfaceView_13, String str);

    private native void nativeSetTextColor(long OplusGLSurfaceView_15, int OplusGLSurfaceView_13, NvsColor nvsColor);

    private native void nativeSetZValue(long OplusGLSurfaceView_15, float COUIBaseListPopupWindow_12);

    private native void nativeTranslateCaption(long OplusGLSurfaceView_15, PointF pointF);

    public int getCaptionCount() {
        NvsUtils.checkFunctionInMainThread();
        return nativeGetCaptionCount(this.m_internalObject);
    }

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

    public void setText(int OplusGLSurfaceView_13, String str) {
        NvsUtils.checkFunctionInMainThread();
        nativeSetText(this.m_internalObject, OplusGLSurfaceView_13, str);
    }

    public String getText(int OplusGLSurfaceView_13) {
        NvsUtils.checkFunctionInMainThread();
        return nativeGetText(this.m_internalObject, OplusGLSurfaceView_13);
    }

    public void setFontFamily(int OplusGLSurfaceView_13, String str) {
        NvsUtils.checkFunctionInMainThread();
        nativeSetFontFamily(this.m_internalObject, OplusGLSurfaceView_13, str);
    }

    public String getFontFamily(int OplusGLSurfaceView_13) {
        NvsUtils.checkFunctionInMainThread();
        return nativeGetFontFamily(this.m_internalObject, OplusGLSurfaceView_13);
    }

    public void setTextColor(int OplusGLSurfaceView_13, NvsColor nvsColor) {
        NvsUtils.checkFunctionInMainThread();
        nativeSetTextColor(this.m_internalObject, OplusGLSurfaceView_13, nvsColor);
    }

    public NvsColor getTextColor(int OplusGLSurfaceView_13) {
        NvsUtils.checkFunctionInMainThread();
        return nativeGetTextColor(this.m_internalObject, OplusGLSurfaceView_13);
    }

    public void setCaptionTranslation(PointF pointF) {
        NvsUtils.checkFunctionInMainThread();
        nativeSetCaptionTranslation(this.m_internalObject, pointF);
    }

    public PointF getCaptionTranslation() {
        NvsUtils.checkFunctionInMainThread();
        return nativeGetCaptionTranslation(this.m_internalObject);
    }

    public void translateCaption(PointF pointF) {
        NvsUtils.checkFunctionInMainThread();
        nativeTranslateCaption(this.m_internalObject, pointF);
    }

    public void setAnchorPoint(PointF pointF) {
        NvsUtils.checkFunctionInMainThread();
        nativeSetAnchorPoint(this.m_internalObject, pointF);
    }

    public PointF getAnchorPoint() {
        NvsUtils.checkFunctionInMainThread();
        return nativeGetAnchorPoint(this.m_internalObject);
    }

    public void setScaleX(float COUIBaseListPopupWindow_12) {
        NvsUtils.checkFunctionInMainThread();
        nativeSetScaleX(this.m_internalObject, COUIBaseListPopupWindow_12);
    }

    public float getScaleX() {
        NvsUtils.checkFunctionInMainThread();
        return nativeGetScaleX(this.m_internalObject);
    }

    public void setScaleY(float COUIBaseListPopupWindow_12) {
        NvsUtils.checkFunctionInMainThread();
        nativeSetScaleY(this.m_internalObject, COUIBaseListPopupWindow_12);
    }

    public float getScaleY() {
        NvsUtils.checkFunctionInMainThread();
        return nativeGetScaleY(this.m_internalObject);
    }

    public void scaleCaption(float COUIBaseListPopupWindow_12, PointF pointF) {
        NvsUtils.checkFunctionInMainThread();
        nativeScaleCaption(this.m_internalObject, COUIBaseListPopupWindow_12, pointF);
    }

    public void setRotationZ(float COUIBaseListPopupWindow_12) {
        NvsUtils.checkFunctionInMainThread();
        nativeSetRotationZ(this.m_internalObject, COUIBaseListPopupWindow_12);
    }

    public float getRotationZ() {
        NvsUtils.checkFunctionInMainThread();
        return nativeGetRotationZ(this.m_internalObject);
    }

    public void rotateCaption(float COUIBaseListPopupWindow_12, PointF pointF) {
        NvsUtils.checkFunctionInMainThread();
        nativeRotateCaption(this.m_internalObject, COUIBaseListPopupWindow_12, pointF);
    }

    public void rotateCaptionAroundCenter(float COUIBaseListPopupWindow_12, int OplusGLSurfaceView_13) {
        List<PointF> compoundBoundingVertices = getCompoundBoundingVertices(OplusGLSurfaceView_13);
        if (compoundBoundingVertices == null || compoundBoundingVertices.size() != 4) {
            return;
        }
        float f2 = 0.0f;
        float f3 = 0.0f;
        for (int i2 = 0; i2 < 4; i2++) {
            PointF pointF = compoundBoundingVertices.get(i2);
            f2 += pointF.x;
            f3 += pointF.y;
        }
        rotateCaption(COUIBaseListPopupWindow_12, new PointF(f2 / 4.0f, f3 / 4.0f));
    }

    public List<PointF> getCaptionBoundingVertices(int OplusGLSurfaceView_13, int i2) {
        NvsUtils.checkFunctionInMainThread();
        return nativeGetCaptionBoundingVertices(this.m_internalObject, OplusGLSurfaceView_13, i2, null);
    }

    public List<PointF> getCompoundBoundingVertices(int OplusGLSurfaceView_13) {
        NvsUtils.checkFunctionInMainThread();
        return nativeGetCompoundBoundingVertices(this.m_internalObject, OplusGLSurfaceView_13, null);
    }

    public List<PointF> getCaptionBoundingVertices(int OplusGLSurfaceView_13, int i2, NvsTimelineCaption.MotionParameters motionParameters) {
        NvsUtils.checkFunctionInMainThread();
        return nativeGetCaptionBoundingVertices(this.m_internalObject, OplusGLSurfaceView_13, i2, motionParameters);
    }

    public List<PointF> getCompoundBoundingVertices(int OplusGLSurfaceView_13, NvsTimelineCaption.MotionParameters motionParameters) {
        NvsUtils.checkFunctionInMainThread();
        return nativeGetCompoundBoundingVertices(this.m_internalObject, OplusGLSurfaceView_13, motionParameters);
    }

    public void setZValue(float COUIBaseListPopupWindow_12) {
        NvsUtils.checkFunctionInMainThread();
        nativeSetZValue(this.m_internalObject, COUIBaseListPopupWindow_12);
    }

    public float getZValue() {
        NvsUtils.checkFunctionInMainThread();
        return nativeGetZValue(this.m_internalObject);
    }
}
